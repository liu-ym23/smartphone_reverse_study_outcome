package n4;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends a {
    public final b b;

    public c(ProtocolMessage r10, b r11) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_MSG);
        super(r10);
        this.b = r11;
    }
}
