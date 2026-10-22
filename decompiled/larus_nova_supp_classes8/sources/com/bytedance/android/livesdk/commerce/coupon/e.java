package com.bytedance.android.livesdk.commerce.coupon;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends Dialog {
    public final View a;

    public static void a(e r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        if (getWindow() != null) goto L6;
        a(this);
        return;
    L6:
        Window r3 = getWindow();
        if (r3 == null) goto L9;
        r3.setGravity(17);
    L9:
        View r4 = this.a;
        if (r4 == null) goto L26;
        setContentView(r4);
        Window r5 = getWindow();
        if (r5 == null) goto L14;
        r5.setLayout(-1, -1);
    L14:
        Window r6 = getWindow();
        if (r6 == null) goto L17;
        r6.setBackgroundDrawableResource(2131107029);
    L17:
        Window r7 = getWindow();
        if (r7 == null) goto L21;
        r7.setDimAmount(0.0f);
    L21:
        if (DigHoleScreenUtil.isDigHole(getContext()) == true) goto L28;
        Window r8 = getWindow();
        if (r8 == null) goto L29;
        r8.addFlags(1024);
        return;
    L29:
        return;
    L28:
        return;
    L26:
        a(this);
    }

    public e(Context r2, LiveCouponView r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = r3;
    }
}
