package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.hb;
import com.obric.memorydata.database.entity.he;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class PhotoHistoryEntityDao_Impl implements PhotoHistoryEntityDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<he> __deletionAdapterOfRawPhotoHistoryEntity;
    private final EntityInsertionAdapter<he> __insertionAdapterOfRawPhotoHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<he> __updateAdapterOfRawPhotoHistoryEntity;

    public PhotoHistoryEntityDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawPhotoHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawPhotoHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawPhotoHistoryEntity = new AnonymousClass3(this, r2);
    }

    private he __entityCursorConverter_comObricMemorydataDatabaseEntityRawPhotoHistoryEntity(Cursor r67) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r67, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "photo_id");
        int r3 = CursorUtil.getColumnIndex(r0, "photo_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "photo_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "photo_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "photo_type");
        int r7 = CursorUtil.getColumnIndex(r0, "photo_timestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "photo_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "photo_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "photo_uuid");
        int r11 = CursorUtil.getColumnIndex(r0, "photo_name");
        int r12 = CursorUtil.getColumnIndex(r0, "photo_file");
        int r13 = CursorUtil.getColumnIndex(r0, "photo_assetType");
        int r14 = CursorUtil.getColumnIndex(r0, "photo_inAlbum");
        int r15 = CursorUtil.getColumnIndex(r0, "photo_resolution");
        int r16 = CursorUtil.getColumnIndex(r0, "photo_fileSize");
        int r17 = CursorUtil.getColumnIndex(r0, "photo_isFavorite");
        int r18 = CursorUtil.getColumnIndex(r0, "photo_tags");
        int r19 = CursorUtil.getColumnIndex(r0, "photo_faces");
        int r110 = CursorUtil.getColumnIndex(r0, "photo_location");
        int r111 = CursorUtil.getColumnIndex(r0, "photo_caption");
        int r112 = CursorUtil.getColumnIndex(r0, "photo_contentWithTime");
        int r113 = CursorUtil.getColumnIndex(r0, "photo_ocr");
        int r114 = CursorUtil.getColumnIndex(r0, "photo_sourceAppName");
        int r115 = CursorUtil.getColumnIndex(r0, "photo_sourcePackageName");
        int r116 = CursorUtil.getColumnIndex(r0, "photo_sourceDevice");
        int r117 = CursorUtil.getColumnIndex(r0, "photo_poison_label");
        int r118 = CursorUtil.getColumnIndex(r0, "photo_poison_label_version");
        int r119 = CursorUtil.getColumnIndex(r0, "photo_content_hash");
        long r28 = 0;
        if (r1 != (-1)) goto L5;
        long r33 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r36 = 0;
    L9:
        String r20 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r38 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r39 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r41 = 0;
    L22:
        boolean r21 = false;
        if (r6 != (-1)) goto L25;
        int r43 = 0;
    L26:
        if (r7 != (-1)) goto L28;
        long r44 = 0;
    L29:
        if (r8 != (-1)) goto L32;
    L30:
        String r46 = null;
    L35:
        if (r9 != (-1)) goto L37;
        int r47 = 0;
    L38:
        if (r10 != (-1)) goto L41;
    L39:
        String r48 = null;
    L44:
        if (r11 != (-1)) goto L47;
    L45:
        String r49 = null;
    L50:
        if (r12 != (-1)) goto L53;
    L51:
        String r50 = null;
    L56:
        if (r13 != (-1)) goto L59;
    L57:
        String r51 = null;
    L62:
        if (r14 != (-1)) goto L65;
    L63:
        String r52 = null;
    L68:
        if (r66 != (-1)) goto L71;
    L69:
        String r53 = null;
    L74:
        if (r67 == (-1)) goto L77;
        r28 = r0.getLong(r16);
    L77:
        long r54 = r28;
        if (r17 != (-1)) goto L81;
    L79:
        boolean r56 = r21;
        if (r18 != (-1)) goto L87;
    L84:
        String r57 = null;
    L90:
        if (r19 != (-1)) goto L94;
    L91:
        String r58 = null;
    L97:
        if (r110 != (-1)) goto L101;
    L98:
        String r59 = null;
    L104:
        if (r111 != (-1)) goto L108;
    L105:
        String r60 = null;
    L111:
        if (r112 != (-1)) goto L115;
    L112:
        String r61 = null;
    L118:
        if (r113 != (-1)) goto L122;
    L119:
        String r62 = null;
    L125:
        if (r114 != (-1)) goto L129;
    L126:
        String r63 = null;
    L132:
        if (r115 != (-1)) goto L136;
    L133:
        String r64 = null;
    L139:
        if (r116 != (-1)) goto L142;
    L140:
        String r65 = null;
    L145:
        hb r22 = new hb(r36, r38, r39, r41, r43, r44, r46, r47, r48, r49, r50, r51, r52, r53, r54, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65);
        if (r117 == (-1)) goto L153;
        if (r0.isNull(r117) == false) goto L150;
        Integer r23 = null;
    L151:
        r22.setPoisonLabel(r23);
        goto L153
    L150:
        r23 = Integer.valueOf(r0.getInt(r117));
    L153:
        if (r118 == (-1)) goto L160;
        if (r0.isNull(r118) == false) goto L157;
        Integer r24 = null;
    L158:
        r22.setPoisonLabelVersion(r24);
        goto L160
    L157:
        r24 = Integer.valueOf(r0.getInt(r118));
    L160:
        if (r119 == (-1)) goto L167;
        if (r0.isNull(r119) == true) goto L165;
        r20 = r0.getString(r119);
    L165:
        r22.setContentHash(r20);
    L167:
        return new he(r33, r22);
    L142:
        if (r0.isNull(r116) == true) goto L140;
        r65 = r0.getString(r116);
        goto L145
    L136:
        if (r0.isNull(r115) == true) goto L133;
        r64 = r0.getString(r115);
        goto L139
    L129:
        if (r0.isNull(r114) == true) goto L126;
        r63 = r0.getString(r114);
        goto L132
    L122:
        if (r0.isNull(r113) == true) goto L119;
        r62 = r0.getString(r113);
        goto L125
    L115:
        if (r0.isNull(r112) == true) goto L112;
        r61 = r0.getString(r112);
        goto L118
    L108:
        if (r0.isNull(r111) == true) goto L105;
        r60 = r0.getString(r111);
        goto L111
    L101:
        if (r0.isNull(r110) == true) goto L98;
        r59 = r0.getString(r110);
        goto L104
    L94:
        if (r0.isNull(r19) == true) goto L91;
        r58 = r0.getString(r19);
        goto L97
    L87:
        if (r0.isNull(r18) == true) goto L84;
        r57 = r0.getString(r18);
        goto L90
    L81:
        if (r0.getInt(r17) == 0) goto L79;
        r21 = true;
        goto L79
    L71:
        if (r0.isNull(r66) == true) goto L69;
        r53 = r0.getString(r15);
        goto L74
    L65:
        if (r0.isNull(r14) == true) goto L63;
        r52 = r0.getString(r14);
        goto L68
    L59:
        if (r0.isNull(r13) == true) goto L57;
        r51 = r0.getString(r13);
        goto L62
    L53:
        if (r0.isNull(r12) == true) goto L51;
        r50 = r0.getString(r12);
        goto L56
    L47:
        if (r0.isNull(r11) == true) goto L45;
        r49 = r0.getString(r11);
        goto L50
    L41:
        if (r0.isNull(r10) == true) goto L39;
        r48 = r0.getString(r10);
        goto L44
    L37:
        r47 = r0.getInt(r9);
        goto L38
    L32:
        if (r0.isNull(r8) == true) goto L30;
        r46 = r0.getString(r8);
        goto L35
    L28:
        r44 = r0.getLong(r7);
        goto L29
    L25:
        r43 = r0.getInt(r6);
        goto L26
    L21:
        r41 = r0.getLong(r5);
        goto L22
    L18:
        r39 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r38 = r0.getString(r3);
        goto L16
    L8:
        r36 = r0.getLong(r2);
        goto L9
    L5:
        r33 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<he> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawPhotoHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<he> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawPhotoHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(he r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawPhotoHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((he) ZeusTransformUtils.preCheckCast(r3, he.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return PhotoHistoryEntityDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return PhotoHistoryEntityDao.DefaultImpls.deleteByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return PhotoHistoryEntityDao.DefaultImpls.deleteByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return PhotoHistoryEntityDao.DefaultImpls.deleteByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return PhotoHistoryEntityDao.DefaultImpls.deleteById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.PhotoHistoryEntityDao, com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return PhotoHistoryEntityDao.DefaultImpls.getPrefix(this);
    }

    @Override // com.obric.memorydata.database.dao.PhotoHistoryEntityDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return PhotoHistoryEntityDao.DefaultImpls.getTableName(this);
    }

    public long insert(he r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawPhotoHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((he) ZeusTransformUtils.preCheckCast(r3, he.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<he> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawPhotoHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<he> queryAll() {
        return PhotoHistoryEntityDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return PhotoHistoryEntityDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<he> queryByEntityId(String r1, String r2) {
        return PhotoHistoryEntityDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<he> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return PhotoHistoryEntityDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public he queryById(long r1) {
        return PhotoHistoryEntityDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<he> queryByIds(List<Long> r3) {
        return PhotoHistoryEntityDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public he queryByUUID(String r1) {
        return PhotoHistoryEntityDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public he queryOne() {
        return PhotoHistoryEntityDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<he> queryWithLimitAndOffset(int r1, int r2) {
        return PhotoHistoryEntityDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<he> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawPhotoHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(he r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawPhotoHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((he) ZeusTransformUtils.preCheckCast(r3, he.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<he> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawPhotoHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
