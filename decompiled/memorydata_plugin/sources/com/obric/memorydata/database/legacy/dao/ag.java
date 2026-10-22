package com.obric.memorydata.database.legacy.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.dao.BaseDao;
import com.obric.memorydata.database.legacy.entity.MemoryRuleEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/legacy/dao/MemoryRuleDaoOld;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/legacy/entity/MemoryRuleEntityOld;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ag extends BaseDao<MemoryRuleEntityOld> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static MemoryRuleEntityOld a(ag r2, long r3) {
            return (MemoryRuleEntityOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((ag) ZeusTransformUtils.wrapperContextForParams(r2, ag.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), MemoryRuleEntityOld.class, "com.obric.memorydata.plugin");
        }

        public static MemoryRuleEntityOld a(ag r2, String r3) {
            ag r4 = (ag) ZeusTransformUtils.wrapperContextForParams(r2, ag.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (MemoryRuleEntityOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), MemoryRuleEntityOld.class, "com.obric.memorydata.plugin");
        }

        public static String a(ag r2) {
            ag r3 = (ag) ZeusTransformUtils.wrapperContextForParams(r2, ag.class, "com.obric.memorydata.plugin");
            return "MemoryRule";
        }

        public static List<MemoryRuleEntityOld> a(ag r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((ag) ZeusTransformUtils.wrapperContextForParams(r2, ag.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<MemoryRuleEntityOld> a(ag r2, List<Long> r3) {
            ag r4 = (ag) ZeusTransformUtils.wrapperContextForParams(r2, ag.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<MemoryRuleEntityOld> b(ag r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((ag) ZeusTransformUtils.wrapperContextForParams(r2, ag.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int c(ag r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((ag) ZeusTransformUtils.wrapperContextForParams(r2, ag.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int d(ag r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((ag) ZeusTransformUtils.wrapperContextForParams(r2, ag.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static MemoryRuleEntityOld e(ag r2) {
            return (MemoryRuleEntityOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((ag) ZeusTransformUtils.wrapperContextForParams(r2, ag.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), MemoryRuleEntityOld.class, "com.obric.memorydata.plugin");
        }
    }
}
