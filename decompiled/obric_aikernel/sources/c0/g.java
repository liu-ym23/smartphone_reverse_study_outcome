package c0;

import android.os.SystemClock;
import java.io.BufferedReader;
import java.io.FileReader;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static long a(int r10) {
        BufferedReader r11 = null;
        BufferedReader r12 = new BufferedReader(new FileReader("/proc/" + r10 + "/stat"));     // Catch: Throwable -> L13 Throwable -> L19
        String r13 = r12.readLine();     // Catch: Throwable -> L10 Throwable -> L12
        if (r13 == null) goto L9;
        long r14 = ((SystemClock.elapsedRealtime() * com.bytedance.apm.util.b.k(100)) / 1000) - Long.parseLong(r13.split(" ")[21]);
        x3.d.b(r12);
        return r14;
    L9:
        x3.d.b(r12);
        return -1;
    L12:
        r11 = r12;
    L10:
        th = th;
        r11 = r12;
    L14:
        x3.d.b(r11);
        throw th;
    L13:
        th = th;
    L16:
        x3.d.b(r11);
        return -1;
    }
}
