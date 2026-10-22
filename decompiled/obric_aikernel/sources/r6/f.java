package r6;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f12699a;

    static {
    }

    public static Map<String, Boolean> a(Context r10) {
        HashMap r11 = new HashMap();
        String[] r12 = f12699a;
        if (r12 == null) goto L7;
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L7;
        String r15 = r12[r14];
        r11.put(r15, Boolean.valueOf(com.monitor.cloudmessage.utils.c.a(r10, r15)));
        r14 = r14 + 1;
    L7:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static File b(Context r10) {
        BufferedWriter r11 = 0;
        r11 = 0;
        f12699a = r10.getPackageManager().getPackageInfo(r10.getPackageName(), 4096).requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L52
        StringBuilder r12 = new StringBuilder();
        r12.append(com.monitor.cloudmessage.utils.b.h(r10).getAbsolutePath());
        String r13 = File.separator;
        r12.append(r13);
        r12.append("permissionInfo");
        String r14 = r12.toString();
        String r15 = r14 + r13 + "permission.txt";
        File r16 = new File(r14);     // Catch: Throwable -> L27 IOException -> L29
        if (r16.exists() == true) goto L8;
        r16.mkdirs();     // Catch: Throwable -> L27 IOException -> L29
    L8:
        FileWriter r17 = new FileWriter(r14 + r13 + "permission.txt");     // Catch: Throwable -> L27 IOException -> L29
        BufferedWriter r18 = new BufferedWriter(r17);     // Catch: Throwable -> L23 IOException -> L25
        Iterator<Map.Entry<String, Boolean>> r19 = a(r10).entrySet().iterator();     // Catch: IOException -> L21 Throwable -> L41
    L12:
        if (r19.hasNext() == false) goto L57;
        Map.Entry<String, Boolean> r20 = r19.next();     // Catch: IOException -> L21 Throwable -> L41
        r18.write(String.format("permission: %s, result: %b\n", new Object[]{r20.getKey(), r20.getValue()}));     // Catch: IOException -> L21 Throwable -> L41
        goto L12
    L57:
        r18.close();     // Catch: IOException -> L17
        r17.close();     // Catch: IOException -> L17
    L20:
        return new File(r15);
    L17:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = e;
    L31:
        e.printStackTrace();     // Catch: Throwable -> L41
        if (r18 != null) goto L55;
    L36:
        if (r17 == null) goto L40;
        r17.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L40:
        return null;
    L55:
        r18.close();     // Catch: IOException -> L34
        goto L36
    L25:
        e = e;
        r18 = null;
    L23:
        th = th;
    L43:
        if (r11 != 0) goto L64;
    L47:
        if (r17 == null) goto L51;
        r17.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L64:
        r11.close();     // Catch: IOException -> L45
        goto L47
    L41:
        th = th;
        r11 = r14;
    L29:
        e = e;
        r18 = null;
        r17 = null;
    L27:
        th = th;
        r17 = null;
    L52:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
