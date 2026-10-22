package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ey;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H'J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\tH'J$\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\tH'J\u0010\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0012H'J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\fH'¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/database/dao/ProactivePhoneEventDao;", "", "insert", "", "entity", "Lcom/obric/memorydata/database/entity/ProactivePhoneEventEntity;", BuildConfig.CHANNEL, "", "updateStatus", "", OaidModel.KEY_ID, "status", "", "updated", "listByStatus", "", "limit", "observeByStatus", "Lkotlinx/coroutines/flow/Flow;", "observeLatestId", "findLatestDebugLogIdByRecommendId", "recommendId", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ProactivePhoneEventDao {
    String findLatestDebugLogIdByRecommendId(String r1);

    long insert(ey r1);

    List<ey> listByStatus(String r1, int r2);

    i<List<ey>> observeByStatus(String r1, int r2);

    i<Long> observeLatestId();

    void update(ey r1);

    int updateStatus(long r1, String r3, long r4);
}
