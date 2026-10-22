package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.cp;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H'J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH'J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H'J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H'J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004H'J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\t0\u00162\u0006\u0010\r\u001a\u00020\u0004H'¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryEntityCorrelationDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/MemoryEntityCorrelationEntity;", "getTableName", "", "insert", "", "entity", "insertAll", "", "entities", "hasValidRelation", "", "sourceEntityId", "currentTime", "getValidRelation", "deleteInvalidRelations", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deletedRelations", "entityId", "getValidRelatedEntitiesWithOrder", "Lkotlinx/coroutines/flow/Flow;", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryEntityCorrelationDao extends BaseDao<cp> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(MemoryEntityCorrelationDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((MemoryEntityCorrelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityCorrelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(MemoryEntityCorrelationDao r2) {
            MemoryEntityCorrelationDao r3 = (MemoryEntityCorrelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityCorrelationDao.class, "com.obric.memorydata.plugin");
            return "RawMemoryEntityCorrelation";
        }

        public static List<cp> queryAll(MemoryEntityCorrelationDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((MemoryEntityCorrelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityCorrelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MemoryEntityCorrelationDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((MemoryEntityCorrelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityCorrelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static cp queryById(MemoryEntityCorrelationDao r2, long r3) {
            return (cp) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((MemoryEntityCorrelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityCorrelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), cp.class, "com.obric.memorydata.plugin");
        }

        public static List<cp> queryByIds(MemoryEntityCorrelationDao r2, List<Long> r3) {
            MemoryEntityCorrelationDao r4 = (MemoryEntityCorrelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityCorrelationDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static cp queryByUUID(MemoryEntityCorrelationDao r2, String r3) {
            MemoryEntityCorrelationDao r4 = (MemoryEntityCorrelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityCorrelationDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (cp) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), cp.class, "com.obric.memorydata.plugin");
        }

        public static cp queryOne(MemoryEntityCorrelationDao r2) {
            return (cp) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((MemoryEntityCorrelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityCorrelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), cp.class, "com.obric.memorydata.plugin");
        }

        public static List<cp> queryWithLimitAndOffset(MemoryEntityCorrelationDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((MemoryEntityCorrelationDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityCorrelationDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    Object deleteInvalidRelations(String r1, long r2, Continuation<? super Unit> r4);

    void deletedRelations(String r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    i<List<EpisodicMemoryEntity>> getValidRelatedEntitiesWithOrder(String r1);

    List<cp> getValidRelation(String r1, long r2);

    boolean hasValidRelation(String r1, long r2);

    long insert(cp r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    List<Long> insertAll(List<cp> r1);
}
