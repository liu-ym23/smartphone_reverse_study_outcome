package com.bytedance.android.live.broadcastgame.opengame.runtime;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.GameDataReportHelper;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.interactgame.InteractGameLocalStatusUtils;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.h0;
import com.bytedance.android.live.broadcastgame.api.model.q0;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.g0;
import com.bytedance.android.live.broadcastgame.h5.LinkMicGameApi;
import com.bytedance.android.live.broadcastgame.network.BroadcastGameApi;
import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudExecutor;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.message.AnchorGameMessageChannel;
import com.bytedance.android.live.broadcastgame.opengame.message.f0;
import com.bytedance.android.live.broadcastgame.opengame.network.AnchorGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.l30;
import com.bytedance.android.livesdk.config.nc1;
import com.bytedance.android.livesdk.config.oc1;
import com.bytedance.android.livesdk.utils.o1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class AnchorPluginRuntime extends OpenApiSupportPluginRuntime {
    public final com.bytedance.android.live.pushstream.d A;
    public AnchorGameMessageChannel v;
    public long w;
    public String x;
    public long y;
    public long z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ com.bytedance.android.live.broadcastgame.api.model.r a;
        public final /* synthetic */ AnchorPluginRuntime b;
        public final /* synthetic */ String c;
        public final /* synthetic */ PluginType d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ boolean f;

        public b(com.bytedance.android.live.broadcastgame.api.model.r r1, AnchorPluginRuntime r2, r r3, String r4, PluginType r5, Map r6, boolean r7) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }

        public final void accept(Object r14) {
            com.bytedance.android.live.network.response.e r15 = (com.bytedance.android.live.network.response.e) r14;
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("AnchorPluginRuntime", new Object[]{"on game_start success"});
            IInteractService r1 = jc1.k.f(IInteractService.class);
            if (r1 == null) goto L7;
            com.bytedance.android.live.liveinteract.utils.n r2 = r1.getLinkMicGameTraceUtils();
            if (r2 == null) goto L7;
            r2.a(true, "game_start_api", 0, "logId: " + ((ExtraResponse) r15).logId + ", response: " + ((LinkMicGameApi.a) ((ExtraResponse) r15).data));
        L7:
            xs2.b.a().post(new d10.e(((LinkMicGameApi.a) ((ExtraResponse) r15).data).a()));
            AnchorPluginRuntime r4 = this.b;
            long r5 = this.a.p();
            String r7 = this.a.b();
            String r16 = this.a.c();
            if (r16 != null) goto L10;
            r16 = "";
        L10:
            r4.x(r5, r7, r16, this.c, this.d, this.e, this.f);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AnchorPluginRuntime a;
        public final /* synthetic */ r b;
        public final /* synthetic */ Map c;

        public c(AnchorPluginRuntime r1, r r2, Map r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.i(r8, "AnchorPluginRuntime", "on game_start fail");
            String r2 = "";
            ExceptionUtils.handleException(this.a.getContext(), r8, "");
            r r1 = this.b;
            if (r1 == null) goto L5;
            r1.p("on game_start fail");
        L5:
            InteractGameContext r3 = InteractGameContext.Companion.getContext();
            if (r3 == null) goto L10;
            com.bytedance.live.datacontext.n<h0.c> r4 = r3.getOpenGameLaunchResult();
            if (r4 == null) goto L10;
            r4.setValue(new h0.a(null));
        L10:
            IInteractService r5 = jc1.k.f(IInteractService.class);
            if (r5 == null) goto L15;
            com.bytedance.android.live.liveinteract.utils.m r6 = r5.getLinkMicGameLogUtils();
            if (r6 == null) goto L15;
            r6.f(false, "game_start_failed", String.valueOf(com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r8)), o1.a(r8));
        L15:
            IInteractService r9 = jc1.k.f(IInteractService.class);
            if (r9 == null) goto L25;
            com.bytedance.android.live.liveinteract.utils.n r11 = r9.getLinkMicGameTraceUtils();
            if (r11 == null) goto L26;
            int r12 = com.bytedance.android.live.broadcastgame.api.openplatform.h.a(r8);
            String r13 = o1.a(r8);
            if (r13 == null) goto L23;
            r2 = r13;
        L23:
            r11.a(true, "game_start_api", r12, r2);
            return;
        L26:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.network.response.e r4 = (com.bytedance.android.live.network.response.e) r3;
            int r5 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.f("AnchorPluginRuntime", new Object[]{"on game_stop success"});
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r3) {
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.i((Throwable) r3, "AnchorPluginRuntime", "on game_stop fail");
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ Runnable a;

        public f(h r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            BaseResponse r2 = (BaseResponse) r1;
            this.a.run();
        }
    }

    public static final class g<T> implements Consumer {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ AnchorPluginRuntime a;

        public static final class a<T> implements Consumer {
            public final /* synthetic */ h a;

            public a(h r1) {
                this.a = r1;
            }

            public final void accept(Object r8) {
                com.bytedance.android.live.network.response.e r9 = (com.bytedance.android.live.network.response.e) r8;
                this.a.a.y = 0;
                int r11 = com.bytedance.android.live.broadcastgame.opengame.q.a;
                com.bytedance.android.live.broadcastgame.opengame.q.g("game/stop请求成功", "AnchorPluginRuntime");
                IInteractGameMonitorService.b.b((IInteractGameMonitorService) jc1.k.n(IInteractGameMonitorService.class), 0, this.a.a.s(), this.a.a.y, null, 24);
            }
        }

        public static final class b<T> implements Consumer {
            public final /* synthetic */ h a;

            public b(h r1) {
                this.a = r1;
            }

            public final void accept(Object r8) {
                Throwable r9 = (Throwable) r8;
                IInteractGameMonitorService.b.b((IInteractGameMonitorService) jc1.k.n(IInteractGameMonitorService.class), 1, this.a.a.s(), this.a.a.y, r9, 16);
                int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
                com.bytedance.android.live.broadcastgame.opengame.q.i(r9, "AnchorPluginRuntime", "game/stop请求");
            }
        }

        public h(AnchorPluginRuntime r1) {
            this.a = r1;
        }

        public final void a() {
            long r3 = 0;
            if (this.a.y == 0) goto L9;
            int r1 = g0.a;
            Intrinsics.checkNotNullParameter(BroadcastGameApi.class, "cls");
            BroadcastGameApi r5 = (BroadcastGameApi) com.bytedance.android.live.network.c.b().e(BroadcastGameApi.class);
            com.bytedance.android.live.broadcastgame.api.model.r r2 = this.a.s().c();
            if (r2 == null) goto L7;
            r3 = r2.p();
        L7:
            AnchorPluginRuntime r4 = this.a;
            r5.notifyServerGameStop(r3, r4.j, r4.y, "", false, 1, r4.w).subscribe(new a(this), new b(this));
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
        int r1 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("AnchorPluginRuntime", new Object[]{"ready to start, boot info: ", u().m.l, ", pkg: ", u().m.m});
        final Function0<Unit> r2 = new AnonymousClass1(this);
        final Function1<String, Unit> r3 = new AnonymousClass2(this);
        Intrinsics.checkNotNullParameter(r2, "onSuccess");
        Intrinsics.checkNotNullParameter(r3, "onError");
        JSONObject r5 = null;
        if (com.bytedance.android.livesdk.config.setting.s.b() == false) goto L5;
    L6:
        Object r4 = u().n.get("is_preview_mount");
        if ((r4 instanceof Boolean) == true) goto L9;
        r4 = null;
    L9:
        Boolean r6 = (Boolean) r4;
        if (r6 == null) goto L12;
        boolean r27 = r6.booleanValue();
    L13:
        String r22 = ((BootInfoService) u().o(BootInfoService.class)).e();
        AnchorGameMessageChannel r7 = this.v;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("messageChannel");
    L16:
        com.bytedance.android.live.broadcastgame.api.model.r r8 = s().c();
        if (r8 == null) goto L19;
        long r9 = r8.p();
    L20:
        long r11 = r9;
        String r15 = r().n;
        com.bytedance.android.live.broadcastgame.api.model.r r12 = s().c();
        if (r12 == null) goto L24;
        String r13 = r12.j();
        if (r13 == null) goto L24;
    L25:
        String r14 = r13;
        com.bytedance.android.live.broadcastgame.api.model.r r16 = s().c();
        if (r16 == null) goto L28;
        int r25 = r16.g();
    L29:
        com.bytedance.android.live.broadcastgame.api.model.u r17 = s();
        if (r17 == null) goto L34;
        com.bytedance.android.live.broadcastgame.api.model.r r18 = r17.c();
        if (r18 == null) goto L34;
        boolean r31 = r18.u();
    L35:
        Function3<Boolean, String, Boolean, Unit> r19 = new AnchorPluginRuntime$sendAppStart$1(this, r2, r3);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r15, "schema");
        Intrinsics.checkNotNullParameter(r14, "developer");
        Intrinsics.checkNotNullParameter(r19, "onResult");
        com.bytedance.android.live.broadcastgame.api.model.r r21 = r7.k;
        if (r21 == null) goto L42;
        com.bytedance.android.live.broadcastgame.api.model.g r23 = r21.n();
        if (r23 == null) goto L42;
        String r24 = r23.a();
        if (r24 == null) goto L42;
        r5 = new JSONObject().put("unity_version", r24);
    L42:
        r7.c(new f0(r11, r7.i, r7.j, r7.b.a, r7.h, r15, null, null, com.bytedance.android.live.broadcastgame.api.interactgame.o.a, ((IInteractGameMonitorService) jc1.k.n(IInteractGameMonitorService.class)).getCurrentGameIdentifier(), 0, r22, false, r14, r25, 0, r27, false, 0, null, r31, null, r5, false, null, false, false, 2062980288), r19);
        return;
    L34:
        r31 = false;
        goto L35
    L28:
        r25 = 0;
    L24:
        r13 = "";
        goto L25
    L19:
        r9 = 0;
    L12:
        r27 = false;
        goto L13
    L5:
        if (LiveInfraSettingKeys.LIVE_NEW_TOOLBAR_FUNCTION_CHANGE.getValue().c() == false) goto L12;
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.OpenApiSupportPluginRuntime, com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        super.stop();
        ((u10.e) w()).f();
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r1 = AnchorGameContext.a.a();
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.k<Boolean> r2 = r1.getOpenGameTestFloatBall();
        if (r2 == null) goto L7;
        r2.post(Boolean.FALSE);
    L7:
        AnchorGameContext r3 = AnchorGameContext.a.a();
        if (r3 == null) goto L12;
        com.bytedance.live.datacontext.n<h0.c> r4 = r3.getOpenGameLaunchResult();
        if (r4 == null) goto L12;
        r4.setValue(h0.d.a);
    L12:
        ((IInteractGameMonitorService) jc1.k.n(IInteractGameMonitorService.class)).logGameStop(0, s(), false);
        AnchorGameMessageChannel r5 = this.v;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("messageChannel");
    L15:
        r5.getClass();
        com.bytedance.android.live.broadcastgame.opengame.message.y r12 = new com.bytedance.android.live.broadcastgame.opengame.message.y(r5.h, r5.j, r5.b.b.getAndIncrement(), r5.b.a);
        int r6 = InteractGameLocalStatusUtils.a;
        InteractGameLocalStatusUtils.c("open_app_status", String.valueOf(0));
        String r7 = this.r;
        if (r7 != null) goto L18;
        r7 = "anchor_close";
    L18:
        ((BootInfoService) u().o(BootInfoService.class)).e();
        if (this.w == 0) goto L157;
        AnchorGameContext r8 = AnchorGameContext.a.a();
        if (r8 == null) goto L25;
        com.bytedance.live.datacontext.m<Boolean> r9 = r8.getOpenGameIntroCardAutoShow();
        if (r9 == null) goto L25;
        Boolean r11 = (Boolean) r9.getValue();
    L26:
        int r13 = GameDataReportHelper.a;
        com.bytedance.android.live.broadcastgame.api.model.u r14 = s();
        if (((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPkServiceExternal().getPkState() != 1) goto L29;
        boolean r15 = true;
    L31:
        if (((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPkServiceExternal().getPkState() != 2) goto L33;
        boolean r16 = true;
    L34:
        long r17 = this.y;
        Boolean r18 = Boolean.TRUE;
        boolean r19 = Intrinsics.areEqual(r11, r18);
        Intrinsics.checkNotNullParameter(r14, "gameItem");
        Pair[] r21 = new Pair[17];
        r21[0] = TuplesKt.to("game_name", r14.name);
        com.bytedance.android.live.broadcastgame.api.model.r r110 = r14.c();
        if (r110 == null) goto L37;
        Long r111 = Long.valueOf(r110.p());
    L38:
        r21[1] = TuplesKt.to("game_id", String.valueOf(r111));
        com.bytedance.android.live.broadcastgame.api.model.r r112 = r14.c();
        if (r112 == null) goto L41;
        String r113 = r112.b();
    L42:
        r21[2] = TuplesKt.to("game_app_id", String.valueOf(r113));
        r21[3] = TuplesKt.to("game_type", String.valueOf(r14.interactId));
        r21[4] = TuplesKt.to("end_type", "abnormal");
        r21[5] = TuplesKt.to("status", "play_end");
        if (r15 == false) goto L45;
        Object r114 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L46:
        r21[6] = TuplesKt.to("is_pk", r114);
        if (r16 == false) goto L49;
        Object r115 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L50:
        r21[7] = TuplesKt.to("is_linked", r115);
        r21[8] = TuplesKt.to("user_type", "anchor");
        AnchorGameContext r116 = AnchorGameContext.a.a();
        if (r116 == null) goto L58;
        com.bytedance.live.datacontext.m<String> r117 = r116.getClickIconSourceType();
        if (r117 == null) goto L58;
        String r118 = (String) r117.getValue();
        if (r118 == null) goto L58;
        String r119 = r118;
    L59:
        r21[9] = TuplesKt.to("source_type", r119);
        AnchorGameContext r120 = AnchorGameContext.a.a();
        if (r120 == null) goto L67;
        com.bytedance.live.datacontext.m<String> r121 = r120.getClickIconGroupType();
        if (r121 == null) goto L67;
        String r122 = (String) r121.getValue();
        if (r122 == null) goto L67;
    L68:
        r21[10] = TuplesKt.to("click_position", r122);
        r21[11] = TuplesKt.to("play_id", String.valueOf(r17));
        r21[12] = TuplesKt.to("if_started_by_anchor", GamePromoteDataContext.GAME_TYPE_MOBILE);
        r21[13] = TuplesKt.to("if_in_collection", "0");
        if (r19 == false) goto L71;
        Object r123 = "on";
        Object r39 = r123;
    L72:
        r21[14] = TuplesKt.to("ad_status", r123);
        r21[15] = TuplesKt.to("source", jc1.k.n(IInteractService.class).getCurrentSwitchSceneSource());
        com.bytedance.android.live.broadcastgame.api.model.r r22 = r14.c();
        if (r22 == null) goto L75;
        int r23 = r22.g();
    L76:
        r21[16] = TuplesKt.to("game_category", GameDataReportHelper.c(r23));
        Map r24 = MapsKt.mutableMapOf(r21);
        r24.put("miniplugin_live_scene_type", String.valueOf(com.bytedance.android.live.broadcastgame.api.interactgame.j.a()));
        String r25 = (String) r24.put("stop_reason", r7);
        AnchorGameContext r26 = AnchorGameContext.a.a();
        if (r26 == null) goto L83;
        com.bytedance.live.datacontext.n<String> r27 = r26.getGuideActivityName();
        if (r27 == null) goto L83;
        String r28 = (String) r27.getValue();
        if (r28 == null) goto L83;
        r24.put("activity_name", r28);
    L83:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_end", r24, new Object[]{Room.class, am2.x.class});
        com.bytedance.android.live.broadcastgame.api.model.u r29 = s();
        long r31 = System.currentTimeMillis() - this.w;
        if (((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPkServiceExternal().getPkState() != 1) goto L86;
        boolean r124 = true;
    L88:
        if (((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPkServiceExternal().getPkState() != 2) goto L90;
        boolean r125 = true;
    L91:
        long r126 = this.y;
        String r43 = r7;
        Long r32 = Long.valueOf(((v) t()).e);
        if (r32 == null) goto L94;
        long r127 = r32.longValue();
    L95:
        boolean r33 = Intrinsics.areEqual(r11, r18);
        Intrinsics.checkNotNullParameter(r29, "gameItem");
        Pair[] r34 = new Pair[15];
        if (r31 < 0) goto L98;
        long r128 = r31;
    L99:
        r34[0] = TuplesKt.to("duration", String.valueOf(r128));
        r34[1] = TuplesKt.to("game_name", r29.name);
        com.bytedance.android.live.broadcastgame.api.model.r r35 = r29.c();
        if (r35 == null) goto L102;
        Long r36 = Long.valueOf(r35.p());
    L103:
        r34[2] = TuplesKt.to("game_id", String.valueOf(r36));
        com.bytedance.android.live.broadcastgame.api.model.r r37 = r29.c();
        if (r37 == null) goto L106;
        String r38 = r37.b();
    L107:
        r34[3] = TuplesKt.to("game_app_id", String.valueOf(r38));
        r34[4] = TuplesKt.to("game_type", String.valueOf(r29.interactId));
        if (r124 == false) goto L110;
        Object r41 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L111:
        r34[5] = TuplesKt.to("is_pk", r41);
        if (r125 == false) goto L114;
        Object r129 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L115:
        r34[6] = TuplesKt.to("is_linked", r129);
        r34[7] = TuplesKt.to("user_type", "anchor");
        if (r127 != 0) goto L118;
        String r42 = String.valueOf(r31);
    L119:
        r34[8] = TuplesKt.to("valid_duration", r42);
        AnchorGameContext r44 = AnchorGameContext.a.a();
        if (r44 == null) goto L125;
        com.bytedance.live.datacontext.m<String> r45 = r44.getClickIconSourceType();
        if (r45 == null) goto L125;
        String r46 = (String) r45.getValue();
        if (r46 == null) goto L125;
    L126:
        r34[9] = TuplesKt.to("source_type", r46);
        AnchorGameContext r47 = AnchorGameContext.a.a();
        if (r47 == null) goto L132;
        com.bytedance.live.datacontext.m<String> r48 = r47.getClickIconGroupType();
        if (r48 == null) goto L132;
        String r49 = (String) r48.getValue();
        if (r49 == null) goto L132;
    L133:
        r34[10] = TuplesKt.to("click_position", r49);
        r34[11] = TuplesKt.to("play_id", String.valueOf(r126));
        if (r33 == false) goto L136;
        Object r51 = r39;
    L137:
        r34[12] = TuplesKt.to("ad_status", r51);
        AnchorGameContext r52 = AnchorGameContext.a.a();
        if (r52 == null) goto L143;
        com.bytedance.live.datacontext.n<String> r53 = r52.getStartGameSource();
        if (r53 == null) goto L143;
        String r54 = (String) r53.getValue();
        if (r54 == null) goto L143;
    L144:
        r34[13] = TuplesKt.to("source", r54);
        com.bytedance.android.live.broadcastgame.api.model.r r55 = r29.c();
        if (r55 == null) goto L147;
        int r56 = r55.g();
    L148:
        r34[14] = TuplesKt.to("game_category", GameDataReportHelper.c(r56));
        Map r57 = MapsKt.mutableMapOf(r34);
        String r58 = (String) r57.put("stop_reason", r43);
        AnchorGameContext r59 = AnchorGameContext.a.a();
        if (r59 == null) goto L155;
        com.bytedance.live.datacontext.n<String> r61 = r59.getGuideActivityName();
        if (r61 == null) goto L155;
        String r62 = (String) r61.getValue();
        if (r62 == null) goto L155;
        r57.put("activity_name", r62);
    L155:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_game_duration", r57, new Object[]{Room.class, am2.x.class});
        goto L157
    L147:
        r56 = 0;
    L143:
        r54 = "unknown";
        goto L144
    L136:
        r51 = "off";
    L132:
        r49 = "all_used";
    L125:
        r46 = "normal";
        goto L126
    L118:
        r42 = String.valueOf(r127);
        goto L119
    L114:
        r129 = "0";
        goto L115
    L110:
        r41 = "0";
        goto L111
    L106:
        r38 = null;
        goto L107
    L102:
        r36 = null;
        goto L103
    L98:
        r128 = 0;
        goto L99
    L94:
        r127 = System.currentTimeMillis() - this.w;
        goto L95
    L90:
        r125 = false;
        goto L91
    L86:
        r124 = false;
        goto L88
    L75:
        r23 = 0;
        goto L76
    L71:
        r39 = "on";
        r123 = "off";
    L67:
        r122 = "all_used";
    L58:
        r119 = "normal";
        goto L59
    L49:
        r115 = "0";
        goto L50
    L45:
        r114 = "0";
        goto L46
    L41:
        r113 = null;
        goto L42
    L37:
        r111 = null;
        goto L38
    L33:
        r16 = false;
        goto L34
    L29:
        r15 = false;
    L25:
        r11 = null;
    L157:
        h r63 = new h(this);
        if (this.x.length() <= 0) goto L160;
        boolean r64 = true;
    L162:
        if (r64 == false) goto L179;
        Lazy r65 = LiveOpenGameClient.d;
        AnchorGameNetApi r66 = (AnchorGameNetApi) LiveOpenGameClient.a.a().a(AnchorGameNetApi.class);
        String r67 = this.x;
        com.bytedance.android.live.broadcastgame.api.model.r r68 = s().c();
        if (r68 == null) goto L169;
        String r69 = r68.b();
        if (r69 == null) goto L169;
        String r71 = r69;
    L170:
        RxCompatKt.b(r66.sendAppStop(r67, r71, this.j, r12.a().toString(), ""), RxUtil.rxRetryHelper(3)).subscribe(new f(r63), g.a);
        if (y() == false) goto L179;
        LinkMicGameApi r72 = (LinkMicGameApi) com.bytedance.android.live.network.c.b().e(LinkMicGameApi.class);
        long r73 = this.j;
        com.bytedance.android.live.broadcastgame.api.model.r r74 = s().c();
        if (r74 == null) goto L177;
        String r75 = r74.b();
        if (r75 == null) goto L177;
        String r76 = r75;
    L178:
        RxUtilKt.i(r72.stopGame(r73, r76, "danmu", null)).subscribe(d.a, e.a);
    L177:
        r76 = null;
    L169:
        r71 = "";
    L179:
        this.x = "";
        this.w = 0;
        InteractGameLocalStatusUtils.a();
        if (((Boolean) l30.a.getValue()).booleanValue() == false) goto L182;
        boolean r77 = com.bytedance.android.live.revenue.core.util.h.a;
        ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).notifyLowPriorityDownloadTask(Boolean.TRUE);
    L182:
        jc1.k.n(IPerformanceManager.class).onModuleStop("game_platform");
        AnchorGameMessageChannel r78 = this.v;
        if (r78 != null) goto L185;
        Intrinsics.throwUninitializedPropertyAccessException("messageChannel");
    L185:
        r78.b();
        return;
    L160:
        r64 = false;
        goto L162
    }

    public final boolean y() {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (r0.isTalkRoomLoaded() != true) goto L13;
        com.bytedance.android.live.broadcastgame.api.model.u r1 = s();
        if (r1 == null) goto L13;
        com.bytedance.android.live.broadcastgame.api.model.r r2 = r1.c();
        if (r2 == null) goto L13;
        if (r2.g() != 4) goto L13;
        return true;
    }

    public final void z() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("AnchorPluginRuntime", new Object[]{"real start, init anchor open api"});
        k r1 = t();
        com.bytedance.android.live.broadcastgame.opengame.openapi.b r3 = new com.bytedance.android.live.broadcastgame.opengame.openapi.b(u(), w(), (CloudExecutor) this.p.getValue());
        v r2 = (v) r1;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "openApi");
        r2.b = r3;
        super.start();
        Long r4 = null;
        ((IInteractGameMonitorService) jc1.k.n(IInteractGameMonitorService.class)).logGameStartupResult(0, s(), null);
        AnchorGameMessageChannel r5 = this.v;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("messageChannel");
    L5:
        r5.getClass();
        int r6 = InteractGameLocalStatusUtils.a;
        InteractGameLocalStatusUtils.c("open_conn_id", String.valueOf(r5.b.a));
        com.bytedance.android.live.broadcastgame.opengame.message.q r7 = r5.e;
        String r8 = r5.h;
        long r9 = r5.b.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "appId");
        r7.a = r8;
        r7.b = Long.valueOf(r9);
        String r11 = r().i;
        Intrinsics.checkNotNullParameter(r11, "appId");
        InteractGameLocalStatusUtils.c(OpenPlatformBaseDebugger.APP_ID, r11);
        InteractGameLocalStatusUtils.c("open_app_status", String.valueOf(1));
        com.bytedance.android.live.broadcastgame.api.model.r r12 = s().c();
        if (r12 == null) goto L34;
        RoomContext r13 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        String r14 = "";
        if (r13 == null) goto L17;
        com.bytedance.live.datacontext.m r15 = r13.getRoom();
        if (r15 == null) goto L17;
        Room r16 = (Room) r15.getValue();
        if (r16 == null) goto L17;
        User r17 = r16.getOwner();
        if (r17 == null) goto L17;
        String r18 = r17.getCastSecUid();
        if (r18 == null) goto L17;
    L19:
        if (r18.length() <= 0) goto L21;
        boolean r19 = true;
    L22:
        if (r19 == false) goto L34;
        com.bytedance.android.livesdk.sharedpref.e r21 = com.bytedance.android.livesdk.sharedpref.b.x2;
        List r22 = (List) ((HashMap) r21.getValue()).get(r18);
        if (r22 != null) goto L26;
        r22 = new ArrayList();
    L26:
        String r110 = r12.b();
        if (r110 != null) goto L29;
        r110 = "";
    L29:
        String r23 = r12.c();
        if (r23 == null) goto L33;
        r14 = r23;
    L33:
        oc1.a(r22, new nc1(r110, r14));
        ((Map) r21.getValue()).put(r18, r22);
        ((Map) r21.getValue()).put(r18, r22);
        goto L34
    L21:
        r19 = false;
    L17:
        r18 = "";
    L34:
        int r24 = com.bytedance.android.live.broadcastgame.api.interactgame.j.a;
        String r25 = s().e();
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r26 = AnchorGameContext.a.a();
        if (r26 == null) goto L40;
        com.bytedance.live.datacontext.m<List<String>> r27 = r26.getRecentUsedInteractItemIdList();
        if (r27 == null) goto L40;
        List r28 = (List) r27.getValue();
        if (r28 == null) goto L40;
    L41:
        Intrinsics.checkNotNullParameter(r25, "id");
        Intrinsics.checkNotNullParameter(r28, "currentRecentUsedList");
        if (r28.contains(r25) == false) goto L44;
        r28.remove(r25);
    L44:
        ListProtector.add(r28, 0, r25);
        AnchorGameContext r29 = AnchorGameContext.a.a();
        if (r29 == null) goto L49;
        com.bytedance.live.datacontext.m<List<String>> r31 = r29.getRecentUsedInteractItemIdList();
        if (r31 == null) goto L49;
        r31.setValue(r28);
    L49:
        IPerformanceManager r32 = jc1.k.n(IPerformanceManager.class);
        int r33 = GameDataReportHelper.a;
        com.bytedance.android.live.broadcastgame.api.model.u r34 = s();
        if (r34 != null) goto L52;
        Map r35 = MapsKt.emptyMap();
    L69:
        r32.onModuleStart("game_platform", r35);
        return;
    L52:
        Pair[] r36 = new Pair[5];
        com.bytedance.android.live.broadcastgame.api.model.r r37 = r34.c();
        if (r37 == null) goto L55;
        r4 = Long.valueOf(r37.p());
    L55:
        r36[0] = TuplesKt.to("game_id", String.valueOf(r4));
        r36[1] = TuplesKt.to("game_name", r34.name);
        InteractID.a r38 = InteractID.Companion;
        int r39 = r34.interactId;
        r38.getClass();
        if (r39 != InteractID.EffectGame.getValue()) goto L59;
        String r41 = "effect_game";
    L68:
        r36[2] = TuplesKt.to("game_type", r41);
        r36[3] = TuplesKt.to("game_status", "gaming");
        r36[4] = TuplesKt.to("active", GamePromoteDataContext.GAME_TYPE_MOBILE);
        r35 = MapsKt.mapOf(r36);
        goto L69
    L59:
        if (r39 != InteractID.OpenGame.getValue()) goto L62;
        r41 = "mini_plugin";
        goto L68
    L62:
        if (r39 != InteractID.Zhufen.getValue()) goto L65;
        r41 = "lynx_game";
        goto L68
    L65:
        if (r39 != InteractID.SonicMiniGame.getValue()) goto L67;
        r41 = "sonic_game";
        goto L68
    L67:
        r41 = "unnamed id " + r39;
    L40:
        r28 = new ArrayList();
        goto L41
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.OpenApiSupportPluginRuntime, com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
        super.launch();
        this.z = System.currentTimeMillis();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void m() {
        super.m();
        if (s().c() == null) goto L80;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r0 = AnchorGameContext.a.a();
        Long r1 = null;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r2 = r0.getOpenGameIntroCardAutoShow();
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.getValue();
    L10:
        int r4 = GameDataReportHelper.a;
        com.bytedance.android.live.broadcastgame.api.model.u r5 = s();
        if (((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPkServiceExternal().getPkState() != 1) goto L13;
        boolean r6 = true;
    L15:
        if (((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getPkServiceExternal().getPkState() != 2) goto L17;
        boolean r7 = true;
    L18:
        boolean r8 = Intrinsics.areEqual(r3, Boolean.TRUE);
        Intrinsics.checkNotNullParameter(r5, "gameItem");
        Pair[] r9 = new Pair[15];
        r9[0] = TuplesKt.to("game_name", r5.name);
        com.bytedance.android.live.broadcastgame.api.model.r r11 = r5.c();
        if (r11 == null) goto L21;
        Long r12 = Long.valueOf(r11.p());
    L22:
        r9[1] = TuplesKt.to("game_id", String.valueOf(r12));
        com.bytedance.android.live.broadcastgame.api.model.r r13 = r5.c();
        if (r13 == null) goto L25;
        String r14 = r13.b();
    L26:
        r9[2] = TuplesKt.to("game_app_id", String.valueOf(r14));
        r9[3] = TuplesKt.to("game_type", String.valueOf(r5.interactId));
        r9[4] = TuplesKt.to("status", "first_start");
        if (r6 == false) goto L29;
        Object r15 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L30:
        r9[5] = TuplesKt.to("is_pk", r15);
        if (r7 == false) goto L33;
        Object r16 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L34:
        r9[6] = TuplesKt.to("is_linked", r16);
        AnchorGameContext r17 = AnchorGameContext.a.a();
        if (r17 == null) goto L40;
        com.bytedance.live.datacontext.m<String> r18 = r17.getClickIconSourceType();
        if (r18 == null) goto L40;
        String r19 = (String) r18.getValue();
        if (r19 == null) goto L40;
    L41:
        r9[7] = TuplesKt.to("source_type", r19);
        r9[8] = TuplesKt.to("user_type", "anchor");
        r9[9] = TuplesKt.to("if_started_by_anchor", GamePromoteDataContext.GAME_TYPE_MOBILE);
        r9[10] = TuplesKt.to("if_in_collection", "0");
        AnchorGameContext r21 = AnchorGameContext.a.a();
        if (r21 == null) goto L47;
        com.bytedance.live.datacontext.m<String> r22 = r21.getClickIconGroupType();
        if (r22 == null) goto L47;
        String r23 = (String) r22.getValue();
        if (r23 == null) goto L47;
    L48:
        r9[11] = TuplesKt.to("click_position", r23);
        if (r8 == false) goto L51;
        String r24 = "on";
    L52:
        r9[12] = TuplesKt.to("ad_status", r24);
        r9[13] = TuplesKt.to("source", jc1.k.n(IInteractService.class).getCurrentSwitchSceneSource());
        com.bytedance.android.live.broadcastgame.api.model.r r25 = r5.c();
        if (r25 == null) goto L55;
        int r26 = r25.g();
    L56:
        r9[14] = TuplesKt.to("game_category", GameDataReportHelper.c(r26));
        Map r27 = MapsKt.mutableMapOf(r9);
        AnchorGameContext r28 = AnchorGameContext.a.a();
        if (r28 == null) goto L63;
        com.bytedance.live.datacontext.n<String> r29 = r28.getGuideActivityName();
        if (r29 == null) goto L63;
        String r31 = (String) r29.getValue();
        if (r31 == null) goto L63;
        r27.put("activity_name", r31);
    L63:
        r27.put("room_live_type", String.valueOf(com.bytedance.android.live.broadcastgame.api.interactgame.j.a()));
        AnchorGameContext r32 = AnchorGameContext.a.a();
        if (r32 == null) goto L68;
        com.bytedance.live.datacontext.n<String> r33 = r32.getStartGameSource();
        if (r33 == null) goto L68;
        r33.setValue(r27.get("source"));
    L68:
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_game_start", r27, new Object[]{Room.class, am2.x.class});
        int r34 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        String r35 = s().name;
        com.bytedance.android.live.broadcastgame.api.model.r r36 = s().c();
        if (r36 == null) goto L74;
        String r37 = r36.b();
        if (r37 == null) goto L74;
        String r38 = r37;
    L75:
        com.bytedance.android.live.broadcastgame.api.model.r r39 = s().c();
        if (r39 == null) goto L78;
        r1 = Long.valueOf(r39.p());
    L78:
        com.bytedance.android.live.broadcastgame.api.interactgame.n.i(r35, r38, String.valueOf(r1), System.currentTimeMillis() - this.z, 1, ((BootInfoService) u().o(BootInfoService.class)).e());
        return;
    L74:
        r38 = "0";
        goto L75
    L55:
        r26 = 0;
        goto L56
    L51:
        r24 = "off";
    L47:
        r23 = "all_used";
    L40:
        r19 = "normal";
        goto L41
    L33:
        r16 = "0";
        goto L34
    L29:
        r15 = "0";
        goto L30
    L25:
        r14 = null;
        goto L26
    L21:
        r12 = null;
        goto L22
    L17:
        r7 = false;
        goto L18
    L13:
        r6 = false;
    L9:
        r3 = null;
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w, com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r8) {
        Intrinsics.checkNotNullParameter(r8, "error");
        super.fail(r8);
        int r9 = com.bytedance.android.live.broadcastgame.api.interactgame.n.a;
        String r0 = s().name;
        com.bytedance.android.live.broadcastgame.api.model.r r11 = s().c();
        if (r11 == null) goto L6;
        String r12 = r11.b();
        if (r12 == null) goto L6;
    L7:
        String r1 = r12;
        com.bytedance.android.live.broadcastgame.api.model.r r13 = s().c();
        if (r13 == null) goto L10;
        Long r14 = Long.valueOf(r13.p());
    L11:
        com.bytedance.android.live.broadcastgame.api.interactgame.n.i(r0, r1, String.valueOf(r14), System.currentTimeMillis() - this.z, 0, ((BootInfoService) u().o(BootInfoService.class)).e());
        return;
    L10:
        r14 = null;
    L6:
        r12 = "0";
        goto L7
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.w
    public final PluginContext q(Map<String, ? extends Object> r14) {
        Intrinsics.checkNotNullParameter(r14, "params");
        com.bytedance.android.live.pushstream.d r1 = this.A;
        com.bytedance.android.live.broadcastgame.opengame.f r2 = this.t;
        com.bytedance.android.live.broadcastgame.api.model.r r0 = s().c();
        if (r0 == null) goto L8;
        String r3 = r0.b();
        if (r3 == null) goto L8;
        String r4 = r3;
    L9:
        com.bytedance.android.live.broadcastgame.api.model.r r5 = s().c();
        if (r5 == null) goto L15;
        String r6 = r5.c();
        if (r6 == null) goto L15;
        String r7 = r6;
    L16:
        String r8 = r4;
        String r9 = r7;
        this.v = new AnchorGameMessageChannel(r1, r2, r8, r9, this.j, s().c(), this);
        Context r11 = getContext();
        DataCenter r12 = this.i;
        com.bytedance.android.live.broadcastgame.opengame.i r13 = this.l;
        AnchorGameMessageChannel r15 = this.v;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("messageChannel");
    L20:
        return new PluginContext(r11, r12, r13, this, r15, r(), r14, this.k, false, this.A);
    L15:
        r7 = "";
    L8:
        r4 = "";
        goto L9
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.OpenApiSupportPluginRuntime, com.bytedance.android.live.broadcastgame.opengame.runtime.n
    public final void f(String r2, File r3) {
        super.f(r2, r3);
        r r0 = this.e;
        if (r0 == null) goto L6;
        r0.f(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.q
    public final void e(String r21, PluginType r22, Map<String, ? extends Object> r23, boolean r24, r r25) {
        Intrinsics.checkNotNullParameter(r21, "schema");
        Intrinsics.checkNotNullParameter(r22, "pluginType");
        Intrinsics.checkNotNullParameter(r23, "params");
        this.e = r25;
        Object r0 = r23.get("game");
        q0 r2 = null;
        if ((r0 instanceof com.bytedance.android.live.broadcastgame.api.model.u) == true) goto L5;
        r0 = null;
    L5:
        com.bytedance.android.live.broadcastgame.api.model.u r1 = (com.bytedance.android.live.broadcastgame.api.model.u) r0;
        if (r1 == null) goto L8;
        com.bytedance.android.live.broadcastgame.api.model.r r3 = r1.c();
    L9:
        if (r3 != null) goto L13;
        int r4 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.h("anchor open " + r21 + " fail: " + r1);
        return;
    L13:
        if (((Boolean) l30.a.getValue()).booleanValue() == false) goto L15;
        boolean r5 = com.bytedance.android.live.revenue.core.util.h.a;
        ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).notifyLowPriorityDownloadTask(Boolean.FALSE);
    L15:
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        this.d = r1;
        com.bytedance.android.live.broadcastgame.api.model.r r6 = s().c();
        if (r6 != null) goto L18;
        return;
    L18:
        if (TextUtils.isEmpty(r6.b()) == false) goto L26;
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L22;
        f2.c("appid is null", 0);
    L22:
        if (r25 == null) goto L44;
        r25.p("appid is null");
        return;
    L44:
        return;
    L26:
        if (y() == false) goto L39;
        IInteractService r7 = jc1.k.f(IInteractService.class);
        if (r7 == null) goto L32;
        com.bytedance.android.live.liveinteract.utils.n r8 = r7.getLinkMicGameTraceUtils();
        if (r8 == null) goto L32;
        com.bytedance.android.live.liveinteract.utils.n.a.a(r8, true, "start_game_start_api", "gameId: " + r6.b() + ", gameName: " + r6.q(), 4);
    L32:
        com.bytedance.android.live.broadcastgame.api.model.g r9 = r6.n();
        if (r9 == null) goto L35;
        r2 = r9.b();
    L35:
        if (r2 == null) goto L37;
        int r17 = 1;
    L38:
        RxUtilKt.i(((LinkMicGameApi) com.bytedance.android.live.network.c.b().e(LinkMicGameApi.class)).startgame(this.j, r6.b(), "danmu", 0, r17, null)).subscribe(new b(r6, this, r25, r21, r22, r23, r24), new c(this, r25, r23));
        return;
    L37:
        r17 = 0;
        goto L38
    L39:
        long r11 = r6.p();
        String r12 = r6.b();
        String r13 = r6.c();
        if (r13 != null) goto L42;
        r13 = "";
    L42:
        x(r11, r12, r13, r21, r22, r23, r24);
        Unit r14 = Unit.INSTANCE;
        return;
    L8:
        r3 = null;
        goto L9
    }

    public AnchorPluginRuntime(Context r11, DataCenter r12, long r13, com.bytedance.android.live.pushstream.d r15, com.bytedance.android.live.broadcastgame.opengame.f r16, com.bytedance.android.live.broadcastgame.opengame.i r17) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "dataCenter");
        Intrinsics.checkNotNullParameter(r15, "liveStream");
        Intrinsics.checkNotNullParameter(r16, "gameIMManager");
        super(r11, r12, r13, true, r17, r16);
        this.A = r15;
        this.x = "";
    }
}
