package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.memorydata.database.entity.dc;
import com.obric.memorydata.database.entity.dd;
import com.obric.memorydata.database.entity.de;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class MemorySourceImageRelationDao_Impl implements MemorySourceImageRelationDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<dc> __insertionAdapterOfMemorySourceEpisodicImageRelationEntity;
    private final EntityInsertionAdapter<de> __insertionAdapterOfMemorySourceSemanticImageRelationEntity;

    public MemorySourceImageRelationDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfMemorySourceEpisodicImageRelationEntity = new AnonymousClass1(this, r2);
        this.__insertionAdapterOfMemorySourceSemanticImageRelationEntity = new AnonymousClass2(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.MemorySourceImageRelationDao
    public int deleteEpisodicRelationsByMemoryIds(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM MemorySourceEpisodicImageRelation WHERE episodic_id IN (");
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

    @Override // com.obric.memorydata.database.dao.MemorySourceImageRelationDao
    public int deleteSemanticRelationsByMemoryIds(List<String> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM MemorySourceSemanticImageRelation WHERE semantic_id IN (");
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

    @Override // com.obric.memorydata.database.dao.MemorySourceImageRelationDao
    public long insertEpisodicRelation(dc r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemorySourceEpisodicImageRelationEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemorySourceImageRelationDao
    public long insertSemanticRelation(de r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfMemorySourceSemanticImageRelationEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.MemorySourceImageRelationDao
    public dd queryLatestStatusByHash(String r5) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT source_image_hash, remembered_time FROM (SELECT rel.source_image_hash, rel.remembered_time FROM MemorySourceEpisodicImageRelation rel INNER JOIN ShortMemory memory ON rel.episodic_id = memory.entityId WHERE rel.source_image_hash = ? UNION ALL SELECT rel.source_image_hash, rel.remembered_time FROM MemorySourceSemanticImageRelation rel INNER JOIN UnionSemanticMemory memory ON rel.semantic_id = memory.entityId WHERE rel.source_image_hash = ?) ORDER BY remembered_time DESC LIMIT 1", 2);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L6:
        if (r5 != null) goto L8;
        r0.bindNull(2);
    L9:
        this.__db.assertNotSuspendingTransaction();
        dd r1 = null;
        String r2 = null;
        Cursor r4 = DBUtil.query(this.__db, r0, false, null);
    L20:
        th = move-exception;
        r4.close();
        r0.release();
        throw th;
    L11:
        if (r4.moveToFirst() == true) goto L13;
    L18:
        r4.close();
        r0.release();
        return r1;
    L13:
        if (r4.isNull(0) == true) goto L16;
        r2 = r4.getString(0);     // Catch: Throwable -> L20
    L16:
        r1 = new dd(r2, r4.getLong(1));     // Catch: Throwable -> L20
        goto L18
    L8:
        r0.bindString(2, r5);
        goto L9
    L5:
        r0.bindString(1, r5);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.MemorySourceImageRelationDao
    public List<dd> queryLatestStatusByHashes(List<String> r9) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT source_image_hash, MAX(remembered_time) AS remembered_time FROM (SELECT rel.source_image_hash, rel.remembered_time FROM MemorySourceEpisodicImageRelation rel INNER JOIN ShortMemory memory ON rel.episodic_id = memory.entityId WHERE rel.source_image_hash IN (");
        int r2 = r10.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(") UNION ALL SELECT rel.source_image_hash, rel.remembered_time FROM MemorySourceSemanticImageRelation rel INNER JOIN UnionSemanticMemory memory ON rel.semantic_id = memory.entityId WHERE rel.source_image_hash IN (");
        int r3 = r10.size();
        StringUtil.appendPlaceholders(r0, r3);
        r0.append(")) GROUP BY source_image_hash");
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), (r2 + 0) + r3);
        Iterator r4 = r10.iterator();
        int r5 = 1;
    L4:
        if (r4.hasNext() == false) goto L10;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L8;
        r1.bindNull(r5);
    L9:
        r5 = r5 + 1;
        goto L4
    L8:
        r1.bindString(r5, r6);
        goto L9
    L10:
        int r7 = r2 + 1;
        Iterator r11 = r10.iterator();
    L12:
        if (r11.hasNext() == false) goto L18;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L16;
        r1.bindNull(r7);
    L17:
        r7 = r7 + 1;
        goto L12
    L16:
        r1.bindString(r7, r8);
        goto L17
    L18:
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r1, false, null);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L30
    L20:
        if (r12.moveToNext() == false) goto L28;
        if (r12.isNull(0) == false) goto L25;
        String r14 = null;
    L26:
        r13.add(new dd(r14, r12.getLong(1)));     // Catch: Throwable -> L30
        goto L20
    L25:
        r14 = r12.getString(0);     // Catch: Throwable -> L30
        goto L26
    L28:
        r12.close();
        r1.release();
        return r13;
    L30:
        th = move-exception;
        r12.close();
        r1.release();
        throw th;
    }
}
