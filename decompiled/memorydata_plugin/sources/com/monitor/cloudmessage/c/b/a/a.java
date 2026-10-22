package com.monitor.cloudmessage.c.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f5843a = "db.zip";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f5844b = false;
    private static String c;

    static {
    }

    public static File a(Context r7, String r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r8) == true) goto L5;
        f5844b = true;
        c = r8;
    L5:
        String r10 = r9.getApplicationInfo().dataDir + File.separator + "databases";
        String r11 = r9.getApplicationInfo().dataDir + File.separator + "dbFiles";
        String r0 = r11 + File.separator + "/tmp";
        File r1 = new File(r10);
        if (r1.exists() == false) goto L32;
        File[] r12 = r1.listFiles();
        int r2 = r12.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L32;
        File r4 = r12[r3];
        String r5 = r4.getName();
        if (r5.endsWith(".db") == false) goto L17;
        if (f5844b == true) goto L17;
        if (com.monitor.cloudmessage.utils.c.a(r4.getAbsolutePath(), r0, r5) == true) goto L17;
        return null;
    L17:
        if (f5844b == false) goto L25;
        if (TextUtils.isEmpty(c) == true) goto L25;
        if (c.equals(r5) == false) goto L25;
        if (com.monitor.cloudmessage.utils.c.a(r4.getAbsolutePath(), r0, r5) == true) goto L25;
        return null;
    L25:
        r3 = r3 + 1;
    L32:
        com.monitor.cloudmessage.utils.c.a(r0, r11 + File.separator + f5843a);     // Catch: Exception -> L29
        com.monitor.cloudmessage.utils.c.a(r0);
        return new File(r11 + File.separator + f5843a);
    L29:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void a(Context r2) {
        com.monitor.cloudmessage.utils.c.a(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getApplicationInfo().dataDir + File.separator + "dbFiles");
    }
}
