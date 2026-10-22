package com.ss.android.token;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15723b;

    public b(String r1, String r2) {
        this.f15722a = r1;
        this.f15723b = r2;
    }

    public String a() {
        return this.f15722a;
    }

    public String b() {
        return this.f15723b;
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
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
        String r2 = this.f15722a;
        if (r2 == null) goto L16;
        if (r2.equals(r6.f15722a) == false) goto L17;
    L18:
        String r4 = this.f15723b;
        if (r4 == null) goto L24;
        if (r4.equals(r6.f15723b) == false) goto L25;
    L26:
        return true;
    L25:
        return false;
    L24:
        if (r6.f15723b == null) goto L26;
    L17:
        return false;
    L16:
        if (r6.f15722a == null) goto L18;
        goto L17
    }

    public int hashCode() {
        String r0 = this.f15722a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.f15723b;
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
        String r1 = this.f15722a;
        String r2 = "";
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        StringBuilder r3 = r0.append(r1).append(": ");
        String r4 = this.f15723b;
        if (r4 == null) goto L10;
        r2 = r4;
    L10:
        return r3.append(r2).toString();
    }
}
