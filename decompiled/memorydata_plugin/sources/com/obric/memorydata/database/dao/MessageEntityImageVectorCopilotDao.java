package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.dj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/dao/MessageEntityImageVectorCopilotDao;", "Lcom/obric/memorydata/database/dao/IAppEntityVectorCopilotDao;", "Lcom/obric/memorydata/database/entity/MessageEntityImageVectorCopilotEntity;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MessageEntityImageVectorCopilotDao extends IAppEntityVectorCopilotDao<dj> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String buildColumnGroup(MessageEntityImageVectorCopilotDao r2, Set<String> r3) {
            MessageEntityImageVectorCopilotDao r4 = (MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "columnSet");
            return IAppEntityVectorCopilotDao.DefaultImpls.buildColumnGroup((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int deleteAll(MessageEntityImageVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbId(MessageEntityImageVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static void deleteByRawDbIdAndColumns(MessageEntityImageVectorCopilotDao r2, long r3, Set<String> r5) {
            MessageEntityImageVectorCopilotDao r4 = (MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static void deleteByRawDbIdAndType(MessageEntityImageVectorCopilotDao r2, long r3, int r5) {
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndType((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static void deleteByRawDbIdAndTypeColumns(MessageEntityImageVectorCopilotDao r2, long r3, int r5, Set<String> r6) {
            MessageEntityImageVectorCopilotDao r4 = (MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
            IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndTypeColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r5, r7);
        }

        public static int deleteByRawDbIds(MessageEntityImageVectorCopilotDao r2, List<Long> r3) {
            MessageEntityImageVectorCopilotDao r4 = (MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.deleteByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static String getTableName(MessageEntityImageVectorCopilotDao r2) {
            MessageEntityImageVectorCopilotDao r3 = (MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            return "MessageEntityImageVectorCopilot";
        }

        public static boolean isEmpty(MessageEntityImageVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.isEmpty((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<dj> queryAll(MessageEntityImageVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAll((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MessageEntityImageVectorCopilotDao r2) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryAllCount((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"));
        }

        public static dj queryById(MessageEntityImageVectorCopilotDao r2, long r3) {
            return (dj) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryById((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), dj.class, "com.obric.memorydata.plugin");
        }

        public static List<dj> queryByIds(MessageEntityImageVectorCopilotDao r2, List<Long> r3) {
            MessageEntityImageVectorCopilotDao r4 = (MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<dj> queryByRawDbId(MessageEntityImageVectorCopilotDao r2, long r3) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbId((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<dj> queryByRawDbIdAndColumns(MessageEntityImageVectorCopilotDao r2, long r3, Set<String> r5) {
            MessageEntityImageVectorCopilotDao r4 = (MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdAndColumns((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r6);
        }

        public static List<dj> queryByRawDbIdListAndColumnContent(MessageEntityImageVectorCopilotDao r2, List<Long> r3, String r4) {
            MessageEntityImageVectorCopilotDao r5 = (MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "rawDbIds");
            Intrinsics.checkNotNullParameter(r4, "rawDbColumn");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIdListAndColumnContent((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static List<dj> queryByRawDbIds(MessageEntityImageVectorCopilotDao r2, List<Long> r3) {
            MessageEntityImageVectorCopilotDao r4 = (MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityVectorCopilotDao.DefaultImpls.queryByRawDbIds((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static dj queryByUUID(MessageEntityImageVectorCopilotDao r2, String r3) {
            MessageEntityImageVectorCopilotDao r4 = (MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (dj) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryByUUID((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3), dj.class, "com.obric.memorydata.plugin");
        }

        public static dj queryOne(MessageEntityImageVectorCopilotDao r2) {
            return (dj) ZeusTransformUtils.preCheckCast(IAppEntityVectorCopilotDao.DefaultImpls.queryOne((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin")), dj.class, "com.obric.memorydata.plugin");
        }

        public static List<dj> queryWithLimitAndOffset(MessageEntityImageVectorCopilotDao r2, int r3, int r4) {
            return IAppEntityVectorCopilotDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityVectorCopilotDao) ZeusTransformUtils.preCheckCast((MessageEntityImageVectorCopilotDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageEntityImageVectorCopilotDao.class, "com.obric.memorydata.plugin"), IAppEntityVectorCopilotDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
