package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.fc;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ProactiveSubscriptionTasksDao_Impl implements ProactiveSubscriptionTasksDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<fc> __insertionAdapterOfProactiveSubscriptionTaskEntity;

    public ProactiveSubscriptionTasksDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfProactiveSubscriptionTaskEntity = new AnonymousClass1(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.ProactiveSubscriptionTasksDao
    public fc getById(String r31) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveSubscriptionTasks WHERE task_id = ? LIMIT 1", 1);
        if (r31 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        fc r4 = null;
        String r5 = null;
        Cursor r6 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r6, "task_id");     // Catch: Throwable -> L36
        int r7 = CursorUtil.getColumnIndexOrThrow(r6, "task_description");     // Catch: Throwable -> L36
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, "task_state");     // Catch: Throwable -> L36
        int r9 = CursorUtil.getColumnIndexOrThrow(r6, "source_task_id");     // Catch: Throwable -> L36
        int r10 = CursorUtil.getColumnIndexOrThrow(r6, "subscription_id");     // Catch: Throwable -> L36
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
        r4 = new fc(r16, r17, r18, r19, r20, r21, r23, r25, r6.getLong(r14), r6.getLong(r15));     // Catch: Throwable -> L36
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

    @Override // com.obric.memorydata.database.dao.ProactiveSubscriptionTasksDao
    public List<fc> listAll() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveSubscriptionTasks ORDER BY updated DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, "task_id");     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "task_description");     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "task_state");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "source_task_id");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "subscription_id");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "created");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "updated");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "is_delete");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        ArrayList r14 = new ArrayList(r4.getCount());     // Catch: Throwable -> L34
    L4:
        if (r4.moveToNext() == false) goto L32;
        if (r4.isNull(r0) == false) goto L9;
        String r17 = null;
    L11:
        if (r4.isNull(r5) == false) goto L13;
        String r18 = null;
    L15:
        if (r4.isNull(r6) == false) goto L17;
        String r19 = null;
    L19:
        if (r4.isNull(r7) == false) goto L21;
        String r20 = null;
    L23:
        if (r4.isNull(r8) == false) goto L25;
        String r21 = null;
    L26:
        long r22 = r4.getLong(r9);     // Catch: Throwable -> L34
        long r24 = r4.getLong(r10);     // Catch: Throwable -> L34
        if (r4.getInt(r11) == 0) goto L29;
        boolean r26 = true;
    L30:
        r14.add(new fc(r17, r18, r19, r20, r21, r22, r24, r26, r4.getLong(r12), r4.getLong(r13)));     // Catch: Throwable -> L34
        goto L4
    L29:
        r26 = false;
        goto L30
    L25:
        r21 = r4.getString(r8);     // Catch: Throwable -> L34
        goto L26
    L21:
        r20 = r4.getString(r7);     // Catch: Throwable -> L34
        goto L23
    L17:
        r19 = r4.getString(r6);     // Catch: Throwable -> L34
        goto L19
    L13:
        r18 = r4.getString(r5);     // Catch: Throwable -> L34
        goto L15
    L9:
        r17 = r4.getString(r0);     // Catch: Throwable -> L34
        goto L11
    L32:
        r4.close();
        r1.release();
        return r14;
    L34:
        th = move-exception;
        r4.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveSubscriptionTasksDao
    public List<fc> listByState(String r32) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveSubscriptionTasks WHERE task_state = ? ORDER BY updated DESC", 1);
        if (r32 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, "task_id");     // Catch: Throwable -> L38
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "task_description");     // Catch: Throwable -> L38
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "task_state");     // Catch: Throwable -> L38
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "source_task_id");     // Catch: Throwable -> L38
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "subscription_id");     // Catch: Throwable -> L38
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "created");     // Catch: Throwable -> L38
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "updated");     // Catch: Throwable -> L38
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "is_delete");     // Catch: Throwable -> L38
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L38
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L38
        ArrayList r15 = new ArrayList(r5.getCount());     // Catch: Throwable -> L38
    L8:
        if (r5.moveToNext() == false) goto L36;
        if (r5.isNull(r0) == false) goto L13;
        String r17 = null;
    L15:
        if (r5.isNull(r6) == false) goto L17;
        String r18 = null;
    L19:
        if (r5.isNull(r7) == false) goto L21;
        String r19 = null;
    L23:
        if (r5.isNull(r8) == false) goto L25;
        String r20 = null;
    L27:
        if (r5.isNull(r9) == false) goto L29;
        String r21 = null;
    L30:
        long r22 = r5.getLong(r10);     // Catch: Throwable -> L38
        long r24 = r5.getLong(r11);     // Catch: Throwable -> L38
        if (r5.getInt(r12) == 0) goto L33;
        boolean r26 = true;
    L34:
        r15.add(new fc(r17, r18, r19, r20, r21, r22, r24, r26, r5.getLong(r13), r5.getLong(r14)));     // Catch: Throwable -> L38
        goto L8
    L33:
        r26 = false;
        goto L34
    L29:
        r21 = r5.getString(r9);     // Catch: Throwable -> L38
        goto L30
    L25:
        r20 = r5.getString(r8);     // Catch: Throwable -> L38
        goto L27
    L21:
        r19 = r5.getString(r7);     // Catch: Throwable -> L38
        goto L23
    L17:
        r18 = r5.getString(r6);     // Catch: Throwable -> L38
        goto L19
    L13:
        r17 = r5.getString(r0);     // Catch: Throwable -> L38
        goto L15
    L36:
        r5.close();
        r2.release();
        return r15;
    L38:
        th = move-exception;
        r5.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r32);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveSubscriptionTasksDao
    public List<fc> listBySubscriptionId(String r32) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveSubscriptionTasks WHERE subscription_id = ? ORDER BY updated DESC", 1);
        if (r32 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, "task_id");     // Catch: Throwable -> L38
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "task_description");     // Catch: Throwable -> L38
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "task_state");     // Catch: Throwable -> L38
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "source_task_id");     // Catch: Throwable -> L38
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "subscription_id");     // Catch: Throwable -> L38
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "created");     // Catch: Throwable -> L38
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "updated");     // Catch: Throwable -> L38
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "is_delete");     // Catch: Throwable -> L38
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L38
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L38
        ArrayList r15 = new ArrayList(r5.getCount());     // Catch: Throwable -> L38
    L8:
        if (r5.moveToNext() == false) goto L36;
        if (r5.isNull(r0) == false) goto L13;
        String r17 = null;
    L15:
        if (r5.isNull(r6) == false) goto L17;
        String r18 = null;
    L19:
        if (r5.isNull(r7) == false) goto L21;
        String r19 = null;
    L23:
        if (r5.isNull(r8) == false) goto L25;
        String r20 = null;
    L27:
        if (r5.isNull(r9) == false) goto L29;
        String r21 = null;
    L30:
        long r22 = r5.getLong(r10);     // Catch: Throwable -> L38
        long r24 = r5.getLong(r11);     // Catch: Throwable -> L38
        if (r5.getInt(r12) == 0) goto L33;
        boolean r26 = true;
    L34:
        r15.add(new fc(r17, r18, r19, r20, r21, r22, r24, r26, r5.getLong(r13), r5.getLong(r14)));     // Catch: Throwable -> L38
        goto L8
    L33:
        r26 = false;
        goto L34
    L29:
        r21 = r5.getString(r9);     // Catch: Throwable -> L38
        goto L30
    L25:
        r20 = r5.getString(r8);     // Catch: Throwable -> L38
        goto L27
    L21:
        r19 = r5.getString(r7);     // Catch: Throwable -> L38
        goto L23
    L17:
        r18 = r5.getString(r6);     // Catch: Throwable -> L38
        goto L19
    L13:
        r17 = r5.getString(r0);     // Catch: Throwable -> L38
        goto L15
    L36:
        r5.close();
        r2.release();
        return r15;
    L38:
        th = move-exception;
        r5.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r32);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveSubscriptionTasksDao
    public List<String> listTaskIdsBySourceTaskIds(List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT task_id FROM ProactiveSubscriptionTasks WHERE source_task_id IN (");
        int r2 = r8.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r9 = r8.iterator();
        int r3 = 1;
    L4:
        if (r9.hasNext() == false) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r1.bindNull(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r1.bindString(r3, r4);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r1, false, null);
        ArrayList r5 = new ArrayList(r6.getCount());     // Catch: Throwable -> L22
    L12:
        if (r6.moveToNext() == false) goto L20;
        if (r6.isNull(0) == false) goto L17;
        String r10 = null;
    L18:
        r5.add(r10);     // Catch: Throwable -> L22
        goto L12
    L17:
        r10 = r6.getString(0);     // Catch: Throwable -> L22
        goto L18
    L20:
        r6.close();
        r1.release();
        return r5;
    L22:
        th = move-exception;
        r6.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveSubscriptionTasksDao
    public List<String> listTaskIdsBySubscriptionId(String r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT task_id FROM ProactiveSubscriptionTasks WHERE subscription_id = ?", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r4.getCount());     // Catch: Throwable -> L18
    L8:
        if (r4.moveToNext() == false) goto L16;
        if (r4.isNull(0) == false) goto L13;
        String r3 = null;
    L14:
        r2.add(r3);     // Catch: Throwable -> L18
        goto L8
    L13:
        r3 = r4.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r4.close();
        r0.release();
        return r2;
    L18:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveSubscriptionTasksDao
    public List<String> updateIsDeleteBySourceTaskIds(List<String> r3, boolean r4, long r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        List<String> r7 = ProactiveSubscriptionTasksDao.DefaultImpls.updateIsDeleteBySourceTaskIds(this, r6, r4, r5);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r7;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveSubscriptionTasksDao
    public List<String> updateIsDeleteBySubscriptionId(String r2, boolean r3, long r4) {
        this.__db.beginTransaction();
        List<String> r5 = ProactiveSubscriptionTasksDao.DefaultImpls.updateIsDeleteBySubscriptionId(this, r2, r3, r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveSubscriptionTasksDao
    public int updateIsDeleteByTaskIds(List<String> r5, boolean r6, long r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE ProactiveSubscriptionTasks SET is_delete = ");
        r0.append("?");
        r0.append(", updated = ");
        r0.append("?");
        r0.append(" WHERE task_id IN (");
        StringUtil.appendPlaceholders(r0, r8.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        r2.bindLong(1, r6 ? 1 : 0);
        r2.bindLong(2, r7);
        int r9 = 3;
        Iterator r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L8;
        r2.bindNull(r9);
    L9:
        r9 = r9 + 1;
        goto L4
    L8:
        r2.bindString(r9, r11);
        goto L9
    L10:
        this.__db.beginTransaction();
        int r12 = r2.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        return r12;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveSubscriptionTasksDao
    public void upsert(fc r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfProactiveSubscriptionTaskEntity.insert(r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
