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
import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.database.entity.ee;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class PendingContextDao_Impl implements PendingContextDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ee> __deletionAdapterOfPendingContext;
    private final EntityInsertionAdapter<ee> __insertionAdapterOfPendingContext;
    private final EntityDeletionOrUpdateAdapter<ee> __updateAdapterOfPendingContext;

    public PendingContextDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfPendingContext = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfPendingContext = new AnonymousClass2(this, r2);
        this.__updateAdapterOfPendingContext = new AnonymousClass3(this, r2);
    }

    private ee __entityCursorConverter_comObricMemorydataDatabaseEntityPendingContext(Cursor r29) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r29, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "context_id");
        int r3 = CursorUtil.getColumnIndex(r0, "source_type");
        int r4 = CursorUtil.getColumnIndex(r0, "messages_json");
        int r5 = CursorUtil.getColumnIndex(r0, "expires_at_ms");
        int r6 = CursorUtil.getColumnIndex(r0, "state");
        int r7 = CursorUtil.getColumnIndex(r0, "session_id");
        int r8 = CursorUtil.getColumnIndex(r0, "pre_build_time");
        int r9 = CursorUtil.getColumnIndex(r0, WsConstants.KEY_EXTRA);
        long r10 = 0;
        if (r1 != (-1)) goto L5;
        long r16 = 0;
    L7:
        if (r2 != (-1)) goto L10;
    L8:
        String r18 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r19 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r20 = null;
    L25:
        if (r5 != (-1)) goto L27;
        long r21 = 0;
    L28:
        if (r6 != (-1)) goto L31;
    L29:
        String r23 = null;
    L34:
        if (r7 != (-1)) goto L37;
    L35:
        String r24 = null;
    L40:
        if (r8 == (-1)) goto L43;
        r10 = r0.getLong(r8);
    L43:
        long r25 = r10;
        if (r9 != (-1)) goto L47;
    L45:
        String r27 = null;
    L51:
        return new ee(r16, r18, r19, r20, r21, r23, r24, r25, r27);
    L47:
        if (r0.isNull(r9) == true) goto L45;
        r27 = r0.getString(r9);
        goto L51
    L37:
        if (r0.isNull(r7) == true) goto L35;
        r24 = r0.getString(r7);
        goto L40
    L31:
        if (r0.isNull(r6) == true) goto L29;
        r23 = r0.getString(r6);
        goto L34
    L27:
        r21 = r0.getLong(r5);
        goto L28
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r20 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r19 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r18 = r0.getString(r2);
        goto L13
    L5:
        r16 = r0.getLong(r1);
        goto L7
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ee> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfPendingContext.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ee> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPendingContext.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(ee r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfPendingContext.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(ee r3) {
        return delete2((ee) ZeusTransformUtils.preCheckCast(r3, ee.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return PendingContextDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.PendingContextDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return PendingContextDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(ee r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfPendingContext.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(ee r3) {
        return insert2((ee) ZeusTransformUtils.preCheckCast(r3, ee.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ee> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfPendingContext.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ee> queryAll() {
        return PendingContextDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return PendingContextDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.PendingContextDao
    public ee queryByContextId(String r27) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM PendingContext WHERE context_id = ? LIMIT 1", 1);
        if (r27 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        ee r3 = null;
        String r4 = null;
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L36
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "context_id");     // Catch: Throwable -> L36
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "source_type");     // Catch: Throwable -> L36
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "messages_json");     // Catch: Throwable -> L36
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "expires_at_ms");     // Catch: Throwable -> L36
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "state");     // Catch: Throwable -> L36
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "session_id");     // Catch: Throwable -> L36
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "pre_build_time");     // Catch: Throwable -> L36
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, WsConstants.KEY_EXTRA);     // Catch: Throwable -> L36
        if (r1.moveToFirst() == false) goto L34;
        long r14 = r1.getLong(r0);     // Catch: Throwable -> L36
        if (r1.isNull(r5) == false) goto L12;
        String r16 = null;
    L14:
        if (r1.isNull(r6) == false) goto L16;
        String r17 = null;
    L18:
        if (r1.isNull(r7) == false) goto L20;
        String r18 = null;
    L21:
        long r19 = r1.getLong(r8);     // Catch: Throwable -> L36
        if (r1.isNull(r9) == false) goto L24;
        String r21 = null;
    L26:
        if (r1.isNull(r10) == false) goto L28;
        String r22 = null;
    L29:
        long r23 = r1.getLong(r11);     // Catch: Throwable -> L36
        if (r1.isNull(r12) == true) goto L33;
        r4 = r1.getString(r12);     // Catch: Throwable -> L36
    L33:
        r3 = new ee(r14, r16, r17, r18, r19, r21, r22, r23, r4);     // Catch: Throwable -> L36
        goto L34
    L28:
        r22 = r1.getString(r10);     // Catch: Throwable -> L36
        goto L29
    L24:
        r21 = r1.getString(r9);     // Catch: Throwable -> L36
        goto L26
    L20:
        r18 = r1.getString(r7);     // Catch: Throwable -> L36
        goto L21
    L16:
        r17 = r1.getString(r6);     // Catch: Throwable -> L36
        goto L18
    L12:
        r16 = r1.getString(r5);     // Catch: Throwable -> L36
    L34:
        r1.close();
        r2.release();
        return r3;
    L36:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r27);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ee queryById(long r1) {
        return PendingContextDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ee queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ee> queryByIds(List<Long> r3) {
        return PendingContextDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ee queryByUUID(String r1) {
        return PendingContextDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ee queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ee queryOne() {
        return PendingContextDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ee queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ee> queryWithLimitAndOffset(int r1, int r2) {
        return PendingContextDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ee> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityPendingContext(r6));     // Catch: Throwable -> L10
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
    public int update2(ee r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfPendingContext.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(ee r3) {
        return update2((ee) ZeusTransformUtils.preCheckCast(r3, ee.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ee> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfPendingContext.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
