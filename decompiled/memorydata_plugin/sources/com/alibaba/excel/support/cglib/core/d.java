package com.alibaba.excel.support.cglib.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.alibaba.excel.support.cglib.a.a {
    private static int e;
    private f c;
    private Map d;
    private com.alibaba.excel.support.asm.r f;
    private g g;
    private g h;
    private ag i;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f386b;
        com.alibaba.excel.support.asm.aa c;
        Object d;

        public a(int r1, String r2, com.alibaba.excel.support.asm.aa r3, Object r4) {
            this.f385a = r1;
            this.f386b = r2;
            this.c = r3;
            this.d = r4;
        }

        public boolean equals(Object r5) {
            if (r5 != null) goto L6;
            return false;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f385a == r6.f385a) goto L11;
        L31:
            return false;
        L11:
            if (this.f386b.equals(r6.f386b) == false) goto L31;
            if (this.c.equals(r6.c) == false) goto L31;
            Object r4 = this.d;
            if (r4 != null) goto L18;
            boolean r2 = true;
        L19:
            Object r7 = r6.d;
            if (r7 != null) goto L22;
            boolean r3 = true;
        L24:
            if ((r2 ^ r3) == false) goto L26;
            return false;
        L26:
            if (r4 != null) goto L28;
        L30:
            return true;
        L28:
            if (r4.equals(r7) == true) goto L30;
            return false;
        L22:
            r3 = false;
            goto L24
        L18:
            r2 = false;
            goto L19
        }

        public int hashCode() {
            int r0 = (this.f385a ^ this.f386b.hashCode()) ^ this.c.hashCode();
            Object r2 = this.d;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r3 ^ r0;
        L5:
            r3 = r2.hashCode();
            goto L7
        }
    }

    public d() {
        super(i.h);
    }

    public d(com.alibaba.excel.support.asm.f r1) {
        a(r1);
    }

    private static synchronized int j() {
        monitor-enter(d.class);
        int r1 = e + 1;     // Catch: Throwable -> L7
        e = r1;     // Catch: Throwable -> L7
        monitor-exit(d.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.alibaba.excel.support.asm.f
    public com.alibaba.excel.support.asm.l a(int r1, String r2, String r3, String r4, Object r5) {
        a(r1, r2, com.alibaba.excel.support.asm.aa.getType(r3), r5);
        return null;
    }

    @Override // com.alibaba.excel.support.asm.f
    public com.alibaba.excel.support.asm.r a(int r1, String r2, String r3, String r4, String[] r5) {
        return a(r1, new ag(r2, r3), ai.a(r5));
    }

    public g a(final int r14, final ag r15, final com.alibaba.excel.support.asm.aa[] r16) {
        if (this.c == null) goto L21;
        final com.alibaba.excel.support.asm.r r3 = this.f313b.a(r14, r15.a(), r15.b(), null, ai.a(r16));
        if (r15.equals(i.k) == false) goto L15;
        if (ai.f(e()) == true) goto L15;
        this.f = r3;
        final int r0 = i.h;
        g r7 = new g(this, new AnonymousClass2(this, r0, r3), r14, r15, r16);
        this.g = r7;
        if (this.h != null) goto L11;
        c();
    L13:
        return this.g;
    L11:
        r7.c(this.i);
    L15:
        if (r15.equals(this.i) == false) goto L19;
        return new AnonymousClass3(this, this, r3, r14, r15, r16);
    L19:
        return new g(this, r3, r14, r15, r16);
    L21:
        throw new IllegalStateException("classInfo is null! " + this);
    }

    @Override // com.alibaba.excel.support.asm.f
    public void a() {
        h();
    }

    public void a(int r17, final int r18, String r19, final com.alibaba.excel.support.asm.aa r20, final com.alibaba.excel.support.asm.aa[] r21, String r22) {
        final com.alibaba.excel.support.asm.aa r2 = com.alibaba.excel.support.asm.aa.getType(com.tom_roush.pdfbox.pdmodel.a.d.i.u + r19.replace('.', '/') + ";");
        this.c = new AnonymousClass1(this, r2, r20, r21, r18);
        this.f313b.a(r17, r18, this.c.getType().c(), null, this.c.a().c(), ai.a(r21));
        if (r22 == null) goto L5;
        this.f313b.a(r22, null);
    L5:
        d();
    }

    @Override // com.alibaba.excel.support.asm.f
    public void a(int r9, int r10, String r11, String r12, String r13, String[] r14) {
        a(r9, r10, r11.replace('/', '.'), ai.b(r13), ai.a(r14), null);
    }

    public void a(int r9, String r10, com.alibaba.excel.support.asm.aa r11, Object r12) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.d.get(r10), a.class, "com.obric.memorydata.plugin");
        a r1 = new a(r9, r10, r11, r12);
        if (r0 != null) goto L5;
        this.d.put(r10, r1);
        this.f313b.a(r9, r10, r11.d(), null, r12);
        return;
    L5:
        if (r1.equals(r0) == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Field \"" + r10 + "\" has been declared differently");
    }

    public void a(com.alibaba.excel.support.asm.f r1) {
        this.f313b = r1;
        this.d = new HashMap();
        this.h = null;
        this.g = null;
        this.i = null;
    }

    public f b() {
        return this.c;
    }

    public g c() {
        if (ai.f(e()) == true) goto L12;
        if (this.h != null) goto L10;
        ag r0 = new ag("CGLIB$STATICHOOK" + j(), "()V");
        this.i = r0;
        this.h = a(8, r0, null);
        g r1 = this.g;
        if (r1 == null) goto L10;
        r1.c(this.i);
    L10:
        return this.h;
    L12:
        throw new IllegalStateException("static hook is invalid for this class");
    }

    public void d() {
    }

    boolean d(String r1) {
        if (this.d.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public int e() {
        return this.c.b();
    }

    a e(String r4) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.d.get(r4), a.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Field " + r4 + " is not declared in " + f().b());
    }

    public com.alibaba.excel.support.asm.aa f() {
        return this.c.getType();
    }

    public com.alibaba.excel.support.asm.aa g() {
        return this.c.a();
    }

    public void h() {
        if (this.h == null) goto L8;
        if (this.g != null) goto L8;
        i();
    L8:
        if (this.g == null) goto L10;
        this.h.w();
        this.h.g();
        this.f.a(177);
        this.f.d(0, 0);
        this.h = null;
        this.g = null;
        this.i = null;
    L10:
        this.f313b.a();
    }

    public g i() {
        return a(8, i.k, null);
    }
}
