package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/room/QueryInterceptorOpenHelperFactory;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "delegate", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$QueryCallback;)V", "create", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "configuration", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class QueryInterceptorOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final SupportSQLiteOpenHelper.Factory delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public QueryInterceptorOpenHelperFactory(SupportSQLiteOpenHelper.Factory r3, Executor r4, RoomDatabase.QueryCallback r5) {
        SupportSQLiteOpenHelper.Factory r6 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        RoomDatabase.QueryCallback r8 = (RoomDatabase.QueryCallback) ZeusTransformUtils.wrapperContextForParams(r5, RoomDatabase.QueryCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "delegate");
        Intrinsics.checkNotNullParameter(r7, "queryCallbackExecutor");
        Intrinsics.checkNotNullParameter(r8, "queryCallback");
        this.delegate = r6;
        this.queryCallbackExecutor = r7;
        this.queryCallback = r8;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r3) {
        Intrinsics.checkNotNullParameter(r3, "configuration");
        return (SupportSQLiteOpenHelper) ZeusTransformUtils.preCheckCast(new QueryInterceptorOpenHelper(this.delegate.create(r3), this.queryCallbackExecutor, this.queryCallback), SupportSQLiteOpenHelper.class, "com.obric.memorydata.plugin");
    }
}
