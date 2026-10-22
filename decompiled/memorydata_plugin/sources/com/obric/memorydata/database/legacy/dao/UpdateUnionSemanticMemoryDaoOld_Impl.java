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
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UpdateUnionSemanticMemoryDaoOld_Impl implements ba {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.aj> __deletionAdapterOfUpdateUnionSemanticMemoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.entity.aj> __insertionAdapterOfUpdateUnionSemanticMemoryEntityOld;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.aj> __updateAdapterOfUpdateUnionSemanticMemoryEntityOld;

    public UpdateUnionSemanticMemoryDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfUpdateUnionSemanticMemoryEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfUpdateUnionSemanticMemoryEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfUpdateUnionSemanticMemoryEntityOld = new AnonymousClass3(this, r2);
    }

    private com.obric.memorydata.database.legacy.entity.aj __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityUpdateUnionSemanticMemoryEntityOld(Cursor r61) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r61, Cursor.class, "com.obric.memorydata.plugin");
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
        int r110 = CursorUtil.getColumnIndex(r0, "confidence");
        int r111 = CursorUtil.getColumnIndex(r0, "updateResult");
        int r112 = CursorUtil.getColumnIndex(r0, "isUpdated");
        int r113 = CursorUtil.getColumnIndex(r0, "retryTime");
        int r114 = CursorUtil.getColumnIndex(r0, "lastExecuteUpdateTimestamp");
        int r115 = CursorUtil.getColumnIndex(r0, "personalDbSplitMigrated");
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
        if (r6 != (-1)) goto L25;
        long r38 = 0;
    L26:
        if (r7 != (-1)) goto L29;
    L27:
        String r40 = null;
    L32:
        if (r8 != (-1)) goto L34;
        int r41 = 0;
    L35:
        if (r9 != (-1)) goto L38;
    L36:
        String r42 = null;
    L41:
        if (r10 != (-1)) goto L44;
    L42:
        String r43 = null;
    L47:
        if (r11 != (-1)) goto L50;
    L48:
        String r44 = null;
    L53:
        if (r12 != (-1)) goto L56;
    L54:
        String r45 = null;
    L59:
        if (r13 != (-1)) goto L62;
    L60:
        String r46 = null;
    L65:
        if (r14 != (-1)) goto L68;
    L66:
        String r47 = null;
    L71:
        if (r60 != (-1)) goto L74;
    L72:
        String r48 = null;
    L78:
        if (r16 != (-1)) goto L82;
        boolean r49 = false;
    L86:
        if (r17 != (-1)) goto L88;
        int r50 = 0;
    L90:
        if (r18 != (-1)) goto L92;
        int r51 = 0;
    L94:
        if (r19 != (-1)) goto L98;
        boolean r52 = false;
    L102:
        if (r110 != (-1)) goto L104;
        float r22 = 0.0f;
    L105:
        float r53 = r22;
        if (r111 != (-1)) goto L109;
    L107:
        String r54 = r20;
        if (r112 != (-1)) goto L116;
        boolean r55 = false;
    L120:
        if (r113 != (-1)) goto L122;
        int r56 = 0;
    L124:
        if (r114 == (-1)) goto L127;
        r24 = r0.getLong(r114);
    L127:
        long r57 = r24;
        if (r115 != (-1)) goto L131;
    L134:
        return new com.obric.memorydata.database.legacy.entity.aj(r30, r32, r33, r35, r37, r38, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r21);
    L131:
        if (r0.getInt(r115) == 0) goto L134;
        r21 = true;
        goto L134
    L122:
        r56 = r0.getInt(r113);
        goto L124
    L116:
        if (r0.getInt(r112) == 0) goto L118;
        boolean r23 = true;
    L119:
        r55 = r23;
        goto L120
    L118:
        r23 = false;
        goto L119
    L109:
        if (r0.isNull(r111) == true) goto L107;
        r20 = r0.getString(r111);
        goto L107
    L104:
        r22 = r0.getFloat(r110);
        goto L105
    L98:
        if (r0.getInt(r19) == 0) goto L100;
        boolean r25 = true;
    L101:
        r52 = r25;
        goto L102
    L100:
        r25 = false;
        goto L101
    L92:
        r51 = r0.getInt(r18);
        goto L94
    L88:
        r50 = r0.getInt(r17);
        goto L90
    L82:
        if (r0.getInt(r16) == 0) goto L84;
        boolean r26 = true;
    L85:
        r49 = r26;
        goto L86
    L84:
        r26 = false;
        goto L85
    L74:
        if (r0.isNull(r60) == true) goto L72;
        r48 = r0.getString(r15);
        goto L78
    L68:
        if (r0.isNull(r14) == true) goto L66;
        r47 = r0.getString(r14);
        goto L71
    L62:
        if (r0.isNull(r13) == true) goto L60;
        r46 = r0.getString(r13);
        goto L65
    L56:
        if (r0.isNull(r12) == true) goto L54;
        r45 = r0.getString(r12);
        goto L59
    L50:
        if (r0.isNull(r11) == true) goto L48;
        r44 = r0.getString(r11);
        goto L53
    L44:
        if (r0.isNull(r10) == true) goto L42;
        r43 = r0.getString(r10);
        goto L47
    L38:
        if (r0.isNull(r9) == true) goto L36;
        r42 = r0.getString(r9);
        goto L41
    L34:
        r41 = r0.getInt(r8);
        goto L35
    L29:
        if (r0.isNull(r7) == true) goto L27;
        r40 = r0.getString(r7);
        goto L32
    L25:
        r38 = r0.getLong(r6);
        goto L26
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
    public void bulkDelete(List<com.obric.memorydata.database.legacy.entity.aj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfUpdateUnionSemanticMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.entity.aj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUpdateUnionSemanticMemoryEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.memorydata.database.legacy.entity.aj r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfUpdateUnionSemanticMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.memorydata.database.legacy.entity.aj r3) {
        return delete2((com.obric.memorydata.database.legacy.entity.aj) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.aj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return ba.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return ba.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.memorydata.database.legacy.entity.aj r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUpdateUnionSemanticMemoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.memorydata.database.legacy.entity.aj r3) {
        return insert2((com.obric.memorydata.database.legacy.entity.aj) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.aj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.entity.aj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfUpdateUnionSemanticMemoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.aj> queryAll() {
        return ba.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return ba.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.aj queryById(long r1) {
        return ba.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.aj queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.aj> queryByIds(List<Long> r3) {
        return ba.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.aj queryByUUID(String r1) {
        return ba.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.aj queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.aj queryOne() {
        return ba.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.aj queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.aj> queryWithLimitAndOffset(int r1, int r2) {
        return ba.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.aj> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityUpdateUnionSemanticMemoryEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.memorydata.database.legacy.entity.aj r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfUpdateUnionSemanticMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.memorydata.database.legacy.entity.aj r3) {
        return update2((com.obric.memorydata.database.legacy.entity.aj) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.aj.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.entity.aj> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfUpdateUnionSemanticMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
