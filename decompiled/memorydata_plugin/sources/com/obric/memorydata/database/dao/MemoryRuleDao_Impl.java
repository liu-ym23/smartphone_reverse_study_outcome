package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.MemoryRuleEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryRuleDao_Impl implements MemoryRuleDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<MemoryRuleEntity> __deletionAdapterOfMemoryRuleEntity;
    private final EntityInsertionAdapter<MemoryRuleEntity> __insertionAdapterOfMemoryRuleEntity;
    private final SharedSQLiteStatement __preparedStmtOfClearTable;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;
    private final SharedSQLiteStatement __preparedStmtOfResetSequence;
    private final SharedSQLiteStatement __preparedStmtOfUpdateLastExposedAutoMemoryId;
    private final SharedSQLiteStatement __preparedStmtOfUpdatePausedState;
    private final SharedSQLiteStatement __preparedStmtOfUpdateUseClientModel;
    private final EntityDeletionOrUpdateAdapter<MemoryRuleEntity> __updateAdapterOfMemoryRuleEntity;

    public MemoryRuleDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryRuleEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfMemoryRuleEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfMemoryRuleEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteById = new AnonymousClass4(this, r2);
        this.__preparedStmtOfUpdateLastExposedAutoMemoryId = new AnonymousClass5(this, r2);
        this.__preparedStmtOfUpdatePausedState = new AnonymousClass6(this, r2);
        this.__preparedStmtOfUpdateUseClientModel = new AnonymousClass7(this, r2);
        this.__preparedStmtOfClearTable = new AnonymousClass8(this, r2);
        this.__preparedStmtOfResetSequence = new AnonymousClass9(this, r2);
    }

    private MemoryRuleEntity __entityCursorConverter_comObricMemorydataDatabaseEntityMemoryRuleEntity(Cursor r59) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r59, Cursor.class, "com.obric.memorydata.plugin");
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
        long r24 = 0;
        if (r1 != (-1)) goto L5;
        long r30 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r32 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r33 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r34 = null;
    L25:
        if (r5 != (-1)) goto L28;
    L26:
        String r35 = null;
    L31:
        if (r6 != (-1)) goto L34;
    L32:
        String r36 = null;
    L37:
        if (r7 != (-1)) goto L40;
    L38:
        String r37 = null;
    L43:
        if (r8 != (-1)) goto L46;
    L44:
        String r38 = null;
    L49:
        boolean r21 = true;
        if (r9 != (-1)) goto L53;
        boolean r39 = false;
    L57:
        if (r10 != (-1)) goto L59;
        long r40 = 0;
    L60:
        if (r11 != (-1)) goto L63;
    L61:
        String r42 = null;
    L66:
        if (r12 != (-1)) goto L69;
    L67:
        String r43 = null;
    L72:
        if (r13 != (-1)) goto L75;
    L73:
        String r44 = null;
    L78:
        if (r14 != (-1)) goto L81;
    L79:
        String r45 = null;
    L84:
        if (r58 != (-1)) goto L87;
        boolean r46 = false;
    L91:
        if (r59 != (-1)) goto L95;
        boolean r47 = false;
    L99:
        if (r17 != (-1)) goto L103;
        boolean r48 = false;
    L107:
        if (r18 != (-1)) goto L111;
        boolean r49 = false;
    L115:
        if (r19 != (-1)) goto L117;
        int r50 = 0;
    L119:
        if (r110 != (-1)) goto L121;
        int r51 = 0;
    L123:
        if (r111 != (-1)) goto L125;
        int r52 = 0;
    L127:
        if (r112 != (-1)) goto L131;
    L128:
        String r53 = null;
    L134:
        if (r113 != (-1)) goto L138;
    L135:
        String r54 = null;
    L141:
        if (r114 != (-1)) goto L144;
    L142:
        String r55 = r20;
        if (r115 == (-1)) goto L151;
        r24 = r0.getLong(r115);
    L151:
        return new MemoryRuleEntity(r30, r32, r33, r34, r35, r36, r37, r38, r39, r40, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r24);
    L144:
        if (r0.isNull(r114) == true) goto L142;
        r20 = r0.getString(r114);
        goto L142
    L138:
        if (r0.isNull(r113) == true) goto L135;
        r54 = r0.getString(r113);
        goto L141
    L131:
        if (r0.isNull(r112) == true) goto L128;
        r53 = r0.getString(r112);
        goto L134
    L125:
        r52 = r0.getInt(r111);
        goto L127
    L121:
        r51 = r0.getInt(r110);
        goto L123
    L117:
        r50 = r0.getInt(r19);
        goto L119
    L111:
        if (r0.getInt(r18) != 0) goto L114;
        r21 = false;
    L114:
        r49 = r21;
        goto L115
    L103:
        if (r0.getInt(r17) == 0) goto L105;
        boolean r22 = true;
    L106:
        r48 = r22;
        goto L107
    L105:
        r22 = false;
        goto L106
    L95:
        if (r0.getInt(r16) == 0) goto L97;
        boolean r23 = true;
    L98:
        r47 = r23;
        goto L99
    L97:
        r23 = false;
        goto L98
    L87:
        if (r0.getInt(r15) == 0) goto L89;
        boolean r25 = true;
    L90:
        r46 = r25;
        goto L91
    L89:
        r25 = false;
        goto L90
    L81:
        if (r0.isNull(r14) == true) goto L79;
        r45 = r0.getString(r14);
        goto L84
    L75:
        if (r0.isNull(r13) == true) goto L73;
        r44 = r0.getString(r13);
        goto L78
    L69:
        if (r0.isNull(r12) == true) goto L67;
        r43 = r0.getString(r12);
        goto L72
    L63:
        if (r0.isNull(r11) == true) goto L61;
        r42 = r0.getString(r11);
        goto L66
    L59:
        r40 = r0.getLong(r10);
        goto L60
    L53:
        if (r0.getInt(r9) == 0) goto L55;
        boolean r26 = true;
    L56:
        r39 = r26;
        goto L57
    L55:
        r26 = false;
        goto L56
    L46:
        if (r0.isNull(r8) == true) goto L44;
        r38 = r0.getString(r8);
        goto L49
    L40:
        if (r0.isNull(r7) == true) goto L38;
        r37 = r0.getString(r7);
        goto L43
    L34:
        if (r0.isNull(r6) == true) goto L32;
        r36 = r0.getString(r6);
        goto L37
    L28:
        if (r0.isNull(r5) == true) goto L26;
        r35 = r0.getString(r5);
        goto L31
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r34 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r33 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r32 = r0.getString(r2);
        goto L13
    L5:
        r30 = r0.getLong(r1);
        goto L6
    }

    static /* synthetic */ RoomDatabase access$000(MemoryRuleDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<MemoryRuleEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMemoryRuleEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<MemoryRuleEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMemoryRuleEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public void clearTable() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfClearTable.acquire();
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfClearTable.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfClearTable.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public void clearTableAndResetId() {
        this.__db.beginTransaction();
        MemoryRuleDao.DefaultImpls.clearTableAndResetId(this);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public int countClientModelRules(long r3) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM MemoryRule WHERE useClientModel = 1 AND id != ?", 1);
        r0.bindLong(1, r3);
        this.__db.assertNotSuspendingTransaction();
        int r4 = 0;
        Cursor r2 = DBUtil.query(this.__db, r0, false, null);
    L8:
        th = move-exception;
        r2.close();
        r0.release();
        throw th;
    L4:
        if (r2.moveToFirst() == false) goto L6;
        r4 = r2.getInt(0);     // Catch: Throwable -> L8
    L6:
        r2.close();
        r0.release();
        return r4;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(MemoryRuleEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMemoryRuleEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(MemoryRuleEntity r3) {
        return delete2((MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r3, MemoryRuleEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return MemoryRuleDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
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

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MemoryRuleDao.DefaultImpls.getTableName(this);
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public boolean hasPendingRuleGenerator() {
        boolean r1 = false;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT EXISTS(\n            SELECT 1 FROM MemoryRule\n            WHERE triggerMode = ''\n                OR (triggerMode = 'SCHEDULED' AND cronExpression = '')\n                OR IFNULL(TRIM(iconGenerateVersion), '') != '1.0.0'\n                OR ruleSettingsVersion != 1\n            LIMIT 1\n        )\n        ", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L10:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L8;
        if (r3.getInt(0) == 0) goto L8;
        r1 = true;
    L8:
        r3.close();
        r0.release();
        return r1;
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public boolean hasPendingRuleSettingsUpgrade() {
        boolean r1 = false;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT EXISTS(\n            SELECT 1 FROM MemoryRule\n            WHERE memoryInfoJson is null or memoryInfoJson = ''\n            LIMIT 1\n        )\n        ", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L10:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L8;
        if (r3.getInt(0) == 0) goto L8;
        r1 = true;
    L8:
        r3.close();
        r0.release();
        return r1;
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(MemoryRuleEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryRuleEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(MemoryRuleEntity r3) {
        return insert2((MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r3, MemoryRuleEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<MemoryRuleEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryRuleEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public long insertMyCollection(String r1, String r2, String r3, String r4, boolean r5, String r6, String r7, String r8, boolean r9, boolean r10, int r11) {
        return MemoryRuleDao.DefaultImpls.insertMyCollection(this, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public boolean isUpdating() {
        boolean r1 = false;
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT 1 FROM MemoryRule WHERE IFNULL(TRIM(iconGenerateVersion), '') != '1.0.0' OR ruleSettingsVersion != 1 LIMIT 1)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L10:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L4:
        if (r3.moveToFirst() == false) goto L8;
        if (r3.getInt(0) == 0) goto L8;
        r1 = true;
    L8:
        r3.close();
        r0.release();
        return r1;
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public i<List<MemoryRuleEntity>> observeAllRules() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryRule", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"MemoryRule"}, new AnonymousClass10(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryRuleEntity> queryAll() {
        return MemoryRuleDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MemoryRuleDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public List<Long> queryAllIds() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id FROM MemoryRule", 0);
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

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryRuleEntity queryById(long r1) {
        return MemoryRuleDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryRuleEntity queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryRuleEntity> queryByIds(List<Long> r3) {
        return MemoryRuleDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryRuleEntity queryByUUID(String r1) {
        return MemoryRuleDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryRuleEntity queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public List<MemoryRuleEntity> queryMyCollections(String r60) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryRule WHERE source != ? AND canDisplay = 1 ORDER BY id DESC", 1);
        if (r60 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r5 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r5, OaidModel.KEY_ID);     // Catch: Throwable -> L95
        int r6 = CursorUtil.getColumnIndexOrThrow(r5, "title");     // Catch: Throwable -> L95
        int r7 = CursorUtil.getColumnIndexOrThrow(r5, Params.CONTENT);     // Catch: Throwable -> L95
        int r8 = CursorUtil.getColumnIndexOrThrow(r5, "appPackages");     // Catch: Throwable -> L95
        int r9 = CursorUtil.getColumnIndexOrThrow(r5, "imageFilterQuery");     // Catch: Throwable -> L95
        int r10 = CursorUtil.getColumnIndexOrThrow(r5, "imageFilterModelVersion");     // Catch: Throwable -> L95
        int r11 = CursorUtil.getColumnIndexOrThrow(r5, "clientModelQuery");     // Catch: Throwable -> L95
        int r12 = CursorUtil.getColumnIndexOrThrow(r5, "clientModelVersion");     // Catch: Throwable -> L95
        int r13 = CursorUtil.getColumnIndexOrThrow(r5, "useClientModel");     // Catch: Throwable -> L95
        int r14 = CursorUtil.getColumnIndexOrThrow(r5, "memoryCount");     // Catch: Throwable -> L95
        int r15 = CursorUtil.getColumnIndexOrThrow(r5, AILabCheckPermissionTask.KEY_SOURCE);     // Catch: Throwable -> L95
        int r1 = CursorUtil.getColumnIndexOrThrow(r5, "triggerMode");     // Catch: Throwable -> L95
        int r3 = CursorUtil.getColumnIndexOrThrow(r5, "cronExpression");     // Catch: Throwable -> L95
        int r4 = CursorUtil.getColumnIndexOrThrow(r5, "memoryInfoJson");     // Catch: Throwable -> L95
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r5, "isPaused");     // Catch: Throwable -> L93
        int r18 = CursorUtil.getColumnIndexOrThrow(r5, "autoCaptureEnabled");     // Catch: Throwable -> L93
        int r19 = CursorUtil.getColumnIndexOrThrow(r5, "isFromPreset");     // Catch: Throwable -> L93
        int r20 = CursorUtil.getColumnIndexOrThrow(r5, "canDisplay");     // Catch: Throwable -> L93
        int r21 = CursorUtil.getColumnIndexOrThrow(r5, "ruleSettingsVersion");     // Catch: Throwable -> L93
        int r22 = CursorUtil.getColumnIndexOrThrow(r5, "activeStartMinute");     // Catch: Throwable -> L93
        int r23 = CursorUtil.getColumnIndexOrThrow(r5, "activeEndMinute");     // Catch: Throwable -> L93
        int r24 = CursorUtil.getColumnIndexOrThrow(r5, "iconKey");     // Catch: Throwable -> L93
        int r25 = CursorUtil.getColumnIndexOrThrow(r5, "iconColorKey");     // Catch: Throwable -> L93
        int r26 = CursorUtil.getColumnIndexOrThrow(r5, "iconGenerateVersion");     // Catch: Throwable -> L93
        int r27 = CursorUtil.getColumnIndexOrThrow(r5, "lastExposedAutoMemoryId");     // Catch: Throwable -> L93
        int r28 = r4;
        ArrayList r29 = new ArrayList(r5.getCount());     // Catch: Throwable -> L93
    L10:
        if (r5.moveToNext() == false) goto L91;
        long r30 = r5.getLong(r0);     // Catch: Throwable -> L93
        if (r5.isNull(r6) == false) goto L15;
        String r32 = null;
    L17:
        if (r5.isNull(r7) == false) goto L19;
        String r33 = null;
    L21:
        if (r5.isNull(r8) == false) goto L23;
        String r34 = null;
    L25:
        if (r5.isNull(r9) == false) goto L27;
        String r35 = null;
    L29:
        if (r5.isNull(r10) == false) goto L31;
        String r36 = null;
    L33:
        if (r5.isNull(r11) == false) goto L35;
        String r37 = null;
    L37:
        if (r5.isNull(r12) == false) goto L39;
        String r38 = null;
    L41:
        if (r5.getInt(r13) == 0) goto L43;
        boolean r39 = true;
    L44:
        long r40 = r5.getLong(r14);     // Catch: Throwable -> L93
        if (r5.isNull(r15) == false) goto L47;
        String r42 = null;
    L49:
        if (r5.isNull(r1) == false) goto L51;
        String r43 = null;
    L53:
        if (r5.isNull(r3) == false) goto L55;
        String r44 = null;
    L57:
        if (r5.isNull(r28) == false) goto L60;
        String r45 = null;
    L59:
        int r58 = r17;
        int r110 = r0;
        if (r5.getInt(r58) == 0) goto L64;
        boolean r46 = true;
    L65:
        int r59 = r18;
        if (r5.getInt(r59) == 0) goto L68;
        boolean r47 = true;
    L69:
        int r510 = r19;
        if (r5.getInt(r510) == 0) goto L72;
        boolean r48 = true;
    L73:
        int r511 = r20;
        if (r5.getInt(r511) == 0) goto L76;
        boolean r49 = true;
    L77:
        int r512 = r21;
        int r50 = r5.getInt(r512);     // Catch: Throwable -> L93
        int r31 = r22;
        int r51 = r5.getInt(r31);     // Catch: Throwable -> L93
        r22 = r31;
        int r41 = r23;
        int r52 = r5.getInt(r41);     // Catch: Throwable -> L93
        r23 = r41;
        r24 = r24;
        if (r5.isNull(r24) == false) goto L80;
        String r53 = null;
    L82:
        if (r5.isNull(r25) == false) goto L84;
        String r54 = null;
    L86:
        if (r5.isNull(r26) == false) goto L88;
        String r55 = null;
    L89:
        long r56 = r5.getLong(r27);     // Catch: Throwable -> L93
        r27 = r27;
        r29.add(new MemoryRuleEntity(r30, r32, r33, r34, r35, r36, r37, r38, r39, r40, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56));     // Catch: Throwable -> L93
        r0 = r110;
        r17 = r58;
        r18 = r59;
        r19 = r510;
        r20 = r511;
        r21 = r512;
        r28 = r28;
        goto L10
    L88:
        r55 = r5.getString(r26);     // Catch: Throwable -> L93
        goto L89
    L84:
        r54 = r5.getString(r25);     // Catch: Throwable -> L93
        goto L86
    L80:
        r53 = r5.getString(r24);     // Catch: Throwable -> L93
        goto L82
    L76:
        r49 = false;
        goto L77
    L72:
        r48 = false;
        goto L73
    L68:
        r47 = false;
        goto L69
    L64:
        r46 = false;
        goto L65
    L60:
        r45 = r5.getString(r28);     // Catch: Throwable -> L93
        goto L59
    L55:
        r44 = r5.getString(r3);     // Catch: Throwable -> L93
        goto L57
    L51:
        r43 = r5.getString(r1);     // Catch: Throwable -> L93
        goto L53
    L47:
        r42 = r5.getString(r15);     // Catch: Throwable -> L93
        goto L49
    L43:
        r39 = false;
        goto L44
    L39:
        r38 = r5.getString(r12);     // Catch: Throwable -> L93
        goto L41
    L35:
        r37 = r5.getString(r11);     // Catch: Throwable -> L93
        goto L37
    L31:
        r36 = r5.getString(r10);     // Catch: Throwable -> L93
        goto L33
    L27:
        r35 = r5.getString(r9);     // Catch: Throwable -> L93
        goto L29
    L23:
        r34 = r5.getString(r8);     // Catch: Throwable -> L93
        goto L25
    L19:
        r33 = r5.getString(r7);     // Catch: Throwable -> L93
        goto L21
    L15:
        r32 = r5.getString(r6);     // Catch: Throwable -> L93
        goto L17
    L91:
        r5.close();
        r16.release();
        return r29;
    L93:
        th = th;
    L97:
        r5.close();
        r16.release();
        throw th;
    L95:
        th = th;
        r16 = r2;
        goto L97
    L5:
        r2.bindString(1, r60);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryRuleEntity queryOne() {
        return MemoryRuleDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryRuleEntity queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryRuleEntity> queryWithLimitAndOffset(int r1, int r2) {
        return MemoryRuleDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryRuleEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityMemoryRuleEntity(r6));     // Catch: Throwable -> L10
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

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
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

    /* JADX INFO: renamed from: update, reason: avoid collision after fix types in other method */
    public int update2(MemoryRuleEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMemoryRuleEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(MemoryRuleEntity r3) {
        return update2((MemoryRuleEntity) ZeusTransformUtils.preCheckCast(r3, MemoryRuleEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<MemoryRuleEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMemoryRuleEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public int updateLastExposedAutoMemoryId(long r3, long r5) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateLastExposedAutoMemoryId.acquire();
        r0.bindLong(1, r5);
        r0.bindLong(2, r3);
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateLastExposedAutoMemoryId.release(r0);
        return r4;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateLastExposedAutoMemoryId.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public void updateMemoryRuleCountById(long r1) {
        MemoryRuleDao.DefaultImpls.updateMemoryRuleCountById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public int updateMyCollection(long r1, String r3, String r4, String r5, boolean r6) {
        return MemoryRuleDao.DefaultImpls.updateMyCollection(this, r1, r3, r4, r5, r6);
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public int updatePausedState(long r4, boolean r6) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdatePausedState.acquire();
        r0.bindLong(1, r6 ? 1 : 0);
        r0.bindLong(2, r4);
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfUpdatePausedState.release(r0);
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdatePausedState.release(r0);
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryRuleDao
    public void updateUseClientModel(boolean r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateUseClientModel.acquire();
        r0.bindLong(1, r4 ? 1 : 0);
        this.__db.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateUseClientModel.release(r0);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateUseClientModel.release(r0);
        throw th;
    }
}
