package com.bytedance.android.ec.core.imagex;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.android.ec.core.imagex.common.AsyncWorker;
import com.bytedance.android.ec.core.imagex.common.ECImageX;
import com.bytedance.android.ec.core.imagex.common.ProxyRequestListener;
import com.bytedance.android.ec.core.imagex.opt.AsyncLoadImage;
import com.bytedance.android.ec.core.imagex.opt.AsyncPrefetchImage;
import com.bytedance.android.ec.core.imagex.opt.DomainPreConnect;
import com.bytedance.android.ec.core.imagex.opt.ECImageMultiSizeReuseOpt;
import com.bytedance.android.ec.core.imagex.opt.ImageNetworkPriorityOpt;
import com.bytedance.android.ec.core.imagex.tmplConv.TmplConvConfig;
import com.bytedance.android.ec.hybrid.ui.ECImageCustomDiskCacheHelper;
import com.bytedance.android.ec.model.ECImageLoadConfig;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeBitmapConfigStrategy;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.ObservableEmitter;
import io.reactivex.disposables.Disposable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ImageExtensionsKt {
    public static final /* synthetic */ KProperty[] a = null;
    public static final a b = null;
    public static final List<String> c = null;
    public static final Lazy d = null;

    public static final class a implements ReadOnlyProperty<Object, cj.b> {
        public cj.b a;

        public a() {
        }

        public final cj.b getValue(Object r10, KProperty<?> r11) {
            Intrinsics.checkNotNullParameter(r11, "property");
            cj.b r12 = this.a;
            if (r12 == null) goto L5;
            return r12;
        L5:
            int r13 = ECSdk.a;
            cj.b r14 = (cj.b) ECSdk.a(cj.b.class);
            if (r14 == null) goto L11;
            if (StringsKt.contains$default(r14.getClass().getSimpleName(), "DefaultImpl_", false, 2, null) == true) goto L12;
            this.a = r14;
            return r14;
        L12:
            return r14;
        L11:
            return null;
        }
    }

    static {
        a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(ImageExtensionsKt.class, "shoppingPerfOptService", "getShoppingPerfOptService()Lcom/bytedance/android/ec/host/api/opt/IShoppingPerfOptService;", 1))};
        b = new a();
        c = CollectionsKt.emptyList();
        d = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, ImageExtensionsKt$imageHandler$2.INSTANCE);
    }

    public static final r0 l() {
        return (r0) d.getValue();
    }

    public static final Uri c(String r10) {
        Uri r11 = UriProtector.parse(r10);
        Intrinsics.checkNotNullParameter(r11, "uri");
        if (((Boolean) ImageSettings.q.getValue()).booleanValue() == true) goto L5;
        return r11;
    L5:
        if (Intrinsics.areEqual(r11.getScheme(), "http") == true) goto L7;
        return r11;
    L7:
        if (r11.isHierarchical() == true) goto L9;
        return r11;
    L9:
        return r11.buildUpon().scheme("https").build();
    }

    public static final ImageRequest h(ImageRequest[] r10) {
        if (r10 == null) goto L10;
        int r1 = r10.length;
        int r11 = 0;
    L5:
        if (r11 >= r1) goto L14;
        ImageRequest r12 = r10[r11];
        if (q(r12) == true) goto L13;
        r11 = r11 + 1;
        goto L5
    L13:
        return r12;
    L14:
        return null;
    L10:
        return null;
    }

    public static final r j(View r10) {
        Intrinsics.checkNotNullParameter(r10, "genericDraweeView");
        Object r0 = r10.getTag(2131370760);
        if ((r0 instanceof r) == true) goto L5;
        r0 = null;
    L5:
        r r1 = (r) r0;
        if (r1 != null) goto L12;
        Context r11 = r10.getContext();
        r r12 = t.a;
        Intrinsics.checkNotNullParameter(r11, "context");
        Map<String, r> r13 = t.b;
        Activity r14 = com.bytedance.android.ec.core.utils.l0.b(r11);
        if (r14 == null) goto L10;
        r11 = r14;
    L10:
        ConcurrentHashMap r15 = (ConcurrentHashMap) r13;
        return (r) r15.get(String.valueOf(r11.hashCode()));
    L12:
        return r1;
    }

    public static final boolean q(ImageRequest r10) {
        if (r10 == null) goto L15;
        ImageRequest.RequestLevel r11 = r10.getLowestPermittedRequestLevel();
        if (r11 != null) goto L7;
    L10:
        boolean r12 = true;
    L11:
        if (r12 == true) goto L16;
        return false;
    L16:
        return true;
    L7:
        if (r11 == ImageRequest.RequestLevel.FULL_FETCH) goto L10;
        r12 = false;
        goto L11
    L15:
        return true;
    }

    public static final void D(GenericDraweeView r1, r r10) {
        Intrinsics.checkNotNullParameter(r1, "$this$setCallerContext");
        r1.setTag(2131370760, r10);
    }

    public static final boolean e(String r10, r r11) {
        ri.b r0 = com.bytedance.android.ec.sdk.helper.d.b.getIECHostFrescoService();
        if (r0 == null) goto L6;
        r0.d();
    L6:
        if ((!Intrinsics.areEqual(null, Boolean.TRUE)) == false) goto L8;
        return false;
    L8:
        if (r10 != null) goto L51;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == false) goto L16;
        return false;
    L16:
        u r12 = s.a(r11);     // Catch: Exception -> L50
        if (r12 == null) goto L20;
        com.bytedance.android.shopping.api.image.r r13 = r12.z;     // Catch: Exception -> L50
    L22:
        if (r13 == null) goto L37;
        u r14 = s.a(r11);     // Catch: Exception -> L50
        if (r14 == null) goto L35;
        com.bytedance.android.shopping.api.image.r r15 = r14.z;     // Catch: Exception -> L50
        if (r15 == null) goto L35;
        if (Intrinsics.areEqual(r15.getQuery().b("use_image_sr"), "1") == true) goto L30;
    L32:
        boolean r16 = false;
    L33:
        if (r16 != true) goto L35;
        return true;
    L30:
        if (r15.isHierarchical() == false) goto L32;
        r16 = true;
    L35:
        return false;
    L37:
        Lazy r17 = ECImageX.a;     // Catch: Exception -> L50
        if (r10 != null) goto L40;
    L44:
        boolean r18 = false;
    L45:
        if (r18 == true) goto L47;
    L49:
        return false;
    L47:
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(c(r10), "use_image_sr"), "1") == false) goto L49;
        return true;
    L40:
        if (StringsKt.startsWith$default(r10, "https://", false, 2, null) == false) goto L42;
    L43:
        r18 = true;
        goto L45
    L42:
        if (StringsKt.startsWith$default(r10, "http://", false, 2, null) == false) goto L44;
    L20:
        r13 = null;
        goto L22
    L51:
        if (r10.length() == 0) goto L13;
        r1 = false;
        goto L14
    }

    public static final ResizeOptions i(Integer r1, Integer r10) {
        if (r1 != null) goto L4;
    L9:
        return null;
    L4:
        if (r1.intValue() <= 0) goto L9;
        if (r10 == null) goto L9;
        if (r10.intValue() <= 0) goto L9;
        return new ResizeOptions(r1.intValue(), r10.intValue());
    }

    public static u k(View r10, r r11) {
        Context r0 = null;
        if (r11 != null) goto L13;
        if (r10 == null) goto L7;
        r11 = j(r10);
        if (r11 != null) goto L13;
    L7:
        if (r10 == null) goto L10;
        Context r12 = r10.getContext();
        if (r12 == null) goto L10;
    L11:
        r11 = t.a(r12);
    L10:
        r12 = null;
    L13:
        if (r11 != null) goto L15;
        r11 = new r("", "");
    L15:
        u r1 = new u(r11);
        if (r10 == null) goto L21;
        Context r13 = r10.getContext();
        if (r13 == null) goto L21;
        r0 = r13;
    L21:
        r1.A(r0);
        if (r10 == null) goto L24;
        r1.D(r10);
    L24:
        return r1;
    }

    public static ImageRequest G(String r12, r r13, final Boolean r14) {
        final ResizeOptions r10 = null;
        final Bitmap.Config r11 = null;
        final Postprocessor r15 = null;
        final Priority r16 = null;
        final String r17 = null;
        final RequestListener r18 = null;
        Intrinsics.checkNotNullParameter(r12, "$this$toImageRequestOrNull");
        if ((r13 instanceof u) == true) goto L5;
        r r0 = null;
    L6:
        u r1 = (u) r0;
        if (r1 != null) goto L9;
        u r19 = k(null, r13);
    L10:
        final u r20 = r19;
        final Function1<String, ImageRequest> r110 = new ImageExtensionsKt$toImageRequestOrNull$urlToImageRequest$1(r20, r10, r11, r15, r16, r17, r18, r14);
        List r111 = n0.a(l(), CollectionsKt.listOf(r12), null, r19, null, false, 56);
        Function1<String, ImageRequest> r112 = new ImageExtensionsKt$toImageRequestOrNull$1(r110);
        Intrinsics.checkNotNullParameter(r112, "block");
        if (r111 == null) goto L30;
        Iterator r113 = r111.iterator();
    L15:
        if (r113.hasNext() == false) goto L31;
        ImageRequest r114 = (ImageRequest) r112.invoke((String) r113.next());
        if (r114 != null) goto L19;
    L21:
        r114 = null;
    L22:
        if (r114 == null) goto L15;
        return r114;
    L19:
        if (q(r114) == false) goto L21;
    L31:
        return null;
    L30:
        return null;
    L9:
        r19 = r1;
        goto L10
    L5:
        r0 = r13;
        goto L6
    }

    public static final Pair<ImageRequest[], ImageRequest> J(final r r19, ImageRequest[] r20, ImageRequest r21) {
        Intrinsics.checkNotNullParameter(r19, "callerContext");
        Intrinsics.checkNotNullParameter(r20, "imageRequests");
        ECImageMultiSizeReuseOpt r10 = ECImageMultiSizeReuseOpt.e;
        r10.getClass();
        if (ECImageMultiSizeReuseOpt.g() == false) goto L147;
        if (r20.length != 0) goto L7;
        boolean r11 = true;
    L9:
        if ((!r11) == false) goto L147;
        l8a.d r13 = h(r20);
        if (r13 == null) goto L13;
        ResizeOptions r12 = r13.getResizeOptions();
    L14:
        final Ref.ObjectRef r15 = new Ref.ObjectRef();
        r15.element = r20;
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = r21;
        if ((r19 instanceof u) == true) goto L17;
        Object r0 = null;
    L18:
        u r1 = (u) r0;
        if (r1 == null) goto L21;
        com.bytedance.android.shopping.api.image.q r16 = r1.n();
    L22:
        if (r16 == null) goto L24;
        Pair<ECImageMultiSizeReuseOpt.CacheType, ECImageMultiSizeReuseOpt.c> r17 = r10.e(r19, r16);
    L25:
        if (r17 == null) goto L71;
        ECImageMultiSizeReuseOpt.CacheType r18 = (ECImageMultiSizeReuseOpt.CacheType) r17.getFirst();
        ECImageMultiSizeReuseOpt.c r22 = (ECImageMultiSizeReuseOpt.c) r17.getSecond();
        if (r18 != ECImageMultiSizeReuseOpt.CacheType.PRELOAD_REUSE_CACHE) goto L44;
        if (r22 == null) goto L44;
        if (r22.e() > 0) goto L32;
    L38:
        if (r12 == null) goto L69;
        int r23 = r22.c;
        if (r23 <= r12.width) goto L69;
        int r24 = r22.d;
        if (r24 <= r12.height) goto L69;
        r12 = new ResizeOptions(r23, r24);
    L70:
        ResizeOptions r25 = r12;
    L72:
        if (r17 == null) goto L144;
        if (r25 == null) goto L144;
        final ECImageMultiSizeReuseOpt.CacheType r26 = (ECImageMultiSizeReuseOpt.CacheType) r17.component1();
        final ECImageMultiSizeReuseOpt.c r27 = (ECImageMultiSizeReuseOpt.c) r17.component2();
        if (r26 != ECImageMultiSizeReuseOpt.CacheType.PRELOAD_REUSE_CACHE) goto L78;
        ImageRequest.RequestLevel r28 = ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE;
    L77:
        final ImageRequest.RequestLevel r29 = r28;
        if (r26 != ECImageMultiSizeReuseOpt.CacheType.REUSE_THUMB_CACHE) goto L97;
        if (r21 != null) goto L144;
    L97:
        if (r13 == null) goto L144;
        final String r30 = r13.getSourceUri().toString();
        Lazy r31 = ECImageX.a;
        final ResizeOptions r32 = r25;
        Function1<ImageRequestBuilder, Unit> r33 = new ImageExtensionsKt$tryReuseImageCache$$inlined$let$lambda$1(r30, r27, r32, r29, r26, r14, r15, r19);
        Intrinsics.checkNotNullParameter(r13, "request");
        ImageRequestBuilder r34 = ImageRequestBuilder.fromRequest(r13);
        Map r35 = r13.getCustomParam();
        if (r35 == null) goto L101;
        ECImageX.a(r34).putAll(r35);
    L101:
        ECImageXCompact.c.getClass();
        Intrinsics.checkNotNullParameter(r13, "imageRequest");
        m0.c("ECImageXCompact.isEnableNetworkPriority");
        if (m0.b() == true) goto L148;
        Intrinsics.checkNotNullParameter(r13, "imageRequest");
    L121:
        boolean r36 = false;
    L122:
        if (r36 == false) goto L124;
        ECImageXCompact.c.getClass();
        ECImageXCompact.d(r34);
    L124:
        Unit r37 = (Unit) r33.invoke(r34);
        if ((r13 instanceof l8a.d) == false) goto L127;
        l8a.d r38 = new l8a.d(r34, r13.a);
    L129:
        if (r26 != ECImageMultiSizeReuseOpt.CacheType.REUSE_THUMB_CACHE) goto L131;
        Ref.ObjectRef r39 = r14;
        r39.element = r38;
    L134:
        int r40 = v.a[r26.ordinal()];
        if (r40 != 1) goto L137;
        int r110 = 1;
    L141:
        r19.f("multi_size_image_reuse_type", Integer.valueOf(r110));
        r19.f("multi_size_image_reuse_origin", r30);
        ((u) r19).A = r27;
    L150:
        return new Pair((ImageRequest[]) r15.element, (ImageRequest) r39.element);
    L137:
        if (r40 == 2) goto L139;
        r110 = 0;
        goto L141
    L139:
        r110 = 2;
        goto L141
    L131:
        r39 = r14;
        List r41 = CollectionsKt.mutableListOf(new ImageRequest[]{r38});
        r41.addAll(ArraysKt.toList((ImageRequest[]) r15.element));
        Unit r42 = Unit.INSTANCE;
        Object[] r43 = r41.toArray(new ImageRequest[0]);
        if (r43 == null) goto L143;
        r15.element = (ImageRequest[]) r43;
        goto L134
    L143:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L127:
        r38 = r34.build();
        goto L129
    L148:
        Result.Companion r44 = Result.Companion;     // Catch: Throwable -> L113
        Method r45 = (Method) ECImageXCompact.a.getValue();     // Catch: Throwable -> L113
        if (r45 == null) goto L107;
        Object r46 = r45.invoke(r13, new Object[0]);     // Catch: Throwable -> L113
    L109:
        if ((r46 instanceof Boolean) == true) goto L111;
        r46 = null;
    L111:
        Object r47 = Result.constructor-impl((Boolean) r46);     // Catch: Throwable -> L113
    L116:
        if (Result.isFailure-impl(r47) == false) goto L118;
        r47 = null;
    L118:
        Boolean r48 = (Boolean) r47;
        if (r48 == null) goto L121;
        r36 = r48.booleanValue();
        goto L122
    L107:
        r46 = null;
    L113:
        th = move-exception;
        Result.Companion r49 = Result.Companion;
        r47 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L116
    L78:
        com.bytedance.android.shopping.api.image.b r50 = r10.f();
        if (r50 == null) goto L93;
        int r51 = com.bytedance.android.ec.core.imagex.opt.t.a;
        Intrinsics.checkNotNullParameter(r50, "$this$requestLevel");
        Integer r52 = r50.f();
        if (r52 != null) goto L84;
    L86:
        if (r52 != null) goto L89;
    L91:
        r28 = ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
    L92:
        if (r28 != null) goto L77;
    L89:
        if (r52.intValue() != 3) goto L91;
        r28 = ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE;
        goto L92
    L84:
        if (r52.intValue() != 2) goto L86;
        r28 = ImageRequest.RequestLevel.DISK_CACHE;
    L93:
        r28 = ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE;
    L144:
        r39 = r14;
    L69:
        r12 = null;
        goto L70
    L32:
        if (r22.a() <= 0) goto L38;
        if (r22.c < r22.e()) goto L38;
        if (r22.d < r22.a()) goto L38;
        r12 = new ResizeOptions(r22.c, r22.d);
    L44:
        if (r12 != null) goto L70;
        if (r16 == null) goto L70;
        if (r22 == null) goto L70;
        Integer r53 = r16.d().getValue();
        if (r53 == null) goto L51;
        int r54 = r53.intValue();
    L52:
        Integer r55 = r16.b().getValue();
        if (r55 == null) goto L55;
        int r56 = r55.intValue();
    L56:
        if (r54 <= 0) goto L58;
        if (r56 <= 0) goto L58;
    L66:
        if (r54 <= 0) goto L69;
        if (r56 <= 0) goto L69;
        r12 = new ResizeOptions(r54, r56);
    L58:
        int r57 = r22.c;
        if (r57 <= 0) goto L66;
        int r58 = r22.d;
        if (r58 <= 0) goto L66;
        if (r56 <= 0) goto L64;
        r54 = (int) ((r57 / r58) * r56);
        goto L66
    L64:
        if (r54 <= 0) goto L66;
        r56 = (int) ((r58 / r57) * r54);
        goto L66
    L55:
        r56 = 0;
        goto L56
    L51:
        r54 = 0;
        goto L52
    L71:
        r25 = null;
        goto L72
    L24:
        r17 = null;
        goto L25
    L21:
        r16 = null;
        goto L22
    L17:
        r0 = r19;
        goto L18
    L13:
        r12 = null;
        goto L14
    L7:
        r11 = false;
    L147:
        return new Pair(r20, r21);
    }

    public static final void d(PipelineDraweeControllerBuilder r10, ImageRequest[] r11, ImageRequest r12) {
        Intrinsics.checkNotNullParameter(r10, "$this$compactImageRequest");
        if (r11 != null) goto L5;
    L7:
        r10.setImageRequests(null, false);
        if (r11 == null) goto L12;
        ImageRequest r13 = (ImageRequest) ArraysKt.firstOrNull(r11);
        if (r13 == null) goto L12;
        r10.setImageRequest(r13);
    L12:
        r10.setLowResImageRequest(r12);
        r10.setDataSourceSupplier(null);
        return;
    L5:
        if (r11.length <= 1) goto L7;
        r10.setImageRequest(null);
        ECImageXCompact.c.getClass();
        ECImageXCompact.a(r10, r11);
        goto L12
    }

    public static final Pair C(List r12, r r13, Integer r14, Integer r15) {
        List r0 = r12;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        return null;
    L12:
        ResizeOptions r16 = i(r14, r15);
        u r17 = k(null, r13);
        r17.C(r16);
        ImageRequest[] r18 = o(n0.a(l(), r12, r16, r17, null, false, 56), r17, r16, null, null, null, null, false, 192);
        if (r18 == null) goto L21;
        ImageRequest r19 = h(r18);
        if (r19 == null) goto L21;
        Intrinsics.checkNotNullParameter(r19, "$this$prefetchImageToCache");
        DomainPreConnect r110 = com.bytedance.android.ec.core.imagex.opt.p.a();
        if (r110 == null) goto L19;
        r110.a(r17);
    L19:
        r17.i = true;
        Fresco.getImagePipeline().prefetchToBitmapCache(r19, r17);
    L21:
        return new Pair(r17, r18);
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }

    public static final void a(List r10, int r11, r r12, ObservableEmitter r13) {
        int r0 = r10.size();
        if (r11 < 0) goto L8;
        if (r0 <= r11) goto L9;
        DataSource r1 = ImagePipelineFactory.getInstance().getImagePipeline().fetchDecodedImage((ImageRequest) ListProtector.get(r10, r11), r12);
        r1.subscribe(new x(r1, r1, r13, r11, r10, r12), CallerThreadExecutor.getInstance());
        return;
    L9:
        return;
    }

    public static final void b(List r10, int r11, r r12, ObservableEmitter r13) {
        int r0 = r10.size();
        if (r11 < 0) goto L8;
        if (r0 <= r11) goto L9;
        ImageRequest r14 = (ImageRequest) ListProtector.get(r10, r11);
        ImagePipelineFactory.getInstance().getImagePipeline().prefetchToDiskCache(r14, r12).subscribe(new z(r13, r11, r10, r12, r14, r12), CallerThreadExecutor.getInstance());
        return;
    L9:
        return;
    }

    public static final void u(GenericDraweeView r11, ImageRequest[] r12, ImageRequest r13, r r14) {
        Intrinsics.checkNotNullParameter(r11, "$this$load");
        Intrinsics.checkNotNullParameter(r12, "imageRequests");
        u r10 = k(null, r14);
        r10.B();
        y(r11, r12, r13, r10, null, false, null, false, null, 240);
    }

    public static /* synthetic */ void v(GenericDraweeView r14, ECUrlModel r15, Function1 r16, int r17) {
        if ((r17 & 256) == 0) goto L5;
        boolean r10 = true;
    L7:
        if ((r17 & 1024) == 0) goto L9;
        Function1 r11 = null;
    L10:
        r(r14, r15, null, null, null, null, null, null, null, r10, null, r11, null, null);
        return;
    L9:
        r11 = r16;
        goto L10
    L5:
        r10 = false;
        goto L7
    }

    public static final void E(ImageRequestBuilder r20, r r21, ResizeOptions r22, Bitmap.Config r23, Postprocessor r24) {
        ResizeOptions r10 = r22;
        long r11 = System.nanoTime();
        Uri r12 = r20.getSourceUri();
        String r13 = r12.toString();
        com.bytedance.android.shopping.api.image.q r14 = com.bytedance.android.ec.core.imagex.opt.s.c(r21);
        com.bytedance.android.shopping.api.image.q r15 = com.bytedance.android.ec.core.imagex.opt.s.c(r21);
        if (r15 == null) goto L53;
        com.bytedance.android.shopping.api.image.n r16 = r15.d();
        if (r16 == null) goto L53;
        if (r16.a() != true) goto L53;
        if (r15.b().a() != true) goto L53;
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.p.getValue()).booleanValue() == false) goto L53;
        if (r10 == null) goto L14;
        int r17 = r10.width;
    L15:
        if (r10 == null) goto L17;
        int r18 = r10.height;
    L18:
        int r19 = r15.e();
        int r110 = r15.a();
        Integer r111 = r15.d().getValue();
        if (r111 == null) goto L21;
        int r112 = r111.intValue();
    L22:
        Integer r113 = r15.b().getValue();
        if (r113 != null) goto L25;
    L35:
        int r114 = r110;
        if (r17 <= 0) goto L43;
        if (r18 <= 0) goto L43;
        if (r17 >= r112) goto L43;
        if (r18 >= r114) goto L43;
        if (Math.max(r17 / r112, r18 / r114) < 0.7f) goto L53;
    L43:
        r10 = i(Integer.valueOf(r112), Integer.valueOf(r114));
        if (r10 != null) goto L46;
        r10 = null;
        goto L53
    L46:
        if ((r21 instanceof u) == true) goto L48;
        r r115 = null;
    L49:
        u r116 = (u) r115;
        if (r116 == null) goto L53;
        r116.C(r10);
        goto L53
    L48:
        r115 = r21;
        goto L49
    L25:
        if (r113.intValue() != 0) goto L29;
        if (r112 <= 0) goto L29;
        if (r19 <= 0) goto L29;
        boolean r117 = true;
    L30:
        if (r117 == true) goto L33;
        r113 = null;
    L33:
        if (r113 == null) goto L35;
        r113.intValue();
        r110 = (r110 / r19) * r112;
    L29:
        r117 = false;
        goto L30
    L21:
        r112 = r19;
        goto L22
    L17:
        r18 = 0;
        goto L18
    L14:
        r17 = 0;
    L53:
        if (r10 == null) goto L56;
        r20.setResizeOptions(r10);
    L56:
        if (r24 == null) goto L59;
        r20.setPostprocessor(r24);
    L64:
        if (r23 == null) goto L66;
        ImageDecodeOptionsBuilder r25 = new ImageDecodeOptionsBuilder();
        r25.setBitmapConfig(r23);
        Unit r26 = Unit.INSTANCE;
        r20.setImageDecodeOptions(new ImageDecodeOptions(r25));
    L91:
        if (((Boolean) ImageSettings.p.getValue()).booleanValue() == false) goto L93;
        r20.setRotationOptions(RotationOptions.autoRotateAtRenderTime());
    L93:
        u r0 = s.a(r21);
        if (r0 == null) goto L97;
        r0.f("ec_local_duration_request_core_build", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r11)));
        return;
    L97:
        return;
    L66:
        ImageDecodeOptionsBuilder r27 = new ImageDecodeOptionsBuilder();
        r27.setBitmapConfig(Bitmap.Config.ARGB_8888);
        Unit r28 = Unit.INSTANCE;
        r20.setImageDecodeOptions(new ImageDecodeOptions(r27));
        com.bytedance.android.ec.core.imagex.opt.m r29 = com.bytedance.android.ec.core.imagex.opt.n.a;
        String r30 = r12.toString();
        Intrinsics.checkNotNullParameter(r30, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r20, "imageRequestBuilder");
        m0.c("DecodeRGB565ConfigHelper.setRGB565Strategy()");
        if (m0.b() == false) goto L91;
        if (r14 == null) goto L72;
        boolean r31 = !Intrinsics.areEqual(r14.getQuery().b("ec_rgb565"), "1");
    L75:
        if (r31 == true) goto L91;
        ImageExperiments.G.getClass();
        if (((Boolean) ImageExperiments.B.getValue()).booleanValue() == false) goto L80;
        ImageDecodeOptionsBuilder r32 = new ImageDecodeOptionsBuilder();
        r32.setBitmapConfig(Bitmap.Config.RGB_565);
        r20.setImageDecodeOptions(new ImageDecodeOptions(r32));
        goto L91
    L80:
        r20.getImageDecodeOptions().isSelectBitmapConfig = false;
        ImageDecodeBitmapConfigStrategy r33 = ImageDecodeBitmapConfigStrategy.getStrategy();
        if (r33 != null) goto L84;
        r33 = ImageDecodeBitmapConfigStrategy.DEFAULT;
    L84:
        if (r33 == ImageDecodeBitmapConfigStrategy.MEMORY_AT_LEAST) goto L91;
        com.bytedance.android.ec.core.imagex.opt.m r34 = com.bytedance.android.ec.core.imagex.opt.n.a;
        if (r34 == null) goto L89;
        if (r34 == r33) goto L91;
    L89:
        com.bytedance.android.ec.core.imagex.opt.m r35 = new com.bytedance.android.ec.core.imagex.opt.m(r33);
        com.bytedance.android.ec.core.imagex.opt.n.a = r35;
        ImageDecodeBitmapConfigStrategy.setStrategy(r35);
        FrescoCacheMonitorUtil.setOptRgbaForPostProcessor(true);
        goto L91
    L72:
        if (StringsKt.contains$default(r30, "ec_rgb565=1", false, 2, null) == true) goto L74;
        r31 = true;
        goto L75
    L74:
        r31 = false;
        goto L75
    L59:
        if (e(r13, r21) == false) goto L64;
        ri.b r36 = com.bytedance.android.ec.sdk.helper.d.b.getIECHostFrescoService();
        if (r36 == null) goto L63;
        r36.b();
    L63:
        r20.setPostprocessor(null);
        r21.f("use_image_sr", "1");
        goto L64
    }

    public static final Pair<List<ImageRequest>, r> m(List<String> r11, Integer r12, Integer r13, r r14, Postprocessor r15) {
        Intrinsics.checkNotNullParameter(r11, "urlList");
        if (r11.isEmpty() == false) goto L5;
        return null;
    L5:
        ResizeOptions r16 = i(r12, r13);
        u r17 = k(null, r14);
        r17.C(r16);
        ImageRequest[] r18 = o(n0.a(l(), r11, r16, r17, null, false, 56), r17, r16, null, r15, null, null, false, 192);
        if (r18 != null) goto L9;
        r18 = new ImageRequest[0];
    L9:
        return new Pair(ArraysKt.toList(r18), r17);
    }

    public static final void F(ImageRequestBuilder r10, r r11, Priority r12, String r13, RequestListener r14, Boolean r15) {
        long r0 = System.nanoTime();
        String r16 = r10.getSourceUri().toString();
        com.bytedance.android.shopping.api.image.q r17 = com.bytedance.android.ec.core.imagex.opt.s.c(r11);
        boolean r18 = true;
        if (r15 == null) goto L8;
        boolean r19 = r15.booleanValue();
        ECImageXCompact.c.getClass();
        Intrinsics.checkNotNullParameter(r10, "$this$compactSetFallBackToMainMemory");
        m0.c("ECImageXCompact.compactSetFallBackToMainMemory");
        if (m0.b() == false) goto L18;
        r10.setFallBackToMainMemory(r19);
    L18:
        r r20 = null;
        if (r12 == null) goto L21;
        r10.setRequestPriority(r12);
    L37:
        ImageNetworkPriorityOpt.d.getClass();
        if (((Boolean) ImageNetworkPriorityOpt.b.getValue()).booleanValue() == true) goto L40;
    L46:
        Priority r110 = r10.getRequestPriority();
        if (r110 != null) goto L49;
    L55:
        if (r13 != null) goto L57;
    L60:
        boolean r111 = true;
    L61:
        if (r111 == true) goto L63;
    L65:
        if (r13 != null) goto L67;
    L70:
        if (r18 == true) goto L73;
        r10.setCacheChoice(ImageRequest.CacheChoice.CUSTOM);
        r10.setCustomCacheName(r13);
    L73:
        if (((Boolean) ImageSettings.p.getValue()).booleanValue() == false) goto L75;
        r10.setRotationOptions(RotationOptions.autoRotateAtRenderTime());
    L75:
        int r112 = ProxyRequestListener.c;
        com.bytedance.android.ec.core.imagex.common.x r113 = ProxyRequestListener.a.a(r14, new c0(r17, r11));
        com.bytedance.android.shopping.api.image.r r114 = com.bytedance.android.ec.core.imagex.opt.s.d(r11);
        if (r114 == null) goto L78;
        Intrinsics.checkNotNullParameter("tag#ImageUrlParser", "key");
        Intrinsics.checkNotNullParameter(r114, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        r113.a.put("tag#ImageUrlParser", r114);
    L78:
        r10.setRequestListener(r113);
        Map r115 = r10.getCustomParam();
        if (r115 != null) goto L81;
        r115 = new LinkedHashMap();
        r10.setCustomParam(r115);
    L81:
        r115.put("biz_tag", r11.f);
        r115.put("scene_tag", r11.g);
        r115.put("from_ec_image_loaded", "1");
        u r116 = s.a(r11);
        if (r116 == null) goto L88;
        r116.f("ec_local_duration_request_secondary_build", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r0)));
        return;
    L88:
        return;
    L67:
        if (StringsKt.isBlank(r13) == true) goto L70;
        r18 = false;
        goto L70
    L63:
        if (((Boolean) ECImageCustomDiskCacheHelper.b.getValue()).booleanValue() == false) goto L65;
        r13 = ECImageCustomDiskCacheHelper.a(r11.f, r11.g, r16);
        goto L65
    L57:
        if (StringsKt.isBlank(r13) == true) goto L60;
        r111 = false;
        goto L61
    L49:
        if ((r11 instanceof u) == false) goto L52;
        r20 = r11;
    L52:
        u r21 = (u) r20;
        if (r21 == null) goto L55;
        Intrinsics.checkNotNullParameter(r110, "requestPriority");
        r21.l = Integer.valueOf(r110.ordinal());
        goto L55
    L40:
        if (r10.getRequestPriority() == null) goto L46;
        ECImageXCompact.c.getClass();
        ECImageXCompact.d(r10);
        if (r10.getRequestPriority() != Priority.IMMEDIATE) goto L46;
        u r117 = s.a(r11);
        if (r117 == null) goto L46;
        r117.n = true;
        goto L46
    L21:
        ImageNetworkPriorityOpt r118 = ImageNetworkPriorityOpt.d;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r11, "callerContext");
        if (((Boolean) ImageNetworkPriorityOpt.b.getValue()).booleanValue() == false) goto L34;
        List r119 = ((com.bytedance.android.shopping.api.image.e0) ImageNetworkPriorityOpt.c.getValue(r118, ImageNetworkPriorityOpt.a[0])).a();
        if (r119 == null) goto L34;
        Iterator r120 = r119.iterator();
    L28:
        if (r120.hasNext() == false) goto L32;
        Object r22 = r120.next();
        if (com.bytedance.android.ec.core.imagex.common.l.b((com.bytedance.android.shopping.api.image.d0) r22, r11, r17) == false) goto L28;
    L33:
        com.bytedance.android.shopping.api.image.d0 r23 = (com.bytedance.android.shopping.api.image.d0) r22;
    L35:
        if (r23 == null) goto L37;
        r10.setRequestPriority(com.bytedance.android.ec.core.imagex.opt.y.a(r23));
        goto L37
    L32:
        r22 = null;
    L34:
        r23 = null;
        goto L35
    L8:
        TmplConvConfig r121 = TmplConvConfig.k;
        r121.getClass();
        if (((Boolean) TmplConvConfig.j.getValue()).booleanValue() == false) goto L18;
        com.bytedance.android.shopping.api.image.h r122 = (com.bytedance.android.shopping.api.image.h) TmplConvConfig.f.getValue(r121, TmplConvConfig.a[4]);
        if (r122 == null) goto L18;
        if (com.bytedance.android.ec.core.imagex.common.l.b(r122, r11, r17) != true) goto L18;
        ECImageXCompact.c.getClass();
        Intrinsics.checkNotNullParameter(r10, "$this$compactSetFallBackToMainMemory");
        m0.c("ECImageXCompact.compactSetFallBackToMainMemory");
        if (m0.b() == false) goto L18;
        r10.setFallBackToMainMemory(true);
        goto L18
    }

    public static b g(List r10, r r11, Integer r12, Integer r13, final Postprocessor r14, final Function1 r15) {
        final Priority r16 = null;
        final String r17 = null;
        Intrinsics.checkNotNullParameter(r10, "$this$fetchImage");
        final ResizeOptions r18 = i(r12, r13);
        final u r19 = k(null, r11);
        r19.B();
        r19.C(r18);
        final b r110 = new b(0);
        n0.d(l(), r10, r18, r19, new ImageExtensionsKt$fetchImage$2(r19, r18, r14, r16, r17, r15, r110));
        return r110;
    }

    public static b f(String r14, r r15, Integer r16, Integer r17, Postprocessor r18, Function1 r19, int r20) {
        if ((r20 & 2) == 0) goto L5;
        Integer r1 = null;
    L7:
        if ((r20 & 4) == 0) goto L9;
        Integer r10 = null;
    L11:
        if ((r20 & 8) == 0) goto L13;
        final Postprocessor r11 = null;
    L15:
        if ((r20 & 16) == 0) goto L17;
        final Function1 r12 = null;
    L18:
        final Priority r13 = null;
        final String r110 = null;
        Intrinsics.checkNotNullParameter(r14, "$this$fetchImage");
        final ResizeOptions r21 = i(r1, r10);
        final u r22 = k(null, r15);
        r22.B();
        r22.C(r21);
        final b r23 = new b(0);
        n0.c(l(), r14, r21, r22, new ImageExtensionsKt$fetchImage$4(r22, r21, r11, r13, r110, r12, r23));
        return r23;
    L17:
        r12 = r19;
        goto L18
    L13:
        r11 = r18;
        goto L15
    L9:
        r10 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }

    public static /* synthetic */ Pair I(List r11, r r12, ResizeOptions r13, Bitmap.Config r14, Postprocessor r15, Priority r16, String r17, int r18) {
        if ((r18 & 2) == 0) goto L5;
        ResizeOptions r10 = null;
    L7:
        if ((r18 & 4) == 0) goto L9;
        Bitmap.Config r19 = null;
    L11:
        if ((r18 & 8) == 0) goto L13;
        Postprocessor r20 = null;
    L15:
        if ((r18 & 16) == 0) goto L17;
        Priority r21 = null;
    L19:
        if ((r18 & 32) == 0) goto L21;
        String r22 = null;
    L23:
        return H(r11, r12, r10, r19, r20, r21, r22, null, false);
    L21:
        r22 = r17;
        goto L23
    L17:
        r21 = r16;
        goto L19
    L13:
        r20 = r15;
        goto L15
    L9:
        r19 = r14;
        goto L11
    L5:
        r10 = r13;
        goto L7
    }

    public static final ImageRequest p(List r10, u r11, ResizeOptions r12, Bitmap.Config r13, Postprocessor r14, Priority r15, String r16, RequestListener r17) {
        Intrinsics.checkNotNullParameter(r10, "$this$innerToPreloadImageRequestOrNull");
        Intrinsics.checkNotNullParameter(r11, "callerContext");
        Intrinsics.checkNotNullParameter(r10, "$this$innerToImageRequestsOrNull");
        Intrinsics.checkNotNullParameter(r11, "callerContext");
        Pair<ImageRequest[], ImageRequest> r0 = H(r10, r11, r12, r13, r14, r15, r16, r17, true);
        if (r0 != null) goto L5;
        ImageRequest[] r1 = null;
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return h(r1);
    L5:
        r1 = (ImageRequest[]) r0.component1();
        goto L6
    }

    public static final void A(String r11, r r12, Integer r13, Integer r14, Priority r15, RequestListener r16, Postprocessor r17, boolean r18, String r19) {
        Intrinsics.checkNotNullParameter(r11, "$this$prefetchImageToCache");
        z(r11, r12, r13, r14, null, r15, r16, r17, r18, r19);
    }

    public static /* synthetic */ void B(String r10, r r11, Integer r12, Integer r13, Priority r14, RequestListener r15, Postprocessor r16, boolean r17, int r18) {
        if ((r18 & 64) == 0) goto L5;
        boolean r19 = true;
    L6:
        A(r10, r11, r12, r13, r14, r15, r16, r19, null);
        return;
    L5:
        r19 = r17;
        goto L6
    }

    public static final Pair<ImageRequest[], ImageRequest> H(List<String> r19, r r20, ResizeOptions r21, Bitmap.Config r22, Postprocessor r23, Priority r24, String r25, RequestListener r26, boolean r27) {
        Intrinsics.checkNotNullParameter(r19, "$this$transformToImageRequest");
        Intrinsics.checkNotNullParameter(r20, "callerContext");
        if (r19.isEmpty() == false) goto L5;
        return null;
    L5:
        long r14 = System.nanoTime();
        ArrayList r11 = new ArrayList();
        Iterator<T> r16 = r19.iterator();
        int r1 = 0;
    L7:
        if (r16.hasNext() == false) goto L15;
        Object r10 = r16.next();
        int r17 = r1 + 1;
        if (r1 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        ArrayList r13 = r11;
        ImageRequest r12 = n((String) r10, r20, r21, r22, r23, r24, r25, r26, null, r27, 128);
        if (r12 == null) goto L14;
        r13.add(r12);
    L14:
        r11 = r13;
        r1 = r17;
        goto L7
    L15:
        ArrayList r15 = r11;
        if (r15.isEmpty() == false) goto L19;
        return null;
    L19:
        Object[] r18 = r15.toArray(new ImageRequest[0]);
        if (r18 == null) goto L43;
        ImageRequest[] r28 = (ImageRequest[]) r18;
        ImageRequest r29 = (ImageRequest) ArraysKt.firstOrNull(r28);
        if (r29 != null) goto L24;
    L31:
        int r30 = r28.length;
        int r110 = 0;
    L32:
        if (r110 >= r30) goto L40;
        RequestListener r31 = r28[r110].getRequestListener();
        if ((r31 instanceof ProxyRequestListener) == true) goto L36;
        r31 = null;
    L36:
        ProxyRequestListener r32 = (ProxyRequestListener) r31;
        if (r32 == null) goto L39;
        Intrinsics.checkNotNullParameter("tag#ImageUrls", "key");
        Intrinsics.checkNotNullParameter(r19, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        r32.a.put("tag#ImageUrls", r19);
    L39:
        r110 = r110 + 1;
        goto L32
    L40:
        r20.f("ec_local_duration_request", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r14)));
        return new Pair(r28, null);
    L24:
        if (r29.getLowestPermittedRequestLevel().compareTo(ImageRequest.RequestLevel.FULL_FETCH) <= 0) goto L31;
        RequestListener r33 = r29.getRequestListener();
        if ((r33 instanceof ProxyRequestListener) == true) goto L28;
        r33 = null;
    L28:
        ProxyRequestListener r34 = (ProxyRequestListener) r33;
        if (r34 == null) goto L31;
        Intrinsics.checkNotNullParameter("tag#ArrayImageRequest", "key");
        Intrinsics.checkNotNullParameter(r28, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        r34.a.put("tag#ArrayImageRequest", r28);
        goto L31
    L43:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static ImageRequest[] o(List r12, u r13, ResizeOptions r14, Bitmap.Config r15, Postprocessor r16, Priority r17, String r18, boolean r19, int r20) {
        if ((r20 & 2) == 0) goto L5;
        ResizeOptions r10 = null;
    L7:
        if ((r20 & 4) == 0) goto L9;
        Bitmap.Config r11 = null;
    L11:
        if ((r20 & 8) == 0) goto L13;
        Postprocessor r21 = null;
    L15:
        if ((r20 & 16) == 0) goto L17;
        Priority r22 = null;
    L19:
        if ((r20 & 32) == 0) goto L21;
        String r23 = null;
    L23:
        if ((r20 & 128) == 0) goto L25;
        boolean r110 = false;
    L26:
        Intrinsics.checkNotNullParameter(r12, "$this$innerToImageRequestsOrNull");
        Intrinsics.checkNotNullParameter(r13, "callerContext");
        Pair<ImageRequest[], ImageRequest> r0 = H(r12, r13, r10, r11, r21, r22, r23, null, r110);
        if (r0 != null) goto L30;
        return null;
    L30:
        return (ImageRequest[]) r0.component1();
    L25:
        r110 = r19;
        goto L26
    L21:
        r23 = r18;
        goto L23
    L17:
        r22 = r17;
        goto L19
    L13:
        r21 = r16;
        goto L15
    L9:
        r11 = r15;
        goto L11
    L5:
        r10 = r14;
        goto L7
    }

    public static void y(final GenericDraweeView r36, ImageRequest[] r37, final ImageRequest r38, final r r39, ControllerListener r40, boolean r41, Function1 r42, boolean r43, com.bytedance.android.ec.core.imagex.opt.t0.d r44, int r45) {
        if ((r45 & 8) == 0) goto L5;
        ControllerListener r11 = null;
    L7:
        if ((r45 & 16) == 0) goto L9;
        boolean r10 = true;
    L11:
        if ((r45 & 32) == 0) goto L13;
        Function1 r12 = null;
    L15:
        if ((r45 & 64) == 0) goto L17;
        boolean r1 = false;
    L19:
        if ((r45 & 128) == 0) goto L21;
        com.bytedance.android.ec.core.imagex.opt.t0.d r13 = null;
    L22:
        Intrinsics.checkNotNullParameter(r36, "$this$load");
        Intrinsics.checkNotNullParameter(r37, "imageRequests");
        Intrinsics.checkNotNullParameter(r39, "callerContext");
        if (r37.length != 0) goto L25;
        boolean r14 = true;
    L26:
        if (r14 == false) goto L30;
        if (r38 != null) goto L30;
        if (r13 != null) goto L30;
        return;
    L30:
        long r16 = System.nanoTime();
        Intrinsics.checkNotNullParameter(r36, "$this$setECPlaceholderImage");
        boolean r15 = r39 instanceof u;
        if (r15 == false) goto L64;
        Drawable r17 = com.bytedance.android.ec.core.imagex.common.d.a;
        if (com.bytedance.android.ec.core.imagex.common.d.a(null, r39, 3) == false) goto L64;
        u r18 = (u) r39;
        ResizeOptions r19 = r18.k;
        if (r19 == null) goto L38;
        Integer r20 = Integer.valueOf(r19.width);
    L44:
        if (r20 == null) goto L46;
        int r21 = r20.intValue();
    L47:
        ResizeOptions r22 = r18.k;
        if (r22 == null) goto L50;
        Integer r23 = Integer.valueOf(r22.height);
    L56:
        if (r23 == null) goto L58;
        r23.intValue();
    L58:
        Drawable r24 = com.bytedance.android.ec.core.imagex.common.d.b(r36.getContext(), r21);
        if (r24 == null) goto L64;
        if (r36.hasHierarchy() == false) goto L63;
        r36.getHierarchy().setPlaceholderImage(r24, ScalingUtils.ScaleType.FIT_CENTER);
        goto L64
    L63:
        r36.setHierarchy(GenericDraweeHierarchyBuilder.newInstance(r36.getResources()).setPlaceholderImage(r24, ScalingUtils.ScaleType.FIT_CENTER).build());
        goto L64
    L50:
        com.bytedance.android.shopping.api.image.q r25 = com.bytedance.android.ec.core.imagex.opt.s.c(r39);
        if (r25 == null) goto L55;
        com.bytedance.android.shopping.api.image.n r26 = r25.b();
        if (r26 == null) goto L55;
        r23 = r26.getValue();
    L55:
        r23 = null;
        goto L56
    L46:
        r21 = 0;
        goto L47
    L38:
        com.bytedance.android.shopping.api.image.q r27 = com.bytedance.android.ec.core.imagex.opt.s.c(r39);
        if (r27 == null) goto L43;
        com.bytedance.android.shopping.api.image.n r28 = r27.d();
        if (r28 == null) goto L43;
        r20 = r28.getValue();
    L43:
        r20 = null;
    L64:
        Lazy r29 = ECAppInfoService.a;
        String r30 = "ec_na_mall";
        if (ECAppInfoService.m() == false) goto L257;
        if (r13 == null) goto L72;
        u r31 = s.a(r39);
        if (r31 == null) goto L72;
        String r32 = r31.p();
        if (r32 == null) goto L72;
        ImageRequest[] r110 = {ImageRequest.fromUri(r32)};
    L73:
        FirstScreenStatistic.S.getClass();
        if (FirstScreenStatistic.E == false) goto L107;
        if (r15 == true) goto L77;
        r r33 = null;
    L78:
        u r34 = (u) r33;
        if (r34 == null) goto L81;
        String r35 = r34.g;
    L83:
        if (com.bytedance.forest.utils.h.a(r35) == false) goto L107;
        if (CollectionsKt.contains(FirstScreenStatistic.k, r35) == false) goto L107;
        Intrinsics.checkNotNullParameter(r36, "$this$setLastBitmapAsPlaceHolder");
        if (ECAppInfoService.m() == false) goto L107;
        if (FirstScreenStatistic.G == false) goto L107;
        if (FirstScreenStatistic.H == true) goto L107;
        Intrinsics.checkNotNullParameter(r36, "imageView");
        String r111 = FirstScreenStatistic.L.get(r36);
        if (r111 != null) goto L97;
        r111 = "";
    L97:
        boolean r112 = r15;
        String r46 = FirstScreenStatistic.M.get(r111);
        if (r46 != null) goto L100;
        r46 = "";
    L100:
        Bitmap r47 = FirstScreenStatistic.O.get(r46);
        if (r47 == null) goto L108;
        com.bytedance.android.ec.core.imagex.opt.t0.d r210 = r13;
        Function1 r211 = r12;
        dm.a.a("FirstScreenStatistic").a("sceneTag " + r35 + " setPlaceHolder");
        BitmapDrawable r48 = new BitmapDrawable(r36.getResources(), r47);
        if (r36.hasHierarchy() == false) goto L106;
        r36.getHierarchy().setPlaceholderImage(r48, ScalingUtils.ScaleType.CENTER_CROP);
    L109:
        if (r1 == true) goto L229;
        Intrinsics.checkNotNullParameter(r36, "$this$processByBitmapAndSimpleFresco");
        Intrinsics.checkNotNullParameter(r110, "imageRequests");
        if (ECAppInfoService.m() == true) goto L113;
    L225:
        r210 = r210;
        r30 = "ec_na_mall";
        String r212 = "";
        String r113 = "imageView";
        final boolean r49 = r10;
    L224:
        ImageRequest[] r213 = r110;
    L226:
        boolean r0 = false;
    L227:
        if (r0 == true) goto L445;
    L230:
        h(r213);
        Intrinsics.checkNotNullParameter(r36, r113);
        if (FirstScreenStatistic.H == false) goto L233;
        r30 = r30;
    L259:
        Intrinsics.checkNotNullParameter(r36, "$this$getRealCallerContext");
        if (r39 != null) goto L265;
        Object r50 = j(r36);
        if (r50 != null) goto L264;
        r50 = t.a(r36.getContext());
    L264:
        Object r51 = r50;
    L266:
        boolean r52 = Intrinsics.areEqual(r36.getTag(2131376211), Boolean.TRUE);
        if (r52 == false) goto L274;
        Object r53 = r36.getTag(2131376167);
        if ((r53 instanceof ImageRequest) == true) goto L271;
        r53 = null;
    L271:
        ImageRequest r54 = (ImageRequest) r53;
        if (r54 == null) goto L274;
    L275:
        if (r52 == false) goto L279;
        if (r54 == null) goto L279;
        boolean r114 = false;
    L280:
        if (r210 != 0) goto L291;
        ImageRequest r55 = (ImageRequest) ArraysKt.firstOrNull(r37);
        if (ECImageMultiSizeReuseOpt.e.j() == false) goto L286;
        boolean r56 = true;
        ECImageMultiSizeReuseOpt.b r57 = ECImageMultiSizeReuseOpt.d(r55, r39, true);
        if (r57 == null) goto L287;
        CloseableStaticBitmap r58 = r57.a;
    L288:
        ImageRequest[] r115 = r37;
        if (r58 != null) goto L292;
        Pair<ImageRequest[], ImageRequest> r59 = J(r39, r115, r54);
        ImageRequest[] r116 = (ImageRequest[]) r59.component1();
        r54 = (ImageRequest) r59.component2();
    L293:
        u r117 = s.a(r39);
        if (r117 == null) goto L296;
        r117.f("ec_local_duration_load_controller_before", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r16)));
    L296:
        if (r58 != null) goto L300;
        if (r210 != 0) goto L300;
        boolean r118 = r114;
        com.bytedance.android.ec.core.imagex.common.i r60 = null;
    L323:
        long r61 = System.nanoTime();
        PipelineDraweeControllerBuilder r62 = Fresco.newDraweeControllerBuilder().setOldController(r36.getController());
        if (r60 != null) goto L329;
        d(r62, r116, r54);
        if (r54 == null) goto L328;
        r62.setLowResImageRequest(r54);
    L328:
        Integer r63 = null;
    L342:
        r62.setRetainImageOnFailure(r118);
        r62.setCallerContext(r51);
        ControllerListener r64 = r11;
        if (r64 != null) goto L345;
    L356:
        r62.setAutoPlayAnimations(r49);
        r r65 = r62.build();
        if (r52 == true) goto L359;
    L365:
        if (r52 == false) goto L374;
        if (r210 == 0) goto L374;
        if ((r65 instanceof PipelineDraweeController) == true) goto L370;
        Object r66 = r63;
    L371:
        PipelineDraweeController r67 = (PipelineDraweeController) r66;
        if (r67 == null) goto L374;
        r67.addControllerListener(new b0(r36, r65));
        goto L374
    L370:
        r66 = r65;
    L374:
        u r68 = s.a(r39);
        if (r68 == null) goto L377;
        r68.f("ec_local_duration_load_controller_build", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r61)));
    L377:
        DomainPreConnect.c.a(r39);
        if ((r51 instanceof u) == true) goto L380;
        Object r69 = r63;
    L381:
        u r70 = (u) r69;
        if (r70 == null) goto L384;
        r70.k();
    L384:
        Function1 r119 = r211;
        if (r119 == null) goto L387;
        Unit r71 = (Unit) r119.invoke(r65);
    L387:
        long r72 = System.nanoTime();
        if (r60 == null) goto L390;
        r60.b(r65);
    L390:
        r36.setController(r65);
        u r73 = s.a(r51);
        if (r73 == null) goto L394;
        r73.f("ec_local_set_controller_duration", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r72)));
    L394:
        if (ECAppInfoService.m() == true) goto L396;
    L439:
        u r74 = s.a(r39);
        if (r74 == null) goto L443;
        r74.f("ec_local_duration_load_controller", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r16)));
        return;
    L443:
        return;
    L396:
        if (r115.length != 0) goto L398;
        boolean r120 = true;
    L400:
        if ((!r120) == false) goto L439;
        com.bytedance.android.ec.core.imagex.opt.u r75 = com.bytedance.android.ec.core.imagex.opt.u.c;
        ImageRequest r76 = r115[0];
        r75.getClass();
        if (r76 == null) goto L439;
        if (r39 == null) goto L439;
        if (((Boolean) ImageExperimentsKt.a.getValue()).booleanValue() == false) goto L439;
        Uri r77 = r76.getSourceUri();
        if (r77 == null) goto L416;
        String r78 = r77.toString();
        if (r78 == null) goto L416;
        r212 = r78;
    L416:
        if (com.bytedance.android.ec.core.imagex.opt.u.a == null) goto L439;
        if (r212.length() <= 0) goto L420;
        boolean r121 = true;
    L421:
        if (r121 == false) goto L439;
        if (Intrinsics.areEqual(r30, r39.f) == false) goto L439;
        List<String> r79 = ((l) ImageExperimentsKt.b.getValue()).a();
        if (r79 == null) goto L439;
        if (r79.contains(r39.g) != true) goto L439;
        Set<com.bytedance.android.ec.core.imagex.opt.o0> r80 = com.bytedance.android.ec.core.imagex.opt.u.a;
        if (r80 == null) goto L439;
        String r81 = r39.f;
        String r82 = r39.g;
        ResizeOptions r83 = r76.getResizeOptions();
        if (r83 == null) goto L433;
        Integer r84 = Integer.valueOf(r83.width);
    L434:
        ResizeOptions r85 = r76.getResizeOptions();
        if (r85 == null) goto L437;
        Integer r122 = Integer.valueOf(r85.height);
    L438:
        r80.add(new com.bytedance.android.ec.core.imagex.opt.o0(r212, r81, r82, r84, r122));
        goto L439
    L437:
        r122 = r63;
        goto L438
    L433:
        r84 = r63;
        goto L434
    L420:
        r121 = false;
        goto L421
    L398:
        r120 = false;
        goto L400
    L380:
        r69 = r51;
        goto L381
    L359:
        if (r115.length != 0) goto L361;
        boolean r86 = true;
        boolean r123 = true;
    L363:
        if ((r123 ^ r86) == false) goto L365;
        r36.setTag(2131376167, r115[0]);
        goto L374
    L361:
        r86 = true;
        r123 = false;
        goto L363
    L345:
        if ((r64 instanceof n) == true) goto L347;
        Object r124 = r63;
    L349:
        if (((n) r124) != null) goto L351;
    L355:
        r62.setControllerListener(r64);
        goto L356
    L351:
        if ((r51 instanceof u) == true) goto L353;
        Object r125 = r63;
    L354:
        u r126 = (u) r125;
        goto L355
    L353:
        r125 = r51;
        goto L354
    L347:
        r124 = r64;
        goto L349
    L329:
        int r87 = com.bytedance.android.ec.core.imagex.common.c.e;
        Intrinsics.checkNotNullParameter(r62, "builder");
        Intrinsics.checkNotNullParameter(r60, "supplierContext");
        if ((r60 instanceof AsyncLoadImage.b) == false) goto L338;
        Lazy r127 = AsyncLoadImage.a;
        AsyncLoadImage.b r128 = (AsyncLoadImage.b) r60;
        Intrinsics.checkNotNullParameter(r128, "supplierContext");
        AsyncLoadImage.AsyncLoadImageDataSourceHandler r88 = new AsyncLoadImage.AsyncLoadImageDataSourceHandler(r128);
        ArrayList r129 = new ArrayList();
        ImageRequest r130 = r88.getImageRequest();
        if (r130 != null) goto L334;
        r130 = (com.bytedance.android.ec.core.imagex.opt.q0) r88.d.getValue();
    L334:
        com.bytedance.android.ec.core.imagex.opt.c r89 = new com.bytedance.android.ec.core.imagex.opt.c(r88, r130);
        ECImageXCompact.c.getClass();
        r129.add(ECImageXCompact.e(r89));
        r129.add(ECImageXCompact.e(new com.bytedance.android.ec.core.imagex.opt.e(r88)));
        r129.add(ECImageXCompact.e(new com.bytedance.android.ec.core.imagex.opt.b(r88)));
        IncreasingQualityDataSourceSupplier r90 = FirstAvailableDataSourceSupplier.create(r129);
        ImageRequest r131 = r88.e.d;
        if (r131 == null) goto L341;
        r90 = IncreasingQualityDataSourceSupplier.create(CollectionsKt.mutableListOf(new Supplier[]{r90, ECImageXCompact.e(new com.bytedance.android.ec.core.imagex.opt.d(r88, r131))}));
    L341:
        r62.setDataSourceSupplier(r90);
        r63 = null;
        r62.setImageRequest(null);
        r62.setImageRequests(null, false);
        goto L342
    L338:
        if ((r60 instanceof com.bytedance.android.ec.core.imagex.opt.l) == false) goto L340;
        r90 = new com.bytedance.android.ec.core.imagex.opt.k((com.bytedance.android.ec.core.imagex.opt.l) r60);
        goto L341
    L340:
        r90 = null;
    L300:
        com.bytedance.android.ec.core.imagex.common.c r91 = new com.bytedance.android.ec.core.imagex.common.c(r39, r116, r54);
        if (r210 == 0) goto L303;
        r60 = new AsyncLoadImage.b(r39, r116, r210.c.g(r54), r210);
    L320:
        u r92 = s.a(r39);
        r118 = r114;
        if (r92 == null) goto L323;
        r92.f("ec_local_duration_async_context_init", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r91.a)));
        goto L323
    L303:
        if (r58 == null) goto L319;
        if (r116 != null) goto L306;
    L312:
        boolean r93 = true;
    L314:
        if ((r93 ^ r56) == false) goto L316;
        ImageRequest[] r94 = r116;
    L317:
        if (r94 == null) goto L319;
        r60 = new com.bytedance.android.ec.core.imagex.opt.l(r58, new com.bytedance.android.ec.core.imagex.common.f(r39, r116, r54));
        goto L320
    L316:
        r94 = null;
        goto L317
    L306:
        if (r116.length != 0) goto L308;
        boolean r95 = true;
    L309:
        if (r95 == true) goto L312;
        r93 = false;
        goto L314
    L308:
        r95 = false;
    L319:
        r60 = null;
    L292:
        r116 = r115;
    L287:
        r58 = null;
        goto L288
    L286:
        r56 = true;
        goto L287
    L291:
        r115 = r37;
        r56 = true;
        r58 = null;
    L279:
        r114 = true;
    L274:
        r54 = r38;
        goto L275
    L265:
        r51 = r39;
        goto L266
    L233:
        if (r112 == true) goto L235;
        r r96 = null;
    L236:
        u r97 = (u) r96;
        if (r97 == null) goto L240;
        String r98 = r97.g;
        if (r98 == null) goto L240;
    L241:
        r30 = r30;
        if (StringsKt.contains$default(r98, r30, false, 2, null) == false) goto L259;
        if (r112 == true) goto L246;
        r r99 = null;
    L247:
        u r100 = (u) r99;
        if (r100 == null) goto L251;
        String r101 = r100.p();
        if (r101 == null) goto L251;
    L252:
        String r102 = FirstScreenStatistic.k(r101);
        if (com.bytedance.android.shopping.extensions.k.c(r102) == false) goto L259;
        HashSet<String> r103 = FirstScreenStatistic.v;
        if (r103.contains(r102) == true) goto L259;
        dm.a.a("FirstScreenStatistic").a("frescoLoadingUrls add sceneTag " + r98 + " cleanUrl " + r102);
        r103.add(r102);
        FirstScreenStatistic.x.incrementAndGet();
    L251:
        r101 = r212;
        goto L252
    L246:
        r99 = r39;
    L240:
        r98 = r212;
        goto L241
    L235:
        r96 = r39;
        goto L236
    L445:
        return;
    L113:
        if (FirstScreenStatistic.H == true) goto L225;
        ImageRequest r104 = h(r110);
        if (r104 == null) goto L121;
        Uri r105 = r104.getSourceUri();
        if (r105 == null) goto L121;
        String r106 = r105.toString();
        if (r106 == null) goto L121;
    L122:
        final HashMap r132 = new HashMap();
        r132.put("editedUrl", r106);
        if (r104 != null) goto L126;
        FirstScreenStatistic.n("processByBitmapCacheProcessor", "imageRequest null", null, r132);
        goto L225
    L126:
        if (r39 != null) goto L129;
        dm.a.a("FirstScreenStatistic").b("processByBitmapCacheProcessor callerContext null, fallback to fresco", null);
        FirstScreenStatistic.n("processByBitmapCacheProcessor", "callerContext null", null, r132);
        FirstScreenStatistic.m(r106, "", "", "");
        goto L225
    L129:
        if ((r39 instanceof u) == true) goto L131;
        dm.a.a("FirstScreenStatistic").b("processByBitmapCacheProcessor callerContext type error, fallback to fresco", null);
        FirstScreenStatistic.n("processByBitmapCacheProcessor", "callerContext type error", null, r132);
        FirstScreenStatistic.m(r106, "", "", "");
        goto L225
    L131:
        String r107 = ((u) r39).p();
        if (r107 != null) goto L134;
        r107 = "";
    L134:
        final Ref.ObjectRef r108 = new Ref.ObjectRef();
        r108.element = FirstScreenStatistic.k(r107);
        final String r109 = r39.g;
        final String r133 = r39.f;
        r212 = "";
        r132.put("originUrl", r107);
        r132.put("cleanUrl", (String) r108.element);
        r132.put("sceneTag", r109);
        boolean r214 = r10;
        r132.put("bizTag", r133);
        FirstScreenStatistic.m(r106, r107, (String) r108.element, r109);
        String r134 = (String) r108.element;
        if (r134 != null) goto L137;
    L140:
        boolean r135 = true;
    L141:
        if (r135 == false) goto L144;
        dm.a.a("FirstScreenStatistic").b("processByBitmapCacheProcessor cleanUrl empty, fallback to fresco", null);
        FirstScreenStatistic.n("processByBitmapCacheProcessor", "cleanUrl empty", null, r132);
    L145:
        r113 = "imageView";
    L223:
        r49 = r214;
        goto L224
    L144:
        if (StringsKt.contains$default(r109, "ec_na_mall", false, 2, null) == false) goto L145;
        String r136 = (String) r108.element;
        Intrinsics.checkNotNullParameter(r36, "imageView");
        Intrinsics.checkNotNullParameter(r136, "cleanUrl");
        Intrinsics.checkNotNullParameter(r109, "sceneTag");
        Intrinsics.checkNotNullParameter(r132, "extra");
        if (FirstScreenStatistic.C != 0) goto L150;
        FirstScreenStatistic.C = System.currentTimeMillis();
    L150:
        if (FirstScreenStatistic.t == false) goto L155;
        if (FirstScreenStatistic.u == true) goto L155;
        FirstScreenStatistic.r.add(r136);
    L155:
        if (FirstScreenStatistic.u == true) goto L162;
        FirstScreenStatistic.L.put(r36, r136);
        HashMap<String, o0> r137 = FirstScreenStatistic.h;
        o0 r138 = new o0();
        r138.c = System.currentTimeMillis();
        r138.b = r109;
        r138.a = r136;
        if (FirstScreenStatistic.a == false) goto L159;
        r138.g = LoadType.SECOND_REAL_DATA;
    L159:
        Unit r139 = Unit.INSTANCE;
        r137.put(r136, r138);
        dm.a.a("FirstScreenStatistic").a("imageViewLoadingUrlMap update " + r36.hashCode() + ' ' + r136);
    L162:
        if (FirstScreenStatistic.H == true) goto L197;
        Set<String> r140 = FirstScreenStatistic.D;
        if (r140.contains(r136) == true) goto L166;
        r140.add(r136);
        if (FirstScreenStatistic.a == false) goto L172;
        dm.a.a("FirstScreenStatistic").a(ThreadMethodProxy.currentThread().getName() + " AfterFirstScreen load url " + r136);
    L174:
        if (FirstScreenStatistic.m == false) goto L197;
        if (FirstScreenStatistic.a == true) goto L197;
        if (FirstScreenStatistic.l.contains(r109) == true) goto L182;
        FirstScreenStatistic.i.add(r109);
        String r141 = "ec_na_mall_other";
    L183:
        String r142 = String.valueOf(r141);
        boolean r143 = FirstScreenStatistic.h(r136);
        dm.a.b r144 = dm.a.a("FirstScreenStatistic");
        StringBuilder r145 = new StringBuilder("hasCacheFile: hitCache ");
        r145.append(r143);
        r145.append(" originUrl ");
        r145.append(r136);
        r145.append(" cacheSize: ");
        ConcurrentHashMap<String, Boolean> r146 = FirstScreenStatistic.K;
        String r410 = "imageView";
        r145.append(r146.size());
        r145.append(" bitmapCacheMd5Names: ");
        r145.append(r146.toString());
        r144.a(r145.toString());
        if (r143 == false) goto L191;
        String r147 = FirstScreenStatistic.M.get(r136);
        if (r147 != null) goto L189;
        r147 = r212;
    L189:
        if (com.bytedance.android.shopping.extensions.k.c(r147) == false) goto L191;
        FirstScreenStatistic.q.add(r147);
    L191:
        i0 r148 = new i0();
        r148.b = System.currentTimeMillis();
        HashMap<String, i0> r149 = FirstScreenStatistic.g.get(r142);
        if (r149 == null) goto L199;
        if (r149.containsKey(r136) == true) goto L199;
        r149.put(r136, r148);
    L199:
        if (FirstScreenStatistic.G == true) goto L201;
        r113 = r410;
        goto L223
    L201:
        if (FirstScreenStatistic.h((String) r108.element) == false) goto L218;
        String r150 = (String) r108.element;
        final ControllerListener r151 = r11;
        r30 = r30;
        r212 = r212;
        final ImageRequest[] r152 = r110;
        r210 = r210;
        r49 = r214;
        r213 = r110;
        r11 = r11;
        final Function1 r153 = r211;
        Function1<Boolean, Unit> r154 = new ImageExtensionsKt$processByBitmapAndSimpleFresco$1(r36, r151, r108, r109, r133, r132, r152, r38, r39, r49, r153);
        Intrinsics.checkNotNullParameter(r150, "cleanUrl");
        r113 = r410;
        Intrinsics.checkNotNullParameter(r36, r113);
        Intrinsics.checkNotNullParameter(r132, "extra");
        Intrinsics.checkNotNullParameter(r154, "callback");
        String r155 = FirstScreenStatistic.M.get(r150);
        ConcurrentHashMap<String, p0> r156 = FirstScreenStatistic.N;
        p0 r157 = r156.get(r155);
        if (r157 == null) goto L205;
        r157.c = System.currentTimeMillis();
    L205:
        dm.a.b r158 = dm.a.a("FirstScreenStatistic");
        StringBuilder r159 = new StringBuilder("preloadedMap ");
        ConcurrentHashMap<String, Bitmap> r160 = FirstScreenStatistic.O;
        r159.append(r160.size());
        r158.a(r159.toString());
        if (r160.containsKey(r155) == false) goto L217;
        dm.a.a("FirstScreenStatistic").a(r155 + ' ' + r150 + " bitmap already preloaded");
        p0 r161 = r156.get(r155);
        if (r161 == null) goto L210;
        r161.d = System.currentTimeMillis();
    L210:
        p0 r162 = r156.get(r155);
        if (r162 == null) goto L213;
        r162.e = System.currentTimeMillis();
    L213:
        Bitmap r163 = r160.get(r155);
        r36.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r36.setImageBitmap(r163);
        p0 r164 = r156.get(r155);
        if (r164 == null) goto L216;
        r164.e = System.currentTimeMillis();
    L216:
        r154.invoke(Boolean.TRUE);
    L221:
        r0 = true;
        goto L227
    L217:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FirstScreenStatistic$readBitmapIntoImageView$1(r36, r150, r132, r154, r155, null), 3, null);
        goto L221
    L218:
        r30 = r30;
        r210 = r210;
        r212 = r212;
        r11 = r11;
        r49 = r214;
        r113 = r410;
        r213 = r110;
        if (FirstScreenStatistic.o == false) goto L226;
        dm.a.a("FirstScreenStatistic").a("no bitmap cache, fallback to simpleFrescoLoader " + ((String) r108.element));
        SimpleFrescoLoaderKt.b(r36, (String) r108.element, r109, r132, r213, r38, r39, r11, r49, r211);
        goto L221
    L182:
        r141 = r109;
        goto L183
    L172:
        dm.a.a("FirstScreenStatistic").a(ThreadMethodProxy.currentThread().getName() + " BeforeFirstScreen load url " + r136);
        goto L174
    L166:
        if (FirstScreenStatistic.a == false) goto L168;
        dm.a.a("FirstScreenStatistic").a("AfterFirstScreen repeatLoad url " + r136);
        goto L197
    L168:
        dm.a.a("FirstScreenStatistic").a("BeforeFirstScreen repeatLoad url " + r136);
    L197:
        r410 = "imageView";
        goto L199
    L137:
        if (r134.length() == 0) goto L140;
        r135 = false;
    L121:
        r106 = "";
        goto L122
    L229:
        r210 = r210;
        r30 = "ec_na_mall";
        r212 = "";
        r113 = "imageView";
        r49 = r10;
        r11 = r11;
        r213 = r110;
        goto L230
    L106:
        r36.setHierarchy(GenericDraweeHierarchyBuilder.newInstance(r36.getResources()).setPlaceholderImage(r48, ScalingUtils.ScaleType.CENTER_CROP).build());
    L108:
        r210 = r13;
        r211 = r12;
        goto L109
    L81:
        r35 = null;
        goto L83
    L77:
        r33 = r39;
    L107:
        r112 = r15;
    L72:
        r110 = r37;
        goto L73
    L257:
        r212 = "";
        r210 = r13;
        r211 = r12;
        r49 = r10;
        r11 = r11;
        goto L259
    L25:
        r14 = false;
        goto L26
    L21:
        r13 = r44;
        goto L22
    L17:
        r1 = r43;
        goto L19
    L13:
        r12 = r42;
        goto L15
    L9:
        r10 = r41;
        goto L11
    L5:
        r11 = r40;
        goto L7
    }

    public static final void z(final String r16, final r r17, final Integer r18, final Integer r19, final Bitmap.Config r20, Priority r21, final RequestListener r22, final Postprocessor r23, final boolean r24, final String r25) {
        Intrinsics.checkNotNullParameter(r16, "$this$prefetchImageToCache");
        final long r10 = System.nanoTime();
        final Ref.ObjectRef r11 = new Ref.ObjectRef();
        r11.element = r21;
        final Ref.BooleanRef r12 = new Ref.BooleanRef();
        r12.element = false;
        AsyncPrefetchImage r0 = AsyncPrefetchImage.i;
        Function1<Boolean, Unit> r15 = new ImageExtensionsKt$prefetchImageToCache$1(r16, r18, r19, r17, r10, r11, r12, r20, r23, r25, r22, r24);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r15, "block");
        if (((Boolean) AsyncPrefetchImage.e.getValue()).booleanValue() == false) goto L8;
        Executor r1 = AsyncWorker.a;
        if (AsyncWorker.a() == false) goto L8;
        AsyncPrefetchImage.h.execute(new com.bytedance.android.ec.core.imagex.common.v.a(Integer.valueOf(((Number) AsyncPrefetchImage.f.getValue()).intValue()), new com.bytedance.android.ec.core.imagex.opt.g(r15)));
        return;
    L8:
        r15.invoke(Boolean.valueOf(((Boolean) AsyncPrefetchImage.c.getValue()).booleanValue()));
    }

    public static ImageRequest n(String r10, r r11, ResizeOptions r12, Bitmap.Config r13, Postprocessor r14, Priority r15, String r16, RequestListener r17, Boolean r18, boolean r19, int r110) {
        if ((r110 & 2) == 0) goto L5;
        ResizeOptions r1 = null;
    L7:
        if ((r110 & 4) == 0) goto L9;
        Bitmap.Config r20 = null;
    L11:
        if ((r110 & 8) == 0) goto L13;
        Postprocessor r21 = null;
    L15:
        if ((r110 & 16) == 0) goto L17;
        Priority r22 = null;
    L19:
        if ((r110 & 32) == 0) goto L21;
        String r23 = null;
    L23:
        if ((r110 & 64) == 0) goto L25;
        RequestListener r24 = null;
    L27:
        if ((r110 & 128) == 0) goto L29;
        Boolean r0 = null;
    L30:
        if (r10 != null) goto L32;
    L35:
        boolean r25 = true;
    L36:
        if (r25 == true) goto L40;
        ImageRequestBuilder r26 = ImageRequestBuilder.newBuilderWithSource(c(r10));
        E(r26, r11, r1, r20, r21);
        F(r26, r11, r22, r23, r24, r0);
        return r26.build();
    L40:
        return null;
    L32:
        if (StringsKt.isBlank(r10) == true) goto L35;
        r25 = false;
        goto L36
    L29:
        r0 = r18;
        goto L30
    L25:
        r24 = r17;
        goto L27
    L21:
        r23 = r16;
        goto L23
    L17:
        r22 = r15;
        goto L19
    L13:
        r21 = r14;
        goto L15
    L9:
        r20 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    public static final void s(GenericDraweeView r15, String r16, ImageRequest r17, r r18, Integer r19, Integer r20, Bitmap.Config r21, Postprocessor r22, ControllerListener<? super ImageInfo> r23, boolean r24, Priority r25, Function1<? super DraweeController, Unit> r26, String r27) {
        Intrinsics.checkNotNullParameter(r15, "$this$load");
        Intrinsics.checkNotNullParameter(r16, com.bytedance.android.ec.core.event.a.KEY_URL);
        x(r15, CollectionsKt.listOf(r16), r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, 4096);
    }

    public static /* synthetic */ void w(GenericDraweeView r16, String r17, ImageRequest r18, r r19, Integer r20, Integer r21, Bitmap.Config r22, Postprocessor r23, ControllerListener r24, boolean r25, Priority r26, Function1 r27, int r28) {
        if ((r28 & 2) == 0) goto L5;
        ImageRequest r10 = null;
    L7:
        if ((r28 & 4) == 0) goto L9;
        r r11 = null;
    L11:
        if ((r28 & 8) == 0) goto L13;
        Integer r12 = null;
    L15:
        if ((r28 & 16) == 0) goto L17;
        Integer r13 = null;
    L19:
        if ((r28 & 32) == 0) goto L21;
        Bitmap.Config r14 = null;
    L23:
        if ((r28 & 64) == 0) goto L25;
        Postprocessor r15 = null;
    L27:
        if ((r28 & 128) == 0) goto L29;
        ControllerListener r110 = null;
    L31:
        if ((r28 & 256) == 0) goto L33;
        boolean r111 = true;
    L35:
        if ((r28 & 512) == 0) goto L37;
        Priority r112 = null;
    L39:
        if ((r28 & 1024) == 0) goto L41;
        Function1 r113 = null;
    L42:
        s(r16, r17, r10, r11, r12, r13, r14, r15, r110, r111, r112, r113, null);
        return;
    L41:
        r113 = r27;
        goto L42
    L37:
        r112 = r26;
        goto L39
    L33:
        r111 = r25;
        goto L35
    L29:
        r110 = r24;
        goto L31
    L25:
        r15 = r23;
        goto L27
    L21:
        r14 = r22;
        goto L23
    L17:
        r13 = r21;
        goto L19
    L13:
        r12 = r20;
        goto L15
    L9:
        r11 = r19;
        goto L11
    L5:
        r10 = r18;
        goto L7
    }

    public static final void r(GenericDraweeView r15, ECUrlModel r16, ImageRequest r17, r r18, Integer r19, Integer r20, Bitmap.Config r21, Postprocessor r22, ControllerListener<? super ImageInfo> r23, boolean r24, Priority r25, Function1<? super DraweeController, Unit> r26, String r27, ECImageLoadConfig r28) {
        Intrinsics.checkNotNullParameter(r15, "$this$load");
        Intrinsics.checkNotNullParameter(r16, "urlModel");
        List<String> r0 = r16.getUrlList();
        if (r0 != null) goto L5;
        r0 = c;
    L5:
        List<String> r10 = r0;
        if (r10.isEmpty() == false) goto L9;
        if (r17 != null) goto L9;
        return;
    L9:
        t(r15, r10, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public static final void t(final GenericDraweeView r26, List<String> r27, final ImageRequest r28, r r29, Integer r30, Integer r31, final Bitmap.Config r32, final Postprocessor r33, ControllerListener<? super ImageInfo> r34, final boolean r35, final Priority r36, final Function1<? super DraweeController, Unit> r37, final String r38, ECImageLoadConfig r39) {
        Intrinsics.checkNotNullParameter(r26, "$this$load");
        Intrinsics.checkNotNullParameter(r27, "originList");
        ImageRequest[] r10 = null;
        if (((Boolean) ImageSettings.e.getValue()).booleanValue() == false) goto L15;
        if (r26 == null) goto L15;
        Object r1 = r26.getTag(2131370764);
        if ((r1 instanceof Disposable) == true) goto L9;
        r1 = null;
    L9:
        Disposable r11 = (Disposable) r1;
        if (r11 == null) goto L15;
        if (r11.isDisposed() == true) goto L14;
        r11.dispose();
    L14:
        r26.setController(Fresco.newDraweeControllerBuilder().setOldController(r26.getController()).build());
    L15:
        final ResizeOptions r14 = i(r30, r31);
        final u r12 = k(r26, r29);
        r12.C(r14);
        r12.B();
        r12.o = com.bytedance.android.ec.core.event.a.VALUE_NATIVE;
        String r13 = r12.f;
        ImageExperiments.G.getClass();
        if (((HashSet) ImageExperiments.v.getValue()).contains(r13) != true) goto L19;
        ECImageX.c(r26, r27, r28, r12, r14, r32, r33, r34, r35, r36, r37, r38);
        return;
    L19:
        String r15 = (String) CollectionsKt.firstOrNull(r27);
        if (r15 == null) goto L35;
        Lazy r16 = ECImageX.a;
        if (StringsKt.startsWith$default(r15, "https://", false, 2, null) == false) goto L24;
    L27:
        boolean r17 = true;
    L29:
        if ((!r17) != true) goto L35;
        ImageRequest[] r0 = o(r27, r12, r14, r32, r33, r36, r38, false, 192);
        if (r0 != null) goto L33;
        r0 = new ImageRequest[0];
    L33:
        y(r26, r0, r28, r12, r34, r35, r37, false, null, 192);
        return;
    L24:
        if (StringsKt.startsWith$default(r15, "http://", false, 2, null) == true) goto L27;
        r17 = false;
    L35:
        Lazy r18 = AsyncLoadImage.a;
        if (((Boolean) AsyncLoadImage.b.getValue()).booleanValue() == true) goto L38;
    L63:
        List r19 = n0.a(l(), r27, r14, r12, r39, false, 48);
        Function2<List<? extends String>, ControllerListener<? super ImageInfo>, Unit> r110 = new ImageExtensionsKt$load$fetchImage$1(r26, r12, r14, r32, r33, r36, r38, r28, r35, r37);
        Intrinsics.checkNotNullParameter(r26, "$this$setAutoUseAlternateDomain");
        Intrinsics.checkNotNullParameter(r19, "urlList");
        Intrinsics.checkNotNullParameter(r110, "onRetry");
        cj.b r20 = (cj.b) b.getValue(null, a[0]);
        if (r20 == null) goto L66;
        r20.b();
    L66:
        r110.invoke(r19, r34);
        return;
    L38:
        if ((!r27.isEmpty()) == false) goto L63;
        long r24 = System.nanoTime();
        Intrinsics.checkNotNullParameter(r27, "originList");
        Intrinsics.checkNotNullParameter(r12, "realCallerContext");
        if (r27.isEmpty() == false) goto L42;
        com.bytedance.android.ec.core.imagex.opt.t0.d r21 = null;
        int r22 = 0;
    L54:
        u r23 = s.a(r12);
        if (r23 == null) goto L57;
        r23.f("ec_local_duration_async_build_init", Float.valueOf(com.bytedance.android.ec.core.imagex.common.e.a(r24)));
    L57:
        if (r21 == null) goto L69;
        ImageRequest[] r25 = r21.b;
        if (r25 != null) goto L61;
        r25 = new ImageRequest[r22];
    L61:
        y(r26, r25, r28, r12, r34, r35, r37, false, r21, 64);
        return;
    L69:
        return;
    L42:
        List r40 = n0.a(l(), r27, r14, r12, r39, ((Boolean) AsyncLoadImage.c.getValue()).booleanValue(), 32);
        ArrayList r41 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r40, 10));
        Iterator r42 = r40.iterator();
    L44:
        if (r42.hasNext() == false) goto L47;
        r41.add(c((String) r42.next()));
        goto L44
    L47:
        if ((!r41.isEmpty()) == false) goto L49;
        ArrayList r210 = r41;
    L50:
        int r43 = com.bytedance.android.ec.core.imagex.opt.t0.d;
        r22 = 0;
        a0 r44 = new a0(r12, r14, r32, r33, r210, r27, r39, r36, r38, r28, r210);
        Intrinsics.checkNotNullParameter(r44, "builder");
        ImageRequestBuilder r45 = r44.a();
        if (r45 == null) goto L53;
        r10 = new ImageRequest[]{r45.build()};
        r44.c.compareAndSet(true, false);
    L53:
        r21 = new com.bytedance.android.ec.core.imagex.opt.t0.d(r44, r10);
        goto L54
    L49:
        r210 = null;
        goto L50
    }

    public static /* synthetic */ void x(GenericDraweeView r17, List r18, ImageRequest r19, r r20, Integer r21, Integer r22, Bitmap.Config r23, Postprocessor r24, ControllerListener r25, boolean r26, Priority r27, Function1 r28, String r29, int r30) {
        if ((r30 & 2) == 0) goto L5;
        ImageRequest r10 = null;
    L7:
        if ((r30 & 4) == 0) goto L9;
        r r11 = null;
    L11:
        if ((r30 & 8) == 0) goto L13;
        Integer r12 = null;
    L15:
        if ((r30 & 16) == 0) goto L17;
        Integer r13 = null;
    L19:
        if ((r30 & 32) == 0) goto L21;
        Bitmap.Config r14 = null;
    L23:
        if ((r30 & 64) == 0) goto L25;
        Postprocessor r15 = null;
    L27:
        if ((r30 & 128) == 0) goto L29;
        ControllerListener r16 = null;
    L31:
        if ((r30 & 256) == 0) goto L33;
        boolean r110 = true;
    L35:
        if ((r30 & 512) == 0) goto L37;
        Priority r111 = null;
    L39:
        if ((r30 & 1024) == 0) goto L41;
        Function1 r112 = null;
    L43:
        if ((r30 & 2048) == 0) goto L45;
        String r113 = null;
    L46:
        t(r17, r18, r10, r11, r12, r13, r14, r15, r16, r110, r111, r112, r113, null);
        return;
    L45:
        r113 = r29;
        goto L46
    L41:
        r112 = r28;
        goto L43
    L37:
        r111 = r27;
        goto L39
    L33:
        r110 = r26;
        goto L35
    L29:
        r16 = r25;
        goto L31
    L25:
        r15 = r24;
        goto L27
    L21:
        r14 = r23;
        goto L23
    L17:
        r13 = r22;
        goto L19
    L13:
        r12 = r21;
        goto L15
    L9:
        r11 = r20;
        goto L11
    L5:
        r10 = r19;
        goto L7
    }
}
