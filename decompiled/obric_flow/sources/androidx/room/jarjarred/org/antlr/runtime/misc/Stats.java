package androidx.room.jarjarred.org.antlr.runtime.misc;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Stats {
    public static final String ANTLRWORKS_DIR = "antlrworks";

    public Stats() {
    }

    public static double avg(int[] r10) {
        int r5 = r10.length;
        if (r5 != 0) goto L5;
        return 0.0d;
    L5:
        int r11 = 0;
        double r12 = 0.0d;
    L6:
        if (r11 >= r5) goto L9;
        r12 = r12 + ((double) r10[r11]);
        r11 = r11 + 1;
        goto L6
    L9:
        if (r12 >= 0.0d) goto L11;
        return 0.0d;
    L11:
        return r12 / ((double) r5);
    }

    public static String getAbsoluteFileName(String r5) {
        StringBuilder r10 = new StringBuilder();
        r10.append(System.getProperty("user.home"));
        String r11 = File.separator;
        return a.u(r10, r11, ANTLRWORKS_DIR, r11, r5);
    }

    public static int max(int[] r5) {
        int r10 = r5.length;
        int r11 = 0;
        if (r10 != 0) goto L5;
        return 0;
    L5:
        int r12 = Integer.MIN_VALUE;
    L6:
        if (r11 >= r10) goto L11;
        int r13 = r5[r11];
        if (r13 <= r12) goto L10;
        r12 = r13;
    L10:
        r11 = r11 + 1;
        goto L6
    L11:
        return r12;
    }

    public static int min(int[] r5) {
        int r10 = r5.length;
        int r11 = 0;
        if (r10 != 0) goto L5;
        return 0;
    L5:
        int r12 = Integer.MAX_VALUE;
    L6:
        if (r11 >= r10) goto L11;
        int r13 = r5[r11];
        if (r13 >= r12) goto L10;
        r12 = r13;
    L10:
        r11 = r11 + 1;
        goto L6
    L11:
        return r12;
    }

    public static double stddev(int[] r14) {
        int r5 = r14.length;
        if (r5 > 1) goto L5;
        return 0.0d;
    L5:
        double r12 = avg(r14);
        double r10 = 0.0d;
        int r11 = 0;
    L6:
        if (r11 >= r5) goto L9;
        int r13 = r14[r11];
        r10 = j0.a(r13, r12, ((double) r13) - r12, r10);
        r11 = r11 + 1;
        goto L6
    L9:
        return Math.sqrt(r10 / ((double) (r5 - 1)));
    }

    public static int sum(int[] r5) {
        int r10 = r5.length;
        int r11 = 0;
        if (r10 != 0) goto L5;
        return 0;
    L5:
        int r12 = 0;
    L6:
        if (r11 >= r10) goto L8;
        r12 = r12 + r5[r11];
        r11 = r11 + 1;
        goto L6
    L8:
        return r12;
    }

    public static void writeReport(String r5, String r10) throws IOException {
        File r11 = new File(getAbsoluteFileName(r5));
        r11.getParentFile().mkdirs();
        FileOutputStream r12 = new FileOutputStream(r11, true);
        BufferedOutputStream r13 = new BufferedOutputStream(r12);
        PrintStream r14 = new PrintStream(r13);
        r14.println(r10);
        r14.close();
        r13.close();
        r12.close();
    }

    public static double avg(List<Integer> r10) {
        int r5 = r10.size();
        if (r5 != 0) goto L5;
        return 0.0d;
    L5:
        int r11 = 0;
        double r12 = 0.0d;
    L6:
        if (r11 >= r5) goto L9;
        r12 = r12 + ((double) r10.get(r11).intValue());
        r11 = r11 + 1;
        goto L6
    L9:
        if (r12 >= 0.0d) goto L11;
        return 0.0d;
    L11:
        return r12 / ((double) r5);
    }

    public static int max(List<Integer> r5) {
        int r10 = r5.size();
        int r11 = 0;
        if (r10 != 0) goto L5;
        return 0;
    L5:
        int r12 = Integer.MIN_VALUE;
    L6:
        if (r11 >= r10) goto L11;
        if (r5.get(r11).intValue() <= r12) goto L10;
        r12 = r5.get(r11).intValue();
    L10:
        r11 = r11 + 1;
        goto L6
    L11:
        return r12;
    }

    public static int min(List<Integer> r5) {
        int r10 = r5.size();
        int r11 = 0;
        if (r10 != 0) goto L5;
        return 0;
    L5:
        int r12 = Integer.MAX_VALUE;
    L6:
        if (r11 >= r10) goto L11;
        if (r5.get(r11).intValue() >= r12) goto L10;
        r12 = r5.get(r11).intValue();
    L10:
        r11 = r11 + 1;
        goto L6
    L11:
        return r12;
    }
}
