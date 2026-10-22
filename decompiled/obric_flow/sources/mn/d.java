package mn;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.core.LynxEngineProxy;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f20124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f20126c;
    public final /* synthetic */ ByteBuffer d;
    public final /* synthetic */ int e;
    public final /* synthetic */ LynxEngineProxy f;

    public d(LynxEngineProxy r5, String r10, int r11, int r12, ByteBuffer r13, int r14) {
        this.f = r5;
        this.f20124a = r10;
        this.f20125b = r11;
        this.f20126c = r12;
        this.d = r13;
        this.e = r14;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LynxEngineProxy r5 = this.f;
        long r10 = r5.f10828a;
        if (r10 != 0) goto L6;
        LynxLog.b(4, "LynxEngineProxy", "sendGestureEvent failed since mNativePtr is null");
        return;
    L6:
        ByteBuffer r11 = this.d;
        int r12 = this.e;
        LynxEngineProxy.g(r5, r10, this.f20124a, this.f20125b, this.f20126c, r11, r12);
    }
}
