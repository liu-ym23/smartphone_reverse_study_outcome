package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements Runnable {
    public final /* synthetic */ MmCoveredEditTextView a;

    public b(MmCoveredEditTextView r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.EditText, com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmCoveredEditTextView] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.widget.EditText, com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmCoveredEditTextView] */
    public final void a() {
        long r0 = SystemClock.uptimeMillis();
        ?? r2 = this.a;
        long r1 = r0 - r2.i;
        if (r2.isFocused() == false) goto L16;
        MmCoveredEditTextView r3 = this.a;
        if (r3.h == true) goto L16;
        if (r3.g == true) goto L16;
        if (0 <= r1) goto L11;
    L13:
        boolean r4 = false;
    L14:
        if (r4 == false) goto L16;
        int r5 = bwb.b.a;
        bwb.b.g(MmUiLogScene.FOUNDATION, "onKeyboardHide", "ignore keyboard hide before shown, elapsed=" + r1, null, 8);
        return;
    L11:
        if (r1 >= 1001) goto L13;
        r4 = true;
    L16:
        ?? r6 = this.a;
        r6.h = false;
        r6.clearFocus();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
