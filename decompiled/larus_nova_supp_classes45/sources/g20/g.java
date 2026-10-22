package g20;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements Runnable {
    public final /* synthetic */ TextView a;

    public g(TextView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();     // Catch: Throwable -> L7
        if (r0 == null) goto L6;
        LinearLayout.LayoutParams r1 = (LinearLayout.LayoutParams) r0;     // Catch: Throwable -> L7
        r1.setMargins(s1.f(4.0f), 0, 0, 0);     // Catch: Throwable -> L7
        this.a.setLayoutParams(r1);     // Catch: Throwable -> L7
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
