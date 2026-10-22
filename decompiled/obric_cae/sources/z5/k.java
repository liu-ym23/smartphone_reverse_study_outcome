package z5;

import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.e f14270a;

    public k(b.e r8) {
        this.f14270a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Logger.d("WsChannelSdk_ok", "----------onClosing--------");
        this.f14270a.f14247c.t(6);
    }
}
