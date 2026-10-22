package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.obric.memorydata.database.entity.dn;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH'J&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH'J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0004H'J:\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J.\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH'J*\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\nH'¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/dao/MiddleUserProfileDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/MiddleUserProfileEntity;", "getTableName", "", "queryOneRecordBy", "uriKey", "timeStamp", "", "queryRecords", "", "startTimeStamp", "endTimeStamp", "deleteByUriKey", "", "queryMultiKeysGroupByTime", "", "uriKeys", "queryMultiTimes", "queryMultiKeysEntitiesByTimesList", "timestamps", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MiddleUserProfileDao extends BaseDao<dn> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int deleteAll(MiddleUserProfileDao r2) {
            return BaseDao.DefaultImpls.deleteAll((BaseDao) ZeusTransformUtils.preCheckCast((MiddleUserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, MiddleUserProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(MiddleUserProfileDao r2) {
            MiddleUserProfileDao r3 = (MiddleUserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, MiddleUserProfileDao.class, "com.obric.memorydata.plugin");
            return "MiddleUserProfile";
        }

        public static List<dn> queryAll(MiddleUserProfileDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((MiddleUserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, MiddleUserProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(MiddleUserProfileDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((MiddleUserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, MiddleUserProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static dn queryById(MiddleUserProfileDao r2, long r3) {
            return (dn) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((MiddleUserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, MiddleUserProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), dn.class, "com.obric.memorydata.plugin");
        }

        public static List<dn> queryByIds(MiddleUserProfileDao r2, List<Long> r3) {
            MiddleUserProfileDao r4 = (MiddleUserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, MiddleUserProfileDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static dn queryByUUID(MiddleUserProfileDao r2, String r3) {
            MiddleUserProfileDao r4 = (MiddleUserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, MiddleUserProfileDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (dn) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), dn.class, "com.obric.memorydata.plugin");
        }

        public static Map<Long, List<dn>> queryMultiKeysGroupByTime(MiddleUserProfileDao r8, List<String> r9, long r10, long r12) {
            MiddleUserProfileDao r11 = (MiddleUserProfileDao) ZeusTransformUtils.wrapperContextForParams(r8, MiddleUserProfileDao.class, "com.obric.memorydata.plugin");
            List<String> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r13, "uriKeys");
            List<Long> r14 = r11.queryMultiTimes(r13, r10, r12);
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(r14, Collection.class, "com.obric.memorydata.plugin");
            if (r15 != null) goto L5;
        L8:
            boolean r16 = true;
        L9:
            if (r16 == false) goto L11;
            return null;
        L11:
            List<dn> r17 = r11.queryMultiKeysEntitiesByTimesList(r13, r14);
            Map<Long, List<dn>> r18 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
            Iterator<dn> r19 = r17.iterator();
        L13:
            if (r19.hasNext() == false) goto L19;
            dn r110 = (dn) ZeusTransformUtils.preCheckCast(r19.next(), dn.class, "com.obric.memorydata.plugin");
            long r111 = r110.a();
            if (r18.get(Long.valueOf(r111)) != null) goto L17;
            r18.put(Long.valueOf(r111), new ArrayList());
        L17:
            List<dn> r112 = r18.get(Long.valueOf(r111));
            Intrinsics.checkNotNull(r112);
            ((ArrayList) ZeusTransformUtils.preCheckCast(r112, ArrayList.class, "com.obric.memorydata.plugin")).add(r110);
            goto L13
        L19:
            return r18;
        L5:
            if (r15.isEmpty() == true) goto L8;
            r16 = false;
            goto L9
        }

        public static dn queryOne(MiddleUserProfileDao r2) {
            return (dn) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((MiddleUserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, MiddleUserProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), dn.class, "com.obric.memorydata.plugin");
        }

        public static List<dn> queryWithLimitAndOffset(MiddleUserProfileDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((MiddleUserProfileDao) ZeusTransformUtils.wrapperContextForParams(r2, MiddleUserProfileDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int deleteByUriKey(String r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<dn> queryMultiKeysEntitiesByTimesList(List<String> r1, List<Long> r2);

    Map<Long, List<dn>> queryMultiKeysGroupByTime(List<String> r1, long r2, long r4);

    List<Long> queryMultiTimes(List<String> r1, long r2, long r4);

    dn queryOneRecordBy(String r1, long r2);

    List<dn> queryRecords(String r1, long r2, long r4);
}
