package com.larus.dora.impl.onboarding.othersmart;

import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.e1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h0 implements Runnable {
    public final /* synthetic */ DoraExternalSmartOnboardingWakeupFragment a;

    public h0(DoraExternalSmartOnboardingWakeupFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoraExternalSmartOnboardingWakeupFragment r0 = this.a;     // Catch: Throwable -> L6
        int r1 = DoraExternalSmartOnboardingWakeupFragment.s;     // Catch: Throwable -> L6
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
