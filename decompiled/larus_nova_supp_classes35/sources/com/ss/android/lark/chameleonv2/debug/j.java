package com.ss.android.lark.chameleonv2.debug;

import android.animation.ValueAnimator;
import android.app.Dialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleonv2.debug.ui.LoadingView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements Runnable {
    public final /* synthetic */ f a;

    public j(f r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w0b.a r0 = this.a.a;     // Catch: Throwable -> L22
        if (r0 != null) goto L29;
    L20:
        this.a.a = null;     // Catch: Throwable -> L22
        return;
    L29:
    L12:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c("LoadingDialog", "Error closing dialog", e);     // Catch: Throwable -> L22
        goto L20
    L6:
        if (r0.e == false) goto L20;
        LoadingView r2 = r0.b;     // Catch: Exception -> L12 Throwable -> L22
        if (r2 == null) goto L14;
        ValueAnimator r3 = r2.g;     // Catch: Exception -> L12 Throwable -> L22
        if (r3 == null) goto L14;
        r2.clearAnimation();     // Catch: Exception -> L12 Throwable -> L22
        r3.setRepeatCount(1);     // Catch: Exception -> L12 Throwable -> L22
        r3.cancel();     // Catch: Exception -> L12 Throwable -> L22
        r3.end();     // Catch: Exception -> L12 Throwable -> L22
    L14:
        Dialog r4 = r0.d;     // Catch: Exception -> L12 Throwable -> L22
        if (r4 == null) goto L17;
        w0b.a.a(r4);     // Catch: Exception -> L12 Throwable -> L22
    L17:
        r0.d = null;     // Catch: Exception -> L12 Throwable -> L22
        r0.e = false;     // Catch: Exception -> L12 Throwable -> L22
    L22:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L26;
        return;
    L26:
        throw th;
    }
}
