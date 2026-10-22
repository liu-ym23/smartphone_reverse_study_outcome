package m5;

import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    public e() {
        this("/proc/self/time_in_state");
    }

    public e(int r10) {
        super("/proc/self/task/" + r10 + "/time_in_state");
    }

    public e(String r10) {
        super(r10);
    }

    private b c(File r14) {
        BufferedReader r13 = n5.c.b(r14);
        if (r13 != null) goto L5;
        return null;
    L5:
        k5.e r10 = new k5.e();
        LinkedHashMap<Long, Long> r11 = null;
        long r12 = 0;
    L33:
        String r15 = r13.readLine();     // Catch: Exception -> L27 Throwable -> L31
        if (r15 == null) goto L24;
        if (r15.isEmpty() == true) goto L33;
        if (r15.contains("cpu") == true) goto L33;
        String[] r16 = r15.split(" ");     // Catch: Exception -> L27 Throwable -> L31
        if (r16.length <= 1) goto L24;
        long r17 = Long.parseLong(r16[0]);     // Catch: Exception -> L27 Throwable -> L31
        long r18 = Long.parseLong(r16[1]) * 10;     // Catch: Exception -> L27 Throwable -> L31
        if (r12 != 0) goto L19;
    L21:
        if (r11 != null) goto L23;
        r11 = new LinkedHashMap();     // Catch: Exception -> L27 Throwable -> L31
    L23:
        r11.put(Long.valueOf(r17), Long.valueOf(r18));     // Catch: Exception -> L27 Throwable -> L31
        r12 = r17;
        goto L33
    L19:
        if (r17 >= r12) goto L21;
        r10.a(r11);     // Catch: Exception -> L27 Throwable -> L31
        r11 = null;
    L24:
        r10.a(r11);     // Catch: Exception -> L27 Throwable -> L31
        n5.c.a(r13);
        return r10;
    L31:
        n5.c.a(r13);
        return r10;
    L27:
        e = move-exception;
        n5.b.c(Log.getStackTraceString(e));     // Catch: Throwable -> L31
        n5.c.a(r13);
        return r10;
    }

    @Override // m5.a
    protected b a(File r10) {
        return c(r10);
    }
}
