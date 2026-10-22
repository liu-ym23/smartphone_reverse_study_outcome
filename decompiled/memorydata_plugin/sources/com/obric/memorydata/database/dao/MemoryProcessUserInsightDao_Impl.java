package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.da;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryProcessUserInsightDao_Impl implements MemoryProcessUserInsightDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<da> __deletionAdapterOfMemoryProcessUserInsightEntity;
    private final EntityInsertionAdapter<da> __insertionAdapterOfMemoryProcessUserInsightEntity;
    private final EntityInsertionAdapter<da> __insertionAdapterOfMemoryProcessUserInsightEntity_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final EntityDeletionOrUpdateAdapter<da> __updateAdapterOfMemoryProcessUserInsightEntity;

    public MemoryProcessUserInsightDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryProcessUserInsightEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfMemoryProcessUserInsightEntity_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfMemoryProcessUserInsightEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfMemoryProcessUserInsightEntity = new AnonymousClass4(this, r2);
        this.__preparedStmtOfDeleteAll = new AnonymousClass5(this, r2);
    }

    private da __entityCursorConverter_comObricMemorydataDatabaseEntityMemoryProcessUserInsightEntity(Cursor r33) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r33, Cursor.class, "com.obric.memorydata.plugin");
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
        long r12 = 0;
        if (r1 != (-1)) goto L5;
        long r18 = 0;
    L6:
        String r13 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r20 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r21 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r22 = null;
    L25:
        if (r5 != (-1)) goto L28;
    L26:
        String r23 = null;
    L31:
        if (r6 != (-1)) goto L34;
    L32:
        String r24 = null;
    L37:
        if (r7 != (-1)) goto L40;
    L38:
        String r25 = null;
    L43:
        boolean r14 = false;
        if (r8 != (-1)) goto L47;
    L45:
        boolean r26 = r14;
        if (r9 != (-1)) goto L52;
    L50:
        String r27 = r13;
        if (r10 != (-1)) goto L57;
        long r28 = 0;
    L58:
        if (r11 == (-1)) goto L62;
        r12 = r0.getLong(r11);
    L62:
        return new da(r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r12);
    L57:
        r28 = r0.getLong(r10);
        goto L58
    L52:
        if (r0.isNull(r9) == true) goto L50;
        r13 = r0.getString(r9);
        goto L50
    L47:
        if (r0.getInt(r8) == 0) goto L45;
        r14 = true;
        goto L45
    L40:
        if (r0.isNull(r7) == true) goto L38;
        r25 = r0.getString(r7);
        goto L43
    L34:
        if (r0.isNull(r6) == true) goto L32;
        r24 = r0.getString(r6);
        goto L37
    L28:
        if (r0.isNull(r5) == true) goto L26;
        r23 = r0.getString(r5);
        goto L31
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r22 = r0.getString(r4);
        goto L25
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
    public void bulkDelete(List<da> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMemoryProcessUserInsightEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<da> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMemoryProcessUserInsightEntity_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessUserInsightDao
    public int countUnprocessedForUnion() {
        int r1 = 0;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM MemoryProcessUserInsight WHERE processedForUnion = 0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L8:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L6;
        r1 = r3.getInt(0);     // Catch: Throwable -> L8
    L6:
        r3.close();
        r0.release();
        return r1;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(da r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMemoryProcessUserInsightEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(da r3) {
        return delete2((da) ZeusTransformUtils.preCheckCast(r3, da.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessUserInsightDao, com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessUserInsightDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MemoryProcessUserInsightDao.DefaultImpls.getTableName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.MemoryProcessUserInsightDao
    public long insert(da r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryProcessUserInsightEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(da r3) {
        return insert((da) ZeusTransformUtils.preCheckCast(r3, da.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<da> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryProcessUserInsightEntity_1.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessUserInsightDao
    public int markProcessedForUnion(List<Long> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE MemoryProcessUserInsight SET processedForUnion = 1 WHERE id IN (");
        StringUtil.appendPlaceholders(r0, r8.size());
        r0.append(")");
        SupportSQLiteStatement r1 = this.__db.compileStatement(r0.toString());
        Iterator r9 = r8.iterator();
        int r3 = 1;
    L4:
        if (r9.hasNext() == false) goto L6;
        r1.bindLong(r3, ((Long) ZeusTransformUtils.preCheckCast(r9.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r3 = r3 + 1;
        goto L4
    L6:
        this.__db.beginTransaction();
        int r10 = r1.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        return r10;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<da> queryAll() {
        return MemoryProcessUserInsightDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MemoryProcessUserInsightDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public da queryById(long r1) {
        return MemoryProcessUserInsightDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ da queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<da> queryByIds(List<Long> r3) {
        return MemoryProcessUserInsightDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public da queryByUUID(String r1) {
        return MemoryProcessUserInsightDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ da queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public da queryOne() {
        return MemoryProcessUserInsightDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ da queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessUserInsightDao
    public List<da> queryRecent(int r32) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryProcessUserInsight ORDER BY updateTime DESC LIMIT ?", 1);
        r1.bindLong(1, r32);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L42
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "profileKey");     // Catch: Throwable -> L42
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "summary");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "description");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "profileJson");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "evidenceRefs");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "sourceEventIds");     // Catch: Throwable -> L42
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "processedForUnion");     // Catch: Throwable -> L42
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L42
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L42
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "updateTime");     // Catch: Throwable -> L42
        ArrayList r2 = new ArrayList(r5.getCount());     // Catch: Throwable -> L42
    L4:
        if (r5.moveToNext() == false) goto L40;
        long r17 = r5.getLong(r0);     // Catch: Throwable -> L42
        if (r5.isNull(r6) == false) goto L9;
        String r19 = null;
    L11:
        if (r5.isNull(r7) == false) goto L13;
        String r20 = null;
    L15:
        if (r5.isNull(r8) == false) goto L17;
        String r21 = null;
    L19:
        if (r5.isNull(r9) == false) goto L21;
        String r22 = null;
    L23:
        if (r5.isNull(r10) == false) goto L25;
        String r23 = null;
    L27:
        if (r5.isNull(r11) == false) goto L29;
        String r24 = null;
    L31:
        if (r5.getInt(r12) == 0) goto L33;
        boolean r25 = true;
    L35:
        if (r5.isNull(r13) == false) goto L37;
        String r26 = null;
    L38:
        r2.add(new da(r17, r19, r20, r21, r22, r23, r24, r25, r26, r5.getLong(r14), r5.getLong(r15)));     // Catch: Throwable -> L42
        goto L4
    L37:
        r26 = r5.getString(r13);     // Catch: Throwable -> L42
        goto L38
    L33:
        r25 = false;
        goto L35
    L29:
        r24 = r5.getString(r11);     // Catch: Throwable -> L42
        goto L31
    L25:
        r23 = r5.getString(r10);     // Catch: Throwable -> L42
        goto L27
    L21:
        r22 = r5.getString(r9);     // Catch: Throwable -> L42
        goto L23
    L17:
        r21 = r5.getString(r8);     // Catch: Throwable -> L42
        goto L19
    L13:
        r20 = r5.getString(r7);     // Catch: Throwable -> L42
        goto L15
    L9:
        r19 = r5.getString(r6);     // Catch: Throwable -> L42
        goto L11
    L40:
        r5.close();
        r1.release();
        return r2;
    L42:
        th = move-exception;
        r5.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryProcessUserInsightDao
    public List<da> queryUnprocessedForUnion(int r32) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryProcessUserInsight WHERE processedForUnion = 0 ORDER BY updateTime DESC LIMIT ?", 1);
        r1.bindLong(1, r32);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L42
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "profileKey");     // Catch: Throwable -> L42
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "summary");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "description");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "profileJson");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "evidenceRefs");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "sourceEventIds");     // Catch: Throwable -> L42
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "processedForUnion");     // Catch: Throwable -> L42
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L42
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L42
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "updateTime");     // Catch: Throwable -> L42
        ArrayList r2 = new ArrayList(r5.getCount());     // Catch: Throwable -> L42
    L4:
        if (r5.moveToNext() == false) goto L40;
        long r17 = r5.getLong(r0);     // Catch: Throwable -> L42
        if (r5.isNull(r6) == false) goto L9;
        String r19 = null;
    L11:
        if (r5.isNull(r7) == false) goto L13;
        String r20 = null;
    L15:
        if (r5.isNull(r8) == false) goto L17;
        String r21 = null;
    L19:
        if (r5.isNull(r9) == false) goto L21;
        String r22 = null;
    L23:
        if (r5.isNull(r10) == false) goto L25;
        String r23 = null;
    L27:
        if (r5.isNull(r11) == false) goto L29;
        String r24 = null;
    L31:
        if (r5.getInt(r12) == 0) goto L33;
        boolean r25 = true;
    L35:
        if (r5.isNull(r13) == false) goto L37;
        String r26 = null;
    L38:
        r2.add(new da(r17, r19, r20, r21, r22, r23, r24, r25, r26, r5.getLong(r14), r5.getLong(r15)));     // Catch: Throwable -> L42
        goto L4
    L37:
        r26 = r5.getString(r13);     // Catch: Throwable -> L42
        goto L38
    L33:
        r25 = false;
        goto L35
    L29:
        r24 = r5.getString(r11);     // Catch: Throwable -> L42
        goto L31
    L25:
        r23 = r5.getString(r10);     // Catch: Throwable -> L42
        goto L27
    L21:
        r22 = r5.getString(r9);     // Catch: Throwable -> L42
        goto L23
    L17:
        r21 = r5.getString(r8);     // Catch: Throwable -> L42
        goto L19
    L13:
        r20 = r5.getString(r7);     // Catch: Throwable -> L42
        goto L15
    L9:
        r19 = r5.getString(r6);     // Catch: Throwable -> L42
        goto L11
    L40:
        r5.close();
        r1.release();
        return r2;
    L42:
        th = move-exception;
        r5.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<da> queryWithLimitAndOffset(int r1, int r2) {
        return MemoryProcessUserInsightDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<da> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityMemoryProcessUserInsightEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(da r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMemoryProcessUserInsightEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(da r3) {
        return update2((da) ZeusTransformUtils.preCheckCast(r3, da.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<da> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMemoryProcessUserInsightEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
