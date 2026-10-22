package com.obric.memorydata.database.legacy.backup.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.legacy.entity.AutoMemoryProSlmEpisodicMemoryEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class BackUpAutoMemoryProSlmEpisodicMemoryDaoOld_Impl implements d {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.d> __deletionAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.d> __insertionAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.d> __insertionAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld_1;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.d> __updateAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld;

    public BackUpAutoMemoryProSlmEpisodicMemoryDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld = new AnonymousClass3(this, r2);
        this.__updateAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld = new AnonymousClass4(this, r2);
    }

    private com.obric.memorydata.database.legacy.backup.a.d __entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpAutoMemoryProSlmEpisodicMemoryEntityOld(Cursor r44) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r44, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "backupUserId");
        int r3 = CursorUtil.getColumnIndex(r0, "backupDbVersion");
        int r4 = CursorUtil.getColumnIndex(r0, "backup_id");
        int r5 = CursorUtil.getColumnIndex(r0, "backup_data");
        int r6 = CursorUtil.getColumnIndex(r0, "backup_targetRuleId");
        int r7 = CursorUtil.getColumnIndex(r0, "backup_createTimestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "backup_userActionTimestamp");
        int r9 = CursorUtil.getColumnIndex(r0, "backup_location");
        int r10 = CursorUtil.getColumnIndex(r0, "backup_locationState");
        int r11 = CursorUtil.getColumnIndex(r0, "backup_packageNames");
        int r12 = CursorUtil.getColumnIndex(r0, "backup_retryCount");
        int r13 = CursorUtil.getColumnIndex(r0, "backup_stepState");
        int r14 = CursorUtil.getColumnIndex(r0, "backup_enableState");
        int r15 = CursorUtil.getColumnIndex(r0, "backup_batch_id");
        int r16 = CursorUtil.getColumnIndex(r0, "backup_personalDbSplitMigrated");
        long r17 = 0;
        if (r1 != (-1)) goto L5;
        long r21 = 0;
    L6:
        String r18 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r24 = null;
    L13:
        boolean r19 = false;
        if (r3 != (-1)) goto L16;
        int r25 = 0;
    L17:
        if (r4 != (-1)) goto L19;
        long r27 = 0;
    L20:
        if (r5 != (-1)) goto L23;
    L21:
        String r29 = null;
    L26:
        if (r6 != (-1)) goto L29;
    L27:
        String r30 = null;
    L32:
        if (r7 != (-1)) goto L34;
        long r31 = 0;
    L35:
        if (r8 == (-1)) goto L38;
        r17 = r0.getLong(r8);
    L38:
        long r33 = r17;
        if (r9 != (-1)) goto L42;
    L40:
        String r35 = null;
    L45:
        if (r10 != (-1)) goto L48;
    L46:
        String r36 = null;
    L51:
        if (r11 != (-1)) goto L54;
    L52:
        String r37 = null;
    L57:
        if (r12 != (-1)) goto L59;
        int r38 = 0;
    L60:
        if (r13 != (-1)) goto L62;
        int r39 = 0;
    L63:
        if (r14 != (-1)) goto L65;
        int r40 = 0;
    L66:
        if (r43 != (-1)) goto L69;
    L67:
        String r41 = r18;
        if (r16 != (-1)) goto L75;
    L78:
        return new com.obric.memorydata.database.legacy.backup.a.d(r21, new AutoMemoryProSlmEpisodicMemoryEntityOld(r27, r29, r30, r31, r33, r35, r36, r37, r38, r39, r40, r41, r19), r24, r25);
    L75:
        if (r0.getInt(r16) == 0) goto L78;
        r19 = true;
        goto L78
    L69:
        if (r0.isNull(r43) == true) goto L67;
        r18 = r0.getString(r15);
        goto L67
    L65:
        r40 = r0.getInt(r14);
        goto L66
    L62:
        r39 = r0.getInt(r13);
        goto L63
    L59:
        r38 = r0.getInt(r12);
        goto L60
    L54:
        if (r0.isNull(r11) == true) goto L52;
        r37 = r0.getString(r11);
        goto L57
    L48:
        if (r0.isNull(r10) == true) goto L46;
        r36 = r0.getString(r10);
        goto L51
    L42:
        if (r0.isNull(r9) == true) goto L40;
        r35 = r0.getString(r9);
        goto L45
    L34:
        r31 = r0.getLong(r7);
        goto L35
    L29:
        if (r0.isNull(r6) == true) goto L27;
        r30 = r0.getString(r6);
        goto L32
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r29 = r0.getString(r5);
        goto L26
    L19:
        r27 = r0.getLong(r4);
        goto L20
    L16:
        r25 = r0.getInt(r3);
        goto L17
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r24 = r0.getString(r2);
        goto L13
    L5:
        r21 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.backup.a.d> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.backup.a.d> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(com.obric.memorydata.database.legacy.backup.a.d r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((com.obric.memorydata.database.legacy.backup.a.d) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.d.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return d.a.d(this);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public int deleteByBackupUserId(String r1) {
        return d.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return d.a.a(this);
    }

    public long insert(com.obric.memorydata.database.legacy.backup.a.d r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((com.obric.memorydata.database.legacy.backup.a.d) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.d.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.backup.a.d> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.d> queryAll() {
        return d.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return d.a.c(this);
    }

    public List<com.obric.memorydata.database.legacy.backup.a.d> queryByBackupUserId(String r1) {
        return d.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public List<com.obric.memorydata.database.legacy.backup.a.d> queryByBackupUserId(String r1, int r2, int r3) {
        return d.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.d queryById(long r1) {
        return d.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.d> queryByIds(List<Long> r3) {
        return d.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.d queryByUUID(String r1) {
        return d.a.c(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.d queryOne() {
        return d.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.d> queryWithLimitAndOffset(int r1, int r2) {
        return d.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.d> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpAutoMemoryProSlmEpisodicMemoryEntityOld(r6));     // Catch: Throwable -> L10
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

    public int update(com.obric.memorydata.database.legacy.backup.a.d r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((com.obric.memorydata.database.legacy.backup.a.d) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.d.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.backup.a.d> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBackUpAutoMemoryProSlmEpisodicMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
