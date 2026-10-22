package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.by;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H'J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/dao/GlassesEpisodicRelevantDataDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/GlassesEpisodicRelevantData;", "queryByEpisodicId", "episodicId", "", "insert", "", "entity", "getTableName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface GlassesEpisodicRelevantDataDao extends BaseDao<by> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(GlassesEpisodicRelevantDataDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((GlassesEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, GlassesEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(GlassesEpisodicRelevantDataDao r2) {
            GlassesEpisodicRelevantDataDao r3 = (GlassesEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, GlassesEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin");
            return "GlassesEpisodicRelevantData";
        }

        public static List<by> queryAll(GlassesEpisodicRelevantDataDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((GlassesEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, GlassesEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(GlassesEpisodicRelevantDataDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((GlassesEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, GlassesEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static by queryById(GlassesEpisodicRelevantDataDao r2, long r3) {
            return (by) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((GlassesEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, GlassesEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), by.class, "com.obric.memorydata.plugin");
        }

        public static List<by> queryByIds(GlassesEpisodicRelevantDataDao r2, List<Long> r3) {
            GlassesEpisodicRelevantDataDao r4 = (GlassesEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, GlassesEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static by queryByUUID(GlassesEpisodicRelevantDataDao r2, String r3) {
            GlassesEpisodicRelevantDataDao r4 = (GlassesEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, GlassesEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (by) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), by.class, "com.obric.memorydata.plugin");
        }

        public static by queryOne(GlassesEpisodicRelevantDataDao r2) {
            return (by) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((GlassesEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, GlassesEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), by.class, "com.obric.memorydata.plugin");
        }

        public static List<by> queryWithLimitAndOffset(GlassesEpisodicRelevantDataDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((GlassesEpisodicRelevantDataDao) ZeusTransformUtils.wrapperContextForParams(r2, GlassesEpisodicRelevantDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(by r1);

    by queryByEpisodicId(String r1);
}
