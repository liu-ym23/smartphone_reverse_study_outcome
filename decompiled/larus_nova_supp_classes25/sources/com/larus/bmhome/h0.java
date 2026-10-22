package com.larus.bmhome;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.d;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;
import nr8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h0 implements f09.a.a {
    public final /* synthetic */ Activity a;
    public final /* synthetic */ b b;

    public final void onPaused(Activity r4) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        if (Intrinsics.areEqual(r4, this.a) == false) goto L21;
        AppHost.a.a().f(this);
        b r5 = this.b;
        Handler r0 = DialogLancet.resolveDialogHandler(r5);
        if (r0 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r5);
        r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r5);
        return;
    L14:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r5);
        throw th;
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(r5));
        return;
    }

    public final void onPreDestroyed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onResumed(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onStart(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public final void onStopped(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
    }

    public h0(Activity r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onCreate(Activity r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
    }
}
