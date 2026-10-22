package com.bytedance.monitor.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static void a(Closeable r2) {
        Closeable r3 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r2, Closeable.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.close();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static void a(String r2, int r3) {
        com.bytedance.monitor.util.a.a.a("android.os.FileUtils", "setPermissions", new Object[]{r2, Integer.valueOf(r3), -1, -1});
    }

    public static void a(ZipFile r0) {
        if (r0 != null) goto L7;
        return;
    L7:
        r0.close();     // Catch: Throwable -> L6
        return;
    }

    public static boolean a(String r1) {
        return new File(r1).mkdirs();
    }
}
