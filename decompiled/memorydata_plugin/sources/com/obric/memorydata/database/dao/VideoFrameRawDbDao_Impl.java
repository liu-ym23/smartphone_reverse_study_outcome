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
import com.obric.memorydata.database.entity.hr;
import com.obric.memorydata.database.entity.j;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class VideoFrameRawDbDao_Impl implements VideoFrameRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<hr> __deletionAdapterOfRawVideoFrameEntity;
    private final EntityInsertionAdapter<hr> __insertionAdapterOfRawVideoFrameEntity;
    private final EntityDeletionOrUpdateAdapter<hr> __updateAdapterOfRawVideoFrameEntity;

    public VideoFrameRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawVideoFrameEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawVideoFrameEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawVideoFrameEntity = new AnonymousClass3(this, r2);
    }

    private hr __entityCursorConverter_comObricMemorydataDatabaseEntityRawVideoFrameEntity(Cursor r50) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r50, Cursor.class, "com.obric.memorydata.plugin");
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
        int r12 = CursorUtil.getColumnIndex(r0, "tags");
        int r13 = CursorUtil.getColumnIndex(r0, "faces");
        int r14 = CursorUtil.getColumnIndex(r0, "caption");
        int r15 = CursorUtil.getColumnIndex(r0, "ocr");
        int r16 = CursorUtil.getColumnIndex(r0, "photoEntityDbId");
        int r17 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r18 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r19 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r110 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r111 = 0;
        if (r1 != (-1)) goto L5;
        long r25 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r27 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r28 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r30 = 0;
    L19:
        int r21 = 0;
        if (r5 != (-1)) goto L22;
        int r32 = 0;
    L23:
        if (r6 != (-1)) goto L25;
        long r33 = 0;
    L26:
        if (r7 != (-1)) goto L29;
    L27:
        String r35 = null;
    L32:
        if (r8 == (-1)) goto L35;
        r21 = r0.getInt(r8);
    L35:
        int r36 = r21;
        if (r9 != (-1)) goto L38;
        long r37 = 0;
    L39:
        if (r10 != (-1)) goto L41;
        long r39 = 0;
    L42:
        if (r11 != (-1)) goto L44;
        long r41 = 0;
    L45:
        if (r12 != (-1)) goto L48;
    L46:
        String r43 = null;
    L51:
        if (r13 != (-1)) goto L54;
    L52:
        String r44 = null;
    L57:
        if (r14 != (-1)) goto L60;
    L58:
        String r45 = null;
    L63:
        if (r49 != (-1)) goto L66;
    L64:
        String r46 = null;
    L69:
        if (r50 == (-1)) goto L72;
        r111 = r0.getLong(r16);
    L72:
        hr r22 = new hr(r25, r27, r28, r30, r32, r33, r35, r36, r37, r39, r41, r43, r44, r45, r46, r111);
        if (r17 == (-1)) goto L80;
        if (r0.isNull(r17) == false) goto L77;
        String r23 = null;
    L78:
        r22.setUuid(r23);
        goto L80
    L77:
        r23 = r0.getString(r17);
    L80:
        if (r18 == (-1)) goto L87;
        if (r0.isNull(r18) == false) goto L84;
        Integer r24 = null;
    L85:
        r22.setPoisonLabel(r24);
        goto L87
    L84:
        r24 = Integer.valueOf(r0.getInt(r18));
    L87:
        if (r19 == (-1)) goto L94;
        if (r0.isNull(r19) == false) goto L91;
        Integer r26 = null;
    L92:
        r22.setPoisonLabelVersion(r26);
        goto L94
    L91:
        r26 = Integer.valueOf(r0.getInt(r19));
    L94:
        if (r110 != (-1)) goto L96;
    L100:
        return r22;
    L96:
        if (r0.isNull(r110) == true) goto L99;
        r20 = r0.getString(r110);
    L99:
        r22.setContentHash(r20);
        goto L100
    L66:
        if (r0.isNull(r49) == true) goto L64;
        r46 = r0.getString(r15);
        goto L69
    L60:
        if (r0.isNull(r14) == true) goto L58;
        r45 = r0.getString(r14);
        goto L63
    L54:
        if (r0.isNull(r13) == true) goto L52;
        r44 = r0.getString(r13);
        goto L57
    L48:
        if (r0.isNull(r12) == true) goto L46;
        r43 = r0.getString(r12);
        goto L51
    L44:
        r41 = r0.getLong(r11);
        goto L45
    L41:
        r39 = r0.getLong(r10);
        goto L42
    L38:
        r37 = r0.getLong(r9);
        goto L39
    L29:
        if (r0.isNull(r7) == true) goto L27;
        r35 = r0.getString(r7);
        goto L32
    L25:
        r33 = r0.getLong(r6);
        goto L26
    L22:
        r32 = r0.getInt(r5);
        goto L23
    L18:
        r30 = r0.getLong(r4);
        goto L19
    L15:
        r28 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r27 = r0.getString(r2);
        goto L13
    L5:
        r25 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return VideoFrameRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<hr> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawVideoFrameEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<hr> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawVideoFrameEntity.insert(r4);     // Catch: Throwable -> L6
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

    public int delete(hr r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawVideoFrameEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((hr) ZeusTransformUtils.preCheckCast(r3, hr.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return VideoFrameRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return VideoFrameRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
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
        return VideoFrameRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return VideoFrameRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return VideoFrameRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
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
        return VideoFrameRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return VideoFrameRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
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
        return VideoFrameRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.VideoFrameRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return VideoFrameRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(hr r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawVideoFrameEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((hr) ZeusTransformUtils.preCheckCast(r3, hr.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<hr> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawVideoFrameEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.VideoFrameRawDbDao, com.obric.memorydata.database.dao.AbstractVideoFrameRawDbDao
    public List<j> queryAbstractVideoFrameEntity(long r1) {
        return VideoFrameRawDbDao.DefaultImpls.queryAbstractVideoFrameEntity(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hr> queryAll() {
        return VideoFrameRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return VideoFrameRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hr> queryByEntityId(String r1, String r2) {
        return VideoFrameRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hr> queryByEntityIdList(List<String> r3) {
        return VideoFrameRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hr> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return VideoFrameRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hr queryById(long r1) {
        return VideoFrameRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hr> queryByIdAndTimestamp(long r1, long r3) {
        return VideoFrameRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hr> queryByIds(List<Long> r3) {
        return VideoFrameRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return VideoFrameRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hr> queryByPackageName(String r1) {
        return VideoFrameRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hr> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return VideoFrameRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hr> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return VideoFrameRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.VideoFrameRawDbDao
    public List<hr> queryByPhotoEntityDbId(long r49) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawVideoFrameEntity WHERE photoEntityDbId = ?", 1);
        r1.bindLong(1, r49);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L56
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "entityId");     // Catch: Throwable -> L56
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "createTime");     // Catch: Throwable -> L56
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "modifyTime");     // Catch: Throwable -> L56
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L56
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L56
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L56
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "hashCodeValue");     // Catch: Throwable -> L56
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "startTime");     // Catch: Throwable -> L56
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "endTime");     // Catch: Throwable -> L56
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "frameTime");     // Catch: Throwable -> L56
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "tags");     // Catch: Throwable -> L56
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "faces");     // Catch: Throwable -> L56
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "caption");     // Catch: Throwable -> L56
        RoomSQLiteQuery r16 = r1;
        int r410 = CursorUtil.getColumnIndexOrThrow(r2, "ocr");     // Catch: Throwable -> L54
        int r50 = CursorUtil.getColumnIndexOrThrow(r2, "photoEntityDbId");     // Catch: Throwable -> L54
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, Api.KEY_UUID);     // Catch: Throwable -> L54
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "poison_label");     // Catch: Throwable -> L54
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "poison_label_version");     // Catch: Throwable -> L54
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "content_hash");     // Catch: Throwable -> L54
        int r21 = r3;
        ArrayList r22 = new ArrayList(r2.getCount());     // Catch: Throwable -> L54
    L6:
        if (r2.moveToNext() == false) goto L52;
        long r23 = r2.getLong(r0);     // Catch: Throwable -> L54
        if (r2.isNull(r4) == false) goto L11;
        String r25 = null;
    L12:
        long r26 = r2.getLong(r5);     // Catch: Throwable -> L54
        long r28 = r2.getLong(r6);     // Catch: Throwable -> L54
        int r30 = r2.getInt(r7);     // Catch: Throwable -> L54
        long r31 = r2.getLong(r8);     // Catch: Throwable -> L54
        if (r2.isNull(r9) == false) goto L15;
        String r33 = null;
    L16:
        int r34 = r2.getInt(r10);     // Catch: Throwable -> L54
        long r35 = r2.getLong(r11);     // Catch: Throwable -> L54
        long r37 = r2.getLong(r12);     // Catch: Throwable -> L54
        long r39 = r2.getLong(r13);     // Catch: Throwable -> L54
        if (r2.isNull(r14) == false) goto L19;
        String r41 = null;
    L21:
        if (r2.isNull(r15) == false) goto L23;
        String r42 = null;
    L25:
        if (r2.isNull(r21) == false) goto L28;
        String r43 = null;
    L27:
        int r47 = r0;
        int r24 = r410;
        if (r2.isNull(r24) == false) goto L33;
        String r44 = null;
    L32:
        int r27 = r50;
        r50 = r27;
        hr r29 = new hr(r23, r25, r26, r28, r30, r31, r33, r34, r35, r37, r39, r41, r42, r43, r44, r2.getLong(r27));     // Catch: Throwable -> L54
        int r210 = r21;
        int r32 = r17;
        if (r2.isNull(r32) == false) goto L37;
        String r36 = null;
    L38:
        r29.setUuid(r36);     // Catch: Throwable -> L54
        r18 = r18;
        if (r2.isNull(r18) == false) goto L41;
        Integer r38 = null;
    L42:
        r29.setPoisonLabel(r38);     // Catch: Throwable -> L54
        r19 = r19;
        if (r2.isNull(r19) == false) goto L45;
        Integer r40 = null;
    L46:
        r29.setPoisonLabelVersion(r40);     // Catch: Throwable -> L54
        r20 = r20;
        if (r2.isNull(r20) == false) goto L49;
        String r45 = null;
    L50:
        r29.setContentHash(r45);     // Catch: Throwable -> L54
        r22.add(r29);     // Catch: Throwable -> L54
        r0 = r47;
        r410 = r24;
        r21 = r210;
        r17 = r32;
        goto L6
    L49:
        r45 = r2.getString(r20);     // Catch: Throwable -> L54
        goto L50
    L45:
        r40 = Integer.valueOf(r2.getInt(r19));     // Catch: Throwable -> L54
        goto L46
    L41:
        r38 = Integer.valueOf(r2.getInt(r18));     // Catch: Throwable -> L54
        goto L42
    L37:
        r36 = r2.getString(r32);     // Catch: Throwable -> L54
        goto L38
    L33:
        r44 = r2.getString(r24);     // Catch: Throwable -> L54
        goto L32
    L28:
        r43 = r2.getString(r21);     // Catch: Throwable -> L54
        goto L27
    L23:
        r42 = r2.getString(r15);     // Catch: Throwable -> L54
        goto L25
    L19:
        r41 = r2.getString(r14);     // Catch: Throwable -> L54
        goto L21
    L15:
        r33 = r2.getString(r9);     // Catch: Throwable -> L54
        goto L16
    L11:
        r25 = r2.getString(r4);     // Catch: Throwable -> L54
        goto L12
    L52:
        r2.close();
        r16.release();
        return r22;
    L54:
        th = th;
    L58:
        r2.close();
        r16.release();
        throw th;
    L56:
        th = th;
        r16 = r1;
        goto L58
    }

    @Override // com.obric.memorydata.database.dao.VideoFrameRawDbDao
    public List<hr> queryByPhotoEntityDbId(long r47, long r49) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawVideoFrameEntity WHERE photoEntityDbId = ? AND timestamp != ?", 2);
        r1.bindLong(1, r47);
        r1.bindLong(2, r49);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L56
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "entityId");     // Catch: Throwable -> L56
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "createTime");     // Catch: Throwable -> L56
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "modifyTime");     // Catch: Throwable -> L56
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L56
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L56
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L56
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "hashCodeValue");     // Catch: Throwable -> L56
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "startTime");     // Catch: Throwable -> L56
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "endTime");     // Catch: Throwable -> L56
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "frameTime");     // Catch: Throwable -> L56
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "tags");     // Catch: Throwable -> L56
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "faces");     // Catch: Throwable -> L56
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "caption");     // Catch: Throwable -> L56
        RoomSQLiteQuery r16 = r1;
        int r48 = CursorUtil.getColumnIndexOrThrow(r2, "ocr");     // Catch: Throwable -> L54
        int r410 = CursorUtil.getColumnIndexOrThrow(r2, "photoEntityDbId");     // Catch: Throwable -> L54
        int r411 = CursorUtil.getColumnIndexOrThrow(r2, Api.KEY_UUID);     // Catch: Throwable -> L54
        int r50 = CursorUtil.getColumnIndexOrThrow(r2, "poison_label");     // Catch: Throwable -> L54
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "poison_label_version");     // Catch: Throwable -> L54
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "content_hash");     // Catch: Throwable -> L54
        int r19 = r3;
        ArrayList r20 = new ArrayList(r2.getCount());     // Catch: Throwable -> L54
    L6:
        if (r2.moveToNext() == false) goto L52;
        long r21 = r2.getLong(r0);     // Catch: Throwable -> L54
        if (r2.isNull(r4) == false) goto L11;
        String r23 = null;
    L12:
        long r24 = r2.getLong(r5);     // Catch: Throwable -> L54
        long r26 = r2.getLong(r6);     // Catch: Throwable -> L54
        int r28 = r2.getInt(r7);     // Catch: Throwable -> L54
        long r29 = r2.getLong(r8);     // Catch: Throwable -> L54
        if (r2.isNull(r9) == false) goto L15;
        String r31 = null;
    L16:
        int r32 = r2.getInt(r10);     // Catch: Throwable -> L54
        long r33 = r2.getLong(r11);     // Catch: Throwable -> L54
        long r35 = r2.getLong(r12);     // Catch: Throwable -> L54
        long r37 = r2.getLong(r13);     // Catch: Throwable -> L54
        if (r2.isNull(r14) == false) goto L19;
        String r39 = null;
    L21:
        if (r2.isNull(r15) == false) goto L23;
        String r40 = null;
    L25:
        if (r2.isNull(r19) == false) goto L28;
        String r41 = null;
    L27:
        int r45 = r0;
        int r22 = r48;
        if (r2.isNull(r22) == false) goto L33;
        String r42 = null;
    L32:
        int r25 = r410;
        r410 = r25;
        hr r27 = new hr(r21, r23, r24, r26, r28, r29, r31, r32, r33, r35, r37, r39, r40, r41, r42, r2.getLong(r25));     // Catch: Throwable -> L54
        int r210 = r19;
        r411 = r411;
        if (r2.isNull(r411) == false) goto L37;
        String r30 = null;
    L38:
        r27.setUuid(r30);     // Catch: Throwable -> L54
        r50 = r50;
        if (r2.isNull(r50) == false) goto L41;
        Integer r34 = null;
    L42:
        r27.setPoisonLabel(r34);     // Catch: Throwable -> L54
        int r36 = r17;
        if (r2.isNull(r36) == false) goto L45;
        Integer r38 = null;
    L46:
        r27.setPoisonLabelVersion(r38);     // Catch: Throwable -> L54
        r18 = r18;
        if (r2.isNull(r18) == false) goto L49;
        String r43 = null;
    L50:
        r27.setContentHash(r43);     // Catch: Throwable -> L54
        r20.add(r27);     // Catch: Throwable -> L54
        r0 = r45;
        r48 = r22;
        r19 = r210;
        r17 = r36;
        goto L6
    L49:
        r43 = r2.getString(r18);     // Catch: Throwable -> L54
        goto L50
    L45:
        r38 = Integer.valueOf(r2.getInt(r36));     // Catch: Throwable -> L54
        goto L46
    L41:
        r34 = Integer.valueOf(r2.getInt(r50));     // Catch: Throwable -> L54
        goto L42
    L37:
        r30 = r2.getString(r411);     // Catch: Throwable -> L54
        goto L38
    L33:
        r42 = r2.getString(r22);     // Catch: Throwable -> L54
        goto L32
    L28:
        r41 = r2.getString(r19);     // Catch: Throwable -> L54
        goto L27
    L23:
        r40 = r2.getString(r15);     // Catch: Throwable -> L54
        goto L25
    L19:
        r39 = r2.getString(r14);     // Catch: Throwable -> L54
        goto L21
    L15:
        r31 = r2.getString(r9);     // Catch: Throwable -> L54
        goto L16
    L11:
        r23 = r2.getString(r4);     // Catch: Throwable -> L54
        goto L12
    L52:
        r2.close();
        r16.release();
        return r20;
    L54:
        th = th;
    L58:
        r2.close();
        r16.release();
        throw th;
    L56:
        th = th;
        r16 = r1;
        goto L58
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hr queryByUUID(String r1) {
        return VideoFrameRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.VideoFrameRawDbDao
    public List<String> queryEntityIdsByPhotoEntityDbIdList(List<Long> r3, String r4) {
        return VideoFrameRawDbDao.DefaultImpls.queryEntityIdsByPhotoEntityDbIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hr queryOne() {
        return VideoFrameRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hr> queryRecentByPackageName(String r1, long r2) {
        return VideoFrameRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hr> queryWithLimitAndOffset(int r1, int r2) {
        return VideoFrameRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hr> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawVideoFrameEntity(r6));     // Catch: Throwable -> L10
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

    public int update(hr r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawVideoFrameEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((hr) ZeusTransformUtils.preCheckCast(r3, hr.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<hr> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawVideoFrameEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return VideoFrameRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
