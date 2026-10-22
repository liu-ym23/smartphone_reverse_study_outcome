package com.bytedance.ai.ex.widget;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.core.AIBridgeMethod$Error;
import com.google.gson.JsonObject;
import com.lynx.jsbridge.LynxResourceModule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH&¨\u0006\f"}, d2 = {"Lcom/bytedance/ai/ex/widget/EventCall;", "", "sendCall", "", "name", "", LynxResourceModule.PARAMS_KEY, "Lcom/google/gson/JsonObject;", "resolve", "Landroidx/core/util/Consumer;", "reject", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "widget-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface EventCall {
    void sendCall(String r5, JsonObject r10, Consumer<JsonObject> r11, Consumer<AIBridgeMethod$Error> r12);
}
