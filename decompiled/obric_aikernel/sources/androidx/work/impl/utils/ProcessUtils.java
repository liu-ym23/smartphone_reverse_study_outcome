package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.work.Configuration;
import androidx.work.Logger;
import androidx.work.WorkManager;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@JvmName(name = "ProcessUtils")
public final class ProcessUtils {
    private static final String TAG = null;

    static {
        String r10 = Logger.tagWithPrefix("ProcessUtils");
        Intrinsics.checkNotNullExpressionValue(r10, "tagWithPrefix(\"ProcessUtils\")");
        TAG = r10;
    }

    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    private static final String getProcessName(Context r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 28) goto L34;
        return Api28Impl.INSTANCE.getProcessName();
    L34:
        Class<?> r12 = Class.forName("android.app.ActivityThread", false, WorkManager.class.getClassLoader());     // Catch: Throwable -> L16
        if (r11 < 18) goto L11;
        Method r13 = r12.getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L16
        r13.setAccessible(true);     // Catch: Throwable -> L16
        Object r14 = r13.invoke(null, new Object[0]);     // Catch: Throwable -> L16
    L10:
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L16
        if ((r14 instanceof String) == false) goto L18;
        return (String) r14;
    L18:
        int r15 = Process.myPid();
        Object r16 = r10.getSystemService("activity");
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.app.ActivityManager");
        List<ActivityManager.RunningAppProcessInfo> r17 = ((ActivityManager) r16).getRunningAppProcesses();
        if (r17 == null) goto L41;
        Iterator<T> r18 = r17.iterator();
    L22:
        if (r18.hasNext() == false) goto L29;
        Object r19 = r18.next();
        if (((ActivityManager.RunningAppProcessInfo) r19).pid != r15) goto L26;
        boolean r20 = true;
    L27:
        if (r20 == false) goto L22;
    L30:
        ActivityManager.RunningAppProcessInfo r21 = (ActivityManager.RunningAppProcessInfo) r19;
        if (r21 != null) goto L33;
        return null;
    L33:
        return r21.processName;
    L26:
        r20 = false;
        goto L27
    L29:
        r19 = null;
        goto L30
    L41:
        return null;
    L11:
        Method r22 = r12.getDeclaredMethod("currentActivityThread", new Class[0]);     // Catch: Throwable -> L16
        r22.setAccessible(true);     // Catch: Throwable -> L16
        Method r23 = r12.getDeclaredMethod("getProcessName", new Class[0]);     // Catch: Throwable -> L16
        r23.setAccessible(true);     // Catch: Throwable -> L16
        r14 = r23.invoke(r22.invoke(null, new Object[0]), new Object[0]);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        Logger.get().debug(TAG, "Unable to check ActivityThread for processName", th);
        goto L18
    }

    public static final boolean isDefaultProcess(Context r10, Configuration r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "configuration");
        String r12 = getProcessName(r10);
        String r13 = r11.getDefaultProcessName();
        if (r13 != null) goto L5;
    L8:
        boolean r14 = true;
    L9:
        if (r14 == true) goto L11;
        String r15 = r11.getDefaultProcessName();
    L13:
        return Intrinsics.areEqual(r12, r15);
    L11:
        r15 = r10.getApplicationInfo().processName;
        goto L13
    L5:
        if (r13.length() == 0) goto L8;
        r14 = false;
        goto L9
    }
}
