package net.zetetic.database.sqlcipher;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import net.zetetic.database.DatabaseErrorHandler;

/* JADX INFO: loaded from: classes6.dex */
public class SupportHelper implements SupportSQLiteOpenHelper {
    private SQLiteOpenHelper openHelper;

    public SupportHelper(SupportSQLiteOpenHelper.Configuration r7, byte[] r8, SQLiteDatabaseHook r9, boolean r10) {
        this(r7, r8, (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r9, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin"), r10, 0);
    }

    public SupportHelper(final SupportSQLiteOpenHelper.Configuration r14, final byte[] r15, SQLiteDatabaseHook r16, final boolean r17, final int r18) {
        final SQLiteDatabaseHook r9 = (SQLiteDatabaseHook) ZeusTransformUtils.wrapperContextForParams(r16, SQLiteDatabaseHook.class, "com.obric.memorydata.plugin");
        final Context r2 = r14.context;
        final String r3 = r14.name;
        final int r6 = r14.callback.version;
        final SQLiteDatabase.CursorFactory r5 = null;
        final DatabaseErrorHandler r8 = null;
        this.openHelper = new AnonymousClass1(this, r2, r3, r15, r5, r6, r18, r8, r9, r17, r14);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.openHelper.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.openHelper.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return this.openHelper.getReadableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return this.openHelper.getWritableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r1) {
        this.openHelper.setWriteAheadLoggingEnabled(r1);
    }
}
