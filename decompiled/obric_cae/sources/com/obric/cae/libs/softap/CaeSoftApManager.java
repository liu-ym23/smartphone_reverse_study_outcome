package com.obric.cae.libs.softap;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.appcompat.app.r;
import androidx.room.k;
import androidx.room.l;
import com.obric.cae.libs.utils.LogUtil;
import j1.d0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import s1.x;

/* JADX INFO: loaded from: classes.dex */
public class CaeSoftApManager {
    public static final long SOFTAP_CAPABILITY_160MHZ = 2;
    public static final long SOFTAP_CAPABILITY_BASIC = 1;
    public static final long SOFTAP_CAPABILITY_HIDDEN_SSID = 128;
    public static final long SOFTAP_CAPABILITY_METERED = 256;
    public static final long SOFTAP_CAPABILITY_SECURITY_OPEN = 8;
    public static final long SOFTAP_CAPABILITY_SECURITY_WPA2_PSK = 16;
    public static final long SOFTAP_CAPABILITY_SECURITY_WPA2_WPA3_TRANSITION = 64;
    public static final long SOFTAP_CAPABILITY_SECURITY_WPA3_SAE = 32;
    public static final long SOFTAP_CAPABILITY_TX_POWER_CONTROL = 4;
    public static final int SOFTAP_INTERFACE_VERSION_1 = 1;
    public static final int SOFTAP_INTERFACE_VERSION_UNSUPPORTED = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile CaeSoftApManager f5452k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<ICaeSoftApManager> f5454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f5456d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ExecutorService f5457e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<c> f5458f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashSet<ICaeSoftApCallback> f5459g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f5460h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5461i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f5462j;

    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CaeSoftApManager f5463a;

        public a(CaeSoftApManager r8) {
            this.f5463a = r8;
        }

        public static /* synthetic */ void a(a r8, ICaeSoftApManager r10, ArrayList r11) {
            r8.a(r10, r11);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r8, IBinder r10) {
            ICaeSoftApManager r11 = ICaeSoftApManager.Stub.asInterface(r10);
            Object r12 = CaeSoftApManager.a(this.f5463a);
            monitor-enter(r12);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (CaeSoftApManager.b(this.f5463a) == false) goto L8;
            monitor-exit(r12);     // Catch: Throwable -> L12
            return;
        L8:
            CaeSoftApManager.c(this.f5463a).set(r11);     // Catch: Throwable -> L12
            CaeSoftApManager.d(this.f5463a);     // Catch: Throwable -> L12
            ArrayList r13 = new ArrayList(CaeSoftApManager.e(this.f5463a));     // Catch: Throwable -> L12
            CaeSoftApManager.e(this.f5463a).clear();     // Catch: Throwable -> L12
            monitor-exit(r12);     // Catch: Throwable -> L12
            LogUtil.i("CaeSoftApManager", "onServiceConnected: " + r8 + ", pending=" + r13.size());
            CaeSoftApManager.f(this.f5463a).execute(new l(this, r11, r13, 3));
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r8) {
            Object r10 = this.f5463a.f5455c;
            monitor-enter(r10);
            this.f5463a.f5454b.set(null);     // Catch: Throwable -> L8
            this.f5463a.f5461i = false;     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            LogUtil.e("CaeSoftApManager", "onServiceDisconnected: " + r8);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        private void a(ICaeSoftApManager r8, ArrayList r10) {
            CaeSoftApManager r11 = this.f5463a;
            Object r12 = r11.f5455c;
            monitor-enter(r12);
            ArrayList r13 = new ArrayList(r11.f5459g);     // Catch: Throwable -> L21
            monitor-exit(r12);     // Catch: Throwable -> L21
            Iterator r14 = r13.iterator();
        L8:
            if (r14.hasNext() == false) goto L16;
            ICaeSoftApCallback r15 = (ICaeSoftApCallback) r14.next();
            if (r11.b(r15) == false) goto L8;
            r8.registerCallback(r15);     // Catch: RemoteException -> L14
        L14:
            e = move-exception;
            com.obric.cae.libs.bluetooth.a.a("registerCallback on connect failed: ", e, "CaeSoftApManager");
            goto L8
        L16:
            Iterator r16 = r10.iterator();
        L18:
            if (r16.hasNext() == false) goto L20;
            c r17 = (c) r16.next();
            this.f5463a.a(r8, r17);
            goto L18
        L20:
            return;
        L21:
            th = move-exception;
            throw th;
        }
    }

