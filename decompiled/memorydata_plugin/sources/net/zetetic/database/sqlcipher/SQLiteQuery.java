package net.zetetic.database.sqlcipher;

import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.os.CancellationSignal;
import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "SQLiteQuery";
    private final CancellationSignal mCancellationSignal;

    SQLiteQuery(SQLiteDatabase r2, String r3, CancellationSignal r4) {
        super(r2, r3, null, r4);
        this.mCancellationSignal = r4;
    }

    int fillWindow(CursorWindow r10, int r11, int r12, boolean r13) {
        acquireReference();
        r10.acquireReference();     // Catch: Throwable -> L18
        int r14 = getSession().executeForCursorWindow(getSql(), getBindArgs(), r10, r11, r12, r13, getConnectionFlags(), this.mCancellationSignal);     // Catch: Throwable -> L8 SQLiteException -> L10 SQLiteDatabaseCorruptException -> L13
        r10.releaseReference();     // Catch: Throwable -> L18
        releaseReference();
        return r14;
    L8:
        th = move-exception;
        r10.releaseReference();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L13:
        e = move-exception;
        onCorruption();     // Catch: Throwable -> L8
        throw e;     // Catch: Throwable -> L8
    L10:
        e = move-exception;
        Log.e(TAG, "exception: " + e.getMessage() + "; query: " + getSql());     // Catch: Throwable -> L8
        throw e;     // Catch: Throwable -> L8
    L18:
        th = move-exception;
        releaseReference();
        throw th;
    }

    public String toString() {
        return "SQLiteQuery: " + getSql();
    }
}
