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
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.database.entity.cd;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class IndexPendingDao_PersonalMemoryFrameDb_Impl implements IndexPendingDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<cd> __deletionAdapterOfIndexPendingEntity;
    private final EntityInsertionAdapter<cd> __insertionAdapterOfIndexPendingEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllByEntityTypeAndBuildType;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByColumnContent;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByIdAndTimestamp;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByRawDb;
    private final SharedSQLiteStatement __preparedStmtOfDeleteForExecutionSettlement;
    private final SharedSQLiteStatement __preparedStmtOfUpdateRetrySchedule;
    private final EntityDeletionOrUpdateAdapter<cd> __updateAdapterOfIndexPendingEntity;

    public IndexPendingDao_PersonalMemoryFrameDb_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfIndexPendingEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfIndexPendingEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfIndexPendingEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteByColumnContent = new AnonymousClass4(this, r2);
        this.__preparedStmtOfDeleteAllByEntityTypeAndBuildType = new AnonymousClass5(this, r2);
        this.__preparedStmtOfDeleteByRawDb = new AnonymousClass6(this, r2);
        this.__preparedStmtOfDeleteById = new AnonymousClass7(this, r2);
        this.__preparedStmtOfDeleteByIdAndTimestamp = new AnonymousClass8(this, r2);
        this.__preparedStmtOfDeleteForExecutionSettlement = new AnonymousClass9(this, r2);
        this.__preparedStmtOfUpdateRetrySchedule = new AnonymousClass10(this, r2);
    }

    private cd __entityCursorConverter_comObricMemorydataDatabaseEntityIndexPendingEntity(Cursor r42) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r42, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "rawDbId");
        int r3 = CursorUtil.getColumnIndex(r0, "entityType");
        int r4 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r5 = CursorUtil.getColumnIndex(r0, "createTimeStamp");
        int r6 = CursorUtil.getColumnIndex(r0, "state");
        int r7 = CursorUtil.getColumnIndex(r0, "progress");
        int r8 = CursorUtil.getColumnIndex(r0, "columnContent");
        int r9 = CursorUtil.getColumnIndex(r0, "buildType");
        int r10 = CursorUtil.getColumnIndex(r0, "indexProgress");
        int r11 = CursorUtil.getColumnIndex(r0, LBSLightLocationTraceLogger.TOTAL);
        int r12 = CursorUtil.getColumnIndex(r0, WsConstants.KEY_EXTRA);
        int r13 = CursorUtil.getColumnIndex(r0, "isScheduledSlowTask");
        int r14 = CursorUtil.getColumnIndex(r0, "retryCount");
        int r15 = CursorUtil.getColumnIndex(r0, "nextRetryAt");
        long r16 = 0;
        if (r1 != (-1)) goto L5;
        long r21 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r23 = 0;
    L9:
        int r17 = 0;
        if (r3 != (-1)) goto L12;
        int r25 = 0;
    L13:
        if (r4 != (-1)) goto L15;
        long r26 = 0;
    L16:
        if (r5 != (-1)) goto L18;
        long r28 = 0;
    L19:
        if (r6 != (-1)) goto L21;
        int r30 = 0;
    L22:
        if (r7 != (-1)) goto L24;
        int r31 = 0;
    L25:
        String r18 = null;
        if (r8 != (-1)) goto L29;
    L27:
        String r32 = null;
    L32:
        if (r9 != (-1)) goto L35;
    L33:
        String r33 = null;
    L38:
        if (r10 != (-1)) goto L40;
        int r34 = 0;
    L41:
        if (r11 != (-1)) goto L43;
        int r35 = 0;
    L44:
        if (r12 != (-1)) goto L47;
    L45:
        String r36 = r18;
        if (r13 != (-1)) goto L53;
        boolean r37 = false;
    L57:
        if (r14 == (-1)) goto L60;
        r17 = r0.getInt(r14);
    L60:
        int r38 = r17;
        if (r15 == (-1)) goto L65;
        r16 = r0.getLong(r15);
    L65:
        return new cd(r21, r23, r25, r26, r28, r30, r31, r32, r33, r34, r35, r36, r37, r38, r16);
    L53:
        if (r0.getInt(r13) == 0) goto L55;
        boolean r19 = true;
    L56:
        r37 = r19;
        goto L57
    L55:
        r19 = false;
        goto L56
    L47:
        if (r0.isNull(r12) == true) goto L45;
        r18 = r0.getString(r12);
        goto L45
    L43:
        r35 = r0.getInt(r11);
        goto L44
    L40:
        r34 = r0.getInt(r10);
        goto L41
    L35:
        if (r0.isNull(r9) == true) goto L33;
        r33 = r0.getString(r9);
        goto L38
    L29:
        if (r0.isNull(r8) == true) goto L27;
        r32 = r0.getString(r8);
        goto L32
    L24:
        r31 = r0.getInt(r7);
        goto L25
    L21:
        r30 = r0.getInt(r6);
        goto L22
    L18:
        r28 = r0.getLong(r5);
        goto L19
    L15:
        r26 = r0.getLong(r4);
        goto L16
    L12:
        r25 = r0.getInt(r3);
        goto L13
    L8:
        r23 = r0.getLong(r2);
        goto L9
    L5:
        r21 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<cd> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfIndexPendingEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<cd> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfIndexPendingEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(cd r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfIndexPendingEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(cd r3) {
        return delete2((cd) ZeusTransformUtils.preCheckCast(r3, cd.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return IndexPendingDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public int deleteAllByBuildType(List<Long> r8, int r9, String r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM AppEntityIndexPending WHERE rawDbId IN (");
        int r2 = r11.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND entityType = ");
        r0.append("?");
        r0.append(" AND buildType = ");
        r0.append("?");
        SupportSQLiteStatement r1 = this.__db.compileStatement(r0.toString());
        Iterator r12 = r11.iterator();
        int r4 = 1;
    L4:
        if (r12.hasNext() == false) goto L6;
        r1.bindLong(r4, ((Long) ZeusTransformUtils.preCheckCast(r12.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r4 = r4 + 1;
        goto L4
    L6:
        r1.bindLong(r2 + 1, r9);
        int r3 = r2 + 2;
        if (r10 != null) goto L9;
        r1.bindNull(r3);
    L10:
        this.__db.beginTransaction();
        int r13 = r1.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        return r13;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L9:
        r1.bindString(r3, r10);
        goto L10
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public int deleteAllByEntityTypeAndBuildType(int r4, String r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAllByEntityTypeAndBuildType.acquire();
        r0.bindLong(1, r4);
        if (r5 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.__db.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllByEntityTypeAndBuildType.release(r0);
        return r6;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllByEntityTypeAndBuildType.release(r0);
        throw th;
    L5:
        r0.bindString(2, r5);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public int deleteAllByRawDbIds(List<Long> r8, int r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM AppEntityIndexPending WHERE rawDbId IN (");
        int r2 = r10.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND entityType = ");
        r0.append("?");
        SupportSQLiteStatement r1 = this.__db.compileStatement(r0.toString());
        Iterator r11 = r10.iterator();
        int r4 = 1;
    L4:
        if (r11.hasNext() == false) goto L6;
        r1.bindLong(r4, ((Long) ZeusTransformUtils.preCheckCast(r11.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r4 = r4 + 1;
        goto L4
    L6:
        r1.bindLong(r2 + 1, r9);
        this.__db.beginTransaction();
        int r12 = r1.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        return r12;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public int deleteByColumnContent(long r3, int r5, String r6) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByColumnContent.acquire();
        r0.bindLong(1, r3);
        r0.bindLong(2, r5);
        if (r6 != null) goto L5;
        r0.bindNull(3);
    L6:
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByColumnContent.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByColumnContent.release(r0);
        throw th;
    L5:
        r0.bindString(3, r6);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
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

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public int deleteByIdAndTimestamp(long r3, long r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByIdAndTimestamp.acquire();
        r0.bindLong(1, r3);
        r0.bindLong(2, r5);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByIdAndTimestamp.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByIdAndTimestamp.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public int deleteByRawDb(long r3, int r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByRawDb.acquire();
        r0.bindLong(1, r3);
        r0.bindLong(2, r5);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByRawDb.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByRawDb.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public int deleteForExecutionSettlement(long r3, long r5, long r7, int r9, long r10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteForExecutionSettlement.acquire();
        r0.bindLong(1, r3);
        r0.bindLong(2, r5);
        r0.bindLong(3, r7);
        long r4 = r9;
        r0.bindLong(4, r4);
        r0.bindLong(5, r7);
        r0.bindLong(6, r4);
        r0.bindLong(7, r10);
        this.__db.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteForExecutionSettlement.release(r0);
        return r6;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteForExecutionSettlement.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public long getCountByBuildTypeList(List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT COUNT(*) FROM AppEntityIndexPending WHERE buildType IN (");
        int r2 = r8.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r9 = r8.iterator();
        int r3 = 1;
    L4:
        if (r9.hasNext() == false) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r1.bindNull(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r1.bindString(r3, r4);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r1, false, null);
    L18:
        th = move-exception;
        r6.close();
        r1.release();
        throw th;
    L12:
        if (r6.moveToFirst() == false) goto L15;
        long r5 = r6.getLong(0);     // Catch: Throwable -> L18
    L16:
        r6.close();
        r1.release();
        return r5;
    L15:
        r5 = 0;
        goto L16
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public long getCountByEntityType(int r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM AppEntityIndexPending WHERE entityType = ?", 1);
        r0.bindLong(1, r5);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
    L10:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L4:
        if (r4.moveToFirst() == false) goto L7;
        long r1 = r4.getLong(0);     // Catch: Throwable -> L10
    L8:
        r4.close();
        r0.release();
        return r1;
    L7:
        r1 = 0;
        goto L8
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return IndexPendingDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(cd r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfIndexPendingEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(cd r3) {
        return insert2((cd) ZeusTransformUtils.preCheckCast(r3, cd.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<cd> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfIndexPendingEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cd> queryAll() {
        return IndexPendingDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return IndexPendingDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public List<cd> queryByColumnContent(long r39, int r41, String r42) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM AppEntityIndexPending WHERE rawDbId = ? AND entityType = ? AND columnContent = ?", 3);
        r2.bindLong(1, r39);
        r2.bindLong(2, r41);
        if (r42 != null) goto L5;
        r2.bindNull(3);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "rawDbId");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "entityType");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "createTimeStamp");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "state");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "progress");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "columnContent");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "buildType");     // Catch: Throwable -> L34
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "indexProgress");     // Catch: Throwable -> L34
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, LBSLightLocationTraceLogger.TOTAL);     // Catch: Throwable -> L34
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L34
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "isScheduledSlowTask");     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "retryCount");     // Catch: Throwable -> L34
        RoomSQLiteQuery r16 = r2;
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "nextRetryAt");     // Catch: Throwable -> L32
        int r43 = r4;
        ArrayList r17 = new ArrayList(r5.getCount());     // Catch: Throwable -> L32
    L10:
        if (r5.moveToNext() == false) goto L30;
        long r18 = r5.getLong(r0);     // Catch: Throwable -> L32
        long r20 = r5.getLong(r6);     // Catch: Throwable -> L32
        int r22 = r5.getInt(r7);     // Catch: Throwable -> L32
        long r23 = r5.getLong(r8);     // Catch: Throwable -> L32
        long r25 = r5.getLong(r9);     // Catch: Throwable -> L32
        int r27 = r5.getInt(r10);     // Catch: Throwable -> L32
        int r28 = r5.getInt(r11);     // Catch: Throwable -> L32
        if (r5.isNull(r12) == false) goto L15;
        String r29 = null;
    L17:
        if (r5.isNull(r13) == false) goto L19;
        String r30 = null;
    L20:
        int r31 = r5.getInt(r14);     // Catch: Throwable -> L32
        int r32 = r5.getInt(r15);     // Catch: Throwable -> L32
        if (r5.isNull(r1) == false) goto L23;
        String r33 = null;
    L25:
        if (r5.getInt(r3) == 0) goto L27;
        boolean r34 = true;
    L28:
        int r35 = r5.getInt(r43);     // Catch: Throwable -> L32
        int r44 = r0;
        int r19 = r40;
        r40 = r19;
        r17.add(new cd(r18, r20, r22, r23, r25, r27, r28, r29, r30, r31, r32, r33, r34, r35, r5.getLong(r19)));     // Catch: Throwable -> L32
        r0 = r44;
        r43 = r43;
        goto L10
    L27:
        r34 = false;
        goto L28
    L23:
        r33 = r5.getString(r1);     // Catch: Throwable -> L32
        goto L25
    L19:
        r30 = r5.getString(r13);     // Catch: Throwable -> L32
        goto L20
    L15:
        r29 = r5.getString(r12);     // Catch: Throwable -> L32
        goto L17
    L30:
        r5.close();
        r16.release();
        return r17;
    L32:
        th = th;
    L36:
        r5.close();
        r16.release();
        throw th;
    L34:
        th = th;
        r16 = r2;
        goto L36
    L5:
        r2.bindString(3, r42);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public List<cd> queryByEntityTypeAndBuildType(int r40, String r41) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM AppEntityIndexPending WHERE entityType = ? AND buildType = ?", 2);
        r2.bindLong(1, r40);
        if (r41 != null) goto L5;
        r2.bindNull(2);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "rawDbId");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "entityType");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "createTimeStamp");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "state");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "progress");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "columnContent");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "buildType");     // Catch: Throwable -> L34
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "indexProgress");     // Catch: Throwable -> L34
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, LBSLightLocationTraceLogger.TOTAL);     // Catch: Throwable -> L34
        int r1 = CursorUtil.getColumnIndexOrThrow(r4, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L34
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "isScheduledSlowTask");     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "retryCount");     // Catch: Throwable -> L34
        RoomSQLiteQuery r16 = r2;
        int r42 = CursorUtil.getColumnIndexOrThrow(r4, "nextRetryAt");     // Catch: Throwable -> L32
        int r17 = r6;
        ArrayList r18 = new ArrayList(r4.getCount());     // Catch: Throwable -> L32
    L10:
        if (r4.moveToNext() == false) goto L30;
        long r19 = r4.getLong(r0);     // Catch: Throwable -> L32
        long r21 = r4.getLong(r5);     // Catch: Throwable -> L32
        int r23 = r4.getInt(r7);     // Catch: Throwable -> L32
        long r24 = r4.getLong(r8);     // Catch: Throwable -> L32
        long r26 = r4.getLong(r9);     // Catch: Throwable -> L32
        int r28 = r4.getInt(r10);     // Catch: Throwable -> L32
        int r29 = r4.getInt(r11);     // Catch: Throwable -> L32
        if (r4.isNull(r12) == false) goto L15;
        String r30 = null;
    L17:
        if (r4.isNull(r13) == false) goto L19;
        String r31 = null;
    L20:
        int r32 = r4.getInt(r14);     // Catch: Throwable -> L32
        int r33 = r4.getInt(r15);     // Catch: Throwable -> L32
        if (r4.isNull(r1) == false) goto L23;
        String r34 = null;
    L25:
        if (r4.getInt(r3) == 0) goto L27;
        boolean r35 = true;
    L28:
        int r36 = r4.getInt(r17);     // Catch: Throwable -> L32
        int r110 = r0;
        int r20 = r42;
        r42 = r20;
        r18.add(new cd(r19, r21, r23, r24, r26, r28, r29, r30, r31, r32, r33, r34, r35, r36, r4.getLong(r20)));     // Catch: Throwable -> L32
        r0 = r110;
        r17 = r17;
        goto L10
    L27:
        r35 = false;
        goto L28
    L23:
        r34 = r4.getString(r1);     // Catch: Throwable -> L32
        goto L25
    L19:
        r31 = r4.getString(r13);     // Catch: Throwable -> L32
        goto L20
    L15:
        r30 = r4.getString(r12);     // Catch: Throwable -> L32
        goto L17
    L30:
        r4.close();
        r16.release();
        return r18;
    L32:
        th = th;
    L36:
        r4.close();
        r16.release();
        throw th;
    L34:
        th = th;
        r16 = r2;
        goto L36
    L5:
        r2.bindString(2, r41);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cd queryById(long r1) {
        return IndexPendingDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cd queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public cd queryByIdAndTimestamp(long r40, long r42) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM AppEntityIndexPending WHERE id = ? AND timestamp = ? LIMIT 1", 2);
        r1.bindLong(1, r40);
        r1.bindLong(2, r42);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "rawDbId");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "entityType");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "createTimeStamp");     // Catch: Throwable -> L30
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "state");     // Catch: Throwable -> L30
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "progress");     // Catch: Throwable -> L30
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "columnContent");     // Catch: Throwable -> L30
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "buildType");     // Catch: Throwable -> L30
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "indexProgress");     // Catch: Throwable -> L30
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, LBSLightLocationTraceLogger.TOTAL);     // Catch: Throwable -> L30
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L30
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "isScheduledSlowTask");     // Catch: Throwable -> L30
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "retryCount");     // Catch: Throwable -> L30
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "nextRetryAt");     // Catch: Throwable -> L28
        if (r5.moveToFirst() == false) goto L25;
        long r19 = r5.getLong(r0);     // Catch: Throwable -> L28
        long r21 = r5.getLong(r6);     // Catch: Throwable -> L28
        int r23 = r5.getInt(r7);     // Catch: Throwable -> L28
        long r24 = r5.getLong(r8);     // Catch: Throwable -> L28
        long r26 = r5.getLong(r9);     // Catch: Throwable -> L28
        int r28 = r5.getInt(r10);     // Catch: Throwable -> L28
        int r29 = r5.getInt(r11);     // Catch: Throwable -> L28
        if (r5.isNull(r12) == false) goto L10;
        String r30 = null;
    L12:
        if (r5.isNull(r13) == false) goto L14;
        String r31 = null;
    L15:
        int r32 = r5.getInt(r14);     // Catch: Throwable -> L28
        int r33 = r5.getInt(r15);     // Catch: Throwable -> L28
        if (r5.isNull(r2) == false) goto L18;
        String r34 = null;
    L20:
        if (r5.getInt(r3) == 0) goto L22;
        boolean r35 = true;
    L23:
        cd r18 = new cd(r19, r21, r23, r24, r26, r28, r29, r30, r31, r32, r33, r34, r35, r5.getInt(r4), r5.getLong(r17));     // Catch: Throwable -> L28
    L26:
        r5.close();
        r16.release();
        return r18;
    L22:
        r35 = false;
        goto L23
    L18:
        r34 = r5.getString(r2);     // Catch: Throwable -> L28
        goto L20
    L14:
        r31 = r5.getString(r13);     // Catch: Throwable -> L28
        goto L15
    L10:
        r30 = r5.getString(r12);     // Catch: Throwable -> L28
        goto L12
    L25:
        r18 = null;
    L28:
        th = th;
    L32:
        r5.close();
        r16.release();
        throw th;
    L30:
        th = th;
        r16 = r1;
        goto L32
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cd> queryByIds(List<Long> r3) {
        return IndexPendingDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public long queryByRawDbIdListAndColumnContentSize(List<Long> r3, String r4, int r5) {
        return IndexPendingDao.DefaultImpls.queryByRawDbIdListAndColumnContentSize(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public List<cd> queryByRawDbIdsAndBuildType(List<Long> r39, int r40, String r41) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r39, List.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = StringUtil.newStringBuilder();
        r4.append("SELECT * FROM AppEntityIndexPending WHERE rawDbId IN (");
        int r5 = r2.size();
        StringUtil.appendPlaceholders(r4, r5);
        r4.append(") AND entityType = ");
        r4.append("?");
        r4.append(" AND buildType = ");
        r4.append("?");
        int r6 = r5 + 2;
        RoomSQLiteQuery r7 = RoomSQLiteQuery.acquire(r4.toString(), r6);
        Iterator r3 = r2.iterator();
        int r8 = 1;
    L4:
        if (r3.hasNext() == false) goto L6;
        r7.bindLong(r8, ((Long) ZeusTransformUtils.preCheckCast(r3.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r8 = r8 + 1;
        goto L4
    L6:
        r7.bindLong(r5 + 1, r40);
        if (r41 != null) goto L9;
        r7.bindNull(r6);
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r9 = DBUtil.query(this.__db, r7, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r9, OaidModel.KEY_ID);     // Catch: Throwable -> L38
        int r10 = CursorUtil.getColumnIndexOrThrow(r9, "rawDbId");     // Catch: Throwable -> L38
        int r11 = CursorUtil.getColumnIndexOrThrow(r9, "entityType");     // Catch: Throwable -> L38
        int r12 = CursorUtil.getColumnIndexOrThrow(r9, "timestamp");     // Catch: Throwable -> L38
        int r13 = CursorUtil.getColumnIndexOrThrow(r9, "createTimeStamp");     // Catch: Throwable -> L38
        int r14 = CursorUtil.getColumnIndexOrThrow(r9, "state");     // Catch: Throwable -> L38
        int r15 = CursorUtil.getColumnIndexOrThrow(r9, "progress");     // Catch: Throwable -> L38
        int r16 = CursorUtil.getColumnIndexOrThrow(r9, "columnContent");     // Catch: Throwable -> L38
        int r17 = CursorUtil.getColumnIndexOrThrow(r9, "buildType");     // Catch: Throwable -> L38
        int r18 = CursorUtil.getColumnIndexOrThrow(r9, "indexProgress");     // Catch: Throwable -> L38
        int r19 = CursorUtil.getColumnIndexOrThrow(r9, LBSLightLocationTraceLogger.TOTAL);     // Catch: Throwable -> L38
        int r1 = CursorUtil.getColumnIndexOrThrow(r9, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L38
        int r20 = CursorUtil.getColumnIndexOrThrow(r9, "isScheduledSlowTask");     // Catch: Throwable -> L38
        int r21 = CursorUtil.getColumnIndexOrThrow(r9, "retryCount");     // Catch: Throwable -> L38
        RoomSQLiteQuery r110 = r7;
        int r42 = CursorUtil.getColumnIndexOrThrow(r9, "nextRetryAt");     // Catch: Throwable -> L36
        int r43 = r21;
        ArrayList r22 = new ArrayList(r9.getCount());     // Catch: Throwable -> L36
    L14:
        if (r9.moveToNext() == false) goto L34;
        long r111 = r9.getLong(r0);     // Catch: Throwable -> L36
        long r23 = r9.getLong(r10);     // Catch: Throwable -> L36
        int r24 = r9.getInt(r11);     // Catch: Throwable -> L36
        long r25 = r9.getLong(r12);     // Catch: Throwable -> L36
        long r26 = r9.getLong(r13);     // Catch: Throwable -> L36
        int r27 = r9.getInt(r14);     // Catch: Throwable -> L36
        int r28 = r9.getInt(r15);     // Catch: Throwable -> L36
        if (r9.isNull(r16) == false) goto L19;
        String r29 = null;
    L21:
        if (r9.isNull(r17) == false) goto L23;
        String r30 = null;
    L24:
        int r31 = r9.getInt(r18);     // Catch: Throwable -> L36
        int r32 = r9.getInt(r19);     // Catch: Throwable -> L36
        if (r9.isNull(r1) == false) goto L27;
        String r33 = null;
    L29:
        if (r9.getInt(r20) == 0) goto L31;
        boolean r34 = true;
    L32:
        int r35 = r9.getInt(r43);     // Catch: Throwable -> L36
        int r44 = r0;
        int r36 = r42;
        r42 = r36;
        r22.add(new cd(r111, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r9.getLong(r36)));     // Catch: Throwable -> L36
        r0 = r44;
        r43 = r43;
        goto L14
    L31:
        r34 = false;
        goto L32
    L27:
        r33 = r9.getString(r1);     // Catch: Throwable -> L36
        goto L29
    L23:
        r30 = r9.getString(r17);     // Catch: Throwable -> L36
        goto L24
    L19:
        r29 = r9.getString(r16);     // Catch: Throwable -> L36
        goto L21
    L34:
        r9.close();
        r110.release();
        return r22;
    L36:
        th = th;
    L40:
        r9.close();
        r110.release();
        throw th;
    L38:
        th = th;
        r110 = r7;
        goto L40
    L9:
        r7.bindString(r6, r41);
        goto L10
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cd queryByUUID(String r1) {
        return IndexPendingDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cd queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public long queryCountByEntityTypeAndColumn(int r5, String r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM AppEntityIndexPending WHERE entityType = ? AND columnContent = ?", 2);
        r0.bindLong(1, r5);
        if (r6 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
    L14:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L8:
        if (r4.moveToFirst() == false) goto L11;
        long r7 = r4.getLong(0);     // Catch: Throwable -> L14
    L12:
        r4.close();
        r0.release();
        return r7;
    L11:
        r7 = 0;
        goto L12
    L5:
        r0.bindString(2, r6);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public long queryCountWithRawDb(long r4, int r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM AppEntityIndexPending WHERE rawDbId = ? AND entityType = ?", 2);
        r0.bindLong(1, r4);
        r0.bindLong(2, r6);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L10:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L7;
        long r5 = r3.getLong(0);     // Catch: Throwable -> L10
    L8:
        r3.close();
        r0.release();
        return r5;
    L7:
        r5 = 0;
        goto L8
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public long queryCountWithRawDbIds(List<Long> r8, int r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT COUNT(*) FROM AppEntityIndexPending WHERE rawDbId IN (");
        int r2 = r10.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND entityType = ");
        r0.append("?");
        int r3 = r2 + 1;
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r3);
        Iterator r11 = r10.iterator();
        int r4 = 1;
    L4:
        if (r11.hasNext() == false) goto L6;
        r1.bindLong(r4, ((Long) ZeusTransformUtils.preCheckCast(r11.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r4 = r4 + 1;
        goto L4
    L6:
        r1.bindLong(r3, r9);
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r1, false, null);
    L14:
        th = move-exception;
        r7.close();
        r1.release();
        throw th;
    L8:
        if (r7.moveToFirst() == false) goto L11;
        long r12 = r7.getLong(0);     // Catch: Throwable -> L14
    L12:
        r7.close();
        r1.release();
        return r12;
    L11:
        r12 = 0;
        goto L12
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public List<cd> queryIndexed(long r39, int r41) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM AppEntityIndexPending WHERE rawDbId = ? AND entityType = ?", 2);
        r1.bindLong(1, r39);
        r1.bindLong(2, r41);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "rawDbId");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "entityType");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "createTimeStamp");     // Catch: Throwable -> L30
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "state");     // Catch: Throwable -> L30
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "progress");     // Catch: Throwable -> L30
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "columnContent");     // Catch: Throwable -> L30
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "buildType");     // Catch: Throwable -> L30
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "indexProgress");     // Catch: Throwable -> L30
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, LBSLightLocationTraceLogger.TOTAL);     // Catch: Throwable -> L30
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L30
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "isScheduledSlowTask");     // Catch: Throwable -> L30
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "retryCount");     // Catch: Throwable -> L30
        RoomSQLiteQuery r16 = r1;
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "nextRetryAt");     // Catch: Throwable -> L28
        int r42 = r4;
        ArrayList r17 = new ArrayList(r5.getCount());     // Catch: Throwable -> L28
    L6:
        if (r5.moveToNext() == false) goto L26;
        long r18 = r5.getLong(r0);     // Catch: Throwable -> L28
        long r20 = r5.getLong(r6);     // Catch: Throwable -> L28
        int r22 = r5.getInt(r7);     // Catch: Throwable -> L28
        long r23 = r5.getLong(r8);     // Catch: Throwable -> L28
        long r25 = r5.getLong(r9);     // Catch: Throwable -> L28
        int r27 = r5.getInt(r10);     // Catch: Throwable -> L28
        int r28 = r5.getInt(r11);     // Catch: Throwable -> L28
        if (r5.isNull(r12) == false) goto L11;
        String r29 = null;
    L13:
        if (r5.isNull(r13) == false) goto L15;
        String r30 = null;
    L16:
        int r31 = r5.getInt(r14);     // Catch: Throwable -> L28
        int r32 = r5.getInt(r15);     // Catch: Throwable -> L28
        if (r5.isNull(r2) == false) goto L19;
        String r33 = null;
    L21:
        if (r5.getInt(r3) == 0) goto L23;
        boolean r34 = true;
    L24:
        int r35 = r5.getInt(r42);     // Catch: Throwable -> L28
        int r43 = r0;
        int r19 = r40;
        r40 = r19;
        r17.add(new cd(r18, r20, r22, r23, r25, r27, r28, r29, r30, r31, r32, r33, r34, r35, r5.getLong(r19)));     // Catch: Throwable -> L28
        r0 = r43;
        r42 = r42;
        goto L6
    L23:
        r34 = false;
        goto L24
    L19:
        r33 = r5.getString(r2);     // Catch: Throwable -> L28
        goto L21
    L15:
        r30 = r5.getString(r13);     // Catch: Throwable -> L28
        goto L16
    L11:
        r29 = r5.getString(r12);     // Catch: Throwable -> L28
        goto L13
    L26:
        r5.close();
        r16.release();
        return r17;
    L28:
        th = th;
    L32:
        r5.close();
        r16.release();
        throw th;
    L30:
        th = th;
        r16 = r1;
        goto L32
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cd queryOne() {
        return IndexPendingDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cd queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public List<Long> queryPendingRawDbIds(List<Long> r8, int r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT DISTINCT rawDbId FROM AppEntityIndexPending WHERE rawDbId IN (");
        int r2 = r10.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND entityType = ");
        r0.append("?");
        int r3 = r2 + 1;
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r3);
        Iterator r11 = r10.iterator();
        int r4 = 1;
    L4:
        if (r11.hasNext() == false) goto L6;
        r1.bindLong(r4, ((Long) ZeusTransformUtils.preCheckCast(r11.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r4 = r4 + 1;
        goto L4
    L6:
        r1.bindLong(r3, r9);
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r1, false, null);
        ArrayList r12 = new ArrayList(r7.getCount());     // Catch: Throwable -> L14
    L9:
        if (r7.moveToNext() == false) goto L12;
        r12.add(Long.valueOf(r7.getLong(0)));     // Catch: Throwable -> L14
        goto L9
    L12:
        r7.close();
        r1.release();
        return r12;
    L14:
        th = move-exception;
        r7.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public List<cd> queryUnIndexedEntity() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM AppEntityIndexPending", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "rawDbId");     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "entityType");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "createTimeStamp");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "state");     // Catch: Throwable -> L30
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "progress");     // Catch: Throwable -> L30
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "columnContent");     // Catch: Throwable -> L30
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "buildType");     // Catch: Throwable -> L30
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "indexProgress");     // Catch: Throwable -> L30
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, LBSLightLocationTraceLogger.TOTAL);     // Catch: Throwable -> L30
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L30
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "isScheduledSlowTask");     // Catch: Throwable -> L30
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "retryCount");     // Catch: Throwable -> L30
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "nextRetryAt");     // Catch: Throwable -> L28
        int r18 = r3;
        ArrayList r19 = new ArrayList(r4.getCount());     // Catch: Throwable -> L28
    L6:
        if (r4.moveToNext() == false) goto L26;
        long r20 = r4.getLong(r0);     // Catch: Throwable -> L28
        long r22 = r4.getLong(r5);     // Catch: Throwable -> L28
        int r24 = r4.getInt(r6);     // Catch: Throwable -> L28
        long r25 = r4.getLong(r7);     // Catch: Throwable -> L28
        long r27 = r4.getLong(r8);     // Catch: Throwable -> L28
        int r29 = r4.getInt(r9);     // Catch: Throwable -> L28
        int r30 = r4.getInt(r10);     // Catch: Throwable -> L28
        if (r4.isNull(r11) == false) goto L11;
        String r31 = null;
    L13:
        if (r4.isNull(r12) == false) goto L15;
        String r32 = null;
    L16:
        int r33 = r4.getInt(r13);     // Catch: Throwable -> L28
        int r34 = r4.getInt(r14);     // Catch: Throwable -> L28
        if (r4.isNull(r15) == false) goto L19;
        String r35 = null;
    L21:
        if (r4.getInt(r2) == 0) goto L23;
        boolean r36 = true;
    L24:
        int r37 = r4.getInt(r18);     // Catch: Throwable -> L28
        int r110 = r0;
        int r21 = r17;
        r17 = r21;
        r19.add(new cd(r20, r22, r24, r25, r27, r29, r30, r31, r32, r33, r34, r35, r36, r37, r4.getLong(r21)));     // Catch: Throwable -> L28
        r0 = r110;
        r18 = r18;
        goto L6
    L23:
        r36 = false;
        goto L24
    L19:
        r35 = r4.getString(r15);     // Catch: Throwable -> L28
        goto L21
    L15:
        r32 = r4.getString(r12);     // Catch: Throwable -> L28
        goto L16
    L11:
        r31 = r4.getString(r11);     // Catch: Throwable -> L28
        goto L13
    L26:
        r4.close();
        r16.release();
        return r19;
    L28:
        th = th;
    L32:
        r4.close();
        r16.release();
        throw th;
    L30:
        th = th;
        r16 = r1;
        goto L32
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public List<cd> queryUnhandledEntity() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM AppEntityIndexPending", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "rawDbId");     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "entityType");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "createTimeStamp");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "state");     // Catch: Throwable -> L30
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "progress");     // Catch: Throwable -> L30
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "columnContent");     // Catch: Throwable -> L30
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "buildType");     // Catch: Throwable -> L30
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "indexProgress");     // Catch: Throwable -> L30
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, LBSLightLocationTraceLogger.TOTAL);     // Catch: Throwable -> L30
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L30
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "isScheduledSlowTask");     // Catch: Throwable -> L30
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "retryCount");     // Catch: Throwable -> L30
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "nextRetryAt");     // Catch: Throwable -> L28
        int r18 = r3;
        ArrayList r19 = new ArrayList(r4.getCount());     // Catch: Throwable -> L28
    L6:
        if (r4.moveToNext() == false) goto L26;
        long r20 = r4.getLong(r0);     // Catch: Throwable -> L28
        long r22 = r4.getLong(r5);     // Catch: Throwable -> L28
        int r24 = r4.getInt(r6);     // Catch: Throwable -> L28
        long r25 = r4.getLong(r7);     // Catch: Throwable -> L28
        long r27 = r4.getLong(r8);     // Catch: Throwable -> L28
        int r29 = r4.getInt(r9);     // Catch: Throwable -> L28
        int r30 = r4.getInt(r10);     // Catch: Throwable -> L28
        if (r4.isNull(r11) == false) goto L11;
        String r31 = null;
    L13:
        if (r4.isNull(r12) == false) goto L15;
        String r32 = null;
    L16:
        int r33 = r4.getInt(r13);     // Catch: Throwable -> L28
        int r34 = r4.getInt(r14);     // Catch: Throwable -> L28
        if (r4.isNull(r15) == false) goto L19;
        String r35 = null;
    L21:
        if (r4.getInt(r2) == 0) goto L23;
        boolean r36 = true;
    L24:
        int r37 = r4.getInt(r18);     // Catch: Throwable -> L28
        int r110 = r0;
        int r21 = r17;
        r17 = r21;
        r19.add(new cd(r20, r22, r24, r25, r27, r29, r30, r31, r32, r33, r34, r35, r36, r37, r4.getLong(r21)));     // Catch: Throwable -> L28
        r0 = r110;
        r18 = r18;
        goto L6
    L23:
        r36 = false;
        goto L24
    L19:
        r35 = r4.getString(r15);     // Catch: Throwable -> L28
        goto L21
    L15:
        r32 = r4.getString(r12);     // Catch: Throwable -> L28
        goto L16
    L11:
        r31 = r4.getString(r11);     // Catch: Throwable -> L28
        goto L13
    L26:
        r4.close();
        r16.release();
        return r19;
    L28:
        th = th;
    L32:
        r4.close();
        r16.release();
        throw th;
    L30:
        th = th;
        r16 = r1;
        goto L32
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public List<cd> queryUnhandledEntity(int r41) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM AppEntityIndexPending WHERE state != 3 AND entityType = ?", 1);
        r1.bindLong(1, r41);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "rawDbId");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "entityType");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "createTimeStamp");     // Catch: Throwable -> L30
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "state");     // Catch: Throwable -> L30
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "progress");     // Catch: Throwable -> L30
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "columnContent");     // Catch: Throwable -> L30
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "buildType");     // Catch: Throwable -> L30
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "indexProgress");     // Catch: Throwable -> L30
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, LBSLightLocationTraceLogger.TOTAL);     // Catch: Throwable -> L30
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L30
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "isScheduledSlowTask");     // Catch: Throwable -> L30
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "retryCount");     // Catch: Throwable -> L30
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "nextRetryAt");     // Catch: Throwable -> L28
        int r18 = r4;
        ArrayList r19 = new ArrayList(r5.getCount());     // Catch: Throwable -> L28
    L6:
        if (r5.moveToNext() == false) goto L26;
        long r20 = r5.getLong(r0);     // Catch: Throwable -> L28
        long r22 = r5.getLong(r6);     // Catch: Throwable -> L28
        int r24 = r5.getInt(r7);     // Catch: Throwable -> L28
        long r25 = r5.getLong(r8);     // Catch: Throwable -> L28
        long r27 = r5.getLong(r9);     // Catch: Throwable -> L28
        int r29 = r5.getInt(r10);     // Catch: Throwable -> L28
        int r30 = r5.getInt(r11);     // Catch: Throwable -> L28
        if (r5.isNull(r12) == false) goto L11;
        String r31 = null;
    L13:
        if (r5.isNull(r13) == false) goto L15;
        String r32 = null;
    L16:
        int r33 = r5.getInt(r14);     // Catch: Throwable -> L28
        int r34 = r5.getInt(r15);     // Catch: Throwable -> L28
        if (r5.isNull(r2) == false) goto L19;
        String r35 = null;
    L21:
        if (r5.getInt(r3) == 0) goto L23;
        boolean r36 = true;
    L24:
        int r37 = r5.getInt(r18);     // Catch: Throwable -> L28
        int r110 = r0;
        int r21 = r17;
        r17 = r21;
        r19.add(new cd(r20, r22, r24, r25, r27, r29, r30, r31, r32, r33, r34, r35, r36, r37, r5.getLong(r21)));     // Catch: Throwable -> L28
        r0 = r110;
        r18 = r18;
        goto L6
    L23:
        r36 = false;
        goto L24
    L19:
        r35 = r5.getString(r2);     // Catch: Throwable -> L28
        goto L21
    L15:
        r32 = r5.getString(r13);     // Catch: Throwable -> L28
        goto L16
    L11:
        r31 = r5.getString(r12);     // Catch: Throwable -> L28
        goto L13
    L26:
        r5.close();
        r16.release();
        return r19;
    L28:
        th = th;
    L32:
        r5.close();
        r16.release();
        throw th;
    L30:
        th = th;
        r16 = r1;
        goto L32
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public List<cd> queryUnhandledEntityWithLimit(int r39, int r40, long r41) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM AppEntityIndexPending WHERE state != 3 AND entityType = ? AND id > ? ORDER BY id ASC LIMIT ?", 3);
        r1.bindLong(1, r39);
        r1.bindLong(2, r41);
        r1.bindLong(3, r40);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "rawDbId");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "entityType");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "createTimeStamp");     // Catch: Throwable -> L30
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "state");     // Catch: Throwable -> L30
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "progress");     // Catch: Throwable -> L30
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "columnContent");     // Catch: Throwable -> L30
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "buildType");     // Catch: Throwable -> L30
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "indexProgress");     // Catch: Throwable -> L30
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, LBSLightLocationTraceLogger.TOTAL);     // Catch: Throwable -> L30
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L30
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "isScheduledSlowTask");     // Catch: Throwable -> L30
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "retryCount");     // Catch: Throwable -> L30
        RoomSQLiteQuery r16 = r1;
        int r42 = CursorUtil.getColumnIndexOrThrow(r4, "nextRetryAt");     // Catch: Throwable -> L28
        int r43 = r5;
        ArrayList r17 = new ArrayList(r4.getCount());     // Catch: Throwable -> L28
    L6:
        if (r4.moveToNext() == false) goto L26;
        long r18 = r4.getLong(r0);     // Catch: Throwable -> L28
        long r20 = r4.getLong(r6);     // Catch: Throwable -> L28
        int r22 = r4.getInt(r7);     // Catch: Throwable -> L28
        long r23 = r4.getLong(r8);     // Catch: Throwable -> L28
        long r25 = r4.getLong(r9);     // Catch: Throwable -> L28
        int r27 = r4.getInt(r10);     // Catch: Throwable -> L28
        int r28 = r4.getInt(r11);     // Catch: Throwable -> L28
        if (r4.isNull(r12) == false) goto L11;
        String r29 = null;
    L13:
        if (r4.isNull(r13) == false) goto L15;
        String r30 = null;
    L16:
        int r31 = r4.getInt(r14);     // Catch: Throwable -> L28
        int r32 = r4.getInt(r15);     // Catch: Throwable -> L28
        if (r4.isNull(r2) == false) goto L19;
        String r33 = null;
    L21:
        if (r4.getInt(r3) == 0) goto L23;
        boolean r34 = true;
    L24:
        int r35 = r4.getInt(r43);     // Catch: Throwable -> L28
        int r44 = r0;
        int r19 = r42;
        r42 = r19;
        r17.add(new cd(r18, r20, r22, r23, r25, r27, r28, r29, r30, r31, r32, r33, r34, r35, r4.getLong(r19)));     // Catch: Throwable -> L28
        r0 = r44;
        r43 = r43;
        goto L6
    L23:
        r34 = false;
        goto L24
    L19:
        r33 = r4.getString(r2);     // Catch: Throwable -> L28
        goto L21
    L15:
        r30 = r4.getString(r13);     // Catch: Throwable -> L28
        goto L16
    L11:
        r29 = r4.getString(r12);     // Catch: Throwable -> L28
        goto L13
    L26:
        r4.close();
        r16.release();
        return r17;
    L28:
        th = th;
    L32:
        r4.close();
        r16.release();
        throw th;
    L30:
        th = th;
        r16 = r1;
        goto L32
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public List<cd> queryWithId(List<Long> r41) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r41, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM AppEntityIndexPending WHERE id IN (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(")");
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire(r3.toString(), r4 + 0);
        Iterator r2 = r1.iterator();
        int r6 = 1;
    L4:
        if (r2.hasNext() == false) goto L6;
        r5.bindLong(r6, ((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r6 = r6 + 1;
        goto L4
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r5, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r7, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r7, "rawDbId");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r7, "entityType");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r7, "timestamp");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r7, "createTimeStamp");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r7, "state");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r7, "progress");     // Catch: Throwable -> L34
        int r14 = CursorUtil.getColumnIndexOrThrow(r7, "columnContent");     // Catch: Throwable -> L34
        int r15 = CursorUtil.getColumnIndexOrThrow(r7, "buildType");     // Catch: Throwable -> L34
        int r16 = CursorUtil.getColumnIndexOrThrow(r7, "indexProgress");     // Catch: Throwable -> L34
        int r17 = CursorUtil.getColumnIndexOrThrow(r7, LBSLightLocationTraceLogger.TOTAL);     // Catch: Throwable -> L34
        int r18 = CursorUtil.getColumnIndexOrThrow(r7, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L34
        int r19 = CursorUtil.getColumnIndexOrThrow(r7, "isScheduledSlowTask");     // Catch: Throwable -> L34
        int r20 = CursorUtil.getColumnIndexOrThrow(r7, "retryCount");     // Catch: Throwable -> L34
        RoomSQLiteQuery r110 = r5;
        int r111 = CursorUtil.getColumnIndexOrThrow(r7, "nextRetryAt");     // Catch: Throwable -> L32
        int r112 = r20;
        ArrayList r21 = new ArrayList(r7.getCount());     // Catch: Throwable -> L32
    L10:
        if (r7.moveToNext() == false) goto L30;
        long r22 = r7.getLong(r0);     // Catch: Throwable -> L32
        long r23 = r7.getLong(r8);     // Catch: Throwable -> L32
        int r24 = r7.getInt(r9);     // Catch: Throwable -> L32
        long r25 = r7.getLong(r10);     // Catch: Throwable -> L32
        long r27 = r7.getLong(r11);     // Catch: Throwable -> L32
        int r29 = r7.getInt(r12);     // Catch: Throwable -> L32
        int r30 = r7.getInt(r13);     // Catch: Throwable -> L32
        if (r7.isNull(r14) == false) goto L15;
        String r31 = null;
    L17:
        if (r7.isNull(r15) == false) goto L19;
        String r32 = null;
    L20:
        int r33 = r7.getInt(r16);     // Catch: Throwable -> L32
        int r34 = r7.getInt(r17);     // Catch: Throwable -> L32
        if (r7.isNull(r18) == false) goto L23;
        String r35 = null;
    L25:
        if (r7.getInt(r19) == 0) goto L27;
        boolean r36 = true;
    L28:
        int r37 = r7.getInt(r112);     // Catch: Throwable -> L32
        int r113 = r0;
        int r26 = r111;
        r111 = r26;
        r21.add(new cd(r22, r23, r24, r25, r27, r29, r30, r31, r32, r33, r34, r35, r36, r37, r7.getLong(r26)));     // Catch: Throwable -> L32
        r0 = r113;
        r112 = r112;
        goto L10
    L27:
        r36 = false;
        goto L28
    L23:
        r35 = r7.getString(r18);     // Catch: Throwable -> L32
        goto L25
    L19:
        r32 = r7.getString(r15);     // Catch: Throwable -> L32
        goto L20
    L15:
        r31 = r7.getString(r14);     // Catch: Throwable -> L32
        goto L17
    L30:
        r7.close();
        r110.release();
        return r21;
    L32:
        th = th;
    L36:
        r7.close();
        r110.release();
        throw th;
    L34:
        th = th;
        r110 = r5;
        goto L36
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cd> queryWithLimitAndOffset(int r1, int r2) {
        return IndexPendingDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public List<cd> queryWithRawDb(long r39, int r41) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM AppEntityIndexPending WHERE rawDbId = ? AND entityType = ?", 2);
        r1.bindLong(1, r39);
        r1.bindLong(2, r41);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "rawDbId");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "entityType");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "createTimeStamp");     // Catch: Throwable -> L30
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "state");     // Catch: Throwable -> L30
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "progress");     // Catch: Throwable -> L30
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "columnContent");     // Catch: Throwable -> L30
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "buildType");     // Catch: Throwable -> L30
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "indexProgress");     // Catch: Throwable -> L30
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, LBSLightLocationTraceLogger.TOTAL);     // Catch: Throwable -> L30
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L30
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "isScheduledSlowTask");     // Catch: Throwable -> L30
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "retryCount");     // Catch: Throwable -> L30
        RoomSQLiteQuery r16 = r1;
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "nextRetryAt");     // Catch: Throwable -> L28
        int r42 = r4;
        ArrayList r17 = new ArrayList(r5.getCount());     // Catch: Throwable -> L28
    L6:
        if (r5.moveToNext() == false) goto L26;
        long r18 = r5.getLong(r0);     // Catch: Throwable -> L28
        long r20 = r5.getLong(r6);     // Catch: Throwable -> L28
        int r22 = r5.getInt(r7);     // Catch: Throwable -> L28
        long r23 = r5.getLong(r8);     // Catch: Throwable -> L28
        long r25 = r5.getLong(r9);     // Catch: Throwable -> L28
        int r27 = r5.getInt(r10);     // Catch: Throwable -> L28
        int r28 = r5.getInt(r11);     // Catch: Throwable -> L28
        if (r5.isNull(r12) == false) goto L11;
        String r29 = null;
    L13:
        if (r5.isNull(r13) == false) goto L15;
        String r30 = null;
    L16:
        int r31 = r5.getInt(r14);     // Catch: Throwable -> L28
        int r32 = r5.getInt(r15);     // Catch: Throwable -> L28
        if (r5.isNull(r2) == false) goto L19;
        String r33 = null;
    L21:
        if (r5.getInt(r3) == 0) goto L23;
        boolean r34 = true;
    L24:
        int r35 = r5.getInt(r42);     // Catch: Throwable -> L28
        int r43 = r0;
        int r19 = r40;
        r40 = r19;
        r17.add(new cd(r18, r20, r22, r23, r25, r27, r28, r29, r30, r31, r32, r33, r34, r35, r5.getLong(r19)));     // Catch: Throwable -> L28
        r0 = r43;
        r42 = r42;
        goto L6
    L23:
        r34 = false;
        goto L24
    L19:
        r33 = r5.getString(r2);     // Catch: Throwable -> L28
        goto L21
    L15:
        r30 = r5.getString(r13);     // Catch: Throwable -> L28
        goto L16
    L11:
        r29 = r5.getString(r12);     // Catch: Throwable -> L28
        goto L13
    L26:
        r5.close();
        r16.release();
        return r17;
    L28:
        th = th;
    L32:
        r5.close();
        r16.release();
        throw th;
    L30:
        th = th;
        r16 = r1;
        goto L32
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public List<cd> queryWithRawDbAndColumn(long r39, int r41, String r42) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM AppEntityIndexPending WHERE rawDbId = ? AND entityType = ? AND columnContent = ?", 3);
        r2.bindLong(1, r39);
        r2.bindLong(2, r41);
        if (r42 != null) goto L5;
        r2.bindNull(3);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "rawDbId");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "entityType");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "createTimeStamp");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "state");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "progress");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "columnContent");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "buildType");     // Catch: Throwable -> L34
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "indexProgress");     // Catch: Throwable -> L34
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, LBSLightLocationTraceLogger.TOTAL);     // Catch: Throwable -> L34
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L34
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "isScheduledSlowTask");     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "retryCount");     // Catch: Throwable -> L34
        RoomSQLiteQuery r16 = r2;
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "nextRetryAt");     // Catch: Throwable -> L32
        int r43 = r4;
        ArrayList r17 = new ArrayList(r5.getCount());     // Catch: Throwable -> L32
    L10:
        if (r5.moveToNext() == false) goto L30;
        long r18 = r5.getLong(r0);     // Catch: Throwable -> L32
        long r20 = r5.getLong(r6);     // Catch: Throwable -> L32
        int r22 = r5.getInt(r7);     // Catch: Throwable -> L32
        long r23 = r5.getLong(r8);     // Catch: Throwable -> L32
        long r25 = r5.getLong(r9);     // Catch: Throwable -> L32
        int r27 = r5.getInt(r10);     // Catch: Throwable -> L32
        int r28 = r5.getInt(r11);     // Catch: Throwable -> L32
        if (r5.isNull(r12) == false) goto L15;
        String r29 = null;
    L17:
        if (r5.isNull(r13) == false) goto L19;
        String r30 = null;
    L20:
        int r31 = r5.getInt(r14);     // Catch: Throwable -> L32
        int r32 = r5.getInt(r15);     // Catch: Throwable -> L32
        if (r5.isNull(r1) == false) goto L23;
        String r33 = null;
    L25:
        if (r5.getInt(r3) == 0) goto L27;
        boolean r34 = true;
    L28:
        int r35 = r5.getInt(r43);     // Catch: Throwable -> L32
        int r44 = r0;
        int r19 = r40;
        r40 = r19;
        r17.add(new cd(r18, r20, r22, r23, r25, r27, r28, r29, r30, r31, r32, r33, r34, r35, r5.getLong(r19)));     // Catch: Throwable -> L32
        r0 = r44;
        r43 = r43;
        goto L10
    L27:
        r34 = false;
        goto L28
    L23:
        r33 = r5.getString(r1);     // Catch: Throwable -> L32
        goto L25
    L19:
        r30 = r5.getString(r13);     // Catch: Throwable -> L32
        goto L20
    L15:
        r29 = r5.getString(r12);     // Catch: Throwable -> L32
        goto L17
    L30:
        r5.close();
        r16.release();
        return r17;
    L32:
        th = th;
    L36:
        r5.close();
        r16.release();
        throw th;
    L34:
        th = th;
        r16 = r2;
        goto L36
    L5:
        r2.bindString(3, r42);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public List<cd> queryWithRawDbIds(List<Long> r40, int r41) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r40, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM AppEntityIndexPending WHERE rawDbId IN (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(") AND entityType = ");
        r3.append("?");
        int r5 = r4 + 1;
        RoomSQLiteQuery r6 = RoomSQLiteQuery.acquire(r3.toString(), r5);
        Iterator r2 = r1.iterator();
        int r7 = 1;
    L4:
        if (r2.hasNext() == false) goto L6;
        r6.bindLong(r7, ((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r7 = r7 + 1;
        goto L4
    L6:
        r6.bindLong(r5, r41);
        this.__db.assertNotSuspendingTransaction();
        Cursor r8 = DBUtil.query(this.__db, r6, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "rawDbId");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "entityType");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "timestamp");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "createTimeStamp");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "state");     // Catch: Throwable -> L34
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, "progress");     // Catch: Throwable -> L34
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "columnContent");     // Catch: Throwable -> L34
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, "buildType");     // Catch: Throwable -> L34
        int r17 = CursorUtil.getColumnIndexOrThrow(r8, "indexProgress");     // Catch: Throwable -> L34
        int r18 = CursorUtil.getColumnIndexOrThrow(r8, LBSLightLocationTraceLogger.TOTAL);     // Catch: Throwable -> L34
        int r19 = CursorUtil.getColumnIndexOrThrow(r8, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L34
        int r20 = CursorUtil.getColumnIndexOrThrow(r8, "isScheduledSlowTask");     // Catch: Throwable -> L34
        int r21 = CursorUtil.getColumnIndexOrThrow(r8, "retryCount");     // Catch: Throwable -> L34
        RoomSQLiteQuery r110 = r6;
        int r42 = CursorUtil.getColumnIndexOrThrow(r8, "nextRetryAt");     // Catch: Throwable -> L32
        int r111 = r21;
        ArrayList r22 = new ArrayList(r8.getCount());     // Catch: Throwable -> L32
    L10:
        if (r8.moveToNext() == false) goto L30;
        long r112 = r8.getLong(r0);     // Catch: Throwable -> L32
        long r23 = r8.getLong(r9);     // Catch: Throwable -> L32
        int r24 = r8.getInt(r10);     // Catch: Throwable -> L32
        long r25 = r8.getLong(r11);     // Catch: Throwable -> L32
        long r26 = r8.getLong(r12);     // Catch: Throwable -> L32
        int r28 = r8.getInt(r13);     // Catch: Throwable -> L32
        int r29 = r8.getInt(r14);     // Catch: Throwable -> L32
        if (r8.isNull(r15) == false) goto L15;
        String r30 = null;
    L17:
        if (r8.isNull(r16) == false) goto L19;
        String r31 = null;
    L20:
        int r32 = r8.getInt(r17);     // Catch: Throwable -> L32
        int r33 = r8.getInt(r18);     // Catch: Throwable -> L32
        if (r8.isNull(r19) == false) goto L23;
        String r34 = null;
    L25:
        if (r8.getInt(r20) == 0) goto L27;
        boolean r35 = true;
    L28:
        int r36 = r8.getInt(r111);     // Catch: Throwable -> L32
        int r113 = r0;
        int r27 = r42;
        r42 = r27;
        r22.add(new cd(r112, r23, r24, r25, r26, r28, r29, r30, r31, r32, r33, r34, r35, r36, r8.getLong(r27)));     // Catch: Throwable -> L32
        r0 = r113;
        r111 = r111;
        goto L10
    L27:
        r35 = false;
        goto L28
    L23:
        r34 = r8.getString(r19);     // Catch: Throwable -> L32
        goto L25
    L19:
        r31 = r8.getString(r16);     // Catch: Throwable -> L32
        goto L20
    L15:
        r30 = r8.getString(r15);     // Catch: Throwable -> L32
        goto L17
    L30:
        r8.close();
        r110.release();
        return r22;
    L32:
        th = th;
    L36:
        r8.close();
        r110.release();
        throw th;
    L34:
        th = th;
        r110 = r6;
        goto L36
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public List<cd> queryWithRawDbIdsAndColumn(List<Long> r39, int r40, String r41) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r39, List.class, "com.obric.memorydata.plugin");
        StringBuilder r4 = StringUtil.newStringBuilder();
        r4.append("SELECT * FROM AppEntityIndexPending WHERE rawDbId IN (");
        int r5 = r2.size();
        StringUtil.appendPlaceholders(r4, r5);
        r4.append(") AND entityType = ");
        r4.append("?");
        r4.append(" AND columnContent = ");
        r4.append("?");
        int r6 = r5 + 2;
        RoomSQLiteQuery r7 = RoomSQLiteQuery.acquire(r4.toString(), r6);
        Iterator r3 = r2.iterator();
        int r8 = 1;
    L4:
        if (r3.hasNext() == false) goto L6;
        r7.bindLong(r8, ((Long) ZeusTransformUtils.preCheckCast(r3.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r8 = r8 + 1;
        goto L4
    L6:
        r7.bindLong(r5 + 1, r40);
        if (r41 != null) goto L9;
        r7.bindNull(r6);
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r9 = DBUtil.query(this.__db, r7, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r9, OaidModel.KEY_ID);     // Catch: Throwable -> L38
        int r10 = CursorUtil.getColumnIndexOrThrow(r9, "rawDbId");     // Catch: Throwable -> L38
        int r11 = CursorUtil.getColumnIndexOrThrow(r9, "entityType");     // Catch: Throwable -> L38
        int r12 = CursorUtil.getColumnIndexOrThrow(r9, "timestamp");     // Catch: Throwable -> L38
        int r13 = CursorUtil.getColumnIndexOrThrow(r9, "createTimeStamp");     // Catch: Throwable -> L38
        int r14 = CursorUtil.getColumnIndexOrThrow(r9, "state");     // Catch: Throwable -> L38
        int r15 = CursorUtil.getColumnIndexOrThrow(r9, "progress");     // Catch: Throwable -> L38
        int r16 = CursorUtil.getColumnIndexOrThrow(r9, "columnContent");     // Catch: Throwable -> L38
        int r17 = CursorUtil.getColumnIndexOrThrow(r9, "buildType");     // Catch: Throwable -> L38
        int r18 = CursorUtil.getColumnIndexOrThrow(r9, "indexProgress");     // Catch: Throwable -> L38
        int r19 = CursorUtil.getColumnIndexOrThrow(r9, LBSLightLocationTraceLogger.TOTAL);     // Catch: Throwable -> L38
        int r1 = CursorUtil.getColumnIndexOrThrow(r9, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L38
        int r20 = CursorUtil.getColumnIndexOrThrow(r9, "isScheduledSlowTask");     // Catch: Throwable -> L38
        int r21 = CursorUtil.getColumnIndexOrThrow(r9, "retryCount");     // Catch: Throwable -> L38
        RoomSQLiteQuery r110 = r7;
        int r42 = CursorUtil.getColumnIndexOrThrow(r9, "nextRetryAt");     // Catch: Throwable -> L36
        int r43 = r21;
        ArrayList r22 = new ArrayList(r9.getCount());     // Catch: Throwable -> L36
    L14:
        if (r9.moveToNext() == false) goto L34;
        long r111 = r9.getLong(r0);     // Catch: Throwable -> L36
        long r23 = r9.getLong(r10);     // Catch: Throwable -> L36
        int r24 = r9.getInt(r11);     // Catch: Throwable -> L36
        long r25 = r9.getLong(r12);     // Catch: Throwable -> L36
        long r26 = r9.getLong(r13);     // Catch: Throwable -> L36
        int r27 = r9.getInt(r14);     // Catch: Throwable -> L36
        int r28 = r9.getInt(r15);     // Catch: Throwable -> L36
        if (r9.isNull(r16) == false) goto L19;
        String r29 = null;
    L21:
        if (r9.isNull(r17) == false) goto L23;
        String r30 = null;
    L24:
        int r31 = r9.getInt(r18);     // Catch: Throwable -> L36
        int r32 = r9.getInt(r19);     // Catch: Throwable -> L36
        if (r9.isNull(r1) == false) goto L27;
        String r33 = null;
    L29:
        if (r9.getInt(r20) == 0) goto L31;
        boolean r34 = true;
    L32:
        int r35 = r9.getInt(r43);     // Catch: Throwable -> L36
        int r44 = r0;
        int r36 = r42;
        r42 = r36;
        r22.add(new cd(r111, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r9.getLong(r36)));     // Catch: Throwable -> L36
        r0 = r44;
        r43 = r43;
        goto L14
    L31:
        r34 = false;
        goto L32
    L27:
        r33 = r9.getString(r1);     // Catch: Throwable -> L36
        goto L29
    L23:
        r30 = r9.getString(r17);     // Catch: Throwable -> L36
        goto L24
    L19:
        r29 = r9.getString(r16);     // Catch: Throwable -> L36
        goto L21
    L34:
        r9.close();
        r110.release();
        return r22;
    L36:
        th = th;
    L40:
        r9.close();
        r110.release();
        throw th;
    L38:
        th = th;
        r110 = r7;
        goto L40
    L9:
        r7.bindString(r6, r41);
        goto L10
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cd> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityIndexPendingEntity(r6));     // Catch: Throwable -> L10
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

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public void setStateByRawDbIdListAndEntityType(int r7, int r8, List<Long> r9, int r10, String r11) {
        IndexPendingDao.DefaultImpls.setStateByRawDbIdListAndEntityType(this, r7, r8, (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin"), r10, r11);
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public int update2(cd r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfIndexPendingEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(cd r3) {
        return update2((cd) ZeusTransformUtils.preCheckCast(r3, cd.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<cd> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfIndexPendingEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IndexPendingDao
    public int updateRetrySchedule(long r4, long r6, int r8, long r9) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateRetrySchedule.acquire();
        r0.bindLong(1, r8);
        r0.bindLong(2, r9);
        r0.bindLong(3, r4);
        r0.bindLong(4, r6);
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateRetrySchedule.release(r0);
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateRetrySchedule.release(r0);
        throw th;
    }
}
