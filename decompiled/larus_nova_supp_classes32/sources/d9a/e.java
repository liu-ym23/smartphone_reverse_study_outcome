package d9a;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static PolarisFileWrapper a(Context r9) {
        String r1 = r9.getApplicationInfo().dataDir + "/shared_prefs";
        String r10 = r9.getApplicationInfo().dataDir + "/spFiles";
        String r2 = r10 + File.separator + "/tmp";
        PolarisFileWrapper r3 = new PolarisFileWrapper(r1);
        if (r3.exists() == false) goto L18;
        File[] r4 = r3.listFiles();
        int r5 = r4.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L18;
        File r7 = r4[r6];
        String r8 = r7.getName();
        if (r8.endsWith(".xml") == false) goto L11;
        if (com.monitor.cloudmessage.utils.a.c(r7.getAbsolutePath(), r2, r8) == true) goto L11;
        return null;
    L11:
        r6 = r6 + 1;
    L18:
        StringBuilder r11 = new StringBuilder();     // Catch: Exception -> L15
        r11.append(r10);     // Catch: Exception -> L15
        String r12 = File.separator;     // Catch: Exception -> L15
        r11.append(r12);     // Catch: Exception -> L15
        r11.append("sp.zip");     // Catch: Exception -> L15
        com.monitor.cloudmessage.utils.a.i(r2, r11.toString());     // Catch: Exception -> L15
        com.monitor.cloudmessage.utils.a.g(r2);
        return new PolarisFileWrapper(r10 + r12 + "sp.zip");
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
