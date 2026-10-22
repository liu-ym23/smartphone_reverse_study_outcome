package com.obric.memorydata.database.entity;

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
public final class UnionSemanticMemoryHistoryRawDbDao_Impl implements it {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<is> __deletionAdapterOfUnionSemanticMemoryHistoryEntity;
    private final EntityInsertionAdapter<is> __insertionAdapterOfUnionSemanticMemoryHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<is> __updateAdapterOfUnionSemanticMemoryHistoryEntity;

    public UnionSemanticMemoryHistoryRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfUnionSemanticMemoryHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfUnionSemanticMemoryHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfUnionSemanticMemoryHistoryEntity = new AnonymousClass3(this, r2);
    }

    private is __entityCursorConverter_comObricMemorydataDatabaseEntityUnionSemanticMemoryHistoryEntity(Cursor r82) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r82, Cursor.class, "com.obric.memorydata.plugin");
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
        int r118 = CursorUtil.getColumnIndex(r0, "semantic_change_seq");
        int r119 = CursorUtil.getColumnIndex(r0, "semantic_confirmation_state");
        int r120 = CursorUtil.getColumnIndex(r0, "semantic_migration_version");
        int r121 = CursorUtil.getColumnIndex(r0, "semantic_evidence_ids");
        int r122 = CursorUtil.getColumnIndex(r0, "semantic_conflict_entity_ids");
        int r123 = CursorUtil.getColumnIndex(r0, "semantic_last_user_assert_at");
        int r124 = CursorUtil.getColumnIndex(r0, "semantic_poison_label");
        int r125 = CursorUtil.getColumnIndex(r0, "semantic_poison_label_version");
        int r126 = CursorUtil.getColumnIndex(r0, "semantic_content_hash");
        long r35 = 0;
        if (r1 != (-1)) goto L5;
        long r40 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r43 = 0;
    L9:
        String r20 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r45 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r46 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r48 = 0;
    L22:
        int r21 = 0;
        if (r6 != (-1)) goto L25;
        int r50 = 0;
    L26:
        if (r7 != (-1)) goto L28;
        long r51 = 0;
    L29:
        if (r8 != (-1)) goto L32;
    L30:
        String r53 = null;
    L35:
        if (r9 != (-1)) goto L37;
        int r54 = 0;
    L38:
        if (r10 != (-1)) goto L41;
    L39:
        String r55 = null;
    L44:
        if (r11 != (-1)) goto L47;
    L45:
        String r56 = null;
    L50:
        if (r12 != (-1)) goto L53;
    L51:
        String r57 = null;
    L56:
        if (r13 != (-1)) goto L59;
    L57:
        String r58 = null;
    L62:
        if (r14 != (-1)) goto L65;
    L63:
        String r59 = null;
    L68:
        if (r81 != (-1)) goto L71;
    L69:
        String r60 = null;
    L74:
        if (r82 != (-1)) goto L77;
    L75:
        String r61 = null;
    L80:
        boolean r22 = true;
        if (r17 != (-1)) goto L85;
        boolean r62 = false;
    L89:
        if (r18 != (-1)) goto L91;
        int r63 = 0;
    L93:
        if (r19 != (-1)) goto L95;
        int r64 = 0;
    L97:
        if (r110 != (-1)) goto L101;
        boolean r65 = false;
    L105:
        if (r111 != (-1)) goto L109;
        boolean r66 = false;
    L113:
        if (r112 != (-1)) goto L115;
        float r23 = 0.0f;
    L116:
        float r67 = r23;
        if (r113 != (-1)) goto L121;
    L118:
        String r68 = null;
    L124:
        if (r114 != (-1)) goto L128;
    L125:
        String r69 = null;
    L131:
        if (r115 != (-1)) goto L135;
    L132:
        String r70 = null;
    L138:
        if (r116 != (-1)) goto L142;
    L139:
        String r71 = null;
    L145:
        if (r117 != (-1)) goto L149;
    L146:
        String r72 = null;
    L152:
        if (r118 != (-1)) goto L154;
        long r73 = 0;
    L155:
        if (r28 != (-1)) goto L159;
    L156:
        String r75 = null;
    L162:
        if (r120 == (-1)) goto L165;
        r21 = r0.getInt(r120);
    L165:
        int r76 = r21;
        if (r121 != (-1)) goto L170;
    L167:
        String r77 = null;
    L173:
        if (r122 != (-1)) goto L177;
    L174:
        String r78 = null;
    L180:
        if (r123 == (-1)) goto L183;
        r35 = r0.getLong(r123);
    L183:
        ip r24 = new ip(r43, r45, r46, r48, r50, r51, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r75, r76, r77, r78, r35);
        if (r124 == (-1)) goto L191;
        if (r0.isNull(r124) == false) goto L188;
        Integer r25 = null;
    L189:
        r24.setPoisonLabel(r25);
        goto L191
    L188:
        r25 = Integer.valueOf(r0.getInt(r124));
    L191:
        if (r125 == (-1)) goto L198;
        if (r0.isNull(r125) == false) goto L195;
        Integer r26 = null;
    L196:
        r24.setPoisonLabelVersion(r26);
        goto L198
    L195:
        r26 = Integer.valueOf(r0.getInt(r125));
    L198:
        if (r126 == (-1)) goto L205;
        if (r0.isNull(r126) == true) goto L203;
        r20 = r0.getString(r126);
    L203:
        r24.setContentHash(r20);
    L205:
        return new is(r40, r24);
    L177:
        if (r0.isNull(r122) == true) goto L174;
        r78 = r0.getString(r122);
        goto L180
    L170:
        if (r0.isNull(r121) == true) goto L167;
        r77 = r0.getString(r121);
        goto L173
    L159:
        if (r0.isNull(r28) == true) goto L156;
        r75 = r0.getString(r119);
        goto L162
    L154:
        r73 = r0.getLong(r118);
        goto L155
    L149:
        if (r0.isNull(r117) == true) goto L146;
        r72 = r0.getString(r117);
        goto L152
    L142:
        if (r0.isNull(r116) == true) goto L139;
        r71 = r0.getString(r116);
        goto L145
    L135:
        if (r0.isNull(r115) == true) goto L132;
        r70 = r0.getString(r115);
        goto L138
    L128:
        if (r0.isNull(r114) == true) goto L125;
        r69 = r0.getString(r114);
        goto L131
    L121:
        if (r0.isNull(r113) == true) goto L118;
        r68 = r0.getString(r113);
        goto L124
    L115:
        r23 = r0.getFloat(r112);
        goto L116
    L109:
        if (r0.getInt(r111) != 0) goto L112;
        r22 = false;
    L112:
        r66 = r22;
        goto L113
    L101:
        if (r0.getInt(r110) == 0) goto L103;
        boolean r27 = true;
    L104:
        r65 = r27;
        goto L105
    L103:
        r27 = false;
        goto L104
    L95:
        r64 = r0.getInt(r19);
        goto L97
    L91:
        r63 = r0.getInt(r18);
        goto L93
    L85:
        if (r0.getInt(r17) == 0) goto L87;
        boolean r28 = true;
    L88:
        r62 = r28;
        goto L89
    L87:
        r28 = false;
        goto L88
    L77:
        if (r0.isNull(r82) == true) goto L75;
        r61 = r0.getString(r16);
        goto L80
    L71:
        if (r0.isNull(r81) == true) goto L69;
        r60 = r0.getString(r15);
        goto L74
    L65:
        if (r0.isNull(r14) == true) goto L63;
        r59 = r0.getString(r14);
        goto L68
    L59:
        if (r0.isNull(r13) == true) goto L57;
        r58 = r0.getString(r13);
        goto L62
    L53:
        if (r0.isNull(r12) == true) goto L51;
        r57 = r0.getString(r12);
        goto L56
    L47:
        if (r0.isNull(r11) == true) goto L45;
        r56 = r0.getString(r11);
        goto L50
    L41:
        if (r0.isNull(r10) == true) goto L39;
        r55 = r0.getString(r10);
        goto L44
    L37:
        r54 = r0.getInt(r9);
        goto L38
    L32:
        if (r0.isNull(r8) == true) goto L30;
        r53 = r0.getString(r8);
        goto L35
    L28:
        r51 = r0.getLong(r7);
        goto L29
    L25:
        r50 = r0.getInt(r6);
        goto L26
    L21:
        r48 = r0.getLong(r5);
        goto L22
    L18:
        r46 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r45 = r0.getString(r3);
        goto L16
    L8:
        r43 = r0.getLong(r2);
        goto L9
    L5:
        r40 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<is> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfUnionSemanticMemoryHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<is> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUnionSemanticMemoryHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(is r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfUnionSemanticMemoryHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((is) ZeusTransformUtils.preCheckCast(r3, is.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return it.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return it.a.b(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return it.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return it.a.b(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return it.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return it.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return it.a.a(this);
    }

    public long insert(is r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUnionSemanticMemoryHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((is) ZeusTransformUtils.preCheckCast(r3, is.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<is> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfUnionSemanticMemoryHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<is> queryAll() {
        return it.a.c(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return it.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<is> queryByEntityId(String r1, String r2) {
        return it.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<is> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return it.a.c(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public is queryById(long r1) {
        return it.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<is> queryByIds(List<Long> r3) {
        return it.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public is queryByUUID(String r1) {
        return it.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public is queryOne() {
        return it.a.f(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<is> queryWithLimitAndOffset(int r1, int r2) {
        return it.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<is> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityUnionSemanticMemoryHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(is r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfUnionSemanticMemoryHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((is) ZeusTransformUtils.preCheckCast(r3, is.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<is> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfUnionSemanticMemoryHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
