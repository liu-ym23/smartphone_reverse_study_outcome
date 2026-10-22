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
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.memorydata.database.entity.ScreenObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ScreenObservationDao_Impl implements ScreenObservationDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ScreenObservationEntity> __deletionAdapterOfScreenObservationEntity;
    private final EntityInsertionAdapter<ScreenObservationEntity> __insertionAdapterOfScreenObservationEntity;
    private final SharedSQLiteStatement __preparedStmtOfClearTable;
    private final SharedSQLiteStatement __preparedStmtOfResetSequence;
    private final EntityDeletionOrUpdateAdapter<ScreenObservationEntity> __updateAdapterOfScreenObservationEntity;

    public ScreenObservationDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfScreenObservationEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfScreenObservationEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfScreenObservationEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfClearTable = new AnonymousClass4(this, r2);
        this.__preparedStmtOfResetSequence = new AnonymousClass5(this, r2);
    }

    private ScreenObservationEntity __entityCursorConverter_comObricMemorydataDatabaseEntityScreenObservationEntity(Cursor r50) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r50, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r3 = CursorUtil.getColumnIndex(r0, "trigger_type");
        int r4 = CursorUtil.getColumnIndex(r0, Api.KEY_APP_NAME);
        int r5 = CursorUtil.getColumnIndex(r0, "package_name");
        int r6 = CursorUtil.getColumnIndex(r0, "screenshot_path");
        int r7 = CursorUtil.getColumnIndex(r0, "image_tos_key");
        int r8 = CursorUtil.getColumnIndex(r0, "location");
        int r9 = CursorUtil.getColumnIndex(r0, "location_state");
        int r10 = CursorUtil.getColumnIndex(r0, "movement_state");
        int r11 = CursorUtil.getColumnIndex(r0, "click_detail");
        int r12 = CursorUtil.getColumnIndex(r0, "scroll_detail");
        int r13 = CursorUtil.getColumnIndex(r0, WsConstants.KEY_EXTRA);
        int r14 = CursorUtil.getColumnIndex(r0, "state");
        int r15 = CursorUtil.getColumnIndex(r0, TypedValues.AttributesType.S_TARGET);
        int r16 = CursorUtil.getColumnIndex(r0, "filter_result");
        int r17 = CursorUtil.getColumnIndex(r0, "is_image_filter_finish");
        int r18 = CursorUtil.getColumnIndex(r0, "retry_time");
        int r19 = CursorUtil.getColumnIndex(r0, "logId");
        int r110 = CursorUtil.getColumnIndex(r0, "rule_ids");
        int r111 = CursorUtil.getColumnIndex(r0, "activity_name");
        long r20 = 0;
        if (r1 != (-1)) goto L5;
        long r26 = 0;
    L6:
        if (r2 == (-1)) goto L9;
        r20 = r0.getLong(r2);
    L9:
        long r28 = r20;
        if (r3 != (-1)) goto L13;
    L11:
        String r30 = null;
    L16:
        if (r4 != (-1)) goto L19;
    L17:
        String r31 = null;
    L22:
        if (r5 != (-1)) goto L25;
    L23:
        String r32 = null;
    L28:
        if (r6 != (-1)) goto L31;
    L29:
        String r33 = null;
    L34:
        if (r7 != (-1)) goto L37;
    L35:
        String r34 = null;
    L40:
        if (r8 != (-1)) goto L43;
    L41:
        String r35 = null;
    L46:
        if (r9 != (-1)) goto L49;
    L47:
        String r36 = null;
    L52:
        if (r10 != (-1)) goto L55;
    L53:
        String r37 = null;
    L58:
        if (r11 != (-1)) goto L61;
    L59:
        String r38 = null;
    L64:
        if (r12 != (-1)) goto L67;
    L65:
        String r39 = null;
    L70:
        if (r13 != (-1)) goto L73;
    L71:
        String r40 = null;
    L76:
        int r21 = 0;
        if (r14 != (-1)) goto L79;
        int r41 = 0;
    L80:
        if (r49 != (-1)) goto L83;
    L81:
        String r42 = null;
    L86:
        if (r50 != (-1)) goto L88;
        int r43 = 0;
    L90:
        if (r17 != (-1)) goto L92;
        int r44 = 0;
    L94:
        if (r18 == (-1)) goto L97;
        r21 = r0.getInt(r18);
    L97:
        int r45 = r21;
        if (r19 != (-1)) goto L102;
    L99:
        String r46 = null;
    L105:
        if (r110 != (-1)) goto L109;
    L106:
        String r47 = null;
    L112:
        if (r111 != (-1)) goto L115;
    L113:
        String r48 = null;
    L119:
        return new ScreenObservationEntity(r26, r28, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48);
    L115:
        if (r0.isNull(r111) == true) goto L113;
        r48 = r0.getString(r111);
        goto L119
    L109:
        if (r0.isNull(r110) == true) goto L106;
        r47 = r0.getString(r110);
        goto L112
    L102:
        if (r0.isNull(r19) == true) goto L99;
        r46 = r0.getString(r19);
        goto L105
    L92:
        r44 = r0.getInt(r17);
        goto L94
    L88:
        r43 = r0.getInt(r16);
        goto L90
    L83:
        if (r0.isNull(r49) == true) goto L81;
        r42 = r0.getString(r15);
        goto L86
    L79:
        r41 = r0.getInt(r14);
        goto L80
    L73:
        if (r0.isNull(r13) == true) goto L71;
        r40 = r0.getString(r13);
        goto L76
    L67:
        if (r0.isNull(r12) == true) goto L65;
        r39 = r0.getString(r12);
        goto L70
    L61:
        if (r0.isNull(r11) == true) goto L59;
        r38 = r0.getString(r11);
        goto L64
    L55:
        if (r0.isNull(r10) == true) goto L53;
        r37 = r0.getString(r10);
        goto L58
    L49:
        if (r0.isNull(r9) == true) goto L47;
        r36 = r0.getString(r9);
        goto L52
    L43:
        if (r0.isNull(r8) == true) goto L41;
        r35 = r0.getString(r8);
        goto L46
    L37:
        if (r0.isNull(r7) == true) goto L35;
        r34 = r0.getString(r7);
        goto L40
    L31:
        if (r0.isNull(r6) == true) goto L29;
        r33 = r0.getString(r6);
        goto L34
    L25:
        if (r0.isNull(r5) == true) goto L23;
        r32 = r0.getString(r5);
        goto L28
    L19:
        if (r0.isNull(r4) == true) goto L17;
        r31 = r0.getString(r4);
        goto L22
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r30 = r0.getString(r3);
        goto L16
    L5:
        r26 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ScreenObservationEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfScreenObservationEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ScreenObservationEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfScreenObservationEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ScreenObservationDao
    public void clearTable() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfClearTable.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfClearTable.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfClearTable.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.ScreenObservationDao
    public void clearTableAndResetId() {
        this.__db.beginTransaction();
        ScreenObservationDao.DefaultImpls.clearTableAndResetId(this);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(ScreenObservationEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfScreenObservationEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(ScreenObservationEntity r3) {
        return delete2((ScreenObservationEntity) ZeusTransformUtils.preCheckCast(r3, ScreenObservationEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ScreenObservationDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.ScreenObservationDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ScreenObservationDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(ScreenObservationEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfScreenObservationEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(ScreenObservationEntity r3) {
        return insert2((ScreenObservationEntity) ZeusTransformUtils.preCheckCast(r3, ScreenObservationEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ScreenObservationEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfScreenObservationEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ScreenObservationEntity> queryAll() {
        return ScreenObservationDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ScreenObservationDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ScreenObservationEntity queryById(long r1) {
        return ScreenObservationDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ScreenObservationEntity queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ScreenObservationEntity> queryByIds(List<Long> r3) {
        return ScreenObservationDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ScreenObservationEntity queryByUUID(String r1) {
        return ScreenObservationDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ScreenObservationEntity queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ScreenObservationEntity queryOne() {
        return ScreenObservationDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ScreenObservationEntity queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.ScreenObservationDao
    public List<String> queryScreenshotPathsByIds(List<Long> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT screenshot_path FROM ScreenObservation WHERE id IN (");
        int r2 = r9.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND screenshot_path != ''");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r10 = r9.iterator();
        int r4 = 1;
    L4:
        if (r10.hasNext() == false) goto L6;
        r1.bindLong(r4, ((Long) ZeusTransformUtils.preCheckCast(r10.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r4 = r4 + 1;
        goto L4
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r1, false, null);
        ArrayList r3 = new ArrayList(r7.getCount());     // Catch: Throwable -> L18
    L8:
        if (r7.moveToNext() == false) goto L16;
        if (r7.isNull(0) == false) goto L13;
        String r5 = null;
    L14:
        r3.add(r5);     // Catch: Throwable -> L18
        goto L8
    L13:
        r5 = r7.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r7.close();
        r1.release();
        return r3;
    L18:
        th = move-exception;
        r7.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ScreenObservationEntity> queryWithLimitAndOffset(int r1, int r2) {
        return ScreenObservationDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ScreenObservationEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityScreenObservationEntity(r6));     // Catch: Throwable -> L10
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

    @Override // com.obric.memorydata.database.dao.ScreenObservationDao
    public void resetSequence() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfResetSequence.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfResetSequence.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfResetSequence.release(r0);
        throw th;
    }

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public int update2(ScreenObservationEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfScreenObservationEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(ScreenObservationEntity r3) {
        return update2((ScreenObservationEntity) ZeusTransformUtils.preCheckCast(r3, ScreenObservationEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ScreenObservationEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfScreenObservationEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
