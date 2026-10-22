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
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0002\u0010\u000fJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\bH\u0002J\u0018\u0010&\u001a\u00020 2\u0006\u0010%\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u000e\u0010'\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u001cH\u0017J\u0010\u0010*\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001a¨\u0006+"}, d2 = {"Landroidx/room/SQLiteCopyOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/room/DelegatingOpenHelper;", "context", "Landroid/content/Context;", "copyFromAssetPath", "", "copyFromFile", "Ljava/io/File;", "copyFromInputStream", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "databaseVersion", "", "delegate", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;ILandroidx/sqlite/db/SupportSQLiteOpenHelper;)V", "databaseConfiguration", "Landroidx/room/DatabaseConfiguration;", "databaseName", "getDatabaseName", "()Ljava/lang/String;", "getDelegate", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "verified", "", "writableDatabase", "getWritableDatabase", "close", "", "copyDatabaseFile", "destinationFile", "writable", "createFrameworkOpenHelper", "databaseFile", "dispatchOnOpenPrepackagedDatabase", "setDatabaseConfiguration", "setWriteAheadLoggingEnabled", "enabled", "verifyDatabaseFile", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final Context context;
    private final String copyFromAssetPath;
    private final File copyFromFile;
    private final Callable<InputStream> copyFromInputStream;
    private DatabaseConfiguration databaseConfiguration;
    private final int databaseVersion;
    private final SupportSQLiteOpenHelper delegate;
    private boolean verified;

    public SQLiteCopyOpenHelper(Context r5, String r10, File r11, Callable<InputStream> r12, int r13, SupportSQLiteOpenHelper r14) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r14, "delegate");
        this.context = r5;
        this.copyFromAssetPath = r10;
        this.copyFromFile = r11;
        this.copyFromInputStream = r12;
        this.databaseVersion = r13;
        this.delegate = r14;
    }

    private final void copyDatabaseFile(File r5, boolean r10) throws IOException {
        if (this.copyFromAssetPath == null) goto L6;
        ReadableByteChannel r11 = Channels.newChannel(this.context.getAssets().open(this.copyFromAssetPath));
    L12:
        File r12 = File.createTempFile("room-copy-helper", ".tmp", this.context.getCacheDir());
        r12.deleteOnExit();
        FileUtil.copy(r11, new FileOutputStream(r12).getChannel());
        File r13 = r5.getParentFile();
        if (r13 != null) goto L15;
    L21:
        dispatchOnOpenPrepackagedDatabase(r12, r10);
        if (r12.renameTo(r5) == false) goto L25;
        return;
    L25:
        throw new IOException("Failed to move intermediate file (" + r12.getAbsolutePath() + ") to destination (" + r5.getAbsolutePath() + ").");
    L15:
        if (r13.exists() == true) goto L21;
        if (r13.mkdirs() == true) goto L21;
        throw new IOException("Failed to create directories for " + r5.getAbsolutePath());
    L6:
        if (this.copyFromFile == null) goto L8;
        r11 = new FileInputStream(this.copyFromFile).getChannel();
        goto L12
    L8:
        Callable<InputStream> r14 = this.copyFromInputStream;
        if (r14 == null) goto L30;
        r11 = Channels.newChannel(r14.call());
    L26:
        e = move-exception;
        throw new IOException("inputStreamCallable exception on call", e);
    L30:
        throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
    }

    private final SupportSQLiteOpenHelper createFrameworkOpenHelper(File r5) {
        final int r10 = DBUtil.readVersion(r5);     // Catch: IOException -> L5
        FrameworkSQLiteOpenHelperFactory r11 = new FrameworkSQLiteOpenHelperFactory();
        SupportSQLiteOpenHelper.Configuration.Builder r12 = SupportSQLiteOpenHelper.Configuration.Companion.builder(this.context).name(r5.getAbsolutePath());
        final int r13 = RangesKt.coerceAtLeast(r10, 1);
        return r11.create(r12.callback(new SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1(r10, r13)).build());
    L5:
        e = move-exception;
        throw new RuntimeException("Malformed database file, unable to read version.", e);
    }

    private final void dispatchOnOpenPrepackagedDatabase(File r5, boolean r10) {
        DatabaseConfiguration r11 = this.databaseConfiguration;
        if (r11 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
        r11 = null;
    L6:
        if (r11.prepackagedDatabaseCallback != null) goto L8;
        return;
    L8:
        SupportSQLiteOpenHelper r12 = createFrameworkOpenHelper(r5);
        if (r10 == false) goto L13;
        SupportSQLiteDatabase r13 = r12.getWritableDatabase();     // Catch: Throwable -> L11
    L14:
        DatabaseConfiguration r14 = this.databaseConfiguration;     // Catch: Throwable -> L11
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");     // Catch: Throwable -> L11
        r14 = null;
    L17:
        RoomDatabase.PrepackagedDatabaseCallback r15 = r14.prepackagedDatabaseCallback;     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L11
        r15.onOpenPrepackagedDatabase(r13);     // Catch: Throwable -> L11
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r12, null);
        return;
    L13:
        r13 = r12.getReadableDatabase();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    private final void verifyDatabaseFile(boolean r11) {
        String r5 = getDatabaseName();
        if (r5 == null) goto L48;
        File r10 = this.context.getDatabasePath(r5);
        DatabaseConfiguration r12 = this.databaseConfiguration;
        DatabaseConfiguration r13 = null;
        if (r12 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
        r12 = null;
    L7:
        ProcessLock r14 = new ProcessLock(r5, this.context.getFilesDir(), r12.multiInstanceInvalidation);
        ProcessLock.lock$default(r14, false, 1, null);     // Catch: Throwable -> L14
        if (r10.exists() == false) goto L54;
        int r15 = DBUtil.readVersion(r10);     // Catch: Throwable -> L14 IOException -> L41
    L21:
        if (r15 != this.databaseVersion) goto L24;
        r14.unlock();
        return;
    L24:
        DatabaseConfiguration r16 = this.databaseConfiguration;     // Catch: Throwable -> L14
        if (r16 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");     // Catch: Throwable -> L14
    L29:
        if (r13.isMigrationRequired(r15, this.databaseVersion) == false) goto L33;
        r14.unlock();
        return;
    L33:
        if (this.context.deleteDatabase(r5) == true) goto L49;
        Log.w(Room.LOG_TAG, "Failed to delete database file (" + r5 + ") for a copy destructive migration.");     // Catch: Throwable -> L14
    L39:
        r14.unlock();
        return;
    L49:
        copyDatabaseFile(r10, r11);     // Catch: Throwable -> L14 IOException -> L36
    L36:
        e = move-exception;
        Log.w(Room.LOG_TAG, "Unable to copy database file.", e);     // Catch: Throwable -> L14
        goto L39
    L27:
        r13 = r16;
    L41:
        e = move-exception;
        Log.w(Room.LOG_TAG, "Unable to read database version.", e);     // Catch: Throwable -> L14
        r14.unlock();
        return;
    L54:
        copyDatabaseFile(r10, r11);     // Catch: Throwable -> L14 IOException -> L16
        r14.unlock();
        return;
    L16:
        e = move-exception;
        throw new RuntimeException("Unable to copy database file.", e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r14.unlock();
        throw th;
    L48:
        throw new IllegalStateException("Required value was null.");
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

    public final void setDatabaseConfiguration(DatabaseConfiguration r5) {
        Intrinsics.checkNotNullParameter(r5, "databaseConfiguration");
        this.databaseConfiguration = r5;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean r5) {
        getDelegate().setWriteAheadLoggingEnabled(r5);
    }
}
