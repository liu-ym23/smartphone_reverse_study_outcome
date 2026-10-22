package com.ss.android.lark.officesdk.minutes.ui.foundation.widget;

import android.view.inputmethod.InputMethodManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements Runnable {
    public final /* synthetic */ MmCoveredEditTextView a;

    public a(MmCoveredEditTextView r1) {
        this.a = r1;
    }

    public final void a() {
        Object r1 = this.a.getContext().getSystemService("input_method");     // Catch: Exception -> L10
        if ((r1 instanceof InputMethodManager) == false) goto L6;
        InputMethodManager r2 = (InputMethodManager) r1;     // Catch: Exception -> L10
    L7:
        if (r2 == null) goto L15;
        r2.hideSoftInputFromWindow(this.a.getWindowToken(), 0);     // Catch: Exception -> L10
        return;
    L15:
        return;
    L6:
        r2 = null;
    L10:
        e = move-exception;
        int r3 = bwb.b.a;
        bwb.b.d(MmUiLogScene.FOUNDATION, "hideKeyboard", "error=" + e.getMessage(), null);
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
