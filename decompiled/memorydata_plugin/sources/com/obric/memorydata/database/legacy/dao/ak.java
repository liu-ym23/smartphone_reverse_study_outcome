package com.obric.memorydata.database.legacy.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.dao.BaseDao;
import com.obric.memorydata.database.legacy.entity.PendingMemoryCalendarOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/legacy/dao/PendingMemoryCalendarDaoOld;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/legacy/entity/PendingMemoryCalendarOld;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ak extends BaseDao<PendingMemoryCalendarOld> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static PendingMemoryCalendarOld a(ak r2, long r3) {
            return (PendingMemoryCalendarOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((ak) ZeusTransformUtils.wrapperContextForParams(r2, ak.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), PendingMemoryCalendarOld.class, "com.obric.memorydata.plugin");
        }

        public static PendingMemoryCalendarOld a(ak r2, String r3) {
            ak r4 = (ak) ZeusTransformUtils.wrapperContextForParams(r2, ak.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (PendingMemoryCalendarOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), PendingMemoryCalendarOld.class, "com.obric.memorydata.plugin");
        }

        public static String a(ak r2) {
            ak r3 = (ak) ZeusTransformUtils.wrapperContextForParams(r2, ak.class, "com.obric.memorydata.plugin");
            return "PendingMemoryCalendar";
        }

        public static List<PendingMemoryCalendarOld> a(ak r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((ak) ZeusTransformUtils.wrapperContextForParams(r2, ak.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<PendingMemoryCalendarOld> a(ak r2, List<Long> r3) {
            ak r4 = (ak) ZeusTransformUtils.wrapperContextForParams(r2, ak.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<PendingMemoryCalendarOld> b(ak r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((ak) ZeusTransformUtils.wrapperContextForParams(r2, ak.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int c(ak r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((ak) ZeusTransformUtils.wrapperContextForParams(r2, ak.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int d(ak r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((ak) ZeusTransformUtils.wrapperContextForParams(r2, ak.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static PendingMemoryCalendarOld e(ak r2) {
            return (PendingMemoryCalendarOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((ak) ZeusTransformUtils.wrapperContextForParams(r2, ak.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), PendingMemoryCalendarOld.class, "com.obric.memorydata.plugin");
        }
    }
}
