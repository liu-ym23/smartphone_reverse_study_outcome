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
import com.obric.memorydata.database.entity.by;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class GlassesEpisodicRelevantDataDao_Impl implements GlassesEpisodicRelevantDataDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<by> __deletionAdapterOfGlassesEpisodicRelevantData;
    private final EntityInsertionAdapter<by> __insertionAdapterOfGlassesEpisodicRelevantData;
    private final EntityInsertionAdapter<by> __insertionAdapterOfGlassesEpisodicRelevantData_1;
    private final EntityDeletionOrUpdateAdapter<by> __updateAdapterOfGlassesEpisodicRelevantData;

    public GlassesEpisodicRelevantDataDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfGlassesEpisodicRelevantData = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfGlassesEpisodicRelevantData_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfGlassesEpisodicRelevantData = new AnonymousClass3(this, r2);
        this.__updateAdapterOfGlassesEpisodicRelevantData = new AnonymousClass4(this, r2);
    }

    private by __entityCursorConverter_comObricMemorydataDatabaseEntityGlassesEpisodicRelevantData(Cursor r7) {
        Cursor r6 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r7, Cursor.class, "com.obric.memorydata.plugin");
        int r8 = CursorUtil.getColumnIndex(r6, OaidModel.KEY_ID);
        int r0 = CursorUtil.getColumnIndex(r6, "episodic_id");
        int r1 = CursorUtil.getColumnIndex(r6, "speaker_summary");
        if (r8 != (-1)) goto L5;
        long r3 = 0;
    L6:
        String r9 = null;
        if (r0 != (-1)) goto L10;
    L8:
        String r2 = null;
    L13:
        if (r1 == (-1)) goto L20;
        if (r6.isNull(r1) == true) goto L20;
        r9 = r6.getString(r1);
    L20:
        return new by(r3, r2, r9);
    L10:
        if (r6.isNull(r0) == true) goto L8;
        r2 = r6.getString(r0);
        goto L13
    L5:
        r3 = r6.getLong(r8);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<by> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfGlassesEpisodicRelevantData.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<by> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfGlassesEpisodicRelevantData_1.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(by r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfGlassesEpisodicRelevantData.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(by r3) {
        return delete2((by) ZeusTransformUtils.preCheckCast(r3, by.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return GlassesEpisodicRelevantDataDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.GlassesEpisodicRelevantDataDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return GlassesEpisodicRelevantDataDao.DefaultImpls.getTableName(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.GlassesEpisodicRelevantDataDao
    public long insert(by r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfGlassesEpisodicRelevantData.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(by r3) {
        return insert((by) ZeusTransformUtils.preCheckCast(r3, by.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<by> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfGlassesEpisodicRelevantData_1.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<by> queryAll() {
        return GlassesEpisodicRelevantDataDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return GlassesEpisodicRelevantDataDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.GlassesEpisodicRelevantDataDao
    public by queryByEpisodicId(String r7) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM GlassesEpisodicRelevantData WHERE episodic_id = ? LIMIT 1", 1);
        if (r7 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        by r1 = null;
        String r2 = null;
        Cursor r6 = DBUtil.query(this.__db, r0, false, null);
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, OaidModel.KEY_ID);     // Catch: Throwable -> L21
        int r3 = CursorUtil.getColumnIndexOrThrow(r6, "episodic_id");     // Catch: Throwable -> L21
        int r4 = CursorUtil.getColumnIndexOrThrow(r6, "speaker_summary");     // Catch: Throwable -> L21
        if (r6.moveToFirst() == false) goto L19;
        long r5 = r6.getLong(r8);     // Catch: Throwable -> L21
        if (r6.isNull(r3) == false) goto L12;
        String r9 = null;
    L14:
        if (r6.isNull(r4) == true) goto L17;
        r2 = r6.getString(r4);     // Catch: Throwable -> L21
    L17:
        r1 = new by(r5, r9, r2);     // Catch: Throwable -> L21
        goto L19
    L12:
        r9 = r6.getString(r3);     // Catch: Throwable -> L21
    L19:
        r6.close();
        r0.release();
        return r1;
    L21:
        th = move-exception;
        r6.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r7);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public by queryById(long r1) {
        return GlassesEpisodicRelevantDataDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ by queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<by> queryByIds(List<Long> r3) {
        return GlassesEpisodicRelevantDataDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public by queryByUUID(String r1) {
        return GlassesEpisodicRelevantDataDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ by queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public by queryOne() {
        return GlassesEpisodicRelevantDataDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ by queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<by> queryWithLimitAndOffset(int r1, int r2) {
        return GlassesEpisodicRelevantDataDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<by> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityGlassesEpisodicRelevantData(r6));     // Catch: Throwable -> L10
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
    public int update2(by r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfGlassesEpisodicRelevantData.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(by r3) {
        return update2((by) ZeusTransformUtils.preCheckCast(r3, by.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<by> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfGlassesEpisodicRelevantData.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
