package com.obric.memorydata.awareness.api;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001J\u001f\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001J\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0096\u0001J!\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u0007H\u0096\u0001J!\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0007H\u0096\u0001J\u0011\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J3\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0013H\u0096\u0001¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/awareness/api/FeatureManager;", "Lcom/obric/memorydata/awareness/api/IFeatureManager;", "<init>", "()V", "addProducer", "", "groupName", "", "producer", "Lcom/obric/memorydata/awareness/api/IFeatureProducer;", "collectFeatures", "featureNames", "", "collect", "", "getFeature", "", "featureName", "getFeatureExtra", "", "getFeatureValueAndExtra", "hasDefineFeature", "removeProducer", "setFeature", EventBody.KEY_VALUE, WsConstants.KEY_EXTRA, "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FeatureManager implements IFeatureManager {
    public static final FeatureManager INSTANCE = null;
    private final /* synthetic */ IFeatureManager $$delegate_0;

    static {
        INSTANCE = new FeatureManager();
    }

    private FeatureManager() {
        IFeatureManager r0 = (IFeatureManager) ZeusTransformUtils.preCheckCast(ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IFeatureManager.class)), IFeatureManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = (IFeatureManager) ZeusTransformUtils.preCheckCast(DefaultFeatureManager.INSTANCE, IFeatureManager.class, "com.obric.memorydata.plugin");
    L5:
        this.$$delegate_0 = r0;
    }

    @Override // com.obric.memorydata.awareness.api.IFeatureManager
    public void addProducer(String r3, b r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "groupName");
        Intrinsics.checkNotNullParameter(r5, "producer");
        this.$$delegate_0.addProducer(r3, r5);
    }

    @Override // com.obric.memorydata.awareness.api.b
    public void collectFeatures(List<String> r3, boolean r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "featureNames");
        this.$$delegate_0.collectFeatures(r5, r4);
    }

    @Override // com.obric.memorydata.awareness.api.b
    public Object getFeature(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return this.$$delegate_0.getFeature(r2);
    }

    @Override // com.obric.memorydata.awareness.api.b
    public Map<String, Object> getFeatureExtra(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return this.$$delegate_0.getFeatureExtra(r2);
    }

    @Override // com.obric.memorydata.awareness.api.b
    public Map<String, Object> getFeatureValueAndExtra(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return this.$$delegate_0.getFeatureValueAndExtra(r2);
    }

    @Override // com.obric.memorydata.awareness.api.b
    public boolean hasDefineFeature(String r2) {
        Intrinsics.checkNotNullParameter(r2, "featureName");
        return this.$$delegate_0.hasDefineFeature(r2);
    }

    @Override // com.obric.memorydata.awareness.api.IFeatureManager
    public void removeProducer(String r2) {
        Intrinsics.checkNotNullParameter(r2, "groupName");
        this.$$delegate_0.removeProducer(r2);
    }

    @Override // com.obric.memorydata.awareness.api.b
    public void setFeature(String r3, Object r4, Map<String, ? extends Object> r5) {
        Map<String, ? extends Object> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "featureName");
        this.$$delegate_0.setFeature(r3, r4, r6);
    }
}
