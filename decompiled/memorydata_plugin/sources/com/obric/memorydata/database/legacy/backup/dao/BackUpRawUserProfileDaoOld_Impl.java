package com.obric.memorydata.database.legacy.backup.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.legacy.entity.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class BackUpRawUserProfileDaoOld_Impl implements r {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.r> __deletionAdapterOfBackUpRawUserProfileEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.r> __insertionAdapterOfBackUpRawUserProfileEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.r> __insertionAdapterOfBackUpRawUserProfileEntityOld_1;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.r> __updateAdapterOfBackUpRawUserProfileEntityOld;

    public BackUpRawUserProfileDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBackUpRawUserProfileEntityOld = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfBackUpRawUserProfileEntityOld_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfBackUpRawUserProfileEntityOld = new AnonymousClass3(this, r2);
        this.__updateAdapterOfBackUpRawUserProfileEntityOld = new AnonymousClass4(this, r2);
    }

    private com.obric.memorydata.database.legacy.backup.a.r __entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpRawUserProfileEntityOld(Cursor r50) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r50, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "backupUserId");
        int r3 = CursorUtil.getColumnIndex(r0, "backupDbVersion");
        int r4 = CursorUtil.getColumnIndex(r0, "backup_id");
        int r5 = CursorUtil.getColumnIndex(r0, "backup_entityId");
        int r6 = CursorUtil.getColumnIndex(r0, "backup_createTime");
        int r7 = CursorUtil.getColumnIndex(r0, "backup_modifyTime");
        int r8 = CursorUtil.getColumnIndex(r0, "backup_type");
        int r9 = CursorUtil.getColumnIndex(r0, "backup_timestamp");
        int r10 = CursorUtil.getColumnIndex(r0, "backup_packageName");
        int r11 = CursorUtil.getColumnIndex(r0, "backup_hashCodeValue");
        int r12 = CursorUtil.getColumnIndex(r0, "backup_uuid");
        int r13 = CursorUtil.getColumnIndex(r0, "backup_profileKey");
        int r14 = CursorUtil.getColumnIndex(r0, "backup_profileValue");
        int r15 = CursorUtil.getColumnIndex(r0, "backup_isFromAutoLearn");
        int r16 = CursorUtil.getColumnIndex(r0, "backup_fullContent");
        int r17 = CursorUtil.getColumnIndex(r0, "backup_personalDbSplitMigrated");
        int r18 = CursorUtil.getColumnIndex(r0, "backup_poison_label");
        int r19 = CursorUtil.getColumnIndex(r0, "backup_poison_label_version");
        int r110 = CursorUtil.getColumnIndex(r0, "backup_content_hash");
        long r111 = 0;
        if (r1 != (-1)) goto L5;
        long r25 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r28 = null;
    L13:
        boolean r21 = false;
        if (r3 != (-1)) goto L16;
        int r29 = 0;
    L17:
        if (r4 != (-1)) goto L19;
        long r31 = 0;
    L20:
        if (r5 != (-1)) goto L23;
    L21:
        String r33 = null;
    L26:
        if (r6 != (-1)) goto L28;
        long r34 = 0;
    L29:
        if (r7 != (-1)) goto L31;
        long r36 = 0;
    L32:
        if (r8 != (-1)) goto L34;
        int r38 = 0;
    L35:
        if (r9 == (-1)) goto L38;
        r111 = r0.getLong(r9);
    L38:
        long r39 = r111;
        if (r10 != (-1)) goto L42;
    L40:
        String r41 = null;
    L45:
        if (r11 != (-1)) goto L47;
        int r42 = 0;
    L48:
        if (r12 != (-1)) goto L51;
    L49:
        String r43 = null;
    L54:
        if (r13 != (-1)) goto L57;
    L55:
        String r44 = null;
    L60:
        if (r14 != (-1)) goto L63;
    L61:
        String r45 = null;
    L67:
        if (r15 != (-1)) goto L70;
        boolean r46 = false;
    L74:
        if (r50 != (-1)) goto L78;
    L75:
        String r47 = null;
    L81:
        if (r17 != (-1)) goto L84;
    L86:
        y r22 = new y(r31, r33, r34, r36, r38, r39, r41, r42, r43, r44, r45, r46, r47, r21);
        if (r18 == (-1)) goto L94;
        if (r0.isNull(r18) == false) goto L91;
        Integer r23 = null;
    L92:
        r22.setPoisonLabel(r23);
        goto L94
    L91:
        r23 = Integer.valueOf(r0.getInt(r18));
    L94:
        if (r19 == (-1)) goto L101;
        if (r0.isNull(r19) == false) goto L98;
        Integer r24 = null;
    L99:
        r22.setPoisonLabelVersion(r24);
        goto L101
    L98:
        r24 = Integer.valueOf(r0.getInt(r19));
    L101:
        if (r110 == (-1)) goto L108;
        if (r0.isNull(r110) == true) goto L106;
        r20 = r0.getString(r110);
    L106:
        r22.setContentHash(r20);
    L108:
        return new com.obric.memorydata.database.legacy.backup.a.r(r25, r22, r28, r29);
    L84:
        if (r0.getInt(r17) == 0) goto L86;
        r21 = true;
        goto L86
    L78:
        if (r0.isNull(r50) == true) goto L75;
        r47 = r0.getString(r16);
        goto L81
    L70:
        if (r0.getInt(r15) == 0) goto L72;
        boolean r26 = true;
    L73:
        r46 = r26;
        goto L74
    L72:
        r26 = false;
        goto L73
    L63:
        if (r0.isNull(r14) == true) goto L61;
        r45 = r0.getString(r14);
        goto L67
    L57:
        if (r0.isNull(r13) == true) goto L55;
        r44 = r0.getString(r13);
        goto L60
    L51:
        if (r0.isNull(r12) == true) goto L49;
        r43 = r0.getString(r12);
        goto L54
    L47:
        r42 = r0.getInt(r11);
        goto L48
    L42:
        if (r0.isNull(r10) == true) goto L40;
        r41 = r0.getString(r10);
        goto L45
    L34:
        r38 = r0.getInt(r8);
        goto L35
    L31:
        r36 = r0.getLong(r7);
        goto L32
    L28:
        r34 = r0.getLong(r6);
        goto L29
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r33 = r0.getString(r5);
        goto L26
    L19:
        r31 = r0.getLong(r4);
        goto L20
    L16:
        r29 = r0.getInt(r3);
        goto L17
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r28 = r0.getString(r2);
        goto L13
    L5:
        r25 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.backup.a.r> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBackUpRawUserProfileEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.backup.a.r> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBackUpRawUserProfileEntityOld_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(com.obric.memorydata.database.legacy.backup.a.r r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBackUpRawUserProfileEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((com.obric.memorydata.database.legacy.backup.a.r) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.r.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return r.a.d(this);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public int deleteByBackupUserId(String r1) {
        return r.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return r.a.a(this);
    }

    public long insert(com.obric.memorydata.database.legacy.backup.a.r r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBackUpRawUserProfileEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((com.obric.memorydata.database.legacy.backup.a.r) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.r.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.backup.a.r> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBackUpRawUserProfileEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.r> queryAll() {
        return r.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return r.a.c(this);
    }

    public List<com.obric.memorydata.database.legacy.backup.a.r> queryByBackupUserId(String r1) {
        return r.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public List<com.obric.memorydata.database.legacy.backup.a.r> queryByBackupUserId(String r1, int r2, int r3) {
        return r.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.r queryById(long r1) {
        return r.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.r> queryByIds(List<Long> r3) {
        return r.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.r queryByUUID(String r1) {
        return r.a.c(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.r queryOne() {
        return r.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.r> queryWithLimitAndOffset(int r1, int r2) {
        return r.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.r> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpRawUserProfileEntityOld(r6));     // Catch: Throwable -> L10
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

    public int update(com.obric.memorydata.database.legacy.backup.a.r r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBackUpRawUserProfileEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((com.obric.memorydata.database.legacy.backup.a.r) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.r.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.backup.a.r> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBackUpRawUserProfileEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
