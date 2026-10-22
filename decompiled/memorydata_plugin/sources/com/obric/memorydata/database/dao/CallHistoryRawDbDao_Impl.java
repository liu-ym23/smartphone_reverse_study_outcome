package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.fq;
import com.obric.memorydata.database.model.a;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: classes4.dex */
public final class CallHistoryRawDbDao_Impl implements CallHistoryRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<fq> __deletionAdapterOfRawCallHistoryEntity;
    private final EntityInsertionAdapter<fq> __insertionAdapterOfRawCallHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<fq> __updateAdapterOfRawCallHistoryEntity;

    public CallHistoryRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawCallHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawCallHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawCallHistoryEntity = new AnonymousClass3(this, r2);
    }

    private fq __entityCursorConverter_comObricMemorydataDatabaseEntityRawCallHistoryEntity(Cursor r61) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r61, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r10 = CursorUtil.getColumnIndex(r0, "telephones");
        int r11 = CursorUtil.getColumnIndex(r0, "contactIds");
        int r12 = CursorUtil.getColumnIndex(r0, "callType");
        int r13 = CursorUtil.getColumnIndex(r0, "duration");
        int r14 = CursorUtil.getColumnIndex(r0, LocationMonitorConst.TAG);
        int r15 = CursorUtil.getColumnIndex(r0, "isAIPickup");
        int r16 = CursorUtil.getColumnIndex(r0, "hasTranscript");
        int r17 = CursorUtil.getColumnIndex(r0, "transcript");
        int r18 = CursorUtil.getColumnIndex(r0, "contentWithTime");
        int r19 = CursorUtil.getColumnIndex(r0, "carriers");
        int r110 = CursorUtil.getColumnIndex(r0, "fullContent");
        int r111 = CursorUtil.getColumnIndex(r0, "telephoneStandardMap");
        int r112 = CursorUtil.getColumnIndex(r0, "todoList");
        int r113 = CursorUtil.getColumnIndex(r0, "transcriptTitle");
        int r114 = CursorUtil.getColumnIndex(r0, "source_number");
        int r115 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r116 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r117 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r26 = 0;
        if (r1 != (-1)) goto L5;
        long r32 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r34 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r35 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r37 = 0;
    L19:
        boolean r21 = false;
        if (r5 != (-1)) goto L22;
        int r39 = 0;
    L23:
        if (r6 == (-1)) goto L26;
        r26 = r0.getLong(r6);
    L26:
        long r40 = r26;
        if (r7 != (-1)) goto L30;
    L28:
        String r42 = null;
    L33:
        if (r8 != (-1)) goto L35;
        int r43 = 0;
    L36:
        if (r9 != (-1)) goto L39;
    L37:
        String r44 = null;
    L42:
        if (r10 != (-1)) goto L45;
    L43:
        String r45 = null;
    L48:
        if (r11 != (-1)) goto L51;
    L49:
        String r46 = null;
    L54:
        if (r12 != (-1)) goto L57;
    L55:
        String r47 = null;
    L60:
        if (r13 != (-1)) goto L62;
        int r48 = 0;
    L63:
        if (r14 != (-1)) goto L66;
    L64:
        String r49 = null;
    L70:
        if (r15 != (-1)) goto L73;
        boolean r50 = false;
    L77:
        if (r61 != (-1)) goto L80;
    L78:
        boolean r51 = r21;
        if (r17 != (-1)) goto L86;
    L83:
        String r52 = null;
    L89:
        if (r18 != (-1)) goto L93;
    L90:
        String r53 = null;
    L96:
        if (r19 != (-1)) goto L100;
    L97:
        String r54 = null;
    L103:
        if (r110 != (-1)) goto L107;
    L104:
        String r55 = null;
    L110:
        if (r111 != (-1)) goto L114;
    L111:
        String r56 = null;
    L117:
        if (r112 != (-1)) goto L121;
    L118:
        String r57 = null;
    L124:
        if (r113 != (-1)) goto L128;
    L125:
        String r58 = null;
    L131:
        if (r114 != (-1)) goto L134;
    L132:
        String r59 = null;
    L137:
        fq r22 = new fq(r32, r34, r35, r37, r39, r40, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59);
        if (r115 == (-1)) goto L145;
        if (r0.isNull(r115) == false) goto L142;
        Integer r23 = null;
    L143:
        r22.setPoisonLabel(r23);
        goto L145
    L142:
        r23 = Integer.valueOf(r0.getInt(r115));
    L145:
        if (r116 == (-1)) goto L152;
        if (r0.isNull(r116) == false) goto L149;
        Integer r24 = null;
    L150:
        r22.setPoisonLabelVersion(r24);
        goto L152
    L149:
        r24 = Integer.valueOf(r0.getInt(r116));
    L152:
        if (r117 != (-1)) goto L154;
    L158:
        return r22;
    L154:
        if (r0.isNull(r117) == true) goto L157;
        r20 = r0.getString(r117);
    L157:
        r22.setContentHash(r20);
        goto L158
    L134:
        if (r0.isNull(r114) == true) goto L132;
        r59 = r0.getString(r114);
        goto L137
    L128:
        if (r0.isNull(r113) == true) goto L125;
        r58 = r0.getString(r113);
        goto L131
    L121:
        if (r0.isNull(r112) == true) goto L118;
        r57 = r0.getString(r112);
        goto L124
    L114:
        if (r0.isNull(r111) == true) goto L111;
        r56 = r0.getString(r111);
        goto L117
    L107:
        if (r0.isNull(r110) == true) goto L104;
        r55 = r0.getString(r110);
        goto L110
    L100:
        if (r0.isNull(r19) == true) goto L97;
        r54 = r0.getString(r19);
        goto L103
    L93:
        if (r0.isNull(r18) == true) goto L90;
        r53 = r0.getString(r18);
        goto L96
    L86:
        if (r0.isNull(r17) == true) goto L83;
        r52 = r0.getString(r17);
        goto L89
    L80:
        if (r0.getInt(r16) == 0) goto L78;
        r21 = true;
        goto L78
    L73:
        if (r0.getInt(r15) == 0) goto L75;
        boolean r25 = true;
    L76:
        r50 = r25;
        goto L77
    L75:
        r25 = false;
        goto L76
    L66:
        if (r0.isNull(r14) == true) goto L64;
        r49 = r0.getString(r14);
        goto L70
    L62:
        r48 = r0.getInt(r13);
        goto L63
    L57:
        if (r0.isNull(r12) == true) goto L55;
        r47 = r0.getString(r12);
        goto L60
    L51:
        if (r0.isNull(r11) == true) goto L49;
        r46 = r0.getString(r11);
        goto L54
    L45:
        if (r0.isNull(r10) == true) goto L43;
        r45 = r0.getString(r10);
        goto L48
    L39:
        if (r0.isNull(r9) == true) goto L37;
        r44 = r0.getString(r9);
        goto L42
    L35:
        r43 = r0.getInt(r8);
        goto L36
    L30:
        if (r0.isNull(r7) == true) goto L28;
        r42 = r0.getString(r7);
        goto L33
    L22:
        r39 = r0.getInt(r5);
        goto L23
    L18:
        r37 = r0.getLong(r4);
        goto L19
    L15:
        r35 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r34 = r0.getString(r2);
        goto L13
    L5:
        r32 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return CallHistoryRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<fq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawCallHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<fq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawCallHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryRawDbDao
    public int debugCountRowsForSourceNumberBackfill() {
        return CallHistoryRawDbDao.DefaultImpls.debugCountRowsForSourceNumberBackfill(this);
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryRawDbDao
    public List<fq> debugQueryRowsByEntityIdForSourceNumberBackfill(String r1) {
        return CallHistoryRawDbDao.DefaultImpls.debugQueryRowsByEntityIdForSourceNumberBackfill(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryRawDbDao
    public int debugUpdateSourceNumberPostCasDonationForBackfill(long r1, String r3, String r4, String r5, long r6) {
        return CallHistoryRawDbDao.DefaultImpls.debugUpdateSourceNumberPostCasDonationForBackfill(this, r1, r3, r4, r5, r6);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int delete(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        int r0 = 0;
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L8:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L6;
        r0 = r2.getInt(0);     // Catch: Throwable -> L8
    L6:
        r2.close();
        return r0;
    }

    public int delete(fq r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawCallHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(Object r3) {
        return delete((fq) ZeusTransformUtils.preCheckCast(r3, fq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return CallHistoryRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return CallHistoryRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCount(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        int r0 = 0;
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L8:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L6;
        r0 = r2.getInt(0);     // Catch: Throwable -> L8
    L6:
        r2.close();
        return r0;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageName(String r1) {
        return CallHistoryRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return CallHistoryRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return CallHistoryRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<c> getHashCodeListByPackageNameWithTimeStamp(SupportSQLiteQuery r8) {
        SupportSQLiteQuery r9 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r8, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r9, false, null);
        int r10 = CursorUtil.getColumnIndex(r7, "entityId");     // Catch: Throwable -> L20
        int r2 = CursorUtil.getColumnIndex(r7, "hashCodeValue");     // Catch: Throwable -> L20
        ArrayList r3 = new ArrayList(r7.getCount());     // Catch: Throwable -> L20
    L4:
        if (r7.moveToNext() == false) goto L18;
        if (r10 != (-1)) goto L10;
    L8:
        String r5 = null;
    L13:
        if (r2 != (-1)) goto L15;
        int r4 = 0;
    L16:
        r3.add(new c(r5, r4));     // Catch: Throwable -> L20
        goto L4
    L15:
        r4 = r7.getInt(r2);     // Catch: Throwable -> L20
        goto L16
    L10:
        if (r7.isNull(r10) == true) goto L8;
        r5 = r7.getString(r10);     // Catch: Throwable -> L20
        goto L13
    L18:
        r7.close();
        return r3;
    L20:
        th = move-exception;
        r7.close();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<c> getHashCodeListByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return CallHistoryRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryRawDbDao
    public Pair<String, Long> getLastCallTimeStampByPhoneNumbers(List<String> r3, String r4) {
        return CallHistoryRawDbDao.DefaultImpls.getLastCallTimeStampByPhoneNumbers(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return CallHistoryRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Long getMaxValue(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Long r1 = null;
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L11:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == true) goto L6;
    L9:
        r2.close();
        return r1;
    L6:
        if (r2.isNull(0) == true) goto L9;
        r1 = Long.valueOf(r2.getLong(0));     // Catch: Throwable -> L11
        goto L9
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<String> getPackageNameList() {
        return CallHistoryRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return CallHistoryRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(fq r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawCallHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(Object r3) {
        return insert((fq) ZeusTransformUtils.preCheckCast(r3, fq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<fq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawCallHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fq> queryAll() {
        return CallHistoryRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return CallHistoryRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fq> queryByEntityId(String r1, String r2) {
        return CallHistoryRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fq> queryByEntityIdList(List<String> r3) {
        return CallHistoryRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fq> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return CallHistoryRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fq queryById(long r1) {
        return CallHistoryRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fq> queryByIdAndTimestamp(long r1, long r3) {
        return CallHistoryRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fq> queryByIds(List<Long> r3) {
        return CallHistoryRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return CallHistoryRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fq> queryByPackageName(String r1) {
        return CallHistoryRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fq> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return CallHistoryRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fq> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return CallHistoryRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryRawDbDao
    public fq queryByRawDbId(long r1) {
        return CallHistoryRawDbDao.DefaultImpls.queryByRawDbId(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fq queryByUUID(String r1) {
        return CallHistoryRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryRawDbDao
    public Cursor queryOldDataForContentTimeIndexPending() {
        return CallHistoryRawDbDao.DefaultImpls.queryOldDataForContentTimeIndexPending(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fq queryOne() {
        return CallHistoryRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fq> queryRecentByPackageName(String r1, long r2) {
        return CallHistoryRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryRawDbDao
    public List<a> querySourceNumberBackfillCandidates(long r1, int r3) {
        return CallHistoryRawDbDao.DefaultImpls.querySourceNumberBackfillCandidates(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryRawDbDao
    public List<com.obric.memorydata.database.model.b> querySourceNumberContentCandidates(long r1, int r3) {
        return CallHistoryRawDbDao.DefaultImpls.querySourceNumberContentCandidates(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fq> queryWithLimitAndOffset(int r1, int r2) {
        return CallHistoryRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fq> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawCallHistoryEntity(r6));     // Catch: Throwable -> L10
        goto L5
    L8:
        r6.close();
        return r0;
    L10:
        th = move-exception;
        r6.close();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public Cursor rawQueryForCursor(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        return this.__db.query(r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int rawQueryForInt(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        int r0 = 0;
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L8:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L6;
        r0 = r2.getInt(0);     // Catch: Throwable -> L8
    L6:
        r2.close();
        return r0;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public long rawQueryForLong(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L10:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L7;
        long r0 = r2.getLong(0);     // Catch: Throwable -> L10
    L8:
        r2.close();
        return r0;
    L7:
        r0 = 0;
        goto L8
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryRawDbDao
    public List<a> rawQuerySourceNumberBackfillCandidates(SupportSQLiteQuery r26) {
        SupportSQLiteQuery r1 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r26, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndex(r2, "rawDbId");     // Catch: Throwable -> L35
        int r4 = CursorUtil.getColumnIndex(r2, "entityId");     // Catch: Throwable -> L35
        int r5 = CursorUtil.getColumnIndex(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L35
        int r6 = CursorUtil.getColumnIndex(r2, "expectedModifyTime");     // Catch: Throwable -> L35
        int r7 = CursorUtil.getColumnIndex(r2, "expectedHash");     // Catch: Throwable -> L35
        int r8 = CursorUtil.getColumnIndex(r2, "expectedTimestamp");     // Catch: Throwable -> L35
        ArrayList r9 = new ArrayList(r2.getCount());     // Catch: Throwable -> L35
    L4:
        if (r2.moveToNext() == false) goto L33;
        long r10 = 0;
        if (r0 != (-1)) goto L9;
        long r16 = 0;
    L10:
        if (r4 != (-1)) goto L13;
    L11:
        String r18 = null;
    L16:
        if (r5 != (-1)) goto L19;
    L17:
        String r19 = null;
    L22:
        if (r6 != (-1)) goto L24;
        long r20 = 0;
    L25:
        if (r7 != (-1)) goto L27;
        int r22 = 0;
    L28:
        if (r8 == (-1)) goto L31;
        r10 = r2.getLong(r8);     // Catch: Throwable -> L35
    L31:
        r9.add(new a(r16, r18, r19, r20, r22, r10));     // Catch: Throwable -> L35
        goto L4
    L27:
        r22 = r2.getInt(r7);     // Catch: Throwable -> L35
        goto L28
    L24:
        r20 = r2.getLong(r6);     // Catch: Throwable -> L35
        goto L25
    L19:
        if (r2.isNull(r5) == true) goto L17;
        r19 = r2.getString(r5);     // Catch: Throwable -> L35
        goto L22
    L13:
        if (r2.isNull(r4) == true) goto L11;
        r18 = r2.getString(r4);     // Catch: Throwable -> L35
        goto L16
    L9:
        r16 = r2.getLong(r0);     // Catch: Throwable -> L35
        goto L10
    L33:
        r2.close();
        return r9;
    L35:
        th = move-exception;
        r2.close();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryRawDbDao
    public List<com.obric.memorydata.database.model.b> rawQuerySourceNumberContentCandidates(SupportSQLiteQuery r20) {
        SupportSQLiteQuery r1 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r20, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndex(r2, "rawDbId");     // Catch: Throwable -> L29
        int r3 = CursorUtil.getColumnIndex(r2, "entityId");     // Catch: Throwable -> L29
        int r4 = CursorUtil.getColumnIndex(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L29
        int r5 = CursorUtil.getColumnIndex(r2, "expectedTimestamp");     // Catch: Throwable -> L29
        ArrayList r6 = new ArrayList(r2.getCount());     // Catch: Throwable -> L29
    L4:
        if (r2.moveToNext() == false) goto L27;
        long r7 = 0;
        if (r0 != (-1)) goto L9;
        long r13 = 0;
    L10:
        if (r3 != (-1)) goto L13;
    L11:
        String r15 = null;
    L16:
        if (r4 != (-1)) goto L19;
    L17:
        String r16 = null;
    L22:
        if (r5 == (-1)) goto L25;
        r7 = r2.getLong(r5);     // Catch: Throwable -> L29
    L25:
        r6.add(new com.obric.memorydata.database.model.b(r13, r15, r16, r7));     // Catch: Throwable -> L29
        goto L4
    L19:
        if (r2.isNull(r4) == true) goto L17;
        r16 = r2.getString(r4);     // Catch: Throwable -> L29
        goto L22
    L13:
        if (r2.isNull(r3) == true) goto L11;
        r15 = r2.getString(r3);     // Catch: Throwable -> L29
        goto L16
    L9:
        r13 = r2.getLong(r0);     // Catch: Throwable -> L29
        goto L10
    L27:
        r2.close();
        return r6;
    L29:
        th = move-exception;
        r2.close();
        throw th;
    }

    public int update(fq r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawCallHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(Object r3) {
        return update((fq) ZeusTransformUtils.preCheckCast(r3, fq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<fq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawCallHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor updateByRawQuery(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        return this.__db.query(r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int updatePoisonLabelIfContentHashMatches(String r1, String r2, int r3, Integer r4) {
        return CallHistoryRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryRawDbDao
    public int updateSourceNumberForBackfill(long r1, String r3, String r4, String r5, int r6, long r7, int r9, long r10) {
        return CallHistoryRawDbDao.DefaultImpls.updateSourceNumberForBackfill(this, r1, r3, r4, r5, r6, r7, r9, r10);
    }
}
