package com.bytedance.common.wschannel.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes.dex */
public class l implements k {
    private static boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Messenger f2093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ServiceConnection f2094b;
    private final Runnable d;
    private long e;
    private long f;
    private WeakReference<Context> g;
    private final LinkedBlockingDeque<k.a> h;

    class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l f2102a;

        a(l r1) {
            this.f2102a = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(final ComponentName r5, IBinder r6) {
            IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.class, "com.obric.memorydata.plugin");
            if (r5 == null) goto L19;
            if (r7 != null) goto L7;
            return;
        L7:
            if (Logger.debug() == false) goto L18;
            Logger.d("WsChannelSdk", "onServiceConnected name = " + r5.toString() + ", " + l.a());
        L18:
            this.f2102a.f2093a = new Messenger(r7);     // Catch: Throwable -> L14
            if (l.a() == false) goto L12;
            com.bytedance.common.utility.a.c.a(new AnonymousClass1(this, r5));     // Catch: Throwable -> L14
        L16:
            l.a(this.f2102a, SystemClock.uptimeMillis());
            l.a(this.f2102a, 0, SystemClock.uptimeMillis() - l.a(this.f2102a));
            return;
        L12:
            l.a(this.f2102a, r5);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            th.printStackTrace();
            goto L16
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r6) {
            if (r6 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L13;
            Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r6.toString());
        L13:
            this.f2102a.f2093a = null;     // Catch: Throwable -> L9
            l.c(this.f2102a).clear();     // Catch: Throwable -> L9
            l.b(this.f2102a, r6);     // Catch: Throwable -> L9
        L11:
            l.a(this.f2102a, 2, SystemClock.uptimeMillis() - l.d(this.f2102a));
            return;
        L9:
            th = move-exception;
            th.printStackTrace();
            goto L11
        }
    }

    static {
    }

    public l() {
        this.d = new AnonymousClass1(this);
        this.e = 0;
        this.f = 0;
        this.h = new LinkedBlockingDeque();
    }

    static /* synthetic */ long a(l r2) {
        return r2.e;
    }

    static /* synthetic */ long a(l r0, long r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ WeakReference a(l r0, WeakReference r1) {
        r0.g = r1;
        return r1;
    }

    private void a(int r1, long r2) {
        com.bytedance.common.wschannel.app.b r0 = WsConstants.getBindWsChannelServiceListener();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.a(r1, r2);
    }

    private synchronized void a(ComponentName r2) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f2093a != null) goto L6;
        b(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        c(r2);     // Catch: Throwable -> L9
        goto L7
    }

    private void a(ComponentName r2, Message r3) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelSdk", "sendMsg msg = " + r3.toString() + " , + what = " + r3.what);
    L7:
        Messenger r1 = this.f2093a;
        if (r1 != null) goto L10;
        return;
    L10:
        r1.send(r3);
    }

    private void a(Context r5, final int r6) {
        final Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L21;
        if (r6 > 0) goto L6;
        return;
    L6:
        if (r6 > 3) goto L23;
        WeakReference<Context> r0 = this.g;
        if (r0 != null) goto L11;
    L12:
        this.g = new WeakReference((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
    L14:
        if (Logger.debug() == false) goto L17;
        Logger.d("WsChannelSdk", "sendAppState appState = " + r6);
    L17:
        if (com.bytedance.common.wschannel.l.a(r7).c() == true) goto L19;
        return;
    L19:
        com.bytedance.common.utility.a.c.a(new AnonymousClass4(this, r7, r6));
        return;
    L11:
        if (r0.get() != null) goto L14;
    L23:
        return;
    }

    private void a(Context r3, final boolean r4) {
        final Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        com.bytedance.common.utility.a.c.a(new AnonymousClass3(this, r5, r4));
    }

    static /* synthetic */ void a(l r0, int r1, long r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void a(l r0, ComponentName r1) {
        r0.a(r1);
    }

    static /* synthetic */ boolean a() {
        return c;
    }

    static /* synthetic */ WeakReference b(l r0) {
        return r0.g;
    }

    private void b() {
        this.e = SystemClock.uptimeMillis();
        if (WsConstants.getBindWsChannelServiceListener() != null) goto L5;
        return;
    L5:
        com.bytedance.common.wschannel.h.a().b().postDelayed(this.d, 10000);
    }

    private void b(ComponentName r5) {
        WeakReference<Context> r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.get() == null) goto L24;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(r0.get(), Context.class, "com.obric.memorydata.plugin");
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "doBindService");
    L10:
        if (r5 != null) goto L19;
        return;
    L19:
        Intent r2 = new Intent();     // Catch: Throwable -> L18
        r2.setComponent(r5);     // Catch: Throwable -> L18
        ZeusTransformUtils.startService(r1, r2, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
    L21:
        Intent r3 = new Intent();     // Catch: Throwable -> L15
        r3.setComponent(r5);     // Catch: Throwable -> L15
        a r6 = new a(this);     // Catch: Throwable -> L15
        this.f2094b = r6;     // Catch: Throwable -> L15
        b();     // Catch: Throwable -> L15
        ZeusTransformUtils.bindService(r1, r3, r6, 1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    static /* synthetic */ void b(l r0, ComponentName r1) {
        r0.d(r1);
    }

    static /* synthetic */ LinkedBlockingDeque c(l r0) {
        return r0.h;
    }

    private void c(ComponentName r6) {
        if (r6 != null) goto L17;
        return;
    L17:
        if (this.h.peek() == null) goto L27;
        k.a r0 = (k.a) ZeusTransformUtils.preCheckCast(this.h.poll(), k.a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        if (r0 == null) goto L8;
        Message r1 = new Message();     // Catch: Throwable -> L16
        r1.what = r0.c;     // Catch: Throwable -> L16
        r1.getData().putParcelable(r0.f2091a, r0.f2092b);     // Catch: Throwable -> L16
        a(r6, r1);     // Catch: Throwable -> L12 DeadObjectException -> L14
    L14:
        this.f2093a = null;     // Catch: Throwable -> L16
        this.h.offerFirst(r0);     // Catch: Throwable -> L16
        a(3, SystemClock.uptimeMillis() - this.f);     // Catch: Throwable -> L16
        return;
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
        goto L17
    L8:
        return;
    L27:
        return;
    }

    static /* synthetic */ long d(l r2) {
        return r2.f;
    }

    private synchronized void d(ComponentName r1) {
        monitor-enter(this);
        monitor-exit(this);
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void a(Context r3) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), 1);
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void a(Context r3, boolean r4, boolean r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 == false) goto L5;
        a(r6, r5);
        return;
    L5:
        com.bytedance.common.utility.a.c.a(new AnonymousClass2(this, r6));
    }

    @Override // com.bytedance.common.wschannel.client.k
    public void b(Context r3) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), 2);
    }
}
