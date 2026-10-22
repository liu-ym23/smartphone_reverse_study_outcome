package com.obric.memorydata.database.legacy.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.dao.BaseDao;
import com.obric.memorydata.database.legacy.entity.SlmAgentWatermarkEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/database/legacy/dao/SlmAgentWatermarkDaoOld;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/legacy/entity/SlmAgentWatermarkEntityOld;", "getTableName", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ar extends BaseDao<SlmAgentWatermarkEntityOld> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        public static SlmAgentWatermarkEntityOld a(ar r2, long r3) {
            return (SlmAgentWatermarkEntityOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((ar) ZeusTransformUtils.wrapperContextForParams(r2, ar.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), SlmAgentWatermarkEntityOld.class, "com.obric.memorydata.plugin");
        }

        public static SlmAgentWatermarkEntityOld a(ar r2, String r3) {
            ar r4 = (ar) ZeusTransformUtils.wrapperContextForParams(r2, ar.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (SlmAgentWatermarkEntityOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), SlmAgentWatermarkEntityOld.class, "com.obric.memorydata.plugin");
        }

        public static String a(ar r2) {
            ar r3 = (ar) ZeusTransformUtils.wrapperContextForParams(r2, ar.class, "com.obric.memorydata.plugin");
            return "SlmAgentWatermark";
        }

        public static List<SlmAgentWatermarkEntityOld> a(ar r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((ar) ZeusTransformUtils.wrapperContextForParams(r2, ar.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<SlmAgentWatermarkEntityOld> a(ar r2, List<Long> r3) {
            ar r4 = (ar) ZeusTransformUtils.wrapperContextForParams(r2, ar.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<SlmAgentWatermarkEntityOld> b(ar r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((ar) ZeusTransformUtils.wrapperContextForParams(r2, ar.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int c(ar r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((ar) ZeusTransformUtils.wrapperContextForParams(r2, ar.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int d(ar r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((ar) ZeusTransformUtils.wrapperContextForParams(r2, ar.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static SlmAgentWatermarkEntityOld e(ar r2) {
            return (SlmAgentWatermarkEntityOld) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((ar) ZeusTransformUtils.wrapperContextForParams(r2, ar.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), SlmAgentWatermarkEntityOld.class, "com.obric.memorydata.plugin");
        }
    }
}
