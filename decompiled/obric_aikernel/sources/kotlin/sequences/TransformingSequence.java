package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class TransformingSequence<T, R> implements Sequence<R> {
    private final Sequence<T> sequence;
    private final Function1<T, R> transformer;

    /* JADX INFO: renamed from: kotlin.sequences.TransformingSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<R>, KMappedMarker {
        private final Iterator<T> iterator;
        final /* synthetic */ TransformingSequence<T, R> this$0;

        AnonymousClass1(TransformingSequence<T, R> r10) {
            this.this$0 = r10;
            this.iterator = TransformingSequence.access$getSequence$p(r10).iterator();
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
            return (R) TransformingSequence.access$getTransformer$p(this.this$0).invoke(this.iterator.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransformingSequence(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "sequence");
        Intrinsics.checkNotNullParameter(r11, "transformer");
        this.sequence = r10;
        this.transformer = r11;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(TransformingSequence r10) {
        return r10.sequence;
    }

    public static final /* synthetic */ Function1 access$getTransformer$p(TransformingSequence r10) {
        return r10.transformer;
    }

    public final <E> Sequence<E> flatten$kotlin_stdlib(Function1<? super R, ? extends Iterator<? extends E>> r10) {
        Intrinsics.checkNotNullParameter(r10, "iterator");
        return new FlatteningSequence(this.sequence, this.transformer, r10);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<R> iterator() {
        return new AnonymousClass1(this);
    }
}
