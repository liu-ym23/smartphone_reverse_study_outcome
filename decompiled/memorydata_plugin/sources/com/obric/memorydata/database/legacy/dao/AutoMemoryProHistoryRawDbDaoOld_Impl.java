package com.obric.memorydata.database.legacy.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.legacy.entity.AutoMemoryProEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoMemoryProHistoryRawDbDaoOld_Impl implements g {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.e> __deletionAdapterOfAutoMemoryProHistoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.entity.e> __insertionAdapterOfAutoMemoryProHistoryEntityOld;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.e> __updateAdapterOfAutoMemoryProHistoryEntityOld;

    public AutoMemoryProHistoryRawDbDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAutoMemoryProHistoryEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfAutoMemoryProHistoryEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfAutoMemoryProHistoryEntityOld = new AnonymousClass3(this, r2);
    }

    private com.obric.memorydata.database.legacy.entity.e __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityAutoMemoryProHistoryEntityOld(Cursor r61) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r61, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_id");
        int r3 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_type");
        int r7 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_packageName");
        int r8 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_hashCodeValue");
        int r9 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_uuid");
        int r10 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_rule_id");
        int r11 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_timestamp");
        int r12 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_title");
        int r13 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_content");
        int r14 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_subtitle");
        int r15 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_reason");
        int r16 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_log_id");
        int r17 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_trace_id");
        int r18 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_package_names");
        int r19 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_episodic_ids");
        int r110 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_semantic_ids");
        int r111 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_raw_observation_ids");
        int r112 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_fullContent");
        int r113 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_personalDbSplitMigrated");
        int r114 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_poison_label");
        int r115 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_poison_label_version");
        int r116 = CursorUtil.getColumnIndex(r0, "auto_memory_pro_content_hash");
        long r25 = 0;
        if (r1 != (-1)) goto L5;
        long r30 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r33 = 0;
    L9:
        String r20 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r35 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r36 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r38 = 0;
    L22:
        boolean r21 = false;
        if (r6 != (-1)) goto L25;
        int r40 = 0;
    L26:
        if (r7 != (-1)) goto L29;
    L27:
        String r41 = null;
    L32:
        if (r8 != (-1)) goto L34;
        int r42 = 0;
    L35:
        if (r9 != (-1)) goto L38;
    L36:
        String r43 = null;
    L41:
        if (r10 != (-1)) goto L43;
        long r44 = 0;
    L44:
        if (r11 == (-1)) goto L47;
        r25 = r0.getLong(r11);
    L47:
        long r46 = r25;
        if (r12 != (-1)) goto L51;
    L49:
        String r48 = null;
    L54:
        if (r13 != (-1)) goto L57;
    L55:
        String r49 = null;
    L60:
        if (r14 != (-1)) goto L63;
    L61:
        String r50 = null;
    L66:
        if (r60 != (-1)) goto L69;
    L67:
        String r51 = null;
    L72:
        if (r61 != (-1)) goto L76;
    L73:
        String r52 = null;
    L79:
        if (r17 != (-1)) goto L81;
        int r53 = 0;
    L83:
        if (r18 != (-1)) goto L87;
    L84:
        String r54 = null;
    L90:
        if (r19 != (-1)) goto L94;
    L91:
        String r55 = null;
    L97:
        if (r110 != (-1)) goto L101;
    L98:
        String r56 = null;
    L104:
        if (r111 != (-1)) goto L108;
    L105:
        String r57 = null;
    L111:
        if (r112 != (-1)) goto L115;
    L112:
        String r58 = null;
    L118:
        if (r113 != (-1)) goto L121;
    L123:
        AutoMemoryProEntityOld r22 = new AutoMemoryProEntityOld(r33, r35, r36, r38, r40, r41, r42, r43, r44, r46, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r21);
        if (r114 == (-1)) goto L131;
        if (r0.isNull(r114) == false) goto L128;
        Integer r23 = null;
    L129:
        r22.setPoisonLabel(r23);
        goto L131
    L128:
        r23 = Integer.valueOf(r0.getInt(r114));
    L131:
        if (r115 == (-1)) goto L138;
        if (r0.isNull(r115) == false) goto L135;
        Integer r24 = null;
    L136:
        r22.setPoisonLabelVersion(r24);
        goto L138
    L135:
        r24 = Integer.valueOf(r0.getInt(r115));
    L138:
        if (r116 == (-1)) goto L145;
        if (r0.isNull(r116) == true) goto L143;
        r20 = r0.getString(r116);
    L143:
        r22.setContentHash(r20);
    L145:
        return new com.obric.memorydata.database.legacy.entity.e(r30, r22);
    L121:
        if (r0.getInt(r113) == 0) goto L123;
        r21 = true;
        goto L123
    L115:
        if (r0.isNull(r112) == true) goto L112;
        r58 = r0.getString(r112);
        goto L118
    L108:
        if (r0.isNull(r111) == true) goto L105;
        r57 = r0.getString(r111);
        goto L111
    L101:
        if (r0.isNull(r110) == true) goto L98;
        r56 = r0.getString(r110);
        goto L104
    L94:
        if (r0.isNull(r19) == true) goto L91;
        r55 = r0.getString(r19);
        goto L97
    L87:
        if (r0.isNull(r18) == true) goto L84;
        r54 = r0.getString(r18);
        goto L90
    L81:
        r53 = r0.getInt(r17);
        goto L83
    L76:
        if (r0.isNull(r61) == true) goto L73;
        r52 = r0.getString(r16);
        goto L79
    L69:
        if (r0.isNull(r60) == true) goto L67;
        r51 = r0.getString(r15);
        goto L72
    L63:
        if (r0.isNull(r14) == true) goto L61;
        r50 = r0.getString(r14);
        goto L66
    L57:
        if (r0.isNull(r13) == true) goto L55;
        r49 = r0.getString(r13);
        goto L60
    L51:
        if (r0.isNull(r12) == true) goto L49;
        r48 = r0.getString(r12);
        goto L54
    L43:
        r44 = r0.getLong(r10);
        goto L44
    L38:
        if (r0.isNull(r9) == true) goto L36;
        r43 = r0.getString(r9);
        goto L41
    L34:
        r42 = r0.getInt(r8);
        goto L35
    L29:
        if (r0.isNull(r7) == true) goto L27;
        r41 = r0.getString(r7);
        goto L32
    L25:
        r40 = r0.getInt(r6);
        goto L26
    L21:
        r38 = r0.getLong(r5);
        goto L22
    L18:
        r36 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r35 = r0.getString(r3);
        goto L16
    L8:
        r33 = r0.getLong(r2);
        goto L9
    L5:
        r30 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.entity.e> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAutoMemoryProHistoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.entity.e> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAutoMemoryProHistoryEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.memorydata.database.legacy.entity.e r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAutoMemoryProHistoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.memorydata.database.legacy.entity.e r3) {
        return delete2((com.obric.memorydata.database.legacy.entity.e) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.e.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return g.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return g.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.memorydata.database.legacy.entity.e r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAutoMemoryProHistoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.memorydata.database.legacy.entity.e r3) {
        return insert2((com.obric.memorydata.database.legacy.entity.e) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.e.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.entity.e> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAutoMemoryProHistoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.e> queryAll() {
        return g.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return g.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.e queryById(long r1) {
        return g.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.e queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.e> queryByIds(List<Long> r3) {
        return g.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.e queryByUUID(String r1) {
        return g.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.e queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.e queryOne() {
        return g.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.e queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.e> queryWithLimitAndOffset(int r1, int r2) {
        return g.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.e> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityAutoMemoryProHistoryEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.memorydata.database.legacy.entity.e r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAutoMemoryProHistoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.memorydata.database.legacy.entity.e r3) {
        return update2((com.obric.memorydata.database.legacy.entity.e) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.e.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.entity.e> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAutoMemoryProHistoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
