package iu8;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.larus.common.apphost.AppHost;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public static final void b() {
        nu8.a.e("ProcessUtils", "killCurrentProcess");
        Process.killProcess(Process.myPid());
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    public static final void c() {
        nu8.a.e("ProcessUtils", "restartApp");
        Application r0 = AppHost.a.getApplication();
        Intent r1 = r0.getPackageManager().getLaunchIntentForPackage(r0.getPackageName());
        if (r1 == null) goto L6;
        r1.addFlags(67108864);
        r0.startActivity(r1);
    L6:
        b();
        throw null;
    }

    public static final int a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Object r1 = r5.getSystemService("activity");     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Throwable -> L10
        Iterator<ActivityManager.RunningAppProcessInfo> r2 = ((ActivityManager) r1).getRunningAppProcesses().iterator();     // Catch: Throwable -> L10
    L5:
        if (r2.hasNext() == false) goto L12;
        ActivityManager.RunningAppProcessInfo r3 = r2.next();     // Catch: Throwable -> L10
        if (Intrinsics.areEqual(r5.getPackageName(), r3.processName) == false) goto L5;
        nu8.a.a("ProcessUtils", "main process pid is " + r3.pid);     // Catch: Throwable -> L10
        return r3.pid;
    L12:
        nu8.a.a("ProcessUtils", "not found main process pid -1");
        return -1;
    L10:
        th = move-exception;
        nu8.a.f("ProcessUtils", th, "getMainProcessPid failed ");
        goto L12
    }
}
