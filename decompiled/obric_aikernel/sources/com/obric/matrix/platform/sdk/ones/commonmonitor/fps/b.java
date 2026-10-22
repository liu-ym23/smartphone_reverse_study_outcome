package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.Looper;
import android.util.Printer;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5856a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f5857b;

    static {
        f5856a = new b();
    }

    private b() {
    }

    public static final /* synthetic */ void a(b r10) {
        r10.b();
    }

    private final void b() {
        if (f5857b == false) goto L5;
        return;
    L5:
        if (a.f5855a.a() != null) goto L17;
        e9.b.b("FPSMonitor", "CurrentPrinter() == null, now reset.", null, 4, null);
        Field r10 = f.class.getDeclaredField("a");     // Catch: Exception -> L12
        r10.setAccessible(true);     // Catch: Exception -> L12
        Object r11 = r10.get(null);     // Catch: Exception -> L12
        if (r11 == null) goto L11;
        Looper r12 = Looper.getMainLooper();     // Catch: Exception -> L12
        r12.setMessageLogging((Printer) r11);     // Catch: Exception -> L12
        f5857b = true;     // Catch: Exception -> L12
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.util.Printer");     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
