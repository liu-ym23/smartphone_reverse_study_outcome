package mn;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.core.LynxEngineProxy;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f20116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxEngineProxy f20117c;

    public /* synthetic */ a(LynxEngineProxy r5, long r10, int r11) {
        this.f20115a = r11;
        this.f20117c = r5;
        this.f20116b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f20115a) {
            case 0: goto L9;
            default: goto L4;
        };
    L4:
        LynxEngineProxy r5 = this.f20117c;
        long r10 = r5.f10828a;
        if (r10 != 0) goto L7;
        LynxLog.b(4, "LynxEngineProxy", "startEventBubble failed since mNativePtr is null");
        return;
    L7:
        LynxEngineProxy.l(r5, r10, this.f20116b);
        return;
    L9:
        LynxEngineProxy r11 = this.f20117c;
        long r12 = r11.f10828a;
        if (r12 != 0) goto L12;
        LynxLog.b(4, "LynxEngineProxy", "startEventCapture failed since mNativePtr is null");
        return;
    L12:
        LynxEngineProxy.d(r11, r12, this.f20116b);
    }
}
