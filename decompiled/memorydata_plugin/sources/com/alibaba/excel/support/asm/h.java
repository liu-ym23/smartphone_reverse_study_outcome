package com.alibaba.excel.support.asm;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f315b;
    private final o c;
    private final Object[] d;

    public h(String r1, String r2, o r3, Object... r4) {
        this.f314a = r1;
        this.f315b = r2;
        this.c = r3;
        this.d = r4;
    }

    public String a() {
        return this.f314a;
    }

    public String b() {
        return this.f315b;
    }

    public o c() {
        return this.c;
    }

    Object[] d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
        return false;
    L8:
        h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.memorydata.plugin");
        if (this.f314a.equals(r6.f314a) == false) goto L18;
        if (this.f315b.equals(r6.f315b) == false) goto L18;
        if (this.c.equals(r6.c) == false) goto L18;
        if (Arrays.equals(this.d, r6.d) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        int r0 = (this.f314a.hashCode() ^ Integer.rotateLeft(this.f315b.hashCode(), 8)) ^ Integer.rotateLeft(this.c.hashCode(), 16);
        return Integer.rotateLeft(Arrays.hashCode(this.d), 24) ^ r0;
    }

    public String toString() {
        return this.f314a + " : " + this.f315b + ' ' + this.c + ' ' + Arrays.toString(this.d);
    }
}
