package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.AssistantChatEntity;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.ak;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AssistantChatDao_Impl implements AssistantChatDao {
    private final ak __chatMessageListConverter;
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<AssistantChatEntity> __deletionAdapterOfAssistantChatEntity;
    private final EntityInsertionAdapter<AssistantChatEntity> __insertionAdapterOfAssistantChatEntity;
    private final EntityInsertionAdapter<AssistantChatEntity> __insertionAdapterOfAssistantChatEntity_1;
    private final EntityDeletionOrUpdateAdapter<AssistantChatEntity> __updateAdapterOfAssistantChatEntity;

    public AssistantChatDao_Impl(final RoomDatabase r2) {
        this.__chatMessageListConverter = new ak();
        this.__db = r2;
        this.__insertionAdapterOfAssistantChatEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfAssistantChatEntity_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfAssistantChatEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfAssistantChatEntity = new AnonymousClass4(this, r2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private AssistantChatEntity __entityCursorConverter_comObricMemorydataDatabaseEntityAssistantChatEntity(Cursor r21) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r21, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "logId");
        int r3 = CursorUtil.getColumnIndex(r0, "messages");
        int r4 = CursorUtil.getColumnIndex(r0, "createdAt");
        int r5 = CursorUtil.getColumnIndex(r0, "updatedAt");
        long r6 = 0;
        if (r1 != (-1)) goto L5;
        long r12 = 0;
    L6:
        List<ChatMessage> r7 = null;
        String r8 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r14 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        List<ChatMessage> r15 = r7;
        if (r4 != (-1)) goto L22;
        long r16 = 0;
    L23:
        if (r5 == (-1)) goto L27;
        r6 = r0.getLong(r5);
    L27:
        return new AssistantChatEntity(r12, r14, r15, r16, r6);
    L22:
        r16 = r0.getLong(r4);
        goto L23
    L16:
        if (r0.isNull(r3) == true) goto L19;
        r8 = r0.getString(r3);
    L19:
        r7 = this.__chatMessageListConverter.a(r8);
        goto L14
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r14 = r0.getString(r2);
        goto L13
    L5:
        r12 = r0.getLong(r1);
        goto L6
    }

    static /* synthetic */ ak access$000(AssistantChatDao_Impl r0) {
        return r0.__chatMessageListConverter;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<AssistantChatEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAssistantChatEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<AssistantChatEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAssistantChatEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(AssistantChatEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAssistantChatEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(AssistantChatEntity r3) {
        return delete2((AssistantChatEntity) ZeusTransformUtils.preCheckCast(r3, AssistantChatEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return AssistantChatDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.AssistantChatDao
    public List<AssistantChatEntity> getAll() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM AssistantChatEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r3 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, "logId");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "messages");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "createdAt");     // Catch: Throwable -> L18
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "updatedAt");     // Catch: Throwable -> L18
        ArrayList r9 = new ArrayList(r2.getCount());     // Catch: Throwable -> L18
    L4:
        if (r2.moveToNext() == false) goto L16;
        long r12 = r2.getLong(r3);     // Catch: Throwable -> L18
        if (r2.isNull(r5) == false) goto L9;
        String r14 = null;
    L11:
        if (r2.isNull(r6) == false) goto L13;
        String r10 = null;
    L14:
        r9.add(new AssistantChatEntity(r12, r14, this.__chatMessageListConverter.a(r10), r2.getLong(r7), r2.getLong(r8)));     // Catch: Throwable -> L18
        goto L4
    L13:
        r10 = r2.getString(r6);     // Catch: Throwable -> L18
        goto L14
    L9:
        r14 = r2.getString(r5);     // Catch: Throwable -> L18
        goto L11
    L16:
        r2.close();
        r1.release();
        return r9;
    L18:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AssistantChatDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return AssistantChatDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(AssistantChatEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAssistantChatEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(AssistantChatEntity r3) {
        return insert2((AssistantChatEntity) ZeusTransformUtils.preCheckCast(r3, AssistantChatEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<AssistantChatEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAssistantChatEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.AssistantChatDao
    public void insertSingle(AssistantChatEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAssistantChatEntity_1.insert(r2);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AssistantChatEntity> queryAll() {
        return AssistantChatDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return AssistantChatDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AssistantChatEntity queryById(long r1) {
        return AssistantChatDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AssistantChatEntity queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AssistantChatEntity> queryByIds(List<Long> r3) {
        return AssistantChatDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AssistantChatEntity queryByUUID(String r1) {
        return AssistantChatDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AssistantChatEntity queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AssistantChatEntity queryOne() {
        return AssistantChatDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AssistantChatEntity queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AssistantChatEntity> queryWithLimitAndOffset(int r1, int r2) {
        return AssistantChatDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AssistantChatEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityAssistantChatEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(AssistantChatEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAssistantChatEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(AssistantChatEntity r3) {
        return update2((AssistantChatEntity) ZeusTransformUtils.preCheckCast(r3, AssistantChatEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<AssistantChatEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAssistantChatEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
