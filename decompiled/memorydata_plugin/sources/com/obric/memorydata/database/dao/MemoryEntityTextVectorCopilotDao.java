package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.cq;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH'¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryEntityTextVectorCopilotDao;", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "Lcom/obric/memorydata/database/entity/MemoryEntityTextVectorCopilotEntity;", "getTableName", "", "deleteByIds", "", "ids", "", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryEntityTextVectorCopilotDao extends IAppEntityVectorCopilotDao<cq> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String buildColumnGroup(MemoryEntityTextVectorCopilotDao r2, Set<String> r3) {
            MemoryEntityTextVectorCopilotDao r4 = (MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "columnSet");
            return IAppEntityVectorCopilotDao.DefaultImpls.buildColumnGroup((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int deleteAll(MemoryEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbId(MemoryEntityTextVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static void deleteByRawDbIdAndColumns(MemoryEntityTextVectorCopilotDao r2, long r3, Set<String> r5) {
            MemoryEntityTextVectorCopilotDao r4 = (MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static void deleteByRawDbIdAndType(MemoryEntityTextVectorCopilotDao r2, long r3, int r5) {
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndType((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static void deleteByRawDbIdAndTypeColumns(MemoryEntityTextVectorCopilotDao r2, long r3, int r5, Set<String> r6) {
            MemoryEntityTextVectorCopilotDao r4 = (MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndTypeColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5, r7);
        }

        public static int deleteByRawDbIds(MemoryEntityTextVectorCopilotDao r2, List<Long> r3) {
            MemoryEntityTextVectorCopilotDao r4 = (MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static String getTableName(MemoryEntityTextVectorCopilotDao r2) {
            MemoryEntityTextVectorCopilotDao r3 = (MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            return "MemoryEntityTextVectorCopilot";
        }

        public static boolean isEmpty(MemoryEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.isEmpty((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<cq> queryAll(MemoryEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MemoryEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAllCount((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static cq queryById(MemoryEntityTextVectorCopilotDao r2, long r3) {
            return (cq) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryById((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), cq.class, "com.obric.memorydata.plugin");
        }

        public static List<cq> queryByIds(MemoryEntityTextVectorCopilotDao r2, List<Long> r3) {
            MemoryEntityTextVectorCopilotDao r4 = (MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<cq> queryByRawDbId(MemoryEntityTextVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<cq> queryByRawDbIdAndColumns(MemoryEntityTextVectorCopilotDao r2, long r3, Set<String> r5) {
            MemoryEntityTextVectorCopilotDao r4 = (MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static List<cq> queryByRawDbIdListAndColumnContent(MemoryEntityTextVectorCopilotDao r2, List<Long> r3, String r4) {
            MemoryEntityTextVectorCopilotDao r5 = (MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "rawDbIds");
            Intrinsics.checkNotNullParameter(r4, "rawDbColumn");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdListAndColumnContent((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static List<cq> queryByRawDbIds(MemoryEntityTextVectorCopilotDao r2, List<Long> r3) {
            MemoryEntityTextVectorCopilotDao r4 = (MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static cq queryByUUID(MemoryEntityTextVectorCopilotDao r2, String r3) {
            MemoryEntityTextVectorCopilotDao r4 = (MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (cq) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryByUUID((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), cq.class, "com.obric.memorydata.plugin");
        }

        public static cq queryOne(MemoryEntityTextVectorCopilotDao r2) {
            return (cq) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryOne((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin")), cq.class, "com.obric.memorydata.plugin");
        }

        public static List<cq> queryWithLimitAndOffset(MemoryEntityTextVectorCopilotDao r2, int r3, int r4) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MemoryEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int deleteByIds(List<Long> r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
