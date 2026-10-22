package com.obric.memorydata.database.backup.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class BackUpRawMemoryDao_Impl implements c {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.backup.a.d> __deletionAdapterOfBackUpRawMemoryEntity;
    private final EntityInsertionAdapter<com.obric.memorydata.database.backup.a.d> __insertionAdapterOfBackUpRawMemoryEntity;
    private final EntityInsertionAdapter<com.obric.memorydata.database.backup.a.d> __insertionAdapterOfBackUpRawMemoryEntity_1;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.backup.a.d> __updateAdapterOfBackUpRawMemoryEntity;

    public BackUpRawMemoryDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBackUpRawMemoryEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfBackUpRawMemoryEntity_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfBackUpRawMemoryEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfBackUpRawMemoryEntity = new AnonymousClass4(this, r2);
    }

    private com.obric.memorydata.database.backup.a.d __entityCursorConverter_comObricMemorydataDatabaseBackupEntityBackUpRawMemoryEntity(Cursor r112) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r112, Cursor.class, "com.obric.memorydata.plugin");
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
        int r13 = CursorUtil.getColumnIndex(r0, "backup_memoryType");
        int r14 = CursorUtil.getColumnIndex(r0, "backup_productType");
        int r15 = CursorUtil.getColumnIndex(r0, "backup_startDate");
        int r16 = CursorUtil.getColumnIndex(r0, "backup_startTime");
        int r17 = CursorUtil.getColumnIndex(r0, "backup_endDate");
        int r18 = CursorUtil.getColumnIndex(r0, "backup_endTime");
        int r19 = CursorUtil.getColumnIndex(r0, "backup_sourceLinkType");
        int r110 = CursorUtil.getColumnIndex(r0, "backup_sourceLink");
        int r111 = CursorUtil.getColumnIndex(r0, "backup_screenshot");
        int r113 = CursorUtil.getColumnIndex(r0, "backup_locations");
        int r114 = CursorUtil.getColumnIndex(r0, "backup_summary");
        int r115 = CursorUtil.getColumnIndex(r0, "backup_fullContent");
        int r116 = CursorUtil.getColumnIndex(r0, "backup_key1");
        int r117 = CursorUtil.getColumnIndex(r0, "backup_key2");
        int r118 = CursorUtil.getColumnIndex(r0, "backup_key3");
        int r119 = CursorUtil.getColumnIndex(r0, "backup_key4");
        int r120 = CursorUtil.getColumnIndex(r0, "backup_key5");
        int r121 = CursorUtil.getColumnIndex(r0, "backup_keyword1");
        int r122 = CursorUtil.getColumnIndex(r0, "backup_keyword2");
        int r123 = CursorUtil.getColumnIndex(r0, "backup_keyword3");
        int r124 = CursorUtil.getColumnIndex(r0, "backup_keyword4");
        int r125 = CursorUtil.getColumnIndex(r0, "backup_keyword5");
        int r126 = CursorUtil.getColumnIndex(r0, "backup_keyword6");
        int r127 = CursorUtil.getColumnIndex(r0, "backup_semantic1");
        int r128 = CursorUtil.getColumnIndex(r0, "backup_semantic2");
        int r129 = CursorUtil.getColumnIndex(r0, "backup_keywordAndSemantic1");
        int r130 = CursorUtil.getColumnIndex(r0, "backup_keywordAndSemantic2");
        int r131 = CursorUtil.getColumnIndex(r0, "backup_sourceText");
        int r132 = CursorUtil.getColumnIndex(r0, "backup_sourcePackageName");
        int r133 = CursorUtil.getColumnIndex(r0, "backup_sourceAppName");
        int r134 = CursorUtil.getColumnIndex(r0, "backup_logId");
        int r135 = CursorUtil.getColumnIndex(r0, "backup_sourceQuery");
        int r136 = CursorUtil.getColumnIndex(r0, "backup_detail");
        int r137 = CursorUtil.getColumnIndex(r0, "backup_detailStatus");
        int r138 = CursorUtil.getColumnIndex(r0, "backup_contentWithTime");
        int r139 = CursorUtil.getColumnIndex(r0, "backup_userEdit");
        int r140 = CursorUtil.getColumnIndex(r0, "backup_poison_label");
        int r141 = CursorUtil.getColumnIndex(r0, "backup_poison_label_version");
        int r142 = CursorUtil.getColumnIndex(r0, "backup_content_hash");
        long r50 = 0;
        if (r1 != (-1)) goto L5;
        long r56 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r59 = null;
    L13:
        boolean r21 = false;
        if (r3 != (-1)) goto L16;
        int r60 = 0;
    L17:
        if (r4 != (-1)) goto L19;
        long r62 = 0;
    L20:
        if (r5 != (-1)) goto L23;
    L21:
        String r64 = null;
    L26:
        if (r6 != (-1)) goto L28;
        long r65 = 0;
    L29:
        if (r7 != (-1)) goto L31;
        long r67 = 0;
    L32:
        if (r8 != (-1)) goto L34;
        int r69 = 0;
    L35:
        if (r9 == (-1)) goto L38;
        r50 = r0.getLong(r9);
    L38:
        long r70 = r50;
        if (r10 != (-1)) goto L42;
    L40:
        String r72 = null;
    L45:
        if (r11 != (-1)) goto L47;
        int r73 = 0;
    L48:
        if (r12 != (-1)) goto L51;
    L49:
        String r74 = null;
    L54:
        if (r13 != (-1)) goto L56;
        int r75 = 0;
    L57:
        if (r14 != (-1)) goto L59;
        int r76 = 0;
    L60:
        if (r111 != (-1)) goto L63;
    L61:
        Long r77 = null;
    L66:
        if (r112 != (-1)) goto L70;
    L67:
        Long r78 = null;
    L73:
        if (r17 != (-1)) goto L77;
    L74:
        Long r79 = null;
    L80:
        if (r18 != (-1)) goto L84;
    L81:
        Long r80 = null;
    L87:
        if (r19 != (-1)) goto L91;
    L88:
        String r81 = null;
    L94:
        if (r110 != (-1)) goto L98;
    L95:
        String r82 = null;
    L101:
        if (r111 != (-1)) goto L105;
    L102:
        String r83 = null;
    L108:
        if (r113 != (-1)) goto L112;
    L109:
        String r84 = null;
    L115:
        if (r114 != (-1)) goto L119;
    L116:
        String r85 = null;
    L122:
        if (r115 != (-1)) goto L126;
    L123:
        String r86 = null;
    L129:
        if (r116 != (-1)) goto L133;
    L130:
        String r87 = null;
    L136:
        if (r117 != (-1)) goto L140;
    L137:
        String r88 = null;
    L143:
        if (r118 != (-1)) goto L147;
    L144:
        String r89 = null;
    L150:
        if (r119 != (-1)) goto L154;
    L151:
        String r90 = null;
    L157:
        if (r120 != (-1)) goto L161;
    L158:
        String r91 = null;
    L164:
        if (r121 != (-1)) goto L168;
    L165:
        String r92 = null;
    L171:
        if (r122 != (-1)) goto L175;
    L172:
        String r93 = null;
    L178:
        if (r123 != (-1)) goto L182;
    L179:
        String r94 = null;
    L185:
        if (r124 != (-1)) goto L189;
    L186:
        String r95 = null;
    L192:
        if (r125 != (-1)) goto L196;
    L193:
        String r96 = null;
    L199:
        if (r126 != (-1)) goto L203;
    L200:
        String r97 = null;
    L206:
        if (r127 != (-1)) goto L210;
    L207:
        String r98 = null;
    L213:
        if (r128 != (-1)) goto L217;
    L214:
        String r99 = null;
    L220:
        if (r129 != (-1)) goto L224;
    L221:
        String r100 = null;
    L227:
        if (r130 != (-1)) goto L231;
    L228:
        String r101 = null;
    L234:
        if (r131 != (-1)) goto L238;
    L235:
        String r102 = null;
    L241:
        if (r132 != (-1)) goto L245;
    L242:
        String r103 = null;
    L248:
        if (r133 != (-1)) goto L252;
    L249:
        String r104 = null;
    L255:
        if (r134 != (-1)) goto L259;
    L256:
        String r105 = null;
    L262:
        if (r135 != (-1)) goto L266;
    L263:
        String r106 = null;
    L269:
        if (r136 != (-1)) goto L273;
    L270:
        String r107 = null;
    L276:
        if (r137 != (-1)) goto L278;
        int r108 = 0;
    L280:
        if (r138 != (-1)) goto L284;
    L281:
        String r109 = null;
    L287:
        if (r139 != (-1)) goto L290;
    L292:
        RawMemoryEntity r22 = new RawMemoryEntity(r62, r64, r65, r67, r69, r70, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r21);
        if (r140 == (-1)) goto L300;
        if (r0.isNull(r140) == false) goto L297;
        Integer r23 = null;
    L298:
        r22.setPoisonLabel(r23);
        goto L300
    L297:
        r23 = Integer.valueOf(r0.getInt(r140));
    L300:
        if (r141 == (-1)) goto L307;
        if (r0.isNull(r141) == false) goto L304;
        Integer r24 = null;
    L305:
        r22.setPoisonLabelVersion(r24);
        goto L307
    L304:
        r24 = Integer.valueOf(r0.getInt(r141));
    L307:
        if (r142 == (-1)) goto L314;
        if (r0.isNull(r142) == true) goto L312;
        r20 = r0.getString(r142);
    L312:
        r22.setContentHash(r20);
    L314:
        return new com.obric.memorydata.database.backup.a.d(r56, r22, r59, r60);
    L290:
        if (r0.getInt(r139) == 0) goto L292;
        r21 = true;
        goto L292
    L284:
        if (r0.isNull(r138) == true) goto L281;
        r109 = r0.getString(r138);
        goto L287
    L278:
        r108 = r0.getInt(r137);
        goto L280
    L273:
        if (r0.isNull(r136) == true) goto L270;
        r107 = r0.getString(r136);
        goto L276
    L266:
        if (r0.isNull(r135) == true) goto L263;
        r106 = r0.getString(r135);
        goto L269
    L259:
        if (r0.isNull(r134) == true) goto L256;
        r105 = r0.getString(r134);
        goto L262
    L252:
        if (r0.isNull(r133) == true) goto L249;
        r104 = r0.getString(r133);
        goto L255
    L245:
        if (r0.isNull(r132) == true) goto L242;
        r103 = r0.getString(r132);
        goto L248
    L238:
        if (r0.isNull(r131) == true) goto L235;
        r102 = r0.getString(r131);
        goto L241
    L231:
        if (r0.isNull(r130) == true) goto L228;
        r101 = r0.getString(r130);
        goto L234
    L224:
        if (r0.isNull(r129) == true) goto L221;
        r100 = r0.getString(r129);
        goto L227
    L217:
        if (r0.isNull(r128) == true) goto L214;
        r99 = r0.getString(r128);
        goto L220
    L210:
        if (r0.isNull(r127) == true) goto L207;
        r98 = r0.getString(r127);
        goto L213
    L203:
        if (r0.isNull(r126) == true) goto L200;
        r97 = r0.getString(r126);
        goto L206
    L196:
        if (r0.isNull(r125) == true) goto L193;
        r96 = r0.getString(r125);
        goto L199
    L189:
        if (r0.isNull(r124) == true) goto L186;
        r95 = r0.getString(r124);
        goto L192
    L182:
        if (r0.isNull(r123) == true) goto L179;
        r94 = r0.getString(r123);
        goto L185
    L175:
        if (r0.isNull(r122) == true) goto L172;
        r93 = r0.getString(r122);
        goto L178
    L168:
        if (r0.isNull(r121) == true) goto L165;
        r92 = r0.getString(r121);
        goto L171
    L161:
        if (r0.isNull(r120) == true) goto L158;
        r91 = r0.getString(r120);
        goto L164
    L154:
        if (r0.isNull(r119) == true) goto L151;
        r90 = r0.getString(r119);
        goto L157
    L147:
        if (r0.isNull(r118) == true) goto L144;
        r89 = r0.getString(r118);
        goto L150
    L140:
        if (r0.isNull(r117) == true) goto L137;
        r88 = r0.getString(r117);
        goto L143
    L133:
        if (r0.isNull(r116) == true) goto L130;
        r87 = r0.getString(r116);
        goto L136
    L126:
        if (r0.isNull(r115) == true) goto L123;
        r86 = r0.getString(r115);
        goto L129
    L119:
        if (r0.isNull(r114) == true) goto L116;
        r85 = r0.getString(r114);
        goto L122
    L112:
        if (r0.isNull(r113) == true) goto L109;
        r84 = r0.getString(r113);
        goto L115
    L105:
        if (r0.isNull(r111) == true) goto L102;
        r83 = r0.getString(r111);
        goto L108
    L98:
        if (r0.isNull(r110) == true) goto L95;
        r82 = r0.getString(r110);
        goto L101
    L91:
        if (r0.isNull(r19) == true) goto L88;
        r81 = r0.getString(r19);
        goto L94
    L84:
        if (r0.isNull(r18) == true) goto L81;
        r80 = Long.valueOf(r0.getLong(r18));
        goto L87
    L77:
        if (r0.isNull(r17) == true) goto L74;
        r79 = Long.valueOf(r0.getLong(r17));
        goto L80
    L70:
        if (r0.isNull(r112) == true) goto L67;
        r78 = Long.valueOf(r0.getLong(r16));
        goto L73
    L63:
        if (r0.isNull(r111) == true) goto L61;
        r77 = Long.valueOf(r0.getLong(r15));
        goto L66
    L59:
        r76 = r0.getInt(r14);
        goto L60
    L56:
        r75 = r0.getInt(r13);
        goto L57
    L51:
        if (r0.isNull(r12) == true) goto L49;
        r74 = r0.getString(r12);
        goto L54
    L47:
        r73 = r0.getInt(r11);
        goto L48
    L42:
        if (r0.isNull(r10) == true) goto L40;
        r72 = r0.getString(r10);
        goto L45
    L34:
        r69 = r0.getInt(r8);
        goto L35
    L31:
        r67 = r0.getLong(r7);
        goto L32
    L28:
        r65 = r0.getLong(r6);
        goto L29
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r64 = r0.getString(r5);
        goto L26
    L19:
        r62 = r0.getLong(r4);
        goto L20
    L16:
        r60 = r0.getInt(r3);
        goto L17
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r59 = r0.getString(r2);
        goto L13
    L5:
        r56 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.backup.a.d> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBackUpRawMemoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.backup.a.d> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBackUpRawMemoryEntity_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(com.obric.memorydata.database.backup.a.d r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBackUpRawMemoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((com.obric.memorydata.database.backup.a.d) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.backup.a.d.class, "com.obric.memorydata.plugin"));
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

    public long insert(com.obric.memorydata.database.backup.a.d r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBackUpRawMemoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((com.obric.memorydata.database.backup.a.d) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.backup.a.d.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.backup.a.d> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBackUpRawMemoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.backup.a.d> queryAll() {
        return c.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return c.a.c(this);
    }

    public List<com.obric.memorydata.database.backup.a.d> queryByBackupUserId(String r1) {
        return c.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public List<com.obric.memorydata.database.backup.a.d> queryByBackupUserId(String r1, int r2, int r3) {
        return c.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.backup.a.d queryById(long r1) {
        return c.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.backup.a.d> queryByIds(List<Long> r3) {
        return c.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.backup.a.d queryByUUID(String r1) {
        return c.a.c(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.backup.a.d queryOne() {
        return c.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.backup.a.d> queryWithLimitAndOffset(int r1, int r2) {
        return c.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.backup.a.d> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseBackupEntityBackUpRawMemoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(com.obric.memorydata.database.backup.a.d r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBackUpRawMemoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((com.obric.memorydata.database.backup.a.d) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.backup.a.d.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.backup.a.d> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBackUpRawMemoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
