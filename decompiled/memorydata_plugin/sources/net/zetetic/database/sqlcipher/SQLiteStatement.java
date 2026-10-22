package net.zetetic.database.sqlcipher;

import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.ParcelFileDescriptor;
import androidx.sqlite.db.SupportSQLiteStatement;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteStatement extends SQLiteProgram implements SupportSQLiteStatement {
    SQLiteStatement(SQLiteDatabase r2, String r3, Object[] r4) {
        super(r2, r3, r4, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        acquireReference();
        getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), null);     // Catch: Throwable -> L6 SQLiteDatabaseCorruptException -> L8
        releaseReference();
        return;
    L8:
        e = move-exception;
        onCorruption();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        acquireReference();
        long r0 = getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), null);     // Catch: Throwable -> L6 SQLiteDatabaseCorruptException -> L8
        releaseReference();
        return r0;
    L8:
        e = move-exception;
        onCorruption();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public void executeRaw() {
        acquireReference();
        getSession().executeRaw(getSql(), getBindArgs(), getConnectionFlags(), null);     // Catch: Throwable -> L6 SQLiteDatabaseCorruptException -> L8
        releaseReference();
        return;
    L8:
        e = move-exception;
        onCorruption();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        acquireReference();
        int r0 = getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), null);     // Catch: Throwable -> L6 SQLiteDatabaseCorruptException -> L8
        releaseReference();
        return r0;
    L8:
        e = move-exception;
        onCorruption();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public ParcelFileDescriptor simpleQueryForBlobFileDescriptor() {
        acquireReference();
        ParcelFileDescriptor r0 = getSession().executeForBlobFileDescriptor(getSql(), getBindArgs(), getConnectionFlags(), null);     // Catch: Throwable -> L6 SQLiteDatabaseCorruptException -> L8
        releaseReference();
        return r0;
    L8:
        e = move-exception;
        onCorruption();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        acquireReference();
        long r0 = getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), null);     // Catch: Throwable -> L6 SQLiteDatabaseCorruptException -> L8
        releaseReference();
        return r0;
    L8:
        e = move-exception;
        onCorruption();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        acquireReference();
        String r0 = getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), null);     // Catch: Throwable -> L6 SQLiteDatabaseCorruptException -> L8
        releaseReference();
        return r0;
    L8:
        e = move-exception;
        onCorruption();     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public String toString() {
        return "SQLiteProgram: " + getSql();
    }
}
