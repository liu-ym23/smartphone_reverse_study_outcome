package r6;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static File a(Context r10) {
        String r11 = r10.getApplicationInfo().dataDir + "/shared_prefs";
        String r12 = r10.getApplicationInfo().dataDir + "/spFiles";
        String r13 = r12 + File.separator + "/tmp";
        File r14 = new File(r11);
        if (r14.exists() == false) goto L18;
        File[] r15 = r14.listFiles();
        int r16 = r15.length;
        int r17 = 0;
    L5:
        if (r17 >= r16) goto L18;
        File r18 = r15[r17];
        String r19 = r18.getName();
        if (r19.endsWith(".xml") == false) goto L11;
        if (com.monitor.cloudmessage.utils.b.e(r18.getAbsolutePath(), r13, r19) == true) goto L11;
        return null;
    L11:
        r17 = r17 + 1;
    L18:
        StringBuilder r20 = new StringBuilder();     // Catch: Exception -> L15
        r20.append(r12);     // Catch: Exception -> L15
        String r21 = File.separator;     // Catch: Exception -> L15
        r20.append(r21);     // Catch: Exception -> L15
        r20.append("sp.zip");     // Catch: Exception -> L15
        com.monitor.cloudmessage.utils.b.n(r13, r20.toString());     // Catch: Exception -> L15
        com.monitor.cloudmessage.utils.b.k(r13);
        return new File(r12 + r21 + "sp.zip");
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
