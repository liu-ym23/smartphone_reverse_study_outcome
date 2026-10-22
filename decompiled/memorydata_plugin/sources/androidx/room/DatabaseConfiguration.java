package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001Bi\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¢\u0006\u0002\u0010\u0017B\u0081\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¢\u0006\u0002\u0010\u001bB\u0095\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\u001fB¥\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!¢\u0006\u0002\u0010#B¯\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u0012\b\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010&B½\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\u0010(BË\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000b¢\u0006\u0002\u0010+BÍ\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\b\u0010,\u001a\u0004\u0018\u00010-\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000b¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u0016H\u0016J\u0010\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u0016H\u0017R\u0010\u0010\u001a\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u0004\u0018\u00010-8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Landroidx/room/DatabaseConfiguration;", "", "context", "Landroid/content/Context;", ActivityLifecycle.NAME, "", "sqliteOpenHelperFactory", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "migrationContainer", "Landroidx/room/RoomDatabase$MigrationContainer;", "callbacks", "", "Landroidx/room/RoomDatabase$Callback;", "allowMainThreadQueries", "", "journalMode", "Landroidx/room/RoomDatabase$JournalMode;", "queryExecutor", "Ljava/util/concurrent/Executor;", "requireMigration", "migrationNotRequiredFrom", "", "", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;ZLjava/util/Set;)V", "transactionExecutor", "multiInstanceInvalidation", "allowDestructiveMigrationOnDowngrade", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;)V", "copyFromAssetPath", "copyFromFile", "Ljava/io/File;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;)V", "copyFromInputStream", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;)V", "prepackagedDatabaseCallback", "Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;)V", "typeConverters", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;Ljava/util/List;)V", "autoMigrationSpecs", "Landroidx/room/migration/AutoMigrationSpec;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;Ljava/util/List;Ljava/util/List;)V", "multiInstanceInvalidationServiceIntent", "Landroid/content/Intent;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroid/content/Intent;ZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;Ljava/util/List;Ljava/util/List;)V", "isMigrationRequired", "fromVersion", "toVersion", "isMigrationRequiredFrom", "version", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List<AutoMigrationSpec> autoMigrationSpecs;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    public final RoomDatabase.MigrationContainer migrationContainer;
    private final Set<Integer> migrationNotRequiredFrom;
    public final boolean multiInstanceInvalidation;
    public final Intent multiInstanceInvalidationServiceIntent;
    public final String name;
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;
    public final List<Object> typeConverters;

    public DatabaseConfiguration(Context r16, String r17, SupportSQLiteOpenHelper.Factory r18, RoomDatabase.MigrationContainer r19, List<? extends RoomDatabase.Callback> r20, boolean r21, RoomDatabase.JournalMode r22, Executor r23, Executor r24, Intent r25, boolean r26, boolean r27, Set<Integer> r28, String r29, File r30, Callable<InputStream> r31, RoomDatabase.PrepackagedDatabaseCallback r32, List<? extends Object> r33, List<? extends AutoMigrationSpec> r34) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r16, Context.class, "com.obric.memorydata.plugin");
        SupportSQLiteOpenHelper.Factory r6 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.wrapperContextForParams(r18, SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
        List<RoomDatabase.Callback> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.memorydata.plugin");
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r23, Executor.class, "com.obric.memorydata.plugin");
        Executor r9 = (Executor) ZeusTransformUtils.wrapperContextForParams(r24, Executor.class, "com.obric.memorydata.plugin");
        Set<Integer> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r28, Set.class, "com.obric.memorydata.plugin");
        Callable<InputStream> r11 = (Callable) ZeusTransformUtils.wrapperContextForParams(r31, Callable.class, "com.obric.memorydata.plugin");
        List<Object> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.memorydata.plugin");
        List<AutoMigrationSpec> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r6, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r19, "migrationContainer");
        Intrinsics.checkNotNullParameter(r22, "journalMode");
        Intrinsics.checkNotNullParameter(r8, "queryExecutor");
        Intrinsics.checkNotNullParameter(r9, "transactionExecutor");
        Intrinsics.checkNotNullParameter(r12, "typeConverters");
        Intrinsics.checkNotNullParameter(r13, "autoMigrationSpecs");
        this.context = ZeusTransformUtils.wrapperContext(r4, "com.obric.memorydata.plugin");
        this.name = r17;
        this.sqliteOpenHelperFactory = r6;
        this.migrationContainer = r19;
        this.callbacks = r7;
        this.allowMainThreadQueries = r21;
        this.journalMode = r22;
        this.queryExecutor = r8;
        this.transactionExecutor = r9;
        this.multiInstanceInvalidationServiceIntent = r25;
        this.requireMigration = r26;
        this.allowDestructiveMigrationOnDowngrade = r27;
        this.migrationNotRequiredFrom = r10;
        this.copyFromAssetPath = r29;
        this.copyFromFile = r30;
        this.copyFromInputStream = r11;
        this.prepackagedDatabaseCallback = r32;
        this.typeConverters = r12;
        this.autoMigrationSpecs = r13;
        if (r25 == null) goto L5;
        boolean r1 = true;
    L6:
        this.multiInstanceInvalidation = r1;
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    public DatabaseConfiguration(Context r23, String r24, SupportSQLiteOpenHelper.Factory r25, RoomDatabase.MigrationContainer r26, List<? extends RoomDatabase.Callback> r27, boolean r28, RoomDatabase.JournalMode r29, Executor r30, Executor r31, boolean r32, boolean r33, boolean r34, Set<Integer> r35) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
        SupportSQLiteOpenHelper.Factory r5 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.wrapperContextForParams(r25, SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r30, Executor.class, "com.obric.memorydata.plugin");
        Executor r11 = (Executor) ZeusTransformUtils.wrapperContextForParams(r31, Executor.class, "com.obric.memorydata.plugin");
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r35, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r26, "migrationContainer");
        Intrinsics.checkNotNullParameter(r29, "journalMode");
        Intrinsics.checkNotNullParameter(r10, "queryExecutor");
        Intrinsics.checkNotNullParameter(r11, "transactionExecutor");
        if (r32 == false) goto L5;
        Intent r0 = new Intent(r3, MultiInstanceInvalidationService.class);
    L6:
        this(r3, r24, r5, r26, r7, r28, r29, r10, r11, r0, r33, r34, r15, null, null, null, null, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    public DatabaseConfiguration(Context r23, String r24, SupportSQLiteOpenHelper.Factory r25, RoomDatabase.MigrationContainer r26, List<? extends RoomDatabase.Callback> r27, boolean r28, RoomDatabase.JournalMode r29, Executor r30, Executor r31, boolean r32, boolean r33, boolean r34, Set<Integer> r35, String r36, File r37) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
        SupportSQLiteOpenHelper.Factory r5 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.wrapperContextForParams(r25, SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r30, Executor.class, "com.obric.memorydata.plugin");
        Executor r11 = (Executor) ZeusTransformUtils.wrapperContextForParams(r31, Executor.class, "com.obric.memorydata.plugin");
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r35, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r26, "migrationContainer");
        Intrinsics.checkNotNullParameter(r29, "journalMode");
        Intrinsics.checkNotNullParameter(r10, "queryExecutor");
        Intrinsics.checkNotNullParameter(r11, "transactionExecutor");
        if (r32 == false) goto L5;
        Intent r0 = new Intent(r3, MultiInstanceInvalidationService.class);
    L6:
        this(r3, r24, r5, r26, r7, r28, r29, r10, r11, r0, r33, r34, r15, r36, r37, null, null, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    public DatabaseConfiguration(Context r23, String r24, SupportSQLiteOpenHelper.Factory r25, RoomDatabase.MigrationContainer r26, List<? extends RoomDatabase.Callback> r27, boolean r28, RoomDatabase.JournalMode r29, Executor r30, Executor r31, boolean r32, boolean r33, boolean r34, Set<Integer> r35, String r36, File r37, Callable<InputStream> r38) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
        SupportSQLiteOpenHelper.Factory r5 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.wrapperContextForParams(r25, SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r30, Executor.class, "com.obric.memorydata.plugin");
        Executor r11 = (Executor) ZeusTransformUtils.wrapperContextForParams(r31, Executor.class, "com.obric.memorydata.plugin");
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r35, Set.class, "com.obric.memorydata.plugin");
        Callable r18 = (Callable) ZeusTransformUtils.wrapperContextForParams(r38, Callable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r26, "migrationContainer");
        Intrinsics.checkNotNullParameter(r29, "journalMode");
        Intrinsics.checkNotNullParameter(r10, "queryExecutor");
        Intrinsics.checkNotNullParameter(r11, "transactionExecutor");
        if (r32 == false) goto L5;
        Intent r0 = new Intent(r3, MultiInstanceInvalidationService.class);
    L6:
        this(r3, r24, r5, r26, r7, r28, r29, r10, r11, r0, r33, r34, r15, r36, r37, r18, null, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    public DatabaseConfiguration(Context r23, String r24, SupportSQLiteOpenHelper.Factory r25, RoomDatabase.MigrationContainer r26, List<? extends RoomDatabase.Callback> r27, boolean r28, RoomDatabase.JournalMode r29, Executor r30, Executor r31, boolean r32, boolean r33, boolean r34, Set<Integer> r35, String r36, File r37, Callable<InputStream> r38, RoomDatabase.PrepackagedDatabaseCallback r39) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
        SupportSQLiteOpenHelper.Factory r5 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.wrapperContextForParams(r25, SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r30, Executor.class, "com.obric.memorydata.plugin");
        Executor r11 = (Executor) ZeusTransformUtils.wrapperContextForParams(r31, Executor.class, "com.obric.memorydata.plugin");
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r35, Set.class, "com.obric.memorydata.plugin");
        Callable r18 = (Callable) ZeusTransformUtils.wrapperContextForParams(r38, Callable.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r26, "migrationContainer");
        Intrinsics.checkNotNullParameter(r29, "journalMode");
        Intrinsics.checkNotNullParameter(r10, "queryExecutor");
        Intrinsics.checkNotNullParameter(r11, "transactionExecutor");
        if (r32 == false) goto L5;
        Intent r0 = new Intent(r3, MultiInstanceInvalidationService.class);
    L6:
        this(r3, r24, r5, r26, r7, r28, r29, r10, r11, r0, r33, r34, r15, r36, r37, r18, r39, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    public DatabaseConfiguration(Context r23, String r24, SupportSQLiteOpenHelper.Factory r25, RoomDatabase.MigrationContainer r26, List<? extends RoomDatabase.Callback> r27, boolean r28, RoomDatabase.JournalMode r29, Executor r30, Executor r31, boolean r32, boolean r33, boolean r34, Set<Integer> r35, String r36, File r37, Callable<InputStream> r38, RoomDatabase.PrepackagedDatabaseCallback r39, List<? extends Object> r40) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
        SupportSQLiteOpenHelper.Factory r5 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.wrapperContextForParams(r25, SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r30, Executor.class, "com.obric.memorydata.plugin");
        Executor r11 = (Executor) ZeusTransformUtils.wrapperContextForParams(r31, Executor.class, "com.obric.memorydata.plugin");
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r35, Set.class, "com.obric.memorydata.plugin");
        Callable r18 = (Callable) ZeusTransformUtils.wrapperContextForParams(r38, Callable.class, "com.obric.memorydata.plugin");
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r40, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r26, "migrationContainer");
        Intrinsics.checkNotNullParameter(r29, "journalMode");
        Intrinsics.checkNotNullParameter(r10, "queryExecutor");
        Intrinsics.checkNotNullParameter(r11, "transactionExecutor");
        Intrinsics.checkNotNullParameter(r0, "typeConverters");
        if (r32 == false) goto L5;
        Intent r1 = new Intent(r3, MultiInstanceInvalidationService.class);
    L6:
        this(r3, r24, r5, r26, r7, r28, r29, r10, r11, r1, r33, r34, r15, r36, r37, r18, r39, r0, CollectionsKt.emptyList());
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    public DatabaseConfiguration(Context r23, String r24, SupportSQLiteOpenHelper.Factory r25, RoomDatabase.MigrationContainer r26, List<? extends RoomDatabase.Callback> r27, boolean r28, RoomDatabase.JournalMode r29, Executor r30, Executor r31, boolean r32, boolean r33, boolean r34, Set<Integer> r35, String r36, File r37, Callable<InputStream> r38, RoomDatabase.PrepackagedDatabaseCallback r39, List<? extends Object> r40, List<? extends AutoMigrationSpec> r41) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
        SupportSQLiteOpenHelper.Factory r5 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.wrapperContextForParams(r25, SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        Executor r10 = (Executor) ZeusTransformUtils.wrapperContextForParams(r30, Executor.class, "com.obric.memorydata.plugin");
        Executor r11 = (Executor) ZeusTransformUtils.wrapperContextForParams(r31, Executor.class, "com.obric.memorydata.plugin");
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r35, Set.class, "com.obric.memorydata.plugin");
        Callable r18 = (Callable) ZeusTransformUtils.wrapperContextForParams(r38, Callable.class, "com.obric.memorydata.plugin");
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r40, List.class, "com.obric.memorydata.plugin");
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r41, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r26, "migrationContainer");
        Intrinsics.checkNotNullParameter(r29, "journalMode");
        Intrinsics.checkNotNullParameter(r10, "queryExecutor");
        Intrinsics.checkNotNullParameter(r11, "transactionExecutor");
        Intrinsics.checkNotNullParameter(r0, "typeConverters");
        Intrinsics.checkNotNullParameter(r1, "autoMigrationSpecs");
        if (r32 == false) goto L5;
        Intent r2 = new Intent(r3, MultiInstanceInvalidationService.class);
    L6:
        this(r3, r24, r5, r26, r7, r28, r29, r10, r11, r2, r33, r34, r15, r36, r37, r18, null, r0, r1);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    public DatabaseConfiguration(Context r21, String r22, SupportSQLiteOpenHelper.Factory r23, RoomDatabase.MigrationContainer r24, List<? extends RoomDatabase.Callback> r25, boolean r26, RoomDatabase.JournalMode r27, Executor r28, boolean r29, Set<Integer> r30) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r21, Context.class, "com.obric.memorydata.plugin");
        SupportSQLiteOpenHelper.Factory r14 = (SupportSQLiteOpenHelper.Factory) ZeusTransformUtils.wrapperContextForParams(r23, SupportSQLiteOpenHelper.Factory.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        Executor r15 = (Executor) ZeusTransformUtils.wrapperContextForParams(r28, Executor.class, "com.obric.memorydata.plugin");
        Set r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r30, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r14, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r24, "migrationContainer");
        Intrinsics.checkNotNullParameter(r27, "journalMode");
        Intrinsics.checkNotNullParameter(r15, "queryExecutor");
        this(r12, r22, r14, r24, r5, r26, r27, r15, r15, null, r29, false, r13, null, null, null, null, CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public boolean isMigrationRequired(int r3, int r4) {
        if (r3 <= r4) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L11;
        if (this.allowDestructiveMigrationOnDowngrade == false) goto L11;
        return false;
    L11:
        if (this.requireMigration == false) goto L18;
        Set<Integer> r2 = this.migrationNotRequiredFrom;
        if (r2 != null) goto L15;
        return true;
    L15:
        if (r2.contains(Integer.valueOf(r3)) == true) goto L18;
        return true;
    L18:
        return false;
    L5:
        r5 = false;
        goto L6
    }

    @Deprecated(message = "Use [isMigrationRequired(int, int)] which takes\n      [allowDestructiveMigrationOnDowngrade] into account.", replaceWith = @ReplaceWith(expression = "isMigrationRequired(version, version + 1)", imports = {}))
    public boolean isMigrationRequiredFrom(int r2) {
        return isMigrationRequired(r2, r2 + 1);
    }
}
