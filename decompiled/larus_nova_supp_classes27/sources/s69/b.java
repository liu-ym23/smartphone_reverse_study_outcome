package s69;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.larus.common.apphost.AppHost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public static final CopyOnWriteArraySet<a> a = null;
    public static final ConnectivityManager b = null;
    public static final WifiManager c = null;
    public static final AtomicBoolean d = null;
    public static final Handler e = null;
    public static AbstractC0138b f;
    public static final c g = null;

    /* JADX INFO: renamed from: s69.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0138b {

        /* JADX INFO: renamed from: s69.b$b$a */
        public static final class a extends AbstractC0138b {
            public final Network a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Available(network=" + this.a + ')';
            }

            public a(Network r2) {
                Intrinsics.checkNotNullParameter(r2, "network");
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: s69.b$b$b, reason: collision with other inner class name */
        public static final class C0139b extends AbstractC0138b {
            public final Network a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0139b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0139b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "CapabilitiesChanged(network=" + this.a + ')';
            }

            public C0139b(Network r2) {
                Intrinsics.checkNotNullParameter(r2, "network");
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: s69.b$b$c */
        public static final class c extends AbstractC0138b {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }
        }

        /* JADX INFO: renamed from: s69.b$b$d */
        public static final class d extends AbstractC0138b {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }
        }

        public AbstractC0138b() {
        }
    }

    public static final class c extends ConnectivityManager.NetworkCallback {
        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onUnavailable() {
            super.onUnavailable();
            g49.d.a("DoraWifiManager", "wifi unavailable");
            CopyOnWriteArraySet<a> r0 = b.a;
            b.a(AbstractC0138b.d.a);
        }

        public c() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network r3) {
            Intrinsics.checkNotNullParameter(r3, "network");
            super.onAvailable(r3);
            g49.d.a("DoraWifiManager", "network onAvailable");
            CopyOnWriteArraySet<a> r0 = b.a;
            b.a(new AbstractC0138b.a(r3));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network r2) {
            Intrinsics.checkNotNullParameter(r2, "network");
            super.onLost(r2);
            g49.d.a("DoraWifiManager", "wifi lost");
            CopyOnWriteArraySet<a> r3 = b.a;
            b.a(AbstractC0138b.c.a);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onCapabilitiesChanged(Network r2, NetworkCapabilities r3) {
            Intrinsics.checkNotNullParameter(r2, "network");
            Intrinsics.checkNotNullParameter(r3, "networkCapabilities");
            super.onCapabilitiesChanged(r2, r3);
            g49.d.a("DoraWifiManager", "network capabilities changed");
            CopyOnWriteArraySet<a> r4 = b.a;
            b.a(new AbstractC0138b.C0139b(r2));
        }
    }

    public b() {
    }

    static {
        a = new CopyOnWriteArraySet();
        AppHost.Companion r0 = AppHost.a;
        Object r1 = r0.getApplication().getSystemService("connectivity");
        WifiManager r3 = null;
        if ((r1 instanceof ConnectivityManager) == false) goto L5;
        ConnectivityManager r2 = (ConnectivityManager) r1;
    L6:
        b = r2;
        Object r4 = r0.getApplication().getApplicationContext().getSystemService("wifi");
        if ((r4 instanceof WifiManager) == false) goto L9;
        r3 = (WifiManager) r4;
    L9:
        c = r3;
        d = new AtomicBoolean(false);
        e = new Handler(Looper.getMainLooper());
        g = new c();
        return;
    L5:
        r2 = null;
        goto L6
    }

    public static final void a(AbstractC0138b r3) {
        g49.d.d("DoraWifiManager", "handleNetworkEvent event:" + r3);
        if (d.get() == true) goto L5;
        g49.d.d("DoraWifiManager", "not initialized, skip network event");
        return;
    L5:
        Handler r0 = e;
        r0.removeCallbacksAndMessages(null);
        f = r3;
        r0.postDelayed(new a(), 300);
    }

    public static WifiInfo b(WifiManager r18) {
        ArrayList r0 = new ArrayList();
        Object[] r10 = new Object[0];
        f06.b r11 = new f06.b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102301);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102301, "android/net/wifi/WifiManager", "getConnectionInfo", r18, r10, "android.net.wifi.WifiInfo", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (WifiInfo) r4.b;
    L21:
        return r18.getConnectionInfo();
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public static void c(Network r6) {
        ConnectivityManager r0 = b;
        boolean r1 = false;
        if (r0 == null) goto L9;
        NetworkCapabilities r7 = r0.getNetworkCapabilities(r6);
        if (r7 == null) goto L9;
        if (r7.hasTransport(1) != true) goto L9;
        boolean r8 = true;
    L10:
        String r2 = "none";
        if (r8 == true) goto L57;
        g49.d.e("DoraWifiManager", "network is not WiFi, skip update");
        Iterator<a> r9 = a.iterator();
    L14:
        if (r9.hasNext() == false) goto L16;
        r9.next().j("none");
        goto L14
    L16:
        return;
    L57:
        WifiManager r10 = c;     // Catch: Exception -> L21
        if (r10 == null) goto L23;
        WifiInfo r11 = b(r10);     // Catch: Exception -> L21
    L24:
        if (r11 != null) goto L59;
        g49.d.e("DoraWifiManager", "wifiInfo is null");
        Iterator<a> r12 = a.iterator();
    L54:
        if (r12.hasNext() == false) goto L56;
        r12.next().j("none");
        goto L54
    L56:
        return;
    L59:
        int r13 = r11.getFrequency();     // Catch: Exception -> L27
    L30:
        if (r13 > 0) goto L33;
        g49.d.e("DoraWifiManager", "Invalid frequency: " + r13);
    L48:
        g49.d.d("DoraWifiManager", "wifi band：" + r2 + "，frequency：" + r13 + " MHz");
        Iterator<a> r14 = a.iterator();
    L50:
        if (r14.hasNext() == false) goto L64;
        r14.next().j(r2);
        goto L50
    L64:
        return;
    L33:
        if (2400 <= r13) goto L35;
    L37:
        boolean r5 = false;
    L38:
        if (r5 == false) goto L41;
        r2 = "2.4G";
        goto L48
    L41:
        if (5150 <= r13) goto L43;
    L45:
        if (r1 == false) goto L47;
        r2 = "5G";
        goto L48
    L47:
        g49.d.e("DoraWifiManager", "Unknown frequency band: " + r13 + " MHz");
        goto L48
    L43:
        if (r13 >= 5851) goto L45;
        r1 = true;
        goto L45
    L35:
        if (r13 >= 2484) goto L37;
        r5 = true;
    L27:
        e = move-exception;
        g49.d.c("DoraWifiManager", "Failed to get frequency", e);
        r13 = 0;
    L23:
        r11 = null;
    L21:
        e = move-exception;
        g49.d.c("DoraWifiManager", "Failed to get wifiInfo", e);
    L9:
        r8 = false;
        goto L10
    }
}
