package com.bumptech.glide.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile q f932b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Set<com.bumptech.glide.manager.b.a> f933a;
    private final a c;
    private boolean d;

    private interface a {
        boolean a();

        void b();
    }

    private static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.manager.b.a f938b;
        private final com.bumptech.glide.util.e.a<ConnectivityManager> c;
        private final ConnectivityManager.NetworkCallback d;

        /* JADX INFO: renamed from: com.bumptech.glide.manager.q$b$1, reason: invalid class name */
        class AnonymousClass1 extends ConnectivityManager.NetworkCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f939a;

            AnonymousClass1(b r1) {
                this.f939a = r1;
            }

            private void b(final boolean r2) {
                com.bumptech.glide.util.k.a(new RunnableC00711(this, r2));
            }

            void a(boolean r3) {
                com.bumptech.glide.util.k.a();
                boolean r0 = this.f939a.f937a;
                this.f939a.f937a = r3;
                if (r0 == r3) goto L6;
                this.f939a.f938b.a(r3);
                return;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network r1) {
                b(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network r1) {
                b(false);
            }
        }

        b(com.bumptech.glide.util.e.a<ConnectivityManager> r3, com.bumptech.glide.manager.b.a r4) {
            com.bumptech.glide.util.e.a<ConnectivityManager> r5 = (com.bumptech.glide.util.e.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.util.e.a.class, "com.obric.memorydata.plugin");
            com.bumptech.glide.manager.b.a r6 = (com.bumptech.glide.manager.b.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.manager.b.a.class, "com.obric.memorydata.plugin");
            this.d = new AnonymousClass1(this);
            this.c = r5;
            this.f938b = r6;
        }

        @Override // com.bumptech.glide.manager.q.a
        public boolean a() {
            if (((ConnectivityManager) ZeusTransformUtils.preCheckCast(this.c.b(), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetwork() == null) goto L5;
            boolean r0 = true;
        L6:
            this.f937a = r0;
            ((ConnectivityManager) ZeusTransformUtils.preCheckCast(this.c.b(), ConnectivityManager.class, "com.obric.memorydata.plugin")).registerDefaultNetworkCallback(this.d);     // Catch: RuntimeException -> L9
            return true;
        L9:
            e = move-exception;
            if (Log.isLoggable("ConnectivityMonitor", 5) == false) goto L13;
            Log.w("ConnectivityMonitor", "Failed to register callback", e);
        L13:
            return false;
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.bumptech.glide.manager.q.a
        public void b() {
            ((ConnectivityManager) ZeusTransformUtils.preCheckCast(this.c.b(), ConnectivityManager.class, "com.obric.memorydata.plugin")).unregisterNetworkCallback(this.d);
        }
    }

    private static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Executor f942a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Context f943b;
        final com.bumptech.glide.manager.b.a c;
        volatile boolean d;
        volatile boolean e;
        final PluginBroadcastReceiver f;
        private final com.bumptech.glide.util.e.a<ConnectivityManager> g;

        static {
            f942a = AsyncTask.SERIAL_EXECUTOR;
        }

        c(Context r3, com.bumptech.glide.util.e.a<ConnectivityManager> r4, com.bumptech.glide.manager.b.a r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            com.bumptech.glide.util.e.a<ConnectivityManager> r7 = (com.bumptech.glide.util.e.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.util.e.a.class, "com.obric.memorydata.plugin");
            com.bumptech.glide.manager.b.a r8 = (com.bumptech.glide.manager.b.a) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.manager.b.a.class, "com.obric.memorydata.plugin");
            this.f = new AnonymousClass1(this);
            this.f943b = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
            this.g = r7;
            this.c = r8;
        }

        void a(final boolean r2) {
            com.bumptech.glide.util.k.a(new AnonymousClass5(this, r2));
        }

        @Override // com.bumptech.glide.manager.q.a
        public boolean a() {
            f942a.execute(new AnonymousClass2(this));
            return true;
        }

        @Override // com.bumptech.glide.manager.q.a
        public void b() {
            f942a.execute(new AnonymousClass3(this));
        }

        void c() {
            f942a.execute(new AnonymousClass4(this));
        }

        boolean d() {
            NetworkInfo r3 = ((ConnectivityManager) ZeusTransformUtils.preCheckCast(this.g.b(), ConnectivityManager.class, "com.obric.memorydata.plugin")).getActiveNetworkInfo();     // Catch: RuntimeException -> L10
            if (r3 != null) goto L6;
        L8:
            return false;
        L6:
            if (r3.isConnected() == false) goto L8;
            return true;
        L10:
            e = move-exception;
            if (Log.isLoggable("ConnectivityMonitor", 5) == false) goto L14;
            Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
        L14:
            return true;
        }
    }

    private q(Context r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        this.f933a = new HashSet();
        com.bumptech.glide.util.e.a r0 = com.bumptech.glide.util.e.a(new AnonymousClass1(this, r6));
        com.bumptech.glide.manager.b.a r1 = new AnonymousClass2(this);
        if (Build.VERSION.SDK_INT < 24) goto L5;
        a r7 = new b(r0, r1);
    L6:
        this.c = r7;
        return;
    L5:
        r7 = new c(r6, r0, r1);
        goto L6
    }

    static q a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (f932b != null) goto L15;
        monitor-enter(q.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f932b != null) goto L9;
        f932b = new q((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(q.class);     // Catch: Throwable -> L11
    L15:
        return f932b;
    }

    private void a() {
        if (this.d == false) goto L5;
        return;
    L5:
        if (this.f933a.isEmpty() == true) goto L10;
        this.d = this.c.a();
        return;
    }

    private void b() {
        if (this.d == true) goto L5;
        return;
    L5:
        if (this.f933a.isEmpty() == false) goto L10;
        this.c.b();
        this.d = false;
        return;
    }

    synchronized void a(com.bumptech.glide.manager.b.a r3) {
        monitor-enter(this);
        com.bumptech.glide.manager.b.a r4 = (com.bumptech.glide.manager.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.manager.b.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        this.f933a.add(r4);     // Catch: Throwable -> L6
        a();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void b(com.bumptech.glide.manager.b.a r3) {
        monitor-enter(this);
        com.bumptech.glide.manager.b.a r4 = (com.bumptech.glide.manager.b.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.manager.b.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        this.f933a.remove(r4);     // Catch: Throwable -> L6
        b();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
