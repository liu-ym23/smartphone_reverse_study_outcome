package com.obric.memorydata.database.dao;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.ct;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\nH'J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH'J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH'J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\u001e\u0010\u0013\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\nH'¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryMapTableDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/MemoryMapEntity;", "getTableName", "", "queryByEntity", "", "entityRawDbId", "", "entityType", "", "queryByEntitySet", "entityRawDbIds", "", "queryByEntityType", "queryByMemoryRawDbId", "memoryRawDbId", "queryByMemoryRawDbIdSize", "deleteByEntity", "deleteByEntityRawDbIds", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryMapTableDao extends BaseDao<ct> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(MemoryMapTableDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((MemoryMapTableDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryMapTableDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(MemoryMapTableDao r2) {
            MemoryMapTableDao r3 = (MemoryMapTableDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryMapTableDao.class, "com.obric.memorydata.plugin");
            return "AppEntityToMemoryTable";
        }

        public static List<ct> queryAll(MemoryMapTableDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((MemoryMapTableDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryMapTableDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MemoryMapTableDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((MemoryMapTableDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryMapTableDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<ct> queryByEntitySet(MemoryMapTableDao r11, Set<Long> r12, int r13) {
            MemoryMapTableDao r14 = (MemoryMapTableDao) ZeusTransformUtils.wrapperContextForParams(r11, MemoryMapTableDao.class, "com.obric.memorydata.plugin");
            Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "entityRawDbIds");
            return r14.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM AppEntityToMemoryTable WHERE entityType = " + r13 + " AND entityRawDbId in (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r15, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')'), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static ct queryById(MemoryMapTableDao r2, long r3) {
            return (ct) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((MemoryMapTableDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryMapTableDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ct.class, "com.obric.memorydata.plugin");
        }

        public static List<ct> queryByIds(MemoryMapTableDao r2, List<Long> r3) {
            MemoryMapTableDao r4 = (MemoryMapTableDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryMapTableDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ct queryByUUID(MemoryMapTableDao r2, String r3) {
            MemoryMapTableDao r4 = (MemoryMapTableDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryMapTableDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ct) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ct.class, "com.obric.memorydata.plugin");
        }

        public static ct queryOne(MemoryMapTableDao r2) {
            return (ct) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((MemoryMapTableDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryMapTableDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ct.class, "com.obric.memorydata.plugin");
        }

        public static List<ct> queryWithLimitAndOffset(MemoryMapTableDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((MemoryMapTableDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryMapTableDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int deleteByEntity(long r1, int r3);

    int deleteByEntityRawDbIds(List<Long> r1, int r2);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<ct> queryByEntity(long r1, int r3);

    List<ct> queryByEntitySet(Set<Long> r1, int r2);

    List<ct> queryByEntityType(int r1);

    List<ct> queryByMemoryRawDbId(long r1);

    long queryByMemoryRawDbIdSize(long r1);
}
