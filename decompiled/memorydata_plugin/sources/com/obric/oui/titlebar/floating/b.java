package com.obric.oui.titlebar.floating;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Boolean f14797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f14798b;

    private b() {
    }

    public static boolean a() {
        Boolean r0 = f14797a;
        if (r0 != null) goto L15;
        monitor-enter(b.class);
        r0 = f14797a;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = Boolean.valueOf(a("persist.sys.floating.transition", false));     // Catch: Throwable -> L11
        f14797a = r0;     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L15:
        return r0.booleanValue();
    }

    private static boolean a(String r8, boolean r9) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.memorydata.plugin").getMethod("getBoolean", new Class[]{String.class, Boolean.TYPE}).invoke(null, new Object[]{r8, Boolean.valueOf(r9)}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        return r9;
    }

    public static boolean b() {
        return f14798b;
    }
}
