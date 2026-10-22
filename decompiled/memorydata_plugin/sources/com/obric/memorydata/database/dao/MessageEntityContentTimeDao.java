package com.obric.memorydata.database.dao;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.di;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/dao/MessageEntityContentTimeDao;", "Lcom/obric/memorydata/database/dao/IAppEntityContentTimeDao;", "Lcom/obric/memorydata/database/entity/MessageEntityContentTimeEntity;", "getTableName", "", "queryByRawDbId", "rawDbId", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MessageEntityContentTimeDao extends IAppEntityContentTimeDao<di> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String buildColumnGroup(MessageEntityContentTimeDao r2, Set<String> r3) {
            MessageEntityContentTimeDao r4 = (MessageEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityContentTimeDao.class, "com.obric.memorydata.plugin");
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "columnSet");
            return IAppEntityContentTimeDao.DefaultImpls.buildColumnGroup((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int deleteAll(MessageEntityContentTimeDao r2) {
            return IAppEntityContentTimeDao.DefaultImpls.deleteAll((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast((MessageEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityContentTimeDao.class, "com.obric.memorydata.plugin"), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbId(MessageEntityContentTimeDao r2, long r3) {
            return IAppEntityContentTimeDao.DefaultImpls.deleteByRawDbId((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast((MessageEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityContentTimeDao.class, "com.obric.memorydata.plugin"), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static void deleteByRawDbIdAndColumns(MessageEntityContentTimeDao r2, long r3, Set<String> r5) {
            MessageEntityContentTimeDao r4 = (MessageEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityContentTimeDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            IAppEntityContentTimeDao.DefaultImpls.deleteByRawDbIdAndColumns((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static int deleteByRawDbIds(MessageEntityContentTimeDao r2, List<Long> r3) {
            MessageEntityContentTimeDao r4 = (MessageEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityContentTimeDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityContentTimeDao.DefaultImpls.deleteByRawDbIds((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static String getTableName(MessageEntityContentTimeDao r2) {
            MessageEntityContentTimeDao r3 = (MessageEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityContentTimeDao.class, "com.obric.memorydata.plugin");
            return "MessageEntityContentTime";
        }

        public static List<di> queryAll(MessageEntityContentTimeDao r2) {
            return IAppEntityContentTimeDao.DefaultImpls.queryAll((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast((MessageEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityContentTimeDao.class, "com.obric.memorydata.plugin"), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MessageEntityContentTimeDao r2) {
            return IAppEntityContentTimeDao.DefaultImpls.queryAllCount((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast((MessageEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityContentTimeDao.class, "com.obric.memorydata.plugin"), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"));
        }

        public static di queryById(MessageEntityContentTimeDao r2, long r3) {
            return (di) ZeusTransformUtils.preCheckCast(IAppEntityContentTimeDao.DefaultImpls.queryById((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast((MessageEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityContentTimeDao.class, "com.obric.memorydata.plugin"), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r3), di.class, "com.obric.memorydata.plugin");
        }

        public static List<di> queryByIds(MessageEntityContentTimeDao r2, List<Long> r3) {
            MessageEntityContentTimeDao r4 = (MessageEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityContentTimeDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityContentTimeDao.DefaultImpls.queryByIds((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static di queryByRawDbId(MessageEntityContentTimeDao r4, long r5) {
            MessageEntityContentTimeDao r6 = (MessageEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r4, MessageEntityContentTimeDao.class, "com.obric.memorydata.plugin");
            return (di) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r6.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r6.getTableName() + " WHERE rawDbId = " + r5 + " LIMIT 1"), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"))), di.class, "com.obric.memorydata.plugin");
        }

        public static di queryByUUID(MessageEntityContentTimeDao r2, String r3) {
            MessageEntityContentTimeDao r4 = (MessageEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityContentTimeDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (di) ZeusTransformUtils.preCheckCast(IAppEntityContentTimeDao.DefaultImpls.queryByUUID((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r3), di.class, "com.obric.memorydata.plugin");
        }

        public static di queryOne(MessageEntityContentTimeDao r2) {
            return (di) ZeusTransformUtils.preCheckCast(IAppEntityContentTimeDao.DefaultImpls.queryOne((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast((MessageEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityContentTimeDao.class, "com.obric.memorydata.plugin"), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin")), di.class, "com.obric.memorydata.plugin");
        }

        public static List<di> queryWithLimitAndOffset(MessageEntityContentTimeDao r2, int r3, int r4) {
            return IAppEntityContentTimeDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityContentTimeDao) ZeusTransformUtils.preCheckCast((MessageEntityContentTimeDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityContentTimeDao.class, "com.obric.memorydata.plugin"), IAppEntityContentTimeDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    di queryByRawDbId(long r1);
}
