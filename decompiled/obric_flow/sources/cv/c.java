package cv;

import ai.j0;
import androidx.core.view.PointerIconCompat;
import dv.f;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.sqlite.core.NativeDB;
import org.sqlite.date.FastDateFormat;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends bv.c {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f16517l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f16518m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Pattern f16519n = null;

    static {
        f16517l = Pattern.compile("([^\\(]*)");
        f16518m = Pattern.compile("cast\\(.*?\\s+as\\s+(.*?)\\s*\\)");
        f16519n = Pattern.compile(".*?\\((.*?)\\)");
    }

    public static Calendar n(Double r16, Calendar r17) {
        double r5 = r16.doubleValue() + 0.5d;
        int r10 = (int) r5;
        double r11 = r10;
        double r12 = r5 - r11;
        if (r10 < 2299161) goto L6;
        int r13 = (int) ((r11 - 1867216.25d) / 36524.25d);
        r10 = ((r10 + 1) + r13) - ((int) (((double) r13) / 4.0d));
    L6:
        int r14 = r10 + 1524;
        int r15 = (int) ((((double) r14) - 122.1d) / 365.25d);
        int r18 = r14 - ((int) (((double) r15) * 365.25d));
        int r19 = (int) (((double) r18) / 30.6001d);
        double r20 = r19;
        if (r20 >= 13.5d) goto L9;
        int r110 = 1;
    L10:
        int r21 = r19 - r110;
        if (r21 <= 2.5d) goto L13;
        int r111 = 4716;
    L14:
        int r112 = r15 - r111;
        double r22 = ((double) (r18 - ((int) (r20 * 30.6001d)))) + r12;
        int r23 = (int) r22;
        double r24 = (r22 - ((double) r23)) * 24.0d;
        int r25 = (int) r24;
        double r26 = (r24 - ((double) r25)) * 60.0d;
        int r27 = (int) r26;
        double r28 = (r26 - ((double) r27)) * 60.0d;
        int r29 = (int) r28;
        r17.set(r112, r21 - 1, r23, r25, r27, r29);
        r17.set(14, (int) ((r28 - ((double) r29)) * 1000.0d));
        if (r112 >= 1) goto L17;
        r17.set(0, 0);
        r17.set(1, -(r112 - 1));
    L17:
        return r17;
    L13:
        r111 = 4715;
        goto L14
    L9:
        r110 = 13;
        goto L10
    }

    public final void clearWarnings() {
    }

    public final int findColumn(String r5) {
        d();
        HashMap r10 = this.f1019k;
        if (r10 != null) goto L5;
        Integer r11 = null;
    L6:
        if (r11 != null) goto L8;
        int r12 = 0;
    L10:
        String[] r13 = this.d;
        if (r12 >= r13.length) goto L21;
        if (r5.equalsIgnoreCase(r13[r12]) == true) goto L14;
        r12 = r12 + 1;
        goto L10
    L14:
        int r14 = r12 + 1;
        if (this.f1019k != null) goto L17;
        this.f1019k = new HashMap(this.d.length);
    L17:
        this.f1019k.put(r5, Integer.valueOf(r14));
        return r14;
    L21:
        throw new SQLException(j0.k("no such column: '", r5, "'"));
    L8:
        return r11.intValue();
    L5:
        r11 = (Integer) r10.get(r5);
        goto L6
    }

    public final BigDecimal getBigDecimal(int r5) {
        String r10 = getString(r5);
        if (r10 != null) goto L10;
        return null;
    L10:
        return new BigDecimal(r10);
    L9:
        throw new SQLException("Bad value for type BigDecimal : ".concat(r10));
    }

    public final InputStream getBinaryStream(int r5) {
        byte[] r10 = getBytes(r5);
        if (r10 != null) goto L5;
        return null;
    L5:
        return new ByteArrayInputStream(r10);
    }

    public final boolean getBoolean(int r5) {
        if (getInt(r5) != 0) goto L5;
        return false;
    L5:
        return true;
    }

    public final byte getByte(int r5) {
        return (byte) getInt(r5);
    }

    public final byte[] getBytes(int r5) {
        return f().column_blob(this.f1013a.f16721c, g(r5));
    }

    public final String getCatalogName(int r5) {
        NativeDB r10 = f();
        long r11 = this.f1013a.f16721c;
        int r12 = b(r5);
        monitor-enter(r10);
        String r13 = NativeDB.p(r10.column_table_name_utf8(r11, r12));     // Catch: Throwable -> L7
        monitor-exit(r10);
        return r13;
    L7:
        th = move-exception;
        throw th;
    }

    public final Reader getCharacterStream(int r5) {
        String r10 = getString(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        return new StringReader(r10);
    }

    public final String getColumnClassName(int r5) {
        b(r5);
        return "java.lang.Object";
    }

    public final int getColumnCount() {
        b(1);
        return this.e.length;
    }

    public final int getColumnDisplaySize(int r5) {
        return Integer.MAX_VALUE;
    }

    public final String getColumnLabel(int r5) {
        return getColumnName(r5);
    }

    public final String getColumnName(int r5) {
        NativeDB r10 = f();
        long r11 = this.f1013a.f16721c;
        return r10.a(b(r5), r11);
    }

    public final int getColumnType(int r10) {
        String r5 = getColumnTypeName(r10);
        int r11 = f().column_type(this.f1013a.f16721c, b(r10));
        if (r11 == 1) goto L6;
        if (r11 == 5) goto L6;
    L43:
        if (r11 == 2) goto L46;
        if (r11 == 5) goto L46;
    L64:
        if (r11 == 3) goto L67;
        if (r11 == 5) goto L67;
    L94:
        if (r11 == 4) goto L97;
        if (r11 == 5) goto L97;
    L104:
        return 2;
    L97:
        if ("BINARY".equals(r5) == false) goto L100;
        return -2;
    L100:
        if (r11 != 4) goto L102;
        return 2004;
    L102:
        if ("BLOB".equals(r5) == false) goto L104;
        return 2004;
    L67:
        if ("CHARACTER".equals(r5) == false) goto L69;
    L110:
        return 1;
    L69:
        if ("NCHAR".equals(r5) == true) goto L110;
        if ("NATIVE CHARACTER".equals(r5) == true) goto L110;
        if ("CHAR".equals(r5) == true) goto L110;
        if ("CLOB".equals(r5) == false) goto L80;
        return 2005;
    L80:
        if ("DATE".equals(r5) == false) goto L82;
    L109:
        return 91;
    L82:
        if ("DATETIME".equals(r5) == true) goto L109;
        if (r11 != 3) goto L86;
        return 12;
    L86:
        if ("VARCHAR".equals(r5) == false) goto L88;
        return 12;
    L88:
        if ("VARYING CHARACTER".equals(r5) == false) goto L90;
        return 12;
    L90:
        if ("NVARCHAR".equals(r5) == false) goto L92;
        return 12;
    L92:
        if ("TEXT".equals(r5) == false) goto L94;
        return 12;
    L46:
        if ("DECIMAL".equals(r5) == false) goto L49;
        return 3;
    L49:
        if ("DOUBLE".equals(r5) == false) goto L51;
        return 8;
    L51:
        if ("DOUBLE PRECISION".equals(r5) == false) goto L54;
        return 8;
    L54:
        if ("NUMERIC".equals(r5) == false) goto L57;
        return 2;
    L57:
        if ("REAL".equals(r5) == false) goto L60;
        return 7;
    L60:
        if (r11 != 2) goto L62;
        return 6;
    L62:
        if ("FLOAT".equals(r5) == false) goto L64;
        return 6;
    L6:
        if ("BOOLEAN".equals(r5) == false) goto L10;
        return 16;
    L10:
        if ("TINYINT".equals(r5) == false) goto L14;
        return -6;
    L14:
        if ("SMALLINT".equals(r5) == false) goto L16;
    L119:
        return 5;
    L16:
        if ("INT2".equals(r5) == true) goto L119;
        if ("BIGINT".equals(r5) == false) goto L21;
        return -5;
    L21:
        if ("INT8".equals(r5) == false) goto L23;
        return -5;
    L23:
        if ("UNSIGNED BIG INT".equals(r5) == false) goto L26;
        return -5;
    L26:
        if ("DATE".equals(r5) == false) goto L28;
    L116:
        return 91;
    L28:
        if ("DATETIME".equals(r5) == true) goto L116;
        if ("TIMESTAMP".equals(r5) == false) goto L34;
        return 93;
    L34:
        if (r11 != 1) goto L36;
    L115:
        return 4;
    L36:
        if ("INT".equals(r5) == true) goto L115;
        if ("INTEGER".equals(r5) == true) goto L115;
        if ("MEDIUMINT".equals(r5) == false) goto L43;
        goto L115
    }

    public final String getColumnTypeName(int r5) {
        String r10 = m(r5);
        if (r10 == null) goto L6;
        Matcher r11 = f16517l.matcher(r10);
        r11.find();
        return r11.group(1).toUpperCase(Locale.ENGLISH);
    L6:
        int r12 = f().column_type(this.f1013a.f16721c, b(r5));
        if (r12 != 1) goto L9;
        return "INTEGER";
    L9:
        if (r12 != 2) goto L11;
        return "FLOAT";
    L11:
        if (r12 != 3) goto L13;
        return "TEXT";
    L13:
        if (r12 == 4) goto L16;
        return "NUMERIC";
    L16:
        return "BLOB";
    }

    public final int getConcurrency() {
        return PointerIconCompat.TYPE_CROSSHAIR;
    }

    public final String getCursorName() {
        return null;
    }

    public final Date getDate(int r10) {
        NativeDB r5 = f();
        f r11 = this.f1013a;
        int r12 = r5.column_type(r11.f16721c, g(r10));
        if (r12 != 2) goto L5;
        Double r13 = Double.valueOf(r5.column_double(r11.f16721c, g(r10)));
        Calendar r14 = Calendar.getInstance();
        n(r13, r14);
        return new Date(r14.getTimeInMillis());
    L5:
        if (r12 != 3) goto L7;
        FastDateFormat r15 = e().d;     // Catch: Exception -> L14
        long r16 = r11.f16721c;     // Catch: Exception -> L14
        return new Date(r15.parse(r5.n(g(r10), r16)).getTime());
    L14:
        e = move-exception;
        SQLException r17 = new SQLException("Error parsing date");
        r17.initCause(e);
        throw r17;
    L7:
        if (r12 == 5) goto L10;
        long r18 = r5.column_long(r11.f16721c, g(r10));
        return new Date(e().a() * r18);
    L10:
        return null;
    }

    public final double getDouble(int r10) {
        NativeDB r5 = f();
        f r11 = this.f1013a;
        if (r5.column_type(r11.f16721c, g(r10)) != 5) goto L7;
        return 0.0d;
    L7:
        return r5.column_double(r11.f16721c, g(r10));
    }

    public final int getFetchDirection() {
        d();
        return 1000;
    }

    public final int getFetchSize() {
        return this.g;
    }

    public final float getFloat(int r10) {
        NativeDB r5 = f();
        f r11 = this.f1013a;
        if (r5.column_type(r11.f16721c, g(r10)) != 5) goto L7;
        return 0.0f;
    L7:
        return (float) r5.column_double(r11.f16721c, g(r10));
    }

    public final int getInt(int r5) {
        return f().column_int(this.f1013a.f16721c, g(r5));
    }

    public final long getLong(int r5) {
        return f().column_long(this.f1013a.f16721c, g(r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ResultSetMetaData getMetaData() {
        return (ResultSetMetaData) this;
    }

    public final Object getObject(int r5) {
        int r10 = f().column_type(this.f1013a.f16721c, g(r5));
        if (r10 != 1) goto L5;
        long r11 = getLong(r5);
        if (r11 > 2147483647L) goto L26;
        if (r11 < (-2147483648L)) goto L26;
        return new Integer((int) r11);
    L26:
        return new Long(r11);
    L5:
        if (r10 == 2) goto L17;
        if (r10 == 4) goto L15;
        if (r10 != 5) goto L11;
        return null;
    L11:
        return getString(r5);
    L15:
        return getBytes(r5);
    L17:
        return new Double(getDouble(r5));
    }

    public final int getPrecision(int r5) {
        String r10 = m(r5);
        if (r10 == null) goto L8;
        Matcher r11 = f16519n.matcher(r10);
        if (r11.find() == true) goto L7;
        return 0;
    L7:
        return Integer.parseInt(r11.group(1).split(",")[0].trim());
    L8:
        return 0;
    }

    public final int getRow() {
        return this.f1016h;
    }

    public final int getScale(int r5) {
        String r10 = m(r5);
        if (r10 == null) goto L10;
        Matcher r11 = f16519n.matcher(r10);
        if (r11.find() == false) goto L12;
        String[] r12 = r11.group(1).split(",");
        if (r12.length == 2) goto L9;
        return 0;
    L9:
        return Integer.parseInt(r12[1].trim());
    L12:
        return 0;
    L10:
        return 0;
    }

    public final String getSchemaName(int r5) {
        return "";
    }

    public final short getShort(int r5) {
        return (short) getInt(r5);
    }

    public final Statement getStatement() {
        return this.f1013a;
    }

    public final String getString(int r5) {
        NativeDB r10 = f();
        long r11 = this.f1013a.f16721c;
        return r10.n(g(r5), r11);
    }

    public final String getTableName(int r5) {
        NativeDB r10 = f();
        long r11 = this.f1013a.f16721c;
        int r12 = b(r5);
        monitor-enter(r10);
        String r13 = NativeDB.p(r10.column_table_name_utf8(r11, r12));     // Catch: Throwable -> L9
        monitor-exit(r10);
        if (r13 != null) goto L14;
        return "";
    L14:
        return r13;
    L9:
        th = move-exception;
        throw th;
    }

    public final Time getTime(int r10) {
        NativeDB r5 = f();
        f r11 = this.f1013a;
        int r12 = r5.column_type(r11.f16721c, g(r10));
        if (r12 != 2) goto L5;
        Double r13 = Double.valueOf(r5.column_double(r11.f16721c, g(r10)));
        Calendar r14 = Calendar.getInstance();
        n(r13, r14);
        return new Time(r14.getTimeInMillis());
    L5:
        if (r12 != 3) goto L7;
        FastDateFormat r15 = e().d;     // Catch: Exception -> L14
        long r16 = r11.f16721c;     // Catch: Exception -> L14
        return new Time(r15.parse(r5.n(g(r10), r16)).getTime());
    L14:
        e = move-exception;
        SQLException r17 = new SQLException("Error parsing time");
        r17.initCause(e);
        throw r17;
    L7:
        if (r12 == 5) goto L10;
        long r18 = r5.column_long(r11.f16721c, g(r10));
        return new Time(e().a() * r18);
    L10:
        return null;
    }

    public final Timestamp getTimestamp(int r10) {
        NativeDB r5 = f();
        f r11 = this.f1013a;
        int r12 = r5.column_type(r11.f16721c, g(r10));
        if (r12 != 2) goto L5;
        Double r13 = Double.valueOf(r5.column_double(r11.f16721c, g(r10)));
        Calendar r14 = Calendar.getInstance();
        n(r13, r14);
        return new Timestamp(r14.getTimeInMillis());
    L5:
        if (r12 != 3) goto L7;
        FastDateFormat r15 = e().d;     // Catch: Exception -> L14
        long r16 = r11.f16721c;     // Catch: Exception -> L14
        return new Timestamp(r15.parse(r5.n(g(r10), r16)).getTime());
    L14:
        e = move-exception;
        SQLException r17 = new SQLException("Error parsing time stamp");
        r17.initCause(e);
        throw r17;
    L7:
        if (r12 == 5) goto L10;
        long r18 = r5.column_long(r11.f16721c, g(r10));
        return new Timestamp(e().a() * r18);
    L10:
        return null;
    }

    public final int getType() {
        return PointerIconCompat.TYPE_HELP;
    }

    public final SQLWarning getWarnings() {
        return null;
    }

    public final boolean isAfterLast() {
        return !this.f1014b;
    }

    public final boolean isAutoIncrement(int r5) {
        b(1);
        if (this.f != null) goto L6;
        f r10 = this.f1013a;
        dv.a r11 = r10.f16719a;
        long r12 = r10.f16721c;
        this.f = r11.f16711a.column_metadata(r12);
    L6:
        return this.f[b(r5)][2];
    }

    public final boolean isBeforeFirst() {
        if (this.f1014b == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f1016h != 0) goto L7;
        return true;
    }

    public final boolean isCaseSensitive(int r5) {
        return true;
    }

    public final boolean isCurrency(int r5) {
        return false;
    }

    public final boolean isDefinitelyWritable(int r5) {
        return true;
    }

    public final boolean isFirst() {
        if (this.f1016h == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isLast() {
        throw new SQLException("function not yet implemented for SQLite");
    }

    public final int isNullable(int r10) {
        b(1);
        if (this.f != null) goto L6;
        f r5 = this.f1013a;
        dv.a r11 = r5.f16719a;
        long r12 = r5.f16721c;
        this.f = r11.f16711a.column_metadata(r12);
    L6:
        return !this.f[b(r10)][1] ? 1 : 0;
    }

    public final boolean isReadOnly(int r5) {
        return false;
    }

    public final boolean isSearchable(int r5) {
        return true;
    }

    public final boolean isSigned(int r5) {
        String r10 = getColumnTypeName(r5);
        if ("NUMERIC".equals(r10) == false) goto L5;
    L10:
        return true;
    L5:
        if ("INTEGER".equals(r10) == true) goto L10;
        if ("REAL".equals(r10) == true) goto L10;
        return false;
    }

    public final boolean isWritable(int r5) {
        return true;
    }

    public final String m(int r5) {
        NativeDB r10 = f();
        long r11 = this.f1013a.f16721c;
        int r12 = b(r5);
        monitor-enter(r10);
        String r13 = NativeDB.p(r10.column_decltype_utf8(r11, r12));     // Catch: Throwable -> L13
        monitor-exit(r10);
        if (r13 != null) goto L12;
        Pattern r14 = f16518m;
        long r15 = this.f1013a.f16721c;
        Matcher r16 = r14.matcher(r10.a(b(r5), r15));
        if (r16.find() == false) goto L11;
        String r17 = r16.group(1);
    L18:
        return r17;
    L11:
        r17 = null;
        goto L18
    L12:
        return r13;
    L13:
        th = move-exception;
        throw th;
    }

    public final boolean next() {
        if (this.f1014b == true) goto L5;
        return false;
    L5:
        this.f1017i = -1;
        int r5 = this.f1016h;
        if (r5 != 0) goto L9;
        this.f1016h = r5 + 1;
        return true;
    L9:
        int r10 = this.f1015c;
        if (r10 == 0) goto L13;
        if (r5 != r10) goto L13;
        return false;
    L13:
        int r11 = f().step(this.f1013a.f16721c);
        if (r11 != 100) goto L16;
        this.f1016h++;
        return true;
    L16:
        if (r11 != 101) goto L20;
        close();
        return false;
    L20:
        throw f().i(r11);
    }

    public final boolean rowDeleted() {
        return false;
    }

    public final boolean rowInserted() {
        return false;
    }

    public final boolean rowUpdated() {
        return false;
    }

    public final void setFetchDirection(int r5) {
        d();
        if (r5 != 1000) goto L6;
        return;
    L6:
        throw new SQLException("only FETCH_FORWARD direction supported");
    }

    public final void setFetchSize(int r5) {
        if (r5 < 0) goto L8;
        int r10 = this.f1015c;
        if (r10 == 0) goto L6;
        if (r5 > r10) goto L8;
    L6:
        this.g = r5;
        return;
    L8:
        StringBuilder r11 = j0.s(r5, "fetch size ", " out of bounds ");
        r11.append(this.f1015c);
        throw new SQLException(r11.toString());
    }

    public final boolean wasNull() {
        if (f().column_type(this.f1013a.f16721c, g(this.f1017i)) != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getBoolean(String r5) {
        return getBoolean(findColumn(r5));
    }

    public final byte getByte(String r5) {
        return (byte) getInt(findColumn(r5));
    }

    public final byte[] getBytes(String r5) {
        return getBytes(findColumn(r5));
    }

    public final short getShort(String r5) {
        return (short) getInt(findColumn(r5));
    }

    public final InputStream getBinaryStream(String r5) {
        return getBinaryStream(findColumn(r5));
    }

    public final Reader getCharacterStream(String r5) {
        return getCharacterStream(findColumn(r5));
    }

    public final int getInt(String r5) {
        return getInt(findColumn(r5));
    }

    public final long getLong(String r5) {
        return getLong(findColumn(r5));
    }

    public final String getString(String r5) {
        return getString(findColumn(r5));
    }

    public final BigDecimal getBigDecimal(String r5) {
        return getBigDecimal(findColumn(r5));
    }

    public final double getDouble(String r5) {
        return getDouble(findColumn(r5));
    }

    public final float getFloat(String r5) {
        return getFloat(findColumn(r5));
    }

    public final Object getObject(String r5) {
        return getObject(findColumn(r5));
    }

    public final Date getDate(int r10, Calendar r11) {
        if (r11 == null) goto L20;
        NativeDB r5 = f();
        f r12 = this.f1013a;
        int r13 = r5.column_type(r12.f16721c, g(r10));
        if (r13 != 2) goto L6;
        n(Double.valueOf(r5.column_double(r12.f16721c, g(r10))), r11);
        return new Date(r11.getTimeInMillis());
    L6:
        if (r13 != 3) goto L8;
        FastDateFormat r14 = FastDateFormat.getInstance(e().f794c, r11.getTimeZone());     // Catch: Exception -> L15
        long r15 = r12.f16721c;     // Catch: Exception -> L15
        return new Date(r14.parse(r5.n(g(r10), r15)).getTime());
    L15:
        e = move-exception;
        SQLException r16 = new SQLException("Error parsing time stamp");
        r16.initCause(e);
        throw r16;
    L8:
        if (r13 == 5) goto L11;
        long r17 = r5.column_long(r12.f16721c, g(r10));
        r11.setTimeInMillis(e().a() * r17);
        return new Date(r11.getTime().getTime());
    L11:
        return null;
    L20:
        SQLException r18 = new SQLException("Expected a calendar instance.");
        r18.initCause(new NullPointerException());
        throw r18;
    }

    public final Time getTime(int r10, Calendar r11) {
        if (r11 == null) goto L20;
        NativeDB r5 = f();
        f r12 = this.f1013a;
        int r13 = r5.column_type(r12.f16721c, g(r10));
        if (r13 != 2) goto L6;
        n(Double.valueOf(r5.column_double(r12.f16721c, g(r10))), r11);
        return new Time(r11.getTimeInMillis());
    L6:
        if (r13 != 3) goto L8;
        FastDateFormat r14 = FastDateFormat.getInstance(e().f794c, r11.getTimeZone());     // Catch: Exception -> L15
        long r15 = r12.f16721c;     // Catch: Exception -> L15
        return new Time(r14.parse(r5.n(g(r10), r15)).getTime());
    L15:
        e = move-exception;
        SQLException r16 = new SQLException("Error parsing time");
        r16.initCause(e);
        throw r16;
    L8:
        if (r13 == 5) goto L11;
        long r17 = r5.column_long(r12.f16721c, g(r10));
        r11.setTimeInMillis(e().a() * r17);
        return new Time(r11.getTime().getTime());
    L11:
        return null;
    L20:
        SQLException r18 = new SQLException("Expected a calendar instance.");
        r18.initCause(new NullPointerException());
        throw r18;
    }

    public final Timestamp getTimestamp(int r10, Calendar r11) {
        if (r11 == null) goto L4;
        NativeDB r5 = f();
        f r12 = this.f1013a;
        int r13 = r5.column_type(r12.f16721c, g(r10));
        if (r13 != 2) goto L8;
        n(Double.valueOf(r5.column_double(r12.f16721c, g(r10))), r11);
        return new Timestamp(r11.getTimeInMillis());
    L8:
        if (r13 != 3) goto L10;
        FastDateFormat r14 = FastDateFormat.getInstance(e().f794c, r11.getTimeZone());     // Catch: Exception -> L17
        long r15 = r12.f16721c;     // Catch: Exception -> L17
        return new Timestamp(r14.parse(r5.n(g(r10), r15)).getTime());
    L17:
        e = move-exception;
        SQLException r16 = new SQLException("Error parsing time stamp");
        r16.initCause(e);
        throw r16;
    L10:
        if (r13 == 5) goto L13;
        long r17 = r5.column_long(r12.f16721c, g(r10));
        r11.setTimeInMillis(e().a() * r17);
        return new Timestamp(r11.getTime().getTime());
    L13:
        return null;
    L4:
        return getTimestamp(r10);
    }

    public final Timestamp getTimestamp(String r5) {
        return getTimestamp(findColumn(r5));
    }

    public final Timestamp getTimestamp(String r5, Calendar r10) {
        return getTimestamp(findColumn(r5), r10);
    }

    public final Date getDate(String r5) {
        return getDate(findColumn(r5), Calendar.getInstance());
    }

    public final Time getTime(String r5) {
        return getTime(findColumn(r5));
    }

    public final Date getDate(String r5, Calendar r10) {
        return getDate(findColumn(r5), r10);
    }

    public final Time getTime(String r5, Calendar r10) {
        return getTime(findColumn(r5), r10);
    }
}
