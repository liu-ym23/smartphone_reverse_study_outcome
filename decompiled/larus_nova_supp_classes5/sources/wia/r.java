package wia;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.obric.capabilitykit.logger.Logger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class r {
    public static volatile String a;

    static {
    }

    public static String a(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        String r0 = a;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L12;
        return r0;
    L12:
        if (Build.VERSION.SDK_INT < 28) goto L45;
        a = Application.getProcessName();
        Logger.INSTANCE.d("ProcessUtils", "processName = " + a);
    L37:
        return a;
    L45:
        int r2 = Process.myPid();     // Catch: Exception -> L21
        Object r7 = r6.getSystemService("activity");     // Catch: Exception -> L21
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Exception -> L21
        Iterator<ActivityManager.RunningAppProcessInfo> r8 = ((ActivityManager) r7).getRunningAppProcesses().iterator();     // Catch: Exception -> L21
    L16:
        if (r8.hasNext() == false) goto L23;
        ActivityManager.RunningAppProcessInfo r3 = r8.next();     // Catch: Exception -> L21
        if (r3.pid != r2) goto L16;
        Logger.INSTANCE.d("ProcessUtils", "processName = " + r3.processName);     // Catch: Exception -> L21
        a = r3.processName;     // Catch: Exception -> L21
        return a;
    L23:
        String r4 = null;
        BufferedReader r5 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L32
        Ref$IntRef r9 = new Ref$IntRef();     // Catch: Throwable -> L31
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L31
    L26:
        int r11 = r5.read();     // Catch: Throwable -> L31
        r9.element = r11;     // Catch: Throwable -> L31
        if (r11 <= 0) goto L29;
        r10.append((char) r11);     // Catch: Throwable -> L31
        goto L26
    L29:
        Logger.INSTANCE.d("ProcessUtils", "get processName = " + r10);     // Catch: Throwable -> L31
        r4 = r10.toString();     // Catch: Throwable -> L31
    L43:
        r5.close();     // Catch: Exception -> L38
    L35:
        a = r4;
    L33:
        if (r5 == null) goto L35;
    L32:
        r5 = null;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
