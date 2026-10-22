package com.bytedance.ttnet.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.bytedance.common.utility.g;
import com.bytedance.frameworks.baselib.network.http.util.e;
import com.bytedance.retrofit2.t;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {
    static {
    }

    public static boolean a(String r10, List<String> r11) {
        if (g.b(r10) == false) goto L5;
    L21:
        return false;
    L5:
        if (com.bytedance.common.utility.c.a(r11) == true) goto L21;
        Iterator<String> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L21;
        String r13 = r12.next();
        if (g.b(r13) == true) goto L9;
        if (k2.b.e() == true) goto L16;
        if (b(r10, r13) == false) goto L9;
        return true;
    L16:
        if (r10.endsWith(r13) == false) goto L9;
        return true;
    }

    public static boolean b(String r10, String r11) {
        if (g.b(r10) == false) goto L5;
        return false;
    L5:
        if (g.b(r11) == false) goto L8;
        return false;
    L8:
        if (r10.equalsIgnoreCase(r11) == false) goto L11;
        return true;
    L11:
        String r12 = r10.toLowerCase();
        if (r11.startsWith(".") == false) goto L16;
        String r13 = r11.toLowerCase();
    L15:
        return r12.endsWith(r13);
    L16:
        r13 = "." + r11.toLowerCase();
        goto L15
    }

    public static String c(Throwable r10) {
        String r11 = null;
        if (r10 != null) goto L29;
        return null;
    L29:
        StringWriter r12 = new StringWriter();     // Catch: Throwable -> L15
        PrintWriter r13 = new PrintWriter(r12);     // Catch: Throwable -> L15
        r10.printStackTrace(r13);     // Catch: Throwable -> L13
        Throwable r14 = r10.getCause();     // Catch: Throwable -> L13
        if (r14 == null) goto L11;
        r14.printStackTrace(r13);     // Catch: Throwable -> L13
        Throwable r15 = r14.getCause();     // Catch: Throwable -> L13
        if (r15 == null) goto L11;
        r15.printStackTrace(r13);     // Catch: Throwable -> L13
    L11:
        r11 = r12.toString();     // Catch: Throwable -> L13
    L12:
        r13.close();
    L20:
        return r11;
    L13:
        th = th;
    L25:
        th.printStackTrace();     // Catch: Throwable -> L21
        if (r13 == null) goto L20;
    L21:
        th = move-exception;
        if (r13 == null) goto L24;
        r13.close();
    L24:
        throw th;
    L15:
        th = th;
        r13 = null;
        goto L25
    }

    public static void d(String r10, List<String> r11) {
        if (g.b(r10) == true) goto L14;
        if (r11 == null) goto L19;
        String[] r12 = r10.split(",");
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L20;
        String r15 = r12[r14];
        if (g.b(r15) == true) goto L13;
        if (a(r15, r11) == true) goto L13;
        r11.add(r15.trim());
    L13:
        r14 = r14 + 1;
        goto L7
    L20:
        return;
    L19:
        return;
    }

    private static Intent e(Context r10, BroadcastReceiver r11, IntentFilter r12, String r13, Handler r14, int r15) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return r10.registerReceiver(r11, r12, r13, r14, r15);
    L7:
        return r10.registerReceiver(r11, r12, r13, r14);
    }

    public static Intent f(Context r10, BroadcastReceiver r11, IntentFilter r12) {
        return e(r10, r11, r12, null, null, 4);
    }

    public static void g(e<String, t> r10, q4.a r11) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.i() <= 0) goto L30;
        Map<String, t> r12 = r10.e();
        Collection<t> r13 = r12.values();
        monitor-enter(r12);
        Iterator<t> r14 = r13.iterator();     // Catch: Throwable -> L17
    L9:
        if (r14.hasNext() == false) goto L15;
        List<q4.a> r15 = r14.next().i();     // Catch: Throwable -> L17
        if (r15 == null) goto L9;
        if (r15.contains(r11) == true) goto L9;
        r15.add(r11);     // Catch: Throwable -> L17
        goto L9
    L15:
        monitor-exit(r12);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
