package com.squareup.javapoet;

import ai.j0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f14975q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f14977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14978c;
    public boolean d;
    public boolean e;
    public String f;
    public final ArrayList g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashSet f14979h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set f14980i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set f14981j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map f14982k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedHashMap f14983l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashSet f14984m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final bd.d f14985n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f14986o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14987p;

    static {
        f14975q = new String();
    }

    public k(StringBuilder r5) {
        this(r5, "  ", Collections.emptySet(), Collections.emptySet());
    }

    public static String k(String r5) {
        com.bytedance.android.anniex.base.service.f.r(Character.isJavaIdentifierStart(r5.charAt(0)), "not an identifier: %s", new Object[]{r5});
        int r10 = 1;
    L4:
        if (r10 > r5.length()) goto L10;
        if (SourceVersion.isIdentifier(r5.substring(0, r10)) == false) goto L8;
        r10 = r10 + 1;
        goto L4
    L8:
        return r5.substring(0, r10 - 1);
    L10:
        return r5;
    }

    public final k a(i r5) {
        c(r5, false);
        return this;
    }

    public final k b(String r5, Object... r10) {
        c(i.d(r5, r10), false);
        return this;
    }

    public final void c(i r17, boolean r18) {
        int r5 = 2;
        int r10 = -1;
        ListIterator r11 = r17.f14971a.listIterator();
        int r12 = 0;
        e r13 = null;
    L3:
        boolean r14 = r11.hasNext();
        r r15 = this.f14977b;
        if (r14 == false) goto L163;
        String r16 = (String) r11.next();
        r16.getClass();
        List r19 = r17.f14972b;
        switch(r16.hashCode()) {
            case 1152: goto L49;
            case 1176: goto L45;
            case 1178: goto L41;
            case 1192: goto L37;
            case 1194: goto L33;
            case 1199: goto L29;
            case 1200: goto L25;
            case 1203: goto L21;
            case 1206: goto L17;
            case 1207: goto L13;
            case 1209: goto L9;
            default: goto L7;
        };
    L7:
        int r110 = r10;
    L52:
        switch(r110) {
            case 0: goto L161;
            case 1: goto L160;
            case 2: goto L159;
            case 3: goto L149;
            case 4: goto L147;
            case 5: goto L107;
            case 6: goto L93;
            case 7: goto L89;
            case 8: goto L82;
            case 9: goto L78;
            case 10: goto L70;
            default: goto L53;
        };
    L53:
        if (r13 != null) goto L55;
    L68:
        e(r16);
    L162:
        r5 = 2;
        r10 = -1;
        goto L3
    L55:
        if (r16.startsWith(".") == false) goto L67;
        String r111 = r16.substring(1);
        if (r111.isEmpty() == true) goto L67;
        if (Character.isJavaIdentifierStart(r111.charAt(0)) == false) goto L67;
        StringBuilder r112 = new StringBuilder();
        String r113 = r13.A;
        r112.append(r113);
        r112.append(".");
        r112.append(k(r111));
        String r114 = r112.toString();
        String r115 = j0.j(r113, ".*");
        Set r116 = this.f14980i;
        if (r116.contains(r114) == false) goto L65;
    L66:
        e(r111);
        r13 = null;
        goto L162
    L65:
        if (r116.contains(r115) == true) goto L66;
    L67:
        r13.c(this);
        r13 = null;
        goto L68
    L82:
        int r117 = this.f14978c + r5;
        if (r15.e == 0) goto L162;
        LineWrapper$FlushType r118 = r15.g;
        if (r118 == null) goto L88;
        r15.b(r118);
    L88:
        r15.g = LineWrapper$FlushType.EMPTY;
        r15.f = r117;
        goto L162
    L89:
        int r119 = this.f14978c + r5;
        LineWrapper$FlushType r120 = r15.g;
        if (r120 == null) goto L92;
        r15.b(r120);
    L92:
        r15.e++;
        r15.g = LineWrapper$FlushType.SPACE;
        r15.f = r119;
        goto L162
    L93:
        int r121 = r12 + 1;
        x r20 = (x) r19.get(r12);
        if ((r20 instanceof e) == true) goto L96;
    L105:
        r20.c(this);
    L106:
        r12 = r121;
        goto L162
    L96:
        if (r11.hasNext() == false) goto L105;
        if (((String) r17.f14971a.get(r11.nextIndex())).startsWith("$") == true) goto L105;
        e r122 = (e) r20;
        if (this.f14979h.contains(r122.A) == false) goto L105;
        if (r13 != null) goto L103;
        boolean r21 = true;
    L104:
        com.bytedance.android.anniex.base.service.f.t(r21, "pending type for static import?!", new Object[0]);
        r12 = r121;
        r13 = r122;
        goto L162
    L103:
        r21 = false;
        goto L104
    L107:
        r121 = r12 + 1;
        String r22 = (String) r19.get(r12);
        if (r22 == null) goto L145;
        StringBuilder r123 = new StringBuilder(r22.length() + r5);
        r123.append(Typography.quote);
        int r124 = 0;
    L111:
        if (r124 >= r22.length()) goto L144;
        char r125 = r22.charAt(r124);
        if (r125 != '\'') goto L115;
        r123.append("'");
    L143:
        r124 = r124 + 1;
        goto L111
    L115:
        if (r125 != '\"') goto L118;
        r123.append("\\\"");
        goto L143
    L118:
        if (r125 != '\f') goto L120;
        String r23 = "\\f";
    L138:
        r123.append(r23);
        if (r125 != '\n') goto L143;
        if ((r124 + 1) >= r22.length()) goto L143;
        r123.append("\"\n");
        String r24 = this.f14976a;
        r123.append(r24);
        r123.append(r24);
        r123.append("+ \"");
        goto L143
    L120:
        if (r125 == '\r') goto L136;
        if (r125 == '\"') goto L135;
        if (r125 != '\'') goto L124;
        r23 = "\\'";
        goto L138
    L124:
        if (r125 == '\\') goto L133;
        switch(r125) {
            case 8: goto L132;
            case 9: goto L131;
            case 10: goto L130;
            default: goto L127;
        };
    L130:
        r23 = "\\n";
        goto L138
    L131:
        r23 = "\\t";
        goto L138
    L132:
        r23 = "\\b";
        goto L138
    L127:
        if (Character.isISOControl(r125) == false) goto L129;
        r23 = String.format("\\u%04x", new Object[]{Integer.valueOf(r125)});
        goto L138
    L129:
        r23 = Character.toString(r125);
        goto L138
    L133:
        r23 = "\\\\";
        goto L138
    L135:
        r23 = "\"";
        goto L138
    L136:
        r23 = "\\r";
        goto L138
    L144:
        r123.append(Typography.quote);
        String r25 = r123.toString();
    L146:
        e(r25);
        goto L106
    L145:
        r25 = "null";
        goto L146
    L147:
        int r26 = r12 + 1;
        e((String) r19.get(r12));
    L148:
        r12 = r26;
        goto L162
    L149:
        r26 = r12 + 1;
        Object r27 = r19.get(r12);
        if ((r27 instanceof z) == false) goto L153;
        ((z) r27).b(this, null, Collections.emptySet());
        goto L148
    L153:
        if ((r27 instanceof b) == false) goto L156;
        ((b) r27).b(this, true);
        goto L148
    L156:
        if ((r27 instanceof i) == false) goto L158;
        c((i) r27, false);
        goto L148
    L158:
        e(String.valueOf(r27));
        goto L148
    L159:
        m(1);
        goto L162
    L160:
        r(1);
        goto L162
    L161:
        e("$");
        goto L162
    L70:
        if (this.f14987p == r10) goto L72;
        boolean r126 = true;
    L73:
        com.bytedance.android.anniex.base.service.f.t(r126, "statement exit $] has no matching statement enter $[", new Object[0]);
        if (this.f14987p <= 0) goto L76;
        r(r5);
    L76:
        this.f14987p = r10;
        goto L162
    L72:
        r126 = false;
        goto L73
    L78:
        if (this.f14987p != r10) goto L80;
        boolean r127 = true;
    L81:
        com.bytedance.android.anniex.base.service.f.t(r127, "statement enter $[ followed by statement enter $[", new Object[0]);
        this.f14987p = 0;
        goto L162
    L80:
        r127 = false;
        goto L81
    L9:
        if (r16.equals("$]") == false) goto L188;
        r110 = 10;
        goto L52
    L188:
        r110 = r10;
        goto L52
    L13:
        if (r16.equals("$[") == false) goto L189;
        r110 = 9;
        goto L52
    L189:
        r110 = r10;
        goto L52
    L17:
        if (r16.equals("$Z") == false) goto L190;
        r110 = 8;
        goto L52
    L190:
        r110 = r10;
        goto L52
    L21:
        if (r16.equals("$W") == false) goto L191;
        r110 = 7;
        goto L52
    L191:
        r110 = r10;
        goto L52
    L25:
        if (r16.equals("$T") == false) goto L192;
        r110 = 6;
        goto L52
    L192:
        r110 = r10;
        goto L52
    L29:
        if (r16.equals("$S") == false) goto L193;
        r110 = 5;
        goto L52
    L193:
        r110 = r10;
        goto L52
    L33:
        if (r16.equals("$N") == false) goto L194;
        r110 = 4;
        goto L52
    L194:
        r110 = r10;
        goto L52
    L37:
        if (r16.equals("$L") == false) goto L195;
        r110 = 3;
        goto L52
    L195:
        r110 = r10;
        goto L52
    L41:
        if (r16.equals("$>") == false) goto L196;
        r110 = r5;
        goto L52
    L196:
        r110 = r10;
        goto L52
    L45:
        if (r16.equals("$<") == false) goto L197;
        r110 = 1;
        goto L52
    L197:
        r110 = r10;
        goto L52
    L49:
        if (r16.equals("$$") == false) goto L198;
        r110 = 0;
        goto L52
    L198:
        r110 = r10;
        goto L52
    L163:
        if (r18 == true) goto L165;
        return;
    L165:
        if (r15.f15000a.f14999b == '\n') goto L200;
        e("\n");
        return;
    }

    public final void d(String r5) {
        e(r5);
    }

    public final void e(String r11) {
        String[] r12 = r11.split("\\R", -1);
        int r5 = r12.length;
        boolean r10 = true;
        int r13 = 0;
    L3:
        if (r13 >= r5) goto L43;
        String r14 = r12[r13];
        String r15 = this.f14976a;
        r r16 = this.f14977b;
        if (r10 == true) goto L27;
        if (this.d == true) goto L11;
        if (this.e == true) goto L11;
    L21:
        r16.a("\n");
        this.f14986o = true;
        int r17 = this.f14987p;
        if (r17 == (-1)) goto L27;
        if (r17 != 0) goto L25;
        m(2);
    L25:
        this.f14987p++;
    L11:
        if (this.f14986o == false) goto L21;
        int r18 = 0;
    L14:
        if (r18 >= this.f14978c) goto L17;
        r16.a(r15);
        r18 = r18 + 1;
        goto L14
    L17:
        if (this.d == false) goto L19;
        String r19 = " *";
    L20:
        r16.a(r19);
        goto L21
    L19:
        r19 = "//";
    L27:
        if (r14.isEmpty() == true) goto L42;
        if (this.f14986o == false) goto L41;
        int r20 = 0;
    L33:
        if (r20 >= this.f14978c) goto L36;
        r16.a(r15);
        r20 = r20 + 1;
        goto L33
    L36:
        if (this.d == false) goto L39;
        r16.a(" * ");
        goto L41
    L39:
        if (this.e == false) goto L41;
        r16.a("// ");
    L41:
        r16.a(r14);
        this.f14986o = false;
    L42:
        r13 = r13 + 1;
        r10 = false;
        goto L3
    }

    public final void f(List r5, boolean r10) {
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        ((b) r11.next()).b(this, r10);
        if (r10 == false) goto L8;
        String r12 = " ";
    L9:
        e(r12);
        goto L4
    L8:
        r12 = "\n";
        goto L9
    }

    public final void g(i r5) {
        if (r5.f14971a.isEmpty() == false) goto L5;
        return;
    L5:
        e("/**\n");
        this.d = true;
        c(r5, true);     // Catch: Throwable -> L9
        this.d = false;
        e(" */\n");
        return;
    L9:
        th = move-exception;
        this.d = false;
        throw th;
    }

    public final void h(Set r5, Set r10) {
        if (r5.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r11 = EnumSet.copyOf(r5).iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        Modifier r12 = (Modifier) r11.next();
        if (r10.contains(r12) == true) goto L7;
        e(r12.name().toLowerCase(Locale.US));
        e(" ");
        goto L7
    }

    public final void i(List r10) {
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        r10.forEach(new j(this, 1));
        e("<");
        Iterator r11 = r10.iterator();
        boolean r5 = true;
    L7:
        if (r11.hasNext() == false) goto L20;
        a0 r12 = (a0) r11.next();
        if (r5 == true) goto L11;
        e(", ");
    L11:
        f(r12.f15038b, true);
        b("$L", new Object[]{r12.f14951w});
        Iterator r13 = r12.f14952x.iterator();
        boolean r14 = true;
    L13:
        if (r13.hasNext() == false) goto L19;
        x r15 = (x) r13.next();
        if (r14 == false) goto L17;
        String r16 = " extends $T";
    L18:
        b(r16, new Object[]{r15});
        r14 = false;
        goto L13
    L17:
        r16 = " & $T";
        goto L18
    L19:
        r5 = false;
        goto L7
    L20:
        e(">");
    }

    public final void j() {
        int r5 = this.f14978c + 2;
        r r10 = this.f14977b;
        LineWrapper$FlushType r11 = r10.g;
        if (r11 == null) goto L5;
        r10.b(r11);
    L5:
        r10.e++;
        r10.g = LineWrapper$FlushType.SPACE;
        r10.f = r5;
    }

    public final void l() {
        m(1);
    }

    public final void m(int r5) {
        this.f14978c += r5;
    }

    public final void n() {
        ArrayList r5 = this.g;
        r5.remove(r5.size() - 1);
    }

    public final void o(List r5) {
        r5.forEach(new j(this, 0));
    }

    public final void p(z r5) {
        this.g.add(r5);
    }

    public final void q() {
        r(1);
    }

    public final void r(int r5) {
        if ((this.f14978c - r5) < 0) goto L5;
        boolean r10 = true;
    L6:
        com.bytedance.android.anniex.base.service.f.r(r10, "cannot unindent %s from %s", new Object[]{Integer.valueOf(r5), Integer.valueOf(this.f14978c)});
        this.f14978c -= r5;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public k(Appendable r10, String r11, Set r12, Set r13) {
        this(r10, r11, Collections.emptyMap(), r12, r13);
    }

    public k(Appendable r5, String r10, Map r11, Set r12, Set r13) {
        this.d = false;
        this.e = false;
        this.f = f14975q;
        this.g = new ArrayList();
        this.f14983l = new LinkedHashMap();
        this.f14984m = new LinkedHashSet();
        this.f14985n = new bd.d(5);
        this.f14987p = -1;
        this.f14977b = new r(r5, r10);
        com.bytedance.android.anniex.base.service.f.s(r10, "indent == null", new Object[0]);
        this.f14976a = r10;
        com.bytedance.android.anniex.base.service.f.s(r11, "importedTypes == null", new Object[0]);
        this.f14982k = r11;
        com.bytedance.android.anniex.base.service.f.s(r12, "staticImports == null", new Object[0]);
        this.f14980i = r12;
        com.bytedance.android.anniex.base.service.f.s(r13, "alwaysQualify == null", new Object[0]);
        this.f14981j = r13;
        this.f14979h = new LinkedHashSet();
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        String r15 = (String) r14.next();
        this.f14979h.add(r15.substring(0, r15.lastIndexOf(46)));
        goto L4
    }
}
