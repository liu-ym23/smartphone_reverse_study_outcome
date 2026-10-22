package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.obric.memorydata.database.entity.cv;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryProcessConsumerSubscriptionDao_Impl implements MemoryProcessConsumerSubscriptionDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<cv> __insertionAdapterOfMemoryProcessConsumerSubscriptionEntity;

    public MemoryProcessConsumerSubscriptionDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryProcessConsumerSubscriptionEntity = new AnonymousClass1(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessConsumerSubscriptionDao
    public long insert(cv r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryProcessConsumerSubscriptionEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessConsumerSubscriptionDao
    public List<Long> insertAll(List<cv> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryProcessConsumerSubscriptionEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessConsumerSubscriptionDao
    public List<cv> queryActive() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryProcessConsumerSubscription WHERE status = 'active'", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "businessId");     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "memoryTypes");     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "triggerMode");     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "semanticTypes");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "sourceBusinesses");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "status");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "createTime");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "updateTime");     // Catch: Throwable -> L34
        ArrayList r11 = new ArrayList(r2.getCount());     // Catch: Throwable -> L34
    L4:
        if (r2.moveToNext() == false) goto L32;
        if (r2.isNull(r0) == false) goto L9;
        String r14 = null;
    L11:
        if (r2.isNull(r4) == false) goto L13;
        String r15 = null;
    L15:
        if (r2.isNull(r5) == false) goto L17;
        String r16 = null;
    L19:
        if (r2.isNull(r6) == false) goto L21;
        String r17 = null;
    L23:
        if (r2.isNull(r7) == false) goto L25;
        String r18 = null;
    L27:
        if (r2.isNull(r8) == false) goto L29;
        String r19 = null;
    L30:
        r11.add(new cv(r14, r15, r16, r17, r18, r19, r2.getLong(r9), r2.getLong(r10)));     // Catch: Throwable -> L34
        goto L4
    L29:
        r19 = r2.getString(r8);     // Catch: Throwable -> L34
        goto L30
    L25:
        r18 = r2.getString(r7);     // Catch: Throwable -> L34
        goto L27
    L21:
        r17 = r2.getString(r6);     // Catch: Throwable -> L34
        goto L23
    L17:
        r16 = r2.getString(r5);     // Catch: Throwable -> L34
        goto L19
    L13:
        r15 = r2.getString(r4);     // Catch: Throwable -> L34
        goto L15
    L9:
        r14 = r2.getString(r0);     // Catch: Throwable -> L34
        goto L11
    L32:
        r2.close();
        r1.release();
        return r11;
    L34:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }
}
