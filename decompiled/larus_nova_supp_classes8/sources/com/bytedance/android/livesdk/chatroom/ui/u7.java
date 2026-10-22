package com.bytedance.android.livesdk.chatroom.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class u7 extends Dialog {
    public LiveDoubleColorBallAnimationView a;
    public String b;

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (getOwnerActivity() != null) goto L5;
        return;
    L5:
        if (getOwnerActivity().isFinishing() == true) goto L18;
        a(this);     // Catch: Exception -> L9
    L10:
        LiveDoubleColorBallAnimationView r0 = this.a;
        if (r0 == null) goto L17;
        r0.setVisibility(8);
        return;
    L17:
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (getOwnerActivity() != null) goto L5;
        return;
    L5:
        if (getOwnerActivity().isFinishing() == false) goto L8;
        return;
    L8:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(this);
    L12:
        LiveDoubleColorBallAnimationView r0 = this.a;
        if (r0 == null) goto L20;
        r0.setVisibility(0);
        return;
    L20:
        return;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L11:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L12
    }

    public u7(Activity r2) {
        super(r2, 2131954606);
        setOwnerActivity(r2);
    }

    public static void a(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        super.dismiss();     // Catch: Exception -> L11 Throwable -> L17
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L11:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setContentView(2131566865);
        LiveDoubleColorBallAnimationView r3 = (LiveDoubleColorBallAnimationView) findViewById(2131370123);
        this.a = r3;
        r3.setVisibility(0);
        TextView r4 = (TextView) findViewById(2131388367);
        String r0 = this.b;
        if (r0 == null) goto L6;
        r4.setText(r0);
        return;
    }
}
