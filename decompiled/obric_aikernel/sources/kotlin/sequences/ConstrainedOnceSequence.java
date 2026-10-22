package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class ConstrainedOnceSequence<T> implements Sequence<T> {
    private final AtomicReference<Sequence<T>> sequenceRef;

    public ConstrainedOnceSequence(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "sequence");
        this.sequenceRef = new AtomicReference(r10);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        Sequence<T> r10 = this.sequenceRef.getAndSet(null);
        if (r10 == null) goto L7;
        return r10.iterator();
    L7:
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
