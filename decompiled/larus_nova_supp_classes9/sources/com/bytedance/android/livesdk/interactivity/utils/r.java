package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.api.commentcontrol.utils.CommentControlSwitchHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreenpanel.enums.PanelItemSymbol;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class r {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(long r6, boolean r8, Map r9) {
        Intrinsics.checkNotNullParameter(r9, "extra");
        HashMap r0 = new HashMap();
        r0.putAll(r9);
        r0.put("item_id", String.valueOf(r6));
        String r10 = "1";
        if (r8 == false) goto L5;
        Object r11 = "1";
    L6:
        r0.put("is_anchor", r11);
        if (r6 != PanelItemSymbol.COMMENT_CONTROL_MODE.getId()) goto L31;
        RoomContext.a r7 = RoomContext.Companion;
        String r13 = null;
        RoomContext r4 = RoomContext.a.c(r7, null, 0, 3);
        if (r4 == null) goto L15;
        com.bytedance.live.datacontext.m r5 = r4.getRoom();
        if (r5 == null) goto L15;
        Room r14 = (Room) r5.getValue();
        if (r14 == null) goto L15;
        String r15 = r14.getIdStr();
    L16:
        r0.put("anchor_id", r15);
        RoomContext r16 = RoomContext.a.c(r7, null, 0, 3);
        if (r16 == null) goto L23;
        com.bytedance.live.datacontext.m r17 = r16.getRoom();
        if (r17 == null) goto L23;
        Room r18 = (Room) r17.getValue();
        if (r18 == null) goto L23;
        r13 = r18.getOwnerUserIdString();
    L23:
        r0.put("room_id", r13);
        long r19 = CommentControlSwitchHelper.b();
        if (r19 != 0) goto L27;
    L29:
        r10 = "0";
    L30:
        r0.put("item_style", r10);
        goto L31
    L27:
        if (r19 != 1) goto L29;
    L15:
        r15 = null;
    L31:
        com.bytedance.android.livesdk.log.u.l().sendLog("live_public_screen_action_sheet_item_click", r0, new Object[]{Room.class});
        return;
    L5:
        r11 = "0";
        goto L6
    }
}
