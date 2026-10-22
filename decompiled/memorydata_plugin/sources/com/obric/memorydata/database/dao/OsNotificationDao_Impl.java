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
import com.obric.memorydata.database.entity.ec;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class OsNotificationDao_Impl implements OsNotificationDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ec> __deletionAdapterOfOsNotificationEntity;
    private final EntityInsertionAdapter<ec> __insertionAdapterOfOsNotificationEntity;
    private final EntityDeletionOrUpdateAdapter<ec> __updateAdapterOfOsNotificationEntity;

    public OsNotificationDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfOsNotificationEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfOsNotificationEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfOsNotificationEntity = new AnonymousClass3(this, r2);
    }

    private ec __entityCursorConverter_comObricMemorydataDatabaseEntityOsNotificationEntity(Cursor r21) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r21, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "dataId");
        int r2 = CursorUtil.getColumnIndex(r0, "dataVersion");
        int r3 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r4 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r5 = CursorUtil.getColumnIndex(r0, "title");
        int r6 = CursorUtil.getColumnIndex(r0, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        int r7 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r8 = 0;
        if (r1 != (-1)) goto L5;
        int r11 = 0;
    L6:
        if (r2 == (-1)) goto L9;
        r8 = r0.getInt(r2);
    L9:
        int r12 = r8;
        if (r3 != (-1)) goto L12;
        long r13 = 0;
    L13:
        String r9 = null;
        if (r4 != (-1)) goto L17;
    L15:
        String r15 = null;
    L20:
        if (r5 != (-1)) goto L23;
    L21:
        String r16 = null;
    L26:
        if (r6 != (-1)) goto L29;
    L27:
        String r17 = r9;
        if (r7 != (-1)) goto L34;
        long r18 = 0;
    L36:
        return new ec(r11, r12, r13, r15, r16, r17, r18);
    L34:
        r18 = r0.getLong(r7);
        goto L36
    L29:
        if (r0.isNull(r6) == true) goto L27;
        r9 = r0.getString(r6);
        goto L27
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r16 = r0.getString(r5);
        goto L26
    L17:
        if (r0.isNull(r4) == true) goto L15;
        r15 = r0.getString(r4);
        goto L20
    L12:
        r13 = r0.getLong(r3);
        goto L13
    L5:
        r11 = r0.getInt(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ec> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfOsNotificationEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ec> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfOsNotificationEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(ec r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfOsNotificationEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(ec r3) {
        return delete2((ec) ZeusTransformUtils.preCheckCast(r3, ec.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return OsNotificationDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.OsNotificationDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return OsNotificationDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(ec r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfOsNotificationEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(ec r3) {
        return insert2((ec) ZeusTransformUtils.preCheckCast(r3, ec.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ec> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfOsNotificationEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ec> queryAll() {
        return OsNotificationDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return OsNotificationDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ec queryById(long r1) {
        return OsNotificationDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ec queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ec> queryByIds(List<Long> r3) {
        return OsNotificationDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ec queryByUUID(String r1) {
        return OsNotificationDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ec queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.OsNotificationDao
    public List<ec> queryLast5Records(long r23, long r25) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawOsNotification WHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp DESC LIMIT 5", 2);
        r1.bindLong(1, r23);
        r1.bindLong(2, r25);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "dataId");     // Catch: Throwable -> L22
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "dataVersion");     // Catch: Throwable -> L22
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L22
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L22
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "title");     // Catch: Throwable -> L22
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);     // Catch: Throwable -> L22
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L22
        ArrayList r10 = new ArrayList(r2.getCount());     // Catch: Throwable -> L22
    L4:
        if (r2.moveToNext() == false) goto L20;
        int r13 = r2.getInt(r0);     // Catch: Throwable -> L22
        int r14 = r2.getInt(r4);     // Catch: Throwable -> L22
        long r15 = r2.getLong(r5);     // Catch: Throwable -> L22
        if (r2.isNull(r6) == false) goto L9;
        String r17 = null;
    L11:
        if (r2.isNull(r7) == false) goto L13;
        String r18 = null;
    L15:
        if (r2.isNull(r8) == false) goto L17;
        String r19 = null;
    L18:
        r10.add(new ec(r13, r14, r15, r17, r18, r19, r2.getLong(r9)));     // Catch: Throwable -> L22
        goto L4
    L17:
        r19 = r2.getString(r8);     // Catch: Throwable -> L22
        goto L18
    L13:
        r18 = r2.getString(r7);     // Catch: Throwable -> L22
        goto L15
    L9:
        r17 = r2.getString(r6);     // Catch: Throwable -> L22
        goto L11
    L20:
        r2.close();
        r1.release();
        return r10;
    L22:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ec queryOne() {
        return OsNotificationDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ec queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ec> queryWithLimitAndOffset(int r1, int r2) {
        return OsNotificationDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ec> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityOsNotificationEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(ec r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfOsNotificationEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(ec r3) {
        return update2((ec) ZeusTransformUtils.preCheckCast(r3, ec.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ec> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfOsNotificationEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
