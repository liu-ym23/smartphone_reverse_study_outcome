package com.bytedance.crash.dumper.tools;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.FileSystemUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class ThrowableDumper {
    private static final char[] CAUSE_CAPTION = null;
    private static final char CR = '\n';
    private static final String FILE_NAME = "throwable.txt";
    private static final int MAX_LINES = 256;
    private static final char[] SPACE_MORE_CR = null;
    private static final char[] SPACE_SKIP_CR = null;
    private static final char[] SUPPRESSED_CAPTION = null;
    private static final char[] TAB_3_DOT_SPACE = null;
    private static final char[] TAB_AT_SPACE = null;
    private static final boolean mHasSuppressed = false;

    static {
        CAUSE_CAPTION = new char[]{'C', 'a', 'u', 's', 'e', 'd', ' ', 'b', 'y', ':', ' '};
        SUPPRESSED_CAPTION = new char[]{'S', 'u', 'p', 'p', 'r', 'e', 's', 's', 'e', 'd', ':', ' '};
        TAB_AT_SPACE = new char[]{'\t', 'a', 't', ' '};
        TAB_3_DOT_SPACE = new char[]{'\t', '.', '.', '.', ' '};
        SPACE_MORE_CR = new char[]{' ', 'm', 'o', 'r', 'e', CR};
        SPACE_SKIP_CR = new char[]{' ', 's', 'k', 'i', 'p', CR};
        if (Build.VERSION.SDK_INT < 19) goto L5;
        boolean r0 = true;
    L6:
        mHasSuppressed = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public ThrowableDumper() {
    }

    private static void appendStackTraceElements(StackBuilder r4, StackTraceElement[] r5, int r6) {
        int r0 = 0;
        if (r6 > 256) goto L5;
    L10:
        if (r0 >= r6) goto L16;
        r4.append(TAB_AT_SPACE).append(r5[r0]).append(CR);
        r0 = r0 + 1;
        goto L10
    L16:
        return;
    L5:
        if (r0 >= 128) goto L7;
        r4.append(TAB_AT_SPACE).append(r5[r0]).append(CR);
        r0 = r0 + 1;
        goto L5
    L7:
        r4.append(TAB_3_DOT_SPACE).append(r6 + InputDeviceCompat.SOURCE_ANY).append(SPACE_SKIP_CR);
        int r1 = r6 - 128;
    L8:
        if (r1 >= r6) goto L12;
        r4.append(TAB_AT_SPACE).append(r5[r1]).append(CR);
        r1 = r1 + 1;
        goto L8
    }

    public static void dump(File r2, Throwable r3) {
        StringDumper r0 = new StringDumper(r2.getAbsolutePath() + '/' + FILE_NAME);     // Catch: Throwable -> L4
        walkStackTrace(new StackBuilder(r0), r3);     // Catch: Throwable -> L4
        r0.release();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthMonitor.directReportInnerException("NPTH_DUMP", th);
    }

    public static String load(File r2) {
        return FileSystemUtils.readUtf8File(new File(r2, FILE_NAME));
    }

    private static void walkEnclosedStackTrace(StackBuilder r5, char[] r6, int r7, Throwable r8, Throwable r9) {
        StackTraceElement[] r10 = r9.getStackTrace();
        StackTraceElement[] r0 = r8.getStackTrace();
        int r1 = r0.length - 1;
        int r2 = r10.length - 1;
    L3:
        if (r1 < 0) goto L8;
        if (r2 < 0) goto L8;
        if (r0[r1].equals(r10[r2]) == false) goto L8;
        r1 = r1 - 1;
        r2 = r2 - 1;
    L8:
        int r11 = (r0.length - 1) - r1;
        r5.appendTabs(r7).append(r6).append(r8).append(CR);
        appendStackTraceElements(r5, r0, r0.length - r11);
        if (r11 == 0) goto L12;
        r5.appendTabs(r7).append(TAB_3_DOT_SPACE).append(r11).append(SPACE_MORE_CR);
    L12:
        if (mHasSuppressed == false) goto L16;
        Throwable[] r12 = r8.getSuppressed();
        int r13 = r12.length;
        int r3 = 0;
    L14:
        if (r3 >= r13) goto L16;
        walkEnclosedStackTrace(r5, SUPPRESSED_CAPTION, r7 + 1, r12[r3], r8);
        r3 = r3 + 1;
    L16:
        Throwable r14 = r8.getCause();
        if (r14 == null) goto L24;
        walkEnclosedStackTrace(r5, CAUSE_CAPTION, r7, r14, r8);
        return;
    }

    private static void walkStackTrace(StackBuilder r7, Throwable r8) {
        r7.append(r8).append(CR);
        StackTraceElement[] r0 = r8.getStackTrace();
        appendStackTraceElements(r7, r0, r0.length);
        if (mHasSuppressed == false) goto L7;
        Throwable[] r1 = r8.getSuppressed();
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        walkEnclosedStackTrace(r7, SUPPRESSED_CAPTION, 1, r1[r3], r8);
        r3 = r3 + 1;
    L7:
        Throwable r4 = r8.getCause();
        if (r4 == null) goto L12;
        walkEnclosedStackTrace(r7, CAUSE_CAPTION, 0, r4, r8);
        return;
    }
}
