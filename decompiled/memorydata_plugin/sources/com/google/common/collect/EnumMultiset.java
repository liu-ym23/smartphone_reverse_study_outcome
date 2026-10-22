package com.google.common.collect;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.google.common.primitives.Ints;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final class EnumMultiset<E extends Enum<E>> extends d<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private transient int[] counts;
    private transient int distinctElements;
    private transient E[] enumConstants;
    private transient long size;
    private transient Class<E> type;

    abstract class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f4432b;
        int c;
        final /* synthetic */ EnumMultiset d;

        a(EnumMultiset r1) {
            this.d = r1;
            this.f4432b = 0;
            this.c = -1;
        }

        abstract T b(int r1);

        @Override // java.util.Iterator
        public boolean hasNext() {
        L3:
            if (this.f4432b >= EnumMultiset.access$000(this.d).length) goto L9;
            int[] r0 = EnumMultiset.access$100(this.d);
            int r1 = this.f4432b;
            if (r0[r1] > 0) goto L6;
            this.f4432b = r1 + 1;
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            T r0 = b(this.f4432b);
            int r1 = this.f4432b;
            this.c = r1;
            this.f4432b = r1 + 1;
            return r0;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.c < 0) goto L5;
            boolean r0 = true;
        L6:
            o.a(r0);
            if (EnumMultiset.access$100(this.d)[this.c] <= 0) goto L9;
            EnumMultiset.access$210(this.d);
            EnumMultiset r1 = this.d;
            EnumMultiset.access$322(r1, EnumMultiset.access$100(r1)[this.c]);
            EnumMultiset.access$100(this.d)[this.c] = 0;
        L9:
            this.c = -1;
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    private EnumMultiset(Class<E> r3) {
        this.type = r3;
        com.google.common.base.n.a(r3.isEnum());
        E[] r4 = (E[]) ((Enum[]) ZeusTransformUtils.preCheckCast(r3.getEnumConstants(), Enum[].class, "com.obric.memorydata.plugin"));
        this.enumConstants = r4;
        this.counts = new int[r4.length];
    }

    static /* synthetic */ Enum[] access$000(EnumMultiset r0) {
        return r0.enumConstants;
    }

    static /* synthetic */ int[] access$100(EnumMultiset r0) {
        return r0.counts;
    }

    static /* synthetic */ int access$210(EnumMultiset r2) {
        int r0 = r2.distinctElements;
        r2.distinctElements = r0 - 1;
        return r0;
    }

    static /* synthetic */ long access$322(EnumMultiset r2, long r3) {
        long r0 = r2.size - r3;
        r2.size = r0;
        return r0;
    }

    private void checkIsE(Object r4) {
        com.google.common.base.n.a(r4);
        if (isActuallyE(r4) == false) goto L6;
        return;
    L6:
        throw new ClassCastException("Expected an " + this.type + " but got " + r4);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> r1) {
        return new EnumMultiset(r1);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.memorydata.plugin");
        Iterator r0 = r5.iterator();
        com.google.common.base.n.a(r0.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> r2 = new EnumMultiset(((Enum) ZeusTransformUtils.preCheckCast(r0.next(), Enum.class, "com.obric.memorydata.plugin")).getDeclaringClass());
        aj.a(r2, r5);
        return r2;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> r2, Class<E> r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.memorydata.plugin");
        EnumMultiset<E> r5 = create(r3);
        aj.a(r5, r4);
        return r5;
    }

    private boolean isActuallyE(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, Enum.class) == false) goto L10;
        Enum r5 = (Enum) ZeusTransformUtils.preCheckCast(r4, Enum.class, "com.obric.memorydata.plugin");
        int r0 = r5.ordinal();
        E[] r3 = this.enumConstants;
        if (r0 < r3.length) goto L7;
        return false;
    L7:
        if (r3[r0] != r5) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    private void readObject(ObjectInputStream r4) {
        r4.defaultReadObject();
        Class<E> r0 = (Class) ZeusTransformUtils.preCheckCast(r4.readObject(), Class.class, "com.obric.memorydata.plugin");
        this.type = r0;
        E[] r1 = (E[]) ((Enum[]) ZeusTransformUtils.preCheckCast(r0.getEnumConstants(), Enum[].class, "com.obric.memorydata.plugin"));
        this.enumConstants = r1;
        this.counts = new int[r1.length];
        av.a(this, r4);
    }

    private void writeObject(ObjectOutputStream r2) {
        r2.defaultWriteObject();
        r2.writeObject(this.type);
        av.a(this, r2);
    }

    public int add(E r8, int r9) {
        checkIsE(r8);
        o.a(r9, "occurrences");
        if (r9 == 0) goto L5;
        int r10 = r8.ordinal();
        int r0 = this.counts[r10];
        long r3 = r9;
        long r1 = ((long) r0) + r3;
        if (r1 > 2147483647L) goto L9;
        boolean r11 = true;
    L10:
        com.google.common.base.n.a(r11, "too many occurrences: %s", r1);
        this.counts[r10] = (int) r1;
        if (r0 != 0) goto L13;
        this.distinctElements++;
    L13:
        this.size += r3;
        return r0;
    L9:
        r11 = false;
        goto L10
    L5:
        return count(r8);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public /* synthetic */ int add(Object r3, int r4) {
        return add((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0;
        this.distinctElements = 0;
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public /* bridge */ /* synthetic */ boolean contains(Object r1) {
        return super.contains(r1);
    }

    @Override // com.google.common.collect.an
    public int count(Object r3) {
        if (r3 != null) goto L4;
        return 0;
    L4:
        if (isActuallyE(r3) == false) goto L10;
        Enum r4 = (Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin");
        return this.counts[r4.ordinal()];
    L10:
        return 0;
    }

    @Override // com.google.common.collect.d
    int distinctElements() {
        return this.distinctElements;
    }

    @Override // com.google.common.collect.d
    Iterator<E> elementIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.d
    Iterator<an.a<E>> entryIterator() {
        return new AnonymousClass2(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.an
    public void forEachEntry(ObjIntConsumer<? super E> r5) {
        ObjIntConsumer r6 = (ObjIntConsumer) ZeusTransformUtils.wrapperContextForParams(r5, ObjIntConsumer.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r6);
        int r0 = 0;
    L3:
        E[] r1 = this.enumConstants;
        if (r0 >= r1.length) goto L9;
        int[] r2 = this.counts;
        if (r2[r0] <= 0) goto L8;
        r6.accept(r1[r0], r2[r0]);
    L8:
        r0 = r0 + 1;
        goto L3
    }

    @Override // com.google.common.collect.d, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.an
    public Iterator<E> iterator() {
        return Multisets.b(this);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public int remove(Object r4, int r5) {
        if (r4 != null) goto L5;
    L18:
        return 0;
    L5:
        if (isActuallyE(r4) == false) goto L18;
        Enum r1 = (Enum) ZeusTransformUtils.preCheckCast(r4, Enum.class, "com.obric.memorydata.plugin");
        o.a(r5, "occurrences");
        if (r5 == 0) goto L10;
        int r6 = r1.ordinal();
        int[] r2 = this.counts;
        int r3 = r2[r6];
        if (r3 != 0) goto L14;
        return 0;
    L14:
        if (r3 > r5) goto L16;
        r2[r6] = 0;
        this.distinctElements--;
        this.size -= (long) r3;
    L17:
        return r3;
    L16:
        r2[r6] = r3 - r5;
        this.size -= (long) r5;
        goto L17
    L10:
        return count(r4);
    }

    public int setCount(E r7, int r8) {
        checkIsE(r7);
        o.a(r8, CommonConsts.COUNT_TYPE);
        int r9 = r7.ordinal();
        int[] r0 = this.counts;
        int r1 = r0[r9];
        r0[r9] = r8;
        this.size += (long) (r8 - r1);
        if (r1 != 0) goto L7;
        if (r8 <= 0) goto L7;
        int r10 = this.distinctElements + 1;
    L6:
        this.distinctElements = r10;
    L10:
        return r1;
    L7:
        if (r1 <= 0) goto L10;
        if (r8 != 0) goto L10;
        r10 = this.distinctElements - 1;
        goto L6
    }

    @Override // com.google.common.collect.d, com.google.common.collect.an
    public /* synthetic */ int setCount(Object r3, int r4) {
        return setCount((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin"), r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.d, com.google.common.collect.an
    public /* bridge */ /* synthetic */ boolean setCount(Object r1, int r2, int r3) {
        return super.setCount(r1, r2, r3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.an
    public int size() {
        return Ints.b(this.size);
    }
}
