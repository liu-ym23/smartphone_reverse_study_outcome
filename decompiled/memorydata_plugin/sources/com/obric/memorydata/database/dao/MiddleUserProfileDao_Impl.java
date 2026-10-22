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
import com.obric.memorydata.database.entity.dn;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class MiddleUserProfileDao_Impl implements MiddleUserProfileDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<dn> __deletionAdapterOfMiddleUserProfileEntity;
    private final EntityInsertionAdapter<dn> __insertionAdapterOfMiddleUserProfileEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByUriKey;
    private final EntityDeletionOrUpdateAdapter<dn> __updateAdapterOfMiddleUserProfileEntity;

    public MiddleUserProfileDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMiddleUserProfileEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfMiddleUserProfileEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfMiddleUserProfileEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteByUriKey = new AnonymousClass4(this, r2);
    }

    private dn __entityCursorConverter_comObricMemorydataDatabaseEntityMiddleUserProfileEntity(Cursor r18) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r18, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r2 = CursorUtil.getColumnIndex(r0, "uri_key");
        int r3 = CursorUtil.getColumnIndex(r0, "uri_value");
        int r4 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        long r5 = 0;
        if (r1 != (-1)) goto L5;
        long r11 = 0;
    L6:
        String r6 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r13 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r14 = r6;
        if (r4 == (-1)) goto L23;
        r5 = r0.getLong(r4);
    L23:
        return new dn(r11, r13, r14, r5);
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r6 = r0.getString(r3);
        goto L14
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r13 = r0.getString(r2);
        goto L13
    L5:
        r11 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<dn> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMiddleUserProfileEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<dn> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMiddleUserProfileEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(dn r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMiddleUserProfileEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(dn r3) {
        return delete2((dn) ZeusTransformUtils.preCheckCast(r3, dn.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return MiddleUserProfileDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.MiddleUserProfileDao
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

    @Override // com.obric.memorydata.database.dao.MiddleUserProfileDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MiddleUserProfileDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(dn r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMiddleUserProfileEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(dn r3) {
        return insert2((dn) ZeusTransformUtils.preCheckCast(r3, dn.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<dn> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMiddleUserProfileEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dn> queryAll() {
        return MiddleUserProfileDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MiddleUserProfileDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dn queryById(long r1) {
        return MiddleUserProfileDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dn queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dn> queryByIds(List<Long> r3) {
        return MiddleUserProfileDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dn queryByUUID(String r1) {
        return MiddleUserProfileDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dn queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.MiddleUserProfileDao
    public List<dn> queryMultiKeysEntitiesByTimesList(List<String> r14, List<Long> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM MiddleUserProfile WHERE (uri_key IN (");
        int r2 = r16.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")) AND timestamp IN (");
        int r3 = r17.size();
        StringUtil.appendPlaceholders(r0, r3);
        r0.append(")");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), (r2 + 0) + r3);
        Iterator r18 = r16.iterator();
        int r4 = 1;
    L4:
        if (r18.hasNext() == false) goto L10;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
        r1.bindNull(r4);
    L9:
        r4 = r4 + 1;
        goto L4
    L8:
        r1.bindString(r4, r5);
        goto L9
    L10:
        int r6 = r2 + 1;
        Iterator r19 = r17.iterator();
    L12:
        if (r19.hasNext() == false) goto L14;
        r1.bindLong(r6, ((Long) ZeusTransformUtils.preCheckCast(r19.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r6 = r6 + 1;
        goto L12
    L14:
        this.__db.assertNotSuspendingTransaction();
        Cursor r13 = DBUtil.query(this.__db, r1, false, null);
        int r110 = CursorUtil.getColumnIndexOrThrow(r13, "timestamp");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r13, "uri_key");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r13, "uri_value");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r13, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        ArrayList r10 = new ArrayList(r13.getCount());     // Catch: Throwable -> L30
    L16:
        if (r13.moveToNext() == false) goto L28;
        long r11 = r13.getLong(r110);     // Catch: Throwable -> L30
        if (r13.isNull(r7) == false) goto L21;
        String r12 = null;
    L23:
        if (r13.isNull(r8) == false) goto L25;
        String r111 = null;
    L26:
        r10.add(new dn(r11, r12, r111, r13.getLong(r9)));     // Catch: Throwable -> L30
        goto L16
    L25:
        r111 = r13.getString(r8);     // Catch: Throwable -> L30
        goto L26
    L21:
        r12 = r13.getString(r7);     // Catch: Throwable -> L30
        goto L23
    L28:
        r13.close();
        r1.release();
        return r10;
    L30:
        th = move-exception;
        r13.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MiddleUserProfileDao
    public Map<Long, List<dn>> queryMultiKeysGroupByTime(List<String> r7, long r8, long r10) {
        return MiddleUserProfileDao.DefaultImpls.queryMultiKeysGroupByTime(this, (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin"), r8, r10);
    }

    @Override // com.obric.memorydata.database.dao.MiddleUserProfileDao
    public List<Long> queryMultiTimes(List<String> r9, long r10, long r12) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT timestamp FROM MiddleUserProfile WHERE (uri_key IN (");
        int r2 = r11.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")) AND timestamp > ");
        r0.append("?");
        r0.append(" AND timestamp < ");
        r0.append("?");
        r0.append(" GROUP BY timestamp");
        int r3 = r2 + 2;
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r3);
        Iterator r13 = r11.iterator();
        int r5 = 1;
    L4:
        if (r13.hasNext() == false) goto L10;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L8;
        r1.bindNull(r5);
    L9:
        r5 = r5 + 1;
        goto L4
    L8:
        r1.bindString(r5, r6);
        goto L9
    L10:
        r1.bindLong(r2 + 1, r10);
        r1.bindLong(r3, r12);
        this.__db.assertNotSuspendingTransaction();
        Cursor r8 = DBUtil.query(this.__db, r1, false, null);
        ArrayList r14 = new ArrayList(r8.getCount());     // Catch: Throwable -> L18
    L13:
        if (r8.moveToNext() == false) goto L16;
        r14.add(Long.valueOf(r8.getLong(0)));     // Catch: Throwable -> L18
        goto L13
    L16:
        r8.close();
        r1.release();
        return r14;
    L18:
        th = move-exception;
        r8.close();
        r1.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dn queryOne() {
        return MiddleUserProfileDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dn queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.MiddleUserProfileDao
    public dn queryOneRecordBy(String r12, long r13) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MiddleUserProfile WHERE uri_key= ? AND timestamp = ? LIMIT 1", 2);
        if (r12 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r13);
        this.__db.assertNotSuspendingTransaction();
        dn r14 = null;
        String r15 = null;
        Cursor r11 = DBUtil.query(this.__db, r0, false, null);
        int r16 = CursorUtil.getColumnIndexOrThrow(r11, "timestamp");     // Catch: Throwable -> L20
        int r17 = CursorUtil.getColumnIndexOrThrow(r11, "uri_key");     // Catch: Throwable -> L20
        int r1 = CursorUtil.getColumnIndexOrThrow(r11, "uri_value");     // Catch: Throwable -> L20
        int r2 = CursorUtil.getColumnIndexOrThrow(r11, OaidModel.KEY_ID);     // Catch: Throwable -> L20
        if (r11.moveToFirst() == false) goto L18;
        long r5 = r11.getLong(r16);     // Catch: Throwable -> L20
        if (r11.isNull(r17) == false) goto L12;
        String r7 = null;
    L14:
        if (r11.isNull(r1) == true) goto L17;
        r15 = r11.getString(r1);     // Catch: Throwable -> L20
    L17:
        r14 = new dn(r5, r7, r15, r11.getLong(r2));     // Catch: Throwable -> L20
        goto L18
    L12:
        r7 = r11.getString(r17);     // Catch: Throwable -> L20
    L18:
        r11.close();
        r0.release();
        return r14;
    L20:
        th = move-exception;
        r11.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r12);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MiddleUserProfileDao
    public List<dn> queryRecords(String r11, long r12, long r14) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MiddleUserProfile WHERE uri_key= ? AND timestamp >= ? AND timestamp < ?", 3);
        if (r11 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r12);
        r0.bindLong(3, r14);
        this.__db.assertNotSuspendingTransaction();
        Cursor r10 = DBUtil.query(this.__db, r0, false, null);
        int r13 = CursorUtil.getColumnIndexOrThrow(r10, "timestamp");     // Catch: Throwable -> L22
        int r15 = CursorUtil.getColumnIndexOrThrow(r10, "uri_key");     // Catch: Throwable -> L22
        int r16 = CursorUtil.getColumnIndexOrThrow(r10, "uri_value");     // Catch: Throwable -> L22
        int r17 = CursorUtil.getColumnIndexOrThrow(r10, OaidModel.KEY_ID);     // Catch: Throwable -> L22
        ArrayList r1 = new ArrayList(r10.getCount());     // Catch: Throwable -> L22
    L8:
        if (r10.moveToNext() == false) goto L20;
        long r4 = r10.getLong(r13);     // Catch: Throwable -> L22
        if (r10.isNull(r15) == false) goto L13;
        String r6 = null;
    L15:
        if (r10.isNull(r16) == false) goto L17;
        String r7 = null;
    L18:
        r1.add(new dn(r4, r6, r7, r10.getLong(r17)));     // Catch: Throwable -> L22
        goto L8
    L17:
        r7 = r10.getString(r16);     // Catch: Throwable -> L22
        goto L18
    L13:
        r6 = r10.getString(r15);     // Catch: Throwable -> L22
        goto L15
    L20:
        r10.close();
        r0.release();
        return r1;
    L22:
        th = move-exception;
        r10.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r11);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dn> queryWithLimitAndOffset(int r1, int r2) {
        return MiddleUserProfileDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dn> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityMiddleUserProfileEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(dn r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMiddleUserProfileEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(dn r3) {
        return update2((dn) ZeusTransformUtils.preCheckCast(r3, dn.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<dn> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMiddleUserProfileEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
