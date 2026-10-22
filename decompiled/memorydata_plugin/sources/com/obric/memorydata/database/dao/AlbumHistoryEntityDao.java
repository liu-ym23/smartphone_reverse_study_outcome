package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.fh;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/dao/AlbumHistoryEntityDao;", "Lcom/obric/memorydata/database/dao/IHistoryEntityDao;", "Lcom/obric/memorydata/database/entity/RawAlbumHistoryEntity;", "getTableName", "", "getPrefix", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AlbumHistoryEntityDao extends IHistoryEntityDao<fh> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(AlbumHistoryEntityDao r2) {
            return IHistoryEntityDao.DefaultImpls.deleteAll((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByEntityId(AlbumHistoryEntityDao r2, String r3, String r4) {
            AlbumHistoryEntityDao r5 = (AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityId((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int deleteByEntityIdList(AlbumHistoryEntityDao r2, List<String> r3, String r4) {
            AlbumHistoryEntityDao r5 = (AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityIdList((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static int deleteByEntityIdListAndPackageName(AlbumHistoryEntityDao r2, List<String> r3, String r4) {
            AlbumHistoryEntityDao r5 = (AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityIdListAndPackageName((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static int deleteById(AlbumHistoryEntityDao r2, long r3) {
            return IHistoryEntityDao.DefaultImpls.deleteById((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static String getPrefix(AlbumHistoryEntityDao r2) {
            AlbumHistoryEntityDao r3 = (AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin");
            return "album_";
        }

        public static String getTableName(AlbumHistoryEntityDao r2) {
            AlbumHistoryEntityDao r3 = (AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin");
            return "RawAlbumHistoryEntity";
        }

        public static List<fh> queryAll(AlbumHistoryEntityDao r2) {
            return IHistoryEntityDao.DefaultImpls.queryAll((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(AlbumHistoryEntityDao r2) {
            return IHistoryEntityDao.DefaultImpls.queryAllCount((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<fh> queryByEntityId(AlbumHistoryEntityDao r2, String r3, String r4) {
            AlbumHistoryEntityDao r5 = (AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.queryByEntityId((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<fh> queryByEntityIdListAndPackageName(AlbumHistoryEntityDao r2, List<String> r3, String r4) {
            AlbumHistoryEntityDao r5 = (AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.queryByEntityIdListAndPackageName((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static fh queryById(AlbumHistoryEntityDao r2, long r3) {
            return (fh) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryById((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3), fh.class, "com.obric.memorydata.plugin");
        }

        public static List<fh> queryByIds(AlbumHistoryEntityDao r2, List<Long> r3) {
            AlbumHistoryEntityDao r4 = (AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IHistoryEntityDao.DefaultImpls.queryByIds((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static fh queryByUUID(AlbumHistoryEntityDao r2, String r3) {
            AlbumHistoryEntityDao r4 = (AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (fh) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryByUUID((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3), fh.class, "com.obric.memorydata.plugin");
        }

        public static fh queryOne(AlbumHistoryEntityDao r2) {
            return (fh) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryOne((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin")), fh.class, "com.obric.memorydata.plugin");
        }

        public static List<fh> queryWithLimitAndOffset(AlbumHistoryEntityDao r2, int r3, int r4) {
            return IHistoryEntityDao.DefaultImpls.queryWithLimitAndOffset((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((AlbumHistoryEntityDao) ZeusTransformUtils.wrapperContextForParams(r2, AlbumHistoryEntityDao.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    String getPrefix();

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
