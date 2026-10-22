package com.bytedance.android.livesdk.interactivity.medialink.intercomment;

import am2.x;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d {
    public long a;

    public d() {
    }

    public static void a(Map r6) {
        Object r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 != null) goto L5;
    L7:
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r1 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
        if (r1 == null) goto L41;
        hy.e r2 = r1.Np();
        if (r2 == null) goto L42;
        List r3 = r2.getOnlineUserList();
        if (r3 == null) goto L43;
        Iterator r5 = r3.iterator();
    L15:
        if (r5.hasNext() == false) goto L23;
        Object r7 = r5.next();
        IBaseUser r8 = ((AnchorLinkUser) r7).getUser();
        if (r8 == null) goto L19;
        String r9 = r8.getIdString();
    L21:
        if ((!Intrinsics.areEqual(r9, ey.c.b())) == false) goto L15;
        r4 = r7;
        goto L23
    L19:
        r9 = null;
    L23:
        AnchorLinkUser r10 = (AnchorLinkUser) r4;
        if (r10 == null) goto L44;
        IBaseUser r11 = r10.getUser();
        String r13 = BuildConfig.FLAVOR;
        if (r11 == null) goto L29;
        String r14 = r11.getIdString();
        if (r14 == null) goto L29;
    L30:
        HashMap r15 = (HashMap) r6;
        r15.put("other_anchor_id", r14);
        IBaseUser r16 = r10.getUser();
        if (r16 == null) goto L36;
        String r17 = String.valueOf(r16.getLiveRoomId());
        if (r17 == null) goto L36;
        r13 = r17;
    L36:
        r15.put("other_room_id", r13);
        return;
    L29:
        r14 = BuildConfig.FLAVOR;
        goto L30
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L5:
        if (r0.isMediaRoom() != true) goto L7;
        ((HashMap) r6).put("is_media_room", "1");
        goto L7
    }

    public static void d(boolean r4) {
        HashMap r0 = new HashMap();
        if (r4 == false) goto L5;
        String r5 = "host";
    L6:
        r0.put("anchor_type", r5);
        a(r0);
        u.l().sendLog("livesdk_comment_interflow_introduction_click", r0, new Object[]{Room.class});
        return;
    L5:
        r5 = "guest";
        goto L6
    }

    public final void c(boolean r8) {
        long r0 = System.currentTimeMillis();
        long r2 = this.a;
        if (r2 != 0) goto L5;
    L7:
        this.a = r0;
        HashMap r1 = new HashMap();
        r1.put("connection_scene", "connection");
        a(r1);
        r1.put("channel_id", String.valueOf(e92.m.b()));
        com.bytedance.android.livesdk.log.g r3 = u.l();
        if (r8 == false) goto L10;
        String r9 = "livesdk_comment_interflow_icon_show";
    L11:
        r3.sendLog(r9, r1, new Object[]{Room.class, x.class});
        return;
    L10:
        r9 = "livesdk_comment_interflow_icon_show_audience";
        goto L11
    L5:
        if (Math.abs(r2 - r0) > 1200) goto L7;
    }

    public static void b(int r5, boolean r6) {
        HashMap r0 = new HashMap();
        r0.put("connection_scene", "connection");
        r0.put("channel_id", String.valueOf(e92.m.b()));
        String r2 = "1";
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.b.b3.getValue()).booleanValue() == false) goto L5;
        Object r1 = "1";
    L6:
        r0.put("is_remind_panel_show", r1);
        if (r5 == 4) goto L12;
        if (r5 != 1) goto L11;
        r2 = "2";
        goto L12
    L11:
        r2 = "0";
    L12:
        r0.put("is_interflowing", r2);
        a(r0);
        com.bytedance.android.livesdk.log.g r7 = u.l();
        if (r6 == false) goto L15;
        String r8 = "livesdk_comment_interflow_icon_click";
    L16:
        r7.sendLog(r8, r0, new Object[]{Room.class, x.class});
        return;
    L15:
        r8 = "livesdk_comment_interflow_icon_click_audience";
        goto L16
    L5:
        r1 = "0";
        goto L6
    }

    public static void e(boolean r5, boolean r6) {
        HashMap r0 = new HashMap();
        r0.put("connection_scene", "connection");
        r0.put("channel_id", String.valueOf(e92.m.b()));
        String r1 = "1";
        if (r5 == false) goto L5;
        Object r3 = "1";
    L6:
        r0.put("is_remind_panel_show", r3);
        if (r5 == true) goto L9;
        r1 = "2";
    L12:
        r0.put("is_no_more_remind_panel", r1);
        a(r0);
        u.l().sendLog("livesdk_comment_interflow_invite", r0, new Object[]{Room.class});
        return;
    L9:
        if (r6 == true) goto L12;
        r1 = "0";
        goto L12
    L5:
        r3 = "0";
        goto L6
    }
}
