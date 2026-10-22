package kotlinx.coroutines.android;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class HandlerContext$a implements Runnable {
    public final /* synthetic */ i a;
    public final /* synthetic */ HandlerContext b;

    public HandlerContext$a(i r1, HandlerContext r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f(this.b, Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
