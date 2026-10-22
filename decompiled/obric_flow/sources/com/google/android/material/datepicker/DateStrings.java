package com.google.android.material.datepicker;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class DateStrings {
    private DateStrings() {
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long r5, @Nullable Long r10) {
        return getDateRangeString(r5, r10, null);
    }

    public static String getDateString(long r5) {
        return getDateString(r5, null);
    }

    public static String getDayContentDescription(Context r5, long r10, boolean r11, boolean r12, boolean r13) {
        String r14 = getOptionalYearMonthDayOfWeekDay(r10);
        if (r11 == false) goto L5;
        r14 = String.format(r5.getString(R.string.mtrl_picker_today_description), new Object[]{r14});
    L5:
        if (r12 == true) goto L7;
        if (r13 == true) goto L10;
        return r14;
    L10:
        return String.format(r5.getString(R.string.mtrl_picker_end_date_description), new Object[]{r14});
    L7:
        return String.format(r5.getString(R.string.mtrl_picker_start_date_description), new Object[]{r14});
    }

    public static String getMonthDay(long r5) {
        return getMonthDay(r5, Locale.getDefault());
    }

    public static String getMonthDayOfWeekDay(long r5) {
        return getMonthDayOfWeekDay(r5, Locale.getDefault());
    }

    public static String getOptionalYearMonthDayOfWeekDay(long r5) {
        if (isDateWithinCurrentYear(r5) == false) goto L7;
        return getMonthDayOfWeekDay(r5);
    L7:
        return getYearMonthDayOfWeekDay(r5);
    }

    public static String getYearContentDescription(Context r5, int r10) {
        if (UtcDates.getTodayCalendar().get(1) != r10) goto L7;
        return String.format(r5.getString(R.string.mtrl_picker_navigate_to_current_year_description), new Object[]{Integer.valueOf(r10)});
    L7:
        return String.format(r5.getString(R.string.mtrl_picker_navigate_to_year_description), new Object[]{Integer.valueOf(r10)});
    }

    public static String getYearMonth(long r5) {
        return UtcDates.getYearMonthFormat(Locale.getDefault()).format(new Date(r5));
    }

    public static String getYearMonthDay(long r5) {
        return getYearMonthDay(r5, Locale.getDefault());
    }

    public static String getYearMonthDayOfWeekDay(long r5) {
        return getYearMonthDayOfWeekDay(r5, Locale.getDefault());
    }

    private static boolean isDateWithinCurrentYear(long r5) {
        Calendar r10 = UtcDates.getTodayCalendar();
        Calendar r11 = UtcDates.getUtcCalendar();
        r11.setTimeInMillis(r5);
        if (r10.get(1) == r11.get(1)) goto L7;
        return false;
    L7:
        return true;
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long r5, @Nullable Long r10, @Nullable SimpleDateFormat r11) {
        if (r5 != null) goto L7;
        if (r10 != null) goto L7;
        return Pair.create(null, null);
    L7:
        if (r5 == null) goto L9;
        if (r10 == null) goto L12;
        Calendar r12 = UtcDates.getTodayCalendar();
        Calendar r13 = UtcDates.getUtcCalendar();
        r13.setTimeInMillis(r5.longValue());
        Calendar r14 = UtcDates.getUtcCalendar();
        r14.setTimeInMillis(r10.longValue());
        if (r11 == null) goto L18;
        Date r15 = new Date(r5.longValue());
        Date r16 = new Date(r10.longValue());
        return Pair.create(r11.format(r15), r11.format(r16));
    L18:
        if (r13.get(1) != r14.get(1)) goto L26;
        if (r13.get(1) != r12.get(1)) goto L24;
        return Pair.create(getMonthDay(r5.longValue(), Locale.getDefault()), getMonthDay(r10.longValue(), Locale.getDefault()));
    L24:
        return Pair.create(getMonthDay(r5.longValue(), Locale.getDefault()), getYearMonthDay(r10.longValue(), Locale.getDefault()));
    L26:
        return Pair.create(getYearMonthDay(r5.longValue(), Locale.getDefault()), getYearMonthDay(r10.longValue(), Locale.getDefault()));
    L12:
        return Pair.create(getDateString(r5.longValue(), r11), null);
    L9:
        return Pair.create(null, getDateString(r10.longValue(), r11));
    }

    public static String getDateString(long r5, @Nullable SimpleDateFormat r10) {
        if (r10 == null) goto L6;
        return r10.format(new Date(r5));
    L6:
        if (isDateWithinCurrentYear(r5) == false) goto L10;
        return getMonthDay(r5);
    L10:
        return getYearMonthDay(r5);
    }

    public static String getMonthDay(long r5, Locale r10) {
        return UtcDates.getAbbrMonthDayFormat(r10).format(new Date(r5));
    }

    public static String getMonthDayOfWeekDay(long r5, Locale r10) {
        return UtcDates.getMonthWeekdayDayFormat(r10).format(new Date(r5));
    }

    public static String getYearMonthDay(long r5, Locale r10) {
        return UtcDates.getYearAbbrMonthDayFormat(r10).format(new Date(r5));
    }

    public static String getYearMonthDayOfWeekDay(long r5, Locale r10) {
        return UtcDates.getYearMonthWeekdayDayFormat(r10).format(new Date(r5));
    }
}
