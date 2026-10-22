package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H'J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH'J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H'J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\u000e2\u0006\u0010\f\u001a\u00020\u0004H'J$\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\u000e2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H'J\u001c\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\u000e2\u0006\u0010\f\u001a\u00020\u0004H'J$\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\u000e2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006H'J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0006H'J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u0004H'J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0002H'J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0002H'¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/database/dao/PendingMemoryCalendarDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "getTableName", "", "insert", "", "calendarInfo", "batchInsert", "", "calendarInfos", "queryByMemoryUUIDSync", "memoryUUID", "queryByMemoryUUID", "Lkotlinx/coroutines/flow/Flow;", "queryValidByMemoryUUID", "currentTime", "queryByMemoryUUIDGroupedAndSorted", "queryValidByMemoryUUIDGroupedAndSorted", "deleteExpired", "", "delete", "", BuildConfig.CHANNEL, "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PendingMemoryCalendarDao extends BaseDao<PendingMemoryCalendar> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(PendingMemoryCalendarDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((PendingMemoryCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingMemoryCalendarDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(PendingMemoryCalendarDao r2) {
            PendingMemoryCalendarDao r3 = (PendingMemoryCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingMemoryCalendarDao.class, "com.obric.memorydata.plugin");
            return "PendingMemoryCalendar";
        }

        public static List<PendingMemoryCalendar> queryAll(PendingMemoryCalendarDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((PendingMemoryCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingMemoryCalendarDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(PendingMemoryCalendarDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((PendingMemoryCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingMemoryCalendarDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static PendingMemoryCalendar queryById(PendingMemoryCalendarDao r2, long r3) {
            return (PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((PendingMemoryCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingMemoryCalendarDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), PendingMemoryCalendar.class, "com.obric.memorydata.plugin");
        }

        public static List<PendingMemoryCalendar> queryByIds(PendingMemoryCalendarDao r2, List<Long> r3) {
            PendingMemoryCalendarDao r4 = (PendingMemoryCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingMemoryCalendarDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static PendingMemoryCalendar queryByUUID(PendingMemoryCalendarDao r2, String r3) {
            PendingMemoryCalendarDao r4 = (PendingMemoryCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingMemoryCalendarDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), PendingMemoryCalendar.class, "com.obric.memorydata.plugin");
        }

        public static PendingMemoryCalendar queryOne(PendingMemoryCalendarDao r2) {
            return (PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((PendingMemoryCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingMemoryCalendarDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), PendingMemoryCalendar.class, "com.obric.memorydata.plugin");
        }

        public static List<PendingMemoryCalendar> queryWithLimitAndOffset(PendingMemoryCalendarDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((PendingMemoryCalendarDao) ZeusTransformUtils.wrapperContextForParams(r2, PendingMemoryCalendarDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    List<Long> batchInsert(List<PendingMemoryCalendar> r1);

    int delete(PendingMemoryCalendar r1);

    void delete(String r1);

    int deleteExpired(long r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(PendingMemoryCalendar r1);

    i<List<PendingMemoryCalendar>> queryByMemoryUUID(String r1);

    i<List<PendingMemoryCalendar>> queryByMemoryUUIDGroupedAndSorted(String r1);

    List<PendingMemoryCalendar> queryByMemoryUUIDSync(String r1);

    i<List<PendingMemoryCalendar>> queryValidByMemoryUUID(String r1, long r2);

    i<List<PendingMemoryCalendar>> queryValidByMemoryUUIDGroupedAndSorted(String r1, long r2);

    int update(PendingMemoryCalendar r1);
}
