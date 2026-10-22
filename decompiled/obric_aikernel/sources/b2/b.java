package b2;

import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.heartbeat.model.AppState;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AppState f511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private y1.b f513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterfaceC0024b f514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f515e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f516f;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f517c;

        a(b r10) {
            this.f517c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.a(this.f517c).getAndSet(false) == false) goto L8;
            Logger.d("WsChannelSdk_ok", "Compensate for ping timeout, prepare to reconnect");
            if (b.b(this.f517c) == null) goto L9;
            b.b(this.f517c).onTimeout();
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: b2.b$b, reason: collision with other inner class name */
    public interface InterfaceC0024b {
        void onTimeout();
    }

    public b(InterfaceC0024b r10, Handler r11) {
        this.f512b = new AtomicBoolean(false);
        this.f516f = new a(this);
        this.f514d = r10;
        this.f515e = r11;
    }

    static /* synthetic */ AtomicBoolean a(b r10) {
        return r10.f512b;
    }

    static /* synthetic */ InterfaceC0024b b(b r10) {
        return r10.f514d;
    }

    private boolean c(AppState r10) {
        if (this.f511a == AppState.STATE_BACKGROUND) goto L5;
    L7:
        return false;
    L5:
        if (r10 != AppState.STATE_FOREGROUND) goto L7;
        return true;
    }

    private void f() {
        this.f512b.set(true);
        this.f515e.removeCallbacks(this.f516f);
        this.f515e.postDelayed(this.f516f, 5000);
    }

    public void d(y1.b r10) {
        this.f513c = r10;
    }

    public void e(AppState r10) {
        if (this.f512b.get() == true) goto L14;
        boolean r11 = false;
        if (c(r10) == false) goto L7;
        Logger.d("WsChannelSdk_ok", "Switch the foreground in the background, send compensation ping");
        r11 = true;
    L7:
        if (r11 == false) goto L14;
        y1.b r12 = this.f513c;     // Catch: Exception -> L12
        if (r12 == null) goto L14;
        r12.b();     // Catch: Exception -> L12
        f();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        this.f511a = r10;
    }
}
