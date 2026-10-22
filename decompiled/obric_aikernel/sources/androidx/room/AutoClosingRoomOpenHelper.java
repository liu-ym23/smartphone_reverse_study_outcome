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
import androidx.annotation.RequiresApi;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.crash.entity.EventBody;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    @JvmField
    public final AutoCloser autoCloser;
    private final AutoClosingSupportSQLiteDatabase autoClosingDb;
    private final SupportSQLiteOpenHelper delegate;

    public static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {
        private final AutoCloser autoCloser;

        public AutoClosingSupportSQLiteDatabase(AutoCloser r10) {
            Intrinsics.checkNotNullParameter(r10, "autoCloser");
            this.autoCloser = r10;
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
        public void beginTransactionWithListener(SQLiteTransactionListener r10) {
            Intrinsics.checkNotNullParameter(r10, "transactionListener");
            this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(r10);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            this.autoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r10) {
            Intrinsics.checkNotNullParameter(r10, "transactionListener");
            this.autoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(r10);     // Catch: Throwable -> L5
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
        public SupportSQLiteStatement compileStatement(String r10) {
            Intrinsics.checkNotNullParameter(r10, "sql");
            return new AutoClosingSupportSqliteStatement(r10, this.autoCloser);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int delete(final String r10, final String r11, final Object[] r12) {
            Intrinsics.checkNotNullParameter(r10, "table");
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$delete$1(r10, r11, r12))).intValue();
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
            SupportSQLiteDatabase r10 = this.autoCloser.getDelegateDatabase$room_runtime_release();     // Catch: Throwable -> L7
            Intrinsics.checkNotNull(r10);     // Catch: Throwable -> L7
            r10.endTransaction();     // Catch: Throwable -> L7
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
        public void execSQL(final String r10) {
            Intrinsics.checkNotNullParameter(r10, "sql");
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1(r10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String r10, final Object[] r11) {
            Intrinsics.checkNotNullParameter(r10, "sql");
            Intrinsics.checkNotNullParameter(r11, "bindArgs");
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$2(r10, r11));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public List<Pair<String, String>> getAttachedDbs() {
            return (List) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1.INSTANCE);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getMaximumSize() {
            return ((Number) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$maximumSize$1.INSTANCE)).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getPageSize() {
            return ((Number) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$1.INSTANCE)).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public String getPath() {
            return (String) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1.INSTANCE);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int getVersion() {
            return ((Number) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$1.INSTANCE)).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean inTransaction() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() != null) goto L6;
            return false;
        L6:
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long insert(final String r10, final int r11, final ContentValues r12) {
            Intrinsics.checkNotNullParameter(r10, "table");
            Intrinsics.checkNotNullParameter(r12, "values");
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$insert$1(r10, r11, r12))).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDatabaseIntegrityOk() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDatabaseIntegrityOk$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDbLockedByCurrentThread() {
            if (this.autoCloser.getDelegateDatabase$room_runtime_release() != null) goto L6;
            return false;
        L6:
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isDbLockedByCurrentThread$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isOpen() {
            SupportSQLiteDatabase r10 = this.autoCloser.getDelegateDatabase$room_runtime_release();
            if (r10 != null) goto L7;
            return false;
        L7:
            return r10.isOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isReadOnly() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isReadOnly$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 16)
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean needUpgrade(final int r10) {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1(r10))).booleanValue();
        }

        public final void pokeOpen() {
            this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pokeOpen$1.INSTANCE);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(SupportSQLiteQuery r10) {
            Intrinsics.checkNotNullParameter(r10, "query");
            Cursor r11 = this.autoCloser.incrementCountAndEnsureDbIsOpen().query(r10);     // Catch: Throwable -> L6
            return new KeepAliveCursor(r11, this.autoCloser);
        L6:
            th = move-exception;
            this.autoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 24)
        public Cursor query(SupportSQLiteQuery r10, CancellationSignal r11) {
            Intrinsics.checkNotNullParameter(r10, "query");
            Cursor r12 = this.autoCloser.incrementCountAndEnsureDbIsOpen().query(r10, r11);     // Catch: Throwable -> L6
            return new KeepAliveCursor(r12, this.autoCloser);
        L6:
            th = move-exception;
            this.autoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String r10) {
            Intrinsics.checkNotNullParameter(r10, "query");
            Cursor r11 = this.autoCloser.incrementCountAndEnsureDbIsOpen().query(r10);     // Catch: Throwable -> L6
            return new KeepAliveCursor(r11, this.autoCloser);
        L6:
            th = move-exception;
            this.autoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String r10, Object[] r11) {
            Intrinsics.checkNotNullParameter(r10, "query");
            Intrinsics.checkNotNullParameter(r11, "bindArgs");
            Cursor r12 = this.autoCloser.incrementCountAndEnsureDbIsOpen().query(r10, r11);     // Catch: Throwable -> L6
            return new KeepAliveCursor(r12, this.autoCloser);
        L6:
            th = move-exception;
            this.autoCloser.decrementCountAndScheduleClose();
            throw th;
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 16)
        public void setForeignKeyConstraintsEnabled(final boolean r10) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setForeignKeyConstraintsEnabled$1(r10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setLocale(final Locale r10) {
            Intrinsics.checkNotNullParameter(r10, "locale");
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1(r10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setMaxSqlCacheSize(final int r10) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaxSqlCacheSize$1(r10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long setMaximumSize(final long r10) {
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1(r10))).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setPageSize(final long r10) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$2(r10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setTransactionSuccessful() {
            SupportSQLiteDatabase r10 = this.autoCloser.getDelegateDatabase$room_runtime_release();
            if (r10 == null) goto L5;
            r10.setTransactionSuccessful();
            Unit r11 = Unit.INSTANCE;
        L6:
            if (r11 == null) goto L9;
            return;
        L9:
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null".toString());
        L5:
            r11 = null;
            goto L6
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setVersion(final int r10) {
            this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$2(r10));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int update(final String r10, final int r11, final ContentValues r12, final String r13, final Object[] r14) {
            Intrinsics.checkNotNullParameter(r10, "table");
            Intrinsics.checkNotNullParameter(r12, "values");
            return ((Number) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$update$1(r10, r11, r12, r13, r14))).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely() {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$1.INSTANCE)).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely(long r10) {
            return ((Boolean) this.autoCloser.executeRefCountingFunction(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2.INSTANCE)).booleanValue();
        }
    }

    private static final class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {
        private final AutoCloser autoCloser;
        private final ArrayList<Object> binds;
        private final String sql;

        public AutoClosingSupportSqliteStatement(String r10, AutoCloser r11) {
            Intrinsics.checkNotNullParameter(r10, "sql");
            Intrinsics.checkNotNullParameter(r11, "autoCloser");
            this.sql = r10;
            this.autoCloser = r11;
            this.binds = new ArrayList();
        }

        public static final /* synthetic */ void access$doBinds(AutoClosingSupportSqliteStatement r10, SupportSQLiteStatement r11) {
            r10.doBinds(r11);
        }

        public static final /* synthetic */ String access$getSql$p(AutoClosingSupportSqliteStatement r10) {
            return r10.sql;
        }

        private final void doBinds(SupportSQLiteStatement r10) {
            Iterator<T> r11 = this.binds.iterator();
            int r12 = 0;
        L4:
            if (r11.hasNext() == false) goto L24;
            r11.next();
            int r13 = r12 + 1;
            if (r12 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            Object r14 = this.binds.get(r12);
            if (r14 != null) goto L12;
            r10.bindNull(r13);
        L23:
            r12 = r13;
            goto L4
        L12:
            if ((r14 instanceof Long) == false) goto L15;
            r10.bindLong(r13, ((Number) r14).longValue());
            goto L23
        L15:
            if ((r14 instanceof Double) == false) goto L18;
            r10.bindDouble(r13, ((Number) r14).doubleValue());
            goto L23
        L18:
            if ((r14 instanceof String) == false) goto L21;
            r10.bindString(r13, (String) r14);
            goto L23
        L21:
            if ((r14 instanceof byte[]) == false) goto L23;
            r10.bindBlob(r13, (byte[]) r14);
            goto L23
        }

        private final <T> T executeSqliteStatementWithRefCount(final Function1<? super SupportSQLiteStatement, ? extends T> r10) {
            return (T) this.autoCloser.executeRefCountingFunction(new AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1(this, r10));
        }

        private final void saveBinds(int r10, Object r11) {
            int r12 = r10 - 1;
            if (r12 < this.binds.size()) goto L9;
            int r13 = this.binds.size();
            if (r13 > r12) goto L9;
        L6:
            this.binds.add(null);
            if (r13 == r12) goto L9;
            r13 = r13 + 1;
        L9:
            this.binds.set(r12, r11);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindBlob(int r10, byte[] r11) {
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            saveBinds(r10, r11);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindDouble(int r10, double r11) {
            saveBinds(r10, Double.valueOf(r11));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindLong(int r10, long r11) {
            saveBinds(r10, Long.valueOf(r11));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindNull(int r10) {
            saveBinds(r10, null);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindString(int r10, String r11) {
            Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
            saveBinds(r10, r11);
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
            executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$execute$1.INSTANCE);
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long executeInsert() {
            return ((Number) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeInsert$1.INSTANCE)).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public int executeUpdateDelete() {
            return ((Number) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeUpdateDelete$1.INSTANCE)).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long simpleQueryForLong() {
            return ((Number) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForLong$1.INSTANCE)).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public String simpleQueryForString() {
            return (String) executeSqliteStatementWithRefCount(AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$simpleQueryForString$1.INSTANCE);
        }
    }

    private static final class KeepAliveCursor implements Cursor {
        private final AutoCloser autoCloser;
        private final Cursor delegate;

        public KeepAliveCursor(Cursor r10, AutoCloser r11) {
            Intrinsics.checkNotNullParameter(r10, "delegate");
            Intrinsics.checkNotNullParameter(r11, "autoCloser");
            this.delegate = r10;
            this.autoCloser = r11;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
            this.autoCloser.decrementCountAndScheduleClose();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int r10, CharArrayBuffer r11) {
            this.delegate.copyStringToBuffer(r10, r11);
        }

        @Override // android.database.Cursor
        @Deprecated(message = "Deprecated in Java")
        public void deactivate() {
            this.delegate.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int r10) {
            return this.delegate.getBlob(r10);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.delegate.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String r10) {
            return this.delegate.getColumnIndex(r10);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String r10) {
            return this.delegate.getColumnIndexOrThrow(r10);
        }

        @Override // android.database.Cursor
        public String getColumnName(int r10) {
            return this.delegate.getColumnName(r10);
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
        public double getDouble(int r10) {
            return this.delegate.getDouble(r10);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.delegate.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int r10) {
            return this.delegate.getFloat(r10);
        }

        @Override // android.database.Cursor
        public int getInt(int r10) {
            return this.delegate.getInt(r10);
        }

        @Override // android.database.Cursor
        public long getLong(int r10) {
            return this.delegate.getLong(r10);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 19)
        public Uri getNotificationUri() {
            return SupportSQLiteCompat.Api19Impl.getNotificationUri(this.delegate);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 29)
        public List<Uri> getNotificationUris() {
            return SupportSQLiteCompat.Api29Impl.getNotificationUris(this.delegate);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.delegate.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int r10) {
            return this.delegate.getShort(r10);
        }

        @Override // android.database.Cursor
        public String getString(int r10) {
            return this.delegate.getString(r10);
        }

        @Override // android.database.Cursor
        public int getType(int r10) {
            return this.delegate.getType(r10);
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
        public boolean isNull(int r10) {
            return this.delegate.isNull(r10);
        }

        @Override // android.database.Cursor
        public boolean move(int r10) {
            return this.delegate.move(r10);
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
        public boolean moveToPosition(int r10) {
            return this.delegate.moveToPosition(r10);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.delegate.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver r10) {
            this.delegate.registerContentObserver(r10);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver r10) {
            this.delegate.registerDataSetObserver(r10);
        }

        @Override // android.database.Cursor
        @Deprecated(message = "Deprecated in Java")
        public boolean requery() {
            return this.delegate.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle r10) {
            return this.delegate.respond(r10);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 23)
        public void setExtras(Bundle r10) {
            Intrinsics.checkNotNullParameter(r10, "extras");
            SupportSQLiteCompat.Api23Impl.setExtras(this.delegate, r10);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver r10, Uri r11) {
            this.delegate.setNotificationUri(r10, r11);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 29)
        public void setNotificationUris(ContentResolver r10, List<? extends Uri> r11) {
            Intrinsics.checkNotNullParameter(r10, "cr");
            Intrinsics.checkNotNullParameter(r11, "uris");
            SupportSQLiteCompat.Api29Impl.setNotificationUris(this.delegate, r10, r11);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver r10) {
            this.delegate.unregisterContentObserver(r10);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver r10) {
            this.delegate.unregisterDataSetObserver(r10);
        }
    }

    public AutoClosingRoomOpenHelper(SupportSQLiteOpenHelper r10, AutoCloser r11) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        Intrinsics.checkNotNullParameter(r11, "autoCloser");
        this.delegate = r10;
        this.autoCloser = r11;
        r11.init(getDelegate());
        this.autoClosingDb = new AutoClosingSupportSQLiteDatabase(r11);
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
    @RequiresApi(api = 24)
    public SupportSQLiteDatabase getReadableDatabase() {
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 24)
    public SupportSQLiteDatabase getWritableDatabase() {
        this.autoClosingDb.pokeOpen();
        return this.autoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean r10) {
        this.delegate.setWriteAheadLoggingEnabled(r10);
    }
}
