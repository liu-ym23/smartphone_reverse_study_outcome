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
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.ja;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UploadDataDao_Impl implements UploadDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ja> __deletionAdapterOfUploadDataEntity;
    private final EntityInsertionAdapter<ja> __insertionAdapterOfUploadDataEntity;
    private final SharedSQLiteStatement __preparedStmtOfUpdateAsNeedUpload;
    private final SharedSQLiteStatement __preparedStmtOfUpdateAsUploaded;
    private final SharedSQLiteStatement __preparedStmtOfUpdateAsUploading;
    private final EntityDeletionOrUpdateAdapter<ja> __updateAdapterOfUploadDataEntity;

    public UploadDataDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfUploadDataEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfUploadDataEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfUploadDataEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfUpdateAsUploaded = new AnonymousClass4(this, r2);
        this.__preparedStmtOfUpdateAsUploading = new AnonymousClass5(this, r2);
        this.__preparedStmtOfUpdateAsNeedUpload = new AnonymousClass6(this, r2);
    }

    private ja __entityCursorConverter_comObricMemorydataDatabaseEntityUploadDataEntity(Cursor r23) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r23, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "dataVersion");
        int r2 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r3 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r4 = CursorUtil.getColumnIndex(r0, "appName");
        int r5 = CursorUtil.getColumnIndex(r0, "dataType");
        int r6 = CursorUtil.getColumnIndex(r0, "data");
        int r7 = CursorUtil.getColumnIndex(r0, "uploadState");
        int r8 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r9 = 0;
        if (r1 != (-1)) goto L5;
        int r12 = 0;
    L7:
        if (r2 != (-1)) goto L9;
        long r10 = 0;
    L11:
        if (r3 != (-1)) goto L14;
    L12:
        String r15 = null;
    L17:
        if (r4 != (-1)) goto L20;
    L18:
        String r16 = null;
    L23:
        if (r5 != (-1)) goto L25;
        int r17 = 0;
    L26:
        if (r6 != (-1)) goto L29;
    L27:
        String r18 = null;
    L32:
        if (r7 == (-1)) goto L35;
        r9 = r0.getInt(r7);
    L35:
        int r19 = r9;
        if (r8 != (-1)) goto L38;
        long r20 = 0;
    L40:
        return new ja(r12, r10, r15, r16, r17, r18, r19, r20);
    L38:
        r20 = r0.getLong(r8);
        goto L40
    L29:
        if (r0.isNull(r6) == true) goto L27;
        r18 = r0.getString(r6);
        goto L32
    L25:
        r17 = r0.getInt(r5);
        goto L26
    L20:
        if (r0.isNull(r4) == true) goto L18;
        r16 = r0.getString(r4);
        goto L23
    L14:
        if (r0.isNull(r3) == true) goto L12;
        r15 = r0.getString(r3);
        goto L17
    L9:
        r10 = r0.getLong(r2);
        goto L11
    L5:
        r12 = r0.getInt(r1);
        goto L7
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ja> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfUploadDataEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ja> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUploadDataEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(ja r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfUploadDataEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(ja r3) {
        return delete2((ja) ZeusTransformUtils.preCheckCast(r3, ja.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return UploadDataDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.UploadDataDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return UploadDataDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(ja r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUploadDataEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(ja r3) {
        return insert2((ja) ZeusTransformUtils.preCheckCast(r3, ja.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ja> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfUploadDataEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ja> queryAll() {
        return UploadDataDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return UploadDataDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ja queryById(long r1) {
        return UploadDataDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ja queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ja> queryByIds(List<Long> r3) {
        return UploadDataDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ja queryByUUID(String r1) {
        return UploadDataDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ja queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.UploadDataDao
    public List<ja> queryNeedUploadByPackageName(String r25, int r26, int r27) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM UploadData WHERE packageName == ? AND uploadState == 0 ORDER BY id DESC LIMIT ? OFFSET ?", 3);
        if (r25 != null) goto L5;
        r2.bindNull(1);
    L6:
        r2.bindLong(2, r26);
        r2.bindLong(3, r27);
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "dataVersion");     // Catch: Throwable -> L26
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L26
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L26
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "appName");     // Catch: Throwable -> L26
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "dataType");     // Catch: Throwable -> L26
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "data");     // Catch: Throwable -> L26
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "uploadState");     // Catch: Throwable -> L26
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L26
        ArrayList r11 = new ArrayList(r1.getCount());     // Catch: Throwable -> L26
    L8:
        if (r1.moveToNext() == false) goto L24;
        int r14 = r1.getInt(r0);     // Catch: Throwable -> L26
        long r15 = r1.getLong(r4);     // Catch: Throwable -> L26
        if (r1.isNull(r5) == false) goto L13;
        String r17 = null;
    L15:
        if (r1.isNull(r6) == false) goto L17;
        String r18 = null;
    L18:
        int r19 = r1.getInt(r7);     // Catch: Throwable -> L26
        if (r1.isNull(r8) == false) goto L21;
        String r20 = null;
    L22:
        r11.add(new ja(r14, r15, r17, r18, r19, r20, r1.getInt(r9), r1.getLong(r10)));     // Catch: Throwable -> L26
        goto L8
    L21:
        r20 = r1.getString(r8);     // Catch: Throwable -> L26
        goto L22
    L17:
        r18 = r1.getString(r6);     // Catch: Throwable -> L26
        goto L18
    L13:
        r17 = r1.getString(r5);     // Catch: Throwable -> L26
        goto L15
    L24:
        r1.close();
        r2.release();
        return r11;
    L26:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r25);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.UploadDataDao
    public List<ja> queryNeedUploadOrUploading(int r25, int r26) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM UploadData WHERE uploadState == 0 OR uploadState == 2  LIMIT ? OFFSET ?", 2);
        r1.bindLong(1, r25);
        r1.bindLong(2, r26);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "dataVersion");     // Catch: Throwable -> L22
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L22
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L22
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "appName");     // Catch: Throwable -> L22
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "dataType");     // Catch: Throwable -> L22
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "data");     // Catch: Throwable -> L22
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "uploadState");     // Catch: Throwable -> L22
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L22
        ArrayList r11 = new ArrayList(r2.getCount());     // Catch: Throwable -> L22
    L4:
        if (r2.moveToNext() == false) goto L20;
        int r14 = r2.getInt(r0);     // Catch: Throwable -> L22
        long r15 = r2.getLong(r4);     // Catch: Throwable -> L22
        if (r2.isNull(r5) == false) goto L9;
        String r17 = null;
    L11:
        if (r2.isNull(r6) == false) goto L13;
        String r18 = null;
    L14:
        int r19 = r2.getInt(r7);     // Catch: Throwable -> L22
        if (r2.isNull(r8) == false) goto L17;
        String r20 = null;
    L18:
        r11.add(new ja(r14, r15, r17, r18, r19, r20, r2.getInt(r9), r2.getLong(r10)));     // Catch: Throwable -> L22
        goto L4
    L17:
        r20 = r2.getString(r8);     // Catch: Throwable -> L22
        goto L18
    L13:
        r18 = r2.getString(r6);     // Catch: Throwable -> L22
        goto L14
    L9:
        r17 = r2.getString(r5);     // Catch: Throwable -> L22
        goto L11
    L20:
        r2.close();
        r1.release();
        return r11;
    L22:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ja queryOne() {
        return UploadDataDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ja queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ja> queryWithLimitAndOffset(int r1, int r2) {
        return UploadDataDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ja> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityUploadDataEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(ja r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfUploadDataEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(ja r3) {
        return update2((ja) ZeusTransformUtils.preCheckCast(r3, ja.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ja> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfUploadDataEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.UploadDataDao
    public void updateAsNeedUpload(long r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateAsNeedUpload.acquire();
        r0.bindLong(1, r3);
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateAsNeedUpload.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateAsNeedUpload.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.UploadDataDao
    public void updateAsUploaded(long r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateAsUploaded.acquire();
        r0.bindLong(1, r3);
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateAsUploaded.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateAsUploaded.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.UploadDataDao
    public void updateAsUploading(long r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateAsUploading.acquire();
        r0.bindLong(1, r3);
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateAsUploading.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateAsUploading.release(r0);
        throw th;
    }
}
