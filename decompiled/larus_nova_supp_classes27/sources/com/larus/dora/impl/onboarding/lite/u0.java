package com.larus.dora.impl.onboarding.lite;

import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.e1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u0 implements Runnable {
    public final /* synthetic */ DoraLiteOnboardingWakeupFragment a;

    public u0(DoraLiteOnboardingWakeupFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoraLiteOnboardingWakeupFragment r0 = this.a;     // Catch: Throwable -> L6
        int r1 = DoraLiteOnboardingWakeupFragment.s;     // Catch: Throwable -> L6
        TextView r2 = r0.h;     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        e1.x(r2);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
