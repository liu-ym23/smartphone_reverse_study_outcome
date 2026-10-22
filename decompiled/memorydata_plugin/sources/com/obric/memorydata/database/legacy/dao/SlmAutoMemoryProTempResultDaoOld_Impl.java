package com.obric.memorydata.database.legacy.dao;

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
public final class SlmAutoMemoryProTempResultDaoOld_Impl implements as {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<SlmAutoMemoryProTempResultEntityOld> __deletionAdapterOfSlmAutoMemoryProTempResultEntityOld;
    private final EntityInsertionAdapter<SlmAutoMemoryProTempResultEntityOld> __insertionAdapterOfSlmAutoMemoryProTempResultEntityOld;
    private final EntityDeletionOrUpdateAdapter<SlmAutoMemoryProTempResultEntityOld> __updateAdapterOfSlmAutoMemoryProTempResultEntityOld;

    public SlmAutoMemoryProTempResultDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfSlmAutoMemoryProTempResultEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfSlmAutoMemoryProTempResultEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfSlmAutoMemoryProTempResultEntityOld = new AnonymousClass3(this, r2);
    }

    private SlmAutoMemoryProTempResultEntityOld __entityCursorConverter_comObricMemorydataDatabaseLegacyEntitySlmAutoMemoryProTempResultEntityOld(Cursor r26) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r26, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "batch_id");
        int r3 = CursorUtil.getColumnIndex(r0, "ruleId");
        int r4 = CursorUtil.getColumnIndex(r0, "app_packges");
        int r5 = CursorUtil.getColumnIndex(r0, "enable_index");
        int r6 = CursorUtil.getColumnIndex(r0, "timeStamp");
        int r7 = CursorUtil.getColumnIndex(r0, "data");
        int r8 = CursorUtil.getColumnIndex(r0, "personalDbSplitMigrated");
        long r9 = 0;
        if (r1 != (-1)) goto L5;
        long r15 = 0;
    L6:
        String r10 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r17 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r18 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r19 = null;
    L25:
        boolean r11 = false;
        if (r5 != (-1)) goto L28;
        int r20 = 0;
    L29:
        if (r6 == (-1)) goto L32;
        r9 = r0.getLong(r6);
    L32:
        long r21 = r9;
        if (r7 != (-1)) goto L36;
    L34:
        String r23 = r10;
        if (r8 != (-1)) goto L42;
    L45:
        return new SlmAutoMemoryProTempResultEntityOld(r15, r17, r18, r19, r20, r21, r23, r11);
    L42:
        if (r0.getInt(r8) == 0) goto L45;
        r11 = true;
        goto L45
    L36:
        if (r0.isNull(r7) == true) goto L34;
        r10 = r0.getString(r7);
        goto L34
    L28:
        r20 = r0.getInt(r5);
        goto L29
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r19 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r18 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r17 = r0.getString(r2);
        goto L13
    L5:
        r15 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<SlmAutoMemoryProTempResultEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfSlmAutoMemoryProTempResultEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<SlmAutoMemoryProTempResultEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfSlmAutoMemoryProTempResultEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(SlmAutoMemoryProTempResultEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfSlmAutoMemoryProTempResultEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(SlmAutoMemoryProTempResultEntityOld r3) {
        return delete2((SlmAutoMemoryProTempResultEntityOld) ZeusTransformUtils.preCheckCast(r3, SlmAutoMemoryProTempResultEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return as.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return as.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(SlmAutoMemoryProTempResultEntityOld r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfSlmAutoMemoryProTempResultEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(SlmAutoMemoryProTempResultEntityOld r3) {
        return insert2((SlmAutoMemoryProTempResultEntityOld) ZeusTransformUtils.preCheckCast(r3, SlmAutoMemoryProTempResultEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<SlmAutoMemoryProTempResultEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfSlmAutoMemoryProTempResultEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<SlmAutoMemoryProTempResultEntityOld> queryAll() {
        return as.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return as.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public SlmAutoMemoryProTempResultEntityOld queryById(long r1) {
        return as.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ SlmAutoMemoryProTempResultEntityOld queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<SlmAutoMemoryProTempResultEntityOld> queryByIds(List<Long> r3) {
        return as.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public SlmAutoMemoryProTempResultEntityOld queryByUUID(String r1) {
        return as.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ SlmAutoMemoryProTempResultEntityOld queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public SlmAutoMemoryProTempResultEntityOld queryOne() {
        return as.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ SlmAutoMemoryProTempResultEntityOld queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<SlmAutoMemoryProTempResultEntityOld> queryWithLimitAndOffset(int r1, int r2) {
        return as.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<SlmAutoMemoryProTempResultEntityOld> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntitySlmAutoMemoryProTempResultEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(SlmAutoMemoryProTempResultEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfSlmAutoMemoryProTempResultEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(SlmAutoMemoryProTempResultEntityOld r3) {
        return update2((SlmAutoMemoryProTempResultEntityOld) ZeusTransformUtils.preCheckCast(r3, SlmAutoMemoryProTempResultEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<SlmAutoMemoryProTempResultEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfSlmAutoMemoryProTempResultEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
