package com.obric.memorydata.database.dao;

import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.cb;
import com.obric.memorydata.database.entity.cc;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H'J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u0016\u0010\t\u001a\u00020\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH'J8\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H'J@\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u0004H'J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u0012H'J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0012H'J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH'J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H'J\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H'J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0007H'J&\u0010(\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010)\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H'J&\u0010*\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010)\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0017J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00072\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H'J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u0004H'J\u0016\u00100\u001a\u00020\u000e2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H'J\u001e\u00101\u001a\u00020\u000e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\f\u001a\u00020\u0004H'J\u001e\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u00103\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH'J\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u00120\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H'J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H'J\u0010\u00106\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H'J\b\u00107\u001a\u00020\u000eH'J\b\u00108\u001a\u00020\u0012H\u0016¨\u00069"}, d2 = {"Lcom/obric/memorydata/database/dao/InAppTraceUploadDao;", "Lcom/obric/memorydata/database/dao/BaseDao;", "Lcom/obric/memorydata/database/entity/InAppTraceUploadEntity;", "insert", "", "entity", "insertAll", "", "entities", "bulkInsert", "", "queryRunnable", "now", "limit", "", "claim", OaidModel.KEY_ID, "expectedState", "", "expectedUpdatedAt", "newState", "leaseUntil", "updateState", "state", "tosUri", "retryCount", "nextRetryAt", "lastError", "queryByLocalPath", "localPath", "queryFirstByState", "queryRecent", "queryLocalPathsByIds", "ids", "queryLinkableInWindow", "windowStart", "windowEnd", "insertObservationLinks", "links", "Lcom/obric/memorydata/database/entity/InAppTraceObservationEntity;", "activateObservationLinks", "observationId", "linkToObservation", "queryLinkedByObservationIds", "Lcom/obric/memorydata/database/dao/InAppTraceObservationRow;", "observationIds", "countObservationLinks", "traceRowId", "deleteObservationLinks", "releaseUnreferenced", "queryTraceFilesForAging", "expireBefore", "querySafeLocalPathsForAging", "queryByObservationIds", "deleteById", "deleteAll", "getTableName", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface InAppTraceUploadDao extends BaseDao<cc> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getTableName(InAppTraceUploadDao r2) {
            InAppTraceUploadDao r3 = (InAppTraceUploadDao) ZeusTransformUtils.wrapperContextForParams(r2, InAppTraceUploadDao.class, "com.obric.memorydata.plugin");
            return "InAppTraceUpload";
        }

        public static int linkToObservation(InAppTraceUploadDao r14, List<Long> r15, long r16, long r18) {
            InAppTraceUploadDao r2 = (InAppTraceUploadDao) ZeusTransformUtils.wrapperContextForParams(r14, InAppTraceUploadDao.class, "com.obric.memorydata.plugin");
            List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r0, "ids");
            if (r0.isEmpty() == false) goto L5;
            return 0;
        L5:
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
            Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r4 = r3.iterator();
        L7:
            if (r4.hasNext() == false) goto L9;
            r5.add(new cb(((Number) ZeusTransformUtils.preCheckCast(r4.next(), Number.class, "com.obric.memorydata.plugin")).longValue(), r16, r18));
            goto L7
        L9:
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r2.insertObservationLinks((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L12;
        L14:
            Iterator r7 = r6.iterator();
            int r8 = 0;
        L16:
            if (r7.hasNext() == false) goto L25;
            if (((Number) ZeusTransformUtils.preCheckCast(r7.next(), Number.class, "com.obric.memorydata.plugin")).longValue() == (-1)) goto L20;
            boolean r9 = true;
        L21:
            if (r9 == false) goto L16;
            r8 = r8 + 1;
            if (r8 >= 0) goto L16;
            CollectionsKt.throwCountOverflow();
            goto L16
        L20:
            r9 = false;
            goto L21
        L25:
            int r10 = r8;
        L26:
            r2.activateObservationLinks(CollectionsKt.distinct((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")), r16, r18);
            return r10;
        L12:
            if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L14;
            r10 = 0;
            goto L26
        }

        public static List<cc> queryAll(InAppTraceUploadDao r2) {
            return BaseDao.DefaultImpls.queryAll((BaseDao) ZeusTransformUtils.preCheckCast((InAppTraceUploadDao) ZeusTransformUtils.wrapperContextForParams(r2, InAppTraceUploadDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(InAppTraceUploadDao r2) {
            return BaseDao.DefaultImpls.queryAllCount((BaseDao) ZeusTransformUtils.preCheckCast((InAppTraceUploadDao) ZeusTransformUtils.wrapperContextForParams(r2, InAppTraceUploadDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"));
        }

        public static cc queryById(InAppTraceUploadDao r2, long r3) {
            return (cc) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryById((BaseDao) ZeusTransformUtils.preCheckCast((InAppTraceUploadDao) ZeusTransformUtils.wrapperContextForParams(r2, InAppTraceUploadDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3), cc.class, "com.obric.memorydata.plugin");
        }

        public static List<cc> queryByIds(InAppTraceUploadDao r2, List<Long> r3) {
            InAppTraceUploadDao r4 = (InAppTraceUploadDao) ZeusTransformUtils.wrapperContextForParams(r2, InAppTraceUploadDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return BaseDao.DefaultImpls.queryByIds((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static cc queryByUUID(InAppTraceUploadDao r2, String r3) {
            InAppTraceUploadDao r4 = (InAppTraceUploadDao) ZeusTransformUtils.wrapperContextForParams(r2, InAppTraceUploadDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (cc) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryByUUID((BaseDao) ZeusTransformUtils.preCheckCast(r4, BaseDao.class, "com.obric.memorydata.plugin"), r3), cc.class, "com.obric.memorydata.plugin");
        }

        public static cc queryOne(InAppTraceUploadDao r2) {
            return (cc) ZeusTransformUtils.preCheckCast(BaseDao.DefaultImpls.queryOne((BaseDao) ZeusTransformUtils.preCheckCast((InAppTraceUploadDao) ZeusTransformUtils.wrapperContextForParams(r2, InAppTraceUploadDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin")), cc.class, "com.obric.memorydata.plugin");
        }

        public static List<cc> queryWithLimitAndOffset(InAppTraceUploadDao r2, int r3, int r4) {
            return BaseDao.DefaultImpls.queryWithLimitAndOffset((BaseDao) ZeusTransformUtils.preCheckCast((InAppTraceUploadDao) ZeusTransformUtils.wrapperContextForParams(r2, InAppTraceUploadDao.class, "com.obric.memorydata.plugin"), BaseDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }
    }

    int activateObservationLinks(List<Long> r1, long r2, long r4);

    @Override // com.obric.memorydata.database.dao.BaseDao
    void bulkInsert(List<cc> r1);

    int claim(long r1, String r3, long r4, String r6, long r7, long r9);

    int countObservationLinks(long r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    int deleteAll();

    int deleteById(long r1);

    int deleteObservationLinks(List<Long> r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(cc r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    List<Long> insertAll(List<cc> r1);

    List<Long> insertObservationLinks(List<cb> r1);

    int linkToObservation(List<Long> r1, long r2, long r4);

    cc queryByLocalPath(String r1);

    List<cc> queryByObservationIds(List<Long> r1);

    cc queryFirstByState(String r1);

    List<cc> queryLinkableInWindow(long r1, long r3);

    List<InAppTraceObservationRow> queryLinkedByObservationIds(List<Long> r1);

    List<String> queryLocalPathsByIds(List<Long> r1);

    List<cc> queryRecent(int r1);

    List<cc> queryRunnable(long r1, int r3);

    List<String> querySafeLocalPathsForAging(List<Long> r1);

    List<cc> queryTraceFilesForAging(long r1, int r3);

    int releaseUnreferenced(List<Long> r1, long r2);

    int updateState(long r1, String r3, String r4, int r5, long r6, String r8, long r9);
}
