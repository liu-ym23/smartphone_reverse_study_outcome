package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.iu;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H'J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u0016\u0010\t\u001a\u00020\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004H'J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0004H'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H'J&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H'J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H'J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0004H'J\u0016\u0010\u0017\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H'J\u0016\u0010\u0019\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007H'J\b\u0010\u001b\u001a\u00020\u0013H'J6\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H'J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\u00072\u0006\u0010\u0014\u001a\u00020\u0013H'J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u0004H'J\b\u0010$\u001a\u00020\u0010H\u0016¨\u0006%"}, d2 = {"Lcom/obric/memorydata/database/dao/UnionSemanticMemorySnapShotDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/UnionSemanticMemorySnapShotEntity;", "insert", "", "entity", "insertAll", "", "entities", "bulkInsert", "", "queryByUnionSemanticMemoryId", "unionSemanticMemoryId", "queryLatestByUnionSemanticMemoryId", "queryByEntityId", "entityId", "", "queryVersionWindowByEntityId", "currentVersion", "", "limit", "countVersionWindowByEntityId", "deleteByUnionSemanticMemoryId", "deleteByUnionSemanticMemoryIds", "unionSemanticMemoryIds", "deleteByEntityIds", "entityIds", "deleteAll", "queryPageBeforeCursor", "startTimeInclusive", "endTimeExclusive", "cursorSnapshotTime", "cursorId", "queryDistinctSnapshotLocalDays", "deleteBeforeSnapshotTime", "cutoffTimeExclusive", "getTableName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UnionSemanticMemorySnapShotDao extends BaseDao<iu> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getTableName(UnionSemanticMemorySnapShotDao r2) {
            UnionSemanticMemorySnapShotDao r3 = (UnionSemanticMemorySnapShotDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemorySnapShotDao.class, "com.obric.memorydata.plugin");
            return "UnionSemanticMemorySnapShot";
        }

        public static List<iu> queryAll(UnionSemanticMemorySnapShotDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticMemorySnapShotDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemorySnapShotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(UnionSemanticMemorySnapShotDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticMemorySnapShotDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemorySnapShotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static iu queryById(UnionSemanticMemorySnapShotDao r2, long r3) {
            return (iu) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticMemorySnapShotDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemorySnapShotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), iu.class, "com.obric.memorydata.plugin");
        }

        public static List<iu> queryByIds(UnionSemanticMemorySnapShotDao r2, List<Long> r3) {
            UnionSemanticMemorySnapShotDao r4 = (UnionSemanticMemorySnapShotDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemorySnapShotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static iu queryByUUID(UnionSemanticMemorySnapShotDao r2, String r3) {
            UnionSemanticMemorySnapShotDao r4 = (UnionSemanticMemorySnapShotDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemorySnapShotDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (iu) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), iu.class, "com.obric.memorydata.plugin");
        }

        public static iu queryOne(UnionSemanticMemorySnapShotDao r2) {
            return (iu) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticMemorySnapShotDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemorySnapShotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), iu.class, "com.obric.memorydata.plugin");
        }

        public static List<iu> queryWithLimitAndOffset(UnionSemanticMemorySnapShotDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((UnionSemanticMemorySnapShotDao) ZeusTransformUtils.wrapperContextForParams(r2, UnionSemanticMemorySnapShotDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    void bulkInsert(List<iu> r1);

    int countVersionWindowByEntityId(String r1, int r2);

    @Override // com.obric.memorydata.database.dao.BaseDao
    int deleteAll();

    int deleteBeforeSnapshotTime(long r1);

    int deleteByEntityIds(List<String> r1);

    int deleteByUnionSemanticMemoryId(long r1);

    int deleteByUnionSemanticMemoryIds(List<Long> r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(iu r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    List<Long> insertAll(List<iu> r1);

    List<iu> queryByEntityId(String r1);

    List<iu> queryByUnionSemanticMemoryId(long r1);

    List<String> queryDistinctSnapshotLocalDays(int r1);

    iu queryLatestByUnionSemanticMemoryId(long r1);

    List<iu> queryPageBeforeCursor(long r1, long r3, long r5, long r7, int r9);

    List<iu> queryVersionWindowByEntityId(String r1, int r2, int r3);
}
