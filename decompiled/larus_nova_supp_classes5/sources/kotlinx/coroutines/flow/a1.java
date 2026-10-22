package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a1<T> implements d1<T>, Flow, l<T> {
    public final Job a;
    public final /* synthetic */ d1<T> b;

    public final Object collect(FlowCollector<? super T> r2, Continuation<?> r3) {
        return this.b.collect(r2, r3);
    }

    public final List<T> getReplayCache() {
        return this.b.getReplayCache();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a1(d1<? extends T> r1, Job r2) {
        this.a = r2;
        this.b = r1;
    }

    public final Flow<T> a(CoroutineContext r1, int r2, BufferOverflow r3) {
        return SharedFlowKt.fuseSharedFlow(this, r1, r2, r3);
    }
}
