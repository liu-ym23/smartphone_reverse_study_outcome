package h3;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.bytedance.ai.utils.g;
import d3.z;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements f {
    public static final e a = null;
    public static final List<TargetEntity.Scope> b = null;

    public e() {
    }

    static {
        a = new e();
        b = CollectionsKt.listOf(TargetEntity.Scope.Main);
    }

    @Override // h3.f
    public final boolean a(ProtocolMessage r10) {
        Intrinsics.checkNotNullParameter(r10, "protocolMessage");
        List<TargetEntity.Scope> r0 = b;
        TargetEntity r11 = r10.g();
        if (r11 == null) goto L5;
        TargetEntity.Scope r12 = r11.b();
    L7:
        return CollectionsKt.contains(r0, r12);
    L5:
        r12 = null;
        goto L7
    }

    @Override // h3.f
    public final void b(e3.a r10, ProtocolMessage r11, final d3.b r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "protocolMessage");
        Intrinsics.checkNotNullParameter(r12, "resultCallback");
        TargetEntity r13 = r11.g();
        if (r13 != null) goto L7;
        r12.invoke(null);
        return;
    L7:
        if (r13.b() == TargetEntity.Scope.Main) goto L9;
    L16:
        r12.invoke(null);
        return;
    L9:
        if (r13.c() != TargetEntity.Target.Self) goto L16;
        z r14 = (z) r10.d(z.class);
        if (r14 != null) goto L14;
        g.a.e("AIBridgeWorkerHandler", "appletRuntimeProvider is null");
        r12.invoke(null);
        return;
    L14:
        r14.a(new d(r12));
    }
}
