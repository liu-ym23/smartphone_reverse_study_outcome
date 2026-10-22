package com.obric.memorydata.middleware.api.alog;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.news.common.service.manager.IService;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J(\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/middleware/api/alog/IALogManager;", "Lcom/bytedance/news/common/service/manager/IService;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "upload", "startTimeSec", "", "endTimeSec", MemoryInfoSectionEditActivity.KIND_SCENE, "", "uploadId", "middleware_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IALogManager extends IService {
    void init();

    void upload(long r1, long r3, String r5, String r6);
}
