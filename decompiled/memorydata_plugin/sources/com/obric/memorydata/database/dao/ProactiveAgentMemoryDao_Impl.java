package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.eq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ProactiveAgentMemoryDao_Impl implements ProactiveAgentMemoryDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<eq> __insertionAdapterOfProactiveAgentMemoryEntity;

    public ProactiveAgentMemoryDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfProactiveAgentMemoryEntity = new AnonymousClass1(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.ProactiveAgentMemoryDao
    public eq getById(String r31) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveAgentMemory WHERE record_id = ? LIMIT 1", 1);
        if (r31 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        eq r4 = null;
        String r5 = null;
        Cursor r6 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r6, "record_id");     // Catch: Throwable -> L36
        int r7 = CursorUtil.getColumnIndexOrThrow(r6, "task_id");     // Catch: Throwable -> L36
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, "recommend_id");     // Catch: Throwable -> L36
        int r9 = CursorUtil.getColumnIndexOrThrow(r6, "summary");     // Catch: Throwable -> L36
        int r10 = CursorUtil.getColumnIndexOrThrow(r6, "messages");     // Catch: Throwable -> L36
        int r11 = CursorUtil.getColumnIndexOrThrow(r6, "created");     // Catch: Throwable -> L36
        int r12 = CursorUtil.getColumnIndexOrThrow(r6, "updated");     // Catch: Throwable -> L36
        int r13 = CursorUtil.getColumnIndexOrThrow(r6, "is_delete");     // Catch: Throwable -> L36
        int r14 = CursorUtil.getColumnIndexOrThrow(r6, "timestamp");     // Catch: Throwable -> L36
        int r15 = CursorUtil.getColumnIndexOrThrow(r6, OaidModel.KEY_ID);     // Catch: Throwable -> L36
        if (r6.moveToFirst() == true) goto L10;
    L34:
        r6.close();
        r2.release();
        return r4;
    L10:
        if (r6.isNull(r0) == false) goto L12;
        String r16 = null;
    L14:
        if (r6.isNull(r7) == false) goto L16;
        String r17 = null;
    L18:
        if (r6.isNull(r8) == false) goto L20;
        String r18 = null;
    L22:
        if (r6.isNull(r9) == false) goto L24;
        String r19 = null;
    L26:
        if (r6.isNull(r10) == false) goto L28;
    L27:
        String r20 = r5;
        long r21 = r6.getLong(r11);     // Catch: Throwable -> L36
        long r23 = r6.getLong(r12);     // Catch: Throwable -> L36
        if (r6.getInt(r13) == 0) goto L32;
        boolean r25 = true;
    L33:
        r4 = new eq(r16, r17, r18, r19, r20, r21, r23, r25, r6.getLong(r14), r6.getLong(r15));     // Catch: Throwable -> L36
        goto L34
    L32:
        r25 = false;
        goto L33
    L28:
        r5 = r6.getString(r10);     // Catch: Throwable -> L36
        goto L27
    L24:
        r19 = r6.getString(r9);     // Catch: Throwable -> L36
        goto L26
    L20:
        r18 = r6.getString(r8);     // Catch: Throwable -> L36
        goto L22
    L16:
        r17 = r6.getString(r7);     // Catch: Throwable -> L36
        goto L18
    L12:
        r16 = r6.getString(r0);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r6.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r31);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveAgentMemoryDao
    public List<eq> listRecent(int r32) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveAgentMemory ORDER BY created DESC LIMIT ?", 1);
        r1.bindLong(1, r32);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, "record_id");     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "task_id");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "recommend_id");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "summary");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "messages");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "created");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "updated");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "is_delete");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L34
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        ArrayList r15 = new ArrayList(r5.getCount());     // Catch: Throwable -> L34
    L4:
        if (r5.moveToNext() == false) goto L32;
        if (r5.isNull(r0) == false) goto L9;
        String r17 = null;
    L11:
        if (r5.isNull(r6) == false) goto L13;
        String r18 = null;
    L15:
        if (r5.isNull(r7) == false) goto L17;
        String r19 = null;
    L19:
        if (r5.isNull(r8) == false) goto L21;
        String r20 = null;
    L23:
        if (r5.isNull(r9) == false) goto L25;
        String r21 = null;
    L26:
        long r22 = r5.getLong(r10);     // Catch: Throwable -> L34
        long r24 = r5.getLong(r11);     // Catch: Throwable -> L34
        if (r5.getInt(r12) == 0) goto L29;
        boolean r26 = true;
    L30:
        r15.add(new eq(r17, r18, r19, r20, r21, r22, r24, r26, r5.getLong(r13), r5.getLong(r14)));     // Catch: Throwable -> L34
        goto L4
    L29:
        r26 = false;
        goto L30
    L25:
        r21 = r5.getString(r9);     // Catch: Throwable -> L34
        goto L26
    L21:
        r20 = r5.getString(r8);     // Catch: Throwable -> L34
        goto L23
    L17:
        r19 = r5.getString(r7);     // Catch: Throwable -> L34
        goto L19
    L13:
        r18 = r5.getString(r6);     // Catch: Throwable -> L34
        goto L15
    L9:
        r17 = r5.getString(r0);     // Catch: Throwable -> L34
        goto L11
    L32:
        r5.close();
        r1.release();
        return r15;
    L34:
        th = move-exception;
        r5.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveAgentMemoryDao
    public void upsert(eq r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfProactiveAgentMemoryEntity.insert(r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
