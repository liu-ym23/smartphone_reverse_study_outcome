package com.obric.memorydata.memory.api;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.news.common.service.manager.IService;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&J6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&J6\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH&J\b\u0010\u0011\u001a\u00020\u0003H&¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/api/MemoryIslandApi;", "Lcom/bytedance/news/common/service/manager/IService;", "showMemory", "", OaidModel.KEY_ID, "", "state", "", "entity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "oldEntity", "needEffect", "", "showMemoryList", "entities", "", "oldEntities", "showEffect", "memory_api_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryIslandApi extends IService {
    void showEffect();

    void showMemory(String r1, int r2, MemoryEntity r3, MemoryEntity r4);

    void showMemory(String r1, int r2, boolean r3, MemoryEntity r4, MemoryEntity r5);

    void showMemoryList(String r1, int r2, List<? extends MemoryEntity> r3, List<? extends MemoryEntity> r4);
}
