package com.obric.memorydata.memory.api;

import com.bytedance.news.common.service.manager.IService;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\tH&J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryBuildOuterApi;", "Lcom/bytedance/news/common/service/manager/IService;", "trackProcessedSemanticMemory", "", TrackerImpl.PARAMS, "Lcom/obric/memorydata/memory/api/ProcessedSemanticMemoryParams;", "trackMemoryDelete", "ids", "", "", "deleteMethod", "trackAppEntityIndex", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "generateMethod", "batched", "", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryBuildOuterApi extends IService {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(MemoryBuildOuterApi r2, AppEntity r3, String r4, boolean r5, int r6, Object r7) {
            MemoryBuildOuterApi r8 = (MemoryBuildOuterApi) ZeusTransformUtils.wrapperContextForParams(r2, MemoryBuildOuterApi.class, "com.obric.memorydata.plugin");
            if (r7 != null) goto L10;
            if ((r6 & 4) == 0) goto L7;
            r5 = false;
        L7:
            r8.trackAppEntityIndex(r3, r4, r5);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackAppEntityIndex");
        }
    }

    void trackAppEntityIndex(AppEntity r1, String r2, boolean r3);

    void trackMemoryDelete(List<String> r1, String r2);

    void trackProcessedSemanticMemory(c r1);
}
