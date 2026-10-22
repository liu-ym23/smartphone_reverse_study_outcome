package com.obric.memorydata.database.legacy.backup.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.legacy.entity.MemoryRuleEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class BackUpMemoryRuleDaoOld_Impl implements n {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.n> __deletionAdapterOfBackUpMemoryRuleEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.n> __insertionAdapterOfBackUpMemoryRuleEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.n> __insertionAdapterOfBackUpMemoryRuleEntityOld_1;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.n> __updateAdapterOfBackUpMemoryRuleEntityOld;

    public BackUpMemoryRuleDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBackUpMemoryRuleEntityOld = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfBackUpMemoryRuleEntityOld_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfBackUpMemoryRuleEntityOld = new AnonymousClass3(this, r2);
        this.__updateAdapterOfBackUpMemoryRuleEntityOld = new AnonymousClass4(this, r2);
    }

    private com.obric.memorydata.database.legacy.backup.a.n __entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpMemoryRuleEntityOld(Cursor r70) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r70, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "backupUserId");
        int r3 = CursorUtil.getColumnIndex(r0, "backupDbVersion");
        int r4 = CursorUtil.getColumnIndex(r0, "backup_id");
        int r5 = CursorUtil.getColumnIndex(r0, "backup_title");
        int r6 = CursorUtil.getColumnIndex(r0, "backup_content");
        int r7 = CursorUtil.getColumnIndex(r0, "backup_appPackages");
        int r8 = CursorUtil.getColumnIndex(r0, "backup_imageFilterQuery");
        int r9 = CursorUtil.getColumnIndex(r0, "backup_imageFilterModelVersion");
        int r10 = CursorUtil.getColumnIndex(r0, "backup_clientModelQuery");
        int r11 = CursorUtil.getColumnIndex(r0, "backup_clientModelVersion");
        int r12 = CursorUtil.getColumnIndex(r0, "backup_useClientModel");
        int r13 = CursorUtil.getColumnIndex(r0, "backup_memoryCount");
        int r14 = CursorUtil.getColumnIndex(r0, "backup_source");
        int r15 = CursorUtil.getColumnIndex(r0, "backup_triggerMode");
        int r16 = CursorUtil.getColumnIndex(r0, "backup_cronExpression");
        int r17 = CursorUtil.getColumnIndex(r0, "backup_memoryInfoJson");
        int r18 = CursorUtil.getColumnIndex(r0, "backup_isPaused");
        int r19 = CursorUtil.getColumnIndex(r0, "backup_autoCaptureEnabled");
        int r110 = CursorUtil.getColumnIndex(r0, "backup_isFromPreset");
        int r111 = CursorUtil.getColumnIndex(r0, "backup_canDisplay");
        int r112 = CursorUtil.getColumnIndex(r0, "backup_ruleSettingsVersion");
        int r113 = CursorUtil.getColumnIndex(r0, "backup_activeStartMinute");
        int r114 = CursorUtil.getColumnIndex(r0, "backup_activeEndMinute");
        int r115 = CursorUtil.getColumnIndex(r0, "backup_iconKey");
        int r116 = CursorUtil.getColumnIndex(r0, "backup_iconColorKey");
        int r117 = CursorUtil.getColumnIndex(r0, "backup_iconGenerateVersion");
        int r118 = CursorUtil.getColumnIndex(r0, "backup_lastExposedAutoMemoryId");
        int r119 = CursorUtil.getColumnIndex(r0, "backup_personalDbSplitMigrated");
        long r28 = 0;
        if (r1 != (-1)) goto L5;
        long r34 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r37 = null;
    L13:
        boolean r21 = false;
        if (r3 != (-1)) goto L16;
        int r38 = 0;
    L17:
        if (r4 != (-1)) goto L19;
        long r40 = 0;
    L20:
        if (r5 != (-1)) goto L23;
    L21:
        String r42 = null;
    L26:
        if (r6 != (-1)) goto L29;
    L27:
        String r43 = null;
    L32:
        if (r7 != (-1)) goto L35;
    L33:
        String r44 = null;
    L38:
        if (r8 != (-1)) goto L41;
    L39:
        String r45 = null;
    L44:
        if (r9 != (-1)) goto L47;
    L45:
        String r46 = null;
    L50:
        if (r10 != (-1)) goto L53;
    L51:
        String r47 = null;
    L56:
        if (r11 != (-1)) goto L59;
    L57:
        String r48 = null;
    L63:
        if (r12 != (-1)) goto L66;
        boolean r49 = false;
    L70:
        if (r13 != (-1)) goto L72;
        long r50 = 0;
    L73:
        if (r14 != (-1)) goto L76;
    L74:
        String r52 = null;
    L79:
        if (r69 != (-1)) goto L82;
    L80:
        String r53 = null;
    L85:
        if (r70 != (-1)) goto L89;
    L86:
        String r54 = null;
    L92:
        if (r17 != (-1)) goto L96;
    L93:
        String r55 = null;
    L99:
        if (r18 != (-1)) goto L103;
        boolean r56 = false;
    L107:
        if (r19 != (-1)) goto L111;
        boolean r57 = false;
    L115:
        if (r110 != (-1)) goto L119;
        boolean r58 = false;
    L123:
        if (r111 != (-1)) goto L127;
        boolean r59 = false;
    L131:
        if (r112 != (-1)) goto L133;
        int r60 = 0;
    L135:
        if (r113 != (-1)) goto L137;
        int r61 = 0;
    L139:
        if (r114 != (-1)) goto L141;
        int r62 = 0;
    L143:
        if (r115 != (-1)) goto L147;
    L144:
        String r63 = null;
    L150:
        if (r116 != (-1)) goto L154;
    L151:
        String r64 = null;
    L157:
        if (r117 != (-1)) goto L160;
    L158:
        String r65 = r20;
        if (r118 == (-1)) goto L166;
        r28 = r0.getLong(r118);
    L166:
        long r66 = r28;
        if (r119 != (-1)) goto L170;
    L173:
        return new com.obric.memorydata.database.legacy.backup.a.n(r34, new MemoryRuleEntityOld(r40, r42, r43, r44, r45, r46, r47, r48, r49, r50, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r21), r37, r38);
    L170:
        if (r0.getInt(r119) == 0) goto L173;
        r21 = true;
        goto L173
    L160:
        if (r0.isNull(r117) == true) goto L158;
        r20 = r0.getString(r117);
        goto L158
    L154:
        if (r0.isNull(r116) == true) goto L151;
        r64 = r0.getString(r116);
        goto L157
    L147:
        if (r0.isNull(r115) == true) goto L144;
        r63 = r0.getString(r115);
        goto L150
    L141:
        r62 = r0.getInt(r114);
        goto L143
    L137:
        r61 = r0.getInt(r113);
        goto L139
    L133:
        r60 = r0.getInt(r112);
        goto L135
    L127:
        if (r0.getInt(r111) == 0) goto L129;
        boolean r22 = true;
    L130:
        r59 = r22;
        goto L131
    L129:
        r22 = false;
        goto L130
    L119:
        if (r0.getInt(r110) == 0) goto L121;
        boolean r23 = true;
    L122:
        r58 = r23;
        goto L123
    L121:
        r23 = false;
        goto L122
    L111:
        if (r0.getInt(r19) == 0) goto L113;
        boolean r24 = true;
    L114:
        r57 = r24;
        goto L115
    L113:
        r24 = false;
        goto L114
    L103:
        if (r0.getInt(r18) == 0) goto L105;
        boolean r25 = true;
    L106:
        r56 = r25;
        goto L107
    L105:
        r25 = false;
        goto L106
    L96:
        if (r0.isNull(r17) == true) goto L93;
        r55 = r0.getString(r17);
        goto L99
    L89:
        if (r0.isNull(r70) == true) goto L86;
        r54 = r0.getString(r16);
        goto L92
    L82:
        if (r0.isNull(r69) == true) goto L80;
        r53 = r0.getString(r15);
        goto L85
    L76:
        if (r0.isNull(r14) == true) goto L74;
        r52 = r0.getString(r14);
        goto L79
    L72:
        r50 = r0.getLong(r13);
        goto L73
    L66:
        if (r0.getInt(r12) == 0) goto L68;
        boolean r26 = true;
    L69:
        r49 = r26;
        goto L70
    L68:
        r26 = false;
        goto L69
    L59:
        if (r0.isNull(r11) == true) goto L57;
        r48 = r0.getString(r11);
        goto L63
    L53:
        if (r0.isNull(r10) == true) goto L51;
        r47 = r0.getString(r10);
        goto L56
    L47:
        if (r0.isNull(r9) == true) goto L45;
        r46 = r0.getString(r9);
        goto L50
    L41:
        if (r0.isNull(r8) == true) goto L39;
        r45 = r0.getString(r8);
        goto L44
    L35:
        if (r0.isNull(r7) == true) goto L33;
        r44 = r0.getString(r7);
        goto L38
    L29:
        if (r0.isNull(r6) == true) goto L27;
        r43 = r0.getString(r6);
        goto L32
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r42 = r0.getString(r5);
        goto L26
    L19:
        r40 = r0.getLong(r4);
        goto L20
    L16:
        r38 = r0.getInt(r3);
        goto L17
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r37 = r0.getString(r2);
        goto L13
    L5:
        r34 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.backup.a.n> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBackUpMemoryRuleEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.backup.a.n> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBackUpMemoryRuleEntityOld_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(com.obric.memorydata.database.legacy.backup.a.n r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBackUpMemoryRuleEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((com.obric.memorydata.database.legacy.backup.a.n) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.n.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return n.a.d(this);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public int deleteByBackupUserId(String r1) {
        return n.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return n.a.a(this);
    }

    public long insert(com.obric.memorydata.database.legacy.backup.a.n r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBackUpMemoryRuleEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((com.obric.memorydata.database.legacy.backup.a.n) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.n.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.backup.a.n> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBackUpMemoryRuleEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.n> queryAll() {
        return n.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return n.a.c(this);
    }

    public List<com.obric.memorydata.database.legacy.backup.a.n> queryByBackupUserId(String r1) {
        return n.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public List<com.obric.memorydata.database.legacy.backup.a.n> queryByBackupUserId(String r1, int r2, int r3) {
        return n.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.n queryById(long r1) {
        return n.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.n> queryByIds(List<Long> r3) {
        return n.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.n queryByUUID(String r1) {
        return n.a.c(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.n queryOne() {
        return n.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.n> queryWithLimitAndOffset(int r1, int r2) {
        return n.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.n> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpMemoryRuleEntityOld(r6));     // Catch: Throwable -> L10
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

    public int update(com.obric.memorydata.database.legacy.backup.a.n r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBackUpMemoryRuleEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((com.obric.memorydata.database.legacy.backup.a.n) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.n.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.backup.a.n> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBackUpMemoryRuleEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
