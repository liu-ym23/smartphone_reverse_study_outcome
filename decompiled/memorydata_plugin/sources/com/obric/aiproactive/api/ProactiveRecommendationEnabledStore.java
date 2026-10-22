package com.obric.aiproactive.api;

import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0096\u0001¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/api/ProactiveRecommendationEnabledStore;", "Lcom/obric/aiproactive/api/IProactiveRecommendationEnabledStore;", "<init>", "()V", "isEnabled", "", "registerListener", "", "listener", "Lcom/obric/aiproactive/api/ProactiveRecommendationEnabledListener;", "emitCurrent", "unregisterListener", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveRecommendationEnabledStore implements IProactiveRecommendationEnabledStore {
    public static final ProactiveRecommendationEnabledStore INSTANCE = null;
    private final /* synthetic */ IProactiveRecommendationEnabledStore $$delegate_0;

    static {
        INSTANCE = new ProactiveRecommendationEnabledStore();
    }

    private ProactiveRecommendationEnabledStore() {
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IProactiveRecommendationEnabledStore.class));
        Intrinsics.checkNotNull(r0);
        this.$$delegate_0 = (IProactiveRecommendationEnabledStore) ZeusTransformUtils.preCheckCast(r0, IProactiveRecommendationEnabledStore.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.aiproactive.api.IProactiveRecommendationEnabledStore
    public boolean isEnabled() {
        return this.$$delegate_0.isEnabled();
    }

    @Override // com.obric.aiproactive.api.IProactiveRecommendationEnabledStore
    public void registerListener(ae r3, boolean r4) {
        ae r5 = (ae) ZeusTransformUtils.wrapperContextForParams(r3, ae.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.$$delegate_0.registerListener(r5, r4);
    }

    @Override // com.obric.aiproactive.api.IProactiveRecommendationEnabledStore
    public void unregisterListener(ae r3) {
        ae r4 = (ae) ZeusTransformUtils.wrapperContextForParams(r3, ae.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.$$delegate_0.unregisterListener(r4);
    }
}
