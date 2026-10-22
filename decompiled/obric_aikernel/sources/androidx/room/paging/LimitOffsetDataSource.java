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

    protected LimitOffsetDataSource(@NonNull RoomDatabase r10, @NonNull RoomSQLiteQuery r11, boolean r12, boolean r13, @NonNull final String... r14) {
        this.mRegisteredObserver = new AtomicBoolean(false);
        this.mDb = r10;
        this.mSourceQuery = r11;
        this.mInTransaction = r12;
        this.mCountQuery = "SELECT COUNT(*) FROM ( " + r11.getSql() + " )";
        this.mLimitOffsetQuery = "SELECT * FROM ( " + r11.getSql() + " ) LIMIT ? OFFSET ?";
        this.mObserver = new AnonymousClass1(this, r14);
        if (r13 == false) goto L6;
        registerObserverIfNecessary();
        return;
    }

    protected LimitOffsetDataSource(@NonNull RoomDatabase r10, @NonNull RoomSQLiteQuery r11, boolean r12, @NonNull String... r13) {
        this(r10, r11, r12, true, r13);
    }

    protected LimitOffsetDataSource(@NonNull RoomDatabase r10, @NonNull SupportSQLiteQuery r11, boolean r12, boolean r13, @NonNull String... r14) {
        this(r10, RoomSQLiteQuery.copyFrom(r11), r12, r13, r14);
    }

    protected LimitOffsetDataSource(@NonNull RoomDatabase r10, @NonNull SupportSQLiteQuery r11, boolean r12, @NonNull String... r13) {
        this(r10, RoomSQLiteQuery.copyFrom(r11), r12, r13);
    }

    private RoomSQLiteQuery getSQLiteQuery(int r10, int r11) {
        RoomSQLiteQuery r12 = RoomSQLiteQuery.acquire(this.mLimitOffsetQuery, this.mSourceQuery.getArgCount() + 2);
        r12.copyArgumentsFrom(this.mSourceQuery);
        r12.bindLong(r12.getArgCount() - 1, r11);
        r12.bindLong(r12.getArgCount(), r10);
        return r12;
    }

    private void registerObserverIfNecessary() {
        if (this.mRegisteredObserver.compareAndSet(false, true) == false) goto L6;
        this.mDb.getInvalidationTracker().addWeakObserver(this.mObserver);
        return;
    }

    @NonNull
    protected abstract List<T> convertRows(@NonNull Cursor r10);

    public int countItems() {
        registerObserverIfNecessary();
        RoomSQLiteQuery r10 = RoomSQLiteQuery.acquire(this.mCountQuery, this.mSourceQuery.getArgCount());
        r10.copyArgumentsFrom(this.mSourceQuery);
        Cursor r11 = this.mDb.query(r10);
    L10:
        th = move-exception;
        r11.close();
        r10.release();
        throw th;
    L4:
        if (r11.moveToFirst() == false) goto L8;
        int r12 = r11.getInt(0);     // Catch: Throwable -> L10
        r11.close();
        r10.release();
        return r12;
    L8:
        r11.close();
        r10.release();
        return 0;
    }

    public boolean isInvalid() {
        registerObserverIfNecessary();
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return super.isInvalid();
    }

    public void loadInitial(@NonNull PositionalDataSource.LoadInitialParams r10, @NonNull PositionalDataSource.LoadInitialCallback<T> r11) {
        registerObserverIfNecessary();
        List<T> r12 = Collections.emptyList();
        this.mDb.beginTransaction();
        Cursor r13 = null;
        int r14 = countItems();     // Catch: Throwable -> L18
        if (r14 == 0) goto L10;
        int r15 = computeInitialLoadPosition(r10, r14);     // Catch: Throwable -> L18
        RoomSQLiteQuery r16 = getSQLiteQuery(r15, computeInitialLoadSize(r10, r15, r14));     // Catch: Throwable -> L18
        r13 = this.mDb.query(r16);     // Catch: Throwable -> L8
        List<T> r17 = convertRows(r13);     // Catch: Throwable -> L8
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L8
        RoomSQLiteQuery r18 = r16;
        int r19 = r15;
        r12 = r17;
    L11:
        if (r13 == null) goto L13;
        r13.close();
    L13:
        this.mDb.endTransaction();
        if (r18 == null) goto L16;
        r18.release();
    L16:
        r11.onResult(r12, r19, r14);
        return;
    L8:
        th = th;
    L20:
        if (r13 == null) goto L22;
        r13.close();
    L22:
        this.mDb.endTransaction();
        if (r16 == null) goto L25;
        r16.release();
    L25:
        throw th;
    L10:
        r19 = 0;
        r18 = null;
    L18:
        th = th;
        r16 = null;
        goto L20
    }

    @NonNull
    public List<T> loadRange(int r10, int r11) {
        RoomSQLiteQuery r12 = getSQLiteQuery(r10, r11);
        if (this.mInTransaction == false) goto L15;
        this.mDb.beginTransaction();
        Cursor r13 = null;
        r13 = this.mDb.query(r12);     // Catch: Throwable -> L10
        List<T> r14 = convertRows(r13);     // Catch: Throwable -> L10
        this.mDb.setTransactionSuccessful();     // Catch: Throwable -> L10
        if (r13 == null) goto L8;
        r13.close();
    L8:
        this.mDb.endTransaction();
        r12.release();
        return r14;
    L10:
        th = move-exception;
        if (r13 == null) goto L13;
        r13.close();
    L13:
        this.mDb.endTransaction();
        r12.release();
        throw th;
    L15:
        Cursor r15 = this.mDb.query(r12);
        List<T> r16 = convertRows(r15);     // Catch: Throwable -> L19
        r15.close();
        r12.release();
        return r16;
    L19:
        th = move-exception;
        r15.close();
        r12.release();
        throw th;
    }

    public void loadRange(@NonNull PositionalDataSource.LoadRangeParams r10, @NonNull PositionalDataSource.LoadRangeCallback<T> r11) {
        r11.onResult(loadRange(r10.startPosition, r10.loadSize));
    }
}
