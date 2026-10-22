package o5;

import com.bytedance.bdlocation.LocationUtil;
import com.obric.cae.cldReport.secretCode.CaeSecretCodeReceiver;
import com.obric.cae.userAware.utils.MatrixDidUtils;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9715a;

    public /* synthetic */ p(int r8) {
        this.f9715a = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f9715a) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L11;
        };
    L5:
        MatrixDidUtils.a();
        return;
    L7:
        CaeSecretCodeReceiver.a();
        return;
    L9:
        LocationUtil.uploadDeviceStatus("scenes_status_changed", 1);
        return;
    L11:
        com.obric.matrix.platform.sdk.ones.internal.tunnel.c r8 = com.obric.matrix.platform.sdk.ones.internal.tunnel.c.f6149a;
        com.obric.matrix.platform.sdk.ones.internal.tunnel.c r10 = com.obric.matrix.platform.sdk.ones.internal.tunnel.c.f6149a;
        monitor-enter(ob.a.f9769a);
    L15:
        th = move-exception;
        throw th;
    L14:
        throw new RuntimeException("please call init first ");     // Catch: Throwable -> L15
    }
}
