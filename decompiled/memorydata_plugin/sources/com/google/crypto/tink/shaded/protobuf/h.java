package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class h extends c<Boolean> implements ab.a, bf, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h f5018a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean[] f5019b;
    private int c;

    static {
        f5018a = new h(new boolean[0], 0, false);
    }

    h() {
        this(new boolean[10], 0, true);
    }

    private h(boolean[] r1, int r2, boolean r3) {
        super(r3);
        this.f5019b = r1;
        this.c = r2;
    }

    private void b(int r5, boolean r6) {
        c();
        if (r5 < 0) goto L13;
        int r0 = this.c;
        if (r5 > r0) goto L13;
        boolean[] r1 = this.f5019b;
        if (r0 >= r1.length) goto L9;
        System.arraycopy(r1, r5, r1, r5 + 1, r0 - r5);
    L10:
        this.f5019b[r5] = r6;
        this.c++;
        this.modCount++;
        return;
    L9:
        boolean[] r2 = new boolean[((r0 * 3) / 2) + 1];
        System.arraycopy(r1, 0, r2, 0, r5);
        System.arraycopy(this.f5019b, r5, r2, r5 + 1, this.c - r5);
        this.f5019b = r2;
    L13:
        throw new IndexOutOfBoundsException(g(r5));
    }

    public static h d() {
        return f5018a;
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

    @Override // com.google.crypto.tink.shaded.protobuf.ab.a
    public ab.a a(int r3) {
        if (r3 < this.c) goto L7;
        return new h(Arrays.copyOf(this.f5019b, r3), this.c, true);
    L7:
        throw new IllegalArgumentException();
    }

    public Boolean a(int r1, Boolean r2) {
        return Boolean.valueOf(a(r1, r2.booleanValue()));
    }

    public void a(boolean r5) {
        c();
        int r0 = this.c;
        boolean[] r1 = this.f5019b;
        if (r0 != r1.length) goto L5;
        boolean[] r2 = new boolean[((r0 * 3) / 2) + 1];
        System.arraycopy(r1, 0, r2, 0, r0);
        this.f5019b = r2;
    L5:
        boolean[] r3 = this.f5019b;
        int r4 = this.c;
        this.c = r4 + 1;
        r3[r4] = r5;
    }

    public boolean a(int r2, boolean r3) {
        c();
        f(r2);
        boolean[] r1 = this.f5019b;
        boolean r0 = r1[r2];
        r1[r2] = r3;
        return r0;
    }

    public boolean a(Boolean r1) {
        a(r1.booleanValue());
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public /* synthetic */ void add(int r3, Object r4) {
        b(r3, (Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* synthetic */ boolean add(Object r3) {
        return a((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        c();
        ab.a(r7);
        if (ZeusTransformUtils.instanceOf(r7, h.class) == false) goto L5;
        h r8 = (h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.memorydata.plugin");
        int r0 = r8.c;
        if (r0 != 0) goto L9;
        return false;
    L9:
        int r3 = this.c;
        if ((Integer.MAX_VALUE - r3) < r0) goto L17;
        int r4 = r3 + r0;
        boolean[] r1 = this.f5019b;
        if (r4 <= r1.length) goto L14;
        this.f5019b = Arrays.copyOf(r1, r4);
    L14:
        System.arraycopy(r8.f5019b, 0, this.f5019b, this.c, r8.c);
        this.c = r4;
        this.modCount++;
        return true;
    L17:
        throw new OutOfMemoryError();
    L5:
        return super.addAll(r7);
    }

    public Boolean b(int r1) {
        return Boolean.valueOf(c(r1));
    }

    public void b(int r1, Boolean r2) {
        b(r1, r2.booleanValue());
    }

    public boolean c(int r1) {
        f(r1);
        return this.f5019b[r1];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r1) {
        if (indexOf(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public Boolean d(int r5) {
        c();
        f(r5);
        boolean[] r0 = this.f5019b;
        boolean r1 = r0[r5];
        int r2 = this.c;
        if (r5 >= (r2 - 1)) goto L5;
        System.arraycopy(r0, r5 + 1, r0, r5, (r2 - r5) - 1);
    L5:
        this.c--;
        this.modCount++;
        return Boolean.valueOf(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.i, com.google.crypto.tink.shaded.protobuf.ab.g
    public /* synthetic */ ab.i<Boolean> e(int r1) {
        return a(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, h.class) == false) goto L8;
        h r7 = (h) ZeusTransformUtils.preCheckCast(r6, h.class, "com.obric.memorydata.plugin");
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        boolean[] r8 = r7.f5019b;
        int r0 = 0;
    L14:
        if (r0 >= this.c) goto L19;
        if (this.f5019b[r0] != r8[r0]) goto L17;
        r0 = r0 + 1;
        goto L14
    L17:
        return false;
    L19:
        return true;
    L8:
        return super.equals(r6);
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
        r0 = (r0 * 31) + ab.a(this.f5019b[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, Boolean.class) == true) goto L5;
        return -1;
    L5:
        boolean r6 = ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        int r0 = size();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (this.f5019b[r2] == r6) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return r2;
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
        boolean[] r0 = this.f5019b;
        System.arraycopy(r0, r4, r0, r3, this.c - r4);
        this.c -= r4 - r3;
        this.modCount++;
        return;
    L7:
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public /* synthetic */ Object set(int r3, Object r4) {
        return a(r3, (Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c;
    }
}
