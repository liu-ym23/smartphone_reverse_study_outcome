package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.dp;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MobileCellularDao_Impl implements MobileCellularDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<dp> __deletionAdapterOfMobileCellularEntity;
    private final EntityInsertionAdapter<dp> __insertionAdapterOfMobileCellularEntity;
    private final EntityDeletionOrUpdateAdapter<dp> __updateAdapterOfMobileCellularEntity;

    public MobileCellularDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMobileCellularEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfMobileCellularEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfMobileCellularEntity = new AnonymousClass3(this, r2);
    }

    private dp __entityCursorConverter_comObricMemorydataDatabaseEntityMobileCellularEntity(Cursor r34) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r34, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "dataId");
        int r2 = CursorUtil.getColumnIndex(r0, "dataVersion");
        int r3 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r4 = CursorUtil.getColumnIndex(r0, "cellId");
        int r5 = CursorUtil.getColumnIndex(r0, "lac");
        int r6 = CursorUtil.getColumnIndex(r0, "cellType");
        int r7 = CursorUtil.getColumnIndex(r0, "rsrp");
        int r8 = CursorUtil.getColumnIndex(r0, "pci");
        int r9 = CursorUtil.getColumnIndex(r0, "carrierMcc");
        int r10 = CursorUtil.getColumnIndex(r0, "carrierMnc");
        int r11 = CursorUtil.getColumnIndex(r0, "carrierOperator");
        int r12 = CursorUtil.getColumnIndex(r0, "carrierShortOperator");
        int r13 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r14 = 0;
        if (r1 != (-1)) goto L5;
        int r17 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        int r18 = 0;
    L10:
        if (r3 != (-1)) goto L12;
        long r19 = 0;
    L13:
        if (r4 != (-1)) goto L15;
        long r21 = 0;
    L16:
        if (r5 != (-1)) goto L18;
        int r23 = 0;
    L19:
        String r15 = null;
        if (r6 != (-1)) goto L23;
    L21:
        String r24 = null;
    L26:
        if (r7 != (-1)) goto L28;
        int r25 = 0;
    L29:
        if (r8 == (-1)) goto L32;
        r14 = r0.getInt(r8);
    L32:
        int r26 = r14;
        if (r9 != (-1)) goto L36;
    L34:
        String r27 = null;
    L39:
        if (r10 != (-1)) goto L42;
    L40:
        String r28 = null;
    L45:
        if (r11 != (-1)) goto L48;
    L46:
        String r29 = null;
    L51:
        if (r12 != (-1)) goto L54;
    L52:
        String r30 = r15;
        if (r13 != (-1)) goto L59;
        long r31 = 0;
    L61:
        return new dp(r17, r18, r19, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31);
    L59:
        r31 = r0.getLong(r13);
        goto L61
    L54:
        if (r0.isNull(r12) == true) goto L52;
        r15 = r0.getString(r12);
        goto L52
    L48:
        if (r0.isNull(r11) == true) goto L46;
        r29 = r0.getString(r11);
        goto L51
    L42:
        if (r0.isNull(r10) == true) goto L40;
        r28 = r0.getString(r10);
        goto L45
    L36:
        if (r0.isNull(r9) == true) goto L34;
        r27 = r0.getString(r9);
        goto L39
    L28:
        r25 = r0.getInt(r7);
        goto L29
    L23:
        if (r0.isNull(r6) == true) goto L21;
        r24 = r0.getString(r6);
        goto L26
    L18:
        r23 = r0.getInt(r5);
        goto L19
    L15:
        r21 = r0.getLong(r4);
        goto L16
    L12:
        r19 = r0.getLong(r3);
        goto L13
    L8:
        r18 = r0.getInt(r2);
        goto L10
    L5:
        r17 = r0.getInt(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<dp> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMobileCellularEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<dp> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMobileCellularEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(dp r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMobileCellularEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(dp r3) {
        return delete2((dp) ZeusTransformUtils.preCheckCast(r3, dp.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return MobileCellularDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.MobileCellularDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MobileCellularDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(dp r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMobileCellularEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(dp r3) {
        return insert2((dp) ZeusTransformUtils.preCheckCast(r3, dp.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<dp> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMobileCellularEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dp> queryAll() {
        return MobileCellularDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MobileCellularDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dp queryById(long r1) {
        return MobileCellularDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dp queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dp> queryByIds(List<Long> r3) {
        return MobileCellularDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dp queryByUUID(String r1) {
        return MobileCellularDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dp queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dp queryOne() {
        return MobileCellularDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dp queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dp> queryWithLimitAndOffset(int r1, int r2) {
        return MobileCellularDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dp> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityMobileCellularEntity(r6));     // Catch: Throwable -> L10
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

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public int update2(dp r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMobileCellularEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(dp r3) {
        return update2((dp) ZeusTransformUtils.preCheckCast(r3, dp.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<dp> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMobileCellularEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
