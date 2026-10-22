package zi0;

import com.bytedance.android.live.base.model.message.o2;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.z0;
import com.bytedance.android.live.liveinteract.multiscene.f;
import com.bytedance.android.live.liveinteract.multiscene.g;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.utils.y;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.InviteSource;
import com.bytedance.android.livesdk.chatroom.model.interact.m1;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static long a;
    public static g2 b;
    public static Long c;
    public static long d;

    public static final class a {
        public final com.bytedance.android.live.liveinteract.multiscene.a a;
        public final com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            com.bytedance.android.live.liveinteract.multiscene.a r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "RoomBattleReportInfo(teamFightInfo=" + this.a + ", fightState=" + this.b + ")";
        }

        public a(com.bytedance.android.live.liveinteract.multiscene.a r2, com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b r3) {
            Intrinsics.checkNotNullParameter(r3, "fightState");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public static void c(o2 r19) {
        if (r19 == null) goto L5;
        int r1 = r19.getFinishReason();
    L6:
        String r2 = k.n(IMiddlewareUserService.class).user().n();
        if (r19 == null) goto L12;
        String r3 = r19.getFinishUserIdString();
        if (r3 == null) goto L12;
        String r8 = r3;
    L14:
        if (Intrinsics.areEqual(r8, r2) == false) goto L16;
        String r4 = "anchor";
    L17:
        String r16 = r4;
        m r5 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r5 == null) goto L38;
        IRoom r6 = (IRoom) r5.getValue();
        if (r6 == null) goto L38;
        if (r6.isLiveTypeAudio() != true) goto L38;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r0 = IVoiceChatGuestService.a.a();
        if (r0 == null) goto L29;
        com.bytedance.android.live.liveinteract.voicechat.util.k r7 = r0.getLogger();
        if (r7 == null) goto L29;
    L28:
        com.bytedance.android.live.liveinteract.voicechat.util.k r9 = r7;
        if (r9 == null) goto L40;
        Integer r14 = Integer.valueOf(r1);
        if (r8 != null) goto L37;
        r8 = "";
    L37:
        com.bytedance.android.live.liveinteract.voicechat.util.k.m(r9, null, 16, 0, 0, r14, r8, r16, null, 259);
        return;
    L40:
        return;
    L29:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r10 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r10 == null) goto L32;
        r7 = r10.getLogger();
        goto L28
    L32:
        r7 = null;
    L38:
        TalkRoomLogUtils.L(16, 0, 0, Integer.valueOf(r1), r8, r16, null, 259);
        return;
    L16:
        r4 = "admin";
    L12:
        r8 = r2;
        goto L14
    L5:
        r1 = 1;
        goto L6
    }

    public static void f(com.bytedance.android.live.liveinteract.multiscene.a r7) {
        LinkedHashMap r0 = new LinkedHashMap();
        h(r0);
        TalkRoomLogUtils.J0(r0);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        TalkRoomLogUtils.u0(r0);
        r0.put("seat_fit_status", "off");
        if (d <= 0) goto L39;
        r0.put("duration", String.valueOf((System.currentTimeMillis() - d) / ((long) 1000)));
        d = 0;
        if (je0.d.f() != 16) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == false) goto L20;
        j r2 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r2 == null) goto L19;
        LivePlayModeLogContext r3 = (LivePlayModeLogContext) r2.getValue();
        if (r3 == null) goto L19;
        m r4 = r3.getPlayModes();
        if (r4 == null) goto L19;
        Set r5 = (Set) r4.getValue();
        if (r5 == null) goto L19;
        if (r5.contains(16) == true) goto L20;
    L19:
        String r6 = "link_room";
    L21:
        r0.put("play_mode", r6);
        String r8 = "0";
        if (r7 == null) goto L31;
        g r9 = r7.getRoomBattleContent();
        if (r9 == null) goto L31;
        com.bytedance.android.live.liveinteract.multiscene.c r10 = r9.getRoomBattleMode();
        if (r10 == null) goto L31;
        m1 r11 = r10.getRoomBattleThemeParam();
        if (r11 == null) goto L31;
        String r12 = String.valueOf(r11.getThemeId());
        if (r12 == null) goto L31;
    L32:
        r0.put("theme", r12);
        if (r7 == null) goto L37;
        com.bytedance.android.live.liveinteract.multiscene.j r13 = li0.d.a(r7);
        if (r13 == null) goto L37;
        r8 = com.bytedance.android.live.liveinteract.multiscene.k.b(r13);
    L37:
        r0.put("to_anchor_id", r8);
        j0.l().sendLog("livesdk_audience_playmode_room_link_duration", r0, new Object[]{IRoom.class});
        return;
    L31:
        r12 = "0";
    L20:
        r6 = u0.k(16);
        goto L21
    L7:
        r1 = false;
        goto L8
    }

    public static void g(com.bytedance.android.live.liveinteract.multiscene.a r6) {
        LinkedHashMap r2 = new LinkedHashMap();
        h(r2);
        r2.put("seat_fit_status", "off");
        String r0 = "0";
        if (r6 == null) goto L12;
        g r1 = r6.getRoomBattleContent();
        if (r1 == null) goto L12;
        com.bytedance.android.live.liveinteract.multiscene.c r3 = r1.getRoomBattleMode();
        if (r3 == null) goto L12;
        m1 r4 = r3.getRoomBattleThemeParam();
        if (r4 == null) goto L12;
        String r5 = String.valueOf(r4.getThemeId());
        if (r5 == null) goto L12;
    L13:
        r2.put("theme", r5);
        if (r6 == null) goto L18;
        com.bytedance.android.live.liveinteract.multiscene.j r7 = li0.d.a(r6);
        if (r7 == null) goto L18;
        r0 = com.bytedance.android.live.liveinteract.multiscene.k.b(r7);
    L18:
        r2.put("to_anchor_id", r0);
        m r8 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r8 == null) goto L34;
        IRoom r9 = (IRoom) r8.getValue();
        if (r9 == null) goto L34;
        if (r9.isLiveTypeAudio() != true) goto L34;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r10 = IVoiceChatGuestService.a.a();
        if (r10 == null) goto L28;
        com.bytedance.android.live.liveinteract.voicechat.util.k r11 = r10.getLogger();
        if (r11 == null) goto L28;
    L32:
        if (r11 == null) goto L35;
        com.bytedance.android.live.liveinteract.voicechat.util.k r12 = r11;
        com.bytedance.android.live.liveinteract.voicechat.util.k.t(r12, 16, r2, a, 3);
    L35:
        a = 0;
        return;
    L28:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r13 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r13 == null) goto L31;
        r11 = r13.getLogger();
        goto L32
    L31:
        r11 = null;
    L34:
        TalkRoomLogUtils.N(null, 16, r2, a, 3);
    L12:
        r5 = "0";
        goto L13
    }

    public static void h(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        LinkRoomFightContext r0 = LinkRoomFightContext.Companion.getContext();
        if (r0 == null) goto L23;
        m<com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b> r1 = r0.getFightState();
        if (r1 == null) goto L24;
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b r3 = (com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b) r1.getValue();
        if (r3 == null) goto L25;
        Intrinsics.checkNotNullParameter(r3, "fightState");
        if ((r3 instanceof com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.a) == false) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L18;
        String r5 = "processing";
    L21:
        r2.put("play_stage", r5);
        return;
    L18:
        if ((r3 instanceof com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.e) == false) goto L20;
        r5 = "punish";
        goto L21
    L20:
        r5 = "punish_finish";
        goto L21
    L11:
        if ((r3 instanceof com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.f) == true) goto L14;
        r4 = false;
        goto L15
    L25:
        return;
    L24:
        return;
    }

    public static void a(Map r19, Object r20) {
        Object r1 = r20;
        if ((r1 instanceof a) == true) goto L5;
        r1 = null;
    L5:
        a r2 = (a) r1;
        if (r2 == null) goto L8;
        com.bytedance.android.live.liveinteract.multiscene.a r3 = r2.a;
    L9:
        long r4 = System.currentTimeMillis();
        LinkRoomFightContext r6 = LinkRoomFightContext.Companion.getContext();
        if (r6 == null) goto L16;
        m<Long> r7 = r6.getStartFightTimestamp();
        if (r7 == null) goto L16;
        Long r8 = (Long) r7.getValue();
        if (r8 == null) goto L16;
        long r9 = r8.longValue();
    L17:
        long r5 = (r4 - r9) / ((long) 1000);
        if (r3 == null) goto L20;
        com.bytedance.android.live.liveinteract.multiscene.j r10 = li0.d.i(r3);
    L22:
        if (r10 == null) goto L26;
        List<f> r11 = r10.getPlayers();
        if (r11 == null) goto L26;
        int r12 = r11.size() - 1;
    L28:
        if (r10 == null) goto L30;
        long r13 = r10.getScore();
    L31:
        if (r3 == null) goto L33;
        com.bytedance.android.live.liveinteract.multiscene.j r14 = li0.d.a(r3);
    L34:
        if (r14 == null) goto L38;
        List<f> r15 = r14.getPlayers();
        if (r15 == null) goto L38;
        int r16 = r15.size() - 1;
    L39:
        if (r14 == null) goto L41;
        long r17 = r14.getScore();
    L42:
        if (r3 == null) goto L48;
        g r18 = r3.getRoomBattleContent();
        if (r18 == null) goto L48;
        if (r18.getInviteSource() != InviteSource.RANDOM_MATCH.getValue()) goto L48;
        String r21 = "passive_match";
    L59:
        if (r2 == null) goto L62;
        Object r22 = r2.b;
        if (r22 == null) goto L62;
    L63:
        r22.getClass();
        if ((r22 instanceof com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.a) == false) goto L66;
    L69:
        boolean r23 = true;
    L70:
        if (r23 == false) goto L73;
        String r24 = "processing";
    L76:
        if (r3 == null) goto L78;
        long r110 = r3.getDuration();
    L79:
        r19.put("pk_duration", String.valueOf(r110));
        if (r3 == null) goto L82;
        long r25 = r3.getDuration();
    L83:
        r19.put("actual_pk_duration", String.valueOf(RangesKt.coerceAtMost(r25, r5)));
        if (r3 == null) goto L88;
        com.bytedance.android.live.liveinteract.multiscene.j r26 = li0.d.a(r3);
        if (r26 == null) goto L88;
        Object r27 = com.bytedance.android.live.liveinteract.multiscene.k.b(r26);
    L89:
        r19.put("to_anchor_id", r27.toString());
        r19.put("money", String.valueOf(r13));
        r19.put("others_money", String.valueOf(r17));
        if (r3 == null) goto L112;
        com.bytedance.android.live.liveinteract.multiscene.j r28 = li0.d.i(r3);
        if (r28 == null) goto L112;
        List<f> r29 = r28.getPlayers();
        if (r29 == null) goto L112;
        ArrayList r30 = new ArrayList();
        Iterator<T> r31 = r29.iterator();
    L97:
        if (r31.hasNext() == false) goto L111;
        Object r32 = r31.next();
        f r33 = (f) r32;
        if (r33.getScoreFlex() <= 0) goto L108;
        String r34 = r33.getUserIdString();
        IRoom r35 = je0.d.e(null);
        if (r35 == null) goto L103;
        String r36 = r35.getOwnerUserIdString();
    L105:
        if ((!Intrinsics.areEqual(r34, r36)) == false) goto L108;
        boolean r37 = true;
    L109:
        if (r37 == false) goto L97;
        r30.add(r32);
        goto L97
    L103:
        r36 = null;
    L108:
        r37 = false;
        goto L109
    L111:
        int r38 = r30.size();
    L113:
        r19.put("income_guest_cnt", String.valueOf(r38));
        r19.put("anchor_type", r21);
        r19.put("play_stage", r24);
        r19.put("pk_guest_cnt", String.valueOf(r12));
        r19.put("others_pk_guest_cnt", String.valueOf(r16));
        return;
    L112:
        r38 = 0;
    L88:
        r27 = 0L;
        goto L89
    L82:
        r25 = 0;
        goto L83
    L78:
        r110 = 0;
        goto L79
    L73:
        if ((r22 instanceof com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.e) == false) goto L75;
        r24 = "punish";
        goto L76
    L75:
        r24 = "punish_finish";
        goto L76
    L66:
        if ((r22 instanceof com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.f) == true) goto L69;
        r23 = false;
    L62:
        r22 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b.C0093c.c;
    L48:
        if (r3 == null) goto L50;
        String r39 = r3.getInitiatorAnchorId();
    L51:
        IRoom r40 = je0.d.e(null);
        if (r40 == null) goto L54;
        String r41 = r40.getOwnerUserIdString();
    L56:
        if (Intrinsics.areEqual(r39, r41) == false) goto L58;
        r21 = "inviter";
        goto L59
    L58:
        r21 = "invitee";
        goto L59
    L54:
        r41 = null;
        goto L56
    L50:
        r39 = null;
        goto L51
    L41:
        r17 = 0;
    L38:
        r16 = 0;
        goto L39
    L33:
        r14 = null;
        goto L34
    L30:
        r13 = 0;
    L26:
        r12 = 0;
        goto L28
    L20:
        r10 = null;
    L16:
        r9 = r4;
        goto L17
    L8:
        r3 = null;
        goto L9
    }

    public static void b(Map r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "logMap");
        if (aj0.a.d() == true) goto L6;
        if (r5 == true) goto L6;
        return;
    L6:
        tc0.c r6 = tc0.c.h();
        boolean r0 = true;
        if (r6 == null) goto L28;
        Map r7 = r6.o;
        if (r7 == null) goto L28;
        if ((!r7.isEmpty()) != true) goto L28;
        tc0.c r8 = tc0.c.h();
        Long r1 = null;
        if (r8 == null) goto L19;
        Map r9 = r8.o;
        if (r9 == null) goto L19;
        Map.Entry r10 = z0.a(r9);
        if (r10 == null) goto L19;
        g2 r11 = (g2) r10.getValue();
    L20:
        b = r11;
        tc0.c r12 = tc0.c.h();
        if (r12 == null) goto L27;
        Map r13 = r12.o;
        if (r13 == null) goto L27;
        Map.Entry r14 = z0.a(r13);
        if (r14 == null) goto L27;
        r1 = (Long) r14.getKey();
    L27:
        c = r1;
    L19:
        r11 = null;
    L28:
        j r15 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r15 == null) goto L39;
        LivePlayModeLogContext r16 = (LivePlayModeLogContext) r15.getValue();
        if (r16 == null) goto L39;
        m r17 = r16.getPlayModes();
        if (r17 == null) goto L39;
        Set r18 = (Set) r17.getValue();
        if (r18 == null) goto L39;
        if (r18.contains(16) != true) goto L39;
    L40:
        if (r0 == false) goto L42;
        String r19 = PbRequest.SwitchType.PK;
    L43:
        r4.put("link_room_type", r19);
        r4.put("is_link_room", TalkRoomLogUtils.s);
        r4.put("to_room_id", String.valueOf(c));
        g2 r20 = b;
        if (r20 == null) goto L47;
        String r21 = r20.getAnchorIdString();
        if (r21 == null) goto L47;
    L48:
        r4.put("to_anchor_id", r21);
        g2 r22 = b;
        if (r22 != null) goto L51;
    L53:
        String r23 = "video_live";
    L54:
        r4.put("to_room_live_type", r23);
        return;
    L51:
        if (r22.getLiveRoomMode() != 3) goto L53;
        r23 = "voice_live";
    L47:
        r21 = "";
        goto L48
    L42:
        r19 = "link";
    L39:
        r0 = false;
        goto L40
    }

    public static void d(ILinkPlayerInfoBridge r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "userInfo");
        Intrinsics.checkNotNullParameter(r7, "actionType");
        LinkedHashMap r0 = new LinkedHashMap();
        IBaseUser r1 = r6.getUser();
        if (r1 == null) goto L7;
        String r2 = r1.getIdString();
        if (r2 == null) goto L7;
        r0.put("to_user_id", r2);
    L7:
        int r3 = y.a;
        LinkRoomFightContext r4 = LinkRoomFightContext.Companion.getContext();
        if (r4 == null) goto L19;
        m<com.bytedance.android.live.liveinteract.multiscene.a> r5 = r4.getFightInfo();
        if (r5 == null) goto L19;
        com.bytedance.android.live.liveinteract.multiscene.a r8 = (com.bytedance.android.live.liveinteract.multiscene.a) r5.getValue();
        if (r8 == null) goto L19;
        IBaseUser r9 = r6.getUser();
        if (r9 == null) goto L17;
        String r10 = r9.getIdString();
        if (r10 == null) goto L17;
    L18:
        f r11 = com.bytedance.android.live.liveinteract.multiscene.b.b(r8, r10);
    L20:
        if (r11 != null) goto L22;
        String r12 = "0";
    L27:
        if (r12 == null) goto L29;
        r0.put("others_income", r12);
    L29:
        String r13 = "guest";
        r0.put("to_user_type", "guest");
        Map.Entry r14 = tc0.c.h().p;
        if (r14 == null) goto L44;
        g2 r15 = (g2) r14.getValue();
        if (r15 == null) goto L34;
        String r16 = r15.getAnchorIdString();
    L35:
        IBaseUser r17 = r6.getUser();
        if (r17 == null) goto L38;
        String r18 = r17.getIdString();
    L40:
        if (Intrinsics.areEqual(r16, r18) == false) goto L42;
        Object r19 = "anchor";
    L43:
        r0.put("to_user_type", r19);
        goto L44
    L42:
        r19 = "guest";
        goto L43
    L38:
        r18 = null;
        goto L40
    L34:
        r16 = null;
    L44:
        TalkRoomLogUtils.J0(r0);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        TalkRoomLogUtils.u0(r0);
        Intrinsics.checkNotNullParameter(r0, "logMap");
        o r20 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r20 != null) goto L47;
    L57:
        r0.put("action_type", r7);
        j0.l().sendLog("livesdk_room_grouppk_others_guest_click", r0, new Object[]{IRoom.class});
        return;
    L47:
        if (Intrinsics.areEqual(r20.isAnchor(), Boolean.TRUE) == false) goto L49;
        r13 = "anchor";
    L56:
        r0.put("user_type", r13);
        goto L57
    L49:
        Integer r21 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r21 == null) goto L56;
        if (r21.intValue() != 0) goto L56;
        r13 = "user";
        goto L56
    L22:
        String r22 = r11.getUserIdString();
        f.b r23 = r11.getContributorsFlex();
        if (r23 == null) goto L25;
        List<String> r24 = r23.getUserIds();
    L26:
        r12 = y.a(r22, r24, r11.getScoreStrFlex(), r11.getScoreFuzzyFlex());
        goto L27
    L25:
        r24 = null;
    L17:
        r10 = "";
    L19:
        r11 = null;
        goto L20
    }

    public static void e(String r5, com.bytedance.android.live.liveinteract.multiscene.a r6) {
        d = System.currentTimeMillis();
        LinkedHashMap r0 = new LinkedHashMap();
        if (r5 != null) goto L5;
    L10:
        h(r0);
    L11:
        TalkRoomLogUtils.J0(r0);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        TalkRoomLogUtils.u0(r0);
        r0.put("seat_fit_status", "off");
        if (je0.d.f() != 16) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L27;
        j r8 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r8 == null) goto L26;
        LivePlayModeLogContext r9 = (LivePlayModeLogContext) r8.getValue();
        if (r9 == null) goto L26;
        m r10 = r9.getPlayModes();
        if (r10 == null) goto L26;
        Set r11 = (Set) r10.getValue();
        if (r11 == null) goto L26;
        if (r11.contains(16) == true) goto L27;
    L26:
        String r12 = "link_room";
    L28:
        r0.put("play_mode", r12);
        String r13 = "0";
        if (r6 == null) goto L38;
        g r3 = r6.getRoomBattleContent();
        if (r3 == null) goto L38;
        com.bytedance.android.live.liveinteract.multiscene.c r4 = r3.getRoomBattleMode();
        if (r4 == null) goto L38;
        m1 r14 = r4.getRoomBattleThemeParam();
        if (r14 == null) goto L38;
        String r15 = String.valueOf(r14.getThemeId());
        if (r15 == null) goto L38;
    L39:
        r0.put("theme", r15);
        if (r6 == null) goto L44;
        com.bytedance.android.live.liveinteract.multiscene.j r16 = li0.d.a(r6);
        if (r16 == null) goto L44;
        r13 = com.bytedance.android.live.liveinteract.multiscene.k.b(r16);
    L44:
        r0.put("to_anchor_id", r13);
        j0.l().sendLog("livesdk_audience_playmode_room_link", r0, new Object[]{IRoom.class});
        return;
    L38:
        r15 = "0";
    L27:
        r12 = u0.k(16);
        goto L28
    L14:
        r7 = false;
        goto L15
    L5:
        if (r5.length() <= 0) goto L7;
        boolean r17 = true;
    L8:
        if (r17 != true) goto L10;
        r0.put("play_stage", r5);
        goto L11
    L7:
        r17 = false;
        goto L8
    }
}
