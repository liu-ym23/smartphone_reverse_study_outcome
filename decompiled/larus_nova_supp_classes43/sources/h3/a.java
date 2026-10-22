package h3;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.bytedance.ai.model.AppletRuntimeManager;
import d3.b0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements f {
    public static final a a = null;
    public static final List<TargetEntity.Scope> b = null;

    /* JADX INFO: renamed from: h3.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0162a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TargetEntity.Target.values().length];
            r0[TargetEntity.Target.Current.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = CollectionsKt.listOf(TargetEntity.Scope.Floating);
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
    public final void b(e3.a r10, ProtocolMessage r11, d3.b r12) {
        Intrinsics.checkNotNullParameter(r10, "bridgeContext");
        Intrinsics.checkNotNullParameter(r11, "protocolMessage");
        Intrinsics.checkNotNullParameter(r12, "resultCallback");
        TargetEntity r13 = r11.g();
        if (r13 == null) goto L17;
        TargetEntity.Target r14 = r13.c();
        if (r14 == null) goto L17;
        if (C0162a.a[r14.ordinal()] != 1) goto L17;
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r15 = AppletRuntimeManager.d;
        if (r15 == null) goto L17;
        String r16 = r15.e();
        if (r16 == null) goto L17;
        com.bytedance.ai.model.widgets.c r17 = AppletRuntimeManager.e(r16);
        if (r17 == null) goto L17;
        b0 r18 = r17.getAIBridge();
    L18:
        r12.invoke(r18);
        return;
    L17:
        r18 = null;
        goto L18
    }
}
