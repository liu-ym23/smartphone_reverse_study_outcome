package n5;

import android.os.Process;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f11254a = -1;

    static class a implements FilenameFilter {
        a() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            Long.parseLong(r11);     // Catch: NumberFormatException -> L5
            return true;
        L5:
            return false;
        }
    }

    static {
    }

    public static int a() {
        if (f11254a != (-1)) goto L6;
        f11254a = Process.myPid();
    L6:
        return f11254a;
    }

    private static ArrayList<Long> b(String r10) {
        ArrayList<Long> r11 = new ArrayList();
        File[] r12 = new File(r10).listFiles(new a());
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L5;
        r11.add(Long.valueOf(Long.parseLong(r12[r14].getName())));
        r14 = r14 + 1;
        goto L3
    L5:
        return r11;
    }

    public static ArrayList<Long> c() {
        return b("/proc/self/task/");
    }
}
