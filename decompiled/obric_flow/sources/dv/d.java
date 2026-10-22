package dv;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements NClob {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f16718b;

    public d(e r5, String r10) {
        this.f16718b = r5;
        this.f16717a = r10;
    }

    @Override // java.sql.Clob
    public final void free() {
        this.f16717a = null;
    }

    @Override // java.sql.Clob
    public final InputStream getAsciiStream() {
        String r5 = this.f16717a;
        this.f16718b.getClass();
        return e.p(r5);
    }

    @Override // java.sql.Clob
    public final Reader getCharacterStream() {
        String r5 = this.f16717a;
        this.f16718b.getClass();
        if (r5 != null) goto L6;
        return null;
    L6:
        return new StringReader(r5);
    }

    @Override // java.sql.Clob
    public final String getSubString(long r5, int r10) {
        String r11 = this.f16717a;
        if (r11 == null) goto L14;
        if (r5 < 1) goto L12;
        if (r10 < 0) goto L10;
        int r12 = ((int) r5) - 1;
        return r11.substring(r12, Math.min(r10 + r12, r11.length()));
    L10:
        throw new SQLException("Length must be greater than or equal to 0");
    L12:
        throw new SQLException("Position must be greater than or equal to 1");
    L14:
        throw new SQLException("no data");
    }

    @Override // java.sql.Clob
    public final long length() {
        String r5 = this.f16717a;
        if (r5 == null) goto L7;
        return r5.length();
    L7:
        throw new SQLException("no data");
    }

    @Override // java.sql.Clob
    public final long position(String r5, long r10) {
        this.f16718b.getClass();
        e.q();
        return -1;
    }

    @Override // java.sql.Clob
    public final OutputStream setAsciiStream(long r5) {
        this.f16718b.getClass();
        e.q();
        return null;
    }

    @Override // java.sql.Clob
    public final Writer setCharacterStream(long r5) {
        this.f16718b.getClass();
        e.q();
        return null;
    }

    @Override // java.sql.Clob
    public final int setString(long r5, String r10) {
        this.f16718b.getClass();
        e.q();
        return -1;
    }

    @Override // java.sql.Clob
    public final void truncate(long r5) {
        this.f16718b.getClass();
        e.q();
    }

    @Override // java.sql.Clob
    public final long position(Clob r5, long r10) {
        this.f16718b.getClass();
        e.q();
        return -1;
    }

    @Override // java.sql.Clob
    public final int setString(long r5, String r10, int r11, int r12) {
        this.f16718b.getClass();
        e.q();
        return -1;
    }

    @Override // java.sql.Clob
    public final Reader getCharacterStream(long r5, long r10) {
        String r11 = this.f16717a;
        this.f16718b.getClass();
        if (r11 != null) goto L6;
        return null;
    L6:
        return new StringReader(r11);
    }
}
