package f6;

import android.os.Handler;
import b6.d;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import jf.g;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g6.a f7330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f7331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f7332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0072b f7333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f7334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f7335f;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f7336a;

        public a(b r8) {
            this.f7336a = r8;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b r8 = this.f7336a;
            if (r8.f7331b.getAndSet(false) == false) goto L8;
            Logger.d("WsChannelSdk_ok", "补偿ping发生了超时，准备重连");
            InterfaceC0072b r10 = r8.f7333d;
            if (r10 == null) goto L9;
            z5.b.n(((z5.b.C0203b) r10).f14240a);
            return;
        L9:
            return;
        }
    }

    /* JADX INFO: renamed from: f6.b$b, reason: collision with other inner class name */
    public interface InterfaceC0072b {
    }

    public b(z5.b.C0203b r8, WeakHandler r10) {
        this.f7331b = new AtomicBoolean(false);
        this.f7335f = new a(this);
        this.f7333d = r8;
        this.f7334e = r10;
    }

    public final boolean a() {
        return this.f7331b.get();
    }

    public final void b() {
        Logger.d("WsChannelSdk_ok", "补偿ping之后接受到了pong");
        this.f7331b.set(false);
        a r8 = this.f7335f;
        this.f7334e.removeCallbacks(r8);
    }

    public final void c(g6.a r8) {
        AtomicBoolean r10 = this.f7331b;
        if (r10.get() == true) goto L19;
        boolean r11 = false;
        if (this.f7330a == g6.a.f7693b) goto L7;
    L9:
        boolean r12 = false;
    L10:
        if (r12 == false) goto L12;
        Logger.d("WsChannelSdk_ok", "后台切换前台，发送补偿ping");
        r11 = true;
    L12:
        if (r11 == false) goto L19;
        d r13 = this.f7332c;     // Catch: Exception -> L17
        if (r13 == null) goto L19;
        ((b6.c) r13).j(g.f8841o);     // Catch: Exception -> L17
        r10.set(true);     // Catch: Exception -> L17
        a r14 = this.f7335f;     // Catch: Exception -> L17
        Handler r15 = this.f7334e;     // Catch: Exception -> L17
        r15.removeCallbacks(r14);     // Catch: Exception -> L17
        r15.postDelayed(r14, 5000);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L7:
        if (r8 != g6.a.f7692a) goto L9;
        r12 = true;
    L19:
        this.f7330a = r8;
    }
}
