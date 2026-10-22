package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class WorkTagDao_Impl implements WorkTagDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkTag> __insertionAdapterOfWorkTag;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByWorkSpecId;

    public WorkTagDao_Impl(final RoomDatabase r10) {
        this.__db = r10;
        this.__insertionAdapterOfWorkTag = new AnonymousClass1(this, r10);
        this.__preparedStmtOfDeleteByWorkSpecId = new AnonymousClass2(this, r10);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public void deleteByWorkSpecId(String r10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r11 = this.__preparedStmtOfDeleteByWorkSpecId.acquire();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByWorkSpecId.release(r11);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByWorkSpecId.release(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public List<String> getTagsForWorkSpecId(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r11, false, null);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L18
    L8:
        if (r12.moveToNext() == false) goto L16;
        if (r12.isNull(0) == false) goto L13;
        String r14 = null;
    L14:
        r13.add(r14);     // Catch: Throwable -> L18
        goto L8
    L13:
        r14 = r12.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r12.close();
        r11.release();
        return r13;
    L18:
        th = move-exception;
        r12.close();
        r11.release();
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public List<String> getWorkSpecIdsWithTag(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT work_spec_id FROM worktag WHERE tag=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Cursor r12 = DBUtil.query(this.__db, r11, false, null);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L18
    L8:
        if (r12.moveToNext() == false) goto L16;
        if (r12.isNull(0) == false) goto L13;
        String r14 = null;
    L14:
        r13.add(r14);     // Catch: Throwable -> L18
        goto L8
    L13:
        r14 = r12.getString(0);     // Catch: Throwable -> L18
        goto L14
    L16:
        r12.close();
        r11.release();
        return r13;
    L18:
        th = move-exception;
        r12.close();
        r11.release();
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public void insert(WorkTag r10) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfWorkTag.insert(r10);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public void insertTags(String r10, Set<String> r11) {
        WorkTagDao.DefaultImpls.insertTags(this, r10, r11);
    }
}
