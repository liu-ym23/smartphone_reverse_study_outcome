package com.bytedance.news.common.settings.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2418a;

    static {
    }

    public static String a(Context r10) {
        String r11 = f2418a;
        if (TextUtils.isEmpty(r11) == true) goto L16;
        return r11;
    L16:
        int r12 = Process.myPid();     // Catch: Exception -> L12
        Iterator<ActivityManager.RunningAppProcessInfo> r13 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L12
    L7:
        if (r13.hasNext() == false) goto L14;
        ActivityManager.RunningAppProcessInfo r14 = r13.next();     // Catch: Exception -> L12
        if (r14.pid != r12) goto L7;
        String r15 = r14.processName;     // Catch: Exception -> L12
        f2418a = r15;     // Catch: Exception -> L12
        return r15;
    L14:
        String r16 = b();
        f2418a = r16;
        return r16;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }

    private static String b() {
        BufferedReader r10 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L11
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L16
    L5:
        int r12 = r10.read();     // Catch: Throwable -> L16
        if (r12 <= 0) goto L8;
        r11.append((char) r12);     // Catch: Throwable -> L16
        goto L5
    L8:
        String r13 = r11.toString();     // Catch: Throwable -> L16
        r10.close();     // Catch: Exception -> L15
    L10:
        return r13;
    L12:
        if (r10 != null) goto L22;
    L14:
        return null;
    L22:
        r10.close();     // Catch: Exception -> L17
    L11:
        r10 = null;
        goto L12
    }

    public static boolean c(Context r10) {
        String r11 = a(r10);
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
