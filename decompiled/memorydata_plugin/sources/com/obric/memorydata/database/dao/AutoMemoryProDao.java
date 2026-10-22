package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.c.a;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.u;
import com.obric.memorydata.database.entity.y;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H'J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0002H'J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH'J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0002H'J\u0016\u0010\u0010\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH'J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0017J\u0016\u0010\u0013\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0017J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u0016\u0010\u0015\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0017J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0002H\u0017J\u0016\u0010\u0017\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0017J\u0016\u0010\u0018\u001a\u00020\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0017J\b\u0010\u001a\u001a\u00020\fH\u0017J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H'J\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H'J\u0017\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\u0006H'¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\t2\u0006\u0010\u001c\u001a\u00020\u0006H'J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\t2\u0006\u0010\u001c\u001a\u00020\u0006H'J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\t2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00060\tH'J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0006H'J\u0010\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0006H\u0017J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060\tH'J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016J\u0012\u0010,\u001a\u0004\u0018\u00010\u00022\u0006\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020\u000eH'J\b\u0010/\u001a\u00020\u000eH\u0017J\b\u00100\u001a\u00020\u000eH'J\b\u00101\u001a\u00020\u000eH\u0017¨\u00062"}, d2 = {"Lcom/obric/memorydata/database/dao/AutoMemoryProDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/AutoMemoryProEntity;", "getTableName", "", "insertRaw", "", "entity", "insertAllRaw", "", "entities", "updateRaw", "", "updateAllRaw", "", "deleteRaw", "bulkDeleteRaw", "insert", "insertAll", "bulkInsert", BuildConfig.CHANNEL, "updateAll", "delete", "bulkDelete", "deleteByRawDbIds", "rawDbIds", "deleteAll", "queryByRuleId", "ruleId", "queryNewCountByRuleId", "lastExposedAutoMemoryId", "queryMaxIdByRuleId", "(J)Ljava/lang/Long;", "queryListItemsByRuleId", "Lcom/obric/memorydata/database/entity/AutoMemoryProListItem;", "queryDeleteRefsByRuleId", "Lcom/obric/memorydata/database/entity/AutoMemoryProDeleteRef;", "queryDeleteRefsByIds", "ids", "deleteEntityById", OaidModel.KEY_ID, "deleteById", "queryAllRuleIds", "getAllForTracker", "queryByEntityId", "entityId", "clearEntityTable", "clearTable", "resetSequence", "clearTableAndResetId", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AutoMemoryProDao extends IAppEntityRawDbDao<AutoMemoryProEntity> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(AutoMemoryProDao r8, long r9, long r11, long r13, String r15) {
            AutoMemoryProDao r10 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r8, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static void bulkDelete(AutoMemoryProDao r7, List<AutoMemoryProEntity> r8) {
            AutoMemoryProDao r9 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r7, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            List<AutoMemoryProEntity> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r10, "entities");
            r9.bulkDeleteRaw(r10);
            Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin");
            Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r11, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            r12.add(Long.valueOf(((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r13.next(), AutoMemoryProEntity.class, "com.obric.memorydata.plugin")).getId()));
            goto L4
        L6:
            Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
            Collection r15 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r16 = r14.iterator();
        L7:
            boolean r2 = true;
            if (r16.hasNext() == false) goto L15;
            Object r0 = r16.next();
            if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.memorydata.plugin")).longValue() > 0) goto L13;
            r2 = false;
        L13:
            if (r2 == false) goto L7;
            r15.add(r0);
            goto L7
        L15:
            List<Long> r17 = (List) ZeusTransformUtils.preCheckCast(r15, List.class, "com.obric.memorydata.plugin");
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L25;
            a.f8848a.b(r17);
            return;
        }

        public static void bulkInsert(AutoMemoryProDao r2, List<AutoMemoryProEntity> r3) {
            AutoMemoryProDao r4 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            List<AutoMemoryProEntity> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entities");
            r4.insertAll(r5);
        }

        public static void clearTable(AutoMemoryProDao r2) {
            ((AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin")).clearEntityTable();
            a.f8848a.a();
        }

        public static void clearTableAndResetId(AutoMemoryProDao r2) {
            AutoMemoryProDao r3 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            r3.clearTable();
            r3.resetSequence();
        }

        public static int delete(AutoMemoryProDao r4, AutoMemoryProEntity r5) {
            AutoMemoryProDao r6 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r4, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entity");
            int r7 = r6.deleteRaw(r5);
            if (r7 > 0) goto L5;
        L7:
            return r7;
        L5:
            if (r5.getId() <= 0) goto L7;
            a.f8848a.a(r5.getId());
            goto L7
        }

        public static int deleteAll(AutoMemoryProDao r4) {
            AutoMemoryProDao r5 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r4, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            int r6 = r5.delete((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r5.getTableName()), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
            a.f8848a.a();
            return r6;
        }

        public static int deleteById(AutoMemoryProDao r2, long r3) {
            int r4 = ((AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin")).deleteEntityById(r3);
            if (r4 <= 0) goto L5;
            a.f8848a.a(r3);
        L5:
            return r4;
        }

        public static int deleteByRawDbIds(AutoMemoryProDao r13, List<Long> r14) {
            AutoMemoryProDao r15 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r13, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            List<Long> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r16, "rawDbIds");
            if (r16.isEmpty() == false) goto L6;
            return 0;
        L6:
            int r17 = r15.delete((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("DELETE FROM " + r15.getTableName() + " WHERE id IN (" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r16, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null) + ')'), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
            if (r17 <= 0) goto L9;
            a.f8848a.b(r16);
        L9:
            return r17;
        }

        public static List<AutoMemoryProEntity> getAllForTracker(AutoMemoryProDao r4) {
            AutoMemoryProDao r5 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r4, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            return r5.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r5.getTableName()), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        }

        public static int getCountByPackageName(AutoMemoryProDao r2, String r3) {
            AutoMemoryProDao r4 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(AutoMemoryProDao r6, String r7, long r8, long r10) {
            AutoMemoryProDao r9 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r6, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(AutoMemoryProDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(AutoMemoryProDao r6, String r7, long r8, long r10) {
            AutoMemoryProDao r9 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r6, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(AutoMemoryProDao r2, String r3) {
            AutoMemoryProDao r4 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(AutoMemoryProDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(AutoMemoryProDao r2) {
            AutoMemoryProDao r3 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            return "AutoMemoryPro";
        }

        public static long insert(AutoMemoryProDao r4, AutoMemoryProEntity r5) {
            AutoMemoryProDao r6 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r4, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entity");
            long r0 = r6.insertRaw(r5);
            if (r0 <= 0) goto L5;
            r5.setId(r0);
            a.f8848a.a(r5);
        L5:
            return r0;
        }

        public static List<Long> insertAll(AutoMemoryProDao r10, List<AutoMemoryProEntity> r11) {
            AutoMemoryProDao r12 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r10, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            List<AutoMemoryProEntity> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r13, "entities");
            List<Long> r14 = r12.insertAllRaw(r13);
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            int r3 = 0;
        L4:
            if (r0.hasNext() == false) goto L16;
            Object r4 = r0.next();
            int r7 = r3 + 1;
            if (r3 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            AutoMemoryProEntity r5 = (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r4, AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
            Long r6 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.getOrNull(r14, r3), Long.class, "com.obric.memorydata.plugin");
            if (r6 == null) goto L11;
            long r8 = r6.longValue();
        L13:
            if (r8 <= 0) goto L15;
            r5.setId(r8);
        L15:
            r3 = r7;
            goto L4
        L11:
            r8 = 0;
            goto L13
        L16:
            a r1 = a.f8848a;
            Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin");
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r16 = r15.iterator();
        L18:
            if (r16.hasNext() == false) goto L25;
            Object r17 = r16.next();
            if (((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r17, AutoMemoryProEntity.class, "com.obric.memorydata.plugin")).getId() <= 0) goto L22;
            boolean r18 = true;
        L23:
            if (r18 == false) goto L18;
            r9.add(r17);
            goto L18
        L22:
            r18 = false;
            goto L23
        L25:
            r1.a((List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin"));
            return r14;
        }

        public static List<AutoMemoryProEntity> queryAll(AutoMemoryProDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(AutoMemoryProDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static AutoMemoryProEntity queryByEntityId(AutoMemoryProDao r5, String r6) {
            AutoMemoryProDao r7 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r5, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityId");
            return (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(r7.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r7.getTableName() + " WHERE entityId = ? LIMIT 1", new String[]{r6}), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"))), AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<AutoMemoryProEntity> queryByEntityId(AutoMemoryProDao r2, String r3, String r4) {
            AutoMemoryProDao r5 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<AutoMemoryProEntity> queryByEntityIdList(AutoMemoryProDao r2, List<String> r3) {
            AutoMemoryProDao r4 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<AutoMemoryProEntity> queryByEntityIdListAndPackageName(AutoMemoryProDao r2, List<String> r3, String r4) {
            AutoMemoryProDao r5 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static AutoMemoryProEntity queryById(AutoMemoryProDao r2, long r3) {
            return (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<AutoMemoryProEntity> queryByIdAndTimestamp(AutoMemoryProDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<AutoMemoryProEntity> queryByIds(AutoMemoryProDao r2, List<Long> r3) {
            AutoMemoryProDao r4 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(AutoMemoryProDao r2, String[] r3, String r4, int r5, Long r6) {
            AutoMemoryProDao r7 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<AutoMemoryProEntity> queryByPackageName(AutoMemoryProDao r2, String r3) {
            AutoMemoryProDao r4 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<AutoMemoryProEntity> queryByPackageNameBeforeTimestampWithLimit(AutoMemoryProDao r7, String r8, long r9, int r11, long r12) {
            AutoMemoryProDao r10 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r7, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<AutoMemoryProEntity> queryByPackageNameWithLimit(AutoMemoryProDao r2, String r3, int r4, long r5) {
            AutoMemoryProDao r6 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static AutoMemoryProEntity queryByUUID(AutoMemoryProDao r2, String r3) {
            AutoMemoryProDao r4 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
        }

        public static AutoMemoryProEntity queryOne(AutoMemoryProDao r2) {
            return (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
        }

        public static List<AutoMemoryProEntity> queryRecentByPackageName(AutoMemoryProDao r2, String r3, long r4) {
            AutoMemoryProDao r5 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<AutoMemoryProEntity> queryWithLimitAndOffset(AutoMemoryProDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int update(AutoMemoryProDao r2, AutoMemoryProEntity r3) {
            AutoMemoryProDao r4 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entity");
            int r5 = r4.updateRaw(r3);
            if (r5 <= 0) goto L5;
            a.f8848a.a(r3);
        L5:
            return r5;
        }

        public static void updateAll(AutoMemoryProDao r9, List<AutoMemoryProEntity> r10) {
            AutoMemoryProDao r11 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r9, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            List<AutoMemoryProEntity> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r12, "entities");
            r11.updateAllRaw(r12);
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r2.add(Long.valueOf(((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r1.next(), AutoMemoryProEntity.class, "com.obric.memorydata.plugin")).getId()));
            goto L4
        L6:
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
            Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r5 = r3.iterator();
        L8:
            if (r5.hasNext() == false) goto L15;
            Object r6 = r5.next();
            if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L12;
            boolean r7 = true;
        L13:
            if (r7 == false) goto L8;
            r4.add(r6);
            goto L8
        L12:
            r7 = false;
            goto L13
        L15:
            List<Long> r8 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
            if (r8.isEmpty() == false) goto L18;
            return;
        L18:
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r11.queryByIds(r8), Iterable.class, "com.obric.memorydata.plugin");
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r15 = r13.iterator();
        L20:
            if (r15.hasNext() == false) goto L22;
            r14.add(Long.valueOf(((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r15.next(), AutoMemoryProEntity.class, "com.obric.memorydata.plugin")).getId()));
            goto L20
        L22:
            HashSet r16 = CollectionsKt.toHashSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
            a r17 = a.f8848a;
            Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin");
            Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r110 = r18.iterator();
        L24:
            if (r110.hasNext() == false) goto L28;
            Object r20 = r110.next();
            if (r16.contains(Long.valueOf(((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r20, AutoMemoryProEntity.class, "com.obric.memorydata.plugin")).getId())) == false) goto L24;
            r19.add(r20);
            goto L24
        L28:
            r17.a((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin"));
        }

        public static int updatePoisonLabelIfContentHashMatches(AutoMemoryProDao r2, String r3, String r4, int r5, Integer r6) {
            AutoMemoryProDao r7 = (AutoMemoryProDao) ZeusTransformUtils.wrapperContextForParams(r2, AutoMemoryProDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    void bulkDelete(List<AutoMemoryProEntity> r1);

    void bulkDeleteRaw(List<AutoMemoryProEntity> r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    void bulkInsert(List<AutoMemoryProEntity> r1);

    void clearEntityTable();

    void clearTable();

    void clearTableAndResetId();

    int delete(AutoMemoryProEntity r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    int deleteAll();

    int deleteById(long r1);

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    int deleteByRawDbIds(List<Long> r1);

    int deleteEntityById(long r1);

    int deleteRaw(AutoMemoryProEntity r1);

    List<AutoMemoryProEntity> getAllForTracker();

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    long insert(AutoMemoryProEntity r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    List<Long> insertAll(List<AutoMemoryProEntity> r1);

    List<Long> insertAllRaw(List<AutoMemoryProEntity> r1);

    long insertRaw(AutoMemoryProEntity r1);

    List<Long> queryAllRuleIds();

    AutoMemoryProEntity queryByEntityId(String r1);

    long queryByRuleId(long r1);

    List<u> queryDeleteRefsByIds(List<Long> r1);

    List<u> queryDeleteRefsByRuleId(long r1);

    List<y> queryListItemsByRuleId(long r1);

    Long queryMaxIdByRuleId(long r1);

    long queryNewCountByRuleId(long r1, long r3);

    void resetSequence();

    int update(AutoMemoryProEntity r1);

    @Override // com.obric.memorydata.database.dao.BaseDao
    void updateAll(List<AutoMemoryProEntity> r1);

    void updateAllRaw(List<AutoMemoryProEntity> r1);

    int updateRaw(AutoMemoryProEntity r1);
}
