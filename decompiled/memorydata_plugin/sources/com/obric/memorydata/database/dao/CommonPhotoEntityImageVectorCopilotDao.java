package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.am;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/CommonPhotoEntityImageVectorCopilotDao;", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "Lcom/obric/memorydata/database/entity/CommonPhotoEntityImageVectorCopilotEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface CommonPhotoEntityImageVectorCopilotDao extends IAppEntityVectorCopilotDao<am> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String buildColumnGroup(CommonPhotoEntityImageVectorCopilotDao r2, Set<String> r3) {
            CommonPhotoEntityImageVectorCopilotDao r4 = (CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "columnSet");
            return IAppEntityVectorCopilotDao.DefaultImpls.buildColumnGroup((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int deleteAll(CommonPhotoEntityImageVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbId(CommonPhotoEntityImageVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static void deleteByRawDbIdAndColumns(CommonPhotoEntityImageVectorCopilotDao r2, long r3, Set<String> r5) {
            CommonPhotoEntityImageVectorCopilotDao r4 = (CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static void deleteByRawDbIdAndType(CommonPhotoEntityImageVectorCopilotDao r2, long r3, int r5) {
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndType((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static void deleteByRawDbIdAndTypeColumns(CommonPhotoEntityImageVectorCopilotDao r2, long r3, int r5, Set<String> r6) {
            CommonPhotoEntityImageVectorCopilotDao r4 = (CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndTypeColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5, r7);
        }

        public static int deleteByRawDbIds(CommonPhotoEntityImageVectorCopilotDao r2, List<Long> r3) {
            CommonPhotoEntityImageVectorCopilotDao r4 = (CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static String getTableName(CommonPhotoEntityImageVectorCopilotDao r2) {
            CommonPhotoEntityImageVectorCopilotDao r3 = (CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            return "CommonPhotoEntityImageVectorCopilot";
        }

        public static boolean isEmpty(CommonPhotoEntityImageVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.isEmpty((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<am> queryAll(CommonPhotoEntityImageVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(CommonPhotoEntityImageVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAllCount((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static am queryById(CommonPhotoEntityImageVectorCopilotDao r2, long r3) {
            return (am) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryById((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), am.class, "com.obric.memorydata.plugin");
        }

        public static List<am> queryByIds(CommonPhotoEntityImageVectorCopilotDao r2, List<Long> r3) {
            CommonPhotoEntityImageVectorCopilotDao r4 = (CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<am> queryByRawDbId(CommonPhotoEntityImageVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<am> queryByRawDbIdAndColumns(CommonPhotoEntityImageVectorCopilotDao r2, long r3, Set<String> r5) {
            CommonPhotoEntityImageVectorCopilotDao r4 = (CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static List<am> queryByRawDbIdListAndColumnContent(CommonPhotoEntityImageVectorCopilotDao r2, List<Long> r3, String r4) {
            CommonPhotoEntityImageVectorCopilotDao r5 = (CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "rawDbIds");
            Intrinsics.checkNotNullParameter(r4, "rawDbColumn");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdListAndColumnContent((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static List<am> queryByRawDbIds(CommonPhotoEntityImageVectorCopilotDao r2, List<Long> r3) {
            CommonPhotoEntityImageVectorCopilotDao r4 = (CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static am queryByUUID(CommonPhotoEntityImageVectorCopilotDao r2, String r3) {
            CommonPhotoEntityImageVectorCopilotDao r4 = (CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (am) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryByUUID((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), am.class, "com.obric.memorydata.plugin");
        }

        public static am queryOne(CommonPhotoEntityImageVectorCopilotDao r2) {
            return (am) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryOne((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin")), am.class, "com.obric.memorydata.plugin");
        }

        public static List<am> queryWithLimitAndOffset(CommonPhotoEntityImageVectorCopilotDao r2, int r3, int r4) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((CommonPhotoEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, CommonPhotoEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
