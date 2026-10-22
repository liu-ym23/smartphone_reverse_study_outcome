package com.obric.memorydata.database.legacy.backup.dao;

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
public final class BackUpEpisodicTopicMemoryDaoOld_Impl implements i {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.i> __deletionAdapterOfBackUpEpisodicTopicMemoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.i> __insertionAdapterOfBackUpEpisodicTopicMemoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.i> __insertionAdapterOfBackUpEpisodicTopicMemoryEntityOld_1;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.i> __updateAdapterOfBackUpEpisodicTopicMemoryEntityOld;

    public BackUpEpisodicTopicMemoryDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBackUpEpisodicTopicMemoryEntityOld = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfBackUpEpisodicTopicMemoryEntityOld_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfBackUpEpisodicTopicMemoryEntityOld = new AnonymousClass3(this, r2);
        this.__updateAdapterOfBackUpEpisodicTopicMemoryEntityOld = new AnonymousClass4(this, r2);
    }

    private com.obric.memorydata.database.legacy.backup.a.i __entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpEpisodicTopicMemoryEntityOld(Cursor r48) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r48, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "backupUserId");
        int r3 = CursorUtil.getColumnIndex(r0, "backupDbVersion");
        int r4 = CursorUtil.getColumnIndex(r0, "backup_id");
        int r5 = CursorUtil.getColumnIndex(r0, "backup_summary");
        int r6 = CursorUtil.getColumnIndex(r0, "backup_relateIds");
        int r7 = CursorUtil.getColumnIndex(r0, "backup_logId");
        int r8 = CursorUtil.getColumnIndex(r0, "backup_entityId");
        int r9 = CursorUtil.getColumnIndex(r0, "backup_createTime");
        int r10 = CursorUtil.getColumnIndex(r0, "backup_modifyTime");
        int r11 = CursorUtil.getColumnIndex(r0, "backup_type");
        int r12 = CursorUtil.getColumnIndex(r0, "backup_timestamp");
        int r13 = CursorUtil.getColumnIndex(r0, "backup_packageName");
        int r14 = CursorUtil.getColumnIndex(r0, "backup_hashCodeValue");
        int r15 = CursorUtil.getColumnIndex(r0, "backup_uuid");
        int r16 = CursorUtil.getColumnIndex(r0, "backup_personalDbSplitMigrated");
        int r17 = CursorUtil.getColumnIndex(r0, "backup_poison_label");
        int r18 = CursorUtil.getColumnIndex(r0, "backup_poison_label_version");
        int r19 = CursorUtil.getColumnIndex(r0, "backup_content_hash");
        long r110 = 0;
        if (r1 != (-1)) goto L5;
        long r24 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r27 = null;
    L13:
        boolean r21 = false;
        if (r3 != (-1)) goto L16;
        int r28 = 0;
    L17:
        if (r4 != (-1)) goto L19;
        long r30 = 0;
    L20:
        if (r5 != (-1)) goto L23;
    L21:
        String r32 = null;
    L26:
        if (r6 != (-1)) goto L29;
    L27:
        String r33 = null;
    L32:
        if (r7 != (-1)) goto L35;
    L33:
        String r34 = null;
    L38:
        if (r8 != (-1)) goto L41;
    L39:
        String r35 = null;
    L44:
        if (r9 != (-1)) goto L46;
        long r36 = 0;
    L47:
        if (r10 != (-1)) goto L49;
        long r38 = 0;
    L50:
        if (r11 != (-1)) goto L52;
        int r40 = 0;
    L53:
        if (r12 == (-1)) goto L56;
        r110 = r0.getLong(r12);
    L56:
        long r41 = r110;
        if (r13 != (-1)) goto L60;
    L58:
        String r43 = null;
    L63:
        if (r14 != (-1)) goto L65;
        int r44 = 0;
    L66:
        if (r47 != (-1)) goto L69;
    L67:
        String r45 = null;
    L72:
        if (r48 != (-1)) goto L75;
    L77:
        com.obric.memorydata.database.legacy.entity.k r22 = new com.obric.memorydata.database.legacy.entity.k(r30, r32, r33, r34, r35, r36, r38, r40, r41, r43, r44, r45, r21);
        if (r17 == (-1)) goto L85;
        if (r0.isNull(r17) == false) goto L82;
        Integer r23 = null;
    L83:
        r22.setPoisonLabel(r23);
        goto L85
    L82:
        r23 = Integer.valueOf(r0.getInt(r17));
    L85:
        if (r18 == (-1)) goto L92;
        if (r0.isNull(r18) == false) goto L89;
        Integer r25 = null;
    L90:
        r22.setPoisonLabelVersion(r25);
        goto L92
    L89:
        r25 = Integer.valueOf(r0.getInt(r18));
    L92:
        if (r19 == (-1)) goto L99;
        if (r0.isNull(r19) == true) goto L97;
        r20 = r0.getString(r19);
    L97:
        r22.setContentHash(r20);
    L99:
        return new com.obric.memorydata.database.legacy.backup.a.i(r24, r22, r27, r28);
    L75:
        if (r0.getInt(r16) == 0) goto L77;
        r21 = true;
        goto L77
    L69:
        if (r0.isNull(r47) == true) goto L67;
        r45 = r0.getString(r15);
        goto L72
    L65:
        r44 = r0.getInt(r14);
        goto L66
    L60:
        if (r0.isNull(r13) == true) goto L58;
        r43 = r0.getString(r13);
        goto L63
    L52:
        r40 = r0.getInt(r11);
        goto L53
    L49:
        r38 = r0.getLong(r10);
        goto L50
    L46:
        r36 = r0.getLong(r9);
        goto L47
    L41:
        if (r0.isNull(r8) == true) goto L39;
        r35 = r0.getString(r8);
        goto L44
    L35:
        if (r0.isNull(r7) == true) goto L33;
        r34 = r0.getString(r7);
        goto L38
    L29:
        if (r0.isNull(r6) == true) goto L27;
        r33 = r0.getString(r6);
        goto L32
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r32 = r0.getString(r5);
        goto L26
    L19:
        r30 = r0.getLong(r4);
        goto L20
    L16:
        r28 = r0.getInt(r3);
        goto L17
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r27 = r0.getString(r2);
        goto L13
    L5:
        r24 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.backup.a.i> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBackUpEpisodicTopicMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.backup.a.i> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBackUpEpisodicTopicMemoryEntityOld_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(com.obric.memorydata.database.legacy.backup.a.i r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBackUpEpisodicTopicMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((com.obric.memorydata.database.legacy.backup.a.i) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.i.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return i.a.d(this);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public int deleteByBackupUserId(String r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return i.a.a(this);
    }

    public long insert(com.obric.memorydata.database.legacy.backup.a.i r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBackUpEpisodicTopicMemoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((com.obric.memorydata.database.legacy.backup.a.i) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.i.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.backup.a.i> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBackUpEpisodicTopicMemoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.i> queryAll() {
        return i.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return i.a.c(this);
    }

    public List<com.obric.memorydata.database.legacy.backup.a.i> queryByBackupUserId(String r1) {
        return i.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public List<com.obric.memorydata.database.legacy.backup.a.i> queryByBackupUserId(String r1, int r2, int r3) {
        return i.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.i queryById(long r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.i> queryByIds(List<Long> r3) {
        return i.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.i queryByUUID(String r1) {
        return i.a.c(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.i queryOne() {
        return i.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.i> queryWithLimitAndOffset(int r1, int r2) {
        return i.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.i> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpEpisodicTopicMemoryEntityOld(r6));     // Catch: Throwable -> L10
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

    public int update(com.obric.memorydata.database.legacy.backup.a.i r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBackUpEpisodicTopicMemoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((com.obric.memorydata.database.legacy.backup.a.i) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.i.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.backup.a.i> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBackUpEpisodicTopicMemoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
