package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.bg;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/dao/EmbeddingVectorCacheDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/EmbeddingVectorCacheEntity;", "getTableName", "", "queryOneRecordBy", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "embeddingType", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface EmbeddingVectorCacheDao extends BaseDao<bg> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(EmbeddingVectorCacheDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((EmbeddingVectorCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, EmbeddingVectorCacheDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(EmbeddingVectorCacheDao r2) {
            EmbeddingVectorCacheDao r3 = (EmbeddingVectorCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, EmbeddingVectorCacheDao.class, "com.obric.memorydata.plugin");
            return "EmbeddingVectorCache";
        }

        public static List<bg> queryAll(EmbeddingVectorCacheDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((EmbeddingVectorCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, EmbeddingVectorCacheDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(EmbeddingVectorCacheDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((EmbeddingVectorCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, EmbeddingVectorCacheDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static bg queryById(EmbeddingVectorCacheDao r2, long r3) {
            return (bg) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((EmbeddingVectorCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, EmbeddingVectorCacheDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), bg.class, "com.obric.memorydata.plugin");
        }

        public static List<bg> queryByIds(EmbeddingVectorCacheDao r2, List<Long> r3) {
            EmbeddingVectorCacheDao r4 = (EmbeddingVectorCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, EmbeddingVectorCacheDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static bg queryByUUID(EmbeddingVectorCacheDao r2, String r3) {
            EmbeddingVectorCacheDao r4 = (EmbeddingVectorCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, EmbeddingVectorCacheDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (bg) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), bg.class, "com.obric.memorydata.plugin");
        }

        public static bg queryOne(EmbeddingVectorCacheDao r2) {
            return (bg) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((EmbeddingVectorCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, EmbeddingVectorCacheDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), bg.class, "com.obric.memorydata.plugin");
        }

        public static List<bg> queryWithLimitAndOffset(EmbeddingVectorCacheDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((EmbeddingVectorCacheDao) ZeusTransformUtils.wrapperContextForParams(r2, EmbeddingVectorCacheDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    bg queryOneRecordBy(String r1, int r2);
}
