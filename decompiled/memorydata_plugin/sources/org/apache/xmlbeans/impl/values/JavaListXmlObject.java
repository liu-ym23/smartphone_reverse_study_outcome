package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.AbstractList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: loaded from: classes7.dex */
public class JavaListXmlObject<T extends XmlObject> extends AbstractList<T> {
    private final Function<Integer, T> adder;
    private final Function<Integer, T> getter;
    private final Consumer<Integer> remover;
    private final BiConsumer<Integer, T> setter;
    private final Supplier<Integer> sizer;

    public JavaListXmlObject(Function<Integer, T> r3, BiConsumer<Integer, T> r4, Function<Integer, T> r5, Consumer<Integer> r6, Supplier<Integer> r7) {
        Function<Integer, T> r8 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        BiConsumer<Integer, T> r9 = (BiConsumer) ZeusTransformUtils.wrapperContextForParams(r4, BiConsumer.class, "com.obric.memorydata.plugin");
        Function<Integer, T> r10 = (Function) ZeusTransformUtils.wrapperContextForParams(r5, Function.class, "com.obric.memorydata.plugin");
        Consumer<Integer> r11 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r6, Consumer.class, "com.obric.memorydata.plugin");
        Supplier<Integer> r12 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r7, Supplier.class, "com.obric.memorydata.plugin");
        this.getter = r8;
        this.setter = r9;
        this.adder = r10;
        this.remover = r11;
        this.sizer = r12;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* synthetic */ void add(int r3, Object r4) {
        add(r3, (XmlObject) ZeusTransformUtils.preCheckCast(r4, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public void add(int r3, T r4) {
        XmlObject r5 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin");
        Function<Integer, T> r2 = this.adder;
        if (r2 == null) goto L7;
        ((XmlObject) ZeusTransformUtils.preCheckCast(r2.apply(Integer.valueOf(r3)), XmlObject.class, "com.obric.memorydata.plugin")).set(r5);
        return;
    L7:
        throw new IllegalStateException("XmlBean generated using partial methods - no add method available");
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int r2) {
        Function<Integer, T> r1 = this.getter;
        if (r1 == null) goto L7;
        return (T) ZeusTransformUtils.preCheckCast(r1.apply(Integer.valueOf(r2)), XmlObject.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalStateException("XmlBean generated using partial methods - no getter available");
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r1) {
        return remove(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int r2) {
        if (this.remover == null) goto L7;
        T r0 = (T) get(r2);
        this.remover.accept(Integer.valueOf(r2));
        return r0;
    L7:
        throw new IllegalStateException("XmlBean generated using partial methods - no remove method available");
    }

    @Override // java.util.AbstractList, java.util.List
    public /* synthetic */ Object set(int r3, Object r4) {
        return set(r3, (XmlObject) ZeusTransformUtils.preCheckCast(r4, XmlObject.class, "com.obric.memorydata.plugin"));
    }

    public T set(int r3, T r4) {
        XmlObject r5 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r4, XmlObject.class, "com.obric.memorydata.plugin");
        if (this.setter == null) goto L7;
        T r0 = (T) get(r3);
        this.setter.accept(Integer.valueOf(r3), (T) r5);
        return r0;
    L7:
        throw new IllegalStateException("XmlBean generated using partial methods - no setter available");
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
