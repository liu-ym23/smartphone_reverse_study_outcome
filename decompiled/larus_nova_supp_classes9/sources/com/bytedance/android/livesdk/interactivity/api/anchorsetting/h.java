package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements LiveSwitchButton.e {
    public final /* synthetic */ CommentSettingDialog a;
    public final /* synthetic */ DataCenter b;

    public h(CommentSettingDialog r1, DataCenter r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void d0(LiveSwitchButton r6, boolean r7) {
        if (r7 == false) goto L5;
        com.bytedance.android.livesdk.log.u.l().d("livesdk_open_vocal_message", new Object[]{new am2.x(), Room.class});
        f2.b(2131915101, 0);
        this.a.S90(2131367430).setVisibility(0);
        int r8 = 26;
    L6:
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.b.X0;
        Integer r2 = Integer.valueOf(r8);
        r1.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r1, r2);
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.b.Y0;
        Boolean r4 = Boolean.valueOf(r7);
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, r4);
        AudioCommentApi.a.a((AudioCommentApi) com.bytedance.android.live.network.c.b().e(AudioCommentApi.class), this.a.h, r8, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.user.h());
        DataCenter r9 = this.b;
        if (r9 == null) goto L10;
        r9.put("data_room_audio_comment_enable", Boolean.valueOf(r7));
        return;
    L10:
        return;
    L5:
        f2.b(2131915099, 0);
        this.a.S90(2131367430).setVisibility(8);
        r8 = 27;
        goto L6
    }
}
