package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.dl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MetaFullContentKeywordCopilotDao_Impl implements MetaFullContentKeywordCopilotDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<dl> __deletionAdapterOfMetaFullContentKeywordCopilotEntity;
    private final EntityInsertionAdapter<dl> __insertionAdapterOfMetaFullContentKeywordCopilotEntity;
    private final EntityDeletionOrUpdateAdapter<dl> __updateAdapterOfMetaFullContentKeywordCopilotEntity;

    public MetaFullContentKeywordCopilotDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMetaFullContentKeywordCopilotEntity = new AnonymousClass1(this, r2);
        this.__deletionAdapterOfMetaFullContentKeywordCopilotEntity = new AnonymousClass2(this, r2);
        this.__updateAdapterOfMetaFullContentKeywordCopilotEntity = new AnonymousClass3(this, r2);
    }

    private dl __entityCursorConverter_comObricMemorydataDatabaseEntityMetaFullContentKeywordCopilotEntity(Cursor r18) {
        Cursor r0 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r18, Cursor.class, "com.obric.memorydata.plugin");
        int r1 = CursorUtil.getColumnIndex(r0, OaidModel.KEY_ID);
        int r2 = CursorUtil.getColumnIndex(r0, "type");
        int r3 = CursorUtil.getColumnIndex(r0, "rawDbId");
        int r4 = CursorUtil.getColumnIndex(r0, "uid");
        long r5 = 0;
        if (r1 != (-1)) goto L5;
        long r11 = 0;
    L6:
        if (r2 != (-1)) goto L8;
        int r6 = 0;
    L9:
        int r13 = r6;
        if (r3 == (-1)) goto L13;
        r5 = r0.getLong(r3);
    L13:
        long r14 = r5;
        if (r4 != (-1)) goto L17;
    L15:
        String r16 = null;
    L21:
        return new dl(r11, r13, r14, r16);
    L17:
        if (r0.isNull(r4) == true) goto L15;
        r16 = r0.getString(r4);
        goto L21
    L8:
        r6 = r0.getInt(r2);
        goto L9
    L5:
        r11 = r0.getLong(r1);
        goto L6
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<dl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMetaFullContentKeywordCopilotEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<dl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMetaFullContentKeywordCopilotEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public int delete(SupportSQLiteQuery r3) {
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

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(dl r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMetaFullContentKeywordCopilotEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(dl r3) {
        return delete2((dl) ZeusTransformUtils.preCheckCast(r3, dl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int deleteAll() {
        return MetaFullContentKeywordCopilotDao.DefaultImpls.deleteAll(this);
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public int deleteByRawDbIds(List<Long> r3, int r4) {
        return MetaFullContentKeywordCopilotDao.DefaultImpls.deleteByRawDbIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public int deleteByRawDbIdsAndUid(List<Long> r3, int r4, String r5) {
        return MetaFullContentKeywordCopilotDao.DefaultImpls.deleteByRawDbIdsAndUid(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, r5);
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao, com.obric.memorydata.database.dao.BaseDao
    public String getTableName() {
        return MetaFullContentKeywordCopilotDao.DefaultImpls.getTableName(this);
    }

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(dl r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMetaFullContentKeywordCopilotEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(dl r3) {
        return insert2((dl) ZeusTransformUtils.preCheckCast(r3, dl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<dl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMetaFullContentKeywordCopilotEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dl> queryAll() {
        return MetaFullContentKeywordCopilotDao.DefaultImpls.queryAll(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public int queryAllCount() {
        return MetaFullContentKeywordCopilotDao.DefaultImpls.queryAllCount(this);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dl queryById(long r1) {
        return MetaFullContentKeywordCopilotDao.DefaultImpls.queryById(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dl queryById(long r1) {
        return queryById(r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dl> queryByIds(List<Long> r3) {
        return MetaFullContentKeywordCopilotDao.DefaultImpls.queryByIds(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public List<dl> queryByRawDbIdAndEntityType(long r13, int r15) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MetaFullContentKeywordCopilot WHERE rawDbId = ? AND type = ?", 2);
        r0.bindLong(1, r13);
        r0.bindLong(2, r15);
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r0, false, null);
        int r14 = CursorUtil.getColumnIndexOrThrow(r12, OaidModel.KEY_ID);     // Catch: Throwable -> L14
        int r16 = CursorUtil.getColumnIndexOrThrow(r12, "type");     // Catch: Throwable -> L14
        int r1 = CursorUtil.getColumnIndexOrThrow(r12, "rawDbId");     // Catch: Throwable -> L14
        int r2 = CursorUtil.getColumnIndexOrThrow(r12, "uid");     // Catch: Throwable -> L14
        ArrayList r3 = new ArrayList(r12.getCount());     // Catch: Throwable -> L14
    L4:
        if (r12.moveToNext() == false) goto L12;
        long r6 = r12.getLong(r14);     // Catch: Throwable -> L14
        int r8 = r12.getInt(r16);     // Catch: Throwable -> L14
        long r9 = r12.getLong(r1);     // Catch: Throwable -> L14
        if (r12.isNull(r2) == false) goto L9;
        String r11 = null;
    L10:
        r3.add(new dl(r6, r8, r9, r11));     // Catch: Throwable -> L14
        goto L4
    L9:
        r11 = r12.getString(r2);     // Catch: Throwable -> L14
        goto L10
    L12:
        r12.close();
        r0.release();
        return r3;
    L14:
        th = move-exception;
        r12.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public List<dl> queryByRawDbIdAndEntityTypeAndUid(long r12, int r14, String r15) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MetaFullContentKeywordCopilot WHERE rawDbId = ? AND type = ? AND uid = ?", 3);
        r0.bindLong(1, r12);
        r0.bindLong(2, r14);
        if (r15 != null) goto L5;
        r0.bindNull(3);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.__db, r0, false, null);
        int r13 = CursorUtil.getColumnIndexOrThrow(r11, OaidModel.KEY_ID);     // Catch: Throwable -> L18
        int r16 = CursorUtil.getColumnIndexOrThrow(r11, "type");     // Catch: Throwable -> L18
        int r17 = CursorUtil.getColumnIndexOrThrow(r11, "rawDbId");     // Catch: Throwable -> L18
        int r1 = CursorUtil.getColumnIndexOrThrow(r11, "uid");     // Catch: Throwable -> L18
        ArrayList r2 = new ArrayList(r11.getCount());     // Catch: Throwable -> L18
    L8:
        if (r11.moveToNext() == false) goto L16;
        long r5 = r11.getLong(r13);     // Catch: Throwable -> L18
        int r7 = r11.getInt(r16);     // Catch: Throwable -> L18
        long r8 = r11.getLong(r17);     // Catch: Throwable -> L18
        if (r11.isNull(r1) == false) goto L13;
        String r10 = null;
    L14:
        r2.add(new dl(r5, r7, r8, r10));     // Catch: Throwable -> L18
        goto L8
    L13:
        r10 = r11.getString(r1);     // Catch: Throwable -> L18
        goto L14
    L16:
        r11.close();
        r0.release();
        return r2;
    L18:
        th = move-exception;
        r11.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(3, r15);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public List<dl> queryByRawDbIdsAndEntityType(List<Long> r14, int r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM MetaFullContentKeywordCopilot WHERE rawDbId IN (");
        int r2 = r16.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND type = ");
        r0.append("?");
        int r3 = r2 + 1;
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r3);
        Iterator r17 = r16.iterator();
        int r4 = 1;
    L4:
        if (r17.hasNext() == false) goto L6;
        r1.bindLong(r4, ((Long) ZeusTransformUtils.preCheckCast(r17.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r4 = r4 + 1;
        goto L4
    L6:
        r1.bindLong(r3, r15);
        this.__db.assertNotSuspendingTransaction();
        Cursor r13 = DBUtil.query(this.__db, r1, false, null);
        int r18 = CursorUtil.getColumnIndexOrThrow(r13, OaidModel.KEY_ID);     // Catch: Throwable -> L18
        int r5 = CursorUtil.getColumnIndexOrThrow(r13, "type");     // Catch: Throwable -> L18
        int r6 = CursorUtil.getColumnIndexOrThrow(r13, "rawDbId");     // Catch: Throwable -> L18
        int r7 = CursorUtil.getColumnIndexOrThrow(r13, "uid");     // Catch: Throwable -> L18
        ArrayList r8 = new ArrayList(r13.getCount());     // Catch: Throwable -> L18
    L8:
        if (r13.moveToNext() == false) goto L16;
        long r9 = r13.getLong(r18);     // Catch: Throwable -> L18
        int r10 = r13.getInt(r5);     // Catch: Throwable -> L18
        long r11 = r13.getLong(r6);     // Catch: Throwable -> L18
        if (r13.isNull(r7) == false) goto L13;
        String r12 = null;
    L14:
        r8.add(new dl(r9, r10, r11, r12));     // Catch: Throwable -> L18
        goto L8
    L13:
        r12 = r13.getString(r7);     // Catch: Throwable -> L18
        goto L14
    L16:
        r13.close();
        r1.release();
        return r8;
    L18:
        th = move-exception;
        r13.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public List<dl> queryByRawDbIdsAndEntityTypeAndUid(List<Long> r13, int r14, String r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM MetaFullContentKeywordCopilot WHERE rawDbId IN (");
        int r2 = r16.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") AND type = ");
        r0.append("?");
        r0.append(" AND uid = ");
        r0.append("?");
        int r3 = r2 + 2;
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r3);
        Iterator r17 = r16.iterator();
        int r5 = 1;
    L4:
        if (r17.hasNext() == false) goto L6;
        r1.bindLong(r5, ((Long) ZeusTransformUtils.preCheckCast(r17.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r5 = r5 + 1;
        goto L4
    L6:
        r1.bindLong(r2 + 1, r14);
        if (r15 != null) goto L9;
        r1.bindNull(r3);
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r1, false, null);
        int r18 = CursorUtil.getColumnIndexOrThrow(r12, OaidModel.KEY_ID);     // Catch: Throwable -> L22
        int r19 = CursorUtil.getColumnIndexOrThrow(r12, "type");     // Catch: Throwable -> L22
        int r4 = CursorUtil.getColumnIndexOrThrow(r12, "rawDbId");     // Catch: Throwable -> L22
        int r6 = CursorUtil.getColumnIndexOrThrow(r12, "uid");     // Catch: Throwable -> L22
        ArrayList r7 = new ArrayList(r12.getCount());     // Catch: Throwable -> L22
    L12:
        if (r12.moveToNext() == false) goto L20;
        long r8 = r12.getLong(r18);     // Catch: Throwable -> L22
        int r9 = r12.getInt(r19);     // Catch: Throwable -> L22
        long r10 = r12.getLong(r4);     // Catch: Throwable -> L22
        if (r12.isNull(r6) == false) goto L17;
        String r11 = null;
    L18:
        r7.add(new dl(r8, r9, r10, r11));     // Catch: Throwable -> L22
        goto L12
    L17:
        r11 = r12.getString(r6);     // Catch: Throwable -> L22
        goto L18
    L20:
        r12.close();
        r1.release();
        return r7;
    L22:
        th = move-exception;
        r12.close();
        r1.release();
        throw th;
    L9:
        r1.bindString(r3, r15);
        goto L10
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dl queryByUUID(String r1) {
        return MetaFullContentKeywordCopilotDao.DefaultImpls.queryByUUID(this, r1);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dl queryByUUID(String r1) {
        return queryByUUID(r1);
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public List<Long> queryIdsByEntityTypeAndUids(int r7, List<String> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT id FROM MetaFullContentKeywordCopilot WHERE type = ");
        r0.append("?");
        r0.append(" AND uid IN (");
        int r2 = r9.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 1);
        r1.bindLong(1, r7);
        Iterator r10 = r9.iterator();
        int r11 = 2;
    L4:
        if (r10.hasNext() == false) goto L10;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L8;
        r1.bindNull(r11);
    L9:
        r11 = r11 + 1;
        goto L4
    L8:
        r1.bindString(r11, r3);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r1, false, null);
        ArrayList r12 = new ArrayList(r6.getCount());     // Catch: Throwable -> L18
    L13:
        if (r6.moveToNext() == false) goto L16;
        r12.add(Long.valueOf(r6.getLong(0)));     // Catch: Throwable -> L18
        goto L13
    L16:
        r6.close();
        r1.release();
        return r12;
    L18:
        th = move-exception;
        r6.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public List<Long> queryIdsByUids(List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT id FROM MetaFullContentKeywordCopilot WHERE uid IN (");
        int r2 = r8.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r9 = r8.iterator();
        int r3 = 1;
    L4:
        if (r9.hasNext() == false) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r1.bindNull(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r1.bindString(r3, r4);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r1, false, null);
        ArrayList r10 = new ArrayList(r6.getCount());     // Catch: Throwable -> L18
    L13:
        if (r6.moveToNext() == false) goto L16;
        r10.add(Long.valueOf(r6.getLong(0)));     // Catch: Throwable -> L18
        goto L13
    L16:
        r6.close();
        r1.release();
        return r10;
    L18:
        th = move-exception;
        r6.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public List<dl> queryLegacyRows() {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MetaFullContentKeywordCopilot WHERE uid = ''", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r15 = DBUtil.query(this.__db, r0, false, null);
        int r1 = CursorUtil.getColumnIndexOrThrow(r15, OaidModel.KEY_ID);     // Catch: Throwable -> L14
        int r3 = CursorUtil.getColumnIndexOrThrow(r15, "type");     // Catch: Throwable -> L14
        int r4 = CursorUtil.getColumnIndexOrThrow(r15, "rawDbId");     // Catch: Throwable -> L14
        int r5 = CursorUtil.getColumnIndexOrThrow(r15, "uid");     // Catch: Throwable -> L14
        ArrayList r6 = new ArrayList(r15.getCount());     // Catch: Throwable -> L14
    L4:
        if (r15.moveToNext() == false) goto L12;
        long r9 = r15.getLong(r1);     // Catch: Throwable -> L14
        int r11 = r15.getInt(r3);     // Catch: Throwable -> L14
        long r12 = r15.getLong(r4);     // Catch: Throwable -> L14
        if (r15.isNull(r5) == false) goto L9;
        String r14 = null;
    L10:
        r6.add(new dl(r9, r11, r12, r14));     // Catch: Throwable -> L14
        goto L4
    L9:
        r14 = r15.getString(r5);     // Catch: Throwable -> L14
        goto L10
    L12:
        r15.close();
        r0.release();
        return r6;
    L14:
        th = move-exception;
        r15.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public List<dl> queryLegacyRowsByEntityType(int r15) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MetaFullContentKeywordCopilot WHERE type = ? AND uid = ''", 1);
        r0.bindLong(1, r15);
        this.__db.assertNotSuspendingTransaction();
        Cursor r14 = DBUtil.query(this.__db, r0, false, null);
        int r16 = CursorUtil.getColumnIndexOrThrow(r14, OaidModel.KEY_ID);     // Catch: Throwable -> L14
        int r2 = CursorUtil.getColumnIndexOrThrow(r14, "type");     // Catch: Throwable -> L14
        int r3 = CursorUtil.getColumnIndexOrThrow(r14, "rawDbId");     // Catch: Throwable -> L14
        int r4 = CursorUtil.getColumnIndexOrThrow(r14, "uid");     // Catch: Throwable -> L14
        ArrayList r5 = new ArrayList(r14.getCount());     // Catch: Throwable -> L14
    L4:
        if (r14.moveToNext() == false) goto L12;
        long r8 = r14.getLong(r16);     // Catch: Throwable -> L14
        int r10 = r14.getInt(r2);     // Catch: Throwable -> L14
        long r11 = r14.getLong(r3);     // Catch: Throwable -> L14
        if (r14.isNull(r4) == false) goto L9;
        String r13 = null;
    L10:
        r5.add(new dl(r8, r10, r11, r13));     // Catch: Throwable -> L14
        goto L4
    L9:
        r13 = r14.getString(r4);     // Catch: Throwable -> L14
        goto L10
    L12:
        r14.close();
        r0.release();
        return r5;
    L14:
        th = move-exception;
        r14.close();
        r0.release();
        throw th;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.database.dao.BaseDao
    public dl queryOne() {
        return MetaFullContentKeywordCopilotDao.DefaultImpls.queryOne(this);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* bridge */ /* synthetic */ dl queryOne() {
        return queryOne();
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public List<Long> queryRawDbIdsByEntityType(int r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT rawDbId FROM MetaFullContentKeywordCopilot WHERE type = ?", 1);
        r0.bindLong(1, r5);
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r1 = new ArrayList(r4.getCount());     // Catch: Throwable -> L10
    L5:
        if (r4.moveToNext() == false) goto L8;
        r1.add(Long.valueOf(r4.getLong(0)));     // Catch: Throwable -> L10
        goto L5
    L8:
        r4.close();
        r0.release();
        return r1;
    L10:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public List<Long> queryRawDbIdsByEntityTypeAndUid(int r5, String r6) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT rawDbId FROM MetaFullContentKeywordCopilot WHERE type = ? AND uid = ?", 2);
        r0.bindLong(1, r5);
        if (r6 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
        ArrayList r7 = new ArrayList(r4.getCount());     // Catch: Throwable -> L14
    L9:
        if (r4.moveToNext() == false) goto L12;
        r7.add(Long.valueOf(r4.getLong(0)));     // Catch: Throwable -> L14
        goto L9
    L12:
        r4.close();
        r0.release();
        return r7;
    L14:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(2, r6);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public List<dl> queryRowsByUid(String r15) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MetaFullContentKeywordCopilot WHERE uid = ?", 1);
        if (r15 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r14 = DBUtil.query(this.__db, r0, false, null);
        int r16 = CursorUtil.getColumnIndexOrThrow(r14, OaidModel.KEY_ID);     // Catch: Throwable -> L18
        int r2 = CursorUtil.getColumnIndexOrThrow(r14, "type");     // Catch: Throwable -> L18
        int r3 = CursorUtil.getColumnIndexOrThrow(r14, "rawDbId");     // Catch: Throwable -> L18
        int r4 = CursorUtil.getColumnIndexOrThrow(r14, "uid");     // Catch: Throwable -> L18
        ArrayList r5 = new ArrayList(r14.getCount());     // Catch: Throwable -> L18
    L8:
        if (r14.moveToNext() == false) goto L16;
        long r8 = r14.getLong(r16);     // Catch: Throwable -> L18
        int r10 = r14.getInt(r2);     // Catch: Throwable -> L18
        long r11 = r14.getLong(r3);     // Catch: Throwable -> L18
        if (r14.isNull(r4) == false) goto L13;
        String r13 = null;
    L14:
        r5.add(new dl(r8, r10, r11, r13));     // Catch: Throwable -> L18
        goto L8
    L13:
        r13 = r14.getString(r4);     // Catch: Throwable -> L18
        goto L14
    L16:
        r14.close();
        r0.release();
        return r5;
    L18:
        th = move-exception;
        r14.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r15);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dl> queryWithLimitAndOffset(int r1, int r2) {
        return MetaFullContentKeywordCopilotDao.DefaultImpls.queryWithLimitAndOffset(this, r1, r2);
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<dl> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityMetaFullContentKeywordCopilotEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(dl r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMetaFullContentKeywordCopilotEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(dl r3) {
        return update2((dl) ZeusTransformUtils.preCheckCast(r3, dl.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<dl> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMetaFullContentKeywordCopilotEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao
    public int updateUidByIds(List<Long> r6, String r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE MetaFullContentKeywordCopilot SET uid = ");
        r0.append("?");
        r0.append(" WHERE id IN (");
        StringUtil.appendPlaceholders(r0, r8.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        if (r7 != null) goto L5;
        r2.bindNull(1);
    L6:
        int r9 = 2;
        Iterator r10 = r8.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r2.bindLong(r9, ((Long) ZeusTransformUtils.preCheckCast(r10.next(), Long.class, "com.obric.memorydata.plugin")).longValue());
        r9 = r9 + 1;
        goto L8
    L10:
        this.__db.beginTransaction();
        int r11 = r2.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        return r11;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L5:
        r2.bindString(1, r7);
        goto L6
    }
}
