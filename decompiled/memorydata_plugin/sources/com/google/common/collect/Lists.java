package com.google.common.collect;

import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class Lists {

    private static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final E first;
        final E[] rest;

        OnePlusArrayList(E r2, E[] r3) {
            this.first = r2;
            this.rest = (E[]) ((Object[]) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r3), Object[].class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int r2) {
            com.google.common.base.n.a(r2, size());
            if (r2 != 0) goto L6;
            return this.first;
        L6:
            return this.rest[r2 - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.math.c.d(this.rest.length, 1);
        }
    }

    private static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        StringAsImmutableList(String r1) {
            this.string = r1;
        }

        @Override // java.util.List
        public Character get(int r2) {
            com.google.common.base.n.a(r2, size());
            return Character.valueOf(this.string.charAt(r2));
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Character.class) == true) goto L7;
            return -1;
        L7:
            return this.string.indexOf(((Character) ZeusTransformUtils.preCheckCast(r3, Character.class, "com.obric.memorydata.plugin")).charValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, Character.class) == true) goto L7;
            return -1;
        L7:
            return this.string.lastIndexOf(((Character) ZeusTransformUtils.preCheckCast(r3, Character.class, "com.obric.memorydata.plugin")).charValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.string.length();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<Character> subList(int r2, int r3) {
            com.google.common.base.n.a(r2, r3, size());
            return Lists.a(this.string.substring(r2, r3));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ List subList(int r1, int r2) {
            return subList(r1, r2);
        }
    }

    private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final com.google.common.base.g<? super F, ? extends T> function;

        TransformingRandomAccessList(List<F> r3, com.google.common.base.g<? super F, ? extends T> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            com.google.common.base.g r6 = (com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.base.g.class, "com.obric.memorydata.plugin");
            this.fromList = (List) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), List.class, "com.obric.memorydata.plugin");
            this.function = (com.google.common.base.g) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r6), com.google.common.base.g.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int r2) {
            return this.function.apply(this.fromList.get(r2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        public /* synthetic */ boolean lambda$removeIf$0$Lists$TransformingRandomAccessList(Predicate r3, Object r4) {
            return ((Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin")).test(this.function.apply(r4));
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int r3) {
            final ListIterator<F> r4 = this.fromList.listIterator(r3);
            return new AnonymousClass1(this, r4);
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int r2) {
            return this.function.apply(this.fromList.remove(r2));
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super T> r3) {
            final Predicate r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            return this.fromList.removeIf(new $$Lambda$Lists$TransformingRandomAccessList$ejnOncHNNmmmv_IsgAkCY1rDvWQ(this, r4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    private static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final com.google.common.base.g<? super F, ? extends T> function;

        TransformingSequentialList(List<F> r3, com.google.common.base.g<? super F, ? extends T> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            com.google.common.base.g r6 = (com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r4, com.google.common.base.g.class, "com.obric.memorydata.plugin");
            this.fromList = (List) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r5), List.class, "com.obric.memorydata.plugin");
            this.function = (com.google.common.base.g) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r6), com.google.common.base.g.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        public /* synthetic */ boolean lambda$removeIf$0$Lists$TransformingSequentialList(Predicate r3, Object r4) {
            return ((Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin")).test(this.function.apply(r4));
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int r3) {
            final ListIterator<F> r4 = this.fromList.listIterator(r3);
            return new AnonymousClass1(this, r4);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super T> r3) {
            final Predicate r4 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
            com.google.common.base.n.a(r4);
            return this.fromList.removeIf(new $$Lambda$Lists$TransformingSequentialList$hGsmnKRk31FyLkkDA__7CTrsCc(this, r4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    private static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final E first;
        final E[] rest;
        final E second;

        TwoPlusArrayList(E r1, E r2, E[] r3) {
            this.first = r1;
            this.second = r2;
            this.rest = (E[]) ((Object[]) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r3), Object[].class, "com.obric.memorydata.plugin"));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int r2) {
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L8;
            com.google.common.base.n.a(r2, size());
            return this.rest[r2 - 2];
        L8:
            return this.second;
        L10:
            return this.first;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.math.c.d(this.rest.length, 2);
        }
    }

    static int a(int r4) {
        o.a(r4, "arraySize");
        return Ints.b((((long) r4) + 5) + ((long) (r4 / 10)));
    }

    public static ImmutableList<Character> a(String r3) {
        return new StringAsImmutableList((String) ZeusTransformUtils.preCheckCast(com.google.common.base.n.a(r3), String.class, "com.obric.memorydata.plugin"));
    }

    public static <E> ArrayList<E> a() {
        return new ArrayList();
    }

    public static <E> ArrayList<E> a(Iterable<? extends E> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == false) goto L6;
        return new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin"));
    L6:
        return a(r4.iterator());
    }

    public static <E> ArrayList<E> a(Iterator<? extends E> r2) {
        Iterator r3 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r2, Iterator.class, "com.obric.memorydata.plugin");
        ArrayList<E> r0 = a();
        Iterators.a(r0, r3);
        return r0;
    }

    public static <E> List<E> a(E r1, E[] r2) {
        return new OnePlusArrayList(r1, r2);
    }

    public static <F, T> List<T> a(List<F> r2, com.google.common.base.g<? super F, ? extends T> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        com.google.common.base.g r5 = (com.google.common.base.g) ZeusTransformUtils.wrapperContextForParams(r3, com.google.common.base.g.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, RandomAccess.class) == false) goto L6;
        return new TransformingRandomAccessList(r4, r5);
    L6:
        return new TransformingSequentialList(r4, r5);
    }

    static boolean a(List<?> r6, Object r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r7 != com.google.common.base.n.a(r8)) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, List.class) == true) goto L8;
        return false;
    L8:
        List r9 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.memorydata.plugin");
        int r0 = r8.size();
        if (r0 == r9.size()) goto L12;
        return false;
    L12:
        if (ZeusTransformUtils.instanceOf(r8, RandomAccess.class) == false) goto L23;
        if (ZeusTransformUtils.instanceOf(r9, RandomAccess.class) == false) goto L23;
        int r1 = 0;
    L16:
        if (r1 >= r0) goto L21;
        if (com.google.common.base.k.a(r8.get(r1), r9.get(r1)) == false) goto L19;
        r1 = r1 + 1;
        goto L16
    L19:
        return false;
    L21:
        return true;
    L23:
        return Iterators.a(r8.iterator(), r9.iterator());
    }

    static int b(List<?> r2, Object r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, RandomAccess.class) == true) goto L5;
        ListIterator r5 = r4.listIterator();
    L8:
        if (r5.hasNext() == false) goto L13;
        if (com.google.common.base.k.a(r3, r5.next()) == false) goto L8;
        return r5.previousIndex();
    L13:
        return -1;
    L5:
        return d(r4, r3);
    }

    public static <E> ArrayList<E> b(int r1) {
        o.a(r1, "initialArraySize");
        return new ArrayList(r1);
    }

    static int c(List<?> r2, Object r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, RandomAccess.class) == true) goto L5;
        ListIterator r5 = r4.listIterator(r4.size());
    L8:
        if (r5.hasPrevious() == false) goto L13;
        if (com.google.common.base.k.a(r3, r5.previous()) == false) goto L8;
        return r5.nextIndex();
    L13:
        return -1;
    L5:
        return e(r4, r3);
    }

    public static <E> ArrayList<E> c(int r1) {
        return new ArrayList(a(r1));
    }

    private static int d(List<?> r3, Object r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        int r1 = 0;
        if (r4 != null) goto L9;
    L4:
        if (r1 >= r0) goto L14;
        if (r5.get(r1) == null) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return r1;
    L14:
        return -1;
    L9:
        if (r1 >= r0) goto L20;
        if (r4.equals(r5.get(r1)) == true) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        return r1;
    L20:
        return -1;
    }

    private static int e(List<?> r2, Object r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L10;
        int r5 = r4.size() - 1;
    L5:
        if (r5 < 0) goto L16;
        if (r4.get(r5) == null) goto L8;
        r5 = r5 - 1;
        goto L5
    L8:
        return r5;
    L16:
        return -1;
    L10:
        int r0 = r4.size() - 1;
    L11:
        if (r0 < 0) goto L22;
        if (r3.equals(r4.get(r0)) == true) goto L14;
        r0 = r0 - 1;
        goto L11
    L14:
        return r0;
    L22:
        return -1;
    }
}
