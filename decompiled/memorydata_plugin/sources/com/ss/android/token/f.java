package com.ss.android.token;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f15729a;

    static {
    }

    private static String a() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L19
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L17
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L17
        if (r3 <= 0) goto L9;
        r2.append((char) r3);     // Catch: Throwable -> L17
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("Process", "get processName = " + r2.toString());     // Catch: Throwable -> L17
    L11:
        String r0 = r2.toString();     // Catch: Throwable -> L17
        r1.close();     // Catch: Exception -> L14
    L16:
        return r0;
    L14:
        e = move-exception;
        d.a(e);
    L17:
        th = th;
    L35:
        d.a(th);     // Catch: Throwable -> L28
        if (r1 != null) goto L39;
    L27:
        return null;
    L39:
        r1.close();     // Catch: Exception -> L25
    L25:
        e = move-exception;
        d.a(e);
    L28:
        th = move-exception;
        if (r1 != null) goto L43;
    L34:
        throw th;
    L43:
        r1.close();     // Catch: Exception -> L32
    L32:
        e = move-exception;
        d.a(e);
    L19:
        th = th;
        r1 = null;
        goto L35
    }

    public static boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        String r0 = b(r4);
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

    public static String b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        String r0 = f15729a;
        if (h.a(r0) == true) goto L19;
        return r0;
    L19:
        int r1 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r6 = ((ActivityManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("activity"), ActivityManager.class, "com.obric.memorydata.plugin")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L7:
        if (r6.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r2 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r6.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L15
        if (r2.pid != r1) goto L7;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r2.processName);     // Catch: Exception -> L15
    L13:
        String r7 = r2.processName;     // Catch: Exception -> L15
        f15729a = r7;     // Catch: Exception -> L15
        return r7;
    L17:
        String r8 = a();
        f15729a = r8;
        return r8;
    L15:
        e = move-exception;
        d.a(e);
        goto L17
    }
}
