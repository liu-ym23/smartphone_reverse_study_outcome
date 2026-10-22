package z5;

import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f14259a;

    public f(b r8) {
        this.f14259a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r8 = this.f14259a;
        if (b.a(r8) == null) goto L6;
        Logger.d("WsChannelSdk_ok", "发送ping");     // Catch: Throwable -> L8
        b.a(r8).j(jf.g.f8841o);     // Catch: Throwable -> L8
    L6:
        ((h6.b) b.c(r8)).d();
    }
}
