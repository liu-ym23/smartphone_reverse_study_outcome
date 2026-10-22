package com.bytedance.frameworks.baselib.network.http.util;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class h {
    public static final String a = null;

    public h() {
    }

    static {
        a = h.class.getSimpleName();
    }

    public static Date a(String r4) {
        int r0 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L15
        String r2 = a;
        if (r0 < 24) goto L10;
        if (Logger.debug() == false) goto L8;
        Logger.d(r2, "parse dateTime " + r4 + " sdk version >= N");     // Catch: Throwable -> L15
    L8:
        SimpleDateFormat r1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault());     // Catch: Throwable -> L15
    L13:
        return r1.parse(r4);
    L10:
        if (Logger.debug() == false) goto L12;
        Logger.d(r2, "parse dateTime " + r4 + " sdk version < N");     // Catch: Throwable -> L15
    L12:
        r1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ", Locale.getDefault());     // Catch: Throwable -> L15
    L15:
        return null;
    }

    public static long b(String r3) {
        if (Logger.debug() == false) goto L5;
        Logger.d(a, "utcTime " + r3);
    L5:
        SimpleDateFormat r0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        r0.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date r4 = r0.parse(r3);     // Catch: ParseException -> L10
        if (r4 == null) goto L15;
        return r4.getTime();
    L15:
        return 0;
    L10:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static boolean d(String r8, List<Long> r9) {
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return false;
    L6:
        if (r8.contains("~") == true) goto L8;
        return false;
    L8:
        String[] r10 = r8.split("~");
        if (r10.length == 2) goto L12;
        return false;
    L12:
        if (TextUtils.isEmpty(r10[0]) == false) goto L14;
    L25:
        return false;
    L14:
        if (TextUtils.isEmpty(r10[1]) == true) goto L25;
        long r2 = b(r10[0]);
        long r4 = b(r10[1]);
        if (r2 <= 0) goto L25;
        if (r4 <= 0) goto L25;
        if (r2 >= r4) goto L25;
        r9.add(Long.valueOf(r2));
        r9.add(Long.valueOf(r4));
        return true;
    }

    public static boolean c(String r6, String r7, List r8) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r7) == false) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty("=") == true) goto L42;
        String[] r9 = r6.split(r7);
        if (r9 != null) goto L11;
        return false;
    L11:
        int r10 = 0;
    L13:
        if (r10 >= r9.length) goto L30;
        if (TextUtils.isEmpty(r9[r10]) == true) goto L28;
        String[] r2 = r9[r10].trim().split("=");
        if (r2 == null) goto L28;
        if (r2.length != 2) goto L28;
        if (TextUtils.isEmpty(r2[0]) == true) goto L28;
        if (TextUtils.isEmpty(r2[1]) == true) goto L28;
        Pair r4 = new Pair(r2[0].trim(), r2[1].trim());
        ((ArrayList) r8).add(r4);
    L28:
        r10 = r10 + 1;
        goto L13
    L30:
        if (((ArrayList) r8).size() == 0) goto L43;
        return true;
    L43:
        return false;
    L42:
        return false;
    }
}
