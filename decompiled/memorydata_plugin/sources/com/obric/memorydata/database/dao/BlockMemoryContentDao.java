package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.BlockMemoryContentEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H'¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/database/dao/BlockMemoryContentDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/BlockMemoryContentEntity;", "getTableName", "", "getAllCountFlow", "Lkotlinx/coroutines/flow/Flow;", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface BlockMemoryContentDao extends BaseDao<BlockMemoryContentEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(BlockMemoryContentDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((BlockMemoryContentDao) ZeusTransformUtils.wrapperContextForParams(r2, BlockMemoryContentDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(BlockMemoryContentDao r2) {
            BlockMemoryContentDao r3 = (BlockMemoryContentDao) ZeusTransformUtils.wrapperContextForParams(r2, BlockMemoryContentDao.class, "com.obric.memorydata.plugin");
            return "BlockMemoryContent";
        }

        public static List<BlockMemoryContentEntity> queryAll(BlockMemoryContentDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((BlockMemoryContentDao) ZeusTransformUtils.wrapperContextForParams(r2, BlockMemoryContentDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(BlockMemoryContentDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((BlockMemoryContentDao) ZeusTransformUtils.wrapperContextForParams(r2, BlockMemoryContentDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static BlockMemoryContentEntity queryById(BlockMemoryContentDao r2, long r3) {
            return (BlockMemoryContentEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((BlockMemoryContentDao) ZeusTransformUtils.wrapperContextForParams(r2, BlockMemoryContentDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), BlockMemoryContentEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<BlockMemoryContentEntity> queryByIds(BlockMemoryContentDao r2, List<Long> r3) {
            BlockMemoryContentDao r4 = (BlockMemoryContentDao) ZeusTransformUtils.wrapperContextForParams(r2, BlockMemoryContentDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static BlockMemoryContentEntity queryByUUID(BlockMemoryContentDao r2, String r3) {
            BlockMemoryContentDao r4 = (BlockMemoryContentDao) ZeusTransformUtils.wrapperContextForParams(r2, BlockMemoryContentDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (BlockMemoryContentEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), BlockMemoryContentEntity.class, "com.obric.memorydata.plugin");
        }

        public static BlockMemoryContentEntity queryOne(BlockMemoryContentDao r2) {
            return (BlockMemoryContentEntity) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((BlockMemoryContentDao) ZeusTransformUtils.wrapperContextForParams(r2, BlockMemoryContentDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), BlockMemoryContentEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<BlockMemoryContentEntity> queryWithLimitAndOffset(BlockMemoryContentDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((BlockMemoryContentDao) ZeusTransformUtils.wrapperContextForParams(r2, BlockMemoryContentDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    i<Integer> getAllCountFlow();

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();
}
