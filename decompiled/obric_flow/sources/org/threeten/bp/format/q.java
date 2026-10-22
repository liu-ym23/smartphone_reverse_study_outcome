package org.threeten.bp.format;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile AbstractMap.SimpleImmutableEntry f21235c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.threeten.bp.temporal.i f21236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21237b;

    public q(org.threeten.bp.temporal.i r5, String r10) {
        this.f21236a = r5;
        this.f21237b = r10;
    }

    public static ZoneId a(String r5, Set r10, boolean r11) {
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r11 == true) goto L7;
        Iterator r12 = r10.iterator();
    L12:
        if (r12.hasNext() == false) goto L17;
        String r13 = (String) r12.next();
        if (r13.equalsIgnoreCase(r5) == false) goto L12;
        return ZoneId.of(r13);
    L17:
        return null;
    L7:
        if (r10.contains(r5) == true) goto L9;
        return null;
    L9:
        return ZoneId.of(r5);
    }

    public static int b(u r5, CharSequence r10, int r11, int r12) {
        String r13 = r10.subSequence(r11, r12).toString().toUpperCase();
        u r14 = new u(r5);
        if (r12 < r10.length()) goto L5;
    L8:
        int r15 = k.d.parse(r14, r10, r12);
        if (r15 >= 0) goto L12;
        r5.d(ZoneId.ofOffset(r13, ZoneOffset.UTC));
        return r12;
    L12:
        r5.d(ZoneId.ofOffset(r13, ZoneOffset.ofTotalSeconds((int) r14.c(ChronoField.OFFSET_SECONDS).longValue())));
        return r15;
    L5:
        if (r5.a(r10.charAt(r12), 'Z') == false) goto L8;
        r5.d(ZoneId.ofOffset(r13, ZoneOffset.UTC));
        return r12;
    }

    @Override // org.threeten.bp.format.g
    public final int parse(u r10, CharSequence r11, int r12) {
        int r5 = r11.length();
        if (r12 > r5) goto L85;
        if (r12 == r5) goto L6;
        char r13 = r11.charAt(r12);
        if (r13 != '+') goto L10;
    L79:
        u r14 = new u(r10);
        int r15 = k.d.parse(r14, r11, r12);
        if (r15 >= 0) goto L82;
        return r15;
    L82:
        r10.d(ZoneOffset.ofTotalSeconds((int) r14.c(ChronoField.OFFSET_SECONDS).longValue()));
        return r15;
    L10:
        if (r13 == '-') goto L79;
        int r16 = r12 + 2;
        if (r5 < r16) goto L36;
        char r17 = r11.charAt(r12 + 1);
        if (r10.a(r13, 'U') == false) goto L27;
        if (r10.a(r17, 'T') == false) goto L27;
        int r18 = r12 + 3;
        if (r5 < r18) goto L25;
        if (r10.a(r11.charAt(r16), 'C') == false) goto L25;
        return b(r10, r11, r12, r18);
    L25:
        return b(r10, r11, r12, r16);
    L27:
        if (r10.a(r13, 'G') == false) goto L36;
        int r19 = r12 + 3;
        if (r5 < r19) goto L36;
        if (r10.a(r17, 'M') == false) goto L36;
        if (r10.a(r11.charAt(r16), 'T') == false) goto L36;
        return b(r10, r11, r12, r19);
    L36:
        Set r20 = Collections.unmodifiableSet(org.threeten.bp.zone.b.e.keySet());
        int r21 = r20.size();
        AbstractMap.SimpleImmutableEntry r22 = f21235c;
        if (r22 != null) goto L39;
    L40:
        monitor-enter(this);
        r22 = f21235c;     // Catch: Throwable -> L46
        if (r22 != null) goto L44;
    L48:
        Integer r23 = Integer.valueOf(r21);     // Catch: Throwable -> L46
        ArrayList r24 = new ArrayList(r20);     // Catch: Throwable -> L46
        Collections.sort(r24, s.f21243j);     // Catch: Throwable -> L46
        p r25 = new p(((String) r24.get(0)).length());     // Catch: Throwable -> L46
        Iterator r26 = r24.iterator();     // Catch: Throwable -> L46
    L50:
        if (r26.hasNext() == false) goto L52;
        r25.a((String) r26.next());     // Catch: Throwable -> L46
        goto L50
    L52:
        r22 = new AbstractMap.SimpleImmutableEntry(r23, r25);     // Catch: Throwable -> L46
        f21235c = r22;     // Catch: Throwable -> L46
    L53:
        monitor-exit(this);     // Catch: Throwable -> L46
    L54:
        p r27 = (p) r22.getValue();
        String r28 = null;
        String r29 = null;
    L55:
        if (r27 == null) goto L64;
        int r30 = r27.f21232a + r12;
        if (r30 > r5) goto L64;
        String r31 = r11.subSequence(r12, r30).toString();
        if (r10.d == false) goto L62;
        Object r32 = r27.f21233b.get(r31);
    L63:
        r27 = (p) r32;
        r29 = r28;
        r28 = r31;
        goto L55
    L62:
        r32 = r27.f21234c.get(r31.toString().toLowerCase(Locale.ENGLISH));
    L64:
        ZoneId r33 = a(r28, r20, r10.d);
        if (r33 != null) goto L75;
        r33 = a(r29, r20, r10.d);
        if (r33 == null) goto L69;
        r28 = r29;
        goto L75
    L69:
        if (r10.a(r13, 'Z') == false) goto L73;
        r10.d(ZoneOffset.UTC);
        return r12 + 1;
    L73:
        return ~r12;
    L75:
        r10.d(r33);
        return r28.length() + r12;
    L44:
        if (((Integer) r22.getKey()).intValue() == r21) goto L53;
    L46:
        th = move-exception;
        throw th;
    L39:
        if (((Integer) r22.getKey()).intValue() == r21) goto L54;
    L6:
        return ~r12;
    L85:
        throw new IndexOutOfBoundsException();
    }

    @Override // org.threeten.bp.format.g
    public final boolean print(w r5, StringBuilder r10) {
        ZoneId r11 = (ZoneId) r5.b(this.f21236a);
        if (r11 != null) goto L6;
        return false;
    L6:
        r10.append(r11.getId());
        return true;
    }

    public final String toString() {
        return this.f21237b;
    }
}
