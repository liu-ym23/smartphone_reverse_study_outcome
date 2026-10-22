package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AppUsageDao_Impl implements AppUsageDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<n> __deletionAdapterOfAppUsageEntity;
    private final EntityInsertionAdapter<n> __insertionAdapterOfAppUsageEntity;
    private final EntityDeletionOrUpdateAdapter<n> __updateAdapterOfAppUsageEntity;

    public AppUsageDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAppUsageEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfAppUsageEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfAppUsageEntity = new AnonymousClass3(this, r2);
    }

    private n __entityCursorConverter_comObricMemorydataDatabaseEntityAppUsageEntity(Cursor r23) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r23, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "package_name");
        int r2 = CursorUtil.getColumnIndex(r0, "longitude");
        int r3 = CursorUtil.getColumnIndex(r0, "latitude");
        int r4 = CursorUtil.getColumnIndex(r0, "connection_type");
        int r5 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r6 = CursorUtil.getColumnIndex(r0, "state");
        int r7 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        String r8 = null;
        if (r1 != (-1)) goto L6;
    L4:
        String r11 = null;
    L9:
        double r12 = 0.0d;
        if (r2 != (-1)) goto L12;
        double r9 = 0.0d;
    L13:
        if (r3 == (-1)) goto L16;
        r12 = r0.getDouble(r3);
    L16:
        double r14 = r12;
        if (r4 != (-1)) goto L19;
        int r10 = 0;
    L20:
        int r16 = r10;
        long r13 = 0;
        if (r5 != (-1)) goto L23;
        long r17 = 0;
    L24:
        if (r6 != (-1)) goto L27;
    L25:
        String r19 = r8;
        if (r7 == (-1)) goto L34;
        r13 = r0.getLong(r7);
    L34:
        return new n(r11, r9, r14, r16, r17, r19, r13);
    L27:
        if (r0.isNull(r6) == true) goto L25;
        r8 = r0.getString(r6);
        goto L25
    L23:
        r17 = r0.getLong(r5);
        goto L24
    L19:
        r10 = r0.getInt(r4);
        goto L20
    L12:
        r9 = r0.getDouble(r2);
        goto L13
    L6:
        if (r0.isNull(r1) == true) goto L4;
        r11 = r0.getString(r1);
        goto L9
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<n> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAppUsageEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<n> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAppUsageEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(n r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAppUsageEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(n r3) {
        return delete2((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return AppUsageDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.AppUsageDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return AppUsageDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(n r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAppUsageEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(n r3) {
        return insert2((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<n> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAppUsageEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<n> queryAll() {
        return AppUsageDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return AppUsageDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public n queryById(long r1) {
        return AppUsageDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ n queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<n> queryByIds(List<Long> r3) {
        return AppUsageDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public n queryByUUID(String r1) {
        return AppUsageDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ n queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.AppUsageDao
    public n queryLastRecord(long r23, long r25) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM app_usage_info WHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp DESC LIMIT 1", 2);
        r1.bindLong(1, r23);
        r1.bindLong(2, r25);
        this.__db.assertNotSuspendingTransaction();
        n r3 = null;
        String r4 = null;
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "package_name");     // Catch: Throwable -> L16
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "longitude");     // Catch: Throwable -> L16
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "latitude");     // Catch: Throwable -> L16
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "connection_type");     // Catch: Throwable -> L16
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L16
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L16
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L16
        if (r2.moveToFirst() == true) goto L6;
    L14:
        r2.close();
        r1.release();
        return r3;
    L6:
        if (r2.isNull(r0) == false) goto L8;
        String r11 = null;
    L9:
        double r12 = r2.getDouble(r5);     // Catch: Throwable -> L16
        double r14 = r2.getDouble(r6);     // Catch: Throwable -> L16
        int r16 = r2.getInt(r7);     // Catch: Throwable -> L16
        long r17 = r2.getLong(r8);     // Catch: Throwable -> L16
        if (r2.isNull(r9) == true) goto L13;
        r4 = r2.getString(r9);     // Catch: Throwable -> L16
    L13:
        r3 = new n(r11, r12, r14, r16, r17, r4, r2.getLong(r10));     // Catch: Throwable -> L16
        goto L14
    L8:
        r11 = r2.getString(r0);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public n queryOne() {
        return AppUsageDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ n queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.AppUsageDao
    public List<n> queryRecords(long r25, long r27) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM app_usage_info WHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", 2);
        r1.bindLong(1, r25);
        r1.bindLong(2, r27);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "package_name");     // Catch: Throwable -> L18
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "longitude");     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "latitude");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "connection_type");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L18
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L18
        ArrayList r10 = new ArrayList(r2.getCount());     // Catch: Throwable -> L18
    L4:
        if (r2.moveToNext() == false) goto L16;
        if (r2.isNull(r0) == false) goto L9;
        String r13 = null;
    L10:
        double r14 = r2.getDouble(r4);     // Catch: Throwable -> L18
        double r16 = r2.getDouble(r5);     // Catch: Throwable -> L18
        int r18 = r2.getInt(r6);     // Catch: Throwable -> L18
        long r19 = r2.getLong(r7);     // Catch: Throwable -> L18
        if (r2.isNull(r8) == false) goto L13;
        String r21 = null;
    L14:
        r10.add(new n(r13, r14, r16, r18, r19, r21, r2.getLong(r9)));     // Catch: Throwable -> L18
        goto L4
    L13:
        r21 = r2.getString(r8);     // Catch: Throwable -> L18
        goto L14
    L9:
        r13 = r2.getString(r0);     // Catch: Throwable -> L18
        goto L10
    L16:
        r2.close();
        r1.release();
        return r10;
    L18:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AppUsageDao
    public List<n> queryRecords(List<String> r25, long r26, long r28) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM app_usage_info WHERE timestamp >= ");
        r3.append("?");
        r3.append(" AND timestamp < ");
        r3.append("?");
        r3.append(" AND package_name IN (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(") ORDER BY timestamp ASC");
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire(r3.toString(), r4 + 2);
        r5.bindLong(1, r26);
        r5.bindLong(2, r28);
        Iterator r2 = r1.iterator();
        int r6 = 3;
    L4:
        if (r2.hasNext() == false) goto L10;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
        r5.bindNull(r6);
    L9:
        r6 = r6 + 1;
        goto L4
    L8:
        r5.bindString(r6, r7);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r8 = DBUtil.query(this.__db, r5, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, "package_name");     // Catch: Throwable -> L26
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "longitude");     // Catch: Throwable -> L26
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "latitude");     // Catch: Throwable -> L26
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "connection_type");     // Catch: Throwable -> L26
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "timestamp");     // Catch: Throwable -> L26
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "state");     // Catch: Throwable -> L26
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L26
        ArrayList r15 = new ArrayList(r8.getCount());     // Catch: Throwable -> L26
    L12:
        if (r8.moveToNext() == false) goto L24;
        if (r8.isNull(r0) == false) goto L17;
        String r16 = null;
    L18:
        double r17 = r8.getDouble(r9);     // Catch: Throwable -> L26
        double r18 = r8.getDouble(r10);     // Catch: Throwable -> L26
        int r19 = r8.getInt(r11);     // Catch: Throwable -> L26
        long r110 = r8.getLong(r12);     // Catch: Throwable -> L26
        if (r8.isNull(r13) == false) goto L21;
        String r21 = null;
    L22:
        r15.add(new n(r16, r17, r18, r19, r110, r21, r8.getLong(r14)));     // Catch: Throwable -> L26
        goto L12
    L21:
        r21 = r8.getString(r13);     // Catch: Throwable -> L26
        goto L22
    L17:
        r16 = r8.getString(r0);     // Catch: Throwable -> L26
        goto L18
    L24:
        r8.close();
        r5.release();
        return r15;
    L26:
        th = move-exception;
        r8.close();
        r5.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<n> queryWithLimitAndOffset(int r1, int r2) {
        return AppUsageDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<n> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityAppUsageEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(n r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAppUsageEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(n r3) {
        return update2((n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<n> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAppUsageEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
