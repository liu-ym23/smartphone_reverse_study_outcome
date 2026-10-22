package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.cp;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryEntityCorrelationDao_Impl implements MemoryEntityCorrelationDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<cp> __deletionAdapterOfMemoryEntityCorrelationEntity;
    private final EntityInsertionAdapter<cp> __insertionAdapterOfMemoryEntityCorrelationEntity;
    private final EntityInsertionAdapter<cp> __insertionAdapterOfMemoryEntityCorrelationEntity_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteInvalidRelations;
    private final SharedSQLiteStatement __preparedStmtOfDeletedRelations;
    private final EntityDeletionOrUpdateAdapter<cp> __updateAdapterOfMemoryEntityCorrelationEntity;

    public MemoryEntityCorrelationDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryEntityCorrelationEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfMemoryEntityCorrelationEntity_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfMemoryEntityCorrelationEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfMemoryEntityCorrelationEntity = new AnonymousClass4(this, r2);
        this.__preparedStmtOfDeleteInvalidRelations = new AnonymousClass5(this, r2);
        this.__preparedStmtOfDeletedRelations = new AnonymousClass6(this, r2);
    }

    private cp __entityCursorConverter_comObricMemorydataDatabaseEntityMemoryEntityCorrelationEntity(Cursor r13) {
        Cursor r12 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r13, Cursor.class, "com.obric.memorydata.plugin");
        int r14 = CursorUtil.getColumnIndex(r12, "sourceEntityId");
        int r0 = CursorUtil.getColumnIndex(r12, "targetEntityId");
        int r1 = CursorUtil.getColumnIndex(r12, "targetMemoryType");
        int r2 = CursorUtil.getColumnIndex(r12, "targetExpireTime");
        int r3 = CursorUtil.getColumnIndex(r12, "score");
        Long r5 = null;
        if (r14 != (-1)) goto L6;
    L4:
        String r7 = null;
    L9:
        if (r0 != (-1)) goto L12;
    L10:
        String r8 = null;
    L15:
        if (r1 != (-1)) goto L17;
        int r15 = 0;
    L18:
        int r9 = r15;
        if (r2 != (-1)) goto L22;
    L20:
        Long r10 = r5;
        if (r3 != (-1)) goto L27;
        float r16 = 0.0f;
    L29:
        return new cp(r7, r8, r9, r10, r16);
    L27:
        r16 = r12.getFloat(r3);
        goto L29
    L22:
        if (r12.isNull(r2) == true) goto L20;
        r5 = Long.valueOf(r12.getLong(r2));
        goto L20
    L17:
        r15 = r12.getInt(r1);
        goto L18
    L12:
        if (r12.isNull(r0) == true) goto L10;
        r8 = r12.getString(r0);
        goto L15
    L6:
        if (r12.isNull(r14) == true) goto L4;
        r7 = r12.getString(r14);
        goto L9
    }

    static /* synthetic */ SharedSQLiteStatement access$000(MemoryEntityCorrelationDao_Impl r0) {
        return r0.__preparedStmtOfDeleteInvalidRelations;
    }

    static /* synthetic */ RoomDatabase access$100(MemoryEntityCorrelationDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<cp> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMemoryEntityCorrelationEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<cp> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMemoryEntityCorrelationEntity_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(cp r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMemoryEntityCorrelationEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(cp r3) {
        return delete2((cp) ZeusTransformUtils.preCheckCast(r3, cp.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return MemoryEntityCorrelationDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityCorrelationDao
    public Object deleteInvalidRelations(final String r3, final long r4, Continuation<? super Unit> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return CoroutinesRoom.execute(this.__db, true, new AnonymousClass7(this, r3, r4), r7);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityCorrelationDao
    public void deletedRelations(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeletedRelations.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r3 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfDeletedRelations.release(r0);
        return;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeletedRelations.release(r0);
        throw th;
    L9:
        r0.bindString(2, r3);
        goto L10
    L5:
        r0.bindString(1, r3);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityCorrelationDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MemoryEntityCorrelationDao.DefaultImpls.getTableName(this);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityCorrelationDao
    public i<List<EpisodicMemoryEntity>> getValidRelatedEntitiesWithOrder(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT e.* FROM ShortMemory e\n        INNER JOIN RawMemoryEntityCorrelation r\n            ON e.entityId = r.targetEntityId\n        WHERE r.sourceEntityId = ?\n        ORDER BY e.modifyTime DESC\n        LIMIT 20\n    ", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ShortMemory", "RawMemoryEntityCorrelation"}, new AnonymousClass8(this, r0));
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityCorrelationDao
    public List<cp> getValidRelation(String r13, long r14) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntityCorrelation WHERE sourceEntityId = ? AND (targetExpireTime IS NULL OR targetExpireTime > ?)", 2);
        if (r13 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r14);
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r0, false, null);
        int r15 = CursorUtil.getColumnIndexOrThrow(r12, "sourceEntityId");     // Catch: Throwable -> L26
        int r16 = CursorUtil.getColumnIndexOrThrow(r12, "targetEntityId");     // Catch: Throwable -> L26
        int r1 = CursorUtil.getColumnIndexOrThrow(r12, "targetMemoryType");     // Catch: Throwable -> L26
        int r2 = CursorUtil.getColumnIndexOrThrow(r12, "targetExpireTime");     // Catch: Throwable -> L26
        int r3 = CursorUtil.getColumnIndexOrThrow(r12, "score");     // Catch: Throwable -> L26
        ArrayList r4 = new ArrayList(r12.getCount());     // Catch: Throwable -> L26
    L8:
        if (r12.moveToNext() == false) goto L24;
        if (r12.isNull(r15) == false) goto L13;
        String r7 = null;
    L15:
        if (r12.isNull(r16) == false) goto L17;
        String r8 = null;
    L18:
        int r9 = r12.getInt(r1);     // Catch: Throwable -> L26
        if (r12.isNull(r2) == false) goto L21;
        Long r10 = null;
    L22:
        r4.add(new cp(r7, r8, r9, r10, r12.getFloat(r3)));     // Catch: Throwable -> L26
        goto L8
    L21:
        r10 = Long.valueOf(r12.getLong(r2));     // Catch: Throwable -> L26
        goto L22
    L17:
        r8 = r12.getString(r16);     // Catch: Throwable -> L26
        goto L18
    L13:
        r7 = r12.getString(r15);     // Catch: Throwable -> L26
        goto L15
    L24:
        r12.close();
        r0.release();
        return r4;
    L26:
        th = move-exception;
        r12.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r13);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityCorrelationDao
    public boolean hasValidRelation(String r4, long r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT 1 FROM RawMemoryEntityCorrelation WHERE sourceEntityId = ? AND (targetExpireTime IS NULL OR targetExpireTime > ?))", 2);
        boolean r2 = true;
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r5);
        this.__db.assertNotSuspendingTransaction();
        boolean r6 = false;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L16:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L8:
        if (r3.moveToFirst() == false) goto L14;
        if (r3.getInt(0) != 0) goto L13;
        r2 = false;
    L13:
        r6 = r2;
    L14:
        r3.close();
        r0.release();
        return r6;
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.MemoryEntityCorrelationDao
    public long insert(cp r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryEntityCorrelationEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(cp r3) {
        return insert((cp) ZeusTransformUtils.preCheckCast(r3, cp.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityCorrelationDao, com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<cp> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryEntityCorrelationEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cp> queryAll() {
        return MemoryEntityCorrelationDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MemoryEntityCorrelationDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cp queryById(long r1) {
        return MemoryEntityCorrelationDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cp queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cp> queryByIds(List<Long> r3) {
        return MemoryEntityCorrelationDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cp queryByUUID(String r1) {
        return MemoryEntityCorrelationDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cp queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cp queryOne() {
        return MemoryEntityCorrelationDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cp queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cp> queryWithLimitAndOffset(int r1, int r2) {
        return MemoryEntityCorrelationDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cp> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityMemoryEntityCorrelationEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(cp r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMemoryEntityCorrelationEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(cp r3) {
        return update2((cp) ZeusTransformUtils.preCheckCast(r3, cp.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<cp> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMemoryEntityCorrelationEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
