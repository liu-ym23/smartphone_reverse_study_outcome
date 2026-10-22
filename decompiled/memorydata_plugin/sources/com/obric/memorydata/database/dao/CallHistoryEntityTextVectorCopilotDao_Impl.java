package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.ai;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class CallHistoryEntityTextVectorCopilotDao_Impl implements CallHistoryEntityTextVectorCopilotDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ai> __deletionAdapterOfCallHistoryEntityTextVectorCopilotEntity;
    private final EntityInsertionAdapter<ai> __insertionAdapterOfCallHistoryEntityTextVectorCopilotEntity;
    private final EntityDeletionOrUpdateAdapter<ai> __updateAdapterOfCallHistoryEntityTextVectorCopilotEntity;

    public CallHistoryEntityTextVectorCopilotDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfCallHistoryEntityTextVectorCopilotEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfCallHistoryEntityTextVectorCopilotEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfCallHistoryEntityTextVectorCopilotEntity = new AnonymousClass3(this, r2);
    }

    private ai __entityCursorConverter_comObricMemorydataDatabaseEntityCallHistoryEntityTextVectorCopilotEntity(Cursor r18) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r18, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "rawDbId");
        int r3 = CursorUtil.getColumnIndex(r0, "rawDbColumn");
        int r4 = CursorUtil.getColumnIndex(r0, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
        long r5 = 0;
        if (r1 != (-1)) goto L5;
        long r11 = 0;
    L6:
        if (r2 == (-1)) goto L9;
        r5 = r0.getLong(r2);
    L9:
        long r13 = r5;
        if (r3 != (-1)) goto L13;
    L11:
        String r15 = null;
    L16:
        if (r4 != (-1)) goto L19;
    L17:
        String r16 = null;
    L23:
        return new ai(r11, r13, r15, r16);
    L19:
        if (r0.isNull(r4) == true) goto L17;
        r16 = r0.getString(r4);
        goto L23
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r15 = r0.getString(r3);
        goto L16
    L5:
        r11 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public String buildColumnGroup(Set<String> r3) {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.buildColumnGroup(this, (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ai> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfCallHistoryEntityTextVectorCopilotEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ai> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfCallHistoryEntityTextVectorCopilotEntity.insert(r4);     // Catch: Throwable -> L6
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

    public int delete(ai r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfCallHistoryEntityTextVectorCopilotEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((ai) ZeusTransformUtils.preCheckCast(r3, ai.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public int deleteByRawDbId(long r1) {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.deleteByRawDbId(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public void deleteByRawDbIdAndColumns(long r3, Set<String> r5) {
        CallHistoryEntityTextVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndColumns(this, r3, (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public void deleteByRawDbIdAndType(long r1, int r3) {
        CallHistoryEntityTextVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndType(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public void deleteByRawDbIdAndTypeColumns(long r3, int r5, Set<String> r6) {
        CallHistoryEntityTextVectorCopilotDao.DefaultImpls.deleteByRawDbIdAndTypeColumns(this, r3, r5, (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public int deleteByRawDbIds(List<Long> r3) {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryEntityTextVectorCopilotDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.getTableName(this);
    }

    public long insert(ai r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfCallHistoryEntityTextVectorCopilotEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((ai) ZeusTransformUtils.preCheckCast(r3, ai.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ai> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfCallHistoryEntityTextVectorCopilotEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
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
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.isEmpty(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ai> queryAll() {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ai queryById(long r1) {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ai> queryByIds(List<Long> r3) {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public List<ai> queryByRawDbId(long r1) {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.queryByRawDbId(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public List<ai> queryByRawDbIdAndColumns(long r3, Set<String> r5) {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.queryByRawDbIdAndColumns(this, r3, (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public List<ai> queryByRawDbIdListAndColumnContent(List<Long> r3, String r4) {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.queryByRawDbIdListAndColumnContent(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityVectorCopilotDao
    public List<ai> queryByRawDbIds(List<Long> r3) {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.queryByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ai queryByUUID(String r1) {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ai queryOne() {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ai> queryWithLimitAndOffset(int r1, int r2) {
        return CallHistoryEntityTextVectorCopilotDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ai> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityCallHistoryEntityTextVectorCopilotEntity(r6));     // Catch: Throwable -> L10
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

    public int update(ai r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfCallHistoryEntityTextVectorCopilotEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((ai) ZeusTransformUtils.preCheckCast(r3, ai.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ai> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfCallHistoryEntityTextVectorCopilotEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
