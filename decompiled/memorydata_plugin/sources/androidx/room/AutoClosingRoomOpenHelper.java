package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u001a\u001b\u001cB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0011\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0097\u0001R\u0010\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u001d"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/room/DelegatingOpenHelper;", "delegate", "autoCloser", "Landroidx/room/AutoCloser;", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;Landroidx/room/AutoCloser;)V", "autoClosingDb", "Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "databaseName", "", "getDatabaseName", "()Ljava/lang/String;", "getDelegate", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", IslandSession.REOPEN_VALUE_CLOSE, "", "setWriteAheadLoggingEnabled", "enabled", "", "AutoClosingSupportSQLiteDatabase", "AutoClosingSupportSqliteStatement", "KeepAliveCursor", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AutoClosingRoomOpenHelper implements DelegatingOpenHelper, SupportSQLiteOpenHelper {
    public final AutoCloser autoCloser;
    private final AutoClosingSupportSQLiteDatabase autoClosingDb;
    private final SupportSQLiteOpenHelper delegate;

    @Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020%2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020%H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bH\u0016J3\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010\b2\u0012\u00102\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000104\u0018\u000103H\u0016¢\u0006\u0002\u00105J\b\u00106\u001a\u00020%H\u0016J\b\u00107\u001a\u00020\fH\u0016J\b\u00108\u001a\u00020%H\u0016J\u0010\u00109\u001a\u00020%2\u0006\u0010.\u001a\u00020\bH\u0016J'\u00109\u001a\u00020%2\u0006\u0010.\u001a\u00020\b2\u0010\u0010:\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010403H\u0016¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020\fH\u0016J \u0010=\u001a\u00020\u00132\u0006\u00100\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\u001fH\u0016J\u0006\u0010C\u001a\u00020%J\u0010\u0010D\u001a\u00020E2\u0006\u0010D\u001a\u00020FH\u0016J\u001a\u0010D\u001a\u00020E2\u0006\u0010D\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010HH\u0017J\u0010\u0010D\u001a\u00020E2\u0006\u0010D\u001a\u00020\bH\u0016J'\u0010D\u001a\u00020E2\u0006\u0010D\u001a\u00020\b2\u0010\u0010:\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010403H\u0016¢\u0006\u0002\u0010IJ\u0010\u0010J\u001a\u00020%2\u0006\u0010K\u001a\u00020\fH\u0017J\u0010\u0010L\u001a\u00020%2\u0006\u0010M\u001a\u00020NH\u0016J\u0010\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020\u001fH\u0016J\u0010\u0010Q\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010R\u001a\u00020%H\u0016JC\u0010S\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020@2\b\u00101\u001a\u0004\u0018\u00010\b2\u0012\u00102\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000104\u0018\u000103H\u0016¢\u0006\u0002\u0010TJ\b\u0010U\u001a\u00020\fH\u0016J\u0010\u0010U\u001a\u00020\f2\u0006\u0010V\u001a\u00020\u0013H\u0016R(\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\f8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00138V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006W"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "autoCloser", "Landroidx/room/AutoCloser;", "(Landroidx/room/AutoCloser;)V", "attachedDbs", "", "Landroid/util/Pair;", "", "getAttachedDbs", "()Ljava/util/List;", "isDatabaseIntegrityOk", "", "()Z", "isDbLockedByCurrentThread", "isOpen", "isReadOnly", "isWriteAheadLoggingEnabled", "maximumSize", "", "getMaximumSize", "()J", "numBytes", "pageSize", "getPageSize", "setPageSize", "(J)V", "path", "getPath", "()Ljava/lang/String;", "version", "", "getVersion", "()I", "setVersion", "(I)V", "beginTransaction", "", "beginTransactionNonExclusive", "beginTransactionWithListener", "transactionListener", "Landroid/database/sqlite/SQLiteTransactionListener;", "beginTransactionWithListenerNonExclusive", IslandSession.REOPEN_VALUE_CLOSE, "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "delete", "table", "whereClause", "whereArgs", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "disableWriteAheadLogging", "enableWriteAheadLogging", "endTransaction", "execSQL", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)V", "inTransaction", "insert", "conflictAlgorithm", "values", "Landroid/content/ContentValues;", "needUpgrade", "newVersion", "pokeOpen", ChatMessage.TYPE_QUERY, "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "enabled", "setLocale", "locale", "Ljava/util/Locale;", "setMaxSqlCacheSize", "cacheSize", "setMaximumSize", "setTransactionSuccessful", BuildConfig.CHANNEL, "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "yieldIfContendedSafely", "sleepAfterYieldDelayMillis", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {
        private final AutoCloser autoCloser;

        public AutoClosingSupportSQLiteDatabase(AutoCloser r2) {
            Intrinsics.checkNotNullParameter(r2, "autoCloser");
            this.autoCloser = r2;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransaction() {
            this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.autoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionNonExclusive() {
            this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.autoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListener(SQLiteTransactionListener r3) {
            SQLiteTransactionListener r4 = (SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r3, SQLiteTransactionListener.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "transactionListener");
            this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(r4);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.autoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r3) {
            SQLiteTransactionListener r4 = (SQLiteTransactionListener) ZeusTransformUtils.wrapperContextForParams(r3, SQLiteTransactionListener.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "transactionListener");
            this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(r4);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.autoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.autoCloser.closeDatabaseIfOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public SupportSQLiteStatement compileStatement(String r2) {
            Intrinsics.checkNotNullParameter(r2, "sql");
            return (SupportSQLiteStatement) ZeusTransformUtils.preCheckCast(new AutoClosingSupportSqliteStatement(r2, this.autoCloser), SupportSQLiteStatement.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int delete(final String r2, final String r3, final Object[] r4) {
            Intrinsics.checkNotNullParameter(r2, "table");
            return ((Number) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$delete$1(r2, r3, r4), Function1.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void disableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean enableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void endTransaction() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() == null) goto L11;
            SupportSQLiteDatabase r0 = this.autoCloser.getDelegateDatabase$room_runtime_release();     // Catch: Throwable -> L7
            Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L7
            r0.endTransaction();     // Catch: Throwable -> L7
            this.autoCloser.decrementCountAndScheduleClose();
            return;
        L7:
            th = move-exception;
            this.autoCloser.decrementCountAndScheduleClose();
            throw th;
        L11:
            throw new IllegalStateException("End transaction called but delegateDb is null".toString());
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String r3) {
            Intrinsics.checkNotNullParameter(r3, "sql");
            this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1(r3), Function1.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String r2, final Object[] r3) {
            Intrinsics.checkNotNullParameter(r2, "sql");
            Intrinsics.checkNotNullParameter(r3, "bindArgs");
            this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$2(r2, r3), Function1.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public List<Pair<String, String>> getAttachedDbs() {
            return (List) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getMaximumSize() {
            return ((Number) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getPageSize() {
            return ((Number) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public String getPath() {
            return (String) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int getVersion() {
            return ((Number) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean inTransaction() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() != null) goto L6;
            return false;
        L6:
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long insert(final String r2, final int r3, final ContentValues r4) {
            Intrinsics.checkNotNullParameter(r2, "table");
            Intrinsics.checkNotNullParameter(r4, "values");
            return ((Number) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$insert$1(r2, r3, r4), Function1.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDatabaseIntegrityOk() {
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDatabaseIntegrityOk$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDbLockedByCurrentThread() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() != null) goto L6;
            return false;
        L6:
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDbLockedByCurrentThread$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isOpen() {
            SupportSQLiteDatabase r0 = this.autoCloser.getDelegateDatabase$room_runtime_release();
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.isOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isReadOnly() {
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean needUpgrade(final int r3) {
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1(r3), Function1.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        public final void pokeOpen() {
            this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pokeOpen$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(SupportSQLiteQuery r3) {
            SupportSQLiteQuery r4 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, ChatMessage.TYPE_QUERY);
            Cursor r5 = this.autoCloser.incrementCountAndEnsureDbIsOpen().query(r4);     // Catch: Throwable -> L6
            return (Cursor) ZeusTransformUtils.preCheckCast(new KeepAliveCursor(r5, this.autoCloser), Cursor.class, "com.obric.memorydata.plugin");
        L6:
            th = move-exception;
            this.autoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(SupportSQLiteQuery r3, CancellationSignal r4) {
            SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, ChatMessage.TYPE_QUERY);
            Cursor r6 = this.autoCloser.incrementCountAndEnsureDbIsOpen().query(r5, r4);     // Catch: Throwable -> L6
            return (Cursor) ZeusTransformUtils.preCheckCast(new KeepAliveCursor(r6, this.autoCloser), Cursor.class, "com.obric.memorydata.plugin");
        L6:
            th = move-exception;
            this.autoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String r2) {
            Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
            Cursor r3 = this.autoCloser.incrementCountAndEnsureDbIsOpen().query(r2);     // Catch: Throwable -> L6
            return (Cursor) ZeusTransformUtils.preCheckCast(new KeepAliveCursor(r3, this.autoCloser), Cursor.class, "com.obric.memorydata.plugin");
        L6:
            th = move-exception;
            this.autoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String r2, Object[] r3) {
            Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
            Intrinsics.checkNotNullParameter(r3, "bindArgs");
            Cursor r4 = this.autoCloser.incrementCountAndEnsureDbIsOpen().query(r2, r3);     // Catch: Throwable -> L6
            return (Cursor) ZeusTransformUtils.preCheckCast(new KeepAliveCursor(r4, this.autoCloser), Cursor.class, "com.obric.memorydata.plugin");
        L6:
            th = move-exception;
            this.autoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setForeignKeyConstraintsEnabled(final boolean r3) {
            this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setForeignKeyConstraintsEnabled$1(r3), Function1.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setLocale(final Locale r3) {
            Intrinsics.checkNotNullParameter(r3, "locale");
            this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1(r3), Function1.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setMaxSqlCacheSize(final int r3) {
            this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaxSqlCacheSize$1(r3), Function1.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long setMaximumSize(final long r2) {
            return ((Number) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1(r2), Function1.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setPageSize(final long r2) {
            this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$2(r2), Function1.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setTransactionSuccessful() {
            SupportSQLiteDatabase r1 = this.autoCloser.getDelegateDatabase$room_runtime_release();
            if (r1 == null) goto L5;
            r1.setTransactionSuccessful();
            Unit r2 = Unit.INSTANCE;
        L6:
            if (r2 == null) goto L9;
            return;
        L9:
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null".toString());
        L5:
            r2 = null;
            goto L6
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setVersion(final int r3) {
            this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$2(r3), Function1.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int update(final String r8, final int r9, final ContentValues r10, final String r11, final Object[] r12) {
            Intrinsics.checkNotNullParameter(r8, "table");
            Intrinsics.checkNotNullParameter(r10, "values");
            return ((Number) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$update$1(r8, r9, r10, r11, r12), Function1.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely() {
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely(long r2) {
            return ((Boolean) ZeusTransformUtils.preCheckCast(this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0001H\u0002J\b\u0010\u001b\u001a\u00020\fH\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0016J'\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\u001e0 H\u0002¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u00020\u000eH\u0016J\u001a\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010%\u001a\u00020\u0014H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\t0\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement;", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "", "autoCloser", "Landroidx/room/AutoCloser;", "(Ljava/lang/String;Landroidx/room/AutoCloser;)V", "binds", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "bindBlob", "", "index", "", EventBody.KEY_VALUE, "", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "clearBindings", IslandSession.REOPEN_VALUE_CLOSE, "doBinds", "supportSQLiteStatement", "execute", "executeInsert", "executeSqliteStatementWithRefCount", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "executeUpdateDelete", "saveBinds", "bindIndex", "simpleQueryForLong", "simpleQueryForString", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {
        private final AutoCloser autoCloser;
        private final ArrayList<Object> binds;
        private final String sql;

        public AutoClosingSupportSqliteStatement(String r2, AutoCloser r3) {
            Intrinsics.checkNotNullParameter(r2, "sql");
            Intrinsics.checkNotNullParameter(r3, "autoCloser");
            this.sql = r2;
            this.autoCloser = r3;
            this.binds = new ArrayList();
        }

        public static final /* synthetic */ void access$doBinds(AutoClosingSupportSqliteStatement r2, SupportSQLiteStatement r3) {
            r2.doBinds((SupportSQLiteStatement) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteStatement.class, "com.obric.memorydata.plugin"));
        }

        public static final /* synthetic */ String access$getSql$p(AutoClosingSupportSqliteStatement r0) {
            return r0.sql;
        }

        private final void doBinds(SupportSQLiteStatement r7) {
            SupportSQLiteStatement r8 = (SupportSQLiteStatement) ZeusTransformUtils.wrapperContextForParams(r7, SupportSQLiteStatement.class, "com.obric.memorydata.plugin");
            Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.binds, Iterable.class, "com.obric.memorydata.plugin")).iterator();
            int r2 = 0;
        L4:
            if (r0.hasNext() == false) goto L24;
            r0.next();
            int r3 = r2 + 1;
            if (r2 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            Object r4 = this.binds.get(r2);
            if (r4 != null) goto L12;
            r8.bindNull(r3);
        L23:
            r2 = r3;
            goto L4
        L12:
            if (ZeusTransformUtils.instanceOf(r4, Long.class) == false) goto L15;
            r8.bindLong(r3, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).longValue());
            goto L23
        L15:
            if (ZeusTransformUtils.instanceOf(r4, Double.class) == false) goto L18;
            r8.bindDouble(r3, ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.memorydata.plugin")).doubleValue());
            goto L23
        L18:
            if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L21;
            r8.bindString(r3, (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin"));
            goto L23
        L21:
            if ((r4 instanceof byte[]) == false) goto L23;
            r8.bindBlob(r3, (byte[]) ZeusTransformUtils.preCheckCast(r4, byte[].class, "com.obric.memorydata.plugin"));
            goto L23
        }

        private final <T> T executeSqliteStatementWithRefCount(Function1<? super SupportSQLiteStatement, ? extends T> r4) {
            final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
            return (T) this.autoCloser.executeRefCountingFunction((Function1) ZeusTransformUtils.preCheckCast(new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1(this, r5), Function1.class, "com.obric.memorydata.plugin"));
        }

        private final void saveBinds(int r4, Object r5) {
            int r6 = r4 - 1;
            if (r6 < this.binds.size()) goto L9;
            int r0 = this.binds.size();
            if (r0 > r6) goto L9;
        L6:
            this.binds.add(null);
            if (r0 == r6) goto L9;
            r0 = r0 + 1;
        L9:
            this.binds.set(r6, r5);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindBlob(int r2, byte[] r3) {
            Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
            saveBinds(r2, r3);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindDouble(int r1, double r2) {
            saveBinds(r1, Double.valueOf(r2));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindLong(int r1, long r2) {
            saveBinds(r1, Long.valueOf(r2));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindNull(int r2) {
            saveBinds(r2, null);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindString(int r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, EventBody.KEY_VALUE);
            saveBinds(r2, r3);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void clearBindings() {
            this.binds.clear();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public void execute() {
            executeSqliteStatementWithRefCount((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"));
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long executeInsert() {
            return ((Number) ZeusTransformUtils.preCheckCast(executeSqliteStatementWithRefCount((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public int executeUpdateDelete() {
            return ((Number) ZeusTransformUtils.preCheckCast(executeSqliteStatementWithRefCount((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long simpleQueryForLong() {
            return ((Number) ZeusTransformUtils.preCheckCast(executeSqliteStatementWithRefCount((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForLong$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), Number.class, "com.obric.memorydata.plugin")).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public String simpleQueryForString() {
            return (String) ZeusTransformUtils.preCheckCast(executeSqliteStatementWithRefCount((Function1) ZeusTransformUtils.preCheckCast(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), String.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J!\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fH\u0096\u0001J\t\u0010\u000e\u001a\u00020\u0007H\u0097\u0001J\u0019\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\u00100\u00102\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u0011\u001a\u00020\nH\u0096\u0001J\u0019\u0010\u0012\u001a\u00020\n2\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J\u0019\u0010\u0014\u001a\u00020\n2\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010\u00130\u0013H\u0096\u0001J\u0019\u0010\u0015\u001a\n \r*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J4\u0010\u0016\u001a(\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00130\u0013 \r*\u0014\u0012\u000e\b\u0001\u0012\n \r*\u0004\u0018\u00010\u00130\u0013\u0018\u00010\u00170\u0017H\u0096\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010\u001c\u001a\n \r*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0011\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010 \u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010!\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\b\u0010#\u001a\u00020$H\u0017J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020$0&H\u0017J\t\u0010'\u001a\u00020\nH\u0096\u0001J\u0011\u0010(\u001a\u00020)2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0019\u0010*\u001a\n \r*\u0004\u0018\u00010\u00130\u00132\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u0010+\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010,\u001a\u00020-H\u0096\u0001J\t\u0010.\u001a\u00020-H\u0096\u0001J\t\u0010/\u001a\u00020-H\u0096\u0001J\t\u00100\u001a\u00020-H\u0096\u0001J\t\u00101\u001a\u00020-H\u0096\u0001J\t\u00102\u001a\u00020-H\u0096\u0001J\u0011\u00103\u001a\u00020-2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\u0011\u00104\u001a\u00020-2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u00105\u001a\u00020-H\u0096\u0001J\t\u00106\u001a\u00020-H\u0096\u0001J\t\u00107\u001a\u00020-H\u0096\u0001J\u0011\u00108\u001a\u00020-2\u0006\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u00109\u001a\u00020-H\u0096\u0001J\u0019\u0010:\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010;0;H\u0096\u0001J\u0019\u0010<\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010=0=H\u0096\u0001J\t\u0010>\u001a\u00020-H\u0097\u0001J!\u0010?\u001a\n \r*\u0004\u0018\u00010\u001d0\u001d2\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010\u001d0\u001dH\u0096\u0001J\u0010\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u001dH\u0017J)\u0010B\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010C0C2\u000e\u0010\u000b\u001a\n \r*\u0004\u0018\u00010$0$H\u0096\u0001J\u001e\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020C2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020$0&H\u0017J\u0019\u0010G\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010;0;H\u0096\u0001J\u0019\u0010H\u001a\u00020\u00072\u000e\u0010\t\u001a\n \r*\u0004\u0018\u00010=0=H\u0096\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Landroidx/room/AutoClosingRoomOpenHelper$KeepAliveCursor;", "Landroid/database/Cursor;", "delegate", "autoCloser", "Landroidx/room/AutoCloser;", "(Landroid/database/Cursor;Landroidx/room/AutoCloser;)V", IslandSession.REOPEN_VALUE_CLOSE, "", "copyStringToBuffer", "p0", "", "p1", "Landroid/database/CharArrayBuffer;", "kotlin.jvm.PlatformType", "deactivate", "getBlob", "", "getColumnCount", "getColumnIndex", "", "getColumnIndexOrThrow", "getColumnName", "getColumnNames", "", "()[Ljava/lang/String;", "getCount", "getDouble", "", "getExtras", "Landroid/os/Bundle;", "getFloat", "", "getInt", "getLong", "", "getNotificationUri", "Landroid/net/Uri;", "getNotificationUris", "", "getPosition", "getShort", "", "getString", "getType", "getWantsAllOnMoveCalls", "", "isAfterLast", "isBeforeFirst", "isClosed", "isFirst", "isLast", "isNull", "move", "moveToFirst", "moveToLast", "moveToNext", "moveToPosition", "moveToPrevious", "registerContentObserver", "Landroid/database/ContentObserver;", "registerDataSetObserver", "Landroid/database/DataSetObserver;", "requery", "respond", "setExtras", "extras", "setNotificationUri", "Landroid/content/ContentResolver;", "setNotificationUris", "cr", "uris", "unregisterContentObserver", "unregisterDataSetObserver", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class KeepAliveCursor implements Cursor {
        private final AutoCloser autoCloser;
        private final Cursor delegate;

        public KeepAliveCursor(Cursor r3, AutoCloser r4) {
            Cursor r5 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "delegate");
            Intrinsics.checkNotNullParameter(r4, "autoCloser");
            this.delegate = r5;
            this.autoCloser = r4;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
            this.autoCloser.decrementCountAndScheduleClose();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int r1, CharArrayBuffer r2) {
            this.delegate.copyStringToBuffer(r1, r2);
        }

        @Override // android.database.Cursor
        @Deprecated(message = "Deprecated in Java")
        public void deactivate() {
            this.delegate.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int r1) {
            return this.delegate.getBlob(r1);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.delegate.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String r1) {
            return this.delegate.getColumnIndex(r1);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String r1) {
            return this.delegate.getColumnIndexOrThrow(r1);
        }

        @Override // android.database.Cursor
        public String getColumnName(int r1) {
            return this.delegate.getColumnName(r1);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.delegate.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.delegate.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int r1) {
            return this.delegate.getDouble(r1);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.delegate.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int r1) {
            return this.delegate.getFloat(r1);
        }

        @Override // android.database.Cursor
        public int getInt(int r1) {
            return this.delegate.getInt(r1);
        }

        @Override // android.database.Cursor
        public long getLong(int r1) {
            return this.delegate.getLong(r1);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return SupportSQLiteCompat.Api19Impl.getNotificationUri(this.delegate);
        }

        @Override // android.database.Cursor
        public List<Uri> getNotificationUris() {
            return SupportSQLiteCompat.Api29Impl.getNotificationUris(this.delegate);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.delegate.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int r1) {
            return this.delegate.getShort(r1);
        }

        @Override // android.database.Cursor
        public String getString(int r1) {
            return this.delegate.getString(r1);
        }

        @Override // android.database.Cursor
        public int getType(int r1) {
            return this.delegate.getType(r1);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.delegate.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.delegate.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.delegate.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.delegate.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.delegate.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.delegate.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int r1) {
            return this.delegate.isNull(r1);
        }

        @Override // android.database.Cursor
        public boolean move(int r1) {
            return this.delegate.move(r1);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.delegate.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.delegate.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.delegate.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int r1) {
            return this.delegate.moveToPosition(r1);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.delegate.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver r1) {
            this.delegate.registerContentObserver(r1);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver r1) {
            this.delegate.registerDataSetObserver(r1);
        }

        @Override // android.database.Cursor
        @Deprecated(message = "Deprecated in Java")
        public boolean requery() {
            return this.delegate.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle r1) {
            return this.delegate.respond(r1);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "extras");
            SupportSQLiteCompat.Api23Impl.setExtras(this.delegate, r2);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver r1, Uri r2) {
            this.delegate.setNotificationUri(r1, r2);
        }

        @Override // android.database.Cursor
        public void setNotificationUris(ContentResolver r3, List<? extends Uri> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "cr");
            Intrinsics.checkNotNullParameter(r5, "uris");
            SupportSQLiteCompat.Api29Impl.setNotificationUris(this.delegate, r3, r5);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver r1) {
            this.delegate.unregisterContentObserver(r1);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver r1) {
            this.delegate.unregisterDataSetObserver(r1);
        }
    }

    public AutoClosingRoomOpenHelper(SupportSQLiteOpenHelper r3, AutoCloser r4) {
        SupportSQLiteOpenHelper r5 = (SupportSQLiteOpenHelper) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteOpenHelper.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "delegate");
        Intrinsics.checkNotNullParameter(r4, "autoCloser");
        this.delegate = r5;
        this.autoCloser = r4;
        r4.init(getDelegate());
        this.autoClosingDb = new AutoClosingSupportSQLiteDatabase(r4);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.autoClosingDb.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.delegate.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        this.autoClosingDb.pokeOpen();
        return (SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(this.autoClosingDb, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        this.autoClosingDb.pokeOpen();
        return (SupportSQLiteDatabase) ZeusTransformUtils.preCheckCast(this.autoClosingDb, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r1) {
        this.delegate.setWriteAheadLoggingEnabled(r1);
    }
}
