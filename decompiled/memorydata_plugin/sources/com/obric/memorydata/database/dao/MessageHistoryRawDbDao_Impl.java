package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.go;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MessageHistoryRawDbDao_Impl implements MessageHistoryRawDbDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<MessageHistoryEntity> __deletionAdapterOfMessageHistoryEntity;
    private final EntityInsertionAdapter<MessageHistoryEntity> __insertionAdapterOfMessageHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<MessageHistoryEntity> __updateAdapterOfMessageHistoryEntity;

    public MessageHistoryRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMessageHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfMessageHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfMessageHistoryEntity = new AnonymousClass3(this, r2);
    }

    private MessageHistoryEntity __entityCursorConverter_comObricMemorydataDatabaseDaoMessageHistoryEntity(Cursor r54) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r54, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "message_id");
        int r3 = CursorUtil.getColumnIndex(r0, "message_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "message_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "message_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "message_type");
        int r7 = CursorUtil.getColumnIndex(r0, "message_timestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "message_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "message_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "message_uuid");
        int r11 = CursorUtil.getColumnIndex(r0, "message_telephones");
        int r12 = CursorUtil.getColumnIndex(r0, "message_text");
        int r13 = CursorUtil.getColumnIndex(r0, "message_contentWithTime");
        int r14 = CursorUtil.getColumnIndex(r0, "message_textConversion");
        int r15 = CursorUtil.getColumnIndex(r0, "message_files");
        int r16 = CursorUtil.getColumnIndex(r0, "message_contactIds");
        int r17 = CursorUtil.getColumnIndex(r0, "message_messageType");
        int r18 = CursorUtil.getColumnIndex(r0, "message_messageStatusType");
        int r19 = CursorUtil.getColumnIndex(r0, "message_fullContent");
        int r110 = CursorUtil.getColumnIndex(r0, "message_telephoneStandardMap");
        int r111 = CursorUtil.getColumnIndex(r0, "message_poison_label");
        int r112 = CursorUtil.getColumnIndex(r0, "message_poison_label_version");
        int r113 = CursorUtil.getColumnIndex(r0, "message_content_hash");
        long r22 = 0;
        if (r1 != (-1)) goto L5;
        long r27 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r30 = 0;
    L9:
        String r20 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r32 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r33 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r35 = 0;
    L22:
        int r21 = 0;
        if (r6 != (-1)) goto L25;
        int r37 = 0;
    L26:
        if (r7 == (-1)) goto L29;
        r22 = r0.getLong(r7);
    L29:
        long r38 = r22;
        if (r8 != (-1)) goto L33;
    L31:
        String r40 = null;
    L36:
        if (r9 == (-1)) goto L39;
        r21 = r0.getInt(r9);
    L39:
        int r41 = r21;
        if (r10 != (-1)) goto L43;
    L41:
        String r42 = null;
    L46:
        if (r11 != (-1)) goto L49;
    L47:
        String r43 = null;
    L52:
        if (r12 != (-1)) goto L55;
    L53:
        String r44 = null;
    L58:
        if (r13 != (-1)) goto L61;
    L59:
        String r45 = null;
    L64:
        if (r14 != (-1)) goto L67;
    L65:
        String r46 = null;
    L70:
        if (r53 != (-1)) goto L73;
    L71:
        String r47 = null;
    L76:
        if (r54 != (-1)) goto L80;
    L77:
        String r48 = null;
    L83:
        if (r17 != (-1)) goto L87;
    L84:
        String r49 = null;
    L90:
        if (r18 != (-1)) goto L94;
    L91:
        String r50 = null;
    L97:
        if (r19 != (-1)) goto L101;
    L98:
        String r51 = null;
    L104:
        if (r110 != (-1)) goto L107;
    L105:
        String r52 = null;
    L110:
        go r23 = new go(r30, r32, r33, r35, r37, r38, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52);
        if (r111 == (-1)) goto L118;
        if (r0.isNull(r111) == false) goto L115;
        Integer r24 = null;
    L116:
        r23.setPoisonLabel(r24);
        goto L118
    L115:
        r24 = Integer.valueOf(r0.getInt(r111));
    L118:
        if (r112 == (-1)) goto L125;
        if (r0.isNull(r112) == false) goto L122;
        Integer r25 = null;
    L123:
        r23.setPoisonLabelVersion(r25);
        goto L125
    L122:
        r25 = Integer.valueOf(r0.getInt(r112));
    L125:
        if (r113 == (-1)) goto L132;
        if (r0.isNull(r113) == true) goto L130;
        r20 = r0.getString(r113);
    L130:
        r23.setContentHash(r20);
    L132:
        return new MessageHistoryEntity(r27, r23);
    L107:
        if (r0.isNull(r110) == true) goto L105;
        r52 = r0.getString(r110);
        goto L110
    L101:
        if (r0.isNull(r19) == true) goto L98;
        r51 = r0.getString(r19);
        goto L104
    L94:
        if (r0.isNull(r18) == true) goto L91;
        r50 = r0.getString(r18);
        goto L97
    L87:
        if (r0.isNull(r17) == true) goto L84;
        r49 = r0.getString(r17);
        goto L90
    L80:
        if (r0.isNull(r54) == true) goto L77;
        r48 = r0.getString(r16);
        goto L83
    L73:
        if (r0.isNull(r53) == true) goto L71;
        r47 = r0.getString(r15);
        goto L76
    L67:
        if (r0.isNull(r14) == true) goto L65;
        r46 = r0.getString(r14);
        goto L70
    L61:
        if (r0.isNull(r13) == true) goto L59;
        r45 = r0.getString(r13);
        goto L64
    L55:
        if (r0.isNull(r12) == true) goto L53;
        r44 = r0.getString(r12);
        goto L58
    L49:
        if (r0.isNull(r11) == true) goto L47;
        r43 = r0.getString(r11);
        goto L52
    L43:
        if (r0.isNull(r10) == true) goto L41;
        r42 = r0.getString(r10);
        goto L46
    L33:
        if (r0.isNull(r8) == true) goto L31;
        r40 = r0.getString(r8);
        goto L36
    L25:
        r37 = r0.getInt(r6);
        goto L26
    L21:
        r35 = r0.getLong(r5);
        goto L22
    L18:
        r33 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r32 = r0.getString(r3);
        goto L16
    L8:
        r30 = r0.getLong(r2);
        goto L9
    L5:
        r27 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<MessageHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMessageHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<MessageHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMessageHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(MessageHistoryEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMessageHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((MessageHistoryEntity) ZeusTransformUtils.preCheckCast(r3, MessageHistoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return MessageHistoryRawDbDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return MessageHistoryRawDbDao.DefaultImpls.deleteByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return MessageHistoryRawDbDao.DefaultImpls.deleteByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return MessageHistoryRawDbDao.DefaultImpls.deleteByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return MessageHistoryRawDbDao.DefaultImpls.deleteById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.MessageHistoryRawDbDao, com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return MessageHistoryRawDbDao.DefaultImpls.getPrefix(this);
    }

    @Override // com.obric.memorydata.database.dao.MessageHistoryRawDbDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MessageHistoryRawDbDao.DefaultImpls.getTableName(this);
    }

    public long insert(MessageHistoryEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMessageHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((MessageHistoryEntity) ZeusTransformUtils.preCheckCast(r3, MessageHistoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<MessageHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMessageHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MessageHistoryEntity> queryAll() {
        return MessageHistoryRawDbDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MessageHistoryRawDbDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<MessageHistoryEntity> queryByEntityId(String r1, String r2) {
        return MessageHistoryRawDbDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<MessageHistoryEntity> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return MessageHistoryRawDbDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public MessageHistoryEntity queryById(long r1) {
        return MessageHistoryRawDbDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MessageHistoryEntity> queryByIds(List<Long> r3) {
        return MessageHistoryRawDbDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public MessageHistoryEntity queryByUUID(String r1) {
        return MessageHistoryRawDbDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public MessageHistoryEntity queryOne() {
        return MessageHistoryRawDbDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MessageHistoryEntity> queryWithLimitAndOffset(int r1, int r2) {
        return MessageHistoryRawDbDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MessageHistoryEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseDaoMessageHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(MessageHistoryEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMessageHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((MessageHistoryEntity) ZeusTransformUtils.preCheckCast(r3, MessageHistoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<MessageHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMessageHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
