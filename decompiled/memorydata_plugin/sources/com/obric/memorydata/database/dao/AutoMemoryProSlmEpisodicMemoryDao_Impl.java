package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.AutoMemoryProSlmEpisodicMemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AutoMemoryProSlmEpisodicMemoryDao_Impl implements AutoMemoryProSlmEpisodicMemoryDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<AutoMemoryProSlmEpisodicMemoryEntity> __deletionAdapterOfAutoMemoryProSlmEpisodicMemoryEntity;
    private final EntityInsertionAdapter<AutoMemoryProSlmEpisodicMemoryEntity> __insertionAdapterOfAutoMemoryProSlmEpisodicMemoryEntity;
    private final EntityDeletionOrUpdateAdapter<AutoMemoryProSlmEpisodicMemoryEntity> __updateAdapterOfAutoMemoryProSlmEpisodicMemoryEntity;

    public AutoMemoryProSlmEpisodicMemoryDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfAutoMemoryProSlmEpisodicMemoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfAutoMemoryProSlmEpisodicMemoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfAutoMemoryProSlmEpisodicMemoryEntity = new AnonymousClass3(this, r2);
    }

    private AutoMemoryProSlmEpisodicMemoryEntity __entityCursorConverter_comObricMemorydataDatabaseEntityAutoMemoryProSlmEpisodicMemoryEntity(Cursor r35) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r35, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "data");
        int r3 = CursorUtil.getColumnIndex(r0, "targetRuleId");
        int r4 = CursorUtil.getColumnIndex(r0, "createTimestamp");
        int r5 = CursorUtil.getColumnIndex(r0, "userActionTimestamp");
        int r6 = CursorUtil.getColumnIndex(r0, "location");
        int r7 = CursorUtil.getColumnIndex(r0, "locationState");
        int r8 = CursorUtil.getColumnIndex(r0, "packageNames");
        int r9 = CursorUtil.getColumnIndex(r0, "retryCount");
        int r10 = CursorUtil.getColumnIndex(r0, "stepState");
        int r11 = CursorUtil.getColumnIndex(r0, "enableState");
        int r12 = CursorUtil.getColumnIndex(r0, "batch_id");
        long r13 = 0;
        if (r1 != (-1)) goto L5;
        long r19 = 0;
    L7:
        if (r2 != (-1)) goto L10;
    L8:
        String r21 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r22 = null;
    L19:
        if (r4 != (-1)) goto L21;
        long r23 = 0;
    L22:
        if (r5 == (-1)) goto L25;
        r13 = r0.getLong(r5);
    L25:
        long r25 = r13;
        if (r6 != (-1)) goto L29;
    L27:
        String r27 = null;
    L32:
        if (r7 != (-1)) goto L35;
    L33:
        String r28 = null;
    L38:
        if (r8 != (-1)) goto L41;
    L39:
        String r29 = null;
    L44:
        int r14 = 0;
        if (r9 != (-1)) goto L47;
        int r30 = 0;
    L48:
        if (r10 != (-1)) goto L50;
        int r31 = 0;
    L51:
        if (r11 == (-1)) goto L54;
        r14 = r0.getInt(r11);
    L54:
        int r32 = r14;
        if (r12 != (-1)) goto L58;
    L56:
        String r33 = null;
    L62:
        return new AutoMemoryProSlmEpisodicMemoryEntity(r19, r21, r22, r23, r25, r27, r28, r29, r30, r31, r32, r33);
    L58:
        if (r0.isNull(r12) == true) goto L56;
        r33 = r0.getString(r12);
        goto L62
    L50:
        r31 = r0.getInt(r10);
        goto L51
    L47:
        r30 = r0.getInt(r9);
        goto L48
    L41:
        if (r0.isNull(r8) == true) goto L39;
        r29 = r0.getString(r8);
        goto L44
    L35:
        if (r0.isNull(r7) == true) goto L33;
        r28 = r0.getString(r7);
        goto L38
    L29:
        if (r0.isNull(r6) == true) goto L27;
        r27 = r0.getString(r6);
        goto L32
    L21:
        r23 = r0.getLong(r4);
        goto L22
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r22 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r21 = r0.getString(r2);
        goto L13
    L5:
        r19 = r0.getLong(r1);
        goto L7
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<AutoMemoryProSlmEpisodicMemoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfAutoMemoryProSlmEpisodicMemoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<AutoMemoryProSlmEpisodicMemoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfAutoMemoryProSlmEpisodicMemoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(AutoMemoryProSlmEpisodicMemoryEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfAutoMemoryProSlmEpisodicMemoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(AutoMemoryProSlmEpisodicMemoryEntity r3) {
        return delete2((AutoMemoryProSlmEpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProSlmEpisodicMemoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return AutoMemoryProSlmEpisodicMemoryDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.AutoMemoryProSlmEpisodicMemoryDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return AutoMemoryProSlmEpisodicMemoryDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(AutoMemoryProSlmEpisodicMemoryEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfAutoMemoryProSlmEpisodicMemoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(AutoMemoryProSlmEpisodicMemoryEntity r3) {
        return insert2((AutoMemoryProSlmEpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProSlmEpisodicMemoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<AutoMemoryProSlmEpisodicMemoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfAutoMemoryProSlmEpisodicMemoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProSlmEpisodicMemoryEntity> queryAll() {
        return AutoMemoryProSlmEpisodicMemoryDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return AutoMemoryProSlmEpisodicMemoryDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProSlmEpisodicMemoryEntity queryById(long r1) {
        return AutoMemoryProSlmEpisodicMemoryDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AutoMemoryProSlmEpisodicMemoryEntity queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProSlmEpisodicMemoryEntity> queryByIds(List<Long> r3) {
        return AutoMemoryProSlmEpisodicMemoryDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProSlmEpisodicMemoryEntity queryByUUID(String r1) {
        return AutoMemoryProSlmEpisodicMemoryDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AutoMemoryProSlmEpisodicMemoryEntity queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public AutoMemoryProSlmEpisodicMemoryEntity queryOne() {
        return AutoMemoryProSlmEpisodicMemoryDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ AutoMemoryProSlmEpisodicMemoryEntity queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProSlmEpisodicMemoryEntity> queryWithLimitAndOffset(int r1, int r2) {
        return AutoMemoryProSlmEpisodicMemoryDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<AutoMemoryProSlmEpisodicMemoryEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityAutoMemoryProSlmEpisodicMemoryEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(AutoMemoryProSlmEpisodicMemoryEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfAutoMemoryProSlmEpisodicMemoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(AutoMemoryProSlmEpisodicMemoryEntity r3) {
        return update2((AutoMemoryProSlmEpisodicMemoryEntity) ZeusTransformUtils.preCheckCast(r3, AutoMemoryProSlmEpisodicMemoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<AutoMemoryProSlmEpisodicMemoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfAutoMemoryProSlmEpisodicMemoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
