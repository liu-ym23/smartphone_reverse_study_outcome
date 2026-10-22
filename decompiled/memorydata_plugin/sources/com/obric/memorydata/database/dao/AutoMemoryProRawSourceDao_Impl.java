package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoMemoryProRawSourceDao_Impl implements AutoMemoryProRawSourceDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<z> __deletionAdapterOfAutoMemoryProRawSource;
    private final EntityInsertionAdapter<z> __insertionAdapterOfAutoMemoryProRawSource;
    private final SharedSQLiteStatement __preparedStmtOfUpdateContentPartsIfCurrent;
    private final SharedSQLiteStatement __preparedStmtOfUpdateFailureIfCurrent;
    private final SharedSQLiteStatement __preparedStmtOfUpdateStateIfCurrent;
    private final EntityDeletionOrUpdateAdapter<z> __updateAdapterOfAutoMemoryProRawSource;

    public AutoMemoryProRawSourceDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAutoMemoryProRawSource = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfAutoMemoryProRawSource = new AnonymousClass2(this, r2);
        this.__updateAdapterOfAutoMemoryProRawSource = new AnonymousClass3(this, r2);
        this.__preparedStmtOfUpdateStateIfCurrent = new AnonymousClass4(this, r2);
        this.__preparedStmtOfUpdateFailureIfCurrent = new AnonymousClass5(this, r2);
        this.__preparedStmtOfUpdateContentPartsIfCurrent = new AnonymousClass6(this, r2);
    }

    private z __entityCursorConverter_comObricMemorydataDatabaseEntityAutoMemoryProRawSource(Cursor r35) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r35, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, TypedValues.AttributesType.S_TARGET);
        int r3 = CursorUtil.getColumnIndex(r0, "sourceType");
        int r4 = CursorUtil.getColumnIndex(r0, "sourceKey");
        int r5 = CursorUtil.getColumnIndex(r0, ChatMessage.TYPE_QUERY);
        int r6 = CursorUtil.getColumnIndex(r0, "contentPartsJson");
        int r7 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "state");
        int r9 = CursorUtil.getColumnIndex(r0, "retryCount");
        int r10 = CursorUtil.getColumnIndex(r0, "lastErrorCode");
        int r11 = CursorUtil.getColumnIndex(r0, "logId");
        int r12 = CursorUtil.getColumnIndex(r0, "updateTime");
        long r13 = 0;
        if (r1 != (-1)) goto L5;
        long r19 = 0;
    L6:
        String r14 = null;
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
        String r25 = null;
    L37:
        if (r7 != (-1)) goto L39;
        long r26 = 0;
    L40:
        if (r8 != (-1)) goto L43;
    L41:
        String r28 = null;
    L46:
        int r15 = 0;
        if (r9 != (-1)) goto L49;
        int r29 = 0;
    L50:
        if (r10 == (-1)) goto L53;
        r15 = r0.getInt(r10);
    L53:
        int r30 = r15;
        if (r11 != (-1)) goto L57;
    L55:
        String r31 = r14;
        if (r12 == (-1)) goto L64;
        r13 = r0.getLong(r12);
    L64:
        return new z(r19, r21, r22, r23, r24, r25, r26, r28, r29, r30, r31, r13);
    L57:
        if (r0.isNull(r11) == true) goto L55;
        r14 = r0.getString(r11);
        goto L55
    L49:
        r29 = r0.getInt(r9);
        goto L50
    L43:
        if (r0.isNull(r8) == true) goto L41;
        r28 = r0.getString(r8);
        goto L46
    L39:
        r26 = r0.getLong(r7);
        goto L40
    L34:
        if (r0.isNull(r6) == true) goto L32;
        r25 = r0.getString(r6);
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
        r19 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<z> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAutoMemoryProRawSource.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<z> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAutoMemoryProRawSource.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(z r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAutoMemoryProRawSource.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(z r3) {
        return delete2((z) ZeusTransformUtils.preCheckCast(r3, z.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return AutoMemoryProRawSourceDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProRawSourceDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return AutoMemoryProRawSourceDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(z r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAutoMemoryProRawSource.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(z r3) {
        return insert2((z) ZeusTransformUtils.preCheckCast(r3, z.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<z> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAutoMemoryProRawSource.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProRawSourceDao
    public boolean insertOrUpdatePending(z r2) {
        this.__db.beginTransaction();
        boolean r3 = AutoMemoryProRawSourceDao.DefaultImpls.insertOrUpdatePending(this, r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<z> queryAll() {
        return AutoMemoryProRawSourceDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return AutoMemoryProRawSourceDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public z queryById(long r1) {
        return AutoMemoryProRawSourceDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ z queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<z> queryByIds(List<Long> r3) {
        return AutoMemoryProRawSourceDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProRawSourceDao
    public z queryBySource(String r33, String r34, String r35) {
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("SELECT * FROM AutoMemoryProRawSource WHERE target = ? AND sourceType = ? AND sourceKey = ? LIMIT 1", 3);
        if (r33 != null) goto L5;
        r4.bindNull(1);
    L7:
        if (r34 != null) goto L9;
        r4.bindNull(2);
    L10:
        if (r35 != null) goto L12;
        r4.bindNull(3);
    L13:
        this.__db.assertNotSuspendingTransaction();
        z r2 = null;
        String r3 = null;
        Cursor r1 = DBUtil.query(this.__db, r4, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L47
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, TypedValues.AttributesType.S_TARGET);     // Catch: Throwable -> L47
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "sourceType");     // Catch: Throwable -> L47
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "sourceKey");     // Catch: Throwable -> L47
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, ChatMessage.TYPE_QUERY);     // Catch: Throwable -> L47
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "contentPartsJson");     // Catch: Throwable -> L47
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L47
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "state");     // Catch: Throwable -> L47
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "retryCount");     // Catch: Throwable -> L47
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "lastErrorCode");     // Catch: Throwable -> L47
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "logId");     // Catch: Throwable -> L47
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "updateTime");     // Catch: Throwable -> L47
        if (r1.moveToFirst() == false) goto L45;
        long r17 = r1.getLong(r0);     // Catch: Throwable -> L47
        if (r1.isNull(r5) == false) goto L19;
        String r19 = null;
    L21:
        if (r1.isNull(r6) == false) goto L23;
        String r20 = null;
    L25:
        if (r1.isNull(r7) == false) goto L27;
        String r21 = null;
    L29:
        if (r1.isNull(r8) == false) goto L31;
        String r22 = null;
    L33:
        if (r1.isNull(r9) == false) goto L35;
        String r23 = null;
    L36:
        long r24 = r1.getLong(r10);     // Catch: Throwable -> L47
        if (r1.isNull(r11) == false) goto L39;
        String r26 = null;
    L40:
        int r27 = r1.getInt(r12);     // Catch: Throwable -> L47
        int r28 = r1.getInt(r13);     // Catch: Throwable -> L47
        if (r1.isNull(r14) == true) goto L44;
        r3 = r1.getString(r14);     // Catch: Throwable -> L47
    L44:
        r2 = new z(r17, r19, r20, r21, r22, r23, r24, r26, r27, r28, r3, r1.getLong(r15));     // Catch: Throwable -> L47
        goto L45
    L39:
        r26 = r1.getString(r11);     // Catch: Throwable -> L47
        goto L40
    L35:
        r23 = r1.getString(r9);     // Catch: Throwable -> L47
        goto L36
    L31:
        r22 = r1.getString(r8);     // Catch: Throwable -> L47
        goto L33
    L27:
        r21 = r1.getString(r7);     // Catch: Throwable -> L47
        goto L29
    L23:
        r20 = r1.getString(r6);     // Catch: Throwable -> L47
        goto L25
    L19:
        r19 = r1.getString(r5);     // Catch: Throwable -> L47
    L45:
        r1.close();
        r4.release();
        return r2;
    L47:
        th = move-exception;
        r1.close();
        r4.release();
        throw th;
    L12:
        r4.bindString(3, r35);
        goto L13
    L9:
        r4.bindString(2, r34);
        goto L10
    L5:
        r4.bindString(1, r33);
        goto L7
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public z queryByUUID(String r1) {
        return AutoMemoryProRawSourceDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ z queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public z queryOne() {
        return AutoMemoryProRawSourceDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ z queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<z> queryWithLimitAndOffset(int r1, int r2) {
        return AutoMemoryProRawSourceDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<z> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityAutoMemoryProRawSource(r6));     // Catch: Throwable -> L10
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
    public int update2(z r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAutoMemoryProRawSource.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(z r3) {
        return update2((z) ZeusTransformUtils.preCheckCast(r3, z.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<z> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAutoMemoryProRawSource.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProRawSourceDao
    public int updateContentPartsIfCurrent(String r3, String r4, String r5, String r6, String r7, String r8, long r9) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateContentPartsIfCurrent.acquire();
        if (r8 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r9);
        if (r3 != null) goto L9;
        r0.bindNull(3);
    L11:
        if (r4 != null) goto L13;
        r0.bindNull(4);
    L15:
        if (r5 != null) goto L17;
        r0.bindNull(5);
    L19:
        if (r6 != null) goto L21;
        r0.bindNull(6);
    L23:
        if (r7 != null) goto L25;
        r0.bindNull(7);
    L26:
        this.__db.beginTransaction();
        int r10 = r0.executeUpdateDelete();     // Catch: Throwable -> L30
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L30
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateContentPartsIfCurrent.release(r0);
        return r10;
    L30:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateContentPartsIfCurrent.release(r0);
        throw th;
    L25:
        r0.bindString(7, r7);
        goto L26
    L21:
        r0.bindString(6, r6);
        goto L23
    L17:
        r0.bindString(5, r5);
        goto L19
    L13:
        r0.bindString(4, r4);
        goto L15
    L9:
        r0.bindString(3, r3);
        goto L11
    L5:
        r0.bindString(1, r8);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProRawSourceDao
    public int updateFailureIfCurrent(String r4, String r5, String r6, String r7, String r8, int r9, int r10, long r11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateFailureIfCurrent.acquire();
        if (r8 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r9);
        r0.bindLong(3, r10);
        r0.bindLong(4, r11);
        if (r4 != null) goto L9;
        r0.bindNull(5);
    L11:
        if (r5 != null) goto L13;
        r0.bindNull(6);
    L15:
        if (r6 != null) goto L17;
        r0.bindNull(7);
    L19:
        if (r7 != null) goto L21;
        r0.bindNull(8);
    L22:
        this.__db.beginTransaction();
        int r12 = r0.executeUpdateDelete();     // Catch: Throwable -> L26
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L26
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateFailureIfCurrent.release(r0);
        return r12;
    L26:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateFailureIfCurrent.release(r0);
        throw th;
    L21:
        r0.bindString(8, r7);
        goto L22
    L17:
        r0.bindString(7, r6);
        goto L19
    L13:
        r0.bindString(6, r5);
        goto L15
    L9:
        r0.bindString(5, r4);
        goto L11
    L5:
        r0.bindString(1, r8);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProRawSourceDao
    public int updateStateIfCurrent(String r3, String r4, String r5, String r6, String r7, long r8) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateStateIfCurrent.acquire();
        if (r7 != null) goto L5;
        r0.bindNull(1);
    L6:
        r0.bindLong(2, r8);
        if (r3 != null) goto L9;
        r0.bindNull(3);
    L11:
        if (r4 != null) goto L13;
        r0.bindNull(4);
    L15:
        if (r5 != null) goto L17;
        r0.bindNull(5);
    L19:
        if (r6 != null) goto L21;
        r0.bindNull(6);
    L22:
        this.__db.beginTransaction();
        int r9 = r0.executeUpdateDelete();     // Catch: Throwable -> L26
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L26
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateStateIfCurrent.release(r0);
        return r9;
    L26:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateStateIfCurrent.release(r0);
        throw th;
    L21:
        r0.bindString(6, r6);
        goto L22
    L17:
        r0.bindString(5, r5);
        goto L19
    L13:
        r0.bindString(4, r4);
        goto L15
    L9:
        r0.bindString(3, r3);
        goto L11
    L5:
        r0.bindString(1, r7);
        goto L6
    }
}
