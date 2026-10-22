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
import com.obric.lifelog.data.Lifelog;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.LifelogEntity;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class LifelogDao_Impl implements LifelogDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<LifelogEntity> __deletionAdapterOfLifelogEntity;
    private final EntityInsertionAdapter<LifelogEntity> __insertionAdapterOfLifelogEntity;
    private final EntityDeletionOrUpdateAdapter<LifelogEntity> __updateAdapterOfLifelogEntity;

    public LifelogDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfLifelogEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfLifelogEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfLifelogEntity = new AnonymousClass3(this, r2);
    }

    private LifelogEntity __entityCursorConverter_comObricMemorydataDatabaseEntityLifelogEntity(Cursor r55) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r55, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "entityTimestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r10 = CursorUtil.getColumnIndex(r0, "fullContent");
        int r11 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r12 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r13 = CursorUtil.getColumnIndex(r0, "content_hash");
        int r14 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r15 = CursorUtil.getColumnIndex(r0, "uid");
        int r16 = CursorUtil.getColumnIndex(r0, "title");
        int r17 = CursorUtil.getColumnIndex(r0, "contentAM");
        int r18 = CursorUtil.getColumnIndex(r0, "contentPM");
        int r19 = CursorUtil.getColumnIndex(r0, "finalContent");
        int r110 = CursorUtil.getColumnIndex(r0, "imageUrl");
        int r111 = CursorUtil.getColumnIndex(r0, "retryTime");
        int r112 = CursorUtil.getColumnIndex(r0, "status");
        long r21 = 0;
        if (r1 != (-1)) goto L5;
        long r27 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r29 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r30 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r32 = 0;
    L19:
        int r22 = 0;
        if (r5 != (-1)) goto L22;
        int r34 = 0;
    L23:
        if (r6 != (-1)) goto L25;
        long r35 = 0;
    L26:
        if (r7 != (-1)) goto L29;
    L27:
        String r37 = null;
    L32:
        if (r8 != (-1)) goto L34;
        int r38 = 0;
    L35:
        if (r9 != (-1)) goto L38;
    L36:
        String r39 = null;
    L41:
        if (r10 != (-1)) goto L44;
    L42:
        String r41 = null;
    L47:
        if (r14 != (-1)) goto L49;
        long r43 = 0;
    L50:
        if (r15 == (-1)) goto L53;
        r21 = r0.getLong(r15);
    L53:
        long r45 = r21;
        if (r16 != (-1)) goto L57;
    L55:
        String r47 = null;
    L60:
        if (r17 != (-1)) goto L64;
    L61:
        String r48 = null;
    L67:
        if (r18 != (-1)) goto L71;
    L68:
        String r49 = null;
    L74:
        if (r19 != (-1)) goto L78;
    L75:
        String r50 = null;
    L81:
        if (r110 != (-1)) goto L85;
    L82:
        String r51 = null;
    L88:
        if (r111 != (-1)) goto L90;
        int r52 = 0;
    L92:
        if (r112 == (-1)) goto L95;
        r22 = r0.getInt(r112);
    L95:
        LifelogEntity r23 = new LifelogEntity(r27, r29, r30, r32, r34, r35, r37, r38, r39, new Lifelog(r43, r45, r47, r48, r49, r50, r51, r52, r22), r41);
        if (r11 == (-1)) goto L103;
        if (r0.isNull(r11) == false) goto L100;
        Integer r24 = null;
    L101:
        r23.setPoisonLabel(r24);
        goto L103
    L100:
        r24 = Integer.valueOf(r0.getInt(r11));
    L103:
        if (r12 == (-1)) goto L110;
        if (r0.isNull(r12) == false) goto L107;
        Integer r25 = null;
    L108:
        r23.setPoisonLabelVersion(r25);
        goto L110
    L107:
        r25 = Integer.valueOf(r0.getInt(r12));
    L110:
        if (r13 != (-1)) goto L112;
    L116:
        return r23;
    L112:
        if (r0.isNull(r13) == true) goto L115;
        r20 = r0.getString(r13);
    L115:
        r23.setContentHash(r20);
        goto L116
    L90:
        r52 = r0.getInt(r111);
        goto L92
    L85:
        if (r0.isNull(r110) == true) goto L82;
        r51 = r0.getString(r110);
        goto L88
    L78:
        if (r0.isNull(r19) == true) goto L75;
        r50 = r0.getString(r19);
        goto L81
    L71:
        if (r0.isNull(r18) == true) goto L68;
        r49 = r0.getString(r18);
        goto L74
    L64:
        if (r0.isNull(r17) == true) goto L61;
        r48 = r0.getString(r17);
        goto L67
    L57:
        if (r0.isNull(r16) == true) goto L55;
        r47 = r0.getString(r16);
        goto L60
    L49:
        r43 = r0.getLong(r14);
        goto L50
    L44:
        if (r0.isNull(r10) == true) goto L42;
        r41 = r0.getString(r10);
        goto L47
    L38:
        if (r0.isNull(r9) == true) goto L36;
        r39 = r0.getString(r9);
        goto L41
    L34:
        r38 = r0.getInt(r8);
        goto L35
    L29:
        if (r0.isNull(r7) == true) goto L27;
        r37 = r0.getString(r7);
        goto L32
    L25:
        r35 = r0.getLong(r6);
        goto L26
    L22:
        r34 = r0.getInt(r5);
        goto L23
    L18:
        r32 = r0.getLong(r4);
        goto L19
    L15:
        r30 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r29 = r0.getString(r2);
        goto L13
    L5:
        r27 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return LifelogDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<LifelogEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfLifelogEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<LifelogEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfLifelogEntity.insert(r4);     // Catch: Throwable -> L6
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

    public int delete(LifelogEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfLifelogEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((LifelogEntity) ZeusTransformUtils.preCheckCast(r3, LifelogEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return LifelogDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return LifelogDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
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
        return LifelogDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return LifelogDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return LifelogDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
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
        return LifelogDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return LifelogDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
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
        return LifelogDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.LifelogDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return LifelogDao.DefaultImpls.getTableName(this);
    }

    public long insert(LifelogEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfLifelogEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((LifelogEntity) ZeusTransformUtils.preCheckCast(r3, LifelogEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<LifelogEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfLifelogEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<LifelogEntity> queryAll() {
        return LifelogDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return LifelogDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<LifelogEntity> queryByEntityId(String r1, String r2) {
        return LifelogDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<LifelogEntity> queryByEntityIdList(List<String> r3) {
        return LifelogDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<LifelogEntity> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return LifelogDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public LifelogEntity queryById(long r1) {
        return LifelogDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<LifelogEntity> queryByIdAndTimestamp(long r1, long r3) {
        return LifelogDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<LifelogEntity> queryByIds(List<Long> r3) {
        return LifelogDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return LifelogDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<LifelogEntity> queryByPackageName(String r1) {
        return LifelogDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<LifelogEntity> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return LifelogDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<LifelogEntity> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return LifelogDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.LifelogDao
    public LifelogEntity queryByTimestamp(long r52) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM Lifelog WHERE timestamp = ? LIMIT 1", 1);
        r1.bindLong(1, r52);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L62
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "entityId");     // Catch: Throwable -> L62
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "createTime");     // Catch: Throwable -> L62
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "modifyTime");     // Catch: Throwable -> L62
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L62
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "entityTimestamp");     // Catch: Throwable -> L62
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L62
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "hashCodeValue");     // Catch: Throwable -> L62
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, Api.KEY_UUID);     // Catch: Throwable -> L62
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "fullContent");     // Catch: Throwable -> L62
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "poison_label");     // Catch: Throwable -> L62
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "poison_label_version");     // Catch: Throwable -> L62
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "content_hash");     // Catch: Throwable -> L62
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L62
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "uid");     // Catch: Throwable -> L60
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "title");     // Catch: Throwable -> L60
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "contentAM");     // Catch: Throwable -> L60
        int r110 = CursorUtil.getColumnIndexOrThrow(r2, "contentPM");     // Catch: Throwable -> L60
        int r111 = CursorUtil.getColumnIndexOrThrow(r2, "finalContent");     // Catch: Throwable -> L60
        int r112 = CursorUtil.getColumnIndexOrThrow(r2, "imageUrl");     // Catch: Throwable -> L60
        int r113 = CursorUtil.getColumnIndexOrThrow(r2, "retryTime");     // Catch: Throwable -> L60
        int r114 = CursorUtil.getColumnIndexOrThrow(r2, "status");     // Catch: Throwable -> L60
        if (r2.moveToFirst() == false) goto L57;
        long r24 = r2.getLong(r0);     // Catch: Throwable -> L60
        if (r2.isNull(r4) == false) goto L10;
        String r26 = null;
    L11:
        long r27 = r2.getLong(r5);     // Catch: Throwable -> L60
        long r29 = r2.getLong(r6);     // Catch: Throwable -> L60
        int r31 = r2.getInt(r7);     // Catch: Throwable -> L60
        long r32 = r2.getLong(r8);     // Catch: Throwable -> L60
        if (r2.isNull(r9) == false) goto L14;
        String r34 = null;
    L15:
        int r35 = r2.getInt(r10);     // Catch: Throwable -> L60
        if (r2.isNull(r11) == false) goto L18;
        String r36 = null;
    L20:
        if (r2.isNull(r12) == false) goto L22;
        String r38 = null;
    L23:
        long r40 = r2.getLong(r3);     // Catch: Throwable -> L60
        long r42 = r2.getLong(r17);     // Catch: Throwable -> L60
        if (r2.isNull(r18) == false) goto L26;
        String r44 = null;
    L28:
        if (r2.isNull(r19) == false) goto L30;
        String r45 = null;
    L32:
        if (r2.isNull(r18) == false) goto L34;
        String r46 = null;
    L36:
        if (r2.isNull(r19) == false) goto L38;
        String r47 = null;
    L40:
        if (r2.isNull(r20) == false) goto L42;
        String r48 = null;
    L43:
        LifelogEntity r20 = new LifelogEntity(r24, r26, r27, r29, r31, r32, r34, r35, r36, new Lifelog(r40, r42, r44, r45, r46, r47, r48, r2.getInt(r113), r2.getInt(r114)), r38);     // Catch: Throwable -> L60
        if (r2.isNull(r13) == false) goto L46;
        Integer r21 = null;
    L47:
        r20.setPoisonLabel(r21);     // Catch: Throwable -> L60
        if (r2.isNull(r14) == false) goto L50;
        Integer r22 = null;
    L51:
        r20.setPoisonLabelVersion(r22);     // Catch: Throwable -> L60
        if (r2.isNull(r15) == false) goto L54;
        String r23 = null;
    L55:
        r20.setContentHash(r23);     // Catch: Throwable -> L60
        LifelogEntity r25 = r20;
    L58:
        r2.close();
        r16.release();
        return r25;
    L54:
        r23 = r2.getString(r15);     // Catch: Throwable -> L60
        goto L55
    L50:
        r22 = Integer.valueOf(r2.getInt(r14));     // Catch: Throwable -> L60
        goto L51
    L46:
        r21 = Integer.valueOf(r2.getInt(r13));     // Catch: Throwable -> L60
        goto L47
    L42:
        r48 = r2.getString(r112);     // Catch: Throwable -> L60
        goto L43
    L38:
        r47 = r2.getString(r111);     // Catch: Throwable -> L60
        goto L40
    L34:
        r46 = r2.getString(r110);     // Catch: Throwable -> L60
        goto L36
    L30:
        r45 = r2.getString(r19);     // Catch: Throwable -> L60
        goto L32
    L26:
        r44 = r2.getString(r18);     // Catch: Throwable -> L60
        goto L28
    L22:
        r38 = r2.getString(r12);     // Catch: Throwable -> L60
        goto L23
    L18:
        r36 = r2.getString(r11);     // Catch: Throwable -> L60
        goto L20
    L14:
        r34 = r2.getString(r9);     // Catch: Throwable -> L60
        goto L15
    L10:
        r26 = r2.getString(r4);     // Catch: Throwable -> L60
        goto L11
    L57:
        r25 = null;
    L60:
        th = th;
    L64:
        r2.close();
        r16.release();
        throw th;
    L62:
        th = th;
        r16 = r1;
        goto L64
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public LifelogEntity queryByUUID(String r1) {
        return LifelogDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public LifelogEntity queryOne() {
        return LifelogDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<LifelogEntity> queryRecentByPackageName(String r1, long r2) {
        return LifelogDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<LifelogEntity> queryWithLimitAndOffset(int r1, int r2) {
        return LifelogDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<LifelogEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityLifelogEntity(r6));     // Catch: Throwable -> L10
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

    public int update(LifelogEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfLifelogEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((LifelogEntity) ZeusTransformUtils.preCheckCast(r3, LifelogEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<LifelogEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfLifelogEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return LifelogDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
