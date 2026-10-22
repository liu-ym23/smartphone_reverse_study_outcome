package com.bytedance.crash.dumper.tools;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.crash.diagnose.NpthMonitor;
import com.bytedance.crash.util.FileSystemUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
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
        boolean r10 = true;
    L6:
        mHasSuppressed = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    public ThrowableDumper() {
    }

    private static void appendStackTraceElements(StackBuilder r10, StackTraceElement[] r11, int r12) {
        int r13 = 0;
        if (r12 > 256) goto L5;
    L10:
        if (r13 >= r12) goto L16;
        r10.append(TAB_AT_SPACE).append(r11[r13]).append(CR);
        r13 = r13 + 1;
        goto L10
    L16:
        return;
    L5:
        if (r13 >= 128) goto L7;
        r10.append(TAB_AT_SPACE).append(r11[r13]).append(CR);
        r13 = r13 + 1;
        goto L5
    L7:
        r10.append(TAB_3_DOT_SPACE).append(r12 + InputDeviceCompat.SOURCE_ANY).append(SPACE_SKIP_CR);
        int r14 = r12 - 128;
    L8:
        if (r14 >= r12) goto L12;
        r10.append(TAB_AT_SPACE).append(r11[r14]).append(CR);
        r14 = r14 + 1;
        goto L8
    }

    public static void dump(File r10, Throwable r11) {
        StringDumper r12 = new StringDumper(r10.getAbsolutePath() + '/' + FILE_NAME);     // Catch: Throwable -> L4
        walkStackTrace(new StackBuilder(r12), r11);     // Catch: Throwable -> L4
        r12.release();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        NpthMonitor.directReportInnerException("NPTH_DUMP", th);
    }

    public static String load(File r10) {
        return FileSystemUtils.readUtf8File(new File(r10, FILE_NAME));
    }

    private static void walkEnclosedStackTrace(StackBuilder r10, char[] r11, int r12, Throwable r13, Throwable r14) {
        StackTraceElement[] r15 = r14.getStackTrace();
        StackTraceElement[] r16 = r13.getStackTrace();
        int r17 = r16.length - 1;
        int r18 = r15.length - 1;
    L3:
        if (r17 < 0) goto L8;
        if (r18 < 0) goto L8;
        if (r16[r17].equals(r15[r18]) == false) goto L8;
        r17 = r17 - 1;
        r18 = r18 - 1;
    L8:
        int r19 = (r16.length - 1) - r17;
        r10.appendTabs(r12).append(r11).append(r13).append(CR);
        appendStackTraceElements(r10, r16, r16.length - r19);
        if (r19 == 0) goto L12;
        r10.appendTabs(r12).append(TAB_3_DOT_SPACE).append(r19).append(SPACE_MORE_CR);
    L12:
        if (mHasSuppressed == false) goto L16;
        Throwable[] r20 = r13.getSuppressed();
        int r21 = r20.length;
        int r22 = 0;
    L14:
        if (r22 >= r21) goto L16;
        walkEnclosedStackTrace(r10, SUPPRESSED_CAPTION, r12 + 1, r20[r22], r13);
        r22 = r22 + 1;
    L16:
        Throwable r23 = r13.getCause();
        if (r23 == null) goto L24;
        walkEnclosedStackTrace(r10, CAUSE_CAPTION, r12, r23, r13);
        return;
    }

    private static void walkStackTrace(StackBuilder r10, Throwable r11) {
        r10.append(r11).append(CR);
        StackTraceElement[] r12 = r11.getStackTrace();
        appendStackTraceElements(r10, r12, r12.length);
        if (mHasSuppressed == false) goto L7;
        Throwable[] r13 = r11.getSuppressed();
        int r14 = r13.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L7;
        walkEnclosedStackTrace(r10, SUPPRESSED_CAPTION, 1, r13[r15], r11);
        r15 = r15 + 1;
    L7:
        Throwable r16 = r11.getCause();
        if (r16 == null) goto L12;
        walkEnclosedStackTrace(r10, CAUSE_CAPTION, 0, r16, r11);
        return;
    }
}
