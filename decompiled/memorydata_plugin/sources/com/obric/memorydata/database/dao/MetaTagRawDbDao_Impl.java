package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.gs;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaTagRawDbDao_Impl implements MetaTagRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<gs> __deletionAdapterOfRawMetaTagEntity;
    private final EntityInsertionAdapter<gs> __insertionAdapterOfRawMetaTagEntity;
    private final EntityDeletionOrUpdateAdapter<gs> __updateAdapterOfRawMetaTagEntity;

    public MetaTagRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawMetaTagEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawMetaTagEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawMetaTagEntity = new AnonymousClass3(this, r2);
    }

    private gs __entityCursorConverter_comObricMemorydataDatabaseEntityRawMetaTagEntity(Cursor r34) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r34, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, "sourceType");
        int r10 = CursorUtil.getColumnIndex(r0, "tagName");
        int r11 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r12 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r13 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r14 = CursorUtil.getColumnIndex(r0, "content_hash");
        if (r1 != (-1)) goto L5;
        long r19 = 0;
    L6:
        String r15 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r21 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r22 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r24 = 0;
    L19:
        int r16 = 0;
        if (r5 != (-1)) goto L22;
        int r26 = 0;
    L23:
        if (r6 != (-1)) goto L25;
        long r27 = 0;
    L26:
        if (r7 != (-1)) goto L29;
    L27:
        String r29 = null;
    L32:
        if (r8 != (-1)) goto L34;
        int r30 = 0;
    L35:
        if (r9 == (-1)) goto L38;
        r16 = r0.getInt(r9);
    L38:
        int r31 = r16;
        if (r10 != (-1)) goto L42;
    L40:
        String r32 = null;
    L45:
        gs r17 = new gs(r19, r21, r22, r24, r26, r27, r29, r30, r31, r32);
        if (r11 != (-1)) goto L48;
    L52:
        if (r12 != (-1)) goto L54;
    L58:
        if (r13 != (-1)) goto L60;
    L64:
        if (r14 != (-1)) goto L66;
    L70:
        return r17;
    L66:
        if (r0.isNull(r14) == true) goto L69;
        r15 = r0.getString(r14);
    L69:
        r17.setContentHash(r15);
        goto L70
    L60:
        if (r0.isNull(r13) == false) goto L62;
        Integer r18 = null;
    L63:
        r17.setPoisonLabelVersion(r18);
        goto L64
    L62:
        r18 = Integer.valueOf(r0.getInt(r13));
        goto L63
    L54:
        if (r0.isNull(r12) == false) goto L56;
        Integer r20 = null;
    L57:
        r17.setPoisonLabel(r20);
        goto L58
    L56:
        r20 = Integer.valueOf(r0.getInt(r12));
        goto L57
    L48:
        if (r0.isNull(r11) == false) goto L50;
        String r23 = null;
    L51:
        r17.setUuid(r23);
        goto L52
    L50:
        r23 = r0.getString(r11);
        goto L51
    L42:
        if (r0.isNull(r10) == true) goto L40;
        r32 = r0.getString(r10);
        goto L45
    L34:
        r30 = r0.getInt(r8);
        goto L35
    L29:
        if (r0.isNull(r7) == true) goto L27;
        r29 = r0.getString(r7);
        goto L32
    L25:
        r27 = r0.getLong(r6);
        goto L26
    L22:
        r26 = r0.getInt(r5);
        goto L23
    L18:
        r24 = r0.getLong(r4);
        goto L19
    L15:
        r22 = r0.getLong(r3);
        goto L16
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

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return MetaTagRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<gs> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawMetaTagEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<gs> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawMetaTagEntity.insert(r4);     // Catch: Throwable -> L6
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

    public int delete(gs r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawMetaTagEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((gs) ZeusTransformUtils.preCheckCast(r3, gs.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return MetaTagRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return MetaTagRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
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
        return MetaTagRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return MetaTagRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return MetaTagRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
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
        return MetaTagRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return MetaTagRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
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
        return MetaTagRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.MetaTagRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MetaTagRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(gs r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawMetaTagEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((gs) ZeusTransformUtils.preCheckCast(r3, gs.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<gs> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawMetaTagEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gs> queryAll() {
        return MetaTagRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MetaTagRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gs> queryByEntityId(String r1, String r2) {
        return MetaTagRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gs> queryByEntityIdList(List<String> r3) {
        return MetaTagRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gs> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return MetaTagRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gs queryById(long r1) {
        return MetaTagRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gs> queryByIdAndTimestamp(long r1, long r3) {
        return MetaTagRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gs> queryByIds(List<Long> r3) {
        return MetaTagRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return MetaTagRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gs> queryByPackageName(String r1) {
        return MetaTagRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gs> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return MetaTagRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gs> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return MetaTagRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gs queryByUUID(String r1) {
        return MetaTagRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gs queryOne() {
        return MetaTagRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.MetaTagRawDbDao
    public gs queryOneRecord(String r33, String r34) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM RawMetaTagEntity WHERE tagName = ? AND packageName = ? LIMIT 1", 2);
        if (r33 != null) goto L5;
        r3.bindNull(1);
    L6:
        if (r34 != null) goto L8;
        r3.bindNull(2);
    L9:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L45
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "entityId");     // Catch: Throwable -> L45
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "createTime");     // Catch: Throwable -> L45
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "modifyTime");     // Catch: Throwable -> L45
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L45
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L45
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L45
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "hashCodeValue");     // Catch: Throwable -> L45
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "sourceType");     // Catch: Throwable -> L45
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "tagName");     // Catch: Throwable -> L45
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, Api.KEY_UUID);     // Catch: Throwable -> L45
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "poison_label");     // Catch: Throwable -> L45
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "poison_label_version");     // Catch: Throwable -> L45
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, "content_hash");     // Catch: Throwable -> L45
        if (r1.moveToFirst() == false) goto L42;
        long r18 = r1.getLong(r0);     // Catch: Throwable -> L45
        if (r1.isNull(r4) == false) goto L15;
        String r20 = null;
    L16:
        long r21 = r1.getLong(r5);     // Catch: Throwable -> L45
        long r23 = r1.getLong(r6);     // Catch: Throwable -> L45
        int r25 = r1.getInt(r7);     // Catch: Throwable -> L45
        long r26 = r1.getLong(r8);     // Catch: Throwable -> L45
        if (r1.isNull(r9) == false) goto L19;
        String r28 = null;
    L20:
        int r29 = r1.getInt(r10);     // Catch: Throwable -> L45
        int r30 = r1.getInt(r11);     // Catch: Throwable -> L45
        if (r1.isNull(r12) == false) goto L23;
        String r31 = null;
    L24:
        gs r16 = new gs(r18, r20, r21, r23, r25, r26, r28, r29, r30, r31);     // Catch: Throwable -> L45
        if (r1.isNull(r13) == false) goto L27;
        String r17 = null;
    L28:
        r16.setUuid(r17);     // Catch: Throwable -> L45
        if (r1.isNull(r14) == false) goto L31;
        Integer r19 = null;
    L32:
        r16.setPoisonLabel(r19);     // Catch: Throwable -> L45
        if (r1.isNull(r15) == false) goto L35;
        Integer r22 = null;
    L36:
        r16.setPoisonLabelVersion(r22);     // Catch: Throwable -> L45
        if (r1.isNull(r2) == false) goto L39;
        String r24 = null;
    L40:
        r16.setContentHash(r24);     // Catch: Throwable -> L45
        gs r27 = r16;
    L43:
        r1.close();
        r3.release();
        return r27;
    L39:
        r24 = r1.getString(r2);     // Catch: Throwable -> L45
        goto L40
    L35:
        r22 = Integer.valueOf(r1.getInt(r15));     // Catch: Throwable -> L45
        goto L36
    L31:
        r19 = Integer.valueOf(r1.getInt(r14));     // Catch: Throwable -> L45
        goto L32
    L27:
        r17 = r1.getString(r13);     // Catch: Throwable -> L45
        goto L28
    L23:
        r31 = r1.getString(r12);     // Catch: Throwable -> L45
        goto L24
    L19:
        r28 = r1.getString(r9);     // Catch: Throwable -> L45
        goto L20
    L15:
        r20 = r1.getString(r4);     // Catch: Throwable -> L45
        goto L16
    L42:
        r27 = null;
    L45:
        th = move-exception;
        r1.close();
        r3.release();
        throw th;
    L8:
        r3.bindString(2, r34);
        goto L9
    L5:
        r3.bindString(1, r33);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gs> queryRecentByPackageName(String r1, long r2) {
        return MetaTagRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gs> queryWithLimitAndOffset(int r1, int r2) {
        return MetaTagRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gs> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawMetaTagEntity(r6));     // Catch: Throwable -> L10
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

    public int update(gs r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawMetaTagEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((gs) ZeusTransformUtils.preCheckCast(r3, gs.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<gs> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawMetaTagEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return MetaTagRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
