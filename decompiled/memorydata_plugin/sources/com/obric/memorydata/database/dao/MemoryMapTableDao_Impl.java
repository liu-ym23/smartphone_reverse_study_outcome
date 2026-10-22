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
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.ct;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryMapTableDao_Impl implements MemoryMapTableDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ct> __deletionAdapterOfMemoryMapEntity;
    private final EntityInsertionAdapter<ct> __insertionAdapterOfMemoryMapEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByEntity;
    private final EntityDeletionOrUpdateAdapter<ct> __updateAdapterOfMemoryMapEntity;

    public MemoryMapTableDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryMapEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfMemoryMapEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfMemoryMapEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteByEntity = new AnonymousClass4(this, r2);
    }

    private ct __entityCursorConverter_comObricMemorydataDatabaseEntityMemoryMapEntity(Cursor r29) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r29, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityType");
        int r3 = CursorUtil.getColumnIndex(r0, "entityRawDbId");
        int r4 = CursorUtil.getColumnIndex(r0, "memoryRawDbId");
        int r5 = CursorUtil.getColumnIndex(r0, "triggerTimeType");
        int r6 = CursorUtil.getColumnIndex(r0, "retryTime");
        int r7 = CursorUtil.getColumnIndex(r0, "isModified");
        int r8 = CursorUtil.getColumnIndex(r0, "createTimeStamp");
        int r9 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        long r10 = 0;
        if (r1 != (-1)) goto L5;
        long r16 = 0;
    L6:
        int r11 = 0;
        if (r2 != (-1)) goto L9;
        int r18 = 0;
    L10:
        if (r3 != (-1)) goto L12;
        long r19 = 0;
    L14:
        if (r4 != (-1)) goto L17;
    L15:
        Long r21 = null;
    L20:
        if (r5 != (-1)) goto L22;
        int r22 = 0;
    L23:
        if (r6 != (-1)) goto L25;
        int r23 = 0;
    L26:
        if (r7 == (-1)) goto L29;
        r11 = r0.getInt(r7);
    L29:
        int r24 = r11;
        if (r8 == (-1)) goto L33;
        r10 = r0.getLong(r8);
    L33:
        long r25 = r10;
        if (r9 != (-1)) goto L37;
    L35:
        String r27 = null;
    L41:
        return new ct(r16, r18, r19, r21, r22, r23, r24, r25, r27);
    L37:
        if (r0.isNull(r9) == true) goto L35;
        r27 = r0.getString(r9);
        goto L41
    L25:
        r23 = r0.getInt(r6);
        goto L26
    L22:
        r22 = r0.getInt(r5);
        goto L23
    L17:
        if (r0.isNull(r4) == true) goto L15;
        r21 = Long.valueOf(r0.getLong(r4));
        goto L20
    L12:
        r19 = r0.getLong(r3);
        goto L14
    L9:
        r18 = r0.getInt(r2);
        goto L10
    L5:
        r16 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ct> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMemoryMapEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ct> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMemoryMapEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(ct r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMemoryMapEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(ct r3) {
        return delete2((ct) ZeusTransformUtils.preCheckCast(r3, ct.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return MemoryMapTableDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.MemoryMapTableDao
    public int deleteByEntity(long r3, int r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByEntity.acquire();
        r0.bindLong(1, r3);
        r0.bindLong(2, r5);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByEntity.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByEntity.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryMapTableDao
    public int deleteByEntityRawDbIds(List<Long> r6, int r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM AppEntityToMemoryTable WHERE entityType = ");
        r0.append("?");
        r0.append(" AND entityRawDbId IN (");
        StringUtil.appendPlaceholders(r0, r8.size());
        r0.append(")");
        SupportSQLiteStatement r1 = this.__db.compileStatement(r0.toString());
        r1.bindLong(1, r7);
        Iterator r9 = r8.iterator();
        int r2 = 2;
    L4:
        if (r9.hasNext() == false) goto L6;
        r1.bindLong(r2, ((Long) ZeusTransformUtils.preCheckCast(r9.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r2 = r2 + 1;
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

    @Override // com.obric.memorydata.database.dao.MemoryMapTableDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MemoryMapTableDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(ct r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryMapEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(ct r3) {
        return insert2((ct) ZeusTransformUtils.preCheckCast(r3, ct.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ct> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryMapEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ct> queryAll() {
        return MemoryMapTableDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MemoryMapTableDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.MemoryMapTableDao
    public List<ct> queryByEntity(long r28, int r30) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM AppEntityToMemoryTable WHERE entityRawDbId = ? AND entityType = ? LIMIT 1", 2);
        r1.bindLong(1, r28);
        r1.bindLong(2, r30);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L18
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "entityType");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "entityRawDbId");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "memoryRawDbId");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "triggerTimeType");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "retryTime");     // Catch: Throwable -> L18
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "isModified");     // Catch: Throwable -> L18
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "createTimeStamp");     // Catch: Throwable -> L18
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L18
        ArrayList r12 = new ArrayList(r2.getCount());     // Catch: Throwable -> L18
    L4:
        if (r2.moveToNext() == false) goto L16;
        long r15 = r2.getLong(r0);     // Catch: Throwable -> L18
        int r17 = r2.getInt(r4);     // Catch: Throwable -> L18
        long r18 = r2.getLong(r5);     // Catch: Throwable -> L18
        if (r2.isNull(r6) == false) goto L9;
        Long r20 = null;
    L10:
        int r21 = r2.getInt(r7);     // Catch: Throwable -> L18
        int r22 = r2.getInt(r8);     // Catch: Throwable -> L18
        int r23 = r2.getInt(r9);     // Catch: Throwable -> L18
        long r24 = r2.getLong(r10);     // Catch: Throwable -> L18
        if (r2.isNull(r11) == false) goto L13;
        String r26 = null;
    L14:
        r12.add(new ct(r15, r17, r18, r20, r21, r22, r23, r24, r26));     // Catch: Throwable -> L18
        goto L4
    L13:
        r26 = r2.getString(r11);     // Catch: Throwable -> L18
        goto L14
    L9:
        r20 = Long.valueOf(r2.getLong(r6));     // Catch: Throwable -> L18
        goto L10
    L16:
        r2.close();
        r1.release();
        return r12;
    L18:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryMapTableDao
    public List<ct> queryByEntitySet(Set<Long> r3, int r4) {
        return MemoryMapTableDao.DefaultImpls.queryByEntitySet(this, (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.MemoryMapTableDao
    public List<ct> queryByEntityType(int r28) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM AppEntityToMemoryTable WHERE entityType = ?", 1);
        r1.bindLong(1, r28);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L18
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "entityType");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "entityRawDbId");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "memoryRawDbId");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "triggerTimeType");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "retryTime");     // Catch: Throwable -> L18
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "isModified");     // Catch: Throwable -> L18
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "createTimeStamp");     // Catch: Throwable -> L18
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L18
        ArrayList r12 = new ArrayList(r2.getCount());     // Catch: Throwable -> L18
    L4:
        if (r2.moveToNext() == false) goto L16;
        long r15 = r2.getLong(r0);     // Catch: Throwable -> L18
        int r17 = r2.getInt(r4);     // Catch: Throwable -> L18
        long r18 = r2.getLong(r5);     // Catch: Throwable -> L18
        if (r2.isNull(r6) == false) goto L9;
        Long r20 = null;
    L10:
        int r21 = r2.getInt(r7);     // Catch: Throwable -> L18
        int r22 = r2.getInt(r8);     // Catch: Throwable -> L18
        int r23 = r2.getInt(r9);     // Catch: Throwable -> L18
        long r24 = r2.getLong(r10);     // Catch: Throwable -> L18
        if (r2.isNull(r11) == false) goto L13;
        String r26 = null;
    L14:
        r12.add(new ct(r15, r17, r18, r20, r21, r22, r23, r24, r26));     // Catch: Throwable -> L18
        goto L4
    L13:
        r26 = r2.getString(r11);     // Catch: Throwable -> L18
        goto L14
    L9:
        r20 = Long.valueOf(r2.getLong(r6));     // Catch: Throwable -> L18
        goto L10
    L16:
        r2.close();
        r1.release();
        return r12;
    L18:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ct queryById(long r1) {
        return MemoryMapTableDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ct queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ct> queryByIds(List<Long> r3) {
        return MemoryMapTableDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.MemoryMapTableDao
    public List<ct> queryByMemoryRawDbId(long r28) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM AppEntityToMemoryTable WHERE memoryRawDbId = ?", 1);
        r1.bindLong(1, r28);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L18
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "entityType");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "entityRawDbId");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "memoryRawDbId");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "triggerTimeType");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "retryTime");     // Catch: Throwable -> L18
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "isModified");     // Catch: Throwable -> L18
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "createTimeStamp");     // Catch: Throwable -> L18
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L18
        ArrayList r12 = new ArrayList(r2.getCount());     // Catch: Throwable -> L18
    L4:
        if (r2.moveToNext() == false) goto L16;
        long r15 = r2.getLong(r0);     // Catch: Throwable -> L18
        int r17 = r2.getInt(r4);     // Catch: Throwable -> L18
        long r18 = r2.getLong(r5);     // Catch: Throwable -> L18
        if (r2.isNull(r6) == false) goto L9;
        Long r20 = null;
    L10:
        int r21 = r2.getInt(r7);     // Catch: Throwable -> L18
        int r22 = r2.getInt(r8);     // Catch: Throwable -> L18
        int r23 = r2.getInt(r9);     // Catch: Throwable -> L18
        long r24 = r2.getLong(r10);     // Catch: Throwable -> L18
        if (r2.isNull(r11) == false) goto L13;
        String r26 = null;
    L14:
        r12.add(new ct(r15, r17, r18, r20, r21, r22, r23, r24, r26));     // Catch: Throwable -> L18
        goto L4
    L13:
        r26 = r2.getString(r11);     // Catch: Throwable -> L18
        goto L14
    L9:
        r20 = Long.valueOf(r2.getLong(r6));     // Catch: Throwable -> L18
        goto L10
    L16:
        r2.close();
        r1.release();
        return r12;
    L18:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryMapTableDao
    public long queryByMemoryRawDbIdSize(long r3) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM AppEntityToMemoryTable WHERE memoryRawDbId = ?", 1);
        r0.bindLong(1, r3);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r0, false, null);
    L10:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L7;
        long r4 = r2.getLong(0);     // Catch: Throwable -> L10
    L8:
        r2.close();
        r0.release();
        return r4;
    L7:
        r4 = 0;
        goto L8
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ct queryByUUID(String r1) {
        return MemoryMapTableDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ct queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ct queryOne() {
        return MemoryMapTableDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ct queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ct> queryWithLimitAndOffset(int r1, int r2) {
        return MemoryMapTableDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ct> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityMemoryMapEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(ct r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMemoryMapEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(ct r3) {
        return update2((ct) ZeusTransformUtils.preCheckCast(r3, ct.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ct> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMemoryMapEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
