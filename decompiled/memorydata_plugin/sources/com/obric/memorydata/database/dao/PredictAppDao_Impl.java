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
import com.obric.memorydata.database.entity.eo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class PredictAppDao_Impl implements PredictAppDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<eo> __deletionAdapterOfPredictAppEntity;
    private final EntityInsertionAdapter<eo> __insertionAdapterOfPredictAppEntity;
    private final EntityDeletionOrUpdateAdapter<eo> __updateAdapterOfPredictAppEntity;

    public PredictAppDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfPredictAppEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfPredictAppEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfPredictAppEntity = new AnonymousClass3(this, r2);
    }

    private eo __entityCursorConverter_comObricMemorydataDatabaseEntityPredictAppEntity(Cursor r13) {
        Cursor r12 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r13, Cursor.class, "com.obric.memorydata.plugin");
        int r14 = CursorUtil.getColumnIndex(r12, "package_name");
        int r0 = CursorUtil.getColumnIndex(r12, "predict_result");
        int r1 = CursorUtil.getColumnIndex(r12, "timestamp");
        int r2 = CursorUtil.getColumnIndex(r12, OaidModel.KEY_ID);
        String r3 = null;
        if (r14 != (-1)) goto L6;
    L4:
        String r6 = r3;
        if (r0 != (-1)) goto L11;
        int r15 = 0;
    L12:
        int r7 = r15;
        if (r1 != (-1)) goto L15;
        long r4 = 0;
    L16:
        if (r2 != (-1)) goto L18;
        long r10 = 0;
    L20:
        return new eo(r6, r7, r4, r10);
    L18:
        r10 = r12.getLong(r2);
        goto L20
    L15:
        r4 = r12.getLong(r1);
        goto L16
    L11:
        r15 = r12.getInt(r0);
        goto L12
    L6:
        if (r12.isNull(r14) == true) goto L4;
        r3 = r12.getString(r14);
        goto L4
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<eo> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfPredictAppEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<eo> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPredictAppEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(eo r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfPredictAppEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(eo r3) {
        return delete2((eo) ZeusTransformUtils.preCheckCast(r3, eo.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return PredictAppDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.PredictAppDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return PredictAppDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(eo r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfPredictAppEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(eo r3) {
        return insert2((eo) ZeusTransformUtils.preCheckCast(r3, eo.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<eo> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfPredictAppEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<eo> queryAll() {
        return PredictAppDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return PredictAppDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public eo queryById(long r1) {
        return PredictAppDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ eo queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<eo> queryByIds(List<Long> r3) {
        return PredictAppDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public eo queryByUUID(String r1) {
        return PredictAppDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ eo queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public eo queryOne() {
        return PredictAppDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ eo queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.PredictAppDao
    public List<eo> queryRecords(long r12, long r14) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM predict_app_result WHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp ASC", 2);
        r0.bindLong(1, r12);
        r0.bindLong(2, r14);
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.__db, r0, false, null);
        int r13 = CursorUtil.getColumnIndexOrThrow(r11, "package_name");     // Catch: Throwable -> L14
        int r15 = CursorUtil.getColumnIndexOrThrow(r11, "predict_result");     // Catch: Throwable -> L14
        int r16 = CursorUtil.getColumnIndexOrThrow(r11, "timestamp");     // Catch: Throwable -> L14
        int r1 = CursorUtil.getColumnIndexOrThrow(r11, OaidModel.KEY_ID);     // Catch: Throwable -> L14
        ArrayList r2 = new ArrayList(r11.getCount());     // Catch: Throwable -> L14
    L4:
        if (r11.moveToNext() == false) goto L12;
        if (r11.isNull(r13) == false) goto L9;
        String r5 = null;
    L10:
        r2.add(new eo(r5, r11.getInt(r15), r11.getLong(r16), r11.getLong(r1)));     // Catch: Throwable -> L14
        goto L4
    L9:
        r5 = r11.getString(r13);     // Catch: Throwable -> L14
        goto L10
    L12:
        r11.close();
        r0.release();
        return r2;
    L14:
        th = move-exception;
        r11.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.PredictAppDao
    public List<eo> queryRecords(List<String> r11, long r12, long r14) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM predict_app_result WHERE timestamp >= ");
        r0.append("?");
        r0.append(" AND timestamp < ");
        r0.append("?");
        r0.append(" AND package_name IN (");
        int r2 = r13.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") ORDER BY timestamp ASC");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 2);
        r1.bindLong(1, r12);
        r1.bindLong(2, r14);
        Iterator r15 = r13.iterator();
        int r16 = 3;
    L4:
        if (r15.hasNext() == false) goto L10;
        String r17 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        if (r17 != null) goto L8;
        r1.bindNull(r16);
    L9:
        r16 = r16 + 1;
        goto L4
    L8:
        r1.bindString(r16, r17);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r10 = DBUtil.query(this.__db, r1, false, null);
        int r18 = CursorUtil.getColumnIndexOrThrow(r10, "package_name");     // Catch: Throwable -> L22
        int r19 = CursorUtil.getColumnIndexOrThrow(r10, "predict_result");     // Catch: Throwable -> L22
        int r110 = CursorUtil.getColumnIndexOrThrow(r10, "timestamp");     // Catch: Throwable -> L22
        int r111 = CursorUtil.getColumnIndexOrThrow(r10, OaidModel.KEY_ID);     // Catch: Throwable -> L22
        ArrayList r3 = new ArrayList(r10.getCount());     // Catch: Throwable -> L22
    L12:
        if (r10.moveToNext() == false) goto L20;
        if (r10.isNull(r18) == false) goto L17;
        String r4 = null;
    L18:
        r3.add(new eo(r4, r10.getInt(r19), r10.getLong(r110), r10.getLong(r111)));     // Catch: Throwable -> L22
        goto L12
    L17:
        r4 = r10.getString(r18);     // Catch: Throwable -> L22
        goto L18
    L20:
        r10.close();
        r1.release();
        return r3;
    L22:
        th = move-exception;
        r10.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<eo> queryWithLimitAndOffset(int r1, int r2) {
        return PredictAppDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<eo> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityPredictAppEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(eo r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfPredictAppEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(eo r3) {
        return update2((eo) ZeusTransformUtils.preCheckCast(r3, eo.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<eo> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfPredictAppEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
