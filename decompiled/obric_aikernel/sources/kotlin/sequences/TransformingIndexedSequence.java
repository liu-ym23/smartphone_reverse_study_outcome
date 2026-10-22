package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class TransformingIndexedSequence<T, R> implements Sequence<R> {
    private final Sequence<T> sequence;
    private final Function2<Integer, T, R> transformer;

    /* JADX INFO: renamed from: kotlin.sequences.TransformingIndexedSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<R>, KMappedMarker {
        private int index;
        private final Iterator<T> iterator;
        final /* synthetic */ TransformingIndexedSequence<T, R> this$0;

        AnonymousClass1(TransformingIndexedSequence<T, R> r10) {
            this.this$0 = r10;
            this.iterator = TransformingIndexedSequence.access$getSequence$p(r10).iterator();
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
        public R next() {
            Function2 r10 = TransformingIndexedSequence.access$getTransformer$p(this.this$0);
            int r11 = this.index;
            this.index = r11 + 1;
            if (r11 >= 0) goto L6;
            CollectionsKt.throwIndexOverflow();
        L6:
            return (R) r10.invoke(Integer.valueOf(r11), this.iterator.next());
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
    public TransformingIndexedSequence(Sequence<? extends T> r10, Function2<? super Integer, ? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "sequence");
        Intrinsics.checkNotNullParameter(r11, "transformer");
        this.sequence = r10;
        this.transformer = r11;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(TransformingIndexedSequence r10) {
        return r10.sequence;
    }

    public static final /* synthetic */ Function2 access$getTransformer$p(TransformingIndexedSequence r10) {
        return r10.transformer;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<R> iterator() {
        return new AnonymousClass1(this);
    }
}
