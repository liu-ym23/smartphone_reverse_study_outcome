package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JobSupport$b extends f1 {
    public final JobSupport e;
    public final JobSupport$c f;
    public final p g;
    public final Object h;

    public final void a(Throwable r5) {
        JobSupport r6 = this.e;
        JobSupport$c r0 = this.f;
        p r1 = this.g;
        Object r2 = this.h;
        AtomicReferenceFieldUpdater r3 = JobSupport.a;
        r6.getClass();
        p r4 = JobSupport.X(r1);
        if (r4 != null) goto L5;
    L7:
        r6.o(r6.B(r0, r2));
        return;
    L5:
        if (r6.j0(r0, r4, r2) == false) goto L7;
    }

    public JobSupport$b(JobSupport r1, JobSupport$c r2, p r3, Object r4) {
        this.e = r1;
        this.f = r2;
        this.g = r3;
        this.h = r4;
    }
}
