package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.Ensure;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.fx;
import com.obric.memorydata.database.model.c;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\b\u001a\u00020\tH'J&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0006H\u0016J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/database/dao/ContactRawDbDao;", "Lcom/obric/memorydata/database/dao/IAppEntityRawDbDao;", "Lcom/obric/memorydata/database/entity/RawContactEntity;", "getTableName", "", "queryAllContactName", "", "queryContactNameWithLimit", "limit", "", "queryByContactNameAndPhoneNumber", "contactName", "phoneNumber", "Lcom/obric/capabilitykit/entity/meta/MetaTelephone;", "queryByPhoneNumber", "phoneNumbers", ObricMemoryConstants.KEY_PACKAGE_NAME, "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ContactRawDbDao extends IAppEntityRawDbDao<fx> {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int backfillContentHashIfAbsent(ContactRawDbDao r8, long r9, long r11, long r13, String r15) {
            ContactRawDbDao r10 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r8, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r9, r11, r13, r15);
        }

        public static int deleteAll(ContactRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.deleteAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int deleteByRawDbIds(ContactRawDbDao r2, List<Long> r3) {
            ContactRawDbDao r4 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "rawDbIds");
            return IAppEntityRawDbDao.DefaultImpls.deleteByRawDbIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static int getCountByPackageName(ContactRawDbDao r2, String r3) {
            ContactRawDbDao r4 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static int getCountByPackageNameWithTimeStamp(ContactRawDbDao r6, String r7, long r8, long r10) {
            ContactRawDbDao r9 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static List<b> getEntitySimpleDataPaging(ContactRawDbDao r2, int r3, long r4) {
            return IAppEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<c> getHashCodeListByPackageNameWithTimeStamp(ContactRawDbDao r6, String r7, long r8, long r10) {
            ContactRawDbDao r9 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r6, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r9, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r7, r8, r10);
        }

        public static long getLastModifyTimeByPackageName(ContactRawDbDao r2, String r3) {
            ContactRawDbDao r4 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<String> getPackageNameList(ContactRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.getPackageNameList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static String getTableName(ContactRawDbDao r2) {
            ContactRawDbDao r3 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            return "RawContactEntity";
        }

        public static /* synthetic */ CharSequence lambda$prEj_iWfpk9DDZkc9qToZfttXLg(String r0) {
            return queryByPhoneNumber$lambda$2(r0);
        }

        public static List<fx> queryAll(ContactRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAll((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static int queryAllCount(ContactRawDbDao r2) {
            return IAppEntityRawDbDao.DefaultImpls.queryAllCount((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"));
        }

        public static List<fx> queryByContactNameAndPhoneNumber(ContactRawDbDao r17, String r18, List<MetaTelephone> r19) {
            ContactRawDbDao r1 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r17, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r18, "contactName");
            if (r3 == null) goto L5;
            Collection r0 = r1.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r1.getTableName() + " WHERE name = '" + r18 + '\''), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
            ArrayList r2 = new ArrayList();
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L22;
            Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L10:
            if (r4.hasNext() == false) goto L22;
            fx r5 = (fx) ZeusTransformUtils.preCheckCast(r4.next(), fx.class, "com.obric.memorydata.plugin");
            Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            boolean r8 = false;
        L13:
            if (r6.hasNext() == false) goto L19;
            MetaTelephone r9 = (MetaTelephone) ZeusTransformUtils.preCheckCast(r6.next(), MetaTelephone.class, "com.obric.memorydata.plugin");
            if (r5.b() == null) goto L13;
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r5.b(), CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(StringsKt.replace$default(r9.getTelephone(), " ", "", false, 4, null), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L13;
            r8 = true;
            goto L13
        L19:
            if (r8 == false) goto L10;
            r2.add(r5);
        L22:
            return (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        L5:
            return CollectionsKt.emptyList();
        }

        public static List<fx> queryByEntityId(ContactRawDbDao r2, String r3, String r4) {
            ContactRawDbDao r5 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityId((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        @Deprecated(message = "use queryByEntityIdListAndPackageName")
        public static List<fx> queryByEntityIdList(ContactRawDbDao r2, List<String> r3) {
            ContactRawDbDao r4 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "entityIds");
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdList((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static List<fx> queryByEntityIdListAndPackageName(ContactRawDbDao r2, List<String> r3, String r4) {
            ContactRawDbDao r5 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "entityIds");
            Intrinsics.checkNotNullParameter(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r6, r4);
        }

        public static fx queryById(ContactRawDbDao r2, long r3) {
            return (fx) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryById((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), fx.class, "com.obric.memorydata.plugin");
        }

        public static List<fx> queryByIdAndTimestamp(ContactRawDbDao r2, long r3, long r5) {
            return IAppEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r5);
        }

        public static List<fx> queryByIds(ContactRawDbDao r2, List<Long> r3) {
            ContactRawDbDao r4 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "ids");
            return IAppEntityRawDbDao.DefaultImpls.queryByIds((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r5);
        }

        public static Cursor queryByPackageName(ContactRawDbDao r2, String[] r3, String r4, int r5, Long r6) {
            ContactRawDbDao r7 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "projection");
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }

        public static List<fx> queryByPackageName(ContactRawDbDao r2, String r3) {
            ContactRawDbDao r4 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3);
        }

        public static List<fx> queryByPackageNameBeforeTimestampWithLimit(ContactRawDbDao r7, String r8, long r9, int r11, long r12) {
            ContactRawDbDao r10 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r7, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r10, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r8, r9, r11, r12);
        }

        public static List<fx> queryByPackageNameWithLimit(ContactRawDbDao r2, String r3, int r4, long r5) {
            ContactRawDbDao r6 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r6, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }

        public static List<fx> queryByPhoneNumber(ContactRawDbDao r13, List<String> r14, String r15) {
            ContactRawDbDao r16 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r13, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r15, ObricMemoryConstants.KEY_PACKAGE_NAME);
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(r17, Collection.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r1 = true;
        L9:
            if (r1 == true) goto L11;
            String r2 = CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" OR ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$ContactRawDbDao$DefaultImpls$prEj_iWfpk9DDZkc9qToZfttXLg.INSTANCE, 30, null);     // Catch: Exception -> L18
            String[] r3 = {r15};     // Catch: Exception -> L18
            Iterable r18 = (Iterable) ZeusTransformUtils.preCheckCast(r17, Iterable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
            Collection r19 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L18
            Iterator r110 = r18.iterator();     // Catch: Exception -> L18
        L14:
            if (r110.hasNext() == false) goto L16;
            r19.add('%' + ((String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.memorydata.plugin")) + ",%");     // Catch: Exception -> L18
            goto L14
        L16:
            return r16.rawQuery((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery("SELECT * FROM " + r16.getTableName() + " WHERE packageName = ? AND (" + r2 + ')', (String[]) ZeusTransformUtils.preCheckCast(ArraysKt.plus(r3, ((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r19, List.class, "com.obric.memorydata.plugin"), Collection.class, "com.obric.memorydata.plugin")).toArray(new String[0])), String[].class, "com.obric.memorydata.plugin")), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
        L18:
            e = move-exception;
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ContactRawDbDao", "queryByPhoneNumber error: " + e.getMessage(), null, 4, null);
            Ensure.ensureNotReachHere((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"), "ContactRawDbDao queryByPhoneNumber error");
            return CollectionsKt.emptyList();
        L11:
            return CollectionsKt.emptyList();
        L5:
            if (r0.isEmpty() == true) goto L8;
            r1 = false;
            goto L9
        }

        private static CharSequence queryByPhoneNumber$lambda$2(String r2) {
            Intrinsics.checkNotNullParameter(r2, "phoneNumber");
            return (CharSequence) ZeusTransformUtils.preCheckCast("telephonesValues LIKE ?", CharSequence.class, "com.obric.memorydata.plugin");
        }

        public static fx queryByUUID(ContactRawDbDao r2, String r3) {
            ContactRawDbDao r4 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, Api.KEY_UUID);
            return (fx) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryByUUID((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r4, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3), fx.class, "com.obric.memorydata.plugin");
        }

        public static fx queryOne(ContactRawDbDao r2) {
            return (fx) ZeusTransformUtils.preCheckCast(IAppEntityRawDbDao.DefaultImpls.queryOne((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin")), fx.class, "com.obric.memorydata.plugin");
        }

        public static List<fx> queryRecentByPackageName(ContactRawDbDao r2, String r3, long r4) {
            ContactRawDbDao r5 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            return IAppEntityRawDbDao.DefaultImpls.queryRecentByPackageName((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r5, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static List<fx> queryWithLimitAndOffset(ContactRawDbDao r2, int r3, int r4) {
            return IAppEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast((ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin"), IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4);
        }

        public static int updatePoisonLabelIfContentHashMatches(ContactRawDbDao r2, String r3, String r4, int r5, Integer r6) {
            ContactRawDbDao r7 = (ContactRawDbDao) ZeusTransformUtils.wrapperContextForParams(r2, ContactRawDbDao.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "entityId");
            Intrinsics.checkNotNullParameter(r4, "contentHash");
            return IAppEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches((IAppEntityRawDbDao) ZeusTransformUtils.preCheckCast(r7, IAppEntityRawDbDao.class, "com.obric.memorydata.plugin"), r3, r4, r5, r6);
        }
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    String getTableName();

    List<String> queryAllContactName();

    List<fx> queryByContactNameAndPhoneNumber(String r1, List<MetaTelephone> r2);

    List<fx> queryByPhoneNumber(List<String> r1, String r2);

    List<String> queryContactNameWithLimit(int r1);
}
