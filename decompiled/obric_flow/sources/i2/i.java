package i2;

import com.bytedance.ai.bridge.protocol.RelaxWorkerAIBridgePort$RTSInterface;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.relax.BackendWorker;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference f17498c;
    public final l2.a d;

    public i(WeakReference r5, l2.a r10) {
        Intrinsics.checkNotNullParameter(r5, "relaxRuntimeReference");
        Intrinsics.checkNotNullParameter(r10, "remoteMessageCache");
        this.f17498c = r5;
        this.d = r10;
    }

    public static final void e(BackendWorker r5, j2.a r10) {
        ProtocolMessage r11 = (ProtocolMessage) r10.f22372b;
        Intrinsics.checkNotNullParameter(r11, "value");
        r5.callRTSFunction("onMessage", z0.a.a().toJson(r11));
    }

    @Override // i2.c
    public final void a() {
        super.a();
        this.d.a();
        BackendWorker r5 = (BackendWorker) this.f17498c.get();
        if (r5 == null) goto L6;
        RelaxWorkerAIBridgePort$RTSInterface.release(r5);
        return;
    }

    @Override // i2.c
    public final void b(a r5) {
        Intrinsics.checkNotNullParameter(r5, "consumer");
        b r10 = new b(r5, 1);
        this.d.b(r10);
    }

    @Override // i2.c
    public final void d(final j2.a r5) {
        Intrinsics.checkNotNullParameter(r5, "messageWrapper");
        final BackendWorker r10 = (BackendWorker) this.f17498c.get();
        if (r10 == null) goto L6;
        r10.executeOnWorker(new g(r10, r5));
        return;
    }
}
