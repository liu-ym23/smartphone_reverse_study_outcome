package k0;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q7.a f18573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18574c;
    public boolean d;
    public final e6.d e;

    public b(Context r5, q7.a r10) {
        this.e = new e6.d(this, 1);
        this.f18572a = r5.getApplicationContext();
        this.f18573b = r10;
    }

    public static boolean j(Context r5) {
        ConnectivityManager r10 = (ConnectivityManager) r5.getSystemService("connectivity");
        io.reactivex.internal.observers.h.h(r10, "Argument must not be null");
        NetworkInfo r11 = r10.getActiveNetworkInfo();     // Catch: RuntimeException -> L10
        if (r11 != null) goto L6;
    L8:
        return false;
    L6:
        if (r11.isConnected() == false) goto L8;
        return true;
    L10:
        e = move-exception;
        if (Log.isLoggable("ConnectivityMonitor", 5) == false) goto L14;
        Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
    L14:
        return true;
    }

    @Override // k0.d
    public final void i() {
        if (this.d == false) goto L7;
        e6.d r5 = this.e;
        this.f18572a.unregisterReceiver(r5);
        this.d = false;
        return;
    }

    @Override // k0.d
    public final void onDestroy() {
    }

    @Override // k0.d
    public final void onStart() {
        if (this.d == true) goto L16;
        Context r5 = this.f18572a;
        this.f18574c = j(r5);
        r5.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));     // Catch: SecurityException -> L8
        this.d = true;     // Catch: SecurityException -> L8
        return;
    L8:
        e = move-exception;
        if (Log.isLoggable("ConnectivityMonitor", 5) == false) goto L15;
        Log.w("ConnectivityMonitor", "Failed to register", e);
        return;
    L15:
        return;
    }
}
