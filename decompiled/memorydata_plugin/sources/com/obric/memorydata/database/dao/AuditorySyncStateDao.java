package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.AuditorySyncStateEntity;
import com.obric.memorydata.database.entity.ChatMessage;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/dao/AuditorySyncStateDao;", "", ChatMessage.TYPE_QUERY, "Lcom/obric/memorydata/database/entity/AuditorySyncStateEntity;", "accountScope", "", "upsert", "", "state", "deleteByAccount", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AuditorySyncStateDao {
    int deleteByAccount(String r1);

    AuditorySyncStateEntity query(String r1);

    void upsert(AuditorySyncStateEntity r1);
}
