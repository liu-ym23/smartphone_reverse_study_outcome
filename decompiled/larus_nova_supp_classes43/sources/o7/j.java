package o7;

import android.content.Context;
import android.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ int b;

    public j(Context r1) {
        this.a = r1;
        this.b = 2131894126;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.a, this.b, 0).show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
