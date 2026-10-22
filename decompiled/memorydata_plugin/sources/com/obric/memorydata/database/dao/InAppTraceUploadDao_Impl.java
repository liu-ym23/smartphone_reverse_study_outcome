package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.core.provider.FontsContractCompat;
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
import com.obric.memorydata.database.entity.cb;
import com.obric.memorydata.database.entity.cc;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class InAppTraceUploadDao_Impl implements InAppTraceUploadDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<cc> __deletionAdapterOfInAppTraceUploadEntity;
    private final EntityInsertionAdapter<cb> __insertionAdapterOfInAppTraceObservationEntity;
    private final EntityInsertionAdapter<cc> __insertionAdapterOfInAppTraceUploadEntity;
    private final SharedSQLiteStatement __preparedStmtOfClaim;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;
    private final SharedSQLiteStatement __preparedStmtOfUpdateState;
    private final EntityDeletionOrUpdateAdapter<cc> __updateAdapterOfInAppTraceUploadEntity;

    public InAppTraceUploadDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfInAppTraceUploadEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfInAppTraceObservationEntity = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfInAppTraceUploadEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfInAppTraceUploadEntity = new AnonymousClass4(this, r2);
        this.__preparedStmtOfDeleteAll = new AnonymousClass5(this, r2);
        this.__preparedStmtOfClaim = new AnonymousClass6(this, r2);
        this.__preparedStmtOfUpdateState = new AnonymousClass7(this, r2);
        this.__preparedStmtOfDeleteById = new AnonymousClass8(this, r2);
    }

    private cc __entityCursorConverter_comObricMemorydataDatabaseEntityInAppTraceUploadEntity(Cursor r51) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r51, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, FontsContractCompat.Columns.FILE_ID);
        int r3 = CursorUtil.getColumnIndex(r0, "trace_session_id");
        int r4 = CursorUtil.getColumnIndex(r0, "local_path");
        int r5 = CursorUtil.getColumnIndex(r0, "start_timestamp");
        int r6 = CursorUtil.getColumnIndex(r0, "end_timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, "event_count");
        int r8 = CursorUtil.getColumnIndex(r0, "zip_size");
        int r9 = CursorUtil.getColumnIndex(r0, "sha256");
        int r10 = CursorUtil.getColumnIndex(r0, "state");
        int r11 = CursorUtil.getColumnIndex(r0, "tos_uri");
        int r12 = CursorUtil.getColumnIndex(r0, "retry_count");
        int r13 = CursorUtil.getColumnIndex(r0, "next_retry_at");
        int r14 = CursorUtil.getColumnIndex(r0, "last_error");
        int r15 = CursorUtil.getColumnIndex(r0, "created_at");
        int r16 = CursorUtil.getColumnIndex(r0, "updated_at");
        int r17 = CursorUtil.getColumnIndex(r0, "lease_until");
        int r18 = CursorUtil.getColumnIndex(r0, "observation_id");
        long r19 = 0;
        if (r1 != (-1)) goto L5;
        long r23 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r25 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r26 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r27 = null;
    L25:
        if (r5 != (-1)) goto L27;
        long r28 = 0;
    L28:
        if (r6 != (-1)) goto L30;
        long r30 = 0;
    L31:
        int r21 = 0;
        if (r7 != (-1)) goto L34;
        int r32 = 0;
    L35:
        if (r8 != (-1)) goto L37;
        long r33 = 0;
    L38:
        if (r9 != (-1)) goto L41;
    L39:
        String r35 = null;
    L44:
        if (r10 != (-1)) goto L47;
    L45:
        String r36 = null;
    L50:
        if (r11 != (-1)) goto L53;
    L51:
        String r37 = null;
    L56:
        if (r12 == (-1)) goto L59;
        r21 = r0.getInt(r12);
    L59:
        int r38 = r21;
        if (r13 != (-1)) goto L62;
        long r39 = 0;
    L63:
        if (r14 != (-1)) goto L66;
    L64:
        String r41 = r20;
        if (r15 != (-1)) goto L71;
        long r42 = 0;
    L72:
        if (r51 != (-1)) goto L74;
        long r44 = 0;
    L75:
        if (r16 != (-1)) goto L77;
        long r46 = 0;
    L79:
        if (r18 == (-1)) goto L83;
        r19 = r0.getLong(r18);
    L83:
        return new cc(r23, r25, r26, r27, r28, r30, r32, r33, r35, r36, r37, r38, r39, r41, r42, r44, r46, r19);
    L77:
        r46 = r0.getLong(r17);
        goto L79
    L74:
        r44 = r0.getLong(r16);
        goto L75
    L71:
        r42 = r0.getLong(r15);
        goto L72
    L66:
        if (r0.isNull(r14) == true) goto L64;
        r20 = r0.getString(r14);
        goto L64
    L62:
        r39 = r0.getLong(r13);
        goto L63
    L53:
        if (r0.isNull(r11) == true) goto L51;
        r37 = r0.getString(r11);
        goto L56
    L47:
        if (r0.isNull(r10) == true) goto L45;
        r36 = r0.getString(r10);
        goto L50
    L41:
        if (r0.isNull(r9) == true) goto L39;
        r35 = r0.getString(r9);
        goto L44
    L37:
        r33 = r0.getLong(r8);
        goto L38
    L34:
        r32 = r0.getInt(r7);
        goto L35
    L30:
        r30 = r0.getLong(r6);
        goto L31
    L27:
        r28 = r0.getLong(r5);
        goto L28
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r27 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r26 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r25 = r0.getString(r2);
        goto L13
    L5:
        r23 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public int activateObservationLinks(List<Long> r5, long r6, long r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE InAppTraceUpload SET observation_id = CASE WHEN observation_id = 0 THEN ");
        r0.append("?");
        r0.append(" ELSE observation_id END, state = CASE WHEN state = 'WAIT_OBSERVATION' AND tos_uri = '' THEN 'READY' WHEN state = 'WAIT_OBSERVATION' THEN 'TOS_UPLOADED' ELSE state END, updated_at = ");
        r0.append("?");
        r0.append(" WHERE id IN (");
        StringUtil.appendPlaceholders(r0, r7.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        r2.bindLong(1, r6);
        r2.bindLong(2, r8);
        Iterator r9 = r7.iterator();
        int r10 = 3;
    L4:
        if (r9.hasNext() == false) goto L6;
        r2.bindLong(r10, ((Long) ZeusTransformUtils.preCheckCast(r9.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r10 = r10 + 1;
        goto L4
    L6:
        this.__db.beginTransaction();
        int r11 = r2.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        return r11;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<cc> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfInAppTraceUploadEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao, com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<cc> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfInAppTraceUploadEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public int claim(long r3, String r5, long r6, String r8, long r9, long r11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfClaim.acquire();
        if (r8 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r9);
        r0.bindLong(3, r11);
        r0.bindLong(4, r3);
        if (r5 != null) goto L9;
        r0.bindNull(5);
    L10:
        r0.bindLong(6, r6);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfClaim.release(r0);
        return r4;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfClaim.release(r0);
        throw th;
    L9:
        r0.bindString(5, r5);
        goto L10
    L5:
        r0.bindString(1, r8);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public int countObservationLinks(long r3) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM InAppTraceObservation WHERE trace_row_id = ?", 1);
        r0.bindLong(1, r3);
        this.__db.assertNotSuspendingTransaction();
        int r4 = 0;
        Cursor r2 = DBUtil.query(this.__db, r0, false, null);
    L8:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L6;
        r4 = r2.getInt(0);     // Catch: Throwable -> L8
    L6:
        r2.close();
        r0.release();
        return r4;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(cc r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfInAppTraceUploadEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(cc r3) {
        return delete2((cc) ZeusTransformUtils.preCheckCast(r3, cc.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao, com.obric.memorydata.database.dao.BaseDao
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

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
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

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public int deleteObservationLinks(List<Long> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM InAppTraceObservation WHERE observation_id IN (");
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

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return InAppTraceUploadDao.DefaultImpls.getTableName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public long insert(cc r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfInAppTraceUploadEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(cc r3) {
        return insert((cc) ZeusTransformUtils.preCheckCast(r3, cc.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao, com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<cc> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfInAppTraceUploadEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public List<Long> insertObservationLinks(List<cb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfInAppTraceObservationEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public int linkToObservation(List<Long> r7, long r8, long r10) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        int r9 = InAppTraceUploadDao.DefaultImpls.linkToObservation(this, r1, r8, r10);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r9;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cc> queryAll() {
        return InAppTraceUploadDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return InAppTraceUploadDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cc queryById(long r1) {
        return InAppTraceUploadDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cc queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cc> queryByIds(List<Long> r3) {
        return InAppTraceUploadDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public cc queryByLocalPath(String r49) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM InAppTraceUpload WHERE local_path = ? LIMIT 1", 1);
        if (r49 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L46
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L46
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "trace_session_id");     // Catch: Throwable -> L46
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "local_path");     // Catch: Throwable -> L46
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "start_timestamp");     // Catch: Throwable -> L46
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "end_timestamp");     // Catch: Throwable -> L46
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "event_count");     // Catch: Throwable -> L46
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "zip_size");     // Catch: Throwable -> L46
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "sha256");     // Catch: Throwable -> L46
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "state");     // Catch: Throwable -> L46
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "tos_uri");     // Catch: Throwable -> L46
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "retry_count");     // Catch: Throwable -> L46
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "next_retry_at");     // Catch: Throwable -> L46
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "last_error");     // Catch: Throwable -> L46
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "created_at");     // Catch: Throwable -> L44
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "updated_at");     // Catch: Throwable -> L44
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "lease_until");     // Catch: Throwable -> L44
        int r20 = CursorUtil.getColumnIndexOrThrow(r1, "observation_id");     // Catch: Throwable -> L44
        if (r1.moveToFirst() == false) goto L41;
        long r21 = r1.getLong(r0);     // Catch: Throwable -> L44
        if (r1.isNull(r4) == false) goto L14;
        String r23 = null;
    L16:
        if (r1.isNull(r5) == false) goto L18;
        String r24 = null;
    L20:
        if (r1.isNull(r6) == false) goto L22;
        String r25 = null;
    L23:
        long r26 = r1.getLong(r7);     // Catch: Throwable -> L44
        long r28 = r1.getLong(r8);     // Catch: Throwable -> L44
        int r30 = r1.getInt(r9);     // Catch: Throwable -> L44
        long r31 = r1.getLong(r10);     // Catch: Throwable -> L44
        if (r1.isNull(r11) == false) goto L26;
        String r33 = null;
    L28:
        if (r1.isNull(r12) == false) goto L30;
        String r34 = null;
    L32:
        if (r1.isNull(r13) == false) goto L34;
        String r35 = null;
    L35:
        int r36 = r1.getInt(r14);     // Catch: Throwable -> L44
        long r37 = r1.getLong(r15);     // Catch: Throwable -> L44
        if (r1.isNull(r3) == false) goto L38;
        String r39 = null;
    L39:
        cc r22 = new cc(r21, r23, r24, r25, r26, r28, r30, r31, r33, r34, r35, r36, r37, r39, r1.getLong(r17), r1.getLong(r18), r1.getLong(r19), r1.getLong(r20));     // Catch: Throwable -> L44
    L42:
        r1.close();
        r16.release();
        return r22;
    L38:
        r39 = r1.getString(r3);     // Catch: Throwable -> L44
        goto L39
    L34:
        r35 = r1.getString(r13);     // Catch: Throwable -> L44
        goto L35
    L30:
        r34 = r1.getString(r12);     // Catch: Throwable -> L44
        goto L32
    L26:
        r33 = r1.getString(r11);     // Catch: Throwable -> L44
        goto L28
    L22:
        r25 = r1.getString(r6);     // Catch: Throwable -> L44
        goto L23
    L18:
        r24 = r1.getString(r5);     // Catch: Throwable -> L44
        goto L20
    L14:
        r23 = r1.getString(r4);     // Catch: Throwable -> L44
        goto L16
    L41:
        r22 = null;
    L44:
        th = th;
    L48:
        r1.close();
        r16.release();
        throw th;
    L46:
        th = th;
        r16 = r2;
        goto L48
    L5:
        r2.bindString(1, r49);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public List<cc> queryByObservationIds(List<Long> r51) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r51, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM InAppTraceUpload WHERE observation_id IN (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(") ORDER BY start_timestamp ASC");
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
        int r0 = CursorUtil.getColumnIndexOrThrow(r7, OaidModel.KEY_ID);     // Catch: Throwable -> L47
        int r8 = CursorUtil.getColumnIndexOrThrow(r7, FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L47
        int r9 = CursorUtil.getColumnIndexOrThrow(r7, "trace_session_id");     // Catch: Throwable -> L47
        int r10 = CursorUtil.getColumnIndexOrThrow(r7, "local_path");     // Catch: Throwable -> L47
        int r11 = CursorUtil.getColumnIndexOrThrow(r7, "start_timestamp");     // Catch: Throwable -> L47
        int r12 = CursorUtil.getColumnIndexOrThrow(r7, "end_timestamp");     // Catch: Throwable -> L47
        int r13 = CursorUtil.getColumnIndexOrThrow(r7, "event_count");     // Catch: Throwable -> L47
        int r14 = CursorUtil.getColumnIndexOrThrow(r7, "zip_size");     // Catch: Throwable -> L47
        int r15 = CursorUtil.getColumnIndexOrThrow(r7, "sha256");     // Catch: Throwable -> L47
        int r16 = CursorUtil.getColumnIndexOrThrow(r7, "state");     // Catch: Throwable -> L47
        int r17 = CursorUtil.getColumnIndexOrThrow(r7, "tos_uri");     // Catch: Throwable -> L47
        int r18 = CursorUtil.getColumnIndexOrThrow(r7, "retry_count");     // Catch: Throwable -> L47
        int r19 = CursorUtil.getColumnIndexOrThrow(r7, "next_retry_at");     // Catch: Throwable -> L47
        int r20 = CursorUtil.getColumnIndexOrThrow(r7, "last_error");     // Catch: Throwable -> L47
        RoomSQLiteQuery r52 = r5;
        int r110 = CursorUtil.getColumnIndexOrThrow(r7, "created_at");     // Catch: Throwable -> L45
        int r111 = CursorUtil.getColumnIndexOrThrow(r7, "updated_at");     // Catch: Throwable -> L45
        int r112 = CursorUtil.getColumnIndexOrThrow(r7, "lease_until");     // Catch: Throwable -> L45
        int r113 = CursorUtil.getColumnIndexOrThrow(r7, "observation_id");     // Catch: Throwable -> L45
        int r21 = r20;
        ArrayList r22 = new ArrayList(r7.getCount());     // Catch: Throwable -> L45
    L10:
        if (r7.moveToNext() == false) goto L43;
        long r23 = r7.getLong(r0);     // Catch: Throwable -> L45
        if (r7.isNull(r8) == false) goto L15;
        String r24 = null;
    L17:
        if (r7.isNull(r9) == false) goto L19;
        String r25 = null;
    L21:
        if (r7.isNull(r10) == false) goto L23;
        String r26 = null;
    L24:
        long r27 = r7.getLong(r11);     // Catch: Throwable -> L45
        long r29 = r7.getLong(r12);     // Catch: Throwable -> L45
        int r31 = r7.getInt(r13);     // Catch: Throwable -> L45
        long r32 = r7.getLong(r14);     // Catch: Throwable -> L45
        if (r7.isNull(r15) == false) goto L27;
        String r34 = null;
    L29:
        if (r7.isNull(r16) == false) goto L31;
        String r35 = null;
    L33:
        if (r7.isNull(r17) == false) goto L35;
        String r36 = null;
    L36:
        int r37 = r7.getInt(r18);     // Catch: Throwable -> L45
        long r38 = r7.getLong(r19);     // Catch: Throwable -> L45
        int r28 = r21;
        if (r7.isNull(r28) == false) goto L40;
        String r40 = null;
    L39:
        int r49 = r110;
        int r114 = r0;
        long r41 = r7.getLong(r49);     // Catch: Throwable -> L45
        int r30 = r111;
        long r43 = r7.getLong(r30);     // Catch: Throwable -> L45
        r111 = r30;
        int r33 = r112;
        long r45 = r7.getLong(r33);     // Catch: Throwable -> L45
        r112 = r33;
        int r39 = r113;
        r113 = r39;
        r22.add(new cc(r23, r24, r25, r26, r27, r29, r31, r32, r34, r35, r36, r37, r38, r40, r41, r43, r45, r7.getLong(r39)));     // Catch: Throwable -> L45
        r0 = r114;
        r110 = r49;
        r21 = r28;
        goto L10
    L40:
        r40 = r7.getString(r28);     // Catch: Throwable -> L45
        goto L39
    L35:
        r36 = r7.getString(r17);     // Catch: Throwable -> L45
        goto L36
    L31:
        r35 = r7.getString(r16);     // Catch: Throwable -> L45
        goto L33
    L27:
        r34 = r7.getString(r15);     // Catch: Throwable -> L45
        goto L29
    L23:
        r26 = r7.getString(r10);     // Catch: Throwable -> L45
        goto L24
    L19:
        r25 = r7.getString(r9);     // Catch: Throwable -> L45
        goto L21
    L15:
        r24 = r7.getString(r8);     // Catch: Throwable -> L45
        goto L17
    L43:
        r7.close();
        r52.release();
        return r22;
    L45:
        th = th;
    L49:
        r7.close();
        r52.release();
        throw th;
    L47:
        th = th;
        r52 = r5;
        goto L49
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cc queryByUUID(String r1) {
        return InAppTraceUploadDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cc queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public cc queryFirstByState(String r49) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM InAppTraceUpload WHERE state = ? ORDER BY created_at ASC LIMIT 1", 1);
        if (r49 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L46
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L46
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "trace_session_id");     // Catch: Throwable -> L46
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "local_path");     // Catch: Throwable -> L46
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "start_timestamp");     // Catch: Throwable -> L46
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "end_timestamp");     // Catch: Throwable -> L46
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "event_count");     // Catch: Throwable -> L46
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "zip_size");     // Catch: Throwable -> L46
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "sha256");     // Catch: Throwable -> L46
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "state");     // Catch: Throwable -> L46
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "tos_uri");     // Catch: Throwable -> L46
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "retry_count");     // Catch: Throwable -> L46
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "next_retry_at");     // Catch: Throwable -> L46
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "last_error");     // Catch: Throwable -> L46
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "created_at");     // Catch: Throwable -> L44
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "updated_at");     // Catch: Throwable -> L44
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "lease_until");     // Catch: Throwable -> L44
        int r20 = CursorUtil.getColumnIndexOrThrow(r1, "observation_id");     // Catch: Throwable -> L44
        if (r1.moveToFirst() == false) goto L41;
        long r21 = r1.getLong(r0);     // Catch: Throwable -> L44
        if (r1.isNull(r4) == false) goto L14;
        String r23 = null;
    L16:
        if (r1.isNull(r5) == false) goto L18;
        String r24 = null;
    L20:
        if (r1.isNull(r6) == false) goto L22;
        String r25 = null;
    L23:
        long r26 = r1.getLong(r7);     // Catch: Throwable -> L44
        long r28 = r1.getLong(r8);     // Catch: Throwable -> L44
        int r30 = r1.getInt(r9);     // Catch: Throwable -> L44
        long r31 = r1.getLong(r10);     // Catch: Throwable -> L44
        if (r1.isNull(r11) == false) goto L26;
        String r33 = null;
    L28:
        if (r1.isNull(r12) == false) goto L30;
        String r34 = null;
    L32:
        if (r1.isNull(r13) == false) goto L34;
        String r35 = null;
    L35:
        int r36 = r1.getInt(r14);     // Catch: Throwable -> L44
        long r37 = r1.getLong(r15);     // Catch: Throwable -> L44
        if (r1.isNull(r3) == false) goto L38;
        String r39 = null;
    L39:
        cc r22 = new cc(r21, r23, r24, r25, r26, r28, r30, r31, r33, r34, r35, r36, r37, r39, r1.getLong(r17), r1.getLong(r18), r1.getLong(r19), r1.getLong(r20));     // Catch: Throwable -> L44
    L42:
        r1.close();
        r16.release();
        return r22;
    L38:
        r39 = r1.getString(r3);     // Catch: Throwable -> L44
        goto L39
    L34:
        r35 = r1.getString(r13);     // Catch: Throwable -> L44
        goto L35
    L30:
        r34 = r1.getString(r12);     // Catch: Throwable -> L44
        goto L32
    L26:
        r33 = r1.getString(r11);     // Catch: Throwable -> L44
        goto L28
    L22:
        r25 = r1.getString(r6);     // Catch: Throwable -> L44
        goto L23
    L18:
        r24 = r1.getString(r5);     // Catch: Throwable -> L44
        goto L20
    L14:
        r23 = r1.getString(r4);     // Catch: Throwable -> L44
        goto L16
    L41:
        r22 = null;
    L44:
        th = th;
    L48:
        r1.close();
        r16.release();
        throw th;
    L46:
        th = th;
        r16 = r2;
        goto L48
    L5:
        r2.bindString(1, r49);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public List<cc> queryLinkableInWindow(long r48, long r50) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM InAppTraceUpload WHERE state NOT IN ('DELETE_PENDING', 'COMPLETED', 'FILE_DELETED', 'DEBUG_TOS_READY', 'DEBUG_REPORT_READY', 'DEBUG_COMPLETED') AND end_timestamp > ? AND start_timestamp <= ? ORDER BY end_timestamp ASC", 2);
        r1.bindLong(1, r48);
        r1.bindLong(2, r50);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L43
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L43
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "trace_session_id");     // Catch: Throwable -> L43
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "local_path");     // Catch: Throwable -> L43
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "start_timestamp");     // Catch: Throwable -> L43
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "end_timestamp");     // Catch: Throwable -> L43
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "event_count");     // Catch: Throwable -> L43
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "zip_size");     // Catch: Throwable -> L43
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "sha256");     // Catch: Throwable -> L43
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L43
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "tos_uri");     // Catch: Throwable -> L43
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "retry_count");     // Catch: Throwable -> L43
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "next_retry_at");     // Catch: Throwable -> L43
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "last_error");     // Catch: Throwable -> L43
        RoomSQLiteQuery r16 = r1;
        int r49 = CursorUtil.getColumnIndexOrThrow(r2, "created_at");     // Catch: Throwable -> L41
        int r410 = CursorUtil.getColumnIndexOrThrow(r2, "updated_at");     // Catch: Throwable -> L41
        int r51 = CursorUtil.getColumnIndexOrThrow(r2, "lease_until");     // Catch: Throwable -> L41
        int r52 = CursorUtil.getColumnIndexOrThrow(r2, "observation_id");     // Catch: Throwable -> L41
        int r17 = r3;
        ArrayList r18 = new ArrayList(r2.getCount());     // Catch: Throwable -> L41
    L6:
        if (r2.moveToNext() == false) goto L39;
        long r19 = r2.getLong(r0);     // Catch: Throwable -> L41
        if (r2.isNull(r4) == false) goto L11;
        String r21 = null;
    L13:
        if (r2.isNull(r5) == false) goto L15;
        String r22 = null;
    L17:
        if (r2.isNull(r6) == false) goto L19;
        String r23 = null;
    L20:
        long r24 = r2.getLong(r7);     // Catch: Throwable -> L41
        long r26 = r2.getLong(r8);     // Catch: Throwable -> L41
        int r28 = r2.getInt(r9);     // Catch: Throwable -> L41
        long r29 = r2.getLong(r10);     // Catch: Throwable -> L41
        if (r2.isNull(r11) == false) goto L23;
        String r31 = null;
    L25:
        if (r2.isNull(r12) == false) goto L27;
        String r32 = null;
    L29:
        if (r2.isNull(r13) == false) goto L31;
        String r33 = null;
    L32:
        int r34 = r2.getInt(r14);     // Catch: Throwable -> L41
        long r35 = r2.getLong(r15);     // Catch: Throwable -> L41
        int r20 = r17;
        if (r2.isNull(r20) == false) goto L36;
        String r37 = null;
    L35:
        int r46 = r0;
        int r25 = r49;
        long r38 = r2.getLong(r25);     // Catch: Throwable -> L41
        int r27 = r410;
        long r40 = r2.getLong(r27);     // Catch: Throwable -> L41
        r410 = r27;
        int r30 = r51;
        long r42 = r2.getLong(r30);     // Catch: Throwable -> L41
        r51 = r30;
        int r36 = r52;
        r52 = r36;
        r18.add(new cc(r19, r21, r22, r23, r24, r26, r28, r29, r31, r32, r33, r34, r35, r37, r38, r40, r42, r2.getLong(r36)));     // Catch: Throwable -> L41
        r0 = r46;
        r49 = r25;
        r17 = r20;
        goto L6
    L36:
        r37 = r2.getString(r20);     // Catch: Throwable -> L41
        goto L35
    L31:
        r33 = r2.getString(r13);     // Catch: Throwable -> L41
        goto L32
    L27:
        r32 = r2.getString(r12);     // Catch: Throwable -> L41
        goto L29
    L23:
        r31 = r2.getString(r11);     // Catch: Throwable -> L41
        goto L25
    L19:
        r23 = r2.getString(r6);     // Catch: Throwable -> L41
        goto L20
    L15:
        r22 = r2.getString(r5);     // Catch: Throwable -> L41
        goto L17
    L11:
        r21 = r2.getString(r4);     // Catch: Throwable -> L41
        goto L13
    L39:
        r2.close();
        r16.release();
        return r18;
    L41:
        th = th;
    L45:
        r2.close();
        r16.release();
        throw th;
    L43:
        th = th;
        r16 = r1;
        goto L45
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public List<InAppTraceObservationRow> queryLinkedByObservationIds(List<Long> r54) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r54, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT t.*, l.observation_id AS linked_observation_id FROM InAppTraceUpload t INNER JOIN InAppTraceObservation l ON l.trace_row_id = t.id WHERE l.observation_id IN (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(") ORDER BY t.start_timestamp ASC, l.observation_id ASC");
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
        int r0 = CursorUtil.getColumnIndexOrThrow(r7, OaidModel.KEY_ID);     // Catch: Throwable -> L47
        int r8 = CursorUtil.getColumnIndexOrThrow(r7, FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L47
        int r9 = CursorUtil.getColumnIndexOrThrow(r7, "trace_session_id");     // Catch: Throwable -> L47
        int r10 = CursorUtil.getColumnIndexOrThrow(r7, "local_path");     // Catch: Throwable -> L47
        int r11 = CursorUtil.getColumnIndexOrThrow(r7, "start_timestamp");     // Catch: Throwable -> L47
        int r12 = CursorUtil.getColumnIndexOrThrow(r7, "end_timestamp");     // Catch: Throwable -> L47
        int r13 = CursorUtil.getColumnIndexOrThrow(r7, "event_count");     // Catch: Throwable -> L47
        int r14 = CursorUtil.getColumnIndexOrThrow(r7, "zip_size");     // Catch: Throwable -> L47
        int r15 = CursorUtil.getColumnIndexOrThrow(r7, "sha256");     // Catch: Throwable -> L47
        int r16 = CursorUtil.getColumnIndexOrThrow(r7, "state");     // Catch: Throwable -> L47
        int r17 = CursorUtil.getColumnIndexOrThrow(r7, "tos_uri");     // Catch: Throwable -> L47
        int r18 = CursorUtil.getColumnIndexOrThrow(r7, "retry_count");     // Catch: Throwable -> L47
        int r19 = CursorUtil.getColumnIndexOrThrow(r7, "next_retry_at");     // Catch: Throwable -> L47
        int r20 = CursorUtil.getColumnIndexOrThrow(r7, "last_error");     // Catch: Throwable -> L47
        RoomSQLiteQuery r55 = r5;
        int r110 = CursorUtil.getColumnIndexOrThrow(r7, "created_at");     // Catch: Throwable -> L45
        int r111 = CursorUtil.getColumnIndexOrThrow(r7, "updated_at");     // Catch: Throwable -> L45
        int r112 = CursorUtil.getColumnIndexOrThrow(r7, "lease_until");     // Catch: Throwable -> L45
        int r113 = CursorUtil.getColumnIndexOrThrow(r7, "observation_id");     // Catch: Throwable -> L45
        int r21 = CursorUtil.getColumnIndexOrThrow(r7, "linked_observation_id");     // Catch: Throwable -> L45
        int r22 = r20;
        int r23 = r19;
        ArrayList r24 = new ArrayList(r7.getCount());     // Catch: Throwable -> L45
    L10:
        if (r7.moveToNext() == false) goto L43;
        int r25 = r18;
        long r114 = r7.getLong(r21);     // Catch: Throwable -> L45
        long r26 = r7.getLong(r0);     // Catch: Throwable -> L45
        if (r7.isNull(r8) == false) goto L15;
        String r27 = null;
    L17:
        if (r7.isNull(r9) == false) goto L19;
        String r28 = null;
    L21:
        if (r7.isNull(r10) == false) goto L23;
        String r29 = null;
    L24:
        long r210 = r7.getLong(r11);     // Catch: Throwable -> L45
        long r31 = r7.getLong(r12);     // Catch: Throwable -> L45
        int r33 = r7.getInt(r13);     // Catch: Throwable -> L45
        long r34 = r7.getLong(r14);     // Catch: Throwable -> L45
        if (r7.isNull(r15) == false) goto L27;
        String r36 = null;
    L29:
        if (r7.isNull(r16) == false) goto L31;
        String r37 = null;
    L33:
        if (r7.isNull(r17) == false) goto L36;
        String r38 = null;
    L35:
        int r211 = r0;
        int r39 = r7.getInt(r25);     // Catch: Throwable -> L45
        int r30 = r23;
        long r40 = r7.getLong(r30);     // Catch: Throwable -> L45
        r23 = r30;
        r22 = r22;
        if (r7.isNull(r22) == false) goto L40;
        String r42 = null;
    L41:
        long r43 = r7.getLong(r110);     // Catch: Throwable -> L45
        r110 = r110;
        int r32 = r111;
        long r45 = r7.getLong(r32);     // Catch: Throwable -> L45
        r111 = r32;
        int r35 = r112;
        long r47 = r7.getLong(r35);     // Catch: Throwable -> L45
        r112 = r35;
        int r41 = r113;
        r113 = r41;
        int r212 = r21;
        r24.add(new InAppTraceObservationRow(new cc(r26, r27, r28, r29, r210, r31, r33, r34, r36, r37, r38, r39, r40, r42, r43, r45, r47, r7.getLong(r41)), r114));     // Catch: Throwable -> L45
        r0 = r211;
        r21 = r212;
        r18 = r25;
        goto L10
    L40:
        r42 = r7.getString(r22);     // Catch: Throwable -> L45
        goto L41
    L36:
        r38 = r7.getString(r17);     // Catch: Throwable -> L45
        goto L35
    L31:
        r37 = r7.getString(r16);     // Catch: Throwable -> L45
        goto L33
    L27:
        r36 = r7.getString(r15);     // Catch: Throwable -> L45
        goto L29
    L23:
        r29 = r7.getString(r10);     // Catch: Throwable -> L45
        goto L24
    L19:
        r28 = r7.getString(r9);     // Catch: Throwable -> L45
        goto L21
    L15:
        r27 = r7.getString(r8);     // Catch: Throwable -> L45
        goto L17
    L43:
        r7.close();
        r55.release();
        return r24;
    L45:
        th = th;
    L49:
        r7.close();
        r55.release();
        throw th;
    L47:
        th = th;
        r55 = r5;
        goto L49
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public List<String> queryLocalPathsByIds(List<Long> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT local_path FROM InAppTraceUpload WHERE id IN (");
        int r2 = r9.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r10 = r9.iterator();
        int r4 = 1;
    L4:
        if (r10.hasNext() == false) goto L6;
        r1.bindLong(r4, ((Long) ZeusTransformUtils.preCheckCast(r10.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r4 = r4 + 1;
        goto L4
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r1, false, null);
        ArrayList r3 = new ArrayList(r7.getCount());     // Catch: Throwable -> L18
    L8:
        if (r7.moveToNext() == false) goto L16;
        if (r7.isNull(0) == false) goto L13;
        String r5 = null;
    L14:
        r3.add(r5);     // Catch: Throwable -> L18
        goto L8
    L13:
        r5 = r7.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r7.close();
        r1.release();
        return r3;
    L18:
        th = move-exception;
        r7.close();
        r1.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cc queryOne() {
        return InAppTraceUploadDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cc queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public List<cc> queryRecent(int r51) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM InAppTraceUpload ORDER BY created_at DESC LIMIT ?", 1);
        r1.bindLong(1, r51);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L43
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L43
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "trace_session_id");     // Catch: Throwable -> L43
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "local_path");     // Catch: Throwable -> L43
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "start_timestamp");     // Catch: Throwable -> L43
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "end_timestamp");     // Catch: Throwable -> L43
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "event_count");     // Catch: Throwable -> L43
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "zip_size");     // Catch: Throwable -> L43
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "sha256");     // Catch: Throwable -> L43
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L43
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "tos_uri");     // Catch: Throwable -> L43
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "retry_count");     // Catch: Throwable -> L43
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "next_retry_at");     // Catch: Throwable -> L43
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "last_error");     // Catch: Throwable -> L43
        RoomSQLiteQuery r16 = r1;
        int r52 = CursorUtil.getColumnIndexOrThrow(r2, "created_at");     // Catch: Throwable -> L41
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "updated_at");     // Catch: Throwable -> L41
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "lease_until");     // Catch: Throwable -> L41
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "observation_id");     // Catch: Throwable -> L41
        int r20 = r3;
        ArrayList r21 = new ArrayList(r2.getCount());     // Catch: Throwable -> L41
    L6:
        if (r2.moveToNext() == false) goto L39;
        long r22 = r2.getLong(r0);     // Catch: Throwable -> L41
        if (r2.isNull(r4) == false) goto L11;
        String r24 = null;
    L13:
        if (r2.isNull(r5) == false) goto L15;
        String r25 = null;
    L17:
        if (r2.isNull(r6) == false) goto L19;
        String r26 = null;
    L20:
        long r27 = r2.getLong(r7);     // Catch: Throwable -> L41
        long r29 = r2.getLong(r8);     // Catch: Throwable -> L41
        int r31 = r2.getInt(r9);     // Catch: Throwable -> L41
        long r32 = r2.getLong(r10);     // Catch: Throwable -> L41
        if (r2.isNull(r11) == false) goto L23;
        String r34 = null;
    L25:
        if (r2.isNull(r12) == false) goto L27;
        String r35 = null;
    L29:
        if (r2.isNull(r13) == false) goto L31;
        String r36 = null;
    L32:
        int r37 = r2.getInt(r14);     // Catch: Throwable -> L41
        long r38 = r2.getLong(r15);     // Catch: Throwable -> L41
        int r23 = r20;
        if (r2.isNull(r23) == false) goto L36;
        String r40 = null;
    L35:
        int r49 = r0;
        int r28 = r52;
        long r41 = r2.getLong(r28);     // Catch: Throwable -> L41
        int r30 = r17;
        long r43 = r2.getLong(r30);     // Catch: Throwable -> L41
        r17 = r30;
        int r33 = r18;
        long r45 = r2.getLong(r33);     // Catch: Throwable -> L41
        r18 = r33;
        int r39 = r19;
        r19 = r39;
        r21.add(new cc(r22, r24, r25, r26, r27, r29, r31, r32, r34, r35, r36, r37, r38, r40, r41, r43, r45, r2.getLong(r39)));     // Catch: Throwable -> L41
        r0 = r49;
        r52 = r28;
        r20 = r23;
        goto L6
    L36:
        r40 = r2.getString(r23);     // Catch: Throwable -> L41
        goto L35
    L31:
        r36 = r2.getString(r13);     // Catch: Throwable -> L41
        goto L32
    L27:
        r35 = r2.getString(r12);     // Catch: Throwable -> L41
        goto L29
    L23:
        r34 = r2.getString(r11);     // Catch: Throwable -> L41
        goto L25
    L19:
        r26 = r2.getString(r6);     // Catch: Throwable -> L41
        goto L20
    L15:
        r25 = r2.getString(r5);     // Catch: Throwable -> L41
        goto L17
    L11:
        r24 = r2.getString(r4);     // Catch: Throwable -> L41
        goto L13
    L39:
        r2.close();
        r16.release();
        return r21;
    L41:
        th = th;
    L45:
        r2.close();
        r16.release();
        throw th;
    L43:
        th = th;
        r16 = r1;
        goto L45
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public List<cc> queryRunnable(long r49, int r51) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM InAppTraceUpload WHERE (state = 'READY' AND next_retry_at <= ?) OR (state = 'TOS_UPLOADING' AND lease_until <= ?) OR state = 'DELETE_PENDING' ORDER BY created_at ASC LIMIT ?", 3);
        r3.bindLong(1, r49);
        r3.bindLong(2, r49);
        r3.bindLong(3, r51);
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L43
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L43
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "trace_session_id");     // Catch: Throwable -> L43
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "local_path");     // Catch: Throwable -> L43
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "start_timestamp");     // Catch: Throwable -> L43
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "end_timestamp");     // Catch: Throwable -> L43
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "event_count");     // Catch: Throwable -> L43
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "zip_size");     // Catch: Throwable -> L43
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "sha256");     // Catch: Throwable -> L43
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "state");     // Catch: Throwable -> L43
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "tos_uri");     // Catch: Throwable -> L43
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "retry_count");     // Catch: Throwable -> L43
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "next_retry_at");     // Catch: Throwable -> L43
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, "last_error");     // Catch: Throwable -> L43
        RoomSQLiteQuery r16 = r3;
        int r410 = CursorUtil.getColumnIndexOrThrow(r1, "created_at");     // Catch: Throwable -> L41
        int r50 = CursorUtil.getColumnIndexOrThrow(r1, "updated_at");     // Catch: Throwable -> L41
        int r52 = CursorUtil.getColumnIndexOrThrow(r1, "lease_until");     // Catch: Throwable -> L41
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "observation_id");     // Catch: Throwable -> L41
        int r18 = r2;
        ArrayList r19 = new ArrayList(r1.getCount());     // Catch: Throwable -> L41
    L6:
        if (r1.moveToNext() == false) goto L39;
        long r20 = r1.getLong(r0);     // Catch: Throwable -> L41
        if (r1.isNull(r4) == false) goto L11;
        String r22 = null;
    L13:
        if (r1.isNull(r5) == false) goto L15;
        String r23 = null;
    L17:
        if (r1.isNull(r6) == false) goto L19;
        String r24 = null;
    L20:
        long r25 = r1.getLong(r7);     // Catch: Throwable -> L41
        long r27 = r1.getLong(r8);     // Catch: Throwable -> L41
        int r29 = r1.getInt(r9);     // Catch: Throwable -> L41
        long r30 = r1.getLong(r10);     // Catch: Throwable -> L41
        if (r1.isNull(r11) == false) goto L23;
        String r32 = null;
    L25:
        if (r1.isNull(r12) == false) goto L27;
        String r33 = null;
    L29:
        if (r1.isNull(r13) == false) goto L31;
        String r34 = null;
    L32:
        int r35 = r1.getInt(r14);     // Catch: Throwable -> L41
        long r36 = r1.getLong(r15);     // Catch: Throwable -> L41
        int r21 = r18;
        if (r1.isNull(r21) == false) goto L36;
        String r38 = null;
    L35:
        int r47 = r0;
        int r26 = r410;
        long r39 = r1.getLong(r26);     // Catch: Throwable -> L41
        int r28 = r50;
        long r41 = r1.getLong(r28);     // Catch: Throwable -> L41
        r50 = r28;
        int r31 = r52;
        long r43 = r1.getLong(r31);     // Catch: Throwable -> L41
        r52 = r31;
        int r37 = r17;
        r17 = r37;
        r19.add(new cc(r20, r22, r23, r24, r25, r27, r29, r30, r32, r33, r34, r35, r36, r38, r39, r41, r43, r1.getLong(r37)));     // Catch: Throwable -> L41
        r0 = r47;
        r410 = r26;
        r18 = r21;
        goto L6
    L36:
        r38 = r1.getString(r21);     // Catch: Throwable -> L41
        goto L35
    L31:
        r34 = r1.getString(r13);     // Catch: Throwable -> L41
        goto L32
    L27:
        r33 = r1.getString(r12);     // Catch: Throwable -> L41
        goto L29
    L23:
        r32 = r1.getString(r11);     // Catch: Throwable -> L41
        goto L25
    L19:
        r24 = r1.getString(r6);     // Catch: Throwable -> L41
        goto L20
    L15:
        r23 = r1.getString(r5);     // Catch: Throwable -> L41
        goto L17
    L11:
        r22 = r1.getString(r4);     // Catch: Throwable -> L41
        goto L13
    L39:
        r1.close();
        r16.release();
        return r19;
    L41:
        th = th;
    L45:
        r1.close();
        r16.release();
        throw th;
    L43:
        th = th;
        r16 = r3;
        goto L45
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public List<String> querySafeLocalPathsForAging(List<Long> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT local_path FROM InAppTraceUpload WHERE id IN (");
        int r2 = r9.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND state IN ('WAIT_OBSERVATION', 'COMPLETED') AND NOT EXISTS (SELECT 1 FROM InAppTraceObservation l WHERE l.trace_row_id = InAppTraceUpload.id)");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r10 = r9.iterator();
        int r4 = 1;
    L4:
        if (r10.hasNext() == false) goto L6;
        r1.bindLong(r4, ((Long) ZeusTransformUtils.preCheckCast(r10.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r4 = r4 + 1;
        goto L4
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r1, false, null);
        ArrayList r3 = new ArrayList(r7.getCount());     // Catch: Throwable -> L18
    L8:
        if (r7.moveToNext() == false) goto L16;
        if (r7.isNull(0) == false) goto L13;
        String r5 = null;
    L14:
        r3.add(r5);     // Catch: Throwable -> L18
        goto L8
    L13:
        r5 = r7.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r7.close();
        r1.release();
        return r3;
    L18:
        th = move-exception;
        r7.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public List<cc> queryTraceFilesForAging(long r49, int r51) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM InAppTraceUpload WHERE state IN ('WAIT_OBSERVATION', 'COMPLETED') AND created_at <= ? AND NOT EXISTS (SELECT 1 FROM InAppTraceObservation l WHERE l.trace_row_id = InAppTraceUpload.id) ORDER BY created_at ASC LIMIT ?", 2);
        r1.bindLong(1, r49);
        r1.bindLong(2, r51);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L43
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, FontsContractCompat.Columns.FILE_ID);     // Catch: Throwable -> L43
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "trace_session_id");     // Catch: Throwable -> L43
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "local_path");     // Catch: Throwable -> L43
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "start_timestamp");     // Catch: Throwable -> L43
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "end_timestamp");     // Catch: Throwable -> L43
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "event_count");     // Catch: Throwable -> L43
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "zip_size");     // Catch: Throwable -> L43
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "sha256");     // Catch: Throwable -> L43
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L43
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "tos_uri");     // Catch: Throwable -> L43
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "retry_count");     // Catch: Throwable -> L43
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "next_retry_at");     // Catch: Throwable -> L43
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "last_error");     // Catch: Throwable -> L43
        RoomSQLiteQuery r16 = r1;
        int r410 = CursorUtil.getColumnIndexOrThrow(r2, "created_at");     // Catch: Throwable -> L41
        int r50 = CursorUtil.getColumnIndexOrThrow(r2, "updated_at");     // Catch: Throwable -> L41
        int r52 = CursorUtil.getColumnIndexOrThrow(r2, "lease_until");     // Catch: Throwable -> L41
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "observation_id");     // Catch: Throwable -> L41
        int r18 = r3;
        ArrayList r19 = new ArrayList(r2.getCount());     // Catch: Throwable -> L41
    L6:
        if (r2.moveToNext() == false) goto L39;
        long r20 = r2.getLong(r0);     // Catch: Throwable -> L41
        if (r2.isNull(r4) == false) goto L11;
        String r22 = null;
    L13:
        if (r2.isNull(r5) == false) goto L15;
        String r23 = null;
    L17:
        if (r2.isNull(r6) == false) goto L19;
        String r24 = null;
    L20:
        long r25 = r2.getLong(r7);     // Catch: Throwable -> L41
        long r27 = r2.getLong(r8);     // Catch: Throwable -> L41
        int r29 = r2.getInt(r9);     // Catch: Throwable -> L41
        long r30 = r2.getLong(r10);     // Catch: Throwable -> L41
        if (r2.isNull(r11) == false) goto L23;
        String r32 = null;
    L25:
        if (r2.isNull(r12) == false) goto L27;
        String r33 = null;
    L29:
        if (r2.isNull(r13) == false) goto L31;
        String r34 = null;
    L32:
        int r35 = r2.getInt(r14);     // Catch: Throwable -> L41
        long r36 = r2.getLong(r15);     // Catch: Throwable -> L41
        int r21 = r18;
        if (r2.isNull(r21) == false) goto L36;
        String r38 = null;
    L35:
        int r47 = r0;
        int r26 = r410;
        long r39 = r2.getLong(r26);     // Catch: Throwable -> L41
        int r28 = r50;
        long r41 = r2.getLong(r28);     // Catch: Throwable -> L41
        r50 = r28;
        int r31 = r52;
        long r43 = r2.getLong(r31);     // Catch: Throwable -> L41
        r52 = r31;
        int r37 = r17;
        r17 = r37;
        r19.add(new cc(r20, r22, r23, r24, r25, r27, r29, r30, r32, r33, r34, r35, r36, r38, r39, r41, r43, r2.getLong(r37)));     // Catch: Throwable -> L41
        r0 = r47;
        r410 = r26;
        r18 = r21;
        goto L6
    L36:
        r38 = r2.getString(r21);     // Catch: Throwable -> L41
        goto L35
    L31:
        r34 = r2.getString(r13);     // Catch: Throwable -> L41
        goto L32
    L27:
        r33 = r2.getString(r12);     // Catch: Throwable -> L41
        goto L29
    L23:
        r32 = r2.getString(r11);     // Catch: Throwable -> L41
        goto L25
    L19:
        r24 = r2.getString(r6);     // Catch: Throwable -> L41
        goto L20
    L15:
        r23 = r2.getString(r5);     // Catch: Throwable -> L41
        goto L17
    L11:
        r22 = r2.getString(r4);     // Catch: Throwable -> L41
        goto L13
    L39:
        r2.close();
        r16.release();
        return r19;
    L41:
        th = th;
    L45:
        r2.close();
        r16.release();
        throw th;
    L43:
        th = th;
        r16 = r1;
        goto L45
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cc> queryWithLimitAndOffset(int r1, int r2) {
        return InAppTraceUploadDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cc> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityInAppTraceUploadEntity(r6));     // Catch: Throwable -> L10
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

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public int releaseUnreferenced(List<Long> r6, long r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE InAppTraceUpload SET observation_id = 0, state = 'COMPLETED', updated_at = ");
        r0.append("?");
        r0.append(", lease_until = 0 WHERE id IN (");
        StringUtil.appendPlaceholders(r0, r8.size());
        r0.append(") AND NOT EXISTS (SELECT 1 FROM InAppTraceObservation l WHERE l.trace_row_id = InAppTraceUpload.id)");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        r2.bindLong(1, r7);
        Iterator r9 = r8.iterator();
        int r10 = 2;
    L4:
        if (r9.hasNext() == false) goto L6;
        r2.bindLong(r10, ((Long) ZeusTransformUtils.preCheckCast(r9.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r10 = r10 + 1;
        goto L4
    L6:
        this.__db.beginTransaction();
        int r11 = r2.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        return r11;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public int update2(cc r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfInAppTraceUploadEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(cc r3) {
        return update2((cc) ZeusTransformUtils.preCheckCast(r3, cc.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<cc> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfInAppTraceUploadEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.InAppTraceUploadDao
    public int updateState(long r3, String r5, String r6, int r7, long r8, String r10, long r11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateState.acquire();
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r6 != null) goto L9;
        r0.bindNull(2);
    L10:
        r0.bindLong(3, r7);
        r0.bindLong(4, r8);
        if (r10 != null) goto L13;
        r0.bindNull(5);
    L14:
        r0.bindLong(6, r11);
        r0.bindLong(7, r3);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L18
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L18
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateState.release(r0);
        return r4;
    L18:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateState.release(r0);
        throw th;
    L13:
        r0.bindString(5, r10);
        goto L14
    L9:
        r0.bindString(2, r6);
        goto L10
    L5:
        r0.bindString(1, r5);
        goto L7
    }
}
