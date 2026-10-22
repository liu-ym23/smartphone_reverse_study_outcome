package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/TakeSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
public final class TakeSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    private final int count;
    private final Sequence<T> sequence;

    /* JADX INFO: renamed from: kotlin.sequences.TakeSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private final Iterator<T> iterator;
        private int left;

        AnonymousClass1(TakeSequence<T> r10) {
            this.left = TakeSequence.access$getCount$p(r10);
            this.iterator = TakeSequence.access$getSequence$p(r10).iterator();
        }

        public final Iterator<T> getIterator() {
            return this.iterator;
        }

        public final int getLeft() {
            return this.left;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.left > 0) goto L5;
        L7:
            return false;
        L5:
            if (this.iterator.hasNext() == false) goto L7;
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            int r10 = this.left;
            if (r10 == 0) goto L7;
            this.left = r10 - 1;
            return this.iterator.next();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setLeft(int r10) {
            this.left = r10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TakeSequence(Sequence<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "sequence");
        this.sequence = r10;
        this.count = r11;
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("count must be non-negative, but was " + r11 + '.').toString());
    L5:
        r12 = false;
        goto L6
    }

    public static final /* synthetic */ int access$getCount$p(TakeSequence r10) {
        return r10.count;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(TakeSequence r10) {
        return r10.sequence;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> drop(int r10) {
        int r11 = this.count;
        if (r10 < r11) goto L6;
        return SequencesKt.emptySequence();
    L6:
        return new SubSequence(this.sequence, r10, r11);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> take(int r10) {
        if (r10 < this.count) goto L6;
        return this;
    L6:
        return new TakeSequence(this.sequence, r10);
    }
}
