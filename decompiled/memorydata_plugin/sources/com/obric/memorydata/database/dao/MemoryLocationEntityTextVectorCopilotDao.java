package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.cs;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryLocationEntityTextVectorCopilotDao;", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "Lcom/obric/memorydata/database/entity/MemoryLocationEntityTextVectorCopilotEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryLocationEntityTextVectorCopilotDao extends IAppEntityVectorCopilotDao<cs> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String buildColumnGroup(MemoryLocationEntityTextVectorCopilotDao r2, Set<String> r3) {
            MemoryLocationEntityTextVectorCopilotDao r4 = (MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "columnSet");
            return IAppEntityVectorCopilotDao.DefaultImpls.buildColumnGroup((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int deleteAll(MemoryLocationEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbId(MemoryLocationEntityTextVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static void deleteByRawDbIdAndColumns(MemoryLocationEntityTextVectorCopilotDao r2, long r3, Set<String> r5) {
            MemoryLocationEntityTextVectorCopilotDao r4 = (MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static void deleteByRawDbIdAndType(MemoryLocationEntityTextVectorCopilotDao r2, long r3, int r5) {
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndType((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static void deleteByRawDbIdAndTypeColumns(MemoryLocationEntityTextVectorCopilotDao r2, long r3, int r5, Set<String> r6) {
            MemoryLocationEntityTextVectorCopilotDao r4 = (MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndTypeColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5, r7);
        }

        public static int deleteByRawDbIds(MemoryLocationEntityTextVectorCopilotDao r2, List<Long> r3) {
            MemoryLocationEntityTextVectorCopilotDao r4 = (MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static String getTableName(MemoryLocationEntityTextVectorCopilotDao r2) {
            MemoryLocationEntityTextVectorCopilotDao r3 = (MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            return "MemoryLocationEntityTextVectorCopilot";
        }

        public static boolean isEmpty(MemoryLocationEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.isEmpty((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<cs> queryAll(MemoryLocationEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MemoryLocationEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAllCount((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static cs queryById(MemoryLocationEntityTextVectorCopilotDao r2, long r3) {
            return (cs) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryById((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), cs.class, "com.obric.memorydata.plugin");
        }

        public static List<cs> queryByIds(MemoryLocationEntityTextVectorCopilotDao r2, List<Long> r3) {
            MemoryLocationEntityTextVectorCopilotDao r4 = (MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<cs> queryByRawDbId(MemoryLocationEntityTextVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<cs> queryByRawDbIdAndColumns(MemoryLocationEntityTextVectorCopilotDao r2, long r3, Set<String> r5) {
            MemoryLocationEntityTextVectorCopilotDao r4 = (MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static List<cs> queryByRawDbIdListAndColumnContent(MemoryLocationEntityTextVectorCopilotDao r2, List<Long> r3, String r4) {
            MemoryLocationEntityTextVectorCopilotDao r5 = (MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "rawDbIds");
            Intrinsics.checkNotNullParameter(r4, "rawDbColumn");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdListAndColumnContent((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static List<cs> queryByRawDbIds(MemoryLocationEntityTextVectorCopilotDao r2, List<Long> r3) {
            MemoryLocationEntityTextVectorCopilotDao r4 = (MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static cs queryByUUID(MemoryLocationEntityTextVectorCopilotDao r2, String r3) {
            MemoryLocationEntityTextVectorCopilotDao r4 = (MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (cs) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryByUUID((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), cs.class, "com.obric.memorydata.plugin");
        }

        public static cs queryOne(MemoryLocationEntityTextVectorCopilotDao r2) {
            return (cs) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryOne((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin")), cs.class, "com.obric.memorydata.plugin");
        }

        public static List<cs> queryWithLimitAndOffset(MemoryLocationEntityTextVectorCopilotDao r2, int r3, int r4) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryLocationEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryLocationEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
