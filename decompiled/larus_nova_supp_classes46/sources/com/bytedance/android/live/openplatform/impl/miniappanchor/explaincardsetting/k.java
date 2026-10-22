package com.bytedance.android.live.openplatform.impl.miniappanchor.explaincardsetting;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdk.widget.x0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements DialogInterface.OnClickListener {
    public final /* synthetic */ ExplainCardSettingDialog a;
    public final /* synthetic */ Ref.ObjectRef b;

    public k(ExplainCardSettingDialog r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r3, int r4) {
        ExplainCardSettingDialog r5 = this.a;
        int r6 = ExplainCardSettingDialog.k;
        r5.A1();
        x0 r7 = (x0) this.b.element;
        if (r7 == null) goto L21;
        Handler r8 = DialogLancet.resolveDialogHandler(r7);
        if (r8 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r7);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r9 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r9 == null) goto L18;
        com.bytedance.crash.d.d(r9, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
        throw th;
    L7:
        if (Looper.myLooper() == r8.getLooper()) goto L9;
        r8.post(DialogLancet.createDismissRunnable(r7));
        return;
    }
}
