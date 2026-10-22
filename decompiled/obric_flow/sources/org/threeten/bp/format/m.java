package org.threeten.bp.format;

import java.util.ArrayList;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.chrono.IsoChronology;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final LocalDate f21226h = null;
    public final LocalDate g;

    static {
        f21226h = LocalDate.of(2000, 1, 1);
    }

    public m(org.threeten.bp.temporal.g r5, LocalDate r10) {
        super(r5, 2, 2, SignStyle.NOT_NEGATIVE);
        if (r10 != null) goto L13;
        long r11 = 0;
        if (r5.range().isValidValue(r11) == false) goto L12;
        if ((r11 + ((long) j.f[2])) <= 2147483647L) goto L13;
        throw new DateTimeException("Unable to add printer-parser as the range exceeds the capacity of an int");
    L12:
        throw new IllegalArgumentException("The base value must be within the range of the field");
    L13:
        this.g = r10;
    }

    @Override // org.threeten.bp.format.j
    public final long a(w r10, long r11) {
        long r5 = Math.abs(r11);
        LocalDate r12 = this.g;
        if (r12 == null) goto L5;
        int r13 = org.threeten.bp.chrono.i.from(r10.f21256a).date(r12).get(this.f21217a);
    L6:
        long r14 = r13;
        int[] r15 = j.f;
        if (r11 < r14) goto L13;
        int r16 = r15[this.f21218b];
        if (r11 >= (r13 + r16)) goto L13;
        return r5 % ((long) r16);
    L13:
        return r5 % ((long) r15[this.f21219c]);
    L5:
        r13 = 0;
        goto L6
    }

    @Override // org.threeten.bp.format.j
    public final boolean b(u r5) {
        if (r5.e == true) goto L7;
        return false;
    L7:
        return super.b(r5);
    }

    @Override // org.threeten.bp.format.j
    public final int c(u r10, long r11, int r12, int r13) {
        LocalDate r5 = this.g;
        if (r5 == null) goto L13;
        org.threeten.bp.chrono.i r14 = r10.b().f21247a;
        if (r14 != null) goto L9;
        r14 = r10.f21252c;
        if (r14 != null) goto L9;
        r14 = IsoChronology.INSTANCE;
    L9:
        int r15 = r14.date(r5).get(this.f21217a);
        t r16 = r10.b();
        if (r16.f != null) goto L12;
        r16.f = new ArrayList(2);
    L12:
        r16.f.add(new Object[]{this, Long.valueOf(r11), Integer.valueOf(r12), Integer.valueOf(r13)});
    L14:
        int r17 = r13 - r12;
        int r18 = this.f21218b;
        if (r17 != r18) goto L27;
        if (r11 < 0) goto L27;
        long r19 = j.f[r18];
        long r20 = r15;
        long r21 = r20 - (r20 % r19);
        if (r15 <= 0) goto L22;
        long r22 = r21 + r11;
    L21:
        r11 = r22;
        if (r11 >= r20) goto L27;
        r11 = r11 + r19;
        goto L27
    L22:
        r22 = r21 - r11;
    L27:
        return r10.e(this.f21217a, r11, r12, r13);
    L13:
        r15 = 0;
        goto L14
    }

    @Override // org.threeten.bp.format.j
    public final j d() {
        if (this.e != (-1)) goto L5;
        return this;
    L5:
        int r5 = this.f21218b;
        int r10 = this.f21219c;
        return new m(this.f21217a, r5, r10, this.g, -1);
    }

    @Override // org.threeten.bp.format.j
    public final j e(int r10) {
        int r5 = this.e + r10;
        int r11 = this.f21218b;
        int r12 = this.f21219c;
        return new m(this.f21217a, r11, r12, this.g, r5);
    }

    @Override // org.threeten.bp.format.j
    public final String toString() {
        StringBuilder r5 = new StringBuilder("ReducedValue(");
        r5.append(this.f21217a);
        r5.append(",");
        r5.append(this.f21218b);
        r5.append(",");
        r5.append(this.f21219c);
        r5.append(",");
        Object r10 = this.g;
        if (r10 != null) goto L6;
        r10 = 0;
    L6:
        r5.append(r10);
        r5.append(")");
        return r5.toString();
    }

    public m(org.threeten.bp.temporal.g r10, int r11, int r12, LocalDate r13, int r14) {
        super(r10, r11, r12, SignStyle.NOT_NEGATIVE, r14);
        this.g = r13;
    }
}
