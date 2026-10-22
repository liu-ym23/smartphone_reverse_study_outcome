package com.bytedance.ai.bridge.method.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import com.google.gson.JsonObject;
import f2.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final Object a = null;
    public static Context b;
    public static c c;
    public static f d;

    public d() {
    }

    static {
        a = new Object();
    }

    public static final void a() {
        Context r0 = b;
        if (r0 == null) goto L27;
        f r1 = e.a(r0);
        Object r10 = a;
        monitor-enter(r10);
        f r11 = d;     // Catch: Throwable -> L22
        if (r11 != null) goto L10;
    L14:
        boolean r12 = false;
    L15:
        if (r12 == false) goto L18;
        monitor-exit(r10);
        return;
    L18:
        d = r1;     // Catch: Throwable -> L22
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r10);
        JsonObject r14 = new JsonObject();
        r14.addProperty("isConnected", Boolean.valueOf(r1.b));
        r14.addProperty("networkType", r1.a);
        l3.d.c(new l3.a("doubao.onNetworkStatusChange", r14, 4));
        return;
    L10:
        if (Intrinsics.areEqual(r1.a, r11.a) == false) goto L14;
        if (r1.b != r11.b) goto L14;
        r12 = true;
    L22:
        th = move-exception;
        throw th;
    }

    public static void b() {
        Context r0 = k.a().getApplicationContext();
        Object r1 = a;
        monitor-enter(r1);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (c == null) goto L8;
        monitor-exit(r1);
        return;
    L8:
        Object r10 = r0.getSystemService("connectivity");     // Catch: Throwable -> L23
        if ((r10 instanceof ConnectivityManager) == false) goto L12;
        ConnectivityManager r11 = (ConnectivityManager) r10;     // Catch: Throwable -> L23
    L13:
        if (r11 != null) goto L16;
        monitor-exit(r1);
        return;
    L16:
        c r12 = new c();     // Catch: Throwable -> L23
        r11.registerNetworkCallback(new NetworkRequest.Builder().build(), r12);     // Catch: RuntimeException -> L19 Throwable -> L23
        b = r0;     // Catch: RuntimeException -> L19 Throwable -> L23
        c = r12;     // Catch: RuntimeException -> L19 Throwable -> L23
        d = e.a(r0);     // Catch: RuntimeException -> L19 Throwable -> L23
    L20:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r1);
        return;
    L19:
        b = null;     // Catch: Throwable -> L23
        c = null;     // Catch: Throwable -> L23
        d = null;     // Catch: Throwable -> L23
        goto L20
    L12:
        r11 = null;
        goto L13
    }
}
