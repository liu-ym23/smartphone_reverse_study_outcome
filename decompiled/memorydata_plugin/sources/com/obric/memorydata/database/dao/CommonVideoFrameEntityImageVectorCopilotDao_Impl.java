package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.ao;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class CommonVideoFrameEntityImageVectorCopilotDao_Impl implements CommonVideoFrameEntityImageVectorCopilotDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ao> __deletionAdapterOfCommonVideoFrameEntityImageVectorCopilotEntity;
    private final EntityInsertionAdapter<ao> __insertionAdapterOfCommonVideoFrameEntityImageVectorCopilotEntity;
    private final EntityDeletionOrUpdateAdapter<ao> __updateAdapterOfCommonVideoFrameEntityImageVectorCopilotEntity;

    public CommonVideoFrameEntityImageVectorCopilotDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfCommonVideoFrameEntityImageVectorCopilotEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfCommonVideoFrameEntityImageVectorCopilotEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfCommonVideoFrameEntityImageVectorCopilotEntity = new AnonymousClass3(this, r2);
    }

    private ao __entityCursorConverter_comObricMemorydataDatabaseEntityCommonVideoFrameEntityImageVectorCopilotEntity(Cursor r14) {
        Cursor r13 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r14, Cursor.class, "com.obric.memorydata.plugin");
        int r15 = CursorUtil.getColumnIndex(r13, OaidModel.KEY_ID);
        int r0 = CursorUtil.getColumnIndex(r13, "rawDbId");
        int r1 = CursorUtil.getColumnIndex(r13, "rawDbColumn");
        long r2 = 0;
        if (r15 != (-1)) goto L5;
        long r8 = 0;
    L6:
        if (r0 == (-1)) goto L9;
        r2 = r13.getLong(r0);
    L9:
        long r10 = r2;
        if (r1 != (-1)) goto L13;
    L11:
        String r12 = null;
    L17:
        return new ao(r8, r10, r12);
    L13:
        if (r13.isNull(r1) == true) goto L11;
        r12 = r13.getString(r1);
        goto L17
    L5:
        r8 = r13.getLong(r15);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public String buildColumnGroup(Set<String> r3) {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.buildColumnGroup(this, (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ao> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfCommonVideoFrameEntityImageVectorCopilotEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ao> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfCommonVideoFrameEntityImageVectorCopilotEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public int delete(SupportSQLiteQuery r3) {
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

    public int delete(ao r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfCommonVideoFrameEntityImageVectorCopilotEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((ao) ZeusTransformUtils.preCheckCast(r3, ao.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public int deleteByRawDbId(long r1) {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.deleteByRawDbId(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public void deleteByRawDbIdAndColumns(long r3, Set<String> r5) {
        CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndColumns(this, r3, (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public void deleteByRawDbIdAndType(long r1, int r3) {
        CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndType(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public void deleteByRawDbIdAndTypeColumns(long r3, int r5, Set<String> r6) {
        CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndTypeColumns(this, r3, r5, (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public int deleteByRawDbIds(List<Long> r3) {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.CommonVideoFrameEntityImageVectorCopilotDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.getTableName(this);
    }

    public long insert(ao r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfCommonVideoFrameEntityImageVectorCopilotEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((ao) ZeusTransformUtils.preCheckCast(r3, ao.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ao> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfCommonVideoFrameEntityImageVectorCopilotEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public boolean isEmpty() {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.isEmpty(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ao> queryAll() {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ao queryById(long r1) {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ao> queryByIds(List<Long> r3) {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public List<ao> queryByRawDbId(long r1) {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.queryByRawDbId(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public List<ao> queryByRawDbIdAndColumns(long r3, Set<String> r5) {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.queryByRawDbIdAndColumns(this, r3, (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public List<ao> queryByRawDbIdListAndColumnContent(List<Long> r3, String r4) {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.queryByRawDbIdListAndColumnContent(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public List<ao> queryByRawDbIds(List<Long> r3) {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.queryByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ao queryByUUID(String r1) {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ao queryOne() {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ao> queryWithLimitAndOffset(int r1, int r2) {
        return CommonVideoFrameEntityImageVectorCopilotDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ao> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityCommonVideoFrameEntityImageVectorCopilotEntity(r6));     // Catch: Throwable -> L10
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

    public int update(ao r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfCommonVideoFrameEntityImageVectorCopilotEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((ao) ZeusTransformUtils.preCheckCast(r3, ao.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ao> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfCommonVideoFrameEntityImageVectorCopilotEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
