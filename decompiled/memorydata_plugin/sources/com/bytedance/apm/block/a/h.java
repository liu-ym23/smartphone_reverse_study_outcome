package com.bytedance.apm.block.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1221b;
    public long c;
    public int d;
    public int e;

    public h(int r2, int r3, long r4, int r6) {
        this.e = 1;
        this.f1220a = r2;
        this.f1221b = r3;
        this.d = r6;
        this.c = r4;
    }

    public void a(long r3) {
        this.e++;
        this.f1221b = (int) (((long) this.f1221b) + r3);
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, h.class) == false) goto L10;
        h r4 = (h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.memorydata.plugin");
        if (r4.f1220a == this.f1220a) goto L7;
        return false;
    L7:
        if (r4.d != this.d) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return this.d + "," + this.f1220a + "," + this.e + "," + this.f1221b + "," + this.c;
    }
}
