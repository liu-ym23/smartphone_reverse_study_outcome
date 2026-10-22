package com.obric.aiagent.product.a;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u0015\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/aiagent/product/utils/UtcToDateUtils;", "", "<init>", "()V", "UTC_PARSE_FORMAT", "", "INT_DATE_PATTERN", "utcStrToIntDate", "", "utcStr", "utcTimestampToIntDate", "utcTimestamp", "", "parseBuildDateToInt", "data", "(Ljava/lang/String;)Ljava/lang/Integer;", "fallbackParseBuildDate", "buildDateStr", "getMonthFromAbbr", "abbr", "getIntDate", "year", "month", "day", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f5973a = null;

    static {
        f5973a = new e();
    }

    private e() {
    }

    private final Integer b(String r11) {
        MatchResult r12 = Regex.find$default(new Regex("(\\d{4})\\D*(\\d{2}|\\w{3})\\D*(\\d{2})"), (CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin"), 0, 2, null);
        if (r12 != null) goto L5;
        return null;
    L5:
        MatchResult.Destructured r13 = r12.getDestructured();
        String r0 = (String) ZeusTransformUtils.preCheckCast(r13.getMatch().getGroupValues().get(1), String.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r13.getMatch().getGroupValues().get(2), String.class, "com.obric.memorydata.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.getMatch().getGroupValues().get(3), String.class, "com.obric.memorydata.plugin");
        if (new Regex("\\d{2}").matches((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L8;
        Integer r10 = Integer.valueOf(Integer.parseInt(r6));
    L9:
        if (r10 == null) goto L12;
        int r15 = r10.intValue();
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        String r16 = String.format("%04d%02d%02d", Arrays.copyOf(new Object[]{Integer.valueOf(Integer.parseInt(r0)), Integer.valueOf(r15), Integer.valueOf(Integer.parseInt(r14))}, 3));
        Intrinsics.checkNotNullExpressionValue(r16, "format(format, *args)");
        return Integer.valueOf(Integer.parseInt(r16));
    L12:
        return null;
    L8:
        r10 = c(r6);
        goto L9
    }

    private final Integer c(String r2) {
        Locale r1 = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(r1, "ENGLISH");
        String r3 = r2.toUpperCase(r1);
        Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String).toUpperCase(locale)");
        switch(r3.hashCode()) {
            case 65027: goto L50;
            case 65171: goto L46;
            case 67554: goto L42;
            case 69475: goto L38;
            case 73207: goto L34;
            case 73825: goto L30;
            case 73827: goto L26;
            case 76094: goto L22;
            case 76101: goto L18;
            case 77493: goto L14;
            case 78080: goto L10;
            case 81982: goto L6;
            default: goto L54;
        };
    L54:
        return null;
    L6:
        if (r3.equals("SEP") == false) goto L54;
        int r4 = 9;
    L56:
        return Integer.valueOf(r4);
    L10:
        if (r3.equals("OCT") == false) goto L54;
        r4 = 10;
        goto L56
    L14:
        if (r3.equals("NOV") == false) goto L54;
        r4 = 11;
        goto L56
    L18:
        if (r3.equals("MAY") == false) goto L54;
        r4 = 5;
        goto L56
    L22:
        if (r3.equals("MAR") == false) goto L54;
        r4 = 3;
        goto L56
    L26:
        if (r3.equals("JUN") == false) goto L54;
        r4 = 6;
        goto L56
    L30:
        if (r3.equals("JUL") == false) goto L54;
        r4 = 7;
        goto L56
    L34:
        if (r3.equals("JAN") == false) goto L54;
        r4 = 1;
        goto L56
    L38:
        if (r3.equals("FEB") == false) goto L54;
        r4 = 2;
        goto L56
    L42:
        if (r3.equals("DEC") == false) goto L54;
        r4 = 12;
        goto L56
    L46:
        if (r3.equals("AUG") == false) goto L54;
        r4 = 8;
        goto L56
    L50:
        if (r3.equals("APR") == false) goto L54;
        r4 = 4;
        goto L56
    }

    public final int a(long r4) {
    L9:
        return 0;
    L4:
        if (Build.VERSION.SDK_INT < 26) goto L7;
        Instant r3 = Instant.ofEpochMilli(r4);     // Catch: Exception -> L9
        String r5 = DateTimeFormatter.ofPattern("yyyyMMdd").withZone(ZoneId.of("Asia/Shanghai")).format((TemporalAccessor) ZeusTransformUtils.preCheckCast(r3, TemporalAccessor.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L9
    L6:
        Intrinsics.checkNotNull(r5);     // Catch: Exception -> L9
        return Integer.parseInt(r5);
    L7:
        Date r6 = new Date(r4);     // Catch: Exception -> L9
        SimpleDateFormat r7 = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);     // Catch: Exception -> L9
        r7.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));     // Catch: Exception -> L9
        r5 = r7.format(r6);     // Catch: Exception -> L9
        goto L6
    }

    public final Integer a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "data");
        String r5 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L12;
        System.out.println("ro.build.date 属性为空");
        return null;
    L12:
        String r0 = ZonedDateTime.parse((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"), new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("EEE MMM dd HH:mm:ss ").appendZoneText(TextStyle.SHORT).appendPattern(" yyyy").toFormatter(Locale.ENGLISH)).format(DateTimeFormatter.ofPattern("yyyyMMdd"));     // Catch: Exception -> L9
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L9
        return Integer.valueOf(Integer.parseInt(r0));
    L9:
        e = move-exception;
        System.out.println("解析 ro.build.date 失败：" + e.getMessage() + "，尝试降级解析");
        return b(r5);
    }
}
