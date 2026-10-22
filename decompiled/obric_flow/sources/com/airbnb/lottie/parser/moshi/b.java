package com.airbnb.lottie.parser.moshi;

import java.io.EOFException;
import ko.r;
import kotlin.text.Charsets;
import nu.j;
import nu.u;
import nu.x;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public final class b extends a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ByteString f1306l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ByteString f1307m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ByteString f1308n = null;
    public final x f;
    public final j g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f1310i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1311j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f1312k;

    static {
        f1306l = ByteString.encodeUtf8("'\\");
        f1307m = ByteString.encodeUtf8("\"\\");
        f1308n = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
        ByteString.encodeUtf8("\n\r");
        ByteString.encodeUtf8("*/");
    }

    public b(x r5) {
        this.f1304b = new int[32];
        this.f1305c = new String[32];
        this.d = new int[32];
        this.f1309h = 0;
        this.f = r5;
        this.g = r5.f20349a;
        K(6);
    }

    @Override // com.airbnb.lottie.parser.moshi.a
    public final JsonReader$Token J() {
        int r5 = this.f1309h;
        if (r5 != 0) goto L5;
        r5 = Q();
    L5:
        switch(r5) {
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
            case 15: goto L13;
            case 16: goto L11;
            case 17: goto L11;
            case 18: goto L9;
            default: goto L7;
        };
    L7:
        throw new AssertionError();
    L9:
        return JsonReader$Token.END_DOCUMENT;
    L11:
        return JsonReader$Token.NUMBER;
    L13:
        return JsonReader$Token.NAME;
    L15:
        return JsonReader$Token.STRING;
    L17:
        return JsonReader$Token.NULL;
    L19:
        return JsonReader$Token.BOOLEAN;
    L21:
        return JsonReader$Token.END_ARRAY;
    L23:
        return JsonReader$Token.BEGIN_ARRAY;
    L25:
        return JsonReader$Token.END_OBJECT;
    L27:
        return JsonReader$Token.BEGIN_OBJECT;
    }

    @Override // com.airbnb.lottie.parser.moshi.a
    public final int L(r r5) {
        int r10 = this.f1309h;
        if (r10 != 0) goto L6;
        r10 = Q();
    L6:
        if (r10 >= 12) goto L8;
    L21:
        return -1;
    L8:
        if (r10 > 15) goto L21;
        if (r10 == 15) goto L12;
        int r11 = this.f.D((u) r5.f18729c);
        if (r11 == (-1)) goto L17;
        this.f1309h = 0;
        this.f1305c[this.f1303a - 1] = ((String[]) r5.f18728b)[r11];
        return r11;
    L17:
        String r12 = this.f1305c[this.f1303a - 1];
        String r13 = T();
        int r14 = R(r13, r5);
        if (r14 != (-1)) goto L20;
        this.f1309h = 15;
        this.f1312k = r13;
        this.f1305c[this.f1303a - 1] = r12;
    L20:
        return r14;
    L12:
        return R(this.f1312k, r5);
    }

    @Override // com.airbnb.lottie.parser.moshi.a
    public final void M() {
        int r5 = this.f1309h;
        if (r5 != 0) goto L6;
        r5 = Q();
    L6:
        if (r5 != 14) goto L13;
        long r10 = this.f.d(f1308n);
        j r11 = this.g;
        if (r10 != (-1)) goto L11;
        r10 = r11.f20328b;
    L11:
        r11.skip(r10);
    L20:
        this.f1309h = 0;
        this.f1305c[this.f1303a - 1] = "null";
        return;
    L13:
        if (r5 != 13) goto L16;
        Y(f1307m);
        goto L20
    L16:
        if (r5 != 12) goto L19;
        Y(f1306l);
        goto L20
    L19:
        if (r5 == 15) goto L20;
        throw new JsonDataException("Expected a name but was " + J() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.a
    public final void N() {
        int r5 = 0;
    L3:
        int r10 = this.f1309h;
        if (r10 != 0) goto L7;
        r10 = Q();
    L7:
        if (r10 != 3) goto L10;
        K(1);
    L9:
        r5 = r5 + 1;
    L56:
        this.f1309h = 0;
        if (r5 != 0) goto L3;
        int[] r11 = this.d;
        int r12 = this.f1303a - 1;
        r11[r12] = r11[r12] + 1;
        this.f1305c[r12] = "null";
        return;
    L10:
        if (r10 != 1) goto L13;
        K(3);
        goto L9
    L13:
        if (r10 != 4) goto L20;
        r5 = r5 - 1;
        if (r5 < 0) goto L18;
        this.f1303a--;
        goto L56
    L18:
        throw new JsonDataException("Expected a value but was " + J() + " at path " + getPath());
    L20:
        if (r10 != 2) goto L26;
        r5 = r5 - 1;
        if (r5 < 0) goto L25;
        this.f1303a--;
        goto L56
    L25:
        throw new JsonDataException("Expected a value but was " + J() + " at path " + getPath());
    L26:
        j r13 = this.g;
        if (r10 != 14) goto L29;
    L51:
        long r14 = this.f.d(f1308n);
        if (r14 != (-1)) goto L55;
        r14 = r13.f20328b;
    L55:
        r13.skip(r14);
        goto L56
    L29:
        if (r10 == 10) goto L51;
        if (r10 != 9) goto L34;
    L50:
        Y(f1307m);
        goto L56
    L34:
        if (r10 == 13) goto L50;
        if (r10 != 8) goto L39;
    L49:
        Y(f1306l);
        goto L56
    L39:
        if (r10 == 12) goto L49;
        if (r10 != 17) goto L45;
        r13.skip(this.f1311j);
        goto L56
    L45:
        if (r10 != 18) goto L56;
        throw new JsonDataException("Expected a value but was " + J() + " at path " + getPath());
    }

    public final void P() {
        O("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    public final int Q() {
        int[] r5 = this.f1304b;
        int r10 = this.f1303a - 1;
        int r11 = r5[r10];
        j r12 = this.g;
        if (r11 != 1) goto L6;
        r5[r10] = 2;
    L40:
        int r13 = U(true);
        if (r13 != 34) goto L43;
        r12.readByte();
        this.f1309h = 9;
        return 9;
    L43:
        if (r13 == 39) goto L194;
        if (r13 == 44) goto L187;
        if (r13 == 59) goto L187;
        if (r13 == 91) goto L185;
        if (r13 != 93) goto L50;
        if (r11 != 1) goto L187;
        r12.readByte();
        this.f1309h = 4;
        return 4;
    L50:
        if (r13 == 123) goto L180;
        byte r14 = r12.m(0);
        x r15 = this.f;
        if (r14 != 116) goto L54;
    L69:
        int r16 = 5;
        String r17 = "true";
        String r18 = "TRUE";
    L70:
        int r19 = r17.length();
        int r110 = 1;
    L71:
        if (r110 >= r19) goto L82;
        int r111 = r110 + 1;
        if (r15.request(r111) == false) goto L66;
        char r112 = r12.m(r110);
        if (r112 == r17.charAt(r110)) goto L80;
        if (r112 != r18.charAt(r110)) goto L66;
    L80:
        r110 = r111;
    L66:
        r16 = 0;
    L87:
        if (r16 == 0) goto L89;
        return r16;
    L89:
        long r113 = 0;
        boolean r114 = true;
        char r20 = 0;
        int r21 = 0;
        boolean r115 = false;
    L90:
        int r116 = r21 + 1;
        if (r15.request(r116) == false) goto L136;
        byte r22 = r12.m(r21);
        if (r22 != 43) goto L96;
        char r23 = 6;
        if (r20 != 5) goto L114;
    L162:
        r20 = r23;
    L171:
        r21 = r116;
    L114:
        int r117 = 0;
    L172:
        if (r117 == 0) goto L175;
        return r117;
    L175:
        if (S(r12.m(0)) == true) goto L178;
        O("Expected value");
        throw null;
    L178:
        P();
        throw null;
    L96:
        if (r22 == 69) goto L164;
        if (r22 == 101) goto L164;
        if (r22 != 45) goto L102;
        r23 = 6;
        if (r20 != 0) goto L161;
        r20 = 1;
        r115 = true;
        goto L171
    L161:
        if (r20 != 5) goto L114;
    L102:
        if (r22 == 46) goto L156;
        if (r22 < 48) goto L135;
        if (r22 > 57) goto L135;
        if (r20 == 1) goto L133;
        if (r20 == 0) goto L133;
        if (r20 != 2) goto L125;
        if (r113 == 0) goto L114;
        long r118 = (10 * r113) - ((long) (r22 - 48));
        if (r113 > (-922337203685477580L)) goto L122;
        if (r113 == (-922337203685477580L)) goto L119;
    L121:
        boolean r24 = false;
    L123:
        r114 = r114 & r24;
        r113 = r118;
        goto L171
    L119:
        if (r118 >= r113) goto L121;
    L122:
        r24 = true;
        goto L123
    L125:
        if (r20 != 3) goto L128;
        r20 = 4;
        goto L171
    L128:
        if (r20 == 5) goto L132;
        if (r20 != 6) goto L171;
    L132:
        r20 = 7;
    L133:
        r113 = -(r22 - 48);
        r20 = 2;
    L135:
        if (S(r22) == true) goto L114;
    L156:
        if (r20 != 2) goto L114;
        r20 = 3;
    L164:
        if (r20 != 2) goto L166;
    L167:
        r20 = 5;
        goto L171
    L166:
        if (r20 != 4) goto L114;
    L136:
        if (r20 != 2) goto L149;
        if (r114 == false) goto L149;
        if (r113 != Long.MIN_VALUE) goto L142;
        if (r115 == false) goto L149;
    L142:
        if (r113 != 0) goto L144;
        if (r115 == true) goto L149;
    L144:
        if (r115 == true) goto L147;
        r113 = -r113;
    L147:
        this.f1310i = r113;
        r12.skip(r21);
        int r25 = 16;
        this.f1309h = 16;
    L148:
        r117 = r25;
    L149:
        if (r20 != 2) goto L151;
    L154:
        this.f1311j = r21;
        r25 = 17;
        this.f1309h = 17;
        goto L148
    L151:
        if (r20 == 4) goto L154;
        if (r20 != 7) goto L114;
    L82:
        if (r15.request(r19 + 1) == true) goto L84;
    L86:
        r12.skip(r19);
        this.f1309h = r16;
        goto L87
    L84:
        if (S(r12.m(r19)) == false) goto L86;
    L54:
        if (r14 == 84) goto L69;
        if (r14 != 102) goto L59;
    L68:
        r16 = 6;
        r17 = "false";
        r18 = "FALSE";
        goto L70
    L59:
        if (r14 == 70) goto L68;
        if (r14 != 110) goto L64;
    L67:
        r16 = 7;
        r17 = "null";
        r18 = "NULL";
        goto L70
    L64:
        if (r14 != 78) goto L66;
    L180:
        r12.readByte();
        this.f1309h = 1;
        return 1;
    L185:
        r12.readByte();
        this.f1309h = 3;
        return 3;
    L187:
        if (r11 == 1) goto L192;
        if (r11 == 2) goto L192;
        O("Unexpected value");
        throw null;
    L192:
        P();
        throw null;
    L194:
        P();
        throw null;
    L6:
        if (r11 != 2) goto L17;
        int r26 = U(true);
        r12.readByte();
        if (r26 == 44) goto L40;
        if (r26 == 59) goto L15;
        if (r26 != 93) goto L13;
        this.f1309h = 4;
        return 4;
    L13:
        O("Unterminated array");
        throw null;
    L15:
        P();
        throw null;
    L17:
        if (r11 == 3) goto L200;
        if (r11 == 5) goto L200;
        if (r11 != 4) goto L29;
        r5[r10] = 5;
        int r27 = U(true);
        r12.readByte();
        if (r27 == 58) goto L40;
        if (r27 == 61) goto L27;
        O("Expected ':'");
        throw null;
    L27:
        P();
        throw null;
    L29:
        if (r11 != 6) goto L31;
        r5[r10] = 7;
        goto L40
    L31:
        if (r11 != 7) goto L39;
        if (U(false) != (-1)) goto L36;
        this.f1309h = 18;
        return 18;
    L36:
        P();
        throw null;
    L39:
        if (r11 != 8) goto L40;
        throw new IllegalStateException("JsonReader is closed");
    L200:
        r5[r10] = 4;
        if (r11 != 5) goto L212;
        int r28 = U(true);
        r12.readByte();
        if (r28 == 44) goto L212;
        if (r28 == 59) goto L210;
        if (r28 != 125) goto L208;
        this.f1309h = 2;
        return 2;
    L208:
        O("Unterminated object");
        throw null;
    L210:
        P();
        throw null;
    L212:
        int r29 = U(true);
        if (r29 != 34) goto L215;
        r12.readByte();
        this.f1309h = 13;
        return 13;
    L215:
        if (r29 == 39) goto L224;
        if (r29 != 125) goto L222;
        if (r11 == 5) goto L220;
        r12.readByte();
        this.f1309h = 2;
        return 2;
    L220:
        O("Expected name");
        throw null;
    L222:
        P();
        throw null;
    L224:
        r12.readByte();
        P();
        throw null;
    }

    public final int R(String r5, r r10) {
        int r11 = ((String[]) r10.f18728b).length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (r5.equals(((String[]) r10.f18728b)[r12]) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        this.f1309h = 0;
        this.f1305c[this.f1303a - 1] = r5;
        return r12;
    L9:
        return -1;
    }

    public final boolean S(int r5) {
        if (r5 != 9) goto L5;
        return false;
    L5:
        if (r5 != 10) goto L7;
        return false;
    L7:
        if (r5 != 12) goto L9;
        return false;
    L9:
        if (r5 != 13) goto L11;
        return false;
    L11:
        if (r5 != 32) goto L13;
        return false;
    L13:
        if (r5 != 35) goto L15;
    L31:
        P();
        throw null;
    L15:
        if (r5 != 44) goto L17;
        return false;
    L17:
        if (r5 == 47) goto L31;
        if (r5 == 61) goto L31;
        if (r5 != 123) goto L23;
        return false;
    L23:
        if (r5 != 125) goto L25;
        return false;
    L25:
        if (r5 != 58) goto L27;
        return false;
    L27:
        if (r5 == 59) goto L31;
        switch(r5) {
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

    public final String T() {
        int r5 = this.f1309h;
        if (r5 != 0) goto L6;
        r5 = Q();
    L6:
        if (r5 != 14) goto L9;
        String r10 = W();
    L17:
        this.f1309h = 0;
        this.f1305c[this.f1303a - 1] = r10;
        return r10;
    L9:
        if (r5 != 13) goto L12;
        r10 = V(f1307m);
        goto L17
    L12:
        if (r5 != 12) goto L15;
        r10 = V(f1306l);
        goto L17
    L15:
        if (r5 != 15) goto L20;
        r10 = this.f1312k;
        goto L17
    L20:
        throw new JsonDataException("Expected a name but was " + J() + " at path " + getPath());
    }

    public final int U(boolean r10) {
        int r5 = 0;
    L3:
        int r11 = r5 + 1;
        x r12 = this.f;
        if (r12.request(r11) == false) goto L27;
        long r13 = r5;
        j r14 = this.g;
        byte r15 = r14.m(r13);
        if (r15 == 10) goto L26;
        if (r15 == 32) goto L26;
        if (r15 == 13) goto L26;
        if (r15 == 9) goto L26;
        r14.skip(r13);
        if (r15 != 47) goto L22;
        if (r12.request(2) == true) goto L19;
        return r15;
    L19:
        P();
        throw null;
    L22:
        if (r15 == 35) goto L24;
        return r15;
    L24:
        P();
        throw null;
    L26:
        r5 = r11;
        goto L3
    L27:
        if (r10 == true) goto L31;
        return -1;
    L31:
        throw new EOFException("End of input");
    }

    public final String V(ByteString r10) {
        StringBuilder r5 = null;
    L3:
        long r11 = this.f.d(r10);
        if (r11 == (-1)) goto L15;
        j r12 = this.g;
        if (r12.m(r11) != 92) goto L10;
        if (r5 != null) goto L9;
        r5 = new StringBuilder();
    L9:
        r5.append(r12.L(r11, Charsets.UTF_8));
        r12.readByte();
        r5.append(X());
        goto L3
    L10:
        if (r5 != null) goto L13;
        String r13 = r12.L(r11, Charsets.UTF_8);
        r12.readByte();
        return r13;
    L13:
        r5.append(r12.L(r11, Charsets.UTF_8));
        r12.readByte();
        return r5.toString();
    L15:
        O("Unterminated string");
        throw null;
    }

    public final String W() {
        long r5 = this.f.d(f1308n);
        j r10 = this.g;
        if (r5 == (-1)) goto L6;
        r10.getClass();
        return r10.L(r5, Charsets.UTF_8);
    L6:
        return r10.M();
    }

    public final char X() {
        x r5 = this.f;
        if (r5.request(1) == false) goto L66;
        j r10 = this.g;
        byte r11 = r10.readByte();
        if (r11 == 10) goto L65;
        if (r11 == 34) goto L65;
        if (r11 == 39) goto L65;
        if (r11 == 47) goto L65;
        if (r11 == 92) goto L65;
        if (r11 != 98) goto L17;
        return '\b';
    L17:
        if (r11 != 102) goto L19;
        return '\f';
    L19:
        if (r11 != 110) goto L21;
        return '\n';
    L21:
        if (r11 != 114) goto L23;
        return '\r';
    L23:
        if (r11 != 116) goto L25;
        return '\t';
    L25:
        if (r11 == 117) goto L27;
        O("Invalid escape sequence: \\" + ((char) r11));
        throw null;
    L27:
        if (r5.request(4) == false) goto L52;
        int r12 = 0;
        char r13 = 0;
    L30:
        if (r12 >= 4) goto L49;
        byte r14 = r10.m(r12);
        char r15 = (char) (r13 << 4);
        if (r14 < 48) goto L38;
        if (r14 > 57) goto L38;
        int r16 = r14 - 48;
    L36:
        r13 = (char) (r16 + r15);
        r12 = r12 + 1;
    L38:
        if (r14 < 97) goto L42;
        if (r14 > 102) goto L42;
        r16 = r14 - 87;
    L42:
        if (r14 < 65) goto L47;
        if (r14 > 70) goto L47;
        r16 = r14 - 55;
    L47:
        O("\\u".concat(r10.L(4, Charsets.UTF_8)));
        throw null;
    L49:
        r10.skip(4);
        return r13;
    L52:
        throw new EOFException("Unterminated escape sequence at path " + getPath());
    L65:
        return (char) r11;
    L66:
        O("Unterminated escape sequence");
        throw null;
    }

    public final void Y(ByteString r10) {
    L2:
        long r5 = this.f.d(r10);
        if (r5 == (-1)) goto L9;
        j r11 = this.g;
        if (r11.m(r5) != 92) goto L7;
        r11.skip(r5 + 1);
        X();
        goto L2
    L7:
        r11.skip(r5 + 1);
        return;
    L9:
        O("Unterminated string");
        throw null;
    }

    @Override // com.airbnb.lottie.parser.moshi.a
    public final void b() {
        int r5 = this.f1309h;
        if (r5 != 0) goto L6;
        r5 = Q();
    L6:
        if (r5 != 3) goto L10;
        K(1);
        this.d[this.f1303a - 1] = 0;
        this.f1309h = 0;
        return;
    L10:
        throw new JsonDataException("Expected BEGIN_ARRAY but was " + J() + " at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f1309h = 0;
        this.f1304b[0] = 8;
        this.f1303a = 1;
        this.g.b();
        this.f.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.a
    public final void d() {
        int r5 = this.f1309h;
        if (r5 != 0) goto L6;
        r5 = Q();
    L6:
        if (r5 != 1) goto L10;
        K(3);
        this.f1309h = 0;
        return;
    L10:
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + J() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.a
    public final void e() {
        int r5 = this.f1309h;
        if (r5 != 0) goto L6;
        r5 = Q();
    L6:
        if (r5 != 4) goto L10;
        int r10 = this.f1303a;
        this.f1303a = r10 - 1;
        int[] r11 = this.d;
        int r12 = r10 - 2;
        r11[r12] = r11[r12] + 1;
        this.f1309h = 0;
        return;
    L10:
        throw new JsonDataException("Expected END_ARRAY but was " + J() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.a
    public final void f() {
        int r5 = this.f1309h;
        if (r5 != 0) goto L6;
        r5 = Q();
    L6:
        if (r5 != 2) goto L10;
        int r10 = this.f1303a;
        int r11 = r10 - 1;
        this.f1303a = r11;
        this.f1305c[r11] = null;
        int[] r12 = this.d;
        int r13 = r10 - 2;
        r12[r13] = r12[r13] + 1;
        this.f1309h = 0;
        return;
    L10:
        throw new JsonDataException("Expected END_OBJECT but was " + J() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.a
    public final boolean g() {
        int r5 = this.f1309h;
        if (r5 != 0) goto L6;
        r5 = Q();
    L6:
        if (r5 != 2) goto L8;
    L12:
        return false;
    L8:
        if (r5 == 4) goto L12;
        if (r5 == 18) goto L12;
        return true;
    }

    @Override // com.airbnb.lottie.parser.moshi.a
    public final boolean m() {
        int r5 = this.f1309h;
        if (r5 != 0) goto L6;
        r5 = Q();
    L6:
        if (r5 != 5) goto L10;
        this.f1309h = 0;
        int[] r10 = this.d;
        int r11 = this.f1303a - 1;
        r10[r11] = r10[r11] + 1;
        return true;
    L10:
        if (r5 != 6) goto L14;
        this.f1309h = 0;
        int[] r12 = this.d;
        int r13 = this.f1303a - 1;
        r12[r13] = r12[r13] + 1;
        return false;
    L14:
        throw new JsonDataException("Expected a boolean but was " + J() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.a
    public final double n() {
        int r5 = this.f1309h;
        if (r5 != 0) goto L6;
        r5 = Q();
    L6:
        if (r5 != 16) goto L10;
        this.f1309h = 0;
        int[] r10 = this.d;
        int r11 = this.f1303a - 1;
        r10[r11] = r10[r11] + 1;
        return this.f1310i;
    L10:
        if (r5 != 17) goto L13;
        long r12 = this.f1311j;
        j r13 = this.g;
        r13.getClass();
        this.f1312k = r13.L(r12, Charsets.UTF_8);
    L22:
        this.f1309h = 11;
        double r14 = Double.parseDouble(this.f1312k);     // Catch: NumberFormatException -> L32
        if (Double.isNaN(r14) == true) goto L31;
        if (Double.isInfinite(r14) == true) goto L31;
        this.f1312k = null;
        this.f1309h = 0;
        int[] r15 = this.d;
        int r16 = this.f1303a - 1;
        r15[r16] = r15[r16] + 1;
        return r14;
    L31:
        throw new JsonEncodingException("JSON forbids NaN and infinities: " + r14 + " at path " + getPath());
    L33:
        throw new JsonDataException("Expected a double but was " + this.f1312k + " at path " + getPath());
    L13:
        if (r5 != 9) goto L16;
        this.f1312k = V(f1307m);
        goto L22
    L16:
        if (r5 != 8) goto L19;
        this.f1312k = V(f1306l);
        goto L22
    L19:
        if (r5 != 10) goto L21;
        this.f1312k = W();
        goto L22
    L21:
        if (r5 == 11) goto L22;
        throw new JsonDataException("Expected a double but was " + J() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.a
    public final int p() {
        int r5 = this.f1309h;
        if (r5 != 0) goto L6;
        r5 = Q();
    L6:
        if (r5 != 16) goto L14;
        long r10 = this.f1310i;
        int r11 = (int) r10;
        if (r10 != r11) goto L12;
        this.f1309h = 0;
        int[] r12 = this.d;
        int r13 = this.f1303a - 1;
        r12[r13] = r12[r13] + 1;
        return r11;
    L12:
        throw new JsonDataException("Expected an int but was " + this.f1310i + " at path " + getPath());
    L14:
        if (r5 != 17) goto L17;
        long r14 = this.f1311j;
        j r15 = this.g;
        r15.getClass();
        this.f1312k = r15.L(r14, Charsets.UTF_8);
    L31:
        this.f1309h = 11;
        double r16 = Double.parseDouble(this.f1312k);     // Catch: NumberFormatException -> L39
        int r17 = (int) r16;
        if (r17 != r16) goto L38;
        this.f1312k = null;
        this.f1309h = 0;
        int[] r18 = this.d;
        int r19 = this.f1303a - 1;
        r18[r19] = r18[r19] + 1;
        return r17;
    L38:
        throw new JsonDataException("Expected an int but was " + this.f1312k + " at path " + getPath());
    L40:
        throw new JsonDataException("Expected an int but was " + this.f1312k + " at path " + getPath());
    L17:
        if (r5 != 9) goto L19;
    L25:
        if (r5 != 9) goto L27;
        String r20 = V(f1307m);
    L28:
        this.f1312k = r20;
        int r21 = Integer.parseInt(r20);     // Catch: NumberFormatException -> L41
        this.f1309h = 0;     // Catch: NumberFormatException -> L41
        int[] r22 = this.d;     // Catch: NumberFormatException -> L41
        int r23 = this.f1303a - 1;     // Catch: NumberFormatException -> L41
        r22[r23] = r22[r23] + 1;     // Catch: NumberFormatException -> L41
        return r21;
    L27:
        r20 = V(f1306l);
        goto L28
    L19:
        if (r5 == 8) goto L25;
        if (r5 == 11) goto L31;
        throw new JsonDataException("Expected an int but was " + J() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.a
    public final String q() {
        int r5 = this.f1309h;
        if (r5 != 0) goto L6;
        r5 = Q();
    L6:
        if (r5 != 10) goto L9;
        String r10 = W();
    L23:
        this.f1309h = 0;
        int[] r11 = this.d;
        int r12 = this.f1303a - 1;
        r11[r12] = r11[r12] + 1;
        return r10;
    L9:
        if (r5 != 9) goto L12;
        r10 = V(f1307m);
        goto L23
    L12:
        if (r5 != 8) goto L15;
        r10 = V(f1306l);
        goto L23
    L15:
        if (r5 != 11) goto L18;
        r10 = this.f1312k;
        this.f1312k = null;
        goto L23
    L18:
        if (r5 != 16) goto L21;
        r10 = Long.toString(this.f1310i);
        goto L23
    L21:
        if (r5 != 17) goto L26;
        long r13 = this.f1311j;
        j r14 = this.g;
        r14.getClass();
        r10 = r14.L(r13, Charsets.UTF_8);
        goto L23
    L26:
        throw new JsonDataException("Expected a string but was " + J() + " at path " + getPath());
    }

    public final String toString() {
        return "JsonReader(" + this.f + ")";
    }
}
