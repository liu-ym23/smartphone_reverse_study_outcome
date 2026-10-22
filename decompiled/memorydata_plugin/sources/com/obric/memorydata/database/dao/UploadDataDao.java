package com.obric.memorydata.database.dao;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.ja;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/database/dao/UploadDataDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/UploadDataEntity;", "getTableName", "", "queryNeedUploadOrUploading", "", "limit", "", TypedValues.CycleType.S_WAVE_OFFSET, "queryNeedUploadByPackageName", ObricMemoryConstants.KEY_PACKAGE_NAME, "updateAsUploaded", "", OaidModel.KEY_ID, "", "updateAsUploading", "updateAsNeedUpload", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface UploadDataDao extends BaseDao<ja> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(UploadDataDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((UploadDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UploadDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(UploadDataDao r2) {
            UploadDataDao r3 = (UploadDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UploadDataDao.class, "com.obric.memorydata.plugin");
            return "UploadData";
        }

        public static List<ja> queryAll(UploadDataDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((UploadDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UploadDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(UploadDataDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((UploadDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UploadDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static ja queryById(UploadDataDao r2, long r3) {
            return (ja) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((UploadDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UploadDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), ja.class, "com.obric.memorydata.plugin");
        }

        public static List<ja> queryByIds(UploadDataDao r2, List<Long> r3) {
            UploadDataDao r4 = (UploadDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UploadDataDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static ja queryByUUID(UploadDataDao r2, String r3) {
            UploadDataDao r4 = (UploadDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UploadDataDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ja) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), ja.class, "com.obric.memorydata.plugin");
        }

        public static ja queryOne(UploadDataDao r2) {
            return (ja) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((UploadDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UploadDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), ja.class, "com.obric.memorydata.plugin");
        }

        public static List<ja> queryWithLimitAndOffset(UploadDataDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((UploadDataDao) ZeusTransformUtils.wrapperContextForParams(r2, UploadDataDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<ja> queryNeedUploadByPackageName(String r1, int r2, int r3);

    List<ja> queryNeedUploadOrUploading(int r1, int r2);

    void updateAsNeedUpload(long r1);

    void updateAsUploaded(long r1);

    void updateAsUploading(long r1);
}
