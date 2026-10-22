package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.gl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/dao/RawMemoryHistoryRawDbDao;", "Lcom/obric/memorydata/database/dao/IHistoryEntityDao;", "Lcom/obric/memorydata/database/entity/RawMemoryHistoryEntity;", "getTableName", "", "getPrefix", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface RawMemoryHistoryRawDbDao extends IHistoryEntityDao<gl> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(RawMemoryHistoryRawDbDao r2) {
            return IHistoryEntityDao.DefaultImpls.deleteAll((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByEntityId(RawMemoryHistoryRawDbDao r2, String r3, String r4) {
            RawMemoryHistoryRawDbDao r5 = (RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityId((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int deleteByEntityIdList(RawMemoryHistoryRawDbDao r2, List<String> r3, String r4) {
            RawMemoryHistoryRawDbDao r5 = (RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityIdList((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static int deleteByEntityIdListAndPackageName(RawMemoryHistoryRawDbDao r2, List<String> r3, String r4) {
            RawMemoryHistoryRawDbDao r5 = (RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityIdListAndPackageName((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static int deleteById(RawMemoryHistoryRawDbDao r2, long r3) {
            return IHistoryEntityDao.DefaultImpls.deleteById((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static String getPrefix(RawMemoryHistoryRawDbDao r2) {
            RawMemoryHistoryRawDbDao r3 = (RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            return "memory_";
        }

        public static String getTableName(RawMemoryHistoryRawDbDao r2) {
            RawMemoryHistoryRawDbDao r3 = (RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawMemoryHistoryEntity";
        }

        public static List<gl> queryAll(RawMemoryHistoryRawDbDao r2) {
            return IHistoryEntityDao.DefaultImpls.queryAll((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(RawMemoryHistoryRawDbDao r2) {
            return IHistoryEntityDao.DefaultImpls.queryAllCount((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<gl> queryByEntityId(RawMemoryHistoryRawDbDao r2, String r3, String r4) {
            RawMemoryHistoryRawDbDao r5 = (RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.queryByEntityId((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<gl> queryByEntityIdListAndPackageName(RawMemoryHistoryRawDbDao r2, List<String> r3, String r4) {
            RawMemoryHistoryRawDbDao r5 = (RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.queryByEntityIdListAndPackageName((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static gl queryById(RawMemoryHistoryRawDbDao r2, long r3) {
            return (gl) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryById((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3), gl.class, "com.obric.memorydata.plugin");
        }

        public static List<gl> queryByIds(RawMemoryHistoryRawDbDao r2, List<Long> r3) {
            RawMemoryHistoryRawDbDao r4 = (RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IHistoryEntityDao.DefaultImpls.queryByIds((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static gl queryByUUID(RawMemoryHistoryRawDbDao r2, String r3) {
            RawMemoryHistoryRawDbDao r4 = (RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (gl) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryByUUID((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3), gl.class, "com.obric.memorydata.plugin");
        }

        public static gl queryOne(RawMemoryHistoryRawDbDao r2) {
            return (gl) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryOne((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin")), gl.class, "com.obric.memorydata.plugin");
        }

        public static List<gl> queryWithLimitAndOffset(RawMemoryHistoryRawDbDao r2, int r3, int r4) {
            return IHistoryEntityDao.DefaultImpls.queryWithLimitAndOffset((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((RawMemoryHistoryRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, RawMemoryHistoryRawDbDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    String getPrefix();

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
