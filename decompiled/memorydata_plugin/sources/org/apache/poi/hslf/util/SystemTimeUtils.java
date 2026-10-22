package org.apache.poi.hslf.util;

import java.util.Calendar;
import java.util.Date;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class SystemTimeUtils {
    public static Date getDate(byte[] r3, int r4) {
        Calendar r0 = LocaleUtil.getLocaleCalendar();
        r0.set(1, LittleEndian.getShort(r3, r4));
        r0.set(2, LittleEndian.getShort(r3, r4 + 2) - 1);
        r0.set(5, LittleEndian.getShort(r3, r4 + 6));
        r0.set(11, LittleEndian.getShort(r3, r4 + 8));
        r0.set(12, LittleEndian.getShort(r3, r4 + 10));
        r0.set(13, LittleEndian.getShort(r3, r4 + 12));
        r0.set(14, LittleEndian.getShort(r3, r4 + 14));
        return r0.getTime();
    }
}
