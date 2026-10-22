package dv;

import java.sql.ResultSet;
import java.sql.RowIdLifetime;
import java.sql.SQLFeatureNotSupportedException;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends cv.b {
    @Override // java.sql.DatabaseMetaData
    public final boolean autoCommitFailureClosesAllResultSets() {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getClientInfoProperties() {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getFunctions(String r5, String r10, String r11) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.DatabaseMetaData
    public final RowIdLifetime getRowIdLifetime() {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.DatabaseMetaData
    public final ResultSet getSchemas(String r5, String r10) {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.Wrapper
    public final boolean isWrapperFor(Class r5) {
        return r5.isInstance(this);
    }

    @Override // java.sql.DatabaseMetaData
    public final boolean supportsStoredFunctionsUsingCallSyntax() {
        throw new SQLFeatureNotSupportedException();
    }

    @Override // java.sql.Wrapper
    public final Object unwrap(Class r5) {
        return r5.cast(this);
    }
}
