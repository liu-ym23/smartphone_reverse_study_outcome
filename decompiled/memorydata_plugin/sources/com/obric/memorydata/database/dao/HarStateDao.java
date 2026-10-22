package com.obric.memorydata.database.dao;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.bz;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/dao/HarStateDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/HarStateEntity;", "getTableName", "", "queryLatest", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface HarStateDao extends BaseDao<bz> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(HarStateDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((HarStateDao) ZeusTransformUtils.wrapperContextForParams(r2, HarStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(HarStateDao r2) {
            HarStateDao r3 = (HarStateDao) ZeusTransformUtils.wrapperContextForParams(r2, HarStateDao.class, "com.obric.memorydata.plugin");
            return "har_state";
        }

        public static List<bz> queryAll(HarStateDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((HarStateDao) ZeusTransformUtils.wrapperContextForParams(r2, HarStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(HarStateDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((HarStateDao) ZeusTransformUtils.wrapperContextForParams(r2, HarStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static bz queryById(HarStateDao r2, long r3) {
            return (bz) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((HarStateDao) ZeusTransformUtils.wrapperContextForParams(r2, HarStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), bz.class, "com.obric.memorydata.plugin");
        }

        public static List<bz> queryByIds(HarStateDao r2, List<Long> r3) {
            HarStateDao r4 = (HarStateDao) ZeusTransformUtils.wrapperContextForParams(r2, HarStateDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static bz queryByUUID(HarStateDao r2, String r3) {
            HarStateDao r4 = (HarStateDao) ZeusTransformUtils.wrapperContextForParams(r2, HarStateDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (bz) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), bz.class, "com.obric.memorydata.plugin");
        }

        public static bz queryLatest(HarStateDao r3) {
            return (bz) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(((HarStateDao) ZeusTransformUtils.wrapperContextForParams(r3, HarStateDao.class, "com.obric.memorydata.plugin")).rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM har_state ORDER BY id DESC LIMIT 1"), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"))), bz.class, "com.obric.memorydata.plugin");
        }

        public static bz queryOne(HarStateDao r2) {
            return (bz) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((HarStateDao) ZeusTransformUtils.wrapperContextForParams(r2, HarStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), bz.class, "com.obric.memorydata.plugin");
        }

        public static List<bz> queryWithLimitAndOffset(HarStateDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((HarStateDao) ZeusTransformUtils.wrapperContextForParams(r2, HarStateDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    bz queryLatest();
}
