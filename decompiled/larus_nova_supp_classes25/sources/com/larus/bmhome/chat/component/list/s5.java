package com.larus.bmhome.chat.component.list;

import com.bytedance.crash.d;
import com.larus.common_ui.dialog.CommonDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class s5 implements Runnable {
    public final /* synthetic */ WeakReference a;

    public /* synthetic */ s5(WeakReference r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CommonDialog r0 = (CommonDialog) this.a.get();
        if (r0 == null) goto L13;
        r0.dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r1 = DialogFragmentLancet.sLastShowStack;
        if (r1 == null) goto L14;
        d.d(r1, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L14:
        return;
    }
}
