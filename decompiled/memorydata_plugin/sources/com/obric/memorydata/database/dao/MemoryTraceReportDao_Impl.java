package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.dh;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryTraceReportDao_Impl implements MemoryTraceReportDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<dh> __deletionAdapterOfMemoryTraceReportEntity;
    private final EntityInsertionAdapter<dh> __insertionAdapterOfMemoryTraceReportEntity;
    private final SharedSQLiteStatement __preparedStmtOfClaimForUpload;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;
    private final SharedSQLiteStatement __preparedStmtOfDeleteOversizedReportData;
    private final SharedSQLiteStatement __preparedStmtOfDeleteOversizedReportDataByLogId;
    private final SharedSQLiteStatement __preparedStmtOfMarkTriggeredByLogId;
    private final SharedSQLiteStatement __preparedStmtOfUpdateMergedTriggered;
    private final SharedSQLiteStatement __preparedStmtOfUpdateReportResult;
    private final EntityDeletionOrUpdateAdapter<dh> __updateAdapterOfMemoryTraceReportEntity;

    public MemoryTraceReportDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryTraceReportEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfMemoryTraceReportEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfMemoryTraceReportEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteAll = new AnonymousClass4(this, r2);
        this.__preparedStmtOfMarkTriggeredByLogId = new AnonymousClass5(this, r2);
        this.__preparedStmtOfClaimForUpload = new AnonymousClass6(this, r2);
        this.__preparedStmtOfUpdateMergedTriggered = new AnonymousClass7(this, r2);
        this.__preparedStmtOfUpdateReportResult = new AnonymousClass8(this, r2);
        this.__preparedStmtOfDeleteById = new AnonymousClass9(this, r2);
        this.__preparedStmtOfDeleteOversizedReportData = new AnonymousClass10(this, r2);
        this.__preparedStmtOfDeleteOversizedReportDataByLogId = new AnonymousClass11(this, r2);
    }

    private dh __entityCursorConverter_comObricMemorydataDatabaseEntityMemoryTraceReportEntity(Cursor r24) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r24, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "log_id");
        int r3 = CursorUtil.getColumnIndex(r0, "report_data");
        int r4 = CursorUtil.getColumnIndex(r0, "last_report_time");
        int r5 = CursorUtil.getColumnIndex(r0, "is_triggered_report");
        int r6 = CursorUtil.getColumnIndex(r0, "report_status");
        int r7 = CursorUtil.getColumnIndex(r0, "last_error");
        long r8 = 0;
        if (r1 != (-1)) goto L5;
        long r14 = 0;
    L7:
        if (r2 != (-1)) goto L10;
    L8:
        String r16 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r17 = null;
    L19:
        if (r4 == (-1)) goto L22;
        r8 = r0.getLong(r4);
    L22:
        long r18 = r8;
        boolean r9 = false;
        if (r5 != (-1)) goto L26;
    L24:
        boolean r20 = r9;
        if (r6 != (-1)) goto L31;
    L29:
        String r21 = null;
    L34:
        if (r7 != (-1)) goto L37;
    L35:
        String r22 = null;
    L41:
        return new dh(r14, r16, r17, r18, r20, r21, r22);
    L37:
        if (r0.isNull(r7) == true) goto L35;
        r22 = r0.getString(r7);
        goto L41
    L31:
        if (r0.isNull(r6) == true) goto L29;
        r21 = r0.getString(r6);
        goto L34
    L26:
        if (r0.getInt(r5) == 0) goto L24;
        r9 = true;
        goto L24
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r17 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r16 = r0.getString(r2);
        goto L13
    L5:
        r14 = r0.getLong(r1);
        goto L7
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<dh> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMemoryTraceReportEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao, com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<dh> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMemoryTraceReportEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao
    public int claimForUpload(long r3, String r5, long r6, String r8, long r9) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfClaimForUpload.acquire();
        if (r8 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r9);
        r0.bindLong(3, r3);
        if (r5 != null) goto L9;
        r0.bindNull(4);
    L10:
        r0.bindLong(5, r6);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfClaimForUpload.release(r0);
        return r4;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfClaimForUpload.release(r0);
        throw th;
    L9:
        r0.bindString(4, r5);
        goto L10
    L5:
        r0.bindString(1, r8);
        goto L6
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(dh r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMemoryTraceReportEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(dh r3) {
        return delete2((dh) ZeusTransformUtils.preCheckCast(r3, dh.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao, com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao
    public int deleteById(long r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteById.acquire();
        r0.bindLong(1, r3);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteById.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteById.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao
    public int deleteByIds(List<Long> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM MemoryTraceReport WHERE id IN (");
        StringUtil.appendPlaceholders(r0, r8.size());
        r0.append(")");
        SupportSQLiteStatement r1 = this.__db.compileStatement(r0.toString());
        Iterator r9 = r8.iterator();
        int r3 = 1;
    L4:
        if (r9.hasNext() == false) goto L6;
        r1.bindLong(r3, ((Long) ZeusTransformUtils.preCheckCast(r9.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r3 = r3 + 1;
        goto L4
    L6:
        this.__db.beginTransaction();
        int r10 = r1.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        return r10;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao
    public int deleteOversizedReportData(int r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteOversizedReportData.acquire();
        r0.bindLong(1, r4);
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteOversizedReportData.release(r0);
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteOversizedReportData.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao
    public int deleteOversizedReportDataByLogId(String r4, int r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteOversizedReportDataByLogId.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r5);
        this.__db.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteOversizedReportDataByLogId.release(r0);
        return r6;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteOversizedReportDataByLogId.release(r0);
        throw th;
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MemoryTraceReportDao.DefaultImpls.getTableName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao
    public long insert(dh r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryTraceReportEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(dh r3) {
        return insert((dh) ZeusTransformUtils.preCheckCast(r3, dh.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao, com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<dh> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryTraceReportEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao
    public int markTriggeredByLogId(String r3, String r4, String r5, long r6) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfMarkTriggeredByLogId.acquire();
        r0.bindLong(1, r6);
        if (r3 != null) goto L5;
        r0.bindNull(2);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(3);
    L11:
        if (r5 != null) goto L13;
        r0.bindNull(4);
    L14:
        this.__db.beginTransaction();
        int r7 = r0.executeUpdateDelete();     // Catch: Throwable -> L18
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L18
        this.__db.endTransaction();
        this.__preparedStmtOfMarkTriggeredByLogId.release(r0);
        return r7;
    L18:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfMarkTriggeredByLogId.release(r0);
        throw th;
    L13:
        r0.bindString(4, r5);
        goto L14
    L9:
        r0.bindString(3, r4);
        goto L11
    L5:
        r0.bindString(2, r3);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dh> queryAll() {
        return MemoryTraceReportDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MemoryTraceReportDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dh queryById(long r1) {
        return MemoryTraceReportDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dh queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dh> queryByIds(List<Long> r3) {
        return MemoryTraceReportDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dh queryByUUID(String r1) {
        return MemoryTraceReportDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dh queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dh queryOne() {
        return MemoryTraceReportDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dh queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao
    public List<dh> queryTriggeredPending(String r25, String r26, long r27, long r29, int r31) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryTraceReport WHERE is_triggered_report = 1 AND report_status != ? AND ((report_status = ? AND last_report_time <= ?) OR (report_status != ? AND last_report_time <= ?)) ORDER BY last_report_time DESC, id DESC LIMIT ?", 6);
        if (r25 != null) goto L5;
        r3.bindNull(1);
    L7:
        if (r26 != null) goto L9;
        r3.bindNull(2);
    L10:
        r3.bindLong(3, r27);
        if (r26 != null) goto L13;
        r3.bindNull(4);
    L14:
        r3.bindLong(5, r29);
        r3.bindLong(6, r31);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L42
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "log_id");     // Catch: Throwable -> L42
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "report_data");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "last_report_time");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "is_triggered_report");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "report_status");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "last_error");     // Catch: Throwable -> L42
        ArrayList r12 = new ArrayList(r4.getCount());     // Catch: Throwable -> L42
    L16:
        if (r4.moveToNext() == false) goto L40;
        long r15 = r4.getLong(r0);     // Catch: Throwable -> L42
        if (r4.isNull(r6) == false) goto L21;
        String r17 = null;
    L23:
        if (r4.isNull(r7) == false) goto L25;
        String r18 = null;
    L26:
        long r19 = r4.getLong(r8);     // Catch: Throwable -> L42
        if (r4.getInt(r9) == 0) goto L29;
        boolean r21 = true;
    L31:
        if (r4.isNull(r10) == false) goto L33;
        String r22 = null;
    L35:
        if (r4.isNull(r11) == false) goto L37;
        String r23 = null;
    L38:
        r12.add(new dh(r15, r17, r18, r19, r21, r22, r23));     // Catch: Throwable -> L42
        goto L16
    L37:
        r23 = r4.getString(r11);     // Catch: Throwable -> L42
        goto L38
    L33:
        r22 = r4.getString(r10);     // Catch: Throwable -> L42
        goto L35
    L29:
        r21 = false;
        goto L31
    L25:
        r18 = r4.getString(r7);     // Catch: Throwable -> L42
        goto L26
    L21:
        r17 = r4.getString(r6);     // Catch: Throwable -> L42
        goto L23
    L40:
        r4.close();
        r3.release();
        return r12;
    L42:
        th = move-exception;
        r4.close();
        r3.release();
        throw th;
    L13:
        r3.bindString(4, r26);
        goto L14
    L9:
        r3.bindString(2, r26);
        goto L10
    L5:
        r3.bindString(1, r25);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao
    public List<dh> queryUnfinishedByLogId(String r25, String r26, String r27) {
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryTraceReport WHERE log_id = ? AND report_status != ? AND report_status != ? ORDER BY last_report_time ASC, id ASC", 3);
        if (r25 != null) goto L5;
        r4.bindNull(1);
    L7:
        if (r26 != null) goto L9;
        r4.bindNull(2);
    L10:
        if (r27 != null) goto L12;
        r4.bindNull(3);
    L13:
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r4, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r3, OaidModel.KEY_ID);     // Catch: Throwable -> L41
        int r5 = CursorUtil.getColumnIndexOrThrow(r3, "log_id");     // Catch: Throwable -> L41
        int r7 = CursorUtil.getColumnIndexOrThrow(r3, "report_data");     // Catch: Throwable -> L41
        int r8 = CursorUtil.getColumnIndexOrThrow(r3, "last_report_time");     // Catch: Throwable -> L41
        int r9 = CursorUtil.getColumnIndexOrThrow(r3, "is_triggered_report");     // Catch: Throwable -> L41
        int r10 = CursorUtil.getColumnIndexOrThrow(r3, "report_status");     // Catch: Throwable -> L41
        int r11 = CursorUtil.getColumnIndexOrThrow(r3, "last_error");     // Catch: Throwable -> L41
        ArrayList r12 = new ArrayList(r3.getCount());     // Catch: Throwable -> L41
    L15:
        if (r3.moveToNext() == false) goto L39;
        long r15 = r3.getLong(r0);     // Catch: Throwable -> L41
        if (r3.isNull(r5) == false) goto L20;
        String r17 = null;
    L22:
        if (r3.isNull(r7) == false) goto L24;
        String r18 = null;
    L25:
        long r19 = r3.getLong(r8);     // Catch: Throwable -> L41
        if (r3.getInt(r9) == 0) goto L28;
        boolean r21 = true;
    L30:
        if (r3.isNull(r10) == false) goto L32;
        String r22 = null;
    L34:
        if (r3.isNull(r11) == false) goto L36;
        String r23 = null;
    L37:
        r12.add(new dh(r15, r17, r18, r19, r21, r22, r23));     // Catch: Throwable -> L41
        goto L15
    L36:
        r23 = r3.getString(r11);     // Catch: Throwable -> L41
        goto L37
    L32:
        r22 = r3.getString(r10);     // Catch: Throwable -> L41
        goto L34
    L28:
        r21 = false;
        goto L30
    L24:
        r18 = r3.getString(r7);     // Catch: Throwable -> L41
        goto L25
    L20:
        r17 = r3.getString(r5);     // Catch: Throwable -> L41
        goto L22
    L39:
        r3.close();
        r4.release();
        return r12;
    L41:
        th = move-exception;
        r3.close();
        r4.release();
        throw th;
    L12:
        r4.bindString(3, r27);
        goto L13
    L9:
        r4.bindString(2, r26);
        goto L10
    L5:
        r4.bindString(1, r25);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dh> queryWithLimitAndOffset(int r1, int r2) {
        return MemoryTraceReportDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dh> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityMemoryTraceReportEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(dh r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMemoryTraceReportEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(dh r3) {
        return update2((dh) ZeusTransformUtils.preCheckCast(r3, dh.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<dh> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMemoryTraceReportEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao
    public int updateMergedTriggered(long r3, String r5, String r6, long r7) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateMergedTriggered.acquire();
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r6 != null) goto L9;
        r0.bindNull(2);
    L10:
        r0.bindLong(3, r7);
        r0.bindLong(4, r3);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateMergedTriggered.release(r0);
        return r4;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateMergedTriggered.release(r0);
        throw th;
    L9:
        r0.bindString(2, r6);
        goto L10
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryTraceReportDao
    public int updateReportResult(long r3, String r5, String r6, long r7) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateReportResult.acquire();
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r6 != null) goto L9;
        r0.bindNull(2);
    L10:
        r0.bindLong(3, r7);
        r0.bindLong(4, r3);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateReportResult.release(r0);
        return r4;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateReportResult.release(r0);
        throw th;
    L9:
        r0.bindString(2, r6);
        goto L10
    L5:
        r0.bindString(1, r5);
        goto L7
    }
}
