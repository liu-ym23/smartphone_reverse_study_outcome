package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static AtomicReference<i> f3232a;

    static {
        f3232a = new AtomicReference();
    }

    static long a(long r10) {
        Calendar r11 = q();
        r11.setTimeInMillis(r10);
        return f(r11).getTimeInMillis();
    }

    private static int b(@NonNull String r10, @NonNull String r11, int r12, int r13) {
    L2:
        if (r13 < 0) goto L17;
        if (r13 >= r10.length()) goto L17;
        if (r11.indexOf(r10.charAt(r13)) != (-1)) goto L17;
        if (r10.charAt(r13) != '\'') goto L16;
    L9:
        r13 = r13 + r12;
        if (r13 < 0) goto L16;
        if (r13 >= r10.length()) goto L16;
        if (r10.charAt(r13) != '\'') goto L9;
    L16:
        r13 = r13 + r12;
    L17:
        return r13;
    }

    @TargetApi(24)
    static DateFormat c(Locale r10) {
        return e("MMMd", r10);
    }

    @TargetApi(24)
    static DateFormat d(Locale r10) {
        return e("MMMEd", r10);
    }

    @TargetApi(24)
    private static DateFormat e(String r10, Locale r11) {
        DateFormat r12 = DateFormat.getInstanceForSkeleton(r10, r11);
        r12.setTimeZone(p());
        return r12;
    }

    static Calendar f(Calendar r10) {
        Calendar r11 = r(r10);
        Calendar r12 = q();
        r12.set(r11.get(1), r11.get(2), r11.get(5));
        return r12;
    }

    private static java.text.DateFormat g(int r10, Locale r11) {
        java.text.DateFormat r12 = java.text.DateFormat.getDateInstance(r10, r11);
        r12.setTimeZone(n());
        return r12;
    }

    static java.text.DateFormat h(Locale r10) {
        return g(0, r10);
    }

    static java.text.DateFormat i(Locale r10) {
        return g(2, r10);
    }

    static java.text.DateFormat j(Locale r10) {
        SimpleDateFormat r11 = (SimpleDateFormat) i(r10);
        r11.applyPattern(u(r11.toPattern()));
        return r11;
    }

    static SimpleDateFormat k() {
        SimpleDateFormat r10 = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern().replaceAll("\\s+", ""), Locale.getDefault());
        r10.setTimeZone(n());
        r10.setLenient(false);
        return r10;
    }

    static String l(Resources r10, SimpleDateFormat r11) {
        String r12 = r11.toPattern();
        String r13 = r10.getString(q5.j.mtrl_picker_text_input_year_abbr);
        String r14 = r10.getString(q5.j.mtrl_picker_text_input_month_abbr);
        String r15 = r10.getString(q5.j.mtrl_picker_text_input_day_abbr);
        if (r12.replaceAll("[^y]", "").length() != 1) goto L6;
        r12 = r12.replace("y", "yyyy");
    L6:
        return r12.replace("d", r15).replace("M", r14).replace("y", r13);
    }

    static i m() {
        i r10 = f3232a.get();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return i.c();
    }

    private static TimeZone n() {
        return TimeZone.getTimeZone("UTC");
    }

    static Calendar o() {
        Calendar r10 = m().a();
        r10.set(11, 0);
        r10.set(12, 0);
        r10.set(13, 0);
        r10.set(14, 0);
        r10.setTimeZone(n());
        return r10;
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone p() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    static Calendar q() {
        return r(null);
    }

    static Calendar r(@Nullable Calendar r10) {
        Calendar r11 = Calendar.getInstance(n());
        if (r10 != null) goto L5;
        r11.clear();
    L6:
        return r11;
    L5:
        r11.setTimeInMillis(r10.getTimeInMillis());
        goto L6
    }

    @TargetApi(24)
    static DateFormat s(Locale r10) {
        return e("yMMMd", r10);
    }

    @TargetApi(24)
    static DateFormat t(Locale r10) {
        return e("yMMMEd", r10);
    }

    @NonNull
    private static String u(@NonNull String r10) {
        int r11 = b(r10, "yY", 1, 0);
        if (r11 < r10.length()) goto L5;
        return r10;
    L5:
        String r12 = "EMd";
        int r13 = b(r10, "EMd", 1, r11);
        if (r13 >= r10.length()) goto L9;
        r12 = "EMd,";
    L9:
        return r10.replace(r10.substring(b(r10, r12, -1, r11) + 1, r13), " ").trim();
    }
}
