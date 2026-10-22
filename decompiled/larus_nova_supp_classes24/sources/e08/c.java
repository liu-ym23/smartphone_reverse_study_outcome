package e08;

import android.view.View;
import com.larksuite.component.ui.navigation.LKUISearchView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements Runnable {
    public final /* synthetic */ LKUISearchView a;

    @Override // java.lang.Runnable
    public final void run() {
        LKUISearchView r0 = this.a;     // Catch: Throwable -> L7
        View.OnFocusChangeListener r1 = r0.D;     // Catch: Throwable -> L7
        if (r1 == null) goto L5;
        r1.onFocusChange(r0.w, false);     // Catch: Throwable -> L7
    L5:
        LKUISearchView.b(this.a.w);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public c(LKUISearchView r1) {
        this.a = r1;
    }
}
