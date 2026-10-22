package com.obric.memorydata.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.collection.ArrayMap;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.fa;
import com.obric.memorydata.database.entity.ih;
import com.obric.memorydata.database.entity.ip;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class SemanticMemoryDao_Impl implements SemanticMemoryDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ip> __deletionAdapterOfUnionSemanticMemoryEntity;
    private final EntityInsertionAdapter<ip> __insertionAdapterOfUnionSemanticMemoryEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllRaw;
    private final SharedSQLiteStatement __preparedStmtOfRequeueConflictKeeper;
    private final SharedSQLiteStatement __preparedStmtOfResetAllUseForInsight;
    private final SharedSQLiteStatement __preparedStmtOfResetAllUseForPersona;
    private final SharedSQLiteStatement __preparedStmtOfResetSequence;
    private final SharedSQLiteStatement __preparedStmtOfResetUseForInsightBySemanticType;
    private final SharedSQLiteStatement __preparedStmtOfResetUseForInsightBySemanticTypeAndTagPath;
    private final SharedSQLiteStatement __preparedStmtOfResetUseForPersonaBySemanticType;
    private final EntityDeletionOrUpdateAdapter<ip> __updateAdapterOfUnionSemanticMemoryEntity;

    public SemanticMemoryDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfUnionSemanticMemoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfUnionSemanticMemoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfUnionSemanticMemoryEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfResetAllUseForInsight = new AnonymousClass4(this, r2);
        this.__preparedStmtOfResetUseForInsightBySemanticType = new AnonymousClass5(this, r2);
        this.__preparedStmtOfResetUseForInsightBySemanticTypeAndTagPath = new AnonymousClass6(this, r2);
        this.__preparedStmtOfResetAllUseForPersona = new AnonymousClass7(this, r2);
        this.__preparedStmtOfResetUseForPersonaBySemanticType = new AnonymousClass8(this, r2);
        this.__preparedStmtOfRequeueConflictKeeper = new AnonymousClass9(this, r2);
        this.__preparedStmtOfDeleteAllRaw = new AnonymousClass10(this, r2);
        this.__preparedStmtOfResetSequence = new AnonymousClass11(this, r2);
    }

    private ip __entityCursorConverter_comObricMemorydataDatabaseEntityUnionSemanticMemoryEntity(Cursor r79) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r79, Cursor.class, "com.obric.memorydata.plugin");
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
        int r117 = CursorUtil.getColumnIndex(r0, "change_seq");
        int r118 = CursorUtil.getColumnIndex(r0, "confirmation_state");
        int r119 = CursorUtil.getColumnIndex(r0, "migration_version");
        int r120 = CursorUtil.getColumnIndex(r0, "evidence_ids");
        int r121 = CursorUtil.getColumnIndex(r0, "conflict_entity_ids");
        int r122 = CursorUtil.getColumnIndex(r0, "last_user_assert_at");
        int r123 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r124 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r125 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r34 = 0;
        if (r1 != (-1)) goto L5;
        long r40 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r42 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r43 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r45 = 0;
    L19:
        int r21 = 0;
        if (r5 != (-1)) goto L22;
        int r47 = 0;
    L23:
        if (r6 != (-1)) goto L25;
        long r48 = 0;
    L26:
        if (r7 != (-1)) goto L29;
    L27:
        String r50 = null;
    L32:
        if (r8 != (-1)) goto L34;
        int r51 = 0;
    L35:
        if (r9 != (-1)) goto L38;
    L36:
        String r52 = null;
    L41:
        if (r10 != (-1)) goto L44;
    L42:
        String r53 = null;
    L47:
        if (r11 != (-1)) goto L50;
    L48:
        String r54 = null;
    L53:
        if (r12 != (-1)) goto L56;
    L54:
        String r55 = null;
    L59:
        if (r13 != (-1)) goto L62;
    L60:
        String r56 = null;
    L65:
        if (r14 != (-1)) goto L68;
    L66:
        String r57 = null;
    L71:
        if (r78 != (-1)) goto L74;
    L72:
        String r58 = null;
    L77:
        boolean r22 = true;
        if (r16 != (-1)) goto L82;
        boolean r59 = false;
    L86:
        if (r17 != (-1)) goto L88;
        int r60 = 0;
    L90:
        if (r18 != (-1)) goto L92;
        int r61 = 0;
    L94:
        if (r19 != (-1)) goto L98;
        boolean r62 = false;
    L102:
        if (r110 != (-1)) goto L106;
        boolean r63 = false;
    L110:
        if (r111 != (-1)) goto L112;
        float r23 = 0.0f;
    L113:
        float r64 = r23;
        if (r112 != (-1)) goto L118;
    L115:
        String r65 = null;
    L121:
        if (r113 != (-1)) goto L125;
    L122:
        String r66 = null;
    L128:
        if (r114 != (-1)) goto L132;
    L129:
        String r67 = null;
    L135:
        if (r115 != (-1)) goto L139;
    L136:
        String r68 = null;
    L142:
        if (r116 != (-1)) goto L146;
    L143:
        String r69 = null;
    L149:
        if (r117 != (-1)) goto L151;
        long r70 = 0;
    L152:
        if (r27 != (-1)) goto L156;
    L153:
        String r72 = null;
    L159:
        if (r119 == (-1)) goto L162;
        r21 = r0.getInt(r119);
    L162:
        int r73 = r21;
        if (r120 != (-1)) goto L167;
    L164:
        String r74 = null;
    L170:
        if (r121 != (-1)) goto L174;
    L171:
        String r75 = null;
    L177:
        if (r122 == (-1)) goto L180;
        r34 = r0.getLong(r122);
    L180:
        ip r24 = new ip(r40, r42, r43, r45, r47, r48, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r72, r73, r74, r75, r34);
        if (r123 == (-1)) goto L188;
        if (r0.isNull(r123) == false) goto L185;
        Integer r25 = null;
    L186:
        r24.setPoisonLabel(r25);
        goto L188
    L185:
        r25 = Integer.valueOf(r0.getInt(r123));
    L188:
        if (r124 == (-1)) goto L195;
        if (r0.isNull(r124) == false) goto L192;
        Integer r26 = null;
    L193:
        r24.setPoisonLabelVersion(r26);
        goto L195
    L192:
        r26 = Integer.valueOf(r0.getInt(r124));
    L195:
        if (r125 != (-1)) goto L197;
    L201:
        return r24;
    L197:
        if (r0.isNull(r125) == true) goto L200;
        r20 = r0.getString(r125);
    L200:
        r24.setContentHash(r20);
        goto L201
    L174:
        if (r0.isNull(r121) == true) goto L171;
        r75 = r0.getString(r121);
        goto L177
    L167:
        if (r0.isNull(r120) == true) goto L164;
        r74 = r0.getString(r120);
        goto L170
    L156:
        if (r0.isNull(r27) == true) goto L153;
        r72 = r0.getString(r118);
        goto L159
    L151:
        r70 = r0.getLong(r117);
        goto L152
    L146:
        if (r0.isNull(r116) == true) goto L143;
        r69 = r0.getString(r116);
        goto L149
    L139:
        if (r0.isNull(r115) == true) goto L136;
        r68 = r0.getString(r115);
        goto L142
    L132:
        if (r0.isNull(r114) == true) goto L129;
        r67 = r0.getString(r114);
        goto L135
    L125:
        if (r0.isNull(r113) == true) goto L122;
        r66 = r0.getString(r113);
        goto L128
    L118:
        if (r0.isNull(r112) == true) goto L115;
        r65 = r0.getString(r112);
        goto L121
    L112:
        r23 = r0.getFloat(r111);
        goto L113
    L106:
        if (r0.getInt(r110) != 0) goto L109;
        r22 = false;
    L109:
        r63 = r22;
        goto L110
    L98:
        if (r0.getInt(r19) == 0) goto L100;
        boolean r27 = true;
    L101:
        r62 = r27;
        goto L102
    L100:
        r27 = false;
        goto L101
    L92:
        r61 = r0.getInt(r18);
        goto L94
    L88:
        r60 = r0.getInt(r17);
        goto L90
    L82:
        if (r0.getInt(r16) == 0) goto L84;
        boolean r28 = true;
    L85:
        r59 = r28;
        goto L86
    L84:
        r28 = false;
        goto L85
    L74:
        if (r0.isNull(r78) == true) goto L72;
        r58 = r0.getString(r15);
        goto L77
    L68:
        if (r0.isNull(r14) == true) goto L66;
        r57 = r0.getString(r14);
        goto L71
    L62:
        if (r0.isNull(r13) == true) goto L60;
        r56 = r0.getString(r13);
        goto L65
    L56:
        if (r0.isNull(r12) == true) goto L54;
        r55 = r0.getString(r12);
        goto L59
    L50:
        if (r0.isNull(r11) == true) goto L48;
        r54 = r0.getString(r11);
        goto L53
    L44:
        if (r0.isNull(r10) == true) goto L42;
        r53 = r0.getString(r10);
        goto L47
    L38:
        if (r0.isNull(r9) == true) goto L36;
        r52 = r0.getString(r9);
        goto L41
    L34:
        r51 = r0.getInt(r8);
        goto L35
    L29:
        if (r0.isNull(r7) == true) goto L27;
        r50 = r0.getString(r7);
        goto L32
    L25:
        r48 = r0.getLong(r6);
        goto L26
    L22:
        r47 = r0.getInt(r5);
        goto L23
    L18:
        r45 = r0.getLong(r4);
        goto L19
    L15:
        r43 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r42 = r0.getString(r2);
        goto L13
    L5:
        r40 = r0.getLong(r1);
        goto L6
    }

    private void __fetchRelationshipProactiveSemanticRelevantDataAscomObricMemorydataDatabaseEntityProactiveSemanticRelevantData(ArrayMap<String, ArrayList<fa>> r20) {
        Set<String> r2 = r20.keySet();
        if (r2.isEmpty() == false) goto L6;
        return;
    L6:
        if (r20.size() <= 999) goto L15;
        ArrayMap<String, ArrayList<fa>> r3 = new ArrayMap(999);
        int r4 = r20.size();
        int r7 = 0;
        int r8 = 0;
    L8:
        if (r7 >= r4) goto L12;
        r3.put((String) ZeusTransformUtils.preCheckCast(r20.keyAt(r7), String.class, "com.obric.memorydata.plugin"), (ArrayList) ZeusTransformUtils.preCheckCast(r20.valueAt(r7), ArrayList.class, "com.obric.memorydata.plugin"));
        r7 = r7 + 1;
        r8 = r8 + 1;
        if (r8 != 999) goto L8;
        __fetchRelationshipProactiveSemanticRelevantDataAscomObricMemorydataDatabaseEntityProactiveSemanticRelevantData(r3);
        r3 = new ArrayMap(999);
        r8 = 0;
        goto L8
    L12:
        if (r8 <= 0) goto L79;
        __fetchRelationshipProactiveSemanticRelevantDataAscomObricMemorydataDatabaseEntityProactiveSemanticRelevantData(r3);
        return;
    L79:
        return;
    L15:
        StringBuilder r5 = StringUtil.newStringBuilder();
        r5.append("SELECT `id`,`semantic_id`,`source_query`,`source_text`,`source_screenshot`,`source_app_name`,`source_package_name`,`detail_status`,`product_type` FROM `ProactiveSemanticRelevantData` WHERE `semantic_id` IN (");
        int r6 = r2.size();
        StringUtil.appendPlaceholders(r5, r6);
        r5.append(")");
        RoomSQLiteQuery r9 = RoomSQLiteQuery.acquire(r5.toString(), r6 + 0);
        Iterator<String> r10 = r2.iterator();
        int r11 = 1;
    L17:
        if (r10.hasNext() == false) goto L23;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L21;
        r9.bindNull(r11);
    L22:
        r11 = r11 + 1;
        goto L17
    L21:
        r9.bindString(r11, r12);
        goto L22
    L23:
        Cursor r13 = DBUtil.query(this.__db, r9, false, null);
        int r0 = CursorUtil.getColumnIndex(r13, "semantic_id");     // Catch: Throwable -> L61
        if (r0 != (-1)) goto L29;
        r13.close();
        return;
    L29:
        if (r13.moveToNext() == false) goto L59;
        ArrayList r14 = (ArrayList) ZeusTransformUtils.preCheckCast(r20.get(r13.getString(r0)), ArrayList.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L61
        if (r14 == null) goto L29;
        long r15 = r13.getLong(0);     // Catch: Throwable -> L61
        if (r13.isNull(1) == false) goto L36;
        String r16 = null;
    L38:
        if (r13.isNull(2) == false) goto L40;
        String r17 = null;
    L42:
        if (r13.isNull(3) == false) goto L44;
        String r18 = null;
    L46:
        if (r13.isNull(4) == false) goto L48;
        String r19 = null;
    L50:
        if (r13.isNull(5) == false) goto L52;
        String r110 = null;
    L54:
        if (r13.isNull(6) == false) goto L56;
        String r111 = null;
    L57:
        r14.add(new fa(r15, r16, r17, r18, r19, r110, r111, r13.getInt(7), r13.getInt(8)));     // Catch: Throwable -> L61
        goto L29
    L56:
        r111 = r13.getString(6);     // Catch: Throwable -> L61
        goto L57
    L52:
        r110 = r13.getString(5);     // Catch: Throwable -> L61
        goto L54
    L48:
        r19 = r13.getString(4);     // Catch: Throwable -> L61
        goto L50
    L44:
        r18 = r13.getString(3);     // Catch: Throwable -> L61
        goto L46
    L40:
        r17 = r13.getString(2);     // Catch: Throwable -> L61
        goto L42
    L36:
        r16 = r13.getString(1);     // Catch: Throwable -> L61
        goto L38
    L59:
        r13.close();
        return;
    L61:
        th = move-exception;
        r13.close();
        throw th;
    }

    static /* synthetic */ RoomDatabase access$000(SemanticMemoryDao_Impl r0) {
        return r0.__db;
    }

    static /* synthetic */ void access$100(SemanticMemoryDao_Impl r0, ArrayMap r1) {
        r0.__fetchRelationshipProactiveSemanticRelevantDataAscomObricMemorydataDatabaseEntityProactiveSemanticRelevantData(r1);
    }

    static /* synthetic */ ip access$200(SemanticMemoryDao_Impl r2, Cursor r3) {
        return r2.__entityCursorConverter_comObricMemorydataDatabaseEntityUnionSemanticMemoryEntity((Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin"));
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return SemanticMemoryDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public SimpleSQLiteQuery buildSemanticTypeRangeQuery(String r1, Integer r2, Integer r3) {
        return SemanticMemoryDao.DefaultImpls.buildSemanticTypeRangeQuery(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao, com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ip> r3) {
        SemanticMemoryDao.DefaultImpls.bulkDelete(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public void bulkDeleteRaw(List<ip> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfUnionSemanticMemoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao, com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ip> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        SemanticMemoryDao.DefaultImpls.bulkInsert(this, r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int countAllInfoSync() {
        int r1 = 0;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM UnionSemanticMemory WHERE product_type != 1004 AND confidence = 4.0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L8:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L6;
        r1 = r3.getInt(0);     // Catch: Throwable -> L8
    L6:
        r3.close();
        r0.release();
        return r1;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int countBySemanticTypeSync(String r3) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM UnionSemanticMemory WHERE semantic_type = ? AND product_type != 1004 AND confidence = 4.0", 1);
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        int r1 = 0;
        Cursor r2 = DBUtil.query(this.__db, r0, false, null);
    L12:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    L8:
        if (r2.moveToFirst() == false) goto L10;
        r1 = r2.getInt(0);     // Catch: Throwable -> L12
    L10:
        r2.close();
        r0.release();
        return r1;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int countMigrationCompleted() {
        int r1 = 0;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM UnionSemanticMemory WHERE migration_version >= 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L8:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L6;
        r1 = r3.getInt(0);     // Catch: Throwable -> L8
    L6:
        r3.close();
        r0.release();
        return r1;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int countMigrationTotal() {
        int r1 = 0;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM UnionSemanticMemory", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L8:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L6;
        r1 = r3.getInt(0);     // Catch: Throwable -> L8
    L6:
        r3.close();
        r0.release();
        return r1;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int countPendingConfirmation() {
        int r1 = 0;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM UnionSemanticMemory WHERE confidence = 3.0 AND confirmation_state = 'pending'", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L8:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L6;
        r1 = r3.getInt(0);     // Catch: Throwable -> L8
    L6:
        r3.close();
        r0.release();
        return r1;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int delete(SupportSQLiteQuery r3) {
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

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int delete(ip r1) {
        return SemanticMemoryDao.DefaultImpls.delete(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(Object r3) {
        return delete((ip) ZeusTransformUtils.preCheckCast(r3, ip.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao, com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return SemanticMemoryDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int deleteAllRaw() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteAllRaw.acquire();
        this.__db.beginTransaction();
        int r1 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllRaw.release(r0);
        return r1;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAllRaw.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public void deleteByEntityIds(List<String> r3) {
        SemanticMemoryDao.DefaultImpls.deleteByEntityIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao, com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return SemanticMemoryDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int deleteEntityByEntityIdsRaw(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM UnionSemanticMemory WHERE entityId IN (");
        StringUtil.appendPlaceholders(r0, r7.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        Iterator r8 = r7.iterator();
        int r3 = 1;
    L4:
        if (r8.hasNext() == false) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r2.bindNull(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r2.bindString(r3, r4);
        goto L9
    L10:
        this.__db.beginTransaction();
        int r9 = r2.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        return r9;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int deleteRaw(ip r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfUnionSemanticMemoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public boolean exists(String r4) {
        boolean r1 = true;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT 1 FROM UnionSemanticMemory WHERE entityId = ?)", 1);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        boolean r2 = false;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L16:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L8:
        if (r3.moveToFirst() == false) goto L14;
        if (r3.getInt(0) != 0) goto L13;
        r1 = false;
    L13:
        r2 = r1;
    L14:
        r3.close();
        r0.release();
        return r2;
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<ip> getAllOrderByUserEditAndModifyTime() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM UnionSemanticMemory ORDER BY user_edit DESC, modifyTime DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L108
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "entityId");     // Catch: Throwable -> L108
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "createTime");     // Catch: Throwable -> L108
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "modifyTime");     // Catch: Throwable -> L108
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "type");     // Catch: Throwable -> L108
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L108
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L108
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "hashCodeValue");     // Catch: Throwable -> L108
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, Api.KEY_UUID);     // Catch: Throwable -> L108
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "semantic_type");     // Catch: Throwable -> L108
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "tag_path");     // Catch: Throwable -> L108
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, "key_phrase");     // Catch: Throwable -> L108
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "description");     // Catch: Throwable -> L108
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "embedding_content");     // Catch: Throwable -> L108
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "sources");     // Catch: Throwable -> L106
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "user_edit");     // Catch: Throwable -> L106
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "evidence_count");     // Catch: Throwable -> L106
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "product_type");     // Catch: Throwable -> L106
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "use_for_insight");     // Catch: Throwable -> L106
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "use_for_persona");     // Catch: Throwable -> L106
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "confidence");     // Catch: Throwable -> L106
        int r24 = CursorUtil.getColumnIndexOrThrow(r4, "logId");     // Catch: Throwable -> L106
        int r25 = CursorUtil.getColumnIndexOrThrow(r4, "important_raw_ref_ids");     // Catch: Throwable -> L106
        int r26 = CursorUtil.getColumnIndexOrThrow(r4, "source_raw_ref_ids");     // Catch: Throwable -> L106
        int r27 = CursorUtil.getColumnIndexOrThrow(r4, "scene_ids");     // Catch: Throwable -> L106
        int r28 = CursorUtil.getColumnIndexOrThrow(r4, "sourcePackageName");     // Catch: Throwable -> L106
        int r29 = CursorUtil.getColumnIndexOrThrow(r4, "change_seq");     // Catch: Throwable -> L106
        int r30 = CursorUtil.getColumnIndexOrThrow(r4, "confirmation_state");     // Catch: Throwable -> L106
        int r31 = CursorUtil.getColumnIndexOrThrow(r4, "migration_version");     // Catch: Throwable -> L106
        int r32 = CursorUtil.getColumnIndexOrThrow(r4, "evidence_ids");     // Catch: Throwable -> L106
        int r33 = CursorUtil.getColumnIndexOrThrow(r4, "conflict_entity_ids");     // Catch: Throwable -> L106
        int r34 = CursorUtil.getColumnIndexOrThrow(r4, "last_user_assert_at");     // Catch: Throwable -> L106
        int r35 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label");     // Catch: Throwable -> L106
        int r36 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label_version");     // Catch: Throwable -> L106
        int r37 = CursorUtil.getColumnIndexOrThrow(r4, "content_hash");     // Catch: Throwable -> L106
        int r38 = r3;
        ArrayList r39 = new ArrayList(r4.getCount());     // Catch: Throwable -> L106
    L6:
        if (r4.moveToNext() == false) goto L104;
        long r40 = r4.getLong(r0);     // Catch: Throwable -> L106
        if (r4.isNull(r5) == false) goto L11;
        String r42 = null;
    L12:
        long r43 = r4.getLong(r6);     // Catch: Throwable -> L106
        long r45 = r4.getLong(r7);     // Catch: Throwable -> L106
        int r47 = r4.getInt(r8);     // Catch: Throwable -> L106
        long r48 = r4.getLong(r9);     // Catch: Throwable -> L106
        if (r4.isNull(r10) == false) goto L15;
        String r50 = null;
    L16:
        int r51 = r4.getInt(r11);     // Catch: Throwable -> L106
        if (r4.isNull(r12) == false) goto L19;
        String r52 = null;
    L21:
        if (r4.isNull(r13) == false) goto L23;
        String r53 = null;
    L25:
        if (r4.isNull(r14) == false) goto L27;
        String r54 = null;
    L29:
        if (r4.isNull(r15) == false) goto L31;
        String r55 = null;
    L33:
        if (r4.isNull(r2) == false) goto L35;
        String r56 = null;
    L37:
        if (r4.isNull(r38) == false) goto L40;
        String r57 = null;
    L39:
        int r78 = r17;
        int r110 = r0;
        if (r4.isNull(r78) == false) goto L45;
        String r58 = null;
    L44:
        int r79 = r18;
        if (r4.getInt(r79) == 0) goto L49;
        boolean r59 = true;
    L50:
        int r710 = r19;
        int r60 = r4.getInt(r710);     // Catch: Throwable -> L106
        int r41 = r20;
        int r61 = r4.getInt(r41);     // Catch: Throwable -> L106
        r20 = r41;
        r21 = r21;
        if (r4.getInt(r21) == 0) goto L53;
        boolean r62 = true;
    L55:
        if (r4.getInt(r22) == 0) goto L57;
        boolean r63 = true;
    L58:
        float r64 = r4.getFloat(r23);     // Catch: Throwable -> L106
        r23 = r23;
        r24 = r24;
        if (r4.isNull(r24) == false) goto L61;
        String r65 = null;
    L63:
        if (r4.isNull(r25) == false) goto L65;
        String r66 = null;
    L67:
        if (r4.isNull(r26) == false) goto L69;
        String r67 = null;
    L71:
        if (r4.isNull(r27) == false) goto L73;
        String r68 = null;
    L75:
        if (r4.isNull(r28) == false) goto L77;
        String r69 = null;
    L78:
        long r70 = r4.getLong(r29);     // Catch: Throwable -> L106
        r29 = r29;
        r30 = r30;
        if (r4.isNull(r30) == false) goto L81;
        String r72 = null;
    L82:
        int r73 = r4.getInt(r31);     // Catch: Throwable -> L106
        r31 = r31;
        r32 = r32;
        if (r4.isNull(r32) == false) goto L85;
        String r74 = null;
    L87:
        if (r4.isNull(r33) == false) goto L89;
        String r75 = null;
    L90:
        long r76 = r4.getLong(r34);     // Catch: Throwable -> L106
        r34 = r34;
        ip r44 = new ip(r40, r42, r43, r45, r47, r48, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r72, r73, r74, r75, r76);     // Catch: Throwable -> L106
        int r310 = r2;
        int r46 = r35;
        if (r4.isNull(r46) == false) goto L93;
        Integer r49 = null;
    L94:
        r44.setPoisonLabel(r49);     // Catch: Throwable -> L106
        r36 = r36;
        if (r4.isNull(r36) == false) goto L97;
        Integer r71 = null;
    L98:
        r44.setPoisonLabelVersion(r71);     // Catch: Throwable -> L106
        r37 = r37;
        if (r4.isNull(r37) == false) goto L101;
        String r77 = null;
    L102:
        r44.setContentHash(r77);     // Catch: Throwable -> L106
        r39.add(r44);     // Catch: Throwable -> L106
        r0 = r110;
        r17 = r78;
        r18 = r79;
        r19 = r710;
        r2 = r310;
        r35 = r46;
        r38 = r38;
        goto L6
    L101:
        r77 = r4.getString(r37);     // Catch: Throwable -> L106
        goto L102
    L97:
        r71 = Integer.valueOf(r4.getInt(r36));     // Catch: Throwable -> L106
        goto L98
    L93:
        r49 = Integer.valueOf(r4.getInt(r46));     // Catch: Throwable -> L106
        goto L94
    L89:
        r75 = r4.getString(r33);     // Catch: Throwable -> L106
        goto L90
    L85:
        r74 = r4.getString(r32);     // Catch: Throwable -> L106
        goto L87
    L81:
        r72 = r4.getString(r30);     // Catch: Throwable -> L106
        goto L82
    L77:
        r69 = r4.getString(r28);     // Catch: Throwable -> L106
        goto L78
    L73:
        r68 = r4.getString(r27);     // Catch: Throwable -> L106
        goto L75
    L69:
        r67 = r4.getString(r26);     // Catch: Throwable -> L106
        goto L71
    L65:
        r66 = r4.getString(r25);     // Catch: Throwable -> L106
        goto L67
    L61:
        r65 = r4.getString(r24);     // Catch: Throwable -> L106
        goto L63
    L57:
        r63 = false;
        goto L58
    L53:
        r62 = false;
        goto L55
    L49:
        r59 = false;
        goto L50
    L45:
        r58 = r4.getString(r78);     // Catch: Throwable -> L106
        goto L44
    L40:
        r57 = r4.getString(r38);     // Catch: Throwable -> L106
        goto L39
    L35:
        r56 = r4.getString(r2);     // Catch: Throwable -> L106
        goto L37
    L31:
        r55 = r4.getString(r15);     // Catch: Throwable -> L106
        goto L33
    L27:
        r54 = r4.getString(r14);     // Catch: Throwable -> L106
        goto L29
    L23:
        r53 = r4.getString(r13);     // Catch: Throwable -> L106
        goto L25
    L19:
        r52 = r4.getString(r12);     // Catch: Throwable -> L106
        goto L21
    L15:
        r50 = r4.getString(r10);     // Catch: Throwable -> L106
        goto L16
    L11:
        r42 = r4.getString(r5);     // Catch: Throwable -> L106
        goto L12
    L104:
        r4.close();
        r16.release();
        return r39;
    L106:
        th = th;
    L110:
        r4.close();
        r16.release();
        throw th;
    L108:
        th = th;
        r16 = r1;
        goto L110
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCount(SupportSQLiteQuery r3) {
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

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageName(String r1) {
        return SemanticMemoryDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return SemanticMemoryDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public i<Integer> getCountBySemanticType(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM UnionSemanticMemory WHERE semantic_type = ? AND product_type != 1004 AND confidence = 4.0", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"UnionSemanticMemory"}, new AnonymousClass26(this, r0));
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return SemanticMemoryDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<c> getHashCodeListByPackageNameWithTimeStamp(SupportSQLiteQuery r8) {
        SupportSQLiteQuery r9 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r8, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.__db, r9, false, null);
        int r10 = CursorUtil.getColumnIndex(r7, "entityId");     // Catch: Throwable -> L20
        int r2 = CursorUtil.getColumnIndex(r7, "hashCodeValue");     // Catch: Throwable -> L20
        ArrayList r3 = new ArrayList(r7.getCount());     // Catch: Throwable -> L20
    L4:
        if (r7.moveToNext() == false) goto L18;
        if (r10 != (-1)) goto L10;
    L8:
        String r5 = null;
    L13:
        if (r2 != (-1)) goto L15;
        int r4 = 0;
    L16:
        r3.add(new c(r5, r4));     // Catch: Throwable -> L20
        goto L4
    L15:
        r4 = r7.getInt(r2);     // Catch: Throwable -> L20
        goto L16
    L10:
        if (r7.isNull(r10) == true) goto L8;
        r5 = r7.getString(r10);     // Catch: Throwable -> L20
        goto L13
    L18:
        r7.close();
        return r3;
    L20:
        th = move-exception;
        r7.close();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<c> getHashCodeListByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return SemanticMemoryDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public PagingSource<Integer, ip> getInfoAllTypeMemory() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM UnionSemanticMemory WHERE product_type != 1004 AND confidence = 4.0 ORDER BY modifyTime DESC", 0);
        final RoomDatabase r2 = this.__db;
        final String[] r3 = {"UnionSemanticMemory"};
        return new AnonymousClass13(this, r0, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public i<Integer> getInfoAllTypeMemoryCount() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM UnionSemanticMemory WHERE product_type != 1004 AND confidence = 4.0", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"UnionSemanticMemory"}, new AnonymousClass23(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public Object getInfoAllTypeMemoryMetaInfo(List<String> r9, boolean r10, boolean r11, Continuation<? super List<cu>> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT entityId, type, packageName, \"19700101000000\" as logId FROM UnionSemanticMemory WHERE product_type != 1004 AND confidence = 4.0 AND (       (NOT ");
        r0.append("?");
        r0.append(" AND (            (");
        r0.append("?");
        r0.append(" AND entityId IN (");
        int r3 = r13.size();
        StringUtil.appendPlaceholders(r0, r3);
        r0.append(")) OR             (NOT ");
        r0.append("?");
        r0.append(" AND entityId NOT IN (");
        int r4 = r13.size();
        StringUtil.appendPlaceholders(r0, r4);
        r0.append("))         ))        OR (");
        r0.append("?");
        r0.append(")) ");
        int r2 = r3 + 4;
        final RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r4 + r2);
        r1.bindLong(1, r11 ? 1 : 0);
        r1.bindLong(2, r10 ? 1 : 0);
        Iterator r5 = r13.iterator();
        int r6 = 3;
    L4:
        if (r5.hasNext() == false) goto L10;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
        r1.bindNull(r6);
    L9:
        r6 = r6 + 1;
        goto L4
    L8:
        r1.bindString(r6, r7);
        goto L9
    L10:
        r1.bindLong(r3 + 3, r10 ? 1 : 0);
        Iterator r15 = r13.iterator();
        int r16 = r2;
    L12:
        if (r15.hasNext() == false) goto L18;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L16;
        r1.bindNull(r16);
    L17:
        r16 = r16 + 1;
        goto L12
    L16:
        r1.bindString(r16, r8);
        goto L17
    L18:
        r1.bindLong(r2 + r3, r11 ? 1 : 0);
        CancellationSignal r17 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r17, new AnonymousClass19(this, r1), r14);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public PagingSource<Integer, ih> getInfoAllTypeMemoryWithRelevantPojo() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM UnionSemanticMemory WHERE confidence = 4.0 ORDER BY modifyTime DESC", 0);
        final RoomDatabase r2 = this.__db;
        final String[] r3 = {"ProactiveSemanticRelevantData", "UnionSemanticMemory"};
        return new AnonymousClass16(this, r0, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public PagingSource<Integer, ip> getInfoOthersTypeMemory(String[] r6) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM UnionSemanticMemory WHERE tag_path NOT IN (");
        int r1 = r6.length;
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(") AND confidence = 4.0 ORDER BY modifyTime DESC");
        int r2 = 0;
        final RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire(r0.toString(), r1 + 0);
        int r4 = r6.length;
        int r5 = 1;
    L3:
        if (r2 >= r4) goto L9;
        String r7 = r6[r2];
        if (r7 != null) goto L7;
        r3.bindNull(r5);
    L8:
        r5 = r5 + 1;
        r2 = r2 + 1;
        goto L3
    L7:
        r3.bindString(r5, r7);
        goto L8
    L9:
        final RoomDatabase r8 = this.__db;
        final String[] r9 = {"UnionSemanticMemory"};
        return new AnonymousClass14(this, r3, r8, r9);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public i<Integer> getInfoOthersTypeMemoryCount(String[] r7) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT COUNT(*) FROM UnionSemanticMemory WHERE product_type != 1004 AND confidence = 4.0 AND (tag_path NOT IN (");
        int r1 = r7.length;
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(")) ");
        final RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire(r0.toString(), r1 + 0);
        int r3 = r7.length;
        int r4 = 1;
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L10;
        String r6 = r7[r5];
        if (r6 != null) goto L7;
        r2.bindNull(r4);
    L8:
        r4 = r4 + 1;
        r5 = r5 + 1;
        goto L3
    L7:
        r2.bindString(r4, r6);
        goto L8
    L10:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"UnionSemanticMemory"}, new AnonymousClass24(this, r2));
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public Object getInfoOthersTypeMemoryMetaInfo(String[] r11, List<String> r12, boolean r13, boolean r14, Continuation<? super List<cu>> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT entityId, type, packageName, \"19700101000000\" as logId FROM UnionSemanticMemory WHERE product_type != 1004 AND confidence = 4.0 AND (tag_path NOT IN (");
        int r2 = r11.length;
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")) AND (       (NOT ");
        r0.append("?");
        r0.append(" AND (            (");
        r0.append("?");
        r0.append(" AND entityId IN (");
        int r4 = r16.size();
        StringUtil.appendPlaceholders(r0, r4);
        r0.append(")) OR             (NOT ");
        r0.append("?");
        r0.append(" AND entityId NOT IN (");
        int r5 = r16.size();
        StringUtil.appendPlaceholders(r0, r5);
        r0.append("))         ))        OR (");
        r0.append("?");
        r0.append(")) ");
        int r3 = (r2 + 4) + r4;
        final RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r5 + r3);
        int r6 = r11.length;
        int r7 = 1;
        int r8 = 0;
    L3:
        if (r8 >= r6) goto L9;
        String r9 = r11[r8];
        if (r9 != null) goto L7;
        r1.bindNull(r7);
    L8:
        r7 = r7 + 1;
        r8 = r8 + 1;
        goto L3
    L7:
        r1.bindString(r7, r9);
        goto L8
    L9:
        r1.bindLong(r2 + 1, r14 ? 1 : 0);
        r1.bindLong(r2 + 2, r13 ? 1 : 0);
        int r10 = r2 + 3;
        Iterator r18 = r16.iterator();
        int r19 = r10;
    L11:
        if (r18.hasNext() == false) goto L17;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin");
        if (r20 != null) goto L15;
        r1.bindNull(r19);
    L16:
        r19 = r19 + 1;
        goto L11
    L15:
        r1.bindString(r19, r20);
        goto L16
    L17:
        r1.bindLong(r10 + r4, r13 ? 1 : 0);
        Iterator r110 = r16.iterator();
        int r111 = r3;
    L19:
        if (r110.hasNext() == false) goto L25;
        String r112 = (String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.memorydata.plugin");
        if (r112 != null) goto L23;
        r1.bindNull(r111);
    L24:
        r111 = r111 + 1;
        goto L19
    L23:
        r1.bindString(r111, r112);
        goto L24
    L25:
        r1.bindLong(r3 + r4, r14 ? 1 : 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new AnonymousClass20(this, r1), r17);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public PagingSource<Integer, ih> getInfoOthersTypeMemoryWithRelevantPojo(String[] r6) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM UnionSemanticMemory WHERE tag_path NOT IN (");
        int r1 = r6.length;
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(") AND confidence = 4.0 ORDER BY modifyTime DESC");
        int r2 = 0;
        final RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire(r0.toString(), r1 + 0);
        int r4 = r6.length;
        int r5 = 1;
    L3:
        if (r2 >= r4) goto L9;
        String r7 = r6[r2];
        if (r7 != null) goto L7;
        r3.bindNull(r5);
    L8:
        r5 = r5 + 1;
        r2 = r2 + 1;
        goto L3
    L7:
        r3.bindString(r5, r7);
        goto L8
    L9:
        final RoomDatabase r8 = this.__db;
        final String[] r9 = {"ProactiveSemanticRelevantData", "UnionSemanticMemory"};
        return new AnonymousClass17(this, r3, r8, r9);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public PagingSource<Integer, ip> getInfoSingleTagMemory(String r4) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM UnionSemanticMemory WHERE (? IS NOT NULL AND tag_path=?) AND confidence = 4.0 ORDER BY modifyTime DESC", 2);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        if (r4 != null) goto L8;
        r0.bindNull(2);
    L9:
        final RoomDatabase r1 = this.__db;
        final String[] r2 = {"UnionSemanticMemory"};
        return new AnonymousClass15(this, r0, r1, r2);
    L8:
        r0.bindString(2, r4);
        goto L9
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public i<Integer> getInfoSingleTagMemoryCount(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM UnionSemanticMemory WHERE product_type != 1004 AND confidence = 4.0 AND (? IS NOT NULL AND tag_path=?)", 2);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        if (r5 != null) goto L8;
        r0.bindNull(2);
    L10:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"UnionSemanticMemory"}, new AnonymousClass25(this, r0));
    L8:
        r0.bindString(2, r5);
        goto L10
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public Object getInfoSingleTagMemoryMetaInfo(String r8, List<String> r9, boolean r10, boolean r11, Continuation<? super List<cu>> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT entityId, type, packageName, \"19700101000000\" as logId FROM UnionSemanticMemory WHERE product_type != 1004 AND confidence = 4.0 AND (");
        r0.append("?");
        r0.append(" IS NOT NULL AND semantic_type=");
        r0.append("?");
        r0.append(") AND (       (NOT ");
        r0.append("?");
        r0.append(" AND (            (");
        r0.append("?");
        r0.append(" AND entityId IN (");
        int r3 = r13.size();
        StringUtil.appendPlaceholders(r0, r3);
        r0.append(")) OR             (NOT ");
        r0.append("?");
        r0.append(" AND entityId NOT IN (");
        int r4 = r13.size();
        StringUtil.appendPlaceholders(r0, r4);
        r0.append("))         ))        OR (");
        r0.append("?");
        r0.append(")) ");
        int r2 = r3 + 6;
        final RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r4 + r2);
        if (r8 != null) goto L5;
        r1.bindNull(1);
    L7:
        if (r8 != null) goto L9;
        r1.bindNull(2);
    L10:
        r1.bindLong(3, r11 ? 1 : 0);
        r1.bindLong(4, r10 ? 1 : 0);
        Iterator r15 = r13.iterator();
        int r5 = 5;
    L12:
        if (r15.hasNext() == false) goto L18;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L16;
        r1.bindNull(r5);
    L17:
        r5 = r5 + 1;
        goto L12
    L16:
        r1.bindString(r5, r6);
        goto L17
    L18:
        r1.bindLong(r3 + 5, r10 ? 1 : 0);
        Iterator r16 = r13.iterator();
        int r17 = r2;
    L20:
        if (r16.hasNext() == false) goto L26;
        String r18 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L24;
        r1.bindNull(r17);
    L25:
        r17 = r17 + 1;
        goto L20
    L24:
        r1.bindString(r17, r18);
        goto L25
    L26:
        r1.bindLong(r2 + r3, r11 ? 1 : 0);
        CancellationSignal r19 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r19, new AnonymousClass21(this, r1), r14);
    L9:
        r1.bindString(2, r8);
        goto L10
    L5:
        r1.bindString(1, r8);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public PagingSource<Integer, ih> getInfoSingleTagMemoryWithRelevantPojo(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM UnionSemanticMemory WHERE (? IS NOT NULL AND tag_path=?) AND confidence = 4.0 ORDER BY modifyTime DESC", 2);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        if (r5 != null) goto L8;
        r0.bindNull(2);
    L9:
        final RoomDatabase r1 = this.__db;
        final String[] r2 = {"ProactiveSemanticRelevantData", "UnionSemanticMemory"};
        return new AnonymousClass18(this, r0, r1, r2);
    L8:
        r0.bindString(2, r5);
        goto L9
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public i<Integer> getInfoTypeMemoryCount() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM UnionSemanticMemory WHERE product_type != 1004 AND confidence = 4.0", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"UnionSemanticMemory"}, new AnonymousClass22(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return SemanticMemoryDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Long getMaxValue(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Long r1 = null;
        Cursor r2 = DBUtil.query(this.__db, r4, false, null);
    L11:
        th = move-exception;
        r2.close();
        throw th;
    L4:
        if (r2.moveToFirst() == true) goto L6;
    L9:
        r2.close();
        return r1;
    L6:
        if (r2.isNull(0) == true) goto L9;
        r1 = Long.valueOf(r2.getLong(0));     // Catch: Throwable -> L11
        goto L9
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public i<List<ip>> getMemoryBySemanticTypeFlow(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM UnionSemanticMemory WHERE semantic_type = ? AND product_type != 1004 AND confidence = 4.0 ORDER BY tag_path ASC, modifyTime DESC", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"UnionSemanticMemory"}, new AnonymousClass12(this, r0));
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<ih> getMemoryWithRelevantByEntityIds(List<String> r84) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r84, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM UnionSemanticMemory WHERE entityId IN (");
        int r4 = r0.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(")");
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire(r3.toString(), r4 + 0);
        Iterator r1 = r0.iterator();
        int r6 = 1;
    L4:
        if (r1.hasNext() == false) goto L10;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
        r5.bindNull(r6);
    L9:
        r6 = r6 + 1;
        goto L4
    L8:
        r5.bindString(r6, r7);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor r8 = DBUtil.query(this.__db, r5, true, null);     // Catch: Throwable -> L135
        int r2 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L131
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "entityId");     // Catch: Throwable -> L131
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "createTime");     // Catch: Throwable -> L131
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "modifyTime");     // Catch: Throwable -> L131
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "type");     // Catch: Throwable -> L131
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "timestamp");     // Catch: Throwable -> L131
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L131
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "hashCodeValue");     // Catch: Throwable -> L131
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, Api.KEY_UUID);     // Catch: Throwable -> L131
        int r17 = CursorUtil.getColumnIndexOrThrow(r8, "semantic_type");     // Catch: Throwable -> L131
        int r18 = CursorUtil.getColumnIndexOrThrow(r8, "tag_path");     // Catch: Throwable -> L131
        int r19 = CursorUtil.getColumnIndexOrThrow(r8, "key_phrase");     // Catch: Throwable -> L131
        RoomSQLiteQuery r110 = r5;
        int r111 = CursorUtil.getColumnIndexOrThrow(r8, "description");     // Catch: Throwable -> L129
        int r112 = CursorUtil.getColumnIndexOrThrow(r8, "embedding_content");     // Catch: Throwable -> L129
        int r113 = CursorUtil.getColumnIndexOrThrow(r8, "sources");     // Catch: Throwable -> L129
        int r20 = CursorUtil.getColumnIndexOrThrow(r8, "user_edit");     // Catch: Throwable -> L129
        int r21 = CursorUtil.getColumnIndexOrThrow(r8, "evidence_count");     // Catch: Throwable -> L129
        int r22 = CursorUtil.getColumnIndexOrThrow(r8, "product_type");     // Catch: Throwable -> L129
        int r23 = CursorUtil.getColumnIndexOrThrow(r8, "use_for_insight");     // Catch: Throwable -> L129
        int r24 = CursorUtil.getColumnIndexOrThrow(r8, "use_for_persona");     // Catch: Throwable -> L129
        int r25 = CursorUtil.getColumnIndexOrThrow(r8, "confidence");     // Catch: Throwable -> L129
        int r26 = CursorUtil.getColumnIndexOrThrow(r8, "logId");     // Catch: Throwable -> L129
        int r27 = CursorUtil.getColumnIndexOrThrow(r8, "important_raw_ref_ids");     // Catch: Throwable -> L129
        int r28 = CursorUtil.getColumnIndexOrThrow(r8, "source_raw_ref_ids");     // Catch: Throwable -> L129
        int r29 = CursorUtil.getColumnIndexOrThrow(r8, "scene_ids");     // Catch: Throwable -> L129
        int r30 = CursorUtil.getColumnIndexOrThrow(r8, "sourcePackageName");     // Catch: Throwable -> L129
        int r31 = CursorUtil.getColumnIndexOrThrow(r8, "change_seq");     // Catch: Throwable -> L129
        int r32 = CursorUtil.getColumnIndexOrThrow(r8, "confirmation_state");     // Catch: Throwable -> L129
        int r33 = CursorUtil.getColumnIndexOrThrow(r8, "migration_version");     // Catch: Throwable -> L129
        int r34 = CursorUtil.getColumnIndexOrThrow(r8, "evidence_ids");     // Catch: Throwable -> L129
        int r35 = CursorUtil.getColumnIndexOrThrow(r8, "conflict_entity_ids");     // Catch: Throwable -> L129
        int r36 = CursorUtil.getColumnIndexOrThrow(r8, "last_user_assert_at");     // Catch: Throwable -> L129
        int r37 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label");     // Catch: Throwable -> L129
        int r38 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label_version");     // Catch: Throwable -> L129
        int r39 = CursorUtil.getColumnIndexOrThrow(r8, "content_hash");     // Catch: Throwable -> L129
        ArrayMap<String, ArrayList<fa>> r40 = new ArrayMap();     // Catch: Throwable -> L129
    L16:
        if (r8.moveToNext() == false) goto L21;
        int r41 = r19;
        String r42 = r8.getString(r9);     // Catch: Throwable -> L129
        int r43 = r18;
        int r44 = r17;
        if (((ArrayList) ZeusTransformUtils.preCheckCast(r40.get(r42), ArrayList.class, "com.obric.memorydata.plugin")) != null) goto L20;
        r40.put(r42, new ArrayList());     // Catch: Throwable -> L129
    L20:
        r19 = r41;
        r18 = r43;
        r17 = r44;
        goto L16
    L21:
        int r45 = r17;
        int r46 = r18;
        int r47 = r19;
        r8.moveToPosition(-1);     // Catch: Throwable -> L129
        __fetchRelationshipProactiveSemanticRelevantDataAscomObricMemorydataDatabaseEntityProactiveSemanticRelevantData(r40);     // Catch: Throwable -> L129
        ArrayList r48 = new ArrayList(r8.getCount());     // Catch: Throwable -> L129
    L23:
        if (r8.moveToNext() == false) goto L125;
        long r49 = r8.getLong(r2);     // Catch: Throwable -> L129
        if (r8.isNull(r9) == false) goto L27;
        String r410 = null;
    L28:
        long r411 = r8.getLong(r10);     // Catch: Throwable -> L129
        long r412 = r8.getLong(r11);     // Catch: Throwable -> L129
        int r51 = r8.getInt(r12);     // Catch: Throwable -> L129
        long r52 = r8.getLong(r13);     // Catch: Throwable -> L129
        if (r8.isNull(r14) == false) goto L31;
        String r54 = null;
    L32:
        int r55 = r8.getInt(r15);     // Catch: Throwable -> L129
        if (r8.isNull(r16) == false) goto L35;
        String r56 = null;
    L37:
        if (r8.isNull(r45) == false) goto L39;
        String r57 = null;
    L41:
        if (r8.isNull(r46) == false) goto L44;
        String r58 = null;
    L43:
        int r82 = r47;
        int r413 = r2;
        if (r8.isNull(r82) == false) goto L49;
        String r59 = null;
    L48:
        int r83 = r111;
        if (r8.isNull(r83) == false) goto L54;
        String r60 = null;
    L53:
        int r85 = r112;
        if (r8.isNull(r85) == false) goto L59;
        String r61 = null;
    L58:
        int r86 = r113;
        if (r8.isNull(r86) == false) goto L64;
        String r62 = null;
    L63:
        int r87 = r20;
        if (r8.getInt(r87) == 0) goto L68;
        boolean r63 = true;
    L69:
        int r88 = r21;
        int r64 = r8.getInt(r88);     // Catch: Throwable -> L129
        int r50 = r22;
        int r65 = r8.getInt(r50);     // Catch: Throwable -> L129
        r22 = r50;
        r23 = r23;
        if (r8.getInt(r23) == 0) goto L72;
        boolean r66 = true;
    L74:
        if (r8.getInt(r24) == 0) goto L76;
        boolean r67 = true;
    L77:
        float r68 = r8.getFloat(r25);     // Catch: Throwable -> L129
        r25 = r25;
        r26 = r26;
        if (r8.isNull(r26) == false) goto L80;
        String r69 = null;
    L82:
        if (r8.isNull(r27) == false) goto L84;
        String r70 = null;
    L86:
        if (r8.isNull(r28) == false) goto L88;
        String r71 = null;
    L90:
        if (r8.isNull(r29) == false) goto L92;
        String r72 = null;
    L94:
        if (r8.isNull(r30) == false) goto L96;
        String r73 = null;
    L97:
        long r74 = r8.getLong(r31);     // Catch: Throwable -> L129
        r31 = r31;
        r32 = r32;
        if (r8.isNull(r32) == false) goto L100;
        String r76 = null;
    L101:
        int r77 = r8.getInt(r33);     // Catch: Throwable -> L129
        r33 = r33;
        r34 = r34;
        if (r8.isNull(r34) == false) goto L104;
        String r78 = null;
    L106:
        if (r8.isNull(r35) == false) goto L108;
        String r79 = null;
    L109:
        long r80 = r8.getLong(r36);     // Catch: Throwable -> L129
        r36 = r36;
        ip r53 = new ip(r49, r410, r411, r412, r51, r52, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r76, r77, r78, r79, r80);     // Catch: Throwable -> L129
        r45 = r45;
        int r75 = r37;
        if (r8.isNull(r75) == false) goto L112;
        Integer r81 = null;
    L113:
        r53.setPoisonLabel(r81);     // Catch: Throwable -> L129
        r38 = r38;
        if (r8.isNull(r38) == false) goto L116;
        Integer r89 = null;
    L117:
        r53.setPoisonLabelVersion(r89);     // Catch: Throwable -> L129
        r39 = r39;
        if (r8.isNull(r39) == false) goto L120;
        String r90 = null;
    L121:
        r53.setContentHash(r90);     // Catch: Throwable -> L129
        ArrayMap<String, ArrayList<fa>> r310 = r40;
        ArrayList r91 = (ArrayList) ZeusTransformUtils.preCheckCast(r40.get(r8.getString(r9)), ArrayList.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L129
        if (r91 != null) goto L124;
        r91 = new ArrayList();     // Catch: Throwable -> L129
    L124:
        r48.add(new ih(r53, r91));     // Catch: Throwable -> L129
        r40 = r310;
        r2 = r413;
        r37 = r75;
        r47 = r82;
        r111 = r83;
        r112 = r85;
        r113 = r86;
        r20 = r87;
        r21 = r88;
        r46 = r46;
        goto L23
    L120:
        r90 = r8.getString(r39);     // Catch: Throwable -> L129
        goto L121
    L116:
        r89 = Integer.valueOf(r8.getInt(r38));     // Catch: Throwable -> L129
        goto L117
    L112:
        r81 = Integer.valueOf(r8.getInt(r75));     // Catch: Throwable -> L129
        goto L113
    L108:
        r79 = r8.getString(r35);     // Catch: Throwable -> L129
        goto L109
    L104:
        r78 = r8.getString(r34);     // Catch: Throwable -> L129
        goto L106
    L100:
        r76 = r8.getString(r32);     // Catch: Throwable -> L129
        goto L101
    L96:
        r73 = r8.getString(r30);     // Catch: Throwable -> L129
        goto L97
    L92:
        r72 = r8.getString(r29);     // Catch: Throwable -> L129
        goto L94
    L88:
        r71 = r8.getString(r28);     // Catch: Throwable -> L129
        goto L90
    L84:
        r70 = r8.getString(r27);     // Catch: Throwable -> L129
        goto L86
    L80:
        r69 = r8.getString(r26);     // Catch: Throwable -> L129
        goto L82
    L76:
        r67 = false;
        goto L77
    L72:
        r66 = false;
        goto L74
    L68:
        r63 = false;
        goto L69
    L64:
        r62 = r8.getString(r86);     // Catch: Throwable -> L129
        goto L63
    L59:
        r61 = r8.getString(r85);     // Catch: Throwable -> L129
        goto L58
    L54:
        r60 = r8.getString(r83);     // Catch: Throwable -> L129
        goto L53
    L49:
        r59 = r8.getString(r82);     // Catch: Throwable -> L129
        goto L48
    L44:
        r58 = r8.getString(r46);     // Catch: Throwable -> L129
        goto L43
    L39:
        r57 = r8.getString(r45);     // Catch: Throwable -> L129
        goto L41
    L35:
        r56 = r8.getString(r16);     // Catch: Throwable -> L129
        goto L37
    L31:
        r54 = r8.getString(r14);     // Catch: Throwable -> L129
        goto L32
    L27:
        r410 = r8.getString(r9);     // Catch: Throwable -> L129
        goto L28
    L125:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L129
        r8.close();     // Catch: Throwable -> L135
        r110.release();     // Catch: Throwable -> L135
        this.__db.endTransaction();
        return r48;
    L129:
        th = th;
    L133:
        r8.close();     // Catch: Throwable -> L135
        r110.release();     // Catch: Throwable -> L135
        throw th;     // Catch: Throwable -> L135
    L131:
        th = th;
        r110 = r5;
    L135:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<String> getPackageNameList() {
        return SemanticMemoryDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public ip getSameMemory(String r77, String r78) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM UnionSemanticMemory WHERE tag_path = ? AND key_phrase = ? LIMIT 1", 2);
        if (r77 != null) goto L5;
        r3.bindNull(1);
    L6:
        if (r78 != null) goto L8;
        r3.bindNull(2);
    L9:
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L113
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "entityId");     // Catch: Throwable -> L113
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "createTime");     // Catch: Throwable -> L113
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "modifyTime");     // Catch: Throwable -> L113
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "type");     // Catch: Throwable -> L113
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L113
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L113
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "hashCodeValue");     // Catch: Throwable -> L113
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, Api.KEY_UUID);     // Catch: Throwable -> L113
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "semantic_type");     // Catch: Throwable -> L113
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, "tag_path");     // Catch: Throwable -> L113
        int r1 = CursorUtil.getColumnIndexOrThrow(r4, "key_phrase");     // Catch: Throwable -> L113
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "description");     // Catch: Throwable -> L113
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "embedding_content");     // Catch: Throwable -> L113
        RoomSQLiteQuery r16 = r3;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "sources");     // Catch: Throwable -> L111
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "user_edit");     // Catch: Throwable -> L111
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "evidence_count");     // Catch: Throwable -> L111
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "product_type");     // Catch: Throwable -> L111
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "use_for_insight");     // Catch: Throwable -> L111
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "use_for_persona");     // Catch: Throwable -> L111
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "confidence");     // Catch: Throwable -> L111
        int r24 = CursorUtil.getColumnIndexOrThrow(r4, "logId");     // Catch: Throwable -> L111
        int r25 = CursorUtil.getColumnIndexOrThrow(r4, "important_raw_ref_ids");     // Catch: Throwable -> L111
        int r26 = CursorUtil.getColumnIndexOrThrow(r4, "source_raw_ref_ids");     // Catch: Throwable -> L111
        int r27 = CursorUtil.getColumnIndexOrThrow(r4, "scene_ids");     // Catch: Throwable -> L111
        int r28 = CursorUtil.getColumnIndexOrThrow(r4, "sourcePackageName");     // Catch: Throwable -> L111
        int r29 = CursorUtil.getColumnIndexOrThrow(r4, "change_seq");     // Catch: Throwable -> L111
        int r30 = CursorUtil.getColumnIndexOrThrow(r4, "confirmation_state");     // Catch: Throwable -> L111
        int r31 = CursorUtil.getColumnIndexOrThrow(r4, "migration_version");     // Catch: Throwable -> L111
        int r32 = CursorUtil.getColumnIndexOrThrow(r4, "evidence_ids");     // Catch: Throwable -> L111
        int r33 = CursorUtil.getColumnIndexOrThrow(r4, "conflict_entity_ids");     // Catch: Throwable -> L111
        int r34 = CursorUtil.getColumnIndexOrThrow(r4, "last_user_assert_at");     // Catch: Throwable -> L111
        int r35 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label");     // Catch: Throwable -> L111
        int r36 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label_version");     // Catch: Throwable -> L111
        int r37 = CursorUtil.getColumnIndexOrThrow(r4, "content_hash");     // Catch: Throwable -> L111
        if (r4.moveToFirst() == false) goto L108;
        long r38 = r4.getLong(r0);     // Catch: Throwable -> L111
        if (r4.isNull(r6) == false) goto L17;
        String r40 = null;
    L18:
        long r41 = r4.getLong(r7);     // Catch: Throwable -> L111
        long r43 = r4.getLong(r8);     // Catch: Throwable -> L111
        int r45 = r4.getInt(r9);     // Catch: Throwable -> L111
        long r46 = r4.getLong(r10);     // Catch: Throwable -> L111
        if (r4.isNull(r11) == false) goto L21;
        String r48 = null;
    L22:
        int r49 = r4.getInt(r12);     // Catch: Throwable -> L111
        if (r4.isNull(r13) == false) goto L25;
        String r50 = null;
    L27:
        if (r4.isNull(r14) == false) goto L29;
        String r51 = null;
    L31:
        if (r4.isNull(r15) == false) goto L33;
        String r52 = null;
    L35:
        if (r4.isNull(r1) == false) goto L37;
        String r53 = null;
    L39:
        if (r4.isNull(r2) == false) goto L41;
        String r54 = null;
    L43:
        if (r4.isNull(r5) == false) goto L45;
        String r55 = null;
    L47:
        if (r4.isNull(r78) == false) goto L49;
        String r56 = null;
    L51:
        if (r4.getInt(r18) == 0) goto L53;
        boolean r57 = true;
    L54:
        int r58 = r4.getInt(r19);     // Catch: Throwable -> L111
        int r59 = r4.getInt(r20);     // Catch: Throwable -> L111
        if (r4.getInt(r21) == 0) goto L57;
        boolean r60 = true;
    L59:
        if (r4.getInt(r22) == 0) goto L61;
        boolean r61 = true;
    L62:
        float r62 = r4.getFloat(r23);     // Catch: Throwable -> L111
        if (r4.isNull(r24) == false) goto L65;
        String r63 = null;
    L67:
        if (r4.isNull(r24) == false) goto L69;
        String r64 = null;
    L71:
        if (r4.isNull(r25) == false) goto L73;
        String r65 = null;
    L75:
        if (r4.isNull(r26) == false) goto L77;
        String r66 = null;
    L79:
        if (r4.isNull(r27) == false) goto L81;
        String r67 = null;
    L82:
        long r68 = r4.getLong(r29);     // Catch: Throwable -> L111
        if (r4.isNull(r30) == false) goto L85;
        String r70 = null;
    L86:
        int r71 = r4.getInt(r31);     // Catch: Throwable -> L111
        if (r4.isNull(r32) == false) goto L89;
        String r72 = null;
    L91:
        if (r4.isNull(r32) == false) goto L93;
        String r73 = null;
    L94:
        ip r39 = new ip(r38, r40, r41, r43, r45, r46, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r70, r71, r72, r73, r4.getLong(r34));     // Catch: Throwable -> L111
        if (r4.isNull(r35) == false) goto L97;
        Integer r42 = null;
    L98:
        r39.setPoisonLabel(r42);     // Catch: Throwable -> L111
        if (r4.isNull(r36) == false) goto L101;
        Integer r44 = null;
    L102:
        r39.setPoisonLabelVersion(r44);     // Catch: Throwable -> L111
        if (r4.isNull(r37) == false) goto L105;
        String r47 = null;
    L106:
        r39.setContentHash(r47);     // Catch: Throwable -> L111
        ip r69 = r39;
    L109:
        r4.close();
        r16.release();
        return r69;
    L105:
        r47 = r4.getString(r37);     // Catch: Throwable -> L111
        goto L106
    L101:
        r44 = Integer.valueOf(r4.getInt(r36));     // Catch: Throwable -> L111
        goto L102
    L97:
        r42 = Integer.valueOf(r4.getInt(r35));     // Catch: Throwable -> L111
        goto L98
    L93:
        r73 = r4.getString(r33);     // Catch: Throwable -> L111
        goto L94
    L89:
        r72 = r4.getString(r32);     // Catch: Throwable -> L111
        goto L91
    L85:
        r70 = r4.getString(r30);     // Catch: Throwable -> L111
        goto L86
    L81:
        r67 = r4.getString(r28);     // Catch: Throwable -> L111
        goto L82
    L77:
        r66 = r4.getString(r27);     // Catch: Throwable -> L111
        goto L79
    L73:
        r65 = r4.getString(r26);     // Catch: Throwable -> L111
        goto L75
    L69:
        r64 = r4.getString(r25);     // Catch: Throwable -> L111
        goto L71
    L65:
        r63 = r4.getString(r24);     // Catch: Throwable -> L111
        goto L67
    L61:
        r61 = false;
        goto L62
    L57:
        r60 = false;
        goto L59
    L53:
        r57 = false;
        goto L54
    L49:
        r56 = r4.getString(r17);     // Catch: Throwable -> L111
        goto L51
    L45:
        r55 = r4.getString(r5);     // Catch: Throwable -> L111
        goto L47
    L41:
        r54 = r4.getString(r2);     // Catch: Throwable -> L111
        goto L43
    L37:
        r53 = r4.getString(r1);     // Catch: Throwable -> L111
        goto L39
    L33:
        r52 = r4.getString(r15);     // Catch: Throwable -> L111
        goto L35
    L29:
        r51 = r4.getString(r14);     // Catch: Throwable -> L111
        goto L31
    L25:
        r50 = r4.getString(r13);     // Catch: Throwable -> L111
        goto L27
    L21:
        r48 = r4.getString(r11);     // Catch: Throwable -> L111
        goto L22
    L17:
        r40 = r4.getString(r6);     // Catch: Throwable -> L111
        goto L18
    L108:
        r69 = null;
    L111:
        th = th;
    L115:
        r4.close();
        r16.release();
        throw th;
    L113:
        th = th;
        r16 = r3;
        goto L115
    L8:
        r3.bindString(2, r78);
        goto L9
    L5:
        r3.bindString(1, r77);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return SemanticMemoryDao.DefaultImpls.getTableName(this);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int getTotalCount() {
        int r1 = 0;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM UnionSemanticMemory", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L8:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L6;
        r1 = r3.getInt(0);     // Catch: Throwable -> L8
    L6:
        r3.close();
        r0.release();
        return r1;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<String> getUUIDListByEntityIds(List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT uuid FROM UnionSemanticMemory WHERE entityId IN (");
        int r2 = r8.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r9 = r8.iterator();
        int r3 = 1;
    L4:
        if (r9.hasNext() == false) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r1.bindNull(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r1.bindString(r3, r4);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r1, false, null);
        ArrayList r5 = new ArrayList(r6.getCount());     // Catch: Throwable -> L22
    L12:
        if (r6.moveToNext() == false) goto L20;
        if (r6.isNull(0) == false) goto L17;
        String r10 = null;
    L18:
        r5.add(r10);     // Catch: Throwable -> L22
        goto L12
    L17:
        r10 = r6.getString(0);     // Catch: Throwable -> L22
        goto L18
    L20:
        r6.close();
        r1.release();
        return r5;
    L22:
        th = move-exception;
        r6.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int getUnprocessedForInsightCount() {
        int r1 = 0;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM UnionSemanticMemory WHERE use_for_insight = 0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L8:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L6;
        r1 = r3.getInt(0);     // Catch: Throwable -> L8
    L6:
        r3.close();
        r0.release();
        return r1;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int getUnprocessedForPersonaCount() {
        int r1 = 0;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM UnionSemanticMemory WHERE use_for_persona = 0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L8:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L6;
        r1 = r3.getInt(0);     // Catch: Throwable -> L8
    L6:
        r3.close();
        r0.release();
        return r1;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public long insert(ip r3) {
        this.__db.beginTransaction();
        long r0 = SemanticMemoryDao.DefaultImpls.insert(this, r3);     // Catch: Throwable -> L6
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
        return insert((ip) ZeusTransformUtils.preCheckCast(r3, ip.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao, com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ip> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        List<Long> r5 = SemanticMemoryDao.DefaultImpls.insertAll(this, r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<Long> insertAllRaw(List<ip> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfUnionSemanticMemoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public long insertRaw(ip r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUnionSemanticMemoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ip> queryAll() {
        return SemanticMemoryDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return SemanticMemoryDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<ih> queryAllRangeWithRelevant(int r2, int r3) {
        this.__db.beginTransaction();
        List<ih> r4 = SemanticMemoryDao.DefaultImpls.queryAllRangeWithRelevant(this, r2, r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<Long> queryAllRawDbIds() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id FROM UnionSemanticMemory", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r5.getCount());     // Catch: Throwable -> L10
    L5:
        if (r5.moveToNext() == false) goto L8;
        r2.add(Long.valueOf(r5.getLong(0)));     // Catch: Throwable -> L10
        goto L5
    L8:
        r5.close();
        r0.release();
        return r2;
    L10:
        th = move-exception;
        r5.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public ip queryByEntityId(String r1) {
        return SemanticMemoryDao.DefaultImpls.queryByEntityId(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao, com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ip> queryByEntityId(String r1, String r2) {
        return SemanticMemoryDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ip> queryByEntityIdList(List<String> r3) {
        return SemanticMemoryDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ip> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return SemanticMemoryDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<ih> queryByEntityIdWithRelevantPojo(String r2) {
        this.__db.beginTransaction();
        List<ih> r3 = SemanticMemoryDao.DefaultImpls.queryByEntityIdWithRelevantPojo(this, r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<ip> queryByEntityIds(List<String> r80) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r80, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM UnionSemanticMemory WHERE entityId in (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(")");
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire(r3.toString(), r4 + 0);
        Iterator r2 = r1.iterator();
        int r6 = 1;
    L4:
        if (r2.hasNext() == false) goto L10;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
        r5.bindNull(r6);
    L9:
        r6 = r6 + 1;
        goto L4
    L8:
        r5.bindString(r6, r7);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r8 = DBUtil.query(this.__db, r5, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L116
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "entityId");     // Catch: Throwable -> L116
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "createTime");     // Catch: Throwable -> L116
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "modifyTime");     // Catch: Throwable -> L116
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "type");     // Catch: Throwable -> L116
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "timestamp");     // Catch: Throwable -> L116
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L116
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "hashCodeValue");     // Catch: Throwable -> L116
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, Api.KEY_UUID);     // Catch: Throwable -> L116
        int r17 = CursorUtil.getColumnIndexOrThrow(r8, "semantic_type");     // Catch: Throwable -> L116
        int r18 = CursorUtil.getColumnIndexOrThrow(r8, "tag_path");     // Catch: Throwable -> L116
        int r19 = CursorUtil.getColumnIndexOrThrow(r8, "key_phrase");     // Catch: Throwable -> L116
        int r20 = CursorUtil.getColumnIndexOrThrow(r8, "description");     // Catch: Throwable -> L116
        int r21 = CursorUtil.getColumnIndexOrThrow(r8, "embedding_content");     // Catch: Throwable -> L116
        RoomSQLiteQuery r110 = r5;
        int r111 = CursorUtil.getColumnIndexOrThrow(r8, "sources");     // Catch: Throwable -> L114
        int r112 = CursorUtil.getColumnIndexOrThrow(r8, "user_edit");     // Catch: Throwable -> L114
        int r113 = CursorUtil.getColumnIndexOrThrow(r8, "evidence_count");     // Catch: Throwable -> L114
        int r22 = CursorUtil.getColumnIndexOrThrow(r8, "product_type");     // Catch: Throwable -> L114
        int r23 = CursorUtil.getColumnIndexOrThrow(r8, "use_for_insight");     // Catch: Throwable -> L114
        int r24 = CursorUtil.getColumnIndexOrThrow(r8, "use_for_persona");     // Catch: Throwable -> L114
        int r25 = CursorUtil.getColumnIndexOrThrow(r8, "confidence");     // Catch: Throwable -> L114
        int r26 = CursorUtil.getColumnIndexOrThrow(r8, "logId");     // Catch: Throwable -> L114
        int r27 = CursorUtil.getColumnIndexOrThrow(r8, "important_raw_ref_ids");     // Catch: Throwable -> L114
        int r28 = CursorUtil.getColumnIndexOrThrow(r8, "source_raw_ref_ids");     // Catch: Throwable -> L114
        int r29 = CursorUtil.getColumnIndexOrThrow(r8, "scene_ids");     // Catch: Throwable -> L114
        int r210 = CursorUtil.getColumnIndexOrThrow(r8, "sourcePackageName");     // Catch: Throwable -> L114
        int r211 = CursorUtil.getColumnIndexOrThrow(r8, "change_seq");     // Catch: Throwable -> L114
        int r30 = CursorUtil.getColumnIndexOrThrow(r8, "confirmation_state");     // Catch: Throwable -> L114
        int r31 = CursorUtil.getColumnIndexOrThrow(r8, "migration_version");     // Catch: Throwable -> L114
        int r32 = CursorUtil.getColumnIndexOrThrow(r8, "evidence_ids");     // Catch: Throwable -> L114
        int r33 = CursorUtil.getColumnIndexOrThrow(r8, "conflict_entity_ids");     // Catch: Throwable -> L114
        int r34 = CursorUtil.getColumnIndexOrThrow(r8, "last_user_assert_at");     // Catch: Throwable -> L114
        int r35 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label");     // Catch: Throwable -> L114
        int r36 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label_version");     // Catch: Throwable -> L114
        int r37 = CursorUtil.getColumnIndexOrThrow(r8, "content_hash");     // Catch: Throwable -> L114
        int r38 = r21;
        ArrayList r39 = new ArrayList(r8.getCount());     // Catch: Throwable -> L114
    L14:
        if (r8.moveToNext() == false) goto L112;
        long r40 = r8.getLong(r0);     // Catch: Throwable -> L114
        if (r8.isNull(r9) == false) goto L19;
        String r42 = null;
    L20:
        long r43 = r8.getLong(r10);     // Catch: Throwable -> L114
        long r45 = r8.getLong(r11);     // Catch: Throwable -> L114
        int r47 = r8.getInt(r12);     // Catch: Throwable -> L114
        long r48 = r8.getLong(r13);     // Catch: Throwable -> L114
        if (r8.isNull(r14) == false) goto L23;
        String r50 = null;
    L24:
        int r51 = r8.getInt(r15);     // Catch: Throwable -> L114
        if (r8.isNull(r16) == false) goto L27;
        String r52 = null;
    L29:
        if (r8.isNull(r17) == false) goto L31;
        String r53 = null;
    L33:
        if (r8.isNull(r18) == false) goto L35;
        String r54 = null;
    L37:
        if (r8.isNull(r19) == false) goto L39;
        String r55 = null;
    L41:
        if (r8.isNull(r20) == false) goto L43;
        String r56 = null;
    L45:
        if (r8.isNull(r38) == false) goto L48;
        String r57 = null;
    L47:
        int r78 = r111;
        int r114 = r0;
        if (r8.isNull(r78) == false) goto L53;
        String r58 = null;
    L52:
        int r79 = r112;
        if (r8.getInt(r79) == 0) goto L57;
        boolean r59 = true;
    L58:
        int r710 = r113;
        int r60 = r8.getInt(r710);     // Catch: Throwable -> L114
        int r41 = r22;
        int r61 = r8.getInt(r41);     // Catch: Throwable -> L114
        r22 = r41;
        r23 = r23;
        if (r8.getInt(r23) == 0) goto L61;
        boolean r62 = true;
    L63:
        if (r8.getInt(r24) == 0) goto L65;
        boolean r63 = true;
    L66:
        float r64 = r8.getFloat(r25);     // Catch: Throwable -> L114
        r25 = r25;
        r26 = r26;
        if (r8.isNull(r26) == false) goto L69;
        String r65 = null;
    L71:
        if (r8.isNull(r27) == false) goto L73;
        String r66 = null;
    L75:
        if (r8.isNull(r28) == false) goto L77;
        String r67 = null;
    L79:
        if (r8.isNull(r29) == false) goto L81;
        String r68 = null;
    L83:
        if (r8.isNull(r210) == false) goto L85;
        String r69 = null;
    L86:
        long r70 = r8.getLong(r211);     // Catch: Throwable -> L114
        r211 = r211;
        r30 = r30;
        if (r8.isNull(r30) == false) goto L89;
        String r72 = null;
    L90:
        int r73 = r8.getInt(r31);     // Catch: Throwable -> L114
        r31 = r31;
        r32 = r32;
        if (r8.isNull(r32) == false) goto L93;
        String r74 = null;
    L95:
        if (r8.isNull(r33) == false) goto L97;
        String r75 = null;
    L98:
        long r76 = r8.getLong(r34);     // Catch: Throwable -> L114
        r34 = r34;
        ip r44 = new ip(r40, r42, r43, r45, r47, r48, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r72, r73, r74, r75, r76);     // Catch: Throwable -> L114
        int r310 = r19;
        int r46 = r35;
        if (r8.isNull(r46) == false) goto L101;
        Integer r49 = null;
    L102:
        r44.setPoisonLabel(r49);     // Catch: Throwable -> L114
        r36 = r36;
        if (r8.isNull(r36) == false) goto L105;
        Integer r71 = null;
    L106:
        r44.setPoisonLabelVersion(r71);     // Catch: Throwable -> L114
        r37 = r37;
        if (r8.isNull(r37) == false) goto L109;
        String r77 = null;
    L110:
        r44.setContentHash(r77);     // Catch: Throwable -> L114
        r39.add(r44);     // Catch: Throwable -> L114
        r0 = r114;
        r111 = r78;
        r112 = r79;
        r113 = r710;
        r19 = r310;
        r35 = r46;
        r38 = r38;
        goto L14
    L109:
        r77 = r8.getString(r37);     // Catch: Throwable -> L114
        goto L110
    L105:
        r71 = Integer.valueOf(r8.getInt(r36));     // Catch: Throwable -> L114
        goto L106
    L101:
        r49 = Integer.valueOf(r8.getInt(r46));     // Catch: Throwable -> L114
        goto L102
    L97:
        r75 = r8.getString(r33);     // Catch: Throwable -> L114
        goto L98
    L93:
        r74 = r8.getString(r32);     // Catch: Throwable -> L114
        goto L95
    L89:
        r72 = r8.getString(r30);     // Catch: Throwable -> L114
        goto L90
    L85:
        r69 = r8.getString(r210);     // Catch: Throwable -> L114
        goto L86
    L81:
        r68 = r8.getString(r29);     // Catch: Throwable -> L114
        goto L83
    L77:
        r67 = r8.getString(r28);     // Catch: Throwable -> L114
        goto L79
    L73:
        r66 = r8.getString(r27);     // Catch: Throwable -> L114
        goto L75
    L69:
        r65 = r8.getString(r26);     // Catch: Throwable -> L114
        goto L71
    L65:
        r63 = false;
        goto L66
    L61:
        r62 = false;
        goto L63
    L57:
        r59 = false;
        goto L58
    L53:
        r58 = r8.getString(r78);     // Catch: Throwable -> L114
        goto L52
    L48:
        r57 = r8.getString(r38);     // Catch: Throwable -> L114
        goto L47
    L43:
        r56 = r8.getString(r20);     // Catch: Throwable -> L114
        goto L45
    L39:
        r55 = r8.getString(r19);     // Catch: Throwable -> L114
        goto L41
    L35:
        r54 = r8.getString(r18);     // Catch: Throwable -> L114
        goto L37
    L31:
        r53 = r8.getString(r17);     // Catch: Throwable -> L114
        goto L33
    L27:
        r52 = r8.getString(r16);     // Catch: Throwable -> L114
        goto L29
    L23:
        r50 = r8.getString(r14);     // Catch: Throwable -> L114
        goto L24
    L19:
        r42 = r8.getString(r9);     // Catch: Throwable -> L114
        goto L20
    L112:
        r8.close();
        r110.release();
        return r39;
    L114:
        th = th;
    L118:
        r8.close();
        r110.release();
        throw th;
    L116:
        th = th;
        r110 = r5;
        goto L118
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ip queryById(long r1) {
        return SemanticMemoryDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ip> queryByIdAndTimestamp(long r1, long r3) {
        return SemanticMemoryDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ip> queryByIds(List<Long> r3) {
        return SemanticMemoryDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return SemanticMemoryDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ip> queryByPackageName(String r1) {
        return SemanticMemoryDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ip> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return SemanticMemoryDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ip> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return SemanticMemoryDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ip queryByUUID(String r1) {
        return SemanticMemoryDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<SemanticConflictSnapshot> queryC3ConflictSnapshots() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT entityId, change_seq AS changeSeq, conflict_entity_ids AS conflictEntityIds FROM UnionSemanticMemory WHERE confidence = 3.0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r9 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r9.getCount());     // Catch: Throwable -> L18
    L4:
        if (r9.moveToNext() == false) goto L16;
        if (r9.isNull(0) == false) goto L9;
        String r4 = null;
    L10:
        long r5 = r9.getLong(1);     // Catch: Throwable -> L18
        if (r9.isNull(2) == false) goto L13;
        String r7 = null;
    L14:
        r3.add(new SemanticConflictSnapshot(r4, r5, r7));     // Catch: Throwable -> L18
        goto L4
    L13:
        r7 = r9.getString(2);     // Catch: Throwable -> L18
        goto L14
    L9:
        r4 = r9.getString(0);     // Catch: Throwable -> L18
        goto L10
    L16:
        r9.close();
        r0.release();
        return r3;
    L18:
        th = move-exception;
        r9.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public ip queryDuplicateCandidate(List<String> r76, String r77, boolean r78) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r76, List.class, "com.obric.memorydata.plugin");
        StringBuilder r5 = StringUtil.newStringBuilder();
        r5.append("SELECT * FROM UnionSemanticMemory WHERE ((NOT ");
        r5.append("?");
        r5.append(" AND entityId IN (");
        int r8 = r3.size();
        StringUtil.appendPlaceholders(r5, r8);
        r5.append(")) OR key_phrase = ");
        r5.append("?");
        r5.append(") ORDER BY CASE WHEN (NOT ");
        r5.append("?");
        r5.append(" AND entityId IN (");
        int r6 = r3.size();
        StringUtil.appendPlaceholders(r5, r6);
        r5.append(")) THEN 0 ELSE 1 END, modifyTime DESC LIMIT 1");
        int r7 = r8 + 3;
        RoomSQLiteQuery r9 = RoomSQLiteQuery.acquire(r5.toString(), r6 + r7);
        r9.bindLong(1, r78 ? 1 : 0);
        Iterator r10 = r3.iterator();
        int r11 = 2;
    L4:
        if (r10.hasNext() == false) goto L10;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        if (r12 != null) goto L8;
        r9.bindNull(r11);
    L9:
        r11 = r11 + 1;
        goto L4
    L8:
        r9.bindString(r11, r12);
        goto L9
    L10:
        int r13 = r8 + 2;
        if (r77 != null) goto L13;
        r9.bindNull(r13);
    L14:
        r9.bindLong(r7, r78 ? 1 : 0);
        int r14 = r8 + 4;
        Iterator r1 = r3.iterator();
    L16:
        if (r1.hasNext() == false) goto L22;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L20;
        r9.bindNull(r14);
    L21:
        r14 = r14 + 1;
        goto L16
    L20:
        r9.bindString(r14, r2);
        goto L21
    L22:
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r9, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L126
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, "entityId");     // Catch: Throwable -> L126
        int r16 = CursorUtil.getColumnIndexOrThrow(r4, "createTime");     // Catch: Throwable -> L126
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "modifyTime");     // Catch: Throwable -> L126
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "type");     // Catch: Throwable -> L126
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L126
        int r110 = CursorUtil.getColumnIndexOrThrow(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L126
        int r111 = CursorUtil.getColumnIndexOrThrow(r4, "hashCodeValue");     // Catch: Throwable -> L126
        int r112 = CursorUtil.getColumnIndexOrThrow(r4, Api.KEY_UUID);     // Catch: Throwable -> L126
        int r113 = CursorUtil.getColumnIndexOrThrow(r4, "semantic_type");     // Catch: Throwable -> L126
        int r114 = CursorUtil.getColumnIndexOrThrow(r4, "tag_path");     // Catch: Throwable -> L126
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "key_phrase");     // Catch: Throwable -> L126
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "description");     // Catch: Throwable -> L126
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "embedding_content");     // Catch: Throwable -> L126
        RoomSQLiteQuery r115 = r9;
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "sources");     // Catch: Throwable -> L124
        int r24 = CursorUtil.getColumnIndexOrThrow(r4, "user_edit");     // Catch: Throwable -> L124
        int r25 = CursorUtil.getColumnIndexOrThrow(r4, "evidence_count");     // Catch: Throwable -> L124
        int r26 = CursorUtil.getColumnIndexOrThrow(r4, "product_type");     // Catch: Throwable -> L124
        int r27 = CursorUtil.getColumnIndexOrThrow(r4, "use_for_insight");     // Catch: Throwable -> L124
        int r28 = CursorUtil.getColumnIndexOrThrow(r4, "use_for_persona");     // Catch: Throwable -> L124
        int r29 = CursorUtil.getColumnIndexOrThrow(r4, "confidence");     // Catch: Throwable -> L124
        int r30 = CursorUtil.getColumnIndexOrThrow(r4, "logId");     // Catch: Throwable -> L124
        int r31 = CursorUtil.getColumnIndexOrThrow(r4, "important_raw_ref_ids");     // Catch: Throwable -> L124
        int r32 = CursorUtil.getColumnIndexOrThrow(r4, "source_raw_ref_ids");     // Catch: Throwable -> L124
        int r33 = CursorUtil.getColumnIndexOrThrow(r4, "scene_ids");     // Catch: Throwable -> L124
        int r34 = CursorUtil.getColumnIndexOrThrow(r4, "sourcePackageName");     // Catch: Throwable -> L124
        int r35 = CursorUtil.getColumnIndexOrThrow(r4, "change_seq");     // Catch: Throwable -> L124
        int r36 = CursorUtil.getColumnIndexOrThrow(r4, "confirmation_state");     // Catch: Throwable -> L124
        int r37 = CursorUtil.getColumnIndexOrThrow(r4, "migration_version");     // Catch: Throwable -> L124
        int r38 = CursorUtil.getColumnIndexOrThrow(r4, "evidence_ids");     // Catch: Throwable -> L124
        int r39 = CursorUtil.getColumnIndexOrThrow(r4, "conflict_entity_ids");     // Catch: Throwable -> L124
        int r40 = CursorUtil.getColumnIndexOrThrow(r4, "last_user_assert_at");     // Catch: Throwable -> L124
        int r41 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label");     // Catch: Throwable -> L124
        int r42 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label_version");     // Catch: Throwable -> L124
        int r43 = CursorUtil.getColumnIndexOrThrow(r4, "content_hash");     // Catch: Throwable -> L124
        if (r4.moveToFirst() == false) goto L121;
        long r310 = r4.getLong(r0);     // Catch: Throwable -> L124
        if (r4.isNull(r15) == false) goto L30;
        String r311 = null;
    L31:
        long r44 = r4.getLong(r16);     // Catch: Throwable -> L124
        long r45 = r4.getLong(r17);     // Catch: Throwable -> L124
        int r46 = r4.getInt(r18);     // Catch: Throwable -> L124
        long r47 = r4.getLong(r19);     // Catch: Throwable -> L124
        if (r4.isNull(r110) == false) goto L34;
        String r48 = null;
    L35:
        int r49 = r4.getInt(r111);     // Catch: Throwable -> L124
        if (r4.isNull(r112) == false) goto L38;
        String r410 = null;
    L40:
        if (r4.isNull(r113) == false) goto L42;
        String r50 = null;
    L44:
        if (r4.isNull(r114) == false) goto L46;
        String r51 = null;
    L48:
        if (r4.isNull(r20) == false) goto L50;
        String r52 = null;
    L52:
        if (r4.isNull(r21) == false) goto L54;
        String r53 = null;
    L56:
        if (r4.isNull(r22) == false) goto L58;
        String r54 = null;
    L60:
        if (r4.isNull(r77) == false) goto L62;
        String r55 = null;
    L64:
        if (r4.getInt(r24) == 0) goto L66;
        boolean r56 = true;
    L67:
        int r57 = r4.getInt(r25);     // Catch: Throwable -> L124
        int r58 = r4.getInt(r26);     // Catch: Throwable -> L124
        if (r4.getInt(r27) == 0) goto L70;
        boolean r59 = true;
    L72:
        if (r4.getInt(r28) == 0) goto L74;
        boolean r60 = true;
    L75:
        float r61 = r4.getFloat(r29);     // Catch: Throwable -> L124
        if (r4.isNull(r30) == false) goto L78;
        String r62 = null;
    L80:
        if (r4.isNull(r23) == false) goto L82;
        String r63 = null;
    L84:
        if (r4.isNull(r24) == false) goto L86;
        String r64 = null;
    L88:
        if (r4.isNull(r25) == false) goto L90;
        String r65 = null;
    L92:
        if (r4.isNull(r26) == false) goto L94;
        String r66 = null;
    L95:
        long r67 = r4.getLong(r35);     // Catch: Throwable -> L124
        if (r4.isNull(r36) == false) goto L98;
        String r69 = null;
    L99:
        int r70 = r4.getInt(r37);     // Catch: Throwable -> L124
        if (r4.isNull(r38) == false) goto L102;
        String r71 = null;
    L104:
        if (r4.isNull(r31) == false) goto L106;
        String r72 = null;
    L107:
        ip r68 = new ip(r310, r311, r44, r45, r46, r47, r48, r49, r410, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r69, r70, r71, r72, r4.getLong(r40));     // Catch: Throwable -> L124
        if (r4.isNull(r41) == false) goto L110;
        Integer r73 = null;
    L111:
        r68.setPoisonLabel(r73);     // Catch: Throwable -> L124
        if (r4.isNull(r42) == false) goto L114;
        Integer r74 = null;
    L115:
        r68.setPoisonLabelVersion(r74);     // Catch: Throwable -> L124
        if (r4.isNull(r43) == false) goto L118;
        String r75 = null;
    L119:
        r68.setContentHash(r75);     // Catch: Throwable -> L124
        ip r79 = r68;
    L122:
        r4.close();
        r115.release();
        return r79;
    L118:
        r75 = r4.getString(r43);     // Catch: Throwable -> L124
        goto L119
    L114:
        r74 = Integer.valueOf(r4.getInt(r42));     // Catch: Throwable -> L124
        goto L115
    L110:
        r73 = Integer.valueOf(r4.getInt(r41));     // Catch: Throwable -> L124
        goto L111
    L106:
        r72 = r4.getString(r39);     // Catch: Throwable -> L124
        goto L107
    L102:
        r71 = r4.getString(r38);     // Catch: Throwable -> L124
        goto L104
    L98:
        r69 = r4.getString(r36);     // Catch: Throwable -> L124
        goto L99
    L94:
        r66 = r4.getString(r34);     // Catch: Throwable -> L124
        goto L95
    L90:
        r65 = r4.getString(r33);     // Catch: Throwable -> L124
        goto L92
    L86:
        r64 = r4.getString(r32);     // Catch: Throwable -> L124
        goto L88
    L82:
        r63 = r4.getString(r31);     // Catch: Throwable -> L124
        goto L84
    L78:
        r62 = r4.getString(r30);     // Catch: Throwable -> L124
        goto L80
    L74:
        r60 = false;
        goto L75
    L70:
        r59 = false;
        goto L72
    L66:
        r56 = false;
        goto L67
    L62:
        r55 = r4.getString(r23);     // Catch: Throwable -> L124
        goto L64
    L58:
        r54 = r4.getString(r22);     // Catch: Throwable -> L124
        goto L60
    L54:
        r53 = r4.getString(r21);     // Catch: Throwable -> L124
        goto L56
    L50:
        r52 = r4.getString(r20);     // Catch: Throwable -> L124
        goto L52
    L46:
        r51 = r4.getString(r114);     // Catch: Throwable -> L124
        goto L48
    L42:
        r50 = r4.getString(r113);     // Catch: Throwable -> L124
        goto L44
    L38:
        r410 = r4.getString(r112);     // Catch: Throwable -> L124
        goto L40
    L34:
        r48 = r4.getString(r110);     // Catch: Throwable -> L124
        goto L35
    L30:
        r311 = r4.getString(r15);     // Catch: Throwable -> L124
        goto L31
    L121:
        r79 = null;
    L124:
        th = th;
    L128:
        r4.close();
        r115.release();
        throw th;
    L126:
        th = th;
        r115 = r9;
        goto L128
    L13:
        r9.bindString(r13, r77);
        goto L14
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<ip> queryEffectiveConflicts(List<String> r80) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r80, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM UnionSemanticMemory WHERE entityId IN (");
        int r4 = r1.size();
        StringUtil.appendPlaceholders(r3, r4);
        r3.append(") AND confidence = 4.0");
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire(r3.toString(), r4 + 0);
        Iterator r2 = r1.iterator();
        int r6 = 1;
    L4:
        if (r2.hasNext() == false) goto L10;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L8;
        r5.bindNull(r6);
    L9:
        r6 = r6 + 1;
        goto L4
    L8:
        r5.bindString(r6, r7);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r8 = DBUtil.query(this.__db, r5, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L116
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "entityId");     // Catch: Throwable -> L116
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "createTime");     // Catch: Throwable -> L116
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "modifyTime");     // Catch: Throwable -> L116
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "type");     // Catch: Throwable -> L116
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "timestamp");     // Catch: Throwable -> L116
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L116
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "hashCodeValue");     // Catch: Throwable -> L116
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, Api.KEY_UUID);     // Catch: Throwable -> L116
        int r17 = CursorUtil.getColumnIndexOrThrow(r8, "semantic_type");     // Catch: Throwable -> L116
        int r18 = CursorUtil.getColumnIndexOrThrow(r8, "tag_path");     // Catch: Throwable -> L116
        int r19 = CursorUtil.getColumnIndexOrThrow(r8, "key_phrase");     // Catch: Throwable -> L116
        int r20 = CursorUtil.getColumnIndexOrThrow(r8, "description");     // Catch: Throwable -> L116
        int r21 = CursorUtil.getColumnIndexOrThrow(r8, "embedding_content");     // Catch: Throwable -> L116
        RoomSQLiteQuery r110 = r5;
        int r111 = CursorUtil.getColumnIndexOrThrow(r8, "sources");     // Catch: Throwable -> L114
        int r112 = CursorUtil.getColumnIndexOrThrow(r8, "user_edit");     // Catch: Throwable -> L114
        int r113 = CursorUtil.getColumnIndexOrThrow(r8, "evidence_count");     // Catch: Throwable -> L114
        int r22 = CursorUtil.getColumnIndexOrThrow(r8, "product_type");     // Catch: Throwable -> L114
        int r23 = CursorUtil.getColumnIndexOrThrow(r8, "use_for_insight");     // Catch: Throwable -> L114
        int r24 = CursorUtil.getColumnIndexOrThrow(r8, "use_for_persona");     // Catch: Throwable -> L114
        int r25 = CursorUtil.getColumnIndexOrThrow(r8, "confidence");     // Catch: Throwable -> L114
        int r26 = CursorUtil.getColumnIndexOrThrow(r8, "logId");     // Catch: Throwable -> L114
        int r27 = CursorUtil.getColumnIndexOrThrow(r8, "important_raw_ref_ids");     // Catch: Throwable -> L114
        int r28 = CursorUtil.getColumnIndexOrThrow(r8, "source_raw_ref_ids");     // Catch: Throwable -> L114
        int r29 = CursorUtil.getColumnIndexOrThrow(r8, "scene_ids");     // Catch: Throwable -> L114
        int r210 = CursorUtil.getColumnIndexOrThrow(r8, "sourcePackageName");     // Catch: Throwable -> L114
        int r211 = CursorUtil.getColumnIndexOrThrow(r8, "change_seq");     // Catch: Throwable -> L114
        int r30 = CursorUtil.getColumnIndexOrThrow(r8, "confirmation_state");     // Catch: Throwable -> L114
        int r31 = CursorUtil.getColumnIndexOrThrow(r8, "migration_version");     // Catch: Throwable -> L114
        int r32 = CursorUtil.getColumnIndexOrThrow(r8, "evidence_ids");     // Catch: Throwable -> L114
        int r33 = CursorUtil.getColumnIndexOrThrow(r8, "conflict_entity_ids");     // Catch: Throwable -> L114
        int r34 = CursorUtil.getColumnIndexOrThrow(r8, "last_user_assert_at");     // Catch: Throwable -> L114
        int r35 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label");     // Catch: Throwable -> L114
        int r36 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label_version");     // Catch: Throwable -> L114
        int r37 = CursorUtil.getColumnIndexOrThrow(r8, "content_hash");     // Catch: Throwable -> L114
        int r38 = r21;
        ArrayList r39 = new ArrayList(r8.getCount());     // Catch: Throwable -> L114
    L14:
        if (r8.moveToNext() == false) goto L112;
        long r40 = r8.getLong(r0);     // Catch: Throwable -> L114
        if (r8.isNull(r9) == false) goto L19;
        String r42 = null;
    L20:
        long r43 = r8.getLong(r10);     // Catch: Throwable -> L114
        long r45 = r8.getLong(r11);     // Catch: Throwable -> L114
        int r47 = r8.getInt(r12);     // Catch: Throwable -> L114
        long r48 = r8.getLong(r13);     // Catch: Throwable -> L114
        if (r8.isNull(r14) == false) goto L23;
        String r50 = null;
    L24:
        int r51 = r8.getInt(r15);     // Catch: Throwable -> L114
        if (r8.isNull(r16) == false) goto L27;
        String r52 = null;
    L29:
        if (r8.isNull(r17) == false) goto L31;
        String r53 = null;
    L33:
        if (r8.isNull(r18) == false) goto L35;
        String r54 = null;
    L37:
        if (r8.isNull(r19) == false) goto L39;
        String r55 = null;
    L41:
        if (r8.isNull(r20) == false) goto L43;
        String r56 = null;
    L45:
        if (r8.isNull(r38) == false) goto L48;
        String r57 = null;
    L47:
        int r78 = r111;
        int r114 = r0;
        if (r8.isNull(r78) == false) goto L53;
        String r58 = null;
    L52:
        int r79 = r112;
        if (r8.getInt(r79) == 0) goto L57;
        boolean r59 = true;
    L58:
        int r710 = r113;
        int r60 = r8.getInt(r710);     // Catch: Throwable -> L114
        int r41 = r22;
        int r61 = r8.getInt(r41);     // Catch: Throwable -> L114
        r22 = r41;
        r23 = r23;
        if (r8.getInt(r23) == 0) goto L61;
        boolean r62 = true;
    L63:
        if (r8.getInt(r24) == 0) goto L65;
        boolean r63 = true;
    L66:
        float r64 = r8.getFloat(r25);     // Catch: Throwable -> L114
        r25 = r25;
        r26 = r26;
        if (r8.isNull(r26) == false) goto L69;
        String r65 = null;
    L71:
        if (r8.isNull(r27) == false) goto L73;
        String r66 = null;
    L75:
        if (r8.isNull(r28) == false) goto L77;
        String r67 = null;
    L79:
        if (r8.isNull(r29) == false) goto L81;
        String r68 = null;
    L83:
        if (r8.isNull(r210) == false) goto L85;
        String r69 = null;
    L86:
        long r70 = r8.getLong(r211);     // Catch: Throwable -> L114
        r211 = r211;
        r30 = r30;
        if (r8.isNull(r30) == false) goto L89;
        String r72 = null;
    L90:
        int r73 = r8.getInt(r31);     // Catch: Throwable -> L114
        r31 = r31;
        r32 = r32;
        if (r8.isNull(r32) == false) goto L93;
        String r74 = null;
    L95:
        if (r8.isNull(r33) == false) goto L97;
        String r75 = null;
    L98:
        long r76 = r8.getLong(r34);     // Catch: Throwable -> L114
        r34 = r34;
        ip r44 = new ip(r40, r42, r43, r45, r47, r48, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r72, r73, r74, r75, r76);     // Catch: Throwable -> L114
        int r310 = r19;
        int r46 = r35;
        if (r8.isNull(r46) == false) goto L101;
        Integer r49 = null;
    L102:
        r44.setPoisonLabel(r49);     // Catch: Throwable -> L114
        r36 = r36;
        if (r8.isNull(r36) == false) goto L105;
        Integer r71 = null;
    L106:
        r44.setPoisonLabelVersion(r71);     // Catch: Throwable -> L114
        r37 = r37;
        if (r8.isNull(r37) == false) goto L109;
        String r77 = null;
    L110:
        r44.setContentHash(r77);     // Catch: Throwable -> L114
        r39.add(r44);     // Catch: Throwable -> L114
        r0 = r114;
        r111 = r78;
        r112 = r79;
        r113 = r710;
        r19 = r310;
        r35 = r46;
        r38 = r38;
        goto L14
    L109:
        r77 = r8.getString(r37);     // Catch: Throwable -> L114
        goto L110
    L105:
        r71 = Integer.valueOf(r8.getInt(r36));     // Catch: Throwable -> L114
        goto L106
    L101:
        r49 = Integer.valueOf(r8.getInt(r46));     // Catch: Throwable -> L114
        goto L102
    L97:
        r75 = r8.getString(r33);     // Catch: Throwable -> L114
        goto L98
    L93:
        r74 = r8.getString(r32);     // Catch: Throwable -> L114
        goto L95
    L89:
        r72 = r8.getString(r30);     // Catch: Throwable -> L114
        goto L90
    L85:
        r69 = r8.getString(r210);     // Catch: Throwable -> L114
        goto L86
    L81:
        r68 = r8.getString(r29);     // Catch: Throwable -> L114
        goto L83
    L77:
        r67 = r8.getString(r28);     // Catch: Throwable -> L114
        goto L79
    L73:
        r66 = r8.getString(r27);     // Catch: Throwable -> L114
        goto L75
    L69:
        r65 = r8.getString(r26);     // Catch: Throwable -> L114
        goto L71
    L65:
        r63 = false;
        goto L66
    L61:
        r62 = false;
        goto L63
    L57:
        r59 = false;
        goto L58
    L53:
        r58 = r8.getString(r78);     // Catch: Throwable -> L114
        goto L52
    L48:
        r57 = r8.getString(r38);     // Catch: Throwable -> L114
        goto L47
    L43:
        r56 = r8.getString(r20);     // Catch: Throwable -> L114
        goto L45
    L39:
        r55 = r8.getString(r19);     // Catch: Throwable -> L114
        goto L41
    L35:
        r54 = r8.getString(r18);     // Catch: Throwable -> L114
        goto L37
    L31:
        r53 = r8.getString(r17);     // Catch: Throwable -> L114
        goto L33
    L27:
        r52 = r8.getString(r16);     // Catch: Throwable -> L114
        goto L29
    L23:
        r50 = r8.getString(r14);     // Catch: Throwable -> L114
        goto L24
    L19:
        r42 = r8.getString(r9);     // Catch: Throwable -> L114
        goto L20
    L112:
        r8.close();
        r110.release();
        return r39;
    L114:
        th = th;
    L118:
        r8.close();
        r110.release();
        throw th;
    L116:
        th = th;
        r110 = r5;
        goto L118
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<ip> queryFormalList(String r79, int r80) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM UnionSemanticMemory WHERE confidence = 4.0 AND product_type != 1004 AND (? IS NULL OR semantic_type = ?) ORDER BY modifyTime DESC LIMIT ?", 3);
        if (r79 != null) goto L5;
        r2.bindNull(1);
    L7:
        if (r79 != null) goto L9;
        r2.bindNull(2);
    L10:
        r2.bindLong(3, r80);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L116
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L116
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L116
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L116
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L116
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L116
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L116
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L116
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L116
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "semantic_type");     // Catch: Throwable -> L116
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "tag_path");     // Catch: Throwable -> L116
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "key_phrase");     // Catch: Throwable -> L116
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "description");     // Catch: Throwable -> L116
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "embedding_content");     // Catch: Throwable -> L116
        RoomSQLiteQuery r16 = r2;
        int r81 = CursorUtil.getColumnIndexOrThrow(r5, "sources");     // Catch: Throwable -> L114
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "user_edit");     // Catch: Throwable -> L114
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "evidence_count");     // Catch: Throwable -> L114
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "product_type");     // Catch: Throwable -> L114
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "use_for_insight");     // Catch: Throwable -> L114
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "use_for_persona");     // Catch: Throwable -> L114
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "confidence");     // Catch: Throwable -> L114
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L114
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "important_raw_ref_ids");     // Catch: Throwable -> L114
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "source_raw_ref_ids");     // Catch: Throwable -> L114
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "scene_ids");     // Catch: Throwable -> L114
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "sourcePackageName");     // Catch: Throwable -> L114
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "change_seq");     // Catch: Throwable -> L114
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "confirmation_state");     // Catch: Throwable -> L114
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "migration_version");     // Catch: Throwable -> L114
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, "evidence_ids");     // Catch: Throwable -> L114
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, "conflict_entity_ids");     // Catch: Throwable -> L114
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "last_user_assert_at");     // Catch: Throwable -> L114
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L114
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L114
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L114
        int r37 = r4;
        ArrayList r38 = new ArrayList(r5.getCount());     // Catch: Throwable -> L114
    L14:
        if (r5.moveToNext() == false) goto L112;
        long r39 = r5.getLong(r0);     // Catch: Throwable -> L114
        if (r5.isNull(r6) == false) goto L19;
        String r41 = null;
    L20:
        long r42 = r5.getLong(r7);     // Catch: Throwable -> L114
        long r44 = r5.getLong(r8);     // Catch: Throwable -> L114
        int r46 = r5.getInt(r9);     // Catch: Throwable -> L114
        long r47 = r5.getLong(r10);     // Catch: Throwable -> L114
        if (r5.isNull(r11) == false) goto L23;
        String r49 = null;
    L24:
        int r50 = r5.getInt(r12);     // Catch: Throwable -> L114
        if (r5.isNull(r13) == false) goto L27;
        String r51 = null;
    L29:
        if (r5.isNull(r14) == false) goto L31;
        String r52 = null;
    L33:
        if (r5.isNull(r15) == false) goto L35;
        String r53 = null;
    L37:
        if (r5.isNull(r1) == false) goto L39;
        String r54 = null;
    L41:
        if (r5.isNull(r3) == false) goto L43;
        String r55 = null;
    L45:
        if (r5.isNull(r37) == false) goto L48;
        String r56 = null;
    L47:
        int r77 = r0;
        int r40 = r81;
        if (r5.isNull(r40) == false) goto L53;
        String r57 = null;
    L52:
        int r78 = r17;
        if (r5.getInt(r78) == 0) goto L57;
        boolean r58 = true;
    L58:
        int r710 = r18;
        int r59 = r5.getInt(r710);     // Catch: Throwable -> L114
        int r43 = r19;
        int r60 = r5.getInt(r43);     // Catch: Throwable -> L114
        r19 = r43;
        r20 = r20;
        if (r5.getInt(r20) == 0) goto L61;
        boolean r61 = true;
    L63:
        if (r5.getInt(r21) == 0) goto L65;
        boolean r62 = true;
    L66:
        float r63 = r5.getFloat(r22);     // Catch: Throwable -> L114
        r22 = r22;
        r23 = r23;
        if (r5.isNull(r23) == false) goto L69;
        String r64 = null;
    L71:
        if (r5.isNull(r24) == false) goto L73;
        String r65 = null;
    L75:
        if (r5.isNull(r25) == false) goto L77;
        String r66 = null;
    L79:
        if (r5.isNull(r26) == false) goto L81;
        String r67 = null;
    L83:
        if (r5.isNull(r27) == false) goto L85;
        String r68 = null;
    L86:
        long r69 = r5.getLong(r28);     // Catch: Throwable -> L114
        r28 = r28;
        r29 = r29;
        if (r5.isNull(r29) == false) goto L89;
        String r71 = null;
    L90:
        int r72 = r5.getInt(r30);     // Catch: Throwable -> L114
        r30 = r30;
        r31 = r31;
        if (r5.isNull(r31) == false) goto L93;
        String r73 = null;
    L95:
        if (r5.isNull(r32) == false) goto L97;
        String r74 = null;
    L98:
        long r75 = r5.getLong(r33);     // Catch: Throwable -> L114
        r33 = r33;
        ip r45 = new ip(r39, r41, r42, r44, r46, r47, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r71, r72, r73, r74, r75);     // Catch: Throwable -> L114
        int r310 = r1;
        int r48 = r34;
        if (r5.isNull(r48) == false) goto L101;
        Integer r70 = null;
    L102:
        r45.setPoisonLabel(r70);     // Catch: Throwable -> L114
        r35 = r35;
        if (r5.isNull(r35) == false) goto L105;
        Integer r76 = null;
    L106:
        r45.setPoisonLabelVersion(r76);     // Catch: Throwable -> L114
        r36 = r36;
        if (r5.isNull(r36) == false) goto L109;
        String r82 = null;
    L110:
        r45.setContentHash(r82);     // Catch: Throwable -> L114
        r38.add(r45);     // Catch: Throwable -> L114
        r0 = r77;
        r81 = r40;
        r17 = r78;
        r18 = r710;
        r1 = r310;
        r34 = r48;
        r37 = r37;
        goto L14
    L109:
        r82 = r5.getString(r36);     // Catch: Throwable -> L114
        goto L110
    L105:
        r76 = Integer.valueOf(r5.getInt(r35));     // Catch: Throwable -> L114
        goto L106
    L101:
        r70 = Integer.valueOf(r5.getInt(r48));     // Catch: Throwable -> L114
        goto L102
    L97:
        r74 = r5.getString(r32);     // Catch: Throwable -> L114
        goto L98
    L93:
        r73 = r5.getString(r31);     // Catch: Throwable -> L114
        goto L95
    L89:
        r71 = r5.getString(r29);     // Catch: Throwable -> L114
        goto L90
    L85:
        r68 = r5.getString(r27);     // Catch: Throwable -> L114
        goto L86
    L81:
        r67 = r5.getString(r26);     // Catch: Throwable -> L114
        goto L83
    L77:
        r66 = r5.getString(r25);     // Catch: Throwable -> L114
        goto L79
    L73:
        r65 = r5.getString(r24);     // Catch: Throwable -> L114
        goto L75
    L69:
        r64 = r5.getString(r23);     // Catch: Throwable -> L114
        goto L71
    L65:
        r62 = false;
        goto L66
    L61:
        r61 = false;
        goto L63
    L57:
        r58 = false;
        goto L58
    L53:
        r57 = r5.getString(r40);     // Catch: Throwable -> L114
        goto L52
    L48:
        r56 = r5.getString(r37);     // Catch: Throwable -> L114
        goto L47
    L43:
        r55 = r5.getString(r3);     // Catch: Throwable -> L114
        goto L45
    L39:
        r54 = r5.getString(r1);     // Catch: Throwable -> L114
        goto L41
    L35:
        r53 = r5.getString(r15);     // Catch: Throwable -> L114
        goto L37
    L31:
        r52 = r5.getString(r14);     // Catch: Throwable -> L114
        goto L33
    L27:
        r51 = r5.getString(r13);     // Catch: Throwable -> L114
        goto L29
    L23:
        r49 = r5.getString(r11);     // Catch: Throwable -> L114
        goto L24
    L19:
        r41 = r5.getString(r6);     // Catch: Throwable -> L114
        goto L20
    L112:
        r5.close();
        r16.release();
        return r38;
    L114:
        th = th;
    L118:
        r5.close();
        r16.release();
        throw th;
    L116:
        th = th;
        r16 = r2;
        goto L118
    L9:
        r2.bindString(2, r79);
        goto L10
    L5:
        r2.bindString(1, r79);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ip queryOne() {
        return SemanticMemoryDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public PagingSource<Integer, ih> queryPagedBySemanticType(String r1) {
        return SemanticMemoryDao.DefaultImpls.queryPagedBySemanticType(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public PagingSource<Integer, ip> queryPagedRaw(SupportSQLiteQuery r4) {
        final SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        final RoomDatabase r1 = this.__db;
        final String[] r2 = {"UnionSemanticMemory"};
        return new AnonymousClass27(this, r5, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public PagingSource<Integer, ih> queryPagedRawWithRelevant(SupportSQLiteQuery r5) {
        final SupportSQLiteQuery r6 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        final RoomDatabase r1 = this.__db;
        final String[] r2 = {"ProactiveSemanticRelevantData", "UnionSemanticMemory"};
        return new AnonymousClass28(this, r6, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<ip> queryPendingConfirmationNewest(int r80) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM UnionSemanticMemory WHERE confidence = 3.0 AND confirmation_state = 'pending' ORDER BY modifyTime DESC, entityId ASC LIMIT ?", 1);
        r1.bindLong(1, r80);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L108
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L108
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L108
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L108
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L108
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L108
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L108
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L108
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L108
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "semantic_type");     // Catch: Throwable -> L108
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "tag_path");     // Catch: Throwable -> L108
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, "key_phrase");     // Catch: Throwable -> L108
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "description");     // Catch: Throwable -> L108
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "embedding_content");     // Catch: Throwable -> L108
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "sources");     // Catch: Throwable -> L106
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "user_edit");     // Catch: Throwable -> L106
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "evidence_count");     // Catch: Throwable -> L106
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "product_type");     // Catch: Throwable -> L106
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "use_for_insight");     // Catch: Throwable -> L106
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "use_for_persona");     // Catch: Throwable -> L106
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "confidence");     // Catch: Throwable -> L106
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L106
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "important_raw_ref_ids");     // Catch: Throwable -> L106
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "source_raw_ref_ids");     // Catch: Throwable -> L106
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "scene_ids");     // Catch: Throwable -> L106
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "sourcePackageName");     // Catch: Throwable -> L106
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "change_seq");     // Catch: Throwable -> L106
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "confirmation_state");     // Catch: Throwable -> L106
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, "migration_version");     // Catch: Throwable -> L106
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, "evidence_ids");     // Catch: Throwable -> L106
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "conflict_entity_ids");     // Catch: Throwable -> L106
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "last_user_assert_at");     // Catch: Throwable -> L106
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L106
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L106
        int r37 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L106
        int r38 = r4;
        ArrayList r39 = new ArrayList(r5.getCount());     // Catch: Throwable -> L106
    L6:
        if (r5.moveToNext() == false) goto L104;
        long r40 = r5.getLong(r0);     // Catch: Throwable -> L106
        if (r5.isNull(r6) == false) goto L11;
        String r42 = null;
    L12:
        long r43 = r5.getLong(r7);     // Catch: Throwable -> L106
        long r45 = r5.getLong(r8);     // Catch: Throwable -> L106
        int r47 = r5.getInt(r9);     // Catch: Throwable -> L106
        long r48 = r5.getLong(r10);     // Catch: Throwable -> L106
        if (r5.isNull(r11) == false) goto L15;
        String r50 = null;
    L16:
        int r51 = r5.getInt(r12);     // Catch: Throwable -> L106
        if (r5.isNull(r13) == false) goto L19;
        String r52 = null;
    L21:
        if (r5.isNull(r14) == false) goto L23;
        String r53 = null;
    L25:
        if (r5.isNull(r15) == false) goto L27;
        String r54 = null;
    L29:
        if (r5.isNull(r2) == false) goto L31;
        String r55 = null;
    L33:
        if (r5.isNull(r3) == false) goto L35;
        String r56 = null;
    L37:
        if (r5.isNull(r38) == false) goto L40;
        String r57 = null;
    L39:
        int r78 = r17;
        int r110 = r0;
        if (r5.isNull(r78) == false) goto L45;
        String r58 = null;
    L44:
        int r79 = r18;
        if (r5.getInt(r79) == 0) goto L49;
        boolean r59 = true;
    L50:
        int r710 = r19;
        int r60 = r5.getInt(r710);     // Catch: Throwable -> L106
        int r41 = r20;
        int r61 = r5.getInt(r41);     // Catch: Throwable -> L106
        r20 = r41;
        r21 = r21;
        if (r5.getInt(r21) == 0) goto L53;
        boolean r62 = true;
    L55:
        if (r5.getInt(r22) == 0) goto L57;
        boolean r63 = true;
    L58:
        float r64 = r5.getFloat(r23);     // Catch: Throwable -> L106
        r23 = r23;
        r24 = r24;
        if (r5.isNull(r24) == false) goto L61;
        String r65 = null;
    L63:
        if (r5.isNull(r25) == false) goto L65;
        String r66 = null;
    L67:
        if (r5.isNull(r26) == false) goto L69;
        String r67 = null;
    L71:
        if (r5.isNull(r27) == false) goto L73;
        String r68 = null;
    L75:
        if (r5.isNull(r28) == false) goto L77;
        String r69 = null;
    L78:
        long r70 = r5.getLong(r29);     // Catch: Throwable -> L106
        r29 = r29;
        r30 = r30;
        if (r5.isNull(r30) == false) goto L81;
        String r72 = null;
    L82:
        int r73 = r5.getInt(r31);     // Catch: Throwable -> L106
        r31 = r31;
        r32 = r32;
        if (r5.isNull(r32) == false) goto L85;
        String r74 = null;
    L87:
        if (r5.isNull(r33) == false) goto L89;
        String r75 = null;
    L90:
        long r76 = r5.getLong(r34);     // Catch: Throwable -> L106
        r34 = r34;
        ip r44 = new ip(r40, r42, r43, r45, r47, r48, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r72, r73, r74, r75, r76);     // Catch: Throwable -> L106
        int r310 = r2;
        int r46 = r35;
        if (r5.isNull(r46) == false) goto L93;
        Integer r49 = null;
    L94:
        r44.setPoisonLabel(r49);     // Catch: Throwable -> L106
        r36 = r36;
        if (r5.isNull(r36) == false) goto L97;
        Integer r71 = null;
    L98:
        r44.setPoisonLabelVersion(r71);     // Catch: Throwable -> L106
        r37 = r37;
        if (r5.isNull(r37) == false) goto L101;
        String r77 = null;
    L102:
        r44.setContentHash(r77);     // Catch: Throwable -> L106
        r39.add(r44);     // Catch: Throwable -> L106
        r0 = r110;
        r17 = r78;
        r18 = r79;
        r19 = r710;
        r2 = r310;
        r35 = r46;
        r38 = r38;
        goto L6
    L101:
        r77 = r5.getString(r37);     // Catch: Throwable -> L106
        goto L102
    L97:
        r71 = Integer.valueOf(r5.getInt(r36));     // Catch: Throwable -> L106
        goto L98
    L93:
        r49 = Integer.valueOf(r5.getInt(r46));     // Catch: Throwable -> L106
        goto L94
    L89:
        r75 = r5.getString(r33);     // Catch: Throwable -> L106
        goto L90
    L85:
        r74 = r5.getString(r32);     // Catch: Throwable -> L106
        goto L87
    L81:
        r72 = r5.getString(r30);     // Catch: Throwable -> L106
        goto L82
    L77:
        r69 = r5.getString(r28);     // Catch: Throwable -> L106
        goto L78
    L73:
        r68 = r5.getString(r27);     // Catch: Throwable -> L106
        goto L75
    L69:
        r67 = r5.getString(r26);     // Catch: Throwable -> L106
        goto L71
    L65:
        r66 = r5.getString(r25);     // Catch: Throwable -> L106
        goto L67
    L61:
        r65 = r5.getString(r24);     // Catch: Throwable -> L106
        goto L63
    L57:
        r63 = false;
        goto L58
    L53:
        r62 = false;
        goto L55
    L49:
        r59 = false;
        goto L50
    L45:
        r58 = r5.getString(r78);     // Catch: Throwable -> L106
        goto L44
    L40:
        r57 = r5.getString(r38);     // Catch: Throwable -> L106
        goto L39
    L35:
        r56 = r5.getString(r3);     // Catch: Throwable -> L106
        goto L37
    L31:
        r55 = r5.getString(r2);     // Catch: Throwable -> L106
        goto L33
    L27:
        r54 = r5.getString(r15);     // Catch: Throwable -> L106
        goto L29
    L23:
        r53 = r5.getString(r14);     // Catch: Throwable -> L106
        goto L25
    L19:
        r52 = r5.getString(r13);     // Catch: Throwable -> L106
        goto L21
    L15:
        r50 = r5.getString(r11);     // Catch: Throwable -> L106
        goto L16
    L11:
        r42 = r5.getString(r6);     // Catch: Throwable -> L106
        goto L12
    L104:
        r5.close();
        r16.release();
        return r39;
    L106:
        th = th;
    L110:
        r5.close();
        r16.release();
        throw th;
    L108:
        th = th;
        r16 = r1;
        goto L110
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<ip> queryPendingConfirmationOldest(int r80) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM UnionSemanticMemory WHERE confidence = 3.0 AND confirmation_state = 'pending' ORDER BY modifyTime ASC, entityId ASC LIMIT ?", 1);
        r1.bindLong(1, r80);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L108
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L108
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L108
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L108
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L108
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L108
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L108
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L108
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L108
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "semantic_type");     // Catch: Throwable -> L108
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "tag_path");     // Catch: Throwable -> L108
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, "key_phrase");     // Catch: Throwable -> L108
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "description");     // Catch: Throwable -> L108
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "embedding_content");     // Catch: Throwable -> L108
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "sources");     // Catch: Throwable -> L106
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "user_edit");     // Catch: Throwable -> L106
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "evidence_count");     // Catch: Throwable -> L106
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "product_type");     // Catch: Throwable -> L106
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "use_for_insight");     // Catch: Throwable -> L106
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "use_for_persona");     // Catch: Throwable -> L106
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "confidence");     // Catch: Throwable -> L106
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L106
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "important_raw_ref_ids");     // Catch: Throwable -> L106
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "source_raw_ref_ids");     // Catch: Throwable -> L106
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "scene_ids");     // Catch: Throwable -> L106
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "sourcePackageName");     // Catch: Throwable -> L106
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "change_seq");     // Catch: Throwable -> L106
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "confirmation_state");     // Catch: Throwable -> L106
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, "migration_version");     // Catch: Throwable -> L106
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, "evidence_ids");     // Catch: Throwable -> L106
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "conflict_entity_ids");     // Catch: Throwable -> L106
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "last_user_assert_at");     // Catch: Throwable -> L106
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L106
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L106
        int r37 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L106
        int r38 = r4;
        ArrayList r39 = new ArrayList(r5.getCount());     // Catch: Throwable -> L106
    L6:
        if (r5.moveToNext() == false) goto L104;
        long r40 = r5.getLong(r0);     // Catch: Throwable -> L106
        if (r5.isNull(r6) == false) goto L11;
        String r42 = null;
    L12:
        long r43 = r5.getLong(r7);     // Catch: Throwable -> L106
        long r45 = r5.getLong(r8);     // Catch: Throwable -> L106
        int r47 = r5.getInt(r9);     // Catch: Throwable -> L106
        long r48 = r5.getLong(r10);     // Catch: Throwable -> L106
        if (r5.isNull(r11) == false) goto L15;
        String r50 = null;
    L16:
        int r51 = r5.getInt(r12);     // Catch: Throwable -> L106
        if (r5.isNull(r13) == false) goto L19;
        String r52 = null;
    L21:
        if (r5.isNull(r14) == false) goto L23;
        String r53 = null;
    L25:
        if (r5.isNull(r15) == false) goto L27;
        String r54 = null;
    L29:
        if (r5.isNull(r2) == false) goto L31;
        String r55 = null;
    L33:
        if (r5.isNull(r3) == false) goto L35;
        String r56 = null;
    L37:
        if (r5.isNull(r38) == false) goto L40;
        String r57 = null;
    L39:
        int r78 = r17;
        int r110 = r0;
        if (r5.isNull(r78) == false) goto L45;
        String r58 = null;
    L44:
        int r79 = r18;
        if (r5.getInt(r79) == 0) goto L49;
        boolean r59 = true;
    L50:
        int r710 = r19;
        int r60 = r5.getInt(r710);     // Catch: Throwable -> L106
        int r41 = r20;
        int r61 = r5.getInt(r41);     // Catch: Throwable -> L106
        r20 = r41;
        r21 = r21;
        if (r5.getInt(r21) == 0) goto L53;
        boolean r62 = true;
    L55:
        if (r5.getInt(r22) == 0) goto L57;
        boolean r63 = true;
    L58:
        float r64 = r5.getFloat(r23);     // Catch: Throwable -> L106
        r23 = r23;
        r24 = r24;
        if (r5.isNull(r24) == false) goto L61;
        String r65 = null;
    L63:
        if (r5.isNull(r25) == false) goto L65;
        String r66 = null;
    L67:
        if (r5.isNull(r26) == false) goto L69;
        String r67 = null;
    L71:
        if (r5.isNull(r27) == false) goto L73;
        String r68 = null;
    L75:
        if (r5.isNull(r28) == false) goto L77;
        String r69 = null;
    L78:
        long r70 = r5.getLong(r29);     // Catch: Throwable -> L106
        r29 = r29;
        r30 = r30;
        if (r5.isNull(r30) == false) goto L81;
        String r72 = null;
    L82:
        int r73 = r5.getInt(r31);     // Catch: Throwable -> L106
        r31 = r31;
        r32 = r32;
        if (r5.isNull(r32) == false) goto L85;
        String r74 = null;
    L87:
        if (r5.isNull(r33) == false) goto L89;
        String r75 = null;
    L90:
        long r76 = r5.getLong(r34);     // Catch: Throwable -> L106
        r34 = r34;
        ip r44 = new ip(r40, r42, r43, r45, r47, r48, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r72, r73, r74, r75, r76);     // Catch: Throwable -> L106
        int r310 = r2;
        int r46 = r35;
        if (r5.isNull(r46) == false) goto L93;
        Integer r49 = null;
    L94:
        r44.setPoisonLabel(r49);     // Catch: Throwable -> L106
        r36 = r36;
        if (r5.isNull(r36) == false) goto L97;
        Integer r71 = null;
    L98:
        r44.setPoisonLabelVersion(r71);     // Catch: Throwable -> L106
        r37 = r37;
        if (r5.isNull(r37) == false) goto L101;
        String r77 = null;
    L102:
        r44.setContentHash(r77);     // Catch: Throwable -> L106
        r39.add(r44);     // Catch: Throwable -> L106
        r0 = r110;
        r17 = r78;
        r18 = r79;
        r19 = r710;
        r2 = r310;
        r35 = r46;
        r38 = r38;
        goto L6
    L101:
        r77 = r5.getString(r37);     // Catch: Throwable -> L106
        goto L102
    L97:
        r71 = Integer.valueOf(r5.getInt(r36));     // Catch: Throwable -> L106
        goto L98
    L93:
        r49 = Integer.valueOf(r5.getInt(r46));     // Catch: Throwable -> L106
        goto L94
    L89:
        r75 = r5.getString(r33);     // Catch: Throwable -> L106
        goto L90
    L85:
        r74 = r5.getString(r32);     // Catch: Throwable -> L106
        goto L87
    L81:
        r72 = r5.getString(r30);     // Catch: Throwable -> L106
        goto L82
    L77:
        r69 = r5.getString(r28);     // Catch: Throwable -> L106
        goto L78
    L73:
        r68 = r5.getString(r27);     // Catch: Throwable -> L106
        goto L75
    L69:
        r67 = r5.getString(r26);     // Catch: Throwable -> L106
        goto L71
    L65:
        r66 = r5.getString(r25);     // Catch: Throwable -> L106
        goto L67
    L61:
        r65 = r5.getString(r24);     // Catch: Throwable -> L106
        goto L63
    L57:
        r63 = false;
        goto L58
    L53:
        r62 = false;
        goto L55
    L49:
        r59 = false;
        goto L50
    L45:
        r58 = r5.getString(r78);     // Catch: Throwable -> L106
        goto L44
    L40:
        r57 = r5.getString(r38);     // Catch: Throwable -> L106
        goto L39
    L35:
        r56 = r5.getString(r3);     // Catch: Throwable -> L106
        goto L37
    L31:
        r55 = r5.getString(r2);     // Catch: Throwable -> L106
        goto L33
    L27:
        r54 = r5.getString(r15);     // Catch: Throwable -> L106
        goto L29
    L23:
        r53 = r5.getString(r14);     // Catch: Throwable -> L106
        goto L25
    L19:
        r52 = r5.getString(r13);     // Catch: Throwable -> L106
        goto L21
    L15:
        r50 = r5.getString(r11);     // Catch: Throwable -> L106
        goto L16
    L11:
        r42 = r5.getString(r6);     // Catch: Throwable -> L106
        goto L12
    L104:
        r5.close();
        r16.release();
        return r39;
    L106:
        th = th;
    L110:
        r5.close();
        r16.release();
        throw th;
    L108:
        th = th;
        r16 = r1;
        goto L110
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<ih> queryRangeBySemanticTypeWithRelevant(String r2, int r3, int r4) {
        this.__db.beginTransaction();
        List<ih> r5 = SemanticMemoryDao.DefaultImpls.queryRangeBySemanticTypeWithRelevant(this, r2, r3, r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<ih> queryRawWithRelevant(SupportSQLiteQuery r87) {
        SupportSQLiteQuery r0 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r87, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, true, null);     // Catch: Throwable -> L228
        int r1 = CursorUtil.getColumnIndex(r3, OaidModel.KEY_ID);     // Catch: Throwable -> L225
        int r6 = CursorUtil.getColumnIndex(r3, "entityId");     // Catch: Throwable -> L225
        int r7 = CursorUtil.getColumnIndex(r3, "createTime");     // Catch: Throwable -> L225
        int r8 = CursorUtil.getColumnIndex(r3, "modifyTime");     // Catch: Throwable -> L225
        int r9 = CursorUtil.getColumnIndex(r3, "type");     // Catch: Throwable -> L225
        int r10 = CursorUtil.getColumnIndex(r3, "timestamp");     // Catch: Throwable -> L225
        int r11 = CursorUtil.getColumnIndex(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L225
        int r12 = CursorUtil.getColumnIndex(r3, "hashCodeValue");     // Catch: Throwable -> L225
        int r13 = CursorUtil.getColumnIndex(r3, Api.KEY_UUID);     // Catch: Throwable -> L225
        int r14 = CursorUtil.getColumnIndex(r3, "semantic_type");     // Catch: Throwable -> L225
        int r15 = CursorUtil.getColumnIndex(r3, "tag_path");     // Catch: Throwable -> L225
        int r4 = CursorUtil.getColumnIndex(r3, "key_phrase");     // Catch: Throwable -> L225
        int r16 = CursorUtil.getColumnIndex(r3, "description");     // Catch: Throwable -> L225
        int r17 = CursorUtil.getColumnIndex(r3, "embedding_content");     // Catch: Throwable -> L225
        int r18 = CursorUtil.getColumnIndex(r3, "sources");     // Catch: Throwable -> L225
        int r19 = CursorUtil.getColumnIndex(r3, "user_edit");     // Catch: Throwable -> L225
        int r20 = CursorUtil.getColumnIndex(r3, "evidence_count");     // Catch: Throwable -> L225
        int r21 = CursorUtil.getColumnIndex(r3, "product_type");     // Catch: Throwable -> L225
        int r22 = CursorUtil.getColumnIndex(r3, "use_for_insight");     // Catch: Throwable -> L225
        int r23 = CursorUtil.getColumnIndex(r3, "use_for_persona");     // Catch: Throwable -> L225
        int r24 = CursorUtil.getColumnIndex(r3, "confidence");     // Catch: Throwable -> L225
        int r25 = CursorUtil.getColumnIndex(r3, "logId");     // Catch: Throwable -> L225
        int r26 = CursorUtil.getColumnIndex(r3, "important_raw_ref_ids");     // Catch: Throwable -> L225
        int r27 = CursorUtil.getColumnIndex(r3, "source_raw_ref_ids");     // Catch: Throwable -> L225
        int r28 = CursorUtil.getColumnIndex(r3, "scene_ids");     // Catch: Throwable -> L225
        int r29 = CursorUtil.getColumnIndex(r3, "sourcePackageName");     // Catch: Throwable -> L225
        int r30 = CursorUtil.getColumnIndex(r3, "change_seq");     // Catch: Throwable -> L225
        int r31 = CursorUtil.getColumnIndex(r3, "confirmation_state");     // Catch: Throwable -> L225
        int r32 = CursorUtil.getColumnIndex(r3, "migration_version");     // Catch: Throwable -> L225
        int r33 = CursorUtil.getColumnIndex(r3, "evidence_ids");     // Catch: Throwable -> L225
        int r34 = CursorUtil.getColumnIndex(r3, "conflict_entity_ids");     // Catch: Throwable -> L225
        int r35 = CursorUtil.getColumnIndex(r3, "last_user_assert_at");     // Catch: Throwable -> L225
        int r36 = CursorUtil.getColumnIndex(r3, "poison_label");     // Catch: Throwable -> L225
        int r37 = CursorUtil.getColumnIndex(r3, "poison_label_version");     // Catch: Throwable -> L225
        int r38 = CursorUtil.getColumnIndex(r3, "content_hash");     // Catch: Throwable -> L225
        ArrayMap<String, ArrayList<fa>> r5 = new ArrayMap();     // Catch: Throwable -> L225
    L6:
        if (r3.moveToNext() == false) goto L11;
        int r39 = r4;
        String r40 = r3.getString(r6);     // Catch: Throwable -> L225
        int r41 = r15;
        int r42 = r14;
        if (((ArrayList) ZeusTransformUtils.preCheckCast(r5.get(r40), ArrayList.class, "com.obric.memorydata.plugin")) != null) goto L10;
        r5.put(r40, new ArrayList());     // Catch: Throwable -> L225
    L10:
        r4 = r39;
        r15 = r41;
        r14 = r42;
        goto L6
    L11:
        int r310 = r4;
        int r43 = r14;
        int r44 = r15;
        int r45 = -1;
        r3.moveToPosition(-1);     // Catch: Throwable -> L225
        __fetchRelationshipProactiveSemanticRelevantDataAscomObricMemorydataDatabaseEntityProactiveSemanticRelevantData(r5);     // Catch: Throwable -> L225
        ArrayList r110 = new ArrayList(r3.getCount());     // Catch: Throwable -> L225
    L13:
        if (r3.moveToNext() == false) goto L221;
        long r46 = 0;
        if (r1 != r45) goto L17;
        long r47 = 0;
    L18:
        if (r6 != r45) goto L21;
    L19:
        String r49 = null;
    L24:
        if (r7 != r45) goto L26;
        long r50 = 0;
    L27:
        if (r8 != r45) goto L29;
        long r52 = 0;
    L30:
        if (r9 != r45) goto L32;
        int r54 = 0;
    L33:
        if (r10 != r45) goto L35;
        long r55 = 0;
    L36:
        if (r11 != r45) goto L39;
    L37:
        String r57 = null;
    L42:
        if (r12 != r45) goto L44;
        int r58 = 0;
    L45:
        if (r13 != r45) goto L48;
    L46:
        String r59 = null;
    L51:
        if (r43 != r45) goto L55;
    L52:
        String r60 = null;
    L53:
        int r85 = r44;
        int r48 = r1;
        if (r85 != r45) goto L62;
    L59:
        String r61 = null;
    L60:
        int r86 = r310;
        if (r86 != r45) goto L69;
    L66:
        String r62 = null;
    L67:
        int r88 = r16;
        if (r88 != r45) goto L76;
    L73:
        String r63 = null;
    L74:
        int r89 = r17;
        if (r89 != r45) goto L83;
    L80:
        String r64 = null;
    L81:
        int r810 = r18;
        if (r810 != r45) goto L90;
    L87:
        String r65 = null;
    L88:
        int r811 = r19;
        if (r811 != r45) goto L97;
        boolean r66 = false;
    L95:
        int r812 = r20;
        if (r812 != r45) goto L104;
        int r67 = 0;
    L103:
        int r813 = r21;
        if (r813 != r45) goto L108;
        int r68 = 0;
    L107:
        int r814 = r22;
        if (r814 != r45) goto L113;
        boolean r69 = false;
    L111:
        int r815 = r23;
        if (r815 != r45) goto L121;
        boolean r70 = false;
    L119:
        int r816 = r24;
        if (r816 != r45) goto L128;
        float r410 = 0.0f;
    L127:
        float r71 = r410;
        int r817 = r25;
        if (r817 != r45) goto L133;
    L130:
        String r72 = null;
    L131:
        int r818 = r26;
        if (r818 != r45) goto L140;
    L137:
        String r73 = null;
    L138:
        int r819 = r27;
        if (r819 != r45) goto L147;
    L144:
        String r74 = null;
    L145:
        int r820 = r28;
        if (r820 != r45) goto L154;
    L151:
        String r75 = null;
    L152:
        int r821 = r29;
        if (r821 != r45) goto L161;
    L158:
        String r76 = null;
    L159:
        int r822 = r30;
        if (r822 != r45) goto L167;
        long r77 = 0;
    L166:
        int r823 = r31;
        if (r823 != r45) goto L172;
    L169:
        String r79 = null;
    L170:
        int r824 = r32;
        if (r824 != r45) goto L178;
        int r80 = 0;
    L177:
        int r825 = r33;
        if (r825 != r45) goto L183;
    L180:
        String r81 = null;
    L181:
        int r826 = r34;
        if (r826 != r45) goto L190;
    L187:
        String r82 = null;
    L188:
        int r827 = r35;
        if (r827 == r45) goto L196;
        r46 = r3.getLong(r827);     // Catch: Throwable -> L225
    L196:
        ip r51 = new ip(r47, r49, r50, r52, r54, r55, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r79, r80, r81, r82, r46);     // Catch: Throwable -> L225
        int r2 = r36;
        int r311 = r7;
        if (r2 != (-1)) goto L199;
        int r53 = -1;
        int r56 = r37;
    L204:
        if (r56 != r53) goto L206;
        int r828 = r56;
        int r78 = r53;
        int r312 = r828;
    L211:
        if (r38 != r78) goto L213;
    L217:
        int r411 = r38;
        ArrayList r83 = (ArrayList) ZeusTransformUtils.preCheckCast(r5.get(r3.getString(r6)), ArrayList.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L225
        if (r83 != null) goto L220;
        r83 = new ArrayList();     // Catch: Throwable -> L225
    L220:
        r110.add(new ih(r51, r83));     // Catch: Throwable -> L225
        r7 = r311;
        r36 = r2;
        r37 = r312;
        r1 = r48;
        r38 = r411;
        r45 = -1;
        r43 = r43;
        r44 = r85;
        r310 = r86;
        r16 = r88;
        r17 = r89;
        r18 = r810;
        r19 = r811;
        r20 = r812;
        r21 = r813;
        r22 = r814;
        r23 = r815;
        r24 = r816;
        r25 = r817;
        r26 = r818;
        r27 = r819;
        r28 = r820;
        r29 = r821;
        r30 = r822;
        r31 = r823;
        r32 = r824;
        r33 = r825;
        r34 = r826;
        r35 = r827;
        goto L13
    L213:
        if (r3.isNull(r38) == false) goto L215;
        String r84 = null;
    L216:
        r51.setContentHash(r84);     // Catch: Throwable -> L225
        goto L217
    L215:
        r84 = r3.getString(r38);     // Catch: Throwable -> L225
        goto L216
    L206:
        if (r3.isNull(r56) == false) goto L208;
        Integer r90 = null;
    L209:
        r51.setPoisonLabelVersion(r90);     // Catch: Throwable -> L225
        r312 = r56;
        r78 = -1;
        goto L211
    L208:
        r90 = Integer.valueOf(r3.getInt(r56));     // Catch: Throwable -> L225
        goto L209
    L199:
        if (r3.isNull(r2) == false) goto L201;
        Integer r91 = null;
    L202:
        r51.setPoisonLabel(r91);     // Catch: Throwable -> L225
        r56 = r37;
        r53 = -1;
        goto L204
    L201:
        r91 = Integer.valueOf(r3.getInt(r2));     // Catch: Throwable -> L225
        goto L202
    L190:
        if (r3.isNull(r826) == true) goto L187;
        r82 = r3.getString(r826);     // Catch: Throwable -> L225
        goto L188
    L183:
        if (r3.isNull(r825) == true) goto L180;
        r81 = r3.getString(r825);     // Catch: Throwable -> L225
        goto L181
    L178:
        r80 = r3.getInt(r824);     // Catch: Throwable -> L225
        goto L177
    L172:
        if (r3.isNull(r823) == true) goto L169;
        r79 = r3.getString(r823);     // Catch: Throwable -> L225
        goto L170
    L167:
        r77 = r3.getLong(r822);     // Catch: Throwable -> L225
        goto L166
    L161:
        if (r3.isNull(r821) == true) goto L158;
        r76 = r3.getString(r821);     // Catch: Throwable -> L225
        goto L159
    L154:
        if (r3.isNull(r820) == true) goto L151;
        r75 = r3.getString(r820);     // Catch: Throwable -> L225
        goto L152
    L147:
        if (r3.isNull(r819) == true) goto L144;
        r74 = r3.getString(r819);     // Catch: Throwable -> L225
        goto L145
    L140:
        if (r3.isNull(r818) == true) goto L137;
        r73 = r3.getString(r818);     // Catch: Throwable -> L225
        goto L138
    L133:
        if (r3.isNull(r817) == true) goto L130;
        r72 = r3.getString(r817);     // Catch: Throwable -> L225
        goto L131
    L128:
        r410 = r3.getFloat(r816);     // Catch: Throwable -> L225
        goto L127
    L121:
        if (r3.getInt(r815) == 0) goto L123;
        boolean r412 = true;
    L124:
        r70 = r412;
        goto L119
    L123:
        r412 = false;
        goto L124
    L113:
        if (r3.getInt(r814) == 0) goto L115;
        boolean r413 = true;
    L116:
        r69 = r413;
        goto L111
    L115:
        r413 = false;
        goto L116
    L108:
        r68 = r3.getInt(r813);     // Catch: Throwable -> L225
        goto L107
    L104:
        r67 = r3.getInt(r812);     // Catch: Throwable -> L225
        goto L103
    L97:
        if (r3.getInt(r811) == 0) goto L99;
        boolean r414 = true;
    L100:
        r66 = r414;
        goto L95
    L99:
        r414 = false;
        goto L100
    L90:
        if (r3.isNull(r810) == true) goto L87;
        r65 = r3.getString(r810);     // Catch: Throwable -> L225
        goto L88
    L83:
        if (r3.isNull(r89) == true) goto L80;
        r64 = r3.getString(r89);     // Catch: Throwable -> L225
        goto L81
    L76:
        if (r3.isNull(r88) == true) goto L73;
        r63 = r3.getString(r88);     // Catch: Throwable -> L225
        goto L74
    L69:
        if (r3.isNull(r86) == true) goto L66;
        r62 = r3.getString(r86);     // Catch: Throwable -> L225
        goto L67
    L62:
        if (r3.isNull(r85) == true) goto L59;
        r61 = r3.getString(r85);     // Catch: Throwable -> L225
        goto L60
    L55:
        if (r3.isNull(r43) == true) goto L52;
        r60 = r3.getString(r43);     // Catch: Throwable -> L225
        goto L53
    L48:
        if (r3.isNull(r13) == true) goto L46;
        r59 = r3.getString(r13);     // Catch: Throwable -> L225
        goto L51
    L44:
        r58 = r3.getInt(r12);     // Catch: Throwable -> L225
        goto L45
    L39:
        if (r3.isNull(r11) == true) goto L37;
        r57 = r3.getString(r11);     // Catch: Throwable -> L225
        goto L42
    L35:
        r55 = r3.getLong(r10);     // Catch: Throwable -> L225
        goto L36
    L32:
        r54 = r3.getInt(r9);     // Catch: Throwable -> L225
        goto L33
    L29:
        r52 = r3.getLong(r8);     // Catch: Throwable -> L225
        goto L30
    L26:
        r50 = r3.getLong(r7);     // Catch: Throwable -> L225
        goto L27
    L21:
        if (r3.isNull(r6) == true) goto L19;
        r49 = r3.getString(r6);     // Catch: Throwable -> L225
        goto L24
    L17:
        r47 = r3.getLong(r1);     // Catch: Throwable -> L225
        goto L18
    L221:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L225
        r3.close();     // Catch: Throwable -> L228
        this.__db.endTransaction();
        return r110;
    L225:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L228
        throw th;     // Catch: Throwable -> L228
    L228:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<ip> queryRecentByPackageName(String r1, long r2) {
        return SemanticMemoryDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public List<SemanticConflictSnapshot> queryReviewConflictSnapshots() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT entityId, change_seq AS changeSeq, conflict_entity_ids AS conflictEntityIds FROM UnionSemanticMemory WHERE (confidence = 3.0 AND confirmation_state = 'pending') OR confidence = 4.0", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r9 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r9.getCount());     // Catch: Throwable -> L18
    L4:
        if (r9.moveToNext() == false) goto L16;
        if (r9.isNull(0) == false) goto L9;
        String r4 = null;
    L10:
        long r5 = r9.getLong(1);     // Catch: Throwable -> L18
        if (r9.isNull(2) == false) goto L13;
        String r7 = null;
    L14:
        r3.add(new SemanticConflictSnapshot(r4, r5, r7));     // Catch: Throwable -> L18
        goto L4
    L13:
        r7 = r9.getString(2);     // Catch: Throwable -> L18
        goto L14
    L9:
        r4 = r9.getString(0);     // Catch: Throwable -> L18
        goto L10
    L16:
        r9.close();
        r0.release();
        return r3;
    L18:
        th = move-exception;
        r9.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ip> queryWithLimitAndOffset(int r1, int r2) {
        return SemanticMemoryDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ip> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityUnionSemanticMemoryEntity(r6));     // Catch: Throwable -> L10
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

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int requeueConflictKeeper(String r3, long r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfRequeueConflictKeeper.acquire();
        r0.bindLong(1, r4);
        if (r3 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfRequeueConflictKeeper.release(r0);
        return r5;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfRequeueConflictKeeper.release(r0);
        throw th;
    L5:
        r0.bindString(2, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public void resetAllUseForInsight() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfResetAllUseForInsight.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfResetAllUseForInsight.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfResetAllUseForInsight.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public void resetAllUseForPersona() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfResetAllUseForPersona.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfResetAllUseForPersona.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfResetAllUseForPersona.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public void resetSequence() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfResetSequence.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfResetSequence.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfResetSequence.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public void resetUseForInsightBySemanticType(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfResetUseForInsightBySemanticType.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfResetUseForInsightBySemanticType.release(r0);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfResetUseForInsightBySemanticType.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public void resetUseForInsightBySemanticTypeAndTagPath(String r3, String r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfResetUseForInsightBySemanticTypeAndTagPath.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r4 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfResetUseForInsightBySemanticTypeAndTagPath.release(r0);
        return;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfResetUseForInsightBySemanticTypeAndTagPath.release(r0);
        throw th;
    L9:
        r0.bindString(2, r4);
        goto L10
    L5:
        r0.bindString(1, r3);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public void resetUseForPersonaBySemanticType(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfResetUseForPersonaBySemanticType.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfResetUseForPersonaBySemanticType.release(r0);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfResetUseForPersonaBySemanticType.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int update(ip r2) {
        this.__db.beginTransaction();
        int r3 = SemanticMemoryDao.DefaultImpls.update(this, r2);     // Catch: Throwable -> L6
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
        return update((ip) ZeusTransformUtils.preCheckCast(r3, ip.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao, com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ip> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        SemanticMemoryDao.DefaultImpls.updateAll(this, r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public void updateAllRaw(List<ip> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfUnionSemanticMemoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor updateByRawQuery(SupportSQLiteQuery r3) {
        SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        return this.__db.query(r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int updatePoisonLabelIfContentHashMatches(String r1, String r2, int r3, Integer r4) {
        return SemanticMemoryDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public int updateRaw(ip r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfUnionSemanticMemoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public void updateUseForInsight(List<Long> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE UnionSemanticMemory SET use_for_insight = 1 WHERE id IN (");
        StringUtil.appendPlaceholders(r0, r8.size());
        r0.append(")");
        SupportSQLiteStatement r1 = this.__db.compileStatement(r0.toString());
        Iterator r9 = r8.iterator();
        int r3 = 1;
    L4:
        if (r9.hasNext() == false) goto L6;
        r1.bindLong(r3, ((Long) ZeusTransformUtils.preCheckCast(r9.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r3 = r3 + 1;
        goto L4
    L6:
        this.__db.beginTransaction();
        r1.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticMemoryDao
    public void updateUseForPersona(List<Long> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE UnionSemanticMemory SET use_for_persona = 1 WHERE id IN (");
        StringUtil.appendPlaceholders(r0, r8.size());
        r0.append(")");
        SupportSQLiteStatement r1 = this.__db.compileStatement(r0.toString());
        Iterator r9 = r8.iterator();
        int r3 = 1;
    L4:
        if (r9.hasNext() == false) goto L6;
        r1.bindLong(r3, ((Long) ZeusTransformUtils.preCheckCast(r9.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r3 = r3 + 1;
        goto L4
    L6:
        this.__db.beginTransaction();
        r1.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
