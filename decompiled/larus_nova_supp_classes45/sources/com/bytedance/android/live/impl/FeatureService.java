package com.bytedance.android.live.impl;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.LongSparseArray;
import com.bytedance.android.live.base.model.message.n5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.k0;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.feature.config.LiveFeatureConfig;
import com.bytedance.android.live.impl.applogListener.FeatureApplogListener;
import com.bytedance.android.live.impl.logInterceptor.ShuffleSequenceInterceptor;
import com.bytedance.android.live.impl.logfilter.DeviceFeatureFilter;
import com.bytedance.android.live.impl.logfilter.RealtimeSequenceFilter;
import com.bytedance.android.live.impl.logfilter.SkipSequenceHelper;
import com.bytedance.android.live.impl.logfilter.UserFeatureInRoomFilter;
import com.bytedance.android.live.impl.logfilter.e;
import com.bytedance.android.live.impl.logfilter.f;
import com.bytedance.android.live.impl.logfilter.r;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.live.impl.service.FeedFeatureManager;
import com.bytedance.android.live.impl.service.LivePortraitCenterService;
import com.bytedance.android.live.impl.service.RoomService;
import com.bytedance.android.live.impl.utils.LimitSizeQueue;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomStats;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.android.livesdkapi.model.LiveUnifyBoxConfig;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Flowable;
import j40.a2;
import j40.c0;
import j40.n3;
import j40.t2;
import j40.u2;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import py.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bK\u0010LJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010%\u001a\u00020$2\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010&\u001a\u00020$H\u0016J\u0010\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010'H\u0016J\u001a\u0010-\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016J\u001a\u0010.\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016J\u001a\u0010/\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016J\u001a\u00100\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016J\u0012\u00101\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\b\u00102\u001a\u00020\u0007H\u0016J\b\u00103\u001a\u00020\u0002H\u0016J\u0012\u00104\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u00106\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u00105\u001a\u00020 H\u0016J\"\u00109\u001a\u00020\u00072\u0006\u0010,\u001a\u00020$2\u0006\u00107\u001a\u00020$2\b\u00108\u001a\u0004\u0018\u00010\"H\u0016R\u001c\u0010<\u001a\n ;*\u0004\u0018\u00010:0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R#\u0010C\u001a\n ;*\u0004\u0018\u00010>0>8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010H\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010I¨\u0006M"}, d2 = {"Lcom/bytedance/android/live/impl/FeatureService;", "Lcom/bytedance/android/live/feature/api/IFeatureService;", "", "asyncInit", "Lkotlin/Function0;", "Lcom/bytedance/android/livesdk/log/g;", "liveLoggerSupplier", "", "initService", "addSendLogFilter", "realInit", "addFilter", "addShuffleSequenceInterceptor", "addFeatureInterceptor", "addApplogListener", "addFeatureLogLogicFeatureProvider", "setupLivePortraitCenterService", "init", "Lz90/a;", "getFeatureManager", "", "listener", "setFeatureImListener", "setByteLinkListener", "Lz90/b;", "getFeedFeatureManager", "Lz90/c;", "getLivePortraitCenterService", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", NewBroadcastMonitor.PAGE.ROOM, "handleRoom", "unifyHandleRoom", "", "type", "Lorg/json/JSONObject;", "extraParams", "", "getRealtimeSequenceJson", "getSkipSequenceJson", "Ljava/lang/ref/WeakReference;", "getWeakRoom", "Landroid/os/Bundle;", "bundle", "", "roomId", "onLivePlayActivityCreate", "onLivePlayActivityDestroy", "onDetailModelStartRoom", "onDetailModelStopRoom", "onLiveRoomFragmentCreate", "onLiveRoomFragmentDestroy", "featureServiceHaveInit", "onPreviewVHShow", "roomIndex", "saveUnreadRoomFeature", "enterFromMerge", "featuresInfo", "addShuffleSequenceFeature", "Lcom/bytedance/android/live/feature/config/LiveFeatureConfig;", "kotlin.jvm.PlatformType", "liveFeatureConfig", "Lcom/bytedance/android/live/feature/config/LiveFeatureConfig;", "Lcom/bytedance/android/livesdkapi/model/LiveUnifyBoxConfig;", "unifyBoxConfig$delegate", "Lkotlin/Lazy;", "getUnifyBoxConfig", "()Lcom/bytedance/android/livesdkapi/model/LiveUnifyBoxConfig;", "unifyBoxConfig", "startTime", "J", "serviceInited", "Z", "featureImListener", "Ljava/lang/Object;", "byteLinkListener", "<init>", "()V", "livefeature-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class FeatureService implements IFeatureService {
    private Object byteLinkListener;
    private Object featureImListener;
    private final LiveFeatureConfig liveFeatureConfig;
    private volatile boolean serviceInited;
    private final long startTime;
    private final Lazy unifyBoxConfig$delegate;

    public static final class a implements Runnable {
        public final /* synthetic */ FeatureService a;
        public final /* synthetic */ Function0 b;

        public a(FeatureService r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FeatureService.access$addSendLogFilter(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ FeatureService a;
        public final /* synthetic */ Function0 b;

        public b(FeatureService r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FeatureService.access$addSendLogFilter(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ FeatureService a;
        public final /* synthetic */ Function0 b;

        public c(FeatureService r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FeatureService.access$addSendLogFilter(this.a, this.b);     // Catch: Throwable -> L4
            FeatureService.access$realInit(this.a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    private final LiveUnifyBoxConfig getUnifyBoxConfig() {
        return (LiveUnifyBoxConfig) this.unifyBoxConfig$delegate.getValue();
    }

    private final void addApplogListener() {
        c0 r0 = c0.a;
        if (r0.getValue().getFeatureApplogListenerEnable() == false) goto L12;
        FeatureApplogListener r1 = FeatureApplogListener.b;
        if (r0.getValue().getFeatureApplogListenerEnable() == false) goto L13;
        IMiddleHostService r2 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r2 == null) goto L14;
        IMiddlewareHostAction r3 = r2.action();
        if (r3 == null) goto L15;
        r3.addAppLogLiveListener(r1, (Set) FeatureApplogListener.a.getValue());
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    private final void addFeatureInterceptor() {
        if (c0.a.getValue().getFeatureInterceptorEnable() == false) goto L10;
        Integer r0 = com.bytedance.android.live.impl.logInterceptor.a.a;
        IMiddleHostService r1 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r1 == null) goto L11;
        IMiddlewareHostAction r2 = r1.action();
        if (r2 == null) goto L12;
        r2.addLiveFeatureInterceptor(com.bytedance.android.live.impl.logInterceptor.a.h);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void addFeatureLogLogicFeatureProvider() {
        if (c0.a.getValue().getFeatureLogLogicFeatureProviderEnable() == false) goto L10;
        ConcurrentHashMap<String, IMiddlewareHostAction.ILiveLogLogicFeatureProvider> r0 = com.bytedance.android.live.impl.applogListener.a.a;
        IMiddleHostService r1 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r1 == null) goto L11;
        IMiddlewareHostAction r2 = r1.action();
        if (r2 == null) goto L12;
        r2.addLogLogicFeatureProviders(com.bytedance.android.live.impl.applogListener.a.a);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void addFilter() {
        CopyOnWriteArraySet<f> r0 = com.bytedance.android.live.impl.logfilter.c.a;
        com.bytedance.android.live.impl.logfilter.c.a(com.bytedance.android.live.impl.logfilter.b.c);
        com.bytedance.android.live.impl.logfilter.c.a(UserFeatureInRoomFilter.y1);
        com.bytedance.android.live.impl.logfilter.c.a(DeviceFeatureFilter.O);
        com.bytedance.android.live.impl.logfilter.c.a(r.a);
        if (a2.a.getValue().isEnable() == false) goto L6;
        com.bytedance.android.live.impl.logfilter.c.a(RealtimeSequenceFilter.A);
    L6:
        if (n3.a.getValue().a() == false) goto L9;
        com.bytedance.android.live.impl.logfilter.c.a(e.g);
        return;
    }

    private final void addShuffleSequenceInterceptor() {
        if (u2.a.getValue().intValue() <= 0) goto L62;
        ShuffleSequenceInterceptor r0 = ShuffleSequenceInterceptor.l;
        r0.getClass();
        Iterator<String> r1 = ShuffleSequenceInterceptor.f.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        String r2 = r1.next();
        ShuffleSequenceInterceptor.i.add(r2);
        goto L6
    L8:
        t2 r3 = t2.a;
        if (r3.getValue().getEnableUploadLiveRevenueFeature() == false) goto L28;
        Map r4 = r3.getValue().getLiveRevenueFeaturesMap();
        if (r4 == null) goto L19;
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator r6 = r4.entrySet().iterator();
    L14:
        if (r6.hasNext() == false) goto L18;
        Map.Entry r7 = (Map.Entry) r6.next();
        if (((Boolean) r7.getValue()).booleanValue() == false) goto L14;
        r5.put(r7.getKey(), r7.getValue());
        goto L14
    L18:
        Set r8 = r5.keySet();
    L20:
        if (r8 == null) goto L23;
        List r9 = CollectionsKt.toList(r8);
        if (r9 == null) goto L23;
    L24:
        Iterator r11 = r9.iterator();
    L26:
        if (r11.hasNext() == false) goto L28;
        String r12 = (String) r11.next();
        ShuffleSequenceInterceptor.i.add(r12);
    L23:
        r9 = CollectionsKt.emptyList();
        goto L24
    L19:
        r8 = null;
    L28:
        u2 r13 = u2.a;
        Integer r14 = r13.getValue();
        if (r14 != null) goto L32;
    L33:
        Integer r15 = r13.getValue();
        if (r15 != null) goto L37;
    L43:
        Integer r16 = r13.getValue();
        if (r16 != null) goto L47;
    L48:
        Integer r17 = r13.getValue();
        if (r17 != null) goto L52;
        return;
    L52:
        if (r17.intValue() != 3) goto L78;
    L54:
        Iterator<String> r18 = ShuffleSequenceInterceptor.i.iterator();
    L56:
        if (r18.hasNext() == false) goto L79;
        String r19 = r18.next();
        IMiddleHostService r21 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r21 == null) goto L56;
        IMiddlewareHostAction r22 = r21.action();
        if (r22 == null) goto L56;
        r22.addSequenceItemProvider(r19, r0);
        goto L56
    L79:
        return;
    L78:
        return;
    L47:
        if (r16.intValue() == 1) goto L54;
    L37:
        if (r15.intValue() != 2) goto L43;
    L38:
        IMiddleHostService r23 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r23 == null) goto L43;
        IMiddlewareHostAction r24 = r23.action();
        if (r24 == null) goto L43;
        r24.addShuffleSequenceProvider(r0);
        goto L43
    L32:
        if (r14.intValue() == 1) goto L38;
    }

    private final void realInit() {
        FeatureManager.u.getClass();
        IUtilsCommonService r0 = k.f(IUtilsCommonService.class);
        boolean r1 = false;
        String r2 = null;
        if (r0 == null) goto L5;
        Float r3 = Float.valueOf(r0.deviceScoreHelperGetScore(false));
    L6:
        FeatureManager.q("device_score", r3);
        IUtilsCommonService r4 = k.f(IUtilsCommonService.class);
        if (r4 == null) goto L9;
        Float r5 = Float.valueOf(r4.deviceScoreHelperGetScore(true));
    L10:
        FeatureManager.q("anchor_device_score", r5);
        FeatureManager.q("system_version", Integer.valueOf(Build.VERSION.SDK_INT));
        IMiddlewareUserService r6 = k.f(IMiddlewareUserService.class);
        if (r6 == null) goto L17;
        com.bytedance.android.livesdk.user.e r7 = r6.user();
        if (r7 == null) goto L17;
        String r8 = r7.n();
        if (r8 == null) goto L17;
    L18:
        FeatureManager.q("user_id", r8);
        IMiddleWareHostContext r9 = k.f(IMiddleWareHostContext.class);
        if (r9 == null) goto L23;
        String r11 = r9.getServerDeviceId();
        if (r11 == null) goto L23;
    L24:
        FeatureManager.q("device_id", r11);
        if (PadConfigUtils.c() == false) goto L27;
        int r12 = 2;
    L28:
        FeatureManager.q("device_type", Integer.valueOf(r12));
        FeatureManager.q("last_play_resolution_key", new Property("audience_resolution_last_play_resolution_key", "").getValue());
        String r13 = Build.BRAND;
        Locale r14 = Locale.ROOT;
        if (r13 == null) goto L78;
        FeatureManager.q("device_brand", r13.toLowerCase(r14));
        String r15 = Build.MODEL;
        if (r15 == null) goto L76;
        FeatureManager.q("device_model", r15.toLowerCase(r14));
        Class r16 = FeatureManager.k();     // Catch: Throwable -> L38
        Object r17 = r16.getMethod("getOsBrand", new Class[0]).invoke(r16, new Object[0]);     // Catch: Throwable -> L38
        if (r17 == null) goto L39;
        boolean r18 = StringsKt.equals("harmony", r17.toString(), true);     // Catch: Throwable -> L38
    L40:
        FeatureManager.q("is_harmony", Boolean.valueOf(r18));
        IMiddleWareHostContext r19 = k.f(IMiddleWareHostContext.class);
        if (r19 == null) goto L45;
        String r21 = r19.getChannel();
        if (r21 == null) goto L45;
        r2 = r21.toLowerCase(Locale.ROOT);
    L45:
        FeatureManager.q("app_channel", r2);
        FeatureManager.q("is_in_inner_live", Boolean.FALSE);
        FeatureManager.q("is_fold_device", Boolean.valueOf(FoldScreenUtils.f()));
        FeatureManager.q("fold_type", Integer.valueOf(FoldScreenUtils.a()));
        FeatureManager.q("watch_live_orientation", Boolean.valueOf(e5.l()));
        FeatureManager.q("aweme_live_preview_pcu", 0L);
        IMiddlewareHostBusiness r22 = k.f(IMiddlewareHostBusiness.class);
        if (r22 == null) goto L48;
        boolean r23 = r22.hasCellularPermission();
    L49:
        FeatureManager.q("has_cellular_permission", Boolean.valueOf(r23));
        k0 r24 = FeatureManager.q;
        JSONObject r25 = r24.b("store_features");
        if (r25 == null) goto L53;
        FeatureManager.r("", r25);
    L53:
        IMiddlewareUserService r26 = k.f(IMiddlewareUserService.class);
        if (r26 == null) goto L63;
        com.bytedance.android.livesdk.user.e r27 = r26.user();
        if (r27 == null) goto L63;
        FeatureManager r28 = FeatureManager.u;
        int r29 = !r27.isLogin() ? 1 : 0;
        Handler r31 = UtilityKotlinExtentionsKt.a;
        Integer r32 = Integer.valueOf(r29);
        r28.getClass();
        FeatureManager.q("user_login_status", r32);
        JSONObject r33 = r24.b("user_features");
        if (r33 == null) goto L60;
        FeatureManager.r("user_features", r33);
    L60:
        Flowable r34 = r27.m().onBackpressureLatest();
        if (r34 == null) goto L63;
        r34.subscribe(com.bytedance.android.live.impl.service.e.a);
    L63:
        c0 r35 = c0.a;
        if (r35.getValue().getFeatureTestEnable() == false) goto L66;
        i0.c().post(FeatureManager.s);
    L66:
        Map<String, Object> r36 = r35.getValue().getTimerUpdateFeatureMap();
        if (r36 != null) goto L69;
    L70:
        r1 = true;
    L71:
        if (r1 == true) goto L73;
        i0.c().postDelayed(FeatureManager.t, n5.DEFAULT_SHOW_DURATION);
    L73:
        addFilter();
        addApplogListener();
        addFeatureLogLogicFeatureProvider();
        addFeatureInterceptor();
        setupLivePortraitCenterService();
        addShuffleSequenceInterceptor();
        FeatureManager.u.i("feature_service_init_duration", Long.valueOf(System.currentTimeMillis() - this.startTime), FeatureType.STATIC);
        boolean r37 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.d("LFM-FeatureService", new C03191(this));
        return;
    L69:
        if (r36.isEmpty() == false) goto L71;
    L48:
        r23 = false;
    L39:
        r18 = false;
        goto L40
    L76:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L78:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L27:
        r12 = 1;
    L23:
        r11 = "";
    L17:
        r8 = "";
        goto L18
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    private final void setupLivePortraitCenterService() {
        c0 r0 = c0.a;
        if (r0.getValue().getPortraitCenterEnable() == true) goto L5;
        return;
    L5:
        if (r0.getValue().getPortraitCenterSetupEnable() == false) goto L9;
        LivePortraitCenterService r1 = LivePortraitCenterService.b;
        LivePortraitCenterService.b();
        return;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public z90.c getLivePortraitCenterService() {
        if (c0.a.getValue().getPortraitCenterEnable() == true) goto L5;
        return null;
    L5:
        return LivePortraitCenterService.b;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public WeakReference<IRoom> getWeakRoom() {
        WeakReference<IRoom> r0 = RoomService.a;
        return RoomService.a;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void onLiveRoomFragmentDestroy() {
        int r0 = com.bytedance.android.live.impl.service.a.b;
        com.bytedance.android.live.impl.service.a.a--;
        FeatureManager r1 = FeatureManager.u;
        if (com.bytedance.android.live.impl.service.a.a <= 0) goto L5;
        boolean r2 = true;
    L6:
        r1.i("is_in_inner_live", Boolean.valueOf(r2), FeatureType.MONITOR);
        return;
    L5:
        r2 = false;
        goto L6
    }

    public FeatureService() {
        this.liveFeatureConfig = c0.a.getValue();
        this.unifyBoxConfig$delegate = LazyKt.lazy(FeatureService$unifyBoxConfig$2.INSTANCE);
        this.startTime = System.currentTimeMillis();
        if (k.h(IFeatureService.class) == true) goto L6;
        k.l(IFeatureService.class, this);
        return;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public String getSkipSequenceJson() {
        return SkipSequenceHelper.b();
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public boolean featureServiceHaveInit() {
        return this.serviceInited;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public z90.a getFeatureManager() {
        return FeatureManager.u;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public z90.b getFeedFeatureManager() {
        return FeedFeatureManager.c;
    }

    public static final /* synthetic */ LiveFeatureConfig access$getLiveFeatureConfig$p(FeatureService r0) {
        return r0.liveFeatureConfig;
    }

    public static final /* synthetic */ long access$getStartTime$p(FeatureService r2) {
        return r2.startTime;
    }

    public static final /* synthetic */ void access$realInit(FeatureService r0) {
        r0.realInit();
    }

    private final void addSendLogFilter(Function0<? extends g> r3) {
        final boolean r4 = ((g) r3.invoke()).addSendLogFilter("LFM-FeatureService", com.bytedance.android.live.impl.logfilter.c.b);
        boolean r0 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.a("LFM-FeatureService", new AnonymousClass1(r4));
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void handleRoom(IRoom r2) {
        if (getUnifyBoxConfig().getHandleRoomMove() == true) goto L5;
    L6:
        RoomService.c(r2);
        return;
    L5:
        if (LiveUnifyBoxConfig.Companion.getUnifyServiceInit() == false) goto L6;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void onLiveRoomFragmentCreate(Bundle r6) {
        int r7 = com.bytedance.android.live.impl.service.a.b;
        com.bytedance.android.live.impl.service.a.a++;
        FeatureManager r8 = FeatureManager.u;
        if (com.bytedance.android.live.impl.service.a.a <= 0) goto L5;
        boolean r0 = true;
    L6:
        r8.i("is_in_inner_live", Boolean.valueOf(r0), FeatureType.MONITOR);
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void onPreviewVHShow(IRoom r2) {
        if (n3.a.getValue().a() == false) goto L6;
        e.g.getClass();
        e.f = r2;
        return;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void setByteLinkListener(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.byteLinkListener = r2;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void setFeatureImListener(Object r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.featureImListener = r2;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void unifyHandleRoom(IRoom r1) {
        RoomService.c(r1);
    }

    public static final /* synthetic */ void access$addSendLogFilter(FeatureService r0, Function0 r1) {
        r0.addSendLogFilter(r1);
    }

    private final void initService(final boolean r5, Function0<? extends g> r6) {
        if (this.serviceInited == false) goto L5;
        return;
    L5:
        this.serviceInited = true;
        if (r5 == false) goto L8;
        addSendLogFilter(r6);
        realInit();
    L20:
        boolean r7 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.d("LFM-FeatureService", new AnonymousClass4(this, r5));
        return;
    L8:
        int r1 = this.liveFeatureConfig.getInitType();
        if (r1 == 0) goto L19;
        if (r1 != 1) goto L12;
        i0.c().postDelayed(new b(this, r6), 1000);
        realInit();
        goto L20
    L12:
        if (r1 != 2) goto L14;
        addSendLogFilter(r6);
        realInit();
        goto L20
    L14:
        if (r1 != 3) goto L20;
        TTExecutors.getSerialThreadPool().submit(new c(this, r6));
        goto L20
    L19:
        i0.c().post(new a(this, r6));
        realInit();
        goto L20
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public String getRealtimeSequenceJson(int r2, JSONObject r3) {
        return RealtimeSequenceFilter.A.c(r2, r3);
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void init(boolean r2, Function0<? extends g> r3) {
        Intrinsics.checkNotNullParameter(r3, "liveLoggerSupplier");
        initService(r2, r3);
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void onDetailModelStartRoom(Bundle r1, long r2) {
        e.g.getClass();
        e.e = r2;
        e.f = null;
        e.c.add(new LimitSizeQueue(e.b.d()));
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void onDetailModelStopRoom(Bundle r1, long r2) {
        e.g.getClass();
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void onLivePlayActivityCreate(Bundle r1, long r2) {
        int r3 = com.bytedance.android.live.impl.service.a.b;
        if (n3.a.getValue().a() == false) goto L6;
        e.g.getClass();
        e.e = r2;
        e.f = null;
        e.c.add(new LimitSizeQueue(e.b.d()));
        return;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void onLivePlayActivityDestroy(Bundle r1, long r2) {
        int r3 = com.bytedance.android.live.impl.service.a.b;
        if (n3.a.getValue().a() == false) goto L6;
        e.g.getClass();
        e.d.clear();
        FeatureManager.u.g("live_selected_position");
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [int] */
    /* JADX WARN: Type inference failed for: r8v3 */
    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void saveUnreadRoomFeature(IRoom r18, int r19) {
        Intrinsics.checkNotNullParameter(r18, NewBroadcastMonitor.PAGE.ROOM);
        if (n3.a.getValue().a() == false) goto L53;
        e.g.getClass();
        Intrinsics.checkNotNullParameter(r18, NewBroadcastMonitor.PAGE.ROOM);
        LongSparseArray r1 = (LongSparseArray) FeatureManager.u.getFeature("live_room_type", new LongSparseArray());     // Catch: Exception -> L48
        ConcurrentHashMap<Long, JSONObject> r3 = e.d;     // Catch: Exception -> L48
        Long r4 = Long.valueOf(r18.getRoomId());     // Catch: Exception -> L48
        ?? r5 = new JSONObject();     // Catch: Exception -> L48
        r5.put("room_id", r18.getId());     // Catch: Exception -> L48
        r5.put("room_user_count", r18.getUserCount());     // Catch: Exception -> L48
        IRoomStats r7 = r18.getStats();     // Catch: Exception -> L48
        ?? r8 = 0;
        if (r7 == null) goto L8;
        int r9 = r7.getTotalUser();     // Catch: Exception -> L48
    L9:
        r5.put("room_total_user_count", r9);     // Catch: Exception -> L48
        IBaseUser r11 = r18.getOwner();     // Catch: Exception -> L48
        long r12 = 0;
        if (r11 == null) goto L14;
        j r13 = r11.getFollowInfo();     // Catch: Exception -> L48
        if (r13 == null) goto L14;
        long r14 = r13.getFollowStatus();     // Catch: Exception -> L48
    L15:
        r5.put("follow_status", r14);     // Catch: Exception -> L48
        String r15 = (String) r1.get(r18.getRoomId());     // Catch: Exception -> L48
        if (r15 == null) goto L19;
        List r2 = StringsKt.split$default(r15, new String[]{","}, false, 0, 6, null);     // Catch: Exception -> L48
        if (r2 == null) goto L19;
    L20:
        r5.putOpt("room_tags", new JSONArray(r2));     // Catch: Exception -> L48
        r5.put("live_room_type", e.h(r18));     // Catch: Exception -> L48
        String r6 = r18.getItemExplicitInfo();     // Catch: Exception -> L48
        String r16 = "";
        if (r6 != null) goto L24;
        r6 = "";
    L24:
        r5.put("live_recommend_info", r6);     // Catch: Exception -> L48
        r5.put("room_position", r19);     // Catch: Exception -> L48
        r5.put("live_mode", r18.getStreamType().ordinal());     // Catch: Exception -> L48
        IBaseUser r17 = r18.getOwner();     // Catch: Exception -> L48
        if (r17 == null) goto L29;
        j r21 = r17.getFollowInfo();     // Catch: Exception -> L48
        if (r21 == null) goto L29;
        long r110 = r21.getFollowerCount();     // Catch: Exception -> L48
    L30:
        r5.put("anchor_fans_count", r110);     // Catch: Exception -> L48
        IBaseUser r22 = r18.getOwner();     // Catch: Exception -> L48
        if (r22 == null) goto L35;
        j r23 = r22.getFollowInfo();     // Catch: Exception -> L48
        if (r23 == null) goto L35;
        r12 = r23.getFollowingCount();     // Catch: Exception -> L48
    L35:
        r5.put("anchor_follow_count", r12);     // Catch: Exception -> L48
        IBaseUser r24 = r18.getOwner();     // Catch: Exception -> L48
        if (r24 == null) goto L38;
        int r25 = r24.getGender();     // Catch: Exception -> L48
    L39:
        r5.put("anchor_gender", r25);     // Catch: Exception -> L48
        String r26 = r18.getAnchorId();     // Catch: Exception -> L48
        if (r26 == null) goto L43;
        r16 = r26;
    L43:
        r5.put("anchor_id", r16);     // Catch: Exception -> L48
        com.bytedance.android.livesdk.strategy.a r0 = r18.getAdStrategyFeatures();     // Catch: Exception -> L48
        if (r0 == null) goto L46;
        boolean r27 = r0.a();     // Catch: Exception -> L48
        Handler r28 = UtilityKotlinExtentionsKt.a;     // Catch: Exception -> L48
        r8 = r27;
    L46:
        r5.put("live_is_ad", r8);     // Catch: Exception -> L48
        Unit r29 = Unit.INSTANCE;     // Catch: Exception -> L48
        r3.put(r4, (JSONObject) r5);     // Catch: Exception -> L48
        return;
    L38:
        r25 = 0;
    L29:
        r110 = 0;
    L19:
        r2 = CollectionsKt.emptyList();     // Catch: Exception -> L48
    L14:
        r14 = 0;
        goto L15
    L8:
        r9 = 0;
    L48:
        e = move-exception;
        ALogger.e("LiveTabGuideFeatureFilter", String.valueOf(e));
        return;
    }

    @Override // com.bytedance.android.live.feature.api.IFeatureService
    public void addShuffleSequenceFeature(String r4, String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r4, "roomId");
        Intrinsics.checkNotNullParameter(r5, "enterFromMerge");
        ShuffleSequenceInterceptor.l.getClass();
        Intrinsics.checkNotNullParameter(r4, "roomId");
        Intrinsics.checkNotNullParameter(r5, "enterFromMerge");
        Pair r0 = new Pair(r4, r5);
        HashMap r7 = (HashMap) ShuffleSequenceInterceptor.a;
        if (r7.containsKey(r0) == true) goto L5;
        r7.put(r0, new LinkedHashMap());
    L5:
        Map r8 = (Map) r7.get(r0);
        if (r6 == null) goto L13;
        Iterator<String> r9 = r6.keys();
    L9:
        if (r9.hasNext() == false) goto L19;
        String r1 = r9.next();
        if (r8 == null) goto L9;
        r8.put(r1, r6.get(r1));
        goto L9
    L19:
        return;
    }
}
