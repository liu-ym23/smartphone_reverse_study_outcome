package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements LiveSwitchButton.e {
    public final /* synthetic */ CommentSettingDialog a;
    public final /* synthetic */ DataCenter b;

    public j(CommentSettingDialog r1, DataCenter r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void d0(LiveSwitchButton r9, boolean r10) {
        if (r10 == false) goto L5;
        f2.b(2131923079, 0);
        String r0 = "on";
        int r1 = 51;
    L6:
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r2 == null) goto L14;
        com.bytedance.live.datacontext.m r3 = r2.getRoom();
        if (r3 == null) goto L14;
        Room r4 = (Room) r3.getValue();
        if (r4 == null) goto L14;
        String r5 = r4.getOwnerUserIdString();
        if (r5 == null) goto L14;
    L15:
        CommentSettingDialog r6 = this.a;
        long r7 = r6.h;
        LinkedHashMap r8 = new LinkedHashMap();
        r8.put("anchor_id", r5);
        r8.put("room_id", String.valueOf(r7));
        r8.put("action_type", r0);
        r8.putAll(r6.m);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_guest_video_send_permission_switch", r8, new Object[0]);
        ALogger.i("LiveVideoCommentPlayLog", "livesdk_guest_video_send_permission_switch: actionType=".concat(r0));
        AudioCommentApi.a.a((AudioCommentApi) com.bytedance.android.live.network.c.b().e(AudioCommentApi.class), this.a.h, r1, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.user.h());
        DataCenter r11 = this.b;
        if (r11 == null) goto L18;
        r11.put("data_room_video_comment_share_enable", Boolean.valueOf(r10));
    L18:
        com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.b.a1;
        Boolean r14 = Boolean.valueOf(r10);
        r13.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r13, r14);
        return;
    L14:
        r5 = "0";
        goto L15
    L5:
        f2.b(2131923077, 0);
        r0 = "off";
        r1 = 52;
        goto L6
    }
}
