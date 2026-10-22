package k20;

import am2.x;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.InteractGameLocalStatusUtils;
import com.bytedance.android.live.broadcastgame.api.model.ReloadPanelType;
import com.bytedance.android.live.broadcastgame.api.model.f0;
import com.bytedance.android.live.broadcastgame.api.model.h0;
import com.bytedance.android.live.broadcastgame.api.model.i0;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.h5.LinkMicGameApi;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.network.AnchorGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext;
import com.bytedance.android.live.broadcastgame.xplay.XplayMonitorSession;
import com.bytedance.android.live.broadcastgame.xplay.g0;
import com.bytedance.android.live.broadcastgame.xplay.q1;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxCompatKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.config.l30;
import com.bytedance.android.livesdk.config.xz0;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements b, o {
    public boolean a;
    public final p b;
    public final XplayInternalContext c;
    public final com.bytedance.android.live.broadcastgame.api.xplay.f d;
    public final XplayMonitorSession e;
    public final g0 f;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // k20.b
    public final void a(String r22) {
        Intrinsics.checkNotNullParameter(r22, "stopReason");
        if (this.a == true) goto L112;
        this.a = true;
        g0 r4 = this.f;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r22, "stopReason");
        Map<String, String> r5 = r4.a();
        r5.put("end_type", "abnormal");
        r5.put("miniplugin_live_scene_type", String.valueOf(com.bytedance.android.live.broadcastgame.api.interactgame.j.a()));
        r5.put("stop_reason", r22);
        u.l().sendLog("livesdk_live_game_end", r5, new Object[]{Room.class, x.class});
        g0 r6 = this.f;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r22, "stopReason");
        long r8 = System.currentTimeMillis() - r6.c;
        Map<String, String> r2 = r6.a();
        r2.put("source", r6.b);
        if (r8 > 0) goto L8;
        r8 = 0;
    L8:
        r2.put("duration", String.valueOf(r8));
        r2.put("stop_reason", r22);
        u.l().sendLog("livesdk_game_duration", r2, new Object[]{Room.class, x.class});
        if (this.b.d == false) goto L35;
        String r3 = (String) this.c.getOpenXplayStartId().getValue();
        ConcurrentHashMap r7 = (ConcurrentHashMap) com.bytedance.android.livesdk.sharedpref.b.w2.getValue();
        if (r7 == null) goto L27;
        String r9 = (String) r7.get("xplay_game_id");
        if (r9 != null) goto L15;
        r9 = "";
    L15:
        String r11 = (String) r7.get("xplay_room_id");
        if (r11 != null) goto L19;
        r11 = "";
    L19:
        if (r3.length() != 0) goto L21;
        boolean r13 = true;
    L22:
        if (r13 == false) goto L26;
        r3 = (String) r7.get("start_id");
        if (r3 != null) goto L26;
        r3 = "";
    L26:
        String r14 = r3;
    L29:
        if (r14.length() != 0) goto L31;
        boolean r12 = true;
    L32:
        if (r12 == true) goto L35;
        Lazy r15 = LiveOpenGameClient.d;
        AnchorGameNetApi r16 = (AnchorGameNetApi) LiveOpenGameClient.a.a().a(AnchorGameNetApi.class);
        p r17 = this.b;
        String r18 = r17.h.b;
        long r19 = r17.b;
        JSONObject r21 = new JSONObject();
        r21.put(OpenPlatformBaseDebugger.APP_ID, this.b.h.b);
        r21.put("room_id", this.b.b);
        r21.put("schema", this.b.h.f);
        r21.put("business_type", this.b.h.g);
        Unit r110 = Unit.INSTANCE;
        String r111 = r21.toString();
        JSONObject r23 = new JSONObject();
        r23.put("need_stop_xplay", GamePromoteDataContext.GAME_TYPE_MOBILE);
        r23.put("xplay_game_id", r9);
        r23.put("xplay_room_id", r11);
        RxUtilKt.h(RxCompatKt.b(r16.sendAppStop(r14, r18, r19, r111, r23.toString()).doFinally(new f(this)), RxUtil.rxRetryHelper(3))).subscribe(g.a, h.a);
        this.c.getOpenXplayStartId().setValue("");
        goto L35
    L31:
        r12 = false;
        goto L32
    L21:
        r13 = false;
        goto L22
    L27:
        r14 = r3;
        r9 = "";
        r11 = r9;
    L35:
        XplayScene r24 = (XplayScene) this.c.getCurrentScene().getValue();
        XplayScene r25 = XplayScene.TalkRoom;
        if (r24 == r25) goto L38;
    L64:
        InteractGameContext.Companion r26 = InteractGameContext.Companion;
        InteractGameContext r27 = r26.getContext();
        if (r27 == null) goto L69;
        n<i0> r28 = r27.getCurrentOpenPlatformAppInfo();
        if (r28 == null) goto L69;
        r28.setValue(null);
    L69:
        InteractGameContext r29 = r26.getContext();
        if (r29 == null) goto L74;
        m<Boolean> r31 = r29.isPlayingGame();
        if (r31 == null) goto L74;
        r31.setValue(Boolean.FALSE);
    L74:
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r32 = AnchorGameContext.a.a();
        if (r32 == null) goto L79;
        n<String> r33 = r32.getLynxDetailExtra();
        if (r33 == null) goto L79;
        r33.setValue(null);
    L79:
        AnchorGameContext r34 = AnchorGameContext.a.a();
        if (r34 == null) goto L84;
        n<h0.c> r35 = r34.getOpenGameLaunchResult();
        if (r35 == null) goto L84;
        r35.setValue(h0.d.a);
    L84:
        xs2.b.a().post(new f0((String) this.c.getOpenFeatureBinderId().getValue(), ReloadPanelType.FROM_CAHCE, false, false, 4));
        int r36 = InteractGameLocalStatusUtils.a;
        InteractGameLocalStatusUtils.c("open_app_status", String.valueOf(0));
        InteractGameLocalStatusUtils.a();
        if (((Boolean) l30.a.getValue()).booleanValue() == false) goto L88;
        boolean r37 = com.bytedance.android.live.revenue.core.util.h.a;
        ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).notifyLowPriorityDownloadTask(Boolean.TRUE);
    L88:
        if (jc1.k.n(IInteractService.class).isLinkCasting() == false) goto L90;
        jc1.k.n(IInteractService.class).onProgramStop();
    L90:
        this.e.getClass();
        jc1.k.n(IPerformanceManager.class).onModuleStop("open_platform_xplay");
        this.d.stop();
        this.a = false;
        XplayExternalContext r38 = XplayExternalContext.Companion.getContext();
        if (r38 == null) goto L95;
        m<Boolean> r39 = r38.getXplayRunning();
        if (r39 == null) goto L95;
        r39.setValue(Boolean.FALSE);
    L95:
        DataCenter r41 = this.b.i;
        if (r41 == null) goto L98;
        r41.put("xplay_run_status_change", Boolean.FALSE);
    L98:
        p r42 = this.b;
        if (r42.f == r25) goto L101;
    L103:
        f2.b(2131923556, 0);
    L105:
        if (((XplayScene) this.c.getCurrentScene().getValue()) != r25) goto L113;
        IInteractService r43 = jc1.k.f(IInteractService.class);
        if (r43 == null) goto L114;
        com.bytedance.android.live.liveinteract.utils.n r44 = r43.getLinkMicGameTraceUtils();
        if (r44 == null) goto L115;
        com.bytedance.android.live.liveinteract.utils.n.a.a(r44, this.b.d, "xplayTerminate", "stopReason: ".concat(r22), 4);
        return;
    L115:
        return;
    L114:
        return;
    L113:
        return;
    L101:
        if (r42.d == true) goto L103;
    L38:
        if (this.b.d == false) goto L64;
        IInteractService r45 = jc1.k.f(IInteractService.class);
        if (r45 == null) goto L45;
        com.bytedance.android.live.liveinteract.utils.m r46 = r45.getLinkMicGameLogUtils();
        if (r46 == null) goto L45;
        r46.c();
    L45:
        if (Intrinsics.areEqual(r22, "switch_game") == true) goto L58;
        long r47 = System.currentTimeMillis();
        InteractGameContext r48 = InteractGameContext.Companion.getContext();
        if (r48 == null) goto L53;
        m<Long> r49 = r48.getLastSwitchGameTime();
        if (r49 == null) goto L53;
        Long r51 = (Long) r49.getValue();
        if (r51 == null) goto L53;
        long r52 = r51.longValue();
    L54:
        long r53 = r47 - r52;
        PublishSubject<Unit> r54 = q1.a;
        if (r53 < ((Long) xz0.a.getValue()).longValue()) goto L58;
        boolean r210 = false;
    L59:
        LinkMicGameApi r55 = (LinkMicGameApi) com.bytedance.android.live.network.c.b().e(LinkMicGameApi.class);
        p r56 = this.b;
        long r57 = r56.b;
        String r58 = r56.h.b;
        if (r210 == false) goto L62;
        String r112 = "switch_game";
    L63:
        RxUtilKt.i(r55.stopGame(r57, r58, "danmu", r112).doFinally(i.a)).subscribe(j.a, k.a);
        goto L64
    L62:
        r112 = null;
    L53:
        r52 = 0;
    L58:
        r210 = true;
        goto L59
    }

    public e(p r2, XplayInternalContext r3, com.bytedance.android.live.broadcastgame.api.xplay.f r4, XplayMonitorSession r5, g0 r6) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        Intrinsics.checkNotNullParameter(r3, "xplayInternalContext");
        Intrinsics.checkNotNullParameter(r4, "instance");
        Intrinsics.checkNotNullParameter(r5, "xplayMonitorSession");
        Intrinsics.checkNotNullParameter(r6, "xplayLogService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
