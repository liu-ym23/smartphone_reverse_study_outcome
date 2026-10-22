package iu8;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    static {
    }

    public static String a() {
        StackTraceElement[] r0 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getStackTrace();     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r0, "stackTraceElements");     // Catch: Throwable -> L7
        StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L7
        int r2 = r0.length;     // Catch: Throwable -> L7
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        StackTraceElement r4 = r0[r3];     // Catch: Throwable -> L7
        r1.append("  at ");     // Catch: Throwable -> L7
        r1.append(r4.getClassName());     // Catch: Throwable -> L7
        r1.append(".");     // Catch: Throwable -> L7
        r1.append(r4.getMethodName());     // Catch: Throwable -> L7
        r1.append("(");     // Catch: Throwable -> L7
        r1.append(r4.getFileName());     // Catch: Throwable -> L7
        r1.append(":");     // Catch: Throwable -> L7
        r1.append(r4.getLineNumber());     // Catch: Throwable -> L7
        r1.append(")\n");     // Catch: Throwable -> L7
        r3 = r3 + 1;     // Catch: Throwable -> L7
        goto L3
    L5:
        return r1.toString();
    L7:
        th = move-exception;
        nu8.a.f("StackDumpUtils", th, "dumpMainStack failed:");
        return "INVALID_STACK in app launch period!";
    }
}
