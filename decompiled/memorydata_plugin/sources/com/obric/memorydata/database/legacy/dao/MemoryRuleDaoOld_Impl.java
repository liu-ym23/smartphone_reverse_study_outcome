package com.obric.memorydata.database.legacy.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.legacy.entity.MemoryRuleEntityOld;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryRuleDaoOld_Impl implements ag {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<MemoryRuleEntityOld> __deletionAdapterOfMemoryRuleEntityOld;
    private final EntityInsertionAdapter<MemoryRuleEntityOld> __insertionAdapterOfMemoryRuleEntityOld;
    private final EntityDeletionOrUpdateAdapter<MemoryRuleEntityOld> __updateAdapterOfMemoryRuleEntityOld;

    public MemoryRuleDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryRuleEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfMemoryRuleEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfMemoryRuleEntityOld = new AnonymousClass3(this, r2);
    }

    private MemoryRuleEntityOld __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityMemoryRuleEntityOld(Cursor r61) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r61, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "title");
        int r3 = CursorUtil.getColumnIndex(r0, Params.CONTENT);
        int r4 = CursorUtil.getColumnIndex(r0, "appPackages");
        int r5 = CursorUtil.getColumnIndex(r0, "imageFilterQuery");
        int r6 = CursorUtil.getColumnIndex(r0, "imageFilterModelVersion");
        int r7 = CursorUtil.getColumnIndex(r0, "clientModelQuery");
        int r8 = CursorUtil.getColumnIndex(r0, "clientModelVersion");
        int r9 = CursorUtil.getColumnIndex(r0, "useClientModel");
        int r10 = CursorUtil.getColumnIndex(r0, "memoryCount");
        int r11 = CursorUtil.getColumnIndex(r0, AILabCheckPermissionTask.KEY_SOURCE);
        int r12 = CursorUtil.getColumnIndex(r0, "triggerMode");
        int r13 = CursorUtil.getColumnIndex(r0, "cronExpression");
        int r14 = CursorUtil.getColumnIndex(r0, "memoryInfoJson");
        int r15 = CursorUtil.getColumnIndex(r0, "isPaused");
        int r16 = CursorUtil.getColumnIndex(r0, "autoCaptureEnabled");
        int r17 = CursorUtil.getColumnIndex(r0, "isFromPreset");
        int r18 = CursorUtil.getColumnIndex(r0, "canDisplay");
        int r19 = CursorUtil.getColumnIndex(r0, "ruleSettingsVersion");
        int r110 = CursorUtil.getColumnIndex(r0, "activeStartMinute");
        int r111 = CursorUtil.getColumnIndex(r0, "activeEndMinute");
        int r112 = CursorUtil.getColumnIndex(r0, "iconKey");
        int r113 = CursorUtil.getColumnIndex(r0, "iconColorKey");
        int r114 = CursorUtil.getColumnIndex(r0, "iconGenerateVersion");
        int r115 = CursorUtil.getColumnIndex(r0, "lastExposedAutoMemoryId");
        int r116 = CursorUtil.getColumnIndex(r0, "personalDbSplitMigrated");
        long r25 = 0;
        if (r1 != (-1)) goto L5;
        long r31 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r33 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r34 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r35 = null;
    L25:
        if (r5 != (-1)) goto L28;
    L26:
        String r36 = null;
    L31:
        if (r6 != (-1)) goto L34;
    L32:
        String r37 = null;
    L37:
        if (r7 != (-1)) goto L40;
    L38:
        String r38 = null;
    L43:
        if (r8 != (-1)) goto L46;
    L44:
        String r39 = null;
    L49:
        boolean r21 = true;
        if (r9 != (-1)) goto L53;
        boolean r40 = false;
    L57:
        if (r10 != (-1)) goto L59;
        long r41 = 0;
    L60:
        if (r11 != (-1)) goto L63;
    L61:
        String r43 = null;
    L66:
        if (r12 != (-1)) goto L69;
    L67:
        String r44 = null;
    L72:
        if (r13 != (-1)) goto L75;
    L73:
        String r45 = null;
    L78:
        if (r14 != (-1)) goto L81;
    L79:
        String r46 = null;
    L84:
        if (r60 != (-1)) goto L87;
        boolean r47 = false;
    L91:
        if (r61 != (-1)) goto L95;
        boolean r48 = false;
    L99:
        if (r17 != (-1)) goto L103;
        boolean r49 = false;
    L107:
        if (r18 != (-1)) goto L111;
        boolean r50 = false;
    L115:
        if (r19 != (-1)) goto L117;
        int r51 = 0;
    L119:
        if (r110 != (-1)) goto L121;
        int r52 = 0;
    L123:
        if (r111 != (-1)) goto L125;
        int r53 = 0;
    L127:
        if (r112 != (-1)) goto L131;
    L128:
        String r54 = null;
    L134:
        if (r113 != (-1)) goto L138;
    L135:
        String r55 = null;
    L141:
        if (r114 != (-1)) goto L144;
    L142:
        String r56 = r20;
        if (r115 == (-1)) goto L150;
        r25 = r0.getLong(r115);
    L150:
        long r57 = r25;
        if (r116 != (-1)) goto L154;
        boolean r59 = false;
    L159:
        return new MemoryRuleEntityOld(r31, r33, r34, r35, r36, r37, r38, r39, r40, r41, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r59);
    L154:
        if (r0.getInt(r116) != 0) goto L157;
        r21 = false;
    L157:
        r59 = r21;
        goto L159
    L144:
        if (r0.isNull(r114) == true) goto L142;
        r20 = r0.getString(r114);
        goto L142
    L138:
        if (r0.isNull(r113) == true) goto L135;
        r55 = r0.getString(r113);
        goto L141
    L131:
        if (r0.isNull(r112) == true) goto L128;
        r54 = r0.getString(r112);
        goto L134
    L125:
        r53 = r0.getInt(r111);
        goto L127
    L121:
        r52 = r0.getInt(r110);
        goto L123
    L117:
        r51 = r0.getInt(r19);
        goto L119
    L111:
        if (r0.getInt(r18) == 0) goto L113;
        boolean r22 = true;
    L114:
        r50 = r22;
        goto L115
    L113:
        r22 = false;
        goto L114
    L103:
        if (r0.getInt(r17) == 0) goto L105;
        boolean r23 = true;
    L106:
        r49 = r23;
        goto L107
    L105:
        r23 = false;
        goto L106
    L95:
        if (r0.getInt(r16) == 0) goto L97;
        boolean r24 = true;
    L98:
        r48 = r24;
        goto L99
    L97:
        r24 = false;
        goto L98
    L87:
        if (r0.getInt(r15) == 0) goto L89;
        boolean r26 = true;
    L90:
        r47 = r26;
        goto L91
    L89:
        r26 = false;
        goto L90
    L81:
        if (r0.isNull(r14) == true) goto L79;
        r46 = r0.getString(r14);
        goto L84
    L75:
        if (r0.isNull(r13) == true) goto L73;
        r45 = r0.getString(r13);
        goto L78
    L69:
        if (r0.isNull(r12) == true) goto L67;
        r44 = r0.getString(r12);
        goto L72
    L63:
        if (r0.isNull(r11) == true) goto L61;
        r43 = r0.getString(r11);
        goto L66
    L59:
        r41 = r0.getLong(r10);
        goto L60
    L53:
        if (r0.getInt(r9) == 0) goto L55;
        boolean r27 = true;
    L56:
        r40 = r27;
        goto L57
    L55:
        r27 = false;
        goto L56
    L46:
        if (r0.isNull(r8) == true) goto L44;
        r39 = r0.getString(r8);
        goto L49
    L40:
        if (r0.isNull(r7) == true) goto L38;
        r38 = r0.getString(r7);
        goto L43
    L34:
        if (r0.isNull(r6) == true) goto L32;
        r37 = r0.getString(r6);
        goto L37
    L28:
        if (r0.isNull(r5) == true) goto L26;
        r36 = r0.getString(r5);
        goto L31
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r35 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r34 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r33 = r0.getString(r2);
        goto L13
    L5:
        r31 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<MemoryRuleEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMemoryRuleEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<MemoryRuleEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMemoryRuleEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(MemoryRuleEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMemoryRuleEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(MemoryRuleEntityOld r3) {
        return delete2((MemoryRuleEntityOld) ZeusTransformUtils.preCheckCast(r3, MemoryRuleEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ag.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ag.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(MemoryRuleEntityOld r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryRuleEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(MemoryRuleEntityOld r3) {
        return insert2((MemoryRuleEntityOld) ZeusTransformUtils.preCheckCast(r3, MemoryRuleEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<MemoryRuleEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryRuleEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryRuleEntityOld> queryAll() {
        return ag.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ag.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryRuleEntityOld queryById(long r1) {
        return ag.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryRuleEntityOld queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryRuleEntityOld> queryByIds(List<Long> r3) {
        return ag.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryRuleEntityOld queryByUUID(String r1) {
        return ag.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryRuleEntityOld queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryRuleEntityOld queryOne() {
        return ag.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryRuleEntityOld queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryRuleEntityOld> queryWithLimitAndOffset(int r1, int r2) {
        return ag.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryRuleEntityOld> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityMemoryRuleEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(MemoryRuleEntityOld r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMemoryRuleEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(MemoryRuleEntityOld r3) {
        return update2((MemoryRuleEntityOld) ZeusTransformUtils.preCheckCast(r3, MemoryRuleEntityOld.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<MemoryRuleEntityOld> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMemoryRuleEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
