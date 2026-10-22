package com.ctc.wstx.d;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.ctc.wstx.exc.WstxIOException;
import com.ctc.wstx.io.WstxInputLocation;
import com.ctc.wstx.util.InternCache;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;
import okio.Utf8;

/* JADX INFO: loaded from: classes2.dex */
public class ac extends ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Boolean f3464a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Boolean f3465b = null;
    String A;
    HashMap<String, String> B;
    z C;
    final m D;
    transient com.ctc.wstx.util.l E;
    final com.ctc.wstx.util.h F;
    final int c;
    final boolean d;
    final boolean e;
    HashMap<String, com.ctc.wstx.e.a> f;
    final HashMap<String, com.ctc.wstx.e.a> g;
    Set<String> h;
    HashMap<String, com.ctc.wstx.e.a> i;
    final HashMap<String, com.ctc.wstx.e.a> j;
    Set<String> k;
    boolean l;
    HashMap<String, javax.xml.stream.a.b> m;
    final HashMap<String, javax.xml.stream.a.b> n;
    boolean o;
    HashMap<String, javax.xml.stream.a> p;
    HashMap<com.ctc.wstx.util.h, com.ctc.wstx.util.h> q;
    LinkedHashMap<com.ctc.wstx.util.h, i> r;
    HashMap<String, String> s;
    aa t;
    boolean u;
    com.ctc.wstx.util.l v;
    int w;
    boolean x;
    String y;
    boolean z;

    static {
        f3464a = Boolean.FALSE;
        f3465b = Boolean.TRUE;
    }

    private ac(com.ctc.wstx.io.v r8, com.ctc.wstx.a.b r9, u r10, boolean r11, int r12) {
        this(r8, r9, true, r10, r11, r12);
        r8.a(this, this.W, 0);
    }

    private ac(com.ctc.wstx.io.v r8, com.ctc.wstx.a.b r9, boolean r10, int r11) {
        this(r8, r9, false, null, r10, r11);
    }

    private ac(com.ctc.wstx.io.v r2, com.ctc.wstx.a.b r3, boolean r4, u r5, boolean r6, int r7) {
        super(r2, r3, r4);
        this.l = false;
        this.o = false;
        this.q = null;
        this.s = null;
        this.t = null;
        this.u = false;
        this.v = null;
        this.w = 0;
        this.x = false;
        this.z = false;
        this.A = "";
        this.B = null;
        this.C = null;
        this.E = null;
        this.F = new com.ctc.wstx.util.h(null, null);
        this.ah = r7;
        this.H = r3.G();
        int r8 = r3.e();
        this.c = r8;
        if ((r8 & 524288) == 0) goto L5;
        boolean r9 = true;
    L6:
        this.d = r9;
        this.e = r6;
        this.l = false;
        this.f = null;
        this.h = null;
        this.k = null;
        this.i = null;
        if (r5 != null) goto L9;
        HashMap<String, com.ctc.wstx.e.a> r10 = null;
    L10:
        if (r10 != null) goto L12;
    L15:
        this.g = null;
    L16:
        if (r5 != null) goto L18;
        HashMap<String, com.ctc.wstx.e.a> r11 = null;
    L19:
        if (r11 != null) goto L21;
    L24:
        this.j = null;
    L25:
        if (r5 != null) goto L27;
        HashMap<String, javax.xml.stream.a.b> r12 = null;
    L28:
        if (r12 != null) goto L30;
    L33:
        this.n = null;
    L34:
        this.D = this.O.H();
        return;
    L30:
        if (r12.isEmpty() == true) goto L33;
        this.n = r12;
        goto L34
    L27:
        r12 = r5.d();
        goto L28
    L21:
        if (r11.isEmpty() == true) goto L24;
        this.j = r11;
        goto L25
    L18:
        r11 = r5.b();
        goto L19
    L12:
        if (r10.isEmpty() == true) goto L15;
        this.g = r10;
        goto L16
    L9:
        r10 = r5.c();
        goto L10
    L5:
        r9 = false;
        goto L6
    }

    private com.ctc.wstx.util.l C() {
        com.ctc.wstx.util.l r0 = this.E;
        if (r0 != null) goto L5;
        com.ctc.wstx.util.l r1 = com.ctc.wstx.util.l.a();
        this.E = r1;
        r1.c();
    L7:
        return this.E;
    L5:
        r0.b();
        goto L7
    }

    private char D() {
        if (this.f3547J >= this.K) goto L5;
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r2 = r0[r1];
    L10:
        if (r2 != 0) goto L12;
        t();
    L12:
        return r2;
    L5:
        int r3 = w();
        if (r3 >= 0) goto L9;
        return 0;
    L9:
        this.f3547J++;
        r2 = (char) r3;
        goto L10
    }

    private char E() {
    L3:
        if (this.f3547J >= this.K) goto L5;
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r2 = r0[r1];
    L7:
        if (r2 != '%') goto L8;
        G();
        goto L3
    L8:
        return r2;
    L5:
        r2 = j(n());
        goto L7
    }

    private char F() {
        if (w() != (-1)) goto L8;
        char r0 = j(n());
        if (r0 <= ' ') goto L12;
        if (r0 == '%') goto L12;
        return r0;
    L12:
        if (r0 != '%') goto L14;
        G();
    L27:
        if (this.f3547J < this.K) goto L28;
        r0 = j(n());
        goto L12
    L28:
        char[] r1 = this.I;
        int r3 = this.f3547J;
        this.f3547J = r3 + 1;
        r0 = r1[r3];
        goto L12
    L14:
        if (r0 > ' ') goto L15;
        if (r0 != '\n') goto L19;
    L25:
        g(r0);
        goto L27
    L19:
        if (r0 == '\r') goto L25;
        if (r0 == ' ') goto L27;
        if (r0 == '\t') goto L27;
        f(r0);
        goto L27
    L15:
        return r0;
    L8:
        char[] r2 = this.I;
        int r4 = this.f3547J;
        this.f3547J = r4 + 1;
        r0 = r2[r4];
        if (r0 <= ' ') goto L12;
        if (r0 == '%') goto L12;
        b(r0, "; expected a separating white space");
        goto L12
    }

    private void G() {
        if (this.x == false) goto L5;
        M();
    L5:
        z r0 = this.C;
        if (r0 == null) goto L21;
        r0.a(this.I, this.f3547J - 1);
        this.C.d();
        if (this.f3547J >= this.K) goto L10;
        char[] r1 = this.I;
        int r2 = this.f3547J;
        this.f3547J = r2 + 1;
        char r3 = r1[r2];
    L11:
        String r4 = f(r3);
    L17:
        th = move-exception;
        this.C.a(this.f3547J);
        throw th;
    L13:
        if (this.f3547J >= this.K) goto L15;
        char[] r5 = this.I;     // Catch: Throwable -> L17
        int r6 = this.f3547J;     // Catch: Throwable -> L17
        this.f3547J = r6 + 1;     // Catch: Throwable -> L17
        char r7 = r5[r6];     // Catch: Throwable -> L17
    L16:
        this.C.a(this.f3547J);
    L29:
        if (r7 == ';') goto L31;
        b(r7, "; expected ';' to end parameter entity name");
    L31:
        this.u = true;
        a(r4, true, f3465b);
        return;
    L15:
        r7 = h();     // Catch: Throwable -> L17
        goto L16
    L10:
        r3 = h();
        goto L11
    L21:
        if (this.f3547J >= this.K) goto L23;
        char[] r8 = this.I;
        int r9 = this.f3547J;
        this.f3547J = r9 + 1;
        char r10 = r8[r9];
    L24:
        r4 = f(r10);
        if (this.f3547J >= this.K) goto L27;
        char[] r11 = this.I;
        int r12 = this.f3547J;
        this.f3547J = r12 + 1;
        r7 = r11[r12];
        goto L29
    L27:
        r7 = h();
        goto L29
    L23:
        r10 = h();
        goto L24
    }

    private char H() {
        if (this.f3547J >= this.K) goto L5;
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r2 = r0[r1];
    L7:
        if (r2 != '?') goto L9;
    L15:
        return r2;
    L9:
        if (r2 == '*') goto L15;
        if (r2 == '+') goto L15;
        this.f3547J--;
        return ' ';
    L5:
        r2 = j(n());
        goto L7
    }

    private void I() {
        if (this.G == false) goto L5;
    L7:
        char r1 = a(true);
        if (r1 == 'I') goto L11;
        String r0 = String.valueOf(r1);
    L10:
        String r2 = c(r0);
    L27:
        r("Unrecognized directive '" + r2 + "'; expected either 'IGNORE' or 'INCLUDE'");
        return;
    L11:
        char r3 = h();
        if (r3 != 'G') goto L20;
        String r4 = b("NORE");
        if (r4 != null) goto L17;
        K();
        return;
    L17:
        StringBuilder r5 = new StringBuilder();
        String r6 = "IG";
    L18:
        r2 = r5.append(r6).append(r4).toString();
        goto L27
    L20:
        if (r3 != 'N') goto L26;
        r4 = b("CLUDE");
        if (r4 != null) goto L25;
        J();
        return;
    L25:
        r5 = new StringBuilder();
        r6 = "IN";
        goto L18
    L26:
        this.f3547J--;
        r0 = "I";
        goto L10
    L5:
        if (this.T != this.U) goto L7;
        r("Internal DTD subset can not use (INCLUDE/IGNORE) directives (except via external entities)");
        goto L7
    }

    private void J() {
        char r0 = a(false);
        if (r0 == '[') goto L5;
        b(r0, "; expected '[' to follow 'INCLUDE' directive");
    L5:
        this.w++;
    }

    private void K() {
        char r0 = a(false);
        if (r0 == '[') goto L5;
        b(r0, "; expected '[' to follow 'IGNORE' directive");
    L5:
        String r1 = n();
        int r3 = 1;
    L7:
        if (this.f3547J >= this.K) goto L9;
        char[] r4 = this.I;
        int r5 = this.f3547J;
        this.f3547J = r5 + 1;
        char r6 = r4[r5];
    L11:
        if (r6 < ' ') goto L13;
        if (r6 == ']') goto L24;
        if (r6 != '<') goto L7;
        if (j(r1) != '!') goto L30;
        if (j(r1) != '[') goto L30;
        r3 = r3 + 1;
    L30:
        this.f3547J--;
        goto L7
    L24:
        if (j(r1) != ']') goto L30;
        if (j(r1) != '>') goto L30;
        r3 = r3 - 1;
        if (r3 >= 1) goto L7;
        return;
    L13:
        if (r6 == '\n') goto L20;
        if (r6 == '\r') goto L20;
        if (r6 == '\t') goto L7;
        f(r6);
    L20:
        g(r6);
        goto L7
    L9:
        r6 = j(r1);
        goto L11
    }

    private void L() {
        int r0 = this.p.size();
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.p.keySet().iterator().next(), String.class, "com.obric.memorydata.plugin");
        String r3 = "";
        StringBuilder r2 = new StringBuilder().append("").append(r0).append(" referenced notation");
        if (r0 == 1) goto L6;
        r3 = "s";
    L6:
        q(r2.append(r3).append(" undefined: first one '").append(r1).append("'").toString());
    }

    private void M() {
        r("Can not have parameter entities in the internal subset, except for defining complete declarations (XML 1.0, #2.8, WFC 'PEs In Internal Subset')");
    }

    private void N() {
        char r0 = h();
        if (r0 != 'N') goto L9;
        String r1 = b("TITY");
        if (r1 != null) goto L8;
        b(true);
        return;
    L8:
        String r2 = "EN" + r1;
        this.C.a(this.f3547J);
    L17:
        p(r2);
        return;
    L9:
        this.C.a(this.f3547J);
        this.C.a("<!E");
        this.C.a(r0);
        if (r0 != 'L') goto L16;
        String r3 = b("EMENT");
        if (r3 != null) goto L15;
        P();
        return;
    L15:
        r2 = "EL" + r3;
        goto L17
    L16:
        r2 = c(ExifInterface.LONGITUDE_EAST);
        goto L17
    }

    private void O() {
        com.ctc.wstx.util.h r0 = m(F());
        org.codehaus.stax2.c r1 = r();
        LinkedHashMap<com.ctc.wstx.util.h, i> r2 = S();
        i r3 = (i) ZeusTransformUtils.preCheckCast(r2.get(r0), i.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L5;
        r3 = i.a(this.O, r1, r0);
        r2.put(r0, r3);
    L5:
        int r4 = 0;
    L6:
        char r5 = E();
        if (c(r5) == false) goto L10;
        this.f3547J--;
        r5 = a(true);
    L10:
        if (r5 == '>') goto L11;
        a(r3, r5, r4, r1);
        r4 = r4 + 1;
        goto L6
    }

    private void P() {
        com.ctc.wstx.util.h r0 = m(F());
        org.codehaus.stax2.c r1 = r();
        char r2 = F();
        int r3 = 0;
        al r7 = null;
        if (r2 != '(') goto L12;
        if (a(true) != '#') goto L7;
        r7 = a(r0, this.e);
    L29:
        r3 = 4;
    L30:
        char r4 = a(true);
        if (r4 == '>') goto L33;
        b(r4, "; expected '>' to finish the element declaration for <" + r0 + ">");
    L33:
        LinkedHashMap<com.ctc.wstx.util.h, i> r5 = S();
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5.get(r0), i.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L36;
        i r9 = i.a(this.O, r1, r0, r7, r3);
    L43:
        r5.put(r0, r9);
        return;
    L36:
        if (r6.d() == true) goto L38;
    L41:
        r9 = r6.a(r1, r7, r3);
        goto L43
    L38:
        if (this.e == false) goto L40;
        v.a(r6, r1);
        goto L41
    L40:
        return;
    L7:
        this.f3547J--;
        d r8 = a(r0, this.e, 0);
        al r10 = r8.a();
        if (r10 != null) goto L10;
        r10 = new f(e.a(r8));
    L10:
        r7 = r10;
        r3 = 1;
        goto L30
    L12:
        if (a(r2) == true) goto L14;
        b(r2, ": expected '(' to start content specification for element <" + r0 + ">");
        goto L29
    L14:
        if (r2 != 'A') goto L21;
        String r11 = b("NY");
        if (r11 == null) goto L29;
        StringBuilder r12 = new StringBuilder();
        String r13 = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
    L19:
        String r14 = r12.append(r13).append(r11).toString();
    L27:
        r("Unrecognized DTD content spec keyword '" + r14 + "' (for element <" + r0 + ">); expected ANY or EMPTY");
        goto L29
    L21:
        if (r2 != 'E') goto L26;
        r11 = b("MPTY");
        if (r11 != null) goto L25;
        r7 = ab.c();
        goto L30
    L25:
        r12 = new StringBuilder();
        r13 = ExifInterface.LONGITUDE_EAST;
        goto L19
    L26:
        this.f3547J--;
        r14 = c(String.valueOf(r2));
        goto L27
    }

    private void Q() {
        String r0 = f(F());
        boolean r1 = e(F());
        char r2 = F();
        if (r1 == false) goto L8;
        if (r2 == '\"') goto L7;
        if (r2 == '\'') goto L7;
        b(r2, "; expected a quote to start the public identifier");
    L7:
        String r7 = b(r2, n());
        r2 = a(true);
    L9:
        if (r2 == '\"') goto L15;
        if (r2 == '\'') goto L15;
        if (r1 == true) goto L14;
        b(r2, "; expected a quote to start the system identifier");
    L14:
        String r5 = null;
    L17:
        if (r2 == '>') goto L42;
        b(r2, "; expected closing '>' after NOTATION declaration");
    L42:
        URL r6 = this.T.a();     // Catch: IOException -> L39
        m r3 = this.D;
        if (r3 == null) goto L23;
        r3.a(r0, r7, r5, r6);
    L23:
        com.ctc.wstx.f.b r8 = new com.ctc.wstx.f.b(r(), r0, r7, r5, r6);
        HashMap<String, javax.xml.stream.a.b> r4 = this.n;
        if (r4 == null) goto L28;
        javax.xml.stream.a.b r9 = (javax.xml.stream.a.b) ZeusTransformUtils.preCheckCast(r4.get(r0), javax.xml.stream.a.b.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L28;
        v.a(r9, r8);
    L28:
        HashMap r10 = this.m;
        if (r10 != null) goto L31;
        r10 = new LinkedHashMap();
        this.m = r10;
    L34:
        HashMap<String, javax.xml.stream.a> r11 = this.p;
        if (r11 == null) goto L37;
        r11.remove(r0);
    L37:
        r10.put(r0, r8);
        return;
    L31:
        javax.xml.stream.a.b r12 = (javax.xml.stream.a.b) ZeusTransformUtils.preCheckCast(r10.get(r0), javax.xml.stream.a.b.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L34;
        v.a(r12, r8);
    L39:
        e = move-exception;
        throw new WstxIOException(e);
    L15:
        String r13 = a(r2, this.Z, n());
        r2 = a(true);
        r5 = r13;
        goto L17
    L8:
        r7 = null;
        goto L9
    }

    private void R() {
        this.z = true;
        char r1 = F();
        if (a(r1) == false) goto L5;
        String r2 = a(r1, false);
        String r3 = r2;
        r1 = F();
    L7:
        if (r1 != '\"') goto L9;
    L13:
        String r4 = a(r1, false, "in namespace URI");
        if ((this.c & 2048) == 0) goto L16;
        r4 = InternCache.getInstance().intern(r4);
    L16:
        char r0 = a(true);
        if (r0 == '>') goto L19;
        b(r0, "; expected '>' to end TARGETNS directive");
    L19:
        if (r3 != null) goto L22;
        this.A = r4;
        return;
    L22:
        if (this.B != null) goto L24;
        this.B = new HashMap();
    L24:
        this.B.put(r3, r4);
        return;
    L9:
        if (r1 == '\'') goto L13;
        if (r1 != '>') goto L12;
        r("Missing namespace URI for TARGETNS directive");
    L12:
        b(r1, "; expected a single or double quote to enclose the namespace URI");
        goto L13
    L5:
        r3 = null;
        goto L7
    }

    private LinkedHashMap<com.ctc.wstx.util.h, i> S() {
        LinkedHashMap<com.ctc.wstx.util.h, i> r0 = this.r;
        if (r0 != null) goto L6;
        LinkedHashMap<com.ctc.wstx.util.h, i> r1 = new LinkedHashMap();
        this.r = r1;
        return r1;
    L6:
        return r0;
    }

    private static char a(char r1, char r2) {
        if (r1 != r2) goto L5;
        return r1;
    L5:
        if (r1 != ' ') goto L7;
        return r2;
    L7:
        if (r2 != ' ') goto L10;
        return r1;
    L10:
        if (r1 == '*') goto L12;
        if (r2 == '*') goto L12;
    L12:
        return '*';
    }

    private char a(boolean r4) {
    L3:
        if (this.f3547J >= this.K) goto L5;
        char[] r0 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r2 = r0[r1];
    L7:
        if (r2 > ' ') goto L9;
        if (r2 == '\n') goto L22;
        if (r2 == '\r') goto L22;
        if (r2 == ' ') goto L3;
        if (r2 == '\t') goto L3;
        f(r2);
    L22:
        g(r2);
        goto L3
    L9:
        if (r2 != '%') goto L12;
        if (r4 == false) goto L12;
        G();
    L12:
        return r2;
    L5:
        r2 = j(n());
        goto L7
    }

    private al a(com.ctc.wstx.util.h r5, boolean r6) {
        String r0 = b("PCDATA");
        if (r0 == null) goto L5;
        r("Unrecognized directive #" + r0 + "'; expected #PCDATA (or element name)");
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
    L6:
        char r2 = a(true);
        if (r2 == ')') goto L9;
        if (r2 != '|') goto L33;
        r2 = a(true);
    L40:
        com.ctc.wstx.util.h r3 = m(r2);
        if (r1.put(r3, am.a(' ', r3)) == null) goto L6;
        if (this.e == false) goto L6;
        c("duplicate child element <" + r3 + "> in mixed content model", r5);
        goto L6
    L33:
        if (r2 != ',') goto L37;
        String r4 = " (sequences not allowed within mixed content)";
    L35:
        b(r2, r4);
        goto L40
    L37:
        if (r2 != '(') goto L39;
        r4 = " (sub-content specs not allowed within mixed content)";
        goto L35
    L39:
        r4 = "; expected either '|' to separate elements, or ')' to close the list";
        goto L35
    L9:
        if (this.f3547J >= this.K) goto L11;
        char[] r7 = this.I;
        int r8 = this.f3547J;
        this.f3547J = r8 + 1;
        char r9 = r7[r8];
    L13:
        if (r9 != '*') goto L15;
    L18:
        if (r6 == true) goto L22;
        return null;
    L22:
        if (r1.isEmpty() == true) goto L24;
        a r10 = a.a(this.P, r1.values());
        al r11 = r10.a();
        if (r11 == null) goto L28;
        return r11;
    L28:
        return new f(e.a(r10));
    L24:
        return ab.c();
    L15:
        if (r1.size() <= 0) goto L17;
        r("Missing trailing '*' after a non-empty mixed content specification");
    L17:
        this.f3547J--;
        goto L18
    L11:
        r9 = j(n());
        goto L13
    }

    private d a(com.ctc.wstx.util.h r10, boolean r11, int r12) {
        a("Maximum DTD nesting depth (WstxInputProperties.P_MAX_DTD_DEPTH)", this.O.w(), r12);
        ArrayList r0 = new ArrayList();
        boolean r2 = false;
        boolean r3 = false;
    L3:
        char r5 = a(true);
        if (r5 == ')') goto L6;
        if (r5 == '|') goto L31;
        if (r5 == ',') goto L31;
        if (r0.isEmpty() == true) goto L40;
        b(r5, " (missing separator '|' or ','?)");
    L40:
        if (r5 != '(') goto L43;
        d r4 = a(r10, r11, 1 + r12);
    L42:
        r0.add(r4);
        goto L3
    L43:
        if (r5 == '|') goto L45;
        if (r5 == ',') goto L45;
    L46:
        com.ctc.wstx.util.h r6 = m(r5);
        char r7 = H();
        if (r11 == false) goto L49;
        r4 = am.a(r7, r6);
        goto L42
    L49:
        r4 = am.e();
    L45:
        b(r5, " (missing element name?)");
    L31:
        if (r5 != '|') goto L33;
        boolean r8 = true;
    L34:
        if (r2 == true) goto L36;
        r2 = true;
        r3 = r8;
    L38:
        r5 = a(true);
        goto L40
    L36:
        if (r3 == r8) goto L38;
        r("Can not mix content spec separators ('|' and ','); need to use parenthesis groups");
        goto L38
    L33:
        r8 = false;
        goto L34
    L6:
        if (r0.isEmpty() == false) goto L8;
        r("Empty content specification for '" + r10 + "' (need at least one entry)");
    L8:
        char r13 = H();
        if (r11 == true) goto L13;
        return am.e();
    L13:
        if (r0.size() != 1) goto L18;
        d r9 = (d) ZeusTransformUtils.preCheckCast(r0.get(0), d.class, "com.obric.memorydata.plugin");
        char r14 = r9.c();
        if (r13 == r14) goto L17;
        r9.a(a(r13, r14));
    L17:
        return r9;
    L18:
        boolean r15 = this.P;
        if (r3 == false) goto L23;
        return a.a(r15, r13, r0);
    L23:
        return ai.a(r15, r13, r0);
    }

    public static u a(com.ctc.wstx.io.u r1, com.ctc.wstx.io.v r2, com.ctc.wstx.a.b r3, boolean r4, int r5) {
        ac r0 = new ac(r2, r3, r4, r5);
        r0.a(r1);
        u r6 = r0.a();     // Catch: Throwable -> L6
        r1.a(r0);
        return r6;
    L6:
        th = move-exception;
        r1.a(r0);
        throw th;
    }

    public static u a(com.ctc.wstx.io.v r7, com.ctc.wstx.a.b r8, u r9, boolean r10, int r11) {
        return new ac(r7, r8, r9, r10, r11).a();
    }

    private com.ctc.wstx.e.a a(com.ctc.wstx.io.v r8, boolean r9, String r10, char r11, javax.xml.stream.a r12) {
        javax.xml.stream.a r1 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r12, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        if (e(r11) == false) goto L15;
        char r13 = F();
        if (r13 == '\"') goto L8;
        if (r13 == '\'') goto L8;
        b(r13, "; expected a quote to start the public identifier");
    L8:
        String r14 = b(r13, n());
        char r5 = E();
        if (r5 > ' ') goto L11;
        r5 = a(true);
    L13:
        if (r5 != '>') goto L16;
        r("Unexpected end of ENTITY declaration (expected a system id after public id): trying to use an SGML DTD instead of XML one?");
    L16:
        if (r5 == '\"') goto L19;
        if (r5 == '\'') goto L19;
        b(r5, "; expected a quote to start the system identifier");
    L19:
        String r6 = a(r5, this.Z, n());
        if (r9 == false) goto L23;
        char r15 = a(true);
    L22:
        String r7 = null;
    L42:
        if (r15 == '>') goto L53;
        b(r15, "; expected closing '>'");
    L53:
        URL r3 = r8.a();     // Catch: IOException -> L50
        if (r7 != null) goto L49;
        return new com.ctc.wstx.e.d(r1, r10, r3, r14, r6);
    L49:
        return new com.ctc.wstx.e.e(r1, r10, r3, r14, r6, r7);
    L50:
        e = move-exception;
        throw new WstxIOException(e);
    L23:
        int r16 = w();
        if (r16 != 62) goto L26;
        this.f3547J++;
        r15 = '>';
    L34:
        if (r15 == '>') goto L22;
        if (a(r15) == true) goto L38;
        b(r15, "; expected either NDATA keyword, or closing '>'");
    L38:
        String r17 = b("DATA");
        if (r17 == null) goto L41;
        r("Unrecognized keyword '" + r17 + "'; expected NOTATION (or closing '>')");
    L41:
        r7 = a(F(), null, r1);
        r15 = a(true);
        goto L42
    L26:
        if (r16 >= 0) goto L29;
    L27:
        r15 = a(true);
        goto L34
    L29:
        if (r16 != 37) goto L31;
        r15 = E();
        goto L34
    L31:
        this.f3547J++;
        char r18 = (char) r16;
        if (c(r18) == true) goto L27;
        b(r18, "; expected a separating space or closing '>'");
        goto L27
    L11:
        if (r5 == '>') goto L13;
        this.f3547J--;
        r5 = F();
        goto L13
    L15:
        r5 = F();
        r14 = null;
        goto L16
    }

    private com.ctc.wstx.util.h a(String r4, String r5) {
        HashMap<com.ctc.wstx.util.h, com.ctc.wstx.util.h> r0 = this.q;
        if (r0 != null) goto L5;
        r0 = new HashMap();
        this.q = r0;
    L8:
        com.ctc.wstx.util.h r3 = new com.ctc.wstx.util.h(r4, r5);
        r0.put(r3, r3);
        return r3;
    L5:
        com.ctc.wstx.util.h r6 = this.F;
        r6.a(r4, r5);
        com.ctc.wstx.util.h r7 = (com.ctc.wstx.util.h) ZeusTransformUtils.preCheckCast(r0.get(r6), com.ctc.wstx.util.h.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L8;
        return r7;
    }

    private com.ctc.wstx.util.o a(i r8, com.ctc.wstx.util.h r9, boolean r10) {
        TreeSet r0 = new TreeSet();
        char r2 = a(true);
        if (r2 != ')') goto L5;
        b(r2, " (empty list; missing identifier(s))?");
    L5:
        if (r10 == false) goto L7;
        HashMap<String, String> r4 = null;
    L11:
        if (r10 == false) goto L13;
        String r3 = a(r2, r9, r8.c());
    L14:
        r0.add(r3);
    L15:
        char r5 = a(true);
        if (r5 == ')') goto L18;
        if (r5 == '|') goto L22;
        b(r5, "; missing '|' separator?");
    L22:
        char r6 = a(true);
        if (r10 == false) goto L25;
        String r7 = a(r6, r9, r8.c());
    L27:
        if (r0.add(r7) == true) goto L15;
        if (this.e == false) goto L15;
        a("Duplicate enumeration value '" + r7 + "'", r8, r9);
        goto L15
    L25:
        r7 = a(r6, r4);
        goto L27
    L18:
        return com.ctc.wstx.util.o.a(r0);
    L13:
        r3 = a(r2, r4);
        goto L14
    L7:
        r4 = this.s;
        if (r4 != null) goto L11;
        if (r10 == true) goto L11;
        r4 = new HashMap();
        this.s = r4;
        goto L11
    }

    private String a(char r3, com.ctc.wstx.util.h r4, javax.xml.stream.a r5) {
        javax.xml.stream.a r6 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r5, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        String r7 = f(r3);
        HashMap<String, javax.xml.stream.a.b> r8 = this.n;
        if (r8 == null) goto L8;
        javax.xml.stream.a.b r9 = (javax.xml.stream.a.b) ZeusTransformUtils.preCheckCast(r8.get(r7), javax.xml.stream.a.b.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L8;
        this.o = true;
        return r9.b();
    L8:
        HashMap<String, javax.xml.stream.a.b> r10 = this.m;
        if (r10 != null) goto L11;
        javax.xml.stream.a.b r11 = null;
    L12:
        if (r11 != null) goto L21;
        if (this.e == true) goto L16;
    L19:
        return r7;
    L16:
        if (this.p != null) goto L18;
        this.p = new LinkedHashMap();
    L18:
        this.p.put(r7, r6);
        goto L19
    L21:
        return r11.b();
    L11:
        r11 = (javax.xml.stream.a.b) ZeusTransformUtils.preCheckCast(r10.get(r7), javax.xml.stream.a.b.class, "com.obric.memorydata.plugin");
        goto L12
    }

    private String a(char r3, HashMap<String, String> r4) {
        String r2 = l(r3);
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.get(r2), String.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        r4.put(r2, r2);
        return r2;
    L6:
        return r5;
    }

    private String a(char r1, boolean r2) {
        if (r2 == false) goto L7;
        if (a(r1) == true) goto L7;
        b(r1, "; expected an identifier");
    L7:
        return h(r1);
    }

    private String a(Object r2) {
        return "Element <" + r2 + ">)";
    }

    private String a(Object r2, com.ctc.wstx.util.h r3) {
        return "Attribute '" + r3 + "' (of element <" + r2 + ">)";
    }

    private void a(aa r17, char r18, com.ctc.wstx.util.h r19, javax.xml.stream.a r20, boolean r21) {
        javax.xml.stream.a r4 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r20, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        if (r18 != '\"') goto L5;
    L10:
        com.ctc.wstx.io.v r5 = this.T;
        com.ctc.wstx.util.l r6 = this.v;
        if (r6 != null) goto L13;
        r6 = com.ctc.wstx.util.l.a();
    L13:
        r6.c();
        char[] r7 = r6.j();
        int r8 = r7.length;
        int r10 = 0;
    L15:
        if (this.f3547J >= this.K) goto L17;
    L25:
        char[] r11 = this.I;
        int r12 = this.f3547J;
        this.f3547J = r12 + 1;
        char r13 = r11[r12];
        if (r13 >= '?') goto L42;
        if (r13 <= ' ') goto L30;
        if (r13 == r18) goto L45;
        if (r13 != '&') goto L69;
        if (u() < 3) goto L53;
        int r9 = e(true);
    L54:
        if (r9 == 0) goto L55;
        int r14 = 0;
        if (r9 > 65535) goto L66;
        char r15 = (char) r9;
    L64:
        r13 = r15;
    L72:
        if (r10 < r8) goto L74;
        r7 = r6.l();
        r8 = r7.length;
        r10 = r14;
    L74:
        r7[r10] = r13;
        r10 = r10 + 1;
        goto L15
    L66:
        if (r10 < r7.length) goto L68;
        r7 = r6.l();
        r10 = 0;
    L68:
        int r16 = r9 - 65536;
        r7[r10] = (char) ((r16 >> 10) + 55296);
        r15 = (char) ((r16 & 1023) + Utf8.LOG_SURROGATE_HEADER);
        r10 = r10 + 1;
        goto L64
    L55:
        String r22 = j(j(" in entity reference"));
        this.t = r17;     // Catch: Throwable -> L58
        this.u = false;     // Catch: Throwable -> L58
        a(r22, false, f3464a);     // Catch: Throwable -> L58
        this.t = null;
    L58:
        th = move-exception;
        this.t = null;
        throw th;
    L53:
        r9 = f(true);
        goto L54
    L69:
        r14 = 0;
        if (r13 != '<') goto L72;
        b(r13, " in attribute default value");
        goto L72
    L45:
        if (this.T != r5) goto L42;
        r6.a(r10);
        r17.a(r6.g());
        this.v = r6;
        return;
    L30:
        if (r13 != '\n') goto L33;
    L31:
        y();
    L41:
        r13 = ' ';
        goto L42
    L33:
        if (r13 == '\r') goto L35;
        if (r13 == ' ') goto L41;
        if (r13 == '\t') goto L41;
        f(r13);
        goto L41
    L35:
        if (j(" in attribute default value") == '\n') goto L31;
        this.f3547J--;
        boolean r23 = this.Z;
    L42:
        r14 = 0;
        goto L72
    L17:
        if (this.T != r5) goto L19;
        boolean r110 = true;
    L20:
        n(n());
        if (r110 == false) goto L25;
        if (this.T == r5) goto L25;
        r("Unterminated attribute default value for attribute '" + r19 + "' (definition started at " + r4 + ")");
        goto L25
    L19:
        r110 = false;
        goto L20
    L5:
        if (r18 == '\'') goto L10;
        String r24 = "; expected a single or double quote to enclose the default value";
        if (r21 == true) goto L9;
        r24 = "; expected a single or double quote to enclose the default value, or one of keywords (#REQUIRED, #IMPLIED, #FIXED)";
    L9:
        b(r18, r24 + " (for attribute '" + r19 + "')");
        goto L10
    }

    private void a(i r17, char r18, int r19, javax.xml.stream.a r20) {
        javax.xml.stream.a r9 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r20, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        com.ctc.wstx.util.h r10 = m(r18);
        char r0 = F();
        if (r0 != '(') goto L5;
        com.ctc.wstx.util.o r14 = a(r17, r10, false);
        int r6 = 1;
    L47:
        char r2 = F();
        if (r2 != '#') goto L61;
        String r1 = f(E());
        if (r1 != "REQUIRED") goto L53;
        aa r3 = aa.b();
    L58:
        aa r15 = r3;
    L62:
        if (r6 != 2) goto L69;
        if (r15.i() == false) goto L69;
        if (this.e == false) goto L74;
        a("has type ID; can not have a default (or #FIXED) value (XML 1.0/#3.3.1)", r17, r10);
    L74:
        if (r10.a(this.P, "space") == false) goto L77;
        a(r6, r14);
    L77:
        if (this.P == true) goto L79;
    L84:
        g r4 = r17.a(this, r10, r6, r15, r14, this.e);
    L85:
        if (r4 != null) goto L90;
        javax.xml.stream.c r5 = this.O.z();
        if (r5 == null) goto L95;
        b(r5, com.ctc.wstx.b.a.c, MessageFormat.format(com.ctc.wstx.b.a.l, new Object[]{r10, r17}), r9);
        return;
    L95:
        return;
    L90:
        if (r15.i() == false) goto L97;
        r4.i();
        if (this.e == false) goto L98;
        r4.a(this, true);
        return;
    L98:
        return;
    L97:
        return;
    L79:
        if (r10.c() == false) goto L84;
        if (r15.i() == true) goto L83;
        return;
    L83:
        r4 = r17.a(this, r10, r6, r15, this.e);
    L69:
        if (this.O.j() == false) goto L74;
        if (r10.a(this.P, OaidModel.KEY_ID) == false) goto L74;
        b(r6);
        goto L74
    L53:
        if (r1 != "IMPLIED") goto L56;
        r3 = aa.a();
        goto L58
    L56:
        if (r1 != "FIXED") goto L59;
        aa r16 = aa.c();
        a(r16, F(), r10, r9, true);
        r3 = r16;
        goto L58
    L59:
        a("Unrecognized attribute default value directive #" + r1 + com.ctc.wstx.b.a.P, r17, r10);
        return;
    L61:
        r15 = aa.d();
        a(r15, r2, r10, r9, false);
        goto L62
    L5:
        String r7 = f(r0);
        char r8 = r7.charAt(0);
        if (r8 == 'C') goto L43;
        if (r8 == 'E') goto L36;
        if (r8 == 'I') goto L27;
        if (r8 == 'N') goto L15;
    L45:
        a("Unrecognized attribute type '" + r7 + "'" + com.ctc.wstx.b.a.O, r17, r10);
    L46:
        r14 = null;
        r6 = 0;
        goto L47
    L15:
        if (r7 != "NOTATION") goto L21;
        char r11 = F();
        if (r11 == '(') goto L19;
        b(r11, "Excepted '(' to start the list of NOTATION ids");
    L19:
        r6 = 7;
        r14 = a(r17, r10, true);
        goto L47
    L21:
        if (r7 != "NMTOKEN") goto L24;
        int r12 = 8;
    L38:
        r6 = r12;
        r14 = null;
        goto L47
    L24:
        if (r7 != "NMTOKENS") goto L45;
        r12 = 9;
        goto L38
    L27:
        if (r7 != "ID") goto L30;
        r14 = null;
        r6 = 2;
        goto L47
    L30:
        if (r7 != "IDREF") goto L33;
        r12 = 3;
        goto L38
    L33:
        if (r7 != "IDREFS") goto L45;
        r12 = 4;
        goto L38
    L36:
        if (r7 != "ENTITY") goto L40;
        r12 = 5;
        goto L38
    L40:
        if (r7 != "ENTITIES") goto L45;
        r12 = 6;
        goto L38
    L43:
        if (r7 != "CDATA") goto L45;
        goto L45
    }

    private void a(com.ctc.wstx.io.v r3, String r4, javax.xml.stream.a r5) {
        javax.xml.stream.a r6 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r5, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        if (this.T != r3) goto L5;
        boolean r0 = true;
    L6:
        n(n());
        if (r0 == true) goto L9;
        return;
    L9:
        if (this.T == r3) goto L13;
        r("Unterminated entity value for entity '" + r4 + "' (definition started at " + r6 + ")");
        return;
    L13:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private void a(String r2, i r3, com.ctc.wstx.util.h r4) {
        r(a(r3, r4) + ": " + r2);
    }

    private char[] a(String r11, javax.xml.stream.a r12, char r13) {
        javax.xml.stream.a r14 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r12, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        com.ctc.wstx.io.v r0 = this.T;
        com.ctc.wstx.util.l r1 = this.v;
        if (r1 != null) goto L5;
        r1 = com.ctc.wstx.util.l.a();
    L5:
        r1.c();
        char[] r2 = r1.j();
        int r3 = r1.k();
    L7:
        if (this.f3547J < this.K) goto L9;
        a(r0, r11, r14);
    L9:
        char[] r4 = this.I;
        int r5 = this.f3547J;
        this.f3547J = r5 + 1;
        char r6 = r4[r5];
        int r7 = 0;
        if (r6 >= '?') goto L81;
        boolean r8 = true;
        if (r6 == r13) goto L15;
        if (r6 == '&') goto L23;
        if (r6 == '%') goto L59;
        if (r6 >= ' ') goto L81;
        if (r6 != '\n') goto L65;
        y();
        goto L81
    L65:
        if (r6 != '\r') goto L78;
        if (g(r6) == false) goto L75;
        if (this.Z == false) goto L71;
    L76:
        r6 = '\n';
        goto L81
    L71:
        if (r3 < r2.length) goto L73;
        r2 = r1.l();
        r3 = 0;
    L73:
        r2[r3] = r6;
        r3 = r3 + 1;
        goto L76
    L75:
        if (this.Z == false) goto L81;
    L78:
        if (r6 == '\t') goto L81;
        f(r6);
        goto L81
    L59:
        G();
        goto L7
    L23:
        int r9 = f(false);
        if (r9 == 0) goto L33;
        if (r9 > 65535) goto L29;
        r6 = (char) r9;
        goto L81
    L29:
        if (r3 < r2.length) goto L31;
        r2 = r1.l();
        r3 = 0;
    L31:
        int r10 = r9 - 65536;
        r2[r3] = (char) ((r10 >> 10) + 55296);
        r6 = (char) ((r10 & 1023) + Utf8.LOG_SURROGATE_HEADER);
        r3 = r3 + 1;
    L33:
        if (r3 < r2.length) goto L35;
        r2 = r1.l();
        r3 = 0;
    L35:
        r3 = r3 + 1;
        r2[r3] = r6;
        if (this.f3547J < this.K) goto L38;
        a(r0, r11, r14);
    L38:
        char[] r15 = this.I;
        int r16 = this.f3547J;
        this.f3547J = r16 + 1;
        r6 = r15[r16];
        if (r6 == ';') goto L40;
        if (r8 == false) goto L47;
        if (a(r6) == true) goto L44;
        r8 = false;
    L50:
        if (r6 == ':') goto L52;
    L54:
        if (r8 == false) goto L56;
        b(r6, "; expected entity name after '&'");
    L56:
        b(r6, "; expected semi-colon after entity name");
        goto L33
    L52:
        if (this.P == true) goto L54;
    L44:
        r8 = false;
        goto L33
    L47:
        if (b(r6) == false) goto L50;
    L40:
        r3 = r3;
        goto L81
    L15:
        if (this.T != r0) goto L81;
        r1.a(r3);
        char r17 = a(true);
        if (r17 == '>') goto L19;
        b(r17, "; expected closing '>' after ENTITY declaration");
    L19:
        char[] r18 = r1.h();
        this.v = r1;
        return r18;
    L81:
        if (r3 < r2.length) goto L83;
        r2 = r1.l();
    L84:
        r3 = r7 + 1;
        r2[r7] = r6;
        goto L7
    L83:
        r7 = r3;
        goto L84
    }

    private void b(int r3, String r4) {
        if (r4 != null) goto L4;
        a(r3, n());
    L4:
        a(r3, n() + r4);
    }

    private void b(String r2, Object r3) {
        a(r2, r3, null);
    }

    private void b(javax.xml.stream.c r2, String r3, String r4, javax.xml.stream.a r5) {
        javax.xml.stream.c r1 = (javax.xml.stream.c) ZeusTransformUtils.wrapperContextForParams(r2, javax.xml.stream.c.class, "com.obric.memorydata.plugin");
        javax.xml.stream.a r6 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r5, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.a(r4, r3, new org.codehaus.stax2.validation.e(r6, r4, 1, r3), r6);
        return;
    }

    private void b(boolean r12) {
        char r0 = h();
        boolean r1 = false;
        boolean r3 = false;
    L4:
        if (r0 != '%') goto L21;
        char r4 = D();
        if (r4 == 0) goto L15;
        if (c(r4) == true) goto L15;
        if (a(r4) == true) goto L13;
        b(r4, "; expected a space (for PE declaration) or PE reference name");
    L13:
        this.f3547J--;
        G();
        r0 = i();
    L86:
        r3 = true;
    L15:
        if (r4 != '\n') goto L17;
    L18:
        g(r4);
    L19:
        r1 = true;
    L22:
        if (r3 == true) goto L24;
        b(r0, "; expected a space separating ENTITY keyword and entity name");
    L24:
        if (r1 == false) goto L26;
        r0 = a(true);
    L26:
        if (r12 == false) goto L29;
        if (r1 == true) goto L29;
        this.C.a(this.f3547J);
        this.C.a("<!ENTITY ");
        this.C.a(r0);
    L29:
        String r2 = f(r0);
        org.codehaus.stax2.c r5 = r();
        char r9 = F();     // Catch: Throwable -> L80
        if (r9 != '\'') goto L33;
    L39:
        h();     // Catch: Throwable -> L80
        WstxInputLocation r10 = p();     // Catch: Throwable -> L80
        this.f3547J--;     // Catch: Throwable -> L80
        com.ctc.wstx.e.a r6 = new com.ctc.wstx.e.c(r5, r2, q(), a(r2, r10, r9), r10);     // Catch: IOException -> L77 Throwable -> L80
    L42:
        if (this.G == false) goto L44;
        r6.a();     // Catch: Throwable -> L80
    L44:
        if (r12 == false) goto L47;
        if (r1 == false) goto L47;
        this.C.a(this.f3547J);
    L47:
        if (r1 == false) goto L51;
        HashMap r13 = this.f;
        if (r13 != null) goto L55;
        r13 = new HashMap();
        this.f = r13;
    L55:
        if (r13.size() <= 0) goto L65;
        Object r7 = r13.get(r2);
        if (r7 == null) goto L65;
        javax.xml.stream.c r14 = this.O.z();
        if (r14 == null) goto L67;
        String r8 = " entity '" + r2 + "' defined more than once: first declaration at " + ((com.ctc.wstx.e.a) ZeusTransformUtils.preCheckCast(r7, com.ctc.wstx.e.a.class, "com.obric.memorydata.plugin")).m();
        if (r1 == false) goto L63;
        StringBuilder r11 = new StringBuilder();
        String r15 = "Parameter";
    L64:
        b(r14, com.ctc.wstx.b.a.f3451a, r11.append(r15).append(r8).toString(), r5);
        goto L67
    L63:
        r11 = new StringBuilder();
        r15 = "General";
    L67:
        if (this.D != null) goto L69;
        return;
    L69:
        if (r6.k() == true) goto L98;
        this.D.a(r2, r6.e(), r6.g(), r6.d(), this.T.a());
        return;
    L73:
        e = move-exception;
        throw new WstxIOException(e);
    L98:
        return;
    L65:
        r13.put(r2, r6);
        goto L67
    L51:
        r13 = this.i;
        if (r13 != null) goto L55;
        r13 = new LinkedHashMap();
        this.i = r13;
    L77:
        e = move-exception;
        throw new WstxIOException(e);     // Catch: Throwable -> L80
    L33:
        if (r9 == '\"') goto L39;
        if (a(r9) == true) goto L38;
        b(r9, "; expected either quoted value, or keyword 'PUBLIC' or 'SYSTEM'");     // Catch: Throwable -> L80
    L38:
        r6 = a(this.T, r1, r2, r9, r5);     // Catch: Throwable -> L80
    L80:
        th = move-exception;
        if (r12 == false) goto L84;
        if (r1 == false) goto L84;
        this.C.a(this.f3547J);
    L84:
        throw th;
    L17:
        if (r4 != '\r') goto L19;
    L21:
        if (c(r0) == false) goto L22;
        r0 = h();
        goto L86
    }

    private void c(String r2, Object r3) {
        r(a(r3) + ": " + r2);
    }

    private String d(com.ctc.wstx.io.v r2) {
        return "Entity &" + r2.i() + ";";
    }

    private boolean e(char r4) {
        if (r4 != 'P') goto L11;
        String r5 = b("UBLIC");
        if (r5 != null) goto L8;
        return true;
    L8:
        StringBuilder r1 = new StringBuilder();
        String r2 = com.tom_roush.pdfbox.pdmodel.a.d.i.m;
    L9:
        String r6 = r1.append(r2).append(r5).toString();
    L20:
        r("Unrecognized keyword '" + r6 + "'; expected 'PUBLIC' or 'SYSTEM'");
        return false;
    L11:
        if (r4 != 'S') goto L17;
        r5 = b("YSTEM");
        if (r5 != null) goto L15;
        return false;
    L15:
        r1 = new StringBuilder();
        r2 = "S";
        goto L9
    L17:
        if (a(r4) == true) goto L19;
        b(r4, "; expected 'PUBLIC' or 'SYSTEM' keyword");
    L19:
        r6 = c(String.valueOf(r4));
        goto L20
    }

    private String f(char r2) {
        if (a(r2) == true) goto L6;
        b(r2, "; expected an identifier");
    L6:
        return i(r2);
    }

    private String l(char r7) {
        char[] r0 = i(64);
        int r1 = r0.length;
        int r3 = 0;
    L4:
        if (b(r7) == false) goto L6;
    L10:
        if (r3 < r1) goto L12;
        r0 = a(r0);
        r1 = r0.length;
    L12:
        int r4 = r3 + 1;
        r0[r3] = r7;
        if (this.f3547J < this.K) goto L14;
        r7 = D();
        r3 = r4;
        if (r7 != 0) goto L4;
    L18:
        return new String(r0, 0, r3);
    L14:
        char[] r8 = this.I;
        int r5 = this.f3547J;
        this.f3547J = r5 + 1;
        r7 = r8[r5];
        r3 = r4;
        goto L4
    L6:
        if (r7 == ':') goto L10;
        if (r3 != 0) goto L9;
        b(r7, "; expected a NMTOKEN character to start a NMTOKEN");
    L9:
        this.f3547J--;
        goto L18
    }

    private com.ctc.wstx.util.h m(char r4) {
        String r1 = null;
        if (this.P == true) goto L5;
        String r5 = i(r4);
    L13:
        return a(r1, r5);
    L5:
        r5 = h(r4);
        char r0 = D();
        if (r0 == 0) goto L13;
        if (r0 != ':') goto L11;
        r1 = r5;
        r5 = h(h());
        goto L13
    L11:
        this.f3547J--;
        goto L13
    }

    private void n(char r5) {
        this.W = 1;
        if (r5 != 'A') goto L12;
        String r6 = b("TTLIST");     // Catch: Throwable -> L9
        if (r6 != null) goto L7;
        this.y = "ATTLIST";     // Catch: Throwable -> L9
        O();     // Catch: Throwable -> L9
    L43:
        if (this.T.j() <= 0) goto L45;
        b(this.T);     // Catch: Throwable -> L9
    L45:
        this.W = 0;
        this.y = null;
        return;
    L7:
        StringBuilder r7 = new StringBuilder().append(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).append(r6);     // Catch: Throwable -> L9
    L8:
        String r8 = r7.toString();     // Catch: Throwable -> L9
    L41:
        p(r8);     // Catch: Throwable -> L9
        goto L43
    L12:
        if (r5 != 'E') goto L27;
        char r9 = h();     // Catch: Throwable -> L9
        if (r9 != 'N') goto L20;
        String r10 = b("TITY");     // Catch: Throwable -> L9
        if (r10 != null) goto L18;
        this.y = "ENTITY";     // Catch: Throwable -> L9
        b(false);     // Catch: Throwable -> L9
        goto L43
    L18:
        r7 = new StringBuilder().append("EN").append(r10);     // Catch: Throwable -> L9
        goto L8
    L20:
        if (r9 != 'L') goto L25;
        String r11 = b("EMENT");     // Catch: Throwable -> L9
        if (r11 != null) goto L24;
        this.y = "ELEMENT";     // Catch: Throwable -> L9
        P();     // Catch: Throwable -> L9
        goto L43
    L24:
        r7 = new StringBuilder().append("EL").append(r11);     // Catch: Throwable -> L9
        goto L8
    L25:
        String r12 = ExifInterface.LONGITUDE_EAST + r9;     // Catch: Throwable -> L9
    L26:
        r8 = c(r12);     // Catch: Throwable -> L9
        goto L41
    L27:
        if (r5 != 'N') goto L33;
        String r13 = b("OTATION");     // Catch: Throwable -> L9
        if (r13 != null) goto L31;
        this.y = "NOTATION";     // Catch: Throwable -> L9
        Q();     // Catch: Throwable -> L9
        goto L43
    L31:
        r7 = new StringBuilder().append("N").append(r13);     // Catch: Throwable -> L9
        goto L8
    L33:
        if (r5 == 'T') goto L35;
    L40:
        r12 = String.valueOf(r5);     // Catch: Throwable -> L9
        goto L26
    L35:
        if (this.d == false) goto L40;
        String r14 = b("ARGETNS");     // Catch: Throwable -> L9
        if (r14 != null) goto L39;
        this.y = "TARGETNS";     // Catch: Throwable -> L9
        R();     // Catch: Throwable -> L9
        goto L43
    L39:
        r7 = new StringBuilder().append(ExifInterface.GPS_DIRECTION_TRUE).append(r14);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.W = 0;
        this.y = null;
        throw th;
    }

    private void p(String r3) {
        String r4 = "Unrecognized DTD directive '<!" + r3 + " >'; expected ATTLIST, ELEMENT, ENTITY or NOTATION";
        if (this.d == false) goto L5;
        r4 = r4 + " (or, for DTD++, TARGETNS)";
    L5:
        r(r4);
    }

    private void q(String r2) {
        if (this.e == false) goto L5;
        int r0 = 2;
    L6:
        a(r2, r0);
        return;
    L5:
        r0 = 1;
        goto L6
    }

    private void r(String r1) {
        e(r1);
    }

    public u a() {
    L2:
        boolean r0 = false;
        this.x = false;
        int r1 = x();
        if (r1 >= 0) goto L9;
        if (this.G == true) goto L28;
        h(" in internal DTD subset");
    L28:
        int r2 = this.w;
        if (r2 <= 0) goto L34;
        if (r2 != 1) goto L32;
        String r3 = "an INCLUDE block";
    L33:
        h(n() + "; expected closing marker for " + r3);
        goto L34
    L32:
        r3 = "" + this.w + " INCLUDE blocks";
    L34:
        HashMap<String, javax.xml.stream.a> r4 = this.p;
        if (r4 == null) goto L40;
        if (r4.size() <= 0) goto L40;
        L();
    L40:
        if (this.G == false) goto L49;
        if (this.l == false) goto L44;
    L46:
        boolean r5 = false;
    L100:
        return v.a(r5, this.i, this.k, null, this.h, this.m, this.r, this.e);
    L44:
        if (this.o == true) goto L46;
        r5 = true;
        goto L100
    L49:
        return v.a(false, this.i, null, this.f, null, this.m, this.r, this.e);
    L9:
        if (r1 == 37) goto L10;
        this.ac = this.L + ((long) this.f3547J);
        this.ad = this.M;
        this.ae = this.f3547J - this.N;
        if (r1 == 60) goto L14;
        if (r1 != 93) goto L74;
        if (this.w != 0) goto L51;
        if (this.G == false) goto L28;
    L51:
        if (this.w <= 0) goto L74;
        z r6 = this.C;
        if (r6 != null) goto L55;
    L57:
        if (r0 == false) goto L77;
        this.C.a(this.I, this.f3547J - 1);
        this.C.d();
    L77:
        char r7 = h();     // Catch: Throwable -> L69
        if (r7 != ']') goto L66;
        r7 = h();     // Catch: Throwable -> L69
        if (r7 != '>') goto L66;
        this.w--;     // Catch: Throwable -> L69
        if (r0 == false) goto L2;
        this.C.a(this.f3547J);
    L66:
        b(r7, "; expected ']]>' to close conditional include section");     // Catch: Throwable -> L69
        if (r0 == false) goto L74;
        this.C.a(this.f3547J);
    L69:
        th = move-exception;
        if (r0 == false) goto L72;
        this.C.a(this.f3547J);
    L72:
        throw th;
    L55:
        if (r6.b() == true) goto L57;
        r0 = true;
    L74:
        if (this.G == false) goto L76;
        b(r1, "; expected a '<' to start a directive");
    L76:
        b(r1, "; expected a '<' to start a directive, or \"]>\" to end internal subset");
        goto L2
    L14:
        if (this.G == false) goto L16;
    L18:
        this.x = r0;
        if (this.C == null) goto L20;
        c();
        goto L2
    L20:
        b();
        goto L2
    L16:
        if (this.T != this.U) goto L18;
        r0 = true;
        goto L18
    L10:
        G();
        goto L2
    }

    @Override // com.ctc.wstx.d.ae
    public com.ctc.wstx.e.a a(String r4) {
        HashMap<String, com.ctc.wstx.e.a> r0 = this.j;
        if (r0 == null) goto L8;
        com.ctc.wstx.e.a r1 = (com.ctc.wstx.e.a) ZeusTransformUtils.preCheckCast(r0.get(r4), com.ctc.wstx.e.a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L8;
        return r1;
    L8:
        return (com.ctc.wstx.e.a) ZeusTransformUtils.preCheckCast(this.i.get(r4), com.ctc.wstx.e.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.ctc.wstx.d.ae, com.ctc.wstx.g.j
    public com.ctc.wstx.e.a a(String r5, Object r6) {
        if (r6 != f3465b) goto L22;
        HashMap<String, com.ctc.wstx.e.a> r7 = this.g;
        if (r7 != null) goto L7;
        com.ctc.wstx.e.a r8 = null;
    L8:
        if (r8 == null) goto L10;
        this.l = true;
        this.h = null;
    L20:
        return r8;
    L10:
        HashMap<String, com.ctc.wstx.e.a> r0 = this.f;
        if (r0 == null) goto L20;
        r8 = (com.ctc.wstx.e.a) ZeusTransformUtils.preCheckCast(r0.get(r5), com.ctc.wstx.e.a.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L20;
        if (this.l == true) goto L20;
        Set r1 = this.h;
        if (r1 != null) goto L19;
        r1 = new HashSet();
        this.h = r1;
    L19:
        r1.add(r5);
        goto L20
    L7:
        r8 = (com.ctc.wstx.e.a) ZeusTransformUtils.preCheckCast(r7.get(r5), com.ctc.wstx.e.a.class, "com.obric.memorydata.plugin");
        goto L8
    L22:
        if (r6 != f3464a) goto L41;
        HashMap<String, com.ctc.wstx.e.a> r9 = this.j;
        if (r9 != null) goto L26;
        com.ctc.wstx.e.a r10 = null;
    L27:
        if (r10 == null) goto L29;
        this.l = true;
        this.k = null;
    L39:
        return r10;
    L29:
        HashMap<String, com.ctc.wstx.e.a> r2 = this.i;
        if (r2 == null) goto L39;
        r10 = (com.ctc.wstx.e.a) ZeusTransformUtils.preCheckCast(r2.get(r5), com.ctc.wstx.e.a.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L39;
        if (this.l == true) goto L39;
        if (this.k != null) goto L38;
        this.k = new HashSet();
    L38:
        this.k.add(r5);
        goto L39
    L26:
        r10 = (com.ctc.wstx.e.a) ZeusTransformUtils.preCheckCast(r9.get(r5), com.ctc.wstx.e.a.class, "com.obric.memorydata.plugin");
        goto L27
    L41:
        throw new IllegalStateException(com.ctc.wstx.b.a.m);
    }

    public void a(int r6, com.ctc.wstx.util.o r7) {
        boolean r0 = false;
        if (r6 != 1) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L22;
        int r9 = r7.a();
        if (r9 == 1) goto L18;
        if (r9 == 2) goto L13;
    L23:
        if (r0 == true) goto L26;
        q(com.ctc.wstx.b.a.T);
        return;
    L26:
        return;
    L13:
        if (r7.a("preserve") == null) goto L23;
        if (r7.a("default") == null) goto L23;
    L16:
        r0 = true;
        goto L23
    L18:
        if (r7.a("preserve") != null) goto L16;
        if (r7.a("default") == null) goto L23;
    L22:
        r0 = r8;
        goto L23
    L5:
        r8 = false;
        goto L6
    }

    public void a(m r9) {
        m r10 = (m) ZeusTransformUtils.wrapperContextForParams(r9, m.class, "com.obric.memorydata.plugin");
        com.ctc.wstx.util.l r0 = C();
        char[] r1 = r0.j();
        int r3 = 0;
    L4:
        if (this.f3547J >= this.K) goto L6;
        char[] r4 = this.I;
        int r5 = this.f3547J;
        this.f3547J = r5 + 1;
        char r6 = r4[r5];
    L8:
        if (r6 >= ' ') goto L17;
        if (r6 != '\n') goto L11;
    L16:
        g(r6);
        r6 = '\n';
    L27:
        if (r3 < r1.length) goto L29;
        r1 = r0.l();
        r3 = 0;
    L29:
        r1[r3] = r6;
        r3 = r3 + 1;
        goto L4
    L11:
        if (r6 == '\r') goto L16;
        if (r6 == '\t') goto L27;
        f(r6);
        goto L27
    L17:
        if (r6 != '-') goto L27;
        if (h() == '-') goto L21;
        this.f3547J--;
        r6 = '-';
        goto L27
    L21:
        if (h() == '>') goto L23;
        e(com.ctc.wstx.b.a.x);
    L23:
        r0.a(r3);
        r0.a(r10);
        return;
    L6:
        r6 = h();
        goto L8
    }

    @Override // com.ctc.wstx.d.ae, com.ctc.wstx.g.j
    public void a(com.ctc.wstx.io.v r2) {
        if (r2.j() != 0) goto L6;
        r(d(r2) + ": Incomplete PE: has to fully contain a declaration (as per xml 1.0.3, section 2.8, WFC 'PE Between Declarations')");
        return;
    L6:
        if (this.e == false) goto L10;
        q(d(r2) + ": Incomplete PE: has to be fully contained in a declaration (as per xml 1.0.3, section 2.8, VC 'Proper Declaration/PE Nesting')");
        return;
    }

    @Override // com.ctc.wstx.g.j
    public void a(com.ctc.wstx.io.v r4, boolean r5, String r6) {
        z r0 = this.C;
        if (r0 == null) goto L10;
        r0.a(this.I, this.f3547J);
        this.C.d();
        super.a(r4, r5, r6);     // Catch: Throwable -> L7
        this.C.a(this.f3547J);
        return;
    L7:
        th = move-exception;
        this.C.a(this.f3547J);
        throw th;
    L10:
        super.a(r4, r5, r6);
    }

    @Override // com.ctc.wstx.g.j
    public boolean a(int r6) {
        int r0 = this.K - this.f3547J;
        if (r0 < r6) goto L5;
        return true;
    L5:
        z r2 = this.C;
        if (r2 == null) goto L18;
        r2.a(this.I, this.K);
    L18:
    L14:
        e = move-exception;
        b(e);
        return false;
    L9:
        if (this.T.a(this, r6) == false) goto L20;
        z r7 = this.C;     // Catch: IOException -> L14
        if (r7 == null) goto L13;
        r7.b(r0);     // Catch: IOException -> L14
    L13:
        return true;
    L20:
        return false;
    }

    public String b(String r7) {
        int r0 = r7.length();
        char r2 = ' ';
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L15;
        if (this.f3547J >= this.K) goto L7;
        char[] r4 = this.I;
        int r5 = this.f3547J;
        this.f3547J = r5 + 1;
        r2 = r4[r5];
    L12:
        if (r2 != r7.charAt(r3)) goto L15;
        r3 = r3 + 1;
        goto L3
    L7:
        r2 = D();
        if (r2 != 0) goto L12;
        return r7.substring(0, r3);
    L15:
        if (r3 != r0) goto L23;
        r2 = D();
        if (r2 != 0) goto L20;
        return null;
    L20:
        if (b(r2) == true) goto L23;
        this.f3547J--;
        return null;
    L23:
        StringBuilder r1 = new StringBuilder(r7.substring(0, r3));
        r1.append(r2);
    L24:
        char r8 = D();
        if (r8 == 0) goto L33;
        if (b(r8) == true) goto L34;
        if (r8 == ':') goto L34;
        this.f3547J--;
    L34:
        r1.append(r8);
    L33:
        return r1.toString();
    }

    public void b() {
        char r0 = h();
        if (r0 != '?') goto L7;
        f();
        return;
    L7:
        if (r0 == '!') goto L9;
        b(r0, "; expected '!' to start a directive");
    L9:
        char r1 = h();
        if (r1 != '-') goto L21;
        char r2 = h();
        if (r2 == '-') goto L14;
        b(r2, "; expected '-' for a comment");
    L14:
        m r3 = this.D;
        if (r3 != null) goto L17;
    L19:
        k();
        return;
    L17:
        if (r3.a() == false) goto L19;
        a(this.D);
        return;
    L21:
        if (r1 != '[') goto L24;
        I();
        return;
    L24:
        if (r1 >= 'A') goto L26;
    L28:
        b(r1, com.ctc.wstx.b.a.N);
        return;
    L26:
        if (r1 > 'Z') goto L28;
        n(r1);
    }

    public void b(int r2) {
        if (r2 == 2) goto L6;
        q(com.ctc.wstx.b.a.U);
        return;
    }

    public void b(com.ctc.wstx.io.v r2) {
        if (this.e == false) goto L6;
        r(d(r2) + ": Unbalanced PE: has to be fully contained in a declaration (as per xml 1.0.3, section 2.8, VC 'Proper Declaration/PE Nesting')");
        return;
    }

    public String c(String r4) {
        StringBuilder r0 = new StringBuilder(r4);
    L4:
        if (this.f3547J >= this.K) goto L6;
        char[] r5 = this.I;
        int r1 = this.f3547J;
        this.f3547J = r1 + 1;
        char r6 = r5[r1];
    L10:
        if (b(r6) == true) goto L16;
        if (r6 == ':') goto L16;
        this.f3547J--;
    L15:
        return r0.toString();
    L16:
        r0.append(r6);
        goto L4
    L6:
        r6 = D();
        if (r6 != 0) goto L10;
        goto L10
    }

    public void c() {
        boolean r3 = true;
        this.C.a(this.I, this.f3547J - 1);
        this.C.d();
        char r0 = h();
        if (r0 != '?') goto L7;
        this.C.a(this.f3547J);
        this.C.a("<?");
        f();
        return;
    L7:
        if (r0 == '!') goto L9;
        b(r0, com.ctc.wstx.b.a.N);
    L9:
        char r1 = h();
        if (r1 != '-') goto L25;
        char r2 = h();
        if (r2 == '-') goto L14;
        b(r2, "; expected '-' for a comment");
    L14:
        boolean r4 = this.C.a();
        if (r4 == false) goto L53;
        this.C.a(this.f3547J);
        this.C.a("<!--");
    L53:
        k();     // Catch: Throwable -> L20
        if (r4 == true) goto L55;
    L19:
        this.C.a(this.f3547J);
        return;
    L55:
        return;
    L20:
        th = move-exception;
        if (r4 == true) goto L23;
        this.C.a(this.f3547J);
    L23:
        throw th;
    L25:
        if (r1 != '[') goto L37;
        boolean r5 = this.C.b();
        if (r5 == false) goto L51;
        this.C.a(this.f3547J);
        this.C.a("<![");
    L51:
        I();     // Catch: Throwable -> L32
        if (r5 == false) goto L19;
        return;
    L32:
        th = move-exception;
        if (r5 == true) goto L35;
        this.C.a(this.f3547J);
    L35:
        throw th;
    L37:
        if (r1 == 'E') goto L39;
    L41:
        r3 = false;
    L42:
        if (r3 == false) goto L45;
        N();
        return;
    L45:
        if (r1 >= 'A') goto L47;
    L49:
        b(r1, com.ctc.wstx.b.a.N);
        return;
    L47:
        if (r1 > 'Z') goto L49;
        this.C.a(this.f3547J);
        this.C.a("<!");
        this.C.a(r1);
        n(r1);
        return;
    L39:
        if (this.C.c() == true) goto L41;
        goto L41
    }

    @Override // com.ctc.wstx.d.ae, com.ctc.wstx.g.j
    public void d(String r3) {
        q("Undeclared parameter entity '" + r3 + "'.");
        if (this.t == null) goto L8;
        WstxInputLocation r0 = p();
        if (this.u == false) goto L7;
        this.t.a(r3, r0);
        goto L8
    L7:
        this.t.b(r3, r0);
    L8:
        m r1 = this.D;
        if (r1 != null) goto L11;
        return;
    L11:
        if (this.u == false) goto L15;
        r1.a("%" + r3);
        return;
    }

    @Override // com.ctc.wstx.g.j
    public boolean d() {
        com.ctc.wstx.io.v r0 = this.T;
        z r1 = this.C;
        if (r1 == null) goto L5;
        r1.a(this.I, this.K);
    L5:
        this.L += (long) this.K;
        this.N -= this.K;
    L33:
        e = move-exception;
        throw a(e);
    L7:
        if (r0.c(this) > 0) goto L8;
        r0.f();     // Catch: IOException -> L33
        if (r0 == this.U) goto L15;
        com.ctc.wstx.io.v r2 = r0.h();
        if (r2 != null) goto L21;
        c(r0);
    L21:
        if (this.W == r0.j()) goto L23;
        a(r0);
    L23:
        this.T = r2;
        r2.b(this);
        z r3 = this.C;
        if (r3 == null) goto L26;
        r3.b(this.f3547J);
    L26:
        this.X = r2.j();
        if (this.Z == true) goto L30;
        this.Z = !r2.e();
    L30:
        if (this.f3547J < this.K) goto L31;
        r0 = r2;
        goto L5
    L31:
        return true;
    L15:
        return false;
    L8:
        z r4 = this.C;     // Catch: IOException -> L33
        if (r4 == null) goto L11;
        r4.b(this.f3547J);     // Catch: IOException -> L33
    L11:
        return true;
    }

    @Override // com.ctc.wstx.g.j
    public boolean e() {
        z r0 = this.C;
        if (r0 == null) goto L5;
        r0.a(this.I, this.K);
    L5:
        this.L += (long) this.K;
        this.N -= this.K;
    L13:
        e = move-exception;
        b(e);
        return false;
    L7:
        if (this.T.c(this) <= 0) goto L20;
        z r1 = this.C;     // Catch: IOException -> L13
        if (r1 == null) goto L19;
        r1.b(this.f3547J);     // Catch: IOException -> L13
        return true;
    L19:
        return true;
    L20:
        return false;
    }

    public void f() {
        String r0 = A();
        if (r0.length() != 0) goto L6;
        r(com.ctc.wstx.b.a.A);
    L6:
        if (r0.equalsIgnoreCase("xml") == false) goto L8;
        b(com.ctc.wstx.b.a.B, r0);
    L8:
        char r1 = h();
        if (c(r1) == true) goto L19;
        if (r1 == '?') goto L12;
    L13:
        a(r1, com.ctc.wstx.b.a.C);
    L14:
        m r14 = this.D;
        if (r14 == null) goto L60;
        String r2 = "";
    L17:
        r14.a(r0, r2);
        return;
    L60:
        return;
    L12:
        if (h() == '>') goto L14;
    L19:
        if (this.D == null) goto L21;
    L39:
        if (r1 > ' ') goto L51;
        if (r1 == '\n') goto L46;
        if (r1 == '\r') goto L46;
        if (r1 == '\t') goto L48;
        if (r1 == ' ') goto L48;
        f(r1);
    L48:
        if (this.f3547J < this.K) goto L49;
        r1 = h();
        goto L39
    L49:
        char[] r3 = this.I;
        int r4 = this.f3547J;
        this.f3547J = r4 + 1;
        r1 = r3[r4];
    L46:
        g(r1);
        goto L48
    L51:
        com.ctc.wstx.util.l r5 = C();
        char[] r9 = r5.j();
        int r11 = 0;
    L52:
        if (r1 == '?') goto L54;
        if (r1 >= ' ') goto L74;
        if (r1 == '\n') goto L72;
        if (r1 == '\r') goto L72;
        if (r1 == '\t') goto L74;
        f(r1);
    L72:
        g(r1);
        r1 = '\n';
    L74:
        if (r11 < r9.length) goto L76;
        r9 = r5.l();
        r11 = 0;
    L76:
        int r12 = r11 + 1;
        r9[r11] = r1;
        if (this.f3547J >= this.K) goto L79;
        char[] r6 = this.I;
        int r13 = this.f3547J;
        this.f3547J = r13 + 1;
        r1 = r6[r13];
    L80:
        r11 = r12;
        goto L52
    L79:
        r1 = h();
    L54:
        if (this.f3547J >= this.K) goto L56;
        char[] r7 = this.I;
        int r15 = this.f3547J;
        this.f3547J = r15 + 1;
        char r8 = r7[r15];
    L57:
        if (r8 != '?') goto L58;
        if (r11 < r9.length) goto L65;
        r9 = r5.l();
        r11 = 0;
    L65:
        r9[r11] = r8;
        r11 = r11 + 1;
        goto L54
    L58:
        if (r8 == '>') goto L59;
        this.f3547J--;
        r1 = '?';
        goto L74
    L59:
        r5.a(r11);
        r2 = r5.g();
        r14 = this.D;
        goto L17
    L56:
        r8 = h();
    L21:
        if (this.f3547J >= this.K) goto L23;
        char[] r10 = this.I;
        int r16 = this.f3547J;
        this.f3547J = r16 + 1;
        char r17 = r10[r16];
    L24:
        if (r17 == '?') goto L26;
    L32:
        if (r17 >= ' ') goto L21;
        if (r17 == '\n') goto L38;
        if (r17 == '\r') goto L38;
        if (r17 == '\t') goto L21;
        f(r17);
    L38:
        g(r17);
    L26:
        if (this.f3547J >= this.K) goto L28;
        char[] r18 = this.I;
        int r19 = this.f3547J;
        this.f3547J = r19 + 1;
        r17 = r18[r19];
    L29:
        if (r17 == '?') goto L26;
        if (r17 != '>') goto L32;
        return;
    L28:
        r17 = h();
        goto L29
    L23:
        r17 = h();
        goto L24
    }
}
