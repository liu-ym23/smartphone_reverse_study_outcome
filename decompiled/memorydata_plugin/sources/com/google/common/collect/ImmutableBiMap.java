package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableBiMapFauxverideShim<K, V> implements k<K, V> {

    private static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;

        SerializedForm(ImmutableBiMap<K, V> r1) {
            super(r1);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        a<K, V> makeBuilder(int r1) {
            return new a(r1);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        /* bridge */ /* synthetic */ ImmutableMap.a makeBuilder(int r1) {
            return makeBuilder(r1);
        }
    }

    public static final class a<K, V> extends ImmutableMap.a<K, V> {
        public a() {
        }

        a(int r1) {
            super(r1);
        }

        a<K, V> a(ImmutableMap.a<K, V> r1) {
            super.b(r1);
            return this;
        }

        public a<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> r3) {
            super.b((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
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

        public a<K, V> a(Map<? extends K, ? extends V> r3) {
            super.b((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
            return this;
        }

        public ImmutableBiMap<K, V> a() {
            return b();
        }

        public ImmutableBiMap<K, V> b() {
            int r0 = this.c;
            if (r0 == 0) goto L17;
            if (r0 != 1) goto L7;
            Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.f4450b[0]), Map.Entry.class, "com.obric.memorydata.plugin");
            return ImmutableBiMap.of(r6.getKey(), r6.getValue());
        L7:
            if (this.f4449a != null) goto L9;
        L12:
            this.d = true;
            return RegularImmutableBiMap.fromEntryArray(this.c, this.f4450b);
        L9:
            if (this.d == false) goto L11;
            this.f4450b = (Map.Entry[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(this.f4450b, this.c), Map.Entry[].class, "com.obric.memorydata.plugin");
        L11:
            Arrays.sort(this.f4450b, 0, this.c, Ordering.from(this.f4449a).onResultOf(Maps.b()));
            goto L12
        L17:
            return ImmutableBiMap.of();
        }

        @Override // com.google.common.collect.ImmutableMap.a
        /* synthetic */ ImmutableMap.a b(ImmutableMap.a r1) {
            return a(r1);
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public /* synthetic */ ImmutableMap.a b(Iterable r3) {
            return a((Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin"));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.a
        public /* synthetic */ ImmutableMap.a b(Object r1, Object r2) {
            return a(r1, r2);
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public /* synthetic */ ImmutableMap.a b(Map.Entry r3) {
            return a((Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public /* synthetic */ ImmutableMap.a b(Map r3) {
            return a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin"));
        }

        @Deprecated
        public ImmutableBiMap<K, V> c() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

        @Override // com.google.common.collect.ImmutableMap.a
        @Deprecated
        public /* synthetic */ ImmutableMap d() {
            return c();
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public /* synthetic */ ImmutableMap e() {
            return b();
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public /* synthetic */ ImmutableMap f() {
            return a();
        }
    }

    ImmutableBiMap() {
    }

    public static <K, V> a<K, V> builder() {
        return new a();
    }

    public static <K, V> a<K, V> builderWithExpectedSize(int r1) {
        o.a(r1, "expectedSize");
        return new a(r1);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> r2) {
        Map.Entry[] r3 = (Map.Entry[]) ZeusTransformUtils.preCheckCast(aj.a((Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin"), EMPTY_ENTRY_ARRAY), Map.Entry[].class, "com.obric.memorydata.plugin");
        int r0 = r3.length;
        if (r0 == 0) goto L11;
        if (r0 != 1) goto L7;
        Map.Entry r4 = r3[0];
        return of(r4.getKey(), r4.getValue());
    L7:
        return RegularImmutableBiMap.fromEntries(r3);
    L11:
        return of();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, ImmutableBiMap.class) == false) goto L8;
        ImmutableBiMap<K, V> r0 = (ImmutableBiMap) ZeusTransformUtils.preCheckCast(r4, ImmutableBiMap.class, "com.obric.memorydata.plugin");
        if (r0.isPartialView() == true) goto L8;
        return r0;
    L8:
        return copyOf(r4.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r1, V r2) {
        return new SingletonImmutableBiMap(r1, r2);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r1, V r2, K r3, V r4) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r1, r2), entryOf(r3, r4)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r1, r2), entryOf(r3, r4), entryOf(r5, r6)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r1, r2), entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r1, r2), entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r1, r2), entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r1, V r2, K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12, K r13, V r14) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r1, r2), entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r20) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18), entryOf(r19, r20)});
    }

    public static <K, V> ImmutableBiMap<K, V> of(K r3, V r4, K r5, V r6, K r7, V r8, K r9, V r10, K r11, V r12, K r13, V r14, K r15, V r16, K r17, V r18, K r19, V r20, K r21, V r22) {
        return RegularImmutableBiMap.fromEntries(new Map.Entry[]{entryOf(r3, r4), entryOf(r5, r6), entryOf(r7, r8), entryOf(r9, r10), entryOf(r11, r12), entryOf(r13, r14), entryOf(r15, r16), entryOf(r17, r18), entryOf(r19, r20), entryOf(r21, r22)});
    }

    @SafeVarargs
    public static <K, V> ImmutableBiMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... r0) {
        return RegularImmutableBiMap.fromEntries(r0);
    }

    private void readObject(ObjectInputStream r1) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> toImmutableBiMap(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3) {
        return n.b((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.common.collect.ImmutableMap
    /* bridge */ /* synthetic */ ImmutableCollection createValues() {
        return createValues();
    }

    @Override // com.google.common.collect.ImmutableMap
    final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.k
    @Deprecated
    public final V forcePut(K r1, V r2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.k
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.k
    public /* bridge */ /* synthetic */ k inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.k
    public /* bridge */ /* synthetic */ ImmutableCollection values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.k
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.k
    public /* bridge */ /* synthetic */ Collection values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.k
    public /* bridge */ /* synthetic */ Set values() {
        return values();
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
