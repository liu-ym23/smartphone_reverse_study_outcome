package org.apache.poi.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes7.dex */
public final class LocaleUtil {
    public static final Charset CHARSET_1252 = null;
    public static final TimeZone TIMEZONE_UTC = null;
    private static final ThreadLocal<Locale> userLocale = null;
    private static final ThreadLocal<TimeZone> userTimeZone = null;

    static {
        TIMEZONE_UTC = TimeZone.getTimeZone(ZoneOffset.UTC);
        CHARSET_1252 = Charset.forName("CP1252");
        userTimeZone = new ThreadLocal();
        userLocale = new ThreadLocal();
    }

    public static Calendar getLocaleCalendar() {
        return getLocaleCalendar(getUserTimeZone());
    }

    public static Calendar getLocaleCalendar(int r6, int r7, int r8) {
        return getLocaleCalendar(r6, r7, r8, 0, 0, 0);
    }

    public static Calendar getLocaleCalendar(int r8, int r9, int r10, int r11, int r12, int r13) {
        Calendar r7 = getLocaleCalendar();
        r7.set(r8, r9, r10, r11, r12, r13);
        r7.clear(14);
        return r7;
    }

    public static Calendar getLocaleCalendar(TimeZone r1) {
        return Calendar.getInstance(r1, getUserLocale());
    }

    public static Locale getUserLocale() {
        Locale r0 = (Locale) ZeusTransformUtils.preCheckCast(userLocale.get(), Locale.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        return Locale.getDefault();
    }

    public static TimeZone getUserTimeZone() {
        TimeZone r0 = (TimeZone) ZeusTransformUtils.preCheckCast(userTimeZone.get(), TimeZone.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        return r0;
    L6:
        return TimeZone.getDefault();
    }
}
