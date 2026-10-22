package org.bouncycastle.asn1;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
class DateUtil {
    static Locale EN_Locale;
    private static final Map localeCache = null;

    static {
        localeCache = new HashMap();
        EN_Locale = forEN();
    }

    static Date epochAdjust(Date r7) {
        Locale r0 = Locale.getDefault();
        if (r0 != null) goto L5;
        return r7;
    L5:
        Map r1 = localeCache;
        monitor-enter(r1);
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(r1.get(r0), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r2 != null) goto L11;
        r2 = longValueOf(new SimpleDateFormat("yyyyMMddHHmmssz").parse("19700101000000GMT+00:00").getTime());     // Catch: Throwable -> L17
        r1.put(r0, r2);     // Catch: Throwable -> L17
    L11:
        if (r2.longValue() == 0) goto L15;
        Date r3 = new Date(r7.getTime() - r2.longValue());     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return r3;
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L17
        return r7;
    L17:
        th = move-exception;
        throw th;
    }

    private static Locale forEN() {
        if ("en".equalsIgnoreCase(Locale.getDefault().getLanguage()) == true) goto L5;
        Locale[] r0 = Locale.getAvailableLocales();
        int r2 = 0;
    L8:
        if (r2 == r0.length) goto L15;
        if ("en".equalsIgnoreCase(r0[r2].getLanguage()) == true) goto L12;
        r2 = r2 + 1;
        goto L8
    L12:
        return r0[r2];
    L15:
        return Locale.getDefault();
    L5:
        return Locale.getDefault();
    }

    private static Long longValueOf(long r0) {
        return Long.valueOf(r0);
    }
}
