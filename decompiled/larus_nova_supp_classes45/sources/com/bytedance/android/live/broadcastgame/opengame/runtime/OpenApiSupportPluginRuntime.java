package com.bytedance.android.live.broadcastgame.opengame.runtime;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.i0;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor;
import com.bytedance.android.live.broadcastgame.opengame.lynx.LynxOpenPlugin;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.opengame.network.OpenGameApi;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.SonicGamePlugin;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.IHostService;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.depend.openplatform.IHostOpenPlatformGameService;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.utils.o1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class OpenApiSupportPluginRuntime extends w implements n {
    public static final /* synthetic */ int u = 0;
    public y n;
    public u10.e o;
    public final Lazy p;
    public boolean q;
    public String r;
    public com.bytedance.android.live.broadcastgame.opengame.utils.d s;
    public final com.bytedance.android.live.broadcastgame.opengame.f t;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ OpenApiSupportPluginRuntime a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Integer c;

        public b(OpenApiSupportPluginRuntime r1, String r2, Integer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r5) {
            g r6 = (g) r5;
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"fetch bootinfo success, transfer state", ", appId: ", this.b});
            com.bytedance.android.live.broadcastgame.opengame.utils.d r1 = this.a.s;
            if (r1 == null) goto L14;
            Integer r2 = this.c;
            if (r2 == null) goto L14;
            int r3 = r2.intValue();
            monitor-enter(r1);
            Long r4 = r1.b.remove(Integer.valueOf(r3));     // Catch: Throwable -> L11
            monitor-exit(r1);
        L11:
            th = move-exception;
            throw th;
        L14:
            int r7 = x10.a.a;
            x10.a.C0290a.C0291a r8 = x10.a.a(this.a.u(), "bootconfig");
            r8.a(GamePromoteDataContext.GAME_TYPE_MOBILE);
            new x10.a.C0290a(r8).a();
            ((OpenPlatformMonitorService) this.a.u().o(OpenPlatformMonitorService.class)).d(false, 0, null, null);
            y r9 = this.a.n;
            if (r9 == null) goto L20;
            r9.a(new y.b.a(r6));
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ OpenApiSupportPluginRuntime a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Integer c;

        public c(OpenApiSupportPluginRuntime r1, String r2, Integer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r9) {
            Throwable r11 = (Throwable) r9;
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"fetch remote bootinfo failed, appId: ", this.b, "error: ", r11});
            com.bytedance.android.live.broadcastgame.opengame.utils.d r1 = this.a.s;
            if (r1 == null) goto L14;
            Integer r4 = this.c;
            if (r4 == null) goto L14;
            int r5 = r4.intValue();
            monitor-enter(r1);
            Long r6 = r1.b.remove(Integer.valueOf(r5));     // Catch: Throwable -> L11
            monitor-exit(r1);
        L11:
            th = move-exception;
            throw th;
        L14:
            OpenApiSupportPluginRuntime r2 = this.a;
            String r7 = this.b;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r7, "appId");
            HashMap r3 = (HashMap) com.bytedance.android.livesdk.sharedpref.b.y2.getValue();
            if (r3.containsKey(r7) == false) goto L17;
            j r8 = (j) JsonUtil.parse((String) r3.get(r7), new z().getType());
        L19:
            if (r8 == null) goto L24;
            com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"fetch local bootinfo success, transfer state"});
            y r12 = this.a.n;
            if (r12 == null) goto L23;
            r12.a(new y.b.a(new g("", r8)));
        L23:
            int r13 = x10.a.a;
            x10.a.C0290a.C0291a r14 = x10.a.a(this.a.u(), "bootconfig");
            r14.a(GamePromoteDataContext.GAME_TYPE_MOBILE);
            r14.a.put("param4", IInteractGameMonitorService.LOCAL_SOURCE);
            new x10.a.C0290a(r14).a();
            ((OpenPlatformMonitorService) this.a.u().o(OpenPlatformMonitorService.class)).d(true, 0, null, null);
            return;
        L24:
            int r15 = x10.a.a;
            x10.a.C0290a.C0291a r16 = x10.a.a(this.a.u(), "bootconfig");
            r16.a("-1");
            new x10.a.C0290a(r16).a();
            ((OpenPlatformMonitorService) this.a.u().o(OpenPlatformMonitorService.class)).d(false, 1, Integer.valueOf(com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r11)), o1.a(r11));
            y r17 = this.a.n;
            if (r17 == null) goto L31;
            r17.a(new y.b.C0080b("bootconfig fail, appId: " + this.b));
            return;
        L31:
            return;
        L17:
            r8 = null;
            goto L19
        }
    }

    static {
        com.bytedance.android.livesdk.log.u.l().register(com.bytedance.android.live.broadcastgame.api.c.class, new com.bytedance.android.live.broadcastgame.opengame.g());
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void a() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"hide plugin, transfer state"});
        y r1 = this.n;
        if (r1 == null) goto L6;
        r1.a(y.b.c.a);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void k() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"retry plugin, transfer state, appId: ", u().m.i});
        y r1 = this.n;
        if (r1 == null) goto L5;
        r1.a(y.b.f.a);
    L5:
        OpenPlatformMonitorService r2 = (OpenPlatformMonitorService) u().o(OpenPlatformMonitorService.class);
        OpenPlatformMonitorUtils.a = -1;
        OpenPlatformMonitorUtils.a = -1;
        OpenPlatformMonitorService.b(r2, "ttlive_open_platform_retry", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, 28).c();
        u().u("is_retry", Boolean.TRUE);
        if (this.k == true) goto L8;
        this.f = true;
    L8:
        com.bytedance.android.live.broadcastgame.opengame.t r3 = r();
        g r5 = r3.l;
        if (r5 == null) goto L13;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"boot info has successfully requested, transfer state"});
        y r6 = this.n;
        if (r6 == null) goto L14;
        r6.a(new y.b.a(r5));
    L14:
        File r7 = r3.m;
        String r8 = null;
        if (r7 == null) goto L19;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"resource has downloaded, transfer state, file: " + r7});
        y r4 = this.n;
        if (r4 == null) goto L20;
        r4.a(new y.b.e(r7));
    L20:
        int r9 = GameDataReportHelper.a;
        Map r11 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("game_name", u().m.b(u().o)), TuplesKt.to("game_id", u().m.i), TuplesKt.to("game_type", u().m.o.name())});
        IUserService r12 = jc1.k.f(IUserService.class);
        if (r12 == null) goto L25;
        com.bytedance.android.livesdk.user.f r13 = r12.user();
        if (r13 == null) goto L25;
        r8 = r13.n();
    L25:
        r11.put("user_id", r8);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_retry", r11, new Object[]{Room.class, am2.x.class});
        return;
    L19:
        t().e(getContext(), r3.n, null, this);
        goto L20
    L13:
        v();
        goto L14
    }

    public final u10.b w() {
        if (this.o != null) goto L6;
        this.o = new u10.e(new u10.k(r().i, r().j));
    L6:
        if (r().m == null) goto L14;
        u10.e r0 = this.o;
        if (r0 == null) goto L14;
        int r1 = com.bytedance.android.live.broadcastgame.opengame.utils.j.a;
        File r2 = r().m;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNullParameter(r2, "res");
        com.bytedance.android.live.broadcastgame.opengame.lynx.b r3 = com.bytedance.android.live.broadcastgame.opengame.utils.j.c(FilesKt.resolve(r2, "config.json"));
        if (r3 == null) goto L12;
        long r4 = r3.c;
    L13:
        r0.g(r4);
        goto L14
    L12:
        r4 = 60000;
    L14:
        u10.e r5 = this.o;
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final String h() {
        g r0 = ((BootInfoService) u().o(BootInfoService.class)).c();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public void launch() {
        super.launch();
        InteractGameContext.Companion r0 = InteractGameContext.Companion;
        InteractGameContext r1 = r0.getContext();
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.n<Boolean> r2 = r1.getHasOpenGameLaunch();
        if (r2 == null) goto L7;
        r2.setValue(Boolean.TRUE);
    L7:
        InteractGameContext r3 = r0.getContext();
        if (r3 == null) goto L31;
        com.bytedance.live.datacontext.n<i0> r4 = r3.getCurrentOpenPlatformAppInfo();
        if (r4 == null) goto L31;
        String r5 = r().i;
        String r6 = r().b(this.k);
        PluginType.a r7 = PluginType.Companion;
        PluginType r8 = r().o;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "$this$toInteractId");
        PluginType r9 = PluginType.a.b(Integer.valueOf(r8.getValue()));
        if (r9 == null) goto L20;
        int r11 = com.bytedance.android.live.broadcastgame.api.openplatform.j.a[r9.ordinal()];
        if (r11 != 1) goto L17;
        InteractID r12 = InteractID.OpenGame;
    L24:
        i0 r13 = new i0(r5, r6, r12);
        Object r14 = r().k.get("OPEN_APP_ICON_URL");
        if ((r14 instanceof String) == true) goto L27;
        r14 = null;
    L27:
        String r15 = (String) r14;
        if (r15 != null) goto L30;
        r15 = "";
    L30:
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        r13.a = r15;
        Unit r16 = Unit.INSTANCE;
        r4.setValue(r13);
        goto L31
    L17:
        if (r11 != 2) goto L19;
        r12 = InteractID.OpenMicroApp;
        goto L24
    L19:
        if (r11 != 3) goto L20;
        r12 = InteractID.SonicMiniGame;
    L20:
        r12 = InteractID.Unknown;
    L31:
        CloudExecutor r17 = (CloudExecutor) this.p.getValue();
        int r18 = CloudExecutor.d;
        r17.e(new com.bytedance.android.live.broadcastgame.opengame.cloud.c());
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public void stop() {
        super.stop();
        CloudExecutor r0 = (CloudExecutor) this.p.getValue();
        r0.a.clear();
        com.bytedance.android.live.broadcastgame.opengame.cloud.f r1 = r0.d();
        r1.c.b();
        r1.b.clear();
        ALogger.i("CloudNetworkExecutor_release", "release finish");
        InteractGameContext.Companion r2 = InteractGameContext.Companion;
        InteractGameContext r3 = r2.getContext();
        if (r3 == null) goto L7;
        com.bytedance.live.datacontext.n<Boolean> r4 = r3.getHasOpenGameLaunch();
        if (r4 == null) goto L7;
        r4.setValue(Boolean.FALSE);
    L7:
        InteractGameContext r5 = r2.getContext();
        if (r5 == null) goto L12;
        com.bytedance.live.datacontext.n<i0> r6 = r5.getCurrentOpenPlatformAppInfo();
        if (r6 == null) goto L12;
        r6.setValue(null);
    L12:
        this.t.b();
        com.bytedance.android.live.broadcastgame.opengame.utils.d r7 = this.s;
        if (r7 == null) goto L19;
        String r8 = this.r;
        if (r8 != null) goto L17;
        r8 = "unknown";
    L17:
        Intrinsics.checkNotNullParameter(r8, "stopReason");
        Observable.just(Long.valueOf(System.nanoTime())).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.live.broadcastgame.opengame.utils.c(r7, r8));
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void stopGameCastToAudience() {
        k r0 = t();
        if ((r0 instanceof SonicGamePlugin) == true) goto L6;
        r0 = null;
    L6:
        if (((SonicGamePlugin) r0) == null) goto L12;
        k r1 = t();
        if (r1 == null) goto L11;
        ((SonicGamePlugin) r1).b(false);
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.opengame.sonicgame.SonicGamePlugin");
    L12:
        a();
    }

    public final void v() {
        String r0 = r().i;
        int r1 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"fetch bootinfo, appId:" + r0});
        com.bytedance.android.live.broadcastgame.opengame.utils.d r2 = this.s;
        if (r2 == null) goto L12;
        int r3 = r2.a;
        r2.a = r3 + 1;
        monitor-enter(r2);
        r2.b.put(Integer.valueOf(r3), Long.valueOf(System.nanoTime()));     // Catch: Throwable -> L9
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r2);
        Integer r5 = Integer.valueOf(r3);
    L13:
        int r6 = x10.a.a;
        x10.a.C0290a.C0291a r7 = x10.a.a(u(), "bootconfig");
        r7.a("0");
        new x10.a.C0290a(r7).a();
        BootInfoService r8 = (BootInfoService) u().o(BootInfoService.class);
        long r9 = this.j;
        PluginType r11 = u().m.o;
        Intrinsics.checkNotNullParameter(r0, "appId");
        Intrinsics.checkNotNullParameter(r11, "pluginType");
        Lazy r12 = LiveOpenGameClient.d;
        Disposable r13 = ((OpenGameApi) LiveOpenGameClient.a.a().a(OpenGameApi.class)).getBootConfig(r0, r9).map(new h(r8, r0)).observeOn(Schedulers.io()).subscribe(new b(this, r0, r5), new c(this, r0, r5));
        Intrinsics.checkNotNullParameter(r13, "$this$autoDispose");
        this.m.a(r13);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        r5 = null;
        goto L13
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"stop plugin, transfer state", ", reason: ", r4});
        this.r = r4;
        y r5 = this.n;
        if (r5 == null) goto L5;
        r5.a(y.b.h.a);
    L5:
        com.bytedance.android.livesdk.log.filter.o r6 = com.bytedance.android.livesdk.log.u.l().c(com.bytedance.android.live.broadcastgame.api.c.class);
        if (r6 == null) goto L9;
        r6.setData(null);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void c(boolean r4) {
        k r0 = t();
        if ((r0 instanceof SonicGamePlugin) == true) goto L5;
        r0 = null;
    L5:
        SonicGamePlugin r1 = (SonicGamePlugin) r0;
        if (r1 == null) goto L13;
        if (r4 == false) goto L14;
        na4.c<com.bytedance.bdp.live.livecontainer.sonicgame.k, com.bytedance.bdp.live.livecontainer.sonicgame.b> r5 = r1.x();
        if (r5 == null) goto L11;
        r5.b(r1.K.m.i, null);
    L11:
        r1.D(false);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public void g(Map<String, String> r6) {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"show plugin, transfer state"});
        if (this.q == false) goto L5;
        u().u("first_launch", Boolean.FALSE);
    L5:
        this.q = true;
        y r1 = this.n;
        if (r1 == null) goto L8;
        r1.a(new y.b.g(r6));
    L8:
        String r7 = u().m.b(u().o);
        long r2 = u().m.h;
        String r3 = ((BootInfoService) u().o(BootInfoService.class)).e();
        com.bytedance.android.livesdk.log.filter.o r4 = com.bytedance.android.livesdk.log.u.l().c(com.bytedance.android.live.broadcastgame.api.c.class);
        if (r4 == null) goto L12;
        r4.setData(new com.bytedance.android.live.broadcastgame.api.c(r7, Long.valueOf(r2), r3));
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void j(String r4) {
        Intrinsics.checkNotNullParameter(r4, "errorMsg");
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"fail plugin, transfer state, error msg: ", r4});
        y r1 = this.n;
        if (r1 == null) goto L6;
        r1.a(new y.b.C0080b(r4));
        return;
    }

    public void onEventEnter(y.b r4) {
        Intrinsics.checkNotNullParameter(r4, "pluginEvent");
        if ((r4 instanceof y.b.a) == true) goto L5;
        return;
    L5:
        if (((y.b.a) r4).a.b.c == true) goto L20;
        com.bytedance.android.live.broadcastgame.opengame.f r5 = this.t;
        monitor-enter(r5);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (r5.a != 0) goto L15;
        r5.a++;     // Catch: Throwable -> L17
        if (r5.a != 1) goto L15;
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;     // Catch: Throwable -> L17
        com.bytedance.android.live.broadcastgame.opengame.q.g("游戏IM startFetchMessage", "");     // Catch: Throwable -> L17
        vlc.d r1 = r5.b;     // Catch: Throwable -> L17
        if (r1 == null) goto L15;
        r1.startMessage();     // Catch: Throwable -> L17
    L15:
        monitor-exit(r5);
        return;
    L20:
        int r6 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"IM is disabled"});
    }

    public void f(String r4, File r5) {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"download resource success, transfer state, appId: ", r4});
        y r6 = this.n;
        if (r6 == null) goto L6;
        r6.a(new y.b.e(r5));
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.n
    public final void n(String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "stage");
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"download resource fail, transfer state, appId: ", r7});
        y r1 = this.n;
        if (r1 == null) goto L13;
        StringBuilder r3 = new StringBuilder("download resource fail, appId: ");
        String r4 = "null";
        if (r7 != null) goto L7;
        String r5 = "null";
    L8:
        r3.append(r5);
        r3.append(", errorMsg: ");
        if (r8 == null) goto L12;
        r4 = r8;
    L12:
        r3.append(r4);
        r1.a(new y.b.C0080b(r3.toString()));
        goto L13
    L7:
        r5 = r7;
    L13:
        r r2 = this.e;
        if (r2 == null) goto L16;
        r2.n(r7, r8, r9);
    L16:
        f2.c("功能加载失败", 0);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void notifyStartLinkCastResult(boolean r3, Surface r4, int r5) {
        k r0 = t();
        if ((r0 instanceof SonicGamePlugin) == true) goto L5;
        r0 = null;
    L5:
        SonicGamePlugin r1 = (SonicGamePlugin) r0;
        if (r1 == null) goto L15;
        if (r3 == false) goto L16;
        na4.c<com.bytedance.bdp.live.livecontainer.sonicgame.k, com.bytedance.bdp.live.livecontainer.sonicgame.b> r6 = r1.x();
        if (r6 == null) goto L11;
        r6.b(r1.K.m.i, r4);
    L11:
        r1.D(true);
        na4.b r7 = r1.r;
        if (r7 == null) goto L17;
        Bundle r8 = new Bundle();
        r8.putInt("fps", r5);
        Unit r9 = Unit.INSTANCE;
        r7.a("command_set_sonic_preferred_fps", r8);
        return;
    L17:
        return;
    L16:
        return;
    }

    public OpenApiSupportPluginRuntime(Context r2, DataCenter r3, long r4, boolean r6, com.bytedance.android.live.broadcastgame.opengame.i r7, com.bytedance.android.live.broadcastgame.opengame.f r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        Intrinsics.checkNotNullParameter(r8, "gameIMManager");
        super(r2, r3, r4, r6, r7);
        this.t = r8;
        this.p = LazyKt.lazy(new OpenApiSupportPluginRuntime$cloudExecutor$2(this));
    }

    public final void x(long r17, String r19, String r21, String r22, PluginType r23, Map r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r19, "appId");
        Intrinsics.checkNotNullParameter(r21, "appVersion");
        Intrinsics.checkNotNullParameter(r22, "schema");
        Intrinsics.checkNotNullParameter(r23, "pluginType");
        Intrinsics.checkNotNullParameter(r24, "params");
        Intrinsics.checkNotNullParameter(r19, "appId");
        Intrinsics.checkNotNullParameter(r21, "appVersion");
        Intrinsics.checkNotNullParameter(r22, "schema");
        Intrinsics.checkNotNullParameter(r23, "pluginType");
        Intrinsics.checkNotNullParameter(r24, "params");
        this.f = r25;
        Object r1 = r24.get("metrics");
        if (r1 != null) goto L5;
        r1 = Boolean.FALSE;
    L5:
        if (r1 == null) goto L66;
        ((Boolean) r1).booleanValue();
        com.bytedance.android.live.broadcastgame.opengame.t r8 = new com.bytedance.android.live.broadcastgame.opengame.t(r17, r19, r21, r24, r22, r23);
        this.b = r8;
        r8.a = this.j;
        Object r2 = null;
        if (this.k == false) goto L15;
        com.bytedance.android.live.broadcastgame.api.model.u r3 = this.d;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("gameItem");
    L11:
        com.bytedance.android.live.broadcastgame.api.model.r r4 = r3.c();
        if (r4 == null) goto L14;
        String r5 = r4.j();
    L19:
        if (r5 != null) goto L21;
        r5 = "";
    L21:
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r8.b = r5;
        int r6 = com.bytedance.android.live.broadcastgame.api.interactgame.o.a;
        com.bytedance.android.live.broadcastgame.opengame.t r7 = this.b;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("currentPluginInfo");
    L24:
        String r9 = r7.b(this.k);
        com.bytedance.android.live.broadcastgame.opengame.t r11 = this.b;
        if (r11 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("currentPluginInfo");
    L27:
        int r12 = com.bytedance.android.live.broadcastgame.opengame.t.a.a(r11.n);
        com.bytedance.android.live.broadcastgame.opengame.t r13 = this.b;
        if (r13 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("currentPluginInfo");
    L31:
        if (this.k == false) goto L35;
        com.bytedance.android.live.broadcastgame.api.model.u r14 = r13.e();
        if (r14 == null) goto L42;
        r14.c();
    L42:
        Intrinsics.checkNotNullParameter(r19, "appId");
        Intrinsics.checkNotNullParameter(r9, "appName");
        com.bytedance.android.live.broadcastgame.api.interactgame.o.a = r12;
        System.currentTimeMillis();
        int r15 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePluginRuntime", new Object[]{"start plugin internal, is anchor: ", Boolean.valueOf(this.k), ", appId: ", r19, ", app version: ", r21, ", plugin type: ", r23});
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePluginRuntime", new Object[]{"create plugin context"});
        this.a = q(r24);
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePluginRuntime", new Object[]{"create plugin instance"});
        Intrinsics.checkNotNullParameter(r23, "pluginType");
        int r16 = x.a[r23.ordinal()];
        if (r16 == 1) goto L53;
        if (r16 == 2) goto L49;
        LocalTestManager.a(new Class[]{wy.a.class});
        PluginContext r18 = this.a;
        if (r18 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
    L48:
        LiveBasePluginWithPanel r26 = new LynxOpenPlugin(r18);
    L57:
        this.c = r26;
        u().u("first_launch", Boolean.TRUE);
        PluginContext r27 = u();
        Boolean r28 = Boolean.FALSE;
        r27.u("is_retry", r28);
        u().u("auto_launch", r28);
        com.bytedance.android.live.broadcastgame.opengame.q.f("OpenApiSupportPluginRuntime", new Object[]{"create stateMachine, start launch"});
        y r29 = new y(r(), this, new OpenApiSupportPluginRuntime$startPluginInternal$1(this));
        this.n = r29;
        r29.a(y.b.d.a);
        t().e(getContext(), r22, MapsKt.mapOf(TuplesKt.to("from_collect", Boolean.valueOf(Intrinsics.areEqual(r24.get("source"), 3)))), this);
        this.s = new com.bytedance.android.live.broadcastgame.opengame.utils.d(u());
        v();
        IHostService r31 = TTLiveSDK.hostService();
        if (r31 == null) goto L67;
        IHostApp r32 = r31.hostApp();
        if (r32 == null) goto L68;
        IHostOpenPlatformGameService r33 = r32.getOpenPlatformGameService();
        if (r33 == null) goto L69;
        r33.updateMicroRecord(r22);
        return;
    L69:
        return;
    L68:
        return;
    L67:
        return;
    L49:
        PluginContext r34 = this.a;
        if (r34 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
    L52:
        r26 = new SonicGamePlugin(r34);
        goto L57
    L53:
        PluginContext r35 = this.a;
        if (r35 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
    L56:
        r26 = new LynxOpenPlugin(r35);
        goto L57
    L35:
        Object r36 = r13.k.get("game_type");
        if ((r36 instanceof Integer) == false) goto L39;
        r2 = r36;
    L39:
        Integer r37 = (Integer) r2;
        if (r37 == null) goto L42;
        r37.intValue();
        goto L42
    L14:
        r5 = null;
        goto L19
    L15:
        Object r38 = r24.get("developer");
        if ((r38 instanceof String) == true) goto L18;
        r38 = null;
    L18:
        r5 = (String) r38;
        goto L19
    L66:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    }
}
