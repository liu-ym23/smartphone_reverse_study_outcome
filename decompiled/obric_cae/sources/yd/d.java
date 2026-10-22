package yd;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class d<E> extends a<E> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Object[] f14114n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f14116b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f14117m;

    static {
        f14114n = new Object[0];
    }

    public d() {
        this.f14116b = f14114n;
    }

    @Override // yd.a
    public final int a() {
        return this.f14117m;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int r8, E r10) {
        y0.d.c(r8, this.f14117m);
        int r11 = this.f14117m;
        if (r8 != r11) goto L6;
        addLast(r10);
        return;
    L6:
        if (r8 != 0) goto L9;
        addFirst(r10);
        return;
    L9:
        d(r11 + 1);
        int r12 = f(this.f14115a + r8);
        int r13 = this.f14117m;
        if (r8 < ((r13 + 1) >> 1)) goto L12;
        int r14 = f(r13 + this.f14115a);
        Object[] r15 = this.f14116b;
        if (r12 >= r14) goto L26;
        e.s0(r15, r15, r12 + 1, r12, r14);
    L27:
        this.f14116b[r12] = r10;
    L28:
        this.f14117m++;
        return;
    L26:
        e.s0(r15, r15, 1, 0, r14);
        Object[] r16 = this.f14116b;
        r16[0] = r16[r16.length - 1];
        e.s0(r16, r16, r12 + 1, r12, r16.length - 1);
        goto L27
    L12:
        if (r12 != 0) goto L14;
        Object[] r17 = this.f14116b;
        he.i.f(r17, "<this>");
        r12 = r17.length;
    L14:
        int r18 = r12 - 1;
        int r19 = this.f14115a;
        if (r19 != 0) goto L17;
        Object[] r20 = this.f14116b;
        he.i.f(r20, "<this>");
        int r21 = r20.length - 1;
    L18:
        int r22 = this.f14115a;
        Object[] r23 = this.f14116b;
        if (r18 < r22) goto L21;
        r23[r21] = r23[r22];
        e.s0(r23, r23, r22, r22 + 1, r18 + 1);
    L22:
        this.f14116b[r18] = r10;
        this.f14115a = r21;
        goto L28
    L21:
        e.s0(r23, r23, r22 - 1, r22, r23.length);
        Object[] r24 = this.f14116b;
        r24[r24.length - 1] = r24[0];
        e.s0(r24, r24, 0, 1, r18 + 1);
        goto L22
    L17:
        r21 = r19 - 1;
        goto L18
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int r10, Collection<? extends E> r11) {
        he.i.f(r11, "elements");
        y0.d.c(r10, this.f14117m);
        if (r11.isEmpty() == false) goto L5;
        return false;
    L5:
        int r8 = this.f14117m;
        if (r10 == r8) goto L8;
        d(r11.size() + r8);
        int r12 = this.f14115a;
        int r13 = f(this.f14117m + r12);
        int r14 = f(this.f14115a + r10);
        int r15 = r11.size();
        if (r10 >= ((this.f14117m + 1) >> 1)) goto L26;
        int r16 = this.f14115a;
        int r17 = r16 - r15;
        if (r14 < r16) goto L19;
        if (r17 < 0) goto L15;
        Object[] r18 = this.f14116b;
        e.s0(r18, r18, r17, r16, r14);
    L23:
        this.f14115a = r17;
        r14 = r14 - r15;
        if (r14 >= 0) goto L40;
        r14 = r14 + this.f14116b.length;
    L40:
        c(r14, r11);
        return true;
    L15:
        Object[] r19 = this.f14116b;
        r17 = r17 + r19.length;
        int r20 = r14 - r16;
        int r21 = r19.length - r17;
        if (r21 < r20) goto L18;
        e.s0(r19, r19, r17, r16, r14);
        goto L23
    L18:
        e.s0(r19, r19, r17, r16, r16 + r21);
        Object[] r22 = this.f14116b;
        e.s0(r22, r22, 0, this.f14115a + r21, r14);
        goto L23
    L19:
        Object[] r23 = this.f14116b;
        e.s0(r23, r23, r17, r16, r23.length);
        Object[] r24 = this.f14116b;
        int r25 = r24.length - r15;
        if (r15 < r14) goto L22;
        e.s0(r24, r24, r25, 0, r14);
        goto L23
    L22:
        e.s0(r24, r24, r25, 0, r15);
        Object[] r26 = this.f14116b;
        e.s0(r26, r26, 0, r15, r14);
        goto L23
    L26:
        int r27 = r14 + r15;
        if (r14 >= r13) goto L36;
        int r28 = r15 + r13;
        Object[] r29 = this.f14116b;
        if (r28 > r29.length) goto L32;
    L34:
        e.s0(r29, r29, r27, r14, r13);
        goto L40
    L32:
        if (r27 < r29.length) goto L35;
        r27 = r27 - r29.length;
        goto L34
    L35:
        int r30 = r13 - (r28 - r29.length);
        e.s0(r29, r29, 0, r30, r13);
        Object[] r31 = this.f14116b;
        e.s0(r31, r31, r27, r14, r30);
        goto L40
    L36:
        Object[] r32 = this.f14116b;
        e.s0(r32, r32, r15, 0, r13);
        Object[] r33 = this.f14116b;
        if (r27 < r33.length) goto L39;
        e.s0(r33, r33, r27 - r33.length, r14, r33.length);
        goto L40
    L39:
        e.s0(r33, r33, 0, r33.length - r15, r33.length);
        Object[] r34 = this.f14116b;
        e.s0(r34, r34, r27, r14, r34.length - r15);
        goto L40
    L8:
        return addAll(r11);
    }

    public final void addFirst(E r8) {
        d(this.f14117m + 1);
        int r10 = this.f14115a;
        if (r10 != 0) goto L5;
        Object[] r11 = this.f14116b;
        he.i.f(r11, "<this>");
        r10 = r11.length;
    L5:
        int r12 = r10 - 1;
        this.f14115a = r12;
        this.f14116b[r12] = r8;
        this.f14117m++;
    }

    public final void addLast(E r8) {
        d(a() + 1);
        Object[] r10 = this.f14116b;
        int r11 = this.f14115a;
        r10[f(a() + r11)] = r8;
        this.f14117m = a() + 1;
    }

    @Override // yd.a
    public final E b(int r10) {
        y0.d.b(r10, this.f14117m);
        if (r10 == l6.a.O(this)) goto L5;
        if (r10 == 0) goto L8;
        int r8 = f(this.f14115a + r10);
        Object[] r11 = this.f14116b;
        E r12 = (E) r11[r8];
        if (r10 >= (this.f14117m >> 1)) goto L16;
        int r13 = this.f14115a;
        if (r8 < r13) goto L14;
        e.s0(r11, r11, r13 + 1, r13, r8);
    L15:
        Object[] r14 = this.f14116b;
        int r15 = this.f14115a;
        r14[r15] = null;
        this.f14115a = e(r15);
    L21:
        this.f14117m--;
        return r12;
    L14:
        e.s0(r11, r11, 1, 0, r8);
        Object[] r16 = this.f14116b;
        r16[0] = r16[r16.length - 1];
        int r17 = this.f14115a;
        e.s0(r16, r16, r17 + 1, r17, r16.length - 1);
        goto L15
    L16:
        int r18 = f(l6.a.O(this) + this.f14115a);
        Object[] r19 = this.f14116b;
        int r20 = r8 + 1;
        if (r8 > r18) goto L19;
        e.s0(r19, r19, r8, r20, r18 + 1);
    L20:
        this.f14116b[r18] = null;
        goto L21
    L19:
        e.s0(r19, r19, r8, r20, r19.length);
        Object[] r21 = this.f14116b;
        r21[r21.length - 1] = r21[0];
        e.s0(r21, r21, 0, 1, r18 + 1);
        goto L20
    L8:
        return removeFirst();
    L5:
        return removeLast();
    }

    public final void c(int r8, Collection<? extends E> r10) {
        Iterator<? extends E> r11 = r10.iterator();
        int r12 = this.f14116b.length;
    L3:
        if (r8 >= r12) goto L7;
        if (r11.hasNext() == false) goto L7;
        this.f14116b[r8] = r11.next();
        r8 = r8 + 1;
    L7:
        int r13 = this.f14115a;
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L12;
        if (r11.hasNext() == false) goto L12;
        this.f14116b[r14] = r11.next();
        r14 = r14 + 1;
    L12:
        int r15 = a();
        this.f14117m = r10.size() + r15;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        int r8 = f(this.f14117m + this.f14115a);
        int r10 = this.f14115a;
        if (r10 >= r8) goto L6;
        Object[] r11 = this.f14116b;
        he.i.f(r11, "<this>");
        Arrays.fill(r11, r10, r8, null);
    L8:
        this.f14115a = 0;
        this.f14117m = 0;
        return;
    L6:
        if ((!isEmpty()) == false) goto L8;
        Object[] r12 = this.f14116b;
        Arrays.fill(r12, this.f14115a, r12.length, null);
        Object[] r13 = this.f14116b;
        he.i.f(r13, "<this>");
        Arrays.fill(r13, 0, r8, null);
        goto L8
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object r8) {
        if (indexOf(r8) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public final void d(int r8) {
        if (r8 < 0) goto L24;
        Object[] r10 = this.f14116b;
        if (r8 > r10.length) goto L7;
        return;
    L7:
        if (r10 == f14114n) goto L9;
        int r11 = r10.length;
        int r12 = r11 + (r11 >> 1);
        if ((r12 - r8) >= 0) goto L17;
        r12 = r8;
    L17:
        if ((r12 - 2147483639) <= 0) goto L21;
        if (r8 <= 2147483639) goto L20;
        r12 = Integer.MAX_VALUE;
        goto L21
    L20:
        r12 = 2147483639;
    L21:
        Object[] r13 = new Object[r12];
        e.s0(r10, r13, 0, this.f14115a, r10.length);
        Object[] r14 = this.f14116b;
        int r15 = r14.length;
        int r16 = this.f14115a;
        e.s0(r14, r13, r15 - r16, 0, r16);
        this.f14115a = 0;
        this.f14116b = r13;
        return;
    L9:
        if (r8 >= 10) goto L11;
        r8 = 10;
    L11:
        this.f14116b = new Object[r8];
        return;
    L24:
        throw new IllegalStateException("Deque is too big.");
    }

    public final int e(int r8) {
        Object[] r10 = this.f14116b;
        he.i.f(r10, "<this>");
        if (r8 != (r10.length - 1)) goto L6;
        return 0;
    L6:
        return r8 + 1;
    }

    public final int f(int r8) {
        Object[] r10 = this.f14116b;
        if (r8 >= r10.length) goto L5;
        return r8;
    L5:
        return r8 - r10.length;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int r8) {
        y0.d.b(r8, this.f14117m);
        return (E) this.f14116b[f(this.f14115a + r8)];
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object r8) {
        int r10 = this.f14115a;
        int r11 = f(a() + r10);
        int r12 = this.f14115a;
        if (r12 >= r11) goto L10;
    L4:
        if (r12 >= r11) goto L31;
        if (he.i.a(r8, this.f14116b[r12]) == true) goto L8;
        r12 = r12 + 1;
    L8:
        return r12 - this.f14115a;
    L31:
        return -1;
    L10:
        if (r12 < r11) goto L23;
        int r13 = this.f14116b.length;
    L12:
        if (r12 >= r13) goto L17;
        if (he.i.a(r8, this.f14116b[r12]) == true) goto L8;
        r12 = r12 + 1;
        goto L12
    L17:
        int r14 = 0;
    L18:
        if (r14 >= r11) goto L32;
        if (he.i.a(r8, this.f14116b[r14]) == true) goto L21;
        r14 = r14 + 1;
        goto L18
    L21:
        r12 = r14 + this.f14116b.length;
        goto L8
    L32:
        return -1;
    L23:
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        if (a() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object r8) {
        int r10 = f(this.f14117m + this.f14115a);
        int r11 = this.f14115a;
        if (r11 >= r10) goto L11;
        int r12 = r10 - 1;
        if (r11 <= r12) goto L7;
    L26:
        return -1;
    L7:
        if (he.i.a(r8, this.f14116b[r12]) == true) goto L23;
        if (r12 == r11) goto L26;
        r12 = r12 - 1;
    L23:
        return r12 - this.f14115a;
    L11:
        if (r11 <= r10) goto L26;
        int r13 = r10 - 1;
    L13:
        if ((-1) >= r13) goto L18;
        if (he.i.a(r8, this.f14116b[r13]) == true) goto L16;
        r13 = r13 - 1;
        goto L13
    L16:
        r12 = r13 + this.f14116b.length;
        goto L23
    L18:
        Object[] r14 = this.f14116b;
        he.i.f(r14, "<this>");
        r12 = r14.length - 1;
        int r15 = this.f14115a;
        if (r15 > r12) goto L26;
    L21:
        if (he.i.a(r8, this.f14116b[r12]) == true) goto L23;
        if (r12 == r15) goto L26;
        r12 = r12 - 1;
        goto L21
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object r8) {
        int r10 = indexOf(r8);
        if (r10 != (-1)) goto L6;
        return false;
    L6:
        b(r10);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection<? extends Object> r12) {
        he.i.f(r12, "elements");
        boolean r8 = false;
        r8 = false;
        int r10 = 0;
        r8 = false;
        if (isEmpty() == false) goto L5;
    L40:
        return r8;
    L5:
        if (this.f14116b.length != 0) goto L7;
        Object[] r11 = true;
    L8:
        if (r11 == true) goto L40;
        int r13 = f(this.f14117m + this.f14115a);
        int r14 = this.f14115a;
        if (r14 >= r13) goto L20;
        int r15 = r14;
    L13:
        if (r14 >= r13) goto L19;
        Object r16 = this.f14116b[r14];
        if ((!r12.contains(r16)) == false) goto L17;
        this.f14116b[r15] = r16;
        r15 = r15 + 1;
    L18:
        r14 = r14 + 1;
        goto L13
    L17:
        r8 = true;
        goto L18
    L19:
        Object[] r17 = this.f14116b;
        he.i.f(r17, "<this>");
        Arrays.fill(r17, r15, r13, null);
    L35:
        if (r8 == false) goto L40;
        int r18 = r15 - this.f14115a;
        if (r18 >= 0) goto L39;
        r18 = r18 + this.f14116b.length;
    L39:
        this.f14117m = r18;
        goto L40
    L20:
        int r19 = this.f14116b.length;
        boolean r20 = false;
        int r21 = r14;
    L21:
        if (r14 >= r19) goto L27;
        Object[] r22 = this.f14116b;
        Object r23 = r22[r14];
        r22[r14] = null;
        if ((!r12.contains(r23)) == false) goto L25;
        this.f14116b[r21] = r23;
        r21 = r21 + 1;
    L26:
        r14 = r14 + 1;
        goto L21
    L25:
        r20 = true;
        goto L26
    L27:
        r15 = f(r21);
    L28:
        if (r10 >= r13) goto L34;
        Object[] r24 = this.f14116b;
        Object r25 = r24[r10];
        r24[r10] = null;
        if ((!r12.contains(r25)) == false) goto L32;
        this.f14116b[r15] = r25;
        r15 = e(r15);
    L33:
        r10 = r10 + 1;
        goto L28
    L32:
        r20 = true;
        goto L33
    L34:
        r8 = r20;
        goto L35
    L7:
        r11 = false;
        goto L8
    }

    public final E removeFirst() {
        if (isEmpty() == true) goto L7;
        Object[] r8 = this.f14116b;
        int r10 = this.f14115a;
        E r11 = (E) r8[r10];
        r8[r10] = null;
        this.f14115a = e(r10);
        this.f14117m = a() - 1;
        return r11;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final E removeLast() {
        if (isEmpty() == true) goto L7;
        int r8 = f(l6.a.O(this) + this.f14115a);
        Object[] r10 = this.f14116b;
        E r11 = (E) r10[r8];
        r10[r8] = null;
        this.f14117m = a() - 1;
        return r11;
    L7:
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection<? extends Object> r12) {
        he.i.f(r12, "elements");
        boolean r8 = false;
        r8 = false;
        int r10 = 0;
        r8 = false;
        if (isEmpty() == false) goto L5;
    L40:
        return r8;
    L5:
        if (this.f14116b.length != 0) goto L7;
        Object[] r11 = true;
    L8:
        if (r11 == true) goto L40;
        int r13 = f(this.f14117m + this.f14115a);
        int r14 = this.f14115a;
        if (r14 >= r13) goto L20;
        int r15 = r14;
    L13:
        if (r14 >= r13) goto L19;
        Object r16 = this.f14116b[r14];
        if (r12.contains(r16) == false) goto L17;
        this.f14116b[r15] = r16;
        r15 = r15 + 1;
    L18:
        r14 = r14 + 1;
        goto L13
    L17:
        r8 = true;
        goto L18
    L19:
        Object[] r17 = this.f14116b;
        he.i.f(r17, "<this>");
        Arrays.fill(r17, r15, r13, null);
    L35:
        if (r8 == false) goto L40;
        int r18 = r15 - this.f14115a;
        if (r18 >= 0) goto L39;
        r18 = r18 + this.f14116b.length;
    L39:
        this.f14117m = r18;
        goto L40
    L20:
        int r19 = this.f14116b.length;
        boolean r20 = false;
        int r21 = r14;
    L21:
        if (r14 >= r19) goto L27;
        Object[] r22 = this.f14116b;
        Object r23 = r22[r14];
        r22[r14] = null;
        if (r12.contains(r23) == false) goto L25;
        this.f14116b[r21] = r23;
        r21 = r21 + 1;
    L26:
        r14 = r14 + 1;
        goto L21
    L25:
        r20 = true;
        goto L26
    L27:
        r15 = f(r21);
    L28:
        if (r10 >= r13) goto L34;
        Object[] r24 = this.f14116b;
        Object r25 = r24[r10];
        r24[r10] = null;
        if (r12.contains(r25) == false) goto L32;
        this.f14116b[r15] = r25;
        r15 = e(r15);
    L33:
        r10 = r10 + 1;
        goto L28
    L32:
        r20 = true;
        goto L33
    L34:
        r8 = r20;
        goto L35
    L7:
        r11 = false;
        goto L8
    }

    @Override // java.util.AbstractList, java.util.List
    public final E set(int r8, E r10) {
        y0.d.b(r8, this.f14117m);
        int r11 = f(this.f14115a + r8);
        Object[] r12 = this.f14116b;
        E r13 = (E) r12[r11];
        r12[r11] = r10;
        return r13;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[a()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final <T> T[] toArray(T[] r8) {
        he.i.f(r8, "array");
        int r10 = r8.length;
        int r11 = this.f14117m;
        if (r10 >= r11) goto L6;
        Object r12 = Array.newInstance(r8.getClass().getComponentType(), r11);
        he.i.d(r12, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        r8 = (T[]) ((Object[]) r12);
    L6:
        int r13 = f(this.f14117m + this.f14115a);
        int r14 = this.f14115a;
        if (r14 >= r13) goto L10;
        e.s0(this.f14116b, r8, 0, r14, r13);
    L12:
        int r15 = r8.length;
        int r16 = this.f14117m;
        if (r15 <= r16) goto L15;
        r8[r16] = null;
    L15:
        return r8;
    L10:
        if ((!isEmpty()) == false) goto L12;
        Object[] r17 = this.f14116b;
        e.s0(r17, r8, 0, this.f14115a, r17.length);
        Object[] r18 = this.f14116b;
        e.s0(r18, r8, r18.length - this.f14115a, 0, r13);
        goto L12
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends E> r8) {
        he.i.f(r8, "elements");
        if (r8.isEmpty() == false) goto L6;
        return false;
    L6:
        int r10 = a();
        d(r8.size() + r10);
        int r11 = this.f14115a;
        c(f(a() + r11), r8);
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E r8) {
        addLast(r8);
        return true;
    }
}
