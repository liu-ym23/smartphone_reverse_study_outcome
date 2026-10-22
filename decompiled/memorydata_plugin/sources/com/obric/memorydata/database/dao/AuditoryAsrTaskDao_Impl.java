package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.memorydata.database.entity.AuditoryAsrTaskEntity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AuditoryAsrTaskDao_Impl implements AuditoryAsrTaskDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<AuditoryAsrTaskEntity> __insertionAdapterOfAuditoryAsrTaskEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByAccount;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByTaskId;
    private final SharedSQLiteStatement __preparedStmtOfFinish;
    private final SharedSQLiteStatement __preparedStmtOfFinishActiveByAccount;
    private final SharedSQLiteStatement __preparedStmtOfFinishDone;
    private final SharedSQLiteStatement __preparedStmtOfMarkPipelineTerminal;
    private final SharedSQLiteStatement __preparedStmtOfMarkRetry;
    private final SharedSQLiteStatement __preparedStmtOfTransition;
    private final SharedSQLiteStatement __preparedStmtOfUpdateRequestIds;

    public AuditoryAsrTaskDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAuditoryAsrTaskEntity = new AnonymousClass1(this, r2);
        this.__preparedStmtOfDeleteByTaskId = new AnonymousClass2(this, r2);
        this.__preparedStmtOfDeleteByAccount = new AnonymousClass3(this, r2);
        this.__preparedStmtOfTransition = new AnonymousClass4(this, r2);
        this.__preparedStmtOfMarkRetry = new AnonymousClass5(this, r2);
        this.__preparedStmtOfFinish = new AnonymousClass6(this, r2);
        this.__preparedStmtOfFinishActiveByAccount = new AnonymousClass7(this, r2);
        this.__preparedStmtOfUpdateRequestIds = new AnonymousClass8(this, r2);
        this.__preparedStmtOfMarkPipelineTerminal = new AnonymousClass9(this, r2);
        this.__preparedStmtOfFinishDone = new AnonymousClass10(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public int countActiveByAccount(String r3) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM AuditoryAsrTask WHERE account_scope = ? AND status IN ('PENDING_UPLOAD', 'PENDING_SUBMIT', 'WAITING_RESULT')", 1);
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        int r1 = 0;
        Cursor r2 = DBUtil.query(this.__db, r0, false, null);
    L12:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    L8:
        if (r2.moveToFirst() == false) goto L10;
        r1 = r2.getInt(0);     // Catch: Throwable -> L12
    L10:
        r2.close();
        r0.release();
        return r1;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public int deleteByAccount(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByAccount.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByAccount.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByAccount.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public int deleteByTaskId(String r3, String r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByTaskId.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByTaskId.release(r0);
        return r5;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByTaskId.release(r0);
        throw th;
    L9:
        r0.bindString(2, r4);
        goto L10
    L5:
        r0.bindString(1, r3);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public int finish(String r3, String r4, String r5, String r6, String r7, String r8, long r9) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfFinish.acquire();
        if (r6 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r7 != null) goto L9;
        r0.bindNull(2);
    L10:
        r0.bindLong(3, r9);
        if (r8 != null) goto L13;
        r0.bindNull(4);
    L14:
        r0.bindLong(5, r9);
        if (r3 != null) goto L17;
        r0.bindNull(6);
    L19:
        if (r4 != null) goto L21;
        r0.bindNull(7);
    L23:
        if (r5 != null) goto L25;
        r0.bindNull(8);
    L26:
        this.__db.beginTransaction();
        int r10 = r0.executeUpdateDelete();     // Catch: Throwable -> L30
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L30
        this.__db.endTransaction();
        this.__preparedStmtOfFinish.release(r0);
        return r10;
    L30:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfFinish.release(r0);
        throw th;
    L25:
        r0.bindString(8, r5);
        goto L26
    L21:
        r0.bindString(7, r4);
        goto L23
    L17:
        r0.bindString(6, r3);
        goto L19
    L13:
        r0.bindString(4, r8);
        goto L14
    L9:
        r0.bindString(2, r7);
        goto L10
    L5:
        r0.bindString(1, r6);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public int finishActiveByAccount(String r3, String r4, long r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfFinishActiveByAccount.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r5);
        r0.bindLong(3, r5);
        if (r3 != null) goto L9;
        r0.bindNull(4);
    L10:
        this.__db.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfFinishActiveByAccount.release(r0);
        return r6;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfFinishActiveByAccount.release(r0);
        throw th;
    L9:
        r0.bindString(4, r3);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public int finishDone(String r3, String r4, long r5, String r7, String r8, String r9) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfFinishDone.acquire();
        r0.bindLong(1, r5);
        if (r7 != null) goto L5;
        r0.bindNull(2);
    L7:
        if (r8 != null) goto L9;
        r0.bindNull(3);
    L11:
        if (r9 != null) goto L13;
        r0.bindNull(4);
    L14:
        r0.bindLong(5, r5);
        if (r3 != null) goto L17;
        r0.bindNull(6);
    L19:
        if (r4 != null) goto L21;
        r0.bindNull(7);
    L22:
        this.__db.beginTransaction();
        int r6 = r0.executeUpdateDelete();     // Catch: Throwable -> L26
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L26
        this.__db.endTransaction();
        this.__preparedStmtOfFinishDone.release(r0);
        return r6;
    L26:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfFinishDone.release(r0);
        throw th;
    L21:
        r0.bindString(7, r4);
        goto L22
    L17:
        r0.bindString(6, r3);
        goto L19
    L13:
        r0.bindString(4, r9);
        goto L14
    L9:
        r0.bindString(3, r8);
        goto L11
    L5:
        r0.bindString(2, r7);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public long insert(AuditoryAsrTaskEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAuditoryAsrTaskEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public int markPipelineTerminal(String r3, String r4, String r5, String r6, long r7) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfMarkPipelineTerminal.acquire();
        if (r6 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r7);
        r0.bindLong(3, r7);
        if (r3 != null) goto L9;
        r0.bindNull(4);
    L11:
        if (r4 != null) goto L13;
        r0.bindNull(5);
    L15:
        if (r5 != null) goto L17;
        r0.bindNull(6);
    L18:
        this.__db.beginTransaction();
        int r8 = r0.executeUpdateDelete();     // Catch: Throwable -> L22
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L22
        this.__db.endTransaction();
        this.__preparedStmtOfMarkPipelineTerminal.release(r0);
        return r8;
    L22:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfMarkPipelineTerminal.release(r0);
        throw th;
    L17:
        r0.bindString(6, r5);
        goto L18
    L13:
        r0.bindString(5, r4);
        goto L15
    L9:
        r0.bindString(4, r3);
        goto L11
    L5:
        r0.bindString(1, r6);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public int markRetry(String r4, String r5, String r6, int r7, String r8, long r9) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfMarkRetry.acquire();
        r0.bindLong(1, r7);
        if (r8 != null) goto L5;
        r0.bindNull(2);
    L6:
        r0.bindLong(3, r9);
        if (r4 != null) goto L9;
        r0.bindNull(4);
    L11:
        if (r5 != null) goto L13;
        r0.bindNull(5);
    L15:
        if (r6 != null) goto L17;
        r0.bindNull(6);
    L18:
        this.__db.beginTransaction();
        int r10 = r0.executeUpdateDelete();     // Catch: Throwable -> L22
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L22
        this.__db.endTransaction();
        this.__preparedStmtOfMarkRetry.release(r0);
        return r10;
    L22:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfMarkRetry.release(r0);
        throw th;
    L17:
        r0.bindString(6, r6);
        goto L18
    L13:
        r0.bindString(5, r5);
        goto L15
    L9:
        r0.bindString(4, r4);
        goto L11
    L5:
        r0.bindString(2, r8);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public List<String> queryAllTaskIds() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT task_id FROM AuditoryAsrTask", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r5.getCount());     // Catch: Throwable -> L14
    L4:
        if (r5.moveToNext() == false) goto L12;
        if (r5.isNull(0) == false) goto L9;
        String r4 = null;
    L10:
        r3.add(r4);     // Catch: Throwable -> L14
        goto L4
    L9:
        r4 = r5.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r5.close();
        r0.release();
        return r3;
    L14:
        th = move-exception;
        r5.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public AuditoryAsrTaskEntity queryByTaskId(String r54) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM AuditoryAsrTask WHERE task_id = ? LIMIT 1", 1);
        if (r54 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "task_id");     // Catch: Throwable -> L86
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "account_scope");     // Catch: Throwable -> L86
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "status");     // Catch: Throwable -> L86
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "audio_start_ms");     // Catch: Throwable -> L86
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "audio_end_ms");     // Catch: Throwable -> L86
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "audio_start_time");     // Catch: Throwable -> L86
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "audio_end_time");     // Catch: Throwable -> L86
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "audio_timezone");     // Catch: Throwable -> L86
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "audio_path");     // Catch: Throwable -> L86
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "manifest");     // Catch: Throwable -> L86
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "audio_sha256");     // Catch: Throwable -> L86
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "tos_key");     // Catch: Throwable -> L86
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "retry_count");     // Catch: Throwable -> L86
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "last_error");     // Catch: Throwable -> L86
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "terminal_at");     // Catch: Throwable -> L84
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "observation_id");     // Catch: Throwable -> L84
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "raw_observation_ids");     // Catch: Throwable -> L84
        int r20 = CursorUtil.getColumnIndexOrThrow(r1, "submit_log_id");     // Catch: Throwable -> L84
        int r21 = CursorUtil.getColumnIndexOrThrow(r1, "result_log_id");     // Catch: Throwable -> L84
        int r22 = CursorUtil.getColumnIndexOrThrow(r1, "request_log_ids");     // Catch: Throwable -> L84
        int r23 = CursorUtil.getColumnIndexOrThrow(r1, "evidence_state");     // Catch: Throwable -> L84
        int r24 = CursorUtil.getColumnIndexOrThrow(r1, "created_at");     // Catch: Throwable -> L84
        int r25 = CursorUtil.getColumnIndexOrThrow(r1, "updated_at");     // Catch: Throwable -> L84
        if (r1.moveToFirst() == true) goto L12;
        AuditoryAsrTaskEntity r26 = null;
    L82:
        r1.close();
        r16.release();
        return r26;
    L12:
        if (r1.isNull(r0) == false) goto L14;
        String r27 = null;
    L16:
        if (r1.isNull(r4) == false) goto L18;
        String r28 = null;
    L20:
        if (r1.isNull(r5) == false) goto L22;
        String r29 = null;
    L23:
        long r210 = r1.getLong(r6);     // Catch: Throwable -> L84
        long r30 = r1.getLong(r7);     // Catch: Throwable -> L84
        if (r1.isNull(r8) == false) goto L26;
        String r32 = null;
    L28:
        if (r1.isNull(r9) == false) goto L30;
        String r33 = null;
    L32:
        if (r1.isNull(r10) == false) goto L34;
        String r34 = null;
    L36:
        if (r1.isNull(r11) == false) goto L38;
        String r35 = null;
    L40:
        if (r1.isNull(r12) == false) goto L42;
        String r36 = null;
    L44:
        if (r1.isNull(r13) == false) goto L46;
        String r37 = null;
    L48:
        if (r1.isNull(r14) == false) goto L50;
        String r38 = null;
    L51:
        int r39 = r1.getInt(r15);     // Catch: Throwable -> L84
        if (r1.isNull(r3) == false) goto L54;
        String r40 = null;
    L55:
        long r41 = r1.getLong(r17);     // Catch: Throwable -> L84
        if (r1.isNull(r18) == false) goto L58;
        String r43 = null;
    L60:
        if (r1.isNull(r18) == false) goto L62;
        String r44 = null;
    L64:
        if (r1.isNull(r19) == false) goto L66;
        String r45 = null;
    L68:
        if (r1.isNull(r20) == false) goto L70;
        String r46 = null;
    L72:
        if (r1.isNull(r21) == false) goto L74;
        String r47 = null;
    L76:
        if (r1.isNull(r22) == false) goto L78;
        String r48 = null;
    L79:
        r26 = new AuditoryAsrTaskEntity(r27, r28, r29, r210, r30, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r43, r44, r45, r46, r47, r48, r1.getLong(r24), r1.getLong(r25));     // Catch: Throwable -> L84
        goto L82
    L78:
        r48 = r1.getString(r23);     // Catch: Throwable -> L84
        goto L79
    L74:
        r47 = r1.getString(r22);     // Catch: Throwable -> L84
        goto L76
    L70:
        r46 = r1.getString(r21);     // Catch: Throwable -> L84
        goto L72
    L66:
        r45 = r1.getString(r20);     // Catch: Throwable -> L84
        goto L68
    L62:
        r44 = r1.getString(r19);     // Catch: Throwable -> L84
        goto L64
    L58:
        r43 = r1.getString(r18);     // Catch: Throwable -> L84
        goto L60
    L54:
        r40 = r1.getString(r3);     // Catch: Throwable -> L84
        goto L55
    L50:
        r38 = r1.getString(r14);     // Catch: Throwable -> L84
        goto L51
    L46:
        r37 = r1.getString(r13);     // Catch: Throwable -> L84
        goto L48
    L42:
        r36 = r1.getString(r12);     // Catch: Throwable -> L84
        goto L44
    L38:
        r35 = r1.getString(r11);     // Catch: Throwable -> L84
        goto L40
    L34:
        r34 = r1.getString(r10);     // Catch: Throwable -> L84
        goto L36
    L30:
        r33 = r1.getString(r9);     // Catch: Throwable -> L84
        goto L32
    L26:
        r32 = r1.getString(r8);     // Catch: Throwable -> L84
        goto L28
    L22:
        r29 = r1.getString(r5);     // Catch: Throwable -> L84
        goto L23
    L18:
        r28 = r1.getString(r4);     // Catch: Throwable -> L84
        goto L20
    L14:
        r27 = r1.getString(r0);     // Catch: Throwable -> L84
    L84:
        th = th;
    L88:
        r1.close();
        r16.release();
        throw th;
    L86:
        th = th;
        r16 = r2;
        goto L88
    L5:
        r2.bindString(1, r54);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public List<AuditoryAsrTaskEntity> queryExpiredTerminal(long r55, int r57) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM AuditoryAsrTask WHERE status IN ('DONE', 'FAILED') AND terminal_at > 0 AND terminal_at <= ? ORDER BY terminal_at ASC LIMIT ?", 2);
        r1.bindLong(1, r55);
        r1.bindLong(2, r57);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "task_id");     // Catch: Throwable -> L84
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "account_scope");     // Catch: Throwable -> L84
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "status");     // Catch: Throwable -> L84
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "audio_start_ms");     // Catch: Throwable -> L84
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "audio_end_ms");     // Catch: Throwable -> L84
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "audio_start_time");     // Catch: Throwable -> L84
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "audio_end_time");     // Catch: Throwable -> L84
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "audio_timezone");     // Catch: Throwable -> L84
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "audio_path");     // Catch: Throwable -> L84
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "manifest");     // Catch: Throwable -> L84
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "audio_sha256");     // Catch: Throwable -> L84
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "tos_key");     // Catch: Throwable -> L84
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "retry_count");     // Catch: Throwable -> L84
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "last_error");     // Catch: Throwable -> L84
        RoomSQLiteQuery r16 = r1;
        int r56 = CursorUtil.getColumnIndexOrThrow(r2, "terminal_at");     // Catch: Throwable -> L82
        int r58 = CursorUtil.getColumnIndexOrThrow(r2, "observation_id");     // Catch: Throwable -> L82
        int r59 = CursorUtil.getColumnIndexOrThrow(r2, "raw_observation_ids");     // Catch: Throwable -> L82
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "submit_log_id");     // Catch: Throwable -> L82
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "result_log_id");     // Catch: Throwable -> L82
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "request_log_ids");     // Catch: Throwable -> L82
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "evidence_state");     // Catch: Throwable -> L82
        int r21 = CursorUtil.getColumnIndexOrThrow(r2, "created_at");     // Catch: Throwable -> L82
        int r22 = CursorUtil.getColumnIndexOrThrow(r2, "updated_at");     // Catch: Throwable -> L82
        int r23 = r3;
        ArrayList r24 = new ArrayList(r2.getCount());     // Catch: Throwable -> L82
    L6:
        if (r2.moveToNext() == false) goto L80;
        if (r2.isNull(r0) == false) goto L11;
        String r25 = null;
    L13:
        if (r2.isNull(r4) == false) goto L15;
        String r26 = null;
    L17:
        if (r2.isNull(r5) == false) goto L19;
        String r27 = null;
    L20:
        long r28 = r2.getLong(r6);     // Catch: Throwable -> L82
        long r30 = r2.getLong(r7);     // Catch: Throwable -> L82
        if (r2.isNull(r8) == false) goto L23;
        String r32 = null;
    L25:
        if (r2.isNull(r9) == false) goto L27;
        String r33 = null;
    L29:
        if (r2.isNull(r10) == false) goto L31;
        String r34 = null;
    L33:
        if (r2.isNull(r11) == false) goto L35;
        String r35 = null;
    L37:
        if (r2.isNull(r12) == false) goto L39;
        String r36 = null;
    L41:
        if (r2.isNull(r13) == false) goto L43;
        String r37 = null;
    L45:
        if (r2.isNull(r14) == false) goto L47;
        String r38 = null;
    L48:
        int r39 = r2.getInt(r15);     // Catch: Throwable -> L82
        int r29 = r23;
        if (r2.isNull(r29) == false) goto L52;
        String r40 = null;
    L51:
        int r53 = r0;
        int r31 = r56;
        long r41 = r2.getLong(r31);     // Catch: Throwable -> L82
        r58 = r58;
        if (r2.isNull(r58) == false) goto L57;
        String r43 = null;
    L56:
        r59 = r59;
        if (r2.isNull(r59) == false) goto L61;
        String r44 = null;
    L63:
        if (r2.isNull(r17) == false) goto L65;
        String r45 = null;
    L67:
        if (r2.isNull(r18) == false) goto L69;
        String r46 = null;
    L71:
        if (r2.isNull(r19) == false) goto L73;
        String r47 = null;
    L75:
        if (r2.isNull(r20) == false) goto L77;
        String r48 = null;
    L78:
        long r49 = r2.getLong(r21);     // Catch: Throwable -> L82
        r21 = r21;
        int r42 = r22;
        r22 = r42;
        r24.add(new AuditoryAsrTaskEntity(r25, r26, r27, r28, r30, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r43, r44, r45, r46, r47, r48, r49, r2.getLong(r42)));     // Catch: Throwable -> L82
        r0 = r53;
        r56 = r31;
        r23 = r29;
        goto L6
    L77:
        r48 = r2.getString(r20);     // Catch: Throwable -> L82
        goto L78
    L73:
        r47 = r2.getString(r19);     // Catch: Throwable -> L82
        goto L75
    L69:
        r46 = r2.getString(r18);     // Catch: Throwable -> L82
        goto L71
    L65:
        r45 = r2.getString(r17);     // Catch: Throwable -> L82
        goto L67
    L61:
        r44 = r2.getString(r59);     // Catch: Throwable -> L82
        goto L63
    L57:
        r43 = r2.getString(r58);     // Catch: Throwable -> L82
        goto L56
    L52:
        r40 = r2.getString(r29);     // Catch: Throwable -> L82
        goto L51
    L47:
        r38 = r2.getString(r14);     // Catch: Throwable -> L82
        goto L48
    L43:
        r37 = r2.getString(r13);     // Catch: Throwable -> L82
        goto L45
    L39:
        r36 = r2.getString(r12);     // Catch: Throwable -> L82
        goto L41
    L35:
        r35 = r2.getString(r11);     // Catch: Throwable -> L82
        goto L37
    L31:
        r34 = r2.getString(r10);     // Catch: Throwable -> L82
        goto L33
    L27:
        r33 = r2.getString(r9);     // Catch: Throwable -> L82
        goto L29
    L23:
        r32 = r2.getString(r8);     // Catch: Throwable -> L82
        goto L25
    L19:
        r27 = r2.getString(r5);     // Catch: Throwable -> L82
        goto L20
    L15:
        r26 = r2.getString(r4);     // Catch: Throwable -> L82
        goto L17
    L11:
        r25 = r2.getString(r0);     // Catch: Throwable -> L82
        goto L13
    L80:
        r2.close();
        r16.release();
        return r24;
    L82:
        th = th;
    L86:
        r2.close();
        r16.release();
        throw th;
    L84:
        th = th;
        r16 = r1;
        goto L86
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public List<String> queryTaskIdsByAccount(String r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT task_id FROM AuditoryAsrTask WHERE account_scope = ?", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r4.getCount());     // Catch: Throwable -> L18
    L8:
        if (r4.moveToNext() == false) goto L16;
        if (r4.isNull(0) == false) goto L13;
        String r3 = null;
    L14:
        r2.add(r3);     // Catch: Throwable -> L18
        goto L8
    L13:
        r3 = r4.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r4.close();
        r0.release();
        return r2;
    L18:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public List<AuditoryAsrTaskEntity> queryUnreportedTerminal(String r56, int r57) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM AuditoryAsrTask WHERE account_scope = ? AND status IN ('DONE', 'FAILED') AND request_log_ids NOT LIKE '%\"stage\":\"PIPELINE_TERMINAL\"%' ORDER BY terminal_at ASC LIMIT ?", 2);
        if (r56 != null) goto L5;
        r2.bindNull(1);
    L6:
        r2.bindLong(2, r57);
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "task_id");     // Catch: Throwable -> L87
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "account_scope");     // Catch: Throwable -> L87
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "status");     // Catch: Throwable -> L87
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "audio_start_ms");     // Catch: Throwable -> L87
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "audio_end_ms");     // Catch: Throwable -> L87
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "audio_start_time");     // Catch: Throwable -> L87
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "audio_end_time");     // Catch: Throwable -> L87
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "audio_timezone");     // Catch: Throwable -> L87
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "audio_path");     // Catch: Throwable -> L87
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "manifest");     // Catch: Throwable -> L87
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "audio_sha256");     // Catch: Throwable -> L87
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "tos_key");     // Catch: Throwable -> L87
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "retry_count");     // Catch: Throwable -> L87
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "last_error");     // Catch: Throwable -> L87
        RoomSQLiteQuery r16 = r2;
        int r58 = CursorUtil.getColumnIndexOrThrow(r1, "terminal_at");     // Catch: Throwable -> L85
        int r59 = CursorUtil.getColumnIndexOrThrow(r1, "observation_id");     // Catch: Throwable -> L85
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "raw_observation_ids");     // Catch: Throwable -> L85
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "submit_log_id");     // Catch: Throwable -> L85
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "result_log_id");     // Catch: Throwable -> L85
        int r20 = CursorUtil.getColumnIndexOrThrow(r1, "request_log_ids");     // Catch: Throwable -> L85
        int r21 = CursorUtil.getColumnIndexOrThrow(r1, "evidence_state");     // Catch: Throwable -> L85
        int r22 = CursorUtil.getColumnIndexOrThrow(r1, "created_at");     // Catch: Throwable -> L85
        int r23 = CursorUtil.getColumnIndexOrThrow(r1, "updated_at");     // Catch: Throwable -> L85
        int r24 = r3;
        ArrayList r25 = new ArrayList(r1.getCount());     // Catch: Throwable -> L85
    L10:
        if (r1.moveToNext() == false) goto L83;
        if (r1.isNull(r0) == false) goto L15;
        String r26 = null;
    L17:
        if (r1.isNull(r4) == false) goto L19;
        String r27 = null;
    L21:
        if (r1.isNull(r5) == false) goto L23;
        String r28 = null;
    L24:
        long r29 = r1.getLong(r6);     // Catch: Throwable -> L85
        long r31 = r1.getLong(r7);     // Catch: Throwable -> L85
        if (r1.isNull(r8) == false) goto L27;
        String r33 = null;
    L29:
        if (r1.isNull(r9) == false) goto L31;
        String r34 = null;
    L33:
        if (r1.isNull(r10) == false) goto L35;
        String r35 = null;
    L37:
        if (r1.isNull(r11) == false) goto L39;
        String r36 = null;
    L41:
        if (r1.isNull(r12) == false) goto L43;
        String r37 = null;
    L45:
        if (r1.isNull(r13) == false) goto L47;
        String r38 = null;
    L49:
        if (r1.isNull(r14) == false) goto L51;
        String r39 = null;
    L52:
        int r40 = r1.getInt(r15);     // Catch: Throwable -> L85
        int r30 = r24;
        if (r1.isNull(r30) == false) goto L56;
        String r41 = null;
    L55:
        int r54 = r0;
        int r32 = r58;
        long r42 = r1.getLong(r32);     // Catch: Throwable -> L85
        r59 = r59;
        if (r1.isNull(r59) == false) goto L60;
        String r44 = null;
    L62:
        if (r1.isNull(r17) == false) goto L64;
        String r45 = null;
    L66:
        if (r1.isNull(r18) == false) goto L68;
        String r46 = null;
    L70:
        if (r1.isNull(r19) == false) goto L72;
        String r47 = null;
    L74:
        if (r1.isNull(r20) == false) goto L76;
        String r48 = null;
    L78:
        if (r1.isNull(r21) == false) goto L80;
        String r49 = null;
    L81:
        long r50 = r1.getLong(r22);     // Catch: Throwable -> L85
        r22 = r22;
        int r43 = r23;
        r23 = r43;
        r25.add(new AuditoryAsrTaskEntity(r26, r27, r28, r29, r31, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r44, r45, r46, r47, r48, r49, r50, r1.getLong(r43)));     // Catch: Throwable -> L85
        r0 = r54;
        r58 = r32;
        r24 = r30;
        goto L10
    L80:
        r49 = r1.getString(r21);     // Catch: Throwable -> L85
        goto L81
    L76:
        r48 = r1.getString(r20);     // Catch: Throwable -> L85
        goto L78
    L72:
        r47 = r1.getString(r19);     // Catch: Throwable -> L85
        goto L74
    L68:
        r46 = r1.getString(r18);     // Catch: Throwable -> L85
        goto L70
    L64:
        r45 = r1.getString(r17);     // Catch: Throwable -> L85
        goto L66
    L60:
        r44 = r1.getString(r59);     // Catch: Throwable -> L85
        goto L62
    L56:
        r41 = r1.getString(r30);     // Catch: Throwable -> L85
        goto L55
    L51:
        r39 = r1.getString(r14);     // Catch: Throwable -> L85
        goto L52
    L47:
        r38 = r1.getString(r13);     // Catch: Throwable -> L85
        goto L49
    L43:
        r37 = r1.getString(r12);     // Catch: Throwable -> L85
        goto L45
    L39:
        r36 = r1.getString(r11);     // Catch: Throwable -> L85
        goto L41
    L35:
        r35 = r1.getString(r10);     // Catch: Throwable -> L85
        goto L37
    L31:
        r34 = r1.getString(r9);     // Catch: Throwable -> L85
        goto L33
    L27:
        r33 = r1.getString(r8);     // Catch: Throwable -> L85
        goto L29
    L23:
        r28 = r1.getString(r5);     // Catch: Throwable -> L85
        goto L24
    L19:
        r27 = r1.getString(r4);     // Catch: Throwable -> L85
        goto L21
    L15:
        r26 = r1.getString(r0);     // Catch: Throwable -> L85
        goto L17
    L83:
        r1.close();
        r16.release();
        return r25;
    L85:
        th = th;
    L89:
        r1.close();
        r16.release();
        throw th;
    L87:
        th = th;
        r16 = r2;
        goto L89
    L5:
        r2.bindString(1, r56);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public int transition(String r3, String r4, String r5, String r6, String r7, long r8) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfTransition.acquire();
        if (r6 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r7 != null) goto L9;
        r0.bindNull(2);
    L10:
        r0.bindLong(3, r8);
        if (r3 != null) goto L13;
        r0.bindNull(4);
    L15:
        if (r4 != null) goto L17;
        r0.bindNull(5);
    L19:
        if (r5 != null) goto L21;
        r0.bindNull(6);
    L22:
        this.__db.beginTransaction();
        int r9 = r0.executeUpdateDelete();     // Catch: Throwable -> L26
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L26
        this.__db.endTransaction();
        this.__preparedStmtOfTransition.release(r0);
        return r9;
    L26:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfTransition.release(r0);
        throw th;
    L21:
        r0.bindString(6, r5);
        goto L22
    L17:
        r0.bindString(5, r4);
        goto L19
    L13:
        r0.bindString(4, r3);
        goto L15
    L9:
        r0.bindString(2, r7);
        goto L10
    L5:
        r0.bindString(1, r6);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.AuditoryAsrTaskDao
    public int updateRequestIds(String r3, String r4, String r5, String r6, String r7, long r8) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateRequestIds.acquire();
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r5 != null) goto L9;
        r0.bindNull(2);
    L11:
        if (r6 != null) goto L13;
        r0.bindNull(3);
    L15:
        if (r6 != null) goto L17;
        r0.bindNull(4);
    L19:
        if (r7 != null) goto L21;
        r0.bindNull(5);
    L22:
        r0.bindLong(6, r8);
        if (r3 != null) goto L25;
        r0.bindNull(7);
    L27:
        if (r4 != null) goto L29;
        r0.bindNull(8);
    L30:
        this.__db.beginTransaction();
        int r9 = r0.executeUpdateDelete();     // Catch: Throwable -> L34
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L34
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateRequestIds.release(r0);
        return r9;
    L34:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateRequestIds.release(r0);
        throw th;
    L29:
        r0.bindString(8, r4);
        goto L30
    L25:
        r0.bindString(7, r3);
        goto L27
    L21:
        r0.bindString(5, r7);
        goto L22
    L17:
        r0.bindString(4, r6);
        goto L19
    L13:
        r0.bindString(3, r6);
        goto L15
    L9:
        r0.bindString(2, r5);
        goto L11
    L5:
        r0.bindString(1, r5);
        goto L7
    }
}
