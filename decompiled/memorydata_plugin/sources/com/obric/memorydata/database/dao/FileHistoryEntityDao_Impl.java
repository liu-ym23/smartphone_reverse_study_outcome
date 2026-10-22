package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.core.provider.FontsContractCompat;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.ge;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class FileHistoryEntityDao_Impl implements FileHistoryEntityDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<FileHistoryEntity> __deletionAdapterOfFileHistoryEntity;
    private final EntityInsertionAdapter<FileHistoryEntity> __insertionAdapterOfFileHistoryEntity;
    private final EntityDeletionOrUpdateAdapter<FileHistoryEntity> __updateAdapterOfFileHistoryEntity;

    public FileHistoryEntityDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfFileHistoryEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfFileHistoryEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfFileHistoryEntity = new AnonymousClass3(this, r2);
    }

    private FileHistoryEntity __entityCursorConverter_comObricMemorydataDatabaseDaoFileHistoryEntity(Cursor r51) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r51, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, FontsContractCompat.Columns.FILE_ID);
        int r3 = CursorUtil.getColumnIndex(r0, "file_entityId");
        int r4 = CursorUtil.getColumnIndex(r0, "file_createTime");
        int r5 = CursorUtil.getColumnIndex(r0, "file_modifyTime");
        int r6 = CursorUtil.getColumnIndex(r0, "file_type");
        int r7 = CursorUtil.getColumnIndex(r0, "file_timestamp");
        int r8 = CursorUtil.getColumnIndex(r0, "file_packageName");
        int r9 = CursorUtil.getColumnIndex(r0, "file_hashCodeValue");
        int r10 = CursorUtil.getColumnIndex(r0, "file_fileName");
        int r11 = CursorUtil.getColumnIndex(r0, "file_fileSize");
        int r12 = CursorUtil.getColumnIndex(r0, "file_contentUrl");
        int r13 = CursorUtil.getColumnIndex(r0, "file_fileType");
        int r14 = CursorUtil.getColumnIndex(r0, "file_mimeType");
        int r15 = CursorUtil.getColumnIndex(r0, "file_fullContent");
        int r16 = CursorUtil.getColumnIndex(r0, "file_docNodeJson");
        int r17 = CursorUtil.getColumnIndex(r0, "file_uuid");
        int r18 = CursorUtil.getColumnIndex(r0, "file_resFiles");
        int r19 = CursorUtil.getColumnIndex(r0, "file_poison_label");
        int r110 = CursorUtil.getColumnIndex(r0, "file_poison_label_version");
        int r111 = CursorUtil.getColumnIndex(r0, "file_content_hash");
        long r20 = 0;
        if (r1 != (-1)) goto L5;
        long r25 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        long r28 = 0;
    L9:
        String r21 = null;
        if (r3 != (-1)) goto L13;
    L11:
        String r30 = null;
    L16:
        if (r4 != (-1)) goto L18;
        long r31 = 0;
    L19:
        if (r5 != (-1)) goto L21;
        long r33 = 0;
    L22:
        int r22 = 0;
        if (r6 != (-1)) goto L25;
        int r35 = 0;
    L26:
        if (r7 != (-1)) goto L28;
        long r36 = 0;
    L29:
        if (r8 != (-1)) goto L32;
    L30:
        String r38 = null;
    L35:
        if (r9 == (-1)) goto L38;
        r22 = r0.getInt(r9);
    L38:
        int r39 = r22;
        if (r10 != (-1)) goto L42;
    L40:
        String r40 = null;
    L45:
        if (r11 == (-1)) goto L48;
        r20 = r0.getLong(r11);
    L48:
        long r41 = r20;
        if (r12 != (-1)) goto L52;
    L50:
        String r43 = null;
    L55:
        if (r13 != (-1)) goto L58;
    L56:
        String r44 = null;
    L61:
        if (r14 != (-1)) goto L64;
    L62:
        String r45 = null;
    L67:
        if (r50 != (-1)) goto L70;
    L68:
        String r46 = null;
    L73:
        if (r51 != (-1)) goto L77;
    L74:
        String r47 = null;
    L80:
        if (r17 != (-1)) goto L84;
    L81:
        String r48 = null;
    L87:
        if (r18 != (-1)) goto L90;
    L88:
        String r49 = null;
    L93:
        ge r23 = new ge(r28, r30, r31, r33, r35, r36, r38, r39, r40, r41, r43, r44, r45, r46, r47, r48, r49);
        if (r19 == (-1)) goto L101;
        if (r0.isNull(r19) == false) goto L98;
        Integer r24 = null;
    L99:
        r23.setPoisonLabel(r24);
        goto L101
    L98:
        r24 = Integer.valueOf(r0.getInt(r19));
    L101:
        if (r110 == (-1)) goto L108;
        if (r0.isNull(r110) == false) goto L105;
        Integer r26 = null;
    L106:
        r23.setPoisonLabelVersion(r26);
        goto L108
    L105:
        r26 = Integer.valueOf(r0.getInt(r110));
    L108:
        if (r111 == (-1)) goto L115;
        if (r0.isNull(r111) == true) goto L113;
        r21 = r0.getString(r111);
    L113:
        r23.setContentHash(r21);
    L115:
        return new FileHistoryEntity(r25, r23);
    L90:
        if (r0.isNull(r18) == true) goto L88;
        r49 = r0.getString(r18);
        goto L93
    L84:
        if (r0.isNull(r17) == true) goto L81;
        r48 = r0.getString(r17);
        goto L87
    L77:
        if (r0.isNull(r51) == true) goto L74;
        r47 = r0.getString(r16);
        goto L80
    L70:
        if (r0.isNull(r50) == true) goto L68;
        r46 = r0.getString(r15);
        goto L73
    L64:
        if (r0.isNull(r14) == true) goto L62;
        r45 = r0.getString(r14);
        goto L67
    L58:
        if (r0.isNull(r13) == true) goto L56;
        r44 = r0.getString(r13);
        goto L61
    L52:
        if (r0.isNull(r12) == true) goto L50;
        r43 = r0.getString(r12);
        goto L55
    L42:
        if (r0.isNull(r10) == true) goto L40;
        r40 = r0.getString(r10);
        goto L45
    L32:
        if (r0.isNull(r8) == true) goto L30;
        r38 = r0.getString(r8);
        goto L35
    L28:
        r36 = r0.getLong(r7);
        goto L29
    L25:
        r35 = r0.getInt(r6);
        goto L26
    L21:
        r33 = r0.getLong(r5);
        goto L22
    L18:
        r31 = r0.getLong(r4);
        goto L19
    L13:
        if (r0.isNull(r3) == true) goto L11;
        r30 = r0.getString(r3);
        goto L16
    L8:
        r28 = r0.getLong(r2);
        goto L9
    L5:
        r25 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<FileHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfFileHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<FileHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfFileHistoryEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    public int delete(FileHistoryEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfFileHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return delete((FileHistoryEntity) ZeusTransformUtils.preCheckCast(r3, FileHistoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return FileHistoryEntityDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityId(String r1, String r2) {
        return FileHistoryEntityDao.DefaultImpls.deleteByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdList(List<String> r3, String r4) {
        return FileHistoryEntityDao.DefaultImpls.deleteByEntityIdList(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteByEntityIdListAndPackageName(List<String> r3, String r4) {
        return FileHistoryEntityDao.DefaultImpls.deleteByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public int deleteById(long r1) {
        return FileHistoryEntityDao.DefaultImpls.deleteById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.FileHistoryEntityDao, com.obric.memorydata.database.dao.IHistoryEntityDao
    public String getPrefix() {
        return FileHistoryEntityDao.DefaultImpls.getPrefix(this);
    }

    @Override // com.obric.memorydata.database.dao.FileHistoryEntityDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return FileHistoryEntityDao.DefaultImpls.getTableName(this);
    }

    public long insert(FileHistoryEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfFileHistoryEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
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
        return insert((FileHistoryEntity) ZeusTransformUtils.preCheckCast(r3, FileHistoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<FileHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfFileHistoryEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<FileHistoryEntity> queryAll() {
        return FileHistoryEntityDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return FileHistoryEntityDao.DefaultImpls.queryAllCount(this);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<FileHistoryEntity> queryByEntityId(String r1, String r2) {
        return FileHistoryEntityDao.DefaultImpls.queryByEntityId(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.IHistoryEntityDao
    public List<FileHistoryEntity> queryByEntityIdListAndPackageName(List<String> r3, String r4) {
        return FileHistoryEntityDao.DefaultImpls.queryByEntityIdListAndPackageName(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public FileHistoryEntity queryById(long r1) {
        return FileHistoryEntityDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<FileHistoryEntity> queryByIds(List<Long> r3) {
        return FileHistoryEntityDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public FileHistoryEntity queryByUUID(String r1) {
        return FileHistoryEntityDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public FileHistoryEntity queryOne() {
        return FileHistoryEntityDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ Object queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<FileHistoryEntity> queryWithLimitAndOffset(int r1, int r2) {
        return FileHistoryEntityDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<FileHistoryEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseDaoFileHistoryEntity(r6));     // Catch: Throwable -> L10
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

    public int update(FileHistoryEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfFileHistoryEntity.handle(r2) + 0;     // Catch: Throwable -> L6
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
        return update((FileHistoryEntity) ZeusTransformUtils.preCheckCast(r3, FileHistoryEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<FileHistoryEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfFileHistoryEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
