package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static i0.c<String, String> a(Long r8, Long r10) {
        if (r8 != null) goto L6;
        if (r10 != null) goto L6;
        return new i0.c(null, null);
    L6:
        if (r8 != null) goto L9;
        i0.c<String, String> r11 = new i0.c(null, b(r10.longValue()));
    L21:
        return r11;
    L9:
        if (r10 != null) goto L11;
        r11 = new i0.c(b(r8.longValue()), null);
        goto L21
    L11:
        Calendar r12 = g0.f();
        Calendar r13 = g0.g(null);
        r13.setTimeInMillis(r8.longValue());
        Calendar r14 = g0.g(null);
        r14.setTimeInMillis(r10.longValue());
        if (r13.get(1) == r14.get(1)) goto L14;
        i0.c<String, String> r15 = new i0.c(d(r8.longValue(), Locale.getDefault()), d(r10.longValue(), Locale.getDefault()));
    L19:
        return r15;
    L14:
        if (r13.get(1) != r12.get(1)) goto L16;
        r15 = new i0.c(c(r8.longValue(), Locale.getDefault()), c(r10.longValue(), Locale.getDefault()));
        goto L19
    L16:
        r15 = new i0.c(c(r8.longValue(), Locale.getDefault()), d(r10.longValue(), Locale.getDefault()));
        goto L19
    }

    public static String b(long r8) {
        Calendar r10 = g0.f();
        Calendar r11 = g0.g(null);
        r11.setTimeInMillis(r8);
        boolean r12 = true;
        if (r10.get(1) == r11.get(1)) goto L6;
        r12 = false;
    L6:
        if (r12 == false) goto L10;
        return c(r8, Locale.getDefault());
    L10:
        return d(r8, Locale.getDefault());
    }

    public static String c(long r8, Locale r10) {
        return g0.b("MMMd", r10).format(new Date(r8));
    }

    public static String d(long r8, Locale r10) {
        return g0.b("yMMMd", r10).format(new Date(r8));
    }
}
