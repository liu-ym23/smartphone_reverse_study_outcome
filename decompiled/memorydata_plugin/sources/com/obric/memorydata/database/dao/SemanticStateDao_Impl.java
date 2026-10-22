package com.obric.memorydata.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.memorydata.database.entity.ik;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.flow.i;

/* JADX INFO: loaded from: classes4.dex */
public final class SemanticStateDao_Impl implements SemanticStateDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ik> __insertionAdapterOfSemanticStateEntity;
    private final SharedSQLiteStatement __preparedStmtOfIncrement;
    private final SharedSQLiteStatement __preparedStmtOfUpdateNum;
    private final SharedSQLiteStatement __preparedStmtOfUpdateNumIfExpected;
    private final SharedSQLiteStatement __preparedStmtOfUpdateText;

    public SemanticStateDao_Impl(final RoomDatabase r2) {
        this.__db = r2;
        this.__insertionAdapterOfSemanticStateEntity = new AnonymousClass1(this, r2);
        this.__preparedStmtOfIncrement = new AnonymousClass2(this, r2);
        this.__preparedStmtOfUpdateNum = new AnonymousClass3(this, r2);
        this.__preparedStmtOfUpdateText = new AnonymousClass4(this, r2);
        this.__preparedStmtOfUpdateNumIfExpected = new AnonymousClass5(this, r2);
    }

    static /* synthetic */ RoomDatabase access$000(SemanticStateDao_Impl r0) {
        return r0.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.obric.memorydata.database.dao.SemanticStateDao
    public int countKeys(List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT COUNT(*) FROM SemanticState WHERE `key` IN (");
        int r2 = r8.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        int r3 = 0;
        RoomSQLiteQuery r1 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator r9 = r8.iterator();
        int r4 = 1;
    L4:
        if (r9.hasNext() == false) goto L10;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L8;
        r1.bindNull(r4);
    L9:
        r4 = r4 + 1;
        goto L4
    L8:
        r1.bindString(r4, r5);
        goto L9
    L10:
        this.__db.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.__db, r1, false, null);
    L16:
        th = move-exception;
        r6.close();
        r1.release();
        throw th;
    L12:
        if (r6.moveToFirst() == false) goto L14;
        r3 = r6.getInt(0);     // Catch: Throwable -> L16
    L14:
        r6.close();
        r1.release();
        return r3;
    }

    @Override // com.obric.memorydata.database.dao.SemanticStateDao
    public int increment(String r3) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfIncrement.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfIncrement.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfIncrement.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SemanticStateDao
    public long insertIfAbsent(ik r3) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        long r0 = this.__insertionAdapterOfSemanticStateEntity.insertAndReturnId(r3);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return r0;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // com.obric.memorydata.database.dao.SemanticStateDao
    public Long minNum(List<String> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT MIN(num) FROM SemanticState WHERE `key` IN (");
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
        Long r10 = null;
        Cursor r6 = DBUtil.query(this.__db, r1, false, null);
    L19:
        th = move-exception;
        r6.close();
        r1.release();
        throw th;
    L12:
        if (r6.moveToFirst() == true) goto L14;
    L17:
        r6.close();
        r1.release();
        return r10;
    L14:
        if (r6.isNull(0) == true) goto L17;
        r10 = Long.valueOf(r6.getLong(0));     // Catch: Throwable -> L19
        goto L17
    }

    @Override // com.obric.memorydata.database.dao.SemanticStateDao
    public i<String> observeText(String r5) {
        final RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT txt FROM SemanticState WHERE `key` = ? LIMIT 1", 1);
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"SemanticState"}, new AnonymousClass6(this, r0));
    L5:
        r0.bindString(1, r5);
        goto L7
    }

    @Override // com.obric.memorydata.database.dao.SemanticStateDao
    public Long queryNum(String r4) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT num FROM SemanticState WHERE `key` = ? LIMIT 1", 1);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Long r1 = null;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L15:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L8:
        if (r3.moveToFirst() == true) goto L10;
    L13:
        r3.close();
        r0.release();
        return r1;
    L10:
        if (r3.isNull(0) == true) goto L13;
        r1 = Long.valueOf(r3.getLong(0));     // Catch: Throwable -> L15
        goto L13
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SemanticStateDao
    public String queryText(String r4) {
        RoomSQLiteQuery r0 = RoomSQLiteQuery.acquire("SELECT txt FROM SemanticState WHERE `key` = ? LIMIT 1", 1);
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        String r1 = null;
        Cursor r3 = DBUtil.query(this.__db, r0, false, null);
    L15:
        th = move-exception;
        r3.close();
        r0.release();
        throw th;
    L8:
        if (r3.moveToFirst() == true) goto L10;
    L13:
        r3.close();
        r0.release();
        return r1;
    L10:
        if (r3.isNull(0) == true) goto L13;
        r1 = r3.getString(0);     // Catch: Throwable -> L15
        goto L13
    L5:
        r0.bindString(1, r4);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SemanticStateDao
    public int updateNum(String r3, long r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateNum.acquire();
        r0.bindLong(1, r4);
        if (r3 != null) goto L5;
        r0.bindNull(2);
    L6:
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateNum.release(r0);
        return r5;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateNum.release(r0);
        throw th;
    L5:
        r0.bindString(2, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SemanticStateDao
    public int updateNumIfExpected(String r3, long r4, long r6) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateNumIfExpected.acquire();
        r0.bindLong(1, r6);
        if (r3 != null) goto L5;
        r0.bindNull(2);
    L6:
        r0.bindLong(3, r4);
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateNumIfExpected.release(r0);
        return r5;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateNumIfExpected.release(r0);
        throw th;
    L5:
        r0.bindString(2, r3);
        goto L6
    }

    @Override // com.obric.memorydata.database.dao.SemanticStateDao
    public int updateText(String r3, String r4) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.__preparedStmtOfUpdateText.acquire();
        if (r4 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r3 != null) goto L9;
        r0.bindNull(2);
    L10:
        this.__db.beginTransaction();
        int r5 = r0.executeUpdateDelete();     // Catch: Throwable -> L14
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateText.release(r0);
        return r5;
    L14:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfUpdateText.release(r0);
        throw th;
    L9:
        r0.bindString(2, r3);
        goto L10
    L5:
        r0.bindString(1, r4);
        goto L7
    }
}
