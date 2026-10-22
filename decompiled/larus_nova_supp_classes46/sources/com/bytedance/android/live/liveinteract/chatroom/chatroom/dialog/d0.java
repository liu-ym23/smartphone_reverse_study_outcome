package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.AudienceLeaveSourceEnum;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d0 {
    public static final /* synthetic */ int a = 0;

    public d0() {
    }

    static {
    }

    public static String a(int r1) {
        if (r1 != AudienceLeaveSourceEnum.AudienceLeave_Kick_Out.getValue()) goto L5;
    L8:
        return "anchor";
    L5:
        if (r1 == AudienceLeaveSourceEnum.AudienceLeave_Sys_Kick_Out.getValue()) goto L8;
        return "audience";
    }

    public static /* synthetic */ String c(Integer r1) {
        return b(r1, AudienceLeaveSourceEnum.AudienceLeave_Kick_Out.getValue());
    }

    public static String b(Integer r2, int r3) {
        int r0 = LinkmicSysKickOutSource.LinkmicKickOutSource_ByAudit.getSource();
        if (r2 != null) goto L6;
    L8:
        int r1 = LinkmicSysKickOutSource.LinkmicKickOutSource_NotInRtc.getSource();
        if (r2 != null) goto L12;
    L14:
        int r4 = LinkmicSysKickOutSource.LinkmicKickOutSource_NotInLinker.getSource();
        if (r2 != null) goto L18;
    L20:
        int r5 = LinkmicSysKickOutSource.LinkmicKickOutSource_UserOutOfPing.getSource();
        if (r2 != null) goto L24;
    L26:
        int r6 = LinkmicSysKickOutSource.LinkmicKickOutSource_CheckAudienceFail.getSource();
        if (r2 == null) goto L33;
        if (r2.intValue() != r6) goto L33;
        return "check_audience_fail";
    L33:
        if (r3 != AudienceLeaveSourceEnum.AudienceLeave_Kick_Out.getValue()) goto L35;
    L38:
        return "anchor_initiate";
    L35:
        if (r3 == AudienceLeaveSourceEnum.AudienceLeave_Sys_Kick_Out.getValue()) goto L38;
        return "audience_initiate";
    L24:
        if (r2.intValue() != r5) goto L26;
        return "user_out_of_ping";
    L18:
        if (r2.intValue() != r4) goto L20;
        return "not_in_linker";
    L12:
        if (r2.intValue() != r1) goto L14;
        return "not_in_rtc";
    L6:
        if (r2.intValue() != r0) goto L8;
        return "byaudit";
    }

    public static void d(long r3, String r5, String r6, String r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r5, "toAnchorId");
        Intrinsics.checkNotNullParameter(r6, "recommond");
        Intrinsics.checkNotNullParameter(r7, "action");
        HashMap r1 = new HashMap();
        r1.put("to_room_id", String.valueOf(r3));
        r1.put("to_anchor_id", r5);
        r1.put("recommend", r6);
        r1.put("action", r7);
        r1.put("connection_over_type", a(r8));
        r1.put("connection_over_type_detail", b(Integer.valueOf(r9), r8));
        r1.put("user_id", jc1.k.n(IMiddlewareUserService.class).user().n());
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_chatroom_audience_breakpage_room_click", r1, new Object[]{IRoom.class, am2.x.class});
    }
}
