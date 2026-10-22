package com.tom_roush.pdfbox.pdmodel.font;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class q implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f16250b;
    private float c;
    private int d;

    q() {
        this.f16250b = Float.NEGATIVE_INFINITY;
        this.c = Float.NEGATIVE_INFINITY;
        this.d = -1;
        com.tom_roush.pdfbox.a.d r0 = new com.tom_roush.pdfbox.a.d();
        this.f16249a = r0;
        r0.a(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.de);
    }

    public q(com.tom_roush.pdfbox.a.d r2) {
        this.f16250b = Float.NEGATIVE_INFINITY;
        this.c = Float.NEGATIVE_INFINITY;
        this.d = -1;
        this.f16249a = r2;
    }

    private void a(int r2, boolean r3) {
        int r0 = j();
        if (r3 == false) goto L5;
        int r4 = r2 | r0;
    L6:
        a(r4);
        return;
    L5:
        r4 = (~r2) & r0;
        goto L6
    }

    private boolean b(int r1) {
        if ((j() & r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void a(float r2) {
        this.f16249a.a(com.tom_roush.pdfbox.a.i.ea, r2);
    }

    public void a(int r3) {
        this.f16249a.a(com.tom_roush.pdfbox.a.i.cY, r3);
        this.d = r3;
    }

    public void a(com.tom_roush.pdfbox.pdmodel.common.h r2) {
        if (r2 == null) goto L4;
        com.tom_roush.pdfbox.a.a r3 = r2.a();
    L5:
        this.f16249a.a(com.tom_roush.pdfbox.a.i.dd, r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void a(String r2) {
        if (r2 == null) goto L4;
        com.tom_roush.pdfbox.a.i r3 = com.tom_roush.pdfbox.a.i.a(r2);
    L5:
        this.f16249a.a(com.tom_roush.pdfbox.a.i.dk, r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void a(boolean r2) {
        a(4, r2);
    }

    public boolean a() {
        return b(1);
    }

    public void b(float r2) {
        this.f16249a.a(com.tom_roush.pdfbox.a.i.F, r2);
    }

    public void b(String r2) {
        if (r2 == null) goto L4;
        com.tom_roush.pdfbox.a.o r0 = new com.tom_roush.pdfbox.a.o(r2);
    L5:
        this.f16249a.a(com.tom_roush.pdfbox.a.i.df, r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public void b(boolean r2) {
        a(32, r2);
    }

    public boolean b() {
        return b(2);
    }

    public void c(float r2) {
        this.f16249a.a(com.tom_roush.pdfbox.a.i.bG, r2);
    }

    public void c(String r2) {
        if (r2 == null) goto L4;
        com.tom_roush.pdfbox.a.o r0 = new com.tom_roush.pdfbox.a.o(r2);
    L5:
        this.f16249a.a(com.tom_roush.pdfbox.a.i.aD, r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public boolean c() {
        return b(4);
    }

    public void d(float r3) {
        this.f16249a.a(com.tom_roush.pdfbox.a.i.at, r3);
        this.c = r3;
    }

    public boolean d() {
        return b(64);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return f();
    }

    public void e(float r3) {
        this.f16249a.a(com.tom_roush.pdfbox.a.i.jh, r3);
        this.f16250b = r3;
    }

    public com.tom_roush.pdfbox.a.d f() {
        return this.f16249a;
    }

    public void f(float r2) {
        this.f16249a.a(com.tom_roush.pdfbox.a.i.hH, r2);
    }

    public String g() {
        com.tom_roush.pdfbox.a.b r2 = this.f16249a.a(com.tom_roush.pdfbox.a.i.dk);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.i.class) == true) goto L7;
        return null;
    L7:
        return ((com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin")).a();
    }

    public void g(float r2) {
        this.f16249a.a(com.tom_roush.pdfbox.a.i.M, r2);
    }

    public String h() {
        com.tom_roush.pdfbox.a.o r2 = (com.tom_roush.pdfbox.a.o) ZeusTransformUtils.preCheckCast(this.f16249a.a(com.tom_roush.pdfbox.a.i.df), com.tom_roush.pdfbox.a.o.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.a();
    }

    public float i() {
        return this.f16249a.b(com.tom_roush.pdfbox.a.i.dm, 0.0f);
    }

    public int j() {
        if (this.d != (-1)) goto L6;
        this.d = this.f16249a.b(com.tom_roush.pdfbox.a.i.cY, 0);
    L6:
        return this.d;
    }

    public com.tom_roush.pdfbox.pdmodel.common.h k() {
        com.tom_roush.pdfbox.a.a r1 = this.f16249a.f(com.tom_roush.pdfbox.a.i.dd);
        if (r1 != null) goto L7;
        return null;
    L7:
        return new com.tom_roush.pdfbox.pdmodel.common.h(r1);
    }

    public float l() {
        return this.f16249a.b(com.tom_roush.pdfbox.a.i.F, 0.0f);
    }

    public float m() {
        return this.f16249a.b(com.tom_roush.pdfbox.a.i.bG, 0.0f);
    }

    public float n() {
        if (this.c != Float.NEGATIVE_INFINITY) goto L6;
        this.c = Math.abs(this.f16249a.b(com.tom_roush.pdfbox.a.i.at, 0.0f));
    L6:
        return this.c;
    }

    public float o() {
        return this.f16249a.b(com.tom_roush.pdfbox.a.i.eZ, 0.0f);
    }

    public com.tom_roush.pdfbox.pdmodel.common.i p() {
        com.tom_roush.pdfbox.a.b r3 = this.f16249a.a(com.tom_roush.pdfbox.a.i.dg);
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.n.class) == true) goto L7;
        return null;
    L7:
        return new com.tom_roush.pdfbox.pdmodel.common.i((com.tom_roush.pdfbox.a.n) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.n.class, "com.obric.memorydata.plugin"));
    }

    public com.tom_roush.pdfbox.pdmodel.common.i q() {
        com.tom_roush.pdfbox.a.b r3 = this.f16249a.a(com.tom_roush.pdfbox.a.i.dh);
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.n.class) == true) goto L7;
        return null;
    L7:
        return new com.tom_roush.pdfbox.pdmodel.common.i((com.tom_roush.pdfbox.a.n) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.n.class, "com.obric.memorydata.plugin"));
    }

    public com.tom_roush.pdfbox.pdmodel.common.i r() {
        com.tom_roush.pdfbox.a.b r3 = this.f16249a.a(com.tom_roush.pdfbox.a.i.di);
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.n.class) == true) goto L7;
        return null;
    L7:
        return new com.tom_roush.pdfbox.pdmodel.common.i((com.tom_roush.pdfbox.a.n) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.n.class, "com.obric.memorydata.plugin"));
    }

    public u s() {
        com.tom_roush.pdfbox.a.d r2 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(this.f16249a.a(com.tom_roush.pdfbox.a.i.hO), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        byte[] r3 = ((com.tom_roush.pdfbox.a.o) ZeusTransformUtils.preCheckCast(r2.a(com.tom_roush.pdfbox.a.i.gc), com.tom_roush.pdfbox.a.o.class, "com.obric.memorydata.plugin")).b();
        if (r3.length >= 12) goto L7;
        return null;
    L7:
        return new u(r3);
    L8:
        return null;
    }
}
