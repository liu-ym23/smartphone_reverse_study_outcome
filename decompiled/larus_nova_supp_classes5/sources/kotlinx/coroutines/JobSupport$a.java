package kotlinx.coroutines;

import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class JobSupport$a<T> extends j<T> {
    public final JobSupport i;

    public final Throwable A(JobSupport r3) {
        Object r0 = this.i.M();
        if ((r0 instanceof JobSupport$c) == false) goto L8;
        Throwable r1 = ((JobSupport$c) r0).b();
        if (r1 == null) goto L8;
        return r1;
    L8:
        if ((r0 instanceof t) == false) goto L12;
        return ((t) r0).a;
    L12:
        return r3.getCancellationException();
    }

    public JobSupport$a(Continuation<? super T> r2, JobSupport r3) {
        super(r2, 1);
        this.i = r3;
    }
}
