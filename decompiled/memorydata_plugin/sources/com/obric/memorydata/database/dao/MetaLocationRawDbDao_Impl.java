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
import com.obric.memorydata.database.entity.gq;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaLocationRawDbDao_Impl implements MetaLocationRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<gq> __deletionAdapterOfRawMetaLocationEntity;
    private final EntityInsertionAdapter<gq> __insertionAdapterOfRawMetaLocationEntity;
    private final EntityDeletionOrUpdateAdapter<gq> __updateAdapterOfRawMetaLocationEntity;

    public MetaLocationRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawMetaLocationEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawMetaLocationEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawMetaLocationEntity = new AnonymousClass3(this, r2);
    }

    private gq __entityCursorConverter_comObricMemorydataDatabaseEntityRawMetaLocationEntity(Cursor r56) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r56, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, "sourceType");
        int r10 = CursorUtil.getColumnIndex(r0, "country");
        int r11 = CursorUtil.getColumnIndex(r0, "stateOrProvince");
        int r12 = CursorUtil.getColumnIndex(r0, "administrativeArea");
        int r13 = CursorUtil.getColumnIndex(r0, "locality");
        int r14 = CursorUtil.getColumnIndex(r0, "subLocality");
        int r15 = CursorUtil.getColumnIndex(r0, "thoroughfare");
        int r16 = CursorUtil.getColumnIndex(r0, "subThoroughfare");
        int r17 = CursorUtil.getColumnIndex(r0, "namedLocation");
        int r18 = CursorUtil.getColumnIndex(r0, "fullAddress");
        int r19 = CursorUtil.getColumnIndex(r0, "longitude");
        int r110 = CursorUtil.getColumnIndex(r0, "latitude");
        int r111 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r112 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r113 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r114 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r23 = 0;
        if (r1 != (-1)) goto L5;
        long r29 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r31 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r32 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r34 = 0;
    L19:
        int r21 = 0;
        if (r5 != (-1)) goto L22;
        int r36 = 0;
    L23:
        if (r6 == (-1)) goto L26;
        r23 = r0.getLong(r6);
    L26:
        long r37 = r23;
        if (r7 != (-1)) goto L30;
    L28:
        String r39 = null;
    L33:
        if (r8 != (-1)) goto L35;
        int r40 = 0;
    L36:
        if (r9 == (-1)) goto L39;
        r21 = r0.getInt(r9);
    L39:
        int r41 = r21;
        if (r10 != (-1)) goto L43;
    L41:
        String r42 = null;
    L46:
        if (r11 != (-1)) goto L49;
    L47:
        String r43 = null;
    L52:
        if (r12 != (-1)) goto L55;
    L53:
        String r44 = null;
    L58:
        if (r13 != (-1)) goto L61;
    L59:
        String r45 = null;
    L64:
        if (r14 != (-1)) goto L67;
    L65:
        String r46 = null;
    L70:
        if (r55 != (-1)) goto L73;
    L71:
        String r47 = null;
    L76:
        if (r56 != (-1)) goto L80;
    L77:
        String r48 = null;
    L83:
        if (r17 != (-1)) goto L87;
    L84:
        String r49 = null;
    L90:
        if (r18 != (-1)) goto L93;
    L91:
        String r50 = null;
    L96:
        double r22 = 0.0d;
        if (r19 != (-1)) goto L99;
        double r51 = 0.0d;
    L101:
        if (r110 == (-1)) goto L104;
        r22 = r0.getDouble(r110);
    L104:
        gq r24 = new gq(r29, r31, r32, r34, r36, r37, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r22);
        if (r111 == (-1)) goto L112;
        if (r0.isNull(r111) == false) goto L109;
        String r25 = null;
    L110:
        r24.setUuid(r25);
        goto L112
    L109:
        r25 = r0.getString(r111);
    L112:
        if (r112 == (-1)) goto L119;
        if (r0.isNull(r112) == false) goto L116;
        Integer r26 = null;
    L117:
        r24.setPoisonLabel(r26);
        goto L119
    L116:
        r26 = Integer.valueOf(r0.getInt(r112));
    L119:
        if (r113 == (-1)) goto L126;
        if (r0.isNull(r113) == false) goto L123;
        Integer r27 = null;
    L124:
        r24.setPoisonLabelVersion(r27);
        goto L126
    L123:
        r27 = Integer.valueOf(r0.getInt(r113));
    L126:
        if (r114 != (-1)) goto L128;
    L132:
        return r24;
    L128:
        if (r0.isNull(r114) == true) goto L131;
        r20 = r0.getString(r114);
    L131:
        r24.setContentHash(r20);
        goto L132
    L99:
        r51 = r0.getDouble(r19);
        goto L101
    L93:
        if (r0.isNull(r18) == true) goto L91;
        r50 = r0.getString(r18);
        goto L96
    L87:
        if (r0.isNull(r17) == true) goto L84;
        r49 = r0.getString(r17);
        goto L90
    L80:
        if (r0.isNull(r56) == true) goto L77;
        r48 = r0.getString(r16);
        goto L83
    L73:
        if (r0.isNull(r55) == true) goto L71;
        r47 = r0.getString(r15);
        goto L76
    L67:
        if (r0.isNull(r14) == true) goto L65;
        r46 = r0.getString(r14);
        goto L70
    L61:
        if (r0.isNull(r13) == true) goto L59;
        r45 = r0.getString(r13);
        goto L64
    L55:
        if (r0.isNull(r12) == true) goto L53;
        r44 = r0.getString(r12);
        goto L58
    L49:
        if (r0.isNull(r11) == true) goto L47;
        r43 = r0.getString(r11);
        goto L52
    L43:
        if (r0.isNull(r10) == true) goto L41;
        r42 = r0.getString(r10);
        goto L46
    L35:
        r40 = r0.getInt(r8);
        goto L36
    L30:
        if (r0.isNull(r7) == true) goto L28;
        r39 = r0.getString(r7);
        goto L33
    L22:
        r36 = r0.getInt(r5);
        goto L23
    L18:
        r34 = r0.getLong(r4);
        goto L19
    L15:
        r32 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r31 = r0.getString(r2);
        goto L13
    L5:
        r29 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return MetaLocationRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<gq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawMetaLocationEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<gq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawMetaLocationEntity.insert(r4);     // Catch: Throwable -> L6
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

    public int delete(gq r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawMetaLocationEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((gq) ZeusTransformUtils.preCheckCast(r3, gq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return MetaLocationRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return MetaLocationRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
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
        return MetaLocationRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return MetaLocationRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return MetaLocationRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
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
        return MetaLocationRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return MetaLocationRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
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
        return MetaLocationRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.MetaLocationRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MetaLocationRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(gq r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawMetaLocationEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((gq) ZeusTransformUtils.preCheckCast(r3, gq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<gq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawMetaLocationEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gq> queryAll() {
        return MetaLocationRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MetaLocationRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.MetaLocationRawDbDao
    public List<gq> queryAllDistinct() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT DISTINCT * FROM RawMetaLocationEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L79
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "entityId");     // Catch: Throwable -> L79
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "createTime");     // Catch: Throwable -> L79
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "modifyTime");     // Catch: Throwable -> L79
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L79
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L79
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L79
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "hashCodeValue");     // Catch: Throwable -> L79
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "sourceType");     // Catch: Throwable -> L79
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "country");     // Catch: Throwable -> L79
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "stateOrProvince");     // Catch: Throwable -> L79
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "administrativeArea");     // Catch: Throwable -> L79
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "locality");     // Catch: Throwable -> L79
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "subLocality");     // Catch: Throwable -> L79
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "thoroughfare");     // Catch: Throwable -> L77
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "subThoroughfare");     // Catch: Throwable -> L77
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "namedLocation");     // Catch: Throwable -> L77
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "fullAddress");     // Catch: Throwable -> L77
        int r21 = CursorUtil.getColumnIndexOrThrow(r2, "longitude");     // Catch: Throwable -> L77
        int r22 = CursorUtil.getColumnIndexOrThrow(r2, "latitude");     // Catch: Throwable -> L77
        int r23 = CursorUtil.getColumnIndexOrThrow(r2, Api.KEY_UUID);     // Catch: Throwable -> L77
        int r24 = CursorUtil.getColumnIndexOrThrow(r2, "poison_label");     // Catch: Throwable -> L77
        int r25 = CursorUtil.getColumnIndexOrThrow(r2, "poison_label_version");     // Catch: Throwable -> L77
        int r26 = CursorUtil.getColumnIndexOrThrow(r2, "content_hash");     // Catch: Throwable -> L77
        int r27 = r3;
        ArrayList r28 = new ArrayList(r2.getCount());     // Catch: Throwable -> L77
    L6:
        if (r2.moveToNext() == false) goto L75;
        long r29 = r2.getLong(r0);     // Catch: Throwable -> L77
        if (r2.isNull(r4) == false) goto L11;
        String r31 = null;
    L12:
        long r32 = r2.getLong(r5);     // Catch: Throwable -> L77
        long r34 = r2.getLong(r6);     // Catch: Throwable -> L77
        int r36 = r2.getInt(r7);     // Catch: Throwable -> L77
        long r37 = r2.getLong(r8);     // Catch: Throwable -> L77
        if (r2.isNull(r9) == false) goto L15;
        String r39 = null;
    L16:
        int r40 = r2.getInt(r10);     // Catch: Throwable -> L77
        int r41 = r2.getInt(r11);     // Catch: Throwable -> L77
        if (r2.isNull(r12) == false) goto L19;
        String r42 = null;
    L21:
        if (r2.isNull(r13) == false) goto L23;
        String r43 = null;
    L25:
        if (r2.isNull(r14) == false) goto L27;
        String r44 = null;
    L29:
        if (r2.isNull(r15) == false) goto L31;
        String r45 = null;
    L33:
        if (r2.isNull(r27) == false) goto L36;
        String r46 = null;
    L35:
        int r55 = r17;
        int r110 = r0;
        if (r2.isNull(r55) == false) goto L41;
        String r47 = null;
    L40:
        int r56 = r18;
        if (r2.isNull(r56) == false) goto L46;
        String r48 = null;
    L45:
        int r57 = r19;
        if (r2.isNull(r57) == false) goto L51;
        String r49 = null;
    L50:
        int r58 = r20;
        if (r2.isNull(r58) == false) goto L56;
        String r50 = null;
    L55:
        int r59 = r21;
        int r30 = r22;
        r22 = r30;
        gq r33 = new gq(r29, r31, r32, r34, r36, r37, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r2.getDouble(r59), r2.getDouble(r30));     // Catch: Throwable -> L77
        int r210 = r27;
        int r35 = r23;
        if (r2.isNull(r35) == false) goto L60;
        String r38 = null;
    L61:
        r33.setUuid(r38);     // Catch: Throwable -> L77
        r24 = r24;
        if (r2.isNull(r24) == false) goto L64;
        Integer r51 = null;
    L65:
        r33.setPoisonLabel(r51);     // Catch: Throwable -> L77
        r25 = r25;
        if (r2.isNull(r25) == false) goto L68;
        Integer r52 = null;
    L69:
        r33.setPoisonLabelVersion(r52);     // Catch: Throwable -> L77
        r26 = r26;
        if (r2.isNull(r26) == false) goto L72;
        String r53 = null;
    L73:
        r33.setContentHash(r53);     // Catch: Throwable -> L77
        r28.add(r33);     // Catch: Throwable -> L77
        r0 = r110;
        r17 = r55;
        r18 = r56;
        r19 = r57;
        r20 = r58;
        r21 = r59;
        r27 = r210;
        r23 = r35;
        goto L6
    L72:
        r53 = r2.getString(r26);     // Catch: Throwable -> L77
        goto L73
    L68:
        r52 = Integer.valueOf(r2.getInt(r25));     // Catch: Throwable -> L77
        goto L69
    L64:
        r51 = Integer.valueOf(r2.getInt(r24));     // Catch: Throwable -> L77
        goto L65
    L60:
        r38 = r2.getString(r35);     // Catch: Throwable -> L77
        goto L61
    L56:
        r50 = r2.getString(r58);     // Catch: Throwable -> L77
        goto L55
    L51:
        r49 = r2.getString(r57);     // Catch: Throwable -> L77
        goto L50
    L46:
        r48 = r2.getString(r56);     // Catch: Throwable -> L77
        goto L45
    L41:
        r47 = r2.getString(r55);     // Catch: Throwable -> L77
        goto L40
    L36:
        r46 = r2.getString(r27);     // Catch: Throwable -> L77
        goto L35
    L31:
        r45 = r2.getString(r15);     // Catch: Throwable -> L77
        goto L33
    L27:
        r44 = r2.getString(r14);     // Catch: Throwable -> L77
        goto L29
    L23:
        r43 = r2.getString(r13);     // Catch: Throwable -> L77
        goto L25
    L19:
        r42 = r2.getString(r12);     // Catch: Throwable -> L77
        goto L21
    L15:
        r39 = r2.getString(r9);     // Catch: Throwable -> L77
        goto L16
    L11:
        r31 = r2.getString(r4);     // Catch: Throwable -> L77
        goto L12
    L75:
        r2.close();
        r16.release();
        return r28;
    L77:
        th = th;
    L81:
        r2.close();
        r16.release();
        throw th;
    L79:
        th = th;
        r16 = r1;
        goto L81
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gq> queryByEntityId(String r1, String r2) {
        return MetaLocationRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gq> queryByEntityIdList(List<String> r3) {
        return MetaLocationRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gq> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return MetaLocationRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gq queryById(long r1) {
        return MetaLocationRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gq> queryByIdAndTimestamp(long r1, long r3) {
        return MetaLocationRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gq> queryByIds(List<Long> r3) {
        return MetaLocationRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return MetaLocationRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gq> queryByPackageName(String r1) {
        return MetaLocationRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gq> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return MetaLocationRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gq> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return MetaLocationRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gq queryByUUID(String r1) {
        return MetaLocationRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gq queryOne() {
        return MetaLocationRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<gq> queryRecentByPackageName(String r1, long r2) {
        return MetaLocationRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gq> queryWithLimitAndOffset(int r1, int r2) {
        return MetaLocationRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gq> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawMetaLocationEntity(r6));     // Catch: Throwable -> L10
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

    public int update(gq r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawMetaLocationEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((gq) ZeusTransformUtils.preCheckCast(r3, gq.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<gq> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawMetaLocationEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return MetaLocationRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
