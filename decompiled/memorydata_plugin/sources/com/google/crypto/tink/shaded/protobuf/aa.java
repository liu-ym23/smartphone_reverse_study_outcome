package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class aa extends c<Integer> implements ab.g, bf, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final aa f4935a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f4936b;
    private int c;

    static {
        f4935a = new aa(new int[0], 0, false);
    }

    aa() {
        this(new int[10], 0, true);
    }

    private aa(int[] r1, int r2, boolean r3) {
        super(r3);
        this.f4936b = r1;
        this.c = r2;
    }

    private void b(int r5, int r6) {
        c();
        if (r5 < 0) goto L13;
        int r0 = this.c;
        if (r5 > r0) goto L13;
        int[] r1 = this.f4936b;
        if (r0 >= r1.length) goto L9;
        System.arraycopy(r1, r5, r1, r5 + 1, r0 - r5);
    L10:
        this.f4936b[r5] = r6;
        this.c++;
        this.modCount++;
        return;
    L9:
        int[] r2 = new int[((r0 * 3) / 2) + 1];
        System.arraycopy(r1, 0, r2, 0, r5);
        System.arraycopy(this.f4936b, r5, r2, r5 + 1, this.c - r5);
        this.f4936b = r2;
    L13:
        throw new IndexOutOfBoundsException(h(r5));
    }

    public static aa d() {
        return f4935a;
    }

    private void g(int r2) {
        if (r2 < 0) goto L7;
        if (r2 >= this.c) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(h(r2));
    }

    private String h(int r3) {
        return "Index:" + r3 + ", Size:" + this.c;
    }

    public int a(int r2, int r3) {
        c();
        g(r2);
        int[] r1 = this.f4936b;
        int r0 = r1[r2];
        r1[r2] = r3;
        return r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.g
    public ab.g a(int r3) {
        if (r3 < this.c) goto L7;
        return new aa(Arrays.copyOf(this.f4936b, r3), this.c, true);
    L7:
        throw new IllegalArgumentException();
    }

    public Integer a(int r1, Integer r2) {
        return Integer.valueOf(a(r1, r2.intValue()));
    }

    public boolean a(Integer r1) {
        d(r1.intValue());
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public /* synthetic */ void add(int r3, Object r4) {
        b(r3, (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* synthetic */ boolean add(Object r3) {
        return a((Integer) ZeusTransformUtils.preCheckCast(r3, Integer.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        c();
        ab.a(r7);
        if (ZeusTransformUtils.instanceOf(r7, aa.class) == false) goto L5;
        aa r8 = (aa) ZeusTransformUtils.preCheckCast(r7, aa.class, "com.obric.memorydata.plugin");
        int r0 = r8.c;
        if (r0 != 0) goto L9;
        return false;
    L9:
        int r3 = this.c;
        if ((Integer.MAX_VALUE - r3) < r0) goto L17;
        int r4 = r3 + r0;
        int[] r1 = this.f4936b;
        if (r4 <= r1.length) goto L14;
        this.f4936b = Arrays.copyOf(r1, r4);
    L14:
        System.arraycopy(r8.f4936b, 0, this.f4936b, this.c, r8.c);
        this.c = r4;
        this.modCount++;
        return true;
    L17:
        throw new OutOfMemoryError();
    L5:
        return super.addAll(r7);
    }

    public Integer b(int r1) {
        return Integer.valueOf(c(r1));
    }

    public void b(int r1, Integer r2) {
        b(r1, r2.intValue());
    }

    public int c(int r1) {
        g(r1);
        return this.f4936b[r1];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r1) {
        if (indexOf(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public void d(int r5) {
        c();
        int r0 = this.c;
        int[] r1 = this.f4936b;
        if (r0 != r1.length) goto L5;
        int[] r2 = new int[((r0 * 3) / 2) + 1];
        System.arraycopy(r1, 0, r2, 0, r0);
        this.f4936b = r2;
    L5:
        int[] r3 = this.f4936b;
        int r4 = this.c;
        this.c = r4 + 1;
        r3[r4] = r5;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.i, com.google.crypto.tink.shaded.protobuf.ab.g
    public /* synthetic */ ab.i<Integer> e(int r1) {
        return a(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, aa.class) == false) goto L8;
        aa r7 = (aa) ZeusTransformUtils.preCheckCast(r6, aa.class, "com.obric.memorydata.plugin");
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        int[] r8 = r7.f4936b;
        int r0 = 0;
    L14:
        if (r0 >= this.c) goto L19;
        if (this.f4936b[r0] != r8[r0]) goto L17;
        r0 = r0 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    L8:
        return super.equals(r6);
    }

    public Integer f(int r5) {
        c();
        g(r5);
        int[] r0 = this.f4936b;
        int r1 = r0[r5];
        int r2 = this.c;
        if (r5 >= (r2 - 1)) goto L5;
        System.arraycopy(r0, r5 + 1, r0, r5, (r2 - r5) - 1);
    L5:
        this.c--;
        this.modCount++;
        return Integer.valueOf(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* synthetic */ Object get(int r1) {
        return b(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int r0 = 1;
        int r1 = 0;
    L4:
        if (r1 >= this.c) goto L6;
        r0 = (r0 * 31) + this.f4936b[r1];
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == true) goto L5;
        return -1;
    L5:
        int r6 = ((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.memorydata.plugin")).intValue();
        int r0 = size();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (this.f4936b[r2] == r6) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return r2;
    L11:
        return -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public /* synthetic */ Object remove(int r1) {
        return f(r1);
    }

    @Override // java.util.AbstractList
    public void removeRange(int r3, int r4) {
        c();
        if (r4 < r3) goto L7;
        int[] r0 = this.f4936b;
        System.arraycopy(r0, r4, r0, r3, this.c - r4);
        this.c -= r4 - r3;
        this.modCount++;
        return;
    L7:
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public /* synthetic */ Object set(int r3, Object r4) {
        return a(r3, (Integer) ZeusTransformUtils.preCheckCast(r4, Integer.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c;
    }
}
