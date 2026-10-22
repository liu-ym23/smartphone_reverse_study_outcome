package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\t\u0010\u001a\u001a\u00020\u000eH\u0096\u0001J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u001a\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010 \u001a\u00020\u0016H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/room/QueryInterceptorStatement;", "Landroidx/sqlite/db/SupportSQLiteStatement;", "delegate", "sqlStatement", "", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "(Landroidx/sqlite/db/SupportSQLiteStatement;Ljava/lang/String;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$QueryCallback;)V", "bindArgsCache", "", "", "bindBlob", "", "index", "", "value", "", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "clearBindings", "close", "execute", "executeInsert", "executeUpdateDelete", "saveArgsToCache", "bindIndex", "simpleQueryForLong", "simpleQueryForString", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final List<Object> bindArgsCache;
    private final SupportSQLiteStatement delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;
    private final String sqlStatement;

    public QueryInterceptorStatement(SupportSQLiteStatement r5, String r10, Executor r11, RoomDatabase.QueryCallback r12) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        Intrinsics.checkNotNullParameter(r10, "sqlStatement");
        Intrinsics.checkNotNullParameter(r11, "queryCallbackExecutor");
        Intrinsics.checkNotNullParameter(r12, "queryCallback");
        this.delegate = r5;
        this.sqlStatement = r10;
        this.queryCallbackExecutor = r11;
        this.queryCallback = r12;
        this.bindArgsCache = new ArrayList();
    }

    public static /* synthetic */ void b(QueryInterceptorStatement r5) {
        simpleQueryForString$lambda$4(r5);
    }

    public static /* synthetic */ void d(QueryInterceptorStatement r5) {
        simpleQueryForLong$lambda$3(r5);
    }

    public static /* synthetic */ void e(QueryInterceptorStatement r5) {
        execute$lambda$0(r5);
    }

    private static final void execute$lambda$0(QueryInterceptorStatement r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.queryCallback.onQuery(r5.sqlStatement, r5.bindArgsCache);
    }

    private static final void executeInsert$lambda$2(QueryInterceptorStatement r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.queryCallback.onQuery(r5.sqlStatement, r5.bindArgsCache);
    }

    private static final void executeUpdateDelete$lambda$1(QueryInterceptorStatement r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.queryCallback.onQuery(r5.sqlStatement, r5.bindArgsCache);
    }

    public static /* synthetic */ void f(QueryInterceptorStatement r5) {
        executeInsert$lambda$2(r5);
    }

    public static /* synthetic */ void g(QueryInterceptorStatement r5) {
        executeUpdateDelete$lambda$1(r5);
    }

    private final void saveArgsToCache(int r5, Object r10) {
        int r11 = r5 - 1;
        if (r11 < this.bindArgsCache.size()) goto L7;
        int r12 = (r11 - this.bindArgsCache.size()) + 1;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L7;
        this.bindArgsCache.add(null);
        r13 = r13 + 1;
    L7:
        this.bindArgsCache.set(r11, r10);
    }

    private static final void simpleQueryForLong$lambda$3(QueryInterceptorStatement r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.queryCallback.onQuery(r5.sqlStatement, r5.bindArgsCache);
    }

    private static final void simpleQueryForString$lambda$4(QueryInterceptorStatement r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.queryCallback.onQuery(r5.sqlStatement, r5.bindArgsCache);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r5, byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        saveArgsToCache(r5, r10);
        this.delegate.bindBlob(r5, r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r5, double r10) {
        saveArgsToCache(r5, Double.valueOf(r10));
        this.delegate.bindDouble(r5, r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r5, long r10) {
        saveArgsToCache(r5, Long.valueOf(r10));
        this.delegate.bindLong(r5, r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r5) {
        Object[] r10 = this.bindArgsCache.toArray(new Object[0]);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        saveArgsToCache(r5, Arrays.copyOf(r10, r10.length));
        this.delegate.bindNull(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        saveArgsToCache(r5, r10);
        this.delegate.bindString(r5, r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.bindArgsCache.clear();
        this.delegate.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        this.queryCallbackExecutor.execute(new h(this, 3));
        this.delegate.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        this.queryCallbackExecutor.execute(new h(this, 1));
        return this.delegate.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        this.queryCallbackExecutor.execute(new h(this, 4));
        return this.delegate.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        this.queryCallbackExecutor.execute(new h(this, 0));
        return this.delegate.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        this.queryCallbackExecutor.execute(new h(this, 2));
        return this.delegate.simpleQueryForString();
    }
}
