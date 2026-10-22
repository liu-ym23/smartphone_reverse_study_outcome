package com.obric.memorydata.database.legacy.backup.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.legacy.entity.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class BackUpUnionSemanticMemoryDaoOld_Impl implements u {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.u> __deletionAdapterOfBackUpUnionSemanticMemoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.u> __insertionAdapterOfBackUpUnionSemanticMemoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.u> __insertionAdapterOfBackUpUnionSemanticMemoryEntityOld_1;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.u> __updateAdapterOfBackUpUnionSemanticMemoryEntityOld;

    public BackUpUnionSemanticMemoryDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBackUpUnionSemanticMemoryEntityOld = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfBackUpUnionSemanticMemoryEntityOld_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfBackUpUnionSemanticMemoryEntityOld = new AnonymousClass3(this, r2);
        this.__updateAdapterOfBackUpUnionSemanticMemoryEntityOld = new AnonymousClass4(this, r2);
    }

    private com.obric.memorydata.database.legacy.backup.a.u __entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpUnionSemanticMemoryEntityOld(Cursor r76) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r76, Cursor.class, "com.obric.memorydata.plugin");
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
        int r113 = CursorUtil.getColumnIndex(r0, "backup_use_for_persona");
        int r114 = CursorUtil.getColumnIndex(r0, "backup_confidence");
        int r115 = CursorUtil.getColumnIndex(r0, "backup_logId");
        int r116 = CursorUtil.getColumnIndex(r0, "backup_important_raw_ref_ids");
        int r117 = CursorUtil.getColumnIndex(r0, "backup_source_raw_ref_ids");
        int r118 = CursorUtil.getColumnIndex(r0, "backup_scene_ids");
        int r119 = CursorUtil.getColumnIndex(r0, "backup_sourcePackageName");
        int r120 = CursorUtil.getColumnIndex(r0, "backup_personalDbSplitMigrated");
        int r121 = CursorUtil.getColumnIndex(r0, "backup_poison_label");
        int r122 = CursorUtil.getColumnIndex(r0, "backup_poison_label_version");
        int r123 = CursorUtil.getColumnIndex(r0, "backup_content_hash");
        long r32 = 0;
        if (r1 != (-1)) goto L5;
        long r38 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r41 = null;
    L13:
        boolean r21 = false;
        if (r3 != (-1)) goto L16;
        int r42 = 0;
    L17:
        if (r4 != (-1)) goto L19;
        long r44 = 0;
    L20:
        if (r5 != (-1)) goto L23;
    L21:
        String r46 = null;
    L26:
        if (r6 != (-1)) goto L28;
        long r47 = 0;
    L29:
        if (r7 != (-1)) goto L31;
        long r49 = 0;
    L32:
        if (r8 != (-1)) goto L34;
        int r51 = 0;
    L35:
        if (r9 == (-1)) goto L38;
        r32 = r0.getLong(r9);
    L38:
        long r52 = r32;
        if (r10 != (-1)) goto L42;
    L40:
        String r54 = null;
    L45:
        if (r11 != (-1)) goto L47;
        int r55 = 0;
    L48:
        if (r12 != (-1)) goto L51;
    L49:
        String r56 = null;
    L54:
        if (r13 != (-1)) goto L57;
    L55:
        String r57 = null;
    L60:
        if (r14 != (-1)) goto L63;
    L61:
        String r58 = null;
    L66:
        if (r75 != (-1)) goto L69;
    L67:
        String r59 = null;
    L72:
        if (r76 != (-1)) goto L76;
    L73:
        String r60 = null;
    L79:
        if (r17 != (-1)) goto L83;
    L80:
        String r61 = null;
    L86:
        if (r18 != (-1)) goto L89;
    L87:
        String r62 = null;
    L93:
        if (r19 != (-1)) goto L97;
        boolean r63 = false;
    L101:
        if (r110 != (-1)) goto L103;
        int r64 = 0;
    L105:
        if (r111 != (-1)) goto L107;
        int r65 = 0;
    L109:
        if (r112 != (-1)) goto L113;
        boolean r66 = false;
    L117:
        if (r113 != (-1)) goto L121;
        boolean r67 = false;
    L125:
        if (r114 != (-1)) goto L127;
        float r22 = 0.0f;
    L128:
        float r68 = r22;
        if (r115 != (-1)) goto L133;
    L130:
        String r69 = null;
    L136:
        if (r116 != (-1)) goto L140;
    L137:
        String r70 = null;
    L143:
        if (r117 != (-1)) goto L147;
    L144:
        String r71 = null;
    L150:
        if (r118 != (-1)) goto L154;
    L151:
        String r72 = null;
    L157:
        if (r119 != (-1)) goto L161;
    L158:
        String r73 = null;
    L164:
        if (r120 != (-1)) goto L167;
    L169:
        ac r23 = new ac(r44, r46, r47, r49, r51, r52, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r21);
        if (r121 == (-1)) goto L177;
        if (r0.isNull(r121) == false) goto L174;
        Integer r24 = null;
    L175:
        r23.setPoisonLabel(r24);
        goto L177
    L174:
        r24 = Integer.valueOf(r0.getInt(r121));
    L177:
        if (r122 == (-1)) goto L184;
        if (r0.isNull(r122) == false) goto L181;
        Integer r25 = null;
    L182:
        r23.setPoisonLabelVersion(r25);
        goto L184
    L181:
        r25 = Integer.valueOf(r0.getInt(r122));
    L184:
        if (r123 == (-1)) goto L191;
        if (r0.isNull(r123) == true) goto L189;
        r20 = r0.getString(r123);
    L189:
        r23.setContentHash(r20);
    L191:
        return new com.obric.memorydata.database.legacy.backup.a.u(r38, r23, r41, r42);
    L167:
        if (r0.getInt(r120) == 0) goto L169;
        r21 = true;
        goto L169
    L161:
        if (r0.isNull(r119) == true) goto L158;
        r73 = r0.getString(r119);
        goto L164
    L154:
        if (r0.isNull(r118) == true) goto L151;
        r72 = r0.getString(r118);
        goto L157
    L147:
        if (r0.isNull(r117) == true) goto L144;
        r71 = r0.getString(r117);
        goto L150
    L140:
        if (r0.isNull(r116) == true) goto L137;
        r70 = r0.getString(r116);
        goto L143
    L133:
        if (r0.isNull(r115) == true) goto L130;
        r69 = r0.getString(r115);
        goto L136
    L127:
        r22 = r0.getFloat(r114);
        goto L128
    L121:
        if (r0.getInt(r113) == 0) goto L123;
        boolean r26 = true;
    L124:
        r67 = r26;
        goto L125
    L123:
        r26 = false;
        goto L124
    L113:
        if (r0.getInt(r112) == 0) goto L115;
        boolean r27 = true;
    L116:
        r66 = r27;
        goto L117
    L115:
        r27 = false;
        goto L116
    L107:
        r65 = r0.getInt(r111);
        goto L109
    L103:
        r64 = r0.getInt(r110);
        goto L105
    L97:
        if (r0.getInt(r19) == 0) goto L99;
        boolean r28 = true;
    L100:
        r63 = r28;
        goto L101
    L99:
        r28 = false;
        goto L100
    L89:
        if (r0.isNull(r18) == true) goto L87;
        r62 = r0.getString(r18);
        goto L93
    L83:
        if (r0.isNull(r17) == true) goto L80;
        r61 = r0.getString(r17);
        goto L86
    L76:
        if (r0.isNull(r76) == true) goto L73;
        r60 = r0.getString(r16);
        goto L79
    L69:
        if (r0.isNull(r75) == true) goto L67;
        r59 = r0.getString(r15);
        goto L72
    L63:
        if (r0.isNull(r14) == true) goto L61;
        r58 = r0.getString(r14);
        goto L66
    L57:
        if (r0.isNull(r13) == true) goto L55;
        r57 = r0.getString(r13);
        goto L60
    L51:
        if (r0.isNull(r12) == true) goto L49;
        r56 = r0.getString(r12);
        goto L54
    L47:
        r55 = r0.getInt(r11);
        goto L48
    L42:
        if (r0.isNull(r10) == true) goto L40;
        r54 = r0.getString(r10);
        goto L45
    L34:
        r51 = r0.getInt(r8);
        goto L35
    L31:
        r49 = r0.getLong(r7);
        goto L32
    L28:
        r47 = r0.getLong(r6);
        goto L29
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r46 = r0.getString(r5);
        goto L26
    L19:
        r44 = r0.getLong(r4);
        goto L20
    L16:
        r42 = r0.getInt(r3);
        goto L17
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r41 = r0.getString(r2);
        goto L13
    L5:
        r38 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.backup.a.u> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBackUpUnionSemanticMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.backup.a.u> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBackUpUnionSemanticMemoryEntityOld_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(com.obric.memorydata.database.legacy.backup.a.u r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBackUpUnionSemanticMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((com.obric.memorydata.database.legacy.backup.a.u) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.u.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return u.a.d(this);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public int deleteByBackupUserId(String r1) {
        return u.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return u.a.a(this);
    }

    public long insert(com.obric.memorydata.database.legacy.backup.a.u r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBackUpUnionSemanticMemoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((com.obric.memorydata.database.legacy.backup.a.u) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.u.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.backup.a.u> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBackUpUnionSemanticMemoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.u> queryAll() {
        return u.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return u.a.c(this);
    }

    public List<com.obric.memorydata.database.legacy.backup.a.u> queryByBackupUserId(String r1) {
        return u.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public List<com.obric.memorydata.database.legacy.backup.a.u> queryByBackupUserId(String r1, int r2, int r3) {
        return u.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.u queryById(long r1) {
        return u.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.u> queryByIds(List<Long> r3) {
        return u.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.u queryByUUID(String r1) {
        return u.a.c(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.u queryOne() {
        return u.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.u> queryWithLimitAndOffset(int r1, int r2) {
        return u.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.u> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpUnionSemanticMemoryEntityOld(r6));     // Catch: Throwable -> L10
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

    public int update(com.obric.memorydata.database.legacy.backup.a.u r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBackUpUnionSemanticMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((com.obric.memorydata.database.legacy.backup.a.u) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.u.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.backup.a.u> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBackUpUnionSemanticMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
