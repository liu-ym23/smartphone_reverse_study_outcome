package com.bytedance.ttnet.utils;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import com.bytedance.common.utility.h;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f3333a = false;

    static {
    }

    public static Intent a(Context r6, PluginBroadcastReceiver r7, IntentFilter r8) {
        return a((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin"), r7, r8, null, null, 4);
    }

    private static Intent a(Context r7, PluginBroadcastReceiver r8, IntentFilter r9, String r10, Handler r11, int r12) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return ZeusTransformUtils.registerReceiver(r0, r8, r9, r10, r11, r12, "com.obric.memorydata.plugin");
    L7:
        return ZeusTransformUtils.registerReceiver(r0, r8, r9, r10, r11, "com.obric.memorydata.plugin");
    }

    public static String a(Throwable r3) {
        String r0 = null;
        if (r3 != null) goto L29;
        return null;
    L29:
        StringWriter r1 = new StringWriter();     // Catch: Throwable -> L15
        PrintWriter r2 = new PrintWriter(r1);     // Catch: Throwable -> L15
        r3.printStackTrace(r2);     // Catch: Throwable -> L13
        Throwable r4 = r3.getCause();     // Catch: Throwable -> L13
        if (r4 == null) goto L11;
        r4.printStackTrace(r2);     // Catch: Throwable -> L13
        Throwable r5 = r4.getCause();     // Catch: Throwable -> L13
        if (r5 == null) goto L11;
        r5.printStackTrace(r2);     // Catch: Throwable -> L13
    L11:
        r0 = r1.toString();     // Catch: Throwable -> L13
    L12:
        r2.close();
    L20:
        return r0;
    L13:
        th = th;
    L25:
        th.printStackTrace();     // Catch: Throwable -> L21
        if (r2 == null) goto L20;
    L21:
        th = move-exception;
        if (r2 == null) goto L24;
        r2.close();
    L24:
        throw th;
    L15:
        th = th;
        r2 = null;
        goto L25
    }

    public static boolean a(String r2, String r3) {
        if (h.a(r2) == false) goto L5;
        return false;
    L5:
        if (h.a(r3) == false) goto L8;
        return false;
    L8:
        if (r2.equalsIgnoreCase(r3) == false) goto L11;
        return true;
    L11:
        String r4 = r2.toLowerCase();
        if (r3.startsWith(".") == false) goto L16;
        String r5 = r3.toLowerCase();
    L15:
        return r4.endsWith(r5);
    L16:
        r5 = "." + r3.toLowerCase();
        goto L15
    }

    public static boolean a(String r4, List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (h.a(r4) == false) goto L5;
    L17:
        return false;
    L5:
        if (com.bytedance.common.utility.d.a(r6) == true) goto L17;
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L17;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin");
        if (h.a(r0) == true) goto L9;
        if (a(r4, r0) == false) goto L9;
        return true;
    }

    public static void b(String r4, List<String> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (h.a(r4) == true) goto L14;
        if (r6 == null) goto L19;
        String[] r7 = r4.split(",");
        int r0 = r7.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L20;
        String r2 = r7[r1];
        if (h.a(r2) == true) goto L13;
        if (a(r2, r6) == true) goto L13;
        r6.add(r2.trim());
    L13:
        r1 = r1 + 1;
        goto L7
    L20:
        return;
    L19:
        return;
    }
}
