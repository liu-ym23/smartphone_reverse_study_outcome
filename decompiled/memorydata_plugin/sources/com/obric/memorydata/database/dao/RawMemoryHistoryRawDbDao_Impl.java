package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.gl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class RawMemoryHistoryRawDbDao_Impl implements RawMemoryHistoryRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<gl> __deletionAdapterOfRawMemoryHistoryEntity;
    private final EntityInsertionAdapter<gl> __insertionAdapterOfRawMemoryHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<gl> __updateAdapterOfRawMemoryHistoryEntity;

    public RawMemoryHistoryRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawMemoryHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawMemoryHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawMemoryHistoryEntity = new AnonymousClass3(this, r2);
    }

    private gl __entityCursorConverter_comObricMemorydataDatabaseEntityRawMemoryHistoryEntity(Cursor r106) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r106, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "memory_id");
        int r3 = CursorUtil.getColumnIndex(r0, "memory_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "memory_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "memory_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "memory_type");
        int r7 = CursorUtil.getColumnIndex(r0, "memory_timestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "memory_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "memory_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "memory_uuid");
        int r11 = CursorUtil.getColumnIndex(r0, "memory_memoryType");
        int r12 = CursorUtil.getColumnIndex(r0, "memory_productType");
        int r13 = CursorUtil.getColumnIndex(r0, "memory_startDate");
        int r14 = CursorUtil.getColumnIndex(r0, "memory_startTime");
        int r15 = CursorUtil.getColumnIndex(r0, "memory_endDate");
        int r16 = CursorUtil.getColumnIndex(r0, "memory_endTime");
        int r17 = CursorUtil.getColumnIndex(r0, "memory_sourceLinkType");
        int r18 = CursorUtil.getColumnIndex(r0, "memory_sourceLink");
        int r19 = CursorUtil.getColumnIndex(r0, "memory_screenshot");
        int r110 = CursorUtil.getColumnIndex(r0, "memory_locations");
        int r111 = CursorUtil.getColumnIndex(r0, "memory_summary");
        int r112 = CursorUtil.getColumnIndex(r0, "memory_fullContent");
        int r113 = CursorUtil.getColumnIndex(r0, "memory_key1");
        int r114 = CursorUtil.getColumnIndex(r0, "memory_key2");
        int r115 = CursorUtil.getColumnIndex(r0, "memory_key3");
        int r116 = CursorUtil.getColumnIndex(r0, "memory_key4");
        int r117 = CursorUtil.getColumnIndex(r0, "memory_key5");
        int r118 = CursorUtil.getColumnIndex(r0, "memory_keyword1");
        int r119 = CursorUtil.getColumnIndex(r0, "memory_keyword2");
        int r120 = CursorUtil.getColumnIndex(r0, "memory_keyword3");
        int r121 = CursorUtil.getColumnIndex(r0, "memory_keyword4");
        int r122 = CursorUtil.getColumnIndex(r0, "memory_keyword5");
        int r123 = CursorUtil.getColumnIndex(r0, "memory_keyword6");
        int r124 = CursorUtil.getColumnIndex(r0, "memory_semantic1");
        int r125 = CursorUtil.getColumnIndex(r0, "memory_semantic2");
        int r126 = CursorUtil.getColumnIndex(r0, "memory_keywordAndSemantic1");
        int r127 = CursorUtil.getColumnIndex(r0, "memory_keywordAndSemantic2");
        int r128 = CursorUtil.getColumnIndex(r0, "memory_sourceText");
        int r129 = CursorUtil.getColumnIndex(r0, "memory_sourcePackageName");
        int r130 = CursorUtil.getColumnIndex(r0, "memory_sourceAppName");
        int r131 = CursorUtil.getColumnIndex(r0, "memory_logId");
        int r132 = CursorUtil.getColumnIndex(r0, "memory_sourceQuery");
        int r133 = CursorUtil.getColumnIndex(r0, "memory_detail");
        int r134 = CursorUtil.getColumnIndex(r0, "memory_detailStatus");
        int r135 = CursorUtil.getColumnIndex(r0, "memory_contentWithTime");
        int r136 = CursorUtil.getColumnIndex(r0, "memory_userEdit");
        int r137 = CursorUtil.getColumnIndex(r0, "memory_poison_label");
        int r138 = CursorUtil.getColumnIndex(r0, "memory_poison_label_version");
        int r139 = CursorUtil.getColumnIndex(r0, "memory_content_hash");
        long r48 = 0;
        if (r1 != (-1)) goto L5;
        long r53 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r56 = 0;
    L9:
        String r20 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r58 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r59 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r61 = 0;
    L22:
        boolean r21 = false;
        if (r6 != (-1)) goto L25;
        int r63 = 0;
    L26:
        if (r7 == (-1)) goto L29;
        r48 = r0.getLong(r7);
    L29:
        long r64 = r48;
        if (r8 != (-1)) goto L33;
    L31:
        String r66 = null;
    L36:
        if (r9 != (-1)) goto L38;
        int r67 = 0;
    L39:
        if (r10 != (-1)) goto L42;
    L40:
        String r68 = null;
    L45:
        if (r11 != (-1)) goto L47;
        int r69 = 0;
    L48:
        if (r12 != (-1)) goto L50;
        int r70 = 0;
    L51:
        if (r13 != (-1)) goto L54;
    L52:
        Long r71 = null;
    L57:
        if (r14 != (-1)) goto L60;
    L58:
        Long r72 = null;
    L63:
        if (r105 != (-1)) goto L66;
    L64:
        Long r73 = null;
    L69:
        if (r106 != (-1)) goto L73;
    L70:
        Long r74 = null;
    L76:
        if (r17 != (-1)) goto L80;
    L77:
        String r75 = null;
    L83:
        if (r18 != (-1)) goto L87;
    L84:
        String r76 = null;
    L90:
        if (r19 != (-1)) goto L94;
    L91:
        String r77 = null;
    L97:
        if (r110 != (-1)) goto L101;
    L98:
        String r78 = null;
    L104:
        if (r111 != (-1)) goto L108;
    L105:
        String r79 = null;
    L111:
        if (r112 != (-1)) goto L115;
    L112:
        String r80 = null;
    L118:
        if (r113 != (-1)) goto L122;
    L119:
        String r81 = null;
    L125:
        if (r114 != (-1)) goto L129;
    L126:
        String r82 = null;
    L132:
        if (r115 != (-1)) goto L136;
    L133:
        String r83 = null;
    L139:
        if (r116 != (-1)) goto L143;
    L140:
        String r84 = null;
    L146:
        if (r117 != (-1)) goto L150;
    L147:
        String r85 = null;
    L153:
        if (r118 != (-1)) goto L157;
    L154:
        String r86 = null;
    L160:
        if (r119 != (-1)) goto L164;
    L161:
        String r87 = null;
    L167:
        if (r120 != (-1)) goto L171;
    L168:
        String r88 = null;
    L174:
        if (r121 != (-1)) goto L178;
    L175:
        String r89 = null;
    L181:
        if (r122 != (-1)) goto L185;
    L182:
        String r90 = null;
    L188:
        if (r123 != (-1)) goto L192;
    L189:
        String r91 = null;
    L195:
        if (r124 != (-1)) goto L199;
    L196:
        String r92 = null;
    L202:
        if (r125 != (-1)) goto L206;
    L203:
        String r93 = null;
    L209:
        if (r126 != (-1)) goto L213;
    L210:
        String r94 = null;
    L216:
        if (r127 != (-1)) goto L220;
    L217:
        String r95 = null;
    L223:
        if (r128 != (-1)) goto L227;
    L224:
        String r96 = null;
    L230:
        if (r129 != (-1)) goto L234;
    L231:
        String r97 = null;
    L237:
        if (r130 != (-1)) goto L241;
    L238:
        String r98 = null;
    L244:
        if (r131 != (-1)) goto L248;
    L245:
        String r99 = null;
    L251:
        if (r132 != (-1)) goto L255;
    L252:
        String r100 = null;
    L258:
        if (r133 != (-1)) goto L262;
    L259:
        String r101 = null;
    L265:
        if (r134 != (-1)) goto L267;
        int r102 = 0;
    L269:
        if (r135 != (-1)) goto L273;
    L270:
        String r103 = null;
    L276:
        if (r136 != (-1)) goto L279;
    L281:
        RawMemoryEntity r22 = new RawMemoryEntity(r56, r58, r59, r61, r63, r64, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101, r102, r103, r21);
        if (r137 == (-1)) goto L289;
        if (r0.isNull(r137) == false) goto L286;
        Integer r23 = null;
    L287:
        r22.setPoisonLabel(r23);
        goto L289
    L286:
        r23 = Integer.valueOf(r0.getInt(r137));
    L289:
        if (r138 == (-1)) goto L296;
        if (r0.isNull(r138) == false) goto L293;
        Integer r24 = null;
    L294:
        r22.setPoisonLabelVersion(r24);
        goto L296
    L293:
        r24 = Integer.valueOf(r0.getInt(r138));
    L296:
        if (r139 == (-1)) goto L303;
        if (r0.isNull(r139) == true) goto L301;
        r20 = r0.getString(r139);
    L301:
        r22.setContentHash(r20);
    L303:
        return new gl(r53, r22);
    L279:
        if (r0.getInt(r136) == 0) goto L281;
        r21 = true;
        goto L281
    L273:
        if (r0.isNull(r135) == true) goto L270;
        r103 = r0.getString(r135);
        goto L276
    L267:
        r102 = r0.getInt(r134);
        goto L269
    L262:
        if (r0.isNull(r133) == true) goto L259;
        r101 = r0.getString(r133);
        goto L265
    L255:
        if (r0.isNull(r132) == true) goto L252;
        r100 = r0.getString(r132);
        goto L258
    L248:
        if (r0.isNull(r131) == true) goto L245;
        r99 = r0.getString(r131);
        goto L251
    L241:
        if (r0.isNull(r130) == true) goto L238;
        r98 = r0.getString(r130);
        goto L244
    L234:
        if (r0.isNull(r129) == true) goto L231;
        r97 = r0.getString(r129);
        goto L237
    L227:
        if (r0.isNull(r128) == true) goto L224;
        r96 = r0.getString(r128);
        goto L230
    L220:
        if (r0.isNull(r127) == true) goto L217;
        r95 = r0.getString(r127);
        goto L223
    L213:
        if (r0.isNull(r126) == true) goto L210;
        r94 = r0.getString(r126);
        goto L216
    L206:
        if (r0.isNull(r125) == true) goto L203;
        r93 = r0.getString(r125);
        goto L209
    L199:
        if (r0.isNull(r124) == true) goto L196;
        r92 = r0.getString(r124);
        goto L202
    L192:
        if (r0.isNull(r123) == true) goto L189;
        r91 = r0.getString(r123);
        goto L195
    L185:
        if (r0.isNull(r122) == true) goto L182;
        r90 = r0.getString(r122);
        goto L188
    L178:
        if (r0.isNull(r121) == true) goto L175;
        r89 = r0.getString(r121);
        goto L181
    L171:
        if (r0.isNull(r120) == true) goto L168;
        r88 = r0.getString(r120);
        goto L174
    L164:
        if (r0.isNull(r119) == true) goto L161;
        r87 = r0.getString(r119);
        goto L167
    L157:
        if (r0.isNull(r118) == true) goto L154;
        r86 = r0.getString(r118);
        goto L160
    L150:
        if (r0.isNull(r117) == true) goto L147;
        r85 = r0.getString(r117);
        goto L153
    L143:
        if (r0.isNull(r116) == true) goto L140;
        r84 = r0.getString(r116);
        goto L146
    L136:
        if (r0.isNull(r115) == true) goto L133;
        r83 = r0.getString(r115);
        goto L139
    L129:
        if (r0.isNull(r114) == true) goto L126;
        r82 = r0.getString(r114);
        goto L132
    L122:
        if (r0.isNull(r113) == true) goto L119;
        r81 = r0.getString(r113);
        goto L125
    L115:
        if (r0.isNull(r112) == true) goto L112;
        r80 = r0.getString(r112);
        goto L118
    L108:
        if (r0.isNull(r111) == true) goto L105;
        r79 = r0.getString(r111);
        goto L111
    L101:
        if (r0.isNull(r110) == true) goto L98;
        r78 = r0.getString(r110);
        goto L104
    L94:
        if (r0.isNull(r19) == true) goto L91;
        r77 = r0.getString(r19);
        goto L97
    L87:
        if (r0.isNull(r18) == true) goto L84;
        r76 = r0.getString(r18);
        goto L90
    L80:
        if (r0.isNull(r17) == true) goto L77;
        r75 = r0.getString(r17);
        goto L83
    L73:
        if (r0.isNull(r106) == true) goto L70;
        r74 = Long.valueOf(r0.getLong(r16));
        goto L76
    L66:
        if (r0.isNull(r105) == true) goto L64;
        r73 = Long.valueOf(r0.getLong(r15));
        goto L69
    L60:
        if (r0.isNull(r14) == true) goto L58;
        r72 = Long.valueOf(r0.getLong(r14));
        goto L63
    L54:
        if (r0.isNull(r13) == true) goto L52;
        r71 = Long.valueOf(r0.getLong(r13));
        goto L57
    L50:
        r70 = r0.getInt(r12);
        goto L51
    L47:
        r69 = r0.getInt(r11);
        goto L48
    L42:
        if (r0.isNull(r10) == true) goto L40;
        r68 = r0.getString(r10);
        goto L45
    L38:
        r67 = r0.getInt(r9);
        goto L39
    L33:
        if (r0.isNull(r8) == true) goto L31;
        r66 = r0.getString(r8);
        goto L36
    L25:
        r63 = r0.getInt(r6);
        goto L26
    L21:
        r61 = r0.getLong(r5);
        goto L22
    L18:
        r59 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r58 = r0.getString(r3);
        goto L16
    L8:
        r56 = r0.getLong(r2);
        goto L9
    L5:
        r53 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<gl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawMemoryHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<gl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawMemoryHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(gl r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawMemoryHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((gl) ZeusTransformUtils.preCheckCast(r3, gl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return RawMemoryHistoryRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return RawMemoryHistoryRawDbDao.DefaultImpls.deleteByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return RawMemoryHistoryRawDbDao.DefaultImpls.deleteByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return RawMemoryHistoryRawDbDao.DefaultImpls.deleteByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return RawMemoryHistoryRawDbDao.DefaultImpls.deleteById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.RawMemoryHistoryRawDbDao, com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return RawMemoryHistoryRawDbDao.DefaultImpls.getPrefix(this);
    }

    @Override // com.obric.memorydata.database.dao.RawMemoryHistoryRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return RawMemoryHistoryRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(gl r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawMemoryHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((gl) ZeusTransformUtils.preCheckCast(r3, gl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<gl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawMemoryHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gl> queryAll() {
        return RawMemoryHistoryRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return RawMemoryHistoryRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<gl> queryByEntityId(String r1, String r2) {
        return RawMemoryHistoryRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<gl> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return RawMemoryHistoryRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gl queryById(long r1) {
        return RawMemoryHistoryRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gl> queryByIds(List<Long> r3) {
        return RawMemoryHistoryRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gl queryByUUID(String r1) {
        return RawMemoryHistoryRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public gl queryOne() {
        return RawMemoryHistoryRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gl> queryWithLimitAndOffset(int r1, int r2) {
        return RawMemoryHistoryRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<gl> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawMemoryHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(gl r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawMemoryHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((gl) ZeusTransformUtils.preCheckCast(r3, gl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<gl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawMemoryHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
