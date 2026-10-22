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
import com.obric.memorydata.database.entity.aj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class CellInfoDao_Impl implements CellInfoDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<aj> __deletionAdapterOfCellInfoEntity;
    private final EntityInsertionAdapter<aj> __insertionAdapterOfCellInfoEntity;
    private final EntityDeletionOrUpdateAdapter<aj> __updateAdapterOfCellInfoEntity;

    public CellInfoDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfCellInfoEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfCellInfoEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfCellInfoEntity = new AnonymousClass3(this, r2);
    }

    private aj __entityCursorConverter_comObricMemorydataDatabaseEntityCellInfoEntity(Cursor r37) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r37, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "uniqueId");
        int r2 = CursorUtil.getColumnIndex(r0, "cellId");
        int r3 = CursorUtil.getColumnIndex(r0, "pci");
        int r4 = CursorUtil.getColumnIndex(r0, "tac");
        int r5 = CursorUtil.getColumnIndex(r0, "arfcn");
        int r6 = CursorUtil.getColumnIndex(r0, "bands");
        int r7 = CursorUtil.getColumnIndex(r0, "level");
        int r8 = CursorUtil.getColumnIndex(r0, "signalQuality");
        int r9 = CursorUtil.getColumnIndex(r0, "signalStrength");
        int r10 = CursorUtil.getColumnIndex(r0, "mcc");
        int r11 = CursorUtil.getColumnIndex(r0, "mnc");
        int r12 = CursorUtil.getColumnIndex(r0, "standard");
        int r13 = CursorUtil.getColumnIndex(r0, "registered");
        int r14 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r15 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        String r16 = null;
        if (r1 != (-1)) goto L6;
    L4:
        String r18 = null;
    L10:
        if (r2 != (-1)) goto L12;
        long r17 = 0;
    L13:
        boolean r19 = false;
        if (r3 != (-1)) goto L16;
        int r21 = 0;
    L17:
        if (r4 != (-1)) goto L19;
        int r22 = 0;
    L20:
        if (r5 != (-1)) goto L22;
        int r23 = 0;
    L23:
        if (r6 != (-1)) goto L26;
    L24:
        String r24 = null;
    L29:
        if (r7 != (-1)) goto L31;
        int r25 = 0;
    L32:
        if (r8 != (-1)) goto L34;
        int r26 = 0;
    L35:
        if (r9 != (-1)) goto L37;
        int r27 = 0;
    L38:
        if (r10 != (-1)) goto L41;
    L39:
        String r28 = null;
    L44:
        if (r11 != (-1)) goto L47;
    L45:
        String r29 = null;
    L50:
        if (r12 != (-1)) goto L53;
    L51:
        String r30 = r16;
        if (r13 != (-1)) goto L59;
    L57:
        boolean r31 = r19;
        if (r14 != (-1)) goto L63;
        long r32 = 0;
    L64:
        if (r36 != (-1)) goto L66;
        long r34 = 0;
    L68:
        return new aj(r18, r17, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r34);
    L66:
        r34 = r0.getLong(r15);
        goto L68
    L63:
        r32 = r0.getLong(r14);
        goto L64
    L59:
        if (r0.getInt(r13) == 0) goto L57;
        r19 = true;
        goto L57
    L53:
        if (r0.isNull(r12) == true) goto L51;
        r16 = r0.getString(r12);
        goto L51
    L47:
        if (r0.isNull(r11) == true) goto L45;
        r29 = r0.getString(r11);
        goto L50
    L41:
        if (r0.isNull(r10) == true) goto L39;
        r28 = r0.getString(r10);
        goto L44
    L37:
        r27 = r0.getInt(r9);
        goto L38
    L34:
        r26 = r0.getInt(r8);
        goto L35
    L31:
        r25 = r0.getInt(r7);
        goto L32
    L26:
        if (r0.isNull(r6) == true) goto L24;
        r24 = r0.getString(r6);
        goto L29
    L22:
        r23 = r0.getInt(r5);
        goto L23
    L19:
        r22 = r0.getInt(r4);
        goto L20
    L16:
        r21 = r0.getInt(r3);
        goto L17
    L12:
        r17 = r0.getLong(r2);
        goto L13
    L6:
        if (r0.isNull(r1) == true) goto L4;
        r18 = r0.getString(r1);
        goto L10
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<aj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfCellInfoEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<aj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfCellInfoEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(aj r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfCellInfoEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(aj r3) {
        return delete2((aj) ZeusTransformUtils.preCheckCast(r3, aj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return CellInfoDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.CellInfoDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return CellInfoDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(aj r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfCellInfoEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(aj r3) {
        return insert2((aj) ZeusTransformUtils.preCheckCast(r3, aj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<aj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfCellInfoEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aj> queryAll() {
        return CellInfoDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return CellInfoDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public aj queryById(long r1) {
        return CellInfoDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ aj queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aj> queryByIds(List<Long> r3) {
        return CellInfoDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public aj queryByUUID(String r1) {
        return CellInfoDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ aj queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.CellInfoDao
    public aj queryByUniqueId(String r37) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM cell_info WHERE uniqueId = ? LIMIT 1", 1);
        if (r37 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, "uniqueId");     // Catch: Throwable -> L42
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "cellId");     // Catch: Throwable -> L42
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "pci");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "tac");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "arfcn");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "bands");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "level");     // Catch: Throwable -> L42
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "signalQuality");     // Catch: Throwable -> L42
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "signalStrength");     // Catch: Throwable -> L42
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "mcc");     // Catch: Throwable -> L42
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "mnc");     // Catch: Throwable -> L42
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "standard");     // Catch: Throwable -> L42
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "registered");     // Catch: Throwable -> L42
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L42
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L40
        if (r5.moveToFirst() == true) goto L12;
        aj r18 = null;
    L38:
        r5.close();
        r16.release();
        return r18;
    L12:
        if (r5.isNull(r0) == false) goto L14;
        String r19 = null;
    L15:
        long r110 = r5.getLong(r6);     // Catch: Throwable -> L40
        int r21 = r5.getInt(r7);     // Catch: Throwable -> L40
        int r22 = r5.getInt(r8);     // Catch: Throwable -> L40
        int r23 = r5.getInt(r9);     // Catch: Throwable -> L40
        if (r5.isNull(r10) == false) goto L18;
        String r24 = null;
    L19:
        int r25 = r5.getInt(r11);     // Catch: Throwable -> L40
        int r26 = r5.getInt(r12);     // Catch: Throwable -> L40
        int r27 = r5.getInt(r13);     // Catch: Throwable -> L40
        if (r5.isNull(r14) == false) goto L22;
        String r28 = null;
    L24:
        if (r5.isNull(r15) == false) goto L26;
        String r29 = null;
    L28:
        if (r5.isNull(r1) == false) goto L30;
        String r30 = null;
    L32:
        if (r5.getInt(r3) == 0) goto L34;
        boolean r31 = true;
    L35:
        r18 = new aj(r19, r110, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r5.getLong(r4), r5.getLong(r17));     // Catch: Throwable -> L40
        goto L38
    L34:
        r31 = false;
        goto L35
    L30:
        r30 = r5.getString(r1);     // Catch: Throwable -> L40
        goto L32
    L26:
        r29 = r5.getString(r15);     // Catch: Throwable -> L40
        goto L28
    L22:
        r28 = r5.getString(r14);     // Catch: Throwable -> L40
        goto L24
    L18:
        r24 = r5.getString(r10);     // Catch: Throwable -> L40
        goto L19
    L14:
        r19 = r5.getString(r0);     // Catch: Throwable -> L40
    L40:
        th = th;
    L44:
        r5.close();
        r16.release();
        throw th;
    L42:
        th = th;
        r16 = r2;
        goto L44
    L5:
        r2.bindString(1, r37);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public aj queryOne() {
        return CellInfoDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ aj queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aj> queryWithLimitAndOffset(int r1, int r2) {
        return CellInfoDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aj> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityCellInfoEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(aj r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfCellInfoEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(aj r3) {
        return update2((aj) ZeusTransformUtils.preCheckCast(r3, aj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<aj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfCellInfoEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
