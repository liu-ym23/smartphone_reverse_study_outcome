package com.ctc.wstx.util;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f3701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3702b;

    public j(int r1) {
        this.f3701a = new String[r1];
    }

    public int a() {
        return this.f3702b;
    }

    public String a(int r4) {
        if (r4 < 0) goto L8;
        if (r4 >= this.f3702b) goto L8;
        return this.f3701a[r4];
    L8:
        throw new IllegalArgumentException("Index " + r4 + " out of valid range; current size: " + this.f3702b + ".");
    }

    public String a(String r4) {
        int r0 = this.f3702b;
    L3:
        r0 = r0 - 2;
        if (r0 < 0) goto L9;
        String[] r1 = this.f3701a;
        if (r1[r0] != r4) goto L3;
        return r1[r0 + 1];
    L9:
        return null;
    }

    public void a(String r5, String r6) {
        int r0 = this.f3702b + 2;
        String[] r1 = this.f3701a;
        if (r0 <= r1.length) goto L5;
        int r2 = r1.length;
        String[] r3 = new String[(r2 << 1) + r2];
        this.f3701a = r3;
        System.arraycopy(r1, 0, r3, 0, r2);
    L5:
        String[] r4 = this.f3701a;
        int r7 = this.f3702b;
        r4[r7] = r5;
        r4[r7 + 1] = r6;
        this.f3702b = r7 + 2;
    }

    public String b(String r3) {
        int r0 = this.f3702b;
    L3:
        r0 = r0 - 2;
        if (r0 < 0) goto L12;
        String r1 = this.f3701a[r0];
        if (r1 == r3) goto L11;
        if (r1 == null) goto L3;
        if (r1.equals(r3) == false) goto L3;
    L11:
        return this.f3701a[r0 + 1];
    L12:
        return null;
    }

    public void b(int r4) {
    L2:
        r4 = r4 - 1;
        if (r4 < 0) goto L5;
        String[] r0 = this.f3701a;
        int r1 = this.f3702b - 1;
        this.f3702b = r1;
        r0[r1] = null;
        goto L2
    }

    public String[] b() {
        return this.f3701a;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(this.f3702b * 16);
        r0.append("[(size = ");
        r0.append(this.f3702b);
        r0.append(" ) ");
        int r1 = 0;
    L4:
        if (r1 >= this.f3702b) goto L8;
        if (r1 <= 0) goto L7;
        r0.append(", ");
    L7:
        r0.append(Typography.quote);
        r0.append(this.f3701a[r1]);
        r0.append(Typography.quote);
        r0.append(" == ");
        r0.append(Integer.toHexString(System.identityHashCode(this.f3701a[r1])));
        r1 = r1 + 1;
        goto L4
    L8:
        r0.append(']');
        return r0.toString();
    }
}
