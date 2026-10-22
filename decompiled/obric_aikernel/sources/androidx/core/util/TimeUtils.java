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

    private static int accumField(int r10, int r11, boolean r12, int r13) {
        if (r10 > 99) goto L22;
        if (r12 == false) goto L8;
        if (r13 >= 3) goto L22;
    L8:
        if (r10 > 9) goto L20;
        if (r12 == false) goto L12;
        if (r13 >= 2) goto L20;
    L12:
        if (r12 == true) goto L18;
        if (r10 > 0) goto L18;
        return 0;
    L18:
        return r11 + 1;
    L20:
        return r11 + 2;
    L22:
        return r11 + 3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long r10, long r11, PrintWriter r12) {
        if (r10 != 0) goto L6;
        r12.print("--");
        return;
    L6:
        formatDuration(r10 - r11, r12, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long r10, PrintWriter r11) {
        formatDuration(r10, r11, 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long r10, PrintWriter r11, int r12) {
        Object r13 = sFormatSync;
        monitor-enter(r13);
        int r14 = formatDurationLocked(r10, r12);     // Catch: Throwable -> L7
        r11.print(new String(sFormatStr, 0, r14));     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void formatDuration(long r10, StringBuilder r11) {
        Object r12 = sFormatSync;
        monitor-enter(r12);
        int r13 = formatDurationLocked(r10, 0);     // Catch: Throwable -> L8
        r11.append(sFormatStr, 0, r13);     // Catch: Throwable -> L8
        monitor-exit(r12);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static int formatDurationLocked(long r17, int r19) {
        long r10 = r17;
        if (sFormatStr.length >= r19) goto L5;
        sFormatStr = new char[r19];
    L5:
        char[] r11 = sFormatStr;
        if (r10 != 0) goto L12;
        int r12 = r19 - 1;
    L8:
        if (r12 <= 0) goto L10;
        r11[0] = ' ';
        goto L8
    L10:
        r11[0] = '0';
        return 1;
    L12:
        if (r10 <= 0) goto L14;
        char r13 = '+';
    L15:
        int r14 = (int) (r10 % 1000);
        int r15 = (int) Math.floor(r10 / 1000);
        if (r15 <= SECONDS_PER_DAY) goto L18;
        int r16 = r15 / SECONDS_PER_DAY;
        r15 = r15 - (SECONDS_PER_DAY * r16);
    L20:
        if (r15 <= SECONDS_PER_HOUR) goto L22;
        int r18 = r15 / SECONDS_PER_HOUR;
        r15 = r15 - (r18 * SECONDS_PER_HOUR);
    L24:
        if (r15 <= 60) goto L26;
        int r20 = r15 / 60;
        int r110 = r15 - (r20 * 60);
        int r21 = r20;
    L28:
        if (r19 == 0) goto L48;
        int r22 = accumField(r16, 1, false, 0);
        if (r22 <= 0) goto L32;
        boolean r23 = true;
    L33:
        int r24 = r22 + accumField(r18, 1, r23, 2);
        if (r24 <= 0) goto L36;
        boolean r25 = true;
    L37:
        int r26 = r24 + accumField(r21, 1, r25, 2);
        if (r26 <= 0) goto L40;
        boolean r27 = true;
    L41:
        int r28 = r26 + accumField(r110, 1, r27, 2);
        if (r28 <= 0) goto L44;
        int r29 = 3;
    L45:
        int r30 = r28 + (accumField(r14, 2, true, r29) + 1);
        int r31 = 0;
    L46:
        if (r30 >= r19) goto L49;
        r11[r31] = ' ';
        r31 = r31 + 1;
        r30 = r30 + 1;
    L49:
        r11[r31] = r13;
        int r32 = r31 + 1;
        if (r19 == 0) goto L52;
        boolean r33 = true;
    L53:
        int r34 = printField(r11, r16, 'd', r32, false, 0);
        if (r34 == r32) goto L56;
        boolean r35 = true;
    L57:
        if (r33 == false) goto L59;
        int r36 = 2;
    L60:
        int r37 = printField(r11, r18, 'h', r34, r35, r36);
        if (r37 == r32) goto L63;
        boolean r38 = true;
    L64:
        if (r33 == false) goto L66;
        int r39 = 2;
    L67:
        int r40 = printField(r11, r21, 'm', r37, r38, r39);
        if (r40 == r32) goto L70;
        boolean r41 = true;
    L71:
        if (r33 == false) goto L73;
        int r42 = 2;
    L74:
        int r43 = printField(r11, r110, 's', r40, r41, r42);
        if (r33 == false) goto L78;
        if (r43 == r32) goto L78;
        int r44 = 3;
    L79:
        int r45 = printField(r11, r14, 'm', r43, true, r44);
        r11[r45] = 's';
        return r45 + 1;
    L78:
        r44 = 0;
        goto L79
    L73:
        r42 = 0;
        goto L74
    L70:
        r41 = false;
        goto L71
    L66:
        r39 = 0;
        goto L67
    L63:
        r38 = false;
        goto L64
    L59:
        r36 = 0;
        goto L60
    L56:
        r35 = false;
        goto L57
    L52:
        r33 = false;
        goto L53
    L44:
        r29 = 0;
        goto L45
    L40:
        r27 = false;
        goto L41
    L36:
        r25 = false;
        goto L37
    L32:
        r23 = false;
        goto L33
    L48:
        r31 = 0;
        goto L49
    L26:
        r110 = r15;
        r21 = 0;
        goto L28
    L22:
        r18 = 0;
        goto L24
    L18:
        r16 = 0;
        goto L20
    L14:
        r13 = '-';
        r10 = -r10;
        goto L15
    }

    private static int printField(char[] r10, int r11, char r12, int r13, boolean r14, int r15) {
        if (r14 == true) goto L4;
        if (r11 > 0) goto L4;
        return r13;
    L4:
        if (r14 == false) goto L8;
        if (r15 < 3) goto L8;
    L9:
        int r16 = r11 / 100;
        r10[r13] = (char) (r16 + 48);
        int r17 = r13 + 1;
        r11 = r11 - (r16 * 100);
    L11:
        if (r14 == false) goto L15;
        if (r15 < 2) goto L15;
    L17:
        int r18 = r11 / 10;
        r10[r17] = (char) (r18 + 48);
        r17 = r17 + 1;
        r11 = r11 - (r18 * 10);
    L18:
        r10[r17] = (char) (r11 + 48);
        int r19 = r17 + 1;
        r10[r19] = r12;
        return r19 + 1;
    L15:
        if (r11 > 9) goto L17;
        if (r13 == r17) goto L18;
    L8:
        if (r11 > 99) goto L9;
        r17 = r13;
        goto L11
    }
}
