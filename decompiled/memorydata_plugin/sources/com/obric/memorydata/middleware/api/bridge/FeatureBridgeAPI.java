package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\u0013\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J!\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u0005H\u0096\u0001J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0096\u0001J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0096\u0001J!\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J)\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\rH\u0096\u0001J=\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\rH\u0096\u0001J3\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\rH\u0096\u0001¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/FeatureBridgeAPI;", "Lcom/obric/memorydata/middleware/api/bridge/IFeatureBridgeAPI;", "<init>", "()V", "getCurrentLocationWeather", "", "dailySteps", "", "hourlySteps", "getFeature", "", "featureName", "getFeatureExtra", "", "getFeatureValueExtra", "getOAutoWhiteListApp", "", "getSupportedFeatureList", "getWeatherOfLocation", "location", "sendAwarenessEvent", "", "event", WsConstants.KEY_EXTRA, "sendFeatureEvent", "oldValue", "newValue", "setFeature", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FeatureBridgeAPI implements IFeatureBridgeAPI {
    public static final FeatureBridgeAPI INSTANCE = null;
    private final /* synthetic */ IFeatureBridgeAPI $$delegate_0;

    static {
        INSTANCE = new FeatureBridgeAPI();
    }

    private FeatureBridgeAPI() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IFeatureBridgeAPI.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IFeatureBridgeAPI) ZeusTransformUtils.preCheckCast(r0, IFeatureBridgeAPI.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public String getCurrentLocationWeather(int r1, int r2) {
        return this.$$delegate_0.getCurrentLocationWeather(r1, r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public Object getFeature(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return this.$$delegate_0.getFeature(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public Map<String, Object> getFeatureExtra(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return this.$$delegate_0.getFeatureExtra(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public Map<String, Object> getFeatureValueExtra(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return this.$$delegate_0.getFeatureValueExtra(r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public List<String> getOAutoWhiteListApp() {
        return this.$$delegate_0.getOAutoWhiteListApp();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public List<String> getSupportedFeatureList() {
        return this.$$delegate_0.getSupportedFeatureList();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public String getWeatherOfLocation(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "location");
        return this.$$delegate_0.getWeatherOfLocation(r2, r3, r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public void sendAwarenessEvent(String r3, Map<String, ? extends Object> r4) {
        Map<String, ? extends Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "event");
        this.$$delegate_0.sendAwarenessEvent(r3, r5);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public void sendFeatureEvent(String r3, Object r4, Object r5, Map<String, ? extends Object> r6) {
        Map<String, ? extends Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "featureName");
        this.$$delegate_0.sendFeatureEvent(r3, r4, r5, r7);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public void setFeature(String r3, Object r4, Map<String, ? extends Object> r5) {
        Map<String, ? extends Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "featureName");
        this.$$delegate_0.setFeature(r3, r4, r6);
    }
}
