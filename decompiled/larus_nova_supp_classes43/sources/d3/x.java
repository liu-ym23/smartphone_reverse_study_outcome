package d3;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class x {
    public final ProtocolMessage a;

    public x(String r10, ProtocolMessage r11) {
        Intrinsics.checkNotNullParameter(r10, "methodName");
        Intrinsics.checkNotNullParameter(r11, "protocolMessage");
        this.a = r11;
        System.currentTimeMillis();
    }
}
