package com.ctc.wstx.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected e[] f3696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f3697b;
    protected int c;
    protected int d;
    protected e e;
    protected e f;

    public f() {
        this(128);
    }

    public f(int r2) {
        int r0 = 16;
    L3:
        if (r0 >= r2) goto L5;
        r0 = r0 + r0;
        goto L3
    L5:
        this.f3696a = new e[r0];
        this.d = r0 - 1;
        this.f3697b = 0;
        this.c = (r0 * 80) / 100;
        this.f = null;
        this.e = null;
    }

    public static int a(String r4) {
        int r0 = r4.charAt(0);
        int r1 = r4.length();
        int r2 = 1;
    L3:
        if (r2 >= r1) goto L5;
        r0 = (r0 * 31) + r4.charAt(r2);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    private void b() {
        e[] r0 = this.f3696a;
        int r1 = r0.length;
        int r2 = r1 << 2;
        this.f3696a = new e[r2];
        this.d = r2 - 1;
        this.c <<= 2;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r1) goto L9;
        e r5 = r0[r3];
    L5:
        if (r5 == null) goto L7;
        r4 = r4 + 1;
        int r6 = a(r5.a()) & this.d;
        e r7 = r5.g();
        r5.b(this.f3696a[r6]);
        this.f3696a[r6] = r5;
        r5 = r7;
        goto L5
    L7:
        r3 = r3 + 1;
        goto L3
    L9:
        if (r4 == this.f3697b) goto L14;
        g.a("on rehash(): had " + this.f3697b + " entries; now have " + r4 + ".");
        return;
    }

    public e a() {
        return this.e;
    }

    public e a(char[] r7, int r8, int r9, int r10, javax.xml.stream.a r11, h r12, h r13) {
        javax.xml.stream.a r2 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r11, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        int r14 = this.d & r10;
        e r0 = this.f3696a[r14];
    L3:
        if (r0 == null) goto L9;
        if (r0.a(r7, r8, r9) == true) goto L6;
        r0 = r0.g();
        goto L3
    L6:
        return r0;
    L9:
        if (this.f3697b < this.c) goto L11;
        b();
        r14 = this.d & r10;
    L11:
        this.f3697b++;
        e r15 = new e(new String(r7, r8, r9), r2, false, r12, r13);
        r15.b(this.f3696a[r14]);
        this.f3696a[r14] = r15;
        if (this.e != null) goto L14;
        this.f = r15;
        this.e = r15;
    L15:
        return r15;
    L14:
        this.f.a(r15);
        this.f = r15;
        goto L15
    }

    public e b(char[] r7, int r8, int r9, int r10, javax.xml.stream.a r11, h r12, h r13) {
        javax.xml.stream.a r2 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r11, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        int r14 = this.d & r10;
        e r0 = this.f3696a[r14];
    L3:
        if (r0 == null) goto L8;
        if (r0.a(r7, r8, r9) == true) goto L8;
        r0 = r0.g();
    L8:
        if (r0 != null) goto L14;
        if (this.f3697b < this.c) goto L12;
        b();
        r14 = this.d & r10;
    L12:
        this.f3697b++;
        e r15 = new e(new String(r7, r8, r9), r2, true, r12, r13);
        r15.b(this.f3696a[r14]);
        this.f3696a[r14] = r15;
        return r15;
    L14:
        if (r0.e() == true) goto L34;
        r0.a(r2);
        if (r0 != this.e) goto L32;
    L18:
        e r16 = this.e.f();
        this.e = r16;
        if (r16 == null) goto L23;
        if (r16.e() == true) goto L18;
    L23:
        if (this.e != null) goto L33;
        this.f = null;
        return r0;
    L33:
        return r0;
    L32:
        return r0;
    L34:
        return r0;
    }
}
