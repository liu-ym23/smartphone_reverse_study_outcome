package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\t\u0010.\u001a\u00020(H\u0096\u0001J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000bH\u0016J4\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u00010\u000b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0096\u0001¢\u0006\u0002\u00108J\t\u00109\u001a\u00020(H\u0097\u0001J\t\u0010:\u001a\u00020\u000fH\u0096\u0001J\b\u0010;\u001a\u00020(H\u0016J,\u0010<\u001a\u00020(2\u0006\u00101\u001a\u00020\u000b2\u0014\b\u0001\u0010=\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0096\u0001¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\u000bH\u0016J'\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\u000b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016¢\u0006\u0002\u0010>J\t\u0010@\u001a\u00020\u000fH\u0096\u0001J!\u0010A\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0096\u0001J\u0011\u0010E\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\"H\u0096\u0001J\u0010\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020IH\u0016J\u001a\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020\u000bH\u0016J'\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020\u000b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016¢\u0006\u0002\u0010LJ\u0011\u0010M\u001a\u00020(2\u0006\u0010N\u001a\u00020\u000fH\u0097\u0001J\u0011\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020QH\u0096\u0001J\u0011\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020\"H\u0096\u0001J\u0011\u0010T\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u0017H\u0096\u0001J\b\u0010V\u001a\u00020(H\u0016JD\u0010W\u001a\u00020\"2\u0006\u00103\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020D2\b\u00104\u001a\u0004\u0018\u00010\u000b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0096\u0001¢\u0006\u0002\u0010XJ\t\u0010Y\u001a\u00020\u000fH\u0096\u0001J\u0011\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020\u0017H\u0096\u0001R(\u0010\b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0012\u0010\u0014\u001a\u00020\u000fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000f8WX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0012\u0010\u0016\u001a\u00020\u0017X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u0017X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010!\u001a\u00020\"X\u0096\u000f¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006["}, d2 = {"Landroidx/room/QueryInterceptorDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "delegate", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$QueryCallback;)V", "attachedDbs", "", "Landroid/util/Pair;", "", "getAttachedDbs", "()Ljava/util/List;", "isDatabaseIntegrityOk", "", "()Z", "isDbLockedByCurrentThread", "isExecPerConnectionSQLSupported", "isOpen", "isReadOnly", "isWriteAheadLoggingEnabled", "maximumSize", "", "getMaximumSize", "()J", "pageSize", "getPageSize", "setPageSize", "(J)V", "path", "getPath", "()Ljava/lang/String;", "version", "", "getVersion", "()I", "setVersion", "(I)V", "beginTransaction", "", "beginTransactionNonExclusive", "beginTransactionWithListener", "transactionListener", "Landroid/database/sqlite/SQLiteTransactionListener;", "beginTransactionWithListenerNonExclusive", IslandSession.REOPEN_VALUE_CLOSE, "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "delete", "table", "whereClause", "whereArgs", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "disableWriteAheadLogging", "enableWriteAheadLogging", "endTransaction", "execPerConnectionSQL", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)V", "execSQL", "inTransaction", "insert", "conflictAlgorithm", "values", "Landroid/content/ContentValues;", "needUpgrade", "newVersion", ChatMessage.TYPE_QUERY, "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "enabled", "setLocale", "locale", "Ljava/util/Locale;", "setMaxSqlCacheSize", "cacheSize", "setMaximumSize", "numBytes", "setTransactionSuccessful", BuildConfig.CHANNEL, "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "yieldIfContendedSafely", "sleepAfterYieldDelayMillis", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public QueryInterceptorDatabase(SupportSQLiteDatabase r3, Executor r4, RoomDatabase.QueryCallback r5) {
        SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        RoomDatabase.QueryCallback r8 = (RoomDatabase.QueryCallback) ZeusTransformUtils.wrapperContextForParams(r5, RoomDatabase.QueryCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "delegate");
        Intrinsics.checkNotNullParameter(r7, "queryCallbackExecutor");
        Intrinsics.checkNotNullParameter(r8, "queryCallback");
        this.delegate = r6;
        this.queryCallbackExecutor = r7;
        this.queryCallback = r8;
    }

    private static final void beginTransaction$lambda$0(QueryInterceptorDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void beginTransactionNonExclusive$lambda$1(QueryInterceptorDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void beginTransactionWithListener$lambda$2(QueryInterceptorDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void beginTransactionWithListenerNonExclusive$lambda$3(QueryInterceptorDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void endTransaction$lambda$4(QueryInterceptorDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.queryCallback.onQuery("END TRANSACTION", CollectionsKt.emptyList());
    }

    private static final void execSQL$lambda$10(QueryInterceptorDatabase r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$sql");
        r1.queryCallback.onQuery(r2, CollectionsKt.emptyList());
    }

    private static final void execSQL$lambda$11(QueryInterceptorDatabase r2, String r3, List r4) {
        List<? extends Object> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$sql");
        Intrinsics.checkNotNullParameter(r5, "$inputArguments");
        r2.queryCallback.onQuery(r3, r5);
    }

    /* JADX INFO: renamed from: lambda$3nqW82Zqx2VSpCkGWA-yR8NbjIM, reason: not valid java name */
    public static /* synthetic */ void m56lambda$3nqW82Zqx2VSpCkGWAyR8NbjIM(QueryInterceptorDatabase r0, SupportSQLiteQuery r1, QueryInterceptorProgram r2) {
        query$lambda$8(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$3s68izs9RCe2upmu8CDLAvlPAwI(QueryInterceptorDatabase r0) {
        beginTransactionWithListener$lambda$2(r0);
    }

    public static /* synthetic */ void lambda$4C_ITtrC3gjVZMSZyw1Sxxv4ic4(QueryInterceptorDatabase r0) {
        beginTransaction$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$Dioq6ZJjT472mWjAQIRwVg5bWbI(QueryInterceptorDatabase r0, String r1, Object[] r2) {
        query$lambda$7(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$ESli_u-fGKTMJTbM4iCdFlNcDiE, reason: not valid java name */
    public static /* synthetic */ void m57lambda$ESli_ufGKTMJTbM4iCdFlNcDiE(QueryInterceptorDatabase r0, String r1, List r2) {
        execSQL$lambda$11(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$H_SBEG9RXHaL-4kIiF5ViKOQLZM, reason: not valid java name */
    public static /* synthetic */ void m58lambda$H_SBEG9RXHaL4kIiF5ViKOQLZM(QueryInterceptorDatabase r0) {
        beginTransactionWithListenerNonExclusive$lambda$3(r0);
    }

    public static /* synthetic */ void lambda$JwG54xY9OuUVdVWoxMHN3HSB5TM(QueryInterceptorDatabase r0) {
        endTransaction$lambda$4(r0);
    }

    public static /* synthetic */ void lambda$LVN74JJqCqCfwEWaHRC8n0Un2m0(QueryInterceptorDatabase r0) {
        setTransactionSuccessful$lambda$5(r0);
    }

    public static /* synthetic */ void lambda$ouzRkg2RWZvzWqaXpn1vapooSoE(QueryInterceptorDatabase r0, String r1) {
        execSQL$lambda$10(r0, r1);
    }

    public static /* synthetic */ void lambda$rBUkojwUw7EIsqAZ40YXCOpJQkc(QueryInterceptorDatabase r0, SupportSQLiteQuery r1, QueryInterceptorProgram r2) {
        query$lambda$9(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$w1qlF-OxXaEnb0tz5DMFEAdIrHU, reason: not valid java name */
    public static /* synthetic */ void m59lambda$w1qlFOxXaEnb0tz5DMFEAdIrHU(QueryInterceptorDatabase r0, String r1) {
        query$lambda$6(r0, r1);
    }

    public static /* synthetic */ void lambda$xXhyjBFfIFBi3uBWfyjF_r55EDQ(QueryInterceptorDatabase r0) {
        beginTransactionNonExclusive$lambda$1(r0);
    }

    private static final void query$lambda$6(QueryInterceptorDatabase r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$query");
        r1.queryCallback.onQuery(r2, CollectionsKt.emptyList());
    }

    private static final void query$lambda$7(QueryInterceptorDatabase r1, String r2, Object[] r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$query");
        Intrinsics.checkNotNullParameter(r3, "$bindArgs");
        r1.queryCallback.onQuery(r2, ArraysKt.toList(r3));
    }

    private static final void query$lambda$8(QueryInterceptorDatabase r2, SupportSQLiteQuery r3, QueryInterceptorProgram r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r5, "$query");
        Intrinsics.checkNotNullParameter(r4, "$queryInterceptorProgram");
        r2.queryCallback.onQuery(r5.getSql(), r4.getBindArgsCache$room_runtime_release());
    }

    private static final void query$lambda$9(QueryInterceptorDatabase r2, SupportSQLiteQuery r3, QueryInterceptorProgram r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r5, "$query");
        Intrinsics.checkNotNullParameter(r4, "$queryInterceptorProgram");
        r2.queryCallback.onQuery(r5.getSql(), r4.getBindArgsCache$room_runtime_release());
    }

    private static final void setTransactionSuccessful$lambda$5(QueryInterceptorDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.queryCallback.onQuery("TRANSACTION SUCCESSFUL", CollectionsKt.emptyList());
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorDatabase$4C_ITtrC3gjVZMSZyw1Sxxv4ic4(this));
        this.delegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorDatabase$xXhyjBFfIFBi3uBWfyjF_r55EDQ(this));
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener r3) {
        SQLiteTransactionListener r4 = (SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r3, SQLiteTransactionListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "transactionListener");
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorDatabase$3s68izs9RCe2upmu8CDLAvlPAwI(this));
        this.delegate.beginTransactionWithListener(r4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r3) {
        SQLiteTransactionListener r4 = (SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r3, SQLiteTransactionListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "transactionListener");
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorDatabase$H_SBEG9RXHaL4kIiF5ViKOQLZM(this));
        this.delegate.beginTransactionWithListenerNonExclusive(r4);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String r4) {
        Intrinsics.checkNotNullParameter(r4, "sql");
        return (SupportSQLiteStatement) ZeusTransformUtils.preCheckCast(new QueryInterceptorStatement(this.delegate.compileStatement(r4), r4, this.queryCallbackExecutor, this.queryCallback), SupportSQLiteStatement.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r2, String r3, Object[] r4) {
        Intrinsics.checkNotNullParameter(r2, "table");
        return this.delegate.delete(r2, r3, r4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorDatabase$JwG54xY9OuUVdVWoxMHN3HSB5TM(this));
        this.delegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(String r2, Object[] r3) {
        Intrinsics.checkNotNullParameter(r2, "sql");
        this.delegate.execPerConnectionSQL(r2, r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(final String r3) {
        Intrinsics.checkNotNullParameter(r3, "sql");
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorDatabase$ouzRkg2RWZvzWqaXpn1vapooSoE(this, r3));
        this.delegate.execSQL(r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(final String r4, Object[] r5) {
        Intrinsics.checkNotNullParameter(r4, "sql");
        Intrinsics.checkNotNullParameter(r5, "bindArgs");
        final List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        r0.addAll((Collection) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(r5), Collection.class, "com.obric.memorydata.plugin"));
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorDatabase$ESli_ufGKTMJTbM4iCdFlNcDiE(this, r4, r0));
        this.delegate.execSQL(r4, new List[]{r0});
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
    public long insert(String r2, int r3, ContentValues r4) {
        Intrinsics.checkNotNullParameter(r2, "table");
        Intrinsics.checkNotNullParameter(r4, "values");
        return this.delegate.insert(r2, r3, r4);
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
    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int r1) {
        return this.delegate.needUpgrade(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery r4) {
        final SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, ChatMessage.TYPE_QUERY);
        final QueryInterceptorProgram r0 = new QueryInterceptorProgram();
        r5.bindTo((SupportSQLiteProgram) ZeusTransformUtils.preCheckCast(r0, SupportSQLiteProgram.class, "com.obric.memorydata.plugin"));
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorDatabase$3nqW82Zqx2VSpCkGWAyR8NbjIM(this, r5, r0));
        return this.delegate.query(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery r3, CancellationSignal r4) {
        final SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, ChatMessage.TYPE_QUERY);
        final QueryInterceptorProgram r6 = new QueryInterceptorProgram();
        r5.bindTo((SupportSQLiteProgram) ZeusTransformUtils.preCheckCast(r6, SupportSQLiteProgram.class, "com.obric.memorydata.plugin"));
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorDatabase$rBUkojwUw7EIsqAZ40YXCOpJQkc(this, r5, r6));
        return this.delegate.query(r5);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final String r3) {
        Intrinsics.checkNotNullParameter(r3, ChatMessage.TYPE_QUERY);
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorDatabase$w1qlFOxXaEnb0tz5DMFEAdIrHU(this, r3));
        return this.delegate.query(r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final String r3, final Object[] r4) {
        Intrinsics.checkNotNullParameter(r3, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r4, "bindArgs");
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorDatabase$Dioq6ZJjT472mWjAQIRwVg5bWbI(this, r3, r4));
        return this.delegate.query(r3, r4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean r1) {
        this.delegate.setForeignKeyConstraintsEnabled(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale r2) {
        Intrinsics.checkNotNullParameter(r2, "locale");
        this.delegate.setLocale(r2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setMaxSqlCacheSize(int r1) {
        this.delegate.setMaxSqlCacheSize(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long r1) {
        return this.delegate.setMaximumSize(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long r1) {
        this.delegate.setPageSize(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        this.queryCallbackExecutor.execute(new $$Lambda$QueryInterceptorDatabase$LVN74JJqCqCfwEWaHRC8n0Un2m0(this));
        this.delegate.setTransactionSuccessful();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int r1) {
        this.delegate.setVersion(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String r8, int r9, ContentValues r10, String r11, Object[] r12) {
        Intrinsics.checkNotNullParameter(r8, "table");
        Intrinsics.checkNotNullParameter(r10, "values");
        return this.delegate.update(r8, r9, r10, r11, r12);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long r1) {
        return this.delegate.yieldIfContendedSafely(r1);
    }
}
