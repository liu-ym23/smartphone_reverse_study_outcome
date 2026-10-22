package com.obric.memorydata.database.entity;

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
public final class AuditoryRecordingHistoryEntityDao_Impl implements r {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<fl> __deletionAdapterOfRawAuditoryRecordingHistoryEntity;
    private final EntityInsertionAdapter<fl> __insertionAdapterOfRawAuditoryRecordingHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<fl> __updateAdapterOfRawAuditoryRecordingHistoryEntity;

    public AuditoryRecordingHistoryEntityDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawAuditoryRecordingHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawAuditoryRecordingHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawAuditoryRecordingHistoryEntity = new AnonymousClass3(this, r2);
    }

    private fl __entityCursorConverter_comObricMemorydataDatabaseEntityRawAuditoryRecordingHistoryEntity(Cursor r60) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r60, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "auditoryid");
        int r3 = CursorUtil.getColumnIndex(r0, "auditoryentityId");
        int r4 = CursorUtil.getColumnIndex(r0, "auditorycreateTime");
        int r5 = CursorUtil.getColumnIndex(r0, "auditorymodifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "auditorytype");
        int r7 = CursorUtil.getColumnIndex(r0, "auditorytimestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "auditorypackageName");
        int r9 = CursorUtil.getColumnIndex(r0, "auditoryhashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "auditoryname");
        int r11 = CursorUtil.getColumnIndex(r0, "auditorystate");
        int r12 = CursorUtil.getColumnIndex(r0, "auditoryfile");
        int r13 = CursorUtil.getColumnIndex(r0, "auditoryduration");
        int r14 = CursorUtil.getColumnIndex(r0, "auditorytranscript");
        int r15 = CursorUtil.getColumnIndex(r0, "auditorysummary");
        int r16 = CursorUtil.getColumnIndex(r0, "auditorytodoList");
        int r17 = CursorUtil.getColumnIndex(r0, "auditorymarkers");
        int r18 = CursorUtil.getColumnIndex(r0, "auditorysourceAppName");
        int r19 = CursorUtil.getColumnIndex(r0, "auditorysourceAppPackage");
        int r110 = CursorUtil.getColumnIndex(r0, "auditoryrequestTime");
        int r111 = CursorUtil.getColumnIndex(r0, "auditorydid");
        int r112 = CursorUtil.getColumnIndex(r0, "auditorydocNodeJson");
        int r113 = CursorUtil.getColumnIndex(r0, "auditoryuuid");
        int r114 = CursorUtil.getColumnIndex(r0, "auditorypoison_label");
        int r115 = CursorUtil.getColumnIndex(r0, "auditorypoison_label_version");
        int r116 = CursorUtil.getColumnIndex(r0, "auditorycontent_hash");
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
        int r21 = 0;
        if (r6 != (-1)) goto L25;
        int r40 = 0;
    L26:
        if (r7 == (-1)) goto L29;
        r25 = r0.getLong(r7);
    L29:
        long r41 = r25;
        if (r8 != (-1)) goto L33;
    L31:
        String r43 = null;
    L36:
        if (r9 != (-1)) goto L38;
        int r44 = 0;
    L39:
        if (r10 != (-1)) goto L42;
    L40:
        String r45 = null;
    L45:
        if (r11 != (-1)) goto L47;
        int r46 = 0;
    L48:
        if (r12 != (-1)) goto L51;
    L49:
        String r47 = null;
    L54:
        if (r13 == (-1)) goto L57;
        r21 = r0.getInt(r13);
    L57:
        int r48 = r21;
        if (r14 != (-1)) goto L61;
    L59:
        String r49 = null;
    L64:
        if (r59 != (-1)) goto L67;
    L65:
        String r50 = null;
    L70:
        if (r60 != (-1)) goto L74;
    L71:
        String r51 = null;
    L77:
        if (r17 != (-1)) goto L81;
    L78:
        String r52 = null;
    L84:
        if (r18 != (-1)) goto L88;
    L85:
        String r53 = null;
    L91:
        if (r19 != (-1)) goto L95;
    L92:
        String r54 = null;
    L98:
        if (r110 != (-1)) goto L102;
    L99:
        Long r55 = null;
    L105:
        if (r111 != (-1)) goto L109;
    L106:
        String r56 = null;
    L112:
        if (r112 != (-1)) goto L116;
    L113:
        String r57 = null;
    L119:
        if (r113 != (-1)) goto L122;
    L120:
        String r58 = null;
    L125:
        fj r22 = new fj(r33, r35, r36, r38, r40, r41, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58);
        if (r114 == (-1)) goto L133;
        if (r0.isNull(r114) == false) goto L130;
        Integer r23 = null;
    L131:
        r22.setPoisonLabel(r23);
        goto L133
    L130:
        r23 = Integer.valueOf(r0.getInt(r114));
    L133:
        if (r115 == (-1)) goto L140;
        if (r0.isNull(r115) == false) goto L137;
        Integer r24 = null;
    L138:
        r22.setPoisonLabelVersion(r24);
        goto L140
    L137:
        r24 = Integer.valueOf(r0.getInt(r115));
    L140:
        if (r116 == (-1)) goto L147;
        if (r0.isNull(r116) == true) goto L145;
        r20 = r0.getString(r116);
    L145:
        r22.setContentHash(r20);
    L147:
        return new fl(r30, r22);
    L122:
        if (r0.isNull(r113) == true) goto L120;
        r58 = r0.getString(r113);
        goto L125
    L116:
        if (r0.isNull(r112) == true) goto L113;
        r57 = r0.getString(r112);
        goto L119
    L109:
        if (r0.isNull(r111) == true) goto L106;
        r56 = r0.getString(r111);
        goto L112
    L102:
        if (r0.isNull(r110) == true) goto L99;
        r55 = Long.valueOf(r0.getLong(r110));
        goto L105
    L95:
        if (r0.isNull(r19) == true) goto L92;
        r54 = r0.getString(r19);
        goto L98
    L88:
        if (r0.isNull(r18) == true) goto L85;
        r53 = r0.getString(r18);
        goto L91
    L81:
        if (r0.isNull(r17) == true) goto L78;
        r52 = r0.getString(r17);
        goto L84
    L74:
        if (r0.isNull(r60) == true) goto L71;
        r51 = r0.getString(r16);
        goto L77
    L67:
        if (r0.isNull(r59) == true) goto L65;
        r50 = r0.getString(r15);
        goto L70
    L61:
        if (r0.isNull(r14) == true) goto L59;
        r49 = r0.getString(r14);
        goto L64
    L51:
        if (r0.isNull(r12) == true) goto L49;
        r47 = r0.getString(r12);
        goto L54
    L47:
        r46 = r0.getInt(r11);
        goto L48
    L42:
        if (r0.isNull(r10) == true) goto L40;
        r45 = r0.getString(r10);
        goto L45
    L38:
        r44 = r0.getInt(r9);
        goto L39
    L33:
        if (r0.isNull(r8) == true) goto L31;
        r43 = r0.getString(r8);
        goto L36
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
    public void bulkDelete(List<fl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawAuditoryRecordingHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<fl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawAuditoryRecordingHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(fl r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawAuditoryRecordingHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((fl) ZeusTransformUtils.preCheckCast(r3, fl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return r.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return r.a.b(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return r.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return r.a.b(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return r.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return r.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return r.a.a(this);
    }

    public long insert(fl r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawAuditoryRecordingHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((fl) ZeusTransformUtils.preCheckCast(r3, fl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<fl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawAuditoryRecordingHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fl> queryAll() {
        return r.a.c(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return r.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<fl> queryByEntityId(String r1, String r2) {
        return r.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<fl> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return r.a.c(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fl queryById(long r1) {
        return r.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fl> queryByIds(List<Long> r3) {
        return r.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fl queryByUUID(String r1) {
        return r.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fl queryOne() {
        return r.a.f(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fl> queryWithLimitAndOffset(int r1, int r2) {
        return r.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fl> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawAuditoryRecordingHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(fl r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawAuditoryRecordingHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((fl) ZeusTransformUtils.preCheckCast(r3, fl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<fl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawAuditoryRecordingHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
