package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class b1<T> implements i1<T>, Flow, l<T> {
    public final Job a;
    public final /* synthetic */ i1<T> b;

    public final Object collect(FlowCollector<? super T> r2, Continuation<?> r3) {
        return this.b.collect(r2, r3);
    }

    public final List<T> getReplayCache() {
        return this.b.getReplayCache();
    }

    public final T getValue() {
        return (T) this.b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b1(i1<? extends T> r1, Job r2) {
        this.a = r2;
        this.b = r1;
    }

    public final Flow<T> a(CoroutineContext r2, int r3, BufferOverflow r4) {
        kotlinx.coroutines.internal.b0 r0 = j1.a;
        if (r3 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L12;
        if (r3 == (-2)) goto L12;
    L15:
        return SharedFlowKt.fuseSharedFlow(this, r2, r3, r4);
    L12:
        if (r4 != BufferOverflow.DROP_OLDEST) goto L15;
        return this;
    L5:
        if (r3 >= 2) goto L7;
        r1 = true;
        goto L8
    }
}
