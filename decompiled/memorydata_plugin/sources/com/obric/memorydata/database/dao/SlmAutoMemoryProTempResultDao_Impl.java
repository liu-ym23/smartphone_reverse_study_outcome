package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.SlmAutoMemoryProTempResultEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class SlmAutoMemoryProTempResultDao_Impl implements SlmAutoMemoryProTempResultDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<SlmAutoMemoryProTempResultEntity> __deletionAdapterOfSlmAutoMemoryProTempResultEntity;
    private final EntityInsertionAdapter<SlmAutoMemoryProTempResultEntity> __insertionAdapterOfSlmAutoMemoryProTempResultEntity;
    private final EntityDeletionOrUpdateAdapter<SlmAutoMemoryProTempResultEntity> __updateAdapterOfSlmAutoMemoryProTempResultEntity;

    public SlmAutoMemoryProTempResultDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfSlmAutoMemoryProTempResultEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfSlmAutoMemoryProTempResultEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfSlmAutoMemoryProTempResultEntity = new AnonymousClass3(this, r2);
    }

    private SlmAutoMemoryProTempResultEntity __entityCursorConverter_comObricMemorydataDatabaseEntitySlmAutoMemoryProTempResultEntity(Cursor r24) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r24, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "batch_id");
        int r3 = CursorUtil.getColumnIndex(r0, "ruleId");
        int r4 = CursorUtil.getColumnIndex(r0, "app_packges");
        int r5 = CursorUtil.getColumnIndex(r0, "enable_index");
        int r6 = CursorUtil.getColumnIndex(r0, "timeStamp");
        int r7 = CursorUtil.getColumnIndex(r0, "data");
        long r8 = 0;
        if (r1 != (-1)) goto L5;
        long r14 = 0;
    L7:
        if (r2 != (-1)) goto L10;
    L8:
        String r16 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r17 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r18 = null;
    L25:
        if (r5 != (-1)) goto L27;
        int r9 = 0;
    L28:
        int r19 = r9;
        if (r6 == (-1)) goto L32;
        r8 = r0.getLong(r6);
    L32:
        long r20 = r8;
        if (r7 != (-1)) goto L36;
    L34:
        String r22 = null;
    L40:
        return new SlmAutoMemoryProTempResultEntity(r14, r16, r17, r18, r19, r20, r22);
    L36:
        if (r0.isNull(r7) == true) goto L34;
        r22 = r0.getString(r7);
        goto L40
    L27:
        r9 = r0.getInt(r5);
        goto L28
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r18 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r17 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r16 = r0.getString(r2);
        goto L13
    L5:
        r14 = r0.getLong(r1);
        goto L7
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<SlmAutoMemoryProTempResultEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfSlmAutoMemoryProTempResultEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<SlmAutoMemoryProTempResultEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfSlmAutoMemoryProTempResultEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(SlmAutoMemoryProTempResultEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfSlmAutoMemoryProTempResultEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(SlmAutoMemoryProTempResultEntity r3) {
        return delete2((SlmAutoMemoryProTempResultEntity) ZeusTransformUtils.preCheckCast(r3, SlmAutoMemoryProTempResultEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return SlmAutoMemoryProTempResultDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.SlmAutoMemoryProTempResultDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return SlmAutoMemoryProTempResultDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(SlmAutoMemoryProTempResultEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfSlmAutoMemoryProTempResultEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(SlmAutoMemoryProTempResultEntity r3) {
        return insert2((SlmAutoMemoryProTempResultEntity) ZeusTransformUtils.preCheckCast(r3, SlmAutoMemoryProTempResultEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<SlmAutoMemoryProTempResultEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfSlmAutoMemoryProTempResultEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<SlmAutoMemoryProTempResultEntity> queryAll() {
        return SlmAutoMemoryProTempResultDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return SlmAutoMemoryProTempResultDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public SlmAutoMemoryProTempResultEntity queryById(long r1) {
        return SlmAutoMemoryProTempResultDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ SlmAutoMemoryProTempResultEntity queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<SlmAutoMemoryProTempResultEntity> queryByIds(List<Long> r3) {
        return SlmAutoMemoryProTempResultDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public SlmAutoMemoryProTempResultEntity queryByUUID(String r1) {
        return SlmAutoMemoryProTempResultDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ SlmAutoMemoryProTempResultEntity queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public SlmAutoMemoryProTempResultEntity queryOne() {
        return SlmAutoMemoryProTempResultDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ SlmAutoMemoryProTempResultEntity queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<SlmAutoMemoryProTempResultEntity> queryWithLimitAndOffset(int r1, int r2) {
        return SlmAutoMemoryProTempResultDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<SlmAutoMemoryProTempResultEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntitySlmAutoMemoryProTempResultEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(SlmAutoMemoryProTempResultEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfSlmAutoMemoryProTempResultEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(SlmAutoMemoryProTempResultEntity r3) {
        return update2((SlmAutoMemoryProTempResultEntity) ZeusTransformUtils.preCheckCast(r3, SlmAutoMemoryProTempResultEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<SlmAutoMemoryProTempResultEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfSlmAutoMemoryProTempResultEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
