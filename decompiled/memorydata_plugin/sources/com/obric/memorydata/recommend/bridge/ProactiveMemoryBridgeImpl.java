package com.obric.memorydata.recommend.bridge;

import com.obric.memorydata.middleware.api.bridge.IProactiveMemoryBridgeAPI;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.recommend.memory.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0000H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/recommend/bridge/ProactiveMemoryBridgeImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IProactiveMemoryBridgeAPI;", "<init>", "()V", "TAG", "", "getInst", "onScreenObservationResult", "", "data", "onProactivePortraitResult", "onEpisodicTopicMemoryResult", "logId", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveMemoryBridgeImpl implements IProactiveMemoryBridgeAPI {
    public static final ProactiveMemoryBridgeImpl INSTANCE = null;
    private static final String TAG = "ProactiveMemoryBridge";

    static {
        INSTANCE = new ProactiveMemoryBridgeImpl();
    }

    private ProactiveMemoryBridgeImpl() {
    }

    @JvmStatic
    public static final ProactiveMemoryBridgeImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IProactiveMemoryBridgeAPI
    public void onEpisodicTopicMemoryResult(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r4, "logId");
        RunLog.INSTANCE.debug(TAG, "onEpisodicTopicMemoryResult data = " + r3 + ", logId = " + r4);
        new b(r3, r4).a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IProactiveMemoryBridgeAPI
    public void onProactivePortraitResult(String r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        RunLog.INSTANCE.debug(TAG, "onProactivePortraitResult data = " + r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IProactiveMemoryBridgeAPI
    public void onScreenObservationResult(String r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        RunLog.INSTANCE.debug(TAG, "onScreenObservationResult data = " + r3);
        new com.obric.memorydata.recommend.memory.a(r3).a();
    }
}
