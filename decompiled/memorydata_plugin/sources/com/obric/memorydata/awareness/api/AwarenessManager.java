package com.obric.memorydata.awareness.api;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0096\u0001J)\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0096\u0001J\u001b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0007H\u0096\u0001J\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0096\u0001J=\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0096\u0001J=\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\n2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tH\u0096\u0001J\u0019\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0096\u0001J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010!H\u0096\u0001J\u0019\u0010\"\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001fH\u0096\u0001J\u0011\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0012H\u0096\u0001¨\u0006%"}, d2 = {"Lcom/obric/memorydata/awareness/api/AwarenessManager;", "Lcom/obric/memorydata/awareness/api/IAwarenessManager;", "<init>", "()V", "dispatchAwarenessEvent", "", "eventName", "", WsConstants.KEY_EXTRA, "", "", "dispatchTaskEvent", "getAddressByGps", "longitude", "", "latitude", "getCachedAddressByGps", "isPackageAutoTriggerEnabled", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "makeAwarenessFeature", "feature", "observeAnyListener", "Lkotlinx/coroutines/flow/StateFlow;", "event", "onFeatureChanged", "oldValue", "newValue", "onFeatureEvent", "registerAwarenessEvent", "listener", "Lcom/obric/memorydata/awareness/api/EventListener;", "resolveAtHomeEventLocation", "", "unregisterAwarenessEvent", "updatePackageInfo", "firstLaunch", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AwarenessManager implements IAwarenessManager {
    public static final AwarenessManager INSTANCE = null;
    private final /* synthetic */ IAwarenessManager $$delegate_0;

    static {
        INSTANCE = new AwarenessManager();
    }

    private AwarenessManager() {
        IAwarenessManager r0 = (IAwarenessManager) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IAwarenessManager.class)), IAwarenessManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = (IAwarenessManager) ZeusTransformUtils.preCheckCast(DefaultAwarenessManager.INSTANCE, IAwarenessManager.class, "com.obric.memorydata.plugin");
    L5:
        this.$$delegate_0 = r0;
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void dispatchAwarenessEvent(String r3, Map<String, ? extends Object> r4) {
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        this.$$delegate_0.dispatchAwarenessEvent(r3, r5);
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void dispatchTaskEvent(String r3, Map<String, ? extends Object> r4) {
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "eventName");
        this.$$delegate_0.dispatchTaskEvent(r3, r5);
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public String getAddressByGps(double r1, double r3) {
        return this.$$delegate_0.getAddressByGps(r1, r3);
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public String getCachedAddressByGps(double r1, double r3) {
        return this.$$delegate_0.getCachedAddressByGps(r1, r3);
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public boolean isPackageAutoTriggerEnabled(String r2) {
        Intrinsics.checkNotNullParameter(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);
        return this.$$delegate_0.isPackageAutoTriggerEnabled(r2);
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public boolean makeAwarenessFeature(String r2) {
        Intrinsics.checkNotNullParameter(r2, "feature");
        return this.$$delegate_0.makeAwarenessFeature(r2);
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public ar<Boolean> observeAnyListener(String r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return this.$$delegate_0.observeAnyListener(r2);
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void onFeatureChanged(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
        Map<String, ? extends Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "feature");
        this.$$delegate_0.onFeatureChanged(r3, r4, r5, r7);
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void onFeatureEvent(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
        Map<String, ? extends Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "feature");
        this.$$delegate_0.onFeatureEvent(r3, r4, r5, r7);
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void registerAwarenessEvent(String r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.$$delegate_0.registerAwarenessEvent(r3, r5);
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public List<Double> resolveAtHomeEventLocation() {
        return this.$$delegate_0.resolveAtHomeEventLocation();
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void unregisterAwarenessEvent(String r3, a r4) {
        a r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.$$delegate_0.unregisterAwarenessEvent(r3, r5);
    }

    @Override // com.obric.memorydata.awareness.api.IAwarenessManager
    public void updatePackageInfo(boolean r1) {
        this.$$delegate_0.updatePackageInfo(r1);
    }
}
