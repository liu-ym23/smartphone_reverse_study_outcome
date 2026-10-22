package r6;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f12696a = "db.zip";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12697b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f12698c;

    static {
    }

    public static void a(Context r10) {
        com.monitor.cloudmessage.utils.b.k(r10.getApplicationInfo().dataDir + File.separator + "dbFiles");
    }

    public static File b(Context r10, String r11) {
        if (TextUtils.isEmpty(r11) == true) goto L5;
        f12697b = true;
        f12698c = r11;
    L5:
        StringBuilder r12 = new StringBuilder();
        r12.append(r10.getApplicationInfo().dataDir);
        String r13 = File.separator;
        r12.append(r13);
        r12.append("databases");
        String r14 = r12.toString();
        String r15 = r10.getApplicationInfo().dataDir + r13 + "dbFiles";
        String r16 = r15 + r13 + "/tmp";
        File r17 = new File(r14);
        if (r17.exists() == false) goto L32;
        File[] r18 = r17.listFiles();
        int r19 = r18.length;
        int r20 = 0;
    L8:
        if (r20 >= r19) goto L32;
        File r21 = r18[r20];
        String r22 = r21.getName();
        if (r22.endsWith(".db") == false) goto L17;
        if (f12697b == true) goto L17;
        if (com.monitor.cloudmessage.utils.b.e(r21.getAbsolutePath(), r16, r22) == true) goto L17;
        return null;
    L17:
        if (f12697b == false) goto L25;
        if (TextUtils.isEmpty(f12698c) == true) goto L25;
        if (f12698c.equals(r22) == false) goto L25;
        if (com.monitor.cloudmessage.utils.b.e(r21.getAbsolutePath(), r16, r22) == true) goto L25;
        return null;
    L25:
        r20 = r20 + 1;
    L32:
        StringBuilder r23 = new StringBuilder();     // Catch: Exception -> L29
        r23.append(r15);     // Catch: Exception -> L29
        String r24 = File.separator;     // Catch: Exception -> L29
        r23.append(r24);     // Catch: Exception -> L29
        r23.append(f12696a);     // Catch: Exception -> L29
        com.monitor.cloudmessage.utils.b.n(r16, r23.toString());     // Catch: Exception -> L29
        com.monitor.cloudmessage.utils.b.k(r16);
        return new File(r15 + r24 + f12696a);
    L29:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
