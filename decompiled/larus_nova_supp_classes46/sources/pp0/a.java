package pp0;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import yo2.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ View b;

    public a(b r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f r1 = this.a.c;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r1.i(this.b, 2, 3, s1.f(12.0f), s1.f(12.0f));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
