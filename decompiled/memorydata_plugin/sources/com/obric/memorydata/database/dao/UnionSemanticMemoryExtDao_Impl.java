package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.ir;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UnionSemanticMemoryExtDao_Impl implements UnionSemanticMemoryExtDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ir> __deletionAdapterOfUnionSemanticMemoryExtEntity;
    private final EntityInsertionAdapter<ir> __insertionAdapterOfUnionSemanticMemoryExtEntity;
    private final EntityInsertionAdapter<ir> __insertionAdapterOfUnionSemanticMemoryExtEntity_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByMemoryId;
    private final EntityDeletionOrUpdateAdapter<ir> __updateAdapterOfUnionSemanticMemoryExtEntity;

    public UnionSemanticMemoryExtDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfUnionSemanticMemoryExtEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfUnionSemanticMemoryExtEntity_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfUnionSemanticMemoryExtEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfUnionSemanticMemoryExtEntity = new AnonymousClass4(this, r2);
        this.__preparedStmtOfDeleteByMemoryId = new AnonymousClass5(this, r2);
    }

    private ir __entityCursorConverter_comObricMemorydataDatabaseEntityUnionSemanticMemoryExtEntity(Cursor r7) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r7, Cursor.class, "com.obric.memorydata.plugin");
        int r8 = CursorUtil.getColumnIndex(r6, OaidModel.KEY_ID);
        int r0 = CursorUtil.getColumnIndex(r6, "memory_id");
        int r1 = CursorUtil.getColumnIndex(r6, "use_for_keyword");
        if (r8 != (-1)) goto L5;
        long r3 = 0;
    L6:
        String r9 = null;
        if (r0 != (-1)) goto L10;
    L13:
        boolean r2 = false;
        if (r1 == (-1)) goto L20;
        if (r6.getInt(r1) == 0) goto L20;
        r2 = true;
    L20:
        return new ir(r3, r9, r2);
    L10:
        if (r6.isNull(r0) == true) goto L13;
        r9 = r6.getString(r0);
        goto L13
    L5:
        r3 = r6.getLong(r8);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ir> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfUnionSemanticMemoryExtEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ir> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUnionSemanticMemoryExtEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(ir r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfUnionSemanticMemoryExtEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(ir r3) {
        return delete2((ir) ZeusTransformUtils.preCheckCast(r3, ir.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return UnionSemanticMemoryExtDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.UnionSemanticMemoryExtDao
    public int deleteByMemoryId(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByMemoryId.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByMemoryId.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByMemoryId.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.UnionSemanticMemoryExtDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return UnionSemanticMemoryExtDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(ir r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUnionSemanticMemoryExtEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(ir r3) {
        return insert2((ir) ZeusTransformUtils.preCheckCast(r3, ir.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ir> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfUnionSemanticMemoryExtEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.UnionSemanticMemoryExtDao
    public long insertOrReplace(ir r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUnionSemanticMemoryExtEntity_1.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ir> queryAll() {
        return UnionSemanticMemoryExtDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return UnionSemanticMemoryExtDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ir queryById(long r1) {
        return UnionSemanticMemoryExtDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ir queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ir> queryByIds(List<Long> r3) {
        return UnionSemanticMemoryExtDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.UnionSemanticMemoryExtDao
    public ir queryByMemoryId(String r9) {
        boolean r1 = true;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM UnionSemanticMemoryExt WHERE memory_id = ? LIMIT 1", 1);
        if (r9 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        ir r2 = null;
        String r3 = null;
        Cursor r8 = DBUtil.query(this.__db, r0, false, null);
        int r4 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L21
        int r5 = CursorUtil.getColumnIndexOrThrow(r8, "memory_id");     // Catch: Throwable -> L21
        int r6 = CursorUtil.getColumnIndexOrThrow(r8, "use_for_keyword");     // Catch: Throwable -> L21
        if (r8.moveToFirst() == false) goto L19;
        long r7 = r8.getLong(r4);     // Catch: Throwable -> L21
        if (r8.isNull(r5) == true) goto L14;
        r3 = r8.getString(r5);     // Catch: Throwable -> L21
    L14:
        if (r8.getInt(r6) != 0) goto L17;
        r1 = false;
    L17:
        r2 = new ir(r7, r3, r1);     // Catch: Throwable -> L21
    L19:
        r8.close();
        r0.release();
        return r2;
    L21:
        th = move-exception;
        r8.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r9);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ir queryByUUID(String r1) {
        return UnionSemanticMemoryExtDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ir queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ir queryOne() {
        return UnionSemanticMemoryExtDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ir queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ir> queryWithLimitAndOffset(int r1, int r2) {
        return UnionSemanticMemoryExtDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ir> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityUnionSemanticMemoryExtEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(ir r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfUnionSemanticMemoryExtEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(ir r3) {
        return update2((ir) ZeusTransformUtils.preCheckCast(r3, ir.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ir> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfUnionSemanticMemoryExtEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
