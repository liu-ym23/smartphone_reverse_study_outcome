package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.ev;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH'J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH'¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/dao/ProactiveMemoryRuleDao;", "", "upsert", "", "entity", "Lcom/obric/memorydata/database/entity/ProactiveMemoryRuleEntity;", "getById", "ruleId", "", "observeAll", "Lkotlinx/coroutines/flow/Flow;", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ProactiveMemoryRuleDao {
    ev getById(String r1);

    i<List<ev>> observeAll();

    void upsert(ev r1);
}
