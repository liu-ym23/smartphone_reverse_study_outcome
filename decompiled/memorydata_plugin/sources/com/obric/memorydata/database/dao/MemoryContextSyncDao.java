package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.cm;
import com.obric.memorydata.database.entity.cn;
import com.obric.memorydata.database.entity.ip;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H'J\b\u0010\u0007\u001a\u00020\u0005H'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH'J\b\u0010\r\u001a\u00020\fH'J\b\u0010\u000e\u001a\u00020\u0005H'J \u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H'J0\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0014H'J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\t2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\tH'J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0014H'¨\u0006\u001f"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryContextSyncDao;", "", "queryState", "Lcom/obric/memorydata/database/entity/MemoryContextSyncStateEntity;", "upsertState", "", "state", "clearState", "queryPending", "", "Lcom/obric/memorydata/database/entity/MemoryContextSyncPendingEntity;", "limit", "", "countPending", "clearPending", "deletePendingIfUnchanged", Api.KEY_UUID, "", "operation", "sourceUpdateTime", "", "replacePendingIfUnchanged", "expectedOperation", "expectedSourceUpdateTime", "newOperation", "newSourceUpdateTime", "queryTargetSemanticByUuids", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryEntity;", "uuids", "insertFullPending", "syncTimeMs", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryContextSyncDao {
    void clearPending();

    void clearState();

    int countPending();

    int deletePendingIfUnchanged(String r1, int r2, long r3);

    void insertFullPending(long r1);

    List<cm> queryPending(int r1);

    cn queryState();

    List<ip> queryTargetSemanticByUuids(List<String> r1);

    int replacePendingIfUnchanged(String r1, int r2, long r3, int r5, long r6);

    void upsertState(cn r1);
}
