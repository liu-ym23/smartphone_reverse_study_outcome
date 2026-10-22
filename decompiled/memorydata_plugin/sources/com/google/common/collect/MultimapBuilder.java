package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MultimapBuilder<K0, V0> {

    /* JADX INFO: renamed from: com.google.common.collect.MultimapBuilder$1, reason: invalid class name */
    class AnonymousClass1 extends b<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4558a;

        @Override // com.google.common.collect.MultimapBuilder.b
        <K, V> Map<K, Collection<V>> a() {
            return ar.a(this.f4558a);
        }
    }

    private static final class ArrayListSupplier<V> implements com.google.common.base.r<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        ArrayListSupplier(int r2) {
            this.expectedValuesPerKey = o.a(r2, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    private static final class EnumSetSupplier<V extends Enum<V>> implements com.google.common.base.r<Set<V>>, Serializable {
        private final Class<V> clazz;

        EnumSetSupplier(Class<V> r3) {
            this.clazz = (Class) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r3), Class.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public Set<V> get() {
            return EnumSet.noneOf(this.clazz);
        }
    }

    private static final class HashSetSupplier<V> implements com.google.common.base.r<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        HashSetSupplier(int r2) {
            this.expectedValuesPerKey = o.a(r2, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public Set<V> get() {
            return ar.c(this.expectedValuesPerKey);
        }
    }

    private static final class LinkedHashSetSupplier<V> implements com.google.common.base.r<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        LinkedHashSetSupplier(int r2) {
            this.expectedValuesPerKey = o.a(r2, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public Set<V> get() {
            return ar.d(this.expectedValuesPerKey);
        }
    }

    private static final enum LinkedListSupplier extends Enum<LinkedListSupplier> implements com.google.common.base.r<List<?>> {
        private static final /* synthetic */ LinkedListSupplier[] $VALUES = null;
        public static final LinkedListSupplier INSTANCE = null;

        private static /* synthetic */ LinkedListSupplier[] $values() {
            return new LinkedListSupplier[]{INSTANCE};
        }

        static {
            INSTANCE = new LinkedListSupplier("INSTANCE", 0);
            $VALUES = $values();
        }

        private LinkedListSupplier(String r1, int r2) {
            super(r1, r2);
        }

        public static <V> com.google.common.base.r<List<V>> instance() {
            return INSTANCE;
        }

        public static LinkedListSupplier valueOf(String r2) {
            return (LinkedListSupplier) ZeusTransformUtils.preCheckCast(Enum.valueOf(LinkedListSupplier.class, r2), LinkedListSupplier.class, "com.obric.memorydata.plugin");
        }

        public static LinkedListSupplier[] values() {
            return (LinkedListSupplier[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LinkedListSupplier[].class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public List<?> get() {
            return new LinkedList();
        }
    }

    private static final class TreeSetSupplier<V> implements com.google.common.base.r<SortedSet<V>>, Serializable {
        private final Comparator<? super V> comparator;

        TreeSetSupplier(Comparator<? super V> r3) {
            this.comparator = (Comparator) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a((Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.memorydata.plugin")), Comparator.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public /* bridge */ /* synthetic */ Object get() {
            return get();
        }

        @Override // com.google.common.base.r, java.util.function.Supplier
        public SortedSet<V> get() {
            return new TreeSet(this.comparator);
        }
    }

    public static abstract class a<K0, V0> extends MultimapBuilder<K0, V0> {
        a() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> ak<K, V> b();
    }

    public static abstract class b<K0> {
        b() {
        }

        public a<K0, Object> a(final int r2) {
            o.a(r2, "expectedValuesPerKey");
            return new AnonymousClass1(this, r2);
        }

        abstract <K extends K0, V> Map<K, Collection<V>> a();

        public a<K0, Object> b() {
            return a(2);
        }

        public c<K0, Object> b(final int r2) {
            o.a(r2, "expectedValuesPerKey");
            return new AnonymousClass2(this, r2);
        }

        public c<K0, Object> c() {
            return b(2);
        }
    }

    public static abstract class c<K0, V0> extends MultimapBuilder<K0, V0> {
        c() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> aw<K, V> b();
    }

    private MultimapBuilder() {
    }

    /* synthetic */ MultimapBuilder(AnonymousClass1 r1) {
        this();
    }

    public static b<Object> a() {
        return a(8);
    }

    public static b<Object> a(final int r1) {
        o.a(r1, "expectedKeys");
        return new AnonymousClass2(r1);
    }
}
