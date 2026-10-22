package org.threeten.bp.format;

import ai.j0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.LocalDate;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final com.bytedance.frameworks.baselib.network.http.cronet.b f21241h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final HashMap f21242i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final c f21243j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f21244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f21245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f21246c;
    public final boolean d;
    public int e;
    public char f;
    public int g;

    static {
        f21241h = new com.bytedance.frameworks.baselib.network.http.cronet.b(15);
        HashMap r5 = new HashMap();
        f21242i = r5;
        r5.put('G', ChronoField.ERA);
        r5.put('y', ChronoField.YEAR_OF_ERA);
        r5.put('u', ChronoField.YEAR);
        org.threeten.bp.temporal.g r10 = org.threeten.bp.temporal.b.f21283a;
        r5.put('Q', r10);
        r5.put('q', r10);
        ChronoField r11 = ChronoField.MONTH_OF_YEAR;
        r5.put('M', r11);
        r5.put('L', r11);
        r5.put('D', ChronoField.DAY_OF_YEAR);
        r5.put('d', ChronoField.DAY_OF_MONTH);
        r5.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        ChronoField r12 = ChronoField.DAY_OF_WEEK;
        r5.put('E', r12);
        r5.put('c', r12);
        r5.put('e', r12);
        r5.put('a', ChronoField.AMPM_OF_DAY);
        r5.put('H', ChronoField.HOUR_OF_DAY);
        r5.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        r5.put('K', ChronoField.HOUR_OF_AMPM);
        r5.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);
        r5.put('m', ChronoField.MINUTE_OF_HOUR);
        r5.put('s', ChronoField.SECOND_OF_MINUTE);
        ChronoField r13 = ChronoField.NANO_OF_SECOND;
        r5.put('S', r13);
        r5.put('A', ChronoField.MILLI_OF_DAY);
        r5.put('n', r13);
        r5.put('N', ChronoField.NANO_OF_DAY);
        f21243j = new c(0);
    }

    public s() {
        this.f21244a = this;
        this.f21246c = new ArrayList();
        this.g = -1;
        this.f21245b = null;
        this.d = false;
    }

    public final void a(b r5) {
        jm.c.p(r5, "formatter");
        f r10 = r5.f21204a;
        if (r10.f21213b == false) goto L6;
        r10 = new f(r10.f21212a, false);
    L6:
        b(r10);
    }

    public final int b(g r5) {
        jm.c.p(r5, "pp");
        s r10 = this.f21244a;
        int r11 = r10.e;
        if (r11 <= 0) goto L5;
        l r12 = new l(r5, r11, r10.f);
        r10.e = 0;
        r10.f = 0;
        r5 = r12;
    L5:
        r10.f21246c.add(r5);
        s r13 = this.f21244a;
        r13.g = -1;
        return r13.f21246c.size() - 1;
    }

    public final void c(char r5) {
        b(new e(r5));
    }

    public final void d(String r5) {
        jm.c.p(r5, "literal");
        if (r5.length() > 0) goto L5;
        return;
    L5:
        if (r5.length() != 1) goto L7;
        b(new e(r5.charAt(0)));
        return;
    L7:
        b(new r(r5, 3));
    }

    public final void e(TextStyle r5) {
        jm.c.p(r5, "style");
        if (r5 != TextStyle.FULL) goto L5;
    L9:
        b(new r(r5, 2));
        return;
    L5:
        if (r5 == TextStyle.SHORT) goto L9;
        throw new IllegalArgumentException("Style must be either full or short");
    }

    public final void f(String r5, String r10) {
        b(new k(r10, r5));
    }

    public final void g(String r15) {
        int r5 = 0;
    L4:
        if (r5 >= r15.length()) goto L269;
        char r10 = r15.charAt(r5);
        if (r10 < 'A') goto L8;
        if (r10 > 'Z') goto L8;
    L10:
        int r11 = r5 + 1;
    L12:
        if (r11 >= r15.length()) goto L16;
        if (r15.charAt(r11) != r10) goto L16;
        r11 = r11 + 1;
    L16:
        int r12 = r11 - r5;
        if (r10 == 'p') goto L19;
    L40:
        org.threeten.bp.temporal.g r13 = (org.threeten.bp.temporal.g) f21242i.get(Character.valueOf(r10));
        if (r13 != null) goto L43;
        if (r10 != 'z') goto L160;
        if (r12 > 4) goto L158;
        if (r12 != 4) goto L156;
        b(new r(TextStyle.FULL));
    L224:
        r5 = r11 - 1;
    L266:
        r5 = r5 + 1;
        goto L4
    L156:
        b(new r(TextStyle.SHORT));
        goto L224
    L158:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L160:
        if (r10 != 'V') goto L165;
        if (r12 != 2) goto L164;
        b(new q(org.threeten.bp.temporal.h.f21286a, "ZoneId()"));
        goto L224
    L164:
        throw new IllegalArgumentException(kotlin.collections.a.g("Pattern letter count must be 2: ", r10));
    L165:
        String r14 = "+0000";
        if (r10 != 'Z') goto L176;
        if (r12 >= 4) goto L169;
        f("+HHMM", "+0000");
        goto L224
    L169:
        if (r12 != 4) goto L171;
        e(TextStyle.FULL);
        goto L224
    L171:
        if (r12 != 5) goto L174;
        f("+HH:MM:ss", "Z");
        goto L224
    L174:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L176:
        if (r10 != 'O') goto L184;
        if (r12 != 1) goto L179;
        e(TextStyle.SHORT);
        goto L224
    L179:
        if (r12 != 4) goto L182;
        e(TextStyle.FULL);
        goto L224
    L182:
        throw new IllegalArgumentException(kotlin.collections.a.g("Pattern letter count must be 1 or 4: ", r10));
    L184:
        if (r10 != 'X') goto L194;
        if (r12 > 5) goto L192;
        String[] r16 = k.f21220c;
        if (r12 != 1) goto L189;
        int r17 = 0;
    L190:
        f(r16[r12 + r17], "Z");
        goto L224
    L189:
        r17 = 1;
        goto L190
    L192:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L194:
        if (r10 != 'x') goto L210;
        if (r12 > 5) goto L208;
        if (r12 != 1) goto L199;
        r14 = "+00";
    L202:
        String[] r18 = k.f21220c;
        if (r12 != 1) goto L205;
        int r19 = 0;
    L206:
        f(r18[r12 + r19], r14);
        goto L224
    L205:
        r19 = 1;
        goto L206
    L199:
        if ((r12 % 2) == 0) goto L202;
        r14 = "+00:00";
        goto L202
    L208:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L210:
        if (r10 != 'W') goto L216;
        if (r12 > 1) goto L214;
        b(new o('W', r12));
        goto L224
    L214:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L216:
        if (r10 != 'w') goto L222;
        if (r12 > 2) goto L220;
        b(new o('w', r12));
        goto L224
    L220:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L222:
        if (r10 != 'Y') goto L226;
        b(new o('Y', r12));
        goto L224
    L226:
        throw new IllegalArgumentException(kotlin.collections.a.g("Unknown pattern letter: ", r10));
    L43:
        if (r10 != 'Q') goto L45;
    L140:
        if (r12 == 1) goto L151;
        if (r12 == 2) goto L150;
        if (r12 == 3) goto L149;
        if (r12 == 4) goto L148;
        if (r12 != 5) goto L147;
        i(r13, TextStyle.NARROW);
        goto L224
    L147:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L148:
        i(r13, TextStyle.FULL);
        goto L224
    L149:
        i(r13, TextStyle.SHORT);
        goto L224
    L150:
        l(r13, 2);
        goto L224
    L151:
        k(r13);
        goto L224
    L45:
        if (r10 == 'S') goto L139;
        if (r10 != 'a') goto L48;
        if (r12 != 1) goto L138;
        i(r13, TextStyle.SHORT);
        goto L224
    L138:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L48:
        if (r10 != 'h') goto L50;
    L129:
        if (r12 != 1) goto L131;
        k(r13);
        goto L224
    L131:
        if (r12 != 2) goto L134;
        l(r13, r12);
        goto L224
    L134:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L50:
        if (r10 == 'k') goto L129;
        if (r10 == 'm') goto L129;
        if (r10 != 'q') goto L56;
    L117:
        if (r12 == 1) goto L128;
        if (r12 == 2) goto L127;
        if (r12 == 3) goto L126;
        if (r12 == 4) goto L125;
        if (r12 != 5) goto L124;
        i(r13, TextStyle.NARROW_STANDALONE);
        goto L224
    L124:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L125:
        i(r13, TextStyle.FULL_STANDALONE);
        goto L224
    L126:
        i(r13, TextStyle.SHORT_STANDALONE);
        goto L224
    L127:
        l(r13, 2);
        goto L224
    L128:
        k(r13);
        goto L224
    L56:
        if (r10 == 's') goto L129;
        if (r10 != 'u') goto L60;
    L111:
        if (r12 != 2) goto L114;
        LocalDate r20 = m.f21226h;
        jm.c.p(r20, "baseDate");
        j(new m(r13, r20));
        goto L224
    L114:
        if (r12 >= 4) goto L116;
        m(r13, r12, 19, SignStyle.NORMAL);
        goto L224
    L116:
        m(r13, r12, 19, SignStyle.EXCEEDS_PAD);
        goto L224
    L60:
        if (r10 == 'y') goto L111;
        switch(r10) {
            case 68: goto L105;
            case 69: goto L95;
            case 70: goto L91;
            case 71: goto L95;
            case 72: goto L129;
            default: goto L62;
        };
    L62:
        switch(r10) {
            case 75: goto L129;
            case 76: goto L117;
            case 77: goto L140;
            default: goto L63;
        };
    L63:
        switch(r10) {
            case 99: goto L78;
            case 100: goto L129;
            case 101: goto L67;
            default: goto L64;
        };
    L64:
        if (r12 != 1) goto L66;
        k(r13);
        goto L224
    L66:
        l(r13, r12);
        goto L224
    L67:
        if (r12 == 1) goto L77;
        if (r12 == 2) goto L77;
        if (r12 == 3) goto L76;
        if (r12 == 4) goto L75;
        if (r12 != 5) goto L74;
        i(r13, TextStyle.NARROW);
        goto L224
    L74:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L75:
        i(r13, TextStyle.FULL);
        goto L224
    L76:
        i(r13, TextStyle.SHORT);
    L77:
        b(new o('e', r12));
        goto L224
    L78:
        if (r12 == 1) goto L90;
        if (r12 == 2) goto L89;
        if (r12 == 3) goto L87;
        if (r12 == 4) goto L86;
        if (r12 != 5) goto L85;
        i(r13, TextStyle.NARROW_STANDALONE);
        goto L224
    L85:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L86:
        i(r13, TextStyle.FULL_STANDALONE);
        goto L224
    L87:
        i(r13, TextStyle.SHORT_STANDALONE);
        goto L224
    L89:
        throw new IllegalArgumentException(kotlin.collections.a.g("Invalid number of pattern letters: ", r10));
    L90:
        b(new o('c', r12));
        goto L224
    L91:
        if (r12 != 1) goto L94;
        k(r13);
        goto L224
    L94:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L95:
        if (r12 == 1) goto L104;
        if (r12 == 2) goto L104;
        if (r12 == 3) goto L104;
        if (r12 == 4) goto L103;
        if (r12 != 5) goto L102;
        i(r13, TextStyle.NARROW);
        goto L224
    L102:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L103:
        i(r13, TextStyle.FULL);
    L104:
        i(r13, TextStyle.SHORT);
        goto L224
    L105:
        if (r12 != 1) goto L107;
        k(r13);
        goto L224
    L107:
        if (r12 > 3) goto L110;
        l(r13, r12);
        goto L224
    L110:
        throw new IllegalArgumentException(kotlin.collections.a.g("Too many pattern letters: ", r10));
    L139:
        b(new h(ChronoField.NANO_OF_SECOND, r12, r12, false));
        goto L224
    L19:
        if (r11 >= r15.length()) goto L32;
        r10 = r15.charAt(r11);
        if (r10 < 'A') goto L23;
        if (r10 > 'Z') goto L23;
    L25:
        int r21 = r11 + 1;
    L27:
        if (r21 >= r15.length()) goto L31;
        if (r15.charAt(r21) != r10) goto L31;
        r21 = r21 + 1;
    L31:
        int r22 = r21 - r11;
    L33:
        if (r12 == 0) goto L39;
        if (r12 < 1) goto L37;
        s r23 = this.f21244a;
        r23.e = r12;
        r23.f = ' ';
        r23.g = -1;
        r12 = r22;
        r11 = r21;
        goto L40
    L37:
        throw new IllegalArgumentException(j0.g(r12, "The pad width must be at least one but was "));
    L39:
        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: ".concat(r15));
    L23:
        if (r10 < 'a') goto L32;
        if (r10 <= 'z') goto L25;
    L32:
        r21 = r11;
        r22 = r12;
        r12 = 0;
    L8:
        if (r10 < 'a') goto L228;
        if (r10 <= 'z') goto L10;
    L228:
        if (r10 != '\'') goto L250;
        int r24 = r5 + 1;
        int r25 = r24;
    L231:
        if (r25 >= r15.length()) goto L241;
        if (r15.charAt(r25) != '\'') goto L239;
        int r26 = r25 + 1;
        if (r26 >= r15.length()) goto L241;
        if (r15.charAt(r26) != '\'') goto L241;
        r25 = r26;
    L239:
        r25 = r25 + 1;
    L241:
        if (r25 >= r15.length()) goto L248;
        String r27 = r15.substring(r24, r25);
        if (r27.length() != 0) goto L245;
        c('\'');
    L246:
        r5 = r25;
        goto L266
    L245:
        d(r27.replace("''", "'"));
        goto L246
    L248:
        throw new IllegalArgumentException("Pattern ends with an incomplete string literal: ".concat(r15));
    L250:
        if (r10 != '[') goto L253;
        o();
        goto L266
    L253:
        if (r10 != ']') goto L260;
        if (this.f21244a.f21245b == null) goto L258;
        n();
        goto L266
    L258:
        throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
    L260:
        if (r10 == '{') goto L268;
        if (r10 == '}') goto L268;
        if (r10 == '#') goto L268;
        c(r10);
    L268:
        throw new IllegalArgumentException("Pattern includes reserved character: '" + r10 + "'");
    }

    public final void h(ChronoField r5, HashMap r10) {
        jm.c.p(r5, "field");
        LinkedHashMap r11 = new LinkedHashMap(r10);
        TextStyle r12 = TextStyle.FULL;
        b(new n(r5, r12, new b0(new a0(Collections.singletonMap(r12, r11)))));
    }

    public final void i(org.threeten.bp.temporal.g r5, TextStyle r10) {
        jm.c.p(r5, "field");
        jm.c.p(r10, "textStyle");
        AtomicReference r11 = y.f21260a;
        b(new n(r5, r10, x.f21259a));
    }

    public final void j(j r10) {
        s r5 = this.f21244a;
        int r11 = r5.g;
        if (r11 >= 0) goto L5;
    L13:
        s r12 = this.f21244a;
        r12.g = b(r10);
        return;
    L5:
        if ((r5.f21246c.get(r11) instanceof j) == false) goto L13;
        s r13 = this.f21244a;
        int r14 = r13.g;
        j r15 = (j) r13.f21246c.get(r14);
        int r16 = r10.f21218b;
        int r17 = r10.f21219c;
        if (r16 == r17) goto L9;
    L11:
        j r18 = r15.d();
        s r19 = this.f21244a;
        r19.g = b(r10);
    L12:
        this.f21244a.f21246c.set(r14, r18);
        return;
    L9:
        if (r10.d != SignStyle.NOT_NEGATIVE) goto L11;
        r18 = r15.e(r17);
        b(r10.d());
        this.f21244a.g = r14;
        goto L12
    }

    public final void k(org.threeten.bp.temporal.g r5) {
        j(new j(r5, 1, 19, SignStyle.NORMAL));
    }

    public final void l(org.threeten.bp.temporal.g r5, int r10) {
        jm.c.p(r5, "field");
        if (r10 < 1) goto L9;
        if (r10 > 19) goto L9;
        j(new j(r5, r10, r10, SignStyle.NOT_NEGATIVE));
        return;
    L9:
        throw new IllegalArgumentException(j0.g(r10, "The width must be from 1 to 19 inclusive but was "));
    }

    public final void m(org.threeten.bp.temporal.g r5, int r10, int r11, SignStyle r12) {
        if (r10 == r11) goto L4;
    L7:
        jm.c.p(r5, "field");
        jm.c.p(r12, "signStyle");
        if (r10 < 1) goto L21;
        if (r10 > 19) goto L21;
        if (r11 < 1) goto L19;
        if (r11 > 19) goto L19;
        if (r11 < r10) goto L17;
        j(new j(r5, r10, r11, r12));
        return;
    L17:
        throw new IllegalArgumentException(j0.f(r11, r10, "The maximum width must exceed or equal the minimum width but ", " < "));
    L19:
        throw new IllegalArgumentException(j0.g(r11, "The maximum width must be from 1 to 19 inclusive but was "));
    L21:
        throw new IllegalArgumentException(j0.g(r10, "The minimum width must be from 1 to 19 inclusive but was "));
    L4:
        if (r12 != SignStyle.NOT_NEGATIVE) goto L7;
        l(r5, r11);
    }

    public final void n() {
        s r5 = this.f21244a;
        if (r5.f21245b == null) goto L10;
        if (r5.f21246c.size() <= 0) goto L7;
        s r10 = this.f21244a;
        ArrayList r11 = r10.f21246c;
        f r12 = new f(r10.d, r11);
        this.f21244a = this.f21244a.f21245b;
        b(r12);
        return;
    L7:
        this.f21244a = this.f21244a.f21245b;
        return;
    L10:
        throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
    }

    public final void o() {
        s r5 = this.f21244a;
        r5.g = -1;
        this.f21244a = new s(r5);
    }

    public final b p() {
        return q(Locale.getDefault());
    }

    public final b q(Locale r10) {
        jm.c.p(r10, "locale");
    L4:
        if (this.f21244a.f21245b == null) goto L7;
        n();
        goto L4
    L7:
        return new b(new f(false, this.f21246c), r10, z.f21261a, ResolverStyle.SMART, null);
    }

    public final b r(ResolverStyle r10) {
        b r11 = p();
        jm.c.p(r10, "resolverStyle");
        if (jm.c.k(r10, r11.d) == true) goto L7;
        Locale r5 = r11.f21205b;
        IsoChronology r12 = r11.e;
        return new b(r11.f21204a, r5, r11.f21206c, r10, r12);
    L7:
        return r11;
    }

    public s(s r5) {
        this.f21244a = this;
        this.f21246c = new ArrayList();
        this.g = -1;
        this.f21245b = r5;
        this.d = true;
    }
}
