package v3;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.bridge.method.device.wifi.WifiError;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h implements e3.b {
    public final WeakReference<e3.d> a;
    public final Object b;
    public final Handler c;
    public boolean d;
    public boolean e;
    public ConnectivityManager f;
    public ConnectivityManager.NetworkCallback g;

    public static final class a {
    }

    static {
    }

    @Override // e3.b
    public final void a() {
        Object r0 = this.b;
        monitor-enter(r0);
        this.e = true;     // Catch: Throwable -> L9
        this.d = false;     // Catch: Throwable -> L9
        b();     // Catch: Throwable -> L9
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r0);
        b.g();
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void b() {
        ConnectivityManager.NetworkCallback r0 = this.g;
        if (r0 == null) goto L26;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L10
        ConnectivityManager r11 = this.f;     // Catch: Throwable -> L10
        if (r11 == null) goto L7;
        r11.unregisterNetworkCallback(r0);     // Catch: Throwable -> L10
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Object r12 = Result.constructor-impl(r1);     // Catch: Throwable -> L10
    L12:
        Result.box-impl(r12);
        goto L26
    L7:
        r1 = null;
    L10:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
    L26:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L20
        if (Build.VERSION.SDK_INT < 23) goto L18;
        ConnectivityManager r15 = this.f;     // Catch: Throwable -> L20
        if (r15 == null) goto L18;
        r15.bindProcessToNetwork(null);     // Catch: Throwable -> L20
    L18:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        this.g = null;
        this.f = null;
        return;
    L20:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    public final WifiError h() {
        Object r0 = this.b;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.e == false) goto L8;
        WifiError r1 = new WifiError(f3.a.f, "context is null");     // Catch: Throwable -> L14
    L12:
        monitor-exit(r0);
        return r1;
    L8:
        if (this.d == true) goto L11;
        f3.a.C0156a r10 = f3.a.c;     // Catch: Throwable -> L14
        f3.a r11 = f3.b.a;     // Catch: Throwable -> L14
        Intrinsics.checkNotNullParameter(r10, "<this>");     // Catch: Throwable -> L14
        r1 = new WifiError(f3.b.e, "wifi module is not initialized");     // Catch: Throwable -> L14
        goto L12
    L11:
        r1 = null;
        goto L12
    }

    public final Context j() {
        e3.d r0 = this.a.get();
        if (r0 == null) goto L10;
        Context r1 = e3.e.b(r0);
        if (r1 == null) goto L10;
        Context r10 = r1.getApplicationContext();
        if (r10 != null) goto L12;
        return r1;
    L12:
        return r10;
    L10:
        return null;
    }

    public h(e3.d r10) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        this.a = new WeakReference(r10);
        this.b = new Object();
        this.c = new Handler(Looper.getMainLooper());
    }

    public static String c(WifiConfiguration r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r12 = (g06.a) ApiHookConfig.b.get(101102);
        if (r12 == null) goto L5;
        f06.a[] r13 = r12.i;
    L6:
        f06.a[] r15 = r13;
        int r14 = r15.length;
        int r16 = 0;
    L8:
        if (r16 >= r14) goto L15;
        f06.a r17 = r15[r16];
        int r19 = r16;
        int r110 = r14;
        f06.d r20 = r17.preInvoke(101102, "android/net/wifi/WifiConfiguration", "BSSID", r18, r10, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r20.a == true) goto L17;
        r0.add(r17);     // Catch: Exception -> L22
    L17:
        if (r20.a == false) goto L21;
        return (String) r20.b;
    L21:
        return r18.BSSID;
    L14:
        r16 = r19 + 1;
        r14 = r110;
        goto L8
    L15:
        r20 = new f06.d(false, null);
        goto L17
    L5:
        r13 = ApiHookConfig.d;
        goto L6
    }

    public static String e(WifiConfiguration r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r12 = (g06.a) ApiHookConfig.b.get(101004);
        if (r12 == null) goto L5;
        f06.a[] r13 = r12.i;
    L6:
        f06.a[] r15 = r13;
        int r14 = r15.length;
        int r16 = 0;
    L8:
        if (r16 >= r14) goto L15;
        f06.a r17 = r15[r16];
        int r19 = r16;
        int r110 = r14;
        f06.d r20 = r17.preInvoke(101004, "android/net/wifi/WifiConfiguration", "SSID", r18, r10, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r20.a == true) goto L17;
        r0.add(r17);     // Catch: Exception -> L22
    L17:
        if (r20.a == false) goto L21;
        return (String) r20.b;
    L21:
        return r18.SSID;
    L14:
        r16 = r19 + 1;
        r14 = r110;
        goto L8
    L15:
        r20 = new f06.d(false, null);
        goto L17
    L5:
        r13 = ApiHookConfig.d;
        goto L6
    }

    public static List g(WifiManager r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r12 = (g06.a) ApiHookConfig.b.get(101001);
        if (r12 == null) goto L5;
        f06.a[] r13 = r12.i;
    L6:
        f06.a[] r15 = r13;
        int r14 = r15.length;
        int r16 = 0;
    L8:
        if (r16 >= r14) goto L15;
        f06.a r17 = r15[r16];
        int r19 = r16;
        int r110 = r14;
        f06.d r20 = r17.preInvoke(101001, "android/net/wifi/WifiManager", "getConfiguredNetworks", r18, r10, "java.util.List", r11);     // Catch: Exception -> L22
        if (r20.a == true) goto L17;
        r0.add(r17);     // Catch: Exception -> L22
    L17:
        if (r20.a == false) goto L21;
        return (List) r20.b;
    L21:
        return r18.getConfiguredNetworks();
    L14:
        r16 = r19 + 1;
        r14 = r110;
        goto L8
    L15:
        r20 = new f06.d(false, null);
        goto L17
    L5:
        r13 = ApiHookConfig.d;
        goto L6
    }

    public static String i(e r10) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r10.a);
        r0.append('#');
        String r11 = r10.b;
        if (r11 != null) goto L5;
        r11 = "";
    L5:
        r0.append(r11);
        return r0.toString();
    }

    public static void d(WifiConfiguration r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r12 = (g06.a) ApiHookConfig.b.get(101102);
        if (r12 == null) goto L5;
        f06.a[] r13 = r12.i;
    L6:
        f06.a[] r15 = r13;
        int r14 = r15.length;
        int r16 = 0;
    L8:
        if (r16 >= r14) goto L15;
        f06.a r17 = r15[r16];
        int r110 = r16;
        int r111 = r14;
        f06.d r20 = r17.preInvoke(101102, "android/net/wifi/WifiConfiguration", "BSSID", r18, r10, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r20.a == true) goto L17;
        r0.add(r17);     // Catch: Exception -> L22
    L17:
        if (r20.a == false) goto L20;
        String r1 = (String) r20.b;
        return;
    L20:
        r18.BSSID = r19;
        return;
    L14:
        r16 = r110 + 1;
        r14 = r111;
        goto L8
    L15:
        r20 = new f06.d(false, null);
        goto L17
    L5:
        r13 = ApiHookConfig.d;
        goto L6
    }

    public static void f(WifiConfiguration r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r12 = (g06.a) ApiHookConfig.b.get(101004);
        if (r12 == null) goto L5;
        f06.a[] r13 = r12.i;
    L6:
        f06.a[] r15 = r13;
        int r14 = r15.length;
        int r16 = 0;
    L8:
        if (r16 >= r14) goto L15;
        f06.a r17 = r15[r16];
        int r110 = r16;
        int r111 = r14;
        f06.d r20 = r17.preInvoke(101004, "android/net/wifi/WifiConfiguration", "SSID", r18, r10, "java.lang.String", r11);     // Catch: Exception -> L22
        if (r20.a == true) goto L17;
        r0.add(r17);     // Catch: Exception -> L22
    L17:
        if (r20.a == false) goto L20;
        String r1 = (String) r20.b;
        return;
    L20:
        r18.SSID = r19;
        return;
    L14:
        r16 = r110 + 1;
        r14 = r111;
        goto L8
    L15:
        r20 = new f06.d(false, null);
        goto L17
    L5:
        r13 = ApiHookConfig.d;
        goto L6
    }
}
