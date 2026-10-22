package com.obric.memorydata.awareness.api;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0001H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/awareness/api/IFeatureManager;", "Lcom/obric/memorydata/awareness/api/IFeatureProducer;", "Lcom/bytedance/news/common/service/manager/IService;", "addProducer", "", "groupName", "", "producer", "removeProducer", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IFeatureManager extends IService, b {
    void addProducer(String r1, b r2);

    void removeProducer(String r1);
}
