package com.ss.android;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15228b;

    public f(String r1, String r2) {
        this.f15227a = r1;
        this.f15228b = r2;
    }

    public String a() {
        return this.f15227a;
    }

    public String b() {
        return this.f15228b;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L27:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L27;
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.memorydata.plugin");
        String r2 = this.f15227a;
        if (r2 == null) goto L16;
        if (r2.equals(r6.f15227a) == false) goto L17;
    L18:
        String r4 = this.f15228b;
        if (r4 == null) goto L24;
        if (r4.equals(r6.f15228b) == false) goto L25;
    L26:
        return true;
    L25:
        return false;
    L24:
        if (r6.f15228b == null) goto L26;
    L17:
        return false;
    L16:
        if (r6.f15227a == null) goto L18;
        goto L17
    }

    public int hashCode() {
        String r0 = this.f15227a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.f15228b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.f15227a;
        String r2 = "";
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        StringBuilder r3 = r0.append(r1).append(": ");
        String r4 = this.f15228b;
        if (r4 == null) goto L10;
        r2 = r4;
    L10:
        return r3.append(r2).toString();
    }
}
