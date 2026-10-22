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
import com.obric.memorydata.database.entity.hn;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UserProfileRawDbDao_Impl implements UserProfileRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<hn> __deletionAdapterOfRawUserProfileEntity;
    private final EntityInsertionAdapter<hn> __insertionAdapterOfRawUserProfileEntity;
    private final EntityDeletionOrUpdateAdapter<hn> __updateAdapterOfRawUserProfileEntity;

    public UserProfileRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawUserProfileEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawUserProfileEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawUserProfileEntity = new AnonymousClass3(this, r2);
    }

    private hn __entityCursorConverter_comObricMemorydataDatabaseEntityRawUserProfileEntity(Cursor r39) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r39, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r10 = CursorUtil.getColumnIndex(r0, "profileKey");
        int r11 = CursorUtil.getColumnIndex(r0, "profileValue");
        int r12 = CursorUtil.getColumnIndex(r0, "isFromAutoLearn");
        int r13 = CursorUtil.getColumnIndex(r0, "fullContent");
        int r14 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r15 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r16 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r17 = 0;
        if (r1 != (-1)) goto L5;
        long r21 = 0;
    L6:
        String r18 = null;
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
        boolean r19 = false;
        if (r5 != (-1)) goto L22;
        int r28 = 0;
    L23:
        if (r6 == (-1)) goto L26;
        r17 = r0.getLong(r6);
    L26:
        long r29 = r17;
        if (r7 != (-1)) goto L30;
    L28:
        String r31 = null;
    L33:
        if (r8 != (-1)) goto L35;
        int r32 = 0;
    L36:
        if (r9 != (-1)) goto L39;
    L37:
        String r33 = null;
    L42:
        if (r10 != (-1)) goto L45;
    L43:
        String r34 = null;
    L48:
        if (r11 != (-1)) goto L51;
    L49:
        String r35 = null;
    L54:
        if (r12 != (-1)) goto L57;
    L55:
        boolean r36 = r19;
        if (r13 != (-1)) goto L62;
    L60:
        String r37 = null;
    L65:
        hn r20 = new hn(r21, r23, r24, r26, r28, r29, r31, r32, r33, r34, r35, r36, r37);
        if (r14 == (-1)) goto L73;
        if (r0.isNull(r14) == false) goto L70;
        Integer r22 = null;
    L71:
        r20.setPoisonLabel(r22);
        goto L73
    L70:
        r22 = Integer.valueOf(r0.getInt(r14));
    L73:
        if (r15 == (-1)) goto L80;
        if (r0.isNull(r15) == false) goto L77;
        Integer r25 = null;
    L78:
        r20.setPoisonLabelVersion(r25);
        goto L80
    L77:
        r25 = Integer.valueOf(r0.getInt(r15));
    L80:
        if (r16 != (-1)) goto L82;
    L86:
        return r20;
    L82:
        if (r0.isNull(r16) == true) goto L85;
        r18 = r0.getString(r16);
    L85:
        r20.setContentHash(r18);
        goto L86
    L62:
        if (r0.isNull(r13) == true) goto L60;
        r37 = r0.getString(r13);
        goto L65
    L57:
        if (r0.getInt(r12) == 0) goto L55;
        r19 = true;
        goto L55
    L51:
        if (r0.isNull(r11) == true) goto L49;
        r35 = r0.getString(r11);
        goto L54
    L45:
        if (r0.isNull(r10) == true) goto L43;
        r34 = r0.getString(r10);
        goto L48
    L39:
        if (r0.isNull(r9) == true) goto L37;
        r33 = r0.getString(r9);
        goto L42
    L35:
        r32 = r0.getInt(r8);
        goto L36
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
        return UserProfileRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<hn> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawUserProfileEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<hn> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawUserProfileEntity.insert(r4);     // Catch: Throwable -> L6
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

    public int delete(hn r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawUserProfileEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((hn) ZeusTransformUtils.preCheckCast(r3, hn.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return UserProfileRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return UserProfileRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
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
        return UserProfileRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return UserProfileRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return UserProfileRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
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
        return UserProfileRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return UserProfileRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
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
        return UserProfileRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.UserProfileRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return UserProfileRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(hn r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawUserProfileEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((hn) ZeusTransformUtils.preCheckCast(r3, hn.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<hn> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawUserProfileEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hn> queryAll() {
        return UserProfileRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return UserProfileRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hn> queryByEntityId(String r1, String r2) {
        return UserProfileRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hn> queryByEntityIdList(List<String> r3) {
        return UserProfileRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hn> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return UserProfileRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hn queryById(long r1) {
        return UserProfileRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hn> queryByIdAndTimestamp(long r1, long r3) {
        return UserProfileRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hn> queryByIds(List<Long> r3) {
        return UserProfileRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return UserProfileRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hn> queryByPackageName(String r1) {
        return UserProfileRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hn> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return UserProfileRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hn> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return UserProfileRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.UserProfileRawDbDao
    public List<hn> queryByProfileKey(String r39) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM RawUserProfileEntity WHERE profileKey = ?", 1);
        if (r39 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L58
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L58
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L58
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L58
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L58
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L58
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L58
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L58
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L58
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "profileKey");     // Catch: Throwable -> L58
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "profileValue");     // Catch: Throwable -> L58
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "isFromAutoLearn");     // Catch: Throwable -> L58
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "fullContent");     // Catch: Throwable -> L58
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L58
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L56
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L56
        int r19 = r4;
        ArrayList r20 = new ArrayList(r5.getCount());     // Catch: Throwable -> L56
    L10:
        if (r5.moveToNext() == false) goto L54;
        long r21 = r5.getLong(r0);     // Catch: Throwable -> L56
        if (r5.isNull(r6) == false) goto L15;
        String r23 = null;
    L16:
        long r24 = r5.getLong(r7);     // Catch: Throwable -> L56
        long r26 = r5.getLong(r8);     // Catch: Throwable -> L56
        int r28 = r5.getInt(r9);     // Catch: Throwable -> L56
        long r29 = r5.getLong(r10);     // Catch: Throwable -> L56
        if (r5.isNull(r11) == false) goto L19;
        String r31 = null;
    L20:
        int r32 = r5.getInt(r12);     // Catch: Throwable -> L56
        if (r5.isNull(r13) == false) goto L23;
        String r33 = null;
    L25:
        if (r5.isNull(r14) == false) goto L27;
        String r34 = null;
    L29:
        if (r5.isNull(r15) == false) goto L31;
        String r35 = null;
    L33:
        if (r5.getInt(r1) == 0) goto L35;
        boolean r36 = true;
    L37:
        if (r5.isNull(r3) == false) goto L39;
        String r37 = null;
    L40:
        hn r22 = new hn(r21, r23, r24, r26, r28, r29, r31, r32, r33, r34, r35, r36, r37);     // Catch: Throwable -> L56
        int r25 = r0;
        int r27 = r19;
        if (r5.isNull(r27) == false) goto L43;
        Integer r30 = null;
    L44:
        r22.setPoisonLabel(r30);     // Catch: Throwable -> L56
        int r38 = r17;
        if (r5.isNull(r38) == false) goto L47;
        Integer r40 = null;
    L48:
        r22.setPoisonLabelVersion(r40);     // Catch: Throwable -> L56
        r18 = r18;
        if (r5.isNull(r18) == false) goto L51;
        String r41 = null;
    L52:
        r22.setContentHash(r41);     // Catch: Throwable -> L56
        r20.add(r22);     // Catch: Throwable -> L56
        r17 = r38;
        r0 = r25;
        r19 = r27;
        goto L10
    L51:
        r41 = r5.getString(r18);     // Catch: Throwable -> L56
        goto L52
    L47:
        r40 = Integer.valueOf(r5.getInt(r38));     // Catch: Throwable -> L56
        goto L48
    L43:
        r30 = Integer.valueOf(r5.getInt(r27));     // Catch: Throwable -> L56
        goto L44
    L39:
        r37 = r5.getString(r3);     // Catch: Throwable -> L56
        goto L40
    L35:
        r36 = false;
        goto L37
    L31:
        r35 = r5.getString(r15);     // Catch: Throwable -> L56
        goto L33
    L27:
        r34 = r5.getString(r14);     // Catch: Throwable -> L56
        goto L29
    L23:
        r33 = r5.getString(r13);     // Catch: Throwable -> L56
        goto L25
    L19:
        r31 = r5.getString(r11);     // Catch: Throwable -> L56
        goto L20
    L15:
        r23 = r5.getString(r6);     // Catch: Throwable -> L56
        goto L16
    L54:
        r5.close();
        r16.release();
        return r20;
    L56:
        th = th;
    L60:
        r5.close();
        r16.release();
        throw th;
    L58:
        th = th;
        r16 = r2;
        goto L60
    L5:
        r2.bindString(1, r39);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hn queryByUUID(String r1) {
        return UserProfileRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hn queryOne() {
        return UserProfileRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<hn> queryRecentByPackageName(String r1, long r2) {
        return UserProfileRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hn> queryWithLimitAndOffset(int r1, int r2) {
        return UserProfileRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hn> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawUserProfileEntity(r6));     // Catch: Throwable -> L10
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

    public int update(hn r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawUserProfileEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((hn) ZeusTransformUtils.preCheckCast(r3, hn.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<hn> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawUserProfileEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return UserProfileRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
