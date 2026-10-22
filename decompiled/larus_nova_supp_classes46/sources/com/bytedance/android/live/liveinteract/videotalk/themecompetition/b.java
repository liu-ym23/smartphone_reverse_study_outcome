package com.bytedance.android.live.liveinteract.videotalk.themecompetition;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.livesdk.chatroom.model.interact.SelectionType;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionRole;
import com.bytedance.android.livesdk.chatroom.model.interact.a2;
import com.bytedance.android.livesdk.chatroom.model.interact.b2;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.n;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final a a = null;

    static {
        a = new a();
    }

    public static void c() {
        LinkedHashMap r0 = new LinkedHashMap();
        Long r1 = null;
        TalkRoomLogUtils.B0(r0, null, null, 6);
        r0.put("source", a.b);
        r0.put("play_mode", u0.b());
        ThemedCompetitionContext.a r2 = ThemedCompetitionContext.Companion;
        ThemedCompetitionContext r3 = r2.getContext();
        if (r3 == null) goto L12;
        n<a2> r4 = r3.getInfo();
        if (r4 == null) goto L12;
        a2 r5 = (a2) r4.getValue();
        if (r5 == null) goto L12;
        b2 r6 = r5.getSetting();
        if (r6 == null) goto L12;
        String r7 = r6.getTheme();
        if (r7 == null) goto L12;
    L13:
        r0.put("theme", r7);
        ThemedCompetitionContext r8 = r2.getContext();
        if (r8 == null) goto L22;
        n<a2> r9 = r8.getInfo();
        if (r9 == null) goto L22;
        a2 r10 = (a2) r9.getValue();
        if (r10 == null) goto L22;
        b2 r11 = r10.getSetting();
        if (r11 == null) goto L22;
        r1 = Long.valueOf(r11.getWinCount());
    L22:
        r0.put("win_num", String.valueOf(r1));
        if (r2.b() != SelectionType.SCORING.getValue()) goto L47;
        ThemedCompetitionContext r12 = r2.getContext();
        if (r12 == null) goto L33;
        n<a2> r13 = r12.getInfo();
        if (r13 == null) goto L33;
        a2 r14 = (a2) r13.getValue();
        if (r14 == null) goto L33;
        b2 r15 = r14.getSetting();
        if (r15 == null) goto L33;
        long r16 = r15.getMaxScore();
    L34:
        r0.put("full_mark", String.valueOf(r16));
        ThemedCompetitionContext r17 = r2.getContext();
        if (r17 == null) goto L45;
        n<a2> r18 = r17.getInfo();
        if (r18 == null) goto L45;
        a2 r19 = (a2) r18.getValue();
        if (r19 == null) goto L45;
        b2 r20 = r19.getSetting();
        if (r20 == null) goto L45;
        if (r20.getCanEditScore() != true) goto L45;
        String r21 = "on";
    L46:
        r0.put("change_mark_status", r21);
    L45:
        r21 = "off";
    L33:
        r16 = 100;
    L47:
        zi0.d.b(r0, false);
        j0.l().sendLog("livesdk_anchor_playmode_open_success", r0, new Object[]{IRoom.class});
        return;
    L12:
        r7 = "";
        goto L13
    }

    public static void d() {
        LinkedHashMap r0 = new LinkedHashMap();
        Long r1 = null;
        TalkRoomLogUtils.B0(r0, null, null, 6);
        r0.put("play_mode", u0.b());
        a r2 = a;
        r2.getClass();
        r0.put("duration", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - r2.a)));
        ThemedCompetitionContext.a r3 = ThemedCompetitionContext.Companion;
        ThemedCompetitionContext r4 = r3.getContext();
        if (r4 == null) goto L12;
        n<a2> r5 = r4.getInfo();
        if (r5 == null) goto L12;
        a2 r6 = (a2) r5.getValue();
        if (r6 == null) goto L12;
        b2 r7 = r6.getSetting();
        if (r7 == null) goto L12;
        String r8 = r7.getTheme();
        if (r8 == null) goto L12;
    L13:
        r0.put("theme", r8);
        ThemedCompetitionContext r9 = r3.getContext();
        if (r9 == null) goto L22;
        n<a2> r10 = r9.getInfo();
        if (r10 == null) goto L22;
        a2 r11 = (a2) r10.getValue();
        if (r11 == null) goto L22;
        b2 r12 = r11.getSetting();
        if (r12 == null) goto L22;
        r1 = Long.valueOf(r12.getWinCount());
    L22:
        r0.put("win_num", String.valueOf(r1));
        zi0.d.b(r0, false);
        j0.l().sendLog("livesdk_anchor_playmode_over", r0, new Object[]{IRoom.class});
        return;
    L12:
        r8 = "";
        goto L13
    }

    public static void e() {
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r0, null, null, 6);
        r0.put("play_mode", u0.b());
        i0 r1 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.c1(r0);
        zi0.d.b(r0, false);
        j0.l().sendLog("livesdk_audience_playmode_room_watch", r0, new Object[]{IRoom.class});
    }

    public static void f() {
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r0, null, null, 6);
        r0.put("play_mode", u0.b());
        a r1 = a;
        r1.getClass();
        r0.put("duration", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - r1.a)));
        zi0.d.b(r0, false);
        j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r0, new Object[]{IRoom.class});
    }

    public static void b(boolean r3, int r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r0, null, null, 6);
        if (r3 == false) goto L5;
        String r5 = "anchor";
    L6:
        r0.put("user_type", r5);
        if (r4 != ThemedCompetitionRole.PERFORMER.getValue()) goto L10;
        String r6 = "cancel";
    L13:
        r0.put("btn_type", r6);
        j0.l().sendLog("livesdk_anchor_theme_perform_setting_show", r0, new Object[]{IRoom.class});
        return;
    L10:
        if (r4 != ThemedCompetitionRole.CONTESTANT.getValue()) goto L12;
        r6 = "perform";
        goto L13
    L12:
        r6 = "";
        goto L13
    L5:
        r5 = "admin";
        goto L6
    }

    public static void a(boolean r3, boolean r4, String r5, Long r6) {
        Intrinsics.checkNotNullParameter(r5, "toUserId");
        LinkedHashMap r0 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r0, null, null, 6);
        if (r3 == false) goto L5;
        String r7 = "anchor";
    L6:
        r0.put("user_type", r7);
        if (r4 == false) goto L9;
        String r8 = "perform";
    L10:
        r0.put("action_type", r8);
        r0.put("perform_user_id", r5.toString());
        IInteractService r9 = (IInteractService) k.f(IInteractService.class);
        if (r9 == null) goto L17;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r10 = r9.getLinkUserInfoCenter();
        if (r10 == null) goto L17;
        List<T> r11 = r10.getOnlineUserList();
        if (r11 == 0) goto L17;
        int r12 = r11.size();
    L18:
        if (r12 <= 0) goto L20;
        r12 = r12 - 1;
    L20:
        r0.put("seat_num", String.valueOf(r12));
        if (r6 == null) goto L23;
        r0.put("perform_duration", String.valueOf(r6.longValue()));
    L23:
        j0.l().sendLog("livesdk_anchor_theme_perform_setting_click", r0, new Object[]{IRoom.class});
        return;
    L17:
        r12 = 0;
        goto L18
    L9:
        r8 = "cancel";
        goto L10
    L5:
        r7 = "admin";
        goto L6
    }
}
