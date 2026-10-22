package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.er;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class ProactiveEcaConditionDao_Impl implements ProactiveEcaConditionDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<er> __insertionAdapterOfProactiveEcaConditionEntity;
    private final SharedSQLiteStatement __preparedStmtOfUpdateIsDeleteBySubscriptionId;

    public ProactiveEcaConditionDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfProactiveEcaConditionEntity = new AnonymousClass1(this, r2);
        this.__preparedStmtOfUpdateIsDeleteBySubscriptionId = new AnonymousClass2(this, r2);
    }

    static /* synthetic */ RoomDatabase access$000(ProactiveEcaConditionDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.ProactiveEcaConditionDao
    public er getById(String r36) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM `ProactiveEcaCondition` WHERE condition_id = ? LIMIT 1", 1);
        if (r36 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, "condition_id");     // Catch: Throwable -> L54
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "recommend_id");     // Catch: Throwable -> L54
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "task_id");     // Catch: Throwable -> L54
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "events");     // Catch: Throwable -> L54
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "timers");     // Catch: Throwable -> L54
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "code");     // Catch: Throwable -> L54
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "feature_duration_triggered_list");     // Catch: Throwable -> L54
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "script_deadline");     // Catch: Throwable -> L54
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "is_one_time");     // Catch: Throwable -> L54
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "created");     // Catch: Throwable -> L54
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "updated");     // Catch: Throwable -> L54
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "is_delete");     // Catch: Throwable -> L54
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L54
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L54
        if (r5.moveToFirst() == true) goto L10;
        er r16 = null;
    L52:
        r5.close();
        r2.release();
        return r16;
    L10:
        if (r5.isNull(r0) == false) goto L12;
        String r17 = null;
    L14:
        if (r5.isNull(r6) == false) goto L16;
        String r18 = null;
    L18:
        if (r5.isNull(r7) == false) goto L20;
        String r19 = null;
    L22:
        if (r5.isNull(r8) == false) goto L24;
        String r20 = null;
    L26:
        if (r5.isNull(r9) == false) goto L28;
        String r21 = null;
    L30:
        if (r5.isNull(r10) == false) goto L32;
        String r22 = null;
    L34:
        if (r5.isNull(r11) == false) goto L36;
        String r23 = null;
    L38:
        if (r5.isNull(r12) == false) goto L40;
        String r24 = null;
    L42:
        if (r5.getInt(r13) == 0) goto L44;
        boolean r25 = true;
    L45:
        long r26 = r5.getLong(r14);     // Catch: Throwable -> L54
        long r28 = r5.getLong(r15);     // Catch: Throwable -> L54
        if (r5.getInt(r1) == 0) goto L48;
        boolean r30 = true;
    L49:
        r16 = new er(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r30, r5.getLong(r3), r5.getLong(r4));     // Catch: Throwable -> L54
        goto L52
    L48:
        r30 = false;
        goto L49
    L44:
        r25 = false;
        goto L45
    L40:
        r24 = r5.getString(r12);     // Catch: Throwable -> L54
        goto L42
    L36:
        r23 = r5.getString(r11);     // Catch: Throwable -> L54
        goto L38
    L32:
        r22 = r5.getString(r10);     // Catch: Throwable -> L54
        goto L34
    L28:
        r21 = r5.getString(r9);     // Catch: Throwable -> L54
        goto L30
    L24:
        r20 = r5.getString(r8);     // Catch: Throwable -> L54
        goto L26
    L20:
        r19 = r5.getString(r7);     // Catch: Throwable -> L54
        goto L22
    L16:
        r18 = r5.getString(r6);     // Catch: Throwable -> L54
        goto L18
    L12:
        r17 = r5.getString(r0);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        r5.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r36);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveEcaConditionDao
    public er getByRecommendId(String r36) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM `ProactiveEcaCondition` WHERE recommend_id = ? LIMIT 1", 1);
        if (r36 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, "condition_id");     // Catch: Throwable -> L54
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "recommend_id");     // Catch: Throwable -> L54
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "task_id");     // Catch: Throwable -> L54
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "events");     // Catch: Throwable -> L54
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "timers");     // Catch: Throwable -> L54
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "code");     // Catch: Throwable -> L54
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "feature_duration_triggered_list");     // Catch: Throwable -> L54
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "script_deadline");     // Catch: Throwable -> L54
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "is_one_time");     // Catch: Throwable -> L54
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "created");     // Catch: Throwable -> L54
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "updated");     // Catch: Throwable -> L54
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "is_delete");     // Catch: Throwable -> L54
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L54
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L54
        if (r5.moveToFirst() == true) goto L10;
        er r16 = null;
    L52:
        r5.close();
        r2.release();
        return r16;
    L10:
        if (r5.isNull(r0) == false) goto L12;
        String r17 = null;
    L14:
        if (r5.isNull(r6) == false) goto L16;
        String r18 = null;
    L18:
        if (r5.isNull(r7) == false) goto L20;
        String r19 = null;
    L22:
        if (r5.isNull(r8) == false) goto L24;
        String r20 = null;
    L26:
        if (r5.isNull(r9) == false) goto L28;
        String r21 = null;
    L30:
        if (r5.isNull(r10) == false) goto L32;
        String r22 = null;
    L34:
        if (r5.isNull(r11) == false) goto L36;
        String r23 = null;
    L38:
        if (r5.isNull(r12) == false) goto L40;
        String r24 = null;
    L42:
        if (r5.getInt(r13) == 0) goto L44;
        boolean r25 = true;
    L45:
        long r26 = r5.getLong(r14);     // Catch: Throwable -> L54
        long r28 = r5.getLong(r15);     // Catch: Throwable -> L54
        if (r5.getInt(r1) == 0) goto L48;
        boolean r30 = true;
    L49:
        r16 = new er(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r30, r5.getLong(r3), r5.getLong(r4));     // Catch: Throwable -> L54
        goto L52
    L48:
        r30 = false;
        goto L49
    L44:
        r25 = false;
        goto L45
    L40:
        r24 = r5.getString(r12);     // Catch: Throwable -> L54
        goto L42
    L36:
        r23 = r5.getString(r11);     // Catch: Throwable -> L54
        goto L38
    L32:
        r22 = r5.getString(r10);     // Catch: Throwable -> L54
        goto L34
    L28:
        r21 = r5.getString(r9);     // Catch: Throwable -> L54
        goto L30
    L24:
        r20 = r5.getString(r8);     // Catch: Throwable -> L54
        goto L26
    L20:
        r19 = r5.getString(r7);     // Catch: Throwable -> L54
        goto L22
    L16:
        r18 = r5.getString(r6);     // Catch: Throwable -> L54
        goto L18
    L12:
        r17 = r5.getString(r0);     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        r5.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r36);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveEcaConditionDao
    public i<List<er>> observeAll() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM `ProactiveEcaCondition` ORDER BY timestamp DESC", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ProactiveEcaCondition"}, new AnonymousClass3(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.ProactiveEcaConditionDao
    public int updateIsDeleteBySubscriptionId(String r4, boolean r5, long r6) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateIsDeleteBySubscriptionId.acquire();
        r0.bindLong(1, r5 ? 1 : 0);
        r0.bindLong(2, r6);
        if (r4 != null) goto L5;
        r0.bindNull(3);
    L6:
        this.__db.beginTransaction();
        int r7 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateIsDeleteBySubscriptionId.release(r0);
        return r7;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateIsDeleteBySubscriptionId.release(r0);
        throw th;
    L5:
        r0.bindString(3, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveEcaConditionDao
    public void upsert(er r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfProactiveEcaConditionEntity.insert(r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
