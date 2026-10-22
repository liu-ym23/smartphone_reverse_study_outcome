package com.obric.memorydata.database.legacy.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UserProfileRawDbDaoOld_Impl implements be {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.y> __deletionAdapterOfRawUserProfileEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.entity.y> __insertionAdapterOfRawUserProfileEntityOld;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.y> __updateAdapterOfRawUserProfileEntityOld;

    public UserProfileRawDbDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawUserProfileEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawUserProfileEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawUserProfileEntityOld = new AnonymousClass3(this, r2);
    }

    private com.obric.memorydata.database.legacy.entity.y __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityRawUserProfileEntityOld(Cursor r41) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r41, Cursor.class, "com.obric.memorydata.plugin");
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
        int r14 = CursorUtil.getColumnIndex(r0, "personalDbSplitMigrated");
        int r15 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r16 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r17 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r18 = 0;
        if (r1 != (-1)) goto L5;
        long r22 = 0;
    L6:
        String r19 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r24 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r25 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r27 = 0;
    L19:
        boolean r20 = false;
        if (r5 != (-1)) goto L22;
        int r29 = 0;
    L23:
        if (r6 == (-1)) goto L26;
        r18 = r0.getLong(r6);
    L26:
        long r30 = r18;
        if (r7 != (-1)) goto L30;
    L28:
        String r32 = null;
    L33:
        if (r8 != (-1)) goto L35;
        int r33 = 0;
    L36:
        if (r9 != (-1)) goto L39;
    L37:
        String r34 = null;
    L42:
        if (r10 != (-1)) goto L45;
    L43:
        String r35 = null;
    L48:
        if (r11 != (-1)) goto L51;
    L49:
        String r36 = null;
    L55:
        if (r12 != (-1)) goto L58;
        boolean r37 = false;
    L62:
        if (r13 != (-1)) goto L65;
    L63:
        String r38 = null;
    L68:
        if (r14 != (-1)) goto L71;
    L73:
        com.obric.memorydata.database.legacy.entity.y r21 = new com.obric.memorydata.database.legacy.entity.y(r22, r24, r25, r27, r29, r30, r32, r33, r34, r35, r36, r37, r38, r20);
        if (r15 == (-1)) goto L81;
        if (r0.isNull(r15) == false) goto L78;
        Integer r23 = null;
    L79:
        r21.setPoisonLabel(r23);
        goto L81
    L78:
        r23 = Integer.valueOf(r0.getInt(r15));
    L81:
        if (r16 == (-1)) goto L88;
        if (r0.isNull(r16) == false) goto L85;
        Integer r26 = null;
    L86:
        r21.setPoisonLabelVersion(r26);
        goto L88
    L85:
        r26 = Integer.valueOf(r0.getInt(r16));
    L88:
        if (r17 != (-1)) goto L90;
    L94:
        return r21;
    L90:
        if (r0.isNull(r17) == true) goto L93;
        r19 = r0.getString(r17);
    L93:
        r21.setContentHash(r19);
        goto L94
    L71:
        if (r0.getInt(r14) == 0) goto L73;
        r20 = true;
        goto L73
    L65:
        if (r0.isNull(r13) == true) goto L63;
        r38 = r0.getString(r13);
        goto L68
    L58:
        if (r0.getInt(r12) == 0) goto L60;
        boolean r28 = true;
    L61:
        r37 = r28;
        goto L62
    L60:
        r28 = false;
        goto L61
    L51:
        if (r0.isNull(r11) == true) goto L49;
        r36 = r0.getString(r11);
        goto L55
    L45:
        if (r0.isNull(r10) == true) goto L43;
        r35 = r0.getString(r10);
        goto L48
    L39:
        if (r0.isNull(r9) == true) goto L37;
        r34 = r0.getString(r9);
        goto L42
    L35:
        r33 = r0.getInt(r8);
        goto L36
    L30:
        if (r0.isNull(r7) == true) goto L28;
        r32 = r0.getString(r7);
        goto L33
    L22:
        r29 = r0.getInt(r5);
        goto L23
    L18:
        r27 = r0.getLong(r4);
        goto L19
    L15:
        r25 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r24 = r0.getString(r2);
        goto L13
    L5:
        r22 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.entity.y> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawUserProfileEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.entity.y> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawUserProfileEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.memorydata.database.legacy.entity.y r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawUserProfileEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.memorydata.database.legacy.entity.y r3) {
        return delete2((com.obric.memorydata.database.legacy.entity.y) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.y.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return be.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return be.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.memorydata.database.legacy.entity.y r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawUserProfileEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.memorydata.database.legacy.entity.y r3) {
        return insert2((com.obric.memorydata.database.legacy.entity.y) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.y.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.entity.y> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawUserProfileEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.y> queryAll() {
        return be.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return be.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.y queryById(long r1) {
        return be.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.y queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.y> queryByIds(List<Long> r3) {
        return be.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.y queryByUUID(String r1) {
        return be.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.y queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.y queryOne() {
        return be.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.y queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.y> queryWithLimitAndOffset(int r1, int r2) {
        return be.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.y> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityRawUserProfileEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.memorydata.database.legacy.entity.y r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawUserProfileEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.memorydata.database.legacy.entity.y r3) {
        return update2((com.obric.memorydata.database.legacy.entity.y) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.y.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.entity.y> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawUserProfileEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
