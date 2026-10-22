package z1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import androidx.work.WorkRequest;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.server.WsChannelService;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingDeque;

/* JADX INFO: loaded from: classes.dex */
public class l implements k {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f13757g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Runnable f13758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f13759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f13760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private WeakReference<Context> f13761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Messenger f13762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinkedBlockingDeque<k.a> f13763f;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f13764c;

        a(l r10) {
            this.f13764c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            l r10 = this.f13764c;
            if (r10.f13762e != null) goto L6;
            l.e(r10, 1, SystemClock.uptimeMillis() - l.d(this.f13764c));
            return;
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f13765c;

        b(l r10, Context r11) {
            this.f13765c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13765c.startService(new Intent(this.f13765c, WsChannelService.class));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f13766c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f13767g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ l f13768h;

        c(l r10, Context r11, boolean r12) {
            this.f13768h = r10;
            this.f13766c = r11;
            this.f13767g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f13766c != null) goto L6;
            return;
        L6:
            if (l.f(this.f13768h) != null) goto L8;
        L9:
            l.g(this.f13768h, new WeakReference(this.f13766c.getApplicationContext()));
        L19:
            ComponentName r10 = new ComponentName(this.f13766c, WsChannelService.class);     // Catch: Throwable -> L16
            k.a r11 = new k.a();     // Catch: Throwable -> L16
            if (this.f13767g == false) goto L13;
            int r12 = 9;
        L14:
            r11.f13756c = r12;     // Catch: Throwable -> L16
            l.h(this.f13768h).offer(r11);     // Catch: Throwable -> L16
            l.i(this.f13768h, r10);     // Catch: Throwable -> L16
            return;
        L13:
            r12 = 11;
        L16:
            th = move-exception;
            th.printStackTrace();
            return;
        L8:
            if (l.f(this.f13768h).get() != null) goto L19;
            goto L9
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f13769c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f13770g;

        d(l r10, Context r11, int r12) {
            this.f13769c = r11;
            this.f13770g = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            ComponentName r10 = new ComponentName(this.f13769c, WsChannelService.class);     // Catch: Throwable -> L4
            Intent r11 = new Intent(WsConstants.APP_STATE_ACTION);     // Catch: Throwable -> L4
            r11.setComponent(r10);     // Catch: Throwable -> L4
            r11.putExtra(WsConstants.KEY_APP_STATE, this.f13770g);     // Catch: Throwable -> L4
            this.f13769c.startService(r11);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    class e implements ServiceConnection {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ l f13771c;

        class a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ComponentName f13772c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ e f13773g;

            a(e r10, ComponentName r11) {
                this.f13773g = r10;
                this.f13772c = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                l.i(this.f13773g.f13771c, this.f13772c);
            }
        }

        e(l r10) {
            this.f13771c = r10;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            if (r10 == null) goto L18;
            if (r11 != null) goto L6;
            return;
        L6:
            if (Logger.debug() == false) goto L17;
            Logger.d("WsChannelSdk", "onServiceConnected name = " + r10.toString() + ", " + l.m());
        L17:
            this.f13771c.f13762e = new Messenger(r11);     // Catch: Throwable -> L13
            if (l.m() == false) goto L11;
            r1.c.b(new a(this, r10));     // Catch: Throwable -> L13
        L15:
            l.l(this.f13771c, SystemClock.uptimeMillis());
            l.e(this.f13771c, 0, SystemClock.uptimeMillis() - l.d(this.f13771c));
            return;
        L11:
            l.i(this.f13771c, r10);     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            th.printStackTrace();
            goto L15
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (Logger.debug() == false) goto L13;
            Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r10.toString());
        L13:
            l r11 = this.f13771c;     // Catch: Throwable -> L9
            r11.f13762e = null;     // Catch: Throwable -> L9
            l.h(r11).clear();     // Catch: Throwable -> L9
            l.j(this.f13771c, r10);     // Catch: Throwable -> L9
        L11:
            l.e(this.f13771c, 2, SystemClock.uptimeMillis() - l.k(this.f13771c));
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
        this.f13758a = new a(this);
        this.f13759b = 0;
        this.f13760c = 0;
        this.f13763f = new LinkedBlockingDeque();
    }

    static /* synthetic */ long d(l r10) {
        return r10.f13759b;
    }

    static /* synthetic */ void e(l r10, int r11, long r12) {
        r10.p(r11, r12);
    }

    static /* synthetic */ WeakReference f(l r10) {
        return r10.f13761d;
    }

    static /* synthetic */ WeakReference g(l r10, WeakReference r11) {
        r10.f13761d = r11;
        return r11;
    }

    static /* synthetic */ LinkedBlockingDeque h(l r10) {
        return r10.f13763f;
    }

    static /* synthetic */ void i(l r10, ComponentName r11) {
        r10.n(r11);
    }

    static /* synthetic */ void j(l r10, ComponentName r11) {
        r10.r(r11);
    }

    static /* synthetic */ long k(l r10) {
        return r10.f13760c;
    }

    static /* synthetic */ long l(l r10, long r11) {
        r10.f13760c = r11;
        return r11;
    }

    static /* synthetic */ boolean m() {
        return f13757g;
    }

    private synchronized void n(ComponentName r10) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f13762e != null) goto L6;
        o(r10);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        q(r10);     // Catch: Throwable -> L9
        goto L7
    }

