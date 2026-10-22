package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.PersonAudioProfileEntity;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class PersonAudioProfileDao_Impl implements PersonAudioProfileDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PersonAudioProfileEntity> __deletionAdapterOfPersonAudioProfileEntity;
    private final EntityInsertionAdapter<PersonAudioProfileEntity> __insertionAdapterOfPersonAudioProfileEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByProfileId;
    private final EntityDeletionOrUpdateAdapter<PersonAudioProfileEntity> __updateAdapterOfPersonAudioProfileEntity;

    public PersonAudioProfileDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfPersonAudioProfileEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfPersonAudioProfileEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfPersonAudioProfileEntity = new AnonymousClass3(this, r2);
        this.__preparedStmtOfDeleteByProfileId = new AnonymousClass4(this, r2);
    }

    private PersonAudioProfileEntity __entityCursorConverter_comObricMemorydataDatabaseEntityPersonAudioProfileEntity(Cursor r29) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r29, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "profileId");
        int r3 = CursorUtil.getColumnIndex(r0, AILabCheckPermissionTask.KEY_SOURCE);
        int r4 = CursorUtil.getColumnIndex(r0, "embedding");
        int r5 = CursorUtil.getColumnIndex(r0, "dim");
        int r6 = CursorUtil.getColumnIndex(r0, "resourceId");
        int r7 = CursorUtil.getColumnIndex(r0, "modelVersion");
        int r8 = CursorUtil.getColumnIndex(r0, "durationMs");
        int r9 = CursorUtil.getColumnIndex(r0, "createdAt");
        long r10 = 0;
        if (r1 != (-1)) goto L5;
        long r16 = 0;
    L6:
        String r11 = null;
        if (r2 != (-1)) goto L10;
    L8:
        String r18 = null;
    L13:
        if (r3 != (-1)) goto L16;
    L14:
        String r19 = null;
    L19:
        if (r4 != (-1)) goto L22;
    L20:
        String r20 = null;
    L25:
        if (r5 != (-1)) goto L27;
        int r12 = 0;
    L28:
        int r21 = r12;
        if (r6 != (-1)) goto L32;
    L30:
        String r22 = null;
    L35:
        if (r7 != (-1)) goto L38;
    L36:
        String r23 = r11;
        if (r8 != (-1)) goto L43;
        long r24 = 0;
    L44:
        if (r9 == (-1)) goto L48;
        r10 = r0.getLong(r9);
    L48:
        return new PersonAudioProfileEntity(r16, r18, r19, r20, r21, r22, r23, r24, r10);
    L43:
        r24 = r0.getLong(r8);
        goto L44
    L38:
        if (r0.isNull(r7) == true) goto L36;
        r11 = r0.getString(r7);
        goto L36
    L32:
        if (r0.isNull(r6) == true) goto L30;
        r22 = r0.getString(r6);
        goto L35
    L27:
        r12 = r0.getInt(r5);
        goto L28
    L22:
        if (r0.isNull(r4) == true) goto L20;
        r20 = r0.getString(r4);
        goto L25
    L16:
        if (r0.isNull(r3) == true) goto L14;
        r19 = r0.getString(r3);
        goto L19
    L10:
        if (r0.isNull(r2) == true) goto L8;
        r18 = r0.getString(r2);
        goto L13
    L5:
        r16 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<PersonAudioProfileEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfPersonAudioProfileEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<PersonAudioProfileEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPersonAudioProfileEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(PersonAudioProfileEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfPersonAudioProfileEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(PersonAudioProfileEntity r3) {
        return delete2((PersonAudioProfileEntity) ZeusTransformUtils.preCheckCast(r3, PersonAudioProfileEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return PersonAudioProfileDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.PersonAudioProfileDao
    public int deleteByProfileId(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfDeleteByProfileId.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByProfileId.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByProfileId.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.PersonAudioProfileDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return PersonAudioProfileDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(PersonAudioProfileEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfPersonAudioProfileEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(PersonAudioProfileEntity r3) {
        return insert2((PersonAudioProfileEntity) ZeusTransformUtils.preCheckCast(r3, PersonAudioProfileEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<PersonAudioProfileEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfPersonAudioProfileEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.PersonAudioProfileDao, com.obric.memorydata.database.dao.BaseDao
    public List<PersonAudioProfileEntity> queryAll() {
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire("SELECT * FROM PersonAudioProfile", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r2 = DBUtil.query(this.__db, r1, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r2, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        int r4 = CursorUtil.getColumnIndexOrThrow(r2, "profileId");     // Catch: Throwable -> L30
        int r5 = CursorUtil.getColumnIndexOrThrow(r2, AILabCheckPermissionTask.KEY_SOURCE);     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r2, "embedding");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r2, "dim");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r2, "resourceId");     // Catch: Throwable -> L30
        int r9 = CursorUtil.getColumnIndexOrThrow(r2, "modelVersion");     // Catch: Throwable -> L30
        int r10 = CursorUtil.getColumnIndexOrThrow(r2, "durationMs");     // Catch: Throwable -> L30
        int r11 = CursorUtil.getColumnIndexOrThrow(r2, "createdAt");     // Catch: Throwable -> L30
        ArrayList r12 = new ArrayList(r2.getCount());     // Catch: Throwable -> L30
    L4:
        if (r2.moveToNext() == false) goto L28;
        long r15 = r2.getLong(r0);     // Catch: Throwable -> L30
        if (r2.isNull(r4) == false) goto L9;
        String r17 = null;
    L11:
        if (r2.isNull(r5) == false) goto L13;
        String r18 = null;
    L15:
        if (r2.isNull(r6) == false) goto L17;
        String r19 = null;
    L18:
        int r20 = r2.getInt(r7);     // Catch: Throwable -> L30
        if (r2.isNull(r8) == false) goto L21;
        String r21 = null;
    L23:
        if (r2.isNull(r9) == false) goto L25;
        String r22 = null;
    L26:
        r12.add(new PersonAudioProfileEntity(r15, r17, r18, r19, r20, r21, r22, r2.getLong(r10), r2.getLong(r11)));     // Catch: Throwable -> L30
        goto L4
    L25:
        r22 = r2.getString(r9);     // Catch: Throwable -> L30
        goto L26
    L21:
        r21 = r2.getString(r8);     // Catch: Throwable -> L30
        goto L23
    L17:
        r19 = r2.getString(r6);     // Catch: Throwable -> L30
        goto L18
    L13:
        r18 = r2.getString(r5);     // Catch: Throwable -> L30
        goto L15
    L9:
        r17 = r2.getString(r4);     // Catch: Throwable -> L30
        goto L11
    L28:
        r2.close();
        r1.release();
        return r12;
    L30:
        th = move-exception;
        r2.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return PersonAudioProfileDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PersonAudioProfileEntity queryById(long r1) {
        return PersonAudioProfileDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PersonAudioProfileEntity queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PersonAudioProfileEntity> queryByIds(List<Long> r3) {
        return PersonAudioProfileDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.PersonAudioProfileDao
    public List<PersonAudioProfileEntity> queryByProfileId(String r28) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM PersonAudioProfile WHERE profileId = ?", 1);
        if (r28 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "profileId");     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, AILabCheckPermissionTask.KEY_SOURCE);     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "embedding");     // Catch: Throwable -> L34
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "dim");     // Catch: Throwable -> L34
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "resourceId");     // Catch: Throwable -> L34
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "modelVersion");     // Catch: Throwable -> L34
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "durationMs");     // Catch: Throwable -> L34
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "createdAt");     // Catch: Throwable -> L34
        ArrayList r12 = new ArrayList(r1.getCount());     // Catch: Throwable -> L34
    L8:
        if (r1.moveToNext() == false) goto L32;
        long r15 = r1.getLong(r0);     // Catch: Throwable -> L34
        if (r1.isNull(r4) == false) goto L13;
        String r17 = null;
    L15:
        if (r1.isNull(r5) == false) goto L17;
        String r18 = null;
    L19:
        if (r1.isNull(r6) == false) goto L21;
        String r19 = null;
    L22:
        int r20 = r1.getInt(r7);     // Catch: Throwable -> L34
        if (r1.isNull(r8) == false) goto L25;
        String r21 = null;
    L27:
        if (r1.isNull(r9) == false) goto L29;
        String r22 = null;
    L30:
        r12.add(new PersonAudioProfileEntity(r15, r17, r18, r19, r20, r21, r22, r1.getLong(r10), r1.getLong(r11)));     // Catch: Throwable -> L34
        goto L8
    L29:
        r22 = r1.getString(r9);     // Catch: Throwable -> L34
        goto L30
    L25:
        r21 = r1.getString(r8);     // Catch: Throwable -> L34
        goto L27
    L21:
        r19 = r1.getString(r6);     // Catch: Throwable -> L34
        goto L22
    L17:
        r18 = r1.getString(r5);     // Catch: Throwable -> L34
        goto L19
    L13:
        r17 = r1.getString(r4);     // Catch: Throwable -> L34
        goto L15
    L32:
        r1.close();
        r2.release();
        return r12;
    L34:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r28);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PersonAudioProfileEntity queryByUUID(String r1) {
        return PersonAudioProfileDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PersonAudioProfileEntity queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PersonAudioProfileEntity queryOne() {
        return PersonAudioProfileDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PersonAudioProfileEntity queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PersonAudioProfileEntity> queryWithLimitAndOffset(int r1, int r2) {
        return PersonAudioProfileDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PersonAudioProfileEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityPersonAudioProfileEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(PersonAudioProfileEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfPersonAudioProfileEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(PersonAudioProfileEntity r3) {
        return update2((PersonAudioProfileEntity) ZeusTransformUtils.preCheckCast(r3, PersonAudioProfileEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<PersonAudioProfileEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfPersonAudioProfileEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
