package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.jf;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/UserProfileTextEntityTextVectorCopilotDao;", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "Lcom/obric/memorydata/database/entity/UserProfileEntityTextVectorCopilotEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UserProfileTextEntityTextVectorCopilotDao extends IAppEntityVectorCopilotDao<jf> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String buildColumnGroup(UserProfileTextEntityTextVectorCopilotDao r2, Set<String> r3) {
            UserProfileTextEntityTextVectorCopilotDao r4 = (UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "columnSet");
            return IAppEntityVectorCopilotDao.DefaultImpls.buildColumnGroup((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int deleteAll(UserProfileTextEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbId(UserProfileTextEntityTextVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static void deleteByRawDbIdAndColumns(UserProfileTextEntityTextVectorCopilotDao r2, long r3, Set<String> r5) {
            UserProfileTextEntityTextVectorCopilotDao r4 = (UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static void deleteByRawDbIdAndType(UserProfileTextEntityTextVectorCopilotDao r2, long r3, int r5) {
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndType((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static void deleteByRawDbIdAndTypeColumns(UserProfileTextEntityTextVectorCopilotDao r2, long r3, int r5, Set<String> r6) {
            UserProfileTextEntityTextVectorCopilotDao r4 = (UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndTypeColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5, r7);
        }

        public static int deleteByRawDbIds(UserProfileTextEntityTextVectorCopilotDao r2, List<Long> r3) {
            UserProfileTextEntityTextVectorCopilotDao r4 = (UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static String getTableName(UserProfileTextEntityTextVectorCopilotDao r2) {
            UserProfileTextEntityTextVectorCopilotDao r3 = (UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            return "UserProfileEntityTextVectorCopilot";
        }

        public static boolean isEmpty(UserProfileTextEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.isEmpty((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<jf> queryAll(UserProfileTextEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(UserProfileTextEntityTextVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAllCount((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static jf queryById(UserProfileTextEntityTextVectorCopilotDao r2, long r3) {
            return (jf) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryById((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), jf.class, "com.obric.memorydata.plugin");
        }

        public static List<jf> queryByIds(UserProfileTextEntityTextVectorCopilotDao r2, List<Long> r3) {
            UserProfileTextEntityTextVectorCopilotDao r4 = (UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<jf> queryByRawDbId(UserProfileTextEntityTextVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<jf> queryByRawDbIdAndColumns(UserProfileTextEntityTextVectorCopilotDao r2, long r3, Set<String> r5) {
            UserProfileTextEntityTextVectorCopilotDao r4 = (UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static List<jf> queryByRawDbIdListAndColumnContent(UserProfileTextEntityTextVectorCopilotDao r2, List<Long> r3, String r4) {
            UserProfileTextEntityTextVectorCopilotDao r5 = (UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "rawDbIds");
            Intrinsics.checkNotNullParameter(r4, "rawDbColumn");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdListAndColumnContent((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static List<jf> queryByRawDbIds(UserProfileTextEntityTextVectorCopilotDao r2, List<Long> r3) {
            UserProfileTextEntityTextVectorCopilotDao r4 = (UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static jf queryByUUID(UserProfileTextEntityTextVectorCopilotDao r2, String r3) {
            UserProfileTextEntityTextVectorCopilotDao r4 = (UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (jf) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryByUUID((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), jf.class, "com.obric.memorydata.plugin");
        }

        public static jf queryOne(UserProfileTextEntityTextVectorCopilotDao r2) {
            return (jf) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryOne((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin")), jf.class, "com.obric.memorydata.plugin");
        }

        public static List<jf> queryWithLimitAndOffset(UserProfileTextEntityTextVectorCopilotDao r2, int r3, int r4) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((UserProfileTextEntityTextVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, UserProfileTextEntityTextVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
