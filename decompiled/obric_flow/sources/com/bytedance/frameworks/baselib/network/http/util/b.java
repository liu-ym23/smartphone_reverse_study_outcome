package com.bytedance.frameworks.baselib.network.http.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f4692a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f4693b;

    static {
        f4692a = new AtomicInteger(0);
        f4693b = null;
    }

    public static String a(Context r10) {
        String r5 = f4693b;
        if (com.bytedance.common.utility.b.b(r5) == true) goto L37;
        return r5;
    L37:
        int r11 = Process.myPid();     // Catch: Exception -> L13
        Iterator<ActivityManager.RunningAppProcessInfo> r12 = ((ActivityManager) r10.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L13
    L7:
        if (r12.hasNext() == false) goto L18;
        ActivityManager.RunningAppProcessInfo r13 = r12.next();     // Catch: Exception -> L13
        if (r13.pid != r11) goto L7;
        if (Logger.debug() == false) goto L15;
        Logger.d("Process", "processName = " + r13.processName);     // Catch: Exception -> L13
    L15:
        String r14 = r13.processName;     // Catch: Exception -> L13
        f4693b = r14;     // Catch: Exception -> L13
        return r14;
    L18:
        String r15 = null;
        BufferedReader r16 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L30
        StringBuilder r17 = new StringBuilder();     // Catch: Throwable -> L36
    L21:
        int r18 = r16.read();     // Catch: Throwable -> L36
        if (r18 <= 0) goto L25;
        r17.append((char) r18);     // Catch: Throwable -> L36
        goto L21
    L25:
        if (Logger.debug() == false) goto L27;
        Logger.d("Process", "get processName = " + r17.toString());     // Catch: Throwable -> L36
    L27:
        r15 = r17.toString();     // Catch: Throwable -> L36
    L39:
        r16.close();     // Catch: Exception -> L35
    L33:
        f4693b = r15;
        return r15;
    L31:
        if (r16 == null) goto L33;
    L30:
        r16 = null;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public static boolean b(Context r5) {
        boolean r10 = Logger.debug();
        AtomicInteger r11 = f4692a;
        if (r10 == false) goto L5;
        Logger.d("ProcessUtils", "TTNet ProcessFlag: " + r11);
    L5:
        int r12 = r11.get();
        boolean r13 = true;
        if (r12 != 1) goto L8;
        return true;
    L8:
        if (r12 == 2) goto L22;
        String r14 = a(r5);
        if (r14 != null) goto L12;
    L14:
        if (r14 != null) goto L16;
    L18:
        r13 = false;
    L20:
        return r13;
    L16:
        if (r14.equals(r5.getPackageName()) == false) goto L18;
    L12:
        if (r14.contains(":") == false) goto L14;
        return false;
    L22:
        return false;
    }
}
