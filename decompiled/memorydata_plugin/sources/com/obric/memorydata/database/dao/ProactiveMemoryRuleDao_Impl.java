package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.ev;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class ProactiveMemoryRuleDao_Impl implements ProactiveMemoryRuleDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ev> __insertionAdapterOfProactiveMemoryRuleEntity;

    public ProactiveMemoryRuleDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfProactiveMemoryRuleEntity = new AnonymousClass1(this, r2);
    }

    static /* synthetic */ RoomDatabase access$000(ProactiveMemoryRuleDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.ProactiveMemoryRuleDao
    public ev getById(String r29) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveMemoryRule WHERE rule_id = ? LIMIT 1", 1);
        if (r29 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        ev r4 = null;
        String r5 = null;
        Cursor r6 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r6, "rule_id");     // Catch: Throwable -> L32
        int r7 = CursorUtil.getColumnIndexOrThrow(r6, "bind_id");     // Catch: Throwable -> L32
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, "title");     // Catch: Throwable -> L32
        int r9 = CursorUtil.getColumnIndexOrThrow(r6, Params.CONTENT);     // Catch: Throwable -> L32
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
        String r17 = null;
    L22:
        if (r6.isNull(r9) == false) goto L24;
    L23:
        String r18 = r5;
        long r19 = r6.getLong(r10);     // Catch: Throwable -> L32
        long r21 = r6.getLong(r11);     // Catch: Throwable -> L32
        if (r6.getInt(r12) == 0) goto L28;
        boolean r23 = true;
    L29:
        r4 = new ev(r15, r16, r17, r18, r19, r21, r23, r6.getLong(r13), r6.getLong(r14));     // Catch: Throwable -> L32
        goto L30
    L28:
        r23 = false;
        goto L29
    L24:
        r5 = r6.getString(r9);     // Catch: Throwable -> L32
        goto L23
    L20:
        r17 = r6.getString(r8);     // Catch: Throwable -> L32
        goto L22
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

    @Override // com.obric.memorydata.database.dao.ProactiveMemoryRuleDao
    public i<List<ev>> observeAll() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveMemoryRule WHERE is_delete = 0 ORDER BY updated DESC", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ProactiveMemoryRule"}, new AnonymousClass2(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.ProactiveMemoryRuleDao
    public void upsert(ev r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfProactiveMemoryRuleEntity.insert(r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
