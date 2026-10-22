package androidx.sqlite.db;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteProgram extends Closeable {
    void bindBlob(int r10, byte[] r11);

    void bindDouble(int r10, double r11);

    void bindLong(int r10, long r11);

    void bindNull(int r10);

    void bindString(int r10, String r11);

    void clearBindings();
}
