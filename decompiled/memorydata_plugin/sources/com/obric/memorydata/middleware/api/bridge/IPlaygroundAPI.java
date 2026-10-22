package com.obric.memorydata.middleware.api.bridge;

import com.bytedance.news.common.service.manager.IService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/middleware/api/bridge/IPlaygroundAPI;", "Lcom/bytedance/news/common/service/manager/IService;", "getSkillList", "Lcom/obric/memorydata/middleware/api/bridge/Response;", "loadSkill", "skillId", "", "dispatchIntent", "payload", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IPlaygroundAPI extends IService {
    Response dispatchIntent(String r1);

    Response getSkillList();

    Response loadSkill(String r1);
}
