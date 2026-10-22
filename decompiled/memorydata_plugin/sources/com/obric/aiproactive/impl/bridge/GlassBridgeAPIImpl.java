package com.obric.aiproactive.impl.bridge;

import com.obric.aiproactive.api.DoubaoGlassesConnectionState;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.obric.memorydata.middleware.api.bridge.IGlassBridgeAPI;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/aiproactive/impl/bridge/GlassBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IGlassBridgeAPI;", "<init>", "()V", "getInst", "isConnected", "", "isWearing", "isConnectedGeneration", PendingPersonalInfoNotificationTask.KEY_GENERATION, "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GlassBridgeAPIImpl implements IGlassBridgeAPI {
    public static final GlassBridgeAPIImpl INSTANCE = null;

    static {
        INSTANCE = new GlassBridgeAPIImpl();
    }

    private GlassBridgeAPIImpl() {
    }

    @JvmStatic
    public static final GlassBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IGlassBridgeAPI
    public boolean isConnected() {
        return DoubaoGlassesConnectionState.INSTANCE.isConnected();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IGlassBridgeAPI
    public boolean isConnectedGeneration(long r1) {
        return DoubaoGlassesConnectionState.INSTANCE.isConnectedGeneration(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IGlassBridgeAPI
    public boolean isWearing() {
        return DoubaoGlassesConnectionState.INSTANCE.isWearing();
    }
}
