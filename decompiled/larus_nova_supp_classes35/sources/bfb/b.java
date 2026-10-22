package bfb;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.feed.shared.data.UpdateRecord;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ UpdateRecord b;

    public b(a r1, UpdateRecord r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a(this.b);     // Catch: Throwable -> L4
        this.a.c = false;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
