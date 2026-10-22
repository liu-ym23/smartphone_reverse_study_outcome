package mn;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.core.LynxEngineProxy;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f20118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f20119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxEngineProxy f20120c;

    public b(LynxEngineProxy r5, boolean r10, long r11) {
        this.f20120c = r5;
        this.f20118a = r10;
        this.f20119b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LynxEngineProxy r5 = this.f20120c;
        long r10 = r5.f10828a;
        if (r10 != 0) goto L6;
        LynxLog.b(4, "LynxEngineProxy", "startEventFire failed since mNativePtr is null");
        return;
    L6:
        LynxEngineProxy.k(r5, r10, this.f20118a, this.f20119b);
    }
}
