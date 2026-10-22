package com.obric.memorydata.database.legacy.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class RawUserProfileHistoryRawDbDaoOld_Impl implements ao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.z> __deletionAdapterOfRawUserProfileHistoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.entity.z> __insertionAdapterOfRawUserProfileHistoryEntityOld;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.z> __updateAdapterOfRawUserProfileHistoryEntityOld;

    public RawUserProfileHistoryRawDbDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawUserProfileHistoryEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawUserProfileHistoryEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawUserProfileHistoryEntityOld = new AnonymousClass3(this, r2);
    }

    private com.obric.memorydata.database.legacy.entity.z __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityRawUserProfileHistoryEntityOld(Cursor r44) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r44, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "user_profile_id");
        int r3 = CursorUtil.getColumnIndex(r0, "user_profile_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "user_profile_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "user_profile_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "user_profile_type");
        int r7 = CursorUtil.getColumnIndex(r0, "user_profile_timestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "user_profile_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "user_profile_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "user_profile_uuid");
        int r11 = CursorUtil.getColumnIndex(r0, "user_profile_profileKey");
        int r12 = CursorUtil.getColumnIndex(r0, "user_profile_profileValue");
        int r13 = CursorUtil.getColumnIndex(r0, "user_profile_isFromAutoLearn");
        int r14 = CursorUtil.getColumnIndex(r0, "user_profile_fullContent");
        int r15 = CursorUtil.getColumnIndex(r0, "user_profile_personalDbSplitMigrated");
        int r16 = CursorUtil.getColumnIndex(r0, "user_profile_poison_label");
        int r17 = CursorUtil.getColumnIndex(r0, "user_profile_poison_label_version");
        int r18 = CursorUtil.getColumnIndex(r0, "user_profile_content_hash");
        long r19 = 0;
        if (r1 != (-1)) goto L5;
        long r22 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r25 = 0;
    L9:
        String r20 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r27 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r28 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r30 = 0;
    L22:
        boolean r21 = false;
        if (r6 != (-1)) goto L25;
        int r32 = 0;
    L26:
        if (r7 == (-1)) goto L29;
        r19 = r0.getLong(r7);
    L29:
        long r33 = r19;
        if (r8 != (-1)) goto L33;
    L31:
        String r35 = null;
    L36:
        if (r9 != (-1)) goto L38;
        int r36 = 0;
    L39:
        if (r10 != (-1)) goto L42;
    L40:
        String r37 = null;
    L45:
        if (r11 != (-1)) goto L48;
    L46:
        String r38 = null;
    L51:
        if (r12 != (-1)) goto L54;
    L52:
        String r39 = null;
    L58:
        if (r13 != (-1)) goto L61;
        boolean r40 = false;
    L65:
        if (r14 != (-1)) goto L68;
    L66:
        String r41 = null;
    L71:
        if (r43 != (-1)) goto L74;
    L76:
        com.obric.memorydata.database.legacy.entity.y r23 = new com.obric.memorydata.database.legacy.entity.y(r25, r27, r28, r30, r32, r33, r35, r36, r37, r38, r39, r40, r41, r21);
        if (r16 == (-1)) goto L84;
        if (r0.isNull(r16) == false) goto L81;
        Integer r24 = null;
    L82:
        r23.setPoisonLabel(r24);
        goto L84
    L81:
        r24 = Integer.valueOf(r0.getInt(r16));
    L84:
        if (r17 == (-1)) goto L91;
        if (r0.isNull(r17) == false) goto L88;
        Integer r26 = null;
    L89:
        r23.setPoisonLabelVersion(r26);
        goto L91
    L88:
        r26 = Integer.valueOf(r0.getInt(r17));
    L91:
        if (r18 == (-1)) goto L98;
        if (r0.isNull(r18) == true) goto L96;
        r20 = r0.getString(r18);
    L96:
        r23.setContentHash(r20);
    L98:
        return new com.obric.memorydata.database.legacy.entity.z(r22, r23);
    L74:
        if (r0.getInt(r15) == 0) goto L76;
        r21 = true;
        goto L76
    L68:
        if (r0.isNull(r14) == true) goto L66;
        r41 = r0.getString(r14);
        goto L71
    L61:
        if (r0.getInt(r13) == 0) goto L63;
        boolean r29 = true;
    L64:
        r40 = r29;
        goto L65
    L63:
        r29 = false;
        goto L64
    L54:
        if (r0.isNull(r12) == true) goto L52;
        r39 = r0.getString(r12);
        goto L58
    L48:
        if (r0.isNull(r11) == true) goto L46;
        r38 = r0.getString(r11);
        goto L51
    L42:
        if (r0.isNull(r10) == true) goto L40;
        r37 = r0.getString(r10);
        goto L45
    L38:
        r36 = r0.getInt(r9);
        goto L39
    L33:
        if (r0.isNull(r8) == true) goto L31;
        r35 = r0.getString(r8);
        goto L36
    L25:
        r32 = r0.getInt(r6);
        goto L26
    L21:
        r30 = r0.getLong(r5);
        goto L22
    L18:
        r28 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r27 = r0.getString(r3);
        goto L16
    L8:
        r25 = r0.getLong(r2);
        goto L9
    L5:
        r22 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.entity.z> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawUserProfileHistoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.entity.z> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawUserProfileHistoryEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.memorydata.database.legacy.entity.z r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawUserProfileHistoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.memorydata.database.legacy.entity.z r3) {
        return delete2((com.obric.memorydata.database.legacy.entity.z) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.z.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ao.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ao.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.memorydata.database.legacy.entity.z r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawUserProfileHistoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.memorydata.database.legacy.entity.z r3) {
        return insert2((com.obric.memorydata.database.legacy.entity.z) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.z.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.entity.z> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawUserProfileHistoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.z> queryAll() {
        return ao.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ao.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.z queryById(long r1) {
        return ao.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.z queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.z> queryByIds(List<Long> r3) {
        return ao.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.z queryByUUID(String r1) {
        return ao.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.z queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.z queryOne() {
        return ao.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.z queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.z> queryWithLimitAndOffset(int r1, int r2) {
        return ao.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.z> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityRawUserProfileHistoryEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.memorydata.database.legacy.entity.z r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawUserProfileHistoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.memorydata.database.legacy.entity.z r3) {
        return update2((com.obric.memorydata.database.legacy.entity.z) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.z.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.entity.z> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawUserProfileHistoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
