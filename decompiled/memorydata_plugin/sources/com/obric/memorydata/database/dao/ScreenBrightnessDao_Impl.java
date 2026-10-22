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
import com.obric.memorydata.database.entity.ib;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ScreenBrightnessDao_Impl implements ScreenBrightnessDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ib> __deletionAdapterOfScreenBrightnessEntity;
    private final EntityInsertionAdapter<ib> __insertionAdapterOfScreenBrightnessEntity;
    private final EntityDeletionOrUpdateAdapter<ib> __updateAdapterOfScreenBrightnessEntity;

    public ScreenBrightnessDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfScreenBrightnessEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfScreenBrightnessEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfScreenBrightnessEntity = new AnonymousClass3(this, r2);
    }

    private ib __entityCursorConverter_comObricMemorydataDatabaseEntityScreenBrightnessEntity(Cursor r15) {
        Cursor r14 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r15, Cursor.class, "com.obric.memorydata.plugin");
        int r16 = CursorUtil.getColumnIndex(r14, "dataId");
        int r0 = CursorUtil.getColumnIndex(r14, "dataVersion");
        int r1 = CursorUtil.getColumnIndex(r14, "timestamp");
        int r2 = CursorUtil.getColumnIndex(r14, "brightness");
        int r3 = CursorUtil.getColumnIndex(r14, OaidModel.KEY_ID);
        int r4 = 0;
        if (r16 != (-1)) goto L5;
        int r7 = 0;
    L6:
        if (r0 != (-1)) goto L8;
        int r8 = 0;
    L10:
        if (r1 != (-1)) goto L12;
        long r5 = 0;
    L13:
        if (r2 == (-1)) goto L16;
        r4 = r14.getInt(r2);
    L16:
        int r11 = r4;
        if (r3 != (-1)) goto L19;
        long r12 = 0;
    L21:
        return new ib(r7, r8, r5, r11, r12);
    L19:
        r12 = r14.getLong(r3);
        goto L21
    L12:
        r5 = r14.getLong(r1);
        goto L13
    L8:
        r8 = r14.getInt(r0);
        goto L10
    L5:
        r7 = r14.getInt(r16);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ib> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfScreenBrightnessEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ib> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfScreenBrightnessEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(ib r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfScreenBrightnessEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(ib r3) {
        return delete2((ib) ZeusTransformUtils.preCheckCast(r3, ib.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ScreenBrightnessDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.ScreenBrightnessDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ScreenBrightnessDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(ib r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfScreenBrightnessEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(ib r3) {
        return insert2((ib) ZeusTransformUtils.preCheckCast(r3, ib.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ib> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfScreenBrightnessEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ib> queryAll() {
        return ScreenBrightnessDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ScreenBrightnessDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ib queryById(long r1) {
        return ScreenBrightnessDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ib queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ib> queryByIds(List<Long> r3) {
        return ScreenBrightnessDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ib queryByUUID(String r1) {
        return ScreenBrightnessDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ib queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.ScreenBrightnessDao
    public ib queryLastRecords(long r18, long r20) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawScreenBrightness WHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp DESC LIMIT 1", 2);
        r1.bindLong(1, r18);
        r1.bindLong(2, r20);
        this.__db.assertNotSuspendingTransaction();
        ib r3 = null;
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "dataId");     // Catch: Throwable -> L8
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "dataVersion");     // Catch: Throwable -> L8
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L8
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "brightness");     // Catch: Throwable -> L8
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L8
        if (r2.moveToFirst() == false) goto L6;
        r3 = new ib(r2.getInt(r0), r2.getInt(r4), r2.getLong(r5), r2.getInt(r6), r2.getLong(r7));     // Catch: Throwable -> L8
    L6:
        r2.close();
        r1.release();
        return r3;
    L8:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ib queryOne() {
        return ScreenBrightnessDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ib queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ib> queryWithLimitAndOffset(int r1, int r2) {
        return ScreenBrightnessDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ib> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityScreenBrightnessEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(ib r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfScreenBrightnessEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(ib r3) {
        return update2((ib) ZeusTransformUtils.preCheckCast(r3, ib.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ib> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfScreenBrightnessEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
