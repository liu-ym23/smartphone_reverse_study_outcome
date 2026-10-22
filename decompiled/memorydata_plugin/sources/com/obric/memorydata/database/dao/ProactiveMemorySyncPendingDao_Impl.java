package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.ew;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ProactiveMemorySyncPendingDao_Impl implements ProactiveMemorySyncPendingDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ew> __deletionAdapterOfProactiveMemorySyncPendingEntity;
    private final EntityInsertionAdapter<ew> __insertionAdapterOfProactiveMemorySyncPendingEntity;
    private final EntityDeletionOrUpdateAdapter<ew> __updateAdapterOfProactiveMemorySyncPendingEntity;

    public ProactiveMemorySyncPendingDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfProactiveMemorySyncPendingEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfProactiveMemorySyncPendingEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfProactiveMemorySyncPendingEntity = new AnonymousClass3(this, r2);
    }

    private ew __entityCursorConverter_comObricMemorydataDatabaseEntityProactiveMemorySyncPendingEntity(Cursor r20) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r20, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r3 = CursorUtil.getColumnIndex(r0, "type");
        int r4 = CursorUtil.getColumnIndex(r0, "entityId");
        int r5 = CursorUtil.getColumnIndex(r0, "status");
        long r6 = 0;
        if (r1 != (-1)) goto L5;
        long r12 = 0;
    L6:
        if (r2 == (-1)) goto L9;
        r6 = r0.getLong(r2);
    L9:
        long r14 = r6;
        if (r3 != (-1)) goto L12;
        int r16 = 0;
    L13:
        String r7 = null;
        if (r4 != (-1)) goto L17;
    L15:
        String r17 = r7;
        if (r5 != (-1)) goto L22;
        int r18 = 0;
    L24:
        return new ew(r12, r14, r16, r17, r18);
    L22:
        r18 = r0.getInt(r5);
        goto L24
    L17:
        if (r0.isNull(r4) == true) goto L15;
        r7 = r0.getString(r4);
        goto L15
    L12:
        r16 = r0.getInt(r3);
        goto L13
    L5:
        r12 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ew> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfProactiveMemorySyncPendingEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ew> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfProactiveMemorySyncPendingEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(ew r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfProactiveMemorySyncPendingEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(ew r3) {
        return delete2((ew) ZeusTransformUtils.preCheckCast(r3, ew.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ProactiveMemorySyncPendingDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.ProactiveMemorySyncPendingDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ProactiveMemorySyncPendingDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(ew r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfProactiveMemorySyncPendingEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(ew r3) {
        return insert2((ew) ZeusTransformUtils.preCheckCast(r3, ew.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ew> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfProactiveMemorySyncPendingEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ew> queryAll() {
        return ProactiveMemorySyncPendingDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ProactiveMemorySyncPendingDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ew queryById(long r1) {
        return ProactiveMemorySyncPendingDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ew queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ew> queryByIds(List<Long> r3) {
        return ProactiveMemorySyncPendingDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.ProactiveMemorySyncPendingDao
    public List<ew> queryByTypeAndEntityId(int r19, String r20) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveMemorySyncPending WHERE type = ? AND entityId = ? LIMIT 1", 2);
        r2.bindLong(1, r19);
        if (r20 != null) goto L5;
        r2.bindNull(2);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L18
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "entityId");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "status");     // Catch: Throwable -> L18
        ArrayList r8 = new ArrayList(r1.getCount());     // Catch: Throwable -> L18
    L8:
        if (r1.moveToNext() == false) goto L16;
        long r11 = r1.getLong(r0);     // Catch: Throwable -> L18
        long r13 = r1.getLong(r4);     // Catch: Throwable -> L18
        int r15 = r1.getInt(r5);     // Catch: Throwable -> L18
        if (r1.isNull(r6) == false) goto L13;
        String r16 = null;
    L14:
        r8.add(new ew(r11, r13, r15, r16, r1.getInt(r7)));     // Catch: Throwable -> L18
        goto L8
    L13:
        r16 = r1.getString(r6);     // Catch: Throwable -> L18
        goto L14
    L16:
        r1.close();
        r2.release();
        return r8;
    L18:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(2, r20);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.ProactiveMemorySyncPendingDao
    public List<ew> queryByTypeAndEntityIds(List<String> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT id, timestamp, type, entityId, 0 as status FROM ProactiveMemorySyncPending WHERE entityId IN (");
        int r2 = r15.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r16 = r15.iterator();
        int r4 = 1;
    L4:
        if (r16.hasNext() == false) goto L10;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
        r1.bindNull(r4);
    L9:
        r4 = r4 + 1;
        goto L4
    L8:
        r1.bindString(r4, r5);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r13 = DBUtil.query(this.__db, r1, false, null);
        ArrayList r3 = new ArrayList(r13.getCount());     // Catch: Throwable -> L22
    L12:
        if (r13.moveToNext() == false) goto L20;
        long r6 = r13.getLong(0);     // Catch: Throwable -> L22
        long r8 = r13.getLong(1);     // Catch: Throwable -> L22
        int r10 = r13.getInt(2);     // Catch: Throwable -> L22
        if (r13.isNull(3) == false) goto L17;
        String r11 = null;
    L18:
        r3.add(new ew(r6, r8, r10, r11, r13.getInt(4)));     // Catch: Throwable -> L22
        goto L12
    L17:
        r11 = r13.getString(3);     // Catch: Throwable -> L22
        goto L18
    L20:
        r13.close();
        r1.release();
        return r3;
    L22:
        th = move-exception;
        r13.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ProactiveMemorySyncPendingDao
    public List<ew> queryByTypeAndStatus(int r19, int r20) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ProactiveMemorySyncPending WHERE type = ? AND status = ?", 2);
        r1.bindLong(1, r19);
        r1.bindLong(2, r20);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L14
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L14
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L14
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "entityId");     // Catch: Throwable -> L14
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "status");     // Catch: Throwable -> L14
        ArrayList r8 = new ArrayList(r2.getCount());     // Catch: Throwable -> L14
    L4:
        if (r2.moveToNext() == false) goto L12;
        long r11 = r2.getLong(r0);     // Catch: Throwable -> L14
        long r13 = r2.getLong(r4);     // Catch: Throwable -> L14
        int r15 = r2.getInt(r5);     // Catch: Throwable -> L14
        if (r2.isNull(r6) == false) goto L9;
        String r16 = null;
    L10:
        r8.add(new ew(r11, r13, r15, r16, r2.getInt(r7)));     // Catch: Throwable -> L14
        goto L4
    L9:
        r16 = r2.getString(r6);     // Catch: Throwable -> L14
        goto L10
    L12:
        r2.close();
        r1.release();
        return r8;
    L14:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ew queryByUUID(String r1) {
        return ProactiveMemorySyncPendingDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ew queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ew queryOne() {
        return ProactiveMemorySyncPendingDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ew queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ew> queryWithLimitAndOffset(int r1, int r2) {
        return ProactiveMemorySyncPendingDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ew> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityProactiveMemorySyncPendingEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(ew r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfProactiveMemorySyncPendingEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(ew r3) {
        return update2((ew) ZeusTransformUtils.preCheckCast(r3, ew.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ew> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfProactiveMemorySyncPendingEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
