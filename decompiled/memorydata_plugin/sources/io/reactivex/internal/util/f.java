package io.reactivex.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final float f17153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f17154b;
    int c;
    int d;
    T[] e;

    public f() {
        this(16, 0.75f);
    }

    public f(int r2, float r3) {
        this.f17153a = r3;
        int r4 = g.a(r2);
        this.f17154b = r4 - 1;
        this.d = (int) (r3 * r4);
        this.e = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(new Object[r4], Object[].class, "com.obric.memorydata.plugin"));
    }

    static int a(int r1) {
        int r2 = r1 * (-1640531527);
        return r2 ^ (r2 >>> 16);
    }

    void a() {
        T[] r0 = this.e;
        int r1 = r0.length;
        int r2 = r1 << 1;
        int r3 = r2 - 1;
        T[] r4 = (T[]) ((Object[]) ZeusTransformUtils.preCheckCast(new Object[r2], Object[].class, "com.obric.memorydata.plugin"));
        int r5 = this.c;
    L3:
        int r6 = r5 - 1;
        if (r5 == 0) goto L13;
    L5:
        r1 = r1 - 1;
        if (r0[r1] == null) goto L5;
        int r7 = a(r0[r1].hashCode()) & r3;
        if (r4[r7] == null) goto L12;
    L10:
        r7 = (r7 + 1) & r3;
        if (r4[r7] != null) goto L10;
    L12:
        r4[r7] = r0[r1];
        r5 = r6;
        goto L3
    L13:
        this.f17154b = r3;
        this.d = (int) (r2 * this.f17153a);
        this.e = r4;
    }

    boolean a(int r4, T[] r5, int r6) {
        this.c--;
    L3:
        int r3 = r4 + 1;
    L4:
        int r7 = r3 & r6;
        T r0 = r5[r7];
        if (r0 == null) goto L6;
        int r2 = a(r0.hashCode()) & r6;
        if (r4 > r7) goto L13;
        if (r4 >= r2) goto L15;
        if (r2 > r7) goto L15;
    L16:
        r3 = r7 + 1;
    L15:
        r5[r4] = r0;
        r4 = r7;
        goto L3
    L13:
        if (r4 < r2) goto L16;
        if (r2 <= r7) goto L16;
    L6:
        r5[r4] = null;
        return true;
    }

    public boolean a(T r7) {
        T[] r0 = this.e;
        int r1 = this.f17154b;
        int r2 = a(r7.hashCode()) & r1;
        T r3 = r0[r2];
        if (r3 != null) goto L5;
    L13:
        r0[r2] = r7;
        int r8 = this.c + 1;
        this.c = r8;
        if (r8 < this.d) goto L16;
        a();
    L16:
        return true;
    L5:
        if (r3.equals(r7) == false) goto L7;
        return false;
    L7:
        r2 = (r2 + 1) & r1;
        T r4 = r0[r2];
        if (r4 == null) goto L13;
        if (r4.equals(r7) == false) goto L7;
        return false;
    }

    public boolean b(T r6) {
        T[] r0 = this.e;
        int r1 = this.f17154b;
        int r2 = a(r6.hashCode()) & r1;
        T r3 = r0[r2];
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.equals(r6) == true) goto L8;
    L9:
        r2 = (r2 + 1) & r1;
        T r4 = r0[r2];
        if (r4 == null) goto L11;
        if (r4.equals(r6) == false) goto L9;
        return a(r2, r0, r1);
    L11:
        return false;
    L8:
        return a(r2, r0, r1);
    }

    public Object[] b() {
        return this.e;
    }

    public int c() {
        return this.c;
    }
}
