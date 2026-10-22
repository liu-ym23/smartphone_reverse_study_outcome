package w6a;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g implements h.c {
    public final /* synthetic */ AtomicInteger a;
    public final /* synthetic */ h.c b;

    @Override // w6a.h.c
    public final void a() {
        if (this.a.decrementAndGet() != 0) goto L8;
        h.c r0 = this.b;
        if (r0 == null) goto L9;
        r0.a();
        return;
    L9:
        return;
    }

    public g(AtomicInteger r1, x7a.d.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
