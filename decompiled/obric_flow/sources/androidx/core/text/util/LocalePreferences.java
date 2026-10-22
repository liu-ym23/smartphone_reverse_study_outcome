package androidx.core.text.util;

import android.icu.number.NumberFormatter;
import android.icu.number.UnlocalizedNumberFormatter;
import android.icu.text.DateFormat;
import android.icu.text.DateTimePatternGenerator;
import android.icu.util.Calendar;
import android.icu.util.MeasureUnit;
import android.os.Build;
import androidx.activity.e;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class LocalePreferences {
    private static final String TAG = "LocalePreferences";
    private static final String[] WEATHER_FAHRENHEIT_COUNTRIES = null;

    /* JADX INFO: renamed from: androidx.core.text.util.LocalePreferences$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$icu$text$DateFormat$HourCycle = null;

        static {
            int[] r5 = new int[e.w().length];
            $SwitchMap$android$icu$text$DateFormat$HourCycle = r5;
            r5[e.b(e.f())] = 1;     // Catch: NoSuchFieldError -> L8
        L18:
            $SwitchMap$android$icu$text$DateFormat$HourCycle[e.b(e.x())] = 2;     // Catch: NoSuchFieldError -> L9
        L12:
            $SwitchMap$android$icu$text$DateFormat$HourCycle[e.b(e.y())] = 3;     // Catch: NoSuchFieldError -> L10
        L14:
            $SwitchMap$android$icu$text$DateFormat$HourCycle[e.b(e.z())] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static String getCalendarType(@NonNull Locale r5) {
            return Calendar.getInstance(r5).getType();
        }

        @DoNotInline
        public static Locale getDefaultLocale() {
            return Locale.getDefault(Locale.Category.FORMAT);
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static String getHourCycle(@NonNull Locale r5) {
            return getHourCycleType(DateTimePatternGenerator.getInstance(r5).getDefaultHourCycle());
        }

        private static String getHourCycleType(DateFormat.HourCycle r5) {
            int r10 = AnonymousClass1.$SwitchMap$android$icu$text$DateFormat$HourCycle[r5.ordinal()];
            if (r10 != 1) goto L5;
            return HourCycle.H11;
        L5:
            if (r10 != 2) goto L7;
            return HourCycle.H12;
        L7:
            if (r10 != 3) goto L9;
            return HourCycle.H23;
        L9:
            if (r10 == 4) goto L12;
            return "";
        L12:
            return HourCycle.H24;
        }

        @DoNotInline
        public static String getResolvedTemperatureUnit(@NonNull Locale r5) {
            String r10 = ((UnlocalizedNumberFormatter) ((UnlocalizedNumberFormatter) NumberFormatter.with().usage("weather")).unit(MeasureUnit.CELSIUS)).locale(r5).format(1).getOutputUnit().getIdentifier();
            if (r10.startsWith(TemperatureUnit.FAHRENHEIT) == false) goto L5;
            return TemperatureUnit.FAHRENHEIT;
        L5:
            return r10;
        }
    }

    public static class CalendarType {
        public static final String CHINESE = "chinese";
        public static final String DANGI = "dangi";
        public static final String DEFAULT = "";
        public static final String GREGORIAN = "gregorian";
        public static final String HEBREW = "hebrew";
        public static final String INDIAN = "indian";
        public static final String ISLAMIC = "islamic";
        public static final String ISLAMIC_CIVIL = "islamic-civil";
        public static final String ISLAMIC_RGSA = "islamic-rgsa";
        public static final String ISLAMIC_TBLA = "islamic-tbla";
        public static final String ISLAMIC_UMALQURA = "islamic-umalqura";
        public static final String PERSIAN = "persian";
        private static final String U_EXTENSION_TAG = "ca";

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface CalendarTypes {
        }

        private CalendarType() {
        }
    }

    public static class FirstDayOfWeek {
        public static final String DEFAULT = "";
        public static final String FRIDAY = "fri";
        public static final String MONDAY = "mon";
        public static final String SATURDAY = "sat";
        public static final String SUNDAY = "sun";
        public static final String THURSDAY = "thu";
        public static final String TUESDAY = "tue";
        private static final String U_EXTENSION_TAG = "fw";
        public static final String WEDNESDAY = "wed";

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface Days {
        }

        private FirstDayOfWeek() {
        }
    }

    public static class HourCycle {
        public static final String DEFAULT = "";
        public static final String H11 = "h11";
        public static final String H12 = "h12";
        public static final String H23 = "h23";
        public static final String H24 = "h24";
        private static final String U_EXTENSION_TAG = "hc";

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface HourCycleTypes {
        }

        private HourCycle() {
        }
    }

    public static class TemperatureUnit {
        public static final String CELSIUS = "celsius";
        public static final String DEFAULT = "";
        public static final String FAHRENHEIT = "fahrenhe";
        public static final String KELVIN = "kelvin";
        private static final String U_EXTENSION_TAG = "mu";

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public @interface TemperatureUnits {
        }

        private TemperatureUnit() {
        }
    }

    static {
        WEATHER_FAHRENHEIT_COUNTRIES = new String[]{"BS", "BZ", "KY", "PR", "PW", "US"};
    }

    private LocalePreferences() {
    }

    private static String getBaseFirstDayOfWeek(@NonNull Locale r5) {
        return getStringOfFirstDayOfWeek(java.util.Calendar.getInstance(r5).getFirstDayOfWeek());
    }

    private static String getBaseHourCycle(@NonNull Locale r5) {
        if (android.text.format.DateFormat.getBestDateTimePattern(r5, "jm").contains("H") == false) goto L5;
        return HourCycle.H23;
    L5:
        return HourCycle.H12;
    }

    @NonNull
    public static String getCalendarType() {
        return getCalendarType(true);
    }

    private static Locale getDefaultLocale() {
        return Locale.getDefault();
    }

    @NonNull
    public static String getFirstDayOfWeek() {
        return getFirstDayOfWeek(true);
    }

    @NonNull
    public static String getHourCycle() {
        return getHourCycle(true);
    }

    private static String getStringOfFirstDayOfWeek(int r10) {
        String[] r5 = {FirstDayOfWeek.SUNDAY, FirstDayOfWeek.MONDAY, FirstDayOfWeek.TUESDAY, FirstDayOfWeek.WEDNESDAY, FirstDayOfWeek.THURSDAY, FirstDayOfWeek.FRIDAY, FirstDayOfWeek.SATURDAY};
        if (r10 >= 1) goto L5;
    L7:
        return "";
    L5:
        if (r10 > 7) goto L7;
        return r5[r10 - 1];
    }

    private static String getTemperatureHardCoded(Locale r5) {
        if (Arrays.binarySearch(WEATHER_FAHRENHEIT_COUNTRIES, r5.getCountry()) < 0) goto L5;
        return TemperatureUnit.FAHRENHEIT;
    L5:
        return TemperatureUnit.CELSIUS;
    }

    @NonNull
    public static String getTemperatureUnit() {
        return getTemperatureUnit(true);
    }

    private static String getUnicodeLocaleType(String r5, String r10, Locale r11, boolean r12) {
        String r13 = r11.getUnicodeLocaleType(r5);
        if (r13 == null) goto L5;
        return r13;
    L5:
        if (r12 == true) goto L7;
        return r10;
    L7:
        return null;
    }

    @NonNull
    public static String getCalendarType(@NonNull Locale r5) {
        return getCalendarType(r5, true);
    }

    @NonNull
    public static String getFirstDayOfWeek(@NonNull Locale r5) {
        return getFirstDayOfWeek(r5, true);
    }

    @NonNull
    public static String getHourCycle(@NonNull Locale r5) {
        return getHourCycle(r5, true);
    }

    @NonNull
    public static String getTemperatureUnit(@NonNull Locale r5) {
        return getTemperatureUnit(r5, true);
    }

    @NonNull
    public static String getCalendarType(boolean r5) {
        return getCalendarType(Api24Impl.getDefaultLocale(), r5);
    }

    @NonNull
    public static String getFirstDayOfWeek(boolean r5) {
        return getFirstDayOfWeek(Api24Impl.getDefaultLocale(), r5);
    }

    @NonNull
    public static String getHourCycle(boolean r5) {
        return getHourCycle(Api24Impl.getDefaultLocale(), r5);
    }

    @NonNull
    public static String getTemperatureUnit(boolean r5) {
        return getTemperatureUnit(Api24Impl.getDefaultLocale(), r5);
    }

    @NonNull
    public static String getCalendarType(@NonNull Locale r5, boolean r10) {
        String r11 = getUnicodeLocaleType("ca", "", r5, r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return Api24Impl.getCalendarType(r5);
    }

    @NonNull
    public static String getFirstDayOfWeek(@NonNull Locale r5, boolean r10) {
        String r11 = getUnicodeLocaleType("fw", "", r5, r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return getBaseFirstDayOfWeek(r5);
    }

    @NonNull
    public static String getHourCycle(@NonNull Locale r5, boolean r10) {
        String r11 = getUnicodeLocaleType("hc", "", r5, r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        if (Build.VERSION.SDK_INT < 33) goto L10;
        return Api33Impl.getHourCycle(r5);
    L10:
        return getBaseHourCycle(r5);
    }

    @NonNull
    public static String getTemperatureUnit(@NonNull Locale r5, boolean r10) {
        String r11 = getUnicodeLocaleType("mu", "", r5, r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        if (Build.VERSION.SDK_INT < 33) goto L10;
        return Api33Impl.getResolvedTemperatureUnit(r5);
    L10:
        return getTemperatureHardCoded(r5);
    }
}
