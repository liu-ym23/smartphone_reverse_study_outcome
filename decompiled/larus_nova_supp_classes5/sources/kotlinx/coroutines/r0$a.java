package kotlinx.coroutines;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r0$a extends r0$c {
    public final i<Unit> c;
    public final /* synthetic */ r0 d;

    @Override // java.lang.Runnable
    public final void run() {
        this.c.f(this.d, Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // kotlinx.coroutines.r0$c
    public final String toString() {
        return super.toString() + this.c;
    }

    public r0$a(r0 r1, long r2, j r4) {
        this.d = r1;
        super(r2);
        this.c = r4;
    }
}
