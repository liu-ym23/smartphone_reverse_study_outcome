package com.tencent.wcdb;

import android.database.Cursor;

/* JADX INFO: loaded from: classes6.dex */
public interface f extends Cursor {
    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Override // android.database.Cursor
    int getColumnIndex(String r1);

    @Override // android.database.Cursor
    int getCount();

    @Override // android.database.Cursor
    double getDouble(int r1);

    @Override // android.database.Cursor
    long getLong(int r1);

    @Override // android.database.Cursor
    String getString(int r1);

    @Override // android.database.Cursor
    int getType(int r1);

    @Override // android.database.Cursor
    boolean isAfterLast();

    @Override // android.database.Cursor
    boolean isLast();

    @Override // android.database.Cursor
    boolean moveToNext();
}
