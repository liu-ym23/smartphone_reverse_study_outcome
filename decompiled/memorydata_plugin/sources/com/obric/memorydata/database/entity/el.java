package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.Api;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.dao.IHistoryEntityDao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/entity/PhotoFaceHistoryRawDbDao;", "Lcom/obric/memorydata/database/dao/IHistoryEntityDao;", "Lcom/obric/memorydata/database/entity/PhotoFaceHistoryEntity;", "getTableName", "", "getPrefix", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface el extends IHistoryEntityDao<ek> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static int a(el r2, long r3) {
            return IHistoryEntityDao.DefaultImpls.deleteById((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int a(el r2, List<String> r3, String r4) {
            el r5 = (el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityIdList((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static ek a(el r2, String r3) {
            el r4 = (el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (ek) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryByUUID((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3), ek.class, "com.obric.memorydata.plugin");
        }

        public static String a(el r2) {
            el r3 = (el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin");
            return "RawPhotoFaceHistoryEntity";
        }

        public static List<ek> a(el r2, int r3, int r4) {
            return IHistoryEntityDao.DefaultImpls.queryWithLimitAndOffset((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<ek> a(el r2, String r3, String r4) {
            el r5 = (el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.queryByEntityId((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<ek> a(el r2, List<Long> r3) {
            el r4 = (el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IHistoryEntityDao.DefaultImpls.queryByIds((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r4, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int b(el r2, String r3, String r4) {
            el r5 = (el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityId((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int b(el r2, List<String> r3, String r4) {
            el r5 = (el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.deleteByEntityIdListAndPackageName((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static ek b(el r2, long r3) {
            return (ek) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryById((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r3), ek.class, "com.obric.memorydata.plugin");
        }

        public static String b(el r2) {
            el r3 = (el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin");
            return "photo_face_";
        }

        public static List<ek> c(el r2) {
            return IHistoryEntityDao.DefaultImpls.queryAll((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<ek> c(el r2, List<String> r3, String r4) {
            el r5 = (el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IHistoryEntityDao.DefaultImpls.queryByEntityIdListAndPackageName((IHistoryEntityDao) ZeusTransformUtils.preCheckCast(r5, IHistoryEntityDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static int d(el r2) {
            return IHistoryEntityDao.DefaultImpls.queryAllCount((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static int e(el r2) {
            return IHistoryEntityDao.DefaultImpls.deleteAll((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin"));
        }

        public static ek f(el r2) {
            return (ek) ZeusTransformUtils.preCheckCast(IHistoryEntityDao.DefaultImpls.queryOne((IHistoryEntityDao) ZeusTransformUtils.preCheckCast((el) ZeusTransformUtils.wrapperContextForParams(r2, el.class, "com.obric.memorydata.plugin"), IHistoryEntityDao.class, "com.obric.memorydata.plugin")), ek.class, "com.obric.memorydata.plugin");
        }
    }
}
