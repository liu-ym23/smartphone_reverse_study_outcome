package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.m;
import j1.b0;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2844a = null;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f2845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f2846b;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ BroadcastReceiver.PendingResult f2847m;

        public a(Intent r8, Context r10, BroadcastReceiver.PendingResult r11) {
            this.f2845a = r8;
            this.f2846b = r10;
            this.f2847m = r11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BroadcastReceiver.PendingResult r8 = this.f2847m;
            Context r10 = this.f2846b;
            Intent r11 = this.f2845a;
            boolean r12 = r11.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);     // Catch: Throwable -> L6
            boolean r13 = r11.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);     // Catch: Throwable -> L6
            boolean r14 = r11.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);     // Catch: Throwable -> L6
            boolean r15 = r11.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);     // Catch: Throwable -> L6
            m.d().a(ConstraintProxyUpdateReceiver.f2844a, "Updating proxies: (BatteryNotLowProxy (" + r12 + "), BatteryChargingProxy (" + r13 + "), StorageNotLowProxy (" + r14 + "), NetworkStateProxy (" + r15 + "), ");     // Catch: Throwable -> L6
            s1.m.a(r10, ConstraintProxy.BatteryNotLowProxy.class, r12);     // Catch: Throwable -> L6
            s1.m.a(r10, ConstraintProxy.BatteryChargingProxy.class, r13);     // Catch: Throwable -> L6
            s1.m.a(r10, ConstraintProxy.StorageNotLowProxy.class, r14);     // Catch: Throwable -> L6
            s1.m.a(r10, ConstraintProxy.NetworkStateProxy.class, r15);     // Catch: Throwable -> L6
            r8.finish();
            return;
        L6:
            th = move-exception;
            r8.finish();
            throw th;
        }
    }

    static {
        f2844a = m.f("ConstrntProxyUpdtRecvr");
    }

    public ConstraintProxyUpdateReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r8, Intent r10) {
        if (r10 == null) goto L4;
        String r11 = r10.getAction();
    L6:
        if ("androidx.work.impl.background.systemalarm.UpdateProxies".equals(r11) == true) goto L8;
        m r12 = m.d();
        String r13 = defpackage.b.c("Ignoring unknown action ", r11);
        r12.a(f2844a, r13);
        return;
    L8:
        BroadcastReceiver.PendingResult r14 = goAsync();
        b0.f(r8).f8454d.a(new a(r10, r8, r14));
        return;
    L4:
        r11 = null;
        goto L6
    }
}
