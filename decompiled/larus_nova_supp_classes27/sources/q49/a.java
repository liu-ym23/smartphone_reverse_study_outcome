package q49;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.dora.impl.device.settings.lab.env.DoraEnvObserveManager;
import g49.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a extends p49.a {
    public static final C0137a b = null;
    public static volatile a c;
    public final b a;

    /* JADX INFO: renamed from: q49.a$a, reason: collision with other inner class name */
    public static final class C0137a {
        public final a a() {
            a r0 = a.c;
            if (r0 != null) goto L15;
            monitor-enter(this);
            r0 = a.c;     // Catch: Throwable -> L9
            if (r0 != null) goto L11;
            r0 = new a();     // Catch: Throwable -> L9
            a.c = r0;     // Catch: Throwable -> L9
        L11:
            monitor-exit(this);
        L9:
            th = move-exception;
            throw th;
        L15:
            return r0;
        }

        public C0137a() {
        }
    }

    public static final class b extends ConnectivityManager.NetworkCallback {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onAvailable(Network r3) {
            Intrinsics.checkNotNullParameter(r3, "network");
            super.onAvailable(r3);
            d.d("NetWorkJob", "network = " + r3);
            a r4 = this.a;
            EnvObserveChangeReason r0 = EnvObserveChangeReason.NETWORK_CHANGE;
            r4.getClass();
            Intrinsics.checkNotNullParameter(r0, "reason");
            DoraEnvObserveManager.a.getClass();
            DoraEnvObserveManager.h(r0, 0);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public final void onLost(Network r3) {
            Intrinsics.checkNotNullParameter(r3, "network");
            super.onLost(r3);
            d.d("NetWorkJob", "onLost network = " + r3);
        }
    }

    static {
        b = new C0137a();
    }

    public final void a() {
        Object r0 = AppHost.a.getApplication().getSystemService("connectivity");     // Catch: Exception -> L6
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L6
        ConnectivityManager r1 = (ConnectivityManager) r0;     // Catch: Exception -> L6
        r1.unregisterNetworkCallback(this.a);     // Catch: Exception -> L8
    L4:
        r1.registerNetworkCallback(new NetworkRequest.Builder().build(), this.a);     // Catch: Exception -> L6
        return;
    L6:
        d.d("NetWorkJob", "registerNetworkCallback failed!");
    }

    public a() {
        this.a = new b(this);
    }
}
