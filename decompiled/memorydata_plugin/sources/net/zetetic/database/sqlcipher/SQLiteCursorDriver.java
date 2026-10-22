package net.zetetic.database.sqlcipher;

import android.database.Cursor;

/* JADX INFO: loaded from: classes6.dex */
public interface SQLiteCursorDriver {
    void cursorClosed();

    void cursorDeactivated();

    void cursorRequeried(Cursor r1);

    Cursor query(SQLiteDatabase.CursorFactory r1, String[] r2);

    void setBindArguments(String[] r1);
}
