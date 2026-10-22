package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class MergingSequence<T1, T2, V> implements Sequence<V> {
    private final Sequence<T1> sequence1;
    private final Sequence<T2> sequence2;
    private final Function2<T1, T2, V> transform;

    /* JADX INFO: renamed from: kotlin.sequences.MergingSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<V>, KMappedMarker {
        private final Iterator<T1> iterator1;
        private final Iterator<T2> iterator2;
        final /* synthetic */ MergingSequence<T1, T2, V> this$0;

        AnonymousClass1(MergingSequence<T1, T2, V> r10) {
            this.this$0 = r10;
            this.iterator1 = MergingSequence.access$getSequence1$p(r10).iterator();
            this.iterator2 = MergingSequence.access$getSequence2$p(r10).iterator();
        }

        public final Iterator<T1> getIterator1() {
            return this.iterator1;
        }

        public final Iterator<T2> getIterator2() {
            return this.iterator2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.iterator1.hasNext() == true) goto L5;
        L7:
            return false;
        L5:
            if (this.iterator2.hasNext() == false) goto L7;
            return true;
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) MergingSequence.access$getTransform$p(this.this$0).invoke(this.iterator1.next(), this.iterator2.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MergingSequence(Sequence<? extends T1> r10, Sequence<? extends T2> r11, Function2<? super T1, ? super T2, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "sequence1");
        Intrinsics.checkNotNullParameter(r11, "sequence2");
        Intrinsics.checkNotNullParameter(r12, "transform");
        this.sequence1 = r10;
        this.sequence2 = r11;
        this.transform = r12;
    }

    public static final /* synthetic */ Sequence access$getSequence1$p(MergingSequence r10) {
        return r10.sequence1;
    }

    public static final /* synthetic */ Sequence access$getSequence2$p(MergingSequence r10) {
        return r10.sequence2;
    }

    public static final /* synthetic */ Function2 access$getTransform$p(MergingSequence r10) {
        return r10.transform;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<V> iterator() {
        return new AnonymousClass1(this);
    }
}
