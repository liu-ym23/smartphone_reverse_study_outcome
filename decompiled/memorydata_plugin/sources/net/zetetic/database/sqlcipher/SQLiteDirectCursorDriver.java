package net.zetetic.database.sqlcipher;

import android.database.Cursor;
import android.os.CancellationSignal;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private final CancellationSignal mCancellationSignal;
    private final SQLiteDatabase mDatabase;
    private final String mEditTable;
    private SQLiteQuery mQuery;
    private final String mSql;

    public SQLiteDirectCursorDriver(SQLiteDatabase r1, String r2, String r3, CancellationSignal r4) {
        this.mDatabase = r1;
        this.mEditTable = r3;
        this.mSql = r2;
        this.mCancellationSignal = r4;
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteCursorDriver
    public void cursorClosed() {
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteCursorDriver
    public void cursorDeactivated() {
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteCursorDriver
    public void cursorRequeried(Cursor r2) {
        Cursor r1 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.memorydata.plugin");
    }

    public Cursor query(SQLiteDatabase.CursorFactory r5, Object... r6) {
        SQLiteDatabase.CursorFactory r7 = (SQLiteDatabase.CursorFactory) ZeusTransformUtils.wrapperContextForParams(r5, SQLiteDatabase.CursorFactory.class, "com.obric.memorydata.plugin");
        SQLiteQuery r0 = new SQLiteQuery(this.mDatabase, this.mSql, this.mCancellationSignal);
        r0.bindAllArgs(r6);     // Catch: RuntimeException -> L9
        if (r7 != null) goto L6;
        Cursor r8 = new SQLiteCursor(this, this.mEditTable, r0);     // Catch: RuntimeException -> L9
    L7:
        this.mQuery = r0;
        return r8;
    L6:
        r8 = r7.newCursor(this.mDatabase, this, this.mEditTable, r0);     // Catch: RuntimeException -> L9
    L9:
        e = move-exception;
        r0.close();
        throw e;
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteCursorDriver
    public Cursor query(SQLiteDatabase.CursorFactory r5, String[] r6) {
        SQLiteDatabase.CursorFactory r7 = (SQLiteDatabase.CursorFactory) ZeusTransformUtils.wrapperContextForParams(r5, SQLiteDatabase.CursorFactory.class, "com.obric.memorydata.plugin");
        SQLiteQuery r0 = new SQLiteQuery(this.mDatabase, this.mSql, this.mCancellationSignal);
        r0.bindAllArgsAsStrings(r6);     // Catch: RuntimeException -> L9
        if (r7 != null) goto L6;
        Cursor r8 = new SQLiteCursor(this, this.mEditTable, r0);     // Catch: RuntimeException -> L9
    L7:
        this.mQuery = r0;
        return r8;
    L6:
        r8 = r7.newCursor(this.mDatabase, this, this.mEditTable, r0);     // Catch: RuntimeException -> L9
    L9:
        e = move-exception;
        r0.close();
        throw e;
    }

    @Override // net.zetetic.database.sqlcipher.SQLiteCursorDriver
    public void setBindArguments(String[] r1) {
        this.mQuery.bindAllArgsAsStrings(r1);
    }

    public String toString() {
        return "SQLiteDirectCursorDriver: " + this.mSql;
    }
}
