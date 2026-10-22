package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Data;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WorkProgressDao_Impl implements WorkProgressDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkProgress> __insertionAdapterOfWorkProgress;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public WorkProgressDao_Impl(final RoomDatabase r10) {
        this.__db = r10;
        this.__insertionAdapterOfWorkProgress = new AnonymousClass1(this, r10);
        this.__preparedStmtOfDelete = new AnonymousClass2(this, r10);
        this.__preparedStmtOfDeleteAll = new AnonymousClass3(this, r10);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void delete(String r10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r11 = this.__preparedStmtOfDelete.acquire();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDelete.release(r11);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDelete.release(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r10 = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        r10.executeUpdateDelete();     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r10);
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteAll.release(r10);
        throw th;
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public Data getProgressForWorkSpecId(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT progress FROM WorkProgress WHERE work_spec_id=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Data r12 = null;
        Cursor r13 = DBUtil.query(this.__db, r11, false, null);
    L19:
        th = move-exception;
        r13.close();
        r11.release();
        throw th;
    L8:
        if (r13.moveToFirst() == true) goto L10;
    L17:
        r13.close();
        r11.release();
        return r12;
    L10:
        if (r13.isNull(0) == false) goto L12;
        byte[] r14 = null;
    L13:
        if (r14 == null) goto L17;
        r12 = Data.fromByteArray(r14);     // Catch: Throwable -> L19
        goto L17
    L12:
        r14 = r13.getBlob(0);     // Catch: Throwable -> L19
        goto L13
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void insert(WorkProgress r10) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfWorkProgress.insert(r10);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
