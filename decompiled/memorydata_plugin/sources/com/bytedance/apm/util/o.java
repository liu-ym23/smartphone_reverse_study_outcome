package com.bytedance.apm.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f1496a;

    static {
    }

    private static String a() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r2 = new StringBuilder(32);     // Catch: Throwable -> L14
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L14
        if (r3 <= 0) goto L8;
        r2.append((char) r3);     // Catch: Throwable -> L14
        goto L5
    L8:
        String r0 = r2.toString();     // Catch: Throwable -> L14
        com.bytedance.monitor.util.d.a(r1);
        return r0;
    L12:
        com.bytedance.monitor.util.d.a(r1);
        return null;
    L11:
        r1 = null;
        goto L12
    }

    public static String a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        String r4 = f1496a;
        if (TextUtils.isEmpty(r4) == true) goto L5;
        return r4;
    L5:
        String r5 = a();
        f1496a = r5;
        if (r5 != null) goto L9;
        return "";
    L9:
        return r5;
    }
}
