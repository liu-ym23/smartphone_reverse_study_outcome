package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.ea;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class OrderHitDao_Impl implements OrderHitDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ea> __insertionAdapterOfOrderHitEntity;

    public OrderHitDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfOrderHitEntity = new AnonymousClass1(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.OrderHitDao
    public ea getOrder(String r11, String r12, String r13) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM SmartMemoryOrderHit WHERE packageName = ? AND orderType = ? AND orderId = ?", 3);
        if (r11 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r12 != null) goto L9;
        r0.bindNull(2);
    L10:
        if (r13 != null) goto L12;
        r0.bindNull(3);
    L13:
        this.__db.assertNotSuspendingTransaction();
        ea r14 = null;
        String r15 = null;
        Cursor r10 = DBUtil.query(this.__db, r0, false, null);
        int r16 = CursorUtil.getColumnIndexOrThrow(r10, OaidModel.KEY_ID);     // Catch: Throwable -> L31
        int r17 = CursorUtil.getColumnIndexOrThrow(r10, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L31
        int r1 = CursorUtil.getColumnIndexOrThrow(r10, "orderType");     // Catch: Throwable -> L31
        int r2 = CursorUtil.getColumnIndexOrThrow(r10, "orderId");     // Catch: Throwable -> L31
        if (r10.moveToFirst() == false) goto L29;
        long r5 = r10.getLong(r16);     // Catch: Throwable -> L31
        if (r10.isNull(r17) == false) goto L19;
        String r7 = null;
    L21:
        if (r10.isNull(r1) == false) goto L23;
        String r8 = null;
    L25:
        if (r10.isNull(r2) == true) goto L28;
        r15 = r10.getString(r2);     // Catch: Throwable -> L31
    L28:
        r14 = new ea(r5, r7, r8, r15);     // Catch: Throwable -> L31
        goto L29
    L23:
        r8 = r10.getString(r1);     // Catch: Throwable -> L31
        goto L25
    L19:
        r7 = r10.getString(r17);     // Catch: Throwable -> L31
    L29:
        r10.close();
        r0.release();
        return r14;
    L31:
        th = move-exception;
        r10.close();
        r0.release();
        throw th;
    L12:
        r0.bindString(3, r13);
        goto L13
    L9:
        r0.bindString(2, r12);
        goto L10
    L5:
        r0.bindString(1, r11);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.OrderHitDao
    public void insertOrder(ea r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfOrderHitEntity.insert(r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
