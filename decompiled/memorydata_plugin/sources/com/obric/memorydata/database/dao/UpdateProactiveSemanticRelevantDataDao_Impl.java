package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.iy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdateProactiveSemanticRelevantDataDao_Impl implements UpdateProactiveSemanticRelevantDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<iy> __deletionAdapterOfUpdateProactiveSemanticRelevantData;
    private final EntityInsertionAdapter<iy> __insertionAdapterOfUpdateProactiveSemanticRelevantData;
    private final EntityInsertionAdapter<iy> __insertionAdapterOfUpdateProactiveSemanticRelevantData_1;
    private final EntityDeletionOrUpdateAdapter<iy> __updateAdapterOfUpdateProactiveSemanticRelevantData;

    public UpdateProactiveSemanticRelevantDataDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfUpdateProactiveSemanticRelevantData = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfUpdateProactiveSemanticRelevantData_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfUpdateProactiveSemanticRelevantData = new AnonymousClass3(this, r2);
        this.__updateAdapterOfUpdateProactiveSemanticRelevantData = new AnonymousClass4(this, r2);
    }

    private iy __entityCursorConverter_comObricMemorydataDatabaseEntityUpdateProactiveSemanticRelevantData(Cursor r23) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r23, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "semantic_id");
        int r3 = CursorUtil.getColumnIndex(r0, "source_query");
        int r4 = CursorUtil.getColumnIndex(r0, "source_text");
        int r5 = CursorUtil.getColumnIndex(r0, "source_screenshot");
        int r6 = CursorUtil.getColumnIndex(r0, "source_app_name");
        int r7 = CursorUtil.getColumnIndex(r0, "source_package_name");
        int r8 = CursorUtil.getColumnIndex(r0, "detail_status");
        if (r1 != (-1)) goto L5;
        long r10 = 0;
    L6:
        long r13 = r10;
        String r9 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r15 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r16 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r17 = null;
    L25:
        if (r5 != (-1)) goto L28;
    L26:
        String r18 = null;
    L31:
        if (r6 != (-1)) goto L34;
    L32:
        String r19 = null;
    L37:
        if (r7 != (-1)) goto L40;
    L38:
        String r20 = r9;
        if (r8 != (-1)) goto L45;
        int r11 = 0;
    L47:
        return new iy(r13, r15, r16, r17, r18, r19, r20, r11);
    L45:
        r11 = r0.getInt(r8);
        goto L47
    L40:
        if (r0.isNull(r7) == true) goto L38;
        r9 = r0.getString(r7);
        goto L38
    L34:
        if (r0.isNull(r6) == true) goto L32;
        r19 = r0.getString(r6);
        goto L37
    L28:
        if (r0.isNull(r5) == true) goto L26;
        r18 = r0.getString(r5);
        goto L31
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r17 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r16 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r15 = r0.getString(r2);
        goto L13
    L5:
        r10 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<iy> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfUpdateProactiveSemanticRelevantData.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<iy> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUpdateProactiveSemanticRelevantData_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(iy r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfUpdateProactiveSemanticRelevantData.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(iy r3) {
        return delete2((iy) ZeusTransformUtils.preCheckCast(r3, iy.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return UpdateProactiveSemanticRelevantDataDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.UpdateProactiveSemanticRelevantDataDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return UpdateProactiveSemanticRelevantDataDao.DefaultImpls.getTableName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.UpdateProactiveSemanticRelevantDataDao
    public long insert(iy r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUpdateProactiveSemanticRelevantData.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(iy r3) {
        return insert((iy) ZeusTransformUtils.preCheckCast(r3, iy.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.UpdateProactiveSemanticRelevantDataDao, com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<iy> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfUpdateProactiveSemanticRelevantData.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.UpdateProactiveSemanticRelevantDataDao, com.obric.memorydata.database.dao.BaseDao
    public List<iy> queryAll() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM UpdateProactiveSemanticRelevantData", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "semantic_id");     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "source_query");     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "source_text");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "source_screenshot");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "source_app_name");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "source_package_name");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "detail_status");     // Catch: Throwable -> L34
        ArrayList r11 = new ArrayList(r2.getCount());     // Catch: Throwable -> L34
    L4:
        if (r2.moveToNext() == false) goto L32;
        long r14 = r2.getLong(r0);     // Catch: Throwable -> L34
        if (r2.isNull(r4) == false) goto L9;
        String r16 = null;
    L11:
        if (r2.isNull(r5) == false) goto L13;
        String r17 = null;
    L15:
        if (r2.isNull(r6) == false) goto L17;
        String r18 = null;
    L19:
        if (r2.isNull(r7) == false) goto L21;
        String r19 = null;
    L23:
        if (r2.isNull(r8) == false) goto L25;
        String r20 = null;
    L27:
        if (r2.isNull(r9) == false) goto L29;
        String r21 = null;
    L30:
        r11.add(new iy(r14, r16, r17, r18, r19, r20, r21, r2.getInt(r10)));     // Catch: Throwable -> L34
        goto L4
    L29:
        r21 = r2.getString(r9);     // Catch: Throwable -> L34
        goto L30
    L25:
        r20 = r2.getString(r8);     // Catch: Throwable -> L34
        goto L27
    L21:
        r19 = r2.getString(r7);     // Catch: Throwable -> L34
        goto L23
    L17:
        r18 = r2.getString(r6);     // Catch: Throwable -> L34
        goto L19
    L13:
        r17 = r2.getString(r5);     // Catch: Throwable -> L34
        goto L15
    L9:
        r16 = r2.getString(r4);     // Catch: Throwable -> L34
        goto L11
    L32:
        r2.close();
        r1.release();
        return r11;
    L34:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return UpdateProactiveSemanticRelevantDataDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public iy queryById(long r1) {
        return UpdateProactiveSemanticRelevantDataDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ iy queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<iy> queryByIds(List<Long> r3) {
        return UpdateProactiveSemanticRelevantDataDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.UpdateProactiveSemanticRelevantDataDao
    public iy queryBySemanticId(String r23) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM UpdateProactiveSemanticRelevantData WHERE semantic_id = ? LIMIT 1", 1);
        if (r23 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        iy r3 = null;
        String r4 = null;
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L36
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "semantic_id");     // Catch: Throwable -> L36
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "source_query");     // Catch: Throwable -> L36
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "source_text");     // Catch: Throwable -> L36
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "source_screenshot");     // Catch: Throwable -> L36
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "source_app_name");     // Catch: Throwable -> L36
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "source_package_name");     // Catch: Throwable -> L36
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "detail_status");     // Catch: Throwable -> L36
        if (r1.moveToFirst() == false) goto L34;
        long r13 = r1.getLong(r0);     // Catch: Throwable -> L36
        if (r1.isNull(r5) == false) goto L12;
        String r15 = null;
    L14:
        if (r1.isNull(r6) == false) goto L16;
        String r16 = null;
    L18:
        if (r1.isNull(r7) == false) goto L20;
        String r17 = null;
    L22:
        if (r1.isNull(r8) == false) goto L24;
        String r18 = null;
    L26:
        if (r1.isNull(r9) == false) goto L28;
        String r19 = null;
    L30:
        if (r1.isNull(r10) == true) goto L33;
        r4 = r1.getString(r10);     // Catch: Throwable -> L36
    L33:
        r3 = new iy(r13, r15, r16, r17, r18, r19, r4, r1.getInt(r11));     // Catch: Throwable -> L36
        goto L34
    L28:
        r19 = r1.getString(r9);     // Catch: Throwable -> L36
        goto L30
    L24:
        r18 = r1.getString(r8);     // Catch: Throwable -> L36
        goto L26
    L20:
        r17 = r1.getString(r7);     // Catch: Throwable -> L36
        goto L22
    L16:
        r16 = r1.getString(r6);     // Catch: Throwable -> L36
        goto L18
    L12:
        r15 = r1.getString(r5);     // Catch: Throwable -> L36
    L34:
        r1.close();
        r2.release();
        return r3;
    L36:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r23);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public iy queryByUUID(String r1) {
        return UpdateProactiveSemanticRelevantDataDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ iy queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public iy queryOne() {
        return UpdateProactiveSemanticRelevantDataDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ iy queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<iy> queryWithLimitAndOffset(int r1, int r2) {
        return UpdateProactiveSemanticRelevantDataDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<iy> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityUpdateProactiveSemanticRelevantData(r6));     // Catch: Throwable -> L10
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
    public int update2(iy r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfUpdateProactiveSemanticRelevantData.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(iy r3) {
        return update2((iy) ZeusTransformUtils.preCheckCast(r3, iy.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<iy> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfUpdateProactiveSemanticRelevantData.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
