package com.bytedance.ies.bullet.lynx.init;

import android.graphics.Typeface;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.lynx.tasm.LynxEnv;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import zm.g0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f5679a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f5680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Typeface f5681c = null;
    public static rc.f d;

    static {
        f5679a = new AtomicBoolean(false);
        f5681c = Typeface.DEFAULT;
    }

    public static void a() {
        rc.f r5 = d;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("token");
        r5 = null;
    L5:
        com.bytedance.ies.bullet.settings.b r10 = (com.bytedance.ies.bullet.settings.b) r5.a(com.bytedance.ies.bullet.settings.b.class);
        if (r10 == null) goto L10;
        com.bytedance.ies.bullet.service.base.d r11 = (com.bytedance.ies.bullet.service.base.d) r10.f6163b.getValue();
        if (r11 == null) goto L10;
        boolean r12 = r11.f5964b;
    L11:
        yn.c.f23314a = new f(r12);
        g r13 = new g(r12);
        monitor-enter(g0.class);
        g0.f.add(r13);     // Catch: Throwable -> L16
        monitor-exit(g0.class);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    L10:
        r12 = true;
        goto L11
    }

    public static void b(sg.a r5, rc.f r10) {
        Intrinsics.checkNotNullParameter(r5, "lynxConfig");
        Intrinsics.checkNotNullParameter(r10, "token");
        boolean r11 = f5680b;
        AtomicBoolean r12 = f5679a;
        if (r11 == true) goto L5;
    L8:
        d = r10;
        a();     // Catch: Throwable -> L13
        l.a(r5, r10);     // Catch: Throwable -> L13
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L15;
        f5680b = true;     // Catch: Throwable -> L13
        m.a(i.a(), ((rc.a) r10.getServiceContext()).f21719b);     // Catch: Throwable -> L13
        Npth.addAttachUserData(e.f5676a, CrashType.ALL);     // Catch: Throwable -> L13
        return;
    L15:
        r12.set(false);     // Catch: Throwable -> L13
        throw new RuntimeException("Lynx so Init Failed");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r12.set(false);
        com.bytedance.ies.bullet.service.base.b.g("LynxKit Init Failed", "XLynxKit", th);
        return;
    L5:
        if (r12.compareAndSet(false, true) == true) goto L8;
        boolean r13 = com.bytedance.ies.bullet.service.base.b.f5956a;
        com.bytedance.ies.bullet.service.base.b.d("LynxKit has init", LogLevel.f5954b, "XLynxKit");
    }
}
