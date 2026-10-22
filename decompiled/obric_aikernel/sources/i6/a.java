package i6;

import com.google.gson.internal.e;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import e6.f;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Reader f9380c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f9381g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final char[] f9382h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f9383i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9384j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f9385k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f9386l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f9387m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f9388n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f9389o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f9390p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int[] f9391q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f9392r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String[] f9393s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int[] f9394t;

    /* JADX INFO: renamed from: i6.a$a, reason: collision with other inner class name */
    class C0181a extends e {
        C0181a() {
        }

        @Override // com.google.gson.internal.e
        public void a(a r10) {
            if ((r10 instanceof f) == false) goto L6;
            ((f) r10).p0();
            return;
        L6:
            int r11 = r10.f9387m;
            if (r11 != 0) goto L10;
            r11 = r10.k();
        L10:
            if (r11 != 13) goto L14;
            int r12 = 9;
        L12:
            r10.f9387m = r12;
            return;
        L14:
            if (r11 != 12) goto L17;
            r12 = 8;
            goto L12
        L17:
            if (r11 != 14) goto L21;
            r12 = 10;
            goto L12
        L21:
            throw new IllegalStateException("Expected a name but was " + r10.Q() + r10.B());
        }
    }

    static {
        e.f4260a = new C0181a();
    }

    public a(Reader r10) {
        this.f9381g = false;
        this.f9382h = new char[1024];
        this.f9383i = 0;
        this.f9384j = 0;
        this.f9385k = 0;
        this.f9386l = 0;
        this.f9387m = 0;
        int[] r11 = new int[32];
        this.f9391q = r11;
        this.f9392r = 0;
        this.f9392r = 0 + 1;
        r11[0] = 6;
        this.f9393s = new String[32];
        this.f9394t = new int[32];
        Objects.requireNonNull(r10, "in == null");
        this.f9380c = r10;
    }

    private boolean A(char r10) {
        if (r10 != '\t') goto L5;
        return false;
    L5:
        if (r10 != '\n') goto L7;
        return false;
    L7:
        if (r10 != '\f') goto L9;
        return false;
    L9:
        if (r10 != '\r') goto L11;
        return false;
    L11:
        if (r10 != ' ') goto L13;
        return false;
    L13:
        if (r10 != '#') goto L15;
    L31:
        f();
        return false;
    L15:
        if (r10 != ',') goto L17;
        return false;
    L17:
        if (r10 == '/') goto L31;
        if (r10 == '=') goto L31;
        if (r10 != '{') goto L23;
        return false;
    L23:
        if (r10 != '}') goto L25;
        return false;
    L25:
        if (r10 != ':') goto L27;
        return false;
    L27:
        if (r10 == ';') goto L31;
        switch(r10) {
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

    private int J(boolean r10) {
        char[] r11 = this.f9382h;
    L3:
        int r12 = this.f9383i;
    L4:
        int r13 = this.f9384j;
    L6:
        if (r12 != r13) goto L15;
        this.f9383i = r12;
        if (p(1) == false) goto L9;
        r12 = this.f9383i;
        r13 = this.f9384j;
        goto L15
    L9:
        if (r10 == true) goto L13;
        return -1;
    L13:
        throw new EOFException("End of input" + B());
    L15:
        int r14 = r12 + 1;
        char r15 = r11[r12];
        if (r15 != '\n') goto L19;
        this.f9385k++;
        this.f9386l = r14;
    L47:
        r12 = r14;
        goto L6
    L19:
        if (r15 == ' ') goto L47;
        if (r15 == '\r') goto L47;
        if (r15 == '\t') goto L47;
        if (r15 != '/') goto L43;
        this.f9383i = r14;
        if (r14 != r13) goto L32;
        this.f9383i = r14 - 1;
        boolean r16 = p(2);
        this.f9383i++;
        if (r16 == true) goto L32;
        return r15;
    L32:
        f();
        int r17 = this.f9383i;
        char r18 = r11[r17];
        if (r18 != '*') goto L34;
        this.f9383i = r17 + 1;
        if (f0("*/") == false) goto L42;
        r12 = this.f9383i + 2;
        goto L4
    L42:
        throw j0("Unterminated comment");
    L34:
        if (r18 != '/') goto L35;
        this.f9383i = r17 + 1;
    L37:
        g0();
        goto L3
    L35:
        return r15;
    L43:
        this.f9383i = r14;
        if (r15 != '#') goto L46;
        f();
        goto L37
    L46:
        return r15;
    }

    private String M(char r10) {
        char[] r11 = this.f9382h;
        StringBuilder r12 = null;
    L3:
        int r13 = this.f9383i;
        int r14 = this.f9384j;
    L5:
        if (r13 >= r14) goto L24;
        int r15 = r13 + 1;
        char r16 = r11[r13];
        if (r16 == r10) goto L8;
        if (r16 == '\\') goto L16;
        if (r16 != '\n') goto L23;
        this.f9385k++;
        this.f9386l = r15;
    L23:
        r13 = r15;
        goto L5
    L16:
        this.f9383i = r15;
        int r17 = (r15 - r13) - 1;
        if (r12 != null) goto L19;
        r12 = new StringBuilder(Math.max((r17 + 1) * 2, 16));
    L19:
        r12.append(r11, r13, r17);
        r12.append(c0());
        goto L3
    L8:
        this.f9383i = r15;
        int r18 = (r15 - r13) - 1;
        if (r12 == null) goto L11;
        r12.append(r11, r13, r18);
        return r12.toString();
    L11:
        return new String(r11, r13, r18);
    L24:
        if (r12 != null) goto L26;
        r12 = new StringBuilder(Math.max((r13 - r13) * 2, 16));
    L26:
        r12.append(r11, r13, r13 - r13);
        this.f9383i = r13;
        if (p(1) == true) goto L3;
        throw j0("Unterminated string");
    }

    private String P() {
        int r10 = 0;
        StringBuilder r11 = null;
    L3:
        int r12 = 0;
    L4:
        int r13 = this.f9383i;
        if ((r13 + r12) < this.f9384j) goto L6;
        if (r12 >= this.f9382h.length) goto L41;
        if (p(r12 + 1) == true) goto L4;
    L40:
        r10 = r12;
    L45:
        if (r11 != null) goto L47;
        String r14 = new String(this.f9382h, this.f9383i, r10);
    L48:
        this.f9383i += r10;
        return r14;
    L47:
        r11.append(this.f9382h, this.f9383i, r10);
        r14 = r11.toString();
        goto L48
    L41:
        if (r11 != null) goto L43;
        r11 = new StringBuilder(Math.max(r12, 16));
    L43:
        r11.append(this.f9382h, this.f9383i, r12);
        this.f9383i += r12;
        if (p(1) == true) goto L3;
    L6:
        char r15 = this.f9382h[r13 + r12];
        if (r15 == '\t') goto L40;
        if (r15 == '\n') goto L40;
        if (r15 == '\f') goto L40;
        if (r15 == '\r') goto L40;
        if (r15 == ' ') goto L40;
        if (r15 == '#') goto L34;
        if (r15 == ',') goto L40;
        if (r15 == '/') goto L34;
        if (r15 == '=') goto L34;
        if (r15 == '{') goto L40;
        if (r15 == '}') goto L40;
        if (r15 == ':') goto L40;
        if (r15 == ';') goto L34;
        switch(r15) {
            case 91: goto L40;
            case 92: goto L34;
            case 93: goto L40;
            default: goto L33;
        };
    L33:
        r12 = r12 + 1;
    L34:
        f();
        goto L40
    }

    private int V() {
        char r10 = this.f9382h[this.f9383i];
        if (r10 != 't') goto L5;
    L20:
        int r11 = 5;
        String r12 = "true";
        String r13 = "TRUE";
    L21:
        int r14 = r12.length();
        int r15 = 1;
    L22:
        if (r15 >= r14) goto L35;
        if ((this.f9383i + r15) >= this.f9384j) goto L26;
    L28:
        char r16 = this.f9382h[this.f9383i + r15];
        if (r16 == r12.charAt(r15)) goto L33;
        if (r16 == r13.charAt(r15)) goto L33;
        return 0;
    L33:
        r15 = r15 + 1;
        goto L22
    L26:
        if (p(r15 + 1) == true) goto L28;
        return 0;
    L35:
        if ((this.f9383i + r14) < this.f9384j) goto L39;
        if (p(r14 + 1) == true) goto L39;
    L41:
        this.f9383i += r14;
        this.f9387m = r11;
        return r11;
    L39:
        if (A(this.f9382h[this.f9383i + r14]) == false) goto L41;
        return 0;
    L5:
        if (r10 == 'T') goto L20;
        if (r10 != 'f') goto L10;
    L19:
        r11 = 6;
        r12 = "false";
        r13 = "FALSE";
        goto L21
    L10:
        if (r10 == 'F') goto L19;
        if (r10 != 'n') goto L15;
    L18:
        r11 = 7;
        r12 = "null";
        r13 = "NULL";
        goto L21
    L15:
        if (r10 == 'N') goto L18;
        return 0;
    }

    private int X() {
        char[] r10 = this.f9382h;
        int r11 = this.f9383i;
        int r12 = this.f9384j;
        int r13 = 0;
        boolean r14 = true;
        int r15 = 0;
        char r16 = 0;
        boolean r17 = false;
        long r18 = 0;
    L4:
        if ((r11 + r15) == r12) goto L6;
    L12:
        char r19 = r10[r11 + r15];
        char r20 = 3;
        if (r19 != '+') goto L15;
        r20 = 6;
        r13 = 0;
        if (r16 != 5) goto L101;
    L99:
        r16 = r20;
    L100:
        r15 = r15 + 1;
        goto L4
    L101:
        return 0;
    L15:
        if (r19 != 'E') goto L17;
    L90:
        r13 = 0;
        if (r16 != 2) goto L93;
    L96:
        r16 = 5;
        goto L100
    L93:
        if (r16 == 4) goto L96;
        return 0;
    L17:
        if (r19 == 'e') goto L90;
        if (r19 != '-') goto L21;
        r20 = 6;
        r13 = 0;
        if (r16 != 0) goto L87;
        r16 = 1;
        r17 = true;
        goto L100
    L87:
        if (r16 == 5) goto L99;
        return 0;
    L21:
        if (r19 != '.') goto L23;
        r13 = 0;
        if (r16 == 2) goto L99;
        return 0;
    L23:
        if (r19 < '0') goto L54;
        if (r19 > '9') goto L54;
        if (r16 == 1) goto L50;
        if (r16 == 0) goto L50;
        if (r16 == 2) goto L32;
        if (r16 != 3) goto L46;
        r13 = 0;
        r16 = 4;
        goto L100
    L46:
        if (r16 != 5) goto L48;
    L49:
        r13 = 0;
        r16 = 7;
        goto L100
    L48:
        if (r16 == 6) goto L49;
    L51:
        r13 = 0;
        goto L100
    L32:
        if (r18 == 0) goto L33;
        long r21 = (10 * r18) - ((long) (r19 - '0'));
        if (r18 > (-922337203685477580L)) goto L42;
        if (r18 == (-922337203685477580L)) goto L39;
    L41:
        boolean r22 = false;
    L43:
        r14 = r14 & r22;
        r18 = r21;
        goto L51
    L39:
        if (r21 >= r18) goto L41;
    L42:
        r22 = true;
        goto L43
    L33:
        return 0;
    L50:
        r18 = -(r19 - '0');
        r16 = 2;
    L54:
        if (A(r19) == true) goto L78;
    L55:
        if (r16 != 2) goto L69;
        if (r14 == false) goto L69;
        if (r18 != Long.MIN_VALUE) goto L61;
        if (r17 == false) goto L69;
    L61:
        if (r18 != 0) goto L63;
        if (r17 == true) goto L69;
    L63:
        if (r17 == true) goto L66;
        r18 = -r18;
    L66:
        this.f9388n = r18;
        this.f9383i += r15;
        int r23 = 15;
    L67:
        this.f9387m = r23;
        return r23;
    L69:
        if (r16 != 2) goto L71;
    L77:
        this.f9389o = r15;
        r23 = 16;
        goto L67
    L71:
        if (r16 == 4) goto L77;
        if (r16 == 7) goto L77;
        return 0;
    L78:
        return 0;
    L6:
        if (r15 == r10.length) goto L7;
        if (p(r15 + 1) == false) goto L55;
        r11 = this.f9383i;
        r12 = this.f9384j;
        goto L12
    L7:
        return r13;
    }

    private void a0(int r10) {
        int r11 = this.f9392r;
        int[] r12 = this.f9391q;
        if (r11 != r12.length) goto L5;
        int r13 = r11 * 2;
        this.f9391q = Arrays.copyOf(r12, r13);
        this.f9394t = Arrays.copyOf(this.f9394t, r13);
        this.f9393s = (String[]) Arrays.copyOf(this.f9393s, r13);
    L5:
        int[] r14 = this.f9391q;
        int r15 = this.f9392r;
        this.f9392r = r15 + 1;
        r14[r15] = r10;
    }

    private char c0() {
        if (this.f9383i == this.f9384j) goto L5;
    L9:
        char[] r10 = this.f9382h;
        int r11 = this.f9383i;
        int r12 = r11 + 1;
        this.f9383i = r12;
        char r13 = r10[r11];
        if (r13 != '\n') goto L12;
        this.f9385k++;
        this.f9386l = r12;
    L73:
        return r13;
    L12:
        if (r13 == '\"') goto L73;
        if (r13 == '\'') goto L73;
        if (r13 == '/') goto L73;
        if (r13 == '\\') goto L73;
        if (r13 != 'b') goto L22;
        return '\b';
    L22:
        if (r13 != 'f') goto L24;
        return '\f';
    L24:
        if (r13 != 'n') goto L26;
        return '\n';
    L26:
        if (r13 != 'r') goto L28;
        return '\r';
    L28:
        if (r13 != 't') goto L30;
        return '\t';
    L30:
        if (r13 != 'u') goto L62;
        if ((r12 + 4) > this.f9384j) goto L34;
    L38:
        char r14 = 0;
        int r15 = this.f9383i;
        int r16 = r15 + 4;
    L39:
        if (r15 >= r16) goto L59;
        char r17 = this.f9382h[r15];
        char r18 = (char) (r14 << 4);
        if (r17 < '0') goto L47;
        if (r17 > '9') goto L47;
        int r19 = r17 - '0';
    L45:
        r14 = (char) (r18 + r19);
        r15 = r15 + 1;
    L47:
        if (r17 < 'a') goto L52;
        if (r17 > 'f') goto L52;
        int r20 = r17 - 'a';
    L50:
        r19 = r20 + 10;
    L52:
        if (r17 < 'A') goto L58;
        if (r17 > 'F') goto L58;
        r20 = r17 - 'A';
    L58:
        throw new NumberFormatException("\\u" + new String(this.f9382h, this.f9383i, 4));
    L59:
        this.f9383i += 4;
        return r14;
    L34:
        if (p(4) == true) goto L38;
        throw j0("Unterminated escape sequence");
    L62:
        throw j0("Invalid escape sequence");
    L5:
        if (p(1) == true) goto L9;
        throw j0("Unterminated escape sequence");
    }

    private void e0(char r10) {
        char[] r11 = this.f9382h;
    L3:
        int r12 = this.f9383i;
        int r13 = this.f9384j;
    L5:
        if (r12 >= r13) goto L17;
        int r14 = r12 + 1;
        char r15 = r11[r12];
        if (r15 == r10) goto L8;
        if (r15 == '\\') goto L12;
        if (r15 != '\n') goto L16;
        this.f9385k++;
        this.f9386l = r14;
    L16:
        r12 = r14;
        goto L5
    L12:
        this.f9383i = r14;
        c0();
        goto L3
    L8:
        this.f9383i = r14;
        return;
    L17:
        this.f9383i = r12;
        if (p(1) == true) goto L3;
        throw j0("Unterminated string");
    }

    private void f() {
        if (this.f9381g == false) goto L6;
        return;
    L6:
        throw j0("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private boolean f0(String r10) {
        int r11 = r10.length();
    L3:
        int r12 = 0;
        if ((this.f9383i + r11) > this.f9384j) goto L6;
    L9:
        char[] r13 = this.f9382h;
        int r14 = this.f9383i;
        if (r13[r14] != '\n') goto L12;
        this.f9385k++;
        this.f9386l = r14 + 1;
    L15:
        this.f9383i++;
    L12:
        if (r12 >= r11) goto L17;
        if (this.f9382h[this.f9383i + r12] != r10.charAt(r12)) goto L15;
        r12 = r12 + 1;
        goto L12
    L17:
        return true;
    L6:
        if (p(r11) == true) goto L9;
        return false;
    }

    private void g0() {
    L3:
        if (this.f9383i >= this.f9384j) goto L5;
    L6:
        char[] r10 = this.f9382h;
        int r11 = this.f9383i;
        int r12 = r11 + 1;
        this.f9383i = r12;
        char r13 = r10[r11];
        if (r13 == '\n') goto L8;
        if (r13 != '\r') goto L3;
        return;
    L8:
        this.f9385k++;
        this.f9386l = r12;
        return;
    L5:
        if (p(1) == true) goto L6;
    }

    private void h0() {
    L2:
        int r10 = 0;
    L3:
        int r11 = this.f9383i;
        if ((r11 + r10) >= this.f9384j) goto L36;
        char r12 = this.f9382h[r11 + r10];
        if (r12 == '\t') goto L34;
        if (r12 == '\n') goto L34;
        if (r12 == '\f') goto L34;
        if (r12 == '\r') goto L34;
        if (r12 == ' ') goto L34;
        if (r12 == '#') goto L33;
        if (r12 == ',') goto L34;
        if (r12 == '/') goto L33;
        if (r12 == '=') goto L33;
        if (r12 == '{') goto L34;
        if (r12 == '}') goto L34;
        if (r12 == ':') goto L34;
        if (r12 == ';') goto L33;
        switch(r12) {
            case 91: goto L34;
            case 92: goto L33;
            case 93: goto L34;
            default: goto L32;
        };
    L32:
        r10 = r10 + 1;
    L33:
        f();
    L34:
        this.f9383i += r10;
        return;
    L36:
        this.f9383i = r11 + r10;
        if (p(1) == true) goto L2;
    }

    private void i() {
        J(true);
        int r10 = this.f9383i - 1;
        this.f9383i = r10;
        if ((r10 + 5) > this.f9384j) goto L5;
    L7:
        int r11 = this.f9383i;
        char[] r12 = this.f9382h;
        if (r12[r11] == ')') goto L10;
        return;
    L10:
        if (r12[r11 + 1] == ']') goto L12;
        return;
    L12:
        if (r12[r11 + 2] == '}') goto L14;
        return;
    L14:
        if (r12[r11 + 3] == '\'') goto L16;
        return;
    L16:
        if (r12[r11 + 4] != '\n') goto L24;
        this.f9383i = r11 + 5;
        return;
    L24:
        return;
    L5:
        if (p(5) == true) goto L7;
    }

    private IOException j0(String r10) {
        throw new MalformedJsonException(r10 + B());
    }

    private boolean p(int r10) {
        char[] r11 = this.f9382h;
        int r12 = this.f9386l;
        int r13 = this.f9383i;
        this.f9386l = r12 - r13;
        int r14 = this.f9384j;
        if (r14 == r13) goto L5;
        int r15 = r14 - r13;
        this.f9384j = r15;
        System.arraycopy(r11, r13, r11, 0, r15);
    L6:
        this.f9383i = 0;
    L7:
        Reader r16 = this.f9380c;
        int r17 = this.f9384j;
        int r18 = r16.read(r11, r17, r11.length - r17);
        if (r18 == (-1)) goto L19;
        int r19 = this.f9384j + r18;
        this.f9384j = r19;
        if (this.f9385k != 0) goto L17;
        int r20 = this.f9386l;
        if (r20 != 0) goto L17;
        if (r19 <= 0) goto L17;
        if (r11[0] != 65279) goto L17;
        this.f9383i++;
        this.f9386l = r20 + 1;
        r10 = r10 + 1;
    L17:
        if (r19 < r10) goto L7;
        return true;
    L19:
        return false;
    L5:
        this.f9384j = 0;
        goto L6
    }

    private String r(boolean r10) {
        StringBuilder r11 = new StringBuilder();
        r11.append(Typography.dollar);
        int r12 = 0;
    L3:
        int r13 = this.f9392r;
        if (r12 >= r13) goto L28;
        int r14 = this.f9391q[r12];
        if (r14 != 1) goto L8;
    L19:
        int r15 = this.f9394t[r12];
        if (r10 == false) goto L25;
        if (r15 <= 0) goto L25;
        if (r12 != (r13 - 1)) goto L25;
        r15 = r15 - 1;
    L25:
        r11.append('[');
        r11.append(r15);
        r11.append(']');
    L26:
        r12 = r12 + 1;
        goto L3
    L8:
        if (r14 == 2) goto L19;
        if (r14 != 3) goto L12;
    L16:
        r11.append('.');
        String[] r16 = this.f9393s;
        if (r16[r12] == null) goto L26;
        r11.append(r16[r12]);
        goto L26
    L12:
        if (r14 == 4) goto L16;
        if (r14 == 5) goto L16;
    L28:
        return r11.toString();
    }

    String B() {
        return " at line " + (this.f9385k + 1) + " column " + ((this.f9383i - this.f9386l) + 1) + " path " + getPath();
    }

    public boolean C() {
        int r10 = this.f9387m;
        if (r10 != 0) goto L6;
        r10 = k();
    L6:
        if (r10 != 5) goto L10;
        this.f9387m = 0;
        int[] r11 = this.f9394t;
        int r12 = this.f9392r - 1;
        r11[r12] = r11[r12] + 1;
        return true;
    L10:
        if (r10 != 6) goto L14;
        this.f9387m = 0;
        int[] r13 = this.f9394t;
        int r14 = this.f9392r - 1;
        r13[r14] = r13[r14] + 1;
        return false;
    L14:
        throw new IllegalStateException("Expected a boolean but was " + Q() + B());
    }

    public double D() {
        int r10 = this.f9387m;
        if (r10 != 0) goto L6;
        r10 = k();
    L6:
        if (r10 != 15) goto L10;
        this.f9387m = 0;
        int[] r11 = this.f9394t;
        int r12 = this.f9392r - 1;
        r11[r12] = r11[r12] + 1;
        return this.f9388n;
    L10:
        if (r10 != 16) goto L13;
        this.f9390p = new String(this.f9382h, this.f9383i, this.f9389o);
        this.f9383i += this.f9389o;
    L29:
        this.f9387m = 11;
        double r13 = Double.parseDouble(this.f9390p);
        if (this.f9381g == false) goto L32;
    L38:
        this.f9390p = null;
        this.f9387m = 0;
        int[] r14 = this.f9394t;
        int r15 = this.f9392r - 1;
        r14[r15] = r14[r15] + 1;
        return r13;
    L32:
        if (Double.isNaN(r13) == true) goto L37;
        if (Double.isInfinite(r13) == false) goto L38;
    L37:
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + r13 + B());
    L13:
        if (r10 != 8) goto L15;
    L24:
        if (r10 != 8) goto L26;
        char r16 = '\'';
    L27:
        String r17 = M(r16);
    L28:
        this.f9390p = r17;
        goto L29
    L26:
        r16 = Typography.quote;
        goto L27
    L15:
        if (r10 == 9) goto L24;
        if (r10 != 10) goto L20;
        r17 = P();
        goto L28
    L20:
        if (r10 == 11) goto L29;
        throw new IllegalStateException("Expected a double but was " + Q() + B());
    }

    public int F() {
        int r10 = this.f9387m;
        if (r10 != 0) goto L6;
        r10 = k();
    L6:
        if (r10 != 15) goto L14;
        long r11 = this.f9388n;
        int r12 = (int) r11;
        if (r11 != r12) goto L12;
        this.f9387m = 0;
        int[] r13 = this.f9394t;
        int r14 = this.f9392r - 1;
        r13[r14] = r13[r14] + 1;
        return r12;
    L12:
        throw new NumberFormatException("Expected an int but was " + this.f9388n + B());
    L14:
        if (r10 != 16) goto L17;
        this.f9390p = new String(this.f9382h, this.f9383i, this.f9389o);
        this.f9383i += this.f9389o;
    L33:
        this.f9387m = 11;
        double r15 = Double.parseDouble(this.f9390p);
        int r16 = (int) r15;
        if (r16 != r15) goto L38;
        this.f9390p = null;
        this.f9387m = 0;
        int[] r17 = this.f9394t;
        int r18 = this.f9392r - 1;
        r17[r18] = r17[r18] + 1;
        return r16;
    L38:
        throw new NumberFormatException("Expected an int but was " + this.f9390p + B());
    L17:
        if (r10 != 8) goto L19;
    L24:
        if (r10 != 10) goto L27;
        String r19 = P();
    L26:
        this.f9390p = r19;
        int r20 = Integer.parseInt(this.f9390p);     // Catch: NumberFormatException -> L39
        this.f9387m = 0;     // Catch: NumberFormatException -> L39
        int[] r21 = this.f9394t;     // Catch: NumberFormatException -> L39
        int r22 = this.f9392r - 1;     // Catch: NumberFormatException -> L39
        r21[r22] = r21[r22] + 1;     // Catch: NumberFormatException -> L39
        return r20;
    L27:
        if (r10 != 8) goto L29;
        char r23 = '\'';
    L30:
        r19 = M(r23);
        goto L26
    L29:
        r23 = Typography.quote;
        goto L30
    L19:
        if (r10 == 9) goto L24;
        if (r10 == 10) goto L24;
        throw new IllegalStateException("Expected an int but was " + Q() + B());
    }

    public long G() {
        int r10 = this.f9387m;
        if (r10 != 0) goto L6;
        r10 = k();
    L6:
        if (r10 != 15) goto L10;
        this.f9387m = 0;
        int[] r11 = this.f9394t;
        int r12 = this.f9392r - 1;
        r11[r12] = r11[r12] + 1;
        return this.f9388n;
    L10:
        if (r10 != 16) goto L13;
        this.f9390p = new String(this.f9382h, this.f9383i, this.f9389o);
        this.f9383i += this.f9389o;
    L29:
        this.f9387m = 11;
        double r13 = Double.parseDouble(this.f9390p);
        long r14 = (long) r13;
        if (r14 != r13) goto L34;
        this.f9390p = null;
        this.f9387m = 0;
        int[] r15 = this.f9394t;
        int r16 = this.f9392r - 1;
        r15[r16] = r15[r16] + 1;
        return r14;
    L34:
        throw new NumberFormatException("Expected a long but was " + this.f9390p + B());
    L13:
        if (r10 != 8) goto L15;
    L20:
        if (r10 != 10) goto L23;
        String r17 = P();
    L22:
        this.f9390p = r17;
        long r18 = Long.parseLong(this.f9390p);     // Catch: NumberFormatException -> L35
        this.f9387m = 0;     // Catch: NumberFormatException -> L35
        int[] r19 = this.f9394t;     // Catch: NumberFormatException -> L35
        int r20 = this.f9392r - 1;     // Catch: NumberFormatException -> L35
        r19[r20] = r19[r20] + 1;     // Catch: NumberFormatException -> L35
        return r18;
    L23:
        if (r10 != 8) goto L25;
        char r21 = '\'';
    L26:
        r17 = M(r21);
        goto L22
    L25:
        r21 = Typography.quote;
        goto L26
    L15:
        if (r10 == 9) goto L20;
        if (r10 == 10) goto L20;
        throw new IllegalStateException("Expected a long but was " + Q() + B());
    }

    public String I() {
        int r10 = this.f9387m;
        if (r10 != 0) goto L6;
        r10 = k();
    L6:
        if (r10 != 14) goto L9;
        String r11 = P();
    L15:
        this.f9387m = 0;
        this.f9393s[this.f9392r - 1] = r11;
        return r11;
    L9:
        if (r10 != 12) goto L13;
        char r12 = '\'';
    L11:
        r11 = M(r12);
        goto L15
    L13:
        if (r10 != 13) goto L18;
        r12 = Typography.quote;
        goto L11
    L18:
        throw new IllegalStateException("Expected a name but was " + Q() + B());
    }

    public void K() {
        int r10 = this.f9387m;
        if (r10 != 0) goto L6;
        r10 = k();
    L6:
        if (r10 != 7) goto L10;
        this.f9387m = 0;
        int[] r11 = this.f9394t;
        int r12 = this.f9392r - 1;
        r11[r12] = r11[r12] + 1;
        return;
    L10:
        throw new IllegalStateException("Expected null but was " + Q() + B());
    }

    public String N() {
        int r10 = this.f9387m;
        if (r10 != 0) goto L6;
        r10 = k();
    L6:
        if (r10 != 10) goto L9;
        String r11 = P();
    L24:
        this.f9387m = 0;
        int[] r12 = this.f9394t;
        int r13 = this.f9392r - 1;
        r12[r13] = r12[r13] + 1;
        return r11;
    L9:
        if (r10 != 8) goto L13;
        char r14 = '\'';
    L11:
        r11 = M(r14);
        goto L24
    L13:
        if (r10 != 9) goto L16;
        r14 = Typography.quote;
        goto L11
    L16:
        if (r10 != 11) goto L19;
        r11 = this.f9390p;
        this.f9390p = null;
        goto L24
    L19:
        if (r10 != 15) goto L22;
        r11 = Long.toString(this.f9388n);
        goto L24
    L22:
        if (r10 != 16) goto L27;
        r11 = new String(this.f9382h, this.f9383i, this.f9389o);
        this.f9383i += this.f9389o;
        goto L24
    L27:
        throw new IllegalStateException("Expected a string but was " + Q() + B());
    }

    public JsonToken Q() {
        int r10 = this.f9387m;
        if (r10 != 0) goto L5;
        r10 = k();
    L5:
        switch(r10) {
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
        return JsonToken.END_DOCUMENT;
    L11:
        return JsonToken.NUMBER;
    L13:
        return JsonToken.NAME;
    L15:
        return JsonToken.STRING;
    L17:
        return JsonToken.NULL;
    L19:
        return JsonToken.BOOLEAN;
    L21:
        return JsonToken.END_ARRAY;
    L23:
        return JsonToken.BEGIN_ARRAY;
    L25:
        return JsonToken.END_OBJECT;
    L27:
        return JsonToken.BEGIN_OBJECT;
    }

    public void a() {
        int r10 = this.f9387m;
        if (r10 != 0) goto L6;
        r10 = k();
    L6:
        if (r10 != 3) goto L10;
        a0(1);
        this.f9394t[this.f9392r - 1] = 0;
        this.f9387m = 0;
        return;
    L10:
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + Q() + B());
    }

    public void c() {
        int r10 = this.f9387m;
        if (r10 != 0) goto L6;
        r10 = k();
    L6:
        if (r10 != 1) goto L10;
        a0(3);
        this.f9387m = 0;
        return;
    L10:
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + Q() + B());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9387m = 0;
        this.f9391q[0] = 8;
        this.f9392r = 1;
        this.f9380c.close();
    }

    public final void d0(boolean r10) {
        this.f9381g = r10;
    }

    public String getPath() {
        return r(false);
    }

    public void i0() {
        int r10 = 0;
    L3:
        int r11 = this.f9387m;
        if (r11 != 0) goto L7;
        r11 = k();
    L7:
        switch(r11) {
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
        this.f9383i += this.f9389o;
        goto L29
    L11:
        h0();
        if (r10 != 0) goto L29;
        this.f9393s[this.f9392r - 1] = "<skipped>";
        goto L29
    L14:
        e0(Typography.quote);
        if (r10 != 0) goto L29;
        this.f9393s[this.f9392r - 1] = "<skipped>";
        goto L29
    L17:
        e0('\'');
        if (r10 != 0) goto L29;
        this.f9393s[this.f9392r - 1] = "<skipped>";
        goto L29
    L20:
        h0();
        goto L29
    L21:
        e0(Typography.quote);
        goto L29
    L22:
        e0('\'');
    L23:
        this.f9392r--;
        r10 = r10 - 1;
        goto L29
    L24:
        a0(1);
    L28:
        r10 = r10 + 1;
        goto L29
    L25:
        if (r10 != 0) goto L23;
        this.f9393s[this.f9392r - 1] = null;
        goto L23
    L27:
        a0(3);
    L29:
        this.f9387m = 0;
        if (r10 > 0) goto L3;
        int[] r12 = this.f9394t;
        int r13 = this.f9392r - 1;
        r12[r13] = r12[r13] + 1;
        return;
    }

    int k() {
        int[] r10 = this.f9391q;
        int r11 = this.f9392r;
        int r12 = r10[r11 - 1];
        if (r12 != 1) goto L5;
        r10[r11 - 1] = 2;
    L47:
        int r13 = J(true);
        if (r13 == 34) goto L84;
        if (r13 == 39) goto L82;
        if (r13 == 44) goto L75;
        if (r13 == 59) goto L75;
        if (r13 == 91) goto L73;
        if (r13 != 93) goto L56;
        if (r12 != 1) goto L75;
        this.f9387m = 4;
        return 4;
    L56:
        if (r13 == 123) goto L68;
        this.f9383i--;
        int r14 = V();
        if (r14 == 0) goto L60;
        return r14;
    L60:
        int r15 = X();
        if (r15 == 0) goto L64;
        return r15;
    L64:
        if (A(this.f9382h[this.f9383i]) == false) goto L67;
        f();
        int r16 = 10;
    L43:
        this.f9387m = r16;
        return r16;
    L67:
        throw j0("Expected value");
    L68:
        this.f9387m = 1;
        return 1;
    L73:
        this.f9387m = 3;
        return 3;
    L75:
        if (r12 == 1) goto L80;
        if (r12 == 2) goto L80;
        throw j0("Unexpected value");
    L80:
        f();
        this.f9383i--;
        this.f9387m = 7;
        return 7;
    L82:
        f();
        this.f9387m = 8;
        return 8;
    L84:
        r16 = 9;
        goto L43
    L5:
        if (r12 != 2) goto L16;
        int r17 = J(true);
        if (r17 == 44) goto L47;
        if (r17 == 59) goto L14;
        if (r17 != 93) goto L13;
        this.f9387m = 4;
        return 4;
    L13:
        throw j0("Unterminated array");
    L14:
        f();
        goto L47
    L16:
        if (r12 == 3) goto L87;
        if (r12 == 5) goto L87;
        if (r12 != 4) goto L34;
        r10[r11 - 1] = 5;
        int r18 = J(true);
        if (r18 == 58) goto L47;
        if (r18 != 61) goto L32;
        f();
        if (this.f9383i >= this.f9384j) goto L27;
    L28:
        char[] r19 = this.f9382h;
        int r20 = this.f9383i;
        if (r19[r20] != '>') goto L47;
        this.f9383i = r20 + 1;
        goto L47
    L27:
        if (p(1) == false) goto L47;
    L32:
        throw j0("Expected ':'");
    L34:
        if (r12 == 6) goto L36;
        if (r12 == 7) goto L41;
        if (r12 != 8) goto L47;
        throw new IllegalStateException("JsonReader is closed");
    L41:
        if (J(false) != (-1)) goto L45;
        r16 = 17;
        goto L43
    L45:
        f();
        this.f9383i--;
        goto L47
    L36:
        if (this.f9381g == false) goto L38;
        i();
    L38:
        this.f9391q[this.f9392r - 1] = 7;
    L87:
        r10[r11 - 1] = 4;
        if (r12 != 5) goto L98;
        int r21 = J(true);
        if (r21 == 44) goto L98;
        if (r21 == 59) goto L97;
        if (r21 != 125) goto L96;
        this.f9387m = 2;
        return 2;
    L96:
        throw j0("Unterminated object");
    L97:
        f();
    L98:
        int r22 = J(true);
        if (r22 == 34) goto L114;
        if (r22 != 39) goto L102;
        f();
        r16 = 12;
        goto L43
    L102:
        if (r22 == 125) goto L108;
        f();
        this.f9383i--;
        if (A((char) r22) == false) goto L107;
        r16 = 14;
        goto L43
    L107:
        throw j0("Expected name");
    L108:
        if (r12 == 5) goto L112;
        this.f9387m = 2;
        return 2;
    L112:
        throw j0("Expected name");
    L114:
        r16 = 13;
        goto L43
    }

    public void l() {
        int r10 = this.f9387m;
        if (r10 != 0) goto L6;
        r10 = k();
    L6:
        if (r10 != 4) goto L10;
        int r11 = this.f9392r - 1;
        this.f9392r = r11;
        int[] r12 = this.f9394t;
        int r13 = r11 - 1;
        r12[r13] = r12[r13] + 1;
        this.f9387m = 0;
        return;
    L10:
        throw new IllegalStateException("Expected END_ARRAY but was " + Q() + B());
    }

    public void o() {
        int r10 = this.f9387m;
        if (r10 != 0) goto L6;
        r10 = k();
    L6:
        if (r10 != 2) goto L10;
        int r11 = this.f9392r - 1;
        this.f9392r = r11;
        this.f9393s[r11] = null;
        int[] r12 = this.f9394t;
        int r13 = r11 - 1;
        r12[r13] = r12[r13] + 1;
        this.f9387m = 0;
        return;
    L10:
        throw new IllegalStateException("Expected END_OBJECT but was " + Q() + B());
    }

    public String s() {
        return r(true);
    }

    public String toString() {
        return getClass().getSimpleName() + B();
    }

    public boolean u() {
        int r10 = this.f9387m;
        if (r10 != 0) goto L6;
        r10 = k();
    L6:
        if (r10 != 2) goto L8;
    L12:
        return false;
    L8:
        if (r10 == 4) goto L12;
        if (r10 == 17) goto L12;
        return true;
    }

    public final boolean v() {
        return this.f9381g;
    }
}
