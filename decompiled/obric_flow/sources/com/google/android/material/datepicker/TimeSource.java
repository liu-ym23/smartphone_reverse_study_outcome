package com.google.android.material.datepicker;

import androidx.annotation.Nullable;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
class TimeSource {
    private static final TimeSource SYSTEM_TIME_SOURCE = null;

    @Nullable
    private final Long fixedTimeMs;

    @Nullable
    private final TimeZone fixedTimeZone;

    static {
        SYSTEM_TIME_SOURCE = new TimeSource(null, null);
    }

    private TimeSource(@Nullable Long r5, @Nullable TimeZone r10) {
        this.fixedTimeMs = r5;
        this.fixedTimeZone = r10;
    }

    public static TimeSource fixed(long r5, @Nullable TimeZone r10) {
        return new TimeSource(Long.valueOf(r5), r10);
    }

    public static TimeSource system() {
        return SYSTEM_TIME_SOURCE;
    }

    public Calendar now() {
        return now(this.fixedTimeZone);
    }

    public static TimeSource fixed(long r5) {
        return new TimeSource(Long.valueOf(r5), null);
    }

    public Calendar now(@Nullable TimeZone r5) {
        if (r5 != null) goto L4;
        Calendar r10 = Calendar.getInstance();
    L5:
        Long r11 = this.fixedTimeMs;
        if (r11 == null) goto L8;
        r10.setTimeInMillis(r11.longValue());
    L8:
        return r10;
    L4:
        r10 = Calendar.getInstance(r5);
        goto L5
    }
}
