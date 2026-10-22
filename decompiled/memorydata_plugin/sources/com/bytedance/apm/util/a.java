package com.bytedance.apm.util;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Boolean f1479b;

    static {
    }

    public static String a(int r5) {
        if (TextUtils.isEmpty(f1478a) == true) goto L45;
        return f1478a;
    L45:
        BufferedReader r1 = new BufferedReader(new FileReader("/proc/" + r5 + "/cmdline"));     // Catch: Throwable -> L19
        String r6 = r1.readLine();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r6) == true) goto L11;
        r6 = r6.trim();     // Catch: Throwable -> L17
    L11:
        f1478a = r6;     // Catch: Throwable -> L17
        r1.close();     // Catch: IOException -> L14
    L16:
        return r6;
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
    L43:
        th.printStackTrace();     // Catch: Throwable -> L28
        if (r1 != null) goto L35;
    L27:
        return null;
    L35:
        r1.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L28:
        th = move-exception;
        if (r1 != null) goto L39;
    L34:
        throw th;
    L39:
        r1.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r1 = null;
        goto L43
    }

    public static boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        String r0 = a(Process.myPid());
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.equals(r4.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR) == false) goto L7;
        return false;
    }
}
