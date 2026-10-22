package we;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char[] f13240j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13243c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f13244d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f13245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f13246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final List<String> f13247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f13248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f13249i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public String f13250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13251b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f13252c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public String f13253d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f13254e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArrayList f13255f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public ArrayList f13256g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public String f13257h;

        public a() {
            this.f13251b = "";
            this.f13252c = "";
            this.f13254e = -1;
            ArrayList r8 = new ArrayList();
            this.f13255f = r8;
            r8.add("");
        }

        public final r a() {
            if (this.f13250a == null) goto L11;
            if (this.f13253d == null) goto L9;
            return new r(this);
        L9:
            throw new IllegalStateException("host == null");
        L11:
            throw new IllegalStateException("scheme == null");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
        public final void b(@Nullable r r26, String r27) {
            String r10 = r27;
            int r8 = xe.c.v(0, r27.length(), r10);
            int r11 = xe.c.w(r8, r27.length(), r10);
            byte r14 = -1;
            if ((r11 - r8) < 2) goto L33;
            char r12 = r10.charAt(r8);
            char r13 = 'Z';
            if (r12 < 'a') goto L8;
            if (r12 > 'z') goto L8;
        L11:
            int r15 = r8;
        L12:
            r15 = r15 + 1;
            if (r15 >= r11) goto L33;
            char r16 = r10.charAt(r15);
            if (r16 < 'a') goto L17;
            if (r16 > 'z') goto L17;
        L32:
            r13 = 'Z';
        L17:
            if (r16 < 'A') goto L20;
            if (r16 <= r13) goto L32;
        L20:
            if (r16 < '0') goto L24;
            if (r16 <= '9') goto L32;
        L24:
            if (r16 == '+') goto L32;
            if (r16 == '-') goto L32;
            if (r16 == '.') goto L32;
            if (r16 != ':') goto L33;
            int r17 = r15;
        L34:
            if (r17 == (-1)) goto L43;
            int r18 = r17;
            if (r27.regionMatches(true, r8, "https:", 0, 6) == false) goto L39;
            this.f13250a = LocationInfoConst.HTTPS;
            r8 = r8 + 6;
        L45:
            int r19 = r8;
            int r20 = 0;
        L46:
            byte r110 = 92;
            byte r21 = 47;
            if (r19 >= r11) goto L52;
            char r22 = r10.charAt(r19);
            if (r22 == '\\') goto L51;
            if (r22 != '/') goto L52;
        L51:
            r20 = r20 + 1;
            r19 = r19 + 1;
        L52:
            if (r20 >= 2) goto L55;
        L64:
            boolean r23 = false;
        L65:
            ArrayList r111 = this.f13255f;
            byte r24 = 63;
            byte r25 = 35;
            if (r23 == true) goto L81;
            if (r26 == null) goto L81;
            if (r26.f13241a.equals(this.f13250a) == false) goto L81;
            this.f13251b = r26.h();
            this.f13252c = r26.d();
            this.f13253d = r26.f13244d;
            this.f13254e = r26.f13245e;
            r111.clear();
            r111.addAll(r26.f());
            if (r8 != r11) goto L74;
        L75:
            String r112 = r26.g();
            if (r112 == null) goto L78;
            ArrayList r28 = r.l(r.b(r112, " \"'<>#", true, false, true, true));
        L79:
            this.f13256g = r28;
        L80:
            boolean r29 = false;
        L142:
            int r30 = xe.c.j(r8, r11, r10, "?#");
            if (r8 != r30) goto L145;
            String r113 = r10;
        L195:
            if (r30 < r11) goto L197;
        L199:
            char r114 = '#';
        L200:
            if (r30 < r11) goto L202;
            return;
        L202:
            if (r10.charAt(r30) != r114) goto L246;
            this.f13257h = r.a(r113, r30 + 1, r11, "", true, false, false, false);
            return;
        L246:
            return;
        L197:
            if (r10.charAt(r30) != '?') goto L199;
            r114 = '#';
            int r115 = xe.c.k(r10, r30, r11, '#');
            this.f13256g = r.l(r.a(r113, r30 + 1, r115, " \"'<>#", true, false, true, true));
            r30 = r115;
            goto L200
        L145:
            char r31 = r10.charAt(r8);
            if (r31 != '/') goto L148;
        L151:
            r111.clear();
            r111.add("");
            int r116 = r30;
            int r117 = r30;
            Object r118 = "";
            r113 = r10;
            String r119 = r10;
            String r120 = r10;
            int r32 = r8 + 1;
            String r121 = r10;
        L153:
            if (r32 >= r117) goto L194;
            int r33 = xe.c.j(r32, r117, r119, "/\\");
            if (r33 >= r117) goto L157;
            boolean r122 = true;
        L158:
            ArrayList r210 = r111;
            String r34 = r.a(r121, r32, r33, " \"<>^`{}|/\\?#", true, false, false, true);
            if (r34.equals(".") == false) goto L161;
        L164:
            boolean r35 = true;
        L165:
            if (r35 == false) goto L168;
            ArrayList r36 = r210;
        L191:
            if (r122 == true) goto L152;
            r111 = r36;
            r32 = r33;
            goto L153
        L152:
            r116 = r116;
            r117 = r117;
            r118 = r118;
            r113 = r113;
            r11 = r11;
            r111 = r36;
            r119 = r119;
            r120 = r120;
            r32 = r33 + 1;
            r121 = r121;
            goto L153
        L168:
            if (r34.equals("..") == false) goto L170;
        L177:
            boolean r37 = true;
        L178:
            if (r37 == false) goto L185;
            r36 = r210;
            if (((String) r36.remove(r210.size() - 1)).isEmpty() == true) goto L182;
        L184:
            r36.add(r118);
            goto L191
        L182:
            if (r36.isEmpty() == true) goto L184;
            r36.set(r36.size() - 1, r118);
            goto L191
        L185:
            r36 = r210;
            if (((String) r36.get(r36.size() - 1)).isEmpty() == false) goto L188;
            r36.set(r36.size() - 1, r34);
        L189:
            if (r122 == false) goto L191;
            r36.add(r118);
            goto L191
        L188:
            r36.add(r34);
            goto L189
        L170:
            if (r34.equalsIgnoreCase("%2e.") == true) goto L177;
            if (r34.equalsIgnoreCase(".%2e") == true) goto L177;
            if (r34.equalsIgnoreCase("%2e%2e") == true) goto L177;
            r37 = r29;
            goto L178
        L161:
            if (r34.equalsIgnoreCase("%2e") == true) goto L164;
            r35 = r29;
            goto L165
        L157:
            r122 = r29;
            goto L158
        L194:
            r10 = r120;
            r30 = r116;
            r11 = r11;
            goto L195
        L148:
            if (r31 == '\\') goto L151;
            r111.set(r111.size() - 1, "");
            r116 = r30;
            r117 = r116;
            r118 = "";
            r32 = r8;
            r121 = r10;
            r113 = r121;
            r119 = r113;
            r120 = r119;
            goto L153
        L78:
            r28 = null;
            goto L79
        L74:
            if (r10.charAt(r8) != '#') goto L80;
        L81:
            int r38 = r8 + r20;
            boolean r123 = false;
            boolean r124 = false;
        L82:
            int r39 = xe.c.j(r38, r11, r10, "@/\\?#");
            if (r39 == r11) goto L85;
            byte r40 = r10.charAt(r39);
        L86:
            if (r40 == r14) goto L106;
            if (r40 == r25) goto L106;
            if (r40 == r21) goto L106;
            if (r40 == r110) goto L106;
            if (r40 == r24) goto L106;
            if (r40 != 64) goto L105;
            if (r123 == true) goto L103;
            int r41 = xe.c.k(r10, r38, r39, ':');
            int r125 = r39;
            String r42 = r.a(r27, r38, r41, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            if (r124 == false) goto L99;
            r42 = this.f13251b + "%40" + r42;
        L99:
            this.f13251b = r42;
            if (r41 == r125) goto L102;
            this.f13252c = r.a(r27, r41 + 1, r125, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            r123 = true;
        L102:
            r124 = true;
        L104:
            r38 = r125 + 1;
            goto L105
        L103:
            r125 = r39;
            this.f13252c += "%40" + r.a(r27, r38, r125, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
        L105:
            r25 = 35;
            r24 = 63;
            r21 = 47;
            r14 = -1;
            r110 = 92;
        L106:
            int r43 = r38;
        L107:
            if (r43 >= r39) goto L120;
            char r44 = r10.charAt(r43);
            if (r44 == ':') goto L119;
            if (r44 == '[') goto L113;
            int r45 = 1;
        L118:
            r43 = r43 + r45;
            goto L107
        L113:
            r45 = 1;
        L114:
            r43 = r43 + 1;
            if (r43 >= r39) goto L118;
            if (r10.charAt(r43) != ']') goto L114;
        L119:
            int r126 = r43;
        L121:
            int r127 = r126 + 1;
            if (r127 >= r39) goto L138;
            this.f13253d = xe.c.c(r.i(r10, r38, r126, false));
            char r128 = '\"';
            int r211 = r38;
            int r46 = Integer.parseInt(r.a(r27, r127, r39, "", false, false, false, true));     // Catch: NumberFormatException -> L209
            if (r46 <= 0) goto L132;
            if (r46 > 65535) goto L132;
        L133:
            this.f13254e = r46;
            if (r46 == (-1)) goto L137;
            r38 = r211;
            r29 = false;
        L140:
            if (this.f13253d == null) goto L206;
            r8 = r39;
            goto L142
        L206:
            throw new IllegalArgumentException("Invalid URL host: \"" + r10.substring(r38, r126) + r128);
        L137:
            throw new IllegalArgumentException("Invalid URL port: \"" + r10.substring(r127, r39) + '\"');
        L132:
            r46 = -1;
            goto L133
        L138:
            r29 = false;
            r128 = '\"';
            this.f13253d = xe.c.c(r.i(r10, r38, r126, false));
            this.f13254e = r.c(this.f13250a);
            goto L140
        L120:
            r126 = r39;
            goto L121
        L85:
            r40 = r14;
            goto L86
        L55:
            if (p000if.a.f8330n.get() == true) goto L58;
        L63:
            r23 = true;
            goto L65
        L58:
            if (TextUtils.isEmpty(r27) == true) goto L64;
            if (r10.startsWith("https://") == true) goto L63;
            if (r10.startsWith("http://") == false) goto L64;
        L39:
            if (r27.regionMatches(true, r8, "http:", 0, 5) == false) goto L42;
            this.f13250a = "http";
            r8 = r8 + 5;
            goto L45
        L42:
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + r10.substring(0, r18) + "'");
        L43:
            if (r26 == null) goto L208;
            this.f13250a = r26.f13241a;
            goto L45
        L208:
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
        L8:
            if (r12 < 'A') goto L33;
            if (r12 <= 'Z') goto L11;
        L33:
            r17 = -1;
            goto L34
        }

        public final String toString() {
            StringBuilder r8 = new StringBuilder();
            String r10 = this.f13250a;
            if (r10 == null) goto L5;
            r8.append(r10);
            String r11 = "://";
        L6:
            r8.append(r11);
            if (this.f13251b.isEmpty() == true) goto L9;
        L10:
            r8.append(this.f13251b);
            if (this.f13252c.isEmpty() == true) goto L13;
            r8.append(':');
            r8.append(this.f13252c);
        L13:
            r8.append('@');
        L14:
            String r12 = this.f13253d;
            if (r12 != null) goto L17;
        L20:
            int r13 = this.f13254e;
            if (r13 == (-1)) goto L23;
        L24:
            if (r13 != (-1)) goto L27;
            r13 = r.c(this.f13250a);
        L27:
            String r14 = this.f13250a;
            if (r14 != null) goto L30;
        L31:
            r8.append(':');
            r8.append(r13);
        L32:
            ArrayList r15 = this.f13255f;
            int r16 = r15.size();
            int r17 = 0;
            int r18 = 0;
        L33:
            if (r18 >= r16) goto L36;
            r8.append('/');
            r8.append((String) r15.get(r18));
            r18 = r18 + 1;
            goto L33
        L36:
            if (this.f13256g == null) goto L47;
            r8.append('?');
            ArrayList r19 = this.f13256g;
            int r20 = r19.size();
        L38:
            if (r17 >= r20) goto L47;
            String r21 = (String) r19.get(r17);
            String r22 = (String) r19.get(r17 + 1);
            if (r17 <= 0) goto L42;
            r8.append('&');
        L42:
            r8.append(r21);
            if (r22 == null) goto L45;
            r8.append('=');
            r8.append(r22);
        L45:
            r17 = r17 + 2;
        L47:
            if (this.f13257h == null) goto L50;
            r8.append('#');
            r8.append(this.f13257h);
        L50:
            return r8.toString();
        L30:
            if (r13 == r.c(r14)) goto L32;
        L23:
            if (this.f13250a == null) goto L32;
        L17:
            if (r12.indexOf(58) == (-1)) goto L19;
            r8.append('[');
            r8.append(this.f13253d);
            r8.append(']');
            goto L20
        L19:
            r8.append(this.f13253d);
            goto L20
        L9:
            if (this.f13252c.isEmpty() == true) goto L14;
        L5:
            r11 = "//";
            goto L6
        }
    }

    static {
        f13240j = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public r(a r8) {
        this.f13241a = r8.f13250a;
        String r10 = r8.f13251b;
        this.f13242b = i(r10, 0, r10.length(), false);
        String r11 = r8.f13252c;
        this.f13243c = i(r11, 0, r11.length(), false);
        this.f13244d = r8.f13253d;
        int r12 = r8.f13254e;
        if (r12 != (-1)) goto L6;
        r12 = c(r8.f13250a);
    L6:
        this.f13245e = r12;
        this.f13246f = j(r8.f13255f, false);
        ArrayList r13 = r8.f13256g;
        String r14 = null;
        if (r13 == null) goto L9;
        List<String> r15 = j(r13, true);
    L10:
        this.f13247g = r15;
        String r16 = r8.f13257h;
        if (r16 == null) goto L13;
        r14 = i(r16, 0, r16.length(), false);
    L13:
        this.f13248h = r14;
        this.f13249i = r8.toString();
        return;
    L9:
        r15 = null;
        goto L10
    }

    public static String a(String r16, int r17, int r18, String r19, boolean r20, boolean r21, boolean r22, boolean r23) {
        int r8 = r17;
    L3:
        if (r8 >= r18) goto L62;
        int r10 = r16.codePointAt(r8);
        if (r10 < 32) goto L20;
        if (r10 == 127) goto L20;
        if (r10 < 128) goto L10;
        if (r23 == true) goto L20;
    L10:
        if (r19.indexOf(r10) != (-1)) goto L20;
        if (r10 != 37) goto L16;
        if (r20 == false) goto L20;
        if (r21 == false) goto L16;
        if (k(r8, r18, r16) == false) goto L20;
    L16:
        if (r10 != 43) goto L19;
        if (r22 == true) goto L20;
    L19:
        r8 = r8 + Character.charCount(r10);
    L20:
        jf.d r11 = new jf.d();
        r11.c0(r17, r8, r16);
        jf.d r12 = null;
    L21:
        if (r8 >= r18) goto L60;
        int r13 = r16.codePointAt(r8);
        if (r20 == true) goto L25;
    L33:
        if (r13 != 43) goto L39;
        if (r22 == false) goto L39;
        if (r20 == false) goto L37;
        String r14 = "+";
    L38:
        r11.c0(0, r14.length(), r14);
    L58:
        r8 = r8 + Character.charCount(r13);
        goto L21
    L37:
        r14 = "%2B";
    L39:
        if (r13 < 32) goto L52;
        if (r13 == 127) goto L52;
        if (r13 < 128) goto L44;
        if (r23 == true) goto L52;
    L44:
        if (r19.indexOf(r13) != (-1)) goto L52;
        if (r13 != 37) goto L51;
        if (r20 == false) goto L52;
        if (r21 == false) goto L51;
        if (k(r8, r18, r16) == false) goto L52;
    L51:
        r11.e0(r13);
    L52:
        if (r12 != null) goto L54;
        r12 = new jf.d();
    L54:
        r12.e0(r13);
    L56:
        if (r12.U() == true) goto L58;
        int r15 = r12.readByte() & 255;
        r11.G(37);
        char[] r110 = f13240j;
        r11.G(r110[(r15 >> 4) & 15]);
        r11.G(r110[r15 & 15]);
        goto L56
    L25:
        if (r13 == 9) goto L58;
        if (r13 == 10) goto L58;
        if (r13 == 12) goto L58;
        if (r13 != 13) goto L33;
    L60:
        return r11.A();
    L62:
        return r16.substring(r17, r18);
    }

    public static String b(String r8, String r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        return a(r8, 0, r8.length(), r10, r11, r12, r13, r14);
    }

    public static int c(String r8) {
        if (r8.equals("http") == false) goto L7;
        return 80;
    L7:
        if (r8.equals(LocationInfoConst.HTTPS) == false) goto L10;
        return 443;
    L10:
        return -1;
    }

    public static String i(String r8, int r10, int r11, boolean r12) {
        int r13 = r10;
    L3:
        if (r13 >= r11) goto L28;
        char r14 = r8.charAt(r13);
        if (r14 == '%') goto L10;
        if (r14 != '+') goto L9;
        if (r12 == true) goto L10;
    L9:
        r13 = r13 + 1;
    L10:
        jf.d r15 = new jf.d();
        r15.c0(r10, r13, r8);
    L11:
        if (r13 >= r11) goto L26;
        int r16 = r8.codePointAt(r13);
        if (r16 != 37) goto L20;
        int r17 = r13 + 2;
        if (r17 >= r11) goto L20;
        int r18 = xe.c.h(r8.charAt(r13 + 1));
        int r19 = xe.c.h(r8.charAt(r17));
        if (r18 == (-1)) goto L23;
        if (r19 == (-1)) goto L23;
        r15.G((r18 << 4) + r19);
        r13 = r17;
    L24:
        r13 = r13 + Character.charCount(r16);
    L23:
        r15.e0(r16);
    L20:
        if (r16 != 43) goto L23;
        if (r12 == false) goto L23;
        r15.G(32);
        goto L24
    L26:
        return r15.A();
    L28:
        return r8.substring(r10, r11);
    }

    public static List j(List r8, boolean r10) {
        int r11 = r8.size();
        ArrayList r12 = new ArrayList(r11);
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L10;
        String r14 = (String) r8.get(r13);
        if (r14 == null) goto L7;
        String r15 = i(r14, 0, r14.length(), r10);
    L8:
        r12.add(r15);
        r13 = r13 + 1;
        goto L3
    L7:
        r15 = null;
        goto L8
    L10:
        return Collections.unmodifiableList(r12);
    }

    public static boolean k(int r8, int r10, String r11) {
        int r12 = r8 + 2;
        if (r12 < r10) goto L5;
    L11:
        return false;
    L5:
        if (r11.charAt(r8) != '%') goto L11;
        if (xe.c.h(r11.charAt(r8 + 1)) == (-1)) goto L11;
        if (xe.c.h(r11.charAt(r12)) == (-1)) goto L11;
        return true;
    }

    public static ArrayList l(String r8) {
        ArrayList r10 = new ArrayList();
        int r11 = 0;
    L4:
        if (r11 > r8.length()) goto L15;
        int r12 = r8.indexOf(38, r11);
        if (r12 != (-1)) goto L8;
        r12 = r8.length();
    L8:
        int r13 = r8.indexOf(61, r11);
        if (r13 == (-1)) goto L13;
        if (r13 > r12) goto L13;
        r10.add(r8.substring(r11, r13));
        String r14 = r8.substring(r13 + 1, r12);
    L14:
        r10.add(r14);
        r11 = r12 + 1;
    L13:
        r10.add(r8.substring(r11, r12));
        r14 = null;
        goto L14
    L15:
        return r10;
    }

    public final String d() {
        if (this.f13243c.isEmpty() == false) goto L6;
        return "";
    L6:
        int r8 = this.f13241a.length() + 3;
        String r10 = this.f13249i;
        return r10.substring(r10.indexOf(58, r8) + 1, r10.indexOf(64));
    }

    public final String e() {
        int r8 = this.f13241a.length() + 3;
        String r10 = this.f13249i;
        int r11 = r10.indexOf(47, r8);
        return r10.substring(r11, xe.c.j(r11, r10.length(), r10, "?#"));
    }

    public final boolean equals(@Nullable Object r8) {
        if ((r8 instanceof r) == true) goto L5;
    L7:
        return false;
    L5:
        if (((r) r8).f13249i.equals(this.f13249i) == false) goto L7;
        return true;
    }

    public final ArrayList f() {
        int r8 = this.f13241a.length() + 3;
        String r10 = this.f13249i;
        int r11 = r10.indexOf(47, r8);
        int r12 = xe.c.j(r11, r10.length(), r10, "?#");
        ArrayList r13 = new ArrayList();
    L3:
        if (r11 >= r12) goto L5;
        int r14 = r11 + 1;
        int r15 = xe.c.k(r10, r14, r12, '/');
        r13.add(r10.substring(r14, r15));
        r11 = r15;
        goto L3
    L5:
        return r13;
    }

    @Nullable
    public final String g() {
        if (this.f13247g != null) goto L6;
        return null;
    L6:
        String r8 = this.f13249i;
        int r10 = r8.indexOf(63) + 1;
        return r8.substring(r10, xe.c.k(r8, r10, r8.length(), '#'));
    }

    public final String h() {
        if (this.f13242b.isEmpty() == false) goto L6;
        return "";
    L6:
        int r8 = this.f13241a.length() + 3;
        String r10 = this.f13249i;
        return r10.substring(r8, xe.c.j(r8, r10.length(), r10, ":@"));
    }

    public final int hashCode() {
        return this.f13249i.hashCode();
    }

    public final String m() {
        a r8 = new a();     // Catch: IllegalArgumentException -> L5
        r8.b(this, "/...");     // Catch: IllegalArgumentException -> L5
    L6:
        r8.getClass();
        r8.f13251b = b("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        r8.f13252c = b("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return r8.a().f13249i;
    L5:
        r8 = null;
        goto L6
    }

    public final URI n() {
        a r8 = new a();
        String r10 = this.f13241a;
        r8.f13250a = r10;
        r8.f13251b = h();
        r8.f13252c = d();
        r8.f13253d = this.f13244d;
        int r11 = c(r10);
        int r12 = this.f13245e;
        if (r12 != r11) goto L6;
        r12 = -1;
    L6:
        r8.f13254e = r12;
        ArrayList r13 = r8.f13255f;
        r13.clear();
        r13.addAll(f());
        String r14 = g();
        String r15 = null;
        if (r14 == null) goto L9;
        ArrayList r16 = l(b(r14, " \"'<>#", true, false, true, true));
    L10:
        r8.f13256g = r16;
        if (this.f13248h == null) goto L14;
        String r17 = this.f13249i;
        r15 = r17.substring(r17.indexOf(35) + 1);
    L14:
        r8.f13257h = r15;
        int r18 = r13.size();
        int r19 = 0;
        int r20 = 0;
    L15:
        if (r20 >= r18) goto L17;
        r13.set(r20, b((String) r13.get(r20), "[]", true, true, false, true));
        r20 = r20 + 1;
        goto L15
    L17:
        ArrayList r110 = r8.f13256g;
        if (r110 == null) goto L25;
        int r111 = r110.size();
    L20:
        if (r19 >= r111) goto L25;
        String r21 = (String) r8.f13256g.get(r19);
        if (r21 == null) goto L24;
        r8.f13256g.set(r19, b(r21, "\\^`{|}", true, true, true, true));
    L24:
        r19 = r19 + 1;
    L25:
        String r22 = r8.f13257h;
        if (r22 == null) goto L28;
        r8.f13257h = b(r22, " \"#<>\\^`{|}", true, true, false, false);
    L28:
        String r112 = r8.toString();
        return new URI(r112);
    L31:
        e = move-exception;
        return URI.create(r112.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L35:
        throw new RuntimeException(e);
    L9:
        r16 = null;
        goto L10
    }

    public final String toString() {
        return this.f13249i;
    }
}
