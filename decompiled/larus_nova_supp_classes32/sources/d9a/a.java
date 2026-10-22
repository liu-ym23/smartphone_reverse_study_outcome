package d9a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static boolean a;
    public static String b;

    public static PolarisFileWrapper a(Context r8, String r9) {
        if (TextUtils.isEmpty(r9) == true) goto L5;
        a = true;
        b = r9;
    L5:
        StringBuilder r10 = new StringBuilder();
        r10.append(r8.getApplicationInfo().dataDir);
        String r1 = File.separator;
        r10.append(r1);
        r10.append("databases");
        String r11 = r10.toString();
        String r12 = r8.getApplicationInfo().dataDir + r1 + "dbFiles";
        String r2 = r12 + r1 + "/tmp";
        PolarisFileWrapper r3 = new PolarisFileWrapper(r11);
        if (r3.exists() == false) goto L32;
        File[] r13 = r3.listFiles();
        int r4 = r13.length;
        int r5 = 0;
    L8:
        if (r5 >= r4) goto L32;
        File r6 = r13[r5];
        String r7 = r6.getName();
        if (r7.endsWith(".db") == false) goto L17;
        if (a == true) goto L17;
        if (com.monitor.cloudmessage.utils.a.c(r6.getAbsolutePath(), r2, r7) == true) goto L17;
        return null;
    L17:
        if (a == false) goto L25;
        if (TextUtils.isEmpty(b) == true) goto L25;
        if (b.equals(r7) == false) goto L25;
        if (com.monitor.cloudmessage.utils.a.c(r6.getAbsolutePath(), r2, r7) == true) goto L25;
        return null;
    L25:
        r5 = r5 + 1;
    L32:
        StringBuilder r14 = new StringBuilder();     // Catch: Exception -> L29
        r14.append(r12);     // Catch: Exception -> L29
        String r15 = File.separator;     // Catch: Exception -> L29
        r14.append(r15);     // Catch: Exception -> L29
        r14.append("db.zip");     // Catch: Exception -> L29
        com.monitor.cloudmessage.utils.a.i(r2, r14.toString());     // Catch: Exception -> L29
        com.monitor.cloudmessage.utils.a.g(r2);
        return new PolarisFileWrapper(r12 + r15 + "db.zip");
    L29:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
