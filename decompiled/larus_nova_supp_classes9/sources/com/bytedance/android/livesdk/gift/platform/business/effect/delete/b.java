package com.bytedance.android.livesdk.gift.platform.business.effect.delete;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.annie.view.DoubleColorBallAnimationView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b extends Dialog {
    public DoubleColorBallAnimationView a;

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Activity r0 = getOwnerActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isFinishing() == true) goto L18;
        a(this);     // Catch: Exception -> L9
    L10:
        DoubleColorBallAnimationView r1 = this.a;
        if (r1 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mDoubleColorBallAnimationView");
    L13:
        r1.i = false;
        r1.g = false;
        r1.e = 0.0f;
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (isShowing() == true) goto L22;
        Activity r0 = getOwnerActivity();
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.isFinishing() == false) goto L10;
        return;
    L10:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L20;
        DialogLancet.handleBlockedDialogShow(this);
    L14:
        DoubleColorBallAnimationView r1 = this.a;
        if (r1 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mDoubleColorBallAnimationView");
    L17:
        r1.a();
        r1.i = true;
        r1.f = true;
        r1.postInvalidate();
        return;
    L20:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
    L13:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L14
    }

    public b(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, 2131954652);
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
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        setContentView(2131566119);
        this.a = findViewById(2131366924);
    }
}
