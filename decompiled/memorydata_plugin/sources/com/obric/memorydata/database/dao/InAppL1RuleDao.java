package com.obric.memorydata.database.dao;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.ca;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006H'J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH'¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/database/dao/InAppL1RuleDao;", "", "readAll", "", "Lcom/obric/memorydata/database/entity/InAppL1RuleEntity;", "observe", "Lkotlinx/coroutines/flow/Flow;", "upsert", "", "rows", "remove", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "ruleId", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface InAppL1RuleDao {
    i<List<ca>> observe();

    List<ca> readAll();

    void remove(String r1, String r2);

    void upsert(List<ca> r1);
}
