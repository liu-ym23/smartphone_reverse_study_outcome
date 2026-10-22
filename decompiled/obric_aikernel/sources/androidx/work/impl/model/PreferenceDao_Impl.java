package androidx.work.impl.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PreferenceDao_Impl implements PreferenceDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<Preference> __insertionAdapterOfPreference;

    public PreferenceDao_Impl(final RoomDatabase r10) {
        this.__db = r10;
        this.__insertionAdapterOfPreference = new AnonymousClass1(this, r10);
    }

    static /* synthetic */ RoomDatabase access$000(PreferenceDao_Impl r10) {
        return r10.__db;
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public Long getLongValue(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.__db.assertNotSuspendingTransaction();
        Long r12 = null;
        Cursor r13 = DBUtil.query(this.__db, r11, false, null);
    L15:
        th = move-exception;
        r13.close();
        r11.release();
        throw th;
    L8:
        if (r13.moveToFirst() == true) goto L10;
    L13:
        r13.close();
        r11.release();
        return r12;
    L10:
        if (r13.isNull(0) == true) goto L13;
        r12 = Long.valueOf(r13.getLong(0));     // Catch: Throwable -> L15
        goto L13
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public LiveData<Long> getObservableLongValue(String r10) {
        final RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L7:
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"Preference"}, false, new AnonymousClass2(this, r11));
    L5:
        r11.bindString(1, r10);
        goto L7
    }

    @Override // androidx.work.impl.model.PreferenceDao
    public void insertPreference(Preference r10) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        this.__insertionAdapterOfPreference.insert(r10);     // Catch: Throwable -> L6
        this.__db.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.__db.endTransaction();
        return;
    L6:
        th = move-exception;
        this.__db.endTransaction();
        throw th;
    }
}
