package kotlinx.coroutines;

import java.util.concurrent.Future;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class g extends f1 {
    public final Future<?> e;

    public g(Future<?> r1) {
        this.e = r1;
    }

    public final void a(Throwable r2) {
        if (r2 == null) goto L5;
        this.e.cancel(false);
        return;
    }
}
