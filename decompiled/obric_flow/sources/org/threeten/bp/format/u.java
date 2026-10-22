package org.threeten.bp.format;

import java.util.ArrayList;
import java.util.Locale;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Locale f21250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f21251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IsoChronology f21252c;
    public boolean d;
    public boolean e;
    public final ArrayList f;

    public u(b r5) {
        this.d = true;
        this.e = true;
        ArrayList r10 = new ArrayList();
        this.f = r10;
        this.f21250a = r5.f21205b;
        this.f21251b = r5.f21206c;
        this.f21252c = r5.e;
        r10.add(new t(this));
    }

    public final boolean a(char r5, char r10) {
        if (this.d == false) goto L7;
        if (r5 == r10) goto L6;
        return false;
    L6:
        return true;
    L7:
        if (r5 == r10) goto L13;
        if (Character.toUpperCase(r5) == Character.toUpperCase(r10)) goto L13;
        if (Character.toLowerCase(r5) == Character.toLowerCase(r10)) goto L13;
        return false;
    L13:
        return true;
    }

    public final t b() {
        return (t) androidx.constraintlayout.motion.widget.a.h(this.f, 1);
    }

    public final Long c(ChronoField r5) {
        return (Long) b().f21249c.get(r5);
    }

    public final void d(ZoneId r5) {
        jm.c.p(r5, "zone");
        b().f21248b = r5;
    }

    public final int e(org.threeten.bp.temporal.g r5, long r10, int r11, int r12) {
        jm.c.p(r5, "field");
        Long r13 = (Long) b().f21249c.put(r5, Long.valueOf(r10));
        if (r13 != null) goto L5;
        return r12;
    L5:
        if (r13.longValue() != r10) goto L7;
        return r12;
    L7:
        return ~r11;
    }

    public final boolean f(CharSequence r10, int r11, CharSequence r12, int r13, int r14) {
        if ((r11 + r14) <= r10.length()) goto L5;
    L27:
        return false;
    L5:
        if ((r13 + r14) > r12.length()) goto L27;
        if (this.d == false) goto L15;
        int r5 = 0;
    L10:
        if (r5 >= r14) goto L25;
        if (r10.charAt(r11 + r5) != r12.charAt(r13 + r5)) goto L13;
        r5 = r5 + 1;
        goto L10
    L13:
        return false;
    L25:
        return true;
    L15:
        int r15 = 0;
    L16:
        if (r15 >= r14) goto L35;
        char r16 = r10.charAt(r11 + r15);
        char r17 = r12.charAt(r13 + r15);
        if (r16 == r17) goto L24;
        if (Character.toUpperCase(r16) == Character.toUpperCase(r17)) goto L24;
        if (Character.toLowerCase(r16) == Character.toLowerCase(r17)) goto L24;
        return false;
    L24:
        r15 = r15 + 1;
        goto L16
    L35:
        return true;
    }

    public final String toString() {
        return b().toString();
    }

    public u(u r5) {
        this.d = true;
        this.e = true;
        ArrayList r10 = new ArrayList();
        this.f = r10;
        this.f21250a = r5.f21250a;
        this.f21251b = r5.f21251b;
        this.f21252c = r5.f21252c;
        this.d = r5.d;
        this.e = r5.e;
        r10.add(new t(this));
    }
}
