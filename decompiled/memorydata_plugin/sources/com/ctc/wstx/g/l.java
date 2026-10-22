package com.ctc.wstx.g;

import com.ctc.wstx.d.ac;
import com.ctc.wstx.d.n;
import com.ctc.wstx.d.u;
import com.ctc.wstx.d.y;
import com.ctc.wstx.io.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class l extends k {
    org.codehaus.stax2.validation.a G;
    org.codehaus.stax2.validation.g al;
    boolean am;
    protected org.codehaus.stax2.validation.c an;

    private l(com.ctc.wstx.io.k r8, com.ctc.wstx.io.d r9, h r10, com.ctc.wstx.a.b r11, e r12, boolean r13) {
        super(r8, r9, (h) ZeusTransformUtils.wrapperContextForParams(r10, h.class, "com.obric.memorydata.plugin"), r11, r12, r13);
        this.G = null;
        this.al = null;
        this.am = false;
        this.an = null;
    }

    private u a(n r1, u r2) {
        u r0 = this.h.a(r1);
        if (r0 == null) goto L8;
        if (r2 != null) goto L6;
    L7:
        return r0;
    L6:
        if (r0.a(r2) == true) goto L7;
        return null;
    L8:
        return null;
    }

    private u a(String r13, String r14, u r15) {
        boolean r0 = b(65536);
        n r1 = b(r13, r14);     // Catch: IOException -> L26
        if (r0 == false) goto L8;
        u r2 = a(r1, r15);
        if (r2 == null) goto L8;
        return r2;
    L8:
        v r3 = null;
        if (r14 != null) goto L31;
        a("Can not resolve DTD with public id \"{0}\"; missing system identifier", this.l, null);
    L31:
        int r4 = this.ah;     // Catch: IOException -> L16 FileNotFoundException -> L18
        if (r4 != 0) goto L14;
        r4 = 256;
    L14:
        int r11 = r4;
        r3 = com.ctc.wstx.io.h.a(this.T, null, null, r13, r14, this.O.A(), this.O, r11);     // Catch: IOException -> L16 FileNotFoundException -> L18
    L20:
        u r16 = ac.a(r3, this.O, r15, b(32), this.ah);
        if (r0 == true) goto L23;
    L25:
        return r16;
    L23:
        if (r16.a() == false) goto L25;
        this.h.a(r1, r16);
        goto L25
    L18:
        e = move-exception;
        a("(was {0}) {1}", e.getClass().getName(), e.getMessage());
    L16:
        e = move-exception;
        b(e);
    L26:
        e = move-exception;
        throw a(e);
    }

    public static l a(com.ctc.wstx.io.d r7, h r8, com.ctc.wstx.a.b r9, com.ctc.wstx.io.k r10, boolean r11) {
        return new l(r10, r7, (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin"), r9, a(r9), r11);
    }

    private URI a(String r4) {
        if (this.T != null) goto L5;
        URL r3 = null;
    L6:
        if (r3 == null) goto L8;
        URL r5 = com.ctc.wstx.util.n.a(r4, r3);
        return new URI(r5.toExternalForm());
    L12:
        e = move-exception;
        throw new IOException("Failed to construct URI for external subset, URL = " + r5.toExternalForm() + ": " + e.getMessage());
    L8:
        return com.ctc.wstx.util.n.b(r4);
    L5:
        r3 = this.T.a();
        goto L6
    }

    @Override // com.ctc.wstx.g.j, com.ctc.wstx.g.f
    public void a(org.codehaus.stax2.validation.e r2) {
        org.codehaus.stax2.validation.c r0 = this.an;
        if (r0 == null) goto L5;
        r0.a(r2);
        return;
    L5:
        super.a(r2);
    }

    public n b(String r5, String r6) {
        int r0 = this.c & 2621473;
        if (r6 != null) goto L5;
    L8:
        URI r7 = null;
    L10:
        if ((this.c & 131072) == 0) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L19;
        if (r5 == null) goto L19;
        if (r5.length() <= 0) goto L19;
        return n.a(r5, r7, r0, this.H);
    L19:
        if (r7 != null) goto L22;
        return null;
    L22:
        return n.a(r7, r0, this.H);
    L12:
        r2 = false;
        goto L13
    L5:
        if (r6.length() == 0) goto L8;
        r7 = a(r6);
        goto L10
    }

    @Override // com.ctc.wstx.g.c
    public void b(boolean r9) {
        if (b(16) == true) goto L6;
        super.b(r9);
        return;
    L6:
        char r0 = j(" in DOCTYPE declaration");
        y r4 = null;
        if (r0 != '[') goto L18;
        if (r9 == false) goto L52;
        ((com.ctc.wstx.io.d) ZeusTransformUtils.preCheckCast(this.T, com.ctc.wstx.io.d.class, "com.obric.memorydata.plugin")).a(this.n, this.f3547J, this.Z);
    L52:
        u r1 = ac.a(this, this.T, this.O, b(32), this.ah);     // Catch: Throwable -> L14
        if (r9 == false) goto L13;
        ((com.ctc.wstx.io.d) ZeusTransformUtils.preCheckCast(this.T, com.ctc.wstx.io.d.class, "com.obric.memorydata.plugin")).a(this.f3547J - 1);
    L13:
        r0 = l(" in internal DTD subset");
        u r10 = r1;
    L20:
        if (r0 == '>') goto L22;
        a(r0, "; expected '>' to finish DOCTYPE declaration.");
    L22:
        org.codehaus.stax2.validation.a r2 = this.O.I();
        this.G = r2;
        if (r2 == null) goto L26;
    L38:
        org.codehaus.stax2.validation.a r11 = this.G;
        if (r11 != null) goto L42;
        this.C = null;
        return;
    L42:
        if (ZeusTransformUtils.instanceOf(r11, u.class) == false) goto L44;
        this.C = ((u) ZeusTransformUtils.preCheckCast(this.G, u.class, "com.obric.memorydata.plugin")).b();
    L45:
        org.codehaus.stax2.validation.g r12 = this.G.a(this.o);
        this.al = r12;
        this.am = true;
        if (ZeusTransformUtils.instanceOf(r12, y.class) == false) goto L50;
        y r13 = (y) ZeusTransformUtils.preCheckCast(this.al, y.class, "com.obric.memorydata.plugin");
        r13.a(true);
        if (r13.h() == false) goto L50;
        r4 = r13;
    L50:
        this.o.a(this.al, r4);
        return;
    L44:
        a(this.O.z(), com.ctc.wstx.b.a.e, "Value to set for property 'org.codehaus.stax2.propDtdOverride' not a native Woodstox DTD implementation (but " + this.G.getClass() + "): can not access full entity or notation information", null);
        goto L45
    L26:
        if (this.l == null) goto L28;
    L31:
        u r3 = a(this.l, this.m, r10);
    L32:
        if (r10 != null) goto L34;
        this.G = r3;
        goto L38
    L34:
        if (r3 == null) goto L37;
        r10 = r10.a(this, r3);
    L37:
        this.G = r10;
        goto L38
    L28:
        if (this.m != null) goto L31;
        r3 = null;
    L14:
        th = move-exception;
        if (r9 == false) goto L17;
        ((com.ctc.wstx.io.d) ZeusTransformUtils.preCheckCast(this.T, com.ctc.wstx.io.d.class, "com.obric.memorydata.plugin")).a(this.f3547J - 1);
    L17:
        throw th;
    L18:
        r10 = null;
        goto L20
    }

    @Override // com.ctc.wstx.g.c
    public void c() {
        if (b(32) == true) goto L5;
        return;
    L5:
        if (this.am == true) goto L9;
        a(null, com.ctc.wstx.b.a.e, com.ctc.wstx.b.a.j, null, null);
        return;
    }

    @Override // com.ctc.wstx.g.c
    public void e(int r3) {
        int r0 = this.D;
        if (r0 != 0) goto L5;
        String r1 = com.ctc.wstx.b.a.W;
    L16:
        b(r1, this.o.l(), com.ctc.wstx.b.a.a(r3));
        return;
    L5:
        if (r0 != 1) goto L7;
    L14:
        b(com.ctc.wstx.b.a.X, this.o.l(), null);
        return;
    L7:
        if (r0 == 2) goto L14;
        if (r0 != 3) goto L11;
    L13:
        r1 = com.ctc.wstx.b.a.Y;
        goto L16
    L11:
        if (r0 == 4) goto L13;
        e("Internal error: trying to report invalid content for " + r3);
    }
}
