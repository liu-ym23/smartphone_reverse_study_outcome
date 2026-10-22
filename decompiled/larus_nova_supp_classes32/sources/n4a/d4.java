package n4a;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class d4 {
    public static long b(long r2) {
        Calendar r0 = Calendar.getInstance();
        r0.setTime(new Date(r2));
        r0.set(11, 0);
        r0.set(12, 0);
        r0.set(13, 0);
        r0.set(14, 0);
        return r0.getTimeInMillis();
    }

    public static long a(long r6, long r8, int r10) {
        if (r10 > 0) goto L19;
    L17:
        return r6;
    L19:
        if (Math.abs(r6 - r8) <= (((long) r10) * 31536000000L)) goto L17;
        long r0 = r6 - b(r6);     // Catch: Throwable -> L18
        long r2 = b(r8) + r0;     // Catch: Throwable -> L18
        long r9 = Math.abs(r2 - r8);     // Catch: Throwable -> L18
        Calendar r11 = Calendar.getInstance();     // Catch: Throwable -> L18
        r11.setTime(new Date(r2));     // Catch: Throwable -> L18
        int r7 = r11.get(11);     // Catch: Throwable -> L18
        if (r7 == 23) goto L10;
    L12:
        if (r7 == 0) goto L14;
        return r2;
    L14:
        if (r9 >= 82800000) goto L16;
        return r2;
    L16:
        return r2 + 86400000;
    L10:
        if (r9 < 82800000) goto L12;
        r2 = r2 - 86400000;
        goto L12
    }
}
