package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.iv;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UnionSemanticTypeSummaryDao_Impl implements UnionSemanticTypeSummaryDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<iv> __deletionAdapterOfUnionSemanticTypeSummaryEntity;
    private final EntityInsertionAdapter<iv> __insertionAdapterOfUnionSemanticTypeSummaryEntity;
    private final EntityInsertionAdapter<iv> __insertionAdapterOfUnionSemanticTypeSummaryEntity_1;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByTypeAndTreePath;
    private final EntityDeletionOrUpdateAdapter<iv> __updateAdapterOfUnionSemanticTypeSummaryEntity;

    public UnionSemanticTypeSummaryDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfUnionSemanticTypeSummaryEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfUnionSemanticTypeSummaryEntity_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfUnionSemanticTypeSummaryEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfUnionSemanticTypeSummaryEntity = new AnonymousClass4(this, r2);
        this.__preparedStmtOfDeleteAll = new AnonymousClass5(this, r2);
        this.__preparedStmtOfDeleteByTypeAndTreePath = new AnonymousClass6(this, r2);
    }

    private iv __entityCursorConverter_comObricMemorydataDatabaseEntityUnionSemanticTypeSummaryEntity(Cursor r21) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r21, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "type");
        int r3 = CursorUtil.getColumnIndex(r0, "treePath");
        int r4 = CursorUtil.getColumnIndex(r0, "summary");
        int r5 = CursorUtil.getColumnIndex(r0, "description");
        int r6 = CursorUtil.getColumnIndex(r0, CommonConsts.COUNT_TYPE);
        int r7 = CursorUtil.getColumnIndex(r0, "createTime");
        int r8 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r9 = 0;
        if (r1 != (-1)) goto L5;
        int r12 = 0;
    L6:
        String r10 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r13 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r14 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r15 = null;
    L25:
        if (r5 != (-1)) goto L28;
    L26:
        String r16 = r10;
        if (r6 != (-1)) goto L33;
        int r17 = 0;
    L34:
        if (r7 != (-1)) goto L36;
        int r18 = 0;
    L37:
        if (r8 == (-1)) goto L41;
        r9 = r0.getInt(r8);
    L41:
        return new iv(r12, r13, r14, r15, r16, r17, r18, r9);
    L36:
        r18 = r0.getInt(r7);
        goto L37
    L33:
        r17 = r0.getInt(r6);
        goto L34
    L28:
        if (r0.isNull(r5) == true) goto L26;
        r10 = r0.getString(r5);
        goto L26
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r15 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r14 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r13 = r0.getString(r2);
        goto L13
    L5:
        r12 = r0.getInt(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<iv> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfUnionSemanticTypeSummaryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<iv> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUnionSemanticTypeSummaryEntity_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(iv r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfUnionSemanticTypeSummaryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(iv r3) {
        return delete2((iv) ZeusTransformUtils.preCheckCast(r3, iv.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.UnionSemanticTypeSummaryDao, com.obric.memorydata.database.dao.BaseDao
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

    @Override // com.obric.memorydata.database.dao.UnionSemanticTypeSummaryDao
    public void deleteByTypeAndTreePath(String r3, String r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByTypeAndTreePath.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByTypeAndTreePath.release(r0);
        return;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByTypeAndTreePath.release(r0);
        throw th;
    L9:
        r0.bindString(2, r4);
        goto L10
    L5:
        r0.bindString(1, r3);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.UnionSemanticTypeSummaryDao
    public List<iv> getAll() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM UnionSemanticTypeSummary", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L26
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L26
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "treePath");     // Catch: Throwable -> L26
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "summary");     // Catch: Throwable -> L26
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "description");     // Catch: Throwable -> L26
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, CommonConsts.COUNT_TYPE);     // Catch: Throwable -> L26
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "createTime");     // Catch: Throwable -> L26
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "modifyTime");     // Catch: Throwable -> L26
        ArrayList r11 = new ArrayList(r2.getCount());     // Catch: Throwable -> L26
    L4:
        if (r2.moveToNext() == false) goto L24;
        int r14 = r2.getInt(r0);     // Catch: Throwable -> L26
        if (r2.isNull(r4) == false) goto L9;
        String r15 = null;
    L11:
        if (r2.isNull(r5) == false) goto L13;
        String r16 = null;
    L15:
        if (r2.isNull(r6) == false) goto L17;
        String r17 = null;
    L19:
        if (r2.isNull(r7) == false) goto L21;
        String r18 = null;
    L22:
        r11.add(new iv(r14, r15, r16, r17, r18, r2.getInt(r8), r2.getInt(r9), r2.getInt(r10)));     // Catch: Throwable -> L26
        goto L4
    L21:
        r18 = r2.getString(r7);     // Catch: Throwable -> L26
        goto L22
    L17:
        r17 = r2.getString(r6);     // Catch: Throwable -> L26
        goto L19
    L13:
        r16 = r2.getString(r5);     // Catch: Throwable -> L26
        goto L15
    L9:
        r15 = r2.getString(r4);     // Catch: Throwable -> L26
        goto L11
    L24:
        r2.close();
        r1.release();
        return r11;
    L26:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.UnionSemanticTypeSummaryDao
    public List<iv> getAllExcludeTypeOrderByCount(String r23) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM UnionSemanticTypeSummary WHERE type != ? ORDER BY `count` DESC, modifyTime DESC", 1);
        if (r23 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L30
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "treePath");     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "summary");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "description");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, CommonConsts.COUNT_TYPE);     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "createTime");     // Catch: Throwable -> L30
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "modifyTime");     // Catch: Throwable -> L30
        ArrayList r11 = new ArrayList(r1.getCount());     // Catch: Throwable -> L30
    L8:
        if (r1.moveToNext() == false) goto L28;
        int r14 = r1.getInt(r0);     // Catch: Throwable -> L30
        if (r1.isNull(r4) == false) goto L13;
        String r15 = null;
    L15:
        if (r1.isNull(r5) == false) goto L17;
        String r16 = null;
    L19:
        if (r1.isNull(r6) == false) goto L21;
        String r17 = null;
    L23:
        if (r1.isNull(r7) == false) goto L25;
        String r18 = null;
    L26:
        r11.add(new iv(r14, r15, r16, r17, r18, r1.getInt(r8), r1.getInt(r9), r1.getInt(r10)));     // Catch: Throwable -> L30
        goto L8
    L25:
        r18 = r1.getString(r7);     // Catch: Throwable -> L30
        goto L26
    L21:
        r17 = r1.getString(r6);     // Catch: Throwable -> L30
        goto L23
    L17:
        r16 = r1.getString(r5);     // Catch: Throwable -> L30
        goto L19
    L13:
        r15 = r1.getString(r4);     // Catch: Throwable -> L30
        goto L15
    L28:
        r1.close();
        r2.release();
        return r11;
    L30:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r23);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.UnionSemanticTypeSummaryDao
    public iv getLatest(String r22, String r23) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM UnionSemanticTypeSummary WHERE type = ? AND treePath = ? ORDER BY id DESC LIMIT 1", 2);
        if (r22 != null) goto L5;
        r3.bindNull(1);
    L6:
        if (r23 != null) goto L8;
        r3.bindNull(2);
    L9:
        this.__db.assertNotSuspendingTransaction();
        iv r2 = null;
        String r4 = null;
        Cursor r1 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L31
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L31
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "treePath");     // Catch: Throwable -> L31
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "summary");     // Catch: Throwable -> L31
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "description");     // Catch: Throwable -> L31
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, CommonConsts.COUNT_TYPE);     // Catch: Throwable -> L31
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "createTime");     // Catch: Throwable -> L31
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "modifyTime");     // Catch: Throwable -> L31
        if (r1.moveToFirst() == false) goto L29;
        int r13 = r1.getInt(r0);     // Catch: Throwable -> L31
        if (r1.isNull(r5) == false) goto L15;
        String r14 = null;
    L17:
        if (r1.isNull(r6) == false) goto L19;
        String r15 = null;
    L21:
        if (r1.isNull(r7) == false) goto L23;
        String r16 = null;
    L25:
        if (r1.isNull(r8) == true) goto L28;
        r4 = r1.getString(r8);     // Catch: Throwable -> L31
    L28:
        r2 = new iv(r13, r14, r15, r16, r4, r1.getInt(r9), r1.getInt(r10), r1.getInt(r11));     // Catch: Throwable -> L31
        goto L29
    L23:
        r16 = r1.getString(r7);     // Catch: Throwable -> L31
        goto L25
    L19:
        r15 = r1.getString(r6);     // Catch: Throwable -> L31
        goto L21
    L15:
        r14 = r1.getString(r5);     // Catch: Throwable -> L31
    L29:
        r1.close();
        r3.release();
        return r2;
    L31:
        th = move-exception;
        r1.close();
        r3.release();
        throw th;
    L8:
        r3.bindString(2, r23);
        goto L9
    L5:
        r3.bindString(1, r22);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.UnionSemanticTypeSummaryDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return UnionSemanticTypeSummaryDao.DefaultImpls.getTableName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.UnionSemanticTypeSummaryDao
    public long insert(iv r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUnionSemanticTypeSummaryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(iv r3) {
        return insert((iv) ZeusTransformUtils.preCheckCast(r3, iv.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<iv> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfUnionSemanticTypeSummaryEntity_1.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<iv> queryAll() {
        return UnionSemanticTypeSummaryDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return UnionSemanticTypeSummaryDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public iv queryById(long r1) {
        return UnionSemanticTypeSummaryDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ iv queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<iv> queryByIds(List<Long> r3) {
        return UnionSemanticTypeSummaryDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public iv queryByUUID(String r1) {
        return UnionSemanticTypeSummaryDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ iv queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public iv queryOne() {
        return UnionSemanticTypeSummaryDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ iv queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<iv> queryWithLimitAndOffset(int r1, int r2) {
        return UnionSemanticTypeSummaryDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<iv> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityUnionSemanticTypeSummaryEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(iv r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfUnionSemanticTypeSummaryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(iv r3) {
        return update2((iv) ZeusTransformUtils.preCheckCast(r3, iv.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<iv> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfUnionSemanticTypeSummaryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
