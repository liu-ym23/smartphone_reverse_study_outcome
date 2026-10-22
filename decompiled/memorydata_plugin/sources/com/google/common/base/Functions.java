package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Functions {

    /* JADX INFO: renamed from: com.google.common.base.Functions$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class ConstantFunction<E> implements g<Object, E>, Serializable {
        private static final long serialVersionUID = 0;
        private final E value;

        public ConstantFunction(E r1) {
            this.value = r1;
        }

        @Override // com.google.common.base.g, java.util.function.Function
        public E apply(Object r1) {
            return this.value;
        }

        @Override // com.google.common.base.g
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, ConstantFunction.class) == false) goto L6;
            ConstantFunction r4 = (ConstantFunction) ZeusTransformUtils.preCheckCast(r3, ConstantFunction.class, "com.obric.memorydata.plugin");
            return k.a(this.value, r4.value);
        L6:
            return false;
        }

        public int hashCode() {
            E r0 = this.value;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Functions.constant(" + this.value + ")";
        }
    }

    private static class ForMapWithDefault<K, V> implements g<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final V defaultValue;
        final Map<K, ? extends V> map;

        ForMapWithDefault(Map<K, ? extends V> r3, V r4) {
            this.map = (Map) ZeusTransformUtils.preCheckCast(n.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")), Map.class, "com.obric.memorydata.plugin");
            this.defaultValue = r4;
        }

        @Override // com.google.common.base.g, java.util.function.Function
        public V apply(K r3) {
            V r0 = this.map.get(r3);
            if (r0 != null) goto L9;
            if (this.map.containsKey(r3) == true) goto L9;
            return this.defaultValue;
        L9:
            return (V) j.a(r0);
        }

        @Override // com.google.common.base.g
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, ForMapWithDefault.class) == false) goto L10;
            ForMapWithDefault r5 = (ForMapWithDefault) ZeusTransformUtils.preCheckCast(r4, ForMapWithDefault.class, "com.obric.memorydata.plugin");
            if (this.map.equals(r5.map) == true) goto L7;
            return false;
        L7:
            if (k.a(this.defaultValue, r5.defaultValue) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            return k.a(new Object[]{this.map, this.defaultValue});
        }

        public String toString() {
            return "Functions.forMap(" + this.map + ", defaultValue=" + this.defaultValue + ")";
        }
    }

    private static class FunctionComposition<A, B, C> implements g<A, C>, Serializable {
        private static final long serialVersionUID = 0;
        private final g<A, ? extends B> f;
        private final g<B, C> g;

        public FunctionComposition(g<B, C> r3, g<A, ? extends B> r4) {
            g r5 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
            g r6 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.memorydata.plugin");
            this.g = (g) ZeusTransformUtils.preCheckCast(n.a(r5), g.class, "com.obric.memorydata.plugin");
            this.f = (g) ZeusTransformUtils.preCheckCast(n.a(r6), g.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.g, java.util.function.Function
        public C apply(A r2) {
            return (C) this.g.apply(this.f.apply(r2));
        }

        @Override // com.google.common.base.g
        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, FunctionComposition.class) == false) goto L10;
            FunctionComposition r5 = (FunctionComposition) ZeusTransformUtils.preCheckCast(r4, FunctionComposition.class, "com.obric.memorydata.plugin");
            if (this.f.equals(r5.f) == true) goto L7;
            return false;
        L7:
            if (this.g.equals(r5.g) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = this.f.hashCode();
            return this.g.hashCode() ^ r0;
        }

        public String toString() {
            return this.g + "(" + this.f + ")";
        }
    }

    private static class FunctionForMapNoDefault<K, V> implements g<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final Map<K, V> map;

        FunctionForMapNoDefault(Map<K, V> r3) {
            this.map = (Map) ZeusTransformUtils.preCheckCast(n.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin")), Map.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.g, java.util.function.Function
        public V apply(K r3) {
            V r0 = this.map.get(r3);
            if (r0 == null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            n.a(r2, "Key '%s' not present in map", r3);
            return (V) j.a(r0);
        L5:
            if (this.map.containsKey(r3) == true) goto L8;
            r2 = false;
            goto L9
        }

        @Override // com.google.common.base.g
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, FunctionForMapNoDefault.class) == false) goto L6;
            FunctionForMapNoDefault r4 = (FunctionForMapNoDefault) ZeusTransformUtils.preCheckCast(r3, FunctionForMapNoDefault.class, "com.obric.memorydata.plugin");
            return this.map.equals(r4.map);
        L6:
            return false;
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        public String toString() {
            return "Functions.forMap(" + this.map + ")";
        }
    }

    private static final enum IdentityFunction extends Enum<IdentityFunction> implements g<Object, Object> {
        private static final /* synthetic */ IdentityFunction[] $VALUES = null;
        public static final IdentityFunction INSTANCE = null;

        private static /* synthetic */ IdentityFunction[] $values() {
            return new IdentityFunction[]{INSTANCE};
        }

        static {
            INSTANCE = new IdentityFunction("INSTANCE", 0);
            $VALUES = $values();
        }

        private IdentityFunction(String r1, int r2) {
            super(r1, r2);
        }

        public static IdentityFunction valueOf(String r2) {
            return (IdentityFunction) ZeusTransformUtils.preCheckCast(Enum.valueOf(IdentityFunction.class, r2), IdentityFunction.class, "com.obric.memorydata.plugin");
        }

        public static IdentityFunction[] values() {
            return (IdentityFunction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), IdentityFunction[].class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.g, java.util.function.Function
        public Object apply(Object r1) {
            return r1;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.identity()";
        }
    }

    private static class PredicateFunction<T> implements g<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;
        private final o<T> predicate;

        private PredicateFunction(o<T> r3) {
            this.predicate = (o) ZeusTransformUtils.preCheckCast(n.a((o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.memorydata.plugin")), o.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ PredicateFunction(o r2, AnonymousClass1 r3) {
            this((o) ZeusTransformUtils.wrapperContextForParams(r2, o.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.base.g, java.util.function.Function
        public Boolean apply(T r1) {
            return Boolean.valueOf(this.predicate.apply(r1));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.g, java.util.function.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply(r1);
        }

        @Override // com.google.common.base.g
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, PredicateFunction.class) == false) goto L6;
            PredicateFunction r4 = (PredicateFunction) ZeusTransformUtils.preCheckCast(r3, PredicateFunction.class, "com.obric.memorydata.plugin");
            return this.predicate.equals(r4.predicate);
        L6:
            return false;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            return "Functions.forPredicate(" + this.predicate + ")";
        }
    }

    private static class SupplierFunction<F, T> implements g<F, T>, Serializable {
        private static final long serialVersionUID = 0;
        private final r<T> supplier;

        private SupplierFunction(r<T> r3) {
            this.supplier = (r) ZeusTransformUtils.preCheckCast(n.a((r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.memorydata.plugin")), r.class, "com.obric.memorydata.plugin");
        }

        /* synthetic */ SupplierFunction(r r2, AnonymousClass1 r3) {
            this((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.base.g, java.util.function.Function
        public T apply(F r1) {
            return this.supplier.get();
        }

        @Override // com.google.common.base.g
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, SupplierFunction.class) == false) goto L6;
            SupplierFunction r4 = (SupplierFunction) ZeusTransformUtils.preCheckCast(r3, SupplierFunction.class, "com.obric.memorydata.plugin");
            return this.supplier.equals(r4.supplier);
        L6:
            return false;
        }

        public int hashCode() {
            return this.supplier.hashCode();
        }

        public String toString() {
            return "Functions.forSupplier(" + this.supplier + ")";
        }
    }

    private static final enum ToStringFunction extends Enum<ToStringFunction> implements g<Object, String> {
        private static final /* synthetic */ ToStringFunction[] $VALUES = null;
        public static final ToStringFunction INSTANCE = null;

        private static /* synthetic */ ToStringFunction[] $values() {
            return new ToStringFunction[]{INSTANCE};
        }

        static {
            INSTANCE = new ToStringFunction("INSTANCE", 0);
            $VALUES = $values();
        }

        private ToStringFunction(String r1, int r2) {
            super(r1, r2);
        }

        public static ToStringFunction valueOf(String r2) {
            return (ToStringFunction) ZeusTransformUtils.preCheckCast(Enum.valueOf(ToStringFunction.class, r2), ToStringFunction.class, "com.obric.memorydata.plugin");
        }

        public static ToStringFunction[] values() {
            return (ToStringFunction[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ToStringFunction[].class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.g, java.util.function.Function
        public /* bridge */ /* synthetic */ Object apply(Object r1) {
            return apply(r1);
        }

        @Override // com.google.common.base.g, java.util.function.Function
        public String apply(Object r1) {
            n.a(r1);
            return r1.toString();
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.toStringFunction()";
        }
    }
}
