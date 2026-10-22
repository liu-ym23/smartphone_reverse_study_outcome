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
public final class UnionSemanticMemoryHistoryRawDbDaoOld_Impl implements au {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.ae> __deletionAdapterOfUnionSemanticMemoryHistoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.entity.ae> __insertionAdapterOfUnionSemanticMemoryHistoryEntityOld;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.ae> __updateAdapterOfUnionSemanticMemoryHistoryEntityOld;

    public UnionSemanticMemoryHistoryRawDbDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfUnionSemanticMemoryHistoryEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfUnionSemanticMemoryHistoryEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfUnionSemanticMemoryHistoryEntityOld = new AnonymousClass3(this, r2);
    }

    private com.obric.memorydata.database.legacy.entity.ae __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityUnionSemanticMemoryHistoryEntityOld(Cursor r70) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r70, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "semantic_id");
        int r3 = CursorUtil.getColumnIndex(r0, "semantic_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "semantic_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "semantic_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "semantic_type");
        int r7 = CursorUtil.getColumnIndex(r0, "semantic_timestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "semantic_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "semantic_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "semantic_uuid");
        int r11 = CursorUtil.getColumnIndex(r0, "semantic_semantic_type");
        int r12 = CursorUtil.getColumnIndex(r0, "semantic_tag_path");
        int r13 = CursorUtil.getColumnIndex(r0, "semantic_key_phrase");
        int r14 = CursorUtil.getColumnIndex(r0, "semantic_description");
        int r15 = CursorUtil.getColumnIndex(r0, "semantic_embedding_content");
        int r16 = CursorUtil.getColumnIndex(r0, "semantic_sources");
        int r17 = CursorUtil.getColumnIndex(r0, "semantic_user_edit");
        int r18 = CursorUtil.getColumnIndex(r0, "semantic_evidence_count");
        int r19 = CursorUtil.getColumnIndex(r0, "semantic_product_type");
        int r110 = CursorUtil.getColumnIndex(r0, "semantic_use_for_insight");
        int r111 = CursorUtil.getColumnIndex(r0, "semantic_use_for_persona");
        int r112 = CursorUtil.getColumnIndex(r0, "semantic_confidence");
        int r113 = CursorUtil.getColumnIndex(r0, "semantic_logId");
        int r114 = CursorUtil.getColumnIndex(r0, "semantic_important_raw_ref_ids");
        int r115 = CursorUtil.getColumnIndex(r0, "semantic_source_raw_ref_ids");
        int r116 = CursorUtil.getColumnIndex(r0, "semantic_scene_ids");
        int r117 = CursorUtil.getColumnIndex(r0, "semantic_sourcePackageName");
        int r118 = CursorUtil.getColumnIndex(r0, "semantic_personalDbSplitMigrated");
        int r119 = CursorUtil.getColumnIndex(r0, "semantic_poison_label");
        int r120 = CursorUtil.getColumnIndex(r0, "semantic_poison_label_version");
        int r121 = CursorUtil.getColumnIndex(r0, "semantic_content_hash");
        long r30 = 0;
        if (r1 != (-1)) goto L5;
        long r35 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r38 = 0;
    L9:
        String r20 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r40 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r41 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r43 = 0;
    L22:
        boolean r21 = false;
        if (r6 != (-1)) goto L25;
        int r45 = 0;
    L26:
        if (r7 == (-1)) goto L29;
        r30 = r0.getLong(r7);
    L29:
        long r46 = r30;
        if (r8 != (-1)) goto L33;
    L31:
        String r48 = null;
    L36:
        if (r9 != (-1)) goto L38;
        int r49 = 0;
    L39:
        if (r10 != (-1)) goto L42;
    L40:
        String r50 = null;
    L45:
        if (r11 != (-1)) goto L48;
    L46:
        String r51 = null;
    L51:
        if (r12 != (-1)) goto L54;
    L52:
        String r52 = null;
    L57:
        if (r13 != (-1)) goto L60;
    L58:
        String r53 = null;
    L63:
        if (r14 != (-1)) goto L66;
    L64:
        String r54 = null;
    L69:
        if (r69 != (-1)) goto L72;
    L70:
        String r55 = null;
    L75:
        if (r70 != (-1)) goto L78;
    L76:
        String r56 = null;
    L82:
        if (r17 != (-1)) goto L86;
        boolean r57 = false;
    L90:
        if (r18 != (-1)) goto L92;
        int r58 = 0;
    L94:
        if (r19 != (-1)) goto L96;
        int r59 = 0;
    L98:
        if (r110 != (-1)) goto L102;
        boolean r60 = false;
    L106:
        if (r111 != (-1)) goto L110;
        boolean r61 = false;
    L114:
        if (r112 != (-1)) goto L116;
        float r22 = 0.0f;
    L117:
        float r62 = r22;
        if (r113 != (-1)) goto L122;
    L119:
        String r63 = null;
    L125:
        if (r114 != (-1)) goto L129;
    L126:
        String r64 = null;
    L132:
        if (r115 != (-1)) goto L136;
    L133:
        String r65 = null;
    L139:
        if (r116 != (-1)) goto L143;
    L140:
        String r66 = null;
    L146:
        if (r117 != (-1)) goto L150;
    L147:
        String r67 = null;
    L153:
        if (r118 != (-1)) goto L156;
    L158:
        com.obric.memorydata.database.legacy.entity.ac r23 = new com.obric.memorydata.database.legacy.entity.ac(r38, r40, r41, r43, r45, r46, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r21);
        if (r119 == (-1)) goto L166;
        if (r0.isNull(r119) == false) goto L163;
        Integer r24 = null;
    L164:
        r23.setPoisonLabel(r24);
        goto L166
    L163:
        r24 = Integer.valueOf(r0.getInt(r119));
    L166:
        if (r120 == (-1)) goto L173;
        if (r0.isNull(r120) == false) goto L170;
        Integer r25 = null;
    L171:
        r23.setPoisonLabelVersion(r25);
        goto L173
    L170:
        r25 = Integer.valueOf(r0.getInt(r120));
    L173:
        if (r121 == (-1)) goto L180;
        if (r0.isNull(r121) == true) goto L178;
        r20 = r0.getString(r121);
    L178:
        r23.setContentHash(r20);
    L180:
        return new com.obric.memorydata.database.legacy.entity.ae(r35, r23);
    L156:
        if (r0.getInt(r118) == 0) goto L158;
        r21 = true;
        goto L158
    L150:
        if (r0.isNull(r117) == true) goto L147;
        r67 = r0.getString(r117);
        goto L153
    L143:
        if (r0.isNull(r116) == true) goto L140;
        r66 = r0.getString(r116);
        goto L146
    L136:
        if (r0.isNull(r115) == true) goto L133;
        r65 = r0.getString(r115);
        goto L139
    L129:
        if (r0.isNull(r114) == true) goto L126;
        r64 = r0.getString(r114);
        goto L132
    L122:
        if (r0.isNull(r113) == true) goto L119;
        r63 = r0.getString(r113);
        goto L125
    L116:
        r22 = r0.getFloat(r112);
        goto L117
    L110:
        if (r0.getInt(r111) == 0) goto L112;
        boolean r26 = true;
    L113:
        r61 = r26;
        goto L114
    L112:
        r26 = false;
        goto L113
    L102:
        if (r0.getInt(r110) == 0) goto L104;
        boolean r27 = true;
    L105:
        r60 = r27;
        goto L106
    L104:
        r27 = false;
        goto L105
    L96:
        r59 = r0.getInt(r19);
        goto L98
    L92:
        r58 = r0.getInt(r18);
        goto L94
    L86:
        if (r0.getInt(r17) == 0) goto L88;
        boolean r28 = true;
    L89:
        r57 = r28;
        goto L90
    L88:
        r28 = false;
        goto L89
    L78:
        if (r0.isNull(r70) == true) goto L76;
        r56 = r0.getString(r16);
        goto L82
    L72:
        if (r0.isNull(r69) == true) goto L70;
        r55 = r0.getString(r15);
        goto L75
    L66:
        if (r0.isNull(r14) == true) goto L64;
        r54 = r0.getString(r14);
        goto L69
    L60:
        if (r0.isNull(r13) == true) goto L58;
        r53 = r0.getString(r13);
        goto L63
    L54:
        if (r0.isNull(r12) == true) goto L52;
        r52 = r0.getString(r12);
        goto L57
    L48:
        if (r0.isNull(r11) == true) goto L46;
        r51 = r0.getString(r11);
        goto L51
    L42:
        if (r0.isNull(r10) == true) goto L40;
        r50 = r0.getString(r10);
        goto L45
    L38:
        r49 = r0.getInt(r9);
        goto L39
    L33:
        if (r0.isNull(r8) == true) goto L31;
        r48 = r0.getString(r8);
        goto L36
    L25:
        r45 = r0.getInt(r6);
        goto L26
    L21:
        r43 = r0.getLong(r5);
        goto L22
    L18:
        r41 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r40 = r0.getString(r3);
        goto L16
    L8:
        r38 = r0.getLong(r2);
        goto L9
    L5:
        r35 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.entity.ae> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfUnionSemanticMemoryHistoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.entity.ae> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUnionSemanticMemoryHistoryEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.memorydata.database.legacy.entity.ae r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfUnionSemanticMemoryHistoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.memorydata.database.legacy.entity.ae r3) {
        return delete2((com.obric.memorydata.database.legacy.entity.ae) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.ae.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return au.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return au.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.memorydata.database.legacy.entity.ae r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUnionSemanticMemoryHistoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.memorydata.database.legacy.entity.ae r3) {
        return insert2((com.obric.memorydata.database.legacy.entity.ae) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.ae.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.entity.ae> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfUnionSemanticMemoryHistoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.ae> queryAll() {
        return au.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return au.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.ae queryById(long r1) {
        return au.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.ae queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.ae> queryByIds(List<Long> r3) {
        return au.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.ae queryByUUID(String r1) {
        return au.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.ae queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.ae queryOne() {
        return au.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.ae queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.ae> queryWithLimitAndOffset(int r1, int r2) {
        return au.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.ae> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityUnionSemanticMemoryHistoryEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.memorydata.database.legacy.entity.ae r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfUnionSemanticMemoryHistoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.memorydata.database.legacy.entity.ae r3) {
        return update2((com.obric.memorydata.database.legacy.entity.ae) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.ae.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.entity.ae> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfUnionSemanticMemoryHistoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
