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
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.entity.eb;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class OsAudioPlayDao_Impl implements OsAudioPlayDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<eb> __deletionAdapterOfOsAudioPlayEntity;
    private final EntityInsertionAdapter<eb> __insertionAdapterOfOsAudioPlayEntity;
    private final EntityDeletionOrUpdateAdapter<eb> __updateAdapterOfOsAudioPlayEntity;

    public OsAudioPlayDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfOsAudioPlayEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfOsAudioPlayEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfOsAudioPlayEntity = new AnonymousClass3(this, r2);
    }

    private eb __entityCursorConverter_comObricMemorydataDatabaseEntityOsAudioPlayEntity(Cursor r28) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r28, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r2 = CursorUtil.getColumnIndex(r0, "audioType");
        int r3 = CursorUtil.getColumnIndex(r0, "outputType");
        int r4 = CursorUtil.getColumnIndex(r0, "beginTimestamp");
        int r5 = CursorUtil.getColumnIndex(r0, "endTimestamp");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, "duration");
        int r8 = CursorUtil.getColumnIndex(r0, "dataVersion");
        int r9 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        String r10 = null;
        if (r1 != (-1)) goto L6;
    L4:
        String r13 = null;
    L9:
        if (r2 != (-1)) goto L12;
    L10:
        String r14 = r10;
        int r11 = 0;
        if (r3 != (-1)) goto L18;
        int r15 = 0;
    L20:
        if (r4 != (-1)) goto L22;
        long r16 = 0;
    L23:
        if (r5 != (-1)) goto L25;
        long r18 = 0;
    L26:
        if (r6 != (-1)) goto L28;
        long r20 = 0;
    L29:
        if (r7 != (-1)) goto L31;
        long r22 = 0;
    L32:
        if (r8 == (-1)) goto L35;
        r11 = r0.getInt(r8);
    L35:
        int r24 = r11;
        if (r9 != (-1)) goto L38;
        long r25 = 0;
    L40:
        return new eb(r13, r14, r15, r16, r18, r20, r22, r24, r25);
    L38:
        r25 = r0.getLong(r9);
        goto L40
    L31:
        r22 = r0.getLong(r7);
        goto L32
    L28:
        r20 = r0.getLong(r6);
        goto L29
    L25:
        r18 = r0.getLong(r5);
        goto L26
    L22:
        r16 = r0.getLong(r4);
        goto L23
    L18:
        r15 = r0.getInt(r3);
        goto L20
    L12:
        if (r0.isNull(r2) == true) goto L10;
        r10 = r0.getString(r2);
        goto L10
    L6:
        if (r0.isNull(r1) == true) goto L4;
        r13 = r0.getString(r1);
        goto L9
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<eb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfOsAudioPlayEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<eb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfOsAudioPlayEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(eb r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfOsAudioPlayEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(eb r3) {
        return delete2((eb) ZeusTransformUtils.preCheckCast(r3, eb.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return OsAudioPlayDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.OsAudioPlayDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return OsAudioPlayDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(eb r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfOsAudioPlayEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(eb r3) {
        return insert2((eb) ZeusTransformUtils.preCheckCast(r3, eb.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<eb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfOsAudioPlayEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<eb> queryAll() {
        return OsAudioPlayDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return OsAudioPlayDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public eb queryById(long r1) {
        return OsAudioPlayDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ eb queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<eb> queryByIds(List<Long> r3) {
        return OsAudioPlayDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public eb queryByUUID(String r1) {
        return OsAudioPlayDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ eb queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public eb queryOne() {
        return OsAudioPlayDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ eb queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.OsAudioPlayDao
    public List<eb> queryRecords(long r30, long r32) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawAudioPlay WHERE beginTimestamp >= ? AND beginTimestamp < ? ORDER BY beginTimestamp ASC", 2);
        r1.bindLong(1, r30);
        r1.bindLong(2, r32);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L18
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "audioType");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "outputType");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "beginTimestamp");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "endTimestamp");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L18
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "duration");     // Catch: Throwable -> L18
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "dataVersion");     // Catch: Throwable -> L18
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L18
        ArrayList r12 = new ArrayList(r2.getCount());     // Catch: Throwable -> L18
    L4:
        if (r2.moveToNext() == false) goto L16;
        if (r2.isNull(r0) == false) goto L9;
        String r15 = null;
    L11:
        if (r2.isNull(r4) == false) goto L13;
        String r16 = null;
    L14:
        r12.add(new eb(r15, r16, r2.getInt(r5), r2.getLong(r6), r2.getLong(r7), r2.getLong(r8), r2.getLong(r9), r2.getInt(r10), r2.getLong(r11)));     // Catch: Throwable -> L18
        goto L4
    L13:
        r16 = r2.getString(r4);     // Catch: Throwable -> L18
        goto L14
    L9:
        r15 = r2.getString(r0);     // Catch: Throwable -> L18
        goto L11
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

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<eb> queryWithLimitAndOffset(int r1, int r2) {
        return OsAudioPlayDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<eb> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityOsAudioPlayEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(eb r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfOsAudioPlayEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(eb r3) {
        return update2((eb) ZeusTransformUtils.preCheckCast(r3, eb.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<eb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfOsAudioPlayEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
