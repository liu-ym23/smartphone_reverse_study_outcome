package pa;

import ha.u;
import java.io.Closeable;
import java.io.EOFException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import ka.f;

/* JADX INFO: loaded from: classes.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Reader f9951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9952b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final char[] f9953m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9954n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f9955o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f9956p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f9957q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f9958r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f9959s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f9960t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f9961u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int[] f9962v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f9963w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String[] f9964x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int[] f9965y;

    /* JADX INFO: renamed from: pa.a$a, reason: collision with other inner class name */
    public class C0135a extends android.support.v4.media.a {
        public final void z(a r8) {
            if ((r8 instanceof f) == false) goto L6;
            f r10 = (f) r8;
            r10.getClass();
            r10.w0(b.f9970o);
            Map.Entry r11 = (Map.Entry) ((Iterator) r10.z0()).next();
            r10.B0(r11.getValue());
            r10.B0(new u((String) r11.getKey()));
            return;
        L6:
            int r12 = r8.f9958r;
            if (r12 != 0) goto L10;
            r12 = r8.n();
        L10:
            if (r12 != 13) goto L14;
            int r13 = 9;
        L12:
            r8.f9958r = r13;
            return;
        L14:
            if (r12 != 12) goto L17;
            r13 = 8;
            goto L12
        L17:
            if (r12 != 14) goto L21;
            r13 = 10;
            goto L12
        L21:
            throw new IllegalStateException("Expected a name but was " + r8.h0() + r8.D());
        }
    }

    static {
        android.support.v4.media.a.f405b = new C0135a();
    }

    public a(Reader r8) {
        this.f9952b = false;
        this.f9953m = new char[1024];
        this.f9954n = 0;
        this.f9955o = 0;
        this.f9956p = 0;
        this.f9957q = 0;
        this.f9958r = 0;
        int[] r10 = new int[32];
        this.f9962v = r10;
        this.f9963w = 0 + 1;
        r10[0] = 6;
        this.f9964x = new String[32];
        this.f9965y = new int[32];
        Objects.requireNonNull(r8, "in == null");
        this.f9951a = r8;
    }

    public String A() {
        return z(true);
    }

    public boolean B() {
        int r8 = this.f9958r;
        if (r8 != 0) goto L6;
        r8 = n();
    L6:
        if (r8 != 2) goto L8;
    L12:
        return false;
    L8:
        if (r8 == 4) goto L12;
        if (r8 == 17) goto L12;
        return true;
    }

    public final boolean C(char r8) {
        if (r8 != '\t') goto L5;
        return false;
    L5:
        if (r8 != '\n') goto L7;
        return false;
    L7:
        if (r8 != '\f') goto L9;
        return false;
    L9:
        if (r8 != '\r') goto L11;
        return false;
    L11:
        if (r8 != ' ') goto L13;
        return false;
    L13:
        if (r8 != '#') goto L15;
    L31:
        k();
        return false;
    L15:
        if (r8 != ',') goto L17;
        return false;
    L17:
        if (r8 == '/') goto L31;
        if (r8 == '=') goto L31;
        if (r8 != '{') goto L23;
        return false;
    L23:
        if (r8 != '}') goto L25;
        return false;
    L25:
        if (r8 != ':') goto L27;
        return false;
    L27:
        if (r8 == ';') goto L31;
        switch(r8) {
            case 91: goto L43;
            case 92: goto L31;
            case 93: goto L43;
            default: goto L29;
        };
    L29:
        return true;
    L43:
        return false;
    }

    public final String D() {
        StringBuilder r8 = defpackage.a.g(" at line ", this.f9956p + 1, " column ", (this.f9954n - this.f9957q) + 1, " path ");
        r8.append(x());
        return r8.toString();
    }

    public boolean E() {
        int r8 = this.f9958r;
        if (r8 != 0) goto L6;
        r8 = n();
    L6:
        if (r8 != 5) goto L10;
        this.f9958r = 0;
        int[] r10 = this.f9965y;
        int r11 = this.f9963w - 1;
        r10[r11] = r10[r11] + 1;
        return true;
    L10:
        if (r8 != 6) goto L14;
        this.f9958r = 0;
        int[] r12 = this.f9965y;
        int r13 = this.f9963w - 1;
        r12[r13] = r12[r13] + 1;
        return false;
    L14:
        throw new IllegalStateException("Expected a boolean but was " + h0() + D());
    }

    public double G() {
        int r8 = this.f9958r;
        if (r8 != 0) goto L6;
        r8 = n();
    L6:
        if (r8 != 15) goto L10;
        this.f9958r = 0;
        int[] r10 = this.f9965y;
        int r11 = this.f9963w - 1;
        r10[r11] = r10[r11] + 1;
        return this.f9959s;
    L10:
        if (r8 != 16) goto L13;
        this.f9961u = new String(this.f9953m, this.f9954n, this.f9960t);
        this.f9954n += this.f9960t;
    L29:
        this.f9958r = 11;
        double r12 = Double.parseDouble(this.f9961u);
        if (this.f9952b == false) goto L32;
    L38:
        this.f9961u = null;
        this.f9958r = 0;
        int[] r13 = this.f9965y;
        int r14 = this.f9963w - 1;
        r13[r14] = r13[r14] + 1;
        return r12;
    L32:
        if (Double.isNaN(r12) == true) goto L37;
        if (Double.isInfinite(r12) == false) goto L38;
    L37:
        throw new d("JSON forbids NaN and infinities: " + r12 + D());
    L13:
        if (r8 != 8) goto L15;
    L24:
        if (r8 != 8) goto L26;
        char r15 = '\'';
    L27:
        String r16 = c0(r15);
    L28:
        this.f9961u = r16;
        goto L29
    L26:
        r15 = '\"';
        goto L27
    L15:
        if (r8 == 9) goto L24;
        if (r8 != 10) goto L20;
        r16 = f0();
        goto L28
    L20:
        if (r8 == 11) goto L29;
        throw new IllegalStateException("Expected a double but was " + h0() + D());
    }

    public int H() {
        int r8 = this.f9958r;
        if (r8 != 0) goto L6;
        r8 = n();
    L6:
        if (r8 != 15) goto L14;
        long r10 = this.f9959s;
        int r11 = (int) r10;
        if (r10 != r11) goto L12;
        this.f9958r = 0;
        int[] r12 = this.f9965y;
        int r13 = this.f9963w - 1;
        r12[r13] = r12[r13] + 1;
        return r11;
    L12:
        throw new NumberFormatException("Expected an int but was " + this.f9959s + D());
    L14:
        if (r8 != 16) goto L17;
        this.f9961u = new String(this.f9953m, this.f9954n, this.f9960t);
        this.f9954n += this.f9960t;
    L33:
        this.f9958r = 11;
        double r14 = Double.parseDouble(this.f9961u);
        int r15 = (int) r14;
        if (r15 != r14) goto L38;
        this.f9961u = null;
        this.f9958r = 0;
        int[] r16 = this.f9965y;
        int r17 = this.f9963w - 1;
        r16[r17] = r16[r17] + 1;
        return r15;
    L38:
        throw new NumberFormatException("Expected an int but was " + this.f9961u + D());
    L17:
        if (r8 != 8) goto L19;
    L24:
        if (r8 != 10) goto L27;
        String r18 = f0();
    L26:
        this.f9961u = r18;
        int r19 = Integer.parseInt(this.f9961u);     // Catch: NumberFormatException -> L39
        this.f9958r = 0;     // Catch: NumberFormatException -> L39
        int[] r20 = this.f9965y;     // Catch: NumberFormatException -> L39
        int r21 = this.f9963w - 1;     // Catch: NumberFormatException -> L39
        r20[r21] = r20[r21] + 1;     // Catch: NumberFormatException -> L39
        return r19;
    L27:
        if (r8 != 8) goto L29;
        char r22 = '\'';
    L30:
        r18 = c0(r22);
        goto L26
    L29:
        r22 = '\"';
        goto L30
    L19:
        if (r8 == 9) goto L24;
        if (r8 == 10) goto L24;
        throw new IllegalStateException("Expected an int but was " + h0() + D());
    }

    public long I() {
        int r8 = this.f9958r;
        if (r8 != 0) goto L6;
        r8 = n();
    L6:
        if (r8 != 15) goto L10;
        this.f9958r = 0;
        int[] r10 = this.f9965y;
        int r11 = this.f9963w - 1;
        r10[r11] = r10[r11] + 1;
        return this.f9959s;
    L10:
        if (r8 != 16) goto L13;
        this.f9961u = new String(this.f9953m, this.f9954n, this.f9960t);
        this.f9954n += this.f9960t;
    L29:
        this.f9958r = 11;
        double r12 = Double.parseDouble(this.f9961u);
        long r13 = (long) r12;
        if (r13 != r12) goto L34;
        this.f9961u = null;
        this.f9958r = 0;
        int[] r14 = this.f9965y;
        int r15 = this.f9963w - 1;
        r14[r15] = r14[r15] + 1;
        return r13;
    L34:
        throw new NumberFormatException("Expected a long but was " + this.f9961u + D());
    L13:
        if (r8 != 8) goto L15;
    L20:
        if (r8 != 10) goto L23;
        String r16 = f0();
    L22:
        this.f9961u = r16;
        long r17 = Long.parseLong(this.f9961u);     // Catch: NumberFormatException -> L35
        this.f9958r = 0;     // Catch: NumberFormatException -> L35
        int[] r18 = this.f9965y;     // Catch: NumberFormatException -> L35
        int r19 = this.f9963w - 1;     // Catch: NumberFormatException -> L35
        r18[r19] = r18[r19] + 1;     // Catch: NumberFormatException -> L35
        return r17;
    L23:
        if (r8 != 8) goto L25;
        char r20 = '\'';
    L26:
        r16 = c0(r20);
        goto L22
    L25:
        r20 = '\"';
        goto L26
    L15:
        if (r8 == 9) goto L20;
        if (r8 == 10) goto L20;
        throw new IllegalStateException("Expected a long but was " + h0() + D());
    }

    public String J() {
        int r8 = this.f9958r;
        if (r8 != 0) goto L6;
        r8 = n();
    L6:
        if (r8 != 14) goto L9;
        String r10 = f0();
    L15:
        this.f9958r = 0;
        this.f9964x[this.f9963w - 1] = r10;
        return r10;
    L9:
        if (r8 != 12) goto L13;
        char r11 = '\'';
    L11:
        r10 = c0(r11);
        goto L15
    L13:
        if (r8 != 13) goto L18;
        r11 = '\"';
        goto L11
    L18:
        throw new IllegalStateException("Expected a name but was " + h0() + D());
    }

    public final int K(boolean r10) {
    L2:
        int r8 = this.f9954n;
    L3:
        int r11 = this.f9955o;
    L4:
        boolean r12 = true;
        if (r8 != r11) goto L14;
        this.f9954n = r8;
        if (w(1) == false) goto L8;
        r8 = this.f9954n;
        r11 = this.f9955o;
        goto L14
    L8:
        if (r10 == true) goto L12;
        return -1;
    L12:
        throw new EOFException("End of input" + D());
    L14:
        int r13 = r8 + 1;
        char[] r14 = this.f9953m;
        char r15 = r14[r8];
        if (r15 != '\n') goto L18;
        this.f9956p++;
        this.f9957q = r13;
    L60:
        r8 = r13;
        goto L4
    L18:
        if (r15 == ' ') goto L60;
        if (r15 == '\r') goto L60;
        if (r15 == '\t') goto L60;
        this.f9954n = r13;
        if (r15 != '/') goto L56;
        if (r13 != r11) goto L31;
        this.f9954n = r13 - 1;
        boolean r16 = w(2);
        this.f9954n++;
        if (r16 == true) goto L31;
        return r15;
    L31:
        k();
        int r17 = this.f9954n;
        char r18 = r14[r17];
        if (r18 != '*') goto L33;
        this.f9954n = r17 + 1;
    L37:
        int r19 = 0;
        if ((this.f9954n + 2) > this.f9955o) goto L40;
    L43:
        int r20 = this.f9954n;
        if (r14[r20] != '\n') goto L46;
        this.f9956p++;
        this.f9957q = r20 + 1;
    L49:
        this.f9954n++;
    L46:
        if (r19 >= 2) goto L51;
        if (r14[this.f9954n + r19] != "*/".charAt(r19)) goto L49;
        r19 = r19 + 1;
    L51:
        if (r12 == false) goto L53;
        r8 = this.f9954n + 2;
        goto L3
    L53:
        v0("Unterminated comment");
        throw null;
    L40:
        if (w(2) == true) goto L43;
        r12 = false;
        goto L51
    L33:
        if (r18 != '/') goto L34;
        this.f9954n = r17 + 1;
    L58:
        s0();
        goto L2
    L34:
        return r15;
    L56:
        if (r15 != '#') goto L59;
        k();
        goto L58
    L59:
        return r15;
    }

    public void V() {
        int r8 = this.f9958r;
        if (r8 != 0) goto L6;
        r8 = n();
    L6:
        if (r8 != 7) goto L10;
        this.f9958r = 0;
        int[] r10 = this.f9965y;
        int r11 = this.f9963w - 1;
        r10[r11] = r10[r11] + 1;
        return;
    L10:
        throw new IllegalStateException("Expected null but was " + h0() + D());
    }

    public void a() {
        int r8 = this.f9958r;
        if (r8 != 0) goto L6;
        r8 = n();
    L6:
        if (r8 != 3) goto L10;
        m0(1);
        this.f9965y[this.f9963w - 1] = 0;
        this.f9958r = 0;
        return;
    L10:
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + h0() + D());
    }

    public final String c0(char r11) {
        StringBuilder r8 = null;
    L3:
        int r10 = this.f9954n;
        int r12 = this.f9955o;
        int r13 = r10;
    L4:
        char[] r14 = this.f9953m;
        if (r13 >= r12) goto L24;
        int r15 = r13 + 1;
        char r16 = r14[r13];
        if (r16 == r11) goto L8;
        if (r16 == '\\') goto L16;
        if (r16 != '\n') goto L23;
        this.f9956p++;
        this.f9957q = r15;
    L23:
        r13 = r15;
        goto L4
    L16:
        this.f9954n = r15;
        int r17 = (r15 - r10) - 1;
        if (r8 != null) goto L19;
        r8 = new StringBuilder(Math.max((r17 + 1) * 2, 16));
    L19:
        r8.append(r14, r10, r17);
        r8.append(q0());
        goto L3
    L8:
        this.f9954n = r15;
        int r18 = (r15 - r10) - 1;
        if (r8 == null) goto L11;
        r8.append(r14, r10, r18);
        return r8.toString();
    L11:
        return new String(r14, r10, r18);
    L24:
        if (r8 != null) goto L26;
        r8 = new StringBuilder(Math.max((r13 - r10) * 2, 16));
    L26:
        r8.append(r14, r10, r13 - r10);
        this.f9954n = r13;
        if (w(1) == true) goto L3;
        v0("Unterminated string");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9958r = 0;
        this.f9962v[0] = 8;
        this.f9963w = 1;
        this.f9951a.close();
    }

    public String e0() {
        int r8 = this.f9958r;
        if (r8 != 0) goto L6;
        r8 = n();
    L6:
        if (r8 != 10) goto L9;
        String r10 = f0();
    L24:
        this.f9958r = 0;
        int[] r11 = this.f9965y;
        int r12 = this.f9963w - 1;
        r11[r12] = r11[r12] + 1;
        return r10;
    L9:
        if (r8 != 8) goto L13;
        char r13 = '\'';
    L11:
        r10 = c0(r13);
        goto L24
    L13:
        if (r8 != 9) goto L16;
        r13 = '\"';
        goto L11
    L16:
        if (r8 != 11) goto L19;
        r10 = this.f9961u;
        this.f9961u = null;
        goto L24
    L19:
        if (r8 != 15) goto L22;
        r10 = Long.toString(this.f9959s);
        goto L24
    L22:
        if (r8 != 16) goto L27;
        r10 = new String(this.f9953m, this.f9954n, this.f9960t);
        this.f9954n += this.f9960t;
        goto L24
    L27:
        throw new IllegalStateException("Expected a string but was " + h0() + D());
    }

    public final String f0() {
        StringBuilder r8 = null;
        int r10 = 0;
    L3:
        int r11 = 0;
    L4:
        int r12 = this.f9954n;
        int r13 = r12 + r11;
        int r14 = this.f9955o;
        char[] r15 = this.f9953m;
        if (r13 < r14) goto L6;
        if (r11 >= r15.length) goto L41;
        if (w(r11 + 1) == true) goto L4;
    L40:
        r10 = r11;
    L45:
        if (r8 != null) goto L47;
        String r16 = new String(r15, this.f9954n, r10);
    L48:
        this.f9954n += r10;
        return r16;
    L47:
        r8.append(r15, this.f9954n, r10);
        r16 = r8.toString();
        goto L48
    L41:
        if (r8 != null) goto L43;
        r8 = new StringBuilder(Math.max(r11, 16));
    L43:
        r8.append(r15, this.f9954n, r11);
        this.f9954n += r11;
        if (w(1) == true) goto L3;
    L6:
        char r17 = r15[r12 + r11];
        if (r17 == '\t') goto L40;
        if (r17 == '\n') goto L40;
        if (r17 == '\f') goto L40;
        if (r17 == '\r') goto L40;
        if (r17 == ' ') goto L40;
        if (r17 == '#') goto L34;
        if (r17 == ',') goto L40;
        if (r17 == '/') goto L34;
        if (r17 == '=') goto L34;
        if (r17 == '{') goto L40;
        if (r17 == '}') goto L40;
        if (r17 == ':') goto L40;
        if (r17 == ';') goto L34;
        switch(r17) {
            case 91: goto L40;
            case 92: goto L34;
            case 93: goto L40;
            default: goto L33;
        };
    L33:
        r11 = r11 + 1;
    L34:
        k();
        goto L40
    }

    public b h0() {
        int r8 = this.f9958r;
        if (r8 != 0) goto L5;
        r8 = n();
    L5:
        switch(r8) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L23;
            case 4: goto L21;
            case 5: goto L19;
            case 6: goto L19;
            case 7: goto L17;
            case 8: goto L15;
            case 9: goto L15;
            case 10: goto L15;
            case 11: goto L15;
            case 12: goto L13;
            case 13: goto L13;
            case 14: goto L13;
            case 15: goto L11;
            case 16: goto L11;
            case 17: goto L9;
            default: goto L7;
        };
    L7:
        throw new AssertionError();
    L9:
        return b.f9975t;
    L11:
        return b.f9972q;
    L13:
        return b.f9970o;
    L15:
        return b.f9971p;
    L17:
        return b.f9974s;
    L19:
        return b.f9973r;
    L21:
        return b.f9967b;
    L23:
        return b.f9966a;
    L25:
        return b.f9969n;
    L27:
        return b.f9968m;
    }

    public void i() {
        int r8 = this.f9958r;
        if (r8 != 0) goto L6;
        r8 = n();
    L6:
        if (r8 != 1) goto L10;
        m0(3);
        this.f9958r = 0;
        return;
    L10:
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + h0() + D());
    }

    public final void k() {
        if (this.f9952b == false) goto L5;
        return;
    L5:
        v0("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    public final void m0(int r8) {
        int r10 = this.f9963w;
        int[] r11 = this.f9962v;
        if (r10 != r11.length) goto L5;
        int r12 = r10 * 2;
        this.f9962v = Arrays.copyOf(r11, r12);
        this.f9965y = Arrays.copyOf(this.f9965y, r12);
        this.f9964x = (String[]) Arrays.copyOf(this.f9964x, r12);
    L5:
        int[] r13 = this.f9962v;
        int r14 = this.f9963w;
        this.f9963w = r14 + 1;
        r13[r14] = r8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v5 */
    public final int n() {
        int[] r8 = this.f9962v;
        int r10 = this.f9963w;
        int r11 = r8[r10 - 1];
        char[] r12 = this.f9953m;
        boolean r13 = true;
        if (r11 != 1) goto L6;
        r8[r10 - 1] = 2;
    L57:
        int r14 = 8;
    L66:
        int r15 = K(true);
        if (r15 == 34) goto L232;
        if (r15 == 39) goto L231;
        if (r15 == 44) goto L223;
        if (r15 == 59) goto L223;
        if (r15 == 91) goto L221;
        if (r15 != 93) goto L75;
        int r16 = 1;
        if (r11 != 1) goto L224;
        int r17 = 4;
    L261:
        this.f9958r = r17;
        return r17;
    L224:
        if (r11 != r16) goto L226;
    L230:
        k();
        this.f9954n -= r16;
        int r18 = 7;
    L267:
        this.f9958r = r18;
        return r18;
    L226:
        if (r11 == 2) goto L230;
        v0("Unexpected value");
        throw null;
    L75:
        if (r15 == 123) goto L217;
        int r19 = this.f9954n - 1;
        this.f9954n = r19;
        char r20 = r12[r19];
        if (r20 != 't') goto L79;
    L92:
        String r21 = "true";
        String r22 = "TRUE";
        int r23 = 5;
    L93:
        int r24 = r21.length();
        int r110 = 1;
    L94:
        if (r110 >= r24) goto L107;
        if ((this.f9954n + r110) >= this.f9955o) goto L98;
    L100:
        char r111 = r12[this.f9954n + r110];
        if (r111 == r21.charAt(r110)) goto L105;
        if (r111 == r22.charAt(r110)) goto L105;
    L112:
        r23 = 0;
    L114:
        if (r23 == 0) goto L116;
        return r23;
    L116:
        int r25 = this.f9954n;
        int r26 = this.f9955o;
        boolean r112 = true;
        long r27 = 0;
        char r28 = 0;
        int r113 = 0;
        boolean r114 = false;
    L118:
        if ((r25 + r113) == r26) goto L120;
    L126:
        char r29 = r12[r25 + r113];
        if (r29 == '+') goto L206;
        if (r29 == 'E') goto L201;
        if (r29 == 'e') goto L201;
        if (r29 == '-') goto L195;
        if (r29 == '.') goto L192;
        if (r29 < '0') goto L169;
        if (r29 > '9') goto L169;
        if (r28 == r13) goto L167;
        if (r28 == 0) goto L167;
        if (r28 == 2) goto L147;
        if (r28 != 3) goto L161;
        r28 = 4;
    L208:
        r113 = r113 + 1;
        r13 = true;
        goto L118
    L161:
        if (r28 == 5) goto L166;
        if (r28 != 6) goto L208;
    L166:
        r28 = 7;
        goto L208
    L147:
        if (r27 == 0) goto L209;
        long r115 = (10 * r27) - ((long) (r29 - '0'));
        if (r27 > (-922337203685477580L)) goto L156;
        if (r27 == (-922337203685477580L)) goto L153;
    L155:
        boolean r30 = false;
    L157:
        r112 = r112 & r30;
        r27 = r115;
        goto L208
    L153:
        if (r115 >= r27) goto L155;
    L156:
        r30 = true;
    L209:
        int r31 = 0;
    L210:
        if (r31 == 0) goto L213;
        return r31;
    L213:
        if (C(r12[this.f9954n]) == false) goto L215;
        k();
        r18 = 10;
        goto L267
    L215:
        v0("Expected value");
        throw null;
    L167:
        r27 = -(r29 - '0');
        r28 = 2;
    L169:
        if (C(r29) == true) goto L209;
    L170:
        char r32 = 2;
        if (r28 != 2) goto L184;
        if (r112 == true) goto L174;
    L183:
        r32 = 2;
        goto L184
    L174:
        if (r27 != Long.MIN_VALUE) goto L177;
        if (r114 == false) goto L183;
    L177:
        if (r27 != 0) goto L179;
        if (r114 == true) goto L183;
    L179:
        if (r114 == true) goto L182;
        r27 = -r27;
    L182:
        this.f9959s = r27;
        this.f9954n += r113;
        int r33 = 15;
    L190:
        r31 = r33;
        this.f9958r = r31;
    L184:
        if (r28 != r32) goto L186;
    L189:
        this.f9960t = r113;
        r33 = 16;
        goto L190
    L186:
        if (r28 == 4) goto L189;
        if (r28 != 7) goto L209;
    L192:
        if (r28 != 2) goto L209;
        r28 = 3;
        goto L208
    L195:
        if (r28 != 0) goto L198;
        r28 = 1;
        r114 = true;
        goto L208
    L198:
        if (r28 != 5) goto L209;
    L207:
        r28 = 6;
    L201:
        if (r28 != 2) goto L203;
    L204:
        r28 = 5;
        goto L208
    L203:
        if (r28 != 4) goto L209;
    L206:
        if (r28 != 5) goto L209;
    L120:
        if (r113 == r12.length) goto L209;
        if (w(r113 + 1) == false) goto L170;
        r25 = this.f9954n;
        r26 = this.f9955o;
    L105:
        r110 = r110 + 1;
        goto L94
    L98:
        if (w(r110 + 1) == true) goto L100;
    L107:
        if ((this.f9954n + r24) < this.f9955o) goto L111;
        if (w(r24 + 1) == true) goto L111;
    L113:
        this.f9954n += r24;
        this.f9958r = r23;
    L111:
        if (C(r12[this.f9954n + r24]) == false) goto L113;
    L79:
        if (r20 == 'T') goto L92;
        if (r20 != 'f') goto L84;
    L91:
        r21 = "false";
        r22 = "FALSE";
        r23 = 6;
        goto L93
    L84:
        if (r20 == 'F') goto L91;
        if (r20 != 'n') goto L89;
    L90:
        r21 = "null";
        r22 = "NULL";
        r23 = 7;
        goto L93
    L89:
        if (r20 != 'N') goto L112;
    L217:
        r18 = 1;
        goto L267
    L221:
        this.f9958r = 3;
        return 3;
    L223:
        r16 = 1;
        goto L224
    L231:
        k();
        r18 = r14;
        goto L267
    L232:
        r18 = 9;
        goto L267
    L6:
        if (r11 != 2) goto L17;
        int r34 = K(true);
        if (r34 == 44) goto L57;
        if (r34 == 59) goto L15;
        if (r34 != 93) goto L13;
        this.f9958r = 4;
        return 4;
    L13:
        v0("Unterminated array");
        throw null;
    L15:
        k();
        goto L57
    L17:
        if (r11 == 3) goto L235;
        if (r11 != 5) goto L20;
        ?? r35 = 1;
        r18 = 2;
    L236:
        r8[r10 - r35] = 4;
        if (r11 != 5) goto L247;
        int r36 = K(r35);
        if (r36 == 44) goto L246;
        if (r36 == 59) goto L245;
        if (r36 == 125) goto L267;
        v0("Unterminated object");
        throw null;
    L245:
        k();
    L246:
        ?? r37 = 1;
    L248:
        int r38 = K(r37);
        if (r38 == 34) goto L266;
        if (r38 != 39) goto L252;
        k();
        r18 = 12;
        goto L267
    L252:
        if (r38 == 125) goto L259;
        k();
        this.f9954n -= r37;
        if (C((char) r38) == false) goto L256;
        r18 = 14;
        goto L267
    L256:
        v0("Expected name");
        throw null;
    L259:
        if (r11 == 5) goto L263;
        r17 = r18;
        goto L261
    L263:
        v0("Expected name");
        throw null;
    L266:
        r18 = 13;
        goto L267
    L247:
        r37 = r35;
        goto L248
    L20:
        if (r11 != 4) goto L34;
        r8[r10 - 1] = 5;
        int r39 = K(true);
        if (r39 == 58) goto L57;
        if (r39 != 61) goto L32;
        k();
        if (this.f9954n >= this.f9955o) goto L28;
    L29:
        int r40 = this.f9954n;
        if (r12[r40] != '>') goto L57;
        this.f9954n = r40 + 1;
        goto L57
    L28:
        if (w(1) == false) goto L57;
    L32:
        v0("Expected ':'");
        throw null;
    L34:
        if (r11 != 6) goto L59;
        if (this.f9952b == false) goto L55;
        K(true);
        int r41 = this.f9954n - 1;
        this.f9954n = r41;
        if ((r41 + 5) > this.f9955o) goto L40;
    L42:
        int r42 = this.f9954n;
        if (r12[r42] != ')') goto L55;
        if (r12[r42 + 1] != ']') goto L55;
        if (r12[r42 + 2] != '}') goto L55;
        if (r12[r42 + 3] != '\'') goto L55;
        if (r12[r42 + 4] != '\n') goto L55;
        this.f9954n = r42 + 5;
        goto L55
    L40:
        if (w(5) == true) goto L42;
    L55:
        this.f9962v[this.f9963w - 1] = 7;
        goto L57
    L59:
        if (r11 == 7) goto L61;
        r14 = 8;
        if (r11 != 8) goto L66;
        throw new IllegalStateException("JsonReader is closed");
    L61:
        if (K(false) != (-1)) goto L63;
        r18 = 17;
        goto L267
    L63:
        k();
        this.f9954n--;
        goto L57
    L235:
        r18 = 2;
        r35 = 1;
        goto L236
    }

    public final char q0() {
        if (this.f9954n == this.f9955o) goto L5;
    L9:
        int r8 = this.f9954n;
        int r10 = r8 + 1;
        this.f9954n = r10;
        char[] r11 = this.f9953m;
        char r12 = r11[r8];
        if (r12 != '\n') goto L12;
        this.f9956p++;
        this.f9957q = r10;
    L72:
        return r12;
    L12:
        if (r12 == '\"') goto L72;
        if (r12 == '\'') goto L72;
        if (r12 == '/') goto L72;
        if (r12 == '\\') goto L72;
        if (r12 != 'b') goto L22;
        return '\b';
    L22:
        if (r12 != 'f') goto L24;
        return '\f';
    L24:
        if (r12 != 'n') goto L26;
        return '\n';
    L26:
        if (r12 != 'r') goto L28;
        return '\r';
    L28:
        if (r12 != 't') goto L30;
        return '\t';
    L30:
        if (r12 == 'u') goto L32;
        v0("Invalid escape sequence");
        throw null;
    L32:
        if ((r10 + 4) > this.f9955o) goto L34;
    L38:
        int r13 = this.f9954n;
        int r14 = r13 + 4;
        char r15 = 0;
    L39:
        if (r13 >= r14) goto L58;
        char r16 = r11[r13];
        char r17 = (char) (r15 << 4);
        if (r16 < '0') goto L46;
        if (r16 > '9') goto L46;
        int r18 = r16 - '0';
    L55:
        r15 = (char) (r18 + r17);
        r13 = r13 + 1;
    L46:
        if (r16 < 'a') goto L50;
        if (r16 > 'f') goto L50;
        int r19 = r16 - 'a';
    L54:
        r18 = r19 + 10;
    L50:
        if (r16 < 'A') goto L57;
        if (r16 > 'F') goto L57;
        r19 = r16 - 'A';
    L57:
        throw new NumberFormatException("\\u".concat(new String(r11, this.f9954n, 4)));
    L58:
        this.f9954n += 4;
        return r15;
    L34:
        if (w(4) == true) goto L38;
        v0("Unterminated escape sequence");
        throw null;
    L5:
        if (w(1) == true) goto L9;
        v0("Unterminated escape sequence");
        throw null;
    }

    public void r() {
        int r8 = this.f9958r;
        if (r8 != 0) goto L6;
        r8 = n();
    L6:
        if (r8 != 4) goto L10;
        int r10 = this.f9963w - 1;
        this.f9963w = r10;
        int[] r11 = this.f9965y;
        int r12 = r10 - 1;
        r11[r12] = r11[r12] + 1;
        this.f9958r = 0;
        return;
    L10:
        throw new IllegalStateException("Expected END_ARRAY but was " + h0() + D());
    }

    public final void r0(char r8) {
    L2:
        int r10 = this.f9954n;
        int r11 = this.f9955o;
    L4:
        if (r10 >= r11) goto L16;
        int r12 = r10 + 1;
        char r13 = this.f9953m[r10];
        if (r13 == r8) goto L7;
        if (r13 == '\\') goto L11;
        if (r13 != '\n') goto L15;
        this.f9956p++;
        this.f9957q = r12;
    L15:
        r10 = r12;
        goto L4
    L11:
        this.f9954n = r12;
        q0();
        goto L2
    L7:
        this.f9954n = r12;
        return;
    L16:
        this.f9954n = r10;
        if (w(1) == true) goto L2;
        v0("Unterminated string");
        throw null;
    }

    public final void s0() {
    L3:
        if (this.f9954n >= this.f9955o) goto L5;
    L6:
        int r8 = this.f9954n;
        int r10 = r8 + 1;
        this.f9954n = r10;
        char r11 = this.f9953m[r8];
        if (r11 == '\n') goto L8;
        if (r11 != '\r') goto L3;
        return;
    L8:
        this.f9956p++;
        this.f9957q = r10;
        return;
    L5:
        if (w(1) == true) goto L6;
    }

    public final void t0() {
    L2:
        int r8 = 0;
    L3:
        int r10 = this.f9954n;
        if ((r10 + r8) >= this.f9955o) goto L36;
        char r11 = this.f9953m[r10 + r8];
        if (r11 == '\t') goto L34;
        if (r11 == '\n') goto L34;
        if (r11 == '\f') goto L34;
        if (r11 == '\r') goto L34;
        if (r11 == ' ') goto L34;
        if (r11 == '#') goto L33;
        if (r11 == ',') goto L34;
        if (r11 == '/') goto L33;
        if (r11 == '=') goto L33;
        if (r11 == '{') goto L34;
        if (r11 == '}') goto L34;
        if (r11 == ':') goto L34;
        if (r11 == ';') goto L33;
        switch(r11) {
            case 91: goto L34;
            case 92: goto L33;
            case 93: goto L34;
            default: goto L32;
        };
    L32:
        r8 = r8 + 1;
    L33:
        k();
    L34:
        this.f9954n += r8;
        return;
    L36:
        this.f9954n = r10 + r8;
        if (w(1) == true) goto L2;
    }

    public String toString() {
        return getClass().getSimpleName() + D();
    }

    public void u0() {
        int r8 = 0;
    L3:
        int r10 = this.f9958r;
        if (r10 != 0) goto L7;
        r10 = n();
    L7:
        switch(r10) {
            case 1: goto L27;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L29;
            case 6: goto L29;
            case 7: goto L29;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L29;
            case 12: goto L17;
            case 13: goto L14;
            case 14: goto L11;
            case 15: goto L29;
            case 16: goto L10;
            case 17: goto L9;
            default: goto L29;
        };
    L10:
        this.f9954n += this.f9960t;
        goto L29
    L11:
        t0();
        if (r8 != 0) goto L29;
        this.f9964x[this.f9963w - 1] = "<skipped>";
        goto L29
    L14:
        r0('\"');
        if (r8 != 0) goto L29;
        this.f9964x[this.f9963w - 1] = "<skipped>";
        goto L29
    L17:
        r0('\'');
        if (r8 != 0) goto L29;
        this.f9964x[this.f9963w - 1] = "<skipped>";
        goto L29
    L20:
        t0();
        goto L29
    L21:
        r0('\"');
        goto L29
    L22:
        r0('\'');
    L23:
        this.f9963w--;
        r8 = r8 - 1;
        goto L29
    L24:
        m0(1);
    L28:
        r8 = r8 + 1;
        goto L29
    L25:
        if (r8 != 0) goto L23;
        this.f9964x[this.f9963w - 1] = null;
        goto L23
    L27:
        m0(3);
    L29:
        this.f9958r = 0;
        if (r8 > 0) goto L3;
        int[] r11 = this.f9965y;
        int r12 = this.f9963w - 1;
        r11[r12] = r11[r12] + 1;
        return;
    }

    public void v() {
        int r8 = this.f9958r;
        if (r8 != 0) goto L6;
        r8 = n();
    L6:
        if (r8 != 2) goto L10;
        int r10 = this.f9963w - 1;
        this.f9963w = r10;
        this.f9964x[r10] = null;
        int[] r11 = this.f9965y;
        int r12 = r10 - 1;
        r11[r12] = r11[r12] + 1;
        this.f9958r = 0;
        return;
    L10:
        throw new IllegalStateException("Expected END_OBJECT but was " + h0() + D());
    }

    public final void v0(String r8) {
        StringBuilder r10 = android.aimedia.a.j(r8);
        r10.append(D());
        throw new d(r10.toString());
    }

    public final boolean w(int r8) {
        int r10 = this.f9957q;
        int r11 = this.f9954n;
        this.f9957q = r10 - r11;
        int r12 = this.f9955o;
        char[] r13 = this.f9953m;
        if (r12 == r11) goto L5;
        int r14 = r12 - r11;
        this.f9955o = r14;
        System.arraycopy(r13, r11, r13, 0, r14);
    L6:
        this.f9954n = 0;
    L7:
        int r15 = this.f9955o;
        int r16 = this.f9951a.read(r13, r15, r13.length - r15);
        if (r16 == (-1)) goto L19;
        int r17 = this.f9955o + r16;
        this.f9955o = r17;
        if (this.f9956p != 0) goto L17;
        int r18 = this.f9957q;
        if (r18 != 0) goto L17;
        if (r17 <= 0) goto L17;
        if (r13[0] != 65279) goto L17;
        this.f9954n++;
        this.f9957q = r18 + 1;
        r8 = r8 + 1;
    L17:
        if (r17 < r8) goto L7;
        return true;
    L19:
        return false;
    L5:
        this.f9955o = 0;
        goto L6
    }

    public String x() {
        return z(false);
    }

    public final String z(boolean r8) {
        StringBuilder r10 = new StringBuilder("$");
        int r11 = 0;
    L3:
        int r12 = this.f9963w;
        if (r11 >= r12) goto L28;
        int r13 = this.f9962v[r11];
        if (r13 != 1) goto L8;
    L19:
        int r14 = this.f9965y[r11];
        if (r8 == false) goto L25;
        if (r14 <= 0) goto L25;
        if (r11 != (r12 - 1)) goto L25;
        r14 = r14 - 1;
    L25:
        r10.append('[');
        r10.append(r14);
        r10.append(']');
    L26:
        r11 = r11 + 1;
        goto L3
    L8:
        if (r13 == 2) goto L19;
        if (r13 != 3) goto L12;
    L16:
        r10.append('.');
        String r15 = this.f9964x[r11];
        if (r15 == null) goto L26;
        r10.append(r15);
        goto L26
    L12:
        if (r13 == 4) goto L16;
        if (r13 == 5) goto L16;
    L28:
        return r10.toString();
    }
}
