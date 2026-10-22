package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.bn;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH'¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/database/dao/EpisodicMemoryTextVectorCopilotDao;", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "Lcom/obric/memorydata/database/entity/EpisodicMemoryTextVectorCopilotEntity;", "getTableName", "", "deleteById", "", OaidModel.KEY_ID, "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface EpisodicMemoryTextVectorCopilotDao extends IAppEntityVectorCopilotDao<bn> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String buildColumnGroup(EpisodicMemoryTextVectorCopilotDao r2, Set<String> r3) {
            EpisodicMemoryTextVectorCopilotDao r4 = (EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "columnSet");
            return IAppEntityVectorCopilotDao.DefaultImpls.buildColumnGroup((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int deleteAll(EpisodicMemoryTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbId(EpisodicMemoryTextVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static void deleteByRawDbIdAndColumns(EpisodicMemoryTextVectorCopilotDao r2, long r3, Set<String> r5) {
            EpisodicMemoryTextVectorCopilotDao r4 = (EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static void deleteByRawDbIdAndType(EpisodicMemoryTextVectorCopilotDao r2, long r3, int r5) {
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndType((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static void deleteByRawDbIdAndTypeColumns(EpisodicMemoryTextVectorCopilotDao r2, long r3, int r5, Set<String> r6) {
            EpisodicMemoryTextVectorCopilotDao r4 = (EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndTypeColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5, r7);
        }

        public static int deleteByRawDbIds(EpisodicMemoryTextVectorCopilotDao r2, List<Long> r3) {
            EpisodicMemoryTextVectorCopilotDao r4 = (EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static String getTableName(EpisodicMemoryTextVectorCopilotDao r2) {
            EpisodicMemoryTextVectorCopilotDao r3 = (EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            return "ShortMemoryTextVectorCopilot";
        }

        public static boolean isEmpty(EpisodicMemoryTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.isEmpty((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<bn> queryAll(EpisodicMemoryTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(EpisodicMemoryTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAllCount((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static bn queryById(EpisodicMemoryTextVectorCopilotDao r2, long r3) {
            return (bn) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryById((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), bn.class, "com.obric.memorydata.plugin");
        }

        public static List<bn> queryByIds(EpisodicMemoryTextVectorCopilotDao r2, List<Long> r3) {
            EpisodicMemoryTextVectorCopilotDao r4 = (EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<bn> queryByRawDbId(EpisodicMemoryTextVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<bn> queryByRawDbIdAndColumns(EpisodicMemoryTextVectorCopilotDao r2, long r3, Set<String> r5) {
            EpisodicMemoryTextVectorCopilotDao r4 = (EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static List<bn> queryByRawDbIdListAndColumnContent(EpisodicMemoryTextVectorCopilotDao r2, List<Long> r3, String r4) {
            EpisodicMemoryTextVectorCopilotDao r5 = (EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "rawDbIds");
            Intrinsics.checkNotNullParameter(r4, "rawDbColumn");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdListAndColumnContent((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static List<bn> queryByRawDbIds(EpisodicMemoryTextVectorCopilotDao r2, List<Long> r3) {
            EpisodicMemoryTextVectorCopilotDao r4 = (EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static bn queryByUUID(EpisodicMemoryTextVectorCopilotDao r2, String r3) {
            EpisodicMemoryTextVectorCopilotDao r4 = (EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (bn) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryByUUID((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), bn.class, "com.obric.memorydata.plugin");
        }

        public static bn queryOne(EpisodicMemoryTextVectorCopilotDao r2) {
            return (bn) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryOne((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin")), bn.class, "com.obric.memorydata.plugin");
        }

        public static List<bn> queryWithLimitAndOffset(EpisodicMemoryTextVectorCopilotDao r2, int r3, int r4) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((EpisodicMemoryTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, EpisodicMemoryTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int deleteById(long r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
