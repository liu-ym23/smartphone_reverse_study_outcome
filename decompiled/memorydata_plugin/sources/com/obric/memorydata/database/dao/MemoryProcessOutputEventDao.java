package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.cx;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH'J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H'¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryProcessOutputEventDao;", "", "insert", "", "entity", "Lcom/obric/memorydata/database/entity/MemoryProcessOutputEventEntity;", "queryPending", "", "limit", "", "ack", "eventId", "", "updateTime", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryProcessOutputEventDao {
    int ack(String r1, long r2);

    long insert(cx r1);

    List<cx> queryPending(int r1);
}
