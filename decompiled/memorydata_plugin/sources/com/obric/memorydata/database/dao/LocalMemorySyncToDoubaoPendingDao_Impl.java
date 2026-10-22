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
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.cj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class LocalMemorySyncToDoubaoPendingDao_Impl implements LocalMemorySyncToDoubaoPendingDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<cj> __deletionAdapterOfLocalMemorySyncToDoubaoPendingEntity;
    private final EntityInsertionAdapter<cj> __insertionAdapterOfLocalMemorySyncToDoubaoPendingEntity;
    private final EntityDeletionOrUpdateAdapter<cj> __updateAdapterOfLocalMemorySyncToDoubaoPendingEntity;

    public LocalMemorySyncToDoubaoPendingDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfLocalMemorySyncToDoubaoPendingEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfLocalMemorySyncToDoubaoPendingEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfLocalMemorySyncToDoubaoPendingEntity = new AnonymousClass3(this, r2);
    }

    private cj __entityCursorConverter_comObricMemorydataDatabaseEntityLocalMemorySyncToDoubaoPendingEntity(Cursor r24) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r24, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "type");
        int r3 = CursorUtil.getColumnIndex(r0, "entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r5 = CursorUtil.getColumnIndex(r0, Params.CONTENT);
        int r6 = CursorUtil.getColumnIndex(r0, "alreadySyncDoubaoUid");
        int r7 = CursorUtil.getColumnIndex(r0, "syncToDoubaoUid");
        long r8 = 0;
        if (r1 != (-1)) goto L5;
        long r14 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        int r9 = 0;
    L9:
        int r16 = r9;
        if (r3 != (-1)) goto L13;
    L11:
        String r17 = null;
    L16:
        if (r4 == (-1)) goto L19;
        r8 = r0.getLong(r4);
    L19:
        long r18 = r8;
        if (r5 != (-1)) goto L23;
    L21:
        String r20 = null;
    L26:
        if (r6 != (-1)) goto L29;
    L27:
        String r21 = null;
    L32:
        if (r7 != (-1)) goto L35;
    L33:
        String r22 = null;
    L39:
        return new cj(r14, r16, r17, r18, r20, r21, r22);
    L35:
        if (r0.isNull(r7) == true) goto L33;
        r22 = r0.getString(r7);
        goto L39
    L29:
        if (r0.isNull(r6) == true) goto L27;
        r21 = r0.getString(r6);
        goto L32
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r20 = r0.getString(r5);
        goto L26
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r17 = r0.getString(r3);
        goto L16
    L8:
        r9 = r0.getInt(r2);
        goto L9
    L5:
        r14 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<cj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfLocalMemorySyncToDoubaoPendingEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<cj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfLocalMemorySyncToDoubaoPendingEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(cj r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfLocalMemorySyncToDoubaoPendingEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(cj r3) {
        return delete2((cj) ZeusTransformUtils.preCheckCast(r3, cj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return LocalMemorySyncToDoubaoPendingDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.LocalMemorySyncToDoubaoPendingDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return LocalMemorySyncToDoubaoPendingDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(cj r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfLocalMemorySyncToDoubaoPendingEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(cj r3) {
        return insert2((cj) ZeusTransformUtils.preCheckCast(r3, cj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<cj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfLocalMemorySyncToDoubaoPendingEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cj> queryAll() {
        return LocalMemorySyncToDoubaoPendingDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return LocalMemorySyncToDoubaoPendingDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cj queryById(long r1) {
        return LocalMemorySyncToDoubaoPendingDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cj queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cj> queryByIds(List<Long> r3) {
        return LocalMemorySyncToDoubaoPendingDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.LocalMemorySyncToDoubaoPendingDao
    public List<cj> queryByTypeAndEntityId(int r23, String r24) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM LocalMemorySyncToDoubaoPending WHERE type = ? AND entityId = ? LIMIT 1", 2);
        r2.bindLong(1, r23);
        if (r24 != null) goto L5;
        r2.bindNull(2);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L30
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "entityId");     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, Params.CONTENT);     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "alreadySyncDoubaoUid");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "syncToDoubaoUid");     // Catch: Throwable -> L30
        ArrayList r10 = new ArrayList(r1.getCount());     // Catch: Throwable -> L30
    L8:
        if (r1.moveToNext() == false) goto L28;
        long r13 = r1.getLong(r0);     // Catch: Throwable -> L30
        int r15 = r1.getInt(r4);     // Catch: Throwable -> L30
        if (r1.isNull(r5) == false) goto L13;
        String r16 = null;
    L14:
        long r17 = r1.getLong(r6);     // Catch: Throwable -> L30
        if (r1.isNull(r7) == false) goto L17;
        String r19 = null;
    L19:
        if (r1.isNull(r8) == false) goto L21;
        String r20 = null;
    L23:
        if (r1.isNull(r9) == false) goto L25;
        String r21 = null;
    L26:
        r10.add(new cj(r13, r15, r16, r17, r19, r20, r21));     // Catch: Throwable -> L30
        goto L8
    L25:
        r21 = r1.getString(r9);     // Catch: Throwable -> L30
        goto L26
    L21:
        r20 = r1.getString(r8);     // Catch: Throwable -> L30
        goto L23
    L17:
        r19 = r1.getString(r7);     // Catch: Throwable -> L30
        goto L19
    L13:
        r16 = r1.getString(r5);     // Catch: Throwable -> L30
        goto L14
    L28:
        r1.close();
        r2.release();
        return r10;
    L30:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(2, r24);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.LocalMemorySyncToDoubaoPendingDao
    public List<cj> queryByTypeAndEntityIds(int r23, List<String> r24) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM LocalMemorySyncToDoubaoPending WHERE type = ");
        r3.append("?");
        r3.append(" AND entityId IN (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(")");
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire(r3.toString(), r4 + 1);
        r5.bindLong(1, r23);
        Iterator r2 = r1.iterator();
        int r6 = 2;
    L4:
        if (r2.hasNext() == false) goto L10;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
        r5.bindNull(r6);
    L9:
        r6 = r6 + 1;
        goto L4
    L8:
        r5.bindString(r6, r7);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r8 = DBUtil.query(this.__db, r5, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "type");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "entityId");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "timestamp");     // Catch: Throwable -> L34
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, Params.CONTENT);     // Catch: Throwable -> L34
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "alreadySyncDoubaoUid");     // Catch: Throwable -> L34
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, "syncToDoubaoUid");     // Catch: Throwable -> L34
        ArrayList r15 = new ArrayList(r8.getCount());     // Catch: Throwable -> L34
    L12:
        if (r8.moveToNext() == false) goto L32;
        long r16 = r8.getLong(r0);     // Catch: Throwable -> L34
        int r17 = r8.getInt(r9);     // Catch: Throwable -> L34
        if (r8.isNull(r10) == false) goto L17;
        String r18 = null;
    L18:
        long r19 = r8.getLong(r11);     // Catch: Throwable -> L34
        if (r8.isNull(r12) == false) goto L21;
        String r110 = null;
    L23:
        if (r8.isNull(r13) == false) goto L25;
        String r20 = null;
    L27:
        if (r8.isNull(r14) == false) goto L29;
        String r21 = null;
    L30:
        r15.add(new cj(r16, r17, r18, r19, r110, r20, r21));     // Catch: Throwable -> L34
        goto L12
    L29:
        r21 = r8.getString(r14);     // Catch: Throwable -> L34
        goto L30
    L25:
        r20 = r8.getString(r13);     // Catch: Throwable -> L34
        goto L27
    L21:
        r110 = r8.getString(r12);     // Catch: Throwable -> L34
        goto L23
    L17:
        r18 = r8.getString(r10);     // Catch: Throwable -> L34
        goto L18
    L32:
        r8.close();
        r5.release();
        return r15;
    L34:
        th = move-exception;
        r8.close();
        r5.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cj queryByUUID(String r1) {
        return LocalMemorySyncToDoubaoPendingDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cj queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.LocalMemorySyncToDoubaoPendingDao
    public List<cj> queryNeedToSyncPendingEntity(int r23, long r24, String r26) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM LocalMemorySyncToDoubaoPending WHERE timestamp > ? AND type = ? AND (syncToDoubaoUid IS NULL OR syncToDoubaoUid NOT LIKE '%' || ? || '%') ORDER BY timestamp ASC LIMIT 20", 3);
        r2.bindLong(1, r24);
        r2.bindLong(2, r23);
        if (r26 != null) goto L5;
        r2.bindNull(3);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L30
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "entityId");     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, Params.CONTENT);     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "alreadySyncDoubaoUid");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "syncToDoubaoUid");     // Catch: Throwable -> L30
        ArrayList r10 = new ArrayList(r1.getCount());     // Catch: Throwable -> L30
    L8:
        if (r1.moveToNext() == false) goto L28;
        long r13 = r1.getLong(r0);     // Catch: Throwable -> L30
        int r15 = r1.getInt(r4);     // Catch: Throwable -> L30
        if (r1.isNull(r5) == false) goto L13;
        String r16 = null;
    L14:
        long r17 = r1.getLong(r6);     // Catch: Throwable -> L30
        if (r1.isNull(r7) == false) goto L17;
        String r19 = null;
    L19:
        if (r1.isNull(r8) == false) goto L21;
        String r20 = null;
    L23:
        if (r1.isNull(r9) == false) goto L25;
        String r21 = null;
    L26:
        r10.add(new cj(r13, r15, r16, r17, r19, r20, r21));     // Catch: Throwable -> L30
        goto L8
    L25:
        r21 = r1.getString(r9);     // Catch: Throwable -> L30
        goto L26
    L21:
        r20 = r1.getString(r8);     // Catch: Throwable -> L30
        goto L23
    L17:
        r19 = r1.getString(r7);     // Catch: Throwable -> L30
        goto L19
    L13:
        r16 = r1.getString(r5);     // Catch: Throwable -> L30
        goto L14
    L28:
        r1.close();
        r2.release();
        return r10;
    L30:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(3, r26);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cj queryOne() {
        return LocalMemorySyncToDoubaoPendingDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cj queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cj> queryWithLimitAndOffset(int r1, int r2) {
        return LocalMemorySyncToDoubaoPendingDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cj> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityLocalMemorySyncToDoubaoPendingEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(cj r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfLocalMemorySyncToDoubaoPendingEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(cj r3) {
        return update2((cj) ZeusTransformUtils.preCheckCast(r3, cj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<cj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfLocalMemorySyncToDoubaoPendingEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
