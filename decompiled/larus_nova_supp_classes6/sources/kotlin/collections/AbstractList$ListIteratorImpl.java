package kotlin.collections;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0092\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\r\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "index", "", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public class AbstractList$ListIteratorImpl<E> extends AbstractList<E>.IteratorImpl implements ListIterator<E> {
    final /* synthetic */ AbstractList<E> this$0;

    @Override // java.util.ListIterator
    public void add(E r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public void set(E r2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        if (getIndex() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return getIndex();
    }

    @Override // java.util.ListIterator
    public E previous() {
        if (hasPrevious() == false) goto L7;
        AbstractList<E> r0 = this.this$0;
        setIndex(getIndex() - 1);
        return (E) r0.get(getIndex());
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return getIndex() - 1;
    }

    public AbstractList$ListIteratorImpl(AbstractList r2, int r3) {
        this.this$0 = r2;
        super(r2);
        AbstractList.Companion.checkPositionIndex$kotlin_stdlib(r3, r2.size());
        setIndex(r3);
    }
}
