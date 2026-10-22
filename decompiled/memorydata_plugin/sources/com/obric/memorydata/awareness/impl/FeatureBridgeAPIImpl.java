package com.obric.memorydata.awareness.impl;

import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0007J2\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016J(\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\b2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\fH\u0016J<\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\fH\u0016J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J \u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0011H\u0016¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/awareness/impl/FeatureBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/IFeatureBridgeAPI;", "<init>", "()V", "getInst", "setFeature", "", "featureName", "", "newValue", "", WsConstants.KEY_EXTRA, "", "getFeature", "getFeatureExtra", "getFeatureValueExtra", "getSupportedFeatureList", "", "sendAwarenessEvent", "event", "sendFeatureEvent", "oldValue", "getCurrentLocationWeather", "dailySteps", "", "hourlySteps", "getWeatherOfLocation", "location", "getOAutoWhiteListApp", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FeatureBridgeAPIImpl implements IFeatureBridgeAPI {
    public static final FeatureBridgeAPIImpl INSTANCE = null;

    static {
        INSTANCE = new FeatureBridgeAPIImpl();
    }

    private FeatureBridgeAPIImpl() {
    }

    @JvmStatic
    public static final FeatureBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public String getCurrentLocationWeather(int r1, int r2) {
        return com.obric.memorydata.awareness.c.a.f8544a.a(r1, r2);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public Object getFeature(String r1) {
        Intrinsics.checkNotNullParameter(r1, "featureName");
        return FeatureManager.INSTANCE.getFeature(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public Map<String, Object> getFeatureExtra(String r1) {
        Intrinsics.checkNotNullParameter(r1, "featureName");
        return FeatureManager.INSTANCE.getFeatureExtra(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public Map<String, Object> getFeatureValueExtra(String r1) {
        Intrinsics.checkNotNullParameter(r1, "featureName");
        return FeatureManager.INSTANCE.getFeatureValueAndExtra(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public List<String> getOAutoWhiteListApp() {
        return com.obric.memorydata.awareness.b.a.f8541a.a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public List<String> getSupportedFeatureList() {
        return l.f8716a.a();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public String getWeatherOfLocation(String r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "location");
        return com.obric.memorydata.awareness.c.a.f8544a.a(r1, r2, r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public void sendAwarenessEvent(String r2, Map<String, ? extends Object> r3) {
        Map<String, ? extends Object> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "event");
        AwarenessManager.INSTANCE.dispatchAwarenessEvent(r2, r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public void sendFeatureEvent(String r2, Object r3, Object r4, Map<String, ? extends Object> r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "featureName");
        AwarenessManager.INSTANCE.onFeatureEvent(r2, r3, r4, com.obric.memorydata.awareness.impl.a.c.a(r1));
    }

    @Override // com.obric.memorydata.middleware.api.bridge.IFeatureBridgeAPI
    public void setFeature(String r2, Object r3, Map<String, ? extends Object> r4) {
        Map<String, ? extends Object> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "featureName");
        FeatureManager.INSTANCE.setFeature(r2, r3, r1);
    }
}
