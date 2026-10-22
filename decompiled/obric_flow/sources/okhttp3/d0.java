package okhttp3;

import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f20628c;
    public String d;
    public int e;
    public final ArrayList f;
    public ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f20629h;

    public d0() {
        this.f20627b = "";
        this.f20628c = "";
        this.e = -1;
        ArrayList r5 = new ArrayList();
        this.f = r5;
        r5.add("");
    }

    public final e0 a() {
        String r5 = this.f20626a;
        if (r5 == null) goto L29;
        String r10 = uj.a.k(this.f20627b, 0, 0, 7, false);
        String r11 = uj.a.k(this.f20628c, 0, 0, 7, false);
        String r12 = this.d;
        if (r12 == null) goto L27;
        int r13 = b();
        ArrayList r14 = this.f;
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator r16 = r14.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        r15.add(uj.a.k((String) r16.next(), 0, 0, 7, false));
        goto L8
    L10:
        ArrayList r17 = this.g;
        String r18 = null;
        if (r17 == null) goto L20;
        ArrayList r19 = new ArrayList(CollectionsKt.h(r17));
        Iterator r20 = r17.iterator();
    L14:
        if (r20.hasNext() == false) goto L21;
        String r110 = (String) r20.next();
        if (r110 == null) goto L18;
        String r111 = uj.a.k(r110, 0, 0, 3, true);
    L19:
        r19.add(r111);
        goto L14
    L18:
        r111 = null;
    L21:
        String r21 = this.f20629h;
        if (r21 == null) goto L25;
        r18 = uj.a.k(r21, 0, 0, 7, false);
    L25:
        return new e0(r5, r10, r11, r12, r13, r15, r19, r18, toString());
    L20:
        r19 = null;
        goto L21
    L27:
        throw new IllegalStateException("host == null");
    L29:
        throw new IllegalStateException("scheme == null");
    }

    public final int b() {
        int r5 = this.e;
        if (r5 != (-1)) goto L20;
        String r10 = this.f20626a;
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullParameter(r10, "scheme");
        int r11 = r10.hashCode();
        if (r11 == 3213448) goto L15;
        if (r11 != 99617003) goto L18;
        if (r10.equals(IIvyAIPackageResourceService.SCHEMA) == false) goto L18;
        int r12 = 443;
    L19:
        return r12;
    L18:
        return -1;
    L15:
        if (r10.equals("http") == false) goto L18;
        r12 = 80;
        goto L19
    L20:
        return r5;
    }

    public final void c(String r10) {
        if (r10 == null) goto L6;
        String r11 = uj.a.h(r10, 0, 0, " \"'<>#", true, false, true, false, 211);
        if (r11 == null) goto L6;
        ArrayList r12 = uj.a.l(r11);
    L7:
        this.g = r12;
        return;
    L6:
        r12 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d(e0 r26, String r27) {
        String r5 = r27;
        Intrinsics.checkNotNullParameter(r5, "input");
        int r10 = Util.indexOfFirstNonAsciiWhitespace$default(r5, 0, 0, 3, null);
        int r11 = Util.indexOfLastNonAsciiWhitespace$default(r5, r10, 0, 2, null);
        char r15 = ':';
        byte r14 = -1;
        if ((r11 - r10) >= 2) goto L5;
    L4:
        int r12 = -1;
    L41:
        if (r12 != (-1)) goto L43;
        if (r26 == null) goto L167;
        this.f20626a = r26.f20640b;
    L52:
        int r13 = r10;
        int r16 = 0;
    L53:
        byte r17 = 47;
        byte r18 = 92;
        if (r13 >= r11) goto L59;
        char r19 = r5.charAt(r13);
        if (r19 == '\\') goto L58;
        if (r19 != '/') goto L59;
    L58:
        r16 = r16 + 1;
        r13 = r13 + 1;
    L59:
        ArrayList r110 = this.f;
        byte r20 = 63;
        byte r21 = 35;
        if (r16 >= 2) goto L71;
        if (r26 == null) goto L71;
        if (Intrinsics.areEqual(r26.f20640b, this.f20626a) == false) goto L71;
        this.f20627b = r26.e();
        this.f20628c = r26.a();
        this.d = r26.e;
        this.e = r26.f;
        r110.clear();
        r110.addAll(r26.c());
        if (r10 != r11) goto L68;
    L69:
        c(r26.d());
    L70:
        int r22 = 0;
        ArrayList r111 = r110;
        int r23 = 1;
    L134:
        int r24 = Util.delimiterOffset(r5, "?#", r10, r11);
        if (r10 != r24) goto L137;
    L136:
        int r112 = r11;
        String r113 = r5;
        if (r24 < r112) goto L156;
    L158:
        char r25 = '#';
    L159:
        if (r24 < r112) goto L161;
        return;
    L161:
        if (r113.charAt(r24) != r25) goto L200;
        this.f20629h = uj.a.h(r27, r24 + 1, r112, "", true, false, false, true, 176);
        return;
    L200:
        return;
    L156:
        if (r113.charAt(r24) != '?') goto L158;
        r25 = '#';
        int r28 = Util.delimiterOffset(r113, '#', r24, r112);
        this.g = uj.a.l(uj.a.h(r27, r24 + 1, r28, " \"'<>#", true, false, true, false, 208));
        r24 = r28;
        goto L159
    L137:
        char r29 = r5.charAt(r10);
        if (r29 != '/') goto L140;
    L141:
        ArrayList r30 = r111;
        r30.clear();
        r30.add("");
        r10 = r10 + 1;
    L144:
        int r31 = r10;
    L145:
        if (r31 >= r24) goto L136;
        int r32 = Util.delimiterOffset(r5, "/\\", r31, r24);
        if (r32 >= r24) goto L149;
        int r114 = r23;
    L150:
        int r115 = r11;
        int r116 = r23;
        String r117 = r5;
        e(r27, r31, r32, r114, true);
        if (r114 == 0) goto L153;
        r32 = r32 + 1;
    L153:
        r31 = r32;
        r5 = r117;
        r11 = r115;
        r23 = r116;
        goto L145
    L149:
        r114 = r22;
        goto L150
    L140:
        if (r29 == '\\') goto L141;
        r111.set(r111.size() - r23, "");
        goto L144
    L68:
        if (r5.charAt(r10) != '#') goto L70;
    L71:
        int r33 = r10 + r16;
        boolean r34 = false;
        boolean r35 = false;
    L72:
        int r118 = Util.delimiterOffset(r5, "@/\\?#", r33, r11);
        if (r118 == r11) goto L75;
        byte r36 = r5.charAt(r118);
    L76:
        if (r36 == r14) goto L97;
        if (r36 == r21) goto L97;
        if (r36 == r17) goto L97;
        if (r36 == r18) goto L97;
        if (r36 == r20) goto L97;
        if (r36 == 64) goto L85;
        boolean r119 = r34;
        r110 = r110;
        r15 = r15;
    L96:
        r15 = r15;
        r110 = r110;
        r34 = r119;
        r21 = 35;
        r20 = 63;
        r18 = 92;
        r17 = 47;
        r14 = -1;
        goto L72
    L85:
        if (r34 == true) goto L94;
        int r37 = Util.delimiterOffset(r5, r15, r33, r118);
        boolean r120 = r34;
        String r38 = uj.a.h(r27, r33, r37, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240);
        if (r35 == false) goto L89;
        r38 = androidx.constraintlayout.motion.widget.a.t(new StringBuilder(), this.f20627b, "%40", r38);
    L89:
        this.f20627b = r38;
        if (r37 == r118) goto L92;
        this.f20628c = uj.a.h(r27, r37 + 1, r118, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240);
        boolean r121 = true;
    L93:
        int r39 = r118;
        r119 = r121;
        boolean r122 = true;
    L95:
        r33 = r39 + 1;
        r35 = r122;
        goto L96
    L92:
        r121 = r120;
        goto L93
    L94:
        r119 = r34;
        StringBuilder r123 = new StringBuilder();
        r123.append(this.f20628c);
        r123.append("%40");
        r39 = r118;
        r123.append(uj.a.h(r27, r33, r118, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 240));
        this.f20628c = r123.toString();
        r122 = r35;
    L97:
        r111 = r110;
        char r40 = r15;
        int r124 = r33;
    L98:
        if (r124 >= r118) goto L111;
        char r41 = r5.charAt(r124);
        if (r41 == r40) goto L110;
        if (r41 == '[') goto L104;
        int r42 = 1;
    L109:
        r124 = r124 + r42;
        goto L98
    L104:
        r42 = 1;
    L105:
        r124 = r124 + 1;
        if (r124 >= r118) goto L109;
        if (r5.charAt(r124) != ']') goto L105;
    L110:
        r23 = 1;
        int r43 = r124;
    L112:
        int r125 = r43 + 1;
        if (r125 >= r118) goto L130;
        this.d = HostnamesKt.toCanonicalHost(uj.a.k(r5, r33, r43, 4, false));
        int r126 = Integer.parseInt(uj.a.h(r27, r125, r118, "", false, false, false, false, 248));     // Catch: NumberFormatException -> L168
        if (r23 > r126) goto L124;
        if (65535 < r126) goto L124;
    L125:
        this.e = r126;
        if (r126 == (-1)) goto L129;
        char r44 = Typography.quote;
        r22 = 0;
    L132:
        if (this.d == null) goto L165;
        r10 = r118;
        goto L134
    L165:
        throw new IllegalArgumentException(("Invalid URL host: \"" + r5.substring(r33, r43) + r44).toString());
    L129:
        throw new IllegalArgumentException(("Invalid URL port: \"" + r5.substring(r125, r118) + Typography.quote).toString());
    L124:
        r126 = -1;
        goto L125
    L130:
        r44 = '\"';
        r22 = 0;
        this.d = HostnamesKt.toCanonicalHost(uj.a.k(r5, r33, r43, 4, false));
        String r45 = this.f20626a;
        Intrinsics.checkNotNull(r45);
        this.e = uj.a.i(r45);
        goto L132
    L111:
        r23 = 1;
        r43 = r118;
        goto L112
    L75:
        r36 = r14;
        goto L76
    L167:
        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
    L43:
        if (StringsKt.L(r10, r5, "https:") == false) goto L46;
        this.f20626a = IIvyAIPackageResourceService.SCHEMA;
        r10 = r10 + 6;
        goto L52
    L46:
        if (StringsKt.L(r10, r5, "http:") == false) goto L49;
        this.f20626a = "http";
        r10 = r10 + 5;
        goto L52
    L49:
        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + r5.substring(0, r12) + "'");
    L5:
        char r46 = r5.charAt(r10);
        if (Intrinsics.compare(r46, 97) < 0) goto L10;
        if (Intrinsics.compare(r46, 122) > 0) goto L10;
    L14:
        r12 = r10 + 1;
    L15:
        if (r12 >= r11) goto L4;
        char r47 = r5.charAt(r12);
        if ('a' > r47) goto L21;
        if ('z' < r47) goto L21;
    L39:
        r12 = r12 + 1;
    L21:
        if ('A' > r47) goto L26;
        if ('Z' >= r47) goto L39;
    L26:
        if ('0' > r47) goto L32;
        if ('9' >= r47) goto L39;
    L32:
        if (r47 == '+') goto L39;
        if (r47 == '-') goto L39;
        if (r47 == '.') goto L39;
        if (r47 != ':') goto L4;
    L10:
        if (Intrinsics.compare(r46, 65) < 0) goto L4;
        if (Intrinsics.compare(r46, 90) <= 0) goto L14;
        goto L14
    }

    public final void e(String r10, int r11, int r12, boolean r13, boolean r14) {
        String r15 = uj.a.h(r10, r11, r12, " \"<>^`{}|/\\?#", r14, false, false, false, 240);
        if (Intrinsics.areEqual(r15, ".") == false) goto L5;
        return;
    L5:
        if (StringsKt.l(r15, "%2e") == true) goto L33;
        boolean r16 = Intrinsics.areEqual(r15, "..");
        ArrayList r17 = this.f;
        if (r16 == true) goto L24;
        if (StringsKt.l(r15, "%2e.") == true) goto L24;
        if (StringsKt.l(r15, ".%2e") == true) goto L24;
        if (StringsKt.l(r15, "%2e%2e") == true) goto L24;
        if (((CharSequence) androidx.constraintlayout.motion.widget.a.h(r17, 1)).length() != 0) goto L19;
        r17.set(r17.size() - 1, r15);
    L20:
        if (r13 == false) goto L30;
        r17.add("");
        return;
    L30:
        return;
    L19:
        r17.add(r15);
    L24:
        if (((String) r17.remove(r17.size() - 1)).length() == 0) goto L26;
    L28:
        r17.add("");
        return;
    L26:
        if (r17.isEmpty() == true) goto L28;
        r17.set(r17.size() - 1, "");
        return;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        String r10 = this.f20626a;
        if (r10 == null) goto L5;
        r5.append(r10);
        r5.append("://");
    L7:
        if (this.f20627b.length() <= 0) goto L10;
    L11:
        r5.append(this.f20627b);
        if (this.f20628c.length() <= 0) goto L14;
        r5.append(':');
        r5.append(this.f20628c);
    L14:
        r5.append('@');
    L15:
        String r11 = this.d;
        if (r11 == null) goto L21;
        Intrinsics.checkNotNull(r11);
        if (StringsKt.f(r11, ':') == false) goto L20;
        r5.append('[');
        r5.append(this.d);
        r5.append(']');
        goto L21
    L20:
        r5.append(this.d);
    L21:
        int r12 = -1;
        if (this.e == (-1)) goto L24;
    L25:
        int r13 = b();
        String r14 = this.f20626a;
        if (r14 == null) goto L39;
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNullParameter(r14, "scheme");
        int r15 = r14.hashCode();
        if (r15 == 3213448) goto L36;
        if (r15 == 99617003) goto L33;
    L38:
        if (r13 != r12) goto L39;
    L40:
        ArrayList r16 = this.f;
        Intrinsics.checkNotNullParameter(r16, "$this$toPathString");
        Intrinsics.checkNotNullParameter(r5, "out");
        int r17 = r16.size();
        int r18 = 0;
    L41:
        if (r18 >= r17) goto L44;
        r5.append('/');
        r5.append((String) r16.get(r18));
        r18 = r18 + 1;
        goto L41
    L44:
        if (this.g == null) goto L47;
        r5.append('?');
        ArrayList r19 = this.g;
        Intrinsics.checkNotNull(r19);
        uj.a.m(r19, r5);
    L47:
        if (this.f20629h == null) goto L50;
        r5.append('#');
        r5.append(this.f20629h);
    L50:
        return r5.toString();
    L33:
        if (r14.equals(IIvyAIPackageResourceService.SCHEMA) == false) goto L38;
        r12 = 443;
        goto L38
    L36:
        if (r14.equals("http") == false) goto L38;
        r12 = 80;
    L39:
        r5.append(':');
        r5.append(r13);
        goto L40
    L24:
        if (this.f20626a == null) goto L40;
    L10:
        if (this.f20628c.length() <= 0) goto L15;
    L5:
        r5.append("//");
        goto L7
    }
}
