package dv;

import ai.j0;
import androidx.core.view.PointerIconCompat;
import av.g;
import av.i;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.text.Typography;
import kotlin.time.DurationKt;
import okhttp3.internal.http2.Http2Connection;
import org.sqlite.SQLiteConfig$HexKeyMode;
import org.sqlite.SQLiteConfig$Pragma;
import org.sqlite.SQLiteLimits;
import org.sqlite.SQLiteOpenMode;
import org.sqlite.core.NativeDB;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Connection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NativeDB f16711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f16712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f16713c;
    public final AtomicInteger d;
    public Map e;

    public a(String r18, String r19, Properties r20) {
        String r5 = r19;
        this.f16712b = null;
        Properties r10 = new Properties();
        r10.putAll(r20);
        int r11 = r5.indexOf(63);
        int r12 = 0;
        if (r11 == (-1)) goto L29;
        StringBuilder r13 = new StringBuilder();
        r13.append(r5.substring(0, r11));
        String[] r14 = r5.substring(r11 + 1).split("&");
        int r15 = 0;
        int r16 = 0;
    L7:
        if (r15 >= r14.length) goto L28;
        String r17 = r14[(r14.length - 1) - r15].trim();
        if (r17.isEmpty() == true) goto L27;
        String[] r110 = r17.split("=");
        String r111 = r110[0].trim().toLowerCase();
        if (av.f.f.contains(r111) == true) goto L14;
        if (r16 != 0) goto L25;
        char r112 = '?';
    L26:
        r13.append(r112);
        r13.append(r17);
        r16 = r16 + 1;
        goto L27
    L25:
        r112 = Typography.amp;
        goto L26
    L14:
        if (r110.length == 1) goto L22;
        String r113 = r110[1].trim();
        if (r113.isEmpty() == true) goto L27;
        if (r10.containsKey(r111) == true) goto L27;
        r10.setProperty(r111, r113);
        goto L27
    L22:
        throw new SQLException(androidx.constraintlayout.motion.widget.a.p("Please specify a value for PRAGMA ", r111, " in URL ", r18));
    L27:
        r15 = r15 + 1;
        goto L7
    L28:
        r5 = r13.toString();
    L29:
        av.f r21 = new av.f(r10);
        if (r5.isEmpty() == false) goto L32;
    L148:
    L134:
        e = move-exception;
        SQLException r22 = new SQLException("Error opening connection");
        r22.initCause(e);
        throw r22;
    L74:
        if (NativeDB.f21056h == true) goto L77;
        i.r();     // Catch: Exception -> L134
        NativeDB.f21056h = true;     // Catch: Exception -> L134
    L77:
        NativeDB r23 = new NativeDB(r18, r5, r21);     // Catch: Exception -> L134
        int r24 = r21.f789b;
        monitor-enter(r23);
        monitor-enter(r23);     // Catch: Throwable -> L88
        r23._open_utf8(NativeDB.o(r5), r24);     // Catch: Throwable -> L129
        monitor-exit(r23);     // Catch: Throwable -> L88
        r23.d.set(false);     // Catch: Throwable -> L88
        if (r23.f1021b.startsWith("file:") == true) goto L86;
    L90:
        av.f r25 = r23.f1022c;     // Catch: Throwable -> L88
        r25.getClass();     // Catch: Throwable -> L88
        r23.enable_load_extension(Boolean.parseBoolean(r25.f788a.getProperty(SQLiteConfig$Pragma.LOAD_EXTENSION.pragmaName, "false")));     // Catch: Throwable -> L88
        r23.busy_timeout(r23.f1022c.f790c);     // Catch: Throwable -> L88
        monitor-exit(r23);
        this.f16711a = r23;
        av.f r26 = r23.f1022c;
        r26.getClass();
        g r27 = r26.d;
        this.f16713c = new g(r27.f792a, r27.f793b, r27.f794c, r27.e, r27.f, r27.g);
        Properties r28 = r26.f788a;
        HashSet r29 = new HashSet();
        SQLiteConfig$Pragma[] r30 = SQLiteConfig$Pragma.values();
        int r31 = r30.length;
    L93:
        if (r12 >= r31) goto L95;
        r29.add(r30[r12].pragmaName);
        r12 = r12 + 1;
        goto L93
    L95:
        SQLiteLimits r32 = SQLiteLimits.SQLITE_LIMIT_ATTACHED;
        SQLiteConfig$Pragma r33 = SQLiteConfig$Pragma.LIMIT_ATTACHED;
        n(r32, r26.b(r33, 10));
        SQLiteLimits r34 = SQLiteLimits.SQLITE_LIMIT_COLUMN;
        SQLiteConfig$Pragma r35 = SQLiteConfig$Pragma.LIMIT_COLUMN;
        n(r34, r26.b(r35, 2000));
        SQLiteLimits r36 = SQLiteLimits.SQLITE_LIMIT_COMPOUND_SELECT;
        SQLiteConfig$Pragma r37 = SQLiteConfig$Pragma.LIMIT_COMPOUND_SELECT;
        n(r36, r26.b(r37, -1));
        SQLiteLimits r38 = SQLiteLimits.SQLITE_LIMIT_EXPR_DEPTH;
        SQLiteConfig$Pragma r39 = SQLiteConfig$Pragma.LIMIT_EXPR_DEPTH;
        n(r38, r26.b(r39, -1));
        SQLiteLimits r40 = SQLiteLimits.SQLITE_LIMIT_FUNCTION_ARG;
        SQLiteConfig$Pragma r114 = SQLiteConfig$Pragma.LIMIT_FUNCTION_ARG;
        n(r40, r26.b(r114, 100));
        SQLiteLimits r41 = SQLiteLimits.SQLITE_LIMIT_LENGTH;
        SQLiteConfig$Pragma r115 = SQLiteConfig$Pragma.LIMIT_LENGTH;
        n(r41, r26.b(r115, Http2Connection.DEGRADED_PONG_TIMEOUT_NS));
        SQLiteLimits r42 = SQLiteLimits.SQLITE_LIMIT_LIKE_PATTERN_LENGTH;
        SQLiteConfig$Pragma r116 = SQLiteConfig$Pragma.LIMIT_LIKE_PATTERN_LENGTH;
        n(r42, r26.b(r116, -1));
        SQLiteLimits r43 = SQLiteLimits.SQLITE_LIMIT_SQL_LENGTH;
        SQLiteConfig$Pragma r117 = SQLiteConfig$Pragma.LIMIT_SQL_LENGTH;
        n(r43, r26.b(r117, DurationKt.NANOS_IN_MILLIS));
        SQLiteLimits r44 = SQLiteLimits.SQLITE_LIMIT_TRIGGER_DEPTH;
        SQLiteConfig$Pragma r118 = SQLiteConfig$Pragma.LIMIT_TRIGGER_DEPTH;
        n(r44, r26.b(r118, -1));
        SQLiteLimits r45 = SQLiteLimits.SQLITE_LIMIT_VARIABLE_NUMBER;
        SQLiteConfig$Pragma r119 = SQLiteConfig$Pragma.LIMIT_VARIABLE_NUMBER;
        n(r45, r26.b(r119, -1));
        SQLiteLimits r46 = SQLiteLimits.SQLITE_LIMIT_VDBE_OP;
        SQLiteConfig$Pragma r47 = SQLiteConfig$Pragma.LIMIT_VDBE_OP;
        n(r46, r26.b(r47, -1));
        SQLiteLimits r48 = SQLiteLimits.SQLITE_LIMIT_WORKER_THREADS;
        SQLiteConfig$Pragma r120 = SQLiteConfig$Pragma.LIMIT_WORKER_THREADS;
        n(r48, r26.b(r120, -1));
        SQLiteLimits r49 = SQLiteLimits.SQLITE_LIMIT_PAGE_COUNT;
        SQLiteConfig$Pragma r50 = SQLiteConfig$Pragma.LIMIT_PAGE_COUNT;
        n(r49, r26.b(r50, 1073741823));
        r29.remove(SQLiteConfig$Pragma.OPEN_MODE.pragmaName);
        r29.remove(SQLiteConfig$Pragma.SHARED_CACHE.pragmaName);
        r29.remove(SQLiteConfig$Pragma.LOAD_EXTENSION.pragmaName);
        r29.remove(SQLiteConfig$Pragma.DATE_PRECISION.pragmaName);
        r29.remove(SQLiteConfig$Pragma.DATE_CLASS.pragmaName);
        r29.remove(SQLiteConfig$Pragma.DATE_STRING_FORMAT.pragmaName);
        SQLiteConfig$Pragma r51 = SQLiteConfig$Pragma.PASSWORD;
        r29.remove(r51.pragmaName);
        SQLiteConfig$Pragma r52 = SQLiteConfig$Pragma.HEXKEY_MODE;
        r29.remove(r52.pragmaName);
        r29.remove(r33.pragmaName);
        r29.remove(r35.pragmaName);
        r29.remove(r37.pragmaName);
        r29.remove(r39.pragmaName);
        r29.remove(r114.pragmaName);
        r29.remove(r115.pragmaName);
        r29.remove(r116.pragmaName);
        r29.remove(r117.pragmaName);
        r29.remove(r118.pragmaName);
        r29.remove(r119.pragmaName);
        r29.remove(r47.pragmaName);
        r29.remove(r120.pragmaName);
        r29.remove(r50.pragmaName);
        Statement r53 = createStatement();
    L105:
        th = move-exception;
        if (r53 == null) goto L128;
        r53.close();
    L128:
        throw th;
    L97:
        if (r28.containsKey(r51.pragmaName) == false) goto L112;
        String r54 = r28.getProperty(r51.pragmaName);     // Catch: Throwable -> L105
        if (r54 == null) goto L112;
        if (r54.isEmpty() == true) goto L112;
        String r55 = r28.getProperty(r52.pragmaName);     // Catch: Throwable -> L105
        if (SQLiteConfig$HexKeyMode.SSE.name().equalsIgnoreCase(r55) == false) goto L108;
        String r56 = "pragma hexkey = '%s'";
    L111:
        r53.execute(String.format(r56, new Object[]{r54.replace("'", "''")}));     // Catch: Throwable -> L105
        r53.execute("select 1 from sqlite_master");     // Catch: Throwable -> L105
        goto L112
    L108:
        if (SQLiteConfig$HexKeyMode.SQLCIPHER.name().equalsIgnoreCase(r55) == false) goto L110;
        r56 = "pragma key = \"x'%s'\"";
        goto L111
    L110:
        r56 = "pragma key = '%s'";
    L112:
        Iterator r57 = r28.keySet().iterator();     // Catch: Throwable -> L105
    L113:
        if (r57.hasNext() == false) goto L122;
        String r58 = r57.next().toString();     // Catch: Throwable -> L105
        if (r29.contains(r58) == false) goto L113;
        String r59 = r28.getProperty(r58);     // Catch: Throwable -> L105
        if (r59 == null) goto L113;
        r53.execute("pragma " + r58 + "=" + r59);     // Catch: Throwable -> L105
        goto L113
    L122:
        if (r53 == null) goto L124;
        r53.close();
    L124:
        this.d = new AtomicInteger(0);
        return;
    L86:
        if (r23.f1021b.contains("cache=") == true) goto L90;
        av.f r60 = r23.f1022c;     // Catch: Throwable -> L88
        r60.getClass();     // Catch: Throwable -> L88
        r23.shared_cache(Boolean.parseBoolean(r60.f788a.getProperty(SQLiteConfig$Pragma.SHARED_CACHE.pragmaName, "false")));     // Catch: Throwable -> L88
        goto L90
    L129:
        th = move-exception;
        throw th;     // Catch: Throwable -> L88
    L88:
        th = move-exception;
        throw th;
    L32:
        if (":memory:".equals(r5) == true) goto L148;
        if (r5.startsWith("file:") == true) goto L148;
        if (r5.contains("mode=memory") == true) goto L148;
        if (r5.startsWith(":resource:") == false) goto L51;
        String r61 = r5.substring(10);
        URL r62 = Thread.currentThread().getContextClassLoader().getResource(r61);
        if (r62 != null) goto L142;
        r62 = new URL(r61);     // Catch: MalformedURLException -> L43
    L43:
        e = move-exception;
        throw new SQLException(String.format("resource %s not found: %s", new Object[]{r61, e}));
    L142:
        r5 = e(r62).getAbsolutePath();     // Catch: IOException -> L48
    L48:
        e = move-exception;
        throw new SQLException(String.format("failed to load %s: %s", new Object[]{r61, e}));
    L51:
        File r63 = new File(r5).getAbsoluteFile();
        File r64 = r63.getParentFile();
        if (r64 != null) goto L54;
    L139:
    L68:
        e = move-exception;
        throw new SQLException(androidx.room.jarjarred.org.antlr.runtime.a.o(e, j0.x("opening db: '", r5, "': ")));
    L63:
        if (r63.exists() == false) goto L65;
    L70:
        r5 = r63.getAbsolutePath();
        goto L148
    L65:
        if (r63.createNewFile() == false) goto L70;
        r63.delete();     // Catch: Exception -> L68
        goto L70
    L54:
        if (r64.exists() == true) goto L139;
        File r65 = r64;
    L56:
        if (r64 == null) goto L61;
        if (r64.exists() == true) goto L61;
        File r121 = r64;
        r64 = r64.getParentFile();
        r65 = r121;
    L61:
        throw new SQLException("path to '" + r5 + "': '" + r65 + "' does not exist");
    }

    public static void b(int r5, int r10, int r11) {
        if (r5 != 1003) goto L14;
        if (r10 != 1007) goto L12;
        if (r11 != 2) goto L10;
        return;
    L10:
        throw new SQLException("SQLite only supports closing cursors at commit");
    L12:
        throw new SQLException("SQLite only supports CONCUR_READ_ONLY cursors");
    L14:
        throw new SQLException("SQLite only supports TYPE_FORWARD_ONLY cursors");
    }

    public static File e(URL r5) {
        if (r5.getProtocol().equals("file") == true) goto L32;
        File r10 = new File(new File(System.getProperty("java.io.tmpdir")).getAbsolutePath(), String.format("sqlite-jdbc-tmp-%d.db", new Object[]{Integer.valueOf(r5.hashCode())}));
        if (r10.exists() == true) goto L12;
    L19:
        byte[] r11 = new byte[8192];
        FileOutputStream r12 = new FileOutputStream(r10);
        InputStream r13 = r5.openStream();
    L30:
        int r14 = r13.read(r11);     // Catch: Throwable -> L24
        if (r14 == (-1)) goto L26;
        r12.write(r11, 0, r14);     // Catch: Throwable -> L24
        goto L30
    L26:
        r12.close();
        r13.close();
        return r10;
    L24:
        th = move-exception;
        r12.close();
        r13.close();
        throw th;
    L12:
        if (r5.openConnection().getLastModified() >= r10.lastModified()) goto L15;
        return r10;
    L15:
        if (r10.delete() == true) goto L19;
        throw new IOException("failed to remove existing DB file: " + r10.getAbsolutePath());
    L32:
        return new File(r5.toURI());
    L6:
        e = move-exception;
        throw new IOException(e.getMessage());
    }

    @Override // java.sql.Connection
    public final void clearWarnings() {
    }

    @Override // java.sql.Connection, java.lang.AutoCloseable
    public final void close() {
        if (isClosed() == false) goto L5;
        return;
    L5:
        b r5 = this.f16712b;
        if (r5 == null) goto L8;
        r5.close();
    L8:
        NativeDB r10 = this.f16711a;
        monitor-enter(r10);
        HashMap r11 = r10.g;     // Catch: Throwable -> L25
        monitor-enter(r11);     // Catch: Throwable -> L25
        Iterator r12 = r10.g.entrySet().iterator();     // Catch: Throwable -> L18
    L14:
        if (r12.hasNext() == false) goto L21;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L18
        f r14 = (f) r13.getValue();     // Catch: Throwable -> L18
        r10.finalize(((Long) r13.getKey()).longValue());     // Catch: Throwable -> L18
        if (r14 == null) goto L20;
        r14.f16721c = 0;     // Catch: Throwable -> L18
    L20:
        r12.remove();     // Catch: Throwable -> L18
        goto L14
    L21:
        monitor-exit(r11);     // Catch: Throwable -> L18
        r10.free_functions();     // Catch: Throwable -> L25
        long r15 = r10.e;     // Catch: Throwable -> L25
        if (r15 == 0) goto L27;
        r10.finalize(r15);     // Catch: Throwable -> L25
        r10.e = 0;     // Catch: Throwable -> L25
    L27:
        long r16 = r10.f;     // Catch: Throwable -> L25
        if (r16 == 0) goto L30;
        r10.finalize(r16);     // Catch: Throwable -> L25
        r10.f = 0;     // Catch: Throwable -> L25
    L30:
        r10.d.set(true);     // Catch: Throwable -> L25
        r10._close();     // Catch: Throwable -> L25
        monitor-exit(r10);
        return;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    @Override // java.sql.Connection
    public final void commit() {
        d();
        g r5 = this.f16713c;
        if (r5.g == true) goto L7;
        boolean r10 = getAutoCommit();
        NativeDB r11 = this.f16711a;
        r11.d("commit;", r10);
        r11.d((String) g.f791h.get(r5.f), getAutoCommit());
        return;
    L7:
        throw new SQLException("database in auto-commit mode");
    }

    @Override // java.sql.Connection
    public final Array createArrayOf(String r5, Object[] r10) {
        return null;
    }

    @Override // java.sql.Connection
    public final Blob createBlob() {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.Connection
    public final Clob createClob() {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.Connection
    public final NClob createNClob() {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.Connection
    public final SQLXML createSQLXML() {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.Connection
    public final Statement createStatement(int r5, int r10, int r11) {
        d();
        b(r5, r10, r11);
        return new f(this);
    }

    @Override // java.sql.Connection
    public final Struct createStruct(String r5, Object[] r10) {
        throw new SQLException("unsupported by SQLite");
    }

    public final void d() {
        if (isClosed() == true) goto L6;
        return;
    L6:
        throw new SQLException("database connection closed");
    }

    public final bv.a f() {
        d();
        if (this.f16712b != null) goto L6;
        b r5 = new b();
        r5.f1001b = null;
        r5.f1002c = null;
        r5.d = null;
        r5.e = null;
        r5.f = null;
        r5.g = null;
        r5.f1003h = null;
        r5.f1004i = null;
        r5.f1005j = null;
        r5.f1006k = null;
        r5.f1007l = null;
        r5.f1008m = null;
        r5.f1009n = null;
        r5.f1010o = null;
        r5.f1011p = null;
        r5.f1000a = this;
        this.f16712b = r5;
    L6:
        return this.f16712b;
    }

    public final boolean g() {
        return this.f16711a.d.get();
    }

    @Override // java.sql.Connection
    public final boolean getAutoCommit() {
        d();
        return this.f16713c.g;
    }

    @Override // java.sql.Connection
    public final String getCatalog() {
        d();
        return null;
    }

    @Override // java.sql.Connection
    public final String getClientInfo(String r5) {
        return null;
    }

    @Override // java.sql.Connection
    public final int getHoldability() {
        d();
        return 2;
    }

    @Override // java.sql.Connection
    public final DatabaseMetaData getMetaData() {
        return f();
    }

    @Override // java.sql.Connection
    public final int getTransactionIsolation() {
        return this.f16713c.e;
    }

    @Override // java.sql.Connection
    public final Map getTypeMap() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.e != null) goto L8;
        this.e = new HashMap();     // Catch: Throwable -> L6
    L8:
        Map r5 = this.e;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return r5;
    }

    @Override // java.sql.Connection
    public final SQLWarning getWarnings() {
        return null;
    }

    @Override // java.sql.Connection
    public /* bridge */ /* synthetic */ boolean isClosed() {
        return g();
    }

    @Override // java.sql.Connection
    public final boolean isReadOnly() {
        if ((this.f16711a.f1022c.f789b & SQLiteOpenMode.READONLY.flag) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.sql.Connection
    public final boolean isValid(int r5) {
        if (g() == false) goto L6;
        return false;
    L6:
        Statement r10 = createStatement();
        boolean r11 = r10.execute("select 1");     // Catch: Throwable -> L10
        r10.close();
        return r11;
    L10:
        th = move-exception;
        r10.close();
        throw th;
    }

    @Override // java.sql.Wrapper
    public final boolean isWrapperFor(Class r5) {
        return r5.isInstance(this);
    }

    public final String m() {
        d();
        NativeDB r5 = this.f16711a;
        monitor-enter(r5);
        String r10 = NativeDB.p(r5.libversion_utf8());     // Catch: Throwable -> L7
        monitor-exit(r5);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public final void n(SQLiteLimits r5, int r10) {
        if (r10 < 0) goto L5;
        this.f16711a.limit(r5.getId(), r10);
        return;
    }

    @Override // java.sql.Connection
    public final String nativeSQL(String r5) {
        return r5;
    }

    @Override // java.sql.Connection
    public final CallableStatement prepareCall(String r5) {
        prepareCall(r5, PointerIconCompat.TYPE_HELP, PointerIconCompat.TYPE_CROSSHAIR, 2);
        throw null;
    }

    @Override // java.sql.Connection
    public final PreparedStatement prepareStatement(String r5, int r10, int r11, int r12) {
        d();
        b(r10, r11, r12);
        c r13 = new c(this);
        r13.d = r5;
        NativeDB r14 = this.f16711a;
        r14.l(r13);
        r13.f16720b.e = r14.b(r13.f16721c);
        r13.f16714i = r14.column_count(r13.f16721c);
        r13.f16715j = r14.bind_parameter_count(r13.f16721c);
        r13.f16716k = 0;
        r13.f = null;
        r13.e = 0;
        return r13;
    }

    @Override // java.sql.Connection
    public final void releaseSavepoint(Savepoint r5) {
        d();
        if (getAutoCommit() == true) goto L7;
        this.f16711a.d("RELEASE SAVEPOINT " + r5.getSavepointName(), false);
        return;
    L7:
        throw new SQLException("database in auto-commit mode");
    }

    @Override // java.sql.Connection
    public final void rollback(Savepoint r5) {
        d();
        if (getAutoCommit() == true) goto L7;
        String r10 = j0.C("ROLLBACK TO SAVEPOINT ", r5.getSavepointName());
        boolean r11 = getAutoCommit();
        this.f16711a.d(r10, r11);
        return;
    L7:
        throw new SQLException("database in auto-commit mode");
    }

    @Override // java.sql.Connection
    public final void setAutoCommit(boolean r5) {
        d();
        g r10 = this.f16713c;
        if (r10.g != r5) goto L5;
        return;
    L5:
        r10.g = r5;
        if (r5 == false) goto L8;
        String r11 = "commit;";
    L9:
        this.f16711a.d(r11, r5);
        return;
    L8:
        r11 = (String) g.f791h.get(r10.f);
        goto L9
    }

    @Override // java.sql.Connection
    public void setCatalog(String r5) {
        d();
    }

    @Override // java.sql.Connection
    public final void setClientInfo(String r5, String r10) {
    }

    @Override // java.sql.Connection
    public final void setHoldability(int r5) {
        d();
        if (r5 != 2) goto L6;
        return;
    L6:
        throw new SQLException("SQLite only supports CLOSE_CURSORS_AT_COMMIT");
    }

    @Override // java.sql.Connection
    public final void setReadOnly(boolean r5) {
        if (r5 != isReadOnly()) goto L6;
        return;
    L6:
        throw new SQLException("Cannot change read-only flag after establishing a connection. Use SQLiteConfig#setReadOnly and SQLiteConfig.createConnection().");
    }

    @Override // java.sql.Connection
    public final Savepoint setSavepoint() {
        d();
        if (getAutoCommit() == false) goto L5;
        this.f16713c.g = false;
    L5:
        cv.d r5 = new cv.d(this.d.incrementAndGet());
        this.f16711a.d("SAVEPOINT " + r5.getSavepointName(), false);
        return r5;
    }

    @Override // java.sql.Connection
    public final void setTransactionIsolation(int r5) {
        d();
        NativeDB r10 = this.f16711a;
        if (r5 != 1) goto L5;
        r10.d("PRAGMA read_uncommitted = true;", getAutoCommit());
    L15:
        this.f16713c.e = r5;
        return;
    L5:
        if (r5 != 2) goto L7;
    L13:
        r10.d("PRAGMA read_uncommitted = false;", getAutoCommit());
        goto L15
    L7:
        if (r5 == 4) goto L13;
        if (r5 == 8) goto L13;
        throw new SQLException(j0.h(r5, "Unsupported transaction isolation level: ", ". Must be one of TRANSACTION_READ_UNCOMMITTED, TRANSACTION_READ_COMMITTED, TRANSACTION_REPEATABLE_READ, or TRANSACTION_SERIALIZABLE in java.sql.Connection"));
    }

    @Override // java.sql.Connection
    public final void setTypeMap(Map r5) {
        monitor-enter(this);
        this.e = r5;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.sql.Wrapper
    public final Object unwrap(Class r5) {
        return r5.cast(this);
    }

    @Override // java.sql.Connection
    public final Properties getClientInfo() {
        return null;
    }

    @Override // java.sql.Connection
    public final CallableStatement prepareCall(String r5, int r10, int r11) {
        prepareCall(r5, r10, r11, 2);
        throw null;
    }

    @Override // java.sql.Connection
    public final void setClientInfo(Properties r5) {
    }

    @Override // java.sql.Connection
    public final CallableStatement prepareCall(String r5, int r10, int r11, int r12) {
        throw new SQLException("SQLite does not support Stored Procedures");
    }

    @Override // java.sql.Connection
    public final Statement createStatement() {
        return createStatement(PointerIconCompat.TYPE_HELP, PointerIconCompat.TYPE_CROSSHAIR, 2);
    }

    @Override // java.sql.Connection
    public final Statement createStatement(int r5, int r10) {
        return createStatement(r5, r10, 2);
    }

    @Override // java.sql.Connection
    public final Savepoint setSavepoint(String r5) {
        d();
        if (getAutoCommit() == false) goto L5;
        this.f16713c.g = false;
    L5:
        cv.d r10 = new cv.d(this.d.incrementAndGet(), r5);
        this.f16711a.d("SAVEPOINT " + r10.getSavepointName(), false);
        return r10;
    }

    @Override // java.sql.Connection
    public final void rollback() {
        d();
        g r5 = this.f16713c;
        if (r5.g == true) goto L7;
        boolean r10 = getAutoCommit();
        NativeDB r11 = this.f16711a;
        r11.d("rollback;", r10);
        r11.d((String) g.f791h.get(r5.f), getAutoCommit());
        return;
    L7:
        throw new SQLException("database in auto-commit mode");
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String r5, int r10) {
        return prepareStatement(r5);
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String r5, int[] r10) {
        return prepareStatement(r5);
    }

    @Override // java.sql.Connection
    public PreparedStatement prepareStatement(String r5, String[] r10) {
        return prepareStatement(r5);
    }

    @Override // java.sql.Connection
    public final PreparedStatement prepareStatement(String r5) {
        return prepareStatement(r5, PointerIconCompat.TYPE_HELP, PointerIconCompat.TYPE_CROSSHAIR, 2);
    }

    @Override // java.sql.Connection
    public final PreparedStatement prepareStatement(String r5, int r10, int r11) {
        return prepareStatement(r5, r10, r11, 2);
    }
}
