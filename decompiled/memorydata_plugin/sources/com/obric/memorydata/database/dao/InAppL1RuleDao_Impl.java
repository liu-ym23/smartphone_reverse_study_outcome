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
import com.obric.memorydata.database.entity.ca;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class InAppL1RuleDao_Impl implements InAppL1RuleDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ca> __insertionAdapterOfInAppL1RuleEntity;
    private final SharedSQLiteStatement __preparedStmtOfRemove;

    public InAppL1RuleDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfInAppL1RuleEntity = new AnonymousClass1(this, r2);
        this.__preparedStmtOfRemove = new AnonymousClass2(this, r2);
    }

    static /* synthetic */ RoomDatabase access$000(InAppL1RuleDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.InAppL1RuleDao
    public i<List<ca>> observe() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM in_app_l1_rule ORDER BY package_name, rule_id", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"in_app_l1_rule"}, new AnonymousClass3(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.InAppL1RuleDao
    public List<ca> readAll() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM in_app_l1_rule ORDER BY package_name, rule_id", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "package_name");     // Catch: Throwable -> L30
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "rule_id");     // Catch: Throwable -> L30
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "engine_version");     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "rule_version");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "min_app_version_code");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "max_app_version_code");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "rule_json");     // Catch: Throwable -> L30
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "business");     // Catch: Throwable -> L30
        ArrayList r11 = new ArrayList(r2.getCount());     // Catch: Throwable -> L30
    L4:
        if (r2.moveToNext() == false) goto L28;
        if (r2.isNull(r0) == false) goto L9;
        String r14 = null;
    L11:
        if (r2.isNull(r4) == false) goto L13;
        String r15 = null;
    L14:
        int r16 = r2.getInt(r5);     // Catch: Throwable -> L30
        if (r2.isNull(r6) == false) goto L17;
        String r17 = null;
    L18:
        long r18 = r2.getLong(r7);     // Catch: Throwable -> L30
        long r20 = r2.getLong(r8);     // Catch: Throwable -> L30
        if (r2.isNull(r9) == false) goto L21;
        String r22 = null;
    L23:
        if (r2.isNull(r10) == false) goto L25;
        String r23 = null;
    L26:
        r11.add(new ca(r14, r15, r16, r17, r18, r20, r22, r23));     // Catch: Throwable -> L30
        goto L4
    L25:
        r23 = r2.getString(r10);     // Catch: Throwable -> L30
        goto L26
    L21:
        r22 = r2.getString(r9);     // Catch: Throwable -> L30
        goto L23
    L17:
        r17 = r2.getString(r6);     // Catch: Throwable -> L30
        goto L18
    L13:
        r15 = r2.getString(r4);     // Catch: Throwable -> L30
        goto L14
    L9:
        r14 = r2.getString(r0);     // Catch: Throwable -> L30
        goto L11
    L28:
        r2.close();
        r1.release();
        return r11;
    L30:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.InAppL1RuleDao
    public void remove(String r3, String r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfRemove.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfRemove.release(r0);
        return;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfRemove.release(r0);
        throw th;
    L9:
        r0.bindString(2, r4);
        goto L10
    L5:
        r0.bindString(1, r3);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.InAppL1RuleDao
    public void upsert(List<ca> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfInAppL1RuleEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