    public interface b {
        void a(int r8);
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f5465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f5466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d f5467d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Runnable f5468e;

        public c(String r8, e r10, d r11) {
            this.f5466c = new AtomicBoolean(false);
            this.f5464a = r8;
            this.f5465b = r10;
            this.f5467d = r11;
        }

        public static c a(e r8, CaeSoftApStatusResultCallback r10) {
            return new c("getStatus", r8, new j(r10));
        }

        public static c a(String r8, e r10, CaeSoftApRequestCallback r11) {
            return new c(r8, r10, new m0.a(r11));
        }

        public static /* synthetic */ void a(CaeSoftApRequestCallback r8, int r10, String r11) {
            if (r8 == null) goto L5;
            r8.onError(r10, r11);
            return;
        }

        public static /* synthetic */ void a(CaeSoftApStatusResultCallback r8, int r10, String r11) {
            if (r8 == null) goto L5;
            r8.onError(r10, r11);
            return;
        }
    }

    public interface d {
        void onError(int r8, String r10);
    }

    public interface e {
        void a(ICaeSoftApManager r8);
    }

    public CaeSoftApManager(Context r8) {
        this.f5454b = new AtomicReference();
        this.f5455c = new Object();
        this.f5456d = new Handler(Looper.getMainLooper());
        this.f5457e = Executors.newSingleThreadExecutor(new i(0));
        this.f5458f = new ArrayList();
        this.f5459g = new LinkedHashSet();
        this.f5460h = new a(this);
        this.f5453a = r8.getApplicationContext();
    }

    public static /* synthetic */ void a(CaeSoftApManager r8, ICaeSoftApCallback r10) {
        r8.d(r10);
    }

    public static /* synthetic */ void b(CaeSoftApManager r8, c r10) {
        r8.b(r10);
    }

    public static /* synthetic */ void c(CaeSoftApManager r8, CaeSoftApStatusResultCallback r10, String r11, int r12) {
        r8.b(r10, r11, r12);
    }

    public static /* synthetic */ void d(CaeSoftApManager r8, String r10, ICaeSoftApManager r11, e r12, CaeSoftApRequestCallback r13) {
        r8.a(r10, r11, r12, r13);
    }

    public static /* synthetic */ ArrayList e(CaeSoftApManager r8) {
        return r8.f5458f;
    }

    public static /* synthetic */ ExecutorService f(CaeSoftApManager r8) {
        return r8.f5457e;
    }

    public static /* synthetic */ void g(CaeSoftApManager r8) {
        r8.e();
    }

    public static CaeSoftApManager getInstance(Context r8) {
        if (r8 == null) goto L18;
        if (f5452k != null) goto L16;
        monitor-enter(CaeSoftApManager.class);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (f5452k != null) goto L10;
        f5452k = new CaeSoftApManager(r8);     // Catch: Throwable -> L12
    L10:
        monitor-exit(CaeSoftApManager.class);     // Catch: Throwable -> L12
    L16:
        return f5452k;
    L18:
        throw new IllegalArgumentException("context cannot be null");
    }

    public static /* synthetic */ void h(CaeSoftApManager r8, c r10, int r11) {
        r8.b(r10, r11);
    }

    public static /* synthetic */ void i(CaeSoftApManager r8, CaeSoftApStatusResultCallback r10, ICaeSoftApManager r11) {
        r8.a(r10, r11);
    }

