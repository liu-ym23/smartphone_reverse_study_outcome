package androidx.core.util;

import androidx.annotation.RestrictTo;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TimeUtils {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

    private static int accumField(int r5, int r10, boolean r11, int r12) {
        if (r5 > 99) goto L22;
        if (r11 == false) goto L8;
        if (r12 >= 3) goto L22;
    L8:
        if (r5 > 9) goto L20;
        if (r11 == false) goto L12;
        if (r12 >= 2) goto L20;
    L12:
        if (r11 == true) goto L18;
        if (r5 > 0) goto L18;
        return 0;
    L18:
        return r10 + 1;
    L20:
        return r10 + 2;
    L22:
        return r10 + 3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long r5, StringBuilder r10) {
        Object r11 = sFormatSync;
        monitor-enter(r11);
        int r12 = formatDurationLocked(r5, 0);     // Catch: Throwable -> L8
        r10.append(sFormatStr, 0, r12);     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static int formatDurationLocked(long r17, int r19) {
        long r5 = r17;
        if (sFormatStr.length >= r19) goto L5;
        sFormatStr = new char[r19];
    L5:
        char[] r10 = sFormatStr;
        if (r5 != 0) goto L12;
        int r11 = r19 - 1;
    L8:
        if (r11 <= 0) goto L10;
        r10[0] = ' ';
        goto L8
    L10:
        r10[0] = '0';
        return 1;
    L12:
        if (r5 <= 0) goto L14;
        char r12 = '+';
    L15:
        int r13 = (int) (r5 % 1000);
        int r14 = (int) Math.floor(r5 / 1000);
        if (r14 <= SECONDS_PER_DAY) goto L18;
        int r15 = r14 / SECONDS_PER_DAY;
        r14 = r14 - (SECONDS_PER_DAY * r15);
    L20:
        if (r14 <= SECONDS_PER_HOUR) goto L22;
        int r16 = r14 / SECONDS_PER_HOUR;
        r14 = r14 - (r16 * SECONDS_PER_HOUR);
    L24:
        if (r14 <= 60) goto L26;
        int r18 = r14 / 60;
        int r110 = r14 - (r18 * 60);
        int r20 = r18;
    L28:
        if (r19 == 0) goto L48;
        int r21 = accumField(r15, 1, false, 0);
        if (r21 <= 0) goto L32;
        boolean r22 = true;
    L33:
        int r23 = r21 + accumField(r16, 1, r22, 2);
        if (r23 <= 0) goto L36;
        boolean r24 = true;
    L37:
        int r25 = r23 + accumField(r20, 1, r24, 2);
        if (r25 <= 0) goto L40;
        boolean r26 = true;
    L41:
        int r27 = r25 + accumField(r110, 1, r26, 2);
        if (r27 <= 0) goto L44;
        int r28 = 3;
    L45:
        int r29 = (accumField(r13, 2, true, r28) + 1) + r27;
        int r30 = 0;
    L46:
        if (r29 >= r19) goto L49;
        r10[r30] = ' ';
        r30 = r30 + 1;
        r29 = r29 + 1;
    L49:
        r10[r30] = r12;
        int r31 = r30 + 1;
        if (r19 == 0) goto L52;
        boolean r32 = true;
    L53:
        int r33 = printField(r10, r15, 'd', r31, false, 0);
        if (r33 == r31) goto L56;
        boolean r34 = true;
    L57:
        if (r32 == false) goto L59;
        int r35 = 2;
    L60:
        int r36 = printField(r10, r16, 'h', r33, r34, r35);
        if (r36 == r31) goto L63;
        boolean r37 = true;
    L64:
        if (r32 == false) goto L66;
        int r38 = 2;
    L67:
        int r39 = printField(r10, r20, 'm', r36, r37, r38);
        if (r39 == r31) goto L70;
        boolean r40 = true;
    L71:
        if (r32 == false) goto L73;
        int r41 = 2;
    L74:
        int r42 = printField(r10, r110, 's', r39, r40, r41);
        if (r32 == false) goto L78;
        if (r42 == r31) goto L78;
        int r43 = 3;
    L79:
        int r44 = printField(r10, r13, 'm', r42, true, r43);
        r10[r44] = 's';
        return r44 + 1;
    L78:
        r43 = 0;
        goto L79
    L73:
        r41 = 0;
        goto L74
    L70:
        r40 = false;
        goto L71
    L66:
        r38 = 0;
        goto L67
    L63:
        r37 = false;
        goto L64
    L59:
        r35 = 0;
        goto L60
    L56:
        r34 = false;
        goto L57
    L52:
        r32 = false;
        goto L53
    L44:
        r28 = 0;
        goto L45
    L40:
        r26 = false;
        goto L41
    L36:
        r24 = false;
        goto L37
    L32:
        r22 = false;
        goto L33
    L48:
        r30 = 0;
        goto L49
    L26:
        r110 = r14;
        r20 = 0;
        goto L28
    L22:
        r16 = 0;
        goto L24
    L18:
        r15 = 0;
        goto L20
    L14:
        r5 = -r5;
        r12 = '-';
        goto L15
    }

    private static int printField(char[] r5, int r10, char r11, int r12, boolean r13, int r14) {
        if (r13 == true) goto L4;
        if (r10 > 0) goto L4;
        return r12;
    L4:
        if (r13 == false) goto L8;
        if (r14 < 3) goto L8;
    L9:
        int r15 = r10 / 100;
        r5[r12] = (char) (r15 + 48);
        int r16 = r12 + 1;
        r10 = r10 - (r15 * 100);
    L12:
        if (r13 == false) goto L15;
        if (r14 < 2) goto L15;
    L17:
        int r17 = r10 / 10;
        r5[r16] = (char) (r17 + 48);
        r16 = r16 + 1;
        r10 = r10 - (r17 * 10);
    L18:
        r5[r16] = (char) (r10 + 48);
        r5[r16 + 1] = r11;
        return r16 + 2;
    L15:
        if (r10 > 9) goto L17;
        if (r12 == r16) goto L18;
    L8:
        if (r10 > 99) goto L9;
        r16 = r12;
        goto L12
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long r5, PrintWriter r10, int r11) {
        Object r12 = sFormatSync;
        monitor-enter(r12);
        int r13 = formatDurationLocked(r5, r11);     // Catch: Throwable -> L7
        r10.print(new String(sFormatStr, 0, r13));     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long r5, PrintWriter r10) {
        formatDuration(r5, r10, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long r5, long r10, PrintWriter r11) {
        if (r5 != 0) goto L6;
        r11.print("--");
        return;
    L6:
        formatDuration(r5 - r10, r11, 0);
    }
}
