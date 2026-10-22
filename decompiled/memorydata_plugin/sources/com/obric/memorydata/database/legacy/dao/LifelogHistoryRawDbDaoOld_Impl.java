package com.obric.memorydata.database.legacy.dao;

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
public final class LifelogHistoryRawDbDaoOld_Impl implements y {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.o> __deletionAdapterOfLifelogHistoryEntityOld;
    private final EntityInsertionAdapter<com.obric.memorydata.database.legacy.entity.o> __insertionAdapterOfLifelogHistoryEntityOld;
    private final EntityDeletionOrUpdateAdapter<com.obric.memorydata.database.legacy.entity.o> __updateAdapterOfLifelogHistoryEntityOld;

    public LifelogHistoryRawDbDaoOld_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfLifelogHistoryEntityOld = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfLifelogHistoryEntityOld = new AnonymousClass2(this, r2);
        this.__updateAdapterOfLifelogHistoryEntityOld = new AnonymousClass3(this, r2);
    }

    private com.obric.memorydata.database.legacy.entity.o __entityCursorConverter_comObricMemorydataDatabaseLegacyEntityLifelogHistoryEntityOld(Cursor r60) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r60, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "lifelog_id");
        int r3 = CursorUtil.getColumnIndex(r0, "lifelog_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "lifelog_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "lifelog_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "lifelog_type");
        int r7 = CursorUtil.getColumnIndex(r0, "lifelog_entityTimestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "lifelog_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "lifelog_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "lifelog_uuid");
        int r11 = CursorUtil.getColumnIndex(r0, "lifelog_fullContent");
        int r12 = CursorUtil.getColumnIndex(r0, "lifelog_personalDbSplitMigrated");
        int r13 = CursorUtil.getColumnIndex(r0, "lifelog_poison_label");
        int r14 = CursorUtil.getColumnIndex(r0, "lifelog_poison_label_version");
        int r15 = CursorUtil.getColumnIndex(r0, "lifelog_content_hash");
        int r16 = CursorUtil.getColumnIndex(r0, "lifelog_timestamp");
        int r17 = CursorUtil.getColumnIndex(r0, "lifelog_uid");
        int r18 = CursorUtil.getColumnIndex(r0, "lifelog_title");
        int r19 = CursorUtil.getColumnIndex(r0, "lifelog_contentAM");
        int r110 = CursorUtil.getColumnIndex(r0, "lifelog_contentPM");
        int r111 = CursorUtil.getColumnIndex(r0, "lifelog_finalContent");
        int r112 = CursorUtil.getColumnIndex(r0, "lifelog_imageUrl");
        int r113 = CursorUtil.getColumnIndex(r0, "lifelog_retryTime");
        int r114 = CursorUtil.getColumnIndex(r0, "lifelog_status");
        long r23 = 0;
        if (r1 != (-1)) goto L5;
        long r28 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r31 = 0;
    L9:
        String r20 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r33 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r34 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r36 = 0;
    L22:
        int r21 = 0;
        if (r6 != (-1)) goto L25;
        int r38 = 0;
    L26:
        if (r7 != (-1)) goto L28;
        long r39 = 0;
    L29:
        if (r8 != (-1)) goto L32;
    L30:
        String r41 = null;
    L35:
        if (r9 != (-1)) goto L37;
        int r42 = 0;
    L38:
        if (r10 != (-1)) goto L41;
    L39:
        String r43 = null;
    L44:
        if (r11 != (-1)) goto L47;
    L45:
        String r45 = null;
    L50:
        if (r12 != (-1)) goto L53;
        boolean r46 = false;
    L57:
        if (r16 != (-1)) goto L59;
        long r48 = 0;
    L60:
        if (r17 == (-1)) goto L63;
        r23 = r0.getLong(r17);
    L63:
        long r50 = r23;
        if (r18 != (-1)) goto L68;
    L65:
        String r52 = null;
    L71:
        if (r19 != (-1)) goto L75;
    L72:
        String r53 = null;
    L78:
        if (r110 != (-1)) goto L82;
    L79:
        String r54 = null;
    L85:
        if (r111 != (-1)) goto L89;
    L86:
        String r55 = null;
    L92:
        if (r112 != (-1)) goto L96;
    L93:
        String r56 = null;
    L99:
        if (r113 != (-1)) goto L101;
        int r57 = 0;
    L103:
        if (r114 == (-1)) goto L106;
        r21 = r0.getInt(r114);
    L106:
        LifelogEntityOld r22 = new LifelogEntityOld(r31, r33, r34, r36, r38, r39, r41, r42, r43, new Lifelog(r48, r50, r52, r53, r54, r55, r56, r57, r21), r45, r46);
        if (r13 == (-1)) goto L114;
        if (r0.isNull(r13) == false) goto L111;
        Integer r24 = null;
    L112:
        r22.setPoisonLabel(r24);
        goto L114
    L111:
        r24 = Integer.valueOf(r0.getInt(r13));
    L114:
        if (r14 == (-1)) goto L121;
        if (r0.isNull(r14) == false) goto L118;
        Integer r25 = null;
    L119:
        r22.setPoisonLabelVersion(r25);
        goto L121
    L118:
        r25 = Integer.valueOf(r0.getInt(r14));
    L121:
        if (r15 == (-1)) goto L128;
        if (r0.isNull(r15) == true) goto L126;
        r20 = r0.getString(r15);
    L126:
        r22.setContentHash(r20);
    L128:
        return new com.obric.memorydata.database.legacy.entity.o(r28, r22);
    L101:
        r57 = r0.getInt(r113);
        goto L103
    L96:
        if (r0.isNull(r112) == true) goto L93;
        r56 = r0.getString(r112);
        goto L99
    L89:
        if (r0.isNull(r111) == true) goto L86;
        r55 = r0.getString(r111);
        goto L92
    L82:
        if (r0.isNull(r110) == true) goto L79;
        r54 = r0.getString(r110);
        goto L85
    L75:
        if (r0.isNull(r19) == true) goto L72;
        r53 = r0.getString(r19);
        goto L78
    L68:
        if (r0.isNull(r18) == true) goto L65;
        r52 = r0.getString(r18);
        goto L71
    L59:
        r48 = r0.getLong(r16);
        goto L60
    L53:
        if (r0.getInt(r12) == 0) goto L55;
        boolean r26 = true;
    L56:
        r46 = r26;
        goto L57
    L55:
        r26 = false;
        goto L56
    L47:
        if (r0.isNull(r11) == true) goto L45;
        r45 = r0.getString(r11);
        goto L50
    L41:
        if (r0.isNull(r10) == true) goto L39;
        r43 = r0.getString(r10);
        goto L44
    L37:
        r42 = r0.getInt(r9);
        goto L38
    L32:
        if (r0.isNull(r8) == true) goto L30;
        r41 = r0.getString(r8);
        goto L35
    L28:
        r39 = r0.getLong(r7);
        goto L29
    L25:
        r38 = r0.getInt(r6);
        goto L26
    L21:
        r36 = r0.getLong(r5);
        goto L22
    L18:
        r34 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r33 = r0.getString(r3);
        goto L16
    L8:
        r31 = r0.getLong(r2);
        goto L9
    L5:
        r28 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<com.obric.memorydata.database.legacy.entity.o> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfLifelogHistoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<com.obric.memorydata.database.legacy.entity.o> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfLifelogHistoryEntityOld.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(com.obric.memorydata.database.legacy.entity.o r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfLifelogHistoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(com.obric.memorydata.database.legacy.entity.o r3) {
        return delete2((com.obric.memorydata.database.legacy.entity.o) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.o.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return y.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return y.a.a(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(com.obric.memorydata.database.legacy.entity.o r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfLifelogHistoryEntityOld.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(com.obric.memorydata.database.legacy.entity.o r3) {
        return insert2((com.obric.memorydata.database.legacy.entity.o) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.o.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<com.obric.memorydata.database.legacy.entity.o> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfLifelogHistoryEntityOld.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.o> queryAll() {
        return y.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return y.a.c(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.o queryById(long r1) {
        return y.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.o queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.o> queryByIds(List<Long> r3) {
        return y.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.o queryByUUID(String r1) {
        return y.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.o queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public com.obric.memorydata.database.legacy.entity.o queryOne() {
        return y.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ com.obric.memorydata.database.legacy.entity.o queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.o> queryWithLimitAndOffset(int r1, int r2) {
        return y.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<com.obric.memorydata.database.legacy.entity.o> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseLegacyEntityLifelogHistoryEntityOld(r6));     // Catch: Throwable -> L10
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
    public int update2(com.obric.memorydata.database.legacy.entity.o r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfLifelogHistoryEntityOld.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(com.obric.memorydata.database.legacy.entity.o r3) {
        return update2((com.obric.memorydata.database.legacy.entity.o) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.database.legacy.entity.o.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<com.obric.memorydata.database.legacy.entity.o> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfLifelogHistoryEntityOld.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
