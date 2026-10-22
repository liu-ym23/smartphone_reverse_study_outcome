package com.bytedance.android.live.livepullstream.service;

import android.content.Context;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.platform.IHostUser;
import com.bytedance.android.livesdk.config.c21;
import com.bytedance.android.livesdk.config.p30;
import com.bytedance.android.livesdk.config.rj;
import com.bytedance.android.livesdkapi.init.LiveInitAssistant;
import com.bytedance.android.livesdkapi.service.ILiveCellularService;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.network.LSNetworkManager;
import com.ss.videoarch.strategy.network.LSSDKConfig;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements gl0.f {
    public static volatile boolean a;
    public static final JSONObject b = null;
    public static boolean c;
    public static final h d = null;

    public h() {
    }

    static {
        d = new h();
        b = new JSONObject();
    }

    public static void b() {
        if (a == true) goto L27;
        LiveInitAssistant.INSTANCE.markTimeStart("stream_strategy_init_duration");
        Context r0 = k.n(IHostContext.class).context().getApplicationContext();
        if (r0 == null) goto L26;
        LSNetworkManager.inst().init(new LSSDKConfig.Builder().setApiHost("https://i.snssdk.com").setHttpExecutor(new b()).build());
        LiveStrategyManager r4 = LiveStrategyManager.inst();
        JSONObject r6 = new JSONObject();
        r6.put("device_id", k.n(IHostContext.class).getServerDeviceId().toString());     // Catch: Exception -> L23
        if (tb1.c.a == false) goto L18;
        IHostService r7 = TTLiveSDK.hostService();     // Catch: Exception -> L23
        if (r7 == null) goto L18;
        IHostUser r8 = r7.user();     // Catch: Exception -> L23
        if (r8 == null) goto L18;
        String r9 = r8.getCurUserId();     // Catch: Exception -> L23
        if (r9 == null) goto L18;
        if (r6.put("user_id", r9) != null) goto L18;
        r6.put("user_id", String.valueOf(0));     // Catch: Exception -> L23
    L18:
        r6.put("channel", k.n(IHostContext.class).getChannel());     // Catch: Exception -> L23
        r6.put("host_aid", k.n(IHostContext.class).appId());     // Catch: Exception -> L23
        String r10 = k.n(IHostApp.class).getSessionId();     // Catch: Exception -> L23
        if (r10 != null) goto L21;
        r10 = "";
    L21:
        r6.put("app_session_id", r10);     // Catch: Exception -> L23
        r6.put("app_version", k.n(IHostContext.class).getVersionName());     // Catch: Exception -> L23
        r6.put("update_version_code", String.valueOf(k.n(IHostContext.class).getUpdateVersionCode()));     // Catch: Exception -> L23
    L25:
        r4.init(r0, r6);
        LiveStrategyManager.inst().setAppInfoBundle(new a());
        a = true;
    L23:
        e = move-exception;
        ALogger.e("StreamStrategyOptimizer", "build stream strategy info failed", e);
    L26:
        LiveInitAssistant.INSTANCE.markTimeEnd("stream_strategy_init_duration");
    L27:
        LiveStrategyManager.inst().start();
        com.ss.videoarch.live.b.f.a.getClass();
        LiveStrategyManager.inst().setIFunctionCalledByStrategyEngine(new com.ss.videoarch.live.b.g());
        rj r1 = rj.a;
        boolean r3 = ((c21) r1.getValue()).c();
        boolean r5 = ((c21) r1.getValue()).e();
        boolean r2 = ((c21) r1.getValue()).d();
        ILiveCellularService r11 = k.f(ILiveCellularService.class);
        if (r11 == null) goto L30;
        boolean r12 = r11.hasCellularPermission();
    L31:
        ILiveCellularService r13 = k.f(ILiveCellularService.class);
        if (r13 == null) goto L34;
        boolean r14 = r13.isPermissionLimite();
    L36:
        if (r12 == false) goto L39;
        if (r2 == false) goto L42;
        int r15 = 2;
    L44:
        c = r3;
        if (r3 == false) goto L54;
        JSONObject r16 = b;
        r16.put("multipath_network_status", 0);
        if (c == true) goto L49;
        r16.put("multipath_user_access_status", 3);
    L50:
        r16.put("multipath_user_toast", 1);
        TTExecutors.getNormalExecutor().submit(d.a);
        ALogger.e("LiveCellularService", "init, mJson:" + r16.toString());
        return;
    L49:
        r16.put("multipath_user_access_status", r15);
        goto L50
    L54:
        return;
    L42:
        r15 = 1;
        goto L44
    L39:
        if (r14 == true) goto L43;
        if (r5 == true) goto L42;
    L43:
        r15 = 3;
        goto L44
    L34:
        r14 = false;
        goto L36
    L30:
        r12 = false;
        goto L31
    }

    public final void a() {
        if (((Boolean) p30.a.getValue()).booleanValue() == false) goto L10;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L7;
        b();
        return;
    L7:
        TTExecutors.getNormalExecutor().submit(g.a);
        return;
    L10:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L12;
        b();
        return;
    L12:
        UtilityKotlinExtentionsKt.s(0, false, false, StreamStrategyOptimizer$startOnUiThread$1.INSTANCE, 7);
    }
}
