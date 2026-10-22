package com.obric.memorydata.database.dao;

import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.GlassesSyncStateEntity;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\nH'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH'J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH'J\b\u0010\u000e\u001a\u00020\u0007H'¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/database/dao/GlassesSyncStateDao;", "", "insert", "", "entity", "Lcom/obric/memorydata/database/entity/GlassesSyncStateEntity;", BuildConfig.CHANNEL, "", "queryByAccountScope", "accountScope", "", "queryAll", "", "resetLastSuccessWindowEnd", "deleteAll", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface GlassesSyncStateDao {
    int deleteAll();

    long insert(GlassesSyncStateEntity r1);

    List<GlassesSyncStateEntity> queryAll();

    GlassesSyncStateEntity queryByAccountScope(String r1);

    int resetLastSuccessWindowEnd(String r1);

    int update(GlassesSyncStateEntity r1);
}
