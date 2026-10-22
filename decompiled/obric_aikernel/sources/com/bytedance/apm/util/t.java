package com.bytedance.apm.util;

import android.content.Context;
import com.bytedance.apm6.util.IOUtils;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Properties f1148a;

    public static String a() {
        return String.valueOf(b("release_build"));
    }

    private static Object b(String r10) {
        c();
        Properties r11 = f1148a;     // Catch: Exception -> L9
        if (r11 != null) goto L6;
        return null;
    L6:
        if (r11.containsKey(r10) == false) goto L13;
        return f1148a.get(r10);
    L13:
        return null;
    L14:
        return null;
    }

    private static void c() {
        Context r10 = com.bytedance.apm.d.g();
        if (f1148a != null) goto L15;
        f1148a = new Properties();
        InputStream r11 = r10.getApplicationContext().getAssets().open("slardar.properties");     // Catch: Throwable -> L8
        f1148a.load(r11);     // Catch: Throwable -> L16
    L10:
        IOUtils.closeQuietly(r11);
        return;
    L21:
        f1148a = null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        IOUtils.closeQuietly(r11);
        throw th;
    L8:
        r11 = null;
        goto L21
    }
}
