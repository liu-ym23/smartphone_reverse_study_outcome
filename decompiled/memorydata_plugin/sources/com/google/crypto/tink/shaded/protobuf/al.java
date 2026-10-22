package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class al extends c<Long> implements ab.h, bf, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final al f4952a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f4953b;
    private int c;

    static {
        f4952a = new al(new long[0], 0, false);
    }

    al() {
        this(new long[10], 0, true);
    }

    private al(long[] r1, int r2, boolean r3) {
        super(r3);
        this.f4953b = r1;
        this.c = r2;
    }

    private void b(int r5, long r6) {
        c();
        if (r5 < 0) goto L13;
        int r0 = this.c;
        if (r5 > r0) goto L13;
        long[] r1 = this.f4953b;
        if (r0 >= r1.length) goto L9;
        System.arraycopy(r1, r5, r1, r5 + 1, r0 - r5);
    L10:
        this.f4953b[r5] = r6;
        this.c++;
        this.modCount++;
        return;
    L9:
        long[] r2 = new long[((r0 * 3) / 2) + 1];
        System.arraycopy(r1, 0, r2, 0, r5);
        System.arraycopy(this.f4953b, r5, r2, r5 + 1, this.c - r5);
        this.f4953b = r2;
    L13:
        throw new IndexOutOfBoundsException(g(r5));
    }

    public static al d() {
        return f4952a;
    }

    private void f(int r2) {
        if (r2 < 0) goto L7;
        if (r2 >= this.c) goto L7;
        return;
    L7:
        throw new IndexOutOfBoundsException(g(r2));
    }

    private String g(int r3) {
        return "Index:" + r3 + ", Size:" + this.c;
    }

    public long a(int r3, long r4) {
        c();
        f(r3);
        long[] r2 = this.f4953b;
        long r0 = r2[r3];
        r2[r3] = r4;
        return r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.h
    public ab.h a(int r3) {
        if (r3 < this.c) goto L7;
        return new al(Arrays.copyOf(this.f4953b, r3), this.c, true);
    L7:
        throw new IllegalArgumentException();
    }

    public Long a(int r3, Long r4) {
        return Long.valueOf(a(r3, r4.longValue()));
    }

    public void a(long r5) {
        c();
        int r0 = this.c;
        long[] r1 = this.f4953b;
        if (r0 != r1.length) goto L5;
        long[] r2 = new long[((r0 * 3) / 2) + 1];
        System.arraycopy(r1, 0, r2, 0, r0);
        this.f4953b = r2;
    L5:
        long[] r3 = this.f4953b;
        int r4 = this.c;
        this.c = r4 + 1;
        r3[r4] = r5;
    }

    public boolean a(Long r3) {
        a(r3.longValue());
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public /* synthetic */ void add(int r3, Object r4) {
        b(r3, (Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* synthetic */ boolean add(Object r3) {
        return a((Long) ZeusTransformUtils.preCheckCast(r3, Long.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        c();
        ab.a(r7);
        if (ZeusTransformUtils.instanceOf(r7, al.class) == false) goto L5;
        al r8 = (al) ZeusTransformUtils.preCheckCast(r7, al.class, "com.obric.memorydata.plugin");
        int r0 = r8.c;
        if (r0 != 0) goto L9;
        return false;
    L9:
        int r3 = this.c;
        if ((Integer.MAX_VALUE - r3) < r0) goto L17;
        int r4 = r3 + r0;
        long[] r1 = this.f4953b;
        if (r4 <= r1.length) goto L14;
        this.f4953b = Arrays.copyOf(r1, r4);
    L14:
        System.arraycopy(r8.f4953b, 0, this.f4953b, this.c, r8.c);
        this.c = r4;
        this.modCount++;
        return true;
    L17:
        throw new OutOfMemoryError();
    L5:
        return super.addAll(r7);
    }

    public Long b(int r1) {
        return Long.valueOf(c(r1));
    }

    public void b(int r3, Long r4) {
        b(r3, r4.longValue());
    }

    public long c(int r1) {
        f(r1);
        return this.f4953b[r1];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r1) {
        if (indexOf(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public Long d(int r6) {
        c();
        f(r6);
        long[] r0 = this.f4953b;
        long r1 = r0[r6];
        int r3 = this.c;
        if (r6 >= (r3 - 1)) goto L5;
        System.arraycopy(r0, r6 + 1, r0, r6, (r3 - r6) - 1);
    L5:
        this.c--;
        this.modCount++;
        return Long.valueOf(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.i, com.google.crypto.tink.shaded.protobuf.ab.g
    public /* synthetic */ ab.i<Long> e(int r1) {
        return a(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, al.class) == false) goto L8;
        al r10 = (al) ZeusTransformUtils.preCheckCast(r9, al.class, "com.obric.memorydata.plugin");
        if (this.c == r10.c) goto L12;
        return false;
    L12:
        long[] r11 = r10.f4953b;
        int r0 = 0;
    L14:
        if (r0 >= this.c) goto L19;
        if (this.f4953b[r0] != r11[r0]) goto L17;
        r0 = r0 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    L8:
        return super.equals(r9);
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
        r0 = (r0 * 31) + ab.a(this.f4953b[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r7) {
        if (ZeusTransformUtils.instanceOf(r7, Long.class) == true) goto L5;
        return -1;
    L5:
        long r2 = ((Long) ZeusTransformUtils.preCheckCast(r7, Long.class, "com.obric.memorydata.plugin")).longValue();
        int r8 = size();
        int r0 = 0;
    L6:
        if (r0 >= r8) goto L11;
        if (this.f4953b[r0] == r2) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        return r0;
    L11:
        return -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public /* synthetic */ Object remove(int r1) {
        return d(r1);
    }

    @Override // java.util.AbstractList
    public void removeRange(int r3, int r4) {
        c();
        if (r4 < r3) goto L7;
        long[] r0 = this.f4953b;
        System.arraycopy(r0, r4, r0, r3, this.c - r4);
        this.c -= r4 - r3;
        this.modCount++;
        return;
    L7:
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public /* synthetic */ Object set(int r3, Object r4) {
        return a(r3, (Long) ZeusTransformUtils.preCheckCast(r4, Long.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c;
    }
}
