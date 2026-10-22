package com.obric.memorydata.database.legacy.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class EpisodicTopicMemoryHistoryRawDbDaoOld_Impl implements u {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.l> __deletionAdapterOfEpisodicTopicMemoryHistoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.entity.l> __insertionAdapterOfEpisodicTopicMemoryHistoryEntityOld;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.l> __updateAdapterOfEpisodicTopicMemoryHistoryEntityOld;

    public EpisodicTopicMemoryHistoryRawDbDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfEpisodicTopicMemoryHistoryEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfEpisodicTopicMemoryHistoryEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfEpisodicTopicMemoryHistoryEntityOld = new AnonymousClass3(this, r2);
    }

    private com.obric.memorydata.database.legacy.entity.l __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityEpisodicTopicMemoryHistoryEntityOld(Cursor r42) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r42, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_id");
        int r3 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_summary");
        int r4 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_relateIds");
        int r5 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_logId");
        int r6 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_entityId");
        int r7 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_createTime");
        int r8 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_modifyTime");
        int r9 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_type");
        int r10 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_timestamp");
        int r11 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_packageName");
        int r12 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_hashCodeValue");
        int r13 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_uuid");
        int r14 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_personalDbSplitMigrated");
        int r15 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_poison_label");
        int r16 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_poison_label_version");
        int r17 = CursorUtil.getColumnIndex(r0, "episodic_topic_memory_content_hash");
        long r18 = 0;
        if (r1 != (-1)) goto L5;
        long r21 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r24 = 0;
    L9:
        String r19 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r26 = null;
    L16:
        if (r4 != (-1)) goto L19;
    L17:
        String r27 = null;
    L22:
        if (r5 != (-1)) goto L25;
    L23:
        String r28 = null;
    L28:
        if (r6 != (-1)) goto L31;
    L29:
        String r29 = null;
    L34:
        if (r7 != (-1)) goto L36;
        long r30 = 0;
    L37:
        if (r8 != (-1)) goto L39;
        long r32 = 0;
    L40:
        boolean r20 = false;
        if (r9 != (-1)) goto L43;
        int r34 = 0;
    L44:
        if (r10 == (-1)) goto L47;
        r18 = r0.getLong(r10);
    L47:
        long r35 = r18;
        if (r11 != (-1)) goto L51;
    L49:
        String r37 = null;
    L54:
        if (r12 != (-1)) goto L56;
        int r38 = 0;
    L57:
        if (r13 != (-1)) goto L60;
    L58:
        String r39 = null;
    L63:
        if (r14 != (-1)) goto L66;
    L68:
        com.obric.memorydata.database.legacy.entity.k r22 = new com.obric.memorydata.database.legacy.entity.k(r24, r26, r27, r28, r29, r30, r32, r34, r35, r37, r38, r39, r20);
        if (r15 == (-1)) goto L76;
        if (r0.isNull(r15) == false) goto L73;
        Integer r23 = null;
    L74:
        r22.setPoisonLabel(r23);
        goto L76
    L73:
        r23 = Integer.valueOf(r0.getInt(r15));
    L76:
        if (r16 == (-1)) goto L83;
        if (r0.isNull(r16) == false) goto L80;
        Integer r25 = null;
    L81:
        r22.setPoisonLabelVersion(r25);
        goto L83
    L80:
        r25 = Integer.valueOf(r0.getInt(r16));
    L83:
        if (r17 == (-1)) goto L90;
        if (r0.isNull(r17) == true) goto L88;
        r19 = r0.getString(r17);
    L88:
        r22.setContentHash(r19);
    L90:
        return new com.obric.memorydata.database.legacy.entity.l(r21, r22);
    L66:
        if (r0.getInt(r14) == 0) goto L68;
        r20 = true;
        goto L68
    L60:
        if (r0.isNull(r13) == true) goto L58;
        r39 = r0.getString(r13);
        goto L63
    L56:
        r38 = r0.getInt(r12);
        goto L57
    L51:
        if (r0.isNull(r11) == true) goto L49;
        r37 = r0.getString(r11);
        goto L54
    L43:
        r34 = r0.getInt(r9);
        goto L44
    L39:
        r32 = r0.getLong(r8);
        goto L40
    L36:
        r30 = r0.getLong(r7);
        goto L37
    L31:
        if (r0.isNull(r6) == true) goto L29;
        r29 = r0.getString(r6);
        goto L34
    L25:
        if (r0.isNull(r5) == true) goto L23;
        r28 = r0.getString(r5);
        goto L28
    L19:
        if (r0.isNull(r4) == true) goto L17;
        r27 = r0.getString(r4);
        goto L22
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r26 = r0.getString(r3);
        goto L16
    L8:
        r24 = r0.getLong(r2);
        goto L9
    L5:
        r21 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.entity.l> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfEpisodicTopicMemoryHistoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.entity.l> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfEpisodicTopicMemoryHistoryEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.memorydata.database.legacy.entity.l r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfEpisodicTopicMemoryHistoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.memorydata.database.legacy.entity.l r3) {
        return delete2((com.obric.memorydata.database.legacy.entity.l) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.l.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return u.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return u.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.memorydata.database.legacy.entity.l r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfEpisodicTopicMemoryHistoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.memorydata.database.legacy.entity.l r3) {
        return insert2((com.obric.memorydata.database.legacy.entity.l) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.l.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.entity.l> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfEpisodicTopicMemoryHistoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.l> queryAll() {
        return u.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return u.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.l queryById(long r1) {
        return u.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.l queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.l> queryByIds(List<Long> r3) {
        return u.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.l queryByUUID(String r1) {
        return u.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.l queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.l queryOne() {
        return u.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.l queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.l> queryWithLimitAndOffset(int r1, int r2) {
        return u.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.l> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityEpisodicTopicMemoryHistoryEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.memorydata.database.legacy.entity.l r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfEpisodicTopicMemoryHistoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.memorydata.database.legacy.entity.l r3) {
        return update2((com.obric.memorydata.database.legacy.entity.l) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.l.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.entity.l> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfEpisodicTopicMemoryHistoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
