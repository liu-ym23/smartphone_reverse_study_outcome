package com.alibaba.excel.support.asm;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f325b;
    private final String c;
    private final String d;
    private final boolean e;

    public o(int r1, String r2, String r3, String r4, boolean r5) {
        this.f324a = r1;
        this.f325b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public int a() {
        return this.f324a;
    }

    public String b() {
        return this.f325b;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, o.class) == true) goto L8;
        return false;
    L8:
        o r6 = (o) ZeusTransformUtils.preCheckCast(r5, o.class, "com.obric.memorydata.plugin");
        if (this.f324a != r6.f324a) goto L20;
        if (this.e != r6.e) goto L20;
        if (this.f325b.equals(r6.f325b) == false) goto L20;
        if (this.c.equals(r6.c) == false) goto L20;
        if (this.d.equals(r6.d) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.f324a;
        if (this.e == false) goto L5;
        int r1 = 64;
    L7:
        return (r0 + r1) + ((this.f325b.hashCode() * this.c.hashCode()) * this.d.hashCode());
    L5:
        r1 = 0;
        goto L7
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append(this.f325b).append('.').append(this.c).append(this.d).append(" (").append(this.f324a);
        if (this.e == false) goto L5;
        String r2 = " itf";
    L7:
        return r0.append(r2).append(')').toString();
    L5:
        r2 = "";
        goto L7
    }
}
