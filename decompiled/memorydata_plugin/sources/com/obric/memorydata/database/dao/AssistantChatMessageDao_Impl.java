package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.AssistantChatContent;
import com.obric.memorydata.database.entity.AssistantChatMessageEntity;
import com.obric.memorydata.database.entity.p;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AssistantChatMessageDao_Impl implements AssistantChatMessageDao {
    private final p __assistantChatContentListConverter;
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<AssistantChatMessageEntity> __deletionAdapterOfAssistantChatMessageEntity;
    private final EntityInsertionAdapter<AssistantChatMessageEntity> __insertionAdapterOfAssistantChatMessageEntity;
    private final EntityInsertionAdapter<AssistantChatMessageEntity> __insertionAdapterOfAssistantChatMessageEntity_1;
    private final EntityDeletionOrUpdateAdapter<AssistantChatMessageEntity> __updateAdapterOfAssistantChatMessageEntity;

    public AssistantChatMessageDao_Impl(final RoomDatabase r2) {
        this.__assistantChatContentListConverter = new p();
        this.__db = r2;
        this.__insertionAdapterOfAssistantChatMessageEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfAssistantChatMessageEntity_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfAssistantChatMessageEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfAssistantChatMessageEntity = new AnonymousClass4(this, r2);
    }

    private AssistantChatMessageEntity __entityCursorConverter_comObricMemorydataDatabaseEntityAssistantChatMessageEntity(Cursor r31) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r31, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "messageId");
        int r3 = CursorUtil.getColumnIndex(r0, "replyId");
        int r4 = CursorUtil.getColumnIndex(r0, "collectionId");
        int r5 = CursorUtil.getColumnIndex(r0, "createTime");
        int r6 = CursorUtil.getColumnIndex(r0, "timestamp");
        int r7 = CursorUtil.getColumnIndex(r0, "type");
        int r8 = CursorUtil.getColumnIndex(r0, "omniId");
        int r9 = CursorUtil.getColumnIndex(r0, "omniState");
        int r10 = CursorUtil.getColumnIndex(r0, Params.CONTENT);
        long r11 = 0;
        if (r1 != (-1)) goto L5;
        long r17 = 0;
    L6:
        String r12 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r19 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r20 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r21 = null;
    L25:
        if (r5 != (-1)) goto L27;
        long r22 = 0;
    L28:
        if (r6 == (-1)) goto L31;
        r11 = r0.getLong(r6);
    L31:
        long r24 = r11;
        if (r7 != (-1)) goto L35;
    L33:
        String r26 = null;
    L38:
        if (r8 != (-1)) goto L41;
    L39:
        String r27 = null;
    L44:
        if (r9 != (-1)) goto L47;
    L45:
        String r28 = null;
    L50:
        if (r10 != (-1)) goto L53;
        List<AssistantChatContent> r29 = null;
    L58:
        return new AssistantChatMessageEntity(r17, r19, r20, r21, r22, r24, r26, r27, r28, r29);
    L53:
        if (r0.isNull(r10) == true) goto L56;
        r12 = r0.getString(r10);
    L56:
        r29 = this.__assistantChatContentListConverter.a(r12);
        goto L58
    L47:
        if (r0.isNull(r9) == true) goto L45;
        r28 = r0.getString(r9);
        goto L50
    L41:
        if (r0.isNull(r8) == true) goto L39;
        r27 = r0.getString(r8);
        goto L44
    L35:
        if (r0.isNull(r7) == true) goto L33;
        r26 = r0.getString(r7);
        goto L38
    L27:
        r22 = r0.getLong(r5);
        goto L28
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r21 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r20 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r19 = r0.getString(r2);
        goto L13
    L5:
        r17 = r0.getLong(r1);
        goto L6
    }

    static /* synthetic */ p access$000(AssistantChatMessageDao_Impl r0) {
        return r0.__assistantChatContentListConverter;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<AssistantChatMessageEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAssistantChatMessageEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<AssistantChatMessageEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAssistantChatMessageEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(AssistantChatMessageEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAssistantChatMessageEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(AssistantChatMessageEntity r3) {
        return delete2((AssistantChatMessageEntity) ZeusTransformUtils.preCheckCast(r3, AssistantChatMessageEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return AssistantChatMessageDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.AssistantChatMessageDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return AssistantChatMessageDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(AssistantChatMessageEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAssistantChatMessageEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(AssistantChatMessageEntity r3) {
        return insert2((AssistantChatMessageEntity) ZeusTransformUtils.preCheckCast(r3, AssistantChatMessageEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<AssistantChatMessageEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAssistantChatMessageEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AssistantChatMessageDao
    public long insertIgnore(AssistantChatMessageEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAssistantChatMessageEntity_1.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AssistantChatMessageEntity> queryAll() {
        return AssistantChatMessageDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return AssistantChatMessageDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AssistantChatMessageEntity queryById(long r1) {
        return AssistantChatMessageDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AssistantChatMessageEntity queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AssistantChatMessageEntity> queryByIds(List<Long> r3) {
        return AssistantChatMessageDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AssistantChatMessageEntity queryByUUID(String r1) {
        return AssistantChatMessageDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AssistantChatMessageEntity queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AssistantChatMessageEntity queryOne() {
        return AssistantChatMessageDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AssistantChatMessageEntity queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AssistantChatMessageEntity> queryWithLimitAndOffset(int r1, int r2) {
        return AssistantChatMessageDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AssistantChatMessageEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityAssistantChatMessageEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(AssistantChatMessageEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAssistantChatMessageEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(AssistantChatMessageEntity r3) {
        return update2((AssistantChatMessageEntity) ZeusTransformUtils.preCheckCast(r3, AssistantChatMessageEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<AssistantChatMessageEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAssistantChatMessageEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
