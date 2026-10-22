package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.gb;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class DoubaoAccountEntityRawDbDao_Impl implements DoubaoAccountEntityRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<gb> __deletionAdapterOfRawDoubaoAccountEntity;
    private final EntityInsertionAdapter<gb> __insertionAdapterOfRawDoubaoAccountEntity;
    private final EntityDeletionOrUpdateAdapter<gb> __updateAdapterOfRawDoubaoAccountEntity;

    public DoubaoAccountEntityRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawDoubaoAccountEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawDoubaoAccountEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawDoubaoAccountEntity = new AnonymousClass3(this, r2);
    }

    private gb __entityCursorConverter_comObricMemorydataDatabaseEntityRawDoubaoAccountEntity(Cursor r33) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r33, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r10 = CursorUtil.getColumnIndex(r0, "doubaoUid");
        int r11 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r12 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r13 = CursorUtil.getColumnIndex(r0, "content_hash");
        if (r1 != (-1)) goto L5;
        long r18 = 0;
    L6:
        String r14 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r20 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r21 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r23 = 0;
    L19:
        int r15 = 0;
        if (r5 != (-1)) goto L22;
        int r25 = 0;
    L23:
        if (r6 != (-1)) goto L25;
        long r26 = 0;
    L26:
        if (r7 != (-1)) goto L29;
    L27:
        String r28 = null;
    L32:
        if (r8 == (-1)) goto L35;
        r15 = r0.getInt(r8);
    L35:
        int r29 = r15;
        if (r9 != (-1)) goto L39;
    L37:
        String r30 = null;
    L42:
        if (r10 != (-1)) goto L45;
    L43:
        String r31 = null;
    L48:
        gb r16 = new gb(r18, r20, r21, r23, r25, r26, r28, r29, r30, r31);
        if (r11 != (-1)) goto L51;
    L55:
        if (r12 != (-1)) goto L57;
    L61:
        if (r13 != (-1)) goto L63;
    L67:
        return r16;
    L63:
        if (r0.isNull(r13) == true) goto L66;
        r14 = r0.getString(r13);
    L66:
        r16.setContentHash(r14);
        goto L67
    L57:
        if (r0.isNull(r12) == false) goto L59;
        Integer r17 = null;
    L60:
        r16.setPoisonLabelVersion(r17);
        goto L61
    L59:
        r17 = Integer.valueOf(r0.getInt(r12));
        goto L60
    L51:
        if (r0.isNull(r11) == false) goto L53;
        Integer r19 = null;
    L54:
        r16.setPoisonLabel(r19);
        goto L55
    L53:
        r19 = Integer.valueOf(r0.getInt(r11));
        goto L54
    L45:
        if (r0.isNull(r10) == true) goto L43;
        r31 = r0.getString(r10);
        goto L48
    L39:
        if (r0.isNull(r9) == true) goto L37;
        r30 = r0.getString(r9);
        goto L42
    L29:
        if (r0.isNull(r7) == true) goto L27;
        r28 = r0.getString(r7);
        goto L32
    L25:
        r26 = r0.getLong(r6);
        goto L26
    L22:
        r25 = r0.getInt(r5);
        goto L23
    L18:
        r23 = r0.getLong(r4);
        goto L19
    L15:
        r21 = r0.getLong(r3);
        goto L16
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

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<gb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawDoubaoAccountEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<gb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawDoubaoAccountEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
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

    public int delete(gb r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawDoubaoAccountEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((gb) ZeusTransformUtils.preCheckCast(r3, gb.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCount(SupportSQLiteQuery r3) {
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

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageName(String r1) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<c> getHashCodeListByPackageNameWithTimeStamp(SupportSQLiteQuery r8) {
        SupportSQLiteQuery r9 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r8, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r9, false, null);
        int r10 = CursorUtil.getColumnIndex(r7, "entityId");     // Catch: Throwable -> L20
        int r2 = CursorUtil.getColumnIndex(r7, "hashCodeValue");     // Catch: Throwable -> L20
        ArrayList r3 = new ArrayList(r7.getCount());     // Catch: Throwable -> L20
    L4:
        if (r7.moveToNext() == false) goto L18;
        if (r10 != (-1)) goto L10;
    L8:
        String r5 = null;
    L13:
        if (r2 != (-1)) goto L15;
        int r4 = 0;
    L16:
        r3.add(new c(r5, r4));     // Catch: Throwable -> L20
        goto L4
    L15:
        r4 = r7.getInt(r2);     // Catch: Throwable -> L20
        goto L16
    L10:
        if (r7.isNull(r10) == true) goto L8;
        r5 = r7.getString(r10);     // Catch: Throwable -> L20
        goto L13
    L18:
        r7.close();
        return r3;
    L20:
        th = move-exception;
        r7.close();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<c> getHashCodeListByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Long getMaxValue(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Long r1 = null;
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L11:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == true) goto L6;
    L9:
        r2.close();
        return r1;
    L6:
        if (r2.isNull(0) == true) goto L9;
        r1 = Long.valueOf(r2.getLong(0));     // Catch: Throwable -> L11
        goto L9
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<String> getPackageNameList() {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.DoubaoAccountEntityRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(gb r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawDoubaoAccountEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((gb) ZeusTransformUtils.preCheckCast(r3, gb.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<gb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawDoubaoAccountEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gb> queryAll() {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gb> queryByEntityId(String r1, String r2) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gb> queryByEntityIdList(List<String> r3) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gb> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gb queryById(long r1) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gb> queryByIdAndTimestamp(long r1, long r3) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gb> queryByIds(List<Long> r3) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gb> queryByPackageName(String r1) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gb> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gb> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gb queryByUUID(String r1) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gb queryOne() {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gb> queryRecentByPackageName(String r1, long r2) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gb> queryWithLimitAndOffset(int r1, int r2) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gb> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawDoubaoAccountEntity(r6));     // Catch: Throwable -> L10
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

    public int update(gb r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawDoubaoAccountEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((gb) ZeusTransformUtils.preCheckCast(r3, gb.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<gb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawDoubaoAccountEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor updateByRawQuery(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        return this.__db.query(r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int updatePoisonLabelIfContentHashMatches(String r1, String r2, int r3, Integer r4) {
        return DoubaoAccountEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
