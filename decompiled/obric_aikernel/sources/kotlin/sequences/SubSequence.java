package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SubSequence\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,680:1\n1#2:681\n*E\n"})
public final class SubSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    private final int endIndex;
    private final Sequence<T> sequence;
    private final int startIndex;

    /* JADX INFO: renamed from: kotlin.sequences.SubSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private final Iterator<T> iterator;
        private int position;
        final /* synthetic */ SubSequence<T> this$0;

        AnonymousClass1(SubSequence<T> r10) {
            this.this$0 = r10;
            this.iterator = SubSequence.access$getSequence$p(r10).iterator();
        }

        private final void drop() {
        L3:
            if (this.position >= SubSequence.access$getStartIndex$p(this.this$0)) goto L7;
            if (this.iterator.hasNext() == false) goto L10;
            this.iterator.next();
            this.position++;
            goto L3
        L10:
            return;
        }

        public final Iterator<T> getIterator() {
            return this.iterator;
        }

        public final int getPosition() {
            return this.position;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            drop();
            if (this.position < SubSequence.access$getEndIndex$p(this.this$0)) goto L5;
        L7:
            return false;
        L5:
            if (this.iterator.hasNext() == false) goto L7;
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            drop();
            if (this.position >= SubSequence.access$getEndIndex$p(this.this$0)) goto L7;
            this.position++;
            return this.iterator.next();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setPosition(int r10) {
            this.position = r10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubSequence(Sequence<? extends T> r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "sequence");
        this.sequence = r10;
        this.startIndex = r11;
        this.endIndex = r12;
        boolean r13 = true;
        if (r11 < 0) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == false) goto L21;
        if (r12 < 0) goto L9;
        boolean r15 = true;
    L10:
        if (r15 == false) goto L19;
        if (r12 >= r11) goto L14;
        r13 = false;
    L14:
        if (r13 == false) goto L17;
        return;
    L17:
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + r12 + " < " + r11).toString());
    L19:
        throw new IllegalArgumentException(("endIndex should be non-negative, but is " + r12).toString());
    L9:
        r15 = false;
        goto L10
    L21:
        throw new IllegalArgumentException(("startIndex should be non-negative, but is " + r11).toString());
    L5:
        r14 = false;
        goto L6
    }

    public static final /* synthetic */ int access$getEndIndex$p(SubSequence r10) {
        return r10.endIndex;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(SubSequence r10) {
        return r10.sequence;
    }

    public static final /* synthetic */ int access$getStartIndex$p(SubSequence r10) {
        return r10.startIndex;
    }

    private final int getCount() {
        return this.endIndex - this.startIndex;
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> drop(int r10) {
        if (r10 < getCount()) goto L6;
        return SequencesKt.emptySequence();
    L6:
        return new SubSequence(this.sequence, this.startIndex + r10, this.endIndex);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> take(int r10) {
        if (r10 >= getCount()) goto L7;
        Sequence<T> r11 = this.sequence;
        int r12 = this.startIndex;
        return new SubSequence(r11, r12, r10 + r12);
    L7:
        return this;
    }
}
