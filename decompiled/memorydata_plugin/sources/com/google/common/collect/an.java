package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public interface an<E> extends Collection<E> {

    public interface a<E> {
        int getCount();

        E getElement();

        String toString();
    }

    private static /* synthetic */ void a(Consumer r2, a r3) {
        Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r2, Consumer.class, "com.obric.memorydata.plugin");
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Object r0 = r5.getElement();
        int r6 = r5.getCount();
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L5;
        r4.accept(r0);
        r1 = r1 + 1;
        goto L3
    }

    private static /* synthetic */ void a(ObjIntConsumer r2, a r3) {
        ObjIntConsumer r4 = (ObjIntConsumer) ZeusTransformUtils.wrapperContextForParams(r2, ObjIntConsumer.class, "com.obric.memorydata.plugin");
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        r4.accept(r5.getElement(), r5.getCount());
    }

    /* JADX INFO: renamed from: lambda$reosM-pVYEA-6VpqxWFi3nbr85U, reason: not valid java name */
    static /* synthetic */ void m131lambda$reosMpVYEA6VpqxWFi3nbr85U(Consumer r0, a r1) {
        a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$so5jecfgv-e3_JBiAkrUfbBSyGs, reason: not valid java name */
    static /* synthetic */ void m132lambda$so5jecfgve3_JBiAkrUfbBSyGs(ObjIntConsumer r0, a r1) {
        a(r0, r1);
    }

    int add(E r1, int r2);

    @Override // java.util.Collection
    boolean add(E r1);

    boolean contains(Object r1);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> r1);

    int count(Object r1);

    Set<E> elementSet();

    Set<a<E>> entrySet();

    boolean equals(Object r1);

    default void forEach(Consumer<? super E> r3) {
        final Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        entrySet().forEach(new $$Lambda$an$reosMpVYEA6VpqxWFi3nbr85U(r4));
    }

    default void forEachEntry(ObjIntConsumer<? super E> r3) {
        final ObjIntConsumer r4 = (ObjIntConsumer) ZeusTransformUtils.wrapperContextForParams(r3, ObjIntConsumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        entrySet().forEach(new $$Lambda$an$so5jecfgve3_JBiAkrUfbBSyGs(r4));
    }

    int hashCode();

    Iterator<E> iterator();

    int remove(Object r1, int r2);

    @Override // java.util.Collection
    boolean remove(Object r1);

    int setCount(E r1, int r2);

    boolean setCount(E r1, int r2, int r3);

    int size();

    default Spliterator<E> spliterator() {
        return Multisets.c(this);
    }
}
