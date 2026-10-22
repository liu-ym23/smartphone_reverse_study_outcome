package androidx.room;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public QueryInterceptorDatabase(SupportSQLiteDatabase r10, Executor r11, RoomDatabase.QueryCallback r12) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        Intrinsics.checkNotNullParameter(r11, "queryCallbackExecutor");
        Intrinsics.checkNotNullParameter(r12, "queryCallback");
        this.delegate = r10;
        this.queryCallbackExecutor = r11;
        this.queryCallback = r12;
    }

    public static /* synthetic */ void a(QueryInterceptorDatabase r10, SupportSQLiteQuery r11, QueryInterceptorProgram r12) {
        query$lambda$8(r10, r11, r12);
    }

    private static final void beginTransaction$lambda$0(QueryInterceptorDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void beginTransactionNonExclusive$lambda$1(QueryInterceptorDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void beginTransactionWithListener$lambda$2(QueryInterceptorDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void beginTransactionWithListenerNonExclusive$lambda$3(QueryInterceptorDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt.emptyList());
    }

    public static /* synthetic */ void c(QueryInterceptorDatabase r10) {
        beginTransactionWithListener$lambda$2(r10);
    }

    private static final void endTransaction$lambda$4(QueryInterceptorDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.queryCallback.onQuery("END TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void execSQL$lambda$10(QueryInterceptorDatabase r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$sql");
        r10.queryCallback.onQuery(r11, CollectionsKt.emptyList());
    }

    private static final void execSQL$lambda$11(QueryInterceptorDatabase r10, String r11, List r12) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$sql");
        Intrinsics.checkNotNullParameter(r12, "$inputArguments");
        r10.queryCallback.onQuery(r11, r12);
    }

    public static /* synthetic */ void f(QueryInterceptorDatabase r10) {
        beginTransaction$lambda$0(r10);
    }

    public static /* synthetic */ void i(QueryInterceptorDatabase r10, String r11, Object[] r12) {
        query$lambda$7(r10, r11, r12);
    }

    public static /* synthetic */ void k(QueryInterceptorDatabase r10, String r11, List r12) {
        execSQL$lambda$11(r10, r11, r12);
    }

    public static /* synthetic */ void l(QueryInterceptorDatabase r10) {
        beginTransactionWithListenerNonExclusive$lambda$3(r10);
    }

    public static /* synthetic */ void o(QueryInterceptorDatabase r10) {
        endTransaction$lambda$4(r10);
    }

    public static /* synthetic */ void p(QueryInterceptorDatabase r10) {
        setTransactionSuccessful$lambda$5(r10);
    }

    private static final void query$lambda$6(QueryInterceptorDatabase r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$query");
        r10.queryCallback.onQuery(r11, CollectionsKt.emptyList());
    }

    private static final void query$lambda$7(QueryInterceptorDatabase r10, String r11, Object[] r12) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$query");
        Intrinsics.checkNotNullParameter(r12, "$bindArgs");
        r10.queryCallback.onQuery(r11, ArraysKt.toList(r12));
    }

    private static final void query$lambda$8(QueryInterceptorDatabase r10, SupportSQLiteQuery r11, QueryInterceptorProgram r12) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$query");
        Intrinsics.checkNotNullParameter(r12, "$queryInterceptorProgram");
        r10.queryCallback.onQuery(r11.getSql(), r12.getBindArgsCache$room_runtime_release());
    }

    private static final void query$lambda$9(QueryInterceptorDatabase r10, SupportSQLiteQuery r11, QueryInterceptorProgram r12) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        Intrinsics.checkNotNullParameter(r11, "$query");
        Intrinsics.checkNotNullParameter(r12, "$queryInterceptorProgram");
        r10.queryCallback.onQuery(r11.getSql(), r12.getBindArgsCache$room_runtime_release());
    }

    public static /* synthetic */ void r(QueryInterceptorDatabase r10, String r11) {
        execSQL$lambda$10(r10, r11);
    }

    public static /* synthetic */ void s(QueryInterceptorDatabase r10, SupportSQLiteQuery r11, QueryInterceptorProgram r12) {
        query$lambda$9(r10, r11, r12);
    }

    private static final void setTransactionSuccessful$lambda$5(QueryInterceptorDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        r10.queryCallback.onQuery("TRANSACTION SUCCESSFUL", CollectionsKt.emptyList());
    }

    public static /* synthetic */ void u(QueryInterceptorDatabase r10, String r11) {
        query$lambda$6(r10, r11);
    }

    public static /* synthetic */ void v(QueryInterceptorDatabase r10) {
        beginTransactionNonExclusive$lambda$1(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.queryCallbackExecutor.execute(new j(this));
        this.delegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.queryCallbackExecutor.execute(new n(this));
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener r10) {
        Intrinsics.checkNotNullParameter(r10, "transactionListener");
        this.queryCallbackExecutor.execute(new g(this));
        this.delegate.beginTransactionWithListener(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r10) {
        Intrinsics.checkNotNullParameter(r10, "transactionListener");
        this.queryCallbackExecutor.execute(new k(this));
        this.delegate.beginTransactionWithListenerNonExclusive(r10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sql");
        return new QueryInterceptorStatement(this.delegate.compileStatement(r10), r10, this.queryCallbackExecutor, this.queryCallback);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r10, String r11, Object[] r12) {
        Intrinsics.checkNotNullParameter(r10, "table");
        return this.delegate.delete(r10, r11, r12);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.queryCallbackExecutor.execute(new l(this));
        this.delegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(String r10, @SuppressLint({"ArrayReturn"}) Object[] r11) {
        Intrinsics.checkNotNullParameter(r10, "sql");
        this.delegate.execPerConnectionSQL(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "sql");
        this.queryCallbackExecutor.execute(new q(this, r10));
        this.delegate.execSQL(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(final String r10, Object[] r11) {
        Intrinsics.checkNotNullParameter(r10, "sql");
        Intrinsics.checkNotNullParameter(r11, "bindArgs");
        final ArrayList r12 = new ArrayList();
        r12.addAll(CollectionsKt.listOf(r11));
        this.queryCallbackExecutor.execute(new h(this, r10, r12));
        this.delegate.execSQL(r10, new List[]{r12});
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public String getPath() {
        return this.delegate.getPath();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        return this.delegate.getVersion();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String r10, int r11, ContentValues r12) {
        Intrinsics.checkNotNullParameter(r10, "table");
        Intrinsics.checkNotNullParameter(r12, "values");
        return this.delegate.insert(r10, r11, r12);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        return this.delegate.isExecPerConnectionSQLSupported();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int r10) {
        return this.delegate.needUpgrade(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery r10) {
        Intrinsics.checkNotNullParameter(r10, "query");
        final QueryInterceptorProgram r11 = new QueryInterceptorProgram();
        r10.bindTo(r11);
        this.queryCallbackExecutor.execute(new o(this, r10, r11));
        return this.delegate.query(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery r10, CancellationSignal r11) {
        Intrinsics.checkNotNullParameter(r10, "query");
        final QueryInterceptorProgram r12 = new QueryInterceptorProgram();
        r10.bindTo(r12);
        this.queryCallbackExecutor.execute(new p(this, r10, r12));
        return this.delegate.query(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final String r10) {
        Intrinsics.checkNotNullParameter(r10, "query");
        this.queryCallbackExecutor.execute(new s(this, r10));
        return this.delegate.query(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final String r10, final Object[] r11) {
        Intrinsics.checkNotNullParameter(r10, "query");
        Intrinsics.checkNotNullParameter(r11, "bindArgs");
        this.queryCallbackExecutor.execute(new i(this, r10, r11));
        return this.delegate.query(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean r10) {
        this.delegate.setForeignKeyConstraintsEnabled(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale r10) {
        Intrinsics.checkNotNullParameter(r10, "locale");
        this.delegate.setLocale(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int r10) {
        this.delegate.setMaxSqlCacheSize(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long r10) {
        return this.delegate.setMaximumSize(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long r10) {
        this.delegate.setPageSize(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.queryCallbackExecutor.execute(new m(this));
        this.delegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int r10) {
        this.delegate.setVersion(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String r10, int r11, ContentValues r12, String r13, Object[] r14) {
        Intrinsics.checkNotNullParameter(r10, "table");
        Intrinsics.checkNotNullParameter(r12, "values");
        return this.delegate.update(r10, r11, r12, r13, r14);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long r10) {
        return this.delegate.yieldIfContendedSafely(r10);
    }
}
