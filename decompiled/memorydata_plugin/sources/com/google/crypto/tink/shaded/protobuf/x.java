package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
final class x extends c<Float> implements ab.f, bf, RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final x f5046a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float[] f5047b;
    private int c;

    static {
        f5046a = new x(new float[0], 0, false);
    }

    x() {
        this(new float[10], 0, true);
    }

    private x(float[] r1, int r2, boolean r3) {
        super(r3);
        this.f5047b = r1;
        this.c = r2;
    }

    private void b(int r5, float r6) {
        c();
        if (r5 < 0) goto L13;
        int r0 = this.c;
        if (r5 > r0) goto L13;
        float[] r1 = this.f5047b;
        if (r0 >= r1.length) goto L9;
        System.arraycopy(r1, r5, r1, r5 + 1, r0 - r5);
    L10:
        this.f5047b[r5] = r6;
        this.c++;
        this.modCount++;
        return;
    L9:
        float[] r2 = new float[((r0 * 3) / 2) + 1];
        System.arraycopy(r1, 0, r2, 0, r5);
        System.arraycopy(this.f5047b, r5, r2, r5 + 1, this.c - r5);
        this.f5047b = r2;
    L13:
        throw new IndexOutOfBoundsException(g(r5));
    }

    public static x d() {
        return f5046a;
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

    public float a(int r2, float r3) {
        c();
        f(r2);
        float[] r1 = this.f5047b;
        float r0 = r1[r2];
        r1[r2] = r3;
        return r0;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.f
    public ab.f a(int r3) {
        if (r3 < this.c) goto L7;
        return new x(Arrays.copyOf(this.f5047b, r3), this.c, true);
    L7:
        throw new IllegalArgumentException();
    }

    public Float a(int r1, Float r2) {
        return Float.valueOf(a(r1, r2.floatValue()));
    }

    public void a(float r5) {
        c();
        int r0 = this.c;
        float[] r1 = this.f5047b;
        if (r0 != r1.length) goto L5;
        float[] r2 = new float[((r0 * 3) / 2) + 1];
        System.arraycopy(r1, 0, r2, 0, r0);
        this.f5047b = r2;
    L5:
        float[] r3 = this.f5047b;
        int r4 = this.c;
        this.c = r4 + 1;
        r3[r4] = r5;
    }

    public boolean a(Float r1) {
        a(r1.floatValue());
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public /* synthetic */ void add(int r3, Object r4) {
        b(r3, (Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* synthetic */ boolean add(Object r3) {
        return a((Float) ZeusTransformUtils.preCheckCast(r3, Float.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r6, Collection.class, "com.obric.memorydata.plugin");
        c();
        ab.a(r7);
        if (ZeusTransformUtils.instanceOf(r7, x.class) == false) goto L5;
        x r8 = (x) ZeusTransformUtils.preCheckCast(r7, x.class, "com.obric.memorydata.plugin");
        int r0 = r8.c;
        if (r0 != 0) goto L9;
        return false;
    L9:
        int r3 = this.c;
        if ((Integer.MAX_VALUE - r3) < r0) goto L17;
        int r4 = r3 + r0;
        float[] r1 = this.f5047b;
        if (r4 <= r1.length) goto L14;
        this.f5047b = Arrays.copyOf(r1, r4);
    L14:
        System.arraycopy(r8.f5047b, 0, this.f5047b, this.c, r8.c);
        this.c = r4;
        this.modCount++;
        return true;
    L17:
        throw new OutOfMemoryError();
    L5:
        return super.addAll(r7);
    }

    public Float b(int r1) {
        return Float.valueOf(c(r1));
    }

    public void b(int r1, Float r2) {
        b(r1, r2.floatValue());
    }

    public float c(int r1) {
        f(r1);
        return this.f5047b[r1];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r1) {
        if (indexOf(r1) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public Float d(int r5) {
        c();
        f(r5);
        float[] r0 = this.f5047b;
        float r1 = r0[r5];
        int r2 = this.c;
        if (r5 >= (r2 - 1)) goto L5;
        System.arraycopy(r0, r5 + 1, r0, r5, (r2 - r5) - 1);
    L5:
        this.c--;
        this.modCount++;
        return Float.valueOf(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ab.i, com.google.crypto.tink.shaded.protobuf.ab.g
    public /* synthetic */ ab.i<Float> e(int r1) {
        return a(r1);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, x.class) == false) goto L8;
        x r7 = (x) ZeusTransformUtils.preCheckCast(r6, x.class, "com.obric.memorydata.plugin");
        if (this.c == r7.c) goto L12;
        return false;
    L12:
        float[] r8 = r7.f5047b;
        int r0 = 0;
    L14:
        if (r0 >= this.c) goto L19;
        if (Float.floatToIntBits(this.f5047b[r0]) != Float.floatToIntBits(r8[r0])) goto L17;
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
        r0 = (r0 * 31) + Float.floatToIntBits(this.f5047b[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, Float.class) == true) goto L5;
        return -1;
    L5:
        float r6 = ((Float) ZeusTransformUtils.preCheckCast(r5, Float.class, "com.obric.memorydata.plugin")).floatValue();
        int r0 = size();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L11;
        if (this.f5047b[r2] == r6) goto L9;
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
        float[] r0 = this.f5047b;
        System.arraycopy(r0, r4, r0, r3, this.c - r4);
        this.c -= r4 - r3;
        this.modCount++;
        return;
    L7:
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.c, java.util.AbstractList, java.util.List
    public /* synthetic */ Object set(int r3, Object r4) {
        return a(r3, (Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.memorydata.plugin"));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c;
    }
}
