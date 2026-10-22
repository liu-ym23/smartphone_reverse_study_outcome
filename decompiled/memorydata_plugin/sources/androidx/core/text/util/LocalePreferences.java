package androidx.core.text.util;

import android.icu.number.NumberFormatter;
import android.icu.number.UnlocalizedNumberFormatter;
import android.icu.text.DateFormat;
import android.icu.text.DateTimePatternGenerator;
import android.icu.util.Calendar;
import android.icu.util.MeasureUnit;
import android.os.Build;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class LocalePreferences {
    private static final String TAG = "LocalePreferences";
    private static final String[] WEATHER_FAHRENHEIT_COUNTRIES = null;

    /* JADX INFO: renamed from: androidx.core.text.util.LocalePreferences$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$icu$text$DateFormat$HourCycle = null;

        static {
            int[] r0 = new int[DateFormat.HourCycle.values().length];
            $SwitchMap$android$icu$text$DateFormat$HourCycle = r0;
            r0[DateFormat.HourCycle.HOUR_CYCLE_11.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$android$icu$text$DateFormat$HourCycle[DateFormat.HourCycle.HOUR_CYCLE_12.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$android$icu$text$DateFormat$HourCycle[DateFormat.HourCycle.HOUR_CYCLE_23.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$android$icu$text$DateFormat$HourCycle[DateFormat.HourCycle.HOUR_CYCLE_24.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private static class Api24Impl {
        private Api24Impl() {
        }

        static String getCalendarType(Locale r0) {
            return Calendar.getInstance(r0).getType();
        }

        static Locale getDefaultLocale() {
            return Locale.getDefault(Locale.Category.FORMAT);
        }
    }

    private static class Api33Impl {
        private Api33Impl() {
        }

        static String getHourCycle(Locale r0) {
            return getHourCycleType(DateTimePatternGenerator.getInstance(r0).getDefaultHourCycle());
        }

        private static String getHourCycleType(DateFormat.HourCycle r1) {
            int r2 = AnonymousClass1.$SwitchMap$android$icu$text$DateFormat$HourCycle[r1.ordinal()];
            if (r2 != 1) goto L5;
            return HourCycle.H11;
        L5:
            if (r2 != 2) goto L7;
            return HourCycle.H12;
        L7:
            if (r2 != 3) goto L9;
            return HourCycle.H23;
        L9:
            if (r2 == 4) goto L12;
            return "";
        L12:
            return HourCycle.H24;
        }

        static String getResolvedTemperatureUnit(Locale r3) {
            String r4 = ((UnlocalizedNumberFormatter) ZeusTransformUtils.preCheckCast(((UnlocalizedNumberFormatter) ZeusTransformUtils.preCheckCast(NumberFormatter.with().usage("weather"), UnlocalizedNumberFormatter.class, "com.obric.memorydata.plugin")).unit(MeasureUnit.CELSIUS), UnlocalizedNumberFormatter.class, "com.obric.memorydata.plugin")).locale(r3).format(1).getOutputUnit().getIdentifier();
            if (r4.startsWith(TemperatureUnit.FAHRENHEIT) == false) goto L5;
            return TemperatureUnit.FAHRENHEIT;
        L5:
            return r4;
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

    private static String getBaseFirstDayOfWeek(Locale r0) {
        return getStringOfFirstDayOfWeek(java.util.Calendar.getInstance(r0).getFirstDayOfWeek());
    }

    private static String getBaseHourCycle(Locale r1) {
        if (android.text.format.DateFormat.getBestDateTimePattern(r1, "jm").contains(i.n) == false) goto L5;
        return HourCycle.H23;
    L5:
        return HourCycle.H12;
    }

    public static String getCalendarType() {
        return getCalendarType(true);
    }

    public static String getCalendarType(Locale r1) {
        return getCalendarType(r1, true);
    }

    public static String getCalendarType(Locale r3, boolean r4) {
        String r0 = getUnicodeLocaleType("ca", "", r3, r4);
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (Build.VERSION.SDK_INT >= 24) goto L8;
        if (r4 == false) goto L12;
        return CalendarType.GREGORIAN;
    L12:
        return "";
    L8:
        return Api24Impl.getCalendarType(r3);
    }

    public static String getCalendarType(boolean r2) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Locale r0 = Api24Impl.getDefaultLocale();
    L7:
        return getCalendarType(r0, r2);
    L5:
        r0 = getDefaultLocale();
        goto L7
    }

    private static Locale getDefaultLocale() {
        return Locale.getDefault();
    }

    public static String getFirstDayOfWeek() {
        return getFirstDayOfWeek(true);
    }

    public static String getFirstDayOfWeek(Locale r1) {
        return getFirstDayOfWeek(r1, true);
    }

    public static String getFirstDayOfWeek(Locale r2, boolean r3) {
        String r4 = getUnicodeLocaleType("fw", "", r2, r3);
        if (r4 == null) goto L6;
        return r4;
    L6:
        return getBaseFirstDayOfWeek(r2);
    }

    public static String getFirstDayOfWeek(boolean r2) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Locale r0 = Api24Impl.getDefaultLocale();
    L7:
        return getFirstDayOfWeek(r0, r2);
    L5:
        r0 = getDefaultLocale();
        goto L7
    }

    public static String getHourCycle() {
        return getHourCycle(true);
    }

    public static String getHourCycle(Locale r1) {
        return getHourCycle(r1, true);
    }

    public static String getHourCycle(Locale r2, boolean r3) {
        String r4 = getUnicodeLocaleType("hc", "", r2, r3);
        if (r4 == null) goto L6;
        return r4;
    L6:
        if (Build.VERSION.SDK_INT < 33) goto L10;
        return Api33Impl.getHourCycle(r2);
    L10:
        return getBaseHourCycle(r2);
    }

    public static String getHourCycle(boolean r2) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Locale r0 = Api24Impl.getDefaultLocale();
    L7:
        return getHourCycle(r0, r2);
    L5:
        r0 = getDefaultLocale();
        goto L7
    }

    private static String getStringOfFirstDayOfWeek(int r7) {
        String[] r0 = {FirstDayOfWeek.SUNDAY, FirstDayOfWeek.MONDAY, FirstDayOfWeek.TUESDAY, FirstDayOfWeek.WEDNESDAY, FirstDayOfWeek.THURSDAY, FirstDayOfWeek.FRIDAY, FirstDayOfWeek.SATURDAY};
        if (r7 >= 1) goto L5;
    L7:
        return "";
    L5:
        if (r7 > 7) goto L7;
        return r0[r7 - 1];
    }

    private static String getTemperatureHardCoded(Locale r1) {
        if (Arrays.binarySearch(WEATHER_FAHRENHEIT_COUNTRIES, r1.getCountry()) < 0) goto L5;
        return TemperatureUnit.FAHRENHEIT;
    L5:
        return TemperatureUnit.CELSIUS;
    }

    public static String getTemperatureUnit() {
        return getTemperatureUnit(true);
    }

    public static String getTemperatureUnit(Locale r1) {
        return getTemperatureUnit(r1, true);
    }

    public static String getTemperatureUnit(Locale r2, boolean r3) {
        String r4 = getUnicodeLocaleType("mu", "", r2, r3);
        if (r4 == null) goto L6;
        return r4;
    L6:
        if (Build.VERSION.SDK_INT < 33) goto L10;
        return Api33Impl.getResolvedTemperatureUnit(r2);
    L10:
        return getTemperatureHardCoded(r2);
    }

    public static String getTemperatureUnit(boolean r2) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        Locale r0 = Api24Impl.getDefaultLocale();
    L7:
        return getTemperatureUnit(r0, r2);
    L5:
        r0 = getDefaultLocale();
        goto L7
    }

    private static String getUnicodeLocaleType(String r0, String r1, Locale r2, boolean r3) {
        String r4 = r2.getUnicodeLocaleType(r0);
        if (r4 == null) goto L5;
        return r4;
    L5:
        if (r3 == true) goto L7;
        return r1;
    L7:
        return null;
    }
}
