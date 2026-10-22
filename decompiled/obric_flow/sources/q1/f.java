package q1;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.bytedance.ai.model.s;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f21468a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f21469b = null;

    static {
        f21468a = new f();
        f21469b = CollectionsKt.listOf(TargetEntity.Scope.f2035c);
    }

    @Override // q1.g
    public final void a(n1.c r5, ProtocolMessage r10, com.bytedance.ai.bridge.method.sqlite.b r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "protocolMessage");
        Intrinsics.checkNotNullParameter(r11, "resultCallback");
        TargetEntity r12 = r10.g();
        if (r12 != null) goto L7;
        r11.invoke(null);
        return;
    L7:
        if (r12.b() == TargetEntity.Scope.f2035c) goto L9;
    L19:
        r11.invoke(null);
        return;
    L9:
        if (r12.c() != TargetEntity.Target.f2038c) goto L19;
        s r13 = (s) ((n1.a) r5).b(s.class);
        if (r13 != null) goto L17;
        Intrinsics.checkNotNullParameter("AIBridgeWorkerHandler", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L15;
        r14.e("AIBridgeWorkerHandler", "appletRuntimeProvider is null");
    L15:
        r11.invoke(null);
        return;
    L17:
        r13.a(new com.bytedance.ai.bridge.method.net.e(r11, 8));
    }

    @Override // q1.g
    public final boolean b(ProtocolMessage r5) {
        Intrinsics.checkNotNullParameter(r5, "protocolMessage");
        TargetEntity r10 = r5.g();
        if (r10 == null) goto L5;
        TargetEntity.Scope r11 = r10.b();
    L7:
        return CollectionsKt.contains(f21469b, r11);
    L5:
        r11 = null;
        goto L7
    }
}
