package h3;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.contianer.h;
import d3.b0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements f {
    public static final c a = null;
    public static final List<TargetEntity.Scope> b = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[TargetEntity.Target.values().length];
            r0[TargetEntity.Target.InstanceId.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public c() {
    }

    static {
        a = new c();
        b = CollectionsKt.listOf(TargetEntity.Scope.View);
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
        if (r13 == null) goto L20;
        TargetEntity.Target r14 = r13.c();
        if (r14 != null) goto L8;
        int r15 = -1;
    L10:
        if (r15 != 1) goto L20;
        String r16 = r13.a();
        if (r16 == null) goto L20;
        AppletRuntimeManager.INSTANCE.getClass();
        com.bytedance.ai.model.widgets.c r17 = AppletRuntimeManager.e(r16);
        if (r17 == null) goto L17;
        b0 r18 = r17.getAIBridge();
        if (r18 == null) goto L17;
    L21:
        r12.invoke(r18);
        return;
    L17:
        h r19 = AppletRuntimeManager.f(r16);
        if (r19 == null) goto L20;
        r18 = ((WidgetContainer) r19).o;
        goto L21
    L8:
        r15 = a.a[r14.ordinal()];
    L20:
        r18 = null;
        goto L21
    }
}
