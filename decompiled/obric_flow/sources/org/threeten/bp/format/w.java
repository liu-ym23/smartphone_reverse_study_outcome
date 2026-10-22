package org.threeten.bp.format;

import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.threeten.bp.temporal.d f21256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Locale f21257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f21258c;
    public int d;

    public w(org.threeten.bp.temporal.d r10, b r11) {
        IsoChronology r5 = r11.e;
        if (r5 == null) goto L32;
        org.threeten.bp.chrono.i r12 = (org.threeten.bp.chrono.i) r10.query(org.threeten.bp.temporal.h.f21287b);
        ZoneId r13 = (ZoneId) r10.query(org.threeten.bp.temporal.h.f21286a);
        org.threeten.bp.chrono.b r14 = null;
        if (jm.c.k(r5, r12) == false) goto L8;
        r5 = null;
    L8:
        jm.c.k(null, r13);
        if (r5 == null) goto L32;
        if (r5 == null) goto L13;
        org.threeten.bp.chrono.i r15 = r5;
    L14:
        if (r5 != null) goto L16;
    L31:
        r10 = new v(r14, r10, r15, r13);
        goto L32
    L16:
        if (r10.isSupported(ChronoField.EPOCH_DAY) == false) goto L19;
        r14 = r15.date(r10);
        goto L31
    L19:
        if (r5 != IsoChronology.INSTANCE) goto L21;
        if (r12 == null) goto L31;
    L21:
        ChronoField[] r16 = ChronoField.values();
        int r17 = r16.length;
        int r18 = 0;
    L22:
        if (r18 >= r17) goto L31;
        ChronoField r19 = r16[r18];
        if (r19.isDateBased() == false) goto L30;
        if (r10.isSupported(r19) == false) goto L30;
        throw new DateTimeException("Invalid override chronology for temporal: " + r5 + " " + r10);
    L30:
        r18 = r18 + 1;
        goto L22
    L13:
        r15 = r12;
    L32:
        this.f21256a = r10;
        this.f21257b = r11.f21205b;
        this.f21258c = r11.f21206c;
    }

    public final Long a(org.threeten.bp.temporal.g r5) {
        return Long.valueOf(this.f21256a.getLong(r5));
    L4:
        e = move-exception;
        if (this.d <= 0) goto L9;
        return null;
    L9:
        throw e;
    }

    public final Object b(org.threeten.bp.temporal.i r5) {
        org.threeten.bp.temporal.d r10 = this.f21256a;
        Object r11 = r10.query(r5);
        if (r11 == null) goto L5;
    L9:
        return r11;
    L5:
        if (this.d != 0) goto L9;
        throw new DateTimeException("Unable to extract value: " + r10.getClass());
    }

    public final String toString() {
        return this.f21256a.toString();
    }
}
