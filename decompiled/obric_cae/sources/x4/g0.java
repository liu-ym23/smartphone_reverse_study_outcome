package x4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class g0 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0.d f13428b;

    public g0(d0.d r8) {
        this.f13428b = r8;
        this.f13427a = true;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r8, Intent r10) {
        if (this.f13427a == false) goto L6;
        this.f13427a = false;
        return;
    L6:
        if (r10 != null) goto L10;
        int r11 = r.f13543a;
        return;
    L10:
        if (r10.getBooleanExtra("noConnectivity", false) == false) goto L14;
        int r12 = r.f13543a;
        return;
    L14:
        if (k5.e.a(this.f13428b.f13408c) == false) goto L23;
        d0.d r13 = this.f13428b;
        monitor-enter(r13);
        t.e(new h0(r13), t.a(t.f13552d));     // Catch: Throwable -> L20
        monitor-exit(r13);
        return;
    L20:
        th = move-exception;
        throw th;
    }
}
