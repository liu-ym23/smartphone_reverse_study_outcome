package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmSuppressWildcards;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class RoomDatabase {
    public static final Companion Companion = null;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean allowMainThreadQueries;
    private AutoCloser autoCloser;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    private Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs;
    private final Map<String, Object> backingFieldMap;
    private SupportSQLiteOpenHelper internalOpenHelper;
    private Executor internalQueryExecutor;
    private Executor internalTransactionExecutor;
    private final InvalidationTracker invalidationTracker;

    @JvmField
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    protected List<? extends Callback> mCallbacks;

    @JvmField
    protected volatile SupportSQLiteDatabase mDatabase;
    private final ReentrantReadWriteLock readWriteLock;
    private final ThreadLocal<Integer> suspendingTransactionId;
    private final Map<Class<?>, Object> typeConverters;
    private boolean writeAheadLoggingEnabled;

    public static class Builder<T extends RoomDatabase> {
        private boolean allowDestructiveMigrationOnDowngrade;
        private boolean allowMainThreadQueries;
        private TimeUnit autoCloseTimeUnit;
        private long autoCloseTimeout;
        private List<AutoMigrationSpec> autoMigrationSpecs;
        private final List<Callback> callbacks;
        private final Context context;
        private String copyFromAssetPath;
        private File copyFromFile;
        private Callable<InputStream> copyFromInputStream;
        private SupportSQLiteOpenHelper.Factory factory;
        private JournalMode journalMode;
        private final Class<T> klass;
        private final MigrationContainer migrationContainer;
        private Set<Integer> migrationStartAndEndVersions;
        private Set<Integer> migrationsNotRequiredFrom;
        private Intent multiInstanceInvalidationIntent;
        private final String name;
        private PrepackagedDatabaseCallback prepackagedDatabaseCallback;
        private QueryCallback queryCallback;
        private Executor queryCallbackExecutor;
        private Executor queryExecutor;
        private boolean requireMigration;
        private Executor transactionExecutor;
        private final List<Object> typeConverters;

        public Builder(Context r10, Class<T> r11, String r12) {
            Intrinsics.checkNotNullParameter(r10, "context");
            Intrinsics.checkNotNullParameter(r11, "klass");
            this.context = r10;
            this.klass = r11;
            this.name = r12;
            this.callbacks = new ArrayList();
            this.typeConverters = new ArrayList();
            this.autoMigrationSpecs = new ArrayList();
            this.journalMode = JournalMode.AUTOMATIC;
            this.requireMigration = true;
            this.autoCloseTimeout = -1;
            this.migrationContainer = new MigrationContainer();
            this.migrationsNotRequiredFrom = new LinkedHashSet();
        }

        public Builder<T> addAutoMigrationSpec(AutoMigrationSpec r10) {
            Intrinsics.checkNotNullParameter(r10, "autoMigrationSpec");
            this.autoMigrationSpecs.add(r10);
            return this;
        }

        public Builder<T> addCallback(Callback r10) {
            Intrinsics.checkNotNullParameter(r10, "callback");
            this.callbacks.add(r10);
            return this;
        }

        public Builder<T> addMigrations(Migration... r10) {
            Intrinsics.checkNotNullParameter(r10, "migrations");
            if (this.migrationStartAndEndVersions != null) goto L5;
            this.migrationStartAndEndVersions = new HashSet();
        L5:
            int r11 = 0;
            int r12 = r10.length;
        L6:
            if (r11 >= r12) goto L8;
            Migration r13 = r10[r11];
            Set<Integer> r14 = this.migrationStartAndEndVersions;
            Intrinsics.checkNotNull(r14);
            r14.add(Integer.valueOf(r13.startVersion));
            Set<Integer> r15 = this.migrationStartAndEndVersions;
            Intrinsics.checkNotNull(r15);
            r15.add(Integer.valueOf(r13.endVersion));
            r11 = r11 + 1;
            goto L6
        L8:
            this.migrationContainer.addMigrations((Migration[]) Arrays.copyOf(r10, r10.length));
            return this;
        }

        public Builder<T> addTypeConverter(Object r10) {
            Intrinsics.checkNotNullParameter(r10, "typeConverter");
            this.typeConverters.add(r10);
            return this;
        }

        public Builder<T> allowMainThreadQueries() {
            this.allowMainThreadQueries = true;
            return this;
        }

        public T build() {
            Executor r10 = this.queryExecutor;
            if (r10 == null) goto L5;
        L8:
            if (r10 != null) goto L10;
        L12:
            if (r10 != null) goto L14;
            Executor r11 = this.transactionExecutor;
        L7:
            this.queryExecutor = r11;
        L14:
            Set<Integer> r12 = this.migrationStartAndEndVersions;
            boolean r13 = true;
            if (r12 == null) goto L24;
            Intrinsics.checkNotNull(r12);
            Iterator<Integer> r14 = r12.iterator();
        L18:
            if (r14.hasNext() == false) goto L24;
            int r15 = r14.next().intValue();
            if ((!this.migrationsNotRequiredFrom.contains(Integer.valueOf(r15))) == true) goto L18;
            throw new IllegalArgumentException(("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + r15).toString());
        L24:
            SupportSQLiteOpenHelper.Factory r16 = this.factory;
            if (r16 != null) goto L28;
            r16 = new FrameworkSQLiteOpenHelperFactory();
        L28:
            if (r16 != null) goto L30;
            r16 = null;
        L75:
            if (r16 == null) goto L98;
            QueryCallback r17 = this.queryCallback;
            if (r17 == null) goto L86;
            Executor r18 = this.queryCallbackExecutor;
            if (r18 == null) goto L85;
            if (r17 == null) goto L83;
            SupportSQLiteOpenHelper.Factory r19 = new QueryInterceptorOpenHelperFactory(r16, r18, r17);
        L87:
            Context r20 = this.context;
            String r21 = this.name;
            MigrationContainer r22 = this.migrationContainer;
            List<Callback> r23 = this.callbacks;
            boolean r24 = this.allowMainThreadQueries;
            JournalMode r110 = this.journalMode.resolve$room_runtime_release(r20);
            Executor r111 = this.queryExecutor;
            if (r111 == null) goto L96;
            Executor r25 = this.transactionExecutor;
            if (r25 == null) goto L94;
            DatabaseConfiguration r26 = new DatabaseConfiguration(r20, r21, r19, r22, r23, r24, r110, r111, r25, this.multiInstanceInvalidationIntent, this.requireMigration, this.allowDestructiveMigrationOnDowngrade, this.migrationsNotRequiredFrom, this.copyFromAssetPath, this.copyFromFile, this.copyFromInputStream, this.prepackagedDatabaseCallback, this.typeConverters, this.autoMigrationSpecs);
            T r27 = (T) Room.getGeneratedImplementation(this.klass, "_Impl");
            r27.init(r26);
            return r27;
        L94:
            throw new IllegalArgumentException("Required value was null.".toString());
        L96:
            throw new IllegalArgumentException("Required value was null.".toString());
        L83:
            throw new IllegalArgumentException("Required value was null.".toString());
        L85:
            throw new IllegalArgumentException("Required value was null.".toString());
        L86:
            r19 = r16;
            goto L87
        L98:
            throw new IllegalArgumentException("Required value was null.".toString());
        L30:
            if (this.autoCloseTimeout > 0) goto L32;
        L44:
            String r28 = this.copyFromAssetPath;
            if (r28 != null) goto L51;
            if (this.copyFromFile != null) goto L51;
            if (this.copyFromInputStream == null) goto L75;
        L51:
            if (this.name == null) goto L73;
            if (r28 != null) goto L55;
            int r29 = 0;
        L56:
            File r30 = this.copyFromFile;
            if (r30 != null) goto L59;
            int r31 = 0;
        L60:
            Callable<InputStream> r32 = this.copyFromInputStream;
            if (r32 != null) goto L63;
            int r112 = 0;
        L65:
            if (((r29 + r31) + r112) == 1) goto L68;
            r13 = false;
        L68:
            if (r13 == false) goto L71;
            r16 = new SQLiteCopyOpenHelperFactory(r28, r30, r32, r16);
            goto L75
        L71:
            throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.".toString());
        L63:
            r112 = 1;
            goto L65
        L59:
            r31 = 1;
            goto L60
        L55:
            r29 = 1;
            goto L56
        L73:
            throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.".toString());
        L32:
            if (this.name == null) goto L43;
            long r33 = this.autoCloseTimeout;
            TimeUnit r34 = this.autoCloseTimeUnit;
            if (r34 == null) goto L41;
            Executor r35 = this.queryExecutor;
            if (r35 == null) goto L39;
            r16 = new AutoClosingRoomOpenHelperFactory(r16, new AutoCloser(r33, r34, r35));
            goto L44
        L39:
            throw new IllegalArgumentException("Required value was null.".toString());
        L41:
            throw new IllegalArgumentException("Required value was null.".toString());
        L43:
            throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.".toString());
        L10:
            if (this.transactionExecutor != null) goto L12;
            this.transactionExecutor = r10;
            goto L14
        L5:
            if (this.transactionExecutor != null) goto L8;
            r11 = ArchTaskExecutor.getIOThreadExecutor();
            this.transactionExecutor = r11;
            goto L7
        }

        public Builder<T> createFromAsset(String r10) {
            Intrinsics.checkNotNullParameter(r10, "databaseFilePath");
            this.copyFromAssetPath = r10;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromAsset(String r10, PrepackagedDatabaseCallback r11) {
            Intrinsics.checkNotNullParameter(r10, "databaseFilePath");
            Intrinsics.checkNotNullParameter(r11, "callback");
            this.prepackagedDatabaseCallback = r11;
            this.copyFromAssetPath = r10;
            return this;
        }

        public Builder<T> createFromFile(File r10) {
            Intrinsics.checkNotNullParameter(r10, "databaseFile");
            this.copyFromFile = r10;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "StreamFiles"})
        public Builder<T> createFromFile(File r10, PrepackagedDatabaseCallback r11) {
            Intrinsics.checkNotNullParameter(r10, "databaseFile");
            Intrinsics.checkNotNullParameter(r11, "callback");
            this.prepackagedDatabaseCallback = r11;
            this.copyFromFile = r10;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromInputStream(Callable<InputStream> r10) {
            Intrinsics.checkNotNullParameter(r10, "inputStreamCallable");
            this.copyFromInputStream = r10;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "LambdaLast"})
        public Builder<T> createFromInputStream(Callable<InputStream> r10, PrepackagedDatabaseCallback r11) {
            Intrinsics.checkNotNullParameter(r10, "inputStreamCallable");
            Intrinsics.checkNotNullParameter(r11, "callback");
            this.prepackagedDatabaseCallback = r11;
            this.copyFromInputStream = r10;
            return this;
        }

        public Builder<T> enableMultiInstanceInvalidation() {
            if (this.name == null) goto L5;
            Intent r10 = new Intent(this.context, MultiInstanceInvalidationService.class);
        L6:
            this.multiInstanceInvalidationIntent = r10;
            return this;
        L5:
            r10 = null;
            goto L6
        }

        public Builder<T> fallbackToDestructiveMigration() {
            this.requireMigration = false;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationFrom(int... r10) {
            Intrinsics.checkNotNullParameter(r10, "startVersions");
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            int r13 = r10[r12];
            this.migrationsNotRequiredFrom.add(Integer.valueOf(r13));
            r12 = r12 + 1;
            goto L3
        L5:
            return this;
        }

        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.requireMigration = true;
            this.allowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        public Builder<T> openHelperFactory(SupportSQLiteOpenHelper.Factory r10) {
            this.factory = r10;
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setAutoCloseTimeout(@IntRange(from = 0) long r10, TimeUnit r11) {
            Intrinsics.checkNotNullParameter(r11, "autoCloseTimeUnit");
            if (r10 < 0) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L10;
            this.autoCloseTimeout = r10;
            this.autoCloseTimeUnit = r11;
            return this;
        L10:
            throw new IllegalArgumentException("autoCloseTimeout must be >= 0".toString());
        L5:
            r12 = false;
            goto L6
        }

        public Builder<T> setJournalMode(JournalMode r10) {
            Intrinsics.checkNotNullParameter(r10, "journalMode");
            this.journalMode = r10;
            return this;
        }

        @ExperimentalRoomApi
        public Builder<T> setMultiInstanceInvalidationServiceIntent(Intent r10) {
            Intrinsics.checkNotNullParameter(r10, "invalidationServiceIntent");
            if (this.name != null) goto L6;
            r10 = null;
        L6:
            this.multiInstanceInvalidationIntent = r10;
            return this;
        }

        public Builder<T> setQueryCallback(QueryCallback r10, Executor r11) {
            Intrinsics.checkNotNullParameter(r10, "queryCallback");
            Intrinsics.checkNotNullParameter(r11, "executor");
            this.queryCallback = r10;
            this.queryCallbackExecutor = r11;
            return this;
        }

        public Builder<T> setQueryExecutor(Executor r10) {
            Intrinsics.checkNotNullParameter(r10, "executor");
            this.queryExecutor = r10;
            return this;
        }

        public Builder<T> setTransactionExecutor(Executor r10) {
            Intrinsics.checkNotNullParameter(r10, "executor");
            this.transactionExecutor = r10;
            return this;
        }
    }

    public static abstract class Callback {
        public Callback() {
        }

        public void onCreate(SupportSQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "db");
        }

        public void onDestructiveMigration(SupportSQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "db");
        }

        public void onOpen(SupportSQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "db");
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final enum JournalMode extends Enum<JournalMode> {
        private static final /* synthetic */ JournalMode[] $VALUES = null;
        public static final JournalMode AUTOMATIC = null;
        public static final JournalMode TRUNCATE = null;
        public static final JournalMode WRITE_AHEAD_LOGGING = null;

        private static final /* synthetic */ JournalMode[] $values() {
            return new JournalMode[]{AUTOMATIC, TRUNCATE, WRITE_AHEAD_LOGGING};
        }

        static {
            AUTOMATIC = new JournalMode("AUTOMATIC", 0);
            TRUNCATE = new JournalMode("TRUNCATE", 1);
            WRITE_AHEAD_LOGGING = new JournalMode("WRITE_AHEAD_LOGGING", 2);
            $VALUES = $values();
        }

        private JournalMode(String r10, int r11) {
            super(r10, r11);
        }

        private final boolean isLowRamDevice(ActivityManager r10) {
            if (Build.VERSION.SDK_INT >= 19) goto L7;
            return false;
        L7:
            return SupportSQLiteCompat.Api19Impl.isLowRamDevice(r10);
        }

        public static JournalMode valueOf(String r10) {
            return (JournalMode) Enum.valueOf(JournalMode.class, r10);
        }

        public static JournalMode[] values() {
            return (JournalMode[]) $VALUES.clone();
        }

        public final JournalMode resolve$room_runtime_release(Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            if (this == AUTOMATIC) goto L6;
            return this;
        L6:
            if (Build.VERSION.SDK_INT < 16) goto L12;
            Object r11 = r10.getSystemService("activity");
            Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.app.ActivityManager");
            if (isLowRamDevice((ActivityManager) r11) == true) goto L12;
            return WRITE_AHEAD_LOGGING;
        L12:
            return TRUNCATE;
        }
    }

    public static class MigrationContainer {
        private final Map<Integer, TreeMap<Integer, Migration>> migrations;

        public MigrationContainer() {
            this.migrations = new LinkedHashMap();
        }

        private final void addMigration(Migration r10) {
            int r11 = r10.startVersion;
            int r12 = r10.endVersion;
            Map<Integer, TreeMap<Integer, Migration>> r13 = this.migrations;
            Integer r14 = Integer.valueOf(r11);
            TreeMap<Integer, Migration> r15 = r13.get(r14);
            if (r15 != null) goto L5;
            r15 = new TreeMap();
            r13.put(r14, r15);
        L5:
            TreeMap<Integer, Migration> r16 = r15;
            if (r16.containsKey(Integer.valueOf(r12)) == false) goto L8;
            Log.w(Room.LOG_TAG, "Overriding migration " + r16.get(Integer.valueOf(r12)) + " with " + r10);
        L8:
            r16.put(Integer.valueOf(r12), r10);
        }

        private final List<Migration> findUpMigrationPath(List<Migration> r10, boolean r11, int r12, int r13) {
        L2:
            boolean r14 = true;
            if (r11 == false) goto L6;
            if (r12 < r13) goto L7;
        L8:
            boolean r15 = false;
        L9:
            if (r15 == false) goto L35;
            TreeMap<Integer, Migration> r16 = this.migrations.get(Integer.valueOf(r12));
            if (r16 == null) goto L12;
            if (r11 == false) goto L15;
            Set<Integer> r17 = r16.descendingKeySet();
        L16:
            Iterator<Integer> r18 = r17.iterator();
        L18:
            if (r18.hasNext() == false) goto L32;
            Integer r19 = r18.next();
            if (r11 == false) goto L25;
            int r20 = r12 + 1;
            Intrinsics.checkNotNullExpressionValue(r19, "targetVersion");
            int r21 = r19.intValue();
            if (r20 > r21) goto L29;
            if (r21 > r13) goto L29;
        L28:
            boolean r22 = true;
        L30:
            if (r22 == false) goto L18;
            Migration r110 = r16.get(r19);
            Intrinsics.checkNotNull(r110);
            r10.add(r110);
            r12 = r19.intValue();
        L33:
            if (r14 == true) goto L2;
            return null;
        L29:
            r22 = false;
            goto L30
        L25:
            Intrinsics.checkNotNullExpressionValue(r19, "targetVersion");
            int r23 = r19.intValue();
            if (r13 > r23) goto L29;
            if (r23 >= r12) goto L29;
        L32:
            r14 = false;
            goto L33
        L15:
            r17 = r16.keySet();
            goto L16
        L12:
            return null;
        L35:
            return r10;
        L7:
            r15 = true;
            goto L9
        L6:
            if (r12 <= r13) goto L8;
            goto L7
        }

        public void addMigrations(List<? extends Migration> r10) {
            Intrinsics.checkNotNullParameter(r10, "migrations");
            Iterator<T> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            addMigration((Migration) r11.next());
            goto L4
        }

        public void addMigrations(Migration... r10) {
            Intrinsics.checkNotNullParameter(r10, "migrations");
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            addMigration(r10[r12]);
            r12 = r12 + 1;
            goto L3
        }

        public final boolean contains(int r10, int r11) {
            Map<Integer, Map<Integer, Migration>> r12 = getMigrations();
            if (r12.containsKey(Integer.valueOf(r10)) == false) goto L9;
            Map<Integer, Migration> r13 = r12.get(Integer.valueOf(r10));
            if (r13 != null) goto L8;
            r13 = MapsKt.emptyMap();
        L8:
            return r13.containsKey(Integer.valueOf(r11));
        L9:
            return false;
        }

        public List<Migration> findMigrationPath(int r10, int r11) {
            if (r10 == r11) goto L4;
            if (r11 <= r10) goto L7;
            boolean r12 = true;
        L9:
            return findUpMigrationPath(new ArrayList(), r12, r10, r11);
        L7:
            r12 = false;
            goto L9
        L4:
            return CollectionsKt.emptyList();
        }

        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return this.migrations;
        }
    }

    public static abstract class PrepackagedDatabaseCallback {
        public PrepackagedDatabaseCallback() {
        }

        public void onOpenPrepackagedDatabase(SupportSQLiteDatabase r10) {
            Intrinsics.checkNotNullParameter(r10, "db");
        }
    }

    public interface QueryCallback {
        void onQuery(String r10, List<? extends Object> r11);
    }

    static {
        Companion = new Companion(null);
    }

    public RoomDatabase() {
        this.invalidationTracker = createInvalidationTracker();
        this.autoMigrationSpecs = new LinkedHashMap();
        this.readWriteLock = new ReentrantReadWriteLock();
        this.suspendingTransactionId = new ThreadLocal();
        Map<String, Object> r10 = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(r10, "synchronizedMap(mutableMapOf())");
        this.backingFieldMap = r10;
        this.typeConverters = new LinkedHashMap();
    }

    public static final /* synthetic */ void access$internalBeginTransaction(RoomDatabase r10) {
        r10.internalBeginTransaction();
    }

    public static final /* synthetic */ void access$internalEndTransaction(RoomDatabase r10) {
        r10.internalEndTransaction();
    }

    @Deprecated(message = "Will be hidden in a future release.")
    protected static /* synthetic */ void getMCallbacks$annotations() {
    }

    @Deprecated(message = "Will be hidden in the next release.")
    protected static /* synthetic */ void getMDatabase$annotations() {
    }

    private final void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase r10 = getOpenHelper().getWritableDatabase();
        getInvalidationTracker().syncTriggers$room_runtime_release(r10);
        if (Build.VERSION.SDK_INT >= 16) goto L5;
    L7:
        r10.beginTransaction();
        return;
    L5:
        if (r10.isWriteAheadLoggingEnabled() == false) goto L7;
        r10.beginTransactionNonExclusive();
    }

    private final void internalEndTransaction() {
        getOpenHelper().getWritableDatabase().endTransaction();
        if (inTransaction() == true) goto L6;
        getInvalidationTracker().refreshVersionsAsync();
        return;
    }

    public static /* synthetic */ void isOpen$annotations() {
    }

    public static /* synthetic */ Cursor query$default(RoomDatabase r10, SupportSQLiteQuery r11, CancellationSignal r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L7;
        r12 = null;
    L7:
        return r10.query(r11, r12);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: query");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> T unwrapOpenHelper(Class<T> r10, SupportSQLiteOpenHelper r11) {
        if (r10.isInstance(r11) == false) goto L6;
        return r11;
    L6:
        if ((r11 instanceof DelegatingOpenHelper) == true) goto L10;
        return null;
    L10:
        return (T) unwrapOpenHelper(r10, ((DelegatingOpenHelper) r11).getDelegate());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (this.allowMainThreadQueries == false) goto L6;
        return;
    L6:
        if ((!isMainThread$room_runtime_release()) == false) goto L9;
        return;
    L9:
        throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.".toString());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void assertNotSuspendingTransaction() {
        if (inTransaction() == false) goto L5;
    L8:
        boolean r10 = true;
    L9:
        if (r10 == false) goto L12;
        return;
    L12:
        throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.".toString());
    L5:
        if (this.suspendingTransactionId.get() == null) goto L8;
        r10 = false;
        goto L9
    }

    @Deprecated(message = "beginTransaction() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser r10 = this.autoCloser;
        if (r10 != null) goto L5;
        internalBeginTransaction();
        return;
    L5:
        r10.executeRefCountingFunction(new AnonymousClass1(this));
    }

    @WorkerThread
    public abstract void clearAllTables();

    public void close() {
        if (isOpen() == false) goto L10;
        ReentrantReadWriteLock.WriteLock r10 = this.readWriteLock.writeLock();
        Intrinsics.checkNotNullExpressionValue(r10, "readWriteLock.writeLock()");
        r10.lock();
        getInvalidationTracker().stopMultiInstanceInvalidation$room_runtime_release();     // Catch: Throwable -> L7
        getOpenHelper().close();     // Catch: Throwable -> L7
        r10.unlock();
        return;
    L7:
        th = move-exception;
        r10.unlock();
        throw th;
    }

    public SupportSQLiteStatement compileStatement(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sql");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return getOpenHelper().getWritableDatabase().compileStatement(r10);
    }

    protected abstract InvalidationTracker createInvalidationTracker();

    protected abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r10);

    @Deprecated(message = "endTransaction() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void endTransaction() {
        AutoCloser r10 = this.autoCloser;
        if (r10 != null) goto L5;
        internalEndTransaction();
        return;
    L5:
        r10.executeRefCountingFunction(new C03411(this));
    }

    protected final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> getAutoMigrationSpecs() {
        return this.autoMigrationSpecs;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @JvmSuppressWildcards
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r10) {
        Intrinsics.checkNotNullParameter(r10, "autoMigrationSpecs");
        return CollectionsKt.emptyList();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Map<String, Object> getBackingFieldMap() {
        return this.backingFieldMap;
    }

    public final Lock getCloseLock$room_runtime_release() {
        ReentrantReadWriteLock.ReadLock r10 = this.readWriteLock.readLock();
        Intrinsics.checkNotNullExpressionValue(r10, "readWriteLock.readLock()");
        return r10;
    }

    public InvalidationTracker getInvalidationTracker() {
        return this.invalidationTracker;
    }

    public SupportSQLiteOpenHelper getOpenHelper() {
        SupportSQLiteOpenHelper r10 = this.internalOpenHelper;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("internalOpenHelper");
        return null;
    L6:
        return r10;
    }

    public Executor getQueryExecutor() {
        Executor r10 = this.internalQueryExecutor;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("internalQueryExecutor");
        return null;
    L6:
        return r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return SetsKt.emptySet();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return MapsKt.emptyMap();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.suspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        Executor r10 = this.internalTransactionExecutor;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("internalTransactionExecutor");
        return null;
    L6:
        return r10;
    }

    public <T> T getTypeConverter(Class<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "klass");
        return (T) this.typeConverters.get(r10);
    }

    public boolean inTransaction() {
        return getOpenHelper().getWritableDatabase().inTransaction();
    }

    @CallSuper
    public void init(DatabaseConfiguration r12) {
        Intrinsics.checkNotNullParameter(r12, "configuration");
        this.internalOpenHelper = createOpenHelper(r12);
        Set<Class<? extends AutoMigrationSpec>> r10 = getRequiredAutoMigrationSpecs();
        BitSet r11 = new BitSet();
        Iterator<Class<? extends AutoMigrationSpec>> r13 = r10.iterator();
    L3:
        boolean r14 = true;
        int r15 = -1;
        if (r13.hasNext() == false) goto L20;
        Class<? extends AutoMigrationSpec> r16 = r13.next();
        int r17 = r12.autoMigrationSpecs.size() - 1;
        if (r17 < 0) goto L13;
    L7:
        int r18 = r17 - 1;
        if (r16.isAssignableFrom(r12.autoMigrationSpecs.get(r17).getClass()) == true) goto L9;
        if (r18 < 0) goto L13;
        r17 = r18;
        goto L7
    L9:
        r11.set(r17);
        r15 = r17;
    L13:
        if (r15 >= 0) goto L16;
        r14 = false;
    L16:
        if (r14 == false) goto L19;
        this.autoMigrationSpecs.put(r16, r12.autoMigrationSpecs.get(r15));
        goto L3
    L19:
        throw new IllegalArgumentException(("A required auto migration spec (" + r16.getCanonicalName() + ") is missing in the database configuration.").toString());
    L20:
        int r19 = r12.autoMigrationSpecs.size() - 1;
        if (r19 < 0) goto L29;
    L22:
        int r20 = r19 - 1;
        if (r11.get(r19) == false) goto L28;
        if (r20 < 0) goto L29;
        r19 = r20;
        goto L22
    L28:
        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.".toString());
    L29:
        Iterator<Migration> r21 = getAutoMigrations(this.autoMigrationSpecs).iterator();
    L31:
        if (r21.hasNext() == false) goto L35;
        Migration r22 = r21.next();
        if (r12.migrationContainer.contains(r22.startVersion, r22.endVersion) == true) goto L31;
        r12.migrationContainer.addMigrations(new Migration[]{r22});
        goto L31
    L35:
        SQLiteCopyOpenHelper r23 = (SQLiteCopyOpenHelper) unwrapOpenHelper(SQLiteCopyOpenHelper.class, getOpenHelper());
        if (r23 == null) goto L38;
        r23.setDatabaseConfiguration(r12);
    L38:
        AutoClosingRoomOpenHelper r24 = (AutoClosingRoomOpenHelper) unwrapOpenHelper(AutoClosingRoomOpenHelper.class, getOpenHelper());
        if (r24 == null) goto L42;
        this.autoCloser = r24.autoCloser;
        getInvalidationTracker().setAutoCloser$room_runtime_release(r24.autoCloser);
    L42:
        if (Build.VERSION.SDK_INT >= 16) goto L44;
        boolean r25 = false;
    L49:
        this.mCallbacks = r12.callbacks;
        this.internalQueryExecutor = r12.queryExecutor;
        this.internalTransactionExecutor = new TransactionExecutor(r12.transactionExecutor);
        this.allowMainThreadQueries = r12.allowMainThreadQueries;
        this.writeAheadLoggingEnabled = r25;
        if (r12.multiInstanceInvalidationServiceIntent != null) goto L52;
    L56:
        Map<Class<?>, List<Class<?>>> r26 = getRequiredTypeConverters();
        BitSet r27 = new BitSet();
        Iterator<Map.Entry<Class<?>, List<Class<?>>>> r28 = r26.entrySet().iterator();
    L58:
        if (r28.hasNext() == false) goto L78;
        Map.Entry<Class<?>, List<Class<?>>> r29 = r28.next();
        Class<?> r30 = r29.getKey();
        Iterator<Class<?>> r31 = r29.getValue().iterator();
    L61:
        if (r31.hasNext() == false) goto L58;
        Class<?> r32 = r31.next();
        int r33 = r12.typeConverters.size() - 1;
        if (r33 < 0) goto L70;
    L64:
        int r34 = r33 - 1;
        if (r32.isAssignableFrom(r12.typeConverters.get(r33).getClass()) == true) goto L66;
        if (r34 < 0) goto L70;
        r33 = r34;
        goto L64
    L66:
        r27.set(r33);
    L71:
        if (r33 < 0) goto L73;
        boolean r35 = true;
    L74:
        if (r35 == false) goto L77;
        this.typeConverters.put(r32, r12.typeConverters.get(r33));
        goto L61
    L77:
        throw new IllegalArgumentException(("A required type converter (" + r32 + ") for " + r30.getCanonicalName() + " is missing in the database configuration.").toString());
    L73:
        r35 = false;
    L70:
        r33 = -1;
        goto L71
    L78:
        int r110 = r12.typeConverters.size() - 1;
        if (r110 < 0) goto L87;
    L80:
        int r36 = r110 - 1;
        if (r27.get(r110) == false) goto L86;
        if (r36 < 0) goto L106;
        r110 = r36;
        goto L80
    L106:
        return;
    L86:
        throw new IllegalArgumentException("Unexpected type converter " + r12.typeConverters.get(r110) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
    L87:
        return;
    L52:
        if (r12.name == null) goto L55;
        getInvalidationTracker().startMultiInstanceInvalidation$room_runtime_release(r12.context, r12.name, r12.multiInstanceInvalidationServiceIntent);
        goto L56
    L55:
        throw new IllegalArgumentException("Required value was null.".toString());
    L44:
        if (r12.journalMode != JournalMode.WRITE_AHEAD_LOGGING) goto L46;
        r25 = true;
    L47:
        getOpenHelper().setWriteAheadLoggingEnabled(r25);
        goto L49
    L46:
        r25 = false;
        goto L47
    }

    protected void internalInitInvalidationTracker(SupportSQLiteDatabase r10) {
        Intrinsics.checkNotNullParameter(r10, "db");
        getInvalidationTracker().internalInit$room_runtime_release(r10);
    }

    public final boolean isMainThread$room_runtime_release() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOpen() {
        AutoCloser r10 = this.autoCloser;
        if (r10 == null) goto L6;
        boolean r11 = r10.isActive();
    L5:
        Boolean r12 = Boolean.valueOf(r11);
    L11:
        return Intrinsics.areEqual(r12, Boolean.TRUE);
    L6:
        SupportSQLiteDatabase r13 = this.mDatabase;
        if (r13 == null) goto L9;
        r11 = r13.isOpen();
        goto L5
    L9:
        r12 = null;
        goto L11
    }

    @JvmOverloads
    public final Cursor query(SupportSQLiteQuery r10) {
        Intrinsics.checkNotNullParameter(r10, "query");
        return query$default(this, r10, null, 2, null);
    }

    @JvmOverloads
    public Cursor query(SupportSQLiteQuery r10, CancellationSignal r11) {
        Intrinsics.checkNotNullParameter(r10, "query");
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (r11 == null) goto L8;
        if (Build.VERSION.SDK_INT < 16) goto L8;
        return getOpenHelper().getWritableDatabase().query(r10, r11);
    L8:
        return getOpenHelper().getWritableDatabase().query(r10);
    }

    public Cursor query(String r10, Object[] r11) {
        Intrinsics.checkNotNullParameter(r10, "query");
        return getOpenHelper().getWritableDatabase().query(new SimpleSQLiteQuery(r10, r11));
    }

    public <V> V runInTransaction(Callable<V> r10) {
        Intrinsics.checkNotNullParameter(r10, "body");
        beginTransaction();
        V r11 = r10.call();     // Catch: Throwable -> L6
        setTransactionSuccessful();     // Catch: Throwable -> L6
        endTransaction();
        return r11;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    }

    public void runInTransaction(Runnable r10) {
        Intrinsics.checkNotNullParameter(r10, "body");
        beginTransaction();
        r10.run();     // Catch: Throwable -> L6
        setTransactionSuccessful();     // Catch: Throwable -> L6
        endTransaction();
        return;
    L6:
        th = move-exception;
        endTransaction();
        throw th;
    }

    protected final void setAutoMigrationSpecs(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.autoMigrationSpecs = r10;
    }

    @Deprecated(message = "setTransactionSuccessful() is deprecated", replaceWith = @ReplaceWith(expression = "runInTransaction(Runnable)", imports = {}))
    public void setTransactionSuccessful() {
        getOpenHelper().getWritableDatabase().setTransactionSuccessful();
    }
}
