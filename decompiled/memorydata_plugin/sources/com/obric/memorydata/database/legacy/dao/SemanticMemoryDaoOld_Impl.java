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
public final class SemanticMemoryDaoOld_Impl implements ap {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.ac> __deletionAdapterOfUnionSemanticMemoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.entity.ac> __insertionAdapterOfUnionSemanticMemoryEntityOld;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.ac> __updateAdapterOfUnionSemanticMemoryEntityOld;

    public SemanticMemoryDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfUnionSemanticMemoryEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfUnionSemanticMemoryEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfUnionSemanticMemoryEntityOld = new AnonymousClass3(this, r2);
    }

    private com.obric.memorydata.database.legacy.entity.ac __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityUnionSemanticMemoryEntityOld(Cursor r67) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r67, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r10 = CursorUtil.getColumnIndex(r0, "semantic_type");
        int r11 = CursorUtil.getColumnIndex(r0, "tag_path");
        int r12 = CursorUtil.getColumnIndex(r0, "key_phrase");
        int r13 = CursorUtil.getColumnIndex(r0, "description");
        int r14 = CursorUtil.getColumnIndex(r0, "embedding_content");
        int r15 = CursorUtil.getColumnIndex(r0, "sources");
        int r16 = CursorUtil.getColumnIndex(r0, "user_edit");
        int r17 = CursorUtil.getColumnIndex(r0, "evidence_count");
        int r18 = CursorUtil.getColumnIndex(r0, "product_type");
        int r19 = CursorUtil.getColumnIndex(r0, "use_for_insight");
        int r110 = CursorUtil.getColumnIndex(r0, "use_for_persona");
        int r111 = CursorUtil.getColumnIndex(r0, "confidence");
        int r112 = CursorUtil.getColumnIndex(r0, "logId");
        int r113 = CursorUtil.getColumnIndex(r0, "important_raw_ref_ids");
        int r114 = CursorUtil.getColumnIndex(r0, "source_raw_ref_ids");
        int r115 = CursorUtil.getColumnIndex(r0, "scene_ids");
        int r116 = CursorUtil.getColumnIndex(r0, "sourcePackageName");
        int r117 = CursorUtil.getColumnIndex(r0, "personalDbSplitMigrated");
        int r118 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r119 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r120 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r29 = 0;
        if (r1 != (-1)) goto L5;
        long r35 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r37 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r38 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r40 = 0;
    L19:
        boolean r21 = false;
        if (r5 != (-1)) goto L22;
        int r42 = 0;
    L23:
        if (r6 == (-1)) goto L26;
        r29 = r0.getLong(r6);
    L26:
        long r43 = r29;
        if (r7 != (-1)) goto L30;
    L28:
        String r45 = null;
    L33:
        if (r8 != (-1)) goto L35;
        int r46 = 0;
    L36:
        if (r9 != (-1)) goto L39;
    L37:
        String r47 = null;
    L42:
        if (r10 != (-1)) goto L45;
    L43:
        String r48 = null;
    L48:
        if (r11 != (-1)) goto L51;
    L49:
        String r49 = null;
    L54:
        if (r12 != (-1)) goto L57;
    L55:
        String r50 = null;
    L60:
        if (r13 != (-1)) goto L63;
    L61:
        String r51 = null;
    L66:
        if (r14 != (-1)) goto L69;
    L67:
        String r52 = null;
    L72:
        if (r66 != (-1)) goto L75;
    L73:
        String r53 = null;
    L79:
        if (r16 != (-1)) goto L83;
        boolean r54 = false;
    L87:
        if (r17 != (-1)) goto L89;
        int r55 = 0;
    L91:
        if (r18 != (-1)) goto L93;
        int r56 = 0;
    L95:
        if (r19 != (-1)) goto L99;
        boolean r57 = false;
    L103:
        if (r110 != (-1)) goto L107;
        boolean r58 = false;
    L111:
        if (r111 != (-1)) goto L113;
        float r22 = 0.0f;
    L114:
        float r59 = r22;
        if (r112 != (-1)) goto L119;
    L116:
        String r60 = null;
    L122:
        if (r113 != (-1)) goto L126;
    L123:
        String r61 = null;
    L129:
        if (r114 != (-1)) goto L133;
    L130:
        String r62 = null;
    L136:
        if (r115 != (-1)) goto L140;
    L137:
        String r63 = null;
    L143:
        if (r116 != (-1)) goto L147;
    L144:
        String r64 = null;
    L150:
        if (r117 != (-1)) goto L153;
    L155:
        com.obric.memorydata.database.legacy.entity.ac r23 = new com.obric.memorydata.database.legacy.entity.ac(r35, r37, r38, r40, r42, r43, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r21);
        if (r118 == (-1)) goto L163;
        if (r0.isNull(r118) == false) goto L160;
        Integer r24 = null;
    L161:
        r23.setPoisonLabel(r24);
        goto L163
    L160:
        r24 = Integer.valueOf(r0.getInt(r118));
    L163:
        if (r119 == (-1)) goto L170;
        if (r0.isNull(r119) == false) goto L167;
        Integer r25 = null;
    L168:
        r23.setPoisonLabelVersion(r25);
        goto L170
    L167:
        r25 = Integer.valueOf(r0.getInt(r119));
    L170:
        if (r120 != (-1)) goto L172;
    L176:
        return r23;
    L172:
        if (r0.isNull(r120) == true) goto L175;
        r20 = r0.getString(r120);
    L175:
        r23.setContentHash(r20);
        goto L176
    L153:
        if (r0.getInt(r117) == 0) goto L155;
        r21 = true;
        goto L155
    L147:
        if (r0.isNull(r116) == true) goto L144;
        r64 = r0.getString(r116);
        goto L150
    L140:
        if (r0.isNull(r115) == true) goto L137;
        r63 = r0.getString(r115);
        goto L143
    L133:
        if (r0.isNull(r114) == true) goto L130;
        r62 = r0.getString(r114);
        goto L136
    L126:
        if (r0.isNull(r113) == true) goto L123;
        r61 = r0.getString(r113);
        goto L129
    L119:
        if (r0.isNull(r112) == true) goto L116;
        r60 = r0.getString(r112);
        goto L122
    L113:
        r22 = r0.getFloat(r111);
        goto L114
    L107:
        if (r0.getInt(r110) == 0) goto L109;
        boolean r26 = true;
    L110:
        r58 = r26;
        goto L111
    L109:
        r26 = false;
        goto L110
    L99:
        if (r0.getInt(r19) == 0) goto L101;
        boolean r27 = true;
    L102:
        r57 = r27;
        goto L103
    L101:
        r27 = false;
        goto L102
    L93:
        r56 = r0.getInt(r18);
        goto L95
    L89:
        r55 = r0.getInt(r17);
        goto L91
    L83:
        if (r0.getInt(r16) == 0) goto L85;
        boolean r28 = true;
    L86:
        r54 = r28;
        goto L87
    L85:
        r28 = false;
        goto L86
    L75:
        if (r0.isNull(r66) == true) goto L73;
        r53 = r0.getString(r15);
        goto L79
    L69:
        if (r0.isNull(r14) == true) goto L67;
        r52 = r0.getString(r14);
        goto L72
    L63:
        if (r0.isNull(r13) == true) goto L61;
        r51 = r0.getString(r13);
        goto L66
    L57:
        if (r0.isNull(r12) == true) goto L55;
        r50 = r0.getString(r12);
        goto L60
    L51:
        if (r0.isNull(r11) == true) goto L49;
        r49 = r0.getString(r11);
        goto L54
    L45:
        if (r0.isNull(r10) == true) goto L43;
        r48 = r0.getString(r10);
        goto L48
    L39:
        if (r0.isNull(r9) == true) goto L37;
        r47 = r0.getString(r9);
        goto L42
    L35:
        r46 = r0.getInt(r8);
        goto L36
    L30:
        if (r0.isNull(r7) == true) goto L28;
        r45 = r0.getString(r7);
        goto L33
    L22:
        r42 = r0.getInt(r5);
        goto L23
    L18:
        r40 = r0.getLong(r4);
        goto L19
    L15:
        r38 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r37 = r0.getString(r2);
        goto L13
    L5:
        r35 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.entity.ac> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfUnionSemanticMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.entity.ac> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUnionSemanticMemoryEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.memorydata.database.legacy.entity.ac r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfUnionSemanticMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.memorydata.database.legacy.entity.ac r3) {
        return delete2((com.obric.memorydata.database.legacy.entity.ac) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.ac.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ap.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ap.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.memorydata.database.legacy.entity.ac r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUnionSemanticMemoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.memorydata.database.legacy.entity.ac r3) {
        return insert2((com.obric.memorydata.database.legacy.entity.ac) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.ac.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.entity.ac> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfUnionSemanticMemoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.ac> queryAll() {
        return ap.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ap.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.ac queryById(long r1) {
        return ap.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.ac queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.ac> queryByIds(List<Long> r3) {
        return ap.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.ac queryByUUID(String r1) {
        return ap.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.ac queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.ac queryOne() {
        return ap.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.ac queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.ac> queryWithLimitAndOffset(int r1, int r2) {
        return ap.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.ac> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityUnionSemanticMemoryEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.memorydata.database.legacy.entity.ac r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfUnionSemanticMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.memorydata.database.legacy.entity.ac r3) {
        return update2((com.obric.memorydata.database.legacy.entity.ac) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.ac.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.entity.ac> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfUnionSemanticMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
