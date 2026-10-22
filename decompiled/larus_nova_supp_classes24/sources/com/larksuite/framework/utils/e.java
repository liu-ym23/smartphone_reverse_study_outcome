package com.larksuite.framework.utils;

import com.larus.audio.call.dora.CommandStatus;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static long e() {
        return System.currentTimeMillis() / 1000;
    }

    public static String b(int r2) {
        if (r2 >= 10) goto L6;
        return "0" + r2;
    L6:
        return String.valueOf(r2);
    }

    public static String f(int r4) {
        if (r4 >= 0) goto L6;
        return "";
    L6:
        if (r4 <= 0) goto L9;
        if (r4 >= 1000) goto L9;
        r4 = CommandStatus.DORA_TRACE;
    L9:
        int r5 = r4 / CommandStatus.DORA_TRACE;
        int r0 = r5 % 60;
        int r6 = r5 / 60;
        int r1 = r6 % 60;
        int r7 = r6 / 60;
        StringBuilder r2 = new StringBuilder();
        if (r7 <= 0) goto L12;
        r2.append(b(r7));
        r2.append(":");
    L12:
        r2.append(b(r1));
        r2.append(":");
        r2.append(b(r0));
        return r2.toString();
    }

    public static String g(int r0) {
        if (r0 <= 0) goto L5;
        r0 = r0 + 500;
    L5:
        return f(r0);
    }

    public static boolean h(Date r8) {
        long r0 = r8.getTime();
        f.a r9 = f.a;
        f.b r2 = r9.c(new Object[]{null, null});
        Calendar r4 = r2.b;
        f.d(r4, System.currentTimeMillis());
        int r6 = r4.get(1);
        f.d(r4, r0);
        int r1 = r4.get(1);
        r9.d(r2);
        if (r6 != r1) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        return true;
    L8:
        return false;
    L5:
        r10 = false;
        goto L6
    }

    public static int i(Date r8) {
        long r0 = r8.getTime();
        boolean r6 = false;
        if (r0 < (f.c() + 86400000)) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        return 0;
    L11:
        if (r0 <= f.c()) goto L13;
    L15:
        if (r6 == false) goto L17;
        return 1;
    L17:
        return -1;
    L13:
        if (r0 <= (f.c() - 86400000)) goto L15;
        r6 = true;
        goto L15
    L5:
        if (r0 <= f.c()) goto L7;
        r2 = true;
        goto L8
    }

    public static boolean a(long r2, long r4) {
        TimeZone r0 = TimeZone.getDefault();
        Calendar r1 = Calendar.getInstance(r0);
        r1.setTimeInMillis(r2);
        Calendar r3 = Calendar.getInstance(r0);
        r3.setTimeInMillis(r4);
        if (r1.get(1) == r3.get(1)) goto L5;
    L7:
        return false;
    L5:
        if (r1.get(6) != r3.get(6)) goto L7;
        return true;
    }

    public static String c(Date r1, String r2) {
        return new SimpleDateFormat(r2).format(r1);
    L5:
        return "";
    }

    public static int d(int r3, int r4) {
        if (r4 <= 12) goto L5;
        r3 = r3 + 1;
        r4 = 1;
    L7:
        int[] r1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((r3 % 4) != 0) goto L12;
        if ((r3 % 100) == 0) goto L12;
    L13:
        r1[1] = 29;
    L20:
        return r1[r4 - 1];
    L17:
        e = move-exception;
        e.getStackTrace();
        return 0;
    L12:
        if ((r3 % 400) != 0) goto L20;
    L5:
        if (r4 >= 1) goto L7;
        r3 = r3 - 1;
        r4 = 12;
        goto L7
    }
}
