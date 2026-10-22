package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class FilteringSequence<T> implements Sequence<T> {
    private final Function1<T, Boolean> predicate;
    private final boolean sendWhen;
    private final Sequence<T> sequence;

    /* JADX INFO: renamed from: kotlin.sequences.FilteringSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private final Iterator<T> iterator;
        private T nextItem;
        private int nextState;
        final /* synthetic */ FilteringSequence<T> this$0;

        AnonymousClass1(FilteringSequence<T> r10) {
            this.this$0 = r10;
            this.iterator = FilteringSequence.access$getSequence$p(r10).iterator();
            this.nextState = -1;
        }

        private final void calcNext() {
        L3:
            if (this.iterator.hasNext() == false) goto L9;
            T r10 = this.iterator.next();
            if (((Boolean) FilteringSequence.access$getPredicate$p(this.this$0).invoke(r10)).booleanValue() != FilteringSequence.access$getSendWhen$p(this.this$0)) goto L3;
            this.nextItem = r10;
            int r11 = 1;
        L7:
            this.nextState = r11;
            return;
        L9:
            r11 = 0;
            goto L7
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
    public FilteringSequence(Sequence<? extends T> r10, boolean r11, Function1<? super T, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "sequence");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        this.sequence = r10;
        this.sendWhen = r11;
        this.predicate = r12;
    }

    public /* synthetic */ FilteringSequence(Sequence r10, boolean r11, Function1 r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        r11 = true;
    L5:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ Function1 access$getPredicate$p(FilteringSequence r10) {
        return r10.predicate;
    }

    public static final /* synthetic */ boolean access$getSendWhen$p(FilteringSequence r10) {
        return r10.sendWhen;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(FilteringSequence r10) {
        return r10.sequence;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }
}
