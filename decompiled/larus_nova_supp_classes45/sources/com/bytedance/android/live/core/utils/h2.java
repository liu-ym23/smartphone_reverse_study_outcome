package com.bytedance.android.live.core.utils;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h2 {
    public static final int a = 0;

    static {
        a = TimeZone.getDefault().getRawOffset();
    }

    public static final long a() {
        return ((long) Calendar.getInstance().get(3)) & 4294967295L;
    }

    public static final long b() {
        return ((System.currentTimeMillis() + ((long) a)) / ((long) 86400000)) & 4294967295L;
    }
}
