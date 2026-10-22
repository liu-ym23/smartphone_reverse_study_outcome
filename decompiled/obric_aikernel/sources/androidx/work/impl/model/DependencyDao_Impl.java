package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class DependencyDao_Impl implements DependencyDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Dependency> __insertionAdapterOfDependency;

    public DependencyDao_Impl(final RoomDatabase r10) {
        this.__db = r10;
        this.__insertionAdapterOfDependency = new AnonymousClass1(this, r10);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.DependencyDao
    public List<String> getDependentWorkIds(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
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

    @Override // androidx.work.impl.model.DependencyDao
    public List<String> getPrerequisites(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT prerequisite_id FROM dependency WHERE work_spec_id=?", 1);
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

    @Override // androidx.work.impl.model.DependencyDao
    public boolean hasCompletedAllPrerequisites(String r10) {
        boolean r11 = true;
        RoomSQLiteQuery r12 = RoomSQLiteQuery.acquire("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (r10 != null) goto L5;
        r12.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        boolean r13 = false;
        Cursor r14 = DBUtil.query(this.__db, r12, false, null);
    L16:
        th = move-exception;
        r14.close();
        r12.release();
        throw th;
    L8:
        if (r14.moveToFirst() == false) goto L14;
        if (r14.getInt(0) != 0) goto L13;
        r11 = false;
    L13:
        r13 = r11;
    L14:
        r14.close();
        r12.release();
        return r13;
    L5:
        r12.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.DependencyDao
    public boolean hasDependents(String r10) {
        boolean r11 = true;
        RoomSQLiteQuery r12 = RoomSQLiteQuery.acquire("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (r10 != null) goto L5;
        r12.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        boolean r13 = false;
        Cursor r14 = DBUtil.query(this.__db, r12, false, null);
    L16:
        th = move-exception;
        r14.close();
        r12.release();
        throw th;
    L8:
        if (r14.moveToFirst() == false) goto L14;
        if (r14.getInt(0) != 0) goto L13;
        r11 = false;
    L13:
        r13 = r11;
    L14:
        r14.close();
        r12.release();
        return r13;
    L5:
        r12.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.DependencyDao
    public void insertDependency(Dependency r10) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfDependency.insert(r10);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
