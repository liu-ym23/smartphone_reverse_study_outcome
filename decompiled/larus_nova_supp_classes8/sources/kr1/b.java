package kr1;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.vs_base.view.actionsheet.ReplayActionSheet;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ ReplayActionSheet a;

    public b(ReplayActionSheet r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.dismiss();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L12;
        d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
