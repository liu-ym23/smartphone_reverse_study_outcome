package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.MemoryBaseRequirementEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryBaseRequirementDao_Impl implements MemoryBaseRequirementDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<MemoryBaseRequirementEntity> __deletionAdapterOfMemoryBaseRequirementEntity;
    private final EntityInsertionAdapter<MemoryBaseRequirementEntity> __insertionAdapterOfMemoryBaseRequirementEntity;
    private final EntityInsertionAdapter<MemoryBaseRequirementEntity> __insertionAdapterOfMemoryBaseRequirementEntity_1;
    private final SharedSQLiteStatement __preparedStmtOfMarkDelete;
    private final SharedSQLiteStatement __preparedStmtOfMarkDeleteBySource;
    private final EntityDeletionOrUpdateAdapter<MemoryBaseRequirementEntity> __updateAdapterOfMemoryBaseRequirementEntity;

    public MemoryBaseRequirementDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryBaseRequirementEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfMemoryBaseRequirementEntity_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfMemoryBaseRequirementEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfMemoryBaseRequirementEntity = new AnonymousClass4(this, r2);
        this.__preparedStmtOfMarkDelete = new AnonymousClass5(this, r2);
        this.__preparedStmtOfMarkDeleteBySource = new AnonymousClass6(this, r2);
    }

    private MemoryBaseRequirementEntity __entityCursorConverter_comObricMemorydataDatabaseEntityMemoryBaseRequirementEntity(Cursor r23) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r23, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "requirementId");
        int r2 = CursorUtil.getColumnIndex(r0, Params.CONTENT);
        int r3 = CursorUtil.getColumnIndex(r0, AILabCheckPermissionTask.KEY_SOURCE);
        int r4 = CursorUtil.getColumnIndex(r0, "status");
        int r5 = CursorUtil.getColumnIndex(r0, "sceneId");
        int r6 = CursorUtil.getColumnIndex(r0, "errorMessage");
        int r7 = CursorUtil.getColumnIndex(r0, "createTime");
        int r8 = CursorUtil.getColumnIndex(r0, "updateTime");
        String r10 = null;
        if (r1 != (-1)) goto L6;
    L4:
        String r12 = null;
    L9:
        if (r2 != (-1)) goto L12;
    L10:
        String r13 = null;
    L15:
        if (r3 != (-1)) goto L18;
    L16:
        String r14 = null;
    L21:
        if (r4 != (-1)) goto L24;
    L22:
        String r15 = null;
    L27:
        if (r5 != (-1)) goto L30;
    L28:
        String r16 = null;
    L33:
        if (r6 != (-1)) goto L36;
    L34:
        String r17 = r10;
        if (r7 != (-1)) goto L42;
        long r18 = 0;
    L43:
        if (r8 != (-1)) goto L45;
        long r20 = 0;
    L47:
        return new MemoryBaseRequirementEntity(r12, r13, r14, r15, r16, r17, r18, r20);
    L45:
        r20 = r0.getLong(r8);
        goto L47
    L42:
        r18 = r0.getLong(r7);
        goto L43
    L36:
        if (r0.isNull(r6) == true) goto L34;
        r10 = r0.getString(r6);
        goto L34
    L30:
        if (r0.isNull(r5) == true) goto L28;
        r16 = r0.getString(r5);
        goto L33
    L24:
        if (r0.isNull(r4) == true) goto L22;
        r15 = r0.getString(r4);
        goto L27
    L18:
        if (r0.isNull(r3) == true) goto L16;
        r14 = r0.getString(r3);
        goto L21
    L12:
        if (r0.isNull(r2) == true) goto L10;
        r13 = r0.getString(r2);
        goto L15
    L6:
        if (r0.isNull(r1) == true) goto L4;
        r12 = r0.getString(r1);
        goto L9
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<MemoryBaseRequirementEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMemoryBaseRequirementEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<MemoryBaseRequirementEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMemoryBaseRequirementEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(MemoryBaseRequirementEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMemoryBaseRequirementEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(MemoryBaseRequirementEntity r3) {
        return delete2((MemoryBaseRequirementEntity) ZeusTransformUtils.preCheckCast(r3, MemoryBaseRequirementEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return MemoryBaseRequirementDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.MemoryBaseRequirementDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MemoryBaseRequirementDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(MemoryBaseRequirementEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryBaseRequirementEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(MemoryBaseRequirementEntity r3) {
        return insert2((MemoryBaseRequirementEntity) ZeusTransformUtils.preCheckCast(r3, MemoryBaseRequirementEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<MemoryBaseRequirementEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryBaseRequirementEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryBaseRequirementDao
    public int markDelete(String r3, long r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfMarkDelete.acquire();
        r0.bindLong(1, r4);
        if (r3 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfMarkDelete.release(r0);
        return r5;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfMarkDelete.release(r0);
        throw th;
    L5:
        r0.bindString(2, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryBaseRequirementDao
    public int markDeleteBySource(String r3, long r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfMarkDeleteBySource.acquire();
        r0.bindLong(1, r4);
        if (r3 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfMarkDeleteBySource.release(r0);
        return r5;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfMarkDeleteBySource.release(r0);
        throw th;
    L5:
        r0.bindString(2, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryBaseRequirementEntity> queryAll() {
        return MemoryBaseRequirementDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MemoryBaseRequirementDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryBaseRequirementEntity queryById(long r1) {
        return MemoryBaseRequirementDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryBaseRequirementEntity queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryBaseRequirementEntity> queryByIds(List<Long> r3) {
        return MemoryBaseRequirementDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryBaseRequirementEntity queryByUUID(String r1) {
        return MemoryBaseRequirementDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryBaseRequirementEntity queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryBaseRequirementEntity queryOne() {
        return MemoryBaseRequirementDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryBaseRequirementEntity queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryBaseRequirementEntity> queryWithLimitAndOffset(int r1, int r2) {
        return MemoryBaseRequirementDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryBaseRequirementEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityMemoryBaseRequirementEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(MemoryBaseRequirementEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMemoryBaseRequirementEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(MemoryBaseRequirementEntity r3) {
        return update2((MemoryBaseRequirementEntity) ZeusTransformUtils.preCheckCast(r3, MemoryBaseRequirementEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<MemoryBaseRequirementEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMemoryBaseRequirementEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryBaseRequirementDao
    public long upsert(MemoryBaseRequirementEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryBaseRequirementEntity_1.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
