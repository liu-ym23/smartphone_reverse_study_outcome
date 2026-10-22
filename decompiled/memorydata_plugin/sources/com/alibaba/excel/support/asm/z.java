package com.alibaba.excel.support.asm;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final g f341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f342b;
    private int c;
    private String d;
    private int e;
    private a[] f;
    private int g;
    private d h;
    private int i;
    private d j;
    private int k;
    private a[] l;

    private static class a extends y {
        final int h;
        a i;

        a(int r9, int r10, long r11, int r13) {
            super(r9, r10, null, null, null, r11);
            this.h = r13;
        }

        a(int r9, int r10, String r11, int r12) {
            super(r9, r10, null, null, r11, 0);
            this.h = r12;
        }

        a(int r9, int r10, String r11, long r12, int r14) {
            super(r9, r10, null, null, r11, r12);
            this.h = r14;
        }

        a(int r9, int r10, String r11, String r12, int r13) {
            super(r9, r10, null, r11, r12, 0);
            this.h = r13;
        }

        a(int r1, int r2, String r3, String r4, String r5, long r6, int r8) {
            super(r1, r2, r3, r4, r5, r6);
            this.h = r8;
        }
    }

    z(g r1) {
        this.f341a = r1;
        this.f342b = null;
        this.f = new a[256];
        this.g = 1;
        this.h = new d();
    }

    z(g r14, e r15) {
        this.f341a = r14;
        this.f342b = r15;
        byte[] r16 = r15.c;
        int r1 = r15.a(1) - 1;
        int r2 = r15.f311b - r1;
        this.g = r15.b();
        d r3 = new d(r2);
        this.h = r3;
        r3.a(r16, r1, r2);
        this.f = new a[this.g * 2];
        char[] r4 = new char[r15.c()];
        boolean r5 = false;
        int r10 = 1;
    L4:
        if (r10 >= this.g) goto L25;
        int r6 = r15.a(r10);
        byte r11 = r16[r6 - 1];
        switch(r11) {
            case 1: goto L16;
            case 2: goto L8;
            case 3: goto L15;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L14;
            case 7: goto L13;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L12;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L10;
            case 16: goto L13;
            case 17: goto L9;
            case 18: goto L9;
            case 19: goto L13;
            case 20: goto L13;
            default: goto L8;
        };
    L9:
        int r7 = r15.a(r15.c(r6 + 2));
        a(r11, r10, r15.a(r7, r4), r15.a(r7 + 2, r4), r15.c(r6));
        r5 = true;
    L18:
        if (r11 != 5) goto L20;
    L23:
        int r8 = 2;
    L24:
        r10 = r10 + r8;
        goto L4
    L20:
        if (r11 == 6) goto L23;
        r8 = 1;
        goto L24
    L10:
        int r9 = r15.a(r15.c(r6 + 1));
        int r12 = r15.a(r15.c(r9 + 2));
        b(r10, r15.b(r6), r15.c(r9, r4), r15.a(r12, r4), r15.a(r12 + 2, r4));
        goto L18
    L11:
        a(r10, r15.a(r6, r4), r15.a(r6 + 2, r4));
        goto L18
    L12:
        int r13 = r15.a(r15.c(r6 + 2));
        a(r10, r11, r15.c(r6, r4), r15.a(r13, r4), r15.a(r13 + 2, r4));
        goto L18
    L13:
        a(r10, r11, r15.a(r6, r4));
        goto L18
    L14:
        a(r10, r11, r15.f(r6));
        goto L18
    L15:
        a(r10, r11, r15.e(r6));
        goto L18
    L16:
        b(r10, r15.b(r10, r4));
        goto L18
    L8:
        throw new IllegalArgumentException();
    L25:
        if (r5 == false) goto L32;
        a(r15, r4);
        return;
    }

    private static int a(int r0, String r1, int r2) {
        return ((r0 + r1.hashCode()) + r2) & Integer.MAX_VALUE;
    }

    private static int a(int r0, String r1, String r2, String r3, int r4) {
        return (r0 + (((r1.hashCode() * r2.hashCode()) * r3.hashCode()) * r4)) & Integer.MAX_VALUE;
    }

    private y a(int r8, long r9) {
        int r5 = b(r8, r9);
        a r0 = b(r5);
    L3:
        if (r0 == null) goto L12;
        if (r0.f340b != r8) goto L11;
        if (r0.h != r5) goto L11;
        if (r0.f != r9) goto L11;
        return r0;
    L11:
        r0 = r0.i;
        goto L3
    L12:
        int r1 = this.g;
        this.h.a(r8).a(r9);
        this.g += 2;
        return a(new a(r1, r8, r9, r5));
    }

    private y a(int r11, String r12, String r13, int r14) {
        int r8 = b(r11, r12, r13, r14);
        a r0 = b(r8);
    L3:
        if (r0 == null) goto L16;
        if (r0.f340b != r11) goto L15;
        if (r0.h != r8) goto L15;
        if (r0.f != r14) goto L15;
        if (r0.d.equals(r12) == false) goto L15;
        if (r0.e.equals(r13) == false) goto L15;
        return r0;
    L15:
        r0 = r0.i;
        goto L3
    L16:
        this.h.b(r11, r14, a(r12, r13));
        int r1 = this.g;
        this.g = r1 + 1;
        return a(new a(r1, r11, null, r12, r13, r14, r8));
    }

    private a a(int r11, String r12, String r13, String r14) {
        int r8 = b(r11, r12, r13, r14);
        a r0 = b(r8);
    L3:
        if (r0 == null) goto L16;
        if (r0.f340b != r11) goto L15;
        if (r0.h != r8) goto L15;
        if (r0.c.equals(r12) == false) goto L15;
        if (r0.d.equals(r13) == false) goto L15;
        if (r0.e.equals(r14) == false) goto L15;
        return r0;
    L15:
        r0 = r0.i;
        goto L3
    L16:
        this.h.b(r11, a(r12).f339a, a(r13, r14));
        int r1 = this.g;
        this.g = r1 + 1;
        return a(new a(r1, r11, r12, r13, r14, 0, r8));
    }

    private a a(a r8) {
        int r0 = this.e;
        a[] r1 = this.f;
        if (r0 <= ((r1.length * 3) / 4)) goto L11;
        int r2 = r1.length;
        int r3 = (r2 * 2) + 1;
        a[] r4 = new a[r3];
        int r5 = r2 - 1;
    L5:
        if (r5 < 0) goto L10;
        a r6 = this.f[r5];
    L7:
        if (r6 == null) goto L9;
        int r7 = r6.h % r3;
        a r9 = r6.i;
        r6.i = r4[r7];
        r4[r7] = r6;
        r6 = r9;
        goto L7
    L9:
        r5 = r5 - 1;
        goto L5
    L10:
        this.f = r4;
    L11:
        this.e++;
        int r10 = r8.h;
        a[] r11 = this.f;
        int r12 = r10 % r11.length;
        r8.i = r11[r12];
        this.f[r12] = r8;
        return r8;
    }

    private void a(int r8, int r9, int r10) {
        b(new a(r8, r9, r10, c(r9, r10)));
    }

    private void a(int r8, int r9, long r10) {
        b(new a(r8, r9, r10, b(r9, r10)));
    }

    private void a(int r3, int r4, String r5) {
        b(new a(r3, r4, r5, d(r4, r5)));
    }

    private void a(int r11, int r12, String r13, String r14, int r15) {
        b(new a(r12, r11, null, r13, r14, r15, b(r11, r13, r14, r15)));
    }

    private void a(int r11, int r12, String r13, String r14, String r15) {
        b(new a(r11, r12, r13, r14, r15, 0, b(r12, r13, r14, r15)));
    }

    private void a(int r8, String r9, String r10) {
        b(new a(r8, 12, r9, r10, b(12, r9, r10)));
    }

    private void a(e r11, char[] r12) {
        byte[] r0 = r11.c;
        int r1 = r11.a();
        int r2 = r11.c(r1 - 2);
    L3:
        if (r2 <= 0) goto L9;
        if ("BootstrapMethods".equals(r11.a(r1, r12)) == true) goto L6;
        r1 = r1 + (r11.e(r1 + 2) + 6);
        r2 = r2 - 1;
        goto L3
    L6:
        this.i = r11.c(r1 + 6);
    L9:
        if (this.i <= 0) goto L18;
        int r3 = r1 + 8;
        int r4 = r11.e(r1 + 2) - 2;
        d r5 = new d(r4);
        this.j = r5;
        r5.a(r0, r3, r4);
        int r6 = 0;
        int r7 = r3;
    L12:
        if (r6 >= this.i) goto L23;
        int r8 = r7 - r3;
        int r9 = r11.c(r7);
        int r10 = r7 + 2;
        int r13 = r11.c(r10);
        r7 = r10 + 2;
        int r14 = r11.f(r9, r12).hashCode();
    L14:
        int r15 = r13 - 1;
        if (r13 <= 0) goto L17;
        int r16 = r11.c(r7);
        r7 = r7 + 2;
        r14 = r14 ^ r11.f(r16, r12).hashCode();
        r13 = r15;
        goto L14
    L17:
        int r17 = r14 & Integer.MAX_VALUE;
        b(new a(r6, 64, r8, r17));
        r6 = r6 + 1;
        goto L12
    L23:
        return;
    }

    private static int b(int r1, long r2) {
        return ((r1 + ((int) r2)) + ((int) (r2 >>> 32))) & Integer.MAX_VALUE;
    }

    private static int b(int r0, String r1, String r2) {
        return (r0 + (r1.hashCode() * r2.hashCode())) & Integer.MAX_VALUE;
    }

    private static int b(int r0, String r1, String r2, int r3) {
        return (r0 + ((r1.hashCode() * r2.hashCode()) * (r3 + 1))) & Integer.MAX_VALUE;
    }

    private static int b(int r0, String r1, String r2, String r3) {
        return (r0 + ((r1.hashCode() * r2.hashCode()) * r3.hashCode())) & Integer.MAX_VALUE;
    }

    private y b(int r8, int r9) {
        int r5 = c(r8, r9);
        a r0 = b(r5);
    L3:
        if (r0 == null) goto L12;
        if (r0.f340b != r8) goto L11;
        if (r0.h != r5) goto L11;
        if (r0.f != r9) goto L11;
        return r0;
    L11:
        r0 = r0.i;
        goto L3
    L12:
        this.h.a(r8).c(r9);
        int r1 = this.g;
        this.g = r1 + 1;
        return a(new a(r1, r8, r9, r5));
    }

    private y b(int r9, int r10, int r11) {
        byte[] r0 = this.j.f308a;
        a r1 = b(r11);
    L3:
        if (r1 == null) goto L19;
        if (r1.f340b != 64) goto L18;
        if (r1.h != r11) goto L18;
        int r2 = (int) r1.f;
        boolean r3 = false;
        int r4 = 0;
    L9:
        if (r4 >= r10) goto L14;
        if (r0[r9 + r4] != r0[r2 + r4]) goto L15;
        r4 = r4 + 1;
    L15:
        if (r3 == false) goto L18;
        this.j.f309b = r9;
        return r1;
    L14:
        r3 = true;
    L18:
        r1 = r1.i;
        goto L3
    L19:
        int r5 = this.i;
        this.i = r5 + 1;
        return a(new a(r5, 64, r9, r11));
    }

    private a b(int r2) {
        a[] r1 = this.f;
        return r1[r2 % r1.length];
    }

    private void b(int r11, int r12, String r13, String r14, String r15) {
        b(new a(r11, 15, r13, r14, r15, r12, a(15, r13, r14, r15, r12)));
    }

    private void b(int r4, String r5) {
        b(new a(r4, 1, r5, d(1, r5)));
    }

    private void b(a r4) {
        this.e++;
        int r0 = r4.h;
        a[] r1 = this.f;
        int r2 = r0 % r1.length;
        r4.i = r1[r2];
        this.f[r2] = r4;
    }

    private static int c(int r0, int r1) {
        return (r0 + r1) & Integer.MAX_VALUE;
    }

    private int c(a r5) {
        if (this.l != null) goto L5;
        this.l = new a[16];
    L5:
        int r0 = this.k;
        a[] r1 = this.l;
        if (r0 != r1.length) goto L8;
        a[] r2 = new a[r1.length * 2];
        System.arraycopy(r1, 0, r2, 0, r1.length);
        this.l = r2;
    L8:
        a[] r3 = this.l;
        int r4 = this.k;
        this.k = r4 + 1;
        r3[r4] = r5;
        return a(r5).f339a;
    }

    private y c(int r5, String r6) {
        int r0 = d(r5, r6);
        a r1 = b(r0);
    L3:
        if (r1 == null) goto L12;
        if (r1.f340b != r5) goto L11;
        if (r1.h != r0) goto L11;
        if (r1.e.equals(r6) == false) goto L11;
        return r1;
    L11:
        r1 = r1.i;
        goto L3
    L12:
        this.h.b(r5, c(r6));
        int r2 = this.g;
        this.g = r2 + 1;
        return a(new a(r2, r5, r6, r0));
    }

    private static int d(int r0, String r1) {
        return (r0 + r1.hashCode()) & Integer.MAX_VALUE;
    }

    int a(int r9, int r10) {
        if (r9 >= r10) goto L5;
        long r1 = r9;
        long r3 = r10;
    L6:
        long r0 = r1 | (r3 << 32);
        int r7 = c(130, r9 + r10);
        a r2 = b(r7);
    L7:
        if (r2 == null) goto L17;
        if (r2.f340b != 130) goto L16;
        if (r2.h != r7) goto L16;
        if (r2.f != r0) goto L16;
        return r2.g;
    L16:
        r2 = r2.i;
        goto L7
    L17:
        int r11 = g(this.f341a.b(this.l[r9].e, this.l[r10].e));
        a(new a(this.k, 130, r0, r7)).g = r11;
        return r11;
    L5:
        r1 = r10;
        r3 = r9;
        goto L6
    }

    int a(int r1, String r2) {
        this.c = r1;
        this.d = r2;
        return a(r2).f339a;
    }

    int a(String r9, int r10) {
        int r7 = a(129, r9, r10);
        a r1 = b(r7);
    L3:
        if (r1 == null) goto L16;
        if (r1.f340b != 129) goto L14;
        if (r1.h != r7) goto L14;
        if (r1.f != r10) goto L14;
        if (r1.e.equals(r9) == false) goto L14;
        return r1.f339a;
    L14:
        r1 = r1.i;
        goto L3
    L16:
        return c(new a(this.k, 129, r9, r10, r7));
    }

    int a(String r8, String r9) {
        int r6 = b(12, r8, r9);
        a r1 = b(r6);
    L3:
        if (r1 == null) goto L15;
        if (r1.f340b != 12) goto L14;
        if (r1.h != r6) goto L14;
        if (r1.d.equals(r8) == false) goto L14;
        if (r1.e.equals(r9) == false) goto L14;
        return r1.f339a;
    L14:
        r1 = r1.i;
        goto L3
    L15:
        this.h.b(12, c(r8), c(r9));
        int r2 = this.g;
        this.g = r2 + 1;
        return a(new a(r2, 12, r8, r9, r6)).f339a;
    }

    e a() {
        return this.f342b;
    }

    y a(double r2) {
        return a(6, Double.doubleToRawLongBits(r2));
    }

    y a(float r2) {
        return b(4, Float.floatToRawIntBits(r2));
    }

    y a(int r2) {
        return b(3, r2);
    }

    y a(int r11, String r12, String r13, String r14, boolean r15) {
        int r9 = a(15, r12, r13, r14, r11);
        a r1 = b(r9);
    L3:
        if (r1 == null) goto L19;
        if (r1.f340b != 15) goto L17;
        if (r1.h != r9) goto L17;
        if (r1.f != r11) goto L17;
        if (r1.c.equals(r12) == false) goto L17;
        if (r1.d.equals(r13) == false) goto L17;
        if (r1.e.equals(r14) == false) goto L17;
        return r1;
    L17:
        r1 = r1.i;
        goto L3
    L19:
        if (r11 > 4) goto L21;
        this.h.a(15, r11, a(r12, r13, r14).f339a);
    L22:
        int r2 = this.g;
        this.g = r2 + 1;
        return a(new a(r2, 15, r12, r13, r14, r11, r9));
    L21:
        this.h.a(15, r11, a(r12, r13, r14, r15).f339a);
        goto L22
    }

    y a(long r2) {
        return a(5, r2);
    }

    y a(o r12, Object... r13) {
        d r0 = this.j;
        if (r0 != null) goto L5;
        r0 = new d();
        this.j = r0;
    L5:
        int r1 = r13.length;
        int[] r2 = new int[r1];
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L8;
        r2[r4] = a(r13[r4]).f339a;
        r4 = r4 + 1;
        goto L6
    L8:
        int r5 = r0.f309b;
        r0.b(a(r12.a(), r12.b(), r12.c(), r12.d(), r12.e()).f339a);
        r0.b(r1);
        int r6 = 0;
    L9:
        if (r6 >= r1) goto L11;
        r0.b(r2[r6]);
        r6 = r6 + 1;
        goto L9
    L11:
        int r7 = r0.f309b - r5;
        int r14 = r12.hashCode();
        int r8 = r13.length;
    L12:
        if (r3 >= r8) goto L15;
        r14 = r14 ^ r13[r3].hashCode();
        r3 = r3 + 1;
        goto L12
    L15:
        return b(r5, r7, r14 & Integer.MAX_VALUE);
    }

    y a(Object r7) {
        if (ZeusTransformUtils.instanceOf(r7, Integer.class) == false) goto L7;
        return a(((Integer) ZeusTransformUtils.preCheckCast(r7, Integer.class, "com.obric.memorydata.plugin")).intValue());
    L7:
        if (ZeusTransformUtils.instanceOf(r7, Byte.class) == false) goto L11;
        return a(((Byte) ZeusTransformUtils.preCheckCast(r7, Byte.class, "com.obric.memorydata.plugin")).intValue());
    L11:
        if (ZeusTransformUtils.instanceOf(r7, Character.class) == false) goto L15;
        return a(((Character) ZeusTransformUtils.preCheckCast(r7, Character.class, "com.obric.memorydata.plugin")).charValue());
    L15:
        if (ZeusTransformUtils.instanceOf(r7, Short.class) == false) goto L19;
        return a(((Short) ZeusTransformUtils.preCheckCast(r7, Short.class, "com.obric.memorydata.plugin")).intValue());
    L19:
        if (ZeusTransformUtils.instanceOf(r7, Boolean.class) == false) goto L23;
        return a(((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() ? 1 : 0);
    L23:
        if (ZeusTransformUtils.instanceOf(r7, Float.class) == false) goto L27;
        return a(((Float) ZeusTransformUtils.preCheckCast(r7, Float.class, "com.obric.memorydata.plugin")).floatValue());
    L27:
        if (ZeusTransformUtils.instanceOf(r7, Long.class) == false) goto L31;
        return a(((Long) ZeusTransformUtils.preCheckCast(r7, Long.class, "com.obric.memorydata.plugin")).longValue());
    L31:
        if (ZeusTransformUtils.instanceOf(r7, Double.class) == false) goto L35;
        return a(((Double) ZeusTransformUtils.preCheckCast(r7, Double.class, "com.obric.memorydata.plugin")).doubleValue());
    L35:
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L39;
        return b((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"));
    L39:
        if (ZeusTransformUtils.instanceOf(r7, aa.class) == false) goto L51;
        aa r8 = (aa) ZeusTransformUtils.preCheckCast(r7, aa.class, "com.obric.memorydata.plugin");
        int r0 = r8.e();
        if (r0 == 10) goto L43;
        String r9 = r8.d();
        if (r0 != 11) goto L49;
        return d(r9);
    L49:
        return a(r9);
    L43:
        return a(r8.c());
    L51:
        if (ZeusTransformUtils.instanceOf(r7, o.class) == false) goto L55;
        o r10 = (o) ZeusTransformUtils.preCheckCast(r7, o.class, "com.obric.memorydata.plugin");
        return a(r10.a(), r10.b(), r10.c(), r10.d(), r10.e());
    L55:
        if (ZeusTransformUtils.instanceOf(r7, h.class) == false) goto L59;
        h r11 = (h) ZeusTransformUtils.preCheckCast(r7, h.class, "com.obric.memorydata.plugin");
        return a(r11.a(), r11.b(), r11.c(), r11.d());
    L59:
        throw new IllegalArgumentException("value " + r7);
    }

    y a(String r2) {
        return c(7, r2);
    }

    y a(String r1, String r2, o r3, Object... r4) {
        return a(17, r1, r2, a(r3, r4).f339a);
    }

    y a(String r2, String r3, String r4) {
        return a(9, r2, r3, r4);
    }

    y a(String r1, String r2, String r3, boolean r4) {
        if (r4 == false) goto L4;
        int r5 = 11;
    L6:
        return a(r5, r1, r2, r3);
    L4:
        r5 = 10;
        goto L6
    }

    void a(d r3) {
        r3.b(this.g).a(this.h.f308a, 0, this.h.f309b);
    }

    int b() {
        return this.c;
    }

    y b(String r2) {
        return c(8, r2);
    }

    y b(String r1, String r2, o r3, Object... r4) {
        return a(18, r1, r2, a(r3, r4).f339a);
    }

    void b(d r3) {
        if (this.j == null) goto L6;
        r3.b(c("BootstrapMethods")).c(this.j.f309b + 2).b(this.i).a(this.j.f308a, 0, this.j.f309b);
        return;
    }

    int c(String r6) {
        int r1 = d(1, r6);
        a r2 = b(r1);
    L3:
        if (r2 == null) goto L13;
        if (r2.f340b != 1) goto L12;
        if (r2.h != r1) goto L12;
        if (r2.e.equals(r6) == false) goto L12;
        return r2.f339a;
    L12:
        r2 = r2.i;
        goto L3
    L13:
        this.h.a(1).a(r6);
        int r3 = this.g;
        this.g = r3 + 1;
        return a(new a(r3, 1, r6, r1)).f339a;
    }

    String c() {
        return this.d;
    }

    int d() {
        return this.g;
    }

    y d(String r2) {
        return c(16, r2);
    }

    int e() {
        return this.h.f309b;
    }

    y e(String r2) {
        return c(19, r2);
    }

    int f() {
        if (this.j == null) goto L6;
        c("BootstrapMethods");
        return this.j.f309b + 8;
    L6:
        return 0;
    }

    y f(String r2) {
        return c(20, r2);
    }

    int g(String r5) {
        int r1 = d(128, r5);
        a r2 = b(r1);
    L3:
        if (r2 == null) goto L14;
        if (r2.f340b != 128) goto L12;
        if (r2.h != r1) goto L12;
        if (r2.e.equals(r5) == false) goto L12;
        return r2.f339a;
    L12:
        r2 = r2.i;
        goto L3
    L14:
        return c(new a(this.k, 128, r5, r1));
    }

    y getType(int r1) {
        return this.l[r1];
    }
}
