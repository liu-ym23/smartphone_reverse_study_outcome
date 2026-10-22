package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.obric.memorydata.database.entity.PersonProfileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class PersonProfileDao_Impl implements PersonProfileDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PersonProfileEntity> __deletionAdapterOfPersonProfileEntity;
    private final EntityInsertionAdapter<PersonProfileEntity> __insertionAdapterOfPersonProfileEntity;
    private final EntityDeletionOrUpdateAdapter<PersonProfileEntity> __updateAdapterOfPersonProfileEntity;

    public PersonProfileDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfPersonProfileEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfPersonProfileEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfPersonProfileEntity = new AnonymousClass3(this, r2);
    }

    private PersonProfileEntity __entityCursorConverter_comObricMemorydataDatabaseEntityPersonProfileEntity(Cursor r23) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r23, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, "profileId");
        int r2 = CursorUtil.getColumnIndex(r0, "alias");
        int r3 = CursorUtil.getColumnIndex(r0, "aliasConfidence");
        int r4 = CursorUtil.getColumnIndex(r0, "summary");
        int r5 = CursorUtil.getColumnIndex(r0, "summaryConfidence");
        int r6 = CursorUtil.getColumnIndex(r0, "l1RefIds");
        int r7 = CursorUtil.getColumnIndex(r0, "createdAt");
        int r8 = CursorUtil.getColumnIndex(r0, "updatedAt");
        String r10 = null;
        if (r1 != (-1)) goto L6;
    L4:
        String r12 = null;
    L9:
        if (r2 != (-1)) goto L12;
    L10:
        String r13 = null;
    L15:
        if (r3 != (-1)) goto L18;
    L16:
        String r14 = null;
    L21:
        if (r4 != (-1)) goto L24;
    L22:
        String r15 = null;
    L27:
        if (r5 != (-1)) goto L30;
    L28:
        String r16 = null;
    L33:
        if (r6 != (-1)) goto L36;
    L34:
        String r17 = r10;
        if (r7 != (-1)) goto L42;
        long r18 = 0;
    L43:
        if (r8 != (-1)) goto L45;
        long r20 = 0;
    L47:
        return new PersonProfileEntity(r12, r13, r14, r15, r16, r17, r18, r20);
    L45:
        r20 = r0.getLong(r8);
        goto L47
    L42:
        r18 = r0.getLong(r7);
        goto L43
    L36:
        if (r0.isNull(r6) == true) goto L34;
        r10 = r0.getString(r6);
        goto L34
    L30:
        if (r0.isNull(r5) == true) goto L28;
        r16 = r0.getString(r5);
        goto L33
    L24:
        if (r0.isNull(r4) == true) goto L22;
        r15 = r0.getString(r4);
        goto L27
    L18:
        if (r0.isNull(r3) == true) goto L16;
        r14 = r0.getString(r3);
        goto L21
    L12:
        if (r0.isNull(r2) == true) goto L10;
        r13 = r0.getString(r2);
        goto L15
    L6:
        if (r0.isNull(r1) == true) goto L4;
        r12 = r0.getString(r1);
        goto L9
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<PersonProfileEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfPersonProfileEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<PersonProfileEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPersonProfileEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(PersonProfileEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfPersonProfileEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(PersonProfileEntity r3) {
        return delete2((PersonProfileEntity) ZeusTransformUtils.preCheckCast(r3, PersonProfileEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return PersonProfileDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.PersonProfileDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return PersonProfileDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(PersonProfileEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfPersonProfileEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(PersonProfileEntity r3) {
        return insert2((PersonProfileEntity) ZeusTransformUtils.preCheckCast(r3, PersonProfileEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<PersonProfileEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfPersonProfileEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PersonProfileEntity> queryAll() {
        return PersonProfileDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return PersonProfileDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PersonProfileEntity queryById(long r1) {
        return PersonProfileDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PersonProfileEntity queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PersonProfileEntity> queryByIds(List<Long> r3) {
        return PersonProfileDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.PersonProfileDao
    public PersonProfileEntity queryByProfileId(String r23) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM PersonProfile WHERE profileId = ? LIMIT 1", 1);
        if (r23 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        PersonProfileEntity r3 = null;
        String r4 = null;
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, "profileId");     // Catch: Throwable -> L36
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "alias");     // Catch: Throwable -> L36
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "aliasConfidence");     // Catch: Throwable -> L36
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "summary");     // Catch: Throwable -> L36
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "summaryConfidence");     // Catch: Throwable -> L36
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "l1RefIds");     // Catch: Throwable -> L36
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "createdAt");     // Catch: Throwable -> L36
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "updatedAt");     // Catch: Throwable -> L36
        if (r1.moveToFirst() == true) goto L10;
    L34:
        r1.close();
        r2.release();
        return r3;
    L10:
        if (r1.isNull(r0) == false) goto L12;
        String r12 = null;
    L14:
        if (r1.isNull(r5) == false) goto L16;
        String r13 = null;
    L18:
        if (r1.isNull(r6) == false) goto L20;
        String r14 = null;
    L22:
        if (r1.isNull(r7) == false) goto L24;
        String r15 = null;
    L26:
        if (r1.isNull(r8) == false) goto L28;
        String r16 = null;
    L30:
        if (r1.isNull(r9) == true) goto L33;
        r4 = r1.getString(r9);     // Catch: Throwable -> L36
    L33:
        r3 = new PersonProfileEntity(r12, r13, r14, r15, r16, r4, r1.getLong(r10), r1.getLong(r11));     // Catch: Throwable -> L36
        goto L34
    L28:
        r16 = r1.getString(r8);     // Catch: Throwable -> L36
        goto L30
    L24:
        r15 = r1.getString(r7);     // Catch: Throwable -> L36
        goto L26
    L20:
        r14 = r1.getString(r6);     // Catch: Throwable -> L36
        goto L22
    L16:
        r13 = r1.getString(r5);     // Catch: Throwable -> L36
        goto L18
    L12:
        r12 = r1.getString(r0);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r23);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PersonProfileEntity queryByUUID(String r1) {
        return PersonProfileDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PersonProfileEntity queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PersonProfileEntity queryOne() {
        return PersonProfileDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PersonProfileEntity queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.PersonProfileDao
    public SpeakerProfileDailyStats querySpeakerProfileDailyStats() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("\n        SELECT\n            COUNT(*) AS profileCount,\n            CASE WHEN COUNT(*) = 0 THEN NULL ELSE (\n                SELECT COUNT(*) * 1.0\n                FROM PersonAudioProfile AS audio\n                INNER JOIN PersonProfile AS profile ON profile.profileId = audio.profileId\n            ) / COUNT(*) END AS profileAvgEmbeddingCount\n        FROM PersonProfile\n        ", 0);
        this.__db.assertNotSuspendingTransaction();
        SpeakerProfileDailyStats r2 = null;
        Double r3 = null;
        Cursor r6 = DBUtil.query(this.__db, r0, false, null);
    L13:
        th = move-exception;
        r6.close();
        r0.release();
        throw th;
    L4:
        if (r6.moveToFirst() == false) goto L11;
        long r4 = r6.getLong(0);     // Catch: Throwable -> L13
        if (r6.isNull(1) == true) goto L9;
        r3 = Double.valueOf(r6.getDouble(1));     // Catch: Throwable -> L13
    L9:
        r2 = new SpeakerProfileDailyStats(r4, r3);     // Catch: Throwable -> L13
    L11:
        r6.close();
        r0.release();
        return r2;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PersonProfileEntity> queryWithLimitAndOffset(int r1, int r2) {
        return PersonProfileDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PersonProfileEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityPersonProfileEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(PersonProfileEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfPersonProfileEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(PersonProfileEntity r3) {
        return update2((PersonProfileEntity) ZeusTransformUtils.preCheckCast(r3, PersonProfileEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<PersonProfileEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfPersonProfileEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
