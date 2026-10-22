package q1;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.bytedance.ai.model.p;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import m1.k;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f21466a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f21467b = null;

    static {
        f21466a = new e();
        f21467b = CollectionsKt.listOf(TargetEntity.Scope.f2034b);
    }

    @Override // q1.g
    public final void a(n1.c r5, ProtocolMessage r10, com.bytedance.ai.bridge.method.sqlite.b r11) {
        Intrinsics.checkNotNullParameter(r5, "bridgeContext");
        Intrinsics.checkNotNullParameter(r10, "protocolMessage");
        Intrinsics.checkNotNullParameter(r11, "resultCallback");
        TargetEntity r12 = r10.g();
        if (r12 == null) goto L20;
        TargetEntity.Target r13 = r12.c();
        if (r13 != null) goto L8;
        int r14 = -1;
    L10:
        if (r14 != 1) goto L20;
        String r15 = r12.a();
        if (r15 == null) goto L20;
        Lazy r16 = p.f2292a;
        Intrinsics.checkNotNullParameter(r15, "pageId");
        com.bytedance.ai.model.widgets.a r17 = (com.bytedance.ai.model.widgets.a) p.f2293b.get(r15);
        if (r17 == null) goto L17;
        k r18 = r17.i();
        if (r18 == null) goto L17;
    L21:
        r11.invoke(r18);
        return;
    L17:
        com.bytedance.ai.widget.contianer.f r19 = p.g(r15);
        if (r19 == null) goto L20;
        r18 = ((WidgetContainer) r19).f3025l;
        goto L21
    L8:
        r14 = d.f21465a[r13.ordinal()];
    L20:
        r18 = null;
        goto L21
    }

    @Override // q1.g
    public final boolean b(ProtocolMessage r5) {
        Intrinsics.checkNotNullParameter(r5, "protocolMessage");
        TargetEntity r10 = r5.g();
        if (r10 == null) goto L5;
        TargetEntity.Scope r11 = r10.b();
    L7:
        return CollectionsKt.contains(f21467b, r11);
    L5:
        r11 = null;
        goto L7
    }
}
