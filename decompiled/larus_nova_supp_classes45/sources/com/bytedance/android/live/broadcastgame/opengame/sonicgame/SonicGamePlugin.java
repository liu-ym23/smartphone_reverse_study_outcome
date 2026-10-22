package com.bytedance.android.live.broadcastgame.opengame.sonicgame;

import android.content.Context;
import android.os.Bundle;
import androidx.collection.LruCache;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.opengame.openapi.g0;
import com.bytedance.android.live.broadcastgame.opengame.openapi.y;
import com.bytedance.android.live.broadcastgame.opengame.panel.FullScreenOpenPanel;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LaunchMode;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.n;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.checker.GameFpsMonitor;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.checker.PerformanceChecker;
import com.bytedance.android.live.broadcastgame.opengame.t;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.at0;
import com.bytedance.android.livesdk.config.fe0;
import com.bytedance.android.livesdk.config.ke0;
import com.bytedance.android.livesdk.config.me0;
import com.bytedance.android.livesdk.config.nh1;
import com.bytedance.android.livesdk.config.zc1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdp.bdpbase.core.IBdpAppInstance;
import com.bytedance.bdp.bdpbase.core.container.BdpAppContainer;
import com.bytedance.bdp.live.livecontainer.base.schema.LiveSchemaInfo;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class SonicGamePlugin extends LiveBasePluginWithPanel implements f {
    public static final /* synthetic */ int L = 0;
    public volatile boolean A;
    public volatile String B;
    public long C;
    public long D;
    public k E;
    public final boolean F;
    public final Lazy G;
    public boolean H;
    public final SonicGamePlugin$liveLifeCycle$1 I;
    public com.bytedance.android.live.broadcastgame.opengame.panel.h J;
    public final PluginContext K;
    public final Lazy q;
    public na4.b r;
    public String s;
    public SonicState t;
    public final com.bytedance.android.live.broadcastgame.openplatform.miniapp.b u;
    public final String v;
    public final String w;
    public final String x;
    public final List<Class<Object>> y;
    public volatile com.bytedance.android.live.broadcastgame.opengame.sonicgame.a z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/sonicgame/SonicGamePlugin$SonicState;", "", "RESUME", "PAUSE", "DESTROY", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SonicState extends Enum<SonicState> {
        public static final SonicState DESTROY = null;
        public static final SonicState PAUSE = null;
        public static final SonicState RESUME = null;
        public static final /* synthetic */ SonicState[] a = null;

        static {
            SonicState r1 = new SonicState("RESUME", 0);
            RESUME = r1;
            SonicState r2 = new SonicState("PAUSE", 1);
            PAUSE = r2;
            SonicState r3 = new SonicState("DESTROY", 2);
            DESTROY = r3;
            a = new SonicState[]{r1, r2, r3};
        }

        public static SonicState valueOf(String r1) {
            return (SonicState) r27.a.a(SonicState.class, r1);
        }

        public static SonicState[] values() {
            return (SonicState[]) a.clone();
        }

        public SonicState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b implements com.bytedance.bdp.live.livecontainer.sonicgame.b {
        public final /* synthetic */ SonicGamePlugin a;
        public final /* synthetic */ n b;

        public final void a(String r1, com.bytedance.bdp.live.livecontainer.sonicgame.h r2) {
            Intrinsics.checkNotNullParameter(r2, "instance");
        }

        public final void b() {
        }

        public final void onFirstFrame() {
        }

        public b(SonicGamePlugin r1, n r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onFail(String r9, String r11) {
            int r0 = q.a;
            q.f("SonicGamePlugin", new Object[]{"onDownloadFail, appId: ", r9, ", errorMsg: ", r11});
            ((OpenPlatformMonitorService) this.a.K.o(OpenPlatformMonitorService.class)).a("ttlive_open_platform_resource_download", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 1, 1, r11).c();
            n r1 = this.b;
            if (r1 == null) goto L6;
            r1.n(r9, r11, "Download");
            return;
        }
    }

    public static final class c {
        public final /* synthetic */ SonicGamePlugin a;

        public c(SonicGamePlugin r1) {
            this.a = r1;
        }
    }

    public static final class d implements com.bytedance.android.live.broadcastgame.opengame.panel.i {
        public final /* synthetic */ SonicGamePlugin a;

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void a() {
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void b() {
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void c() {
            this.a.u(SonicState.RESUME, true);
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void onBackPressed() {
            this.a.K.m.getClass();
            this.a.K.k.a();
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void onPanelCancel() {
            this.a.K.m.getClass();
            this.a.K.k.a();
        }

        public d(SonicGamePlugin r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel, com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void onStop() {
        b(false);
        if (jc1.k.n(IInteractService.class).isLinkCasting() == false) goto L5;
        jc1.k.n(IInteractService.class).onProgramStop();
    L5:
        MainThreadPostUtils.d(((GameFpsMonitor) ((PerformanceChecker) this.G.getValue()).a.getValue()).d);
        this.K.g = null;
        jc1.a.b().unregisterActivityLifecycleCallbacks(this.I);
        this.J = null;
        super.onStop();
        k r1 = this.E;
        if (r1 == null) goto L8;
        r1.b.clear();
        MainThreadPostUtils.d(r1.c);
    L8:
        this.E = null;
        int r2 = q.a;
        q.f("SonicGamePlugin", new Object[]{"transfer sonic state to destroy"});
        u(SonicState.DESTROY, false);
        t10.a r0 = this.u.a;
        na4.b r3 = r0.a;
        if (r3 == null) goto L11;
        r3.d();
    L11:
        r0.b.e();
        r0.a = null;
        if (((Boolean) at0.a.getValue()).booleanValue() == false) goto L28;
        na4.c<com.bytedance.bdp.live.livecontainer.sonicgame.k, com.bytedance.bdp.live.livecontainer.sonicgame.b> r4 = x();
        if ((r4 instanceof com.bytedance.bdp.live.livecontainer.sonicgame.j) == true) goto L17;
        r4 = null;
    L17:
        com.bytedance.bdp.live.livecontainer.sonicgame.j r5 = (com.bytedance.bdp.live.livecontainer.sonicgame.j) r4;
        if (r5 == null) goto L26;
        IBdpAppInstance r6 = r5.a;
        if (r6 == null) goto L27;
        r6.finish();
        BdpAppContainer r7 = r6.getAppContainer();
        if (r7 == null) goto L24;
        r7.a();
    L24:
        r5.a = null;
        return;
    L27:
        return;
    L26:
        return;
    }

    public final na4.c<com.bytedance.bdp.live.livecontainer.sonicgame.k, com.bytedance.bdp.live.livecontainer.sonicgame.b> x() {
        return (na4.c) this.q.getValue();
    }

    public final void A() {
        int r0 = q.a;
        q.f("SonicGamePlugin", new Object[]{"init sonic context"});
        JSONObject r1 = (JSONObject) this.K.g("game_config");
        if (r1 != null) goto L15;
    L8:
        final String r2 = "";
    L9:
        t(null, new SonicGamePlugin$initSonicContext$1(r2));     // Catch: JSONException -> L11
    L13:
        t(null, new SonicGamePlugin$initSonicContext$2(this));
        return;
    L11:
        e = move-exception;
        int r5 = q.a;
        q.f("SonicGamePlugin", new Object[]{"parse button color fail, error: ", e});
        goto L13
    L15:
        JSONObject r3 = JSONObjectProtectorUtils.getJSONObject(r1, "liveOpenConfig");     // Catch: JSONException -> L11
        if (r3 == null) goto L8;
        r2 = JSONObjectProtectorUtils.getString(r3, "panelMoreBtnColor");     // Catch: JSONException -> L11
        if (r2 != null) goto L9;
        goto L8
    }

    public final boolean B() {
        PluginContext r0 = this.K;
        if (r0.h(r0.r()) == GameCastStrategy.VIDEO_CHATROOM) goto L5;
    L7:
        return false;
    L5:
        if (jc1.k.n(IInteractService.class).isLinkCasting() == false) goto L7;
        return true;
    }

    public final boolean E() {
        if (((Boolean) me0.a.getValue()).booleanValue() == true) goto L32;
        com.bytedance.android.live.broadcastgame.opengame.runtime.g r0 = ((BootInfoService) this.K.o(BootInfoService.class)).c();
        if (r0 == null) goto L24;
        com.bytedance.android.live.broadcastgame.opengame.runtime.j r1 = r0.b;
        if (r1 == null) goto L24;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> r2 = r1.a;
        if (r2 == null) goto L24;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> r3 = r2;
        if ((r3 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r4 = r3.iterator();
    L17:
        if (r4.hasNext() == false) goto L21;
        if (Intrinsics.areEqual("openCloudGame", ((com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a) r4.next()).c()) == false) goto L17;
        boolean r5 = true;
    L22:
        if (r5 != true) goto L24;
        boolean r6 = true;
    L25:
        if (r6 == false) goto L33;
        return false;
    L33:
        return true;
    L21:
        r5 = false;
        goto L22
    L13:
        if (r3.isEmpty() == false) goto L15;
    L24:
        r6 = false;
        goto L25
    L32:
        return true;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel
    public final com.bytedance.android.live.broadcastgame.opengame.runtime.l m() {
        int r0 = q.a;
        q.f("SonicGamePlugin", new Object[]{"create panel factory, can switch screen: ", Boolean.valueOf(((BootInfoService) this.K.o(BootInfoService.class)).a())});
        int r1 = ((zc1) fe0.a.getValue()).b();
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L7;
        return new SonicGamePlugin$provideFactory$2(this);
    L7:
        if (((BootInfoService) this.K.o(BootInfoService.class)).a() == false) goto L14;
        return new i(this);
    L14:
        return new SonicGamePlugin$provideFactory$2(this);
    L11:
        return new i(this);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel, com.bytedance.android.live.broadcastgame.opengame.runtime.v, com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void onHide() {
        this.C += System.currentTimeMillis() - this.D;
        if (((nh1) ke0.a.getValue()).a() == false) goto L6;
        t(null, new SonicGamePlugin$checkBlackScreen$1(this));
    L6:
        super.onHide();
        if (E() == false) goto L10;
        int r0 = q.a;
        q.f("SonicGamePlugin", new Object[]{"transfer sonic state to pause"});
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel
    public final boolean q() {
        if (((zc1) fe0.a.getValue()).b() == 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService.b
    public final void s0() {
        int r0 = q.a;
        q.f("SonicGamePlugin", new Object[]{"on panel real show"});
        u(SonicState.RESUME, false);
        if (B() == false) goto L6;
        jc1.k.n(IInteractService.class).onProgramShow();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService.b
    public final void t0() {
        int r0 = q.a;
        q.f("SonicGamePlugin", new Object[]{"on panel real hide"});
        if (E() == false) goto L6;
        q.f("SonicGamePlugin", new Object[]{"transfer sonic state to pause"});
        u(SonicState.PAUSE, false);
    L6:
        if (B() == false) goto L9;
        jc1.k.n(IInteractService.class).onProgramHide();
        return;
    }

    public final f w() {
        if (this.z == null) goto L7;
        return this.z;
    L7:
        if (x() == null) goto L9;
        com.bytedance.android.live.broadcastgame.opengame.sonicgame.a r0 = new com.bytedance.android.live.broadcastgame.opengame.sonicgame.a(this.K, x(), new c(this));
    L10:
        this.z = r0;
        return this.z;
    L9:
        r0 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel, com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void onStart() {
        super.onStart();
        int r0 = q.a;
        q.f("SonicGamePlugin", new Object[]{"on lifecycle: onStart"});
        q.f("SonicGamePlugin", new Object[]{"inject open api"});
        y r1 = this.b;
        if (r1 == null) goto L6;
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.b r2 = this.u;
        PluginContext r3 = this.K;
        t r4 = r3.m;
        String r5 = r4.i;
        long r6 = r4.a;
        Context r7 = r3.getContext();
        LaunchMode r8 = this.a;
        t r9 = this.K.m;
        r1.a(r2, new g0(r5, r6, r7, r8, r9.h, r9.b(this.c)));
    L6:
        if (this.F == false) goto L11;
        k r11 = this.E;
        if (r11 == null) goto L10;
        r11.b.clear();
        MainThreadPostUtils.d(r11.c);
    L10:
        k r12 = new k(this.K);
        boolean r13 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.profit.scoreboard.h r14 = com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class);
        t r15 = r12.d.m;
        r14.S3(r15.i, r15.a, new l(r12));
        Unit r16 = Unit.INSTANCE;
        this.E = r12;
    L11:
        jc1.a.b().registerActivityLifecycleCallbacks(this.I);
        A();
    }

    public SonicGamePlugin(PluginContext r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        super(r3);
        this.K = r3;
        this.q = LazyKt.lazy(new SonicGamePlugin$pluginLauncher$2(this));
        this.u = new com.bytedance.android.live.broadcastgame.openplatform.miniapp.b(r3.getContext());
        this.v = "com.bytedance.android.ttlivesdk.live.LiveBgBroadcastActivity";
        this.w = "com.ss.android.ugc.aweme.live.LiveBgBroadcastActivity";
        this.x = "com.bytedance.android.livesdkproxy.activity.LiveBgBroadcastActivity";
        this.y = jc1.k.n(IHostApp.class).getAllLiveActivity();
        this.B = "sonic_game_load_unknown";
        if (r3.m.d(this.c) != 5) goto L5;
        boolean r4 = true;
    L6:
        this.F = r4;
        this.G = LazyKt.lazy(new SonicGamePlugin$performanceChecker$2(this));
        this.I = new SonicGamePlugin$liveLifeCycle$1(this);
        return;
    L5:
        r4 = false;
        goto L6
    }

    public final void D(boolean r6) {
        na4.b r0 = this.r;
        if (r0 == null) goto L10;
        Bundle r1 = new Bundle();
        r1.putString("event", "onAnchorShareScreen");
        JSONObject r2 = new JSONObject();
        if (r6 == false) goto L7;
        int r7 = 1;
    L8:
        r2.put("action", r7);
        r2.put("scene", 2);
        Unit r8 = Unit.INSTANCE;
        r1.putString("data", r2.toString());
        r0.a("command_send_event_to_js_core", r1);
        return;
    L7:
        r7 = 2;
        goto L8
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.sonicgame.f
    public final void b(boolean r2) {
        f r0 = w();
        if (r0 == null) goto L5;
        ((com.bytedance.android.live.broadcastgame.opengame.sonicgame.a) r0).b(r2);
    L5:
        this.z = null;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.sonicgame.f
    public final void g(boolean r2) {
        f r0 = w();
        if (r0 == null) goto L6;
        r0.g(r2);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel, com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void onShow(final Map<String, String> r3) {
        this.D = System.currentTimeMillis();
        super.onShow(r3);
        t(new AnonymousClass1(this, r3), AnonymousClass2.INSTANCE);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel
    public final void s(com.bytedance.android.live.broadcastgame.opengame.panel.h r11) {
        Intrinsics.checkNotNullParameter(r11, "panel");
        int r0 = q.a;
        q.f("SonicGamePlugin", new Object[]{"on panel create"});
        this.K.g = r11;
        this.J = r11;
        String r1 = jc1.k.n(IUserService.class).user().b().getIdString();
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, this.K.i, 0, 2);
        com.bytedance.android.live.broadcastgame.opengame.panel.h r3 = null;
        if (r2 == null) goto L9;
        m r4 = r2.getRoom();
        if (r4 == null) goto L9;
        Room r5 = (Room) r4.getValue();
        if (r5 == null) goto L9;
        String r6 = r5.getOwnerUserIdString();
    L10:
        com.bytedance.android.live.broadcastgame.opengame.panel.h r7 = this.J;
        if ((r7 instanceof FullScreenOpenPanel) == false) goto L14;
        r3 = r7;
    L14:
        FullScreenOpenPanel r8 = (FullScreenOpenPanel) r3;
        if (r8 == null) goto L21;
        t r9 = this.K.m;
        long r12 = r9.h;
        String r13 = r9.b(this.c);
        String r14 = ((BootInfoService) this.K.o(BootInfoService.class)).e();
        PluginContext r15 = this.K;
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r13, "gameName");
        Intrinsics.checkNotNullParameter(r14, "gameCategory");
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        r8.r = r6;
        r8.s = r1;
        r8.t = String.valueOf(r12);
        r8.u = r13;
        r8.v = r14;
        r8.w = r15;
    L21:
        r11.registerListener(new d(this));
        return;
    L9:
        r6 = null;
        goto L10
    }

    public final void y(final Function1<? super PanelType, Unit> r2) {
        t(null, new SonicGamePlugin$getScreenType$1(r2));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final <T> void sendEvent(String r5, T r6) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r6, "data");
        com.bytedance.android.live.broadcastgame.openplatform.miniapp.b r2 = this.u;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r6, "data");
        t10.a r3 = r2.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r6, "data");
        if (r3.b.f == true) goto L6;
        JSONObject r0 = new JSONObject();
        r0.put("eventName", r5);
        r0.put("data", r6);
        r3.b.f(r5, r0);
        return;
    }

    public final void u(SonicState r7, boolean r8) {
        int r0 = q.a;
        q.f("SonicGamePlugin", new Object[]{"sonic state change, cur state: ", this.t, ", to state: ", r7, ", force: ", Boolean.valueOf(r8), ", sonic instance: ", this.r});
        if (r8 == false) goto L5;
    L11:
        int r9 = g.a[r7.ordinal()];
        if (r9 == 1) goto L28;
        if (r9 == 2) goto L24;
        if (r9 == 3) goto L17;
    L31:
        this.t = r7;
        return;
    L17:
        if (this.F == false) goto L19;
        boolean r11 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(com.bytedance.android.live.profit.scoreboard.h.class).i(this.K.m.i);
    L19:
        na4.b r12 = this.r;
        if (r12 == null) goto L22;
        r12.destroy();
    L22:
        this.r = null;
        goto L31
    L24:
        if (this.F == true) goto L31;
        na4.b r13 = this.r;
        if (r13 == null) goto L31;
        r13.pause();
        goto L31
    L28:
        na4.b r14 = this.r;
        if (r14 == null) goto L31;
        r14.resume();
        goto L31
    L5:
        if (this.r == null) goto L10;
        SonicState r15 = this.t;
        if (r15 != r7) goto L9;
        return;
    L9:
        if (r15 != SonicState.DESTROY) goto L11;
        return;
    }

    public final void G(PanelType r9, Function1<? super PanelType, Unit> r11, Function1<? super Throwable, Unit> r12) {
        Intrinsics.checkNotNullParameter(r9, "toType");
        com.bytedance.android.live.broadcastgame.opengame.panel.h r0 = this.J;
        if ((r0 instanceof com.bytedance.android.live.broadcastgame.opengame.panel.g) == true) goto L6;
        Unit r13 = (Unit) r12.invoke(new Throwable("panel not support switch"));
        return;
    L6:
        if (r0 == null) goto L38;
        PanelType r14 = r0.getPanelType();
        if (r14 == null) goto L39;
        if (r14 != r9) goto L13;
        Unit r15 = (Unit) r11.invoke(r9);
        return;
    L13:
        PanelType.Companion.getClass();
        if (PanelType.a.a(r14) == false) goto L22;
        if (r9 != PanelType.PANEL_TYPE_PORTRAIT) goto L19;
        String r16 = "玩法将切换为竖全屏";
    L26:
        if (r9 != PanelType.PANEL_TYPE_LANDSCAPE) goto L28;
        long r1 = 100;
    L30:
        if ((!StringsKt.isBlank(r16)) == false) goto L36;
        InteractGameContext r2 = InteractGameContext.Companion.getContext();
        if (r2 == null) goto L36;
        if (r2.getGameFullPanelIsShowing() != true) goto L36;
        f2.c(r16, 0);
        r1 = 0;
    L36:
        UtilityKotlinExtentionsKt.s(r1, false, false, new SonicGamePlugin$switchScreen$1(this, r9, r11), 6);
        return;
    L28:
        r1 = 500;
        goto L30
    L19:
        if (r9 != PanelType.PANEL_TYPE_LANDSCAPE) goto L24;
        r16 = "玩法将切换为横全屏";
    L24:
        r16 = "";
        goto L26
    L22:
        if (PanelType.a.a(r9) == false) goto L24;
        r16 = "当前玩法将进入全屏模式";
        goto L26
    L39:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void e(Context r22, String r23, Map<String, ? extends Object> r24, n r25) {
        Intrinsics.checkNotNullParameter(r22, "context");
        Intrinsics.checkNotNullParameter(r23, "schema");
        this.s = r23;
        LruCache r4 = LiveSchemaInfo.r;
        LiveSchemaInfo r1 = LiveSchemaInfo.c.a(r23);
        int r5 = q.a;
        q.f("SonicGamePlugin", new Object[]{"start download resource, appId: " + this.K.m.i});
        Object r6 = null;
        if (r1 != null) goto L7;
        q.f("SonicGamePlugin", new Object[]{"download resource failed, schemaInfo is null"});
        if (r25 == null) goto L20;
        r25.n(null, "schema error", "Download");
        return;
    L20:
        return;
    L7:
        Object[] r8 = new Object[6];
        r8[0] = "is anchor: ";
        r8[1] = Boolean.valueOf(this.K.o);
        int r7 = 2;
        r8[2] = ", from collect: ";
        if (r24 == null) goto L10;
        r6 = r24.get("from_collect");
    L10:
        r8[3] = r6;
        r8[4] = ", live start mode: ";
        r8[5] = Integer.valueOf(n());
        q.f("SonicGamePlugin", r8);
        com.bytedance.bdp.live.livecontainer.sonicgame.k r9 = new com.bytedance.bdp.live.livecontainer.sonicgame.k(null, null, null, false, 0, 0, false, 0, 0, 4095);
        ((na4.f) r9).b.put("key_start_mode", "host");
        Map r11 = ((na4.f) r9).b;
        JSONObject r12 = new JSONObject();
        r12.put("anchor", this.K.o);
        if (r24 != null) goto L13;
    L15:
        r7 = n();
    L16:
        r12.put("live_start_mode", r7);
        Unit r2 = Unit.INSTANCE;
        r11.put("key_ext_config_json", r12.toString());
        na4.c<com.bytedance.bdp.live.livecontainer.sonicgame.k, com.bytedance.bdp.live.livecontainer.sonicgame.b> r3 = x();
        if (r3 == null) goto L22;
        r3.a(r1, r9, new b(this, r25));
        return;
    L22:
        return;
    L13:
        if (Intrinsics.areEqual(r24.get("from_collect"), Boolean.TRUE) == false) goto L15;
        goto L15
    }
}
