package com.bytedance.android.livesdk.interactivity.api.anchorsetting;

import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.livesdk.chatroom.ui.LiveSwitchButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d implements LiveSwitchButton.e {
    public final /* synthetic */ CommentSettingDialog a;

    public d(CommentSettingDialog r1) {
        this.a = r1;
    }

    public final void d0(LiveSwitchButton r4, boolean r5) {
        com.bytedance.android.livesdk.sharedpref.e r6 = com.bytedance.android.livesdk.sharedpref.b.b1;
        Boolean r0 = Boolean.valueOf(r5);
        r6.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r6, r0);
        AudioCommentApi r7 = (AudioCommentApi) com.bytedance.android.live.network.c.b().e(AudioCommentApi.class);
        long r1 = this.a.h;
        if (r5 == false) goto L5;
        int r8 = 53;
    L6:
        AudioCommentApi.a.a(r7, r1, r8, 0).compose(RxUtil.rxSchedulerHelper()).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L5:
        r8 = 54;
        goto L6
    }
}
