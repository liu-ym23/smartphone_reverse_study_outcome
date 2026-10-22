package com.obric.memorydata.database.legacy.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.legacy.entity.MemoryReviewFeedbackEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryReviewFeedbackDaoOld_Impl implements af {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<MemoryReviewFeedbackEntityOld> __deletionAdapterOfMemoryReviewFeedbackEntityOld;
    private final EntityInsertionAdapter<MemoryReviewFeedbackEntityOld> __insertionAdapterOfMemoryReviewFeedbackEntityOld;
    private final EntityDeletionOrUpdateAdapter<MemoryReviewFeedbackEntityOld> __updateAdapterOfMemoryReviewFeedbackEntityOld;

    public MemoryReviewFeedbackDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryReviewFeedbackEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfMemoryReviewFeedbackEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfMemoryReviewFeedbackEntityOld = new AnonymousClass3(this, r2);
    }

    private MemoryReviewFeedbackEntityOld __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityMemoryReviewFeedbackEntityOld(Cursor r41) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r41, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "record_id");
        int r3 = CursorUtil.getColumnIndex(r0, "module");
        int r4 = CursorUtil.getColumnIndex(r0, "vote");
        int r5 = CursorUtil.getColumnIndex(r0, "reasons_json");
        int r6 = CursorUtil.getColumnIndex(r0, "comment");
        int r7 = CursorUtil.getColumnIndex(r0, "displayed_card_json");
        int r8 = CursorUtil.getColumnIndex(r0, "status");
        int r9 = CursorUtil.getColumnIndex(r0, "error");
        int r10 = CursorUtil.getColumnIndex(r0, "trace_json");
        int r11 = CursorUtil.getColumnIndex(r0, "update_time");
        int r12 = CursorUtil.getColumnIndex(r0, "server_uniq_id");
        int r13 = CursorUtil.getColumnIndex(r0, "server_status");
        int r14 = CursorUtil.getColumnIndex(r0, "server_error");
        int r15 = CursorUtil.getColumnIndex(r0, "server_update_time");
        int r16 = CursorUtil.getColumnIndex(r0, "personalDbSplitMigrated");
        long r17 = 0;
        if (r1 != (-1)) goto L5;
        long r21 = 0;
    L6:
        String r18 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r23 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r24 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r25 = null;
    L25:
        if (r5 != (-1)) goto L28;
    L26:
        String r26 = null;
    L31:
        if (r6 != (-1)) goto L34;
    L32:
        String r27 = null;
    L37:
        if (r7 != (-1)) goto L40;
    L38:
        String r28 = null;
    L43:
        if (r8 != (-1)) goto L46;
    L44:
        String r29 = null;
    L49:
        if (r9 != (-1)) goto L52;
    L50:
        String r30 = null;
    L55:
        if (r10 != (-1)) goto L58;
    L56:
        String r31 = null;
    L61:
        if (r11 != (-1)) goto L63;
        long r32 = 0;
    L64:
        if (r12 != (-1)) goto L67;
    L65:
        String r34 = null;
    L70:
        if (r13 != (-1)) goto L73;
    L71:
        String r35 = null;
    L76:
        if (r14 != (-1)) goto L79;
    L77:
        String r36 = r18;
        if (r15 == (-1)) goto L85;
        r17 = r0.getLong(r15);
    L85:
        long r37 = r17;
        boolean r19 = false;
        if (r16 != (-1)) goto L89;
    L92:
        return new MemoryReviewFeedbackEntityOld(r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r34, r35, r36, r37, r19);
    L89:
        if (r0.getInt(r16) == 0) goto L92;
        r19 = true;
        goto L92
    L79:
        if (r0.isNull(r14) == true) goto L77;
        r18 = r0.getString(r14);
        goto L77
    L73:
        if (r0.isNull(r13) == true) goto L71;
        r35 = r0.getString(r13);
        goto L76
    L67:
        if (r0.isNull(r12) == true) goto L65;
        r34 = r0.getString(r12);
        goto L70
    L63:
        r32 = r0.getLong(r11);
        goto L64
    L58:
        if (r0.isNull(r10) == true) goto L56;
        r31 = r0.getString(r10);
        goto L61
    L52:
        if (r0.isNull(r9) == true) goto L50;
        r30 = r0.getString(r9);
        goto L55
    L46:
        if (r0.isNull(r8) == true) goto L44;
        r29 = r0.getString(r8);
        goto L49
    L40:
        if (r0.isNull(r7) == true) goto L38;
        r28 = r0.getString(r7);
        goto L43
    L34:
        if (r0.isNull(r6) == true) goto L32;
        r27 = r0.getString(r6);
        goto L37
    L28:
        if (r0.isNull(r5) == true) goto L26;
        r26 = r0.getString(r5);
        goto L31
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r25 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r24 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r23 = r0.getString(r2);
        goto L13
    L5:
        r21 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<MemoryReviewFeedbackEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMemoryReviewFeedbackEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<MemoryReviewFeedbackEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMemoryReviewFeedbackEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(MemoryReviewFeedbackEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMemoryReviewFeedbackEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(MemoryReviewFeedbackEntityOld r3) {
        return delete2((MemoryReviewFeedbackEntityOld) ZeusTransformUtils.preCheckCast(r3, MemoryReviewFeedbackEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return af.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return af.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(MemoryReviewFeedbackEntityOld r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryReviewFeedbackEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(MemoryReviewFeedbackEntityOld r3) {
        return insert2((MemoryReviewFeedbackEntityOld) ZeusTransformUtils.preCheckCast(r3, MemoryReviewFeedbackEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<MemoryReviewFeedbackEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryReviewFeedbackEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryReviewFeedbackEntityOld> queryAll() {
        return af.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return af.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryReviewFeedbackEntityOld queryById(long r1) {
        return af.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryReviewFeedbackEntityOld queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryReviewFeedbackEntityOld> queryByIds(List<Long> r3) {
        return af.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryReviewFeedbackEntityOld queryByUUID(String r1) {
        return af.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryReviewFeedbackEntityOld queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryReviewFeedbackEntityOld queryOne() {
        return af.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryReviewFeedbackEntityOld queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryReviewFeedbackEntityOld> queryWithLimitAndOffset(int r1, int r2) {
        return af.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryReviewFeedbackEntityOld> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityMemoryReviewFeedbackEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(MemoryReviewFeedbackEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMemoryReviewFeedbackEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(MemoryReviewFeedbackEntityOld r3) {
        return update2((MemoryReviewFeedbackEntityOld) ZeusTransformUtils.preCheckCast(r3, MemoryReviewFeedbackEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<MemoryReviewFeedbackEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMemoryReviewFeedbackEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
