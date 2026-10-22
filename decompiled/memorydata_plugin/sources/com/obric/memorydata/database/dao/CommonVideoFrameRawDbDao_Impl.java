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
import com.obric.memorydata.database.entity.fv;
import com.obric.memorydata.database.entity.j;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class CommonVideoFrameRawDbDao_Impl implements CommonVideoFrameRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<fv> __deletionAdapterOfRawCommonVideoFrameEntity;
    private final EntityInsertionAdapter<fv> __insertionAdapterOfRawCommonVideoFrameEntity;
    private final EntityDeletionOrUpdateAdapter<fv> __updateAdapterOfRawCommonVideoFrameEntity;

    public CommonVideoFrameRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawCommonVideoFrameEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawCommonVideoFrameEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawCommonVideoFrameEntity = new AnonymousClass3(this, r2);
    }

    private fv __entityCursorConverter_comObricMemorydataDatabaseEntityRawCommonVideoFrameEntity(Cursor r46) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r46, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, "startTime");
        int r10 = CursorUtil.getColumnIndex(r0, "endTime");
        int r11 = CursorUtil.getColumnIndex(r0, "frameTime");
        int r12 = CursorUtil.getColumnIndex(r0, "caption");
        int r13 = CursorUtil.getColumnIndex(r0, "ocr");
        int r14 = CursorUtil.getColumnIndex(r0, "photoEntityDbId");
        int r15 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r16 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r17 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r18 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r19 = 0;
        if (r1 != (-1)) goto L5;
        long r23 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r25 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r26 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r28 = 0;
    L19:
        int r21 = 0;
        if (r5 != (-1)) goto L22;
        int r30 = 0;
    L23:
        if (r6 != (-1)) goto L25;
        long r31 = 0;
    L26:
        if (r7 != (-1)) goto L29;
    L27:
        String r33 = null;
    L32:
        if (r8 == (-1)) goto L35;
        r21 = r0.getInt(r8);
    L35:
        int r34 = r21;
        if (r9 != (-1)) goto L38;
        long r35 = 0;
    L39:
        if (r10 != (-1)) goto L41;
        long r37 = 0;
    L42:
        if (r11 != (-1)) goto L44;
        long r39 = 0;
    L45:
        if (r12 != (-1)) goto L48;
    L46:
        String r41 = null;
    L51:
        if (r13 != (-1)) goto L54;
    L52:
        String r42 = null;
    L57:
        if (r14 == (-1)) goto L60;
        r19 = r0.getLong(r14);
    L60:
        fv r22 = new fv(r23, r25, r26, r28, r30, r31, r33, r34, r35, r37, r39, r41, r42, r19);
        if (r15 == (-1)) goto L68;
        if (r0.isNull(r15) == false) goto L65;
        String r24 = null;
    L66:
        r22.setUuid(r24);
        goto L68
    L65:
        r24 = r0.getString(r15);
    L68:
        if (r16 == (-1)) goto L75;
        if (r0.isNull(r16) == false) goto L72;
        Integer r27 = null;
    L73:
        r22.setPoisonLabel(r27);
        goto L75
    L72:
        r27 = Integer.valueOf(r0.getInt(r16));
    L75:
        if (r17 == (-1)) goto L82;
        if (r0.isNull(r17) == false) goto L79;
        Integer r29 = null;
    L80:
        r22.setPoisonLabelVersion(r29);
        goto L82
    L79:
        r29 = Integer.valueOf(r0.getInt(r17));
    L82:
        if (r18 != (-1)) goto L84;
    L88:
        return r22;
    L84:
        if (r0.isNull(r18) == true) goto L87;
        r20 = r0.getString(r18);
    L87:
        r22.setContentHash(r20);
        goto L88
    L54:
        if (r0.isNull(r13) == true) goto L52;
        r42 = r0.getString(r13);
        goto L57
    L48:
        if (r0.isNull(r12) == true) goto L46;
        r41 = r0.getString(r12);
        goto L51
    L44:
        r39 = r0.getLong(r11);
        goto L45
    L41:
        r37 = r0.getLong(r10);
        goto L42
    L38:
        r35 = r0.getLong(r9);
        goto L39
    L29:
        if (r0.isNull(r7) == true) goto L27;
        r33 = r0.getString(r7);
        goto L32
    L25:
        r31 = r0.getLong(r6);
        goto L26
    L22:
        r30 = r0.getInt(r5);
        goto L23
    L18:
        r28 = r0.getLong(r4);
        goto L19
    L15:
        r26 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r25 = r0.getString(r2);
        goto L13
    L5:
        r23 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return CommonVideoFrameRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<fv> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawCommonVideoFrameEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<fv> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawCommonVideoFrameEntity.insert(r4);     // Catch: Throwable -> L6
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

    public int delete(fv r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawCommonVideoFrameEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((fv) ZeusTransformUtils.preCheckCast(r3, fv.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return CommonVideoFrameRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return CommonVideoFrameRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
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
        return CommonVideoFrameRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return CommonVideoFrameRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return CommonVideoFrameRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
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
        return CommonVideoFrameRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return CommonVideoFrameRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
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
        return CommonVideoFrameRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.CommonVideoFrameRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return CommonVideoFrameRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(fv r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawCommonVideoFrameEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((fv) ZeusTransformUtils.preCheckCast(r3, fv.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<fv> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawCommonVideoFrameEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.CommonVideoFrameRawDbDao, com.obric.memorydata.database.dao.AbstractVideoFrameRawDbDao
    public List<j> queryAbstractVideoFrameEntity(long r1) {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryAbstractVideoFrameEntity(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fv> queryAll() {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fv> queryByEntityId(String r1, String r2) {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fv> queryByEntityIdList(List<String> r3) {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fv> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fv queryById(long r1) {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fv> queryByIdAndTimestamp(long r1, long r3) {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fv> queryByIds(List<Long> r3) {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fv> queryByPackageName(String r1) {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fv> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fv> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.CommonVideoFrameRawDbDao
    public List<fv> queryByPhotoEntityDbId(long r44) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawCommonVideoFrameEntity WHERE photoEntityDbId = ?", 1);
        r1.bindLong(1, r44);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L46
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "entityId");     // Catch: Throwable -> L46
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "createTime");     // Catch: Throwable -> L46
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "modifyTime");     // Catch: Throwable -> L46
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L46
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L46
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L46
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "hashCodeValue");     // Catch: Throwable -> L46
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "startTime");     // Catch: Throwable -> L46
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "endTime");     // Catch: Throwable -> L46
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "frameTime");     // Catch: Throwable -> L46
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "caption");     // Catch: Throwable -> L46
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "ocr");     // Catch: Throwable -> L46
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "photoEntityDbId");     // Catch: Throwable -> L46
        RoomSQLiteQuery r16 = r1;
        int r45 = CursorUtil.getColumnIndexOrThrow(r2, Api.KEY_UUID);     // Catch: Throwable -> L44
        int r46 = CursorUtil.getColumnIndexOrThrow(r2, "poison_label");     // Catch: Throwable -> L44
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "poison_label_version");     // Catch: Throwable -> L44
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "content_hash");     // Catch: Throwable -> L44
        int r19 = r3;
        ArrayList r20 = new ArrayList(r2.getCount());     // Catch: Throwable -> L44
    L6:
        if (r2.moveToNext() == false) goto L42;
        long r21 = r2.getLong(r0);     // Catch: Throwable -> L44
        if (r2.isNull(r4) == false) goto L11;
        String r23 = null;
    L12:
        long r24 = r2.getLong(r5);     // Catch: Throwable -> L44
        long r26 = r2.getLong(r6);     // Catch: Throwable -> L44
        int r28 = r2.getInt(r7);     // Catch: Throwable -> L44
        long r29 = r2.getLong(r8);     // Catch: Throwable -> L44
        if (r2.isNull(r9) == false) goto L15;
        String r31 = null;
    L16:
        int r32 = r2.getInt(r10);     // Catch: Throwable -> L44
        long r33 = r2.getLong(r11);     // Catch: Throwable -> L44
        long r35 = r2.getLong(r12);     // Catch: Throwable -> L44
        long r37 = r2.getLong(r13);     // Catch: Throwable -> L44
        if (r2.isNull(r14) == false) goto L19;
        String r39 = null;
    L21:
        if (r2.isNull(r15) == false) goto L23;
        String r40 = null;
    L24:
        long r41 = r2.getLong(r19);     // Catch: Throwable -> L44
        int r110 = r0;
        fv r22 = new fv(r21, r23, r24, r26, r28, r29, r31, r32, r33, r35, r37, r39, r40, r41);     // Catch: Throwable -> L44
        int r25 = r19;
        r45 = r45;
        if (r2.isNull(r45) == false) goto L27;
        String r27 = null;
    L28:
        r22.setUuid(r27);     // Catch: Throwable -> L44
        r46 = r46;
        if (r2.isNull(r46) == false) goto L31;
        Integer r30 = null;
    L32:
        r22.setPoisonLabel(r30);     // Catch: Throwable -> L44
        int r34 = r17;
        if (r2.isNull(r34) == false) goto L35;
        Integer r36 = null;
    L36:
        r22.setPoisonLabelVersion(r36);     // Catch: Throwable -> L44
        r18 = r18;
        if (r2.isNull(r18) == false) goto L39;
        String r38 = null;
    L40:
        r22.setContentHash(r38);     // Catch: Throwable -> L44
        r20.add(r22);     // Catch: Throwable -> L44
        r0 = r110;
        r19 = r25;
        r17 = r34;
        goto L6
    L39:
        r38 = r2.getString(r18);     // Catch: Throwable -> L44
        goto L40
    L35:
        r36 = Integer.valueOf(r2.getInt(r34));     // Catch: Throwable -> L44
        goto L36
    L31:
        r30 = Integer.valueOf(r2.getInt(r46));     // Catch: Throwable -> L44
        goto L32
    L27:
        r27 = r2.getString(r45);     // Catch: Throwable -> L44
        goto L28
    L23:
        r40 = r2.getString(r15);     // Catch: Throwable -> L44
        goto L24
    L19:
        r39 = r2.getString(r14);     // Catch: Throwable -> L44
        goto L21
    L15:
        r31 = r2.getString(r9);     // Catch: Throwable -> L44
        goto L16
    L11:
        r23 = r2.getString(r4);     // Catch: Throwable -> L44
        goto L12
    L42:
        r2.close();
        r16.release();
        return r20;
    L44:
        th = th;
    L48:
        r2.close();
        r16.release();
        throw th;
    L46:
        th = th;
        r16 = r1;
        goto L48
    }

    @Override // com.obric.memorydata.database.dao.CommonVideoFrameRawDbDao
    public List<fv> queryByPhotoEntityDbId(long r42, long r44) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawCommonVideoFrameEntity WHERE photoEntityDbId = ? AND timestamp != ?", 2);
        r1.bindLong(1, r42);
        r1.bindLong(2, r44);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L46
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "entityId");     // Catch: Throwable -> L46
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "createTime");     // Catch: Throwable -> L46
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "modifyTime");     // Catch: Throwable -> L46
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L46
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L46
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L46
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "hashCodeValue");     // Catch: Throwable -> L46
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "startTime");     // Catch: Throwable -> L46
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "endTime");     // Catch: Throwable -> L46
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "frameTime");     // Catch: Throwable -> L46
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "caption");     // Catch: Throwable -> L46
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "ocr");     // Catch: Throwable -> L46
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "photoEntityDbId");     // Catch: Throwable -> L46
        RoomSQLiteQuery r16 = r1;
        int r43 = CursorUtil.getColumnIndexOrThrow(r2, Api.KEY_UUID);     // Catch: Throwable -> L44
        int r45 = CursorUtil.getColumnIndexOrThrow(r2, "poison_label");     // Catch: Throwable -> L44
        int r46 = CursorUtil.getColumnIndexOrThrow(r2, "poison_label_version");     // Catch: Throwable -> L44
        int r47 = CursorUtil.getColumnIndexOrThrow(r2, "content_hash");     // Catch: Throwable -> L44
        int r17 = r3;
        ArrayList r18 = new ArrayList(r2.getCount());     // Catch: Throwable -> L44
    L6:
        if (r2.moveToNext() == false) goto L42;
        long r19 = r2.getLong(r0);     // Catch: Throwable -> L44
        if (r2.isNull(r4) == false) goto L11;
        String r21 = null;
    L12:
        long r22 = r2.getLong(r5);     // Catch: Throwable -> L44
        long r24 = r2.getLong(r6);     // Catch: Throwable -> L44
        int r26 = r2.getInt(r7);     // Catch: Throwable -> L44
        long r27 = r2.getLong(r8);     // Catch: Throwable -> L44
        if (r2.isNull(r9) == false) goto L15;
        String r29 = null;
    L16:
        int r30 = r2.getInt(r10);     // Catch: Throwable -> L44
        long r31 = r2.getLong(r11);     // Catch: Throwable -> L44
        long r33 = r2.getLong(r12);     // Catch: Throwable -> L44
        long r35 = r2.getLong(r13);     // Catch: Throwable -> L44
        if (r2.isNull(r14) == false) goto L19;
        String r37 = null;
    L21:
        if (r2.isNull(r15) == false) goto L23;
        String r38 = null;
    L24:
        long r39 = r2.getLong(r17);     // Catch: Throwable -> L44
        int r110 = r0;
        fv r20 = new fv(r19, r21, r22, r24, r26, r27, r29, r30, r31, r33, r35, r37, r38, r39);     // Catch: Throwable -> L44
        int r111 = r17;
        r43 = r43;
        if (r2.isNull(r43) == false) goto L27;
        String r23 = null;
    L28:
        r20.setUuid(r23);     // Catch: Throwable -> L44
        r45 = r45;
        if (r2.isNull(r45) == false) goto L31;
        Integer r25 = null;
    L32:
        r20.setPoisonLabel(r25);     // Catch: Throwable -> L44
        r46 = r46;
        if (r2.isNull(r46) == false) goto L35;
        Integer r28 = null;
    L36:
        r20.setPoisonLabelVersion(r28);     // Catch: Throwable -> L44
        r47 = r47;
        if (r2.isNull(r47) == false) goto L39;
        String r32 = null;
    L40:
        r20.setContentHash(r32);     // Catch: Throwable -> L44
        r18.add(r20);     // Catch: Throwable -> L44
        r0 = r110;
        r17 = r111;
        goto L6
    L39:
        r32 = r2.getString(r47);     // Catch: Throwable -> L44
        goto L40
    L35:
        r28 = Integer.valueOf(r2.getInt(r46));     // Catch: Throwable -> L44
        goto L36
    L31:
        r25 = Integer.valueOf(r2.getInt(r45));     // Catch: Throwable -> L44
        goto L32
    L27:
        r23 = r2.getString(r43);     // Catch: Throwable -> L44
        goto L28
    L23:
        r38 = r2.getString(r15);     // Catch: Throwable -> L44
        goto L24
    L19:
        r37 = r2.getString(r14);     // Catch: Throwable -> L44
        goto L21
    L15:
        r29 = r2.getString(r9);     // Catch: Throwable -> L44
        goto L16
    L11:
        r21 = r2.getString(r4);     // Catch: Throwable -> L44
        goto L12
    L42:
        r2.close();
        r16.release();
        return r18;
    L44:
        th = th;
    L48:
        r2.close();
        r16.release();
        throw th;
    L46:
        th = th;
        r16 = r1;
        goto L48
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fv queryByUUID(String r1) {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fv queryOne() {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fv> queryRecentByPackageName(String r1, long r2) {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fv> queryWithLimitAndOffset(int r1, int r2) {
        return CommonVideoFrameRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fv> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawCommonVideoFrameEntity(r6));     // Catch: Throwable -> L10
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

    public int update(fv r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawCommonVideoFrameEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((fv) ZeusTransformUtils.preCheckCast(r3, fv.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<fv> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawCommonVideoFrameEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return CommonVideoFrameRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