    private void o(ComponentName r10) {
        WeakReference<Context> r11 = this.f13761d;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.get() == null) goto L24;
        Context r12 = r11.get();
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "doBindService");
    L10:
        if (r10 != null) goto L21;
        return;
    L21:
        Intent r13 = new Intent();     // Catch: Throwable -> L18
        r13.setComponent(r10);     // Catch: Throwable -> L18
        r12.startService(r13);     // Catch: Throwable -> L18
    L19:
        Intent r14 = new Intent();     // Catch: Throwable -> L15
        r14.setComponent(r10);     // Catch: Throwable -> L15
        e r15 = new e(this);     // Catch: Throwable -> L15
        u();     // Catch: Throwable -> L15
        r12.bindService(r14, r15, 1);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    private void p(int r10, long r11) {
        u1.b r12 = WsConstants.getBindWsChannelServiceListener();
        if (r12 != null) goto L5;
        return;
    L5:
        r12.a(r10, r11);
    }

    private void q(ComponentName r10) {
        if (r10 != null) goto L17;
        return;
    L17:
        if (this.f13763f.peek() == null) goto L27;
        k.a r11 = this.f13763f.poll();     // Catch: Throwable -> L16
        if (r11 == null) goto L8;
        Message r12 = new Message();     // Catch: Throwable -> L16
        r12.what = r11.f13756c;     // Catch: Throwable -> L16
        r12.getData().putParcelable(r11.f13754a, r11.f13755b);     // Catch: Throwable -> L16
        t(r10, r12);     // Catch: Throwable -> L12 DeadObjectException -> L14
    L14:
        this.f13762e = null;     // Catch: Throwable -> L16
        this.f13763f.offerFirst(r11);     // Catch: Throwable -> L16
        p(3, SystemClock.uptimeMillis() - this.f13760c);     // Catch: Throwable -> L16
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

    private synchronized void r(ComponentName r10) {
        monitor-enter(this);
        monitor-exit(this);
    }

    private void s(Context r10, int r11) {
        if (r10 == null) goto L20;
        if (r11 > 0) goto L5;
        return;
    L5:
        if (r11 > 3) goto L22;
        WeakReference<Context> r12 = this.f13761d;
        if (r12 != null) goto L10;
    L11:
        this.f13761d = new WeakReference(r10.getApplicationContext());
    L13:
        if (Logger.debug() == false) goto L16;
        Logger.d("WsChannelSdk", "sendAppState appState = " + r11);
    L16:
        if (com.bytedance.common.wschannel.l.f(r10).g() == true) goto L18;
        return;
    L18:
        r1.c.b(new d(this, r10, r11));
        return;
    L10:
        if (r12.get() != null) goto L13;
    L22:
        return;
    }

    private void t(ComponentName r10, Message r11) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.d("WsChannelSdk", "sendMsg msg = " + r11.toString() + " , + what = " + r11.what);
    L7:
        Messenger r12 = this.f13762e;
        if (r12 != null) goto L10;
        return;
    L10:
        r12.send(r11);
    }

    private void u() {
        this.f13759b = SystemClock.uptimeMillis();
        if (WsConstants.getBindWsChannelServiceListener() != null) goto L5;
        return;
    L5:
        com.bytedance.common.wschannel.g.b().a().postDelayed(this.f13758a, WorkRequest.MIN_BACKOFF_MILLIS);
    }

    private void v(Context r10, boolean r11) {
        r1.c.b(new c(this, r10, r11));
    }

    @Override // z1.k
    public void a(Context r10, boolean r11, boolean r12) {
        if (r11 == false) goto L4;
        v(r10, r12);
        return;
    L4:
        r1.c.b(new b(this, r10));
    }

    @Override // z1.k
    public void b(Context r10) {
        s(r10, 2);
    }

    @Override // z1.k
    public void c(Context r10) {
        s(r10, 1);
    }
}
