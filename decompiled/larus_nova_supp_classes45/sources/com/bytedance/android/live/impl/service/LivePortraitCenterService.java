package com.bytedance.android.live.impl.service;

import com.bytedance.android.live.feature.api.FeatureType;
import com.bytedance.android.live.impl.utils.json.JsonHelper;
import com.bytedance.android.livehostapi.IMiddleHostService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import j40.c0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LivePortraitCenterService implements z90.c {
    public static long a;
    public static final LivePortraitCenterService b = null;

    public LivePortraitCenterService() {
    }

    public final synchronized void a() {
        monitor-enter(this);
        c0 r0 = c0.a;     // Catch: Throwable -> L31
        List<Integer> r1 = r0.getValue().getPortraitCenterGetTypeList();     // Catch: Throwable -> L31
        if (r1 != null) goto L6;
    L29:
        monitor-exit(this);
        return;
    L6:
        if (r1.contains(2) != true) goto L29;
        if ((System.currentTimeMillis() - a) < r0.getValue().getPortraitCenterUpdateInterval()) goto L27;
        IMiddleHostService r2 = TTMiddlewareLiveSDK.hostMiddlewareService();     // Catch: Throwable -> L31
        if (r2 == null) goto L15;
        IMiddlewareHostAction r3 = r2.action();     // Catch: Throwable -> L31
        if (r3 == null) goto L15;
        final ConcurrentHashMap r4 = r3.getPortraits();     // Catch: Throwable -> L31
    L16:
        if (r4 == null) goto L24;
        JSONObject r5 = JsonHelper.d(r4);     // Catch: Throwable -> L31
        JSONObject r6 = (JSONObject) FeatureManager.u.getFeature("solaria_features", new JSONObject());     // Catch: Throwable -> L31
        Iterator<String> r7 = r5.keys();     // Catch: Throwable -> L31
    L19:
        if (r7.hasNext() == false) goto L22;
        String r8 = r7.next();     // Catch: Throwable -> L31
        r6.putOpt(r8, r5.optString(r8));     // Catch: Throwable -> L31
        goto L19
    L22:
        if (FeatureManager.u.i("solaria_features", r6, FeatureType.DYNAMIC) == false) goto L24;
        a = System.currentTimeMillis();     // Catch: Throwable -> L31
    L24:
        boolean r9 = com.bytedance.android.live.impl.utils.a.a;     // Catch: Throwable -> L31
        com.bytedance.android.live.impl.utils.a.a("LFM-LivePortraitCenter", new LivePortraitCenterService$getPortraits$2(r4));     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L15:
        r4 = null;
        goto L16
    L27:
        monitor-exit(this);
        return;
    L31:
        th = move-exception;
        throw th;
    }

    static {
        b = new LivePortraitCenterService();
        new ArrayList();
        new ConcurrentHashMap();
    }

    public static void b() {
        boolean r0 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.d("LFM-LivePortraitCenter", LivePortraitCenterService$setup$1.INSTANCE);
        IMiddleHostService r1 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r1 == null) goto L8;
        IMiddlewareHostAction r2 = r1.action();
        if (r2 == null) goto L9;
        r2.portraitCenterServiceSetup();
        return;
    L9:
        return;
    }

    @Override // z90.c
    public final String getPortrait(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        IMiddleHostService r0 = TTMiddlewareLiveSDK.hostMiddlewareService();
        if (r0 == null) goto L7;
        IMiddlewareHostAction r1 = r0.action();
        if (r1 == null) goto L7;
        final String r2 = r1.getPortrait(r3);
    L8:
        boolean r4 = com.bytedance.android.live.impl.utils.a.a;
        com.bytedance.android.live.impl.utils.a.a("LFM-LivePortraitCenter", new AnonymousClass1(r3, r2));
        return r2;
    L7:
        r2 = null;
        goto L8
    }
}
