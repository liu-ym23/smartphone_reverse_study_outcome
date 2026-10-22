package com.bytedance.android.ec.core.imagex;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.util.LruCache;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.imagex.opt.NetImagePreloaderOpt;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.host.api.core.api.IECImageXService;
import com.bytedance.android.ec.host.api.core.api.ImagePreloadConfig;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.common.utility.Logger;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pitaya.api.PitayaCoreFactory;
import com.bytedance.pitaya.api.feature.IFeatureCore;
import com.bytedance.services.apm.api.EnsureManager;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.BaseRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bN\u0010OJ\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J^\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b`\t2\u001a\u0010\r\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\f\u0018\u00010\u000bH\u0002J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0002J \u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0083\u0001\u0010&\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#H\u0016¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u0017H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J2\u00102\u001a\u00020\u00192\u0006\u0010,\u001a\u00020+2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-2\b\u00100\u001a\u0004\u0018\u00010.2\b\u00101\u001a\u0004\u0018\u00010\bH\u0016Jl\u00106\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020+2\u0010\u00105\u001a\f\u0012\u0006\b\u0000\u0012\u000204\u0018\u0001032\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b`\t2\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016J\u0088\u0001\u00106\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020+2\u0010\u00105\u001a\f\u0012\u0006\b\u0000\u0012\u000204\u0018\u0001032\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b`\t2\b\u0010 \u001a\u0004\u0018\u00010\u00022\u001a\u0010\r\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\f\u0018\u00010\u000bH\u0016JR\u00108\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u0001072\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u001a\u0010\r\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\f\u0018\u00010\u000bH\u0016J£\u0001\u0010;\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020+2\u0010\u00105\u001a\f\u0012\u0006\b\u0000\u0012\u000204\u0018\u0001032\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u00109\u001a\u0004\u0018\u00010#2\b\u0010:\u001a\u0004\u0018\u00010#2\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b`\t2\b\u0010 \u001a\u0004\u0018\u00010\u00022\u001a\u0010\r\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\f\u0018\u00010\u000bH\u0016¢\u0006\u0004\b;\u0010<J]\u0010A\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#2\b\u0010=\u001a\u0004\u0018\u00010\u00122\u0016\u0010@\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010?\u0012\u0004\u0012\u00020\u0019\u0018\u00010>H\u0016¢\u0006\u0004\bA\u0010BJ \u0010C\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010D\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\n\u0010F\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010H\u001a\u00020\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010GH\u0016J\b\u0010I\u001a\u00020\u0019H\u0016J\u0010\u0010K\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\u001eH\u0016J\b\u0010M\u001a\u00020LH\u0016¨\u0006P"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/ECImageXService;", "Lcom/bytedance/android/ec/host/api/core/api/IECImageXService;", "", "bizTag", "sceneTag", "Landroid/graphics/Bitmap$Config;", "bitmapConfig", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "monitor", "Lkotlin/Function0;", "", "monitorInjector", "Lcom/bytedance/android/ec/core/imagex/r;", "createCallerContext", com.bytedance.android.ec.core.event.a.KEY_URL, "context", "Lcom/facebook/imagepipeline/request/Postprocessor;", "createPostProcessor", "Lorg/json/JSONObject;", "configRule", "data", "Lcom/bytedance/android/ec/host/api/core/api/ImagePreloadConfig;", "extras", "", "preloadImages", "imageUrl", "Lcom/facebook/imagepipeline/common/Priority;", "priority", "", "prefetchToMemoryCache", "specifiedDiskCache", "Lcom/facebook/imagepipeline/listener/BaseRequestListener;", "requestListener", "", "resizeWidth", "resizeHeight", "preloadImage", "(Ljava/lang/String;Lcom/facebook/imagepipeline/common/Priority;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;ZLjava/lang/String;Lcom/facebook/imagepipeline/listener/BaseRequestListener;Ljava/lang/Integer;Ljava/lang/Integer;)V", "config", "savePreloadConfig", "urlPreConnect", "Lcom/facebook/drawee/view/GenericDraweeView;", "draweeView", "", "Lcom/facebook/imagepipeline/request/ImageRequest;", "imageRequests", "lowResImageRequest", "callerContext", "bindImageByRequest", "Lcom/facebook/drawee/controller/ControllerListener;", "Lcom/facebook/imagepipeline/image/ImageInfo;", "controllerListener", "bindByImageX", "Lkotlin/Pair;", "prepareImageRequest", "width", "height", "bindImageXWithSize", "(Lcom/facebook/drawee/view/GenericDraweeView;Lcom/facebook/drawee/controller/ControllerListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/HashMap;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Z", "postprocessor", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "consumer", "downloadByImageX", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/facebook/imagepipeline/request/Postprocessor;Lkotlin/jvm/functions/Function1;)Z", "transformImageUrl", "provideImageCallerContext", "Lcom/bytedance/android/ecom/arch/slice/render/elements/asyncimage/a;", "provideSlcImageHook", "Landroid/content/Context;", "saveFirstScreenImageSet", "initFirstScreenImageRecord", "fromCache", "recordFirstScreenEnd", "Lpi/c;", "providerNetImagePreloader", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECImageXService implements IECImageXService {
    public ECImageXService() {
    }

    public void initFirstScreenImageRecord() {
        com.bytedance.android.ec.core.imagex.opt.u.c.getClass();
        if (((Boolean) ImageExperimentsKt.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (com.bytedance.android.ec.core.imagex.opt.u.b == true) goto L9;
        dm.a.a("FristScreenImagePreloadTask").i("initFirstScreenImageRecordSet");
        com.bytedance.android.ec.core.imagex.opt.u.b = true;
        com.bytedance.android.ec.core.imagex.opt.u.a = new LinkedHashSet();
        return;
    }

    public com.bytedance.android.ecom.arch.slice.render.elements.asyncimage.a provideSlcImageHook() {
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.i.getValue()).booleanValue() == true) goto L7;
        return null;
    L7:
        return SlcImageLoaderHookImpl.d;
    }

    public pi.c providerNetImagePreloader() {
        return new NetImagePreloaderOpt();
    }

    /* JADX INFO: renamed from: provideSlcImageHook, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1205provideSlcImageHook() {
        return provideSlcImageHook();
    }

    public void recordFirstScreenEnd(boolean r10) {
        FirstScreenStatistic.S.getClass();
        if (r10 == true) goto L5;
    L7:
        if (r10 == false) goto L9;
    L18:
        if (FirstScreenStatistic.m == true) goto L21;
        return;
    L21:
        if (FirstScreenStatistic.H == true) goto L48;
        dm.a.a("FirstScreenStatistic").a(ThreadMethodProxy.currentThread().getName() + " recordFirstScreenEnd fromCache " + r10);
        if (r10 == true) goto L32;
        Handler r1 = FirstScreenStatistic.I;
        r1.post(o.a);
        if (FirstScreenStatistic.F == true) goto L29;
        FirstScreenStatistic.c = true;
        FirstScreenStatistic.u = true;
        FirstScreenStatistic.H = true;
        FirstScreenStatistic.r();
        FirstScreenStatistic.e();
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new FirstScreenStatistic$recordFirstScreenEnd$2(null), 3, null);
        goto L32
    L29:
        if (FirstScreenStatistic.c == true) goto L32;
        FirstScreenStatistic.c = true;
        JSONObject r11 = new JSONObject();
        r11.put("time", System.currentTimeMillis());
        int r12 = ECMonitorService.b;
        ECMonitorService.a.a("first_screen_end", r11, null, null);
        r1.postDelayed(FirstScreenStatistic$recordFirstScreenEnd$3.a, 3000);
    L32:
        if (FirstScreenStatistic.a == true) goto L49;
        FirstScreenStatistic.a = true;
        FirstScreenStatistic.d = System.currentTimeMillis();
        Iterator<T> r13 = FirstScreenStatistic.h.values().iterator();
    L36:
        if (r13.hasNext() == false) goto L42;
        o0 r14 = (o0) r13.next();
        if (r10 == false) goto L40;
        LoadType r15 = LoadType.FIRST_CACHE;
    L41:
        r14.g = r15;
        goto L36
    L40:
        r15 = LoadType.FIRST_REAL_DATA;
        goto L41
    L42:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new FirstScreenStatistic$recordFirstScreenEnd$5(r10, null), 3, null);
        return;
    L49:
        return;
    L48:
        return;
    L9:
        if (FirstScreenStatistic.u == true) goto L18;
        if (FirstScreenStatistic.F == true) goto L14;
        FirstScreenStatistic.u = true;
    L14:
        if (FirstScreenStatistic.t == true) goto L16;
        Set<String> r16 = FirstScreenStatistic.r;
        r16.addAll(FirstScreenStatistic.D);
        dm.a.a("FirstScreenStatistic").a("realDataLoadUrls " + r16.size() + ' ' + r16.toString());
        goto L18
    L16:
        dm.a.b r17 = dm.a.a("FirstScreenStatistic");
        StringBuilder r18 = new StringBuilder("realDataLoadUrls ");
        Set<String> r19 = FirstScreenStatistic.r;
        r18.append(r19.size());
        r18.append(' ');
        r18.append(r19.toString());
        r17.a(r18.toString());
        goto L18
    L5:
        if (FirstScreenStatistic.t == true) goto L7;
        FirstScreenStatistic.t = true;
        Set<String> r20 = FirstScreenStatistic.s;
        r20.addAll(FirstScreenStatistic.D);
        dm.a.a("FirstScreenStatistic").a("cacheLoadUrls " + r20.size() + ' ' + r20.toString());
        goto L18
    }

    public void saveFirstScreenImageSet(Context r10) {
        com.bytedance.android.ec.core.imagex.opt.u.c.getClass();
        if (r10 == null) goto L38;
        dm.a.b r11 = dm.a.a("FristScreenImagePreloadTask");
        StringBuilder r0 = new StringBuilder("saveLastFirstScreenImageSet, size:");
        Set<com.bytedance.android.ec.core.imagex.opt.o0> r1 = com.bytedance.android.ec.core.imagex.opt.u.a;
        int r12 = -1;
        if (r1 == null) goto L8;
        int r13 = r1.size();
    L9:
        r0.append(r13);
        r11.i(r0.toString());
        if (((Boolean) ImageExperimentsKt.a.getValue()).booleanValue() == false) goto L37;
        Set<com.bytedance.android.ec.core.imagex.opt.o0> r14 = com.bytedance.android.ec.core.imagex.opt.u.a;
        if (r14 != null) goto L14;
    L17:
        boolean r15 = true;
    L18:
        if (r15 == true) goto L39;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L22
        Object r17 = Result.constructor-impl(new Gson().toJson(com.bytedance.android.ec.core.imagex.opt.u.a));     // Catch: Throwable -> L22
    L25:
        if (Result.isFailure-impl(r17) == false) goto L27;
        r17 = null;
    L27:
        String r18 = (String) r17;
        if (r18 == null) goto L30;
        Keva.getRepo("legou_mall_first_screen_image_cache_sp").storeString("last_first_screen_image_set", r18);
    L30:
        int r19 = ECMonitorService.b;
        JSONObject r20 = new JSONObject();
        r20.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, "save");
        Set<com.bytedance.android.ec.core.imagex.opt.o0> r21 = com.bytedance.android.ec.core.imagex.opt.u.a;
        if (r21 == null) goto L33;
        r12 = r21.size();
    L33:
        r20.put("images_size", String.valueOf(r12));
        Unit r22 = Unit.INSTANCE;
        ECMonitorService.a.a("ec_mall_first_screen_image_preload", r20, null, null);
        com.bytedance.android.ec.core.imagex.opt.u.a = null;
        return;
    L22:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L39:
        return;
    L14:
        if (r14.isEmpty() == true) goto L17;
        r15 = false;
        goto L18
    L37:
        return;
    L8:
        r13 = -1;
        goto L9
    }

    public void savePreloadConfig(ImagePreloadConfig r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Map<String, JSONObject> r1 = com.bytedance.android.ec.core.hybrid.utils.c.a;
        Intrinsics.checkNotNullParameter(r10, "config");
        if (r10.getNeedSaveConfig() == false) goto L10;
        int r0 = com.bytedance.forest.utils.h.a;
        if (com.bytedance.forest.utils.h.a(r10.getSaveConfigPageTag()) == false) goto L11;
        JSONObject r11 = r10.getConfigCache();
        if (r11 == null) goto L12;
        Map<String, JSONObject> r12 = com.bytedance.android.ec.core.hybrid.utils.c.a;
        String r13 = r10.getSaveConfigPageTag();
        Intrinsics.checkNotNull(r13);
        r12.put(r13, r11);
        return;
    L12:
        return;
    L11:
        return;
    }

    public void urlPreConnect(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        com.bytedance.android.ec.core.utils.h0.a(r10);
    }

    private final Bitmap.Config bitmapConfig(String r10, String r11) {
        boolean r0 = false;
        if (r10 != null) goto L5;
    L8:
        boolean r12 = true;
    L10:
        if (r12 == true) goto L23;
        if (r11 != null) goto L13;
    L14:
        r0 = true;
    L15:
        if (r0 == true) goto L26;
        Lazy r1 = ImageSettings.a;
        if (((ArrayList) ImageSettings.s.getValue()).contains(r11) == true) goto L20;
        return null;
    L20:
        if (((ArrayList) ImageSettings.r.getValue()).contains(r10) == true) goto L22;
        return null;
    L22:
        return Bitmap.Config.RGB_565;
    L26:
        return null;
    L13:
        if (r11.length() != 0) goto L15;
    L23:
        return null;
    L5:
        if (r10.length() == 0) goto L8;
        r12 = false;
        goto L10
    }

    private final Postprocessor createPostProcessor(String r11, r r12) {
        if (ImageExtensionsKt.e(r11, null) == false) goto L232;
        String r10 = "1";
        if (r11 != null) goto L241;
    L11:
        boolean r13 = true;
    L12:
        if (r13 == true) goto L21;
        Uri r14 = UriProtector.parse(r11);     // Catch: Exception -> L10
        if (r14 == null) goto L21;
        if (r14.isOpaque() == true) goto L21;
        boolean r15 = Intrinsics.areEqual(UriProtector.getQueryParameter(r14, "need_judge_fast_scroll"), "1");     // Catch: Exception -> L10
    L22:
        if (r15 == false) goto L215;
        int r16 = g0.a;
        m0.c("ImageGetScrollKey.getMemoryKVStore");
        if (m0.b() == false) goto L215;
        if (g0.a != (-2)) goto L200;
        int r17 = com.bytedance.android.ec.base.settings.b.a;
        Object r18 = 0;
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L190
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L190
        SDKSettingsCacheManager r20 = SDKSettingsCacheManager.e;     // Catch: Throwable -> L190
        r20.getClass();     // Catch: Throwable -> L81
        Object r21 = SDKSettingsCacheManager.b.get("iesec_mall_xtab_image_sr_type");     // Catch: Throwable -> L81
        if (r21 != null) goto L36;
    L78:
        Object r22 = null;
    L79:
        Object r23 = Result.constructor-impl(r22);     // Catch: Throwable -> L81
    L83:
        Throwable r24 = Result.exceptionOrNull-impl(r23);     // Catch: Throwable -> L190
        if (r24 == null) goto L87;
        EnsureManager.ensureNotReachHere(r24);     // Catch: Throwable -> L190
    L87:
        if (Result.isFailure-impl(r23) == false) goto L90;
        r23 = null;
    L90:
        if ((r23 instanceof Integer) == true) goto L92;
        r23 = null;
    L92:
        Object r25 = (Integer) r23;     // Catch: Throwable -> L190
        if (r25 != null) goto L99;
        r20.getClass();     // Catch: Throwable -> L190
        Object r26 = SDKSettingsCacheManager.a.get("iesec_mall_xtab_image_sr_type");     // Catch: Throwable -> L190
        if ((r26 instanceof Integer) == true) goto L98;
        r26 = null;
    L98:
        r25 = (Integer) r26;     // Catch: Throwable -> L190
    L99:
        if (r25 != null) goto L199;
        int r27 = com.bytedance.android.ec.base.settings.g.a;     // Catch: Throwable -> L190
    L177:
        th = move-exception;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L190
        Object r29 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L190
    L180:
        if (Result.exceptionOrNull-impl(r29) != null) goto L243;
    L187:
        r25 = r29;
    L188:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L190
        SDKSettingsCacheManager.e("iesec_mall_xtab_image_sr_type", r25);     // Catch: Throwable -> L190
        goto L199
    L243:
        r29 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("iesec_mall_xtab_image_sr_type", Integer.class, r18);     // Catch: Throwable -> L184
    L185:
        if (r29 != null) goto L187;
        r25 = r18;
    L184:
        r29 = r18;
        goto L185
    L235:
        SDKSettingsCacheManager.e.getClass();     // Catch: Throwable -> L152
        Object r30 = SDKSettingsCacheManager.b.get("iesec_mall_xtab_image_sr_type");     // Catch: Throwable -> L152
        if (r30 != null) goto L107;
    L149:
        Object r31 = null;
    L150:
        Object r32 = Result.constructor-impl(r31);     // Catch: Throwable -> L152
    L154:
        Throwable r33 = Result.exceptionOrNull-impl(r32);     // Catch: Throwable -> L177
        if (r33 == null) goto L158;
        EnsureManager.ensureNotReachHere(r33);     // Catch: Throwable -> L177
    L158:
        if (Result.isFailure-impl(r32) == false) goto L161;
        r32 = null;
    L161:
        if ((r32 instanceof Integer) == true) goto L163;
        r32 = null;
    L163:
        Integer r34 = (Integer) r32;     // Catch: Throwable -> L177
        if (r34 == null) goto L166;
        r25 = r34;
        goto L188
    L166:
        jj4.b r35 = jj4.b.b;     // Catch: Throwable -> L177
        Object r36 = jj4.a.a("iesec_mall_xtab_image_sr_type", Integer.class, r18, false);     // Catch: Throwable -> L177
        if (r36 != null) goto L170;
        Intrinsics.throwNpe();     // Catch: Throwable -> L177
    L170:
        if ((r36 instanceof Integer) == true) goto L172;
        r36 = null;
    L172:
        Object r37 = (Integer) r36;     // Catch: Throwable -> L177
        if (r37 != null) goto L175;
        r37 = r18;
    L175:
        r29 = Result.constructor-impl(r37);     // Catch: Throwable -> L177
    L107:
        if ((r30 instanceof Integer) == true) goto L109;
        Object r38 = null;
    L110:
        r31 = (Integer) r38;     // Catch: Throwable -> L152
        if (r31 != null) goto L150;
        if ((r30 instanceof Number) == false) goto L137;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L122;
        Float r39 = Float.valueOf(((Number) r30).floatValue());     // Catch: Throwable -> L152
        if ((r39 instanceof Integer) == true) goto L120;
        r39 = null;
    L120:
        r31 = (Integer) r39;     // Catch: Throwable -> L152
        goto L150
    L122:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L128;
        Double r40 = Double.valueOf(((Number) r30).doubleValue());     // Catch: Throwable -> L152
        if ((r40 instanceof Integer) == true) goto L126;
        r40 = null;
    L126:
        r31 = (Integer) r40;     // Catch: Throwable -> L152
        goto L150
    L128:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L131;
        r31 = Integer.valueOf(((Number) r30).intValue());     // Catch: Throwable -> L152
        goto L150
    L131:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L137;
        Long r41 = Long.valueOf(((Number) r30).longValue());     // Catch: Throwable -> L152
        if ((r41 instanceof Integer) == true) goto L135;
        r41 = null;
    L135:
        r31 = (Integer) r41;     // Catch: Throwable -> L152
    L137:
        if ((r30 instanceof JSONObject) == false) goto L139;
    L247:
        Object r42 = SDKSettingsCacheManager.a().fromJson(r30.toString(), Integer.class);     // Catch: Throwable -> L145
        if ((r42 instanceof Integer) == true) goto L143;
        r42 = null;
    L143:
        Object r43 = Result.constructor-impl((Integer) r42);     // Catch: Throwable -> L145
    L147:
        r31 = r43;
        if (Result.isFailure-impl(r31) == false) goto L150;
    L145:
        th = move-exception;
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L152
        r43 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L152
        goto L147
    L139:
        if ((r30 instanceof JSONArray) == false) goto L149;
    L109:
        r38 = r30;
    L152:
        th = move-exception;
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L177
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L177
    L199:
        g0.a = ((Number) r25).intValue();
        goto L200
    L36:
        if ((r21 instanceof Integer) == true) goto L38;
        Object r46 = null;
    L39:
        r22 = (Integer) r46;     // Catch: Throwable -> L81
        if (r22 != null) goto L79;
        if ((r21 instanceof Number) == false) goto L66;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L51;
        Float r47 = Float.valueOf(((Number) r21).floatValue());     // Catch: Throwable -> L81
        if ((r47 instanceof Integer) == true) goto L49;
        r47 = null;
    L49:
        r22 = (Integer) r47;     // Catch: Throwable -> L81
        goto L79
    L51:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L57;
        Double r48 = Double.valueOf(((Number) r21).doubleValue());     // Catch: Throwable -> L81
        if ((r48 instanceof Integer) == true) goto L55;
        r48 = null;
    L55:
        r22 = (Integer) r48;     // Catch: Throwable -> L81
        goto L79
    L57:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L60;
        r22 = Integer.valueOf(((Number) r21).intValue());     // Catch: Throwable -> L81
        goto L79
    L60:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L66;
        Long r49 = Long.valueOf(((Number) r21).longValue());     // Catch: Throwable -> L81
        if ((r49 instanceof Integer) == true) goto L64;
        r49 = null;
    L64:
        r22 = (Integer) r49;     // Catch: Throwable -> L81
    L66:
        if ((r21 instanceof JSONObject) == false) goto L68;
    L239:
        Object r50 = SDKSettingsCacheManager.a().fromJson(r21.toString(), Integer.class);     // Catch: Throwable -> L74
        if ((r50 instanceof Integer) == true) goto L72;
        r50 = null;
    L72:
        Object r51 = Result.constructor-impl((Integer) r50);     // Catch: Throwable -> L74
    L76:
        r22 = r51;
        if (Result.isFailure-impl(r22) == false) goto L79;
    L74:
        th = move-exception;
        Result.Companion r52 = Result.Companion;     // Catch: Throwable -> L81
        r51 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L81
        goto L76
    L68:
        if ((r21 instanceof JSONArray) == false) goto L78;
    L38:
        r46 = r21;
    L81:
        th = move-exception;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L190
        r23 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L190
    L190:
        th = move-exception;
        Result.Companion r54 = Result.Companion;
        Object r55 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r56 = Result.exceptionOrNull-impl(r55);
        if (r56 == null) goto L195;
        EnsureManager.ensureNotReachHere(r56);
    L195:
        if (Result.isFailure-impl(r55) == true) goto L198;
        r18 = r55;
    L198:
        r25 = r18;
    L200:
        String r57 = HybridAppInfoService.p.getAppId();
        if (r57 != null) goto L204;
        r57 = "1128";
    L204:
        if (PitayaCoreFactory.getCore(r57).isReady() == false) goto L215;
        long r58 = System.currentTimeMillis();
        IFeatureCore r59 = j0.a;
        if ((r58 - j0.c) < 500) goto L215;
        if (j0.d == true) goto L213;
        ThreadPoolHelper.c().submit(new e0(r57));
        j0.d = true;
    L213:
        if (j0.b == null) goto L215;
        ThreadPoolHelper.c().submit(f0.a);
    L215:
        if (r15 == false) goto L232;
        int r110 = g0.a;
        if (g0.b != g0.a) goto L232;
        ri.b r111 = com.bytedance.android.ec.sdk.helper.d.b.getIECHostFrescoService();
        if (r111 == null) goto L221;
        r111.b();
    L221:
        if (r12 == null) goto L224;
        r12.f("use_image_sr", "1");
    L224:
        if (g0.b != 0) goto L227;
        r10 = "0";
    L230:
        if (r12 == null) goto L232;
        r12.f("slow_or_fast_enable_sr", r10);
        goto L232
    L227:
        if (g0.b == 1) goto L230;
        r10 = "-1";
    L21:
        r15 = false;
        goto L22
    L241:
        if (r11.length() == 0) goto L11;
        r13 = false;
    L232:
        return null;
    }

    public Object provideImageCallerContext(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "bizTag");
        Intrinsics.checkNotNullParameter(r11, "sceneTag");
        return new r(r10, r11);
    }

    public void preloadImages(JSONObject r17, JSONObject r18, ImagePreloadConfig r19) {
        JSONObject r0 = r17;
        Intrinsics.checkNotNullParameter(r0, "configRule");
        Intrinsics.checkNotNullParameter(r18, "data");
        Intrinsics.checkNotNullParameter(r19, "extras");
        Map<String, JSONObject> r10 = com.bytedance.android.ec.core.hybrid.utils.c.a;
        Intrinsics.checkNotNullParameter(r18, "data");
        Intrinsics.checkNotNullParameter(r19, "extras");
        Map<? extends String, ? extends Object> r11 = r19.getMonitorParams();
        if (r11 == null) goto L6;
        com.bytedance.android.ec.core.hybrid.utils.c.b.putAll(r11);
    L6:
        if (r19.getNeedSaveConfig() == false) goto L12;
        int r12 = com.bytedance.forest.utils.h.a;
        if (com.bytedance.forest.utils.h.a(r19.getSaveConfigPageTag()) == false) goto L12;
        JSONObject r13 = r19.getConfigCache();
        if (r13 == null) goto L12;
        Map<String, JSONObject> r14 = com.bytedance.android.ec.core.hybrid.utils.c.a;
        String r15 = r19.getSaveConfigPageTag();
        Intrinsics.checkNotNull(r15);
        r14.put(r15, r13);
    L12:
        if (r0 != null) goto L19;
        String r16 = r19.getSaveConfigPageTag();
        if (r16 == null) goto L19;
        JSONObject r1 = (JSONObject) ((LinkedHashMap) com.bytedance.android.ec.core.hybrid.utils.c.a).get(r16);
        if (r1 == null) goto L18;
        r0 = r1.optJSONObject(r19.getConfigUrlTag());
        goto L19
    L18:
        r0 = null;
    L19:
        ArrayList r20 = new ArrayList();
        LinkedHashMap r110 = new LinkedHashMap();
        if (r0 == null) goto L22;
        Intrinsics.checkNotNullParameter(r0, "config");
        Intrinsics.checkNotNullParameter(r18, "data");
        Intrinsics.checkNotNullParameter(r20, "urlList");
        Intrinsics.checkNotNullParameter(r110, "waitPreload");
        com.bytedance.android.ec.core.hybrid.utils.c.b(r0, r18, r20, r110);
    L22:
        Logger.d("PreloadImage", "获取url数量为: " + r20.size());
        Iterator r21 = r20.iterator();
    L24:
        if (r21.hasNext() == false) goto L26;
        Logger.d("PreloadImage", "获取url是: " + ((String) r21.next()));
        goto L24
    L26:
        Iterator r22 = r20.iterator();
    L28:
        if (r22.hasNext() == false) goto L30;
        ImageExtensionsKt.A((String) r22.next(), com.bytedance.android.ec.core.hybrid.utils.c.a(r19.getBizTag(), r19.getSceneTag(), com.bytedance.android.ec.core.hybrid.utils.c.b), null, null, r19.getPriority(), null, null, true, null);
        goto L28
    L30:
        Iterator r23 = r110.keySet().iterator();
    L32:
        if (r23.hasNext() == false) goto L34;
        long r24 = ((Number) r23.next()).longValue();
        Schedulers.io().scheduleDirect(new com.bytedance.android.ec.core.hybrid.utils.b(r24, r110, r19), r24, TimeUnit.MILLISECONDS);
        goto L32
    }

    public String transformImageUrl(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "sceneTag");
        Intrinsics.checkNotNullParameter(r12, "bizTag");
        LruCache<String, List<String>> r0 = com.bytedance.android.ec.core.imagex.transform.b.a;
        List r13 = com.bytedance.android.ec.core.imagex.transform.b.f(r10, null, new r(r12, r11));
        if ((!r13.isEmpty()) == false) goto L9;
        String r14 = (String) CollectionsKt.getOrNull(r13, 0);
        if (r14 != null) goto L8;
        return r10;
    L8:
        return r14;
    L9:
        return r10;
    }

    private final r createCallerContext(String r10, String r11, HashMap<String, Object> r12, Function0<? extends Map<String, ? extends Object>> r13) {
        if (r10 == null) goto L11;
        if (r11 == null) goto L11;
        r r0 = new r(r10, r11, r13);
        Iterator<String> r14 = r12.keySet().iterator();
    L7:
        if (r14.hasNext() == false) goto L18;
        String r15 = r14.next();
        Object r16 = r12.get(r15);
        if (r16 == null) goto L7;
        r0.g(r15, r16);
        goto L7
    L18:
        return r0;
    L11:
        return null;
    }

    public void bindImageByRequest(GenericDraweeView r10, List<? extends ImageRequest> r11, ImageRequest r12, Object r13) {
        Intrinsics.checkNotNullParameter(r10, "draweeView");
        Intrinsics.checkNotNullParameter(r11, "imageRequests");
        Object[] r14 = r11.toArray(new ImageRequest[0]);
        if (r14 == null) goto L10;
        ImageRequest[] r15 = (ImageRequest[]) r14;
        if ((r13 instanceof r) == true) goto L7;
        r13 = null;
    L7:
        ImageExtensionsKt.u(r10, r15, r12, (r) r13);
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public Pair<List<ImageRequest>, r> prepareImageRequest(String r10, String r11, String r12, Function0<? extends Map<String, ? extends Object>> r13) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "bizTag");
        Intrinsics.checkNotNullParameter(r12, "sceneTag");
        r r14 = createCallerContext(r11, r12, new HashMap(), r13);
        Postprocessor r15 = createPostProcessor(r10, r14);
        return ImageExtensionsKt.m(CollectionsKt.listOf(r10), -1, -1, r14, r15);
    }

    public boolean bindByImageX(GenericDraweeView r11, ControllerListener<? super ImageInfo> r12, String r13, String r14, String r15, HashMap<String, Object> r16, String r17) {
        Intrinsics.checkNotNullParameter(r11, "draweeView");
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r16, "monitor");
        return bindByImageX(r11, r12, r13, r14, r15, r16, r17, null);
    }

    public boolean downloadByImageX(String r10, String r11, String r12, Integer r13, Integer r14, Postprocessor r15, Function1<? super Bitmap, Unit> r16) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r11, "bizTag");
        Intrinsics.checkNotNullParameter(r12, "sceneTag");
        ImageExtensionsKt.f(r10, new r(r11, r12), r13, r14, r15, r16, 96);
        return true;
    }

    public boolean bindByImageX(GenericDraweeView r13, ControllerListener<? super ImageInfo> r14, String r15, String r16, String r17, HashMap<String, Object> r18, String r19, Function0<? extends Map<String, ? extends Object>> r20) {
        Intrinsics.checkNotNullParameter(r13, "draweeView");
        Intrinsics.checkNotNullParameter(r15, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r18, "monitor");
        return bindImageXWithSize(r13, r14, r15, r16, r17, -1, -1, r18, r19, r20);
    }

    public boolean bindImageXWithSize(GenericDraweeView r15, ControllerListener<? super ImageInfo> r16, String r17, String r18, String r19, Integer r20, Integer r21, HashMap<String, Object> r22, String r23, Function0<? extends Map<String, ? extends Object>> r24) {
        Intrinsics.checkNotNullParameter(r15, "draweeView");
        Intrinsics.checkNotNullParameter(r17, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r22, "monitor");
        r r10 = createCallerContext(r18, r19, r22, r24);
        Postprocessor r11 = createPostProcessor(r17, r10);
        ImageExtensionsKt.s(r15, r17, null, r10, r20, r21, bitmapConfig(r18, r19), r11, r16, true, null, null, r23);
        return true;
    }

    public void preloadImage(String r16, Priority r17, String r18, String r19, HashMap<String, Object> r20, boolean r21, String r22, BaseRequestListener r23, Integer r24, Integer r25) {
        Intrinsics.checkNotNullParameter(r16, "imageUrl");
        Intrinsics.checkNotNullParameter(r17, "priority");
        Intrinsics.checkNotNullParameter(r18, "bizTag");
        Intrinsics.checkNotNullParameter(r19, "sceneTag");
        Intrinsics.checkNotNullParameter(r20, "monitor");
        r r10 = new r(r18, r19);
        Iterator<T> r11 = r20.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        String r12 = (String) r11.next();
        Object r13 = r20.get(r12);
        if (r13 == null) goto L4;
        r10.g(r12, r13);
        goto L4
    L8:
        ImageExtensionsKt.z(r16, r10, r24, r25, bitmapConfig(r18, r19), r17, r23, null, r21, r22);
    }
}
