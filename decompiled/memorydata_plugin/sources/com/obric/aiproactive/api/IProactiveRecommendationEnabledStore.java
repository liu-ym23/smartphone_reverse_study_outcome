package com.obric.aiproactive.api;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/api/IProactiveRecommendationEnabledStore;", "Lcom/bytedance/news/common/service/manager/IService;", "isEnabled", "", "registerListener", "", "listener", "Lcom/obric/aiproactive/api/ProactiveRecommendationEnabledListener;", "emitCurrent", "unregisterListener", "ai_proactive_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IProactiveRecommendationEnabledStore extends IService {
    boolean isEnabled();

    void registerListener(ae r1, boolean r2);

    void unregisterListener(ae r1);
}
