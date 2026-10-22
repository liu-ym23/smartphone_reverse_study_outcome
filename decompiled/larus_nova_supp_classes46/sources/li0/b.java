package li0;

import com.bytedance.android.live.base.model.message.o2;
import com.bytedance.android.live.liveinteract.multiscene.f;
import com.bytedance.android.live.liveinteract.multiscene.j;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.util.k;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static long a;
    public static final b b = null;

    public static final class a {
        public final long a;
        public final String b;

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof a) == false) goto L10;
            a r7 = (a) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            if (r2 == null) goto L5;
            int r3 = r2.hashCode();
        L7:
            return r1 + r3;
        L5:
            r3 = 0;
            goto L7
        }

        public final String toString() {
            return "WatchInfo(duration=" + this.a + ", stage=" + this.b + ")";
        }

        public a(long r2, String r4) {
            Intrinsics.checkNotNullParameter(r4, "stage");
            this.a = r2;
            this.b = r4;
        }
    }

    public b() {
    }

    public static String c(int r1) {
        if (r1 != 1) goto L5;
        return "prepare";
    L5:
        if (r1 != 2) goto L7;
        return "processing";
    L7:
        if (r1 == 3) goto L10;
        return "";
    L10:
        return "punish";
    }

    public static String d(int r1) {
        if (r1 != 1) goto L7;
        return "red";
    L7:
        if (r1 != 2) goto L10;
        return "blue";
    L10:
        return "";
    }

    static {
        b = new b();
    }

    public static String b() {
        TeamFightContext.a r0 = TeamFightContext.Companion;
        if (r0.h() == true) goto L7;
        return null;
    L7:
        if (r0.d() == false) goto L11;
        return "prepare";
    L11:
        if (r0.e() == false) goto L14;
        return "punish";
    L14:
        return "processing";
    }

    public final void f() {
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("seat_fit_status", "off");
        k(r2);
        j(this, r2, null, true, 2);
        m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L18;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L18;
        if (r1.isLiveTypeAudio() != true) goto L18;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r3 = IVoiceChatGuestService.a.a();
        if (r3 == null) goto L12;
        k r4 = r3.getLogger();
        if (r4 == null) goto L12;
    L16:
        if (r4 == null) goto L19;
        k.t(r4, 7, r2, a, 3);
    L19:
        a = 0;
        return;
    L12:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r5 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r5 == null) goto L15;
        r4 = r5.getLogger();
        goto L16
    L15:
        r4 = null;
    L18:
        TalkRoomLogUtils.N(null, 7, r2, a, 3);
        goto L19
    }

    public static String a(com.bytedance.android.live.liveinteract.multiscene.a r1) {
        int r2 = r1.getTeamBattleType();
        if (r2 != 1) goto L5;
        return "fixed";
    L5:
        if (r2 == 2) goto L7;
        return "";
    L7:
        return "flexible";
    }

    public static void e(o2 r13) {
        boolean r0 = r13 instanceof o2;
        if (r0 == false) goto L5;
        int r2 = r13.getFinishReason();
    L7:
        if (r0 == false) goto L9;
        Object r14 = r13.getFinishUserIdString();
    L10:
        String r1 = jc1.k.n(IMiddlewareUserService.class).user().n();
        if (Intrinsics.areEqual(r14, 0L) == false) goto L14;
        r14 = r1;
    L14:
        if (Intrinsics.areEqual(r14, r1) == false) goto L16;
        String r3 = "anchor";
    L17:
        m r4 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r4 == null) goto L35;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L35;
        if (r5.isLiveTypeAudio() != true) goto L35;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r6 = IVoiceChatGuestService.a.a();
        if (r6 == null) goto L29;
        k r7 = r6.getLogger();
        if (r7 == null) goto L29;
    L28:
        k r8 = r7;
        if (r8 == null) goto L37;
        k.m(r8, null, 7, 0, 0, Integer.valueOf(r2), String.valueOf(r14), r3, null, 259);
        return;
    L37:
        return;
    L29:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r9 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r9 == null) goto L32;
        r7 = r9.getLogger();
        goto L28
    L32:
        r7 = null;
    L35:
        TalkRoomLogUtils.L(7, 0, 0, Integer.valueOf(r2), String.valueOf(r14), r3, null, 259);
        return;
    L16:
        r3 = "admin";
        goto L17
    L9:
        r14 = 0L;
        goto L10
    L5:
        r2 = 1;
        goto L7
    }

    public static void h(String r4) {
        Intrinsics.checkNotNullParameter(r4, "actionType");
        HashMap r0 = new HashMap();
        r0.put("action_type", r4);
        k(r0);
        TalkRoomLogUtils.B0(r0, null, null, 6);
        j0.l().sendLog("livesdk_grouppk_user_apply_panel", r0, new Object[]{IRoom.class});
    }

    public static void i(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "logMap");
        TeamFightContext.a r0 = TeamFightContext.Companion;
        if (r0.h() == false) goto L5;
    L6:
        com.bytedance.android.live.liveinteract.multiscene.a r1 = r0.b();
        if (r1 == null) goto L18;
        HashMap r5 = (HashMap) r4;
        r5.put("play_layout", a(r1));
        j r2 = d.i(r1);
        j r3 = d.a(r1);
        Long r6 = null;
        if (r2 == null) goto L11;
        Long r7 = r2.getMaxMember();
    L12:
        r5.put("grouppk_redcnt", String.valueOf(r7));
        if (r3 == null) goto L15;
        r6 = r3.getMaxMember();
    L15:
        r5.put("grouppk_bluecnt", String.valueOf(r6));
        return;
    L11:
        r7 = null;
        goto L12
    L18:
        return;
    L5:
        if (r0.g() == true) goto L6;
    }

    public static void k(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        String r0 = b();
        if (r0 == null) goto L6;
        r2.put("grouppk_stage", r0);
        return;
    }

    public static void g(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        Intrinsics.checkNotNullParameter(r5, "source");
        LinkedHashMap r1 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r1, null, null, 6);
        r1.put("request_page", r4);
        i0 r6 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.i1(r1);
        r1.put("source", r5);
        j0.l().sendLog("livesdk_grouppk_icon_click", r1, new Object[]{IRoom.class});
    }

    public static void j(b r2, Map r3, com.bytedance.android.live.liveinteract.multiscene.a r4, boolean r5, int r6) {
        String r1 = null;
        if ((r6 & 2) == 0) goto L5;
        r4 = null;
    L5:
        boolean r0 = false;
        if ((r6 & 4) == 0) goto L8;
        r5 = false;
    L8:
        r2.getClass();
        TeamFightContext.a r7 = TeamFightContext.Companion;
        if (r7.h() == false) goto L11;
    L13:
        if (r4 != null) goto L15;
        r4 = r7.b();
    L15:
        if (r4 == null) goto L61;
        r3.put("play_layout", a(r4));
        j r8 = d.i(r4);
        j r9 = d.a(r4);
        if (r8 == null) goto L19;
        Long r10 = r8.getMaxMember();
    L20:
        r3.put("grouppk_redcnt", String.valueOf(r10));
        if (r9 == null) goto L23;
        Long r11 = r9.getMaxMember();
    L24:
        r3.put("grouppk_bluecnt", String.valueOf(r11));
        r3.put("grouppk_playtime", String.valueOf(r4.getDuration()));
        m r12 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r12 == null) goto L29;
        IRoom r13 = (IRoom) r12.getValue();
        if (r13 == null) goto L29;
        r1 = r13.getOwnerUserIdString();
    L29:
        List<j> r14 = r4.getTeamInfos();
        if (r14 == null) goto L44;
        Iterator<T> r15 = r14.iterator();
    L33:
        if (r15.hasNext() == false) goto L44;
        j r16 = (j) r15.next();
        if (r16 == null) goto L33;
        List<f> r17 = r16.getPlayers();
        if (r17 == null) goto L33;
        Iterator<T> r18 = r17.iterator();
    L40:
        if (r18.hasNext() == false) goto L33;
        if (Intrinsics.areEqual(((f) r18.next()).getUserIdString(), r1) == false) goto L40;
        r0 = true;
    L44:
        if (r0 == false) goto L46;
        String r19 = "1";
    L47:
        r3.put("grouppk_anchorpart", r19);
        return;
    L46:
        r19 = "0";
        goto L47
    L23:
        r11 = null;
        goto L24
    L19:
        r10 = null;
        goto L20
    L61:
        return;
    L11:
        if (r7.g() == true) goto L13;
        if (r5 == true) goto L13;
    }
}
