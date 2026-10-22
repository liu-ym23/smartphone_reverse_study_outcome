package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.widget.TalkRoomFeedbackView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e0 implements View.OnClickListener {
    public final /* synthetic */ TalkRoomFeedbackDialog a;

    public e0(TalkRoomFeedbackDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ((TalkRoomFeedbackView) this.a.S90(2131372320)).setVisibility(0);
        ((TextView) this.a.S90(2131390610)).setVisibility(4);
    }
}
