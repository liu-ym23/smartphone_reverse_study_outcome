package com.obric.memorydata.database.dao;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.RawObservationEntity;
import com.obric.memorydata.database.entity.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\"\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H'J8\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH'JH\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH'J@\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH'J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0017¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/dao/AutoMemoryProRawSourceDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/AutoMemoryProRawSource;", "getTableName", "", "queryBySource", TypedValues.AttributesType.S_TARGET, "sourceType", "sourceKey", "updateStateIfCurrent", "", "expectedState", "newState", "updateTime", "", "updateFailureIfCurrent", "retryCount", "lastErrorCode", "updateContentPartsIfCurrent", "expectedContentPartsJson", "contentPartsJson", "insertOrUpdatePending", "", "entity", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AutoMemoryProRawSourceDao extends BaseDao<z> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(AutoMemoryProRawSourceDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemoryProRawSourceDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProRawSourceDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(AutoMemoryProRawSourceDao r2) {
            AutoMemoryProRawSourceDao r3 = (AutoMemoryProRawSourceDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProRawSourceDao.class, "com.obric.memorydata.plugin");
            return "AutoMemoryProRawSource";
        }

        public static boolean insertOrUpdatePending(AutoMemoryProRawSourceDao r37, z r38) {
            AutoMemoryProRawSourceDao r14 = (AutoMemoryProRawSourceDao) ZeusTransformUtils.wrapperContextForParams(r37, AutoMemoryProRawSourceDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r38, "entity");
            z r0 = z.a(r38, 0, null, null, null, null, null, 0, "PENDING", 0, 0, null, 0, 3199, null);
            z r1 = r14.queryBySource(r38.b(), r38.c(), r38.d());
            if (r1 != null) goto L10;
            if (r14.insert(r0) <= 0) goto L8;
            return true;
        L8:
            return false;
        L10:
            if (Intrinsics.areEqual(r1.h(), RawObservationEntity.STATE_FAILED) == false) goto L16;
            r14.delete(r1);
            if (r14.insert(z.a(r0, 0, null, null, null, null, null, 0, null, 0, 0, null, 0, 4094, null)) <= 0) goto L15;
            return true;
        L15:
            return false;
        L16:
            return false;
        }

        public static List<z> queryAll(AutoMemoryProRawSourceDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemoryProRawSourceDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProRawSourceDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(AutoMemoryProRawSourceDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemoryProRawSourceDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProRawSourceDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static z queryById(AutoMemoryProRawSourceDao r2, long r3) {
            return (z) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemoryProRawSourceDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProRawSourceDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), z.class, "com.obric.memorydata.plugin");
        }

        public static List<z> queryByIds(AutoMemoryProRawSourceDao r2, List<Long> r3) {
            AutoMemoryProRawSourceDao r4 = (AutoMemoryProRawSourceDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProRawSourceDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static z queryByUUID(AutoMemoryProRawSourceDao r2, String r3) {
            AutoMemoryProRawSourceDao r4 = (AutoMemoryProRawSourceDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProRawSourceDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (z) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), z.class, "com.obric.memorydata.plugin");
        }

        public static z queryOne(AutoMemoryProRawSourceDao r2) {
            return (z) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemoryProRawSourceDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProRawSourceDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), z.class, "com.obric.memorydata.plugin");
        }

        public static List<z> queryWithLimitAndOffset(AutoMemoryProRawSourceDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((AutoMemoryProRawSourceDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProRawSourceDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    boolean insertOrUpdatePending(z r1);

    z queryBySource(String r1, String r2, String r3);

    int updateContentPartsIfCurrent(String r1, String r2, String r3, String r4, String r5, String r6, long r7);

    int updateFailureIfCurrent(String r1, String r2, String r3, String r4, String r5, int r6, int r7, long r8);

    int updateStateIfCurrent(String r1, String r2, String r3, String r4, String r5, long r6);
}
