package l9;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bumptech.glide.load.engine.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f19589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f19590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u f19591c;

    public s(u r5) {
        this.f19591c = r5;
        super("default_npth_thread");
    }

    /* JADX INFO: Infinite loop detected, blocks: 19, insns: 0 */
    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        super.onLooperPrepared();
        Object r5 = this.f19591c.e;
        monitor-enter(r5);
        this.f19591c.d = new Handler();     // Catch: Throwable -> L18
        monitor-exit(r5);     // Catch: Throwable -> L18
        this.f19591c.d.post(new jm.a(this.f19591c, 1));
    L24:
        Looper.loop();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        h0 r10 = ((w8.b) w8.f.c(com.bytedance.crash.n.f4057a).f22816a).f22767a;     // Catch: Throwable -> L21
        if (this.f19589a >= 5) goto L14;
        com.bytedance.crash.c.f4025a.getClass();     // Catch: Throwable -> L21
        m.b.h("NPTH_CATCH", th);     // Catch: Throwable -> L21
    L16:
        this.f19589a++;     // Catch: Throwable -> L21
        goto L24
    L14:
        if (this.f19590b == true) goto L16;
        this.f19590b = true;     // Catch: Throwable -> L21
        m.b r11 = com.bytedance.crash.c.f4025a;     // Catch: Throwable -> L21
        RuntimeException r12 = new RuntimeException();     // Catch: Throwable -> L21
        r11.getClass();     // Catch: Throwable -> L21
        m.b.h("NPTH_ERR_MAX", r12);     // Catch: Throwable -> L21
    L18:
        th = move-exception;
        throw th;
    }
}
