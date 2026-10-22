package org.sqlite;

import java.sql.SQLException;

/* JADX INFO: loaded from: classes3.dex */
public class SQLiteException extends SQLException {
    private SQLiteErrorCode resultCode;

    public SQLiteException(String r5, SQLiteErrorCode r10) {
        super(r5, null, r10.code & 255);
        this.resultCode = r10;
    }

    public SQLiteErrorCode getResultCode() {
        return this.resultCode;
    }
}
