package com.bytedance.android.live.impl.logInterceptor;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livesdkapi.api.IUtilsCommonService;
import com.bytedance.android.livesdkapi.model.LivePreviewWormholePredictConfig;
import j40.f;
import java.util.ArrayList;
import java.util.HashSet;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class PreviewWormholePredictInterceptor implements z90.a.b, IMiddlewareHostAction.ILiveAppLogListener {
    public static final LivePreviewWormholePredictConfig a = null;
    public static volatile Long b;
    public static final PreviewWormholePredictInterceptor c = null;

    public PreviewWormholePredictInterceptor() {
    }

    static {
        PreviewWormholePredictInterceptor r0 = new PreviewWormholePredictInterceptor();
        c = r0;
        LivePreviewWormholePredictConfig r1 = f.a.getValue();
        a = r1;
        FeatureManager.u.e(r0, r1.runEventList);
        ArrayList r2 = r1.runEventList;
        if (r2 == null) goto L10;
        IMiddleHostService r3 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r3 == null) goto L11;
        IMiddlewareHostAction r4 = r3.action();
        if (r4 == null) goto L12;
        HashSet r5 = new HashSet();
        r5.addAll(r2);
        Unit r6 = Unit.INSTANCE;
        r4.addAppLogLiveListener(r0, r5);
        return;
    L12:
        return;
    L11:
        return;
    }

    public static boolean b(String r6) {
        LivePreviewWormholePredictConfig r0 = a;
        ArrayList r1 = r0.runEventList;
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.contains(r6) == true) goto L7;
        return false;
    L7:
        if (((Boolean) FeatureManager.u.getFeature("live_enter_preview_pre_room", Boolean.FALSE)).booleanValue() == false) goto L20;
        long r2 = System.currentTimeMillis();
        Long r7 = b;
        if (r7 == null) goto L11;
        long r4 = r7.longValue();
    L13:
        if ((r2 - r4) < r0.getPredictInterval()) goto L15;
        return true;
    L15:
        boolean r8 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.a("LAI-WormholePreview", PreviewWormholePredictInterceptor$isIntervalMet$1.INSTANCE);
        return false;
    L11:
        r4 = 0;
        goto L13
    L20:
        return false;
    }

    @Override // z90.a.b
    public final <T> void a(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        if (b(r2) == false) goto L6;
        c(r2, r3);
        return;
    }

    public final synchronized void c(final String r5, Object r6) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (b(r5) == false) goto L10;
        b = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L12
        boolean r0 = com.bytedance.android.live.impl.utils.a.a;     // Catch: Throwable -> L12
        com.bytedance.android.live.impl.utils.a.a("LAI-WormholePreview", new PreviewWormholePredictInterceptor$predict$1(r5));     // Catch: Throwable -> L12
        IFeatureService r1 = (IFeatureService) k.f(IFeatureService.class);     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        z90.a r2 = r1.getFeatureManager();     // Catch: Throwable -> L12
        if (r2 == null) goto L10;
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L12
        r3.putOpt("event_name", r5).putOpt("event_params", r6);     // Catch: Throwable -> L12
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L12
        r2.i("event_trigger_preview_wormhole_predict", r3, FeatureType.DYNAMIC_MONITOR);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    public final void handleAppLogEvent(final String r3, final JSONObject r4) {
        if (r3 == null) goto L7;
        IUtilsCommonService r0 = k.f(IUtilsCommonService.class);
        if (r0 == null) goto L8;
        r0.runOnUIThread(new PreviewWormholePredictInterceptor$handleAppLogEvent$$inlined$let$lambda$1(r3, r4));
        return;
    L8:
        return;
    }
}
