package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/dao/ICSProtocolHistoryEntityDao;", "Lcom/obric/memorydata/database/dao/IHistoryEntityDao;", "Lcom/obric/memorydata/database/dao/ICSProtocolHistoryEntity;", "getTableName", "", "getPrefix", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ICSProtocolHistoryEntityDao extends IHistoryEntityDao<ICSProtocolHistoryEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(ICSProtocolHistoryEntityDao r2) {
            return IHistoryEntityDao.DefaultImpls.deleteAll((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByEntityId(ICSProtocolHistoryEntityDao r2, String r3, String r4) {
            ICSProtocolHistoryEntityDao r5 = (ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityId((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int deleteByEntityIdList(ICSProtocolHistoryEntityDao r2, List<String> r3, String r4) {
            ICSProtocolHistoryEntityDao r5 = (ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityIdList((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static int deleteByEntityIdListAndPackageName(ICSProtocolHistoryEntityDao r2, List<String> r3, String r4) {
            ICSProtocolHistoryEntityDao r5 = (ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityIdListAndPackageName((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static int deleteById(ICSProtocolHistoryEntityDao r2, long r3) {
            return IHistoryEntityDao.DefaultImpls.deleteById((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static String getPrefix(ICSProtocolHistoryEntityDao r2) {
            ICSProtocolHistoryEntityDao r3 = (ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin");
            return ICSProtocolHistoryEntity.PREFIX_TAG;
        }

        public static String getTableName(ICSProtocolHistoryEntityDao r2) {
            ICSProtocolHistoryEntityDao r3 = (ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin");
            return "RawICSProtocolHistoryEntity";
        }

        public static List<ICSProtocolHistoryEntity> queryAll(ICSProtocolHistoryEntityDao r2) {
            return IHistoryEntityDao.DefaultImpls.queryAll((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(ICSProtocolHistoryEntityDao r2) {
            return IHistoryEntityDao.DefaultImpls.queryAllCount((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<ICSProtocolHistoryEntity> queryByEntityId(ICSProtocolHistoryEntityDao r2, String r3, String r4) {
            ICSProtocolHistoryEntityDao r5 = (ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.queryByEntityId((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<ICSProtocolHistoryEntity> queryByEntityIdListAndPackageName(ICSProtocolHistoryEntityDao r2, List<String> r3, String r4) {
            ICSProtocolHistoryEntityDao r5 = (ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.queryByEntityIdListAndPackageName((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static ICSProtocolHistoryEntity queryById(ICSProtocolHistoryEntityDao r2, long r3) {
            return (ICSProtocolHistoryEntity) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryById((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3), ICSProtocolHistoryEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<ICSProtocolHistoryEntity> queryByIds(ICSProtocolHistoryEntityDao r2, List<Long> r3) {
            ICSProtocolHistoryEntityDao r4 = (ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IHistoryEntityDao.DefaultImpls.queryByIds((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ICSProtocolHistoryEntity queryByUUID(ICSProtocolHistoryEntityDao r2, String r3) {
            ICSProtocolHistoryEntityDao r4 = (ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ICSProtocolHistoryEntity) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryByUUID((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3), ICSProtocolHistoryEntity.class, "com.obric.memorydata.plugin");
        }

        public static ICSProtocolHistoryEntity queryOne(ICSProtocolHistoryEntityDao r2) {
            return (ICSProtocolHistoryEntity) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryOne((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin")), ICSProtocolHistoryEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<ICSProtocolHistoryEntity> queryWithLimitAndOffset(ICSProtocolHistoryEntityDao r2, int r3, int r4) {
            return IHistoryEntityDao.DefaultImpls.queryWithLimitAndOffset((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((ICSProtocolHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, ICSProtocolHistoryEntityDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    String getPrefix();

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
