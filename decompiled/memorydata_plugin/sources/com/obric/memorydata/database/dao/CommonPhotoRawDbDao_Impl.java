package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.ft;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class CommonPhotoRawDbDao_Impl implements CommonPhotoRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ft> __deletionAdapterOfRawCommonPhotoEntity;
    private final EntityInsertionAdapter<ft> __insertionAdapterOfRawCommonPhotoEntity;
    private final EntityDeletionOrUpdateAdapter<ft> __updateAdapterOfRawCommonPhotoEntity;

    public CommonPhotoRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawCommonPhotoEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawCommonPhotoEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawCommonPhotoEntity = new AnonymousClass3(this, r2);
    }

    private ft __entityCursorConverter_comObricMemorydataDatabaseEntityRawCommonPhotoEntity(Cursor r45) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r45, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r10 = CursorUtil.getColumnIndex(r0, "file");
        int r11 = CursorUtil.getColumnIndex(r0, "assetType");
        int r12 = CursorUtil.getColumnIndex(r0, "caption");
        int r13 = CursorUtil.getColumnIndex(r0, "ocr");
        int r14 = CursorUtil.getColumnIndex(r0, "rawDbType");
        int r15 = CursorUtil.getColumnIndex(r0, "rawEntityId");
        int r16 = CursorUtil.getColumnIndex(r0, "rawDbColumn");
        int r17 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r18 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r19 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r110 = 0;
        if (r1 != (-1)) goto L5;
        long r24 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r26 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r27 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r29 = 0;
    L19:
        int r21 = 0;
        if (r5 != (-1)) goto L22;
        int r31 = 0;
    L23:
        if (r6 == (-1)) goto L26;
        r110 = r0.getLong(r6);
    L26:
        long r32 = r110;
        if (r7 != (-1)) goto L30;
    L28:
        String r34 = null;
    L33:
        if (r8 != (-1)) goto L35;
        int r35 = 0;
    L36:
        if (r9 != (-1)) goto L39;
    L37:
        String r36 = null;
    L42:
        if (r10 != (-1)) goto L45;
    L43:
        String r37 = null;
    L48:
        if (r11 != (-1)) goto L51;
    L49:
        String r38 = null;
    L54:
        if (r12 != (-1)) goto L57;
    L55:
        String r39 = null;
    L60:
        if (r13 != (-1)) goto L63;
    L61:
        String r40 = null;
    L66:
        if (r14 == (-1)) goto L69;
        r21 = r0.getInt(r14);
    L69:
        int r41 = r21;
        if (r15 != (-1)) goto L73;
    L71:
        String r42 = null;
    L76:
        if (r45 != (-1)) goto L79;
    L77:
        String r43 = null;
    L82:
        ft r22 = new ft(r24, r26, r27, r29, r31, r32, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43);
        if (r17 == (-1)) goto L90;
        if (r0.isNull(r17) == false) goto L87;
        Integer r23 = null;
    L88:
        r22.setPoisonLabel(r23);
        goto L90
    L87:
        r23 = Integer.valueOf(r0.getInt(r17));
    L90:
        if (r18 == (-1)) goto L97;
        if (r0.isNull(r18) == false) goto L94;
        Integer r25 = null;
    L95:
        r22.setPoisonLabelVersion(r25);
        goto L97
    L94:
        r25 = Integer.valueOf(r0.getInt(r18));
    L97:
        if (r19 != (-1)) goto L99;
    L103:
        return r22;
    L99:
        if (r0.isNull(r19) == true) goto L102;
        r20 = r0.getString(r19);
    L102:
        r22.setContentHash(r20);
        goto L103
    L79:
        if (r0.isNull(r45) == true) goto L77;
        r43 = r0.getString(r16);
        goto L82
    L73:
        if (r0.isNull(r15) == true) goto L71;
        r42 = r0.getString(r15);
        goto L76
    L63:
        if (r0.isNull(r13) == true) goto L61;
        r40 = r0.getString(r13);
        goto L66
    L57:
        if (r0.isNull(r12) == true) goto L55;
        r39 = r0.getString(r12);
        goto L60
    L51:
        if (r0.isNull(r11) == true) goto L49;
        r38 = r0.getString(r11);
        goto L54
    L45:
        if (r0.isNull(r10) == true) goto L43;
        r37 = r0.getString(r10);
        goto L48
    L39:
        if (r0.isNull(r9) == true) goto L37;
        r36 = r0.getString(r9);
        goto L42
    L35:
        r35 = r0.getInt(r8);
        goto L36
    L30:
        if (r0.isNull(r7) == true) goto L28;
        r34 = r0.getString(r7);
        goto L33
    L22:
        r31 = r0.getInt(r5);
        goto L23
    L18:
        r29 = r0.getLong(r4);
        goto L19
    L15:
        r27 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r26 = r0.getString(r2);
        goto L13
    L5:
        r24 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return CommonPhotoRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ft> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawCommonPhotoEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ft> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawCommonPhotoEntity.insert(r4);     // Catch: Throwable -> L6
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

    public int delete(ft r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawCommonPhotoEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((ft) ZeusTransformUtils.preCheckCast(r3, ft.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return CommonPhotoRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.CommonPhotoRawDbDao
    public int deleteByEntityIds(List<String> r8, String r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM RawCommonPhotoEntity WHERE entityId IN (");
        int r2 = r10.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND packageName = ");
        r0.append("?");
        SupportSQLiteStatement r1 = this.__db.compileStatement(r0.toString());
        Iterator r11 = r10.iterator();
        int r4 = 1;
    L4:
        if (r11.hasNext() == false) goto L10;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
        r1.bindNull(r4);
    L9:
        r4 = r4 + 1;
        goto L4
    L8:
        r1.bindString(r4, r5);
        goto L9
    L10:
        int r3 = r2 + 1;
        if (r9 != null) goto L13;
        r1.bindNull(r3);
    L14:
        this.__db.beginTransaction();
        int r12 = r1.executeUpdateDelete();     // Catch: Throwable -> L18
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L18
        this.__db.endTransaction();
        return r12;
    L18:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L13:
        r1.bindString(r3, r9);
        goto L14
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return CommonPhotoRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
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
        return CommonPhotoRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return CommonPhotoRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return CommonPhotoRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
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
        return CommonPhotoRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return CommonPhotoRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
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
        return CommonPhotoRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.CommonPhotoRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return CommonPhotoRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(ft r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawCommonPhotoEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((ft) ZeusTransformUtils.preCheckCast(r3, ft.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ft> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawCommonPhotoEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ft> queryAll() {
        return CommonPhotoRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return CommonPhotoRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ft> queryByEntityId(String r1, String r2) {
        return CommonPhotoRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ft> queryByEntityIdList(List<String> r3) {
        return CommonPhotoRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ft> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return CommonPhotoRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ft queryById(long r1) {
        return CommonPhotoRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ft> queryByIdAndTimestamp(long r1, long r3) {
        return CommonPhotoRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ft> queryByIds(List<Long> r3) {
        return CommonPhotoRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return CommonPhotoRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ft> queryByPackageName(String r1) {
        return CommonPhotoRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ft> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return CommonPhotoRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ft> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return CommonPhotoRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ft queryByUUID(String r1) {
        return CommonPhotoRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.CommonPhotoRawDbDao
    public String queryCaptionById(String r4) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT caption FROM RawCommonPhotoEntity WHERE id = ? LIMIT 1", 1);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        String r1 = null;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L15:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L8:
        if (r3.moveToFirst() == true) goto L10;
    L13:
        r3.close();
        r0.release();
        return r1;
    L10:
        if (r3.isNull(0) == true) goto L13;
        r1 = r3.getString(0);     // Catch: Throwable -> L15
        goto L13
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.CommonPhotoRawDbDao
    public List<ft> queryEntitiesByOriginalEntity(int r42, String r43, String r44) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM RawCommonPhotoEntity WHERE rawDbType = ? AND rawEntityId = ? AND packageName = ?", 3);
        r3.bindLong(1, r42);
        if (r43 != null) goto L5;
        r3.bindNull(2);
    L6:
        if (r44 != null) goto L8;
        r3.bindNull(3);
    L9:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L70
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "entityId");     // Catch: Throwable -> L70
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "createTime");     // Catch: Throwable -> L70
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "modifyTime");     // Catch: Throwable -> L70
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L70
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L70
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L70
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "hashCodeValue");     // Catch: Throwable -> L70
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, Api.KEY_UUID);     // Catch: Throwable -> L70
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "file");     // Catch: Throwable -> L70
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "assetType");     // Catch: Throwable -> L70
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "caption");     // Catch: Throwable -> L70
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "ocr");     // Catch: Throwable -> L70
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, "rawDbType");     // Catch: Throwable -> L70
        RoomSQLiteQuery r16 = r3;
        int r45 = CursorUtil.getColumnIndexOrThrow(r1, "rawEntityId");     // Catch: Throwable -> L68
        int r46 = CursorUtil.getColumnIndexOrThrow(r1, "rawDbColumn");     // Catch: Throwable -> L68
        int r47 = CursorUtil.getColumnIndexOrThrow(r1, "poison_label");     // Catch: Throwable -> L68
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "poison_label_version");     // Catch: Throwable -> L68
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "content_hash");     // Catch: Throwable -> L68
        int r19 = r2;
        ArrayList r20 = new ArrayList(r1.getCount());     // Catch: Throwable -> L68
    L13:
        if (r1.moveToNext() == false) goto L66;
        long r21 = r1.getLong(r0);     // Catch: Throwable -> L68
        if (r1.isNull(r4) == false) goto L18;
        String r23 = null;
    L19:
        long r24 = r1.getLong(r5);     // Catch: Throwable -> L68
        long r26 = r1.getLong(r6);     // Catch: Throwable -> L68
        int r28 = r1.getInt(r7);     // Catch: Throwable -> L68
        long r29 = r1.getLong(r8);     // Catch: Throwable -> L68
        if (r1.isNull(r9) == false) goto L22;
        String r31 = null;
    L23:
        int r32 = r1.getInt(r10);     // Catch: Throwable -> L68
        if (r1.isNull(r11) == false) goto L26;
        String r33 = null;
    L28:
        if (r1.isNull(r12) == false) goto L30;
        String r34 = null;
    L32:
        if (r1.isNull(r13) == false) goto L34;
        String r35 = null;
    L36:
        if (r1.isNull(r14) == false) goto L38;
        String r36 = null;
    L40:
        if (r1.isNull(r15) == false) goto L42;
        String r37 = null;
    L43:
        int r38 = r1.getInt(r19);     // Catch: Throwable -> L68
        int r110 = r0;
        r45 = r45;
        if (r1.isNull(r45) == false) goto L47;
        String r39 = null;
    L46:
        r46 = r46;
        if (r1.isNull(r46) == false) goto L51;
        String r40 = null;
    L52:
        ft r22 = new ft(r21, r23, r24, r26, r28, r29, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40);     // Catch: Throwable -> L68
        int r25 = r19;
        r47 = r47;
        if (r1.isNull(r47) == false) goto L55;
        Integer r27 = null;
    L56:
        r22.setPoisonLabel(r27);     // Catch: Throwable -> L68
        int r30 = r17;
        if (r1.isNull(r30) == false) goto L59;
        Integer r41 = null;
    L60:
        r22.setPoisonLabelVersion(r41);     // Catch: Throwable -> L68
        r18 = r18;
        if (r1.isNull(r18) == false) goto L63;
        String r48 = null;
    L64:
        r22.setContentHash(r48);     // Catch: Throwable -> L68
        r20.add(r22);     // Catch: Throwable -> L68
        r0 = r110;
        r19 = r25;
        r17 = r30;
        goto L13
    L63:
        r48 = r1.getString(r18);     // Catch: Throwable -> L68
        goto L64
    L59:
        r41 = Integer.valueOf(r1.getInt(r30));     // Catch: Throwable -> L68
        goto L60
    L55:
        r27 = Integer.valueOf(r1.getInt(r47));     // Catch: Throwable -> L68
        goto L56
    L51:
        r40 = r1.getString(r46);     // Catch: Throwable -> L68
        goto L52
    L47:
        r39 = r1.getString(r45);     // Catch: Throwable -> L68
        goto L46
    L42:
        r37 = r1.getString(r15);     // Catch: Throwable -> L68
        goto L43
    L38:
        r36 = r1.getString(r14);     // Catch: Throwable -> L68
        goto L40
    L34:
        r35 = r1.getString(r13);     // Catch: Throwable -> L68
        goto L36
    L30:
        r34 = r1.getString(r12);     // Catch: Throwable -> L68
        goto L32
    L26:
        r33 = r1.getString(r11);     // Catch: Throwable -> L68
        goto L28
    L22:
        r31 = r1.getString(r9);     // Catch: Throwable -> L68
        goto L23
    L18:
        r23 = r1.getString(r4);     // Catch: Throwable -> L68
        goto L19
    L66:
        r1.close();
        r16.release();
        return r20;
    L68:
        th = th;
    L72:
        r1.close();
        r16.release();
        throw th;
    L70:
        th = th;
        r16 = r3;
        goto L72
    L8:
        r3.bindString(3, r44);
        goto L9
    L5:
        r3.bindString(2, r43);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.CommonPhotoRawDbDao
    public List<ft> queryEntitiesByOriginalEntityAndColumn(int r41, String r42, String r43, String r44) {
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("SELECT * FROM RawCommonPhotoEntity WHERE rawDbType = ? AND rawEntityId = ? AND rawDbColumn = ? AND packageName = ?", 4);
        r4.bindLong(1, r41);
        if (r42 != null) goto L5;
        r4.bindNull(2);
    L7:
        if (r43 != null) goto L9;
        r4.bindNull(3);
    L10:
        if (r44 != null) goto L12;
        r4.bindNull(4);
    L13:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r4, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L74
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "entityId");     // Catch: Throwable -> L74
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "createTime");     // Catch: Throwable -> L74
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "modifyTime");     // Catch: Throwable -> L74
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L74
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L74
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L74
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "hashCodeValue");     // Catch: Throwable -> L74
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, Api.KEY_UUID);     // Catch: Throwable -> L74
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "file");     // Catch: Throwable -> L74
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "assetType");     // Catch: Throwable -> L74
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "caption");     // Catch: Throwable -> L74
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "ocr");     // Catch: Throwable -> L74
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, "rawDbType");     // Catch: Throwable -> L74
        RoomSQLiteQuery r16 = r4;
        int r45 = CursorUtil.getColumnIndexOrThrow(r1, "rawEntityId");     // Catch: Throwable -> L72
        int r46 = CursorUtil.getColumnIndexOrThrow(r1, "rawDbColumn");     // Catch: Throwable -> L72
        int r47 = CursorUtil.getColumnIndexOrThrow(r1, "poison_label");     // Catch: Throwable -> L72
        int r48 = CursorUtil.getColumnIndexOrThrow(r1, "poison_label_version");     // Catch: Throwable -> L72
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "content_hash");     // Catch: Throwable -> L72
        int r18 = r2;
        ArrayList r19 = new ArrayList(r1.getCount());     // Catch: Throwable -> L72
    L17:
        if (r1.moveToNext() == false) goto L70;
        long r20 = r1.getLong(r0);     // Catch: Throwable -> L72
        if (r1.isNull(r3) == false) goto L22;
        String r22 = null;
    L23:
        long r23 = r1.getLong(r5);     // Catch: Throwable -> L72
        long r25 = r1.getLong(r6);     // Catch: Throwable -> L72
        int r27 = r1.getInt(r7);     // Catch: Throwable -> L72
        long r28 = r1.getLong(r8);     // Catch: Throwable -> L72
        if (r1.isNull(r9) == false) goto L26;
        String r30 = null;
    L27:
        int r31 = r1.getInt(r10);     // Catch: Throwable -> L72
        if (r1.isNull(r11) == false) goto L30;
        String r32 = null;
    L32:
        if (r1.isNull(r12) == false) goto L34;
        String r33 = null;
    L36:
        if (r1.isNull(r13) == false) goto L38;
        String r34 = null;
    L40:
        if (r1.isNull(r14) == false) goto L42;
        String r35 = null;
    L44:
        if (r1.isNull(r15) == false) goto L46;
        String r36 = null;
    L47:
        int r37 = r1.getInt(r18);     // Catch: Throwable -> L72
        int r110 = r0;
        r45 = r45;
        if (r1.isNull(r45) == false) goto L51;
        String r38 = null;
    L50:
        r46 = r46;
        if (r1.isNull(r46) == false) goto L55;
        String r39 = null;
    L56:
        ft r21 = new ft(r20, r22, r23, r25, r27, r28, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39);     // Catch: Throwable -> L72
        int r111 = r18;
        r47 = r47;
        if (r1.isNull(r47) == false) goto L59;
        Integer r24 = null;
    L60:
        r21.setPoisonLabel(r24);     // Catch: Throwable -> L72
        r48 = r48;
        if (r1.isNull(r48) == false) goto L63;
        Integer r26 = null;
    L64:
        r21.setPoisonLabelVersion(r26);     // Catch: Throwable -> L72
        int r29 = r17;
        if (r1.isNull(r29) == false) goto L67;
        String r40 = null;
    L68:
        r21.setContentHash(r40);     // Catch: Throwable -> L72
        r19.add(r21);     // Catch: Throwable -> L72
        r0 = r110;
        r18 = r111;
        r17 = r29;
        goto L17
    L67:
        r40 = r1.getString(r29);     // Catch: Throwable -> L72
        goto L68
    L63:
        r26 = Integer.valueOf(r1.getInt(r48));     // Catch: Throwable -> L72
        goto L64
    L59:
        r24 = Integer.valueOf(r1.getInt(r47));     // Catch: Throwable -> L72
        goto L60
    L55:
        r39 = r1.getString(r46);     // Catch: Throwable -> L72
        goto L56
    L51:
        r38 = r1.getString(r45);     // Catch: Throwable -> L72
        goto L50
    L46:
        r36 = r1.getString(r15);     // Catch: Throwable -> L72
        goto L47
    L42:
        r35 = r1.getString(r14);     // Catch: Throwable -> L72
        goto L44
    L38:
        r34 = r1.getString(r13);     // Catch: Throwable -> L72
        goto L40
    L34:
        r33 = r1.getString(r12);     // Catch: Throwable -> L72
        goto L36
    L30:
        r32 = r1.getString(r11);     // Catch: Throwable -> L72
        goto L32
    L26:
        r30 = r1.getString(r9);     // Catch: Throwable -> L72
        goto L27
    L22:
        r22 = r1.getString(r3);     // Catch: Throwable -> L72
        goto L23
    L70:
        r1.close();
        r16.release();
        return r19;
    L72:
        th = th;
    L76:
        r1.close();
        r16.release();
        throw th;
    L74:
        th = th;
        r16 = r4;
        goto L76
    L12:
        r4.bindString(4, r44);
        goto L13
    L9:
        r4.bindString(3, r43);
        goto L10
    L5:
        r4.bindString(2, r42);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ft queryOne() {
        return CommonPhotoRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ft> queryRecentByPackageName(String r1, long r2) {
        return CommonPhotoRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ft> queryWithLimitAndOffset(int r1, int r2) {
        return CommonPhotoRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ft> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawCommonPhotoEntity(r6));     // Catch: Throwable -> L10
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

    public int update(ft r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawCommonPhotoEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((ft) ZeusTransformUtils.preCheckCast(r3, ft.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ft> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawCommonPhotoEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return CommonPhotoRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
