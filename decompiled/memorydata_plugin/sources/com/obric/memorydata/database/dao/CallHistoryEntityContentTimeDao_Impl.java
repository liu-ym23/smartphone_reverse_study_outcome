package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.ah;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class CallHistoryEntityContentTimeDao_Impl implements CallHistoryEntityContentTimeDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ah> __deletionAdapterOfCallHistoryEntityContentTimeEntity;
    private final EntityInsertionAdapter<ah> __insertionAdapterOfCallHistoryEntityContentTimeEntity;
    private final EntityDeletionOrUpdateAdapter<ah> __updateAdapterOfCallHistoryEntityContentTimeEntity;

    public CallHistoryEntityContentTimeDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfCallHistoryEntityContentTimeEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfCallHistoryEntityContentTimeEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfCallHistoryEntityContentTimeEntity = new AnonymousClass3(this, r2);
    }

    private ah __entityCursorConverter_comObricMemorydataDatabaseEntityCallHistoryEntityContentTimeEntity(Cursor r34) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r34, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "rawDbId");
        int r3 = CursorUtil.getColumnIndex(r0, "rawDbColumn");
        int r4 = CursorUtil.getColumnIndex(r0, "startTimestamp");
        int r5 = CursorUtil.getColumnIndex(r0, "endTimestamp");
        int r6 = CursorUtil.getColumnIndex(r0, "startDateTimestamp");
        int r7 = CursorUtil.getColumnIndex(r0, "endDateTimestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "deltaDay");
        int r9 = CursorUtil.getColumnIndex(r0, "deltaMonth");
        int r10 = CursorUtil.getColumnIndex(r0, "deltaYear");
        long r11 = 0;
        if (r1 != (-1)) goto L5;
        long r17 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r19 = 0;
    L10:
        if (r3 != (-1)) goto L13;
    L11:
        String r21 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r22 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r24 = 0;
    L22:
        if (r6 != (-1)) goto L24;
        long r26 = 0;
    L25:
        if (r7 == (-1)) goto L28;
        r11 = r0.getLong(r7);
    L28:
        long r28 = r11;
        if (r8 != (-1)) goto L32;
    L30:
        Integer r30 = null;
    L35:
        if (r9 != (-1)) goto L38;
    L36:
        Integer r31 = null;
    L41:
        if (r10 != (-1)) goto L44;
    L42:
        Integer r32 = null;
    L48:
        return new ah(r17, r19, r21, r22, r24, r26, r28, r30, r31, r32);
    L44:
        if (r0.isNull(r10) == true) goto L42;
        r32 = Integer.valueOf(r0.getInt(r10));
        goto L48
    L38:
        if (r0.isNull(r9) == true) goto L36;
        r31 = Integer.valueOf(r0.getInt(r9));
        goto L41
    L32:
        if (r0.isNull(r8) == true) goto L30;
        r30 = Integer.valueOf(r0.getInt(r8));
        goto L35
    L24:
        r26 = r0.getLong(r6);
        goto L25
    L21:
        r24 = r0.getLong(r5);
        goto L22
    L18:
        r22 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r21 = r0.getString(r3);
        goto L16
    L8:
        r19 = r0.getLong(r2);
        goto L10
    L5:
        r17 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityContentTimeDao
    public String buildColumnGroup(Set<String> r3) {
        return CallHistoryEntityContentTimeDao.DefaultImpls.buildColumnGroup(this, (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ah> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfCallHistoryEntityContentTimeEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ah> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfCallHistoryEntityContentTimeEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityContentTimeDao
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

    public int delete(ah r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfCallHistoryEntityContentTimeEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((ah) ZeusTransformUtils.preCheckCast(r3, ah.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return CallHistoryEntityContentTimeDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityContentTimeDao
    public int deleteByRawDbId(long r1) {
        return CallHistoryEntityContentTimeDao.DefaultImpls.deleteByRawDbId(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityContentTimeDao
    public void deleteByRawDbIdAndColumns(long r3, Set<String> r5) {
        CallHistoryEntityContentTimeDao.DefaultImpls.deleteByRawDbIdAndColumns(this, r3, (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityContentTimeDao
    public int deleteByRawDbIds(List<Long> r3) {
        return CallHistoryEntityContentTimeDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryEntityContentTimeDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return CallHistoryEntityContentTimeDao.DefaultImpls.getTableName(this);
    }

    public long insert(ah r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfCallHistoryEntityContentTimeEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((ah) ZeusTransformUtils.preCheckCast(r3, ah.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ah> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfCallHistoryEntityContentTimeEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ah> queryAll() {
        return CallHistoryEntityContentTimeDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return CallHistoryEntityContentTimeDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ah queryById(long r1) {
        return CallHistoryEntityContentTimeDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ah> queryByIds(List<Long> r3) {
        return CallHistoryEntityContentTimeDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryEntityContentTimeDao
    public ah queryByRawDbId(long r1) {
        return CallHistoryEntityContentTimeDao.DefaultImpls.queryByRawDbId(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ah queryByUUID(String r1) {
        return CallHistoryEntityContentTimeDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ah queryOne() {
        return CallHistoryEntityContentTimeDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ah> queryWithLimitAndOffset(int r1, int r2) {
        return CallHistoryEntityContentTimeDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ah> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityCallHistoryEntityContentTimeEntity(r6));     // Catch: Throwable -> L10
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

    public int update(ah r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfCallHistoryEntityContentTimeEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((ah) ZeusTransformUtils.preCheckCast(r3, ah.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ah> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfCallHistoryEntityContentTimeEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
