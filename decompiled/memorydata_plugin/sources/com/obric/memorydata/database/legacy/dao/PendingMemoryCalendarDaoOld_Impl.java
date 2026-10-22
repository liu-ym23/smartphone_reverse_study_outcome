package com.obric.memorydata.database.legacy.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.legacy.entity.PendingMemoryCalendarOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class PendingMemoryCalendarDaoOld_Impl implements ak {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PendingMemoryCalendarOld> __deletionAdapterOfPendingMemoryCalendarOld;
    private final EntityInsertionAdapter<PendingMemoryCalendarOld> __insertionAdapterOfPendingMemoryCalendarOld;
    private final EntityDeletionOrUpdateAdapter<PendingMemoryCalendarOld> __updateAdapterOfPendingMemoryCalendarOld;

    public PendingMemoryCalendarDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfPendingMemoryCalendarOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfPendingMemoryCalendarOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfPendingMemoryCalendarOld = new AnonymousClass3(this, r2);
    }

    private PendingMemoryCalendarOld __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityPendingMemoryCalendarOld(Cursor r35) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r35, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "title");
        int r3 = CursorUtil.getColumnIndex(r0, "location");
        int r4 = CursorUtil.getColumnIndex(r0, "eventType");
        int r5 = CursorUtil.getColumnIndex(r0, "description");
        int r6 = CursorUtil.getColumnIndex(r0, "dtstart");
        int r7 = CursorUtil.getColumnIndex(r0, "dtend");
        int r8 = CursorUtil.getColumnIndex(r0, "rrule");
        int r9 = CursorUtil.getColumnIndex(r0, "sourceAppPackage");
        int r10 = CursorUtil.getColumnIndex(r0, "sourceAppName");
        int r11 = CursorUtil.getColumnIndex(r0, "memoryUuid");
        int r12 = CursorUtil.getColumnIndex(r0, "entityType");
        int r13 = CursorUtil.getColumnIndex(r0, "status");
        int r14 = CursorUtil.getColumnIndex(r0, "personalDbSplitMigrated");
        if (r1 != (-1)) goto L5;
        long r16 = 0;
    L6:
        long r19 = r16;
        Integer r15 = null;
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
        Long r25 = null;
    L37:
        if (r7 != (-1)) goto L40;
    L38:
        Long r26 = null;
    L43:
        if (r8 != (-1)) goto L46;
    L44:
        String r27 = null;
    L49:
        if (r9 != (-1)) goto L52;
    L50:
        String r28 = null;
    L55:
        if (r10 != (-1)) goto L58;
    L56:
        String r29 = null;
    L61:
        if (r11 != (-1)) goto L64;
    L62:
        String r30 = null;
    L67:
        if (r12 != (-1)) goto L70;
    L68:
        Integer r31 = r15;
        boolean r17 = false;
        if (r13 != (-1)) goto L76;
        int r32 = 0;
    L77:
        if (r14 != (-1)) goto L80;
    L83:
        return new PendingMemoryCalendarOld(r19, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r17);
    L80:
        if (r0.getInt(r14) == 0) goto L83;
        r17 = true;
        goto L83
    L76:
        r32 = r0.getInt(r13);
        goto L77
    L70:
        if (r0.isNull(r12) == true) goto L68;
        r15 = Integer.valueOf(r0.getInt(r12));
        goto L68
    L64:
        if (r0.isNull(r11) == true) goto L62;
        r30 = r0.getString(r11);
        goto L67
    L58:
        if (r0.isNull(r10) == true) goto L56;
        r29 = r0.getString(r10);
        goto L61
    L52:
        if (r0.isNull(r9) == true) goto L50;
        r28 = r0.getString(r9);
        goto L55
    L46:
        if (r0.isNull(r8) == true) goto L44;
        r27 = r0.getString(r8);
        goto L49
    L40:
        if (r0.isNull(r7) == true) goto L38;
        r26 = Long.valueOf(r0.getLong(r7));
        goto L43
    L34:
        if (r0.isNull(r6) == true) goto L32;
        r25 = Long.valueOf(r0.getLong(r6));
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
        r16 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<PendingMemoryCalendarOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfPendingMemoryCalendarOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<PendingMemoryCalendarOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPendingMemoryCalendarOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(PendingMemoryCalendarOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfPendingMemoryCalendarOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(PendingMemoryCalendarOld r3) {
        return delete2((PendingMemoryCalendarOld) ZeusTransformUtils.preCheckCast(r3, PendingMemoryCalendarOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ak.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ak.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(PendingMemoryCalendarOld r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfPendingMemoryCalendarOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(PendingMemoryCalendarOld r3) {
        return insert2((PendingMemoryCalendarOld) ZeusTransformUtils.preCheckCast(r3, PendingMemoryCalendarOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<PendingMemoryCalendarOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfPendingMemoryCalendarOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PendingMemoryCalendarOld> queryAll() {
        return ak.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ak.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PendingMemoryCalendarOld queryById(long r1) {
        return ak.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PendingMemoryCalendarOld queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PendingMemoryCalendarOld> queryByIds(List<Long> r3) {
        return ak.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PendingMemoryCalendarOld queryByUUID(String r1) {
        return ak.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PendingMemoryCalendarOld queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PendingMemoryCalendarOld queryOne() {
        return ak.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PendingMemoryCalendarOld queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PendingMemoryCalendarOld> queryWithLimitAndOffset(int r1, int r2) {
        return ak.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PendingMemoryCalendarOld> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityPendingMemoryCalendarOld(r6));     // Catch: Throwable -> L10
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
    public int update2(PendingMemoryCalendarOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfPendingMemoryCalendarOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(PendingMemoryCalendarOld r3) {
        return update2((PendingMemoryCalendarOld) ZeusTransformUtils.preCheckCast(r3, PendingMemoryCalendarOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<PendingMemoryCalendarOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfPendingMemoryCalendarOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
