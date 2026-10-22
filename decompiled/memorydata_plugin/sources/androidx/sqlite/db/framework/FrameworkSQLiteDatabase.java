package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \\2\u00020\u0001:\u0002[\\B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020(H\u0016J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\bH\u0016J3\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0016¢\u0006\u0002\u00108J\b\u00109\u001a\u00020(H\u0017J\b\u0010:\u001a\u00020\fH\u0016J\b\u0010;\u001a\u00020(H\u0016J)\u0010<\u001a\u00020(2\u0006\u00101\u001a\u00020\b2\u0012\u0010=\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0016¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\bH\u0016J'\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016¢\u0006\u0002\u0010>J\b\u0010@\u001a\u00020\fH\u0016J \u0010A\u001a\u00020\u00142\u0006\u00103\u001a\u00020\b2\u0006\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020DH\u0016J\u000e\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\u0003J\u0010\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020!H\u0016J\u0010\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020KH\u0016J\u001a\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0017J\u0010\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020\bH\u0016J'\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020\b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016¢\u0006\u0002\u0010NJ\u0010\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020\fH\u0017J\u0010\u0010Q\u001a\u00020(2\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u00020!H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010V\u001a\u00020(H\u0016JC\u0010W\u001a\u00020!2\u0006\u00103\u001a\u00020\b2\u0006\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020D2\b\u00104\u001a\u0004\u0018\u00010\b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0016¢\u0006\u0002\u0010XJ\b\u0010Y\u001a\u00020\fH\u0016J\u0010\u0010Y\u001a\u00020\f2\u0006\u0010Z\u001a\u00020\u0014H\u0016R(\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\f8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\rR$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR$\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006]"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "delegate", "Landroid/database/sqlite/SQLiteDatabase;", "(Landroid/database/sqlite/SQLiteDatabase;)V", "attachedDbs", "", "Landroid/util/Pair;", "", "getAttachedDbs", "()Ljava/util/List;", "isDatabaseIntegrityOk", "", "()Z", "isDbLockedByCurrentThread", "isExecPerConnectionSQLSupported", "isOpen", "isReadOnly", "isWriteAheadLoggingEnabled", "numBytes", "", "maximumSize", "getMaximumSize", "()J", "setMaximumSize", "(J)V", "pageSize", "getPageSize", "setPageSize", "path", "getPath", "()Ljava/lang/String;", EventBody.KEY_VALUE, "", "version", "getVersion", "()I", "setVersion", "(I)V", "beginTransaction", "", "beginTransactionNonExclusive", "beginTransactionWithListener", "transactionListener", "Landroid/database/sqlite/SQLiteTransactionListener;", "beginTransactionWithListenerNonExclusive", IslandSession.REOPEN_VALUE_CLOSE, "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "delete", "table", "whereClause", "whereArgs", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "disableWriteAheadLogging", "enableWriteAheadLogging", "endTransaction", "execPerConnectionSQL", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)V", "execSQL", "inTransaction", "insert", "conflictAlgorithm", "values", "Landroid/content/ContentValues;", "isDelegate", "sqLiteDatabase", "needUpgrade", "newVersion", ChatMessage.TYPE_QUERY, "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "enabled", "setLocale", "locale", "Ljava/util/Locale;", "setMaxSqlCacheSize", "cacheSize", "setTransactionSuccessful", BuildConfig.CHANNEL, "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "yieldIfContendedSafely", "sleepAfterYieldDelayMillis", "Api30Impl", "Companion", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {
    private static final String[] CONFLICT_VALUES = null;
    public static final Companion Companion = null;
    private static final String[] EMPTY_STRING_ARRAY = null;
    private final SQLiteDatabase delegate;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase$Api30Impl;", "", "()V", "execPerConnectionSQL", "", "sQLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "sql", "", "bindArgs", "", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Object;)V", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = null;

        static {
            INSTANCE = new Api30Impl();
        }

        private Api30Impl() {
        }

        public final void execPerConnectionSQL(SQLiteDatabase r1, String r2, Object[] r3) {
            Intrinsics.checkNotNullParameter(r1, "sQLiteDatabase");
            Intrinsics.checkNotNullParameter(r2, "sql");
            r1.execPerConnectionSQL(r2, r3);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase$Companion;", "", "()V", "CONFLICT_VALUES", "", "", "[Ljava/lang/String;", "EMPTY_STRING_ARRAY", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        EMPTY_STRING_ARRAY = new String[0];
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        this.delegate = r2;
    }

    public static /* synthetic */ Cursor lambda$BFGJjdMOCDz5XPIMAR1G27bXFjU(SupportSQLiteQuery r0, SQLiteDatabase r1, SQLiteCursorDriver r2, String r3, SQLiteQuery r4) {
        return query$lambda$1(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$xWs7VTYEzeAWyi_2-SJixQ1HyKQ, reason: not valid java name */
    public static /* synthetic */ Cursor m64lambda$xWs7VTYEzeAWyi_2SJixQ1HyKQ(Function4 r0, SQLiteDatabase r1, SQLiteCursorDriver r2, String r3, SQLiteQuery r4) {
        return query$lambda$0(r0, r1, r2, r3, r4);
    }

    private static final Cursor query$lambda$0(Function4 r2, SQLiteDatabase r3, SQLiteCursorDriver r4, String r5, SQLiteQuery r6) {
        Function4 r7 = (Function4) ZeusTransformUtils.wrapperContextForParams(r2, Function4.class, "com.obric.memorydata.plugin");
        SQLiteCursorDriver r8 = (SQLiteCursorDriver) ZeusTransformUtils.wrapperContextForParams(r4, SQLiteCursorDriver.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "$tmp0");
        return (Cursor) ZeusTransformUtils.preCheckCast(r7.invoke(r3, r8, r5, r6), Cursor.class, "com.obric.memorydata.plugin");
    }

    private static final Cursor query$lambda$1(SupportSQLiteQuery r2, SQLiteDatabase r3, SQLiteCursorDriver r4, String r5, SQLiteQuery r6) {
        SupportSQLiteQuery r7 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        SQLiteCursorDriver r8 = (SQLiteCursorDriver) ZeusTransformUtils.wrapperContextForParams(r4, SQLiteCursorDriver.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "$query");
        Intrinsics.checkNotNull(r6);
        r7.bindTo((SupportSQLiteProgram) ZeusTransformUtils.preCheckCast(new FrameworkSQLiteProgram((SQLiteProgram) ZeusTransformUtils.preCheckCast(r6, SQLiteProgram.class, "com.obric.memorydata.plugin")), SupportSQLiteProgram.class, "com.obric.memorydata.plugin"));
        return (Cursor) ZeusTransformUtils.preCheckCast(new SQLiteCursor(r8, r5, r6), Cursor.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        this.delegate.beginTransactionNonExclusive();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(SQLiteTransactionListener r3) {
        SQLiteTransactionListener r4 = (SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r3, SQLiteTransactionListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "transactionListener");
        this.delegate.beginTransactionWithListener(r4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r3) {
        SQLiteTransactionListener r4 = (SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r3, SQLiteTransactionListener.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "transactionListener");
        this.delegate.beginTransactionWithListenerNonExclusive(r4);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sql");
        SQLiteStatement r1 = this.delegate.compileStatement(r2);
        Intrinsics.checkNotNullExpressionValue(r1, "delegate.compileStatement(sql)");
        return (SupportSQLiteStatement) ZeusTransformUtils.preCheckCast(new FrameworkSQLiteStatement(r1), SupportSQLiteStatement.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r3, String r4, Object[] r5) {
        Intrinsics.checkNotNullParameter(r3, "table");
        StringBuilder r0 = new StringBuilder();
        r0.append("DELETE FROM ");
        r0.append(r3);
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L8:
        boolean r7 = true;
    L9:
        if (r7 == true) goto L11;
        r0.append(" WHERE ");
        r0.append(r4);
    L11:
        String r8 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r8, "StringBuilder().apply(builderAction).toString()");
        SupportSQLiteStatement r2 = compileStatement(r8);
        SimpleSQLiteQuery.Companion.bind((SupportSQLiteProgram) ZeusTransformUtils.preCheckCast(r2, SupportSQLiteProgram.class, "com.obric.memorydata.plugin"), r5);
        return r2.executeUpdateDelete();
    L5:
        if (r6.length() == 0) goto L8;
        r7 = false;
        goto L9
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        SupportSQLiteCompat.Api16Impl.disableWriteAheadLogging(this.delegate);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        this.delegate.endTransaction();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execPerConnectionSQL(String r3, Object[] r4) {
        Intrinsics.checkNotNullParameter(r3, "sql");
        if (Build.VERSION.SDK_INT < 30) goto L7;
        Api30Impl.INSTANCE.execPerConnectionSQL(this.delegate, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: " + Build.VERSION.SDK_INT);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r2) {
        Intrinsics.checkNotNullParameter(r2, "sql");
        this.delegate.execSQL(r2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r2, Object[] r3) {
        Intrinsics.checkNotNullParameter(r2, "sql");
        Intrinsics.checkNotNullParameter(r3, "bindArgs");
        this.delegate.execSQL(r2, r3);
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
        return this.delegate.insertWithOnConflict(r2, null, r4, r3);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public final boolean isDelegate(SQLiteDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, "sqLiteDatabase");
        return Intrinsics.areEqual(this.delegate, r2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isExecPerConnectionSQLSupported() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        return true;
    L5:
        return false;
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
        return SupportSQLiteCompat.Api16Impl.isWriteAheadLoggingEnabled(this.delegate);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int r1) {
        return this.delegate.needUpgrade(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery r4) {
        final SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, ChatMessage.TYPE_QUERY);
        final Function4 r0 = (Function4) ZeusTransformUtils.preCheckCast(new FrameworkSQLiteDatabase$query$cursorFactory$1(r5), Function4.class, "com.obric.memorydata.plugin");
        Cursor r3 = this.delegate.rawQueryWithFactory(new $$Lambda$FrameworkSQLiteDatabase$xWs7VTYEzeAWyi_2SJixQ1HyKQ(r0), r5.getSql(), EMPTY_STRING_ARRAY, null);
        Intrinsics.checkNotNullExpressionValue(r3, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return r3;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(SupportSQLiteQuery r8, CancellationSignal r9) {
        final SupportSQLiteQuery r10 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r8, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, ChatMessage.TYPE_QUERY);
        SQLiteDatabase r1 = this.delegate;
        String r2 = r10.getSql();
        String[] r3 = EMPTY_STRING_ARRAY;
        Intrinsics.checkNotNull(r9);
        return SupportSQLiteCompat.Api16Impl.rawQueryWithFactory(r1, r2, r3, null, r9, new $$Lambda$FrameworkSQLiteDatabase$BFGJjdMOCDz5XPIMAR1G27bXFjU(r10));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r3) {
        Intrinsics.checkNotNullParameter(r3, ChatMessage.TYPE_QUERY);
        return query((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(r3), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r2, Object[] r3) {
        Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
        Intrinsics.checkNotNullParameter(r3, "bindArgs");
        return query((SupportSQLiteQuery) ZeusTransformUtils.preCheckCast(new SimpleSQLiteQuery(r2, r3), SupportSQLiteQuery.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean r1) {
        SupportSQLiteCompat.Api16Impl.setForeignKeyConstraintsEnabled(this.delegate, r1);
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
    public long setMaximumSize(long r2) {
        this.delegate.setMaximumSize(r2);
        return this.delegate.getMaximumSize();
    }

    /* JADX INFO: renamed from: setMaximumSize, reason: collision with other method in class */
    public void m65setMaximumSize(long r1) {
        this.delegate.setMaximumSize(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long r1) {
        this.delegate.setPageSize(r1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
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
        int r1 = 0;
        if (r10.size() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L29;
        int r2 = r10.size();
        if (r12 != null) goto L10;
        int r3 = r2;
    L11:
        Object[] r4 = new Object[r3];
        StringBuilder r5 = new StringBuilder();
        r5.append("UPDATE ");
        r5.append(CONFLICT_VALUES[r9]);
        r5.append(r8);
        r5.append(" SET ");
        Iterator<String> r13 = r10.keySet().iterator();
    L13:
        if (r13.hasNext() == false) goto L19;
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        if (r1 <= 0) goto L17;
        String r6 = ",";
    L18:
        r5.append(r6);
        r5.append(r14);
        r4[r1] = r10.get(r14);
        r5.append("=?");
        r1 = r1 + 1;
        goto L13
    L17:
        r6 = "";
        goto L18
    L19:
        if (r12 == null) goto L24;
        int r15 = r2;
    L21:
        if (r15 >= r3) goto L24;
        r4[r15] = r12[r15 - r2];
        r15 = r15 + 1;
    L24:
        if (TextUtils.isEmpty((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L26;
        r5.append(" WHERE ");
        r5.append(r11);
    L26:
        String r16 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r16, "StringBuilder().apply(builderAction).toString()");
        SupportSQLiteStatement r7 = compileStatement(r16);
        SimpleSQLiteQuery.Companion.bind((SupportSQLiteProgram) ZeusTransformUtils.preCheckCast(r7, SupportSQLiteProgram.class, "com.obric.memorydata.plugin"), r4);
        return r7.executeUpdateDelete();
    L10:
        r3 = r12.length + r2;
        goto L11
    L29:
        throw new IllegalArgumentException("Empty values".toString());
    L5:
        r0 = false;
        goto L6
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
