package com.obric.memorydata.database.legacy.backup.dao;

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
public final class BackUpEpisodicMemoryDaoOld_Impl implements h {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.h> __deletionAdapterOfBackUpEpisodicMemoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.h> __insertionAdapterOfBackUpEpisodicMemoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.h> __insertionAdapterOfBackUpEpisodicMemoryEntityOld_1;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.h> __updateAdapterOfBackUpEpisodicMemoryEntityOld;

    public BackUpEpisodicMemoryDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBackUpEpisodicMemoryEntityOld = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfBackUpEpisodicMemoryEntityOld_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfBackUpEpisodicMemoryEntityOld = new AnonymousClass3(this, r2);
        this.__updateAdapterOfBackUpEpisodicMemoryEntityOld = new AnonymousClass4(this, r2);
    }

    private com.obric.memorydata.database.legacy.backup.a.h __entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpEpisodicMemoryEntityOld(Cursor r98) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r98, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "backupUserId");
        int r3 = CursorUtil.getColumnIndex(r0, "backupDbVersion");
        int r4 = CursorUtil.getColumnIndex(r0, "backup_id");
        int r5 = CursorUtil.getColumnIndex(r0, "backup_actionTimestamp");
        int r6 = CursorUtil.getColumnIndex(r0, "backup_uid");
        int r7 = CursorUtil.getColumnIndex(r0, "backup_title");
        int r8 = CursorUtil.getColumnIndex(r0, "backup_content");
        int r9 = CursorUtil.getColumnIndex(r0, "backup_contentWithTime");
        int r10 = CursorUtil.getColumnIndex(r0, "backup_fullContent");
        int r11 = CursorUtil.getColumnIndex(r0, "backup_observation");
        int r12 = CursorUtil.getColumnIndex(r0, "backup_location");
        int r13 = CursorUtil.getColumnIndex(r0, "backup_appNames");
        int r14 = CursorUtil.getColumnIndex(r0, "backup_category");
        int r15 = CursorUtil.getColumnIndex(r0, "backup_profileType");
        int r16 = CursorUtil.getColumnIndex(r0, "backup_profileTag");
        int r17 = CursorUtil.getColumnIndex(r0, "backup_tagOther");
        int r18 = CursorUtil.getColumnIndex(r0, "backup_logId");
        int r19 = CursorUtil.getColumnIndex(r0, "backup_usedForPortrait");
        int r110 = CursorUtil.getColumnIndex(r0, "backup_useLocation");
        int r111 = CursorUtil.getColumnIndex(r0, "backup_useForUserKeyword");
        int r112 = CursorUtil.getColumnIndex(r0, "backup_startTimestamp");
        int r113 = CursorUtil.getColumnIndex(r0, "backup_endTimestamp");
        int r114 = CursorUtil.getColumnIndex(r0, "backup_useForTopic");
        int r115 = CursorUtil.getColumnIndex(r0, "backup_entityId");
        int r116 = CursorUtil.getColumnIndex(r0, "backup_createTime");
        int r117 = CursorUtil.getColumnIndex(r0, "backup_modifyTime");
        int r118 = CursorUtil.getColumnIndex(r0, "backup_type");
        int r119 = CursorUtil.getColumnIndex(r0, "backup_timestamp");
        int r120 = CursorUtil.getColumnIndex(r0, "backup_packageName");
        int r121 = CursorUtil.getColumnIndex(r0, "backup_hashCodeValue");
        int r122 = CursorUtil.getColumnIndex(r0, "backup_uuid");
        int r123 = CursorUtil.getColumnIndex(r0, "backup_userEdit");
        int r124 = CursorUtil.getColumnIndex(r0, "backup_productType");
        int r125 = CursorUtil.getColumnIndex(r0, "backup_important_raw_ref_ids");
        int r126 = CursorUtil.getColumnIndex(r0, "backup_source_raw_ref_ids");
        int r127 = CursorUtil.getColumnIndex(r0, "backup_scene_ids");
        int r128 = CursorUtil.getColumnIndex(r0, "backup_sourcePackageName");
        int r129 = CursorUtil.getColumnIndex(r0, "backup_personalDbSplitMigrated");
        int r130 = CursorUtil.getColumnIndex(r0, "backup_poison_label");
        int r131 = CursorUtil.getColumnIndex(r0, "backup_poison_label_version");
        int r132 = CursorUtil.getColumnIndex(r0, "backup_content_hash");
        long r41 = 0;
        if (r1 != (-1)) goto L5;
        long r47 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r50 = null;
    L13:
        boolean r21 = false;
        if (r3 != (-1)) goto L16;
        int r51 = 0;
    L17:
        if (r4 != (-1)) goto L19;
        long r53 = 0;
    L20:
        if (r5 != (-1)) goto L22;
        long r55 = 0;
    L23:
        if (r6 != (-1)) goto L25;
        long r57 = 0;
    L26:
        if (r7 != (-1)) goto L29;
    L27:
        String r59 = null;
    L32:
        if (r8 != (-1)) goto L35;
    L33:
        String r60 = null;
    L38:
        if (r9 != (-1)) goto L41;
    L39:
        String r61 = null;
    L44:
        if (r10 != (-1)) goto L47;
    L45:
        String r62 = null;
    L50:
        if (r11 != (-1)) goto L53;
    L51:
        String r63 = null;
    L56:
        if (r12 != (-1)) goto L59;
    L57:
        String r64 = null;
    L62:
        if (r13 != (-1)) goto L65;
    L63:
        String r65 = null;
    L68:
        if (r14 != (-1)) goto L71;
    L69:
        Integer r66 = null;
    L74:
        if (r97 != (-1)) goto L77;
    L75:
        Integer r67 = null;
    L80:
        if (r98 != (-1)) goto L84;
    L81:
        String r68 = null;
    L87:
        if (r17 != (-1)) goto L91;
    L88:
        String r69 = null;
    L94:
        if (r18 != (-1)) goto L97;
    L95:
        String r70 = null;
    L101:
        if (r19 != (-1)) goto L105;
        Boolean r71 = null;
    L116:
        if (r110 != (-1)) goto L120;
        Boolean r72 = null;
    L131:
        if (r111 != (-1)) goto L135;
        boolean r73 = false;
    L139:
        if (r112 != (-1)) goto L141;
        long r74 = 0;
    L142:
        if (r22 != (-1)) goto L144;
        long r76 = 0;
    L145:
        if (r23 != (-1)) goto L149;
        Boolean r78 = null;
    L160:
        if (r115 != (-1)) goto L164;
    L161:
        String r79 = null;
    L167:
        if (r116 != (-1)) goto L169;
        long r80 = 0;
    L170:
        if (r26 != (-1)) goto L172;
        long r82 = 0;
    L173:
        if (r27 != (-1)) goto L175;
        int r84 = 0;
    L177:
        if (r119 == (-1)) goto L180;
        r41 = r0.getLong(r119);
    L180:
        long r85 = r41;
        if (r120 != (-1)) goto L185;
    L182:
        String r87 = null;
    L188:
        if (r121 != (-1)) goto L190;
        int r88 = 0;
    L192:
        if (r122 != (-1)) goto L196;
    L193:
        String r89 = null;
    L199:
        if (r123 != (-1)) goto L203;
        Boolean r90 = null;
    L214:
        if (r124 != (-1)) goto L216;
        int r91 = 0;
    L218:
        if (r125 != (-1)) goto L222;
    L219:
        String r92 = null;
    L225:
        if (r126 != (-1)) goto L229;
    L226:
        String r93 = null;
    L232:
        if (r127 != (-1)) goto L236;
    L233:
        String r94 = null;
    L239:
        if (r128 != (-1)) goto L243;
    L240:
        String r95 = null;
    L246:
        if (r129 != (-1)) goto L249;
    L251:
        EpisodicMemoryEntityOld r22 = new EpisodicMemoryEntityOld(r53, r55, r57, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r76, r78, r79, r80, r82, r84, r85, r87, r88, r89, r90, r91, r92, r93, r94, r95, r21);
        if (r130 == (-1)) goto L259;
        if (r0.isNull(r130) == false) goto L256;
        Integer r23 = null;
    L257:
        r22.setPoisonLabel(r23);
        goto L259
    L256:
        r23 = Integer.valueOf(r0.getInt(r130));
    L259:
        if (r131 == (-1)) goto L266;
        if (r0.isNull(r131) == false) goto L263;
        Integer r24 = null;
    L264:
        r22.setPoisonLabelVersion(r24);
        goto L266
    L263:
        r24 = Integer.valueOf(r0.getInt(r131));
    L266:
        if (r132 == (-1)) goto L273;
        if (r0.isNull(r132) == true) goto L271;
        r20 = r0.getString(r132);
    L271:
        r22.setContentHash(r20);
    L273:
        return new com.obric.memorydata.database.legacy.backup.a.h(r47, r22, r50, r51);
    L249:
        if (r0.getInt(r129) == 0) goto L251;
        r21 = true;
        goto L251
    L243:
        if (r0.isNull(r128) == true) goto L240;
        r95 = r0.getString(r128);
        goto L246
    L236:
        if (r0.isNull(r127) == true) goto L233;
        r94 = r0.getString(r127);
        goto L239
    L229:
        if (r0.isNull(r126) == true) goto L226;
        r93 = r0.getString(r126);
        goto L232
    L222:
        if (r0.isNull(r125) == true) goto L219;
        r92 = r0.getString(r125);
        goto L225
    L216:
        r91 = r0.getInt(r124);
        goto L218
    L203:
        if (r0.isNull(r123) == false) goto L205;
        Integer r25 = null;
    L206:
        if (r25 != null) goto L209;
        Boolean r26 = null;
    L213:
        r90 = r26;
        goto L214
    L209:
        if (r25.intValue() == 0) goto L211;
        boolean r27 = true;
    L212:
        r26 = Boolean.valueOf(r27);
        goto L213
    L211:
        r27 = false;
        goto L212
    L205:
        r25 = Integer.valueOf(r0.getInt(r123));
        goto L206
    L196:
        if (r0.isNull(r122) == true) goto L193;
        r89 = r0.getString(r122);
        goto L199
    L190:
        r88 = r0.getInt(r121);
        goto L192
    L185:
        if (r0.isNull(r120) == true) goto L182;
        r87 = r0.getString(r120);
        goto L188
    L175:
        r84 = r0.getInt(r118);
        goto L177
    L172:
        r82 = r0.getLong(r117);
        goto L173
    L169:
        r80 = r0.getLong(r116);
        goto L170
    L164:
        if (r0.isNull(r115) == true) goto L161;
        r79 = r0.getString(r115);
        goto L167
    L149:
        if (r0.isNull(r23) == false) goto L151;
        Integer r28 = null;
    L152:
        if (r28 != null) goto L155;
        Boolean r29 = null;
    L159:
        r78 = r29;
        goto L160
    L155:
        if (r28.intValue() == 0) goto L157;
        boolean r30 = true;
    L158:
        r29 = Boolean.valueOf(r30);
        goto L159
    L157:
        r30 = false;
        goto L158
    L151:
        r28 = Integer.valueOf(r0.getInt(r114));
        goto L152
    L144:
        r76 = r0.getLong(r113);
        goto L145
    L141:
        r74 = r0.getLong(r112);
        goto L142
    L135:
        if (r0.getInt(r111) == 0) goto L137;
        boolean r31 = true;
    L138:
        r73 = r31;
        goto L139
    L137:
        r31 = false;
        goto L138
    L120:
        if (r0.isNull(r110) == false) goto L122;
        Integer r32 = null;
    L123:
        if (r32 != null) goto L126;
        Boolean r33 = null;
    L130:
        r72 = r33;
        goto L131
    L126:
        if (r32.intValue() == 0) goto L128;
        boolean r34 = true;
    L129:
        r33 = Boolean.valueOf(r34);
        goto L130
    L128:
        r34 = false;
        goto L129
    L122:
        r32 = Integer.valueOf(r0.getInt(r110));
        goto L123
    L105:
        if (r0.isNull(r19) == false) goto L107;
        Integer r35 = null;
    L108:
        if (r35 != null) goto L111;
        Boolean r36 = null;
    L115:
        r71 = r36;
        goto L116
    L111:
        if (r35.intValue() == 0) goto L113;
        boolean r37 = true;
    L114:
        r36 = Boolean.valueOf(r37);
        goto L115
    L113:
        r37 = false;
        goto L114
    L107:
        r35 = Integer.valueOf(r0.getInt(r19));
        goto L108
    L97:
        if (r0.isNull(r18) == true) goto L95;
        r70 = r0.getString(r18);
        goto L101
    L91:
        if (r0.isNull(r17) == true) goto L88;
        r69 = r0.getString(r17);
        goto L94
    L84:
        if (r0.isNull(r98) == true) goto L81;
        r68 = r0.getString(r16);
        goto L87
    L77:
        if (r0.isNull(r97) == true) goto L75;
        r67 = Integer.valueOf(r0.getInt(r15));
        goto L80
    L71:
        if (r0.isNull(r14) == true) goto L69;
        r66 = Integer.valueOf(r0.getInt(r14));
        goto L74
    L65:
        if (r0.isNull(r13) == true) goto L63;
        r65 = r0.getString(r13);
        goto L68
    L59:
        if (r0.isNull(r12) == true) goto L57;
        r64 = r0.getString(r12);
        goto L62
    L53:
        if (r0.isNull(r11) == true) goto L51;
        r63 = r0.getString(r11);
        goto L56
    L47:
        if (r0.isNull(r10) == true) goto L45;
        r62 = r0.getString(r10);
        goto L50
    L41:
        if (r0.isNull(r9) == true) goto L39;
        r61 = r0.getString(r9);
        goto L44
    L35:
        if (r0.isNull(r8) == true) goto L33;
        r60 = r0.getString(r8);
        goto L38
    L29:
        if (r0.isNull(r7) == true) goto L27;
        r59 = r0.getString(r7);
        goto L32
    L25:
        r57 = r0.getLong(r6);
        goto L26
    L22:
        r55 = r0.getLong(r5);
        goto L23
    L19:
        r53 = r0.getLong(r4);
        goto L20
    L16:
        r51 = r0.getInt(r3);
        goto L17
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r50 = r0.getString(r2);
        goto L13
    L5:
        r47 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.backup.a.h> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBackUpEpisodicMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.backup.a.h> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBackUpEpisodicMemoryEntityOld_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(com.obric.memorydata.database.legacy.backup.a.h r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBackUpEpisodicMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((com.obric.memorydata.database.legacy.backup.a.h) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.h.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return h.a.d(this);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public int deleteByBackupUserId(String r1) {
        return h.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return h.a.a(this);
    }

    public long insert(com.obric.memorydata.database.legacy.backup.a.h r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBackUpEpisodicMemoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((com.obric.memorydata.database.legacy.backup.a.h) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.h.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.backup.a.h> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBackUpEpisodicMemoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.h> queryAll() {
        return h.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return h.a.c(this);
    }

    public List<com.obric.memorydata.database.legacy.backup.a.h> queryByBackupUserId(String r1) {
        return h.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public List<com.obric.memorydata.database.legacy.backup.a.h> queryByBackupUserId(String r1, int r2, int r3) {
        return h.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.h queryById(long r1) {
        return h.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.h> queryByIds(List<Long> r3) {
        return h.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.h queryByUUID(String r1) {
        return h.a.c(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.h queryOne() {
        return h.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.h> queryWithLimitAndOffset(int r1, int r2) {
        return h.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.h> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpEpisodicMemoryEntityOld(r6));     // Catch: Throwable -> L10
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

    public int update(com.obric.memorydata.database.legacy.backup.a.h r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBackUpEpisodicMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((com.obric.memorydata.database.legacy.backup.a.h) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.h.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.backup.a.h> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBackUpEpisodicMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
