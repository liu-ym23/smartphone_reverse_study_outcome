package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import com.obric.cae.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<f0> f4678a = null;

    static {
        f4678a = new AtomicReference();
    }

    public static long a(long r8) {
        Calendar r10 = g(null);
        r10.setTimeInMillis(r8);
        return c(r10).getTimeInMillis();
    }

    @TargetApi(24)
    public static DateFormat b(String r8, Locale r10) {
        DateFormat r11 = DateFormat.getInstanceForSkeleton(r8, r10);
        r11.setTimeZone(TimeZone.getTimeZone("UTC"));
        r11.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return r11;
    }

    public static Calendar c(Calendar r8) {
        Calendar r10 = g(r8);
        Calendar r11 = g(null);
        r11.set(r10.get(1), r10.get(2), r10.get(5));
        return r11;
    }

    public static SimpleDateFormat d() {
        SimpleDateFormat r8 = new SimpleDateFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern().replaceAll("[^dMy/\\-.]", "").replaceAll("d{1,2}", "dd").replaceAll("M{1,2}", "MM").replaceAll("y{1,4}", "yyyy").replaceAll("\\.$", "").replaceAll("My", "M/y"), Locale.getDefault());
        r8.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        r8.setLenient(false);
        return r8;
    }

    public static String e(Resources r8, SimpleDateFormat r10) {
        String r11 = r10.toPattern();
        String r12 = r8.getString(R.string.mtrl_picker_text_input_year_abbr);
        String r13 = r8.getString(R.string.mtrl_picker_text_input_month_abbr);
        String r14 = r8.getString(R.string.mtrl_picker_text_input_day_abbr);
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) == false) goto L6;
        r11 = r11.replaceAll("d+", "d").replaceAll("M+", "M").replaceAll("y+", "y");
    L6:
        return r11.replace("d", r14).replace("M", r13).replace("y", r12);
    }

    public static Calendar f() {
        f0 r8 = f4678a.get();
        if (r8 != null) goto L5;
        r8 = f0.f4672c;
    L5:
        java.util.TimeZone r10 = r8.f4674b;
        if (r10 != null) goto L8;
        Calendar r11 = Calendar.getInstance();
    L9:
        Long r12 = r8.f4673a;
        if (r12 == null) goto L12;
        r11.setTimeInMillis(r12.longValue());
    L12:
        r11.set(11, 0);
        r11.set(12, 0);
        r11.set(13, 0);
        r11.set(14, 0);
        r11.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return r11;
    L8:
        r11 = Calendar.getInstance(r10);
        goto L9
    }

    public static Calendar g(Calendar r8) {
        Calendar r10 = Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));
        if (r8 != null) goto L5;
        r10.clear();
    L6:
        return r10;
    L5:
        r10.setTimeInMillis(r8.getTimeInMillis());
        goto L6
    }
}
