package com.ctc.wstx.g;

import com.ctc.wstx.d.ae;
import com.ctc.wstx.exc.WstxException;
import com.ctc.wstx.io.v;
import com.ctc.wstx.util.m;
import com.tencent.wcdb.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import okio.Utf8;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends j implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final String f3512a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final String f3513b = null;
    protected int A;
    protected XMLStreamException B;
    protected Map<String, com.ctc.wstx.e.a> C;
    protected int D;
    protected boolean E;
    protected final int c;
    protected final boolean d;
    protected final boolean e;
    protected final boolean f;
    protected final int g;
    protected final h h;
    protected int i;
    protected String j;
    protected String k;
    protected String l;
    protected String m;
    protected final com.ctc.wstx.util.l n;
    protected final e o;
    protected final b p;
    protected boolean q;
    protected int r;
    protected final int s;
    protected int t;
    protected boolean u;
    protected int v;
    protected int w;
    protected int x;
    protected int y;
    protected boolean z;

    static {
        f3512a = com.ctc.wstx.util.d.b();
        f3513b = com.ctc.wstx.util.d.c();
    }

    public c(com.ctc.wstx.io.k r6, com.ctc.wstx.io.d r7, h r8, com.ctc.wstx.a.b r9, e r10, boolean r11) {
        h r12 = (h) ZeusTransformUtils.wrapperContextForParams(r8, h.class, "com.obric.memorydata.plugin");
        super(r7, r9, r9.B());
        this.i = 0;
        this.q = false;
        this.r = 4;
        this.u = false;
        this.w = 7;
        this.x = 7;
        this.z = false;
        this.B = null;
        this.C = null;
        this.D = 4;
        this.h = r12;
        this.n = com.ctc.wstx.util.l.a(r9);
        int r13 = r9.e();
        this.c = r13;
        if ((r13 & 2) == 0) goto L5;
        boolean r2 = true;
    L6:
        this.d = r2;
        if ((r13 & 512) != 0) goto L9;
        boolean r4 = true;
    L10:
        this.e = r4;
        this.H = r9.G();
        if (this.Z == false) goto L13;
        int r5 = 16;
    L14:
        this.A = r5;
        if (r11 == false) goto L17;
    L19:
        boolean r14 = false;
    L20:
        this.f = r14;
        int r15 = Integer.MAX_VALUE;
        if (r2 == false) goto L24;
        this.s = 4;
    L23:
        this.g = r15;
        this.ah = r6.a();
        this.af = r6.h();
        this.ag = r6.d();
        String r16 = r6.c();
        if (r16 != null) goto L34;
        this.i = 0;
    L37:
        this.v = this.O.F() ? 1 : 0;
        this.o = r10;
        this.p = r10.b();
        r7.a(this, this.W, 0);
        r10.a(this);
        this.E = this.O.a();
        return;
    L34:
        if ("yes".equals(r16) == false) goto L36;
        this.i = 1;
        goto L37
    L36:
        this.i = 2;
        goto L37
    L24:
        this.s = 2;
        if (r11 == true) goto L27;
    L29:
        r15 = r9.o();
        goto L23
    L27:
        if (r9.J() == true) goto L29;
    L17:
        if ((r13 & 262144) == 0) goto L19;
        r14 = true;
        goto L20
    L13:
        r5 = 0;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private int C() {
        char r1 = k(" in main document content");
        if (r1 != '[') goto L11;
        b();
        if (this.f3547J >= this.K) goto L7;
        char[] r0 = this.I;
        int r2 = this.f3547J;
        this.f3547J = r2 + 1;
        char r3 = r0[r2];
    L8:
        p(r3);
        return 12;
    L7:
        r3 = k(" in CDATA section");
        goto L8
    L11:
        if (r1 == '-') goto L13;
    L16:
        e("Unrecognized XML directive; expected CDATA or comment ('<![CDATA[' or '<!--').");
        return 0;
    L13:
        if (k(" in main document content") != '-') goto L16;
        this.r = 1;
        return 5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [com.ctc.wstx.g.c] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int] */
    /* JADX WARN: Type inference failed for: r5v10, types: [int] */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v4, types: [char, int] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [int] */
    /* JADX WARN: Type inference failed for: r5v7, types: [int] */
    /* JADX WARN: Type inference failed for: r5v8, types: [int] */
    private int D() {
        char r5 = 0;
        r5 = 0;
        r5 = 0;
        switch(this.w) {
            case 3: goto L35;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L16;
            case 7: goto L14;
            case 8: goto L14;
            case 9: goto L14;
            case 10: goto L5;
            case 11: goto L12;
            case 12: goto L7;
            case 13: goto L5;
            case 14: goto L14;
            case 15: goto L14;
            default: goto L5;
        };
    L12:
        b(false);
    L47:
        this.ad = this.M;
        long r0 = this.L + ((long) this.f3547J);
        if (r5 >= 1) goto L54;
        this.ac = r0;
        this.ae = this.f3547J - this.N;
        if (r5 >= 0) goto L53;
        return r5;
    L53:
        return v();
    L54:
        this.ac = r0 - 1;
        this.ae = (this.f3547J - this.N) - 1;
        return r5;
    L30:
        a(" in comment", '-', true);
        goto L47
    L31:
        r5 = k(v());
        ?? r6 = r5;
        if (this.d == false) goto L47;
    L33:
        r5 = j(r6);
        goto L47
    L5:
        throw new IllegalStateException("Internal error: unexpected token " + g(this.w));
    L7:
        if (this.r > 2) goto L9;
        a(" in CDATA section", ']', false);
    L9:
        r5 = v();
        r6 = r5;
        if (this.d == false) goto L47;
    L14:
        throw new IllegalStateException("skipToken() called when current token is " + g(this.w));
    L16:
        if (this.f3547J < this.K) goto L17;
        if (d() == true) goto L16;
        r5 = -1;
        goto L47
    L17:
        char[] r1 = this.I;
        int r7 = this.f3547J;
        this.f3547J = r7 + 1;
        r5 = r1[r7];
        if (r5 > 32) goto L47;
        if (r5 == 10) goto L26;
        if (r5 == 13) goto L26;
        if (r5 == 32) goto L16;
        if (r5 == 9) goto L16;
        f(r5);
    L26:
        g(r5);
    L35:
        if (this.f3547J >= this.K) goto L37;
        char[] r2 = this.I;
        int r8 = this.f3547J;
        this.f3547J = r8 + 1;
        char r3 = r2[r8];
    L39:
        if (r3 == '?') goto L41;
    L56:
        if (r3 >= ' ') goto L35;
        if (r3 == '\n') goto L62;
        if (r3 == '\r') goto L62;
        if (r3 == '\t') goto L35;
        f(r3);
    L62:
        g(r3);
    L41:
        if (this.f3547J >= this.K) goto L43;
        char[] r4 = this.I;
        int r9 = this.f3547J;
        this.f3547J = r9 + 1;
        r3 = r4[r9];
    L44:
        if (r3 == '?') goto L41;
        if (r3 != '>') goto L56;
    L43:
        r3 = k(" in processing instruction");
        goto L44
    L37:
        r3 = k(" in processing instruction");
        goto L39
    }

    private void E() {
        char[] r0 = this.I;
        int r1 = this.K;
        int r2 = this.f3547J;
        int r3 = r2;
    L3:
        if (r3 >= r1) goto L36;
        int r4 = r3 + 1;
        char r5 = r0[r3];
        if (r5 > '-') goto L30;
        if (r5 < ' ') goto L10;
        if (r5 != '-') goto L30;
        int r6 = r4 + 1;
        if (r6 >= r1) goto L27;
        if (r0[r4] != '-') goto L30;
        if (r0[r6] == '>') goto L34;
        e("String '--' not allowed in comment (missing '>'?)");
    L34:
        this.n.a(r0, r2, (r4 - r2) - 1);
        this.f3547J = r4 + 2;
        return;
    L27:
        r3 = r4 - 1;
        goto L36
    L10:
        if (r5 != '\n') goto L13;
    L20:
        h(r4);
        goto L30
    L13:
        if (r5 != '\r') goto L22;
        if (this.Z == true) goto L27;
        if (r4 >= r1) goto L27;
        if (r0[r4] != '\n') goto L20;
        r4 = r4 + 1;
        goto L20
    L22:
        if (r5 == '\t') goto L30;
        f(r5);
    L30:
        r3 = r4;
    L36:
        this.f3547J = r3;
        this.n.b(r0, r2, r3 - r2);
        a(this.n);
    }

    private final int F() {
        String r0 = A();
        this.S = r0;
        if (r0.length() != 0) goto L6;
        e(com.ctc.wstx.b.a.A);
    L6:
        if (r0.equalsIgnoreCase("xml") == false) goto L16;
        if (this.O.E() == true) goto L10;
        a(com.ctc.wstx.b.a.B, r0, null);
    L10:
        char r1 = k(" in xml declaration");
        if (c(r1) == true) goto L14;
        a(r1, "expected a space in xml declaration after 'xml'");
    L14:
        return c(7);
    L16:
        if (this.f3547J >= this.K) goto L18;
        char[] r2 = this.I;
        int r3 = this.f3547J;
        this.f3547J = r3 + 1;
        char r4 = r2[r3];
    L20:
        if (c(r4) == false) goto L22;
        this.r = 1;
        f(r4);
        return 3;
    L22:
        this.r = 4;
        this.n.b();
        if (r4 == '?') goto L25;
    L26:
        a(r4, com.ctc.wstx.b.a.C);
        return 3;
    L25:
        if (k(" in processing instruction") != '>') goto L26;
        return 3;
    L18:
        r4 = k(" in processing instruction");
        goto L20
    }

    private void G() {
        int r0 = this.f3547J;
        char[] r1 = this.I;
        int r2 = this.K;
        int r3 = r0;
    L3:
        if (r3 >= r2) goto L33;
        int r4 = r3 + 1;
        char r5 = r1[r3];
        if (r5 < ' ') goto L7;
        if (r5 != '?') goto L32;
    L23:
        if (r4 >= r2) goto L24;
        int r6 = r4 + 1;
        char r7 = r1[r4];
        if (r7 == '>') goto L27;
        if (r7 != '?') goto L30;
        r4 = r6;
        goto L23
    L30:
        r3 = r6 - 1;
        goto L3
    L27:
        this.f3547J = r6;
        this.n.a(r1, r0, (r6 - r0) - 2);
        return;
    L24:
        r3 = r4 - 1;
    L32:
        r3 = r4;
        goto L3
    L7:
        if (r5 != '\n') goto L10;
    L17:
        h(r4);
        goto L32
    L10:
        if (r5 != '\r') goto L19;
        if (r4 >= r2) goto L24;
        if (this.Z == true) goto L24;
        if (r1[r4] != '\n') goto L17;
        r4 = r4 + 1;
        goto L17
    L19:
        if (r5 == '\t') goto L32;
        f(r5);
    L33:
        this.f3547J = r3;
        this.n.b(r1, r0, r3 - r0);
        b(this.n);
    }

    private final int a(char r10, int r11) {
        int r0 = this.K;
        char[] r1 = this.I;
        int r2 = r11 - 1;
        int r3 = r11 + 1;
        char r12 = r1[r11];
        int r5 = 32;
        if (r12 != ' ') goto L5;
    L9:
        if (r12 == ' ') goto L12;
        r5 = 8;
    L12:
        int r6 = r5 + r3;
        if (r6 <= r0) goto L15;
        r6 = r0;
    L15:
        if (r3 >= r6) goto L8;
        int r8 = r3 + 1;
        char r4 = r1[r3];
        if (r4 != r12) goto L19;
        r3 = r8;
        goto L15
    L19:
        if (r4 != '<') goto L29;
        r3 = r8;
    L21:
        if (r3 >= r0) goto L8;
        if (r1[r3] == '!') goto L8;
        int r7 = r3 - 1;
        this.f3547J = r7;
        this.n.a((r7 - r2) - 1, r12);
        int r13 = this.A;
        if (r13 >= 40) goto L27;
        this.A = r13 + 16;
    L27:
        this.y = 1;
        return -1;
    L29:
        int r9 = r8 - 1;
    L30:
        this.A--;
        if (r10 != '\r') goto L33;
        r1[r2] = '\n';
    L33:
        return r9;
    L8:
        r9 = r3 - 1;
        goto L30
    L5:
        if (r12 == '\t') goto L9;
        if (r12 == '<') goto L21;
        goto L8
    }

    private final int a(char[] r1, int r2, int r3) {
        return Math.min(r1.length, Math.max(r3, r2 + r3));
    }

    public static e a(com.ctc.wstx.a.b r2) {
        return new e(r2, r2.f());
    }

    private final void a(char r14, m r15) {
        char[] r0 = r15.c();
        int r1 = r15.d();
        int r2 = this.O.q();
        int r3 = a(r0, r1, r2);
        v r9 = this.T;
        char[] r5 = r0;
        int r4 = r1;
    L4:
        if (this.f3547J >= this.K) goto L6;
        char[] r6 = this.I;
        int r7 = this.f3547J;
        this.f3547J = r7 + 1;
        char r8 = r6[r7];
    L8:
        if (r8 > '\'') goto L48;
        if (r8 < ' ') goto L12;
        if (r8 == r14) goto L27;
        if (r8 != '&') goto L50;
        if (u() < 3) goto L37;
        int r10 = e(true);
        if (r10 == 0) goto L37;
    L41:
        if (r10 > 65535) goto L43;
        r8 = (char) r10;
        goto L50
    L43:
        int r11 = r10 - 65536;
        if (r4 < r3) goto L46;
        r5 = a(r15, r5, r4, r4 - r1, r2);
        r3 = a(r5, r1, r2);
    L46:
        r5[r4] = (char) ((r11 >> 10) + 55296);
        r8 = (char) ((r11 & 1023) + Utf8.LOG_SURROGATE_HEADER);
        r4 = r4 + 1;
    L37:
        r10 = g(false);
        if (r10 != 0) goto L41;
    L50:
        char r12 = r8;
    L51:
        if (r4 < r3) goto L53;
        char[] r13 = a(r15, r5, r4, r4 - r1, r2);
        r5 = r13;
        r3 = a(r13, r1, r2);
    L53:
        r5[r4] = r12;
        r4 = r4 + 1;
        goto L4
    L27:
        if (this.T != r9) goto L50;
        r15.a(r4);
        return;
    L12:
        if (r8 != '\n') goto L15;
    L13:
        y();
    L24:
        r12 = ' ';
        goto L51
    L15:
        if (r8 != '\r') goto L22;
        if (this.Z == false) goto L13;
        if (j(" in attribute value") == '\n') goto L13;
        this.f3547J--;
        goto L13
    L22:
        if (r8 == '\t') goto L24;
        f(r8);
        goto L24
    L48:
        if (r8 != '<') goto L50;
        a(r8, " in attribute value");
        goto L50
    L6:
        r8 = j(" in attribute value");
        goto L8
    }

    private void a(com.ctc.wstx.util.l r13) {
        char[] r0 = r13.j();
        int r14 = r13.k();
        int r1 = r0.length;
    L4:
        if (this.f3547J >= this.K) goto L6;
        char[] r2 = this.I;
        int r3 = this.f3547J;
        this.f3547J = r3 + 1;
        char r4 = r2[r3];
    L7:
        int r5 = 0;
        if (r4 >= ' ') goto L26;
        if (r4 != '\n') goto L12;
        y();
    L35:
        if (r14 < r1) goto L37;
        char[] r15 = this.n.l();
        int r6 = r15.length;
        a("Text size", this.O.y(), this.n.d());
        r1 = r6;
        r0 = r15;
    L38:
        r14 = r5 + 1;
        r0[r5] = r4;
        goto L4
    L37:
        r5 = r14;
        goto L38
    L12:
        if (r4 != '\r') goto L24;
        if (g(r4) == false) goto L21;
        if (this.Z == true) goto L22;
        if (r14 < r1) goto L19;
        r0 = this.n.l();
        r1 = r0.length;
        r14 = 0;
    L19:
        r0[r14] = r4;
        r14 = r14 + 1;
    L22:
        r4 = '\n';
        goto L35
    L21:
        if (this.Z == false) goto L35;
    L24:
        if (r4 == '\t') goto L35;
        f(r4);
        goto L35
    L26:
        if (r4 != '-') goto L35;
        if (k(" in comment") == '-') goto L30;
        this.f3547J--;
        r4 = '-';
        goto L35
    L30:
        if (k(" in comment") == '>') goto L32;
        e(com.ctc.wstx.b.a.x);
    L32:
        this.n.a(r14);
        return;
    L6:
        r4 = k(" in comment");
        goto L7
    }

    private void a(String r10, char r11, boolean r12) {
        int r0 = 0;
    L4:
        if (this.f3547J < this.K) goto L6;
        a("Text size", this.O.y(), r0);
        char r1 = k(r10);
    L8:
        if (r1 < ' ') goto L9;
        if (r1 != r11) goto L37;
        char r2 = j(r10);
        if (r2 != r11) goto L30;
        r2 = j(r10);
        if (r2 == '>') goto L29;
        if (r12 == false) goto L23;
        e("String '--' not allowed in comment (missing '>'?)");
    L23:
        if (r2 != r11) goto L28;
        if (this.f3547J < this.K) goto L26;
        r2 = k(r10);
        goto L23
    L26:
        char[] r3 = this.I;
        int r7 = this.f3547J;
        this.f3547J = r7 + 1;
        r2 = r3[r7];
        goto L23
    L28:
        if (r2 != '>') goto L30;
        return;
    L29:
        return;
    L30:
        if (r2 >= ' ') goto L4;
        if (r2 == '\n') goto L36;
        if (r2 == '\r') goto L36;
        if (r2 == '\t') goto L4;
        f(r2);
    L36:
        g(r2);
    L37:
        r0 = r0 + 1;
        goto L4
    L9:
        if (r1 == '\n') goto L14;
        if (r1 == '\r') goto L14;
        if (r1 == '\t') goto L37;
        f(r1);
    L14:
        g(r1);
        goto L37
    L6:
        char[] r4 = this.I;
        int r5 = this.f3547J;
        this.f3547J = r5 + 1;
        r1 = r4[r5];
        goto L8
    }

    private void a(String r3, String r4, int r5) {
        this.f3547J--;
        String r6 = r3 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r4;
        e("Unexpected close tag </" + (r6.substring(0, r5) + B()) + ">; expected </" + r6 + ">.");
    }

    private final boolean a(char r8, boolean r9) {
        int r10 = this.f3547J;
        char[] r0 = this.I;
        int r1 = this.K;
        int r2 = r10 - 1;
    L4:
        if (r8 > ' ') goto L5;
        if (r8 != '\n') goto L11;
    L24:
        h(r10);
    L29:
        if (r10 >= r1) goto L30;
        int r11 = r10 + 1;
        char r12 = r0[r10];
        r10 = r11;
        r8 = r12;
    L30:
        this.f3547J = r10;
        this.n.a(r0, r2, r10 - r2);
        return false;
    L11:
        if (r8 == '\r') goto L13;
        if (r8 == ' ') goto L29;
        if (r8 == '\t') goto L29;
        f(r8);
        goto L29
    L13:
        if (r10 >= this.K) goto L14;
        if (this.Z == false) goto L22;
        if (r0[r10] == '\n') goto L14;
        r0[r10 - 1] = '\n';
        goto L24
    L22:
        if (r0[r10] != '\n') goto L24;
        r10 = r10 + 1;
    L14:
        r10 = r10 - 1;
        goto L30
    L5:
        int r13 = r10 - 1;
        this.f3547J = r13;
        this.n.a(this.I, r2, r13 - r2);
        return true;
    }

    private boolean a(char[] r7, int r8) {
        int r1 = 0;
    L3:
        r1 = r1 + 1;
        if (this.f3547J >= this.K) goto L6;
        char[] r3 = this.I;
        int r4 = this.f3547J;
        this.f3547J = r4 + 1;
        char r5 = r3[r4];
    L8:
        if (r5 == ']') goto L3;
        if (r1 >= 2) goto L12;
    L14:
        boolean r6 = false;
    L15:
        if (r6 == false) goto L17;
        r1 = r1 - 2;
    L17:
        if (r1 <= 0) goto L22;
        r1 = r1 - 1;
        int r9 = r8 + 1;
        r7[r8] = ']';
        if (r9 >= r7.length) goto L20;
        r8 = r9;
        goto L17
    L20:
        r7 = this.n.l();
        r8 = 0;
        goto L17
    L22:
        this.n.a(r8);
        if (r6 == false) goto L25;
        return true;
    L25:
        this.f3547J--;
        return false;
    L12:
        if (r5 != '>') goto L14;
        r6 = true;
        goto L15
    L6:
        r5 = k(" in CDATA section");
        goto L8
    }

    private final char[] a(int r2, char[] r3, int r4) {
        com.ctc.wstx.util.l r0 = this.n;
        r0.a(r3.length);
        if (r0.d() < r4) goto L7;
        this.f3547J = r2;
        return null;
    L7:
        return r0.l();
    }

    private final char[] a(m r7, char[] r8, int r9, int r10, int r11) {
        a("Maximum attribute size", r11, r10 + 1);
        if (r9 >= r8.length) goto L6;
        com.ctc.wstx.util.g.a(String.format("Expected either currAttrSize (%d) > maxAttrSize (%d) OR outPtr (%d) >= outBuf.length (%d)", new Object[]{Integer.valueOf(r10), Integer.valueOf(r11), Integer.valueOf(r9), Integer.valueOf(r8.length)}));
    L6:
        return r7.b(1);
    }

    private void b(com.ctc.wstx.util.l r12) {
        char[] r0 = this.I;
        int r1 = this.K;
        int r2 = this.f3547J;
        char[] r3 = r12.j();
        int r4 = r12.k();
    L4:
        if (r2 < r1) goto L6;
        o(" in processing instruction");
        r0 = this.I;
        r2 = this.f3547J;
        r1 = this.K;
    L6:
        int r6 = r2 + 1;
        char r5 = r0[r2];
        int r8 = 0;
        char r9 = '?';
        if (r5 < ' ') goto L9;
        if (r5 != '?') goto L44;
        this.f3547J = r6;
    L31:
        if (this.f3547J >= this.K) goto L33;
        char[] r7 = this.I;
        int r10 = this.f3547J;
        this.f3547J = r10 + 1;
        char r11 = r7[r10];
    L35:
        if (r11 == '>') goto L36;
        if (r11 != '?') goto L43;
        if (r4 < r3.length) goto L42;
        r3 = r12.l();
        r4 = 0;
    L42:
        r3[r4] = r11;
        r4 = r4 + 1;
        goto L31
    L43:
        int r13 = this.f3547J - 1;
        this.f3547J = r13;
        r2 = r13;
        r0 = this.I;
        r1 = this.K;
    L46:
        if (r4 < r3.length) goto L48;
        r3 = r12.l();
    L49:
        r4 = r8 + 1;
        r3[r8] = r9;
        goto L4
    L48:
        r8 = r4;
        goto L49
    L36:
        r12.a(r4);
        return;
    L33:
        r11 = k(" in processing instruction");
    L44:
        r9 = r5;
        r2 = r6;
        goto L46
    L9:
        if (r5 != '\n') goto L12;
        h(r6);
        goto L44
    L12:
        if (r5 != '\r') goto L26;
        this.f3547J = r6;
        if (g(r5) == false) goto L22;
        if (this.Z == false) goto L18;
    L23:
        r5 = '\n';
    L24:
        int r14 = this.f3547J;
        r9 = r5;
        r2 = r14;
        r0 = this.I;
        r1 = this.K;
        goto L46
    L18:
        if (r4 < r3.length) goto L20;
        r3 = this.n.l();
        r4 = 0;
    L20:
        r3[r4] = r5;
        r4 = r4 + 1;
        goto L23
    L22:
        if (this.Z == false) goto L24;
    L26:
        if (r5 == '\t') goto L44;
        f(r5);
        goto L44
    }

    private void b(String r3, String r4, int r5) {
        this.f3547J--;
        if (r3 != null) goto L5;
    L7:
        e("Unexpected close tag </" + (r4.substring(0, r5) + B()) + ">; expected </" + r4 + ">.");
        return;
    L5:
        if (r3.length() <= 0) goto L7;
        r4 = r3 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r4;
        r5 = r5 + (r3.length() + 1);
        goto L7
    }

    private boolean h(boolean r10) {
        if (this.r >= this.s) goto L5;
        this.r = 4;
        int r0 = D();
    L7:
        if (r0 > 32) goto L22;
        if (r0 < 0) goto L22;
        if (b(256) == false) goto L19;
        this.w = 6;
        if (a((char) r0, true) == false) goto L15;
    L13:
        this.r = 4;
    L18:
        return false;
    L15:
        if (this.f == false) goto L17;
        this.r = 1;
        goto L18
    L17:
        j(true);
        goto L13
    L19:
        this.f3547J--;
        r0 = x();
        if (r0 < 0) goto L22;
        this.ac = (this.L + ((long) this.f3547J)) - 1;
        this.ad = this.M;
        this.ae = (this.f3547J - this.N) - 1;
    L22:
        if (r0 >= 0) goto L25;
        a(r10);
        this.v = 4;
        return true;
    L25:
        String r2 = " in prolog";
        if (r0 == 60) goto L32;
        StringBuilder r1 = new StringBuilder();
        if (r10 == false) goto L30;
        String r6 = " in prolog";
    L31:
        a(r0, r1.append(r6).append("; expected '<'").toString());
        goto L32
    L30:
        r6 = " in epilog";
    L32:
        if (r10 == false) goto L34;
        String r3 = " in prolog";
    L35:
        char r4 = j(r3);
        if (r4 != '?') goto L39;
        this.w = F();
    L61:
        if (this.f == false) goto L63;
    L65:
        return false;
    L63:
        if (this.r >= this.s) goto L65;
        c(false);
        goto L65
    L39:
        if (r4 != '!') goto L42;
        i(r10);
        goto L61
    L42:
        if (r4 != '/') goto L47;
        if (r10 == false) goto L45;
        e("Unexpected character combination '</' in prolog.");
    L45:
        e("Unexpected character combination '</' in epilog (extra close tag?).");
        goto L61
    L47:
        if (r4 != ':') goto L49;
    L56:
        if (r10 == true) goto L59;
        this.w = l(r4);
        return false;
    L59:
        e(r4);
        this.w = 1;
        goto L61
    L49:
        if (a(r4) == true) goto L56;
        StringBuilder r5 = new StringBuilder();
        if (r10 == true) goto L55;
        r2 = " in epilog";
    L55:
        a(r4, r5.append(r2).append(", after '<'.").toString());
        goto L61
    L34:
        r3 = " in epilog";
        goto L35
    L5:
        this.ac = this.L + ((long) this.f3547J);
        this.ad = this.M;
        this.ae = this.f3547J - this.N;
        r0 = v();
        goto L7
    }

    private void i(boolean r5) {
        int r0 = v();
        String r1 = " in prolog";
        if (r0 >= 0) goto L6;
        h(" in prolog");
    L6:
        if (r0 != 68) goto L25;
        String r2 = a('D', "DOCTYPE");
        if (r2 == null) goto L11;
        e("Unrecognized XML directive '<!" + r2 + "' (misspelled DOCTYPE?).");
    L11:
        if (r5 == true) goto L20;
        if (this.O.E() == true) goto L15;
        e(com.ctc.wstx.b.a.u);
        goto L20
    L15:
        if (this.q == true) goto L20;
        this.w = c(11);
        return;
    L20:
        if (this.q == false) goto L22;
        e(com.ctc.wstx.b.a.v);
    L22:
        this.q = true;
        this.w = 11;
        l();
        return;
    L25:
        if (r0 != 45) goto L35;
        if (r5 == true) goto L30;
        r1 = " in epilog";
    L30:
        if (j(r1) == '-') goto L32;
        a(r0, " (malformed comment?)");
    L32:
        this.r = 1;
        this.w = 5;
        return;
    L35:
        if (r0 != 91) goto L39;
        r0 = w();
        if (r0 != 67) goto L39;
        a(r0, com.ctc.wstx.b.a.w);
    L39:
        a(r0, " after '<!' (malformed comment?)");
    }

    private int j(int r3) {
    L3:
        if (r3 == 60) goto L5;
        if (r3 < 0) goto L15;
        r3 = k(r3);
        if (r3 == 38) goto L19;
        if (r3 >= 0) goto L3;
    L19:
        return r3;
    L15:
        return r3;
    L5:
        if (a(3) == false) goto L6;
        if (this.I[this.f3547J] != '!') goto L13;
        if (this.I[this.f3547J + 1] != '[') goto L13;
        this.f3547J += 2;
        b();
        a(" in CDATA section", ']', false);
        r3 = v();
    L13:
        return r3;
    L6:
        return r3;
    }

    private void j(boolean r7) {
        char[] r8 = this.n.j();
        int r0 = this.n.k();
    L4:
        if (this.f3547J >= this.K) goto L6;
    L8:
        char r1 = this.I[this.f3547J];
        if (r1 > ' ') goto L10;
        this.f3547J++;
        if (r1 != '\n') goto L16;
        y();
    L32:
        int r2 = r0 + 1;
        r8[r0] = r1;
        if (r2 >= r8.length) goto L34;
        r0 = r2;
        goto L4
    L34:
        r8 = this.n.l();
        r0 = 0;
        goto L4
    L16:
        if (r1 == '\r') goto L18;
        if (r1 == ' ') goto L32;
        if (r1 == '\t') goto L32;
        f(r1);
        goto L32
    L18:
        if (g(r1) == false) goto L26;
        if (this.Z == true) goto L27;
        int r3 = r0 + 1;
        r8[r0] = r1;
        if (r3 < r8.length) goto L24;
        r8 = this.n.l();
        r0 = 0;
        goto L27
    L24:
        r0 = r3;
    L27:
        r1 = '\n';
        goto L32
    L26:
        if (this.Z == false) goto L32;
    L10:
        this.n.a(r0);
        return;
    L6:
        if (d() == true) goto L8;
        goto L8
    }

    private char[] j() {
        return this.n.h();
    }

    private int k() {
        int r0 = this.w;
        if (r0 == 8) goto L5;
        if (r0 != 7) goto L22;
        this.v = 0;
        int r1 = this.x;
        if (r1 != 7) goto L14;
        h(true);
        return this.w;
    L14:
        if (r1 != 1) goto L18;
        e(j(" in start tag"));
        return 1;
    L18:
        if (r1 != 11) goto L22;
        this.q = true;
        l();
        return 11;
    L22:
        throw new IllegalStateException("Internal error: unexpected state; current event " + g(this.w) + ", sec. state: " + g(this.x));
    L5:
        if (this.x != 7) goto L7;
        f();
    L8:
        return 7;
    L7:
        this.ag = null;
        this.ah = 0;
        this.i = 0;
        goto L8
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r8v0 ??, r8v1 ??, r8v6 ??, r8v5 ??, r8v8 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    private int k(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r8v0 ??, r8v1 ??, r8v6 ??, r8v5 ??, r8v8 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    private int l(char r2) {
        if (this.O.E() == true) goto L5;
        e("Illegal to have multiple roots (start tag in epilog?).");
    L5:
        this.f3547J--;
        return c(1);
    }

    private void l() {
        this.n.c();
        char r1 = m(" in DOCTYPE declaration");
        String r6 = null;
        if (this.P == false) goto L15;
        String r2 = h(r1);
        char r3 = j(" in DOCTYPE declaration");
        if (r3 != ':') goto L9;
        this.j = r2;
        r2 = h(j("; expected an identifier"));
    L7:
        this.k = r2;
    L16:
        char r4 = m(" in DOCTYPE declaration");
        if (r4 == '[') goto L60;
        if (r4 == '>') goto L60;
        if (r4 != 'P') goto L41;
        r6 = a(j(" in DOCTYPE declaration"), "UBLIC");
        if (r6 == null) goto L26;
        StringBuilder r5 = new StringBuilder().append(com.tom_roush.pdfbox.pdmodel.a.d.i.m).append(r6);
    L24:
        r6 = r5.toString();
    L57:
        if (r6 == null) goto L59;
        e("Unexpected keyword '" + r6 + "'; expected 'PUBLIC' or 'SYSTEM'");
    L59:
        r4 = m(" in DOCTYPE declaration");
        goto L60
    L26:
        if (f(j(" in DOCTYPE declaration")) == true) goto L28;
        a(r4, " in DOCTYPE declaration; expected a space between PUBLIC keyword and public id");
    L28:
        char r7 = k(" in DOCTYPE declaration");
        if (r7 == '\"') goto L32;
        if (r7 == '\'') goto L32;
        a(r7, " in DOCTYPE declaration; expected a public identifier.");
    L32:
        String r8 = b(r7, " in DOCTYPE declaration");
        this.l = r8;
        r8.length();
        if (f(j(" in DOCTYPE declaration")) == true) goto L35;
        a(r7, " in DOCTYPE declaration; expected a space between public and system identifiers");
    L35:
        char r9 = k(" in DOCTYPE declaration");
        if (r9 == '\"') goto L39;
        if (r9 == '\'') goto L39;
        e(" in DOCTYPE declaration; expected a system identifier.");
    L39:
        String r10 = a(r9, this.Z, " in DOCTYPE declaration");
        this.m = r10;
        r10.length();
        goto L57
    L41:
        if (r4 != 'S') goto L54;
        this.l = null;
        String r11 = a(j(" in DOCTYPE declaration"), "YSTEM");
        if (r11 == null) goto L45;
        r5 = new StringBuilder().append("S").append(r11);
        goto L24
    L45:
        char r12 = m(" in DOCTYPE declaration");
        if (r12 == '\"') goto L49;
        if (r12 == '\'') goto L49;
        a(r12, " in DOCTYPE declaration; expected a system identifier.");
    L49:
        String r13 = a(r12, this.Z, " in DOCTYPE declaration");
        this.m = r13;
        if (r13.length() != 0) goto L52;
        this.m = null;
    L52:
        r6 = r11;
        goto L57
    L54:
        if (a(r4) == true) goto L56;
        a(r4, " in DOCTYPE declaration; expected keywords 'PUBLIC' or 'SYSTEM'.");
        goto L57
    L56:
        this.f3547J--;
        r6 = a(r4, "SYSTEM");
    L60:
        if (r4 == '[') goto L64;
        if (r4 == '>') goto L64;
        a(r4, " in DOCTYPE declaration; expected closing '>'.");
    L64:
        this.f3547J--;
        this.r = 1;
        return;
    L9:
        if (r3 <= ' ') goto L14;
        if (r3 == '[') goto L14;
        if (r3 == '>') goto L14;
        a(r3, " in DOCTYPE declaration; expected '[' or white space.");
    L14:
        this.f3547J--;
        this.j = null;
        goto L7
    L15:
        this.k = i(r1);
        this.j = null;
        goto L16
    }

    private void l(int r4) {
        throw new IllegalStateException("Not a textual event (" + g(r4) + ")");
    }

    private final int m() {
        int r0 = this.r;
        boolean r2 = false;
        int r6 = 4;
        if (r0 < this.s) goto L5;
        int r1 = this.w;
        if (r1 == 1) goto L14;
        if (r1 == 2) goto L22;
        if (r1 != 12) goto L52;
        if (r0 > 2) goto L52;
        this.ac = this.L + ((long) this.f3547J);
        this.ad = this.M;
        this.ae = this.f3547J - this.N;
        if (this.f3547J >= this.K) goto L32;
        char[] r3 = this.I;
        int r4 = this.f3547J;
        this.f3547J = r4 + 1;
        char r5 = r3[r4];
    L34:
        if (p(r5) == false) goto L39;
        if (this.n.d() <= 0) goto L52;
        return 12;
    L39:
        if (this.n.d() == 0) goto L41;
    L50:
        this.r = 2;
        return 12;
    L41:
        if (this.f == false) goto L43;
        int r7 = 1;
    L45:
        if (d(r7) == false) goto L50;
        if (this.n.d() <= 0) goto L52;
        this.r = 3;
        return 12;
    L43:
        r7 = this.g;
        goto L45
    L32:
        r5 = j(" in CDATA section");
    L52:
        this.ac = this.L + ((long) this.f3547J);
        this.ad = this.M;
        this.ae = this.f3547J - this.N;
        int r8 = v();
    L53:
        if (r8 >= 0) goto L60;
        if (this.o.h() == true) goto L58;
        i();
    L58:
        return a(false);
    L60:
        if (r8 != 38) goto L91;
        this.y = 0;
        if (this.D != 0) goto L65;
        e(9);
    L65:
        if (this.Q == false) goto L67;
        int r9 = g(true);
    L68:
        if (r9 != 0) goto L70;
        if (this.Q == false) goto L86;
        if (this.aj == true) goto L86;
        r8 = j(" in main document content");
    L86:
        if (this.aj == true) goto L88;
        this.ak = z();
    L88:
        this.r = 4;
        return 9;
    L70:
        if (this.D > 1) goto L73;
        if (r9 <= 32) goto L73;
        e(4);
    L73:
        com.ctc.wstx.util.l r10 = this.n;
        r10.c();
        if (r9 <= 65535) goto L77;
        int r11 = r9 - 65536;
        r10.a((char) ((r11 >> 10) + 55296));
        r9 = (r11 & 1023) + Utf8.LOG_SURROGATE_HEADER;
    L77:
        r10.a((char) r9);
        this.r = 1;
        return 4;
    L67:
        r9 = f(true);
        goto L68
    L91:
        if (r8 != 60) goto L120;
        char r12 = j(" in start tag");
        if (r12 != '?') goto L100;
        if (this.D != 0) goto L98;
        e(3);
    L98:
        return F();
    L100:
        if (r12 != '!') goto L106;
        int r13 = C();
        if (this.D != 0) goto L104;
        e(r13);
    L104:
        return r13;
    L106:
        if (r12 != '/') goto L110;
        g();
        return 2;
    L110:
        if (r12 != ':') goto L112;
    L118:
        m(r12);
        return 1;
    L112:
        if (a(r12) == true) goto L118;
        if (r12 != '[') goto L117;
        a(r12, " in content after '<' (malformed <![CDATA[]] directive?)");
    L117:
        a(r12, " in content after '<' (malformed start element?).");
    L120:
        int r14 = this.D;
        if (r14 > 2) goto L137;
        if (r14 == 0) goto L124;
    L126:
        if (r8 > 32) goto L134;
        if (a((char) r8, false) == true) goto L131;
        r6 = 1;
    L131:
        this.r = r6;
        return 6;
    L134:
        if (this.o.a() == false) goto L137;
        e(4);
        goto L137
    L124:
        if (this.o.a() == false) goto L126;
        e(4);
    L137:
        if (q((char) r8) == false) goto L140;
        this.r = 3;
    L145:
        return 4;
    L140:
        if (this.d == false) goto L142;
    L144:
        this.r = 1;
        goto L145
    L142:
        if (this.n.d() < this.g) goto L144;
        this.r = 2;
        goto L145
    L22:
        if (this.o.c() == true) goto L52;
        if (this.O.F() == true) goto L52;
        return n();
    L14:
        if (this.u == false) goto L52;
        this.u = false;
        int r15 = this.o.e();
        this.D = r15;
        if (r15 != 3) goto L18;
        r2 = true;
    L18:
        this.z = r2;
        return 2;
    L5:
        if (this.D != 3) goto L10;
        int r16 = this.w;
        if (r16 == 4) goto L9;
        if (r16 != 12) goto L10;
    L9:
        e("Internal error: skipping validatable text");
    L10:
        r8 = D();
        goto L53
    }

    private final void m(char r9) {
        this.r = 4;
        boolean r4 = false;
        if (this.P == false) goto L23;
        String r10 = h(r9);
        if (this.f3547J >= this.K) goto L7;
        char[] r0 = this.I;
        int r5 = this.f3547J;
        this.f3547J = r5 + 1;
        char r1 = r0[r5];
    L9:
        if (r1 == ':') goto L11;
        this.o.a(null, r10);
    L20:
        if (r1 != '>') goto L22;
    L21:
        boolean r11 = false;
    L31:
        if (r11 == true) goto L33;
        this.W++;
    L33:
        this.u = r11;
        int r12 = this.o.d();
        this.D = r12;
        if (r12 != 3) goto L36;
        r4 = true;
    L36:
        this.z = r4;
        return;
    L22:
        r11 = n(r1);
        goto L31
    L11:
        if (this.f3547J >= this.K) goto L13;
        char[] r2 = this.I;
        int r3 = this.f3547J;
        this.f3547J = r3 + 1;
        char r6 = r2[r3];
    L14:
        this.o.a(r10, h(r6));
        if (this.f3547J >= this.K) goto L17;
        char[] r13 = this.I;
        int r7 = this.f3547J;
        this.f3547J = r7 + 1;
        char r14 = r13[r7];
    L18:
        r1 = r14;
        goto L20
    L17:
        r14 = k(" in start tag");
        goto L18
    L13:
        r6 = k("; expected an identifier");
        goto L14
    L7:
        r1 = k("; expected an identifier");
        goto L9
    L23:
        this.o.a(null, i(r9));
        if (this.f3547J >= this.K) goto L26;
        char[] r15 = this.I;
        int r8 = this.f3547J;
        this.f3547J = r8 + 1;
        char r16 = r15[r8];
    L27:
        if (r16 == '>') goto L21;
        r11 = o(r16);
        goto L31
    L26:
        r16 = k(" in start tag");
        goto L27
    }

    private void m(int r4) {
        throw new IllegalStateException("getTextXxx() methods can not be called on " + g(r4));
    }

    private int n() {
        this.v = 2;
        if (h(false) == false) goto L6;
        this.x = 0;
    L6:
        if (this.R.d() == false) goto L8;
        this.h.a(this.R);
    L8:
        this.n.a(false);
        return this.w;
    }

    private final boolean n(char r11) {
        b r0 = this.p;
    L4:
        if (r11 > ' ') goto L6;
        r11 = a(" in start tag", r11);
    L10:
        if (r11 == '/') goto L11;
        if (r11 == '>') goto L17;
        if (r11 != '<') goto L21;
        e("Unexpected '<' character in element (missing closing '>'?)");
    L21:
        String r12 = h(r11);
        if (this.f3547J >= this.K) goto L24;
        char[] r2 = this.I;
        int r6 = this.f3547J;
        this.f3547J = r6 + 1;
        char r3 = r2[r6];
    L26:
        if (r3 == ':') goto L28;
        this.f3547J--;
        String r4 = r12;
        r12 = null;
    L34:
        if (this.f3547J >= this.K) goto L36;
        char[] r5 = this.I;
        int r7 = this.f3547J;
        this.f3547J = r7 + 1;
        char r8 = r5[r7];
    L37:
        if (r8 > ' ') goto L40;
        r8 = a(" in start tag", r8);
    L40:
        if (r8 == '=') goto L43;
        a(r8, " expected '='");
    L43:
        if (this.f3547J >= this.K) goto L45;
        char[] r9 = this.I;
        int r10 = this.f3547J;
        this.f3547J = r10 + 1;
        char r13 = r9[r10];
    L46:
        if (r13 > ' ') goto L49;
        r13 = a(" in start tag", r13);
    L49:
        if (r13 != '\"') goto L51;
    L53:
        int r14 = -1;
        String r15 = f3513b;
        if (r12 != r15) goto L60;
        m r16 = r0.a(r4);
        if (r16 == null) goto L57;
        r14 = r16.d();
    L66:
        a(r13, r16);
        if (this.H == true) goto L73;
        if (r14 < 0) goto L73;
        if (r16.d() != r14) goto L73;
        e(com.ctc.wstx.b.a.M);
    L73:
        if (this.f3547J < this.K) goto L74;
        r11 = k(" in start tag");
        goto L4
    L74:
        char[] r17 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        r11 = r17[r1];
        goto L4
    L57:
        e("Duplicate declaration for namespace prefix '" + r4 + "'.");
        return false;
    L60:
        if (r4 != r15) goto L65;
        if (r12 != null) goto L65;
        r16 = r0.d();
        if (r16 != null) goto L66;
        e("Duplicate default namespace declaration.");
    L65:
        r16 = r0.a(r12, r4);
        goto L66
    L51:
        if (r13 == '\'') goto L53;
        a(r13, " in start tag Expected a quote");
        goto L53
    L45:
        r13 = k(" in start tag");
        goto L46
    L36:
        r8 = k(" in start tag");
        goto L37
    L28:
        if (this.f3547J >= this.K) goto L30;
        char[] r18 = this.I;
        int r19 = this.f3547J;
        this.f3547J = r19 + 1;
        char r20 = r18[r19];
    L31:
        r4 = h(r20);
        goto L34
    L30:
        r20 = k("; expected an identifier");
        goto L31
    L24:
        r3 = k("; expected an identifier");
        goto L26
    L17:
        return false;
    L11:
        char r110 = k(" in start tag");
        if (r110 == '>') goto L14;
        a(r110, " expected '>'");
    L14:
        return true;
    L6:
        if (r11 == '/') goto L10;
        if (r11 == '>') goto L10;
        a(r11, " expected space, or '>' or \"/>\"");
        goto L10
    }

    private void o() {
        e("Unbalanced close tag </" + B() + ">; no open start tag.");
    }

    private final boolean o(char r7) {
        b r0 = this.p;
    L4:
        if (r7 > ' ') goto L6;
        r7 = a(" in start tag", r7);
    L9:
        if (r7 == '/') goto L10;
        if (r7 == '>') goto L16;
        if (r7 != '<') goto L21;
        e("Unexpected '<' character in element (missing closing '>'?)");
    L21:
        m r8 = r0.a(null, i(r7));
        if (this.f3547J >= this.K) goto L24;
        char[] r1 = this.I;
        int r2 = this.f3547J;
        this.f3547J = r2 + 1;
        char r3 = r1[r2];
    L25:
        if (r3 > ' ') goto L28;
        r3 = a(" in start tag", r3);
    L28:
        if (r3 == '=') goto L31;
        a(r3, " expected '='");
    L31:
        if (this.f3547J >= this.K) goto L33;
        char[] r4 = this.I;
        int r5 = this.f3547J;
        this.f3547J = r5 + 1;
        char r6 = r4[r5];
    L34:
        if (r6 > ' ') goto L37;
        r6 = a(" in start tag", r6);
    L37:
        if (r6 != '\"') goto L39;
    L41:
        a(r6, r8);
        if (this.f3547J < this.K) goto L43;
        r7 = k(" in start tag");
        goto L4
    L43:
        char[] r9 = this.I;
        int r10 = this.f3547J;
        this.f3547J = r10 + 1;
        r7 = r9[r10];
        goto L4
    L39:
        if (r6 == '\'') goto L41;
        a(r6, " in start tag Expected a quote");
        goto L41
    L33:
        r6 = k(" in start tag");
        goto L34
    L24:
        r3 = k(" in start tag");
        goto L25
    L16:
        return false;
    L10:
        char r11 = k(" in start tag");
        if (r11 == '>') goto L52;
        a(r11, " expected '>'");
        return true;
    L52:
        return true;
    L6:
        if (r7 == '/') goto L9;
        if (r7 == '>') goto L9;
        a(r7, " expected space, or '>' or \"/>\"");
        goto L9
    }

    private final boolean p(char r12) {
        if (r12 > ' ') goto L5;
        int r3 = 0;
    L6:
        this.y = r3;
        int r4 = this.f3547J;
        int r5 = this.K;
        char[] r6 = this.I;
        int r7 = r4 - 1;
    L8:
        if (r12 >= ' ') goto L30;
        if (r12 != '\n') goto L13;
    L25:
        h(r4);
    L45:
        if (r4 >= r5) goto L46;
        int r13 = r4 + 1;
        char r8 = r6[r4];
        r4 = r13;
        r12 = r8;
    L46:
        this.f3547J = r4;
        this.n.a(r6, r7, r4 - r7);
        if (this.d == false) goto L49;
    L52:
        this.r = 1;
    L53:
        return false;
    L49:
        if (this.n.d() < this.g) goto L52;
        this.r = 2;
        goto L53
    L13:
        if (r12 != '\r') goto L27;
        if (r4 >= r5) goto L33;
        if (this.Z == false) goto L23;
        if (r6[r4] == '\n') goto L33;
        r6[r4 - 1] = '\n';
        goto L25
    L23:
        if (r6[r4] != '\n') goto L25;
        r4 = r4 + 1;
    L33:
        r4 = r4 - 1;
        goto L46
    L27:
        if (r12 == '\t') goto L45;
        f(r12);
        goto L45
    L30:
        if (r12 != ']') goto L45;
        int r14 = r4 + 1;
        if (r14 >= r5) goto L33;
        if (r6[r4] != ']') goto L45;
    L36:
        if (r14 >= r5) goto L37;
        int r9 = r14 + 1;
        char r15 = r6[r14];
        if (r15 == '>') goto L40;
        if (r15 != ']') goto L43;
        r14 = r9;
        goto L36
    L43:
        r4 = r9 - 1;
        goto L45
    L40:
        this.f3547J = r9;
        this.n.a(r6, r7, r9 - (r7 + 3));
        this.r = 3;
        return true;
    L37:
        r4 = r14 - 2;
        goto L45
    L5:
        r3 = 2;
        goto L6
    }

    private final boolean q(char r13) {
        int r0 = this.f3547J;
        int r1 = r0 - 1;
        boolean r4 = false;
        if (r13 > ' ') goto L24;
        int r7 = this.K;
        if (r0 < r7) goto L7;
    L23:
        this.y = 0;
    L25:
        char[] r8 = this.I;
        int r9 = this.K;
    L27:
        if (r13 < '?') goto L29;
    L68:
        if (r0 >= r9) goto L69;
        int r14 = r0 + 1;
        char r2 = r8[r0];
        r0 = r14;
        r13 = r2;
    L69:
        this.f3547J = r0;
        this.n.a(r8, r1, r0 - r1);
        return false;
    L29:
        if (r13 == '<') goto L30;
        if (r13 >= ' ') goto L56;
        if (r13 == '\n') goto L47;
        if (r13 != '\r') goto L49;
        if (r0 >= r9) goto L57;
        if (this.Z == false) goto L45;
        if (r8[r0] == '\n') goto L57;
        r8[r0 - 1] = '\n';
        goto L47
    L45:
        if (r8[r0] != '\n') goto L47;
        r0 = r0 + 1;
    L57:
        r0 = r0 - 1;
        goto L69
    L49:
        if (r13 == '\t') goto L68;
        this.f3547J = r0;
        int r3 = r0 - r1;
        this.n.a(r8, r1, r3 - 1);
        if (r3 <= 1) goto L53;
        r4 = true;
    L53:
        this.B = c(r13, r4);
        return true;
    L47:
        h(r0);
        goto L68
    L56:
        if (r13 == '&') goto L57;
        if (r13 != '>') goto L68;
        int r15 = r0 - r1;
        if (r15 < 3) goto L68;
        if (r8[r0 - 3] != ']') goto L68;
        if (r8[r0 - 2] != ']') goto L68;
        this.f3547J = r0;
        this.n.a(r8, r1, r15 - 1);
        this.B = a(com.ctc.wstx.b.a.y, true);
        return true;
    L30:
        int r5 = r0 - 1;
        this.f3547J = r5;
        this.n.a(r8, r1, r5 - r1);
        return true;
    L7:
        if (this.Z == false) goto L23;
        if (r13 == '\r') goto L10;
        if (r13 != '\n') goto L23;
    L17:
        h(r0);
        if (this.A <= 0) goto L22;
        r0 = a(r13, r0);
        if (r0 >= 0) goto L22;
        return true;
    L22:
        r13 = this.I[r0];
        r0 = r0 + 1;
        goto L23
    L10:
        if (this.I[r0] != '\n') goto L14;
        r1 = r1 + 1;
        r0 = r0 + 1;
        r13 = '\n';
        if (r0 < r7) goto L17;
    L14:
        this.I[r1] = '\n';
        r13 = '\n';
        goto L17
    L24:
        this.y = 2;
        goto L25
    }

    public final char a(String r4, String r5) {
        char r0 = m(r5);
        if (r0 == '=') goto L6;
        a(r0, " in xml declaration; expected '=' to follow pseudo-attribute '" + r4 + "'");
    L6:
        return m(r5);
    }

    public int a(boolean r3) {
        this.x = 8;
        this.w = 8;
        this.n.a(true);
        if (r3 == false) goto L6;
        h(" in prolog");
    L6:
        return this.w;
    }

    @Override // com.ctc.wstx.g.j
    public com.ctc.wstx.e.a a(String r3, Object r4) {
        com.ctc.wstx.e.a r5 = this.O.d(r3);
        if (r5 != null) goto L8;
        Map<String, com.ctc.wstx.e.a> r0 = this.C;
        if (r0 == null) goto L8;
        r5 = (com.ctc.wstx.e.a) ZeusTransformUtils.preCheckCast(r0.get(r3), com.ctc.wstx.e.a.class, "com.obric.memorydata.plugin");
    L8:
        if (this.i != 1) goto L13;
        if (r5 == null) goto L13;
        if (r5.h() == false) goto L13;
        a(com.ctc.wstx.b.a.D, r5.c(), null);
    L13:
        return r5;
    }

    public String a() {
        if (this.w == 11) goto L7;
        return null;
    L7:
        return this.n.g();
    }

    public String a(char r6, String r7) {
        int r0 = r7.length();
        int r2 = 0;
    L4:
        if (r7.charAt(r2) != r6) goto L14;
        r2 = r2 + 1;
        if (r2 >= r0) goto L14;
        if (this.f3547J < this.K) goto L9;
        int r3 = v();
        if (r3 < 0) goto L14;
        r6 = (char) r3;
        goto L4
    L9:
        char[] r8 = this.I;
        int r4 = this.f3547J;
        this.f3547J = r4 + 1;
        r6 = r8[r4];
    L14:
        if (r2 != r0) goto L23;
        int r5 = w();
        if (r5 >= 0) goto L18;
        return null;
    L18:
        if (b((char) r5) == true) goto L23;
        if (r5 == 58) goto L23;
        return null;
    L23:
        StringBuilder r9 = new StringBuilder(r7.length() + 16);
        r9.append(r7.substring(0, r2));
        if (r2 >= r0) goto L27;
        r9.append(r6);
    L27:
        if (this.f3547J >= this.K) goto L29;
        char[] r10 = this.I;
        int r11 = this.f3547J;
        this.f3547J = r11 + 1;
        char r12 = r10[r11];
    L34:
        if (b(r12) == false) goto L35;
        r9.append(r12);
        goto L27
    L35:
        this.f3547J--;
    L37:
        return r9.toString();
    L29:
        int r13 = v();
        if (r13 < 0) goto L37;
        r12 = (char) r13;
        goto L34
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:16:0x0042). Please report as a decompilation issue!!! */
    public void a(int r8, boolean r9) {
        if (r8 != 4) goto L5;
    L15:
        b(Integer.MAX_VALUE, r9);
        boolean r10 = false;
    L16:
        if (r9 == false) goto L20;
        if (this.B == null) goto L20;
    L41:
        this.r = 4;
        return;
    L20:
        if (this.f3547J < this.K) goto L24;
        this.n.i();
        if (d() == false) goto L41;
    L24:
        char r5 = this.I[this.f3547J];
        if (r5 != '<') goto L39;
        if ((this.K - this.f3547J) >= 9) goto L32;
        this.n.i();
        if (a(3) == false) goto L41;
    L32:
        if (this.I[this.f3547J + 1] != '!') goto L41;
        if (this.I[this.f3547J + 2] != '[') goto L41;
        this.f3547J += 3;
        b();
    L37:
        d(Integer.MAX_VALUE);
    L12:
        r10 = true;
        goto L16
    L39:
        if (r5 != '&') goto L15;
        if (r10 == true) goto L15;
    L5:
        if (r8 == 6) goto L15;
        if (r8 != 12) goto L14;
        if (this.r <= 2) goto L37;
        d(Integer.MAX_VALUE);
        goto L12
    L14:
        throw new IllegalStateException("Internal error: unexpected token " + g(this.w) + "; expected CHARACTERS, CDATA or SPACE.");
    }

    @Override // com.ctc.wstx.g.j
    public void a(v r3) {
        if (this.o.h() == false) goto L5;
        String r0 = "[ROOT]";
    L6:
        a("Unexpected end of entity expansion for entity &{0}; was expecting a close tag for element <{1}>", r3.i(), r0);
        return;
    L5:
        r0 = this.o.l();
        goto L6
    }

    public final void a(String r7, char r8, com.ctc.wstx.util.l r9) {
        if (r8 != '\"') goto L5;
    L7:
        char[] r10 = r9.j();
        int r1 = 0;
    L9:
        if (this.f3547J >= this.K) goto L11;
        char[] r2 = this.I;
        int r3 = this.f3547J;
        this.f3547J = r3 + 1;
        char r4 = r2[r3];
    L12:
        if (r4 == r8) goto L13;
        if (r4 >= ' ') goto L18;
    L19:
        if (r4 != 0) goto L21;
        t();
    L23:
        if (r1 < r10.length) goto L25;
        r10 = r9.l();
        r1 = 0;
    L25:
        r10[r1] = r4;
        r1 = r1 + 1;
        goto L9
    L21:
        a(r4, " in xml declaration");
        goto L23
    L18:
        if (r4 != '<') goto L23;
    L13:
        r9.a(r1);
        return;
    L11:
        r4 = j(" in xml declaration");
        goto L12
    L5:
        if (r8 == '\'') goto L7;
        a(r8, " in xml declaration; waited ' or \" to start a value for pseudo-attribute '" + r7 + "'");
        goto L7
    }

    public void b() {
        String r1 = a(k(" in CDATA section"), "CDATA");
        if (r1 == null) goto L5;
        e("Unrecognized XML directive '" + r1 + "'; expected 'CDATA'.");
    L5:
        char r0 = k(" in CDATA section");
        if (r0 == '[') goto L9;
        a(r0, "expected '[' after '<![CDATA'");
        return;
    }

    public void b(v r4) {
        if (this.o.h() == false) goto L5;
        String r0 = "[ROOT]";
    L6:
        e("Improper GE/element nesting: entity &" + r4.i() + " contains closing tag for <" + r0 + ">");
        return;
    L5:
        r0 = this.o.l();
        goto L6
    }

    public void b(boolean r6) {
        char r0 = j(" in DOCTYPE declaration");
        if (r0 != '[') goto L16;
        if (r6 == false) goto L19;
        ((com.ctc.wstx.io.d) ZeusTransformUtils.preCheckCast(this.T, com.ctc.wstx.io.d.class, "com.obric.memorydata.plugin")).a(this.n, this.f3547J, this.Z);
    L19:
        ae.a(this, this.T, this.O);     // Catch: Throwable -> L11
        if (r6 == false) goto L10;
        ((com.ctc.wstx.io.d) ZeusTransformUtils.preCheckCast(this.T, com.ctc.wstx.io.d.class, "com.obric.memorydata.plugin")).a(this.f3547J - 1);
    L10:
        r0 = l(" in internal DTD subset");
    L11:
        th = move-exception;
        if (r6 == false) goto L14;
        ((com.ctc.wstx.io.d) ZeusTransformUtils.preCheckCast(this.T, com.ctc.wstx.io.d.class, "com.obric.memorydata.plugin")).a(this.f3547J - 1);
    L14:
        throw th;
    L16:
        if (r0 == '>') goto L21;
        a(r0, "; expected '>' to finish DOCTYPE declaration.");
        return;
    }

    public final boolean b(int r1) {
        if ((this.c & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b(int r15, boolean r16) {
        char[] r0 = this.n.j();
        int r1 = this.n.k();
        int r2 = this.f3547J;
        char[] r3 = this.I;
        int r4 = this.K;
    L4:
        if (r2 < r4) goto L9;
        this.f3547J = r2;
        if (d() == false) goto L75;
        r2 = this.f3547J;
        r3 = this.I;
        r4 = this.K;
    L75:
        this.n.a(r1);
        return true;
    L9:
        char[] r8 = r3;
        int r5 = r2 + 1;
        char r6 = r8[r2];
        if (r6 >= '?') goto L77;
        if (r6 < ' ') goto L14;
        if (r6 == '<') goto L36;
        if (r6 != '&') goto L67;
        this.f3547J = r5;
        if (this.Q == false) goto L49;
        if ((r4 - r5) < 3) goto L46;
        int r7 = e(true);
        if (r7 == 0) goto L46;
    L53:
        if (r7 > 65535) goto L55;
        r6 = (char) r7;
    L65:
        r5 = this.f3547J;
        r4 = this.K;
        goto L77
    L55:
        int r9 = r7 - 65536;
        if (r1 < r0.length) goto L58;
        r0 = this.n.l();
        r1 = 0;
    L58:
        int r10 = r1 + 1;
        r0[r1] = (char) ((r9 >> 10) + 55296);
        if (r10 < r0.length) goto L64;
        r0 = a(r5, r0, Integer.MAX_VALUE);
        if (r0 == null) goto L62;
        r10 = 0;
        goto L64
    L62:
        return false;
    L64:
        r6 = (char) ((r9 & 1023) + Utf8.LOG_SURROGATE_HEADER);
        r1 = r10;
    L46:
        r7 = g(true);
        if (r7 != 0) goto L53;
        r3 = this.I;
        r4 = this.K;
        r2 = this.f3547J;
        goto L4
    L49:
        r7 = f(true);
        if (r7 != 0) goto L53;
        this.f3547J--;
        goto L75
    L67:
        if (r6 != '>') goto L77;
        if (r5 <= 2) goto L77;
        if (r8[r5 - 3] != ']') goto L77;
        if (r8[r5 - 2] != ']') goto L77;
        this.f3547J = r5;
        this.n.a(r1);
        WstxException r11 = a(com.ctc.wstx.b.a.y, r16);
    L33:
        this.B = r11;
        goto L75
    L36:
        this.f3547J = r5 - 1;
        goto L75
    L14:
        if (r6 != '\n') goto L17;
        h(r5);
        goto L77
    L17:
        if (r6 != '\r') goto L31;
        this.f3547J = r5;
        if (g(r6) == false) goto L27;
        if (this.Z == true) goto L28;
        int r12 = r1 + 1;
        r0[r1] = r6;
        if (r12 < r0.length) goto L25;
        r0 = this.n.l();
        r1 = 0;
        goto L28
    L25:
        r1 = r12;
    L28:
        r6 = '\n';
    L29:
        int r13 = this.K;
        int r14 = this.f3547J;
    L78:
        int r17 = r1 + 1;
        r0[r1] = r6;
        if (r17 < r0.length) goto L84;
        char[] r18 = a(r14, r0, r15);
        if (r18 == null) goto L82;
        a("Text size", this.O.y(), this.n.d());
        r1 = 0;
        r0 = r18;
    L85:
        r3 = r8;
        r2 = r14;
        r4 = r13;
        goto L4
    L82:
        return false;
    L84:
        r1 = r17;
        goto L85
    L27:
        if (this.Z == false) goto L29;
    L31:
        if (r6 == '\t') goto L77;
        this.n.a(r1);
        this.f3547J = r5;
        r11 = c(r6, r16);
    L77:
        r14 = r5;
        r13 = r4;
        goto L78
    }

    public int c(int r2) {
        this.v = 3;
        this.r = 4;
        this.x = r2;
        return 8;
    }

    public void c() {
    }

    public void c(boolean r6) {
        int r0 = this.w;
        boolean r3 = true;
        switch(r0) {
            case 1: goto L46;
            case 2: goto L46;
            case 3: goto L44;
            case 4: goto L29;
            case 5: goto L27;
            case 6: goto L21;
            case 7: goto L46;
            case 8: goto L46;
            case 9: goto L46;
            case 10: goto L5;
            case 11: goto L47;
            case 12: goto L7;
            case 13: goto L5;
            case 14: goto L46;
            case 15: goto L46;
            default: goto L5;
        };
    L27:
        E();
    L25:
        this.r = 4;
        return;
    L44:
        G();
        goto L25
    L47:
        b(true);     // Catch: Throwable -> L17
        this.r = 4;
        return;
    L17:
        th = move-exception;
        this.r = 4;
        throw th;
    L5:
        throw new IllegalStateException("Internal error: unexpected token " + g(this.w));
    L7:
        if (this.d == false) goto L10;
        a(r0, r6);
        return;
    L10:
        if (d(Integer.MAX_VALUE) == false) goto L12;
        this.r = 3;
        return;
    L12:
        this.r = 2;
        return;
    L21:
        if (this.v != 1) goto L24;
        r3 = false;
    L24:
        j(r3);
        goto L25
    L29:
        if (this.d == false) goto L40;
        if (this.r == 3) goto L33;
    L38:
        a(this.w, r6);
        return;
    L33:
        if ((this.f3547J + 1) >= this.K) goto L38;
        if (this.I[this.f3547J + 1] == '!') goto L38;
        this.r = 4;
        return;
    L40:
        if (b(this.g, r6) == false) goto L42;
        this.r = 3;
        return;
    L42:
        this.r = 2;
        return;
    L46:
        throw new IllegalStateException("finishToken() called when current token is " + g(this.w));
    }

    @Override // javax.xml.stream.e
    public void close() {
        if (this.v == 4) goto L11;
        this.v = 4;
        if (this.w == 8) goto L9;
        this.x = 8;
        this.w = 8;
        if (this.R.d() == false) goto L9;
        this.h.a(this.R);
    L9:
        d(false);
        this.n.a(true);
        return;
    }

    @Override // com.ctc.wstx.g.j
    public void d(String r3) {
        if (this.i != 1) goto L5;
        String r0 = com.ctc.wstx.b.a.F;
    L6:
        a(r0, r3, null);
        return;
    L5:
        r0 = com.ctc.wstx.b.a.E;
        goto L6
    }

    public boolean d(int r12) {
        char[] r0 = this.I;
        int r1 = this.K;
        int r2 = this.f3547J;
    L3:
        char[] r3 = this.n.j();
        int r4 = this.n.k();
    L4:
        if (r2 < r1) goto L6;
        n(" in CDATA section");
        r0 = this.I;
        r2 = this.f3547J;
        r1 = this.K;
    L6:
        int r5 = r2 + 1;
        char r6 = r0[r2];
        if (r6 >= ' ') goto L29;
        if (r6 != '\n') goto L12;
        h(r5);
    L35:
        char[] r7 = r0;
        int r8 = r1;
        int r9 = r5;
    L36:
        int r10 = r4 + 1;
        r3[r4] = r6;
        if (r10 < r3.length) goto L45;
        com.ctc.wstx.util.l r11 = this.n;
        if (this.d == true) goto L44;
        r11.a(r3.length);
        if (r11.d() < r12) goto L44;
        this.f3547J = r9;
        return false;
    L44:
        char[] r13 = r11.l();
        a("Text size", this.O.y(), this.n.d());
        r4 = 0;
        r3 = r13;
    L46:
        r0 = r7;
        r1 = r8;
        r2 = r9;
        goto L4
    L45:
        r4 = r10;
        goto L46
    L12:
        if (r6 != '\r') goto L26;
        this.f3547J = r5;
        if (g(r6) == false) goto L22;
        if (this.Z == true) goto L23;
        int r14 = r4 + 1;
        r3[r4] = r6;
        if (r14 < r3.length) goto L20;
        r3 = this.n.l();
        r4 = 0;
        goto L23
    L20:
        r4 = r14;
    L23:
        r6 = '\n';
    L24:
        int r15 = this.f3547J;
        r9 = r15;
        r7 = this.I;
        r8 = this.K;
        goto L36
    L22:
        if (this.Z == false) goto L24;
    L26:
        if (r6 == '\t') goto L35;
        f(r6);
        goto L35
    L29:
        if (r6 != ']') goto L35;
        this.f3547J = r5;
        if (a(r3, r4) == true) goto L32;
        r2 = this.f3547J;
        r0 = this.I;
        r1 = this.K;
        goto L3
    L32:
        return true;
    }

    public void e(char r3) {
        this.v = 1;
        c();
        m(r3);
        if (this.k != null) goto L5;
        return;
    L5:
        if (b(32) == true) goto L7;
        return;
    L7:
        if (this.o.c(this.j, this.k) == false) goto L9;
        return;
    L9:
        if (this.j != null) goto L11;
        String r4 = this.k;
    L12:
        b(com.ctc.wstx.b.a.aa, r4, this.k);
        return;
    L11:
        r4 = this.j + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.k;
        goto L12
    }

    public void e(int r1) {
        e("Internal error: sub-class should override method");
    }

    public void f() {
        this.i = 0;
        this.ag = null;
        String r2 = a(m(" in xml declaration"), "version");
        if (r2 == null) goto L5;
        a(com.ctc.wstx.b.a.z, r2, "version");
    L5:
        char r3 = a("version", " in xml declaration");
        com.ctc.wstx.util.l r4 = this.n;
        r4.c();
        a("version", r3, r4);
        if (r4.a("1.0") == false) goto L9;
        this.ah = 256;
        this.H = false;
    L12:
        char r0 = m(" in xml declaration");
        if (r0 != '?') goto L15;
    L34:
        if (r0 == '?') goto L36;
        a(r0, " in xml declaration; expected '?>' as the end marker");
    L36:
        char r1 = k(" in xml declaration");
        if (r1 == '>') goto L40;
        a(r1, " in xml declaration; expected '>' to close the declaration");
        return;
    L40:
        return;
    L15:
        if (r0 != 'e') goto L20;
        String r5 = a(r0, "encoding");
        if (r5 == null) goto L19;
        a(com.ctc.wstx.b.a.z, r5, "encoding");
    L19:
        char r6 = a("encoding", " in xml declaration");
        r4.b();
        a("encoding", r6, r4);
        this.ag = r4.toString();
        r0 = m(" in xml declaration");
    L22:
        if (r0 != 's') goto L34;
        String r7 = a(r0, "standalone");
        if (r7 == null) goto L26;
        a(com.ctc.wstx.b.a.z, r7, "standalone");
    L26:
        char r8 = a("standalone", " in xml declaration");
        r4.b();
        a("standalone", r8, r4);
        if (r4.a("yes") == false) goto L30;
        this.i = 1;
    L33:
        r0 = m(" in xml declaration");
        goto L34
    L30:
        if (r4.a("no") == false) goto L32;
        this.i = 2;
        goto L33
    L32:
        e("Unexpected xml 'standalone' pseudo-attribute value '" + r4.toString() + "'; expected 'yes' or 'no'");
        goto L33
    L20:
        if (r0 == 's') goto L22;
        a(r0, " in xml declaration; expected either 'encoding' or 'standalone' pseudo-attribute");
        goto L22
    L9:
        if (r4.a(BuildConfig.VERSION_NAME) == false) goto L11;
        this.ah = 272;
        this.H = true;
        goto L12
    L11:
        this.ah = 0;
        this.H = false;
        e("Unexpected xml version '" + r4.toString() + "'; expected '1.0' or '" + BuildConfig.VERSION_NAME + "'");
        goto L12
    }

    public final boolean f(char r4) {
        if (r4 <= ' ') goto L7;
        return false;
    L7:
        if (r4 != '\n') goto L9;
    L15:
        g(r4);
    L17:
        if (this.f3547J >= this.K) goto L19;
    L21:
        r4 = this.I[this.f3547J];
        if (r4 > ' ') goto L23;
        this.f3547J++;
        goto L7
    L23:
        return true;
    L19:
        if (e() == true) goto L21;
        return true;
    L9:
        if (r4 == '\r') goto L15;
        if (r4 == ' ') goto L17;
        if (r4 == '\t') goto L17;
        f(r4);
        goto L17
    }

    public final void g() {
        this.r = 4;
        if (this.o.h() == false) goto L7;
        o();
        return;
    L7:
        if (this.f3547J >= this.K) goto L9;
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r2 = r0[r1];
    L11:
        if (a(r2) == true) goto L16;
        if (r2 == ':') goto L16;
        if (r2 > ' ') goto L15;
        a(r2, "; missing element name?");
    L15:
        a(r2, "; expected an element name.");
    L16:
        String r3 = this.o.j();
        String r5 = this.o.k();
        boolean r6 = false;
        if (r3 != null) goto L19;
    L42:
        int r7 = r5.length();
        int r8 = 0;
    L44:
        if (r2 != r5.charAt(r8)) goto L45;
        r8 = r8 + 1;
        int r4 = this.f3547J;
        if (r8 >= r7) goto L50;
        if (r4 < this.K) goto L74;
        r2 = k(" in end tag");
        goto L44
    L74:
        char[] r9 = this.I;
        int r10 = this.f3547J;
        this.f3547J = r10 + 1;
        r2 = r9[r10];
        goto L44
    L50:
        if (r4 >= this.K) goto L52;
        char[] r11 = this.I;
        int r12 = this.f3547J;
        this.f3547J = r12 + 1;
        char r13 = r11[r12];
    L54:
        if (r13 > ' ') goto L56;
        r13 = a(" in end tag", r13);
    L62:
        if (r13 == '>') goto L64;
        a(r13, " in end tag Expected '>'.");
    L64:
        int r14 = this.o.e();
        this.D = r14;
        if (r14 != 3) goto L67;
        r6 = true;
    L67:
        this.z = r6;
        if (this.W != this.X) goto L70;
        b(this.T);
    L70:
        this.W--;
        return;
    L56:
        if (r13 == '>') goto L62;
        if (r13 != ':') goto L60;
    L61:
        b(r3, r5, r7);
        goto L62
    L60:
        if (b(r13) == false) goto L62;
    L52:
        r13 = k(" in end tag");
        goto L54
    L45:
        b(r3, r5, r8);
        return;
    L19:
        if (r3.length() <= 0) goto L42;
        int r15 = r3.length();
        int r16 = 0;
    L22:
        if (r2 != r3.charAt(r16)) goto L23;
        r16 = r16 + 1;
        int r17 = this.f3547J;
        if (r16 >= r15) goto L28;
        if (r17 < this.K) goto L40;
        r2 = k(" in end tag");
        goto L22
    L40:
        char[] r18 = this.I;
        int r19 = this.f3547J;
        this.f3547J = r19 + 1;
        r2 = r18[r19];
        goto L22
    L28:
        if (r17 >= this.K) goto L30;
        char[] r20 = this.I;
        int r21 = this.f3547J;
        this.f3547J = r21 + 1;
        char r22 = r20[r21];
    L31:
        if (r22 == ':') goto L35;
        a(r3, r5, r16);
        return;
    L35:
        if (this.f3547J >= this.K) goto L37;
        char[] r23 = this.I;
        int r24 = this.f3547J;
        this.f3547J = r24 + 1;
        r2 = r23[r24];
        goto L42
    L37:
        r2 = k(" in end tag");
        goto L42
    L30:
        r22 = k(" in end tag");
        goto L31
    L23:
        a(r3, r5, r16);
        return;
    L9:
        r2 = k(" in end tag");
        goto L11
    }

    @Override // javax.xml.stream.e
    public int getAttributeCount() {
        if (this.w != 1) goto L7;
        return this.p.c();
    L7:
        throw new IllegalStateException(com.ctc.wstx.b.a.p);
    }

    @Override // javax.xml.stream.e
    public String getAttributeLocalName(int r3) {
        if (this.w != 1) goto L7;
        return this.p.c(r3);
    L7:
        throw new IllegalStateException(com.ctc.wstx.b.a.p);
    }

    @Override // javax.xml.stream.e
    public String getAttributeNamespace(int r3) {
        if (this.w != 1) goto L9;
        String r2 = this.p.d(r3);
        if (r2 != null) goto L10;
        return "";
    L10:
        return r2;
    L9:
        throw new IllegalStateException(com.ctc.wstx.b.a.p);
    }

    @Override // javax.xml.stream.e
    public String getAttributePrefix(int r3) {
        if (this.w != 1) goto L9;
        String r2 = this.p.b(r3);
        if (r2 != null) goto L10;
        return "";
    L10:
        return r2;
    L9:
        throw new IllegalStateException(com.ctc.wstx.b.a.p);
    }

    @Override // javax.xml.stream.e
    public String getAttributeValue(int r3) {
        if (this.w != 1) goto L7;
        return this.p.f(r3);
    L7:
        throw new IllegalStateException(com.ctc.wstx.b.a.p);
    }

    @Override // javax.xml.stream.e
    public String getCharacterEncodingScheme() {
        return this.ag;
    }

    @Override // javax.xml.stream.e
    public int getEventType() {
        int r0 = this.w;
        if (r0 == 12) goto L5;
    L10:
        return r0;
    L5:
        if (this.d == false) goto L7;
        return 4;
    L7:
        if (this.e == false) goto L10;
        return 4;
    }

    @Override // javax.xml.stream.e
    public String getLocalName() {
        int r0 = this.w;
        if (r0 == 1) goto L17;
        if (r0 == 2) goto L17;
        if (r0 != 9) goto L15;
        if (this.ak != null) goto L13;
        return this.S;
    L13:
        return this.ak.c();
    L15:
        throw new IllegalStateException("Current state not START_ELEMENT, END_ELEMENT or ENTITY_REFERENCE");
    L17:
        return this.o.k();
    }

    @Override // com.ctc.wstx.g.f
    public final javax.xml.stream.a getLocation() {
        return r();
    }

    @Override // javax.xml.stream.e
    public QName getName() {
        int r0 = this.w;
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L10;
        throw new IllegalStateException(com.ctc.wstx.b.a.q);
    L10:
        return this.o.f();
    }

    @Override // javax.xml.stream.e
    public int getNamespaceCount() {
        int r0 = this.w;
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L10;
        throw new IllegalStateException(com.ctc.wstx.b.a.q);
    L10:
        return this.o.m();
    }

    @Override // javax.xml.stream.e
    public String getNamespacePrefix(int r3) {
        int r0 = this.w;
        if (r0 != 1) goto L5;
    L9:
        String r4 = this.o.a(r3);
        if (r4 == null) goto L12;
        return r4;
    L12:
        if (this.E == false) goto L14;
        return null;
    L14:
        return "";
    L5:
        if (r0 == 2) goto L9;
        throw new IllegalStateException(com.ctc.wstx.b.a.q);
    }

    @Override // javax.xml.stream.e
    public String getNamespaceURI() {
        int r0 = this.w;
        if (r0 != 1) goto L5;
    L9:
        String r2 = this.o.i();
        if (r2 != null) goto L13;
        return "";
    L13:
        return r2;
    L5:
        if (r0 == 2) goto L9;
        throw new IllegalStateException(com.ctc.wstx.b.a.q);
    }

    @Override // javax.xml.stream.e
    public String getNamespaceURI(int r3) {
        int r0 = this.w;
        if (r0 != 1) goto L5;
    L9:
        String r2 = this.o.b(r3);
        if (r2 != null) goto L13;
        return "";
    L13:
        return r2;
    L5:
        if (r0 == 2) goto L9;
        throw new IllegalStateException(com.ctc.wstx.b.a.q);
    }

    @Override // javax.xml.stream.e
    public String getPIData() {
        if (this.w != 3) goto L10;
        if (this.r > 1) goto L8;
        h();
    L8:
        return this.n.g();
    L10:
        throw new IllegalStateException(com.ctc.wstx.b.a.r);
    }

    @Override // javax.xml.stream.e
    public String getPITarget() {
        if (this.w != 3) goto L7;
        return this.S;
    L7:
        throw new IllegalStateException(com.ctc.wstx.b.a.r);
    }

    @Override // javax.xml.stream.e
    public String getPrefix() {
        int r0 = this.w;
        if (r0 != 1) goto L5;
    L9:
        String r2 = this.o.j();
        if (r2 != null) goto L13;
        return "";
    L13:
        return r2;
    L5:
        if (r0 == 2) goto L9;
        throw new IllegalStateException(com.ctc.wstx.b.a.q);
    }

    @Override // javax.xml.stream.e
    public String getText() {
        int r0 = this.w;
        if (((1 << r0) & 6768) != 0) goto L6;
        l(r0);
    L6:
        if (this.r >= this.s) goto L9;
        h();
    L9:
        if (r0 != 9) goto L16;
        if (this.ak != null) goto L14;
        return null;
    L14:
        return this.ak.f();
    L16:
        if (r0 != 11) goto L20;
        return a();
    L20:
        return this.n.g();
    }

    @Override // javax.xml.stream.e
    public char[] getTextCharacters() {
        int r0 = this.w;
        if (((1 << r0) & 4208) != 0) goto L6;
        m(r0);
    L6:
        if (this.r >= this.s) goto L9;
        h();
    L9:
        if (r0 != 9) goto L13;
        return this.ak.i();
    L13:
        if (r0 != 11) goto L17;
        return j();
    L17:
        return this.n.f();
    }

    @Override // javax.xml.stream.e
    public int getTextLength() {
        int r0 = this.w;
        if (((1 << r0) & 4208) != 0) goto L6;
        m(r0);
    L6:
        if (this.r >= this.s) goto L9;
        h();
    L9:
        return this.n.d();
    }

    @Override // javax.xml.stream.e
    public int getTextStart() {
        int r0 = this.w;
        if (((1 << r0) & 4208) != 0) goto L6;
        m(r0);
    L6:
        if (this.r >= this.s) goto L9;
        h();
    L9:
        return this.n.e();
    }

    @Override // javax.xml.stream.e
    public String getVersion() {
        if (this.ah != 256) goto L7;
        return "1.0";
    L7:
        if (this.ah != 272) goto L10;
        return BuildConfig.VERSION_NAME;
    L10:
        return null;
    }

    public void h() {
    L8:
        e = move-exception;
        a(e);
        return;
    L3:
        if (this.w != 4) goto L5;
        boolean r0 = true;
    L6:
        c(r0);     // Catch: XMLStreamException -> L8
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // javax.xml.stream.e
    public boolean hasNext() {
        if (this.w == 8) goto L5;
    L8:
        return true;
    L5:
        if (this.v == 3) goto L8;
        return false;
    }

    public void i() {
        h("; was expecting a close tag for element <" + this.o.l() + ">");
    }

    @Override // javax.xml.stream.e
    public boolean isStandalone() {
        if (this.i == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // javax.xml.stream.e
    public final int next() {
        XMLStreamException r0 = this.B;
        if (r0 != null) goto L57;
        int r1 = this.v;
        if (r1 != 1) goto L40;
        int r2 = m();
        this.w = r2;
        if (this.r < this.s) goto L9;
    L15:
        if (r2 == 12) goto L17;
        if (r2 == 4) goto L26;
        if (r2 == 1) goto L38;
        if (r2 == 2) goto L38;
    L39:
        return r2;
    L38:
        this.t = 0;
        goto L39
    L26:
        if (this.z == true) goto L28;
    L35:
        this.t += this.n.d();
        a("Text size", this.O.y(), this.t);
        goto L39
    L28:
        if ((this.f3547J + 1) < this.K) goto L30;
    L34:
        this.o.a(this.n, false);
        goto L35
    L30:
        if (this.I[this.f3547J] != '<') goto L34;
        if (this.I[this.f3547J + 1] != '/') goto L34;
        this.o.a(this.n, true);
        goto L35
    L17:
        if (this.z == false) goto L20;
        this.o.a(this.n, false);
    L20:
        if (this.d == false) goto L22;
    L23:
        return 4;
    L22:
        if (this.e == false) goto L35;
    L9:
        if (this.f == true) goto L11;
    L14:
        c(false);
        goto L15
    L11:
        if (this.z == false) goto L15;
        if (r2 == 4) goto L14;
        if (r2 != 12) goto L15;
    L40:
        if (r1 != 0) goto L42;
        h(true);
    L50:
        return this.w;
    L42:
        if (r1 != 2) goto L47;
        if (h(false) == false) goto L50;
        this.x = 0;
        goto L50
    L47:
        if (r1 != 3) goto L52;
        this.w = k();
        goto L50
    L52:
        if (this.x != 8) goto L56;
        this.x = 0;
        return 8;
    L56:
        throw new NoSuchElementException();
    L57:
        this.B = null;
        throw r0;
    }
}
