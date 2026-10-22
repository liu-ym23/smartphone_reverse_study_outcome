package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.ex;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class ProactiveOsNotificationDao_Impl implements ProactiveOsNotificationDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ex> __insertionAdapterOfProactiveOsNotificationEntity;

    public ProactiveOsNotificationDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfProactiveOsNotificationEntity = new AnonymousClass1(this, r2);
    }

    static /* synthetic */ RoomDatabase access$000(ProactiveOsNotificationDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.ProactiveOsNotificationDao
    public long insert(ex r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfProactiveOsNotificationEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveOsNotificationDao
    public List<ex> listRecent(int r32) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveOsNotification ORDER BY post_timestamp DESC LIMIT ?", 1);
        r1.bindLong(1, r32);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "title");     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "post_timestamp");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "notificationId");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "appName");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "flags");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "subTitle");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "channel");     // Catch: Throwable -> L34
        ArrayList r14 = new ArrayList(r2.getCount());     // Catch: Throwable -> L34
    L4:
        if (r2.moveToNext() == false) goto L32;
        long r17 = r2.getLong(r0);     // Catch: Throwable -> L34
        if (r2.isNull(r4) == false) goto L9;
        String r19 = null;
    L11:
        if (r2.isNull(r5) == false) goto L13;
        String r20 = null;
    L15:
        if (r2.isNull(r6) == false) goto L17;
        String r21 = null;
    L18:
        long r22 = r2.getLong(r7);     // Catch: Throwable -> L34
        long r24 = r2.getLong(r8);     // Catch: Throwable -> L34
        int r26 = r2.getInt(r9);     // Catch: Throwable -> L34
        if (r2.isNull(r10) == false) goto L21;
        String r27 = null;
    L22:
        int r28 = r2.getInt(r11);     // Catch: Throwable -> L34
        if (r2.isNull(r12) == false) goto L25;
        String r29 = null;
    L27:
        if (r2.isNull(r13) == false) goto L29;
        String r30 = null;
    L30:
        r14.add(new ex(r17, r19, r20, r21, r22, r24, r26, r27, r28, r29, r30));     // Catch: Throwable -> L34
        goto L4
    L29:
        r30 = r2.getString(r13);     // Catch: Throwable -> L34
        goto L30
    L25:
        r29 = r2.getString(r12);     // Catch: Throwable -> L34
        goto L27
    L21:
        r27 = r2.getString(r10);     // Catch: Throwable -> L34
        goto L22
    L17:
        r21 = r2.getString(r6);     // Catch: Throwable -> L34
        goto L18
    L13:
        r20 = r2.getString(r5);     // Catch: Throwable -> L34
        goto L15
    L9:
        r19 = r2.getString(r4);     // Catch: Throwable -> L34
        goto L11
    L32:
        r2.close();
        r1.release();
        return r14;
    L34:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveOsNotificationDao
    public i<Long> observeLatestId() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id FROM ProactiveOsNotification ORDER BY id DESC LIMIT 1", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ProactiveOsNotification"}, new AnonymousClass2(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.ProactiveOsNotificationDao
    public ex queryById(long r31) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveOsNotification WHERE id = ? LIMIT 1", 1);
        r1.bindLong(1, r31);
        this.__db.assertNotSuspendingTransaction();
        ex r3 = null;
        String r4 = null;
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L32
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L32
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "title");     // Catch: Throwable -> L32
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);     // Catch: Throwable -> L32
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L32
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "post_timestamp");     // Catch: Throwable -> L32
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "notificationId");     // Catch: Throwable -> L32
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "appName");     // Catch: Throwable -> L32
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "flags");     // Catch: Throwable -> L32
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "subTitle");     // Catch: Throwable -> L32
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "channel");     // Catch: Throwable -> L32
        if (r2.moveToFirst() == false) goto L30;
        long r16 = r2.getLong(r0);     // Catch: Throwable -> L32
        if (r2.isNull(r5) == false) goto L8;
        String r18 = null;
    L10:
        if (r2.isNull(r6) == false) goto L12;
        String r19 = null;
    L14:
        if (r2.isNull(r7) == false) goto L16;
        String r20 = null;
    L17:
        long r21 = r2.getLong(r8);     // Catch: Throwable -> L32
        long r23 = r2.getLong(r9);     // Catch: Throwable -> L32
        int r25 = r2.getInt(r10);     // Catch: Throwable -> L32
        if (r2.isNull(r11) == false) goto L20;
        String r26 = null;
    L21:
        int r27 = r2.getInt(r12);     // Catch: Throwable -> L32
        if (r2.isNull(r13) == false) goto L24;
        String r28 = null;
    L26:
        if (r2.isNull(r14) == true) goto L29;
        r4 = r2.getString(r14);     // Catch: Throwable -> L32
    L29:
        r3 = new ex(r16, r18, r19, r20, r21, r23, r25, r26, r27, r28, r4);     // Catch: Throwable -> L32
        goto L30
    L24:
        r28 = r2.getString(r13);     // Catch: Throwable -> L32
        goto L26
    L20:
        r26 = r2.getString(r11);     // Catch: Throwable -> L32
        goto L21
    L16:
        r20 = r2.getString(r7);     // Catch: Throwable -> L32
        goto L17
    L12:
        r19 = r2.getString(r6);     // Catch: Throwable -> L32
        goto L14
    L8:
        r18 = r2.getString(r5);     // Catch: Throwable -> L32
    L30:
        r2.close();
        r1.release();
        return r3;
    L32:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }
}
