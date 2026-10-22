package androidx.sqlite.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.RequiresApi;
import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public interface SupportSQLiteDatabase extends Closeable {
    void beginTransaction();

    void beginTransactionNonExclusive();

    void beginTransactionWithListener(SQLiteTransactionListener r10);

    void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r10);

    SupportSQLiteStatement compileStatement(String r10);

    int delete(String r10, String r11, Object[] r12);

    @RequiresApi(api = 16)
    void disableWriteAheadLogging();

    boolean enableWriteAheadLogging();

    void endTransaction();

    default void execPerConnectionSQL(String r10, @SuppressLint({"ArrayReturn"}) Object[] r11) {
        Intrinsics.checkNotNullParameter(r10, "sql");
        throw new UnsupportedOperationException();
    }

    void execSQL(String r10);

    void execSQL(String r10, Object[] r11);

    List<Pair<String, String>> getAttachedDbs();

    long getMaximumSize();

    long getPageSize();

    String getPath();

    int getVersion();

    boolean inTransaction();

    long insert(String r10, int r11, ContentValues r12);

    boolean isDatabaseIntegrityOk();

    boolean isDbLockedByCurrentThread();

    default boolean isExecPerConnectionSQLSupported() {
        return false;
    }

    boolean isOpen();

    boolean isReadOnly();

    @RequiresApi(api = 16)
    boolean isWriteAheadLoggingEnabled();

    boolean needUpgrade(int r10);

    Cursor query(SupportSQLiteQuery r10);

    @RequiresApi(api = 16)
    Cursor query(SupportSQLiteQuery r10, CancellationSignal r11);

    Cursor query(String r10);

    Cursor query(String r10, Object[] r11);

    @RequiresApi(api = 16)
    void setForeignKeyConstraintsEnabled(boolean r10);

    void setLocale(Locale r10);

    void setMaxSqlCacheSize(int r10);

    long setMaximumSize(long r10);

    void setPageSize(long r10);

    void setTransactionSuccessful();

    void setVersion(int r10);

    int update(String r10, int r11, ContentValues r12, String r13, Object[] r14);

    boolean yieldIfContendedSafely();

    boolean yieldIfContendedSafely(long r10);
}
