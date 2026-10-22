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
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.database.b.a;
import com.obric.memorydata.database.entity.jc;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UserKeywordDao_Impl implements UserKeywordDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<jc> __deletionAdapterOfUserKeywordEntity;
    private final EntityInsertionAdapter<jc> __insertionAdapterOfUserKeywordEntity;
    private final EntityInsertionAdapter<jc> __insertionAdapterOfUserKeywordEntity_1;
    private final a __intListConverter;
    private final EntityDeletionOrUpdateAdapter<jc> __updateAdapterOfUserKeywordEntity;

    public UserKeywordDao_Impl(final RoomDatabase r2) {
        this.__intListConverter = new a();
        this.__db = r2;
        this.__insertionAdapterOfUserKeywordEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfUserKeywordEntity_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfUserKeywordEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfUserKeywordEntity = new AnonymousClass4(this, r2);
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
    private jc __entityCursorConverter_comObricMemorydataDatabaseEntityUserKeywordEntity(Cursor r25) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r25, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, ActivityLifecycle.NAME);
        int r3 = CursorUtil.getColumnIndex(r0, "summary");
        int r4 = CursorUtil.getColumnIndex(r0, "sources");
        int r5 = CursorUtil.getColumnIndex(r0, "user_edit");
        int r6 = CursorUtil.getColumnIndex(r0, "create_time");
        int r7 = CursorUtil.getColumnIndex(r0, "update_time");
        long r8 = 0;
        if (r1 != (-1)) goto L5;
        long r14 = 0;
    L6:
        List<Integer> r9 = null;
        String r10 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r16 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r17 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        List<Integer> r18 = r9;
        boolean r11 = false;
        if (r5 != (-1)) goto L30;
    L28:
        boolean r19 = r11;
        if (r6 != (-1)) goto L34;
        long r20 = 0;
    L35:
        if (r7 == (-1)) goto L39;
        r8 = r0.getLong(r7);
    L39:
        return new jc(r14, r16, r17, r18, r19, r20, r8);
    L34:
        r20 = r0.getLong(r6);
        goto L35
    L30:
        if (r0.getInt(r5) == 0) goto L28;
        r11 = true;
        goto L28
    L22:
        if (r0.isNull(r4) == true) goto L25;
        r10 = r0.getString(r4);
    L25:
        r9 = this.__intListConverter.a(r10);
        goto L20
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r17 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r16 = r0.getString(r2);
        goto L13
    L5:
        r14 = r0.getLong(r1);
        goto L6
    }

    static /* synthetic */ a access$000(UserKeywordDao_Impl r0) {
        return r0.__intListConverter;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<jc> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfUserKeywordEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<jc> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfUserKeywordEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(jc r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfUserKeywordEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(jc r3) {
        return delete2((jc) ZeusTransformUtils.preCheckCast(r3, jc.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return UserKeywordDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.UserKeywordDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return UserKeywordDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(jc r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUserKeywordEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(jc r3) {
        return insert2((jc) ZeusTransformUtils.preCheckCast(r3, jc.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<jc> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfUserKeywordEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.UserKeywordDao
    public long insertIfAbsent(jc r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUserKeywordEntity_1.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<jc> queryAll() {
        return UserKeywordDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return UserKeywordDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public jc queryById(long r1) {
        return UserKeywordDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ jc queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<jc> queryByIds(List<Long> r3) {
        return UserKeywordDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
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
    @Override // com.obric.memorydata.database.dao.UserKeywordDao
    public jc queryByName(String r26) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM UserKeyword WHERE name COLLATE NOCASE = ? ORDER BY update_time DESC LIMIT 1", 1);
        if (r26 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        jc r5 = null;
        String r6 = null;
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L28
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, ActivityLifecycle.NAME);     // Catch: Throwable -> L28
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "summary");     // Catch: Throwable -> L28
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "sources");     // Catch: Throwable -> L28
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "user_edit");     // Catch: Throwable -> L28
        int r12 = CursorUtil.getColumnIndexOrThrow(r1, "create_time");     // Catch: Throwable -> L28
        int r13 = CursorUtil.getColumnIndexOrThrow(r1, "update_time");     // Catch: Throwable -> L28
        if (r1.moveToFirst() == false) goto L26;
        long r15 = r1.getLong(r7);     // Catch: Throwable -> L28
        if (r1.isNull(r8) == false) goto L12;
        String r17 = null;
    L14:
        if (r1.isNull(r9) == false) goto L16;
        String r18 = null;
    L18:
        if (r1.isNull(r10) == true) goto L21;
        r6 = r1.getString(r10);     // Catch: Throwable -> L28
    L21:
        List<Integer> r19 = this.__intListConverter.a(r6);     // Catch: Throwable -> L28
        if (r1.getInt(r11) == 0) goto L24;
        boolean r20 = true;
    L25:
        r5 = new jc(r15, r17, r18, r19, r20, r1.getLong(r12), r1.getLong(r13));     // Catch: Throwable -> L28
        goto L26
    L24:
        r20 = false;
        goto L25
    L16:
        r18 = r1.getString(r9);     // Catch: Throwable -> L28
        goto L18
    L12:
        r17 = r1.getString(r8);     // Catch: Throwable -> L28
    L26:
        r1.close();
        r2.release();
        return r5;
    L28:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r26);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public jc queryByUUID(String r1) {
        return UserKeywordDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ jc queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public jc queryOne() {
        return UserKeywordDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ jc queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.UserKeywordDao
    public List<jc> queryRecent(int r27) {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM UserKeyword ORDER BY update_time DESC LIMIT ?", 1);
        r1.bindLong(1, r27);
        this.__db.assertNotSuspendingTransaction();
        Cursor r3 = DBUtil.query(this.__db, r1, false, null);
        int r6 = CursorUtil.getColumnIndexOrThrow(r3, OaidModel.KEY_ID);     // Catch: Throwable -> L26
        int r7 = CursorUtil.getColumnIndexOrThrow(r3, ActivityLifecycle.NAME);     // Catch: Throwable -> L26
        int r8 = CursorUtil.getColumnIndexOrThrow(r3, "summary");     // Catch: Throwable -> L26
        int r9 = CursorUtil.getColumnIndexOrThrow(r3, "sources");     // Catch: Throwable -> L26
        int r10 = CursorUtil.getColumnIndexOrThrow(r3, "user_edit");     // Catch: Throwable -> L26
        int r11 = CursorUtil.getColumnIndexOrThrow(r3, "create_time");     // Catch: Throwable -> L26
        int r12 = CursorUtil.getColumnIndexOrThrow(r3, "update_time");     // Catch: Throwable -> L26
        ArrayList r13 = new ArrayList(r3.getCount());     // Catch: Throwable -> L26
    L4:
        if (r3.moveToNext() == false) goto L24;
        long r16 = r3.getLong(r6);     // Catch: Throwable -> L26
        if (r3.isNull(r7) == false) goto L9;
        String r18 = null;
    L11:
        if (r3.isNull(r8) == false) goto L13;
        String r19 = null;
    L15:
        if (r3.isNull(r9) == false) goto L17;
        String r14 = null;
    L18:
        List<Integer> r20 = this.__intListConverter.a(r14);     // Catch: Throwable -> L26
        if (r3.getInt(r10) == 0) goto L21;
        boolean r21 = true;
    L22:
        r13.add(new jc(r16, r18, r19, r20, r21, r3.getLong(r11), r3.getLong(r12)));     // Catch: Throwable -> L26
        goto L4
    L21:
        r21 = false;
        goto L22
    L17:
        r14 = r3.getString(r9);     // Catch: Throwable -> L26
        goto L18
    L13:
        r19 = r3.getString(r8);     // Catch: Throwable -> L26
        goto L15
    L9:
        r18 = r3.getString(r7);     // Catch: Throwable -> L26
        goto L11
    L24:
        r3.close();
        r1.release();
        return r13;
    L26:
        th = move-exception;
        r3.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.UserKeywordDao
    public List<String> queryWithLimitAndDesc(int r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT name FROM UserKeyword ORDER BY update_time DESC LIMIT ?", 1);
        r0.bindLong(1, r5);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r2 = new ArrayList(r4.getCount());     // Catch: Throwable -> L14
    L4:
        if (r4.moveToNext() == false) goto L12;
        if (r4.isNull(0) == false) goto L9;
        String r3 = null;
    L10:
        r2.add(r3);     // Catch: Throwable -> L14
        goto L4
    L9:
        r3 = r4.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r4.close();
        r0.release();
        return r2;
    L14:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<jc> queryWithLimitAndOffset(int r1, int r2) {
        return UserKeywordDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<jc> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityUserKeywordEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(jc r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfUserKeywordEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(jc r3) {
        return update2((jc) ZeusTransformUtils.preCheckCast(r3, jc.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<jc> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfUserKeywordEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
