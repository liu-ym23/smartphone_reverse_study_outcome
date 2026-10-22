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
import com.obric.memorydata.database.entity.PersonImageProfileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class PersonImageProfileDao_Impl implements PersonImageProfileDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PersonImageProfileEntity> __deletionAdapterOfPersonImageProfileEntity;
    private final EntityInsertionAdapter<PersonImageProfileEntity> __insertionAdapterOfPersonImageProfileEntity;
    private final EntityDeletionOrUpdateAdapter<PersonImageProfileEntity> __updateAdapterOfPersonImageProfileEntity;

    public PersonImageProfileDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfPersonImageProfileEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfPersonImageProfileEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfPersonImageProfileEntity = new AnonymousClass3(this, r2);
    }

    private PersonImageProfileEntity __entityCursorConverter_comObricMemorydataDatabaseEntityPersonImageProfileEntity(Cursor r28) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r28, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "profileId");
        int r3 = CursorUtil.getColumnIndex(r0, "embedding");
        int r4 = CursorUtil.getColumnIndex(r0, "dim");
        int r5 = CursorUtil.getColumnIndex(r0, "resourceId");
        int r6 = CursorUtil.getColumnIndex(r0, "modelVersion");
        int r7 = CursorUtil.getColumnIndex(r0, "confidence");
        int r8 = CursorUtil.getColumnIndex(r0, "profileImageType");
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
        if (r4 != (-1)) goto L21;
        int r12 = 0;
    L22:
        int r20 = r12;
        if (r5 != (-1)) goto L26;
    L24:
        String r21 = null;
    L29:
        if (r6 != (-1)) goto L32;
    L30:
        String r22 = null;
    L35:
        if (r7 != (-1)) goto L38;
    L36:
        String r23 = null;
    L41:
        if (r8 != (-1)) goto L44;
    L42:
        String r24 = r11;
        if (r9 == (-1)) goto L51;
        r10 = r0.getLong(r9);
    L51:
        return new PersonImageProfileEntity(r16, r18, r19, r20, r21, r22, r23, r24, r10);
    L44:
        if (r0.isNull(r8) == true) goto L42;
        r11 = r0.getString(r8);
        goto L42
    L38:
        if (r0.isNull(r7) == true) goto L36;
        r23 = r0.getString(r7);
        goto L41
    L32:
        if (r0.isNull(r6) == true) goto L30;
        r22 = r0.getString(r6);
        goto L35
    L26:
        if (r0.isNull(r5) == true) goto L24;
        r21 = r0.getString(r5);
        goto L29
    L21:
        r12 = r0.getInt(r4);
        goto L22
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
    public void bulkDelete(List<PersonImageProfileEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfPersonImageProfileEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<PersonImageProfileEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPersonImageProfileEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(PersonImageProfileEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfPersonImageProfileEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(PersonImageProfileEntity r3) {
        return delete2((PersonImageProfileEntity) ZeusTransformUtils.preCheckCast(r3, PersonImageProfileEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return PersonImageProfileDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.PersonImageProfileDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return PersonImageProfileDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(PersonImageProfileEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfPersonImageProfileEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(PersonImageProfileEntity r3) {
        return insert2((PersonImageProfileEntity) ZeusTransformUtils.preCheckCast(r3, PersonImageProfileEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<PersonImageProfileEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfPersonImageProfileEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PersonImageProfileEntity> queryAll() {
        return PersonImageProfileDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return PersonImageProfileDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PersonImageProfileEntity queryById(long r1) {
        return PersonImageProfileDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PersonImageProfileEntity queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PersonImageProfileEntity> queryByIds(List<Long> r3) {
        return PersonImageProfileDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.PersonImageProfileDao
    public List<PersonImageProfileEntity> queryByProfileId(String r27) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM PersonImageProfile WHERE profileId = ?", 1);
        if (r27 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r1 = DBUtil.query(this.__db, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r1, OaidModel.KEY_ID);     // Catch: Throwable -> L38
        int r4 = CursorUtil.getColumnIndexOrThrow(r1, "profileId");     // Catch: Throwable -> L38
        int r5 = CursorUtil.getColumnIndexOrThrow(r1, "embedding");     // Catch: Throwable -> L38
        int r6 = CursorUtil.getColumnIndexOrThrow(r1, "dim");     // Catch: Throwable -> L38
        int r7 = CursorUtil.getColumnIndexOrThrow(r1, "resourceId");     // Catch: Throwable -> L38
        int r8 = CursorUtil.getColumnIndexOrThrow(r1, "modelVersion");     // Catch: Throwable -> L38
        int r9 = CursorUtil.getColumnIndexOrThrow(r1, "confidence");     // Catch: Throwable -> L38
        int r10 = CursorUtil.getColumnIndexOrThrow(r1, "profileImageType");     // Catch: Throwable -> L38
        int r11 = CursorUtil.getColumnIndexOrThrow(r1, "createdAt");     // Catch: Throwable -> L38
        ArrayList r12 = new ArrayList(r1.getCount());     // Catch: Throwable -> L38
    L8:
        if (r1.moveToNext() == false) goto L36;
        long r15 = r1.getLong(r0);     // Catch: Throwable -> L38
        if (r1.isNull(r4) == false) goto L13;
        String r17 = null;
    L15:
        if (r1.isNull(r5) == false) goto L17;
        String r18 = null;
    L18:
        int r19 = r1.getInt(r6);     // Catch: Throwable -> L38
        if (r1.isNull(r7) == false) goto L21;
        String r20 = null;
    L23:
        if (r1.isNull(r8) == false) goto L25;
        String r21 = null;
    L27:
        if (r1.isNull(r9) == false) goto L29;
        String r22 = null;
    L31:
        if (r1.isNull(r10) == false) goto L33;
        String r23 = null;
    L34:
        r12.add(new PersonImageProfileEntity(r15, r17, r18, r19, r20, r21, r22, r23, r1.getLong(r11)));     // Catch: Throwable -> L38
        goto L8
    L33:
        r23 = r1.getString(r10);     // Catch: Throwable -> L38
        goto L34
    L29:
        r22 = r1.getString(r9);     // Catch: Throwable -> L38
        goto L31
    L25:
        r21 = r1.getString(r8);     // Catch: Throwable -> L38
        goto L27
    L21:
        r20 = r1.getString(r7);     // Catch: Throwable -> L38
        goto L23
    L17:
        r18 = r1.getString(r5);     // Catch: Throwable -> L38
        goto L18
    L13:
        r17 = r1.getString(r4);     // Catch: Throwable -> L38
        goto L15
    L36:
        r1.close();
        r2.release();
        return r12;
    L38:
        th = move-exception;
        r1.close();
        r2.release();
        throw th;
    L5:
        r2.bindString(1, r27);
        goto L6
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PersonImageProfileEntity queryByUUID(String r1) {
        return PersonImageProfileDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PersonImageProfileEntity queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public PersonImageProfileEntity queryOne() {
        return PersonImageProfileDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ PersonImageProfileEntity queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PersonImageProfileEntity> queryWithLimitAndOffset(int r1, int r2) {
        return PersonImageProfileDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<PersonImageProfileEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityPersonImageProfileEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(PersonImageProfileEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfPersonImageProfileEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(PersonImageProfileEntity r3) {
        return update2((PersonImageProfileEntity) ZeusTransformUtils.preCheckCast(r3, PersonImageProfileEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<PersonImageProfileEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfPersonImageProfileEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
