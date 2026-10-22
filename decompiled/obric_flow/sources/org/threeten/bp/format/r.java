package org.threeten.bp.format;

import ai.j0;
import androidx.room.writer.DaoWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TimeZone;
import java.util.TreeMap;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public final class r implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f21238c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f21240b;

    static {
        f21238c = new c(1);
    }

    public /* synthetic */ r(Object r5, int r10) {
        this.f21239a = r10;
        this.f21240b = r5;
    }

    @Override // org.threeten.bp.format.g
    public final int parse(u r15, CharSequence r16, int r17) {
        switch(this.f21239a) {
            case 0: goto L110;
            case 1: goto L87;
            case 2: goto L15;
            default: goto L5;
        };
    L87:
        if (r17 < 0) goto L109;
        if (r17 > r16.length()) goto L109;
        Iterator<org.threeten.bp.chrono.i> r10 = org.threeten.bp.chrono.i.getAvailableChronologies().iterator();
        org.threeten.bp.chrono.i r11 = null;
        int r12 = -1;
    L92:
        if (r10.hasNext() == false) goto L98;
        org.threeten.bp.chrono.i r13 = r10.next();
        String r5 = r13.getId();
        int r14 = r5.length();
        if (r14 <= r12) goto L92;
        if (r15.f(r16, r17, r5, 0, r14) == false) goto L92;
        r11 = r13;
        r12 = r14;
        goto L92
    L98:
        if (r11 == null) goto L151;
        t r18 = r15.b();
        r18.f21247a = r11;
        if (r18.f == null) goto L107;
        ArrayList r19 = new ArrayList(r18.f);
        r18.f.clear();
        Iterator r20 = r19.iterator();
    L104:
        if (r20.hasNext() == false) goto L107;
        Object[] r21 = (Object[]) r20.next();
        ((m) r21[0]).c(r15, ((Long) r21[1]).longValue(), ((Integer) r21[2]).intValue(), ((Integer) r21[3]).intValue());
    L107:
        return r17 + r12;
    L151:
        return ~r17;
    L109:
        throw new IndexOutOfBoundsException();
    L110:
        TreeMap r22 = new TreeMap(f21238c);
        Iterator<String> r23 = ZoneId.getAvailableZoneIds().iterator();
    L112:
        if (r23.hasNext() == false) goto L118;
        String r24 = r23.next();
        r22.put(r24, r24);
        TimeZone r25 = TimeZone.getTimeZone(r24);
        if (((TextStyle) this.f21240b).asNormal() != TextStyle.FULL) goto L116;
        int r26 = 1;
    L117:
        r22.put(r25.getDisplayName(false, r26, r15.f21250a), r24);
        r22.put(r25.getDisplayName(true, r26, r15.f21250a), r24);
        goto L112
    L116:
        r26 = 0;
        goto L117
    L118:
        Iterator r27 = r22.entrySet().iterator();
    L120:
        if (r27.hasNext() == false) goto L125;
        Map.Entry r110 = (Map.Entry) r27.next();
        String r111 = (String) r110.getKey();
        if (r15.f(r16, r17, r111, 0, r111.length()) == false) goto L120;
        r15.d(ZoneId.of((String) r110.getValue()));
        return r111.length() + r17;
    L125:
        return ~r17;
    L5:
        if (r17 > r16.length()) goto L13;
        if (r17 < 0) goto L13;
        String r28 = (String) this.f21240b;
        if (r15.f(r16, r17, r28, 0, r28.length()) == true) goto L11;
        return ~r17;
    L11:
        return r28.length() + r17;
    L13:
        throw new IndexOutOfBoundsException();
    L15:
        if (r15.f(r16, r17, "GMT", 0, 3) == false) goto L141;
        int r29 = r17 + 3;
        if (((TextStyle) this.f21240b) == TextStyle.FULL) goto L142;
        int r30 = r16.length();
        if (r29 == r30) goto L143;
        char r31 = r16.charAt(r29);
        if (r31 == '+') goto L27;
        if (r31 == '-') goto L27;
        return r15.e(ChronoField.OFFSET_SECONDS, 0, r29, r29);
    L27:
        if (r31 != '-') goto L29;
        int r32 = -1;
    L30:
        if (r29 == r30) goto L145;
        int r33 = r17 + 4;
        char r34 = r16.charAt(r33);
        if (r34 < '0') goto L146;
        if (r34 > '9') goto L146;
        r33 = r17 + 5;
        int r35 = r34 - '0';
        if (r33 == r30) goto L46;
        char r36 = r16.charAt(r33);
        if (r36 < '0') goto L46;
        if (r36 > '9') goto L46;
        r35 = (r35 * 10) + (r36 - '0');
        if (r35 > 23) goto L146;
        r33 = r17 + 6;
    L46:
        int r37 = r33;
        if (r37 == r30) goto L86;
        if (r16.charAt(r37) != ':') goto L86;
        r33 = r37 + 1;
        int r112 = r30 - 2;
        if (r33 > r112) goto L146;
        char r113 = r16.charAt(r33);
        if (r113 < '0') goto L146;
        if (r113 > '9') goto L146;
        r33 = r37 + 2;
        int r114 = r113 - '0';
        char r115 = r16.charAt(r33);
        if (r115 < '0') goto L146;
        if (r115 > '9') goto L146;
        int r116 = r37 + 3;
        int r117 = (r115 - '0') + (r114 * 10);
        if (r117 > 59) goto L147;
        if (r116 == r30) goto L150;
        if (r16.charAt(r116) != ':') goto L150;
        int r38 = r37 + 4;
        if (r38 > r112) goto L148;
        char r39 = r16.charAt(r38);
        if (r39 < '0') goto L148;
        if (r39 > '9') goto L148;
        r38 = r37 + 5;
        int r40 = r39 - '0';
        char r41 = r16.charAt(r38);
        if (r41 < '0') goto L148;
        if (r41 > '9') goto L148;
        r29 = r37 + 6;
        int r42 = (r41 - '0') + (r40 * 10);
        if (r42 > 59) goto L145;
        return r15.e(ChronoField.OFFSET_SECONDS, (((r117 * 60) + (r35 * 3600)) + r42) * r32, r29, r29);
    L148:
        return ~r38;
    L150:
        return r15.e(ChronoField.OFFSET_SECONDS, ((r117 * 60) + (r35 * 3600)) * r32, r116, r116);
    L147:
        return ~r116;
    L86:
        return r15.e(ChronoField.OFFSET_SECONDS, (r32 * 3600) * r35, r37, r37);
    L146:
        return ~r33;
    L145:
        return ~r29;
    L29:
        r32 = 1;
        goto L30
    L143:
        return r15.e(ChronoField.OFFSET_SECONDS, 0, r29, r29);
    L142:
        return new k("", "+HH:MM:ss").parse(r15, r16, r29);
    L141:
        return ~r17;
    }

    @Override // org.threeten.bp.format.g
    public final boolean print(w r10, StringBuilder r11) {
        switch(this.f21239a) {
            case 0: goto L38;
            case 1: goto L26;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        r11.append((String) this.f21240b);
        return true;
    L6:
        Long r5 = r10.a(ChronoField.OFFSET_SECONDS);
        if (r5 != null) goto L9;
        return false;
    L9:
        r11.append("GMT");
        if (((TextStyle) this.f21240b) == TextStyle.FULL) goto L57;
        int r12 = jm.c.x(r5.longValue());
        if (r12 == 0) goto L24;
        int r13 = Math.abs((r12 / 3600) % 100);
        int r14 = Math.abs((r12 / 60) % 60);
        int r15 = Math.abs(r12 % 60);
        if (r12 >= 0) goto L17;
        String r16 = DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD;
    L18:
        r11.append(r16);
        r11.append(r13);
        if (r14 > 0) goto L21;
        if (r15 <= 0) goto L24;
    L21:
        r11.append(":");
        r11.append((char) ((r14 / 10) + 48));
        r11.append((char) ((r14 % 10) + 48));
        if (r15 <= 0) goto L24;
        r11.append(":");
        r11.append((char) ((r15 / 10) + 48));
        r11.append((char) ((r15 % 10) + 48));
        goto L24
    L17:
        r16 = "+";
    L24:
        return true;
    L57:
        return new k("", "+HH:MM:ss").print(r10, r11);
    L26:
        org.threeten.bp.chrono.i r17 = (org.threeten.bp.chrono.i) r10.b(org.threeten.bp.temporal.h.f21287b);
        if (r17 != null) goto L30;
        return false;
    L30:
        if (((TextStyle) this.f21240b) != null) goto L54;
        r11.append(r17.getId());
    L36:
        return true;
    L54:
        r11.append(ResourceBundle.getBundle("org.threeten.bp.format.ChronologyText", r10.f21257b, s.class.getClassLoader()).getString(r17.getId()));     // Catch: MissingResourceException -> L35
    L35:
        r11.append(r17.getId());
        goto L36
    L38:
        ZoneId r18 = (ZoneId) r10.b(org.threeten.bp.temporal.h.f21286a);
        int r19 = 0;
        if (r18 != null) goto L42;
        return false;
    L42:
        if ((r18.normalized() instanceof ZoneOffset) == false) goto L45;
        r11.append(r18.getId());
    L53:
        return true;
    L45:
        ChronoField r20 = ChronoField.INSTANT_SECONDS;
        org.threeten.bp.temporal.d r21 = r10.f21256a;
        if (r21.isSupported(r20) == false) goto L48;
        boolean r22 = r18.getRules().isDaylightSavings(Instant.ofEpochSecond(r21.getLong(r20)));
    L49:
        TimeZone r23 = TimeZone.getTimeZone(r18.getId());
        if (((TextStyle) this.f21240b).asNormal() != TextStyle.FULL) goto L52;
        r19 = 1;
    L52:
        r11.append(r23.getDisplayName(r22, r19, r10.f21257b));
        goto L53
    L48:
        r22 = false;
        goto L49
    }

    public String toString() {
        switch(this.f21239a) {
            case 0: goto L9;
            case 3: goto L7;
            default: goto L5;
        };
    L5:
        return super.toString();
    L7:
        return j0.k("'", ((String) this.f21240b).replace("'", "''"), "'");
    L9:
        return "ZoneText(" + ((TextStyle) this.f21240b) + ")";
    }

    public r(TextStyle r5) {
        this.f21239a = 0;
        jm.c.p(r5, "textStyle");
        this.f21240b = r5;
    }
}
