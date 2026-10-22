package com.ss.android.lark.flow.feed.long_click;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements View.OnLayoutChangeListener {
    public final /* synthetic */ UDDialog a;

    public b(UDDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        int r10 = r4 - r2;
        int r11 = r5 - r3;
        int r12 = r8 - r6;
        int r13 = r9 - r7;
        if (r12 <= 0) goto L24;
        if (r13 <= 0) goto L28;
        if (r10 != r12) goto L7;
        if (r11 != r13) goto L7;
        return;
    L7:
        com.ss.android.lark.flow.feed.utils.b.d("FeedFlowDialogBuilder", "item  size changed, dismiss dialog");
        UDDialog r14 = this.a;
        Handler r15 = DialogLancet.resolveDialogHandler(r14);
        if (r15 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r14);
        r14.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r14);
        return;
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r14);
        throw th;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r16 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r16 == null) goto L21;
        com.bytedance.crash.d.d(r16, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        goto L21
    L10:
        if (Looper.myLooper() == r15.getLooper()) goto L12;
        r15.post(DialogLancet.createDismissRunnable(r14));
        return;
    L28:
        return;
    }
}
