package w6a;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f implements h.b {
    public final /* synthetic */ AtomicInteger a;
    public final /* synthetic */ h.b b;

    public final void a() {
        if (this.a.decrementAndGet() != 0) goto L8;
        h.b r0 = this.b;
        if (r0 == null) goto L9;
        ((f) r0).a();
        return;
    L9:
        return;
    }

    public f(AtomicInteger r1) {
        this.a = r1;
        this.b = null;
    }
}
