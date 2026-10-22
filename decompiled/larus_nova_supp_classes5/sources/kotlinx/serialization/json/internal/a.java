package kotlinx.serialization.json.internal;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class a {
    public int a;
    public final v b;
    public String c;
    public final StringBuilder d;

    public abstract boolean b();

    public abstract String d();

    public abstract byte e();

    public abstract void g(char r1);

    public abstract CharSequence p();

    public abstract String q(String r1, boolean r2);

    public abstract int t(int r1);

    public abstract int u();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v8 */
    public final long h() {
        int r1 = t(u());
        String r3 = "EOF";
        ?? r6 = 0;
        if (r1 < p().length()) goto L5;
    L116:
        m(this, "EOF", 0, null, 6);
        throw null;
    L5:
        if (r1 == (-1)) goto L116;
        if (p().charAt(r1) != '\"') goto L13;
        r1 = r1 + 1;
        if (r1 == p().length()) goto L11;
        boolean r2 = true;
    L14:
        int r11 = r1;
        long r7 = 0;
        long r9 = 0;
        boolean r12 = false;
        boolean r13 = false;
    L15:
        boolean r14 = false;
    L17:
        if (r11 == p().length()) goto L65;
        char r15 = p().charAt(r11);
        if (r15 != 'e') goto L21;
    L22:
        if (r12 == false) goto L23;
    L28:
        boolean r17 = r14;
        if (r15 != '-') goto L36;
        if (r12 == false) goto L36;
        if (r11 == r1) goto L33;
        r11 = r11 + 1;
        r6 = 0;
        goto L15
    L33:
        m(this, "Unexpected symbol '-' in numeric literal", 0, null, 6);
        throw null;
    L36:
        if (r15 != '+') goto L42;
        if (r12 == false) goto L42;
        if (r11 == r1) goto L40;
        r11 = r11 + 1;
        r6 = 0;
    L25:
        r14 = true;
        goto L17
    L40:
        m(this, "Unexpected symbol '+' in numeric literal", 0, null, 6);
        throw null;
    L42:
        String r18 = r3;
        if (r15 == '-') goto L44;
        if (b.a(r15) != 0) goto L66;
        r11 = r11 + 1;
        int r4 = r15 - '0';
        if (r4 < 0) goto L54;
        if (r4 >= 10) goto L54;
        boolean r8 = true;
    L55:
        if (r8 == false) goto L63;
        if (r12 == false) goto L58;
        r9 = (r9 * ((long) 10)) + ((long) r4);
    L60:
        r14 = r17;
        r3 = r18;
        r6 = 0;
        goto L17
    L58:
        r7 = (r7 * ((long) 10)) - ((long) r4);
        if (r7 <= 0) goto L60;
        m(this, "Numeric value overflow", 0, null, 6);
        throw null;
    L63:
        m(this, "Unexpected symbol '" + r15 + "' in numeric literal", 0, null, 6);
        throw null;
    L54:
        r8 = false;
    L66:
        if (r11 == r1) goto L68;
        boolean r5 = true;
    L69:
        if (r1 == r11) goto L114;
        if (r13 == true) goto L72;
    L73:
        if (r2 == false) goto L82;
        if (r5 == true) goto L76;
        m(this, r18, 0, null, 6);
        throw null;
    L76:
        if (p().charAt(r11) != '\"') goto L78;
        r11 = r11 + 1;
        goto L82
    L78:
        m(this, "Expected closing quotation mark", 0, null, 6);
        throw null;
    L82:
        this.a = r11;
        if (r12 == false) goto L106;
        double r10 = r7;
        if (r17 == true) goto L88;
        double r16 = Math.pow(10.0d, -r9);
    L90:
        double r19 = r10 * r16;
        if (r19 <= 9.223372036854776E18d) goto L93;
    L102:
        m(this, "Numeric value overflow", 0, null, 6);
        throw null;
    L93:
        if (r19 < (-9.223372036854776E18d)) goto L102;
        if (Math.floor(r19) != r19) goto L97;
        boolean r20 = true;
    L98:
        if (r20 == false) goto L100;
        r7 = (long) r19;
        goto L106
    L100:
        m(this, "Can't convert " + r19 + " to Long", 0, null, 6);
        throw null;
    L97:
        r20 = false;
        goto L98
    L88:
        if (r17 != true) goto L105;
        r16 = Math.pow(10.0d, r9);
        goto L90
    L105:
        throw new NoWhenBranchMatchedException();
    L106:
        if (r13 == false) goto L109;
        return r7;
    L109:
        if (r7 != Long.MIN_VALUE) goto L111;
        m(this, "Numeric value overflow", 0, null, 6);
        throw null;
    L111:
        return -r7;
    L72:
        if (r1 != (r11 - 1)) goto L73;
    L114:
        m(this, "Expected numeric literal", 0, null, 6);
        throw null;
    L68:
        r5 = false;
        goto L69
    L44:
        if (r11 != r1) goto L46;
        r11 = r11 + 1;
        r6 = 0;
        r14 = r17;
        r3 = r18;
        r13 = true;
        goto L17
    L46:
        m(this, "Unexpected symbol '-' in numeric literal", 0, null, 6);
        throw null;
    L23:
        if (r11 == r1) goto L26;
        r11 = r11 + 1;
        r12 = true;
        r6 = r6;
        goto L25
    L26:
        m(this, "Unexpected symbol " + r15 + " in numeric literal", 0, r6, 6);
        throw r6;
    L21:
        if (r15 != 'E') goto L28;
    L65:
        r18 = r3;
        r17 = r14;
        goto L66
    L11:
        m(this, "EOF", 0, null, 6);
        throw null;
    L13:
        r2 = false;
        goto L14
    }

    public final String i() {
        String r0 = this.c;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r0);
        this.c = null;
        return r0;
    L7:
        return d();
    }

    public final String j() {
        String r0 = this.c;
        if (r0 == null) goto L6;
        Intrinsics.checkNotNull(r0);
        this.c = null;
        return r0;
    L6:
        int r1 = u();
        if (r1 < p().length()) goto L9;
    L33:
        m(this, "EOF", r1, null, 4);
        throw null;
    L9:
        if (r1 == (-1)) goto L33;
        byte r3 = b.a(p().charAt(r1));
        if (r3 != 1) goto L15;
        return i();
    L15:
        if (r3 != 0) goto L31;
        boolean r2 = false;
    L18:
        if (b.a(p().charAt(r1)) != 0) goto L26;
        r1 = r1 + 1;
        if (r1 < p().length()) goto L18;
        this.d.append(p(), this.a, r1);
        int r4 = t(r1);
        if (r4 == (-1)) goto L23;
        r1 = r4;
        r2 = true;
        goto L18
    L23:
        this.a = r1;
        this.d.append(p(), 0, 0);
        String r5 = this.d.toString();
        this.d.setLength(0);
        return r5;
    L26:
        if (r2 == true) goto L28;
        String r6 = p().subSequence(this.a, r1).toString();
    L29:
        this.a = r1;
        return r6;
    L28:
        this.d.append(p(), this.a, r1);
        r6 = this.d.toString();
        this.d.setLength(0);
        goto L29
    L31:
        m(this, "Expected beginning of the string, but got " + p().charAt(r1), 0, null, 6);
        throw null;
    }

    public final String toString() {
        return "JsonReader(source='" + p() + "', currentPosition=" + this.a + ')';
    }

    public a() {
        this.b = new v();
        this.d = new StringBuilder();
    }

    public final String k() {
        String r0 = j();
        if (Intrinsics.areEqual(r0, "null") == false) goto L12;
        boolean r3 = true;
        if (p().charAt(this.a - 1) != '\"') goto L8;
        r3 = false;
    L8:
        if (r3 == false) goto L12;
        m(this, "Unexpected 'null' value instead of string literal", 0, null, 6);
        throw null;
    L12:
        return r0;
    }

    public byte r() {
        CharSequence r0 = p();
        int r1 = this.a;
    L3:
        int r2 = t(r1);
        if (r2 == (-1)) goto L16;
        char r3 = r0.charAt(r2);
        if (r3 == ' ') goto L15;
        if (r3 == '\n') goto L15;
        if (r3 == '\r') goto L15;
        if (r3 == '\t') goto L15;
        this.a = r2;
        return b.a(r3);
    L15:
        r1 = r2 + 1;
        goto L3
    L16:
        this.a = r2;
        return 10;
    }

    public final boolean v() {
        int r0 = u();
        CharSequence r1 = p();
        if (r0 < r1.length()) goto L5;
        return false;
    L5:
        if (r0 != (-1)) goto L8;
        return false;
    L8:
        if (r1.charAt(r0) != ',') goto L13;
        this.a++;
        return true;
    L13:
        return false;
    }

    public final byte f(byte r2) {
        byte r0 = e();
        if (r0 != r2) goto L5;
        return r0;
    L5:
        n(r2, true);
        throw null;
    }

    public final String s(boolean r4) {
        byte r0 = r();
        if (r4 == false) goto L8;
        if (r0 == 1) goto L7;
        if (r0 == 0) goto L7;
        return null;
    L7:
        String r5 = j();
    L11:
        this.c = r5;
        return r5;
    L8:
        if (r0 == 1) goto L10;
        return null;
    L10:
        r5 = i();
        goto L11
    }

    public final boolean w(boolean r9) {
        int r0 = t(u());
        int r1 = p().length() - r0;
        if (r1 >= 4) goto L5;
    L21:
        return false;
    L5:
        if (r0 == (-1)) goto L21;
        int r4 = 0;
    L8:
        if (r4 >= 4) goto L13;
        if ("null".charAt(r4) != p().charAt(r0 + r4)) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        return false;
    L13:
        if (r1 > 4) goto L15;
    L17:
        if (r9 == false) goto L24;
        this.a = r0 + 4;
        return true;
    L24:
        return true;
    L15:
        if (b.a(p().charAt(r0 + 4)) != 0) goto L17;
        return false;
    }

    public final void x(char r4) {
        int r0 = this.a;
        if (r0 > 0) goto L5;
    L15:
        n(b.a(r4), true);
        throw null;
    L5:
        if (r4 != '\"') goto L15;
        this.a = r0 - 1;     // Catch: Throwable -> L12
        String r2 = j();     // Catch: Throwable -> L12
        this.a = r0;
        if (Intrinsics.areEqual(r2, "null") == false) goto L15;
        l("Expected string literal but 'null' literal was found", this.a - 1, "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
        throw null;
    L12:
        th = move-exception;
        this.a = r0;
        throw th;
    }

    public final int a(CharSequence r5, int r6) {
        int r0 = r6 + 4;
        if (r0 < r5.length()) goto L10;
        this.a = r6;
        if (r0 < r5.length()) goto L7;
        m(this, "Unexpected EOF during unicode escape", 0, null, 6);
        throw null;
    L7:
        return a(r5, this.a);
    L10:
        this.d.append((char) ((((o(r5, r6) << 12) + (o(r5, r6 + 1) << 8)) + (o(r5, r6 + 2) << 4)) + o(r5, r6 + 3)));
        return r0;
    }

    public final void c(String r9, int r10) {
        if ((p().length() - r10) < r9.length()) goto L13;
        int r0 = r9.length();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L11;
        if (r9.charAt(r1) != (p().charAt(r10 + r1) | ' ')) goto L9;
        r1 = r1 + 1;
        goto L5
    L9:
        m(this, "Expected valid boolean literal prefix, but had '" + j() + '\'', 0, null, 6);
        throw null;
    L11:
        this.a = r10 + r9.length();
        return;
    L13:
        m(this, "Unexpected end of boolean literal", 0, null, 6);
        throw null;
    }

    public final void n(byte r4, boolean r5) {
        String r6 = b.b(r4);
        if (r5 == false) goto L5;
        int r7 = this.a - 1;
    L7:
        if (this.a == p().length()) goto L11;
        if (r7 < 0) goto L11;
        String r0 = String.valueOf(p().charAt(r7));
    L12:
        m(this, "Expected " + r6 + ", but had '" + r0 + "' instead", r7, null, 4);
        throw null;
    L11:
        r0 = "EOF";
        goto L12
    L5:
        r7 = this.a;
        goto L7
    }

    public final int o(CharSequence r4, int r5) {
        char r6 = r4.charAt(r5);
        boolean r0 = true;
        if ('0' <= r6) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L29;
        char r1 = 'a';
        if ('a' <= r6) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r3 == true) goto L26;
        r1 = 'A';
        if ('A' <= r6) goto L21;
    L23:
        r0 = false;
    L24:
        if (r0 == true) goto L26;
        m(this, "Invalid toHexChar char '" + r6 + "' in unicode escape", 0, null, 6);
        throw null;
    L21:
        if (r6 >= 'G') goto L23;
    L26:
        return (r6 - r1) + 10;
    L13:
        if (r6 >= 'g') goto L15;
        r3 = true;
        goto L16
    L29:
        return r6 - '0';
    L5:
        if (r6 >= ':') goto L7;
        r2 = true;
        goto L8
    }

    public final void l(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r4, "hint");
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        String r5 = "";
    L10:
        throw s.d(r3, r2 + " at path: " + this.b.a() + r5, p());
    L8:
        r5 = "\n".concat(r4);
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public static /* synthetic */ void m(a r1, String r2, int r3, String r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = r1.a;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = "";
    L8:
        r1.l(r2, r3, r4);
        throw null;
    }
}
