package com.larus.search.impl;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d extends t {
    public final /* synthetic */ BottomSheetBehavior<View> a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Dialog c;

    public final void onStateChanged(View r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "bottomSheet");
        if (r4 != 3) goto L5;
        ViewGroup.LayoutParams r5 = r3.getLayoutParams();
        r5.height = this.b;
        r3.setLayoutParams(r5);
        return;
    L5:
        if (r4 != 5) goto L7;
        Dialog r6 = this.c;
        Handler r7 = DialogLancet.resolveDialogHandler(r6);
        if (r7 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r6);
        return;
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r8 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r8 == null) goto L24;
        com.bytedance.crash.d.d(r8, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
        goto L24
    L13:
        if (Looper.myLooper() == r7.getLooper()) goto L15;
        r7.post(DialogLancet.createDismissRunnable(r6));
        return;
    L7:
        if (r4 != 6) goto L35;
        this.a.setState(5);
        return;
    }

    public d(BottomSheetBehavior<View> r1, int r2, Dialog r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
