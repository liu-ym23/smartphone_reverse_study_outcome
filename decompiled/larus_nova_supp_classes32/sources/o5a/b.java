package o5a;

import android.view.inputmethod.InputMethodManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;

    @Override // java.lang.Runnable
    public final void run() {
        ((InputMethodManager) this.a.e.getSystemService("input_method")).showSoftInput(this.a.h, 1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(a r1) {
        this.a = r1;
    }
}
