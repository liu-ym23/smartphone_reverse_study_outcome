package com.bytedance.ai.debugscene;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v0 extends BottomSheetBehavior.BottomSheetCallback {
    public final /* synthetic */ w0.a a;

    public final void onSlide(View r1, float r10) {
        Intrinsics.checkNotNullParameter(r1, "view");
    }

    public v0(w0.a r1) {
        this.a = r1;
    }

    public final void onStateChanged(View r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        if (r11 != 5) goto L21;
        BottomSheetDialog r12 = this.a.i;
        Handler r13 = DialogLancet.resolveDialogHandler(r12);
        if (r13 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r12);
        r12.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r12);
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r14 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r14 == null) goto L18;
        com.bytedance.crash.d.d(r14, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r12);
        throw th;
    L7:
        if (Looper.myLooper() == r13.getLooper()) goto L9;
        r13.post(DialogLancet.createDismissRunnable(r12));
        return;
    }
}
