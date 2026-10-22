package j6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.client.WsClientService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0100b f8703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<? extends c6.a> f8704b;

    public class a implements InterfaceC0100b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f8705a;

        public a(Context r8) {
            this.f8705a = r8;
        }

        @Override // j6.b.InterfaceC0100b
        public final void a(Intent r8) {
            this.f8705a.startService(r8);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // j6.b.InterfaceC0100b
        public final void b() {
        }
    }

    /* JADX INFO: renamed from: j6.b$b, reason: collision with other inner class name */
    public interface InterfaceC0100b {
        void a(Intent r8);

        void b();
    }

    public class c implements InterfaceC0100b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f8706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Messenger f8707b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final LinkedBlockingDeque<Intent> f8708c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ServiceConnection f8709d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8710e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Object f8711f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a f8712g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final RunnableC0101b f8713h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final AtomicInteger f8714i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ b f8715j;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f8716a;

            public a(c r8) {
                this.f8716a = r8;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Object r8 = this.f8716a.f8711f;
                monitor-enter(r8);
                Logger.d("WsChannelSdk", "mBindServiceTimeoutRunnable run");     // Catch: Throwable -> L9
                c r10 = this.f8716a;     // Catch: Throwable -> L9
                if (r10.f8710e == false) goto L7;
                r10.f8710e = false;     // Catch: Throwable -> L9
            L7:
                monitor-exit(r8);     // Catch: Throwable -> L9
                return;
            L9:
                th = move-exception;
                throw th;
            }
        }

        /* JADX INFO: renamed from: j6.b$c$b, reason: collision with other inner class name */
        public class RunnableC0101b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f8717a;

            public RunnableC0101b(c r8) {
                this.f8717a = r8;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Object r8 = this.f8717a.f8711f;
                monitor-enter(r8);
                c r10 = this.f8717a;     // Catch: Throwable -> L8
                ServiceConnection r11 = r10.f8709d;     // Catch: Throwable -> L8
                if (r11 == null) goto L10;
                r10.f8706a.unbindService(r11);     // Catch: Throwable -> L8
            L10:
                c r12 = this.f8717a;     // Catch: Throwable -> L13
                r12.f8709d = null;     // Catch: Throwable -> L13
                r12.f8707b = null;     // Catch: Throwable -> L13
                Logger.d("WsChannelSdk", "mDisconnectRunnable timeout");     // Catch: Throwable -> L13
                monitor-exit(r8);     // Catch: Throwable -> L13
                return;
            L8:
                th = move-exception;
                th.printStackTrace();     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                throw th;
            }
        }

        /* JADX INFO: renamed from: j6.b$c$c, reason: collision with other inner class name */
        public class ServiceConnectionC0102c implements ServiceConnection {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f8718a;

            public ServiceConnectionC0102c(c r8) {
                this.f8718a = r8;
            }

            @Override // android.content.ServiceConnection
            public final void onServiceConnected(ComponentName r8, IBinder r10) {
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceConnected name = " + r8.toString());
            L5:
                Object r11 = this.f8718a.f8711f;
                monitor-enter(r11);
                this.f8718a.e();     // Catch: Throwable -> L20
                if (r8 == null) goto L18;
                if (r10 == null) goto L18;
                this.f8718a.f8707b = new Messenger(r10);     // Catch: Throwable -> L13
                Logger.d("WsChannelSdk", "onServiceConnected set service");     // Catch: Throwable -> L13
                this.f8718a.d();     // Catch: Throwable -> L13
            L15:
                Logger.d("WsChannelSdk", "onServiceConnected, set Unbind = false");     // Catch: Throwable -> L20
                this.f8718a.f8710e = false;     // Catch: Throwable -> L20
                monitor-exit(r11);     // Catch: Throwable -> L20
                return;
            L13:
                th = move-exception;
                th.printStackTrace();     // Catch: Throwable -> L20
            L18:
                monitor-exit(r11);     // Catch: Throwable -> L20
                return;
            L20:
                th = move-exception;
                throw th;
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName r8) {
                if (Logger.debug() == false) goto L5;
                Logger.d("WsChannelSdk", "onServiceDisconnected name = " + r8.toString());
            L5:
                Object r10 = this.f8718a.f8711f;
                monitor-enter(r10);
                if (r8 != null) goto L22;
                monitor-exit(r10);     // Catch: Throwable -> L10
                return;
            L22:
                Logger.d("WsChannelSdk", "onServiceDisconnected set service = null");     // Catch: Throwable -> L14
                c r11 = this.f8718a;     // Catch: Throwable -> L14
                r11.f8707b = null;     // Catch: Throwable -> L14
                r11.f8706a.unbindService(this);     // Catch: Throwable -> L14
            L16:
                Logger.d("WsChannelSdk", "onServiceDisconnected, set Unbind = false");     // Catch: Throwable -> L10
                c r12 = this.f8718a;     // Catch: Throwable -> L10
                r12.f8710e = false;     // Catch: Throwable -> L10
                r12.f();     // Catch: Throwable -> L10
                this.f8718a.e();     // Catch: Throwable -> L10
                monitor-exit(r10);     // Catch: Throwable -> L10
                return;
            L14:
                th = move-exception;
                th.printStackTrace();     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                throw th;
            }
        }

        public c(b r8, Context r10) {
            this.f8715j = r8;
            this.f8708c = new LinkedBlockingDeque();
            this.f8710e = false;
            this.f8711f = new Object();
            this.f8712g = new a(this);
            this.f8713h = new RunnableC0101b(this);
            this.f8714i = new AtomicInteger(0);
            this.f8706a = r10;
        }

        @Override // j6.b.InterfaceC0100b
        public final void a(Intent r8) {
            if (Logger.debug() == false) goto L5;
            r8.putExtra(WsConstants.MSG_COUNT, this.f8714i.addAndGet(1));
        L5:
            Object r10 = this.f8711f;
            monitor-enter(r10);
            f();     // Catch: Throwable -> L17
            this.f8708c.offer(r8);     // Catch: Throwable -> L17
            if (this.f8707b == null) goto L10;
            d();     // Catch: Throwable -> L17
        L15:
            monitor-exit(r10);     // Catch: Throwable -> L17
            return;
        L10:
            if (this.f8710e == false) goto L13;
            monitor-exit(r10);     // Catch: Throwable -> L17
            return;
        L13:
            c();     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            throw th;
        }

        @Override // j6.b.InterfaceC0100b
        public final void b() {
            if (this.f8708c.size() > 0) goto L5;
            return;
        L5:
            if (this.f8707b != null) goto L21;
            Logger.d("WsChannelSdk", "tryResendMsg try reconnect");
            Object r8 = this.f8711f;
            monitor-enter(r8);
        L15:
            th = move-exception;
            throw th;
        L9:
            if (this.f8708c.size() > 0) goto L11;
        L13:
            monitor-exit(r8);     // Catch: Throwable -> L15
            return;
        L11:
            if (this.f8707b != null) goto L13;
            c();     // Catch: Throwable -> L15
            goto L13
        }

        public final void c() {
            Context r8 = this.f8706a;
            if (Logger.debug() == false) goto L10;
            Logger.d("WsChannelSdk", "doBindService");
        L10:
            this.f8709d = new ServiceConnectionC0102c(this);     // Catch: Throwable -> L7
            r8.bindService(new Intent(r8, this.f8715j.f8704b), this.f8709d, 1);     // Catch: Throwable -> L7
            e();     // Catch: Throwable -> L7
            sd.b.a().f12111a.postDelayed(this.f8712g, TimeUnit.SECONDS.toMillis(7));     // Catch: Throwable -> L7
            this.f8710e = true;     // Catch: Throwable -> L7
            Logger.d("WsChannelSdk", "doBindService, set mBinding = true");     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            e();
            this.f8710e = false;
            Logger.d("WsChannelSdk", "doBindService error, set Unbind = false");
            th.printStackTrace();
        }

        public final void d() {
        L24:
        L19:
            th = move-exception;
            th.printStackTrace();
            return;
        L3:
            if (this.f8708c.peek() == null) goto L12;
            Intent r8 = this.f8708c.poll();     // Catch: Throwable -> L19
            if (r8 == null) goto L6;
            g(r8);     // Catch: Throwable -> L9 DeadObjectException -> L11
        L11:
            Logger.d("WsChannelSdk", "onServiceConnected DeadObjectException");     // Catch: Throwable -> L19
            this.f8707b = null;     // Catch: Throwable -> L19
            this.f8708c.offerFirst(r8);     // Catch: Throwable -> L19
        L9:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L19
            goto L24
        L6:
            return;
        L12:
            monitor-enter(this);     // Catch: Throwable -> L19
            f();     // Catch: Throwable -> L16
            sd.b.a().f12111a.postDelayed(this.f8713h, TimeUnit.SECONDS.toMillis(10));     // Catch: Throwable -> L16
            monitor-exit(this);     // Catch: Throwable -> L19
            return;
        L16:
            th = move-exception;
            throw th;     // Catch: Throwable -> L19
        }

        public final void e() {
            sd.b.a().f12111a.removeCallbacks(this.f8712g);
        }

        public final void f() {
            sd.b.a().f12111a.removeCallbacks(this.f8713h);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            e.printStackTrace();
        }

        public final void g(Intent r8) {
            if (Logger.debug() == false) goto L5;
            Logger.d("WsChannelSdk", "sendMsg msg = " + r8);
        L5:
            Messenger r10 = this.f8707b;
            Message r11 = new Message();
            r11.what = WsConstants.MSG_INTENT;
            r11.getData().putParcelable(WsConstants.DATA_INTENT, r8);
            if (r10 != null) goto L8;
            return;
        L8:
            r10.send(r11);
        }
    }

    public b(Context r8) {
        if (r8.getApplicationInfo().targetSdkVersion < 26) goto L5;
        InterfaceC0100b r10 = new c(this, r8);
    L6:
        this.f8703a = r10;
        this.f8704b = WsClientService.class;
        return;
    L5:
        r10 = new a(r8);
        goto L6
    }
}
