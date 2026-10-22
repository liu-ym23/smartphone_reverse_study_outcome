package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.fd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ProactiveUserSubscriptionsDao_Impl implements ProactiveUserSubscriptionsDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<fd> __insertionAdapterOfProactiveUserSubscriptionEntity;

    public ProactiveUserSubscriptionsDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfProactiveUserSubscriptionEntity = new AnonymousClass1(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.ProactiveUserSubscriptionsDao
    public fd getById(String r29) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveUserSubscriptions WHERE subscription_id = ? LIMIT 1", 1);
        if (r29 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        fd r4 = null;
        String r5 = null;
        Cursor r6 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r6, "subscription_id");     // Catch: Throwable -> L32
        int r7 = CursorUtil.getColumnIndexOrThrow(r6, Params.CONTENT);     // Catch: Throwable -> L32
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, "ui_data");     // Catch: Throwable -> L32
        int r9 = CursorUtil.getColumnIndexOrThrow(r6, "is_active");     // Catch: Throwable -> L32
        int r10 = CursorUtil.getColumnIndexOrThrow(r6, "created");     // Catch: Throwable -> L32
        int r11 = CursorUtil.getColumnIndexOrThrow(r6, "updated");     // Catch: Throwable -> L32
        int r12 = CursorUtil.getColumnIndexOrThrow(r6, "is_delete");     // Catch: Throwable -> L32
        int r13 = CursorUtil.getColumnIndexOrThrow(r6, "timestamp");     // Catch: Throwable -> L32
        int r14 = CursorUtil.getColumnIndexOrThrow(r6, OaidModel.KEY_ID);     // Catch: Throwable -> L32
        if (r6.moveToFirst() == true) goto L10;
    L30:
        r6.close();
        r2.release();
        return r4;
    L10:
        if (r6.isNull(r0) == false) goto L12;
        String r15 = null;
    L14:
        if (r6.isNull(r7) == false) goto L16;
        String r16 = null;
    L18:
        if (r6.isNull(r8) == false) goto L20;
    L19:
        String r17 = r5;
        if (r6.getInt(r9) == 0) goto L24;
        boolean r18 = true;
    L25:
        long r19 = r6.getLong(r10);     // Catch: Throwable -> L32
        long r21 = r6.getLong(r11);     // Catch: Throwable -> L32
        if (r6.getInt(r12) == 0) goto L28;
        boolean r23 = true;
    L29:
        r4 = new fd(r15, r16, r17, r18, r19, r21, r23, r6.getLong(r13), r6.getLong(r14));     // Catch: Throwable -> L32
        goto L30
    L28:
        r23 = false;
        goto L29
    L24:
        r18 = false;
        goto L25
    L20:
        r5 = r6.getString(r8);     // Catch: Throwable -> L32
        goto L19
    L16:
        r16 = r6.getString(r7);     // Catch: Throwable -> L32
        goto L18
    L12:
        r15 = r6.getString(r0);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        r6.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r29);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveUserSubscriptionsDao
    public List<fd> listActive() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveUserSubscriptions WHERE is_active = 1 ORDER BY created DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, "subscription_id");     // Catch: Throwable -> L30
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, Params.CONTENT);     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "ui_data");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "is_active");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "created");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "updated");     // Catch: Throwable -> L30
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "is_delete");     // Catch: Throwable -> L30
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L30
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        ArrayList r13 = new ArrayList(r4.getCount());     // Catch: Throwable -> L30
    L4:
        if (r4.moveToNext() == false) goto L28;
        if (r4.isNull(r0) == false) goto L9;
        String r16 = null;
    L11:
        if (r4.isNull(r5) == false) goto L13;
        String r17 = null;
    L15:
        if (r4.isNull(r6) == false) goto L17;
        String r18 = null;
    L19:
        if (r4.getInt(r7) == 0) goto L21;
        boolean r19 = true;
    L22:
        long r20 = r4.getLong(r8);     // Catch: Throwable -> L30
        long r22 = r4.getLong(r9);     // Catch: Throwable -> L30
        if (r4.getInt(r10) == 0) goto L25;
        boolean r24 = true;
    L26:
        r13.add(new fd(r16, r17, r18, r19, r20, r22, r24, r4.getLong(r11), r4.getLong(r12)));     // Catch: Throwable -> L30
        goto L4
    L25:
        r24 = false;
        goto L26
    L21:
        r19 = false;
        goto L22
    L17:
        r18 = r4.getString(r6);     // Catch: Throwable -> L30
        goto L19
    L13:
        r17 = r4.getString(r5);     // Catch: Throwable -> L30
        goto L15
    L9:
        r16 = r4.getString(r0);     // Catch: Throwable -> L30
        goto L11
    L28:
        r4.close();
        r1.release();
        return r13;
    L30:
        th = move-exception;
        r4.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveUserSubscriptionsDao
    public List<fd> listAll() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveUserSubscriptions ORDER BY created DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, "subscription_id");     // Catch: Throwable -> L30
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, Params.CONTENT);     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "ui_data");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "is_active");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "created");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "updated");     // Catch: Throwable -> L30
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "is_delete");     // Catch: Throwable -> L30
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L30
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        ArrayList r13 = new ArrayList(r4.getCount());     // Catch: Throwable -> L30
    L4:
        if (r4.moveToNext() == false) goto L28;
        if (r4.isNull(r0) == false) goto L9;
        String r16 = null;
    L11:
        if (r4.isNull(r5) == false) goto L13;
        String r17 = null;
    L15:
        if (r4.isNull(r6) == false) goto L17;
        String r18 = null;
    L19:
        if (r4.getInt(r7) == 0) goto L21;
        boolean r19 = true;
    L22:
        long r20 = r4.getLong(r8);     // Catch: Throwable -> L30
        long r22 = r4.getLong(r9);     // Catch: Throwable -> L30
        if (r4.getInt(r10) == 0) goto L25;
        boolean r24 = true;
    L26:
        r13.add(new fd(r16, r17, r18, r19, r20, r22, r24, r4.getLong(r11), r4.getLong(r12)));     // Catch: Throwable -> L30
        goto L4
    L25:
        r24 = false;
        goto L26
    L21:
        r19 = false;
        goto L22
    L17:
        r18 = r4.getString(r6);     // Catch: Throwable -> L30
        goto L19
    L13:
        r17 = r4.getString(r5);     // Catch: Throwable -> L30
        goto L15
    L9:
        r16 = r4.getString(r0);     // Catch: Throwable -> L30
        goto L11
    L28:
        r4.close();
        r1.release();
        return r13;
    L30:
        th = move-exception;
        r4.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveUserSubscriptionsDao
    public long upsert(fd r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfProactiveUserSubscriptionEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
