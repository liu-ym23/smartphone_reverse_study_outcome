package com.obric.memorydata.database.dao;

import com.obric.memorydata.database.entity.ik;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\u0017\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\tH'¢\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\tH'J\u0018\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e2\u0006\u0010\b\u001a\u00020\tH'J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0003H'J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH'J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H'J\u0016\u0010\u0015\u001a\u00020\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0017H'J\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0017H'¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/obric/memorydata/database/dao/SemanticStateDao;", "", "insertIfAbsent", "", "entity", "Lcom/obric/memorydata/database/entity/SemanticStateEntity;", "increment", "", "key", "", "queryNum", "(Ljava/lang/String;)Ljava/lang/Long;", "queryText", "observeText", "Lkotlinx/coroutines/flow/Flow;", "updateNum", "num", "updateText", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "updateNumIfExpected", "expected", "countKeys", "keys", "", "minNum", "(Ljava/util/List;)Ljava/lang/Long;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface SemanticStateDao {
    int countKeys(List<String> r1);

    int increment(String r1);

    long insertIfAbsent(ik r1);

    Long minNum(List<String> r1);

    i<String> observeText(String r1);

    Long queryNum(String r1);

    String queryText(String r1);

    int updateNum(String r1, long r2);

    int updateNumIfExpected(String r1, long r2, long r4);

    int updateText(String r1, String r2);
}
