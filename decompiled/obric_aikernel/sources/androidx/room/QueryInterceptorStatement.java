package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.crash.entity.EventBody;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final List<Object> bindArgsCache;
    private final SupportSQLiteStatement delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;
    private final String sqlStatement;

    public QueryInterceptorStatement(SupportSQLiteStatement r10, String r11, Executor r12, RoomDatabase.QueryCallback r13) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        Intrinsics.checkNotNullParameter(r11, "sqlStatement");
        Intrinsics.checkNotNullParameter(r12, "queryCallbackExecutor");
        Intrinsics.checkNotNullParameter(r13, "queryCallback");
        this.delegate = r10;
        this.sqlStatement = r11;
        this.queryCallbackExecutor = r12;
        this.queryCallback = r13;
        this.bindArgsCache = new ArrayList();
    }

    public static /* synthetic */ void a(QueryInterceptorStatement r10) {
        simpleQueryForLong$lambda$3(r10);
    }

    public static /* synthetic */ void c(QueryInterceptorStatement r10) {
        execute$lambda$0(r10);
    }

    private static final void execute$lambda$0(QueryInterceptorStatement r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.queryCallback.onQuery(r10.sqlStatement, r10.bindArgsCache);
    }

    private static final void executeInsert$lambda$2(QueryInterceptorStatement r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.queryCallback.onQuery(r10.sqlStatement, r10.bindArgsCache);
    }

    private static final void executeUpdateDelete$lambda$1(QueryInterceptorStatement r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.queryCallback.onQuery(r10.sqlStatement, r10.bindArgsCache);
    }

    public static /* synthetic */ void f(QueryInterceptorStatement r10) {
        executeUpdateDelete$lambda$1(r10);
    }

    public static /* synthetic */ void i(QueryInterceptorStatement r10) {
        executeInsert$lambda$2(r10);
    }

    public static /* synthetic */ void k(QueryInterceptorStatement r10) {
        simpleQueryForString$lambda$4(r10);
    }

    private final void saveArgsToCache(int r10, Object r11) {
        int r12 = r10 - 1;
        if (r12 < this.bindArgsCache.size()) goto L7;
        int r13 = (r12 - this.bindArgsCache.size()) + 1;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L7;
        this.bindArgsCache.add(null);
        r14 = r14 + 1;
    L7:
        this.bindArgsCache.set(r12, r11);
    }

    private static final void simpleQueryForLong$lambda$3(QueryInterceptorStatement r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.queryCallback.onQuery(r10.sqlStatement, r10.bindArgsCache);
    }

    private static final void simpleQueryForString$lambda$4(QueryInterceptorStatement r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.queryCallback.onQuery(r10.sqlStatement, r10.bindArgsCache);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        saveArgsToCache(r10, r11);
        this.delegate.bindBlob(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r10, double r11) {
        saveArgsToCache(r10, Double.valueOf(r11));
        this.delegate.bindDouble(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r10, long r11) {
        saveArgsToCache(r10, Long.valueOf(r11));
        this.delegate.bindLong(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r10) {
        Object[] r11 = this.bindArgsCache.toArray(new Object[0]);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        saveArgsToCache(r10, Arrays.copyOf(r11, r11.length));
        this.delegate.bindNull(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        saveArgsToCache(r10, r11);
        this.delegate.bindString(r10, r11);
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
        this.queryCallbackExecutor.execute(new u(this));
        this.delegate.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        this.queryCallbackExecutor.execute(new w(this));
        return this.delegate.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        this.queryCallbackExecutor.execute(new v(this));
        return this.delegate.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        this.queryCallbackExecutor.execute(new t(this));
        return this.delegate.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        this.queryCallbackExecutor.execute(new x(this));
        return this.delegate.simpleQueryForString();
    }
}
