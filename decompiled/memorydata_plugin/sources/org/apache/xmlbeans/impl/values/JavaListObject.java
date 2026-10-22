package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes7.dex */
public class JavaListObject<T> extends AbstractList<T> {
    private final BiConsumer<Integer, T> adder;
    private final Function<Integer, T> getter;
    private final Consumer<Integer> remover;
    private final BiConsumer<Integer, T> setter;
    private final Supplier<Integer> sizer;

    public JavaListObject(Function<Integer, T> r3, BiConsumer<Integer, T> r4, BiConsumer<Integer, T> r5, Consumer<Integer> r6, Supplier<Integer> r7) {
        Function<Integer, T> r8 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        BiConsumer<Integer, T> r9 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r4, BiConsumer.class, "com.obric.memorydata.plugin");
        BiConsumer<Integer, T> r10 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r5, BiConsumer.class, "com.obric.memorydata.plugin");
        Consumer<Integer> r11 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r6, Consumer.class, "com.obric.memorydata.plugin");
        Supplier<Integer> r12 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r7, Supplier.class, "com.obric.memorydata.plugin");
        this.getter = r8;
        this.setter = r9;
        this.adder = r10;
        this.remover = r11;
        this.sizer = r12;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r1, T r2) {
        BiConsumer<Integer, T> r0 = this.adder;
        if (r0 == null) goto L7;
        r0.accept(Integer.valueOf(r1), r2);
        return;
    L7:
        throw new IllegalStateException("XmlBean generated using partial methods - no add method available");
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int r1) {
        Function<Integer, T> r0 = this.getter;
        if (r0 == null) goto L7;
        return r0.apply(Integer.valueOf(r1));
    L7:
        throw new IllegalStateException("XmlBean generated using partial methods - no getter method available");
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int r2) {
        if (this.remover == null) goto L7;
        T r0 = get(r2);
        this.remover.accept(Integer.valueOf(r2));
        return r0;
    L7:
        throw new IllegalStateException("XmlBean generated using partial methods - no remove method available");
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int r2, T r3) {
        if (this.setter == null) goto L7;
        T r0 = get(r2);
        this.setter.accept(Integer.valueOf(r2), r3);
        return r0;
    L7:
        throw new IllegalStateException("XmlBean generated using partial methods - no setter method available");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        Supplier<Integer> r2 = this.sizer;
        if (r2 == null) goto L7;
        return ((Integer) ZeusTransformUtils.preCheckCast(r2.get(), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L7:
        throw new IllegalStateException("XmlBean generated using partial methods - no size-of method available");
    }
}
