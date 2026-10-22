package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/dao/MessageHistoryRawDbDao;", "Lcom/obric/memorydata/database/dao/IHistoryEntityDao;", "Lcom/obric/memorydata/database/dao/MessageHistoryEntity;", "getTableName", "", "getPrefix", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MessageHistoryRawDbDao extends IHistoryEntityDao<MessageHistoryEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(MessageHistoryRawDbDao r2) {
            return IHistoryEntityDao.DefaultImpls.deleteAll((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByEntityId(MessageHistoryRawDbDao r2, String r3, String r4) {
            MessageHistoryRawDbDao r5 = (MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityId((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int deleteByEntityIdList(MessageHistoryRawDbDao r2, List<String> r3, String r4) {
            MessageHistoryRawDbDao r5 = (MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityIdList((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static int deleteByEntityIdListAndPackageName(MessageHistoryRawDbDao r2, List<String> r3, String r4) {
            MessageHistoryRawDbDao r5 = (MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityIdListAndPackageName((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static int deleteById(MessageHistoryRawDbDao r2, long r3) {
            return IHistoryEntityDao.DefaultImpls.deleteById((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static String getPrefix(MessageHistoryRawDbDao r2) {
            MessageHistoryRawDbDao r3 = (MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            return MessageHistoryEntity.PREFIX_TAG;
        }

        public static String getTableName(MessageHistoryRawDbDao r2) {
            MessageHistoryRawDbDao r3 = (MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawMessageHistoryEntity";
        }

        public static List<MessageHistoryEntity> queryAll(MessageHistoryRawDbDao r2) {
            return IHistoryEntityDao.DefaultImpls.queryAll((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MessageHistoryRawDbDao r2) {
            return IHistoryEntityDao.DefaultImpls.queryAllCount((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<MessageHistoryEntity> queryByEntityId(MessageHistoryRawDbDao r2, String r3, String r4) {
            MessageHistoryRawDbDao r5 = (MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.queryByEntityId((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<MessageHistoryEntity> queryByEntityIdListAndPackageName(MessageHistoryRawDbDao r2, List<String> r3, String r4) {
            MessageHistoryRawDbDao r5 = (MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.queryByEntityIdListAndPackageName((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static MessageHistoryEntity queryById(MessageHistoryRawDbDao r2, long r3) {
            return (MessageHistoryEntity) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryById((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3), MessageHistoryEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<MessageHistoryEntity> queryByIds(MessageHistoryRawDbDao r2, List<Long> r3) {
            MessageHistoryRawDbDao r4 = (MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IHistoryEntityDao.DefaultImpls.queryByIds((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static MessageHistoryEntity queryByUUID(MessageHistoryRawDbDao r2, String r3) {
            MessageHistoryRawDbDao r4 = (MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (MessageHistoryEntity) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryByUUID((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3), MessageHistoryEntity.class, "com.obric.memorydata.plugin");
        }

        public static MessageHistoryEntity queryOne(MessageHistoryRawDbDao r2) {
            return (MessageHistoryEntity) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryOne((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin")), MessageHistoryEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<MessageHistoryEntity> queryWithLimitAndOffset(MessageHistoryRawDbDao r2, int r3, int r4) {
            return IHistoryEntityDao.DefaultImpls.queryWithLimitAndOffset((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((MessageHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, MessageHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    String getPrefix();

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
