package com.ss.android.socialbase.downloader.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.socialbase.downloader.utils.SqlUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class TableStatements {
    private final String[] allColumns;
    private final SQLiteDatabase database;
    private SQLiteStatement deleteStatement;
    private SQLiteStatement insertOrReplaceStatement;
    private SQLiteStatement insertStatement;
    private final String[] pkColumns;
    private final String tableName;
    private SQLiteStatement updateStatement;

    public SQLiteStatement getDeleteStatement() {
        if (this.deleteStatement != null) goto L17;
        String r0 = SqlUtils.createSqlDelete(this.tableName, this.pkColumns);
        SQLiteStatement r1 = this.database.compileStatement(r0);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.deleteStatement != null) goto L9;
        this.deleteStatement = r1;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.deleteStatement == r1) goto L17;
        r1.close();
    L17:
        return this.deleteStatement;
    }

    public SQLiteStatement getInsertOrReplaceStatement() {
        if (this.insertOrReplaceStatement != null) goto L17;
        String r0 = SqlUtils.createSqlInsertOrReplace(this.tableName, this.allColumns, this.pkColumns);
        SQLiteStatement r1 = this.database.compileStatement(r0);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.insertOrReplaceStatement != null) goto L9;
        this.insertOrReplaceStatement = r1;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.insertOrReplaceStatement == r1) goto L17;
        r1.close();
    L17:
        return this.insertOrReplaceStatement;
    }

    public SQLiteStatement getInsertStatement() {
        if (this.insertStatement != null) goto L17;
        String r0 = SqlUtils.createSqlInsert("INSERT INTO ", this.tableName, this.allColumns);
        SQLiteStatement r1 = this.database.compileStatement(r0);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.insertStatement != null) goto L9;
        this.insertStatement = r1;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.insertStatement == r1) goto L17;
        r1.close();
    L17:
        return this.insertStatement;
    }

    public SQLiteStatement getUpdateStatement() {
        if (this.updateStatement != null) goto L17;
        String r0 = SqlUtils.createSqlUpdate(this.tableName, this.allColumns, this.pkColumns);
        SQLiteStatement r1 = this.database.compileStatement(r0);
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.updateStatement != null) goto L9;
        this.updateStatement = r1;     // Catch: Throwable -> L13
    L9:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (this.updateStatement == r1) goto L17;
        r1.close();
    L17:
        return this.updateStatement;
    }

    public TableStatements(SQLiteDatabase r1, String r2, String[] r3, String[] r4) {
        this.database = r1;
        this.tableName = r2;
        this.allColumns = r3;
        this.pkColumns = r4;
    }
}
