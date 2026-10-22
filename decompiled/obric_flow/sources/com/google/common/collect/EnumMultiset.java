package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
public final class EnumMultiset<E extends Enum<E>> extends j0 implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Class f8808c;
    public transient Enum[] d;
    public transient int[] e;
    public transient int f;
    public transient long g;

    public EnumMultiset(Class r5) {
        this.f8808c = r5;
        com.google.common.base.b0.i(r5.isEnum());
        Enum[] r10 = (Enum[]) r5.getEnumConstants();
        this.d = r10;
        this.e = new int[r10.length];
    }

    public static /* synthetic */ Enum[] access$000(EnumMultiset r5) {
        return r5.d;
    }

    public static /* synthetic */ int[] access$100(EnumMultiset r5) {
        return r5.e;
    }

    public static /* synthetic */ int access$210(EnumMultiset r5) {
        int r10 = r5.f;
        r5.f = r10 - 1;
        return r10;
    }

    public static /* synthetic */ long access$322(EnumMultiset r5, long r10) {
        long r11 = r5.g - r10;
        r5.g = r11;
        return r11;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> r5) {
        return new EnumMultiset(r5);
    }

    private void readObject(ObjectInputStream r5) throws IOException, ClassNotFoundException {
        r5.defaultReadObject();
        Class r10 = (Class) r5.readObject();
        this.f8808c = r10;
        Enum[] r11 = (Enum[]) r10.getEnumConstants();
        this.d = r11;
        this.e = new int[r11.length];
        p7.f0(this, r5, r5.readInt());
    }

    private void writeObject(ObjectOutputStream r5) throws IOException {
        r5.defaultWriteObject();
        r5.writeObject(this.f8808c);
        p7.A0(this, r5);
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ int add(Object r5, int r10) {
        return add((Enum) r5, r10);
    }

    public final void b(Enum r5) {
        r5.getClass();
        if (c(r5) == false) goto L5;
        return;
    L5:
        String r10 = String.valueOf(this.f8808c);
        String r11 = String.valueOf(r5);
        int r12 = r10.length() + 21;
        StringBuilder r13 = new StringBuilder(r11.length() + r12);
        r13.append("Expected an ");
        r13.append(r10);
        r13.append(" but got ");
        r13.append(r11);
        throw new ClassCastException(r13.toString());
    }

    public final boolean c(Object r5) {
        if ((r5 instanceof Enum) == false) goto L10;
        Enum r10 = (Enum) r5;
        int r11 = r10.ordinal();
        Enum[] r12 = this.d;
        if (r11 < r12.length) goto L7;
        return false;
    L7:
        if (r12[r11] != r10) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.e, 0);
        this.g = 0;
        this.f = 0;
    }

    @Override // com.google.common.collect.j0, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean contains(Object r5) {
        return super.contains(r5);
    }

    @Override // com.google.common.collect.z7
    public int count(Object r5) {
        if (r5 != null) goto L4;
        return 0;
    L4:
        if (c(r5) == true) goto L7;
        return 0;
    L7:
        return this.e[((Enum) r5).ordinal()];
    }

    @Override // com.google.common.collect.j0
    public int distinctElements() {
        return this.f;
    }

    @Override // com.google.common.collect.j0
    public Iterator<E> elementIterator() {
        return new p2(this, 0);
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.j0
    public Iterator<y7> entryIterator() {
        return new p2(this, 1);
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ void forEach(Consumer r5) {
        super.forEach(r5);
    }

    @Override // com.google.common.collect.z7
    public void forEachEntry(ObjIntConsumer<? super E> r5) {
        r5.getClass();
        int r10 = 0;
    L3:
        Enum[] r11 = this.d;
        if (r10 >= r11.length) goto L9;
        int r12 = this.e[r10];
        if (r12 <= 0) goto L8;
        r5.accept(r11[r10], r12);
    L8:
        r10 = r10 + 1;
        goto L3
    }

    @Override // com.google.common.collect.j0, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return p7.O(this);
    }

    @Override // com.google.common.collect.z7
    public int remove(Object r5, int r10) {
        if (r5 != null) goto L5;
    L18:
        return 0;
    L5:
        if (c(r5) == false) goto L18;
        Enum r11 = (Enum) r5;
        p7.q(r10, "occurrences");
        if (r10 == 0) goto L10;
        int r12 = r11.ordinal();
        int[] r13 = this.e;
        int r14 = r13[r12];
        if (r14 != 0) goto L14;
        return 0;
    L14:
        if (r14 > r10) goto L16;
        r13[r12] = 0;
        this.f--;
        this.g -= (long) r14;
    L17:
        return r14;
    L16:
        r13[r12] = r14 - r10;
        this.g -= (long) r10;
        goto L17
    L10:
        return count(r5);
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ int setCount(Object r5, int r10) {
        return setCount((Enum) r5, r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return dn.a.U(this.g);
    }

    @Override // java.util.Collection, java.lang.Iterable, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return super.spliterator();
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> r5) {
        Iterator<E> r10 = r5.iterator();
        com.google.common.base.b0.g("EnumMultiset constructor passed empty Iterable", r10.hasNext());
        EnumMultiset<E> r11 = new EnumMultiset(r10.next().getDeclaringClass());
        p7.i(r11, r5);
        return r11;
    }

    public int add(E r10, int r11) {
        b(r10);
        p7.q(r11, "occurrences");
        if (r11 == 0) goto L5;
        int r12 = r10.ordinal();
        int r5 = this.e[r12];
        long r13 = r11;
        long r14 = ((long) r5) + r13;
        if (r14 > 2147483647L) goto L9;
        boolean r15 = true;
    L10:
        com.google.common.base.b0.f("too many occurrences: %s", r14, r15);
        this.e[r12] = (int) r14;
        if (r5 != 0) goto L13;
        this.f++;
    L13:
        this.g += r13;
        return r5;
    L9:
        r15 = false;
        goto L10
    L5:
        return count(r10);
    }

    @Override // com.google.common.collect.j0, com.google.common.collect.z7
    public /* bridge */ /* synthetic */ boolean setCount(Object r5, int r10, int r11) {
        return super.setCount(r5, r10, r11);
    }

    public int setCount(E r10, int r11) {
        b(r10);
        p7.q(r11, "count");
        int r12 = r10.ordinal();
        int[] r5 = this.e;
        int r13 = r5[r12];
        r5[r12] = r11;
        this.g += (long) (r11 - r13);
        if (r13 != 0) goto L6;
        if (r11 <= 0) goto L6;
        this.f++;
    L9:
        return r13;
    L6:
        if (r13 <= 0) goto L9;
        if (r11 != 0) goto L9;
        this.f--;
        goto L9
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> r5, Class<E> r10) {
        EnumMultiset<E> r11 = create(r10);
        p7.i(r11, r5);
        return r11;
    }
}
