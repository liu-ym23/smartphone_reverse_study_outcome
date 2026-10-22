package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.av;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bJ\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/dao/DataBuildMemoryStatusDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/DataBuildMemoryStatusEntity;", "getTableName", "", "updateStatus", "", OaidModel.KEY_ID, "", "buildStatus", "", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DataBuildMemoryStatusDao extends BaseDao<av> {
    public static final Companion Companion = null;
    public static final String TAG = "DataBuildMemoryStatusDao";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/dao/DataBuildMemoryStatusDao$Companion;", "", "<init>", "()V", "TAG", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String TAG = "DataBuildMemoryStatusDao";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(DataBuildMemoryStatusDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((DataBuildMemoryStatusDao) ZeusTransformUtils.wrapperContextForParams(r2, DataBuildMemoryStatusDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(DataBuildMemoryStatusDao r2) {
            DataBuildMemoryStatusDao r3 = (DataBuildMemoryStatusDao) ZeusTransformUtils.wrapperContextForParams(r2, DataBuildMemoryStatusDao.class, "com.obric.memorydata.plugin");
            return "DataBuildMemoryStatus";
        }

        public static List<av> queryAll(DataBuildMemoryStatusDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((DataBuildMemoryStatusDao) ZeusTransformUtils.wrapperContextForParams(r2, DataBuildMemoryStatusDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(DataBuildMemoryStatusDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((DataBuildMemoryStatusDao) ZeusTransformUtils.wrapperContextForParams(r2, DataBuildMemoryStatusDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static av queryById(DataBuildMemoryStatusDao r2, long r3) {
            return (av) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((DataBuildMemoryStatusDao) ZeusTransformUtils.wrapperContextForParams(r2, DataBuildMemoryStatusDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), av.class, "com.obric.memorydata.plugin");
        }

        public static List<av> queryByIds(DataBuildMemoryStatusDao r2, List<Long> r3) {
            DataBuildMemoryStatusDao r4 = (DataBuildMemoryStatusDao) ZeusTransformUtils.wrapperContextForParams(r2, DataBuildMemoryStatusDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static av queryByUUID(DataBuildMemoryStatusDao r2, String r3) {
            DataBuildMemoryStatusDao r4 = (DataBuildMemoryStatusDao) ZeusTransformUtils.wrapperContextForParams(r2, DataBuildMemoryStatusDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (av) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), av.class, "com.obric.memorydata.plugin");
        }

        public static av queryOne(DataBuildMemoryStatusDao r2) {
            return (av) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((DataBuildMemoryStatusDao) ZeusTransformUtils.wrapperContextForParams(r2, DataBuildMemoryStatusDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), av.class, "com.obric.memorydata.plugin");
        }

        public static List<av> queryWithLimitAndOffset(DataBuildMemoryStatusDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((DataBuildMemoryStatusDao) ZeusTransformUtils.wrapperContextForParams(r2, DataBuildMemoryStatusDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    void updateStatus(long r1, int r3);
}
