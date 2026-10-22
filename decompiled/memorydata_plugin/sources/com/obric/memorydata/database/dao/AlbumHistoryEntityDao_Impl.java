package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.fg;
import com.obric.memorydata.database.entity.fh;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class AlbumHistoryEntityDao_Impl implements AlbumHistoryEntityDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<fh> __deletionAdapterOfRawAlbumHistoryEntity;
    private final EntityInsertionAdapter<fh> __insertionAdapterOfRawAlbumHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<fh> __updateAdapterOfRawAlbumHistoryEntity;

    public AlbumHistoryEntityDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfRawAlbumHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfRawAlbumHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfRawAlbumHistoryEntity = new AnonymousClass3(this, r2);
    }

    private fh __entityCursorConverter_comObricMemorydataDatabaseEntityRawAlbumHistoryEntity(Cursor r40) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r40, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "album_id");
        int r3 = CursorUtil.getColumnIndex(r0, "album_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "album_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "album_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "album_type");
        int r7 = CursorUtil.getColumnIndex(r0, "album_timestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "album_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "album_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "album_uuid");
        int r11 = CursorUtil.getColumnIndex(r0, "album_name");
        int r12 = CursorUtil.getColumnIndex(r0, "album_cover");
        int r13 = CursorUtil.getColumnIndex(r0, "album_mediaCount");
        int r14 = CursorUtil.getColumnIndex(r0, "album_poison_label");
        int r15 = CursorUtil.getColumnIndex(r0, "album_poison_label_version");
        int r16 = CursorUtil.getColumnIndex(r0, "album_content_hash");
        long r17 = 0;
        if (r1 != (-1)) goto L5;
        long r20 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r23 = 0;
    L9:
        String r18 = null;
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
        int r19 = 0;
        if (r6 != (-1)) goto L25;
        int r30 = 0;
    L26:
        if (r7 == (-1)) goto L29;
        r17 = r0.getLong(r7);
    L29:
        long r31 = r17;
        if (r8 != (-1)) goto L33;
    L31:
        String r33 = null;
    L36:
        if (r9 != (-1)) goto L38;
        int r34 = 0;
    L39:
        if (r10 != (-1)) goto L42;
    L40:
        String r35 = null;
    L45:
        if (r11 != (-1)) goto L48;
    L46:
        String r36 = null;
    L51:
        if (r12 != (-1)) goto L54;
    L52:
        String r37 = null;
    L57:
        if (r13 == (-1)) goto L60;
        r19 = r0.getInt(r13);
    L60:
        fg r21 = new fg(r23, r25, r26, r28, r30, r31, r33, r34, r35, r36, r37, r19);
        if (r14 == (-1)) goto L68;
        if (r0.isNull(r14) == false) goto L65;
        Integer r22 = null;
    L66:
        r21.setPoisonLabel(r22);
        goto L68
    L65:
        r22 = Integer.valueOf(r0.getInt(r14));
    L68:
        if (r15 == (-1)) goto L75;
        if (r0.isNull(r15) == false) goto L72;
        Integer r24 = null;
    L73:
        r21.setPoisonLabelVersion(r24);
        goto L75
    L72:
        r24 = Integer.valueOf(r0.getInt(r15));
    L75:
        if (r16 == (-1)) goto L82;
        if (r0.isNull(r16) == true) goto L80;
        r18 = r0.getString(r16);
    L80:
        r21.setContentHash(r18);
    L82:
        return new fh(r20, r21);
    L54:
        if (r0.isNull(r12) == true) goto L52;
        r37 = r0.getString(r12);
        goto L57
    L48:
        if (r0.isNull(r11) == true) goto L46;
        r36 = r0.getString(r11);
        goto L51
    L42:
        if (r0.isNull(r10) == true) goto L40;
        r35 = r0.getString(r10);
        goto L45
    L38:
        r34 = r0.getInt(r9);
        goto L39
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
    public void bulkDelete(List<fh> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfRawAlbumHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<fh> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfRawAlbumHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(fh r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfRawAlbumHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((fh) ZeusTransformUtils.preCheckCast(r3, fh.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return AlbumHistoryEntityDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return AlbumHistoryEntityDao.DefaultImpls.deleteByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return AlbumHistoryEntityDao.DefaultImpls.deleteByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return AlbumHistoryEntityDao.DefaultImpls.deleteByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return AlbumHistoryEntityDao.DefaultImpls.deleteById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.AlbumHistoryEntityDao, com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return AlbumHistoryEntityDao.DefaultImpls.getPrefix(this);
    }

    @Override // com.obric.memorydata.database.dao.AlbumHistoryEntityDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return AlbumHistoryEntityDao.DefaultImpls.getTableName(this);
    }

    public long insert(fh r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfRawAlbumHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((fh) ZeusTransformUtils.preCheckCast(r3, fh.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<fh> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfRawAlbumHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fh> queryAll() {
        return AlbumHistoryEntityDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return AlbumHistoryEntityDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<fh> queryByEntityId(String r1, String r2) {
        return AlbumHistoryEntityDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<fh> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return AlbumHistoryEntityDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fh queryById(long r1) {
        return AlbumHistoryEntityDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fh> queryByIds(List<Long> r3) {
        return AlbumHistoryEntityDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fh queryByUUID(String r1) {
        return AlbumHistoryEntityDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public fh queryOne() {
        return AlbumHistoryEntityDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fh> queryWithLimitAndOffset(int r1, int r2) {
        return AlbumHistoryEntityDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<fh> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityRawAlbumHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(fh r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfRawAlbumHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((fh) ZeusTransformUtils.preCheckCast(r3, fh.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<fh> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfRawAlbumHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
