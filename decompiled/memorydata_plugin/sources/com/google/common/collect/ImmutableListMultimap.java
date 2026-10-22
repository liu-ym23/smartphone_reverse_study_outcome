package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ak<K, V> {
    private static final long serialVersionUID = 0;
    private transient ImmutableListMultimap<V, K> inverse;

    public static final class a<K, V> extends ImmutableMultimap.a<K, V> {
        public a() {
        }

        a<K, V> a(ImmutableMultimap.a<K, V> r1) {
            super.b(r1);
            return this;
        }

        public a<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> r3) {
            super.b((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public a<K, V> a(K r3, Iterable<? extends V> r4) {
            super.b(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public a<K, V> a(K r1, V r2) {
            super.b(r1, r2);
            return this;
        }

        public a<K, V> a(Map.Entry<? extends K, ? extends V> r3) {
            super.b((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public ImmutableListMultimap<K, V> a() {
            return (ImmutableListMultimap) ZeusTransformUtils.preCheckCast(super.b(), ImmutableListMultimap.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        /* synthetic */ ImmutableMultimap.a b(ImmutableMultimap.a r1) {
            return a(r1);
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public /* synthetic */ ImmutableMultimap.a b(Iterable r3) {
            return a((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.a
        public /* synthetic */ ImmutableMultimap.a b(Object r3, Iterable r4) {
            return a(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.a
        public /* synthetic */ ImmutableMultimap.a b(Object r1, Object r2) {
            return a(r1, r2);
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public /* synthetic */ ImmutableMultimap.a b(Map.Entry r3) {
            return a((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public /* synthetic */ ImmutableMultimap b() {
            return a();
        }
    }

    ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> r1, int r2) {
        super(r1, r2);
    }

    public static <K, V> a<K, V> builder() {
        return new a();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(am<? extends K, ? extends V> r3) {
        am r4 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L7;
        return of();
    L7:
        if (ZeusTransformUtils.instanceOf(r4, ImmutableListMultimap.class) == false) goto L12;
        ImmutableListMultimap<K, V> r0 = (ImmutableListMultimap) ZeusTransformUtils.preCheckCast(r4, ImmutableListMultimap.class, "com.obric.memorydata.plugin");
        if (r0.isPartialView() == true) goto L12;
        return r0;
    L12:
        return fromMapEntries(r4.asMap().entrySet(), null);
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r2) {
        Iterable<? extends Map.Entry<? extends K, ? extends V>> r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        return new a().a(r3).a();
    }

    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> flatteningToImmutableListMultimap(Function<? super T, ? extends K> r2, Function<? super T, ? extends Stream<? extends V>> r3) {
        return n.e((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> r6, Comparator<? super V> r7) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        Comparator r9 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r7, Comparator.class, "com.obric.memorydata.plugin");
        if (r8.isEmpty() == true) goto L5;
        ImmutableMap.a r0 = new ImmutableMap.a(r8.size());
        int r2 = 0;
        Iterator r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L17;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r4 = r3.getKey();
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(r3.getValue(), Collection.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L12;
        ImmutableList r11 = ImmutableList.copyOf(r5);
    L14:
        if (r11.isEmpty() == true) goto L8;
        r0.b(r4, r11);
        r2 = r2 + r11.size();
        goto L8
    L12:
        r11 = ImmutableList.sortedCopyOf(r9, r5);
        goto L14
    L17:
        return new ImmutableListMultimap(r0.e(), r2);
    L5:
        return of();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> invert() {
        a r0 = builder();
        bj r1 = entries().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.a(r2.getValue(), r2.getKey());
        goto L4
    L6:
        ImmutableListMultimap<V, K> r3 = r0.a();
        r3.inverse = this;
        return r3;
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r1, V r2) {
        a r0 = builder();
        r0.a(r1, r2);
        return r0.a();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r1, V r2, K r3, V r4) {
        a r0 = builder();
        r0.a(r1, r2);
        r0.a(r3, r4);
        return r0.a();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6) {
        a r0 = builder();
        r0.a(r1, r2);
        r0.a(r3, r4);
        r0.a(r5, r6);
        return r0.a();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8) {
        a r0 = builder();
        r0.a(r1, r2);
        r0.a(r3, r4);
        r0.a(r5, r6);
        r0.a(r7, r8);
        return r0.a();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10) {
        a r0 = builder();
        r0.a(r1, r2);
        r0.a(r3, r4);
        r0.a(r5, r6);
        r0.a(r7, r8);
        r0.a(r9, r10);
        return r0.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream r11) {
        r11.defaultReadObject();
        int r0 = r11.readInt();
        if (r0 < 0) goto L21;
        ImmutableMap.a r1 = ImmutableMap.builder();
        int r3 = 0;
        int r4 = 0;
    L5:
        if (r3 >= r0) goto L22;
        Object r5 = r11.readObject();
        int r6 = r11.readInt();
        if (r6 <= 0) goto L13;
        ImmutableList.a r7 = ImmutableList.builder();
        int r8 = 0;
    L9:
        if (r8 >= r6) goto L11;
        r7.b(r11.readObject());
        r8 = r8 + 1;
        goto L9
    L11:
        r1.b(r5, r7.a());
        r4 = r4 + r6;
        r3 = r3 + 1;
        goto L5
    L13:
        throw new InvalidObjectException("Invalid value count " + r6);
    L22:
        ImmutableMultimap.b.f4459a.a(this, r1.e());
        ImmutableMultimap.b.f4460b.a(this, r4);
        return;
    L17:
        e = move-exception;
        throw ((InvalidObjectException) ZeusTransformUtils.preCheckCast(new InvalidObjectException(e.getMessage()).initCause(e), InvalidObjectException.class, "com.obric.memorydata.plugin"));
    L21:
        throw new InvalidObjectException("Invalid key count " + r0);
    }

    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> toImmutableListMultimap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3) {
        return n.d((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin"));
    }

    private void writeObject(ObjectOutputStream r1) {
        r1.defaultWriteObject();
        av.a(this, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ ImmutableCollection get(Object r1) {
        return get(r1);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public ImmutableList<V> get(K r2) {
        ImmutableList<V> r1 = (ImmutableList) ZeusTransformUtils.preCheckCast(this.map.get(r2), ImmutableList.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        return ImmutableList.of();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ Collection get(Object r1) {
        return get(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    public /* bridge */ /* synthetic */ List get(Object r1) {
        return get(r1);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> r0 = this.inverse;
        if (r0 != null) goto L6;
        ImmutableListMultimap<V, K> r1 = invert();
        this.inverse = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public /* bridge */ /* synthetic */ ImmutableMultimap inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection removeAll(Object r1) {
        return removeAll(r1);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public final ImmutableList<V> removeAll(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public /* bridge */ /* synthetic */ Collection removeAll(Object r1) {
        return removeAll(r1);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public /* bridge */ /* synthetic */ List removeAll(Object r1) {
        return removeAll(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public /* synthetic */ ImmutableCollection replaceValues(Object r3, Iterable r4) {
        return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public final ImmutableList<V> replaceValues(K r1, Iterable<? extends V> r2) {
        Iterable r0 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public /* synthetic */ Collection replaceValues(Object r3, Iterable r4) {
        return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.c, com.google.common.collect.am, com.google.common.collect.ak
    @Deprecated
    public /* synthetic */ List replaceValues(Object r3, Iterable r4) {
        return replaceValues(r3, (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin"));
    }
}
