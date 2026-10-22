package com.google.android.material.datepicker;

import android.os.Build;
import android.text.format.DateUtils;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class d {
    static Pair<String, String> a(Long r1, Long r2) {
        return a(r1, r2, null);
    }

    static Pair<String, String> a(Long r5, Long r6, SimpleDateFormat r7) {
        if (r5 != null) goto L7;
        if (r6 != null) goto L7;
        return Pair.create(null, null);
    L7:
        if (r5 == null) goto L9;
        if (r6 == null) goto L12;
        Calendar r0 = j.b();
        Calendar r1 = j.c();
        r1.setTimeInMillis(r5.longValue());
        Calendar r2 = j.c();
        r2.setTimeInMillis(r6.longValue());
        if (r7 == null) goto L18;
        Date r3 = new Date(r5.longValue());
        Date r8 = new Date(r6.longValue());
        return Pair.create(r7.format(r3), r7.format(r8));
    L18:
        if (r1.get(1) != r2.get(1)) goto L26;
        if (r1.get(1) != r0.get(1)) goto L24;
        return Pair.create(b(r5.longValue(), Locale.getDefault()), b(r6.longValue(), Locale.getDefault()));
    L24:
        return Pair.create(b(r5.longValue(), Locale.getDefault()), a(r6.longValue(), Locale.getDefault()));
    L26:
        return Pair.create(a(r5.longValue(), Locale.getDefault()), a(r6.longValue(), Locale.getDefault()));
    L12:
        return Pair.create(a(r5.longValue(), r7), null);
    L9:
        return Pair.create(null, a(r6.longValue(), r7));
    }

    static String a(long r2) {
        return DateUtils.formatDateTime(null, r2, 8228);
    }

    static String a(long r2, SimpleDateFormat r4) {
        Calendar r0 = j.b();
        Calendar r1 = j.c();
        r1.setTimeInMillis(r2);
        if (r4 == null) goto L7;
        return r4.format(new Date(r2));
    L7:
        if (r0.get(1) != r1.get(1)) goto L11;
        return c(r2);
    L11:
        return b(r2);
    }

    static String a(long r2, Locale r4) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return j.a(r4).format(new Date(r2));
    L7:
        return j.e(r4).format(new Date(r2));
    }

    static String b(long r1) {
        return a(r1, Locale.getDefault());
    }

    static String b(long r2, Locale r4) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return j.b(r4).format(new Date(r2));
    L7:
        return j.f(r4).format(new Date(r2));
    }

    static String c(long r1) {
        return b(r1, Locale.getDefault());
    }

    static String c(long r2, Locale r4) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return j.c(r4).format(new Date(r2));
    L7:
        return j.g(r4).format(new Date(r2));
    }

    static String d(long r1) {
        return c(r1, Locale.getDefault());
    }

    static String d(long r2, Locale r4) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return j.d(r4).format(new Date(r2));
    L7:
        return j.g(r4).format(new Date(r2));
    }

    static String e(long r1) {
        return d(r1, Locale.getDefault());
    }

    static String f(long r1) {
        return a(r1, null);
    }
}
