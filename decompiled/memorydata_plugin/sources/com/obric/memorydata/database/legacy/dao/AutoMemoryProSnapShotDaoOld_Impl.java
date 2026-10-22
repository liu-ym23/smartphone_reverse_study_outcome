package com.obric.memorydata.database.legacy.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.legacy.entity.AutoMemoryProSnapShotEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoMemoryProSnapShotDaoOld_Impl implements k {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<AutoMemoryProSnapShotEntityOld> __deletionAdapterOfAutoMemoryProSnapShotEntityOld;
    private final EntityInsertionAdapter<AutoMemoryProSnapShotEntityOld> __insertionAdapterOfAutoMemoryProSnapShotEntityOld;
    private final EntityDeletionOrUpdateAdapter<AutoMemoryProSnapShotEntityOld> __updateAdapterOfAutoMemoryProSnapShotEntityOld;

    public AutoMemoryProSnapShotDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAutoMemoryProSnapShotEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfAutoMemoryProSnapShotEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfAutoMemoryProSnapShotEntityOld = new AnonymousClass3(this, r2);
    }

    private AutoMemoryProSnapShotEntityOld __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityAutoMemoryProSnapShotEntityOld(Cursor r25) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r25, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_id");
        int r3 = CursorUtil.getColumnIndex(r0, "entity_id");
        int r4 = CursorUtil.getColumnIndex(r0, "version");
        int r5 = CursorUtil.getColumnIndex(r0, "snapshot_json");
        int r6 = CursorUtil.getColumnIndex(r0, "snapshot_time");
        int r7 = CursorUtil.getColumnIndex(r0, "personalDbSplitMigrated");
        long r8 = 0;
        if (r1 != (-1)) goto L5;
        long r14 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r16 = 0;
    L9:
        String r9 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r18 = null;
    L16:
        boolean r10 = false;
        if (r4 != (-1)) goto L19;
        int r19 = 0;
    L20:
        if (r5 != (-1)) goto L23;
    L21:
        String r20 = r9;
        if (r6 == (-1)) goto L29;
        r8 = r0.getLong(r6);
    L29:
        long r21 = r8;
        if (r7 != (-1)) goto L33;
    L36:
        return new AutoMemoryProSnapShotEntityOld(r14, r16, r18, r19, r20, r21, r10);
    L33:
        if (r0.getInt(r7) == 0) goto L36;
        r10 = true;
        goto L36
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r9 = r0.getString(r5);
        goto L21
    L19:
        r19 = r0.getInt(r4);
        goto L20
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r18 = r0.getString(r3);
        goto L16
    L8:
        r16 = r0.getLong(r2);
        goto L9
    L5:
        r14 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<AutoMemoryProSnapShotEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAutoMemoryProSnapShotEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<AutoMemoryProSnapShotEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAutoMemoryProSnapShotEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(AutoMemoryProSnapShotEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAutoMemoryProSnapShotEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(AutoMemoryProSnapShotEntityOld r3) {
        return delete2((AutoMemoryProSnapShotEntityOld) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProSnapShotEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return k.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return k.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(AutoMemoryProSnapShotEntityOld r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAutoMemoryProSnapShotEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(AutoMemoryProSnapShotEntityOld r3) {
        return insert2((AutoMemoryProSnapShotEntityOld) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProSnapShotEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<AutoMemoryProSnapShotEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAutoMemoryProSnapShotEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProSnapShotEntityOld> queryAll() {
        return k.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return k.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProSnapShotEntityOld queryById(long r1) {
        return k.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AutoMemoryProSnapShotEntityOld queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProSnapShotEntityOld> queryByIds(List<Long> r3) {
        return k.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProSnapShotEntityOld queryByUUID(String r1) {
        return k.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AutoMemoryProSnapShotEntityOld queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProSnapShotEntityOld queryOne() {
        return k.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AutoMemoryProSnapShotEntityOld queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProSnapShotEntityOld> queryWithLimitAndOffset(int r1, int r2) {
        return k.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProSnapShotEntityOld> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityAutoMemoryProSnapShotEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(AutoMemoryProSnapShotEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAutoMemoryProSnapShotEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(AutoMemoryProSnapShotEntityOld r3) {
        return update2((AutoMemoryProSnapShotEntityOld) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProSnapShotEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<AutoMemoryProSnapShotEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAutoMemoryProSnapShotEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
