package com.obric.memorydata.awareness.api;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/api/IRecommender;", "Lcom/bytedance/news/common/service/manager/IService;", "recommend", "", "data", "Lorg/json/JSONArray;", "awareness_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IRecommender extends IService {
    void recommend(JSONArray r1);
}
