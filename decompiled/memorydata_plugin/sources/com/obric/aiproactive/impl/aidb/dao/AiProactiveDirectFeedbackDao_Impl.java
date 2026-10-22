package com.obric.aiproactive.impl.aidb.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class AiProactiveDirectFeedbackDao_Impl implements a {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.aiproactive.impl.aidb.a.a> __deletionAdapterOfAiProactiveDirectFeedbackEntity;
    private final EntityInsertionAdapter<com.obric.aiproactive.impl.aidb.a.a> __insertionAdapterOfAiProactiveDirectFeedbackEntity;
    private final EntityDeletionOrUpdateAdapter<com.obric.aiproactive.impl.aidb.a.a> __updateAdapterOfAiProactiveDirectFeedbackEntity;

    public AiProactiveDirectFeedbackDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAiProactiveDirectFeedbackEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfAiProactiveDirectFeedbackEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfAiProactiveDirectFeedbackEntity = new AnonymousClass3(this, r2);
    }

    private com.obric.aiproactive.impl.aidb.a.a __entityCursorConverter_comObricAiproactiveImplAidbEntityAiProactiveDirectFeedbackEntity(Cursor r20) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r20, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r3 = CursorUtil.getColumnIndex(r0, "feedback_reason");
        int r4 = CursorUtil.getColumnIndex(r0, "feedback_text");
        int r5 = CursorUtil.getColumnIndex(r0, "trace_id");
        long r6 = 0;
        if (r1 != (-1)) goto L5;
        long r12 = 0;
    L6:
        if (r2 == (-1)) goto L9;
        r6 = r0.getLong(r2);
    L9:
        long r14 = r6;
        if (r3 != (-1)) goto L13;
    L11:
        String r16 = null;
    L16:
        if (r4 != (-1)) goto L19;
    L17:
        String r17 = null;
    L22:
        if (r5 != (-1)) goto L25;
    L23:
        Long r18 = null;
    L29:
        return new com.obric.aiproactive.impl.aidb.a.a(r12, r14, r16, r17, r18);
    L25:
        if (r0.isNull(r5) == true) goto L23;
        r18 = Long.valueOf(r0.getLong(r5));
        goto L29
    L19:
        if (r0.isNull(r4) == true) goto L17;
        r17 = r0.getString(r4);
        goto L22
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r16 = r0.getString(r3);
        goto L16
    L5:
        r12 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.aiproactive.impl.aidb.a.a> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAiProactiveDirectFeedbackEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.aiproactive.impl.aidb.a.a> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAiProactiveDirectFeedbackEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.aiproactive.impl.aidb.a.a r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAiProactiveDirectFeedbackEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.aiproactive.impl.aidb.a.a r3) {
        return delete2((com.obric.aiproactive.impl.aidb.a.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.impl.aidb.a.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return a.C0281a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return a.C0281a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.aiproactive.impl.aidb.a.a r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAiProactiveDirectFeedbackEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.aiproactive.impl.aidb.a.a r3) {
        return insert2((com.obric.aiproactive.impl.aidb.a.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.impl.aidb.a.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.aiproactive.impl.aidb.a.a> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAiProactiveDirectFeedbackEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.a> queryAll() {
        return a.C0281a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return a.C0281a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.aiproactive.impl.aidb.a.a queryById(long r1) {
        return a.C0281a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.aiproactive.impl.aidb.a.a queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.a> queryByIds(List<Long> r3) {
        return a.C0281a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.aiproactive.impl.aidb.a.a queryByUUID(String r1) {
        return a.C0281a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.aiproactive.impl.aidb.a.a queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.aiproactive.impl.aidb.a.a queryOne() {
        return a.C0281a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.aiproactive.impl.aidb.a.a queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.a> queryWithLimitAndOffset(int r1, int r2) {
        return a.C0281a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.a> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricAiproactiveImplAidbEntityAiProactiveDirectFeedbackEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.aiproactive.impl.aidb.a.a r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAiProactiveDirectFeedbackEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.aiproactive.impl.aidb.a.a r3) {
        return update2((com.obric.aiproactive.impl.aidb.a.a) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.impl.aidb.a.a.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.aiproactive.impl.aidb.a.a> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAiProactiveDirectFeedbackEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
