package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.database.entity.cl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class LocationDao_Impl implements LocationDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<cl> __deletionAdapterOfLocationEntity;
    private final EntityInsertionAdapter<cl> __insertionAdapterOfLocationEntity;
    private final EntityDeletionOrUpdateAdapter<cl> __updateAdapterOfLocationEntity;

    public LocationDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfLocationEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfLocationEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfLocationEntity = new AnonymousClass3(this, r2);
    }

    private cl __entityCursorConverter_comObricMemorydataDatabaseEntityLocationEntity(Cursor r36) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r36, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "dataId");
        int r2 = CursorUtil.getColumnIndex(r0, "dataVersion");
        int r3 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r4 = CursorUtil.getColumnIndex(r0, "longitude");
        int r5 = CursorUtil.getColumnIndex(r0, "latitude");
        int r6 = CursorUtil.getColumnIndex(r0, "cellId");
        int r7 = CursorUtil.getColumnIndex(r0, "lac");
        int r8 = CursorUtil.getColumnIndex(r0, "cellType");
        int r9 = CursorUtil.getColumnIndex(r0, "bssid");
        int r10 = CursorUtil.getColumnIndex(r0, Api.KEY_SSID);
        int r11 = CursorUtil.getColumnIndex(r0, LocationMonitorConst.ACCURACY);
        int r12 = CursorUtil.getColumnIndex(r0, "speed");
        int r13 = CursorUtil.getColumnIndex(r0, "harState");
        int r14 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        if (r1 != (-1)) goto L5;
        int r17 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        int r18 = 0;
    L10:
        if (r3 != (-1)) goto L12;
        long r19 = 0;
    L13:
        double r21 = 0.0d;
        if (r4 != (-1)) goto L16;
        double r15 = 0.0d;
    L17:
        if (r5 == (-1)) goto L20;
        r21 = r0.getDouble(r5);
    L20:
        double r23 = r21;
        Integer r16 = null;
        if (r6 != (-1)) goto L24;
    L22:
        Long r25 = null;
    L27:
        if (r7 != (-1)) goto L30;
    L28:
        Integer r26 = null;
    L33:
        if (r8 != (-1)) goto L36;
    L34:
        String r27 = null;
    L39:
        if (r9 != (-1)) goto L42;
    L40:
        String r28 = null;
    L45:
        if (r10 != (-1)) goto L48;
    L46:
        String r29 = null;
    L51:
        if (r11 != (-1)) goto L54;
    L52:
        Float r30 = null;
    L57:
        if (r12 != (-1)) goto L60;
    L58:
        Float r31 = null;
    L63:
        if (r13 != (-1)) goto L66;
    L64:
        Integer r32 = r16;
        if (r14 != (-1)) goto L71;
        long r33 = 0;
    L73:
        return new cl(r17, r18, r19, r15, r23, r25, r26, r27, r28, r29, r30, r31, r32, r33);
    L71:
        r33 = r0.getLong(r14);
        goto L73
    L66:
        if (r0.isNull(r13) == true) goto L64;
        r16 = Integer.valueOf(r0.getInt(r13));
        goto L64
    L60:
        if (r0.isNull(r12) == true) goto L58;
        r31 = Float.valueOf(r0.getFloat(r12));
        goto L63
    L54:
        if (r0.isNull(r11) == true) goto L52;
        r30 = Float.valueOf(r0.getFloat(r11));
        goto L57
    L48:
        if (r0.isNull(r10) == true) goto L46;
        r29 = r0.getString(r10);
        goto L51
    L42:
        if (r0.isNull(r9) == true) goto L40;
        r28 = r0.getString(r9);
        goto L45
    L36:
        if (r0.isNull(r8) == true) goto L34;
        r27 = r0.getString(r8);
        goto L39
    L30:
        if (r0.isNull(r7) == true) goto L28;
        r26 = Integer.valueOf(r0.getInt(r7));
        goto L33
    L24:
        if (r0.isNull(r6) == true) goto L22;
        r25 = Long.valueOf(r0.getLong(r6));
        goto L27
    L16:
        r15 = r0.getDouble(r4);
        goto L17
    L12:
        r19 = r0.getLong(r3);
        goto L13
    L8:
        r18 = r0.getInt(r2);
        goto L10
    L5:
        r17 = r0.getInt(r1);
        goto L6
    }

    static /* synthetic */ RoomDatabase access$000(LocationDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<cl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfLocationEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<cl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfLocationEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(cl r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfLocationEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(cl r3) {
        return delete2((cl) ZeusTransformUtils.preCheckCast(r3, cl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return LocationDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.LocationDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return LocationDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(cl r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfLocationEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(cl r3) {
        return insert2((cl) ZeusTransformUtils.preCheckCast(r3, cl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<cl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfLocationEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cl> queryAll() {
        return LocationDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return LocationDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cl queryById(long r1) {
        return LocationDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cl queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cl> queryByIds(List<Long> r3) {
        return LocationDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cl queryByUUID(String r1) {
        return LocationDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cl queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.LocationDao
    public cl queryFirstRecord() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawLocation ORDER BY timestamp ASC LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "dataId");     // Catch: Throwable -> L42
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "dataVersion");     // Catch: Throwable -> L42
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L42
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "longitude");     // Catch: Throwable -> L42
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "latitude");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "cellId");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "lac");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "cellType");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "bssid");     // Catch: Throwable -> L42
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, Api.KEY_SSID);     // Catch: Throwable -> L42
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, LocationMonitorConst.ACCURACY);     // Catch: Throwable -> L42
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "speed");     // Catch: Throwable -> L42
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "harState");     // Catch: Throwable -> L42
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L42
        if (r2.moveToFirst() == false) goto L39;
        int r18 = r2.getInt(r0);     // Catch: Throwable -> L42
        int r19 = r2.getInt(r4);     // Catch: Throwable -> L42
        long r20 = r2.getLong(r5);     // Catch: Throwable -> L42
        double r22 = r2.getDouble(r6);     // Catch: Throwable -> L42
        double r24 = r2.getDouble(r7);     // Catch: Throwable -> L42
        if (r2.isNull(r8) == false) goto L8;
        Long r26 = null;
    L10:
        if (r2.isNull(r9) == false) goto L12;
        Integer r27 = null;
    L14:
        if (r2.isNull(r10) == false) goto L16;
        String r28 = null;
    L18:
        if (r2.isNull(r11) == false) goto L20;
        String r29 = null;
    L22:
        if (r2.isNull(r12) == false) goto L24;
        String r30 = null;
    L26:
        if (r2.isNull(r13) == false) goto L28;
        Float r31 = null;
    L30:
        if (r2.isNull(r14) == false) goto L32;
        Float r32 = null;
    L34:
        if (r2.isNull(r15) == false) goto L36;
        Integer r33 = null;
    L37:
        cl r16 = new cl(r18, r19, r20, r22, r24, r26, r27, r28, r29, r30, r31, r32, r33, r2.getLong(r3));     // Catch: Throwable -> L42
    L40:
        r2.close();
        r1.release();
        return r16;
    L36:
        r33 = Integer.valueOf(r2.getInt(r15));     // Catch: Throwable -> L42
        goto L37
    L32:
        r32 = Float.valueOf(r2.getFloat(r14));     // Catch: Throwable -> L42
        goto L34
    L28:
        r31 = Float.valueOf(r2.getFloat(r13));     // Catch: Throwable -> L42
        goto L30
    L24:
        r30 = r2.getString(r12);     // Catch: Throwable -> L42
        goto L26
    L20:
        r29 = r2.getString(r11);     // Catch: Throwable -> L42
        goto L22
    L16:
        r28 = r2.getString(r10);     // Catch: Throwable -> L42
        goto L18
    L12:
        r27 = Integer.valueOf(r2.getInt(r9));     // Catch: Throwable -> L42
        goto L14
    L8:
        r26 = Long.valueOf(r2.getLong(r8));     // Catch: Throwable -> L42
        goto L10
    L39:
        r16 = null;
    L42:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.LocationDao
    public cl queryLastRecord() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawLocation ORDER BY id DESC LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "dataId");     // Catch: Throwable -> L42
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "dataVersion");     // Catch: Throwable -> L42
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L42
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "longitude");     // Catch: Throwable -> L42
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "latitude");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "cellId");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "lac");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "cellType");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "bssid");     // Catch: Throwable -> L42
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, Api.KEY_SSID);     // Catch: Throwable -> L42
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, LocationMonitorConst.ACCURACY);     // Catch: Throwable -> L42
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "speed");     // Catch: Throwable -> L42
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "harState");     // Catch: Throwable -> L42
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L42
        if (r2.moveToFirst() == false) goto L39;
        int r18 = r2.getInt(r0);     // Catch: Throwable -> L42
        int r19 = r2.getInt(r4);     // Catch: Throwable -> L42
        long r20 = r2.getLong(r5);     // Catch: Throwable -> L42
        double r22 = r2.getDouble(r6);     // Catch: Throwable -> L42
        double r24 = r2.getDouble(r7);     // Catch: Throwable -> L42
        if (r2.isNull(r8) == false) goto L8;
        Long r26 = null;
    L10:
        if (r2.isNull(r9) == false) goto L12;
        Integer r27 = null;
    L14:
        if (r2.isNull(r10) == false) goto L16;
        String r28 = null;
    L18:
        if (r2.isNull(r11) == false) goto L20;
        String r29 = null;
    L22:
        if (r2.isNull(r12) == false) goto L24;
        String r30 = null;
    L26:
        if (r2.isNull(r13) == false) goto L28;
        Float r31 = null;
    L30:
        if (r2.isNull(r14) == false) goto L32;
        Float r32 = null;
    L34:
        if (r2.isNull(r15) == false) goto L36;
        Integer r33 = null;
    L37:
        cl r16 = new cl(r18, r19, r20, r22, r24, r26, r27, r28, r29, r30, r31, r32, r33, r2.getLong(r3));     // Catch: Throwable -> L42
    L40:
        r2.close();
        r1.release();
        return r16;
    L36:
        r33 = Integer.valueOf(r2.getInt(r15));     // Catch: Throwable -> L42
        goto L37
    L32:
        r32 = Float.valueOf(r2.getFloat(r14));     // Catch: Throwable -> L42
        goto L34
    L28:
        r31 = Float.valueOf(r2.getFloat(r13));     // Catch: Throwable -> L42
        goto L30
    L24:
        r30 = r2.getString(r12);     // Catch: Throwable -> L42
        goto L26
    L20:
        r29 = r2.getString(r11);     // Catch: Throwable -> L42
        goto L22
    L16:
        r28 = r2.getString(r10);     // Catch: Throwable -> L42
        goto L18
    L12:
        r27 = Integer.valueOf(r2.getInt(r9));     // Catch: Throwable -> L42
        goto L14
    L8:
        r26 = Long.valueOf(r2.getLong(r8));     // Catch: Throwable -> L42
        goto L10
    L39:
        r16 = null;
    L42:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.LocationDao
    public cl queryLastRecord(long r37, long r39) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawLocation WHERE timestamp >= ? AND timestamp < ? ORDER BY timestamp DESC LIMIT 1", 2);
        r1.bindLong(1, r37);
        r1.bindLong(2, r39);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "dataId");     // Catch: Throwable -> L42
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "dataVersion");     // Catch: Throwable -> L42
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L42
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "longitude");     // Catch: Throwable -> L42
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "latitude");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "cellId");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "lac");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "cellType");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "bssid");     // Catch: Throwable -> L42
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, Api.KEY_SSID);     // Catch: Throwable -> L42
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, LocationMonitorConst.ACCURACY);     // Catch: Throwable -> L42
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "speed");     // Catch: Throwable -> L42
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "harState");     // Catch: Throwable -> L42
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L42
        if (r2.moveToFirst() == false) goto L39;
        int r18 = r2.getInt(r0);     // Catch: Throwable -> L42
        int r19 = r2.getInt(r4);     // Catch: Throwable -> L42
        long r20 = r2.getLong(r5);     // Catch: Throwable -> L42
        double r22 = r2.getDouble(r6);     // Catch: Throwable -> L42
        double r24 = r2.getDouble(r7);     // Catch: Throwable -> L42
        if (r2.isNull(r8) == false) goto L8;
        Long r26 = null;
    L10:
        if (r2.isNull(r9) == false) goto L12;
        Integer r27 = null;
    L14:
        if (r2.isNull(r10) == false) goto L16;
        String r28 = null;
    L18:
        if (r2.isNull(r11) == false) goto L20;
        String r29 = null;
    L22:
        if (r2.isNull(r12) == false) goto L24;
        String r30 = null;
    L26:
        if (r2.isNull(r13) == false) goto L28;
        Float r31 = null;
    L30:
        if (r2.isNull(r14) == false) goto L32;
        Float r32 = null;
    L34:
        if (r2.isNull(r15) == false) goto L36;
        Integer r33 = null;
    L37:
        cl r16 = new cl(r18, r19, r20, r22, r24, r26, r27, r28, r29, r30, r31, r32, r33, r2.getLong(r3));     // Catch: Throwable -> L42
    L40:
        r2.close();
        r1.release();
        return r16;
    L36:
        r33 = Integer.valueOf(r2.getInt(r15));     // Catch: Throwable -> L42
        goto L37
    L32:
        r32 = Float.valueOf(r2.getFloat(r14));     // Catch: Throwable -> L42
        goto L34
    L28:
        r31 = Float.valueOf(r2.getFloat(r13));     // Catch: Throwable -> L42
        goto L30
    L24:
        r30 = r2.getString(r12);     // Catch: Throwable -> L42
        goto L26
    L20:
        r29 = r2.getString(r11);     // Catch: Throwable -> L42
        goto L22
    L16:
        r28 = r2.getString(r10);     // Catch: Throwable -> L42
        goto L18
    L12:
        r27 = Integer.valueOf(r2.getInt(r9));     // Catch: Throwable -> L42
        goto L14
    L8:
        r26 = Long.valueOf(r2.getLong(r8));     // Catch: Throwable -> L42
        goto L10
    L39:
        r16 = null;
    L42:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.LocationDao
    public LiveData<cl> queryLastRecordLiveData() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM RawLocation ORDER BY id DESC LIMIT 1", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"RawLocation"}, false, new AnonymousClass4(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.LocationDao
    public cl queryOnceRecordByEndTs(long r37) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawLocation WHERE timestamp <= ? ORDER BY timestamp DESC LIMIT 1", 1);
        r1.bindLong(1, r37);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "dataId");     // Catch: Throwable -> L42
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "dataVersion");     // Catch: Throwable -> L42
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L42
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "longitude");     // Catch: Throwable -> L42
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "latitude");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "cellId");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "lac");     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "cellType");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "bssid");     // Catch: Throwable -> L42
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, Api.KEY_SSID);     // Catch: Throwable -> L42
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, LocationMonitorConst.ACCURACY);     // Catch: Throwable -> L42
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "speed");     // Catch: Throwable -> L42
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "harState");     // Catch: Throwable -> L42
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L42
        if (r2.moveToFirst() == false) goto L39;
        int r18 = r2.getInt(r0);     // Catch: Throwable -> L42
        int r19 = r2.getInt(r4);     // Catch: Throwable -> L42
        long r20 = r2.getLong(r5);     // Catch: Throwable -> L42
        double r22 = r2.getDouble(r6);     // Catch: Throwable -> L42
        double r24 = r2.getDouble(r7);     // Catch: Throwable -> L42
        if (r2.isNull(r8) == false) goto L8;
        Long r26 = null;
    L10:
        if (r2.isNull(r9) == false) goto L12;
        Integer r27 = null;
    L14:
        if (r2.isNull(r10) == false) goto L16;
        String r28 = null;
    L18:
        if (r2.isNull(r11) == false) goto L20;
        String r29 = null;
    L22:
        if (r2.isNull(r12) == false) goto L24;
        String r30 = null;
    L26:
        if (r2.isNull(r13) == false) goto L28;
        Float r31 = null;
    L30:
        if (r2.isNull(r14) == false) goto L32;
        Float r32 = null;
    L34:
        if (r2.isNull(r15) == false) goto L36;
        Integer r33 = null;
    L37:
        cl r16 = new cl(r18, r19, r20, r22, r24, r26, r27, r28, r29, r30, r31, r32, r33, r2.getLong(r3));     // Catch: Throwable -> L42
    L40:
        r2.close();
        r1.release();
        return r16;
    L36:
        r33 = Integer.valueOf(r2.getInt(r15));     // Catch: Throwable -> L42
        goto L37
    L32:
        r32 = Float.valueOf(r2.getFloat(r14));     // Catch: Throwable -> L42
        goto L34
    L28:
        r31 = Float.valueOf(r2.getFloat(r13));     // Catch: Throwable -> L42
        goto L30
    L24:
        r30 = r2.getString(r12);     // Catch: Throwable -> L42
        goto L26
    L20:
        r29 = r2.getString(r11);     // Catch: Throwable -> L42
        goto L22
    L16:
        r28 = r2.getString(r10);     // Catch: Throwable -> L42
        goto L18
    L12:
        r27 = Integer.valueOf(r2.getInt(r9));     // Catch: Throwable -> L42
        goto L14
    L8:
        r26 = Long.valueOf(r2.getLong(r8));     // Catch: Throwable -> L42
        goto L10
    L39:
        r16 = null;
    L42:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public cl queryOne() {
        return LocationDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ cl queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.LocationDao
    public List<cl> queryRecords(long r37, long r39) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawLocation WHERE timestamp >= ? AND timestamp < ? ORDER by timestamp ASC", 2);
        r1.bindLong(1, r37);
        r1.bindLong(2, r39);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, "dataId");     // Catch: Throwable -> L46
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "dataVersion");     // Catch: Throwable -> L46
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L46
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "longitude");     // Catch: Throwable -> L46
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "latitude");     // Catch: Throwable -> L46
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "cellId");     // Catch: Throwable -> L46
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "lac");     // Catch: Throwable -> L46
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "cellType");     // Catch: Throwable -> L46
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "bssid");     // Catch: Throwable -> L46
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, Api.KEY_SSID);     // Catch: Throwable -> L46
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, LocationMonitorConst.ACCURACY);     // Catch: Throwable -> L46
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "speed");     // Catch: Throwable -> L46
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "harState");     // Catch: Throwable -> L46
        RoomSQLiteQuery r16 = r1;
        int r38 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L46
        ArrayList r3 = new ArrayList(r2.getCount());     // Catch: Throwable -> L44
    L6:
        if (r2.moveToNext() == false) goto L42;
        int r18 = r2.getInt(r0);     // Catch: Throwable -> L44
        int r19 = r2.getInt(r4);     // Catch: Throwable -> L44
        long r20 = r2.getLong(r5);     // Catch: Throwable -> L44
        double r22 = r2.getDouble(r6);     // Catch: Throwable -> L44
        double r24 = r2.getDouble(r7);     // Catch: Throwable -> L44
        if (r2.isNull(r8) == false) goto L11;
        Long r26 = null;
    L13:
        if (r2.isNull(r9) == false) goto L15;
        Integer r27 = null;
    L17:
        if (r2.isNull(r10) == false) goto L19;
        String r28 = null;
    L21:
        if (r2.isNull(r11) == false) goto L23;
        String r29 = null;
    L25:
        if (r2.isNull(r12) == false) goto L27;
        String r30 = null;
    L29:
        if (r2.isNull(r13) == false) goto L31;
        Float r31 = null;
    L33:
        if (r2.isNull(r14) == false) goto L35;
        Float r32 = null;
    L37:
        if (r2.isNull(r15) == false) goto L39;
        Integer r33 = null;
    L40:
        long r34 = r2.getLong(r38);     // Catch: Throwable -> L44
        int r310 = r0;
        r3.add(new cl(r18, r19, r20, r22, r24, r26, r27, r28, r29, r30, r31, r32, r33, r34));     // Catch: Throwable -> L44
        r0 = r310;
        r38 = r38;
        goto L6
    L39:
        r33 = Integer.valueOf(r2.getInt(r15));     // Catch: Throwable -> L44
        goto L40
    L35:
        r32 = Float.valueOf(r2.getFloat(r14));     // Catch: Throwable -> L44
        goto L37
    L31:
        r31 = Float.valueOf(r2.getFloat(r13));     // Catch: Throwable -> L44
        goto L33
    L27:
        r30 = r2.getString(r12);     // Catch: Throwable -> L44
        goto L29
    L23:
        r29 = r2.getString(r11);     // Catch: Throwable -> L44
        goto L25
    L19:
        r28 = r2.getString(r10);     // Catch: Throwable -> L44
        goto L21
    L15:
        r27 = Integer.valueOf(r2.getInt(r9));     // Catch: Throwable -> L44
        goto L17
    L11:
        r26 = Long.valueOf(r2.getLong(r8));     // Catch: Throwable -> L44
        goto L13
    L42:
        r2.close();
        r16.release();
        return r3;
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
    public List<cl> queryWithLimitAndOffset(int r1, int r2) {
        return LocationDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<cl> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityLocationEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(cl r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfLocationEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(cl r3) {
        return update2((cl) ZeusTransformUtils.preCheckCast(r3, cl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<cl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfLocationEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
