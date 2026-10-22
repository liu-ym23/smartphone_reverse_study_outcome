package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.cf;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/LifeLogTextEntityTextVectorCopilotDao;", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "Lcom/obric/memorydata/database/entity/LifeLogEntityTextVectorCopilotEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LifeLogTextEntityTextVectorCopilotDao extends IAppEntityVectorCopilotDao<cf> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String buildColumnGroup(LifeLogTextEntityTextVectorCopilotDao r2, Set<String> r3) {
            LifeLogTextEntityTextVectorCopilotDao r4 = (LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "columnSet");
            return IAppEntityVectorCopilotDao.DefaultImpls.buildColumnGroup((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int deleteAll(LifeLogTextEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbId(LifeLogTextEntityTextVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static void deleteByRawDbIdAndColumns(LifeLogTextEntityTextVectorCopilotDao r2, long r3, Set<String> r5) {
            LifeLogTextEntityTextVectorCopilotDao r4 = (LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static void deleteByRawDbIdAndType(LifeLogTextEntityTextVectorCopilotDao r2, long r3, int r5) {
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndType((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static void deleteByRawDbIdAndTypeColumns(LifeLogTextEntityTextVectorCopilotDao r2, long r3, int r5, Set<String> r6) {
            LifeLogTextEntityTextVectorCopilotDao r4 = (LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndTypeColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5, r7);
        }

        public static int deleteByRawDbIds(LifeLogTextEntityTextVectorCopilotDao r2, List<Long> r3) {
            LifeLogTextEntityTextVectorCopilotDao r4 = (LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static String getTableName(LifeLogTextEntityTextVectorCopilotDao r2) {
            LifeLogTextEntityTextVectorCopilotDao r3 = (LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            return "LifeLogEntityTextVectorCopilot";
        }

        public static boolean isEmpty(LifeLogTextEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.isEmpty((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<cf> queryAll(LifeLogTextEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(LifeLogTextEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAllCount((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static cf queryById(LifeLogTextEntityTextVectorCopilotDao r2, long r3) {
            return (cf) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryById((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), cf.class, "com.obric.memorydata.plugin");
        }

        public static List<cf> queryByIds(LifeLogTextEntityTextVectorCopilotDao r2, List<Long> r3) {
            LifeLogTextEntityTextVectorCopilotDao r4 = (LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<cf> queryByRawDbId(LifeLogTextEntityTextVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<cf> queryByRawDbIdAndColumns(LifeLogTextEntityTextVectorCopilotDao r2, long r3, Set<String> r5) {
            LifeLogTextEntityTextVectorCopilotDao r4 = (LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static List<cf> queryByRawDbIdListAndColumnContent(LifeLogTextEntityTextVectorCopilotDao r2, List<Long> r3, String r4) {
            LifeLogTextEntityTextVectorCopilotDao r5 = (LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "rawDbIds");
            Intrinsics.checkNotNullParameter(r4, "rawDbColumn");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdListAndColumnContent((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static List<cf> queryByRawDbIds(LifeLogTextEntityTextVectorCopilotDao r2, List<Long> r3) {
            LifeLogTextEntityTextVectorCopilotDao r4 = (LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static cf queryByUUID(LifeLogTextEntityTextVectorCopilotDao r2, String r3) {
            LifeLogTextEntityTextVectorCopilotDao r4 = (LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (cf) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryByUUID((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), cf.class, "com.obric.memorydata.plugin");
        }

        public static cf queryOne(LifeLogTextEntityTextVectorCopilotDao r2) {
            return (cf) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryOne((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin")), cf.class, "com.obric.memorydata.plugin");
        }

        public static List<cf> queryWithLimitAndOffset(LifeLogTextEntityTextVectorCopilotDao r2, int r3, int r4) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((LifeLogTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, LifeLogTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
