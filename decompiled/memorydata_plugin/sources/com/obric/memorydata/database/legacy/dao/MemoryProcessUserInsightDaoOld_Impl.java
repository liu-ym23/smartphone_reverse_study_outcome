package com.obric.memorydata.database.legacy.dao;

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

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryProcessUserInsightDaoOld_Impl implements ae {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.r> __deletionAdapterOfMemoryProcessUserInsightEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.entity.r> __insertionAdapterOfMemoryProcessUserInsightEntityOld;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.r> __updateAdapterOfMemoryProcessUserInsightEntityOld;

    public MemoryProcessUserInsightDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryProcessUserInsightEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfMemoryProcessUserInsightEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfMemoryProcessUserInsightEntityOld = new AnonymousClass3(this, r2);
    }

    private com.obric.memorydata.database.legacy.entity.r __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityMemoryProcessUserInsightEntityOld(Cursor r35) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r35, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "profileKey");
        int r3 = CursorUtil.getColumnIndex(r0, "summary");
        int r4 = CursorUtil.getColumnIndex(r0, "description");
        int r5 = CursorUtil.getColumnIndex(r0, "profileJson");
        int r6 = CursorUtil.getColumnIndex(r0, "evidenceRefs");
        int r7 = CursorUtil.getColumnIndex(r0, "sourceEventIds");
        int r8 = CursorUtil.getColumnIndex(r0, "processedForUnion");
        int r9 = CursorUtil.getColumnIndex(r0, "logId");
        int r10 = CursorUtil.getColumnIndex(r0, "createTime");
        int r11 = CursorUtil.getColumnIndex(r0, "updateTime");
        int r12 = CursorUtil.getColumnIndex(r0, "personalDbSplitMigrated");
        long r13 = 0;
        if (r1 != (-1)) goto L5;
        long r19 = 0;
    L6:
        String r14 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r21 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r22 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r23 = null;
    L25:
        if (r5 != (-1)) goto L28;
    L26:
        String r24 = null;
    L31:
        if (r6 != (-1)) goto L34;
    L32:
        String r25 = null;
    L37:
        if (r7 != (-1)) goto L40;
    L38:
        String r26 = null;
    L43:
        boolean r15 = true;
        if (r8 != (-1)) goto L47;
        boolean r27 = false;
    L51:
        if (r9 != (-1)) goto L54;
    L52:
        String r28 = r14;
        if (r10 != (-1)) goto L59;
        long r29 = 0;
    L60:
        if (r11 == (-1)) goto L63;
        r13 = r0.getLong(r11);
    L63:
        long r31 = r13;
        if (r12 != (-1)) goto L67;
        boolean r33 = false;
    L72:
        return new com.obric.memorydata.database.legacy.entity.r(r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r31, r33);
    L67:
        if (r0.getInt(r12) != 0) goto L70;
        r15 = false;
    L70:
        r33 = r15;
        goto L72
    L59:
        r29 = r0.getLong(r10);
        goto L60
    L54:
        if (r0.isNull(r9) == true) goto L52;
        r14 = r0.getString(r9);
        goto L52
    L47:
        if (r0.getInt(r8) == 0) goto L49;
        boolean r16 = true;
    L50:
        r27 = r16;
        goto L51
    L49:
        r16 = false;
        goto L50
    L40:
        if (r0.isNull(r7) == true) goto L38;
        r26 = r0.getString(r7);
        goto L43
    L34:
        if (r0.isNull(r6) == true) goto L32;
        r25 = r0.getString(r6);
        goto L37
    L28:
        if (r0.isNull(r5) == true) goto L26;
        r24 = r0.getString(r5);
        goto L31
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r23 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r22 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r21 = r0.getString(r2);
        goto L13
    L5:
        r19 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.entity.r> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMemoryProcessUserInsightEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.entity.r> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMemoryProcessUserInsightEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.memorydata.database.legacy.entity.r r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMemoryProcessUserInsightEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.memorydata.database.legacy.entity.r r3) {
        return delete2((com.obric.memorydata.database.legacy.entity.r) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.r.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ae.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ae.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.memorydata.database.legacy.entity.r r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryProcessUserInsightEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.memorydata.database.legacy.entity.r r3) {
        return insert2((com.obric.memorydata.database.legacy.entity.r) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.r.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.entity.r> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryProcessUserInsightEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.r> queryAll() {
        return ae.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ae.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.r queryById(long r1) {
        return ae.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.r queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.r> queryByIds(List<Long> r3) {
        return ae.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.r queryByUUID(String r1) {
        return ae.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.r queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.r queryOne() {
        return ae.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.r queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.r> queryWithLimitAndOffset(int r1, int r2) {
        return ae.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.r> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityMemoryProcessUserInsightEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.memorydata.database.legacy.entity.r r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMemoryProcessUserInsightEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.memorydata.database.legacy.entity.r r3) {
        return update2((com.obric.memorydata.database.legacy.entity.r) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.r.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.entity.r> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMemoryProcessUserInsightEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
