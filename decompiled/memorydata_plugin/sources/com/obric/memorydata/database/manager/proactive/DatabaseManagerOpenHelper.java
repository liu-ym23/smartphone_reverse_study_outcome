package com.obric.memorydata.database.manager.proactive;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.database.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/database/manager/proactive/DatabaseManagerOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "dbName", "", "<init>", "(Ljava/lang/String;)V", "databaseName", "getDatabaseName", "()Ljava/lang/String;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", IslandSession.REOPEN_VALUE_CLOSE, "", "setWriteAheadLoggingEnabled", "enabled", "", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DatabaseManagerOpenHelper implements SupportSQLiteOpenHelper {
    private static final a Companion = null;
    private static final String TAG = "ProactiveDbOpenHelper";
    private final String dbName;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/database/manager/proactive/DatabaseManagerOpenHelper$Companion;", "", "<init>", "()V", "TAG", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public DatabaseManagerOpenHelper(String r1) {
        this.dbName = r1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        RunLog.INSTANCE.debug(TAG, "[OpenHelper] close ignored dbName=" + this.dbName);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.dbName;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return getWritableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        String r5 = this.dbName;
        if (r5 == null) goto L11;
        SupportSQLiteDatabase r0 = c.f11648a.c(r5);
        if (r0 == null) goto L8;
        RunLog.INSTANCE.debug(TAG, "[OpenHelper] writableDatabase dbName=" + r5 + " version=" + r0.getVersion());
        return r0;
    L8:
        RunLog.INSTANCE.error(TAG, "[OpenHelper] writableDatabase databaseNotReady dbName=" + r5, null);
        throw new IllegalStateException(("Database not ready: " + r5).toString());
    L11:
        throw new IllegalStateException("dbName is null".toString());
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r4) {
        RunLog.INSTANCE.debug(TAG, "[OpenHelper] setWriteAheadLoggingEnabled ignored dbName=" + this.dbName + " enabled=" + r4);
    }
}
