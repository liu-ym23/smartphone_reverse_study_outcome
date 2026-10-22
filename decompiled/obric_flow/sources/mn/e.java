package mn;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.core.LynxEngineProxy;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f20129c;
    public final /* synthetic */ LynxEngineProxy d;

    public e(LynxEngineProxy r5, int r10, int r11, int r12) {
        this.d = r5;
        this.f20127a = r10;
        this.f20128b = r11;
        this.f20129c = r12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LynxEngineProxy r5 = this.d;
        long r10 = r5.f10828a;
        if (r10 != 0) goto L6;
        LynxLog.b(4, "LynxEngineProxy", "OnPseudoStatusChanged failed since mNativePtr is null");
        return;
    L6:
        int r11 = this.f20128b;
        int r12 = this.f20129c;
        LynxEngineProxy.b(r5, r10, this.f20127a, r11, r12);
    }
}
