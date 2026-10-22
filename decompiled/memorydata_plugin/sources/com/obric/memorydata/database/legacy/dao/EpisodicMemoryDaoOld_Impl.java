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
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.legacy.entity.EpisodicMemoryEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EpisodicMemoryDaoOld_Impl implements q {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<EpisodicMemoryEntityOld> __deletionAdapterOfEpisodicMemoryEntityOld;
    private final EntityInsertionAdapter<EpisodicMemoryEntityOld> __insertionAdapterOfEpisodicMemoryEntityOld;
    private final EntityDeletionOrUpdateAdapter<EpisodicMemoryEntityOld> __updateAdapterOfEpisodicMemoryEntityOld;

    public EpisodicMemoryDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfEpisodicMemoryEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfEpisodicMemoryEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfEpisodicMemoryEntityOld = new AnonymousClass3(this, r2);
    }

    private EpisodicMemoryEntityOld __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityEpisodicMemoryEntityOld(Cursor r89) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r89, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "actionTimestamp");
        int r3 = CursorUtil.getColumnIndex(r0, "uid");
        int r4 = CursorUtil.getColumnIndex(r0, "title");
        int r5 = CursorUtil.getColumnIndex(r0, Params.CONTENT);
        int r6 = CursorUtil.getColumnIndex(r0, "contentWithTime");
        int r7 = CursorUtil.getColumnIndex(r0, "fullContent");
        int r8 = CursorUtil.getColumnIndex(r0, "observation");
        int r9 = CursorUtil.getColumnIndex(r0, "location");
        int r10 = CursorUtil.getColumnIndex(r0, "appNames");
        int r11 = CursorUtil.getColumnIndex(r0, EventBody.KEY_CATEGORY);
        int r12 = CursorUtil.getColumnIndex(r0, "profileType");
        int r13 = CursorUtil.getColumnIndex(r0, "profileTag");
        int r14 = CursorUtil.getColumnIndex(r0, "tagOther");
        int r15 = CursorUtil.getColumnIndex(r0, "logId");
        int r16 = CursorUtil.getColumnIndex(r0, "usedForPortrait");
        int r17 = CursorUtil.getColumnIndex(r0, "useLocation");
        int r18 = CursorUtil.getColumnIndex(r0, "useForUserKeyword");
        int r19 = CursorUtil.getColumnIndex(r0, "startTimestamp");
        int r110 = CursorUtil.getColumnIndex(r0, "endTimestamp");
        int r111 = CursorUtil.getColumnIndex(r0, "useForTopic");
        int r112 = CursorUtil.getColumnIndex(r0, "entityId");
        int r113 = CursorUtil.getColumnIndex(r0, "createTime");
        int r114 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r115 = CursorUtil.getColumnIndex(r0, "type");
        int r116 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r117 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r118 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r119 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r120 = CursorUtil.getColumnIndex(r0, "userEdit");
        int r121 = CursorUtil.getColumnIndex(r0, "productType");
        int r122 = CursorUtil.getColumnIndex(r0, "important_raw_ref_ids");
        int r123 = CursorUtil.getColumnIndex(r0, "source_raw_ref_ids");
        int r124 = CursorUtil.getColumnIndex(r0, "scene_ids");
        int r125 = CursorUtil.getColumnIndex(r0, "sourcePackageName");
        int r126 = CursorUtil.getColumnIndex(r0, "personalDbSplitMigrated");
        int r127 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r128 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r129 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r38 = 0;
        if (r1 != (-1)) goto L5;
        long r44 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r46 = 0;
    L9:
        if (r3 != (-1)) goto L11;
        long r48 = 0;
    L12:
        String r20 = null;
        if (r4 != (-1)) goto L16;
    L14:
        String r50 = null;
    L19:
        if (r5 != (-1)) goto L22;
    L20:
        String r51 = null;
    L25:
        if (r6 != (-1)) goto L28;
    L26:
        String r52 = null;
    L31:
        if (r7 != (-1)) goto L34;
    L32:
        String r53 = null;
    L37:
        if (r8 != (-1)) goto L40;
    L38:
        String r54 = null;
    L43:
        if (r9 != (-1)) goto L46;
    L44:
        String r55 = null;
    L49:
        if (r10 != (-1)) goto L52;
    L50:
        String r56 = null;
    L55:
        if (r11 != (-1)) goto L58;
    L56:
        Integer r57 = null;
    L61:
        if (r12 != (-1)) goto L64;
    L62:
        Integer r58 = null;
    L67:
        if (r13 != (-1)) goto L70;
    L68:
        String r59 = null;
    L73:
        if (r14 != (-1)) goto L76;
    L74:
        String r60 = null;
    L79:
        if (r88 != (-1)) goto L82;
    L80:
        String r61 = null;
    L85:
        boolean r21 = true;
        if (r16 != (-1)) goto L90;
        Boolean r62 = null;
    L101:
        if (r17 != (-1)) goto L105;
        Boolean r63 = null;
    L116:
        if (r18 != (-1)) goto L120;
        boolean r64 = false;
    L124:
        if (r19 != (-1)) goto L126;
        long r65 = 0;
    L127:
        if (r19 != (-1)) goto L129;
        long r67 = 0;
    L130:
        if (r20 != (-1)) goto L134;
        Boolean r69 = null;
    L145:
        if (r112 != (-1)) goto L149;
    L146:
        String r70 = null;
    L152:
        if (r113 != (-1)) goto L154;
        long r71 = 0;
    L155:
        if (r23 != (-1)) goto L157;
        long r73 = 0;
    L158:
        if (r24 != (-1)) goto L160;
        int r75 = 0;
    L162:
        if (r116 == (-1)) goto L165;
        r38 = r0.getLong(r116);
    L165:
        long r76 = r38;
        if (r117 != (-1)) goto L170;
    L167:
        String r78 = null;
    L173:
        if (r118 != (-1)) goto L175;
        int r79 = 0;
    L177:
        if (r119 != (-1)) goto L181;
    L178:
        String r80 = null;
    L184:
        if (r120 != (-1)) goto L188;
        Boolean r81 = null;
    L199:
        if (r121 != (-1)) goto L201;
        int r82 = 0;
    L203:
        if (r122 != (-1)) goto L207;
    L204:
        String r83 = null;
    L210:
        if (r123 != (-1)) goto L214;
    L211:
        String r84 = null;
    L217:
        if (r124 != (-1)) goto L221;
    L218:
        String r85 = null;
    L224:
        if (r125 != (-1)) goto L228;
    L225:
        String r86 = null;
    L231:
        if (r126 != (-1)) goto L234;
        boolean r87 = false;
    L238:
        EpisodicMemoryEntityOld r22 = new EpisodicMemoryEntityOld(r44, r46, r48, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r67, r69, r70, r71, r73, r75, r76, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87);
        if (r127 == (-1)) goto L246;
        if (r0.isNull(r127) == false) goto L243;
        Integer r23 = null;
    L244:
        r22.setPoisonLabel(r23);
        goto L246
    L243:
        r23 = Integer.valueOf(r0.getInt(r127));
    L246:
        if (r128 == (-1)) goto L253;
        if (r0.isNull(r128) == false) goto L250;
        Integer r24 = null;
    L251:
        r22.setPoisonLabelVersion(r24);
        goto L253
    L250:
        r24 = Integer.valueOf(r0.getInt(r128));
    L253:
        if (r129 != (-1)) goto L255;
    L259:
        return r22;
    L255:
        if (r0.isNull(r129) == true) goto L258;
        r20 = r0.getString(r129);
    L258:
        r22.setContentHash(r20);
        goto L259
    L234:
        if (r0.getInt(r126) != 0) goto L237;
        r21 = false;
    L237:
        r87 = r21;
        goto L238
    L228:
        if (r0.isNull(r125) == true) goto L225;
        r86 = r0.getString(r125);
        goto L231
    L221:
        if (r0.isNull(r124) == true) goto L218;
        r85 = r0.getString(r124);
        goto L224
    L214:
        if (r0.isNull(r123) == true) goto L211;
        r84 = r0.getString(r123);
        goto L217
    L207:
        if (r0.isNull(r122) == true) goto L204;
        r83 = r0.getString(r122);
        goto L210
    L201:
        r82 = r0.getInt(r121);
        goto L203
    L188:
        if (r0.isNull(r120) == false) goto L190;
        Integer r25 = null;
    L191:
        if (r25 != null) goto L194;
        Boolean r26 = null;
    L198:
        r81 = r26;
        goto L199
    L194:
        if (r25.intValue() == 0) goto L196;
        boolean r27 = true;
    L197:
        r26 = Boolean.valueOf(r27);
        goto L198
    L196:
        r27 = false;
        goto L197
    L190:
        r25 = Integer.valueOf(r0.getInt(r120));
        goto L191
    L181:
        if (r0.isNull(r119) == true) goto L178;
        r80 = r0.getString(r119);
        goto L184
    L175:
        r79 = r0.getInt(r118);
        goto L177
    L170:
        if (r0.isNull(r117) == true) goto L167;
        r78 = r0.getString(r117);
        goto L173
    L160:
        r75 = r0.getInt(r115);
        goto L162
    L157:
        r73 = r0.getLong(r114);
        goto L158
    L154:
        r71 = r0.getLong(r113);
        goto L155
    L149:
        if (r0.isNull(r112) == true) goto L146;
        r70 = r0.getString(r112);
        goto L152
    L134:
        if (r0.isNull(r20) == false) goto L136;
        Integer r28 = null;
    L137:
        if (r28 != null) goto L140;
        Boolean r29 = null;
    L144:
        r69 = r29;
        goto L145
    L140:
        if (r28.intValue() == 0) goto L142;
        boolean r30 = true;
    L143:
        r29 = Boolean.valueOf(r30);
        goto L144
    L142:
        r30 = false;
        goto L143
    L136:
        r28 = Integer.valueOf(r0.getInt(r111));
        goto L137
    L129:
        r67 = r0.getLong(r110);
        goto L130
    L126:
        r65 = r0.getLong(r19);
        goto L127
    L120:
        if (r0.getInt(r18) == 0) goto L122;
        boolean r31 = true;
    L123:
        r64 = r31;
        goto L124
    L122:
        r31 = false;
        goto L123
    L105:
        if (r0.isNull(r17) == false) goto L107;
        Integer r32 = null;
    L108:
        if (r32 != null) goto L111;
        Boolean r33 = null;
    L115:
        r63 = r33;
        goto L116
    L111:
        if (r32.intValue() == 0) goto L113;
        boolean r34 = true;
    L114:
        r33 = Boolean.valueOf(r34);
        goto L115
    L113:
        r34 = false;
        goto L114
    L107:
        r32 = Integer.valueOf(r0.getInt(r17));
        goto L108
    L90:
        if (r0.isNull(r16) == false) goto L92;
        Integer r35 = null;
    L93:
        if (r35 != null) goto L96;
        Boolean r36 = null;
    L100:
        r62 = r36;
        goto L101
    L96:
        if (r35.intValue() == 0) goto L98;
        boolean r37 = true;
    L99:
        r36 = Boolean.valueOf(r37);
        goto L100
    L98:
        r37 = false;
        goto L99
    L92:
        r35 = Integer.valueOf(r0.getInt(r16));
        goto L93
    L82:
        if (r0.isNull(r88) == true) goto L80;
        r61 = r0.getString(r15);
        goto L85
    L76:
        if (r0.isNull(r14) == true) goto L74;
        r60 = r0.getString(r14);
        goto L79
    L70:
        if (r0.isNull(r13) == true) goto L68;
        r59 = r0.getString(r13);
        goto L73
    L64:
        if (r0.isNull(r12) == true) goto L62;
        r58 = Integer.valueOf(r0.getInt(r12));
        goto L67
    L58:
        if (r0.isNull(r11) == true) goto L56;
        r57 = Integer.valueOf(r0.getInt(r11));
        goto L61
    L52:
        if (r0.isNull(r10) == true) goto L50;
        r56 = r0.getString(r10);
        goto L55
    L46:
        if (r0.isNull(r9) == true) goto L44;
        r55 = r0.getString(r9);
        goto L49
    L40:
        if (r0.isNull(r8) == true) goto L38;
        r54 = r0.getString(r8);
        goto L43
    L34:
        if (r0.isNull(r7) == true) goto L32;
        r53 = r0.getString(r7);
        goto L37
    L28:
        if (r0.isNull(r6) == true) goto L26;
        r52 = r0.getString(r6);
        goto L31
    L22:
        if (r0.isNull(r5) == true) goto L20;
        r51 = r0.getString(r5);
        goto L25
    L16:
        if (r0.isNull(r4) == true) goto L14;
        r50 = r0.getString(r4);
        goto L19
    L11:
        r48 = r0.getLong(r3);
        goto L12
    L8:
        r46 = r0.getLong(r2);
        goto L9
    L5:
        r44 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<EpisodicMemoryEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfEpisodicMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<EpisodicMemoryEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfEpisodicMemoryEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(EpisodicMemoryEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfEpisodicMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(EpisodicMemoryEntityOld r3) {
        return delete2((EpisodicMemoryEntityOld) ZeusTransformUtils.preCheckCast(r3, EpisodicMemoryEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return q.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return q.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(EpisodicMemoryEntityOld r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfEpisodicMemoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(EpisodicMemoryEntityOld r3) {
        return insert2((EpisodicMemoryEntityOld) ZeusTransformUtils.preCheckCast(r3, EpisodicMemoryEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<EpisodicMemoryEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfEpisodicMemoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<EpisodicMemoryEntityOld> queryAll() {
        return q.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return q.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public EpisodicMemoryEntityOld queryById(long r1) {
        return q.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ EpisodicMemoryEntityOld queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<EpisodicMemoryEntityOld> queryByIds(List<Long> r3) {
        return q.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public EpisodicMemoryEntityOld queryByUUID(String r1) {
        return q.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ EpisodicMemoryEntityOld queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public EpisodicMemoryEntityOld queryOne() {
        return q.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ EpisodicMemoryEntityOld queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<EpisodicMemoryEntityOld> queryWithLimitAndOffset(int r1, int r2) {
        return q.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<EpisodicMemoryEntityOld> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityEpisodicMemoryEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(EpisodicMemoryEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfEpisodicMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(EpisodicMemoryEntityOld r3) {
        return update2((EpisodicMemoryEntityOld) ZeusTransformUtils.preCheckCast(r3, EpisodicMemoryEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<EpisodicMemoryEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfEpisodicMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
