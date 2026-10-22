package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
class UtcDates {
    static final String UTC = "UTC";
    static AtomicReference<TimeSource> timeSourceRef;

    static {
        timeSourceRef = new AtomicReference();
    }

    private UtcDates() {
    }

    public static long canonicalYearMonthDay(long r5) {
        Calendar r10 = getUtcCalendar();
        r10.setTimeInMillis(r5);
        return getDayCopy(r10).getTimeInMillis();
    }

    private static int findCharactersInDateFormatPattern(@NonNull String r5, @NonNull String r10, int r11, int r12) {
    L2:
        if (r12 < 0) goto L17;
        if (r12 >= r5.length()) goto L17;
        if (r10.indexOf(r5.charAt(r12)) != (-1)) goto L17;
        if (r5.charAt(r12) != '\'') goto L16;
    L9:
        r12 = r12 + r11;
        if (r12 < 0) goto L16;
        if (r12 >= r5.length()) goto L16;
        if (r5.charAt(r12) != '\'') goto L9;
    L16:
        r12 = r12 + r11;
    L17:
        return r12;
    }

    @TargetApi(24)
    public static DateFormat getAbbrMonthDayFormat(Locale r5) {
        return getAndroidFormat("MMMd", r5);
    }

    @TargetApi(24)
    private static DateFormat getAndroidFormat(String r5, Locale r10) {
        DateFormat r11 = DateFormat.getInstanceForSkeleton(r5, r10);
        r11.setTimeZone(getUtcAndroidTimeZone());
        r11.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return r11;
    }

    @NonNull
    public static String getDatePatternAsInputFormat(@NonNull String r5) {
        return r5.replaceAll("[^dMy/\\-.]", "").replaceAll("d{1,2}", "dd").replaceAll("M{1,2}", "MM").replaceAll("y{1,4}", "yyyy").replaceAll("\\.$", "").replaceAll("My", "M/y");
    }

    public static Calendar getDayCopy(Calendar r5) {
        Calendar r10 = getUtcCalendarOf(r5);
        Calendar r11 = getUtcCalendar();
        r11.set(r10.get(1), r10.get(2), r10.get(5));
        return r11;
    }

    public static SimpleDateFormat getDefaultTextInputFormat() {
        SimpleDateFormat r5 = new SimpleDateFormat(getDatePatternAsInputFormat(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern()), Locale.getDefault());
        r5.setTimeZone(getTimeZone());
        r5.setLenient(false);
        return r5;
    }

    public static String getDefaultTextInputHint(Resources r10, SimpleDateFormat r11) {
        String r12 = r11.toPattern();
        String r5 = r10.getString(R.string.mtrl_picker_text_input_year_abbr);
        String r13 = r10.getString(R.string.mtrl_picker_text_input_month_abbr);
        String r14 = r10.getString(R.string.mtrl_picker_text_input_day_abbr);
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage()) == false) goto L6;
        r12 = r12.replaceAll("d+", "d").replaceAll("M+", "M").replaceAll("y+", "y");
    L6:
        return r12.replace("d", r14).replace("M", r13).replace("y", r5);
    }

    private static java.text.DateFormat getFormat(int r5, Locale r10) {
        java.text.DateFormat r11 = java.text.DateFormat.getDateInstance(r5, r10);
        r11.setTimeZone(getTimeZone());
        return r11;
    }

    public static java.text.DateFormat getFullFormat() {
        return getFullFormat(Locale.getDefault());
    }

    public static java.text.DateFormat getMediumFormat() {
        return getMediumFormat(Locale.getDefault());
    }

    public static java.text.DateFormat getMediumNoYear() {
        return getMediumNoYear(Locale.getDefault());
    }

    @TargetApi(24)
    public static DateFormat getMonthWeekdayDayFormat(Locale r5) {
        return getAndroidFormat("MMMMEEEEd", r5);
    }

    public static java.text.DateFormat getNormalizedFormat(@NonNull java.text.DateFormat r5) {
        java.text.DateFormat r10 = (java.text.DateFormat) r5.clone();
        r10.setTimeZone(getTimeZone());
        return r10;
    }

    public static SimpleDateFormat getSimpleFormat(String r5) {
        return getSimpleFormat(r5, Locale.getDefault());
    }

    public static TimeSource getTimeSource() {
        TimeSource r5 = timeSourceRef.get();
        if (r5 == null) goto L5;
        return r5;
    L5:
        return TimeSource.system();
    }

    private static TimeZone getTimeZone() {
        return TimeZone.getTimeZone(UTC);
    }

    public static Calendar getTodayCalendar() {
        Calendar r5 = getTimeSource().now();
        r5.set(11, 0);
        r5.set(12, 0);
        r5.set(13, 0);
        r5.set(14, 0);
        r5.setTimeZone(getTimeZone());
        return r5;
    }

    @TargetApi(24)
    private static android.icu.util.TimeZone getUtcAndroidTimeZone() {
        return android.icu.util.TimeZone.getTimeZone(UTC);
    }

    public static Calendar getUtcCalendar() {
        return getUtcCalendarOf(null);
    }

    public static Calendar getUtcCalendarOf(@Nullable Calendar r5) {
        Calendar r10 = Calendar.getInstance(getTimeZone());
        if (r5 != null) goto L5;
        r10.clear();
    L6:
        return r10;
    L5:
        r10.setTimeInMillis(r5.getTimeInMillis());
        goto L6
    }

    @TargetApi(24)
    public static DateFormat getYearAbbrMonthDayFormat(Locale r5) {
        return getAndroidFormat("yMMMd", r5);
    }

    @TargetApi(24)
    public static DateFormat getYearMonthFormat(Locale r5) {
        return getAndroidFormat("yMMMM", r5);
    }

    @TargetApi(24)
    public static DateFormat getYearMonthWeekdayDayFormat(Locale r5) {
        return getAndroidFormat("yMMMMEEEEd", r5);
    }

    @NonNull
    private static String removeYearFromDateFormatPattern(@NonNull String r5) {
        int r10 = findCharactersInDateFormatPattern(r5, "yY", 1, 0);
        if (r10 < r5.length()) goto L5;
        return r5;
    L5:
        String r11 = "EMd";
        int r12 = findCharactersInDateFormatPattern(r5, "EMd", 1, r10);
        if (r12 >= r5.length()) goto L9;
        r11 = "EMd,";
    L9:
        return r5.replace(r5.substring(findCharactersInDateFormatPattern(r5, r11, -1, r10) + 1, r12), " ").trim();
    }

    public static void setTimeSource(@Nullable TimeSource r5) {
        timeSourceRef.set(r5);
    }

    public static java.text.DateFormat getFullFormat(Locale r5) {
        return getFormat(0, r5);
    }

    public static java.text.DateFormat getMediumFormat(Locale r5) {
        return getFormat(2, r5);
    }

    public static java.text.DateFormat getMediumNoYear(Locale r5) {
        SimpleDateFormat r10 = (SimpleDateFormat) getMediumFormat(r5);
        r10.applyPattern(removeYearFromDateFormatPattern(r10.toPattern()));
        return r10;
    }

    private static SimpleDateFormat getSimpleFormat(String r5, Locale r10) {
        SimpleDateFormat r11 = new SimpleDateFormat(r5, r10);
        r11.setTimeZone(getTimeZone());
        return r11;
    }
}
