package com.obric.assistant;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m4 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        Object r0 = r7.getSystemService("activity");
        ActivityManager.RunningAppProcessInfo r2 = null;
        if ((r0 instanceof ActivityManager) == false) goto L7;
        ActivityManager r1 = (ActivityManager) r0;
    L8:
        if (r1 != null) goto L10;
        return;
    L10:
        String r8 = r7.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> r3 = r1.getRunningAppProcesses();
        if (r3 == null) goto L26;
        Iterator<T> r4 = r3.iterator();
        ActivityManager.RunningAppProcessInfo r5 = null;
    L14:
        if (r4.hasNext() == false) goto L25;
        ActivityManager.RunningAppProcessInfo r6 = (ActivityManager.RunningAppProcessInfo) r4.next();
        if (Intrinsics.areEqual(r6.processName, r8) == true) goto L17;
        String r9 = r6.processName;
        Intrinsics.checkNotNull(r8);
        if (StringsKt.contains$default(r9, r8, false, 2, null) == false) goto L14;
        if (Intrinsics.areEqual(r6.processName, r8) == true) goto L14;
        Process.killProcess(r6.pid);     // Catch: Exception -> L24
        goto L14
    L17:
        r5 = r6;
        goto L14
    L25:
        r2 = r5;
    L26:
        if (r2 != null) goto L34;
    L30:
        System.exit(0);
        return;
    L34:
        Process.killProcess(r2.pid);     // Catch: Exception -> L29
        goto L30
    L7:
        r1 = null;
        goto L8
    }
}
