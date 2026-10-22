package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i implements LiveSwitchButton.e {
    public final /* synthetic */ CommentSettingDialog a;
    public final /* synthetic */ DataCenter b;

    public i(CommentSettingDialog r1, DataCenter r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void d0(LiveSwitchButton r5, boolean r6) {
        if (r6 == false) goto L4;
        int r7 = 28;
    L5:
        AudioCommentApi.a.a((AudioCommentApi) com.bytedance.android.live.network.c.b().e(AudioCommentApi.class), this.a.h, r7, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.user.h());
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.X0;
        Integer r8 = Integer.valueOf(r7);
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r0, r8);
        com.bytedance.android.livesdk.sharedpref.e r9 = com.bytedance.android.livesdk.sharedpref.b.Z0;
        Boolean r1 = Boolean.valueOf(r6);
        r9.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r9, r1);
        if (r6 == false) goto L8;
        com.bytedance.android.livesdk.log.u.l().d("livesdk_open_vocal_message_autoplay", new Object[]{new am2.x(), Room.class});
    L8:
        DataCenter r10 = this.b;
        if (r10 == null) goto L12;
        r10.put("data_room_audio_comment_auto_play", Boolean.valueOf(r6));
        return;
    L12:
        return;
    L4:
        r7 = 29;
        goto L5
    }
}
