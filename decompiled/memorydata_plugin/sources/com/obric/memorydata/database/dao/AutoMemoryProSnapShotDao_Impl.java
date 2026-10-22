package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.aa;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoMemoryProSnapShotDao_Impl implements AutoMemoryProSnapShotDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<aa> __deletionAdapterOfAutoMemoryProSnapShotEntity;
    private final EntityInsertionAdapter<aa> __insertionAdapterOfAutoMemoryProSnapShotEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteBeforeSnapshotTime;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByAutoMemoryProId;
    private final EntityDeletionOrUpdateAdapter<aa> __updateAdapterOfAutoMemoryProSnapShotEntity;

    public AutoMemoryProSnapShotDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAutoMemoryProSnapShotEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfAutoMemoryProSnapShotEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfAutoMemoryProSnapShotEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteAll = new AnonymousClass4(this, r2);
        this.__preparedStmtOfDeleteByAutoMemoryProId = new AnonymousClass5(this, r2);
        this.__preparedStmtOfDeleteBeforeSnapshotTime = new AnonymousClass6(this, r2);
    }

    private aa __entityCursorConverter_comObricMemorydataDatabaseEntityAutoMemoryProSnapShotEntity(Cursor r23) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r23, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_id");
        int r3 = CursorUtil.getColumnIndex(r0, "entity_id");
        int r4 = CursorUtil.getColumnIndex(r0, "version");
        int r5 = CursorUtil.getColumnIndex(r0, "snapshot_json");
        int r6 = CursorUtil.getColumnIndex(r0, "snapshot_time");
        long r7 = 0;
        if (r1 != (-1)) goto L5;
        long r13 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r15 = 0;
    L9:
        String r8 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r17 = null;
    L16:
        if (r4 != (-1)) goto L18;
        int r9 = 0;
    L19:
        int r18 = r9;
        if (r5 != (-1)) goto L23;
    L21:
        String r19 = r8;
        if (r6 == (-1)) goto L30;
        r7 = r0.getLong(r6);
    L30:
        return new aa(r13, r15, r17, r18, r19, r7);
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r8 = r0.getString(r5);
        goto L21
    L18:
        r9 = r0.getInt(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r17 = r0.getString(r3);
        goto L16
    L8:
        r15 = r0.getLong(r2);
        goto L9
    L5:
        r13 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<aa> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAutoMemoryProSnapShotEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao, com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<aa> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAutoMemoryProSnapShotEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao
    public int countVersionWindowByEntityId(String r4, int r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT COUNT(*) FROM AutoMemoryProSnapShot\n        WHERE entity_id = ?\n            AND version <= ?\n        ", 2);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r5);
        this.__db.assertNotSuspendingTransaction();
        int r6 = 0;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L12:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L8:
        if (r3.moveToFirst() == false) goto L10;
        r6 = r3.getInt(0);     // Catch: Throwable -> L12
    L10:
        r3.close();
        r0.release();
        return r6;
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(aa r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAutoMemoryProSnapShotEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(aa r3) {
        return delete2((aa) ZeusTransformUtils.preCheckCast(r3, aa.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao, com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao
    public int deleteBeforeSnapshotTime(long r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteBeforeSnapshotTime.acquire();
        r0.bindLong(1, r3);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteBeforeSnapshotTime.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteBeforeSnapshotTime.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao
    public int deleteByAutoMemoryProId(long r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByAutoMemoryProId.acquire();
        r0.bindLong(1, r3);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByAutoMemoryProId.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByAutoMemoryProId.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao
    public int deleteByAutoMemoryProIds(List<Long> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM AutoMemoryProSnapShot WHERE auto_memory_pro_id IN (");
        StringUtil.appendPlaceholders(r0, r8.size());
        r0.append(")");
        SupportSQLiteStatement r1 = this.__db.compileStatement(r0.toString());
        Iterator r9 = r8.iterator();
        int r3 = 1;
    L4:
        if (r9.hasNext() == false) goto L6;
        r1.bindLong(r3, ((Long) ZeusTransformUtils.preCheckCast(r9.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r3 = r3 + 1;
        goto L4
    L6:
        this.__db.beginTransaction();
        int r10 = r1.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        return r10;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao
    public int deleteByEntityIds(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM AutoMemoryProSnapShot WHERE entity_id IN (");
        StringUtil.appendPlaceholders(r0, r7.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        Iterator r8 = r7.iterator();
        int r3 = 1;
    L4:
        if (r8.hasNext() == false) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r2.bindNull(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r2.bindString(r3, r4);
        goto L9
    L10:
        this.__db.beginTransaction();
        int r9 = r2.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        return r9;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return AutoMemoryProSnapShotDao.DefaultImpls.getTableName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao
    public long insert(aa r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAutoMemoryProSnapShotEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(aa r3) {
        return insert((aa) ZeusTransformUtils.preCheckCast(r3, aa.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao, com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<aa> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAutoMemoryProSnapShotEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aa> queryAll() {
        return AutoMemoryProSnapShotDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return AutoMemoryProSnapShotDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao
    public List<aa> queryByAutoMemoryProId(long r22) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM AutoMemoryProSnapShot WHERE auto_memory_pro_id = ? ORDER BY version DESC", 1);
        r1.bindLong(1, r22);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L18
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "auto_memory_pro_id");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "entity_id");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "version");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "snapshot_json");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "snapshot_time");     // Catch: Throwable -> L18
        ArrayList r9 = new ArrayList(r2.getCount());     // Catch: Throwable -> L18
    L4:
        if (r2.moveToNext() == false) goto L16;
        long r12 = r2.getLong(r0);     // Catch: Throwable -> L18
        long r14 = r2.getLong(r4);     // Catch: Throwable -> L18
        if (r2.isNull(r5) == false) goto L9;
        String r16 = null;
    L10:
        int r17 = r2.getInt(r6);     // Catch: Throwable -> L18
        if (r2.isNull(r7) == false) goto L13;
        String r18 = null;
    L14:
        r9.add(new aa(r12, r14, r16, r17, r18, r2.getLong(r8)));     // Catch: Throwable -> L18
        goto L4
    L13:
        r18 = r2.getString(r7);     // Catch: Throwable -> L18
        goto L14
    L9:
        r16 = r2.getString(r5);     // Catch: Throwable -> L18
        goto L10
    L16:
        r2.close();
        r1.release();
        return r9;
    L18:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao
    public List<aa> queryByEntityId(String r22) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM AutoMemoryProSnapShot WHERE entity_id = ? ORDER BY version DESC", 1);
        if (r22 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L22
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "auto_memory_pro_id");     // Catch: Throwable -> L22
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "entity_id");     // Catch: Throwable -> L22
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "version");     // Catch: Throwable -> L22
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "snapshot_json");     // Catch: Throwable -> L22
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "snapshot_time");     // Catch: Throwable -> L22
        ArrayList r9 = new ArrayList(r1.getCount());     // Catch: Throwable -> L22
    L8:
        if (r1.moveToNext() == false) goto L20;
        long r12 = r1.getLong(r0);     // Catch: Throwable -> L22
        long r14 = r1.getLong(r4);     // Catch: Throwable -> L22
        if (r1.isNull(r5) == false) goto L13;
        String r16 = null;
    L14:
        int r17 = r1.getInt(r6);     // Catch: Throwable -> L22
        if (r1.isNull(r7) == false) goto L17;
        String r18 = null;
    L18:
        r9.add(new aa(r12, r14, r16, r17, r18, r1.getLong(r8)));     // Catch: Throwable -> L22
        goto L8
    L17:
        r18 = r1.getString(r7);     // Catch: Throwable -> L22
        goto L18
    L13:
        r16 = r1.getString(r5);     // Catch: Throwable -> L22
        goto L14
    L20:
        r1.close();
        r2.release();
        return r9;
    L22:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r22);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public aa queryById(long r1) {
        return AutoMemoryProSnapShotDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ aa queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aa> queryByIds(List<Long> r3) {
        return AutoMemoryProSnapShotDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public aa queryByUUID(String r1) {
        return AutoMemoryProSnapShotDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ aa queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao
    public List<String> queryDistinctSnapshotLocalDays(int r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT DISTINCT strftime('%Y-%m-%d', snapshot_time / 1000, 'unixepoch', 'localtime')\n        FROM AutoMemoryProSnapShot\n        ORDER BY snapshot_time DESC\n        LIMIT ?\n        ", 1);
        r0.bindLong(1, r5);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r4.getCount());     // Catch: Throwable -> L14
    L4:
        if (r4.moveToNext() == false) goto L12;
        if (r4.isNull(0) == false) goto L9;
        String r3 = null;
    L10:
        r2.add(r3);     // Catch: Throwable -> L14
        goto L4
    L9:
        r3 = r4.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r4.close();
        r0.release();
        return r2;
    L14:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao
    public aa queryLatestByAutoMemoryProId(long r21) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM AutoMemoryProSnapShot WHERE auto_memory_pro_id = ? ORDER BY version DESC LIMIT 1", 1);
        r1.bindLong(1, r21);
        this.__db.assertNotSuspendingTransaction();
        aa r3 = null;
        String r4 = null;
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L16
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "auto_memory_pro_id");     // Catch: Throwable -> L16
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "entity_id");     // Catch: Throwable -> L16
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "version");     // Catch: Throwable -> L16
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "snapshot_json");     // Catch: Throwable -> L16
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "snapshot_time");     // Catch: Throwable -> L16
        if (r2.moveToFirst() == false) goto L14;
        long r11 = r2.getLong(r0);     // Catch: Throwable -> L16
        long r13 = r2.getLong(r5);     // Catch: Throwable -> L16
        if (r2.isNull(r6) == false) goto L8;
        String r15 = null;
    L9:
        int r16 = r2.getInt(r7);     // Catch: Throwable -> L16
        if (r2.isNull(r8) == true) goto L13;
        r4 = r2.getString(r8);     // Catch: Throwable -> L16
    L13:
        r3 = new aa(r11, r13, r15, r16, r4, r2.getLong(r9));     // Catch: Throwable -> L16
        goto L14
    L8:
        r15 = r2.getString(r6);     // Catch: Throwable -> L16
    L14:
        r2.close();
        r1.release();
        return r3;
    L16:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public aa queryOne() {
        return AutoMemoryProSnapShotDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ aa queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao
    public List<aa> queryPageBeforeCursor(long r20, long r22, long r24, long r26, int r28) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("\n        SELECT * FROM AutoMemoryProSnapShot\n        WHERE snapshot_time >= ?\n            AND snapshot_time < ?\n            AND (snapshot_time < ? OR (snapshot_time = ? AND id < ?))\n        ORDER BY snapshot_time DESC, id DESC\n        LIMIT ?\n        ", 6);
        r3.bindLong(1, r20);
        r3.bindLong(2, r22);
        r3.bindLong(3, r24);
        r3.bindLong(4, r24);
        r3.bindLong(5, r26);
        r3.bindLong(6, r28);
        this.__db.assertNotSuspendingTransaction();
        String r2 = null;
        Cursor r1 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L18
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "auto_memory_pro_id");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "entity_id");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "version");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "snapshot_json");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "snapshot_time");     // Catch: Throwable -> L18
        ArrayList r9 = new ArrayList(r1.getCount());     // Catch: Throwable -> L18
    L4:
        if (r1.moveToNext() == false) goto L16;
        long r10 = r1.getLong(r0);     // Catch: Throwable -> L18
        long r12 = r1.getLong(r4);     // Catch: Throwable -> L18
        if (r1.isNull(r5) == false) goto L9;
        String r14 = r2;
    L10:
        int r15 = r1.getInt(r6);     // Catch: Throwable -> L18
        if (r1.isNull(r7) == false) goto L13;
        String r16 = r2;
    L14:
        r9.add(new aa(r10, r12, r14, r15, r16, r1.getLong(r8)));     // Catch: Throwable -> L18
        r2 = null;
        goto L4
    L13:
        r16 = r1.getString(r7);     // Catch: Throwable -> L18
        goto L14
    L9:
        r14 = r1.getString(r5);     // Catch: Throwable -> L18
        goto L10
    L16:
        r1.close();
        r3.release();
        return r9;
    L18:
        th = move-exception;
        r1.close();
        r3.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao
    public List<aa> queryVersionWindowByEntityId(String r22, int r23, int r24) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("\n        SELECT * FROM AutoMemoryProSnapShot\n        WHERE entity_id = ?\n            AND version <= ?\n        ORDER BY version DESC\n        LIMIT ?\n        ", 3);
        if (r22 != null) goto L5;
        r2.bindNull(1);
    L6:
        r2.bindLong(2, r23);
        r2.bindLong(3, r24);
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L22
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "auto_memory_pro_id");     // Catch: Throwable -> L22
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "entity_id");     // Catch: Throwable -> L22
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "version");     // Catch: Throwable -> L22
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "snapshot_json");     // Catch: Throwable -> L22
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "snapshot_time");     // Catch: Throwable -> L22
        ArrayList r9 = new ArrayList(r1.getCount());     // Catch: Throwable -> L22
    L8:
        if (r1.moveToNext() == false) goto L20;
        long r12 = r1.getLong(r0);     // Catch: Throwable -> L22
        long r14 = r1.getLong(r4);     // Catch: Throwable -> L22
        if (r1.isNull(r5) == false) goto L13;
        String r16 = null;
    L14:
        int r17 = r1.getInt(r6);     // Catch: Throwable -> L22
        if (r1.isNull(r7) == false) goto L17;
        String r18 = null;
    L18:
        r9.add(new aa(r12, r14, r16, r17, r18, r1.getLong(r8)));     // Catch: Throwable -> L22
        goto L8
    L17:
        r18 = r1.getString(r7);     // Catch: Throwable -> L22
        goto L18
    L13:
        r16 = r1.getString(r5);     // Catch: Throwable -> L22
        goto L14
    L20:
        r1.close();
        r2.release();
        return r9;
    L22:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r22);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aa> queryWithLimitAndOffset(int r1, int r2) {
        return AutoMemoryProSnapShotDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aa> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityAutoMemoryProSnapShotEntity(r6));     // Catch: Throwable -> L10
        goto L5
    L8:
        r6.close();
        return r0;
    L10:
        th = move-exception;
        r6.close();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public Cursor rawQueryForCursor(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        return this.__db.query(r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int rawQueryForInt(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        int r0 = 0;
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L8:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L6;
        r0 = r2.getInt(0);     // Catch: Throwable -> L8
    L6:
        r2.close();
        return r0;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public long rawQueryForLong(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L10:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L7;
        long r0 = r2.getLong(0);     // Catch: Throwable -> L10
    L8:
        r2.close();
        return r0;
    L7:
        r0 = 0;
        goto L8
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public int update2(aa r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAutoMemoryProSnapShotEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(aa r3) {
        return update2((aa) ZeusTransformUtils.preCheckCast(r3, aa.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<aa> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAutoMemoryProSnapShotEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
