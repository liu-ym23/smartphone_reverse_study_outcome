package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/DropSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
public final class DropSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    private final int count;
    private final Sequence<T> sequence;

    /* JADX INFO: renamed from: kotlin.sequences.DropSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private final Iterator<T> iterator;
        private int left;

        AnonymousClass1(DropSequence<T> r10) {
            this.iterator = DropSequence.access$getSequence$p(r10).iterator();
            this.left = DropSequence.access$getCount$p(r10);
        }

        private final void drop() {
        L3:
            if (this.left <= 0) goto L7;
            if (this.iterator.hasNext() == false) goto L10;
            this.iterator.next();
            this.left--;
            goto L3
        L10:
            return;
        }

        public final Iterator<T> getIterator() {
            return this.iterator;
        }

        public final int getLeft() {
            return this.left;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            drop();
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            drop();
            return this.iterator.next();
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
    public DropSequence(Sequence<? extends T> r10, int r11) {
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

    public static final /* synthetic */ int access$getCount$p(DropSequence r10) {
        return r10.count;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(DropSequence r10) {
        return r10.sequence;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> drop(int r10) {
        int r11 = this.count + r10;
        if (r11 >= 0) goto L6;
        return new DropSequence(this, r10);
    L6:
        return new DropSequence(this.sequence, r11);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> take(int r10) {
        int r11 = this.count;
        int r12 = r11 + r10;
        if (r12 >= 0) goto L6;
        return new TakeSequence(this, r10);
    L6:
        return new SubSequence(this.sequence, r11, r12);
    }
}
