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
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.gy;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class NoteRecordingTextRawDbDao_Impl implements NoteRecordingTextRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<gy> __deletionAdapterOfRawNoteRecordingTextEntity;
    private final EntityInsertionAdapter<gy> __insertionAdapterOfRawNoteRecordingTextEntity;
    private final EntityDeletionOrUpdateAdapter<gy> __updateAdapterOfRawNoteRecordingTextEntity;

    public NoteRecordingTextRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawNoteRecordingTextEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawNoteRecordingTextEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawNoteRecordingTextEntity = new AnonymousClass3(this, r2);
    }

    private gy __entityCursorConverter_comObricMemorydataDatabaseEntityRawNoteRecordingTextEntity(Cursor r37) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r37, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, "parentEntityId");
        int r10 = CursorUtil.getColumnIndex(r0, Params.CONTENT);
        int r11 = CursorUtil.getColumnIndex(r0, "passageDocNodeTreeJson");
        int r12 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r13 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r14 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r15 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r16 = 0;
        if (r1 != (-1)) goto L5;
        long r21 = 0;
    L6:
        String r17 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r23 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r24 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r26 = 0;
    L19:
        int r18 = 0;
        if (r5 != (-1)) goto L22;
        int r28 = 0;
    L23:
        if (r6 == (-1)) goto L26;
        r16 = r0.getLong(r6);
    L26:
        long r29 = r16;
        if (r7 != (-1)) goto L30;
    L28:
        String r31 = null;
    L33:
        if (r8 == (-1)) goto L36;
        r18 = r0.getInt(r8);
    L36:
        int r32 = r18;
        if (r9 != (-1)) goto L40;
    L38:
        String r33 = null;
    L43:
        if (r10 != (-1)) goto L46;
    L44:
        String r34 = null;
    L49:
        if (r11 != (-1)) goto L52;
    L50:
        String r35 = null;
    L55:
        gy r19 = new gy(r21, r23, r24, r26, r28, r29, r31, r32, r33, r34, r35);
        if (r12 != (-1)) goto L58;
    L62:
        if (r13 != (-1)) goto L64;
    L68:
        if (r14 == (-1)) goto L75;
        if (r0.isNull(r14) == false) goto L72;
        Integer r20 = null;
    L73:
        r19.setPoisonLabelVersion(r20);
        goto L75
    L72:
        r20 = Integer.valueOf(r0.getInt(r14));
    L75:
        if (r15 != (-1)) goto L77;
    L81:
        return r19;
    L77:
        if (r0.isNull(r15) == true) goto L80;
        r17 = r0.getString(r15);
    L80:
        r19.setContentHash(r17);
        goto L81
    L64:
        if (r0.isNull(r13) == false) goto L66;
        Integer r22 = null;
    L67:
        r19.setPoisonLabel(r22);
        goto L68
    L66:
        r22 = Integer.valueOf(r0.getInt(r13));
        goto L67
    L58:
        if (r0.isNull(r12) == false) goto L60;
        String r25 = null;
    L61:
        r19.setUuid(r25);
        goto L62
    L60:
        r25 = r0.getString(r12);
        goto L61
    L52:
        if (r0.isNull(r11) == true) goto L50;
        r35 = r0.getString(r11);
        goto L55
    L46:
        if (r0.isNull(r10) == true) goto L44;
        r34 = r0.getString(r10);
        goto L49
    L40:
        if (r0.isNull(r9) == true) goto L38;
        r33 = r0.getString(r9);
        goto L43
    L30:
        if (r0.isNull(r7) == true) goto L28;
        r31 = r0.getString(r7);
        goto L33
    L22:
        r28 = r0.getInt(r5);
        goto L23
    L18:
        r26 = r0.getLong(r4);
        goto L19
    L15:
        r24 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r23 = r0.getString(r2);
        goto L13
    L5:
        r21 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return NoteRecordingTextRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<gy> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawNoteRecordingTextEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<gy> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawNoteRecordingTextEntity.insert(r4);     // Catch: Throwable -> L6
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

    public int delete(gy r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawNoteRecordingTextEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((gy) ZeusTransformUtils.preCheckCast(r3, gy.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return NoteRecordingTextRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawFileTextDbDao
    public int deleteByParentId(String r1) {
        return NoteRecordingTextRawDbDao.DefaultImpls.deleteByParentId(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return NoteRecordingTextRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
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
        return NoteRecordingTextRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return NoteRecordingTextRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return NoteRecordingTextRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
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
        return NoteRecordingTextRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return NoteRecordingTextRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
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
        return NoteRecordingTextRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.NoteRecordingTextRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return NoteRecordingTextRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(gy r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawNoteRecordingTextEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((gy) ZeusTransformUtils.preCheckCast(r3, gy.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<gy> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawNoteRecordingTextEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gy> queryAll() {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gy> queryByEntityId(String r1, String r2) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gy> queryByEntityIdList(List<String> r3) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gy> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gy queryById(long r1) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gy> queryByIdAndTimestamp(long r1, long r3) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gy> queryByIds(List<Long> r3) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gy> queryByPackageName(String r1) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gy> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gy> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawFileTextDbDao
    public List<gy> queryByParentEntityId(String r1) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryByParentEntityId(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gy queryByUUID(String r1) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawFileTextDbDao
    public List<String> queryEntityIdByParentEntityIds(List<String> r3) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryEntityIdByParentEntityIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gy queryOne() {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gy> queryRecentByPackageName(String r1, long r2) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gy> queryWithLimitAndOffset(int r1, int r2) {
        return NoteRecordingTextRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gy> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawNoteRecordingTextEntity(r6));     // Catch: Throwable -> L10
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

    public int update(gy r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawNoteRecordingTextEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((gy) ZeusTransformUtils.preCheckCast(r3, gy.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<gy> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawNoteRecordingTextEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return NoteRecordingTextRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
