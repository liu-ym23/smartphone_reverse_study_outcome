package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.widget.TalkRoomFeedbackView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h0 implements View.OnClickListener {
    public final /* synthetic */ TalkRoomFeedbackDialog a;

    public h0(TalkRoomFeedbackDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        if (TextUtils.isEmpty(((TalkRoomFeedbackView) this.a.S90(2131372320)).getSelectedTag()) == false) goto L7;
        f2.b(2131922740, 0);
        return;
    L7:
        if (TalkRoomFeedbackDialog.T90(this.a) == false) goto L18;
        this.a.Z90();
        TalkRoomFeedbackDialog.X90(this.a);
        this.a.dismiss();     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L19;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L19:
        return;
    }
}
