package org.apache.commons.collections4.iterators;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Objects;
import org.apache.commons.collections4.Unmodifiable;

/* JADX INFO: loaded from: classes6.dex */
public final class UnmodifiableIterator<E> implements Iterator<E>, Unmodifiable {
    private final Iterator<? extends E> iterator;

    private UnmodifiableIterator(Iterator<? extends E> r3) {
        this.iterator = (Iterator) ZeusTransformUtils.wrapperContextForParams(r3, Iterator.class, "com.obric.memorydata.plugin");
    }

    public static <E> Iterator<E> unmodifiableIterator(Iterator<? extends E> r2) {
        Iterator<E> r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r3, "Iterator must not be null");
        if (ZeusTransformUtils.instanceOf(r3, Unmodifiable.class) == false) goto L6;
        return r3;
    L6:
        return new UnmodifiableIterator(r3);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        return this.iterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported");
    }
}
