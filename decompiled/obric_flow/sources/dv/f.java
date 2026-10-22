package dv;

import ai.j0;
import androidx.core.view.PointerIconCompat;
import io.reactivex.internal.observers.h;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import org.sqlite.SQLiteConfig$Pragma;
import org.sqlite.core.NativeDB;

/* JADX INFO: loaded from: classes3.dex */
public class f implements Statement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f16719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f16720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f16721c;
    public String d;
    public int e;
    public Object[] f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16722h;

    public f(a r5) {
        this.d = null;
        this.f = null;
        this.g = false;
        this.f16719a = r5;
        this.f16720b = new e(this);
        this.f16722h = false;
    }

    @Override // java.sql.Statement
    public void addBatch(String r5) {
        f();
        Object[] r10 = this.f;
        if (r10 != null) goto L5;
    L6:
        Object[] r11 = new Object[Math.max(10, this.e * 2)];
        Object[] r12 = this.f;
        if (r12 == null) goto L9;
        System.arraycopy(r12, 0, r11, 0, r12.length);
    L9:
        this.f = r11;
    L10:
        Object[] r13 = this.f;
        int r14 = this.e;
        this.e = r14 + 1;
        r13[r14] = r5;
        return;
    L5:
        if ((this.e + 1) < r10.length) goto L10;
        goto L6
    }

    public final void b() {
        if (this.f16721c == 0) goto L6;
        return;
    L6:
        throw new SQLException("statement is not executing");
    }

    @Override // java.sql.Statement
    public final void cancel() {
        this.f16719a.f16711a.interrupt();
    }

    @Override // java.sql.Statement
    public void clearBatch() {
        int r5 = 0;
        this.e = 0;
        if (this.f == null) goto L7;
    L4:
        Object[] r10 = this.f;
        if (r5 >= r10.length) goto L9;
        r10[r5] = null;
        r5 = r5 + 1;
        goto L4
    L9:
        return;
    }

    @Override // java.sql.Statement
    public final void clearWarnings() {
    }

    @Override // java.sql.Statement, java.lang.AutoCloseable
    public final void close() {
        f();
        this.f16722h = true;
    }

    public final boolean d() {
        NativeDB r5 = this.f16719a.f16711a;
        if (this.d == null) goto L18;
        if (this.f16720b.f1014b == true) goto L16;
        this.g = r5.e(this, null);
        if (r5.column_count(this.f16721c) == 0) goto L21;
        return true;
    L21:
        return false;
    L12:
        th = move-exception;
        this.g = false;
        r5.h(this);
        throw th;
    L16:
        throw new SQLException("SQLite JDBC internal error: rs.isOpen() on exec.");
    L18:
        throw new SQLException("SQLiteJDBC internal error: sql==null");
    }

    public final ResultSet e(String r5) {
        this.f16720b.f1018j = true;
        return executeQuery(r5);
    }

    @Override // java.sql.Statement
    public boolean execute(String r5) {
        f();
        av.c r10 = h.r(r5);
        NativeDB r11 = this.f16719a.f16711a;
        if (r10 == null) goto L6;
        r10.a(r11);
        return false;
    L6:
        this.d = r5;
        r11.l(this);
        return d();
    }

    @Override // java.sql.Statement
    public int[] executeBatch() {
        f();
        int r5 = 0;
        if (this.f == null) goto L32;
        int r10 = this.e;
        if (r10 == 0) goto L32;
        int[] r11 = new int[r10];
        NativeDB r12 = this.f16719a.f16711a;
        monitor-enter(r12);
    L9:
        if (r5 >= r10) goto L26;
        this.d = (String) this.f[r5];     // Catch: Throwable -> L15 SQLException -> L17
        r12.l(this);     // Catch: Throwable -> L15 SQLException -> L17
        r11[r5] = r12.g(this, null);     // Catch: Throwable -> L15 SQLException -> L17
    L36:
        r12.h(this);     // Catch: Throwable -> L13
        r5 = r5 + 1;
    L15:
        th = move-exception;
        r12.h(this);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        clearBatch();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    L17:
        e = move-exception;
        throw new BatchUpdateException("batch entry " + r5 + ": " + e.getMessage(), r11);     // Catch: Throwable -> L15
    L26:
        clearBatch();     // Catch: Throwable -> L24
        monitor-exit(r12);     // Catch: Throwable -> L24
        return r11;
    L32:
        return new int[0];
    }

    @Override // java.sql.Statement
    public ResultSet executeQuery(String r5) {
        f();
        this.d = r5;
        this.f16719a.f16711a.l(this);
        if (d() == true) goto L5;
        f();
        throw new SQLException("query does not return ResultSet", "SQLITE_DONE", 101);
    L5:
        return getResultSet();
    }

    @Override // java.sql.Statement
    public int executeUpdate(String r5) {
        f();
        this.d = r5;
        NativeDB r10 = this.f16719a.f16711a;
        av.c r11 = h.r(r5);
        if (r11 == null) goto L24;
        r11.a(r10);
        return 0;
    L24:
        int r12 = r10.total_changes();     // Catch: Throwable -> L13
        monitor-enter(r10);     // Catch: Throwable -> L13
        int r13 = r10._exec_utf8(NativeDB.o(r5));     // Catch: Throwable -> L17
        monitor-exit(r10);     // Catch: Throwable -> L13
        if (r13 != 0) goto L16;
        int r14 = r10.total_changes() - r12;
        f();
        return r14;
    L16:
        throw bv.d.j(r13, "");     // Catch: Throwable -> L13
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        f();
        throw th;
    }

    public final void f() {
        if (this.f16721c != 0) goto L5;
        return;
    L5:
        a r5 = this.f16719a;
        if (r5.isClosed() == true) goto L16;
        this.f16720b.close();
        this.f = null;
        this.e = 0;
        NativeDB r10 = r5.f16711a;
        int r11 = r10.h(this);
        if (r11 != 0) goto L10;
        return;
    L10:
        if (r11 != 21) goto L13;
        return;
    L13:
        throw r10.i(r11);
    L16:
        throw bv.d.j(1, "Connection is closed");
    }

    public SQLException g() {
        return new SQLException("not implemented by SQLite JDBC driver");
    }

    @Override // java.sql.Statement
    public final Connection getConnection() {
        return this.f16719a;
    }

    @Override // java.sql.Statement
    public final int getFetchDirection() {
        return 1000;
    }

    @Override // java.sql.Statement
    public final int getFetchSize() {
        return this.f16720b.getFetchSize();
    }

    @Override // java.sql.Statement
    public final ResultSet getGeneratedKeys() {
        cv.b r5 = (cv.b) this.f16719a.f();
        if (r5.f1011p != null) goto L6;
        r5.f1011p = r5.f1000a.prepareStatement("select last_insert_rowid();");
    L6:
        return r5.f1011p.executeQuery();
    }

    @Override // java.sql.Statement
    public final int getMaxFieldSize() {
        return 0;
    }

    @Override // java.sql.Statement
    public final int getMaxRows() {
        return this.f16720b.f1015c;
    }

    @Override // java.sql.Statement
    public final boolean getMoreResults() {
        getMoreResults(0);
        return false;
    }

    @Override // java.sql.Statement
    public final int getQueryTimeout() {
        return this.f16719a.f16711a.f1022c.f790c;
    }

    @Override // java.sql.Statement
    public final ResultSet getResultSet() {
        b();
        e r5 = this.f16720b;
        if (r5.f1014b == true) goto L14;
        a r10 = this.f16719a;
        long r11 = this.f16721c;
        NativeDB r12 = r10.f16711a;
        if (r12.column_count(r11) != 0) goto L9;
        return null;
    L9:
        if (r5.e != null) goto L11;
        r5.e = r12.b(this.f16721c);
    L11:
        r5.d = r5.e;
        r5.f1014b = this.g;
        this.g = false;
        return r5;
    L14:
        throw new SQLException("ResultSet already requested");
    }

    @Override // java.sql.Statement
    public final int getResultSetConcurrency() {
        return PointerIconCompat.TYPE_CROSSHAIR;
    }

    @Override // java.sql.Statement
    public final int getResultSetHoldability() {
        return 2;
    }

    @Override // java.sql.Statement
    public final int getResultSetType() {
        return PointerIconCompat.TYPE_HELP;
    }

    @Override // java.sql.Statement
    public int getUpdateCount() {
        a r5 = this.f16719a;
        long r10 = this.f16721c;
        if (r10 != 0) goto L5;
        return -1;
    L5:
        if (this.f16720b.f1014b == false) goto L7;
        return -1;
    L7:
        if (this.g == true) goto L15;
        NativeDB r11 = r5.f16711a;
        if (r11.column_count(r10) == 0) goto L11;
        return -1;
    L11:
        return r11.changes();
    L15:
        return -1;
    }

    @Override // java.sql.Statement
    public final SQLWarning getWarnings() {
        return null;
    }

    @Override // java.sql.Statement
    public final boolean isClosed() {
        return this.f16722h;
    }

    @Override // java.sql.Statement
    public final boolean isPoolable() {
        return false;
    }

    @Override // java.sql.Wrapper
    public final boolean isWrapperFor(Class r5) {
        return r5.isInstance(this);
    }

    @Override // java.sql.Statement
    public final void setCursorName(String r5) {
    }

    @Override // java.sql.Statement
    public final void setEscapeProcessing(boolean r5) {
        if (r5 == true) goto L5;
        return;
    L5:
        throw g();
    }

    @Override // java.sql.Statement
    public final void setFetchDirection(int r5) {
        switch(r5) {
            case 1000: goto L5;
            case 1001: goto L5;
            case 1002: goto L5;
            default: goto L4;
        };
    L5:
        return;
    L4:
        throw new SQLException(j0.h(r5, "Unknown fetch direction ", ". Must be one of FETCH_FORWARD, FETCH_REVERSE, or FETCH_UNKNOWN in java.sql.ResultSet"));
    }

    @Override // java.sql.Statement
    public final void setFetchSize(int r5) {
        this.f16720b.setFetchSize(r5);
    }

    @Override // java.sql.Statement
    public final void setMaxFieldSize(int r5) {
        if (r5 < 0) goto L5;
        return;
    L5:
        throw new SQLException(j0.h(r5, "max field size ", " cannot be negative"));
    }

    @Override // java.sql.Statement
    public final void setMaxRows(int r5) {
        if (r5 < 0) goto L6;
        this.f16720b.f1015c = r5;
        return;
    L6:
        throw new SQLException("max row count must be >= 0");
    }

    @Override // java.sql.Statement
    public final void setPoolable(boolean r5) {
    }

    @Override // java.sql.Statement
    public final void setQueryTimeout(int r5) {
        if (r5 < 0) goto L6;
        int r10 = r5 * 1000;
        NativeDB r11 = this.f16719a.f16711a;
        av.f r12 = r11.f1022c;
        r12.getClass();
        SQLiteConfig$Pragma r13 = SQLiteConfig$Pragma.BUSY_TIMEOUT;
        String r14 = Integer.toString(r10);
        r12.f788a.put(r13.pragmaName, r14);
        r11.busy_timeout(r10);
        return;
    L6:
        throw new SQLException("query timeout must be >= 0");
    }

    @Override // java.sql.Wrapper
    public final Object unwrap(Class r5) {
        return r5.cast(this);
    }

    @Override // java.sql.Statement
    public final boolean getMoreResults(int r5) {
        b();
        f();
        return false;
    }

    @Override // java.sql.Statement
    public final boolean execute(String r5, int[] r10) {
        throw g();
    }

    @Override // java.sql.Statement
    public final boolean execute(String r5, String[] r10) {
        throw g();
    }

    @Override // java.sql.Statement
    public final boolean execute(String r5, int r10) {
        throw g();
    }

    @Override // java.sql.Statement
    public final int executeUpdate(String r5, int r10) {
        throw g();
    }

    @Override // java.sql.Statement
    public final int executeUpdate(String r5, int[] r10) {
        throw g();
    }

    @Override // java.sql.Statement
    public final int executeUpdate(String r5, String[] r10) {
        throw g();
    }
}
