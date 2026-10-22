package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.ae;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class BatteryStateDao_Impl implements BatteryStateDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ae> __deletionAdapterOfBatteryStateEntity;
    private final EntityInsertionAdapter<ae> __insertionAdapterOfBatteryStateEntity;
    private final EntityDeletionOrUpdateAdapter<ae> __updateAdapterOfBatteryStateEntity;

    public BatteryStateDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBatteryStateEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfBatteryStateEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfBatteryStateEntity = new AnonymousClass3(this, r2);
    }

    private ae __entityCursorConverter_comObricMemorydataDatabaseEntityBatteryStateEntity(Cursor r31) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r31, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "dataId");
        int r2 = CursorUtil.getColumnIndex(r0, "dataVersion");
        int r3 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r4 = CursorUtil.getColumnIndex(r0, "event");
        int r5 = CursorUtil.getColumnIndex(r0, "chargeType");
        int r6 = CursorUtil.getColumnIndex(r0, "level");
        int r7 = CursorUtil.getColumnIndex(r0, "temperature");
        int r8 = CursorUtil.getColumnIndex(r0, "isPowerConnect");
        int r9 = CursorUtil.getColumnIndex(r0, "isSaveMode");
        int r10 = CursorUtil.getColumnIndex(r0, "timeRemaining");
        int r11 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        boolean r12 = false;
        if (r1 != (-1)) goto L5;
        int r15 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        int r16 = 0;
    L10:
        if (r3 != (-1)) goto L12;
        long r17 = 0;
    L13:
        if (r4 != (-1)) goto L15;
        int r19 = 0;
    L16:
        if (r5 != (-1)) goto L18;
        int r20 = 0;
    L19:
        if (r6 != (-1)) goto L21;
        double r13 = 0.0d;
    L22:
        double r21 = r13;
        if (r7 != (-1)) goto L25;
        int r23 = 0;
    L27:
        if (r8 != (-1)) goto L30;
        boolean r24 = false;
    L34:
        if (r9 != (-1)) goto L37;
    L35:
        boolean r25 = r12;
        if (r10 != (-1)) goto L41;
        long r26 = 0;
    L42:
        if (r11 != (-1)) goto L44;
        long r28 = 0;
    L46:
        return new ae(r15, r16, r17, r19, r20, r21, r23, r24, r25, r26, r28);
    L44:
        r28 = r0.getLong(r11);
        goto L46
    L41:
        r26 = r0.getLong(r10);
        goto L42
    L37:
        if (r0.getInt(r9) == 0) goto L35;
        r12 = true;
        goto L35
    L30:
        if (r0.getInt(r8) == 0) goto L32;
        boolean r14 = true;
    L33:
        r24 = r14;
        goto L34
    L32:
        r14 = false;
        goto L33
    L25:
        r23 = r0.getInt(r7);
        goto L27
    L21:
        r13 = r0.getDouble(r6);
        goto L22
    L18:
        r20 = r0.getInt(r5);
        goto L19
    L15:
        r19 = r0.getInt(r4);
        goto L16
    L12:
        r17 = r0.getLong(r3);
        goto L13
    L8:
        r16 = r0.getInt(r2);
        goto L10
    L5:
        r15 = r0.getInt(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ae> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBatteryStateEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ae> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBatteryStateEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(ae r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBatteryStateEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(ae r3) {
        return delete2((ae) ZeusTransformUtils.preCheckCast(r3, ae.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return BatteryStateDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BatteryStateDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return BatteryStateDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(ae r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBatteryStateEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(ae r3) {
        return insert2((ae) ZeusTransformUtils.preCheckCast(r3, ae.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ae> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBatteryStateEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ae> queryAll() {
        return BatteryStateDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return BatteryStateDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ae queryById(long r1) {
        return BatteryStateDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ae queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ae> queryByIds(List<Long> r3) {
        return BatteryStateDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ae queryByUUID(String r1) {
        return BatteryStateDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ae queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BatteryStateDao
    public ae queryLastRecord(long r34, long r36) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawBatteryState WHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp DESC LIMIT 1", 2);
        r1.bindLong(1, r34);
        r1.bindLong(2, r36);
        this.__db.assertNotSuspendingTransaction();
        ae r4 = null;
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, "dataId");     // Catch: Throwable -> L16
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "dataVersion");     // Catch: Throwable -> L16
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L16
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "event");     // Catch: Throwable -> L16
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "chargeType");     // Catch: Throwable -> L16
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "level");     // Catch: Throwable -> L16
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "temperature");     // Catch: Throwable -> L16
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "isPowerConnect");     // Catch: Throwable -> L16
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "isSaveMode");     // Catch: Throwable -> L16
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "timeRemaining");     // Catch: Throwable -> L16
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L16
        if (r5.moveToFirst() == false) goto L14;
        int r18 = r5.getInt(r0);     // Catch: Throwable -> L16
        int r19 = r5.getInt(r6);     // Catch: Throwable -> L16
        long r20 = r5.getLong(r7);     // Catch: Throwable -> L16
        int r22 = r5.getInt(r8);     // Catch: Throwable -> L16
        int r23 = r5.getInt(r9);     // Catch: Throwable -> L16
        double r24 = r5.getDouble(r10);     // Catch: Throwable -> L16
        int r26 = r5.getInt(r11);     // Catch: Throwable -> L16
        if (r5.getInt(r12) == 0) goto L8;
        boolean r27 = true;
    L10:
        if (r5.getInt(r13) == 0) goto L12;
        boolean r28 = true;
    L13:
        r4 = new ae(r18, r19, r20, r22, r23, r24, r26, r27, r28, r5.getLong(r14), r5.getLong(r15));     // Catch: Throwable -> L16
        goto L14
    L12:
        r28 = false;
        goto L13
    L8:
        r27 = false;
    L14:
        r5.close();
        r1.release();
        return r4;
    L16:
        th = move-exception;
        r5.close();
        r1.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ae queryOne() {
        return BatteryStateDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ae queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ae> queryWithLimitAndOffset(int r1, int r2) {
        return BatteryStateDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ae> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityBatteryStateEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(ae r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBatteryStateEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(ae r3) {
        return update2((ae) ZeusTransformUtils.preCheckCast(r3, ae.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ae> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBatteryStateEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
