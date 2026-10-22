package com.bytedance.applog.monitor.v3;

import android.os.SystemClock;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicLong f1700a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicLong f1701b = null;
    private static final SimpleDateFormat c = null;

    static {
        c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        long r0 = (((SystemClock.elapsedRealtime() / 1000) * 100) + ((long) new SecureRandom().nextInt(99))) * 100000;
        f1700a = new AtomicLong(r0);
        f1701b = new AtomicLong(r0);
    }

    public static long a() {
        return f1700a.incrementAndGet();
    }

    public static List<String> a(String r5, char r6) {
        if (r5 == null) goto L16;
        if (r5.isEmpty() == true) goto L16;
        ArrayList r0 = new ArrayList();
        int r1 = r5.length();
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r2 >= r1) goto L12;
        if (r5.charAt(r2) != r6) goto L11;
        r0.add(r5.substring(r3, r2));
        r3 = r2 + 1;
    L11:
        r2 = r2 + 1;
        goto L7
    L12:
        if (r3 > r1) goto L14;
        r0.add(r5.substring(r3));
    L14:
        return r0;
    L16:
        return new ArrayList();
    }

    public static long b() {
        return f1701b.incrementAndGet();
    }

    public static String c() {
        return String.valueOf(a());
    }

    public static String d() {
        return c.format(new Date());
    }
}
