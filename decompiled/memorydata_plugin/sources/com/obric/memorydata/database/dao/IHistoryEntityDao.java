package com.obric.memorydata.database.dao;

import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u0010\u0011\u001a\u00020\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016J$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/database/dao/IHistoryEntityDao;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/memorydata/database/entity/AbstractHistoryEntity;", "Lcom/obric/memorydata/database/dao/BaseDao;", "getPrefix", "", "queryByEntityId", "", "entityId", ObricMemoryConstants.KEY_PACKAGE_NAME, "deleteByEntityId", "", "deleteByEntityIdList", "entityIds", "deleteById", OaidModel.KEY_ID, "", "deleteByEntityIdListAndPackageName", "queryByEntityIdListAndPackageName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface IHistoryEntityDao<T extends c> extends BaseDao<T> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T extends c> int deleteAll(IHistoryEntityDao<T> r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((IHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends c> int deleteByEntityId(IHistoryEntityDao<T> r4, String r5, String r6) {
            IHistoryEntityDao r7 = (IHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityId");
            Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return r7.rawQueryForInt((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r7.getTableName() + " WHERE " + r7.getPrefix() + "entityId = '" + r5 + "' AND " + r7.getPrefix() + "packageName = '" + r6 + '\''), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends c> int deleteByEntityIdList(IHistoryEntityDao<T> r13, List<String> r14, String r15) {
            IHistoryEntityDao r16 = (IHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r13, IHistoryEntityDao.class, "com.obric.memorydata.plugin");
            List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r17, "entityIds");
            Intrinsics.checkNotNullParameter(r15, ObricMemoryConstants.KEY_PACKAGE_NAME);
            if (r17.isEmpty() == false) goto L5;
            return 0;
        L5:
            String r0 = r16.getPrefix();
            String r1 = "DELETE FROM " + r16.getTableName() + " WHERE " + r0 + "entityId IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, $$Lambda$IHistoryEntityDao$DefaultImpls$wXXxyaVEObEVezndmbRAjkG08UI.INSTANCE, 24, null) + " AND " + r0 + "packageName = ?";
            List r18 = CollectionsKt.toMutableList((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin"));
            r18.add(r15);
            return r16.rawQueryForInt((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(r1, (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r18, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin")), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        private static CharSequence deleteByEntityIdList$lambda$0(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
        }

        public static <T extends c> int deleteByEntityIdListAndPackageName(IHistoryEntityDao<T> r12, List<String> r13, String r14) {
            IHistoryEntityDao r15 = (IHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r12, IHistoryEntityDao.class, "com.obric.memorydata.plugin");
            List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r16, "entityIds");
            Intrinsics.checkNotNullParameter(r14, ObricMemoryConstants.KEY_PACKAGE_NAME);
            String r0 = r15.getPrefix();
            return r15.rawQueryForInt((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r15.getTableName() + " WHERE (" + r0 + "entityId IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, $$Lambda$IHistoryEntityDao$DefaultImpls$kOctr5MRtrY01PJaZc1qUMnd2w.INSTANCE, 24, null) + ") AND " + r0 + "packageName = '" + r14 + '\'', (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin")), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        private static CharSequence deleteByEntityIdListAndPackageName$lambda$2(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
        }

        public static <T extends c> int deleteById(IHistoryEntityDao<T> r4, long r5) {
            IHistoryEntityDao r6 = (IHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin");
            return r6.rawQueryForInt((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r6.getTableName() + " WHERE id = " + r5), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static /* synthetic */ CharSequence lambda$KurN7Kt2ZmS_fkfS8ffOe53mgVQ(String r0) {
            return queryByEntityIdListAndPackageName$lambda$3(r0);
        }

        /* JADX INFO: renamed from: lambda$kOctr5MRtrY0-1PJaZc1qUMnd2w, reason: not valid java name */
        public static /* synthetic */ CharSequence m541lambda$kOctr5MRtrY01PJaZc1qUMnd2w(String r0) {
            return deleteByEntityIdListAndPackageName$lambda$2(r0);
        }

        public static /* synthetic */ CharSequence lambda$wXXxyaVEObEVezndmbRAjkG08UI(String r0) {
            return deleteByEntityIdList$lambda$0(r0);
        }

        public static <T extends c> List<T> queryAll(IHistoryEntityDao<T> r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((IHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends c> int queryAllCount(IHistoryEntityDao<T> r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((IHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends c> List<T> queryByEntityId(IHistoryEntityDao<T> r4, String r5, String r6) {
            IHistoryEntityDao r7 = (IHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityId");
            Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return (List<T>) r7.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r7.getTableName() + " WHERE " + r7.getPrefix() + "entityId = '" + r5 + "' AND " + r7.getPrefix() + "packageName = '" + r6 + '\''), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static <T extends c> List<T> queryByEntityIdListAndPackageName(IHistoryEntityDao<T> r12, List<String> r13, String r14) {
            IHistoryEntityDao r15 = (IHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r12, IHistoryEntityDao.class, "com.obric.memorydata.plugin");
            List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r16, "entityIds");
            Intrinsics.checkNotNullParameter(r14, ObricMemoryConstants.KEY_PACKAGE_NAME);
            String r0 = r15.getPrefix();
            return (List<T>) r15.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r15.getTableName() + " WHERE (" + r0 + "entityId IN " + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("(", CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(")", CharSequence.class, "com.obric.memorydata.plugin"), 0, null, $$Lambda$IHistoryEntityDao$DefaultImpls$KurN7Kt2ZmS_fkfS8ffOe53mgVQ.INSTANCE, 24, null) + ") AND " + r0 + "packageName = '" + r14 + '\'', (String[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0]), String[].class, "com.obric.memorydata.plugin")), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        private static CharSequence queryByEntityIdListAndPackageName$lambda$3(String r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            return (CharSequence) ZeusTransformUtils.preCheckCast("?", CharSequence.class, "com.obric.memorydata.plugin");
        }

        public static <T extends c> T queryById(IHistoryEntityDao<T> r2, long r3) {
            return (T) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((IHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), c.class, "com.obric.memorydata.plugin");
        }

        public static <T extends c> List<T> queryByIds(IHistoryEntityDao<T> r2, List<Long> r3) {
            IHistoryEntityDao r4 = (IHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, IHistoryEntityDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static <T extends c> T queryByUUID(IHistoryEntityDao<T> r2, String r3) {
            IHistoryEntityDao r4 = (IHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, IHistoryEntityDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (T) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), c.class, "com.obric.memorydata.plugin");
        }

        public static <T extends c> T queryOne(IHistoryEntityDao<T> r2) {
            return (T) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((IHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), c.class, "com.obric.memorydata.plugin");
        }

        public static <T extends c> List<T> queryWithLimitAndOffset(IHistoryEntityDao<T> r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((IHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int deleteByEntityId(String r1, String r2);

    int deleteByEntityIdList(List<String> r1, String r2);

    int deleteByEntityIdListAndPackageName(List<String> r1, String r2);

    int deleteById(long r1);

    String getPrefix();

    List<T> queryByEntityId(String r1, String r2);

    List<T> queryByEntityIdListAndPackageName(List<String> r1, String r2);
}
