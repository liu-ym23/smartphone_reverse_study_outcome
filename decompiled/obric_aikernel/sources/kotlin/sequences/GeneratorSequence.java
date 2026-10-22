package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes3.dex */
final class GeneratorSequence<T> implements Sequence<T> {
    private final Function0<T> getInitialValue;
    private final Function1<T, T> getNextValue;

    /* JADX INFO: renamed from: kotlin.sequences.GeneratorSequence$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<T>, KMappedMarker {
        private T nextItem;
        private int nextState;
        final /* synthetic */ GeneratorSequence<T> this$0;

        AnonymousClass1(GeneratorSequence<T> r10) {
            this.this$0 = r10;
            this.nextState = -2;
        }

        private final void calcNext() {
            if (this.nextState != (-2)) goto L5;
            T r10 = (T) GeneratorSequence.access$getGetInitialValue$p(this.this$0).invoke();
        L6:
            this.nextItem = r10;
            if (r10 != null) goto L9;
            int r11 = 0;
        L10:
            this.nextState = r11;
            return;
        L9:
            r11 = 1;
            goto L10
        L5:
            Function1 r12 = GeneratorSequence.access$getGetNextValue$p(this.this$0);
            T r13 = this.nextItem;
            Intrinsics.checkNotNull(r13);
            r10 = (T) r12.invoke(r13);
            goto L6
        }

        public final T getNextItem() {
            return this.nextItem;
        }

        public final int getNextState() {
            return this.nextState;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextState >= 0) goto L6;
            calcNext();
        L6:
            if (this.nextState == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nextState >= 0) goto L6;
            calcNext();
        L6:
            if (this.nextState == 0) goto L10;
            T r10 = this.nextItem;
            Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
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
    public GeneratorSequence(Function0<? extends T> r10, Function1<? super T, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "getInitialValue");
        Intrinsics.checkNotNullParameter(r11, "getNextValue");
        this.getInitialValue = r10;
        this.getNextValue = r11;
    }

    public static final /* synthetic */ Function0 access$getGetInitialValue$p(GeneratorSequence r10) {
        return r10.getInitialValue;
    }

    public static final /* synthetic */ Function1 access$getGetNextValue$p(GeneratorSequence r10) {
        return r10.getNextValue;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new AnonymousClass1(this);
    }
}
