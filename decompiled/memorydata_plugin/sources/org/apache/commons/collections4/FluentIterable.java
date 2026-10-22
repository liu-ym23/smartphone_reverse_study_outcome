package org.apache.commons.collections4;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class FluentIterable<E> implements Iterable<E> {
    private final Iterable<E> iterable;

    FluentIterable() {
        this.iterable = this;
    }

    private FluentIterable(Iterable<E> r3) {
        this.iterable = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
    }

    public static <T> FluentIterable<T> of(Iterable<T> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        IterableUtils.checkNotNull(r4);
        if (ZeusTransformUtils.instanceOf(r4, FluentIterable.class) == false) goto L7;
        return (FluentIterable) ZeusTransformUtils.preCheckCast(r4, FluentIterable.class, "com.obric.memorydata.plugin");
    L7:
        return new FluentIterable(r4);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return this.iterable.iterator();
    }

    public String toString() {
        return IterableUtils.toString(this.iterable);
    }

    public <O> FluentIterable<O> transform(Transformer<? super E, ? extends O> r3) {
        Transformer r4 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin");
        return of(IterableUtils.transformedIterable(this.iterable, r4));
    }
}
