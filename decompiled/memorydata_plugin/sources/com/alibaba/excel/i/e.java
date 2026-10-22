package com.alibaba.excel.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.poi.ss.usermodel.DateUtil;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f212b;
    private static final ThreadLocal<Map<Short, Boolean>> c = null;
    private static final ThreadLocal<Map<String, SimpleDateFormat>> d = null;
    private static final Pattern e = null;
    private static final Pattern f = null;
    private static final Pattern g = null;
    private static final Pattern h = null;
    private static final Pattern i = null;
    private static final Pattern j = null;
    private static final Pattern k = null;

    static {
        c = new ThreadLocal();
        d = new ThreadLocal();
        e = Pattern.compile("^\\[\\$\\-.*?\\]");
        f = Pattern.compile("^\\[[a-zA-Z]+\\]");
        g = Pattern.compile("[yYmMdDhHsS]");
        h = Pattern.compile("^[\\[\\]yYmMdDhHsS\\-T/年月日,. :\"\\\\]+0*[ampAMP/]*$");
        i = Pattern.compile("^\\[([hH]+|[mM]+|[sS]+)\\]");
        j = Pattern.compile("^\\[DBNum(1|2|3)\\]");
        k = Pattern.compile("(年|月|日|时|分|秒)+");
        f211a = "yyyy-MM-dd HH:mm:ss";
        f212b = "yyyy-MM-dd";
    }

    public static String a(String r3) {
        int r0 = r3.length();
        if (r0 != 10) goto L5;
        return "yyyy-MM-dd";
    L5:
        if (r0 != 14) goto L7;
        return "yyyyMMddHHmmss";
    L7:
        if (r0 == 19) goto L23;
        if (r0 == 16) goto L17;
        if (r0 != 17) goto L15;
        return "yyyyMMdd HH:mm:ss";
    L15:
        throw new IllegalArgumentException("can not find date format for：" + r3);
    L17:
        if (r3.contains("-") == false) goto L20;
        return "yyyy-MM-dd HH:mm";
    L20:
        return "yyyy/MM/dd HH:mm";
    L23:
        if (r3.contains("-") == false) goto L26;
        return "yyyy-MM-dd HH:mm:ss";
    L26:
        return "yyyy/MM/dd HH:mm:ss";
    }

    public static String a(BigDecimal r2, Boolean r3, String r4) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return a(DateUtil.getLocalDateTime(r2.doubleValue(), b.a(r3), true), r4);
    }

    public static String a(LocalDateTime r1, String r2) {
        return a(r1, r2, null);
    }

    public static String a(LocalDateTime r1, String r2, Locale r3) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if (o.a(r2) == false) goto L8;
        r2 = f211a;
    L8:
        if (r3 != null) goto L12;
        DateTimeFormatter r4 = DateTimeFormatter.ofPattern(r2);
    L11:
        return r1.format(r4);
    L12:
        r4 = DateTimeFormatter.ofPattern(r2, r3);
        goto L11
    }

    public static LocalDateTime a(String r1, String r2, Locale r3) {
        if (o.a(r2) == false) goto L5;
        r2 = a(r1);
    L5:
        if (r3 != null) goto L9;
        DateTimeFormatter r4 = DateTimeFormatter.ofPattern(r2);
    L8:
        return LocalDateTime.parse(r1, r4);
    L9:
        r4 = DateTimeFormatter.ofPattern(r2, r3);
        goto L8
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.time.ZonedDateTime] */
    public static Date a(double r0, boolean r2) {
        return Date.from(b(r0, r2).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date a(String r1, String r2) {
        if (o.a(r2) == false) goto L6;
        r2 = a(r1);
    L6:
        return b(r2).parse(r1);
    }

    public static void a() {
        c.remove();
        d.remove();
    }

    public static boolean a(Short r4, String r5) {
        if (r4 != null) goto L5;
        return false;
    L5:
        ThreadLocal<Map<Short, Boolean>> r0 = c;
        Map<Short, Boolean> r1 = (Map) ZeusTransformUtils.preCheckCast(r0.get(), Map.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
        r1 = j.a();
        r0.set(r1);
    L12:
        boolean r6 = b(r4, r5);
        r1.put(r4, Boolean.valueOf(r6));
        return r6;
    L8:
        Boolean r2 = (Boolean) ZeusTransformUtils.preCheckCast(r1.get(r4), Boolean.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L12;
        return r2.booleanValue();
    }

    public static boolean a(short r0) {
        switch(r0) {
            case 14: goto L8;
            case 15: goto L8;
            case 16: goto L8;
            case 17: goto L8;
            case 18: goto L8;
            case 19: goto L8;
            case 20: goto L8;
            case 21: goto L8;
            case 22: goto L8;
            default: goto L3;
        };
    L3:
        switch(r0) {
            case 27: goto L10;
            case 28: goto L10;
            case 29: goto L10;
            case 30: goto L10;
            case 31: goto L10;
            case 32: goto L10;
            case 33: goto L10;
            case 34: goto L10;
            case 35: goto L10;
            case 36: goto L10;
            default: goto L4;
        };
    L4:
        switch(r0) {
            case 45: goto L11;
            case 46: goto L11;
            case 47: goto L11;
            default: goto L5;
        };
    L5:
        switch(r0) {
            case 50: goto L12;
            case 51: goto L12;
            case 52: goto L12;
            case 53: goto L12;
            case 54: goto L12;
            case 55: goto L12;
            case 56: goto L12;
            case 57: goto L12;
            case 58: goto L12;
            default: goto L6;
        };
    L6:
        return false;
    L12:
        return true;
    L11:
        return true;
    L10:
        return true;
    L8:
        return true;
    }

    private static DateFormat b(String r4) {
        ThreadLocal<Map<String, SimpleDateFormat>> r0 = d;
        Map<String, SimpleDateFormat> r1 = (Map) ZeusTransformUtils.preCheckCast(r0.get(), Map.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        r1 = new HashMap();
        r0.set(r1);
    L8:
        SimpleDateFormat r2 = new SimpleDateFormat(r4);
        r1.put(r4, r2);
        return r2;
    L5:
        SimpleDateFormat r3 = (SimpleDateFormat) ZeusTransformUtils.preCheckCast(r1.get(r4), SimpleDateFormat.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L8;
        return r3;
    }

    public static LocalDate b(String r1, String r2, Locale r3) {
        if (o.a(r2) == false) goto L5;
        r2 = a(r1);
    L5:
        if (r3 != null) goto L9;
        DateTimeFormatter r4 = DateTimeFormatter.ofPattern(r2);
    L8:
        return LocalDate.parse(r1, r4);
    L9:
        r4 = DateTimeFormatter.ofPattern(r2, r3);
        goto L8
    }

    public static LocalDateTime b(double r1, boolean r3) {
        return DateUtil.getLocalDateTime(r1, r3, true);
    }

    public static boolean b(Short r9, String r10) {
        if (a(r9.shortValue()) == false) goto L6;
        return true;
    L6:
        if (o.a(r10) == false) goto L8;
        return false;
    L8:
        int r11 = r10.length();
        StringBuilder r2 = new StringBuilder(r11);
        int r3 = 0;
    L10:
        if (r3 >= r11) goto L26;
        char r5 = r10.charAt(r3);
        if (r3 >= (r11 - 1)) goto L24;
        int r6 = r3 + 1;
        char r7 = r10.charAt(r6);
        if (r5 == '\\') goto L16;
        if (r5 != ';') goto L24;
        if (r7 != '@') goto L24;
        r3 = r6;
    L25:
        r3 = r3 + 1;
        goto L10
    L16:
        if (r7 == ' ') goto L25;
        if (r7 == '\\') goto L25;
        switch(r7) {
            case 44: goto L25;
            case 45: goto L25;
            case 46: goto L25;
            default: goto L24;
        };
    L24:
        r2.append(r5);
        goto L25
    L26:
        String r12 = r2.toString();
        if (i.matcher(r12).matches() == false) goto L29;
        return true;
    L29:
        String r13 = f.matcher(e.matcher(j.matcher(r12).replaceAll("")).replaceAll("")).replaceAll("");
        int r14 = r13.indexOf(59);
        if (r14 <= 0) goto L35;
        if (r14 >= (r13.length() - 1)) goto L35;
        r13 = r13.substring(0, r14);
    L35:
        if (g.matcher(r13).find() == true) goto L38;
        return false;
    L38:
        if (h.matcher(r13).matches() == false) goto L41;
        return true;
    L41:
        return k.matcher(r13).find();
    }

    public static LocalDate c(double r0, boolean r2) {
        LocalDateTime r1 = b(r0, r2);
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.toLocalDate();
    }
}
