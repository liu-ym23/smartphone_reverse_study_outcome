package org.apache.poi.ss.usermodel;

import com.obric.oui.calendar.ODatePickerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.ss.formula.ConditionalFormattingEvaluator;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class DateUtil {
    private static final BigDecimal BD_MILISEC_RND = null;
    private static final BigDecimal BD_NANOSEC_DAY = null;
    private static final BigDecimal BD_SECOND_RND = null;
    private static final Pattern TIME_SEPARATOR_PATTERN = null;
    private static final DateTimeFormatter dateTimeFormats = null;
    private static final Pattern date_ptrn1 = null;
    private static final Pattern date_ptrn2 = null;
    private static final Pattern date_ptrn3a = null;
    private static final Pattern date_ptrn3b = null;
    private static final Pattern date_ptrn4 = null;
    private static final Pattern date_ptrn5 = null;
    private static final ThreadLocal<Boolean> lastCachedResult = null;
    private static final ThreadLocal<Integer> lastFormatIndex = null;
    private static final ThreadLocal<String> lastFormatString = null;

    private static final class FormatException extends Exception {
        public FormatException(String r1) {
            super(r1);
        }
    }

    static {
        BD_NANOSEC_DAY = BigDecimal.valueOf(8.64E13d);
        BD_MILISEC_RND = BigDecimal.valueOf(500000.0d);
        BD_SECOND_RND = BigDecimal.valueOf(5.0E8d);
        TIME_SEPARATOR_PATTERN = Pattern.compile(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        date_ptrn1 = Pattern.compile("^\\[\\$-.*?]");
        date_ptrn2 = Pattern.compile("^\\[[a-zA-Z]+]");
        date_ptrn3a = Pattern.compile("[yYmMdDhHsS]");
        date_ptrn3b = Pattern.compile("^[\\[\\]yYmMdDhHsS\\-T/年月日,. :\"\\\\]+0*[ampAMP/]*$");
        date_ptrn4 = Pattern.compile("^\\[([hH]+|[mM]+|[sS]+)]");
        date_ptrn5 = Pattern.compile("^\\[DBNum([123])]");
        dateTimeFormats = new DateTimeFormatterBuilder().appendPattern("[dd MMM[ yyyy]][[ ]h:m[:s][.SSS] a][[ ]H:m[:s][.SSS]]").appendPattern("[[yyyy ]dd-MMM[-yyyy]][[ ]h:m[:s][.SSS] a][[ ]H:m[:s][.SSS]]").appendPattern("[M/dd[/yyyy]][[ ]h:m[:s][.SSS] a][[ ]H:m[:s][.SSS]]").appendPattern("[[yyyy/]M/dd][[ ]h:m[:s][.SSS] a][[ ]H:m[:s][.SSS]]").parseDefaulting(ChronoField.YEAR_OF_ERA, LocaleUtil.getLocaleCalendar().get(1)).toFormatter(LocaleUtil.getUserLocale());
        lastFormatIndex = ThreadLocal.withInitial($$Lambda$DateUtil$wNP2jCTu1LyR0Z2w9f9vFNTwo.INSTANCE);
        lastFormatString = new ThreadLocal();
        lastCachedResult = new ThreadLocal();
    }

    private static int absoluteDay(int r0, int r1, boolean r2) {
        return r1 + daysInPriorYears(r0, r2);
    }

    private static void cache(String r1, int r2, boolean r3) {
        if (r1 != null) goto L4;
    L7:
        lastFormatString.remove();
    L9:
        if (r2 != (-1)) goto L11;
        lastFormatIndex.remove();
    L12:
        lastCachedResult.set(Boolean.valueOf(r3));
        return;
    L11:
        lastFormatIndex.set(Integer.valueOf(r2));
        goto L12
    L4:
        if ("".equals(r1) == true) goto L7;
        lastFormatString.set(r1);
        goto L9
    }

    static int daysInPriorYears(int r5, boolean r6) {
        int r0 = ODatePickerView.YEAR_FROM;
        if (r6 == true) goto L6;
        if (r5 >= 1900) goto L6;
    L10:
        throw new IllegalArgumentException("'year' must be 1900 or greater");
    L6:
        if (r6 == false) goto L11;
        if (r5 < 1904) goto L10;
    L11:
        int r2 = r5 - 1;
        int r3 = (((r2 / 4) - (r2 / 100)) + (r2 / 400)) - 460;
        if (r6 == false) goto L15;
        r0 = 1904;
    L15:
        return ((r5 - r0) * 365) + r3;
    }

    public static double getExcelDate(LocalDate r2) {
        return getExcelDate(r2, false);
    }

    public static double getExcelDate(LocalDate r7, boolean r8) {
        return internalGetExcelDate(r7.getYear(), r7.getDayOfYear(), 0, 0, 0, 0, r8);
    }

    public static double getExcelDate(Date r2) {
        return getExcelDate(r2, false);
    }

    public static double getExcelDate(Date r8, boolean r9) {
        Calendar r0 = LocaleUtil.getLocaleCalendar();
        r0.setTime(r8);
        return internalGetExcelDate(r0.get(1), r0.get(6), r0.get(11), r0.get(12), r0.get(13), r0.get(14), r9);
    }

    public static Calendar getJavaCalendar(double r2, boolean r4) {
        return getJavaCalendar(r2, r4, null, false);
    }

    public static Calendar getJavaCalendar(double r3, boolean r5, TimeZone r6, boolean r7) {
        if (isValidExcelDate(r3) == true) goto L6;
        return null;
    L6:
        int r0 = (int) Math.floor(r3);
        int r4 = (int) (((r3 - ((double) r0)) * 8.64E7d) + 0.5d);
        if (r6 == null) goto L9;
        Calendar r8 = LocaleUtil.getLocaleCalendar(r6);
    L10:
        setCalendar(r8, r0, r4, r5, r7);
        return r8;
    L9:
        r8 = LocaleUtil.getLocaleCalendar();
        goto L10
    }

    public static Calendar getJavaCalendarUTC(double r2, boolean r4) {
        return getJavaCalendar(r2, r4, LocaleUtil.TIMEZONE_UTC, false);
    }

    public static Date getJavaDate(double r2) {
        return getJavaDate(r2, false, null, false);
    }

    public static Date getJavaDate(double r2, boolean r4) {
        return getJavaDate(r2, r4, null, false);
    }

    public static Date getJavaDate(double r0, boolean r2, TimeZone r3, boolean r4) {
        Calendar r1 = getJavaCalendar(r0, r2, r3, r4);
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.getTime();
    }

    public static LocalDateTime getLocalDateTime(double r1, boolean r3) {
        return getLocalDateTime(r1, r3, false);
    }

    public static LocalDateTime getLocalDateTime(double r4, boolean r6, boolean r7) {
        if (isValidExcelDate(r4) == true) goto L6;
        return null;
    L6:
        BigDecimal r5 = BigDecimal.valueOf(r4);
        int r8 = r5.intValue();
        int r0 = ODatePickerView.YEAR_FROM;
        int r1 = -1;
        if (r6 == false) goto L10;
        r0 = 1904;
        r1 = 1;
    L12:
        LocalDateTime r9 = LocalDateTime.of(r0, 1, 1, 0, 0).plusDays(((long) (r1 + r8)) - 1);
        BigDecimal r10 = r5.subtract(BigDecimal.valueOf(r8)).multiply(BD_NANOSEC_DAY);
        if (r7 == false) goto L15;
        BigDecimal r11 = BD_SECOND_RND;
    L16:
        LocalDateTime r12 = r9.plusNanos(r10.add(r11).longValue());
        if (r7 == false) goto L19;
        ChronoUnit r13 = ChronoUnit.SECONDS;
    L21:
        return r12.truncatedTo(r13);
    L19:
        r13 = ChronoUnit.MILLIS;
        goto L21
    L15:
        r11 = BD_MILISEC_RND;
        goto L16
    L10:
        if (r8 >= 61) goto L12;
        r1 = 0;
        goto L12
    }

    private static double internalGetExcelDate(int r4, int r5, int r6, int r7, int r8, int r9, boolean r10) {
        if (r10 == false) goto L4;
    L5:
        if (r10 == true) goto L7;
    L10:
        double r0 = (((((((((double) r6) * 60.0d) + ((double) r7)) * 60.0d) + ((double) r8)) * 1000.0d) + ((double) r9)) / 8.64E7d) + ((double) absoluteDay(r4, r5, r10));
        if (r10 == false) goto L13;
    L15:
        if (r10 == true) goto L17;
        return r0;
    L17:
        return r0 - 1.0d;
    L13:
        if (r0 < 60.0d) goto L15;
        return r0 + 1.0d;
    L7:
        if (r4 >= 1904) goto L10;
        return -1.0d;
    L4:
        if (r4 >= 1900) goto L5;
        return -1.0d;
    }

    public static boolean isADateFormat(int r10, String r11) {
        if (isInternalDateFormat(r10) == false) goto L7;
        cache(r11, r10, true);
        return true;
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        if (r11.length() != 0) goto L12;
        return false;
    L12:
        if (isCached(r11, r10) == true) goto L14;
        int r2 = r11.length();
        StringBuilder r3 = new StringBuilder(r2);
        int r4 = 0;
    L17:
        if (r4 >= r2) goto L33;
        char r6 = r11.charAt(r4);
        if (r4 >= (r2 - 1)) goto L31;
        int r7 = r4 + 1;
        char r8 = r11.charAt(r7);
        if (r6 == '\\') goto L23;
        if (r6 != ';') goto L31;
        if (r8 != '@') goto L31;
        r4 = r7;
    L32:
        r4 = r4 + 1;
        goto L17
    L23:
        if (r8 == ' ') goto L32;
        if (r8 == '\\') goto L32;
        switch(r8) {
            case 44: goto L32;
            case 45: goto L32;
            case 46: goto L32;
            default: goto L31;
        };
    L31:
        r3.append(r6);
        goto L32
    L33:
        String r5 = r3.toString();
        if (date_ptrn4.matcher(r5).matches() == false) goto L37;
        cache(r11, r10, true);
        return true;
    L37:
        String r9 = date_ptrn2.matcher(date_ptrn1.matcher(date_ptrn5.matcher(r5).replaceAll("")).replaceAll("")).replaceAll("");
        int r12 = r9.indexOf(59);
        if (r12 <= 0) goto L43;
        if (r12 >= (r9.length() - 1)) goto L43;
        r9 = r9.substring(0, r12);
    L43:
        if (date_ptrn3a.matcher(r9).find() == true) goto L45;
        return false;
    L45:
        boolean r0 = date_ptrn3b.matcher(r9).matches();
        cache(r11, r10, r0);
        return r0;
    L14:
        return ((Boolean) ZeusTransformUtils.preCheckCast(lastCachedResult.get(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public static boolean isADateFormat(ExcelNumberFormat r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return isADateFormat(r1.getIdx(), r1.getFormat());
    }

    private static boolean isCached(String r3, int r4) {
        if (r4 == ((Integer) ZeusTransformUtils.preCheckCast(lastFormatIndex.get(), Integer.class, "com.obric.memorydata.plugin")).intValue()) goto L5;
    L7:
        return false;
    L5:
        if (r3.equals(lastFormatString.get()) == false) goto L7;
        return true;
    }

    public static boolean isCellDateFormatted(Cell r2) {
        return isCellDateFormatted((Cell) ZeusTransformUtils.wrapperContextForParams(r2, Cell.class, "com.obric.memorydata.plugin"), null);
    }

    public static boolean isCellDateFormatted(Cell r3, ConditionalFormattingEvaluator r4) {
        Cell r5 = (Cell) ZeusTransformUtils.wrapperContextForParams(r3, Cell.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        return false;
    L6:
        if (isValidExcelDate(r5.getNumericCellValue()) == false) goto L12;
        ExcelNumberFormat r6 = ExcelNumberFormat.from(r5, r4);
        if (r6 != null) goto L11;
        return false;
    L11:
        return isADateFormat(r6);
    L12:
        return false;
    }

    public static boolean isInternalDateFormat(int r0) {
        switch(r0) {
            case 14: goto L6;
            case 15: goto L6;
            case 16: goto L6;
            case 17: goto L6;
            case 18: goto L6;
            case 19: goto L6;
            case 20: goto L6;
            case 21: goto L6;
            case 22: goto L6;
            default: goto L3;
        };
    L3:
        switch(r0) {
            case 45: goto L8;
            case 46: goto L8;
            case 47: goto L8;
            default: goto L4;
        };
    L4:
        return false;
    L8:
        return true;
    L6:
        return true;
    }

    public static boolean isValidExcelDate(double r2) {
        if (r2 <= (-4.9E-324d)) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ Integer lambda$static$0() {
        return -1;
    }

    /* JADX WARN: Type inference failed for: r7v9, types: [java.time.ZonedDateTime] */
    public static Double parseDateTime(String r7) {
        TemporalAccessor r8 = dateTimeFormats.parse(r7.replaceAll("\\s+", " "));
        LocalTime r0 = (LocalTime) ZeusTransformUtils.preCheckCast(r8.query(TemporalQueries.localTime()), LocalTime.class, "com.obric.memorydata.plugin");
        LocalDate r9 = (LocalDate) ZeusTransformUtils.preCheckCast(r8.query(TemporalQueries.localDate()), LocalDate.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L7;
        if (r9 != null) goto L7;
        return null;
    L7:
        double r1 = 0.0d;
        if (r9 == null) goto L10;
        r1 = getExcelDate(Date.from(r9.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
    L10:
        if (r0 == null) goto L13;
        r1 = r1 + ((((double) r0.toSecondOfDay()) * 1.0d) / 86400.0d);
    L13:
        return Double.valueOf(r1);
    }

    public static void setCalendar(Calendar r7, int r8, int r9, boolean r10, boolean r11) {
        int r0 = ODatePickerView.YEAR_FROM;
        if (r10 == false) goto L6;
        r0 = 1904;
        int r12 = 1;
    L9:
        r7.set(r0, 0, r8 + r12, 0, 0, 0);
        r7.set(14, r9);
        if (r7.get(14) != 0) goto L12;
        r7.clear(14);
    L12:
        if (r11 == false) goto L15;
        r7.add(14, 500);
        r7.clear(14);
        return;
    L15:
        return;
    L6:
        if (r8 >= 61) goto L8;
        r12 = 0;
        goto L9
    L8:
        r12 = -1;
        goto L9
    }
}
