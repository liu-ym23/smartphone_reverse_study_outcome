package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.icu.text.DateFormat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static AtomicReference<i> f3895a;

    static {
        f3895a = new AtomicReference();
    }

    private static int a(String r2, String r3, int r4, int r5) {
    L2:
        if (r5 < 0) goto L17;
        if (r5 >= r2.length()) goto L17;
        if (r3.indexOf(r2.charAt(r5)) != (-1)) goto L17;
        if (r2.charAt(r5) != '\'') goto L16;
    L9:
        r5 = r5 + r4;
        if (r5 < 0) goto L16;
        if (r5 >= r2.length()) goto L16;
        if (r2.charAt(r5) != '\'') goto L9;
    L16:
        r5 = r5 + r4;
    L17:
        return r5;
    }

    static long a(long r1) {
        Calendar r0 = c();
        r0.setTimeInMillis(r1);
        return b(r0).getTimeInMillis();
    }

    private static DateFormat a(String r0, Locale r1) {
        DateFormat r2 = DateFormat.getInstanceForSkeleton(r0, r1);
        r2.setTimeZone(f());
        return r2;
    }

    static DateFormat a(Locale r1) {
        return a("yMMMd", r1);
    }

    static i a() {
        i r0 = (i) ZeusTransformUtils.preCheckCast(f3895a.get(), i.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return i.a();
    }

    static String a(Resources r5, SimpleDateFormat r6) {
        String r7 = r6.toPattern();
        String r0 = r5.getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_text_input_year_abbr, TypedValues.Custom.S_STRING, "mtrl_picker_text_input_year_abbr"));
        String r2 = r5.getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_text_input_month_abbr, TypedValues.Custom.S_STRING, "mtrl_picker_text_input_month_abbr"));
        String r8 = r5.getString(ZeusTransformUtils.mapRes(R.string.mtrl_picker_text_input_day_abbr, TypedValues.Custom.S_STRING, "mtrl_picker_text_input_day_abbr"));
        if (r7.replaceAll("[^y]", "").length() != 1) goto L6;
        r7 = r7.replace("y", "yyyy");
    L6:
        return r7.replace("d", r8).replace("M", r2).replace("y", r0);
    }

    private static String a(String r5) {
        int r0 = a(r5, "yY", 1, 0);
        if (r0 < r5.length()) goto L5;
        return r5;
    L5:
        String r2 = "EMd";
        int r3 = a(r5, "EMd", 1, r0);
        if (r3 >= r5.length()) goto L9;
        r2 = "EMd,";
    L9:
        return r5.replace(r5.substring(a(r5, r2, -1, r0) + 1, r3), " ").trim();
    }

    private static java.text.DateFormat a(int r0, Locale r1) {
        java.text.DateFormat r2 = java.text.DateFormat.getDateInstance(r0, r1);
        r2.setTimeZone(e());
        return r2;
    }

    static Calendar a(Calendar r3) {
        Calendar r0 = Calendar.getInstance(e());
        if (r3 != null) goto L5;
        r0.clear();
    L6:
        return r0;
    L5:
        r0.setTimeInMillis(r3.getTimeInMillis());
        goto L6
    }

    static DateFormat b(Locale r1) {
        return a("MMMd", r1);
    }

    static Calendar b() {
        Calendar r0 = a().b();
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        r0.setTimeZone(e());
        return r0;
    }

    static Calendar b(Calendar r4) {
        Calendar r5 = a(r4);
        Calendar r0 = c();
        r0.set(r5.get(1), r5.get(2), r5.get(5));
        return r0;
    }

    static DateFormat c(Locale r1) {
        return a("MMMEd", r1);
    }

    static Calendar c() {
        return a(null);
    }

    static DateFormat d(Locale r1) {
        return a("yMMMEd", r1);
    }

    static SimpleDateFormat d() {
        SimpleDateFormat r1 = new SimpleDateFormat(((SimpleDateFormat) ZeusTransformUtils.preCheckCast(java.text.DateFormat.getDateInstance(3, Locale.getDefault()), SimpleDateFormat.class, "com.obric.memorydata.plugin")).toPattern().replaceAll("\\s+", ""), Locale.getDefault());
        r1.setTimeZone(e());
        r1.setLenient(false);
        return r1;
    }

    static java.text.DateFormat e(Locale r1) {
        return a(2, r1);
    }

    private static TimeZone e() {
        return TimeZone.getTimeZone("UTC");
    }

    private static android.icu.util.TimeZone f() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    static java.text.DateFormat f(Locale r2) {
        SimpleDateFormat r3 = (SimpleDateFormat) ZeusTransformUtils.preCheckCast(e(r2), SimpleDateFormat.class, "com.obric.memorydata.plugin");
        r3.applyPattern(a(r3.toPattern()));
        return r3;
    }

    static java.text.DateFormat g(Locale r1) {
        return a(0, r1);
    }
}
