package p1;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: classes.dex */
public final class j extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f9928a;

    public j(k r8) {
        this.f9928a = r8;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onCapabilitiesChanged(Network r8, NetworkCapabilities r10) {
        he.i.f(r8, "network");
        he.i.f(r10, "capabilities");
        androidx.work.m.d().a(l.f9931a, "Network capabilities changed: " + r10);
        k r11 = this.f9928a;
        r11.c(l.a(r11.f9929f));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network r8) {
        he.i.f(r8, "network");
        androidx.work.m.d().a(l.f9931a, "Network connection lost");
        k r10 = this.f9928a;
        r10.c(l.a(r10.f9929f));
    }
}
