package e2;

import android.os.Handler;
import b2.c;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class b extends b2.a<e2.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f8557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f8558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f8559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f8560e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f8561f;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f8562c;

        a(b r10) {
            this.f8562c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.e(this.f8562c).getAndSet(false) == false) goto L8;
            b.f(this.f8562c);
            if (b.g(this.f8562c) == null) goto L9;
            Logger.d("WsChannelSdk_ok", "heartbeat timeout，ready to close connection");
            b.g(this.f8562c).a();
            d2.a.c().a();
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: e2.b$b, reason: collision with other inner class name */
    class RunnableC0160b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f8563c;

        RunnableC0160b(b r10) {
            this.f8563c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.g(this.f8563c) == null) goto L6;
            b.h(this.f8563c);
            b.g(this.f8563c).b();
            return;
        }
    }

    public b(e2.a r10) {
        super(r10);
        this.f8559d = new AtomicBoolean(false);
        this.f8560e = new a(this);
        this.f8561f = new RunnableC0160b(this);
    }

    static /* synthetic */ AtomicBoolean e(b r10) {
        return r10.f8559d;
    }

    static /* synthetic */ void f(b r10) {
        r10.i();
    }

    static /* synthetic */ c g(b r10) {
        return r10.f8557b;
    }

    static /* synthetic */ void h(b r10) {
        r10.j();
    }

    private void i() {
        this.f8558c.removeCallbacks(this.f8560e);
        this.f8558c.removeCallbacks(this.f8561f);
        this.f8559d.set(false);
    }

    private void j() {
        long r10 = ((e2.a) this.f510a).a();
        Logger.d("WsChannelSdk_ok", "interval :" + r10 + " ms,the next time to send heartbeat is " + g2.c.h(System.currentTimeMillis() + r10));
        this.f8558c.removeCallbacks(this.f8561f);
        this.f8558c.postDelayed(this.f8561f, r10);
    }

    private void k() {
        this.f8559d.set(true);
        this.f8558c.removeCallbacks(this.f8560e);
        this.f8558c.postDelayed(this.f8560e, ((e2.a) this.f510a).b());
    }

    @Override // b2.d
    public void a(AppState r10) {
    }

    @Override // b2.d
    public void b() {
        Logger.d("WsChannelSdk_ok", "ping sent，waiting for pong");
        k();
    }

    @Override // b2.d
    public void c() {
        Logger.d("WsChannelSdk_ok", "disconnected，stop to send ping");
        i();
    }

    @Override // b2.a
    public void d(c r10, Handler r11) {
        this.f8557b = r10;
        this.f8558c = r11;
    }
}
