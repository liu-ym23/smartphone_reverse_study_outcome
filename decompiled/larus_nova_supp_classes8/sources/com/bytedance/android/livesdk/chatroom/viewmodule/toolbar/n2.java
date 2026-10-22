package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.live.core.log.ALogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n2 extends Dialog {

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ n2 a;

        public a(n2 r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            List<i2.a> r5 = i2.a;
            i2.b = false;
            n2 r6 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r6);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r6));
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        List<i2.a> r0 = i2.a;
        i2.b = false;
        ALogger.w("ShadowNoneBrightnessDialog", "dialog dismiss");
        Handler r1 = DialogLancet.resolveDialogHandler(this);
        if (r1 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r2 == null) goto L16;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r1.getLooper()) goto L7;
        r1.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        Window r0 = getWindow();
        if (r0 == null) goto L6;
        WindowManager.LayoutParams r1 = r0.getAttributes();
        r1.screenBrightness = 0.1f;
        r0.setAttributes(r1);
        r0.setDimAmount(0.0f);
        ALogger.w("ShadowNoneBrightnessDialog", "try set brightness to 0.1");
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        ALogger.w("ShadowNoneBrightnessDialog", "dialog show");
        List<i2.a> r0 = i2.a;
        i2.b = true;
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public n2(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, 2131954644);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r4) {
        Window r5 = getWindow();
        if (r5 == null) goto L5;
        r5.setLayout(-1, -1);
        WindowManager.LayoutParams r1 = r5.getAttributes();
        r1.screenBrightness = 0.1f;
        r5.setAttributes(r1);
        r5.setDimAmount(0.0f);
        ALogger.w("ShadowNoneBrightnessDialog", "try set brightness to 0.1");
    L5:
        View r6 = new View(getContext());
        r6.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r6.setOnClickListener(new a(this));
        setContentView(r6);
    }
}
