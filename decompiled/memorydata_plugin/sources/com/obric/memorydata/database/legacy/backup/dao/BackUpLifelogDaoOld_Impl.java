package com.obric.memorydata.database.legacy.backup.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.lifelog.data.Lifelog;
import com.obric.memorydata.database.legacy.entity.LifelogEntityOld;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class BackUpLifelogDaoOld_Impl implements j {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.j> __deletionAdapterOfBackUpLifelogEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.j> __insertionAdapterOfBackUpLifelogEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.backup.a.j> __insertionAdapterOfBackUpLifelogEntityOld_1;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.backup.a.j> __updateAdapterOfBackUpLifelogEntityOld;

    public BackUpLifelogDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfBackUpLifelogEntityOld = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfBackUpLifelogEntityOld_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfBackUpLifelogEntityOld = new AnonymousClass3(this, r2);
        this.__updateAdapterOfBackUpLifelogEntityOld = new AnonymousClass4(this, r2);
    }

    private com.obric.memorydata.database.legacy.backup.a.j __entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpLifelogEntityOld(Cursor r66) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r66, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "backupUserId");
        int r3 = CursorUtil.getColumnIndex(r0, "backupDbVersion");
        int r4 = CursorUtil.getColumnIndex(r0, "backup_id");
        int r5 = CursorUtil.getColumnIndex(r0, "backup_entityId");
        int r6 = CursorUtil.getColumnIndex(r0, "backup_createTime");
        int r7 = CursorUtil.getColumnIndex(r0, "backup_modifyTime");
        int r8 = CursorUtil.getColumnIndex(r0, "backup_type");
        int r9 = CursorUtil.getColumnIndex(r0, "backup_entityTimestamp");
        int r10 = CursorUtil.getColumnIndex(r0, "backup_packageName");
        int r11 = CursorUtil.getColumnIndex(r0, "backup_hashCodeValue");
        int r12 = CursorUtil.getColumnIndex(r0, "backup_uuid");
        int r13 = CursorUtil.getColumnIndex(r0, "backup_fullContent");
        int r14 = CursorUtil.getColumnIndex(r0, "backup_personalDbSplitMigrated");
        int r15 = CursorUtil.getColumnIndex(r0, "backup_poison_label");
        int r16 = CursorUtil.getColumnIndex(r0, "backup_poison_label_version");
        int r17 = CursorUtil.getColumnIndex(r0, "backup_content_hash");
        int r18 = CursorUtil.getColumnIndex(r0, "backup_timestamp");
        int r19 = CursorUtil.getColumnIndex(r0, "backup_uid");
        int r110 = CursorUtil.getColumnIndex(r0, "backup_title");
        int r111 = CursorUtil.getColumnIndex(r0, "backup_contentAM");
        int r112 = CursorUtil.getColumnIndex(r0, "backup_contentPM");
        int r113 = CursorUtil.getColumnIndex(r0, "backup_finalContent");
        int r114 = CursorUtil.getColumnIndex(r0, "backup_imageUrl");
        int r115 = CursorUtil.getColumnIndex(r0, "backup_retryTime");
        int r116 = CursorUtil.getColumnIndex(r0, "backup_status");
        long r25 = 0;
        if (r1 != (-1)) goto L5;
        long r31 = 0;
    L6:
        String r20 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r34 = null;
    L13:
        int r21 = 0;
        if (r3 != (-1)) goto L16;
        int r35 = 0;
    L17:
        if (r4 != (-1)) goto L19;
        long r37 = 0;
    L20:
        if (r5 != (-1)) goto L23;
    L21:
        String r39 = null;
    L26:
        if (r6 != (-1)) goto L28;
        long r40 = 0;
    L29:
        if (r7 != (-1)) goto L31;
        long r42 = 0;
    L32:
        if (r8 != (-1)) goto L34;
        int r44 = 0;
    L35:
        if (r9 != (-1)) goto L37;
        long r45 = 0;
    L38:
        if (r10 != (-1)) goto L41;
    L39:
        String r47 = null;
    L44:
        if (r11 != (-1)) goto L46;
        int r48 = 0;
    L47:
        if (r12 != (-1)) goto L50;
    L48:
        String r49 = null;
    L53:
        if (r13 != (-1)) goto L56;
    L54:
        String r51 = null;
    L59:
        if (r14 != (-1)) goto L63;
        boolean r52 = false;
    L67:
        if (r18 != (-1)) goto L69;
        long r54 = 0;
    L70:
        if (r18 == (-1)) goto L73;
        r25 = r0.getLong(r19);
    L73:
        long r56 = r25;
        if (r110 != (-1)) goto L78;
    L75:
        String r58 = null;
    L81:
        if (r111 != (-1)) goto L85;
    L82:
        String r59 = null;
    L88:
        if (r112 != (-1)) goto L92;
    L89:
        String r60 = null;
    L95:
        if (r113 != (-1)) goto L99;
    L96:
        String r61 = null;
    L102:
        if (r114 != (-1)) goto L106;
    L103:
        String r62 = null;
    L109:
        if (r115 != (-1)) goto L111;
        int r63 = 0;
    L113:
        if (r116 == (-1)) goto L116;
        r21 = r0.getInt(r116);
    L116:
        LifelogEntityOld r22 = new LifelogEntityOld(r37, r39, r40, r42, r44, r45, r47, r48, r49, new Lifelog(r54, r56, r58, r59, r60, r61, r62, r63, r21), r51, r52);
        if (r15 == (-1)) goto L124;
        if (r0.isNull(r15) == false) goto L121;
        Integer r23 = null;
    L122:
        r22.setPoisonLabel(r23);
        goto L124
    L121:
        r23 = Integer.valueOf(r0.getInt(r15));
    L124:
        if (r16 == (-1)) goto L131;
        if (r0.isNull(r16) == false) goto L128;
        Integer r24 = null;
    L129:
        r22.setPoisonLabelVersion(r24);
        goto L131
    L128:
        r24 = Integer.valueOf(r0.getInt(r16));
    L131:
        if (r17 == (-1)) goto L138;
        if (r0.isNull(r17) == true) goto L136;
        r20 = r0.getString(r17);
    L136:
        r22.setContentHash(r20);
    L138:
        return new com.obric.memorydata.database.legacy.backup.a.j(r31, r22, r34, r35);
    L111:
        r63 = r0.getInt(r115);
        goto L113
    L106:
        if (r0.isNull(r114) == true) goto L103;
        r62 = r0.getString(r114);
        goto L109
    L99:
        if (r0.isNull(r113) == true) goto L96;
        r61 = r0.getString(r113);
        goto L102
    L92:
        if (r0.isNull(r112) == true) goto L89;
        r60 = r0.getString(r112);
        goto L95
    L85:
        if (r0.isNull(r111) == true) goto L82;
        r59 = r0.getString(r111);
        goto L88
    L78:
        if (r0.isNull(r110) == true) goto L75;
        r58 = r0.getString(r110);
        goto L81
    L69:
        r54 = r0.getLong(r18);
        goto L70
    L63:
        if (r0.getInt(r14) == 0) goto L65;
        boolean r26 = true;
    L66:
        r52 = r26;
        goto L67
    L65:
        r26 = false;
        goto L66
    L56:
        if (r0.isNull(r13) == true) goto L54;
        r51 = r0.getString(r13);
        goto L59
    L50:
        if (r0.isNull(r12) == true) goto L48;
        r49 = r0.getString(r12);
        goto L53
    L46:
        r48 = r0.getInt(r11);
        goto L47
    L41:
        if (r0.isNull(r10) == true) goto L39;
        r47 = r0.getString(r10);
        goto L44
    L37:
        r45 = r0.getLong(r9);
        goto L38
    L34:
        r44 = r0.getInt(r8);
        goto L35
    L31:
        r42 = r0.getLong(r7);
        goto L32
    L28:
        r40 = r0.getLong(r6);
        goto L29
    L23:
        if (r0.isNull(r5) == true) goto L21;
        r39 = r0.getString(r5);
        goto L26
    L19:
        r37 = r0.getLong(r4);
        goto L20
    L16:
        r35 = r0.getInt(r3);
        goto L17
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r34 = r0.getString(r2);
        goto L13
    L5:
        r31 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.backup.a.j> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfBackUpLifelogEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.backup.a.j> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfBackUpLifelogEntityOld_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(com.obric.memorydata.database.legacy.backup.a.j r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfBackUpLifelogEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((com.obric.memorydata.database.legacy.backup.a.j) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.j.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return j.a.d(this);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public int deleteByBackupUserId(String r1) {
        return j.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return j.a.a(this);
    }

    public long insert(com.obric.memorydata.database.legacy.backup.a.j r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfBackUpLifelogEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((com.obric.memorydata.database.legacy.backup.a.j) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.j.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.backup.a.j> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfBackUpLifelogEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.j> queryAll() {
        return j.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return j.a.c(this);
    }

    public List<com.obric.memorydata.database.legacy.backup.a.j> queryByBackupUserId(String r1) {
        return j.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.backup.dao.e
    public List<com.obric.memorydata.database.legacy.backup.a.j> queryByBackupUserId(String r1, int r2, int r3) {
        return j.a.a(this, r1, r2, r3);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.j queryById(long r1) {
        return j.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.j> queryByIds(List<Long> r3) {
        return j.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.j queryByUUID(String r1) {
        return j.a.c(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.backup.a.j queryOne() {
        return j.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.j> queryWithLimitAndOffset(int r1, int r2) {
        return j.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.backup.a.j> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyBackupEntityBackUpLifelogEntityOld(r6));     // Catch: Throwable -> L10
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

    public int update(com.obric.memorydata.database.legacy.backup.a.j r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfBackUpLifelogEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((com.obric.memorydata.database.legacy.backup.a.j) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.backup.a.j.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.backup.a.j> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfBackUpLifelogEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
