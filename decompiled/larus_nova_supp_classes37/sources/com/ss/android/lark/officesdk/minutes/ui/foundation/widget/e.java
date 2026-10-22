package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.view.animation.TranslateAnimation;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e implements Runnable {
    public final /* synthetic */ MmSummaryLoadingTextView a;

    public e(MmSummaryLoadingTextView r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.ViewGroup, com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmSummaryLoadingTextView] */
    @Override // java.lang.Runnable
    public final void run() {
        ?? r0 = this.a;     // Catch: Throwable -> L10
        if (r0.e == true) goto L5;
        return;
    L5:
        if (r0.isAttachedToWindow() == false) goto L17;
        MmSummaryLoadingTextView r1 = this.a;     // Catch: Throwable -> L10
        TranslateAnimation r2 = r1.c;     // Catch: Throwable -> L10
        if (r2 == null) goto L18;
        r1.b.startAnimation(r2);     // Catch: Throwable -> L10
        return;
    L18:
        return;
    L17:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L19;
        throw th;
    }
}
