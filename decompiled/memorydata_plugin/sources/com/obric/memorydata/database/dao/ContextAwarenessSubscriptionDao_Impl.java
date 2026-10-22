package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.at;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ContextAwarenessSubscriptionDao_Impl implements ContextAwarenessSubscriptionDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<at> __insertionAdapterOfContextAwarenessSubscriptionEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllByOwner;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByOwnerAndSubscription;
    private final SharedSQLiteStatement __preparedStmtOfUpdateLastMatched;

    public ContextAwarenessSubscriptionDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfContextAwarenessSubscriptionEntity = new AnonymousClass1(this, r2);
        this.__preparedStmtOfDeleteByOwnerAndSubscription = new AnonymousClass2(this, r2);
        this.__preparedStmtOfDeleteAllByOwner = new AnonymousClass3(this, r2);
        this.__preparedStmtOfUpdateLastMatched = new AnonymousClass4(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.ContextAwarenessSubscriptionDao
    public int deleteAllByOwner(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAllByOwner.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllByOwner.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllByOwner.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ContextAwarenessSubscriptionDao
    public int deleteByOwnerAndSubscription(String r3, String r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByOwnerAndSubscription.acquire();
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
        this.__preparedStmtOfDeleteByOwnerAndSubscription.release(r0);
        return r5;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByOwnerAndSubscription.release(r0);
        throw th;
    L9:
        r0.bindString(2, r4);
        goto L10
    L5:
        r0.bindString(1, r3);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.ContextAwarenessSubscriptionDao
    public long insert(at r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfContextAwarenessSubscriptionEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ContextAwarenessSubscriptionDao
    public List<at> listAll() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM context_awareness_subscription", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "owner_package");     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "subscription_id");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "target_type");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "target_name");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "condition");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "last_matched");     // Catch: Throwable -> L34
        ArrayList r11 = new ArrayList(r4.getCount());     // Catch: Throwable -> L34
    L4:
        if (r4.moveToNext() == false) goto L32;
        long r14 = r4.getLong(r0);     // Catch: Throwable -> L34
        if (r4.isNull(r5) == false) goto L9;
        String r16 = null;
    L11:
        if (r4.isNull(r6) == false) goto L13;
        String r17 = null;
    L15:
        if (r4.isNull(r7) == false) goto L17;
        String r18 = null;
    L19:
        if (r4.isNull(r8) == false) goto L21;
        String r19 = null;
    L23:
        if (r4.isNull(r9) == false) goto L25;
        String r20 = null;
    L27:
        if (r4.getInt(r10) == 0) goto L29;
        boolean r21 = true;
    L30:
        r11.add(new at(r14, r16, r17, r18, r19, r20, r21));     // Catch: Throwable -> L34
        goto L4
    L29:
        r21 = false;
        goto L30
    L25:
        r20 = r4.getString(r9);     // Catch: Throwable -> L34
        goto L27
    L21:
        r19 = r4.getString(r8);     // Catch: Throwable -> L34
        goto L23
    L17:
        r18 = r4.getString(r7);     // Catch: Throwable -> L34
        goto L19
    L13:
        r17 = r4.getString(r6);     // Catch: Throwable -> L34
        goto L15
    L9:
        r16 = r4.getString(r5);     // Catch: Throwable -> L34
        goto L11
    L32:
        r4.close();
        r1.release();
        return r11;
    L34:
        th = move-exception;
        r4.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ContextAwarenessSubscriptionDao
    public List<at> listByOwner(String r24) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM context_awareness_subscription WHERE owner_package = ?", 1);
        if (r24 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L38
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "owner_package");     // Catch: Throwable -> L38
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "subscription_id");     // Catch: Throwable -> L38
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "target_type");     // Catch: Throwable -> L38
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "target_name");     // Catch: Throwable -> L38
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "condition");     // Catch: Throwable -> L38
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "last_matched");     // Catch: Throwable -> L38
        ArrayList r12 = new ArrayList(r5.getCount());     // Catch: Throwable -> L38
    L8:
        if (r5.moveToNext() == false) goto L36;
        long r15 = r5.getLong(r0);     // Catch: Throwable -> L38
        if (r5.isNull(r6) == false) goto L13;
        String r17 = null;
    L15:
        if (r5.isNull(r7) == false) goto L17;
        String r18 = null;
    L19:
        if (r5.isNull(r8) == false) goto L21;
        String r19 = null;
    L23:
        if (r5.isNull(r9) == false) goto L25;
        String r20 = null;
    L27:
        if (r5.isNull(r10) == false) goto L29;
        String r21 = null;
    L31:
        if (r5.getInt(r11) == 0) goto L33;
        boolean r22 = true;
    L34:
        r12.add(new at(r15, r17, r18, r19, r20, r21, r22));     // Catch: Throwable -> L38
        goto L8
    L33:
        r22 = false;
        goto L34
    L29:
        r21 = r5.getString(r10);     // Catch: Throwable -> L38
        goto L31
    L25:
        r20 = r5.getString(r9);     // Catch: Throwable -> L38
        goto L27
    L21:
        r19 = r5.getString(r8);     // Catch: Throwable -> L38
        goto L23
    L17:
        r18 = r5.getString(r7);     // Catch: Throwable -> L38
        goto L19
    L13:
        r17 = r5.getString(r6);     // Catch: Throwable -> L38
        goto L15
    L36:
        r5.close();
        r2.release();
        return r12;
    L38:
        th = move-exception;
        r5.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r24);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ContextAwarenessSubscriptionDao
    public List<at> listByOwnerAndSubscription(String r24, String r25) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM context_awareness_subscription WHERE owner_package = ? AND subscription_id = ?", 2);
        if (r24 != null) goto L5;
        r3.bindNull(1);
    L6:
        if (r25 != null) goto L8;
        r3.bindNull(2);
    L9:
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L41
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "owner_package");     // Catch: Throwable -> L41
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "subscription_id");     // Catch: Throwable -> L41
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "target_type");     // Catch: Throwable -> L41
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "target_name");     // Catch: Throwable -> L41
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "condition");     // Catch: Throwable -> L41
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "last_matched");     // Catch: Throwable -> L41
        ArrayList r12 = new ArrayList(r4.getCount());     // Catch: Throwable -> L41
    L11:
        if (r4.moveToNext() == false) goto L39;
        long r15 = r4.getLong(r0);     // Catch: Throwable -> L41
        if (r4.isNull(r6) == false) goto L16;
        String r17 = null;
    L18:
        if (r4.isNull(r7) == false) goto L20;
        String r18 = null;
    L22:
        if (r4.isNull(r8) == false) goto L24;
        String r19 = null;
    L26:
        if (r4.isNull(r9) == false) goto L28;
        String r20 = null;
    L30:
        if (r4.isNull(r10) == false) goto L32;
        String r21 = null;
    L34:
        if (r4.getInt(r11) == 0) goto L36;
        boolean r22 = true;
    L37:
        r12.add(new at(r15, r17, r18, r19, r20, r21, r22));     // Catch: Throwable -> L41
        goto L11
    L36:
        r22 = false;
        goto L37
    L32:
        r21 = r4.getString(r10);     // Catch: Throwable -> L41
        goto L34
    L28:
        r20 = r4.getString(r9);     // Catch: Throwable -> L41
        goto L30
    L24:
        r19 = r4.getString(r8);     // Catch: Throwable -> L41
        goto L26
    L20:
        r18 = r4.getString(r7);     // Catch: Throwable -> L41
        goto L22
    L16:
        r17 = r4.getString(r6);     // Catch: Throwable -> L41
        goto L18
    L39:
        r4.close();
        r3.release();
        return r12;
    L41:
        th = move-exception;
        r4.close();
        r3.release();
        throw th;
    L8:
        r3.bindString(2, r25);
        goto L9
    L5:
        r3.bindString(1, r24);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ContextAwarenessSubscriptionDao
    public int updateLastMatched(String r4, String r5, String r6, String r7, boolean r8) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateLastMatched.acquire();
        r0.bindLong(1, r8 ? 1 : 0);
        if (r4 != null) goto L5;
        r0.bindNull(2);
    L7:
        if (r5 != null) goto L9;
        r0.bindNull(3);
    L11:
        if (r6 != null) goto L13;
        r0.bindNull(4);
    L15:
        if (r7 != null) goto L17;
        r0.bindNull(5);
    L18:
        this.__db.beginTransaction();
        int r9 = r0.executeUpdateDelete();     // Catch: Throwable -> L22
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L22
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateLastMatched.release(r0);
        return r9;
    L22:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateLastMatched.release(r0);
        throw th;
    L17:
        r0.bindString(5, r7);
        goto L18
    L13:
        r0.bindString(4, r6);
        goto L15
    L9:
        r0.bindString(3, r5);
        goto L11
    L5:
        r0.bindString(2, r4);
        goto L7
    }
}
