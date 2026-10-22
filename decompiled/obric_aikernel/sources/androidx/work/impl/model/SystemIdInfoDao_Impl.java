package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<SystemIdInfo> __insertionAdapterOfSystemIdInfo;
    private final SharedSQLiteStatement __preparedStmtOfRemoveSystemIdInfo;
    private final SharedSQLiteStatement __preparedStmtOfRemoveSystemIdInfo_1;

    public SystemIdInfoDao_Impl(final RoomDatabase r10) {
        this.__db = r10;
        this.__insertionAdapterOfSystemIdInfo = new AnonymousClass1(this, r10);
        this.__preparedStmtOfRemoveSystemIdInfo = new AnonymousClass2(this, r10);
        this.__preparedStmtOfRemoveSystemIdInfo_1 = new AnonymousClass3(this, r10);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public SystemIdInfo getSystemIdInfo(WorkGenerationalId r10) {
        return SystemIdInfoDao.DefaultImpls.getSystemIdInfo(this, r10);
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public SystemIdInfo getSystemIdInfo(String r10, int r11) {
        RoomSQLiteQuery r12 = RoomSQLiteQuery.acquire("SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?", 2);
        if (r10 != null) goto L5;
        r12.bindNull(1);
    L6:
        r12.bindLong(2, r11);
        this.__db.assertNotSuspendingTransaction();
        SystemIdInfo r13 = null;
        String r14 = null;
        Cursor r15 = DBUtil.query(this.__db, r12, false, null);
        int r16 = CursorUtil.getColumnIndexOrThrow(r15, "work_spec_id");     // Catch: Throwable -> L17
        int r17 = CursorUtil.getColumnIndexOrThrow(r15, "generation");     // Catch: Throwable -> L17
        int r18 = CursorUtil.getColumnIndexOrThrow(r15, "system_id");     // Catch: Throwable -> L17
        if (r15.moveToFirst() == true) goto L10;
    L15:
        r15.close();
        r12.release();
        return r13;
    L10:
        if (r15.isNull(r16) == true) goto L13;
        r14 = r15.getString(r16);     // Catch: Throwable -> L17
    L13:
        r13 = new SystemIdInfo(r14, r15.getInt(r17), r15.getInt(r18));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r15.close();
        r12.release();
        throw th;
    L5:
        r12.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public List<String> getWorkSpecIds() {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor r11 = DBUtil.query(this.__db, r10, false, null);
        ArrayList r12 = new ArrayList(r11.getCount());     // Catch: Throwable -> L14
    L4:
        if (r11.moveToNext() == false) goto L12;
        if (r11.isNull(0) == false) goto L9;
        String r13 = null;
    L10:
        r12.add(r13);     // Catch: Throwable -> L14
        goto L4
    L9:
        r13 = r11.getString(0);     // Catch: Throwable -> L14
        goto L10
    L12:
        r11.close();
        r10.release();
        return r12;
    L14:
        th = move-exception;
        r11.close();
        r10.release();
        throw th;
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void insertSystemIdInfo(SystemIdInfo r10) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfSystemIdInfo.insert(r10);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(WorkGenerationalId r10) {
        SystemIdInfoDao.DefaultImpls.removeSystemIdInfo(this, r10);
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(String r10) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r11 = this.__preparedStmtOfRemoveSystemIdInfo_1.acquire();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.beginTransaction();
        r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfRemoveSystemIdInfo_1.release(r11);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfRemoveSystemIdInfo_1.release(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(String r10, int r11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement r12 = this.__preparedStmtOfRemoveSystemIdInfo.acquire();
        if (r10 != null) goto L5;
        r12.bindNull(1);
    L6:
        r12.bindLong(2, r11);
        this.__db.beginTransaction();
        r12.executeUpdateDelete();     // Catch: Throwable -> L10
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.__db.endTransaction();
        this.__preparedStmtOfRemoveSystemIdInfo.release(r12);
        return;
    L10:
        th = move-exception;
        this.__db.endTransaction();
        this.__preparedStmtOfRemoveSystemIdInfo.release(r12);
        throw th;
    L5:
        r12.bindString(1, r10);
        goto L6
    }
}
