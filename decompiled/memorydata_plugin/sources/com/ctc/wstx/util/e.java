package com.ctc.wstx.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f3695b;
    private javax.xml.stream.a c;
    private h d;
    private h e;
    private e f;
    private e g;

    e(String r3, javax.xml.stream.a r4, boolean r5, h r6, h r7) {
        javax.xml.stream.a r8 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r4, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        this.f3695b = r3;
        this.c = r8;
        this.f3694a = r5;
        this.d = r6;
        this.e = r7;
    }

    public String a() {
        return this.f3695b;
    }

    public void a(e r3) {
        if (this.f != null) goto L7;
        this.f = r3;
        return;
    L7:
        throw new IllegalStateException("ElementId '" + this + "' already had net undefined set ('" + this.f + "')");
    }

    public void a(javax.xml.stream.a r3) {
        javax.xml.stream.a r4 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        if (this.f3694a == true) goto L7;
        this.f3694a = true;
        this.c = r4;
        return;
    L7:
        throw new IllegalStateException(com.ctc.wstx.b.a.m);
    }

    public boolean a(char[] r6, int r7, int r8) {
        if (this.f3695b.length() == r8) goto L6;
        return false;
    L6:
        if (r6[r7] == this.f3695b.charAt(0)) goto L8;
        return false;
    L8:
        int r9 = r8 + r7;
        int r2 = 1;
    L9:
        r7 = r7 + 1;
        if (r7 >= r9) goto L15;
        if (r6[r7] != this.f3695b.charAt(r2)) goto L13;
        r2 = r2 + 1;
        goto L9
    L13:
        return false;
    L15:
        return true;
    }

    public javax.xml.stream.a b() {
        return this.c;
    }

    public void b(e r1) {
        this.g = r1;
    }

    public h c() {
        return this.d;
    }

    public h d() {
        return this.e;
    }

    public boolean e() {
        return this.f3694a;
    }

    public e f() {
        return this.f;
    }

    public e g() {
        return this.g;
    }

    public String toString() {
        return this.f3695b;
    }
}
