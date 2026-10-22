package com.bytedance.android.live.liveinteract.revenue.game.linker;

import am2.x;
import ch0.e;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.model.interact.GameBarrageRtcInfo;
import com.bytedance.android.livesdk.chatroom.t;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.data.LiveWrappedStreamIndex;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamVideoType;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.type.LiveWrappedRoomProfile;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.livelink.kmp.api.base.event.EventCategory;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vb6.g;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class GameRtcRoomController implements c {
    public static final /* synthetic */ int m = 0;
    public boolean a;
    public boolean b;
    public String c;
    public li6.c d;
    public long e;
    public d f;
    public long g;
    public final HashSet<String> h;
    public final Set<String> i;
    public List<e> j;
    public final Lazy k;
    public final j1 l;

    public static final class a {
    }

    public static final class b extends vb6.a {
        public final /* synthetic */ GameRtcRoomController a;

        public final void H1() {
            StringBuilder r0 = new StringBuilder("onLinkSuccess, gameRtcExtInfo: ");
            v1 r1 = tc0.c.h().n;
            if (r1 == null) goto L7;
            GameBarrageRtcInfo r2 = r1.getGameBarrageRtcInfo();
            if (r2 == null) goto L7;
            String r3 = r2.getRtcExtInfo();
        L8:
            r0.append(r3);
            ALogger.i("GameRtcRoomController", r0.toString());
            v1 r4 = tc0.c.h().n;
            if (r4 == null) goto L26;
            GameBarrageRtcInfo r5 = r4.getGameBarrageRtcInfo();
            if (r5 == null) goto L27;
            cg6.a r6 = this.a.d();
            if (r6 == null) goto L28;
            g r7 = r6.O5();
            if (r7 == null) goto L29;
            yb6.e r8 = r7.j();
            if (r8 == null) goto L30;
            ei6.a r9 = r8.Z0();
            if (r9 == null) goto L31;
            li6.a r10 = r9.e();
            if (r10 == null) goto L32;
            li6.c r11 = r10.b(r5.getRtcExtInfo());
            if (r11 == null) goto L33;
            GameRtcRoomController r12 = this.a;
            long r13 = r5.getLinkerId();
            r12.getClass();
            Intrinsics.checkNotNullParameter(r11, "rtcExtInfo");
            ALogger.i("GameRtcRoomController", "onLinkSuccess");
            r12.g(r13, r11, "onLinkSuccess");
            return;
        L33:
            return;
        L32:
            return;
        L31:
            return;
        L30:
            return;
        L29:
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L7:
            r3 = null;
            goto L8
        }

        public final void M1() {
            ALogger.i("GameRtcRoomController", "onEndSuccess");
            GameRtcRoomController r0 = this.a;
            r0.getClass();
            ALogger.i("GameRtcRoomController", "onLinkEnd");
            if (r0.b == true) goto L5;
            return;
        L5:
            if (je0.d.D() == false) goto L7;
            String r1 = "退出聊天室";
        L8:
            r0.h("onLinkEnd", r1);
            return;
        L7:
            r1 = "嘉宾下麦";
            goto L8
        }

        public final void ra() {
            ALogger.i("GameRtcRoomController", "onLinkServiceDetach");
            GameRtcRoomController r0 = this.a;
            r0.getClass();
            ALogger.i("GameRtcRoomController", "onLinkEnd");
            if (r0.b == true) goto L5;
            return;
        L5:
            if (je0.d.D() == false) goto L7;
            String r1 = "退出聊天室";
        L8:
            r0.h("onLinkEnd", r1);
            return;
        L7:
            r1 = "嘉宾下麦";
            goto L8
        }

        public b(GameRtcRoomController r1) {
            this.a = r1;
        }
    }

    static {
    }

    public void j(String r1, String r2, boolean r3) {
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.game.linker.c
    public void attach() {
        ALogger.i("GameRtcRoomController", "attach");
        t r0 = m.b();
        if (r0 == null) goto L7;
        j r1 = r0.getMessageManager();
        if (r1 == null) goto L7;
        d r2 = (d) r1.getValue();
    L8:
        this.f = r2;
        if (r2 == null) goto L11;
        r2.addMessageListener(MessageType.LINK_MIC.getIntType(), (l) this.k.getValue());
    L11:
        d r3 = this.f;
        if (r3 == null) goto L14;
        r3.addMessageListener(MessageType.ANCHOR_LINK_GAME_VOICE_MESSAGE.getKey(), (l) this.k.getValue());
    L14:
        cg6.a r4 = d();
        if (r4 == null) goto L20;
        g r5 = r4.O5();
        if (r5 == null) goto L21;
        r5.X0(new b(this), true);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final String c() {
        li6.c r0 = this.d;
        if (r0 == null) goto L7;
        li6.b r1 = r0.c;
        if (r1 == null) goto L7;
        String r2 = r1.b;
    L9:
        return String.valueOf(r2);
    L7:
        r2 = null;
        goto L9
    }

    public final cg6.a d() {
        return this.l.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.game.linker.c
    public void detach() {
        ALogger.i("GameRtcRoomController", "detach");
        d r0 = this.f;
        if (r0 == null) goto L6;
        r0.removeMessageListener((l) this.k.getValue());
    L6:
        if (this.b == false) goto L9;
        h("linkmicClose", "退出聊天室");
        return;
    }

    public final void k() {
        if (this.b == false) goto L6;
        h("onGameUnload", "主播关玩法");
        return;
    }

    public void l() {
        ALogger.i("GameRtcRoomController", "onJoinGameRtcRoomSuccess");
        List<e> r0 = this.j;
        if (r0 == null) goto L5;
        n(r0, "onJoinGameRtcRoomSuccess");
    L5:
        String r1 = qi0.c.b;
        long r2 = this.e;
        qi0.c.b = qi0.c.i();
        qi0.c.c = qi0.c.j();
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("link_id", String.valueOf(r2));
        r3.put("game_id", qi0.c.i());
        r3.put("game_name", qi0.c.j());
        r3.put("user_id", gh0.a.c());
        if (je0.d.r() == false) goto L8;
        String r4 = "anchor";
    L9:
        r3.put("user_type", r4);
        ALogger.i("LinkMicGameLogUtil", "onBarrageMatchGameStart: " + r3);
        j0.l().sendLog("livesdk_barrage_match_game_start", r3, new Object[]{IRoom.class, x.class});
        return;
    L8:
        r4 = "guest";
        goto L9
    }

    public void m() {
        ALogger.i("GameRtcRoomController", "onleaveGameRtcRoom");
        Iterator<String> r0 = this.i.iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        String r1 = r0.next();
        cg6.a r2 = d();
        if (r2 == null) goto L4;
        hg6.g r3 = r2.getRtcManager();
        if (r3 == null) goto L4;
        ei6.a r4 = r3.V0();
        if (r4 == null) goto L4;
        gi6.e r5 = r4.getEventManager();
        if (r5 == null) goto L4;
        r5.c(r1);
        goto L4
    L14:
        this.i.clear();
        this.b = false;
        this.c = null;
        f();
    }

    public static String b() {
        return e(je0.d.a());
    }

    public final void f() {
        if (je0.d.D() == false) goto L14;
        cg6.a r0 = d();
        if (r0 == null) goto L15;
        hg6.g r1 = r0.getRtcManager();
        if (r1 == null) goto L16;
        ei6.a r2 = r1.V0();
        if (r2 == null) goto L17;
        ALogger.i("GameRtcRoomController", "invalidateSei");
        vi6.a r3 = r2.v();
        if (r3 == null) goto L18;
        r3.f();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public GameRtcRoomController(j1 r2) {
        Intrinsics.checkNotNullParameter(r2, "outerScopeProvider");
        this.l = r2;
        this.h = new HashSet();
        this.i = new LinkedHashSet();
        this.k = LazyKt.lazy(new GameRtcRoomController$mOnMessageListener$2(this));
    }

    public static String e(String r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        IInteractService r1 = (IInteractService) k.f(IInteractService.class);
        if (r1 == null) goto L19;
        i<ILinkPlayerInfoBridge> r2 = r1.getLinkUserInfoCenter();
        if (r2 == null) goto L19;
        ILinkPlayerInfoBridge r3 = (ILinkPlayerInfoBridge) r2.a5(r5, null);
        if (r3 == null) goto L19;
        String r4 = r3.getInteractId();
        if (r4 == null) goto L19;
        if (r4.length() <= 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L19;
        return r4;
    L16:
        r6 = false;
    L19:
        Map r7 = tc0.c.h().o;
        if (r7 == null) goto L37;
        Iterator r8 = r7.entrySet().iterator();
    L23:
        if (r8.hasNext() == false) goto L37;
        List r9 = ((g2) ((Map.Entry) r8.next()).getValue()).getLinkedUsers();
        if (r9 == null) goto L23;
        Iterator r10 = r9.iterator();
    L28:
        if (r10.hasNext() == false) goto L23;
        com.bytedance.android.livesdk.link.model.bridge.k r11 = (com.bytedance.android.livesdk.link.model.bridge.k) r10.next();
        IBaseUser r12 = r11.getUser();
        if (r12 == null) goto L32;
        String r13 = r12.getIdString();
    L34:
        if (Intrinsics.areEqual(r13, r5) == false) goto L28;
        return r11.getInteractId();
    L32:
        r13 = null;
    L37:
        return null;
    }

    @Override // com.bytedance.android.live.liveinteract.revenue.game.linker.c
    public void a(boolean r3) {
        ALogger.i("GameRtcRoomController", "onIsXplayRunningChange: " + r3);
        this.a = r3;
    }

    public final void h(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "source");
        if (this.b == true) goto L5;
        return;
    L5:
        ALogger.i("GameRtcRoomController", "leaveGameRtcRoom, source: " + r7 + ", endReason: " + r8);
        this.b = false;
        this.c = null;
        this.h.clear();
        String r2 = qi0.c.b;
        long r3 = this.e;
        Intrinsics.checkNotNullParameter(r8, "endReason");
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("link_id", String.valueOf(r3));
        r4.put("game_id", qi0.c.i());
        r4.put("game_name", qi0.c.j());
        r4.put("user_id", gh0.a.c());
        if (je0.d.r() == false) goto L8;
        String r5 = "anchor";
    L9:
        r4.put("user_type", r5);
        r4.put("end_reason", r8);
        ALogger.i("LinkMicGameLogUtil", "onBarrageMatchGameEnd: " + r4);
        j0.l().sendLog("livesdk_barrage_match_game_end", r4, new Object[]{IRoom.class, x.class});
        cg6.a r9 = d();
        if (r9 == null) goto L14;
        hg6.g r10 = r9.getRtcManager();
        if (r10 == null) goto L14;
        ei6.a r11 = r10.V0();
    L15:
        if (r11 != null) goto L18;
        ALogger.e("GameRtcRoomController", "leaveGameRtcRoom return, cause: Client is null");
        return;
    L18:
        cg6.a r12 = d();
        if (r12 == null) goto L27;
        hg6.g r13 = r12.getRtcManager();
        if (r13 == null) goto L27;
        ei6.a r14 = r13.V0();
        if (r14 == null) goto L27;
        ui6.d r15 = r14.l();
        if (r15 == null) goto L27;
        mi6.a r16 = r15.b();
    L28:
        if (r16 != null) goto L31;
        ALogger.i("GameRtcRoomController", "leaveGameRtcRoom return, cause: Client#rtcEngine is null");
        return;
    L31:
        cg6.a r17 = d();
        if (r17 == null) goto L51;
        hg6.g r18 = r17.getRtcManager();
        if (r18 == null) goto L51;
        ei6.a r19 = r18.V0();
        if (r19 == null) goto L51;
        si6.b r0 = r19.b();
        if (r0 == null) goto L40;
        r0.h(c(), String.valueOf(this));
    L40:
        ti6.d r1 = r19.p();
        if (r1 == null) goto L43;
        r1.a(c(), null);
    L43:
        ri6.b r6 = r19.r();
        if (r6 == null) goto L47;
        r6.c(false);
    L47:
        if (je0.d.D() == true) goto L51;
        ri6.b r20 = r19.r();
        if (r20 == null) goto L51;
        r20.D(bj6.a.b(r19), LiveWrappedStreamIndex.STREAM_INDEX_MAIN, String.valueOf(b()), 100);
    L51:
        m();
        return;
    L27:
        r16 = null;
    L14:
        r11 = null;
        goto L15
    L8:
        r5 = "guest";
        goto L9
    }

    public final void n(List<e> r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "mergeDataList");
        Intrinsics.checkNotNullParameter(r11, "source");
        this.j = r10;
        if (this.b == false) goto L22;
        ALogger.d("GameRtcRoomController", "updateCrossRoomSilenceState, source: ".concat(r11));
        Iterator<T> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L32;
        ILinkPlayerInfoBridge r0 = ((e) r12.next()).a;
        Intrinsics.checkNotNullParameter(r0, "linkPlayerInfo");
        Intrinsics.checkNotNullParameter(r11, "reason");
        if (r0.getRoomLinkSilenceStatus() != 1) goto L10;
        boolean r2 = true;
    L11:
        String r1 = r0.getInteractId();
        if (r1 == null) goto L6;
        if (r2 == false) goto L18;
        Intrinsics.checkNotNullParameter(r1, "interactId");
        if (this.h.contains(r1) == true) goto L18;
        ALogger.i("GameRtcRoomController", "checkAndDoMuteRemoteAVStream, interactId: " + r1 + ", currentSilence: true, reason: " + r11);
        i(r1, true, r11);
    L18:
        if (r2 == true) goto L6;
        Intrinsics.checkNotNullParameter(r1, "interactId");
        if (this.h.contains(r1) == false) goto L6;
        ALogger.i("GameRtcRoomController", "checkAndDoMuteRemoteAVStream, interactId: " + r1 + ", currentSilence: false, reason: " + r11);
        i(r1, false, r11);
        goto L6
    L10:
        r2 = false;
        goto L11
    L32:
        return;
    }

    public final void g(long r11, li6.c r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "rtcExtInfo");
        Intrinsics.checkNotNullParameter(r14, "source");
        StringBuilder r0 = new StringBuilder("joinGameRtcRoom, source: ");
        r0.append(r14);
        r0.append(", linkerId: ");
        r0.append(r11);
        r0.append(", rtcRoomId: ");
        li6.b r15 = r13.c;
        String r1 = null;
        if (r15 == null) goto L5;
        String r16 = r15.b;
    L6:
        r0.append(r16);
        r0.append(", rtcUserId: ");
        li6.b r17 = r13.c;
        if (r17 == null) goto L9;
        String r18 = r17.e;
    L10:
        r0.append(r18);
        ALogger.i("GameRtcRoomController", r0.toString());
        cg6.a r19 = d();
        if (r19 == null) goto L15;
        hg6.g r110 = r19.getRtcManager();
        if (r110 == null) goto L15;
        ei6.a r111 = r110.V0();
    L16:
        if (r111 != null) goto L19;
        ALogger.e("GameRtcRoomController", "joinGameRtcRoom failed, cause: Client is null");
        return;
    L19:
        cg6.a r112 = d();
        if (r112 == null) goto L28;
        hg6.g r113 = r112.getRtcManager();
        if (r113 == null) goto L28;
        ei6.a r114 = r113.V0();
        if (r114 == null) goto L28;
        ui6.d r115 = r114.l();
        if (r115 == null) goto L28;
        mi6.a r116 = r115.b();
    L29:
        if (r116 != null) goto L32;
        ALogger.e("GameRtcRoomController", "joinGameRtcRoom failed, cause: Client#rtcEngine is null");
        return;
    L32:
        cg6.a r117 = d();
        if (r117 == null) goto L37;
        hg6.g r118 = r117.getRtcManager();
        if (r118 == null) goto L37;
        ei6.a r119 = r118.V0();
    L39:
        if (r119 == null) goto L58;
        cg6.a r120 = d();
        if (r120 == null) goto L49;
        hg6.g r121 = r120.getRtcManager();
        if (r121 == null) goto L49;
        ei6.a r122 = r121.V0();
        if (r122 == null) goto L49;
        ui6.d r123 = r122.l();
        if (r123 == null) goto L49;
        mi6.a r124 = r123.b();
    L50:
        if (r124 == null) goto L58;
        cg6.a r125 = d();
        if (r125 == null) goto L58;
        hg6.g r126 = r125.getRtcManager();
        if (r126 == null) goto L58;
        if (r126.isEngineOn() != true) goto L58;
        boolean r127 = true;
    L59:
        if (r127 == true) goto L63;
        ALogger.e("GameRtcRoomController", "joinGameRtcRoom failed, cause: MultiLink#isLinkMicRtcEngineOn is false");
        return;
    L63:
        if (this.b == false) goto L73;
        String r128 = this.c;
        li6.b r4 = r13.c;
        if (r4 == null) goto L67;
        String r5 = r4.b;
    L69:
        if (Intrinsics.areEqual(r128, r5) == false) goto L72;
        ALogger.i("GameRtcRoomController", "joinGameRtcRoom return, cause: already join");
        return;
    L72:
        h("joinGameRtcRoom", "加入新的主主连线");
        goto L73
    L67:
        r5 = null;
    L73:
        cg6.a r129 = d();
        if (r129 == null) goto L123;
        hg6.g r130 = r129.getRtcManager();
        if (r130 == null) goto L124;
        ei6.a r131 = r130.V0();
        if (r131 == null) goto L125;
        this.e = r11;
        this.h.clear();
        yf2.d r12 = new yf2.d(LiveWrappedRoomProfile.LIVE, false, false, true, false);
        gi6.e r132 = r131.getEventManager();
        if (r132 == null) goto L84;
        String r133 = r132.a(EventCategory.RTC_ROOM_EVENT, null, new GameRtcRoomController$initRTCRoomEventObserver$1(this));
        if (r133 == null) goto L84;
        this.i.add(r133);
    L84:
        gi6.e r134 = r131.getEventManager();
        if (r134 == null) goto L89;
        String r135 = r134.a(EventCategory.RTC_ROOM_EVENT_EX, null, new GameRtcRoomController$initRTCRoomEventObserver$2(this));
        if (r135 == null) goto L89;
        this.i.add(r135);
    L89:
        this.d = r13;
        si6.b r6 = r131.b();
        if (r6 == null) goto L106;
        li6.b r136 = r13.c;
        if (r136 == null) goto L94;
        String r137 = r136.b;
    L95:
        String r7 = String.valueOf(r137);
        li6.b r138 = r13.c;
        if (r138 == null) goto L98;
        String r139 = r138.d;
    L99:
        String r8 = String.valueOf(r139);
        li6.b r140 = r13.c;
        if (r140 == null) goto L104;
        String r141 = r140.e;
        if (r141 == null) goto L104;
    L105:
        r6.e(r7, r8, new yf2.e(r141, ""), true, r12);
    L104:
        r141 = "";
        goto L105
    L98:
        r139 = null;
        goto L99
    L94:
        r137 = null;
    L106:
        ri6.b r142 = r131.r();
        if (r142 == null) goto L113;
        li6.b r143 = r13.c;
        if (r143 == null) goto L111;
        String r144 = r143.b;
    L112:
        String r145 = String.valueOf(r144);
        LiveWrappedStreamIndex r2 = LiveWrappedStreamIndex.STREAM_INDEX_3RD;
        zf2.d r9 = new zf2.d();
        r9.a = true;
        r9.c = false;
        r9.b = false;
        Unit r3 = Unit.INSTANCE;
        r142.r(r145, r2, r9);
        goto L113
    L111:
        r144 = null;
    L113:
        ti6.d r146 = r131.p();
        if (r146 == null) goto L119;
        li6.b r147 = r13.c;
        if (r147 == null) goto L118;
        r1 = r147.b;
    L118:
        r146.a(String.valueOf(r1), new ti6.i(bj6.a.b(r131), LiveWrappedMixedStreamVideoType.MIXED_STREAM_VIDEO_TYPE_3RD));
    L119:
        ri6.b r148 = r131.r();
        if (r148 == null) goto L126;
        r148.c(true);
        return;
    L126:
        return;
    L125:
        return;
    L124:
        return;
    L123:
        return;
    L49:
        r124 = null;
    L58:
        r127 = false;
    L37:
        r119 = null;
    L28:
        r116 = null;
    L15:
        r111 = null;
        goto L16
    L9:
        r18 = null;
        goto L10
    L5:
        r16 = null;
        goto L6
    }

    public final void i(String r9, boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "interactId");
        Intrinsics.checkNotNullParameter(r11, "reason");
        ALogger.i("GameRtcRoomController", "muteGameRtcRoomRemoteAudioStream, interactId: " + r9 + ", mute: " + r10 + ", reason: " + r11);
        cg6.a r0 = d();
        if (r0 == null) goto L7;
        hg6.g r1 = r0.getRtcManager();
        if (r1 == null) goto L7;
        ei6.a r2 = r1.V0();
    L8:
        if (r2 != null) goto L11;
        ALogger.w("GameRtcRoomController", "muteGameRtcRoomRemoteAudioStream return, cause: client is null");
        return;
    L11:
        if (r10 == false) goto L13;
        this.h.add(r9);
    L14:
        ri6.b r3 = r2.r();
        if (r3 == null) goto L18;
        r3.l(c(), LiveWrappedStreamIndex.STREAM_INDEX_3RD, r9, r10, r11);
        return;
    L18:
        return;
    L13:
        this.h.remove(r9);
    L7:
        r2 = null;
        goto L8
    }
}
