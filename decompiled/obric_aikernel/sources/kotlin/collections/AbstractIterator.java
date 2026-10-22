package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {
    private T nextValue;
    private State state;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[State.values().length];
            r10[State.Done.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r10[State.Ready.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r10;
        }
    }

    public AbstractIterator() {
        this.state = State.NotReady;
    }

    private final boolean tryToComputeNext() {
        this.state = State.Failed;
        computeNext();
        if (this.state != State.Ready) goto L5;
        return true;
    L5:
        return false;
    }

    protected abstract void computeNext();

    protected final void done() {
        this.state = State.Done;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        State r10 = this.state;
        if (r10 == State.Failed) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L15;
        int r12 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r12 != 1) goto L10;
        return false;
    L10:
        if (r12 == 2) goto L13;
        return tryToComputeNext();
    L13:
        return true;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r11 = false;
        goto L6
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext() == false) goto L7;
        this.state = State.NotReady;
        return this.nextValue;
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    protected final void setNext(T r10) {
        this.nextValue = r10;
        this.state = State.Ready;
    }
}
