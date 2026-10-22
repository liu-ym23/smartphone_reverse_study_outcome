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
public final class BackUpProactiveEpisodicRelevantDataDaoOld_Impl implements p {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.p> __deletionAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.p> __insertionAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.p> __insertionAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld_1;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.p> __updateAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld;

    public BackUpProactiveEpisodicRelevantDataDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld = new AnonymousClass3(this, r2);
        this.__updateAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld = new AnonymousClass4(this, r2);
    }

    private com.obric.memorydata.database.legacy.backup.a.p __entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpProactiveEpisodicRelevantDataEntityOld(Cursor r46) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r46, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "backupUserId");
        int r3 = CursorUtil.getColumnIndex(r0, "backupDbVersion");
        int r4 = CursorUtil.getColumnIndex(r0, "backup_id");
        int r5 = CursorUtil.getColumnIndex(r0, "backup_episodic_id");
        int r6 = CursorUtil.getColumnIndex(r0, "backup_source_query");
        int r7 = CursorUtil.getColumnIndex(r0, "backup_source_text");
        int r8 = CursorUtil.getColumnIndex(r0, "backup_source_link");
        int r9 = CursorUtil.getColumnIndex(r0, "backup_source_link_type");
        int r10 = CursorUtil.getColumnIndex(r0, "backup_screenshot");
        int r11 = CursorUtil.getColumnIndex(r0, "backup_source_package_name");
        int r12 = CursorUtil.getColumnIndex(r0, "backup_source_app_name");
        int r13 = CursorUtil.getColumnIndex(r0, "backup_product_type");
        int r14 = CursorUtil.getColumnIndex(r0, "backup_category");
        int r15 = CursorUtil.getColumnIndex(r0, "backup_tag_list");
        int r16 = CursorUtil.getColumnIndex(r0, "backup_summary");
        int r17 = CursorUtil.getColumnIndex(r0, "backup_detail_status");
        int r18 = CursorUtil.getColumnIndex(r0, "backup_personalDbSplitMigrated");
        long r19 = 0;
        if (r1 != (-1)) goto L5;
        long r23 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r26 = null;
    L13:
        boolean r21 = false;
        if (r3 != (-1)) goto L16;
        int r27 = 0;
    L17:
        if (r4 == (-1)) goto L20;
        r19 = r0.getLong(r4);
    L20:
        long r29 = r19;
        if (r5 != (-1)) goto L24;
    L22:
        String r31 = null;
    L27:
        if (r6 != (-1)) goto L30;
    L28:
        String r32 = null;
    L33:
        if (r7 != (-1)) goto L36;
    L34:
        String r33 = null;
    L39:
        if (r8 != (-1)) goto L42;
    L40:
        String r34 = null;
    L45:
        if (r9 != (-1)) goto L48;
    L46:
        String r35 = null;
    L51:
        if (r10 != (-1)) goto L54;
    L52:
        String r36 = null;
    L57:
        if (r11 != (-1)) goto L60;
    L58:
        String r37 = null;
    L63:
        if (r12 != (-1)) goto L66;
    L64:
        String r38 = null;
    L69:
        if (r13 != (-1)) goto L71;
        int r39 = 0;
    L72:
        if (r14 != (-1)) goto L75;
    L73:
        String r40 = null;
    L78:
        if (r45 != (-1)) goto L81;
    L79:
        String r41 = null;
    L84:
        if (r46 != (-1)) goto L87;
    L85:
        String r42 = r20;
        if (r17 != (-1)) goto L92;
        int r43 = 0;
    L94:
        if (r18 != (-1)) goto L97;
    L100:
        return new com.obric.memorydata.database.legacy.backup.a.p(r23, new com.obric.memorydata.database.legacy.entity.w(r29, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r21), r26, r27);
    L97:
        if (r0.getInt(r18) == 0) goto L100;
        r21 = true;
        goto L100
    L92:
        r43 = r0.getInt(r17);
        goto L94
    L87:
        if (r0.isNull(r46) == true) goto L85;
        r20 = r0.getString(r16);
        goto L85
    L81:
        if (r0.isNull(r45) == true) goto L79;
        r41 = r0.getString(r15);
        goto L84
    L75:
        if (r0.isNull(r14) == true) goto L73;
        r40 = r0.getString(r14);
        goto L78
    L71:
        r39 = r0.getInt(r13);
        goto L72
    L66:
        if (r0.isNull(r12) == true) goto L64;
        r38 = r0.getString(r12);
        goto L69
    L60:
        if (r0.isNull(r11) == true) goto L58;
        r37 = r0.getString(r11);
        goto L63
    L54:
        if (r0.isNull(r10) == true) goto L52;
        r36 = r0.getString(r10);
        goto L57
    L48:
        if (r0.isNull(r9) == true) goto L46;
        r35 = r0.getString(r9);
        goto L51
    L42:
        if (r0.isNull(r8) == true) goto L40;
        r34 = r0.getString(r8);
        goto L45
    L36:
        if (r0.isNull(r7) == true) goto L34;
        r33 = r0.getString(r7);
        goto L39
    L30:
        if (r0.isNull(r6) == true) goto L28;
        r32 = r0.getString(r6);
        goto L33
    L24:
        if (r0.isNull(r5) == true) goto L22;
        r31 = r0.getString(r5);
        goto L27
    L16:
        r27 = r0.getInt(r3);
        goto L17
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r26 = r0.getString(r2);
        goto L13
    L5:
        r23 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.backup.a.p> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.backup.a.p> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(com.obric.memorydata.database.legacy.backup.a.p r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((com.obric.memorydata.database.legacy.backup.a.p) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.p.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return p.a.d(this);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public int deleteByBackupUserId(String r1) {
        return p.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return p.a.a(this);
    }

    public long insert(com.obric.memorydata.database.legacy.backup.a.p r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((com.obric.memorydata.database.legacy.backup.a.p) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.p.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.backup.a.p> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.p> queryAll() {
        return p.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return p.a.c(this);
    }

    public List<com.obric.memorydata.database.legacy.backup.a.p> queryByBackupUserId(String r1) {
        return p.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public List<com.obric.memorydata.database.legacy.backup.a.p> queryByBackupUserId(String r1, int r2, int r3) {
        return p.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.p queryById(long r1) {
        return p.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.p> queryByIds(List<Long> r3) {
        return p.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.p queryByUUID(String r1) {
        return p.a.c(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.p queryOne() {
        return p.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.p> queryWithLimitAndOffset(int r1, int r2) {
        return p.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.p> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpProactiveEpisodicRelevantDataEntityOld(r6));     // Catch: Throwable -> L10
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

    public int update(com.obric.memorydata.database.legacy.backup.a.p r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((com.obric.memorydata.database.legacy.backup.a.p) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.p.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.backup.a.p> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBackUpProactiveEpisodicRelevantDataEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
