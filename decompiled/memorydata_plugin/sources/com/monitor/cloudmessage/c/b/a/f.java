package com.monitor.cloudmessage.c.b.a;

import android.content.Context;
import android.content.pm.PackageManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f5845a;

    static {
    }

    public static Map<String, Boolean> a(Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        HashMap r0 = new HashMap();
        String[] r1 = f5845a;
        if (r1 == null) goto L7;
        int r2 = r1.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L7;
        String r4 = r1[r3];
        r0.put(r4, Boolean.valueOf(com.monitor.cloudmessage.utils.d.a(r7, r4)));
        r3 = r3 + 1;
    L7:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public static File b(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        ?? r0 = 0;
        r0 = 0;
        f5845a = r11.getPackageManager().getPackageInfo(r11.getPackageName(), 4096).requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L52
        String r2 = com.monitor.cloudmessage.utils.c.a(r11).getAbsolutePath() + File.separator + "permissionInfo";
        String r3 = r2 + File.separator + "permission.txt";
        File r5 = new File(r2);     // Catch: Throwable -> L27 IOException -> L29
        if (r5.exists() == true) goto L8;
        r5.mkdirs();     // Catch: Throwable -> L27 IOException -> L29
    L8:
        FileWriter r6 = new FileWriter(r2 + File.separator + "permission.txt");     // Catch: Throwable -> L27 IOException -> L29
    L67:
        BufferedWriter r4 = new BufferedWriter(r6);     // Catch: Throwable -> L23 IOException -> L25
        Iterator<Map.Entry<String, Boolean>> r12 = a(r11).entrySet().iterator();     // Catch: IOException -> L21 Throwable -> L41
    L12:
        if (r12.hasNext() == false) goto L62;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r12.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L21 Throwable -> L41
        r4.write(String.format("permission: %s, result: %b\n", new Object[]{r7.getKey(), r7.getValue()}));     // Catch: IOException -> L21 Throwable -> L41
        goto L12
    L62:
        r4.close();     // Catch: IOException -> L17
        r6.close();     // Catch: IOException -> L17
    L20:
        return new File(r3);
    L17:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = e;
    L31:
        e.printStackTrace();     // Catch: Throwable -> L41
        if (r4 != null) goto L60;
    L36:
        if (r6 == null) goto L40;
        r6.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
    L40:
        return null;
    L60:
        r4.close();     // Catch: IOException -> L34
        goto L36
    L25:
        e = e;
        r4 = null;
    L23:
        th = th;
    L43:
        if (r0 != 0) goto L55;
    L47:
        if (r6 == null) goto L51;
        r6.close();     // Catch: IOException -> L45
    L45:
        e = move-exception;
        e.printStackTrace();
    L51:
        throw th;
    L55:
        r0.close();     // Catch: IOException -> L45
    L41:
        th = th;
        r0 = r2;
    L29:
        e = e;
        r4 = null;
        r6 = null;
    L27:
        th = th;
        r6 = null;
    L52:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
