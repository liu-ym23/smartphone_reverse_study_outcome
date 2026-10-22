package com.bytedance.android.livesdk.floatview;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.floatview.mob.VideoFloatWindowLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ o a;
    public final /* synthetic */ Context b;

    public n(o r1, FragmentActivity r2) {
        this.a = r1;
        this.b = r2;
    }

    public static void a(o r3) {
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

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        com.bytedance.android.livesdk.sharedpref.e r3 = com.bytedance.android.livesdk.sharedpref.b.k0;
        Boolean r0 = Boolean.TRUE;
        r3.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r3, r0);
        if (p.e() == false) goto L9;
        a(this.a);
        if (rx1.m.f(this.b) == true) goto L7;
        p.h(this.b);
    L7:
        Lazy r4 = VideoFloatWindowLogger.a;
        VideoFloatWindowLogger.a.a().getClass();
        VideoFloatWindowLogger.c("open");
        return;
    L9:
        if (p.c() == true) goto L11;
        return;
    L11:
        if (rx1.m.e(this.b) == false) goto L13;
        a(this.a);
    L14:
        Lazy r5 = VideoFloatWindowLogger.a;
        VideoFloatWindowLogger.a.a().getClass();
        VideoFloatWindowLogger.c("open");
        return;
    L13:
        a(this.a);
        p.g(this.b);
        goto L14
    }
}
