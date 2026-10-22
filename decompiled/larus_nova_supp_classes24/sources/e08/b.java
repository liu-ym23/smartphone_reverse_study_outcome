package e08;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.AppCompatEditText;
import com.larksuite.component.ui.navigation.LKUISearchView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements Runnable {
    public final /* synthetic */ LKUISearchView a;

    @Override // java.lang.Runnable
    public final void run() {
        LKUISearchView r0 = this.a;     // Catch: Throwable -> L9
        View.OnFocusChangeListener r1 = r0.D;     // Catch: Throwable -> L9
        if (r1 == null) goto L5;
        r1.onFocusChange(r0.w, true);     // Catch: Throwable -> L9
    L5:
        AppCompatEditText r2 = this.a.w;     // Catch: Throwable -> L9
        InputMethodManager r3 = (InputMethodManager) r2.getContext().getSystemService("input_method");     // Catch: Throwable -> L9
        if (r3 == null) goto L12;
        r3.showSoftInput(r2, 0);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }

    public b(LKUISearchView r1) {
        this.a = r1;
    }
}
