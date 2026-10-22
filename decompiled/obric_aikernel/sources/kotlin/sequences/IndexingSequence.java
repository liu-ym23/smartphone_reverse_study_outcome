package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class IndexingSequence<T> implements Sequence<IndexedValue<? extends T>> {
    private final Sequence<T> sequence;

    /* JADX INFO: renamed from: kotlin.sequences.IndexingSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<IndexedValue<? extends T>>, KMappedMarker {
        private int index;
        private final Iterator<T> iterator;

        AnonymousClass1(IndexingSequence<T> r10) {
            this.iterator = IndexingSequence.access$getSequence$p(r10).iterator();
        }

        public final int getIndex() {
            return this.index;
        }

        public final Iterator<T> getIterator() {
            return this.iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public IndexedValue<T> next() {
            int r10 = this.index;
            this.index = r10 + 1;
            if (r10 >= 0) goto L6;
            CollectionsKt.throwIndexOverflow();
        L6:
            return new IndexedValue(r10, this.iterator.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int r10) {
            this.index = r10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IndexingSequence(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "sequence");
        this.sequence = r10;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(IndexingSequence r10) {
        return r10.sequence;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<IndexedValue<T>> iterator() {
        return new AnonymousClass1(this);
    }
}
