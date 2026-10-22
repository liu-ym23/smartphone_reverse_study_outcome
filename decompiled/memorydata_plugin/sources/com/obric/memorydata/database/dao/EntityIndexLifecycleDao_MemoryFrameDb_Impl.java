package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.memorydata.database.entity.bh;
import com.obric.memorydata.database.index.aa;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EntityIndexLifecycleDao_MemoryFrameDb_Impl implements EntityIndexLifecycleDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<bh> __insertionAdapterOfEntityIndexLifecycleEntity;
    private final SharedSQLiteStatement __preparedStmtOfCloseSuccess;
    private final SharedSQLiteStatement __preparedStmtOfCloseTerminalFailure;
    private final SharedSQLiteStatement __preparedStmtOfCloseWithoutCompletion;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfInvalidateCoverage;
    private final SharedSQLiteStatement __preparedStmtOfInvalidateObservation;
    private final SharedSQLiteStatement __preparedStmtOfMarkFirstCompletionStartedForNewerSource;
    private final SharedSQLiteStatement __preparedStmtOfMarkFirstCompletionStartedIfAbsent;
    private final SharedSQLiteStatement __preparedStmtOfOpenRound;
    private final SharedSQLiteStatement __preparedStmtOfRecordCoverageSettlement;
    private final SharedSQLiteStatement __preparedStmtOfResetCoverageRound;
    private final SharedSQLiteStatement __preparedStmtOfUpdateCoverageRequiredCount;

    public EntityIndexLifecycleDao_MemoryFrameDb_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfEntityIndexLifecycleEntity = new AnonymousClass1(this, r2);
        this.__preparedStmtOfOpenRound = new AnonymousClass2(this, r2);
        this.__preparedStmtOfResetCoverageRound = new AnonymousClass3(this, r2);
        this.__preparedStmtOfUpdateCoverageRequiredCount = new AnonymousClass4(this, r2);
        this.__preparedStmtOfMarkFirstCompletionStartedIfAbsent = new AnonymousClass5(this, r2);
        this.__preparedStmtOfMarkFirstCompletionStartedForNewerSource = new AnonymousClass6(this, r2);
        this.__preparedStmtOfRecordCoverageSettlement = new AnonymousClass7(this, r2);
        this.__preparedStmtOfCloseSuccess = new AnonymousClass8(this, r2);
        this.__preparedStmtOfCloseWithoutCompletion = new AnonymousClass9(this, r2);
        this.__preparedStmtOfInvalidateCoverage = new AnonymousClass10(this, r2);
        this.__preparedStmtOfCloseTerminalFailure = new AnonymousClass11(this, r2);
        this.__preparedStmtOfInvalidateObservation = new AnonymousClass12(this, r2);
        this.__preparedStmtOfDelete = new AnonymousClass13(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public int closeSuccess(long r3, int r5, long r6, long r8) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfCloseSuccess.acquire();
        r0.bindLong(1, r8);
        r0.bindLong(2, r3);
        r0.bindLong(3, r5);
        r0.bindLong(4, r6);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfCloseSuccess.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfCloseSuccess.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public int closeTerminalFailure(long r3, int r5, long r6, long r8) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfCloseTerminalFailure.acquire();
        r0.bindLong(1, r8);
        r0.bindLong(2, r3);
        r0.bindLong(3, r5);
        r0.bindLong(4, r6);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfCloseTerminalFailure.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfCloseTerminalFailure.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public int closeWithoutCompletion(long r3, int r5, long r6, long r8) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfCloseWithoutCompletion.acquire();
        r0.bindLong(1, r8);
        r0.bindLong(2, r3);
        r0.bindLong(3, r5);
        r0.bindLong(4, r6);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfCloseWithoutCompletion.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfCloseWithoutCompletion.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public int delete(long r3, int r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDelete.acquire();
        r0.bindLong(1, r3);
        r0.bindLong(2, r5);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDelete.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDelete.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public long insertIfAbsent(bh r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfEntityIndexLifecycleEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public int invalidateCoverage(long r3, int r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfInvalidateCoverage.acquire();
        r0.bindLong(1, r3);
        r0.bindLong(2, r5);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfInvalidateCoverage.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfInvalidateCoverage.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public int invalidateObservation(long r3, int r5, long r6) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfInvalidateObservation.acquire();
        r0.bindLong(1, r6);
        r0.bindLong(2, r3);
        r0.bindLong(3, r5);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfInvalidateObservation.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfInvalidateObservation.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public int markFirstCompletionStartedForNewerSource(long r3, int r5, long r6, long r8) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfMarkFirstCompletionStartedForNewerSource.acquire();
        r0.bindLong(1, r8);
        r0.bindLong(2, r8);
        r0.bindLong(3, r8);
        r0.bindLong(4, r3);
        r0.bindLong(5, r5);
        r0.bindLong(6, r6);
        r0.bindLong(7, r8);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfMarkFirstCompletionStartedForNewerSource.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfMarkFirstCompletionStartedForNewerSource.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public int markFirstCompletionStartedIfAbsent(long r3, int r5, long r6, long r8) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfMarkFirstCompletionStartedIfAbsent.acquire();
        r0.bindLong(1, r8);
        r0.bindLong(2, r8);
        r0.bindLong(3, r8);
        r0.bindLong(4, r8);
        r0.bindLong(5, r8);
        r0.bindLong(6, r8);
        r0.bindLong(7, r3);
        r0.bindLong(8, r5);
        r0.bindLong(9, r6);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfMarkFirstCompletionStartedIfAbsent.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfMarkFirstCompletionStartedIfAbsent.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public int openRound(long r8, int r10, long r11, long r13, long r15, long r17, long r19, int r21, int r22, int r23, long r24, int r26, int r27) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r4 = this.__preparedStmtOfOpenRound.acquire();
        long r5 = r21;
        r4.bindLong(1, r5);
        r4.bindLong(2, r15);
        r4.bindLong(3, r15);
        r4.bindLong(4, r5);
        r4.bindLong(5, r15);
        r4.bindLong(6, r22);
        r4.bindLong(7, r5);
        r4.bindLong(8, r17);
        r4.bindLong(9, r13);
        r4.bindLong(10, r19);
        r4.bindLong(11, r23);
        r4.bindLong(12, r24);
        r4.bindLong(13, r26);
        r4.bindLong(14, r27);
        r4.bindLong(15, r8);
        r4.bindLong(16, r10);
        r4.bindLong(17, r11);
        this.__db.beginTransaction();
        int r0 = r4.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfOpenRound.release(r4);
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfOpenRound.release(r4);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public bh query(long r38, int r40) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM EntityIndexLifecycle WHERE rawDbId = ? AND entityType = ?", 2);
        r1.bindLong(1, r38);
        r1.bindLong(2, r40);
        this.__db.assertNotSuspendingTransaction();
        bh r4 = null;
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, "rawDbId");     // Catch: Throwable -> L12
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "entityType");     // Catch: Throwable -> L12
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "firstCompletionStartedAt");     // Catch: Throwable -> L12
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "backlogRoundStartedAt");     // Catch: Throwable -> L12
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "firstCompletionFinished");     // Catch: Throwable -> L12
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "backlogRoundId");     // Catch: Throwable -> L12
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "updatedAt");     // Catch: Throwable -> L12
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "coveragePolicyVersion");     // Catch: Throwable -> L12
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "coverageSourceTimestamp");     // Catch: Throwable -> L12
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "coverageRequiredCount");     // Catch: Throwable -> L12
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "coverageSuccessCount");     // Catch: Throwable -> L12
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, "coverageTerminalFailureCount");     // Catch: Throwable -> L12
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "coverageState");     // Catch: Throwable -> L12
        if (r5.moveToFirst() == false) goto L10;
        long r18 = r5.getLong(r0);     // Catch: Throwable -> L12
        int r20 = r5.getInt(r6);     // Catch: Throwable -> L12
        long r21 = r5.getLong(r7);     // Catch: Throwable -> L12
        long r23 = r5.getLong(r8);     // Catch: Throwable -> L12
        if (r5.getInt(r9) == 0) goto L8;
        boolean r25 = true;
    L9:
        r4 = new bh(r18, r20, r21, r23, r25, r5.getLong(r10), r5.getLong(r11), r5.getInt(r12), r5.getLong(r13), r5.getInt(r14), r5.getInt(r15), r5.getInt(r2), r5.getInt(r3));     // Catch: Throwable -> L12
        goto L10
    L8:
        r25 = false;
    L10:
        r5.close();
        r1.release();
        return r4;
    L12:
        th = move-exception;
        r5.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public List<bh> queryAll() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM EntityIndexLifecycle", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r3, "rawDbId");     // Catch: Throwable -> L18
        int r4 = CursorUtil.getColumnIndexOrThrow(r3, "entityType");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r3, "firstCompletionStartedAt");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r3, "backlogRoundStartedAt");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r3, "firstCompletionFinished");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r3, "backlogRoundId");     // Catch: Throwable -> L18
        int r9 = CursorUtil.getColumnIndexOrThrow(r3, "updatedAt");     // Catch: Throwable -> L18
        int r10 = CursorUtil.getColumnIndexOrThrow(r3, "coveragePolicyVersion");     // Catch: Throwable -> L18
        int r11 = CursorUtil.getColumnIndexOrThrow(r3, "coverageSourceTimestamp");     // Catch: Throwable -> L18
        int r12 = CursorUtil.getColumnIndexOrThrow(r3, "coverageRequiredCount");     // Catch: Throwable -> L18
        int r13 = CursorUtil.getColumnIndexOrThrow(r3, "coverageSuccessCount");     // Catch: Throwable -> L18
        int r14 = CursorUtil.getColumnIndexOrThrow(r3, "coverageTerminalFailureCount");     // Catch: Throwable -> L18
        int r15 = CursorUtil.getColumnIndexOrThrow(r3, "coverageState");     // Catch: Throwable -> L18
        RoomSQLiteQuery r16 = r1;
        ArrayList r2 = new ArrayList(r3.getCount());     // Catch: Throwable -> L16
    L7:
        if (r3.moveToNext() == false) goto L14;
        long r18 = r3.getLong(r0);     // Catch: Throwable -> L16
        int r20 = r3.getInt(r4);     // Catch: Throwable -> L16
        long r21 = r3.getLong(r5);     // Catch: Throwable -> L16
        long r23 = r3.getLong(r6);     // Catch: Throwable -> L16
        if (r3.getInt(r7) == 0) goto L11;
        boolean r25 = true;
    L12:
        r2.add(new bh(r18, r20, r21, r23, r25, r3.getLong(r8), r3.getLong(r9), r3.getInt(r10), r3.getLong(r11), r3.getInt(r12), r3.getInt(r13), r3.getInt(r14), r3.getInt(r15)));     // Catch: Throwable -> L16
        goto L7
    L11:
        r25 = false;
        goto L12
    L14:
        r3.close();
        r16.release();
        return r2;
    L16:
        th = th;
    L20:
        r3.close();
        r16.release();
        throw th;
    L18:
        th = th;
        r16 = r1;
        goto L20
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public List<aa> queryBacklogRows() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT pending.rawDbId AS rawDbId, pending.entityType AS entityType, pending.buildType AS buildType, COALESCE(lifecycle.backlogRoundStartedAt, 0) AS backlogRoundStartedAt FROM AppEntityIndexPending pending LEFT JOIN EntityIndexLifecycle lifecycle ON lifecycle.rawDbId = pending.rawDbId AND lifecycle.entityType = pending.entityType", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r12.getCount());     // Catch: Throwable -> L14
    L4:
        if (r12.moveToNext() == false) goto L12;
        long r6 = r12.getLong(0);     // Catch: Throwable -> L14
        int r8 = r12.getInt(1);     // Catch: Throwable -> L14
        if (r12.isNull(2) == false) goto L9;
        String r9 = null;
    L10:
        r3.add(new aa(r6, r8, r9, r12.getLong(3)));     // Catch: Throwable -> L14
        goto L4
    L9:
        r9 = r12.getString(2);     // Catch: Throwable -> L14
        goto L10
    L12:
        r12.close();
        r0.release();
        return r3;
    L14:
        th = move-exception;
        r12.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public List<bh> queryByRawDbIds(List<Long> r38, int r39) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r38, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM EntityIndexLifecycle WHERE entityType = ");
        r3.append("?");
        r3.append(" AND rawDbId IN (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(")");
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire(r3.toString(), r4 + 1);
        r5.bindLong(1, r39);
        Iterator r2 = r1.iterator();
        int r6 = 2;
    L4:
        if (r2.hasNext() == false) goto L6;
        r5.bindLong(r6, ((Long) ZeusTransformUtils.preCheckCast(r2.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r6 = r6 + 1;
        goto L4
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r5, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r7, "rawDbId");     // Catch: Throwable -> L22
        int r8 = CursorUtil.getColumnIndexOrThrow(r7, "entityType");     // Catch: Throwable -> L22
        int r9 = CursorUtil.getColumnIndexOrThrow(r7, "firstCompletionStartedAt");     // Catch: Throwable -> L22
        int r10 = CursorUtil.getColumnIndexOrThrow(r7, "backlogRoundStartedAt");     // Catch: Throwable -> L22
        int r11 = CursorUtil.getColumnIndexOrThrow(r7, "firstCompletionFinished");     // Catch: Throwable -> L22
        int r12 = CursorUtil.getColumnIndexOrThrow(r7, "backlogRoundId");     // Catch: Throwable -> L22
        int r13 = CursorUtil.getColumnIndexOrThrow(r7, "updatedAt");     // Catch: Throwable -> L22
        int r14 = CursorUtil.getColumnIndexOrThrow(r7, "coveragePolicyVersion");     // Catch: Throwable -> L22
        int r15 = CursorUtil.getColumnIndexOrThrow(r7, "coverageSourceTimestamp");     // Catch: Throwable -> L22
        int r16 = CursorUtil.getColumnIndexOrThrow(r7, "coverageRequiredCount");     // Catch: Throwable -> L22
        int r17 = CursorUtil.getColumnIndexOrThrow(r7, "coverageSuccessCount");     // Catch: Throwable -> L22
        int r18 = CursorUtil.getColumnIndexOrThrow(r7, "coverageTerminalFailureCount");     // Catch: Throwable -> L22
        int r19 = CursorUtil.getColumnIndexOrThrow(r7, "coverageState");     // Catch: Throwable -> L22
        RoomSQLiteQuery r110 = r5;
        ArrayList r20 = new ArrayList(r7.getCount());     // Catch: Throwable -> L20
    L11:
        if (r7.moveToNext() == false) goto L18;
        long r111 = r7.getLong(r0);     // Catch: Throwable -> L20
        int r21 = r7.getInt(r8);     // Catch: Throwable -> L20
        long r22 = r7.getLong(r9);     // Catch: Throwable -> L20
        long r23 = r7.getLong(r10);     // Catch: Throwable -> L20
        if (r7.getInt(r11) == 0) goto L15;
        boolean r25 = true;
    L16:
        r20.add(new bh(r111, r21, r22, r23, r25, r7.getLong(r12), r7.getLong(r13), r7.getInt(r14), r7.getLong(r15), r7.getInt(r16), r7.getInt(r17), r7.getInt(r18), r7.getInt(r19)));     // Catch: Throwable -> L20
        goto L11
    L15:
        r25 = false;
        goto L16
    L18:
        r7.close();
        r110.release();
        return r20;
    L20:
        th = th;
    L24:
        r7.close();
        r110.release();
        throw th;
    L22:
        th = th;
        r110 = r5;
        goto L24
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public int recordCoverageSettlement(long r4, int r6, long r7, int r9, long r10, int r12, int r13) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfRecordCoverageSettlement.acquire();
        r0.bindLong(1, r13);
        long r14 = r12;
        r0.bindLong(2, r14);
        r0.bindLong(3, r14);
        r0.bindLong(4, r4);
        r0.bindLong(5, r6);
        r0.bindLong(6, r7);
        r0.bindLong(7, r9);
        r0.bindLong(8, r10);
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfRecordCoverageSettlement.release(r0);
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfRecordCoverageSettlement.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public int resetCoverageRound(long r4, int r6, int r7, long r8, int r10, int r11, long r12) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfResetCoverageRound.acquire();
        r0.bindLong(1, r7);
        r0.bindLong(2, r8);
        r0.bindLong(3, r10);
        r0.bindLong(4, r11);
        r0.bindLong(5, r4);
        r0.bindLong(6, r6);
        r0.bindLong(7, r12);
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfResetCoverageRound.release(r0);
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfResetCoverageRound.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EntityIndexLifecycleDao
    public int updateCoverageRequiredCount(long r4, int r6, int r7, long r8, int r10, int r11, long r12) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateCoverageRequiredCount.acquire();
        r0.bindLong(1, r10);
        r0.bindLong(2, r11);
        r0.bindLong(3, r4);
        r0.bindLong(4, r6);
        r0.bindLong(5, r12);
        r0.bindLong(6, r7);
        r0.bindLong(7, r8);
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateCoverageRequiredCount.release(r0);
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateCoverageRequiredCount.release(r0);
        throw th;
    }
}
