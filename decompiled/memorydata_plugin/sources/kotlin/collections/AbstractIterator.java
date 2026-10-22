package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH$J\b\u0010\n\u001a\u00020\tH\u0004J\t\u0010\u000b\u001a\u00020\fH\u0096\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\fH\u0002R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlin/collections/AbstractIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "nextValue", "Ljava/lang/Object;", "state", "", "computeNext", "", "done", "hasNext", "", "next", "()Ljava/lang/Object;", "setNext", EventBody.KEY_VALUE, "(Ljava/lang/Object;)V", "tryToComputeNext", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {
    private T nextValue;
    private int state;

    public AbstractIterator() {
    }

    private final boolean tryToComputeNext() {
        this.state = 3;
        computeNext();
        if (this.state == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public abstract void computeNext();

    public final void done() {
        this.state = 2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int r0 = this.state;
        if (r0 == 0) goto L11;
        if (r0 != 1) goto L6;
        return true;
    L6:
        if (r0 != 2) goto L9;
        return false;
    L9:
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    L11:
        return tryToComputeNext();
    }

    @Override // java.util.Iterator
    public T next() {
        int r0 = this.state;
        if (r0 != 1) goto L7;
    L4:
        this.state = 0;
        return this.nextValue;
    L7:
        if (r0 == 2) goto L12;
        if (tryToComputeNext() == true) goto L4;
    L12:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setNext(T r1) {
        this.nextValue = r1;
        this.state = 1;
    }
}
