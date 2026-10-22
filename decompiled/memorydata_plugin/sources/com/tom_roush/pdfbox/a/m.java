package com.tom_roush.pdfbox.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class m implements Comparable<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f16065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16066b;

    public m(long r1, int r3) {
        this.f16065a = r1;
        this.f16066b = r3;
    }

    public m(l r3) {
        this(r3.f(), r3.g());
    }

    public int a() {
        return this.f16066b;
    }

    public int a(m r7) {
        if (b() >= r7.b()) goto L6;
        return -1;
    L6:
        if (b() <= r7.b()) goto L9;
        return 1;
    L9:
        if (a() >= r7.a()) goto L12;
        return -1;
    L12:
        if (a() <= r7.a()) goto L14;
        return 1;
    L14:
        return 0;
    }

    public long b() {
        return this.f16065a;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(m r3) {
        return a((m) ZeusTransformUtils.preCheckCast(r3, m.class, "com.obric.memorydata.plugin"));
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, m.class) == false) goto L5;
        m r6 = (m) ZeusTransformUtils.preCheckCast(r5, m.class, "com.obric.memorydata.plugin");
    L6:
        if (r6 != null) goto L8;
    L12:
        return false;
    L8:
        if (r6.b() != b()) goto L12;
        if (r6.a() != a()) goto L12;
        return true;
    L5:
        r6 = null;
        goto L6
    }

    public int hashCode() {
        return Long.valueOf((this.f16065a << 4) + ((long) this.f16066b)).hashCode();
    }

    public String toString() {
        return this.f16065a + " " + this.f16066b + " R";
    }
}
