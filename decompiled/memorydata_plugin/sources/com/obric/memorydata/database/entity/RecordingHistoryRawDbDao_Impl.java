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
public final class RecordingHistoryRawDbDao_Impl implements hx {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<hw> __deletionAdapterOfRecordingHistoryEntity;
    private final EntityInsertionAdapter<hw> __insertionAdapterOfRecordingHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<hw> __updateAdapterOfRecordingHistoryEntity;

    public RecordingHistoryRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRecordingHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRecordingHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRecordingHistoryEntity = new AnonymousClass3(this, r2);
    }

    private hw __entityCursorConverter_comObricMemorydataDatabaseEntityRecordingHistoryEntity(Cursor r60) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r60, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "recording_id");
        int r3 = CursorUtil.getColumnIndex(r0, "recording_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "recording_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "recording_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "recording_type");
        int r7 = CursorUtil.getColumnIndex(r0, "recording_timestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "recording_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "recording_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "recording_name");
        int r11 = CursorUtil.getColumnIndex(r0, "recording_file");
        int r12 = CursorUtil.getColumnIndex(r0, "recording_duration");
        int r13 = CursorUtil.getColumnIndex(r0, "recording_transcript");
        int r14 = CursorUtil.getColumnIndex(r0, "recording_summary");
        int r15 = CursorUtil.getColumnIndex(r0, "recording_contentWithTime");
        int r16 = CursorUtil.getColumnIndex(r0, "recording_todoList");
        int r17 = CursorUtil.getColumnIndex(r0, "recording_markers");
        int r18 = CursorUtil.getColumnIndex(r0, "recording_sourceAppName");
        int r19 = CursorUtil.getColumnIndex(r0, "recording_sourceAppPackage");
        int r110 = CursorUtil.getColumnIndex(r0, "recording_fullContent");
        int r111 = CursorUtil.getColumnIndex(r0, "recording_docNodeJson");
        int r112 = CursorUtil.getColumnIndex(r0, "recording_uuid");
        int r113 = CursorUtil.getColumnIndex(r0, "recording_sourceDevice");
        int r114 = CursorUtil.getColumnIndex(r0, "recording_poison_label");
        int r115 = CursorUtil.getColumnIndex(r0, "recording_poison_label_version");
        int r116 = CursorUtil.getColumnIndex(r0, "recording_content_hash");
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
        if (r11 != (-1)) goto L48;
    L46:
        String r46 = null;
    L51:
        if (r12 == (-1)) goto L54;
        r21 = r0.getInt(r12);
    L54:
        int r47 = r21;
        if (r13 != (-1)) goto L58;
    L56:
        String r48 = null;
    L61:
        if (r14 != (-1)) goto L64;
    L62:
        String r49 = null;
    L67:
        if (r59 != (-1)) goto L70;
    L68:
        String r50 = null;
    L73:
        if (r60 != (-1)) goto L77;
    L74:
        String r51 = null;
    L80:
        if (r17 != (-1)) goto L84;
    L81:
        String r52 = null;
    L87:
        if (r18 != (-1)) goto L91;
    L88:
        String r53 = null;
    L94:
        if (r19 != (-1)) goto L98;
    L95:
        String r54 = null;
    L101:
        if (r110 != (-1)) goto L105;
    L102:
        String r55 = null;
    L108:
        if (r111 != (-1)) goto L112;
    L109:
        String r56 = null;
    L115:
        if (r112 != (-1)) goto L119;
    L116:
        String r57 = null;
    L122:
        if (r113 != (-1)) goto L125;
    L123:
        String r58 = null;
    L128:
        hh r22 = new hh(r33, r35, r36, r38, r40, r41, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58);
        if (r114 == (-1)) goto L136;
        if (r0.isNull(r114) == false) goto L133;
        Integer r23 = null;
    L134:
        r22.setPoisonLabel(r23);
        goto L136
    L133:
        r23 = Integer.valueOf(r0.getInt(r114));
    L136:
        if (r115 == (-1)) goto L143;
        if (r0.isNull(r115) == false) goto L140;
        Integer r24 = null;
    L141:
        r22.setPoisonLabelVersion(r24);
        goto L143
    L140:
        r24 = Integer.valueOf(r0.getInt(r115));
    L143:
        if (r116 == (-1)) goto L150;
        if (r0.isNull(r116) == true) goto L148;
        r20 = r0.getString(r116);
    L148:
        r22.setContentHash(r20);
    L150:
        return new hw(r30, r22);
    L125:
        if (r0.isNull(r113) == true) goto L123;
        r58 = r0.getString(r113);
        goto L128
    L119:
        if (r0.isNull(r112) == true) goto L116;
        r57 = r0.getString(r112);
        goto L122
    L112:
        if (r0.isNull(r111) == true) goto L109;
        r56 = r0.getString(r111);
        goto L115
    L105:
        if (r0.isNull(r110) == true) goto L102;
        r55 = r0.getString(r110);
        goto L108
    L98:
        if (r0.isNull(r19) == true) goto L95;
        r54 = r0.getString(r19);
        goto L101
    L91:
        if (r0.isNull(r18) == true) goto L88;
        r53 = r0.getString(r18);
        goto L94
    L84:
        if (r0.isNull(r17) == true) goto L81;
        r52 = r0.getString(r17);
        goto L87
    L77:
        if (r0.isNull(r60) == true) goto L74;
        r51 = r0.getString(r16);
        goto L80
    L70:
        if (r0.isNull(r59) == true) goto L68;
        r50 = r0.getString(r15);
        goto L73
    L64:
        if (r0.isNull(r14) == true) goto L62;
        r49 = r0.getString(r14);
        goto L67
    L58:
        if (r0.isNull(r13) == true) goto L56;
        r48 = r0.getString(r13);
        goto L61
    L48:
        if (r0.isNull(r11) == true) goto L46;
        r46 = r0.getString(r11);
        goto L51
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
    public void bulkDelete(List<hw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRecordingHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<hw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRecordingHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(hw r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRecordingHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((hw) ZeusTransformUtils.preCheckCast(r3, hw.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return hx.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return hx.a.b(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return hx.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return hx.a.b(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return hx.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return hx.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return hx.a.a(this);
    }

    public long insert(hw r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRecordingHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((hw) ZeusTransformUtils.preCheckCast(r3, hw.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<hw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRecordingHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hw> queryAll() {
        return hx.a.c(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return hx.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<hw> queryByEntityId(String r1, String r2) {
        return hx.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<hw> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return hx.a.c(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hw queryById(long r1) {
        return hx.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hw> queryByIds(List<Long> r3) {
        return hx.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hw queryByUUID(String r1) {
        return hx.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public hw queryOne() {
        return hx.a.f(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hw> queryWithLimitAndOffset(int r1, int r2) {
        return hx.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<hw> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRecordingHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(hw r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRecordingHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((hw) ZeusTransformUtils.preCheckCast(r3, hw.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<hw> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRecordingHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
