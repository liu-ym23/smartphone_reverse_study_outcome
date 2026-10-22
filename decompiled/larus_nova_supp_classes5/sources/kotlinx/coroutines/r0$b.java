package kotlinx.coroutines;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r0$b extends r0$c {
    public final Runnable c;

    @Override // java.lang.Runnable
    public final void run() {
        this.c.run();     // Catch: Throwable -> L4
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

    public r0$b(long r1, Runnable r3) {
        super(r1);
        this.c = r3;
    }
}
