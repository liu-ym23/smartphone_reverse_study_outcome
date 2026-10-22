package g3;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.core.adapter.XBridge3ToAIBridgeAdapter;
import com.ivy.ivykit.api.bridge.IBridgeMethodService;
import f3.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements l {
    public b() {
    }

    @Override // f3.l
    public final AIBridgeMethod a(String r10, ContainerType r11) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r11, "aiContainerType");
        bx7.b r12 = IBridgeMethodService.a.a(r10);
        if (r12 != null) goto L7;
        return null;
    L7:
        return new XBridge3ToAIBridgeAdapter(r12);
    }
}
