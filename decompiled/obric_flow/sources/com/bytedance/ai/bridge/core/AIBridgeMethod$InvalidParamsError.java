package com.bytedance.ai.bridge.core;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/ai/bridge/core/AIBridgeMethod$InvalidParamsError", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "applet-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIBridgeMethod$InvalidParamsError extends AIBridgeMethod$Error {
    public AIBridgeMethod$InvalidParamsError() {
        super("the result passed by the method implementor is invalid", null);
    }

    public AIBridgeMethod$InvalidParamsError(String r5) {
        super(r5, null);
    }
}
