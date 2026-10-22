package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class TakeWhileSequence<T> implements Sequence<T> {
    private final Function1<T, Boolean> predicate;
    private final Sequence<T> sequence;

    /* JADX INFO: renamed from: kotlin.sequences.TakeWhileSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private final Iterator<T> iterator;
        private T nextItem;
        private int nextState;
        final /* synthetic */ TakeWhileSequence<T> this$0;

        AnonymousClass1(TakeWhileSequence<T> r10) {
            this.this$0 = r10;
            this.iterator = TakeWhileSequence.access$getSequence$p(r10).iterator();
            this.nextState = -1;
        }

        private final void calcNext() {
            if (this.iterator.hasNext() == false) goto L8;
            T r10 = this.iterator.next();
            if (((Boolean) TakeWhileSequence.access$getPredicate$p(this.this$0).invoke(r10)).booleanValue() == false) goto L8;
            this.nextState = 1;
            this.nextItem = r10;
            return;
        L8:
            this.nextState = 0;
        }

        public final Iterator<T> getIterator() {
            return this.iterator;
        }

        public final T getNextItem() {
            return this.nextItem;
        }

        public final int getNextState() {
            return this.nextState;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextState != (-1)) goto L6;
            calcNext();
        L6:
            if (this.nextState == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nextState != (-1)) goto L6;
            calcNext();
        L6:
            if (this.nextState == 0) goto L10;
            T r10 = this.nextItem;
            this.nextItem = null;
            this.nextState = -1;
            return r10;
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setNextItem(T r10) {
            this.nextItem = r10;
        }

        public final void setNextState(int r10) {
            this.nextState = r10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TakeWhileSequence(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "sequence");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        this.sequence = r10;
        this.predicate = r11;
    }

    public static final /* synthetic */ Function1 access$getPredicate$p(TakeWhileSequence r10) {
        return r10.predicate;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(TakeWhileSequence r10) {
        return r10.sequence;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }
}
