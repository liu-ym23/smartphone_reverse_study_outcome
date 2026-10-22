package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.em;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class PoiInfoGroupDao_Impl implements PoiInfoGroupDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<em> __deletionAdapterOfPoiInfoGroupEntity;
    private final EntityInsertionAdapter<em> __insertionAdapterOfPoiInfoGroupEntity;
    private final EntityDeletionOrUpdateAdapter<em> __updateAdapterOfPoiInfoGroupEntity;

    public PoiInfoGroupDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfPoiInfoGroupEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfPoiInfoGroupEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfPoiInfoGroupEntity = new AnonymousClass3(this, r2);
    }

    private em __entityCursorConverter_comObricMemorydataDatabaseEntityPoiInfoGroupEntity(Cursor r18) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r18, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "req_source");
        int r2 = CursorUtil.getColumnIndex(r0, "msg_content");
        int r3 = CursorUtil.getColumnIndex(r0, CommonConsts.COUNT_TYPE);
        int r4 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        long r5 = 0;
        if (r1 != (-1)) goto L5;
        long r11 = 0;
    L6:
        String r6 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r13 = r6;
        if (r3 != (-1)) goto L15;
        int r7 = 0;
    L16:
        int r14 = r7;
        if (r4 == (-1)) goto L21;
        r5 = r0.getLong(r4);
    L21:
        return new em(r11, r13, r14, r5);
    L15:
        r7 = r0.getInt(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r6 = r0.getString(r2);
        goto L8
    L5:
        r11 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<em> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfPoiInfoGroupEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<em> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPoiInfoGroupEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(em r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfPoiInfoGroupEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(em r3) {
        return delete2((em) ZeusTransformUtils.preCheckCast(r3, em.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return PoiInfoGroupDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.PoiInfoGroupDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return PoiInfoGroupDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(em r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfPoiInfoGroupEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(em r3) {
        return insert2((em) ZeusTransformUtils.preCheckCast(r3, em.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<em> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfPoiInfoGroupEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<em> queryAll() {
        return PoiInfoGroupDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return PoiInfoGroupDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public em queryById(long r1) {
        return PoiInfoGroupDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ em queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<em> queryByIds(List<Long> r3) {
        return PoiInfoGroupDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public em queryByUUID(String r1) {
        return PoiInfoGroupDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ em queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public em queryOne() {
        return PoiInfoGroupDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ em queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<em> queryWithLimitAndOffset(int r1, int r2) {
        return PoiInfoGroupDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.PoiInfoGroupDao
    public List<em> queryWithRefSource(long r14) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM PoiInfoGroup WHERE req_source = ?", 1);
        r0.bindLong(1, r14);
        this.__db.assertNotSuspendingTransaction();
        Cursor r13 = DBUtil.query(this.__db, r0, false, null);
        int r15 = CursorUtil.getColumnIndexOrThrow(r13, "req_source");     // Catch: Throwable -> L14
        int r1 = CursorUtil.getColumnIndexOrThrow(r13, "msg_content");     // Catch: Throwable -> L14
        int r2 = CursorUtil.getColumnIndexOrThrow(r13, CommonConsts.COUNT_TYPE);     // Catch: Throwable -> L14
        int r3 = CursorUtil.getColumnIndexOrThrow(r13, OaidModel.KEY_ID);     // Catch: Throwable -> L14
        ArrayList r4 = new ArrayList(r13.getCount());     // Catch: Throwable -> L14
    L4:
        if (r13.moveToNext() == false) goto L12;
        long r7 = r13.getLong(r15);     // Catch: Throwable -> L14
        if (r13.isNull(r1) == false) goto L9;
        String r9 = null;
    L10:
        r4.add(new em(r7, r9, r13.getInt(r2), r13.getLong(r3)));     // Catch: Throwable -> L14
        goto L4
    L9:
        r9 = r13.getString(r1);     // Catch: Throwable -> L14
        goto L10
    L12:
        r13.close();
        r0.release();
        return r4;
    L14:
        th = move-exception;
        r13.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<em> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityPoiInfoGroupEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(em r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfPoiInfoGroupEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(em r3) {
        return update2((em) ZeusTransformUtils.preCheckCast(r3, em.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<em> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfPoiInfoGroupEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
