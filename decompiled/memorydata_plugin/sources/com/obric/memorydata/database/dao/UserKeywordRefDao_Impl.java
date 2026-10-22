package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.jd;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UserKeywordRefDao_Impl implements UserKeywordRefDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<jd> __insertionAdapterOfUserKeywordRefEntity;

    public UserKeywordRefDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfUserKeywordRefEntity = new AnonymousClass1(this, r2);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.UserKeywordRefDao
    public int deleteBySemanticEntityIdAndKeywordIds(String r6, List<Long> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM UserKeywordRef WHERE semantic_entity_id = ");
        r0.append("?");
        r0.append(" AND keyword_id IN (");
        StringUtil.appendPlaceholders(r0, r8.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        if (r6 != null) goto L5;
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
        r2.bindString(1, r6);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.UserKeywordRefDao
    public long insertIfAbsent(jd r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfUserKeywordRefEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.UserKeywordRefDao
    public int moveToKeeper(List<String> r5, String r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.__db.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("UPDATE OR IGNORE UserKeywordRef SET semantic_entity_id = ");
        r0.append("?");
        r0.append(" WHERE semantic_entity_id IN (");
        StringUtil.appendPlaceholders(r0, r7.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.__db.compileStatement(r1);
        if (r6 != null) goto L5;
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
        r2.bindString(1, r6);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.UserKeywordRefDao
    public List<jd> queryBySemanticEntityId(String r13) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT * FROM UserKeywordRef WHERE semantic_entity_id = ?", 1);
        if (r13 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r0, false, null);
        int r14 = CursorUtil.getColumnIndexOrThrow(r12, OaidModel.KEY_ID);     // Catch: Throwable -> L18
        int r2 = CursorUtil.getColumnIndexOrThrow(r12, "keyword_id");     // Catch: Throwable -> L18
        int r3 = CursorUtil.getColumnIndexOrThrow(r12, "semantic_entity_id");     // Catch: Throwable -> L18
        ArrayList r4 = new ArrayList(r12.getCount());     // Catch: Throwable -> L18
    L8:
        if (r12.moveToNext() == false) goto L16;
        long r7 = r12.getLong(r14);     // Catch: Throwable -> L18
        long r9 = r12.getLong(r2);     // Catch: Throwable -> L18
        if (r12.isNull(r3) == false) goto L13;
        String r11 = null;
    L14:
        r4.add(new jd(r7, r9, r11));     // Catch: Throwable -> L18
        goto L8
    L13:
        r11 = r12.getString(r3);     // Catch: Throwable -> L18
        goto L14
    L16:
        r12.close();
        r0.release();
        return r4;
    L18:
        th = move-exception;
        r12.close();
        r0.release();
        throw th;
    L5:
        r0.bindString(1, r13);
        goto L6
    }
}
