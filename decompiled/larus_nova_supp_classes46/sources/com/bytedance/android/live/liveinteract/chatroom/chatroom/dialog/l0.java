package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l0 implements View.OnClickListener {
    public final /* synthetic */ TalkRoomFeedbackDialog a;

    public l0(TalkRoomFeedbackDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        TalkRoomFeedbackDialog r3 = this.a;
        int r0 = TalkRoomFeedbackDialog.r;
        r3.initData();
    }
}
