package q1;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.bytedance.ai.model.p;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m1.k;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f21462a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f21463b = null;

    static {
        f21462a = new b();
        f21463b = CollectionsKt.listOf(TargetEntity.Scope.d);
    }

    @Override // q1.g
    public final void a(n1.c r5, ProtocolMessage r10, com.bytedance.ai.bridge.method.sqlite.b r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "protocolMessage");
        Intrinsics.checkNotNullParameter(r11, "resultCallback");
        TargetEntity r12 = r10.g();
        if (r12 == null) goto L17;
        TargetEntity.Target r13 = r12.c();
        if (r13 == null) goto L17;
        if (a.f21461a[r13.ordinal()] != 1) goto L17;
        t0.b r14 = p.f2294c;
        if (r14 == null) goto L17;
        String r15 = r14.currFloatingViewId();
        if (r15 == null) goto L17;
        Intrinsics.checkNotNullParameter(r15, "pageId");
        com.bytedance.ai.model.widgets.a r16 = (com.bytedance.ai.model.widgets.a) p.f2293b.get(r15);
        if (r16 == null) goto L17;
        k r17 = r16.i();
    L18:
        r11.invoke(r17);
        return;
    L17:
        r17 = null;
        goto L18
    }

    @Override // q1.g
    public final boolean b(ProtocolMessage r5) {
        Intrinsics.checkNotNullParameter(r5, "protocolMessage");
        TargetEntity r10 = r5.g();
        if (r10 == null) goto L5;
        TargetEntity.Scope r11 = r10.b();
    L7:
        return CollectionsKt.contains(f21463b, r11);
    L5:
        r11 = null;
        goto L7
    }
}
