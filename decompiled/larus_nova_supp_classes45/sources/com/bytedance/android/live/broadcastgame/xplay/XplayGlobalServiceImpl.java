package com.bytedance.android.live.broadcastgame.xplay;

import android.content.Context;
import com.bytedance.android.live.broadcast.api.model.OpenPlatformMgInfoModel;
import com.bytedance.android.live.broadcast.api.model.PreviewSourceParam;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.interactgame.InteractGameLocalStatusUtils;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayGuestType;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.network.AnchorGameNetApi;
import com.bytedance.android.live.broadcastgame.opengame.network.LiveOpenGameClient;
import com.bytedance.android.live.broadcastgame.xplay.littlewindow.XplayLittleWindowService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.depend.openplatform.IHostOpenPlatformGameService;
import com.bytedance.android.livehostapi.business.depend.xplay.IXplayApi;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.utils.b4;
import com.bytedance.android.livesdk.config.hb;
import com.bytedance.android.livesdk.config.mz0;
import com.bytedance.android.livesdk.config.tz0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.XplayAnchorCustomServerMergeConfig;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonObject;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayGlobalServiceImpl implements com.bytedance.android.live.broadcastgame.api.xplay.e {
    public static final LinkedHashSet<com.bytedance.android.live.broadcastgame.api.xplay.f> a = null;
    public static u b;
    public static final XplayGlobalServiceImpl c = null;

    public static final class a implements IXplayApi.IXplayInitCallback {
        public a() {
        }

        public final void onSuccess() {
            XplayLog.c("XplayGlobalService", "preload success");
        }

        public final void onFailure(int r3) {
            int r0 = XplayLog.a;
            XplayLog.b("XplayGlobalService", "preload failure: " + r3);
        }
    }

    public XplayGlobalServiceImpl() {
    }

    static {
        c = new XplayGlobalServiceImpl();
        a = new LinkedHashSet();
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final com.bytedance.android.live.broadcastgame.api.xplay.f n() {
        return (com.bytedance.android.live.broadcastgame.api.xplay.f) CollectionsKt.firstOrNull(a);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void a() {
        com.bytedance.android.live.broadcastgame.api.xplay.f r0 = n();
        if (r0 == null) goto L8;
        IXplayMainService r1 = (IXplayMainService) r0.getService(IXplayMainService.class);
        if (r1 == null) goto L9;
        r1.a();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void c() {
        IHostApp r0 = TTLiveSDK.hostService().hostApp();
        if (r0 == null) goto L11;
        IHostOpenPlatformGameService r1 = r0.getOpenPlatformGameService();
        if (r1 == null) goto L12;
        IXplayApi r2 = r1.getXplayApiV2();
        if (r2 == null) goto L13;
        XplayLog.c("XplayGlobalService", "preloading Xplay plugin");
        r2.initializeAsync(new a(), true);
        return;
    L13:
        return;
    L12:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void d() {
        com.bytedance.android.live.broadcastgame.api.xplay.f r0 = n();
        if (r0 == null) goto L8;
        com.bytedance.android.live.broadcastgame.xplay.container.a r1 = (com.bytedance.android.live.broadcastgame.xplay.container.a) r0.getService(com.bytedance.android.live.broadcastgame.xplay.container.a.class);
        if (r1 == null) goto L9;
        r1.d();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void g() {
        com.bytedance.android.live.broadcastgame.api.xplay.f r0 = n();
        if (r0 == null) goto L8;
        XplayLittleWindowService r1 = (XplayLittleWindowService) r0.getService(XplayLittleWindowService.class);
        if (r1 == null) goto L9;
        r1.i();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final boolean l() {
        if (n() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void b(boolean r2) {
        if (((Boolean) tz0.a.getValue()).booleanValue() == false) goto L8;
        u r0 = b;
        if (r0 == null) goto L9;
        r0.a(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "stopReason");
        u r0 = b;
        if (r0 == null) goto L5;
        r0.b(r2);
    L5:
        b = null;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void f(g10.b r3) {
        Intrinsics.checkNotNullParameter(r3, "extension");
        Set<g10.b> r1 = s.a;
        Intrinsics.checkNotNullParameter(r3, "extension");
        s.a.remove(r3);
        int r0 = XplayLog.a;
        XplayLog.a("XplayExtensionManager", "remove extension: " + r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void h(g10.b r3) {
        Intrinsics.checkNotNullParameter(r3, "extension");
        Set<g10.b> r1 = s.a;
        Intrinsics.checkNotNullParameter(r3, "extension");
        s.a.add(r3);
        int r0 = XplayLog.a;
        XplayLog.a("XplayExtensionManager", "add extension: " + r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void j(final com.bytedance.android.live.broadcastgame.api.xplay.p r13) {
        Intrinsics.checkNotNullParameter(r13, "newEnv");
        if (b == null) goto L7;
        IInteractGameService r0 = (IInteractGameService) jc1.k.f(IInteractGameService.class);
        if (r0 == null) goto L7;
        r0.stopRunningPlugin("start xplay plugin");
    L7:
        String r1 = r13.h.b;
        PublishSubject<Unit> r2 = q1.a;
        Intrinsics.checkNotNullParameter(r1, "appId");
        final XplayAnchorCustomServerMergeConfig r3 = (XplayAnchorCustomServerMergeConfig) ((Map) hb.a.getValue()).get(r1);
        if (r3 != null) goto L10;
        r3 = XplayAnchorCustomServerMergeConfig.Companion.getDEFAULT_ITEM();
    L10:
        int r4 = com.bytedance.android.live.broadcastgame.api.interactgame.j.a;
        boolean r5 = com.bytedance.android.live.broadcastgame.api.interactgame.j.e(r13.h.m);
        boolean r6 = false;
        if (((Boolean) mz0.a.getValue()).booleanValue() == true) goto L13;
    L16:
        final boolean r7 = false;
    L17:
        com.bytedance.android.live.broadcastgame.api.xplay.s r8 = r13.j;
        b4.a(r8, new XplayGlobalServiceImpl$appendNewEnv$$inlined$apply$lambda$1(r13, r13, r3, r7));
        if (r8 != null) goto L20;
    L40:
        u r9 = new u(r13);
        b = r9;
        com.bytedance.android.live.broadcastgame.api.xplay.p r14 = r9.b;
        if (r14.f == XplayScene.TalkRoom) goto L43;
    L59:
        XplayGamePlugin$launch$1 r15 = new XplayGamePlugin$launch$1(r9);
        Intrinsics.checkNotNullParameter(r15, "block");
        XplayCompositeTaskBuilderScopeImpl r11 = new XplayCompositeTaskBuilderScopeImpl(XplayTasksDslKt$taskGraph$1.INSTANCE);
        r15.invoke(r11);
        ((j1) r11.c.invoke(r11, r11.a)).a().a().subscribe(new v(r9), new w(r9));
        return;
    L43:
        if (r14.d == false) goto L59;
        IInteractService r16 = jc1.k.f(IInteractService.class);
        if (r16 == null) goto L49;
        com.bytedance.android.live.liveinteract.utils.m r17 = r16.getLinkMicGameLogUtils();
        if (r17 == null) goto L49;
        com.bytedance.android.live.broadcastgame.api.xplay.l r12 = r9.b.h;
        r17.a(r12.b, r12.c);
    L49:
        IInteractService r18 = jc1.k.f(IInteractService.class);
        if (r18 == null) goto L54;
        com.bytedance.android.live.liveinteract.utils.n r19 = r18.getLinkMicGameTraceUtils();
        if (r19 == null) goto L54;
        com.bytedance.android.live.liveinteract.utils.n.a.a(r19, true, "onClickDanmuStartPlayButton", "gameId: " + r9.b.h.b + ", gameName: " + r9.b.h.c, 4);
    L54:
        IInteractService r110 = jc1.k.f(IInteractService.class);
        if (r110 == null) goto L59;
        com.bytedance.android.live.liveinteract.utils.l r21 = r110.getLinkMicGameFullLinkMonitor();
        if (r21 == null) goto L59;
        LinkMonitorData r22 = LinkMonitorData.ClickStartDanmuGameButton;
        com.bytedance.android.live.broadcastgame.api.xplay.l r111 = r9.b.h;
        com.bytedance.android.live.liveinteract.utils.l.a.a(r21, r22, r111.b, r111.c, 0, null, null, "first", Integer.valueOf(XplayGuestType.DEFAULT.getGuestType()), null, 312);
        goto L59
    L20:
        if (r13.d == true) goto L22;
    L25:
        boolean r23 = false;
    L26:
        r8.g = r23;
        if (r13.d == true) goto L29;
    L33:
        r8.h = r6;
        if (r13.d == false) goto L38;
        XplayAnchorCustomServerMergeConfig.ClientMixInfo r24 = r3.getClientMixInfo();
        if (r24 == null) goto L38;
        Long r25 = r24.getAudioMixType();
    L39:
        r8.k = r25;
    L38:
        r25 = null;
        goto L39
    L29:
        if (r3.getOpen() == false) goto L33;
        if (r3.isInjectVideo() == false) goto L33;
        r6 = true;
        goto L33
    L22:
        if (r3.getOpen() == true) goto L24;
        if (r7 == false) goto L25;
    L24:
        r23 = true;
        goto L26
    L13:
        if (r13.f != XplayScene.Video) goto L16;
        if (r5 == true) goto L16;
        r7 = true;
        goto L17
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void k(final Context r21) {
        Intrinsics.checkNotNullParameter(r21, "context");
        RoomContext.a r1 = RoomContext.Companion;
        RoomContext r6 = RoomContext.a.c(r1, null, 0, 3);
        if (r6 == null) goto L7;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L7;
        Room r8 = (Room) r7.getValue();
    L8:
        RoomContext r2 = RoomContext.a.c(r1, null, 0, 3);
        if (r2 == null) goto L24;
        com.bytedance.live.datacontext.j r3 = r2.getPreviewSourceParam();
        if (r3 == null) goto L24;
        PreviewSourceParam r4 = (PreviewSourceParam) r3.getValue();
        if (r4 == null) goto L24;
        OpenPlatformMgInfoModel r5 = r4.getOpenPlatformMg();
        if (r5 == null) goto L24;
        String r9 = r5.getAppId();
        if (r9 == null) goto L24;
        if (r9.length() <= 0) goto L21;
        boolean r11 = true;
    L22:
        if (r11 != true) goto L24;
        final boolean r12 = true;
    L25:
        final Boolean r13 = (Boolean) com.bytedance.android.livesdk.sharedpref.b.j2.getValue();
        int r14 = InteractGameLocalStatusUtils.a;
        if (r8 == null) goto L28;
        long r15 = r8.getRoomId();
    L29:
        Function7<String, Long, String, Long, String, String, String, Unit> r16 = new XplayGlobalServiceImpl$continuePlay$1(r13, r12, r21);
        Intrinsics.checkNotNullParameter(r16, "notifyStop");
        ConcurrentHashMap r0 = (ConcurrentHashMap) com.bytedance.android.livesdk.sharedpref.b.w2.getValue();
        if (r0 == null) goto L86;
        String r17 = (String) r0.get("open_app_status");
        if (r17 == null) goto L34;
        long r18 = CastLongProtector.parseLong(r17);
    L35:
        String r19 = (String) r0.get("start_id");
        if (r19 != null) goto L38;
        r19 = "";
    L38:
        String r110 = (String) r0.get(OpenPlatformBaseDebugger.APP_ID);
        if (r110 != null) goto L41;
        r110 = "";
    L41:
        String r111 = (String) r0.get("room_id");
        if (r111 == null) goto L46;
        Long r112 = StringsKt.toLongOrNull(r111);
        if (r112 == null) goto L46;
        long r113 = r112.longValue();
    L47:
        String r22 = (String) r0.get("open_conn_id");
        if (r22 == null) goto L50;
        long r114 = CastLongProtector.parseLong(r22);
    L51:
        String r23 = (String) r0.get("xplay_game_id");
        if (r23 != null) goto L54;
        r23 = "";
    L54:
        String r24 = (String) r0.get("xplay_room_id");
        if (r24 != null) goto L57;
        r24 = "";
    L57:
        String r25 = (String) r0.get("live_scene");
        if (r25 != null) goto L61;
        r25 = "";
    L61:
        if (r19.length() != 0) goto L63;
        boolean r26 = true;
    L64:
        if (r26 == false) goto L66;
    L76:
        long r27 = 0;
    L77:
        boolean r115 = true;
    L79:
        if (r18 == r27) goto L87;
        if (r115 == false) goto L82;
        return;
    L82:
        if (r113 != r15) goto L89;
        r16.invoke(r19, Long.valueOf(r113), r110, Long.valueOf(r114), r23, r24, r25);
        ALogger.i("InteractGameLocalStatusUtils", "notify xplay app stop to audience");
        InteractGameLocalStatusUtils.c("open_app_status", String.valueOf(0));
        return;
    L89:
        return;
    L87:
        return;
    L66:
        if (Intrinsics.areEqual(r19, "0") == true) goto L76;
        if (r110.length() != 0) goto L70;
        boolean r28 = true;
    L71:
        if (r28 == true) goto L76;
        r27 = 0;
        if (r113 == 0) goto L77;
        r115 = false;
        goto L79
    L70:
        r28 = false;
        goto L71
    L63:
        r26 = false;
        goto L64
    L50:
        r114 = 0;
    L46:
        r113 = 0;
        goto L47
    L34:
        r18 = 0;
        goto L35
    L86:
        return;
    L28:
        r15 = 0;
        goto L29
    L21:
        r11 = false;
    L24:
        r12 = false;
    L7:
        r8 = null;
        goto L8
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void m(XplayScene r4) {
        Intrinsics.checkNotNullParameter(r4, "newScene");
        com.bytedance.android.live.broadcastgame.api.xplay.f r1 = n();
        if (r1 == null) goto L8;
        XplayLittleWindowService r2 = (XplayLittleWindowService) r1.getService(XplayLittleWindowService.class);
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r4, "newScene");
        r2.g.getCurrentScene().setValue(r4);
        r2.d.a();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void updateEnableAudioFrame(boolean r3) {
        com.bytedance.android.live.broadcastgame.api.xplay.f r0 = n();
        if (r0 == null) goto L8;
        IXplayCoreService r1 = (IXplayCoreService) r0.getService(IXplayCoreService.class);
        if (r1 == null) goto L9;
        r1.updateEnableAudioFrame(r3);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.api.xplay.e
    public final void i(Context r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "appId");
        RoomContext r9 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r9 != null) goto L5;
        return;
    L5:
        com.bytedance.live.datacontext.m r0 = r9.getRoom();
        if (r0 == null) goto L12;
        Room r1 = (Room) r0.getValue();
        if (r1 == null) goto L13;
        int r8 = com.bytedance.android.live.broadcastgame.api.interactgame.j.a();
        long r2 = Long.valueOf(r1.getRoomId()).longValue();
        long r3 = System.currentTimeMillis();
        ALogger.i("XplayGlobalService", "startXplay, currentLiveScene: " + r8 + ", appId: " + r14);
        ((XplayApi) com.bytedance.android.live.network.c.b().e(XplayApi.class)).getInteractEntranceItem(r14, r8, r2).observeOn(AndroidSchedulers.mainThread()).subscribe(new c0(r3, r8, r9, r15, r13), new d0(r3));
        return;
    L13:
        return;
    }

    public final void p(String r3, JsonObject r4, Function1<? super JsonObject, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "method");
        Intrinsics.checkNotNullParameter(r4, "param");
        com.bytedance.android.live.broadcastgame.api.xplay.f r0 = n();
        if (r0 == null) goto L8;
        e r1 = (e) r0.getService(e.class);
        if (r1 == null) goto L9;
        r1.handleAnchorPanelJSBInvoke(r3, r4, r5);
        return;
    L9:
        return;
    }

    public static final void o(String r8, String r9, long r11, long r12, String r14, String r15) {
        Lazy r0 = LiveOpenGameClient.d;
        AnchorGameNetApi r1 = (AnchorGameNetApi) LiveOpenGameClient.a.a().a(AnchorGameNetApi.class);
        JSONObject r2 = new JSONObject();
        r2.put("seq", -1);
        r2.put("conn_id", r12);
        Unit r13 = Unit.INSTANCE;
        String r6 = r2.toString();
        JSONObject r16 = new JSONObject();
        r16.put("need_stop_xplay", 1);
        r16.put("xplay_game_id", r14);
        r16.put("xplay_room_id", r15);
        r1.sendAppStop(r8, r9, r11, r6, r16.toString()).subscribe(z.a, a0.a);
    }
}
