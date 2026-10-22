package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
final class QueryInterceptorOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final SupportSQLiteOpenHelper.Factory mDelegate;
    private final RoomDatabase$QueryCallback mQueryCallback;
    private final Executor mQueryCallbackExecutor;

    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r4) {
        return new QueryInterceptorOpenHelper(this.mDelegate.create(r4), this.mQueryCallback, this.mQueryCallbackExecutor);
    }

    public QueryInterceptorOpenHelperFactory(SupportSQLiteOpenHelper.Factory r1, RoomDatabase$QueryCallback r2, Executor r3) {
        this.mDelegate = r1;
        this.mQueryCallback = r2;
        this.mQueryCallbackExecutor = r3;
    }
}
