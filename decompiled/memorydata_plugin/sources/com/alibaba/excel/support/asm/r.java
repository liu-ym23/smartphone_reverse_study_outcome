package com.alibaba.excel.support.asm;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected r f331b;

    public r(int r2) {
        this(r2, null);
    }

    public r(int r2, r r3) {
        if (r2 != 589824) goto L5;
    L19:
        this.f330a = r2;
        this.f331b = r3;
        return;
    L5:
        if (r2 == 524288) goto L19;
        if (r2 == 458752) goto L19;
        if (r2 == 393216) goto L19;
        if (r2 == 327680) goto L19;
        if (r2 == 262144) goto L19;
        if (r2 == 17432576) goto L19;
        throw new IllegalArgumentException("Unsupported api " + r2);
    }

    public a a() {
        r r0 = this.f331b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a();
    }

    public a a(int r3, ab r4, String r5, boolean r6) {
        if (this.f330a < 327680) goto L11;
        r r2 = this.f331b;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.a(r3, r4, r5, r6);
    L11:
        throw new UnsupportedOperationException("This feature requires ASM5");
    }

    public a a(int r12, ab r13, q[] r14, q[] r15, int[] r16, String r17, boolean r18) {
        if (this.f330a < 327680) goto L11;
        r r3 = this.f331b;
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.a(r12, r13, r14, r15, r16, r17, r18);
    L11:
        throw new UnsupportedOperationException("This feature requires ASM5");
    }

    public a a(int r1, String r2, boolean r3) {
        r r0 = this.f331b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1, r2, r3);
    }

    public a a(String r1, boolean r2) {
        r r0 = this.f331b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.a(r1, r2);
    }

    public void a(int r1) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public void a(int r1, int r2) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public void a(int r1, int r2, q r3, q... r4) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3, r4);
        return;
    }

    public void a(int r7, int r8, Object[] r9, int r10, Object[] r11) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.a(r7, r8, r9, r10, r11);
        return;
    }

    public void a(int r1, q r2) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public void a(int r1, String r2) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public void a(int r1, String r2, String r3, String r4) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3, r4);
        return;
    }

    public void a(int r7, String r8, String r9, String r10, boolean r11) {
        if (this.f330a < 327680) goto L5;
    L15:
        r r0 = this.f331b;
        if (r0 == null) goto L19;
        r0.a(r7 & (-257), r8, r9, r10, r11);
        return;
    L19:
        return;
    L5:
        if ((r7 & 256) != 0) goto L15;
        if (r7 != 185) goto L9;
        boolean r1 = true;
    L10:
        if (r11 != r1) goto L14;
        b(r7, r8, r9, r10);
        return;
    L14:
        throw new UnsupportedOperationException("INVOKESPECIAL/STATIC on interfaces requires ASM5");
    L9:
        r1 = false;
        goto L10
    }

    public void a(int r1, boolean r2) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    public void a(c r1) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public void a(q r1) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public void a(q r1, q r2, q r3, String r4) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3, r4);
        return;
    }

    public void a(q r1, int[] r2, q[] r3) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.a(r1, r2, r3);
        return;
    }

    public void a(Object r3) {
        if (this.f330a >= 327680) goto L14;
        if (ZeusTransformUtils.instanceOf(r3, o.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r3, aa.class) == false) goto L14;
        if (((aa) ZeusTransformUtils.preCheckCast(r3, aa.class, "com.obric.memorydata.plugin")).e() != 11) goto L14;
    L12:
        throw new UnsupportedOperationException("This feature requires ASM5");
    L14:
        if (this.f330a < 458752) goto L16;
    L20:
        r r2 = this.f331b;
        if (r2 == null) goto L24;
        r2.a(r3);
        return;
    L24:
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r3, h.class) == false) goto L20;
        throw new UnsupportedOperationException("This feature requires ASM7");
    }

    public void a(String r3, int r4) {
        if (this.f330a < 327680) goto L9;
        r r2 = this.f331b;
        if (r2 == null) goto L10;
        r2.a(r3, r4);
        return;
    L10:
        return;
    L9:
        throw new UnsupportedOperationException("This feature requires ASM5");
    }

    public void a(String r3, String r4, o r5, Object... r6) {
        if (this.f330a < 327680) goto L9;
        r r2 = this.f331b;
        if (r2 == null) goto L10;
        r2.a(r3, r4, r5, r6);
        return;
    L10:
        return;
    L9:
        throw new UnsupportedOperationException("This feature requires ASM5");
    }

    public void a(String r8, String r9, String r10, q r11, q r12, int r13) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.a(r8, r9, r10, r11, r12, r13);
        return;
    }

    public a b(int r3, ab r4, String r5, boolean r6) {
        if (this.f330a < 327680) goto L11;
        r r2 = this.f331b;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.b(r3, r4, r5, r6);
    L11:
        throw new UnsupportedOperationException("This feature requires ASM5");
    }

    public void b() {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public void b(int r1, int r2) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.b(r1, r2);
        return;
    }

    public void b(int r1, q r2) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.b(r1, r2);
        return;
    }

    @Deprecated
    public void b(int r9, String r10, String r11, String r12) {
        boolean r1 = false;
        if (this.f330a >= 327680) goto L5;
        int r0 = 256;
    L6:
        int r3 = r9 | r0;
        if (r9 != 185) goto L9;
        r1 = true;
    L9:
        a(r3, r10, r11, r12, r1);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    public void b(String r1, int r2) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.b(r1, r2);
        return;
    }

    public a c(int r3, ab r4, String r5, boolean r6) {
        if (this.f330a < 327680) goto L11;
        r r2 = this.f331b;
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.c(r3, r4, r5, r6);
    L11:
        throw new UnsupportedOperationException("This feature requires ASM5");
    }

    public void c() {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public void c(int r1, int r2) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.c(r1, r2);
        return;
    }

    public void d(int r1, int r2) {
        r r0 = this.f331b;
        if (r0 == null) goto L6;
        r0.d(r1, r2);
        return;
    }
}
