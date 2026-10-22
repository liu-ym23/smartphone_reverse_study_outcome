package com.google.common.collect;

import com.google.common.base.Predicates;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
class StandardTable<R, C, V> extends i<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final Map<R, Map<C, V>> backingMap;
    private transient Set<C> columnKeySet;
    private transient StandardTable<R, C, V>.e columnMap;
    final com.google.common.base.r<? extends Map<C, V>> factory;
    private transient Map<R, Map<C, V>> rowMap;

    /* JADX INFO: renamed from: com.google.common.collect.StandardTable$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a implements Iterator<be.a<R, C, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<R, Map<C, V>>> f4589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map.Entry<R, Map<C, V>> f4590b;
        Iterator<Map.Entry<C, V>> c;
        final /* synthetic */ StandardTable d;

        private a(StandardTable r1) {
            this.d = r1;
            this.f4589a = r1.backingMap.entrySet().iterator();
            this.c = Iterators.c();
        }

        /* synthetic */ a(StandardTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        public be.a<R, C, V> a() {
            if (this.c.hasNext() == true) goto L5;
            Map.Entry<R, Map<C, V>> r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.f4589a.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            this.f4590b = r0;
            this.c = ((Map) ZeusTransformUtils.preCheckCast(r0.getValue(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
        L5:
            Objects.requireNonNull(this.f4590b);
            Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.c.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            return Tables.a(this.f4590b.getKey(), r1.getKey(), r1.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f4589a.hasNext() == false) goto L5;
        L8:
            return true;
        L5:
            if (this.c.hasNext() == true) goto L8;
            return false;
        }

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            return a();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.c.remove();
            if (((Map) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.f4590b), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Map.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L6;
            this.f4589a.remove();
            this.f4590b = null;
            return;
        }
    }

    private class b extends Maps.m<R, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final C f4591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ StandardTable f4592b;

        private class a extends Sets.b<Map.Entry<R, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f4593a;

            private a(b r1) {
                this.f4593a = r1;
            }

            /* synthetic */ a(b r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                this.f4593a.a(Predicates.a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object r3) {
                if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == false) goto L6;
                Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
                return StandardTable.access$300(this.f4593a.f4592b, r4.getKey(), this.f4593a.f4591a, r4.getValue());
            L6:
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                return !this.f4593a.f4592b.containsColumn(this.f4593a.f4591a);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, V>> iterator() {
                return new C0200b(this.f4593a, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r3) {
                if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == false) goto L6;
                Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
                return StandardTable.access$400(this.f4593a.f4592b, r4.getKey(), this.f4593a.f4591a, r4.getValue());
            L6:
                return false;
            }

            @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> r3) {
                Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
                return this.f4593a.a(Predicates.a(Predicates.a(r4)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<Map<C, V>> r0 = this.f4593a.f4592b.backingMap.values().iterator();
                int r1 = 0;
            L4:
                if (r0.hasNext() == false) goto L8;
                if (((Map) ZeusTransformUtils.preCheckCast(r0.next(), Map.class, "com.obric.memorydata.plugin")).containsKey(this.f4593a.f4591a) == false) goto L4;
                r1 = r1 + 1;
                goto L4
            L8:
                return r1;
            }
        }

        /* JADX INFO: renamed from: com.google.common.collect.StandardTable$b$b, reason: collision with other inner class name */
        private class C0200b extends AbstractIterator<Map.Entry<R, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator<Map.Entry<R, Map<C, V>>> f4594a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f4595b;

            /* JADX INFO: renamed from: com.google.common.collect.StandardTable$b$b$a */
            class a extends com.google.common.collect.b<R, V> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Map.Entry f4596a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ C0200b f4597b;

                a(C0200b r3, Map.Entry r4) {
                    Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r4, Map.Entry.class, "com.obric.memorydata.plugin");
                    this.f4597b = r3;
                    this.f4596a = r5;
                }

                @Override // com.google.common.collect.b, java.util.Map.Entry
                public R getKey() {
                    return (R) this.f4596a.getKey();
                }

                @Override // com.google.common.collect.b, java.util.Map.Entry
                public V getValue() {
                    return (V) ((Map) ZeusTransformUtils.preCheckCast(this.f4596a.getValue(), Map.class, "com.obric.memorydata.plugin")).get(this.f4597b.f4595b.f4591a);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.b, java.util.Map.Entry
                public V setValue(V r4) {
                    return (V) ao.a(((Map) ZeusTransformUtils.preCheckCast(this.f4596a.getValue(), Map.class, "com.obric.memorydata.plugin")).put(this.f4597b.f4595b.f4591a, com.google.common.base.n.a(r4)));
                }
            }

            private C0200b(b r1) {
                this.f4595b = r1;
                this.f4594a = r1.f4592b.backingMap.entrySet().iterator();
            }

            /* synthetic */ C0200b(b r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // com.google.common.collect.AbstractIterator
            public /* synthetic */ Object a() {
                return c();
            }

            public Map.Entry<R, V> c() {
            L3:
                if (this.f4594a.hasNext() == false) goto L9;
                Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.f4594a.next(), Map.Entry.class, "com.obric.memorydata.plugin");
                if (((Map) ZeusTransformUtils.preCheckCast(r0.getValue(), Map.class, "com.obric.memorydata.plugin")).containsKey(this.f4595b.f4591a) == false) goto L3;
                return new a(this, r0);
            L9:
                return (Map.Entry) ZeusTransformUtils.preCheckCast(b(), Map.Entry.class, "com.obric.memorydata.plugin");
            }
        }

        private class c extends Maps.e<R, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f4598a;

            c(b r1) {
                this.f4598a = r1;
                super(r1);
            }

            @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object r2) {
                return this.f4598a.f4592b.contains(r2, this.f4598a.f4591a);
            }

            @Override // com.google.common.collect.Maps.e, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r2) {
                if (this.f4598a.f4592b.remove(r2, this.f4598a.f4591a) == null) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> r3) {
                Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
                return this.f4598a.a(Maps.a(Predicates.a(Predicates.a(r4))));
            }
        }

        private class d extends Maps.l<R, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f4599a;

            d(b r1) {
                this.f4599a = r1;
                super(r1);
            }

            @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object r1) {
                if (r1 != null) goto L4;
            L6:
                return false;
            L4:
                if (this.f4599a.a(Maps.b(Predicates.a(r1))) == false) goto L6;
                return true;
            }

            @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> r3) {
                Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
                return this.f4599a.a(Maps.b(Predicates.a(r4)));
            }

            @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> r3) {
                Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
                return this.f4599a.a(Maps.b(Predicates.a(Predicates.a(r4))));
            }
        }

        b(StandardTable r1, C r2) {
            this.f4592b = r1;
            this.f4591a = (C) com.google.common.base.n.a(r2);
        }

        @Override // com.google.common.collect.Maps.m
        Set<Map.Entry<R, V>> a() {
            return new a(this, null);
        }

        boolean a(com.google.common.base.o<? super Map.Entry<R, V>> r7) {
            com.google.common.base.o r8 = (com.google.common.base.o) ZeusTransformUtils.wrapperContextForParams(r7, com.google.common.base.o.class, "com.obric.memorydata.plugin");
            Iterator<Map.Entry<R, Map<C, V>>> r0 = this.f4592b.backingMap.entrySet().iterator();
            boolean r2 = false;
        L4:
            if (r0.hasNext() == false) goto L12;
            Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            Map r4 = (Map) ZeusTransformUtils.preCheckCast(r3.getValue(), Map.class, "com.obric.memorydata.plugin");
            Object r5 = r4.get(this.f4591a);
            if (r5 == null) goto L4;
            if (r8.apply(Maps.a(r3.getKey(), r5)) == false) goto L4;
            r4.remove(this.f4591a);
            r2 = true;
            if (r4.isEmpty() == false) goto L4;
            r0.remove();
            goto L4
        L12:
            return r2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r2) {
            return this.f4592b.contains(r2, this.f4591a);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object r2) {
            return (V) this.f4592b.get(r2, this.f4591a);
        }

        @Override // com.google.common.collect.Maps.m
        Set<R> h() {
            return new c(this);
        }

        @Override // com.google.common.collect.Maps.m
        Collection<V> i() {
            return new d(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(R r2, V r3) {
            return (V) this.f4592b.put(r2, this.f4591a, r3);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object r2) {
            return (V) this.f4592b.remove(r2, this.f4591a);
        }
    }

    private class c extends AbstractIterator<C> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<C, V> f4600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Iterator<Map<C, V>> f4601b;
        Iterator<Map.Entry<C, V>> c;
        final /* synthetic */ StandardTable d;

        private c(StandardTable r4) {
            this.d = r4;
            this.f4600a = (Map) ZeusTransformUtils.preCheckCast(r4.factory.get(), Map.class, "com.obric.memorydata.plugin");
            this.f4601b = r4.backingMap.values().iterator();
            this.c = Iterators.a();
        }

        /* synthetic */ c(StandardTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.google.common.collect.AbstractIterator
        public C a() {
        L3:
            if (this.c.hasNext() == true) goto L4;
            if (this.f4601b.hasNext() == false) goto L12;
            this.c = ((Map) ZeusTransformUtils.preCheckCast(this.f4601b.next(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
            goto L3
        L12:
            return b();
        L4:
            Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.c.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            if (this.f4600a.containsKey(r0.getKey()) == true) goto L3;
            Map<C, V> r3 = this.f4600a;
            Object r1 = r0.getKey();
            r3.put((C) r1, (V) r0.getValue());
            return (C) r0.getKey();
        }
    }

    private class d extends StandardTable<R, C, V>.h<C> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StandardTable f4602a;

        private d(StandardTable r2) {
            this.f4602a = r2;
            super(r2, null);
        }

        /* synthetic */ d(StandardTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r1) {
            return this.f4602a.containsColumn(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<C> iterator() {
            return this.f4602a.createColumnKeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r5) {
            boolean r0 = false;
            if (r5 != null) goto L5;
            return false;
        L5:
            Iterator<Map<C, V>> r4 = this.f4602a.backingMap.values().iterator();
        L7:
            if (r4.hasNext() == false) goto L13;
            Map r1 = (Map) ZeusTransformUtils.preCheckCast(r4.next(), Map.class, "com.obric.memorydata.plugin");
            if (r1.keySet().remove(r5) == false) goto L7;
            r0 = true;
            if (r1.isEmpty() == false) goto L7;
            r4.remove();
            goto L7
        L13:
            return r0;
        }

        @Override // com.google.common.collect.Sets.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> r5) {
            Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r6);
            Iterator<Map<C, V>> r4 = this.f4602a.backingMap.values().iterator();
            boolean r0 = false;
        L4:
            if (r4.hasNext() == false) goto L10;
            Map r2 = (Map) ZeusTransformUtils.preCheckCast(r4.next(), Map.class, "com.obric.memorydata.plugin");
            if (Iterators.a(r2.keySet().iterator(), r6) == false) goto L4;
            r0 = true;
            if (r2.isEmpty() == false) goto L4;
            r4.remove();
            goto L4
        L10:
            return r0;
        }

        @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> r5) {
            Collection<?> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r6);
            Iterator<Map<C, V>> r4 = this.f4602a.backingMap.values().iterator();
            boolean r0 = false;
        L4:
            if (r4.hasNext() == false) goto L10;
            Map r2 = (Map) ZeusTransformUtils.preCheckCast(r4.next(), Map.class, "com.obric.memorydata.plugin");
            if (r2.keySet().retainAll(r6) == false) goto L4;
            r0 = true;
            if (r2.isEmpty() == false) goto L4;
            r4.remove();
            goto L4
        L10:
            return r0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.b(iterator());
        }
    }

    private class e extends Maps.m<C, Map<R, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StandardTable f4603a;

        class a extends StandardTable<R, C, V>.h<Map.Entry<C, Map<R, V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ e f4604a;

            a(e r2) {
                this.f4604a = r2;
                super(r2.f4603a, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object r4) {
                if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == false) goto L8;
                Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
                if (this.f4604a.f4603a.containsColumn(r5.getKey()) == true) goto L7;
                return false;
            L7:
                return ((Map) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.f4604a.a(r5.getKey())), Map.class, "com.obric.memorydata.plugin")).equals(r5.getValue());
            L8:
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<C, Map<R, V>>> iterator() {
                return Maps.a(this.f4604a.f4603a.columnKeySet(), new AnonymousClass1(this));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r3) {
                if (contains(r3) == true) goto L5;
                return false;
            L5:
                if (ZeusTransformUtils.instanceOf(r3, Map.Entry.class) == false) goto L10;
                Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin");
                StandardTable.access$900(this.f4604a.f4603a, r4.getKey());
                return true;
            L10:
                return false;
            }

            @Override // com.google.common.collect.Sets.b, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> r3) {
                Collection r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
                com.google.common.base.n.a(r4);
                return Sets.a(this, r4.iterator());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Sets.b, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> r5) {
                Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
                com.google.common.base.n.a(r6);
                Iterator r0 = Lists.a(this.f4604a.f4603a.columnKeySet().iterator()).iterator();
                boolean r1 = false;
            L4:
                if (r0.hasNext() == false) goto L8;
                Object r2 = r0.next();
                if (r6.contains(Maps.a(r2, this.f4604a.f4603a.column(r2))) == true) goto L4;
                StandardTable.access$900(this.f4604a.f4603a, r2);
                r1 = true;
                goto L4
            L8:
                return r1;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.f4604a.f4603a.columnKeySet().size();
            }
        }

        private class b extends Maps.l<C, Map<R, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ e f4606a;

            b(e r1) {
                this.f4606a = r1;
                super(r1);
            }

            @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object r6) {
                Iterator<Map.Entry<C, Map<R, V>>> r0 = this.f4606a.entrySet().iterator();
            L4:
                if (r0.hasNext() == false) goto L9;
                Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
                if (((Map) ZeusTransformUtils.preCheckCast(r1.getValue(), Map.class, "com.obric.memorydata.plugin")).equals(r6) == false) goto L4;
                StandardTable.access$900(this.f4606a.f4603a, r1.getKey());
                return true;
            L9:
                return false;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection<?> r5) {
                Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
                com.google.common.base.n.a(r6);
                Iterator r0 = Lists.a(this.f4606a.f4603a.columnKeySet().iterator()).iterator();
                boolean r1 = false;
            L4:
                if (r0.hasNext() == false) goto L8;
                Object r2 = r0.next();
                if (r6.contains(this.f4606a.f4603a.column(r2)) == false) goto L4;
                StandardTable.access$900(this.f4606a.f4603a, r2);
                r1 = true;
                goto L4
            L8:
                return r1;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.Maps.l, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection<?> r5) {
                Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
                com.google.common.base.n.a(r6);
                Iterator r0 = Lists.a(this.f4606a.f4603a.columnKeySet().iterator()).iterator();
                boolean r1 = false;
            L4:
                if (r0.hasNext() == false) goto L8;
                Object r2 = r0.next();
                if (r6.contains(this.f4606a.f4603a.column(r2)) == true) goto L4;
                StandardTable.access$900(this.f4606a.f4603a, r2);
                r1 = true;
                goto L4
            L8:
                return r1;
            }
        }

        private e(StandardTable r1) {
            this.f4603a = r1;
        }

        /* synthetic */ e(StandardTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Map<R, V> a(Object r2) {
            if (this.f4603a.containsColumn(r2) == true) goto L7;
            return null;
        L7:
            return this.f4603a.column(Objects.requireNonNull(r2));
        }

        @Override // com.google.common.collect.Maps.m
        public Set<Map.Entry<C, Map<R, V>>> a() {
            return new a(this);
        }

        public Map<R, V> b(Object r2) {
            if (this.f4603a.containsColumn(r2) == true) goto L7;
            return null;
        L7:
            return StandardTable.access$900(this.f4603a, r2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r1) {
            return this.f4603a.containsColumn(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object get(Object r1) {
            return a(r1);
        }

        @Override // com.google.common.collect.Maps.m
        Collection<Map<R, V>> i() {
            return new b(this);
        }

        @Override // com.google.common.collect.Maps.m, java.util.AbstractMap, java.util.Map
        public Set<C> keySet() {
            return this.f4603a.columnKeySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object remove(Object r1) {
            return b(r1);
        }
    }

    class f extends Maps.d<C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final R f4607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map<C, V> f4608b;
        final /* synthetic */ StandardTable c;

        f(StandardTable r1, R r2) {
            this.c = r1;
            this.f4607a = (R) com.google.common.base.n.a(r2);
        }

        Map.Entry<C, V> a(Map.Entry<C, V> r3) {
            final Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
            return new AnonymousClass2(this, r4);
        }

        final void a() {
            Map<C, V> r0 = this.f4608b;
            if (r0 != null) goto L5;
        L8:
            this.f4608b = b();
            return;
        L5:
            if (r0.isEmpty() == true) goto L7;
            return;
        L7:
            if (this.c.backingMap.containsKey(this.f4607a) == true) goto L8;
        }

        Map<C, V> b() {
            return (Map) ZeusTransformUtils.preCheckCast(this.c.backingMap.get(this.f4607a), Map.class, "com.obric.memorydata.plugin");
        }

        void c() {
            a();
            Map<C, V> r0 = this.f4608b;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isEmpty() == false) goto L9;
            this.c.backingMap.remove(this.f4607a);
            this.f4608b = null;
            return;
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public void clear() {
            a();
            Map<C, V> r0 = this.f4608b;
            if (r0 == null) goto L5;
            r0.clear();
        L5:
            c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r1) {
            a();
            if (r1 == null) goto L9;
            Map<C, V> r0 = this.f4608b;
            if (r0 == null) goto L9;
            if (Maps.b(r0, r1) == false) goto L9;
            return true;
        L9:
            return false;
        }

        @Override // com.google.common.collect.Maps.d
        Iterator<Map.Entry<C, V>> entryIterator() {
            a();
            Map<C, V> r0 = this.f4608b;
            if (r0 == null) goto L5;
            final Iterator<Map.Entry<C, V>> r1 = r0.entrySet().iterator();
            return new AnonymousClass1(this, r1);
        L5:
            return Iterators.c();
        }

        @Override // com.google.common.collect.Maps.d
        Spliterator<Map.Entry<C, V>> entrySpliterator() {
            a();
            Map<C, V> r0 = this.f4608b;
            if (r0 != null) goto L7;
            return Spliterators.emptySpliterator();
        L7:
            return p.a(r0.entrySet().spliterator(), new $$Lambda$8QDnCi5Zl37NzMy7Az7Icv5cuFE(this));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object r1) {
            a();
            if (r1 == null) goto L7;
            Map<C, V> r0 = this.f4608b;
            if (r0 == null) goto L7;
            return (V) Maps.a(r0, r1);
        L7:
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(C r2, V r3) {
            com.google.common.base.n.a(r2);
            com.google.common.base.n.a(r3);
            Map<C, V> r0 = this.f4608b;
            if (r0 == null) goto L9;
            if (r0.isEmpty() == true) goto L9;
            return this.f4608b.put(r2, r3);
        L9:
            return (V) this.c.put(this.f4607a, r2, r3);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object r2) {
            a();
            Map<C, V> r0 = this.f4608b;
            if (r0 != null) goto L6;
            return null;
        L6:
            V r3 = (V) Maps.c(r0, r2);
            c();
            return r3;
        }

        @Override // com.google.common.collect.Maps.d, java.util.AbstractMap, java.util.Map
        public int size() {
            a();
            Map<C, V> r0 = this.f4608b;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }
    }

    class g extends Maps.m<R, Map<C, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ StandardTable f4612b;

        class a extends StandardTable<R, C, V>.h<Map.Entry<R, Map<C, V>>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f4613a;

            a(g r2) {
                this.f4613a = r2;
                super(r2.f4612b, null);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object r4) {
                if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == false) goto L12;
                Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
                if (r5.getKey() != null) goto L7;
                return false;
            L7:
                if (ZeusTransformUtils.instanceOf(r5.getValue(), Map.class) == true) goto L9;
                return false;
            L9:
                if (q.a(this.f4613a.f4612b.backingMap.entrySet(), r5) == false) goto L15;
                return true;
            L15:
                return false;
            L12:
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<R, Map<C, V>>> iterator() {
                return Maps.a(this.f4613a.f4612b.backingMap.keySet(), new AnonymousClass1(this));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object r4) {
                if (ZeusTransformUtils.instanceOf(r4, Map.Entry.class) == false) goto L12;
                Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4, Map.Entry.class, "com.obric.memorydata.plugin");
                if (r5.getKey() != null) goto L7;
                return false;
            L7:
                if (ZeusTransformUtils.instanceOf(r5.getValue(), Map.class) == true) goto L9;
                return false;
            L9:
                if (this.f4613a.f4612b.backingMap.entrySet().remove(r5) == false) goto L15;
                return true;
            L15:
                return false;
            L12:
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.f4613a.f4612b.backingMap.size();
            }
        }

        g(StandardTable r1) {
            this.f4612b = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Map<C, V> a(Object r2) {
            if (this.f4612b.containsRow(r2) == true) goto L7;
            return null;
        L7:
            return this.f4612b.row(Objects.requireNonNull(r2));
        }

        @Override // com.google.common.collect.Maps.m
        public Set<Map.Entry<R, Map<C, V>>> a() {
            return new a(this);
        }

        public Map<C, V> b(Object r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            return (Map) ZeusTransformUtils.preCheckCast(this.f4612b.backingMap.remove(r2), Map.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object r1) {
            return this.f4612b.containsRow(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object get(Object r1) {
            return a(r1);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object remove(Object r1) {
            return b(r1);
        }
    }

    private abstract class h<T> extends Sets.b<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ StandardTable f4615b;

        private h(StandardTable r1) {
            this.f4615b = r1;
        }

        /* synthetic */ h(StandardTable r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this.f4615b.backingMap.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f4615b.backingMap.isEmpty();
        }
    }

    StandardTable(Map<R, Map<C, V>> r3, com.google.common.base.r<? extends Map<C, V>> r4) {
        Map<R, Map<C, V>> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        com.google.common.base.r<? extends Map<C, V>> r6 = (com.google.common.base.r) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.base.r.class, "com.obric.memorydata.plugin");
        this.backingMap = r5;
        this.factory = r6;
    }

    static /* synthetic */ boolean access$300(StandardTable r0, Object r1, Object r2, Object r3) {
        return r0.containsMapping(r1, r2, r3);
    }

    static /* synthetic */ boolean access$400(StandardTable r0, Object r1, Object r2, Object r3) {
        return r0.removeMapping(r1, r2, r3);
    }

    static /* synthetic */ Map access$900(StandardTable r0, Object r1) {
        return r0.removeColumn(r1);
    }

    private boolean containsMapping(Object r1, Object r2, Object r3) {
        if (r3 != null) goto L4;
    L6:
        return false;
    L4:
        if (r3.equals(get(r1, r2)) == false) goto L6;
        return true;
    }

    private Map<C, V> getOrCreate(R r4) {
        Map<C, V> r0 = (Map) ZeusTransformUtils.preCheckCast(this.backingMap.get(r4), Map.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        Map<C, V> r1 = (Map) ZeusTransformUtils.preCheckCast(this.factory.get(), Map.class, "com.obric.memorydata.plugin");
        this.backingMap.put(r4, r1);
        return r1;
    L6:
        return r0;
    }

    static /* synthetic */ be.a lambda$cellSpliterator$0(Map.Entry r2, Map.Entry r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r2, Map.Entry.class, "com.obric.memorydata.plugin");
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        return Tables.a(r4.getKey(), r5.getKey(), r5.getValue());
    }

    static /* synthetic */ Spliterator lambda$cellSpliterator$1(Map.Entry r3) {
        final Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.memorydata.plugin");
        return p.a(((Map) ZeusTransformUtils.preCheckCast(r4.getValue(), Map.class, "com.obric.memorydata.plugin")).entrySet().spliterator(), new $$Lambda$StandardTable$WP4vNSFo6RtQgHEN5LhSOHgsIJU(r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Map<R, V> removeColumn(Object r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<Map.Entry<R, Map<C, V>>> r5 = this.backingMap.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L10;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Object r2 = ((Map) ZeusTransformUtils.preCheckCast(r1.getValue(), Map.class, "com.obric.memorydata.plugin")).remove(r6);
        if (r2 == null) goto L4;
        r0.put(r1.getKey(), r2);
        if (((Map) ZeusTransformUtils.preCheckCast(r1.getValue(), Map.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L4;
        r5.remove();
        goto L4
    L10:
        return r0;
    }

    private boolean removeMapping(Object r1, Object r2, Object r3) {
        if (containsMapping(r1, r2, r3) == false) goto L6;
        remove(r1, r2);
        return true;
    L6:
        return false;
    }

    @Override // com.google.common.collect.i
    Iterator<be.a<R, C, V>> cellIterator() {
        return new a(this, null);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public Set<be.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.i
    Spliterator<be.a<R, C, V>> cellSpliterator() {
        return p.a(this.backingMap.entrySet().spliterator(), $$Lambda$StandardTable$Vzxo9oL8hvAQvGq0nepV6fnu_bc.INSTANCE, 65, size());
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public void clear() {
        this.backingMap.clear();
    }

    @Override // com.google.common.collect.be
    public Map<R, V> column(C r2) {
        return new b(this, r2);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public Set<C> columnKeySet() {
        Set<C> r0 = this.columnKeySet;
        if (r0 != null) goto L6;
        d r1 = new d(this, null);
        this.columnKeySet = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.be
    public Map<C, Map<R, V>> columnMap() {
        StandardTable<R, C, V>.e r0 = this.columnMap;
        if (r0 != null) goto L6;
        StandardTable<R, C, V>.e r1 = new e(this, null);
        this.columnMap = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public boolean contains(Object r1, Object r2) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
        if (super.contains(r1, r2) == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public boolean containsColumn(Object r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        Iterator<Map<C, V>> r4 = this.backingMap.values().iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        if (Maps.b((Map) ZeusTransformUtils.preCheckCast(r4.next(), Map.class, "com.obric.memorydata.plugin"), r5) == false) goto L7;
        return true;
    L12:
        return false;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public boolean containsRow(Object r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (Maps.b(this.backingMap, r1) == false) goto L6;
        return true;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public boolean containsValue(Object r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (super.containsValue(r1) == false) goto L6;
        return true;
    }

    Iterator<C> createColumnKeyIterator() {
        return new c(this, null);
    }

    Map<R, Map<C, V>> createRowMap() {
        return new g(this);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public V get(Object r1, Object r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L6;
        return (V) super.get(r1, r2);
    L6:
        return null;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public boolean isEmpty() {
        return this.backingMap.isEmpty();
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public V put(R r1, C r2, V r3) {
        com.google.common.base.n.a(r1);
        com.google.common.base.n.a(r2);
        com.google.common.base.n.a(r3);
        return getOrCreate(r1).put(r2, r3);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public V remove(Object r5, Object r6) {
        if (r5 == null) goto L13;
        if (r6 == null) goto L13;
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(Maps.a(this.backingMap, r5), Map.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
        return null;
    L9:
        V r7 = (V) r1.remove(r6);
        if (r1.isEmpty() == false) goto L12;
        this.backingMap.remove(r5);
    L12:
        return r7;
    L13:
        return null;
    }

    @Override // com.google.common.collect.be
    public Map<C, V> row(R r2) {
        return new f(this, r2);
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.be
    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> r0 = this.rowMap;
        if (r0 != null) goto L6;
        Map<R, Map<C, V>> r1 = createRowMap();
        this.rowMap = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // com.google.common.collect.be
    public int size() {
        Iterator<Map<C, V>> r4 = this.backingMap.values().iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((Map) ZeusTransformUtils.preCheckCast(r4.next(), Map.class, "com.obric.memorydata.plugin")).size();
        goto L4
    L6:
        return r0;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.be
    public Collection<V> values() {
        return super.values();
    }
}
