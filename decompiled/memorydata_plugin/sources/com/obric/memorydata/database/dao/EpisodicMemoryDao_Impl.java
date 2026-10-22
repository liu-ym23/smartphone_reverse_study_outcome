package com.obric.memorydata.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.collection.ArrayMap;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.al;
import com.obric.memorydata.database.entity.bt;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.es;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class EpisodicMemoryDao_Impl implements EpisodicMemoryDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<EpisodicMemoryEntity> __deletionAdapterOfEpisodicMemoryEntity;
    private final EntityInsertionAdapter<EpisodicMemoryEntity> __insertionAdapterOfEpisodicMemoryEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;
    private final SharedSQLiteStatement __preparedStmtOfResetSequence;
    private final EntityDeletionOrUpdateAdapter<EpisodicMemoryEntity> __updateAdapterOfEpisodicMemoryEntity;

    public EpisodicMemoryDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfEpisodicMemoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfEpisodicMemoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfEpisodicMemoryEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteById = new AnonymousClass4(this, r2);
        this.__preparedStmtOfResetSequence = new AnonymousClass5(this, r2);
    }

    private EpisodicMemoryEntity __entityCursorConverter_comObricMemorydataDatabaseEntityEpisodicMemoryEntity(Cursor r95) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r95, Cursor.class, "com.obric.memorydata.plugin");
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
        int r126 = CursorUtil.getColumnIndex(r0, "eventName");
        int r127 = CursorUtil.getColumnIndex(r0, "rawTableName");
        int r128 = CursorUtil.getColumnIndex(r0, "rawDbId");
        int r129 = CursorUtil.getColumnIndex(r0, "eventData");
        int r130 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r131 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r132 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r41 = 0;
        if (r1 != (-1)) goto L5;
        long r47 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r49 = 0;
    L9:
        if (r3 != (-1)) goto L11;
        long r51 = 0;
    L12:
        String r20 = null;
        if (r4 != (-1)) goto L16;
    L14:
        String r53 = null;
    L19:
        if (r5 != (-1)) goto L22;
    L20:
        String r54 = null;
    L25:
        if (r6 != (-1)) goto L28;
    L26:
        String r55 = null;
    L31:
        if (r7 != (-1)) goto L34;
    L32:
        String r56 = null;
    L37:
        if (r8 != (-1)) goto L40;
    L38:
        String r57 = null;
    L43:
        if (r9 != (-1)) goto L46;
    L44:
        String r58 = null;
    L49:
        if (r10 != (-1)) goto L52;
    L50:
        String r59 = null;
    L55:
        if (r11 != (-1)) goto L58;
    L56:
        Integer r60 = null;
    L61:
        if (r12 != (-1)) goto L64;
    L62:
        Integer r61 = null;
    L67:
        if (r13 != (-1)) goto L70;
    L68:
        String r62 = null;
    L73:
        if (r14 != (-1)) goto L76;
    L74:
        String r63 = null;
    L79:
        if (r94 != (-1)) goto L82;
    L80:
        String r64 = null;
    L85:
        boolean r21 = true;
        if (r16 != (-1)) goto L90;
        Boolean r65 = null;
    L101:
        if (r17 != (-1)) goto L105;
        Boolean r66 = null;
    L116:
        if (r18 != (-1)) goto L120;
        boolean r67 = false;
    L124:
        if (r19 != (-1)) goto L126;
        long r68 = 0;
    L127:
        if (r19 != (-1)) goto L129;
        long r70 = 0;
    L130:
        if (r20 != (-1)) goto L134;
        Boolean r72 = null;
    L145:
        if (r112 != (-1)) goto L149;
    L146:
        String r73 = null;
    L152:
        if (r113 != (-1)) goto L154;
        long r74 = 0;
    L155:
        if (r23 != (-1)) goto L157;
        long r76 = 0;
    L158:
        if (r24 != (-1)) goto L160;
        int r78 = 0;
    L162:
        if (r116 == (-1)) goto L165;
        r41 = r0.getLong(r116);
    L165:
        long r79 = r41;
        if (r117 != (-1)) goto L170;
    L167:
        String r81 = null;
    L173:
        if (r118 != (-1)) goto L175;
        int r82 = 0;
    L177:
        if (r119 != (-1)) goto L181;
    L178:
        String r83 = null;
    L184:
        if (r120 != (-1)) goto L188;
        Boolean r84 = null;
    L199:
        if (r121 != (-1)) goto L201;
        int r85 = 0;
    L203:
        if (r122 != (-1)) goto L207;
    L204:
        String r86 = null;
    L210:
        if (r123 != (-1)) goto L214;
    L211:
        String r87 = null;
    L217:
        if (r124 != (-1)) goto L221;
    L218:
        String r88 = null;
    L224:
        if (r125 != (-1)) goto L228;
    L225:
        String r89 = null;
    L231:
        if (r126 != (-1)) goto L235;
    L232:
        String r90 = null;
    L238:
        if (r127 != (-1)) goto L242;
    L239:
        String r91 = null;
    L245:
        if (r128 != (-1)) goto L249;
    L246:
        Long r92 = null;
    L252:
        if (r129 != (-1)) goto L255;
    L253:
        String r93 = null;
    L258:
        EpisodicMemoryEntity r22 = new EpisodicMemoryEntity(r47, r49, r51, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r70, r72, r73, r74, r76, r78, r79, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93);
        if (r130 == (-1)) goto L266;
        if (r0.isNull(r130) == false) goto L263;
        Integer r23 = null;
    L264:
        r22.setPoisonLabel(r23);
        goto L266
    L263:
        r23 = Integer.valueOf(r0.getInt(r130));
    L266:
        if (r131 == (-1)) goto L273;
        if (r0.isNull(r131) == false) goto L270;
        Integer r24 = null;
    L271:
        r22.setPoisonLabelVersion(r24);
        goto L273
    L270:
        r24 = Integer.valueOf(r0.getInt(r131));
    L273:
        if (r132 != (-1)) goto L275;
    L279:
        return r22;
    L275:
        if (r0.isNull(r132) == true) goto L278;
        r20 = r0.getString(r132);
    L278:
        r22.setContentHash(r20);
        goto L279
    L255:
        if (r0.isNull(r129) == true) goto L253;
        r93 = r0.getString(r129);
        goto L258
    L249:
        if (r0.isNull(r128) == true) goto L246;
        r92 = Long.valueOf(r0.getLong(r128));
        goto L252
    L242:
        if (r0.isNull(r127) == true) goto L239;
        r91 = r0.getString(r127);
        goto L245
    L235:
        if (r0.isNull(r126) == true) goto L232;
        r90 = r0.getString(r126);
        goto L238
    L228:
        if (r0.isNull(r125) == true) goto L225;
        r89 = r0.getString(r125);
        goto L231
    L221:
        if (r0.isNull(r124) == true) goto L218;
        r88 = r0.getString(r124);
        goto L224
    L214:
        if (r0.isNull(r123) == true) goto L211;
        r87 = r0.getString(r123);
        goto L217
    L207:
        if (r0.isNull(r122) == true) goto L204;
        r86 = r0.getString(r122);
        goto L210
    L201:
        r85 = r0.getInt(r121);
        goto L203
    L188:
        if (r0.isNull(r120) == false) goto L190;
        Integer r25 = null;
    L191:
        if (r25 != null) goto L194;
        Boolean r26 = null;
    L198:
        r84 = r26;
        goto L199
    L194:
        if (r25.intValue() != 0) goto L197;
        r21 = false;
    L197:
        r26 = Boolean.valueOf(r21);
        goto L198
    L190:
        r25 = Integer.valueOf(r0.getInt(r120));
        goto L191
    L181:
        if (r0.isNull(r119) == true) goto L178;
        r83 = r0.getString(r119);
        goto L184
    L175:
        r82 = r0.getInt(r118);
        goto L177
    L170:
        if (r0.isNull(r117) == true) goto L167;
        r81 = r0.getString(r117);
        goto L173
    L160:
        r78 = r0.getInt(r115);
        goto L162
    L157:
        r76 = r0.getLong(r114);
        goto L158
    L154:
        r74 = r0.getLong(r113);
        goto L155
    L149:
        if (r0.isNull(r112) == true) goto L146;
        r73 = r0.getString(r112);
        goto L152
    L134:
        if (r0.isNull(r20) == false) goto L136;
        Integer r27 = null;
    L137:
        if (r27 != null) goto L140;
        Boolean r28 = null;
    L144:
        r72 = r28;
        goto L145
    L140:
        if (r27.intValue() == 0) goto L142;
        boolean r29 = true;
    L143:
        r28 = Boolean.valueOf(r29);
        goto L144
    L142:
        r29 = false;
        goto L143
    L136:
        r27 = Integer.valueOf(r0.getInt(r111));
        goto L137
    L129:
        r70 = r0.getLong(r110);
        goto L130
    L126:
        r68 = r0.getLong(r19);
        goto L127
    L120:
        if (r0.getInt(r18) == 0) goto L122;
        boolean r30 = true;
    L123:
        r67 = r30;
        goto L124
    L122:
        r30 = false;
        goto L123
    L105:
        if (r0.isNull(r17) == false) goto L107;
        Integer r31 = null;
    L108:
        if (r31 != null) goto L111;
        Boolean r32 = null;
    L115:
        r66 = r32;
        goto L116
    L111:
        if (r31.intValue() == 0) goto L113;
        boolean r33 = true;
    L114:
        r32 = Boolean.valueOf(r33);
        goto L115
    L113:
        r33 = false;
        goto L114
    L107:
        r31 = Integer.valueOf(r0.getInt(r17));
        goto L108
    L90:
        if (r0.isNull(r16) == false) goto L92;
        Integer r34 = null;
    L93:
        if (r34 != null) goto L96;
        Boolean r35 = null;
    L100:
        r65 = r35;
        goto L101
    L96:
        if (r34.intValue() == 0) goto L98;
        boolean r36 = true;
    L99:
        r35 = Boolean.valueOf(r36);
        goto L100
    L98:
        r36 = false;
        goto L99
    L92:
        r34 = Integer.valueOf(r0.getInt(r16));
        goto L93
    L82:
        if (r0.isNull(r94) == true) goto L80;
        r64 = r0.getString(r15);
        goto L85
    L76:
        if (r0.isNull(r14) == true) goto L74;
        r63 = r0.getString(r14);
        goto L79
    L70:
        if (r0.isNull(r13) == true) goto L68;
        r62 = r0.getString(r13);
        goto L73
    L64:
        if (r0.isNull(r12) == true) goto L62;
        r61 = Integer.valueOf(r0.getInt(r12));
        goto L67
    L58:
        if (r0.isNull(r11) == true) goto L56;
        r60 = Integer.valueOf(r0.getInt(r11));
        goto L61
    L52:
        if (r0.isNull(r10) == true) goto L50;
        r59 = r0.getString(r10);
        goto L55
    L46:
        if (r0.isNull(r9) == true) goto L44;
        r58 = r0.getString(r9);
        goto L49
    L40:
        if (r0.isNull(r8) == true) goto L38;
        r57 = r0.getString(r8);
        goto L43
    L34:
        if (r0.isNull(r7) == true) goto L32;
        r56 = r0.getString(r7);
        goto L37
    L28:
        if (r0.isNull(r6) == true) goto L26;
        r55 = r0.getString(r6);
        goto L31
    L22:
        if (r0.isNull(r5) == true) goto L20;
        r54 = r0.getString(r5);
        goto L25
    L16:
        if (r0.isNull(r4) == true) goto L14;
        r53 = r0.getString(r4);
        goto L19
    L11:
        r51 = r0.getLong(r3);
        goto L12
    L8:
        r49 = r0.getLong(r2);
        goto L9
    L5:
        r47 = r0.getLong(r1);
        goto L6
    }

    private void __fetchRelationshipProactiveEpisodicRelevantDataAscomObricMemorydataDatabaseEntityProactiveEpisodicRelevantData(ArrayMap<String, ArrayList<es>> r30) {
        Set<String> r2 = r30.keySet();
        if (r2.isEmpty() == false) goto L6;
        return;
    L6:
        if (r30.size() <= 999) goto L15;
        ArrayMap<String, ArrayList<es>> r3 = new ArrayMap(999);
        int r4 = r30.size();
        int r7 = 0;
        int r8 = 0;
    L8:
        if (r7 >= r4) goto L12;
        r3.put((String) ZeusTransformUtils.preCheckCast(r30.keyAt(r7), String.class, "com.obric.memorydata.plugin"), (ArrayList) ZeusTransformUtils.preCheckCast(r30.valueAt(r7), ArrayList.class, "com.obric.memorydata.plugin"));
        r7 = r7 + 1;
        r8 = r8 + 1;
        if (r8 != 999) goto L8;
        __fetchRelationshipProactiveEpisodicRelevantDataAscomObricMemorydataDatabaseEntityProactiveEpisodicRelevantData(r3);
        r3 = new ArrayMap(999);
        r8 = 0;
        goto L8
    L12:
        if (r8 <= 0) goto L115;
        __fetchRelationshipProactiveEpisodicRelevantDataAscomObricMemorydataDatabaseEntityProactiveEpisodicRelevantData(r3);
        return;
    L115:
        return;
    L15:
        StringBuilder r5 = StringUtil.newStringBuilder();
        r5.append("SELECT `id`,`episodic_id`,`source_query`,`source_text`,`source_link`,`source_link_type`,`screenshot`,`source_package_name`,`source_app_name`,`product_type`,`category`,`tag_list`,`summary`,`detail_status`,`in_app_object_id`,`in_app_rule_family`,`in_app_activity_name`,`in_app_event_time` FROM `ProactiveEpisodicRelevantData` WHERE `episodic_id` IN (");
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
        int r0 = CursorUtil.getColumnIndex(r13, "episodic_id");     // Catch: Throwable -> L97
        if (r0 != (-1)) goto L29;
        r13.close();
        return;
    L29:
        if (r13.moveToNext() == false) goto L95;
        ArrayList r14 = (ArrayList) ZeusTransformUtils.preCheckCast(r30.get(r13.getString(r0)), ArrayList.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L97
        if (r14 == null) goto L29;
        long r15 = r13.getLong(0);     // Catch: Throwable -> L97
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
    L58:
        if (r13.isNull(7) == false) goto L60;
        String r112 = null;
    L62:
        if (r13.isNull(8) == false) goto L64;
        String r113 = null;
    L65:
        int r114 = r13.getInt(9);     // Catch: Throwable -> L97
        if (r13.isNull(10) == false) goto L68;
        String r20 = null;
    L70:
        if (r13.isNull(11) == false) goto L72;
        String r21 = null;
    L74:
        if (r13.isNull(12) == false) goto L76;
        String r22 = null;
    L77:
        int r23 = r13.getInt(13);     // Catch: Throwable -> L97
        if (r13.isNull(14) == false) goto L80;
        String r24 = null;
    L82:
        if (r13.isNull(15) == false) goto L84;
        String r25 = null;
    L86:
        if (r13.isNull(16) == false) goto L88;
        String r26 = null;
    L90:
        if (r13.isNull(17) == false) goto L92;
        Long r27 = null;
    L93:
        r14.add(new es(r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r20, r21, r22, r23, r24, r25, r26, r27));     // Catch: Throwable -> L97
        goto L29
    L92:
        r27 = Long.valueOf(r13.getLong(17));     // Catch: Throwable -> L97
        goto L93
    L88:
        r26 = r13.getString(16);     // Catch: Throwable -> L97
        goto L90
    L84:
        r25 = r13.getString(15);     // Catch: Throwable -> L97
        goto L86
    L80:
        r24 = r13.getString(14);     // Catch: Throwable -> L97
        goto L82
    L76:
        r22 = r13.getString(12);     // Catch: Throwable -> L97
        goto L77
    L72:
        r21 = r13.getString(11);     // Catch: Throwable -> L97
        goto L74
    L68:
        r20 = r13.getString(10);     // Catch: Throwable -> L97
        goto L70
    L64:
        r113 = r13.getString(8);     // Catch: Throwable -> L97
        goto L65
    L60:
        r112 = r13.getString(7);     // Catch: Throwable -> L97
        goto L62
    L56:
        r111 = r13.getString(6);     // Catch: Throwable -> L97
        goto L58
    L52:
        r110 = r13.getString(5);     // Catch: Throwable -> L97
        goto L54
    L48:
        r19 = r13.getString(4);     // Catch: Throwable -> L97
        goto L50
    L44:
        r18 = r13.getString(3);     // Catch: Throwable -> L97
        goto L46
    L40:
        r17 = r13.getString(2);     // Catch: Throwable -> L97
        goto L42
    L36:
        r16 = r13.getString(1);     // Catch: Throwable -> L97
        goto L38
    L95:
        r13.close();
        return;
    L97:
        th = move-exception;
        r13.close();
        throw th;
    }

    static /* synthetic */ void access$000(EpisodicMemoryDao_Impl r0, ArrayMap r1) {
        r0.__fetchRelationshipProactiveEpisodicRelevantDataAscomObricMemorydataDatabaseEntityProactiveEpisodicRelevantData(r1);
    }

    static /* synthetic */ RoomDatabase access$100(EpisodicMemoryDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return EpisodicMemoryDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<EpisodicMemoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfEpisodicMemoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<EpisodicMemoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfEpisodicMemoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
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

    public int delete(EpisodicMemoryEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfEpisodicMemoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r3, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return EpisodicMemoryDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public int deleteById(long r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteById.acquire();
        r0.bindLong(1, r3);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteById.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteById.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return EpisodicMemoryDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public i<Integer> getAllCollectMemoryWithRelevantCount() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM ShortMemory m INNER JOIN ProactiveEpisodicRelevantData r ON m.entityId = r.episodic_id WHERE m.productType = 1003 AND NULLIF(TRIM(r.source_package_name), '') IS NOT NULL AND NULLIF(TRIM(r.source_app_name), '') IS NOT NULL", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ShortMemory", "ProactiveEpisodicRelevantData"}, new AnonymousClass8(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public PagingSource<Integer, bt> getAllCollectMemoryWithRelevantPojo() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT m.* FROM ShortMemory m INNER JOIN ProactiveEpisodicRelevantData r ON m.entityId = r.episodic_id WHERE m.productType = 1003 AND NULLIF(TRIM(r.source_package_name), '') IS NOT NULL AND NULLIF(TRIM(r.source_app_name), '') IS NOT NULL ORDER BY m.modifyTime DESC", 0);
        final RoomDatabase r2 = this.__db;
        final String[] r3 = {"ProactiveEpisodicRelevantData", "ShortMemory"};
        return new AnonymousClass6(this, r0, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<EpisodicMemoryEntity> getAllMemory() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ShortMemory WHERE category = 0 AND productType != 1004 ORDER BY createTime ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L171
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "actionTimestamp");     // Catch: Throwable -> L171
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "uid");     // Catch: Throwable -> L171
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "title");     // Catch: Throwable -> L171
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, Params.CONTENT);     // Catch: Throwable -> L171
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "contentWithTime");     // Catch: Throwable -> L171
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "fullContent");     // Catch: Throwable -> L171
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "observation");     // Catch: Throwable -> L171
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "location");     // Catch: Throwable -> L171
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "appNames");     // Catch: Throwable -> L171
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L171
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, "profileType");     // Catch: Throwable -> L171
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "profileTag");     // Catch: Throwable -> L171
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "tagOther");     // Catch: Throwable -> L171
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "logId");     // Catch: Throwable -> L169
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "usedForPortrait");     // Catch: Throwable -> L169
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "useLocation");     // Catch: Throwable -> L169
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "useForUserKeyword");     // Catch: Throwable -> L169
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "startTimestamp");     // Catch: Throwable -> L169
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "endTimestamp");     // Catch: Throwable -> L169
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "useForTopic");     // Catch: Throwable -> L169
        int r24 = CursorUtil.getColumnIndexOrThrow(r4, "entityId");     // Catch: Throwable -> L169
        int r25 = CursorUtil.getColumnIndexOrThrow(r4, "createTime");     // Catch: Throwable -> L169
        int r26 = CursorUtil.getColumnIndexOrThrow(r4, "modifyTime");     // Catch: Throwable -> L169
        int r27 = CursorUtil.getColumnIndexOrThrow(r4, "type");     // Catch: Throwable -> L169
        int r28 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L169
        int r29 = CursorUtil.getColumnIndexOrThrow(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L169
        int r30 = CursorUtil.getColumnIndexOrThrow(r4, "hashCodeValue");     // Catch: Throwable -> L169
        int r31 = CursorUtil.getColumnIndexOrThrow(r4, Api.KEY_UUID);     // Catch: Throwable -> L169
        int r32 = CursorUtil.getColumnIndexOrThrow(r4, "userEdit");     // Catch: Throwable -> L169
        int r33 = CursorUtil.getColumnIndexOrThrow(r4, "productType");     // Catch: Throwable -> L169
        int r34 = CursorUtil.getColumnIndexOrThrow(r4, "important_raw_ref_ids");     // Catch: Throwable -> L169
        int r35 = CursorUtil.getColumnIndexOrThrow(r4, "source_raw_ref_ids");     // Catch: Throwable -> L169
        int r36 = CursorUtil.getColumnIndexOrThrow(r4, "scene_ids");     // Catch: Throwable -> L169
        int r37 = CursorUtil.getColumnIndexOrThrow(r4, "sourcePackageName");     // Catch: Throwable -> L169
        int r38 = CursorUtil.getColumnIndexOrThrow(r4, "eventName");     // Catch: Throwable -> L169
        int r39 = CursorUtil.getColumnIndexOrThrow(r4, "rawTableName");     // Catch: Throwable -> L169
        int r40 = CursorUtil.getColumnIndexOrThrow(r4, "rawDbId");     // Catch: Throwable -> L169
        int r41 = CursorUtil.getColumnIndexOrThrow(r4, "eventData");     // Catch: Throwable -> L169
        int r42 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label");     // Catch: Throwable -> L169
        int r43 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label_version");     // Catch: Throwable -> L169
        int r44 = CursorUtil.getColumnIndexOrThrow(r4, "content_hash");     // Catch: Throwable -> L169
        int r45 = r3;
        ArrayList r46 = new ArrayList(r4.getCount());     // Catch: Throwable -> L169
    L6:
        if (r4.moveToNext() == false) goto L167;
        long r47 = r4.getLong(r0);     // Catch: Throwable -> L169
        long r49 = r4.getLong(r5);     // Catch: Throwable -> L169
        long r51 = r4.getLong(r6);     // Catch: Throwable -> L169
        if (r4.isNull(r7) == false) goto L11;
        String r53 = null;
    L13:
        if (r4.isNull(r8) == false) goto L15;
        String r54 = null;
    L17:
        if (r4.isNull(r9) == false) goto L19;
        String r55 = null;
    L21:
        if (r4.isNull(r10) == false) goto L23;
        String r56 = null;
    L25:
        if (r4.isNull(r11) == false) goto L27;
        String r57 = null;
    L29:
        if (r4.isNull(r12) == false) goto L31;
        String r58 = null;
    L33:
        if (r4.isNull(r13) == false) goto L35;
        String r59 = null;
    L37:
        if (r4.isNull(r14) == false) goto L39;
        Integer r60 = null;
    L41:
        if (r4.isNull(r15) == false) goto L43;
        Integer r61 = null;
    L45:
        if (r4.isNull(r2) == false) goto L47;
        String r62 = null;
    L49:
        if (r4.isNull(r45) == false) goto L52;
        String r63 = null;
    L51:
        int r94 = r17;
        int r110 = r0;
        if (r4.isNull(r94) == false) goto L57;
        String r64 = null;
    L56:
        int r95 = r18;
        if (r4.isNull(r95) == false) goto L61;
        Integer r48 = null;
    L62:
        boolean r410 = true;
        if (r48 != null) goto L67;
        Boolean r65 = null;
    L65:
        int r96 = r19;
        if (r4.isNull(r96) == false) goto L74;
        Integer r411 = null;
    L75:
        if (r411 != null) goto L79;
        Boolean r66 = null;
    L77:
        int r97 = r20;
        if (r4.getInt(r97) == 0) goto L86;
        boolean r67 = true;
    L87:
        int r98 = r21;
        long r68 = r4.getLong(r98);     // Catch: Throwable -> L169
        int r50 = r22;
        long r70 = r4.getLong(r50);     // Catch: Throwable -> L169
        r22 = r50;
        r23 = r23;
        if (r4.isNull(r23) == false) goto L90;
        Integer r210 = null;
    L91:
        if (r210 != null) goto L94;
        Boolean r72 = null;
    L99:
        if (r4.isNull(r24) == false) goto L101;
        String r73 = null;
    L102:
        long r74 = r4.getLong(r25);     // Catch: Throwable -> L169
        r25 = r25;
        int r52 = r26;
        long r76 = r4.getLong(r52);     // Catch: Throwable -> L169
        r26 = r52;
        int r69 = r27;
        int r78 = r4.getInt(r69);     // Catch: Throwable -> L169
        r27 = r69;
        int r71 = r28;
        long r79 = r4.getLong(r71);     // Catch: Throwable -> L169
        r28 = r71;
        r29 = r29;
        if (r4.isNull(r29) == false) goto L105;
        String r81 = null;
    L106:
        int r82 = r4.getInt(r30);     // Catch: Throwable -> L169
        r30 = r30;
        r31 = r31;
        if (r4.isNull(r31) == false) goto L109;
        String r83 = null;
    L111:
        if (r4.isNull(r32) == false) goto L113;
        Integer r310 = null;
    L114:
        if (r310 != null) goto L117;
        Boolean r84 = null;
    L121:
        int r85 = r4.getInt(r33);     // Catch: Throwable -> L169
        r33 = r33;
        r34 = r34;
        if (r4.isNull(r34) == false) goto L124;
        String r86 = null;
    L126:
        if (r4.isNull(r35) == false) goto L128;
        String r87 = null;
    L130:
        if (r4.isNull(r36) == false) goto L132;
        String r88 = null;
    L134:
        if (r4.isNull(r37) == false) goto L136;
        String r89 = null;
    L138:
        if (r4.isNull(r38) == false) goto L140;
        String r90 = null;
    L142:
        if (r4.isNull(r39) == false) goto L144;
        String r91 = null;
    L146:
        if (r4.isNull(r40) == false) goto L148;
        Long r92 = null;
    L150:
        if (r4.isNull(r41) == false) goto L152;
        String r93 = null;
    L153:
        EpisodicMemoryEntity r75 = new EpisodicMemoryEntity(r47, r49, r51, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r70, r72, r73, r74, r76, r78, r79, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93);     // Catch: Throwable -> L169
        int r412 = r2;
        int r77 = r42;
        if (r4.isNull(r77) == false) goto L156;
        Integer r80 = null;
    L157:
        r75.setPoisonLabel(r80);     // Catch: Throwable -> L169
        r43 = r43;
        if (r4.isNull(r43) == false) goto L160;
        Integer r99 = null;
    L161:
        r75.setPoisonLabelVersion(r99);     // Catch: Throwable -> L169
        r44 = r44;
        if (r4.isNull(r44) == false) goto L164;
        String r100 = null;
    L165:
        r75.setContentHash(r100);     // Catch: Throwable -> L169
        r46.add(r75);     // Catch: Throwable -> L169
        r0 = r110;
        r17 = r94;
        r18 = r95;
        r19 = r96;
        r20 = r97;
        r21 = r98;
        r2 = r412;
        r42 = r77;
        r45 = r45;
        goto L6
    L164:
        r100 = r4.getString(r44);     // Catch: Throwable -> L169
        goto L165
    L160:
        r99 = Integer.valueOf(r4.getInt(r43));     // Catch: Throwable -> L169
        goto L161
    L156:
        r80 = Integer.valueOf(r4.getInt(r77));     // Catch: Throwable -> L169
        goto L157
    L152:
        r93 = r4.getString(r41);     // Catch: Throwable -> L169
        goto L153
    L148:
        r92 = Long.valueOf(r4.getLong(r40));     // Catch: Throwable -> L169
        goto L150
    L144:
        r91 = r4.getString(r39);     // Catch: Throwable -> L169
        goto L146
    L140:
        r90 = r4.getString(r38);     // Catch: Throwable -> L169
        goto L142
    L136:
        r89 = r4.getString(r37);     // Catch: Throwable -> L169
        goto L138
    L132:
        r88 = r4.getString(r36);     // Catch: Throwable -> L169
        goto L134
    L128:
        r87 = r4.getString(r35);     // Catch: Throwable -> L169
        goto L130
    L124:
        r86 = r4.getString(r34);     // Catch: Throwable -> L169
        goto L126
    L117:
        if (r310.intValue() != 0) goto L120;
        r410 = false;
    L120:
        r84 = Boolean.valueOf(r410);     // Catch: Throwable -> L169
        goto L121
    L113:
        r310 = Integer.valueOf(r4.getInt(r32));     // Catch: Throwable -> L169
        goto L114
    L109:
        r83 = r4.getString(r31);     // Catch: Throwable -> L169
        goto L111
    L105:
        r81 = r4.getString(r29);     // Catch: Throwable -> L169
        goto L106
    L101:
        r73 = r4.getString(r24);     // Catch: Throwable -> L169
        goto L102
    L94:
        if (r210.intValue() == 0) goto L96;
        boolean r211 = true;
    L97:
        r72 = Boolean.valueOf(r211);     // Catch: Throwable -> L169
        goto L99
    L96:
        r211 = false;
        goto L97
    L90:
        r210 = Integer.valueOf(r4.getInt(r23));     // Catch: Throwable -> L169
        goto L91
    L86:
        r67 = false;
        goto L87
    L79:
        if (r411.intValue() == 0) goto L81;
        boolean r413 = true;
    L82:
        r66 = Boolean.valueOf(r413);     // Catch: Throwable -> L169
        goto L77
    L81:
        r413 = false;
        goto L82
    L74:
        r411 = Integer.valueOf(r4.getInt(r96));     // Catch: Throwable -> L169
        goto L75
    L67:
        if (r48.intValue() == 0) goto L69;
        boolean r414 = true;
    L70:
        r65 = Boolean.valueOf(r414);     // Catch: Throwable -> L169
        goto L65
    L69:
        r414 = false;
        goto L70
    L61:
        r48 = Integer.valueOf(r4.getInt(r95));     // Catch: Throwable -> L169
        goto L62
    L57:
        r64 = r4.getString(r94);     // Catch: Throwable -> L169
        goto L56
    L52:
        r63 = r4.getString(r45);     // Catch: Throwable -> L169
        goto L51
    L47:
        r62 = r4.getString(r2);     // Catch: Throwable -> L169
        goto L49
    L43:
        r61 = Integer.valueOf(r4.getInt(r15));     // Catch: Throwable -> L169
        goto L45
    L39:
        r60 = Integer.valueOf(r4.getInt(r14));     // Catch: Throwable -> L169
        goto L41
    L35:
        r59 = r4.getString(r13);     // Catch: Throwable -> L169
        goto L37
    L31:
        r58 = r4.getString(r12);     // Catch: Throwable -> L169
        goto L33
    L27:
        r57 = r4.getString(r11);     // Catch: Throwable -> L169
        goto L29
    L23:
        r56 = r4.getString(r10);     // Catch: Throwable -> L169
        goto L25
    L19:
        r55 = r4.getString(r9);     // Catch: Throwable -> L169
        goto L21
    L15:
        r54 = r4.getString(r8);     // Catch: Throwable -> L169
        goto L17
    L11:
        r53 = r4.getString(r7);     // Catch: Throwable -> L169
        goto L13
    L167:
        r4.close();
        r16.release();
        return r46;
    L169:
        th = th;
    L173:
        r4.close();
        r16.release();
        throw th;
    L171:
        th = th;
        r16 = r1;
        goto L173
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<EpisodicMemoryEntity> getAllMemoryForTracker() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ShortMemory WHERE category = 0 ORDER BY createTime ASC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L171
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "actionTimestamp");     // Catch: Throwable -> L171
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "uid");     // Catch: Throwable -> L171
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "title");     // Catch: Throwable -> L171
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, Params.CONTENT);     // Catch: Throwable -> L171
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "contentWithTime");     // Catch: Throwable -> L171
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "fullContent");     // Catch: Throwable -> L171
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "observation");     // Catch: Throwable -> L171
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "location");     // Catch: Throwable -> L171
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "appNames");     // Catch: Throwable -> L171
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L171
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, "profileType");     // Catch: Throwable -> L171
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "profileTag");     // Catch: Throwable -> L171
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "tagOther");     // Catch: Throwable -> L171
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "logId");     // Catch: Throwable -> L169
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "usedForPortrait");     // Catch: Throwable -> L169
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "useLocation");     // Catch: Throwable -> L169
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "useForUserKeyword");     // Catch: Throwable -> L169
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "startTimestamp");     // Catch: Throwable -> L169
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "endTimestamp");     // Catch: Throwable -> L169
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "useForTopic");     // Catch: Throwable -> L169
        int r24 = CursorUtil.getColumnIndexOrThrow(r4, "entityId");     // Catch: Throwable -> L169
        int r25 = CursorUtil.getColumnIndexOrThrow(r4, "createTime");     // Catch: Throwable -> L169
        int r26 = CursorUtil.getColumnIndexOrThrow(r4, "modifyTime");     // Catch: Throwable -> L169
        int r27 = CursorUtil.getColumnIndexOrThrow(r4, "type");     // Catch: Throwable -> L169
        int r28 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L169
        int r29 = CursorUtil.getColumnIndexOrThrow(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L169
        int r30 = CursorUtil.getColumnIndexOrThrow(r4, "hashCodeValue");     // Catch: Throwable -> L169
        int r31 = CursorUtil.getColumnIndexOrThrow(r4, Api.KEY_UUID);     // Catch: Throwable -> L169
        int r32 = CursorUtil.getColumnIndexOrThrow(r4, "userEdit");     // Catch: Throwable -> L169
        int r33 = CursorUtil.getColumnIndexOrThrow(r4, "productType");     // Catch: Throwable -> L169
        int r34 = CursorUtil.getColumnIndexOrThrow(r4, "important_raw_ref_ids");     // Catch: Throwable -> L169
        int r35 = CursorUtil.getColumnIndexOrThrow(r4, "source_raw_ref_ids");     // Catch: Throwable -> L169
        int r36 = CursorUtil.getColumnIndexOrThrow(r4, "scene_ids");     // Catch: Throwable -> L169
        int r37 = CursorUtil.getColumnIndexOrThrow(r4, "sourcePackageName");     // Catch: Throwable -> L169
        int r38 = CursorUtil.getColumnIndexOrThrow(r4, "eventName");     // Catch: Throwable -> L169
        int r39 = CursorUtil.getColumnIndexOrThrow(r4, "rawTableName");     // Catch: Throwable -> L169
        int r40 = CursorUtil.getColumnIndexOrThrow(r4, "rawDbId");     // Catch: Throwable -> L169
        int r41 = CursorUtil.getColumnIndexOrThrow(r4, "eventData");     // Catch: Throwable -> L169
        int r42 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label");     // Catch: Throwable -> L169
        int r43 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label_version");     // Catch: Throwable -> L169
        int r44 = CursorUtil.getColumnIndexOrThrow(r4, "content_hash");     // Catch: Throwable -> L169
        int r45 = r3;
        ArrayList r46 = new ArrayList(r4.getCount());     // Catch: Throwable -> L169
    L6:
        if (r4.moveToNext() == false) goto L167;
        long r47 = r4.getLong(r0);     // Catch: Throwable -> L169
        long r49 = r4.getLong(r5);     // Catch: Throwable -> L169
        long r51 = r4.getLong(r6);     // Catch: Throwable -> L169
        if (r4.isNull(r7) == false) goto L11;
        String r53 = null;
    L13:
        if (r4.isNull(r8) == false) goto L15;
        String r54 = null;
    L17:
        if (r4.isNull(r9) == false) goto L19;
        String r55 = null;
    L21:
        if (r4.isNull(r10) == false) goto L23;
        String r56 = null;
    L25:
        if (r4.isNull(r11) == false) goto L27;
        String r57 = null;
    L29:
        if (r4.isNull(r12) == false) goto L31;
        String r58 = null;
    L33:
        if (r4.isNull(r13) == false) goto L35;
        String r59 = null;
    L37:
        if (r4.isNull(r14) == false) goto L39;
        Integer r60 = null;
    L41:
        if (r4.isNull(r15) == false) goto L43;
        Integer r61 = null;
    L45:
        if (r4.isNull(r2) == false) goto L47;
        String r62 = null;
    L49:
        if (r4.isNull(r45) == false) goto L52;
        String r63 = null;
    L51:
        int r94 = r17;
        int r110 = r0;
        if (r4.isNull(r94) == false) goto L57;
        String r64 = null;
    L56:
        int r95 = r18;
        if (r4.isNull(r95) == false) goto L61;
        Integer r48 = null;
    L62:
        boolean r410 = true;
        if (r48 != null) goto L67;
        Boolean r65 = null;
    L65:
        int r96 = r19;
        if (r4.isNull(r96) == false) goto L74;
        Integer r411 = null;
    L75:
        if (r411 != null) goto L79;
        Boolean r66 = null;
    L77:
        int r97 = r20;
        if (r4.getInt(r97) == 0) goto L86;
        boolean r67 = true;
    L87:
        int r98 = r21;
        long r68 = r4.getLong(r98);     // Catch: Throwable -> L169
        int r50 = r22;
        long r70 = r4.getLong(r50);     // Catch: Throwable -> L169
        r22 = r50;
        r23 = r23;
        if (r4.isNull(r23) == false) goto L90;
        Integer r210 = null;
    L91:
        if (r210 != null) goto L94;
        Boolean r72 = null;
    L99:
        if (r4.isNull(r24) == false) goto L101;
        String r73 = null;
    L102:
        long r74 = r4.getLong(r25);     // Catch: Throwable -> L169
        r25 = r25;
        int r52 = r26;
        long r76 = r4.getLong(r52);     // Catch: Throwable -> L169
        r26 = r52;
        int r69 = r27;
        int r78 = r4.getInt(r69);     // Catch: Throwable -> L169
        r27 = r69;
        int r71 = r28;
        long r79 = r4.getLong(r71);     // Catch: Throwable -> L169
        r28 = r71;
        r29 = r29;
        if (r4.isNull(r29) == false) goto L105;
        String r81 = null;
    L106:
        int r82 = r4.getInt(r30);     // Catch: Throwable -> L169
        r30 = r30;
        r31 = r31;
        if (r4.isNull(r31) == false) goto L109;
        String r83 = null;
    L111:
        if (r4.isNull(r32) == false) goto L113;
        Integer r310 = null;
    L114:
        if (r310 != null) goto L117;
        Boolean r84 = null;
    L121:
        int r85 = r4.getInt(r33);     // Catch: Throwable -> L169
        r33 = r33;
        r34 = r34;
        if (r4.isNull(r34) == false) goto L124;
        String r86 = null;
    L126:
        if (r4.isNull(r35) == false) goto L128;
        String r87 = null;
    L130:
        if (r4.isNull(r36) == false) goto L132;
        String r88 = null;
    L134:
        if (r4.isNull(r37) == false) goto L136;
        String r89 = null;
    L138:
        if (r4.isNull(r38) == false) goto L140;
        String r90 = null;
    L142:
        if (r4.isNull(r39) == false) goto L144;
        String r91 = null;
    L146:
        if (r4.isNull(r40) == false) goto L148;
        Long r92 = null;
    L150:
        if (r4.isNull(r41) == false) goto L152;
        String r93 = null;
    L153:
        EpisodicMemoryEntity r75 = new EpisodicMemoryEntity(r47, r49, r51, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r70, r72, r73, r74, r76, r78, r79, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93);     // Catch: Throwable -> L169
        int r412 = r2;
        int r77 = r42;
        if (r4.isNull(r77) == false) goto L156;
        Integer r80 = null;
    L157:
        r75.setPoisonLabel(r80);     // Catch: Throwable -> L169
        r43 = r43;
        if (r4.isNull(r43) == false) goto L160;
        Integer r99 = null;
    L161:
        r75.setPoisonLabelVersion(r99);     // Catch: Throwable -> L169
        r44 = r44;
        if (r4.isNull(r44) == false) goto L164;
        String r100 = null;
    L165:
        r75.setContentHash(r100);     // Catch: Throwable -> L169
        r46.add(r75);     // Catch: Throwable -> L169
        r0 = r110;
        r17 = r94;
        r18 = r95;
        r19 = r96;
        r20 = r97;
        r21 = r98;
        r2 = r412;
        r42 = r77;
        r45 = r45;
        goto L6
    L164:
        r100 = r4.getString(r44);     // Catch: Throwable -> L169
        goto L165
    L160:
        r99 = Integer.valueOf(r4.getInt(r43));     // Catch: Throwable -> L169
        goto L161
    L156:
        r80 = Integer.valueOf(r4.getInt(r77));     // Catch: Throwable -> L169
        goto L157
    L152:
        r93 = r4.getString(r41);     // Catch: Throwable -> L169
        goto L153
    L148:
        r92 = Long.valueOf(r4.getLong(r40));     // Catch: Throwable -> L169
        goto L150
    L144:
        r91 = r4.getString(r39);     // Catch: Throwable -> L169
        goto L146
    L140:
        r90 = r4.getString(r38);     // Catch: Throwable -> L169
        goto L142
    L136:
        r89 = r4.getString(r37);     // Catch: Throwable -> L169
        goto L138
    L132:
        r88 = r4.getString(r36);     // Catch: Throwable -> L169
        goto L134
    L128:
        r87 = r4.getString(r35);     // Catch: Throwable -> L169
        goto L130
    L124:
        r86 = r4.getString(r34);     // Catch: Throwable -> L169
        goto L126
    L117:
        if (r310.intValue() != 0) goto L120;
        r410 = false;
    L120:
        r84 = Boolean.valueOf(r410);     // Catch: Throwable -> L169
        goto L121
    L113:
        r310 = Integer.valueOf(r4.getInt(r32));     // Catch: Throwable -> L169
        goto L114
    L109:
        r83 = r4.getString(r31);     // Catch: Throwable -> L169
        goto L111
    L105:
        r81 = r4.getString(r29);     // Catch: Throwable -> L169
        goto L106
    L101:
        r73 = r4.getString(r24);     // Catch: Throwable -> L169
        goto L102
    L94:
        if (r210.intValue() == 0) goto L96;
        boolean r211 = true;
    L97:
        r72 = Boolean.valueOf(r211);     // Catch: Throwable -> L169
        goto L99
    L96:
        r211 = false;
        goto L97
    L90:
        r210 = Integer.valueOf(r4.getInt(r23));     // Catch: Throwable -> L169
        goto L91
    L86:
        r67 = false;
        goto L87
    L79:
        if (r411.intValue() == 0) goto L81;
        boolean r413 = true;
    L82:
        r66 = Boolean.valueOf(r413);     // Catch: Throwable -> L169
        goto L77
    L81:
        r413 = false;
        goto L82
    L74:
        r411 = Integer.valueOf(r4.getInt(r96));     // Catch: Throwable -> L169
        goto L75
    L67:
        if (r48.intValue() == 0) goto L69;
        boolean r414 = true;
    L70:
        r65 = Boolean.valueOf(r414);     // Catch: Throwable -> L169
        goto L65
    L69:
        r414 = false;
        goto L70
    L61:
        r48 = Integer.valueOf(r4.getInt(r95));     // Catch: Throwable -> L169
        goto L62
    L57:
        r64 = r4.getString(r94);     // Catch: Throwable -> L169
        goto L56
    L52:
        r63 = r4.getString(r45);     // Catch: Throwable -> L169
        goto L51
    L47:
        r62 = r4.getString(r2);     // Catch: Throwable -> L169
        goto L49
    L43:
        r61 = Integer.valueOf(r4.getInt(r15));     // Catch: Throwable -> L169
        goto L45
    L39:
        r60 = Integer.valueOf(r4.getInt(r14));     // Catch: Throwable -> L169
        goto L41
    L35:
        r59 = r4.getString(r13);     // Catch: Throwable -> L169
        goto L37
    L31:
        r58 = r4.getString(r12);     // Catch: Throwable -> L169
        goto L33
    L27:
        r57 = r4.getString(r11);     // Catch: Throwable -> L169
        goto L29
    L23:
        r56 = r4.getString(r10);     // Catch: Throwable -> L169
        goto L25
    L19:
        r55 = r4.getString(r9);     // Catch: Throwable -> L169
        goto L21
    L15:
        r54 = r4.getString(r8);     // Catch: Throwable -> L169
        goto L17
    L11:
        r53 = r4.getString(r7);     // Catch: Throwable -> L169
        goto L13
    L167:
        r4.close();
        r16.release();
        return r46;
    L169:
        th = th;
    L173:
        r4.close();
        r16.release();
        throw th;
    L171:
        th = th;
        r16 = r1;
        goto L173
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public i<Integer> getAllObservationMemoryCount(long r4, long r6) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM ShortMemory WHERE category = 0 AND productType IN (1001, 1005, 1006) AND startTimestamp >= ? AND startTimestamp < ?", 2);
        r0.bindLong(1, r4);
        r0.bindLong(2, r6);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ShortMemory"}, new AnonymousClass16(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public Object getAllObservationMemoryMetaInfo(List<String> r9, boolean r10, boolean r11, Continuation<? super List<cu>> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT entityId, type, packageName, logId FROM ShortMemory WHERE category = 0 AND productType IN (1001, 1005, 1006) AND (       (NOT ");
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
        return CoroutinesRoom.execute(this.__db, false, r17, new AnonymousClass14(this, r1), r14);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public Object getAllObservationMemoryMetaInfoWithTimestamp(List<String> r14, boolean r15, long r16, long r18, boolean r20, Continuation<? super List<cu>> r21) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        StringBuilder r6 = StringUtil.newStringBuilder();
        r6.append("SELECT entityId, type, packageName, logId FROM ShortMemory WHERE category = 0 AND productType IN (1001, 1005, 1006) AND (       (NOT ");
        r6.append("?");
        r6.append(" AND (            (");
        r6.append("?");
        r6.append(" AND entityId IN (");
        int r8 = r3.size();
        StringUtil.appendPlaceholders(r6, r8);
        r6.append(")) OR             (NOT ");
        r6.append("?");
        r6.append(" AND entityId NOT IN (");
        int r9 = r3.size();
        StringUtil.appendPlaceholders(r6, r9);
        r6.append("))         ))        OR (");
        r6.append("?");
        r6.append(")) AND startTimestamp >= ");
        r6.append("?");
        r6.append(" AND startTimestamp < ");
        r6.append("?");
        int r7 = r8 + 6;
        final RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire(r6.toString(), r9 + r7);
        r10.bindLong(1, r20 ? 1 : 0);
        r10.bindLong(2, r15 ? 1 : 0);
        Iterator r11 = r3.iterator();
        int r12 = 3;
    L4:
        if (r11.hasNext() == false) goto L10;
        String r13 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L8;
        r10.bindNull(r12);
    L9:
        r12 = r12 + 1;
        goto L4
    L8:
        r10.bindString(r12, r13);
        goto L9
    L10:
        r10.bindLong(r8 + 3, r15 ? 1 : 0);
        int r1 = r8 + 4;
        Iterator r4 = r3.iterator();
        int r17 = r1;
    L12:
        if (r4.hasNext() == false) goto L18;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        if (r19 != null) goto L16;
        r10.bindNull(r17);
    L17:
        r17 = r17 + 1;
        goto L12
    L16:
        r10.bindString(r17, r19);
        goto L17
    L18:
        r10.bindLong(r1 + r8, r20 ? 1 : 0);
        r10.bindLong((r8 + 5) + r8, r16);
        r10.bindLong(r7 + r8, r18);
        CancellationSignal r2 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r2, new AnonymousClass15(this, r10), r5);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public PagingSource<Integer, EpisodicMemoryEntity> getAllRecommendMemory() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ShortMemory WHERE category = 0 AND productType IN (1001, 1005, 1006) ORDER BY modifyTime DESC", 0);
        final RoomDatabase r2 = this.__db;
        final String[] r3 = {"ShortMemory"};
        return new AnonymousClass11(this, r0, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public PagingSource<Integer, EpisodicMemoryEntity> getAllRecommendMemoryByTimeRange(long r4, long r6) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM ShortMemory WHERE category = 0 AND productType IN (1001, 1005, 1006) AND startTimestamp >= ? AND startTimestamp < ? ORDER BY startTimestamp DESC", 2);
        r0.bindLong(1, r4);
        r0.bindLong(2, r6);
        final RoomDatabase r5 = this.__db;
        final String[] r7 = {"ShortMemory"};
        return new AnonymousClass12(this, r0, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public Object getCollectMemoryMetaInfo(List<String> r7, boolean r8, String r9, Integer r10, boolean r11, Continuation<? super List<cu>> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT m.entityId, m.type, m.packageName, m.logId FROM ShortMemory m INNER JOIN ProactiveEpisodicRelevantData r ON m.entityId = r.episodic_id WHERE m.productType = 1003 AND NULLIF(TRIM(r.source_package_name), '') IS NOT NULL AND NULLIF(TRIM(r.source_app_name), '') IS NOT NULL AND (");
        r0.append("?");
        r0.append(" IS NULL OR r.source_package_name = ");
        r0.append("?");
        r0.append(") AND (");
        r0.append("?");
        r0.append(" IS NULL OR        (");
        r0.append("?");
        r0.append(" = 0 AND COALESCE(r.product_type, 0) NOT IN (20, 21)) OR        r.product_type = ");
        r0.append("?");
        r0.append(") AND (       (NOT ");
        r0.append("?");
        r0.append(" AND (            (");
        r0.append("?");
        r0.append(" AND m.entityId IN (");
        int r3 = r13.size();
        StringUtil.appendPlaceholders(r0, r3);
        r0.append(")) OR             (NOT ");
        r0.append("?");
        r0.append(" AND m.entityId NOT IN (");
        int r4 = r13.size();
        StringUtil.appendPlaceholders(r0, r4);
        r0.append("))         ))        OR (");
        r0.append("?");
        r0.append(")) ");
        int r2 = r3 + 9;
        final RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r4 + r2);
        if (r9 != null) goto L5;
        r1.bindNull(1);
    L7:
        if (r9 != null) goto L9;
        r1.bindNull(2);
    L11:
        if (r9 != null) goto L13;
        r1.bindNull(3);
    L15:
        if (r10 != null) goto L17;
        r1.bindNull(4);
    L19:
        if (r10 != null) goto L21;
        r1.bindNull(5);
    L22:
        r1.bindLong(6, r11 ? 1 : 0);
        r1.bindLong(7, r8 ? 1 : 0);
        Iterator r15 = r13.iterator();
        int r16 = 8;
    L24:
        if (r15.hasNext() == false) goto L30;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L28;
        r1.bindNull(r16);
    L29:
        r16 = r16 + 1;
        goto L24
    L28:
        r1.bindString(r16, r5);
        goto L29
    L30:
        r1.bindLong(r3 + 8, r8 ? 1 : 0);
        Iterator r17 = r13.iterator();
        int r18 = r2;
    L32:
        if (r17.hasNext() == false) goto L38;
        String r19 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");
        if (r19 != null) goto L36;
        r1.bindNull(r18);
    L37:
        r18 = r18 + 1;
        goto L32
    L36:
        r1.bindString(r18, r19);
        goto L37
    L38:
        r1.bindLong(r2 + r3, r11 ? 1 : 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new AnonymousClass10(this, r1), r14);
    L21:
        r1.bindLong(5, r10.intValue());
        goto L22
    L17:
        r1.bindLong(4, r10.intValue());
        goto L19
    L13:
        r1.bindString(3, r9);
        goto L15
    L9:
        r1.bindString(2, r9);
        goto L11
    L5:
        r1.bindString(1, r9);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public i<List<al>> getCollectMemorySourceStats() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT r.source_package_name AS sourcePackageName, CASE WHEN r.product_type IN (20, 21) THEN r.product_type ELSE 0 END AS sourceProductType, CASE WHEN r.product_type = 20 THEN '眼镜' WHEN r.product_type = 21 THEN 'Omni' WHEN r.source_package_name = 'com.obric.appletapp' THEN r.source_package_name ELSE COALESCE(MIN(NULLIF(r.source_app_name, '')), r.source_package_name) END AS sourceAppName, COUNT(*) AS count FROM ShortMemory m INNER JOIN ProactiveEpisodicRelevantData r ON m.entityId = r.episodic_id WHERE m.productType = 1003 AND NULLIF(TRIM(r.source_package_name), '') IS NOT NULL AND NULLIF(TRIM(r.source_app_name), '') IS NOT NULL GROUP BY r.source_package_name, CASE WHEN r.product_type IN (20, 21) THEN r.product_type ELSE 0 END ORDER BY count DESC, sourceAppName ASC", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"ShortMemory", "ProactiveEpisodicRelevantData"}, new AnonymousClass9(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public bt getCollectMemoryWithRelevantByEntityId(String r100) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT m.* FROM ShortMemory m INNER JOIN ProactiveEpisodicRelevantData r ON m.entityId = r.episodic_id WHERE m.productType = 1003 and m.entityId = ? LIMIT 1", 1);
        if (r100 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, true, null);     // Catch: Throwable -> L189
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L185
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "actionTimestamp");     // Catch: Throwable -> L185
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "uid");     // Catch: Throwable -> L185
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "title");     // Catch: Throwable -> L185
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, Params.CONTENT);     // Catch: Throwable -> L185
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "contentWithTime");     // Catch: Throwable -> L185
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "fullContent");     // Catch: Throwable -> L185
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "observation");     // Catch: Throwable -> L185
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "location");     // Catch: Throwable -> L185
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "appNames");     // Catch: Throwable -> L185
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L185
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "profileType");     // Catch: Throwable -> L185
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "profileTag");     // Catch: Throwable -> L185
        RoomSQLiteQuery r17 = r2;
        int r16 = CursorUtil.getColumnIndexOrThrow(r5, "tagOther");     // Catch: Throwable -> L183
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L183
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "usedForPortrait");     // Catch: Throwable -> L183
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "useLocation");     // Catch: Throwable -> L183
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "useForUserKeyword");     // Catch: Throwable -> L183
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "startTimestamp");     // Catch: Throwable -> L183
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "endTimestamp");     // Catch: Throwable -> L183
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "useForTopic");     // Catch: Throwable -> L183
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L183
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L183
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L183
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L183
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L183
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L183
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L183
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L183
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "userEdit");     // Catch: Throwable -> L183
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "productType");     // Catch: Throwable -> L183
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "important_raw_ref_ids");     // Catch: Throwable -> L183
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, "source_raw_ref_ids");     // Catch: Throwable -> L183
        int r37 = CursorUtil.getColumnIndexOrThrow(r5, "scene_ids");     // Catch: Throwable -> L183
        int r38 = CursorUtil.getColumnIndexOrThrow(r5, "sourcePackageName");     // Catch: Throwable -> L183
        int r39 = CursorUtil.getColumnIndexOrThrow(r5, "eventName");     // Catch: Throwable -> L183
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "rawTableName");     // Catch: Throwable -> L183
        int r41 = CursorUtil.getColumnIndexOrThrow(r5, "rawDbId");     // Catch: Throwable -> L183
        int r42 = CursorUtil.getColumnIndexOrThrow(r5, "eventData");     // Catch: Throwable -> L183
        int r43 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L183
        int r44 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L183
        int r45 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L183
        ArrayMap<String, ArrayList<es>> r46 = new ArrayMap();     // Catch: Throwable -> L183
    L12:
        int r48 = r3;
        if (r5.moveToNext() == false) goto L19;
        int r47 = r15;
        String r110 = r5.getString(r25);     // Catch: Throwable -> L183
        int r49 = r25;
        int r50 = r14;
        if (((ArrayList) ZeusTransformUtils.preCheckCast(r46.get(r110), ArrayList.class, "com.obric.memorydata.plugin")) != null) goto L18;
        r46.put(r110, new ArrayList());     // Catch: Throwable -> L183
    L18:
        r15 = r47;
        r3 = r48;
        r25 = r49;
        r14 = r50;
        goto L12
    L19:
        int r410 = r25;
        int r51 = r14;
        int r411 = r15;
        r5.moveToPosition(-1);     // Catch: Throwable -> L183
        __fetchRelationshipProactiveEpisodicRelevantDataAscomObricMemorydataDatabaseEntityProactiveEpisodicRelevantData(r46);     // Catch: Throwable -> L183
        if (r5.moveToFirst() == false) goto L178;
        long r52 = r5.getLong(r0);     // Catch: Throwable -> L183
        long r54 = r5.getLong(r6);     // Catch: Throwable -> L183
        long r56 = r5.getLong(r7);     // Catch: Throwable -> L183
        if (r5.isNull(r8) == false) goto L24;
        String r58 = null;
    L26:
        if (r5.isNull(r9) == false) goto L28;
        String r59 = null;
    L30:
        if (r5.isNull(r10) == false) goto L32;
        String r60 = null;
    L34:
        if (r5.isNull(r11) == false) goto L36;
        String r61 = null;
    L38:
        if (r5.isNull(r12) == false) goto L40;
        String r62 = null;
    L42:
        if (r5.isNull(r13) == false) goto L44;
        String r63 = null;
    L46:
        if (r5.isNull(r51) == false) goto L48;
        String r64 = null;
    L50:
        if (r5.isNull(r411) == false) goto L52;
        Integer r65 = null;
    L54:
        if (r5.isNull(r48) == false) goto L56;
        Integer r66 = null;
    L58:
        if (r5.isNull(r26) == false) goto L60;
        String r67 = null;
    L62:
        if (r5.isNull(r18) == false) goto L64;
        String r68 = null;
    L66:
        if (r5.isNull(r19) == false) goto L68;
        String r69 = null;
    L70:
        if (r5.isNull(r20) == false) goto L72;
        Integer r1 = null;
    L74:
        if (r1 != null) goto L77;
        Boolean r70 = null;
    L82:
        if (r5.isNull(r21) == false) goto L84;
        Integer r53 = null;
    L85:
        if (r53 != null) goto L88;
        Boolean r71 = null;
    L93:
        if (r5.getInt(r21) == 0) goto L95;
        boolean r72 = true;
    L96:
        long r73 = r5.getLong(r22);     // Catch: Throwable -> L183
        long r75 = r5.getLong(r23);     // Catch: Throwable -> L183
        if (r5.isNull(r24) == false) goto L99;
        Integer r55 = null;
    L100:
        if (r55 != null) goto L103;
        Boolean r77 = null;
    L108:
        if (r5.isNull(r410) == false) goto L110;
        String r78 = null;
    L111:
        long r79 = r5.getLong(r26);     // Catch: Throwable -> L183
        long r81 = r5.getLong(r27);     // Catch: Throwable -> L183
        int r83 = r5.getInt(r28);     // Catch: Throwable -> L183
        long r84 = r5.getLong(r29);     // Catch: Throwable -> L183
        if (r5.isNull(r30) == false) goto L114;
        String r86 = null;
    L115:
        int r87 = r5.getInt(r31);     // Catch: Throwable -> L183
        if (r5.isNull(r32) == false) goto L118;
        String r88 = null;
    L120:
        if (r5.isNull(r34) == false) goto L122;
        Integer r57 = null;
    L123:
        if (r57 != null) goto L126;
        Boolean r89 = null;
    L130:
        int r90 = r5.getInt(r34);     // Catch: Throwable -> L183
        if (r5.isNull(r35) == false) goto L133;
        String r91 = null;
    L135:
        if (r5.isNull(r37) == false) goto L137;
        String r92 = null;
    L139:
        if (r5.isNull(r38) == false) goto L141;
        String r93 = null;
    L143:
        if (r5.isNull(r39) == false) goto L145;
        String r94 = null;
    L147:
        if (r5.isNull(r40) == false) goto L149;
        String r95 = null;
    L151:
        if (r5.isNull(r41) == false) goto L153;
        String r96 = null;
    L155:
        if (r5.isNull(r42) == false) goto L157;
        Long r97 = null;
    L159:
        if (r5.isNull(r43) == false) goto L161;
        String r98 = null;
    L162:
        EpisodicMemoryEntity r74 = new EpisodicMemoryEntity(r52, r54, r56, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r75, r77, r78, r79, r81, r83, r84, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98);     // Catch: Throwable -> L183
        if (r5.isNull(r43) == false) goto L165;
        Integer r76 = null;
    L166:
        r74.setPoisonLabel(r76);     // Catch: Throwable -> L183
        if (r5.isNull(r44) == false) goto L169;
        Integer r80 = null;
    L170:
        r74.setPoisonLabelVersion(r80);     // Catch: Throwable -> L183
        if (r5.isNull(r45) == false) goto L173;
        String r82 = null;
    L174:
        r74.setContentHash(r82);     // Catch: Throwable -> L183
        ArrayList r85 = (ArrayList) ZeusTransformUtils.preCheckCast(r46.get(r5.getString(r410)), ArrayList.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L183
        if (r85 != null) goto L177;
        r85 = new ArrayList();     // Catch: Throwable -> L183
    L177:
        bt r99 = new bt(r74, r85);     // Catch: Throwable -> L183
    L179:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L183
        r5.close();     // Catch: Throwable -> L189
        r17.release();     // Catch: Throwable -> L189
        this.__db.endTransaction();
        return r99;
    L173:
        r82 = r5.getString(r45);     // Catch: Throwable -> L183
        goto L174
    L169:
        r80 = Integer.valueOf(r5.getInt(r44));     // Catch: Throwable -> L183
        goto L170
    L165:
        r76 = Integer.valueOf(r5.getInt(r43));     // Catch: Throwable -> L183
        goto L166
    L161:
        r98 = r5.getString(r42);     // Catch: Throwable -> L183
        goto L162
    L157:
        r97 = Long.valueOf(r5.getLong(r41));     // Catch: Throwable -> L183
        goto L159
    L153:
        r96 = r5.getString(r40);     // Catch: Throwable -> L183
        goto L155
    L149:
        r95 = r5.getString(r39);     // Catch: Throwable -> L183
        goto L151
    L145:
        r94 = r5.getString(r38);     // Catch: Throwable -> L183
        goto L147
    L141:
        r93 = r5.getString(r37);     // Catch: Throwable -> L183
        goto L143
    L137:
        r92 = r5.getString(r36);     // Catch: Throwable -> L183
        goto L139
    L133:
        r91 = r5.getString(r35);     // Catch: Throwable -> L183
        goto L135
    L126:
        if (r57.intValue() == 0) goto L128;
        boolean r111 = true;
    L129:
        r89 = Boolean.valueOf(r111);     // Catch: Throwable -> L183
        goto L130
    L128:
        r111 = false;
        goto L129
    L122:
        r57 = Integer.valueOf(r5.getInt(r33));     // Catch: Throwable -> L183
        goto L123
    L118:
        r88 = r5.getString(r32);     // Catch: Throwable -> L183
        goto L120
    L114:
        r86 = r5.getString(r30);     // Catch: Throwable -> L183
        goto L115
    L110:
        r78 = r5.getString(r410);     // Catch: Throwable -> L183
        goto L111
    L103:
        if (r55.intValue() == 0) goto L105;
        boolean r101 = true;
    L106:
        r77 = Boolean.valueOf(r101);     // Catch: Throwable -> L183
        goto L108
    L105:
        r101 = false;
        goto L106
    L99:
        r55 = Integer.valueOf(r5.getInt(r24));     // Catch: Throwable -> L183
        goto L100
    L95:
        r72 = false;
        goto L96
    L88:
        if (r53.intValue() == 0) goto L90;
        boolean r102 = true;
    L91:
        r71 = Boolean.valueOf(r102);     // Catch: Throwable -> L183
        goto L93
    L90:
        r102 = false;
        goto L91
    L84:
        r53 = Integer.valueOf(r5.getInt(r20));     // Catch: Throwable -> L183
        goto L85
    L77:
        if (r1.intValue() == 0) goto L79;
        boolean r103 = true;
    L80:
        r70 = Boolean.valueOf(r103);     // Catch: Throwable -> L183
        goto L82
    L79:
        r103 = false;
        goto L80
    L72:
        r1 = Integer.valueOf(r5.getInt(r19));     // Catch: Throwable -> L183
        goto L74
    L68:
        r69 = r5.getString(r18);     // Catch: Throwable -> L183
        goto L70
    L64:
        r68 = r5.getString(r16);     // Catch: Throwable -> L183
        goto L66
    L60:
        r67 = r5.getString(r4);     // Catch: Throwable -> L183
        goto L62
    L56:
        r66 = Integer.valueOf(r5.getInt(r48));     // Catch: Throwable -> L183
        goto L58
    L52:
        r65 = Integer.valueOf(r5.getInt(r411));     // Catch: Throwable -> L183
        goto L54
    L48:
        r64 = r5.getString(r51);     // Catch: Throwable -> L183
        goto L50
    L44:
        r63 = r5.getString(r13);     // Catch: Throwable -> L183
        goto L46
    L40:
        r62 = r5.getString(r12);     // Catch: Throwable -> L183
        goto L42
    L36:
        r61 = r5.getString(r11);     // Catch: Throwable -> L183
        goto L38
    L32:
        r60 = r5.getString(r10);     // Catch: Throwable -> L183
        goto L34
    L28:
        r59 = r5.getString(r9);     // Catch: Throwable -> L183
        goto L30
    L24:
        r58 = r5.getString(r8);     // Catch: Throwable -> L183
        goto L26
    L178:
        r99 = null;
    L183:
        th = th;
    L187:
        r5.close();     // Catch: Throwable -> L189
        r17.release();     // Catch: Throwable -> L189
        throw th;     // Catch: Throwable -> L189
    L185:
        th = th;
        r17 = r2;
    L189:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L5:
        r2.bindString(1, r100);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<bt> getCollectMemoryWithRelevantByEntityIds(List<String> r100) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r100, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT m.* FROM ShortMemory m INNER JOIN ProactiveEpisodicRelevantData r ON m.entityId = r.episodic_id WHERE m.productType = 1003 AND m.entityId IN (");
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
        Cursor r8 = DBUtil.query(this.__db, r5, true, null);     // Catch: Throwable -> L197
        int r2 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L193
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "actionTimestamp");     // Catch: Throwable -> L193
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "uid");     // Catch: Throwable -> L193
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "title");     // Catch: Throwable -> L193
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, Params.CONTENT);     // Catch: Throwable -> L193
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "contentWithTime");     // Catch: Throwable -> L193
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, "fullContent");     // Catch: Throwable -> L193
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "observation");     // Catch: Throwable -> L193
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, "location");     // Catch: Throwable -> L193
        int r17 = CursorUtil.getColumnIndexOrThrow(r8, "appNames");     // Catch: Throwable -> L193
        int r18 = CursorUtil.getColumnIndexOrThrow(r8, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L193
        int r19 = CursorUtil.getColumnIndexOrThrow(r8, "profileType");     // Catch: Throwable -> L193
        RoomSQLiteQuery r110 = r5;
        int r111 = CursorUtil.getColumnIndexOrThrow(r8, "profileTag");     // Catch: Throwable -> L191
        int r112 = CursorUtil.getColumnIndexOrThrow(r8, "tagOther");     // Catch: Throwable -> L191
        int r113 = CursorUtil.getColumnIndexOrThrow(r8, "logId");     // Catch: Throwable -> L191
        int r20 = CursorUtil.getColumnIndexOrThrow(r8, "usedForPortrait");     // Catch: Throwable -> L191
        int r21 = CursorUtil.getColumnIndexOrThrow(r8, "useLocation");     // Catch: Throwable -> L191
        int r22 = CursorUtil.getColumnIndexOrThrow(r8, "useForUserKeyword");     // Catch: Throwable -> L191
        int r23 = CursorUtil.getColumnIndexOrThrow(r8, "startTimestamp");     // Catch: Throwable -> L191
        int r24 = CursorUtil.getColumnIndexOrThrow(r8, "endTimestamp");     // Catch: Throwable -> L191
        int r25 = CursorUtil.getColumnIndexOrThrow(r8, "useForTopic");     // Catch: Throwable -> L191
        int r26 = CursorUtil.getColumnIndexOrThrow(r8, "entityId");     // Catch: Throwable -> L191
        int r27 = r19;
        int r28 = CursorUtil.getColumnIndexOrThrow(r8, "createTime");     // Catch: Throwable -> L191
        int r29 = CursorUtil.getColumnIndexOrThrow(r8, "modifyTime");     // Catch: Throwable -> L191
        int r210 = CursorUtil.getColumnIndexOrThrow(r8, "type");     // Catch: Throwable -> L191
        int r30 = CursorUtil.getColumnIndexOrThrow(r8, "timestamp");     // Catch: Throwable -> L191
        int r31 = CursorUtil.getColumnIndexOrThrow(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L191
        int r32 = CursorUtil.getColumnIndexOrThrow(r8, "hashCodeValue");     // Catch: Throwable -> L191
        int r33 = CursorUtil.getColumnIndexOrThrow(r8, Api.KEY_UUID);     // Catch: Throwable -> L191
        int r34 = CursorUtil.getColumnIndexOrThrow(r8, "userEdit");     // Catch: Throwable -> L191
        int r35 = CursorUtil.getColumnIndexOrThrow(r8, "productType");     // Catch: Throwable -> L191
        int r36 = CursorUtil.getColumnIndexOrThrow(r8, "important_raw_ref_ids");     // Catch: Throwable -> L191
        int r37 = CursorUtil.getColumnIndexOrThrow(r8, "source_raw_ref_ids");     // Catch: Throwable -> L191
        int r38 = CursorUtil.getColumnIndexOrThrow(r8, "scene_ids");     // Catch: Throwable -> L191
        int r39 = CursorUtil.getColumnIndexOrThrow(r8, "sourcePackageName");     // Catch: Throwable -> L191
        int r40 = CursorUtil.getColumnIndexOrThrow(r8, "eventName");     // Catch: Throwable -> L191
        int r41 = CursorUtil.getColumnIndexOrThrow(r8, "rawTableName");     // Catch: Throwable -> L191
        int r42 = CursorUtil.getColumnIndexOrThrow(r8, "rawDbId");     // Catch: Throwable -> L191
        int r43 = CursorUtil.getColumnIndexOrThrow(r8, "eventData");     // Catch: Throwable -> L191
        int r44 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label");     // Catch: Throwable -> L191
        int r45 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label_version");     // Catch: Throwable -> L191
        int r46 = CursorUtil.getColumnIndexOrThrow(r8, "content_hash");     // Catch: Throwable -> L191
        ArrayMap<String, ArrayList<es>> r47 = new ArrayMap();     // Catch: Throwable -> L191
    L16:
        if (r8.moveToNext() == false) goto L21;
        int r48 = r18;
        String r49 = r8.getString(r26);     // Catch: Throwable -> L191
        int r410 = r26;
        int r411 = r17;
        if (((ArrayList) ZeusTransformUtils.preCheckCast(r47.get(r49), ArrayList.class, "com.obric.memorydata.plugin")) != null) goto L20;
        r47.put(r49, new ArrayList());     // Catch: Throwable -> L191
    L20:
        r18 = r48;
        r26 = r410;
        r17 = r411;
        goto L16
    L21:
        int r412 = r26;
        int r413 = r17;
        int r414 = r18;
        r8.moveToPosition(-1);     // Catch: Throwable -> L191
        __fetchRelationshipProactiveEpisodicRelevantDataAscomObricMemorydataDatabaseEntityProactiveEpisodicRelevantData(r47);     // Catch: Throwable -> L191
        ArrayList r50 = new ArrayList(r8.getCount());     // Catch: Throwable -> L191
    L23:
        if (r8.moveToNext() == false) goto L187;
        long r51 = r8.getLong(r2);     // Catch: Throwable -> L191
        long r53 = r8.getLong(r9);     // Catch: Throwable -> L191
        long r55 = r8.getLong(r10);     // Catch: Throwable -> L191
        if (r8.isNull(r11) == false) goto L27;
        String r57 = null;
    L29:
        if (r8.isNull(r12) == false) goto L31;
        String r58 = null;
    L33:
        if (r8.isNull(r13) == false) goto L35;
        String r59 = null;
    L37:
        if (r8.isNull(r14) == false) goto L39;
        String r60 = null;
    L41:
        if (r8.isNull(r15) == false) goto L43;
        String r61 = null;
    L45:
        if (r8.isNull(r16) == false) goto L47;
        String r62 = null;
    L49:
        if (r8.isNull(r413) == false) goto L51;
        String r63 = null;
    L53:
        if (r8.isNull(r414) == false) goto L56;
        Integer r64 = null;
    L55:
        int r98 = r27;
        int r211 = r2;
        if (r8.isNull(r98) == false) goto L61;
        Integer r65 = null;
    L60:
        int r99 = r111;
        if (r8.isNull(r99) == false) goto L66;
        String r66 = null;
    L65:
        int r910 = r112;
        if (r8.isNull(r910) == false) goto L71;
        String r67 = null;
    L70:
        int r911 = r113;
        if (r8.isNull(r911) == false) goto L76;
        String r68 = null;
    L75:
        int r912 = r20;
        if (r8.isNull(r912) == false) goto L80;
        Integer r415 = null;
    L81:
        if (r415 != null) goto L85;
        Boolean r69 = null;
    L83:
        int r913 = r21;
        if (r8.isNull(r913) == false) goto L92;
        Integer r416 = null;
    L93:
        if (r416 != null) goto L97;
        Boolean r70 = null;
    L95:
        int r914 = r22;
        if (r8.getInt(r914) == 0) goto L104;
        boolean r71 = true;
    L105:
        int r915 = r23;
        long r72 = r8.getLong(r915);     // Catch: Throwable -> L191
        int r52 = r24;
        long r74 = r8.getLong(r52);     // Catch: Throwable -> L191
        r24 = r52;
        r25 = r25;
        if (r8.isNull(r25) == false) goto L108;
        Integer r212 = null;
    L109:
        if (r212 != null) goto L112;
        Boolean r76 = null;
    L117:
        if (r8.isNull(r412) == false) goto L119;
        String r77 = null;
    L120:
        long r78 = r8.getLong(r28);     // Catch: Throwable -> L191
        r28 = r28;
        int r54 = r29;
        long r80 = r8.getLong(r54);     // Catch: Throwable -> L191
        r29 = r54;
        int r56 = r210;
        int r82 = r8.getInt(r56);     // Catch: Throwable -> L191
        r210 = r56;
        int r73 = r30;
        long r83 = r8.getLong(r73);     // Catch: Throwable -> L191
        r30 = r73;
        r31 = r31;
        if (r8.isNull(r31) == false) goto L123;
        String r85 = null;
    L124:
        int r86 = r8.getInt(r32);     // Catch: Throwable -> L191
        r32 = r32;
        r33 = r33;
        if (r8.isNull(r33) == false) goto L127;
        String r87 = null;
    L129:
        if (r8.isNull(r34) == false) goto L131;
        Integer r310 = null;
    L132:
        if (r310 != null) goto L135;
        Boolean r88 = null;
    L139:
        int r89 = r8.getInt(r35);     // Catch: Throwable -> L191
        r35 = r35;
        r36 = r36;
        if (r8.isNull(r36) == false) goto L142;
        String r90 = null;
    L144:
        if (r8.isNull(r37) == false) goto L146;
        String r91 = null;
    L148:
        if (r8.isNull(r38) == false) goto L150;
        String r92 = null;
    L152:
        if (r8.isNull(r39) == false) goto L154;
        String r93 = null;
    L156:
        if (r8.isNull(r40) == false) goto L158;
        String r94 = null;
    L160:
        if (r8.isNull(r41) == false) goto L162;
        String r95 = null;
    L164:
        if (r8.isNull(r42) == false) goto L166;
        Long r96 = null;
    L168:
        if (r8.isNull(r43) == false) goto L170;
        String r97 = null;
    L171:
        EpisodicMemoryEntity r75 = new EpisodicMemoryEntity(r51, r53, r55, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r74, r76, r77, r78, r80, r82, r83, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97);     // Catch: Throwable -> L191
        int r417 = r414;
        int r79 = r44;
        if (r8.isNull(r79) == false) goto L174;
        Integer r81 = null;
    L175:
        r75.setPoisonLabel(r81);     // Catch: Throwable -> L191
        r45 = r45;
        if (r8.isNull(r45) == false) goto L178;
        Integer r84 = null;
    L179:
        r75.setPoisonLabelVersion(r84);     // Catch: Throwable -> L191
        r46 = r46;
        if (r8.isNull(r46) == false) goto L182;
        String r101 = null;
    L183:
        r75.setContentHash(r101);     // Catch: Throwable -> L191
        int r418 = r412;
        ArrayList r102 = (ArrayList) ZeusTransformUtils.preCheckCast(r47.get(r8.getString(r412)), ArrayList.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L191
        if (r102 != null) goto L186;
        r102 = new ArrayList();     // Catch: Throwable -> L191
    L186:
        r50.add(new bt(r75, r102));     // Catch: Throwable -> L191
        r2 = r211;
        r27 = r98;
        r111 = r99;
        r112 = r910;
        r113 = r911;
        r20 = r912;
        r21 = r913;
        r22 = r914;
        r23 = r915;
        r414 = r417;
        r412 = r418;
        r44 = r79;
        goto L23
    L182:
        r101 = r8.getString(r46);     // Catch: Throwable -> L191
        goto L183
    L178:
        r84 = Integer.valueOf(r8.getInt(r45));     // Catch: Throwable -> L191
        goto L179
    L174:
        r81 = Integer.valueOf(r8.getInt(r79));     // Catch: Throwable -> L191
        goto L175
    L170:
        r97 = r8.getString(r43);     // Catch: Throwable -> L191
        goto L171
    L166:
        r96 = Long.valueOf(r8.getLong(r42));     // Catch: Throwable -> L191
        goto L168
    L162:
        r95 = r8.getString(r41);     // Catch: Throwable -> L191
        goto L164
    L158:
        r94 = r8.getString(r40);     // Catch: Throwable -> L191
        goto L160
    L154:
        r93 = r8.getString(r39);     // Catch: Throwable -> L191
        goto L156
    L150:
        r92 = r8.getString(r38);     // Catch: Throwable -> L191
        goto L152
    L146:
        r91 = r8.getString(r37);     // Catch: Throwable -> L191
        goto L148
    L142:
        r90 = r8.getString(r36);     // Catch: Throwable -> L191
        goto L144
    L135:
        if (r310.intValue() == 0) goto L137;
        boolean r311 = true;
    L138:
        r88 = Boolean.valueOf(r311);     // Catch: Throwable -> L191
        goto L139
    L137:
        r311 = false;
        goto L138
    L131:
        r310 = Integer.valueOf(r8.getInt(r34));     // Catch: Throwable -> L191
        goto L132
    L127:
        r87 = r8.getString(r33);     // Catch: Throwable -> L191
        goto L129
    L123:
        r85 = r8.getString(r31);     // Catch: Throwable -> L191
        goto L124
    L119:
        r77 = r8.getString(r412);     // Catch: Throwable -> L191
        goto L120
    L112:
        if (r212.intValue() == 0) goto L114;
        boolean r213 = true;
    L115:
        r76 = Boolean.valueOf(r213);     // Catch: Throwable -> L191
        goto L117
    L114:
        r213 = false;
        goto L115
    L108:
        r212 = Integer.valueOf(r8.getInt(r25));     // Catch: Throwable -> L191
        goto L109
    L104:
        r71 = false;
        goto L105
    L97:
        if (r416.intValue() == 0) goto L99;
        boolean r419 = true;
    L100:
        r70 = Boolean.valueOf(r419);     // Catch: Throwable -> L191
        goto L95
    L99:
        r419 = false;
        goto L100
    L92:
        r416 = Integer.valueOf(r8.getInt(r913));     // Catch: Throwable -> L191
        goto L93
    L85:
        if (r415.intValue() == 0) goto L87;
        boolean r420 = true;
    L88:
        r69 = Boolean.valueOf(r420);     // Catch: Throwable -> L191
        goto L83
    L87:
        r420 = false;
        goto L88
    L80:
        r415 = Integer.valueOf(r8.getInt(r912));     // Catch: Throwable -> L191
        goto L81
    L76:
        r68 = r8.getString(r911);     // Catch: Throwable -> L191
        goto L75
    L71:
        r67 = r8.getString(r910);     // Catch: Throwable -> L191
        goto L70
    L66:
        r66 = r8.getString(r99);     // Catch: Throwable -> L191
        goto L65
    L61:
        r65 = Integer.valueOf(r8.getInt(r98));     // Catch: Throwable -> L191
        goto L60
    L56:
        r64 = Integer.valueOf(r8.getInt(r414));     // Catch: Throwable -> L191
        goto L55
    L51:
        r63 = r8.getString(r413);     // Catch: Throwable -> L191
        goto L53
    L47:
        r62 = r8.getString(r16);     // Catch: Throwable -> L191
        goto L49
    L43:
        r61 = r8.getString(r15);     // Catch: Throwable -> L191
        goto L45
    L39:
        r60 = r8.getString(r14);     // Catch: Throwable -> L191
        goto L41
    L35:
        r59 = r8.getString(r13);     // Catch: Throwable -> L191
        goto L37
    L31:
        r58 = r8.getString(r12);     // Catch: Throwable -> L191
        goto L33
    L27:
        r57 = r8.getString(r11);     // Catch: Throwable -> L191
        goto L29
    L187:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L191
        r8.close();     // Catch: Throwable -> L197
        r110.release();     // Catch: Throwable -> L197
        this.__db.endTransaction();
        return r50;
    L191:
        th = th;
    L195:
        r8.close();     // Catch: Throwable -> L197
        r110.release();     // Catch: Throwable -> L197
        throw th;     // Catch: Throwable -> L197
    L193:
        th = th;
        r110 = r5;
    L197:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public PagingSource<Integer, bt> getCollectMemoryWithRelevantPojoBySource(String r5, int r6) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT m.* FROM ShortMemory m INNER JOIN ProactiveEpisodicRelevantData r ON m.entityId = r.episodic_id WHERE m.productType = 1003 AND r.source_package_name = ? AND ((? = 0 AND COALESCE(r.product_type, 0) NOT IN (20, 21)) OR r.product_type = ?) AND NULLIF(TRIM(r.source_app_name), '') IS NOT NULL ORDER BY m.modifyTime DESC", 3);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        long r2 = r6;
        r0.bindLong(2, r2);
        r0.bindLong(3, r2);
        final RoomDatabase r7 = this.__db;
        final String[] r1 = {"ProactiveEpisodicRelevantData", "ShortMemory"};
        return new AnonymousClass7(this, r0, r7, r1);
    L5:
        r0.bindString(1, r5);
        goto L6
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
        return EpisodicMemoryDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return EpisodicMemoryDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return EpisodicMemoryDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<EpisodicMemoryEntity> getEpisodicMemoryEntity(String r96) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM ShortMemory WHERE category = 0 AND entityId = ? LIMIT 1", 1);
        if (r96 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L174
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "actionTimestamp");     // Catch: Throwable -> L174
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "uid");     // Catch: Throwable -> L174
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "title");     // Catch: Throwable -> L174
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, Params.CONTENT);     // Catch: Throwable -> L174
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "contentWithTime");     // Catch: Throwable -> L174
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "fullContent");     // Catch: Throwable -> L174
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "observation");     // Catch: Throwable -> L174
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "location");     // Catch: Throwable -> L174
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "appNames");     // Catch: Throwable -> L174
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L174
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "profileType");     // Catch: Throwable -> L174
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "profileTag");     // Catch: Throwable -> L174
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "tagOther");     // Catch: Throwable -> L174
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L172
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "usedForPortrait");     // Catch: Throwable -> L172
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "useLocation");     // Catch: Throwable -> L172
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "useForUserKeyword");     // Catch: Throwable -> L172
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "startTimestamp");     // Catch: Throwable -> L172
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "endTimestamp");     // Catch: Throwable -> L172
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "useForTopic");     // Catch: Throwable -> L172
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L172
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L172
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L172
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L172
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L172
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L172
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L172
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L172
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, "userEdit");     // Catch: Throwable -> L172
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "productType");     // Catch: Throwable -> L172
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "important_raw_ref_ids");     // Catch: Throwable -> L172
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "source_raw_ref_ids");     // Catch: Throwable -> L172
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, "scene_ids");     // Catch: Throwable -> L172
        int r37 = CursorUtil.getColumnIndexOrThrow(r5, "sourcePackageName");     // Catch: Throwable -> L172
        int r38 = CursorUtil.getColumnIndexOrThrow(r5, "eventName");     // Catch: Throwable -> L172
        int r39 = CursorUtil.getColumnIndexOrThrow(r5, "rawTableName");     // Catch: Throwable -> L172
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "rawDbId");     // Catch: Throwable -> L172
        int r41 = CursorUtil.getColumnIndexOrThrow(r5, "eventData");     // Catch: Throwable -> L172
        int r42 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L172
        int r43 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L172
        int r44 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L172
        int r45 = r4;
        ArrayList r46 = new ArrayList(r5.getCount());     // Catch: Throwable -> L172
    L10:
        if (r5.moveToNext() == false) goto L170;
        long r47 = r5.getLong(r0);     // Catch: Throwable -> L172
        long r49 = r5.getLong(r6);     // Catch: Throwable -> L172
        long r51 = r5.getLong(r7);     // Catch: Throwable -> L172
        if (r5.isNull(r8) == false) goto L15;
        String r53 = null;
    L17:
        if (r5.isNull(r9) == false) goto L19;
        String r54 = null;
    L21:
        if (r5.isNull(r10) == false) goto L23;
        String r55 = null;
    L25:
        if (r5.isNull(r11) == false) goto L27;
        String r56 = null;
    L29:
        if (r5.isNull(r12) == false) goto L31;
        String r57 = null;
    L33:
        if (r5.isNull(r13) == false) goto L35;
        String r58 = null;
    L37:
        if (r5.isNull(r14) == false) goto L39;
        String r59 = null;
    L41:
        if (r5.isNull(r15) == false) goto L43;
        Integer r60 = null;
    L45:
        if (r5.isNull(r1) == false) goto L47;
        Integer r61 = null;
    L49:
        if (r5.isNull(r3) == false) goto L51;
        String r62 = null;
    L53:
        if (r5.isNull(r45) == false) goto L56;
        String r63 = null;
    L55:
        int r94 = r17;
        int r110 = r0;
        if (r5.isNull(r94) == false) goto L61;
        String r64 = null;
    L60:
        int r95 = r18;
        if (r5.isNull(r95) == false) goto L65;
        Integer r48 = null;
    L66:
        if (r48 != null) goto L70;
        Boolean r65 = null;
    L68:
        int r97 = r19;
        if (r5.isNull(r97) == false) goto L77;
        Integer r410 = null;
    L78:
        if (r410 != null) goto L82;
        Boolean r66 = null;
    L80:
        int r98 = r20;
        if (r5.getInt(r98) == 0) goto L89;
        boolean r67 = true;
    L90:
        int r99 = r21;
        long r68 = r5.getLong(r99);     // Catch: Throwable -> L172
        int r50 = r22;
        long r70 = r5.getLong(r50);     // Catch: Throwable -> L172
        r22 = r50;
        r23 = r23;
        if (r5.isNull(r23) == false) goto L93;
        Integer r210 = null;
    L94:
        if (r210 != null) goto L97;
        Boolean r72 = null;
    L102:
        if (r5.isNull(r24) == false) goto L104;
        String r73 = null;
    L105:
        long r74 = r5.getLong(r25);     // Catch: Throwable -> L172
        r25 = r25;
        int r52 = r26;
        long r76 = r5.getLong(r52);     // Catch: Throwable -> L172
        r26 = r52;
        int r69 = r27;
        int r78 = r5.getInt(r69);     // Catch: Throwable -> L172
        r27 = r69;
        int r71 = r28;
        long r79 = r5.getLong(r71);     // Catch: Throwable -> L172
        r28 = r71;
        r29 = r29;
        if (r5.isNull(r29) == false) goto L108;
        String r81 = null;
    L109:
        int r82 = r5.getInt(r30);     // Catch: Throwable -> L172
        r30 = r30;
        r31 = r31;
        if (r5.isNull(r31) == false) goto L112;
        String r83 = null;
    L114:
        if (r5.isNull(r32) == false) goto L116;
        Integer r310 = null;
    L117:
        if (r310 != null) goto L120;
        Boolean r84 = null;
    L124:
        int r85 = r5.getInt(r33);     // Catch: Throwable -> L172
        r33 = r33;
        r34 = r34;
        if (r5.isNull(r34) == false) goto L127;
        String r86 = null;
    L129:
        if (r5.isNull(r35) == false) goto L131;
        String r87 = null;
    L133:
        if (r5.isNull(r36) == false) goto L135;
        String r88 = null;
    L137:
        if (r5.isNull(r37) == false) goto L139;
        String r89 = null;
    L141:
        if (r5.isNull(r38) == false) goto L143;
        String r90 = null;
    L145:
        if (r5.isNull(r39) == false) goto L147;
        String r91 = null;
    L149:
        if (r5.isNull(r40) == false) goto L151;
        Long r92 = null;
    L153:
        if (r5.isNull(r41) == false) goto L155;
        String r93 = null;
    L156:
        EpisodicMemoryEntity r75 = new EpisodicMemoryEntity(r47, r49, r51, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r70, r72, r73, r74, r76, r78, r79, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93);     // Catch: Throwable -> L172
        int r411 = r1;
        int r77 = r42;
        if (r5.isNull(r77) == false) goto L159;
        Integer r80 = null;
    L160:
        r75.setPoisonLabel(r80);     // Catch: Throwable -> L172
        r43 = r43;
        if (r5.isNull(r43) == false) goto L163;
        Integer r100 = null;
    L164:
        r75.setPoisonLabelVersion(r100);     // Catch: Throwable -> L172
        r44 = r44;
        if (r5.isNull(r44) == false) goto L167;
        String r101 = null;
    L168:
        r75.setContentHash(r101);     // Catch: Throwable -> L172
        r46.add(r75);     // Catch: Throwable -> L172
        r0 = r110;
        r17 = r94;
        r18 = r95;
        r19 = r97;
        r20 = r98;
        r21 = r99;
        r1 = r411;
        r42 = r77;
        r45 = r45;
        goto L10
    L167:
        r101 = r5.getString(r44);     // Catch: Throwable -> L172
        goto L168
    L163:
        r100 = Integer.valueOf(r5.getInt(r43));     // Catch: Throwable -> L172
        goto L164
    L159:
        r80 = Integer.valueOf(r5.getInt(r77));     // Catch: Throwable -> L172
        goto L160
    L155:
        r93 = r5.getString(r41);     // Catch: Throwable -> L172
        goto L156
    L151:
        r92 = Long.valueOf(r5.getLong(r40));     // Catch: Throwable -> L172
        goto L153
    L147:
        r91 = r5.getString(r39);     // Catch: Throwable -> L172
        goto L149
    L143:
        r90 = r5.getString(r38);     // Catch: Throwable -> L172
        goto L145
    L139:
        r89 = r5.getString(r37);     // Catch: Throwable -> L172
        goto L141
    L135:
        r88 = r5.getString(r36);     // Catch: Throwable -> L172
        goto L137
    L131:
        r87 = r5.getString(r35);     // Catch: Throwable -> L172
        goto L133
    L127:
        r86 = r5.getString(r34);     // Catch: Throwable -> L172
        goto L129
    L120:
        if (r310.intValue() == 0) goto L122;
        boolean r311 = true;
    L123:
        r84 = Boolean.valueOf(r311);     // Catch: Throwable -> L172
        goto L124
    L122:
        r311 = false;
        goto L123
    L116:
        r310 = Integer.valueOf(r5.getInt(r32));     // Catch: Throwable -> L172
        goto L117
    L112:
        r83 = r5.getString(r31);     // Catch: Throwable -> L172
        goto L114
    L108:
        r81 = r5.getString(r29);     // Catch: Throwable -> L172
        goto L109
    L104:
        r73 = r5.getString(r24);     // Catch: Throwable -> L172
        goto L105
    L97:
        if (r210.intValue() == 0) goto L99;
        boolean r211 = true;
    L100:
        r72 = Boolean.valueOf(r211);     // Catch: Throwable -> L172
        goto L102
    L99:
        r211 = false;
        goto L100
    L93:
        r210 = Integer.valueOf(r5.getInt(r23));     // Catch: Throwable -> L172
        goto L94
    L89:
        r67 = false;
        goto L90
    L82:
        if (r410.intValue() == 0) goto L84;
        boolean r412 = true;
    L85:
        r66 = Boolean.valueOf(r412);     // Catch: Throwable -> L172
        goto L80
    L84:
        r412 = false;
        goto L85
    L77:
        r410 = Integer.valueOf(r5.getInt(r97));     // Catch: Throwable -> L172
        goto L78
    L70:
        if (r48.intValue() == 0) goto L72;
        boolean r413 = true;
    L73:
        r65 = Boolean.valueOf(r413);     // Catch: Throwable -> L172
        goto L68
    L72:
        r413 = false;
        goto L73
    L65:
        r48 = Integer.valueOf(r5.getInt(r95));     // Catch: Throwable -> L172
        goto L66
    L61:
        r64 = r5.getString(r94);     // Catch: Throwable -> L172
        goto L60
    L56:
        r63 = r5.getString(r45);     // Catch: Throwable -> L172
        goto L55
    L51:
        r62 = r5.getString(r3);     // Catch: Throwable -> L172
        goto L53
    L47:
        r61 = Integer.valueOf(r5.getInt(r1));     // Catch: Throwable -> L172
        goto L49
    L43:
        r60 = Integer.valueOf(r5.getInt(r15));     // Catch: Throwable -> L172
        goto L45
    L39:
        r59 = r5.getString(r14);     // Catch: Throwable -> L172
        goto L41
    L35:
        r58 = r5.getString(r13);     // Catch: Throwable -> L172
        goto L37
    L31:
        r57 = r5.getString(r12);     // Catch: Throwable -> L172
        goto L33
    L27:
        r56 = r5.getString(r11);     // Catch: Throwable -> L172
        goto L29
    L23:
        r55 = r5.getString(r10);     // Catch: Throwable -> L172
        goto L25
    L19:
        r54 = r5.getString(r9);     // Catch: Throwable -> L172
        goto L21
    L15:
        r53 = r5.getString(r8);     // Catch: Throwable -> L172
        goto L17
    L170:
        r5.close();
        r16.release();
        return r46;
    L172:
        th = th;
    L176:
        r5.close();
        r16.release();
        throw th;
    L174:
        th = th;
        r16 = r2;
        goto L176
    L5:
        r2.bindString(1, r96);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<EpisodicMemoryEntity> getEpisodicMemoryEntityByEntities(List<String> r3) {
        return EpisodicMemoryDao.DefaultImpls.getEpisodicMemoryEntityByEntities(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
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
        return EpisodicMemoryDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return EpisodicMemoryDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
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

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public Object getMemoryCountByTimeRange(long r4, long r6, Continuation<? super Integer> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM ShortMemory WHERE category = 0 AND productType IN (1001, 1005, 1006) AND createTime BETWEEN ? AND ?", 2);
        r0.bindLong(1, r4);
        r0.bindLong(2, r6);
        CancellationSignal r5 = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, r5, new AnonymousClass13(this, r0), r9);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public Object getMemoryCountsByTimeRanges(List<Pair<Long, Long>> r3, Continuation<? super List<Integer>> r4) {
        final List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return RoomDatabaseKt.withTransaction(this.__db, new $$Lambda$EpisodicMemoryDao_Impl$WoV6MBBVV1sOY3wGP365idPOyKc(this, r5), r6);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<String> getPackageNameList() {
        return EpisodicMemoryDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<String> getScreenMemoryDateList() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT DATE(datetime(startTimestamp / 1000, 'unixepoch', 'localtime')) FROM ShortMemory WHERE category = 0 AND productType IN (1001, 1005, 1006) ORDER BY startTimestamp ", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r5.getCount());     // Catch: Throwable -> L14
    L4:
        if (r5.moveToNext() == false) goto L12;
        if (r5.isNull(0) == false) goto L9;
        String r4 = null;
    L10:
        r3.add(r4);     // Catch: Throwable -> L14
        goto L4
    L9:
        r4 = r5.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r5.close();
        r0.release();
        return r3;
    L14:
        th = move-exception;
        r5.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public Long getScreenMemoryValidateDay(long r3) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(DISTINCT DATE(datetime(startTimestamp / 1000, 'unixepoch', 'localtime'))) FROM ShortMemory WHERE category = 0 AND productType IN (1001, 1005, 1006) AND startTimestamp < ?", 1);
        r0.bindLong(1, r3);
        this.__db.assertNotSuspendingTransaction();
        Long r4 = null;
        Cursor r2 = DBUtil.query(this.__db, r0, false, null);
    L12:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    L4:
        if (r2.moveToFirst() == true) goto L6;
    L10:
        r2.close();
        r0.release();
        return r4;
    L6:
        if (r2.isNull(0) == true) goto L10;
        r4 = Long.valueOf(r2.getLong(0));     // Catch: Throwable -> L12
        goto L10
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return EpisodicMemoryDao.DefaultImpls.getTableName(this);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<String> getUUIDListByEntityIds(List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT uuid FROM ShortMemory WHERE entityId IN (");
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

    public long insert(EpisodicMemoryEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfEpisodicMemoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r3, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<EpisodicMemoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfEpisodicMemoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public /* synthetic */ Object lambda$getMemoryCountsByTimeRanges$0$EpisodicMemoryDao_Impl(List r3, Continuation r4) {
        return EpisodicMemoryDao.DefaultImpls.getMemoryCountsByTimeRanges(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public Long latestValidCreateTime() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT MAX(createTime) FROM ShortMemory WHERE category = 0 AND createTime > 0", 0);
        this.__db.assertNotSuspendingTransaction();
        Long r2 = null;
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
    L12:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L4:
        if (r4.moveToFirst() == true) goto L6;
    L10:
        r4.close();
        r0.release();
        return r2;
    L6:
        if (r4.isNull(0) == true) goto L10;
        r2 = Long.valueOf(r4.getLong(0));     // Catch: Throwable -> L12
        goto L10
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<EpisodicMemoryEntity> queryAll() {
        return EpisodicMemoryDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return EpisodicMemoryDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<EpisodicMemoryEntity> queryAudioMemoryReviewPage(long r89, long r91, long r93, String r95, int r96) {
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("\n        SELECT * FROM ShortMemory\n        WHERE productType = 1006\n            AND modifyTime >= ?\n            AND modifyTime < ?\n            AND (modifyTime < ? OR (modifyTime = ? AND entityId < ?))\n        ORDER BY modifyTime DESC, entityId DESC\n        LIMIT ?\n        ", 6);
        r4.bindLong(1, r89);
        r4.bindLong(2, r91);
        r4.bindLong(3, r93);
        r4.bindLong(4, r93);
        if (r95 != null) goto L5;
        r4.bindNull(5);
    L6:
        r4.bindLong(6, r96);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r4, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r3, OaidModel.KEY_ID);     // Catch: Throwable -> L174
        int r5 = CursorUtil.getColumnIndexOrThrow(r3, "actionTimestamp");     // Catch: Throwable -> L174
        int r7 = CursorUtil.getColumnIndexOrThrow(r3, "uid");     // Catch: Throwable -> L174
        int r8 = CursorUtil.getColumnIndexOrThrow(r3, "title");     // Catch: Throwable -> L174
        int r9 = CursorUtil.getColumnIndexOrThrow(r3, Params.CONTENT);     // Catch: Throwable -> L174
        int r10 = CursorUtil.getColumnIndexOrThrow(r3, "contentWithTime");     // Catch: Throwable -> L174
        int r11 = CursorUtil.getColumnIndexOrThrow(r3, "fullContent");     // Catch: Throwable -> L174
        int r12 = CursorUtil.getColumnIndexOrThrow(r3, "observation");     // Catch: Throwable -> L174
        int r13 = CursorUtil.getColumnIndexOrThrow(r3, "location");     // Catch: Throwable -> L174
        int r14 = CursorUtil.getColumnIndexOrThrow(r3, "appNames");     // Catch: Throwable -> L174
        int r15 = CursorUtil.getColumnIndexOrThrow(r3, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L174
        int r1 = CursorUtil.getColumnIndexOrThrow(r3, "profileType");     // Catch: Throwable -> L174
        int r2 = CursorUtil.getColumnIndexOrThrow(r3, "profileTag");     // Catch: Throwable -> L174
        int r6 = CursorUtil.getColumnIndexOrThrow(r3, "tagOther");     // Catch: Throwable -> L174
        RoomSQLiteQuery r16 = r4;
        int r90 = CursorUtil.getColumnIndexOrThrow(r3, "logId");     // Catch: Throwable -> L172
        int r92 = CursorUtil.getColumnIndexOrThrow(r3, "usedForPortrait");     // Catch: Throwable -> L172
        int r94 = CursorUtil.getColumnIndexOrThrow(r3, "useLocation");     // Catch: Throwable -> L172
        int r97 = CursorUtil.getColumnIndexOrThrow(r3, "useForUserKeyword");     // Catch: Throwable -> L172
        int r98 = CursorUtil.getColumnIndexOrThrow(r3, "startTimestamp");     // Catch: Throwable -> L172
        int r99 = CursorUtil.getColumnIndexOrThrow(r3, "endTimestamp");     // Catch: Throwable -> L172
        int r910 = CursorUtil.getColumnIndexOrThrow(r3, "useForTopic");     // Catch: Throwable -> L172
        int r17 = CursorUtil.getColumnIndexOrThrow(r3, "entityId");     // Catch: Throwable -> L172
        int r18 = CursorUtil.getColumnIndexOrThrow(r3, "createTime");     // Catch: Throwable -> L172
        int r19 = CursorUtil.getColumnIndexOrThrow(r3, "modifyTime");     // Catch: Throwable -> L172
        int r20 = CursorUtil.getColumnIndexOrThrow(r3, "type");     // Catch: Throwable -> L172
        int r21 = CursorUtil.getColumnIndexOrThrow(r3, "timestamp");     // Catch: Throwable -> L172
        int r22 = CursorUtil.getColumnIndexOrThrow(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L172
        int r23 = CursorUtil.getColumnIndexOrThrow(r3, "hashCodeValue");     // Catch: Throwable -> L172
        int r24 = CursorUtil.getColumnIndexOrThrow(r3, Api.KEY_UUID);     // Catch: Throwable -> L172
        int r25 = CursorUtil.getColumnIndexOrThrow(r3, "userEdit");     // Catch: Throwable -> L172
        int r26 = CursorUtil.getColumnIndexOrThrow(r3, "productType");     // Catch: Throwable -> L172
        int r27 = CursorUtil.getColumnIndexOrThrow(r3, "important_raw_ref_ids");     // Catch: Throwable -> L172
        int r28 = CursorUtil.getColumnIndexOrThrow(r3, "source_raw_ref_ids");     // Catch: Throwable -> L172
        int r29 = CursorUtil.getColumnIndexOrThrow(r3, "scene_ids");     // Catch: Throwable -> L172
        int r30 = CursorUtil.getColumnIndexOrThrow(r3, "sourcePackageName");     // Catch: Throwable -> L172
        int r31 = CursorUtil.getColumnIndexOrThrow(r3, "eventName");     // Catch: Throwable -> L172
        int r32 = CursorUtil.getColumnIndexOrThrow(r3, "rawTableName");     // Catch: Throwable -> L172
        int r33 = CursorUtil.getColumnIndexOrThrow(r3, "rawDbId");     // Catch: Throwable -> L172
        int r34 = CursorUtil.getColumnIndexOrThrow(r3, "eventData");     // Catch: Throwable -> L172
        int r35 = CursorUtil.getColumnIndexOrThrow(r3, "poison_label");     // Catch: Throwable -> L172
        int r36 = CursorUtil.getColumnIndexOrThrow(r3, "poison_label_version");     // Catch: Throwable -> L172
        int r37 = CursorUtil.getColumnIndexOrThrow(r3, "content_hash");     // Catch: Throwable -> L172
        int r38 = r6;
        ArrayList r39 = new ArrayList(r3.getCount());     // Catch: Throwable -> L172
    L10:
        if (r3.moveToNext() == false) goto L170;
        long r40 = r3.getLong(r0);     // Catch: Throwable -> L172
        long r42 = r3.getLong(r5);     // Catch: Throwable -> L172
        long r44 = r3.getLong(r7);     // Catch: Throwable -> L172
        if (r3.isNull(r8) == false) goto L15;
        String r46 = null;
    L17:
        if (r3.isNull(r9) == false) goto L19;
        String r47 = null;
    L21:
        if (r3.isNull(r10) == false) goto L23;
        String r48 = null;
    L25:
        if (r3.isNull(r11) == false) goto L27;
        String r49 = null;
    L29:
        if (r3.isNull(r12) == false) goto L31;
        String r50 = null;
    L33:
        if (r3.isNull(r13) == false) goto L35;
        String r51 = null;
    L37:
        if (r3.isNull(r14) == false) goto L39;
        String r52 = null;
    L41:
        if (r3.isNull(r15) == false) goto L43;
        Integer r53 = null;
    L45:
        if (r3.isNull(r1) == false) goto L47;
        Integer r54 = null;
    L49:
        if (r3.isNull(r2) == false) goto L51;
        String r55 = null;
    L53:
        if (r3.isNull(r38) == false) goto L56;
        String r56 = null;
    L55:
        int r87 = r0;
        int r41 = r90;
        if (r3.isNull(r41) == false) goto L61;
        String r57 = null;
    L60:
        r92 = r92;
        if (r3.isNull(r92) == false) goto L65;
        Integer r310 = null;
    L66:
        if (r310 != null) goto L70;
        Boolean r58 = null;
    L68:
        r94 = r94;
        if (r3.isNull(r94) == false) goto L77;
        Integer r311 = null;
    L78:
        if (r311 != null) goto L82;
        Boolean r59 = null;
    L80:
        int r43 = r97;
        r97 = r43;
        if (r3.getInt(r43) == 0) goto L89;
        boolean r60 = true;
    L90:
        int r45 = r98;
        long r61 = r3.getLong(r45);     // Catch: Throwable -> L172
        r98 = r45;
        int r62 = r99;
        long r63 = r3.getLong(r62);     // Catch: Throwable -> L172
        r99 = r62;
        r910 = r910;
        if (r3.isNull(r910) == false) goto L93;
        Integer r312 = null;
    L94:
        if (r312 != null) goto L97;
        Boolean r65 = null;
    L102:
        if (r3.isNull(r17) == false) goto L104;
        String r66 = null;
    L105:
        long r67 = r3.getLong(r18);     // Catch: Throwable -> L172
        r18 = r18;
        int r64 = r19;
        long r69 = r3.getLong(r64);     // Catch: Throwable -> L172
        r19 = r64;
        int r68 = r20;
        int r71 = r3.getInt(r68);     // Catch: Throwable -> L172
        r20 = r68;
        int r70 = r21;
        long r72 = r3.getLong(r70);     // Catch: Throwable -> L172
        r21 = r70;
        r22 = r22;
        if (r3.isNull(r22) == false) goto L108;
        String r74 = null;
    L109:
        int r75 = r3.getInt(r23);     // Catch: Throwable -> L172
        r23 = r23;
        r24 = r24;
        if (r3.isNull(r24) == false) goto L112;
        String r76 = null;
    L114:
        if (r3.isNull(r25) == false) goto L116;
        Integer r210 = null;
    L117:
        if (r210 != null) goto L120;
        Boolean r77 = null;
    L124:
        int r78 = r3.getInt(r26);     // Catch: Throwable -> L172
        r26 = r26;
        r27 = r27;
        if (r3.isNull(r27) == false) goto L127;
        String r79 = null;
    L129:
        if (r3.isNull(r28) == false) goto L131;
        String r80 = null;
    L133:
        if (r3.isNull(r29) == false) goto L135;
        String r81 = null;
    L137:
        if (r3.isNull(r30) == false) goto L139;
        String r82 = null;
    L141:
        if (r3.isNull(r31) == false) goto L143;
        String r83 = null;
    L145:
        if (r3.isNull(r32) == false) goto L147;
        String r84 = null;
    L149:
        if (r3.isNull(r33) == false) goto L151;
        Long r85 = null;
    L153:
        if (r3.isNull(r34) == false) goto L155;
        String r86 = null;
    L156:
        EpisodicMemoryEntity r73 = new EpisodicMemoryEntity(r40, r42, r44, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r63, r65, r66, r67, r69, r71, r72, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86);     // Catch: Throwable -> L172
        int r313 = r1;
        int r88 = r35;
        if (r3.isNull(r88) == false) goto L159;
        Integer r100 = null;
    L160:
        r73.setPoisonLabel(r100);     // Catch: Throwable -> L172
        r36 = r36;
        if (r3.isNull(r36) == false) goto L163;
        Integer r101 = null;
    L164:
        r73.setPoisonLabelVersion(r101);     // Catch: Throwable -> L172
        r37 = r37;
        if (r3.isNull(r37) == false) goto L167;
        String r102 = null;
    L168:
        r73.setContentHash(r102);     // Catch: Throwable -> L172
        r39.add(r73);     // Catch: Throwable -> L172
        r0 = r87;
        r90 = r41;
        r1 = r313;
        r35 = r88;
        r38 = r38;
        goto L10
    L167:
        r102 = r3.getString(r37);     // Catch: Throwable -> L172
        goto L168
    L163:
        r101 = Integer.valueOf(r3.getInt(r36));     // Catch: Throwable -> L172
        goto L164
    L159:
        r100 = Integer.valueOf(r3.getInt(r88));     // Catch: Throwable -> L172
        goto L160
    L155:
        r86 = r3.getString(r34);     // Catch: Throwable -> L172
        goto L156
    L151:
        r85 = Long.valueOf(r3.getLong(r33));     // Catch: Throwable -> L172
        goto L153
    L147:
        r84 = r3.getString(r32);     // Catch: Throwable -> L172
        goto L149
    L143:
        r83 = r3.getString(r31);     // Catch: Throwable -> L172
        goto L145
    L139:
        r82 = r3.getString(r30);     // Catch: Throwable -> L172
        goto L141
    L135:
        r81 = r3.getString(r29);     // Catch: Throwable -> L172
        goto L137
    L131:
        r80 = r3.getString(r28);     // Catch: Throwable -> L172
        goto L133
    L127:
        r79 = r3.getString(r27);     // Catch: Throwable -> L172
        goto L129
    L120:
        if (r210.intValue() == 0) goto L122;
        boolean r211 = true;
    L123:
        r77 = Boolean.valueOf(r211);     // Catch: Throwable -> L172
        goto L124
    L122:
        r211 = false;
        goto L123
    L116:
        r210 = Integer.valueOf(r3.getInt(r25));     // Catch: Throwable -> L172
        goto L117
    L112:
        r76 = r3.getString(r24);     // Catch: Throwable -> L172
        goto L114
    L108:
        r74 = r3.getString(r22);     // Catch: Throwable -> L172
        goto L109
    L104:
        r66 = r3.getString(r17);     // Catch: Throwable -> L172
        goto L105
    L97:
        if (r312.intValue() == 0) goto L99;
        boolean r314 = true;
    L100:
        r65 = Boolean.valueOf(r314);     // Catch: Throwable -> L172
        goto L102
    L99:
        r314 = false;
        goto L100
    L93:
        r312 = Integer.valueOf(r3.getInt(r910));     // Catch: Throwable -> L172
        goto L94
    L89:
        r60 = false;
        goto L90
    L82:
        if (r311.intValue() == 0) goto L84;
        boolean r315 = true;
    L85:
        r59 = Boolean.valueOf(r315);     // Catch: Throwable -> L172
        goto L80
    L84:
        r315 = false;
        goto L85
    L77:
        r311 = Integer.valueOf(r3.getInt(r94));     // Catch: Throwable -> L172
        goto L78
    L70:
        if (r310.intValue() == 0) goto L72;
        boolean r316 = true;
    L73:
        r58 = Boolean.valueOf(r316);     // Catch: Throwable -> L172
        goto L68
    L72:
        r316 = false;
        goto L73
    L65:
        r310 = Integer.valueOf(r3.getInt(r92));     // Catch: Throwable -> L172
        goto L66
    L61:
        r57 = r3.getString(r41);     // Catch: Throwable -> L172
        goto L60
    L56:
        r56 = r3.getString(r38);     // Catch: Throwable -> L172
        goto L55
    L51:
        r55 = r3.getString(r2);     // Catch: Throwable -> L172
        goto L53
    L47:
        r54 = Integer.valueOf(r3.getInt(r1));     // Catch: Throwable -> L172
        goto L49
    L43:
        r53 = Integer.valueOf(r3.getInt(r15));     // Catch: Throwable -> L172
        goto L45
    L39:
        r52 = r3.getString(r14);     // Catch: Throwable -> L172
        goto L41
    L35:
        r51 = r3.getString(r13);     // Catch: Throwable -> L172
        goto L37
    L31:
        r50 = r3.getString(r12);     // Catch: Throwable -> L172
        goto L33
    L27:
        r49 = r3.getString(r11);     // Catch: Throwable -> L172
        goto L29
    L23:
        r48 = r3.getString(r10);     // Catch: Throwable -> L172
        goto L25
    L19:
        r47 = r3.getString(r9);     // Catch: Throwable -> L172
        goto L21
    L15:
        r46 = r3.getString(r8);     // Catch: Throwable -> L172
        goto L17
    L170:
        r3.close();
        r16.release();
        return r39;
    L172:
        th = th;
    L176:
        r3.close();
        r16.release();
        throw th;
    L174:
        th = th;
        r16 = r4;
        goto L176
    L5:
        r4.bindString(5, r95);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public EpisodicMemoryEntity queryByEntityId(String r1) {
        return EpisodicMemoryDao.DefaultImpls.queryByEntityId(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<EpisodicMemoryEntity> queryByEntityId(String r1, String r2) {
        return EpisodicMemoryDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<EpisodicMemoryEntity> queryByEntityIdList(List<String> r3) {
        return EpisodicMemoryDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<EpisodicMemoryEntity> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return EpisodicMemoryDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<EpisodicMemoryEntity> queryByEntityIds(List<String> r96) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r96, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM ShortMemory WHERE entityId IN (");
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
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L178
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "actionTimestamp");     // Catch: Throwable -> L178
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "uid");     // Catch: Throwable -> L178
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "title");     // Catch: Throwable -> L178
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, Params.CONTENT);     // Catch: Throwable -> L178
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "contentWithTime");     // Catch: Throwable -> L178
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, "fullContent");     // Catch: Throwable -> L178
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "observation");     // Catch: Throwable -> L178
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, "location");     // Catch: Throwable -> L178
        int r17 = CursorUtil.getColumnIndexOrThrow(r8, "appNames");     // Catch: Throwable -> L178
        int r18 = CursorUtil.getColumnIndexOrThrow(r8, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L178
        int r19 = CursorUtil.getColumnIndexOrThrow(r8, "profileType");     // Catch: Throwable -> L178
        int r20 = CursorUtil.getColumnIndexOrThrow(r8, "profileTag");     // Catch: Throwable -> L178
        int r21 = CursorUtil.getColumnIndexOrThrow(r8, "tagOther");     // Catch: Throwable -> L178
        RoomSQLiteQuery r110 = r5;
        int r111 = CursorUtil.getColumnIndexOrThrow(r8, "logId");     // Catch: Throwable -> L176
        int r112 = CursorUtil.getColumnIndexOrThrow(r8, "usedForPortrait");     // Catch: Throwable -> L176
        int r113 = CursorUtil.getColumnIndexOrThrow(r8, "useLocation");     // Catch: Throwable -> L176
        int r22 = CursorUtil.getColumnIndexOrThrow(r8, "useForUserKeyword");     // Catch: Throwable -> L176
        int r23 = CursorUtil.getColumnIndexOrThrow(r8, "startTimestamp");     // Catch: Throwable -> L176
        int r24 = CursorUtil.getColumnIndexOrThrow(r8, "endTimestamp");     // Catch: Throwable -> L176
        int r25 = CursorUtil.getColumnIndexOrThrow(r8, "useForTopic");     // Catch: Throwable -> L176
        int r26 = CursorUtil.getColumnIndexOrThrow(r8, "entityId");     // Catch: Throwable -> L176
        int r27 = CursorUtil.getColumnIndexOrThrow(r8, "createTime");     // Catch: Throwable -> L176
        int r28 = CursorUtil.getColumnIndexOrThrow(r8, "modifyTime");     // Catch: Throwable -> L176
        int r29 = CursorUtil.getColumnIndexOrThrow(r8, "type");     // Catch: Throwable -> L176
        int r210 = CursorUtil.getColumnIndexOrThrow(r8, "timestamp");     // Catch: Throwable -> L176
        int r211 = CursorUtil.getColumnIndexOrThrow(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L176
        int r30 = CursorUtil.getColumnIndexOrThrow(r8, "hashCodeValue");     // Catch: Throwable -> L176
        int r31 = CursorUtil.getColumnIndexOrThrow(r8, Api.KEY_UUID);     // Catch: Throwable -> L176
        int r32 = CursorUtil.getColumnIndexOrThrow(r8, "userEdit");     // Catch: Throwable -> L176
        int r33 = CursorUtil.getColumnIndexOrThrow(r8, "productType");     // Catch: Throwable -> L176
        int r34 = CursorUtil.getColumnIndexOrThrow(r8, "important_raw_ref_ids");     // Catch: Throwable -> L176
        int r35 = CursorUtil.getColumnIndexOrThrow(r8, "source_raw_ref_ids");     // Catch: Throwable -> L176
        int r36 = CursorUtil.getColumnIndexOrThrow(r8, "scene_ids");     // Catch: Throwable -> L176
        int r37 = CursorUtil.getColumnIndexOrThrow(r8, "sourcePackageName");     // Catch: Throwable -> L176
        int r38 = CursorUtil.getColumnIndexOrThrow(r8, "eventName");     // Catch: Throwable -> L176
        int r39 = CursorUtil.getColumnIndexOrThrow(r8, "rawTableName");     // Catch: Throwable -> L176
        int r40 = CursorUtil.getColumnIndexOrThrow(r8, "rawDbId");     // Catch: Throwable -> L176
        int r41 = CursorUtil.getColumnIndexOrThrow(r8, "eventData");     // Catch: Throwable -> L176
        int r42 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label");     // Catch: Throwable -> L176
        int r43 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label_version");     // Catch: Throwable -> L176
        int r44 = CursorUtil.getColumnIndexOrThrow(r8, "content_hash");     // Catch: Throwable -> L176
        int r45 = r21;
        ArrayList r46 = new ArrayList(r8.getCount());     // Catch: Throwable -> L176
    L14:
        if (r8.moveToNext() == false) goto L174;
        long r47 = r8.getLong(r0);     // Catch: Throwable -> L176
        long r49 = r8.getLong(r9);     // Catch: Throwable -> L176
        long r51 = r8.getLong(r10);     // Catch: Throwable -> L176
        if (r8.isNull(r11) == false) goto L19;
        String r53 = null;
    L21:
        if (r8.isNull(r12) == false) goto L23;
        String r54 = null;
    L25:
        if (r8.isNull(r13) == false) goto L27;
        String r55 = null;
    L29:
        if (r8.isNull(r14) == false) goto L31;
        String r56 = null;
    L33:
        if (r8.isNull(r15) == false) goto L35;
        String r57 = null;
    L37:
        if (r8.isNull(r16) == false) goto L39;
        String r58 = null;
    L41:
        if (r8.isNull(r17) == false) goto L43;
        String r59 = null;
    L45:
        if (r8.isNull(r18) == false) goto L47;
        Integer r60 = null;
    L49:
        if (r8.isNull(r19) == false) goto L51;
        Integer r61 = null;
    L53:
        if (r8.isNull(r20) == false) goto L55;
        String r62 = null;
    L57:
        if (r8.isNull(r45) == false) goto L60;
        String r63 = null;
    L59:
        int r94 = r111;
        int r114 = r0;
        if (r8.isNull(r94) == false) goto L65;
        String r64 = null;
    L64:
        int r95 = r112;
        if (r8.isNull(r95) == false) goto L69;
        Integer r48 = null;
    L70:
        if (r48 != null) goto L74;
        Boolean r65 = null;
    L72:
        int r97 = r113;
        if (r8.isNull(r97) == false) goto L81;
        Integer r410 = null;
    L82:
        if (r410 != null) goto L86;
        Boolean r66 = null;
    L84:
        int r98 = r22;
        if (r8.getInt(r98) == 0) goto L93;
        boolean r67 = true;
    L94:
        int r99 = r23;
        long r68 = r8.getLong(r99);     // Catch: Throwable -> L176
        int r50 = r24;
        long r70 = r8.getLong(r50);     // Catch: Throwable -> L176
        r24 = r50;
        r25 = r25;
        if (r8.isNull(r25) == false) goto L97;
        Integer r212 = null;
    L98:
        if (r212 != null) goto L101;
        Boolean r72 = null;
    L106:
        if (r8.isNull(r26) == false) goto L108;
        String r73 = null;
    L109:
        long r74 = r8.getLong(r27);     // Catch: Throwable -> L176
        r27 = r27;
        int r52 = r28;
        long r76 = r8.getLong(r52);     // Catch: Throwable -> L176
        r28 = r52;
        int r69 = r29;
        int r78 = r8.getInt(r69);     // Catch: Throwable -> L176
        r29 = r69;
        int r71 = r210;
        long r79 = r8.getLong(r71);     // Catch: Throwable -> L176
        r210 = r71;
        r211 = r211;
        if (r8.isNull(r211) == false) goto L112;
        String r81 = null;
    L113:
        int r82 = r8.getInt(r30);     // Catch: Throwable -> L176
        r30 = r30;
        r31 = r31;
        if (r8.isNull(r31) == false) goto L116;
        String r83 = null;
    L118:
        if (r8.isNull(r32) == false) goto L120;
        Integer r310 = null;
    L121:
        if (r310 != null) goto L124;
        Boolean r84 = null;
    L128:
        int r85 = r8.getInt(r33);     // Catch: Throwable -> L176
        r33 = r33;
        r34 = r34;
        if (r8.isNull(r34) == false) goto L131;
        String r86 = null;
    L133:
        if (r8.isNull(r35) == false) goto L135;
        String r87 = null;
    L137:
        if (r8.isNull(r36) == false) goto L139;
        String r88 = null;
    L141:
        if (r8.isNull(r37) == false) goto L143;
        String r89 = null;
    L145:
        if (r8.isNull(r38) == false) goto L147;
        String r90 = null;
    L149:
        if (r8.isNull(r39) == false) goto L151;
        String r91 = null;
    L153:
        if (r8.isNull(r40) == false) goto L155;
        Long r92 = null;
    L157:
        if (r8.isNull(r41) == false) goto L159;
        String r93 = null;
    L160:
        EpisodicMemoryEntity r75 = new EpisodicMemoryEntity(r47, r49, r51, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r70, r72, r73, r74, r76, r78, r79, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93);     // Catch: Throwable -> L176
        int r411 = r19;
        int r77 = r42;
        if (r8.isNull(r77) == false) goto L163;
        Integer r80 = null;
    L164:
        r75.setPoisonLabel(r80);     // Catch: Throwable -> L176
        r43 = r43;
        if (r8.isNull(r43) == false) goto L167;
        Integer r100 = null;
    L168:
        r75.setPoisonLabelVersion(r100);     // Catch: Throwable -> L176
        r44 = r44;
        if (r8.isNull(r44) == false) goto L171;
        String r101 = null;
    L172:
        r75.setContentHash(r101);     // Catch: Throwable -> L176
        r46.add(r75);     // Catch: Throwable -> L176
        r0 = r114;
        r111 = r94;
        r112 = r95;
        r113 = r97;
        r22 = r98;
        r23 = r99;
        r19 = r411;
        r42 = r77;
        r45 = r45;
        goto L14
    L171:
        r101 = r8.getString(r44);     // Catch: Throwable -> L176
        goto L172
    L167:
        r100 = Integer.valueOf(r8.getInt(r43));     // Catch: Throwable -> L176
        goto L168
    L163:
        r80 = Integer.valueOf(r8.getInt(r77));     // Catch: Throwable -> L176
        goto L164
    L159:
        r93 = r8.getString(r41);     // Catch: Throwable -> L176
        goto L160
    L155:
        r92 = Long.valueOf(r8.getLong(r40));     // Catch: Throwable -> L176
        goto L157
    L151:
        r91 = r8.getString(r39);     // Catch: Throwable -> L176
        goto L153
    L147:
        r90 = r8.getString(r38);     // Catch: Throwable -> L176
        goto L149
    L143:
        r89 = r8.getString(r37);     // Catch: Throwable -> L176
        goto L145
    L139:
        r88 = r8.getString(r36);     // Catch: Throwable -> L176
        goto L141
    L135:
        r87 = r8.getString(r35);     // Catch: Throwable -> L176
        goto L137
    L131:
        r86 = r8.getString(r34);     // Catch: Throwable -> L176
        goto L133
    L124:
        if (r310.intValue() == 0) goto L126;
        boolean r311 = true;
    L127:
        r84 = Boolean.valueOf(r311);     // Catch: Throwable -> L176
        goto L128
    L126:
        r311 = false;
        goto L127
    L120:
        r310 = Integer.valueOf(r8.getInt(r32));     // Catch: Throwable -> L176
        goto L121
    L116:
        r83 = r8.getString(r31);     // Catch: Throwable -> L176
        goto L118
    L112:
        r81 = r8.getString(r211);     // Catch: Throwable -> L176
        goto L113
    L108:
        r73 = r8.getString(r26);     // Catch: Throwable -> L176
        goto L109
    L101:
        if (r212.intValue() == 0) goto L103;
        boolean r213 = true;
    L104:
        r72 = Boolean.valueOf(r213);     // Catch: Throwable -> L176
        goto L106
    L103:
        r213 = false;
        goto L104
    L97:
        r212 = Integer.valueOf(r8.getInt(r25));     // Catch: Throwable -> L176
        goto L98
    L93:
        r67 = false;
        goto L94
    L86:
        if (r410.intValue() == 0) goto L88;
        boolean r412 = true;
    L89:
        r66 = Boolean.valueOf(r412);     // Catch: Throwable -> L176
        goto L84
    L88:
        r412 = false;
        goto L89
    L81:
        r410 = Integer.valueOf(r8.getInt(r97));     // Catch: Throwable -> L176
        goto L82
    L74:
        if (r48.intValue() == 0) goto L76;
        boolean r413 = true;
    L77:
        r65 = Boolean.valueOf(r413);     // Catch: Throwable -> L176
        goto L72
    L76:
        r413 = false;
        goto L77
    L69:
        r48 = Integer.valueOf(r8.getInt(r95));     // Catch: Throwable -> L176
        goto L70
    L65:
        r64 = r8.getString(r94);     // Catch: Throwable -> L176
        goto L64
    L60:
        r63 = r8.getString(r45);     // Catch: Throwable -> L176
        goto L59
    L55:
        r62 = r8.getString(r20);     // Catch: Throwable -> L176
        goto L57
    L51:
        r61 = Integer.valueOf(r8.getInt(r19));     // Catch: Throwable -> L176
        goto L53
    L47:
        r60 = Integer.valueOf(r8.getInt(r18));     // Catch: Throwable -> L176
        goto L49
    L43:
        r59 = r8.getString(r17);     // Catch: Throwable -> L176
        goto L45
    L39:
        r58 = r8.getString(r16);     // Catch: Throwable -> L176
        goto L41
    L35:
        r57 = r8.getString(r15);     // Catch: Throwable -> L176
        goto L37
    L31:
        r56 = r8.getString(r14);     // Catch: Throwable -> L176
        goto L33
    L27:
        r55 = r8.getString(r13);     // Catch: Throwable -> L176
        goto L29
    L23:
        r54 = r8.getString(r12);     // Catch: Throwable -> L176
        goto L25
    L19:
        r53 = r8.getString(r11);     // Catch: Throwable -> L176
        goto L21
    L174:
        r8.close();
        r110.release();
        return r46;
    L176:
        th = th;
    L180:
        r8.close();
        r110.release();
        throw th;
    L178:
        th = th;
        r110 = r5;
        goto L180
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public EpisodicMemoryEntity queryById(long r1) {
        return EpisodicMemoryDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<EpisodicMemoryEntity> queryByIdAndTimestamp(long r1, long r3) {
        return EpisodicMemoryDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<EpisodicMemoryEntity> queryByIds(List<Long> r3) {
        return EpisodicMemoryDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return EpisodicMemoryDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<EpisodicMemoryEntity> queryByPackageName(String r1) {
        return EpisodicMemoryDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<EpisodicMemoryEntity> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return EpisodicMemoryDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<EpisodicMemoryEntity> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return EpisodicMemoryDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<EpisodicMemoryEntity> queryByProductType(int r96) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ShortMemory WHERE productType = ?", 1);
        r1.bindLong(1, r96);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L170
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "actionTimestamp");     // Catch: Throwable -> L170
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "uid");     // Catch: Throwable -> L170
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "title");     // Catch: Throwable -> L170
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, Params.CONTENT);     // Catch: Throwable -> L170
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "contentWithTime");     // Catch: Throwable -> L170
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "fullContent");     // Catch: Throwable -> L170
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "observation");     // Catch: Throwable -> L170
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "location");     // Catch: Throwable -> L170
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "appNames");     // Catch: Throwable -> L170
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L170
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, "profileType");     // Catch: Throwable -> L170
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "profileTag");     // Catch: Throwable -> L170
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "tagOther");     // Catch: Throwable -> L170
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L168
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "usedForPortrait");     // Catch: Throwable -> L168
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "useLocation");     // Catch: Throwable -> L168
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "useForUserKeyword");     // Catch: Throwable -> L168
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "startTimestamp");     // Catch: Throwable -> L168
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "endTimestamp");     // Catch: Throwable -> L168
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "useForTopic");     // Catch: Throwable -> L168
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L168
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L168
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L168
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L168
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L168
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L168
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L168
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L168
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, "userEdit");     // Catch: Throwable -> L168
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "productType");     // Catch: Throwable -> L168
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "important_raw_ref_ids");     // Catch: Throwable -> L168
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "source_raw_ref_ids");     // Catch: Throwable -> L168
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, "scene_ids");     // Catch: Throwable -> L168
        int r37 = CursorUtil.getColumnIndexOrThrow(r5, "sourcePackageName");     // Catch: Throwable -> L168
        int r38 = CursorUtil.getColumnIndexOrThrow(r5, "eventName");     // Catch: Throwable -> L168
        int r39 = CursorUtil.getColumnIndexOrThrow(r5, "rawTableName");     // Catch: Throwable -> L168
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "rawDbId");     // Catch: Throwable -> L168
        int r41 = CursorUtil.getColumnIndexOrThrow(r5, "eventData");     // Catch: Throwable -> L168
        int r42 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L168
        int r43 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L168
        int r44 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L168
        int r45 = r4;
        ArrayList r46 = new ArrayList(r5.getCount());     // Catch: Throwable -> L168
    L6:
        if (r5.moveToNext() == false) goto L166;
        long r47 = r5.getLong(r0);     // Catch: Throwable -> L168
        long r49 = r5.getLong(r6);     // Catch: Throwable -> L168
        long r51 = r5.getLong(r7);     // Catch: Throwable -> L168
        if (r5.isNull(r8) == false) goto L11;
        String r53 = null;
    L13:
        if (r5.isNull(r9) == false) goto L15;
        String r54 = null;
    L17:
        if (r5.isNull(r10) == false) goto L19;
        String r55 = null;
    L21:
        if (r5.isNull(r11) == false) goto L23;
        String r56 = null;
    L25:
        if (r5.isNull(r12) == false) goto L27;
        String r57 = null;
    L29:
        if (r5.isNull(r13) == false) goto L31;
        String r58 = null;
    L33:
        if (r5.isNull(r14) == false) goto L35;
        String r59 = null;
    L37:
        if (r5.isNull(r15) == false) goto L39;
        Integer r60 = null;
    L41:
        if (r5.isNull(r2) == false) goto L43;
        Integer r61 = null;
    L45:
        if (r5.isNull(r3) == false) goto L47;
        String r62 = null;
    L49:
        if (r5.isNull(r45) == false) goto L52;
        String r63 = null;
    L51:
        int r94 = r17;
        int r110 = r0;
        if (r5.isNull(r94) == false) goto L57;
        String r64 = null;
    L56:
        int r95 = r18;
        if (r5.isNull(r95) == false) goto L61;
        Integer r48 = null;
    L62:
        if (r48 != null) goto L66;
        Boolean r65 = null;
    L64:
        int r97 = r19;
        if (r5.isNull(r97) == false) goto L73;
        Integer r410 = null;
    L74:
        if (r410 != null) goto L78;
        Boolean r66 = null;
    L76:
        int r98 = r20;
        if (r5.getInt(r98) == 0) goto L85;
        boolean r67 = true;
    L86:
        int r99 = r21;
        long r68 = r5.getLong(r99);     // Catch: Throwable -> L168
        int r50 = r22;
        long r70 = r5.getLong(r50);     // Catch: Throwable -> L168
        r22 = r50;
        r23 = r23;
        if (r5.isNull(r23) == false) goto L89;
        Integer r210 = null;
    L90:
        if (r210 != null) goto L93;
        Boolean r72 = null;
    L98:
        if (r5.isNull(r24) == false) goto L100;
        String r73 = null;
    L101:
        long r74 = r5.getLong(r25);     // Catch: Throwable -> L168
        r25 = r25;
        int r52 = r26;
        long r76 = r5.getLong(r52);     // Catch: Throwable -> L168
        r26 = r52;
        int r69 = r27;
        int r78 = r5.getInt(r69);     // Catch: Throwable -> L168
        r27 = r69;
        int r71 = r28;
        long r79 = r5.getLong(r71);     // Catch: Throwable -> L168
        r28 = r71;
        r29 = r29;
        if (r5.isNull(r29) == false) goto L104;
        String r81 = null;
    L105:
        int r82 = r5.getInt(r30);     // Catch: Throwable -> L168
        r30 = r30;
        r31 = r31;
        if (r5.isNull(r31) == false) goto L108;
        String r83 = null;
    L110:
        if (r5.isNull(r32) == false) goto L112;
        Integer r310 = null;
    L113:
        if (r310 != null) goto L116;
        Boolean r84 = null;
    L120:
        int r85 = r5.getInt(r33);     // Catch: Throwable -> L168
        r33 = r33;
        r34 = r34;
        if (r5.isNull(r34) == false) goto L123;
        String r86 = null;
    L125:
        if (r5.isNull(r35) == false) goto L127;
        String r87 = null;
    L129:
        if (r5.isNull(r36) == false) goto L131;
        String r88 = null;
    L133:
        if (r5.isNull(r37) == false) goto L135;
        String r89 = null;
    L137:
        if (r5.isNull(r38) == false) goto L139;
        String r90 = null;
    L141:
        if (r5.isNull(r39) == false) goto L143;
        String r91 = null;
    L145:
        if (r5.isNull(r40) == false) goto L147;
        Long r92 = null;
    L149:
        if (r5.isNull(r41) == false) goto L151;
        String r93 = null;
    L152:
        EpisodicMemoryEntity r75 = new EpisodicMemoryEntity(r47, r49, r51, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r70, r72, r73, r74, r76, r78, r79, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93);     // Catch: Throwable -> L168
        int r411 = r2;
        int r77 = r42;
        if (r5.isNull(r77) == false) goto L155;
        Integer r80 = null;
    L156:
        r75.setPoisonLabel(r80);     // Catch: Throwable -> L168
        r43 = r43;
        if (r5.isNull(r43) == false) goto L159;
        Integer r100 = null;
    L160:
        r75.setPoisonLabelVersion(r100);     // Catch: Throwable -> L168
        r44 = r44;
        if (r5.isNull(r44) == false) goto L163;
        String r101 = null;
    L164:
        r75.setContentHash(r101);     // Catch: Throwable -> L168
        r46.add(r75);     // Catch: Throwable -> L168
        r0 = r110;
        r17 = r94;
        r18 = r95;
        r19 = r97;
        r20 = r98;
        r21 = r99;
        r2 = r411;
        r42 = r77;
        r45 = r45;
        goto L6
    L163:
        r101 = r5.getString(r44);     // Catch: Throwable -> L168
        goto L164
    L159:
        r100 = Integer.valueOf(r5.getInt(r43));     // Catch: Throwable -> L168
        goto L160
    L155:
        r80 = Integer.valueOf(r5.getInt(r77));     // Catch: Throwable -> L168
        goto L156
    L151:
        r93 = r5.getString(r41);     // Catch: Throwable -> L168
        goto L152
    L147:
        r92 = Long.valueOf(r5.getLong(r40));     // Catch: Throwable -> L168
        goto L149
    L143:
        r91 = r5.getString(r39);     // Catch: Throwable -> L168
        goto L145
    L139:
        r90 = r5.getString(r38);     // Catch: Throwable -> L168
        goto L141
    L135:
        r89 = r5.getString(r37);     // Catch: Throwable -> L168
        goto L137
    L131:
        r88 = r5.getString(r36);     // Catch: Throwable -> L168
        goto L133
    L127:
        r87 = r5.getString(r35);     // Catch: Throwable -> L168
        goto L129
    L123:
        r86 = r5.getString(r34);     // Catch: Throwable -> L168
        goto L125
    L116:
        if (r310.intValue() == 0) goto L118;
        boolean r311 = true;
    L119:
        r84 = Boolean.valueOf(r311);     // Catch: Throwable -> L168
        goto L120
    L118:
        r311 = false;
        goto L119
    L112:
        r310 = Integer.valueOf(r5.getInt(r32));     // Catch: Throwable -> L168
        goto L113
    L108:
        r83 = r5.getString(r31);     // Catch: Throwable -> L168
        goto L110
    L104:
        r81 = r5.getString(r29);     // Catch: Throwable -> L168
        goto L105
    L100:
        r73 = r5.getString(r24);     // Catch: Throwable -> L168
        goto L101
    L93:
        if (r210.intValue() == 0) goto L95;
        boolean r211 = true;
    L96:
        r72 = Boolean.valueOf(r211);     // Catch: Throwable -> L168
        goto L98
    L95:
        r211 = false;
        goto L96
    L89:
        r210 = Integer.valueOf(r5.getInt(r23));     // Catch: Throwable -> L168
        goto L90
    L85:
        r67 = false;
        goto L86
    L78:
        if (r410.intValue() == 0) goto L80;
        boolean r412 = true;
    L81:
        r66 = Boolean.valueOf(r412);     // Catch: Throwable -> L168
        goto L76
    L80:
        r412 = false;
        goto L81
    L73:
        r410 = Integer.valueOf(r5.getInt(r97));     // Catch: Throwable -> L168
        goto L74
    L66:
        if (r48.intValue() == 0) goto L68;
        boolean r413 = true;
    L69:
        r65 = Boolean.valueOf(r413);     // Catch: Throwable -> L168
        goto L64
    L68:
        r413 = false;
        goto L69
    L61:
        r48 = Integer.valueOf(r5.getInt(r95));     // Catch: Throwable -> L168
        goto L62
    L57:
        r64 = r5.getString(r94);     // Catch: Throwable -> L168
        goto L56
    L52:
        r63 = r5.getString(r45);     // Catch: Throwable -> L168
        goto L51
    L47:
        r62 = r5.getString(r3);     // Catch: Throwable -> L168
        goto L49
    L43:
        r61 = Integer.valueOf(r5.getInt(r2));     // Catch: Throwable -> L168
        goto L45
    L39:
        r60 = Integer.valueOf(r5.getInt(r15));     // Catch: Throwable -> L168
        goto L41
    L35:
        r59 = r5.getString(r14);     // Catch: Throwable -> L168
        goto L37
    L31:
        r58 = r5.getString(r13);     // Catch: Throwable -> L168
        goto L33
    L27:
        r57 = r5.getString(r12);     // Catch: Throwable -> L168
        goto L29
    L23:
        r56 = r5.getString(r11);     // Catch: Throwable -> L168
        goto L25
    L19:
        r55 = r5.getString(r10);     // Catch: Throwable -> L168
        goto L21
    L15:
        r54 = r5.getString(r9);     // Catch: Throwable -> L168
        goto L17
    L11:
        r53 = r5.getString(r8);     // Catch: Throwable -> L168
        goto L13
    L166:
        r5.close();
        r16.release();
        return r46;
    L168:
        th = th;
    L172:
        r5.close();
        r16.release();
        throw th;
    L170:
        th = th;
        r16 = r1;
        goto L172
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<EpisodicMemoryEntity> queryByProductTypeAfterId(int r93, long r94, int r96) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ShortMemory WHERE productType = ? AND id > ? ORDER BY id ASC LIMIT ?", 3);
        r1.bindLong(1, r93);
        r1.bindLong(2, r94);
        r1.bindLong(3, r96);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L169
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "actionTimestamp");     // Catch: Throwable -> L169
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "uid");     // Catch: Throwable -> L169
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "title");     // Catch: Throwable -> L169
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, Params.CONTENT);     // Catch: Throwable -> L169
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "contentWithTime");     // Catch: Throwable -> L169
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "fullContent");     // Catch: Throwable -> L169
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "observation");     // Catch: Throwable -> L169
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "location");     // Catch: Throwable -> L169
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "appNames");     // Catch: Throwable -> L169
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L169
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "profileType");     // Catch: Throwable -> L169
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "profileTag");     // Catch: Throwable -> L169
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "tagOther");     // Catch: Throwable -> L169
        RoomSQLiteQuery r16 = r1;
        int r95 = CursorUtil.getColumnIndexOrThrow(r4, "logId");     // Catch: Throwable -> L167
        int r97 = CursorUtil.getColumnIndexOrThrow(r4, "usedForPortrait");     // Catch: Throwable -> L167
        int r98 = CursorUtil.getColumnIndexOrThrow(r4, "useLocation");     // Catch: Throwable -> L167
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "useForUserKeyword");     // Catch: Throwable -> L167
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "startTimestamp");     // Catch: Throwable -> L167
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "endTimestamp");     // Catch: Throwable -> L167
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "useForTopic");     // Catch: Throwable -> L167
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "entityId");     // Catch: Throwable -> L167
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "createTime");     // Catch: Throwable -> L167
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "modifyTime");     // Catch: Throwable -> L167
        int r24 = CursorUtil.getColumnIndexOrThrow(r4, "type");     // Catch: Throwable -> L167
        int r25 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L167
        int r26 = CursorUtil.getColumnIndexOrThrow(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L167
        int r27 = CursorUtil.getColumnIndexOrThrow(r4, "hashCodeValue");     // Catch: Throwable -> L167
        int r28 = CursorUtil.getColumnIndexOrThrow(r4, Api.KEY_UUID);     // Catch: Throwable -> L167
        int r29 = CursorUtil.getColumnIndexOrThrow(r4, "userEdit");     // Catch: Throwable -> L167
        int r30 = CursorUtil.getColumnIndexOrThrow(r4, "productType");     // Catch: Throwable -> L167
        int r31 = CursorUtil.getColumnIndexOrThrow(r4, "important_raw_ref_ids");     // Catch: Throwable -> L167
        int r32 = CursorUtil.getColumnIndexOrThrow(r4, "source_raw_ref_ids");     // Catch: Throwable -> L167
        int r33 = CursorUtil.getColumnIndexOrThrow(r4, "scene_ids");     // Catch: Throwable -> L167
        int r34 = CursorUtil.getColumnIndexOrThrow(r4, "sourcePackageName");     // Catch: Throwable -> L167
        int r35 = CursorUtil.getColumnIndexOrThrow(r4, "eventName");     // Catch: Throwable -> L167
        int r36 = CursorUtil.getColumnIndexOrThrow(r4, "rawTableName");     // Catch: Throwable -> L167
        int r37 = CursorUtil.getColumnIndexOrThrow(r4, "rawDbId");     // Catch: Throwable -> L167
        int r38 = CursorUtil.getColumnIndexOrThrow(r4, "eventData");     // Catch: Throwable -> L167
        int r39 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label");     // Catch: Throwable -> L167
        int r40 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label_version");     // Catch: Throwable -> L167
        int r41 = CursorUtil.getColumnIndexOrThrow(r4, "content_hash");     // Catch: Throwable -> L167
        int r42 = r5;
        ArrayList r43 = new ArrayList(r4.getCount());     // Catch: Throwable -> L167
    L6:
        if (r4.moveToNext() == false) goto L165;
        long r44 = r4.getLong(r0);     // Catch: Throwable -> L167
        long r46 = r4.getLong(r6);     // Catch: Throwable -> L167
        long r48 = r4.getLong(r7);     // Catch: Throwable -> L167
        if (r4.isNull(r8) == false) goto L11;
        String r50 = null;
    L13:
        if (r4.isNull(r9) == false) goto L15;
        String r51 = null;
    L17:
        if (r4.isNull(r10) == false) goto L19;
        String r52 = null;
    L21:
        if (r4.isNull(r11) == false) goto L23;
        String r53 = null;
    L25:
        if (r4.isNull(r12) == false) goto L27;
        String r54 = null;
    L29:
        if (r4.isNull(r13) == false) goto L31;
        String r55 = null;
    L33:
        if (r4.isNull(r14) == false) goto L35;
        String r56 = null;
    L37:
        if (r4.isNull(r15) == false) goto L39;
        Integer r57 = null;
    L41:
        if (r4.isNull(r2) == false) goto L43;
        Integer r58 = null;
    L45:
        if (r4.isNull(r3) == false) goto L47;
        String r59 = null;
    L49:
        if (r4.isNull(r42) == false) goto L52;
        String r60 = null;
    L51:
        int r91 = r0;
        int r45 = r95;
        if (r4.isNull(r45) == false) goto L57;
        String r61 = null;
    L56:
        r97 = r97;
        if (r4.isNull(r97) == false) goto L61;
        Integer r47 = null;
    L62:
        if (r47 != null) goto L66;
        Boolean r62 = null;
    L64:
        r98 = r98;
        if (r4.isNull(r98) == false) goto L73;
        Integer r49 = null;
    L74:
        if (r49 != null) goto L77;
        Boolean r63 = null;
    L82:
        if (r4.getInt(r17) == 0) goto L84;
        boolean r64 = true;
    L85:
        long r65 = r4.getLong(r18);     // Catch: Throwable -> L167
        r18 = r18;
        int r66 = r19;
        long r67 = r4.getLong(r66);     // Catch: Throwable -> L167
        r19 = r66;
        r20 = r20;
        if (r4.isNull(r20) == false) goto L88;
        Integer r210 = null;
    L89:
        if (r210 != null) goto L92;
        Boolean r69 = null;
    L97:
        if (r4.isNull(r21) == false) goto L99;
        String r70 = null;
    L100:
        long r71 = r4.getLong(r22);     // Catch: Throwable -> L167
        r22 = r22;
        int r68 = r23;
        long r73 = r4.getLong(r68);     // Catch: Throwable -> L167
        r23 = r68;
        int r72 = r24;
        int r75 = r4.getInt(r72);     // Catch: Throwable -> L167
        r24 = r72;
        int r74 = r25;
        long r76 = r4.getLong(r74);     // Catch: Throwable -> L167
        r25 = r74;
        r26 = r26;
        if (r4.isNull(r26) == false) goto L103;
        String r78 = null;
    L104:
        int r79 = r4.getInt(r27);     // Catch: Throwable -> L167
        r27 = r27;
        r28 = r28;
        if (r4.isNull(r28) == false) goto L107;
        String r80 = null;
    L109:
        if (r4.isNull(r29) == false) goto L111;
        Integer r211 = null;
    L112:
        if (r211 != null) goto L115;
        Boolean r81 = null;
    L119:
        int r82 = r4.getInt(r30);     // Catch: Throwable -> L167
        r30 = r30;
        r31 = r31;
        if (r4.isNull(r31) == false) goto L122;
        String r83 = null;
    L124:
        if (r4.isNull(r32) == false) goto L126;
        String r84 = null;
    L128:
        if (r4.isNull(r33) == false) goto L130;
        String r85 = null;
    L132:
        if (r4.isNull(r34) == false) goto L134;
        String r86 = null;
    L136:
        if (r4.isNull(r35) == false) goto L138;
        String r87 = null;
    L140:
        if (r4.isNull(r36) == false) goto L142;
        String r88 = null;
    L144:
        if (r4.isNull(r37) == false) goto L146;
        Long r89 = null;
    L148:
        if (r4.isNull(r38) == false) goto L150;
        String r90 = null;
    L151:
        EpisodicMemoryEntity r77 = new EpisodicMemoryEntity(r44, r46, r48, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r67, r69, r70, r71, r73, r75, r76, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90);     // Catch: Throwable -> L167
        int r410 = r2;
        int r92 = r39;
        if (r4.isNull(r92) == false) goto L154;
        Integer r99 = null;
    L155:
        r77.setPoisonLabel(r99);     // Catch: Throwable -> L167
        r40 = r40;
        if (r4.isNull(r40) == false) goto L158;
        Integer r100 = null;
    L159:
        r77.setPoisonLabelVersion(r100);     // Catch: Throwable -> L167
        r41 = r41;
        if (r4.isNull(r41) == false) goto L162;
        String r101 = null;
    L163:
        r77.setContentHash(r101);     // Catch: Throwable -> L167
        r43.add(r77);     // Catch: Throwable -> L167
        r0 = r91;
        r95 = r45;
        r2 = r410;
        r39 = r92;
        r42 = r42;
        goto L6
    L162:
        r101 = r4.getString(r41);     // Catch: Throwable -> L167
        goto L163
    L158:
        r100 = Integer.valueOf(r4.getInt(r40));     // Catch: Throwable -> L167
        goto L159
    L154:
        r99 = Integer.valueOf(r4.getInt(r92));     // Catch: Throwable -> L167
        goto L155
    L150:
        r90 = r4.getString(r38);     // Catch: Throwable -> L167
        goto L151
    L146:
        r89 = Long.valueOf(r4.getLong(r37));     // Catch: Throwable -> L167
        goto L148
    L142:
        r88 = r4.getString(r36);     // Catch: Throwable -> L167
        goto L144
    L138:
        r87 = r4.getString(r35);     // Catch: Throwable -> L167
        goto L140
    L134:
        r86 = r4.getString(r34);     // Catch: Throwable -> L167
        goto L136
    L130:
        r85 = r4.getString(r33);     // Catch: Throwable -> L167
        goto L132
    L126:
        r84 = r4.getString(r32);     // Catch: Throwable -> L167
        goto L128
    L122:
        r83 = r4.getString(r31);     // Catch: Throwable -> L167
        goto L124
    L115:
        if (r211.intValue() == 0) goto L117;
        boolean r212 = true;
    L118:
        r81 = Boolean.valueOf(r212);     // Catch: Throwable -> L167
        goto L119
    L117:
        r212 = false;
        goto L118
    L111:
        r211 = Integer.valueOf(r4.getInt(r29));     // Catch: Throwable -> L167
        goto L112
    L107:
        r80 = r4.getString(r28);     // Catch: Throwable -> L167
        goto L109
    L103:
        r78 = r4.getString(r26);     // Catch: Throwable -> L167
        goto L104
    L99:
        r70 = r4.getString(r21);     // Catch: Throwable -> L167
        goto L100
    L92:
        if (r210.intValue() == 0) goto L94;
        boolean r213 = true;
    L95:
        r69 = Boolean.valueOf(r213);     // Catch: Throwable -> L167
        goto L97
    L94:
        r213 = false;
        goto L95
    L88:
        r210 = Integer.valueOf(r4.getInt(r20));     // Catch: Throwable -> L167
        goto L89
    L84:
        r64 = false;
        goto L85
    L77:
        if (r49.intValue() == 0) goto L79;
        boolean r411 = true;
    L80:
        r63 = Boolean.valueOf(r411);     // Catch: Throwable -> L167
        goto L82
    L79:
        r411 = false;
        goto L80
    L73:
        r49 = Integer.valueOf(r4.getInt(r98));     // Catch: Throwable -> L167
        goto L74
    L66:
        if (r47.intValue() == 0) goto L68;
        boolean r412 = true;
    L69:
        r62 = Boolean.valueOf(r412);     // Catch: Throwable -> L167
        goto L64
    L68:
        r412 = false;
        goto L69
    L61:
        r47 = Integer.valueOf(r4.getInt(r97));     // Catch: Throwable -> L167
        goto L62
    L57:
        r61 = r4.getString(r45);     // Catch: Throwable -> L167
        goto L56
    L52:
        r60 = r4.getString(r42);     // Catch: Throwable -> L167
        goto L51
    L47:
        r59 = r4.getString(r3);     // Catch: Throwable -> L167
        goto L49
    L43:
        r58 = Integer.valueOf(r4.getInt(r2));     // Catch: Throwable -> L167
        goto L45
    L39:
        r57 = Integer.valueOf(r4.getInt(r15));     // Catch: Throwable -> L167
        goto L41
    L35:
        r56 = r4.getString(r14);     // Catch: Throwable -> L167
        goto L37
    L31:
        r55 = r4.getString(r13);     // Catch: Throwable -> L167
        goto L33
    L27:
        r54 = r4.getString(r12);     // Catch: Throwable -> L167
        goto L29
    L23:
        r53 = r4.getString(r11);     // Catch: Throwable -> L167
        goto L25
    L19:
        r52 = r4.getString(r10);     // Catch: Throwable -> L167
        goto L21
    L15:
        r51 = r4.getString(r9);     // Catch: Throwable -> L167
        goto L17
    L11:
        r50 = r4.getString(r8);     // Catch: Throwable -> L167
        goto L13
    L165:
        r4.close();
        r16.release();
        return r43;
    L167:
        th = th;
    L171:
        r4.close();
        r16.release();
        throw th;
    L169:
        th = th;
        r16 = r1;
        goto L171
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<EpisodicMemoryEntity> queryByTime(long r92, long r94, int r96) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM ShortMemory WHERE category = 0 AND productType IN (1001, 1005, 1006) AND modifyTime >= ? and modifyTime <= ? ORDER BY modifyTime DESC LIMIT ?", 3);
        r1.bindLong(1, r92);
        r1.bindLong(2, r94);
        r1.bindLong(3, r96);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L170
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "actionTimestamp");     // Catch: Throwable -> L170
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "uid");     // Catch: Throwable -> L170
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "title");     // Catch: Throwable -> L170
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, Params.CONTENT);     // Catch: Throwable -> L170
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "contentWithTime");     // Catch: Throwable -> L170
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "fullContent");     // Catch: Throwable -> L170
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "observation");     // Catch: Throwable -> L170
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "location");     // Catch: Throwable -> L170
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "appNames");     // Catch: Throwable -> L170
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L170
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, "profileType");     // Catch: Throwable -> L170
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "profileTag");     // Catch: Throwable -> L170
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "tagOther");     // Catch: Throwable -> L170
        RoomSQLiteQuery r16 = r1;
        int r93 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L168
        int r95 = CursorUtil.getColumnIndexOrThrow(r5, "usedForPortrait");     // Catch: Throwable -> L168
        int r97 = CursorUtil.getColumnIndexOrThrow(r5, "useLocation");     // Catch: Throwable -> L168
        int r98 = CursorUtil.getColumnIndexOrThrow(r5, "useForUserKeyword");     // Catch: Throwable -> L168
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "startTimestamp");     // Catch: Throwable -> L168
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "endTimestamp");     // Catch: Throwable -> L168
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "useForTopic");     // Catch: Throwable -> L168
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L168
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L168
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L168
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L168
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L168
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L168
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L168
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L168
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "userEdit");     // Catch: Throwable -> L168
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "productType");     // Catch: Throwable -> L168
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "important_raw_ref_ids");     // Catch: Throwable -> L168
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, "source_raw_ref_ids");     // Catch: Throwable -> L168
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, "scene_ids");     // Catch: Throwable -> L168
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "sourcePackageName");     // Catch: Throwable -> L168
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "eventName");     // Catch: Throwable -> L168
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "rawTableName");     // Catch: Throwable -> L168
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, "rawDbId");     // Catch: Throwable -> L168
        int r37 = CursorUtil.getColumnIndexOrThrow(r5, "eventData");     // Catch: Throwable -> L168
        int r38 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L168
        int r39 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L168
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L168
        int r41 = r4;
        ArrayList r42 = new ArrayList(r5.getCount());     // Catch: Throwable -> L168
    L6:
        if (r5.moveToNext() == false) goto L166;
        long r43 = r5.getLong(r0);     // Catch: Throwable -> L168
        long r45 = r5.getLong(r6);     // Catch: Throwable -> L168
        long r47 = r5.getLong(r7);     // Catch: Throwable -> L168
        if (r5.isNull(r8) == false) goto L11;
        String r49 = null;
    L13:
        if (r5.isNull(r9) == false) goto L15;
        String r50 = null;
    L17:
        if (r5.isNull(r10) == false) goto L19;
        String r51 = null;
    L21:
        if (r5.isNull(r11) == false) goto L23;
        String r52 = null;
    L25:
        if (r5.isNull(r12) == false) goto L27;
        String r53 = null;
    L29:
        if (r5.isNull(r13) == false) goto L31;
        String r54 = null;
    L33:
        if (r5.isNull(r14) == false) goto L35;
        String r55 = null;
    L37:
        if (r5.isNull(r15) == false) goto L39;
        Integer r56 = null;
    L41:
        if (r5.isNull(r2) == false) goto L43;
        Integer r57 = null;
    L45:
        if (r5.isNull(r3) == false) goto L47;
        String r58 = null;
    L49:
        if (r5.isNull(r41) == false) goto L52;
        String r59 = null;
    L51:
        int r90 = r0;
        int r44 = r93;
        if (r5.isNull(r44) == false) goto L57;
        String r60 = null;
    L56:
        r95 = r95;
        if (r5.isNull(r95) == false) goto L61;
        Integer r46 = null;
    L62:
        if (r46 != null) goto L66;
        Boolean r61 = null;
    L64:
        r97 = r97;
        if (r5.isNull(r97) == false) goto L73;
        Integer r48 = null;
    L74:
        if (r48 != null) goto L78;
        Boolean r62 = null;
    L76:
        int r63 = r98;
        int r410 = r5.getInt(r63);     // Catch: Throwable -> L168
        r98 = r63;
        int r64 = r17;
        if (r410 == 0) goto L85;
        boolean r65 = true;
    L86:
        long r66 = r5.getLong(r64);     // Catch: Throwable -> L168
        r17 = r64;
        int r67 = r18;
        long r68 = r5.getLong(r67);     // Catch: Throwable -> L168
        r18 = r67;
        r19 = r19;
        if (r5.isNull(r19) == false) goto L89;
        Integer r110 = null;
    L90:
        if (r110 != null) goto L93;
        Boolean r69 = null;
    L98:
        if (r5.isNull(r20) == false) goto L100;
        String r610 = null;
    L101:
        long r70 = r5.getLong(r21);     // Catch: Throwable -> L168
        r21 = r21;
        int r71 = r22;
        long r72 = r5.getLong(r71);     // Catch: Throwable -> L168
        r22 = r71;
        int r73 = r23;
        int r74 = r5.getInt(r73);     // Catch: Throwable -> L168
        r23 = r73;
        int r75 = r24;
        long r76 = r5.getLong(r75);     // Catch: Throwable -> L168
        r24 = r75;
        r25 = r25;
        if (r5.isNull(r25) == false) goto L104;
        String r77 = null;
    L105:
        int r78 = r5.getInt(r26);     // Catch: Throwable -> L168
        r26 = r26;
        r27 = r27;
        if (r5.isNull(r27) == false) goto L108;
        String r79 = null;
    L110:
        if (r5.isNull(r28) == false) goto L112;
        Integer r210 = null;
    L113:
        if (r210 != null) goto L116;
        Boolean r80 = null;
    L120:
        int r81 = r5.getInt(r29);     // Catch: Throwable -> L168
        r29 = r29;
        r30 = r30;
        if (r5.isNull(r30) == false) goto L123;
        String r82 = null;
    L125:
        if (r5.isNull(r31) == false) goto L127;
        String r83 = null;
    L129:
        if (r5.isNull(r32) == false) goto L131;
        String r84 = null;
    L133:
        if (r5.isNull(r33) == false) goto L135;
        String r85 = null;
    L137:
        if (r5.isNull(r34) == false) goto L139;
        String r86 = null;
    L141:
        if (r5.isNull(r35) == false) goto L143;
        String r87 = null;
    L145:
        if (r5.isNull(r36) == false) goto L147;
        Long r88 = null;
    L149:
        if (r5.isNull(r37) == false) goto L151;
        String r89 = null;
    L152:
        EpisodicMemoryEntity r91 = new EpisodicMemoryEntity(r43, r45, r47, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r65, r66, r68, r69, r610, r70, r72, r74, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89);     // Catch: Throwable -> L168
        int r411 = r2;
        int r99 = r38;
        if (r5.isNull(r99) == false) goto L155;
        Integer r100 = null;
    L156:
        r91.setPoisonLabel(r100);     // Catch: Throwable -> L168
        r39 = r39;
        if (r5.isNull(r39) == false) goto L159;
        Integer r101 = null;
    L160:
        r91.setPoisonLabelVersion(r101);     // Catch: Throwable -> L168
        r40 = r40;
        if (r5.isNull(r40) == false) goto L163;
        String r102 = null;
    L164:
        r91.setContentHash(r102);     // Catch: Throwable -> L168
        r42.add(r91);     // Catch: Throwable -> L168
        r0 = r90;
        r93 = r44;
        r2 = r411;
        r38 = r99;
        r41 = r41;
        goto L6
    L163:
        r102 = r5.getString(r40);     // Catch: Throwable -> L168
        goto L164
    L159:
        r101 = Integer.valueOf(r5.getInt(r39));     // Catch: Throwable -> L168
        goto L160
    L155:
        r100 = Integer.valueOf(r5.getInt(r99));     // Catch: Throwable -> L168
        goto L156
    L151:
        r89 = r5.getString(r37);     // Catch: Throwable -> L168
        goto L152
    L147:
        r88 = Long.valueOf(r5.getLong(r36));     // Catch: Throwable -> L168
        goto L149
    L143:
        r87 = r5.getString(r35);     // Catch: Throwable -> L168
        goto L145
    L139:
        r86 = r5.getString(r34);     // Catch: Throwable -> L168
        goto L141
    L135:
        r85 = r5.getString(r33);     // Catch: Throwable -> L168
        goto L137
    L131:
        r84 = r5.getString(r32);     // Catch: Throwable -> L168
        goto L133
    L127:
        r83 = r5.getString(r31);     // Catch: Throwable -> L168
        goto L129
    L123:
        r82 = r5.getString(r30);     // Catch: Throwable -> L168
        goto L125
    L116:
        if (r210.intValue() == 0) goto L118;
        boolean r211 = true;
    L119:
        r80 = Boolean.valueOf(r211);     // Catch: Throwable -> L168
        goto L120
    L118:
        r211 = false;
        goto L119
    L112:
        r210 = Integer.valueOf(r5.getInt(r28));     // Catch: Throwable -> L168
        goto L113
    L108:
        r79 = r5.getString(r27);     // Catch: Throwable -> L168
        goto L110
    L104:
        r77 = r5.getString(r25);     // Catch: Throwable -> L168
        goto L105
    L100:
        r610 = r5.getString(r20);     // Catch: Throwable -> L168
        goto L101
    L93:
        if (r110.intValue() == 0) goto L95;
        boolean r111 = true;
    L96:
        r69 = Boolean.valueOf(r111);     // Catch: Throwable -> L168
        goto L98
    L95:
        r111 = false;
        goto L96
    L89:
        r110 = Integer.valueOf(r5.getInt(r19));     // Catch: Throwable -> L168
        goto L90
    L85:
        r65 = false;
        goto L86
    L78:
        if (r48.intValue() == 0) goto L80;
        boolean r412 = true;
    L81:
        r62 = Boolean.valueOf(r412);     // Catch: Throwable -> L168
        goto L76
    L80:
        r412 = false;
        goto L81
    L73:
        r48 = Integer.valueOf(r5.getInt(r97));     // Catch: Throwable -> L168
        goto L74
    L66:
        if (r46.intValue() == 0) goto L68;
        boolean r413 = true;
    L69:
        r61 = Boolean.valueOf(r413);     // Catch: Throwable -> L168
        goto L64
    L68:
        r413 = false;
        goto L69
    L61:
        r46 = Integer.valueOf(r5.getInt(r95));     // Catch: Throwable -> L168
        goto L62
    L57:
        r60 = r5.getString(r44);     // Catch: Throwable -> L168
        goto L56
    L52:
        r59 = r5.getString(r41);     // Catch: Throwable -> L168
        goto L51
    L47:
        r58 = r5.getString(r3);     // Catch: Throwable -> L168
        goto L49
    L43:
        r57 = Integer.valueOf(r5.getInt(r2));     // Catch: Throwable -> L168
        goto L45
    L39:
        r56 = Integer.valueOf(r5.getInt(r15));     // Catch: Throwable -> L168
        goto L41
    L35:
        r55 = r5.getString(r14);     // Catch: Throwable -> L168
        goto L37
    L31:
        r54 = r5.getString(r13);     // Catch: Throwable -> L168
        goto L33
    L27:
        r53 = r5.getString(r12);     // Catch: Throwable -> L168
        goto L29
    L23:
        r52 = r5.getString(r11);     // Catch: Throwable -> L168
        goto L25
    L19:
        r51 = r5.getString(r10);     // Catch: Throwable -> L168
        goto L21
    L15:
        r50 = r5.getString(r9);     // Catch: Throwable -> L168
        goto L17
    L11:
        r49 = r5.getString(r8);     // Catch: Throwable -> L168
        goto L13
    L166:
        r5.close();
        r16.release();
        return r42;
    L168:
        th = th;
    L172:
        r5.close();
        r16.release();
        throw th;
    L170:
        th = th;
        r16 = r1;
        goto L172
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public EpisodicMemoryEntity queryByUUID(String r1) {
        return EpisodicMemoryDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<bt> queryCollectionMemoryReviewPage(long r93, long r95, long r97, String r99, int r100) {
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("\n        SELECT m.* FROM ShortMemory m\n        INNER JOIN ProactiveEpisodicRelevantData r ON m.entityId = r.episodic_id\n        WHERE m.productType = 1003\n            AND NULLIF(TRIM(r.source_package_name), '') IS NOT NULL\n            AND NULLIF(TRIM(r.source_app_name), '') IS NOT NULL\n            AND m.modifyTime >= ?\n            AND m.modifyTime < ?\n            AND (m.modifyTime < ? OR (m.modifyTime = ? AND m.entityId < ?))\n        ORDER BY m.modifyTime DESC, m.entityId DESC\n        LIMIT ?\n        ", 6);
        r4.bindLong(1, r93);
        r4.bindLong(2, r95);
        r4.bindLong(3, r97);
        r4.bindLong(4, r97);
        if (r99 != null) goto L5;
        r4.bindNull(5);
    L6:
        r4.bindLong(6, r100);
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor r3 = DBUtil.query(this.__db, r4, true, null);     // Catch: Throwable -> L194
        int r0 = CursorUtil.getColumnIndexOrThrow(r3, OaidModel.KEY_ID);     // Catch: Throwable -> L190
        int r5 = CursorUtil.getColumnIndexOrThrow(r3, "actionTimestamp");     // Catch: Throwable -> L190
        int r7 = CursorUtil.getColumnIndexOrThrow(r3, "uid");     // Catch: Throwable -> L190
        int r8 = CursorUtil.getColumnIndexOrThrow(r3, "title");     // Catch: Throwable -> L190
        int r9 = CursorUtil.getColumnIndexOrThrow(r3, Params.CONTENT);     // Catch: Throwable -> L190
        int r10 = CursorUtil.getColumnIndexOrThrow(r3, "contentWithTime");     // Catch: Throwable -> L190
        int r11 = CursorUtil.getColumnIndexOrThrow(r3, "fullContent");     // Catch: Throwable -> L190
        int r12 = CursorUtil.getColumnIndexOrThrow(r3, "observation");     // Catch: Throwable -> L190
        int r13 = CursorUtil.getColumnIndexOrThrow(r3, "location");     // Catch: Throwable -> L190
        int r14 = CursorUtil.getColumnIndexOrThrow(r3, "appNames");     // Catch: Throwable -> L190
        int r15 = CursorUtil.getColumnIndexOrThrow(r3, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L190
        int r2 = CursorUtil.getColumnIndexOrThrow(r3, "profileType");     // Catch: Throwable -> L190
        int r6 = CursorUtil.getColumnIndexOrThrow(r3, "profileTag");     // Catch: Throwable -> L190
        RoomSQLiteQuery r16 = r4;
        int r94 = CursorUtil.getColumnIndexOrThrow(r3, "tagOther");     // Catch: Throwable -> L188
        int r96 = CursorUtil.getColumnIndexOrThrow(r3, "logId");     // Catch: Throwable -> L188
        int r98 = CursorUtil.getColumnIndexOrThrow(r3, "usedForPortrait");     // Catch: Throwable -> L188
        int r910 = CursorUtil.getColumnIndexOrThrow(r3, "useLocation");     // Catch: Throwable -> L188
        int r911 = CursorUtil.getColumnIndexOrThrow(r3, "useForUserKeyword");     // Catch: Throwable -> L188
        int r912 = CursorUtil.getColumnIndexOrThrow(r3, "startTimestamp");     // Catch: Throwable -> L188
        int r101 = CursorUtil.getColumnIndexOrThrow(r3, "endTimestamp");     // Catch: Throwable -> L188
        int r17 = CursorUtil.getColumnIndexOrThrow(r3, "useForTopic");     // Catch: Throwable -> L188
        int r18 = CursorUtil.getColumnIndexOrThrow(r3, "entityId");     // Catch: Throwable -> L188
        int r19 = r6;
        int r110 = CursorUtil.getColumnIndexOrThrow(r3, "createTime");     // Catch: Throwable -> L188
        int r20 = CursorUtil.getColumnIndexOrThrow(r3, "modifyTime");     // Catch: Throwable -> L188
        int r21 = CursorUtil.getColumnIndexOrThrow(r3, "type");     // Catch: Throwable -> L188
        int r22 = CursorUtil.getColumnIndexOrThrow(r3, "timestamp");     // Catch: Throwable -> L188
        int r23 = CursorUtil.getColumnIndexOrThrow(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L188
        int r24 = CursorUtil.getColumnIndexOrThrow(r3, "hashCodeValue");     // Catch: Throwable -> L188
        int r25 = CursorUtil.getColumnIndexOrThrow(r3, Api.KEY_UUID);     // Catch: Throwable -> L188
        int r26 = CursorUtil.getColumnIndexOrThrow(r3, "userEdit");     // Catch: Throwable -> L188
        int r27 = CursorUtil.getColumnIndexOrThrow(r3, "productType");     // Catch: Throwable -> L188
        int r28 = CursorUtil.getColumnIndexOrThrow(r3, "important_raw_ref_ids");     // Catch: Throwable -> L188
        int r29 = CursorUtil.getColumnIndexOrThrow(r3, "source_raw_ref_ids");     // Catch: Throwable -> L188
        int r30 = CursorUtil.getColumnIndexOrThrow(r3, "scene_ids");     // Catch: Throwable -> L188
        int r31 = CursorUtil.getColumnIndexOrThrow(r3, "sourcePackageName");     // Catch: Throwable -> L188
        int r32 = CursorUtil.getColumnIndexOrThrow(r3, "eventName");     // Catch: Throwable -> L188
        int r33 = CursorUtil.getColumnIndexOrThrow(r3, "rawTableName");     // Catch: Throwable -> L188
        int r34 = CursorUtil.getColumnIndexOrThrow(r3, "rawDbId");     // Catch: Throwable -> L188
        int r35 = CursorUtil.getColumnIndexOrThrow(r3, "eventData");     // Catch: Throwable -> L188
        int r36 = CursorUtil.getColumnIndexOrThrow(r3, "poison_label");     // Catch: Throwable -> L188
        int r37 = CursorUtil.getColumnIndexOrThrow(r3, "poison_label_version");     // Catch: Throwable -> L188
        int r38 = CursorUtil.getColumnIndexOrThrow(r3, "content_hash");     // Catch: Throwable -> L188
        ArrayMap<String, ArrayList<es>> r39 = new ArrayMap();     // Catch: Throwable -> L188
    L12:
        int r40 = r2;
        if (r3.moveToNext() == false) goto L19;
        int r310 = r15;
        String r111 = r3.getString(r18);     // Catch: Throwable -> L188
        int r41 = r18;
        int r42 = r14;
        if (((ArrayList) ZeusTransformUtils.preCheckCast(r39.get(r111), ArrayList.class, "com.obric.memorydata.plugin")) != null) goto L18;
        r39.put(r111, new ArrayList());     // Catch: Throwable -> L188
    L18:
        r15 = r310;
        r2 = r40;
        r18 = r41;
        r14 = r42;
        goto L12
    L19:
        int r43 = r18;
        int r44 = r14;
        int r311 = r15;
        r3.moveToPosition(-1);     // Catch: Throwable -> L188
        __fetchRelationshipProactiveEpisodicRelevantDataAscomObricMemorydataDatabaseEntityProactiveEpisodicRelevantData(r39);     // Catch: Throwable -> L188
        ArrayList r45 = new ArrayList(r3.getCount());     // Catch: Throwable -> L188
    L21:
        if (r3.moveToNext() == false) goto L184;
        long r46 = r3.getLong(r0);     // Catch: Throwable -> L188
        long r47 = r3.getLong(r5);     // Catch: Throwable -> L188
        long r48 = r3.getLong(r7);     // Catch: Throwable -> L188
        if (r3.isNull(r8) == false) goto L25;
        String r50 = null;
    L27:
        if (r3.isNull(r9) == false) goto L29;
        String r51 = null;
    L31:
        if (r3.isNull(r10) == false) goto L33;
        String r52 = null;
    L35:
        if (r3.isNull(r11) == false) goto L37;
        String r53 = null;
    L39:
        if (r3.isNull(r12) == false) goto L41;
        String r54 = null;
    L43:
        if (r3.isNull(r13) == false) goto L45;
        String r55 = null;
    L47:
        if (r3.isNull(r44) == false) goto L49;
        String r56 = null;
    L51:
        if (r3.isNull(r311) == false) goto L53;
        Integer r57 = null;
    L55:
        if (r3.isNull(r40) == false) goto L57;
        Integer r58 = null;
    L59:
        if (r3.isNull(r19) == false) goto L62;
        String r59 = null;
    L61:
        r94 = r94;
        if (r3.isNull(r94) == false) goto L67;
        String r60 = null;
    L66:
        r96 = r96;
        if (r3.isNull(r96) == false) goto L72;
        String r61 = null;
    L71:
        r98 = r98;
        if (r3.isNull(r98) == false) goto L76;
        Integer r49 = null;
    L77:
        boolean r410 = false;
        if (r49 != null) goto L82;
        Boolean r62 = null;
    L80:
        r910 = r910;
        if (r3.isNull(r910) == false) goto L89;
        Integer r411 = null;
    L90:
        if (r411 != null) goto L94;
        Boolean r63 = null;
    L92:
        int r1 = r911;
        r911 = r1;
        if (r3.getInt(r1) == 0) goto L101;
        boolean r64 = true;
    L102:
        int r65 = r912;
        long r66 = r3.getLong(r65);     // Catch: Throwable -> L188
        r912 = r65;
        int r67 = r101;
        long r68 = r3.getLong(r67);     // Catch: Throwable -> L188
        r101 = r67;
        r17 = r17;
        if (r3.isNull(r17) == false) goto L105;
        Integer r112 = null;
    L106:
        if (r112 != null) goto L109;
        Boolean r69 = null;
    L114:
        if (r3.isNull(r43) == false) goto L117;
        String r70 = null;
    L116:
        int r91 = r110;
        int r113 = r5;
        long r71 = r3.getLong(r91);     // Catch: Throwable -> L188
        int r72 = r20;
        long r73 = r3.getLong(r72);     // Catch: Throwable -> L188
        r20 = r72;
        int r74 = r21;
        int r75 = r3.getInt(r74);     // Catch: Throwable -> L188
        r21 = r74;
        int r76 = r22;
        long r77 = r3.getLong(r76);     // Catch: Throwable -> L188
        r22 = r76;
        r23 = r23;
        if (r3.isNull(r23) == false) goto L121;
        String r78 = null;
    L122:
        int r79 = r3.getInt(r24);     // Catch: Throwable -> L188
        r24 = r24;
        r25 = r25;
        if (r3.isNull(r25) == false) goto L125;
        String r80 = null;
    L127:
        if (r3.isNull(r26) == false) goto L129;
        Integer r210 = null;
    L130:
        if (r210 != null) goto L133;
        Boolean r81 = null;
    L136:
        int r82 = r3.getInt(r27);     // Catch: Throwable -> L188
        r27 = r27;
        r28 = r28;
        if (r3.isNull(r28) == false) goto L139;
        String r83 = null;
    L141:
        if (r3.isNull(r29) == false) goto L143;
        String r84 = null;
    L145:
        if (r3.isNull(r30) == false) goto L147;
        String r85 = null;
    L149:
        if (r3.isNull(r31) == false) goto L151;
        String r86 = null;
    L153:
        if (r3.isNull(r32) == false) goto L155;
        String r87 = null;
    L157:
        if (r3.isNull(r33) == false) goto L159;
        String r88 = null;
    L161:
        if (r3.isNull(r34) == false) goto L163;
        Long r89 = null;
    L165:
        if (r3.isNull(r35) == false) goto L167;
        String r90 = null;
    L168:
        EpisodicMemoryEntity r92 = new EpisodicMemoryEntity(r46, r47, r48, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r66, r68, r69, r70, r71, r73, r75, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90);     // Catch: Throwable -> L188
        int r412 = r7;
        int r102 = r36;
        if (r3.isNull(r102) == false) goto L171;
        Integer r103 = null;
    L172:
        r92.setPoisonLabel(r103);     // Catch: Throwable -> L188
        r37 = r37;
        if (r3.isNull(r37) == false) goto L175;
        Integer r104 = null;
    L176:
        r92.setPoisonLabelVersion(r104);     // Catch: Throwable -> L188
        r38 = r38;
        if (r3.isNull(r38) == false) goto L179;
        String r105 = null;
    L180:
        r92.setContentHash(r105);     // Catch: Throwable -> L188
        int r312 = r43;
        ArrayList r106 = (ArrayList) ZeusTransformUtils.preCheckCast(r39.get(r3.getString(r43)), ArrayList.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L188
        if (r106 != null) goto L183;
        r106 = new ArrayList();     // Catch: Throwable -> L188
    L183:
        r45.add(new bt(r92, r106));     // Catch: Throwable -> L188
        r5 = r113;
        r0 = r0;
        r110 = r91;
        r7 = r412;
        r44 = r44;
        r311 = r311;
        r43 = r312;
        r36 = r102;
        goto L21
    L179:
        r105 = r3.getString(r38);     // Catch: Throwable -> L188
        goto L180
    L175:
        r104 = Integer.valueOf(r3.getInt(r37));     // Catch: Throwable -> L188
        goto L176
    L171:
        r103 = Integer.valueOf(r3.getInt(r102));     // Catch: Throwable -> L188
        goto L172
    L167:
        r90 = r3.getString(r35);     // Catch: Throwable -> L188
        goto L168
    L163:
        r89 = Long.valueOf(r3.getLong(r34));     // Catch: Throwable -> L188
        goto L165
    L159:
        r88 = r3.getString(r33);     // Catch: Throwable -> L188
        goto L161
    L155:
        r87 = r3.getString(r32);     // Catch: Throwable -> L188
        goto L157
    L151:
        r86 = r3.getString(r31);     // Catch: Throwable -> L188
        goto L153
    L147:
        r85 = r3.getString(r30);     // Catch: Throwable -> L188
        goto L149
    L143:
        r84 = r3.getString(r29);     // Catch: Throwable -> L188
        goto L145
    L139:
        r83 = r3.getString(r28);     // Catch: Throwable -> L188
        goto L141
    L133:
        if (r210.intValue() == 0) goto L135;
        r410 = true;
    L135:
        r81 = Boolean.valueOf(r410);     // Catch: Throwable -> L188
        goto L136
    L129:
        r210 = Integer.valueOf(r3.getInt(r26));     // Catch: Throwable -> L188
        goto L130
    L125:
        r80 = r3.getString(r25);     // Catch: Throwable -> L188
        goto L127
    L121:
        r78 = r3.getString(r23);     // Catch: Throwable -> L188
        goto L122
    L117:
        r70 = r3.getString(r43);     // Catch: Throwable -> L188
        goto L116
    L109:
        if (r112.intValue() == 0) goto L111;
        boolean r114 = true;
    L112:
        r69 = Boolean.valueOf(r114);     // Catch: Throwable -> L188
        goto L114
    L111:
        r114 = false;
        goto L112
    L105:
        r112 = Integer.valueOf(r3.getInt(r17));     // Catch: Throwable -> L188
        goto L106
    L101:
        r64 = false;
        goto L102
    L94:
        if (r411.intValue() == 0) goto L96;
        boolean r413 = true;
    L97:
        r63 = Boolean.valueOf(r413);     // Catch: Throwable -> L188
        goto L92
    L96:
        r413 = false;
        goto L97
    L89:
        r411 = Integer.valueOf(r3.getInt(r910));     // Catch: Throwable -> L188
        goto L90
    L82:
        if (r49.intValue() == 0) goto L84;
        boolean r414 = true;
    L85:
        r62 = Boolean.valueOf(r414);     // Catch: Throwable -> L188
        goto L80
    L84:
        r414 = false;
        goto L85
    L76:
        r49 = Integer.valueOf(r3.getInt(r98));     // Catch: Throwable -> L188
        goto L77
    L72:
        r61 = r3.getString(r96);     // Catch: Throwable -> L188
        goto L71
    L67:
        r60 = r3.getString(r94);     // Catch: Throwable -> L188
        goto L66
    L62:
        r59 = r3.getString(r19);     // Catch: Throwable -> L188
        goto L61
    L57:
        r58 = Integer.valueOf(r3.getInt(r40));     // Catch: Throwable -> L188
        goto L59
    L53:
        r57 = Integer.valueOf(r3.getInt(r311));     // Catch: Throwable -> L188
        goto L55
    L49:
        r56 = r3.getString(r44);     // Catch: Throwable -> L188
        goto L51
    L45:
        r55 = r3.getString(r13);     // Catch: Throwable -> L188
        goto L47
    L41:
        r54 = r3.getString(r12);     // Catch: Throwable -> L188
        goto L43
    L37:
        r53 = r3.getString(r11);     // Catch: Throwable -> L188
        goto L39
    L33:
        r52 = r3.getString(r10);     // Catch: Throwable -> L188
        goto L35
    L29:
        r51 = r3.getString(r9);     // Catch: Throwable -> L188
        goto L31
    L25:
        r50 = r3.getString(r8);     // Catch: Throwable -> L188
        goto L27
    L184:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L188
        r3.close();     // Catch: Throwable -> L194
        r16.release();     // Catch: Throwable -> L194
        this.__db.endTransaction();
        return r45;
    L188:
        th = th;
    L192:
        r3.close();     // Catch: Throwable -> L194
        r16.release();     // Catch: Throwable -> L194
        throw th;     // Catch: Throwable -> L194
    L190:
        th = th;
        r16 = r4;
    L194:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L5:
        r4.bindString(5, r99);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<EpisodicMemoryEntity> queryContextAwarenessScreenPage(long r88, long r90, long r92, String r94, int r95, int r96) {
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("\n        SELECT * FROM ShortMemory\n        WHERE category = 0\n            AND productType IN (1001, 1005, 1006)\n            AND startTimestamp >= ?\n            AND startTimestamp < ?\n            AND (\n                startTimestamp < ?\n                OR (\n                    startTimestamp = ?\n                    AND (? = 1 OR entityId < ?)\n                )\n            )\n        ORDER BY startTimestamp DESC, entityId DESC\n        LIMIT ?\n        ", 7);
        r4.bindLong(1, r88);
        r4.bindLong(2, r90);
        r4.bindLong(3, r92);
        r4.bindLong(4, r92);
        r4.bindLong(5, r95);
        if (r94 != null) goto L5;
        r4.bindNull(6);
    L6:
        r4.bindLong(7, r96);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r4, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r3, OaidModel.KEY_ID);     // Catch: Throwable -> L175
        int r5 = CursorUtil.getColumnIndexOrThrow(r3, "actionTimestamp");     // Catch: Throwable -> L175
        int r7 = CursorUtil.getColumnIndexOrThrow(r3, "uid");     // Catch: Throwable -> L175
        int r8 = CursorUtil.getColumnIndexOrThrow(r3, "title");     // Catch: Throwable -> L175
        int r9 = CursorUtil.getColumnIndexOrThrow(r3, Params.CONTENT);     // Catch: Throwable -> L175
        int r10 = CursorUtil.getColumnIndexOrThrow(r3, "contentWithTime");     // Catch: Throwable -> L175
        int r11 = CursorUtil.getColumnIndexOrThrow(r3, "fullContent");     // Catch: Throwable -> L175
        int r12 = CursorUtil.getColumnIndexOrThrow(r3, "observation");     // Catch: Throwable -> L175
        int r13 = CursorUtil.getColumnIndexOrThrow(r3, "location");     // Catch: Throwable -> L175
        int r14 = CursorUtil.getColumnIndexOrThrow(r3, "appNames");     // Catch: Throwable -> L175
        int r15 = CursorUtil.getColumnIndexOrThrow(r3, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L175
        int r1 = CursorUtil.getColumnIndexOrThrow(r3, "profileType");     // Catch: Throwable -> L175
        int r2 = CursorUtil.getColumnIndexOrThrow(r3, "profileTag");     // Catch: Throwable -> L175
        int r6 = CursorUtil.getColumnIndexOrThrow(r3, "tagOther");     // Catch: Throwable -> L175
        RoomSQLiteQuery r16 = r4;
        int r89 = CursorUtil.getColumnIndexOrThrow(r3, "logId");     // Catch: Throwable -> L173
        int r91 = CursorUtil.getColumnIndexOrThrow(r3, "usedForPortrait");     // Catch: Throwable -> L173
        int r93 = CursorUtil.getColumnIndexOrThrow(r3, "useLocation");     // Catch: Throwable -> L173
        int r97 = CursorUtil.getColumnIndexOrThrow(r3, "useForUserKeyword");     // Catch: Throwable -> L173
        int r98 = CursorUtil.getColumnIndexOrThrow(r3, "startTimestamp");     // Catch: Throwable -> L173
        int r99 = CursorUtil.getColumnIndexOrThrow(r3, "endTimestamp");     // Catch: Throwable -> L173
        int r910 = CursorUtil.getColumnIndexOrThrow(r3, "useForTopic");     // Catch: Throwable -> L173
        int r911 = CursorUtil.getColumnIndexOrThrow(r3, "entityId");     // Catch: Throwable -> L173
        int r17 = CursorUtil.getColumnIndexOrThrow(r3, "createTime");     // Catch: Throwable -> L173
        int r18 = CursorUtil.getColumnIndexOrThrow(r3, "modifyTime");     // Catch: Throwable -> L173
        int r19 = CursorUtil.getColumnIndexOrThrow(r3, "type");     // Catch: Throwable -> L173
        int r20 = CursorUtil.getColumnIndexOrThrow(r3, "timestamp");     // Catch: Throwable -> L173
        int r21 = CursorUtil.getColumnIndexOrThrow(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L173
        int r22 = CursorUtil.getColumnIndexOrThrow(r3, "hashCodeValue");     // Catch: Throwable -> L173
        int r23 = CursorUtil.getColumnIndexOrThrow(r3, Api.KEY_UUID);     // Catch: Throwable -> L173
        int r24 = CursorUtil.getColumnIndexOrThrow(r3, "userEdit");     // Catch: Throwable -> L173
        int r25 = CursorUtil.getColumnIndexOrThrow(r3, "productType");     // Catch: Throwable -> L173
        int r26 = CursorUtil.getColumnIndexOrThrow(r3, "important_raw_ref_ids");     // Catch: Throwable -> L173
        int r27 = CursorUtil.getColumnIndexOrThrow(r3, "source_raw_ref_ids");     // Catch: Throwable -> L173
        int r28 = CursorUtil.getColumnIndexOrThrow(r3, "scene_ids");     // Catch: Throwable -> L173
        int r29 = CursorUtil.getColumnIndexOrThrow(r3, "sourcePackageName");     // Catch: Throwable -> L173
        int r30 = CursorUtil.getColumnIndexOrThrow(r3, "eventName");     // Catch: Throwable -> L173
        int r31 = CursorUtil.getColumnIndexOrThrow(r3, "rawTableName");     // Catch: Throwable -> L173
        int r32 = CursorUtil.getColumnIndexOrThrow(r3, "rawDbId");     // Catch: Throwable -> L173
        int r33 = CursorUtil.getColumnIndexOrThrow(r3, "eventData");     // Catch: Throwable -> L173
        int r34 = CursorUtil.getColumnIndexOrThrow(r3, "poison_label");     // Catch: Throwable -> L173
        int r35 = CursorUtil.getColumnIndexOrThrow(r3, "poison_label_version");     // Catch: Throwable -> L173
        int r36 = CursorUtil.getColumnIndexOrThrow(r3, "content_hash");     // Catch: Throwable -> L173
        int r37 = r6;
        ArrayList r38 = new ArrayList(r3.getCount());     // Catch: Throwable -> L173
    L10:
        if (r3.moveToNext() == false) goto L171;
        long r39 = r3.getLong(r0);     // Catch: Throwable -> L173
        long r41 = r3.getLong(r5);     // Catch: Throwable -> L173
        long r43 = r3.getLong(r7);     // Catch: Throwable -> L173
        if (r3.isNull(r8) == false) goto L15;
        String r45 = null;
    L17:
        if (r3.isNull(r9) == false) goto L19;
        String r46 = null;
    L21:
        if (r3.isNull(r10) == false) goto L23;
        String r47 = null;
    L25:
        if (r3.isNull(r11) == false) goto L27;
        String r48 = null;
    L29:
        if (r3.isNull(r12) == false) goto L31;
        String r49 = null;
    L33:
        if (r3.isNull(r13) == false) goto L35;
        String r50 = null;
    L37:
        if (r3.isNull(r14) == false) goto L39;
        String r51 = null;
    L41:
        if (r3.isNull(r15) == false) goto L43;
        Integer r52 = null;
    L45:
        if (r3.isNull(r1) == false) goto L47;
        Integer r53 = null;
    L49:
        if (r3.isNull(r2) == false) goto L51;
        String r54 = null;
    L53:
        if (r3.isNull(r37) == false) goto L56;
        String r55 = null;
    L55:
        int r86 = r0;
        int r40 = r89;
        if (r3.isNull(r40) == false) goto L61;
        String r56 = null;
    L60:
        r91 = r91;
        if (r3.isNull(r91) == false) goto L65;
        Integer r310 = null;
    L66:
        if (r310 != null) goto L70;
        Boolean r57 = null;
    L68:
        r93 = r93;
        if (r3.isNull(r93) == false) goto L77;
        Integer r311 = null;
    L78:
        if (r311 != null) goto L82;
        Boolean r58 = null;
    L80:
        int r42 = r97;
        r97 = r42;
        if (r3.getInt(r42) == 0) goto L89;
        boolean r59 = true;
    L90:
        int r44 = r98;
        long r60 = r3.getLong(r44);     // Catch: Throwable -> L173
        r98 = r44;
        int r61 = r99;
        long r62 = r3.getLong(r61);     // Catch: Throwable -> L173
        r99 = r61;
        r910 = r910;
        if (r3.isNull(r910) == false) goto L93;
        Integer r312 = null;
    L94:
        if (r312 != null) goto L98;
        Boolean r64 = null;
    L96:
        r911 = r911;
        if (r3.isNull(r911) == false) goto L105;
        String r65 = null;
    L106:
        long r66 = r3.getLong(r17);     // Catch: Throwable -> L173
        r17 = r17;
        int r63 = r18;
        long r68 = r3.getLong(r63);     // Catch: Throwable -> L173
        r18 = r63;
        int r67 = r19;
        int r70 = r3.getInt(r67);     // Catch: Throwable -> L173
        r19 = r67;
        int r69 = r20;
        long r71 = r3.getLong(r69);     // Catch: Throwable -> L173
        r20 = r69;
        r21 = r21;
        if (r3.isNull(r21) == false) goto L109;
        String r73 = null;
    L110:
        int r74 = r3.getInt(r22);     // Catch: Throwable -> L173
        r22 = r22;
        r23 = r23;
        if (r3.isNull(r23) == false) goto L113;
        String r75 = null;
    L115:
        if (r3.isNull(r24) == false) goto L117;
        Integer r210 = null;
    L118:
        if (r210 != null) goto L121;
        Boolean r76 = null;
    L125:
        int r77 = r3.getInt(r25);     // Catch: Throwable -> L173
        r25 = r25;
        r26 = r26;
        if (r3.isNull(r26) == false) goto L128;
        String r78 = null;
    L130:
        if (r3.isNull(r27) == false) goto L132;
        String r79 = null;
    L134:
        if (r3.isNull(r28) == false) goto L136;
        String r80 = null;
    L138:
        if (r3.isNull(r29) == false) goto L140;
        String r81 = null;
    L142:
        if (r3.isNull(r30) == false) goto L144;
        String r82 = null;
    L146:
        if (r3.isNull(r31) == false) goto L148;
        String r83 = null;
    L150:
        if (r3.isNull(r32) == false) goto L152;
        Long r84 = null;
    L154:
        if (r3.isNull(r33) == false) goto L156;
        String r85 = null;
    L157:
        EpisodicMemoryEntity r72 = new EpisodicMemoryEntity(r39, r41, r43, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r62, r64, r65, r66, r68, r70, r71, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85);     // Catch: Throwable -> L173
        int r313 = r1;
        int r87 = r34;
        if (r3.isNull(r87) == false) goto L160;
        Integer r100 = null;
    L161:
        r72.setPoisonLabel(r100);     // Catch: Throwable -> L173
        r35 = r35;
        if (r3.isNull(r35) == false) goto L164;
        Integer r101 = null;
    L165:
        r72.setPoisonLabelVersion(r101);     // Catch: Throwable -> L173
        r36 = r36;
        if (r3.isNull(r36) == false) goto L168;
        String r102 = null;
    L169:
        r72.setContentHash(r102);     // Catch: Throwable -> L173
        r38.add(r72);     // Catch: Throwable -> L173
        r0 = r86;
        r89 = r40;
        r1 = r313;
        r34 = r87;
        r37 = r37;
        goto L10
    L168:
        r102 = r3.getString(r36);     // Catch: Throwable -> L173
        goto L169
    L164:
        r101 = Integer.valueOf(r3.getInt(r35));     // Catch: Throwable -> L173
        goto L165
    L160:
        r100 = Integer.valueOf(r3.getInt(r87));     // Catch: Throwable -> L173
        goto L161
    L156:
        r85 = r3.getString(r33);     // Catch: Throwable -> L173
        goto L157
    L152:
        r84 = Long.valueOf(r3.getLong(r32));     // Catch: Throwable -> L173
        goto L154
    L148:
        r83 = r3.getString(r31);     // Catch: Throwable -> L173
        goto L150
    L144:
        r82 = r3.getString(r30);     // Catch: Throwable -> L173
        goto L146
    L140:
        r81 = r3.getString(r29);     // Catch: Throwable -> L173
        goto L142
    L136:
        r80 = r3.getString(r28);     // Catch: Throwable -> L173
        goto L138
    L132:
        r79 = r3.getString(r27);     // Catch: Throwable -> L173
        goto L134
    L128:
        r78 = r3.getString(r26);     // Catch: Throwable -> L173
        goto L130
    L121:
        if (r210.intValue() == 0) goto L123;
        boolean r211 = true;
    L124:
        r76 = Boolean.valueOf(r211);     // Catch: Throwable -> L173
        goto L125
    L123:
        r211 = false;
        goto L124
    L117:
        r210 = Integer.valueOf(r3.getInt(r24));     // Catch: Throwable -> L173
        goto L118
    L113:
        r75 = r3.getString(r23);     // Catch: Throwable -> L173
        goto L115
    L109:
        r73 = r3.getString(r21);     // Catch: Throwable -> L173
        goto L110
    L105:
        r65 = r3.getString(r911);     // Catch: Throwable -> L173
        goto L106
    L98:
        if (r312.intValue() == 0) goto L100;
        boolean r314 = true;
    L101:
        r64 = Boolean.valueOf(r314);     // Catch: Throwable -> L173
        goto L96
    L100:
        r314 = false;
        goto L101
    L93:
        r312 = Integer.valueOf(r3.getInt(r910));     // Catch: Throwable -> L173
        goto L94
    L89:
        r59 = false;
        goto L90
    L82:
        if (r311.intValue() == 0) goto L84;
        boolean r315 = true;
    L85:
        r58 = Boolean.valueOf(r315);     // Catch: Throwable -> L173
        goto L80
    L84:
        r315 = false;
        goto L85
    L77:
        r311 = Integer.valueOf(r3.getInt(r93));     // Catch: Throwable -> L173
        goto L78
    L70:
        if (r310.intValue() == 0) goto L72;
        boolean r316 = true;
    L73:
        r57 = Boolean.valueOf(r316);     // Catch: Throwable -> L173
        goto L68
    L72:
        r316 = false;
        goto L73
    L65:
        r310 = Integer.valueOf(r3.getInt(r91));     // Catch: Throwable -> L173
        goto L66
    L61:
        r56 = r3.getString(r40);     // Catch: Throwable -> L173
        goto L60
    L56:
        r55 = r3.getString(r37);     // Catch: Throwable -> L173
        goto L55
    L51:
        r54 = r3.getString(r2);     // Catch: Throwable -> L173
        goto L53
    L47:
        r53 = Integer.valueOf(r3.getInt(r1));     // Catch: Throwable -> L173
        goto L49
    L43:
        r52 = Integer.valueOf(r3.getInt(r15));     // Catch: Throwable -> L173
        goto L45
    L39:
        r51 = r3.getString(r14);     // Catch: Throwable -> L173
        goto L41
    L35:
        r50 = r3.getString(r13);     // Catch: Throwable -> L173
        goto L37
    L31:
        r49 = r3.getString(r12);     // Catch: Throwable -> L173
        goto L33
    L27:
        r48 = r3.getString(r11);     // Catch: Throwable -> L173
        goto L29
    L23:
        r47 = r3.getString(r10);     // Catch: Throwable -> L173
        goto L25
    L19:
        r46 = r3.getString(r9);     // Catch: Throwable -> L173
        goto L21
    L15:
        r45 = r3.getString(r8);     // Catch: Throwable -> L173
        goto L17
    L171:
        r3.close();
        r16.release();
        return r38;
    L173:
        th = th;
    L177:
        r3.close();
        r16.release();
        throw th;
    L175:
        th = th;
        r16 = r4;
        goto L177
    L5:
        r4.bindString(6, r94);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<EpisodicMemoryEntity> queryContextAwarenessScreenPageBefore(long r88, long r90, long r92, String r94, int r95, int r96) {
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("\n        SELECT * FROM ShortMemory\n        WHERE category = 0\n            AND productType IN (1001, 1005, 1006)\n            AND startTimestamp >= ?\n            AND startTimestamp < ?\n            AND (\n                startTimestamp > ?\n                OR (\n                    startTimestamp = ?\n                    AND (? = 1 OR entityId > ?)\n                )\n            )\n        ORDER BY startTimestamp ASC, entityId ASC\n        LIMIT ?\n        ", 7);
        r4.bindLong(1, r88);
        r4.bindLong(2, r90);
        r4.bindLong(3, r92);
        r4.bindLong(4, r92);
        r4.bindLong(5, r95);
        if (r94 != null) goto L5;
        r4.bindNull(6);
    L6:
        r4.bindLong(7, r96);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r4, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r3, OaidModel.KEY_ID);     // Catch: Throwable -> L175
        int r5 = CursorUtil.getColumnIndexOrThrow(r3, "actionTimestamp");     // Catch: Throwable -> L175
        int r7 = CursorUtil.getColumnIndexOrThrow(r3, "uid");     // Catch: Throwable -> L175
        int r8 = CursorUtil.getColumnIndexOrThrow(r3, "title");     // Catch: Throwable -> L175
        int r9 = CursorUtil.getColumnIndexOrThrow(r3, Params.CONTENT);     // Catch: Throwable -> L175
        int r10 = CursorUtil.getColumnIndexOrThrow(r3, "contentWithTime");     // Catch: Throwable -> L175
        int r11 = CursorUtil.getColumnIndexOrThrow(r3, "fullContent");     // Catch: Throwable -> L175
        int r12 = CursorUtil.getColumnIndexOrThrow(r3, "observation");     // Catch: Throwable -> L175
        int r13 = CursorUtil.getColumnIndexOrThrow(r3, "location");     // Catch: Throwable -> L175
        int r14 = CursorUtil.getColumnIndexOrThrow(r3, "appNames");     // Catch: Throwable -> L175
        int r15 = CursorUtil.getColumnIndexOrThrow(r3, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L175
        int r1 = CursorUtil.getColumnIndexOrThrow(r3, "profileType");     // Catch: Throwable -> L175
        int r2 = CursorUtil.getColumnIndexOrThrow(r3, "profileTag");     // Catch: Throwable -> L175
        int r6 = CursorUtil.getColumnIndexOrThrow(r3, "tagOther");     // Catch: Throwable -> L175
        RoomSQLiteQuery r16 = r4;
        int r89 = CursorUtil.getColumnIndexOrThrow(r3, "logId");     // Catch: Throwable -> L173
        int r91 = CursorUtil.getColumnIndexOrThrow(r3, "usedForPortrait");     // Catch: Throwable -> L173
        int r93 = CursorUtil.getColumnIndexOrThrow(r3, "useLocation");     // Catch: Throwable -> L173
        int r97 = CursorUtil.getColumnIndexOrThrow(r3, "useForUserKeyword");     // Catch: Throwable -> L173
        int r98 = CursorUtil.getColumnIndexOrThrow(r3, "startTimestamp");     // Catch: Throwable -> L173
        int r99 = CursorUtil.getColumnIndexOrThrow(r3, "endTimestamp");     // Catch: Throwable -> L173
        int r910 = CursorUtil.getColumnIndexOrThrow(r3, "useForTopic");     // Catch: Throwable -> L173
        int r911 = CursorUtil.getColumnIndexOrThrow(r3, "entityId");     // Catch: Throwable -> L173
        int r17 = CursorUtil.getColumnIndexOrThrow(r3, "createTime");     // Catch: Throwable -> L173
        int r18 = CursorUtil.getColumnIndexOrThrow(r3, "modifyTime");     // Catch: Throwable -> L173
        int r19 = CursorUtil.getColumnIndexOrThrow(r3, "type");     // Catch: Throwable -> L173
        int r20 = CursorUtil.getColumnIndexOrThrow(r3, "timestamp");     // Catch: Throwable -> L173
        int r21 = CursorUtil.getColumnIndexOrThrow(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L173
        int r22 = CursorUtil.getColumnIndexOrThrow(r3, "hashCodeValue");     // Catch: Throwable -> L173
        int r23 = CursorUtil.getColumnIndexOrThrow(r3, Api.KEY_UUID);     // Catch: Throwable -> L173
        int r24 = CursorUtil.getColumnIndexOrThrow(r3, "userEdit");     // Catch: Throwable -> L173
        int r25 = CursorUtil.getColumnIndexOrThrow(r3, "productType");     // Catch: Throwable -> L173
        int r26 = CursorUtil.getColumnIndexOrThrow(r3, "important_raw_ref_ids");     // Catch: Throwable -> L173
        int r27 = CursorUtil.getColumnIndexOrThrow(r3, "source_raw_ref_ids");     // Catch: Throwable -> L173
        int r28 = CursorUtil.getColumnIndexOrThrow(r3, "scene_ids");     // Catch: Throwable -> L173
        int r29 = CursorUtil.getColumnIndexOrThrow(r3, "sourcePackageName");     // Catch: Throwable -> L173
        int r30 = CursorUtil.getColumnIndexOrThrow(r3, "eventName");     // Catch: Throwable -> L173
        int r31 = CursorUtil.getColumnIndexOrThrow(r3, "rawTableName");     // Catch: Throwable -> L173
        int r32 = CursorUtil.getColumnIndexOrThrow(r3, "rawDbId");     // Catch: Throwable -> L173
        int r33 = CursorUtil.getColumnIndexOrThrow(r3, "eventData");     // Catch: Throwable -> L173
        int r34 = CursorUtil.getColumnIndexOrThrow(r3, "poison_label");     // Catch: Throwable -> L173
        int r35 = CursorUtil.getColumnIndexOrThrow(r3, "poison_label_version");     // Catch: Throwable -> L173
        int r36 = CursorUtil.getColumnIndexOrThrow(r3, "content_hash");     // Catch: Throwable -> L173
        int r37 = r6;
        ArrayList r38 = new ArrayList(r3.getCount());     // Catch: Throwable -> L173
    L10:
        if (r3.moveToNext() == false) goto L171;
        long r39 = r3.getLong(r0);     // Catch: Throwable -> L173
        long r41 = r3.getLong(r5);     // Catch: Throwable -> L173
        long r43 = r3.getLong(r7);     // Catch: Throwable -> L173
        if (r3.isNull(r8) == false) goto L15;
        String r45 = null;
    L17:
        if (r3.isNull(r9) == false) goto L19;
        String r46 = null;
    L21:
        if (r3.isNull(r10) == false) goto L23;
        String r47 = null;
    L25:
        if (r3.isNull(r11) == false) goto L27;
        String r48 = null;
    L29:
        if (r3.isNull(r12) == false) goto L31;
        String r49 = null;
    L33:
        if (r3.isNull(r13) == false) goto L35;
        String r50 = null;
    L37:
        if (r3.isNull(r14) == false) goto L39;
        String r51 = null;
    L41:
        if (r3.isNull(r15) == false) goto L43;
        Integer r52 = null;
    L45:
        if (r3.isNull(r1) == false) goto L47;
        Integer r53 = null;
    L49:
        if (r3.isNull(r2) == false) goto L51;
        String r54 = null;
    L53:
        if (r3.isNull(r37) == false) goto L56;
        String r55 = null;
    L55:
        int r86 = r0;
        int r40 = r89;
        if (r3.isNull(r40) == false) goto L61;
        String r56 = null;
    L60:
        r91 = r91;
        if (r3.isNull(r91) == false) goto L65;
        Integer r310 = null;
    L66:
        if (r310 != null) goto L70;
        Boolean r57 = null;
    L68:
        r93 = r93;
        if (r3.isNull(r93) == false) goto L77;
        Integer r311 = null;
    L78:
        if (r311 != null) goto L82;
        Boolean r58 = null;
    L80:
        int r42 = r97;
        r97 = r42;
        if (r3.getInt(r42) == 0) goto L89;
        boolean r59 = true;
    L90:
        int r44 = r98;
        long r60 = r3.getLong(r44);     // Catch: Throwable -> L173
        r98 = r44;
        int r61 = r99;
        long r62 = r3.getLong(r61);     // Catch: Throwable -> L173
        r99 = r61;
        r910 = r910;
        if (r3.isNull(r910) == false) goto L93;
        Integer r312 = null;
    L94:
        if (r312 != null) goto L98;
        Boolean r64 = null;
    L96:
        r911 = r911;
        if (r3.isNull(r911) == false) goto L105;
        String r65 = null;
    L106:
        long r66 = r3.getLong(r17);     // Catch: Throwable -> L173
        r17 = r17;
        int r63 = r18;
        long r68 = r3.getLong(r63);     // Catch: Throwable -> L173
        r18 = r63;
        int r67 = r19;
        int r70 = r3.getInt(r67);     // Catch: Throwable -> L173
        r19 = r67;
        int r69 = r20;
        long r71 = r3.getLong(r69);     // Catch: Throwable -> L173
        r20 = r69;
        r21 = r21;
        if (r3.isNull(r21) == false) goto L109;
        String r73 = null;
    L110:
        int r74 = r3.getInt(r22);     // Catch: Throwable -> L173
        r22 = r22;
        r23 = r23;
        if (r3.isNull(r23) == false) goto L113;
        String r75 = null;
    L115:
        if (r3.isNull(r24) == false) goto L117;
        Integer r210 = null;
    L118:
        if (r210 != null) goto L121;
        Boolean r76 = null;
    L125:
        int r77 = r3.getInt(r25);     // Catch: Throwable -> L173
        r25 = r25;
        r26 = r26;
        if (r3.isNull(r26) == false) goto L128;
        String r78 = null;
    L130:
        if (r3.isNull(r27) == false) goto L132;
        String r79 = null;
    L134:
        if (r3.isNull(r28) == false) goto L136;
        String r80 = null;
    L138:
        if (r3.isNull(r29) == false) goto L140;
        String r81 = null;
    L142:
        if (r3.isNull(r30) == false) goto L144;
        String r82 = null;
    L146:
        if (r3.isNull(r31) == false) goto L148;
        String r83 = null;
    L150:
        if (r3.isNull(r32) == false) goto L152;
        Long r84 = null;
    L154:
        if (r3.isNull(r33) == false) goto L156;
        String r85 = null;
    L157:
        EpisodicMemoryEntity r72 = new EpisodicMemoryEntity(r39, r41, r43, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r62, r64, r65, r66, r68, r70, r71, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85);     // Catch: Throwable -> L173
        int r313 = r1;
        int r87 = r34;
        if (r3.isNull(r87) == false) goto L160;
        Integer r100 = null;
    L161:
        r72.setPoisonLabel(r100);     // Catch: Throwable -> L173
        r35 = r35;
        if (r3.isNull(r35) == false) goto L164;
        Integer r101 = null;
    L165:
        r72.setPoisonLabelVersion(r101);     // Catch: Throwable -> L173
        r36 = r36;
        if (r3.isNull(r36) == false) goto L168;
        String r102 = null;
    L169:
        r72.setContentHash(r102);     // Catch: Throwable -> L173
        r38.add(r72);     // Catch: Throwable -> L173
        r0 = r86;
        r89 = r40;
        r1 = r313;
        r34 = r87;
        r37 = r37;
        goto L10
    L168:
        r102 = r3.getString(r36);     // Catch: Throwable -> L173
        goto L169
    L164:
        r101 = Integer.valueOf(r3.getInt(r35));     // Catch: Throwable -> L173
        goto L165
    L160:
        r100 = Integer.valueOf(r3.getInt(r87));     // Catch: Throwable -> L173
        goto L161
    L156:
        r85 = r3.getString(r33);     // Catch: Throwable -> L173
        goto L157
    L152:
        r84 = Long.valueOf(r3.getLong(r32));     // Catch: Throwable -> L173
        goto L154
    L148:
        r83 = r3.getString(r31);     // Catch: Throwable -> L173
        goto L150
    L144:
        r82 = r3.getString(r30);     // Catch: Throwable -> L173
        goto L146
    L140:
        r81 = r3.getString(r29);     // Catch: Throwable -> L173
        goto L142
    L136:
        r80 = r3.getString(r28);     // Catch: Throwable -> L173
        goto L138
    L132:
        r79 = r3.getString(r27);     // Catch: Throwable -> L173
        goto L134
    L128:
        r78 = r3.getString(r26);     // Catch: Throwable -> L173
        goto L130
    L121:
        if (r210.intValue() == 0) goto L123;
        boolean r211 = true;
    L124:
        r76 = Boolean.valueOf(r211);     // Catch: Throwable -> L173
        goto L125
    L123:
        r211 = false;
        goto L124
    L117:
        r210 = Integer.valueOf(r3.getInt(r24));     // Catch: Throwable -> L173
        goto L118
    L113:
        r75 = r3.getString(r23);     // Catch: Throwable -> L173
        goto L115
    L109:
        r73 = r3.getString(r21);     // Catch: Throwable -> L173
        goto L110
    L105:
        r65 = r3.getString(r911);     // Catch: Throwable -> L173
        goto L106
    L98:
        if (r312.intValue() == 0) goto L100;
        boolean r314 = true;
    L101:
        r64 = Boolean.valueOf(r314);     // Catch: Throwable -> L173
        goto L96
    L100:
        r314 = false;
        goto L101
    L93:
        r312 = Integer.valueOf(r3.getInt(r910));     // Catch: Throwable -> L173
        goto L94
    L89:
        r59 = false;
        goto L90
    L82:
        if (r311.intValue() == 0) goto L84;
        boolean r315 = true;
    L85:
        r58 = Boolean.valueOf(r315);     // Catch: Throwable -> L173
        goto L80
    L84:
        r315 = false;
        goto L85
    L77:
        r311 = Integer.valueOf(r3.getInt(r93));     // Catch: Throwable -> L173
        goto L78
    L70:
        if (r310.intValue() == 0) goto L72;
        boolean r316 = true;
    L73:
        r57 = Boolean.valueOf(r316);     // Catch: Throwable -> L173
        goto L68
    L72:
        r316 = false;
        goto L73
    L65:
        r310 = Integer.valueOf(r3.getInt(r91));     // Catch: Throwable -> L173
        goto L66
    L61:
        r56 = r3.getString(r40);     // Catch: Throwable -> L173
        goto L60
    L56:
        r55 = r3.getString(r37);     // Catch: Throwable -> L173
        goto L55
    L51:
        r54 = r3.getString(r2);     // Catch: Throwable -> L173
        goto L53
    L47:
        r53 = Integer.valueOf(r3.getInt(r1));     // Catch: Throwable -> L173
        goto L49
    L43:
        r52 = Integer.valueOf(r3.getInt(r15));     // Catch: Throwable -> L173
        goto L45
    L39:
        r51 = r3.getString(r14);     // Catch: Throwable -> L173
        goto L41
    L35:
        r50 = r3.getString(r13);     // Catch: Throwable -> L173
        goto L37
    L31:
        r49 = r3.getString(r12);     // Catch: Throwable -> L173
        goto L33
    L27:
        r48 = r3.getString(r11);     // Catch: Throwable -> L173
        goto L29
    L23:
        r47 = r3.getString(r10);     // Catch: Throwable -> L173
        goto L25
    L19:
        r46 = r3.getString(r9);     // Catch: Throwable -> L173
        goto L21
    L15:
        r45 = r3.getString(r8);     // Catch: Throwable -> L173
        goto L17
    L171:
        r3.close();
        r16.release();
        return r38;
    L173:
        th = th;
    L177:
        r3.close();
        r16.release();
        throw th;
    L175:
        th = th;
        r16 = r4;
        goto L177
    L5:
        r4.bindString(6, r94);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<String> queryExistingEntityIds(List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT entityId FROM ShortMemory WHERE entityId IN (");
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

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<String> queryExistingUuids(List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT uuid FROM ShortMemory WHERE uuid IN (");
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

    @Override // com.obric.memorydata.database.dao.BaseDao
    public EpisodicMemoryEntity queryOne() {
        return EpisodicMemoryDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<EpisodicMemoryEntity> queryRecentByPackageName(String r1, long r2) {
        return EpisodicMemoryDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
    public List<EpisodicMemoryEntity> queryScreenMemoryReviewPage(long r89, long r91, long r93, String r95, int r96) {
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("\n        SELECT * FROM ShortMemory\n        WHERE category = 0\n            AND productType IN (\n                1001,\n                1005\n            )\n            AND modifyTime >= ?\n            AND modifyTime < ?\n            AND (modifyTime < ? OR (modifyTime = ? AND entityId < ?))\n        ORDER BY modifyTime DESC, entityId DESC\n        LIMIT ?\n        ", 6);
        r4.bindLong(1, r89);
        r4.bindLong(2, r91);
        r4.bindLong(3, r93);
        r4.bindLong(4, r93);
        if (r95 != null) goto L5;
        r4.bindNull(5);
    L6:
        r4.bindLong(6, r96);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r4, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r3, OaidModel.KEY_ID);     // Catch: Throwable -> L174
        int r5 = CursorUtil.getColumnIndexOrThrow(r3, "actionTimestamp");     // Catch: Throwable -> L174
        int r7 = CursorUtil.getColumnIndexOrThrow(r3, "uid");     // Catch: Throwable -> L174
        int r8 = CursorUtil.getColumnIndexOrThrow(r3, "title");     // Catch: Throwable -> L174
        int r9 = CursorUtil.getColumnIndexOrThrow(r3, Params.CONTENT);     // Catch: Throwable -> L174
        int r10 = CursorUtil.getColumnIndexOrThrow(r3, "contentWithTime");     // Catch: Throwable -> L174
        int r11 = CursorUtil.getColumnIndexOrThrow(r3, "fullContent");     // Catch: Throwable -> L174
        int r12 = CursorUtil.getColumnIndexOrThrow(r3, "observation");     // Catch: Throwable -> L174
        int r13 = CursorUtil.getColumnIndexOrThrow(r3, "location");     // Catch: Throwable -> L174
        int r14 = CursorUtil.getColumnIndexOrThrow(r3, "appNames");     // Catch: Throwable -> L174
        int r15 = CursorUtil.getColumnIndexOrThrow(r3, EventBody.KEY_CATEGORY);     // Catch: Throwable -> L174
        int r1 = CursorUtil.getColumnIndexOrThrow(r3, "profileType");     // Catch: Throwable -> L174
        int r2 = CursorUtil.getColumnIndexOrThrow(r3, "profileTag");     // Catch: Throwable -> L174
        int r6 = CursorUtil.getColumnIndexOrThrow(r3, "tagOther");     // Catch: Throwable -> L174
        RoomSQLiteQuery r16 = r4;
        int r90 = CursorUtil.getColumnIndexOrThrow(r3, "logId");     // Catch: Throwable -> L172
        int r92 = CursorUtil.getColumnIndexOrThrow(r3, "usedForPortrait");     // Catch: Throwable -> L172
        int r94 = CursorUtil.getColumnIndexOrThrow(r3, "useLocation");     // Catch: Throwable -> L172
        int r97 = CursorUtil.getColumnIndexOrThrow(r3, "useForUserKeyword");     // Catch: Throwable -> L172
        int r98 = CursorUtil.getColumnIndexOrThrow(r3, "startTimestamp");     // Catch: Throwable -> L172
        int r99 = CursorUtil.getColumnIndexOrThrow(r3, "endTimestamp");     // Catch: Throwable -> L172
        int r910 = CursorUtil.getColumnIndexOrThrow(r3, "useForTopic");     // Catch: Throwable -> L172
        int r17 = CursorUtil.getColumnIndexOrThrow(r3, "entityId");     // Catch: Throwable -> L172
        int r18 = CursorUtil.getColumnIndexOrThrow(r3, "createTime");     // Catch: Throwable -> L172
        int r19 = CursorUtil.getColumnIndexOrThrow(r3, "modifyTime");     // Catch: Throwable -> L172
        int r20 = CursorUtil.getColumnIndexOrThrow(r3, "type");     // Catch: Throwable -> L172
        int r21 = CursorUtil.getColumnIndexOrThrow(r3, "timestamp");     // Catch: Throwable -> L172
        int r22 = CursorUtil.getColumnIndexOrThrow(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L172
        int r23 = CursorUtil.getColumnIndexOrThrow(r3, "hashCodeValue");     // Catch: Throwable -> L172
        int r24 = CursorUtil.getColumnIndexOrThrow(r3, Api.KEY_UUID);     // Catch: Throwable -> L172
        int r25 = CursorUtil.getColumnIndexOrThrow(r3, "userEdit");     // Catch: Throwable -> L172
        int r26 = CursorUtil.getColumnIndexOrThrow(r3, "productType");     // Catch: Throwable -> L172
        int r27 = CursorUtil.getColumnIndexOrThrow(r3, "important_raw_ref_ids");     // Catch: Throwable -> L172
        int r28 = CursorUtil.getColumnIndexOrThrow(r3, "source_raw_ref_ids");     // Catch: Throwable -> L172
        int r29 = CursorUtil.getColumnIndexOrThrow(r3, "scene_ids");     // Catch: Throwable -> L172
        int r30 = CursorUtil.getColumnIndexOrThrow(r3, "sourcePackageName");     // Catch: Throwable -> L172
        int r31 = CursorUtil.getColumnIndexOrThrow(r3, "eventName");     // Catch: Throwable -> L172
        int r32 = CursorUtil.getColumnIndexOrThrow(r3, "rawTableName");     // Catch: Throwable -> L172
        int r33 = CursorUtil.getColumnIndexOrThrow(r3, "rawDbId");     // Catch: Throwable -> L172
        int r34 = CursorUtil.getColumnIndexOrThrow(r3, "eventData");     // Catch: Throwable -> L172
        int r35 = CursorUtil.getColumnIndexOrThrow(r3, "poison_label");     // Catch: Throwable -> L172
        int r36 = CursorUtil.getColumnIndexOrThrow(r3, "poison_label_version");     // Catch: Throwable -> L172
        int r37 = CursorUtil.getColumnIndexOrThrow(r3, "content_hash");     // Catch: Throwable -> L172
        int r38 = r6;
        ArrayList r39 = new ArrayList(r3.getCount());     // Catch: Throwable -> L172
    L10:
        if (r3.moveToNext() == false) goto L170;
        long r40 = r3.getLong(r0);     // Catch: Throwable -> L172
        long r42 = r3.getLong(r5);     // Catch: Throwable -> L172
        long r44 = r3.getLong(r7);     // Catch: Throwable -> L172
        if (r3.isNull(r8) == false) goto L15;
        String r46 = null;
    L17:
        if (r3.isNull(r9) == false) goto L19;
        String r47 = null;
    L21:
        if (r3.isNull(r10) == false) goto L23;
        String r48 = null;
    L25:
        if (r3.isNull(r11) == false) goto L27;
        String r49 = null;
    L29:
        if (r3.isNull(r12) == false) goto L31;
        String r50 = null;
    L33:
        if (r3.isNull(r13) == false) goto L35;
        String r51 = null;
    L37:
        if (r3.isNull(r14) == false) goto L39;
        String r52 = null;
    L41:
        if (r3.isNull(r15) == false) goto L43;
        Integer r53 = null;
    L45:
        if (r3.isNull(r1) == false) goto L47;
        Integer r54 = null;
    L49:
        if (r3.isNull(r2) == false) goto L51;
        String r55 = null;
    L53:
        if (r3.isNull(r38) == false) goto L56;
        String r56 = null;
    L55:
        int r87 = r0;
        int r41 = r90;
        if (r3.isNull(r41) == false) goto L61;
        String r57 = null;
    L60:
        r92 = r92;
        if (r3.isNull(r92) == false) goto L65;
        Integer r310 = null;
    L66:
        if (r310 != null) goto L70;
        Boolean r58 = null;
    L68:
        r94 = r94;
        if (r3.isNull(r94) == false) goto L77;
        Integer r311 = null;
    L78:
        if (r311 != null) goto L82;
        Boolean r59 = null;
    L80:
        int r43 = r97;
        r97 = r43;
        if (r3.getInt(r43) == 0) goto L89;
        boolean r60 = true;
    L90:
        int r45 = r98;
        long r61 = r3.getLong(r45);     // Catch: Throwable -> L172
        r98 = r45;
        int r62 = r99;
        long r63 = r3.getLong(r62);     // Catch: Throwable -> L172
        r99 = r62;
        r910 = r910;
        if (r3.isNull(r910) == false) goto L93;
        Integer r312 = null;
    L94:
        if (r312 != null) goto L97;
        Boolean r65 = null;
    L102:
        if (r3.isNull(r17) == false) goto L104;
        String r66 = null;
    L105:
        long r67 = r3.getLong(r18);     // Catch: Throwable -> L172
        r18 = r18;
        int r64 = r19;
        long r69 = r3.getLong(r64);     // Catch: Throwable -> L172
        r19 = r64;
        int r68 = r20;
        int r71 = r3.getInt(r68);     // Catch: Throwable -> L172
        r20 = r68;
        int r70 = r21;
        long r72 = r3.getLong(r70);     // Catch: Throwable -> L172
        r21 = r70;
        r22 = r22;
        if (r3.isNull(r22) == false) goto L108;
        String r74 = null;
    L109:
        int r75 = r3.getInt(r23);     // Catch: Throwable -> L172
        r23 = r23;
        r24 = r24;
        if (r3.isNull(r24) == false) goto L112;
        String r76 = null;
    L114:
        if (r3.isNull(r25) == false) goto L116;
        Integer r210 = null;
    L117:
        if (r210 != null) goto L120;
        Boolean r77 = null;
    L124:
        int r78 = r3.getInt(r26);     // Catch: Throwable -> L172
        r26 = r26;
        r27 = r27;
        if (r3.isNull(r27) == false) goto L127;
        String r79 = null;
    L129:
        if (r3.isNull(r28) == false) goto L131;
        String r80 = null;
    L133:
        if (r3.isNull(r29) == false) goto L135;
        String r81 = null;
    L137:
        if (r3.isNull(r30) == false) goto L139;
        String r82 = null;
    L141:
        if (r3.isNull(r31) == false) goto L143;
        String r83 = null;
    L145:
        if (r3.isNull(r32) == false) goto L147;
        String r84 = null;
    L149:
        if (r3.isNull(r33) == false) goto L151;
        Long r85 = null;
    L153:
        if (r3.isNull(r34) == false) goto L155;
        String r86 = null;
    L156:
        EpisodicMemoryEntity r73 = new EpisodicMemoryEntity(r40, r42, r44, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r63, r65, r66, r67, r69, r71, r72, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86);     // Catch: Throwable -> L172
        int r313 = r1;
        int r88 = r35;
        if (r3.isNull(r88) == false) goto L159;
        Integer r100 = null;
    L160:
        r73.setPoisonLabel(r100);     // Catch: Throwable -> L172
        r36 = r36;
        if (r3.isNull(r36) == false) goto L163;
        Integer r101 = null;
    L164:
        r73.setPoisonLabelVersion(r101);     // Catch: Throwable -> L172
        r37 = r37;
        if (r3.isNull(r37) == false) goto L167;
        String r102 = null;
    L168:
        r73.setContentHash(r102);     // Catch: Throwable -> L172
        r39.add(r73);     // Catch: Throwable -> L172
        r0 = r87;
        r90 = r41;
        r1 = r313;
        r35 = r88;
        r38 = r38;
        goto L10
    L167:
        r102 = r3.getString(r37);     // Catch: Throwable -> L172
        goto L168
    L163:
        r101 = Integer.valueOf(r3.getInt(r36));     // Catch: Throwable -> L172
        goto L164
    L159:
        r100 = Integer.valueOf(r3.getInt(r88));     // Catch: Throwable -> L172
        goto L160
    L155:
        r86 = r3.getString(r34);     // Catch: Throwable -> L172
        goto L156
    L151:
        r85 = Long.valueOf(r3.getLong(r33));     // Catch: Throwable -> L172
        goto L153
    L147:
        r84 = r3.getString(r32);     // Catch: Throwable -> L172
        goto L149
    L143:
        r83 = r3.getString(r31);     // Catch: Throwable -> L172
        goto L145
    L139:
        r82 = r3.getString(r30);     // Catch: Throwable -> L172
        goto L141
    L135:
        r81 = r3.getString(r29);     // Catch: Throwable -> L172
        goto L137
    L131:
        r80 = r3.getString(r28);     // Catch: Throwable -> L172
        goto L133
    L127:
        r79 = r3.getString(r27);     // Catch: Throwable -> L172
        goto L129
    L120:
        if (r210.intValue() == 0) goto L122;
        boolean r211 = true;
    L123:
        r77 = Boolean.valueOf(r211);     // Catch: Throwable -> L172
        goto L124
    L122:
        r211 = false;
        goto L123
    L116:
        r210 = Integer.valueOf(r3.getInt(r25));     // Catch: Throwable -> L172
        goto L117
    L112:
        r76 = r3.getString(r24);     // Catch: Throwable -> L172
        goto L114
    L108:
        r74 = r3.getString(r22);     // Catch: Throwable -> L172
        goto L109
    L104:
        r66 = r3.getString(r17);     // Catch: Throwable -> L172
        goto L105
    L97:
        if (r312.intValue() == 0) goto L99;
        boolean r314 = true;
    L100:
        r65 = Boolean.valueOf(r314);     // Catch: Throwable -> L172
        goto L102
    L99:
        r314 = false;
        goto L100
    L93:
        r312 = Integer.valueOf(r3.getInt(r910));     // Catch: Throwable -> L172
        goto L94
    L89:
        r60 = false;
        goto L90
    L82:
        if (r311.intValue() == 0) goto L84;
        boolean r315 = true;
    L85:
        r59 = Boolean.valueOf(r315);     // Catch: Throwable -> L172
        goto L80
    L84:
        r315 = false;
        goto L85
    L77:
        r311 = Integer.valueOf(r3.getInt(r94));     // Catch: Throwable -> L172
        goto L78
    L70:
        if (r310.intValue() == 0) goto L72;
        boolean r316 = true;
    L73:
        r58 = Boolean.valueOf(r316);     // Catch: Throwable -> L172
        goto L68
    L72:
        r316 = false;
        goto L73
    L65:
        r310 = Integer.valueOf(r3.getInt(r92));     // Catch: Throwable -> L172
        goto L66
    L61:
        r57 = r3.getString(r41);     // Catch: Throwable -> L172
        goto L60
    L56:
        r56 = r3.getString(r38);     // Catch: Throwable -> L172
        goto L55
    L51:
        r55 = r3.getString(r2);     // Catch: Throwable -> L172
        goto L53
    L47:
        r54 = Integer.valueOf(r3.getInt(r1));     // Catch: Throwable -> L172
        goto L49
    L43:
        r53 = Integer.valueOf(r3.getInt(r15));     // Catch: Throwable -> L172
        goto L45
    L39:
        r52 = r3.getString(r14);     // Catch: Throwable -> L172
        goto L41
    L35:
        r51 = r3.getString(r13);     // Catch: Throwable -> L172
        goto L37
    L31:
        r50 = r3.getString(r12);     // Catch: Throwable -> L172
        goto L33
    L27:
        r49 = r3.getString(r11);     // Catch: Throwable -> L172
        goto L29
    L23:
        r48 = r3.getString(r10);     // Catch: Throwable -> L172
        goto L25
    L19:
        r47 = r3.getString(r9);     // Catch: Throwable -> L172
        goto L21
    L15:
        r46 = r3.getString(r8);     // Catch: Throwable -> L172
        goto L17
    L170:
        r3.close();
        r16.release();
        return r39;
    L172:
        th = th;
    L176:
        r3.close();
        r16.release();
        throw th;
    L174:
        th = th;
        r16 = r4;
        goto L176
    L5:
        r4.bindString(5, r95);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<EpisodicMemoryEntity> queryWithLimitAndOffset(int r1, int r2) {
        return EpisodicMemoryDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<EpisodicMemoryEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityEpisodicMemoryEntity(r6));     // Catch: Throwable -> L10
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

    @Override // com.obric.memorydata.database.dao.EpisodicMemoryDao
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

    public int update(EpisodicMemoryEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfEpisodicMemoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((EpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r3, EpisodicMemoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<EpisodicMemoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfEpisodicMemoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return EpisodicMemoryDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
