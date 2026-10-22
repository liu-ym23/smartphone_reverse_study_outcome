package androidx.core.util;

import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public final class TimeUtils {
    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr;
    private static final Object sFormatSync = null;

    static {
        sFormatSync = new Object();
        sFormatStr = new char[24];
    }

    private TimeUtils() {
    }

    private static int accumField(int r2, int r3, boolean r4, int r5) {
        if (r2 > 99) goto L22;
        if (r4 == false) goto L8;
        if (r5 >= 3) goto L22;
    L8:
        if (r2 > 9) goto L20;
        if (r4 == false) goto L12;
        if (r5 >= 2) goto L20;
    L12:
        if (r4 == true) goto L18;
        if (r2 > 0) goto L18;
        return 0;
    L18:
        return r3 + 1;
    L20:
        return r3 + 2;
    L22:
        return r3 + 3;
    }

    public static void formatDuration(long r2, long r4, PrintWriter r6) {
        if (r2 != 0) goto L6;
        r6.print("--");
        return;
    L6:
        formatDuration(r2 - r4, r6, 0);
    }

    public static void formatDuration(long r1, PrintWriter r3) {
        formatDuration(r1, r3, 0);
    }

    public static void formatDuration(long r2, PrintWriter r4, int r5) {
        Object r0 = sFormatSync;
        monitor-enter(r0);
        int r3 = formatDurationLocked(r2, r5);     // Catch: Throwable -> L7
        r4.print(new String(sFormatStr, 0, r3));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void formatDuration(long r2, StringBuilder r4) {
        Object r0 = sFormatSync;
        monitor-enter(r0);
        int r3 = formatDurationLocked(r2, 0);     // Catch: Throwable -> L8
        r4.append(sFormatStr, 0, r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static int formatDurationLocked(long r17, int r19) {
        long r0 = r17;
        if (sFormatStr.length >= r19) goto L5;
        sFormatStr = new char[r19];
    L5:
        char[] r3 = sFormatStr;
        if (r0 != 0) goto L12;
        int r1 = r19 - 1;
    L8:
        if (r1 <= 0) goto L10;
        r3[0] = ' ';
        goto L8
    L10:
        r3[0] = '0';
        return 1;
    L12:
        if (r0 <= 0) goto L14;
        char r4 = '+';
    L15:
        int r12 = (int) (r0 % 1000);
        int r2 = (int) Math.floor(r0 / 1000);
        if (r2 <= SECONDS_PER_DAY) goto L18;
        int r6 = r2 / SECONDS_PER_DAY;
        r2 = r2 - (SECONDS_PER_DAY * r6);
    L20:
        if (r2 <= SECONDS_PER_HOUR) goto L22;
        int r5 = r2 / SECONDS_PER_HOUR;
        r2 = r2 - (r5 * SECONDS_PER_HOUR);
    L24:
        if (r2 <= 60) goto L26;
        int r7 = r2 / 60;
        int r13 = r2 - (r7 * 60);
        int r8 = r7;
    L28:
        if (r19 == 0) goto L48;
        int r9 = accumField(r6, 1, false, 0);
        if (r9 <= 0) goto L32;
        boolean r10 = true;
    L33:
        int r11 = r9 + accumField(r5, 1, r10, 2);
        if (r11 <= 0) goto L36;
        boolean r14 = true;
    L37:
        int r15 = r11 + accumField(r8, 1, r14, 2);
        if (r15 <= 0) goto L40;
        boolean r16 = true;
    L41:
        int r18 = r15 + accumField(r13, 1, r16, 2);
        if (r18 <= 0) goto L44;
        int r20 = 3;
    L45:
        int r21 = r18 + (accumField(r12, 2, true, r20) + 1);
        int r22 = 0;
    L46:
        if (r21 >= r19) goto L49;
        r3[r22] = ' ';
        r22 = r22 + 1;
        r21 = r21 + 1;
    L49:
        r3[r22] = r4;
        int r23 = r22 + 1;
        if (r19 == 0) goto L52;
        boolean r24 = true;
    L53:
        int r25 = printField(r3, r6, 'd', r23, false, 0);
        if (r25 == r23) goto L56;
        boolean r26 = true;
    L57:
        if (r24 == false) goto L59;
        int r27 = 2;
    L60:
        int r28 = printField(r3, r5, 'h', r25, r26, r27);
        if (r28 == r23) goto L63;
        boolean r29 = true;
    L64:
        if (r24 == false) goto L66;
        int r30 = 2;
    L67:
        int r31 = printField(r3, r8, 'm', r28, r29, r30);
        if (r31 == r23) goto L70;
        boolean r32 = true;
    L71:
        if (r24 == false) goto L73;
        int r33 = 2;
    L74:
        int r34 = printField(r3, r13, 's', r31, r32, r33);
        if (r24 == false) goto L78;
        if (r34 == r23) goto L78;
        int r35 = 3;
    L79:
        int r36 = printField(r3, r12, 'm', r34, true, r35);
        r3[r36] = 's';
        return r36 + 1;
    L78:
        r35 = 0;
        goto L79
    L73:
        r33 = 0;
        goto L74
    L70:
        r32 = false;
        goto L71
    L66:
        r30 = 0;
        goto L67
    L63:
        r29 = false;
        goto L64
    L59:
        r27 = 0;
        goto L60
    L56:
        r26 = false;
        goto L57
    L52:
        r24 = false;
        goto L53
    L44:
        r20 = 0;
        goto L45
    L40:
        r16 = false;
        goto L41
    L36:
        r14 = false;
        goto L37
    L32:
        r10 = false;
        goto L33
    L48:
        r22 = 0;
        goto L49
    L26:
        r13 = r2;
        r8 = 0;
        goto L28
    L22:
        r5 = 0;
        goto L24
    L18:
        r6 = 0;
        goto L20
    L14:
        r4 = '-';
        r0 = -r0;
        goto L15
    }

    private static int printField(char[] r2, int r3, char r4, int r5, boolean r6, int r7) {
        if (r6 == true) goto L4;
        if (r3 > 0) goto L4;
        return r5;
    L4:
        if (r6 == false) goto L8;
        if (r7 < 3) goto L8;
    L9:
        int r0 = r3 / 100;
        r2[r5] = (char) (r0 + 48);
        int r1 = r5 + 1;
        r3 = r3 - (r0 * 100);
    L11:
        if (r6 == false) goto L15;
        if (r7 < 2) goto L15;
    L17:
        int r8 = r3 / 10;
        r2[r1] = (char) (r8 + 48);
        r1 = r1 + 1;
        r3 = r3 - (r8 * 10);
    L18:
        r2[r1] = (char) (r3 + 48);
        int r9 = r1 + 1;
        r2[r9] = r4;
        return r9 + 1;
    L15:
        if (r3 > 9) goto L17;
        if (r5 == r1) goto L18;
    L8:
        if (r3 > 99) goto L9;
        r1 = r5;
        goto L11
    }
}
