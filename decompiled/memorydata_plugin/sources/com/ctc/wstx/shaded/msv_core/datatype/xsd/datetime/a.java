package com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime;

import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
abstract class a {
    a() {
    }

    private void g(Object r3, StringBuffer r4) {
        Calendar r5 = a(r3);
        java.util.TimeZone r0 = r5.getTimeZone();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0 != TimeZone.MISSING) goto L9;
        return;
    L9:
        if (r0 != TimeZone.ZERO) goto L13;
        r4.append('Z');
        return;
    L13:
        if (r0.inDaylightTime(r5.getTime()) == false) goto L19;
        int r6 = r0.getRawOffset();
        if (r0.useDaylightTime() == false) goto L17;
        int r1 = 3600000;
    L18:
        int r7 = r6 + r1;
    L20:
        if (r7 < 0) goto L22;
        r4.append('+');
    L23:
        int r8 = r7 / 60000;
        a(r8 / 60, r4);
        r4.append(':');
        a(r8 % 60, r4);
        return;
    L22:
        r4.append('-');
        r7 = r7 * (-1);
        goto L23
    L17:
        r1 = 0;
        goto L18
    L19:
        r7 = r0.getRawOffset();
        goto L20
    }

    public String a(String r6, Object r7) {
        int r0 = r6.length();
        StringBuffer r1 = new StringBuffer();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L31;
        int r3 = r2 + 1;
        char r4 = r6.charAt(r2);
        if (r4 != '%') goto L6;
        r2 = r3 + 1;
        char r5 = r6.charAt(r3);
        if (r5 != 'D') goto L10;
        c(r7, r1);
        goto L3
    L10:
        if (r5 != 'M') goto L12;
        b(r7, r1);
        goto L3
    L12:
        if (r5 != 'Y') goto L14;
        a(r7, r1);
        goto L3
    L14:
        if (r5 != 'h') goto L16;
        d(r7, r1);
        goto L3
    L16:
        if (r5 != 'm') goto L18;
        e(r7, r1);
        goto L3
    L18:
        if (r5 != 's') goto L20;
        f(r7, r1);
        goto L3
    L20:
        if (r5 != 'z') goto L23;
        g(r7, r1);
        goto L3
    L23:
        throw new InternalError();
    L6:
        r1.append(r4);
        r2 = r3;
        goto L3
    L31:
        return r1.toString();
    }

    public abstract Calendar a(Object r1);

    public final void a(int r1, StringBuffer r2) {
        if (r1 >= 10) goto L5;
        r2.append('0');
    L5:
        r2.append(r1);
    }

    public abstract void a(Object r1, StringBuffer r2);

    public abstract void b(Object r1, StringBuffer r2);

    public abstract void c(Object r1, StringBuffer r2);

    public abstract void d(Object r1, StringBuffer r2);

    public abstract void e(Object r1, StringBuffer r2);

    public abstract void f(Object r1, StringBuffer r2);
}
