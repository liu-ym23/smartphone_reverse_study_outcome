package kotlinx.coroutines;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.coroutines.Continuation;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.internal.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class z1<U, T extends U> extends x<T> implements Runnable {
    public final long e;

    public final String W() {
        return super/*kotlinx.coroutines.a*/.W() + "(timeMillis=" + this.e + ')';
    }

    public final void n0() {
        long r0 = this.e;
        f0 r2 = DelayKt.getDelay(getContext());
        if ((r2 instanceof g0) == false) goto L5;
        g0 r3 = (g0) r2;
    L6:
        if (r3 == null) goto L9;
        Duration.Companion r4 = Duration.Companion;
        DurationKt.toDuration(r0, DurationUnit.MILLISECONDS);
        String r5 = r3.b();
        if (r5 == null) goto L9;
    L10:
        s(new TimeoutCancellationException(r5, this));
        return;
    L9:
        r5 = "Timed out waiting for " + r0 + " ms";
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        n0();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public z1(long r2, Continuation<? super U> r4) {
        super(r4.getContext(), r4);
        this.e = r2;
    }
}