    public static /* synthetic */ void j(CaeSoftApManager r8, String r10, ICaeSoftApManager r11, e r12, CaeSoftApRequestCallback r13) {
        r8.b(r10, r11, r12, r13);
    }

    public static /* synthetic */ void k(CaeSoftApManager r8, String r10, ICaeSoftApManager r11, e r12, CaeSoftApStatusResultCallback r13) {
        r8.b(r10, r11, r12, r13);
    }

    public static /* synthetic */ void l(CaeSoftApManager r8, String r10, ICaeSoftApManager r11, e r12, CaeSoftApStatusResultCallback r13) {
        r8.a(r10, r11, r12, r13);
    }

    public static /* synthetic */ void m(CaeSoftApManager r8, ICaeSoftApCallback r10, CaeSoftApConfig r11, CaeSoftApRequestCallback r12, boolean r13, ICaeSoftApManager r14) {
        r8.a(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void n(CaeSoftApManager r8, CaeSoftApRequestCallback r10, String r11, int r12) {
        r8.a(r10, r11, r12);
    }

    public static /* synthetic */ void o(CaeSoftApManager r8, CaeSoftApStatusResultCallback r10, String r11, int r12) {
        r8.a(r10, r11, r12);
    }

    public static /* synthetic */ void p(CaeSoftApManager r8, CaeSoftApRequestCallback r10, ICaeSoftApManager r11) {
        r8.a(r10, r11);
    }

    public static /* synthetic */ void q(CaeSoftApManager r8, CaeSoftApRequestCallback r10, String r11, int r12) {
        r8.b(r10, r11, r12);
    }

    public static /* synthetic */ void r(CaeSoftApManager r8, ICaeSoftApCallback r10) {
        r8.c(r10);
    }

    public long getSoftApCapabilityBits() {
        ICaeSoftApManager r8 = d();
        if (r8 != null) goto L26;
        return 0;
    L26:
        return r8.getSoftApCapabilityBits();
    L10:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("getSoftApCapabilityBits RemoteException: ", e, "CaeSoftApManager");
        monitor-enter(this.f5455c);
        AtomicReference<ICaeSoftApManager> r10 = this.f5454b;     // Catch: Throwable -> L21
    L15:
        if (r10.compareAndSet(r8, null) == true) goto L19;
        if (r10.get() == r8) goto L15;
    L19:
        return 0;
    L21:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        LogUtil.e("CaeSoftApManager", "getSoftApCapabilityBits failed: " + e);
        return 0;
    }

    public int getSoftApInterfaceVersion() {
        ICaeSoftApManager r8 = d();
        if (r8 != null) goto L26;
        return 0;
    L26:
        return r8.getSoftApInterfaceVersion();
    L10:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("getSoftApInterfaceVersion RemoteException: ", e, "CaeSoftApManager");
        monitor-enter(this.f5455c);
        AtomicReference<ICaeSoftApManager> r10 = this.f5454b;     // Catch: Throwable -> L21
    L15:
        if (r10.compareAndSet(r8, null) == true) goto L19;
        if (r10.get() == r8) goto L15;
    L19:
        return 0;
    L21:
        th = move-exception;
        throw th;
    L7:
        e = move-exception;
        LogUtil.e("CaeSoftApManager", "getSoftApInterfaceVersion failed: " + e);
        return 0;
    }

    public void getStatus(CaeSoftApStatusResultCallback r8) {
        a(new com.obric.cae.libs.softap.c(0, this, r8), r8);
    }

    public boolean isReady() {
        if (this.f5454b.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void registerCallback(ICaeSoftApCallback r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Object r10 = this.f5455c;
        monitor-enter(r10);
    L21:
        th = move-exception;
        throw th;
    L7:
        if (this.f5462j == false) goto L11;
        monitor-exit(r10);     // Catch: Throwable -> L21
        return;
    L11:
        if (this.f5459g.add(r8) == true) goto L13;
    L15:
        boolean r11 = false;
    L16:
        b();     // Catch: Throwable -> L21
        monitor-exit(r10);     // Catch: Throwable -> L21
        if (r11 == false) goto L25;
        this.f5457e.execute(new k(13, this, r8));
        return;
    L25:
        return;
    L13:
        if (this.f5454b.get() == null) goto L15;
        r11 = true;
        goto L16
    }

    public void release() {
        Object r8 = this.f5455c;
        monitor-enter(r8);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.f5462j == false) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L24
        return;
    L8:
        this.f5462j = true;     // Catch: Throwable -> L24
        this.f5461i = false;     // Catch: Throwable -> L24
        ArrayList r10 = new ArrayList(this.f5458f);     // Catch: Throwable -> L24
        this.f5458f.clear();     // Catch: Throwable -> L24
        this.f5459g.clear();     // Catch: Throwable -> L24
        this.f5454b.set(null);     // Catch: Throwable -> L24
        monitor-exit(r8);     // Catch: Throwable -> L24
        Iterator r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L14;
        a((c) r11.next(), -10, "manager released");
        goto L12
    L14:
        this.f5456d.post(new androidx.activity.j(this, 19));
        this.f5457e.shutdownNow();
        monitor-enter(CaeSoftApManager.class);
    L21:
        th = move-exception;
        throw th;
    L17:
        if (f5452k != this) goto L19;
        f5452k = null;     // Catch: Throwable -> L21
    L19:
        monitor-exit(CaeSoftApManager.class);     // Catch: Throwable -> L21
    }

    public void startSoftAp(final CaeSoftApConfig r8, final ICaeSoftApCallback r10, final CaeSoftApRequestCallback r11) {
        if (r8 != null) goto L5;
        b(r11, -3, "config is null");
        return;
    L5:
        if (r10 != null) goto L7;
    L9:
        boolean r12 = false;
    L10:
        final boolean r13 = r12;
        a("startSoftAp", new h(this, r10, r8, r11, r13), r11);
        return;
    L7:
        if (a(r10) == false) goto L9;
        r12 = true;
        goto L10
    }

    public void stopSoftAp(CaeSoftApRequestCallback r8) {
        a("stopSoftAp", new com.obric.cae.libs.softap.c(1, this, r8), r8);
    }

    public void unregisterCallback(ICaeSoftApCallback r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        Object r10 = this.f5455c;
        monitor-enter(r10);
    L18:
        th = move-exception;
        throw th;
    L7:
        if (this.f5462j == false) goto L10;
        monitor-exit(r10);     // Catch: Throwable -> L18
        return;
    L10:
        this.f5459g.remove(r8);     // Catch: Throwable -> L18
        if (this.f5454b.get() == null) goto L13;
        boolean r11 = true;
    L14:
        monitor-exit(r10);     // Catch: Throwable -> L18
        if (r11 == false) goto L22;
        this.f5457e.execute(new r(12, this, r8));
        return;
    L22:
        return;
    L13:
        r11 = false;
        goto L14
    }

    public void warmUp() {
        Object r8 = this.f5455c;
        monitor-enter(r8);
        b();     // Catch: Throwable -> L7
        monitor-exit(r8);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Object a(CaeSoftApManager r8) {
        return r8.f5455c;
    }

    public static /* synthetic */ AtomicReference c(CaeSoftApManager r8) {
        return r8.f5454b;
    }

    private /* synthetic */ void e() {
        this.f5453a.unbindService(this.f5460h);     // Catch: Throwable -> L4
        return;
    }

    public final void b() {
        if (this.f5462j == false) goto L5;
        return;
    L5:
        if (this.f5454b.get() == null) goto L7;
        return;
    L7:
        if (this.f5461i == true) goto L13;
        this.f5461i = true;
        this.f5456d.post(new androidx.activity.k(this, 14));
        return;
    }

    public final ICaeSoftApManager d() {
        ICaeSoftApManager r8 = this.f5454b.get();
        if (r8 == null) goto L5;
        return r8;
    L5:
        Object r10 = this.f5455c;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.f5462j == true) goto L10;
        b();     // Catch: Throwable -> L13
    L10:
        ICaeSoftApManager r11 = this.f5454b.get();     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return r11;
    }

    public static /* synthetic */ Thread a(Runnable r8) {
        return new Thread(r8, "cae-softap-client");
    }

    private /* synthetic */ void b(c r8) {
        Object r10 = this.f5455c;
        monitor-enter(r10);
        boolean r11 = this.f5458f.remove(r8);     // Catch: Throwable -> L9
        monitor-exit(r10);     // Catch: Throwable -> L9
        if (r11 == false) goto L14;
        a(r8, -9, android.aimedia.a.i(new StringBuilder(), r8.f5464a, " connect timeout"));
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void d(CaeSoftApManager r8) {
        r8.f5461i = false;
    }

    public final void c() {
        Object r8 = this.f5455c;
        monitor-enter(r8);
        ArrayList r10 = new ArrayList(this.f5458f);     // Catch: Throwable -> L11
        this.f5458f.clear();     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        Iterator r11 = r10.iterator();
    L8:
        if (r11.hasNext() == false) goto L10;
        a((c) r11.next(), -8, "bindService returned false");
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private void c(ICaeSoftApCallback r8) {
        ICaeSoftApManager r10 = this.f5454b.get();
        if (r10 == null) goto L12;
        r10.registerCallback(r8);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("registerCallback RemoteException: ", e, "CaeSoftApManager");
        return;
    }

    private void d(ICaeSoftApCallback r8) {
        ICaeSoftApManager r10 = this.f5454b.get();
        if (r10 == null) goto L12;
        r10.unregisterCallback(r8);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        com.obric.cae.libs.bluetooth.a.a("unregisterCallback RemoteException: ", e, "CaeSoftApManager");
        return;
    }

    public final void a() {
        if (this.f5462j == false) goto L5;
        return;
    L5:
        if (this.f5454b.get() != null) goto L28;
        Intent r8 = new Intent("com.obric.cae.libs.softap.ICaeSoftApManager");
        r8.setPackage("com.obric.cae");
        boolean r10 = this.f5453a.bindService(r8, this.f5460h, 1);     // Catch: Throwable -> L10
    L12:
        if (r10 == true) goto L26;
        LogUtil.e("CaeSoftApManager", "bindService returned false, action=com.obric.cae.libs.softap.ICaeSoftApManager");
        c();
        Object r11 = this.f5455c;
        monitor-enter(r11);
        this.f5461i = false;     // Catch: Throwable -> L18
        monitor-exit(r11);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    L26:
        return;
    L10:
        th = move-exception;
        LogUtil.e("CaeSoftApManager", "bindService failed: " + th);
        r10 = false;
        goto L12
    }

    public final void a(c r8) {
        this.f5458f.add(r8);
        x r10 = new x(4, this, r8);
        r8.f5468e = r10;
        this.f5456d.postDelayed(r10, 3000);
    }

    public static void a(c r8, int r10) {
        String r11 = android.aimedia.a.i(new StringBuilder(), r8.f5464a, " request failed");
        r8.f5467d.onError(r10, r11);
    }

    private /* synthetic */ void b(c r8, int r10) {
        this.f5456d.post(new com.obric.cae.libs.softap.d(r10, 0, r8));
    }

    public static void b(c r8, int r10, String r11) {
        r8.f5467d.onError(r10, r11);
    }

    public final void b(CaeSoftApRequestCallback r8, int r10, String r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.f5456d.post(new v0.a(r8, r10, 3, r11));
    }

    private /* synthetic */ void b(CaeSoftApRequestCallback r8, String r10, int r11) {
        b(r8, r11, r10 + " request failed");
    }

    public final void a(c r8, int r10, String r11) {
        int r12 = 0;
        if (r8.f5466c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Runnable r13 = r8.f5468e;
        if (r13 == null) goto L8;
        this.f5456d.removeCallbacks(r13);
    L8:
        this.f5456d.post(new g(r8, r10, r12, r11));
    }

    public final void a(e r11, CaeSoftApStatusResultCallback r12) {
        String r8 = "getStatus";
        ICaeSoftApManager r10 = this.f5454b.get();
        if (r10 == null) goto L6;
        this.f5457e.execute(new com.obric.cae.libs.softap.b(this, r8, r10, r11, r12, 0));
        return;
    L6:
        c r13 = c.a(r11, r12);
        Object r14 = this.f5455c;
        monitor-enter(r14);
    L21:
        th = move-exception;
        throw th;
    L9:
        if (this.f5462j == false) goto L13;
        b(r12, -10, "manager released");     // Catch: Throwable -> L21
        monitor-exit(r14);     // Catch: Throwable -> L21
        return;
    L13:
        ICaeSoftApManager r15 = this.f5454b.get();     // Catch: Throwable -> L21
        if (r15 == null) goto L18;
        this.f5457e.execute(new d0(this, r8, r15, r11, r12, 2));     // Catch: Throwable -> L21
        monitor-exit(r14);     // Catch: Throwable -> L21
        return;
    L18:
        a(r13);     // Catch: Throwable -> L21
        b();     // Catch: Throwable -> L21
        monitor-exit(r14);     // Catch: Throwable -> L21
    }

    public final void b(CaeSoftApStatusResultCallback r8, int r10, String r11) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.f5456d.post(new n4.d(r8, r10, 2, r11));
    }

    public final void a(CaeSoftApRequestCallback r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.f5456d.post(new androidx.activity.d(r8, 18));
    }

    public final void b(CaeSoftApStatusResultCallback r8, CaeSoftApStatus r10) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.f5456d.post(new k(12, r8, r10));
    }

    public static /* synthetic */ void a(CaeSoftApRequestCallback r8, int r10, String r11) {
        r8.onError(r10, r11);
    }

    private /* synthetic */ void b(CaeSoftApStatusResultCallback r8, String r10, int r11) {
        b(r8, r11, r10 + " request failed");
    }

    private /* synthetic */ void a(CaeSoftApRequestCallback r8, ICaeSoftApManager r10) {
        int r11 = r10.stopSoftAp();
        if (r11 != 0) goto L5;
        a(r8);
        return;
    L5:
        b(r8, r11, "stopSoftAp returned " + r11);
    }

    private /* synthetic */ void b(String r8, ICaeSoftApManager r10, e r11, CaeSoftApRequestCallback r12) {
        a(r8, r10, r11, new com.obric.cae.libs.softap.e(this, r12, r8, 0));
    }

    private /* synthetic */ void a(CaeSoftApRequestCallback r8, String r10, int r11) {
        b(r8, r11, r10 + " request failed");
    }

    private /* synthetic */ void b(String r8, ICaeSoftApManager r10, e r11, CaeSoftApStatusResultCallback r12) {
        a(r8, r10, r11, new com.obric.cae.libs.softap.a(this, r12, r8, 1));
    }

    public static /* synthetic */ void a(CaeSoftApStatusResultCallback r8, int r10, String r11) {
        r8.onError(r10, r11);
    }

    public static /* synthetic */ boolean b(CaeSoftApManager r8) {
        return r8.f5462j;
    }

    public static /* synthetic */ void a(CaeSoftApStatusResultCallback r8, CaeSoftApStatus r10) {
        r8.onSuccess(r10);
    }

    public final boolean b(ICaeSoftApCallback r8) {
        Object r10 = this.f5455c;
        monitor-enter(r10);
        boolean r11 = this.f5459g.contains(r8);     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void a(CaeSoftApStatusResultCallback r8, ICaeSoftApManager r10) {
        b(r8, r10.getStatus());
    }

    private /* synthetic */ void a(CaeSoftApStatusResultCallback r8, String r10, int r11) {
        b(r8, r11, r10 + " request failed");
    }

    private void a(ICaeSoftApCallback r8, CaeSoftApConfig r10, CaeSoftApRequestCallback r11, boolean r12, ICaeSoftApManager r13) {
        if (r8 != null) goto L4;
    L6:
        ICaeSoftApCallback r14 = null;
    L7:
        int r15 = r13.startSoftAp(r10, r14);
        if (r15 != 0) goto L10;
        a(r11);
        return;
    L10:
        if (r12 == false) goto L19;
        Object r16 = this.f5455c;
        monitor-enter(r16);
        this.f5459g.remove(r8);     // Catch: Throwable -> L16
        monitor-exit(r16);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L19:
        b(r11, r15, "startSoftAp returned " + r15);
        return;
    L4:
        if (b(r8) == false) goto L6;
        r14 = r8;
        goto L7
    }

    public final void a(ICaeSoftApManager r8, final c r10) {
        if (r10.f5466c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        Runnable r11 = r10.f5468e;
        if (r11 == null) goto L8;
        this.f5456d.removeCallbacks(r11);
    L8:
        a(r10.f5464a, r8, r10.f5465b, new f(this, r10));
    }

    public final void a(String r11, e r12, CaeSoftApRequestCallback r13) {
        ICaeSoftApManager r8 = this.f5454b.get();
        if (r8 == null) goto L6;
        this.f5457e.execute(new com.obric.cae.libs.softap.b(this, r11, r8, r12, r13, 1));
        return;
    L6:
        c r10 = c.a(r11, r12, r13);
        Object r14 = this.f5455c;
        monitor-enter(r14);
    L21:
        th = move-exception;
        throw th;
    L9:
        if (this.f5462j == false) goto L13;
        b(r13, -10, "manager released");     // Catch: Throwable -> L21
        monitor-exit(r14);     // Catch: Throwable -> L21
        return;
    L13:
        ICaeSoftApManager r15 = this.f5454b.get();     // Catch: Throwable -> L21
        if (r15 == null) goto L18;
        this.f5457e.execute(new d0(this, r11, r15, r12, r13, 3));     // Catch: Throwable -> L21
        monitor-exit(r14);     // Catch: Throwable -> L21
        return;
    L18:
        a(r10);     // Catch: Throwable -> L21
        b();     // Catch: Throwable -> L21
        monitor-exit(r14);     // Catch: Throwable -> L21
    }

    public final void a(String r8, ICaeSoftApManager r10, e r11, b r12) {
        r11.a(r10);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        monitor-enter(this.f5455c);
        AtomicReference<ICaeSoftApManager> r13 = this.f5454b;     // Catch: Throwable -> L16
    L9:
        if (r13.compareAndSet(r10, null) == true) goto L13;
        if (r13.get() == r10) goto L9;
    L13:
        LogUtil.e("CaeSoftApManager", r8 + " RemoteException: " + e);
        r12.a(-10);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void a(String r8, ICaeSoftApManager r10, e r11, CaeSoftApRequestCallback r12) {
        a(r8, r10, r11, new com.obric.cae.libs.softap.e(this, r12, r8, 1));
    }

    private /* synthetic */ void a(String r8, ICaeSoftApManager r10, e r11, CaeSoftApStatusResultCallback r12) {
        a(r8, r10, r11, new com.obric.cae.libs.softap.a(this, r12, r8, 0));
    }

    public final boolean a(ICaeSoftApCallback r8) {
        Object r10 = this.f5455c;
        monitor-enter(r10);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.f5462j == false) goto L7;
    L9:
        boolean r11 = false;
    L10:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return r11;
    L7:
        if (this.f5459g.add(r8) == false) goto L9;
        r11 = true;
        goto L10
    }
}
