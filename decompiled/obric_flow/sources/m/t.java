package m;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.writer.DaoWriter;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ZoneId f19909a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DateTimeFormatter f19910b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DateTimeFormatter f19911c = null;
    public static final DateTimeFormatter d = null;
    public static final DateTimeFormatter e = null;
    public static final DateTimeFormatter f = null;
    public static final DateTimeFormatter g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DateTimeFormatter f19912h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final DateTimeFormatter f19913i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final DateTimeFormatter f19914j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final DateTimeFormatter f19915k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final DateTimeFormatter f19916l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final DateTimeFormatter f19917m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final DateTimeFormatter f19918n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final DateTimeFormatter f19919o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final DateTimeFormatter f19920p = null;

    static {
        ZoneId r5 = ZoneId.systemDefault();
        f19909a = r5;
        ZoneId.of(N.f19842m.b());
        DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(r5);
        f19910b = DateTimeFormatter.ofPattern("yyyy-M-d").withZone(r5);
        f19911c = DateTimeFormatter.ofPattern("yyyyMMdd").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy/MM/dd").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy/M/d").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy年MM月dd日").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy年M月d日").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy.MM.dd").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy.M.d").withZone(r5);
        DateTimeFormatter.ofPattern("yy/MM/dd").withZone(r5);
        DateTimeFormatter.ofPattern("yy/M/d").withZone(r5);
        DateTimeFormatter.ofPattern("MM/dd/yy").withZone(r5);
        DateTimeFormatter.ofPattern("M/d/yy").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy-MM-dd E").withZone(r5);
        DateTimeFormatter.ofPattern("yy").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy-MM").withZone(r5);
        DateTimeFormatter.ofPattern("yyyyMM").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy/MM").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy年MM月").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy年M月").withZone(r5);
        DateTimeFormatter.ofPattern("MM-dd").withZone(r5);
        DateTimeFormatter.ofPattern("MMdd").withZone(r5);
        DateTimeFormatter.ofPattern("MM/dd").withZone(r5);
        DateTimeFormatter.ofPattern("M/d").withZone(r5);
        DateTimeFormatter.ofPattern("MM月dd日").withZone(r5);
        DateTimeFormatter.ofPattern("M月d日").withZone(r5);
        DateTimeFormatter.ofPattern("HH:mm:ss").withZone(r5);
        DateTimeFormatter.ofPattern("H:m:s").withZone(r5);
        DateTimeFormatter.ofPattern("HHmmss").withZone(r5);
        DateTimeFormatter.ofPattern("HH时mm分ss秒").withZone(r5);
        DateTimeFormatter.ofPattern("HH:mm").withZone(r5);
        DateTimeFormatter.ofPattern("H:m").withZone(r5);
        DateTimeFormatter.ofPattern("HH时mm分").withZone(r5);
        DateTimeFormatter.ofPattern("hh:mm a").withZone(r5);
        Locale r10 = Locale.ENGLISH;
        DateTimeFormatter.ofPattern("hh:mm a", r10).withZone(r5);
        DateTimeFormatter.ofPattern("HH:mm:ss.SSS").withZone(r5);
        DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS").withZone(r5);
        DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSSSSS").withZone(r5);
        d = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(r5);
        e = DateTimeFormatter.ofPattern("yyyy-M-d H:m:s").withZone(r5);
        f = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy/M/d H:m:s").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").withZone(r5);
        g = DateTimeFormatter.ofPattern("yyyy-M-d H:m").withZone(r5);
        f19912h = DateTimeFormatter.ofPattern("yyyyMMddHHmm").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy/M/d H:m").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy/M/d h:m a").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy/M/d h:m a", r10).withZone(r5);
        DateTimeFormatter.ofPattern("MM-dd HH:mm").withZone(r5);
        DateTimeFormatter.ofPattern("MM月dd日 HH:mm").withZone(r5);
        DateTimeFormatter.ofPattern("MM-dd HH:mm:ss").withZone(r5);
        DateTimeFormatter.ofPattern("MM月dd日 HH:mm:ss").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss a").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss a", r10).withZone(r5);
        DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh时mm分ss秒 a").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh时mm分ss秒 a", r10).withZone(r5);
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss,SSS").withZone(r5);
        f19913i = new DateTimeFormatterBuilder().appendPattern("yyyyMMddHHmmss").appendValue(ChronoField.MILLI_OF_SECOND, 3).toFormatter().withZone(r5);
        f19914j = DateTimeFormatter.ofPattern("yyyy-M-d H:m:s.SSS").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy/M/d H:m:s.SSS").withZone(r5);
        f19915k = DateTimeFormatter.ofPattern("yyyy-M-d H:m:s,SSS").withZone(r5);
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS").withZone(r5);
        f19916l = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS").withZone(r5);
        f19917m = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssxxx");
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        f19918n = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSxxx");
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ");
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSxxx");
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX");
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSSZ");
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSSxxx");
        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSSXXX");
        DateTimeFormatter r11 = DateTimeFormatter.ISO_DATE;
        f19919o = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter r12 = DateTimeFormatter.ISO_INSTANT;
        DateTimeFormatter r13 = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter r14 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        DateTimeFormatter r15 = DateTimeFormatter.ISO_LOCAL_TIME;
        DateTimeFormatter r16 = DateTimeFormatter.ISO_TIME;
        DateTimeFormatter r17 = DateTimeFormatter.ISO_WEEK_DATE;
        DateTimeFormatter r18 = DateTimeFormatter.ISO_ZONED_DATE_TIME;
        DateTimeFormatter r19 = DateTimeFormatter.BASIC_ISO_DATE;
        f19920p = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy", r10);
    }

    public static String a(Date r5, String r10) {
        DateTimeFormatter r11 = DateTimeFormatter.ofPattern(r10).withZone(f19909a);
        Objects.requireNonNull(r11, "formatter");
        Objects.requireNonNull(r5, "date");
        return Instant.ofEpochMilli(r5.getTime()).atZone(ZoneId.systemDefault()).format(r11);
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.time.LocalDateTime] */
    public static LocalDateTime b(String r5, DateTimeFormatter r10) {
        Objects.requireNonNull(r10, "formatter");
        ZonedDateTime r11 = com.lynx.tasm.behavior.ui.utils.e.j(r10.parse(r5));     // Catch: DateTimeException -> L5
        Objects.requireNonNull(r11, "zonedDateTime");     // Catch: DateTimeException -> L5
        return r11.toLocalDateTime();
    L5:
        e = move-exception;
        if (e.getMessage().startsWith("Unable to obtain") == false) goto L10;
        LocalDate r12 = LocalDate.parse(r5, r10);
        Objects.requireNonNull(r12, "localDate");
        return r12.atStartOfDay();
    L10:
        throw e;
    }

    /* JADX WARN: Type inference failed for: r12v24, types: [java.time.LocalDateTime] */
    /* JADX WARN: Type inference failed for: r12v26, types: [java.time.LocalDateTime] */
    /* JADX WARN: Type inference failed for: r12v28, types: [java.time.LocalDateTime] */
    public static LocalDateTime c(String r12) {
        if (io.reactivex.internal.observers.h.e(r12) == true) goto L123;
        String r13 = r12.trim();
        int r5 = r13.length();
        if (r5 < 8) goto L121;
        if (r13.contains("[") == true) goto L9;
        r13 = r13.replace("/", DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
    L9:
        int r10 = 0;
        if (r13 != null) goto L12;
        int r11 = 0;
    L14:
        if (r11 != 2) goto L16;
        r13 = r13.replace(".", DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD);
    L16:
        if (r13 != null) goto L18;
        boolean r14 = false;
    L20:
        if (r14 == false) goto L22;
        r13 = r13.replace("年", DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD).replace("月", DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD).replace("日", "").replace("时", ":").replace("分", ":").replace("秒", "");
    L22:
        if (r13 != null) goto L24;
        boolean r15 = false;
    L25:
        if (r15 == true) goto L27;
        if (r13 != null) goto L30;
        boolean r16 = false;
    L31:
        if (r16 == true) goto L33;
        if (r13 != null) goto L49;
        int r17 = 0;
    L50:
        if (r17 != 0) goto L54;
        return b(r13, f19910b);
    L54:
        if (r13.contains(ExifInterface.GPS_DIRECTION_TRUE) == false) goto L81;
        if (io.reactivex.internal.observers.h.e(r13) == true) goto L79;
        if (r13.contains(ExifInterface.GPS_DIRECTION_TRUE) == false) goto L77;
        String r18 = r13.trim();
        int r19 = r18.length();
        boolean r20 = r18.contains("[");
        DateTimeFormatter r21 = f19918n;
        DateTimeFormatter r22 = f19917m;
        DateTimeFormatter r23 = f19919o;
        if (r20 == true) goto L70;
        if (r18.contains("Z") == true) goto L125;
        if (r19 == 24) goto L126;
        if (r19 != 28) goto L128;
        return b(r18, r21);
    L128:
        return b(r18, r23);
    L126:
        return b(r18, r22);
    L125:
        return b(r18, r23);
    L70:
        if (r19 != 24) goto L72;
        ZonedDateTime r110 = ZonedDateTime.parse(r18, r22);
        Objects.requireNonNull(r110, "zonedDateTime");
        return r110.toLocalDateTime();
    L72:
        if (r19 != 28) goto L74;
        ZonedDateTime r111 = ZonedDateTime.parse(r18, r21);
        Objects.requireNonNull(r111, "zonedDateTime");
        return r111.toLocalDateTime();
    L74:
        ZonedDateTime r112 = ZonedDateTime.parse(r18, r23);
        Objects.requireNonNull(r112, "zonedDateTime");
        return r112.toLocalDateTime();
    L77:
        throw new DateTimeException("text is not supported! ".concat(r13));
    L79:
        throw new DateTimeException("text is null");
    L81:
        if (r17 > 0) goto L83;
    L106:
        if (r17 > 0) goto L108;
    L111:
        if (r17 <= 0) goto L119;
        if (r17 == 2) goto L114;
        if (r17 != 1) goto L119;
        return b(r13, g);
    L114:
        return b(r13, e);
    L119:
        throw new DateTimeException(j0.C("text is not supported! ", r13));
    L108:
        if (r13.contains(",") == false) goto L111;
        return b(r13, f19915k);
    L83:
        if (r13.contains(".") == false) goto L106;
        if (r13.split("\\.")[1].length() == 3) goto L87;
        String r113 = r13.trim();
        if (r113.contains(".") == false) goto L105;
        String[] r24 = r113.split("\\.");
        String r25 = r24[0];
        String r26 = r24[1];
        int r27 = r25.length();
        int r28 = r26.length();
        if (r27 != 19) goto L103;
        if (r28 > 9) goto L101;
        StringBuilder r114 = new StringBuilder();
    L96:
        if (r10 >= (9 - r28)) goto L98;
        r114.append("0");
        r10 = r10 + 1;
        goto L96
    L98:
        StringBuilder r29 = j0.u(r26);
        r29.append(r114.toString());
        return b(j0.D(r25, ".", r29.toString()), f19916l);
    L101:
        throw new DateTimeException("text is not supported! ".concat(r113));
    L103:
        throw new DateTimeException("text is not supported! ".concat(r113));
    L105:
        throw new DateTimeException("text is not supported! ".concat(r113));
    L87:
        return b(r13, f19914j);
    L49:
        r17 = r13.length() - r13.replace(":", "").length();
        goto L50
    L33:
        if (r5 != 14) goto L37;
        return b(r13, f);
    L37:
        if (r5 == 17) goto L39;
        if (r5 != 8) goto L44;
        return b(r13, f19911c);
    L44:
        if (r5 != 12) goto L119;
        return b(r13, f19912h);
    L39:
        return b(r13, f19913i);
    L30:
        r16 = s.f19906a.matcher(r13).matches();
        goto L31
    L27:
        return b(r13, f19920p);
    L24:
        r15 = s.f19907b.matcher(r13).matches();
        goto L25
    L18:
        r14 = s.f19908c.matcher(r13).find();
        goto L20
    L12:
        r11 = r13.length() - r13.replace(".", "").length();
        goto L14
    L121:
        throw new DateTimeException("text is not supported! ".concat(r13));
    L123:
        throw new DateTimeException("text is null");
    }
}
