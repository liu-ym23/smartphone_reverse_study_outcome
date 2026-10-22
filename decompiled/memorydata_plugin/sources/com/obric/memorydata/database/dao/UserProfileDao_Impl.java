package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
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
import com.obric.memorydata.database.entity.je;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UserProfileDao_Impl implements UserProfileDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<je> __deletionAdapterOfUserProfileEntity;
    private final EntityInsertionAdapter<je> __insertionAdapterOfUserProfileEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByUriKey;
    private final EntityDeletionOrUpdateAdapter<je> __updateAdapterOfUserProfileEntity;

    public UserProfileDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfUserProfileEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfUserProfileEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfUserProfileEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteByUriKey = new AnonymousClass4(this, r2);
    }

    private je __entityCursorConverter_comObricMemorydataDatabaseEntityUserProfileEntity(Cursor r13) {
        Cursor r12 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r13, Cursor.class, "com.obric.memorydata.plugin");
        int r14 = CursorUtil.getColumnIndex(r12, "uri_key");
        int r0 = CursorUtil.getColumnIndex(r12, "uri_value");
        int r1 = CursorUtil.getColumnIndex(r12, "timestamp");
        int r2 = CursorUtil.getColumnIndex(r12, OaidModel.KEY_ID);
        String r3 = null;
        if (r14 != (-1)) goto L6;
    L4:
        String r6 = null;
    L9:
        if (r0 != (-1)) goto L12;
    L10:
        String r7 = r3;
        if (r1 != (-1)) goto L18;
        long r4 = 0;
    L19:
        if (r2 != (-1)) goto L21;
        long r10 = 0;
    L23:
        return new je(r6, r7, r4, r10);
    L21:
        r10 = r12.getLong(r2);
        goto L23
    L18:
        r4 = r12.getLong(r1);
        goto L19
    L12:
        if (r12.isNull(r0) == true) goto L10;
        r3 = r12.getString(r0);
        goto L10
    L6:
        if (r12.isNull(r14) == true) goto L4;
        r6 = r12.getString(r14);
        goto L9
    }

    static /* synthetic */ RoomDatabase access$000(UserProfileDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<je> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfUserProfileEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<je> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUserProfileEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(je r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfUserProfileEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(je r3) {
        return delete2((je) ZeusTransformUtils.preCheckCast(r3, je.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return UserProfileDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.UserProfileDao
    public int deleteByUriKey(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByUriKey.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByUriKey.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByUriKey.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.UserProfileDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return UserProfileDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(je r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUserProfileEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(je r3) {
        return insert2((je) ZeusTransformUtils.preCheckCast(r3, je.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<je> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfUserProfileEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<je> queryAll() {
        return UserProfileDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return UserProfileDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public je queryById(long r1) {
        return UserProfileDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ je queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<je> queryByIds(List<Long> r3) {
        return UserProfileDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public je queryByUUID(String r1) {
        return UserProfileDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ je queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public je queryOne() {
        return UserProfileDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ je queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.UserProfileDao
    public LiveData<je> queryOneRecord(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM UserProfile WHERE uri_key= ? LIMIT 1", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"UserProfile"}, false, new AnonymousClass5(this, r0));
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.UserProfileDao
    public je queryOneRecordBy(String r13) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM UserProfile WHERE uri_key= ? LIMIT 1", 1);
        if (r13 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        je r1 = null;
        String r2 = null;
        Cursor r12 = DBUtil.query(this.__db, r0, false, null);
        int r14 = CursorUtil.getColumnIndexOrThrow(r12, "uri_key");     // Catch: Throwable -> L20
        int r3 = CursorUtil.getColumnIndexOrThrow(r12, "uri_value");     // Catch: Throwable -> L20
        int r4 = CursorUtil.getColumnIndexOrThrow(r12, "timestamp");     // Catch: Throwable -> L20
        int r5 = CursorUtil.getColumnIndexOrThrow(r12, OaidModel.KEY_ID);     // Catch: Throwable -> L20
        if (r12.moveToFirst() == true) goto L10;
    L18:
        r12.close();
        r0.release();
        return r1;
    L10:
        if (r12.isNull(r14) == false) goto L12;
        String r6 = null;
    L14:
        if (r12.isNull(r3) == true) goto L17;
        r2 = r12.getString(r3);     // Catch: Throwable -> L20
    L17:
        r1 = new je(r6, r2, r12.getLong(r4), r12.getLong(r5));     // Catch: Throwable -> L20
        goto L18
    L12:
        r6 = r12.getString(r14);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r12.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r13);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<je> queryWithLimitAndOffset(int r1, int r2) {
        return UserProfileDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<je> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityUserProfileEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(je r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfUserProfileEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(je r3) {
        return update2((je) ZeusTransformUtils.preCheckCast(r3, je.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<je> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfUserProfileEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
