package com.bytedance.android.livesdk.common;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class b extends Dialog {
    public final boolean a;

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        com.bytedance.android.livesdk.f.d().f();
        com.bytedance.android.livesdk.e.b().d();
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r1 == null) goto L16;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L7;
        r0.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        Window r0 = getWindow();
        if (r0 == null) goto L9;
        r0.setBackgroundDrawable(new ColorDrawable(0));
        if (this.a == false) goto L7;
        r0.setLayout(-1, -2);
        return;
    L7:
        r0.setLayout(-2, -1);
        return;
    }

    @Override // android.app.Dialog
    public void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        com.bytedance.android.livesdk.f.d().a();
        com.bytedance.android.livesdk.e.b().a();
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public b(Context r3, boolean r4) {
        if (r4 == false) goto L4;
        int r0 = 2131954578;
    L5:
        super(r3, r0);
        Window r5 = getWindow();
        if (r5 == null) goto L11;
        getWindow().requestFeature(1);
        if (r4 == false) goto L10;
        r5.setGravity(80);
        goto L11
    L10:
        r5.setGravity(8388613);
    L11:
        this.a = r4;
        return;
    L4:
        r0 = 2131954584;
        goto L5
    }
}
