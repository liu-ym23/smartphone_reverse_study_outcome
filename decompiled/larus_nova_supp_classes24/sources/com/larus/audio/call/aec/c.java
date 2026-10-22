package com.larus.audio.call.aec;

import android.os.SystemClock;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static final SimpleDateFormat a = null;
    public static final long b = 0;

    static {
        a = new SimpleDateFormat("HH:mm:ss.SSS");
        b = System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static String a(long r6) {
        if (r6 >= 0) goto L7;
        return "NOT_TIME";
    L7:
        return a.format(new Date(b + (r6 / ((long) 1000000))));
    }

    public static String b(long r2) {
        return a.format(new Date(r2));
    }
}
