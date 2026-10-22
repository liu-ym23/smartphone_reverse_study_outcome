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
import cn.nubia.neopush.commons.Constant;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\t\u0010.\u001a\u00020(H\u0096\u0001J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000bH\u0016J4\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u00010\u000b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0096\u0001¢\u0006\u0002\u00108J\t\u00109\u001a\u00020(H\u0097\u0001J\t\u0010:\u001a\u00020\u000fH\u0096\u0001J\b\u0010;\u001a\u00020(H\u0016J,\u0010<\u001a\u00020(2\u0006\u00101\u001a\u00020\u000b2\u0014\b\u0001\u0010=\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0096\u0001¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\u000bH\u0016J'\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\u000b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016¢\u0006\u0002\u0010>J\t\u0010@\u001a\u00020\u000fH\u0096\u0001J!\u0010A\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0096\u0001J\u0011\u0010E\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\"H\u0096\u0001J\u0010\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020IH\u0016J\u001a\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020\u000bH\u0016J'\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020\u000b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016¢\u0006\u0002\u0010LJ\u0011\u0010M\u001a\u00020(2\u0006\u0010N\u001a\u00020\u000fH\u0097\u0001J\u0011\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020QH\u0096\u0001J\u0011\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020\"H\u0096\u0001J\u0011\u0010T\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u0017H\u0096\u0001J\b\u0010V\u001a\u00020(H\u0016JD\u0010W\u001a\u00020\"2\u0006\u00103\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020D2\b\u00104\u001a\u0004\u0018\u00010\u000b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0096\u0001¢\u0006\u0002\u0010XJ\t\u0010Y\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020\u0017H\u0096\u0001R(\u0010\b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0012\u0010\u0014\u001a\u00020\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000f8WX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0012\u0010\u0016\u001a\u00020\u0017X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u0017X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010!\u001a\u00020\"X\u0096\u000f¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006["}, d2 = {"Landroidx/room/QueryInterceptorDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "delegate", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$QueryCallback;)V", "attachedDbs", "", "Landroid/util/Pair;", "", "getAttachedDbs", "()Ljava/util/List;", "isDatabaseIntegrityOk", "", "()Z", "isDbLockedByCurrentThread", "isExecPerConnectionSQLSupported", "isOpen", "isReadOnly", "isWriteAheadLoggingEnabled", "maximumSize", "", "getMaximumSize", "()J", "pageSize", "getPageSize", "setPageSize", "(J)V", SVGRenderEngine.PATH, "getPath", "()Ljava/lang/String;", "version", "", "getVersion", "()I", "setVersion", "(I)V", "beginTransaction", "", "beginTransactionNonExclusive", "beginTransactionWithListener", "transactionListener", "Landroid/database/sqlite/SQLiteTransactionListener;", "beginTransactionWithListenerNonExclusive", "close", "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", Constant.ClientMessageType.DELETE, "table", "whereClause", "whereArgs", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "disableWriteAheadLogging", "enableWriteAheadLogging", "endTransaction", "execPerConnectionSQL", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)V", "execSQL", "inTransaction", "insert", "conflictAlgorithm", "values", "Landroid/content/ContentValues;", "needUpgrade", "newVersion", "query", "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "enabled", "setLocale", "locale", "Ljava/util/Locale;", "setMaxSqlCacheSize", "cacheSize", "setMaximumSize", "numBytes", "setTransactionSuccessful", "update", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "yieldIfContendedSafely", "sleepAfterYieldDelayMillis", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public QueryInterceptorDatabase(SupportSQLiteDatabase r5, Executor r10, RoomDatabase.QueryCallback r11) {
        Intrinsics.checkNotNullParameter(r5, "delegate");
        Intrinsics.checkNotNullParameter(r10, "queryCallbackExecutor");
        Intrinsics.checkNotNullParameter(r11, "queryCallback");
        this.delegate = r5;
        this.queryCallbackExecutor = r10;
        this.queryCallback = r11;
    }

    public static /* synthetic */ void J(QueryInterceptorDatabase r5) {
        beginTransactionWithListenerNonExclusive$lambda$3(r5);
    }

    public static /* synthetic */ void K(QueryInterceptorDatabase r5, SupportSQLiteQuery r10, QueryInterceptorProgram r11) {
        query$lambda$8(r5, r10, r11);
    }

    public static /* synthetic */ void L(QueryInterceptorDatabase r5, SupportSQLiteQuery r10, QueryInterceptorProgram r11) {
        query$lambda$9(r5, r10, r11);
    }

    public static /* synthetic */ void b(QueryInterceptorDatabase r5, String r10, ArrayList r11) {
        execSQL$lambda$11(r5, r10, r11);
    }

    private static final void beginTransaction$lambda$0(QueryInterceptorDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void beginTransactionNonExclusive$lambda$1(QueryInterceptorDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void beginTransactionWithListener$lambda$2(QueryInterceptorDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void beginTransactionWithListenerNonExclusive$lambda$3(QueryInterceptorDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt.emptyList());
    }

    public static /* synthetic */ void d(QueryInterceptorDatabase r5, String r10) {
        execSQL$lambda$10(r5, r10);
    }

    public static /* synthetic */ void e(QueryInterceptorDatabase r5) {
        endTransaction$lambda$4(r5);
    }

    private static final void endTransaction$lambda$4(QueryInterceptorDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.queryCallback.onQuery("END TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void execSQL$lambda$10(QueryInterceptorDatabase r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$sql");
        r5.queryCallback.onQuery(r10, CollectionsKt.emptyList());
    }

    private static final void execSQL$lambda$11(QueryInterceptorDatabase r5, String r10, List r11) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$sql");
        Intrinsics.checkNotNullParameter(r11, "$inputArguments");
        r5.queryCallback.onQuery(r10, r11);
    }

    public static /* synthetic */ void f(QueryInterceptorDatabase r5) {
        setTransactionSuccessful$lambda$5(r5);
    }

    public static /* synthetic */ void g(QueryInterceptorDatabase r5) {
        beginTransaction$lambda$0(r5);
    }

    public static /* synthetic */ void m(QueryInterceptorDatabase r5) {
        beginTransactionNonExclusive$lambda$1(r5);
    }

    public static /* synthetic */ void n(QueryInterceptorDatabase r5, String r10, Object[] r11) {
        query$lambda$7(r5, r10, r11);
    }

    public static /* synthetic */ void p(QueryInterceptorDatabase r5) {
        beginTransactionWithListener$lambda$2(r5);
    }

    public static /* synthetic */ void q(QueryInterceptorDatabase r5, String r10) {
        query$lambda$6(r5, r10);
    }

    private static final void query$lambda$6(QueryInterceptorDatabase r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$query");
        r5.queryCallback.onQuery(r10, CollectionsKt.emptyList());
    }

    private static final void query$lambda$7(QueryInterceptorDatabase r5, String r10, Object[] r11) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$query");
        Intrinsics.checkNotNullParameter(r11, "$bindArgs");
        r5.queryCallback.onQuery(r10, ArraysKt.toList(r11));
    }

    private static final void query$lambda$8(QueryInterceptorDatabase r5, SupportSQLiteQuery r10, QueryInterceptorProgram r11) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$query");
        Intrinsics.checkNotNullParameter(r11, "$queryInterceptorProgram");
        r5.queryCallback.onQuery(r10.getSql(), r11.getBindArgsCache$room_runtime_release());
    }

    private static final void query$lambda$9(QueryInterceptorDatabase r5, SupportSQLiteQuery r10, QueryInterceptorProgram r11) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$query");
        Intrinsics.checkNotNullParameter(r11, "$queryInterceptorProgram");
        r5.queryCallback.onQuery(r10.getSql(), r11.getBindArgsCache$room_runtime_release());
    }

    private static final void setTransactionSuccessful$lambda$5(QueryInterceptorDatabase r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        r5.queryCallback.onQuery("TRANSACTION SUCCESSFUL", CollectionsKt.emptyList());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.queryCallbackExecutor.execute(new d(this, 2));
        this.delegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.queryCallbackExecutor.execute(new d(this, 4));
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener r5) {
        Intrinsics.checkNotNullParameter(r5, "transactionListener");
        this.queryCallbackExecutor.execute(new d(this, 5));
        this.delegate.beginTransactionWithListener(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r5) {
        Intrinsics.checkNotNullParameter(r5, "transactionListener");
        this.queryCallbackExecutor.execute(new d(this, 1));
        this.delegate.beginTransactionWithListenerNonExclusive(r5);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sql");
        return new QueryInterceptorStatement(this.delegate.compileStatement(r5), r5, this.queryCallbackExecutor, this.queryCallback);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r5, String r10, Object[] r11) {
        Intrinsics.checkNotNullParameter(r5, "table");
        return this.delegate.delete(r5, r10, r11);
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
        this.queryCallbackExecutor.execute(new d(this, 0));
        this.delegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(String r5, @SuppressLint({"ArrayReturn"}) Object[] r10) {
        Intrinsics.checkNotNullParameter(r5, "sql");
        this.delegate.execPerConnectionSQL(r5, r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sql");
        this.queryCallbackExecutor.execute(new e(this, r5, 1));
        this.delegate.execSQL(r5);
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
    public long insert(String r5, int r10, ContentValues r11) {
        Intrinsics.checkNotNullParameter(r5, "table");
        Intrinsics.checkNotNullParameter(r11, "values");
        return this.delegate.insert(r5, r10, r11);
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
    public boolean needUpgrade(int r5) {
        return this.delegate.needUpgrade(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r5) {
        Intrinsics.checkNotNullParameter(r5, "query");
        this.queryCallbackExecutor.execute(new e(this, r5, 0));
        return this.delegate.query(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean r5) {
        this.delegate.setForeignKeyConstraintsEnabled(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale r5) {
        Intrinsics.checkNotNullParameter(r5, "locale");
        this.delegate.setLocale(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int r5) {
        this.delegate.setMaxSqlCacheSize(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long r5) {
        return this.delegate.setMaximumSize(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long r5) {
        this.delegate.setPageSize(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.queryCallbackExecutor.execute(new d(this, 3));
        this.delegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int r5) {
        this.delegate.setVersion(r5);
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
    public boolean yieldIfContendedSafely(long r5) {
        return this.delegate.yieldIfContendedSafely(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r5, Object[] r10) {
        Intrinsics.checkNotNullParameter(r5, "sql");
        Intrinsics.checkNotNullParameter(r10, "bindArgs");
        ArrayList r11 = new ArrayList();
        r11.addAll(CollectionsKt.listOf(r10));
        this.queryCallbackExecutor.execute(new f(this, 1, r5, r11));
        this.delegate.execSQL(r5, new List[]{r11});
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r5, Object[] r10) {
        Intrinsics.checkNotNullParameter(r5, "query");
        Intrinsics.checkNotNullParameter(r10, "bindArgs");
        this.queryCallbackExecutor.execute(new f(this, 0, r5, r10));
        return this.delegate.query(r5, r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery r5) {
        Intrinsics.checkNotNullParameter(r5, "query");
        QueryInterceptorProgram r10 = new QueryInterceptorProgram();
        r5.bindTo(r10);
        this.queryCallbackExecutor.execute(new g(this, r5, r10, 0));
        return this.delegate.query(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery r5, CancellationSignal r10) {
        Intrinsics.checkNotNullParameter(r5, "query");
        QueryInterceptorProgram r11 = new QueryInterceptorProgram();
        r5.bindTo(r11);
        this.queryCallbackExecutor.execute(new g(this, r5, r11, 1));
        return this.delegate.query(r5);
    }
}
