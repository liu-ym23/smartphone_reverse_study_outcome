package com.google.android.material.datepicker;

import android.os.Build;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class d {
    static Pair<String, String> a(@Nullable Long r10, @Nullable Long r11) {
        return b(r10, r11, null);
    }

    static Pair<String, String> b(@Nullable Long r10, @Nullable Long r11, @Nullable SimpleDateFormat r12) {
        if (r10 != null) goto L7;
        if (r11 != null) goto L7;
        return Pair.create(null, null);
    L7:
        if (r10 == null) goto L9;
        if (r11 == null) goto L12;
        Calendar r13 = j.o();
        Calendar r14 = j.q();
        r14.setTimeInMillis(r10.longValue());
        Calendar r15 = j.q();
        r15.setTimeInMillis(r11.longValue());
        if (r12 == null) goto L18;
        Date r16 = new Date(r10.longValue());
        Date r17 = new Date(r11.longValue());
        return Pair.create(r12.format(r16), r12.format(r17));
    L18:
        if (r14.get(1) != r15.get(1)) goto L26;
        if (r14.get(1) != r13.get(1)) goto L24;
        return Pair.create(f(r10.longValue(), Locale.getDefault()), f(r11.longValue(), Locale.getDefault()));
    L24:
        return Pair.create(f(r10.longValue(), Locale.getDefault()), k(r11.longValue(), Locale.getDefault()));
    L26:
        return Pair.create(k(r10.longValue(), Locale.getDefault()), k(r11.longValue(), Locale.getDefault()));
    L12:
        return Pair.create(d(r10.longValue(), r12), null);
    L9:
        return Pair.create(null, d(r11.longValue(), r12));
    }

    static String c(long r10) {
        return d(r10, null);
    }

    static String d(long r10, @Nullable SimpleDateFormat r11) {
        Calendar r12 = j.o();
        Calendar r13 = j.q();
        r13.setTimeInMillis(r10);
        if (r11 == null) goto L7;
        return r11.format(new Date(r10));
    L7:
        if (r12.get(1) != r13.get(1)) goto L11;
        return e(r10);
    L11:
        return j(r10);
    }

    static String e(long r10) {
        return f(r10, Locale.getDefault());
    }

    static String f(long r10, Locale r11) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return j.c(r11).format(new Date(r10));
    L7:
        return j.j(r11).format(new Date(r10));
    }

    static String g(long r10) {
        return h(r10, Locale.getDefault());
    }

    static String h(long r10, Locale r11) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return j.d(r11).format(new Date(r10));
    L7:
        return j.h(r11).format(new Date(r10));
    }

    static String i(long r10) {
        return DateUtils.formatDateTime(null, r10, 8228);
    }

    static String j(long r10) {
        return k(r10, Locale.getDefault());
    }

    static String k(long r10, Locale r11) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return j.s(r11).format(new Date(r10));
    L7:
        return j.i(r11).format(new Date(r10));
    }

    static String l(long r10) {
        return m(r10, Locale.getDefault());
    }

    static String m(long r10, Locale r11) {
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return j.t(r11).format(new Date(r10));
    L7:
        return j.h(r11).format(new Date(r10));
    }
}
