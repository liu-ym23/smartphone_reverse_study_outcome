package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class QueryInterceptorOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final SupportSQLiteOpenHelper.Factory delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public QueryInterceptorOpenHelperFactory(SupportSQLiteOpenHelper.Factory r10, Executor r11, RoomDatabase.QueryCallback r12) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        Intrinsics.checkNotNullParameter(r11, "queryCallbackExecutor");
        Intrinsics.checkNotNullParameter(r12, "queryCallback");
        this.delegate = r10;
        this.queryCallbackExecutor = r11;
        this.queryCallback = r12;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "configuration");
        return new QueryInterceptorOpenHelper(this.delegate.create(r10), this.queryCallbackExecutor, this.queryCallback);
    }
}
