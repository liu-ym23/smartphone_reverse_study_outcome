package o5;

import com.bytedance.bdlocation.client.BDLocationConfig;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import com.ttnet.org.chromium.base.library_loader.LibraryPrefetcher;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9717a;

    public /* synthetic */ r(int r8) {
        this.f9717a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f9717a) {
            case 0: goto L23;
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L5;
            default: goto L25;
        };
    L5:
        com.obric.matrix.platform.sdk.ones.internal.tunnel.c.f6150b = false;
        monitor-enter(com.obric.matrix.platform.sdk.ones.internal.tunnel.c.f6149a);
        he.i.f("start connect binder isbinding " + com.obric.matrix.platform.sdk.ones.internal.tunnel.c.f6150b, "msg");     // Catch: Throwable -> L14
        monitor-enter(ob.a.f9769a);     // Catch: Throwable -> L14
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L10:
        throw new RuntimeException("please call init first ");     // Catch: Throwable -> L11
    L14:
        th = move-exception;
        throw th;
    L17:
        MatrixDidUtils.b();
        return;
    L19:
        WifiScanStateMachine.a();
        return;
    L21:
        BDLocationConfig.setRequestLocation(true);
        return;
    L23:
        BDLocationConfig.setRequestLocation(true);
        return;
    L25:
        LibraryPrefetcher.b();
    }
}
