package com.obric.memorydata.database.legacy.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.legacy.entity.EpisodicMemoryEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EpisodicMemoryHistoryRawDbDaoOld_Impl implements r {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.i> __deletionAdapterOfEpisodicMemoryHistoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.entity.i> __insertionAdapterOfEpisodicMemoryHistoryEntityOld;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.i> __updateAdapterOfEpisodicMemoryHistoryEntityOld;

    public EpisodicMemoryHistoryRawDbDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfEpisodicMemoryHistoryEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfEpisodicMemoryHistoryEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfEpisodicMemoryHistoryEntityOld = new AnonymousClass3(this, r2);
    }

    private com.obric.memorydata.database.legacy.entity.i __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityEpisodicMemoryHistoryEntityOld(Cursor r92) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r92, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "episodic_memory_id");
        int r3 = CursorUtil.getColumnIndex(r0, "episodic_memory_actionTimestamp");
        int r4 = CursorUtil.getColumnIndex(r0, "episodic_memory_uid");
        int r5 = CursorUtil.getColumnIndex(r0, "episodic_memory_title");
        int r6 = CursorUtil.getColumnIndex(r0, "episodic_memory_content");
        int r7 = CursorUtil.getColumnIndex(r0, "episodic_memory_contentWithTime");
        int r8 = CursorUtil.getColumnIndex(r0, "episodic_memory_fullContent");
        int r9 = CursorUtil.getColumnIndex(r0, "episodic_memory_observation");
        int r10 = CursorUtil.getColumnIndex(r0, "episodic_memory_location");
        int r11 = CursorUtil.getColumnIndex(r0, "episodic_memory_appNames");
        int r12 = CursorUtil.getColumnIndex(r0, "episodic_memory_category");
        int r13 = CursorUtil.getColumnIndex(r0, "episodic_memory_profileType");
        int r14 = CursorUtil.getColumnIndex(r0, "episodic_memory_profileTag");
        int r15 = CursorUtil.getColumnIndex(r0, "episodic_memory_tagOther");
        int r16 = CursorUtil.getColumnIndex(r0, "episodic_memory_logId");
        int r17 = CursorUtil.getColumnIndex(r0, "episodic_memory_usedForPortrait");
        int r18 = CursorUtil.getColumnIndex(r0, "episodic_memory_useLocation");
        int r19 = CursorUtil.getColumnIndex(r0, "episodic_memory_useForUserKeyword");
        int r110 = CursorUtil.getColumnIndex(r0, "episodic_memory_startTimestamp");
        int r111 = CursorUtil.getColumnIndex(r0, "episodic_memory_endTimestamp");
        int r112 = CursorUtil.getColumnIndex(r0, "episodic_memory_useForTopic");
        int r113 = CursorUtil.getColumnIndex(r0, "episodic_memory_entityId");
        int r114 = CursorUtil.getColumnIndex(r0, "episodic_memory_createTime");
        int r115 = CursorUtil.getColumnIndex(r0, "episodic_memory_modifyTime");
        int r116 = CursorUtil.getColumnIndex(r0, "episodic_memory_type");
        int r117 = CursorUtil.getColumnIndex(r0, "episodic_memory_timestamp");
        int r118 = CursorUtil.getColumnIndex(r0, "episodic_memory_packageName");
        int r119 = CursorUtil.getColumnIndex(r0, "episodic_memory_hashCodeValue");
        int r120 = CursorUtil.getColumnIndex(r0, "episodic_memory_uuid");
        int r121 = CursorUtil.getColumnIndex(r0, "episodic_memory_userEdit");
        int r122 = CursorUtil.getColumnIndex(r0, "episodic_memory_productType");
        int r123 = CursorUtil.getColumnIndex(r0, "episodic_memory_important_raw_ref_ids");
        int r124 = CursorUtil.getColumnIndex(r0, "episodic_memory_source_raw_ref_ids");
        int r125 = CursorUtil.getColumnIndex(r0, "episodic_memory_scene_ids");
        int r126 = CursorUtil.getColumnIndex(r0, "episodic_memory_sourcePackageName");
        int r127 = CursorUtil.getColumnIndex(r0, "episodic_memory_personalDbSplitMigrated");
        int r128 = CursorUtil.getColumnIndex(r0, "episodic_memory_poison_label");
        int r129 = CursorUtil.getColumnIndex(r0, "episodic_memory_poison_label_version");
        int r130 = CursorUtil.getColumnIndex(r0, "episodic_memory_content_hash");
        long r39 = 0;
        if (r1 != (-1)) goto L5;
        long r44 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r47 = 0;
    L9:
        if (r3 != (-1)) goto L11;
        long r49 = 0;
    L12:
        if (r4 != (-1)) goto L14;
        long r51 = 0;
    L15:
        String r20 = null;
        if (r5 != (-1)) goto L19;
    L17:
        String r53 = null;
    L22:
        if (r6 != (-1)) goto L25;
    L23:
        String r54 = null;
    L28:
        if (r7 != (-1)) goto L31;
    L29:
        String r55 = null;
    L34:
        if (r8 != (-1)) goto L37;
    L35:
        String r56 = null;
    L40:
        if (r9 != (-1)) goto L43;
    L41:
        String r57 = null;
    L46:
        if (r10 != (-1)) goto L49;
    L47:
        String r58 = null;
    L52:
        if (r11 != (-1)) goto L55;
    L53:
        String r59 = null;
    L58:
        if (r12 != (-1)) goto L61;
    L59:
        Integer r60 = null;
    L64:
        if (r13 != (-1)) goto L67;
    L65:
        Integer r61 = null;
    L70:
        if (r14 != (-1)) goto L73;
    L71:
        String r62 = null;
    L76:
        if (r91 != (-1)) goto L79;
    L77:
        String r63 = null;
    L82:
        if (r92 != (-1)) goto L85;
    L83:
        String r64 = null;
    L88:
        boolean r21 = true;
        if (r17 != (-1)) goto L93;
        Boolean r65 = null;
    L104:
        if (r18 != (-1)) goto L108;
        Boolean r66 = null;
    L119:
        if (r19 != (-1)) goto L123;
        boolean r67 = false;
    L127:
        if (r110 != (-1)) goto L129;
        long r68 = 0;
    L130:
        if (r20 != (-1)) goto L132;
        long r70 = 0;
    L133:
        if (r21 != (-1)) goto L137;
        Boolean r72 = null;
    L148:
        if (r113 != (-1)) goto L152;
    L149:
        String r73 = null;
    L155:
        if (r114 != (-1)) goto L157;
        long r74 = 0;
    L158:
        if (r24 != (-1)) goto L160;
        long r76 = 0;
    L161:
        if (r25 != (-1)) goto L163;
        int r78 = 0;
    L165:
        if (r117 == (-1)) goto L168;
        r39 = r0.getLong(r117);
    L168:
        long r79 = r39;
        if (r118 != (-1)) goto L173;
    L170:
        String r81 = null;
    L176:
        if (r119 != (-1)) goto L178;
        int r82 = 0;
    L180:
        if (r120 != (-1)) goto L184;
    L181:
        String r83 = null;
    L187:
        if (r121 != (-1)) goto L191;
        Boolean r84 = null;
    L202:
        if (r122 != (-1)) goto L204;
        int r85 = 0;
    L206:
        if (r123 != (-1)) goto L210;
    L207:
        String r86 = null;
    L213:
        if (r124 != (-1)) goto L217;
    L214:
        String r87 = null;
    L220:
        if (r125 != (-1)) goto L224;
    L221:
        String r88 = null;
    L227:
        if (r126 != (-1)) goto L231;
    L228:
        String r89 = null;
    L234:
        if (r127 != (-1)) goto L237;
        boolean r90 = false;
    L241:
        EpisodicMemoryEntityOld r22 = new EpisodicMemoryEntityOld(r47, r49, r51, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r70, r72, r73, r74, r76, r78, r79, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90);
        if (r128 == (-1)) goto L249;
        if (r0.isNull(r128) == false) goto L246;
        Integer r23 = null;
    L247:
        r22.setPoisonLabel(r23);
        goto L249
    L246:
        r23 = Integer.valueOf(r0.getInt(r128));
    L249:
        if (r129 == (-1)) goto L256;
        if (r0.isNull(r129) == false) goto L253;
        Integer r24 = null;
    L254:
        r22.setPoisonLabelVersion(r24);
        goto L256
    L253:
        r24 = Integer.valueOf(r0.getInt(r129));
    L256:
        if (r130 == (-1)) goto L263;
        if (r0.isNull(r130) == true) goto L261;
        r20 = r0.getString(r130);
    L261:
        r22.setContentHash(r20);
    L263:
        return new com.obric.memorydata.database.legacy.entity.i(r44, r22);
    L237:
        if (r0.getInt(r127) != 0) goto L240;
        r21 = false;
    L240:
        r90 = r21;
        goto L241
    L231:
        if (r0.isNull(r126) == true) goto L228;
        r89 = r0.getString(r126);
        goto L234
    L224:
        if (r0.isNull(r125) == true) goto L221;
        r88 = r0.getString(r125);
        goto L227
    L217:
        if (r0.isNull(r124) == true) goto L214;
        r87 = r0.getString(r124);
        goto L220
    L210:
        if (r0.isNull(r123) == true) goto L207;
        r86 = r0.getString(r123);
        goto L213
    L204:
        r85 = r0.getInt(r122);
        goto L206
    L191:
        if (r0.isNull(r121) == false) goto L193;
        Integer r25 = null;
    L194:
        if (r25 != null) goto L197;
        Boolean r26 = null;
    L201:
        r84 = r26;
        goto L202
    L197:
        if (r25.intValue() == 0) goto L199;
        boolean r27 = true;
    L200:
        r26 = Boolean.valueOf(r27);
        goto L201
    L199:
        r27 = false;
        goto L200
    L193:
        r25 = Integer.valueOf(r0.getInt(r121));
        goto L194
    L184:
        if (r0.isNull(r120) == true) goto L181;
        r83 = r0.getString(r120);
        goto L187
    L178:
        r82 = r0.getInt(r119);
        goto L180
    L173:
        if (r0.isNull(r118) == true) goto L170;
        r81 = r0.getString(r118);
        goto L176
    L163:
        r78 = r0.getInt(r116);
        goto L165
    L160:
        r76 = r0.getLong(r115);
        goto L161
    L157:
        r74 = r0.getLong(r114);
        goto L158
    L152:
        if (r0.isNull(r113) == true) goto L149;
        r73 = r0.getString(r113);
        goto L155
    L137:
        if (r0.isNull(r21) == false) goto L139;
        Integer r28 = null;
    L140:
        if (r28 != null) goto L143;
        Boolean r29 = null;
    L147:
        r72 = r29;
        goto L148
    L143:
        if (r28.intValue() == 0) goto L145;
        boolean r30 = true;
    L146:
        r29 = Boolean.valueOf(r30);
        goto L147
    L145:
        r30 = false;
        goto L146
    L139:
        r28 = Integer.valueOf(r0.getInt(r112));
        goto L140
    L132:
        r70 = r0.getLong(r111);
        goto L133
    L129:
        r68 = r0.getLong(r110);
        goto L130
    L123:
        if (r0.getInt(r19) == 0) goto L125;
        boolean r31 = true;
    L126:
        r67 = r31;
        goto L127
    L125:
        r31 = false;
        goto L126
    L108:
        if (r0.isNull(r18) == false) goto L110;
        Integer r32 = null;
    L111:
        if (r32 != null) goto L114;
        Boolean r33 = null;
    L118:
        r66 = r33;
        goto L119
    L114:
        if (r32.intValue() == 0) goto L116;
        boolean r34 = true;
    L117:
        r33 = Boolean.valueOf(r34);
        goto L118
    L116:
        r34 = false;
        goto L117
    L110:
        r32 = Integer.valueOf(r0.getInt(r18));
        goto L111
    L93:
        if (r0.isNull(r17) == false) goto L95;
        Integer r35 = null;
    L96:
        if (r35 != null) goto L99;
        Boolean r36 = null;
    L103:
        r65 = r36;
        goto L104
    L99:
        if (r35.intValue() == 0) goto L101;
        boolean r37 = true;
    L102:
        r36 = Boolean.valueOf(r37);
        goto L103
    L101:
        r37 = false;
        goto L102
    L95:
        r35 = Integer.valueOf(r0.getInt(r17));
        goto L96
    L85:
        if (r0.isNull(r92) == true) goto L83;
        r64 = r0.getString(r16);
        goto L88
    L79:
        if (r0.isNull(r91) == true) goto L77;
        r63 = r0.getString(r15);
        goto L82
    L73:
        if (r0.isNull(r14) == true) goto L71;
        r62 = r0.getString(r14);
        goto L76
    L67:
        if (r0.isNull(r13) == true) goto L65;
        r61 = Integer.valueOf(r0.getInt(r13));
        goto L70
    L61:
        if (r0.isNull(r12) == true) goto L59;
        r60 = Integer.valueOf(r0.getInt(r12));
        goto L64
    L55:
        if (r0.isNull(r11) == true) goto L53;
        r59 = r0.getString(r11);
        goto L58
    L49:
        if (r0.isNull(r10) == true) goto L47;
        r58 = r0.getString(r10);
        goto L52
    L43:
        if (r0.isNull(r9) == true) goto L41;
        r57 = r0.getString(r9);
        goto L46
    L37:
        if (r0.isNull(r8) == true) goto L35;
        r56 = r0.getString(r8);
        goto L40
    L31:
        if (r0.isNull(r7) == true) goto L29;
        r55 = r0.getString(r7);
        goto L34
    L25:
        if (r0.isNull(r6) == true) goto L23;
        r54 = r0.getString(r6);
        goto L28
    L19:
        if (r0.isNull(r5) == true) goto L17;
        r53 = r0.getString(r5);
        goto L22
    L14:
        r51 = r0.getLong(r4);
        goto L15
    L11:
        r49 = r0.getLong(r3);
        goto L12
    L8:
        r47 = r0.getLong(r2);
        goto L9
    L5:
        r44 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.entity.i> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfEpisodicMemoryHistoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.entity.i> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfEpisodicMemoryHistoryEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.memorydata.database.legacy.entity.i r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfEpisodicMemoryHistoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.memorydata.database.legacy.entity.i r3) {
        return delete2((com.obric.memorydata.database.legacy.entity.i) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.i.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return r.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return r.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.memorydata.database.legacy.entity.i r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfEpisodicMemoryHistoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.memorydata.database.legacy.entity.i r3) {
        return insert2((com.obric.memorydata.database.legacy.entity.i) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.i.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.entity.i> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfEpisodicMemoryHistoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.i> queryAll() {
        return r.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return r.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.i queryById(long r1) {
        return r.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.i queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.i> queryByIds(List<Long> r3) {
        return r.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.i queryByUUID(String r1) {
        return r.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.i queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.i queryOne() {
        return r.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.i queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.i> queryWithLimitAndOffset(int r1, int r2) {
        return r.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.i> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityEpisodicMemoryHistoryEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.memorydata.database.legacy.entity.i r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfEpisodicMemoryHistoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.memorydata.database.legacy.entity.i r3) {
        return update2((com.obric.memorydata.database.legacy.entity.i) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.i.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.entity.i> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfEpisodicMemoryHistoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
