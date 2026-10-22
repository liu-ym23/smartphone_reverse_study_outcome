package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.u;
import com.obric.memorydata.database.entity.y;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoMemoryProDao_Impl implements AutoMemoryProDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<AutoMemoryProEntity> __deletionAdapterOfAutoMemoryProEntity;
    private final EntityInsertionAdapter<AutoMemoryProEntity> __insertionAdapterOfAutoMemoryProEntity;
    private final SharedSQLiteStatement __preparedStmtOfClearEntityTable;
    private final SharedSQLiteStatement __preparedStmtOfDeleteEntityById;
    private final SharedSQLiteStatement __preparedStmtOfResetSequence;
    private final EntityDeletionOrUpdateAdapter<AutoMemoryProEntity> __updateAdapterOfAutoMemoryProEntity;

    public AutoMemoryProDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAutoMemoryProEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfAutoMemoryProEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfAutoMemoryProEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteEntityById = new AnonymousClass4(this, r2);
        this.__preparedStmtOfClearEntityTable = new AnonymousClass5(this, r2);
        this.__preparedStmtOfResetSequence = new AnonymousClass6(this, r2);
    }

    private AutoMemoryProEntity __entityCursorConverter_comObricMemorydataDatabaseEntityAutoMemoryProEntity(Cursor r56) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r56, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r7 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r8 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r9 = CursorUtil.getColumnIndex(r0, "rule_id");
        int r10 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r11 = CursorUtil.getColumnIndex(r0, "title");
        int r12 = CursorUtil.getColumnIndex(r0, Params.CONTENT);
        int r13 = CursorUtil.getColumnIndex(r0, "subtitle");
        int r14 = CursorUtil.getColumnIndex(r0, InfoRequestQPSOptTraceLogger.REASON);
        int r15 = CursorUtil.getColumnIndex(r0, "log_id");
        int r16 = CursorUtil.getColumnIndex(r0, "trace_id");
        int r17 = CursorUtil.getColumnIndex(r0, "package_names");
        int r18 = CursorUtil.getColumnIndex(r0, "episodic_ids");
        int r19 = CursorUtil.getColumnIndex(r0, "semantic_ids");
        int r110 = CursorUtil.getColumnIndex(r0, "raw_observation_ids");
        int r111 = CursorUtil.getColumnIndex(r0, "fullContent");
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
        if (r6 != (-1)) goto L26;
    L24:
        String r37 = null;
    L29:
        if (r7 != (-1)) goto L31;
        int r38 = 0;
    L32:
        if (r8 != (-1)) goto L35;
    L33:
        String r39 = null;
    L38:
        if (r9 != (-1)) goto L40;
        long r40 = 0;
    L41:
        if (r10 == (-1)) goto L44;
        r23 = r0.getLong(r10);
    L44:
        long r42 = r23;
        if (r11 != (-1)) goto L48;
    L46:
        String r44 = null;
    L51:
        if (r12 != (-1)) goto L54;
    L52:
        String r45 = null;
    L57:
        if (r13 != (-1)) goto L60;
    L58:
        String r46 = null;
    L63:
        if (r14 != (-1)) goto L66;
    L64:
        String r47 = null;
    L69:
        if (r55 != (-1)) goto L72;
    L70:
        String r48 = null;
    L75:
        if (r56 == (-1)) goto L78;
        r21 = r0.getInt(r16);
    L78:
        int r49 = r21;
        if (r17 != (-1)) goto L83;
    L80:
        String r50 = null;
    L86:
        if (r18 != (-1)) goto L90;
    L87:
        String r51 = null;
    L93:
        if (r19 != (-1)) goto L97;
    L94:
        String r52 = null;
    L100:
        if (r110 != (-1)) goto L104;
    L101:
        String r53 = null;
    L107:
        if (r111 != (-1)) goto L110;
    L108:
        String r54 = null;
    L113:
        AutoMemoryProEntity r22 = new AutoMemoryProEntity(r29, r31, r32, r34, r36, r37, r38, r39, r40, r42, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54);
        if (r112 == (-1)) goto L121;
        if (r0.isNull(r112) == false) goto L118;
        Integer r24 = null;
    L119:
        r22.setPoisonLabel(r24);
        goto L121
    L118:
        r24 = Integer.valueOf(r0.getInt(r112));
    L121:
        if (r113 == (-1)) goto L128;
        if (r0.isNull(r113) == false) goto L125;
        Integer r25 = null;
    L126:
        r22.setPoisonLabelVersion(r25);
        goto L128
    L125:
        r25 = Integer.valueOf(r0.getInt(r113));
    L128:
        if (r114 != (-1)) goto L130;
    L134:
        return r22;
    L130:
        if (r0.isNull(r114) == true) goto L133;
        r20 = r0.getString(r114);
    L133:
        r22.setContentHash(r20);
        goto L134
    L110:
        if (r0.isNull(r111) == true) goto L108;
        r54 = r0.getString(r111);
        goto L113
    L104:
        if (r0.isNull(r110) == true) goto L101;
        r53 = r0.getString(r110);
        goto L107
    L97:
        if (r0.isNull(r19) == true) goto L94;
        r52 = r0.getString(r19);
        goto L100
    L90:
        if (r0.isNull(r18) == true) goto L87;
        r51 = r0.getString(r18);
        goto L93
    L83:
        if (r0.isNull(r17) == true) goto L80;
        r50 = r0.getString(r17);
        goto L86
    L72:
        if (r0.isNull(r55) == true) goto L70;
        r48 = r0.getString(r15);
        goto L75
    L66:
        if (r0.isNull(r14) == true) goto L64;
        r47 = r0.getString(r14);
        goto L69
    L60:
        if (r0.isNull(r13) == true) goto L58;
        r46 = r0.getString(r13);
        goto L63
    L54:
        if (r0.isNull(r12) == true) goto L52;
        r45 = r0.getString(r12);
        goto L57
    L48:
        if (r0.isNull(r11) == true) goto L46;
        r44 = r0.getString(r11);
        goto L51
    L40:
        r40 = r0.getLong(r9);
        goto L41
    L35:
        if (r0.isNull(r8) == true) goto L33;
        r39 = r0.getString(r8);
        goto L38
    L31:
        r38 = r0.getInt(r7);
        goto L32
    L26:
        if (r0.isNull(r6) == true) goto L24;
        r37 = r0.getString(r6);
        goto L29
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
        return AutoMemoryProDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao, com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<AutoMemoryProEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        AutoMemoryProDao.DefaultImpls.bulkDelete(this, r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public void bulkDeleteRaw(List<AutoMemoryProEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAutoMemoryProEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao, com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<AutoMemoryProEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        AutoMemoryProDao.DefaultImpls.bulkInsert(this, r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public void clearEntityTable() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfClearEntityTable.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfClearEntityTable.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfClearEntityTable.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public void clearTable() {
        this.__db.beginTransaction();
        AutoMemoryProDao.DefaultImpls.clearTable(this);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public void clearTableAndResetId() {
        this.__db.beginTransaction();
        AutoMemoryProDao.DefaultImpls.clearTableAndResetId(this);     // Catch: Throwable -> L6
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

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public int delete(AutoMemoryProEntity r2) {
        this.__db.beginTransaction();
        int r3 = AutoMemoryProDao.DefaultImpls.delete(this, r2);     // Catch: Throwable -> L6
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
        return delete((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao, com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        this.__db.beginTransaction();
        int r0 = AutoMemoryProDao.DefaultImpls.deleteAll(this);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public int deleteById(long r2) {
        this.__db.beginTransaction();
        int r3 = AutoMemoryProDao.DefaultImpls.deleteById(this, r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao, com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        int r5 = AutoMemoryProDao.DefaultImpls.deleteByRawDbIds(this, r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public int deleteEntityById(long r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteEntityById.acquire();
        r0.bindLong(1, r3);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteEntityById.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteEntityById.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public int deleteRaw(AutoMemoryProEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAutoMemoryProEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public List<AutoMemoryProEntity> getAllForTracker() {
        return AutoMemoryProDao.DefaultImpls.getAllForTracker(this);
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
        return AutoMemoryProDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return AutoMemoryProDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return AutoMemoryProDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
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
        return AutoMemoryProDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return AutoMemoryProDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
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
        return AutoMemoryProDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return AutoMemoryProDao.DefaultImpls.getTableName(this);
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public long insert(AutoMemoryProEntity r3) {
        this.__db.beginTransaction();
        long r0 = AutoMemoryProDao.DefaultImpls.insert(this, r3);     // Catch: Throwable -> L6
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
        return insert((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao, com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<AutoMemoryProEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        List<Long> r5 = AutoMemoryProDao.DefaultImpls.insertAll(this, r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public List<Long> insertAllRaw(List<AutoMemoryProEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAutoMemoryProEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public long insertRaw(AutoMemoryProEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAutoMemoryProEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProEntity> queryAll() {
        return AutoMemoryProDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return AutoMemoryProDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public List<Long> queryAllRuleIds() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT rule_id FROM AutoMemoryPro", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r5.getCount());     // Catch: Throwable -> L10
    L5:
        if (r5.moveToNext() == false) goto L8;
        r2.add(Long.valueOf(r5.getLong(0)));     // Catch: Throwable -> L10
        goto L5
    L8:
        r5.close();
        r0.release();
        return r2;
    L10:
        th = move-exception;
        r5.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public AutoMemoryProEntity queryByEntityId(String r1) {
        return AutoMemoryProDao.DefaultImpls.queryByEntityId(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<AutoMemoryProEntity> queryByEntityId(String r1, String r2) {
        return AutoMemoryProDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<AutoMemoryProEntity> queryByEntityIdList(List<String> r3) {
        return AutoMemoryProDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<AutoMemoryProEntity> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return AutoMemoryProDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProEntity queryById(long r1) {
        return AutoMemoryProDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<AutoMemoryProEntity> queryByIdAndTimestamp(long r1, long r3) {
        return AutoMemoryProDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProEntity> queryByIds(List<Long> r3) {
        return AutoMemoryProDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return AutoMemoryProDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<AutoMemoryProEntity> queryByPackageName(String r1) {
        return AutoMemoryProDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<AutoMemoryProEntity> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return AutoMemoryProDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<AutoMemoryProEntity> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return AutoMemoryProDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public long queryByRuleId(long r3) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM AutoMemoryPro WHERE rule_id = ?", 1);
        r0.bindLong(1, r3);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r0, false, null);
    L10:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L7;
        long r4 = r2.getLong(0);     // Catch: Throwable -> L10
    L8:
        r2.close();
        r0.release();
        return r4;
    L7:
        r4 = 0;
        goto L8
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProEntity queryByUUID(String r1) {
        return AutoMemoryProDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public List<u> queryDeleteRefsByIds(List<Long> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT id, entityId, packageName FROM AutoMemoryPro WHERE id IN (");
        int r2 = r11.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r12 = r11.iterator();
        int r4 = 1;
    L4:
        if (r12.hasNext() == false) goto L6;
        r1.bindLong(r4, ((Long) ZeusTransformUtils.preCheckCast(r12.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r4 = r4 + 1;
        goto L4
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r9 = DBUtil.query(this.__db, r1, false, null);
        ArrayList r3 = new ArrayList(r9.getCount());     // Catch: Throwable -> L22
    L8:
        if (r9.moveToNext() == false) goto L20;
        long r5 = r9.getLong(0);     // Catch: Throwable -> L22
        if (r9.isNull(1) == false) goto L13;
        String r6 = null;
    L15:
        if (r9.isNull(2) == false) goto L17;
        String r7 = null;
    L18:
        r3.add(new u(r5, r6, r7));     // Catch: Throwable -> L22
        goto L8
    L17:
        r7 = r9.getString(2);     // Catch: Throwable -> L22
        goto L18
    L13:
        r6 = r9.getString(1);     // Catch: Throwable -> L22
        goto L15
    L20:
        r9.close();
        r1.release();
        return r3;
    L22:
        th = move-exception;
        r9.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public List<u> queryDeleteRefsByRuleId(long r9) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id, entityId, packageName FROM AutoMemoryPro WHERE rule_id = ? ORDER BY id ASC", 1);
        r0.bindLong(1, r9);
        this.__db.assertNotSuspendingTransaction();
        Cursor r8 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r8.getCount());     // Catch: Throwable -> L18
    L4:
        if (r8.moveToNext() == false) goto L16;
        long r3 = r8.getLong(0);     // Catch: Throwable -> L18
        if (r8.isNull(1) == false) goto L9;
        String r5 = null;
    L11:
        if (r8.isNull(2) == false) goto L13;
        String r6 = null;
    L14:
        r2.add(new u(r3, r5, r6));     // Catch: Throwable -> L18
        goto L4
    L13:
        r6 = r8.getString(2);     // Catch: Throwable -> L18
        goto L14
    L9:
        r5 = r8.getString(1);     // Catch: Throwable -> L18
        goto L11
    L16:
        r8.close();
        r0.release();
        return r2;
    L18:
        th = move-exception;
        r8.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public List<y> queryListItemsByRuleId(long r14) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id, uuid, modifyTime, title, SUBSTR(content, 1, 2000) AS content, subtitle FROM AutoMemoryPro WHERE rule_id = ? ORDER BY timestamp DESC", 1);
        r0.bindLong(1, r14);
        this.__db.assertNotSuspendingTransaction();
        Cursor r13 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r13.getCount());     // Catch: Throwable -> L26
    L4:
        if (r13.moveToNext() == false) goto L24;
        long r5 = r13.getLong(0);     // Catch: Throwable -> L26
        if (r13.isNull(1) == false) goto L9;
        String r12 = null;
    L10:
        long r7 = r13.getLong(2);     // Catch: Throwable -> L26
        if (r13.isNull(3) == false) goto L13;
        String r9 = null;
    L15:
        if (r13.isNull(4) == false) goto L17;
        String r10 = null;
    L19:
        if (r13.isNull(5) == false) goto L21;
        String r11 = null;
    L22:
        r2.add(new y(r5, r7, r9, r10, r11, r12));     // Catch: Throwable -> L26
        goto L4
    L21:
        r11 = r13.getString(5);     // Catch: Throwable -> L26
        goto L22
    L17:
        r10 = r13.getString(4);     // Catch: Throwable -> L26
        goto L19
    L13:
        r9 = r13.getString(3);     // Catch: Throwable -> L26
        goto L15
    L9:
        r12 = r13.getString(1);     // Catch: Throwable -> L26
        goto L10
    L24:
        r13.close();
        r0.release();
        return r2;
    L26:
        th = move-exception;
        r13.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public Long queryMaxIdByRuleId(long r3) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT MAX(id) FROM AutoMemoryPro WHERE rule_id = ?", 1);
        r0.bindLong(1, r3);
        this.__db.assertNotSuspendingTransaction();
        Long r4 = null;
        Cursor r2 = DBUtil.query(this.__db, r0, false, null);
    L12:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    L4:
        if (r2.moveToFirst() == true) goto L6;
    L10:
        r2.close();
        r0.release();
        return r4;
    L6:
        if (r2.isNull(0) == true) goto L10;
        r4 = Long.valueOf(r2.getLong(0));     // Catch: Throwable -> L12
        goto L10
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public long queryNewCountByRuleId(long r4, long r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM AutoMemoryPro WHERE rule_id = ? AND id > ?", 2);
        r0.bindLong(1, r4);
        r0.bindLong(2, r6);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L10:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L7;
        long r5 = r3.getLong(0);     // Catch: Throwable -> L10
    L8:
        r3.close();
        r0.release();
        return r5;
    L7:
        r5 = 0;
        goto L8
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProEntity queryOne() {
        return AutoMemoryProDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<AutoMemoryProEntity> queryRecentByPackageName(String r1, long r2) {
        return AutoMemoryProDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProEntity> queryWithLimitAndOffset(int r1, int r2) {
        return AutoMemoryProDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityAutoMemoryProEntity(r6));     // Catch: Throwable -> L10
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

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public void resetSequence() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfResetSequence.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfResetSequence.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfResetSequence.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public int update(AutoMemoryProEntity r2) {
        this.__db.beginTransaction();
        int r3 = AutoMemoryProDao.DefaultImpls.update(this, r2);     // Catch: Throwable -> L6
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
        return update((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao, com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<AutoMemoryProEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        AutoMemoryProDao.DefaultImpls.updateAll(this, r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public void updateAllRaw(List<AutoMemoryProEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAutoMemoryProEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return AutoMemoryProDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProDao
    public int updateRaw(AutoMemoryProEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAutoMemoryProEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
