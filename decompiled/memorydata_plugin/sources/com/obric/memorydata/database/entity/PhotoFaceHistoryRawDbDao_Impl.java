package com.obric.memorydata.database.entity;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class PhotoFaceHistoryRawDbDao_Impl implements el {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ek> __deletionAdapterOfPhotoFaceHistoryEntity;
    private final EntityInsertionAdapter<ek> __insertionAdapterOfPhotoFaceHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<ek> __updateAdapterOfPhotoFaceHistoryEntity;

    public PhotoFaceHistoryRawDbDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfPhotoFaceHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfPhotoFaceHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfPhotoFaceHistoryEntity = new AnonymousClass3(this, r2);
    }

    private ek __entityCursorConverter_comObricMemorydataDatabaseEntityPhotoFaceHistoryEntity(Cursor r38) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r38, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "photo_face_id");
        int r3 = CursorUtil.getColumnIndex(r0, "photo_face_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "photo_face_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "photo_face_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "photo_face_type");
        int r7 = CursorUtil.getColumnIndex(r0, "photo_face_timestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "photo_face_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "photo_face_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "photo_face_name");
        int r11 = CursorUtil.getColumnIndex(r0, "photo_face_avatar");
        int r12 = CursorUtil.getColumnIndex(r0, "photo_face_uuid");
        int r13 = CursorUtil.getColumnIndex(r0, "photo_face_poison_label");
        int r14 = CursorUtil.getColumnIndex(r0, "photo_face_poison_label_version");
        int r15 = CursorUtil.getColumnIndex(r0, "photo_face_content_hash");
        long r16 = 0;
        if (r1 != (-1)) goto L5;
        long r20 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r23 = 0;
    L9:
        String r17 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r25 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r26 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r28 = 0;
    L22:
        int r18 = 0;
        if (r6 != (-1)) goto L25;
        int r30 = 0;
    L26:
        if (r7 == (-1)) goto L29;
        r16 = r0.getLong(r7);
    L29:
        long r31 = r16;
        if (r8 != (-1)) goto L33;
    L31:
        String r33 = null;
    L36:
        if (r9 == (-1)) goto L39;
        r18 = r0.getInt(r9);
    L39:
        int r34 = r18;
        if (r10 != (-1)) goto L43;
    L41:
        String r35 = null;
    L46:
        if (r11 != (-1)) goto L49;
    L47:
        String r36 = null;
    L52:
        hc r19 = new hc(r23, r25, r26, r28, r30, r31, r33, r34, r35, r36);
        if (r12 != (-1)) goto L55;
    L59:
        if (r13 != (-1)) goto L61;
    L65:
        if (r14 == (-1)) goto L72;
        if (r0.isNull(r14) == false) goto L69;
        Integer r21 = null;
    L70:
        r19.setPoisonLabelVersion(r21);
        goto L72
    L69:
        r21 = Integer.valueOf(r0.getInt(r14));
    L72:
        if (r15 == (-1)) goto L79;
        if (r0.isNull(r15) == true) goto L77;
        r17 = r0.getString(r15);
    L77:
        r19.setContentHash(r17);
    L79:
        return new ek(r20, r19);
    L61:
        if (r0.isNull(r13) == false) goto L63;
        Integer r22 = null;
    L64:
        r19.setPoisonLabel(r22);
        goto L65
    L63:
        r22 = Integer.valueOf(r0.getInt(r13));
        goto L64
    L55:
        if (r0.isNull(r12) == false) goto L57;
        String r24 = null;
    L58:
        r19.setUuid(r24);
        goto L59
    L57:
        r24 = r0.getString(r12);
        goto L58
    L49:
        if (r0.isNull(r11) == true) goto L47;
        r36 = r0.getString(r11);
        goto L52
    L43:
        if (r0.isNull(r10) == true) goto L41;
        r35 = r0.getString(r10);
        goto L46
    L33:
        if (r0.isNull(r8) == true) goto L31;
        r33 = r0.getString(r8);
        goto L36
    L25:
        r30 = r0.getInt(r6);
        goto L26
    L21:
        r28 = r0.getLong(r5);
        goto L22
    L18:
        r26 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r25 = r0.getString(r3);
        goto L16
    L8:
        r23 = r0.getLong(r2);
        goto L9
    L5:
        r20 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<ek> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfPhotoFaceHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<ek> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPhotoFaceHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(ek r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfPhotoFaceHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((ek) ZeusTransformUtils.preCheckCast(r3, ek.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return el.a.e(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return el.a.b(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return el.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return el.a.b(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return el.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return el.a.b(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return el.a.a(this);
    }

    public long insert(ek r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfPhotoFaceHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((ek) ZeusTransformUtils.preCheckCast(r3, ek.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<ek> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfPhotoFaceHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ek> queryAll() {
        return el.a.c(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return el.a.d(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<ek> queryByEntityId(String r1, String r2) {
        return el.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<ek> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return el.a.c(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ek queryById(long r1) {
        return el.a.b(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ek> queryByIds(List<Long> r3) {
        return el.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ek queryByUUID(String r1) {
        return el.a.a(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public ek queryOne() {
        return el.a.f(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ek> queryWithLimitAndOffset(int r1, int r2) {
        return el.a.a(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<ek> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityPhotoFaceHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(ek r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfPhotoFaceHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((ek) ZeusTransformUtils.preCheckCast(r3, ek.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<ek> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfPhotoFaceHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
