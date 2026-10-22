package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.bj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EpisodicMemoryHistoryRawDbDao_Impl implements EpisodicMemoryHistoryRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<bj> __deletionAdapterOfEpisodicMemoryHistoryEntity;
    private final EntityInsertionAdapter<bj> __insertionAdapterOfEpisodicMemoryHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<bj> __updateAdapterOfEpisodicMemoryHistoryEntity;

    public EpisodicMemoryHistoryRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfEpisodicMemoryHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfEpisodicMemoryHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfEpisodicMemoryHistoryEntity = new AnonymousClass3(this, r2);
    }

    private bj __entityCursorConverter_comObricMemorydataDatabaseEntityEpisodicMemoryHistoryEntity(Cursor r98) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r98, Cursor.class, "com.obric.memorydata.plugin");
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
        int r127 = CursorUtil.getColumnIndex(r0, "episodic_memory_eventName");
        int r128 = CursorUtil.getColumnIndex(r0, "episodic_memory_rawTableName");
        int r129 = CursorUtil.getColumnIndex(r0, "episodic_memory_rawDbId");
        int r130 = CursorUtil.getColumnIndex(r0, "episodic_memory_eventData");
        int r131 = CursorUtil.getColumnIndex(r0, "episodic_memory_poison_label");
        int r132 = CursorUtil.getColumnIndex(r0, "episodic_memory_poison_label_version");
        int r133 = CursorUtil.getColumnIndex(r0, "episodic_memory_content_hash");
        long r42 = 0;
        if (r1 != (-1)) goto L5;
        long r47 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r50 = 0;
    L9:
        if (r3 != (-1)) goto L11;
        long r52 = 0;
    L12:
        if (r4 != (-1)) goto L14;
        long r54 = 0;
    L15:
        String r20 = null;
        if (r5 != (-1)) goto L19;
    L17:
        String r56 = null;
    L22:
        if (r6 != (-1)) goto L25;
    L23:
        String r57 = null;
    L28:
        if (r7 != (-1)) goto L31;
    L29:
        String r58 = null;
    L34:
        if (r8 != (-1)) goto L37;
    L35:
        String r59 = null;
    L40:
        if (r9 != (-1)) goto L43;
    L41:
        String r60 = null;
    L46:
        if (r10 != (-1)) goto L49;
    L47:
        String r61 = null;
    L52:
        if (r11 != (-1)) goto L55;
    L53:
        String r62 = null;
    L58:
        if (r12 != (-1)) goto L61;
    L59:
        Integer r63 = null;
    L64:
        if (r13 != (-1)) goto L67;
    L65:
        Integer r64 = null;
    L70:
        if (r14 != (-1)) goto L73;
    L71:
        String r65 = null;
    L76:
        if (r97 != (-1)) goto L79;
    L77:
        String r66 = null;
    L82:
        if (r98 != (-1)) goto L85;
    L83:
        String r67 = null;
    L88:
        boolean r21 = true;
        if (r17 != (-1)) goto L93;
        Boolean r68 = null;
    L104:
        if (r18 != (-1)) goto L108;
        Boolean r69 = null;
    L119:
        if (r19 != (-1)) goto L123;
        boolean r70 = false;
    L127:
        if (r110 != (-1)) goto L129;
        long r71 = 0;
    L130:
        if (r20 != (-1)) goto L132;
        long r73 = 0;
    L133:
        if (r21 != (-1)) goto L137;
        Boolean r75 = null;
    L148:
        if (r113 != (-1)) goto L152;
    L149:
        String r76 = null;
    L155:
        if (r114 != (-1)) goto L157;
        long r77 = 0;
    L158:
        if (r24 != (-1)) goto L160;
        long r79 = 0;
    L161:
        if (r25 != (-1)) goto L163;
        int r81 = 0;
    L165:
        if (r117 == (-1)) goto L168;
        r42 = r0.getLong(r117);
    L168:
        long r82 = r42;
        if (r118 != (-1)) goto L173;
    L170:
        String r84 = null;
    L176:
        if (r119 != (-1)) goto L178;
        int r85 = 0;
    L180:
        if (r120 != (-1)) goto L184;
    L181:
        String r86 = null;
    L187:
        if (r121 != (-1)) goto L191;
        Boolean r87 = null;
    L202:
        if (r122 != (-1)) goto L204;
        int r88 = 0;
    L206:
        if (r123 != (-1)) goto L210;
    L207:
        String r89 = null;
    L213:
        if (r124 != (-1)) goto L217;
    L214:
        String r90 = null;
    L220:
        if (r125 != (-1)) goto L224;
    L221:
        String r91 = null;
    L227:
        if (r126 != (-1)) goto L231;
    L228:
        String r92 = null;
    L234:
        if (r127 != (-1)) goto L238;
    L235:
        String r93 = null;
    L241:
        if (r128 != (-1)) goto L245;
    L242:
        String r94 = null;
    L248:
        if (r129 != (-1)) goto L252;
    L249:
        Long r95 = null;
    L255:
        if (r130 != (-1)) goto L258;
    L256:
        String r96 = null;
    L261:
        EpisodicMemoryEntity r22 = new EpisodicMemoryEntity(r50, r52, r54, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r73, r75, r76, r77, r79, r81, r82, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96);
        if (r131 == (-1)) goto L269;
        if (r0.isNull(r131) == false) goto L266;
        Integer r23 = null;
    L267:
        r22.setPoisonLabel(r23);
        goto L269
    L266:
        r23 = Integer.valueOf(r0.getInt(r131));
    L269:
        if (r132 == (-1)) goto L276;
        if (r0.isNull(r132) == false) goto L273;
        Integer r24 = null;
    L274:
        r22.setPoisonLabelVersion(r24);
        goto L276
    L273:
        r24 = Integer.valueOf(r0.getInt(r132));
    L276:
        if (r133 == (-1)) goto L283;
        if (r0.isNull(r133) == true) goto L281;
        r20 = r0.getString(r133);
    L281:
        r22.setContentHash(r20);
    L283:
        return new bj(r47, r22);
    L258:
        if (r0.isNull(r130) == true) goto L256;
        r96 = r0.getString(r130);
        goto L261
    L252:
        if (r0.isNull(r129) == true) goto L249;
        r95 = Long.valueOf(r0.getLong(r129));
        goto L255
    L245:
        if (r0.isNull(r128) == true) goto L242;
        r94 = r0.getString(r128);
        goto L248
    L238:
        if (r0.isNull(r127) == true) goto L235;
        r93 = r0.getString(r127);
        goto L241
    L231:
        if (r0.isNull(r126) == true) goto L228;
        r92 = r0.getString(r126);
        goto L234
    L224:
        if (r0.isNull(r125) == true) goto L221;
        r91 = r0.getString(r125);
        goto L227
    L217:
        if (r0.isNull(r124) == true) goto L214;
        r90 = r0.getString(r124);
        goto L220
    L210:
        if (r0.isNull(r123) == true) goto L207;
        r89 = r0.getString(r123);
        goto L213
    L204:
        r88 = r0.getInt(r122);
        goto L206
    L191:
        if (r0.isNull(r121) == false) goto L193;
        Integer r25 = null;
    L194:
        if (r25 != null) goto L197;
        Boolean r26 = null;
    L201:
        r87 = r26;
        goto L202
    L197:
        if (r25.intValue() != 0) goto L200;
        r21 = false;
    L200:
        r26 = Boolean.valueOf(r21);
        goto L201
    L193:
        r25 = Integer.valueOf(r0.getInt(r121));
        goto L194
    L184:
        if (r0.isNull(r120) == true) goto L181;
        r86 = r0.getString(r120);
        goto L187
    L178:
        r85 = r0.getInt(r119);
        goto L180
    L173:
        if (r0.isNull(r118) == true) goto L170;
        r84 = r0.getString(r118);
        goto L176
    L163:
        r81 = r0.getInt(r116);
        goto L165
    L160:
        r79 = r0.getLong(r115);
        goto L161
    L157:
        r77 = r0.getLong(r114);
        goto L158
    L152:
        if (r0.isNull(r113) == true) goto L149;
        r76 = r0.getString(r113);
        goto L155
    L137:
        if (r0.isNull(r21) == false) goto L139;
        Integer r27 = null;
    L140:
        if (r27 != null) goto L143;
        Boolean r28 = null;
    L147:
        r75 = r28;
        goto L148
    L143:
        if (r27.intValue() == 0) goto L145;
        boolean r29 = true;
    L146:
        r28 = Boolean.valueOf(r29);
        goto L147
    L145:
        r29 = false;
        goto L146
    L139:
        r27 = Integer.valueOf(r0.getInt(r112));
        goto L140
    L132:
        r73 = r0.getLong(r111);
        goto L133
    L129:
        r71 = r0.getLong(r110);
        goto L130
    L123:
        if (r0.getInt(r19) == 0) goto L125;
        boolean r30 = true;
    L126:
        r70 = r30;
        goto L127
    L125:
        r30 = false;
        goto L126
    L108:
        if (r0.isNull(r18) == false) goto L110;
        Integer r31 = null;
    L111:
        if (r31 != null) goto L114;
        Boolean r32 = null;
    L118:
        r69 = r32;
        goto L119
    L114:
        if (r31.intValue() == 0) goto L116;
        boolean r33 = true;
    L117:
        r32 = Boolean.valueOf(r33);
        goto L118
    L116:
        r33 = false;
        goto L117
    L110:
        r31 = Integer.valueOf(r0.getInt(r18));
        goto L111
    L93:
        if (r0.isNull(r17) == false) goto L95;
        Integer r34 = null;
    L96:
        if (r34 != null) goto L99;
        Boolean r35 = null;
    L103:
        r68 = r35;
        goto L104
    L99:
        if (r34.intValue() == 0) goto L101;
        boolean r36 = true;
    L102:
        r35 = Boolean.valueOf(r36);
        goto L103
    L101:
        r36 = false;
        goto L102
    L95:
        r34 = Integer.valueOf(r0.getInt(r17));
        goto L96
    L85:
        if (r0.isNull(r98) == true) goto L83;
        r67 = r0.getString(r16);
        goto L88
    L79:
        if (r0.isNull(r97) == true) goto L77;
        r66 = r0.getString(r15);
        goto L82
    L73:
        if (r0.isNull(r14) == true) goto L71;
        r65 = r0.getString(r14);
        goto L76
    L67:
        if (r0.isNull(r13) == true) goto L65;
        r64 = Integer.valueOf(r0.getInt(r13));
        goto L70
    L61:
        if (r0.isNull(r12) == true) goto L59;
        r63 = Integer.valueOf(r0.getInt(r12));
        goto L64
    L55:
        if (r0.isNull(r11) == true) goto L53;
        r62 = r0.getString(r11);
        goto L58
    L49:
        if (r0.isNull(r10) == true) goto L47;
        r61 = r0.getString(r10);
        goto L52
    L43:
        if (r0.isNull(r9) == true) goto L41;
        r60 = r0.getString(r9);
        goto L46
    L37:
        if (r0.isNull(r8) == true) goto L35;
        r59 = r0.getString(r8);
        goto L40
    L31:
        if (r0.isNull(r7) == true) goto L29;
        r58 = r0.getString(r7);
        goto L34
    L25:
        if (r0.isNull(r6) == true) goto L23;
        r57 = r0.getString(r6);
        goto L28
    L19:
        if (r0.isNull(r5) == true) goto L17;
        r56 = r0.getString(r5);
        goto L22
    L14:
        r54 = r0.getLong(r4);
        goto L15
    L11:
        r52 = r0.getLong(r3);
        goto L12
    L8:
        r50 = r0.getLong(r2);
        goto L9
    L5:
        r47 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<bj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfEpisodicMemoryHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<bj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfEpisodicMemoryHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(bj r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfEpisodicMemoryHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((bj) ZeusTransformUtils.preCheckCast(r3, bj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.deleteByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.deleteByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.deleteByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.deleteById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryHistoryRawDbDao, com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.getPrefix(this);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryHistoryRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(bj r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfEpisodicMemoryHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((bj) ZeusTransformUtils.preCheckCast(r3, bj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<bj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfEpisodicMemoryHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bj> queryAll() {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<bj> queryByEntityId(String r1, String r2) {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<bj> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public bj queryById(long r1) {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bj> queryByIds(List<Long> r3) {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public bj queryByUUID(String r1) {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public bj queryOne() {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bj> queryWithLimitAndOffset(int r1, int r2) {
        return EpisodicMemoryHistoryRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<bj> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityEpisodicMemoryHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(bj r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfEpisodicMemoryHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((bj) ZeusTransformUtils.preCheckCast(r3, bj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<bj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfEpisodicMemoryHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
