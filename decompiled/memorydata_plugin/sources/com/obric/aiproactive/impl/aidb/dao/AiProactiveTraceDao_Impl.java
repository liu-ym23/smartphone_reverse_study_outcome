package com.obric.aiproactive.impl.aidb.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public final class AiProactiveTraceDao_Impl implements i {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.aiproactive.impl.aidb.a.i> __deletionAdapterOfAiProactiveTraceEntity;
    private final EntityInsertionAdapter<com.obric.aiproactive.impl.aidb.a.i> __insertionAdapterOfAiProactiveTraceEntity;
    private final EntityDeletionOrUpdateAdapter<com.obric.aiproactive.impl.aidb.a.i> __updateAdapterOfAiProactiveTraceEntity;

    public AiProactiveTraceDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAiProactiveTraceEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfAiProactiveTraceEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfAiProactiveTraceEntity = new AnonymousClass3(this, r2);
    }

    private com.obric.aiproactive.impl.aidb.a.i __entityCursorConverter_comObricAiproactiveImplAidbEntityAiProactiveTraceEntity(Cursor r28) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r28, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r3 = CursorUtil.getColumnIndex(r0, "status");
        int r4 = CursorUtil.getColumnIndex(r0, CommonConsts.COUNT_TYPE);
        int r5 = CursorUtil.getColumnIndex(r0, "created");
        int r6 = CursorUtil.getColumnIndex(r0, "updated");
        int r7 = CursorUtil.getColumnIndex(r0, "log_id");
        int r8 = CursorUtil.getColumnIndex(r0, "response_id");
        long r9 = 0;
        if (r1 != (-1)) goto L5;
        long r15 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r17 = 0;
    L10:
        if (r3 != (-1)) goto L13;
    L11:
        String r19 = null;
    L16:
        if (r4 != (-1)) goto L18;
        int r10 = 0;
    L19:
        int r20 = r10;
        if (r5 != (-1)) goto L22;
        long r21 = 0;
    L23:
        if (r6 == (-1)) goto L26;
        r9 = r0.getLong(r6);
    L26:
        long r23 = r9;
        if (r7 != (-1)) goto L30;
    L28:
        String r25 = null;
    L33:
        if (r8 != (-1)) goto L36;
    L34:
        String r26 = null;
    L40:
        return new com.obric.aiproactive.impl.aidb.a.i(r15, r17, r19, r20, r21, r23, r25, r26);
    L36:
        if (r0.isNull(r8) == true) goto L34;
        r26 = r0.getString(r8);
        goto L40
    L30:
        if (r0.isNull(r7) == true) goto L28;
        r25 = r0.getString(r7);
        goto L33
    L22:
        r21 = r0.getLong(r5);
        goto L23
    L18:
        r10 = r0.getInt(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r19 = r0.getString(r3);
        goto L16
    L8:
        r17 = r0.getLong(r2);
        goto L10
    L5:
        r15 = r0.getLong(r1);
        goto L6
    }

    static /* synthetic */ RoomDatabase access$000(AiProactiveTraceDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.aiproactive.impl.aidb.a.i> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAiProactiveTraceEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.aiproactive.impl.aidb.a.i> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAiProactiveTraceEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.aiproactive.impl.aidb.a.i r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAiProactiveTraceEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.aiproactive.impl.aidb.a.i r3) {
        return delete2((com.obric.aiproactive.impl.aidb.a.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.impl.aidb.a.i.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return i.a.d(this);
    }

    public Object findLatestLogId(Continuation<? super String> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT log_id FROM ProactiveTrace\n        WHERE log_id IS NOT NULL AND log_id != ''\n        ORDER BY timestamp DESC, id DESC\n        LIMIT 1\n        ", 0);
        CancellationSignal r2 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r2, new AnonymousClass5(this, r0), r7);
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.i
    public Object findLogIdById(long r3, Continuation<? super String> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT log_id FROM ProactiveTrace\n        WHERE id = ?\n        LIMIT 1\n        ", 1);
        r0.bindLong(1, r3);
        CancellationSignal r4 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r4, new AnonymousClass4(this, r0), r6);
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.i
    public String findLogIdByIdSync(long r3) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT log_id FROM ProactiveTrace\n        WHERE id = ?\n        LIMIT 1\n        ", 1);
        r0.bindLong(1, r3);
        this.__db.assertNotSuspendingTransaction();
        String r4 = null;
        Cursor r2 = DBUtil.query(this.__db, r0, false, null);
    L11:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    L4:
        if (r2.moveToFirst() == true) goto L6;
    L9:
        r2.close();
        r0.release();
        return r4;
    L6:
        if (r2.isNull(0) == true) goto L9;
        r4 = r2.getString(0);     // Catch: Throwable -> L11
        goto L9
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return i.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.aiproactive.impl.aidb.a.i r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAiProactiveTraceEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.aiproactive.impl.aidb.a.i r3) {
        return insert2((com.obric.aiproactive.impl.aidb.a.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.impl.aidb.a.i.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.aiproactive.impl.aidb.a.i> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAiProactiveTraceEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.i> queryAll() {
        return i.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return i.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.aiproactive.impl.aidb.a.i queryById(long r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.aiproactive.impl.aidb.a.i queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.i> queryByIds(List<Long> r3) {
        return i.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.aiproactive.impl.aidb.a.i queryByUUID(String r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.aiproactive.impl.aidb.a.i queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.aiproactive.impl.aidb.a.i queryOne() {
        return i.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.aiproactive.impl.aidb.a.i queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.i> queryWithLimitAndOffset(int r1, int r2) {
        return i.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.i> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricAiproactiveImplAidbEntityAiProactiveTraceEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.aiproactive.impl.aidb.a.i r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAiProactiveTraceEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.aiproactive.impl.aidb.a.i r3) {
        return update2((com.obric.aiproactive.impl.aidb.a.i) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.impl.aidb.a.i.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.aiproactive.impl.aidb.a.i> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAiProactiveTraceEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
