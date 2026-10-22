package com.loc;

import com.obric.cae.userAware.WifiScanStateMachine;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public final class ew {
    private static long a(long r2) {
        return r2 - b(r2);
    }

    private static long a(long r6, long r8) {
        long r7 = a(r6);
        long r0 = b(r8) + r7;
        long r9 = Math.abs(r0 - r8);
        Calendar r10 = Calendar.getInstance();
        r10.setTime(new Date(r0));
        int r11 = r10.get(11);
        if (r11 == 23) goto L5;
    L7:
        if (r11 == 0) goto L9;
        return r0;
    L9:
        if (r9 >= 82800000) goto L11;
        return r0;
    L11:
        return r0 + WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
    L5:
        if (r9 < 82800000) goto L7;
        r0 = r0 - WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS;
        goto L7
    }

    public static long a(long r6, long r8, int r10) {
        if (r10 > 0) goto L9;
        return r6;
    L9:
        if (Math.abs(r6 - r8) <= (((long) r10) * 31536000000L)) goto L12;
        return a(r6, r8);
    L12:
        return r6;
    L13:
        return r6;
    }

    private static long b(long r2) {
        Calendar r0 = Calendar.getInstance();
        r0.setTime(new Date(r2));
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        return r0.getTimeInMillis();
    }
}
