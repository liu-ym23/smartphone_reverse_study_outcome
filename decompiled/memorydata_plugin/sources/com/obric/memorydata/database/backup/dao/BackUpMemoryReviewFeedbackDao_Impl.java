package com.obric.memorydata.database.backup.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.db;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class BackUpMemoryReviewFeedbackDao_Impl implements b {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.backup.a.c> __deletionAdapterOfBackUpMemoryReviewFeedbackEntity;
    private final EntityInsertionAdapter<com.obric.memorydata.database.backup.a.c> __insertionAdapterOfBackUpMemoryReviewFeedbackEntity;
    private final EntityInsertionAdapter<com.obric.memorydata.database.backup.a.c> __insertionAdapterOfBackUpMemoryReviewFeedbackEntity_1;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.backup.a.c> __updateAdapterOfBackUpMemoryReviewFeedbackEntity;

    public BackUpMemoryReviewFeedbackDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBackUpMemoryReviewFeedbackEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfBackUpMemoryReviewFeedbackEntity_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfBackUpMemoryReviewFeedbackEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfBackUpMemoryReviewFeedbackEntity = new AnonymousClass4(this, r2);
    }

    private com.obric.memorydata.database.backup.a.c __entityCursorConverter_comObricMemorydataDatabaseBackupEntityBackUpMemoryReviewFeedbackEntity(Cursor r48) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r48, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "backupUserId");
        int r3 = CursorUtil.getColumnIndex(r0, "backupDbVersion");
        int r4 = CursorUtil.getColumnIndex(r0, "backup_id");
        int r5 = CursorUtil.getColumnIndex(r0, "backup_record_id");
        int r6 = CursorUtil.getColumnIndex(r0, "backup_module");
        int r7 = CursorUtil.getColumnIndex(r0, "backup_vote");
        int r8 = CursorUtil.getColumnIndex(r0, "backup_reasons_json");
        int r9 = CursorUtil.getColumnIndex(r0, "backup_comment");
        int r10 = CursorUtil.getColumnIndex(r0, "backup_displayed_card_json");
        int r11 = CursorUtil.getColumnIndex(r0, "backup_status");
        int r12 = CursorUtil.getColumnIndex(r0, "backup_error");
        int r13 = CursorUtil.getColumnIndex(r0, "backup_trace_json");
        int r14 = CursorUtil.getColumnIndex(r0, "backup_update_time");
        int r15 = CursorUtil.getColumnIndex(r0, "backup_server_uniq_id");
        int r16 = CursorUtil.getColumnIndex(r0, "backup_server_status");
        int r17 = CursorUtil.getColumnIndex(r0, "backup_server_error");
        int r18 = CursorUtil.getColumnIndex(r0, "backup_server_update_time");
        long r19 = 0;
        if (r1 != (-1)) goto L5;
        long r23 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r26 = null;
    L13:
        if (r3 != (-1)) goto L15;
        int r21 = 0;
    L16:
        int r27 = r21;
        if (r4 != (-1)) goto L19;
        long r29 = 0;
    L20:
        if (r5 != (-1)) goto L23;
    L21:
        String r31 = null;
    L26:
        if (r6 != (-1)) goto L29;
    L27:
        String r32 = null;
    L32:
        if (r7 != (-1)) goto L35;
    L33:
        String r33 = null;
    L38:
        if (r8 != (-1)) goto L41;
    L39:
        String r34 = null;
    L44:
        if (r9 != (-1)) goto L47;
    L45:
        String r35 = null;
    L50:
        if (r10 != (-1)) goto L53;
    L51:
        String r36 = null;
    L56:
        if (r11 != (-1)) goto L59;
    L57:
        String r37 = null;
    L62:
        if (r12 != (-1)) goto L65;
    L63:
        String r38 = null;
    L68:
        if (r13 != (-1)) goto L71;
    L69:
        String r39 = null;
    L74:
        if (r14 != (-1)) goto L76;
        long r40 = 0;
    L77:
        if (r47 != (-1)) goto L80;
    L78:
        String r42 = null;
    L83:
        if (r48 != (-1)) goto L87;
    L84:
        String r43 = null;
    L90:
        if (r17 != (-1)) goto L93;
    L91:
        String r44 = r20;
        if (r18 == (-1)) goto L100;
        r19 = r0.getLong(r18);
    L100:
        return new com.obric.memorydata.database.backup.a.c(r23, new db(r29, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r42, r43, r44, r19), r26, r27);
    L93:
        if (r0.isNull(r17) == true) goto L91;
        r20 = r0.getString(r17);
        goto L91
    L87:
        if (r0.isNull(r48) == true) goto L84;
        r43 = r0.getString(r16);
        goto L90
    L80:
        if (r0.isNull(r47) == true) goto L78;
        r42 = r0.getString(r15);
        goto L83
    L76:
        r40 = r0.getLong(r14);
        goto L77
    L71:
        if (r0.isNull(r13) == true) goto L69;
        r39 = r0.getString(r13);
        goto L74
    L65:
        if (r0.isNull(r12) == true) goto L63;
        r38 = r0.getString(r12);
        goto L68
    L59:
        if (r0.isNull(r11) == true) goto L57;
        r37 = r0.getString(r11);
        goto L62
    L53:
        if (r0.isNull(r10) == true) goto L51;
        r36 = r0.getString(r10);
        goto L56
    L47:
        if (r0.isNull(r9) == true) goto L45;
        r35 = r0.getString(r9);
        goto L50
    L41:
        if (r0.isNull(r8) == true) goto L39;
        r34 = r0.getString(r8);
        goto L44
    L35:
        if (r0.isNull(r7) == true) goto L33;
        r33 = r0.getString(r7);
        goto L38
    L29:
        if (r0.isNull(r6) == true) goto L27;
        r32 = r0.getString(r6);
        goto L32
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r31 = r0.getString(r5);
        goto L26
    L19:
        r29 = r0.getLong(r4);
        goto L20
    L15:
        r21 = r0.getInt(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r26 = r0.getString(r2);
        goto L13
    L5:
        r23 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.backup.a.c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBackUpMemoryReviewFeedbackEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.backup.a.c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBackUpMemoryReviewFeedbackEntity_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(com.obric.memorydata.database.backup.a.c r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBackUpMemoryReviewFeedbackEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(Object r3) {
        return delete((com.obric.memorydata.database.backup.a.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.backup.a.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return b.a.d(this);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public int deleteByBackupUserId(String r1) {
        return b.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return b.a.a(this);
    }

    public long insert(com.obric.memorydata.database.backup.a.c r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBackUpMemoryReviewFeedbackEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(Object r3) {
        return insert((com.obric.memorydata.database.backup.a.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.backup.a.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.backup.a.c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBackUpMemoryReviewFeedbackEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.backup.a.c> queryAll() {
        return b.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return b.a.c(this);
    }

    public List<com.obric.memorydata.database.backup.a.c> queryByBackupUserId(String r1) {
        return b.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public List<com.obric.memorydata.database.backup.a.c> queryByBackupUserId(String r1, int r2, int r3) {
        return b.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.backup.a.c queryById(long r1) {
        return b.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.backup.a.c> queryByIds(List<Long> r3) {
        return b.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.backup.a.c queryByUUID(String r1) {
        return b.a.c(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.backup.a.c queryOne() {
        return b.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.backup.a.c> queryWithLimitAndOffset(int r1, int r2) {
        return b.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.backup.a.c> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseBackupEntityBackUpMemoryReviewFeedbackEntity(r6));     // Catch: Throwable -> L10
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

    public int update(com.obric.memorydata.database.backup.a.c r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBackUpMemoryReviewFeedbackEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(Object r3) {
        return update((com.obric.memorydata.database.backup.a.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.backup.a.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.backup.a.c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBackUpMemoryReviewFeedbackEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
