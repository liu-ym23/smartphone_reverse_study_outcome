package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class DatabaseConfiguration {

    @JvmField
    public final boolean allowDestructiveMigrationOnDowngrade;

    @JvmField
    public final boolean allowMainThreadQueries;

    @JvmField
    public final List<AutoMigrationSpec> autoMigrationSpecs;

    @JvmField
    public final List<RoomDatabase.Callback> callbacks;

    @JvmField
    public final Context context;

    @JvmField
    public final String copyFromAssetPath;

    @JvmField
    public final File copyFromFile;

    @JvmField
    public final Callable<InputStream> copyFromInputStream;

    @JvmField
    public final RoomDatabase.JournalMode journalMode;

    @JvmField
    public final RoomDatabase.MigrationContainer migrationContainer;
    private final Set<Integer> migrationNotRequiredFrom;

    @JvmField
    public final boolean multiInstanceInvalidation;

    @JvmField
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final Intent multiInstanceInvalidationServiceIntent;

    @JvmField
    public final String name;

    @JvmField
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;

    @JvmField
    public final Executor queryExecutor;

    @JvmField
    public final boolean requireMigration;

    @JvmField
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    @JvmField
    public final Executor transactionExecutor;

    @JvmField
    public final List<Object> typeConverters;

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context r12, String r13, SupportSQLiteOpenHelper.Factory r14, RoomDatabase.MigrationContainer r15, List<? extends RoomDatabase.Callback> r16, boolean r17, RoomDatabase.JournalMode r18, Executor r19, Executor r20, Intent r21, boolean r22, boolean r23, Set<Integer> r24, String r25, File r26, Callable<InputStream> r27, RoomDatabase.PrepackagedDatabaseCallback r28, List<? extends Object> r29, List<? extends AutoMigrationSpec> r30) {
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r14, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r15, "migrationContainer");
        Intrinsics.checkNotNullParameter(r18, "journalMode");
        Intrinsics.checkNotNullParameter(r19, "queryExecutor");
        Intrinsics.checkNotNullParameter(r20, "transactionExecutor");
        Intrinsics.checkNotNullParameter(r29, "typeConverters");
        Intrinsics.checkNotNullParameter(r30, "autoMigrationSpecs");
        this.context = r12;
        this.name = r13;
        this.sqliteOpenHelperFactory = r14;
        this.migrationContainer = r15;
        this.callbacks = r16;
        this.allowMainThreadQueries = r17;
        this.journalMode = r18;
        this.queryExecutor = r19;
        this.transactionExecutor = r20;
        this.multiInstanceInvalidationServiceIntent = r21;
        this.requireMigration = r22;
        this.allowDestructiveMigrationOnDowngrade = r23;
        this.migrationNotRequiredFrom = r24;
        this.copyFromAssetPath = r25;
        this.copyFromFile = r26;
        this.copyFromInputStream = r27;
        this.prepackagedDatabaseCallback = r28;
        this.typeConverters = r29;
        this.autoMigrationSpecs = r30;
        if (r21 == null) goto L5;
        boolean r10 = true;
    L6:
        this.multiInstanceInvalidation = r10;
        return;
    L5:
        r10 = false;
        goto L6
    }

    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context r21, String r22, SupportSQLiteOpenHelper.Factory r23, RoomDatabase.MigrationContainer r24, List<? extends RoomDatabase.Callback> r25, boolean r26, RoomDatabase.JournalMode r27, Executor r28, Executor r29, boolean r30, boolean r31, boolean r32, Set<Integer> r33) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r23, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r24, "migrationContainer");
        Intrinsics.checkNotNullParameter(r27, "journalMode");
        Intrinsics.checkNotNullParameter(r28, "queryExecutor");
        Intrinsics.checkNotNullParameter(r29, "transactionExecutor");
        if (r30 == false) goto L5;
        Intent r10 = new Intent(r21, MultiInstanceInvalidationService.class);
    L6:
        this(r21, r22, r23, r24, r25, r26, r27, r28, r29, r10, r31, r32, r33, null, null, null, null, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context r21, String r22, SupportSQLiteOpenHelper.Factory r23, RoomDatabase.MigrationContainer r24, List<? extends RoomDatabase.Callback> r25, boolean r26, RoomDatabase.JournalMode r27, Executor r28, Executor r29, boolean r30, boolean r31, boolean r32, Set<Integer> r33, String r34, File r35) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r23, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r24, "migrationContainer");
        Intrinsics.checkNotNullParameter(r27, "journalMode");
        Intrinsics.checkNotNullParameter(r28, "queryExecutor");
        Intrinsics.checkNotNullParameter(r29, "transactionExecutor");
        if (r30 == false) goto L5;
        Intent r10 = new Intent(r21, MultiInstanceInvalidationService.class);
    L6:
        this(r21, r22, r23, r24, r25, r26, r27, r28, r29, r10, r31, r32, r33, r34, r35, null, null, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context r21, String r22, SupportSQLiteOpenHelper.Factory r23, RoomDatabase.MigrationContainer r24, List<? extends RoomDatabase.Callback> r25, boolean r26, RoomDatabase.JournalMode r27, Executor r28, Executor r29, boolean r30, boolean r31, boolean r32, Set<Integer> r33, String r34, File r35, Callable<InputStream> r36) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r23, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r24, "migrationContainer");
        Intrinsics.checkNotNullParameter(r27, "journalMode");
        Intrinsics.checkNotNullParameter(r28, "queryExecutor");
        Intrinsics.checkNotNullParameter(r29, "transactionExecutor");
        if (r30 == false) goto L5;
        Intent r10 = new Intent(r21, MultiInstanceInvalidationService.class);
    L6:
        this(r21, r22, r23, r24, r25, r26, r27, r28, r29, r10, r31, r32, r33, r34, r35, r36, null, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context r21, String r22, SupportSQLiteOpenHelper.Factory r23, RoomDatabase.MigrationContainer r24, List<? extends RoomDatabase.Callback> r25, boolean r26, RoomDatabase.JournalMode r27, Executor r28, Executor r29, boolean r30, boolean r31, boolean r32, Set<Integer> r33, String r34, File r35, Callable<InputStream> r36, RoomDatabase.PrepackagedDatabaseCallback r37) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r23, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r24, "migrationContainer");
        Intrinsics.checkNotNullParameter(r27, "journalMode");
        Intrinsics.checkNotNullParameter(r28, "queryExecutor");
        Intrinsics.checkNotNullParameter(r29, "transactionExecutor");
        if (r30 == false) goto L5;
        Intent r10 = new Intent(r21, MultiInstanceInvalidationService.class);
    L6:
        this(r21, r22, r23, r24, r25, r26, r27, r28, r29, r10, r31, r32, r33, r34, r35, r36, r37, CollectionsKt.emptyList(), CollectionsKt.emptyList());
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context r21, String r22, SupportSQLiteOpenHelper.Factory r23, RoomDatabase.MigrationContainer r24, List<? extends RoomDatabase.Callback> r25, boolean r26, RoomDatabase.JournalMode r27, Executor r28, Executor r29, boolean r30, boolean r31, boolean r32, Set<Integer> r33, String r34, File r35, Callable<InputStream> r36, RoomDatabase.PrepackagedDatabaseCallback r37, List<? extends Object> r38) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r23, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r24, "migrationContainer");
        Intrinsics.checkNotNullParameter(r27, "journalMode");
        Intrinsics.checkNotNullParameter(r28, "queryExecutor");
        Intrinsics.checkNotNullParameter(r29, "transactionExecutor");
        Intrinsics.checkNotNullParameter(r38, "typeConverters");
        if (r30 == false) goto L5;
        Intent r10 = new Intent(r21, MultiInstanceInvalidationService.class);
    L6:
        this(r21, r22, r23, r24, r25, r26, r27, r28, r29, r10, r31, r32, r33, r34, r35, r36, r37, r38, CollectionsKt.emptyList());
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context r21, String r22, SupportSQLiteOpenHelper.Factory r23, RoomDatabase.MigrationContainer r24, List<? extends RoomDatabase.Callback> r25, boolean r26, RoomDatabase.JournalMode r27, Executor r28, Executor r29, boolean r30, boolean r31, boolean r32, Set<Integer> r33, String r34, File r35, Callable<InputStream> r36, RoomDatabase.PrepackagedDatabaseCallback r37, List<? extends Object> r38, List<? extends AutoMigrationSpec> r39) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r23, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r24, "migrationContainer");
        Intrinsics.checkNotNullParameter(r27, "journalMode");
        Intrinsics.checkNotNullParameter(r28, "queryExecutor");
        Intrinsics.checkNotNullParameter(r29, "transactionExecutor");
        Intrinsics.checkNotNullParameter(r38, "typeConverters");
        Intrinsics.checkNotNullParameter(r39, "autoMigrationSpecs");
        if (r30 == false) goto L5;
        Intent r10 = new Intent(r21, MultiInstanceInvalidationService.class);
    L6:
        this(r21, r22, r23, r24, r25, r26, r27, r28, r29, r10, r31, r32, r33, r34, r35, r36, null, r38, r39);
        return;
    L5:
        r10 = null;
        goto L6
    }

    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(Context r21, String r22, SupportSQLiteOpenHelper.Factory r23, RoomDatabase.MigrationContainer r24, List<? extends RoomDatabase.Callback> r25, boolean r26, RoomDatabase.JournalMode r27, Executor r28, boolean r29, Set<Integer> r30) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r23, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(r24, "migrationContainer");
        Intrinsics.checkNotNullParameter(r27, "journalMode");
        Intrinsics.checkNotNullParameter(r28, "queryExecutor");
        this(r21, r22, r23, r24, r25, r26, r27, r28, r28, null, r29, false, r30, null, null, null, null, CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public boolean isMigrationRequired(int r10, int r11) {
        if (r10 <= r11) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L11;
        if (this.allowDestructiveMigrationOnDowngrade == false) goto L11;
        return false;
    L11:
        if (this.requireMigration == false) goto L18;
        Set<Integer> r13 = this.migrationNotRequiredFrom;
        if (r13 != null) goto L15;
        return true;
    L15:
        if (r13.contains(Integer.valueOf(r10)) == true) goto L18;
        return true;
    L18:
        return false;
    L5:
        r12 = false;
        goto L6
    }

    @Deprecated(message = "Use [isMigrationRequired(int, int)] which takes\n      [allowDestructiveMigrationOnDowngrade] into account.", replaceWith = @ReplaceWith(expression = "isMigrationRequired(version, version + 1)", imports = {}))
    public boolean isMigrationRequiredFrom(int r10) {
        return isMigrationRequired(r10, r10 + 1);
    }
}
