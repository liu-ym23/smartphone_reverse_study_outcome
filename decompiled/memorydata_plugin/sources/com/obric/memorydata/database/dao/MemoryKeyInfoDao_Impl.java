package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.obric.memorydata.database.manager.w;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryKeyInfoDao_Impl extends MemoryKeyInfoDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<MemoryKeyInfoEntity> __deletionAdapterOfMemoryKeyInfoEntity;
    private final EntityInsertionAdapter<MemoryKeyInfoEntity> __insertionAdapterOfMemoryKeyInfoEntity;
    private final EntityInsertionAdapter<MemoryKeyInfoEntity> __insertionAdapterOfMemoryKeyInfoEntity_1;
    private final SharedSQLiteStatement __preparedStmtOfBatchDeleteBySourceId;
    private final EntityDeletionOrUpdateAdapter<MemoryKeyInfoEntity> __updateAdapterOfMemoryKeyInfoEntity;

    public MemoryKeyInfoDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemoryKeyInfoEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfMemoryKeyInfoEntity_1 = new AnonymousClass2(this, r2);
        this.__deletionAdapterOfMemoryKeyInfoEntity = new AnonymousClass3(this, r2);
        this.__updateAdapterOfMemoryKeyInfoEntity = new AnonymousClass4(this, r2);
        this.__preparedStmtOfBatchDeleteBySourceId = new AnonymousClass5(this, r2);
    }

    private MemoryKeyInfoEntity __entityCursorConverter_comObricMemorydataDatabaseEntityMemoryKeyInfoEntity(Cursor r13) {
        Cursor r12 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r13, Cursor.class, "com.obric.memorydata.plugin");
        int r14 = CursorUtil.getColumnIndex(r12, OaidModel.KEY_ID);
        int r0 = CursorUtil.getColumnIndex(r12, "sourceEntityId");
        int r1 = CursorUtil.getColumnIndex(r12, "key");
        int r2 = CursorUtil.getColumnIndex(r12, EventBody.KEY_VALUE);
        if (r14 != (-1)) goto L5;
        long r4 = 0;
    L6:
        long r7 = r4;
        String r15 = null;
        if (r0 != (-1)) goto L10;
    L8:
        String r9 = null;
    L13:
        if (r1 != (-1)) goto L16;
    L14:
        String r10 = null;
    L19:
        if (r2 != (-1)) goto L22;
        Set<String> r11 = null;
    L27:
        return new MemoryKeyInfoEntity(r7, r9, r10, r11);
    L22:
        if (r12.isNull(r2) == true) goto L25;
        r15 = r12.getString(r2);
    L25:
        w r16 = w.f9604a;
        r11 = w.a(r15);
        goto L27
    L16:
        if (r12.isNull(r1) == true) goto L14;
        r10 = r12.getString(r1);
        goto L19
    L10:
        if (r12.isNull(r0) == true) goto L8;
        r9 = r12.getString(r0);
        goto L13
    L5:
        r4 = r12.getLong(r14);
        goto L6
    }

    static /* synthetic */ List access$001(MemoryKeyInfoDao_Impl r2, List r3) {
        return super.batchUpsert((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ List access$101(MemoryKeyInfoDao_Impl r2, String r3, Map r4) {
        return super.batchUpsertManual(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ List access$201(MemoryKeyInfoDao_Impl r2, String r3, String r4, Collection r5) {
        return super.batchUpsertManual(r3, r4, (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ List access$301(MemoryKeyInfoDao_Impl r2, List r3) {
        return super.batchInsert((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ int access$401(MemoryKeyInfoDao_Impl r2, List r3) {
        return super.batchUpdateOptimized((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ RoomDatabase access$500(MemoryKeyInfoDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public int batchDeleteByKeys(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM MemoryKeyInfoEntity WHERE `key` IN (");
        StringUtil.appendPlaceholders(r0, r7.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        Iterator r8 = r7.iterator();
        int r3 = 1;
    L4:
        if (r8.hasNext() == false) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L8;
        r2.bindNull(r3);
    L9:
        r3 = r3 + 1;
        goto L4
    L8:
        r2.bindString(r3, r4);
        goto L9
    L10:
        this.__db.beginTransaction();
        int r9 = r2.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        return r9;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public int batchDeleteBySourceId(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfBatchDeleteBySourceId.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfBatchDeleteBySourceId.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfBatchDeleteBySourceId.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public int batchDeleteBySourceIdAndKeys(String r5, List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM MemoryKeyInfoEntity WHERE sourceEntityId = ");
        r0.append("?");
        r0.append(" AND `key` IN (");
        StringUtil.appendPlaceholders(r0, r7.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        if (r5 != null) goto L5;
        r2.bindNull(1);
    L6:
        int r8 = 2;
        Iterator r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L14;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L12;
        r2.bindNull(r8);
    L13:
        r8 = r8 + 1;
        goto L8
    L12:
        r2.bindString(r8, r3);
        goto L13
    L14:
        this.__db.beginTransaction();
        int r10 = r2.executeUpdateDelete();     // Catch: Throwable -> L18
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L18
        this.__db.endTransaction();
        return r10;
    L18:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L5:
        r2.bindString(1, r5);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public List<Long> batchInsert(List<MemoryKeyInfoEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        List<Long> r5 = access$301(this, r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public List<MemoryKeyInfoEntity> batchQueryByKeys(List<String> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM MemoryKeyInfoEntity WHERE `key` IN (");
        int r2 = r16.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r17 = r16.iterator();
        int r3 = 1;
    L4:
        if (r17.hasNext() == false) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");
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
        this.__db.beginTransaction();
        Cursor r18 = DBUtil.query(this.__db, r1, false, null);     // Catch: Throwable -> L35
        int r5 = CursorUtil.getColumnIndexOrThrow(r18, OaidModel.KEY_ID);     // Catch: Throwable -> L32
        int r6 = CursorUtil.getColumnIndexOrThrow(r18, "sourceEntityId");     // Catch: Throwable -> L32
        int r7 = CursorUtil.getColumnIndexOrThrow(r18, "key");     // Catch: Throwable -> L32
        int r8 = CursorUtil.getColumnIndexOrThrow(r18, EventBody.KEY_VALUE);     // Catch: Throwable -> L32
        ArrayList r9 = new ArrayList(r18.getCount());     // Catch: Throwable -> L32
    L14:
        if (r18.moveToNext() == false) goto L28;
        long r10 = r18.getLong(r5);     // Catch: Throwable -> L32
        if (r18.isNull(r6) == false) goto L18;
        String r11 = null;
    L20:
        if (r18.isNull(r7) == false) goto L22;
        String r12 = null;
    L24:
        if (r18.isNull(r8) == false) goto L26;
        String r13 = null;
    L27:
        w r14 = w.f9604a;     // Catch: Throwable -> L32
        r9.add(new MemoryKeyInfoEntity(r10, r11, r12, w.a(r13)));     // Catch: Throwable -> L32
        goto L14
    L26:
        r13 = r18.getString(r8);     // Catch: Throwable -> L32
        goto L27
    L22:
        r12 = r18.getString(r7);     // Catch: Throwable -> L32
        goto L24
    L18:
        r11 = r18.getString(r6);     // Catch: Throwable -> L32
        goto L20
    L28:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L32
        r18.close();     // Catch: Throwable -> L35
        r1.release();     // Catch: Throwable -> L35
        this.__db.endTransaction();
        return r9;
    L32:
        th = move-exception;
        r18.close();     // Catch: Throwable -> L35
        r1.release();     // Catch: Throwable -> L35
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public List<MemoryKeyInfoEntity> batchQueryBySourceIdAndKeys(String r14, List<String> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM MemoryKeyInfoEntity WHERE sourceEntityId = ");
        r0.append("?");
        r0.append(" AND `key` IN (");
        int r2 = r16.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 1);
        if (r14 != null) goto L5;
        r1.bindNull(1);
    L6:
        int r17 = 2;
        Iterator r18 = r16.iterator();
    L8:
        if (r18.hasNext() == false) goto L14;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L12;
        r1.bindNull(r17);
    L13:
        r17 = r17 + 1;
        goto L8
    L12:
        r1.bindString(r17, r3);
        goto L13
    L14:
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        Cursor r19 = DBUtil.query(this.__db, r1, false, null);     // Catch: Throwable -> L39
        int r110 = CursorUtil.getColumnIndexOrThrow(r19, OaidModel.KEY_ID);     // Catch: Throwable -> L36
        int r4 = CursorUtil.getColumnIndexOrThrow(r19, "sourceEntityId");     // Catch: Throwable -> L36
        int r5 = CursorUtil.getColumnIndexOrThrow(r19, "key");     // Catch: Throwable -> L36
        int r6 = CursorUtil.getColumnIndexOrThrow(r19, EventBody.KEY_VALUE);     // Catch: Throwable -> L36
        ArrayList r7 = new ArrayList(r19.getCount());     // Catch: Throwable -> L36
    L18:
        if (r19.moveToNext() == false) goto L32;
        long r8 = r19.getLong(r110);     // Catch: Throwable -> L36
        if (r19.isNull(r4) == false) goto L22;
        String r10 = null;
    L24:
        if (r19.isNull(r5) == false) goto L26;
        String r11 = null;
    L28:
        if (r19.isNull(r6) == false) goto L30;
        String r9 = null;
    L31:
        w r12 = w.f9604a;     // Catch: Throwable -> L36
        r7.add(new MemoryKeyInfoEntity(r8, r10, r11, w.a(r9)));     // Catch: Throwable -> L36
        goto L18
    L30:
        r9 = r19.getString(r6);     // Catch: Throwable -> L36
        goto L31
    L26:
        r11 = r19.getString(r5);     // Catch: Throwable -> L36
        goto L28
    L22:
        r10 = r19.getString(r4);     // Catch: Throwable -> L36
        goto L24
    L32:
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L36
        r19.close();     // Catch: Throwable -> L39
        r1.release();     // Catch: Throwable -> L39
        this.__db.endTransaction();
        return r7;
    L36:
        th = move-exception;
        r19.close();     // Catch: Throwable -> L39
        r1.release();     // Catch: Throwable -> L39
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    L5:
        r1.bindString(1, r14);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public int batchUpdateOptimized(List<MemoryKeyInfoEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        int r5 = access$401(this, r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public List<Long> batchUpsert(List<MemoryKeyInfoEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        List<Long> r5 = access$001(this, r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public List<Long> batchUpsertManual(String r3, String r4, Collection<String> r5) {
        Collection r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        List<Long> r7 = access$201(this, r3, r4, r6);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r7;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public List<Long> batchUpsertManual(String r3, Map<String, ? extends Collection<String>> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        this.__db.beginTransaction();
        List<Long> r6 = access$101(this, r3, r5);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r6;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkDelete(List<MemoryKeyInfoEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__deletionAdapterOfMemoryKeyInfoEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void bulkInsert(List<MemoryKeyInfoEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfMemoryKeyInfoEntity.insert(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    /* JADX INFO: renamed from: delete, reason: avoid collision after fix types in other method */
    public int delete2(MemoryKeyInfoEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__deletionAdapterOfMemoryKeyInfoEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int delete(MemoryKeyInfoEntity r3) {
        return delete2((MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r3, MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public int executeRawQuery(SupportSQLiteQuery r3) {
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

    /* JADX INFO: renamed from: insert, reason: avoid collision after fix types in other method */
    public long insert2(MemoryKeyInfoEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryKeyInfoEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ long insert(MemoryKeyInfoEntity r3) {
        return insert2((MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r3, MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<Long> insertAll(List<MemoryKeyInfoEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryKeyInfoEntity.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public List<Long> insertOrReplaceAll(List<MemoryKeyInfoEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        List<Long> r5 = this.__insertionAdapterOfMemoryKeyInfoEntity_1.insertAndReturnIdsList(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r5;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public long insertSingle(MemoryKeyInfoEntity r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemoryKeyInfoEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public boolean isExistsBySourceIdAndKey(String r4, String r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT 1 FROM MemoryKeyInfoEntity WHERE sourceEntityId = ? AND `key` = ? LIMIT 1)", 2);
        boolean r2 = true;
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        if (r5 != null) goto L8;
        r0.bindNull(2);
    L9:
        this.__db.assertNotSuspendingTransaction();
        boolean r6 = false;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L19:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L11:
        if (r3.moveToFirst() == false) goto L17;
        if (r3.getInt(0) != 0) goto L16;
        r2 = false;
    L16:
        r6 = r2;
    L17:
        r3.close();
        r0.release();
        return r6;
    L8:
        r0.bindString(2, r5);
        goto L9
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public i<MemoryKeyInfoEntity> observeAddressBySourceId(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryKeyInfoEntity WHERE sourceEntityId = ? AND `key` = 'address'", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"MemoryKeyInfoEntity"}, new AnonymousClass10(this, r0));
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public i<List<MemoryKeyInfoEntity>> observeAddresses() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryKeyInfoEntity WHERE `key` = 'address'", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"MemoryKeyInfoEntity"}, new AnonymousClass6(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public i<List<MemoryKeyInfoEntity>> observeAllKeysBySourceIdFlow(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryKeyInfoEntity WHERE sourceEntityId = ?", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"MemoryKeyInfoEntity"}, new AnonymousClass15(this, r0));
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public i<List<MemoryKeyInfoEntity>> observeBySourceIdAndKeyTypes(String r5, List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM MemoryKeyInfoEntity WHERE sourceEntityId = ");
        r0.append("?");
        r0.append(" AND `key` IN (");
        int r2 = r7.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        final RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 1);
        if (r5 != null) goto L5;
        r1.bindNull(1);
    L6:
        int r8 = 2;
        Iterator r9 = r7.iterator();
    L8:
        if (r9.hasNext() == false) goto L15;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L12;
        r1.bindNull(r8);
    L13:
        r8 = r8 + 1;
        goto L8
    L12:
        r1.bindString(r8, r3);
        goto L13
    L15:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"MemoryKeyInfoEntity"}, new AnonymousClass14(this, r1));
    L5:
        r1.bindString(1, r5);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public i<MemoryKeyInfoEntity> observeIdentifierBySourceId(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryKeyInfoEntity WHERE sourceEntityId = ? AND `key` = 'identifier'", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"MemoryKeyInfoEntity"}, new AnonymousClass13(this, r0));
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public i<List<MemoryKeyInfoEntity>> observeIdentifiers() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryKeyInfoEntity WHERE `key` = 'identifier'", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"MemoryKeyInfoEntity"}, new AnonymousClass9(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public i<MemoryKeyInfoEntity> observePhoneBySourceId(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryKeyInfoEntity WHERE sourceEntityId = ? AND `key` = 'phone'", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"MemoryKeyInfoEntity"}, new AnonymousClass11(this, r0));
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public i<List<MemoryKeyInfoEntity>> observePhones() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryKeyInfoEntity WHERE `key` = 'phone'", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"MemoryKeyInfoEntity"}, new AnonymousClass7(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public i<MemoryKeyInfoEntity> observeUrlBySourceId(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryKeyInfoEntity WHERE sourceEntityId = ? AND `key` = 'url'", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"MemoryKeyInfoEntity"}, new AnonymousClass12(this, r0));
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public i<List<MemoryKeyInfoEntity>> observeUrls() {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryKeyInfoEntity WHERE `key` = 'url'", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"MemoryKeyInfoEntity"}, new AnonymousClass8(this, r0));
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public List<MemoryKeyInfoEntity> queryAllKeysBySourceId(String r14) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM MemoryKeyInfoEntity WHERE sourceEntityId = ?", 1);
        if (r14 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r13 = DBUtil.query(this.__db, r0, false, null);
        int r15 = CursorUtil.getColumnIndexOrThrow(r13, OaidModel.KEY_ID);     // Catch: Throwable -> L26
        int r2 = CursorUtil.getColumnIndexOrThrow(r13, "sourceEntityId");     // Catch: Throwable -> L26
        int r3 = CursorUtil.getColumnIndexOrThrow(r13, "key");     // Catch: Throwable -> L26
        int r4 = CursorUtil.getColumnIndexOrThrow(r13, EventBody.KEY_VALUE);     // Catch: Throwable -> L26
        ArrayList r5 = new ArrayList(r13.getCount());     // Catch: Throwable -> L26
    L8:
        if (r13.moveToNext() == false) goto L24;
        long r8 = r13.getLong(r15);     // Catch: Throwable -> L26
        if (r13.isNull(r2) == false) goto L13;
        String r10 = null;
    L15:
        if (r13.isNull(r3) == false) goto L17;
        String r11 = null;
    L19:
        if (r13.isNull(r4) == false) goto L21;
        String r6 = null;
    L22:
        w r7 = w.f9604a;     // Catch: Throwable -> L26
        r5.add(new MemoryKeyInfoEntity(r8, r10, r11, w.a(r6)));     // Catch: Throwable -> L26
        goto L8
    L21:
        r6 = r13.getString(r4);     // Catch: Throwable -> L26
        goto L22
    L17:
        r11 = r13.getString(r3);     // Catch: Throwable -> L26
        goto L19
    L13:
        r10 = r13.getString(r2);     // Catch: Throwable -> L26
        goto L15
    L24:
        r13.close();
        r0.release();
        return r5;
    L26:
        th = move-exception;
        r13.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r14);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public List<MemoryKeyInfoEntity> queryByKeyTypes(List<String> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM MemoryKeyInfoEntity WHERE `key` IN (");
        int r2 = r15.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r16 = r15.iterator();
        int r3 = 1;
    L4:
        if (r16.hasNext() == false) goto L10;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin");
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
        Cursor r13 = DBUtil.query(this.__db, r1, false, null);
        int r5 = CursorUtil.getColumnIndexOrThrow(r13, OaidModel.KEY_ID);     // Catch: Throwable -> L30
        int r6 = CursorUtil.getColumnIndexOrThrow(r13, "sourceEntityId");     // Catch: Throwable -> L30
        int r7 = CursorUtil.getColumnIndexOrThrow(r13, "key");     // Catch: Throwable -> L30
        int r8 = CursorUtil.getColumnIndexOrThrow(r13, EventBody.KEY_VALUE);     // Catch: Throwable -> L30
        ArrayList r9 = new ArrayList(r13.getCount());     // Catch: Throwable -> L30
    L12:
        if (r13.moveToNext() == false) goto L28;
        long r10 = r13.getLong(r5);     // Catch: Throwable -> L30
        if (r13.isNull(r6) == false) goto L17;
        String r11 = null;
    L19:
        if (r13.isNull(r7) == false) goto L21;
        String r12 = null;
    L23:
        if (r13.isNull(r8) == false) goto L25;
        String r17 = null;
    L26:
        w r18 = w.f9604a;     // Catch: Throwable -> L30
        r9.add(new MemoryKeyInfoEntity(r10, r11, r12, w.a(r17)));     // Catch: Throwable -> L30
        goto L12
    L25:
        r17 = r13.getString(r8);     // Catch: Throwable -> L30
        goto L26
    L21:
        r12 = r13.getString(r7);     // Catch: Throwable -> L30
        goto L23
    L17:
        r11 = r13.getString(r6);     // Catch: Throwable -> L30
        goto L19
    L28:
        r13.close();
        r1.release();
        return r9;
    L30:
        th = move-exception;
        r13.close();
        r1.release();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public List<MemoryKeyInfoEntity> queryBySourceIdAndKeyTypes(String r13, List<String> r14) {
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT * FROM MemoryKeyInfoEntity WHERE sourceEntityId = ");
        r0.append("?");
        r0.append(" AND `key` IN (");
        int r2 = r15.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 1);
        if (r13 != null) goto L5;
        r1.bindNull(1);
    L6:
        int r16 = 2;
        Iterator r17 = r15.iterator();
    L8:
        if (r17.hasNext() == false) goto L14;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L12;
        r1.bindNull(r16);
    L13:
        r16 = r16 + 1;
        goto L8
    L12:
        r1.bindString(r16, r3);
        goto L13
    L14:
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r1, false, null);
        int r18 = CursorUtil.getColumnIndexOrThrow(r12, OaidModel.KEY_ID);     // Catch: Throwable -> L34
        int r4 = CursorUtil.getColumnIndexOrThrow(r12, "sourceEntityId");     // Catch: Throwable -> L34
        int r5 = CursorUtil.getColumnIndexOrThrow(r12, "key");     // Catch: Throwable -> L34
        int r6 = CursorUtil.getColumnIndexOrThrow(r12, EventBody.KEY_VALUE);     // Catch: Throwable -> L34
        ArrayList r7 = new ArrayList(r12.getCount());     // Catch: Throwable -> L34
    L16:
        if (r12.moveToNext() == false) goto L32;
        long r8 = r12.getLong(r18);     // Catch: Throwable -> L34
        if (r12.isNull(r4) == false) goto L21;
        String r9 = null;
    L23:
        if (r12.isNull(r5) == false) goto L25;
        String r10 = null;
    L27:
        if (r12.isNull(r6) == false) goto L29;
        String r11 = null;
    L30:
        w r19 = w.f9604a;     // Catch: Throwable -> L34
        r7.add(new MemoryKeyInfoEntity(r8, r9, r10, w.a(r11)));     // Catch: Throwable -> L34
        goto L16
    L29:
        r11 = r12.getString(r6);     // Catch: Throwable -> L34
        goto L30
    L25:
        r10 = r12.getString(r5);     // Catch: Throwable -> L34
        goto L27
    L21:
        r9 = r12.getString(r4);     // Catch: Throwable -> L34
        goto L23
    L32:
        r12.close();
        r1.release();
        return r7;
    L34:
        th = move-exception;
        r12.close();
        r1.release();
        throw th;
    L5:
        r1.bindString(1, r13);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemoryKeyInfoDao
    public Long queryIdBySourceIdAndKey(String r4, String r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT id FROM MemoryKeyInfoEntity WHERE sourceEntityId = ? AND `key` = ? LIMIT 1", 2);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        if (r5 != null) goto L8;
        r0.bindNull(2);
    L9:
        this.__db.assertNotSuspendingTransaction();
        Long r6 = null;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L18:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L11:
        if (r3.moveToFirst() == true) goto L13;
    L16:
        r3.close();
        r0.release();
        return r6;
    L13:
        if (r3.isNull(0) == true) goto L16;
        r6 = Long.valueOf(r3.getLong(0));     // Catch: Throwable -> L18
        goto L16
    L8:
        r0.bindString(2, r5);
        goto L9
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public List<MemoryKeyInfoEntity> rawQuery(SupportSQLiteQuery r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r5, false, null);
        ArrayList r0 = new ArrayList(r6.getCount());     // Catch: Throwable -> L10
    L5:
        if (r6.moveToNext() == false) goto L8;
        r0.add(__entityCursorConverter_comObricMemorydataDatabaseEntityMemoryKeyInfoEntity(r6));     // Catch: Throwable -> L10
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
    public int update2(MemoryKeyInfoEntity r2) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        int r3 = this.__updateAdapterOfMemoryKeyInfoEntity.handle(r2) + 0;     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public /* synthetic */ int update(MemoryKeyInfoEntity r3) {
        return update2((MemoryKeyInfoEntity) ZeusTransformUtils.preCheckCast(r3, MemoryKeyInfoEntity.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.obric.memorydata.database.dao.BaseDao
    public void updateAll(List<MemoryKeyInfoEntity> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__updateAdapterOfMemoryKeyInfoEntity.handleMultiple(r4);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
