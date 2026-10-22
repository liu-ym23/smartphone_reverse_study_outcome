package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.cr;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H'J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H'¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/database/dao/MemoryEntityToCalendarDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/MemoryEntityToCalendar;", "getTableName", "", "insert", "", "memoryEntityToCalendar", "exists", "", "memoryEntityId", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MemoryEntityToCalendarDao extends BaseDao<cr> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(MemoryEntityToCalendarDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((MemoryEntityToCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityToCalendarDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(MemoryEntityToCalendarDao r2) {
            MemoryEntityToCalendarDao r3 = (MemoryEntityToCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityToCalendarDao.class, "com.obric.memorydata.plugin");
            return "MemoryEntityToCalendar";
        }

        public static List<cr> queryAll(MemoryEntityToCalendarDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((MemoryEntityToCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityToCalendarDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MemoryEntityToCalendarDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((MemoryEntityToCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityToCalendarDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static cr queryById(MemoryEntityToCalendarDao r2, long r3) {
            return (cr) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((MemoryEntityToCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityToCalendarDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), cr.class, "com.obric.memorydata.plugin");
        }

        public static List<cr> queryByIds(MemoryEntityToCalendarDao r2, List<Long> r3) {
            MemoryEntityToCalendarDao r4 = (MemoryEntityToCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityToCalendarDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static cr queryByUUID(MemoryEntityToCalendarDao r2, String r3) {
            MemoryEntityToCalendarDao r4 = (MemoryEntityToCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityToCalendarDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (cr) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), cr.class, "com.obric.memorydata.plugin");
        }

        public static cr queryOne(MemoryEntityToCalendarDao r2) {
            return (cr) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((MemoryEntityToCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityToCalendarDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), cr.class, "com.obric.memorydata.plugin");
        }

        public static List<cr> queryWithLimitAndOffset(MemoryEntityToCalendarDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((MemoryEntityToCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, MemoryEntityToCalendarDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    boolean exists(String r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(cr r1);
}
