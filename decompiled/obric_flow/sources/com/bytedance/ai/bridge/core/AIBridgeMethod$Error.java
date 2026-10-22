package com.bytedance.ai.bridge.core;

import com.google.gson.JsonObject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002¨\u0006\u0003"}, d2 = {"com/bytedance/ai/bridge/core/AIBridgeMethod$Error", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "applet-bridge_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class AIBridgeMethod$Error extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonObject f1807b;

    public AIBridgeMethod$Error(String r5) {
        super(r5);
        this.f1806a = r5;
        this.f1807b = null;
    }

    public AIBridgeMethod$Error(String r5, int r10) {
        super(r5);
        this.f1806a = r5;
        this.f1807b = null;
    }

    public AIBridgeMethod$Error(String r5, JsonObject r10) {
        super(r5);
        this.f1806a = r5;
        this.f1807b = r10;
    }
}
