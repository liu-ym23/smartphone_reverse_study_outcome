package com.bytedance.android.live.impl.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class TimeUtils {
    public static final SimpleDateFormat a = null;
    public static final Lazy b = null;

    static {
        a = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        b = LazyKt.lazy(TimeUtils$calendar$2.INSTANCE);
    }

    public static String b(long r1) {
        Date r0 = new Date(r1);     // Catch: Exception -> L4
        return a.format(r0);
    L4:
        e = move-exception;
        boolean r2 = a.a;
        a.b("LFM-FeatureManager", new TimeUtils$getDate$1(e), e);
        return "";
    }

    public static long c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "day");
        Date r3 = a.parse(r2);     // Catch: Exception -> L5
        Lazy r0 = b;     // Catch: Exception -> L5
        ((Calendar) r0.getValue()).setTime(r3);     // Catch: Exception -> L5
        return ((Calendar) r0.getValue()).getTimeInMillis();
    L5:
        e = move-exception;
        boolean r1 = a.a;
        a.b("LFM-FeatureManager", TimeUtils$getMsFromDay$1.INSTANCE, e);
        return System.currentTimeMillis();
    }

    public static long a(long r0, long r2) {
        return (r2 - r0) / ((long) 86400000);
    }
}
