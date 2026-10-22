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
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.aq;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ComplexRecommendQueryDao_Impl implements ComplexRecommendQueryDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<aq> __deletionAdapterOfComplexRecommendQuery;
    private final EntityInsertionAdapter<aq> __insertionAdapterOfComplexRecommendQuery;
    private final EntityDeletionOrUpdateAdapter<aq> __updateAdapterOfComplexRecommendQuery;

    public ComplexRecommendQueryDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfComplexRecommendQuery = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfComplexRecommendQuery = new AnonymousClass2(this, r2);
        this.__updateAdapterOfComplexRecommendQuery = new AnonymousClass3(this, r2);
    }

    private aq __entityCursorConverter_comObricMemorydataDatabaseEntityComplexRecommendQuery(Cursor r22) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r22, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, ChatMessage.TYPE_QUERY);
        int r2 = CursorUtil.getColumnIndex(r0, "createTime");
        int r3 = CursorUtil.getColumnIndex(r0, "priority");
        int r4 = CursorUtil.getColumnIndex(r0, InfoRequestQPSOptTraceLogger.REASON);
        int r5 = CursorUtil.getColumnIndex(r0, "expireTime");
        int r6 = CursorUtil.getColumnIndex(r0, "sources");
        int r7 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        String r8 = null;
        if (r1 != (-1)) goto L6;
    L4:
        String r11 = null;
    L10:
        if (r2 != (-1)) goto L12;
        long r9 = 0;
    L13:
        if (r3 != (-1)) goto L15;
        int r10 = 0;
    L16:
        int r14 = r10;
        if (r4 != (-1)) goto L20;
    L18:
        String r15 = null;
    L23:
        if (r5 != (-1)) goto L25;
        long r16 = 0;
    L26:
        if (r6 != (-1)) goto L29;
    L27:
        String r18 = r8;
        if (r7 != (-1)) goto L34;
        long r19 = 0;
    L36:
        return new aq(r11, r9, r14, r15, r16, r18, r19);
    L34:
        r19 = r0.getLong(r7);
        goto L36
    L29:
        if (r0.isNull(r6) == true) goto L27;
        r8 = r0.getString(r6);
        goto L27
    L25:
        r16 = r0.getLong(r5);
        goto L26
    L20:
        if (r0.isNull(r4) == true) goto L18;
        r15 = r0.getString(r4);
        goto L23
    L15:
        r10 = r0.getInt(r3);
        goto L16
    L12:
        r9 = r0.getLong(r2);
        goto L13
    L6:
        if (r0.isNull(r1) == true) goto L4;
        r11 = r0.getString(r1);
        goto L10
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<aq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfComplexRecommendQuery.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<aq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfComplexRecommendQuery.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(aq r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfComplexRecommendQuery.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(aq r3) {
        return delete2((aq) ZeusTransformUtils.preCheckCast(r3, aq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ComplexRecommendQueryDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.ComplexRecommendQueryDao
    public List<aq> getComplexRecommendQuery(int r24) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ComplexRecommendQuery  ORDER BY priority DESC LIMIT ?", 1);
        r1.bindLong(1, r24);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, ChatMessage.TYPE_QUERY);     // Catch: Throwable -> L22
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "createTime");     // Catch: Throwable -> L22
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "priority");     // Catch: Throwable -> L22
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, InfoRequestQPSOptTraceLogger.REASON);     // Catch: Throwable -> L22
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "expireTime");     // Catch: Throwable -> L22
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "sources");     // Catch: Throwable -> L22
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L22
        ArrayList r10 = new ArrayList(r2.getCount());     // Catch: Throwable -> L22
    L4:
        if (r2.moveToNext() == false) goto L20;
        if (r2.isNull(r0) == false) goto L9;
        String r13 = null;
    L10:
        long r14 = r2.getLong(r4);     // Catch: Throwable -> L22
        int r16 = r2.getInt(r5);     // Catch: Throwable -> L22
        if (r2.isNull(r6) == false) goto L13;
        String r17 = null;
    L14:
        long r18 = r2.getLong(r7);     // Catch: Throwable -> L22
        if (r2.isNull(r8) == false) goto L17;
        String r20 = null;
    L18:
        r10.add(new aq(r13, r14, r16, r17, r18, r20, r2.getLong(r9)));     // Catch: Throwable -> L22
        goto L4
    L17:
        r20 = r2.getString(r8);     // Catch: Throwable -> L22
        goto L18
    L13:
        r17 = r2.getString(r6);     // Catch: Throwable -> L22
        goto L14
    L9:
        r13 = r2.getString(r0);     // Catch: Throwable -> L22
        goto L10
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

    @Override // com.obric.memorydata.database.dao.ComplexRecommendQueryDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ComplexRecommendQueryDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(aq r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfComplexRecommendQuery.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(aq r3) {
        return insert2((aq) ZeusTransformUtils.preCheckCast(r3, aq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<aq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfComplexRecommendQuery.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aq> queryAll() {
        return ComplexRecommendQueryDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ComplexRecommendQueryDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public aq queryById(long r1) {
        return ComplexRecommendQueryDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ aq queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aq> queryByIds(List<Long> r3) {
        return ComplexRecommendQueryDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public aq queryByUUID(String r1) {
        return ComplexRecommendQueryDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ aq queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public aq queryOne() {
        return ComplexRecommendQueryDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ aq queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aq> queryWithLimitAndOffset(int r1, int r2) {
        return ComplexRecommendQueryDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<aq> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityComplexRecommendQuery(r6));     // Catch: Throwable -> L10
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
    public int update2(aq r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfComplexRecommendQuery.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(aq r3) {
        return update2((aq) ZeusTransformUtils.preCheckCast(r3, aq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<aq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfComplexRecommendQuery.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
