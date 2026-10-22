package com.bytedance.android.live.broadcastgame.opengame.service;

import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.p;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/OpenPlatformMonitorService;", "Ly10/a;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformMonitorService implements y10.a, p {
    public long a;
    public final Function1<JSONObject, Unit> b;
    public final Function1<JSONObject, Unit> c;
    public final Lazy d;
    public final PluginContext e;

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    @Override // y10.a
    public final void g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r1) {
    }

    public final void e() {
        b(this, "ttlive_open_platform_first_screen", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, 28).c();
        this.a = -1;
        if (this.e.m.o != PluginType.LYNX) goto L8;
        OpenPlatformMonitorUtils r0 = OpenPlatformMonitorUtils.c;
        OpenPlatformMonitorUtils.b = System.currentTimeMillis();
        if (OpenPlatformMonitorUtils.a <= 0) goto L8;
        m(OpenPlatformMonitorUtils.b - OpenPlatformMonitorUtils.a);
    L8:
        if (this.e.m.o != PluginType.SONIC_GAME) goto L11;
        m(System.currentTimeMillis() - OpenPlatformMonitorUtils.a);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
        b(this, "ttlive_open_platform_app_launch_start", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, 28).c();
        this.a = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
        b(this, "ttlive_open_platform_ready", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, 28).c();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        OpenPlatformMonitorUtils.a = -1;
        OpenPlatformMonitorUtils.b = -1;
        b(this, "ttlive_open_platform_exit", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, 28).c();
    }

    public OpenPlatformMonitorService(PluginContext r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        this.e = r3;
        this.a = -1;
        this.b = new OpenPlatformMonitorService$appParam$1(this);
        this.c = new OpenPlatformMonitorService$launchParam$1(this);
        this.d = LazyKt.lazy(new OpenPlatformMonitorService$launchFrom$2(this));
    }

    public final void f(final double r5) {
        com.bytedance.android.live.broadcastgame.api.openplatform.g r0 = b(this, "ttlive_open_platform_game_casting", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, 28);
        r0.b(new OpenPlatformMonitorService$logGameCasting$$inlined$apply$lambda$1(r5));
        r0.c();
    }

    public final void h(final double r5) {
        com.bytedance.android.live.broadcastgame.api.openplatform.g r0 = b(this, "ttlive_open_platform_game_running_fps", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, 28);
        r0.b(new OpenPlatformMonitorService$logGameRunningFps$$inlined$apply$lambda$1(r5));
        r0.c();
    }

    public final void m(final long r6) {
        if (this.e.o == false) goto L6;
        return;
    L6:
        if (OpenPlatformMonitorUtils.a >= 0) goto L8;
        return;
    L8:
        com.bytedance.android.live.broadcastgame.api.openplatform.g r0 = b(this, "ttlive_open_platform_perceived_launch_time", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, 28);
        Function1<com.bytedance.android.live.broadcastgame.api.openplatform.g, Unit> r1 = new OpenPlatformMonitorService$logPerceivedLaunchTimeForAudience$1(r6);
        Intrinsics.checkNotNullParameter(r1, "block");
        r1.invoke(r0);
        r0.c();
        OpenPlatformMonitorUtils.a = -1;
    }

    public static void n(OpenPlatformMonitorService r6, int r7) {
        r6.a("ttlive_open_platform_app_start", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r7, null, null).c();
    }

    public static void j(OpenPlatformMonitorService r7, String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "method");
        r7.o(r8, "ttlive_open_platform_pay_condition_check", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r9, null, null).c();
    }

    public static void k(OpenPlatformMonitorService r7, String r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "method");
        r7.o(r8, "ttlive_open_platform_pay_user_confirm", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r9, null, null).c();
    }

    public final void d(final boolean r7, int r8, Integer r9, String r11) {
        com.bytedance.android.live.broadcastgame.api.openplatform.g r12 = a("ttlive_open_platform_bootconfig", LiveTracingMonitor.EventType.SERVER_API_CALL, r8, r9, r11);
        Function1<com.bytedance.android.live.broadcastgame.api.openplatform.g, Unit> r13 = new OpenPlatformMonitorService$logFetchBootInfo$1(r7);
        Intrinsics.checkNotNullParameter(r13, "block");
        r13.invoke(r12);
        r12.c();
    }

    public final void i(String r9, int r11, Integer r12, String r13) {
        Intrinsics.checkNotNullParameter(r9, "method");
        o(r9, "ttlive_open_platform_openapi_check_permission", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r11, r12, r13).c();
    }

    public static /* synthetic */ com.bytedance.android.live.broadcastgame.api.openplatform.g b(OpenPlatformMonitorService r6, String r7, LiveTracingMonitor.EventType r8, int r9, int r11) {
        if ((r11 & 4) == 0) goto L5;
        int r3 = 0;
    L7:
        return r6.a(r7, r8, r3, null, null);
    L5:
        r3 = r9;
        goto L7
    }

    public static /* synthetic */ com.bytedance.android.live.broadcastgame.api.openplatform.g p(OpenPlatformMonitorService r7, String r8, String r9, LiveTracingMonitor.EventType r11, int r12) {
        return r7.o(r8, r9, r11, 0, null, null);
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.g a(String r2, LiveTracingMonitor.EventType r3, final int r4, final Integer r5, final String r6) {
        OpenPlatformMonitorUtils r0 = OpenPlatformMonitorUtils.c;
        com.bytedance.android.live.broadcastgame.api.openplatform.g r7 = OpenPlatformMonitorUtils.e(r2, r3, r4, (String) this.d.getValue());
        Function1<com.bytedance.android.live.broadcastgame.api.openplatform.g, Unit> r8 = new OpenPlatformMonitorService$launchEvent$1(this, r4, r5, r6);
        Intrinsics.checkNotNullParameter(r8, "block");
        r8.invoke(r7);
        return r7;
    }

    public final void c(int r9, final long r11, final int r12, final boolean r13, final String r14, final String r15) {
        Intrinsics.checkNotNullParameter(r14, "loadResult");
        com.bytedance.android.live.broadcastgame.api.openplatform.g r16 = b(this, "ttlive_open_platform_black_screen_monitor", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, r9, 24);
        Function1<com.bytedance.android.live.broadcastgame.api.openplatform.g, Unit> r7 = new OpenPlatformMonitorService$logBlackScreenCheck$1(r12, r13, r14, r15, r11);
        Intrinsics.checkNotNullParameter(r7, "block");
        r7.invoke(r16);
        r16.c();
    }

    public final com.bytedance.android.live.broadcastgame.api.openplatform.g o(final String r7, String r8, LiveTracingMonitor.EventType r9, int r11, Integer r12, String r13) {
        com.bytedance.android.live.broadcastgame.api.openplatform.g r14 = a(r8, r9, r11, r12, r13);
        Function1<com.bytedance.android.live.broadcastgame.api.openplatform.g, Unit> r15 = new OpenPlatformMonitorService$openApiEvent$1(r7);
        Intrinsics.checkNotNullParameter(r15, "block");
        r15.invoke(r14);
        return r14;
    }
}
