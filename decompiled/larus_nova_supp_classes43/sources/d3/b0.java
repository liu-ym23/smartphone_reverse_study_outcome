package d3;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface b0 {
    void a(String r1, JsonObject r10);

    com.bytedance.ai.bridge.core.a<JsonObject> b(JsonObject r1);

    void c(ProtocolMessage r1, Consumer<JsonObject> r10, Consumer<AIBridgeMethod.Error> r11, String r12);
}
