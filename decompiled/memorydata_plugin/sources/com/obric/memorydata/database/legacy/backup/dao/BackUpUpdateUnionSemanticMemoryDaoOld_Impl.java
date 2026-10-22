package com.obric.memorydata.database.legacy.backup.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.legacy.entity.aj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class BackUpUpdateUnionSemanticMemoryDaoOld_Impl implements w {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.w> __deletionAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.w> __insertionAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.w> __insertionAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld_1;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.w> __updateAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld;

    public BackUpUpdateUnionSemanticMemoryDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld = new AnonymousClass3(this, r2);
        this.__updateAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld = new AnonymousClass4(this, r2);
    }

    private com.obric.memorydata.database.legacy.backup.a.w __entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpUpdateUnionSemanticMemoryEntityOld(Cursor r70) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r70, Cursor.class, "com.obric.memorydata.plugin");
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
        int r13 = CursorUtil.getColumnIndex(r0, "backup_semantic_type");
        int r14 = CursorUtil.getColumnIndex(r0, "backup_tag_path");
        int r15 = CursorUtil.getColumnIndex(r0, "backup_key_phrase");
        int r16 = CursorUtil.getColumnIndex(r0, "backup_description");
        int r17 = CursorUtil.getColumnIndex(r0, "backup_embedding_content");
        int r18 = CursorUtil.getColumnIndex(r0, "backup_sources");
        int r19 = CursorUtil.getColumnIndex(r0, "backup_user_edit");
        int r110 = CursorUtil.getColumnIndex(r0, "backup_evidence_count");
        int r111 = CursorUtil.getColumnIndex(r0, "backup_product_type");
        int r112 = CursorUtil.getColumnIndex(r0, "backup_use_for_insight");
        int r113 = CursorUtil.getColumnIndex(r0, "backup_confidence");
        int r114 = CursorUtil.getColumnIndex(r0, "backup_updateResult");
        int r115 = CursorUtil.getColumnIndex(r0, "backup_isUpdated");
        int r116 = CursorUtil.getColumnIndex(r0, "backup_retryTime");
        int r117 = CursorUtil.getColumnIndex(r0, "backup_lastExecuteUpdateTimestamp");
        int r118 = CursorUtil.getColumnIndex(r0, "backup_personalDbSplitMigrated");
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
        if (r9 != (-1)) goto L37;
        long r47 = 0;
    L38:
        if (r10 != (-1)) goto L41;
    L39:
        String r49 = null;
    L44:
        if (r11 != (-1)) goto L46;
        int r50 = 0;
    L47:
        if (r12 != (-1)) goto L50;
    L48:
        String r51 = null;
    L53:
        if (r13 != (-1)) goto L56;
    L54:
        String r52 = null;
    L59:
        if (r14 != (-1)) goto L62;
    L60:
        String r53 = null;
    L65:
        if (r69 != (-1)) goto L68;
    L66:
        String r54 = null;
    L71:
        if (r70 != (-1)) goto L75;
    L72:
        String r55 = null;
    L78:
        if (r17 != (-1)) goto L82;
    L79:
        String r56 = null;
    L85:
        if (r18 != (-1)) goto L88;
    L86:
        String r57 = null;
    L92:
        if (r19 != (-1)) goto L96;
        boolean r58 = false;
    L100:
        if (r110 != (-1)) goto L102;
        int r59 = 0;
    L104:
        if (r111 != (-1)) goto L106;
        int r60 = 0;
    L108:
        if (r112 != (-1)) goto L112;
        boolean r61 = false;
    L116:
        if (r113 != (-1)) goto L118;
        float r22 = 0.0f;
    L119:
        float r62 = r22;
        if (r114 != (-1)) goto L123;
    L121:
        String r63 = r20;
        if (r115 != (-1)) goto L130;
        boolean r64 = false;
    L134:
        if (r116 != (-1)) goto L136;
        int r65 = 0;
    L138:
        if (r117 == (-1)) goto L141;
        r27 = r0.getLong(r117);
    L141:
        long r66 = r27;
        if (r118 != (-1)) goto L145;
    L148:
        return new com.obric.memorydata.database.legacy.backup.a.w(r33, new aj(r39, r41, r42, r44, r46, r47, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r21), r36, r37);
    L145:
        if (r0.getInt(r118) == 0) goto L148;
        r21 = true;
        goto L148
    L136:
        r65 = r0.getInt(r116);
        goto L138
    L130:
        if (r0.getInt(r115) == 0) goto L132;
        boolean r23 = true;
    L133:
        r64 = r23;
        goto L134
    L132:
        r23 = false;
        goto L133
    L123:
        if (r0.isNull(r114) == true) goto L121;
        r20 = r0.getString(r114);
        goto L121
    L118:
        r22 = r0.getFloat(r113);
        goto L119
    L112:
        if (r0.getInt(r112) == 0) goto L114;
        boolean r24 = true;
    L115:
        r61 = r24;
        goto L116
    L114:
        r24 = false;
        goto L115
    L106:
        r60 = r0.getInt(r111);
        goto L108
    L102:
        r59 = r0.getInt(r110);
        goto L104
    L96:
        if (r0.getInt(r19) == 0) goto L98;
        boolean r25 = true;
    L99:
        r58 = r25;
        goto L100
    L98:
        r25 = false;
        goto L99
    L88:
        if (r0.isNull(r18) == true) goto L86;
        r57 = r0.getString(r18);
        goto L92
    L82:
        if (r0.isNull(r17) == true) goto L79;
        r56 = r0.getString(r17);
        goto L85
    L75:
        if (r0.isNull(r70) == true) goto L72;
        r55 = r0.getString(r16);
        goto L78
    L68:
        if (r0.isNull(r69) == true) goto L66;
        r54 = r0.getString(r15);
        goto L71
    L62:
        if (r0.isNull(r14) == true) goto L60;
        r53 = r0.getString(r14);
        goto L65
    L56:
        if (r0.isNull(r13) == true) goto L54;
        r52 = r0.getString(r13);
        goto L59
    L50:
        if (r0.isNull(r12) == true) goto L48;
        r51 = r0.getString(r12);
        goto L53
    L46:
        r50 = r0.getInt(r11);
        goto L47
    L41:
        if (r0.isNull(r10) == true) goto L39;
        r49 = r0.getString(r10);
        goto L44
    L37:
        r47 = r0.getLong(r9);
        goto L38
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
    public void bulkDelete(List<com.obric.memorydata.database.legacy.backup.a.w> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.backup.a.w> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(com.obric.memorydata.database.legacy.backup.a.w r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((com.obric.memorydata.database.legacy.backup.a.w) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.w.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return w.a.d(this);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public int deleteByBackupUserId(String r1) {
        return w.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return w.a.a(this);
    }

    public long insert(com.obric.memorydata.database.legacy.backup.a.w r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((com.obric.memorydata.database.legacy.backup.a.w) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.w.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.backup.a.w> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.w> queryAll() {
        return w.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return w.a.c(this);
    }

    public List<com.obric.memorydata.database.legacy.backup.a.w> queryByBackupUserId(String r1) {
        return w.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public List<com.obric.memorydata.database.legacy.backup.a.w> queryByBackupUserId(String r1, int r2, int r3) {
        return w.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.w queryById(long r1) {
        return w.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.w> queryByIds(List<Long> r3) {
        return w.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.w queryByUUID(String r1) {
        return w.a.c(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.w queryOne() {
        return w.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.w> queryWithLimitAndOffset(int r1, int r2) {
        return w.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.w> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpUpdateUnionSemanticMemoryEntityOld(r6));     // Catch: Throwable -> L10
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

    public int update(com.obric.memorydata.database.legacy.backup.a.w r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((com.obric.memorydata.database.legacy.backup.a.w) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.w.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.backup.a.w> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBackUpUpdateUnionSemanticMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
