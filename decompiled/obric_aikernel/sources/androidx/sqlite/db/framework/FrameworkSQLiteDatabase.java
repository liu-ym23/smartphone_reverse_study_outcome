package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {
    private static final String[] CONFLICT_VALUES = null;
    public static final Companion Companion = null;
    private static final String[] EMPTY_STRING_ARRAY = null;
    private final List<Pair<String, String>> attachedDbs;
    private final SQLiteDatabase delegate;

    @RequiresApi(30)
    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = null;

        static {
            INSTANCE = new Api30Impl();
        }

        private Api30Impl() {
        }

        @DoNotInline
        public final void execPerConnectionSQL(SQLiteDatabase r10, String r11, Object[] r12) {
            Intrinsics.checkNotNullParameter(r10, "sQLiteDatabase");
            Intrinsics.checkNotNullParameter(r11, "sql");
            r10.execPerConnectionSQL(r11, r12);
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        EMPTY_STRING_ARRAY = new String[0];
    }

    public FrameworkSQLiteDatabase(SQLiteDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.delegate = r10;
        this.attachedDbs = r10.getAttachedDbs();
    }

    public static /* synthetic */ Cursor a(SupportSQLiteQuery r10, SQLiteDatabase r11, SQLiteCursorDriver r12, String r13, SQLiteQuery r14) {
        return query$lambda$1(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Cursor c(Function4 r10, SQLiteDatabase r11, SQLiteCursorDriver r12, String r13, SQLiteQuery r14) {
        return query$lambda$0(r10, r11, r12, r13, r14);
    }

    private static final Cursor query$lambda$0(Function4 r10, SQLiteDatabase r11, SQLiteCursorDriver r12, String r13, SQLiteQuery r14) {
        Intrinsics.checkNotNullParameter(r10, "$tmp0");
        return (Cursor) r10.invoke(r11, r12, r13, r14);
    }

    private static final Cursor query$lambda$1(SupportSQLiteQuery r10, SQLiteDatabase r11, SQLiteCursorDriver r12, String r13, SQLiteQuery r14) {
        Intrinsics.checkNotNullParameter(r10, "$query");
        Intrinsics.checkNotNull(r14);
        r10.bindTo(new FrameworkSQLiteProgram(r14));
        return new SQLiteCursor(r12, r13, r14);
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
    public void beginTransactionWithListener(SQLiteTransactionListener r10) {
        Intrinsics.checkNotNullParameter(r10, "transactionListener");
        this.delegate.beginTransactionWithListener(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r10) {
        Intrinsics.checkNotNullParameter(r10, "transactionListener");
        this.delegate.beginTransactionWithListenerNonExclusive(r10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SupportSQLiteStatement compileStatement(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sql");
        SQLiteStatement r11 = this.delegate.compileStatement(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "delegate.compileStatement(sql)");
        return new FrameworkSQLiteStatement(r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r10, String r11, Object[] r12) {
        Intrinsics.checkNotNullParameter(r10, "table");
        StringBuilder r13 = new StringBuilder();
        r13.append("DELETE FROM ");
        r13.append(r10);
        if (r11 != null) goto L5;
    L8:
        boolean r14 = true;
    L9:
        if (r14 == true) goto L11;
        r13.append(" WHERE ");
        r13.append(r11);
    L11:
        String r15 = r13.toString();
        Intrinsics.checkNotNullExpressionValue(r15, "StringBuilder().apply(builderAction).toString()");
        SupportSQLiteStatement r16 = compileStatement(r15);
        SimpleSQLiteQuery.Companion.bind(r16, r12);
        return r16.executeUpdateDelete();
    L5:
        if (r11.length() == 0) goto L8;
        r14 = false;
        goto L9
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
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
    public void execPerConnectionSQL(String r10, Object[] r11) {
        Intrinsics.checkNotNullParameter(r10, "sql");
        int r12 = Build.VERSION.SDK_INT;
        if (r12 < 30) goto L7;
        Api30Impl.INSTANCE.execPerConnectionSQL(this.delegate, r10, r11);
        return;
    L7:
        throw new UnsupportedOperationException("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: " + r12);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sql");
        this.delegate.execSQL(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r10, Object[] r11) {
        Intrinsics.checkNotNullParameter(r10, "sql");
        Intrinsics.checkNotNullParameter(r11, "bindArgs");
        this.delegate.execSQL(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return this.attachedDbs;
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
        return this.delegate.insertWithOnConflict(r10, null, r12, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public final boolean isDelegate(SQLiteDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "sqLiteDatabase");
        return Intrinsics.areEqual(this.delegate, r10);
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
    @RequiresApi(api = 16)
    public boolean isWriteAheadLoggingEnabled() {
        return SupportSQLiteCompat.Api16Impl.isWriteAheadLoggingEnabled(this.delegate);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int r10) {
        return this.delegate.needUpgrade(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(final SupportSQLiteQuery r10) {
        Intrinsics.checkNotNullParameter(r10, "query");
        final Function4<SQLiteDatabase, SQLiteCursorDriver, String, SQLiteQuery, SQLiteCursor> r11 = new FrameworkSQLiteDatabase$query$cursorFactory$1(r10);
        Cursor r12 = this.delegate.rawQueryWithFactory(new b(r11), r10.getSql(), EMPTY_STRING_ARRAY, null);
        Intrinsics.checkNotNullExpressionValue(r12, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return r12;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(16)
    public Cursor query(final SupportSQLiteQuery r10, CancellationSignal r11) {
        Intrinsics.checkNotNullParameter(r10, "query");
        SQLiteDatabase r12 = this.delegate;
        String r13 = r10.getSql();
        String[] r14 = EMPTY_STRING_ARRAY;
        Intrinsics.checkNotNull(r11);
        return SupportSQLiteCompat.Api16Impl.rawQueryWithFactory(r12, r13, r14, null, r11, new a(r10));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r10) {
        Intrinsics.checkNotNullParameter(r10, "query");
        return query(new SimpleSQLiteQuery(r10));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public Cursor query(String r10, Object[] r11) {
        Intrinsics.checkNotNullParameter(r10, "query");
        Intrinsics.checkNotNullParameter(r11, "bindArgs");
        return query(new SimpleSQLiteQuery(r10, r11));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    @RequiresApi(api = 16)
    public void setForeignKeyConstraintsEnabled(boolean r10) {
        SupportSQLiteCompat.Api16Impl.setForeignKeyConstraintsEnabled(this.delegate, r10);
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
        this.delegate.setMaximumSize(r10);
        return this.delegate.getMaximumSize();
    }

    /* JADX INFO: renamed from: setMaximumSize, reason: collision with other method in class */
    public void m8setMaximumSize(long r10) {
        this.delegate.setMaximumSize(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long r10) {
        this.delegate.setPageSize(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
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
        int r15 = 0;
        if (r12.size() == 0) goto L5;
        boolean r16 = true;
    L6:
        if (r16 == false) goto L29;
        int r17 = r12.size();
        if (r14 != null) goto L10;
        int r18 = r17;
    L11:
        Object[] r19 = new Object[r18];
        StringBuilder r20 = new StringBuilder();
        r20.append("UPDATE ");
        r20.append(CONFLICT_VALUES[r11]);
        r20.append(r10);
        r20.append(" SET ");
        Iterator<String> r21 = r12.keySet().iterator();
    L13:
        if (r21.hasNext() == false) goto L19;
        String r22 = r21.next();
        if (r15 <= 0) goto L17;
        String r23 = ",";
    L18:
        r20.append(r23);
        r20.append(r22);
        r19[r15] = r12.get(r22);
        r20.append("=?");
        r15 = r15 + 1;
        goto L13
    L17:
        r23 = "";
        goto L18
    L19:
        if (r14 == null) goto L24;
        int r24 = r17;
    L21:
        if (r24 >= r18) goto L24;
        r19[r24] = r14[r24 - r17];
        r24 = r24 + 1;
    L24:
        if (TextUtils.isEmpty(r13) == true) goto L26;
        r20.append(" WHERE ");
        r20.append(r13);
    L26:
        String r25 = r20.toString();
        Intrinsics.checkNotNullExpressionValue(r25, "StringBuilder().apply(builderAction).toString()");
        SupportSQLiteStatement r26 = compileStatement(r25);
        SimpleSQLiteQuery.Companion.bind(r26, r19);
        return r26.executeUpdateDelete();
    L10:
        r18 = r14.length + r17;
        goto L11
    L29:
        throw new IllegalArgumentException("Empty values".toString());
    L5:
        r16 = false;
        goto L6
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
