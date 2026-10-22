package r3;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import x4.i0;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f11390a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f11391b;

    static {
        f11390a = new c();
        f11391b = false;
    }

    public a() {
    }

    public static String a() {
        u3.e r8 = f11390a.f11410r;
        if (TextUtils.isEmpty(r8.f12444i) == false) goto L13;
        if (r8.f12442g != null) goto L7;
        r8.f12442g = ((x4.j) r8.b()).b();
    L7:
        i0 r10 = r8.f12442g;
        if (r10 == null) goto L10;
        String r11 = r10.f13444b;
    L11:
        r8.f12444i = r11;
        goto L13
    L10:
        r11 = null;
    L13:
        return r8.f12444i;
    }

    public static void b(Context r8, m r10) {
        monitor-enter(a.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (f11391b == false) goto L9;
        Log.e("AppLog", "Default AppLog is initialized, please new a instance by `AppLog.newInstance()`");     // Catch: Throwable -> L17
        monitor-exit(a.class);     // Catch: Throwable -> L17
        return;
    L9:
        f11391b = true;     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r10.f11437m) == true) goto L12;
    L14:
        f11390a.h(r8, r10);     // Catch: Throwable -> L17
        monitor-exit(a.class);     // Catch: Throwable -> L17
        return;
    L12:
        if (TextUtils.isEmpty("applog_stats") == true) goto L14;
        r10.f11437m = "applog_stats";     // Catch: Throwable -> L17
        goto L14
    }
}
