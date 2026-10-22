package org.apache.commons.collections4.list;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes6.dex */
public class LazyList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -3677737457567429713L;
    private final Factory<? extends E> factory;
    private final Transformer<Integer, ? extends E> transformer;

    public LazyList(List<E> r3, Factory<? extends E> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Factory r6 = (Factory) ZeusTransformUtils.wrapperContextForParams(r4, Factory.class, "com.obric.memorydata.plugin");
        super(r5);
        this.factory = (Factory) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r6), Factory.class, "com.obric.memorydata.plugin");
        this.transformer = null;
    }

    public LazyList(List<E> r3, Transformer<Integer, ? extends E> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Transformer r6 = (Transformer) ZeusTransformUtils.wrapperContextForParams(r4, Transformer.class, "com.obric.memorydata.plugin");
        super(r5);
        this.factory = null;
        this.transformer = (Transformer) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(r6), Transformer.class, "com.obric.memorydata.plugin");
    }

    private E element(int r2) {
        Factory<? extends E> r0 = this.factory;
        if (r0 != null) goto L5;
        Transformer<Integer, ? extends E> r1 = this.transformer;
        if (r1 == null) goto L11;
        return r1.transform(Integer.valueOf(r2));
    L11:
        throw new IllegalStateException("Factory and Transformer are both null!");
    L5:
        return r0.create();
    }

    public static <E> LazyList<E> lazyList(List<E> r2, Factory<? extends E> r3) {
        return new LazyList((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (Factory) ZeusTransformUtils.wrapperContextForParams(r3, Factory.class, "com.obric.memorydata.plugin"));
    }

    public static <E> LazyList<E> lazyList(List<E> r2, Transformer<Integer, ? extends E> r3) {
        return new LazyList((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (Transformer) ZeusTransformUtils.wrapperContextForParams(r3, Transformer.class, "com.obric.memorydata.plugin"));
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E get(int r4) {
        int r0 = decorated().size();
        if (r4 >= r0) goto L8;
        E r1 = (E) decorated().get(r4);
        if (r1 != null) goto L13;
        E r2 = element(r4);
        decorated().set(r4, r2);
        return r2;
    L13:
        return r1;
    L8:
        if (r0 >= r4) goto L10;
        decorated().add(null);
        r0 = r0 + 1;
        goto L8
    L10:
        E r5 = element(r4);
        decorated().add(r5);
        return r5;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public List<E> subList(int r2, int r3) {
        List<E> r4 = decorated().subList(r2, r3);
        if (this.factory == null) goto L7;
        return new LazyList(r4, this.factory);
    L7:
        if (this.transformer == null) goto L11;
        return new LazyList(r4, this.transformer);
    L11:
        throw new IllegalStateException("Factory and Transformer are both null!");
    }
}
