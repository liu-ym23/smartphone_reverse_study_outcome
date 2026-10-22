package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.dao.IHistoryEntityDao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/entity/AuditoryRecordingHistoryEntityDao;", "Lcom/obric/memorydata/database/dao/IHistoryEntityDao;", "Lcom/obric/memorydata/database/entity/RawAuditoryRecordingHistoryEntity;", "getTableName", "", "getPrefix", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface r extends IHistoryEntityDao<fl> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static int a(r r2, long r3) {
            return IHistoryEntityDao.DefaultImpls.deleteById((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int a(r r2, List<String> r3, String r4) {
            r r5 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityIdList((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static fl a(r r2, String r3) {
            r r4 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (fl) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryByUUID((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3), fl.class, "com.obric.memorydata.plugin");
        }

        public static String a(r r2) {
            r r3 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            return "RawAuditoryRecordingHistoryEntity";
        }

        public static List<fl> a(r r2, int r3, int r4) {
            return IHistoryEntityDao.DefaultImpls.queryWithLimitAndOffset((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<fl> a(r r2, String r3, String r4) {
            r r5 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.queryByEntityId((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<fl> a(r r2, List<Long> r3) {
            r r4 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IHistoryEntityDao.DefaultImpls.queryByIds((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int b(r r2, String r3, String r4) {
            r r5 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityId((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int b(r r2, List<String> r3, String r4) {
            r r5 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityIdListAndPackageName((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static fl b(r r2, long r3) {
            return (fl) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryById((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3), fl.class, "com.obric.memorydata.plugin");
        }

        public static String b(r r2) {
            r r3 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            return "auditory";
        }

        public static List<fl> c(r r2) {
            return IHistoryEntityDao.DefaultImpls.queryAll((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<fl> c(r r2, List<String> r3, String r4) {
            r r5 = (r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.queryByEntityIdListAndPackageName((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static int d(r r2) {
            return IHistoryEntityDao.DefaultImpls.queryAllCount((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static int e(r r2) {
            return IHistoryEntityDao.DefaultImpls.deleteAll((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static fl f(r r2) {
            return (fl) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryOne((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((r) ZeusTransformUtils.wrapperContextForParams(r2, r.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin")), fl.class, "com.obric.memorydata.plugin");
        }
    }
}
