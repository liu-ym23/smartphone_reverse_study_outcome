package com.obric.memorydata.awareness.api;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J \u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J \u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J2\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u001e\u0010\u0016\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0016¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/awareness/api/DefaultFeatureManager;", "Lcom/obric/memorydata/awareness/api/IFeatureManager;", "<init>", "()V", "addProducer", "", "groupName", "", "producer", "Lcom/obric/memorydata/awareness/api/IFeatureProducer;", "removeProducer", "getFeature", "", "featureName", "getFeatureExtra", "", "getFeatureValueAndExtra", "setFeature", EventBody.KEY_VALUE, WsConstants.KEY_EXTRA, "hasDefineFeature", "", "collectFeatures", "featureNames", "", "collect", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DefaultFeatureManager implements IFeatureManager {
    public static final DefaultFeatureManager INSTANCE = null;

    static {
        INSTANCE = new DefaultFeatureManager();
    }

    private DefaultFeatureManager() {
    }

    @Override // com.obric.memorydata.awareness.api.IFeatureManager
    public void addProducer(String r2, b r3) {
        b r1 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "groupName");
        Intrinsics.checkNotNullParameter(r1, "producer");
    }

    @Override // com.obric.memorydata.awareness.api.b
    public void collectFeatures(List<String> r1, boolean r2) {
        Intrinsics.checkNotNullParameter((List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin"), "featureNames");
    }

    @Override // com.obric.memorydata.awareness.api.b
    public Object getFeature(String r1) {
        Intrinsics.checkNotNullParameter(r1, "featureName");
        return null;
    }

    @Override // com.obric.memorydata.awareness.api.b
    public Map<String, Object> getFeatureExtra(String r1) {
        Intrinsics.checkNotNullParameter(r1, "featureName");
        return null;
    }

    @Override // com.obric.memorydata.awareness.api.b
    public Map<String, Object> getFeatureValueAndExtra(String r1) {
        Intrinsics.checkNotNullParameter(r1, "featureName");
        return null;
    }

    @Override // com.obric.memorydata.awareness.api.b
    public boolean hasDefineFeature(String r1) {
        Intrinsics.checkNotNullParameter(r1, "featureName");
        return false;
    }

    @Override // com.obric.memorydata.awareness.api.IFeatureManager
    public void removeProducer(String r1) {
        Intrinsics.checkNotNullParameter(r1, "groupName");
    }

    @Override // com.obric.memorydata.awareness.api.b
    public void setFeature(String r1, Object r2, Map<String, ? extends Object> r3) {
        Map r0 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "featureName");
    }
}
