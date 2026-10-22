package com.bytedance.apm.util;

import android.content.Context;
import com.bytedance.apm6.util.IOUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Properties f1499a;

    private static Object a(String r2) {
        b();
        Properties r1 = f1499a;     // Catch: Exception -> L9
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r1.containsKey(r2) == false) goto L13;
        return f1499a.get(r2);
    L13:
        return null;
    L14:
        return null;
    }

    public static String a() {
        return String.valueOf(a("release_build"));
    }

    private static void b() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        if (f1499a != null) goto L15;
        f1499a = new Properties();
        InputStream r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getAssets().open("slardar.properties");     // Catch: Throwable -> L8
        f1499a.load(r1);     // Catch: Throwable -> L16
    L10:
        IOUtils.closeQuietly(r1);
        return;
    L19:
        f1499a = null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        IOUtils.closeQuietly(r1);
        throw th;
    L8:
        r1 = null;
        goto L19
    }
}
