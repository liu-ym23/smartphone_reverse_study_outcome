package com.obric.memorydata.database.legacy.dao;

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
public final class AutoMemoryProSlmEpisodicMemoryDaoOld_Impl implements i {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<AutoMemoryProSlmEpisodicMemoryEntityOld> __deletionAdapterOfAutoMemoryProSlmEpisodicMemoryEntityOld;
    private final EntityInsertionAdapter<AutoMemoryProSlmEpisodicMemoryEntityOld> __insertionAdapterOfAutoMemoryProSlmEpisodicMemoryEntityOld;
    private final EntityDeletionOrUpdateAdapter<AutoMemoryProSlmEpisodicMemoryEntityOld> __updateAdapterOfAutoMemoryProSlmEpisodicMemoryEntityOld;

    public AutoMemoryProSlmEpisodicMemoryDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAutoMemoryProSlmEpisodicMemoryEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfAutoMemoryProSlmEpisodicMemoryEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfAutoMemoryProSlmEpisodicMemoryEntityOld = new AnonymousClass3(this, r2);
    }

    private AutoMemoryProSlmEpisodicMemoryEntityOld __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityAutoMemoryProSlmEpisodicMemoryEntityOld(Cursor r35) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r35, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "data");
        int r3 = CursorUtil.getColumnIndex(r0, "targetRuleId");
        int r4 = CursorUtil.getColumnIndex(r0, "createTimestamp");
        int r5 = CursorUtil.getColumnIndex(r0, "userActionTimestamp");
        int r6 = CursorUtil.getColumnIndex(r0, "location");
        int r7 = CursorUtil.getColumnIndex(r0, "locationState");
        int r8 = CursorUtil.getColumnIndex(r0, "packageNames");
        int r9 = CursorUtil.getColumnIndex(r0, "retryCount");
        int r10 = CursorUtil.getColumnIndex(r0, "stepState");
        int r11 = CursorUtil.getColumnIndex(r0, "enableState");
        int r12 = CursorUtil.getColumnIndex(r0, "batch_id");
        int r13 = CursorUtil.getColumnIndex(r0, "personalDbSplitMigrated");
        if (r1 != (-1)) goto L5;
        long r18 = 0;
    L6:
        String r14 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r20 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r21 = null;
    L19:
        if (r4 != (-1)) goto L21;
        long r22 = 0;
    L22:
        if (r5 != (-1)) goto L24;
        long r24 = 0;
    L25:
        if (r6 != (-1)) goto L28;
    L26:
        String r26 = null;
    L31:
        if (r7 != (-1)) goto L34;
    L32:
        String r27 = null;
    L37:
        if (r8 != (-1)) goto L40;
    L38:
        String r28 = null;
    L43:
        boolean r15 = false;
        if (r9 != (-1)) goto L46;
        int r29 = 0;
    L47:
        if (r10 != (-1)) goto L49;
        int r30 = 0;
    L50:
        if (r11 != (-1)) goto L52;
        int r31 = 0;
    L53:
        if (r12 != (-1)) goto L56;
    L54:
        String r32 = r14;
        if (r13 != (-1)) goto L62;
    L65:
        return new AutoMemoryProSlmEpisodicMemoryEntityOld(r18, r20, r21, r22, r24, r26, r27, r28, r29, r30, r31, r32, r15);
    L62:
        if (r0.getInt(r13) == 0) goto L65;
        r15 = true;
        goto L65
    L56:
        if (r0.isNull(r12) == true) goto L54;
        r14 = r0.getString(r12);
        goto L54
    L52:
        r31 = r0.getInt(r11);
        goto L53
    L49:
        r30 = r0.getInt(r10);
        goto L50
    L46:
        r29 = r0.getInt(r9);
        goto L47
    L40:
        if (r0.isNull(r8) == true) goto L38;
        r28 = r0.getString(r8);
        goto L43
    L34:
        if (r0.isNull(r7) == true) goto L32;
        r27 = r0.getString(r7);
        goto L37
    L28:
        if (r0.isNull(r6) == true) goto L26;
        r26 = r0.getString(r6);
        goto L31
    L24:
        r24 = r0.getLong(r5);
        goto L25
    L21:
        r22 = r0.getLong(r4);
        goto L22
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r21 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r20 = r0.getString(r2);
        goto L13
    L5:
        r18 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<AutoMemoryProSlmEpisodicMemoryEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAutoMemoryProSlmEpisodicMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<AutoMemoryProSlmEpisodicMemoryEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAutoMemoryProSlmEpisodicMemoryEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(AutoMemoryProSlmEpisodicMemoryEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAutoMemoryProSlmEpisodicMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(AutoMemoryProSlmEpisodicMemoryEntityOld r3) {
        return delete2((AutoMemoryProSlmEpisodicMemoryEntityOld) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProSlmEpisodicMemoryEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return i.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return i.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(AutoMemoryProSlmEpisodicMemoryEntityOld r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAutoMemoryProSlmEpisodicMemoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(AutoMemoryProSlmEpisodicMemoryEntityOld r3) {
        return insert2((AutoMemoryProSlmEpisodicMemoryEntityOld) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProSlmEpisodicMemoryEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<AutoMemoryProSlmEpisodicMemoryEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAutoMemoryProSlmEpisodicMemoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProSlmEpisodicMemoryEntityOld> queryAll() {
        return i.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return i.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProSlmEpisodicMemoryEntityOld queryById(long r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AutoMemoryProSlmEpisodicMemoryEntityOld queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProSlmEpisodicMemoryEntityOld> queryByIds(List<Long> r3) {
        return i.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProSlmEpisodicMemoryEntityOld queryByUUID(String r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AutoMemoryProSlmEpisodicMemoryEntityOld queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProSlmEpisodicMemoryEntityOld queryOne() {
        return i.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AutoMemoryProSlmEpisodicMemoryEntityOld queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProSlmEpisodicMemoryEntityOld> queryWithLimitAndOffset(int r1, int r2) {
        return i.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProSlmEpisodicMemoryEntityOld> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityAutoMemoryProSlmEpisodicMemoryEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(AutoMemoryProSlmEpisodicMemoryEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAutoMemoryProSlmEpisodicMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(AutoMemoryProSlmEpisodicMemoryEntityOld r3) {
        return update2((AutoMemoryProSlmEpisodicMemoryEntityOld) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProSlmEpisodicMemoryEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<AutoMemoryProSlmEpisodicMemoryEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAutoMemoryProSlmEpisodicMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
