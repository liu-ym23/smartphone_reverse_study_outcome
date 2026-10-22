package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class FlatteningSequence<T, R, E> implements Sequence<E> {
    private final Function1<R, Iterator<E>> iterator;
    private final Sequence<T> sequence;
    private final Function1<T, R> transformer;

    /* JADX INFO: renamed from: kotlin.sequences.FlatteningSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<E>, KMappedMarker {
        private Iterator<? extends E> itemIterator;
        private final Iterator<T> iterator;
        final /* synthetic */ FlatteningSequence<T, R, E> this$0;

        AnonymousClass1(FlatteningSequence<T, R, E> r10) {
            this.this$0 = r10;
            this.iterator = FlatteningSequence.access$getSequence$p(r10).iterator();
        }

        private final boolean ensureItemIterator() {
            Iterator<? extends E> r10 = this.itemIterator;
            if (r10 != null) goto L5;
        L7:
            boolean r11 = false;
        L8:
            if (r11 == false) goto L11;
            this.itemIterator = null;
        L11:
            if (this.itemIterator != null) goto L18;
            if (this.iterator.hasNext() == false) goto L14;
            Iterator<? extends E> r12 = (Iterator) FlatteningSequence.access$getIterator$p(this.this$0).invoke(FlatteningSequence.access$getTransformer$p(this.this$0).invoke(this.iterator.next()));
            if (r12.hasNext() == false) goto L11;
            this.itemIterator = r12;
            goto L18
        L14:
            return false;
        L18:
            return true;
        L5:
            if (r10.hasNext() == true) goto L7;
            r11 = true;
            goto L8
        }

        public final Iterator<E> getItemIterator() {
            return this.itemIterator;
        }

        public final Iterator<T> getIterator() {
            return this.iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return ensureItemIterator();
        }

        @Override // java.util.Iterator
        public E next() {
            if (ensureItemIterator() == false) goto L7;
            Iterator<? extends E> r10 = this.itemIterator;
            Intrinsics.checkNotNull(r10);
            return r10.next();
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setItemIterator(Iterator<? extends E> r10) {
            this.itemIterator = r10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlatteningSequence(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11, Function1<? super R, ? extends Iterator<? extends E>> r12) {
        Intrinsics.checkNotNullParameter(r10, "sequence");
        Intrinsics.checkNotNullParameter(r11, "transformer");
        Intrinsics.checkNotNullParameter(r12, "iterator");
        this.sequence = r10;
        this.transformer = r11;
        this.iterator = r12;
    }

    public static final /* synthetic */ Function1 access$getIterator$p(FlatteningSequence r10) {
        return r10.iterator;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(FlatteningSequence r10) {
        return r10.sequence;
    }

    public static final /* synthetic */ Function1 access$getTransformer$p(FlatteningSequence r10) {
        return r10.transformer;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<E> iterator() {
        return new AnonymousClass1(this);
    }
}
