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
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.database.b;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.model.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class AuditoryRecordingRawDbDao_Impl implements AuditoryRecordingRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<fj> __deletionAdapterOfRawAuditoryRecordingEntity;
    private final EntityInsertionAdapter<fj> __insertionAdapterOfRawAuditoryRecordingEntity;
    private final EntityDeletionOrUpdateAdapter<fj> __updateAdapterOfRawAuditoryRecordingEntity;

    public AuditoryRecordingRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawAuditoryRecordingEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawAuditoryRecordingEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawAuditoryRecordingEntity = new AnonymousClass3(this, r2);
    }

    private fj __entityCursorConverter_comObricMemorydataDatabaseEntityRawAuditoryRecordingEntity(Cursor r57) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r57, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r8 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, ActivityLifecycle.NAME);
        int r10 = CursorUtil.getColumnIndex(r0, "state");
        int r11 = CursorUtil.getColumnIndex(r0, "file");
        int r12 = CursorUtil.getColumnIndex(r0, "duration");
        int r13 = CursorUtil.getColumnIndex(r0, "transcript");
        int r14 = CursorUtil.getColumnIndex(r0, "summary");
        int r15 = CursorUtil.getColumnIndex(r0, "todoList");
        int r16 = CursorUtil.getColumnIndex(r0, "markers");
        int r17 = CursorUtil.getColumnIndex(r0, "sourceAppName");
        int r18 = CursorUtil.getColumnIndex(r0, "sourceAppPackage");
        int r19 = CursorUtil.getColumnIndex(r0, "requestTime");
        int r110 = CursorUtil.getColumnIndex(r0, "did");
        int r111 = CursorUtil.getColumnIndex(r0, "docNodeJson");
        int r112 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r113 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r114 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r115 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r24 = 0;
        if (r1 != (-1)) goto L5;
        long r30 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r32 = null;
    L13:
        if (r3 != (-1)) goto L15;
        long r33 = 0;
    L16:
        if (r4 != (-1)) goto L18;
        long r35 = 0;
    L19:
        int r21 = 0;
        if (r5 != (-1)) goto L22;
        int r37 = 0;
    L23:
        if (r6 == (-1)) goto L26;
        r24 = r0.getLong(r6);
    L26:
        long r38 = r24;
        if (r7 != (-1)) goto L30;
    L28:
        String r40 = null;
    L33:
        if (r8 != (-1)) goto L35;
        int r41 = 0;
    L36:
        if (r9 != (-1)) goto L39;
    L37:
        String r42 = null;
    L42:
        if (r10 != (-1)) goto L44;
        int r43 = 0;
    L45:
        if (r11 != (-1)) goto L48;
    L46:
        String r44 = null;
    L51:
        if (r12 == (-1)) goto L54;
        r21 = r0.getInt(r12);
    L54:
        int r45 = r21;
        if (r13 != (-1)) goto L58;
    L56:
        String r46 = null;
    L61:
        if (r14 != (-1)) goto L64;
    L62:
        String r47 = null;
    L67:
        if (r56 != (-1)) goto L70;
    L68:
        String r48 = null;
    L73:
        if (r57 != (-1)) goto L77;
    L74:
        String r49 = null;
    L80:
        if (r17 != (-1)) goto L84;
    L81:
        String r50 = null;
    L87:
        if (r18 != (-1)) goto L91;
    L88:
        String r51 = null;
    L94:
        if (r19 != (-1)) goto L98;
    L95:
        Long r52 = null;
    L101:
        if (r110 != (-1)) goto L105;
    L102:
        String r53 = null;
    L108:
        if (r111 != (-1)) goto L112;
    L109:
        String r54 = null;
    L115:
        if (r112 != (-1)) goto L118;
    L116:
        String r55 = null;
    L121:
        fj r22 = new fj(r30, r32, r33, r35, r37, r38, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55);
        if (r113 == (-1)) goto L129;
        if (r0.isNull(r113) == false) goto L126;
        Integer r23 = null;
    L127:
        r22.setPoisonLabel(r23);
        goto L129
    L126:
        r23 = Integer.valueOf(r0.getInt(r113));
    L129:
        if (r114 == (-1)) goto L136;
        if (r0.isNull(r114) == false) goto L133;
        Integer r25 = null;
    L134:
        r22.setPoisonLabelVersion(r25);
        goto L136
    L133:
        r25 = Integer.valueOf(r0.getInt(r114));
    L136:
        if (r115 != (-1)) goto L138;
    L142:
        return r22;
    L138:
        if (r0.isNull(r115) == true) goto L141;
        r20 = r0.getString(r115);
    L141:
        r22.setContentHash(r20);
        goto L142
    L118:
        if (r0.isNull(r112) == true) goto L116;
        r55 = r0.getString(r112);
        goto L121
    L112:
        if (r0.isNull(r111) == true) goto L109;
        r54 = r0.getString(r111);
        goto L115
    L105:
        if (r0.isNull(r110) == true) goto L102;
        r53 = r0.getString(r110);
        goto L108
    L98:
        if (r0.isNull(r19) == true) goto L95;
        r52 = Long.valueOf(r0.getLong(r19));
        goto L101
    L91:
        if (r0.isNull(r18) == true) goto L88;
        r51 = r0.getString(r18);
        goto L94
    L84:
        if (r0.isNull(r17) == true) goto L81;
        r50 = r0.getString(r17);
        goto L87
    L77:
        if (r0.isNull(r57) == true) goto L74;
        r49 = r0.getString(r16);
        goto L80
    L70:
        if (r0.isNull(r56) == true) goto L68;
        r48 = r0.getString(r15);
        goto L73
    L64:
        if (r0.isNull(r14) == true) goto L62;
        r47 = r0.getString(r14);
        goto L67
    L58:
        if (r0.isNull(r13) == true) goto L56;
        r46 = r0.getString(r13);
        goto L61
    L48:
        if (r0.isNull(r11) == true) goto L46;
        r44 = r0.getString(r11);
        goto L51
    L44:
        r43 = r0.getInt(r10);
        goto L45
    L39:
        if (r0.isNull(r9) == true) goto L37;
        r42 = r0.getString(r9);
        goto L42
    L35:
        r41 = r0.getInt(r8);
        goto L36
    L30:
        if (r0.isNull(r7) == true) goto L28;
        r40 = r0.getString(r7);
        goto L33
    L22:
        r37 = r0.getInt(r5);
        goto L23
    L18:
        r35 = r0.getLong(r4);
        goto L19
    L15:
        r33 = r0.getLong(r3);
        goto L16
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r32 = r0.getString(r2);
        goto L13
    L5:
        r30 = r0.getLong(r1);
        goto L6
    }

    static /* synthetic */ RoomDatabase access$000(AuditoryRecordingRawDbDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int backfillContentHashIfAbsent(long r1, long r3, long r5, String r7) {
        return AuditoryRecordingRawDbDao.DefaultImpls.backfillContentHashIfAbsent(this, r1, r3, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<fj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawAuditoryRecordingEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<fj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawAuditoryRecordingEntity.insert(r4);     // Catch: Throwable -> L6
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

    public int delete(fj r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawAuditoryRecordingEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((fj) ZeusTransformUtils.preCheckCast(r3, fj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return AuditoryRecordingRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int deleteByRawDbIds(List<Long> r3) {
        return AuditoryRecordingRawDbDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao
    public PagingSource<Integer, fj> getAllRecordings(long r4, long r6) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM RawAuditoryRecordingEntity WHERE createTime >= ? AND createTime < ? ORDER BY createTime DESC", 2);
        r0.bindLong(1, r4);
        r0.bindLong(2, r6);
        final RoomDatabase r5 = this.__db;
        final String[] r7 = {"RawAuditoryRecordingEntity"};
        return new AnonymousClass4(this, r0, r5, r7);
    }

    @Override // com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao
    public List<fj> getAllRecordings2() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM RawAuditoryRecordingEntity ORDER BY createTime DESC", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L90
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "entityId");     // Catch: Throwable -> L90
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "createTime");     // Catch: Throwable -> L90
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "modifyTime");     // Catch: Throwable -> L90
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "type");     // Catch: Throwable -> L90
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "timestamp");     // Catch: Throwable -> L90
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L90
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "hashCodeValue");     // Catch: Throwable -> L90
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, ActivityLifecycle.NAME);     // Catch: Throwable -> L90
        int r12 = CursorUtil.getColumnIndexOrThrow(r2, "state");     // Catch: Throwable -> L90
        int r13 = CursorUtil.getColumnIndexOrThrow(r2, "file");     // Catch: Throwable -> L90
        int r14 = CursorUtil.getColumnIndexOrThrow(r2, "duration");     // Catch: Throwable -> L90
        int r15 = CursorUtil.getColumnIndexOrThrow(r2, "transcript");     // Catch: Throwable -> L90
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, "summary");     // Catch: Throwable -> L90
        RoomSQLiteQuery r16 = r1;
        int r17 = CursorUtil.getColumnIndexOrThrow(r2, "todoList");     // Catch: Throwable -> L88
        int r18 = CursorUtil.getColumnIndexOrThrow(r2, "markers");     // Catch: Throwable -> L88
        int r19 = CursorUtil.getColumnIndexOrThrow(r2, "sourceAppName");     // Catch: Throwable -> L88
        int r20 = CursorUtil.getColumnIndexOrThrow(r2, "sourceAppPackage");     // Catch: Throwable -> L88
        int r21 = CursorUtil.getColumnIndexOrThrow(r2, "requestTime");     // Catch: Throwable -> L88
        int r22 = CursorUtil.getColumnIndexOrThrow(r2, "did");     // Catch: Throwable -> L88
        int r23 = CursorUtil.getColumnIndexOrThrow(r2, "docNodeJson");     // Catch: Throwable -> L88
        int r24 = CursorUtil.getColumnIndexOrThrow(r2, Api.KEY_UUID);     // Catch: Throwable -> L88
        int r25 = CursorUtil.getColumnIndexOrThrow(r2, "poison_label");     // Catch: Throwable -> L88
        int r26 = CursorUtil.getColumnIndexOrThrow(r2, "poison_label_version");     // Catch: Throwable -> L88
        int r27 = CursorUtil.getColumnIndexOrThrow(r2, "content_hash");     // Catch: Throwable -> L88
        int r28 = r3;
        ArrayList r29 = new ArrayList(r2.getCount());     // Catch: Throwable -> L88
    L6:
        if (r2.moveToNext() == false) goto L86;
        long r30 = r2.getLong(r0);     // Catch: Throwable -> L88
        if (r2.isNull(r4) == false) goto L11;
        String r32 = null;
    L12:
        long r33 = r2.getLong(r5);     // Catch: Throwable -> L88
        long r35 = r2.getLong(r6);     // Catch: Throwable -> L88
        int r37 = r2.getInt(r7);     // Catch: Throwable -> L88
        long r38 = r2.getLong(r8);     // Catch: Throwable -> L88
        if (r2.isNull(r9) == false) goto L15;
        String r40 = null;
    L16:
        int r41 = r2.getInt(r10);     // Catch: Throwable -> L88
        if (r2.isNull(r11) == false) goto L19;
        String r42 = null;
    L20:
        int r43 = r2.getInt(r12);     // Catch: Throwable -> L88
        if (r2.isNull(r13) == false) goto L23;
        String r44 = null;
    L24:
        int r45 = r2.getInt(r14);     // Catch: Throwable -> L88
        if (r2.isNull(r15) == false) goto L27;
        String r46 = null;
    L29:
        if (r2.isNull(r28) == false) goto L32;
        String r47 = null;
    L31:
        int r56 = r17;
        int r110 = r0;
        if (r2.isNull(r56) == false) goto L37;
        String r48 = null;
    L36:
        int r57 = r18;
        if (r2.isNull(r57) == false) goto L42;
        String r49 = null;
    L41:
        int r58 = r19;
        if (r2.isNull(r58) == false) goto L47;
        String r50 = null;
    L46:
        int r59 = r20;
        if (r2.isNull(r59) == false) goto L52;
        String r51 = null;
    L51:
        int r510 = r21;
        if (r2.isNull(r510) == false) goto L57;
        Long r52 = null;
    L56:
        int r511 = r22;
        if (r2.isNull(r511) == false) goto L62;
        String r53 = null;
    L61:
        int r512 = r23;
        if (r2.isNull(r512) == false) goto L67;
        String r54 = null;
    L66:
        int r513 = r24;
        if (r2.isNull(r513) == false) goto L71;
        String r55 = null;
    L72:
        fj r31 = new fj(r30, r32, r33, r35, r37, r38, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55);     // Catch: Throwable -> L88
        int r210 = r28;
        int r34 = r25;
        if (r2.isNull(r34) == false) goto L75;
        Integer r36 = null;
    L76:
        r31.setPoisonLabel(r36);     // Catch: Throwable -> L88
        r26 = r26;
        if (r2.isNull(r26) == false) goto L79;
        Integer r39 = null;
    L80:
        r31.setPoisonLabelVersion(r39);     // Catch: Throwable -> L88
        r27 = r27;
        if (r2.isNull(r27) == false) goto L83;
        String r60 = null;
    L84:
        r31.setContentHash(r60);     // Catch: Throwable -> L88
        r29.add(r31);     // Catch: Throwable -> L88
        r0 = r110;
        r17 = r56;
        r18 = r57;
        r19 = r58;
        r20 = r59;
        r21 = r510;
        r22 = r511;
        r23 = r512;
        r24 = r513;
        r28 = r210;
        r25 = r34;
        goto L6
    L83:
        r60 = r2.getString(r27);     // Catch: Throwable -> L88
        goto L84
    L79:
        r39 = Integer.valueOf(r2.getInt(r26));     // Catch: Throwable -> L88
        goto L80
    L75:
        r36 = Integer.valueOf(r2.getInt(r34));     // Catch: Throwable -> L88
        goto L76
    L71:
        r55 = r2.getString(r513);     // Catch: Throwable -> L88
        goto L72
    L67:
        r54 = r2.getString(r512);     // Catch: Throwable -> L88
        goto L66
    L62:
        r53 = r2.getString(r511);     // Catch: Throwable -> L88
        goto L61
    L57:
        r52 = Long.valueOf(r2.getLong(r510));     // Catch: Throwable -> L88
        goto L56
    L52:
        r51 = r2.getString(r59);     // Catch: Throwable -> L88
        goto L51
    L47:
        r50 = r2.getString(r58);     // Catch: Throwable -> L88
        goto L46
    L42:
        r49 = r2.getString(r57);     // Catch: Throwable -> L88
        goto L41
    L37:
        r48 = r2.getString(r56);     // Catch: Throwable -> L88
        goto L36
    L32:
        r47 = r2.getString(r28);     // Catch: Throwable -> L88
        goto L31
    L27:
        r46 = r2.getString(r15);     // Catch: Throwable -> L88
        goto L29
    L23:
        r44 = r2.getString(r13);     // Catch: Throwable -> L88
        goto L24
    L19:
        r42 = r2.getString(r11);     // Catch: Throwable -> L88
        goto L20
    L15:
        r40 = r2.getString(r9);     // Catch: Throwable -> L88
        goto L16
    L11:
        r32 = r2.getString(r4);     // Catch: Throwable -> L88
        goto L12
    L86:
        r2.close();
        r16.release();
        return r29;
    L88:
        th = th;
    L92:
        r2.close();
        r16.release();
        throw th;
    L90:
        th = th;
        r16 = r1;
        goto L92
    }

    @Override // com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao
    public i<Integer> getAllRecordingsCount(long r4, long r6) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM RawAuditoryRecordingEntity WHERE createTime >= ? AND createTime < ?", 2);
        r0.bindLong(1, r4);
        r0.bindLong(2, r6);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"RawAuditoryRecordingEntity"}, new AnonymousClass7(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao
    public Object getAllRecordingsMetaInfo(List<String> r9, boolean r10, boolean r11, Continuation<? super List<cu>> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT entityId, type, packageName, \"19700101000000\" as logId FROM RawAuditoryRecordingEntity WHERE (       (NOT ");
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
        return CoroutinesRoom.execute(this.__db, false, r17, new AnonymousClass5(this, r1), r14);
    }

    @Override // com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao
    public Object getAllRecordingsMetaInfoWithTimestamp(List<String> r14, boolean r15, long r16, long r18, boolean r20, Continuation<? super List<cu>> r21) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        StringBuilder r6 = StringUtil.newStringBuilder();
        r6.append("SELECT entityId, type, packageName, \"19700101000000\" as logId FROM RawAuditoryRecordingEntity WHERE ((       (NOT ");
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
        r6.append("))        AND (createTime >= ");
        r6.append("?");
        r6.append(" AND createTime < ");
        r6.append("?");
        r6.append("))");
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
        return CoroutinesRoom.execute(this.__db, false, r2, new AnonymousClass6(this, r10), r5);
    }

    @Override // com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao
    public List<String> getAudioMemoryDateList() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT DISTINCT DATE(datetime(createTime / 1000, 'unixepoch', 'localtime')) FROM RawAuditoryRecordingEntity", 0);
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
        return AuditoryRecordingRawDbDao.DefaultImpls.getCountByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public int getCountByPackageNameWithTimeStamp(String r1, long r2, long r4) {
        return AuditoryRecordingRawDbDao.DefaultImpls.getCountByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<b> getEntitySimpleDataPaging(int r1, long r2) {
        return AuditoryRecordingRawDbDao.DefaultImpls.getEntitySimpleDataPaging(this, r1, r2);
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
        return AuditoryRecordingRawDbDao.DefaultImpls.getHashCodeListByPackageNameWithTimeStamp(this, r1, r2, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public long getLastModifyTimeByPackageName(String r1) {
        return AuditoryRecordingRawDbDao.DefaultImpls.getLastModifyTimeByPackageName(this, r1);
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

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<String> getPackageNameList() {
        return AuditoryRecordingRawDbDao.DefaultImpls.getPackageNameList(this);
    }

    @Override // com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return AuditoryRecordingRawDbDao.DefaultImpls.getTableName(this);
    }

    @Override // com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao
    public List<String> getUUIDListByEntityIds(List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT uuid FROM RawAuditoryRecordingEntity WHERE entityId IN (");
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

    public long insert(fj r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawAuditoryRecordingEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((fj) ZeusTransformUtils.preCheckCast(r3, fj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<fj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawAuditoryRecordingEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fj> queryAll() {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao
    public fj queryByEntityId(String r55) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM RawAuditoryRecordingEntity WHERE entityId = ? LIMIT 1", 1);
        if (r55 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L86
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "entityId");     // Catch: Throwable -> L86
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "createTime");     // Catch: Throwable -> L86
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "modifyTime");     // Catch: Throwable -> L86
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L86
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L86
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L86
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "hashCodeValue");     // Catch: Throwable -> L86
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, ActivityLifecycle.NAME);     // Catch: Throwable -> L86
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "state");     // Catch: Throwable -> L86
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "file");     // Catch: Throwable -> L86
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "duration");     // Catch: Throwable -> L86
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "transcript");     // Catch: Throwable -> L86
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "summary");     // Catch: Throwable -> L86
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "todoList");     // Catch: Throwable -> L84
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "markers");     // Catch: Throwable -> L84
        int r19 = CursorUtil.getColumnIndexOrThrow(r1, "sourceAppName");     // Catch: Throwable -> L84
        int r20 = CursorUtil.getColumnIndexOrThrow(r1, "sourceAppPackage");     // Catch: Throwable -> L84
        int r21 = CursorUtil.getColumnIndexOrThrow(r1, "requestTime");     // Catch: Throwable -> L84
        int r22 = CursorUtil.getColumnIndexOrThrow(r1, "did");     // Catch: Throwable -> L84
        int r23 = CursorUtil.getColumnIndexOrThrow(r1, "docNodeJson");     // Catch: Throwable -> L84
        int r24 = CursorUtil.getColumnIndexOrThrow(r1, Api.KEY_UUID);     // Catch: Throwable -> L84
        int r25 = CursorUtil.getColumnIndexOrThrow(r1, "poison_label");     // Catch: Throwable -> L84
        int r26 = CursorUtil.getColumnIndexOrThrow(r1, "poison_label_version");     // Catch: Throwable -> L84
        int r27 = CursorUtil.getColumnIndexOrThrow(r1, "content_hash");     // Catch: Throwable -> L84
        if (r1.moveToFirst() == false) goto L81;
        long r28 = r1.getLong(r0);     // Catch: Throwable -> L84
        if (r1.isNull(r4) == false) goto L14;
        String r30 = null;
    L15:
        long r31 = r1.getLong(r5);     // Catch: Throwable -> L84
        long r33 = r1.getLong(r6);     // Catch: Throwable -> L84
        int r35 = r1.getInt(r7);     // Catch: Throwable -> L84
        long r36 = r1.getLong(r8);     // Catch: Throwable -> L84
        if (r1.isNull(r9) == false) goto L18;
        String r38 = null;
    L19:
        int r39 = r1.getInt(r10);     // Catch: Throwable -> L84
        if (r1.isNull(r11) == false) goto L22;
        String r40 = null;
    L23:
        int r41 = r1.getInt(r12);     // Catch: Throwable -> L84
        if (r1.isNull(r13) == false) goto L26;
        String r42 = null;
    L27:
        int r43 = r1.getInt(r14);     // Catch: Throwable -> L84
        if (r1.isNull(r15) == false) goto L30;
        String r44 = null;
    L32:
        if (r1.isNull(r3) == false) goto L34;
        String r45 = null;
    L36:
        if (r1.isNull(r55) == false) goto L38;
        String r46 = null;
    L40:
        if (r1.isNull(r17) == false) goto L42;
        String r47 = null;
    L44:
        if (r1.isNull(r18) == false) goto L46;
        String r48 = null;
    L48:
        if (r1.isNull(r19) == false) goto L50;
        String r49 = null;
    L52:
        if (r1.isNull(r20) == false) goto L54;
        Long r50 = null;
    L56:
        if (r1.isNull(r21) == false) goto L58;
        String r51 = null;
    L60:
        if (r1.isNull(r22) == false) goto L62;
        String r52 = null;
    L64:
        if (r1.isNull(r23) == false) goto L66;
        String r53 = null;
    L67:
        fj r29 = new fj(r28, r30, r31, r33, r35, r36, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53);     // Catch: Throwable -> L84
        if (r1.isNull(r25) == false) goto L70;
        Integer r32 = null;
    L71:
        r29.setPoisonLabel(r32);     // Catch: Throwable -> L84
        if (r1.isNull(r26) == false) goto L74;
        Integer r34 = null;
    L75:
        r29.setPoisonLabelVersion(r34);     // Catch: Throwable -> L84
        if (r1.isNull(r27) == false) goto L78;
        String r37 = null;
    L79:
        r29.setContentHash(r37);     // Catch: Throwable -> L84
        fj r54 = r29;
    L82:
        r1.close();
        r16.release();
        return r54;
    L78:
        r37 = r1.getString(r27);     // Catch: Throwable -> L84
        goto L79
    L74:
        r34 = Integer.valueOf(r1.getInt(r26));     // Catch: Throwable -> L84
        goto L75
    L70:
        r32 = Integer.valueOf(r1.getInt(r25));     // Catch: Throwable -> L84
        goto L71
    L66:
        r53 = r1.getString(r24);     // Catch: Throwable -> L84
        goto L67
    L62:
        r52 = r1.getString(r23);     // Catch: Throwable -> L84
        goto L64
    L58:
        r51 = r1.getString(r22);     // Catch: Throwable -> L84
        goto L60
    L54:
        r50 = Long.valueOf(r1.getLong(r21));     // Catch: Throwable -> L84
        goto L56
    L50:
        r49 = r1.getString(r20);     // Catch: Throwable -> L84
        goto L52
    L46:
        r48 = r1.getString(r19);     // Catch: Throwable -> L84
        goto L48
    L42:
        r47 = r1.getString(r18);     // Catch: Throwable -> L84
        goto L44
    L38:
        r46 = r1.getString(r17);     // Catch: Throwable -> L84
        goto L40
    L34:
        r45 = r1.getString(r3);     // Catch: Throwable -> L84
        goto L36
    L30:
        r44 = r1.getString(r15);     // Catch: Throwable -> L84
        goto L32
    L26:
        r42 = r1.getString(r13);     // Catch: Throwable -> L84
        goto L27
    L22:
        r40 = r1.getString(r11);     // Catch: Throwable -> L84
        goto L23
    L18:
        r38 = r1.getString(r9);     // Catch: Throwable -> L84
        goto L19
    L14:
        r30 = r1.getString(r4);     // Catch: Throwable -> L84
        goto L15
    L81:
        r54 = null;
    L84:
        th = th;
    L88:
        r1.close();
        r16.release();
        throw th;
    L86:
        th = th;
        r16 = r2;
        goto L88
    L5:
        r2.bindString(1, r55);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fj> queryByEntityId(String r1, String r2) {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fj> queryByEntityIdList(List<String> r3) {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fj> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao
    public List<fj> queryByEntityIds(List<String> r57) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r57, List.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = StringUtil.newStringBuilder();
        r3.append("SELECT * FROM RawAuditoryRecordingEntity WHERE entityId IN (");
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
        int r0 = CursorUtil.getColumnIndexOrThrow(r8, OaidModel.KEY_ID);     // Catch: Throwable -> L98
        int r9 = CursorUtil.getColumnIndexOrThrow(r8, "entityId");     // Catch: Throwable -> L98
        int r10 = CursorUtil.getColumnIndexOrThrow(r8, "createTime");     // Catch: Throwable -> L98
        int r11 = CursorUtil.getColumnIndexOrThrow(r8, "modifyTime");     // Catch: Throwable -> L98
        int r12 = CursorUtil.getColumnIndexOrThrow(r8, "type");     // Catch: Throwable -> L98
        int r13 = CursorUtil.getColumnIndexOrThrow(r8, "timestamp");     // Catch: Throwable -> L98
        int r14 = CursorUtil.getColumnIndexOrThrow(r8, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L98
        int r15 = CursorUtil.getColumnIndexOrThrow(r8, "hashCodeValue");     // Catch: Throwable -> L98
        int r16 = CursorUtil.getColumnIndexOrThrow(r8, ActivityLifecycle.NAME);     // Catch: Throwable -> L98
        int r17 = CursorUtil.getColumnIndexOrThrow(r8, "state");     // Catch: Throwable -> L98
        int r18 = CursorUtil.getColumnIndexOrThrow(r8, "file");     // Catch: Throwable -> L98
        int r19 = CursorUtil.getColumnIndexOrThrow(r8, "duration");     // Catch: Throwable -> L98
        int r110 = CursorUtil.getColumnIndexOrThrow(r8, "transcript");     // Catch: Throwable -> L98
        int r20 = CursorUtil.getColumnIndexOrThrow(r8, "summary");     // Catch: Throwable -> L98
        RoomSQLiteQuery r58 = r5;
        int r111 = CursorUtil.getColumnIndexOrThrow(r8, "todoList");     // Catch: Throwable -> L96
        int r112 = CursorUtil.getColumnIndexOrThrow(r8, "markers");     // Catch: Throwable -> L96
        int r113 = CursorUtil.getColumnIndexOrThrow(r8, "sourceAppName");     // Catch: Throwable -> L96
        int r114 = CursorUtil.getColumnIndexOrThrow(r8, "sourceAppPackage");     // Catch: Throwable -> L96
        int r21 = CursorUtil.getColumnIndexOrThrow(r8, "requestTime");     // Catch: Throwable -> L96
        int r22 = CursorUtil.getColumnIndexOrThrow(r8, "did");     // Catch: Throwable -> L96
        int r23 = CursorUtil.getColumnIndexOrThrow(r8, "docNodeJson");     // Catch: Throwable -> L96
        int r24 = CursorUtil.getColumnIndexOrThrow(r8, Api.KEY_UUID);     // Catch: Throwable -> L96
        int r25 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label");     // Catch: Throwable -> L96
        int r26 = CursorUtil.getColumnIndexOrThrow(r8, "poison_label_version");     // Catch: Throwable -> L96
        int r27 = CursorUtil.getColumnIndexOrThrow(r8, "content_hash");     // Catch: Throwable -> L96
        int r28 = r20;
        ArrayList r29 = new ArrayList(r8.getCount());     // Catch: Throwable -> L96
    L14:
        if (r8.moveToNext() == false) goto L94;
        long r210 = r8.getLong(r0);     // Catch: Throwable -> L96
        if (r8.isNull(r9) == false) goto L19;
        String r31 = null;
    L20:
        long r32 = r8.getLong(r10);     // Catch: Throwable -> L96
        long r34 = r8.getLong(r11);     // Catch: Throwable -> L96
        int r36 = r8.getInt(r12);     // Catch: Throwable -> L96
        long r37 = r8.getLong(r13);     // Catch: Throwable -> L96
        if (r8.isNull(r14) == false) goto L23;
        String r39 = null;
    L24:
        int r40 = r8.getInt(r15);     // Catch: Throwable -> L96
        if (r8.isNull(r16) == false) goto L27;
        String r41 = null;
    L28:
        int r42 = r8.getInt(r17);     // Catch: Throwable -> L96
        if (r8.isNull(r18) == false) goto L31;
        String r43 = null;
    L32:
        int r44 = r8.getInt(r19);     // Catch: Throwable -> L96
        if (r8.isNull(r110) == false) goto L35;
        String r45 = null;
    L37:
        if (r8.isNull(r28) == false) goto L40;
        String r46 = null;
    L39:
        int r55 = r111;
        int r115 = r0;
        if (r8.isNull(r55) == false) goto L45;
        String r47 = null;
    L44:
        int r56 = r112;
        if (r8.isNull(r56) == false) goto L50;
        String r48 = null;
    L49:
        int r59 = r113;
        if (r8.isNull(r59) == false) goto L55;
        String r49 = null;
    L54:
        int r510 = r114;
        if (r8.isNull(r510) == false) goto L60;
        String r50 = null;
    L59:
        int r511 = r21;
        if (r8.isNull(r511) == false) goto L65;
        Long r51 = null;
    L64:
        int r512 = r22;
        if (r8.isNull(r512) == false) goto L70;
        String r52 = null;
    L69:
        int r513 = r23;
        if (r8.isNull(r513) == false) goto L75;
        String r53 = null;
    L74:
        int r514 = r24;
        if (r8.isNull(r514) == false) goto L79;
        String r54 = null;
    L80:
        fj r30 = new fj(r210, r31, r32, r34, r36, r37, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54);     // Catch: Throwable -> L96
        int r211 = r28;
        int r33 = r25;
        if (r8.isNull(r33) == false) goto L83;
        Integer r35 = null;
    L84:
        r30.setPoisonLabel(r35);     // Catch: Throwable -> L96
        r26 = r26;
        if (r8.isNull(r26) == false) goto L87;
        Integer r38 = null;
    L88:
        r30.setPoisonLabelVersion(r38);     // Catch: Throwable -> L96
        r27 = r27;
        if (r8.isNull(r27) == false) goto L91;
        String r60 = null;
    L92:
        r30.setContentHash(r60);     // Catch: Throwable -> L96
        r29.add(r30);     // Catch: Throwable -> L96
        r0 = r115;
        r111 = r55;
        r112 = r56;
        r113 = r59;
        r114 = r510;
        r21 = r511;
        r22 = r512;
        r23 = r513;
        r24 = r514;
        r28 = r211;
        r25 = r33;
        goto L14
    L91:
        r60 = r8.getString(r27);     // Catch: Throwable -> L96
        goto L92
    L87:
        r38 = Integer.valueOf(r8.getInt(r26));     // Catch: Throwable -> L96
        goto L88
    L83:
        r35 = Integer.valueOf(r8.getInt(r33));     // Catch: Throwable -> L96
        goto L84
    L79:
        r54 = r8.getString(r514);     // Catch: Throwable -> L96
        goto L80
    L75:
        r53 = r8.getString(r513);     // Catch: Throwable -> L96
        goto L74
    L70:
        r52 = r8.getString(r512);     // Catch: Throwable -> L96
        goto L69
    L65:
        r51 = Long.valueOf(r8.getLong(r511));     // Catch: Throwable -> L96
        goto L64
    L60:
        r50 = r8.getString(r510);     // Catch: Throwable -> L96
        goto L59
    L55:
        r49 = r8.getString(r59);     // Catch: Throwable -> L96
        goto L54
    L50:
        r48 = r8.getString(r56);     // Catch: Throwable -> L96
        goto L49
    L45:
        r47 = r8.getString(r55);     // Catch: Throwable -> L96
        goto L44
    L40:
        r46 = r8.getString(r28);     // Catch: Throwable -> L96
        goto L39
    L35:
        r45 = r8.getString(r110);     // Catch: Throwable -> L96
        goto L37
    L31:
        r43 = r8.getString(r18);     // Catch: Throwable -> L96
        goto L32
    L27:
        r41 = r8.getString(r16);     // Catch: Throwable -> L96
        goto L28
    L23:
        r39 = r8.getString(r14);     // Catch: Throwable -> L96
        goto L24
    L19:
        r31 = r8.getString(r9);     // Catch: Throwable -> L96
        goto L20
    L94:
        r8.close();
        r58.release();
        return r29;
    L96:
        th = th;
    L100:
        r8.close();
        r58.release();
        throw th;
    L98:
        th = th;
        r58 = r5;
        goto L100
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fj queryById(long r1) {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fj> queryByIdAndTimestamp(long r1, long r3) {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryByIdAndTimestamp(this, r1, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fj> queryByIds(List<Long> r3) {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public Cursor queryByPackageName(String[] r1, String r2, int r3, Long r4) {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryByPackageName(this, r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fj> queryByPackageName(String r1) {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryByPackageName(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fj> queryByPackageNameBeforeTimestampWithLimit(String r1, long r2, int r4, long r5) {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryByPackageNameBeforeTimestampWithLimit(this, r1, r2, r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fj> queryByPackageNameWithLimit(String r1, int r2, long r3) {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryByPackageNameWithLimit(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fj queryByUUID(String r1) {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao
    public List<fj> queryContextAwarenessAudioPage(long r49, long r51, long r53, String r55, int r56, int r57) {
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("\n        SELECT * FROM RawAuditoryRecordingEntity\n        WHERE createTime >= ?\n            AND createTime < ?\n            AND (\n                createTime < ?\n                OR (\n                    createTime = ?\n                    AND (? = 1 OR entityId < ?)\n                )\n            )\n        ORDER BY createTime DESC, entityId DESC\n        LIMIT ?\n        ", 7);
        r4.bindLong(1, r49);
        r4.bindLong(2, r51);
        r4.bindLong(3, r53);
        r4.bindLong(4, r53);
        r4.bindLong(5, r56);
        if (r55 != null) goto L5;
        r4.bindNull(6);
    L6:
        r4.bindLong(7, r57);
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r4, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L94
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "entityId");     // Catch: Throwable -> L94
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "createTime");     // Catch: Throwable -> L94
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "modifyTime");     // Catch: Throwable -> L94
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L94
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L94
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L94
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "hashCodeValue");     // Catch: Throwable -> L94
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, ActivityLifecycle.NAME);     // Catch: Throwable -> L94
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "state");     // Catch: Throwable -> L94
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "file");     // Catch: Throwable -> L94
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "duration");     // Catch: Throwable -> L94
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "transcript");     // Catch: Throwable -> L94
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, "summary");     // Catch: Throwable -> L94
        RoomSQLiteQuery r16 = r4;
        int r410 = CursorUtil.getColumnIndexOrThrow(r1, "todoList");     // Catch: Throwable -> L92
        int r50 = CursorUtil.getColumnIndexOrThrow(r1, "markers");     // Catch: Throwable -> L92
        int r52 = CursorUtil.getColumnIndexOrThrow(r1, "sourceAppName");     // Catch: Throwable -> L92
        int r54 = CursorUtil.getColumnIndexOrThrow(r1, "sourceAppPackage");     // Catch: Throwable -> L92
        int r58 = CursorUtil.getColumnIndexOrThrow(r1, "requestTime");     // Catch: Throwable -> L92
        int r59 = CursorUtil.getColumnIndexOrThrow(r1, "did");     // Catch: Throwable -> L92
        int r510 = CursorUtil.getColumnIndexOrThrow(r1, "docNodeJson");     // Catch: Throwable -> L92
        int r511 = CursorUtil.getColumnIndexOrThrow(r1, Api.KEY_UUID);     // Catch: Throwable -> L92
        int r512 = CursorUtil.getColumnIndexOrThrow(r1, "poison_label");     // Catch: Throwable -> L92
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "poison_label_version");     // Catch: Throwable -> L92
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "content_hash");     // Catch: Throwable -> L92
        int r19 = r2;
        ArrayList r20 = new ArrayList(r1.getCount());     // Catch: Throwable -> L92
    L10:
        if (r1.moveToNext() == false) goto L90;
        long r21 = r1.getLong(r0);     // Catch: Throwable -> L92
        if (r1.isNull(r3) == false) goto L15;
        String r23 = null;
    L16:
        long r24 = r1.getLong(r5);     // Catch: Throwable -> L92
        long r26 = r1.getLong(r6);     // Catch: Throwable -> L92
        int r28 = r1.getInt(r7);     // Catch: Throwable -> L92
        long r29 = r1.getLong(r8);     // Catch: Throwable -> L92
        if (r1.isNull(r9) == false) goto L19;
        String r31 = null;
    L20:
        int r32 = r1.getInt(r10);     // Catch: Throwable -> L92
        if (r1.isNull(r11) == false) goto L23;
        String r33 = null;
    L24:
        int r34 = r1.getInt(r12);     // Catch: Throwable -> L92
        if (r1.isNull(r13) == false) goto L27;
        String r35 = null;
    L28:
        int r36 = r1.getInt(r14);     // Catch: Throwable -> L92
        if (r1.isNull(r15) == false) goto L31;
        String r37 = null;
    L33:
        if (r1.isNull(r19) == false) goto L36;
        String r38 = null;
    L35:
        int r47 = r0;
        int r22 = r410;
        if (r1.isNull(r22) == false) goto L41;
        String r39 = null;
    L40:
        r50 = r50;
        if (r1.isNull(r50) == false) goto L46;
        String r40 = null;
    L45:
        r52 = r52;
        if (r1.isNull(r52) == false) goto L51;
        String r41 = null;
    L50:
        r54 = r54;
        if (r1.isNull(r54) == false) goto L56;
        String r42 = null;
    L55:
        r58 = r58;
        if (r1.isNull(r58) == false) goto L61;
        Long r43 = null;
    L60:
        r59 = r59;
        if (r1.isNull(r59) == false) goto L66;
        String r44 = null;
    L65:
        r510 = r510;
        if (r1.isNull(r510) == false) goto L71;
        String r45 = null;
    L70:
        r511 = r511;
        if (r1.isNull(r511) == false) goto L75;
        String r46 = null;
    L76:
        fj r25 = new fj(r21, r23, r24, r26, r28, r29, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46);     // Catch: Throwable -> L92
        int r27 = r19;
        r512 = r512;
        if (r1.isNull(r512) == false) goto L79;
        Integer r30 = null;
    L80:
        r25.setPoisonLabel(r30);     // Catch: Throwable -> L92
        int r48 = r17;
        if (r1.isNull(r48) == false) goto L83;
        Integer r60 = null;
    L84:
        r25.setPoisonLabelVersion(r60);     // Catch: Throwable -> L92
        r18 = r18;
        if (r1.isNull(r18) == false) goto L87;
        String r61 = null;
    L88:
        r25.setContentHash(r61);     // Catch: Throwable -> L92
        r20.add(r25);     // Catch: Throwable -> L92
        r0 = r47;
        r410 = r22;
        r19 = r27;
        r17 = r48;
        goto L10
    L87:
        r61 = r1.getString(r18);     // Catch: Throwable -> L92
        goto L88
    L83:
        r60 = Integer.valueOf(r1.getInt(r48));     // Catch: Throwable -> L92
        goto L84
    L79:
        r30 = Integer.valueOf(r1.getInt(r512));     // Catch: Throwable -> L92
        goto L80
    L75:
        r46 = r1.getString(r511);     // Catch: Throwable -> L92
        goto L76
    L71:
        r45 = r1.getString(r510);     // Catch: Throwable -> L92
        goto L70
    L66:
        r44 = r1.getString(r59);     // Catch: Throwable -> L92
        goto L65
    L61:
        r43 = Long.valueOf(r1.getLong(r58));     // Catch: Throwable -> L92
        goto L60
    L56:
        r42 = r1.getString(r54);     // Catch: Throwable -> L92
        goto L55
    L51:
        r41 = r1.getString(r52);     // Catch: Throwable -> L92
        goto L50
    L46:
        r40 = r1.getString(r50);     // Catch: Throwable -> L92
        goto L45
    L41:
        r39 = r1.getString(r22);     // Catch: Throwable -> L92
        goto L40
    L36:
        r38 = r1.getString(r19);     // Catch: Throwable -> L92
        goto L35
    L31:
        r37 = r1.getString(r15);     // Catch: Throwable -> L92
        goto L33
    L27:
        r35 = r1.getString(r13);     // Catch: Throwable -> L92
        goto L28
    L23:
        r33 = r1.getString(r11);     // Catch: Throwable -> L92
        goto L24
    L19:
        r31 = r1.getString(r9);     // Catch: Throwable -> L92
        goto L20
    L15:
        r23 = r1.getString(r3);     // Catch: Throwable -> L92
        goto L16
    L90:
        r1.close();
        r16.release();
        return r20;
    L92:
        th = th;
    L96:
        r1.close();
        r16.release();
        throw th;
    L94:
        th = th;
        r16 = r4;
        goto L96
    L5:
        r4.bindString(6, r55);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao
    public List<fj> queryContextAwarenessAudioPageBefore(long r49, long r51, long r53, String r55, int r56, int r57) {
        RoomSQLiteQuery r4 = RoomSQLiteQuery.acquire("\n        SELECT * FROM RawAuditoryRecordingEntity\n        WHERE createTime >= ?\n            AND createTime < ?\n            AND (\n                createTime > ?\n                OR (\n                    createTime = ?\n                    AND (? = 1 OR entityId > ?)\n                )\n            )\n        ORDER BY createTime ASC, entityId ASC\n        LIMIT ?\n        ", 7);
        r4.bindLong(1, r49);
        r4.bindLong(2, r51);
        r4.bindLong(3, r53);
        r4.bindLong(4, r53);
        r4.bindLong(5, r56);
        if (r55 != null) goto L5;
        r4.bindNull(6);
    L6:
        r4.bindLong(7, r57);
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r4, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L94
        int r3 = CursorUtil.getColumnIndexOrThrow(r1, "entityId");     // Catch: Throwable -> L94
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "createTime");     // Catch: Throwable -> L94
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "modifyTime");     // Catch: Throwable -> L94
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "type");     // Catch: Throwable -> L94
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "timestamp");     // Catch: Throwable -> L94
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, ObricMemoryConstants.KEY_PACKAGE_NAME);     // Catch: Throwable -> L94
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "hashCodeValue");     // Catch: Throwable -> L94
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, ActivityLifecycle.NAME);     // Catch: Throwable -> L94
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "state");     // Catch: Throwable -> L94
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "file");     // Catch: Throwable -> L94
        int r14 = CursorUtil.getColumnIndexOrThrow(r1, "duration");     // Catch: Throwable -> L94
        int r15 = CursorUtil.getColumnIndexOrThrow(r1, "transcript");     // Catch: Throwable -> L94
        int r2 = CursorUtil.getColumnIndexOrThrow(r1, "summary");     // Catch: Throwable -> L94
        RoomSQLiteQuery r16 = r4;
        int r410 = CursorUtil.getColumnIndexOrThrow(r1, "todoList");     // Catch: Throwable -> L92
        int r50 = CursorUtil.getColumnIndexOrThrow(r1, "markers");     // Catch: Throwable -> L92
        int r52 = CursorUtil.getColumnIndexOrThrow(r1, "sourceAppName");     // Catch: Throwable -> L92
        int r54 = CursorUtil.getColumnIndexOrThrow(r1, "sourceAppPackage");     // Catch: Throwable -> L92
        int r58 = CursorUtil.getColumnIndexOrThrow(r1, "requestTime");     // Catch: Throwable -> L92
        int r59 = CursorUtil.getColumnIndexOrThrow(r1, "did");     // Catch: Throwable -> L92
        int r510 = CursorUtil.getColumnIndexOrThrow(r1, "docNodeJson");     // Catch: Throwable -> L92
        int r511 = CursorUtil.getColumnIndexOrThrow(r1, Api.KEY_UUID);     // Catch: Throwable -> L92
        int r512 = CursorUtil.getColumnIndexOrThrow(r1, "poison_label");     // Catch: Throwable -> L92
        int r17 = CursorUtil.getColumnIndexOrThrow(r1, "poison_label_version");     // Catch: Throwable -> L92
        int r18 = CursorUtil.getColumnIndexOrThrow(r1, "content_hash");     // Catch: Throwable -> L92
        int r19 = r2;
        ArrayList r20 = new ArrayList(r1.getCount());     // Catch: Throwable -> L92
    L10:
        if (r1.moveToNext() == false) goto L90;
        long r21 = r1.getLong(r0);     // Catch: Throwable -> L92
        if (r1.isNull(r3) == false) goto L15;
        String r23 = null;
    L16:
        long r24 = r1.getLong(r5);     // Catch: Throwable -> L92
        long r26 = r1.getLong(r6);     // Catch: Throwable -> L92
        int r28 = r1.getInt(r7);     // Catch: Throwable -> L92
        long r29 = r1.getLong(r8);     // Catch: Throwable -> L92
        if (r1.isNull(r9) == false) goto L19;
        String r31 = null;
    L20:
        int r32 = r1.getInt(r10);     // Catch: Throwable -> L92
        if (r1.isNull(r11) == false) goto L23;
        String r33 = null;
    L24:
        int r34 = r1.getInt(r12);     // Catch: Throwable -> L92
        if (r1.isNull(r13) == false) goto L27;
        String r35 = null;
    L28:
        int r36 = r1.getInt(r14);     // Catch: Throwable -> L92
        if (r1.isNull(r15) == false) goto L31;
        String r37 = null;
    L33:
        if (r1.isNull(r19) == false) goto L36;
        String r38 = null;
    L35:
        int r47 = r0;
        int r22 = r410;
        if (r1.isNull(r22) == false) goto L41;
        String r39 = null;
    L40:
        r50 = r50;
        if (r1.isNull(r50) == false) goto L46;
        String r40 = null;
    L45:
        r52 = r52;
        if (r1.isNull(r52) == false) goto L51;
        String r41 = null;
    L50:
        r54 = r54;
        if (r1.isNull(r54) == false) goto L56;
        String r42 = null;
    L55:
        r58 = r58;
        if (r1.isNull(r58) == false) goto L61;
        Long r43 = null;
    L60:
        r59 = r59;
        if (r1.isNull(r59) == false) goto L66;
        String r44 = null;
    L65:
        r510 = r510;
        if (r1.isNull(r510) == false) goto L71;
        String r45 = null;
    L70:
        r511 = r511;
        if (r1.isNull(r511) == false) goto L75;
        String r46 = null;
    L76:
        fj r25 = new fj(r21, r23, r24, r26, r28, r29, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46);     // Catch: Throwable -> L92
        int r27 = r19;
        r512 = r512;
        if (r1.isNull(r512) == false) goto L79;
        Integer r30 = null;
    L80:
        r25.setPoisonLabel(r30);     // Catch: Throwable -> L92
        int r48 = r17;
        if (r1.isNull(r48) == false) goto L83;
        Integer r60 = null;
    L84:
        r25.setPoisonLabelVersion(r60);     // Catch: Throwable -> L92
        r18 = r18;
        if (r1.isNull(r18) == false) goto L87;
        String r61 = null;
    L88:
        r25.setContentHash(r61);     // Catch: Throwable -> L92
        r20.add(r25);     // Catch: Throwable -> L92
        r0 = r47;
        r410 = r22;
        r19 = r27;
        r17 = r48;
        goto L10
    L87:
        r61 = r1.getString(r18);     // Catch: Throwable -> L92
        goto L88
    L83:
        r60 = Integer.valueOf(r1.getInt(r48));     // Catch: Throwable -> L92
        goto L84
    L79:
        r30 = Integer.valueOf(r1.getInt(r512));     // Catch: Throwable -> L92
        goto L80
    L75:
        r46 = r1.getString(r511);     // Catch: Throwable -> L92
        goto L76
    L71:
        r45 = r1.getString(r510);     // Catch: Throwable -> L92
        goto L70
    L66:
        r44 = r1.getString(r59);     // Catch: Throwable -> L92
        goto L65
    L61:
        r43 = Long.valueOf(r1.getLong(r58));     // Catch: Throwable -> L92
        goto L60
    L56:
        r42 = r1.getString(r54);     // Catch: Throwable -> L92
        goto L55
    L51:
        r41 = r1.getString(r52);     // Catch: Throwable -> L92
        goto L50
    L46:
        r40 = r1.getString(r50);     // Catch: Throwable -> L92
        goto L45
    L41:
        r39 = r1.getString(r22);     // Catch: Throwable -> L92
        goto L40
    L36:
        r38 = r1.getString(r19);     // Catch: Throwable -> L92
        goto L35
    L31:
        r37 = r1.getString(r15);     // Catch: Throwable -> L92
        goto L33
    L27:
        r35 = r1.getString(r13);     // Catch: Throwable -> L92
        goto L28
    L23:
        r33 = r1.getString(r11);     // Catch: Throwable -> L92
        goto L24
    L19:
        r31 = r1.getString(r9);     // Catch: Throwable -> L92
        goto L20
    L15:
        r23 = r1.getString(r3);     // Catch: Throwable -> L92
        goto L16
    L90:
        r1.close();
        r16.release();
        return r20;
    L92:
        th = th;
    L96:
        r1.close();
        r16.release();
        throw th;
    L94:
        th = th;
        r16 = r4;
        goto L96
    L5:
        r4.bindString(6, r55);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fj queryOne() {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.IAppEntityRawDbDao
    public List<fj> queryRecentByPackageName(String r1, long r2) {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryRecentByPackageName(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fj> queryWithLimitAndOffset(int r1, int r2) {
        return AuditoryRecordingRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fj> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawAuditoryRecordingEntity(r6));     // Catch: Throwable -> L10
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

    public int update(fj r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawAuditoryRecordingEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((fj) ZeusTransformUtils.preCheckCast(r3, fj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<fj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawAuditoryRecordingEntity.handleMultiple(r4);     // Catch: Throwable -> L6
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
        return AuditoryRecordingRawDbDao.DefaultImpls.updatePoisonLabelIfContentHashMatches(this, r1, r2, r3, r4);
    }
}
