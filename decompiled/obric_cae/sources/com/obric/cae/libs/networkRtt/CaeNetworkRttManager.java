package com.obric.cae.libs.networkRtt;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.obric.cae.libs.utils.LogUtil;

/* JADX INFO: loaded from: classes.dex */
public class CaeNetworkRttManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static CaeNetworkRttManager f5428b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ICaeNetworkRtt f5429a;

    public class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeNetworkRttManager f5430a;

        public a(CaeNetworkRttManager r8) {
            this.f5430a = r8;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("CaeNetworkRttManager", "rtt query service is dead!");
            this.f5430a.f5429a = null;
            this.f5430a.a();
        }
    }

    public class b extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeNetworkRttManager f5431a;

        public b(CaeNetworkRttManager r8) {
            this.f5431a = r8;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            int r8 = 0;
        L4:
            if (r8 >= 50) goto L15;
            SystemClock.sleep(100);
            this.f5431a.f5429a = ICaeNetworkRtt.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_network_rtt"}));     // Catch: Exception -> L8
        L11:
            if (this.f5431a.f5429a != null) goto L12;
            r8 = r8 + 1;
            goto L4
        L12:
            this.f5431a.b();
            return;
        L8:
            e = move-exception;
            LogUtil.e("CaeNetworkRttManager", "Get service failed", e);
            goto L11
        L15:
            LogUtil.e("CaeNetworkRttManager", "get rtt query service failed after retries");
        }
    }

    public CaeNetworkRttManager(Context r8) {
        this.f5429a = ICaeNetworkRtt.Stub.asInterface((IBinder) Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class}).invoke(null, new Object[]{"cae_network_rtt"}));     // Catch: Exception -> L5
    L8:
        if (this.f5429a == null) goto L10;
        b();
        return;
    L10:
        a();
        return;
    L5:
        e = move-exception;
        LogUtil.e("CaeNetworkRttManager", "Get service failed", e);
        goto L8
    }

    public static CaeNetworkRttManager getInstance(Context r8) {
        if (r8 == null) goto L15;
        monitor-enter(CaeNetworkRttManager.class);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f5428b != null) goto L8;
        f5428b = new CaeNetworkRttManager(r8);     // Catch: Throwable -> L11
    L8:
        monitor-exit(CaeNetworkRttManager.class);     // Catch: Throwable -> L11
        return f5428b;
    L15:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void a() {
        new b(this).start();
    }

    public final void b() {
        this.f5429a.asBinder().linkToDeath(new a(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        LogUtil.e("CaeNetworkRttManager", "linkToDeath failed", e);
    }

    public int getGameRttbyUid(int r8) {
        ICaeNetworkRtt r10 = this.f5429a;
        if (r10 != null) goto L11;
        LogUtil.e("CaeNetworkRttManager", "getGameRttbyUid: service is null");
        return -1;
    L11:
        return r10.getGameRttbyUid(r8);
    L8:
        e = move-exception;
        LogUtil.e("CaeNetworkRttManager", "getGameRttbyUid failed", e);
        return -1;
    }

    public int getRttByUid(int r8) {
        ICaeNetworkRtt r10 = this.f5429a;
        if (r10 != null) goto L11;
        LogUtil.e("CaeNetworkRttManager", "getRttByUid: service is null");
        return -1;
    L11:
        return r10.getRttByUid(r8);
    L8:
        e = move-exception;
        LogUtil.e("CaeNetworkRttManager", "getRttByUid failed", e);
        return -1;
    }

    public boolean isServiceAvailable() {
        if (this.f5429a == null) goto L5;
        return true;
    L5:
        return false;
    }
}
