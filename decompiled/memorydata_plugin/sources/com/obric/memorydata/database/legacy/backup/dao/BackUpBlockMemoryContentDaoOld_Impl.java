package com.obric.memorydata.database.legacy.backup.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.legacy.entity.BlockMemoryContentEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class BackUpBlockMemoryContentDaoOld_Impl implements g {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.g> __deletionAdapterOfBackUpBlockMemoryContentEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.g> __insertionAdapterOfBackUpBlockMemoryContentEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.g> __insertionAdapterOfBackUpBlockMemoryContentEntityOld_1;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.g> __updateAdapterOfBackUpBlockMemoryContentEntityOld;

    public BackUpBlockMemoryContentDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBackUpBlockMemoryContentEntityOld = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfBackUpBlockMemoryContentEntityOld_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfBackUpBlockMemoryContentEntityOld = new AnonymousClass3(this, r2);
        this.__updateAdapterOfBackUpBlockMemoryContentEntityOld = new AnonymousClass4(this, r2);
    }

    private com.obric.memorydata.database.legacy.backup.a.g __entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpBlockMemoryContentEntityOld(Cursor r30) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r30, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "backupUserId");
        int r3 = CursorUtil.getColumnIndex(r0, "backupDbVersion");
        int r4 = CursorUtil.getColumnIndex(r0, "backup_id");
        int r5 = CursorUtil.getColumnIndex(r0, "backup_content");
        int r6 = CursorUtil.getColumnIndex(r0, "backup_createTime");
        int r7 = CursorUtil.getColumnIndex(r0, "backup_modifyTime");
        int r8 = CursorUtil.getColumnIndex(r0, "backup_personalDbSplitMigrated");
        long r9 = 0;
        if (r1 != (-1)) goto L5;
        long r15 = 0;
    L6:
        String r10 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r18 = null;
    L13:
        boolean r11 = false;
        if (r3 != (-1)) goto L16;
        int r19 = 0;
    L17:
        if (r4 != (-1)) goto L19;
        long r21 = 0;
    L20:
        if (r5 != (-1)) goto L23;
    L21:
        String r23 = r10;
        if (r6 != (-1)) goto L28;
        long r24 = 0;
    L29:
        if (r7 == (-1)) goto L32;
        r9 = r0.getLong(r7);
    L32:
        long r26 = r9;
        if (r8 != (-1)) goto L36;
    L39:
        return new com.obric.memorydata.database.legacy.backup.a.g(r15, new BlockMemoryContentEntityOld(r21, r23, r24, r26, r11), r18, r19);
    L36:
        if (r0.getInt(r8) == 0) goto L39;
        r11 = true;
        goto L39
    L28:
        r24 = r0.getLong(r6);
        goto L29
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r10 = r0.getString(r5);
        goto L21
    L19:
        r21 = r0.getLong(r4);
        goto L20
    L16:
        r19 = r0.getInt(r3);
        goto L17
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r18 = r0.getString(r2);
        goto L13
    L5:
        r15 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.backup.a.g> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBackUpBlockMemoryContentEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.backup.a.g> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBackUpBlockMemoryContentEntityOld_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(com.obric.memorydata.database.legacy.backup.a.g r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBackUpBlockMemoryContentEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((com.obric.memorydata.database.legacy.backup.a.g) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.g.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return g.a.d(this);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public int deleteByBackupUserId(String r1) {
        return g.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return g.a.a(this);
    }

    public long insert(com.obric.memorydata.database.legacy.backup.a.g r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBackUpBlockMemoryContentEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((com.obric.memorydata.database.legacy.backup.a.g) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.g.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.backup.a.g> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBackUpBlockMemoryContentEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.g> queryAll() {
        return g.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return g.a.c(this);
    }

    public List<com.obric.memorydata.database.legacy.backup.a.g> queryByBackupUserId(String r1) {
        return g.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public List<com.obric.memorydata.database.legacy.backup.a.g> queryByBackupUserId(String r1, int r2, int r3) {
        return g.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.g queryById(long r1) {
        return g.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.g> queryByIds(List<Long> r3) {
        return g.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.g queryByUUID(String r1) {
        return g.a.c(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.g queryOne() {
        return g.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.g> queryWithLimitAndOffset(int r1, int r2) {
        return g.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.g> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpBlockMemoryContentEntityOld(r6));     // Catch: Throwable -> L10
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

    public int update(com.obric.memorydata.database.legacy.backup.a.g r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBackUpBlockMemoryContentEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((com.obric.memorydata.database.legacy.backup.a.g) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.g.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.backup.a.g> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBackUpBlockMemoryContentEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
