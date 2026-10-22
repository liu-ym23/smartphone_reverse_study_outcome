package com.obric.cae.libs.nfc;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.activity.k;
import com.obric.cae.libs.utils.LogUtil;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class CaeNfcAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f5432d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f5433e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static CaeNfcAdapter f5434f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ICaeNfcAdapter f5435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile CaeNfcOmapiExecutor f5436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile CaeNfcEventManager f5437c;

    public class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeNfcAdapter f5438a;

        public a(CaeNfcAdapter r8) {
            this.f5438a = r8;
        }

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            LogUtil.e("NFC:CaeNfcAdapter", "cae_nfc service is dead!");
            this.f5438a.f5435a = null;
            this.f5438a.f5436b = null;
            this.f5438a.f5437c = null;
            this.f5438a.c();
        }
    }

    static {
        f5432d = new Object();
    }

    public CaeNfcAdapter(Context r8) {
        r8.getApplicationContext();
        this.f5435a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L5
    L8:
        if (this.f5435a == null) goto L10;
        d();
        return;
    L10:
        c();
        return;
    L5:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "Get service failed: " + e);
        goto L8
    }

    public static /* synthetic */ void a(CaeNfcAdapter r8) {
        r8.b();
    }

    private /* synthetic */ void b() {
        int r8 = 0;
    L4:
        if (r8 >= 10) goto L12;
        this.f5435a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L9
        if (this.f5435a == null) goto L11;
        d();     // Catch: Exception -> L9
        LogUtil.d("NFC:CaeNfcAdapter", "Get service success after retry");     // Catch: Exception -> L9
        return;
    L11:
        r8 = r8 + 1;
        SystemClock.sleep(300);
    L9:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "Retry get service failed: " + e);
        goto L11
    L12:
        LogUtil.e("NFC:CaeNfcAdapter", "Retry get service failed after 10 times");
    }

    public static CaeNfcAdapter getDefaultAdapter(Context r8) {
        if (r8 == null) goto L15;
        monitor-enter(CaeNfcAdapter.class);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f5434f != null) goto L8;
        f5434f = new CaeNfcAdapter(r8);     // Catch: Throwable -> L11
    L8:
        monitor-exit(CaeNfcAdapter.class);     // Catch: Throwable -> L11
        return f5434f;
    L15:
        throw new IllegalArgumentException("context cannot be null");
    }

    public final void c() {
        new Thread(new k(this, 13)).start();
    }

    public final void d() {
        this.f5435a.asBinder().linkToDeath(new a(this), 0);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("linkToDeath failed: ", e, "NFC:CaeNfcAdapter");
    }

    public CaeNfcEventManager getEventManager() {
        if (this.f5437c == null) goto L7;
        return this.f5437c;
    L7:
        if (this.f5435a == null) goto L28;
    L27:
        ICaeNfcEventManager r8 = this.f5435a.getEventManager();     // Catch: RemoteException -> L24
        if (r8 != null) goto L22;
        LogUtil.e("NFC:CaeNfcAdapter", "getEventManager: service is null");     // Catch: RemoteException -> L24
        return null;
    L22:
        this.f5437c = new CaeNfcEventManager(r8);     // Catch: RemoteException -> L24
        return this.f5437c;
    L24:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcAdapter");
        return null;
    L28:
        this.f5435a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L12
        if (this.f5435a == null) goto L14;
        d();     // Catch: Exception -> L12
        boolean r10 = true;
    L15:
        if (r10 == true) goto L27;
        LogUtil.e("NFC:CaeNfcAdapter", "getEventManager: mICaeNfcAdapter is null");
        return null;
    L14:
        c();
        r10 = false;
    L12:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "ensureService failed: " + e);
        goto L14
    }

    public CaeNfcOmapiExecutor getOmapiExecutor() {
        if (this.f5436b == null) goto L7;
        return this.f5436b;
    L7:
        if (this.f5435a == null) goto L28;
    L27:
        ICaeNfcOmapiExecutor r8 = this.f5435a.getOmapiExecutor();     // Catch: RemoteException -> L24
        if (r8 != null) goto L22;
        LogUtil.e("NFC:CaeNfcAdapter", "getOmapiExecutor: service is null");     // Catch: RemoteException -> L24
        return null;
    L22:
        this.f5436b = new CaeNfcOmapiExecutor(r8);     // Catch: RemoteException -> L24
        return this.f5436b;
    L24:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("RemoteException: ", e, "NFC:CaeNfcAdapter");
        return null;
    L28:
        this.f5435a = ICaeNfcAdapter.Stub.asInterface(a());     // Catch: Exception -> L12
        if (this.f5435a == null) goto L14;
        d();     // Catch: Exception -> L12
        boolean r10 = true;
    L15:
        if (r10 == true) goto L27;
        LogUtil.e("NFC:CaeNfcAdapter", "getOmapiExecutor: mICaeNfcAdapter is null");
        return null;
    L14:
        c();
        r10 = false;
    L12:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "ensureService failed: " + e);
        goto L14
    }

    public static IBinder a() {
        Object r8 = f5432d;
        monitor-enter(r8);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f5433e != null) goto L7;
        f5433e = Class.forName("android.os.ServiceManager").getMethod("getService", new Class[]{String.class});     // Catch: Throwable -> L15
    L7:
        Method r10 = f5433e;     // Catch: Throwable -> L15
        monitor-exit(r8);     // Catch: Throwable -> L15
        return (IBinder) r10.invoke(null, new Object[]{CaeNfcConstants.SERVICE_NAME_NFC});
    L12:
        e = move-exception;
        LogUtil.e("NFC:CaeNfcAdapter", "getService denied: " + e);
        return null;
    }
}
