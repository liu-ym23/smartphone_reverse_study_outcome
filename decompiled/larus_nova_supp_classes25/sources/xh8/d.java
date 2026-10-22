package xh8;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.larus.bmhome.chat.markdown.memory.MemoryActionTag;
import com.larus.utils.logger.FLogger;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements SupportSQLiteDatabase {
    public static final String[] b = null;
    public static final String[] c = null;
    public final SQLiteDatabase a;

    public class a implements SQLiteDatabase.CursorFactory {
        public final /* synthetic */ SupportSQLiteQuery a;

        public a(SupportSQLiteQuery r1) {
            this.a = r1;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public final Cursor newCursor(SQLiteDatabase r2, SQLiteCursorDriver r3, String r4, SQLiteQuery r5) {
            this.a.bindTo(new g(r5));
            return new SQLiteCursor(r3, r4, r5);
        }
    }

    public class b implements SQLiteDatabase.CursorFactory {
        public final /* synthetic */ SupportSQLiteQuery a;

        public b(SupportSQLiteQuery r1) {
            this.a = r1;
        }

        @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
        public final Cursor newCursor(SQLiteDatabase r2, SQLiteCursorDriver r3, String r4, SQLiteQuery r5) {
            this.a.bindTo(new g(r5));
            return new SQLiteCursor(r3, r4, r5);
        }
    }

    static {
        b = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        c = new String[0];
    }

    public final void beginTransaction() {
        this.a.beginTransaction();
    }

    public final void beginTransactionNonExclusive() {
        this.a.beginTransactionNonExclusive();
    }

    public final void close() throws IOException {
        this.a.close();     // Catch: SQLiteException -> L4
        return;
    L4:
        e = move-exception;
        e.a(e, "close");
        FLogger.a.e("FlowSQLiteDatabase", "close err", e);
    }

    public final void disableWriteAheadLogging() {
        SupportSQLiteCompat.Api16Impl.disableWriteAheadLogging(this.a);
    }

    public final boolean enableWriteAheadLogging() {
        return this.a.enableWriteAheadLogging();
    }

    public final void endTransaction() {
        this.a.endTransaction();     // Catch: SQLiteException -> L4
        return;
    L4:
        e = move-exception;
        e.a(e, "endTransaction");
        FLogger.a.e("FlowSQLiteDatabase", "endTransaction err", e);
    }

    public final List<Pair<String, String>> getAttachedDbs() {
        return this.a.getAttachedDbs();
    }

    public final long getMaximumSize() {
        return this.a.getMaximumSize();
    }

    public final long getPageSize() {
        return this.a.getPageSize();
    }

    public final String getPath() {
        return this.a.getPath();
    }

    public final int getVersion() {
        return this.a.getVersion();
    }

    public final boolean inTransaction() {
        return this.a.inTransaction();
    }

    public final boolean isDatabaseIntegrityOk() {
        return this.a.isDatabaseIntegrityOk();
    }

    public final boolean isDbLockedByCurrentThread() {
        return this.a.isDbLockedByCurrentThread();
    }

    public final boolean isExecPerConnectionSQLSupported() {
        if (Build.VERSION.SDK_INT < 30) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isOpen() {
        return this.a.isOpen();
    }

    public final boolean isReadOnly() {
        return this.a.isReadOnly();
    }

    public final boolean isWriteAheadLoggingEnabled() {
        return SupportSQLiteCompat.Api16Impl.isWriteAheadLoggingEnabled(this.a);
    }

    public final void setTransactionSuccessful() {
        this.a.setTransactionSuccessful();
    }

    public final boolean yieldIfContendedSafely() {
        return this.a.yieldIfContendedSafely();
    }

    public d(SQLiteDatabase r1) {
        this.a = r1;
    }

    public final void beginTransactionWithListener(SQLiteTransactionListener r2) {
        this.a.beginTransactionWithListener(r2);
    }

    public final void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r2) {
        this.a.beginTransactionWithListenerNonExclusive(r2);
    }

    public final SupportSQLiteStatement compileStatement(String r4) {
        return new h(this.a.compileStatement(r4));
    L4:
        th = move-exception;
        e.a(th, "compileStatement");
        FLogger.a.e("FlowSQLiteDatabase", "compileStatement err", th);
        return new xh8.b();
    }

    public final void execSQL(String r4) throws SQLException {
        this.a.execSQL(r4);     // Catch: SQLiteException -> L4
        return;
    L4:
        e = move-exception;
        e.a(e, "execSQL1");
        FLogger.a.e("FlowSQLiteDatabase", "execSQL1 err", e);
    }

    public final boolean needUpgrade(int r2) {
        return this.a.needUpgrade(r2);
    }

    public Cursor query(SupportSQLiteQuery r5) {
        return this.a.rawQueryWithFactory(new a(r5), r5.getSql(), c, null);
    L4:
        e = move-exception;
        e.a(e, "query1");
        FLogger.a.e("FlowSQLiteDatabase", "query1 err", e);
        return new xh8.a();
    }

    public final void setForeignKeyConstraintsEnabled(boolean r2) {
        SupportSQLiteCompat.Api16Impl.setForeignKeyConstraintsEnabled(this.a, r2);
    }

    public final void setLocale(Locale r2) {
        this.a.setLocale(r2);
    }

    public final void setMaxSqlCacheSize(int r2) {
        this.a.setMaxSqlCacheSize(r2);
    }

    public final long setMaximumSize(long r2) {
        return this.a.setMaximumSize(r2);
    }

    public final void setPageSize(long r2) {
        this.a.setPageSize(r2);
    }

    public final void setVersion(int r2) {
        this.a.setVersion(r2);
    }

    public final boolean yieldIfContendedSafely(long r2) {
        return this.a.yieldIfContendedSafely(r2);
    }

    public Cursor query(String r2) {
        return query(new SimpleSQLiteQuery(r2));
    }

    public final void execPerConnectionSQL(String r3, Object[] r4) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 30) goto L7;
        this.a.execPerConnectionSQL(r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: " + r0);
    }

    public final void execSQL(String r3, Object[] r4) throws SQLException {
        this.a.execSQL(r3, r4);     // Catch: SQLiteException -> L4
        return;
    L4:
        e = move-exception;
        e.a(e, "execSQL2");
        FLogger.a.e("FlowSQLiteDatabase", "execSQL2 err", e);
    }

    public Cursor query(SupportSQLiteQuery r7, CancellationSignal r8) {
        return SupportSQLiteCompat.Api16Impl.rawQueryWithFactory(this.a, r7.getSql(), c, null, r8, new b(r7));
    L4:
        e = move-exception;
        e.a(e, "query2");
        FLogger.a.e("FlowSQLiteDatabase", "query2 err", e);
        return new xh8.a();
    }

    public Cursor query(String r2, Object[] r3) {
        return query(new SimpleSQLiteQuery(r2, r3));
    }

    public int delete(String r4, String r5, Object[] r6) {
        StringBuilder r2 = new StringBuilder("DELETE FROM ");     // Catch: SQLiteException -> L9
        r2.append(r4);     // Catch: SQLiteException -> L9
        if (TextUtils.isEmpty(r5) == false) goto L6;
        String r7 = "";
    L7:
        r2.append(r7);     // Catch: SQLiteException -> L9
        SupportSQLiteStatement r8 = compileStatement(r2.toString());     // Catch: SQLiteException -> L9
        SimpleSQLiteQuery.bind(r8, r6);     // Catch: SQLiteException -> L9
        return r8.executeUpdateDelete();
    L6:
        r7 = " WHERE " + r5;     // Catch: SQLiteException -> L9
    L9:
        e = move-exception;
        e.a(e, "delete");
        FLogger.a.e("FlowSQLiteDatabase", "delete err", e);
        return 0;
    }

    public long insert(String r3, int r4, ContentValues r5) throws SQLException {
        return this.a.insertWithOnConflict(r3, null, r5, r4);
    L4:
        e = move-exception;
        e.a(e, "insert");
        FLogger.a.e("FlowSQLiteDatabase", "insert err", e);
        return 0;
    }

    public int update(String r8, int r9, ContentValues r10, String r11, Object[] r12) {
        if (r10 == null) goto L28;
    L29:
        e = move-exception;
        e.a(e, MemoryActionTag.MEMORY_ACTION_TAG_UPDATE);
        FLogger.a.e("FlowSQLiteDatabase", "update err", e);
        return 0;
    L5:
        if (r10.size() == 0) goto L28;
        StringBuilder r1 = new StringBuilder(120);     // Catch: SQLiteException -> L29
        r1.append("UPDATE ");     // Catch: SQLiteException -> L29
        r1.append(b[r9]);     // Catch: SQLiteException -> L29
        r1.append(r8);     // Catch: SQLiteException -> L29
        r1.append(" SET ");     // Catch: SQLiteException -> L29
        int r13 = r10.size();     // Catch: SQLiteException -> L29
        if (r12 != null) goto L9;
        int r14 = r13;
    L10:
        Object[] r2 = new Object[r14];     // Catch: SQLiteException -> L29
        Iterator<String> r3 = r10.keySet().iterator();     // Catch: SQLiteException -> L29
        int r4 = 0;
    L12:
        if (r3.hasNext() == false) goto L18;
        String r5 = r3.next();     // Catch: SQLiteException -> L29
        if (r4 <= 0) goto L16;
        String r6 = ",";
    L17:
        r1.append(r6);     // Catch: SQLiteException -> L29
        r1.append(r5);     // Catch: SQLiteException -> L29
        r2[r4] = r10.get(r5);     // Catch: SQLiteException -> L29
        r1.append("=?");     // Catch: SQLiteException -> L29
        r4 = r4 + 1;     // Catch: SQLiteException -> L29
        goto L12
    L16:
        r6 = "";
        goto L17
    L18:
        if (r12 == null) goto L23;
        int r15 = r13;
    L20:
        if (r15 >= r14) goto L23;
        r2[r15] = r12[r15 - r13];     // Catch: SQLiteException -> L29
        r15 = r15 + 1;     // Catch: SQLiteException -> L29
    L23:
        if (TextUtils.isEmpty(r11) == true) goto L25;
        r1.append(" WHERE ");     // Catch: SQLiteException -> L29
        r1.append(r11);     // Catch: SQLiteException -> L29
    L25:
        SupportSQLiteStatement r16 = compileStatement(r1.toString());     // Catch: SQLiteException -> L29
        SimpleSQLiteQuery.bind(r16, r2);     // Catch: SQLiteException -> L29
        return r16.executeUpdateDelete();
    L9:
        r14 = r12.length + r13;     // Catch: SQLiteException -> L29
    L28:
        throw new IllegalArgumentException("Empty values");     // Catch: SQLiteException -> L29
    }
}
