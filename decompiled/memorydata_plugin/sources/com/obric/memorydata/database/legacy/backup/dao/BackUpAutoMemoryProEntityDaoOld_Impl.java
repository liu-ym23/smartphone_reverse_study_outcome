package com.obric.memorydata.database.legacy.backup.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.legacy.entity.AutoMemoryProEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class BackUpAutoMemoryProEntityDaoOld_Impl implements c {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.c> __deletionAdapterOfBackUpAutoMemoryProEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.c> __insertionAdapterOfBackUpAutoMemoryProEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.c> __insertionAdapterOfBackUpAutoMemoryProEntityOld_1;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.c> __updateAdapterOfBackUpAutoMemoryProEntityOld;

    public BackUpAutoMemoryProEntityDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBackUpAutoMemoryProEntityOld = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfBackUpAutoMemoryProEntityOld_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfBackUpAutoMemoryProEntityOld = new AnonymousClass3(this, r2);
        this.__updateAdapterOfBackUpAutoMemoryProEntityOld = new AnonymousClass4(this, r2);
    }

    private com.obric.memorydata.database.legacy.backup.a.c __entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpAutoMemoryProEntityOld(Cursor r67) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r67, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "backupUserId");
        int r3 = CursorUtil.getColumnIndex(r0, "backupDbVersion");
        int r4 = CursorUtil.getColumnIndex(r0, "backup_id");
        int r5 = CursorUtil.getColumnIndex(r0, "backup_entityId");
        int r6 = CursorUtil.getColumnIndex(r0, "backup_createTime");
        int r7 = CursorUtil.getColumnIndex(r0, "backup_modifyTime");
        int r8 = CursorUtil.getColumnIndex(r0, "backup_type");
        int r9 = CursorUtil.getColumnIndex(r0, "backup_packageName");
        int r10 = CursorUtil.getColumnIndex(r0, "backup_hashCodeValue");
        int r11 = CursorUtil.getColumnIndex(r0, "backup_uuid");
        int r12 = CursorUtil.getColumnIndex(r0, "backup_rule_id");
        int r13 = CursorUtil.getColumnIndex(r0, "backup_timestamp");
        int r14 = CursorUtil.getColumnIndex(r0, "backup_title");
        int r15 = CursorUtil.getColumnIndex(r0, "backup_content");
        int r16 = CursorUtil.getColumnIndex(r0, "backup_subtitle");
        int r17 = CursorUtil.getColumnIndex(r0, "backup_reason");
        int r18 = CursorUtil.getColumnIndex(r0, "backup_log_id");
        int r19 = CursorUtil.getColumnIndex(r0, "backup_trace_id");
        int r110 = CursorUtil.getColumnIndex(r0, "backup_package_names");
        int r111 = CursorUtil.getColumnIndex(r0, "backup_episodic_ids");
        int r112 = CursorUtil.getColumnIndex(r0, "backup_semantic_ids");
        int r113 = CursorUtil.getColumnIndex(r0, "backup_raw_observation_ids");
        int r114 = CursorUtil.getColumnIndex(r0, "backup_fullContent");
        int r115 = CursorUtil.getColumnIndex(r0, "backup_personalDbSplitMigrated");
        int r116 = CursorUtil.getColumnIndex(r0, "backup_poison_label");
        int r117 = CursorUtil.getColumnIndex(r0, "backup_poison_label_version");
        int r118 = CursorUtil.getColumnIndex(r0, "backup_content_hash");
        long r27 = 0;
        if (r1 != (-1)) goto L5;
        long r33 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r36 = null;
    L13:
        boolean r21 = false;
        if (r3 != (-1)) goto L16;
        int r37 = 0;
    L17:
        if (r4 != (-1)) goto L19;
        long r39 = 0;
    L20:
        if (r5 != (-1)) goto L23;
    L21:
        String r41 = null;
    L26:
        if (r6 != (-1)) goto L28;
        long r42 = 0;
    L29:
        if (r7 != (-1)) goto L31;
        long r44 = 0;
    L32:
        if (r8 != (-1)) goto L34;
        int r46 = 0;
    L35:
        if (r9 != (-1)) goto L38;
    L36:
        String r47 = null;
    L41:
        if (r10 != (-1)) goto L43;
        int r48 = 0;
    L44:
        if (r11 != (-1)) goto L47;
    L45:
        String r49 = null;
    L50:
        if (r12 != (-1)) goto L52;
        long r50 = 0;
    L53:
        if (r13 == (-1)) goto L56;
        r27 = r0.getLong(r13);
    L56:
        long r52 = r27;
        if (r14 != (-1)) goto L60;
    L58:
        String r54 = null;
    L63:
        if (r66 != (-1)) goto L66;
    L64:
        String r55 = null;
    L69:
        if (r67 != (-1)) goto L73;
    L70:
        String r56 = null;
    L76:
        if (r17 != (-1)) goto L80;
    L77:
        String r57 = null;
    L83:
        if (r18 != (-1)) goto L87;
    L84:
        String r58 = null;
    L90:
        if (r19 != (-1)) goto L92;
        int r59 = 0;
    L94:
        if (r110 != (-1)) goto L98;
    L95:
        String r60 = null;
    L101:
        if (r111 != (-1)) goto L105;
    L102:
        String r61 = null;
    L108:
        if (r112 != (-1)) goto L112;
    L109:
        String r62 = null;
    L115:
        if (r113 != (-1)) goto L119;
    L116:
        String r63 = null;
    L122:
        if (r114 != (-1)) goto L126;
    L123:
        String r64 = null;
    L129:
        if (r115 != (-1)) goto L132;
    L134:
        AutoMemoryProEntityOld r22 = new AutoMemoryProEntityOld(r39, r41, r42, r44, r46, r47, r48, r49, r50, r52, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r21);
        if (r116 == (-1)) goto L142;
        if (r0.isNull(r116) == false) goto L139;
        Integer r23 = null;
    L140:
        r22.setPoisonLabel(r23);
        goto L142
    L139:
        r23 = Integer.valueOf(r0.getInt(r116));
    L142:
        if (r117 == (-1)) goto L149;
        if (r0.isNull(r117) == false) goto L146;
        Integer r24 = null;
    L147:
        r22.setPoisonLabelVersion(r24);
        goto L149
    L146:
        r24 = Integer.valueOf(r0.getInt(r117));
    L149:
        if (r118 == (-1)) goto L156;
        if (r0.isNull(r118) == true) goto L154;
        r20 = r0.getString(r118);
    L154:
        r22.setContentHash(r20);
    L156:
        return new com.obric.memorydata.database.legacy.backup.a.c(r33, r22, r36, r37);
    L132:
        if (r0.getInt(r115) == 0) goto L134;
        r21 = true;
        goto L134
    L126:
        if (r0.isNull(r114) == true) goto L123;
        r64 = r0.getString(r114);
        goto L129
    L119:
        if (r0.isNull(r113) == true) goto L116;
        r63 = r0.getString(r113);
        goto L122
    L112:
        if (r0.isNull(r112) == true) goto L109;
        r62 = r0.getString(r112);
        goto L115
    L105:
        if (r0.isNull(r111) == true) goto L102;
        r61 = r0.getString(r111);
        goto L108
    L98:
        if (r0.isNull(r110) == true) goto L95;
        r60 = r0.getString(r110);
        goto L101
    L92:
        r59 = r0.getInt(r19);
        goto L94
    L87:
        if (r0.isNull(r18) == true) goto L84;
        r58 = r0.getString(r18);
        goto L90
    L80:
        if (r0.isNull(r17) == true) goto L77;
        r57 = r0.getString(r17);
        goto L83
    L73:
        if (r0.isNull(r67) == true) goto L70;
        r56 = r0.getString(r16);
        goto L76
    L66:
        if (r0.isNull(r66) == true) goto L64;
        r55 = r0.getString(r15);
        goto L69
    L60:
        if (r0.isNull(r14) == true) goto L58;
        r54 = r0.getString(r14);
        goto L63
    L52:
        r50 = r0.getLong(r12);
        goto L53
    L47:
        if (r0.isNull(r11) == true) goto L45;
        r49 = r0.getString(r11);
        goto L50
    L43:
        r48 = r0.getInt(r10);
        goto L44
    L38:
        if (r0.isNull(r9) == true) goto L36;
        r47 = r0.getString(r9);
        goto L41
    L34:
        r46 = r0.getInt(r8);
        goto L35
    L31:
        r44 = r0.getLong(r7);
        goto L32
    L28:
        r42 = r0.getLong(r6);
        goto L29
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r41 = r0.getString(r5);
        goto L26
    L19:
        r39 = r0.getLong(r4);
        goto L20
    L16:
        r37 = r0.getInt(r3);
        goto L17
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r36 = r0.getString(r2);
        goto L13
    L5:
        r33 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.backup.a.c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBackUpAutoMemoryProEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.backup.a.c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBackUpAutoMemoryProEntityOld_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(com.obric.memorydata.database.legacy.backup.a.c r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBackUpAutoMemoryProEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((com.obric.memorydata.database.legacy.backup.a.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return c.a.d(this);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public int deleteByBackupUserId(String r1) {
        return c.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return c.a.a(this);
    }

    public long insert(com.obric.memorydata.database.legacy.backup.a.c r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBackUpAutoMemoryProEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((com.obric.memorydata.database.legacy.backup.a.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.backup.a.c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBackUpAutoMemoryProEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.c> queryAll() {
        return c.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return c.a.c(this);
    }

    public List<com.obric.memorydata.database.legacy.backup.a.c> queryByBackupUserId(String r1) {
        return c.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public List<com.obric.memorydata.database.legacy.backup.a.c> queryByBackupUserId(String r1, int r2, int r3) {
        return c.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.c queryById(long r1) {
        return c.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.c> queryByIds(List<Long> r3) {
        return c.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.c queryByUUID(String r1) {
        return c.a.c(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.c queryOne() {
        return c.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.c> queryWithLimitAndOffset(int r1, int r2) {
        return c.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.c> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpAutoMemoryProEntityOld(r6));     // Catch: Throwable -> L10
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

    public int update(com.obric.memorydata.database.legacy.backup.a.c r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBackUpAutoMemoryProEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((com.obric.memorydata.database.legacy.backup.a.c) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.c.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.backup.a.c> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBackUpAutoMemoryProEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
