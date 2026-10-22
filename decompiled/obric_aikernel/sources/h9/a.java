package h9;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import ea.b;
import kotlin.jvm.internal.Intrinsics;
import o9.m;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f9196c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f9197g = null;

    static {
        f9197g = new a();
    }

    private a() {
    }

    private final Application a() {
        return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
    L5:
        e = move-exception;
        b.c("OUISdk", "getApplicationReflect failed", e);
        return null;
    }

    public final void b() {
    L12:
        e = move-exception;
        b.c("OUISdk", "init failed", e);
        return;
    L4:
        if (f9196c == true) goto L10;
        long r10 = System.currentTimeMillis();     // Catch: Exception -> L12
        Application r11 = a();     // Catch: Exception -> L12
        if (r11 == null) goto L8;
        r11.registerComponentCallbacks(this);     // Catch: Exception -> L12
    L8:
        t8.b.f12973c.d();     // Catch: Exception -> L12
        f9196c = true;     // Catch: Exception -> L12
        String r12 = "init success, cost: " + (System.currentTimeMillis() - r10) + " ms";     // Catch: Exception -> L12
    L9:
        b.a("OUISdk", r12);     // Catch: Exception -> L12
        return;
    L10:
        r12 = "init already";
        goto L9
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        m.f11593e.g();
        return;
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int r10) {
        if (Build.VERSION.SDK_INT < 24) goto L6;
        m.f11593e.g();
        return;
    }
}
