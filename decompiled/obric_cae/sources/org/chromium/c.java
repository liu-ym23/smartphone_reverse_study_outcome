package org.chromium;

import com.ttnet.org.chromium.base.Reflect;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile c f9795b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f9796a;

    public c() {
    }

    public static c c() {
        if (f9795b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f9795b != null) goto L9;
        f9795b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f9795b;
    }

    public final String a(String r8) {
        Object r10 = this.f9796a;     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return "";
    L6:
        return (String) Reflect.on(r10).call(r8).get();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public final void b(boolean r28, String r29, String r30, String r31, long r32, long r34, long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, boolean r52, long r53, long r55, String r57, String r58, String r59, int r60, int r61, String r62) {
        if (d.a().loggerDebug() == false) goto L16;
        d.a().loggerD("CronetAppProviderManager", "handleApiResult ");
    L16:
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (this.f9796a != null) goto L8;
        return;
    L8:
        if (r28 == true) goto L10;
        IOException r8 = f.d(f.a(r60, r61, r62));     // Catch: Throwable -> L13
    L11:
        Reflect r10 = Reflect.on(this.f9796a);     // Catch: Throwable -> L13
        Class<?> r11 = Boolean.TYPE;     // Catch: Throwable -> L13
        Class<?> r12 = Long.TYPE;     // Catch: Throwable -> L13
        r10.call("handleApiResult", new Class[]{r11, String.class, String.class, String.class, r12, r12, r12, r12, r12, r12, r12, r12, r12, r12, r11, r12, r12, r12, String.class, String.class, Exception.class}, new Object[]{Boolean.valueOf(r28), r29, r30, r31, Long.valueOf(r32), Long.valueOf(r34), Long.valueOf(r36), Long.valueOf(r38), Long.valueOf(r40), Long.valueOf(r42), Long.valueOf(r44), Long.valueOf(r46), Long.valueOf(r48), Long.valueOf(r50), Boolean.valueOf(r52), Long.valueOf(r53), Long.valueOf(r55), r57, r58, r59, r8});     // Catch: Throwable -> L13
        return;
    L10:
        r8 = null;
        goto L11
    }

    public final void d(String r8, String r10) {
        if (d.a().loggerDebug() == false) goto L13;
        d.a().loggerD("CronetAppProviderManager", defpackage.b.e("Send monitor json = ", r8, ", log type =", r10));
    L13:
        Object r11 = this.f9796a;     // Catch: Throwable -> L10
        if (r11 != null) goto L8;
        return;
    L8:
        Reflect.on(r11).call("sendAppMonitorEvent", new Class[]{String.class, String.class}, new Object[]{r8, r10});     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }
}
