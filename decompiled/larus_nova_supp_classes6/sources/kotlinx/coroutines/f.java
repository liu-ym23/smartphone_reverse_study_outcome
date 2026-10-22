package kotlinx.coroutines;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class f implements h {
    public final Future<?> a;

    public final String toString() {
        return "CancelFutureOnCancel[" + this.a + ']';
    }

    public f(Future<?> r1) {
        this.a = r1;
    }

    public final void a(Throwable r2) {
        if (r2 == null) goto L5;
        this.a.cancel(false);
        return;
    }
}
