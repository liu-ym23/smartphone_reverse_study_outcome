package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.bg;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EmbeddingVectorCacheDao_Impl implements EmbeddingVectorCacheDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<bg> __deletionAdapterOfEmbeddingVectorCacheEntity;
    private final EntityInsertionAdapter<bg> __insertionAdapterOfEmbeddingVectorCacheEntity;
    private final EntityDeletionOrUpdateAdapter<bg> __updateAdapterOfEmbeddingVectorCacheEntity;

    public EmbeddingVectorCacheDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfEmbeddingVectorCacheEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfEmbeddingVectorCacheEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfEmbeddingVectorCacheEntity = new AnonymousClass3(this, r2);
    }

    private bg __entityCursorConverter_comObricMemorydataDatabaseEntityEmbeddingVectorCacheEntity(Cursor r20) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r20, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r2 = CursorUtil.getColumnIndex(r0, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        int r3 = CursorUtil.getColumnIndex(r0, "type");
        int r4 = CursorUtil.getColumnIndex(r0, "vector");
        int r5 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        long r6 = 0;
        if (r1 != (-1)) goto L5;
        long r12 = 0;
    L6:
        String r7 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r14 = null;
    L13:
        if (r3 != (-1)) goto L15;
        int r8 = 0;
    L16:
        int r15 = r8;
        if (r4 != (-1)) goto L20;
    L18:
        String r16 = r7;
        if (r5 == (-1)) goto L27;
        r6 = r0.getLong(r5);
    L27:
        return new bg(r12, r14, r15, r16, r6);
    L20:
        if (r0.isNull(r4) == true) goto L18;
        r7 = r0.getString(r4);
        goto L18
    L15:
        r8 = r0.getInt(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r14 = r0.getString(r2);
        goto L13
    L5:
        r12 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<bg> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfEmbeddingVectorCacheEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<bg> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfEmbeddingVectorCacheEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(bg r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfEmbeddingVectorCacheEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(bg r3) {
        return delete2((bg) ZeusTransformUtils.preCheckCast(r3, bg.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return EmbeddingVectorCacheDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.EmbeddingVectorCacheDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return EmbeddingVectorCacheDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(bg r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfEmbeddingVectorCacheEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(bg r3) {
        return insert2((bg) ZeusTransformUtils.preCheckCast(r3, bg.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<bg> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfEmbeddingVectorCacheEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bg> queryAll() {
        return EmbeddingVectorCacheDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return EmbeddingVectorCacheDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public bg queryById(long r1) {
        return EmbeddingVectorCacheDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ bg queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bg> queryByIds(List<Long> r3) {
        return EmbeddingVectorCacheDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public bg queryByUUID(String r1) {
        return EmbeddingVectorCacheDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ bg queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public bg queryOne() {
        return EmbeddingVectorCacheDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ bg queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.EmbeddingVectorCacheDao
    public bg queryOneRecordBy(String r18, int r19) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM EmbeddingVectorCache WHERE text= ? AND type= ? LIMIT 1", 2);
        if (r18 != null) goto L5;
        r2.bindNull(1);
    L6:
        r2.bindLong(2, r19);
        this.__db.assertNotSuspendingTransaction();
        bg r3 = null;
        String r4 = null;
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L20
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);     // Catch: Throwable -> L20
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L20
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "vector");     // Catch: Throwable -> L20
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L20
        if (r1.moveToFirst() == false) goto L18;
        long r10 = r1.getLong(r0);     // Catch: Throwable -> L20
        if (r1.isNull(r5) == false) goto L12;
        String r12 = null;
    L13:
        int r13 = r1.getInt(r6);     // Catch: Throwable -> L20
        if (r1.isNull(r7) == true) goto L17;
        r4 = r1.getString(r7);     // Catch: Throwable -> L20
    L17:
        r3 = new bg(r10, r12, r13, r4, r1.getLong(r8));     // Catch: Throwable -> L20
        goto L18
    L12:
        r12 = r1.getString(r5);     // Catch: Throwable -> L20
    L18:
        r1.close();
        r2.release();
        return r3;
    L20:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r18);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bg> queryWithLimitAndOffset(int r1, int r2) {
        return EmbeddingVectorCacheDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bg> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityEmbeddingVectorCacheEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(bg r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfEmbeddingVectorCacheEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(bg r3) {
        return update2((bg) ZeusTransformUtils.preCheckCast(r3, bg.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<bg> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfEmbeddingVectorCacheEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
