package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {
    private final String mCountQuery;
    private final RoomDatabase mDb;
    private final boolean mInTransaction;
    private final String mLimitOffsetQuery;
    private final InvalidationTracker.Observer mObserver;
    private final AtomicBoolean mRegisteredObserver;
    private final RoomSQLiteQuery mSourceQuery;

    public LimitOffsetDataSource(@NonNull RoomDatabase r5, @NonNull SupportSQLiteQuery r10, boolean r11, @NonNull String... r12) {
        this(r5, RoomSQLiteQuery.copyFrom(r10), r11, r12);
    }

    private RoomSQLiteQuery getSQLiteQuery(int r5, int r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.acquire(this.mLimitOffsetQuery, this.mSourceQuery.getArgCount() + 2);
        r11.copyArgumentsFrom(this.mSourceQuery);
        r11.bindLong(r11.getArgCount() - 1, r10);
        r11.bindLong(r11.getArgCount(), r5);
        return r11;
    }

    private void registerObserverIfNecessary() {
        if (this.mRegisteredObserver.compareAndSet(false, true) == false) goto L6;
        this.mDb.getInvalidationTracker().addWeakObserver(this.mObserver);
        return;
    }

    @NonNull
    public abstract List<T> convertRows(@NonNull Cursor r5);

    public int countItems() {
        registerObserverIfNecessary();
        RoomSQLiteQuery r5 = RoomSQLiteQuery.acquire(this.mCountQuery, this.mSourceQuery.getArgCount());
        r5.copyArgumentsFrom(this.mSourceQuery);
        Cursor r10 = this.mDb.query(r5);
    L8:
        th = move-exception;
        r10.close();
        r5.release();
        throw th;
    L4:
        if (r10.moveToFirst() == false) goto L10;
        int r11 = r10.getInt(0);     // Catch: Throwable -> L8
        r10.close();
        r5.release();
        return r11;
    L10:
        r10.close();
        r5.release();
        return 0;
    }

    public boolean isInvalid() {
        registerObserverIfNecessary();
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    public void loadInitial(@NonNull PositionalDataSource.LoadInitialParams r10, @NonNull PositionalDataSource.LoadInitialCallback<T> r11) {
        registerObserverIfNecessary();
        List<T> r5 = Collections.emptyList();
        this.mDb.beginTransaction();
        Cursor r12 = null;
        int r13 = countItems();     // Catch: Throwable -> L10
        if (r13 == 0) goto L12;
        int r14 = computeInitialLoadPosition(r10, r13);     // Catch: Throwable -> L10
        RoomSQLiteQuery r15 = getSQLiteQuery(r14, computeInitialLoadSize(r10, r14, r13));     // Catch: Throwable -> L10
        r12 = this.mDb.query(r15);     // Catch: Throwable -> L8
        List<T> r16 = convertRows(r12);     // Catch: Throwable -> L8
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L8
        RoomSQLiteQuery r17 = r15;
        int r18 = r14;
        r5 = r16;
    L13:
        if (r12 == null) goto L15;
        r12.close();
    L15:
        this.mDb.endTransaction();
        if (r17 == null) goto L18;
        r17.release();
    L18:
        r11.onResult(r5, r18, r13);
        return;
    L8:
        th = th;
    L20:
        if (r12 == null) goto L22;
        r12.close();
    L22:
        this.mDb.endTransaction();
        if (r15 == null) goto L25;
        r15.release();
    L25:
        throw th;
    L12:
        r18 = 0;
        r17 = null;
    L10:
        th = th;
        r15 = null;
        goto L20
    }

    public void loadRange(@NonNull PositionalDataSource.LoadRangeParams r5, @NonNull PositionalDataSource.LoadRangeCallback<T> r10) {
        r10.onResult(loadRange(r5.startPosition, r5.loadSize));
    }

    public LimitOffsetDataSource(@NonNull RoomDatabase r10, @NonNull SupportSQLiteQuery r11, boolean r12, boolean r13, @NonNull String... r14) {
        this(r10, RoomSQLiteQuery.copyFrom(r11), r12, r13, r14);
    }

    @NonNull
    public List<T> loadRange(int r5, int r10) {
        RoomSQLiteQuery r11 = getSQLiteQuery(r5, r10);
        if (this.mInTransaction == false) goto L15;
        this.mDb.beginTransaction();
        Cursor r12 = null;
        r12 = this.mDb.query(r11);     // Catch: Throwable -> L10
        List<T> r13 = convertRows(r12);     // Catch: Throwable -> L10
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L10
        if (r12 == null) goto L8;
        r12.close();
    L8:
        this.mDb.endTransaction();
        r11.release();
        return r13;
    L10:
        th = move-exception;
        if (r12 == null) goto L13;
        r12.close();
    L13:
        this.mDb.endTransaction();
        r11.release();
        throw th;
    L15:
        Cursor r14 = this.mDb.query(r11);
        List<T> r15 = convertRows(r14);     // Catch: Throwable -> L19
        r14.close();
        r11.release();
        return r15;
    L19:
        th = move-exception;
        r14.close();
        r11.release();
        throw th;
    }

    public LimitOffsetDataSource(@NonNull RoomDatabase r10, @NonNull RoomSQLiteQuery r11, boolean r12, @NonNull String... r13) {
        this(r10, r11, r12, true, r13);
    }

    public LimitOffsetDataSource(@NonNull RoomDatabase r5, @NonNull RoomSQLiteQuery r10, boolean r11, boolean r12, @NonNull final String... r13) {
        this.mRegisteredObserver = new AtomicBoolean(false);
        this.mDb = r5;
        this.mSourceQuery = r10;
        this.mInTransaction = r11;
        this.mCountQuery = "SELECT COUNT(*) FROM ( " + r10.getSql() + " )";
        this.mLimitOffsetQuery = "SELECT * FROM ( " + r10.getSql() + " ) LIMIT ? OFFSET ?";
        this.mObserver = new AnonymousClass1(this, r13);
        if (r12 == false) goto L6;
        registerObserverIfNecessary();
        return;
    }
}
