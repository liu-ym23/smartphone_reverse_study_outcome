package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class DropWhileSequence<T> implements Sequence<T> {
    private final Function1<T, Boolean> predicate;
    private final Sequence<T> sequence;

    /* JADX INFO: renamed from: kotlin.sequences.DropWhileSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private int dropState;
        private final Iterator<T> iterator;
        private T nextItem;
        final /* synthetic */ DropWhileSequence<T> this$0;

        AnonymousClass1(DropWhileSequence<T> r10) {
            this.this$0 = r10;
            this.iterator = DropWhileSequence.access$getSequence$p(r10).iterator();
            this.dropState = -1;
        }

        private final void drop() {
        L3:
            if (this.iterator.hasNext() == false) goto L9;
            T r10 = this.iterator.next();
            if (((Boolean) DropWhileSequence.access$getPredicate$p(this.this$0).invoke(r10)).booleanValue() == true) goto L3;
            this.nextItem = r10;
            int r11 = 1;
        L7:
            this.dropState = r11;
            return;
        L9:
            r11 = 0;
            goto L7
        }

        public final int getDropState() {
            return this.dropState;
        }

        public final Iterator<T> getIterator() {
            return this.iterator;
        }

        public final T getNextItem() {
            return this.nextItem;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.dropState != (-1)) goto L6;
            drop();
        L6:
            if (this.dropState != 1) goto L8;
            return true;
        L8:
            if (this.iterator.hasNext() == true) goto L13;
            return false;
        L13:
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.dropState != (-1)) goto L6;
            drop();
        L6:
            if (this.dropState != 1) goto L10;
            T r10 = this.nextItem;
            this.nextItem = null;
            this.dropState = 0;
            return r10;
        L10:
            return this.iterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setDropState(int r10) {
            this.dropState = r10;
        }

        public final void setNextItem(T r10) {
            this.nextItem = r10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DropWhileSequence(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "sequence");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        this.sequence = r10;
        this.predicate = r11;
    }

    public static final /* synthetic */ Function1 access$getPredicate$p(DropWhileSequence r10) {
        return r10.predicate;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(DropWhileSequence r10) {
        return r10.sequence;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }
}
