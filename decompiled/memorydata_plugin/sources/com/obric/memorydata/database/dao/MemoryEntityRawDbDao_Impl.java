package com.obric.memorydata.database.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.paging.PagingSource;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.model.c;
import com.obric.memorydata.memory.ui.list.MemoryListActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryEntityRawDbDao_Impl implements MemoryEntityRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<RawMemoryEntity> __deletionAdapterOfRawMemoryEntity;
    private final EntityInsertionAdapter<RawMemoryEntity> __insertionAdapterOfRawMemoryEntity;
    private final EntityDeletionOrUpdateAdapter<RawMemoryEntity> __updateAdapterOfRawMemoryEntity;

    public MemoryEntityRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawMemoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawMemoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawMemoryEntity = new AnonymousClass3(this, r2);
    }

    private RawMemoryEntity __entityCursorConverter_comObricMemorydataDatabaseEntityRawMemoryEntity(Cursor r103) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r103, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r10 = CursorUtil.getColumnIndex(r0, "memoryType");
        int r11 = CursorUtil.getColumnIndex(r0, "productType");
        int r12 = CursorUtil.getColumnIndex(r0, "startDate");
        int r13 = CursorUtil.getColumnIndex(r0, "startTime");
        int r14 = CursorUtil.getColumnIndex(r0, "endDate");
        int r15 = CursorUtil.getColumnIndex(r0, "endTime");
        int r16 = CursorUtil.getColumnIndex(r0, "sourceLinkType");
        int r17 = CursorUtil.getColumnIndex(r0, "sourceLink");
        int r18 = CursorUtil.getColumnIndex(r0, "screenshot");
        int r19 = CursorUtil.getColumnIndex(r0, "locations");
        int r110 = CursorUtil.getColumnIndex(r0, "summary");
        int r111 = CursorUtil.getColumnIndex(r0, "fullContent");
        int r112 = CursorUtil.getColumnIndex(r0, "key1");
        int r113 = CursorUtil.getColumnIndex(r0, "key2");
        int r114 = CursorUtil.getColumnIndex(r0, "key3");
        int r115 = CursorUtil.getColumnIndex(r0, "key4");
        int r116 = CursorUtil.getColumnIndex(r0, "key5");
        int r117 = CursorUtil.getColumnIndex(r0, "keyword1");
        int r118 = CursorUtil.getColumnIndex(r0, "keyword2");
        int r119 = CursorUtil.getColumnIndex(r0, "keyword3");
        int r120 = CursorUtil.getColumnIndex(r0, "keyword4");
        int r121 = CursorUtil.getColumnIndex(r0, "keyword5");
        int r122 = CursorUtil.getColumnIndex(r0, "keyword6");
        int r123 = CursorUtil.getColumnIndex(r0, "semantic1");
        int r124 = CursorUtil.getColumnIndex(r0, "semantic2");
        int r125 = CursorUtil.getColumnIndex(r0, "keywordAndSemantic1");
        int r126 = CursorUtil.getColumnIndex(r0, "keywordAndSemantic2");
        int r127 = CursorUtil.getColumnIndex(r0, "sourceText");
        int r128 = CursorUtil.getColumnIndex(r0, "sourcePackageName");
        int r129 = CursorUtil.getColumnIndex(r0, "sourceAppName");
        int r130 = CursorUtil.getColumnIndex(r0, "logId");
        int r131 = CursorUtil.getColumnIndex(r0, "sourceQuery");
        int r132 = CursorUtil.getColumnIndex(r0, MemoryListActivity.JUMP_FROM_DETAIL);
        int r133 = CursorUtil.getColumnIndex(r0, "detailStatus");
        int r134 = CursorUtil.getColumnIndex(r0, "contentWithTime");
        int r135 = CursorUtil.getColumnIndex(r0, "userEdit");
        int r136 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r137 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r138 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r47 = 0;
        if (r1 != (-1)) goto L5;
        long r53 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r55 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r56 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r58 = 0;
    L19:
        boolean r21 = false;
        if (r5 != (-1)) goto L22;
        int r60 = 0;
    L23:
        if (r6 == (-1)) goto L26;
        r47 = r0.getLong(r6);
    L26:
        long r61 = r47;
        if (r7 != (-1)) goto L30;
    L28:
        String r63 = null;
    L33:
        if (r8 != (-1)) goto L35;
        int r64 = 0;
    L36:
        if (r9 != (-1)) goto L39;
    L37:
        String r65 = null;
    L42:
        if (r10 != (-1)) goto L44;
        int r66 = 0;
    L45:
        if (r11 != (-1)) goto L47;
        int r67 = 0;
    L48:
        if (r12 != (-1)) goto L51;
    L49:
        Long r68 = null;
    L54:
        if (r13 != (-1)) goto L57;
    L55:
        Long r69 = null;
    L60:
        if (r14 != (-1)) goto L63;
    L61:
        Long r70 = null;
    L66:
        if (r102 != (-1)) goto L69;
    L67:
        Long r71 = null;
    L72:
        if (r103 != (-1)) goto L76;
    L73:
        String r72 = null;
    L79:
        if (r17 != (-1)) goto L83;
    L80:
        String r73 = null;
    L86:
        if (r18 != (-1)) goto L90;
    L87:
        String r74 = null;
    L93:
        if (r19 != (-1)) goto L97;
    L94:
        String r75 = null;
    L100:
        if (r110 != (-1)) goto L104;
    L101:
        String r76 = null;
    L107:
        if (r111 != (-1)) goto L111;
    L108:
        String r77 = null;
    L114:
        if (r112 != (-1)) goto L118;
    L115:
        String r78 = null;
    L121:
        if (r113 != (-1)) goto L125;
    L122:
        String r79 = null;
    L128:
        if (r114 != (-1)) goto L132;
    L129:
        String r80 = null;
    L135:
        if (r115 != (-1)) goto L139;
    L136:
        String r81 = null;
    L142:
        if (r116 != (-1)) goto L146;
    L143:
        String r82 = null;
    L149:
        if (r117 != (-1)) goto L153;
    L150:
        String r83 = null;
    L156:
        if (r118 != (-1)) goto L160;
    L157:
        String r84 = null;
    L163:
        if (r119 != (-1)) goto L167;
    L164:
        String r85 = null;
    L170:
        if (r120 != (-1)) goto L174;
    L171:
        String r86 = null;
    L177:
        if (r121 != (-1)) goto L181;
    L178:
        String r87 = null;
    L184:
        if (r122 != (-1)) goto L188;
    L185:
        String r88 = null;
    L191:
        if (r123 != (-1)) goto L195;
    L192:
        String r89 = null;
    L198:
        if (r124 != (-1)) goto L202;
    L199:
        String r90 = null;
    L205:
        if (r125 != (-1)) goto L209;
    L206:
        String r91 = null;
    L212:
        if (r126 != (-1)) goto L216;
    L213:
        String r92 = null;
    L219:
        if (r127 != (-1)) goto L223;
    L220:
        String r93 = null;
    L226:
        if (r128 != (-1)) goto L230;
    L227:
        String r94 = null;
    L233:
        if (r129 != (-1)) goto L237;
    L234:
        String r95 = null;
    L240:
        if (r130 != (-1)) goto L244;
    L241:
        String r96 = null;
    L247:
        if (r131 != (-1)) goto L251;
    L248:
        String r97 = null;
    L254:
        if (r132 != (-1)) goto L258;
    L255:
        String r98 = null;
    L261:
        if (r133 != (-1)) goto L263;
        int r99 = 0;
    L265:
        if (r134 != (-1)) goto L269;
    L266:
        String r100 = null;
    L272:
        if (r135 != (-1)) goto L275;
    L277:
        RawMemoryEntity r22 = new RawMemoryEntity(r53, r55, r56, r58, r60, r61, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r21);
        if (r136 == (-1)) goto L285;
        if (r0.isNull(r136) == false) goto L282;
        Integer r23 = null;
    L283:
        r22.setPoisonLabel(r23);
        goto L285
    L282:
        r23 = Integer.valueOf(r0.getInt(r136));
    L285:
        if (r137 == (-1)) goto L292;
        if (r0.isNull(r137) == false) goto L289;
        Integer r24 = null;
    L290:
        r22.setPoisonLabelVersion(r24);
        goto L292
    L289:
        r24 = Integer.valueOf(r0.getInt(r137));
    L292:
        if (r138 != (-1)) goto L294;
    L298:
        return r22;
    L294:
        if (r0.isNull(r138) == true) goto L297;
        r20 = r0.getString(r138);
    L297:
        r22.setContentHash(r20);
        goto L298
    L275:
        if (r0.getInt(r135) == 0) goto L277;
        r21 = true;
        goto L277
    L269:
        if (r0.isNull(r134) == true) goto L266;
        r100 = r0.getString(r134);
        goto L272
    L263:
        r99 = r0.getInt(r133);
        goto L265
    L258:
        if (r0.isNull(r132) == true) goto L255;
        r98 = r0.getString(r132);
        goto L261
    L251:
        if (r0.isNull(r131) == true) goto L248;
        r97 = r0.getString(r131);
        goto L254
    L244:
        if (r0.isNull(r130) == true) goto L241;
        r96 = r0.getString(r130);
        goto L247
    L237:
        if (r0.isNull(r129) == true) goto L234;
        r95 = r0.getString(r129);
        goto L240
    L230:
        if (r0.isNull(r128) == true) goto L227;
        r94 = r0.getString(r128);
        goto L233
    L223:
        if (r0.isNull(r127) == true) goto L220;
        r93 = r0.getString(r127);
        goto L226
    L216:
        if (r0.isNull(r126) == true) goto L213;
        r92 = r0.getString(r126);
        goto L219
    L209:
        if (r0.isNull(r125) == true) goto L206;
        r91 = r0.getString(r125);
        goto L212
    L202:
        if (r0.isNull(r124) == true) goto L199;
        r90 = r0.getString(r124);
        goto L205
    L195:
        if (r0.isNull(r123) == true) goto L192;
        r89 = r0.getString(r123);
        goto L198
    L188:
        if (r0.isNull(r122) == true) goto L185;
        r88 = r0.getString(r122);
        goto L191
    L181:
        if (r0.isNull(r121) == true) goto L178;
        r87 = r0.getString(r121);
        goto L184
    L174:
        if (r0.isNull(r120) == true) goto L171;
        r86 = r0.getString(r120);
        goto L177
    L167:
        if (r0.isNull(r119) == true) goto L164;
        r85 = r0.getString(r119);
        goto L170
    L160:
        if (r0.isNull(r118) == true) goto L157;
        r84 = r0.getString(r118);
        goto L163
    L153:
        if (r0.isNull(r117) == true) goto L150;
        r83 = r0.getString(r117);
        goto L156
    L146:
        if (r0.isNull(r116) == true) goto L143;
        r82 = r0.getString(r116);
        goto L149
    L139:
        if (r0.isNull(r115) == true) goto L136;
        r81 = r0.getString(r115);
        goto L142
    L132:
        if (r0.isNull(r114) == true) goto L129;
        r80 = r0.getString(r114);
        goto L135
    L125:
        if (r0.isNull(r113) == true) goto L122;
        r79 = r0.getString(r113);
        goto L128
    L118:
        if (r0.isNull(r112) == true) goto L115;
        r78 = r0.getString(r112);
        goto L121
    L111:
        if (r0.isNull(r111) == true) goto L108;
        r77 = r0.getString(r111);
        goto L114
    L104:
        if (r0.isNull(r110) == true) goto L101;
        r76 = r0.getString(r110);
        goto L107
    L97:
        if (r0.isNull(r19) == true) goto L94;
        r75 = r0.getString(r19);
        goto L100
    L90:
        if (r0.isNull(r18) == true) goto L87;
        r74 = r0.getString(r18);
        goto L93
    L83:
        if (r0.isNull(r17) == true) goto L80;
        r73 = r0.getString(r17);
        goto L86
    L76:
        if (r0.isNull(r103) == true) goto L73;
        r72 = r0.getString(r16);
        goto L79
    L69:
        if (r0.isNull(r102) == true) goto L67;
        r71 = Long.valueOf(r0.getLong(r15));
        goto L72
    L63:
        if (r0.isNull(r14) == true) goto L61;
        r70 = Long.valueOf(r0.getLong(r14));
        goto L66
    L57:
        if (r0.isNull(r13) == true) goto L55;
        r69 = Long.valueOf(r0.getLong(r13));
        goto L60
    L51:
        if (r0.isNull(r12) == true) goto L49;
        r68 = Long.valueOf(r0.getLong(r12));
        goto L54
    L47:
        r67 = r0.getInt(r11);
        goto L48
    L44:
        r66 = r0.getInt(r10);
        goto L45
    L39:
        if (r0.isNull(r9) == true) goto L37;
        r65 = r0.getString(r9);
        goto L42
    L35:
        r64 = r0.getInt(r8);
        goto L36
    L30:
        if (r0.isNull(r7) == true) goto L28;
        r63 = r0.getString(r7);
        goto L33
    L22:
        r60 = r0.getInt(r5);
        goto L23
    L18:
        r58 = r0.getLong(r4);
        goto L19
    L15:
        r56 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r55 = r0.getString(r2);
        goto L13
    L5:
        r53 = r0.getLong(r1);
        goto L6
    }

    static /* synthetic */ RoomDatabase access$000(MemoryEntityRawDbDao_Impl r0) {
        return r0.__db;
    }

    static /* synthetic */ RawMemoryEntity access$100(MemoryEntityRawDbDao_Impl r2, Cursor r3) {
        return r2.__entityCursorConverter_comObricMemorydataDatabaseEntityRawMemoryEntity((Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin"));
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return MemoryEntityRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<RawMemoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawMemoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<RawMemoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawMemoryEntity.insert(r4);     // Catch: Throwable -> L6
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

    public int delete(RawMemoryEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawMemoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r3, RawMemoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return MemoryEntityRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return MemoryEntityRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public boolean exists(String r4) {
        boolean r1 = true;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT 1 FROM RawMemoryEntity WHERE entityId = ?)", 1);
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

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public i<Integer> getAllMemoryCount() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM RawMemoryEntity", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"RawMemoryEntity"}, new AnonymousClass4(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public PagingSource<Integer, RawMemoryEntity> getAllTypeMemory() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntity ORDER BY createTime DESC", 0);
        final RoomDatabase r2 = this.__db;
        final String[] r3 = {"RawMemoryEntity"};
        return new AnonymousClass22(this, r0, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public List<RawMemoryEntity> getAnniversaryMemory() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntity WHERE memoryType = 10103 ORDER BY createTime DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L199
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "entityId");     // Catch: Throwable -> L199
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "createTime");     // Catch: Throwable -> L199
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "modifyTime");     // Catch: Throwable -> L199
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "type");     // Catch: Throwable -> L199
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L199
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L199
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "hashCodeValue");     // Catch: Throwable -> L199
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, Api.KEY_UUID);     // Catch: Throwable -> L199
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "memoryType");     // Catch: Throwable -> L199
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "productType");     // Catch: Throwable -> L199
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, "startDate");     // Catch: Throwable -> L199
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "startTime");     // Catch: Throwable -> L199
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "endDate");     // Catch: Throwable -> L199
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "endTime");     // Catch: Throwable -> L197
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "sourceLinkType");     // Catch: Throwable -> L197
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "sourceLink");     // Catch: Throwable -> L197
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "screenshot");     // Catch: Throwable -> L197
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "locations");     // Catch: Throwable -> L197
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "summary");     // Catch: Throwable -> L197
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "fullContent");     // Catch: Throwable -> L197
        int r24 = CursorUtil.getColumnIndexOrThrow(r4, "key1");     // Catch: Throwable -> L197
        int r25 = CursorUtil.getColumnIndexOrThrow(r4, "key2");     // Catch: Throwable -> L197
        int r26 = CursorUtil.getColumnIndexOrThrow(r4, "key3");     // Catch: Throwable -> L197
        int r27 = CursorUtil.getColumnIndexOrThrow(r4, "key4");     // Catch: Throwable -> L197
        int r28 = CursorUtil.getColumnIndexOrThrow(r4, "key5");     // Catch: Throwable -> L197
        int r29 = CursorUtil.getColumnIndexOrThrow(r4, "keyword1");     // Catch: Throwable -> L197
        int r30 = CursorUtil.getColumnIndexOrThrow(r4, "keyword2");     // Catch: Throwable -> L197
        int r31 = CursorUtil.getColumnIndexOrThrow(r4, "keyword3");     // Catch: Throwable -> L197
        int r32 = CursorUtil.getColumnIndexOrThrow(r4, "keyword4");     // Catch: Throwable -> L197
        int r33 = CursorUtil.getColumnIndexOrThrow(r4, "keyword5");     // Catch: Throwable -> L197
        int r34 = CursorUtil.getColumnIndexOrThrow(r4, "keyword6");     // Catch: Throwable -> L197
        int r35 = CursorUtil.getColumnIndexOrThrow(r4, "semantic1");     // Catch: Throwable -> L197
        int r36 = CursorUtil.getColumnIndexOrThrow(r4, "semantic2");     // Catch: Throwable -> L197
        int r37 = CursorUtil.getColumnIndexOrThrow(r4, "keywordAndSemantic1");     // Catch: Throwable -> L197
        int r38 = CursorUtil.getColumnIndexOrThrow(r4, "keywordAndSemantic2");     // Catch: Throwable -> L197
        int r39 = CursorUtil.getColumnIndexOrThrow(r4, "sourceText");     // Catch: Throwable -> L197
        int r40 = CursorUtil.getColumnIndexOrThrow(r4, "sourcePackageName");     // Catch: Throwable -> L197
        int r41 = CursorUtil.getColumnIndexOrThrow(r4, "sourceAppName");     // Catch: Throwable -> L197
        int r42 = CursorUtil.getColumnIndexOrThrow(r4, "logId");     // Catch: Throwable -> L197
        int r43 = CursorUtil.getColumnIndexOrThrow(r4, "sourceQuery");     // Catch: Throwable -> L197
        int r44 = CursorUtil.getColumnIndexOrThrow(r4, MemoryListActivity.JUMP_FROM_DETAIL);     // Catch: Throwable -> L197
        int r45 = CursorUtil.getColumnIndexOrThrow(r4, "detailStatus");     // Catch: Throwable -> L197
        int r46 = CursorUtil.getColumnIndexOrThrow(r4, "contentWithTime");     // Catch: Throwable -> L197
        int r47 = CursorUtil.getColumnIndexOrThrow(r4, "userEdit");     // Catch: Throwable -> L197
        int r48 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label");     // Catch: Throwable -> L197
        int r49 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label_version");     // Catch: Throwable -> L197
        int r50 = CursorUtil.getColumnIndexOrThrow(r4, "content_hash");     // Catch: Throwable -> L197
        int r51 = r3;
        ArrayList r52 = new ArrayList(r4.getCount());     // Catch: Throwable -> L197
    L6:
        if (r4.moveToNext() == false) goto L195;
        long r53 = r4.getLong(r0);     // Catch: Throwable -> L197
        if (r4.isNull(r5) == false) goto L11;
        String r55 = null;
    L12:
        long r56 = r4.getLong(r6);     // Catch: Throwable -> L197
        long r58 = r4.getLong(r7);     // Catch: Throwable -> L197
        int r60 = r4.getInt(r8);     // Catch: Throwable -> L197
        long r61 = r4.getLong(r9);     // Catch: Throwable -> L197
        if (r4.isNull(r10) == false) goto L15;
        String r63 = null;
    L16:
        int r64 = r4.getInt(r11);     // Catch: Throwable -> L197
        if (r4.isNull(r12) == false) goto L19;
        String r65 = null;
    L20:
        int r66 = r4.getInt(r13);     // Catch: Throwable -> L197
        int r67 = r4.getInt(r14);     // Catch: Throwable -> L197
        if (r4.isNull(r15) == false) goto L23;
        Long r68 = null;
    L25:
        if (r4.isNull(r2) == false) goto L27;
        Long r69 = null;
    L29:
        if (r4.isNull(r51) == false) goto L32;
        Long r70 = null;
    L31:
        int r102 = r17;
        int r110 = r0;
        if (r4.isNull(r102) == false) goto L37;
        Long r71 = null;
    L36:
        int r103 = r18;
        if (r4.isNull(r103) == false) goto L42;
        String r72 = null;
    L41:
        int r104 = r19;
        if (r4.isNull(r104) == false) goto L47;
        String r73 = null;
    L46:
        int r105 = r20;
        if (r4.isNull(r105) == false) goto L52;
        String r74 = null;
    L51:
        int r106 = r21;
        if (r4.isNull(r106) == false) goto L57;
        String r75 = null;
    L56:
        int r107 = r22;
        if (r4.isNull(r107) == false) goto L62;
        String r76 = null;
    L61:
        int r108 = r23;
        if (r4.isNull(r108) == false) goto L67;
        String r77 = null;
    L66:
        int r109 = r24;
        if (r4.isNull(r109) == false) goto L72;
        String r78 = null;
    L71:
        int r1010 = r25;
        if (r4.isNull(r1010) == false) goto L77;
        String r79 = null;
    L76:
        int r1011 = r26;
        if (r4.isNull(r1011) == false) goto L82;
        String r80 = null;
    L81:
        int r1012 = r27;
        if (r4.isNull(r1012) == false) goto L87;
        String r81 = null;
    L86:
        int r1013 = r28;
        if (r4.isNull(r1013) == false) goto L92;
        String r82 = null;
    L91:
        int r1014 = r29;
        if (r4.isNull(r1014) == false) goto L97;
        String r83 = null;
    L96:
        int r1015 = r30;
        if (r4.isNull(r1015) == false) goto L102;
        String r84 = null;
    L101:
        int r1016 = r31;
        if (r4.isNull(r1016) == false) goto L107;
        String r85 = null;
    L106:
        int r1017 = r32;
        if (r4.isNull(r1017) == false) goto L112;
        String r86 = null;
    L111:
        int r1018 = r33;
        if (r4.isNull(r1018) == false) goto L117;
        String r87 = null;
    L116:
        int r1019 = r34;
        if (r4.isNull(r1019) == false) goto L122;
        String r88 = null;
    L121:
        int r1020 = r35;
        if (r4.isNull(r1020) == false) goto L127;
        String r89 = null;
    L126:
        int r1021 = r36;
        if (r4.isNull(r1021) == false) goto L132;
        String r90 = null;
    L131:
        int r1022 = r37;
        if (r4.isNull(r1022) == false) goto L137;
        String r91 = null;
    L136:
        int r1023 = r38;
        if (r4.isNull(r1023) == false) goto L142;
        String r92 = null;
    L141:
        int r1024 = r39;
        if (r4.isNull(r1024) == false) goto L147;
        String r93 = null;
    L146:
        int r1025 = r40;
        if (r4.isNull(r1025) == false) goto L152;
        String r94 = null;
    L151:
        int r1026 = r41;
        if (r4.isNull(r1026) == false) goto L157;
        String r95 = null;
    L156:
        int r1027 = r42;
        if (r4.isNull(r1027) == false) goto L162;
        String r96 = null;
    L161:
        int r1028 = r43;
        if (r4.isNull(r1028) == false) goto L167;
        String r97 = null;
    L166:
        int r1029 = r44;
        if (r4.isNull(r1029) == false) goto L172;
        String r98 = null;
    L171:
        int r1030 = r45;
        int r99 = r4.getInt(r1030);     // Catch: Throwable -> L197
        r46 = r46;
        if (r4.isNull(r46) == false) goto L176;
        String r100 = null;
    L178:
        if (r4.getInt(r47) == 0) goto L180;
        boolean r101 = true;
    L181:
        RawMemoryEntity r54 = new RawMemoryEntity(r53, r55, r56, r58, r60, r61, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101);     // Catch: Throwable -> L197
        int r57 = r2;
        int r59 = r48;
        if (r4.isNull(r59) == false) goto L184;
        Integer r62 = null;
    L185:
        r54.setPoisonLabel(r62);     // Catch: Throwable -> L197
        r49 = r49;
        if (r4.isNull(r49) == false) goto L188;
        Integer r111 = null;
    L189:
        r54.setPoisonLabelVersion(r111);     // Catch: Throwable -> L197
        r50 = r50;
        if (r4.isNull(r50) == false) goto L192;
        String r112 = null;
    L193:
        r54.setContentHash(r112);     // Catch: Throwable -> L197
        r52.add(r54);     // Catch: Throwable -> L197
        r0 = r110;
        r17 = r102;
        r18 = r103;
        r19 = r104;
        r20 = r105;
        r21 = r106;
        r22 = r107;
        r23 = r108;
        r24 = r109;
        r25 = r1010;
        r26 = r1011;
        r27 = r1012;
        r28 = r1013;
        r29 = r1014;
        r30 = r1015;
        r31 = r1016;
        r32 = r1017;
        r33 = r1018;
        r34 = r1019;
        r35 = r1020;
        r36 = r1021;
        r37 = r1022;
        r38 = r1023;
        r39 = r1024;
        r40 = r1025;
        r41 = r1026;
        r42 = r1027;
        r43 = r1028;
        r44 = r1029;
        r45 = r1030;
        r2 = r57;
        r48 = r59;
        r51 = r51;
        goto L6
    L192:
        r112 = r4.getString(r50);     // Catch: Throwable -> L197
        goto L193
    L188:
        r111 = Integer.valueOf(r4.getInt(r49));     // Catch: Throwable -> L197
        goto L189
    L184:
        r62 = Integer.valueOf(r4.getInt(r59));     // Catch: Throwable -> L197
        goto L185
    L180:
        r101 = false;
        goto L181
    L176:
        r100 = r4.getString(r46);     // Catch: Throwable -> L197
        goto L178
    L172:
        r98 = r4.getString(r1029);     // Catch: Throwable -> L197
        goto L171
    L167:
        r97 = r4.getString(r1028);     // Catch: Throwable -> L197
        goto L166
    L162:
        r96 = r4.getString(r1027);     // Catch: Throwable -> L197
        goto L161
    L157:
        r95 = r4.getString(r1026);     // Catch: Throwable -> L197
        goto L156
    L152:
        r94 = r4.getString(r1025);     // Catch: Throwable -> L197
        goto L151
    L147:
        r93 = r4.getString(r1024);     // Catch: Throwable -> L197
        goto L146
    L142:
        r92 = r4.getString(r1023);     // Catch: Throwable -> L197
        goto L141
    L137:
        r91 = r4.getString(r1022);     // Catch: Throwable -> L197
        goto L136
    L132:
        r90 = r4.getString(r1021);     // Catch: Throwable -> L197
        goto L131
    L127:
        r89 = r4.getString(r1020);     // Catch: Throwable -> L197
        goto L126
    L122:
        r88 = r4.getString(r1019);     // Catch: Throwable -> L197
        goto L121
    L117:
        r87 = r4.getString(r1018);     // Catch: Throwable -> L197
        goto L116
    L112:
        r86 = r4.getString(r1017);     // Catch: Throwable -> L197
        goto L111
    L107:
        r85 = r4.getString(r1016);     // Catch: Throwable -> L197
        goto L106
    L102:
        r84 = r4.getString(r1015);     // Catch: Throwable -> L197
        goto L101
    L97:
        r83 = r4.getString(r1014);     // Catch: Throwable -> L197
        goto L96
    L92:
        r82 = r4.getString(r1013);     // Catch: Throwable -> L197
        goto L91
    L87:
        r81 = r4.getString(r1012);     // Catch: Throwable -> L197
        goto L86
    L82:
        r80 = r4.getString(r1011);     // Catch: Throwable -> L197
        goto L81
    L77:
        r79 = r4.getString(r1010);     // Catch: Throwable -> L197
        goto L76
    L72:
        r78 = r4.getString(r109);     // Catch: Throwable -> L197
        goto L71
    L67:
        r77 = r4.getString(r108);     // Catch: Throwable -> L197
        goto L66
    L62:
        r76 = r4.getString(r107);     // Catch: Throwable -> L197
        goto L61
    L57:
        r75 = r4.getString(r106);     // Catch: Throwable -> L197
        goto L56
    L52:
        r74 = r4.getString(r105);     // Catch: Throwable -> L197
        goto L51
    L47:
        r73 = r4.getString(r104);     // Catch: Throwable -> L197
        goto L46
    L42:
        r72 = r4.getString(r103);     // Catch: Throwable -> L197
        goto L41
    L37:
        r71 = Long.valueOf(r4.getLong(r102));     // Catch: Throwable -> L197
        goto L36
    L32:
        r70 = Long.valueOf(r4.getLong(r51));     // Catch: Throwable -> L197
        goto L31
    L27:
        r69 = Long.valueOf(r4.getLong(r2));     // Catch: Throwable -> L197
        goto L29
    L23:
        r68 = Long.valueOf(r4.getLong(r15));     // Catch: Throwable -> L197
        goto L25
    L19:
        r65 = r4.getString(r12);     // Catch: Throwable -> L197
        goto L20
    L15:
        r63 = r4.getString(r10);     // Catch: Throwable -> L197
        goto L16
    L11:
        r55 = r4.getString(r5);     // Catch: Throwable -> L197
        goto L12
    L195:
        r4.close();
        r16.release();
        return r52;
    L197:
        th = th;
    L201:
        r4.close();
        r16.release();
        throw th;
    L199:
        th = th;
        r16 = r1;
        goto L201
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public PagingSource<Integer, RawMemoryEntity> getCollectTypeMemory() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntity WHERE memoryType NOT IN ( 10101, 10102, 10103, 10104, 10105) ORDER BY modifyTime DESC", 0);
        final RoomDatabase r2 = this.__db;
        final String[] r3 = {"RawMemoryEntity"};
        return new AnonymousClass12(this, r0, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public i<Integer> getCollectTypeMemoryCount() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM RawMemoryEntity WHERE memoryType NOT IN ( 10101, 10102, 10103, 10104, 10105) ORDER BY modifyTime DESC", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"RawMemoryEntity"}, new AnonymousClass5(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public Object getCollectTypeMemoryMetaInfo(List<String> r9, boolean r10, boolean r11, Continuation<? super List<cu>> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT entityId, type, packageName, logId FROM RawMemoryEntity WHERE memoryType NOT IN ( 10101, 10102, 10103, 10104, 10105) AND (       (NOT ");
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
        return CoroutinesRoom.execute(this.__db, false, r17, new AnonymousClass13(this, r1), r14);
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
        return MemoryEntityRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return MemoryEntityRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return MemoryEntityRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
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
        return MemoryEntityRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public PagingSource<Integer, RawMemoryEntity> getInfoAllTypeMemory() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntity WHERE memoryType IN ( 10101 , 10102 , 10103 , 10104 , 10105 ) ORDER BY modifyTime DESC", 0);
        final RoomDatabase r2 = this.__db;
        final String[] r3 = {"RawMemoryEntity"};
        return new AnonymousClass14(this, r0, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public i<Integer> getInfoAllTypeMemoryCount() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM RawMemoryEntity WHERE memoryType IN ( 10101 , 10102 , 10103 , 10104 , 10105 ) ORDER BY modifyTime DESC", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"RawMemoryEntity"}, new AnonymousClass7(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public Object getInfoAllTypeMemoryMetaInfo(List<String> r9, boolean r10, boolean r11, Continuation<? super List<cu>> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT entityId, type, packageName, logId FROM RawMemoryEntity WHERE memoryType IN ( 10101 , 10102 , 10103 , 10104 , 10105 ) AND (       (NOT ");
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
        return CoroutinesRoom.execute(this.__db, false, r17, new AnonymousClass15(this, r1), r14);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public PagingSource<Integer, RawMemoryEntity> getInfoOthersTypeMemory(String[] r6) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM RawMemoryEntity WHERE memoryType IN ( 10101 , 10102 , 10103 , 10104 , 10105 )  AND (key1 NOT IN (");
        int r1 = r6.length;
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(")) ORDER BY modifyTime DESC");
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
        final String[] r9 = {"RawMemoryEntity"};
        return new AnonymousClass16(this, r3, r8, r9);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public i<Integer> getInfoOthersTypeMemoryCount(String[] r7) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT COUNT(*) FROM RawMemoryEntity WHERE memoryType IN ( 10101 , 10102 , 10103 , 10104 , 10105 )  AND (key1 NOT IN (");
        int r1 = r7.length;
        StringUtil.appendPlaceholders(r0, r1);
        r0.append(")) ORDER BY modifyTime DESC");
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
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"RawMemoryEntity"}, new AnonymousClass8(this, r2));
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public Object getInfoOthersTypeMemoryMetaInfo(String[] r11, List<String> r12, boolean r13, boolean r14, Continuation<? super List<cu>> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        Continuation r17 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r15, Continuation.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT entityId, type, packageName, logId FROM RawMemoryEntity WHERE memoryType IN ( 10101 , 10102 , 10103 , 10104 , 10105 )  AND (key1 NOT IN (");
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
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new AnonymousClass17(this, r1), r17);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public PagingSource<Integer, RawMemoryEntity> getInfoSingleTagMemory(String r4) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntity WHERE memoryType = 10105 AND (? IS NOT NULL AND key1=?) ORDER BY modifyTime DESC", 2);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        if (r4 != null) goto L8;
        r0.bindNull(2);
    L9:
        final RoomDatabase r1 = this.__db;
        final String[] r2 = {"RawMemoryEntity"};
        return new AnonymousClass20(this, r0, r1, r2);
    L8:
        r0.bindString(2, r4);
        goto L9
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public i<Integer> getInfoSingleTagMemoryCount(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM RawMemoryEntity WHERE memoryType = 10105 AND (? IS NOT NULL AND key1=?) ORDER BY modifyTime DESC", 2);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        if (r5 != null) goto L8;
        r0.bindNull(2);
    L10:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"RawMemoryEntity"}, new AnonymousClass10(this, r0));
    L8:
        r0.bindString(2, r5);
        goto L10
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public Object getInfoSingleTagMemoryMetaInfo(String r8, List<String> r9, boolean r10, boolean r11, Continuation<? super List<cu>> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT entityId, type, packageName, logId FROM RawMemoryEntity WHERE memoryType = 10105 AND (");
        r0.append("?");
        r0.append(" IS NOT NULL AND key1=");
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

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public PagingSource<Integer, RawMemoryEntity> getInfoSingleTypeMemory(int r4, String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntity WHERE memoryType IN ( 10101 , 10102 , 10103 , 10104, 10105 ) AND (( memoryType = 10105 AND ? IS NOT NULL AND key1=?) OR memoryType = ?) ORDER BY modifyTime DESC", 3);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r5 != null) goto L9;
        r0.bindNull(2);
    L10:
        r0.bindLong(3, r4);
        final RoomDatabase r6 = this.__db;
        final String[] r1 = {"RawMemoryEntity"};
        return new AnonymousClass18(this, r0, r6, r1);
    L9:
        r0.bindString(2, r5);
        goto L10
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public i<Integer> getInfoSingleTypeMemoryCount(int r4, String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM RawMemoryEntity WHERE memoryType IN ( 10101 , 10102 , 10103 , 10104, 10105 ) AND (( memoryType = 10105 AND ? IS NOT NULL AND key1=?) OR memoryType = ?) ORDER BY modifyTime DESC", 3);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r5 != null) goto L9;
        r0.bindNull(2);
    L10:
        r0.bindLong(3, r4);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"RawMemoryEntity"}, new AnonymousClass9(this, r0));
    L9:
        r0.bindString(2, r5);
        goto L10
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public Object getInfoSingleTypeMemoryMetaInfo(int r9, String r10, List<String> r11, boolean r12, boolean r13, Continuation<? super List<cu>> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Continuation r16 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT entityId, type, packageName, logId FROM RawMemoryEntity WHERE memoryType IN ( 10101 , 10102 , 10103 , 10104, 10105 ) AND (( memoryType = 10105 AND ");
        r0.append("?");
        r0.append(" IS NOT NULL AND key1=");
        r0.append("?");
        r0.append(") OR memoryType = ");
        r0.append("?");
        r0.append(") AND (       (NOT ");
        r0.append("?");
        r0.append(" AND (            (");
        r0.append("?");
        r0.append(" AND entityId IN (");
        int r4 = r15.size();
        StringUtil.appendPlaceholders(r0, r4);
        r0.append(")) OR             (NOT ");
        r0.append("?");
        r0.append(" AND entityId NOT IN (");
        int r6 = r15.size();
        StringUtil.appendPlaceholders(r0, r6);
        r0.append("))         ))        OR (");
        r0.append("?");
        r0.append(")) AND ((");
        r0.append("?");
        r0.append(" AND entityId IN (");
        int r3 = r15.size();
        StringUtil.appendPlaceholders(r0, r3);
        r0.append(")) OR (NOT ");
        r0.append("?");
        r0.append(" AND entityId NOT IN (");
        int r2 = r15.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append("))) ");
        int r5 = r4 + 9;
        final RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), ((r6 + r5) + r3) + r2);
        if (r10 != null) goto L5;
        r1.bindNull(1);
    L7:
        if (r10 != null) goto L9;
        r1.bindNull(2);
    L10:
        r1.bindLong(3, r9);
        r1.bindLong(4, r13 ? 1 : 0);
        r1.bindLong(5, r12 ? 1 : 0);
        Iterator r17 = r15.iterator();
        int r18 = 6;
    L12:
        if (r17.hasNext() == false) goto L18;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L16;
        r1.bindNull(r18);
    L17:
        r18 = r18 + 1;
        goto L12
    L16:
        r1.bindString(r18, r7);
        goto L17
    L18:
        r1.bindLong(r4 + 6, r12 ? 1 : 0);
        int r19 = r4 + 7;
        Iterator r110 = r15.iterator();
        int r8 = r19;
    L20:
        if (r110.hasNext() == false) goto L26;
        String r20 = (String) ZeusTransformUtils.preCheckCast(r110.next(), String.class, "com.obric.memorydata.plugin");
        if (r20 != null) goto L24;
        r1.bindNull(r8);
    L25:
        r8 = r8 + 1;
        goto L20
    L24:
        r1.bindString(r8, r20);
        goto L25
    L26:
        r1.bindLong(r19 + r4, r13 ? 1 : 0);
        r1.bindLong((r4 + 8) + r4, r12 ? 1 : 0);
        int r21 = r5 + r4;
        Iterator r22 = r15.iterator();
        int r111 = r21;
    L28:
        if (r22.hasNext() == false) goto L34;
        String r112 = (String) ZeusTransformUtils.preCheckCast(r22.next(), String.class, "com.obric.memorydata.plugin");
        if (r112 != null) goto L32;
        r1.bindNull(r111);
    L33:
        r111 = r111 + 1;
        goto L28
    L32:
        r1.bindString(r111, r112);
        goto L33
    L34:
        r1.bindLong(r21 + r4, r12 ? 1 : 0);
        int r23 = ((r4 + 10) + r4) + r4;
        Iterator r113 = r15.iterator();
    L36:
        if (r113.hasNext() == false) goto L43;
        String r114 = (String) ZeusTransformUtils.preCheckCast(r113.next(), String.class, "com.obric.memorydata.plugin");
        if (r114 != null) goto L40;
        r1.bindNull(r23);
    L41:
        r23 = r23 + 1;
        goto L36
    L40:
        r1.bindString(r23, r114);
        goto L41
    L43:
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new AnonymousClass19(this, r1), r16);
    L9:
        r1.bindString(2, r10);
        goto L10
    L5:
        r1.bindString(1, r10);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public i<Integer> getInfoTypeMemoryCount() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM RawMemoryEntity WHERE memoryType = 10101 OR memoryType = 10102 OR memoryType = 10103 OR memoryType = 10104 OR memoryType = 10105 ORDER BY modifyTime DESC", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"RawMemoryEntity"}, new AnonymousClass6(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return MemoryEntityRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public List<RawMemoryEntity> getLatestMemory() {
        return MemoryEntityRawDbDao.DefaultImpls.getLatestMemory(this);
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

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public List<RawMemoryEntity> getMemoryByType(int r104) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntity WHERE memoryType = ?", 1);
        r1.bindLong(1, r104);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L199
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L199
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L199
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L199
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L199
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L199
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L199
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L199
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L199
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "memoryType");     // Catch: Throwable -> L199
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "productType");     // Catch: Throwable -> L199
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, "startDate");     // Catch: Throwable -> L199
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "startTime");     // Catch: Throwable -> L199
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "endDate");     // Catch: Throwable -> L199
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "endTime");     // Catch: Throwable -> L197
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "sourceLinkType");     // Catch: Throwable -> L197
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "sourceLink");     // Catch: Throwable -> L197
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "screenshot");     // Catch: Throwable -> L197
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "locations");     // Catch: Throwable -> L197
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "summary");     // Catch: Throwable -> L197
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "fullContent");     // Catch: Throwable -> L197
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "key1");     // Catch: Throwable -> L197
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "key2");     // Catch: Throwable -> L197
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "key3");     // Catch: Throwable -> L197
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "key4");     // Catch: Throwable -> L197
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "key5");     // Catch: Throwable -> L197
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "keyword1");     // Catch: Throwable -> L197
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "keyword2");     // Catch: Throwable -> L197
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, "keyword3");     // Catch: Throwable -> L197
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, "keyword4");     // Catch: Throwable -> L197
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "keyword5");     // Catch: Throwable -> L197
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "keyword6");     // Catch: Throwable -> L197
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "semantic1");     // Catch: Throwable -> L197
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, "semantic2");     // Catch: Throwable -> L197
        int r37 = CursorUtil.getColumnIndexOrThrow(r5, "keywordAndSemantic1");     // Catch: Throwable -> L197
        int r38 = CursorUtil.getColumnIndexOrThrow(r5, "keywordAndSemantic2");     // Catch: Throwable -> L197
        int r39 = CursorUtil.getColumnIndexOrThrow(r5, "sourceText");     // Catch: Throwable -> L197
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "sourcePackageName");     // Catch: Throwable -> L197
        int r41 = CursorUtil.getColumnIndexOrThrow(r5, "sourceAppName");     // Catch: Throwable -> L197
        int r42 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L197
        int r43 = CursorUtil.getColumnIndexOrThrow(r5, "sourceQuery");     // Catch: Throwable -> L197
        int r44 = CursorUtil.getColumnIndexOrThrow(r5, MemoryListActivity.JUMP_FROM_DETAIL);     // Catch: Throwable -> L197
        int r45 = CursorUtil.getColumnIndexOrThrow(r5, "detailStatus");     // Catch: Throwable -> L197
        int r46 = CursorUtil.getColumnIndexOrThrow(r5, "contentWithTime");     // Catch: Throwable -> L197
        int r47 = CursorUtil.getColumnIndexOrThrow(r5, "userEdit");     // Catch: Throwable -> L197
        int r48 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L197
        int r49 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L197
        int r50 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L197
        int r51 = r4;
        ArrayList r52 = new ArrayList(r5.getCount());     // Catch: Throwable -> L197
    L6:
        if (r5.moveToNext() == false) goto L195;
        long r53 = r5.getLong(r0);     // Catch: Throwable -> L197
        if (r5.isNull(r6) == false) goto L11;
        String r55 = null;
    L12:
        long r56 = r5.getLong(r7);     // Catch: Throwable -> L197
        long r58 = r5.getLong(r8);     // Catch: Throwable -> L197
        int r60 = r5.getInt(r9);     // Catch: Throwable -> L197
        long r61 = r5.getLong(r10);     // Catch: Throwable -> L197
        if (r5.isNull(r11) == false) goto L15;
        String r63 = null;
    L16:
        int r64 = r5.getInt(r12);     // Catch: Throwable -> L197
        if (r5.isNull(r13) == false) goto L19;
        String r65 = null;
    L20:
        int r66 = r5.getInt(r14);     // Catch: Throwable -> L197
        int r67 = r5.getInt(r15);     // Catch: Throwable -> L197
        if (r5.isNull(r2) == false) goto L23;
        Long r68 = null;
    L25:
        if (r5.isNull(r3) == false) goto L27;
        Long r69 = null;
    L29:
        if (r5.isNull(r51) == false) goto L32;
        Long r70 = null;
    L31:
        int r102 = r17;
        int r110 = r0;
        if (r5.isNull(r102) == false) goto L37;
        Long r71 = null;
    L36:
        int r103 = r18;
        if (r5.isNull(r103) == false) goto L42;
        String r72 = null;
    L41:
        int r105 = r19;
        if (r5.isNull(r105) == false) goto L47;
        String r73 = null;
    L46:
        int r106 = r20;
        if (r5.isNull(r106) == false) goto L52;
        String r74 = null;
    L51:
        int r107 = r21;
        if (r5.isNull(r107) == false) goto L57;
        String r75 = null;
    L56:
        int r108 = r22;
        if (r5.isNull(r108) == false) goto L62;
        String r76 = null;
    L61:
        int r109 = r23;
        if (r5.isNull(r109) == false) goto L67;
        String r77 = null;
    L66:
        int r1010 = r24;
        if (r5.isNull(r1010) == false) goto L72;
        String r78 = null;
    L71:
        int r1011 = r25;
        if (r5.isNull(r1011) == false) goto L77;
        String r79 = null;
    L76:
        int r1012 = r26;
        if (r5.isNull(r1012) == false) goto L82;
        String r80 = null;
    L81:
        int r1013 = r27;
        if (r5.isNull(r1013) == false) goto L87;
        String r81 = null;
    L86:
        int r1014 = r28;
        if (r5.isNull(r1014) == false) goto L92;
        String r82 = null;
    L91:
        int r1015 = r29;
        if (r5.isNull(r1015) == false) goto L97;
        String r83 = null;
    L96:
        int r1016 = r30;
        if (r5.isNull(r1016) == false) goto L102;
        String r84 = null;
    L101:
        int r1017 = r31;
        if (r5.isNull(r1017) == false) goto L107;
        String r85 = null;
    L106:
        int r1018 = r32;
        if (r5.isNull(r1018) == false) goto L112;
        String r86 = null;
    L111:
        int r1019 = r33;
        if (r5.isNull(r1019) == false) goto L117;
        String r87 = null;
    L116:
        int r1020 = r34;
        if (r5.isNull(r1020) == false) goto L122;
        String r88 = null;
    L121:
        int r1021 = r35;
        if (r5.isNull(r1021) == false) goto L127;
        String r89 = null;
    L126:
        int r1022 = r36;
        if (r5.isNull(r1022) == false) goto L132;
        String r90 = null;
    L131:
        int r1023 = r37;
        if (r5.isNull(r1023) == false) goto L137;
        String r91 = null;
    L136:
        int r1024 = r38;
        if (r5.isNull(r1024) == false) goto L142;
        String r92 = null;
    L141:
        int r1025 = r39;
        if (r5.isNull(r1025) == false) goto L147;
        String r93 = null;
    L146:
        int r1026 = r40;
        if (r5.isNull(r1026) == false) goto L152;
        String r94 = null;
    L151:
        int r1027 = r41;
        if (r5.isNull(r1027) == false) goto L157;
        String r95 = null;
    L156:
        int r1028 = r42;
        if (r5.isNull(r1028) == false) goto L162;
        String r96 = null;
    L161:
        int r1029 = r43;
        if (r5.isNull(r1029) == false) goto L167;
        String r97 = null;
    L166:
        int r1030 = r44;
        if (r5.isNull(r1030) == false) goto L172;
        String r98 = null;
    L171:
        int r1031 = r45;
        int r99 = r5.getInt(r1031);     // Catch: Throwable -> L197
        r46 = r46;
        if (r5.isNull(r46) == false) goto L176;
        String r100 = null;
    L178:
        if (r5.getInt(r47) == 0) goto L180;
        boolean r101 = true;
    L181:
        RawMemoryEntity r54 = new RawMemoryEntity(r53, r55, r56, r58, r60, r61, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101);     // Catch: Throwable -> L197
        int r57 = r2;
        int r59 = r48;
        if (r5.isNull(r59) == false) goto L184;
        Integer r62 = null;
    L185:
        r54.setPoisonLabel(r62);     // Catch: Throwable -> L197
        r49 = r49;
        if (r5.isNull(r49) == false) goto L188;
        Integer r111 = null;
    L189:
        r54.setPoisonLabelVersion(r111);     // Catch: Throwable -> L197
        r50 = r50;
        if (r5.isNull(r50) == false) goto L192;
        String r112 = null;
    L193:
        r54.setContentHash(r112);     // Catch: Throwable -> L197
        r52.add(r54);     // Catch: Throwable -> L197
        r0 = r110;
        r17 = r102;
        r18 = r103;
        r19 = r105;
        r20 = r106;
        r21 = r107;
        r22 = r108;
        r23 = r109;
        r24 = r1010;
        r25 = r1011;
        r26 = r1012;
        r27 = r1013;
        r28 = r1014;
        r29 = r1015;
        r30 = r1016;
        r31 = r1017;
        r32 = r1018;
        r33 = r1019;
        r34 = r1020;
        r35 = r1021;
        r36 = r1022;
        r37 = r1023;
        r38 = r1024;
        r39 = r1025;
        r40 = r1026;
        r41 = r1027;
        r42 = r1028;
        r43 = r1029;
        r44 = r1030;
        r45 = r1031;
        r2 = r57;
        r48 = r59;
        r51 = r51;
        goto L6
    L192:
        r112 = r5.getString(r50);     // Catch: Throwable -> L197
        goto L193
    L188:
        r111 = Integer.valueOf(r5.getInt(r49));     // Catch: Throwable -> L197
        goto L189
    L184:
        r62 = Integer.valueOf(r5.getInt(r59));     // Catch: Throwable -> L197
        goto L185
    L180:
        r101 = false;
        goto L181
    L176:
        r100 = r5.getString(r46);     // Catch: Throwable -> L197
        goto L178
    L172:
        r98 = r5.getString(r1030);     // Catch: Throwable -> L197
        goto L171
    L167:
        r97 = r5.getString(r1029);     // Catch: Throwable -> L197
        goto L166
    L162:
        r96 = r5.getString(r1028);     // Catch: Throwable -> L197
        goto L161
    L157:
        r95 = r5.getString(r1027);     // Catch: Throwable -> L197
        goto L156
    L152:
        r94 = r5.getString(r1026);     // Catch: Throwable -> L197
        goto L151
    L147:
        r93 = r5.getString(r1025);     // Catch: Throwable -> L197
        goto L146
    L142:
        r92 = r5.getString(r1024);     // Catch: Throwable -> L197
        goto L141
    L137:
        r91 = r5.getString(r1023);     // Catch: Throwable -> L197
        goto L136
    L132:
        r90 = r5.getString(r1022);     // Catch: Throwable -> L197
        goto L131
    L127:
        r89 = r5.getString(r1021);     // Catch: Throwable -> L197
        goto L126
    L122:
        r88 = r5.getString(r1020);     // Catch: Throwable -> L197
        goto L121
    L117:
        r87 = r5.getString(r1019);     // Catch: Throwable -> L197
        goto L116
    L112:
        r86 = r5.getString(r1018);     // Catch: Throwable -> L197
        goto L111
    L107:
        r85 = r5.getString(r1017);     // Catch: Throwable -> L197
        goto L106
    L102:
        r84 = r5.getString(r1016);     // Catch: Throwable -> L197
        goto L101
    L97:
        r83 = r5.getString(r1015);     // Catch: Throwable -> L197
        goto L96
    L92:
        r82 = r5.getString(r1014);     // Catch: Throwable -> L197
        goto L91
    L87:
        r81 = r5.getString(r1013);     // Catch: Throwable -> L197
        goto L86
    L82:
        r80 = r5.getString(r1012);     // Catch: Throwable -> L197
        goto L81
    L77:
        r79 = r5.getString(r1011);     // Catch: Throwable -> L197
        goto L76
    L72:
        r78 = r5.getString(r1010);     // Catch: Throwable -> L197
        goto L71
    L67:
        r77 = r5.getString(r109);     // Catch: Throwable -> L197
        goto L66
    L62:
        r76 = r5.getString(r108);     // Catch: Throwable -> L197
        goto L61
    L57:
        r75 = r5.getString(r107);     // Catch: Throwable -> L197
        goto L56
    L52:
        r74 = r5.getString(r106);     // Catch: Throwable -> L197
        goto L51
    L47:
        r73 = r5.getString(r105);     // Catch: Throwable -> L197
        goto L46
    L42:
        r72 = r5.getString(r103);     // Catch: Throwable -> L197
        goto L41
    L37:
        r71 = Long.valueOf(r5.getLong(r102));     // Catch: Throwable -> L197
        goto L36
    L32:
        r70 = Long.valueOf(r5.getLong(r51));     // Catch: Throwable -> L197
        goto L31
    L27:
        r69 = Long.valueOf(r5.getLong(r3));     // Catch: Throwable -> L197
        goto L29
    L23:
        r68 = Long.valueOf(r5.getLong(r2));     // Catch: Throwable -> L197
        goto L25
    L19:
        r65 = r5.getString(r13);     // Catch: Throwable -> L197
        goto L20
    L15:
        r63 = r5.getString(r11);     // Catch: Throwable -> L197
        goto L16
    L11:
        r55 = r5.getString(r6);     // Catch: Throwable -> L197
        goto L12
    L195:
        r5.close();
        r16.release();
        return r52;
    L197:
        th = th;
    L201:
        r5.close();
        r16.release();
        throw th;
    L199:
        th = th;
        r16 = r1;
        goto L201
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public List<cu> getMemoryMetaInfoList() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT entityId, type, packageName, logId FROM RawMemoryEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r9 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r3 = new ArrayList(r9.getCount());     // Catch: Throwable -> L22
    L4:
        if (r9.moveToNext() == false) goto L20;
        if (r9.isNull(0) == false) goto L9;
        String r4 = null;
    L10:
        int r5 = r9.getInt(1);     // Catch: Throwable -> L22
        if (r9.isNull(2) == false) goto L13;
        String r6 = null;
    L15:
        if (r9.isNull(3) == false) goto L17;
        String r7 = null;
    L18:
        r3.add(new cu(r4, r5, r6, r7));     // Catch: Throwable -> L22
        goto L4
    L17:
        r7 = r9.getString(3);     // Catch: Throwable -> L22
        goto L18
    L13:
        r6 = r9.getString(2);     // Catch: Throwable -> L22
        goto L15
    L9:
        r4 = r9.getString(0);     // Catch: Throwable -> L22
        goto L10
    L20:
        r9.close();
        r0.release();
        return r3;
    L22:
        th = move-exception;
        r9.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public PagingSource<Integer, RawMemoryEntity> getOrderTypeMemory() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntity WHERE memoryType = 10001 OR memoryType = 10002 OR memoryType = 10004 OR memoryType = 10003 OR memoryType = 10006 OR memoryType = 10005 ORDER BY createTime DESC", 0);
        final RoomDatabase r2 = this.__db;
        final String[] r3 = {"RawMemoryEntity"};
        return new AnonymousClass11(this, r0, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<String> getPackageNameList() {
        return MemoryEntityRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public List<RawMemoryEntity> getProactivePortraitMemory() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntity WHERE memoryType = 10105 AND productType = 11", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, OaidModel.KEY_ID);     // Catch: Throwable -> L199
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "entityId");     // Catch: Throwable -> L199
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "createTime");     // Catch: Throwable -> L199
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "modifyTime");     // Catch: Throwable -> L199
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, "type");     // Catch: Throwable -> L199
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "timestamp");     // Catch: Throwable -> L199
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L199
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "hashCodeValue");     // Catch: Throwable -> L199
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, Api.KEY_UUID);     // Catch: Throwable -> L199
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "memoryType");     // Catch: Throwable -> L199
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "productType");     // Catch: Throwable -> L199
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, "startDate");     // Catch: Throwable -> L199
        int r2 = CursorUtil.getColumnIndexOrThrow(r4, "startTime");     // Catch: Throwable -> L199
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "endDate");     // Catch: Throwable -> L199
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "endTime");     // Catch: Throwable -> L197
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "sourceLinkType");     // Catch: Throwable -> L197
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "sourceLink");     // Catch: Throwable -> L197
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "screenshot");     // Catch: Throwable -> L197
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "locations");     // Catch: Throwable -> L197
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "summary");     // Catch: Throwable -> L197
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "fullContent");     // Catch: Throwable -> L197
        int r24 = CursorUtil.getColumnIndexOrThrow(r4, "key1");     // Catch: Throwable -> L197
        int r25 = CursorUtil.getColumnIndexOrThrow(r4, "key2");     // Catch: Throwable -> L197
        int r26 = CursorUtil.getColumnIndexOrThrow(r4, "key3");     // Catch: Throwable -> L197
        int r27 = CursorUtil.getColumnIndexOrThrow(r4, "key4");     // Catch: Throwable -> L197
        int r28 = CursorUtil.getColumnIndexOrThrow(r4, "key5");     // Catch: Throwable -> L197
        int r29 = CursorUtil.getColumnIndexOrThrow(r4, "keyword1");     // Catch: Throwable -> L197
        int r30 = CursorUtil.getColumnIndexOrThrow(r4, "keyword2");     // Catch: Throwable -> L197
        int r31 = CursorUtil.getColumnIndexOrThrow(r4, "keyword3");     // Catch: Throwable -> L197
        int r32 = CursorUtil.getColumnIndexOrThrow(r4, "keyword4");     // Catch: Throwable -> L197
        int r33 = CursorUtil.getColumnIndexOrThrow(r4, "keyword5");     // Catch: Throwable -> L197
        int r34 = CursorUtil.getColumnIndexOrThrow(r4, "keyword6");     // Catch: Throwable -> L197
        int r35 = CursorUtil.getColumnIndexOrThrow(r4, "semantic1");     // Catch: Throwable -> L197
        int r36 = CursorUtil.getColumnIndexOrThrow(r4, "semantic2");     // Catch: Throwable -> L197
        int r37 = CursorUtil.getColumnIndexOrThrow(r4, "keywordAndSemantic1");     // Catch: Throwable -> L197
        int r38 = CursorUtil.getColumnIndexOrThrow(r4, "keywordAndSemantic2");     // Catch: Throwable -> L197
        int r39 = CursorUtil.getColumnIndexOrThrow(r4, "sourceText");     // Catch: Throwable -> L197
        int r40 = CursorUtil.getColumnIndexOrThrow(r4, "sourcePackageName");     // Catch: Throwable -> L197
        int r41 = CursorUtil.getColumnIndexOrThrow(r4, "sourceAppName");     // Catch: Throwable -> L197
        int r42 = CursorUtil.getColumnIndexOrThrow(r4, "logId");     // Catch: Throwable -> L197
        int r43 = CursorUtil.getColumnIndexOrThrow(r4, "sourceQuery");     // Catch: Throwable -> L197
        int r44 = CursorUtil.getColumnIndexOrThrow(r4, MemoryListActivity.JUMP_FROM_DETAIL);     // Catch: Throwable -> L197
        int r45 = CursorUtil.getColumnIndexOrThrow(r4, "detailStatus");     // Catch: Throwable -> L197
        int r46 = CursorUtil.getColumnIndexOrThrow(r4, "contentWithTime");     // Catch: Throwable -> L197
        int r47 = CursorUtil.getColumnIndexOrThrow(r4, "userEdit");     // Catch: Throwable -> L197
        int r48 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label");     // Catch: Throwable -> L197
        int r49 = CursorUtil.getColumnIndexOrThrow(r4, "poison_label_version");     // Catch: Throwable -> L197
        int r50 = CursorUtil.getColumnIndexOrThrow(r4, "content_hash");     // Catch: Throwable -> L197
        int r51 = r3;
        ArrayList r52 = new ArrayList(r4.getCount());     // Catch: Throwable -> L197
    L6:
        if (r4.moveToNext() == false) goto L195;
        long r53 = r4.getLong(r0);     // Catch: Throwable -> L197
        if (r4.isNull(r5) == false) goto L11;
        String r55 = null;
    L12:
        long r56 = r4.getLong(r6);     // Catch: Throwable -> L197
        long r58 = r4.getLong(r7);     // Catch: Throwable -> L197
        int r60 = r4.getInt(r8);     // Catch: Throwable -> L197
        long r61 = r4.getLong(r9);     // Catch: Throwable -> L197
        if (r4.isNull(r10) == false) goto L15;
        String r63 = null;
    L16:
        int r64 = r4.getInt(r11);     // Catch: Throwable -> L197
        if (r4.isNull(r12) == false) goto L19;
        String r65 = null;
    L20:
        int r66 = r4.getInt(r13);     // Catch: Throwable -> L197
        int r67 = r4.getInt(r14);     // Catch: Throwable -> L197
        if (r4.isNull(r15) == false) goto L23;
        Long r68 = null;
    L25:
        if (r4.isNull(r2) == false) goto L27;
        Long r69 = null;
    L29:
        if (r4.isNull(r51) == false) goto L32;
        Long r70 = null;
    L31:
        int r102 = r17;
        int r110 = r0;
        if (r4.isNull(r102) == false) goto L37;
        Long r71 = null;
    L36:
        int r103 = r18;
        if (r4.isNull(r103) == false) goto L42;
        String r72 = null;
    L41:
        int r104 = r19;
        if (r4.isNull(r104) == false) goto L47;
        String r73 = null;
    L46:
        int r105 = r20;
        if (r4.isNull(r105) == false) goto L52;
        String r74 = null;
    L51:
        int r106 = r21;
        if (r4.isNull(r106) == false) goto L57;
        String r75 = null;
    L56:
        int r107 = r22;
        if (r4.isNull(r107) == false) goto L62;
        String r76 = null;
    L61:
        int r108 = r23;
        if (r4.isNull(r108) == false) goto L67;
        String r77 = null;
    L66:
        int r109 = r24;
        if (r4.isNull(r109) == false) goto L72;
        String r78 = null;
    L71:
        int r1010 = r25;
        if (r4.isNull(r1010) == false) goto L77;
        String r79 = null;
    L76:
        int r1011 = r26;
        if (r4.isNull(r1011) == false) goto L82;
        String r80 = null;
    L81:
        int r1012 = r27;
        if (r4.isNull(r1012) == false) goto L87;
        String r81 = null;
    L86:
        int r1013 = r28;
        if (r4.isNull(r1013) == false) goto L92;
        String r82 = null;
    L91:
        int r1014 = r29;
        if (r4.isNull(r1014) == false) goto L97;
        String r83 = null;
    L96:
        int r1015 = r30;
        if (r4.isNull(r1015) == false) goto L102;
        String r84 = null;
    L101:
        int r1016 = r31;
        if (r4.isNull(r1016) == false) goto L107;
        String r85 = null;
    L106:
        int r1017 = r32;
        if (r4.isNull(r1017) == false) goto L112;
        String r86 = null;
    L111:
        int r1018 = r33;
        if (r4.isNull(r1018) == false) goto L117;
        String r87 = null;
    L116:
        int r1019 = r34;
        if (r4.isNull(r1019) == false) goto L122;
        String r88 = null;
    L121:
        int r1020 = r35;
        if (r4.isNull(r1020) == false) goto L127;
        String r89 = null;
    L126:
        int r1021 = r36;
        if (r4.isNull(r1021) == false) goto L132;
        String r90 = null;
    L131:
        int r1022 = r37;
        if (r4.isNull(r1022) == false) goto L137;
        String r91 = null;
    L136:
        int r1023 = r38;
        if (r4.isNull(r1023) == false) goto L142;
        String r92 = null;
    L141:
        int r1024 = r39;
        if (r4.isNull(r1024) == false) goto L147;
        String r93 = null;
    L146:
        int r1025 = r40;
        if (r4.isNull(r1025) == false) goto L152;
        String r94 = null;
    L151:
        int r1026 = r41;
        if (r4.isNull(r1026) == false) goto L157;
        String r95 = null;
    L156:
        int r1027 = r42;
        if (r4.isNull(r1027) == false) goto L162;
        String r96 = null;
    L161:
        int r1028 = r43;
        if (r4.isNull(r1028) == false) goto L167;
        String r97 = null;
    L166:
        int r1029 = r44;
        if (r4.isNull(r1029) == false) goto L172;
        String r98 = null;
    L171:
        int r1030 = r45;
        int r99 = r4.getInt(r1030);     // Catch: Throwable -> L197
        r46 = r46;
        if (r4.isNull(r46) == false) goto L176;
        String r100 = null;
    L178:
        if (r4.getInt(r47) == 0) goto L180;
        boolean r101 = true;
    L181:
        RawMemoryEntity r54 = new RawMemoryEntity(r53, r55, r56, r58, r60, r61, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101);     // Catch: Throwable -> L197
        int r57 = r2;
        int r59 = r48;
        if (r4.isNull(r59) == false) goto L184;
        Integer r62 = null;
    L185:
        r54.setPoisonLabel(r62);     // Catch: Throwable -> L197
        r49 = r49;
        if (r4.isNull(r49) == false) goto L188;
        Integer r111 = null;
    L189:
        r54.setPoisonLabelVersion(r111);     // Catch: Throwable -> L197
        r50 = r50;
        if (r4.isNull(r50) == false) goto L192;
        String r112 = null;
    L193:
        r54.setContentHash(r112);     // Catch: Throwable -> L197
        r52.add(r54);     // Catch: Throwable -> L197
        r0 = r110;
        r17 = r102;
        r18 = r103;
        r19 = r104;
        r20 = r105;
        r21 = r106;
        r22 = r107;
        r23 = r108;
        r24 = r109;
        r25 = r1010;
        r26 = r1011;
        r27 = r1012;
        r28 = r1013;
        r29 = r1014;
        r30 = r1015;
        r31 = r1016;
        r32 = r1017;
        r33 = r1018;
        r34 = r1019;
        r35 = r1020;
        r36 = r1021;
        r37 = r1022;
        r38 = r1023;
        r39 = r1024;
        r40 = r1025;
        r41 = r1026;
        r42 = r1027;
        r43 = r1028;
        r44 = r1029;
        r45 = r1030;
        r2 = r57;
        r48 = r59;
        r51 = r51;
        goto L6
    L192:
        r112 = r4.getString(r50);     // Catch: Throwable -> L197
        goto L193
    L188:
        r111 = Integer.valueOf(r4.getInt(r49));     // Catch: Throwable -> L197
        goto L189
    L184:
        r62 = Integer.valueOf(r4.getInt(r59));     // Catch: Throwable -> L197
        goto L185
    L180:
        r101 = false;
        goto L181
    L176:
        r100 = r4.getString(r46);     // Catch: Throwable -> L197
        goto L178
    L172:
        r98 = r4.getString(r1029);     // Catch: Throwable -> L197
        goto L171
    L167:
        r97 = r4.getString(r1028);     // Catch: Throwable -> L197
        goto L166
    L162:
        r96 = r4.getString(r1027);     // Catch: Throwable -> L197
        goto L161
    L157:
        r95 = r4.getString(r1026);     // Catch: Throwable -> L197
        goto L156
    L152:
        r94 = r4.getString(r1025);     // Catch: Throwable -> L197
        goto L151
    L147:
        r93 = r4.getString(r1024);     // Catch: Throwable -> L197
        goto L146
    L142:
        r92 = r4.getString(r1023);     // Catch: Throwable -> L197
        goto L141
    L137:
        r91 = r4.getString(r1022);     // Catch: Throwable -> L197
        goto L136
    L132:
        r90 = r4.getString(r1021);     // Catch: Throwable -> L197
        goto L131
    L127:
        r89 = r4.getString(r1020);     // Catch: Throwable -> L197
        goto L126
    L122:
        r88 = r4.getString(r1019);     // Catch: Throwable -> L197
        goto L121
    L117:
        r87 = r4.getString(r1018);     // Catch: Throwable -> L197
        goto L116
    L112:
        r86 = r4.getString(r1017);     // Catch: Throwable -> L197
        goto L111
    L107:
        r85 = r4.getString(r1016);     // Catch: Throwable -> L197
        goto L106
    L102:
        r84 = r4.getString(r1015);     // Catch: Throwable -> L197
        goto L101
    L97:
        r83 = r4.getString(r1014);     // Catch: Throwable -> L197
        goto L96
    L92:
        r82 = r4.getString(r1013);     // Catch: Throwable -> L197
        goto L91
    L87:
        r81 = r4.getString(r1012);     // Catch: Throwable -> L197
        goto L86
    L82:
        r80 = r4.getString(r1011);     // Catch: Throwable -> L197
        goto L81
    L77:
        r79 = r4.getString(r1010);     // Catch: Throwable -> L197
        goto L76
    L72:
        r78 = r4.getString(r109);     // Catch: Throwable -> L197
        goto L71
    L67:
        r77 = r4.getString(r108);     // Catch: Throwable -> L197
        goto L66
    L62:
        r76 = r4.getString(r107);     // Catch: Throwable -> L197
        goto L61
    L57:
        r75 = r4.getString(r106);     // Catch: Throwable -> L197
        goto L56
    L52:
        r74 = r4.getString(r105);     // Catch: Throwable -> L197
        goto L51
    L47:
        r73 = r4.getString(r104);     // Catch: Throwable -> L197
        goto L46
    L42:
        r72 = r4.getString(r103);     // Catch: Throwable -> L197
        goto L41
    L37:
        r71 = Long.valueOf(r4.getLong(r102));     // Catch: Throwable -> L197
        goto L36
    L32:
        r70 = Long.valueOf(r4.getLong(r51));     // Catch: Throwable -> L197
        goto L31
    L27:
        r69 = Long.valueOf(r4.getLong(r2));     // Catch: Throwable -> L197
        goto L29
    L23:
        r68 = Long.valueOf(r4.getLong(r15));     // Catch: Throwable -> L197
        goto L25
    L19:
        r65 = r4.getString(r12);     // Catch: Throwable -> L197
        goto L20
    L15:
        r63 = r4.getString(r10);     // Catch: Throwable -> L197
        goto L16
    L11:
        r55 = r4.getString(r5);     // Catch: Throwable -> L197
        goto L12
    L195:
        r4.close();
        r16.release();
        return r52;
    L197:
        th = th;
    L201:
        r4.close();
        r16.release();
        throw th;
    L199:
        th = th;
        r16 = r1;
        goto L201
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public List<RawMemoryEntity> getProactivePortraitMemoryWithLimit(int r104) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntity WHERE memoryType = 10105 AND productType = 11 ORDER BY modifyTime desc LIMIT ?", 1);
        r1.bindLong(1, r104);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L199
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L199
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L199
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L199
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L199
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L199
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L199
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L199
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L199
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "memoryType");     // Catch: Throwable -> L199
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "productType");     // Catch: Throwable -> L199
        int r2 = CursorUtil.getColumnIndexOrThrow(r5, "startDate");     // Catch: Throwable -> L199
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "startTime");     // Catch: Throwable -> L199
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "endDate");     // Catch: Throwable -> L199
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "endTime");     // Catch: Throwable -> L197
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "sourceLinkType");     // Catch: Throwable -> L197
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "sourceLink");     // Catch: Throwable -> L197
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "screenshot");     // Catch: Throwable -> L197
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "locations");     // Catch: Throwable -> L197
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "summary");     // Catch: Throwable -> L197
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "fullContent");     // Catch: Throwable -> L197
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "key1");     // Catch: Throwable -> L197
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "key2");     // Catch: Throwable -> L197
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "key3");     // Catch: Throwable -> L197
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "key4");     // Catch: Throwable -> L197
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "key5");     // Catch: Throwable -> L197
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "keyword1");     // Catch: Throwable -> L197
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "keyword2");     // Catch: Throwable -> L197
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, "keyword3");     // Catch: Throwable -> L197
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, "keyword4");     // Catch: Throwable -> L197
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "keyword5");     // Catch: Throwable -> L197
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "keyword6");     // Catch: Throwable -> L197
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "semantic1");     // Catch: Throwable -> L197
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, "semantic2");     // Catch: Throwable -> L197
        int r37 = CursorUtil.getColumnIndexOrThrow(r5, "keywordAndSemantic1");     // Catch: Throwable -> L197
        int r38 = CursorUtil.getColumnIndexOrThrow(r5, "keywordAndSemantic2");     // Catch: Throwable -> L197
        int r39 = CursorUtil.getColumnIndexOrThrow(r5, "sourceText");     // Catch: Throwable -> L197
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "sourcePackageName");     // Catch: Throwable -> L197
        int r41 = CursorUtil.getColumnIndexOrThrow(r5, "sourceAppName");     // Catch: Throwable -> L197
        int r42 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L197
        int r43 = CursorUtil.getColumnIndexOrThrow(r5, "sourceQuery");     // Catch: Throwable -> L197
        int r44 = CursorUtil.getColumnIndexOrThrow(r5, MemoryListActivity.JUMP_FROM_DETAIL);     // Catch: Throwable -> L197
        int r45 = CursorUtil.getColumnIndexOrThrow(r5, "detailStatus");     // Catch: Throwable -> L197
        int r46 = CursorUtil.getColumnIndexOrThrow(r5, "contentWithTime");     // Catch: Throwable -> L197
        int r47 = CursorUtil.getColumnIndexOrThrow(r5, "userEdit");     // Catch: Throwable -> L197
        int r48 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L197
        int r49 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L197
        int r50 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L197
        int r51 = r4;
        ArrayList r52 = new ArrayList(r5.getCount());     // Catch: Throwable -> L197
    L6:
        if (r5.moveToNext() == false) goto L195;
        long r53 = r5.getLong(r0);     // Catch: Throwable -> L197
        if (r5.isNull(r6) == false) goto L11;
        String r55 = null;
    L12:
        long r56 = r5.getLong(r7);     // Catch: Throwable -> L197
        long r58 = r5.getLong(r8);     // Catch: Throwable -> L197
        int r60 = r5.getInt(r9);     // Catch: Throwable -> L197
        long r61 = r5.getLong(r10);     // Catch: Throwable -> L197
        if (r5.isNull(r11) == false) goto L15;
        String r63 = null;
    L16:
        int r64 = r5.getInt(r12);     // Catch: Throwable -> L197
        if (r5.isNull(r13) == false) goto L19;
        String r65 = null;
    L20:
        int r66 = r5.getInt(r14);     // Catch: Throwable -> L197
        int r67 = r5.getInt(r15);     // Catch: Throwable -> L197
        if (r5.isNull(r2) == false) goto L23;
        Long r68 = null;
    L25:
        if (r5.isNull(r3) == false) goto L27;
        Long r69 = null;
    L29:
        if (r5.isNull(r51) == false) goto L32;
        Long r70 = null;
    L31:
        int r102 = r17;
        int r110 = r0;
        if (r5.isNull(r102) == false) goto L37;
        Long r71 = null;
    L36:
        int r103 = r18;
        if (r5.isNull(r103) == false) goto L42;
        String r72 = null;
    L41:
        int r105 = r19;
        if (r5.isNull(r105) == false) goto L47;
        String r73 = null;
    L46:
        int r106 = r20;
        if (r5.isNull(r106) == false) goto L52;
        String r74 = null;
    L51:
        int r107 = r21;
        if (r5.isNull(r107) == false) goto L57;
        String r75 = null;
    L56:
        int r108 = r22;
        if (r5.isNull(r108) == false) goto L62;
        String r76 = null;
    L61:
        int r109 = r23;
        if (r5.isNull(r109) == false) goto L67;
        String r77 = null;
    L66:
        int r1010 = r24;
        if (r5.isNull(r1010) == false) goto L72;
        String r78 = null;
    L71:
        int r1011 = r25;
        if (r5.isNull(r1011) == false) goto L77;
        String r79 = null;
    L76:
        int r1012 = r26;
        if (r5.isNull(r1012) == false) goto L82;
        String r80 = null;
    L81:
        int r1013 = r27;
        if (r5.isNull(r1013) == false) goto L87;
        String r81 = null;
    L86:
        int r1014 = r28;
        if (r5.isNull(r1014) == false) goto L92;
        String r82 = null;
    L91:
        int r1015 = r29;
        if (r5.isNull(r1015) == false) goto L97;
        String r83 = null;
    L96:
        int r1016 = r30;
        if (r5.isNull(r1016) == false) goto L102;
        String r84 = null;
    L101:
        int r1017 = r31;
        if (r5.isNull(r1017) == false) goto L107;
        String r85 = null;
    L106:
        int r1018 = r32;
        if (r5.isNull(r1018) == false) goto L112;
        String r86 = null;
    L111:
        int r1019 = r33;
        if (r5.isNull(r1019) == false) goto L117;
        String r87 = null;
    L116:
        int r1020 = r34;
        if (r5.isNull(r1020) == false) goto L122;
        String r88 = null;
    L121:
        int r1021 = r35;
        if (r5.isNull(r1021) == false) goto L127;
        String r89 = null;
    L126:
        int r1022 = r36;
        if (r5.isNull(r1022) == false) goto L132;
        String r90 = null;
    L131:
        int r1023 = r37;
        if (r5.isNull(r1023) == false) goto L137;
        String r91 = null;
    L136:
        int r1024 = r38;
        if (r5.isNull(r1024) == false) goto L142;
        String r92 = null;
    L141:
        int r1025 = r39;
        if (r5.isNull(r1025) == false) goto L147;
        String r93 = null;
    L146:
        int r1026 = r40;
        if (r5.isNull(r1026) == false) goto L152;
        String r94 = null;
    L151:
        int r1027 = r41;
        if (r5.isNull(r1027) == false) goto L157;
        String r95 = null;
    L156:
        int r1028 = r42;
        if (r5.isNull(r1028) == false) goto L162;
        String r96 = null;
    L161:
        int r1029 = r43;
        if (r5.isNull(r1029) == false) goto L167;
        String r97 = null;
    L166:
        int r1030 = r44;
        if (r5.isNull(r1030) == false) goto L172;
        String r98 = null;
    L171:
        int r1031 = r45;
        int r99 = r5.getInt(r1031);     // Catch: Throwable -> L197
        r46 = r46;
        if (r5.isNull(r46) == false) goto L176;
        String r100 = null;
    L178:
        if (r5.getInt(r47) == 0) goto L180;
        boolean r101 = true;
    L181:
        RawMemoryEntity r54 = new RawMemoryEntity(r53, r55, r56, r58, r60, r61, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101);     // Catch: Throwable -> L197
        int r57 = r2;
        int r59 = r48;
        if (r5.isNull(r59) == false) goto L184;
        Integer r62 = null;
    L185:
        r54.setPoisonLabel(r62);     // Catch: Throwable -> L197
        r49 = r49;
        if (r5.isNull(r49) == false) goto L188;
        Integer r111 = null;
    L189:
        r54.setPoisonLabelVersion(r111);     // Catch: Throwable -> L197
        r50 = r50;
        if (r5.isNull(r50) == false) goto L192;
        String r112 = null;
    L193:
        r54.setContentHash(r112);     // Catch: Throwable -> L197
        r52.add(r54);     // Catch: Throwable -> L197
        r0 = r110;
        r17 = r102;
        r18 = r103;
        r19 = r105;
        r20 = r106;
        r21 = r107;
        r22 = r108;
        r23 = r109;
        r24 = r1010;
        r25 = r1011;
        r26 = r1012;
        r27 = r1013;
        r28 = r1014;
        r29 = r1015;
        r30 = r1016;
        r31 = r1017;
        r32 = r1018;
        r33 = r1019;
        r34 = r1020;
        r35 = r1021;
        r36 = r1022;
        r37 = r1023;
        r38 = r1024;
        r39 = r1025;
        r40 = r1026;
        r41 = r1027;
        r42 = r1028;
        r43 = r1029;
        r44 = r1030;
        r45 = r1031;
        r2 = r57;
        r48 = r59;
        r51 = r51;
        goto L6
    L192:
        r112 = r5.getString(r50);     // Catch: Throwable -> L197
        goto L193
    L188:
        r111 = Integer.valueOf(r5.getInt(r49));     // Catch: Throwable -> L197
        goto L189
    L184:
        r62 = Integer.valueOf(r5.getInt(r59));     // Catch: Throwable -> L197
        goto L185
    L180:
        r101 = false;
        goto L181
    L176:
        r100 = r5.getString(r46);     // Catch: Throwable -> L197
        goto L178
    L172:
        r98 = r5.getString(r1030);     // Catch: Throwable -> L197
        goto L171
    L167:
        r97 = r5.getString(r1029);     // Catch: Throwable -> L197
        goto L166
    L162:
        r96 = r5.getString(r1028);     // Catch: Throwable -> L197
        goto L161
    L157:
        r95 = r5.getString(r1027);     // Catch: Throwable -> L197
        goto L156
    L152:
        r94 = r5.getString(r1026);     // Catch: Throwable -> L197
        goto L151
    L147:
        r93 = r5.getString(r1025);     // Catch: Throwable -> L197
        goto L146
    L142:
        r92 = r5.getString(r1024);     // Catch: Throwable -> L197
        goto L141
    L137:
        r91 = r5.getString(r1023);     // Catch: Throwable -> L197
        goto L136
    L132:
        r90 = r5.getString(r1022);     // Catch: Throwable -> L197
        goto L131
    L127:
        r89 = r5.getString(r1021);     // Catch: Throwable -> L197
        goto L126
    L122:
        r88 = r5.getString(r1020);     // Catch: Throwable -> L197
        goto L121
    L117:
        r87 = r5.getString(r1019);     // Catch: Throwable -> L197
        goto L116
    L112:
        r86 = r5.getString(r1018);     // Catch: Throwable -> L197
        goto L111
    L107:
        r85 = r5.getString(r1017);     // Catch: Throwable -> L197
        goto L106
    L102:
        r84 = r5.getString(r1016);     // Catch: Throwable -> L197
        goto L101
    L97:
        r83 = r5.getString(r1015);     // Catch: Throwable -> L197
        goto L96
    L92:
        r82 = r5.getString(r1014);     // Catch: Throwable -> L197
        goto L91
    L87:
        r81 = r5.getString(r1013);     // Catch: Throwable -> L197
        goto L86
    L82:
        r80 = r5.getString(r1012);     // Catch: Throwable -> L197
        goto L81
    L77:
        r79 = r5.getString(r1011);     // Catch: Throwable -> L197
        goto L76
    L72:
        r78 = r5.getString(r1010);     // Catch: Throwable -> L197
        goto L71
    L67:
        r77 = r5.getString(r109);     // Catch: Throwable -> L197
        goto L66
    L62:
        r76 = r5.getString(r108);     // Catch: Throwable -> L197
        goto L61
    L57:
        r75 = r5.getString(r107);     // Catch: Throwable -> L197
        goto L56
    L52:
        r74 = r5.getString(r106);     // Catch: Throwable -> L197
        goto L51
    L47:
        r73 = r5.getString(r105);     // Catch: Throwable -> L197
        goto L46
    L42:
        r72 = r5.getString(r103);     // Catch: Throwable -> L197
        goto L41
    L37:
        r71 = Long.valueOf(r5.getLong(r102));     // Catch: Throwable -> L197
        goto L36
    L32:
        r70 = Long.valueOf(r5.getLong(r51));     // Catch: Throwable -> L197
        goto L31
    L27:
        r69 = Long.valueOf(r5.getLong(r3));     // Catch: Throwable -> L197
        goto L29
    L23:
        r68 = Long.valueOf(r5.getLong(r2));     // Catch: Throwable -> L197
        goto L25
    L19:
        r65 = r5.getString(r13);     // Catch: Throwable -> L197
        goto L20
    L15:
        r63 = r5.getString(r11);     // Catch: Throwable -> L197
        goto L16
    L11:
        r55 = r5.getString(r6);     // Catch: Throwable -> L197
        goto L12
    L195:
        r5.close();
        r16.release();
        return r52;
    L197:
        th = th;
    L201:
        r5.close();
        r16.release();
        throw th;
    L199:
        th = th;
        r16 = r1;
        goto L201
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public RawMemoryEntity getSameMemory(String r1, String[] r2) {
        return MemoryEntityRawDbDao.DefaultImpls.getSameMemory(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MemoryEntityRawDbDao.DefaultImpls.getTableName(this);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public List<RawMemoryEntity> getTimeSensitiveMemory() {
        return MemoryEntityRawDbDao.DefaultImpls.getTimeSensitiveMemory(this);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public List<String> getUUIDListByEntityIds(List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT uuid FROM RawMemoryEntity WHERE entityId IN (");
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

    public long insert(RawMemoryEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawMemoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r3, RawMemoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<RawMemoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawMemoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<RawMemoryEntity> queryAll() {
        return MemoryEntityRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MemoryEntityRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public RawMemoryEntity queryByEntityId(String r102) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntity WHERE entityId = ? LIMIT 1", 1);
        if (r102 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L174
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L174
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L174
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L174
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L174
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L174
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L174
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L174
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L174
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "memoryType");     // Catch: Throwable -> L174
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "productType");     // Catch: Throwable -> L174
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "startDate");     // Catch: Throwable -> L174
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "startTime");     // Catch: Throwable -> L174
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "endDate");     // Catch: Throwable -> L174
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "endTime");     // Catch: Throwable -> L172
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "sourceLinkType");     // Catch: Throwable -> L172
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "sourceLink");     // Catch: Throwable -> L172
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "screenshot");     // Catch: Throwable -> L172
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "locations");     // Catch: Throwable -> L172
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "summary");     // Catch: Throwable -> L172
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "fullContent");     // Catch: Throwable -> L172
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "key1");     // Catch: Throwable -> L172
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "key2");     // Catch: Throwable -> L172
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "key3");     // Catch: Throwable -> L172
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "key4");     // Catch: Throwable -> L172
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "key5");     // Catch: Throwable -> L172
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "keyword1");     // Catch: Throwable -> L172
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "keyword2");     // Catch: Throwable -> L172
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, "keyword3");     // Catch: Throwable -> L172
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, "keyword4");     // Catch: Throwable -> L172
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "keyword5");     // Catch: Throwable -> L172
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "keyword6");     // Catch: Throwable -> L172
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "semantic1");     // Catch: Throwable -> L172
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, "semantic2");     // Catch: Throwable -> L172
        int r37 = CursorUtil.getColumnIndexOrThrow(r5, "keywordAndSemantic1");     // Catch: Throwable -> L172
        int r38 = CursorUtil.getColumnIndexOrThrow(r5, "keywordAndSemantic2");     // Catch: Throwable -> L172
        int r39 = CursorUtil.getColumnIndexOrThrow(r5, "sourceText");     // Catch: Throwable -> L172
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "sourcePackageName");     // Catch: Throwable -> L172
        int r41 = CursorUtil.getColumnIndexOrThrow(r5, "sourceAppName");     // Catch: Throwable -> L172
        int r42 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L172
        int r43 = CursorUtil.getColumnIndexOrThrow(r5, "sourceQuery");     // Catch: Throwable -> L172
        int r44 = CursorUtil.getColumnIndexOrThrow(r5, MemoryListActivity.JUMP_FROM_DETAIL);     // Catch: Throwable -> L172
        int r45 = CursorUtil.getColumnIndexOrThrow(r5, "detailStatus");     // Catch: Throwable -> L172
        int r46 = CursorUtil.getColumnIndexOrThrow(r5, "contentWithTime");     // Catch: Throwable -> L172
        int r47 = CursorUtil.getColumnIndexOrThrow(r5, "userEdit");     // Catch: Throwable -> L172
        int r48 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L172
        int r49 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L172
        int r50 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L172
        if (r5.moveToFirst() == false) goto L169;
        long r52 = r5.getLong(r0);     // Catch: Throwable -> L172
        if (r5.isNull(r6) == false) goto L14;
        String r54 = null;
    L15:
        long r55 = r5.getLong(r7);     // Catch: Throwable -> L172
        long r57 = r5.getLong(r8);     // Catch: Throwable -> L172
        int r59 = r5.getInt(r9);     // Catch: Throwable -> L172
        long r60 = r5.getLong(r10);     // Catch: Throwable -> L172
        if (r5.isNull(r11) == false) goto L18;
        String r62 = null;
    L19:
        int r63 = r5.getInt(r12);     // Catch: Throwable -> L172
        if (r5.isNull(r13) == false) goto L22;
        String r64 = null;
    L23:
        int r65 = r5.getInt(r14);     // Catch: Throwable -> L172
        int r66 = r5.getInt(r15);     // Catch: Throwable -> L172
        if (r5.isNull(r1) == false) goto L26;
        Long r67 = null;
    L28:
        if (r5.isNull(r3) == false) goto L30;
        Long r68 = null;
    L32:
        if (r5.isNull(r4) == false) goto L34;
        Long r69 = null;
    L36:
        if (r5.isNull(r17) == false) goto L38;
        Long r70 = null;
    L40:
        if (r5.isNull(r18) == false) goto L42;
        String r71 = null;
    L44:
        if (r5.isNull(r19) == false) goto L46;
        String r72 = null;
    L48:
        if (r5.isNull(r20) == false) goto L50;
        String r73 = null;
    L52:
        if (r5.isNull(r21) == false) goto L54;
        String r74 = null;
    L56:
        if (r5.isNull(r22) == false) goto L58;
        String r75 = null;
    L60:
        if (r5.isNull(r23) == false) goto L62;
        String r76 = null;
    L64:
        if (r5.isNull(r24) == false) goto L66;
        String r77 = null;
    L68:
        if (r5.isNull(r25) == false) goto L70;
        String r78 = null;
    L72:
        if (r5.isNull(r26) == false) goto L74;
        String r79 = null;
    L76:
        if (r5.isNull(r27) == false) goto L78;
        String r80 = null;
    L80:
        if (r5.isNull(r28) == false) goto L82;
        String r81 = null;
    L84:
        if (r5.isNull(r29) == false) goto L86;
        String r82 = null;
    L88:
        if (r5.isNull(r30) == false) goto L90;
        String r83 = null;
    L92:
        if (r5.isNull(r31) == false) goto L94;
        String r84 = null;
    L96:
        if (r5.isNull(r32) == false) goto L98;
        String r85 = null;
    L100:
        if (r5.isNull(r33) == false) goto L102;
        String r86 = null;
    L104:
        if (r5.isNull(r34) == false) goto L106;
        String r87 = null;
    L108:
        if (r5.isNull(r35) == false) goto L110;
        String r88 = null;
    L112:
        if (r5.isNull(r36) == false) goto L114;
        String r89 = null;
    L116:
        if (r5.isNull(r37) == false) goto L118;
        String r90 = null;
    L120:
        if (r5.isNull(r38) == false) goto L122;
        String r91 = null;
    L124:
        if (r5.isNull(r39) == false) goto L126;
        String r92 = null;
    L128:
        if (r5.isNull(r40) == false) goto L130;
        String r93 = null;
    L132:
        if (r5.isNull(r41) == false) goto L134;
        String r94 = null;
    L136:
        if (r5.isNull(r42) == false) goto L138;
        String r95 = null;
    L140:
        if (r5.isNull(r43) == false) goto L142;
        String r96 = null;
    L144:
        if (r5.isNull(r44) == false) goto L146;
        String r97 = null;
    L147:
        int r98 = r5.getInt(r45);     // Catch: Throwable -> L172
        if (r5.isNull(r46) == false) goto L150;
        String r99 = null;
    L152:
        if (r5.getInt(r47) == 0) goto L154;
        boolean r100 = true;
    L155:
        RawMemoryEntity r51 = new RawMemoryEntity(r52, r54, r55, r57, r59, r60, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100);     // Catch: Throwable -> L172
        if (r5.isNull(r48) == false) goto L158;
        Integer r53 = null;
    L159:
        r51.setPoisonLabel(r53);     // Catch: Throwable -> L172
        if (r5.isNull(r49) == false) goto L162;
        Integer r56 = null;
    L163:
        r51.setPoisonLabelVersion(r56);     // Catch: Throwable -> L172
        if (r5.isNull(r50) == false) goto L166;
        String r58 = null;
    L167:
        r51.setContentHash(r58);     // Catch: Throwable -> L172
        RawMemoryEntity r61 = r51;
    L170:
        r5.close();
        r16.release();
        return r61;
    L166:
        r58 = r5.getString(r50);     // Catch: Throwable -> L172
        goto L167
    L162:
        r56 = Integer.valueOf(r5.getInt(r49));     // Catch: Throwable -> L172
        goto L163
    L158:
        r53 = Integer.valueOf(r5.getInt(r48));     // Catch: Throwable -> L172
        goto L159
    L154:
        r100 = false;
        goto L155
    L150:
        r99 = r5.getString(r46);     // Catch: Throwable -> L172
        goto L152
    L146:
        r97 = r5.getString(r44);     // Catch: Throwable -> L172
        goto L147
    L142:
        r96 = r5.getString(r43);     // Catch: Throwable -> L172
        goto L144
    L138:
        r95 = r5.getString(r42);     // Catch: Throwable -> L172
        goto L140
    L134:
        r94 = r5.getString(r41);     // Catch: Throwable -> L172
        goto L136
    L130:
        r93 = r5.getString(r40);     // Catch: Throwable -> L172
        goto L132
    L126:
        r92 = r5.getString(r39);     // Catch: Throwable -> L172
        goto L128
    L122:
        r91 = r5.getString(r38);     // Catch: Throwable -> L172
        goto L124
    L118:
        r90 = r5.getString(r37);     // Catch: Throwable -> L172
        goto L120
    L114:
        r89 = r5.getString(r36);     // Catch: Throwable -> L172
        goto L116
    L110:
        r88 = r5.getString(r35);     // Catch: Throwable -> L172
        goto L112
    L106:
        r87 = r5.getString(r34);     // Catch: Throwable -> L172
        goto L108
    L102:
        r86 = r5.getString(r33);     // Catch: Throwable -> L172
        goto L104
    L98:
        r85 = r5.getString(r32);     // Catch: Throwable -> L172
        goto L100
    L94:
        r84 = r5.getString(r31);     // Catch: Throwable -> L172
        goto L96
    L90:
        r83 = r5.getString(r30);     // Catch: Throwable -> L172
        goto L92
    L86:
        r82 = r5.getString(r29);     // Catch: Throwable -> L172
        goto L88
    L82:
        r81 = r5.getString(r28);     // Catch: Throwable -> L172
        goto L84
    L78:
        r80 = r5.getString(r27);     // Catch: Throwable -> L172
        goto L80
    L74:
        r79 = r5.getString(r26);     // Catch: Throwable -> L172
        goto L76
    L70:
        r78 = r5.getString(r25);     // Catch: Throwable -> L172
        goto L72
    L66:
        r77 = r5.getString(r24);     // Catch: Throwable -> L172
        goto L68
    L62:
        r76 = r5.getString(r23);     // Catch: Throwable -> L172
        goto L64
    L58:
        r75 = r5.getString(r22);     // Catch: Throwable -> L172
        goto L60
    L54:
        r74 = r5.getString(r21);     // Catch: Throwable -> L172
        goto L56
    L50:
        r73 = r5.getString(r20);     // Catch: Throwable -> L172
        goto L52
    L46:
        r72 = r5.getString(r19);     // Catch: Throwable -> L172
        goto L48
    L42:
        r71 = r5.getString(r18);     // Catch: Throwable -> L172
        goto L44
    L38:
        r70 = Long.valueOf(r5.getLong(r17));     // Catch: Throwable -> L172
        goto L40
    L34:
        r69 = Long.valueOf(r5.getLong(r4));     // Catch: Throwable -> L172
        goto L36
    L30:
        r68 = Long.valueOf(r5.getLong(r3));     // Catch: Throwable -> L172
        goto L32
    L26:
        r67 = Long.valueOf(r5.getLong(r1));     // Catch: Throwable -> L172
        goto L28
    L22:
        r64 = r5.getString(r13);     // Catch: Throwable -> L172
        goto L23
    L18:
        r62 = r5.getString(r11);     // Catch: Throwable -> L172
        goto L19
    L14:
        r54 = r5.getString(r6);     // Catch: Throwable -> L172
        goto L15
    L169:
        r61 = null;
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
        r2.bindString(1, r102);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<RawMemoryEntity> queryByEntityId(String r1, String r2) {
        return MemoryEntityRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<RawMemoryEntity> queryByEntityIdList(List<String> r3) {
        return MemoryEntityRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<RawMemoryEntity> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return MemoryEntityRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public List<RawMemoryEntity> queryByEntityIds(List<String> r104) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r104, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM RawMemoryEntity WHERE entityId in (");
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
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L207
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "entityId");     // Catch: Throwable -> L207
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "createTime");     // Catch: Throwable -> L207
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "modifyTime");     // Catch: Throwable -> L207
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "type");     // Catch: Throwable -> L207
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "timestamp");     // Catch: Throwable -> L207
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L207
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "hashCodeValue");     // Catch: Throwable -> L207
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, Api.KEY_UUID);     // Catch: Throwable -> L207
        int r17 = CursorUtil.getColumnIndexOrThrow(r8, "memoryType");     // Catch: Throwable -> L207
        int r18 = CursorUtil.getColumnIndexOrThrow(r8, "productType");     // Catch: Throwable -> L207
        int r19 = CursorUtil.getColumnIndexOrThrow(r8, "startDate");     // Catch: Throwable -> L207
        int r20 = CursorUtil.getColumnIndexOrThrow(r8, "startTime");     // Catch: Throwable -> L207
        int r21 = CursorUtil.getColumnIndexOrThrow(r8, "endDate");     // Catch: Throwable -> L207
        RoomSQLiteQuery r110 = r5;
        int r111 = CursorUtil.getColumnIndexOrThrow(r8, "endTime");     // Catch: Throwable -> L205
        int r112 = CursorUtil.getColumnIndexOrThrow(r8, "sourceLinkType");     // Catch: Throwable -> L205
        int r113 = CursorUtil.getColumnIndexOrThrow(r8, "sourceLink");     // Catch: Throwable -> L205
        int r22 = CursorUtil.getColumnIndexOrThrow(r8, "screenshot");     // Catch: Throwable -> L205
        int r23 = CursorUtil.getColumnIndexOrThrow(r8, "locations");     // Catch: Throwable -> L205
        int r24 = CursorUtil.getColumnIndexOrThrow(r8, "summary");     // Catch: Throwable -> L205
        int r25 = CursorUtil.getColumnIndexOrThrow(r8, "fullContent");     // Catch: Throwable -> L205
        int r26 = CursorUtil.getColumnIndexOrThrow(r8, "key1");     // Catch: Throwable -> L205
        int r27 = CursorUtil.getColumnIndexOrThrow(r8, "key2");     // Catch: Throwable -> L205
        int r28 = CursorUtil.getColumnIndexOrThrow(r8, "key3");     // Catch: Throwable -> L205
        int r29 = CursorUtil.getColumnIndexOrThrow(r8, "key4");     // Catch: Throwable -> L205
        int r210 = CursorUtil.getColumnIndexOrThrow(r8, "key5");     // Catch: Throwable -> L205
        int r211 = CursorUtil.getColumnIndexOrThrow(r8, "keyword1");     // Catch: Throwable -> L205
        int r30 = CursorUtil.getColumnIndexOrThrow(r8, "keyword2");     // Catch: Throwable -> L205
        int r31 = CursorUtil.getColumnIndexOrThrow(r8, "keyword3");     // Catch: Throwable -> L205
        int r32 = CursorUtil.getColumnIndexOrThrow(r8, "keyword4");     // Catch: Throwable -> L205
        int r33 = CursorUtil.getColumnIndexOrThrow(r8, "keyword5");     // Catch: Throwable -> L205
        int r34 = CursorUtil.getColumnIndexOrThrow(r8, "keyword6");     // Catch: Throwable -> L205
        int r35 = CursorUtil.getColumnIndexOrThrow(r8, "semantic1");     // Catch: Throwable -> L205
        int r36 = CursorUtil.getColumnIndexOrThrow(r8, "semantic2");     // Catch: Throwable -> L205
        int r37 = CursorUtil.getColumnIndexOrThrow(r8, "keywordAndSemantic1");     // Catch: Throwable -> L205
        int r38 = CursorUtil.getColumnIndexOrThrow(r8, "keywordAndSemantic2");     // Catch: Throwable -> L205
        int r39 = CursorUtil.getColumnIndexOrThrow(r8, "sourceText");     // Catch: Throwable -> L205
        int r40 = CursorUtil.getColumnIndexOrThrow(r8, "sourcePackageName");     // Catch: Throwable -> L205
        int r41 = CursorUtil.getColumnIndexOrThrow(r8, "sourceAppName");     // Catch: Throwable -> L205
        int r42 = CursorUtil.getColumnIndexOrThrow(r8, "logId");     // Catch: Throwable -> L205
        int r43 = CursorUtil.getColumnIndexOrThrow(r8, "sourceQuery");     // Catch: Throwable -> L205
        int r44 = CursorUtil.getColumnIndexOrThrow(r8, MemoryListActivity.JUMP_FROM_DETAIL);     // Catch: Throwable -> L205
        int r45 = CursorUtil.getColumnIndexOrThrow(r8, "detailStatus");     // Catch: Throwable -> L205
        int r46 = CursorUtil.getColumnIndexOrThrow(r8, "contentWithTime");     // Catch: Throwable -> L205
        int r47 = CursorUtil.getColumnIndexOrThrow(r8, "userEdit");     // Catch: Throwable -> L205
        int r48 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label");     // Catch: Throwable -> L205
        int r49 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label_version");     // Catch: Throwable -> L205
        int r50 = CursorUtil.getColumnIndexOrThrow(r8, "content_hash");     // Catch: Throwable -> L205
        int r51 = r21;
        ArrayList r52 = new ArrayList(r8.getCount());     // Catch: Throwable -> L205
    L14:
        if (r8.moveToNext() == false) goto L203;
        long r53 = r8.getLong(r0);     // Catch: Throwable -> L205
        if (r8.isNull(r9) == false) goto L19;
        String r55 = null;
    L20:
        long r56 = r8.getLong(r10);     // Catch: Throwable -> L205
        long r58 = r8.getLong(r11);     // Catch: Throwable -> L205
        int r60 = r8.getInt(r12);     // Catch: Throwable -> L205
        long r61 = r8.getLong(r13);     // Catch: Throwable -> L205
        if (r8.isNull(r14) == false) goto L23;
        String r63 = null;
    L24:
        int r64 = r8.getInt(r15);     // Catch: Throwable -> L205
        if (r8.isNull(r16) == false) goto L27;
        String r65 = null;
    L28:
        int r66 = r8.getInt(r17);     // Catch: Throwable -> L205
        int r67 = r8.getInt(r18);     // Catch: Throwable -> L205
        if (r8.isNull(r19) == false) goto L31;
        Long r68 = null;
    L33:
        if (r8.isNull(r20) == false) goto L35;
        Long r69 = null;
    L37:
        if (r8.isNull(r51) == false) goto L40;
        Long r70 = null;
    L39:
        int r102 = r111;
        int r114 = r0;
        if (r8.isNull(r102) == false) goto L45;
        Long r71 = null;
    L44:
        int r103 = r112;
        if (r8.isNull(r103) == false) goto L50;
        String r72 = null;
    L49:
        int r105 = r113;
        if (r8.isNull(r105) == false) goto L55;
        String r73 = null;
    L54:
        int r106 = r22;
        if (r8.isNull(r106) == false) goto L60;
        String r74 = null;
    L59:
        int r107 = r23;
        if (r8.isNull(r107) == false) goto L65;
        String r75 = null;
    L64:
        int r108 = r24;
        if (r8.isNull(r108) == false) goto L70;
        String r76 = null;
    L69:
        int r109 = r25;
        if (r8.isNull(r109) == false) goto L75;
        String r77 = null;
    L74:
        int r1010 = r26;
        if (r8.isNull(r1010) == false) goto L80;
        String r78 = null;
    L79:
        int r1011 = r27;
        if (r8.isNull(r1011) == false) goto L85;
        String r79 = null;
    L84:
        int r1012 = r28;
        if (r8.isNull(r1012) == false) goto L90;
        String r80 = null;
    L89:
        int r1013 = r29;
        if (r8.isNull(r1013) == false) goto L95;
        String r81 = null;
    L94:
        int r1014 = r210;
        if (r8.isNull(r1014) == false) goto L100;
        String r82 = null;
    L99:
        int r1015 = r211;
        if (r8.isNull(r1015) == false) goto L105;
        String r83 = null;
    L104:
        int r1016 = r30;
        if (r8.isNull(r1016) == false) goto L110;
        String r84 = null;
    L109:
        int r1017 = r31;
        if (r8.isNull(r1017) == false) goto L115;
        String r85 = null;
    L114:
        int r1018 = r32;
        if (r8.isNull(r1018) == false) goto L120;
        String r86 = null;
    L119:
        int r1019 = r33;
        if (r8.isNull(r1019) == false) goto L125;
        String r87 = null;
    L124:
        int r1020 = r34;
        if (r8.isNull(r1020) == false) goto L130;
        String r88 = null;
    L129:
        int r1021 = r35;
        if (r8.isNull(r1021) == false) goto L135;
        String r89 = null;
    L134:
        int r1022 = r36;
        if (r8.isNull(r1022) == false) goto L140;
        String r90 = null;
    L139:
        int r1023 = r37;
        if (r8.isNull(r1023) == false) goto L145;
        String r91 = null;
    L144:
        int r1024 = r38;
        if (r8.isNull(r1024) == false) goto L150;
        String r92 = null;
    L149:
        int r1025 = r39;
        if (r8.isNull(r1025) == false) goto L155;
        String r93 = null;
    L154:
        int r1026 = r40;
        if (r8.isNull(r1026) == false) goto L160;
        String r94 = null;
    L159:
        int r1027 = r41;
        if (r8.isNull(r1027) == false) goto L165;
        String r95 = null;
    L164:
        int r1028 = r42;
        if (r8.isNull(r1028) == false) goto L170;
        String r96 = null;
    L169:
        int r1029 = r43;
        if (r8.isNull(r1029) == false) goto L175;
        String r97 = null;
    L174:
        int r1030 = r44;
        if (r8.isNull(r1030) == false) goto L180;
        String r98 = null;
    L179:
        int r1031 = r45;
        int r99 = r8.getInt(r1031);     // Catch: Throwable -> L205
        r46 = r46;
        if (r8.isNull(r46) == false) goto L184;
        String r100 = null;
    L186:
        if (r8.getInt(r47) == 0) goto L188;
        boolean r101 = true;
    L189:
        RawMemoryEntity r54 = new RawMemoryEntity(r53, r55, r56, r58, r60, r61, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98, r99, r100, r101);     // Catch: Throwable -> L205
        int r57 = r19;
        int r59 = r48;
        if (r8.isNull(r59) == false) goto L192;
        Integer r62 = null;
    L193:
        r54.setPoisonLabel(r62);     // Catch: Throwable -> L205
        r49 = r49;
        if (r8.isNull(r49) == false) goto L196;
        Integer r115 = null;
    L197:
        r54.setPoisonLabelVersion(r115);     // Catch: Throwable -> L205
        r50 = r50;
        if (r8.isNull(r50) == false) goto L200;
        String r116 = null;
    L201:
        r54.setContentHash(r116);     // Catch: Throwable -> L205
        r52.add(r54);     // Catch: Throwable -> L205
        r0 = r114;
        r111 = r102;
        r112 = r103;
        r113 = r105;
        r22 = r106;
        r23 = r107;
        r24 = r108;
        r25 = r109;
        r26 = r1010;
        r27 = r1011;
        r28 = r1012;
        r29 = r1013;
        r210 = r1014;
        r211 = r1015;
        r30 = r1016;
        r31 = r1017;
        r32 = r1018;
        r33 = r1019;
        r34 = r1020;
        r35 = r1021;
        r36 = r1022;
        r37 = r1023;
        r38 = r1024;
        r39 = r1025;
        r40 = r1026;
        r41 = r1027;
        r42 = r1028;
        r43 = r1029;
        r44 = r1030;
        r45 = r1031;
        r19 = r57;
        r48 = r59;
        r51 = r51;
        goto L14
    L200:
        r116 = r8.getString(r50);     // Catch: Throwable -> L205
        goto L201
    L196:
        r115 = Integer.valueOf(r8.getInt(r49));     // Catch: Throwable -> L205
        goto L197
    L192:
        r62 = Integer.valueOf(r8.getInt(r59));     // Catch: Throwable -> L205
        goto L193
    L188:
        r101 = false;
        goto L189
    L184:
        r100 = r8.getString(r46);     // Catch: Throwable -> L205
        goto L186
    L180:
        r98 = r8.getString(r1030);     // Catch: Throwable -> L205
        goto L179
    L175:
        r97 = r8.getString(r1029);     // Catch: Throwable -> L205
        goto L174
    L170:
        r96 = r8.getString(r1028);     // Catch: Throwable -> L205
        goto L169
    L165:
        r95 = r8.getString(r1027);     // Catch: Throwable -> L205
        goto L164
    L160:
        r94 = r8.getString(r1026);     // Catch: Throwable -> L205
        goto L159
    L155:
        r93 = r8.getString(r1025);     // Catch: Throwable -> L205
        goto L154
    L150:
        r92 = r8.getString(r1024);     // Catch: Throwable -> L205
        goto L149
    L145:
        r91 = r8.getString(r1023);     // Catch: Throwable -> L205
        goto L144
    L140:
        r90 = r8.getString(r1022);     // Catch: Throwable -> L205
        goto L139
    L135:
        r89 = r8.getString(r1021);     // Catch: Throwable -> L205
        goto L134
    L130:
        r88 = r8.getString(r1020);     // Catch: Throwable -> L205
        goto L129
    L125:
        r87 = r8.getString(r1019);     // Catch: Throwable -> L205
        goto L124
    L120:
        r86 = r8.getString(r1018);     // Catch: Throwable -> L205
        goto L119
    L115:
        r85 = r8.getString(r1017);     // Catch: Throwable -> L205
        goto L114
    L110:
        r84 = r8.getString(r1016);     // Catch: Throwable -> L205
        goto L109
    L105:
        r83 = r8.getString(r1015);     // Catch: Throwable -> L205
        goto L104
    L100:
        r82 = r8.getString(r1014);     // Catch: Throwable -> L205
        goto L99
    L95:
        r81 = r8.getString(r1013);     // Catch: Throwable -> L205
        goto L94
    L90:
        r80 = r8.getString(r1012);     // Catch: Throwable -> L205
        goto L89
    L85:
        r79 = r8.getString(r1011);     // Catch: Throwable -> L205
        goto L84
    L80:
        r78 = r8.getString(r1010);     // Catch: Throwable -> L205
        goto L79
    L75:
        r77 = r8.getString(r109);     // Catch: Throwable -> L205
        goto L74
    L70:
        r76 = r8.getString(r108);     // Catch: Throwable -> L205
        goto L69
    L65:
        r75 = r8.getString(r107);     // Catch: Throwable -> L205
        goto L64
    L60:
        r74 = r8.getString(r106);     // Catch: Throwable -> L205
        goto L59
    L55:
        r73 = r8.getString(r105);     // Catch: Throwable -> L205
        goto L54
    L50:
        r72 = r8.getString(r103);     // Catch: Throwable -> L205
        goto L49
    L45:
        r71 = Long.valueOf(r8.getLong(r102));     // Catch: Throwable -> L205
        goto L44
    L40:
        r70 = Long.valueOf(r8.getLong(r51));     // Catch: Throwable -> L205
        goto L39
    L35:
        r69 = Long.valueOf(r8.getLong(r20));     // Catch: Throwable -> L205
        goto L37
    L31:
        r68 = Long.valueOf(r8.getLong(r19));     // Catch: Throwable -> L205
        goto L33
    L27:
        r65 = r8.getString(r16);     // Catch: Throwable -> L205
        goto L28
    L23:
        r63 = r8.getString(r14);     // Catch: Throwable -> L205
        goto L24
    L19:
        r55 = r8.getString(r9);     // Catch: Throwable -> L205
        goto L20
    L203:
        r8.close();
        r110.release();
        return r52;
    L205:
        th = th;
    L209:
        r8.close();
        r110.release();
        throw th;
    L207:
        th = th;
        r110 = r5;
        goto L209
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public RawMemoryEntity queryById(long r1) {
        return MemoryEntityRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<RawMemoryEntity> queryByIdAndTimestamp(long r1, long r3) {
        return MemoryEntityRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<RawMemoryEntity> queryByIds(List<Long> r3) {
        return MemoryEntityRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return MemoryEntityRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<RawMemoryEntity> queryByPackageName(String r1) {
        return MemoryEntityRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<RawMemoryEntity> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return MemoryEntityRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<RawMemoryEntity> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return MemoryEntityRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public RawMemoryEntity queryByUUID(String r1) {
        return MemoryEntityRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public Cursor queryOldDataForContentTimeIndexPending() {
        return MemoryEntityRawDbDao.DefaultImpls.queryOldDataForContentTimeIndexPending(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public RawMemoryEntity queryOne() {
        return MemoryEntityRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public PagingSource<Integer, RawMemoryEntity> queryPagingSource(SupportSQLiteQuery r4) {
        final SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        final RoomDatabase r1 = this.__db;
        final String[] r2 = {"RawMemoryEntity"};
        return new AnonymousClass23(this, r5, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<RawMemoryEntity> queryRecentByPackageName(String r1, long r2) {
        return MemoryEntityRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public RawMemoryEntity querySameOrderFlightMemoryBy(String r100, long r101) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntity WHERE memoryType = 10001 AND key3 = ? AND startDate = ?", 2);
        if (r100 != null) goto L5;
        r2.bindNull(1);
    L6:
        r2.bindLong(2, r101);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L174
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L174
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L174
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L174
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L174
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L174
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L174
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L174
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L174
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "memoryType");     // Catch: Throwable -> L174
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "productType");     // Catch: Throwable -> L174
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "startDate");     // Catch: Throwable -> L174
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "startTime");     // Catch: Throwable -> L174
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "endDate");     // Catch: Throwable -> L174
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "endTime");     // Catch: Throwable -> L172
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "sourceLinkType");     // Catch: Throwable -> L172
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "sourceLink");     // Catch: Throwable -> L172
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "screenshot");     // Catch: Throwable -> L172
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "locations");     // Catch: Throwable -> L172
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "summary");     // Catch: Throwable -> L172
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "fullContent");     // Catch: Throwable -> L172
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "key1");     // Catch: Throwable -> L172
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "key2");     // Catch: Throwable -> L172
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "key3");     // Catch: Throwable -> L172
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "key4");     // Catch: Throwable -> L172
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "key5");     // Catch: Throwable -> L172
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "keyword1");     // Catch: Throwable -> L172
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "keyword2");     // Catch: Throwable -> L172
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, "keyword3");     // Catch: Throwable -> L172
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, "keyword4");     // Catch: Throwable -> L172
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "keyword5");     // Catch: Throwable -> L172
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "keyword6");     // Catch: Throwable -> L172
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "semantic1");     // Catch: Throwable -> L172
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, "semantic2");     // Catch: Throwable -> L172
        int r37 = CursorUtil.getColumnIndexOrThrow(r5, "keywordAndSemantic1");     // Catch: Throwable -> L172
        int r38 = CursorUtil.getColumnIndexOrThrow(r5, "keywordAndSemantic2");     // Catch: Throwable -> L172
        int r39 = CursorUtil.getColumnIndexOrThrow(r5, "sourceText");     // Catch: Throwable -> L172
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "sourcePackageName");     // Catch: Throwable -> L172
        int r41 = CursorUtil.getColumnIndexOrThrow(r5, "sourceAppName");     // Catch: Throwable -> L172
        int r42 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L172
        int r43 = CursorUtil.getColumnIndexOrThrow(r5, "sourceQuery");     // Catch: Throwable -> L172
        int r44 = CursorUtil.getColumnIndexOrThrow(r5, MemoryListActivity.JUMP_FROM_DETAIL);     // Catch: Throwable -> L172
        int r45 = CursorUtil.getColumnIndexOrThrow(r5, "detailStatus");     // Catch: Throwable -> L172
        int r46 = CursorUtil.getColumnIndexOrThrow(r5, "contentWithTime");     // Catch: Throwable -> L172
        int r47 = CursorUtil.getColumnIndexOrThrow(r5, "userEdit");     // Catch: Throwable -> L172
        int r48 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L172
        int r49 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L172
        int r50 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L172
        if (r5.moveToFirst() == false) goto L169;
        long r51 = r5.getLong(r0);     // Catch: Throwable -> L172
        if (r5.isNull(r6) == false) goto L14;
        String r52 = null;
    L15:
        long r53 = r5.getLong(r7);     // Catch: Throwable -> L172
        long r55 = r5.getLong(r8);     // Catch: Throwable -> L172
        int r57 = r5.getInt(r9);     // Catch: Throwable -> L172
        long r58 = r5.getLong(r10);     // Catch: Throwable -> L172
        if (r5.isNull(r11) == false) goto L18;
        String r60 = null;
    L19:
        int r61 = r5.getInt(r12);     // Catch: Throwable -> L172
        if (r5.isNull(r13) == false) goto L22;
        String r62 = null;
    L23:
        int r63 = r5.getInt(r14);     // Catch: Throwable -> L172
        int r64 = r5.getInt(r15);     // Catch: Throwable -> L172
        if (r5.isNull(r1) == false) goto L26;
        Long r65 = null;
    L28:
        if (r5.isNull(r3) == false) goto L30;
        Long r66 = null;
    L32:
        if (r5.isNull(r4) == false) goto L34;
        Long r67 = null;
    L36:
        if (r5.isNull(r101) == false) goto L38;
        Long r68 = null;
    L40:
        if (r5.isNull(r102) == false) goto L42;
        String r69 = null;
    L44:
        if (r5.isNull(r17) == false) goto L46;
        String r70 = null;
    L48:
        if (r5.isNull(r18) == false) goto L50;
        String r71 = null;
    L52:
        if (r5.isNull(r19) == false) goto L54;
        String r72 = null;
    L56:
        if (r5.isNull(r20) == false) goto L58;
        String r73 = null;
    L60:
        if (r5.isNull(r21) == false) goto L62;
        String r74 = null;
    L64:
        if (r5.isNull(r22) == false) goto L66;
        String r75 = null;
    L68:
        if (r5.isNull(r23) == false) goto L70;
        String r76 = null;
    L72:
        if (r5.isNull(r24) == false) goto L74;
        String r77 = null;
    L76:
        if (r5.isNull(r25) == false) goto L78;
        String r78 = null;
    L80:
        if (r5.isNull(r26) == false) goto L82;
        String r79 = null;
    L84:
        if (r5.isNull(r27) == false) goto L86;
        String r80 = null;
    L88:
        if (r5.isNull(r28) == false) goto L90;
        String r81 = null;
    L92:
        if (r5.isNull(r29) == false) goto L94;
        String r82 = null;
    L96:
        if (r5.isNull(r30) == false) goto L98;
        String r83 = null;
    L100:
        if (r5.isNull(r31) == false) goto L102;
        String r84 = null;
    L104:
        if (r5.isNull(r32) == false) goto L106;
        String r85 = null;
    L108:
        if (r5.isNull(r33) == false) goto L110;
        String r86 = null;
    L112:
        if (r5.isNull(r34) == false) goto L114;
        String r87 = null;
    L116:
        if (r5.isNull(r35) == false) goto L118;
        String r88 = null;
    L120:
        if (r5.isNull(r36) == false) goto L122;
        String r89 = null;
    L124:
        if (r5.isNull(r37) == false) goto L126;
        String r90 = null;
    L128:
        if (r5.isNull(r38) == false) goto L130;
        String r91 = null;
    L132:
        if (r5.isNull(r39) == false) goto L134;
        String r92 = null;
    L136:
        if (r5.isNull(r40) == false) goto L138;
        String r93 = null;
    L140:
        if (r5.isNull(r41) == false) goto L142;
        String r94 = null;
    L144:
        if (r5.isNull(r42) == false) goto L146;
        String r95 = null;
    L147:
        int r96 = r5.getInt(r45);     // Catch: Throwable -> L172
        if (r5.isNull(r46) == false) goto L150;
        String r97 = null;
    L152:
        if (r5.getInt(r47) == 0) goto L154;
        boolean r98 = true;
    L155:
        RawMemoryEntity r54 = new RawMemoryEntity(r51, r52, r53, r55, r57, r58, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98);     // Catch: Throwable -> L172
        if (r5.isNull(r48) == false) goto L158;
        Integer r56 = null;
    L159:
        r54.setPoisonLabel(r56);     // Catch: Throwable -> L172
        if (r5.isNull(r49) == false) goto L162;
        Integer r59 = null;
    L163:
        r54.setPoisonLabelVersion(r59);     // Catch: Throwable -> L172
        if (r5.isNull(r50) == false) goto L166;
        String r99 = null;
    L167:
        r54.setContentHash(r99);     // Catch: Throwable -> L172
        RawMemoryEntity r102 = r54;
    L170:
        r5.close();
        r16.release();
        return r102;
    L166:
        r99 = r5.getString(r50);     // Catch: Throwable -> L172
        goto L167
    L162:
        r59 = Integer.valueOf(r5.getInt(r49));     // Catch: Throwable -> L172
        goto L163
    L158:
        r56 = Integer.valueOf(r5.getInt(r48));     // Catch: Throwable -> L172
        goto L159
    L154:
        r98 = false;
        goto L155
    L150:
        r97 = r5.getString(r46);     // Catch: Throwable -> L172
        goto L152
    L146:
        r95 = r5.getString(r44);     // Catch: Throwable -> L172
        goto L147
    L142:
        r94 = r5.getString(r43);     // Catch: Throwable -> L172
        goto L144
    L138:
        r93 = r5.getString(r42);     // Catch: Throwable -> L172
        goto L140
    L134:
        r92 = r5.getString(r41);     // Catch: Throwable -> L172
        goto L136
    L130:
        r91 = r5.getString(r40);     // Catch: Throwable -> L172
        goto L132
    L126:
        r90 = r5.getString(r39);     // Catch: Throwable -> L172
        goto L128
    L122:
        r89 = r5.getString(r38);     // Catch: Throwable -> L172
        goto L124
    L118:
        r88 = r5.getString(r37);     // Catch: Throwable -> L172
        goto L120
    L114:
        r87 = r5.getString(r36);     // Catch: Throwable -> L172
        goto L116
    L110:
        r86 = r5.getString(r35);     // Catch: Throwable -> L172
        goto L112
    L106:
        r85 = r5.getString(r34);     // Catch: Throwable -> L172
        goto L108
    L102:
        r84 = r5.getString(r33);     // Catch: Throwable -> L172
        goto L104
    L98:
        r83 = r5.getString(r32);     // Catch: Throwable -> L172
        goto L100
    L94:
        r82 = r5.getString(r31);     // Catch: Throwable -> L172
        goto L96
    L90:
        r81 = r5.getString(r30);     // Catch: Throwable -> L172
        goto L92
    L86:
        r80 = r5.getString(r29);     // Catch: Throwable -> L172
        goto L88
    L82:
        r79 = r5.getString(r28);     // Catch: Throwable -> L172
        goto L84
    L78:
        r78 = r5.getString(r27);     // Catch: Throwable -> L172
        goto L80
    L74:
        r77 = r5.getString(r26);     // Catch: Throwable -> L172
        goto L76
    L70:
        r76 = r5.getString(r25);     // Catch: Throwable -> L172
        goto L72
    L66:
        r75 = r5.getString(r24);     // Catch: Throwable -> L172
        goto L68
    L62:
        r74 = r5.getString(r23);     // Catch: Throwable -> L172
        goto L64
    L58:
        r73 = r5.getString(r22);     // Catch: Throwable -> L172
        goto L60
    L54:
        r72 = r5.getString(r21);     // Catch: Throwable -> L172
        goto L56
    L50:
        r71 = r5.getString(r20);     // Catch: Throwable -> L172
        goto L52
    L46:
        r70 = r5.getString(r19);     // Catch: Throwable -> L172
        goto L48
    L42:
        r69 = r5.getString(r18);     // Catch: Throwable -> L172
        goto L44
    L38:
        r68 = Long.valueOf(r5.getLong(r17));     // Catch: Throwable -> L172
        goto L40
    L34:
        r67 = Long.valueOf(r5.getLong(r4));     // Catch: Throwable -> L172
        goto L36
    L30:
        r66 = Long.valueOf(r5.getLong(r3));     // Catch: Throwable -> L172
        goto L32
    L26:
        r65 = Long.valueOf(r5.getLong(r1));     // Catch: Throwable -> L172
        goto L28
    L22:
        r62 = r5.getString(r13);     // Catch: Throwable -> L172
        goto L23
    L18:
        r60 = r5.getString(r11);     // Catch: Throwable -> L172
        goto L19
    L14:
        r52 = r5.getString(r6);     // Catch: Throwable -> L172
        goto L15
    L169:
        r102 = null;
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
        r2.bindString(1, r100);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public RawMemoryEntity querySameOrderHotelMemoryBy(String r100, long r101) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntity WHERE memoryType = 10004 AND keyword1 = ? AND startDate = ?", 2);
        if (r100 != null) goto L5;
        r2.bindNull(1);
    L6:
        r2.bindLong(2, r101);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L174
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L174
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L174
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L174
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L174
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L174
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L174
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L174
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L174
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "memoryType");     // Catch: Throwable -> L174
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "productType");     // Catch: Throwable -> L174
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "startDate");     // Catch: Throwable -> L174
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "startTime");     // Catch: Throwable -> L174
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "endDate");     // Catch: Throwable -> L174
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "endTime");     // Catch: Throwable -> L172
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "sourceLinkType");     // Catch: Throwable -> L172
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "sourceLink");     // Catch: Throwable -> L172
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "screenshot");     // Catch: Throwable -> L172
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "locations");     // Catch: Throwable -> L172
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "summary");     // Catch: Throwable -> L172
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "fullContent");     // Catch: Throwable -> L172
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "key1");     // Catch: Throwable -> L172
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "key2");     // Catch: Throwable -> L172
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "key3");     // Catch: Throwable -> L172
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "key4");     // Catch: Throwable -> L172
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "key5");     // Catch: Throwable -> L172
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "keyword1");     // Catch: Throwable -> L172
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "keyword2");     // Catch: Throwable -> L172
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, "keyword3");     // Catch: Throwable -> L172
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, "keyword4");     // Catch: Throwable -> L172
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "keyword5");     // Catch: Throwable -> L172
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "keyword6");     // Catch: Throwable -> L172
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "semantic1");     // Catch: Throwable -> L172
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, "semantic2");     // Catch: Throwable -> L172
        int r37 = CursorUtil.getColumnIndexOrThrow(r5, "keywordAndSemantic1");     // Catch: Throwable -> L172
        int r38 = CursorUtil.getColumnIndexOrThrow(r5, "keywordAndSemantic2");     // Catch: Throwable -> L172
        int r39 = CursorUtil.getColumnIndexOrThrow(r5, "sourceText");     // Catch: Throwable -> L172
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "sourcePackageName");     // Catch: Throwable -> L172
        int r41 = CursorUtil.getColumnIndexOrThrow(r5, "sourceAppName");     // Catch: Throwable -> L172
        int r42 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L172
        int r43 = CursorUtil.getColumnIndexOrThrow(r5, "sourceQuery");     // Catch: Throwable -> L172
        int r44 = CursorUtil.getColumnIndexOrThrow(r5, MemoryListActivity.JUMP_FROM_DETAIL);     // Catch: Throwable -> L172
        int r45 = CursorUtil.getColumnIndexOrThrow(r5, "detailStatus");     // Catch: Throwable -> L172
        int r46 = CursorUtil.getColumnIndexOrThrow(r5, "contentWithTime");     // Catch: Throwable -> L172
        int r47 = CursorUtil.getColumnIndexOrThrow(r5, "userEdit");     // Catch: Throwable -> L172
        int r48 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L172
        int r49 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L172
        int r50 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L172
        if (r5.moveToFirst() == false) goto L169;
        long r51 = r5.getLong(r0);     // Catch: Throwable -> L172
        if (r5.isNull(r6) == false) goto L14;
        String r52 = null;
    L15:
        long r53 = r5.getLong(r7);     // Catch: Throwable -> L172
        long r55 = r5.getLong(r8);     // Catch: Throwable -> L172
        int r57 = r5.getInt(r9);     // Catch: Throwable -> L172
        long r58 = r5.getLong(r10);     // Catch: Throwable -> L172
        if (r5.isNull(r11) == false) goto L18;
        String r60 = null;
    L19:
        int r61 = r5.getInt(r12);     // Catch: Throwable -> L172
        if (r5.isNull(r13) == false) goto L22;
        String r62 = null;
    L23:
        int r63 = r5.getInt(r14);     // Catch: Throwable -> L172
        int r64 = r5.getInt(r15);     // Catch: Throwable -> L172
        if (r5.isNull(r1) == false) goto L26;
        Long r65 = null;
    L28:
        if (r5.isNull(r3) == false) goto L30;
        Long r66 = null;
    L32:
        if (r5.isNull(r4) == false) goto L34;
        Long r67 = null;
    L36:
        if (r5.isNull(r101) == false) goto L38;
        Long r68 = null;
    L40:
        if (r5.isNull(r102) == false) goto L42;
        String r69 = null;
    L44:
        if (r5.isNull(r17) == false) goto L46;
        String r70 = null;
    L48:
        if (r5.isNull(r18) == false) goto L50;
        String r71 = null;
    L52:
        if (r5.isNull(r19) == false) goto L54;
        String r72 = null;
    L56:
        if (r5.isNull(r20) == false) goto L58;
        String r73 = null;
    L60:
        if (r5.isNull(r21) == false) goto L62;
        String r74 = null;
    L64:
        if (r5.isNull(r22) == false) goto L66;
        String r75 = null;
    L68:
        if (r5.isNull(r23) == false) goto L70;
        String r76 = null;
    L72:
        if (r5.isNull(r24) == false) goto L74;
        String r77 = null;
    L76:
        if (r5.isNull(r25) == false) goto L78;
        String r78 = null;
    L80:
        if (r5.isNull(r26) == false) goto L82;
        String r79 = null;
    L84:
        if (r5.isNull(r27) == false) goto L86;
        String r80 = null;
    L88:
        if (r5.isNull(r28) == false) goto L90;
        String r81 = null;
    L92:
        if (r5.isNull(r29) == false) goto L94;
        String r82 = null;
    L96:
        if (r5.isNull(r30) == false) goto L98;
        String r83 = null;
    L100:
        if (r5.isNull(r31) == false) goto L102;
        String r84 = null;
    L104:
        if (r5.isNull(r32) == false) goto L106;
        String r85 = null;
    L108:
        if (r5.isNull(r33) == false) goto L110;
        String r86 = null;
    L112:
        if (r5.isNull(r34) == false) goto L114;
        String r87 = null;
    L116:
        if (r5.isNull(r35) == false) goto L118;
        String r88 = null;
    L120:
        if (r5.isNull(r36) == false) goto L122;
        String r89 = null;
    L124:
        if (r5.isNull(r37) == false) goto L126;
        String r90 = null;
    L128:
        if (r5.isNull(r38) == false) goto L130;
        String r91 = null;
    L132:
        if (r5.isNull(r39) == false) goto L134;
        String r92 = null;
    L136:
        if (r5.isNull(r40) == false) goto L138;
        String r93 = null;
    L140:
        if (r5.isNull(r41) == false) goto L142;
        String r94 = null;
    L144:
        if (r5.isNull(r42) == false) goto L146;
        String r95 = null;
    L147:
        int r96 = r5.getInt(r45);     // Catch: Throwable -> L172
        if (r5.isNull(r46) == false) goto L150;
        String r97 = null;
    L152:
        if (r5.getInt(r47) == 0) goto L154;
        boolean r98 = true;
    L155:
        RawMemoryEntity r54 = new RawMemoryEntity(r51, r52, r53, r55, r57, r58, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98);     // Catch: Throwable -> L172
        if (r5.isNull(r48) == false) goto L158;
        Integer r56 = null;
    L159:
        r54.setPoisonLabel(r56);     // Catch: Throwable -> L172
        if (r5.isNull(r49) == false) goto L162;
        Integer r59 = null;
    L163:
        r54.setPoisonLabelVersion(r59);     // Catch: Throwable -> L172
        if (r5.isNull(r50) == false) goto L166;
        String r99 = null;
    L167:
        r54.setContentHash(r99);     // Catch: Throwable -> L172
        RawMemoryEntity r102 = r54;
    L170:
        r5.close();
        r16.release();
        return r102;
    L166:
        r99 = r5.getString(r50);     // Catch: Throwable -> L172
        goto L167
    L162:
        r59 = Integer.valueOf(r5.getInt(r49));     // Catch: Throwable -> L172
        goto L163
    L158:
        r56 = Integer.valueOf(r5.getInt(r48));     // Catch: Throwable -> L172
        goto L159
    L154:
        r98 = false;
        goto L155
    L150:
        r97 = r5.getString(r46);     // Catch: Throwable -> L172
        goto L152
    L146:
        r95 = r5.getString(r44);     // Catch: Throwable -> L172
        goto L147
    L142:
        r94 = r5.getString(r43);     // Catch: Throwable -> L172
        goto L144
    L138:
        r93 = r5.getString(r42);     // Catch: Throwable -> L172
        goto L140
    L134:
        r92 = r5.getString(r41);     // Catch: Throwable -> L172
        goto L136
    L130:
        r91 = r5.getString(r40);     // Catch: Throwable -> L172
        goto L132
    L126:
        r90 = r5.getString(r39);     // Catch: Throwable -> L172
        goto L128
    L122:
        r89 = r5.getString(r38);     // Catch: Throwable -> L172
        goto L124
    L118:
        r88 = r5.getString(r37);     // Catch: Throwable -> L172
        goto L120
    L114:
        r87 = r5.getString(r36);     // Catch: Throwable -> L172
        goto L116
    L110:
        r86 = r5.getString(r35);     // Catch: Throwable -> L172
        goto L112
    L106:
        r85 = r5.getString(r34);     // Catch: Throwable -> L172
        goto L108
    L102:
        r84 = r5.getString(r33);     // Catch: Throwable -> L172
        goto L104
    L98:
        r83 = r5.getString(r32);     // Catch: Throwable -> L172
        goto L100
    L94:
        r82 = r5.getString(r31);     // Catch: Throwable -> L172
        goto L96
    L90:
        r81 = r5.getString(r30);     // Catch: Throwable -> L172
        goto L92
    L86:
        r80 = r5.getString(r29);     // Catch: Throwable -> L172
        goto L88
    L82:
        r79 = r5.getString(r28);     // Catch: Throwable -> L172
        goto L84
    L78:
        r78 = r5.getString(r27);     // Catch: Throwable -> L172
        goto L80
    L74:
        r77 = r5.getString(r26);     // Catch: Throwable -> L172
        goto L76
    L70:
        r76 = r5.getString(r25);     // Catch: Throwable -> L172
        goto L72
    L66:
        r75 = r5.getString(r24);     // Catch: Throwable -> L172
        goto L68
    L62:
        r74 = r5.getString(r23);     // Catch: Throwable -> L172
        goto L64
    L58:
        r73 = r5.getString(r22);     // Catch: Throwable -> L172
        goto L60
    L54:
        r72 = r5.getString(r21);     // Catch: Throwable -> L172
        goto L56
    L50:
        r71 = r5.getString(r20);     // Catch: Throwable -> L172
        goto L52
    L46:
        r70 = r5.getString(r19);     // Catch: Throwable -> L172
        goto L48
    L42:
        r69 = r5.getString(r18);     // Catch: Throwable -> L172
        goto L44
    L38:
        r68 = Long.valueOf(r5.getLong(r17));     // Catch: Throwable -> L172
        goto L40
    L34:
        r67 = Long.valueOf(r5.getLong(r4));     // Catch: Throwable -> L172
        goto L36
    L30:
        r66 = Long.valueOf(r5.getLong(r3));     // Catch: Throwable -> L172
        goto L32
    L26:
        r65 = Long.valueOf(r5.getLong(r1));     // Catch: Throwable -> L172
        goto L28
    L22:
        r62 = r5.getString(r13);     // Catch: Throwable -> L172
        goto L23
    L18:
        r60 = r5.getString(r11);     // Catch: Throwable -> L172
        goto L19
    L14:
        r52 = r5.getString(r6);     // Catch: Throwable -> L172
        goto L15
    L169:
        r102 = null;
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
        r2.bindString(1, r100);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public RawMemoryEntity querySameOrderTrainMemoryBy(String r100, long r101) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM RawMemoryEntity WHERE memoryType = 10002 AND key3 = ? AND startDate = ?", 2);
        if (r100 != null) goto L5;
        r2.bindNull(1);
    L6:
        r2.bindLong(2, r101);
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L174
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "entityId");     // Catch: Throwable -> L174
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, "createTime");     // Catch: Throwable -> L174
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "modifyTime");     // Catch: Throwable -> L174
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "type");     // Catch: Throwable -> L174
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "timestamp");     // Catch: Throwable -> L174
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L174
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "hashCodeValue");     // Catch: Throwable -> L174
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, Api.KEY_UUID);     // Catch: Throwable -> L174
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "memoryType");     // Catch: Throwable -> L174
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, "productType");     // Catch: Throwable -> L174
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "startDate");     // Catch: Throwable -> L174
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "startTime");     // Catch: Throwable -> L174
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "endDate");     // Catch: Throwable -> L174
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "endTime");     // Catch: Throwable -> L172
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "sourceLinkType");     // Catch: Throwable -> L172
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "sourceLink");     // Catch: Throwable -> L172
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "screenshot");     // Catch: Throwable -> L172
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "locations");     // Catch: Throwable -> L172
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "summary");     // Catch: Throwable -> L172
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "fullContent");     // Catch: Throwable -> L172
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "key1");     // Catch: Throwable -> L172
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "key2");     // Catch: Throwable -> L172
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "key3");     // Catch: Throwable -> L172
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "key4");     // Catch: Throwable -> L172
        int r28 = CursorUtil.getColumnIndexOrThrow(r5, "key5");     // Catch: Throwable -> L172
        int r29 = CursorUtil.getColumnIndexOrThrow(r5, "keyword1");     // Catch: Throwable -> L172
        int r30 = CursorUtil.getColumnIndexOrThrow(r5, "keyword2");     // Catch: Throwable -> L172
        int r31 = CursorUtil.getColumnIndexOrThrow(r5, "keyword3");     // Catch: Throwable -> L172
        int r32 = CursorUtil.getColumnIndexOrThrow(r5, "keyword4");     // Catch: Throwable -> L172
        int r33 = CursorUtil.getColumnIndexOrThrow(r5, "keyword5");     // Catch: Throwable -> L172
        int r34 = CursorUtil.getColumnIndexOrThrow(r5, "keyword6");     // Catch: Throwable -> L172
        int r35 = CursorUtil.getColumnIndexOrThrow(r5, "semantic1");     // Catch: Throwable -> L172
        int r36 = CursorUtil.getColumnIndexOrThrow(r5, "semantic2");     // Catch: Throwable -> L172
        int r37 = CursorUtil.getColumnIndexOrThrow(r5, "keywordAndSemantic1");     // Catch: Throwable -> L172
        int r38 = CursorUtil.getColumnIndexOrThrow(r5, "keywordAndSemantic2");     // Catch: Throwable -> L172
        int r39 = CursorUtil.getColumnIndexOrThrow(r5, "sourceText");     // Catch: Throwable -> L172
        int r40 = CursorUtil.getColumnIndexOrThrow(r5, "sourcePackageName");     // Catch: Throwable -> L172
        int r41 = CursorUtil.getColumnIndexOrThrow(r5, "sourceAppName");     // Catch: Throwable -> L172
        int r42 = CursorUtil.getColumnIndexOrThrow(r5, "logId");     // Catch: Throwable -> L172
        int r43 = CursorUtil.getColumnIndexOrThrow(r5, "sourceQuery");     // Catch: Throwable -> L172
        int r44 = CursorUtil.getColumnIndexOrThrow(r5, MemoryListActivity.JUMP_FROM_DETAIL);     // Catch: Throwable -> L172
        int r45 = CursorUtil.getColumnIndexOrThrow(r5, "detailStatus");     // Catch: Throwable -> L172
        int r46 = CursorUtil.getColumnIndexOrThrow(r5, "contentWithTime");     // Catch: Throwable -> L172
        int r47 = CursorUtil.getColumnIndexOrThrow(r5, "userEdit");     // Catch: Throwable -> L172
        int r48 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label");     // Catch: Throwable -> L172
        int r49 = CursorUtil.getColumnIndexOrThrow(r5, "poison_label_version");     // Catch: Throwable -> L172
        int r50 = CursorUtil.getColumnIndexOrThrow(r5, "content_hash");     // Catch: Throwable -> L172
        if (r5.moveToFirst() == false) goto L169;
        long r51 = r5.getLong(r0);     // Catch: Throwable -> L172
        if (r5.isNull(r6) == false) goto L14;
        String r52 = null;
    L15:
        long r53 = r5.getLong(r7);     // Catch: Throwable -> L172
        long r55 = r5.getLong(r8);     // Catch: Throwable -> L172
        int r57 = r5.getInt(r9);     // Catch: Throwable -> L172
        long r58 = r5.getLong(r10);     // Catch: Throwable -> L172
        if (r5.isNull(r11) == false) goto L18;
        String r60 = null;
    L19:
        int r61 = r5.getInt(r12);     // Catch: Throwable -> L172
        if (r5.isNull(r13) == false) goto L22;
        String r62 = null;
    L23:
        int r63 = r5.getInt(r14);     // Catch: Throwable -> L172
        int r64 = r5.getInt(r15);     // Catch: Throwable -> L172
        if (r5.isNull(r1) == false) goto L26;
        Long r65 = null;
    L28:
        if (r5.isNull(r3) == false) goto L30;
        Long r66 = null;
    L32:
        if (r5.isNull(r4) == false) goto L34;
        Long r67 = null;
    L36:
        if (r5.isNull(r101) == false) goto L38;
        Long r68 = null;
    L40:
        if (r5.isNull(r102) == false) goto L42;
        String r69 = null;
    L44:
        if (r5.isNull(r17) == false) goto L46;
        String r70 = null;
    L48:
        if (r5.isNull(r18) == false) goto L50;
        String r71 = null;
    L52:
        if (r5.isNull(r19) == false) goto L54;
        String r72 = null;
    L56:
        if (r5.isNull(r20) == false) goto L58;
        String r73 = null;
    L60:
        if (r5.isNull(r21) == false) goto L62;
        String r74 = null;
    L64:
        if (r5.isNull(r22) == false) goto L66;
        String r75 = null;
    L68:
        if (r5.isNull(r23) == false) goto L70;
        String r76 = null;
    L72:
        if (r5.isNull(r24) == false) goto L74;
        String r77 = null;
    L76:
        if (r5.isNull(r25) == false) goto L78;
        String r78 = null;
    L80:
        if (r5.isNull(r26) == false) goto L82;
        String r79 = null;
    L84:
        if (r5.isNull(r27) == false) goto L86;
        String r80 = null;
    L88:
        if (r5.isNull(r28) == false) goto L90;
        String r81 = null;
    L92:
        if (r5.isNull(r29) == false) goto L94;
        String r82 = null;
    L96:
        if (r5.isNull(r30) == false) goto L98;
        String r83 = null;
    L100:
        if (r5.isNull(r31) == false) goto L102;
        String r84 = null;
    L104:
        if (r5.isNull(r32) == false) goto L106;
        String r85 = null;
    L108:
        if (r5.isNull(r33) == false) goto L110;
        String r86 = null;
    L112:
        if (r5.isNull(r34) == false) goto L114;
        String r87 = null;
    L116:
        if (r5.isNull(r35) == false) goto L118;
        String r88 = null;
    L120:
        if (r5.isNull(r36) == false) goto L122;
        String r89 = null;
    L124:
        if (r5.isNull(r37) == false) goto L126;
        String r90 = null;
    L128:
        if (r5.isNull(r38) == false) goto L130;
        String r91 = null;
    L132:
        if (r5.isNull(r39) == false) goto L134;
        String r92 = null;
    L136:
        if (r5.isNull(r40) == false) goto L138;
        String r93 = null;
    L140:
        if (r5.isNull(r41) == false) goto L142;
        String r94 = null;
    L144:
        if (r5.isNull(r42) == false) goto L146;
        String r95 = null;
    L147:
        int r96 = r5.getInt(r45);     // Catch: Throwable -> L172
        if (r5.isNull(r46) == false) goto L150;
        String r97 = null;
    L152:
        if (r5.getInt(r47) == 0) goto L154;
        boolean r98 = true;
    L155:
        RawMemoryEntity r54 = new RawMemoryEntity(r51, r52, r53, r55, r57, r58, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75, r76, r77, r78, r79, r80, r81, r82, r83, r84, r85, r86, r87, r88, r89, r90, r91, r92, r93, r94, r95, r96, r97, r98);     // Catch: Throwable -> L172
        if (r5.isNull(r48) == false) goto L158;
        Integer r56 = null;
    L159:
        r54.setPoisonLabel(r56);     // Catch: Throwable -> L172
        if (r5.isNull(r49) == false) goto L162;
        Integer r59 = null;
    L163:
        r54.setPoisonLabelVersion(r59);     // Catch: Throwable -> L172
        if (r5.isNull(r50) == false) goto L166;
        String r99 = null;
    L167:
        r54.setContentHash(r99);     // Catch: Throwable -> L172
        RawMemoryEntity r102 = r54;
    L170:
        r5.close();
        r16.release();
        return r102;
    L166:
        r99 = r5.getString(r50);     // Catch: Throwable -> L172
        goto L167
    L162:
        r59 = Integer.valueOf(r5.getInt(r49));     // Catch: Throwable -> L172
        goto L163
    L158:
        r56 = Integer.valueOf(r5.getInt(r48));     // Catch: Throwable -> L172
        goto L159
    L154:
        r98 = false;
        goto L155
    L150:
        r97 = r5.getString(r46);     // Catch: Throwable -> L172
        goto L152
    L146:
        r95 = r5.getString(r44);     // Catch: Throwable -> L172
        goto L147
    L142:
        r94 = r5.getString(r43);     // Catch: Throwable -> L172
        goto L144
    L138:
        r93 = r5.getString(r42);     // Catch: Throwable -> L172
        goto L140
    L134:
        r92 = r5.getString(r41);     // Catch: Throwable -> L172
        goto L136
    L130:
        r91 = r5.getString(r40);     // Catch: Throwable -> L172
        goto L132
    L126:
        r90 = r5.getString(r39);     // Catch: Throwable -> L172
        goto L128
    L122:
        r89 = r5.getString(r38);     // Catch: Throwable -> L172
        goto L124
    L118:
        r88 = r5.getString(r37);     // Catch: Throwable -> L172
        goto L120
    L114:
        r87 = r5.getString(r36);     // Catch: Throwable -> L172
        goto L116
    L110:
        r86 = r5.getString(r35);     // Catch: Throwable -> L172
        goto L112
    L106:
        r85 = r5.getString(r34);     // Catch: Throwable -> L172
        goto L108
    L102:
        r84 = r5.getString(r33);     // Catch: Throwable -> L172
        goto L104
    L98:
        r83 = r5.getString(r32);     // Catch: Throwable -> L172
        goto L100
    L94:
        r82 = r5.getString(r31);     // Catch: Throwable -> L172
        goto L96
    L90:
        r81 = r5.getString(r30);     // Catch: Throwable -> L172
        goto L92
    L86:
        r80 = r5.getString(r29);     // Catch: Throwable -> L172
        goto L88
    L82:
        r79 = r5.getString(r28);     // Catch: Throwable -> L172
        goto L84
    L78:
        r78 = r5.getString(r27);     // Catch: Throwable -> L172
        goto L80
    L74:
        r77 = r5.getString(r26);     // Catch: Throwable -> L172
        goto L76
    L70:
        r76 = r5.getString(r25);     // Catch: Throwable -> L172
        goto L72
    L66:
        r75 = r5.getString(r24);     // Catch: Throwable -> L172
        goto L68
    L62:
        r74 = r5.getString(r23);     // Catch: Throwable -> L172
        goto L64
    L58:
        r73 = r5.getString(r22);     // Catch: Throwable -> L172
        goto L60
    L54:
        r72 = r5.getString(r21);     // Catch: Throwable -> L172
        goto L56
    L50:
        r71 = r5.getString(r20);     // Catch: Throwable -> L172
        goto L52
    L46:
        r70 = r5.getString(r19);     // Catch: Throwable -> L172
        goto L48
    L42:
        r69 = r5.getString(r18);     // Catch: Throwable -> L172
        goto L44
    L38:
        r68 = Long.valueOf(r5.getLong(r17));     // Catch: Throwable -> L172
        goto L40
    L34:
        r67 = Long.valueOf(r5.getLong(r4));     // Catch: Throwable -> L172
        goto L36
    L30:
        r66 = Long.valueOf(r5.getLong(r3));     // Catch: Throwable -> L172
        goto L32
    L26:
        r65 = Long.valueOf(r5.getLong(r1));     // Catch: Throwable -> L172
        goto L28
    L22:
        r62 = r5.getString(r13);     // Catch: Throwable -> L172
        goto L23
    L18:
        r60 = r5.getString(r11);     // Catch: Throwable -> L172
        goto L19
    L14:
        r52 = r5.getString(r6);     // Catch: Throwable -> L172
        goto L15
    L169:
        r102 = null;
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
        r2.bindString(1, r100);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryEntityRawDbDao
    public List<RawMemoryEntity> queryWidgetMemory(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawMemoryEntity(r6));     // Catch: Throwable -> L10
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
    public List<RawMemoryEntity> queryWithLimitAndOffset(int r1, int r2) {
        return MemoryEntityRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<RawMemoryEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawMemoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(RawMemoryEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawMemoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((RawMemoryEntity) ZeusTransformUtils.preCheckCast(r3, RawMemoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<RawMemoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawMemoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return MemoryEntityRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
