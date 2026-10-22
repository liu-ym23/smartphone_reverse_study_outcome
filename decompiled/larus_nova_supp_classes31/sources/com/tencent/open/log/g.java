package com.tencent.open.log;

import android.text.format.Time;
import android.util.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g {
    public static final g a = null;

    public g() {
    }

    public final String a(int r2) {
        if (r2 != 1) goto L5;
        return "V";
    L5:
        if (r2 != 2) goto L7;
        return "D";
    L7:
        if (r2 != 4) goto L9;
        return "I";
    L9:
        if (r2 != 8) goto L11;
        return "W";
    L11:
        if (r2 != 16) goto L13;
        return "E";
    L13:
        if (r2 == 32) goto L16;
        return "-";
    L16:
        return "A";
    }

    static {
        a = new g();
    }

    public String a(int r5, Thread r6, long r7, String r9, String r10, Throwable r11) {
        long r0 = r7 % 1000;
        Time r2 = new Time();
        r2.set(r7);
        StringBuilder r8 = new StringBuilder();
        r8.append(a(r5));
        r8.append('/');
        r8.append(r2.format("%Y-%m-%d %H:%M:%S"));
        r8.append('.');
        if (r0 >= 10) goto L6;
        r8.append("00");
    L8:
        r8.append(r0);
        r8.append(" [");
        if (r6 != null) goto L11;
        r8.append("N/A");
    L12:
        r8.append("][");
        r8.append(r9);
        r8.append("] ");
        r8.append(r10);
        r8.append('\n');
        if (r11 == null) goto L16;
        r8.append("* Exception : \n");
        r8.append(Log.getStackTraceString(r11));
        r8.append('\n');
    L16:
        return r8.toString();
    L11:
        r8.append(r6.getName());
        goto L12
    L6:
        if (r0 >= 100) goto L8;
        r8.append('0');
        goto L8
    }
}
