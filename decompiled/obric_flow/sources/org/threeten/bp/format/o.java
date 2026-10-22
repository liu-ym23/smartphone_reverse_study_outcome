package org.threeten.bp.format;

import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f21230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f21231b;

    public o(char r5, int r10) {
        this.f21230a = r5;
        this.f21231b = r10;
    }

    public final j a(WeekFields r10) {
        char r5 = this.f21230a;
        if (r5 == 'W') goto L25;
        int r11 = this.f21231b;
        if (r5 != 'Y') goto L7;
        if (r11 == 2) goto L30;
        org.threeten.bp.temporal.g r12 = r10.weekBasedYear();
        int r13 = this.f21231b;
        if (r13 >= 4) goto L22;
        SignStyle r14 = SignStyle.NORMAL;
    L31:
        return new j(r12, r13, 19, r14, -1);
    L22:
        r14 = SignStyle.EXCEEDS_PAD;
        goto L31
    L30:
        return new m(r10.weekBasedYear(), m.f21226h);
    L7:
        if (r5 == 'c') goto L29;
        if (r5 == 'e') goto L28;
        if (r5 == 'w') goto L27;
        return null;
    L27:
        return new j(r10.weekOfWeekBasedYear(), r11, 2, SignStyle.NOT_NEGATIVE);
    L28:
        return new j(r10.dayOfWeek(), r11, 2, SignStyle.NOT_NEGATIVE);
    L29:
        return new j(r10.dayOfWeek(), r11, 2, SignStyle.NOT_NEGATIVE);
    L25:
        return new j(r10.weekOfMonth(), 1, 2, SignStyle.NOT_NEGATIVE);
    }

    @Override // org.threeten.bp.format.g
    public final int parse(u r5, CharSequence r10, int r11) {
        return a(WeekFields.of(r5.f21250a)).parse(r5, r10, r11);
    }

    @Override // org.threeten.bp.format.g
    public final boolean print(w r5, StringBuilder r10) {
        return a(WeekFields.of(r5.f21257b)).print(r5, r10);
    }

    public final String toString() {
        StringBuilder r5 = androidx.constraintlayout.motion.widget.a.x(30, "Localized(");
        int r10 = this.f21231b;
        char r11 = this.f21230a;
        if (r11 != 'Y') goto L16;
        if (r10 != 1) goto L8;
        r5.append("WeekBasedYear");
    L28:
        r5.append(")");
        return r5.toString();
    L8:
        if (r10 != 2) goto L10;
        r5.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
        goto L28
    L10:
        r5.append("WeekBasedYear,");
        r5.append(r10);
        r5.append(",19,");
        if (r10 >= 4) goto L13;
        SignStyle r12 = SignStyle.NORMAL;
    L14:
        r5.append(r12);
        goto L28
    L13:
        r12 = SignStyle.EXCEEDS_PAD;
        goto L14
    L16:
        if (r11 != 'c') goto L18;
    L26:
        r5.append("DayOfWeek");
    L27:
        r5.append(",");
        r5.append(r10);
        goto L28
    L18:
        if (r11 == 'e') goto L26;
        if (r11 != 'w') goto L24;
        r5.append("WeekOfWeekBasedYear");
        goto L27
    L24:
        if (r11 != 'W') goto L27;
        r5.append("WeekOfMonth");
        goto L27
    }
}
