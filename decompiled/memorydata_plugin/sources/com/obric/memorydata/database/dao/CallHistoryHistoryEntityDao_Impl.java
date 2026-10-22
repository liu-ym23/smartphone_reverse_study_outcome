package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.fq;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class CallHistoryHistoryEntityDao_Impl implements CallHistoryHistoryEntityDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<CallHistoryHistoryEntity> __deletionAdapterOfCallHistoryHistoryEntity;
    private final EntityInsertionAdapter<CallHistoryHistoryEntity> __insertionAdapterOfCallHistoryHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<CallHistoryHistoryEntity> __updateAdapterOfCallHistoryHistoryEntity;

    public CallHistoryHistoryEntityDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfCallHistoryHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfCallHistoryHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfCallHistoryHistoryEntity = new AnonymousClass3(this, r2);
    }

    private CallHistoryHistoryEntity __entityCursorConverter_comObricMemorydataDatabaseDaoCallHistoryHistoryEntity(Cursor r64) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r64, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "call_id");
        int r3 = CursorUtil.getColumnIndex(r0, "call_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "call_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "call_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "call_type");
        int r7 = CursorUtil.getColumnIndex(r0, "call_timestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "call_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "call_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "call_uuid");
        int r11 = CursorUtil.getColumnIndex(r0, "call_telephones");
        int r12 = CursorUtil.getColumnIndex(r0, "call_contactIds");
        int r13 = CursorUtil.getColumnIndex(r0, "call_callType");
        int r14 = CursorUtil.getColumnIndex(r0, "call_duration");
        int r15 = CursorUtil.getColumnIndex(r0, "call_tag");
        int r16 = CursorUtil.getColumnIndex(r0, "call_isAIPickup");
        int r17 = CursorUtil.getColumnIndex(r0, "call_hasTranscript");
        int r18 = CursorUtil.getColumnIndex(r0, "call_transcript");
        int r19 = CursorUtil.getColumnIndex(r0, "call_contentWithTime");
        int r110 = CursorUtil.getColumnIndex(r0, "call_carriers");
        int r111 = CursorUtil.getColumnIndex(r0, "call_fullContent");
        int r112 = CursorUtil.getColumnIndex(r0, "call_telephoneStandardMap");
        int r113 = CursorUtil.getColumnIndex(r0, "call_todoList");
        int r114 = CursorUtil.getColumnIndex(r0, "call_transcriptTitle");
        int r115 = CursorUtil.getColumnIndex(r0, "call_source_number");
        int r116 = CursorUtil.getColumnIndex(r0, "call_poison_label");
        int r117 = CursorUtil.getColumnIndex(r0, "call_poison_label_version");
        int r118 = CursorUtil.getColumnIndex(r0, "call_content_hash");
        long r27 = 0;
        if (r1 != (-1)) goto L5;
        long r32 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r35 = 0;
    L9:
        String r20 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r37 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r38 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r40 = 0;
    L22:
        boolean r21 = false;
        if (r6 != (-1)) goto L25;
        int r42 = 0;
    L26:
        if (r7 == (-1)) goto L29;
        r27 = r0.getLong(r7);
    L29:
        long r43 = r27;
        if (r8 != (-1)) goto L33;
    L31:
        String r45 = null;
    L36:
        if (r9 != (-1)) goto L38;
        int r46 = 0;
    L39:
        if (r10 != (-1)) goto L42;
    L40:
        String r47 = null;
    L45:
        if (r11 != (-1)) goto L48;
    L46:
        String r48 = null;
    L51:
        if (r12 != (-1)) goto L54;
    L52:
        String r49 = null;
    L57:
        if (r13 != (-1)) goto L60;
    L58:
        String r50 = null;
    L63:
        if (r14 != (-1)) goto L65;
        int r51 = 0;
    L66:
        if (r63 != (-1)) goto L69;
    L67:
        String r52 = null;
    L73:
        if (r16 != (-1)) goto L77;
        boolean r53 = false;
    L81:
        if (r17 != (-1)) goto L84;
    L82:
        boolean r54 = r21;
        if (r18 != (-1)) goto L90;
    L87:
        String r55 = null;
    L93:
        if (r19 != (-1)) goto L97;
    L94:
        String r56 = null;
    L100:
        if (r110 != (-1)) goto L104;
    L101:
        String r57 = null;
    L107:
        if (r111 != (-1)) goto L111;
    L108:
        String r58 = null;
    L114:
        if (r112 != (-1)) goto L118;
    L115:
        String r59 = null;
    L121:
        if (r113 != (-1)) goto L125;
    L122:
        String r60 = null;
    L128:
        if (r114 != (-1)) goto L132;
    L129:
        String r61 = null;
    L135:
        if (r115 != (-1)) goto L138;
    L136:
        String r62 = null;
    L141:
        fq r22 = new fq(r35, r37, r38, r40, r42, r43, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62);
        if (r116 == (-1)) goto L149;
        if (r0.isNull(r116) == false) goto L146;
        Integer r23 = null;
    L147:
        r22.setPoisonLabel(r23);
        goto L149
    L146:
        r23 = Integer.valueOf(r0.getInt(r116));
    L149:
        if (r117 == (-1)) goto L156;
        if (r0.isNull(r117) == false) goto L153;
        Integer r24 = null;
    L154:
        r22.setPoisonLabelVersion(r24);
        goto L156
    L153:
        r24 = Integer.valueOf(r0.getInt(r117));
    L156:
        if (r118 == (-1)) goto L163;
        if (r0.isNull(r118) == true) goto L161;
        r20 = r0.getString(r118);
    L161:
        r22.setContentHash(r20);
    L163:
        return new CallHistoryHistoryEntity(r32, r22);
    L138:
        if (r0.isNull(r115) == true) goto L136;
        r62 = r0.getString(r115);
        goto L141
    L132:
        if (r0.isNull(r114) == true) goto L129;
        r61 = r0.getString(r114);
        goto L135
    L125:
        if (r0.isNull(r113) == true) goto L122;
        r60 = r0.getString(r113);
        goto L128
    L118:
        if (r0.isNull(r112) == true) goto L115;
        r59 = r0.getString(r112);
        goto L121
    L111:
        if (r0.isNull(r111) == true) goto L108;
        r58 = r0.getString(r111);
        goto L114
    L104:
        if (r0.isNull(r110) == true) goto L101;
        r57 = r0.getString(r110);
        goto L107
    L97:
        if (r0.isNull(r19) == true) goto L94;
        r56 = r0.getString(r19);
        goto L100
    L90:
        if (r0.isNull(r18) == true) goto L87;
        r55 = r0.getString(r18);
        goto L93
    L84:
        if (r0.getInt(r17) == 0) goto L82;
        r21 = true;
        goto L82
    L77:
        if (r0.getInt(r16) == 0) goto L79;
        boolean r25 = true;
    L80:
        r53 = r25;
        goto L81
    L79:
        r25 = false;
        goto L80
    L69:
        if (r0.isNull(r63) == true) goto L67;
        r52 = r0.getString(r15);
        goto L73
    L65:
        r51 = r0.getInt(r14);
        goto L66
    L60:
        if (r0.isNull(r13) == true) goto L58;
        r50 = r0.getString(r13);
        goto L63
    L54:
        if (r0.isNull(r12) == true) goto L52;
        r49 = r0.getString(r12);
        goto L57
    L48:
        if (r0.isNull(r11) == true) goto L46;
        r48 = r0.getString(r11);
        goto L51
    L42:
        if (r0.isNull(r10) == true) goto L40;
        r47 = r0.getString(r10);
        goto L45
    L38:
        r46 = r0.getInt(r9);
        goto L39
    L33:
        if (r0.isNull(r8) == true) goto L31;
        r45 = r0.getString(r8);
        goto L36
    L25:
        r42 = r0.getInt(r6);
        goto L26
    L21:
        r40 = r0.getLong(r5);
        goto L22
    L18:
        r38 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r37 = r0.getString(r3);
        goto L16
    L8:
        r35 = r0.getLong(r2);
        goto L9
    L5:
        r32 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<CallHistoryHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfCallHistoryHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<CallHistoryHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfCallHistoryHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(CallHistoryHistoryEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfCallHistoryHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((CallHistoryHistoryEntity) ZeusTransformUtils.preCheckCast(r3, CallHistoryHistoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return CallHistoryHistoryEntityDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return CallHistoryHistoryEntityDao.DefaultImpls.deleteByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return CallHistoryHistoryEntityDao.DefaultImpls.deleteByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return CallHistoryHistoryEntityDao.DefaultImpls.deleteByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return CallHistoryHistoryEntityDao.DefaultImpls.deleteById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryHistoryEntityDao, com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return CallHistoryHistoryEntityDao.DefaultImpls.getPrefix(this);
    }

    @Override // com.obric.memorydata.database.dao.CallHistoryHistoryEntityDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return CallHistoryHistoryEntityDao.DefaultImpls.getTableName(this);
    }

    public long insert(CallHistoryHistoryEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfCallHistoryHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((CallHistoryHistoryEntity) ZeusTransformUtils.preCheckCast(r3, CallHistoryHistoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<CallHistoryHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfCallHistoryHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<CallHistoryHistoryEntity> queryAll() {
        return CallHistoryHistoryEntityDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return CallHistoryHistoryEntityDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<CallHistoryHistoryEntity> queryByEntityId(String r1, String r2) {
        return CallHistoryHistoryEntityDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<CallHistoryHistoryEntity> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return CallHistoryHistoryEntityDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public CallHistoryHistoryEntity queryById(long r1) {
        return CallHistoryHistoryEntityDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<CallHistoryHistoryEntity> queryByIds(List<Long> r3) {
        return CallHistoryHistoryEntityDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public CallHistoryHistoryEntity queryByUUID(String r1) {
        return CallHistoryHistoryEntityDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public CallHistoryHistoryEntity queryOne() {
        return CallHistoryHistoryEntityDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<CallHistoryHistoryEntity> queryWithLimitAndOffset(int r1, int r2) {
        return CallHistoryHistoryEntityDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<CallHistoryHistoryEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseDaoCallHistoryHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(CallHistoryHistoryEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfCallHistoryHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((CallHistoryHistoryEntity) ZeusTransformUtils.preCheckCast(r3, CallHistoryHistoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<CallHistoryHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfCallHistoryHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
