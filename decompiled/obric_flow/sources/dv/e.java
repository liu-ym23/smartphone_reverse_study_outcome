package dv;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends cv.c implements ResultSet, ResultSetMetaData {
    public static ByteArrayInputStream p(String r5) {
        if (r5 != null) goto L8;
        return null;
    L8:
        return new ByteArrayInputStream(r5.getBytes("ASCII"));
    L7:
        return null;
    }

    public static void q() {
        new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final boolean absolute(int r5) {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override // java.sql.ResultSet
    public final void afterLast() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override // java.sql.ResultSet
    public final void beforeFirst() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override // java.sql.ResultSet
    public final void cancelRowUpdates() {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // bv.c, java.sql.ResultSet, java.lang.AutoCloseable
    public final void close() {
        boolean r5 = this.f1014b;
        super.close();
        if (r5 == false) goto L8;
        f r10 = this.f1013a;
        if ((r10 instanceof f) == false) goto L9;
        r10.getClass();
        return;
    L9:
        return;
    }

    @Override // java.sql.ResultSet
    public final void deleteRow() {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final boolean first() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override // java.sql.ResultSet
    public final Array getArray(int r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final InputStream getAsciiStream(int r5) {
        return p(getString(r5));
    }

    @Override // java.sql.ResultSet
    public final BigDecimal getBigDecimal(int r5, int r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final Blob getBlob(int r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final Clob getClob(int r5) {
        return new d(this, getString(r5));
    }

    @Override // java.sql.ResultSet
    public final int getHoldability() {
        return 0;
    }

    @Override // java.sql.ResultSet
    public final Reader getNCharacterStream(int r5) {
        String r10 = getString(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        return new StringReader(r10);
    }

    @Override // java.sql.ResultSet
    public final NClob getNClob(int r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final String getNString(int r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final Object getObject(int r5, Map r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final Ref getRef(int r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final RowId getRowId(int r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final SQLXML getSQLXML(int r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final URL getURL(int r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final InputStream getUnicodeStream(int r5) {
        return getAsciiStream(r5);
    }

    @Override // java.sql.ResultSet
    public final void insertRow() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override // java.sql.ResultSet
    public final boolean isClosed() {
        return !this.f1014b;
    }

    @Override // java.sql.Wrapper
    public final boolean isWrapperFor(Class r5) {
        return r5.isInstance(this);
    }

    @Override // java.sql.ResultSet
    public final boolean last() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override // java.sql.ResultSet
    public final void moveToCurrentRow() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override // java.sql.ResultSet
    public final void moveToInsertRow() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override // java.sql.ResultSet
    public final boolean previous() {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override // java.sql.ResultSet
    public final void refreshRow() {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final boolean relative(int r5) {
        throw new SQLException("ResultSet is TYPE_FORWARD_ONLY");
    }

    @Override // java.sql.Wrapper
    public final Object unwrap(Class r5) {
        return r5.cast(this);
    }

    @Override // java.sql.ResultSet
    public final void updateArray(int r5, Array r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateAsciiStream(int r5, InputStream r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBigDecimal(int r5, BigDecimal r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBinaryStream(int r5, InputStream r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBlob(int r5, InputStream r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBoolean(int r5, boolean r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateByte(int r5, byte r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBytes(int r5, byte[] r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateCharacterStream(int r5, Reader r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateClob(int r5, Reader r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateDate(int r5, Date r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateDouble(int r5, double r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateFloat(int r5, float r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateInt(int r5, int r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateLong(int r5, long r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateNCharacterStream(int r5, Reader r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateNClob(int r5, NClob r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateNString(int r5, String r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateNull(int r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateObject(int r5, Object r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateRef(int r5, Ref r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateRow() {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateRowId(int r5, RowId r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateSQLXML(int r5, SQLXML r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateShort(int r5, short r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateString(int r5, String r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateTime(int r5, Time r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateTimestamp(int r5, Timestamp r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final Clob getClob(String r5) {
        return new d(this, getString(r5));
    }

    @Override // java.sql.ResultSet
    public final NClob getNClob(String r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final String getNString(String r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final RowId getRowId(String r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final SQLXML getSQLXML(String r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final InputStream getUnicodeStream(String r5) {
        return getAsciiStream(r5);
    }

    @Override // java.sql.ResultSet
    public final void updateAsciiStream(String r5, InputStream r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBinaryStream(String r5, InputStream r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBlob(String r5, InputStream r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateCharacterStream(String r5, Reader r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateClob(String r5, Reader r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateNCharacterStream(String r5, Reader r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateNClob(String r5, NClob r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateNString(String r5, String r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateRowId(String r5, RowId r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateSQLXML(String r5, SQLXML r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final Array getArray(String r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final InputStream getAsciiStream(String r5) {
        return p(getString(r5));
    }

    @Override // java.sql.ResultSet
    public final BigDecimal getBigDecimal(String r5, int r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final Blob getBlob(String r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final Reader getNCharacterStream(String r5) {
        String r10 = getString(r5);
        if (r10 != null) goto L6;
        return null;
    L6:
        return new StringReader(r10);
    }

    @Override // java.sql.ResultSet
    public final Object getObject(String r5, Map r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final Ref getRef(String r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final URL getURL(String r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateArray(String r5, Array r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateAsciiStream(int r5, InputStream r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBigDecimal(String r5, BigDecimal r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBinaryStream(int r5, InputStream r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBlob(int r5, InputStream r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBoolean(String r5, boolean r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateByte(String r5, byte r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBytes(String r5, byte[] r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateCharacterStream(int r5, Reader r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateClob(int r5, Reader r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateDate(String r5, Date r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateDouble(String r5, double r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateFloat(String r5, float r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateInt(String r5, int r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateLong(String r5, long r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateNCharacterStream(int r5, Reader r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateNClob(int r5, Reader r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateNull(String r5) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateObject(int r5, Object r10, int r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateRef(String r5, Ref r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateShort(String r5, short r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateString(String r5, String r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateTime(String r5, Time r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateTimestamp(String r5, Timestamp r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateAsciiStream(String r5, InputStream r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBinaryStream(String r5, InputStream r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBlob(String r5, InputStream r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateCharacterStream(String r5, Reader r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateClob(String r5, Reader r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateNCharacterStream(String r5, Reader r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateNClob(String r5, Reader r10, long r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateAsciiStream(int r5, InputStream r10, int r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBinaryStream(int r5, InputStream r10, int r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBlob(int r5, Blob r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateCharacterStream(int r5, Reader r10, int r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateClob(int r5, Clob r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateNClob(int r5, Reader r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateObject(String r5, Object r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateNClob(String r5, Reader r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateAsciiStream(String r5, InputStream r10, int r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBinaryStream(String r5, InputStream r10, int r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateBlob(String r5, Blob r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateCharacterStream(String r5, Reader r10, int r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateClob(String r5, Clob r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.ResultSet
    public final void updateObject(String r5, Object r10, int r11) {
        throw new SQLFeatureNotSupportedException();
    }
}
