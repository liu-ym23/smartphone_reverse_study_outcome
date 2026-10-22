package com.obric.memorydata.utils;

import android.text.TextUtils;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e\u001a\u000e\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u000e\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u000e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u0006\u0010\u0016\u001a\u00020\u0001\u001a&\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%\u001a\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u0001H\u0007\u001a\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u0001\u001a\u0010\u0010)\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0001H\u0007\u001a\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0001H\u0007\u001a\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0001H\u0007\u001a\u000e\u0010,\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0001\u001a\u0010\u0010-\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0001H\u0007\u001a\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0001H\u0007\u001a\u001a\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u000eH\u0007\u001a\u000e\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u000e\u001a\u0015\u00105\u001a\u0004\u0018\u00010\u00032\u0006\u00104\u001a\u00020\u000e¢\u0006\u0002\u00106\u001a\u000e\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u0003\u001a\u0010\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000eH\u0007\u001a\u001a\u00109\u001a\u00020\u00012\b\u0010;\u001a\u0004\u0018\u00010\u000e2\u0006\u0010:\u001a\u00020\u000eH\u0007\u001a\u0010\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u0001H\u0007\u001a\u0010\u0010>\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u0001H\u0007\u001a\u0016\u0010?\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\u000e\u001a\u0018\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u00012\b\b\u0002\u0010C\u001a\u00020#\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"HALF_DAY_IN_MILLSECONDS", "", "INT_ONE_HOUR_MINUTES", "", "ONE_DAY_HOURS", "ONE_DAY_IN_MILLISECONDS", "ONE_DAY_IN_MINUTE", "ONE_HOUR_IN_MILLISECONDS", "ONE_MINUTE_IN_MILLISECONDS", "ONE_SECOND_IN_MILLISECONDS", "ONE_MILLISECONDS_IN_MICROSECONDS", "FIFTEEN_MINUTE_IN_MILLISECONDS", "FIVE_MINUTE_IN_MILLISECONDS", "TAG", "", "STR_COLON", "convertToChineseDate", "dateString", "getCorrespondingEndTime", "ms", "getCorrespondingStartTime", "getCorrespondingHour", "getTodayCorrespondingStartTime", "calculateOverlapTime", "s1", "e1", "s2", "e2", "dayOfWeek", "REQUEST_HOLIDAY_SCHEMA", "IS_HOLIDAY", "HOLIDAY", "HOLIDAY_TYPE", "HOLIDAY_TYPE_HOLIDAY", "isWorkingDay", "", "calendar", "Ljava/util/Calendar;", "getHh", "curTimeMills", "getHhMm", "getFullDate", "getFullChineseDate", "getChineseMonthDay", "getFullWithoutSecondDate", "getYearMonthDay", "getYearMonthDaySplitBySlash", "parseTime", "Ljava/util/Date;", "data", "format", "transformMinutesToHmm", "str", "transformMinutesToHmmHasNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "transformHmmToMinutes", "minuteValue", "convertToTimestamp", "timeString", "dateStr", "convertToHourMinuteDesc", "timestamp", "convertToDateDesc", "toTodayTimestamp", "formatStr", "getDateTimeWithWeek", "dateTs", "removeYearIfCurrent", "utils_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class r {
    public static final long a(long r1) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r1);
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        return r0.getTimeInMillis();
    }

    public static final String a(int r4) {
        int r0 = r4 / 60;
        StringBuilder r1 = new StringBuilder();
        if (r0 >= 10) goto L5;
        r1.append("0");
    L5:
        r1.append(r0);
        r1.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        int r5 = r4 % 60;
        if (r5 >= 10) goto L8;
        r1.append("0");
    L8:
        r1.append(r5);
        String r6 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        return r6;
    }

    public static final String a(long r5, boolean r7) {
        LocalDateTime r0 = LocalDateTime.ofInstant(Instant.ofEpochMilli(r5), ZoneId.systemDefault());
        String r1 = r0.getDayOfWeek().getDisplayName(TextStyle.SHORT, new Locale("zh"));
        SimpleDateFormat r2 = new SimpleDateFormat(Format.DATE_SPLIT_BY_SLASH.getValue());
        if (r7 == false) goto L11;
        if (r0.getYear() != LocalDate.now().getYear()) goto L7;
        StringBuilder r6 = new StringBuilder().append(r0.format(DateTimeFormatter.ofPattern(Format.MONTH_DAY_SPLIT_BY_SLASH.getValue())));
    L9:
        return r6.append(' ').append(r1).toString();
    L7:
        r6 = new StringBuilder().append(r2.format(new Date(r5)));
        goto L9
    L11:
        return r2.format(new Date(r5)) + ' ' + r1;
    }

    public static /* synthetic */ String a(long r0, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = true;
    L6:
        return a(r0, r2);
    }

    public static final String a(String r13) {
        Intrinsics.checkNotNullParameter(r13, "dateString");
        String r0 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        Iterator r2 = CollectionsKt.listOf(new String[]{Format.DATE_SPLIT_BY_SLASH.getValue(), Format.MONTH_DAY_SPLIT_BY_SLASH.getValue(), Format.DATE_NOT_FORMATTED.getValue(), Format.MONTH_NOT_FORMATTED.getValue()}).iterator();
    L4:
        if (r2.hasNext() == false) goto L16;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        SimpleDateFormat r7 = new SimpleDateFormat(r3, Locale.getDefault());     // Catch: Exception -> L17
        r7.setLenient(false);     // Catch: Exception -> L17
        Date r8 = r7.parse(r0);     // Catch: Exception -> L17
        Calendar r9 = Calendar.getInstance();     // Catch: Exception -> L17
        r9.setTime(r8);     // Catch: Exception -> L17
        int r10 = r9.get(2) + 1;     // Catch: Exception -> L17
        int r11 = r9.get(5);     // Catch: Exception -> L17
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("yy", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L9;
    L14:
        StringBuilder r4 = new StringBuilder().append(r10).append(26376).append(r11).append(26085);     // Catch: Exception -> L17
    L13:
        r13 = r4.toString();     // Catch: Exception -> L17
    L9:
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("dd", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L14;
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("d", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L14;
        r4 = new StringBuilder().append(r10).append("月1日");     // Catch: Exception -> L17
    L16:
        return r13;
    }

    public static final Date a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "format");
        return new SimpleDateFormat(r3).parse(r2);
    L5:
        e = move-exception;
        RunLog.INSTANCE.error("DateTimeUtils", "incorrect time string of parseTime", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return null;
    }

    public static final int b(long r1) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r1);
        return r0.get(11);
    }

    public static final int b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "str");
        Integer r2 = c(r1);
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.intValue();
    }

    public static final long b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "timeString");
        if (new Regex("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L9;
        Date r12 = new SimpleDateFormat(Format.FULL_WITHOUT_SECOND.getValue()).parse(r11);
        if (r12 != null) goto L7;
        return 0;
    L7:
        return r12.getTime();
    L9:
        if (new Regex("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L15;
        Date r13 = new SimpleDateFormat(Format.FULL.getValue()).parse(r11);
        if (r13 != null) goto L13;
        return 0;
    L13:
        return r13.getTime();
    L15:
        if (new Regex("\\d{4}-\\d{2}-\\d{2}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L20;
        Date r14 = new SimpleDateFormat(Format.DATE.getValue()).parse(r11);
        if (r14 != null) goto L19;
        return 0;
    L19:
        return r14.getTime();
    L20:
        boolean r6 = false;
        if (new Regex("\\d{2}:\\d{2}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L37;
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L25;
    L26:
        r6 = true;
    L27:
        if (r6 == false) goto L29;
    L34:
        Format r15 = Format.MINUTE;
    L58:
        return c(r11, r15.getValue());
    L29:
        if (new Regex("\\d{4}-\\d{2}-\\d{2}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L34;
        Date r16 = new SimpleDateFormat(Format.FULL_WITHOUT_SECOND.getValue()).parse(r10 + ' ' + r11);
        if (r16 != null) goto L57;
        return 0;
    L57:
        return r16.getTime();
    L25:
        if (r0.length() != 0) goto L27;
    L37:
        if (new Regex("\\d{2}:\\d{2}:\\d{2}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L51;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L41;
    L42:
        r6 = true;
    L43:
        if (r6 == false) goto L45;
    L50:
        r15 = Format.SECOND;
        goto L58
    L45:
        if (new Regex("\\d{4}-\\d{2}-\\d{2}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L50;
        r16 = new SimpleDateFormat(Format.FULL.getValue()).parse(r10 + ' ' + r11);
        if (r16 != null) goto L57;
        return 0;
    L41:
        if (r1.length() != 0) goto L43;
    L51:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DateTimeUtils", "incorrect time string format of convertToTimestamp " + r11, null, 4, null);
        return 0;
    }

    public static final int c(long r1) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r1);
        return r0.get(7) - 1;
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [java.time.ZonedDateTime] */
    public static final long c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "timeString");
        Intrinsics.checkNotNullParameter(r3, "formatStr");
        DateTimeFormatter r4 = DateTimeFormatter.ofPattern(r3);
        LocalTime r5 = LocalTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"), r4);
        return LocalDate.now().atTime(r5).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static final Integer c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "str");
        String[] r5 = TextUtils.split(r4, ParameterizedMessage.ERROR_MSG_SEPARATOR);
        if (r5.length == 2) goto L5;
        return null;
    L5:
        String r0 = r5[0];
        Intrinsics.checkNotNullExpressionValue(r0, "get(...)");
        Integer r1 = StringsKt.toIntOrNull(r0);
        String r6 = r5[1];
        Intrinsics.checkNotNullExpressionValue(r6, "get(...)");
        Integer r7 = StringsKt.toIntOrNull(r6);
        if (r1 == null) goto L11;
        if (r7 == null) goto L11;
        return Integer.valueOf((r1.intValue() * 60) + r7.intValue());
    L11:
        return null;
    }

    public static final long d(String r10) {
        Intrinsics.checkNotNullParameter(r10, "timeString");
        if (new Regex("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L9;
        Date r11 = new SimpleDateFormat(Format.FULL_WITHOUT_SECOND.getValue()).parse(r10);
        if (r11 != null) goto L7;
        return 0;
    L7:
        return r11.getTime();
    L9:
        if (new Regex("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L15;
        Date r12 = new SimpleDateFormat(Format.FULL.getValue()).parse(r10);
        if (r12 != null) goto L13;
        return 0;
    L13:
        return r12.getTime();
    L15:
        if (new Regex("\\d{4}-\\d{2}-\\d{2}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L21;
        Date r13 = new SimpleDateFormat(Format.DATE.getValue()).parse(r10);
        if (r13 != null) goto L19;
        return 0;
    L19:
        return r13.getTime();
    L21:
        if (new Regex("\\d{2}:\\d{2}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L26;
        Format r0 = Format.MINUTE;
    L24:
        return c(r10, r0.getValue());
    L26:
        if (new Regex("\\d{2}:\\d{2}:\\d{2}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L28;
        r0 = Format.SECOND;
        goto L24
    L28:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "DateTimeUtils", "incorrect time string format of convertToTimestamp " + r10, null, 4, null);
        return 0;
    }

    public static final boolean d(long r2) {
        aw.a r0 = aw.f13185a.a(r2);
        if (r0 != null) goto L5;
        int r3 = c(r2);
        if (1 > r3) goto L12;
        if (r3 >= 6) goto L12;
        return true;
    L12:
        return false;
    L5:
        return !r0.b();
    }

    public static final String e(long r2) {
        String r3 = new SimpleDateFormat(Format.DATE.getValue()).format(Long.valueOf(r2));
        Intrinsics.checkNotNullExpressionValue(r3, "format(...)");
        return r3;
    }

    public static final String f(long r2) {
        String r3 = new SimpleDateFormat(Format.DATE_SPLIT_BY_SLASH.getValue()).format(Long.valueOf(r2));
        Intrinsics.checkNotNullExpressionValue(r3, "format(...)");
        return r3;
    }

    public static final String g(long r2) {
        String r3 = new SimpleDateFormat(Format.MINUTE.getValue()).format(Long.valueOf(r2));
        Intrinsics.checkNotNullExpressionValue(r3, "format(...)");
        return r3;
    }

    public static final String h(long r2) {
        String r3 = new SimpleDateFormat(Format.DATE.getValue()).format(Long.valueOf(r2));
        Intrinsics.checkNotNullExpressionValue(r3, "format(...)");
        return r3;
    }
}
