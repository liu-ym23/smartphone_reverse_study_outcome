package com.ctc.wstx.g;

import com.ctc.wstx.d.ae;
import com.ctc.wstx.exc.WstxEOFException;
import com.ctc.wstx.exc.WstxException;
import com.ctc.wstx.exc.WstxIOException;
import com.ctc.wstx.exc.WstxLazyException;
import com.ctc.wstx.exc.WstxParsingException;
import com.ctc.wstx.exc.WstxUnexpectedCharException;
import com.ctc.wstx.exc.WstxValidationException;
import com.ctc.wstx.io.WstxInputLocation;
import com.ctc.wstx.io.u;
import com.ctc.wstx.io.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.xml.stream.XMLStreamException;
import okio.Utf8;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends u implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f3518a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f3519b = null;
    protected final com.ctc.wstx.a.b O;
    protected final boolean P;
    protected boolean Q;
    final com.ctc.wstx.util.k R;
    protected String S;
    protected v T;
    protected final v U;
    protected javax.xml.stream.d V;
    protected int W;
    protected int X;
    protected int Y;
    protected boolean Z;
    protected boolean aa;
    protected char[] ab;
    protected long ac;
    protected int ad;
    protected int ae;
    protected String af;
    protected String ag;
    protected int ah;
    protected Map<String, com.ctc.wstx.e.c> ai;
    protected boolean aj;
    protected com.ctc.wstx.e.a ak;

    static {
        byte[] r0 = new byte[256];
        f3518a = r0;
        r0[95] = 1;
        int r1 = 0;
        int r3 = 0;
    L4:
        if (r3 > 25) goto L6;
        byte[] r4 = f3518a;
        r4[r3 + 65] = 1;
        r4[r3 + 97] = 1;
        r3 = r3 + 1;
        goto L4
    L6:
        int r5 = 192;
    L8:
        if (r5 >= 246) goto L10;
        f3518a[r5] = 1;
        r5 = r5 + 1;
        goto L8
    L10:
        byte[] r6 = f3518a;
        r6[215(0xd7, float:3.01E-43)] = 0;
        r6[247(0xf7, float:3.46E-43)] = 0;
        r6[45] = -1;
        r6[46] = -1;
        r6[183(0xb7, float:2.56E-43)] = -1;
        int r7 = 48;
        int r8 = 48;
    L12:
        if (r8 > 57) goto L14;
        f3518a[r8] = -1;
        r8 = r8 + 1;
        goto L12
    L14:
        f3519b = new byte[128];
    L15:
        if (r1 > 25) goto L17;
        byte[] r9 = f3519b;
        r9[r1 + 65] = 1;
        r9[r1 + 97] = 1;
        r1 = r1 + 1;
    L17:
        byte[] r2 = f3519b;
        if (r7 > 57) goto L20;
        r2[r7] = 1;
        r7 = r7 + 1;
        goto L17
    L20:
        r2[10] = 1;
        r2[13] = 1;
        r2[32] = 1;
        r2[45] = 1;
        r2[39] = 1;
        r2[40] = 1;
        r2[41] = 1;
        r2[43] = 1;
        r2[44] = 1;
        r2[46] = 1;
        r2[47] = 1;
        r2[58] = 1;
        r2[61] = 1;
        r2[63] = 1;
        r2[59] = 1;
        r2[33] = 1;
        r2[42] = 1;
        r2[35] = 1;
        r2[64] = 1;
        r2[36] = 1;
        r2[95] = 1;
        r2[37] = 1;
    }

    public j(v r5, com.ctc.wstx.a.b r6, javax.xml.stream.d r7) {
        javax.xml.stream.d r8 = (javax.xml.stream.d) ZeusTransformUtils.wrapperContextForParams(r7, javax.xml.stream.d.class, "com.obric.memorydata.plugin");
        this.V = null;
        this.ab = null;
        this.ac = 0;
        boolean r1 = true;
        this.ad = 1;
        this.ae = 0;
        this.af = null;
        this.ag = null;
        this.ah = 0;
        this.T = r5;
        this.U = r5;
        this.O = r6;
        this.R = r6.c();
        int r9 = r6.e();
        if ((r9 & 1) == 0) goto L5;
        boolean r3 = true;
    L6:
        this.P = r3;
        if ((r9 & 4) != 0) goto L10;
        r1 = false;
    L10:
        this.Q = r1;
        this.aa = r6.m();
        this.Z = r6.k();
        this.I = null;
        this.K = 0;
        this.f3547J = 0;
        this.V = r8;
        boolean r10 = r6.l();
        this.aj = r10;
        if (r10 == false) goto L13;
        Map<String, com.ctc.wstx.e.c> r11 = new HashMap();
    L14:
        this.ai = r11;
        return;
    L13:
        r11 = Collections.emptyMap();
        goto L14
    L5:
        r3 = false;
        goto L6
    }

    private int a(StringBuffer r10) {
        char r1 = j(" in entity reference");
        if (r10 == null) goto L5;
        r10.append(r1);
    L5:
        int r7 = 0;
        if (r1 == 'x') goto L8;
    L35:
        if (r1 == ';') goto L49;
        if (r1 > '9') goto L41;
        if (r1 < '0') goto L41;
        r7 = (r7 * 10) + (r1 - '0');
        if (r7 <= 1114111) goto L43;
        a();
    L43:
        if (this.f3547J >= this.K) goto L45;
        char[] r2 = this.I;
        int r3 = this.f3547J;
        this.f3547J = r3 + 1;
        r1 = r2[r3];
    L46:
        if (r10 == null) goto L35;
        if (r1 == ';') goto L35;
        r10.append(r1);
        goto L35
    L45:
        r1 = k(" in entity reference");
    L41:
        a(r1, "; expected a decimal number.");
    L49:
        b(r7);
        return r7;
    L8:
        if (this.f3547J >= this.K) goto L10;
        char[] r4 = this.I;
        int r5 = this.f3547J;
        this.f3547J = r5 + 1;
        char r6 = r4[r5];
    L11:
        if (r6 == ';') goto L49;
        if (r10 == null) goto L15;
        r10.append(r6);
    L15:
        int r8 = r7 << 4;
        if (r6 > '9') goto L22;
        if (r6 < '0') goto L22;
        int r9 = r6 - '0';
    L19:
        r8 = r8 + r9;
    L20:
        r7 = r8;
        if (r7 <= 1114111) goto L8;
        a();
    L22:
        if (r6 < 'a') goto L28;
        if (r6 > 'f') goto L28;
        int r11 = r6 - 'a';
    L26:
        r9 = r11 + 10;
    L28:
        if (r6 >= 'A') goto L30;
    L32:
        a(r6, "; expected a hex digit (0-9a-fA-F).");
        goto L20
    L30:
        if (r6 > 'F') goto L32;
        r11 = r6 - 'A';
        goto L26
    L10:
        r6 = k(" in entity reference");
        goto L11
    }

    private com.ctc.wstx.e.a a(String r10) {
        javax.xml.stream.d r5 = this.O.C();
        if (r5 != null) goto L5;
    L21:
        d(r10);
        return null;
    L5:
        if (this.T.a(r10) == false) goto L7;
        c(r10);
    L7:
        v r1 = this.T;
        r1.a(this);
        int r2 = this.ah;
        if (r2 != 0) goto L10;
        r2 = 256;
    L10:
        int r7 = r2;
        v r3 = com.ctc.wstx.io.h.a(r1, r10, null, null, r5, this.O, r7);     // Catch: IOException -> L18
        if (this.aj == false) goto L15;
        return new com.ctc.wstx.e.c(WstxInputLocation.getEmptyLocation(), r3.i(), r3.a(), new char[0], WstxInputLocation.getEmptyLocation());
    L15:
        if (r3 == null) goto L21;
        a(r3, true, r10);
        return null;
    L18:
        e = move-exception;
        throw a(e);
    }

    private void a() {
        a("Illegal character entity: value higher than max allowed (0x{0})", Integer.toHexString(1114111), null);
    }

    private void a(com.ctc.wstx.e.a r10, boolean r11) {
        String r0 = r10.c();
        if (this.T.a(r0) == false) goto L5;
        c(r0);
    L5:
        v r2 = null;
        if (r10.k() == true) goto L8;
        a("Illegal reference to unparsed external entity \"{0}\"", r0, null);
    L8:
        boolean r1 = r10.j();
        if (r1 == false) goto L15;
        if (r11 == true) goto L13;
        a("Encountered a reference to external parsed entity \"{0}\" when expanding attribute value: not legal as per XML 1.0/1.1 #3.1", r0, null);
    L13:
        if (this.O.g() == true) goto L15;
        a("Encountered a reference to external entity \"{0}\", but stream reader has feature \"{1}\" disabled", r0, "javax.xml.stream.isSupportingExternalEntities");
    L15:
        long r5 = this.O.v();
        int r12 = this.Y + 1;
        this.Y = r12;
        a("Maximum entity expansion count", r5, r12);
        v r13 = this.T;
        r13.a(this);
        r2 = r10.a(r13, this.V, this.O, this.ah);     // Catch: IOException -> L18 FileNotFoundException -> L21
    L23:
        a(r2, r1, r0);
        return;
    L21:
        e = move-exception;
        a("(was {0}) {1}", e.getClass().getName(), e.getMessage());
    L18:
        e = move-exception;
        throw a(e);
    }

    private final void b(int r2) {
        if (r2 < 55296) goto L16;
        if (r2 >= 57344) goto L8;
        c(r2);
    L8:
        if (r2 <= 65535) goto L13;
        if (r2 <= 1114111) goto L30;
        a();
        return;
    L30:
        return;
    L13:
        if (r2 < 65534) goto L32;
    L14:
        c(r2);
        return;
    L32:
        return;
    L16:
        if (r2 >= 32) goto L34;
        if (r2 != 0) goto L20;
        e("Invalid character reference: null character not allowed in XML content.");
    L20:
        if (this.H == false) goto L22;
        return;
    L22:
        if (this.aa == false) goto L24;
        return;
    L24:
        if (r2 != 9) goto L26;
        return;
    L26:
        if (r2 != 10) goto L28;
        return;
    L28:
        if (r2 != 13) goto L14;
        return;
    }

    private void b(String r3) {
        a("Illegal name \"{0}\" (PI target, entity/notation name): can not contain a colon (XML Namespaces 1.0#6)", r3, null);
    }

    private void c(int r3) {
        a("Illegal character entity: expansion character (code 0x{0}", Integer.toHexString(r3), null);
    }

    private void c(String r3) {
        a("Illegal entity expansion: entity \"{0}\" expands itself recursively.", r3, null);
    }

    public String A() {
        if (this.f3547J < this.K) goto L5;
        e();
    L5:
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        return i(r0[r1]);
    }

    public String B() {
        StringBuilder r0 = new StringBuilder(100);
    L4:
        if (this.f3547J >= this.K) goto L6;
        char[] r1 = this.I;
        int r2 = this.f3547J;
        this.f3547J = r2 + 1;
        char r3 = r1[r2];
    L11:
        if (r3 == ':') goto L17;
        if (b(r3) == true) goto L17;
        this.f3547J--;
    L16:
        return r0.toString();
    L17:
        r0.append(r3);
        goto L4
    L6:
        int r4 = v();
        if (r4 < 0) goto L16;
        r3 = (char) r4;
        goto L11
    }

    public final char a(String r3, char r4) {
    L3:
        if (r4 > ' ') goto L18;
        if (r4 != '\n') goto L7;
    L13:
        g(r4);
    L15:
        if (this.f3547J < this.K) goto L17;
        o(r3);
    L17:
        char[] r5 = this.I;
        int r0 = this.f3547J;
        this.f3547J = r0 + 1;
        r4 = r5[r0];
        goto L3
    L7:
        if (r4 == '\r') goto L13;
        if (r4 == ' ') goto L15;
        if (r4 == '\t') goto L15;
        f(r4);
        goto L15
    L18:
        return r4;
    }

    public com.ctc.wstx.e.a a(int r5, char[] r6) {
        String r0 = new String(r6);
        com.ctc.wstx.e.c r1 = (com.ctc.wstx.e.c) ZeusTransformUtils.preCheckCast(this.ai.get(r0), com.ctc.wstx.e.c.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        if (r5 > 65535) goto L7;
        String r7 = Character.toString((char) r5);
    L8:
        com.ctc.wstx.e.c r2 = com.ctc.wstx.e.c.a(new String(r6), r7);
        this.ai.put(r0, r2);
        return r2;
    L7:
        StringBuffer r3 = new StringBuffer(2);
        int r8 = r5 - 65536;
        r3.append((char) ((r8 >> 10) + 55296));
        r3.append((char) ((r8 & 1023) + Utf8.LOG_SURROGATE_HEADER));
        r7 = r3.toString();
        goto L8
    }

    public abstract com.ctc.wstx.e.a a(String r1, Object r2);

    public com.ctc.wstx.e.a a(String r1, boolean r2, Object r3) {
        this.S = r1;
        com.ctc.wstx.e.a r4 = a(r1, r3);
        if (r4 != null) goto L10;
        if (this.Q == false) goto L15;
        this.ak = a(r1);
        return null;
    L15:
        return null;
    L10:
        if (this.aj == true) goto L12;
    L13:
        a(r4, r2);
    L14:
        return r4;
    L12:
        if (ZeusTransformUtils.instanceOf(this, ae.class) == false) goto L14;
        goto L13
    }

    public WstxException a(IOException r1) {
        return new WstxIOException(r1);
    }

    public WstxException a(String r1, boolean r2) {
        WstxException r0 = g(r1);
        if (r2 == false) goto L5;
        return r0;
    L5:
        throw r0;
    }

    public final String a(char r8, boolean r9, String r10) {
        char[] r0 = i(-1);
        int r2 = 0;
    L4:
        if (this.f3547J >= this.K) goto L6;
        char[] r3 = this.I;
        int r4 = this.f3547J;
        this.f3547J = r4 + 1;
        char r5 = r3[r4];
    L7:
        if (r5 == r8) goto L8;
        if (r5 != '\n') goto L16;
        y();
    L28:
        if (r2 < r0.length) goto L30;
        r0 = a(r0);
    L30:
        r0[r2] = r5;
        r2 = r2 + 1;
        goto L4
    L16:
        if (r5 != '\r') goto L28;
        if (w() != 10) goto L25;
        this.f3547J++;
        if (r9 == false) goto L22;
    L26:
        r5 = '\n';
        goto L28
    L22:
        if (r2 < r0.length) goto L24;
        r0 = a(r0);
    L24:
        r0[r2] = '\r';
        r2 = r2 + 1;
        goto L26
    L25:
        if (r9 == false) goto L28;
    L8:
        if (r2 != 0) goto L11;
        return "";
    L11:
        return new String(r0, 0, r2);
    L6:
        r5 = j(r10);
        goto L7
    }

    public String a(int r7, int r8) {
        int r0 = this.K - r7;
        char[] r1 = i(r0 + 8);
        if (r0 <= 0) goto L5;
        System.arraycopy(this.I, r7, r1, 0, r0);
    L5:
        int r9 = r1.length;
    L7:
        if (this.f3547J >= this.K) goto L9;
    L11:
        char r3 = this.I[this.f3547J];
        if (r3 < '-') goto L17;
        if (b(r3) == false) goto L17;
        this.f3547J++;
        if (r0 < r9) goto L21;
        char[] r10 = a(r1);
        this.ab = r10;
        r1 = r10;
        r9 = r10.length;
    L21:
        r1[r0] = r3;
        r8 = (r8 * 31) + r3;
        r0 = r0 + 1;
    L17:
        return this.R.a(r1, 0, r0, r8);
    L9:
        if (e() == true) goto L11;
        goto L11
    }

    public XMLStreamException a(String r2, long r3) {
        return new XMLStreamException(r2 + " limit (" + r3 + ") exceeded");
    }

    public void a(int r3, String r4) {
        char r5 = (char) r3;
        throw new WstxUnexpectedCharException("Unexpected character " + d(r5) + r4, p(), r5);
    }

    public abstract void a(v r1);

    public void a(v r10, boolean r11, String r12) {
        this.f3547J = 0;
        this.K = 0;
        this.X = this.W;
        int r0 = this.T.k() + 1;
        a("Maximum entity expansion depth", this.O.u(), r0);
        this.T = r10;
        r10.a(this, this.W, r0);
        if (r11 == false) goto L5;
        this.Z = true;
        return;
    L5:
        this.Z = false;
    }

    public void a(Exception r2) {
        if (ZeusTransformUtils.instanceOf(r2, XMLStreamException.class) == false) goto L5;
        WstxLazyException.throwLazily((XMLStreamException) ZeusTransformUtils.preCheckCast(r2, XMLStreamException.class, "com.obric.memorydata.plugin"));
    L5:
        com.ctc.wstx.util.g.a(r2);
    }

    public void a(String r3, int r4) {
        a(new org.codehaus.stax2.validation.e(p(), r3, r4));
    }

    public void a(String r1, long r2, long r4) {
        if (r4 > r2) goto L6;
        return;
    L6:
        throw a(r1, r2);
    }

    @Override // com.ctc.wstx.g.f
    public void a(String r3, Object r4, Object r5) {
        if (r4 != null) goto L5;
        if (r5 != null) goto L5;
    L7:
        throw g(r3);
    L5:
        r3 = MessageFormat.format(r3, new Object[]{r4, r5});
        goto L7
    }

    @Override // com.ctc.wstx.g.f
    public void a(javax.xml.stream.a r4, String r5, String r6, Object r7, Object r8) {
        javax.xml.stream.a r9 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r4, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        javax.xml.stream.c r0 = this.O.z();
        if (r0 == null) goto L9;
        if (r7 != null) goto L6;
        if (r8 != null) goto L6;
    L7:
        a(r0, r5, r6, r9);
        return;
    L6:
        r6 = MessageFormat.format(r6, new Object[]{r7, r8});
        goto L7
    }

    public void a(javax.xml.stream.c r3, String r4, String r5, javax.xml.stream.a r6) {
        javax.xml.stream.c r7 = (javax.xml.stream.c) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.c.class, "com.obric.memorydata.plugin");
        javax.xml.stream.a r8 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r6, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        r8 = p();
    L5:
        a(r7, new org.codehaus.stax2.validation.e(r8, r5, 2, r4));
    }

    public void a(javax.xml.stream.c r3, org.codehaus.stax2.validation.e r4) {
        javax.xml.stream.c r5 = (javax.xml.stream.c) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.c.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L15;
        javax.xml.stream.a r0 = r4.a();
        if (r0 != null) goto L8;
        r0 = p();
        r4.a(r0);
    L8:
        if (r4.getType() != null) goto L11;
        r4.a(com.ctc.wstx.b.a.g);
    L11:
        if (ZeusTransformUtils.instanceOf(r5, org.codehaus.stax2.b.class) == false) goto L13;
        ((org.codehaus.stax2.b) ZeusTransformUtils.preCheckCast(r5, org.codehaus.stax2.b.class, "com.obric.memorydata.plugin")).a(r4);
        return;
    L13:
        r5.a(r4.b(), r4.getType(), r4, r0);
        return;
    }

    @Override // com.ctc.wstx.g.f
    public void a(org.codehaus.stax2.validation.e r3) {
        if (r3.c() > 2) goto L13;
        javax.xml.stream.c r0 = this.O.z();
        if (r0 == null) goto L8;
        a(r0, r3);
        return;
    L8:
        if (r3.c() >= 2) goto L11;
        return;
    L11:
        throw WstxValidationException.create(r3);
    L13:
        throw WstxValidationException.create(r3);
    }

    public boolean a(int r3) {
        if ((this.K - this.f3547J) < r3) goto L11;
        return true;
    L11:
        return this.T.a(this, r3);
    L8:
        e = move-exception;
        throw a(e);
    }

    public final char[] a(char[] r3) {
        int r2 = r3.length;
        char[] r0 = new char[(r2 >> 1) + r2];
        System.arraycopy(r3, 0, r0, 0, r2);
        return r0;
    }

    public final String b(char r9, String r10) {
        char[] r0 = i(-1);
        int r3 = 0;
        boolean r4 = false;
    L4:
        if (this.f3547J >= this.K) goto L6;
        char[] r5 = this.I;
        int r6 = this.f3547J;
        this.f3547J = r6 + 1;
        char r7 = r5[r6];
    L7:
        if (r7 == r9) goto L8;
        if (r7 == '\n') goto L14;
        if (r7 == '\r') goto L19;
        if (r7 == ' ') goto L15;
        if (r7 < 128) goto L27;
    L28:
        a(r7, " in public identifier");
    L30:
        if (r3 < r0.length) goto L32;
        r0 = a(r0);
    L32:
        if (r4 == false) goto L39;
        if (r3 <= 0) goto L38;
        int r8 = r3 + 1;
        r0[r3] = ' ';
        if (r8 < r0.length) goto L37;
        r0 = a(r0);
    L37:
        r3 = r8;
    L38:
        r4 = false;
    L39:
        r0[r3] = r7;
        r3 = r3 + 1;
        goto L4
    L27:
        if (f3519b[r7] == 1) goto L30;
    L15:
        r4 = true;
        goto L4
    L19:
        if (w() != 10) goto L15;
        this.f3547J++;
        goto L15
    L14:
        y();
        goto L15
    L8:
        if (r3 != 0) goto L11;
        return "";
    L11:
        return new String(r0, 0, r3);
    L6:
        r7 = j(r10);
        goto L7
    }

    public String b(int r8, int r9) {
        int r0 = this.K - r8;
        char[] r1 = i(r0 + 8);
        if (r0 <= 0) goto L5;
        System.arraycopy(this.I, r8, r1, 0, r0);
    L5:
        int r10 = r1.length;
    L7:
        if (this.f3547J >= this.K) goto L9;
    L11:
        char r3 = this.I[this.f3547J];
        if (r3 != ':') goto L17;
        if (this.P == false) goto L23;
        b(new String(r1, 0, r0) + r3 + B());
    L23:
        this.f3547J++;
        if (r0 < r10) goto L26;
        char[] r11 = a(r1);
        this.ab = r11;
        r1 = r11;
        r10 = r11.length;
    L26:
        r1[r0] = r3;
        r9 = (r9 * 31) + r3;
        r0 = r0 + 1;
        goto L7
    L17:
        if (r3 < '-') goto L22;
        if (b(r3) == true) goto L23;
    L22:
        return this.R.a(r1, 0, r0, r9);
    L9:
        if (e() == true) goto L11;
        goto L11
    }

    public void b(IOException r1) {
        throw new WstxIOException(r1);
    }

    public void b(String r3, Object r4, Object r5) {
        f(MessageFormat.format(r3, new Object[]{r4, r5}));
    }

    public WstxException c(int r3, boolean r4) {
        char r5 = (char) r3;
        if (r5 != 0) goto L5;
        WstxException r2 = s();
    L9:
        if (r4 == false) goto L11;
        return r2;
    L11:
        throw r2;
    L5:
        String r0 = "Illegal character (" + d(r5) + ")";
        if (this.H == false) goto L8;
        r0 = r0 + " [note: in XML 1.1, it could be included via entity expansion]";
    L8:
        r2 = new WstxUnexpectedCharException(r0, p(), r5);
        goto L9
    }

    public void c(v r1) {
        throw new IllegalStateException(com.ctc.wstx.b.a.m);
    }

    public abstract void d(String r1);

    public void d(boolean r3) {
        v r0 = this.T;
    L3:
        if (r3 == true) goto L16;
        r0.f();     // Catch: IOException -> L13
    L7:
        if (r0 == this.U) goto L8;
        v r1 = r0.h();
        if (r1 != null) goto L12;
        c(r0);
    L12:
        this.T = r1;
        r0 = r1;
        goto L3
    L8:
        return;
    L16:
        r0.g();     // Catch: IOException -> L13
    L13:
        e = move-exception;
        throw a(e);
    }

    public boolean d() {
        v r0 = this.T;
    L3:
        this.L += (long) this.K;
        a("Maximum document characters", this.O.x(), this.L);
        this.N -= this.K;
    L25:
        e = move-exception;
        throw a(e);
    L5:
        if (r0.c(this) > 0) goto L6;
        r0.f();     // Catch: IOException -> L25
        if (r0 == this.U) goto L10;
        v r1 = r0.h();
        if (r1 != null) goto L16;
        c(r0);
    L16:
        if (this.W == r0.j()) goto L18;
        a(r0);
    L18:
        this.T = r1;
        r1.b(this);
        this.X = r1.j();
        if (this.Z == true) goto L22;
        this.Z = !r1.e();
    L22:
        if (this.f3547J < this.K) goto L23;
        r0 = r1;
        goto L3
    L23:
        return true;
    L10:
        return false;
    L6:
        return true;
    }

    public int e(boolean r13) {
        char[] r0 = this.I;
        int r1 = this.f3547J;
        int r2 = r1 + 1;
        char r3 = r0[r1];
        if (r3 != '#') goto L44;
        int r14 = r2 + 1;
        char r4 = r0[r2];
        int r5 = this.K;
        if (r4 != 'x') goto L30;
        int r6 = 0;
    L7:
        if (r14 >= r5) goto L41;
        int r7 = r14 + 1;
        char r15 = r0[r14];
        if (r15 == ';') goto L10;
        r6 = r6 << 4;
        if (r15 > '9') goto L16;
        if (r15 < '0') goto L16;
        int r10 = r15 - '0';
    L15:
        r6 = r6 + r10;
    L27:
        if (r6 <= 1114111) goto L29;
        a();
    L29:
        r4 = r15;
        r14 = r7;
    L16:
        if (r15 < 'a') goto L22;
        if (r15 > 'f') goto L22;
        int r11 = r15 - 'a';
    L20:
        r10 = r11 + 10;
    L22:
        if (r15 >= 'A') goto L24;
    L26:
        this.f3547J = r7;
        a(r15, "; expected a hex digit (0-9a-fA-F).");
        goto L27
    L24:
        if (r15 > 'F') goto L26;
        r11 = r15 - 'A';
        goto L20
    L10:
        r4 = r15;
        r14 = r7;
    L41:
        if (r4 != ';') goto L100;
        this.f3547J = r14;
        b(r6);
        return r6;
    L100:
        return 0;
    L30:
        r6 = 0;
    L31:
        if (r4 == ';') goto L41;
        if (r4 > '9') goto L37;
        if (r4 < '0') goto L37;
        r6 = (r6 * 10) + (r4 - '0');
        if (r6 <= 1114111) goto L38;
        a();
    L38:
        if (r14 >= r5) goto L41;
        r4 = r0[r14];
        r14 = r14 + 1;
    L37:
        this.f3547J = r14;
        a(r4, "; expected a decimal number.");
        goto L38
    L44:
        if (r13 == false) goto L100;
        if (r3 != 'a') goto L70;
        int r8 = r2 + 1;
        char r9 = r0[r2];
        if (r9 != 'm') goto L57;
        int r16 = r8 + 1;
        if (r0[r8] != 'p') goto L100;
        if (r16 >= this.K) goto L100;
        int r12 = r16 + 1;
        if (r0[r16] != ';') goto L100;
        this.f3547J = r12;
        return 38;
    L57:
        if (r9 != 'p') goto L100;
        int r17 = r8 + 1;
        if (r0[r8] != 'o') goto L100;
        int r18 = this.K;
        if (r17 >= r18) goto L100;
        int r19 = r17 + 1;
        if (r0[r17] != 's') goto L100;
        if (r19 >= r18) goto L100;
        int r110 = r19 + 1;
        if (r0[r19] != ';') goto L100;
        this.f3547J = r110;
        return 39;
    L70:
        if (r3 != 'g') goto L78;
        int r111 = r2 + 1;
        if (r0[r2] != 't') goto L100;
        int r20 = r111 + 1;
        if (r0[r111] != ';') goto L100;
        this.f3547J = r20;
        return 62;
    L78:
        if (r3 != 'l') goto L86;
        int r112 = r2 + 1;
        if (r0[r2] != 't') goto L100;
        int r21 = r112 + 1;
        if (r0[r112] != ';') goto L100;
        this.f3547J = r21;
        return 60;
    L86:
        if (r3 != 'q') goto L100;
        int r22 = r2 + 1;
        if (r0[r2] != 'u') goto L100;
        int r23 = r22 + 1;
        if (r0[r22] != 'o') goto L100;
        int r113 = this.K;
        if (r23 >= r113) goto L100;
        int r24 = r23 + 1;
        if (r0[r23] != 't') goto L100;
        if (r24 >= r113) goto L100;
        int r114 = r24 + 1;
        if (r0[r24] != ';') goto L100;
        this.f3547J = r114;
        return 34;
    }

    @Override // com.ctc.wstx.g.f
    public void e(String r2) {
        a(r2, null, null);
    }

    public boolean e() {
        this.L += (long) this.K;
        this.N -= this.K;
        a("Maximum document characters", this.O.x(), this.L);
        if (this.T.c(this) <= 0) goto L6;
        return true;
    L6:
        return false;
    L8:
        e = move-exception;
        throw a(e);
    }

    public int f(boolean r9) {
        int r0 = this.K - this.f3547J;
        if (r0 >= 6) goto L11;
        this.f3547J--;
        if (a(6) == true) goto L9;
        r0 = u();
        if (r0 >= 3) goto L10;
        h(" in entity reference");
    L10:
        this.f3547J++;
        goto L11
    L9:
        r0 = 6;
    L11:
        char r1 = this.I[this.f3547J];
        if (r1 != '#') goto L15;
        this.f3547J++;
        return a(null);
    L15:
        if (r9 == true) goto L17;
        return 0;
    L17:
        if (r1 != 'a') goto L38;
        char r10 = this.I[this.f3547J + 1];
        if (r10 != 'm') goto L27;
        if (r0 >= 4) goto L22;
        return 0;
    L22:
        if (this.I[this.f3547J + 2] == 'p') goto L24;
        return 0;
    L24:
        if (this.I[this.f3547J + 3] != ';') goto L70;
        this.f3547J += 4;
        return 38;
    L70:
        return 0;
    L27:
        if (r10 != 'p') goto L71;
        if (r0 >= 5) goto L30;
        return 0;
    L30:
        if (this.I[this.f3547J + 2] == 'o') goto L32;
        return 0;
    L32:
        if (this.I[this.f3547J + 3] == 's') goto L34;
        return 0;
    L34:
        if (this.I[this.f3547J + 4] != ';') goto L75;
        this.f3547J += 5;
        return 39;
    L75:
        return 0;
    L71:
        return 0;
    L38:
        if (r1 != 'l') goto L46;
        if (this.I[this.f3547J + 1] == 't') goto L42;
        return 0;
    L42:
        if (this.I[this.f3547J + 2] != ';') goto L77;
        this.f3547J += 3;
        return 60;
    L77:
        return 0;
    L46:
        if (r1 != 'g') goto L54;
        if (this.I[this.f3547J + 1] == 't') goto L50;
        return 0;
    L50:
        if (this.I[this.f3547J + 2] != ';') goto L79;
        this.f3547J += 3;
        return 62;
    L79:
        return 0;
    L54:
        if (r1 != 'q') goto L80;
        if (r0 >= 5) goto L57;
        return 0;
    L57:
        if (this.I[this.f3547J + 1] == 'u') goto L59;
        return 0;
    L59:
        if (this.I[this.f3547J + 2] == 'o') goto L61;
        return 0;
    L61:
        if (this.I[this.f3547J + 3] == 't') goto L63;
        return 0;
    L63:
        if (this.I[this.f3547J + 4] != ';') goto L85;
        this.f3547J += 5;
        return 34;
    L85:
        return 0;
    L80:
        return 0;
    }

    public void f(int r2) {
        c(r2, false);
    }

    @Override // com.ctc.wstx.g.f
    public void f(String r4) {
        a(new org.codehaus.stax2.validation.e(p(), r4, 2));
    }

    public int g(boolean r8) {
        char r0 = k(" in entity reference");
        if (r0 != '#') goto L10;
        StringBuffer r9 = new StringBuffer("#");
        int r1 = a(r9);
        if (this.aj == false) goto L9;
        char[] r2 = new char[r9.length()];
        r9.getChars(0, r9.length(), r2, 0);
        com.ctc.wstx.e.a r10 = a(r1, r2);
    L7:
        this.ak = r10;
        return 0;
    L9:
        return r1;
    L10:
        String r3 = j(r0);
        char r4 = r3.charAt(0);
        if (r4 != 'a') goto L19;
        if (r3.equals("amp") == false) goto L16;
        int r5 = 38;
    L38:
        if (r5 != 0) goto L40;
        com.ctc.wstx.e.a r11 = a(r3, r8, null);
        if (this.aj == false) goto L46;
        this.ak = r11;
    L46:
        return 0;
    L40:
        if (this.aj == false) goto L42;
        char[] r12 = new char[r3.length()];
        r3.getChars(0, r3.length(), r12, 0);
        r10 = a(r5, r12);
        goto L7
    L42:
        return r5;
    L16:
        if (r3.equals("apos") == false) goto L37;
        r5 = 39;
    L37:
        r5 = 0;
        goto L38
    L19:
        if (r4 != 'g') goto L26;
        if (r3.length() != 2) goto L37;
        if (r3.charAt(1) != 't') goto L37;
        r5 = 62;
        goto L38
    L26:
        if (r4 != 'l') goto L33;
        if (r3.length() != 2) goto L37;
        if (r3.charAt(1) != 't') goto L37;
        r5 = 60;
        goto L38
    L33:
        if (r4 != 'q') goto L37;
        if (r3.equals("quot") == false) goto L37;
        r5 = 34;
        goto L38
    }

    public WstxException g(String r2) {
        return new WstxParsingException(r2, p());
    }

    public String g(int r1) {
        return com.ctc.wstx.b.a.a(r1);
    }

    public final boolean g(char r3) {
        if (r3 == '\r') goto L5;
    L7:
        boolean r4 = false;
    L8:
        this.M++;
        this.N = this.f3547J;
        return r4;
    L5:
        if (w() != 10) goto L7;
        this.f3547J++;
        r4 = true;
        goto L8
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public String h(char r7) {
        if (a(r7) == false) goto L5;
    L8:
        int r0 = this.f3547J;
        int r1 = this.K;
        int r2 = r0 - 1;
        char[] r3 = this.I;
        int r8 = r7;
    L9:
        if (r0 >= r1) goto L10;
        char r4 = r3[r0];
        if (r4 < '-') goto L17;
        if (b(r4) == false) goto L17;
        r0 = r0 + 1;
        r8 = (r8 * 31) + r4;
    L17:
        this.f3547J = r0;
        return this.R.a(this.I, r2, r0 - r2, r8);
    L10:
        this.f3547J = r0;
        return a(r2, r8);
    L5:
        if (r7 != ':') goto L7;
        a(r7, " (missing namespace prefix?)");
    L7:
        a(r7, " (expected a name start character)");
        goto L8
    }

    public final void h(int r2) {
        this.M++;
        this.N = r2;
    }

    public void h(String r4) {
        StringBuilder r1 = new StringBuilder().append("Unexpected EOF");
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        throw new WstxEOFException(r1.append(r4).toString(), p());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public String i(char r10) {
        if (a(r10) == true) goto L12;
        if (r10 != ':') goto L9;
        if (this.P == false) goto L12;
        b(B());
        goto L12
    L9:
        if (r10 > ' ') goto L11;
        a(r10, " (missing name?)");
    L11:
        a(r10, " (expected a name start character)");
    L12:
        int r0 = this.f3547J;
        int r2 = this.K;
        int r3 = r0 - 1;
        int r11 = r10;
    L13:
        if (r0 >= r2) goto L14;
        char r4 = this.I[r0];
        if (r4 != ':') goto L22;
        if (this.P == false) goto L28;
        this.f3547J = r0;
        b(new String(this.I, r3, r0 - r3) + B());
    L28:
        r0 = r0 + 1;
        r11 = (r11 * 31) + r4;
        goto L13
    L22:
        if (r4 < '-') goto L26;
        if (b(r4) == true) goto L28;
    L26:
        this.f3547J = r0;
        return this.R.a(this.I, r3, r0 - r3, r11);
    L14:
        this.f3547J = r0;
        return b(r3, r11);
    }

    public void i(String r4) {
        StringBuilder r1 = new StringBuilder().append("Unexpected end of input block");
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        throw new WstxEOFException(r1.append(r4).toString(), p());
    }

    public final char[] i(int r3) {
        char[] r0 = this.ab;
        if (r0 != null) goto L10;
        if (r3 <= 48) goto L7;
        int r4 = r3 + 16;
    L8:
        char[] r1 = new char[r4];
        this.ab = r1;
        return r1;
    L7:
        r4 = 64;
        goto L8
    L10:
        if (r3 < r0.length) goto L17;
        int r2 = r0.length;
        int r5 = r2 + (r2 >> 1);
        if (r3 < r5) goto L14;
        r5 = r3 + 16;
    L14:
        char[] r6 = new char[r5];
        this.ab = r6;
        return r6;
    L17:
        return r0;
    }

    public final char j(String r3) {
        if (this.f3547J < this.K) goto L5;
        n(r3);
    L5:
        char[] r4 = this.I;
        int r0 = this.f3547J;
        this.f3547J = r0 + 1;
        return r4[r0];
    }

    public final String j(char r4) {
        String r5 = i(r4);
        if (this.f3547J >= this.K) goto L5;
    L7:
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r2 = r0[r1];
        if (r2 == ';') goto L10;
        a(r2, "; expected a semi-colon after the reference for entity '" + r5 + "'");
    L10:
        return r5;
    L5:
        if (e() == true) goto L7;
        a("Missing semicolon after reference for entity \"{0}\"", r5, null);
        goto L7
    }

    public final char k(String r3) {
        if (this.f3547J < this.K) goto L5;
        o(r3);
    L5:
        char[] r4 = this.I;
        int r0 = this.f3547J;
        this.f3547J = r0 + 1;
        return r4[r0];
    }

    public int k(char r4) {
        int r0 = 1;
        if (a(r4) == true) goto L7;
        this.f3547J--;
        return 0;
    L7:
        if (this.f3547J >= this.K) goto L9;
        char[] r5 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r6 = r5[r1];
    L11:
        if (r6 == ':') goto L15;
        if (b(r6) == true) goto L15;
        return r0;
    L15:
        r0 = r0 + 1;
        goto L7
    L9:
        r6 = j("; expected an identifier");
        goto L11
    }

    public final char l(String r4) {
        if (this.f3547J < this.K) goto L5;
        n(r4);
    L5:
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r2 = r0[r1];
    L7:
        if (r2 > ' ') goto L22;
        if (r2 != '\n') goto L11;
    L17:
        g(r2);
    L19:
        if (this.f3547J < this.K) goto L21;
        n(r4);
    L21:
        char[] r3 = this.I;
        int r5 = this.f3547J;
        this.f3547J = r5 + 1;
        r2 = r3[r5];
        goto L7
    L11:
        if (r2 == '\r') goto L17;
        if (r2 == ' ') goto L19;
        if (r2 == '\t') goto L19;
        f(r2);
        goto L19
    L22:
        return r2;
    }

    public final char m(String r2) {
        return a(r2, k(r2));
    }

    public final boolean n(String r2) {
        if (d() == true) goto L7;
        h(r2);
        return true;
    L7:
        return true;
    }

    public final boolean o(String r2) {
        if (e() == true) goto L7;
        i(r2);
        return true;
    L7:
        return true;
    }

    public WstxInputLocation p() {
        return this.T.a((this.L + ((long) this.f3547J)) - 1, this.M, this.f3547J - this.N);
    }

    public URL q() {
        return this.T.a();
    }

    public org.codehaus.stax2.c r() {
        return this.T.a(this.ac, this.ad, this.ae + 1);
    }

    public WstxException s() {
        return new WstxUnexpectedCharException("Illegal character (NULL, unicode 0) encountered: not valid in any content", p(), 0);
    }

    public void t() {
        throw s();
    }

    public final int u() {
        return this.K - this.f3547J;
    }

    public final int v() {
        if (this.f3547J >= this.K) goto L5;
    L8:
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        return r0[r1];
    L5:
        if (d() == true) goto L8;
        return -1;
    }

    public final int w() {
        if (this.f3547J < this.K) goto L9;
        if (e() == true) goto L9;
        return -1;
    L9:
        return this.I[this.f3547J];
    }

    public final int x() {
        if (this.f3547J >= this.K) goto L5;
    L7:
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r2 = r0[r1];
    L9:
        if (r2 > ' ') goto L26;
        if (r2 != '\n') goto L13;
    L19:
        g(r2);
    L21:
        if (this.f3547J < this.K) goto L25;
        if (d() == true) goto L25;
        return -1;
    L25:
        char[] r3 = this.I;
        int r4 = this.f3547J;
        this.f3547J = r4 + 1;
        r2 = r3[r4];
        goto L9
    L13:
        if (r2 == '\r') goto L19;
        if (r2 == ' ') goto L21;
        if (r2 == '\t') goto L21;
        f(r2);
        goto L21
    L26:
        return r2;
    L5:
        if (d() == true) goto L7;
        return -1;
    }

    public final void y() {
        this.M++;
        this.N = this.f3547J;
    }

    public com.ctc.wstx.e.a z() {
        int r0 = this.K - this.f3547J;
        if (r0 >= 6) goto L11;
        this.f3547J--;
        if (a(6) == true) goto L9;
        r0 = u();
        if (r0 >= 3) goto L10;
        h(" in entity reference");
    L10:
        this.f3547J++;
        goto L11
    L9:
        r0 = 6;
    L11:
        char r1 = this.I[this.f3547J];
        if (r1 != '#') goto L15;
        return null;
    L15:
        if (r1 != 'a') goto L34;
        char r3 = this.I[this.f3547J + 1];
        if (r3 != 'm') goto L24;
        if (r0 >= 4) goto L20;
    L59:
        this.f3547J++;
        String r2 = j(r1);
        this.S = r2;
        return a(r2, null);
    L20:
        if (this.I[this.f3547J + 2] != 'p') goto L59;
        if (this.I[this.f3547J + 3] != ';') goto L59;
        return null;
    L24:
        if (r3 != 'p') goto L59;
        if (r0 < 5) goto L59;
        if (this.I[this.f3547J + 2] != 'o') goto L59;
        if (this.I[this.f3547J + 3] != 's') goto L59;
        if (this.I[this.f3547J + 4] != ';') goto L59;
        return null;
    L34:
        if (r1 != 'l') goto L41;
        if (this.I[this.f3547J + 1] != 't') goto L59;
        if (this.I[this.f3547J + 2] != ';') goto L59;
        return null;
    L41:
        if (r1 != 'g') goto L48;
        if (this.I[this.f3547J + 1] != 't') goto L59;
        if (this.I[this.f3547J + 2] != ';') goto L59;
        return null;
    L48:
        if (r1 != 'q') goto L59;
        if (r0 < 5) goto L59;
        if (this.I[this.f3547J + 1] != 'u') goto L59;
        if (this.I[this.f3547J + 2] != 'o') goto L59;
        if (this.I[this.f3547J + 3] != 't') goto L59;
        if (this.I[this.f3547J + 4] != ';') goto L59;
        return null;
    }
}
