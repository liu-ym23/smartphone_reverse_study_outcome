package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.ck;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationAddressCacheDao_Impl implements LocationAddressCacheDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ck> __deletionAdapterOfLocationAddressCacheEntity;
    private final EntityInsertionAdapter<ck> __insertionAdapterOfLocationAddressCacheEntity;
    private final EntityInsertionAdapter<ck> __insertionAdapterOfLocationAddressCacheEntity_1;
    private final EntityDeletionOrUpdateAdapter<ck> __updateAdapterOfLocationAddressCacheEntity;

    public LocationAddressCacheDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfLocationAddressCacheEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfLocationAddressCacheEntity_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfLocationAddressCacheEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfLocationAddressCacheEntity = new AnonymousClass4(this, r2);
    }

    private ck __entityCursorConverter_comObricMemorydataDatabaseEntityLocationAddressCacheEntity(Cursor r43) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r43, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "latitudeE5");
        int r3 = CursorUtil.getColumnIndex(r0, "longitudeE5");
        int r4 = CursorUtil.getColumnIndex(r0, "localeTag");
        int r5 = CursorUtil.getColumnIndex(r0, "resolverVersion");
        int r6 = CursorUtil.getColumnIndex(r0, "country");
        int r7 = CursorUtil.getColumnIndex(r0, "stateOrProvince");
        int r8 = CursorUtil.getColumnIndex(r0, "administrativeArea");
        int r9 = CursorUtil.getColumnIndex(r0, "locality");
        int r10 = CursorUtil.getColumnIndex(r0, "subLocality");
        int r11 = CursorUtil.getColumnIndex(r0, "thoroughfare");
        int r12 = CursorUtil.getColumnIndex(r0, "subThoroughfare");
        int r13 = CursorUtil.getColumnIndex(r0, "namedLocation");
        int r14 = CursorUtil.getColumnIndex(r0, "fullAddress");
        int r15 = CursorUtil.getColumnIndex(r0, "isEmptyResult");
        int r16 = CursorUtil.getColumnIndex(r0, "expiresAt");
        int r17 = CursorUtil.getColumnIndex(r0, "updatedAt");
        long r18 = 0;
        if (r1 != (-1)) goto L5;
        long r22 = 0;
    L6:
        boolean r19 = false;
        if (r2 != (-1)) goto L9;
        int r24 = 0;
    L10:
        if (r3 != (-1)) goto L12;
        int r25 = 0;
    L13:
        String r20 = null;
        if (r4 != (-1)) goto L17;
    L15:
        String r26 = null;
    L20:
        if (r5 != (-1)) goto L22;
        int r27 = 0;
    L23:
        if (r6 != (-1)) goto L26;
    L24:
        String r28 = null;
    L29:
        if (r7 != (-1)) goto L32;
    L30:
        String r29 = null;
    L35:
        if (r8 != (-1)) goto L38;
    L36:
        String r30 = null;
    L41:
        if (r9 != (-1)) goto L44;
    L42:
        String r31 = null;
    L47:
        if (r10 != (-1)) goto L50;
    L48:
        String r32 = null;
    L53:
        if (r11 != (-1)) goto L56;
    L54:
        String r33 = null;
    L59:
        if (r12 != (-1)) goto L62;
    L60:
        String r34 = null;
    L65:
        if (r13 != (-1)) goto L68;
    L66:
        String r35 = null;
    L71:
        if (r14 != (-1)) goto L74;
    L72:
        String r36 = r20;
        if (r15 != (-1)) goto L80;
    L78:
        boolean r37 = r19;
        if (r16 != (-1)) goto L84;
        long r38 = 0;
    L86:
        if (r17 == (-1)) goto L90;
        r18 = r0.getLong(r17);
    L90:
        return new ck(r22, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r18);
    L84:
        r38 = r0.getLong(r16);
        goto L86
    L80:
        if (r0.getInt(r15) == 0) goto L78;
        r19 = true;
        goto L78
    L74:
        if (r0.isNull(r14) == true) goto L72;
        r20 = r0.getString(r14);
        goto L72
    L68:
        if (r0.isNull(r13) == true) goto L66;
        r35 = r0.getString(r13);
        goto L71
    L62:
        if (r0.isNull(r12) == true) goto L60;
        r34 = r0.getString(r12);
        goto L65
    L56:
        if (r0.isNull(r11) == true) goto L54;
        r33 = r0.getString(r11);
        goto L59
    L50:
        if (r0.isNull(r10) == true) goto L48;
        r32 = r0.getString(r10);
        goto L53
    L44:
        if (r0.isNull(r9) == true) goto L42;
        r31 = r0.getString(r9);
        goto L47
    L38:
        if (r0.isNull(r8) == true) goto L36;
        r30 = r0.getString(r8);
        goto L41
    L32:
        if (r0.isNull(r7) == true) goto L30;
        r29 = r0.getString(r7);
        goto L35
    L26:
        if (r0.isNull(r6) == true) goto L24;
        r28 = r0.getString(r6);
        goto L29
    L22:
        r27 = r0.getInt(r5);
        goto L23
    L17:
        if (r0.isNull(r4) == true) goto L15;
        r26 = r0.getString(r4);
        goto L20
    L12:
        r25 = r0.getInt(r3);
        goto L13
    L9:
        r24 = r0.getInt(r2);
        goto L10
    L5:
        r22 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ck> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfLocationAddressCacheEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ck> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfLocationAddressCacheEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(ck r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfLocationAddressCacheEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(ck r3) {
        return delete2((ck) ZeusTransformUtils.preCheckCast(r3, ck.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return LocationAddressCacheDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.LocationAddressCacheDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return LocationAddressCacheDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(ck r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfLocationAddressCacheEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(ck r3) {
        return insert2((ck) ZeusTransformUtils.preCheckCast(r3, ck.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ck> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfLocationAddressCacheEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.LocationAddressCacheDao
    public long insertOrReplace(ck r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfLocationAddressCacheEntity_1.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ck> queryAll() {
        return LocationAddressCacheDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return LocationAddressCacheDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ck queryById(long r1) {
        return LocationAddressCacheDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ck queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ck> queryByIds(List<Long> r3) {
        return LocationAddressCacheDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ck queryByUUID(String r1) {
        return LocationAddressCacheDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ck queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public ck queryOne() {
        return LocationAddressCacheDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ ck queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.LocationAddressCacheDao
    public ck queryValid(int r40, int r41, String r42, int r43, long r44) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM LocationAddressCache WHERE latitudeE5 = ? AND longitudeE5 = ? AND localeTag = ? AND resolverVersion = ? AND expiresAt > ? LIMIT 1", 5);
        r2.bindLong(1, r40);
        r2.bindLong(2, r41);
        if (r42 != null) goto L5;
        r2.bindNull(3);
    L6:
        r2.bindLong(4, r43);
        r2.bindLong(5, r44);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L62
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "latitudeE5");     // Catch: Throwable -> L62
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "longitudeE5");     // Catch: Throwable -> L62
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "localeTag");     // Catch: Throwable -> L62
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "resolverVersion");     // Catch: Throwable -> L62
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "country");     // Catch: Throwable -> L62
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "stateOrProvince");     // Catch: Throwable -> L62
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "administrativeArea");     // Catch: Throwable -> L62
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "locality");     // Catch: Throwable -> L62
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "subLocality");     // Catch: Throwable -> L62
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, "thoroughfare");     // Catch: Throwable -> L62
        int r1 = CursorUtil.getColumnIndexOrThrow(r4, "subThoroughfare");     // Catch: Throwable -> L62
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "namedLocation");     // Catch: Throwable -> L62
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "fullAddress");     // Catch: Throwable -> L62
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "isEmptyResult");     // Catch: Throwable -> L60
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "expiresAt");     // Catch: Throwable -> L60
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "updatedAt");     // Catch: Throwable -> L60
        if (r4.moveToFirst() == false) goto L57;
        long r110 = r4.getLong(r0);     // Catch: Throwable -> L60
        int r21 = r4.getInt(r5);     // Catch: Throwable -> L60
        int r22 = r4.getInt(r7);     // Catch: Throwable -> L60
        if (r4.isNull(r8) == false) goto L14;
        String r23 = null;
    L15:
        int r24 = r4.getInt(r9);     // Catch: Throwable -> L60
        if (r4.isNull(r10) == false) goto L18;
        String r25 = null;
    L20:
        if (r4.isNull(r11) == false) goto L22;
        String r26 = null;
    L24:
        if (r4.isNull(r12) == false) goto L26;
        String r27 = null;
    L28:
        if (r4.isNull(r13) == false) goto L30;
        String r28 = null;
    L32:
        if (r4.isNull(r14) == false) goto L34;
        String r29 = null;
    L36:
        if (r4.isNull(r15) == false) goto L38;
        String r30 = null;
    L40:
        if (r4.isNull(r1) == false) goto L42;
        String r31 = null;
    L44:
        if (r4.isNull(r3) == false) goto L46;
        String r32 = null;
    L48:
        if (r4.isNull(r6) == false) goto L50;
        String r33 = null;
    L52:
        if (r4.getInt(r17) == 0) goto L54;
        boolean r34 = true;
    L55:
        ck r20 = new ck(r110, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r4.getLong(r18), r4.getLong(r19));     // Catch: Throwable -> L60
    L58:
        r4.close();
        r16.release();
        return r20;
    L54:
        r34 = false;
        goto L55
    L50:
        r33 = r4.getString(r6);     // Catch: Throwable -> L60
        goto L52
    L46:
        r32 = r4.getString(r3);     // Catch: Throwable -> L60
        goto L48
    L42:
        r31 = r4.getString(r1);     // Catch: Throwable -> L60
        goto L44
    L38:
        r30 = r4.getString(r15);     // Catch: Throwable -> L60
        goto L40
    L34:
        r29 = r4.getString(r14);     // Catch: Throwable -> L60
        goto L36
    L30:
        r28 = r4.getString(r13);     // Catch: Throwable -> L60
        goto L32
    L26:
        r27 = r4.getString(r12);     // Catch: Throwable -> L60
        goto L28
    L22:
        r26 = r4.getString(r11);     // Catch: Throwable -> L60
        goto L24
    L18:
        r25 = r4.getString(r10);     // Catch: Throwable -> L60
        goto L20
    L14:
        r23 = r4.getString(r8);     // Catch: Throwable -> L60
        goto L15
    L57:
        r20 = null;
    L60:
        th = th;
    L64:
        r4.close();
        r16.release();
        throw th;
    L62:
        th = th;
        r16 = r2;
        goto L64
    L5:
        r2.bindString(3, r42);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ck> queryWithLimitAndOffset(int r1, int r2) {
        return LocationAddressCacheDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ck> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityLocationAddressCacheEntity(r6));     // Catch: Throwable -> L10
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

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public int update2(ck r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfLocationAddressCacheEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(ck r3) {
        return update2((ck) ZeusTransformUtils.preCheckCast(r3, ck.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ck> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfLocationAddressCacheEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
