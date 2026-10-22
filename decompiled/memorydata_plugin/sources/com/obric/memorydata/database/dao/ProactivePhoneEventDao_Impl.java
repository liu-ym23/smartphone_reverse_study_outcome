package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.database.entity.ey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class ProactivePhoneEventDao_Impl implements ProactivePhoneEventDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ey> __insertionAdapterOfProactivePhoneEventEntity;
    private final SharedSQLiteStatement __preparedStmtOfUpdateStatus;
    private final EntityDeletionOrUpdateAdapter<ey> __updateAdapterOfProactivePhoneEventEntity;

    public ProactivePhoneEventDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfProactivePhoneEventEntity = new AnonymousClass1(this, r2);
        this.__updateAdapterOfProactivePhoneEventEntity = new AnonymousClass2(this, r2);
        this.__preparedStmtOfUpdateStatus = new AnonymousClass3(this, r2);
    }

    static /* synthetic */ RoomDatabase access$000(ProactivePhoneEventDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.ProactivePhoneEventDao
    public String findLatestDebugLogIdByRecommendId(String r4) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT debug_log_id\n        FROM ProactivePhoneEvent\n        WHERE debug_log_id IS NOT NULL\n          AND debug_log_id != ''\n          AND debug_content LIKE '%' || ? || '%'\n        ORDER BY created DESC\n        LIMIT 1\n        ", 1);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        String r1 = null;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L15:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L8:
        if (r3.moveToFirst() == true) goto L10;
    L13:
        r3.close();
        r0.release();
        return r1;
    L10:
        if (r3.isNull(0) == true) goto L13;
        r1 = r3.getString(0);     // Catch: Throwable -> L15
        goto L13
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactivePhoneEventDao
    public long insert(ey r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfProactivePhoneEventEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactivePhoneEventDao
    public List<ey> listByStatus(String r34, int r35) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactivePhoneEvent WHERE status = ? ORDER BY created ASC LIMIT ?", 2);
        if (r34 != null) goto L5;
        r2.bindNull(1);
    L6:
        r2.bindLong(2, r35);
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L38
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L38
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "raw_table");     // Catch: Throwable -> L38
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "raw_id");     // Catch: Throwable -> L38
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L38
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "status");     // Catch: Throwable -> L38
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, CommonConsts.COUNT_TYPE);     // Catch: Throwable -> L38
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "created");     // Catch: Throwable -> L38
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "updated");     // Catch: Throwable -> L38
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "debug_content");     // Catch: Throwable -> L38
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "debug_log_id");     // Catch: Throwable -> L38
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L38
        ArrayList r15 = new ArrayList(r1.getCount());     // Catch: Throwable -> L38
    L8:
        if (r1.moveToNext() == false) goto L36;
        long r17 = r1.getLong(r0);     // Catch: Throwable -> L38
        int r19 = r1.getInt(r4);     // Catch: Throwable -> L38
        if (r1.isNull(r5) == false) goto L13;
        String r20 = null;
    L15:
        if (r1.isNull(r6) == false) goto L17;
        String r21 = null;
    L19:
        if (r1.isNull(r7) == false) goto L21;
        String r22 = null;
    L23:
        if (r1.isNull(r8) == false) goto L25;
        String r23 = null;
    L26:
        int r24 = r1.getInt(r9);     // Catch: Throwable -> L38
        long r25 = r1.getLong(r10);     // Catch: Throwable -> L38
        long r27 = r1.getLong(r11);     // Catch: Throwable -> L38
        if (r1.isNull(r12) == false) goto L29;
        String r29 = null;
    L31:
        if (r1.isNull(r13) == false) goto L33;
        String r30 = null;
    L34:
        r15.add(new ey(r17, r19, r20, r21, r22, r23, r24, r25, r27, r29, r30, r1.getLong(r14)));     // Catch: Throwable -> L38
        goto L8
    L33:
        r30 = r1.getString(r13);     // Catch: Throwable -> L38
        goto L34
    L29:
        r29 = r1.getString(r12);     // Catch: Throwable -> L38
        goto L31
    L25:
        r23 = r1.getString(r8);     // Catch: Throwable -> L38
        goto L26
    L21:
        r22 = r1.getString(r7);     // Catch: Throwable -> L38
        goto L23
    L17:
        r21 = r1.getString(r6);     // Catch: Throwable -> L38
        goto L19
    L13:
        r20 = r1.getString(r5);     // Catch: Throwable -> L38
        goto L15
    L36:
        r1.close();
        r2.release();
        return r15;
    L38:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r34);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactivePhoneEventDao
    public i<List<ey>> observeByStatus(String r4, int r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ProactivePhoneEvent WHERE status = ? ORDER BY created ASC LIMIT ?", 2);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r5);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ProactivePhoneEvent"}, new AnonymousClass4(this, r0));
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactivePhoneEventDao
    public i<Long> observeLatestId() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id FROM ProactivePhoneEvent ORDER BY id DESC LIMIT 1", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ProactivePhoneEvent"}, new AnonymousClass5(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.ProactivePhoneEventDao
    public void update(ey r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfProactivePhoneEventEntity.handle(r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactivePhoneEventDao
    public int updateStatus(long r3, String r5, long r6) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateStatus.acquire();
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r6);
        r0.bindLong(3, r3);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateStatus.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateStatus.release(r0);
        throw th;
    L5:
        r0.bindString(1, r5);
        goto L6
    }
}
