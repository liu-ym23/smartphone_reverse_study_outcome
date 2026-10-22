package com.bytedance.android.live.effect;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e implements Runnable {
    public final /* synthetic */ LiveBeautifyDialogFragment a;

    public e(LiveBeautifyDialogFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LiveBeautifyDialogFragment r0 = this.a;     // Catch: Throwable -> L6
        int r1 = LiveBeautifyDialogFragment.j;     // Catch: Throwable -> L6
        r0.getClass();     // Catch: Throwable -> L6
        ConstraintLayout r2 = this.a.S90(2131378622);     // Catch: Throwable -> L6
        if (r2 == null) goto L9;
        r2.setVisibility(0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
