package o5a;

import android.view.inputmethod.InputMethodManager;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;

    @Override // java.lang.Runnable
    public final void run() {
        ((InputMethodManager) this.a.e.getSystemService("input_method")).hideSoftInputFromWindow(this.a.h.getWindowToken(), 0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public c(a r1) {
        this.a = r1;
    }
}
