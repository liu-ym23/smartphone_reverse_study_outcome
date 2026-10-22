package com.ctc.wstx.shaded.msv_core.datatype.regexp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f3565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f3566b;
    int c;
    int d;
    ResourceBundle e;
    int f;
    int g;
    int h;
    int i;
    boolean j;
    Vector k;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3567a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3568b;

        a(int r1, int r2) {
            this.f3567a = r1;
            this.f3568b = r2;
        }
    }

    public f() {
        this.h = 0;
        this.i = 1;
        this.k = null;
        a(Locale.getDefault());
    }

    private final boolean e(int r1) {
        if ((this.d & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    private static final int f(int r3) {
        if (r3 >= 48) goto L6;
        return -1;
    L6:
        if (r3 <= 102) goto L9;
        return -1;
    L9:
        if (r3 <= 57) goto L11;
        int r0 = 65;
        if (r3 >= 65) goto L16;
        return -1;
    L16:
        if (r3 <= 70) goto L18;
        r0 = 97;
        if (r3 >= 97) goto L18;
        return -1;
    L18:
        return (r3 - r0) + 10;
    L11:
        return r3 - 48;
    }

    int A() {
        if (B() != 10) goto L135;
        int r0 = this.f;
        if (r0 == 65) goto L133;
        if (r0 == 90) goto L133;
        if (r0 != 110) goto L11;
        return 10;
    L11:
        if (r0 != 114) goto L13;
        return 13;
    L13:
        if (r0 != 120) goto L15;
        C();
        if (B() != 0) goto L129;
        if (this.f != 123) goto L116;
        int r1 = 0;
    L96:
        C();
        if (B() != 0) goto L114;
        int r2 = f(this.f);
        if (r2 < 0) goto L101;
        int r4 = r1 * 16;
        if (r1 > r4) goto L112;
        r1 = r4 + r2;
        goto L96
    L112:
        throw a("parser.descape.2", this.f3565a - 1);
    L101:
        if (this.f != 125) goto L107;
        if (r1 > 1114111) goto L105;
        return r1;
    L105:
        throw a("parser.descape.4", this.f3565a - 1);
    L107:
        throw a("parser.descape.3", this.f3565a - 1);
    L114:
        throw a("parser.descape.1", this.f3565a - 1);
    L116:
        if (B() != 0) goto L127;
        int r3 = f(this.f);
        if (r3 < 0) goto L127;
        C();
        if (B() != 0) goto L125;
        int r5 = f(this.f);
        if (r5 < 0) goto L125;
    L144:
        return r5 + (r3 * 16);
    L125:
        throw a("parser.descape.1", this.f3565a - 1);
    L127:
        throw a("parser.descape.1", this.f3565a - 1);
    L129:
        throw a("parser.descape.1", this.f3565a - 1);
    L15:
        if (r0 == 122) goto L133;
        if (r0 != 101) goto L19;
        return 27;
    L19:
        if (r0 == 102) goto L89;
        switch(r0) {
            case 116: goto L88;
            case 117: goto L63;
            case 118: goto L22;
            default: goto L140;
        };
    L22:
        C();
        if (B() != 0) goto L62;
        int r6 = f(this.f);
        if (r6 < 0) goto L62;
        C();
        if (B() != 0) goto L60;
        int r7 = f(this.f);
        if (r7 < 0) goto L60;
        int r8 = (r6 * 16) + r7;
        C();
        if (B() != 0) goto L58;
        int r9 = f(this.f);
        if (r9 < 0) goto L58;
        int r10 = (r8 * 16) + r9;
        C();
        if (B() != 0) goto L56;
        int r11 = f(this.f);
        if (r11 < 0) goto L56;
        int r12 = (r10 * 16) + r11;
        C();
        if (B() != 0) goto L54;
        int r13 = f(this.f);
        if (r13 < 0) goto L54;
        int r14 = (r12 * 16) + r13;
        C();
        if (B() != 0) goto L52;
        int r15 = f(this.f);
        if (r15 < 0) goto L52;
        int r16 = r15 + (r14 * 16);
        if (r16 > 1114111) goto L50;
        return r16;
    L50:
        throw a("parser.descappe.4", this.f3565a - 1);
    L52:
        throw a("parser.descape.1", this.f3565a - 1);
    L54:
        throw a("parser.descape.1", this.f3565a - 1);
    L56:
        throw a("parser.descape.1", this.f3565a - 1);
    L58:
        throw a("parser.descape.1", this.f3565a - 1);
    L60:
        throw a("parser.descape.1", this.f3565a - 1);
    L62:
        throw a("parser.descape.1", this.f3565a - 1);
    L63:
        C();
        if (B() != 0) goto L87;
        int r17 = f(this.f);
        if (r17 < 0) goto L87;
        C();
        if (B() != 0) goto L85;
        int r18 = f(this.f);
        if (r18 < 0) goto L85;
        int r19 = (r17 * 16) + r18;
        C();
        if (B() != 0) goto L83;
        int r20 = f(this.f);
        if (r20 < 0) goto L83;
        r3 = (r19 * 16) + r20;
        C();
        if (B() != 0) goto L81;
        r5 = f(this.f);
        if (r5 >= 0) goto L144;
    L81:
        throw a("parser.descape.1", this.f3565a - 1);
    L83:
        throw a("parser.descape.1", this.f3565a - 1);
    L85:
        throw a("parser.descape.1", this.f3565a - 1);
    L87:
        throw a("parser.descape.1", this.f3565a - 1);
    L88:
        return 9;
    L140:
        return r0;
    L89:
        return 12;
    L133:
        throw a("parser.descape.5", this.f3565a - 2);
    L135:
        throw a("parser.next.1", this.f3565a - 1);
    }

    final int B() {
        return this.g;
    }

    final void C() {
        int r0 = this.f3565a;
        if (r0 < this.c) goto L6;
        this.f = -1;
        this.g = 1;
        return;
    L6:
        String r1 = this.f3566b;
        this.f3565a = r0 + 1;
        char r2 = r1.charAt(r0);
        this.f = r2;
        int r5 = 10;
        if (this.h != 1) goto L43;
        if (r2 == '-') goto L34;
        if (r2 == '[') goto L19;
        if (r2 != '\\') goto L26;
        int r3 = this.f3565a;
        if (r3 >= this.c) goto L17;
        String r4 = this.f3566b;
        this.f3565a = r3 + 1;
        this.f = r4.charAt(r3);
    L40:
        this.g = r5;
        return;
    L17:
        throw a("parser.next.1", r3 - 1);
    L26:
        if (e.b(r2) == false) goto L32;
        int r6 = this.f3565a;
        if (r6 >= this.c) goto L32;
        char r7 = this.f3566b.charAt(r6);
        if (e.a(r7) == false) goto L32;
        this.f = e.a(r2, r7);
        this.f3565a++;
    L32:
        r5 = 0;
        goto L40
    L19:
        if (e(512) == true) goto L26;
        int r8 = this.f3565a;
        if (r8 >= this.c) goto L26;
        if (this.f3566b.charAt(r8) != ':') goto L26;
        this.f3565a++;
        r5 = 20;
        goto L40
    L34:
        if (e(512) == false) goto L32;
        int r9 = this.f3565a;
        if (r9 >= this.c) goto L32;
        if (this.f3566b.charAt(r9) != '[') goto L32;
        this.f3565a++;
        r5 = 24;
        goto L40
    L43:
        if (r2 != '.') goto L45;
        r5 = 8;
    L124:
        this.g = r5;
        return;
    L45:
        if (r2 != '?') goto L47;
        r5 = 5;
        goto L124
    L47:
        if (r2 != '^') goto L49;
        r5 = 11;
        goto L124
    L49:
        if (r2 == '|') goto L120;
        if (r2 == '[') goto L119;
        if (r2 == '\\') goto L114;
        switch(r2) {
            case 40: goto L57;
            case 41: goto L56;
            case 42: goto L55;
            case 43: goto L54;
            default: goto L53;
        };
    L53:
        r5 = 0;
        goto L124
    L54:
        r5 = 4;
        goto L124
    L55:
        r5 = 3;
        goto L124
    L56:
        r5 = 7;
        goto L124
    L57:
        r5 = 6;
        int r10 = this.f3565a;
        if (r10 >= this.c) goto L124;
        if (this.f3566b.charAt(r10) != '?') goto L124;
        int r11 = this.f3565a + 1;
        this.f3565a = r11;
        if (r11 >= this.c) goto L113;
        String r12 = this.f3566b;
        this.f3565a = r11 + 1;
        char r13 = r12.charAt(r11);
        if (r13 != '!') goto L68;
        r5 = 15;
        goto L124
    L68:
        if (r13 == '#') goto L103;
        if (r13 == ':') goto L102;
        if (r13 == '[') goto L101;
        switch(r13) {
            case 60: goto L90;
            case 61: goto L89;
            case 62: goto L88;
            default: goto L72;
        };
    L72:
        if (r13 != '-') goto L74;
    L87:
        this.f3565a--;
        r5 = 22;
        goto L124
    L74:
        if ('a' > r13) goto L78;
        if (r13 <= 'z') goto L87;
    L78:
        if ('A' > r13) goto L83;
        if (r13 <= 'Z') goto L87;
    L83:
        if (r13 != '(') goto L86;
        r5 = 23;
        goto L124
    L86:
        throw a("parser.next.2", this.f3565a - 2);
    L88:
        r5 = 18;
        goto L124
    L89:
        r5 = 14;
        goto L124
    L90:
        int r14 = this.f3565a;
        if (r14 >= this.c) goto L100;
        String r15 = this.f3566b;
        this.f3565a = r14 + 1;
        char r16 = r15.charAt(r14);
        if (r16 != '=') goto L95;
        r5 = 16;
        goto L124
    L95:
        if (r16 != '!') goto L98;
        r5 = 17;
        goto L124
    L98:
        throw a("parser.next.3", this.f3565a - 3);
    L100:
        throw a("parser.next.2", r14 - 3);
    L101:
        r5 = 19;
        goto L124
    L102:
        r5 = 13;
    L103:
        int r17 = this.f3565a;
        if (r17 >= this.c) goto L107;
        String r18 = this.f3566b;
        this.f3565a = r17 + 1;
        r13 = r18.charAt(r17);
        if (r13 != ')') goto L103;
    L107:
        if (r13 != ')') goto L110;
        r5 = 21;
        goto L124
    L110:
        throw a("parser.next.4", this.f3565a - 1);
    L113:
        throw a("parser.next.2", r11 - 1);
    L114:
        int r19 = this.f3565a;
        if (r19 >= this.c) goto L118;
        String r20 = this.f3566b;
        this.f3565a = r19 + 1;
        this.f = r20.charAt(r19);
        goto L124
    L118:
        throw a("parser.next.1", r19 - 1);
    L119:
        r5 = 9;
        goto L124
    L120:
        r5 = 2;
        goto L124
    }

    Token D() {
        Token r0 = E();
        Token.UnionToken r1 = null;
    L4:
        if (B() != 2) goto L9;
        C();
        if (r1 != null) goto L8;
        r1 = Token.createUnion();
        r1.addChild(r0);
        r0 = r1;
    L8:
        r0.addChild(E());
        goto L4
    L9:
        return r0;
    }

    Token E() {
        int r0 = B();
        if (r0 == 2) goto L19;
        if (r0 == 7) goto L19;
        if (r0 == 1) goto L19;
        Token r1 = F();
        Token.UnionToken r4 = null;
    L10:
        int r5 = B();
        if (r5 == 2) goto L17;
        if (r5 == 7) goto L17;
        if (r5 == 1) goto L17;
        if (r4 != null) goto L16;
        r4 = Token.createConcat();
        r4.addChild(r1);
        r1 = r4;
    L16:
        r4.addChild(F());
    L17:
        return r1;
    L19:
        return Token.createEmpty();
    }

    Token F() {
        switch(B()) {
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L16;
            case 13: goto L48;
            case 14: goto L14;
            case 15: goto L12;
            case 16: goto L10;
            case 17: goto L8;
            case 18: goto L48;
            case 19: goto L48;
            case 20: goto L48;
            case 21: goto L5;
            default: goto L48;
        };
    L5:
        C();
        return Token.createEmpty();
    L19:
        int r0 = this.f;
        if (r0 == 60) goto L47;
        if (r0 == 62) goto L45;
        if (r0 == 90) goto L43;
        if (r0 == 98) goto L41;
        if (r0 == 122) goto L39;
        if (r0 == 65) goto L37;
        if (r0 != 66) goto L48;
        return k();
    L37:
        return g();
    L39:
        return i();
    L41:
        return j();
    L43:
        return h();
    L45:
        return m();
    L47:
        return l();
    L48:
        Token r1 = G();
        int r2 = B();
        if (r2 == 0) goto L64;
        if (r2 == 3) goto L62;
        if (r2 == 4) goto L60;
        if (r2 == 5) goto L58;
    L122:
        return r1;
    L58:
        return c(r1);
    L60:
        return b(r1);
    L62:
        return a(r1);
    L64:
        if (this.f != 123) goto L122;
        int r3 = this.f3565a;
        if (r3 >= this.c) goto L122;
        int r4 = r3 + 1;
        char r5 = this.f3566b.charAt(r3);
        if (r5 < '0') goto L121;
        if (r5 > '9') goto L121;
        int r6 = r5 - '0';
    L73:
        if (r4 >= this.c) goto L84;
        int r7 = r4 + 1;
        r5 = this.f3566b.charAt(r4);
        if (r5 < '0') goto L82;
        if (r5 > '9') goto L82;
        r6 = ((r6 * 10) + r5) - 48;
        if (r6 < 0) goto L81;
        r4 = r7;
        goto L73
    L81:
        throw a("parser.quantifier.5", this.f3565a);
    L82:
        r4 = r7;
    L84:
        if (r5 == ',') goto L86;
        int r8 = r6;
    L112:
        if (r5 != '}') goto L119;
        if (a(r4) == false) goto L116;
        r1 = Token.createNGClosure(r1);
        r4 = r4 + 1;
    L117:
        this.f3565a = r4;
        r1.setMin(r6);
        r1.setMax(r8);
        C();
        goto L122
    L116:
        r1 = Token.createClosure(r1);
        goto L117
    L119:
        throw a("parser.quantifier.2", this.f3565a);
    L86:
        if (r4 >= this.c) goto L109;
        int r9 = r4 + 1;
        r5 = this.f3566b.charAt(r4);
        if (r5 < '0') goto L106;
        if (r5 > '9') goto L106;
        int r10 = r5 - '0';
    L92:
        if (r9 >= this.c) goto L102;
        int r11 = r9 + 1;
        r5 = this.f3566b.charAt(r9);
        if (r5 < '0') goto L101;
        if (r5 > '9') goto L101;
        r10 = ((r10 * 10) + r5) - 48;
        if (r10 < 0) goto L100;
        r9 = r11;
        goto L92
    L100:
        throw a("parser.quantifier.5", this.f3565a);
    L101:
        r9 = r11;
    L102:
        if (r6 > r10) goto L105;
    L107:
        r8 = r10;
        r4 = r9;
        goto L112
    L105:
        throw a("parser.quantifier.4", this.f3565a);
    L106:
        r10 = -1;
        goto L107
    L109:
        throw a("parser.quantifier.3", this.f3565a);
    L121:
        throw a("parser.quantifier.1", this.f3565a);
    L8:
        return f();
    L10:
        return e();
    L12:
        return d();
    L14:
        return c();
    L16:
        return b();
    L18:
        return a();
    }

    Token G() {
        int r0 = B();
        if (r0 != 0) goto L5;
        int r1 = this.f;
        if (r1 == 93) goto L98;
        if (r1 == 123) goto L98;
        if (r1 == 125) goto L98;
        Token.CharToken r2 = Token.createChar(r1);
        int r3 = this.f;
        C();
        if (e.b(r3) == true) goto L92;
        return r2;
    L92:
        if (B() == 0) goto L94;
        return r2;
    L94:
        if (e.a(this.f) == false) goto L102;
        Token r4 = Token.createParen(Token.createString(new String(new char[]{(char) r3, (char) this.f})), 0);
    L59:
        C();
        return r4;
    L102:
        return r2;
    L98:
        throw a("parser.atom.4", this.f3565a - 1);
    L5:
        if (r0 == 6) goto L82;
        if (r0 == 13) goto L80;
        if (r0 == 18) goto L78;
        if (r0 == 19) goto L76;
        if (r0 == 22) goto L74;
        if (r0 == 23) goto L72;
        switch(r0) {
            case 8: goto L70;
            case 9: goto L69;
            case 10: goto L19;
            default: goto L18;
        };
    L19:
        int r5 = this.f;
        if (r5 == 67) goto L67;
        if (r5 != 68) goto L24;
    L64:
        Token r6 = b(r5);
        C();
        return r6;
    L24:
        if (r5 == 73) goto L63;
        if (r5 != 80) goto L28;
    L57:
        int r7 = this.f3565a;
        r4 = d(r5);
        if (r4 != null) goto L59;
        throw a("parser.atom.5", r7);
    L28:
        if (r5 == 83) goto L64;
        if (r5 == 105) goto L56;
        if (r5 != 110) goto L34;
    L51:
        r5 = A();
        if (r5 < 65536) goto L42;
        r4 = Token.createString(e.c(r5));
    L42:
        r4 = Token.createChar(r5);
        goto L59
    L34:
        if (r5 == 112) goto L57;
        if (r5 == 87) goto L64;
        if (r5 == 88) goto L50;
        switch(r5) {
            case 49: goto L48;
            case 50: goto L48;
            case 51: goto L48;
            case 52: goto L48;
            case 53: goto L48;
            case 54: goto L48;
            case 55: goto L48;
            case 56: goto L48;
            case 57: goto L48;
            default: goto L40;
        };
    L40:
        switch(r5) {
            case 99: goto L46;
            case 100: goto L64;
            case 101: goto L51;
            case 102: goto L51;
            case 103: goto L44;
            default: goto L41;
        };
    L41:
        switch(r5) {
            case 114: goto L51;
            case 115: goto L64;
            case 116: goto L51;
            case 117: goto L51;
            case 118: goto L51;
            case 119: goto L64;
            case 120: goto L51;
            default: goto L42;
        };
    L44:
        return w();
    L46:
        return s();
    L48:
        return y();
    L50:
        return x();
    L56:
        return u();
    L63:
        return v();
    L67:
        return t();
    L70:
        C();
        return Token.token_dot;
    L18:
        throw a("parser.atom.4", this.f3565a - 1);
    L69:
        return a(true);
    L72:
        return p();
    L74:
        return q();
    L76:
        return z();
    L78:
        return r();
    L80:
        return o();
    L82:
        return n();
    }

    int a(RangeToken r1, int r2) {
        return A();
    }

    final ParseException a(String r2, int r3) {
        return new ParseException(this.e.getString(r2), r3);
    }

    public RangeToken a(boolean r17) {
        c(1);
        C();
        RangeToken r5 = null;
        if (B() == 0) goto L5;
    L11:
        RangeToken r2 = Token.createRange();
        boolean r6 = false;
    L12:
        boolean r7 = true;
    L13:
        int r8 = B();
        if (r8 == 1) goto L109;
        if (r8 == 0) goto L18;
    L21:
        int r9 = this.f;
        if (r8 != 10) goto L58;
        if (r9 != 67) goto L26;
    L54:
        r9 = a(r2, r9);
        if (r9 < 0) goto L72;
    L79:
        boolean r10 = false;
    L80:
        C();
        if (r10 == true) goto L101;
        if (B() == 0) goto L85;
    L99:
        r2.addRange(r9, r9);
        goto L101
    L85:
        if (this.f != 45) goto L99;
        C();
        int r11 = B();
        if (r11 == 1) goto L98;
        if (r11 == 0) goto L91;
    L93:
        int r12 = this.f;
        if (r11 != 10) goto L96;
        r12 = A();
    L96:
        C();
        r2.addRange(r9, r12);
        goto L101
    L91:
        if (this.f != 93) goto L93;
        r2.addRange(r9, r9);
        r2.addRange(45, 45);
        goto L101
    L98:
        throw a("parser.cc.2", this.f3565a);
    L101:
        if (e(1024) == false) goto L107;
        if (B() != 0) goto L107;
        if (this.f != 44) goto L107;
        C();
    L107:
        r7 = false;
    L72:
        r10 = true;
        goto L80
    L26:
        if (r9 != 68) goto L28;
    L53:
        r2.mergeRanges(b(r9));
        goto L72
    L28:
        if (r9 == 73) goto L54;
        if (r9 != 80) goto L32;
    L48:
        int r13 = this.f3565a;
        RangeToken r14 = d(r9);
        if (r14 == null) goto L52;
        r2.mergeRanges(r14);
        goto L72
    L52:
        throw a("parser.atom.5", r13);
    L32:
        if (r9 == 83) goto L53;
        if (r9 == 87) goto L53;
        if (r9 == 105) goto L54;
        if (r9 == 112) goto L48;
        if (r9 == 115) goto L53;
        if (r9 == 119) goto L53;
        if (r9 == 99) goto L54;
        if (r9 == 100) goto L53;
        r9 = A();
        goto L79
    L58:
        if (r8 != 20) goto L79;
        int r15 = this.f3566b.indexOf(58, this.f3565a);
        if (r15 < 0) goto L78;
        if (this.f3566b.charAt(this.f3565a) != '^') goto L64;
        this.f3565a++;
        boolean r16 = false;
    L65:
        RangeToken r18 = Token.getRange(this.f3566b.substring(this.f3565a, r15), r16, e(512));
        if (r18 == null) goto L76;
        r2.mergeRanges(r18);
        int r19 = r15 + 1;
        if (r19 >= this.c) goto L74;
        if (this.f3566b.charAt(r19) != ']') goto L74;
        this.f3565a = r15 + 2;
    L74:
        throw a("parser.cc.1", r15);
    L76:
        throw a("parser.cc.3", this.f3565a);
    L64:
        r16 = true;
        goto L65
    L78:
        throw a("parser.cc.1", this.f3565a);
    L18:
        if (this.f != 93) goto L21;
        if (r7 == true) goto L21;
    L109:
        if (B() == 1) goto L116;
        if (r17 == true) goto L113;
        if (r6 == false) goto L113;
        r5.subtractRanges(r2);
        r2 = r5;
    L113:
        r2.sortRanges();
        r2.compactRanges();
        c(0);
        C();
        return r2;
    L116:
        throw a("parser.cc.2", this.f3565a);
    L5:
        if (this.f != 94) goto L11;
        C();
        if (r17 == false) goto L9;
        r2 = Token.createNRange();
    L10:
        r6 = true;
        goto L12
    L9:
        r5 = Token.createRange();
        r5.addRange(0, 1114111);
        r2 = Token.createRange();
        goto L10
    }

    Token a() {
        C();
        return Token.token_linebeginning;
    }

    Token a(Token r3) {
        C();
        if (B() != 5) goto L7;
        C();
        return Token.createNGClosure(r3);
    L7:
        return Token.createClosure(r3);
    }

    public void a(Locale r3) {
        this.e = ResourceBundle.getBundle(getClass().getPackage().getName() + ".message", r3);     // Catch: MissingResourceException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException("Installation Problem???  Couldn't load messages: " + e.getMessage());
    }

    boolean a(int r2) {
        if (r2 < this.c) goto L5;
    L7:
        return false;
    L5:
        if (this.f3566b.charAt(r2) != '?') goto L7;
        return true;
    }

    Token b() {
        C();
        return Token.token_lineend;
    }

    Token b(int r7) {
        boolean r2 = false;
        if (r7 == 68) goto L37;
        if (r7 == 83) goto L33;
        if (r7 == 87) goto L29;
        r2 = true;
        if (r7 == 100) goto L25;
        if (r7 == 115) goto L21;
        if (r7 != 119) goto L19;
        if (e(32) == false) goto L42;
    L41:
        return Token.getRange("IsWord", r2);
    L42:
        return Token.token_wordchars;
    L19:
        throw new RuntimeException("Internal Error: shorthands: \\u" + Integer.toString(r7, 16));
    L21:
        if (e(32) == false) goto L44;
    L43:
        return Token.getRange("IsSpace", r2);
    L44:
        return Token.token_spaces;
    L25:
        if (e(32) == false) goto L46;
    L45:
        return Token.getRange("Nd", r2);
    L46:
        return Token.token_0to9;
    L29:
        if (e(32) == true) goto L41;
        return Token.token_not_wordchars;
    L33:
        if (e(32) == true) goto L43;
        return Token.token_not_spaces;
    L37:
        if (e(32) == true) goto L45;
        return Token.token_not_0to9;
    }

    Token b(Token r3) {
        C();
        if (B() != 5) goto L7;
        C();
        Token.ClosureToken r2 = Token.createNGClosure(r3);
    L6:
        return Token.createConcat(r3, r2);
    L7:
        r2 = Token.createClosure(r3);
        goto L6
    }

    synchronized Token b(String r4, int r5) {
        monitor-enter(this);
        this.d = r5;     // Catch: Throwable -> L22
        int r6 = 0;
        this.f3565a = 0;     // Catch: Throwable -> L22
        c(0);     // Catch: Throwable -> L22
        this.i = 1;     // Catch: Throwable -> L22
        this.j = false;     // Catch: Throwable -> L22
        this.f3566b = r4;     // Catch: Throwable -> L22
        if (e(16) == false) goto L6;
        this.f3566b = e.b(this.f3566b);     // Catch: Throwable -> L22
    L6:
        this.c = this.f3566b.length();     // Catch: Throwable -> L22
        C();     // Catch: Throwable -> L22
        Token r7 = D();     // Catch: Throwable -> L22
        int r0 = this.f3565a;     // Catch: Throwable -> L22
        if (r0 != this.c) goto L21;
        if (this.k != null) goto L11;
    L18:
        monitor-exit(this);
        return r7;
    L11:
        if (r6 >= this.k.size()) goto L17;
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.k.elementAt(r6), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (this.i <= r1.f3567a) goto L16;
        r6 = r6 + 1;     // Catch: Throwable -> L22
        goto L11
    L16:
        throw a("parser.parse.2", r1.f3568b);     // Catch: Throwable -> L22
    L17:
        this.k.removeAllElements();     // Catch: Throwable -> L22
        goto L18
    L21:
        throw a("parser.parse.1", r0);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    Token c() {
        C();
        Token.ParenToken r0 = Token.createLook(20, D());
        if (B() != 7) goto L7;
        C();
        return r0;
    L7:
        throw a("parser.factor.1", this.f3565a - 1);
    }

    Token c(Token r4) {
        C();
        Token.UnionToken r0 = Token.createUnion();
        if (B() != 5) goto L5;
        C();
        r0.addChild(Token.createEmpty());
        r0.addChild(r4);
    L6:
        return r0;
    L5:
        r0.addChild(r4);
        r0.addChild(Token.createEmpty());
        goto L6
    }

    public final void c(int r1) {
        this.h = r1;
    }

    public RangeToken d(int r5) {
        C();
        if (B() != 0) goto L17;
        if (this.f != 123) goto L17;
        if (r5 != 112) goto L9;
        boolean r6 = true;
    L10:
        int r0 = this.f3565a;
        int r2 = this.f3566b.indexOf(125, r0);
        if (r2 < 0) goto L15;
        String r1 = this.f3566b.substring(r0, r2);
        this.f3565a = r2 + 1;
        return Token.getRange(r1, r6, e(512));
    L15:
        throw a("parser.atom.3", this.f3565a);
    L9:
        r6 = false;
    L17:
        throw a("parser.atom.2", this.f3565a - 1);
    }

    Token d() {
        C();
        Token.ParenToken r0 = Token.createLook(21, D());
        if (B() != 7) goto L7;
        C();
        return r0;
    L7:
        throw a("parser.factor.1", this.f3565a - 1);
    }

    Token e() {
        C();
        Token.ParenToken r0 = Token.createLook(22, D());
        if (B() != 7) goto L7;
        C();
        return r0;
    L7:
        throw a("parser.factor.1", this.f3565a - 1);
    }

    Token f() {
        C();
        Token.ParenToken r0 = Token.createLook(23, D());
        if (B() != 7) goto L7;
        C();
        return r0;
    L7:
        throw a("parser.factor.1", this.f3565a - 1);
    }

    Token g() {
        C();
        return Token.token_stringbeginning;
    }

    Token h() {
        C();
        return Token.token_stringend2;
    }

    Token i() {
        C();
        return Token.token_stringend;
    }

    Token j() {
        C();
        return Token.token_wordedge;
    }

    Token k() {
        C();
        return Token.token_not_wordedge;
    }

    Token l() {
        C();
        return Token.token_wordbeginning;
    }

    Token m() {
        C();
        return Token.token_wordend;
    }

    Token n() {
        C();
        int r0 = this.i;
        this.i = r0 + 1;
        Token.ParenToken r1 = Token.createParen(D(), r0);
        if (B() != 7) goto L7;
        C();
        return r1;
    L7:
        throw a("parser.factor.1", this.f3565a - 1);
    }

    Token o() {
        C();
        Token.ParenToken r0 = Token.createParen(D(), 0);
        if (B() != 7) goto L7;
        C();
        return r0;
    L7:
        throw a("parser.factor.1", this.f3565a - 1);
    }

    Token p() {
        int r0 = this.f3565a;
        if ((r0 + 1) >= this.c) goto L42;
        int r1 = -1;
        char r2 = this.f3566b.charAt(r0);
        Token r4 = null;
        if ('1' > r2) goto L17;
        if (r2 > '9') goto L17;
        r1 = r2 - '0';
        this.j = true;
        if (this.k != null) goto L11;
        this.k = new Vector();
    L11:
        this.k.addElement(new a(r1, this.f3565a));
        int r3 = this.f3565a + 1;
        this.f3565a = r3;
        if (this.f3566b.charAt(r3) != ')') goto L15;
        this.f3565a++;
        Token r5 = null;
    L26:
        C();
        Token r6 = D();
        if (r6.type != 2) goto L34;
        if (r6.size() != 2) goto L32;
        r4 = r6.getChild(1);
        r6 = r6.getChild(0);
        goto L34
    L32:
        throw a("parser.factor.6", this.f3565a);
    L34:
        if (B() != 7) goto L38;
        C();
        return Token.createCondition(r1, r5, r6, r4);
    L38:
        throw a("parser.factor.1", this.f3565a - 1);
    L15:
        throw a("parser.factor.1", this.f3565a);
    L17:
        if (r2 != '?') goto L19;
        this.f3565a--;
    L19:
        C();
        r5 = F();
        int r7 = r5.type;
        if (r7 == 8) goto L25;
        switch(r7) {
            case 20: goto L26;
            case 21: goto L26;
            case 22: goto L26;
            case 23: goto L26;
            default: goto L23;
        };
    L23:
        throw a("parser.factor.5", this.f3565a);
    L25:
        if (B() == 7) goto L26;
        throw a("parser.factor.1", this.f3565a - 1);
    L42:
        throw a("parser.factor.4", r0);
    }

    Token q() {
        int r0 = 0;
        byte r1 = -1;
        int r2 = 0;
    L3:
        int r3 = this.f3565a;
        if (r3 >= this.c) goto L9;
        r1 = this.f3566b.charAt(r3);
        int r4 = e.d(r1);
        if (r4 == 0) goto L9;
        r2 = r2 | r4;
        this.f3565a++;
    L9:
        int r5 = this.f3565a;
        if (r5 >= this.c) goto L38;
        if (r1 != 45) goto L25;
    L13:
        this.f3565a = r5 + 1;
        int r6 = this.f3565a;
        if (r6 >= this.c) goto L19;
        r1 = this.f3566b.charAt(r6);
        int r7 = e.d(r1);
        if (r7 == 0) goto L19;
        r0 = r0 | r7;
        r5 = this.f3565a;
    L19:
        int r8 = this.f3565a;
        if (r8 < this.c) goto L25;
        throw a("parser.factor.2", r8 - 1);
    L25:
        if (r1 != 58) goto L32;
        this.f3565a++;
        C();
        Token.ModifierToken r9 = Token.createModifierGroup(D(), r2, r0);
        if (B() != 7) goto L30;
        C();
        return r9;
    L30:
        throw a("parser.factor.1", this.f3565a - 1);
    L32:
        if (r1 != 41) goto L36;
        this.f3565a++;
        C();
        return Token.createModifierGroup(D(), r2, r0);
    L36:
        throw a("parser.factor.3", this.f3565a);
    L38:
        throw a("parser.factor.2", r5 - 1);
    }

    Token r() {
        C();
        Token.ParenToken r0 = Token.createLook(24, D());
        if (B() != 7) goto L7;
        C();
        return r0;
    L7:
        throw a("parser.factor.1", this.f3565a - 1);
    }

    Token s() {
        int r0 = this.f3565a;
        if (r0 >= this.c) goto L9;
        String r1 = this.f3566b;
        this.f3565a = r0 + 1;
        char r2 = r1.charAt(r0);
        if ((65504 & r2) != 64) goto L9;
        C();
        return Token.createChar(r2 - '@');
    L9:
        throw a("parser.atom.1", this.f3565a - 1);
    }

    Token t() {
        throw a("parser.process.1", this.f3565a);
    }

    Token u() {
        Token.CharToken r0 = Token.createChar(105);
        C();
        return r0;
    }

    Token v() {
        throw a("parser.process.1", this.f3565a);
    }

    Token w() {
        C();
        return Token.getGraphemePattern();
    }

    Token x() {
        C();
        return Token.getCombiningCharacterSequence();
    }

    Token y() {
        int r0 = this.f - 48;
        Token.StringToken r1 = Token.createBackReference(r0);
        this.j = true;
        if (this.k != null) goto L5;
        this.k = new Vector();
    L5:
        this.k.addElement(new a(r0, this.f3565a - 2));
        C();
        return r1;
    }

    public RangeToken z() {
        RangeToken r1 = a(false);
    L3:
        int r2 = B();
        if (r2 == 7) goto L25;
        int r3 = this.f;
        if (r2 != 0) goto L9;
        if (r3 == 45) goto L10;
        if (r3 != 38) goto L9;
    L10:
        C();
        if (B() != 9) goto L22;
        RangeToken r7 = a(false);
        if (r2 == 4) goto L14;
        if (r3 == 45) goto L16;
        if (r3 != 38) goto L20;
        r1.intersectRanges(r7);
        goto L3
    L20:
        throw new RuntimeException("ASSERT");
    L16:
        r1.subtractRanges(r7);
        goto L3
    L14:
        r1.mergeRanges(r7);
        goto L3
    L22:
        throw a("parser.ope.1", this.f3565a - 1);
    L9:
        if (r2 == 4) goto L10;
        throw a("parser.ope.2", this.f3565a - 1);
    L25:
        C();
        return r1;
    }
}
