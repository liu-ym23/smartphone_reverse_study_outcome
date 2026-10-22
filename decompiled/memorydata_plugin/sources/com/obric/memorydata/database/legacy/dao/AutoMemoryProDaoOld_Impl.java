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
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.legacy.entity.AutoMemoryProEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoMemoryProDaoOld_Impl implements e {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<AutoMemoryProEntityOld> __deletionAdapterOfAutoMemoryProEntityOld;
    private final EntityInsertionAdapter<AutoMemoryProEntityOld> __insertionAdapterOfAutoMemoryProEntityOld;
    private final EntityDeletionOrUpdateAdapter<AutoMemoryProEntityOld> __updateAdapterOfAutoMemoryProEntityOld;

    public AutoMemoryProDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAutoMemoryProEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfAutoMemoryProEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfAutoMemoryProEntityOld = new AnonymousClass3(this, r2);
    }

    private AutoMemoryProEntityOld __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityAutoMemoryProEntityOld(Cursor r58) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r58, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "entityId");
        int r3 = CursorUtil.getColumnIndex(r0, "createTime");
        int r4 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r5 = CursorUtil.getColumnIndex(r0, "type");
        int r6 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r7 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r8 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r9 = CursorUtil.getColumnIndex(r0, "rule_id");
        int r10 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r11 = CursorUtil.getColumnIndex(r0, "title");
        int r12 = CursorUtil.getColumnIndex(r0, Params.CONTENT);
        int r13 = CursorUtil.getColumnIndex(r0, "subtitle");
        int r14 = CursorUtil.getColumnIndex(r0, InfoRequestQPSOptTraceLogger.REASON);
        int r15 = CursorUtil.getColumnIndex(r0, "log_id");
        int r16 = CursorUtil.getColumnIndex(r0, "trace_id");
        int r17 = CursorUtil.getColumnIndex(r0, "package_names");
        int r18 = CursorUtil.getColumnIndex(r0, "episodic_ids");
        int r19 = CursorUtil.getColumnIndex(r0, "semantic_ids");
        int r110 = CursorUtil.getColumnIndex(r0, "raw_observation_ids");
        int r111 = CursorUtil.getColumnIndex(r0, "fullContent");
        int r112 = CursorUtil.getColumnIndex(r0, "personalDbSplitMigrated");
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
        boolean r21 = false;
        if (r5 != (-1)) goto L22;
        int r37 = 0;
    L23:
        if (r6 != (-1)) goto L26;
    L24:
        String r38 = null;
    L29:
        if (r7 != (-1)) goto L31;
        int r39 = 0;
    L32:
        if (r8 != (-1)) goto L35;
    L33:
        String r40 = null;
    L38:
        if (r9 != (-1)) goto L40;
        long r41 = 0;
    L41:
        if (r10 == (-1)) goto L44;
        r24 = r0.getLong(r10);
    L44:
        long r43 = r24;
        if (r11 != (-1)) goto L48;
    L46:
        String r45 = null;
    L51:
        if (r12 != (-1)) goto L54;
    L52:
        String r46 = null;
    L57:
        if (r13 != (-1)) goto L60;
    L58:
        String r47 = null;
    L63:
        if (r14 != (-1)) goto L66;
    L64:
        String r48 = null;
    L69:
        if (r57 != (-1)) goto L72;
    L70:
        String r49 = null;
    L75:
        if (r58 != (-1)) goto L77;
        int r50 = 0;
    L79:
        if (r17 != (-1)) goto L83;
    L80:
        String r51 = null;
    L86:
        if (r18 != (-1)) goto L90;
    L87:
        String r52 = null;
    L93:
        if (r19 != (-1)) goto L97;
    L94:
        String r53 = null;
    L100:
        if (r110 != (-1)) goto L104;
    L101:
        String r54 = null;
    L107:
        if (r111 != (-1)) goto L111;
    L108:
        String r55 = null;
    L114:
        if (r112 != (-1)) goto L117;
    L119:
        AutoMemoryProEntityOld r22 = new AutoMemoryProEntityOld(r30, r32, r33, r35, r37, r38, r39, r40, r41, r43, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r21);
        if (r113 == (-1)) goto L127;
        if (r0.isNull(r113) == false) goto L124;
        Integer r23 = null;
    L125:
        r22.setPoisonLabel(r23);
        goto L127
    L124:
        r23 = Integer.valueOf(r0.getInt(r113));
    L127:
        if (r114 == (-1)) goto L134;
        if (r0.isNull(r114) == false) goto L131;
        Integer r25 = null;
    L132:
        r22.setPoisonLabelVersion(r25);
        goto L134
    L131:
        r25 = Integer.valueOf(r0.getInt(r114));
    L134:
        if (r115 != (-1)) goto L136;
    L140:
        return r22;
    L136:
        if (r0.isNull(r115) == true) goto L139;
        r20 = r0.getString(r115);
    L139:
        r22.setContentHash(r20);
        goto L140
    L117:
        if (r0.getInt(r112) == 0) goto L119;
        r21 = true;
        goto L119
    L111:
        if (r0.isNull(r111) == true) goto L108;
        r55 = r0.getString(r111);
        goto L114
    L104:
        if (r0.isNull(r110) == true) goto L101;
        r54 = r0.getString(r110);
        goto L107
    L97:
        if (r0.isNull(r19) == true) goto L94;
        r53 = r0.getString(r19);
        goto L100
    L90:
        if (r0.isNull(r18) == true) goto L87;
        r52 = r0.getString(r18);
        goto L93
    L83:
        if (r0.isNull(r17) == true) goto L80;
        r51 = r0.getString(r17);
        goto L86
    L77:
        r50 = r0.getInt(r16);
        goto L79
    L72:
        if (r0.isNull(r57) == true) goto L70;
        r49 = r0.getString(r15);
        goto L75
    L66:
        if (r0.isNull(r14) == true) goto L64;
        r48 = r0.getString(r14);
        goto L69
    L60:
        if (r0.isNull(r13) == true) goto L58;
        r47 = r0.getString(r13);
        goto L63
    L54:
        if (r0.isNull(r12) == true) goto L52;
        r46 = r0.getString(r12);
        goto L57
    L48:
        if (r0.isNull(r11) == true) goto L46;
        r45 = r0.getString(r11);
        goto L51
    L40:
        r41 = r0.getLong(r9);
        goto L41
    L35:
        if (r0.isNull(r8) == true) goto L33;
        r40 = r0.getString(r8);
        goto L38
    L31:
        r39 = r0.getInt(r7);
        goto L32
    L26:
        if (r0.isNull(r6) == true) goto L24;
        r38 = r0.getString(r6);
        goto L29
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

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<AutoMemoryProEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAutoMemoryProEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<AutoMemoryProEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAutoMemoryProEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(AutoMemoryProEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAutoMemoryProEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(AutoMemoryProEntityOld r3) {
        return delete2((AutoMemoryProEntityOld) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return e.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return e.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(AutoMemoryProEntityOld r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAutoMemoryProEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(AutoMemoryProEntityOld r3) {
        return insert2((AutoMemoryProEntityOld) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<AutoMemoryProEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAutoMemoryProEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProEntityOld> queryAll() {
        return e.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return e.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProEntityOld queryById(long r1) {
        return e.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AutoMemoryProEntityOld queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProEntityOld> queryByIds(List<Long> r3) {
        return e.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProEntityOld queryByUUID(String r1) {
        return e.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AutoMemoryProEntityOld queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProEntityOld queryOne() {
        return e.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AutoMemoryProEntityOld queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProEntityOld> queryWithLimitAndOffset(int r1, int r2) {
        return e.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProEntityOld> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityAutoMemoryProEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(AutoMemoryProEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAutoMemoryProEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(AutoMemoryProEntityOld r3) {
        return update2((AutoMemoryProEntityOld) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<AutoMemoryProEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAutoMemoryProEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
