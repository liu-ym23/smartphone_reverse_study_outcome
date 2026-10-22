package com.ctc.wstx.shaded.msv_core.datatype.regexp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f3562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f3563b;
    c c;

    static class a extends c {
        int d;

        a(int r1, int r2) {
            super(r1);
            this.d = r2;
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.c
        int e() {
            return this.d;
        }
    }

    static class b extends c {
        c d;

        b(int r1) {
            super(r1);
        }

        void a(c r1) {
            this.d = r1;
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.c
        c d() {
            return this.d;
        }
    }

    /* JADX INFO: renamed from: com.ctc.wstx.shaded.msv_core.datatype.regexp.c$c, reason: collision with other inner class name */
    static class C0175c extends c {
        int d;
        c e;
        c f;
        c g;

        C0175c(int r1, int r2, c r3, c r4, c r5) {
            super(r1);
            this.d = r2;
            this.e = r3;
            this.f = r4;
            this.g = r5;
        }
    }

    static class d extends b {
        int e;
        int f;

        d(int r1, int r2, int r3) {
            super(r1);
            this.e = r2;
            this.f = r3;
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.c
        int e() {
            return this.e;
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.c
        int f() {
            return this.f;
        }
    }

    static class e extends c {
        Token d;

        e(int r1, Token r2) {
            super(r1);
            this.d = r2;
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.c
        RangeToken g() {
            return (RangeToken) ZeusTransformUtils.preCheckCast(this.d, RangeToken.class, "com.obric.memorydata.plugin");
        }
    }

    static class f extends c {
        String d;

        f(int r1, String r2) {
            super(r1);
            this.d = r2;
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.c
        String h() {
            return this.d;
        }
    }

    static class g extends c {
        Vector d;

        g(int r1, int r2) {
            super(r1);
            this.d = new Vector(r2);
        }

        void a(c r1) {
            this.d.addElement(r1);
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.c
        int c() {
            return this.d.size();
        }

        @Override // com.ctc.wstx.shaded.msv_core.datatype.regexp.c
        c f(int r2) {
            return (c) ZeusTransformUtils.preCheckCast(this.d.elementAt(r2), c.class, "com.obric.memorydata.plugin");
        }
    }

    static {
    }

    public c(int r2) {
        this.c = null;
        this.f3563b = r2;
    }

    static a a(int r2) {
        return new a(1, r2);
    }

    static a a(int r2, c r3) {
        a r0 = new a(15, r2);
        r0.c = r3;
        return r0;
    }

    static b a(int r1, c r2, c r3) {
        b r0 = new b(r1);
        r0.a(r3);
        r0.c = r2;
        return r0;
    }

    static b a(c r2, c r3) {
        b r0 = new b(24);
        r0.a(r3);
        r0.c = r2;
        return r0;
    }

    static b a(boolean r1) {
        if (r1 == false) goto L5;
        int r2 = 10;
    L7:
        return new b(r2);
    L5:
        r2 = 9;
        goto L7
    }

    static C0175c a(c r7, int r8, c r9, c r10, c r11) {
        C0175c r6 = new C0175c(26, r8, r9, r10, r11);
        r6.c = r7;
        return r6;
    }

    static d a(c r2, c r3, int r4, int r5) {
        d r0 = new d(25, r4, r5);
        r0.a(r3);
        r0.c = r2;
        return r0;
    }

    static e a(Token r2) {
        return new e(3, r2);
    }

    static f a(String r2) {
        return new f(6, r2);
    }

    static c a() {
        return new c(0);
    }

    static a b(int r2) {
        return new a(5, r2);
    }

    static b b() {
        return new b(8);
    }

    static g c(int r2) {
        return new g(11, r2);
    }

    static b d(int r3) {
        return new d(7, r3, -1);
    }

    static a e(int r2) {
        return new a(16, r2);
    }

    int c() {
        return 0;
    }

    c d() {
        throw new RuntimeException("Internal Error: type=" + this.f3563b);
    }

    int e() {
        throw new RuntimeException("Internal Error: type=" + this.f3563b);
    }

    int f() {
        throw new RuntimeException("Internal Error: type=" + this.f3563b);
    }

    c f(int r3) {
        throw new RuntimeException("Internal Error: type=" + this.f3563b);
    }

    RangeToken g() {
        throw new RuntimeException("Internal Error: type=" + this.f3563b);
    }

    String h() {
        throw new RuntimeException("Internal Error: type=" + this.f3563b);
    }
}
