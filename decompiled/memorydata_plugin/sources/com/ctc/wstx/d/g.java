package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String[] f3491a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.ctc.wstx.util.h f3492b;
    protected final int c;
    protected final aa d;
    protected final boolean e;
    protected final boolean f;

    static {
        f3491a = new String[]{"CDATA", "ENUMERATED", "ID", "IDREF", "IDREFS", "ENTITY", "ENTITIES", "NOTATION", "NMTOKEN", "NMTOKENS"};
    }

    public g(com.ctc.wstx.util.h r1, aa r2, int r3, boolean r4, boolean r5) {
        this.f3492b = r1;
        this.d = r2;
        this.c = r3;
        this.e = r4;
        this.f = r5;
    }

    public abstract g a(int r1);

    public final com.ctc.wstx.util.h a() {
        return this.f3492b;
    }

    public String a(y r3, char r4, String r5) {
        a(r3, "Invalid character " + com.ctc.wstx.io.u.d(r4) + ": " + r5);
        return null;
    }

    public String a(y r3, String r4) {
        r3.a("Attribute '" + this.f3492b + "': " + r4);
        return null;
    }

    public String a(y r7, String r8, boolean r9) {
        int r4 = r8.length();
        char[] r2 = r7.a(r8.length());
        if (r4 <= 0) goto L6;
        r8.getChars(0, r4, r2, 0);
    L6:
        return a(r7, r2, 0, r4, r9);
    }

    public String a(y r1, char[] r2, int r3, int r4) {
        return com.ctc.wstx.util.i.a(r2, r3, r4);
    }

    public abstract String a(y r1, char[] r2, int r3, int r4, boolean r5);

    public String a(com.ctc.wstx.g.f r3, String r4) {
        ((com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin")).f("Attribute definition '" + this.f3492b + "': " + r4);
        return null;
    }

    public final String a(org.codehaus.stax2.validation.b r3, org.codehaus.stax2.validation.g r4) {
        org.codehaus.stax2.validation.b r5 = (org.codehaus.stax2.validation.b) ZeusTransformUtils.wrapperContextForParams(r3, org.codehaus.stax2.validation.b.class, "com.obric.memorydata.plugin");
        String r0 = this.d.f();
        if (r0 != null) goto L6;
        this.d.a(r5, r4);
        return this.d.e();
    L6:
        return r0;
    }

    public String a(char[] r1, int r2, int r3, boolean r4, com.ctc.wstx.util.o r5) {
        if (r4 == true) goto L4;
    L14:
        if (r2 < r3) goto L18;
        return null;
    L18:
        return r5.a(r1, r2, r3);
    L4:
        if (r2 >= r3) goto L8;
        if (r1[r2] > ' ') goto L8;
        r2 = r2 + 1;
    L8:
        r3 = r3 - 1;
        if (r3 <= r2) goto L13;
        if (r1[r3] <= ' ') goto L8;
    L13:
        r3 = r3 + 1;
        goto L14
    }

    public void a(com.ctc.wstx.g.f r2, String r3, com.ctc.wstx.e.a r4) {
        com.ctc.wstx.g.f r1 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r2, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L7;
        StringBuilder r5 = new StringBuilder().append("Referenced entity '").append(r3);
        String r6 = "' not defined";
    L5:
        r1.f(r5.append(r6).toString());
        return;
    L7:
        if (r4.k() == false) goto L10;
        r5 = new StringBuilder().append("Referenced entity '").append(r3);
        r6 = "' is not an unparsed entity";
        goto L5
    }

    public abstract void a(com.ctc.wstx.g.f r1, boolean r2);

    public final int b() {
        return this.c;
    }

    public com.ctc.wstx.e.a b(y r3, char[] r4, int r5, int r6) {
        Map<String, com.ctc.wstx.e.a> r0 = r3.g();
        String r1 = new String(r4, r5, r6);
        com.ctc.wstx.e.a r7 = (com.ctc.wstx.e.a) ZeusTransformUtils.preCheckCast(r0.get(r1), com.ctc.wstx.e.a.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L7;
        StringBuilder r8 = new StringBuilder().append("Referenced entity '").append(r1);
        String r9 = "' not defined";
    L5:
        a(r3, r8.append(r9).toString());
    L9:
        return r7;
    L7:
        if (r7.k() == false) goto L9;
        r8 = new StringBuilder().append("Referenced entity '").append(r1);
        r9 = "' is not an unparsed entity";
        goto L5
    }

    public String b(com.ctc.wstx.g.f r6, boolean r7) {
        com.ctc.wstx.g.f r8 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r6, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        String r0 = this.d.e();
        String r1 = r0.trim();
        if (r1.length() != 0) goto L5;
        a(r8, "Invalid default value '" + r1 + "'; empty String is not a valid name");
    L5:
        int r2 = com.ctc.wstx.io.u.a(r1, this.e, this.f);
        if (r2 < 0) goto L11;
        if (r2 != 0) goto L9;
        StringBuilder r3 = new StringBuilder().append("Invalid default value '").append(r1).append("'; character ").append(com.ctc.wstx.io.u.d(r1.charAt(0)));
        String r4 = ") not valid first character of a name";
    L10:
        a(r8, r3.append(r4).toString());
        goto L11
    L9:
        r3 = new StringBuilder().append("Invalid default value '").append(r1).append("'; character #").append(r2).append(" (").append(com.ctc.wstx.io.u.d(r1.charAt(r2)));
        r4 = ") not valid name character";
    L11:
        if (r7 == true) goto L13;
        return r0;
    L13:
        return r1;
    }

    public String c(com.ctc.wstx.g.f r12, boolean r13) {
        com.ctc.wstx.g.f r14 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r12, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        String r0 = this.d.e().trim();
        int r1 = r0.length();
        int r2 = 0;
        StringBuilder r4 = null;
        int r3 = 0;
    L4:
        if (r2 >= r1) goto L30;
    L5:
        char r6 = r0.charAt(r2);
        if (com.ctc.wstx.io.u.c(r6) == false) goto L7;
        r2 = r2 + 1;
        if (r2 < r1) goto L5;
    L7:
        int r7 = r2 + 1;
    L8:
        if (r7 >= r1) goto L13;
        if (com.ctc.wstx.io.u.c(r0.charAt(r7)) == true) goto L13;
        r7 = r7 + 1;
    L13:
        String r8 = r0.substring(r2, r7);
        int r9 = com.ctc.wstx.io.u.a(r8, this.e, this.f);
        if (r9 >= 0) goto L16;
    L20:
        r3 = r3 + 1;
        if (r13 == false) goto L27;
        if (r4 != null) goto L25;
        r4 = new StringBuilder((r7 - r2) + 32);
    L26:
        r4.append(r8);
        goto L27
    L25:
        r4.append(' ');
    L27:
        r2 = r7 + 1;
        goto L4
    L16:
        if (r9 != 0) goto L18;
        StringBuilder r5 = new StringBuilder().append("Invalid default value '").append(r0).append("'; character ").append(com.ctc.wstx.io.u.d(r0.charAt(r2)));
        String r10 = ") not valid first character of a name token";
    L19:
        a(r14, r5.append(r10).toString());
        goto L20
    L18:
        r5 = new StringBuilder().append("Invalid default value '").append(r0).append("'; character ").append(com.ctc.wstx.io.u.d(r6));
        r10 = ") not a valid name character";
    L30:
        if (r3 == 0) goto L32;
        if (r4 != null) goto L35;
        return r0;
    L35:
        return r4.toString();
    L32:
        return a(r14, "Invalid default value '" + r0 + "'; empty String is not a valid name value");
    }

    public final boolean c() {
        if (h() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public String d(com.ctc.wstx.g.f r6, boolean r7) {
        com.ctc.wstx.g.f r8 = (com.ctc.wstx.g.f) ZeusTransformUtils.wrapperContextForParams(r6, com.ctc.wstx.g.f.class, "com.obric.memorydata.plugin");
        String r0 = this.d.e();
        String r1 = r0.trim();
        if (r1.length() != 0) goto L5;
        a(r8, "Invalid default value '" + r1 + "'; empty String is not a valid NMTOKEN");
    L5:
        int r2 = com.ctc.wstx.io.u.b(r1, this.e, this.f);
        if (r2 < 0) goto L8;
        a(r8, "Invalid default value '" + r1 + "'; character #" + r2 + " (" + com.ctc.wstx.io.u.d(r1.charAt(r2)) + ") not valid NMTOKEN character");
    L8:
        if (r7 == true) goto L10;
        return r0;
    L10:
        return r1;
    }

    public final boolean d() {
        return this.d.h();
    }

    public final boolean e() {
        return this.d.g();
    }

    public final boolean f() {
        return this.d.j();
    }

    public final boolean g() {
        return this.d.i();
    }

    public int h() {
        return 0;
    }

    public void i() {
        String r0 = this.d.e();
        if (r0.length() <= 0) goto L8;
        char[] r1 = r0.toCharArray();
        String r2 = com.ctc.wstx.util.i.a(r1, 0, r1.length);
        if (r2 == null) goto L9;
        this.d.a(r2);
        return;
    L9:
        return;
    }

    public final String toString() {
        return this.f3492b.toString();
    }
}
