package com.obric.memorydata.database.legacy.backup.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.legacy.entity.SlmAutoMemoryProTempResultEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class BackUpSlmAutoMemoryProTempResultDaoOld_Impl implements t {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.t> __deletionAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.t> __insertionAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.t> __insertionAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld_1;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.t> __updateAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld;

    public BackUpSlmAutoMemoryProTempResultDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld = new AnonymousClass3(this, r2);
        this.__updateAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld = new AnonymousClass4(this, r2);
    }

    private com.obric.memorydata.database.legacy.backup.a.t __entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpSlmAutoMemoryProTempResultEntityOld(Cursor r35) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r35, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "backupUserId");
        int r3 = CursorUtil.getColumnIndex(r0, "backupDbVersion");
        int r4 = CursorUtil.getColumnIndex(r0, "backup_id");
        int r5 = CursorUtil.getColumnIndex(r0, "backup_batch_id");
        int r6 = CursorUtil.getColumnIndex(r0, "backup_ruleId");
        int r7 = CursorUtil.getColumnIndex(r0, "backup_app_packges");
        int r8 = CursorUtil.getColumnIndex(r0, "backup_enable_index");
        int r9 = CursorUtil.getColumnIndex(r0, "backup_timeStamp");
        int r10 = CursorUtil.getColumnIndex(r0, "backup_data");
        int r11 = CursorUtil.getColumnIndex(r0, "backup_personalDbSplitMigrated");
        long r12 = 0;
        if (r1 != (-1)) goto L5;
        long r18 = 0;
    L6:
        String r13 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r21 = null;
    L13:
        boolean r14 = false;
        if (r3 != (-1)) goto L16;
        int r22 = 0;
    L17:
        if (r4 != (-1)) goto L19;
        long r24 = 0;
    L20:
        if (r5 != (-1)) goto L23;
    L21:
        String r26 = null;
    L26:
        if (r6 != (-1)) goto L29;
    L27:
        String r27 = null;
    L32:
        if (r7 != (-1)) goto L35;
    L33:
        String r28 = null;
    L38:
        if (r8 != (-1)) goto L40;
        int r29 = 0;
    L41:
        if (r9 == (-1)) goto L44;
        r12 = r0.getLong(r9);
    L44:
        long r30 = r12;
        if (r10 != (-1)) goto L48;
    L46:
        String r32 = r13;
        if (r11 != (-1)) goto L54;
    L57:
        return new com.obric.memorydata.database.legacy.backup.a.t(r18, new SlmAutoMemoryProTempResultEntityOld(r24, r26, r27, r28, r29, r30, r32, r14), r21, r22);
    L54:
        if (r0.getInt(r11) == 0) goto L57;
        r14 = true;
        goto L57
    L48:
        if (r0.isNull(r10) == true) goto L46;
        r13 = r0.getString(r10);
        goto L46
    L40:
        r29 = r0.getInt(r8);
        goto L41
    L35:
        if (r0.isNull(r7) == true) goto L33;
        r28 = r0.getString(r7);
        goto L38
    L29:
        if (r0.isNull(r6) == true) goto L27;
        r27 = r0.getString(r6);
        goto L32
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r26 = r0.getString(r5);
        goto L26
    L19:
        r24 = r0.getLong(r4);
        goto L20
    L16:
        r22 = r0.getInt(r3);
        goto L17
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r21 = r0.getString(r2);
        goto L13
    L5:
        r18 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.backup.a.t> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.backup.a.t> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(com.obric.memorydata.database.legacy.backup.a.t r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((com.obric.memorydata.database.legacy.backup.a.t) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.t.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return t.a.d(this);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public int deleteByBackupUserId(String r1) {
        return t.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return t.a.a(this);
    }

    public long insert(com.obric.memorydata.database.legacy.backup.a.t r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((com.obric.memorydata.database.legacy.backup.a.t) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.t.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.backup.a.t> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.t> queryAll() {
        return t.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return t.a.c(this);
    }

    public List<com.obric.memorydata.database.legacy.backup.a.t> queryByBackupUserId(String r1) {
        return t.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public List<com.obric.memorydata.database.legacy.backup.a.t> queryByBackupUserId(String r1, int r2, int r3) {
        return t.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.t queryById(long r1) {
        return t.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.t> queryByIds(List<Long> r3) {
        return t.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.t queryByUUID(String r1) {
        return t.a.c(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.t queryOne() {
        return t.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.t> queryWithLimitAndOffset(int r1, int r2) {
        return t.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.t> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpSlmAutoMemoryProTempResultEntityOld(r6));     // Catch: Throwable -> L10
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

    public int update(com.obric.memorydata.database.legacy.backup.a.t r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((com.obric.memorydata.database.legacy.backup.a.t) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.t.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.backup.a.t> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBackUpSlmAutoMemoryProTempResultEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
