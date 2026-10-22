package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.database.entity.MemoryBaseSceneEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryBaseSceneDao_Impl implements MemoryBaseSceneDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<MemoryBaseSceneEntity> __deletionAdapterOfMemoryBaseSceneEntity;
    private final EntityInsertionAdapter<MemoryBaseSceneEntity> __insertionAdapterOfMemoryBaseSceneEntity;
    private final EntityDeletionOrUpdateAdapter<MemoryBaseSceneEntity> __updateAdapterOfMemoryBaseSceneEntity;

    public MemoryBaseSceneDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryBaseSceneEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfMemoryBaseSceneEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfMemoryBaseSceneEntity = new AnonymousClass3(this, r2);
    }

    private MemoryBaseSceneEntity __entityCursorConverter_comObricMemorydataDatabaseEntityMemoryBaseSceneEntity(Cursor r27) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r27, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "sceneId");
        int r2 = CursorUtil.getColumnIndex(r0, ActivityLifecycle.NAME);
        int r3 = CursorUtil.getColumnIndex(r0, "description");
        int r4 = CursorUtil.getColumnIndex(r0, Params.CONTENT);
        int r5 = CursorUtil.getColumnIndex(r0, "sourceType");
        int r6 = CursorUtil.getColumnIndex(r0, "isUserDefined");
        int r7 = CursorUtil.getColumnIndex(r0, "status");
        int r8 = CursorUtil.getColumnIndex(r0, "requirementIds");
        int r9 = CursorUtil.getColumnIndex(r0, "createTime");
        int r10 = CursorUtil.getColumnIndex(r0, "updateTime");
        String r12 = null;
        if (r1 != (-1)) goto L6;
    L4:
        String r14 = null;
    L9:
        if (r2 != (-1)) goto L12;
    L10:
        String r15 = null;
    L15:
        if (r3 != (-1)) goto L18;
    L16:
        String r16 = null;
    L21:
        if (r4 != (-1)) goto L24;
    L22:
        String r17 = null;
    L27:
        if (r5 != (-1)) goto L30;
    L28:
        String r18 = null;
    L33:
        if (r6 != (-1)) goto L35;
        int r11 = 0;
    L36:
        int r19 = r11;
        if (r7 != (-1)) goto L40;
    L38:
        String r20 = null;
    L43:
        if (r8 != (-1)) goto L46;
    L44:
        String r21 = r12;
        if (r9 != (-1)) goto L52;
        long r22 = 0;
    L53:
        if (r10 != (-1)) goto L55;
        long r24 = 0;
    L57:
        return new MemoryBaseSceneEntity(r14, r15, r16, r17, r18, r19, r20, r21, r22, r24);
    L55:
        r24 = r0.getLong(r10);
        goto L57
    L52:
        r22 = r0.getLong(r9);
        goto L53
    L46:
        if (r0.isNull(r8) == true) goto L44;
        r12 = r0.getString(r8);
        goto L44
    L40:
        if (r0.isNull(r7) == true) goto L38;
        r20 = r0.getString(r7);
        goto L43
    L35:
        r11 = r0.getInt(r6);
        goto L36
    L30:
        if (r0.isNull(r5) == true) goto L28;
        r18 = r0.getString(r5);
        goto L33
    L24:
        if (r0.isNull(r4) == true) goto L22;
        r17 = r0.getString(r4);
        goto L27
    L18:
        if (r0.isNull(r3) == true) goto L16;
        r16 = r0.getString(r3);
        goto L21
    L12:
        if (r0.isNull(r2) == true) goto L10;
        r15 = r0.getString(r2);
        goto L15
    L6:
        if (r0.isNull(r1) == true) goto L4;
        r14 = r0.getString(r1);
        goto L9
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<MemoryBaseSceneEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMemoryBaseSceneEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<MemoryBaseSceneEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMemoryBaseSceneEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(MemoryBaseSceneEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMemoryBaseSceneEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(MemoryBaseSceneEntity r3) {
        return delete2((MemoryBaseSceneEntity) ZeusTransformUtils.preCheckCast(r3, MemoryBaseSceneEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return MemoryBaseSceneDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.MemoryBaseSceneDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MemoryBaseSceneDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(MemoryBaseSceneEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryBaseSceneEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(MemoryBaseSceneEntity r3) {
        return insert2((MemoryBaseSceneEntity) ZeusTransformUtils.preCheckCast(r3, MemoryBaseSceneEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<MemoryBaseSceneEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryBaseSceneEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryBaseSceneEntity> queryAll() {
        return MemoryBaseSceneDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MemoryBaseSceneDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryBaseSceneEntity queryById(long r1) {
        return MemoryBaseSceneDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryBaseSceneEntity queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryBaseSceneEntity> queryByIds(List<Long> r3) {
        return MemoryBaseSceneDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryBaseSceneEntity queryByUUID(String r1) {
        return MemoryBaseSceneDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryBaseSceneEntity queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public MemoryBaseSceneEntity queryOne() {
        return MemoryBaseSceneDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ MemoryBaseSceneEntity queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryBaseSceneEntity> queryWithLimitAndOffset(int r1, int r2) {
        return MemoryBaseSceneDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryBaseSceneEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityMemoryBaseSceneEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(MemoryBaseSceneEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMemoryBaseSceneEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(MemoryBaseSceneEntity r3) {
        return update2((MemoryBaseSceneEntity) ZeusTransformUtils.preCheckCast(r3, MemoryBaseSceneEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<MemoryBaseSceneEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMemoryBaseSceneEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
