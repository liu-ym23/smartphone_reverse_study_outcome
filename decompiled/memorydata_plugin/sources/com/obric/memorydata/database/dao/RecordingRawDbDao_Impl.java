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
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.hh;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class RecordingRawDbDao_Impl implements RecordingRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<hh> __deletionAdapterOfRawRecordingEntity;
    private final EntityInsertionAdapter<hh> __insertionAdapterOfRawRecordingEntity;
    private final EntityDeletionOrUpdateAdapter<hh> __updateAdapterOfRawRecordingEntity;

    public RecordingRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawRecordingEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawRecordingEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawRecordingEntity = new AnonymousClass3(this, r2);
    }

    private hh __entityCursorConverter_comObricMemorydataDatabaseEntityRawRecordingEntity(Cursor r57) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r57, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, ActivityLifecycle.NAME);
        int r10 = CursorUtil.getColumnIndex(r0, "file");
        int r11 = CursorUtil.getColumnIndex(r0, "duration");
        int r12 = CursorUtil.getColumnIndex(r0, "transcript");
        int r13 = CursorUtil.getColumnIndex(r0, "summary");
        int r14 = CursorUtil.getColumnIndex(r0, "contentWithTime");
        int r15 = CursorUtil.getColumnIndex(r0, "todoList");
        int r16 = CursorUtil.getColumnIndex(r0, "markers");
        int r17 = CursorUtil.getColumnIndex(r0, "sourceAppName");
        int r18 = CursorUtil.getColumnIndex(r0, "sourceAppPackage");
        int r19 = CursorUtil.getColumnIndex(r0, "fullContent");
        int r110 = CursorUtil.getColumnIndex(r0, "docNodeJson");
        int r111 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r112 = CursorUtil.getColumnIndex(r0, "sourceDevice");
        int r113 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r114 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r115 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r24 = 0;
        if (r1 != (-1)) goto L5;
        long r30 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r32 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r33 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r35 = 0;
    L19:
        int r21 = 0;
        if (r5 != (-1)) goto L22;
        int r37 = 0;
    L23:
        if (r6 == (-1)) goto L26;
        r24 = r0.getLong(r6);
    L26:
        long r38 = r24;
        if (r7 != (-1)) goto L30;
    L28:
        String r40 = null;
    L33:
        if (r8 != (-1)) goto L35;
        int r41 = 0;
    L36:
        if (r9 != (-1)) goto L39;
    L37:
        String r42 = null;
    L42:
        if (r10 != (-1)) goto L45;
    L43:
        String r43 = null;
    L48:
        if (r11 == (-1)) goto L51;
        r21 = r0.getInt(r11);
    L51:
        int r44 = r21;
        if (r12 != (-1)) goto L55;
    L53:
        String r45 = null;
    L58:
        if (r13 != (-1)) goto L61;
    L59:
        String r46 = null;
    L64:
        if (r14 != (-1)) goto L67;
    L65:
        String r47 = null;
    L70:
        if (r56 != (-1)) goto L73;
    L71:
        String r48 = null;
    L76:
        if (r57 != (-1)) goto L80;
    L77:
        String r49 = null;
    L83:
        if (r17 != (-1)) goto L87;
    L84:
        String r50 = null;
    L90:
        if (r18 != (-1)) goto L94;
    L91:
        String r51 = null;
    L97:
        if (r19 != (-1)) goto L101;
    L98:
        String r52 = null;
    L104:
        if (r110 != (-1)) goto L108;
    L105:
        String r53 = null;
    L111:
        if (r111 != (-1)) goto L115;
    L112:
        String r54 = null;
    L118:
        if (r112 != (-1)) goto L121;
    L119:
        String r55 = null;
    L124:
        hh r22 = new hh(r30, r32, r33, r35, r37, r38, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55);
        if (r113 == (-1)) goto L132;
        if (r0.isNull(r113) == false) goto L129;
        Integer r23 = null;
    L130:
        r22.setPoisonLabel(r23);
        goto L132
    L129:
        r23 = Integer.valueOf(r0.getInt(r113));
    L132:
        if (r114 == (-1)) goto L139;
        if (r0.isNull(r114) == false) goto L136;
        Integer r25 = null;
    L137:
        r22.setPoisonLabelVersion(r25);
        goto L139
    L136:
        r25 = Integer.valueOf(r0.getInt(r114));
    L139:
        if (r115 != (-1)) goto L141;
    L145:
        return r22;
    L141:
        if (r0.isNull(r115) == true) goto L144;
        r20 = r0.getString(r115);
    L144:
        r22.setContentHash(r20);
        goto L145
    L121:
        if (r0.isNull(r112) == true) goto L119;
        r55 = r0.getString(r112);
        goto L124
    L115:
        if (r0.isNull(r111) == true) goto L112;
        r54 = r0.getString(r111);
        goto L118
    L108:
        if (r0.isNull(r110) == true) goto L105;
        r53 = r0.getString(r110);
        goto L111
    L101:
        if (r0.isNull(r19) == true) goto L98;
        r52 = r0.getString(r19);
        goto L104
    L94:
        if (r0.isNull(r18) == true) goto L91;
        r51 = r0.getString(r18);
        goto L97
    L87:
        if (r0.isNull(r17) == true) goto L84;
        r50 = r0.getString(r17);
        goto L90
    L80:
        if (r0.isNull(r57) == true) goto L77;
        r49 = r0.getString(r16);
        goto L83
    L73:
        if (r0.isNull(r56) == true) goto L71;
        r48 = r0.getString(r15);
        goto L76
    L67:
        if (r0.isNull(r14) == true) goto L65;
        r47 = r0.getString(r14);
        goto L70
    L61:
        if (r0.isNull(r13) == true) goto L59;
        r46 = r0.getString(r13);
        goto L64
    L55:
        if (r0.isNull(r12) == true) goto L53;
        r45 = r0.getString(r12);
        goto L58
    L45:
        if (r0.isNull(r10) == true) goto L43;
        r43 = r0.getString(r10);
        goto L48
    L39:
        if (r0.isNull(r9) == true) goto L37;
        r42 = r0.getString(r9);
        goto L42
    L35:
        r41 = r0.getInt(r8);
        goto L36
    L30:
        if (r0.isNull(r7) == true) goto L28;
        r40 = r0.getString(r7);
        goto L33
    L22:
        r37 = r0.getInt(r5);
        goto L23
    L18:
        r35 = r0.getLong(r4);
        goto L19
    L15:
        r33 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r32 = r0.getString(r2);
        goto L13
    L5:
        r30 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return RecordingRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<hh> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawRecordingEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<hh> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawRecordingEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
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

    public int delete(hh r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawRecordingEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((hh) ZeusTransformUtils.preCheckCast(r3, hh.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return RecordingRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return RecordingRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
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
        return RecordingRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return RecordingRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return RecordingRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
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
        return RecordingRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return RecordingRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
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
        return RecordingRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.RecordingRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return RecordingRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(hh r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawRecordingEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((hh) ZeusTransformUtils.preCheckCast(r3, hh.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<hh> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawRecordingEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hh> queryAll() {
        return RecordingRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return RecordingRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hh> queryByEntityId(String r1, String r2) {
        return RecordingRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hh> queryByEntityIdList(List<String> r3) {
        return RecordingRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hh> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return RecordingRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hh queryById(long r1) {
        return RecordingRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hh> queryByIdAndTimestamp(long r1, long r3) {
        return RecordingRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hh> queryByIds(List<Long> r3) {
        return RecordingRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return RecordingRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hh> queryByPackageName(String r1) {
        return RecordingRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hh> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return RecordingRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hh> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return RecordingRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hh queryByUUID(String r1) {
        return RecordingRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.RecordingRawDbDao
    public Cursor queryOldDataForContentTimeIndexPending() {
        return RecordingRawDbDao.DefaultImpls.queryOldDataForContentTimeIndexPending(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hh queryOne() {
        return RecordingRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hh> queryRecentByPackageName(String r1, long r2) {
        return RecordingRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hh> queryWithLimitAndOffset(int r1, int r2) {
        return RecordingRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hh> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawRecordingEntity(r6));     // Catch: Throwable -> L10
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

    public int update(hh r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawRecordingEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((hh) ZeusTransformUtils.preCheckCast(r3, hh.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<hh> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawRecordingEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return RecordingRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
