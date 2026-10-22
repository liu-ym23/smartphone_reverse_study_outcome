package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f2163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<? extends com.bytedance.common.wschannel.client.a> f2164b;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.c$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f2165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f2166b;

        a(c r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.f2165a = r3;
            this.f2166b = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        }

        @Override // com.bytedance.common.wschannel.server.c.b
        public void a() {
        }

        @Override // com.bytedance.common.wschannel.server.c.b
        public void a(Intent r4) {
            r4.setComponent(new ComponentName(this.f2166b, c.a(this.f2165a)));     // Catch: Throwable -> L4
            ZeusTransformUtils.startService(this.f2166b, r4, "com.obric.memorydata.plugin");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    public interface b {
        void a();

        void a(Intent r1);
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.c$c, reason: collision with other inner class name */
    private class C0117c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicInteger f2167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f2168b;
        private final Context c;
        private Messenger d;
        private final LinkedBlockingDeque<Intent> e;
        private ServiceConnection f;
        private boolean g;
        private final Object h;
        private final Runnable i;
        private final Runnable j;

        /* JADX INFO: renamed from: com.bytedance.common.wschannel.server.c$c$a */
        private class a implements ServiceConnection {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ C0117c f2171a;

            private a(C0117c r1) {
                this.f2171a = r1;
            }

            /* synthetic */ a(C0117c r1, AnonymousClass1 r2) {
                this(r1);
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName r4, IBinder r5) {
                IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.memorydata.plugin");
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceConnected name = " + r4.toString());
            L5:
                Object r0 = C0117c.a(this.f2171a);
                monitor-enter(r0);
                C0117c.f(this.f2171a);     // Catch: Throwable -> L20
                if (r4 == null) goto L18;
                if (r6 == null) goto L18;
                C0117c.a(this.f2171a, new Messenger(r6));     // Catch: Throwable -> L13
                Logger.d("WsChannelSdk", "onServiceConnected set service");     // Catch: Throwable -> L13
                C0117c.g(this.f2171a);     // Catch: Throwable -> L13
            L15:
                Logger.d("WsChannelSdk", "onServiceConnected, set Unbind = false");     // Catch: Throwable -> L20
                C0117c.a(this.f2171a, false);     // Catch: Throwable -> L20
                monitor-exit(r0);     // Catch: Throwable -> L20
                return;
            L13:
                th = move-exception;
                th.printStackTrace();     // Catch: Throwable -> L20
            L18:
                monitor-exit(r0);     // Catch: Throwable -> L20
                return;
            L20:
                th = move-exception;
                throw th;
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName r4) {
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r4.toString());
            L5:
                Object r0 = C0117c.a(this.f2171a);
                monitor-enter(r0);
                if (r4 != null) goto L10;
                monitor-exit(r0);     // Catch: Throwable -> L13
                return;
            L10:
                Logger.d("WsChannelSdk", "onServiceDisconnected set service = null");     // Catch: Throwable -> L13
                C0117c.a(this.f2171a, null);     // Catch: Throwable -> L13
                C0117c.a(this.f2171a, null);     // Catch: Throwable -> L13
                Logger.d("WsChannelSdk", "onServiceDisconnected, set Unbind = false");     // Catch: Throwable -> L13
                C0117c.a(this.f2171a, false);     // Catch: Throwable -> L13
                C0117c.e(this.f2171a);     // Catch: Throwable -> L13
                C0117c.f(this.f2171a);     // Catch: Throwable -> L13
                monitor-exit(r0);     // Catch: Throwable -> L13
                return;
            L13:
                th = move-exception;
                throw th;
            }
        }

        C0117c(c r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
            this.f2168b = r3;
            this.e = new LinkedBlockingDeque();
            this.g = false;
            this.h = new Object();
            this.i = new AnonymousClass1(this);
            this.j = new AnonymousClass2(this);
            this.f2167a = new AtomicInteger(0);
            this.c = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        }

        static /* synthetic */ ServiceConnection a(C0117c r2, ServiceConnection r3) {
            ServiceConnection r4 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.memorydata.plugin");
            r2.f = r4;
            return r4;
        }

        static /* synthetic */ Messenger a(C0117c r0, Messenger r1) {
            r0.d = r1;
            return r1;
        }

        static /* synthetic */ Object a(C0117c r0) {
            return r0.h;
        }

        static /* synthetic */ boolean a(C0117c r0, boolean r1) {
            r0.g = r1;
            return r1;
        }

        private void b() {
        L17:
        L14:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (this.e.peek() == null) goto L12;
            Intent r0 = (Intent) ZeusTransformUtils.preCheckCast(this.e.poll(), Intent.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            if (r0 == null) goto L6;
            b(r0);     // Catch: Throwable -> L9 DeadObjectException -> L11
        L11:
            Logger.d("WsChannelSdk", "onServiceConnected DeadObjectException");     // Catch: Throwable -> L14
            this.d = null;     // Catch: Throwable -> L14
            this.e.offerFirst(r0);     // Catch: Throwable -> L14
        L9:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L14
            goto L17
        L6:
            return;
        L12:
            f();     // Catch: Throwable -> L14
        }

        private void b(Intent r4) {
            if (r4 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L7;
            Logger.d("WsChannelSdk", "sendMsg msg = " + r4);
        L7:
            Messenger r3 = this.d;
            Message r0 = new Message();
            r0.what = WsConstants.MSG_INTENT;
            r0.getData().putParcelable(WsConstants.DATA_INTENT, r4);
            if (r3 != null) goto L10;
            return;
        L10:
            r3.send(r0);
        }

        static /* synthetic */ boolean b(C0117c r0) {
            return r0.g;
        }

        static /* synthetic */ ServiceConnection c(C0117c r0) {
            return r0.f;
        }

        private void c() {
            if (Logger.debug() == false) goto L12;
            Logger.d("WsChannelSdk", "doBindService");
        L12:
            ZeusTransformUtils.startService(this.c, new Intent(this.c, c.a(this.f2168b)), "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        L14:
            this.f = new a(this, null);     // Catch: Throwable -> L8
            ZeusTransformUtils.bindService(this.c, new Intent(this.c, c.a(this.f2168b)), this.f, 1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
            d();     // Catch: Throwable -> L8
            this.g = true;     // Catch: Throwable -> L8
            Logger.d("WsChannelSdk", "doBindService, set mBinding = true");     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            e();
            this.g = false;
            Logger.d("WsChannelSdk", "doBindService error, set Unbind = false");
            th.printStackTrace();
        }

        static /* synthetic */ Context d(C0117c r0) {
            return r0.c;
        }

        private void d() {
            e();
            com.bytedance.common.wschannel.h.a().b().postDelayed(this.i, TimeUnit.SECONDS.toMillis(7));
        }

        private void e() {
            com.bytedance.common.wschannel.h.a().b().removeCallbacks(this.i);
        }

        static /* synthetic */ void e(C0117c r0) {
            r0.g();
        }

        private synchronized void f() {
            monitor-enter(this);
            g();     // Catch: Throwable -> L6
            com.bytedance.common.wschannel.h.a().b().postDelayed(this.j, TimeUnit.SECONDS.toMillis(10));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        static /* synthetic */ void f(C0117c r0) {
            r0.e();
        }

        private void g() {
            com.bytedance.common.wschannel.h.a().b().removeCallbacks(this.j);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        static /* synthetic */ void g(C0117c r0) {
            r0.b();
        }

        @Override // com.bytedance.common.wschannel.server.c.b
        public void a() {
            if (this.e.size() > 0) goto L5;
            return;
        L5:
            if (this.d != null) goto L21;
            Logger.d("WsChannelSdk", "tryResendMsg try reconnect");
            Object r0 = this.h;
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L9:
            if (this.e.size() > 0) goto L11;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L11:
            if (this.d != null) goto L13;
            c();     // Catch: Throwable -> L15
            goto L13
        }

        @Override // com.bytedance.common.wschannel.server.c.b
        public void a(Intent r4) {
            if (r4 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L7;
            r4.putExtra(WsConstants.MSG_COUNT, this.f2167a.addAndGet(1));
        L7:
            Object r0 = this.h;
            monitor-enter(r0);
            g();     // Catch: Throwable -> L19
            this.e.offer(r4);     // Catch: Throwable -> L19
            if (this.d == null) goto L12;
            b();     // Catch: Throwable -> L19
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L12:
            if (this.g == false) goto L15;
            monitor-exit(r0);     // Catch: Throwable -> L19
            return;
        L15:
            c();     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        }
    }

    public c(Context r3, Class<? extends com.bytedance.common.wschannel.client.a> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (Build.VERSION.SDK_INT >= 26) goto L5;
    L7:
        b r0 = new a(this, r5);
    L8:
        this.f2163a = r0;
        this.f2164b = r4;
        return;
    L5:
        if (r5.getApplicationInfo().targetSdkVersion < 26) goto L7;
        r0 = new C0117c(this, r5);
        goto L8
    }

    static /* synthetic */ Class a(c r0) {
        return r0.f2164b;
    }

    public void a() {
        this.f2163a.a();
    }

    public void a(Intent r1) {
        this.f2163a.a(r1);
    }
}
