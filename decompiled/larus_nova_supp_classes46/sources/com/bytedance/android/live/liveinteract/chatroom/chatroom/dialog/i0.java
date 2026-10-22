package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i0 implements View.OnClickListener {
    public final /* synthetic */ TalkRoomFeedbackDialog a;

    public i0(TalkRoomFeedbackDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        TalkRoomFeedbackDialog.W90(this.a, "break");
        TalkRoomFeedbackDialog.V90(this.a, "reject");
        gd0.c r3 = this.a.l;
        if (r3 == null) goto L5;
        r3.onCancelClick();
    L5:
        this.a.Z90();
        this.a.dismiss();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L15;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
