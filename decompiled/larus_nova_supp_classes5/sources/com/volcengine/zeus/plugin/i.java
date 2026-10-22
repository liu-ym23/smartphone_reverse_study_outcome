package com.volcengine.zeus.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Process;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.log.ZeusLogger;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqc.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class i {
    public static final Set<String> a = null;

    public i() {
    }

    static {
        a = new LinkedHashSet();
    }

    public static void b() {
        p.b(new h(false));
    }

    public static final void a(String r11) {
        Application r0 = Zeus.getAppApplication();
        String r1 = r0.getPackageName();
        int r2 = Process.myUid();
        int r3 = Process.myPid();
        Object r4 = r0.getSystemService("activity");
        if ((r4 instanceof ActivityManager) == true) goto L5;
        r4 = null;
    L5:
        ActivityManager r5 = (ActivityManager) r4;
        if (r5 == null) goto L8;
        List<ActivityManager.RunningAppProcessInfo> r6 = r5.getRunningAppProcesses();
    L9:
        if (r6 != null) goto L12;
        r6 = CollectionsKt.emptyList();
    L12:
        LinkedHashSet r7 = new LinkedHashSet();
        Iterator<ActivityManager.RunningAppProcessInfo> r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L26;
        ActivityManager.RunningAppProcessInfo r9 = r8.next();
        String r10 = r9.processName;
        if (r10 == null) goto L14;
        boolean r12 = false;
        if (Intrinsics.areEqual(r10, r1) == true) goto L22;
        if (StringsKt.startsWith$default(r10, r1 + ':', false, 2, null) == true) goto L22;
    L24:
        if (r12 == false) goto L14;
        r7.add(Integer.valueOf(r9.pid));
    L22:
        if (r9.uid != r2) goto L24;
        r12 = true;
        goto L24
    L26:
        ZeusLogger.w("Zeus/install_zeus", "PluginReloadManager force-stop app " + r1 + " processes due to plugin update, plugin=" + r11 + ", pids=" + r7);
        r7.toString();
        Iterator r13 = r7.iterator();
    L28:
        if (r13.hasNext() == false) goto L35;
        Integer r14 = (Integer) r13.next();
        if (r14 == null) goto L34;
        if (r14.intValue() == r3) goto L28;
    L34:
        Process.killProcess(r14.intValue());
        goto L28
    L35:
        Process.killProcess(r3);
        return;
    L8:
        r6 = null;
        goto L9
    }
}
