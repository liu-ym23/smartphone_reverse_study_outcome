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
public final class EpisodicTopicMemoryDaoOld_Impl implements t {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.k> __deletionAdapterOfEpisodicTopicMemoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.entity.k> __insertionAdapterOfEpisodicTopicMemoryEntityOld;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.k> __updateAdapterOfEpisodicTopicMemoryEntityOld;

    public EpisodicTopicMemoryDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfEpisodicTopicMemoryEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfEpisodicTopicMemoryEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfEpisodicTopicMemoryEntityOld = new AnonymousClass3(this, r2);
    }

    private com.obric.memorydata.database.legacy.entity.k __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityEpisodicTopicMemoryEntityOld(Cursor r39) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r39, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "summary");
        int r3 = CursorUtil.getColumnIndex(r0, "relateIds");
        int r4 = CursorUtil.getColumnIndex(r0, "logId");
        int r5 = CursorUtil.getColumnIndex(r0, "entityId");
        int r6 = CursorUtil.getColumnIndex(r0, "createTime");
        int r7 = CursorUtil.getColumnIndex(r0, "modifyTime");
        int r8 = CursorUtil.getColumnIndex(r0, "type");
        int r9 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r10 = CursorUtil.getColumnIndex(r0, ObricMemoryConstants.KEY_PACKAGE_NAME);
        int r11 = CursorUtil.getColumnIndex(r0, "hashCodeValue");
        int r12 = CursorUtil.getColumnIndex(r0, Api.KEY_UUID);
        int r13 = CursorUtil.getColumnIndex(r0, "personalDbSplitMigrated");
        int r14 = CursorUtil.getColumnIndex(r0, "poison_label");
        int r15 = CursorUtil.getColumnIndex(r0, "poison_label_version");
        int r16 = CursorUtil.getColumnIndex(r0, "content_hash");
        long r17 = 0;
        if (r1 != (-1)) goto L5;
        long r21 = 0;
    L6:
        String r18 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r23 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r24 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r25 = null;
    L25:
        if (r5 != (-1)) goto L28;
    L26:
        String r26 = null;
    L31:
        if (r6 != (-1)) goto L33;
        long r27 = 0;
    L34:
        if (r7 != (-1)) goto L36;
        long r29 = 0;
    L37:
        boolean r19 = false;
        if (r8 != (-1)) goto L40;
        int r31 = 0;
    L41:
        if (r9 == (-1)) goto L44;
        r17 = r0.getLong(r9);
    L44:
        long r32 = r17;
        if (r10 != (-1)) goto L48;
    L46:
        String r34 = null;
    L51:
        if (r11 != (-1)) goto L53;
        int r35 = 0;
    L54:
        if (r12 != (-1)) goto L57;
    L55:
        String r36 = null;
    L60:
        if (r13 != (-1)) goto L63;
    L65:
        com.obric.memorydata.database.legacy.entity.k r20 = new com.obric.memorydata.database.legacy.entity.k(r21, r23, r24, r25, r26, r27, r29, r31, r32, r34, r35, r36, r19);
        if (r14 == (-1)) goto L73;
        if (r0.isNull(r14) == false) goto L70;
        Integer r22 = null;
    L71:
        r20.setPoisonLabel(r22);
        goto L73
    L70:
        r22 = Integer.valueOf(r0.getInt(r14));
    L73:
        if (r15 == (-1)) goto L80;
        if (r0.isNull(r15) == false) goto L77;
        Integer r28 = null;
    L78:
        r20.setPoisonLabelVersion(r28);
        goto L80
    L77:
        r28 = Integer.valueOf(r0.getInt(r15));
    L80:
        if (r16 != (-1)) goto L82;
    L86:
        return r20;
    L82:
        if (r0.isNull(r16) == true) goto L85;
        r18 = r0.getString(r16);
    L85:
        r20.setContentHash(r18);
        goto L86
    L63:
        if (r0.getInt(r13) == 0) goto L65;
        r19 = true;
        goto L65
    L57:
        if (r0.isNull(r12) == true) goto L55;
        r36 = r0.getString(r12);
        goto L60
    L53:
        r35 = r0.getInt(r11);
        goto L54
    L48:
        if (r0.isNull(r10) == true) goto L46;
        r34 = r0.getString(r10);
        goto L51
    L40:
        r31 = r0.getInt(r8);
        goto L41
    L36:
        r29 = r0.getLong(r7);
        goto L37
    L33:
        r27 = r0.getLong(r6);
        goto L34
    L28:
        if (r0.isNull(r5) == true) goto L26;
        r26 = r0.getString(r5);
        goto L31
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r25 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r24 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r23 = r0.getString(r2);
        goto L13
    L5:
        r21 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.entity.k> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfEpisodicTopicMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.entity.k> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfEpisodicTopicMemoryEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.memorydata.database.legacy.entity.k r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfEpisodicTopicMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.memorydata.database.legacy.entity.k r3) {
        return delete2((com.obric.memorydata.database.legacy.entity.k) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.k.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return t.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return t.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.memorydata.database.legacy.entity.k r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfEpisodicTopicMemoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.memorydata.database.legacy.entity.k r3) {
        return insert2((com.obric.memorydata.database.legacy.entity.k) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.k.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.entity.k> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfEpisodicTopicMemoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.k> queryAll() {
        return t.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return t.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.k queryById(long r1) {
        return t.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.k queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.k> queryByIds(List<Long> r3) {
        return t.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.k queryByUUID(String r1) {
        return t.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.k queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.k queryOne() {
        return t.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.k queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.k> queryWithLimitAndOffset(int r1, int r2) {
        return t.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.k> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityEpisodicTopicMemoryEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.memorydata.database.legacy.entity.k r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfEpisodicTopicMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.memorydata.database.legacy.entity.k r3) {
        return update2((com.obric.memorydata.database.legacy.entity.k) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.k.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.entity.k> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfEpisodicTopicMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
