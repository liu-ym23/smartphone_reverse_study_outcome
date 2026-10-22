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
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes3.dex */
public final class AiProactiveEventRecordDao_Impl implements c {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.aiproactive.impl.aidb.a.c> __deletionAdapterOfAiProactiveEventRecordEntity;
    private final EntityInsertionAdapter<com.obric.aiproactive.impl.aidb.a.c> __insertionAdapterOfAiProactiveEventRecordEntity;
    private final EntityDeletionOrUpdateAdapter<com.obric.aiproactive.impl.aidb.a.c> __updateAdapterOfAiProactiveEventRecordEntity;

    public AiProactiveEventRecordDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAiProactiveEventRecordEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfAiProactiveEventRecordEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfAiProactiveEventRecordEntity = new AnonymousClass3(this, r2);
    }

    private com.obric.aiproactive.impl.aidb.a.c __entityCursorConverter_comObricAiproactiveImplAidbEntityAiProactiveEventRecordEntity(Cursor r30) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r30, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r3 = CursorUtil.getColumnIndex(r0, "raw_table_name");
        int r4 = CursorUtil.getColumnIndex(r0, "raw_db_id");
        int r5 = CursorUtil.getColumnIndex(r0, WsConstants.KEY_EXTRA);
        int r6 = CursorUtil.getColumnIndex(r0, "fullcontent");
        int r7 = CursorUtil.getColumnIndex(r0, "userFullcontent");
        int r8 = CursorUtil.getColumnIndex(r0, "happened_at");
        int r9 = CursorUtil.getColumnIndex(r0, "recorded_at");
        long r10 = 0;
        if (r1 != (-1)) goto L5;
        long r16 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r18 = 0;
    L9:
        String r11 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r20 = null;
    L16:
        if (r4 != (-1)) goto L19;
    L17:
        Long r21 = null;
    L22:
        if (r5 != (-1)) goto L25;
    L23:
        String r22 = null;
    L28:
        if (r6 != (-1)) goto L31;
    L29:
        String r23 = null;
    L34:
        if (r7 != (-1)) goto L37;
    L35:
        String r24 = r11;
        if (r8 != (-1)) goto L42;
        long r25 = 0;
    L43:
        if (r9 == (-1)) goto L47;
        r10 = r0.getLong(r9);
    L47:
        return new com.obric.aiproactive.impl.aidb.a.c(r16, r18, r20, r21, r22, r23, r24, r25, r10);
    L42:
        r25 = r0.getLong(r8);
        goto L43
    L37:
        if (r0.isNull(r7) == true) goto L35;
        r11 = r0.getString(r7);
        goto L35
    L31:
        if (r0.isNull(r6) == true) goto L29;
        r23 = r0.getString(r6);
        goto L34
    L25:
        if (r0.isNull(r5) == true) goto L23;
        r22 = r0.getString(r5);
        goto L28
    L19:
        if (r0.isNull(r4) == true) goto L17;
        r21 = Long.valueOf(r0.getLong(r4));
        goto L22
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r20 = r0.getString(r3);
        goto L16
    L8:
        r18 = r0.getLong(r2);
        goto L9
    L5:
        r16 = r0.getLong(r1);
        goto L6
    }

    static /* synthetic */ RoomDatabase access$000(AiProactiveEventRecordDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.aiproactive.impl.aidb.a.c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAiProactiveEventRecordEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.aiproactive.impl.aidb.a.c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAiProactiveEventRecordEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.c
    public Object countAllRecords(Continuation<? super Integer> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM ProactiveEventRecords", 0);
        CancellationSignal r2 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r2, new AnonymousClass6(this, r0), r7);
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.aiproactive.impl.aidb.a.c r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAiProactiveEventRecordEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.aiproactive.impl.aidb.a.c r3) {
        return delete2((com.obric.aiproactive.impl.aidb.a.c) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.impl.aidb.a.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return c.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return c.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.aiproactive.impl.aidb.a.c r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAiProactiveEventRecordEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.aiproactive.impl.aidb.a.c r3) {
        return insert2((com.obric.aiproactive.impl.aidb.a.c) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.impl.aidb.a.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.aiproactive.impl.aidb.a.c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAiProactiveEventRecordEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.c
    public Object listTodayRecords(long r4, long r6, Continuation<? super List<com.obric.aiproactive.impl.aidb.a.c>> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT * FROM ProactiveEventRecords\n        WHERE happened_at >= ? AND happened_at < ?\n        ORDER BY happened_at DESC, id DESC\n        ", 2);
        r0.bindLong(1, r4);
        r0.bindLong(2, r6);
        CancellationSignal r5 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r5, new AnonymousClass4(this, r0), r9);
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.c
    public kotlinx.coroutines.flow.i<Integer> observeAllRecordCount() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM ProactiveEventRecords", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ProactiveEventRecords"}, new AnonymousClass7(this, r0));
    }

    @Override // com.obric.aiproactive.impl.aidb.dao.c
    public kotlinx.coroutines.flow.i<List<com.obric.aiproactive.impl.aidb.a.c>> observeTodayRecords(long r4, long r6) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT * FROM ProactiveEventRecords\n        WHERE happened_at >= ? AND happened_at < ?\n        ORDER BY happened_at DESC, id DESC\n        ", 2);
        r0.bindLong(1, r4);
        r0.bindLong(2, r6);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ProactiveEventRecords"}, new AnonymousClass5(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.c> queryAll() {
        return c.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return c.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.aiproactive.impl.aidb.a.c queryById(long r1) {
        return c.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.aiproactive.impl.aidb.a.c queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.c> queryByIds(List<Long> r3) {
        return c.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.aiproactive.impl.aidb.a.c queryByUUID(String r1) {
        return c.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.aiproactive.impl.aidb.a.c queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.aiproactive.impl.aidb.a.c queryOne() {
        return c.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.aiproactive.impl.aidb.a.c queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.c> queryWithLimitAndOffset(int r1, int r2) {
        return c.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.aiproactive.impl.aidb.a.c> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricAiproactiveImplAidbEntityAiProactiveEventRecordEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.aiproactive.impl.aidb.a.c r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAiProactiveEventRecordEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.aiproactive.impl.aidb.a.c r3) {
        return update2((com.obric.aiproactive.impl.aidb.a.c) ZeusTransformUtils.preCheckCast(r3, com.obric.aiproactive.impl.aidb.a.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.aiproactive.impl.aidb.a.c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAiProactiveEventRecordEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
