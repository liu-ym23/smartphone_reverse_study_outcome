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
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class PhotoRawDbDao_Impl implements PhotoRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<hb> __deletionAdapterOfRawPhotoEntity;
    private final EntityInsertionAdapter<hb> __insertionAdapterOfRawPhotoEntity;
    private final EntityDeletionOrUpdateAdapter<hb> __updateAdapterOfRawPhotoEntity;

    public PhotoRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawPhotoEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawPhotoEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawPhotoEntity = new AnonymousClass3(this, r2);
    }

    private hb __entityCursorConverter_comObricMemorydataDatabaseEntityRawPhotoEntity(Cursor r64) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r64, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r10 = CursorUtil.getColumnIndex(r0, ActivityLifecycle.NAME);
        int r11 = CursorUtil.getColumnIndex(r0, "file");
        int r12 = CursorUtil.getColumnIndex(r0, "assetType");
        int r13 = CursorUtil.getColumnIndex(r0, "inAlbum");
        int r14 = CursorUtil.getColumnIndex(r0, "resolution");
        int r15 = CursorUtil.getColumnIndex(r0, "fileSize");
        int r16 = CursorUtil.getColumnIndex(r0, "isFavorite");
        int r17 = CursorUtil.getColumnIndex(r0, "tags");
        int r18 = CursorUtil.getColumnIndex(r0, "faces");
        int r19 = CursorUtil.getColumnIndex(r0, "location");
        int r110 = CursorUtil.getColumnIndex(r0, "caption");
        int r111 = CursorUtil.getColumnIndex(r0, "contentWithTime");
        int r112 = CursorUtil.getColumnIndex(r0, "ocr");
        int r113 = CursorUtil.getColumnIndex(r0, "sourceAppName");
        int r114 = CursorUtil.getColumnIndex(r0, "sourcePackageName");
        int r115 = CursorUtil.getColumnIndex(r0, "sourceDevice");
        int r116 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r117 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r118 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r27 = 0;
        if (r1 != (-1)) goto L5;
        long r33 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r35 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r36 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r38 = 0;
    L19:
        boolean r21 = false;
        if (r5 != (-1)) goto L22;
        int r40 = 0;
    L23:
        if (r6 != (-1)) goto L25;
        long r41 = 0;
    L26:
        if (r7 != (-1)) goto L29;
    L27:
        String r43 = null;
    L32:
        if (r8 != (-1)) goto L34;
        int r44 = 0;
    L35:
        if (r9 != (-1)) goto L38;
    L36:
        String r45 = null;
    L41:
        if (r10 != (-1)) goto L44;
    L42:
        String r46 = null;
    L47:
        if (r11 != (-1)) goto L50;
    L48:
        String r47 = null;
    L53:
        if (r12 != (-1)) goto L56;
    L54:
        String r48 = null;
    L59:
        if (r13 != (-1)) goto L62;
    L60:
        String r49 = null;
    L65:
        if (r14 != (-1)) goto L68;
    L66:
        String r50 = null;
    L71:
        if (r63 == (-1)) goto L74;
        r27 = r0.getLong(r15);
    L74:
        long r51 = r27;
        if (r16 != (-1)) goto L78;
    L76:
        boolean r53 = r21;
        if (r17 != (-1)) goto L84;
    L81:
        String r54 = null;
    L87:
        if (r18 != (-1)) goto L91;
    L88:
        String r55 = null;
    L94:
        if (r19 != (-1)) goto L98;
    L95:
        String r56 = null;
    L101:
        if (r110 != (-1)) goto L105;
    L102:
        String r57 = null;
    L108:
        if (r111 != (-1)) goto L112;
    L109:
        String r58 = null;
    L115:
        if (r112 != (-1)) goto L119;
    L116:
        String r59 = null;
    L122:
        if (r113 != (-1)) goto L126;
    L123:
        String r60 = null;
    L129:
        if (r114 != (-1)) goto L133;
    L130:
        String r61 = null;
    L136:
        if (r115 != (-1)) goto L139;
    L137:
        String r62 = null;
    L142:
        hb r22 = new hb(r33, r35, r36, r38, r40, r41, r43, r44, r45, r46, r47, r48, r49, r50, r51, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62);
        if (r116 == (-1)) goto L150;
        if (r0.isNull(r116) == false) goto L147;
        Integer r23 = null;
    L148:
        r22.setPoisonLabel(r23);
        goto L150
    L147:
        r23 = Integer.valueOf(r0.getInt(r116));
    L150:
        if (r117 == (-1)) goto L157;
        if (r0.isNull(r117) == false) goto L154;
        Integer r24 = null;
    L155:
        r22.setPoisonLabelVersion(r24);
        goto L157
    L154:
        r24 = Integer.valueOf(r0.getInt(r117));
    L157:
        if (r118 != (-1)) goto L159;
    L163:
        return r22;
    L159:
        if (r0.isNull(r118) == true) goto L162;
        r20 = r0.getString(r118);
    L162:
        r22.setContentHash(r20);
        goto L163
    L139:
        if (r0.isNull(r115) == true) goto L137;
        r62 = r0.getString(r115);
        goto L142
    L133:
        if (r0.isNull(r114) == true) goto L130;
        r61 = r0.getString(r114);
        goto L136
    L126:
        if (r0.isNull(r113) == true) goto L123;
        r60 = r0.getString(r113);
        goto L129
    L119:
        if (r0.isNull(r112) == true) goto L116;
        r59 = r0.getString(r112);
        goto L122
    L112:
        if (r0.isNull(r111) == true) goto L109;
        r58 = r0.getString(r111);
        goto L115
    L105:
        if (r0.isNull(r110) == true) goto L102;
        r57 = r0.getString(r110);
        goto L108
    L98:
        if (r0.isNull(r19) == true) goto L95;
        r56 = r0.getString(r19);
        goto L101
    L91:
        if (r0.isNull(r18) == true) goto L88;
        r55 = r0.getString(r18);
        goto L94
    L84:
        if (r0.isNull(r17) == true) goto L81;
        r54 = r0.getString(r17);
        goto L87
    L78:
        if (r0.getInt(r16) == 0) goto L76;
        r21 = true;
        goto L76
    L68:
        if (r0.isNull(r14) == true) goto L66;
        r50 = r0.getString(r14);
        goto L71
    L62:
        if (r0.isNull(r13) == true) goto L60;
        r49 = r0.getString(r13);
        goto L65
    L56:
        if (r0.isNull(r12) == true) goto L54;
        r48 = r0.getString(r12);
        goto L59
    L50:
        if (r0.isNull(r11) == true) goto L48;
        r47 = r0.getString(r11);
        goto L53
    L44:
        if (r0.isNull(r10) == true) goto L42;
        r46 = r0.getString(r10);
        goto L47
    L38:
        if (r0.isNull(r9) == true) goto L36;
        r45 = r0.getString(r9);
        goto L41
    L34:
        r44 = r0.getInt(r8);
        goto L35
    L29:
        if (r0.isNull(r7) == true) goto L27;
        r43 = r0.getString(r7);
        goto L32
    L25:
        r41 = r0.getLong(r6);
        goto L26
    L22:
        r40 = r0.getInt(r5);
        goto L23
    L18:
        r38 = r0.getLong(r4);
        goto L19
    L15:
        r36 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r35 = r0.getString(r2);
        goto L13
    L5:
        r33 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return PhotoRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<hb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawPhotoEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<hb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawPhotoEntity.insert(r4);     // Catch: Throwable -> L6
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

    public int delete(hb r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawPhotoEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((hb) ZeusTransformUtils.preCheckCast(r3, hb.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return PhotoRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return PhotoRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.PhotoRawDbDao
    public List<String> getAllImageNames() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT name FROM RawPhotoEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r5.getCount());     // Catch: Throwable -> L14
    L4:
        if (r5.moveToNext() == false) goto L12;
        if (r5.isNull(0) == false) goto L9;
        String r4 = null;
    L10:
        r3.add(r4);     // Catch: Throwable -> L14
        goto L4
    L9:
        r4 = r5.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r5.close();
        r0.release();
        return r3;
    L14:
        th = move-exception;
        r5.close();
        r0.release();
        throw th;
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

    @Override // com.obric.memorydata.database.dao.PhotoRawDbDao
    public int getCountByAlbumId(String r1) {
        return PhotoRawDbDao.DefaultImpls.getCountByAlbumId(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageName(String r1) {
        return PhotoRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return PhotoRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return PhotoRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
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
        return PhotoRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return PhotoRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
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
        return PhotoRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.PhotoRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return PhotoRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(hb r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawPhotoEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((hb) ZeusTransformUtils.preCheckCast(r3, hb.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<hb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawPhotoEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hb> queryAll() {
        return PhotoRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return PhotoRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hb> queryByEntityId(String r1, String r2) {
        return PhotoRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hb> queryByEntityIdList(List<String> r3) {
        return PhotoRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hb> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return PhotoRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hb queryById(long r1) {
        return PhotoRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hb> queryByIdAndTimestamp(long r1, long r3) {
        return PhotoRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hb> queryByIds(List<Long> r3) {
        return PhotoRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.PhotoRawDbDao
    public List<hb> queryByName(String r65) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM RawPhotoEntity WHERE name = ?", 1);
        if (r65 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L103
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L103
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L103
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L103
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L103
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L103
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L103
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L103
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L103
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, ActivityLifecycle.NAME);     // Catch: Throwable -> L103
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "file");     // Catch: Throwable -> L103
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "assetType");     // Catch: Throwable -> L103
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "inAlbum");     // Catch: Throwable -> L103
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "resolution");     // Catch: Throwable -> L103
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "fileSize");     // Catch: Throwable -> L101
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "isFavorite");     // Catch: Throwable -> L101
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "tags");     // Catch: Throwable -> L101
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "faces");     // Catch: Throwable -> L101
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "location");     // Catch: Throwable -> L101
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "caption");     // Catch: Throwable -> L101
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "contentWithTime");     // Catch: Throwable -> L101
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "ocr");     // Catch: Throwable -> L101
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "sourceAppName");     // Catch: Throwable -> L101
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "sourcePackageName");     // Catch: Throwable -> L101
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "sourceDevice");     // Catch: Throwable -> L101
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L101
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L101
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L101
        int r31 = r4;
        ArrayList r32 = new ArrayList(r5.getCount());     // Catch: Throwable -> L101
    L10:
        if (r5.moveToNext() == false) goto L99;
        long r33 = r5.getLong(r0);     // Catch: Throwable -> L101
        if (r5.isNull(r6) == false) goto L15;
        String r35 = null;
    L16:
        long r36 = r5.getLong(r7);     // Catch: Throwable -> L101
        long r38 = r5.getLong(r8);     // Catch: Throwable -> L101
        int r40 = r5.getInt(r9);     // Catch: Throwable -> L101
        long r41 = r5.getLong(r10);     // Catch: Throwable -> L101
        if (r5.isNull(r11) == false) goto L19;
        String r43 = null;
    L20:
        int r44 = r5.getInt(r12);     // Catch: Throwable -> L101
        if (r5.isNull(r13) == false) goto L23;
        String r45 = null;
    L25:
        if (r5.isNull(r14) == false) goto L27;
        String r46 = null;
    L29:
        if (r5.isNull(r15) == false) goto L31;
        String r47 = null;
    L33:
        if (r5.isNull(r1) == false) goto L35;
        String r48 = null;
    L37:
        if (r5.isNull(r3) == false) goto L39;
        String r49 = null;
    L41:
        if (r5.isNull(r31) == false) goto L44;
        String r50 = null;
    L43:
        int r63 = r17;
        int r110 = r0;
        long r51 = r5.getLong(r63);     // Catch: Throwable -> L101
        r18 = r18;
        if (r5.getInt(r18) == 0) goto L48;
        boolean r53 = true;
    L50:
        if (r5.isNull(r19) == false) goto L52;
        String r54 = null;
    L54:
        if (r5.isNull(r20) == false) goto L56;
        String r55 = null;
    L58:
        if (r5.isNull(r21) == false) goto L60;
        String r56 = null;
    L62:
        if (r5.isNull(r22) == false) goto L64;
        String r57 = null;
    L66:
        if (r5.isNull(r23) == false) goto L68;
        String r58 = null;
    L70:
        if (r5.isNull(r24) == false) goto L72;
        String r59 = null;
    L74:
        if (r5.isNull(r25) == false) goto L76;
        String r60 = null;
    L78:
        if (r5.isNull(r26) == false) goto L80;
        String r61 = null;
    L82:
        if (r5.isNull(r27) == false) goto L84;
        String r62 = null;
    L85:
        hb r34 = new hb(r33, r35, r36, r38, r40, r41, r43, r44, r45, r46, r47, r48, r49, r50, r51, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62);     // Catch: Throwable -> L101
        int r37 = r1;
        int r39 = r28;
        if (r5.isNull(r39) == false) goto L88;
        Integer r42 = null;
    L89:
        r34.setPoisonLabel(r42);     // Catch: Throwable -> L101
        r29 = r29;
        if (r5.isNull(r29) == false) goto L92;
        Integer r52 = null;
    L93:
        r34.setPoisonLabelVersion(r52);     // Catch: Throwable -> L101
        r30 = r30;
        if (r5.isNull(r30) == false) goto L96;
        String r64 = null;
    L97:
        r34.setContentHash(r64);     // Catch: Throwable -> L101
        r32.add(r34);     // Catch: Throwable -> L101
        r0 = r110;
        r17 = r63;
        r1 = r37;
        r28 = r39;
        r31 = r31;
        goto L10
    L96:
        r64 = r5.getString(r30);     // Catch: Throwable -> L101
        goto L97
    L92:
        r52 = Integer.valueOf(r5.getInt(r29));     // Catch: Throwable -> L101
        goto L93
    L88:
        r42 = Integer.valueOf(r5.getInt(r39));     // Catch: Throwable -> L101
        goto L89
    L84:
        r62 = r5.getString(r27);     // Catch: Throwable -> L101
        goto L85
    L80:
        r61 = r5.getString(r26);     // Catch: Throwable -> L101
        goto L82
    L76:
        r60 = r5.getString(r25);     // Catch: Throwable -> L101
        goto L78
    L72:
        r59 = r5.getString(r24);     // Catch: Throwable -> L101
        goto L74
    L68:
        r58 = r5.getString(r23);     // Catch: Throwable -> L101
        goto L70
    L64:
        r57 = r5.getString(r22);     // Catch: Throwable -> L101
        goto L66
    L60:
        r56 = r5.getString(r21);     // Catch: Throwable -> L101
        goto L62
    L56:
        r55 = r5.getString(r20);     // Catch: Throwable -> L101
        goto L58
    L52:
        r54 = r5.getString(r19);     // Catch: Throwable -> L101
        goto L54
    L48:
        r53 = false;
        goto L50
    L44:
        r50 = r5.getString(r31);     // Catch: Throwable -> L101
        goto L43
    L39:
        r49 = r5.getString(r3);     // Catch: Throwable -> L101
        goto L41
    L35:
        r48 = r5.getString(r1);     // Catch: Throwable -> L101
        goto L37
    L31:
        r47 = r5.getString(r15);     // Catch: Throwable -> L101
        goto L33
    L27:
        r46 = r5.getString(r14);     // Catch: Throwable -> L101
        goto L29
    L23:
        r45 = r5.getString(r13);     // Catch: Throwable -> L101
        goto L25
    L19:
        r43 = r5.getString(r11);     // Catch: Throwable -> L101
        goto L20
    L15:
        r35 = r5.getString(r6);     // Catch: Throwable -> L101
        goto L16
    L99:
        r5.close();
        r16.release();
        return r32;
    L101:
        th = th;
    L105:
        r5.close();
        r16.release();
        throw th;
    L103:
        th = th;
        r16 = r2;
        goto L105
    L5:
        r2.bindString(1, r65);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return PhotoRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hb> queryByPackageName(String r1) {
        return PhotoRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hb> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return PhotoRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hb> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return PhotoRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hb queryByUUID(String r1) {
        return PhotoRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.PhotoRawDbDao
    public hb queryLatestByAlbumId(String r1) {
        return PhotoRawDbDao.DefaultImpls.queryLatestByAlbumId(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.PhotoRawDbDao
    public Cursor queryOldDataForContentTimeIndexPending() {
        return PhotoRawDbDao.DefaultImpls.queryOldDataForContentTimeIndexPending(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hb queryOne() {
        return PhotoRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hb> queryRecentByPackageName(String r1, long r2) {
        return PhotoRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hb> queryWithLimitAndOffset(int r1, int r2) {
        return PhotoRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hb> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawPhotoEntity(r6));     // Catch: Throwable -> L10
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

    public int update(hb r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawPhotoEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((hb) ZeusTransformUtils.preCheckCast(r3, hb.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<hb> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawPhotoEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return PhotoRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
