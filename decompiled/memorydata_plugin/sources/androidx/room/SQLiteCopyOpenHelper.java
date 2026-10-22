package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.sqlite.util.ProcessLock;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0002\u0010\u000fJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\bH\u0002J\u0018\u0010&\u001a\u00020 2\u0006\u0010%\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u000e\u0010'\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u001cH\u0017J\u0010\u0010*\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001a¨\u0006+"}, d2 = {"Landroidx/room/SQLiteCopyOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/room/DelegatingOpenHelper;", "context", "Landroid/content/Context;", "copyFromAssetPath", "", "copyFromFile", "Ljava/io/File;", "copyFromInputStream", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "databaseVersion", "", "delegate", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;ILandroidx/sqlite/db/SupportSQLiteOpenHelper;)V", "databaseConfiguration", "Landroidx/room/DatabaseConfiguration;", "databaseName", "getDatabaseName", "()Ljava/lang/String;", "getDelegate", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "verified", "", "writableDatabase", "getWritableDatabase", IslandSession.REOPEN_VALUE_CLOSE, "", "copyDatabaseFile", "destinationFile", "writable", "createFrameworkOpenHelper", "databaseFile", "dispatchOnOpenPrepackagedDatabase", "setDatabaseConfiguration", "setWriteAheadLoggingEnabled", "enabled", "verifyDatabaseFile", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SQLiteCopyOpenHelper implements DelegatingOpenHelper, SupportSQLiteOpenHelper {
    private final Context context;
    private final String copyFromAssetPath;
    private final File copyFromFile;
    private final Callable<InputStream> copyFromInputStream;
    private DatabaseConfiguration databaseConfiguration;
    private final int databaseVersion;
    private final SupportSQLiteOpenHelper delegate;
    private boolean verified;

    public SQLiteCopyOpenHelper(Context r3, String r4, File r5, Callable<InputStream> r6, int r7, SupportSQLiteOpenHelper r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Callable<InputStream> r10 = (Callable) ZeusTransformUtils.wrapperContextForParams(r6, Callable.class, "com.obric.memorydata.plugin");
        SupportSQLiteOpenHelper r11 = (SupportSQLiteOpenHelper) ZeusTransformUtils.wrapperContextForParams(r8, SupportSQLiteOpenHelper.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r11, "delegate");
        this.context = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        this.copyFromAssetPath = r4;
        this.copyFromFile = r5;
        this.copyFromInputStream = r10;
        this.databaseVersion = r7;
        this.delegate = r11;
    }

    private final void copyDatabaseFile(File r5, boolean r6) {
        if (this.copyFromAssetPath == null) goto L7;
        ReadableByteChannel r0 = Channels.newChannel(this.context.getAssets().open(this.copyFromAssetPath));
        String r1 = "newChannel(context.assets.open(copyFromAssetPath))";
    L5:
        Intrinsics.checkNotNullExpressionValue(r0, r1);
    L13:
        File r2 = File.createTempFile("room-copy-helper", ".tmp", this.context.getCacheDir());
        r2.deleteOnExit();
        FileChannel r3 = new FileOutputStream(r2).getChannel();
        Intrinsics.checkNotNullExpressionValue(r3, "output");
        FileUtil.copy(r0, r3);
        File r4 = r5.getParentFile();
        if (r4 != null) goto L16;
    L22:
        Intrinsics.checkNotNullExpressionValue(r2, "intermediateFile");
        dispatchOnOpenPrepackagedDatabase(r2, r6);
        if (r2.renameTo(r5) == false) goto L26;
        return;
    L26:
        throw new IOException("Failed to move intermediate file (" + r2.getAbsolutePath() + ") to destination (" + r5.getAbsolutePath() + ").");
    L16:
        if (r4.exists() == true) goto L22;
        if (r4.mkdirs() == true) goto L22;
        throw new IOException("Failed to create directories for " + r5.getAbsolutePath());
    L7:
        if (this.copyFromFile == null) goto L9;
        FileChannel r7 = new FileInputStream(this.copyFromFile).getChannel();
        Intrinsics.checkNotNullExpressionValue(r7, "FileInputStream(copyFromFile).channel");
        r0 = (ReadableByteChannel) ZeusTransformUtils.preCheckCast(r7, ReadableByteChannel.class, "com.obric.memorydata.plugin");
        goto L13
    L9:
        Callable<InputStream> r8 = this.copyFromInputStream;
        if (r8 == null) goto L31;
        r0 = Channels.newChannel((InputStream) ZeusTransformUtils.preCheckCast(r8.call(), InputStream.class, "com.obric.memorydata.plugin"));
        r1 = "newChannel(inputStream)";
    L27:
        e = move-exception;
        throw new IOException("inputStreamCallable exception on call", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    L31:
        throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
    }

    private final SupportSQLiteOpenHelper createFrameworkOpenHelper(File r5) {
        final int r1 = DBUtil.readVersion(r5);     // Catch: IOException -> L6
        FrameworkSQLiteOpenHelperFactory r2 = new FrameworkSQLiteOpenHelperFactory();
        SupportSQLiteOpenHelper.Configuration.Builder r4 = SupportSQLiteOpenHelper.Configuration.Companion.builder(this.context).name(r5.getAbsolutePath());
        final int r6 = RangesKt.coerceAtLeast(r1, 1);
        return r2.create(r4.callback((SupportSQLiteOpenHelper.Callback) ZeusTransformUtils.preCheckCast(new SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1(r1, r6), SupportSQLiteOpenHelper.Callback.class, "com.obric.memorydata.plugin")).build());
    L6:
        e = move-exception;
        throw new RuntimeException("Malformed database file, unable to read version.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final void dispatchOnOpenPrepackagedDatabase(File r5, boolean r6) {
        DatabaseConfiguration r0 = this.databaseConfiguration;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
        r0 = null;
    L6:
        if (r0.prepackagedDatabaseCallback != null) goto L8;
        return;
    L8:
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(createFrameworkOpenHelper(r5), Closeable.class, "com.obric.memorydata.plugin");
        SupportSQLiteOpenHelper r1 = (SupportSQLiteOpenHelper) ZeusTransformUtils.preCheckCast(r7, SupportSQLiteOpenHelper.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r6 == false) goto L12;
        SupportSQLiteDatabase r8 = r1.getWritableDatabase();     // Catch: Throwable -> L19
    L13:
        DatabaseConfiguration r4 = this.databaseConfiguration;     // Catch: Throwable -> L19
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");     // Catch: Throwable -> L19
        r4 = null;
    L16:
        RoomDatabase.PrepackagedDatabaseCallback r9 = r4.prepackagedDatabaseCallback;     // Catch: Throwable -> L19
        Intrinsics.checkNotNull(r9);     // Catch: Throwable -> L19
        r9.onOpenPrepackagedDatabase(r8);     // Catch: Throwable -> L19
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r7, null);
        return;
    L12:
        r8 = r1.getReadableDatabase();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    }

    private final void verifyDatabaseFile(boolean r11) {
        String r1 = getDatabaseName();
        if (r1 == null) goto L47;
        File r2 = this.context.getDatabasePath(r1);
        DatabaseConfiguration r3 = this.databaseConfiguration;
        DatabaseConfiguration r5 = null;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
        r3 = null;
    L7:
        ProcessLock r6 = new ProcessLock(r1, this.context.getFilesDir(), r3.multiInstanceInvalidation);
        ProcessLock.lock$default(r6, false, 1, null);     // Catch: Throwable -> L43
        if (r2.exists() == true) goto L52;
        Intrinsics.checkNotNullExpressionValue(r2, "databaseFile");     // Catch: IOException -> L14 Throwable -> L43
        copyDatabaseFile(r2, r11);     // Catch: IOException -> L14 Throwable -> L43
        r6.unlock();
        return;
    L14:
        e = move-exception;
        throw new RuntimeException("Unable to copy database file.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L43
    L52:
        Intrinsics.checkNotNullExpressionValue(r2, "databaseFile");     // Catch: IOException -> L39 Throwable -> L43
        int r4 = DBUtil.readVersion(r2);     // Catch: IOException -> L39 Throwable -> L43
    L19:
        if (r4 != this.databaseVersion) goto L22;
        r6.unlock();
        return;
    L22:
        DatabaseConfiguration r8 = this.databaseConfiguration;     // Catch: Throwable -> L43
        if (r8 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");     // Catch: Throwable -> L43
    L27:
        if (r5.isMigrationRequired(r4, this.databaseVersion) == false) goto L31;
        r6.unlock();
        return;
    L31:
        if (this.context.deleteDatabase(r1) == true) goto L50;
        Log.w(Room.LOG_TAG, "Failed to delete database file (" + r1 + ") for a copy destructive migration.");     // Catch: Throwable -> L43
    L37:
        r6.unlock();
        return;
    L50:
        copyDatabaseFile(r2, r11);     // Catch: IOException -> L34 Throwable -> L43
    L34:
        e = move-exception;
        Log.w(Room.LOG_TAG, "Unable to copy database file.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L43
        goto L37
    L25:
        r5 = r8;
    L39:
        e = move-exception;
        Log.w(Room.LOG_TAG, "Unable to read database version.", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L43
        r6.unlock();
        return;
    L43:
        th = move-exception;
        r6.unlock();
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

    public final void setDatabaseConfiguration(DatabaseConfiguration r2) {
        Intrinsics.checkNotNullParameter(r2, "databaseConfiguration");
        this.databaseConfiguration = r2;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r1) {
        getDelegate().setWriteAheadLoggingEnabled(r1);
    }
}
