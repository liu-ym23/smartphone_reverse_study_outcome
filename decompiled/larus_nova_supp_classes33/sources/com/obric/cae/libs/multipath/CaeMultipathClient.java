package com.obric.cae.libs.multipath;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class CaeMultipathClient {
    public static volatile CaeMultipathClient e;
    public ICaeMultipathManager a;
    public HandlerThread b;
    public a c;
    public boolean d;

    public class a extends Handler {
        public final /* synthetic */ CaeMultipathClient a;

        @Override // android.os.Handler
        public final void handleMessage(Message r3) {
            int r4 = r3.what;
            boolean r0 = true;
            if (r4 != 1) goto L5;
            CaeMultipathClient.a(this.a);
            return;
        L5:
            if (r4 != 2) goto L17;
            CaeMultipathClient r5 = this.a;
            if (r5.a != null) goto L11;
            r0 = false;
        L11:
            if (r0 == true) goto L15;
            CaeMultipathClient.a(r5);
            return;
        L15:
            return;
        }

        public a(CaeMultipathClient r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static CaeMultipathClient getInstance() {
        if (e != null) goto L15;
        monitor-enter(CaeMultipathClient.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new CaeMultipathClient();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CaeMultipathClient.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    public final void a() {
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("CaeMultipathConnectThread");
        this.b = r0;
        ThreadMethodProxy.start(r0);
        this.c = new a(this, this.b.getLooper());
    }

    public String getLatestNetworkTruth() {
        ICaeMultipathManager r0 = this.a;
        if (r0 == null) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L12;
        return null;
    L12:
        return r0.getLatestNetworkTruth();
    L11:
        return null;
    L5:
        r1 = false;
        goto L7
    }

    public boolean reportAssistantFailure() {
        ICaeMultipathManager r0 = this.a;
        if (r0 == null) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L11;
        return false;
    L11:
        r0.reportAssistantFailure();     // Catch: Exception -> L10
        return true;
    L10:
        return false;
    L5:
        r3 = false;
        goto L6
    }

    public CaeMultipathClient() {
        this.d = false;
        a();
        this.c.sendEmptyMessage(1);
    }

    public static void a(CaeMultipathClient r10) {
        if (r10.d == true) goto L33;
        r10.d = true;
        IBinder r5 = ServiceManager.getService("cae_multipath");     // Catch: Throwable -> L18 Exception -> L20
        if (r5 != null) goto L28;
        r10.c.removeMessages(2);     // Catch: Throwable -> L18 Exception -> L20
        r10.c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L18 Exception -> L20
    L21:
        r10.d = false;
        return;
    L28:
        int r7 = ICaeMultipathManager.Stub.TRANSACTION_startMultipath;     // Catch: Exception -> L16 Throwable -> L18
        ICaeMultipathManager r0 = (ICaeMultipathManager) ICaeMultipathManager.Stub.class.getMethod("asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r5});     // Catch: Exception -> L16 Throwable -> L18
        r10.a = r0;     // Catch: Exception -> L16 Throwable -> L18
        if (r0 != null) goto L26;
        r10.c.removeMessages(2);     // Catch: Exception -> L16 Throwable -> L18
        r10.c.sendEmptyMessageDelayed(2, 5000);     // Catch: Exception -> L16 Throwable -> L18
        goto L21
    L26:
        r5.linkToDeath(new com.obric.cae.libs.multipath.a(r10), 0);     // Catch: RemoteException -> L25 Throwable -> L18 Exception -> L20
    L15:
        r10.d = false;
        return;
    L16:
        r10.c.removeMessages(2);     // Catch: Throwable -> L18 Exception -> L20
        r10.c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L18 Exception -> L20
    L20:
        r10.c.removeMessages(2);     // Catch: Throwable -> L18
        r10.c.sendEmptyMessageDelayed(2, 5000);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        r10.d = false;
        throw th;
    }
}
