package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.sqlite.util.ProcessLock;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public final class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final Context context;
    private final String copyFromAssetPath;
    private final File copyFromFile;
    private final Callable<InputStream> copyFromInputStream;
    private DatabaseConfiguration databaseConfiguration;
    private final int databaseVersion;
    private final SupportSQLiteOpenHelper delegate;
    private boolean verified;

    public SQLiteCopyOpenHelper(Context r10, String r11, File r12, Callable<InputStream> r13, int r14, SupportSQLiteOpenHelper r15) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r15, "delegate");
        this.context = r10;
        this.copyFromAssetPath = r11;
        this.copyFromFile = r12;
        this.copyFromInputStream = r13;
        this.databaseVersion = r14;
        this.delegate = r15;
    }

    private final void copyDatabaseFile(File r10, boolean r11) {
        if (this.copyFromAssetPath == null) goto L7;
        ReadableByteChannel r12 = Channels.newChannel(this.context.getAssets().open(this.copyFromAssetPath));
        String r13 = "newChannel(context.assets.open(copyFromAssetPath))";
    L5:
        Intrinsics.checkNotNullExpressionValue(r12, r13);
        File r14 = File.createTempFile("room-copy-helper", ".tmp", this.context.getCacheDir());
        r14.deleteOnExit();
        FileChannel r15 = new FileOutputStream(r14).getChannel();
        Intrinsics.checkNotNullExpressionValue(r15, "output");
        FileUtil.copy(r12, r15);
        File r16 = r10.getParentFile();
        if (r16 != null) goto L16;
    L22:
        Intrinsics.checkNotNullExpressionValue(r14, "intermediateFile");
        dispatchOnOpenPrepackagedDatabase(r14, r11);
        if (r14.renameTo(r10) == false) goto L26;
        return;
    L26:
        throw new IOException("Failed to move intermediate file (" + r14.getAbsolutePath() + ") to destination (" + r10.getAbsolutePath() + ").");
    L16:
        if (r16.exists() == true) goto L22;
        if (r16.mkdirs() == true) goto L22;
        throw new IOException("Failed to create directories for " + r10.getAbsolutePath());
    L7:
        if (this.copyFromFile == null) goto L9;
        r12 = new FileInputStream(this.copyFromFile).getChannel();
        r13 = "FileInputStream(copyFromFile).channel";
        goto L5
    L9:
        Callable<InputStream> r17 = this.copyFromInputStream;
        if (r17 == null) goto L31;
        r12 = Channels.newChannel(r17.call());
        r13 = "newChannel(inputStream)";
    L27:
        e = move-exception;
        throw new IOException("inputStreamCallable exception on call", e);
    L31:
        throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
    }

    private final SupportSQLiteOpenHelper createFrameworkOpenHelper(File r10) {
        final int r11 = DBUtil.readVersion(r10);     // Catch: IOException -> L5
        FrameworkSQLiteOpenHelperFactory r12 = new FrameworkSQLiteOpenHelperFactory();
        SupportSQLiteOpenHelper.Configuration.Builder r13 = SupportSQLiteOpenHelper.Configuration.Companion.builder(this.context).name(r10.getAbsolutePath());
        final int r14 = RangesKt.coerceAtLeast(r11, 1);
        return r12.create(r13.callback(new SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1(r11, r14)).build());
    L5:
        e = move-exception;
        throw new RuntimeException("Malformed database file, unable to read version.", e);
    }

    private final void dispatchOnOpenPrepackagedDatabase(File r10, boolean r11) {
        DatabaseConfiguration r12 = this.databaseConfiguration;
        if (r12 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
        r12 = null;
    L6:
        if (r12.prepackagedDatabaseCallback != null) goto L8;
        return;
    L8:
        SupportSQLiteOpenHelper r13 = createFrameworkOpenHelper(r10);
        if (r11 == false) goto L11;
        SupportSQLiteDatabase r14 = r13.getWritableDatabase();     // Catch: Throwable -> L18
    L12:
        DatabaseConfiguration r15 = this.databaseConfiguration;     // Catch: Throwable -> L18
        if (r15 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");     // Catch: Throwable -> L18
        r15 = null;
    L15:
        RoomDatabase.PrepackagedDatabaseCallback r16 = r15.prepackagedDatabaseCallback;     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L18
        r16.onOpenPrepackagedDatabase(r14);     // Catch: Throwable -> L18
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r13, null);
        return;
    L11:
        r14 = r13.getReadableDatabase();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    }

    private final void verifyDatabaseFile(boolean r10) {
        String r11 = getDatabaseName();
        if (r11 == null) goto L47;
        File r12 = this.context.getDatabasePath(r11);
        DatabaseConfiguration r13 = this.databaseConfiguration;
        DatabaseConfiguration r14 = null;
        if (r13 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
        r13 = null;
    L7:
        boolean r15 = r13.multiInstanceInvalidation;
        File r16 = this.context.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(r16, "context.filesDir");
        ProcessLock r17 = new ProcessLock(r11, r16, r15);
        ProcessLock.lock$default(r17, false, 1, null);     // Catch: Throwable -> L43
        if (r12.exists() == true) goto L51;
        Intrinsics.checkNotNullExpressionValue(r12, "databaseFile");     // Catch: IOException -> L14 Throwable -> L43
        copyDatabaseFile(r12, r10);     // Catch: IOException -> L14 Throwable -> L43
        r17.unlock();
        return;
    L14:
        e = move-exception;
        throw new RuntimeException("Unable to copy database file.", e);     // Catch: Throwable -> L43
    L51:
        Intrinsics.checkNotNullExpressionValue(r12, "databaseFile");     // Catch: IOException -> L39 Throwable -> L43
        int r18 = DBUtil.readVersion(r12);     // Catch: IOException -> L39 Throwable -> L43
    L19:
        if (r18 != this.databaseVersion) goto L22;
        r17.unlock();
        return;
    L22:
        DatabaseConfiguration r19 = this.databaseConfiguration;     // Catch: Throwable -> L43
        if (r19 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");     // Catch: Throwable -> L43
    L27:
        if (r14.isMigrationRequired(r18, this.databaseVersion) == false) goto L31;
        r17.unlock();
        return;
    L31:
        if (this.context.deleteDatabase(r11) == true) goto L53;
        Log.w(Room.LOG_TAG, "Failed to delete database file (" + r11 + ") for a copy destructive migration.");     // Catch: Throwable -> L43
    L37:
        r17.unlock();
        return;
    L53:
        copyDatabaseFile(r12, r10);     // Catch: IOException -> L34 Throwable -> L43
    L34:
        e = move-exception;
        Log.w(Room.LOG_TAG, "Unable to copy database file.", e);     // Catch: Throwable -> L43
        goto L37
    L25:
        r14 = r19;
    L39:
        e = move-exception;
        Log.w(Room.LOG_TAG, "Unable to read database version.", e);     // Catch: Throwable -> L43
        r17.unlock();
        return;
    L43:
        th = move-exception;
        r17.unlock();
        throw th;
    L47:
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        getDelegate().close();     // Catch: Throwable -> L6
        this.verified = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        if (this.verified == true) goto L6;
        verifyDatabaseFile(false);
        this.verified = true;
    L6:
        return getDelegate().getReadableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        if (this.verified == true) goto L6;
        verifyDatabaseFile(true);
        this.verified = true;
    L6:
        return getDelegate().getWritableDatabase();
    }

    public final void setDatabaseConfiguration(DatabaseConfiguration r10) {
        Intrinsics.checkNotNullParameter(r10, "databaseConfiguration");
        this.databaseConfiguration = r10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean r10) {
        getDelegate().setWriteAheadLoggingEnabled(r10);
    }
}
