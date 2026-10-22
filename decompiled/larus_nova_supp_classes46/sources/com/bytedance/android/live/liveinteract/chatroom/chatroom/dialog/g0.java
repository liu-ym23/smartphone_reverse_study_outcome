package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.text.TextUtils;
import android.widget.Button;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.widget.TalkRoomFeedbackView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g0 implements TalkRoomFeedbackView.a {
    public final /* synthetic */ TalkRoomFeedbackDialog a;

    @Override // com.bytedance.android.live.liveinteract.chatroom.chatroom.widget.TalkRoomFeedbackView.a
    public final void a() {
        TalkRoomFeedbackDialog r0 = this.a;
        int r1 = TalkRoomFeedbackDialog.r;
        r0.Z90();
        if (TextUtils.isEmpty(((TalkRoomFeedbackView) this.a.S90(2131372320)).getSelectedTag()) == false) goto L7;
        Button r2 = (Button) this.a.S90(2131389780);
        if (r2 == null) goto L10;
        r2.setAlpha(0.34f);
    L10:
        TalkRoomFeedbackDialog.V90(this.a, "enter");
        return;
    L7:
        Button r3 = (Button) this.a.S90(2131389780);
        if (r3 == null) goto L10;
        r3.setAlpha(1.0f);
        goto L10
    }

    public g0(TalkRoomFeedbackDialog r1) {
        this.a = r1;
    }
}
