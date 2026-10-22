package dv;

import av.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Calendar;
import org.sqlite.core.NativeDB;
import org.sqlite.date.FastDateFormat;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends f implements PreparedStatement, ParameterMetaData {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16714i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16715j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f16716k;

    public static byte[] n(InputStream r5, int r10) {
        if (r10 < 0) goto L16;
        byte[] r11 = new byte[r10];
        int r12 = 0;
    L4:
        if (r12 >= r10) goto L14;
        int r13 = r5.read(r11, r12, r10 - r12);     // Catch: IOException -> L11
        if (r13 == (-1)) goto L10;
        r12 = r12 + r13;     // Catch: IOException -> L11
        goto L4
    L10:
        throw new IOException("End of stream has been reached");     // Catch: IOException -> L11
    L11:
        e = move-exception;
        SQLException r14 = new SQLException("Error reading stream");
        r14.initCause(e);
        throw r14;
    L14:
        return r11;
    L16:
        throw new SQLException("Error reading stream. Length should be non-negative");
    }

    @Override // java.sql.PreparedStatement
    public final void addBatch() {
        b();
        int r5 = this.e;
        int r10 = this.f16715j;
        int r11 = r5 + r10;
        this.e = r11;
        this.f16716k++;
        if (this.f != null) goto L5;
        this.f = new Object[r10];
    L5:
        int r12 = r11 + r10;
        Object[] r13 = this.f;
        if (r12 <= r13.length) goto L8;
        Object[] r14 = new Object[r13.length * 2];
        System.arraycopy(r13, 0, r14, 0, r13.length);
        this.f = r14;
    L8:
        Object[] r15 = this.f;
        int r16 = this.e;
        System.arraycopy(r15, r16 - r10, r15, r16, r10);
    }

    @Override // dv.f, java.sql.Statement
    public final void clearBatch() {
        super.clearBatch();
        this.f16716k = 0;
    }

    @Override // java.sql.PreparedStatement
    public final void clearParameters() {
        b();
        a r5 = this.f16719a;
        long r10 = this.f16721c;
        r5.f16711a.clear_bindings(r10);
        if (this.f == null) goto L8;
        int r11 = this.e;
    L6:
        if (r11 >= (this.e + this.f16715j)) goto L10;
        this.f[r11] = null;
        r11 = r11 + 1;
        goto L6
    L10:
        return;
    }

    @Override // java.sql.PreparedStatement
    public final boolean execute() {
        b();
        this.f16720b.close();
        a r5 = this.f16719a;
        long r10 = this.f16721c;
        NativeDB r11 = r5.f16711a;
        r11.reset(r10);
        this.g = r11.e(this, this.f);     // Catch: Throwable -> L11
        boolean r12 = true;
        if (this.f16714i != 0) goto L8;
        return false;
    L8:
        return true;
    L9:
        Throwable th2 = th;
    L13:
        if (r12 == true) goto L17;
        long r13 = this.f16721c;
        if (r13 == 0) goto L17;
        r11.reset(r13);
    L17:
        throw th2;
    L11:
        th = move-exception;
        r12 = false;
        th2 = th;
        goto L13
    }

    @Override // dv.f, java.sql.Statement
    public final int[] executeBatch() {
        int r5 = this.f16716k;
        if (r5 == 0) goto L5;
        a r10 = this.f16719a;     // Catch: Throwable -> L9
        int[] r11 = r10.f16711a.f(this.f16721c, r5, this.f, r10.getAutoCommit());     // Catch: Throwable -> L9
        clearBatch();
        return r11;
    L9:
        th = move-exception;
        clearBatch();
        throw th;
    L5:
        return new int[0];
    }

    @Override // java.sql.PreparedStatement
    public final ResultSet executeQuery() {
        b();
        if (this.f16714i == 0) goto L14;
        this.f16720b.close();
        a r5 = this.f16719a;
        long r10 = this.f16721c;
        NativeDB r11 = r5.f16711a;
        r11.reset(r10);
        this.g = r11.e(this, this.f);     // Catch: Throwable -> L8
        return getResultSet();
    L8:
        th = move-exception;
        long r12 = this.f16721c;
        if (r12 == 0) goto L12;
        r11.reset(r12);
    L12:
        throw th;
    L14:
        throw new SQLException("Query does not return results");
    }

    @Override // java.sql.PreparedStatement
    public final int executeUpdate() {
        b();
        if (this.f16714i != 0) goto L7;
        this.f16720b.close();
        a r5 = this.f16719a;
        long r10 = this.f16721c;
        NativeDB r11 = r5.f16711a;
        r11.reset(r10);
        return r11.g(this, this.f);
    L7:
        throw new SQLException("Query returns results");
    }

    @Override // dv.f
    public final SQLException g() {
        return new SQLException("not implemented by SQLite JDBC driver");
    }

    @Override // java.sql.PreparedStatement
    public final ResultSetMetaData getMetaData() {
        b();
        return this.f16720b;
    }

    @Override // java.sql.ParameterMetaData
    public final String getParameterClassName(int r5) {
        b();
        return "java.lang.String";
    }

    @Override // java.sql.ParameterMetaData
    public final int getParameterCount() {
        b();
        return this.f16715j;
    }

    @Override // java.sql.PreparedStatement
    public final ParameterMetaData getParameterMetaData() {
        return this;
    }

    @Override // java.sql.ParameterMetaData
    public final int getParameterMode(int r5) {
        return 1;
    }

    @Override // java.sql.ParameterMetaData
    public final int getParameterType(int r5) {
        return 12;
    }

    @Override // java.sql.ParameterMetaData
    public final String getParameterTypeName(int r5) {
        return "VARCHAR";
    }

    @Override // java.sql.ParameterMetaData
    public final int getPrecision(int r5) {
        return 0;
    }

    @Override // java.sql.ParameterMetaData
    public final int getScale(int r5) {
        return 0;
    }

    @Override // dv.f, java.sql.Statement
    public final int getUpdateCount() {
        if (this.f16721c != 0) goto L5;
        return -1;
    L5:
        if (this.g == false) goto L7;
        return -1;
    L7:
        if (this.f16720b.f1014b == false) goto L10;
        return -1;
    L10:
        return this.f16719a.f16711a.changes();
    }

    @Override // java.sql.ParameterMetaData
    public final int isNullable(int r5) {
        return 1;
    }

    @Override // java.sql.ParameterMetaData
    public final boolean isSigned(int r5) {
        return true;
    }

    public final void m(int r5, Object r10) {
        b();
        if (this.f != null) goto L5;
        this.f = new Object[this.f16715j];
    L5:
        this.f[(this.e + r5) - 1] = r10;
    }

    public final void p(int r10, Long r11, Calendar r12) {
        a r5 = this.f16719a;
        int[] r13 = bv.b.f1012a;
        g r14 = r5.f16713c;
        int r15 = r13[r14.f792a.ordinal()];
        if (r15 != 1) goto L5;
        m(r10, FastDateFormat.getInstance(r14.f794c, r12.getTimeZone()).format(new Date(r11.longValue())));
        return;
    L5:
        if (r15 == 2) goto L7;
        m(r10, new Long(r11.longValue() / r14.a()));
        return;
    L7:
        m(r10, new Double((r11.longValue() / 8.64E7d) + 2440587.5d));
    }

    @Override // java.sql.PreparedStatement
    public final void setArray(int r5, Array r10) {
        throw g();
    }

    @Override // java.sql.PreparedStatement
    public final void setAsciiStream(int r5, InputStream r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setBigDecimal(int r5, BigDecimal r10) {
        if (r10 != null) goto L4;
        String r11 = null;
    L5:
        m(r5, r11);
        return;
    L4:
        r11 = r10.toString();
        goto L5
    }

    @Override // java.sql.PreparedStatement
    public final void setBinaryStream(int r5, InputStream r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setBlob(int r5, InputStream r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setBoolean(int r5, boolean r10) {
        setInt(r5, r10 ? 1 : 0);
    }

    @Override // java.sql.PreparedStatement
    public final void setByte(int r5, byte r10) {
        setInt(r5, r10);
    }

    @Override // java.sql.PreparedStatement
    public void setBytes(int r5, byte[] r10) {
        m(r5, r10);
    }

    @Override // java.sql.PreparedStatement
    public final void setCharacterStream(int r5, Reader r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setClob(int r5, Reader r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setDate(int r5, Date r10, Calendar r11) {
        if (r10 != null) goto L4;
        m(r5, null);
        return;
    L4:
        p(r5, Long.valueOf(r10.getTime()), r11);
    }

    @Override // java.sql.PreparedStatement
    public final void setDouble(int r5, double r10) {
        m(r5, new Double(r10));
    }

    @Override // java.sql.PreparedStatement
    public final void setFloat(int r5, float r10) {
        m(r5, new Float(r10));
    }

    @Override // java.sql.PreparedStatement
    public final void setInt(int r5, int r10) {
        m(r5, new Integer(r10));
    }

    @Override // java.sql.PreparedStatement
    public final void setLong(int r5, long r10) {
        m(r5, new Long(r10));
    }

    @Override // java.sql.PreparedStatement
    public final void setNCharacterStream(int r5, Reader r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setNClob(int r5, NClob r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setNString(int r5, String r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setNull(int r5, int r10) {
        m(r5, null);
    }

    @Override // java.sql.PreparedStatement
    public final void setObject(int r5, Object r10) {
        if (r10 != null) goto L5;
        m(r5, null);
        return;
    L5:
        if ((r10 instanceof java.util.Date) == false) goto L8;
        p(r5, Long.valueOf(((java.util.Date) r10).getTime()), Calendar.getInstance());
        return;
    L8:
        if ((r10 instanceof Long) == false) goto L11;
        m(r5, r10);
        return;
    L11:
        if ((r10 instanceof Integer) == false) goto L14;
        m(r5, r10);
        return;
    L14:
        if ((r10 instanceof Short) == false) goto L17;
        m(r5, new Integer(((Short) r10).intValue()));
        return;
    L17:
        if ((r10 instanceof Float) == false) goto L20;
        m(r5, r10);
        return;
    L20:
        if ((r10 instanceof Double) == false) goto L23;
        m(r5, r10);
        return;
    L23:
        if ((r10 instanceof Boolean) == false) goto L26;
        setInt(r5, ((Boolean) r10).booleanValue() ? 1 : 0);
        return;
    L26:
        if ((r10 instanceof byte[]) == false) goto L29;
        m(r5, r10);
        return;
    L29:
        if ((r10 instanceof BigDecimal) == false) goto L31;
        setBigDecimal(r5, (BigDecimal) r10);
        return;
    L31:
        m(r5, r10.toString());
    }

    @Override // java.sql.PreparedStatement
    public final void setRef(int r5, Ref r10) {
        throw g();
    }

    @Override // java.sql.PreparedStatement
    public final void setRowId(int r5, RowId r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setSQLXML(int r5, SQLXML r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setShort(int r5, short r10) {
        setInt(r5, r10);
    }

    @Override // java.sql.PreparedStatement
    public void setString(int r5, String r10) {
        m(r5, r10);
    }

    @Override // java.sql.PreparedStatement
    public final void setTime(int r5, Time r10, Calendar r11) {
        if (r10 != null) goto L4;
        m(r5, null);
        return;
    L4:
        p(r5, Long.valueOf(r10.getTime()), r11);
    }

    @Override // java.sql.PreparedStatement
    public final void setTimestamp(int r5, Timestamp r10, Calendar r11) {
        if (r10 != null) goto L4;
        m(r5, null);
        return;
    L4:
        p(r5, Long.valueOf(r10.getTime()), r11);
    }

    @Override // java.sql.PreparedStatement
    public final void setURL(int r5, URL r10) {
        throw g();
    }

    @Override // java.sql.PreparedStatement
    public final void setUnicodeStream(int r5, InputStream r10, int r11) {
        if (r10 != null) goto L10;
        if (r11 != 0) goto L10;
        m(r5, null);
    L10:
        m(r5, new String(n(r10, r11), "UTF-8"));     // Catch: UnsupportedEncodingException -> L7
        return;
    L7:
        e = move-exception;
        SQLException r12 = new SQLException("UTF-8 is not supported");
        r12.initCause(e);
        throw r12;
    }

    public final String toString() {
        return this.d + " \n parameters=" + Arrays.toString(this.f);
    }

    @Override // java.sql.PreparedStatement
    public final void setAsciiStream(int r5, InputStream r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setBinaryStream(int r5, InputStream r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setBlob(int r5, InputStream r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setCharacterStream(int r5, Reader r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setClob(int r5, Reader r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setNCharacterStream(int r5, Reader r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setNClob(int r5, Reader r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setNull(int r5, int r10, String r11) {
        m(r5, null);
    }

    @Override // java.sql.PreparedStatement
    public final void setAsciiStream(int r5, InputStream r10, int r11) {
        setUnicodeStream(r5, r10, r11);
    }

    @Override // java.sql.PreparedStatement
    public final void setBinaryStream(int r5, InputStream r10, int r11) {
        if (r10 != null) goto L5;
        if (r11 != 0) goto L5;
        m(r5, null);
    L5:
        m(r5, n(r10, r11));
    }

    @Override // java.sql.PreparedStatement
    public final void setBlob(int r5, Blob r10) {
        throw g();
    }

    @Override // java.sql.PreparedStatement
    public final void setCharacterStream(int r5, Reader r10, int r11) {
        StringBuffer r12 = new StringBuffer();     // Catch: IOException -> L6
        char[] r13 = new char[8192];     // Catch: IOException -> L6
    L3:
        int r14 = r10.read(r13);     // Catch: IOException -> L6
        if (r14 <= 0) goto L8;
        r12.append(r13, 0, r14);     // Catch: IOException -> L6
        goto L3
    L8:
        m(r5, r12.toString());     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new SQLException("Cannot read from character stream, exception message: " + e.getMessage());
    }

    @Override // java.sql.PreparedStatement
    public final void setClob(int r5, Clob r10) {
        throw g();
    }

    @Override // java.sql.PreparedStatement
    public final void setDate(int r5, Date r10) {
        setDate(r5, r10, Calendar.getInstance());
    }

    @Override // java.sql.PreparedStatement
    public final void setNClob(int r5, Reader r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.PreparedStatement
    public final void setTime(int r5, Time r10) {
        setTime(r5, r10, Calendar.getInstance());
    }

    @Override // java.sql.PreparedStatement
    public final void setTimestamp(int r5, Timestamp r10) {
        setTimestamp(r5, r10, Calendar.getInstance());
    }

    @Override // dv.f, java.sql.Statement
    public final int executeUpdate(String r5) {
        throw g();
    }

    @Override // dv.f, java.sql.Statement
    public final boolean execute(String r5) {
        throw g();
    }

    @Override // dv.f, java.sql.Statement
    public final void addBatch(String r5) {
        throw g();
    }

    @Override // dv.f, java.sql.Statement
    public final ResultSet executeQuery(String r5) {
        throw g();
    }

    @Override // java.sql.PreparedStatement
    public final void setObject(int r5, Object r10, int r11) {
        setObject(r5, r10);
    }

    @Override // java.sql.PreparedStatement
    public final void setObject(int r5, Object r10, int r11, int r12) {
        setObject(r5, r10);
    }
}
