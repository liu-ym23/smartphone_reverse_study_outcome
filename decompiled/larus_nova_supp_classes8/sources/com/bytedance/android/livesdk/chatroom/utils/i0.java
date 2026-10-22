package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i0 implements com.bytedance.android.livesdk.log.filter.v {
    public static final i0 a = null;

    public i0() {
    }

    public final void Rd() {
    }

    public final void onRemove() {
    }

    static {
        a = new i0();
    }

    public final void L9(String r5, Map<String, String> r6) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "params");
        switch(r5.hashCode()) {
            case -1837102167: goto L66;
            case -1122536402: goto L63;
            case -1115849514: goto L60;
            case -1103263308: goto L57;
            case -804282046: goto L54;
            case -597919004: goto L51;
            case -546689387: goto L48;
            case -509441308: goto L45;
            case -505186085: goto L42;
            case 21313630: goto L39;
            case 516631638: goto L36;
            case 516908681: goto L33;
            case 524713797: goto L30;
            case 525059201: goto L27;
            case 1059589542: goto L24;
            case 1164596471: goto L21;
            case 1499179894: goto L18;
            case 1744840954: goto L15;
            case 2009019068: goto L12;
            case 2041791848: goto L9;
            case 2112674277: goto L6;
            default: goto L108;
        };
    L108:
        return;
    L6:
        if (r5.equals("livesdk_fans_club_join") == false) goto L87;
    L67:
        Boolean r3 = null;
        RoomContext r7 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r7 == null) goto L76;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();
        if (r8 == null) goto L76;
        Room r9 = (Room) r8.getValue();
        if (r9 == null) goto L76;
        IUser r10 = r9.author();
        if (r10 == null) goto L76;
        py.c r11 = r10.getMAuthenticationInfo();
    L77:
        if (r11 == null) goto L82;
        String r12 = r11.getEnterpriseVerifyReason();
        if (r12 == null) goto L82;
        r3 = Boolean.valueOf(com.bytedance.android.livesdk.live.a.c(r12));
    L82:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L84;
        String r13 = "1";
    L85:
        r6.put("clue_is_biz_account", r13);
        return;
    L84:
        r13 = "0";
    L76:
        r11 = null;
        goto L77
    L87:
        return;
    L9:
        if (r5.equals("livesdk_like") == true) goto L67;
        return;
    L12:
        if (r5.equals("livesdk_recharge_success") == true) goto L67;
        return;
    L15:
        if (r5.equals("livesdk_send_barrage") == true) goto L67;
        return;
    L18:
        if (r5.equals("livesdk_live_play") == true) goto L67;
        return;
    L21:
        if (r5.equals("livesdk_live_banner_click") == true) goto L67;
        return;
    L24:
        if (r5.equals("livesdk_live_user_report") == true) goto L67;
        return;
    L27:
        if (r5.equals("livesdk_redpackage_send") == true) goto L67;
        return;
    L30:
        if (r5.equals("livesdk_redpackage_grab") == true) goto L67;
        return;
    L33:
        if (r5.equals("livesdk_send_prop") == true) goto L67;
        return;
    L36:
        if (r5.equals("livesdk_send_gift") == true) goto L67;
        return;
    L39:
        if (r5.equals("livesdk_audience_live_message") == true) goto L67;
        return;
    L42:
        if (r5.equals("livesdk_unfollow") == true) goto L67;
        return;
    L45:
        if (r5.equals("livesdk_recharge_show") == true) goto L67;
        return;
    L48:
        if (r5.equals("livesdk_live_user_report_submit_success") == true) goto L67;
        return;
    L51:
        if (r5.equals("livesdk_live_click_user") == true) goto L67;
        return;
    L54:
        if (r5.equals("livesdk_follow") == true) goto L67;
        return;
    L57:
        if (r5.equals("livesdk_dislike") == true) goto L67;
        return;
    L60:
        if (r5.equals("livesdk_live_duration") == true) goto L67;
        return;
    L63:
        if (r5.equals("livesdk_share") == true) goto L67;
        return;
    L66:
        if (r5.equals("livesdk_fans_club_join_success") == true) goto L67;
    }
}
