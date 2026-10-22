package com.bytedance.apm.util;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1102a;

    static {
    }

    public static Application a(Context r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if ((r10 instanceof Application) == true) goto L10;
        r10 = r10.getApplicationContext();
    L10:
        return (Application) r10;
    }

    public static String b(int r10) {
        if (TextUtils.isEmpty(f1102a) == true) goto L39;
        return f1102a;
    L39:
        BufferedReader r11 = new BufferedReader(new FileReader("/proc/" + r10 + "/cmdline"));     // Catch: Throwable -> L19
        String r12 = r11.readLine();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r12) == true) goto L11;
        r12 = r12.trim();     // Catch: Throwable -> L17
    L11:
        f1102a = r12;     // Catch: Throwable -> L17
        r11.close();     // Catch: IOException -> L14
    L16:
        return r12;
    L14:
        e = move-exception;
        e.printStackTrace();
    L17:
        th = th;
    L37:
        th.printStackTrace();     // Catch: Throwable -> L28
        if (r11 != null) goto L41;
    L27:
        return null;
    L41:
        r11.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L28:
        th = move-exception;
        if (r11 != null) goto L45;
    L34:
        throw th;
    L45:
        r11.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
        r11 = null;
        goto L37
    }

    public static boolean c(Context r10) {
        String r11 = b(Process.myPid());
        if (r11 != null) goto L5;
    L7:
        if (r11 != null) goto L9;
        return false;
    L9:
        if (r11.equals(r10.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r11.contains(":") == false) goto L7;
        return false;
    }
}
