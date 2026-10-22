package com.ttnet.org.chromium.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class TTProcessUtils {
    public static final String MESSAGE_PROCESS_SERVICE_SUFFIX = ":pushservice";
    public static final String MESSAGE_PROCESS_SUFFIX = ":push";
    private static volatile String sCurProcessName;

    public TTProcessUtils() {
    }

    public static /* synthetic */ Class access$000(String r0, boolean r1, ClassLoader r2) throws ClassNotFoundException {
        return Class.forName(r0, r1, r2);
    }

    private static String getCurrentProcessNameFromActivityThread() {
        Method r1 = INVOKESTATIC_com_ttnet_org_chromium_base_TTProcessUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L7
        r1.setAccessible(true);     // Catch: Throwable -> L7
        Object r2 = r1.invoke(null, new Object[0]);     // Catch: Throwable -> L7
        if ((r2 instanceof String) == false) goto L12;
        return (String) r2;
    L12:
        return null;
    L7:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader r2 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L15
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L14
    L5:
        int r3 = r2.read();     // Catch: Throwable -> L14
        if (r3 <= 0) goto L9;
        r0.append((char) r3);     // Catch: Throwable -> L14
        goto L5
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("Process", "get processName = " + r0.toString());     // Catch: Throwable -> L14
    L11:
        String r1 = r0.toString();     // Catch: Throwable -> L14
        r2.close();     // Catch: Exception -> L19
    L13:
        return r1;
    L16:
        if (r2 != null) goto L27;
    L18:
        return null;
    L27:
        r2.close();     // Catch: Exception -> L20
    L15:
        r2 = null;
        goto L16
    }

    private static String getCurrentProcessNameFromApplication() {
        if (Build.VERSION.SDK_INT < 28) goto L12;
        return Application.getProcessName();
    L6:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        return null;
    }

    public static String getCurProcessName(Context r1) {
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L5;
        sCurProcessName = getCurrentProcessNameFromApplication();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L9;
        sCurProcessName = getCurrentProcessNameFromActivityThread();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L13;
        sCurProcessName = getCurProcessNameFromProc();
        if (TextUtils.isEmpty(sCurProcessName) == false) goto L17;
        sCurProcessName = getCurProcessNameFromActivityManager(r1);
        return sCurProcessName;
    L17:
        return sCurProcessName;
    L13:
        return sCurProcessName;
    L9:
        return sCurProcessName;
    L5:
        return sCurProcessName;
    }

    private static String getCurProcessNameFromActivityManager(Context r6) {
        String r0 = null;
        if (r6 != null) goto L18;
        return null;
    L18:
        int r1 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r7 = ((ActivityManager) r6.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L6:
        if (r7.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r2 = r7.next();     // Catch: Exception -> L15
        if (r2.pid != r1) goto L6;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r2.processName);     // Catch: Exception -> L15
    L13:
        r0 = r2.processName;     // Catch: Exception -> L15
    L17:
        return r0;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static boolean isMainProcess(Context r3) {
        String r0 = getCurProcessName(r3);
        if (r0 != null) goto L5;
    L7:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r0.equals(r3.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r0.contains(":") == false) goto L7;
        return false;
    }

    public static boolean isMessageProcess(Context r1) {
        String r2 = getCurProcessName(r1);
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.endsWith(MESSAGE_PROCESS_SUFFIX) == false) goto L7;
        return true;
    L7:
        if (r2.endsWith(MESSAGE_PROCESS_SERVICE_SUFFIX) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ttnet_org_chromium_base_TTProcessUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r2, boolean r3, ClassLoader r4) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r5 = access$000(r2, r3, r4);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L8
    L7:
        return r5;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r2);
    L12:
        throw th;
    L34:
        Class r6 = access$000(r2, r3, r4);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r2);     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r2);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r2);
    }
}
