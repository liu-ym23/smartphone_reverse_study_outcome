package com.obric.memorydata.awareness.api;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J<\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0015H\u0016J<\u0010\u0016\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0015H\u0016J(\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\n2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0015H\u0016J(\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\n2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001d2\u0006\u0010\f\u001a\u00020\nH\u0016J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\u001a\u0010\"\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\u0010\u0010#\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010$H\u0016¨\u0006%"}, d2 = {"Lcom/obric/memorydata/awareness/api/DefaultAwarenessManager;", "Lcom/obric/memorydata/awareness/api/IAwarenessManager;", "<init>", "()V", "updatePackageInfo", "", "firstLaunch", "", "makeAwarenessFeature", "feature", "", "registerAwarenessEvent", "event", "listener", "Lcom/obric/memorydata/awareness/api/EventListener;", "unregisterAwarenessEvent", "onFeatureChanged", "oldValue", "", "newValue", WsConstants.KEY_EXTRA, "", "onFeatureEvent", "dispatchAwarenessEvent", "eventName", "dispatchTaskEvent", "isPackageAutoTriggerEnabled", ObricMemoryConstants.KEY_PACKAGE_NAME, "observeAnyListener", "Lkotlinx/coroutines/flow/StateFlow;", "getAddressByGps", "longitude", "", "latitude", "getCachedAddressByGps", "resolveAtHomeEventLocation", "", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultAwarenessManager implements IAwarenessManager {
    public static final DefaultAwarenessManager INSTANCE = null;

    static {
        INSTANCE = new DefaultAwarenessManager();
    }

    private DefaultAwarenessManager() {
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void dispatchAwarenessEvent(String r2, Map<String, ? extends Object> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "eventName");
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void dispatchTaskEvent(String r2, Map<String, ? extends Object> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "eventName");
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public String getAddressByGps(double r1, double r3) {
        return "";
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public String getCachedAddressByGps(double r1, double r3) {
        return null;
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public boolean isPackageAutoTriggerEnabled(String r1) {
        Intrinsics.checkNotNullParameter(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return true;
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public boolean makeAwarenessFeature(String r1) {
        Intrinsics.checkNotNullParameter(r1, "feature");
        return false;
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public ar<Boolean> observeAnyListener(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return (ar) ZeusTransformUtils.preCheckCast(at.a(false), ar.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void onFeatureChanged(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "feature");
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void onFeatureEvent(String r1, Object r2, Object r3, Map<String, ? extends Object> r4) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "feature");
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void registerAwarenessEvent(String r2, a r3) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r1, "listener");
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public List<Double> resolveAtHomeEventLocation() {
        return null;
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void unregisterAwarenessEvent(String r2, a r3) {
        a r1 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r1, "listener");
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void updatePackageInfo(boolean r1) {
    }
}
